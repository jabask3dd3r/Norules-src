package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityAIBeg extends EntityAIBase
{
    private final /* synthetic */ World worldObject;
    private /* synthetic */ int timeoutCounter;
    private final /* synthetic */ float minPlayerDistance;
    private final /* synthetic */ EntityWolf theWolf;
    private /* synthetic */ EntityPlayer thePlayer;
    
    public EntityAIBeg(final EntityWolf lIIlIIlllIllII, final float lIIlIIlllIlIll) {
        this.theWolf = lIIlIIlllIllII;
        this.worldObject = lIIlIIlllIllII.world;
        this.minPlayerDistance = lIIlIIlllIlIll;
        this.setMutexBits(2);
    }
    
    @Override
    public boolean shouldExecute() {
        this.thePlayer = this.worldObject.getClosestPlayerToEntity(this.theWolf, this.minPlayerDistance);
        return this.thePlayer != null && this.hasPlayerGotBoneInHand(this.thePlayer);
    }
    
    @Override
    public void updateTask() {
        this.theWolf.getLookHelper().setLookPosition(this.thePlayer.posX, this.thePlayer.posY + this.thePlayer.getEyeHeight(), this.thePlayer.posZ, 10.0f, (float)this.theWolf.getVerticalFaceSpeed());
        --this.timeoutCounter;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.thePlayer.isEntityAlive() && this.theWolf.getDistanceSqToEntity(this.thePlayer) <= this.minPlayerDistance * this.minPlayerDistance && (this.timeoutCounter > 0 && this.hasPlayerGotBoneInHand(this.thePlayer));
    }
    
    private boolean hasPlayerGotBoneInHand(final EntityPlayer lIIlIIllIIllll) {
        final char lIIlIIllIIlIll;
        final Exception lIIlIIllIIllII = (Exception)((EnumHand[])(Object)(lIIlIIllIIlIll = (char)(Object)EnumHand.values())).length;
        for (float lIIlIIllIIllIl = 0; lIIlIIllIIllIl < lIIlIIllIIllII; ++lIIlIIllIIllIl) {
            final EnumHand lIIlIIllIlIIlI = lIIlIIllIIlIll[lIIlIIllIIllIl];
            final ItemStack lIIlIIllIlIIIl = lIIlIIllIIllll.getHeldItem(lIIlIIllIlIIlI);
            if (this.theWolf.isTamed() && lIIlIIllIlIIIl.getItem() == Items.BONE) {
                return true;
            }
            if (this.theWolf.isBreedingItem(lIIlIIllIlIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void startExecuting() {
        this.theWolf.setBegging(true);
        this.timeoutCounter = 40 + this.theWolf.getRNG().nextInt(40);
    }
    
    @Override
    public void resetTask() {
        this.theWolf.setBegging(false);
        this.thePlayer = null;
    }
}
