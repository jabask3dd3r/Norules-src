package com.kisman.nr.cc.util;

import net.minecraft.client.*;
import net.minecraft.item.*;

public class PlayerUtil
{
    private static final /* synthetic */ Minecraft mc;
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    public static int GetItemSlot(final Item llllllllllllllIIlllIIlIlIIlIllll) {
        if (PlayerUtil.mc.player == null) {
            return 0;
        }
        for (int llllllllllllllIIlllIIlIlIIllIIIl = 0; llllllllllllllIIlllIIlIlIIllIIIl < PlayerUtil.mc.player.inventoryContainer.getInventory().size(); ++llllllllllllllIIlllIIlIlIIllIIIl) {
            if (llllllllllllllIIlllIIlIlIIllIIIl != 0 && llllllllllllllIIlllIIlIlIIllIIIl != 5 && llllllllllllllIIlllIIlIlIIllIIIl != 6 && llllllllllllllIIlllIIlIlIIllIIIl != 7) {
                if (llllllllllllllIIlllIIlIlIIllIIIl != 8) {
                    final ItemStack llllllllllllllIIlllIIlIlIIllIIII = PlayerUtil.mc.player.inventoryContainer.getInventory().get(llllllllllllllIIlllIIlIlIIllIIIl);
                    if (!llllllllllllllIIlllIIlIlIIllIIII.func_190926_b()) {
                        if (llllllllllllllIIlllIIlIlIIllIIII.getItem() == llllllllllllllIIlllIIlIlIIlIllll) {
                            return llllllllllllllIIlllIIlIlIIllIIIl;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public static int GetRecursiveItemSlot(final Item llllllllllllllIIlllIIlIlIIlllIII) {
        if (PlayerUtil.mc.player == null) {
            return 0;
        }
        for (int llllllllllllllIIlllIIlIlIIlllIlI = PlayerUtil.mc.player.inventoryContainer.getInventory().size() - 1; llllllllllllllIIlllIIlIlIIlllIlI > 0; --llllllllllllllIIlllIIlIlIIlllIlI) {
            if (llllllllllllllIIlllIIlIlIIlllIlI != 0 && llllllllllllllIIlllIIlIlIIlllIlI != 5 && llllllllllllllIIlllIIlIlIIlllIlI != 6 && llllllllllllllIIlllIIlIlIIlllIlI != 7) {
                if (llllllllllllllIIlllIIlIlIIlllIlI != 8) {
                    final ItemStack llllllllllllllIIlllIIlIlIIlllIIl = PlayerUtil.mc.player.inventoryContainer.getInventory().get(llllllllllllllIIlllIIlIlIIlllIlI);
                    if (!llllllllllllllIIlllIIlIlIIlllIIl.func_190926_b()) {
                        if (llllllllllllllIIlllIIlIlIIlllIIl.getItem() == llllllllllllllIIlllIIlIlIIlllIII) {
                            return llllllllllllllIIlllIIlIlIIlllIlI;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
