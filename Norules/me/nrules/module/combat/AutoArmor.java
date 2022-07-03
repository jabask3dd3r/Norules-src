package me.nrules.module.combat;

import clickui.settings.*;
import me.nrules.event.events.*;
import me.nrules.event.*;
import me.nrules.module.*;
import net.minecraft.init.*;
import me.nrules.*;
import me.nrules.notifications.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;

public class AutoArmor extends Module
{
    public static /* synthetic */ Setting inventory;
    private /* synthetic */ int timer;
    private final /* synthetic */ Item NULL_ITEM;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIIIIlllIlIIIIlIIlI) {
        if (AutoArmor.inventory.getValBoolean() && AutoArmor.mc.currentScreen != null) {
            this.equip();
        }
        if (!AutoArmor.inventory.getValBoolean() && AutoArmor.mc.currentScreen == null) {
            this.equip();
        }
    }
    
    public boolean isEmptySlot(final ItemStack lllllllllllllIIIIIlllIIllllIllII) {
        return lllllllllllllIIIIIlllIIllllIllII.getItem() == this.NULL_ITEM;
    }
    
    public AutoArmor() {
        super("AutoArmor", 0, Category.COMBAT);
        this.NULL_ITEM = Item.getItemFromBlock(Blocks.AIR);
        Main.settingsManager.Property(AutoArmor.inventory = new Setting("Inventory", this, false));
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    private void equip() {
        if (this.timer > 0) {
            --this.timer;
            return;
        }
        if (AutoArmor.mc.currentScreen instanceof GuiContainer && !(AutoArmor.mc.currentScreen instanceof InventoryEffectRenderer)) {
            return;
        }
        final int[] lllllllllllllIIIIIlllIlIIIIIIlll = new int[4];
        final int[] lllllllllllllIIIIIlllIlIIIIIIllI = new int[4];
        for (int lllllllllllllIIIIIlllIlIIIIIIlIl = 0; lllllllllllllIIIIIlllIlIIIIIIlIl < 4; ++lllllllllllllIIIIIlllIlIIIIIIlIl) {
            final ItemStack lllllllllllllIIIIIlllIlIIIIIIlII = AutoArmor.mc.player.inventory.armorItemInSlot(lllllllllllllIIIIIlllIlIIIIIIlIl);
            if (lllllllllllllIIIIIlllIlIIIIIIlII != null && lllllllllllllIIIIIlllIlIIIIIIlII.getItem() instanceof ItemArmor) {
                lllllllllllllIIIIIlllIlIIIIIIllI[lllllllllllllIIIIIlllIlIIIIIIlIl] = ((ItemArmor)lllllllllllllIIIIIlllIlIIIIIIlII.getItem()).damageReduceAmount;
            }
            lllllllllllllIIIIIlllIlIIIIIIlll[lllllllllllllIIIIIlllIlIIIIIIlIl] = -1;
        }
        for (int lllllllllllllIIIIIlllIlIIIIIIIll = 0; lllllllllllllIIIIIlllIlIIIIIIIll < 36; ++lllllllllllllIIIIIlllIlIIIIIIIll) {
            final ItemStack lllllllllllllIIIIIlllIlIIIIIIIlI = AutoArmor.mc.player.inventory.getStackInSlot(lllllllllllllIIIIIlllIlIIIIIIIll);
            if (lllllllllllllIIIIIlllIlIIIIIIIlI != null) {
                if (lllllllllllllIIIIIlllIlIIIIIIIlI.getItem() instanceof ItemArmor) {
                    final ItemArmor lllllllllllllIIIIIlllIlIIIIIIIIl = (ItemArmor)lllllllllllllIIIIIlllIlIIIIIIIlI.getItem();
                    final int lllllllllllllIIIIIlllIlIIIIIIIII = this.getArmorType(lllllllllllllIIIIIlllIlIIIIIIIIl);
                    final int lllllllllllllIIIIIlllIIlllllllll = lllllllllllllIIIIIlllIlIIIIIIIIl.damageReduceAmount;
                    if (lllllllllllllIIIIIlllIIlllllllll > lllllllllllllIIIIIlllIlIIIIIIllI[lllllllllllllIIIIIlllIlIIIIIIIII]) {
                        lllllllllllllIIIIIlllIlIIIIIIlll[lllllllllllllIIIIIlllIlIIIIIIIII] = lllllllllllllIIIIIlllIlIIIIIIIll;
                        lllllllllllllIIIIIlllIlIIIIIIllI[lllllllllllllIIIIIlllIlIIIIIIIII] = lllllllllllllIIIIIlllIIlllllllll;
                    }
                }
            }
        }
        for (int lllllllllllllIIIIIlllIIllllllllI = 0; lllllllllllllIIIIIlllIIllllllllI < 4; ++lllllllllllllIIIIIlllIIllllllllI) {
            int lllllllllllllIIIIIlllIIlllllllIl = lllllllllllllIIIIIlllIlIIIIIIlll[lllllllllllllIIIIIlllIIllllllllI];
            if (lllllllllllllIIIIIlllIIlllllllIl != -1) {
                final ItemStack lllllllllllllIIIIIlllIIlllllllII = AutoArmor.mc.player.inventory.armorItemInSlot(lllllllllllllIIIIIlllIIllllllllI);
                if (lllllllllllllIIIIIlllIIlllllllII == null || !this.isEmptySlot(lllllllllllllIIIIIlllIIlllllllII) || AutoArmor.mc.player.inventory.getFirstEmptyStack() != -1) {
                    if (lllllllllllllIIIIIlllIIlllllllIl < 9) {
                        lllllllllllllIIIIIlllIIlllllllIl += 36;
                    }
                    AutoArmor.mc.playerController.windowClick(0, 8 - lllllllllllllIIIIIlllIIllllllllI, 0, ClickType.QUICK_MOVE, AutoArmor.mc.player);
                    AutoArmor.mc.playerController.windowClick(0, lllllllllllllIIIIIlllIIlllllllIl, 0, ClickType.QUICK_MOVE, AutoArmor.mc.player);
                    break;
                }
            }
        }
        this.timer = 4;
    }
    
    public int getArmorType(final ItemArmor lllllllllllllIIIIIlllIIlllllIIIl) {
        return lllllllllllllIIIIIlllIIlllllIIIl.armorType.ordinal() - 2;
    }
    
    @Override
    public void onEnable() {
        this.timer = 0;
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public static boolean isNullOrEmpty(final ItemStack lllllllllllllIIIIIlllIIllllIIlll) {
        return lllllllllllllIIIIIlllIIllllIIlll == null || lllllllllllllIIIIIlllIIllllIIlll.func_190926_b();
    }
}
