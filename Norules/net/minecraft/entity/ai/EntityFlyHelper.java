package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class EntityFlyHelper extends EntityMoveHelper
{
    public EntityFlyHelper(final EntityLiving llllllllllllllllIllIllllIIlllIlI) {
        super(llllllllllllllllIllIllllIIlllIlI);
    }
    
    @Override
    public void onUpdateMoveHelper() {
        if (this.action == Action.MOVE_TO) {
            this.action = Action.WAIT;
            this.entity.setNoGravity(true);
            final double llllllllllllllllIllIllllIIlIllIl = this.posX - this.entity.posX;
            final double llllllllllllllllIllIllllIIlIllII = this.posY - this.entity.posY;
            final double llllllllllllllllIllIllllIIlIlIll = this.posZ - this.entity.posZ;
            final double llllllllllllllllIllIllllIIlIlIlI = llllllllllllllllIllIllllIIlIllIl * llllllllllllllllIllIllllIIlIllIl + llllllllllllllllIllIllllIIlIllII * llllllllllllllllIllIllllIIlIllII + llllllllllllllllIllIllllIIlIlIll * llllllllllllllllIllIllllIIlIlIll;
            if (llllllllllllllllIllIllllIIlIlIlI < 2.500000277905201E-7) {
                this.entity.setMoveForward(0.0f);
                this.entity.func_191989_p(0.0f);
                return;
            }
            final float llllllllllllllllIllIllllIIlIlIIl = (float)(MathHelper.atan2(llllllllllllllllIllIllllIIlIlIll, llllllllllllllllIllIllllIIlIllIl) * 57.29577951308232) - 90.0f;
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, llllllllllllllllIllIllllIIlIlIIl, 10.0f);
            float llllllllllllllllIllIllllIIlIIlll = 0.0f;
            if (this.entity.onGround) {
                final float llllllllllllllllIllIllllIIlIlIII = (float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
            }
            else {
                llllllllllllllllIllIllllIIlIIlll = (float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.field_193334_e).getAttributeValue());
            }
            this.entity.setAIMoveSpeed(llllllllllllllllIllIllllIIlIIlll);
            final double llllllllllllllllIllIllllIIlIIllI = MathHelper.sqrt(llllllllllllllllIllIllllIIlIllIl * llllllllllllllllIllIllllIIlIllIl + llllllllllllllllIllIllllIIlIlIll * llllllllllllllllIllIllllIIlIlIll);
            final float llllllllllllllllIllIllllIIlIIlIl = (float)(-(MathHelper.atan2(llllllllllllllllIllIllllIIlIllII, llllllllllllllllIllIllllIIlIIllI) * 57.29577951308232));
            this.entity.rotationPitch = this.limitAngle(this.entity.rotationPitch, llllllllllllllllIllIllllIIlIIlIl, 10.0f);
            this.entity.setMoveForward((llllllllllllllllIllIllllIIlIllII > 0.0) ? llllllllllllllllIllIllllIIlIIlll : (-llllllllllllllllIllIllllIIlIIlll));
        }
        else {
            this.entity.setNoGravity(false);
            this.entity.setMoveForward(0.0f);
            this.entity.func_191989_p(0.0f);
        }
    }
}
