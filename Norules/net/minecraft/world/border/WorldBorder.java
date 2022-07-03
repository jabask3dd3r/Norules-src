package net.minecraft.world.border;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class WorldBorder
{
    private /* synthetic */ int warningTime;
    private /* synthetic */ double endDiameter;
    private /* synthetic */ long startTime;
    private /* synthetic */ long endTime;
    private /* synthetic */ double startDiameter;
    private /* synthetic */ double damageAmount;
    private /* synthetic */ int worldSize;
    private /* synthetic */ double centerX;
    private /* synthetic */ double centerZ;
    private /* synthetic */ double damageBuffer;
    private final /* synthetic */ List<IBorderListener> listeners;
    private /* synthetic */ int warningDistance;
    
    public void setDamageAmount(final double lllllllllllllIIIlIIIIllIlIlllIll) {
        this.damageAmount = lllllllllllllIIIlIIIIllIlIlllIll;
        for (final IBorderListener lllllllllllllIIIlIIIIllIlIllllIl : this.getListeners()) {
            lllllllllllllIIIlIIIIllIlIllllIl.onDamageAmountChanged(this, lllllllllllllIIIlIIIIllIlIlllIll);
        }
    }
    
    public EnumBorderStatus getStatus() {
        if (this.endDiameter < this.startDiameter) {
            return EnumBorderStatus.SHRINKING;
        }
        return (this.endDiameter > this.startDiameter) ? EnumBorderStatus.GROWING : EnumBorderStatus.STATIONARY;
    }
    
    protected List<IBorderListener> getListeners() {
        return (List<IBorderListener>)Lists.newArrayList((Iterable)this.listeners);
    }
    
    public void setWarningDistance(final int lllllllllllllIIIlIIIIllIlIIlllll) {
        this.warningDistance = lllllllllllllIIIlIIIIllIlIIlllll;
        for (final IBorderListener lllllllllllllIIIlIIIIllIlIIllllI : this.getListeners()) {
            lllllllllllllIIIlIIIIllIlIIllllI.onWarningDistanceChanged(this, lllllllllllllIIIlIIIIllIlIIlllll);
        }
    }
    
    public double getResizeSpeed() {
        return (this.endTime == this.startTime) ? 0.0 : (Math.abs(this.startDiameter - this.endDiameter) / (this.endTime - this.startTime));
    }
    
    public void setTransition(final double lllllllllllllIIIlIIIIllIllllIIII, final double lllllllllllllIIIlIIIIllIlllIlIlI, final long lllllllllllllIIIlIIIIllIlllIlllI) {
        this.startDiameter = lllllllllllllIIIlIIIIllIllllIIII;
        this.endDiameter = lllllllllllllIIIlIIIIllIlllIlIlI;
        this.startTime = System.currentTimeMillis();
        this.endTime = this.startTime + lllllllllllllIIIlIIIIllIlllIlllI;
        for (final IBorderListener lllllllllllllIIIlIIIIllIlllIllIl : this.getListeners()) {
            lllllllllllllIIIlIIIIllIlllIllIl.onTransitionStarted(this, lllllllllllllIIIlIIIIllIllllIIII, lllllllllllllIIIlIIIIllIlllIlIlI, lllllllllllllIIIlIIIIllIlllIlllI);
        }
    }
    
    public double maxZ() {
        double lllllllllllllIIIlIIIIlllIIlIIlIl = this.getCenterZ() + this.getDiameter() / 2.0;
        if (lllllllllllllIIIlIIIIlllIIlIIlIl > this.worldSize) {
            lllllllllllllIIIlIIIIlllIIlIIlIl = this.worldSize;
        }
        return lllllllllllllIIIlIIIIlllIIlIIlIl;
    }
    
    public void setWarningTime(final int lllllllllllllIIIlIIIIllIlIlIllIl) {
        this.warningTime = lllllllllllllIIIlIIIIllIlIlIllIl;
        for (final IBorderListener lllllllllllllIIIlIIIIllIlIlIllII : this.getListeners()) {
            lllllllllllllIIIlIIIIllIlIlIllII.onWarningTimeChanged(this, lllllllllllllIIIlIIIIllIlIlIllIl);
        }
    }
    
    public double minZ() {
        double lllllllllllllIIIlIIIIlllIIllIIIl = this.getCenterZ() - this.getDiameter() / 2.0;
        if (lllllllllllllIIIlIIIIlllIIllIIIl < -this.worldSize) {
            lllllllllllllIIIlIIIIlllIIllIIIl = -this.worldSize;
        }
        return lllllllllllllIIIlIIIIlllIIllIIIl;
    }
    
    public void setDamageBuffer(final double lllllllllllllIIIlIIIIllIllIIlIIl) {
        this.damageBuffer = lllllllllllllIIIlIIIIllIllIIlIIl;
        for (final IBorderListener lllllllllllllIIIlIIIIllIllIIlIll : this.getListeners()) {
            lllllllllllllIIIlIIIIllIllIIlIll.onDamageBufferChanged(this, lllllllllllllIIIlIIIIllIllIIlIIl);
        }
    }
    
    public int getSize() {
        return this.worldSize;
    }
    
    public void setCenter(final double lllllllllllllIIIlIIIIlllIIIlIllI, final double lllllllllllllIIIlIIIIlllIIIlIlIl) {
        this.centerX = lllllllllllllIIIlIIIIlllIIIlIllI;
        this.centerZ = lllllllllllllIIIlIIIIlllIIIlIlIl;
        for (final IBorderListener lllllllllllllIIIlIIIIlllIIIlIlII : this.getListeners()) {
            lllllllllllllIIIlIIIIlllIIIlIlII.onCenterChanged(this, lllllllllllllIIIlIIIIlllIIIlIllI, lllllllllllllIIIlIIIIlllIIIlIlIl);
        }
    }
    
    public int getWarningTime() {
        return this.warningTime;
    }
    
    public double getTargetSize() {
        return this.endDiameter;
    }
    
    public void setSize(final int lllllllllllllIIIlIIIIllIllIllIlI) {
        this.worldSize = lllllllllllllIIIlIIIIllIllIllIlI;
    }
    
    public boolean contains(final BlockPos lllllllllllllIIIlIIIIlllIllIlIII) {
        return lllllllllllllIIIlIIIIlllIllIlIII.getX() + 1 > this.minX() && lllllllllllllIIIlIIIIlllIllIlIII.getX() < this.maxX() && lllllllllllllIIIlIIIIlllIllIlIII.getZ() + 1 > this.minZ() && lllllllllllllIIIlIIIIlllIllIlIII.getZ() < this.maxZ();
    }
    
    public double getDamageAmount() {
        return this.damageAmount;
    }
    
    public boolean contains(final ChunkPos lllllllllllllIIIlIIIIlllIllIIIlI) {
        return lllllllllllllIIIlIIIIlllIllIIIlI.getXEnd() > this.minX() && lllllllllllllIIIlIIIIlllIllIIIlI.getXStart() < this.maxX() && lllllllllllllIIIlIIIIlllIllIIIlI.getZEnd() > this.minZ() && lllllllllllllIIIlIIIIlllIllIIIlI.getZStart() < this.maxZ();
    }
    
    public double getDiameter() {
        if (this.getStatus() != EnumBorderStatus.STATIONARY) {
            final double lllllllllllllIIIlIIIIlllIIIIlIll = (System.currentTimeMillis() - this.startTime) / (float)(this.endTime - this.startTime);
            if (lllllllllllllIIIlIIIIlllIIIIlIll < 1.0) {
                return this.startDiameter + (this.endDiameter - this.startDiameter) * lllllllllllllIIIlIIIIlllIIIIlIll;
            }
            this.setTransition(this.endDiameter);
        }
        return this.startDiameter;
    }
    
    public WorldBorder() {
        this.listeners = (List<IBorderListener>)Lists.newArrayList();
        this.startDiameter = 6.0E7;
        this.endDiameter = this.startDiameter;
        this.worldSize = 29999984;
        this.damageAmount = 0.2;
        this.damageBuffer = 5.0;
        this.warningTime = 15;
        this.warningDistance = 5;
    }
    
    public double getCenterZ() {
        return this.centerZ;
    }
    
    public double getDamageBuffer() {
        return this.damageBuffer;
    }
    
    public boolean contains(final AxisAlignedBB lllllllllllllIIIlIIIIlllIlIlllII) {
        return lllllllllllllIIIlIIIIlllIlIlllII.maxX > this.minX() && lllllllllllllIIIlIIIIlllIlIlllII.minX < this.maxX() && lllllllllllllIIIlIIIIlllIlIlllII.maxZ > this.minZ() && lllllllllllllIIIlIIIIlllIlIlllII.minZ < this.maxZ();
    }
    
    public long getTimeUntilTarget() {
        return (this.getStatus() == EnumBorderStatus.STATIONARY) ? 0L : (this.endTime - System.currentTimeMillis());
    }
    
    public double minX() {
        double lllllllllllllIIIlIIIIlllIIllIlll = this.getCenterX() - this.getDiameter() / 2.0;
        if (lllllllllllllIIIlIIIIlllIIllIlll < -this.worldSize) {
            lllllllllllllIIIlIIIIlllIIllIlll = -this.worldSize;
        }
        return lllllllllllllIIIlIIIIlllIIllIlll;
    }
    
    public double maxX() {
        double lllllllllllllIIIlIIIIlllIIlIlIll = this.getCenterX() + this.getDiameter() / 2.0;
        if (lllllllllllllIIIlIIIIlllIIlIlIll > this.worldSize) {
            lllllllllllllIIIlIIIIlllIIlIlIll = this.worldSize;
        }
        return lllllllllllllIIIlIIIIlllIIlIlIll;
    }
    
    public int getWarningDistance() {
        return this.warningDistance;
    }
    
    public double getCenterX() {
        return this.centerX;
    }
    
    public double getClosestDistance(final double lllllllllllllIIIlIIIIlllIlIIIlII, final double lllllllllllllIIIlIIIIlllIlIIIIll) {
        final double lllllllllllllIIIlIIIIlllIlIIlIlI = lllllllllllllIIIlIIIIlllIlIIIIll - this.minZ();
        final double lllllllllllllIIIlIIIIlllIlIIlIIl = this.maxZ() - lllllllllllllIIIlIIIIlllIlIIIIll;
        final double lllllllllllllIIIlIIIIlllIlIIlIII = lllllllllllllIIIlIIIIlllIlIIIlII - this.minX();
        final double lllllllllllllIIIlIIIIlllIlIIIlll = this.maxX() - lllllllllllllIIIlIIIIlllIlIIIlII;
        double lllllllllllllIIIlIIIIlllIlIIIllI = Math.min(lllllllllllllIIIlIIIIlllIlIIlIII, lllllllllllllIIIlIIIIlllIlIIIlll);
        lllllllllllllIIIlIIIIlllIlIIIllI = Math.min(lllllllllllllIIIlIIIIlllIlIIIllI, lllllllllllllIIIlIIIIlllIlIIlIlI);
        return Math.min(lllllllllllllIIIlIIIIlllIlIIIllI, lllllllllllllIIIlIIIIlllIlIIlIIl);
    }
    
    public void setTransition(final double lllllllllllllIIIlIIIIllIllllllIl) {
        this.startDiameter = lllllllllllllIIIlIIIIllIllllllIl;
        this.endDiameter = lllllllllllllIIIlIIIIllIllllllIl;
        this.endTime = System.currentTimeMillis();
        this.startTime = this.endTime;
        for (final IBorderListener lllllllllllllIIIlIIIIllIllllllII : this.getListeners()) {
            lllllllllllllIIIlIIIIllIllllllII.onSizeChanged(this, lllllllllllllIIIlIIIIllIllllllIl);
        }
    }
    
    public void addListener(final IBorderListener lllllllllllllIIIlIIIIllIllIllllI) {
        this.listeners.add(lllllllllllllIIIlIIIIllIllIllllI);
    }
    
    public double getClosestDistance(final Entity lllllllllllllIIIlIIIIlllIlIllIII) {
        return this.getClosestDistance(lllllllllllllIIIlIIIIlllIlIllIII.posX, lllllllllllllIIIlIIIIlllIlIllIII.posZ);
    }
}
