package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.boss.*;
import net.minecraft.init.*;

public class PhaseSittingAttacking extends PhaseSittingBase
{
    private /* synthetic */ int attackingTicks;
    
    @Override
    public void initPhase() {
        this.attackingTicks = 0;
    }
    
    @Override
    public PhaseList<PhaseSittingAttacking> getPhaseList() {
        return PhaseList.SITTING_ATTACKING;
    }
    
    @Override
    public void doLocalUpdate() {
        if (this.attackingTicks++ >= 40) {
            this.dragon.getPhaseManager().setPhase(PhaseList.SITTING_FLAMING);
        }
    }
    
    public PhaseSittingAttacking(final EntityDragon llllllllllllllIIlIlIIllllIIIlIII) {
        super(llllllllllllllIIlIlIIllllIIIlIII);
    }
    
    @Override
    public void doClientRenderEffects() {
        this.dragon.world.playSound(this.dragon.posX, this.dragon.posY, this.dragon.posZ, SoundEvents.ENTITY_ENDERDRAGON_GROWL, this.dragon.getSoundCategory(), 2.5f, 0.8f + this.dragon.getRNG().nextFloat() * 0.3f, false);
    }
}
