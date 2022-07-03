package net.minecraft.client.gui.inventory;

import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;

public class CreativeCrafting implements IContainerListener
{
    private final /* synthetic */ Minecraft mc;
    
    @Override
    public void updateCraftingInventory(final Container lllllllllllllllllllIIIIIIIIIllII, final NonNullList<ItemStack> lllllllllllllllllllIIIIIIIIIlIll) {
    }
    
    @Override
    public void sendAllWindowProperties(final Container llllllllllllllllllIllllllllllIll, final IInventory llllllllllllllllllIllllllllllIlI) {
    }
    
    @Override
    public void sendSlotContents(final Container lllllllllllllllllllIIIIIIIIIIllI, final int lllllllllllllllllllIIIIIIIIIIlIl, final ItemStack lllllllllllllllllllIIIIIIIIIIIIl) {
        this.mc.playerController.sendSlotPacket(lllllllllllllllllllIIIIIIIIIIIIl, lllllllllllllllllllIIIIIIIIIIlIl);
    }
    
    public CreativeCrafting(final Minecraft lllllllllllllllllllIIIIIIIIIlllI) {
        this.mc = lllllllllllllllllllIIIIIIIIIlllI;
    }
    
    @Override
    public void sendProgressBarUpdate(final Container llllllllllllllllllIlllllllllllll, final int llllllllllllllllllIllllllllllllI, final int llllllllllllllllllIlllllllllllIl) {
    }
}
