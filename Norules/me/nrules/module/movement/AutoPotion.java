package me.nrules.module.movement;

import me.nrules.module.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import java.util.*;
import me.nrules.event.events.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.client.network.*;
import me.nrules.event.*;

public class AutoPotion extends Module
{
    private /* synthetic */ int item;
    private /* synthetic */ int oldSlot;
    private /* synthetic */ int slot;
    
    public static boolean doesNextSlotHavePot() {
        for (int lllllllllllllIlllIIlllIIllllllIl = 0; lllllllllllllIlllIIlllIIllllllIl < 9; ++lllllllllllllIlllIIlllIIllllllIl) {
            if (AutoPotion.mc.player.inventory.getStackInSlot(lllllllllllllIlllIIlllIIllllllIl) != null && AutoPotion.mc.player.inventory.getStackInSlot(lllllllllllllIlllIIlllIIllllllIl).getItem() == Items.SPLASH_POTION) {
                return true;
            }
        }
        return false;
    }
    
    public AutoPotion() {
        super("AutoPotion", 0, Category.MOVEMENT);
    }
    
    public static int getJumpBoostModifier() {
        final PotionEffect lllllllllllllIlllIIlllIlIlIIIIII = AutoPotion.mc.player.getActivePotionEffect(MobEffects.JUMP_BOOST);
        if (lllllllllllllIlllIIlllIlIlIIIIII != null) {
            return lllllllllllllIlllIIlllIlIlIIIIII.getAmplifier() + 1;
        }
        return 0;
    }
    
    @Override
    public void onDisable() {
        AutoPotion.mc.player.inventory.currentItem = this.slot;
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        this.slot = AutoPotion.mc.player.inventory.currentItem;
        this.oldSlot = AutoPotion.mc.player.inventory.currentItem;
        super.onEnable();
    }
    
    public static boolean isBlockAbove() {
        for (double lllllllllllllIlllIIlllIlIIllIIIl = 0.0; lllllllllllllIlllIIlllIlIIllIIIl <= 1.0; lllllllllllllIlllIIlllIlIIllIIIl += 0.5) {
            final List<AxisAlignedBB> lllllllllllllIlllIIlllIlIIlIllll = AutoPotion.mc.world.getCollisionBoxes(AutoPotion.mc.player, AutoPotion.mc.player.getEntityBoundingBox().offset(0.0, lllllllllllllIlllIIlllIlIIllIIIl, 0.0));
            if (!lllllllllllllIlllIIlllIlIIlIllll.isEmpty()) {
                return true;
            }
        }
        return false;
    }
    
    public static int getSlotWithPot() {
        if (AutoPotion.mc.player.ticksExisted % 2 == 0) {
            for (int lllllllllllllIlllIIlllIIllllIllI = 0; lllllllllllllIlllIIlllIIllllIllI < 9; ++lllllllllllllIlllIIlllIIllllIllI) {
                if (AutoPotion.mc.player.inventory.getStackInSlot(lllllllllllllIlllIIlllIIllllIllI) != null && AutoPotion.mc.player.inventory.getStackInSlot(lllllllllllllIlllIIlllIIllllIllI).getItem() == Items.SPLASH_POTION) {
                    return lllllllllllllIlllIIlllIIllllIllI;
                }
            }
        }
        return 0;
    }
    
    public static void sendPotPacket(final EventPreMotionUpdate lllllllllllllIlllIIlllIlIIIIlIII) {
        final double lllllllllllllIlllIIlllIlIIIIlllI = AutoPotion.mc.player.posX - AutoPotion.mc.player.lastTickPosX;
        final double lllllllllllllIlllIIlllIlIIIIllII = AutoPotion.mc.player.posZ - AutoPotion.mc.player.lastTickPosZ;
        final double lllllllllllllIlllIIlllIlIIIIlIll = Math.sqrt(lllllllllllllIlllIIlllIlIIIIlllI * lllllllllllllIlllIIlllIlIIIIlllI + lllllllllllllIlllIIlllIlIIIIllII * lllllllllllllIlllIIlllIlIIIIllII);
        final boolean lllllllllllllIlllIIlllIlIIIIlIlI = lllllllllllllIlllIIlllIlIIIIlIll > 0.38;
        final boolean lllllllllllllIlllIIlllIlIIIIlIIl = lllllllllllllIlllIIlllIlIIIIlIll < 0.221;
        if (lllllllllllllIlllIIlllIlIIIIlIIl && AutoPotion.mc.player.onGround && !isBlockAbove() && getJumpBoostModifier() == 0) {
            lllllllllllllIlllIIlllIlIIIIlIII.setPitch(90.0f);
            AutoPotion.mc.player.rotationPitchHead = 90.0f;
        }
        else {
            if (!lllllllllllllIlllIIlllIlIIIIlIlI && !AutoPotion.mc.player.onGround) {
                return;
            }
            lllllllllllllIlllIIlllIlIIIIlIII.setYaw(getMovementDirection());
            lllllllllllllIlllIIlllIlIIIIlIII.setPitch(lllllllllllllIlllIIlllIlIIIIlIlI ? 0.0f : 45.0f);
        }
    }
    
    public static float getMovementDirection() {
        final float lllllllllllllIlllIIlllIlIIlIIlIl = AutoPotion.mc.player.movementInput.field_192832_b;
        final MovementInput movementInput = AutoPotion.mc.player.movementInput;
        final float lllllllllllllIlllIIlllIlIIlIIIll = MovementInput.moveStrafe;
        float lllllllllllllIlllIIlllIlIIlIIIlI = 0.0f;
        if (lllllllllllllIlllIIlllIlIIlIIlIl < 0.0f) {
            lllllllllllllIlllIIlllIlIIlIIIlI += 180.0f;
            if (lllllllllllllIlllIIlllIlIIlIIIll > 0.0f) {
                lllllllllllllIlllIIlllIlIIlIIIlI += 45.0f;
            }
            else if (lllllllllllllIlllIIlllIlIIlIIIll < 0.0f) {
                lllllllllllllIlllIIlllIlIIlIIIlI -= 45.0f;
            }
        }
        else if (lllllllllllllIlllIIlllIlIIlIIlIl > 0.0f) {
            if (lllllllllllllIlllIIlllIlIIlIIIll > 0.0f) {
                lllllllllllllIlllIIlllIlIIlIIIlI -= 45.0f;
            }
            else if (lllllllllllllIlllIIlllIlIIlIIIll < 0.0f) {
                lllllllllllllIlllIIlllIlIIlIIIlI += 45.0f;
            }
        }
        else if (lllllllllllllIlllIIlllIlIIlIIIll > 0.0f) {
            lllllllllllllIlllIIlllIlIIlIIIlI -= 90.0f;
        }
        else if (lllllllllllllIlllIIlllIlIIlIIIll < 0.0f) {
            lllllllllllllIlllIIlllIlIIlIIIlI += 90.0f;
        }
        lllllllllllllIlllIIlllIlIIlIIIlI += AutoPotion.mc.player.rotationYaw;
        return MathHelper.wrapDegrees(lllllllllllllIlllIIlllIlIIlIIIlI);
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate lllllllllllllIlllIIlllIlIlIIIlIl) {
        if (!doesNextSlotHavePot()) {
            return;
        }
        if (AutoPotion.mc.player.getHeldItemOffhand().getItem() == Items.field_190929_cY || AutoPotion.mc.player.getHeldItemOffhand().getItem() == Items.SHIELD) {
            return;
        }
        this.item = getSlotWithPot();
        if (this.slot != -1) {
            if (!AutoPotion.mc.player.isPotionActive(MobEffects.SPEED)) {
                sendPotPacket(lllllllllllllIlllIIlllIlIlIIIlIl);
                final NetHandlerPlayClient connection = AutoPotion.mc.player.connection;
                final int item = this.item;
                this.slot = item;
                connection.sendPacket(new CPacketHeldItemChange(item));
                AutoPotion.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(this.oldSlot));
            }
            if (AutoPotion.mc.player.isPotionActive(MobEffects.SPEED)) {
                if (!AutoPotion.mc.player.isPotionActive(MobEffects.STRENGTH)) {
                    sendPotPacket(lllllllllllllIlllIIlllIlIlIIIlIl);
                    final NetHandlerPlayClient connection2 = AutoPotion.mc.player.connection;
                    final int n = this.item + 1;
                    this.slot = n;
                    connection2.sendPacket(new CPacketHeldItemChange(n));
                    AutoPotion.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(this.oldSlot));
                }
                if (AutoPotion.mc.player.isPotionActive(MobEffects.STRENGTH) && !AutoPotion.mc.player.isPotionActive(MobEffects.FIRE_RESISTANCE)) {
                    sendPotPacket(lllllllllllllIlllIIlllIlIlIIIlIl);
                    final NetHandlerPlayClient connection3 = AutoPotion.mc.player.connection;
                    final int n2 = this.item + 2;
                    this.slot = n2;
                    connection3.sendPacket(new CPacketHeldItemChange(n2));
                    AutoPotion.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    AutoPotion.mc.player.connection.sendPacket(new CPacketHeldItemChange(this.oldSlot));
                }
            }
        }
    }
}
