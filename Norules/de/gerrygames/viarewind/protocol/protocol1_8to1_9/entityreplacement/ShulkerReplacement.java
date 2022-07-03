package de.gerrygames.viarewind.protocol.protocol1_8to1_9.entityreplacement;

import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata.*;
import com.viaversion.viaversion.api.type.types.version.*;

public class ShulkerReplacement implements EntityReplacement
{
    private /* synthetic */ double locZ;
    private /* synthetic */ List<Metadata> datawatcher;
    private /* synthetic */ int entityId;
    private /* synthetic */ UserConnection user;
    private /* synthetic */ double locX;
    private /* synthetic */ double locY;
    
    @Override
    public void despawn() {
        final PacketWrapper lIIIllIllIIIlll = PacketWrapper.create(19, null, this.user);
        lIIIllIllIIIlll.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { this.entityId });
        PacketUtil.sendPacket(lIIIllIllIIIlll, Protocol1_8TO1_9.class, true, true);
    }
    
    @Override
    public int getEntityId() {
        return this.entityId;
    }
    
    public void updateMetadata() {
        final PacketWrapper lIIIllIllIllIlI = PacketWrapper.create(28, null, this.user);
        lIIIllIllIllIlI.write(Type.VAR_INT, this.entityId);
        final List<Metadata> lIIIllIllIllIIl = new ArrayList<Metadata>();
        for (final Metadata lIIIllIllIlllII : this.datawatcher) {
            if (lIIIllIllIlllII.id() != 11 && lIIIllIllIlllII.id() != 12) {
                if (lIIIllIllIlllII.id() == 13) {
                    continue;
                }
                lIIIllIllIllIIl.add(new Metadata(lIIIllIllIlllII.id(), lIIIllIllIlllII.metaType(), lIIIllIllIlllII.getValue()));
            }
        }
        lIIIllIllIllIIl.add(new Metadata(11, MetaType1_9.VarInt, 2));
        MetadataRewriter.transform(Entity1_10Types.EntityType.MAGMA_CUBE, lIIIllIllIllIIl);
        lIIIllIllIllIlI.write(Types1_8.METADATA_LIST, lIIIllIllIllIIl);
        PacketUtil.sendPacket(lIIIllIllIllIlI, Protocol1_8TO1_9.class);
    }
    
    @Override
    public void setLocation(final double lIIIlllIIIIIllI, final double lIIIlllIIIIIlIl, final double lIIIlllIIIIIlII) {
        this.locX = lIIIlllIIIIIllI;
        this.locY = lIIIlllIIIIIlIl;
        this.locZ = lIIIlllIIIIIlII;
        this.updateLocation();
    }
    
    @Override
    public void setYawPitch(final float lIIIllIllllIllI, final float lIIIllIllllIlIl) {
    }
    
    @Override
    public void spawn() {
        final PacketWrapper lIIIllIllIIllll = PacketWrapper.create(15, null, this.user);
        lIIIllIllIIllll.write(Type.VAR_INT, this.entityId);
        lIIIllIllIIllll.write(Type.UNSIGNED_BYTE, (Short)62);
        lIIIllIllIIllll.write(Type.INT, 0);
        lIIIllIllIIllll.write(Type.INT, 0);
        lIIIllIllIIllll.write(Type.INT, 0);
        lIIIllIllIIllll.write(Type.BYTE, (Byte)0);
        lIIIllIllIIllll.write(Type.BYTE, (Byte)0);
        lIIIllIllIIllll.write(Type.BYTE, (Byte)0);
        lIIIllIllIIllll.write(Type.SHORT, (Short)0);
        lIIIllIllIIllll.write(Type.SHORT, (Short)0);
        lIIIllIllIIllll.write(Type.SHORT, (Short)0);
        final List<Metadata> lIIIllIllIIlllI = new ArrayList<Metadata>();
        lIIIllIllIIlllI.add(new Metadata(0, MetaType1_9.Byte, 0));
        lIIIllIllIIllll.write(Types1_8.METADATA_LIST, lIIIllIllIIlllI);
        PacketUtil.sendPacket(lIIIllIllIIllll, Protocol1_8TO1_9.class, true, true);
    }
    
    public ShulkerReplacement(final int lIIIlllIIIlIlII, final UserConnection lIIIlllIIIlIIll) {
        this.datawatcher = new ArrayList<Metadata>();
        this.entityId = lIIIlllIIIlIlII;
        this.user = lIIIlllIIIlIIll;
        this.spawn();
    }
    
    @Override
    public void relMove(final double lIIIllIlllllIlI, final double lIIIllIllllllIl, final double lIIIllIllllllII) {
        this.locX += lIIIllIlllllIlI;
        this.locY += lIIIllIllllllIl;
        this.locZ += lIIIllIllllllII;
        this.updateLocation();
    }
    
    public void updateLocation() {
        final PacketWrapper lIIIllIlllIIlII = PacketWrapper.create(24, null, this.user);
        lIIIllIlllIIlII.write(Type.VAR_INT, this.entityId);
        lIIIllIlllIIlII.write(Type.INT, (int)(this.locX * 32.0));
        lIIIllIlllIIlII.write(Type.INT, (int)(this.locY * 32.0));
        lIIIllIlllIIlII.write(Type.INT, (int)(this.locZ * 32.0));
        lIIIllIlllIIlII.write(Type.BYTE, (Byte)0);
        lIIIllIlllIIlII.write(Type.BYTE, (Byte)0);
        lIIIllIlllIIlII.write(Type.BOOLEAN, true);
        PacketUtil.sendPacket(lIIIllIlllIIlII, Protocol1_8TO1_9.class, true, true);
    }
    
    @Override
    public void updateMetadata(final List<Metadata> lIIIllIlllIllII) {
        for (final Metadata lIIIllIlllIlllI : lIIIllIlllIllII) {
            this.datawatcher.removeIf(lIIIllIlIlllllI -> lIIIllIlIlllllI.id() == lIIIllIlllIlllI.id());
            this.datawatcher.add(lIIIllIlllIlllI);
        }
        this.updateMetadata();
    }
    
    @Override
    public void setHeadYaw(final float lIIIllIllllIIll) {
    }
}
