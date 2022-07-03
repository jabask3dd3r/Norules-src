package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.util.math.*;
import org.apache.logging.log4j.*;
import javax.annotation.*;
import net.minecraft.entity.boss.*;

public class PhaseChargingPlayer extends PhaseBase
{
    private /* synthetic */ int timeSinceCharge;
    private /* synthetic */ Vec3d targetLocation;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public float getMaxRiseOrFall() {
        return 3.0f;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    @Override
    public void initPhase() {
        this.targetLocation = null;
        this.timeSinceCharge = 0;
    }
    
    @Override
    public void doLocalUpdate() {
        if (this.targetLocation == null) {
            PhaseChargingPlayer.LOGGER.warn("Aborting charge player as no target was set.");
            this.dragon.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
        }
        else if (this.timeSinceCharge > 0 && this.timeSinceCharge++ >= 10) {
            this.dragon.getPhaseManager().setPhase(PhaseList.HOLDING_PATTERN);
        }
        else {
            final double llllllllllllllllIlIlIIIlIllIIlIl = this.targetLocation.squareDistanceTo(this.dragon.posX, this.dragon.posY, this.dragon.posZ);
            if (llllllllllllllllIlIlIIIlIllIIlIl < 100.0 || llllllllllllllllIlIlIIIlIllIIlIl > 22500.0 || this.dragon.isCollidedHorizontally || this.dragon.isCollidedVertically) {
                ++this.timeSinceCharge;
            }
        }
    }
    
    public void setTarget(final Vec3d llllllllllllllllIlIlIIIlIlIllIlI) {
        this.targetLocation = llllllllllllllllIlIlIIIlIlIllIlI;
    }
    
    @Override
    public PhaseList<PhaseChargingPlayer> getPhaseList() {
        return PhaseList.CHARGING_PLAYER;
    }
    
    public PhaseChargingPlayer(final EntityDragon llllllllllllllllIlIlIIIlIllIlIll) {
        super(llllllllllllllllIlIlIIIlIllIlIll);
    }
}
