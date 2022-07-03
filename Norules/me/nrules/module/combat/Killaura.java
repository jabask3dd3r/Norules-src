package me.nrules.module.combat;

import me.nrules.module.*;
import java.util.*;
import me.nrules.*;
import clickui.settings.*;
import me.nrules.event.events.*;
import net.minecraft.entity.*;
import me.nrules.utils.friend.*;
import me.nrules.utils.player.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;

public class Killaura extends Module
{
    private static /* synthetic */ Setting player;
    public static /* synthetic */ Setting targetHud;
    private /* synthetic */ Setting shieldbreak;
    public static /* synthetic */ Setting range;
    public /* synthetic */ Setting hitAnimation;
    public static /* synthetic */ Setting shieldblock;
    public static /* synthetic */ EntityLivingBase target;
    private /* synthetic */ Setting waterCheck;
    private /* synthetic */ Setting autocrit;
    public static /* synthetic */ Setting targetHudModeType;
    private final /* synthetic */ List<EntityLivingBase> targets;
    private static /* synthetic */ Setting animal;
    private static /* synthetic */ Setting mob;
    
    public static int getSwordH() {
        for (int lllllllllllllIIlIlIlIlIIIlIIIIlI = 0; lllllllllllllIIlIlIlIlIIIlIIIIlI < 9; ++lllllllllllllIIlIlIlIlIIIlIIIIlI) {
            final ItemStack lllllllllllllIIlIlIlIlIIIlIIIIIl = Killaura.mc.player.inventory.getStackInSlot(lllllllllllllIIlIlIlIlIIIlIIIIlI);
            if (lllllllllllllIIlIlIlIlIIIlIIIIIl.getItem() instanceof ItemSword) {
                return lllllllllllllIIlIlIlIlIIIlIIIIlI;
            }
        }
        return -1;
    }
    
    public Killaura() {
        super("KillAura", 0, Category.COMBAT);
        this.targets = new ArrayList<EntityLivingBase>();
        Main.settingsManager.Property(Killaura.range = new Setting("Range", this, 3.6, 3.0, 6.0, false));
        Main.settingsManager.Property(Killaura.shieldblock = new Setting("ShieldBlock", this, true));
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("ShieldBreak", this, true);
        this.shieldbreak = setting;
        settingsManager.Property(setting);
        Main.settingsManager.Property(Killaura.targetHud = new Setting("TargetHud", this, false));
        final SM settingsManager2 = Main.settingsManager;
        final Setting setting2 = new Setting("AutoCrit", this, true);
        this.autocrit = setting2;
        settingsManager2.Property(setting2);
        final SM settingsManager3 = Main.settingsManager;
        final Setting setting3 = new Setting("WaterCheck", this, true);
        this.waterCheck = setting3;
        settingsManager3.Property(setting3);
        final SM settingsManager4 = Main.settingsManager;
        final Setting setting4 = new Setting("HitAnimation", this, false);
        this.hitAnimation = setting4;
        settingsManager4.Property(setting4);
        Main.settingsManager.Property(Killaura.player = new Setting("Player", this, true));
        Main.settingsManager.Property(Killaura.animal = new Setting("Animal", this, false));
        Main.settingsManager.Property(Killaura.mob = new Setting("Mob", this, false));
        final ArrayList<String> lllllllllllllIIlIlIlIlIIIllIIIll = new ArrayList<String>();
        lllllllllllllIIlIlIlIlIIIllIIIll.add("Simple");
        lllllllllllllIIlIlIlIlIIIllIIIll.add("Improve");
        Main.settingsManager.Property(Killaura.targetHudModeType = new Setting("HudMode", this, "Simple", lllllllllllllIIlIlIlIlIIIllIIIll));
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate lllllllllllllIIlIlIlIlIIIlIlIIII) {
        for (final Entity lllllllllllllIIlIlIlIlIIIlIlIIll : Killaura.mc.world.loadedEntityList) {
            if (lllllllllllllIIlIlIlIlIIIlIlIIll != Killaura.mc.player && !FriendManager.isFriend(lllllllllllllIIlIlIlIlIIIlIlIIll.getName()) && Killaura.mc.player.getDistanceToEntity(lllllllllllllIIlIlIlIlIIIlIlIIll) < Killaura.range.getValDouble() && !lllllllllllllIIlIlIlIlIIIlIlIIll.isDead && attackCheck(lllllllllllllIIlIlIlIlIIIlIlIIll)) {
                if (lllllllllllllIIlIlIlIlIIIlIlIIll != null) {
                    final float[] lllllllllllllIIlIlIlIlIIIlIlIIlI = RotationUtils.getRatations(lllllllllllllIIlIlIlIlIIIlIlIIll);
                    lllllllllllllIIlIlIlIlIIIlIlIIII.setYaw(lllllllllllllIIlIlIlIlIIIlIlIIlI[0]);
                    lllllllllllllIIlIlIlIlIIIlIlIIII.setPitch(lllllllllllllIIlIlIlIlIIIlIlIIlI[1]);
                    if (Killaura.mc.player.fallDistance > 0.25f && this.autocrit.getValBoolean() && Killaura.timerHelper.hasReached(513.0)) {
                        Killaura.timerHelper.reset();
                        this.attack(lllllllllllllIIlIlIlIlIIIlIlIIll);
                    }
                    if (!this.autocrit.getValBoolean() && Killaura.timerHelper.hasReached(600.0)) {
                        Killaura.timerHelper.reset();
                        this.attack(lllllllllllllIIlIlIlIlIIIlIlIIll);
                    }
                    if (this.waterCheck.getValBoolean() && (Killaura.mc.player.isInWater() || Killaura.mc.player.isInLava()) && Killaura.mc.player.getCooledAttackStrength(1.0f) == 1.0f) {
                        Killaura.mc.player.connection.sendPacket(new CPacketUseEntity(lllllllllllllIIlIlIlIlIIIlIlIIll));
                        Killaura.mc.player.swingArm(EnumHand.MAIN_HAND);
                        Killaura.mc.player.resetCooldown();
                    }
                }
                if (!this.shieldbreak.getValBoolean()) {
                    continue;
                }
                if (((EntityPlayer)lllllllllllllIIlIlIlIlIIIlIlIIll).getHeldItemOffhand().getItem() instanceof ItemShield && ((EntityPlayer)lllllllllllllIIlIlIlIlIIIlIlIIll).isHandActive() && Killaura.mc.player.canEntityBeSeen(lllllllllllllIIlIlIlIlIIIlIlIIll) && Killaura.mc.player.getDistanceToEntity(lllllllllllllIIlIlIlIlIIIlIlIIll) < 3.8 && !FriendManager.isFriend(((EntityPlayer)lllllllllllllIIlIlIlIlIIIlIlIIll).getName())) {
                    this.destroyShield();
                    if (!(Killaura.mc.player.getHeldItemMainhand().getItem() instanceof ItemAxe) || Killaura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword || !Killaura.timerHelper.hasReached(150.0)) {
                        continue;
                    }
                    Killaura.timerHelper.reset();
                    Killaura.mc.playerController.attackEntity(Killaura.mc.player, lllllllllllllIIlIlIlIlIIIlIlIIll);
                    Killaura.mc.player.swingArm(EnumHand.MAIN_HAND);
                }
                else {
                    if (((EntityPlayer)lllllllllllllIIlIlIlIlIIIlIlIIll).isHandActive()) {
                        continue;
                    }
                    if (((EntityPlayer)lllllllllllllIIlIlIlIlIIIlIlIIll).getHeldItemMainhand().getItem() instanceof ItemAxe) {
                        Killaura.mc.playerController.onStoppedUsingItem(Killaura.mc.player);
                    }
                    getSword();
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        Killaura.target = null;
        Killaura.mc.gameSettings.keyBindUseItem.pressed = false;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public static int getAxeH() {
        for (int lllllllllllllIIlIlIlIlIIIIllllII = 0; lllllllllllllIIlIlIlIlIIIIllllII < 9; ++lllllllllllllIIlIlIlIlIIIIllllII) {
            final ItemStack lllllllllllllIIlIlIlIlIIIIlllIll = Killaura.mc.player.inventory.getStackInSlot(lllllllllllllIIlIlIlIlIIIIllllII);
            if (lllllllllllllIIlIlIlIlIIIIlllIll.getItem() instanceof ItemAxe) {
                return lllllllllllllIIlIlIlIlIIIIllllII;
            }
        }
        return -1;
    }
    
    public void attack(final Entity lllllllllllllIIlIlIlIlIIIlIIlIlI) {
        Killaura.mc.playerController.attackEntity(Killaura.mc.player, lllllllllllllIIlIlIlIlIIIlIIlIlI);
        Killaura.mc.player.swingArm(EnumHand.MAIN_HAND);
    }
    
    public static boolean attackCheck(final Entity lllllllllllllIIlIlIlIlIIIlIIIllI) {
        if (Killaura.player.getValBoolean() && lllllllllllllIIlIlIlIlIIIlIIIllI instanceof EntityPlayer && !FriendManager.isFriend(lllllllllllllIIlIlIlIlIIIlIIIllI.getName()) && ((EntityPlayer)lllllllllllllIIlIlIlIlIIIlIIIllI).getHealth() > 0.0f) {
            return true;
        }
        if (Killaura.animal.getValBoolean() && lllllllllllllIIlIlIlIlIIIlIIIllI instanceof EntityAnimal && lllllllllllllIIlIlIlIlIIIlIIIllI instanceof IAnimals) {
            return !(lllllllllllllIIlIlIlIlIIIlIIIllI instanceof EntityTameable) && !lllllllllllllIIlIlIlIlIIIlIIIllI.isDead;
        }
        return (Killaura.mob.getValBoolean() && lllllllllllllIIlIlIlIlIIIlIIIllI instanceof EntityMob) || lllllllllllllIIlIlIlIlIIIlIIIllI instanceof IMob || (lllllllllllllIIlIlIlIlIIIlIIIllI.isDead && false);
    }
    
    public void destroyShield() {
        if (getAxeH() == -1) {
            return;
        }
        Killaura.mc.player.inventory.currentItem = getAxeH();
    }
    
    public static void getSword() {
        if (getSwordH() == -1) {
            return;
        }
        Killaura.mc.player.inventory.currentItem = getSwordH();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
