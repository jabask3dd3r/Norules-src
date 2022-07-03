package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class EntityAIWander extends EntityAIBase
{
    protected /* synthetic */ boolean mustUpdate;
    protected final /* synthetic */ double speed;
    protected /* synthetic */ double xPosition;
    protected /* synthetic */ int executionChance;
    protected /* synthetic */ double yPosition;
    protected /* synthetic */ double zPosition;
    protected final /* synthetic */ EntityCreature entity;
    
    public void makeUpdate() {
        this.mustUpdate = true;
    }
    
    @Override
    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }
    
    @Nullable
    protected Vec3d func_190864_f() {
        return RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
    }
    
    public EntityAIWander(final EntityCreature lllllllllllllIIIIIlllIIllIIIlIII, final double lllllllllllllIIIIIlllIIllIIIIlII) {
        this(lllllllllllllIIIIIlllIIllIIIlIII, lllllllllllllIIIIIlllIIllIIIIlII, 120);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }
    
    public EntityAIWander(final EntityCreature lllllllllllllIIIIIlllIIlIllllIlI, final double lllllllllllllIIIIIlllIIlIlllllIl, final int lllllllllllllIIIIIlllIIlIlllllII) {
        this.entity = lllllllllllllIIIIIlllIIlIllllIlI;
        this.speed = lllllllllllllIIIIIlllIIlIlllllIl;
        this.executionChance = lllllllllllllIIIIIlllIIlIlllllII;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.mustUpdate) {
            if (this.entity.getAge() >= 100) {
                return false;
            }
            if (this.entity.getRNG().nextInt(this.executionChance) != 0) {
                return false;
            }
        }
        final Vec3d lllllllllllllIIIIIlllIIlIlllIlII = this.func_190864_f();
        if (lllllllllllllIIIIIlllIIlIlllIlII == null) {
            return false;
        }
        this.xPosition = lllllllllllllIIIIIlllIIlIlllIlII.xCoord;
        this.yPosition = lllllllllllllIIIIIlllIIlIlllIlII.yCoord;
        this.zPosition = lllllllllllllIIIIIlllIIlIlllIlII.zCoord;
        this.mustUpdate = false;
        return true;
    }
    
    public void setExecutionChance(final int lllllllllllllIIIIIlllIIlIllIIIII) {
        this.executionChance = lllllllllllllIIIIIlllIIlIllIIIII;
    }
}
