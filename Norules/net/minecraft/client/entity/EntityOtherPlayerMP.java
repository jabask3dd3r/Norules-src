package net.minecraft.client.entity;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import com.mojang.authlib.*;
import net.minecraft.util.text.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class EntityOtherPlayerMP extends AbstractClientPlayer
{
    private /* synthetic */ double otherPlayerMPX;
    private /* synthetic */ int otherPlayerMPPosRotationIncrements;
    private /* synthetic */ double otherPlayerMPYaw;
    private /* synthetic */ double otherPlayerMPPitch;
    private /* synthetic */ double otherPlayerMPY;
    private /* synthetic */ double otherPlayerMPZ;
    
    @Override
    public void setPositionAndRotationDirect(final double lllllllllllllIIlIIllIIIllIIlllIl, final double lllllllllllllIIlIIllIIIllIIlllII, final double lllllllllllllIIlIIllIIIllIlIIIll, final float lllllllllllllIIlIIllIIIllIlIIIlI, final float lllllllllllllIIlIIllIIIllIIllIIl, final int lllllllllllllIIlIIllIIIllIIllIII, final boolean lllllllllllllIIlIIllIIIllIIlllll) {
        this.otherPlayerMPX = lllllllllllllIIlIIllIIIllIIlllIl;
        this.otherPlayerMPY = lllllllllllllIIlIIllIIIllIIlllII;
        this.otherPlayerMPZ = lllllllllllllIIlIIllIIIllIlIIIll;
        this.otherPlayerMPYaw = lllllllllllllIIlIIllIIIllIlIIIlI;
        this.otherPlayerMPPitch = lllllllllllllIIlIIllIIIllIIllIIl;
        this.otherPlayerMPPosRotationIncrements = lllllllllllllIIlIIllIIIllIIllIII;
    }
    
    @Override
    public void onUpdate() {
        this.renderOffsetY = 0.0f;
        super.onUpdate();
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double lllllllllllllIIlIIllIIIllIIlIIlI = this.posX - this.prevPosX;
        final double lllllllllllllIIlIIllIIIllIIlIIIl = this.posZ - this.prevPosZ;
        float lllllllllllllIIlIIllIIIllIIlIIII = MathHelper.sqrt(lllllllllllllIIlIIllIIIllIIlIIlI * lllllllllllllIIlIIllIIIllIIlIIlI + lllllllllllllIIlIIllIIIllIIlIIIl * lllllllllllllIIlIIllIIIllIIlIIIl) * 4.0f;
        if (lllllllllllllIIlIIllIIIllIIlIIII > 1.0f) {
            lllllllllllllIIlIIllIIIllIIlIIII = 1.0f;
        }
        this.limbSwingAmount += (lllllllllllllIIlIIllIIIllIIlIIII - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.otherPlayerMPPosRotationIncrements > 0) {
            final double lllllllllllllIIlIIllIIIllIIIIlII = this.posX + (this.otherPlayerMPX - this.posX) / this.otherPlayerMPPosRotationIncrements;
            final double lllllllllllllIIlIIllIIIllIIIIIll = this.posY + (this.otherPlayerMPY - this.posY) / this.otherPlayerMPPosRotationIncrements;
            final double lllllllllllllIIlIIllIIIllIIIIIlI = this.posZ + (this.otherPlayerMPZ - this.posZ) / this.otherPlayerMPPosRotationIncrements;
            double lllllllllllllIIlIIllIIIllIIIIIIl;
            for (lllllllllllllIIlIIllIIIllIIIIIIl = this.otherPlayerMPYaw - this.rotationYaw; lllllllllllllIIlIIllIIIllIIIIIIl < -180.0; lllllllllllllIIlIIllIIIllIIIIIIl += 360.0) {}
            while (lllllllllllllIIlIIllIIIllIIIIIIl >= 180.0) {
                lllllllllllllIIlIIllIIIllIIIIIIl -= 360.0;
            }
            this.rotationYaw += (float)(lllllllllllllIIlIIllIIIllIIIIIIl / this.otherPlayerMPPosRotationIncrements);
            this.rotationPitch += (float)((this.otherPlayerMPPitch - this.rotationPitch) / this.otherPlayerMPPosRotationIncrements);
            --this.otherPlayerMPPosRotationIncrements;
            this.setPosition(lllllllllllllIIlIIllIIIllIIIIlII, lllllllllllllIIlIIllIIIllIIIIIll, lllllllllllllIIlIIllIIIllIIIIIlI);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        this.prevCameraYaw = this.cameraYaw;
        this.updateArmSwingProgress();
        float lllllllllllllIIlIIllIIIllIIIIIII = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float lllllllllllllIIlIIllIIIlIlllllll = (float)Math.atan(-this.motionY * 0.20000000298023224) * 15.0f;
        if (lllllllllllllIIlIIllIIIllIIIIIII > 0.1f) {
            lllllllllllllIIlIIllIIIllIIIIIII = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            lllllllllllllIIlIIllIIIllIIIIIII = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            lllllllllllllIIlIIllIIIlIlllllll = 0.0f;
        }
        this.cameraYaw += (lllllllllllllIIlIIllIIIllIIIIIII - this.cameraYaw) * 0.4f;
        this.cameraPitch += (lllllllllllllIIlIIllIIIlIlllllll - this.cameraPitch) * 0.8f;
        this.world.theProfiler.startSection("push");
        this.collideWithNearbyEntities();
        this.world.theProfiler.endSection();
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllIIlIIllIIIlIlllIIll, final String lllllllllllllIIlIIllIIIlIlllIIlI) {
        return false;
    }
    
    public EntityOtherPlayerMP(final World lllllllllllllIIlIIllIIIllIlllIll, final GameProfile lllllllllllllIIlIIllIIIllIllllIl) {
        super(lllllllllllllIIlIIllIIIllIlllIll, lllllllllllllIIlIIllIIIllIllllIl);
        this.stepHeight = 1.0f;
        this.noClip = true;
        this.renderOffsetY = 0.25f;
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllllIIlIIllIIIlIlllIllI) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(lllllllllllllIIlIIllIIIlIlllIllI);
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllIIlIIllIIIllIllIIlI) {
        double lllllllllllllIIlIIllIIIllIllIlII = this.getEntityBoundingBox().getAverageEdgeLength() * 10.0;
        if (Double.isNaN(lllllllllllllIIlIIllIIIllIllIlII)) {
            lllllllllllllIIlIIllIIIllIllIlII = 1.0;
        }
        lllllllllllllIIlIIllIIIllIllIlII = lllllllllllllIIlIIllIIIllIllIlII * 64.0 * getRenderDistanceWeight();
        return lllllllllllllIIlIIllIIIllIllIIlI < lllllllllllllIIlIIllIIIllIllIlII * lllllllllllllIIlIIllIIIllIllIlII;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIlIIllIIIllIlIllll, final float lllllllllllllIIlIIllIIIllIlIlllI) {
        return true;
    }
}
