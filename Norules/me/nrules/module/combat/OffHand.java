package me.nrules.module.combat;

import clickui.settings.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import me.nrules.event.events.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.item.*;
import me.nrules.event.*;
import com.kisman.nr.cc.util.*;
import net.minecraft.inventory.*;
import me.nrules.module.*;
import java.util.*;

public class OffHand extends Module
{
    private /* synthetic */ Setting totemOnElytra;
    private /* synthetic */ Setting mode;
    private /* synthetic */ Setting hotbarFirst;
    private /* synthetic */ Setting fallBackDistance;
    private /* synthetic */ Setting offhandGapOnSword;
    private /* synthetic */ Setting fallBackMode;
    private /* synthetic */ Setting health;
    
    public Item getItemFromModeVal(final String lllllllllllllIllIIllllIlIllllIll) {
        final short lllllllllllllIllIIllllIlIllllIlI = (short)lllllllllllllIllIIllllIlIllllIll;
        switch (lllllllllllllIllIIllllIlIllllIll.hashCode()) {
            case -1819473015: {
                if (!((String)lllllllllllllIllIIllllIlIllllIlI).equals("Shield")) {
                    break;
                }
                return Items.SHIELD;
            }
            case -1582753002: {
                if (!((String)lllllllllllllIllIIllllIlIllllIlI).equals("Crystal")) {
                    break;
                }
                return Items.END_CRYSTAL;
            }
            case 71350: {
                if (!((String)lllllllllllllIllIIllllIlIllllIlI).equals("Gap")) {
                    break;
                }
                return Items.GOLDEN_APPLE;
            }
            case 76987430: {
                if (!((String)lllllllllllllIllIIllllIlIllllIlI).equals("Pearl")) {
                    break;
                }
                return Items.ENDER_PEARL;
            }
            case 1855960161: {
                if (!((String)lllllllllllllIllIIllllIlIllllIlI).equals("Strength")) {
                    break;
                }
                return Items.POTIONITEM;
            }
            case 2017619398: {
                if (!((String)lllllllllllllIllIIllllIlIllllIlI).equals("Chorus")) {
                    break;
                }
                return Items.CHORUS_FRUIT;
            }
        }
        return Items.field_190929_cY;
    }
    
    private boolean isValidTarget(final EntityPlayer lllllllllllllIllIIllllIllIIIIIIl) {
        return lllllllllllllIllIIllllIllIIIIIIl != OffHand.mc.player && OffHand.mc.player.getDistanceToEntity(lllllllllllllIllIIllllIllIIIIIIl) <= 15.0f;
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIllIIllllIllIIIIlIl) {
        if (OffHand.mc.player == null && OffHand.mc.world == null) {
            return;
        }
        if (OffHand.mc.currentScreen != null && !(OffHand.mc.currentScreen instanceof GuiInventory)) {
            return;
        }
        if (!OffHand.mc.player.getHeldItemMainhand().func_190926_b() && this.health.getValDouble() <= OffHand.mc.player.getHealth() + OffHand.mc.player.getAbsorptionAmount() && OffHand.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword && this.offhandGapOnSword.getValBoolean()) {
            this.switchOffHandIfNeed("Gapple");
            return;
        }
        if (this.health.getValDouble() > OffHand.mc.player.getHealth() + OffHand.mc.player.getAbsorptionAmount() || this.mode.getValString().equalsIgnoreCase("Totem") || (this.totemOnElytra.getValBoolean() && OffHand.mc.player.isElytraFlying()) || (OffHand.mc.player.fallDistance >= this.fallBackDistance.getValDouble() && !OffHand.mc.player.isElytraFlying()) || this.noNearbyPlayers()) {
            this.switchOffHandIfNeed("Totem");
            return;
        }
        this.switchOffHandIfNeed(this.mode.getValString());
    }
    
    private boolean noNearbyPlayers() {
        return this.mode.getValString().equalsIgnoreCase("Crystal") && OffHand.mc.world.playerEntities.stream().noneMatch(lllllllllllllIllIIllllIlIllIllIl -> lllllllllllllIllIIllllIlIllIllIl != OffHand.mc.player && this.isValidTarget(lllllllllllllIllIIllllIlIllIllIl));
    }
    
    private void switchOffHandIfNeed(final String lllllllllllllIllIIllllIllIIIlIll) {
        final Item lllllllllllllIllIIllllIllIIIllll = this.getItemFromModeVal(lllllllllllllIllIIllllIllIIIlIll);
        if (OffHand.mc.player.getHeldItemOffhand().getItem() != lllllllllllllIllIIllllIllIIIllll) {
            int lllllllllllllIllIIllllIllIIIlllI = this.hotbarFirst.getValBoolean() ? PlayerUtil.GetRecursiveItemSlot(lllllllllllllIllIIllllIllIIIllll) : PlayerUtil.GetItemSlot(lllllllllllllIllIIllllIllIIIllll);
            Item lllllllllllllIllIIllllIllIIIllIl = this.getItemFromModeVal(this.fallBackMode.getValString());
            if (lllllllllllllIllIIllllIllIIIlllI == -1 && lllllllllllllIllIIllllIllIIIllll != lllllllllllllIllIIllllIllIIIllIl && OffHand.mc.player.getHeldItemOffhand().getItem() != lllllllllllllIllIIllllIllIIIllIl) {
                lllllllllllllIllIIllllIllIIIlllI = PlayerUtil.GetRecursiveItemSlot(lllllllllllllIllIIllllIllIIIllIl);
                if (lllllllllllllIllIIllllIllIIIlllI == -1 && lllllllllllllIllIIllllIllIIIllIl != Items.field_190929_cY) {
                    lllllllllllllIllIIllllIllIIIllIl = Items.field_190929_cY;
                    if (lllllllllllllIllIIllllIllIIIllll != lllllllllllllIllIIllllIllIIIllIl && OffHand.mc.player.getHeldItemOffhand().getItem() != lllllllllllllIllIIllllIllIIIllIl) {
                        lllllllllllllIllIIllllIllIIIlllI = PlayerUtil.GetRecursiveItemSlot(lllllllllllllIllIIllllIllIIIllIl);
                    }
                }
            }
            if (lllllllllllllIllIIllllIllIIIlllI != -1) {
                OffHand.mc.playerController.windowClick(OffHand.mc.player.inventoryContainer.windowId, lllllllllllllIllIIllllIllIIIlllI, 0, ClickType.PICKUP, OffHand.mc.player);
                OffHand.mc.playerController.windowClick(OffHand.mc.player.inventoryContainer.windowId, 45, 0, ClickType.PICKUP, OffHand.mc.player);
                OffHand.mc.playerController.windowClick(OffHand.mc.player.inventoryContainer.windowId, lllllllllllllIllIIllllIllIIIlllI, 0, ClickType.PICKUP, OffHand.mc.player);
                OffHand.mc.playerController.updateController();
            }
        }
    }
    
    public OffHand() {
        super("OffHand", 0, Category.COMBAT);
        this.health = new Setting("Health", this, 11.0, 0.0, 20.0, true);
        this.mode = new Setting("Mode", this, "Totem", new ArrayList<String>(Arrays.asList("Totem", "Crystal", "Gapple", "Pearl", "Chorus", "Strength", "Shield")));
        this.fallBackMode = new Setting("FallBackMode", this, "Crystal", new ArrayList<String>(Arrays.asList("Totem", "Crystal", "Gapple", "Pearl", "Chorus", "Strength", "Shield")));
        this.fallBackDistance = new Setting("FallBackDistance", this, 15.0, 0.0, 100.0, true);
        this.totemOnElytra = new Setting("TotemOnElytra", this, true);
        this.offhandGapOnSword = new Setting("OffhandGapOnSword", this, true);
        this.hotbarFirst = new Setting("HotbarFirst", this, false);
        OffHand.sm.Property(this.mode);
        OffHand.sm.Property(this.fallBackMode);
        OffHand.sm.Property(this.fallBackDistance);
        OffHand.sm.Property(this.totemOnElytra);
        OffHand.sm.Property(this.offhandGapOnSword);
        OffHand.sm.Property(this.hotbarFirst);
    }
    
    private String getItemNameFromModeVal(final String lllllllllllllIllIIllllIlIlllIlIl) {
        final char lllllllllllllIllIIllllIlIlllIlII = (char)lllllllllllllIllIIllllIlIlllIlIl;
        switch (lllllllllllllIllIIllllIlIlllIlIl.hashCode()) {
            case -1819473015: {
                if (!((String)lllllllllllllIllIIllllIlIlllIlII).equals("Shield")) {
                    break;
                }
                return "Shield";
            }
            case -1582753002: {
                if (!((String)lllllllllllllIllIIllllIlIlllIlII).equals("Crystal")) {
                    break;
                }
                return "End Crystal";
            }
            case 71350: {
                if (!((String)lllllllllllllIllIIllllIlIlllIlII).equals("Gap")) {
                    break;
                }
                return "Gap";
            }
            case 76987430: {
                if (!((String)lllllllllllllIllIIllllIlIlllIlII).equals("Pearl")) {
                    break;
                }
                return "Pearl";
            }
            case 1855960161: {
                if (!((String)lllllllllllllIllIIllllIlIlllIlII).equals("Strength")) {
                    break;
                }
                return "Strength";
            }
            case 2017619398: {
                if (!((String)lllllllllllllIllIIllllIlIlllIlII).equals("Chorus")) {
                    break;
                }
                return "Chorus";
            }
        }
        return "Totem";
    }
}
