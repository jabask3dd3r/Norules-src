package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.inventory.*;

public class EntityAIRestrictSun extends EntityAIBase
{
    private final /* synthetic */ EntityCreature theEntity;
    
    @Override
    public void startExecuting() {
        ((PathNavigateGround)this.theEntity.getNavigator()).setAvoidSun(true);
    }
    
    @Override
    public void resetTask() {
        ((PathNavigateGround)this.theEntity.getNavigator()).setAvoidSun(false);
    }
    
    public EntityAIRestrictSun(final EntityCreature llllllllllllllIlllIIIlIIIIIIlIIl) {
        this.theEntity = llllllllllllllIlllIIIlIIIIIIlIIl;
    }
    
    @Override
    public boolean shouldExecute() {
        return this.theEntity.world.isDaytime() && this.theEntity.getItemStackFromSlot(EntityEquipmentSlot.HEAD).func_190926_b();
    }
}
