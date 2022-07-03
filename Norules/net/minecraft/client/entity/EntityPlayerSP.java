package net.minecraft.client.entity;

import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.network.*;
import me.nrules.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.inventory.*;
import net.minecraft.network.datasync.*;
import me.nrules.module.player.*;
import net.minecraft.util.text.*;
import net.minecraft.stats.*;
import net.minecraft.item.crafting.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.audio.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.gui.inventory.*;
import me.nrules.event.events.*;
import net.minecraft.client.gui.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import me.nrules.module.*;
import net.minecraft.network.play.client.*;

public class EntityPlayerSP extends AbstractClientPlayer
{
    private /* synthetic */ boolean rowingBoat;
    public /* synthetic */ int sprintingTicksLeft;
    public /* synthetic */ float timeInPortal;
    private /* synthetic */ EnumHand activeHand;
    public /* synthetic */ MovementInput movementInput;
    private /* synthetic */ float PreYaw;
    private /* synthetic */ float horseJumpPower;
    private /* synthetic */ boolean autoJumpEnabled;
    public /* synthetic */ float prevRenderArmYaw;
    protected /* synthetic */ Minecraft mc;
    private /* synthetic */ int positionUpdateTicks;
    private /* synthetic */ float lastReportedPitch;
    public /* synthetic */ float prevRenderArmPitch;
    private /* synthetic */ float lastReportedYaw;
    private /* synthetic */ float PrePitch;
    private final /* synthetic */ StatisticsManager statWriter;
    public /* synthetic */ double lastReportedPosY;
    private /* synthetic */ String serverBrand;
    private /* synthetic */ LPosition location;
    protected /* synthetic */ int sprintToggleTimer;
    private /* synthetic */ boolean handActive;
    private /* synthetic */ int autoJumpTime;
    public /* synthetic */ float renderArmPitch;
    public /* synthetic */ float renderArmYaw;
    private /* synthetic */ double lastReportedPosZ;
    public final /* synthetic */ NetHandlerPlayClient connection;
    private /* synthetic */ double lastReportedPosX;
    private /* synthetic */ boolean prevOnGround;
    private /* synthetic */ boolean hasValidHealth;
    public /* synthetic */ float prevTimeInPortal;
    private /* synthetic */ int permissionLevel;
    private final /* synthetic */ RecipeBook field_192036_cb;
    private /* synthetic */ boolean serverSprintState;
    private /* synthetic */ int horseJumpPowerCounter;
    private /* synthetic */ boolean serverSneakState;
    private /* synthetic */ boolean wasFallFlying;
    
    @Override
    public void updateRidden() {
        super.updateRidden();
        this.rowingBoat = false;
        if (this.getRidingEntity() instanceof EntityBoat) {
            final EntityBoat lllllllllllllIllIlIIIIIIIIIIllIl = (EntityBoat)this.getRidingEntity();
            lllllllllllllIllIlIIIIIIIIIIllIl.updateInputs(this.movementInput.leftKeyDown, this.movementInput.rightKeyDown, this.movementInput.forwardKeyDown, this.movementInput.backKeyDown);
            this.rowingBoat |= (this.movementInput.leftKeyDown || this.movementInput.rightKeyDown || this.movementInput.forwardKeyDown || this.movementInput.backKeyDown);
        }
    }
    
    @Override
    public void displayGuiCommandBlock(final TileEntityCommandBlock lllllllllllllIllIlIIIIIIIllllIII) {
        this.mc.displayGuiScreen(new GuiCommandBlock(lllllllllllllIllIlIIIIIIIllllIII));
    }
    
    @Override
    public boolean canCommandSenderUseCommand(final int lllllllllllllIllIlIIIIIIllIIIlIl, final String lllllllllllllIllIlIIIIIIllIIIlll) {
        return lllllllllllllIllIlIIIIIIllIIIlIl <= this.getPermissionLevel();
    }
    
    private boolean isOpenBlockSpace(final BlockPos lllllllllllllIllIlIIIIIIlllIIlII) {
        return !this.world.getBlockState(lllllllllllllIllIlIIIIIIlllIIlII).isNormalCube() && !this.world.getBlockState(lllllllllllllIllIlIIIIIIlllIIlII.up()).isNormalCube();
    }
    
    @Override
    public void openEditSign(final TileEntitySign lllllllllllllIllIlIIIIIIlIIIIIlI) {
        this.mc.displayGuiScreen(new GuiEditSign(lllllllllllllIllIlIIIIIIlIIIIIlI));
    }
    
    public float getHorseJumpPower() {
        return this.horseJumpPower;
    }
    
    protected void sendHorseJump() {
        this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_RIDING_JUMP, MathHelper.floor(this.getHorseJumpPower() * 100.0f)));
    }
    
    @Override
    public void onLivingUpdate() {
        ++this.sprintingTicksLeft;
        if (this.sprintToggleTimer > 0) {
            --this.sprintToggleTimer;
        }
        this.prevTimeInPortal = this.timeInPortal;
        if (this.inPortal) {
            if (this.mc.currentScreen != null && !this.mc.currentScreen.doesGuiPauseGame()) {
                if (this.mc.currentScreen instanceof GuiContainer) {
                    this.closeScreen();
                }
                this.mc.displayGuiScreen(null);
            }
            if (this.timeInPortal == 0.0f) {
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.BLOCK_PORTAL_TRIGGER, this.rand.nextFloat() * 0.4f + 0.8f));
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
            }
            this.inPortal = false;
        }
        else if (this.isPotionActive(MobEffects.NAUSEA) && this.getActivePotionEffect(MobEffects.NAUSEA).getDuration() > 60) {
            this.timeInPortal += 0.006666667f;
            if (this.timeInPortal > 1.0f) {
                this.timeInPortal = 1.0f;
            }
        }
        else {
            if (this.timeInPortal > 0.0f) {
                this.timeInPortal -= 0.05f;
            }
            if (this.timeInPortal < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
        final boolean lllllllllllllIllIlIIIIIIIIlIIIlI = this.movementInput.jump;
        final boolean lllllllllllllIllIlIIIIIIIIlIIIIl = this.movementInput.sneak;
        final float lllllllllllllIllIlIIIIIIIIlIIIII = 0.8f;
        final boolean lllllllllllllIllIlIIIIIIIIIlllll = this.movementInput.field_192832_b >= 0.8f;
        this.movementInput.updatePlayerMoveState();
        this.mc.func_193032_ao().func_193293_a(this.movementInput);
        if (this.isHandActive() && !this.isRiding() && !Main.moduleManager.getModuleByName("NoSlowDown").isToggled()) {
            MovementInput.moveStrafe *= 0.2f;
            final MovementInput movementInput = this.movementInput;
            movementInput.field_192832_b *= 0.2f;
            this.sprintToggleTimer = 0;
        }
        boolean lllllllllllllIllIlIIIIIIIIIllllI = false;
        if (this.autoJumpTime > 0) {
            --this.autoJumpTime;
            lllllllllllllIllIlIIIIIIIIIllllI = true;
            this.movementInput.jump = true;
        }
        final AxisAlignedBB lllllllllllllIllIlIIIIIIIIIlllIl = this.getEntityBoundingBox();
        this.pushOutOfBlocks(this.posX - this.width * 0.35, lllllllllllllIllIlIIIIIIIIIlllIl.minY + 0.5, this.posZ + this.width * 0.35);
        this.pushOutOfBlocks(this.posX - this.width * 0.35, lllllllllllllIllIlIIIIIIIIIlllIl.minY + 0.5, this.posZ - this.width * 0.35);
        this.pushOutOfBlocks(this.posX + this.width * 0.35, lllllllllllllIllIlIIIIIIIIIlllIl.minY + 0.5, this.posZ - this.width * 0.35);
        this.pushOutOfBlocks(this.posX + this.width * 0.35, lllllllllllllIllIlIIIIIIIIIlllIl.minY + 0.5, this.posZ + this.width * 0.35);
        final boolean lllllllllllllIllIlIIIIIIIIIlllII = this.getFoodStats().getFoodLevel() > 6.0f || this.capabilities.allowFlying;
        if (this.onGround && !lllllllllllllIllIlIIIIIIIIlIIIIl && !lllllllllllllIllIlIIIIIIIIIlllll && this.movementInput.field_192832_b >= 0.8f && !this.isSprinting() && lllllllllllllIllIlIIIIIIIIIlllII && !this.isHandActive() && !this.isPotionActive(MobEffects.BLINDNESS)) {
            if (this.sprintToggleTimer <= 0 && !this.mc.gameSettings.keyBindSprint.isKeyDown()) {
                this.sprintToggleTimer = 7;
            }
            else {
                this.setSprinting(true);
            }
        }
        if (!this.isSprinting() && this.movementInput.field_192832_b >= 0.8f && lllllllllllllIllIlIIIIIIIIIlllII && !this.isHandActive() && !this.isPotionActive(MobEffects.BLINDNESS) && this.mc.gameSettings.keyBindSprint.isKeyDown()) {
            this.setSprinting(true);
        }
        if (this.isSprinting() && (this.movementInput.field_192832_b < 0.8f || this.isCollidedHorizontally || !lllllllllllllIllIlIIIIIIIIIlllII)) {
            this.setSprinting(false);
        }
        if (this.capabilities.allowFlying) {
            if (this.mc.playerController.isSpectatorMode()) {
                if (!this.capabilities.isFlying) {
                    this.capabilities.isFlying = true;
                    this.sendPlayerAbilities();
                }
            }
            else if (!lllllllllllllIllIlIIIIIIIIlIIIlI && this.movementInput.jump && !lllllllllllllIllIlIIIIIIIIIllllI) {
                if (this.flyToggleTimer == 0) {
                    this.flyToggleTimer = 7;
                }
                else {
                    this.capabilities.isFlying = !this.capabilities.isFlying;
                    this.sendPlayerAbilities();
                    this.flyToggleTimer = 0;
                }
            }
        }
        if (this.movementInput.jump && !lllllllllllllIllIlIIIIIIIIlIIIlI && !this.onGround && this.motionY < 0.0 && !this.isElytraFlying() && !this.capabilities.isFlying) {
            final ItemStack lllllllllllllIllIlIIIIIIIIIllIll = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (lllllllllllllIllIlIIIIIIIIIllIll.getItem() == Items.ELYTRA && ItemElytra.isBroken(lllllllllllllIllIlIIIIIIIIIllIll)) {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_FALL_FLYING));
            }
        }
        this.wasFallFlying = this.isElytraFlying();
        if (this.capabilities.isFlying && this.isCurrentViewEntity()) {
            if (this.movementInput.sneak) {
                MovementInput.moveStrafe /= (float)0.3;
                this.movementInput.field_192832_b /= (float)0.3;
                this.motionY -= this.capabilities.getFlySpeed() * 3.0f;
            }
            if (this.movementInput.jump) {
                this.motionY += this.capabilities.getFlySpeed() * 3.0f;
            }
        }
        if (this.isRidingHorse()) {
            final IJumpingMount lllllllllllllIllIlIIIIIIIIIllIlI = (IJumpingMount)this.getRidingEntity();
            if (this.horseJumpPowerCounter < 0) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter == 0) {
                    this.horseJumpPower = 0.0f;
                }
            }
            if (lllllllllllllIllIlIIIIIIIIlIIIlI && !this.movementInput.jump) {
                this.horseJumpPowerCounter = -10;
                lllllllllllllIllIlIIIIIIIIIllIlI.setJumpPower(MathHelper.floor(this.getHorseJumpPower() * 100.0f));
                this.sendHorseJump();
            }
            else if (!lllllllllllllIllIlIIIIIIIIlIIIlI && this.movementInput.jump) {
                this.horseJumpPowerCounter = 0;
                this.horseJumpPower = 0.0f;
            }
            else if (lllllllllllllIllIlIIIIIIIIlIIIlI) {
                ++this.horseJumpPowerCounter;
                if (this.horseJumpPowerCounter < 10) {
                    this.horseJumpPower = this.horseJumpPowerCounter * 0.1f;
                }
                else {
                    this.horseJumpPower = 0.8f + 2.0f / (this.horseJumpPowerCounter - 9) * 0.1f;
                }
            }
        }
        else {
            this.horseJumpPower = 0.0f;
        }
        super.onLivingUpdate();
        if (this.onGround && this.capabilities.isFlying && !this.mc.playerController.isSpectatorMode()) {
            this.capabilities.isFlying = false;
            this.sendPlayerAbilities();
        }
    }
    
    public float[] getRotations() {
        return new float[] { this.rotationYaw, this.rotationPitch };
    }
    
    @Override
    public void respawnPlayer() {
        this.connection.sendPacket(new CPacketClientStatus(CPacketClientStatus.State.PERFORM_RESPAWN));
    }
    
    public void setHeadRotations(final float[] lllllllllllllIllIlIIIIIllIllllIl) {
        this.setHeadRotations(lllllllllllllIllIlIIIIIllIllllIl[0], lllllllllllllIllIlIIIIIllIllllIl[1]);
    }
    
    public void closeScreenAndDropStack() {
        this.inventory.setItemStack(ItemStack.field_190927_a);
        super.closeScreen();
        this.mc.displayGuiScreen(null);
    }
    
    public void setPlayerSPHealth(final float lllllllllllllIllIlIIIIIlIlIIIIll) {
        if (this.hasValidHealth) {
            final float lllllllllllllIllIlIIIIIlIlIIIlIl = this.getHealth() - lllllllllllllIllIlIIIIIlIlIIIIll;
            if (lllllllllllllIllIlIIIIIlIlIIIlIl <= 0.0f) {
                this.setHealth(lllllllllllllIllIlIIIIIlIlIIIIll);
                if (lllllllllllllIllIlIIIIIlIlIIIlIl < 0.0f) {
                    this.hurtResistantTime = this.maxHurtResistantTime / 2;
                }
            }
            else {
                this.lastDamage = lllllllllllllIllIlIIIIIlIlIIIlIl;
                this.setHealth(this.getHealth());
                this.hurtResistantTime = this.maxHurtResistantTime;
                this.damageEntity(DamageSource.generic, lllllllllllllIllIlIIIIIlIlIIIlIl);
                this.maxHurtTime = 10;
                this.hurtTime = this.maxHurtTime;
            }
        }
        else {
            this.setHealth(lllllllllllllIllIlIIIIIlIlIIIIll);
            this.hasValidHealth = true;
        }
    }
    
    @Override
    public void displayVillagerTradeGui(final IMerchant lllllllllllllIllIlIIIIIIIlIIIlIl) {
        this.mc.displayGuiScreen(new GuiMerchant(this.inventory, lllllllllllllIllIlIIIIIIIlIIIlIl, this.world));
    }
    
    @Nullable
    @Override
    public PotionEffect removeActivePotionEffect(@Nullable final Potion lllllllllllllIllIlIIIIIIIIIIIIlI) {
        if (lllllllllllllIllIlIIIIIIIIIIIIlI == MobEffects.NAUSEA) {
            this.prevTimeInPortal = 0.0f;
            this.timeInPortal = 0.0f;
        }
        return super.removeActivePotionEffect(lllllllllllllIllIlIIIIIIIIIIIIlI);
    }
    
    public void setPermissionLevel(final int lllllllllllllIllIlIIIIIlIIIlIIll) {
        this.permissionLevel = lllllllllllllIllIlIIIIIlIIIlIIll;
    }
    
    protected void updateAutoJump(final float lllllllllllllIllIIlllllllIlllIlI, final float lllllllllllllIllIIlllllllIIIlIlI) {
        if (this.isAutoJumpEnabled() && this.autoJumpTime <= 0 && this.onGround && !this.isSneaking() && !this.isRiding()) {
            final Vec2f lllllllllllllIllIIlllllllIlllIII = this.movementInput.getMoveVector();
            if (lllllllllllllIllIIlllllllIlllIII.x != 0.0f || lllllllllllllIllIIlllllllIlllIII.y != 0.0f) {
                final Vec3d lllllllllllllIllIIlllllllIllIlll = new Vec3d(this.posX, this.getEntityBoundingBox().minY, this.posZ);
                final double lllllllllllllIllIIlllllllIllIllI = this.posX + lllllllllllllIllIIlllllllIlllIlI;
                final double lllllllllllllIllIIlllllllIllIlIl = this.posZ + lllllllllllllIllIIlllllllIIIlIlI;
                final Vec3d lllllllllllllIllIIlllllllIllIlII = new Vec3d(lllllllllllllIllIIlllllllIllIllI, this.getEntityBoundingBox().minY, lllllllllllllIllIIlllllllIllIlIl);
                Vec3d lllllllllllllIllIIlllllllIllIIll = new Vec3d(lllllllllllllIllIIlllllllIlllIlI, 0.0, lllllllllllllIllIIlllllllIIIlIlI);
                final float lllllllllllllIllIIlllllllIllIIlI = this.getAIMoveSpeed();
                float lllllllllllllIllIIlllllllIllIIIl = (float)lllllllllllllIllIIlllllllIllIIll.lengthSquared();
                if (lllllllllllllIllIIlllllllIllIIIl <= 0.001f) {
                    final float lllllllllllllIllIIlllllllIllIIII = lllllllllllllIllIIlllllllIllIIlI * lllllllllllllIllIIlllllllIlllIII.x;
                    final float lllllllllllllIllIIlllllllIlIllll = lllllllllllllIllIIlllllllIllIIlI * lllllllllllllIllIIlllllllIlllIII.y;
                    final float lllllllllllllIllIIlllllllIlIlllI = MathHelper.sin(this.rotationYaw * 0.017453292f);
                    final float lllllllllllllIllIIlllllllIlIllIl = MathHelper.cos(this.rotationYaw * 0.017453292f);
                    lllllllllllllIllIIlllllllIllIIll = new Vec3d(lllllllllllllIllIIlllllllIllIIII * lllllllllllllIllIIlllllllIlIllIl - lllllllllllllIllIIlllllllIlIllll * lllllllllllllIllIIlllllllIlIlllI, lllllllllllllIllIIlllllllIllIIll.yCoord, lllllllllllllIllIIlllllllIlIllll * lllllllllllllIllIIlllllllIlIllIl + lllllllllllllIllIIlllllllIllIIII * lllllllllllllIllIIlllllllIlIlllI);
                    lllllllllllllIllIIlllllllIllIIIl = (float)lllllllllllllIllIIlllllllIllIIll.lengthSquared();
                    if (lllllllllllllIllIIlllllllIllIIIl <= 0.001f) {
                        return;
                    }
                }
                final float lllllllllllllIllIIlllllllIlIllII = (float)MathHelper.fastInvSqrt(lllllllllllllIllIIlllllllIllIIIl);
                final Vec3d lllllllllllllIllIIlllllllIlIlIll = lllllllllllllIllIIlllllllIllIIll.scale(lllllllllllllIllIIlllllllIlIllII);
                final Vec3d lllllllllllllIllIIlllllllIlIlIlI = this.getForward();
                final float lllllllllllllIllIIlllllllIlIlIIl = (float)(lllllllllllllIllIIlllllllIlIlIlI.xCoord * lllllllllllllIllIIlllllllIlIlIll.xCoord + lllllllllllllIllIIlllllllIlIlIlI.zCoord * lllllllllllllIllIIlllllllIlIlIll.zCoord);
                if (lllllllllllllIllIIlllllllIlIlIIl >= -0.15f) {
                    BlockPos lllllllllllllIllIIlllllllIlIlIII = new BlockPos(this.posX, this.getEntityBoundingBox().maxY, this.posZ);
                    final IBlockState lllllllllllllIllIIlllllllIlIIlll = this.world.getBlockState(lllllllllllllIllIIlllllllIlIlIII);
                    if (lllllllllllllIllIIlllllllIlIIlll.getCollisionBoundingBox(this.world, lllllllllllllIllIIlllllllIlIlIII) == null) {
                        lllllllllllllIllIIlllllllIlIlIII = lllllllllllllIllIIlllllllIlIlIII.up();
                        final IBlockState lllllllllllllIllIIlllllllIlIIllI = this.world.getBlockState(lllllllllllllIllIIlllllllIlIlIII);
                        if (lllllllllllllIllIIlllllllIlIIllI.getCollisionBoundingBox(this.world, lllllllllllllIllIIlllllllIlIlIII) == null) {
                            final float lllllllllllllIllIIlllllllIlIIlIl = 7.0f;
                            float lllllllllllllIllIIlllllllIlIIlII = 1.2f;
                            if (this.isPotionActive(MobEffects.JUMP_BOOST)) {
                                lllllllllllllIllIIlllllllIlIIlII += (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.75f;
                            }
                            final float lllllllllllllIllIIlllllllIlIIIll = Math.max(lllllllllllllIllIIlllllllIllIIlI * 7.0f, 1.0f / lllllllllllllIllIIlllllllIlIllII);
                            Vec3d lllllllllllllIllIIlllllllIlIIIlI = lllllllllllllIllIIlllllllIllIlII.add(lllllllllllllIllIIlllllllIlIlIll.scale(lllllllllllllIllIIlllllllIlIIIll));
                            final float lllllllllllllIllIIlllllllIlIIIIl = this.width;
                            final float lllllllllllllIllIIlllllllIlIIIII = this.height;
                            final AxisAlignedBB lllllllllllllIllIIlllllllIIlllll = new AxisAlignedBB(lllllllllllllIllIIlllllllIllIlll, lllllllllllllIllIIlllllllIlIIIlI.addVector(0.0, lllllllllllllIllIIlllllllIlIIIII, 0.0)).expand(lllllllllllllIllIIlllllllIlIIIIl, 0.0, lllllllllllllIllIIlllllllIlIIIIl);
                            final Vec3d lllllllllllllIllIIlllllllIIllllI = lllllllllllllIllIIlllllllIllIlll.addVector(0.0, 0.5099999904632568, 0.0);
                            lllllllllllllIllIIlllllllIlIIIlI = lllllllllllllIllIIlllllllIlIIIlI.addVector(0.0, 0.5099999904632568, 0.0);
                            final Vec3d lllllllllllllIllIIlllllllIIlllIl = lllllllllllllIllIIlllllllIlIlIll.crossProduct(new Vec3d(0.0, 1.0, 0.0));
                            final Vec3d lllllllllllllIllIIlllllllIIlllII = lllllllllllllIllIIlllllllIIlllIl.scale(lllllllllllllIllIIlllllllIlIIIIl * 0.5f);
                            final Vec3d lllllllllllllIllIIlllllllIIllIll = lllllllllllllIllIIlllllllIIllllI.subtract(lllllllllllllIllIIlllllllIIlllII);
                            final Vec3d lllllllllllllIllIIlllllllIIllIlI = lllllllllllllIllIIlllllllIlIIIlI.subtract(lllllllllllllIllIIlllllllIIlllII);
                            final Vec3d lllllllllllllIllIIlllllllIIllIIl = lllllllllllllIllIIlllllllIIllllI.add(lllllllllllllIllIIlllllllIIlllII);
                            final Vec3d lllllllllllllIllIIlllllllIIllIII = lllllllllllllIllIIlllllllIlIIIlI.add(lllllllllllllIllIIlllllllIIlllII);
                            final List<AxisAlignedBB> lllllllllllllIllIIlllllllIIlIlll = this.world.getCollisionBoxes(this, lllllllllllllIllIIlllllllIIlllll);
                            if (!lllllllllllllIllIIlllllllIIlIlll.isEmpty()) {}
                            float lllllllllllllIllIIlllllllIIlIllI = Float.MIN_VALUE;
                            for (final AxisAlignedBB lllllllllllllIllIIlllllllIIlIlIl : lllllllllllllIllIIlllllllIIlIlll) {
                                if (lllllllllllllIllIIlllllllIIlIlIl.intersects(lllllllllllllIllIIlllllllIIllIll, lllllllllllllIllIIlllllllIIllIlI) || lllllllllllllIllIIlllllllIIlIlIl.intersects(lllllllllllllIllIIlllllllIIllIIl, lllllllllllllIllIIlllllllIIllIII)) {
                                    lllllllllllllIllIIlllllllIIlIllI = (float)lllllllllllllIllIIlllllllIIlIlIl.maxY;
                                    final Vec3d lllllllllllllIllIIlllllllIIlIlII = lllllllllllllIllIIlllllllIIlIlIl.getCenter();
                                    final BlockPos lllllllllllllIllIIlllllllIIlIIll = new BlockPos(lllllllllllllIllIIlllllllIIlIlII);
                                    for (int lllllllllllllIllIIlllllllIIlIIlI = 1; lllllllllllllIllIIlllllllIIlIIlI < lllllllllllllIllIIlllllllIlIIlII; ++lllllllllllllIllIIlllllllIIlIIlI) {
                                        final BlockPos lllllllllllllIllIIlllllllIIlIIIl = lllllllllllllIllIIlllllllIIlIIll.up(lllllllllllllIllIIlllllllIIlIIlI);
                                        final IBlockState lllllllllllllIllIIlllllllIIlIIII = this.world.getBlockState(lllllllllllllIllIIlllllllIIlIIIl);
                                        final AxisAlignedBB lllllllllllllIllIIlllllllIIIllll;
                                        if ((lllllllllllllIllIIlllllllIIIllll = lllllllllllllIllIIlllllllIIlIIII.getCollisionBoundingBox(this.world, lllllllllllllIllIIlllllllIIlIIIl)) != null) {
                                            lllllllllllllIllIIlllllllIIlIllI = (float)lllllllllllllIllIIlllllllIIIllll.maxY + lllllllllllllIllIIlllllllIIlIIIl.getY();
                                            if (lllllllllllllIllIIlllllllIIlIllI - this.getEntityBoundingBox().minY > lllllllllllllIllIIlllllllIlIIlII) {
                                                return;
                                            }
                                        }
                                        if (lllllllllllllIllIIlllllllIIlIIlI > 1) {
                                            lllllllllllllIllIIlllllllIlIlIII = lllllllllllllIllIIlllllllIlIlIII.up();
                                            final IBlockState lllllllllllllIllIIlllllllIIIlllI = this.world.getBlockState(lllllllllllllIllIIlllllllIlIlIII);
                                            if (lllllllllllllIllIIlllllllIIIlllI.getCollisionBoundingBox(this.world, lllllllllllllIllIIlllllllIlIlIII) != null) {
                                                return;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                            if (lllllllllllllIllIIlllllllIIlIllI != Float.MIN_VALUE) {
                                final float lllllllllllllIllIIlllllllIIIllIl = (float)(lllllllllllllIllIIlllllllIIlIllI - this.getEntityBoundingBox().minY);
                                if (lllllllllllllIllIIlllllllIIIllIl > 0.5f && lllllllllllllIllIIlllllllIIIllIl <= lllllllllllllIllIIlllllllIlIIlII) {
                                    this.autoJumpTime = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public Vec3d getLook(final float lllllllllllllIllIlIIIIIllIlIIllI) {
        return this.getVectorForRotation(this.rotationPitch, this.rotationYaw);
    }
    
    @Override
    public void playSound(final SoundEvent lllllllllllllIllIlIIIIIIlIllIllI, final float lllllllllllllIllIlIIIIIIlIllIlIl, final float lllllllllllllIllIlIIIIIIlIllIlII) {
        this.world.playSound(this.posX, this.posY, this.posZ, lllllllllllllIllIlIIIIIIlIllIllI, this.getSoundCategory(), lllllllllllllIllIlIIIIIIlIllIlIl, lllllllllllllIllIlIIIIIIlIllIlII, false);
    }
    
    @Override
    public EnumHand getActiveHand() {
        return this.activeHand;
    }
    
    @Override
    public void dismountRidingEntity() {
        super.dismountRidingEntity();
        this.rowingBoat = false;
    }
    
    public int getPermissionLevel() {
        return this.permissionLevel;
    }
    
    public boolean isRowingBoat() {
        return this.rowingBoat;
    }
    
    @Override
    public void openGuiHorseInventory(final AbstractHorse lllllllllllllIllIlIIIIIIIlIllIII, final IInventory lllllllllllllIllIlIIIIIIIlIlIlII) {
        this.mc.displayGuiScreen(new GuiScreenHorseInventory(this.inventory, lllllllllllllIllIlIIIIIIIlIlIlII, lllllllllllllIllIlIIIIIIIlIllIII));
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIllIlIIIIIIlIIlIlll) {
        super.notifyDataManagerChange(lllllllllllllIllIlIIIIIIlIIlIlll);
        if (EntityPlayerSP.HAND_STATES.equals(lllllllllllllIllIlIIIIIIlIIlIlll)) {
            final boolean lllllllllllllIllIlIIIIIIlIIlIllI = (this.dataManager.get(EntityPlayerSP.HAND_STATES) & 0x1) > 0;
            final EnumHand lllllllllllllIllIlIIIIIIlIIlIlIl = ((this.dataManager.get(EntityPlayerSP.HAND_STATES) & 0x2) > 0) ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
            if (lllllllllllllIllIlIIIIIIlIIlIllI && !this.handActive) {
                this.setActiveHand(lllllllllllllIllIlIIIIIIlIIlIlIl);
            }
            else if (!lllllllllllllIllIlIIIIIIlIIlIllI && this.handActive) {
                this.resetActiveHand();
            }
        }
        if (EntityPlayerSP.FLAGS.equals(lllllllllllllIllIlIIIIIIlIIlIlll) && this.isElytraFlying() && !this.wasFallFlying) {
            this.mc.getSoundHandler().playSound(new ElytraSound(this));
        }
    }
    
    @Override
    public void resetActiveHand() {
        super.resetActiveHand();
        this.handActive = false;
    }
    
    public boolean isAutoJumpEnabled() {
        return this.autoJumpEnabled;
    }
    
    @Override
    protected void damageEntity(final DamageSource lllllllllllllIllIlIIIIIlIlIlIIlI, final float lllllllllllllIllIlIIIIIlIlIlIIIl) {
        if (!this.isEntityInvulnerable(lllllllllllllIllIlIIIIIlIlIlIIlI)) {
            this.setHealth(this.getHealth() - lllllllllllllIllIlIIIIIlIlIlIIIl);
        }
    }
    
    public float[] getHeadRotations() {
        return new float[] { this.rotationYawHead, this.rotationPitchHead };
    }
    
    private void onUpdateWalkingPlayer() {
        final EventPreMotionUpdate lllllllllllllIllIlIIIIIllIIIllIl = new EventPreMotionUpdate(this.rotationYaw, this.rotationPitch, this.posY, this.getLocation());
        lllllllllllllIllIlIIIIIllIIIllIl.call();
        this.PreYaw = this.rotationYaw;
        this.PrePitch = this.rotationPitch;
        this.rotationYaw = lllllllllllllIllIlIIIIIllIIIllIl.getYaw();
        this.rotationPitch = lllllllllllllIllIlIIIIIllIIIllIl.getPitch();
        final boolean lllllllllllllIllIlIIIIIllIIIllII = this.isSprinting();
        if (lllllllllllllIllIlIIIIIllIIIllII != this.serverSprintState) {
            if (lllllllllllllIllIlIIIIIllIIIllII) {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_SPRINTING));
            }
            else {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            this.serverSprintState = lllllllllllllIllIlIIIIIllIIIllII;
        }
        final boolean lllllllllllllIllIlIIIIIllIIIlIll = this.isSneaking();
        if (lllllllllllllIllIlIIIIIllIIIlIll != this.serverSneakState) {
            if (lllllllllllllIllIlIIIIIllIIIlIll) {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.START_SNEAKING));
            }
            else {
                this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            this.serverSneakState = lllllllllllllIllIlIIIIIllIIIlIll;
        }
        if (this.isCurrentViewEntity()) {
            final AxisAlignedBB lllllllllllllIllIlIIIIIllIIIlIlI = this.getEntityBoundingBox();
            final double lllllllllllllIllIlIIIIIllIIIlIIl = this.posX - this.lastReportedPosX;
            final double lllllllllllllIllIlIIIIIllIIIlIII = lllllllllllllIllIlIIIIIllIIIlIlI.minY - this.lastReportedPosY;
            final double lllllllllllllIllIlIIIIIllIIIIlll = this.posZ - this.lastReportedPosZ;
            final double lllllllllllllIllIlIIIIIllIIIIllI = this.rotationYaw - this.lastReportedYaw;
            final double lllllllllllllIllIlIIIIIllIIIIlIl = this.rotationPitch - this.lastReportedPitch;
            ++this.positionUpdateTicks;
            boolean lllllllllllllIllIlIIIIIllIIIIlII = lllllllllllllIllIlIIIIIllIIIlIIl * lllllllllllllIllIlIIIIIllIIIlIIl + lllllllllllllIllIlIIIIIllIIIlIII * lllllllllllllIllIlIIIIIllIIIlIII + lllllllllllllIllIlIIIIIllIIIIlll * lllllllllllllIllIlIIIIIllIIIIlll > 9.0E-4 || this.positionUpdateTicks >= 20;
            final boolean lllllllllllllIllIlIIIIIllIIIIIll = lllllllllllllIllIlIIIIIllIIIIllI != 0.0 || lllllllllllllIllIlIIIIIllIIIIlIl != 0.0;
            if (this.isRiding()) {
                this.connection.sendPacket(new CPacketPlayer.PositionRotation(this.motionX, -999.0, this.motionZ, this.rotationYaw, this.rotationPitch, this.onGround));
                lllllllllllllIllIlIIIIIllIIIIlII = false;
            }
            else if (lllllllllllllIllIlIIIIIllIIIIlII && lllllllllllllIllIlIIIIIllIIIIIll) {
                this.connection.sendPacket(new CPacketPlayer.PositionRotation(this.posX, lllllllllllllIllIlIIIIIllIIIlIlI.minY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
            }
            else if (lllllllllllllIllIlIIIIIllIIIIlII) {
                this.connection.sendPacket(new CPacketPlayer.Position(this.posX, lllllllllllllIllIlIIIIIllIIIlIlI.minY, this.posZ, this.onGround));
            }
            else if (lllllllllllllIllIlIIIIIllIIIIIll) {
                this.connection.sendPacket(new CPacketPlayer.Rotation(this.rotationYaw, this.rotationPitch, this.onGround));
            }
            else if (this.prevOnGround != this.onGround) {
                this.connection.sendPacket(new CPacketPlayer(this.onGround));
            }
            if (lllllllllllllIllIlIIIIIllIIIIlII) {
                this.lastReportedPosX = this.posX;
                this.lastReportedPosY = lllllllllllllIllIlIIIIIllIIIlIlI.minY;
                this.lastReportedPosZ = this.posZ;
                this.positionUpdateTicks = 0;
            }
            if (lllllllllllllIllIlIIIIIllIIIIIll) {
                this.lastReportedYaw = this.rotationYaw;
                this.lastReportedPitch = this.rotationPitch;
            }
            this.prevOnGround = this.onGround;
            this.autoJumpEnabled = this.mc.gameSettings.autoJump;
        }
    }
    
    @Override
    public void displayGUIChest(final IInventory lllllllllllllIllIlIIIIIIIlIllllI) {
        final String lllllllllllllIllIlIIIIIIIllIIIII = (lllllllllllllIllIlIIIIIIIlIllllI instanceof IInteractionObject) ? ((IInteractionObject)lllllllllllllIllIlIIIIIIIlIllllI).getGuiID() : "minecraft:container";
        if ("minecraft:chest".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
            this.mc.displayGuiScreen(new GuiChest(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
        }
        else if ("minecraft:hopper".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
            this.mc.displayGuiScreen(new GuiHopper(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
        }
        else if ("minecraft:furnace".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
            this.mc.displayGuiScreen(new GuiFurnace(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
        }
        else if ("minecraft:brewing_stand".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
            this.mc.displayGuiScreen(new GuiBrewingStand(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
        }
        else if ("minecraft:beacon".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
            this.mc.displayGuiScreen(new GuiBeacon(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
        }
        else if (!"minecraft:dispenser".equals(lllllllllllllIllIlIIIIIIIllIIIII) && !"minecraft:dropper".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
            if ("minecraft:shulker_box".equals(lllllllllllllIllIlIIIIIIIllIIIII)) {
                this.mc.displayGuiScreen(new GuiShulkerBox(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
            }
            else {
                this.mc.displayGuiScreen(new GuiChest(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
            }
        }
        else {
            this.mc.displayGuiScreen(new GuiDispenser(this.inventory, lllllllllllllIllIlIIIIIIIlIllllI));
        }
    }
    
    @Override
    public boolean isHandActive() {
        return this.handActive;
    }
    
    @Override
    public void setSprinting(final boolean lllllllllllllIllIlIIIIIIlllIIIII) {
        super.setSprinting(lllllllllllllIllIlIIIIIIlllIIIII);
        this.sprintingTicksLeft = 0;
    }
    
    @Override
    protected boolean pushOutOfBlocks(final double lllllllllllllIllIlIIIIIIllllllII, final double lllllllllllllIllIlIIIIIIlllllIll, final double lllllllllllllIllIlIIIIIIlllllIlI) {
        if ((Main.moduleManager.getModule(NoPush.class).isToggled() && Main.settingsManager.getSettingByName("Blocks").getValBoolean()) || Main.moduleManager.getModule(Freecam.class).isToggled() || Main.moduleManager.getModule(NoClip.class).isToggled()) {
            return false;
        }
        final BlockPos lllllllllllllIllIlIIIIIIlllllIIl = new BlockPos(lllllllllllllIllIlIIIIIIllllllII, lllllllllllllIllIlIIIIIIlllllIll, lllllllllllllIllIlIIIIIIlllllIlI);
        final double lllllllllllllIllIlIIIIIIlllllIII = lllllllllllllIllIlIIIIIIllllllII - lllllllllllllIllIlIIIIIIlllllIIl.getX();
        final double lllllllllllllIllIlIIIIIIllllIlll = lllllllllllllIllIlIIIIIIlllllIlI - lllllllllllllIllIlIIIIIIlllllIIl.getZ();
        if (!this.isOpenBlockSpace(lllllllllllllIllIlIIIIIIlllllIIl)) {
            int lllllllllllllIllIlIIIIIIllllIllI = -1;
            double lllllllllllllIllIlIIIIIIllllIlIl = 9999.0;
            if (this.isOpenBlockSpace(lllllllllllllIllIlIIIIIIlllllIIl.west()) && lllllllllllllIllIlIIIIIIlllllIII < lllllllllllllIllIlIIIIIIllllIlIl) {
                lllllllllllllIllIlIIIIIIllllIlIl = lllllllllllllIllIlIIIIIIlllllIII;
                lllllllllllllIllIlIIIIIIllllIllI = 0;
            }
            if (this.isOpenBlockSpace(lllllllllllllIllIlIIIIIIlllllIIl.east()) && 1.0 - lllllllllllllIllIlIIIIIIlllllIII < lllllllllllllIllIlIIIIIIllllIlIl) {
                lllllllllllllIllIlIIIIIIllllIlIl = 1.0 - lllllllllllllIllIlIIIIIIlllllIII;
                lllllllllllllIllIlIIIIIIllllIllI = 1;
            }
            if (this.isOpenBlockSpace(lllllllllllllIllIlIIIIIIlllllIIl.north()) && lllllllllllllIllIlIIIIIIllllIlll < lllllllllllllIllIlIIIIIIllllIlIl) {
                lllllllllllllIllIlIIIIIIllllIlIl = lllllllllllllIllIlIIIIIIllllIlll;
                lllllllllllllIllIlIIIIIIllllIllI = 4;
            }
            if (this.isOpenBlockSpace(lllllllllllllIllIlIIIIIIlllllIIl.south()) && 1.0 - lllllllllllllIllIlIIIIIIllllIlll < lllllllllllllIllIlIIIIIIllllIlIl) {
                lllllllllllllIllIlIIIIIIllllIlIl = 1.0 - lllllllllllllIllIlIIIIIIllllIlll;
                lllllllllllllIllIlIIIIIIllllIllI = 5;
            }
            final float lllllllllllllIllIlIIIIIIllllIlII = 0.1f;
            if (lllllllllllllIllIlIIIIIIllllIllI == 0) {
                this.motionX = -0.10000000149011612;
            }
            if (lllllllllllllIllIlIIIIIIllllIllI == 1) {
                this.motionX = 0.10000000149011612;
            }
            if (lllllllllllllIllIlIIIIIIllllIllI == 4) {
                this.motionZ = -0.10000000149011612;
            }
            if (lllllllllllllIllIlIIIIIIllllIllI == 5) {
                this.motionZ = 0.10000000149011612;
            }
        }
        return false;
    }
    
    public StatisticsManager getStatFileWriter() {
        return this.statWriter;
    }
    
    @Override
    public void displayGui(final IInteractionObject lllllllllllllIllIlIIIIIIIlIIllll) {
        final String lllllllllllllIllIlIIIIIIIlIIlllI = lllllllllllllIllIlIIIIIIIlIIllll.getGuiID();
        if ("minecraft:crafting_table".equals(lllllllllllllIllIlIIIIIIIlIIlllI)) {
            this.mc.displayGuiScreen(new GuiCrafting(this.inventory, this.world));
        }
        else if ("minecraft:enchanting_table".equals(lllllllllllllIllIlIIIIIIIlIIlllI)) {
            this.mc.displayGuiScreen(new GuiEnchantment(this.inventory, this.world, lllllllllllllIllIlIIIIIIIlIIllll));
        }
        else if ("minecraft:anvil".equals(lllllllllllllIllIlIIIIIIIlIIlllI)) {
            this.mc.displayGuiScreen(new GuiRepair(this.inventory, this.world));
        }
    }
    
    public void setServerBrand(final String lllllllllllllIllIlIIIIIlIIlIlIIl) {
        this.serverBrand = lllllllllllllIllIlIIIIIlIIlIlIIl;
    }
    
    @Override
    public void swingArm(final EnumHand lllllllllllllIllIlIIIIIlIlIlllIl) {
        super.swingArm(lllllllllllllIllIlIIIIIlIlIlllIl);
        this.connection.sendPacket(new CPacketAnimation(lllllllllllllIllIlIIIIIlIlIlllIl));
    }
    
    @Override
    public void addChatMessage(final ITextComponent lllllllllllllIllIlIIIIIIllIIllII) {
        this.mc.ingameGUI.getChatGUI().printChatMessage(lllllllllllllIllIlIIIIIIllIIllII);
    }
    
    public LPosition getLocation() {
        if (this.location == null) {
            this.location = new LPosition(this.mc.player.posX, this.mc.player.posY, this.mc.player.posZ, this.mc.player.onGround);
        }
        this.location.setX(this.mc.player.posX);
        this.location.setY(this.mc.player.posY);
        this.location.setZ(this.mc.player.posZ);
        this.location.setOnGround(this.mc.player.onGround);
        return this.location;
    }
    
    @Override
    public void heal(final float lllllllllllllIllIlIIIIIllIllIlIl) {
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIllIlIIIIIlllIIllIl, final float lllllllllllllIllIlIIIIIlllIIllII) {
        return false;
    }
    
    @Override
    public void openEditStructure(final TileEntityStructure lllllllllllllIllIlIIIIIIIlllIIlI) {
        this.mc.displayGuiScreen(new GuiEditStructure(lllllllllllllIllIlIIIIIIIlllIIlI));
    }
    
    @Override
    public void setActiveHand(final EnumHand lllllllllllllIllIlIIIIIIlIlIIlll) {
        final ItemStack lllllllllllllIllIlIIIIIIlIlIlIIl = this.getHeldItem(lllllllllllllIllIlIIIIIIlIlIIlll);
        if (!lllllllllllllIllIlIIIIIIlIlIlIIl.func_190926_b() && !this.isHandActive()) {
            super.setActiveHand(lllllllllllllIllIlIIIIIIlIlIIlll);
            this.handActive = true;
            this.activeHand = lllllllllllllIllIlIIIIIIlIlIIlll;
        }
    }
    
    @Override
    public boolean isServerWorld() {
        return true;
    }
    
    public boolean isRidingHorse() {
        final Entity lllllllllllllIllIlIIIIIIlIIIllIl = this.getRidingEntity();
        return this.isRiding() && lllllllllllllIllIlIIIIIIlIIIllIl instanceof IJumpingMount && ((IJumpingMount)lllllllllllllIllIlIIIIIIlIIIllIl).canJump();
    }
    
    @Override
    public void addStat(final StatBase lllllllllllllIllIlIIIIIlIIlllIlI, final int lllllllllllllIllIlIIIIIlIIlllIIl) {
        if (lllllllllllllIllIlIIIIIlIIlllIlI != null && lllllllllllllIllIlIIIIIlIIlllIlI.isIndependent) {
            super.addStat(lllllllllllllIllIlIIIIIlIIlllIlI, lllllllllllllIllIlIIIIIlIIlllIIl);
        }
    }
    
    public void func_193103_a(final IRecipe lllllllllllllIllIlIIIIIlIIIllIlI) {
        if (this.field_192036_cb.func_194076_e(lllllllllllllIllIlIIIIIlIIIllIlI)) {
            this.field_192036_cb.func_194074_f(lllllllllllllIllIlIIIIIlIIIllIlI);
            this.connection.sendPacket(new CPacketRecipeInfo(lllllllllllllIllIlIIIIIlIIIllIlI));
        }
    }
    
    @Override
    public BlockPos getPosition() {
        return new BlockPos(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5);
    }
    
    @Override
    public void moveEntity(final MoverType lllllllllllllIllIIllllllllllIIII, final double lllllllllllllIllIIlllllllllIllll, final double lllllllllllllIllIIlllllllllIlllI, final double lllllllllllllIllIIlllllllllIllIl) {
        final EventMove lllllllllllllIllIIllllllllllIlII = new EventMove(lllllllllllllIllIIlllllllllIllll, lllllllllllllIllIIlllllllllIlllI, lllllllllllllIllIIlllllllllIllIl);
        lllllllllllllIllIIllllllllllIlII.call();
        final double lllllllllllllIllIIllllllllllIIll = this.posX;
        final double lllllllllllllIllIIllllllllllIIlI = this.posZ;
        super.moveEntity(lllllllllllllIllIIllllllllllIIII, lllllllllllllIllIIlllllllllIllll, lllllllllllllIllIIlllllllllIlllI, lllllllllllllIllIIlllllllllIllIl);
        this.updateAutoJump((float)(this.posX - lllllllllllllIllIIllllllllllIIll), (float)(this.posZ - lllllllllllllIllIIllllllllllIIlI));
    }
    
    @Nullable
    @Override
    public EntityItem dropItem(final boolean lllllllllllllIllIlIIIIIlIllIllll) {
        final CPacketPlayerDigging.Action lllllllllllllIllIlIIIIIlIlllIIIl = lllllllllllllIllIlIIIIIlIllIllll ? CPacketPlayerDigging.Action.DROP_ALL_ITEMS : CPacketPlayerDigging.Action.DROP_ITEM;
        this.connection.sendPacket(new CPacketPlayerDigging(lllllllllllllIllIlIIIIIlIlllIIIl, BlockPos.ORIGIN, EnumFacing.DOWN));
        return null;
    }
    
    @Override
    public boolean startRiding(final Entity lllllllllllllIllIlIIIIIllIllIIII, final boolean lllllllllllllIllIlIIIIIllIlIllll) {
        if (!super.startRiding(lllllllllllllIllIlIIIIIllIllIIII, lllllllllllllIllIlIIIIIllIlIllll)) {
            return false;
        }
        if (lllllllllllllIllIlIIIIIllIllIIII instanceof EntityMinecart) {
            this.mc.getSoundHandler().playSound(new MovingSoundMinecartRiding(this, (EntityMinecart)lllllllllllllIllIlIIIIIllIllIIII));
        }
        if (lllllllllllllIllIlIIIIIllIllIIII instanceof EntityBoat) {
            this.prevRotationYaw = lllllllllllllIllIlIIIIIllIllIIII.rotationYaw;
            this.rotationYaw = lllllllllllllIllIlIIIIIllIllIIII.rotationYaw;
            this.setRotationYawHead(lllllllllllllIllIlIIIIIllIllIIII.rotationYaw);
        }
        return true;
    }
    
    public String getServerBrand() {
        return this.serverBrand;
    }
    
    @Override
    public void onCriticalHit(final Entity lllllllllllllIllIlIIIIIIIlIIIIIl) {
        this.mc.effectRenderer.emitParticleAtEntity(lllllllllllllIllIlIIIIIIIlIIIIIl, EnumParticleTypes.CRIT);
    }
    
    @Override
    public void displayGuiEditCommandCart(final CommandBlockBaseLogic lllllllllllllIllIlIIIIIIIlllllII) {
        this.mc.displayGuiScreen(new GuiEditCommandBlockMinecart(lllllllllllllIllIlIIIIIIIlllllII));
    }
    
    public void setXPStats(final float lllllllllllllIllIlIIIIIIllIllIII, final int lllllllllllllIllIlIIIIIIllIlIIll, final int lllllllllllllIllIlIIIIIIllIlIIlI) {
        this.experience = lllllllllllllIllIlIIIIIIllIllIII;
        this.experienceTotal = lllllllllllllIllIlIIIIIIllIlIIll;
        this.experienceLevel = lllllllllllllIllIlIIIIIIllIlIIlI;
    }
    
    public void updateEntityActionState() {
        super.updateEntityActionState();
        if (this.isCurrentViewEntity()) {
            this.moveStrafing = MovementInput.moveStrafe;
            this.field_191988_bg = this.movementInput.field_192832_b;
            this.isJumping = this.movementInput.jump;
            this.prevRenderArmYaw = this.renderArmYaw;
            this.prevRenderArmPitch = this.renderArmPitch;
            this.renderArmPitch += (float)((this.rotationPitch - this.renderArmPitch) * 0.5);
            this.renderArmYaw += (float)((this.rotationYaw - this.renderArmYaw) * 0.5);
        }
    }
    
    public RecipeBook func_192035_E() {
        return this.field_192036_cb;
    }
    
    public void sendHorseInventory() {
        this.connection.sendPacket(new CPacketEntityAction(this, CPacketEntityAction.Action.OPEN_INVENTORY));
    }
    
    @Override
    public boolean isSneaking() {
        final boolean lllllllllllllIllIlIIIIIIIIllIlIl = this.movementInput != null && this.movementInput.sneak;
        return lllllllllllllIllIlIIIIIIIIllIlIl && !this.sleeping;
    }
    
    @Override
    public void sendPlayerAbilities() {
        this.connection.sendPacket(new CPacketPlayerAbilities(this.capabilities));
    }
    
    @Override
    public void onUpdate() {
        if (this.world.isBlockLoaded(new BlockPos(this.posX, 0.0, this.posZ))) {
            final EventUpdate lllllllllllllIllIlIIIIIllIlIIIII = new EventUpdate();
            lllllllllllllIllIlIIIIIllIlIIIII.call();
            super.onUpdate();
            if (this.isRiding()) {
                this.connection.sendPacket(new CPacketPlayer.Rotation(this.rotationYaw, this.rotationPitch, this.onGround));
                this.connection.sendPacket(new CPacketInput(this.moveStrafing, this.field_191988_bg, this.movementInput.jump, this.movementInput.sneak));
                final Entity lllllllllllllIllIlIIIIIllIIlllll = this.getLowestRidingEntity();
                if (lllllllllllllIllIlIIIIIllIIlllll != this && lllllllllllllIllIlIIIIIllIIlllll.canPassengerSteer()) {
                    this.connection.sendPacket(new CPacketVehicleMove(lllllllllllllIllIlIIIIIllIIlllll));
                }
            }
            else {
                this.onUpdateWalkingPlayer();
                if (!Main.moduleManager.getModuleByName("Freecam").isToggled()) {
                    this.rotationYaw = this.PreYaw;
                    this.rotationPitch = this.PrePitch;
                }
                final EventPostMotionUpdate lllllllllllllIllIlIIIIIllIIllllI = new EventPostMotionUpdate(this.rotationYaw, this.rotationPitch, this.onGround, this.posY);
                lllllllllllllIllIlIIIIIllIIllllI.call();
            }
        }
    }
    
    protected boolean isCurrentViewEntity() {
        return this.mc.getRenderViewEntity() == this;
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIllIlIIIIIIllIIIIIl) {
        if (lllllllllllllIllIlIIIIIIllIIIIIl >= 24 && lllllllllllllIllIlIIIIIIllIIIIIl <= 28) {
            this.setPermissionLevel(lllllllllllllIllIlIIIIIIllIIIIIl - 24);
        }
        else {
            super.handleStatusUpdate(lllllllllllllIllIlIIIIIIllIIIIIl);
        }
    }
    
    @Override
    public void openBook(final ItemStack lllllllllllllIllIlIIIIIIIllIIlll, final EnumHand lllllllllllllIllIlIIIIIIIllIlIlI) {
        final Item lllllllllllllIllIlIIIIIIIllIlIIl = lllllllllllllIllIlIIIIIIIllIIlll.getItem();
        if (lllllllllllllIllIlIIIIIIIllIlIIl == Items.WRITABLE_BOOK) {
            this.mc.displayGuiScreen(new GuiScreenBook(this, lllllllllllllIllIlIIIIIIIllIIlll, true));
        }
    }
    
    @Override
    public void onEnchantmentCritical(final Entity lllllllllllllIllIlIIIIIIIIlllIll) {
        this.mc.effectRenderer.emitParticleAtEntity(lllllllllllllIllIlIIIIIIIIlllIll, EnumParticleTypes.CRIT_MAGIC);
    }
    
    public EntityPlayerSP(final Minecraft lllllllllllllIllIlIIIIIlllIlIIll, final World lllllllllllllIllIlIIIIIlllIllIII, final NetHandlerPlayClient lllllllllllllIllIlIIIIIlllIlIIIl, final StatisticsManager lllllllllllllIllIlIIIIIlllIlIIII, final RecipeBook lllllllllllllIllIlIIIIIlllIIllll) {
        super(lllllllllllllIllIlIIIIIlllIllIII, lllllllllllllIllIlIIIIIlllIlIIIl.getGameProfile());
        this.permissionLevel = 0;
        this.autoJumpEnabled = true;
        this.connection = lllllllllllllIllIlIIIIIlllIlIIIl;
        this.statWriter = lllllllllllllIllIlIIIIIlllIlIIII;
        this.field_192036_cb = lllllllllllllIllIlIIIIIlllIIllll;
        this.mc = lllllllllllllIllIlIIIIIlllIlIIll;
        this.dimension = 0;
    }
    
    public void closeScreen() {
        this.connection.sendPacket(new CPacketCloseWindow(this.openContainer.windowId));
        this.closeScreenAndDropStack();
    }
    
    public void setHeadRotations(final float lllllllllllllIllIlIIIIIlllIIIlII, final float lllllllllllllIllIlIIIIIlllIIIllI) {
        this.rotationYawHead = lllllllllllllIllIlIIIIIlllIIIlII;
        this.rotationPitchHead = lllllllllllllIllIlIIIIIlllIIIllI;
    }
    
    @Override
    public boolean isUser() {
        return true;
    }
    
    @Override
    public void addChatComponentMessage(final ITextComponent lllllllllllllIllIlIIIIIlIIIIllII, final boolean lllllllllllllIllIlIIIIIlIIIIlIII) {
        if (lllllllllllllIllIlIIIIIlIIIIlIII) {
            this.mc.ingameGUI.setRecordPlaying(lllllllllllllIllIlIIIIIlIIIIllII, false);
        }
        else {
            this.mc.ingameGUI.getChatGUI().printChatMessage(lllllllllllllIllIlIIIIIlIIIIllII);
        }
    }
    
    public void sendChatMessage(final String lllllllllllllIllIlIIIIIlIllIIlIl) {
        if (ModuleManager.onSendMessage(lllllllllllllIllIlIIIIIlIllIIlIl)) {
            this.connection.sendPacket(new CPacketChatMessage(lllllllllllllIllIlIIIIIlIllIIlIl));
        }
    }
    
    @Override
    protected ItemStack dropItemAndGetStack(final EntityItem lllllllllllllIllIlIIIIIlIllIllII) {
        return ItemStack.field_190927_a;
    }
}
