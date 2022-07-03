package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.entityreplacements;

import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;

public class EndermiteReplacement implements EntityReplacement
{
    private /* synthetic */ float yaw;
    private /* synthetic */ List<Metadata> datawatcher;
    private /* synthetic */ double locX;
    private /* synthetic */ UserConnection user;
    private /* synthetic */ double locY;
    private /* synthetic */ int entityId;
    private /* synthetic */ float pitch;
    private /* synthetic */ float headYaw;
    private /* synthetic */ double locZ;
    
    public EndermiteReplacement(final int lllllllllllllIlIlIIlIIllIllIlIIl, final UserConnection lllllllllllllIlIlIIlIIllIllIlIII) {
        this.datawatcher = new ArrayList<Metadata>();
        this.entityId = lllllllllllllIlIlIIlIIllIllIlIIl;
        this.user = lllllllllllllIlIlIIlIIllIllIlIII;
        this.spawn();
    }
    
    public void updateMetadata() {
        final PacketWrapper lllllllllllllIlIlIIlIIllIIlIIlIl = PacketWrapper.create(28, null, this.user);
        lllllllllllllIlIlIIlIIllIIlIIlIl.write(Type.INT, this.entityId);
        final List<Metadata> lllllllllllllIlIlIIlIIllIIlIIlII = new ArrayList<Metadata>();
        for (final Metadata lllllllllllllIlIlIIlIIllIIlIIlll : this.datawatcher) {
            lllllllllllllIlIlIIlIIllIIlIIlII.add(new Metadata(lllllllllllllIlIlIIlIIllIIlIIlll.id(), lllllllllllllIlIlIIlIIllIIlIIlll.metaType(), lllllllllllllIlIlIIlIIllIIlIIlll.getValue()));
        }
        MetadataRewriter.transform(Entity1_10Types.EntityType.SQUID, lllllllllllllIlIlIIlIIllIIlIIlII);
        lllllllllllllIlIlIIlIIllIIlIIlIl.write(Types1_7_6_10.METADATA_LIST, lllllllllllllIlIlIIlIIllIIlIIlII);
        PacketUtil.sendPacket(lllllllllllllIlIlIIlIIllIIlIIlIl, Protocol1_7_6_10TO1_8.class);
    }
    
    @Override
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void setLocation(final double lllllllllllllIlIlIIlIIllIllIIIlI, final double lllllllllllllIlIlIIlIIllIlIlllIl, final double lllllllllllllIlIlIIlIIllIlIlllII) {
        this.locX = lllllllllllllIlIlIIlIIllIllIIIlI;
        this.locY = lllllllllllllIlIlIIlIIllIlIlllIl;
        this.locZ = lllllllllllllIlIlIIlIIllIlIlllII;
        this.updateLocation();
    }
    
    @Override
    public void despawn() {
        final PacketWrapper lllllllllllllIlIlIIlIIllIIIlIlIl = PacketWrapper.create(19, null, this.user);
        lllllllllllllIlIlIIlIIllIIIlIlIl.write(Types1_7_6_10.INT_ARRAY, new int[] { this.entityId });
        PacketUtil.sendPacket(lllllllllllllIlIlIIlIIllIIIlIlIl, Protocol1_7_6_10TO1_8.class, true, true);
    }
    
    @Override
    public void setYawPitch(final float lllllllllllllIlIlIIlIIllIlIIlIll, final float lllllllllllllIlIlIIlIIllIlIIIlll) {
        if (this.yaw != lllllllllllllIlIlIIlIIllIlIIlIll || this.pitch != lllllllllllllIlIlIIlIIllIlIIIlll) {
            this.yaw = lllllllllllllIlIlIIlIIllIlIIlIll;
            this.pitch = lllllllllllllIlIlIIlIIllIlIIIlll;
            this.updateLocation();
        }
    }
    
    @Override
    public void spawn() {
        final PacketWrapper lllllllllllllIlIlIIlIIllIIIllIll = PacketWrapper.create(15, null, this.user);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.VAR_INT, this.entityId);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.UNSIGNED_BYTE, (Short)60);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.INT, 0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.INT, 0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.INT, 0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.SHORT, (Short)0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.SHORT, (Short)0);
        lllllllllllllIlIlIIlIIllIIIllIll.write(Type.SHORT, (Short)0);
        lllllllllllllIlIlIIlIIllIIIllIll.write((Type<ArrayList>)Types1_7_6_10.METADATA_LIST, new ArrayList());
        PacketUtil.sendPacket(lllllllllllllIlIlIIlIIllIIIllIll, Protocol1_7_6_10TO1_8.class, true, true);
    }
    
    @Override
    public void relMove(final double lllllllllllllIlIlIIlIIllIlIlIllI, final double lllllllllllllIlIlIIlIIllIlIlIlIl, final double lllllllllllllIlIlIIlIIllIlIlIlII) {
        this.locX += lllllllllllllIlIlIIlIIllIlIlIllI;
        this.locY += lllllllllllllIlIlIIlIIllIlIlIlIl;
        this.locZ += lllllllllllllIlIlIIlIIllIlIlIlII;
        this.updateLocation();
    }
    
    public void updateLocation() {
        final PacketWrapper lllllllllllllIlIlIIlIIllIIllIIIl = PacketWrapper.create(24, null, this.user);
        lllllllllllllIlIlIIlIIllIIllIIIl.write(Type.INT, this.entityId);
        lllllllllllllIlIlIIlIIllIIllIIIl.write(Type.INT, (int)(this.locX * 32.0));
        lllllllllllllIlIlIIlIIllIIllIIIl.write(Type.INT, (int)(this.locY * 32.0));
        lllllllllllllIlIlIIlIIllIIllIIIl.write(Type.INT, (int)(this.locZ * 32.0));
        lllllllllllllIlIlIIlIIllIIllIIIl.write(Type.BYTE, (byte)(this.yaw / 360.0f * 256.0f));
        lllllllllllllIlIlIIlIIllIIllIIIl.write(Type.BYTE, (byte)(this.pitch / 360.0f * 256.0f));
        final PacketWrapper lllllllllllllIlIlIIlIIllIIllIIII = PacketWrapper.create(25, null, this.user);
        lllllllllllllIlIlIIlIIllIIllIIII.write(Type.INT, this.entityId);
        lllllllllllllIlIlIIlIIllIIllIIII.write(Type.BYTE, (byte)(this.headYaw / 360.0f * 256.0f));
        PacketUtil.sendPacket(lllllllllllllIlIlIIlIIllIIllIIIl, Protocol1_7_6_10TO1_8.class, true, true);
        PacketUtil.sendPacket(lllllllllllllIlIlIIlIIllIIllIIII, Protocol1_7_6_10TO1_8.class, true, true);
    }
    
    @Override
    public void setHeadYaw(final float lllllllllllllIlIlIIlIIllIlIIIIll) {
        if (this.headYaw != lllllllllllllIlIlIIlIIllIlIIIIll) {
            this.headYaw = lllllllllllllIlIlIIlIIllIlIIIIll;
            this.updateLocation();
        }
    }
    
    @Override
    public void updateMetadata(final List<Metadata> lllllllllllllIlIlIIlIIllIIlllIII) {
        for (final Metadata lllllllllllllIlIlIIlIIllIIllllII : lllllllllllllIlIlIIlIIllIIlllIII) {
            this.datawatcher.removeIf(lllllllllllllIlIlIIlIIllIIIIlIlI -> lllllllllllllIlIlIIlIIllIIIIlIlI.id() == lllllllllllllIlIlIIlIIllIIllllII.id());
            this.datawatcher.add(lllllllllllllIlIlIIlIIllIIllllII);
        }
        this.updateMetadata();
    }
}
