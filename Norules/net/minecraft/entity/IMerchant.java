package net.minecraft.entity;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.village.*;
import net.minecraft.util.text.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import javax.annotation.*;

public interface IMerchant
{
    void useRecipe(final MerchantRecipe p0);
    
    void setCustomer(final EntityPlayer p0);
    
    World func_190670_t_();
    
    void setRecipes(final MerchantRecipeList p0);
    
    ITextComponent getDisplayName();
    
    BlockPos func_190671_u_();
    
    void verifySellingItem(final ItemStack p0);
    
    @Nullable
    EntityPlayer getCustomer();
    
    @Nullable
    MerchantRecipeList getRecipes(final EntityPlayer p0);
}
