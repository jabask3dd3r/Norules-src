package net.minecraft.entity.ai;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;

public class EntityAIZombieAttack extends EntityAIAttackMelee
{
    private /* synthetic */ int raiseArmTicks;
    private final /* synthetic */ EntityZombie zombie;
    
    public EntityAIZombieAttack(final EntityZombie lllllllllllllIlIIIIlIlIlIlIlllll, final double lllllllllllllIlIIIIlIlIlIlIllllI, final boolean lllllllllllllIlIIIIlIlIlIlIlllIl) {
        super(lllllllllllllIlIIIIlIlIlIlIlllll, lllllllllllllIlIIIIlIlIlIlIllllI, lllllllllllllIlIIIIlIlIlIlIlllIl);
        this.zombie = lllllllllllllIlIIIIlIlIlIlIlllll;
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
            this.zombie.setArmsRaised(true);
        }
        else {
            this.zombie.setArmsRaised(false);
        }
    }
    
    @Override
    public void resetTask() {
        super.resetTask();
        this.zombie.setArmsRaised(false);
    }
}
