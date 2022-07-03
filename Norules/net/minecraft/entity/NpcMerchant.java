package net.minecraft.entity;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.village.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.util.math.*;

public class NpcMerchant implements IMerchant
{
    private final /* synthetic */ EntityPlayer customer;
    private /* synthetic */ MerchantRecipeList recipeList;
    private final /* synthetic */ ITextComponent name;
    private final /* synthetic */ InventoryMerchant theMerchantInventory;
    
    @Override
    public void useRecipe(final MerchantRecipe lllllllllllllIIlllIIIIlIlIIIIlII) {
        lllllllllllllIIlllIIIIlIlIIIIlII.incrementToolUses();
    }
    
    @Nullable
    @Override
    public MerchantRecipeList getRecipes(final EntityPlayer lllllllllllllIIlllIIIIlIlIIIllll) {
        return this.recipeList;
    }
    
    @Override
    public void setCustomer(@Nullable final EntityPlayer lllllllllllllIIlllIIIIlIlIIlIIlI) {
    }
    
    @Override
    public World func_190670_t_() {
        return this.customer.world;
    }
    
    public NpcMerchant(final EntityPlayer lllllllllllllIIlllIIIIlIlIIllIII, final ITextComponent lllllllllllllIIlllIIIIlIlIIlIlll) {
        this.customer = lllllllllllllIIlllIIIIlIlIIllIII;
        this.name = lllllllllllllIIlllIIIIlIlIIlIlll;
        this.theMerchantInventory = new InventoryMerchant(lllllllllllllIIlllIIIIlIlIIllIII, this);
    }
    
    @Override
    public void verifySellingItem(final ItemStack lllllllllllllIIlllIIIIlIlIIIIIlI) {
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return (this.name != null) ? this.name : new TextComponentTranslation("entity.Villager.name", new Object[0]);
    }
    
    @Override
    public void setRecipes(@Nullable final MerchantRecipeList lllllllllllllIIlllIIIIlIlIIIlIII) {
        this.recipeList = lllllllllllllIIlllIIIIlIlIIIlIII;
    }
    
    @Override
    public BlockPos func_190671_u_() {
        return new BlockPos(this.customer);
    }
    
    @Nullable
    @Override
    public EntityPlayer getCustomer() {
        return this.customer;
    }
}
