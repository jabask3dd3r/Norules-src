package net.minecraft.village;

import java.util.*;
import net.minecraft.network.*;
import net.minecraft.item.*;
import java.io.*;
import javax.annotation.*;
import net.minecraft.nbt.*;

public class MerchantRecipeList extends ArrayList<MerchantRecipe>
{
    public static MerchantRecipeList readFromBuf(final PacketBuffer lllllllllllllIllIIlIIIIIIIIlIIIl) throws IOException {
        final MerchantRecipeList lllllllllllllIllIIlIIIIIIIIllIll = new MerchantRecipeList();
        for (int lllllllllllllIllIIlIIIIIIIIllIlI = lllllllllllllIllIIlIIIIIIIIlIIIl.readByte() & 0xFF, lllllllllllllIllIIlIIIIIIIIllIIl = 0; lllllllllllllIllIIlIIIIIIIIllIIl < lllllllllllllIllIIlIIIIIIIIllIlI; ++lllllllllllllIllIIlIIIIIIIIllIIl) {
            final ItemStack lllllllllllllIllIIlIIIIIIIIllIII = lllllllllllllIllIIlIIIIIIIIlIIIl.readItemStackFromBuffer();
            final ItemStack lllllllllllllIllIIlIIIIIIIIlIlll = lllllllllllllIllIIlIIIIIIIIlIIIl.readItemStackFromBuffer();
            ItemStack lllllllllllllIllIIlIIIIIIIIlIllI = ItemStack.field_190927_a;
            if (lllllllllllllIllIIlIIIIIIIIlIIIl.readBoolean()) {
                lllllllllllllIllIIlIIIIIIIIlIllI = lllllllllllllIllIIlIIIIIIIIlIIIl.readItemStackFromBuffer();
            }
            final boolean lllllllllllllIllIIlIIIIIIIIlIlIl = lllllllllllllIllIIlIIIIIIIIlIIIl.readBoolean();
            final int lllllllllllllIllIIlIIIIIIIIlIlII = lllllllllllllIllIIlIIIIIIIIlIIIl.readInt();
            final int lllllllllllllIllIIlIIIIIIIIlIIll = lllllllllllllIllIIlIIIIIIIIlIIIl.readInt();
            final MerchantRecipe lllllllllllllIllIIlIIIIIIIIlIIlI = new MerchantRecipe(lllllllllllllIllIIlIIIIIIIIllIII, lllllllllllllIllIIlIIIIIIIIlIllI, lllllllllllllIllIIlIIIIIIIIlIlll, lllllllllllllIllIIlIIIIIIIIlIlII, lllllllllllllIllIIlIIIIIIIIlIIll);
            if (lllllllllllllIllIIlIIIIIIIIlIlIl) {
                lllllllllllllIllIIlIIIIIIIIlIIlI.compensateToolUses();
            }
            lllllllllllllIllIIlIIIIIIIIllIll.add(lllllllllllllIllIIlIIIIIIIIlIIlI);
        }
        return lllllllllllllIllIIlIIIIIIIIllIll;
    }
    
    public MerchantRecipeList(final NBTTagCompound lllllllllllllIllIIlIIIIIIlIlIIIl) {
        this.readRecipiesFromTags(lllllllllllllIllIIlIIIIIIlIlIIIl);
    }
    
    public void writeToBuf(final PacketBuffer lllllllllllllIllIIlIIIIIIIllIIII) {
        lllllllllllllIllIIlIIIIIIIllIIII.writeByte((byte)(this.size() & 0xFF));
        for (int lllllllllllllIllIIlIIIIIIIlIllll = 0; lllllllllllllIllIIlIIIIIIIlIllll < this.size(); ++lllllllllllllIllIIlIIIIIIIlIllll) {
            final MerchantRecipe lllllllllllllIllIIlIIIIIIIlIlllI = this.get(lllllllllllllIllIIlIIIIIIIlIllll);
            lllllllllllllIllIIlIIIIIIIllIIII.writeItemStackToBuffer(lllllllllllllIllIIlIIIIIIIlIlllI.getItemToBuy());
            lllllllllllllIllIIlIIIIIIIllIIII.writeItemStackToBuffer(lllllllllllllIllIIlIIIIIIIlIlllI.getItemToSell());
            final ItemStack lllllllllllllIllIIlIIIIIIIlIllIl = lllllllllllllIllIIlIIIIIIIlIlllI.getSecondItemToBuy();
            lllllllllllllIllIIlIIIIIIIllIIII.writeBoolean(!lllllllllllllIllIIlIIIIIIIlIllIl.func_190926_b());
            if (!lllllllllllllIllIIlIIIIIIIlIllIl.func_190926_b()) {
                lllllllllllllIllIIlIIIIIIIllIIII.writeItemStackToBuffer(lllllllllllllIllIIlIIIIIIIlIllIl);
            }
            lllllllllllllIllIIlIIIIIIIllIIII.writeBoolean(lllllllllllllIllIIlIIIIIIIlIlllI.isRecipeDisabled());
            lllllllllllllIllIIlIIIIIIIllIIII.writeInt(lllllllllllllIllIIlIIIIIIIlIlllI.getToolUses());
            lllllllllllllIllIIlIIIIIIIllIIII.writeInt(lllllllllllllIllIIlIIIIIIIlIlllI.getMaxTradeUses());
        }
    }
    
    @Nullable
    public MerchantRecipe canRecipeBeUsed(final ItemStack lllllllllllllIllIIlIIIIIIlIIlIIl, final ItemStack lllllllllllllIllIIlIIIIIIlIIIIIl, final int lllllllllllllIllIIlIIIIIIlIIIIII) {
        if (lllllllllllllIllIIlIIIIIIlIIIIII > 0 && lllllllllllllIllIIlIIIIIIlIIIIII < this.size()) {
            final MerchantRecipe lllllllllllllIllIIlIIIIIIlIIIllI = this.get(lllllllllllllIllIIlIIIIIIlIIIIII);
            return (!this.areItemStacksExactlyEqual(lllllllllllllIllIIlIIIIIIlIIlIIl, lllllllllllllIllIIlIIIIIIlIIIllI.getItemToBuy()) || ((!lllllllllllllIllIIlIIIIIIlIIIIIl.func_190926_b() || lllllllllllllIllIIlIIIIIIlIIIllI.hasSecondItemToBuy()) && (!lllllllllllllIllIIlIIIIIIlIIIllI.hasSecondItemToBuy() || !this.areItemStacksExactlyEqual(lllllllllllllIllIIlIIIIIIlIIIIIl, lllllllllllllIllIIlIIIIIIlIIIllI.getSecondItemToBuy()))) || lllllllllllllIllIIlIIIIIIlIIlIIl.func_190916_E() < lllllllllllllIllIIlIIIIIIlIIIllI.getItemToBuy().func_190916_E() || (lllllllllllllIllIIlIIIIIIlIIIllI.hasSecondItemToBuy() && lllllllllllllIllIIlIIIIIIlIIIIIl.func_190916_E() < lllllllllllllIllIIlIIIIIIlIIIllI.getSecondItemToBuy().func_190916_E())) ? null : lllllllllllllIllIIlIIIIIIlIIIllI;
        }
        for (int lllllllllllllIllIIlIIIIIIlIIIlIl = 0; lllllllllllllIllIIlIIIIIIlIIIlIl < this.size(); ++lllllllllllllIllIIlIIIIIIlIIIlIl) {
            final MerchantRecipe lllllllllllllIllIIlIIIIIIlIIIlII = this.get(lllllllllllllIllIIlIIIIIIlIIIlIl);
            if (this.areItemStacksExactlyEqual(lllllllllllllIllIIlIIIIIIlIIlIIl, lllllllllllllIllIIlIIIIIIlIIIlII.getItemToBuy()) && lllllllllllllIllIIlIIIIIIlIIlIIl.func_190916_E() >= lllllllllllllIllIIlIIIIIIlIIIlII.getItemToBuy().func_190916_E() && ((!lllllllllllllIllIIlIIIIIIlIIIlII.hasSecondItemToBuy() && lllllllllllllIllIIlIIIIIIlIIIIIl.func_190926_b()) || (lllllllllllllIllIIlIIIIIIlIIIlII.hasSecondItemToBuy() && this.areItemStacksExactlyEqual(lllllllllllllIllIIlIIIIIIlIIIIIl, lllllllllllllIllIIlIIIIIIlIIIlII.getSecondItemToBuy()) && lllllllllllllIllIIlIIIIIIlIIIIIl.func_190916_E() >= lllllllllllllIllIIlIIIIIIlIIIlII.getSecondItemToBuy().func_190916_E()))) {
                return lllllllllllllIllIIlIIIIIIlIIIlII;
            }
        }
        return null;
    }
    
    public MerchantRecipeList() {
    }
    
    public NBTTagCompound getRecipiesAsTags() {
        final NBTTagCompound lllllllllllllIllIIIlllllllllIIIl = new NBTTagCompound();
        final NBTTagList lllllllllllllIllIIIlllllllllIIII = new NBTTagList();
        for (int lllllllllllllIllIIIllllllllIllll = 0; lllllllllllllIllIIIllllllllIllll < this.size(); ++lllllllllllllIllIIIllllllllIllll) {
            final MerchantRecipe lllllllllllllIllIIIllllllllIlllI = this.get(lllllllllllllIllIIIllllllllIllll);
            lllllllllllllIllIIIlllllllllIIII.appendTag(lllllllllllllIllIIIllllllllIlllI.writeToTags());
        }
        lllllllllllllIllIIIlllllllllIIIl.setTag("Recipes", lllllllllllllIllIIIlllllllllIIII);
        return lllllllllllllIllIIIlllllllllIIIl;
    }
    
    private boolean areItemStacksExactlyEqual(final ItemStack lllllllllllllIllIIlIIIIIIIlllIlI, final ItemStack lllllllllllllIllIIlIIIIIIIllIlll) {
        return ItemStack.areItemsEqual(lllllllllllllIllIIlIIIIIIIlllIlI, lllllllllllllIllIIlIIIIIIIllIlll) && (!lllllllllllllIllIIlIIIIIIIllIlll.hasTagCompound() || (lllllllllllllIllIIlIIIIIIIlllIlI.hasTagCompound() && NBTUtil.areNBTEquals(lllllllllllllIllIIlIIIIIIIllIlll.getTagCompound(), lllllllllllllIllIIlIIIIIIIlllIlI.getTagCompound(), false)));
    }
    
    public void readRecipiesFromTags(final NBTTagCompound lllllllllllllIllIIIllllllllllIll) {
        final NBTTagList lllllllllllllIllIIIlllllllllllll = lllllllllllllIllIIIllllllllllIll.getTagList("Recipes", 10);
        for (int lllllllllllllIllIIIllllllllllllI = 0; lllllllllllllIllIIIllllllllllllI < lllllllllllllIllIIIlllllllllllll.tagCount(); ++lllllllllllllIllIIIllllllllllllI) {
            final NBTTagCompound lllllllllllllIllIIIlllllllllllIl = lllllllllllllIllIIIlllllllllllll.getCompoundTagAt(lllllllllllllIllIIIllllllllllllI);
            this.add(new MerchantRecipe(lllllllllllllIllIIIlllllllllllIl));
        }
    }
}
