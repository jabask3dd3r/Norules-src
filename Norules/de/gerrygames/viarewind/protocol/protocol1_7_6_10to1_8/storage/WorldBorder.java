package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.connection.*;

public class WorldBorder extends StoredObject implements Tickable
{
    private /* synthetic */ double oldDiameter;
    private /* synthetic */ long lerpTime;
    private /* synthetic */ int portalTeleportBoundary;
    private /* synthetic */ boolean init;
    private /* synthetic */ double z;
    private /* synthetic */ double newDiameter;
    private /* synthetic */ long lerpStartTime;
    private /* synthetic */ int warningBlocks;
    private /* synthetic */ int warningTime;
    private /* synthetic */ double x;
    
    public long getLerpTime() {
        return this.lerpTime;
    }
    
    public void setSize(final double lllllIIllIlIlll) {
        this.oldDiameter = lllllIIllIlIlll;
        this.newDiameter = lllllIIllIlIlll;
        this.lerpTime = 0L;
    }
    
    public void setCenter(final double lllllIIllllIllI, final double lllllIIllllIIlI) {
        this.x = lllllIIllllIllI;
        this.z = lllllIIllllIIlI;
    }
    
    public void setWarningBlocks(final int lllllIIlIllIlIl) {
        this.warningBlocks = lllllIIlIllIlIl;
    }
    
    private void sendPackets() {
        final PlayerPosition lllllIlIIllIlII = this.getUser().get(PlayerPosition.class);
        final double lllllIlIIllIIll = this.getSize() / 2.0;
        final int lllllIlIIlIllll = (Object)Side.values();
        final int lllllIlIIlIlllI = lllllIlIIlIllll.length;
        for (long lllllIlIIlIllIl = 0; lllllIlIIlIllIl < lllllIlIIlIlllI; ++lllllIlIIlIllIl) {
            final Side lllllIlIIllIllI = lllllIlIIlIllll[lllllIlIIlIllIl];
            double lllllIlIlIIIIIl = 0.0;
            double lllllIlIlIIIIlI = 0.0;
            double lllllIlIlIIIIll = 0.0;
            if (lllllIlIIllIllI.modX != 0) {
                final double lllllIlIlIIIlIl = lllllIlIIllIlII.getPosZ();
                final double lllllIlIlIIIlII = this.z;
                final double lllllIlIlIIIllI = Math.abs(this.x + lllllIlIIllIIll * lllllIlIIllIllI.modX - lllllIlIIllIlII.getPosX());
            }
            else {
                lllllIlIlIIIIIl = this.x;
                lllllIlIlIIIIlI = lllllIlIIllIlII.getPosX();
                lllllIlIlIIIIll = Math.abs(this.z + lllllIlIIllIIll * lllllIlIIllIllI.modZ - lllllIlIIllIlII.getPosZ());
            }
            if (lllllIlIlIIIIll < 16.0) {
                final double lllllIlIlIIIIII = Math.sqrt(256.0 - lllllIlIlIIIIll * lllllIlIlIIIIll);
                double lllllIlIIllllll = Math.ceil(lllllIlIlIIIIlI - lllllIlIlIIIIII);
                double lllllIlIIlllllI = Math.floor(lllllIlIlIIIIlI + lllllIlIlIIIIII);
                double lllllIlIIllllIl = Math.ceil(lllllIlIIllIlII.getPosY() - lllllIlIlIIIIII);
                final double lllllIlIIllllII = Math.floor(lllllIlIIllIlII.getPosY() + lllllIlIlIIIIII);
                if (lllllIlIIllllll < lllllIlIlIIIIIl - lllllIlIIllIIll) {
                    lllllIlIIllllll = Math.ceil(lllllIlIlIIIIIl - lllllIlIIllIIll);
                }
                if (lllllIlIIlllllI > lllllIlIlIIIIIl + lllllIlIIllIIll) {
                    lllllIlIIlllllI = Math.floor(lllllIlIlIIIIIl + lllllIlIIllIIll);
                }
                if (lllllIlIIllllIl < 0.0) {
                    lllllIlIIllllIl = 0.0;
                }
                final double lllllIlIIlllIll = (lllllIlIIllllll + lllllIlIIlllllI) / 2.0;
                final double lllllIlIIlllIlI = (lllllIlIIllllIl + lllllIlIIllllII) / 2.0;
                final int lllllIlIIlllIIl = (int)Math.floor((lllllIlIIlllllI - lllllIlIIllllll) * (lllllIlIIllllII - lllllIlIIllllIl) * 0.5);
                final double lllllIlIIlllIII = 2.5;
                final PacketWrapper lllllIlIIllIlll = PacketWrapper.create(42, null, this.getUser());
                lllllIlIIllIlll.write(Type.STRING, "fireworksSpark");
                lllllIlIIllIlll.write(Type.FLOAT, (float)((lllllIlIIllIllI.modX != 0) ? (this.x + lllllIlIIllIIll * lllllIlIIllIllI.modX) : lllllIlIIlllIll));
                lllllIlIIllIlll.write(Type.FLOAT, (float)lllllIlIIlllIlI);
                lllllIlIIllIlll.write(Type.FLOAT, (float)((lllllIlIIllIllI.modX == 0) ? (this.z + lllllIlIIllIIll * lllllIlIIllIllI.modZ) : lllllIlIIlllIll));
                lllllIlIIllIlll.write(Type.FLOAT, (float)((lllllIlIIllIllI.modX != 0) ? 0.0 : ((lllllIlIIlllllI - lllllIlIIllllll) / lllllIlIIlllIII)));
                lllllIlIIllIlll.write(Type.FLOAT, (float)((lllllIlIIllllII - lllllIlIIllllIl) / lllllIlIIlllIII));
                lllllIlIIllIlll.write(Type.FLOAT, (float)((lllllIlIIllIllI.modX == 0) ? 0.0 : ((lllllIlIIlllllI - lllllIlIIllllll) / lllllIlIIlllIII)));
                lllllIlIIllIlll.write(Type.FLOAT, 0.0f);
                lllllIlIIllIlll.write(Type.INT, lllllIlIIlllIIl);
                PacketUtil.sendPacket(lllllIlIIllIlll, Protocol1_7_6_10TO1_8.class, true, true);
            }
        }
    }
    
    public void setWarningTime(final int lllllIIlIllllII) {
        this.warningTime = lllllIIlIllllII;
    }
    
    @Override
    public void tick() {
        if (!this.isInit()) {
            return;
        }
        this.sendPackets();
    }
    
    public int getWarningBlocks() {
        return this.warningBlocks;
    }
    
    public double getOldDiameter() {
        return this.oldDiameter;
    }
    
    public void init(final double lllllIlIIIIlIII, final double lllllIlIIIlIIII, final double lllllIlIIIIllll, final double lllllIlIIIIlllI, final long lllllIlIIIIIlII, final int lllllIlIIIIllII, final int lllllIlIIIIIIlI, final int lllllIlIIIIIIIl) {
        this.x = lllllIlIIIIlIII;
        this.z = lllllIlIIIlIIII;
        this.oldDiameter = lllllIlIIIIllll;
        this.newDiameter = lllllIlIIIIlllI;
        this.lerpTime = lllllIlIIIIIlII;
        this.portalTeleportBoundary = lllllIlIIIIllII;
        this.warningTime = lllllIlIIIIIIlI;
        this.warningBlocks = lllllIlIIIIIIIl;
        this.init = true;
    }
    
    private boolean isInit() {
        return this.init;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void lerpSize(final double lllllIIllIlllll, final double lllllIIllIllllI, final long lllllIIllIlllIl) {
        this.oldDiameter = lllllIIllIlllll;
        this.newDiameter = lllllIIllIllllI;
        this.lerpTime = lllllIIllIlllIl;
        this.lerpStartTime = System.currentTimeMillis();
    }
    
    public double getSize() {
        if (this.lerpTime == 0L) {
            return this.newDiameter;
        }
        final long lllllIIllIlIIlI = System.currentTimeMillis() - this.lerpStartTime;
        double lllllIIllIlIIIl = lllllIIllIlIIlI / (double)this.lerpTime;
        if (lllllIIllIlIIIl > 1.0) {
            lllllIIllIlIIIl = 1.0;
        }
        else if (lllllIIllIlIIIl < 0.0) {
            lllllIIllIlIIIl = 0.0;
        }
        return this.oldDiameter + (this.newDiameter - this.oldDiameter) * lllllIIllIlIIIl;
    }
    
    public double getNewDiameter() {
        return this.newDiameter;
    }
    
    public double getX() {
        return this.x;
    }
    
    public int getWarningTime() {
        return this.warningTime;
    }
    
    public int getPortalTeleportBoundary() {
        return this.portalTeleportBoundary;
    }
    
    public WorldBorder(final UserConnection lllllIlIllIIIII) {
        super(lllllIlIllIIIII);
        this.init = false;
    }
    
    public void setPortalTeleportBoundary(final int lllllIIllIIIlll) {
        this.portalTeleportBoundary = lllllIIllIIIlll;
    }
    
    private enum Side
    {
        EAST(1, 0), 
        NORTH(0, -1);
        
        private /* synthetic */ int modZ;
        
        SOUTH(0, 1);
        
        private /* synthetic */ int modX;
        
        WEST(-1, 0);
        
        private Side(final int llllllllllllllIlIIlIIlIIlIlIIIIl, final int llllllllllllllIlIIlIIlIIlIlIIIII) {
            this.modX = llllllllllllllIlIIlIIlIIlIlIIIIl;
            this.modZ = llllllllllllllIlIIlIIlIIlIlIIIII;
        }
    }
}
