package me.nrules.module.combat;

import net.minecraft.client.settings.*;
import net.minecraft.item.*;
import me.nrules.event.events.*;
import me.nrules.event.*;
import net.minecraft.entity.passive.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;

public class AutoGApple extends Module
{
    private /* synthetic */ Setting health;
    private /* synthetic */ boolean eating;
    
    void stop() {
        KeyBinding.setKeyBindState(AutoGApple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
    }
    
    boolean isFood(final ItemStack llIIllIlII) {
        return !isNullOrEmptyStack(llIIllIlII) && llIIllIlII.getItem() instanceof ItemAppleGold;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llIIllllII) {
        if (AutoGApple.mc.player.getHealth() + AutoGApple.mc.player.getAbsorptionAmount() > this.health.getValDouble() && this.eating) {
            this.eating = false;
            this.stop();
            return;
        }
        if (!this.canEat()) {
            return;
        }
        if (this.isFood(AutoGApple.mc.player.getHeldItemOffhand()) && AutoGApple.mc.player.getHealth() <= this.health.getValDouble() && this.canEat()) {
            KeyBinding.setKeyBindState(AutoGApple.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
            this.eating = true;
        }
        if (!this.canEat()) {
            this.stop();
        }
    }
    
    public boolean canEat() {
        return AutoGApple.mc.objectMouseOver == null || !(AutoGApple.mc.objectMouseOver.entityHit instanceof EntityVillager);
    }
    
    public static boolean isNullOrEmptyStack(final ItemStack llIIlllIII) {
        return llIIlllIII == null || llIIlllIII.func_190926_b();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public AutoGApple() {
        super("AutoGapple", 0, Category.COMBAT);
        this.eating = false;
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Health", this, 15.0, 2.0, 20.0, false);
        this.health = setting;
        settingsManager.Property(setting);
    }
}
