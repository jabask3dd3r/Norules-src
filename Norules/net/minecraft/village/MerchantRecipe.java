package net.minecraft.village;

import net.minecraft.item.*;
import net.minecraft.nbt.*;

public class MerchantRecipe
{
    private /* synthetic */ ItemStack secondItemToBuy;
    private /* synthetic */ int toolUses;
    private /* synthetic */ int maxTradeUses;
    private /* synthetic */ ItemStack itemToBuy;
    private /* synthetic */ ItemStack itemToSell;
    private /* synthetic */ boolean rewardsExp;
    
    public ItemStack getItemToSell() {
        return this.itemToSell;
    }
    
    public MerchantRecipe(final ItemStack lllllllllllllIIIIIllllllIIIlIIll, final ItemStack lllllllllllllIIIIIllllllIIIIlllI, final ItemStack lllllllllllllIIIIIllllllIIIlIIIl) {
        this(lllllllllllllIIIIIllllllIIIlIIll, lllllllllllllIIIIIllllllIIIIlllI, lllllllllllllIIIIIllllllIIIlIIIl, 0, 7);
    }
    
    public int getToolUses() {
        return this.toolUses;
    }
    
    public void incrementToolUses() {
        ++this.toolUses;
    }
    
    public MerchantRecipe(final NBTTagCompound lllllllllllllIIIIIllllllIIIllIIl) {
        this.itemToBuy = ItemStack.field_190927_a;
        this.secondItemToBuy = ItemStack.field_190927_a;
        this.itemToSell = ItemStack.field_190927_a;
        this.readFromTags(lllllllllllllIIIIIllllllIIIllIIl);
    }
    
    public boolean isRecipeDisabled() {
        return this.toolUses >= this.maxTradeUses;
    }
    
    public boolean hasSecondItemToBuy() {
        return !this.secondItemToBuy.func_190926_b();
    }
    
    public MerchantRecipe(final ItemStack lllllllllllllIIIIIlllllIllllIIll, final ItemStack lllllllllllllIIIIIlllllIllllIlIl) {
        this(lllllllllllllIIIIIlllllIllllIIll, ItemStack.field_190927_a, lllllllllllllIIIIIlllllIllllIlIl);
    }
    
    public void compensateToolUses() {
        this.toolUses = this.maxTradeUses;
    }
    
    public void increaseMaxTradeUses(final int lllllllllllllIIIIIlllllIllIlIIII) {
        this.maxTradeUses += lllllllllllllIIIIIlllllIllIlIIII;
    }
    
    public boolean getRewardsExp() {
        return this.rewardsExp;
    }
    
    public MerchantRecipe(final ItemStack lllllllllllllIIIIIlllllIllllllll, final ItemStack lllllllllllllIIIIIlllllIlllllllI, final ItemStack lllllllllllllIIIIIlllllIllllllIl, final int lllllllllllllIIIIIllllllIIIIIIlI, final int lllllllllllllIIIIIlllllIlllllIll) {
        this.itemToBuy = ItemStack.field_190927_a;
        this.secondItemToBuy = ItemStack.field_190927_a;
        this.itemToSell = ItemStack.field_190927_a;
        this.itemToBuy = lllllllllllllIIIIIlllllIllllllll;
        this.secondItemToBuy = lllllllllllllIIIIIlllllIlllllllI;
        this.itemToSell = lllllllllllllIIIIIlllllIllllllIl;
        this.toolUses = lllllllllllllIIIIIllllllIIIIIIlI;
        this.maxTradeUses = lllllllllllllIIIIIlllllIlllllIll;
        this.rewardsExp = true;
    }
    
    public int getMaxTradeUses() {
        return this.maxTradeUses;
    }
    
    public MerchantRecipe(final ItemStack lllllllllllllIIIIIlllllIlllIlIlI, final Item lllllllllllllIIIIIlllllIlllIllII) {
        this(lllllllllllllIIIIIlllllIlllIlIlI, new ItemStack(lllllllllllllIIIIIlllllIlllIllII));
    }
    
    public ItemStack getItemToBuy() {
        return this.itemToBuy;
    }
    
    public NBTTagCompound writeToTags() {
        final NBTTagCompound lllllllllllllIIIIIlllllIlIllIlIl = new NBTTagCompound();
        lllllllllllllIIIIIlllllIlIllIlIl.setTag("buy", this.itemToBuy.writeToNBT(new NBTTagCompound()));
        lllllllllllllIIIIIlllllIlIllIlIl.setTag("sell", this.itemToSell.writeToNBT(new NBTTagCompound()));
        if (!this.secondItemToBuy.func_190926_b()) {
            lllllllllllllIIIIIlllllIlIllIlIl.setTag("buyB", this.secondItemToBuy.writeToNBT(new NBTTagCompound()));
        }
        lllllllllllllIIIIIlllllIlIllIlIl.setInteger("uses", this.toolUses);
        lllllllllllllIIIIIlllllIlIllIlIl.setInteger("maxUses", this.maxTradeUses);
        lllllllllllllIIIIIlllllIlIllIlIl.setBoolean("rewardExp", this.rewardsExp);
        return lllllllllllllIIIIIlllllIlIllIlIl;
    }
    
    public ItemStack getSecondItemToBuy() {
        return this.secondItemToBuy;
    }
    
    public void readFromTags(final NBTTagCompound lllllllllllllIIIIIlllllIlIllllll) {
        final NBTTagCompound lllllllllllllIIIIIlllllIlIlllllI = lllllllllllllIIIIIlllllIlIllllll.getCompoundTag("buy");
        this.itemToBuy = new ItemStack(lllllllllllllIIIIIlllllIlIlllllI);
        final NBTTagCompound lllllllllllllIIIIIlllllIlIllllIl = lllllllllllllIIIIIlllllIlIllllll.getCompoundTag("sell");
        this.itemToSell = new ItemStack(lllllllllllllIIIIIlllllIlIllllIl);
        if (lllllllllllllIIIIIlllllIlIllllll.hasKey("buyB", 10)) {
            this.secondItemToBuy = new ItemStack(lllllllllllllIIIIIlllllIlIllllll.getCompoundTag("buyB"));
        }
        if (lllllllllllllIIIIIlllllIlIllllll.hasKey("uses", 99)) {
            this.toolUses = lllllllllllllIIIIIlllllIlIllllll.getInteger("uses");
        }
        if (lllllllllllllIIIIIlllllIlIllllll.hasKey("maxUses", 99)) {
            this.maxTradeUses = lllllllllllllIIIIIlllllIlIllllll.getInteger("maxUses");
        }
        else {
            this.maxTradeUses = 7;
        }
        if (lllllllllllllIIIIIlllllIlIllllll.hasKey("rewardExp", 1)) {
            this.rewardsExp = lllllllllllllIIIIIlllllIlIllllll.getBoolean("rewardExp");
        }
        else {
            this.rewardsExp = true;
        }
    }
}
