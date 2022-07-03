package com.kisman.nr.cc.util;

import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class InventoryUtil
{
    private static final /* synthetic */ Minecraft mc;
    
    public static int findItem(final Item lllllllllllllIllIllIllllIIIlllIl, final int lllllllllllllIllIllIllllIIIlllII, final int lllllllllllllIllIllIllllIIIllIll) {
        for (int lllllllllllllIllIllIllllIIIllIlI = lllllllllllllIllIllIllllIIIlllII; lllllllllllllIllIllIllllIIIllIlI <= lllllllllllllIllIllIllllIIIllIll; ++lllllllllllllIllIllIllllIIIllIlI) {
            final ItemStack lllllllllllllIllIllIllllIIIllIIl = InventoryUtil.mc.player.inventory.getStackInSlot(lllllllllllllIllIllIllllIIIllIlI);
            if (lllllllllllllIllIllIllllIIIllIIl.getItem() == lllllllllllllIllIllIllllIIIlllIl) {
                return lllllllllllllIllIllIllllIIIllIlI;
            }
        }
        return -1;
    }
    
    public static int findBlock(final Block lllllllllllllIllIllIllllIIIIllIl, final int lllllllllllllIllIllIllllIIIIllII, final int lllllllllllllIllIllIllllIIIIlIll) {
        for (int lllllllllllllIllIllIllllIIIIlIlI = lllllllllllllIllIllIllllIIIIllII; lllllllllllllIllIllIllllIIIIlIlI <= lllllllllllllIllIllIllllIIIIlIll; ++lllllllllllllIllIllIllllIIIIlIlI) {
            final ItemStack lllllllllllllIllIllIllllIIIIlIIl = InventoryUtil.mc.player.inventory.getStackInSlot(lllllllllllllIllIllIllllIIIIlIlI);
            if (lllllllllllllIllIllIllllIIIIlIIl.getItem() instanceof ItemBlock) {
                final ItemBlock lllllllllllllIllIllIllllIIIIlIII = (ItemBlock)lllllllllllllIllIllIllllIIIIlIIl.getItem();
                if (lllllllllllllIllIllIllllIIIIlIII.getBlock() == lllllllllllllIllIllIllllIIIIllIl) {
                    return lllllllllllllIllIllIllllIIIIlIlI;
                }
            }
        }
        return -1;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory() {
        final int[] $switch_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory = InventoryUtil.$SWITCH_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory;
        if ($switch_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory != null) {
            return $switch_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory;
        }
        final long lllllllllllllIllIllIlllIllllIIll = (Object)new int[Inventory.values().length];
        try {
            lllllllllllllIllIllIlllIllllIIll[Inventory.CRAFTING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllIllIlllIllllIIll[Inventory.HOTBAR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllIllIlllIllllIIll[Inventory.INVENTORY.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return InventoryUtil.$SWITCH_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory = (int[])(Object)lllllllllllllIllIllIlllIllllIIll;
    }
    
    public static void switchToSlot(final int lllllllllllllIllIllIllllIIlIIllI, final boolean lllllllllllllIllIllIllllIIlIIIll) {
        if (!lllllllllllllIllIllIllllIIlIIIll) {
            InventoryUtil.mc.player.connection.sendPacket(new CPacketHeldItemChange(lllllllllllllIllIllIllllIIlIIllI));
        }
        else {
            InventoryUtil.mc.player.connection.sendPacket(new CPacketHeldItemChange(lllllllllllllIllIllIllllIIlIIllI));
            InventoryUtil.mc.player.inventory.currentItem = lllllllllllllIllIllIllllIIlIIllI;
        }
    }
    
    public static int getItemSlot(final Item lllllllllllllIllIllIlllIllllllIl, final Inventory lllllllllllllIllIllIlllIllllIlll, final boolean lllllllllllllIllIllIlllIlllllIll) {
        switch ($SWITCH_TABLE$com$kisman$nr$cc$util$InventoryUtil$Inventory()[lllllllllllllIllIllIlllIllllIlll.ordinal()]) {
            case 2: {
                for (int lllllllllllllIllIllIlllIlllllIlI = 0; lllllllllllllIllIllIlllIlllllIlI < 9; ++lllllllllllllIllIllIlllIlllllIlI) {
                    if (InventoryUtil.mc.player.inventory.getStackInSlot(lllllllllllllIllIllIlllIlllllIlI).getItem() == lllllllllllllIllIllIlllIllllllIl) {
                        return lllllllllllllIllIllIlllIlllllIlI;
                    }
                }
                break;
            }
            case 1: {
                for (int lllllllllllllIllIllIlllIlllllIIl = lllllllllllllIllIllIlllIlllllIll ? 9 : 0; lllllllllllllIllIllIlllIlllllIIl < 45; ++lllllllllllllIllIllIlllIlllllIIl) {
                    if (InventoryUtil.mc.player.inventory.getStackInSlot(lllllllllllllIllIllIlllIlllllIIl).getItem() == lllllllllllllIllIllIlllIllllllIl) {
                        return lllllllllllllIllIllIlllIlllllIIl;
                    }
                }
                break;
            }
        }
        return -1;
    }
    
    public enum Inventory
    {
        CRAFTING("CRAFTING", 2), 
        HOTBAR("HOTBAR", 1), 
        INVENTORY("INVENTORY", 0);
        
        private Inventory(final String lllllllllllllIlIIIIlllIlIlllIlII, final int lllllllllllllIlIIIIlllIlIlllIIll) {
        }
    }
}
