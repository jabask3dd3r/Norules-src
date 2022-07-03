package net.minecraft.inventory;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.village.*;

public class SlotMerchantResult extends Slot
{
    private /* synthetic */ int removeCount;
    private final /* synthetic */ IMerchant theMerchant;
    private final /* synthetic */ InventoryMerchant theMerchantInventory;
    private final /* synthetic */ EntityPlayer thePlayer;
    
    @Override
    public ItemStack func_190901_a(final EntityPlayer lllllllllllllIllllllIIlIlIlllIlI, final ItemStack lllllllllllllIllllllIIlIlIlllIIl) {
        this.onCrafting(lllllllllllllIllllllIIlIlIlllIIl);
        final MerchantRecipe lllllllllllllIllllllIIlIlIlllllI = this.theMerchantInventory.getCurrentRecipe();
        if (lllllllllllllIllllllIIlIlIlllllI != null) {
            final ItemStack lllllllllllllIllllllIIlIlIllllIl = this.theMerchantInventory.getStackInSlot(0);
            final ItemStack lllllllllllllIllllllIIlIlIllllII = this.theMerchantInventory.getStackInSlot(1);
            if (this.doTrade(lllllllllllllIllllllIIlIlIlllllI, lllllllllllllIllllllIIlIlIllllIl, lllllllllllllIllllllIIlIlIllllII) || this.doTrade(lllllllllllllIllllllIIlIlIlllllI, lllllllllllllIllllllIIlIlIllllII, lllllllllllllIllllllIIlIlIllllIl)) {
                this.theMerchant.useRecipe(lllllllllllllIllllllIIlIlIlllllI);
                lllllllllllllIllllllIIlIlIlllIlI.addStat(StatList.TRADED_WITH_VILLAGER);
                this.theMerchantInventory.setInventorySlotContents(0, lllllllllllllIllllllIIlIlIllllIl);
                this.theMerchantInventory.setInventorySlotContents(1, lllllllllllllIllllllIIlIlIllllII);
            }
        }
        return lllllllllllllIllllllIIlIlIlllIIl;
    }
    
    @Override
    protected void onCrafting(final ItemStack lllllllllllllIllllllIIlIllIIllll, final int lllllllllllllIllllllIIlIllIlIIIl) {
        this.removeCount += lllllllllllllIllllllIIlIllIlIIIl;
        this.onCrafting(lllllllllllllIllllllIIlIllIIllll);
    }
    
    @Override
    public boolean isItemValid(final ItemStack lllllllllllllIllllllIIlIllIlllIl) {
        return false;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIllllllIIlIllIlIlll) {
        if (this.getHasStack()) {
            this.removeCount += Math.min(lllllllllllllIllllllIIlIllIlIlll, this.getStack().func_190916_E());
        }
        return super.decrStackSize(lllllllllllllIllllllIIlIllIlIlll);
    }
    
    @Override
    protected void onCrafting(final ItemStack lllllllllllllIllllllIIlIllIIlIlI) {
        lllllllllllllIllllllIIlIllIIlIlI.onCrafting(this.thePlayer.world, this.thePlayer, this.removeCount);
        this.removeCount = 0;
    }
    
    public SlotMerchantResult(final EntityPlayer lllllllllllllIllllllIIlIlllIlIll, final IMerchant lllllllllllllIllllllIIlIlllIlIlI, final InventoryMerchant lllllllllllllIllllllIIlIlllIlIIl, final int lllllllllllllIllllllIIlIlllIlIII, final int lllllllllllllIllllllIIlIlllIIlll, final int lllllllllllllIllllllIIlIllIlllll) {
        super(lllllllllllllIllllllIIlIlllIlIIl, lllllllllllllIllllllIIlIlllIlIII, lllllllllllllIllllllIIlIlllIIlll, lllllllllllllIllllllIIlIllIlllll);
        this.thePlayer = lllllllllllllIllllllIIlIlllIlIll;
        this.theMerchant = lllllllllllllIllllllIIlIlllIlIlI;
        this.theMerchantInventory = lllllllllllllIllllllIIlIlllIlIIl;
    }
    
    private boolean doTrade(final MerchantRecipe lllllllllllllIllllllIIlIlIlIllll, final ItemStack lllllllllllllIllllllIIlIlIlIlIIl, final ItemStack lllllllllllllIllllllIIlIlIlIlIII) {
        final ItemStack lllllllllllllIllllllIIlIlIlIllII = lllllllllllllIllllllIIlIlIlIllll.getItemToBuy();
        final ItemStack lllllllllllllIllllllIIlIlIlIlIll = lllllllllllllIllllllIIlIlIlIllll.getSecondItemToBuy();
        if (lllllllllllllIllllllIIlIlIlIlIIl.getItem() == lllllllllllllIllllllIIlIlIlIllII.getItem() && lllllllllllllIllllllIIlIlIlIlIIl.func_190916_E() >= lllllllllllllIllllllIIlIlIlIllII.func_190916_E()) {
            if (!lllllllllllllIllllllIIlIlIlIlIll.func_190926_b() && !lllllllllllllIllllllIIlIlIlIlIII.func_190926_b() && lllllllllllllIllllllIIlIlIlIlIll.getItem() == lllllllllllllIllllllIIlIlIlIlIII.getItem() && lllllllllllllIllllllIIlIlIlIlIII.func_190916_E() >= lllllllllllllIllllllIIlIlIlIlIll.func_190916_E()) {
                lllllllllllllIllllllIIlIlIlIlIIl.func_190918_g(lllllllllllllIllllllIIlIlIlIllII.func_190916_E());
                lllllllllllllIllllllIIlIlIlIlIII.func_190918_g(lllllllllllllIllllllIIlIlIlIlIll.func_190916_E());
                return true;
            }
            if (lllllllllllllIllllllIIlIlIlIlIll.func_190926_b() && lllllllllllllIllllllIIlIlIlIlIII.func_190926_b()) {
                lllllllllllllIllllllIIlIlIlIlIIl.func_190918_g(lllllllllllllIllllllIIlIlIlIllII.func_190916_E());
                return true;
            }
        }
        return false;
    }
}
