package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;

public class EntityMoveHelper
{
    protected /* synthetic */ double posY;
    protected /* synthetic */ double posZ;
    protected /* synthetic */ double speed;
    protected final /* synthetic */ EntityLiving entity;
    public /* synthetic */ Action action;
    protected /* synthetic */ float moveStrafe;
    protected /* synthetic */ float moveForward;
    protected /* synthetic */ double posX;
    
    public void strafe(final float lllllllllllllIlllIIIIlIIlIllIllI, final float lllllllllllllIlllIIIIlIIlIllIlIl) {
        this.action = Action.STRAFE;
        this.moveForward = lllllllllllllIlllIIIIlIIlIllIllI;
        this.moveStrafe = lllllllllllllIlllIIIIlIIlIllIlIl;
        this.speed = 0.25;
    }
    
    public boolean isUpdating() {
        return this.action == Action.MOVE_TO;
    }
    
    public double getX() {
        return this.posX;
    }
    
    protected float limitAngle(final float lllllllllllllIlllIIIIlIIIllllIlI, final float lllllllllllllIlllIIIIlIIIllllllI, final float lllllllllllllIlllIIIIlIIIllllIII) {
        float lllllllllllllIlllIIIIlIIIlllllII = MathHelper.wrapDegrees(lllllllllllllIlllIIIIlIIIllllllI - lllllllllllllIlllIIIIlIIIllllIlI);
        if (lllllllllllllIlllIIIIlIIIlllllII > lllllllllllllIlllIIIIlIIIllllIII) {
            lllllllllllllIlllIIIIlIIIlllllII = lllllllllllllIlllIIIIlIIIllllIII;
        }
        if (lllllllllllllIlllIIIIlIIIlllllII < -lllllllllllllIlllIIIIlIIIllllIII) {
            lllllllllllllIlllIIIIlIIIlllllII = -lllllllllllllIlllIIIIlIIIllllIII;
        }
        float lllllllllllllIlllIIIIlIIIllllIll = lllllllllllllIlllIIIIlIIIllllIlI + lllllllllllllIlllIIIIlIIIlllllII;
        if (lllllllllllllIlllIIIIlIIIllllIll < 0.0f) {
            lllllllllllllIlllIIIIlIIIllllIll += 360.0f;
        }
        else if (lllllllllllllIlllIIIIlIIIllllIll > 360.0f) {
            lllllllllllllIlllIIIIlIIIllllIll -= 360.0f;
        }
        return lllllllllllllIlllIIIIlIIIllllIll;
    }
    
    public EntityMoveHelper(final EntityLiving lllllllllllllIlllIIIIlIIllIlIlIl) {
        this.action = Action.WAIT;
        this.entity = lllllllllllllIlllIIIIlIIllIlIlIl;
    }
    
    public void read(final EntityMoveHelper lllllllllllllIlllIIIIlIIlIlIllll) {
        this.action = lllllllllllllIlllIIIIlIIlIlIllll.action;
        this.posX = lllllllllllllIlllIIIIlIIlIlIllll.posX;
        this.posY = lllllllllllllIlllIIIIlIIlIlIllll.posY;
        this.posZ = lllllllllllllIlllIIIIlIIlIlIllll.posZ;
        this.speed = Math.max(lllllllllllllIlllIIIIlIIlIlIllll.speed, 1.0);
        this.moveForward = lllllllllllllIlllIIIIlIIlIlIllll.moveForward;
        this.moveStrafe = lllllllllllllIlllIIIIlIIlIlIllll.moveStrafe;
    }
    
    public void onUpdateMoveHelper() {
        if (this.action == Action.STRAFE) {
            final float lllllllllllllIlllIIIIlIIlIlIIIIl = (float)this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
            float lllllllllllllIlllIIIIlIIlIlIIIII = (float)this.speed * lllllllllllllIlllIIIIlIIlIlIIIIl;
            float lllllllllllllIlllIIIIlIIlIIlllll = this.moveForward;
            float lllllllllllllIlllIIIIlIIlIIllllI = this.moveStrafe;
            float lllllllllllllIlllIIIIlIIlIIlllIl = MathHelper.sqrt(lllllllllllllIlllIIIIlIIlIIlllll * lllllllllllllIlllIIIIlIIlIIlllll + lllllllllllllIlllIIIIlIIlIIllllI * lllllllllllllIlllIIIIlIIlIIllllI);
            if (lllllllllllllIlllIIIIlIIlIIlllIl < 1.0f) {
                lllllllllllllIlllIIIIlIIlIIlllIl = 1.0f;
            }
            lllllllllllllIlllIIIIlIIlIIlllIl = lllllllllllllIlllIIIIlIIlIlIIIII / lllllllllllllIlllIIIIlIIlIIlllIl;
            lllllllllllllIlllIIIIlIIlIIlllll *= lllllllllllllIlllIIIIlIIlIIlllIl;
            lllllllllllllIlllIIIIlIIlIIllllI *= lllllllllllllIlllIIIIlIIlIIlllIl;
            final float lllllllllllllIlllIIIIlIIlIIlllII = MathHelper.sin(this.entity.rotationYaw * 0.017453292f);
            final float lllllllllllllIlllIIIIlIIlIIllIll = MathHelper.cos(this.entity.rotationYaw * 0.017453292f);
            final float lllllllllllllIlllIIIIlIIlIIllIlI = lllllllllllllIlllIIIIlIIlIIlllll * lllllllllllllIlllIIIIlIIlIIllIll - lllllllllllllIlllIIIIlIIlIIllllI * lllllllllllllIlllIIIIlIIlIIlllII;
            final float lllllllllllllIlllIIIIlIIlIIllIIl = lllllllllllllIlllIIIIlIIlIIllllI * lllllllllllllIlllIIIIlIIlIIllIll + lllllllllllllIlllIIIIlIIlIIlllll * lllllllllllllIlllIIIIlIIlIIlllII;
            final PathNavigate lllllllllllllIlllIIIIlIIlIIllIII = this.entity.getNavigator();
            if (lllllllllllllIlllIIIIlIIlIIllIII != null) {
                final NodeProcessor lllllllllllllIlllIIIIlIIlIIlIlll = lllllllllllllIlllIIIIlIIlIIllIII.getNodeProcessor();
                if (lllllllllllllIlllIIIIlIIlIIlIlll != null && lllllllllllllIlllIIIIlIIlIIlIlll.getPathNodeType(this.entity.world, MathHelper.floor(this.entity.posX + lllllllllllllIlllIIIIlIIlIIllIlI), MathHelper.floor(this.entity.posY), MathHelper.floor(this.entity.posZ + lllllllllllllIlllIIIIlIIlIIllIIl)) != PathNodeType.WALKABLE) {
                    this.moveForward = 1.0f;
                    this.moveStrafe = 0.0f;
                    lllllllllllllIlllIIIIlIIlIlIIIII = lllllllllllllIlllIIIIlIIlIlIIIIl;
                }
            }
            this.entity.setAIMoveSpeed(lllllllllllllIlllIIIIlIIlIlIIIII);
            this.entity.func_191989_p(this.moveForward);
            this.entity.setMoveStrafing(this.moveStrafe);
            this.action = Action.WAIT;
        }
        else if (this.action == Action.MOVE_TO) {
            this.action = Action.WAIT;
            final double lllllllllllllIlllIIIIlIIlIIlIllI = this.posX - this.entity.posX;
            final double lllllllllllllIlllIIIIlIIlIIlIlIl = this.posZ - this.entity.posZ;
            final double lllllllllllllIlllIIIIlIIlIIlIlII = this.posY - this.entity.posY;
            final double lllllllllllllIlllIIIIlIIlIIlIIll = lllllllllllllIlllIIIIlIIlIIlIllI * lllllllllllllIlllIIIIlIIlIIlIllI + lllllllllllllIlllIIIIlIIlIIlIlII * lllllllllllllIlllIIIIlIIlIIlIlII + lllllllllllllIlllIIIIlIIlIIlIlIl * lllllllllllllIlllIIIIlIIlIIlIlIl;
            if (lllllllllllllIlllIIIIlIIlIIlIIll < 2.500000277905201E-7) {
                this.entity.func_191989_p(0.0f);
                return;
            }
            final float lllllllllllllIlllIIIIlIIlIIlIIlI = (float)(MathHelper.atan2(lllllllllllllIlllIIIIlIIlIIlIlIl, lllllllllllllIlllIIIIlIIlIIlIllI) * 57.29577951308232) - 90.0f;
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, lllllllllllllIlllIIIIlIIlIIlIIlI, 90.0f);
            this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
            if (lllllllllllllIlllIIIIlIIlIIlIlII > this.entity.stepHeight && lllllllllllllIlllIIIIlIIlIIlIllI * lllllllllllllIlllIIIIlIIlIIlIllI + lllllllllllllIlllIIIIlIIlIIlIlIl * lllllllllllllIlllIIIIlIIlIIlIlIl < Math.max(1.0f, this.entity.width)) {
                this.entity.getJumpHelper().setJumping();
                this.action = Action.JUMPING;
            }
        }
        else if (this.action == Action.JUMPING) {
            this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
            if (this.entity.onGround) {
                this.action = Action.WAIT;
            }
        }
        else {
            this.entity.func_191989_p(0.0f);
        }
    }
    
    public void setMoveTo(final double lllllllllllllIlllIIIIlIIllIIIllI, final double lllllllllllllIlllIIIIlIIllIIIIII, final double lllllllllllllIlllIIIIlIIllIIIlII, final double lllllllllllllIlllIIIIlIIllIIIIll) {
        this.posX = lllllllllllllIlllIIIIlIIllIIIllI;
        this.posY = lllllllllllllIlllIIIIlIIllIIIIII;
        this.posZ = lllllllllllllIlllIIIIlIIllIIIlII;
        this.speed = lllllllllllllIlllIIIIlIIllIIIIll;
        this.action = Action.MOVE_TO;
    }
    
    public double getSpeed() {
        return this.speed;
    }
    
    public double getZ() {
        return this.posZ;
    }
    
    public double getY() {
        return this.posY;
    }
    
    public enum Action
    {
        STRAFE("STRAFE", 2), 
        JUMPING("JUMPING", 3), 
        MOVE_TO("MOVE_TO", 1), 
        WAIT("WAIT", 0);
        
        private Action(final String llllllllllllllIIlIIlllIlllIIllIl, final int llllllllllllllIIlIIlllIlllIIllII) {
        }
    }
}
