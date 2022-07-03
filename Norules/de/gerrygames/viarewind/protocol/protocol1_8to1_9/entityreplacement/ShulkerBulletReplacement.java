package de.gerrygames.viarewind.protocol.protocol1_8to1_9.entityreplacement;

import de.gerrygames.viarewind.replacement.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class ShulkerBulletReplacement implements EntityReplacement
{
    private /* synthetic */ float yaw;
    private /* synthetic */ double locZ;
    private /* synthetic */ float pitch;
    private /* synthetic */ double locY;
    private /* synthetic */ List<Metadata> datawatcher;
    private /* synthetic */ int entityId;
    private /* synthetic */ UserConnection user;
    private /* synthetic */ float headYaw;
    private /* synthetic */ double locX;
    
    @Override
    public void setHeadYaw(final float lllllllllllllIIlIlIIIlllIlIlIlII) {
        this.headYaw = lllllllllllllIIlIlIIIlllIlIlIlII;
    }
    
    @Override
    public void setYawPitch(final float lllllllllllllIIlIlIIIlllIlIlllII, final float lllllllllllllIIlIlIIIlllIlIllIII) {
        if (this.yaw != lllllllllllllIIlIlIIIlllIlIlllII && this.pitch != lllllllllllllIIlIlIIIlllIlIllIII) {
            this.yaw = lllllllllllllIIlIlIIIlllIlIlllII;
            this.pitch = lllllllllllllIIlIlIIIlllIlIllIII;
            this.updateLocation();
        }
    }
    
    @Override
    public void updateMetadata(final List<Metadata> lllllllllllllIIlIlIIIlllIlIlIIII) {
    }
    
    @Override
    public void spawn() {
        final PacketWrapper lllllllllllllIIlIlIIIlllIlIIIIll = PacketWrapper.create(14, null, this.user);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.VAR_INT, this.entityId);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.BYTE, (Byte)66);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.INT, 0);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.INT, 0);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.INT, 0);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.BYTE, (Byte)0);
        lllllllllllllIIlIlIIIlllIlIIIIll.write(Type.INT, 0);
        PacketUtil.sendPacket(lllllllllllllIIlIlIIIlllIlIIIIll, Protocol1_8TO1_9.class, true, true);
    }
    
    @Override
    public void despawn() {
        final PacketWrapper lllllllllllllIIlIlIIIlllIIllllIl = PacketWrapper.create(19, null, this.user);
        lllllllllllllIIlIlIIIlllIIllllIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { this.entityId });
        PacketUtil.sendPacket(lllllllllllllIIlIlIIIlllIIllllIl, Protocol1_8TO1_9.class, true, true);
    }
    
    @Override
    public void setLocation(final double lllllllllllllIIlIlIIIlllIlllIIll, final double lllllllllllllIIlIlIIIlllIlllIIlI, final double lllllllllllllIIlIlIIIlllIllIllIl) {
        if (lllllllllllllIIlIlIIIlllIlllIIll != this.locX || lllllllllllllIIlIlIIIlllIlllIIlI != this.locY || lllllllllllllIIlIlIIIlllIllIllIl != this.locZ) {
            this.locX = lllllllllllllIIlIlIIIlllIlllIIll;
            this.locY = lllllllllllllIIlIlIIIlllIlllIIlI;
            this.locZ = lllllllllllllIIlIlIIIlllIllIllIl;
            this.updateLocation();
        }
    }
    
    @Override
    public int getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void relMove(final double lllllllllllllIIlIlIIIlllIllIIIll, final double lllllllllllllIIlIlIIIlllIllIIIlI, final double lllllllllllllIIlIlIIIlllIllIIIIl) {
        if (lllllllllllllIIlIlIIIlllIllIIIll == 0.0 && lllllllllllllIIlIlIIIlllIllIIIlI == 0.0 && lllllllllllllIIlIlIIIlllIllIIIIl == 0.0) {
            return;
        }
        this.locX += lllllllllllllIIlIlIIIlllIllIIIll;
        this.locY += lllllllllllllIIlIlIIIlllIllIIIlI;
        this.locZ += lllllllllllllIIlIlIIIlllIllIIIIl;
        this.updateLocation();
    }
    
    public void updateLocation() {
        final PacketWrapper lllllllllllllIIlIlIIIlllIlIIlIll = PacketWrapper.create(24, null, this.user);
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.VAR_INT, this.entityId);
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.INT, (int)(this.locX * 32.0));
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.INT, (int)(this.locY * 32.0));
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.INT, (int)(this.locZ * 32.0));
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.BYTE, (byte)(this.yaw / 360.0f * 256.0f));
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.BYTE, (byte)(this.pitch / 360.0f * 256.0f));
        lllllllllllllIIlIlIIIlllIlIIlIll.write(Type.BOOLEAN, true);
        final PacketWrapper lllllllllllllIIlIlIIIlllIlIIlIlI = PacketWrapper.create(25, null, this.user);
        lllllllllllllIIlIlIIIlllIlIIlIlI.write(Type.VAR_INT, this.entityId);
        lllllllllllllIIlIlIIIlllIlIIlIlI.write(Type.BYTE, (byte)(this.headYaw / 360.0f * 256.0f));
        PacketUtil.sendPacket(lllllllllllllIIlIlIIIlllIlIIlIll, Protocol1_8TO1_9.class, true, true);
        PacketUtil.sendPacket(lllllllllllllIIlIlIIIlllIlIIlIlI, Protocol1_8TO1_9.class, true, true);
    }
    
    public ShulkerBulletReplacement(final int lllllllllllllIIlIlIIIlllIllllIlI, final UserConnection lllllllllllllIIlIlIIIlllIllllIIl) {
        this.datawatcher = new ArrayList<Metadata>();
        this.entityId = lllllllllllllIIlIlIIIlllIllllIlI;
        this.user = lllllllllllllIIlIlIIIlllIllllIIl;
        this.spawn();
    }
}
