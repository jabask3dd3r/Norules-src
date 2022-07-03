package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.entity.*;

public class EntityAIWanderAvoidWater extends EntityAIWander
{
    protected final /* synthetic */ float field_190865_h;
    
    @Nullable
    @Override
    protected Vec3d func_190864_f() {
        if (this.entity.isInWater()) {
            final Vec3d lIlIIIIlIllIIIl = RandomPositionGenerator.func_191377_b(this.entity, 15, 7);
            return (lIlIIIIlIllIIIl == null) ? super.func_190864_f() : lIlIIIIlIllIIIl;
        }
        return (this.entity.getRNG().nextFloat() >= this.field_190865_h) ? RandomPositionGenerator.func_191377_b(this.entity, 10, 7) : super.func_190864_f();
    }
    
    public EntityAIWanderAvoidWater(final EntityCreature lIlIIIIlIlllIll, final double lIlIIIIlIlllIlI, final float lIlIIIIlIlllIIl) {
        super(lIlIIIIlIlllIll, lIlIIIIlIlllIlI);
        this.field_190865_h = lIlIIIIlIlllIIl;
    }
    
    public EntityAIWanderAvoidWater(final EntityCreature lIlIIIIllIIIIlI, final double lIlIIIIllIIIIIl) {
        this(lIlIIIIllIIIIlI, lIlIIIIllIIIIIl, 0.001f);
    }
}
