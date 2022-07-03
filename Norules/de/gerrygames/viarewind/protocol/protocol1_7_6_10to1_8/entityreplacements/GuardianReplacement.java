package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements;

import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;

public class GuardianReplacement implements EntityReplacement
{
    private /* synthetic */ double locZ;
    private /* synthetic */ UserConnection user;
    private /* synthetic */ double locY;
    private /* synthetic */ float pitch;
    private /* synthetic */ List<Metadata> datawatcher;
    private /* synthetic */ double locX;
    private /* synthetic */ int entityId;
    private /* synthetic */ float yaw;
    private /* synthetic */ float headYaw;
    
    @Override
    public void setLocation(final double lllIllI, final double lllIIIl, final double lllIIII) {
        this.locX = lllIllI;
        this.locY = lllIIIl;
        this.locZ = lllIIII;
        this.updateLocation();
    }
    
    public void updateLocation() {
        final PacketWrapper lIIIlIl = PacketWrapper.create(24, null, this.user);
        lIIIlIl.write(Type.INT, this.entityId);
        lIIIlIl.write(Type.INT, (int)(this.locX * 32.0));
        lIIIlIl.write(Type.INT, (int)(this.locY * 32.0));
        lIIIlIl.write(Type.INT, (int)(this.locZ * 32.0));
        lIIIlIl.write(Type.BYTE, (byte)(this.yaw / 360.0f * 256.0f));
        lIIIlIl.write(Type.BYTE, (byte)(this.pitch / 360.0f * 256.0f));
        final PacketWrapper lIIIlII = PacketWrapper.create(25, null, this.user);
        lIIIlII.write(Type.INT, this.entityId);
        lIIIlII.write(Type.BYTE, (byte)(this.headYaw / 360.0f * 256.0f));
        PacketUtil.sendPacket(lIIIlIl, Protocol1_7_6_10TO1_8.class, true, true);
        PacketUtil.sendPacket(lIIIlII, Protocol1_7_6_10TO1_8.class, true, true);
    }
    
    public void updateMetadata() {
        final PacketWrapper lllIIl = PacketWrapper.create(28, null, this.user);
        lllIIl.write(Type.INT, this.entityId);
        final List<Metadata> lllIII = new ArrayList<Metadata>();
        for (final Metadata lllIll : this.datawatcher) {
            if (lllIll.id() != 16) {
                if (lllIll.id() == 17) {
                    continue;
                }
                lllIII.add(new Metadata(lllIll.id(), lllIll.metaType(), lllIll.getValue()));
            }
        }
        MetadataRewriter.transform(Entity1_10Types.EntityType.SQUID, lllIII);
        lllIIl.write(Types1_7_6_10.METADATA_LIST, lllIII);
        PacketUtil.sendPacket(lllIIl, Protocol1_7_6_10TO1_8.class);
    }
    
    @Override
    public void updateMetadata(final List<Metadata> lIIlllI) {
        for (final Metadata lIlIIII : lIIlllI) {
            this.datawatcher.removeIf(lIIIII -> lIIIII.id() == lIlIIII.id());
            this.datawatcher.add(lIlIIII);
        }
        this.updateMetadata();
    }
    
    @Override
    public void setHeadYaw(final float lIlIlll) {
        if (this.headYaw != lIlIlll) {
            this.headYaw = lIlIlll;
            this.updateLocation();
        }
    }
    
    public GuardianReplacement(final int lllllIl, final UserConnection lllllII) {
        this.datawatcher = new ArrayList<Metadata>();
        this.entityId = lllllIl;
        this.user = lllllII;
        this.spawn();
    }
    
    @Override
    public void spawn() {
        final PacketWrapper lIllll = PacketWrapper.create(15, null, this.user);
        lIllll.write(Type.VAR_INT, this.entityId);
        lIllll.write(Type.UNSIGNED_BYTE, (Short)94);
        lIllll.write(Type.INT, 0);
        lIllll.write(Type.INT, 0);
        lIllll.write(Type.INT, 0);
        lIllll.write(Type.BYTE, (Byte)0);
        lIllll.write(Type.BYTE, (Byte)0);
        lIllll.write(Type.BYTE, (Byte)0);
        lIllll.write(Type.SHORT, (Short)0);
        lIllll.write(Type.SHORT, (Short)0);
        lIllll.write(Type.SHORT, (Short)0);
        lIllll.write((Type<ArrayList>)Types1_7_6_10.METADATA_LIST, new ArrayList());
        PacketUtil.sendPacket(lIllll, Protocol1_7_6_10TO1_8.class, true, true);
    }
    
    @Override
    public void setYawPitch(final float lIlllll, final float lIllIll) {
        if (this.yaw != lIlllll || this.pitch != lIllIll) {
            this.yaw = lIlllll;
            this.pitch = lIllIll;
            this.updateLocation();
        }
    }
    
    @Override
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void relMove(final double llIlIlI, final double llIIlIl, final double llIIlII) {
        this.locX += llIlIlI;
        this.locY += llIIlIl;
        this.locZ += llIIlII;
        this.updateLocation();
    }
    
    @Override
    public void despawn() {
        final PacketWrapper lIlIIl = PacketWrapper.create(19, null, this.user);
        lIlIIl.write(Types1_7_6_10.INT_ARRAY, new int[] { this.entityId });
        PacketUtil.sendPacket(lIlIIl, Protocol1_7_6_10TO1_8.class, true, true);
    }
}
