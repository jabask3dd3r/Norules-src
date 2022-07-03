package me.nrules.module.combat;

import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import me.nrules.event.events.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import me.nrules.event.*;
import net.minecraft.item.*;

public class AutoTotem extends Module
{
    private /* synthetic */ Setting fallCheck;
    private /* synthetic */ boolean switching;
    private /* synthetic */ Setting crystal;
    private /* synthetic */ Setting health;
    private /* synthetic */ int lastSlot;
    
    public AutoTotem() {
        super("AutoTotem", 0, Category.COMBAT);
        this.switching = false;
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Health", this, 18.0, 1.0, 20.0, true);
        this.health = setting;
        settingsManager.Property(setting);
        final SM settingsManager2 = Main.settingsManager;
        final Setting setting2 = new Setting("CrystalCheck", this, true);
        this.crystal = setting2;
        settingsManager2.Property(setting2);
        final SM settingsManager3 = Main.settingsManager;
        final Setting setting3 = new Setting("TNTCheck", this, true);
        this.crystal = setting3;
        settingsManager3.Property(setting3);
        final SM settingsManager4 = Main.settingsManager;
        final Setting setting4 = new Setting("FallCheck", this, true);
        this.fallCheck = setting4;
        settingsManager4.Property(setting4);
    }
    
    public void swapTotem(final int lllllllllllllIIlIlllIlIlIlllllll, final int lllllllllllllIIlIlllIlIlIllllllI) {
        if (lllllllllllllIIlIlllIlIlIlllllll == -1) {
            return;
        }
        if (lllllllllllllIIlIlllIlIlIllllllI == 0) {
            AutoTotem.mc.playerController.windowClick(0, lllllllllllllIIlIlllIlIlIlllllll, 0, ClickType.PICKUP, AutoTotem.mc.player);
            AutoTotem.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, AutoTotem.mc.player);
            AutoTotem.mc.playerController.windowClick(0, lllllllllllllIIlIlllIlIlIlllllll, 0, ClickType.PICKUP, AutoTotem.mc.player);
        }
        if (lllllllllllllIIlIlllIlIlIllllllI == 1) {
            AutoTotem.mc.playerController.windowClick(0, lllllllllllllIIlIlllIlIlIlllllll, 0, ClickType.PICKUP, AutoTotem.mc.player);
            this.switching = true;
            this.lastSlot = lllllllllllllIIlIlllIlIlIlllllll;
        }
        if (lllllllllllllIIlIlllIlIlIllllllI == 2) {
            AutoTotem.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, AutoTotem.mc.player);
            AutoTotem.mc.playerController.windowClick(0, lllllllllllllIIlIlllIlIlIlllllll, 0, ClickType.PICKUP, AutoTotem.mc.player);
            this.switching = false;
        }
        AutoTotem.mc.playerController.updateController();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIlIlllIlIllIIlIlII) {
        if (AutoTotem.mc.currentScreen == null || AutoTotem.mc.currentScreen instanceof GuiInventory) {
            final int lllllllllllllIIlIlllIlIllIIlIIll = (int)Math.ceil(AutoTotem.mc.player.getHealth());
            if (this.switching) {
                this.swapTotem(this.lastSlot, 2);
                return;
            }
            if ((AutoTotem.mc.player.getHeldItemOffhand().getItem() == Items.field_190931_a || AutoTotem.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE || AutoTotem.mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL || AutoTotem.mc.player.getHeldItemOffhand().getItem() == Items.SHIELD) && lllllllllllllIIlIlllIlIllIIlIIll <= Main.settingsManager.getSettingByName("Health").getValDouble()) {
                this.swapTotem(this.getTotem(), 2);
            }
            for (final Entity lllllllllllllIIlIlllIlIllIIlIIlI : AutoTotem.mc.world.loadedEntityList) {
                if (lllllllllllllIIlIlllIlIllIIlIIlI instanceof EntityEnderCrystal && AutoTotem.mc.player.getDistanceToEntity(lllllllllllllIIlIlllIlIllIIlIIlI) < 7.0f && Main.settingsManager.getSettingByName("CrystalCheck").getValBoolean()) {
                    this.swapTotem(this.getTotem(), 2);
                }
                if (lllllllllllllIIlIlllIlIllIIlIIlI instanceof EntityMinecartTNT && AutoTotem.mc.player.getDistanceToEntity(lllllllllllllIIlIlllIlIllIIlIIlI) < 7.0f && Main.settingsManager.getSettingByName("TNTCheck").getValBoolean()) {
                    this.swapTotem(this.getTotem(), 2);
                }
            }
            if (AutoTotem.mc.player.fallDistance > 10.0f && Main.settingsManager.getSettingByName("FallCheck").getValBoolean()) {
                this.swapTotem(this.getTotem(), 2);
            }
        }
    }
    
    private int getTotem() {
        if (Items.field_190929_cY == AutoTotem.mc.player.getHeldItemOffhand().getItem()) {
            return -1;
        }
        int lllllllllllllIIlIlllIlIllIIIlIlI = 36;
        while (lllllllllllllIIlIlllIlIllIIIlIlI >= 0) {
            final Item lllllllllllllIIlIlllIlIllIIIlIIl = AutoTotem.mc.player.inventory.getStackInSlot(lllllllllllllIIlIlllIlIllIIIlIlI).getItem();
            if (lllllllllllllIIlIlllIlIllIIIlIIl == Items.field_190929_cY) {
                if (lllllllllllllIIlIlllIlIllIIIlIlI < 9) {
                    return -1;
                }
                return lllllllllllllIIlIlllIlIllIIIlIlI;
            }
            else {
                --lllllllllllllIIlIlllIlIllIIIlIlI;
            }
        }
        return -1;
    }
}
