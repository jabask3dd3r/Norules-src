package net.minecraft.item.crafting;

import net.minecraft.inventory.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import java.util.*;

public class RecipeFireworks implements IRecipe
{
    private /* synthetic */ ItemStack resultItem;
    
    @Override
    public ItemStack getCraftingResult(final InventoryCrafting lllllllllllllIIlIIIIIlIIIIIIlIIl) {
        return this.resultItem.copy();
    }
    
    @Override
    public NonNullList<ItemStack> getRemainingItems(final InventoryCrafting lllllllllllllIIlIIIIIIllllllllll) {
        final NonNullList<ItemStack> lllllllllllllIIlIIIIIIlllllllllI = NonNullList.func_191197_a(lllllllllllllIIlIIIIIIllllllllll.getSizeInventory(), ItemStack.field_190927_a);
        for (int lllllllllllllIIlIIIIIIllllllllIl = 0; lllllllllllllIIlIIIIIIllllllllIl < lllllllllllllIIlIIIIIIlllllllllI.size(); ++lllllllllllllIIlIIIIIIllllllllIl) {
            final ItemStack lllllllllllllIIlIIIIIIllllllllII = lllllllllllllIIlIIIIIIllllllllll.getStackInSlot(lllllllllllllIIlIIIIIIllllllllIl);
            if (lllllllllllllIIlIIIIIIllllllllII.getItem().hasContainerItem()) {
                lllllllllllllIIlIIIIIIlllllllllI.set(lllllllllllllIIlIIIIIIllllllllIl, new ItemStack(lllllllllllllIIlIIIIIIllllllllII.getItem().getContainerItem()));
            }
        }
        return lllllllllllllIIlIIIIIIlllllllllI;
    }
    
    @Override
    public boolean matches(final InventoryCrafting lllllllllllllIIlIIIIIlIIIIllIllI, final World lllllllllllllIIlIIIIIlIIIIllIlIl) {
        this.resultItem = ItemStack.field_190927_a;
        int lllllllllllllIIlIIIIIlIIIIllIlII = 0;
        int lllllllllllllIIlIIIIIlIIIIllIIll = 0;
        int lllllllllllllIIlIIIIIlIIIIllIIlI = 0;
        int lllllllllllllIIlIIIIIlIIIIllIIIl = 0;
        int lllllllllllllIIlIIIIIlIIIIllIIII = 0;
        int lllllllllllllIIlIIIIIlIIIIlIllll = 0;
        for (int lllllllllllllIIlIIIIIlIIIIlIlllI = 0; lllllllllllllIIlIIIIIlIIIIlIlllI < lllllllllllllIIlIIIIIlIIIIllIllI.getSizeInventory(); ++lllllllllllllIIlIIIIIlIIIIlIlllI) {
            final ItemStack lllllllllllllIIlIIIIIlIIIIlIllIl = lllllllllllllIIlIIIIIlIIIIllIllI.getStackInSlot(lllllllllllllIIlIIIIIlIIIIlIlllI);
            if (!lllllllllllllIIlIIIIIlIIIIlIllIl.func_190926_b()) {
                if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.GUNPOWDER) {
                    ++lllllllllllllIIlIIIIIlIIIIllIIll;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.FIREWORK_CHARGE) {
                    ++lllllllllllllIIlIIIIIlIIIIllIIIl;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.DYE) {
                    ++lllllllllllllIIlIIIIIlIIIIllIIlI;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.PAPER) {
                    ++lllllllllllllIIlIIIIIlIIIIllIlII;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.GLOWSTONE_DUST) {
                    ++lllllllllllllIIlIIIIIlIIIIllIIII;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.DIAMOND) {
                    ++lllllllllllllIIlIIIIIlIIIIllIIII;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.FIRE_CHARGE) {
                    ++lllllllllllllIIlIIIIIlIIIIlIllll;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.FEATHER) {
                    ++lllllllllllllIIlIIIIIlIIIIlIllll;
                }
                else if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() == Items.GOLD_NUGGET) {
                    ++lllllllllllllIIlIIIIIlIIIIlIllll;
                }
                else {
                    if (lllllllllllllIIlIIIIIlIIIIlIllIl.getItem() != Items.SKULL) {
                        return false;
                    }
                    ++lllllllllllllIIlIIIIIlIIIIlIllll;
                }
            }
        }
        lllllllllllllIIlIIIIIlIIIIllIIII = lllllllllllllIIlIIIIIlIIIIllIIII + lllllllllllllIIlIIIIIlIIIIllIIlI + lllllllllllllIIlIIIIIlIIIIlIllll;
        if (lllllllllllllIIlIIIIIlIIIIllIIll > 3 || lllllllllllllIIlIIIIIlIIIIllIlII > 1) {
            return false;
        }
        if (lllllllllllllIIlIIIIIlIIIIllIIll >= 1 && lllllllllllllIIlIIIIIlIIIIllIlII == 1 && lllllllllllllIIlIIIIIlIIIIllIIII == 0) {
            this.resultItem = new ItemStack(Items.FIREWORKS, 3);
            final NBTTagCompound lllllllllllllIIlIIIIIlIIIIlIllII = new NBTTagCompound();
            if (lllllllllllllIIlIIIIIlIIIIllIIIl > 0) {
                final NBTTagList lllllllllllllIIlIIIIIlIIIIlIlIll = new NBTTagList();
                for (int lllllllllllllIIlIIIIIlIIIIlIlIlI = 0; lllllllllllllIIlIIIIIlIIIIlIlIlI < lllllllllllllIIlIIIIIlIIIIllIllI.getSizeInventory(); ++lllllllllllllIIlIIIIIlIIIIlIlIlI) {
                    final ItemStack lllllllllllllIIlIIIIIlIIIIlIlIIl = lllllllllllllIIlIIIIIlIIIIllIllI.getStackInSlot(lllllllllllllIIlIIIIIlIIIIlIlIlI);
                    if (lllllllllllllIIlIIIIIlIIIIlIlIIl.getItem() == Items.FIREWORK_CHARGE && lllllllllllllIIlIIIIIlIIIIlIlIIl.hasTagCompound() && lllllllllllllIIlIIIIIlIIIIlIlIIl.getTagCompound().hasKey("Explosion", 10)) {
                        lllllllllllllIIlIIIIIlIIIIlIlIll.appendTag(lllllllllllllIIlIIIIIlIIIIlIlIIl.getTagCompound().getCompoundTag("Explosion"));
                    }
                }
                lllllllllllllIIlIIIIIlIIIIlIllII.setTag("Explosions", lllllllllllllIIlIIIIIlIIIIlIlIll);
            }
            lllllllllllllIIlIIIIIlIIIIlIllII.setByte("Flight", (byte)lllllllllllllIIlIIIIIlIIIIllIIll);
            final NBTTagCompound lllllllllllllIIlIIIIIlIIIIlIlIII = new NBTTagCompound();
            lllllllllllllIIlIIIIIlIIIIlIlIII.setTag("Fireworks", lllllllllllllIIlIIIIIlIIIIlIllII);
            this.resultItem.setTagCompound(lllllllllllllIIlIIIIIlIIIIlIlIII);
            return true;
        }
        if (lllllllllllllIIlIIIIIlIIIIllIIll == 1 && lllllllllllllIIlIIIIIlIIIIllIlII == 0 && lllllllllllllIIlIIIIIlIIIIllIIIl == 0 && lllllllllllllIIlIIIIIlIIIIllIIlI > 0 && lllllllllllllIIlIIIIIlIIIIlIllll <= 1) {
            this.resultItem = new ItemStack(Items.FIREWORK_CHARGE);
            final NBTTagCompound lllllllllllllIIlIIIIIlIIIIlIIlll = new NBTTagCompound();
            final NBTTagCompound lllllllllllllIIlIIIIIlIIIIlIIllI = new NBTTagCompound();
            byte lllllllllllllIIlIIIIIlIIIIlIIlIl = 0;
            final List<Integer> lllllllllllllIIlIIIIIlIIIIlIIlII = (List<Integer>)Lists.newArrayList();
            for (int lllllllllllllIIlIIIIIlIIIIlIIIll = 0; lllllllllllllIIlIIIIIlIIIIlIIIll < lllllllllllllIIlIIIIIlIIIIllIllI.getSizeInventory(); ++lllllllllllllIIlIIIIIlIIIIlIIIll) {
                final ItemStack lllllllllllllIIlIIIIIlIIIIlIIIlI = lllllllllllllIIlIIIIIlIIIIllIllI.getStackInSlot(lllllllllllllIIlIIIIIlIIIIlIIIll);
                if (!lllllllllllllIIlIIIIIlIIIIlIIIlI.func_190926_b()) {
                    if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.DYE) {
                        lllllllllllllIIlIIIIIlIIIIlIIlII.add(ItemDye.DYE_COLORS[lllllllllllllIIlIIIIIlIIIIlIIIlI.getMetadata() & 0xF]);
                    }
                    else if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.GLOWSTONE_DUST) {
                        lllllllllllllIIlIIIIIlIIIIlIIllI.setBoolean("Flicker", true);
                    }
                    else if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.DIAMOND) {
                        lllllllllllllIIlIIIIIlIIIIlIIllI.setBoolean("Trail", true);
                    }
                    else if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.FIRE_CHARGE) {
                        lllllllllllllIIlIIIIIlIIIIlIIlIl = 1;
                    }
                    else if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.FEATHER) {
                        lllllllllllllIIlIIIIIlIIIIlIIlIl = 4;
                    }
                    else if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.GOLD_NUGGET) {
                        lllllllllllllIIlIIIIIlIIIIlIIlIl = 2;
                    }
                    else if (lllllllllllllIIlIIIIIlIIIIlIIIlI.getItem() == Items.SKULL) {
                        lllllllllllllIIlIIIIIlIIIIlIIlIl = 3;
                    }
                }
            }
            final int[] lllllllllllllIIlIIIIIlIIIIlIIIIl = new int[lllllllllllllIIlIIIIIlIIIIlIIlII.size()];
            for (int lllllllllllllIIlIIIIIlIIIIlIIIII = 0; lllllllllllllIIlIIIIIlIIIIlIIIII < lllllllllllllIIlIIIIIlIIIIlIIIIl.length; ++lllllllllllllIIlIIIIIlIIIIlIIIII) {
                lllllllllllllIIlIIIIIlIIIIlIIIIl[lllllllllllllIIlIIIIIlIIIIlIIIII] = lllllllllllllIIlIIIIIlIIIIlIIlII.get(lllllllllllllIIlIIIIIlIIIIlIIIII);
            }
            lllllllllllllIIlIIIIIlIIIIlIIllI.setIntArray("Colors", lllllllllllllIIlIIIIIlIIIIlIIIIl);
            lllllllllllllIIlIIIIIlIIIIlIIllI.setByte("Type", lllllllllllllIIlIIIIIlIIIIlIIlIl);
            lllllllllllllIIlIIIIIlIIIIlIIlll.setTag("Explosion", lllllllllllllIIlIIIIIlIIIIlIIllI);
            this.resultItem.setTagCompound(lllllllllllllIIlIIIIIlIIIIlIIlll);
            return true;
        }
        if (lllllllllllllIIlIIIIIlIIIIllIIll != 0 || lllllllllllllIIlIIIIIlIIIIllIlII != 0 || lllllllllllllIIlIIIIIlIIIIllIIIl != 1 || lllllllllllllIIlIIIIIlIIIIllIIlI <= 0 || lllllllllllllIIlIIIIIlIIIIllIIlI != lllllllllllllIIlIIIIIlIIIIllIIII) {
            return false;
        }
        final List<Integer> lllllllllllllIIlIIIIIlIIIIIlllll = (List<Integer>)Lists.newArrayList();
        for (int lllllllllllllIIlIIIIIlIIIIIllllI = 0; lllllllllllllIIlIIIIIlIIIIIllllI < lllllllllllllIIlIIIIIlIIIIllIllI.getSizeInventory(); ++lllllllllllllIIlIIIIIlIIIIIllllI) {
            final ItemStack lllllllllllllIIlIIIIIlIIIIIlllIl = lllllllllllllIIlIIIIIlIIIIllIllI.getStackInSlot(lllllllllllllIIlIIIIIlIIIIIllllI);
            if (!lllllllllllllIIlIIIIIlIIIIIlllIl.func_190926_b()) {
                if (lllllllllllllIIlIIIIIlIIIIIlllIl.getItem() == Items.DYE) {
                    lllllllllllllIIlIIIIIlIIIIIlllll.add(ItemDye.DYE_COLORS[lllllllllllllIIlIIIIIlIIIIIlllIl.getMetadata() & 0xF]);
                }
                else if (lllllllllllllIIlIIIIIlIIIIIlllIl.getItem() == Items.FIREWORK_CHARGE) {
                    this.resultItem = lllllllllllllIIlIIIIIlIIIIIlllIl.copy();
                    this.resultItem.func_190920_e(1);
                }
            }
        }
        final int[] lllllllllllllIIlIIIIIlIIIIIlllII = new int[lllllllllllllIIlIIIIIlIIIIIlllll.size()];
        for (int lllllllllllllIIlIIIIIlIIIIIllIll = 0; lllllllllllllIIlIIIIIlIIIIIllIll < lllllllllllllIIlIIIIIlIIIIIlllII.length; ++lllllllllllllIIlIIIIIlIIIIIllIll) {
            lllllllllllllIIlIIIIIlIIIIIlllII[lllllllllllllIIlIIIIIlIIIIIllIll] = lllllllllllllIIlIIIIIlIIIIIlllll.get(lllllllllllllIIlIIIIIlIIIIIllIll);
        }
        if (this.resultItem.func_190926_b() || !this.resultItem.hasTagCompound()) {
            return false;
        }
        final NBTTagCompound lllllllllllllIIlIIIIIlIIIIIllIlI = this.resultItem.getTagCompound().getCompoundTag("Explosion");
        if (lllllllllllllIIlIIIIIlIIIIIllIlI == null) {
            return false;
        }
        lllllllllllllIIlIIIIIlIIIIIllIlI.setIntArray("FadeColors", lllllllllllllIIlIIIIIlIIIIIlllII);
        return true;
    }
    
    @Override
    public boolean func_192399_d() {
        return true;
    }
    
    @Override
    public ItemStack getRecipeOutput() {
        return this.resultItem;
    }
    
    public RecipeFireworks() {
        this.resultItem = ItemStack.field_190927_a;
    }
    
    @Override
    public boolean func_194133_a(final int lllllllllllllIIlIIIIIIllllllIIll, final int lllllllllllllIIlIIIIIIllllllIIlI) {
        return lllllllllllllIIlIIIIIIllllllIIll * lllllllllllllIIlIIIIIIllllllIIlI >= 1;
    }
}
