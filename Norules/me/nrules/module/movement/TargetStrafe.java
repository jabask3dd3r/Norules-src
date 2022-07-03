package me.nrules.module.movement;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;
import me.nrules.module.combat.*;
import net.minecraft.client.entity.*;
import me.nrules.event.*;
import me.nrules.event.events.*;
import net.minecraft.entity.player.*;
import me.nrules.utils.friend.*;
import me.nrules.utils.player.*;
import me.nrules.notifications.*;
import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class TargetStrafe extends Module
{
    public /* synthetic */ Setting autojump;
    public static /* synthetic */ EntityLivingBase target;
    public static /* synthetic */ Minecraft mc;
    public /* synthetic */ Setting speed;
    private /* synthetic */ int direction;
    public static /* synthetic */ Setting radius;
    
    public double getMovementSpeed() {
        double llllllllllllllIlIIlllIIIIIlllIlI = 0.2873;
        if (Minecraft.getMinecraft().player.isPotionActive(Objects.requireNonNull(Potion.getPotionById(1)))) {
            final int llllllllllllllIlIIlllIIIIIlllIIl = Objects.requireNonNull(Minecraft.getMinecraft().player.getActivePotionEffect(Objects.requireNonNull(Potion.getPotionById(1)))).getAmplifier();
            llllllllllllllIlIIlllIIIIIlllIlI *= 1.0 + 0.2 * (llllllllllllllIlIIlllIIIIIlllIIl + 1);
        }
        return llllllllllllllIlIIlllIIIIIlllIlI;
    }
    
    public TargetStrafe() {
        super("TargetStrafe", 0, Category.MOVEMENT);
        this.direction = -1;
        Main.settingsManager.Property(TargetStrafe.radius = new Setting("Radius", this, 3.0, 1.0, 6.0, false));
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Speed", this, 3.18, 0.15, 50.0, false);
        this.speed = setting;
        settingsManager.Property(setting);
        final SM settingsManager2 = Main.settingsManager;
        final Setting setting2 = new Setting("AutoJump", this, true);
        this.autojump = setting2;
        settingsManager2.Property(setting2);
    }
    
    private void invertStrafe() {
        this.direction = -this.direction;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIlIIlllIIIIIIllIll) {
        if (Main.moduleManager.getModule(Killaura.class).isToggled()) {
            if (TargetStrafe.mc.player.isCollidedHorizontally) {
                TargetStrafe.timerHelper.reset();
                this.invertStrafe();
            }
            if (this.autojump.getValBoolean()) {
                final Entity llllllllllllllIlIIlllIIIIIIllIlI = this.getTarget();
                if (llllllllllllllIlIIlllIIIIIIllIlI != null && TargetStrafe.mc.player.onGround) {
                    TargetStrafe.mc.player.jump();
                    final EntityPlayerSP player = TargetStrafe.mc.player;
                    player.motionY -= 0.008599899709224701;
                }
            }
            if (TargetStrafe.mc.gameSettings.keyBindLeft.isPressed()) {
                this.direction = 1;
            }
            if (TargetStrafe.mc.gameSettings.keyBindRight.isPressed()) {
                this.direction = -1;
            }
            TargetStrafe.mc.player.movementInput.field_192832_b = 0.0f;
            final double llllllllllllllIlIIlllIIIIIIllIIl = this.getMovementSpeed();
            this.doStrafeAtSpeed(llllllllllllllIlIIlllIIIIIIllIIl);
        }
    }
    
    @EventTarget
    public void onRender(final Event3D llllllllllllllIlIIlllIIIIIIIIIll) {
        if (TargetStrafe.mc.world == null && TargetStrafe.mc.player == null) {
            return;
        }
        if (TargetStrafe.target != null) {
            for (final Entity llllllllllllllIlIIlllIIIIIIIIIlI : TargetStrafe.mc.world.getLoadedEntityList()) {
                if (llllllllllllllIlIIlllIIIIIIIIIlI instanceof EntityPlayer) {
                    final EntityPlayer llllllllllllllIlIIlllIIIIIIIIIIl = (EntityPlayer)llllllllllllllIlIIlllIIIIIIIIIlI;
                    if (llllllllllllllIlIIlllIIIIIIIIIIl.isDead && llllllllllllllIlIIlllIIIIIIIIIIl == TargetStrafe.mc.player) {
                        continue;
                    }
                    final long llllllllllllllIlIIllIlllllllllII = (long)this.getTarget();
                }
            }
        }
    }
    
    public static void setSpeed(final double llllllllllllllIlIIllIlllllllIIlI, final float llllllllllllllIlIIllIlllllllIIIl, final double llllllllllllllIlIIllIllllllIIlll, final double llllllllllllllIlIIllIllllllIllll) {
        double llllllllllllllIlIIllIllllllIlllI = llllllllllllllIlIIllIllllllIllll;
        double llllllllllllllIlIIllIllllllIllIl = llllllllllllllIlIIllIllllllIIlll;
        float llllllllllllllIlIIllIllllllIllII = llllllllllllllIlIIllIlllllllIIIl;
        if (llllllllllllllIlIIllIllllllIlllI == 0.0 && llllllllllllllIlIIllIllllllIllIl == 0.0) {
            TargetStrafe.mc.player.motionZ = 0.0;
            TargetStrafe.mc.player.motionX = 0.0;
        }
        else {
            if (llllllllllllllIlIIllIllllllIlllI != 0.0) {
                if (llllllllllllllIlIIllIllllllIllIl > 0.0) {
                    llllllllllllllIlIIllIllllllIllII += ((llllllllllllllIlIIllIllllllIlllI > 0.0) ? -45 : 45);
                }
                else if (llllllllllllllIlIIllIllllllIllIl < 0.0) {
                    llllllllllllllIlIIllIllllllIllII += ((llllllllllllllIlIIllIllllllIlllI > 0.0) ? 45 : -45);
                }
                llllllllllllllIlIIllIllllllIllIl = 0.0;
                if (llllllllllllllIlIIllIllllllIlllI > 0.0) {
                    llllllllllllllIlIIllIllllllIlllI = 1.0;
                }
                else if (llllllllllllllIlIIllIllllllIlllI < 0.0) {
                    llllllllllllllIlIIllIllllllIlllI = -1.0;
                }
            }
            final double llllllllllllllIlIIllIllllllIlIll = Math.cos(Math.toRadians(llllllllllllllIlIIllIllllllIllII + 90.0f));
            final double llllllllllllllIlIIllIllllllIlIlI = Math.sin(Math.toRadians(llllllllllllllIlIIllIllllllIllII + 90.0f));
            TargetStrafe.mc.player.motionX = llllllllllllllIlIIllIllllllIlllI * llllllllllllllIlIIllIlllllllIIlI * llllllllllllllIlIIllIllllllIlIll + llllllllllllllIlIIllIllllllIllIl * llllllllllllllIlIIllIlllllllIIlI * llllllllllllllIlIIllIllllllIlIlI;
            TargetStrafe.mc.player.motionZ = llllllllllllllIlIIllIllllllIlllI * llllllllllllllIlIIllIlllllllIIlI * llllllllllllllIlIIllIllllllIlIlI - llllllllllllllIlIIllIllllllIllIl * llllllllllllllIlIIllIlllllllIIlI * llllllllllllllIlIIllIllllllIlIll;
        }
    }
    
    public boolean attackCheckin(final Entity llllllllllllllIlIIlllIIIIIIIlIll) {
        return llllllllllllllIlIIlllIIIIIIIlIll instanceof EntityPlayer && ((EntityPlayer)llllllllllllllIlIIlllIIIIIIIlIll).getHealth() > 0.0f && !FriendManager.isFriend(llllllllllllllIlIIlllIIIIIIIlIll.getName()) && Math.abs(TargetStrafe.mc.player.rotationYaw - RotationUtils.getRotations(llllllllllllllIlIIlllIIIIIIIlIll)[0]) % 180.0f < 190.0f && !llllllllllllllIlIIlllIIIIIIIlIll.isInvisible() && !llllllllllllllIlIIlllIIIIIIIlIll.getUniqueID().equals(TargetStrafe.mc.player.getUniqueID());
    }
    
    public final void doStrafeAtSpeed(final double llllllllllllllIlIIlllIIIIIlIIIIl) {
        if (Main.moduleManager.getModule(Killaura.class).isToggled()) {
            final Entity llllllllllllllIlIIlllIIIIIlIIlII = this.getTarget();
            if (llllllllllllllIlIIlllIIIIIlIIlII != null) {
                final float[] llllllllllllllIlIIlllIIIIIlIIIll = RotationUtils.getRotations(llllllllllllllIlIIlllIIIIIlIIlII);
                if (Minecraft.getMinecraft().player.getDistanceToEntity(llllllllllllllIlIIlllIIIIIlIIlII) <= TargetStrafe.radius.getValDouble()) {
                    setSpeed(llllllllllllllIlIIlllIIIIIlIIIIl - (0.2 - this.speed.getValDouble() / 100.0), llllllllllllllIlIIlllIIIIIlIIIll[0], this.direction, 0.0);
                }
                else {
                    setSpeed(llllllllllllllIlIIlllIIIIIlIIIIl - (0.2 - this.speed.getValDouble() / 100.0), llllllllllllllIlIIlllIIIIIlIIIll[0], this.direction, 1.0);
                }
            }
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    static {
        TargetStrafe.mc = Minecraft.getMinecraft();
    }
    
    private boolean target(final Entity llllllllllllllIlIIlllIIIIIIIlllI) {
        return this.attackCheckin(llllllllllllllIlIIlllIIIIIIIlllI);
    }
    
    public static double getRandomInRange(final double llllllllllllllIlIIllIlllllIlIlII, final double llllllllllllllIlIIllIlllllIlIIll) {
        final Random llllllllllllllIlIIllIlllllIllIII = new Random();
        final double llllllllllllllIlIIllIlllllIlIlll = llllllllllllllIlIIllIlllllIlIIll - llllllllllllllIlIIllIlllllIlIlII;
        double llllllllllllllIlIIllIlllllIlIllI = llllllllllllllIlIIllIlllllIllIII.nextDouble() * llllllllllllllIlIIllIlllllIlIlll;
        if (llllllllllllllIlIIllIlllllIlIllI > llllllllllllllIlIIllIlllllIlIIll) {
            llllllllllllllIlIIllIlllllIlIllI = llllllllllllllIlIIllIlllllIlIIll;
        }
        double llllllllllllllIlIIllIlllllIlIlIl = llllllllllllllIlIIllIlllllIlIllI + llllllllllllllIlIIllIlllllIlIlII;
        if (llllllllllllllIlIIllIlllllIlIlIl > llllllllllllllIlIIllIlllllIlIIll) {
            llllllllllllllIlIIllIlllllIlIlIl = llllllllllllllIlIIllIlllllIlIIll;
        }
        return llllllllllllllIlIIllIlllllIlIlIl;
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public Entity getTarget() {
        if (TargetStrafe.mc.player == null || TargetStrafe.mc.player.isDead || TargetStrafe.mc.player.isInvisible()) {
            return null;
        }
        final List llllllllllllllIlIIlllIIIIIlIllIl = TargetStrafe.mc.world.loadedEntityList.stream().filter(llllllllllllllIlIIllIlllllIIIllI -> llllllllllllllIlIIllIlllllIIIllI != TargetStrafe.mc.player).filter(llllllllllllllIlIIllIlllllIIIlII -> TargetStrafe.mc.player.getDistanceToEntity(llllllllllllllIlIIllIlllllIIIlII) <= 6.0f).filter(llllllllllllllIlIIllIlllllIIIIIl -> !llllllllllllllIlIIllIlllllIIIIIl.isGlowing()).filter(llllllllllllllIlIIllIllllIllllIl -> !llllllllllllllIlIIllIllllIllllIl.isDead && Killaura.attackCheck(llllllllllllllIlIIllIllllIllllIl)).filter((Predicate<? super Object>)this::target).sorted(Comparator.comparing(llllllllllllllIlIIllIllllIlllIll -> TargetStrafe.mc.player.getDistanceToEntity(llllllllllllllIlIIllIllllIlllIll))).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList());
        if (llllllllllllllIlIIlllIIIIIlIllIl.size() > 0) {
            return llllllllllllllIlIIlllIIIIIlIllIl.get(0);
        }
        return null;
    }
}
