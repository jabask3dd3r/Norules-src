package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public class EntityAILandOnOwnersShoulder extends EntityAIBase
{
    private /* synthetic */ boolean field_192384_c;
    private final /* synthetic */ EntityShoulderRiding field_192382_a;
    private /* synthetic */ EntityPlayer field_192383_b;
    
    @Override
    public void startExecuting() {
        this.field_192383_b = (EntityPlayer)this.field_192382_a.getOwner();
        this.field_192384_c = false;
    }
    
    public EntityAILandOnOwnersShoulder(final EntityShoulderRiding lllllllllllllIlIllIlllIIIlIIIlll) {
        this.field_192382_a = lllllllllllllIlIllIlllIIIlIIIlll;
    }
    
    @Override
    public void updateTask() {
        if (!this.field_192384_c && !this.field_192382_a.isSitting() && !this.field_192382_a.getLeashed() && this.field_192382_a.getEntityBoundingBox().intersectsWith(this.field_192383_b.getEntityBoundingBox())) {
            this.field_192384_c = this.field_192382_a.func_191994_f(this.field_192383_b);
        }
    }
    
    @Override
    public boolean isInterruptible() {
        return !this.field_192384_c;
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase lllllllllllllIlIllIlllIIIIllIlll = this.field_192382_a.getOwner();
        final boolean lllllllllllllIlIllIlllIIIIllIllI = lllllllllllllIlIllIlllIIIIllIlll != null && !((EntityPlayer)lllllllllllllIlIllIlllIIIIllIlll).isSpectator() && !((EntityPlayer)lllllllllllllIlIllIlllIIIIllIlll).capabilities.isFlying && !lllllllllllllIlIllIlllIIIIllIlll.isInWater();
        return !this.field_192382_a.isSitting() && lllllllllllllIlIllIlllIIIIllIllI && this.field_192382_a.func_191995_du();
    }
}
