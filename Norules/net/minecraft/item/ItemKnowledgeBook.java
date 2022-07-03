package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.stats.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.item.crafting.*;
import org.apache.logging.log4j.*;

public class ItemKnowledgeBook extends Item
{
    private static final /* synthetic */ Logger field_194126_a;
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIllllllIIIIllIlllll, final EntityPlayer lllllllllllllIllllllIIIIllIlIIll, final EnumHand lllllllllllllIllllllIIIIllIlIIlI) {
        final ItemStack lllllllllllllIllllllIIIIllIlllII = lllllllllllllIllllllIIIIllIlIIll.getHeldItem(lllllllllllllIllllllIIIIllIlIIlI);
        final NBTTagCompound lllllllllllllIllllllIIIIllIllIll = lllllllllllllIllllllIIIIllIlllII.getTagCompound();
        if (!lllllllllllllIllllllIIIIllIlIIll.capabilities.isCreativeMode) {
            lllllllllllllIllllllIIIIllIlIIll.setHeldItem(lllllllllllllIllllllIIIIllIlIIlI, ItemStack.field_190927_a);
        }
        if (lllllllllllllIllllllIIIIllIllIll != null && lllllllllllllIllllllIIIIllIllIll.hasKey("Recipes", 9)) {
            if (!lllllllllllllIllllllIIIIllIlllll.isRemote) {
                final NBTTagList lllllllllllllIllllllIIIIllIllIlI = lllllllllllllIllllllIIIIllIllIll.getTagList("Recipes", 8);
                final List<IRecipe> lllllllllllllIllllllIIIIllIllIIl = (List<IRecipe>)Lists.newArrayList();
                for (int lllllllllllllIllllllIIIIllIllIII = 0; lllllllllllllIllllllIIIIllIllIII < lllllllllllllIllllllIIIIllIllIlI.tagCount(); ++lllllllllllllIllllllIIIIllIllIII) {
                    final String lllllllllllllIllllllIIIIllIlIlll = lllllllllllllIllllllIIIIllIllIlI.getStringTagAt(lllllllllllllIllllllIIIIllIllIII);
                    final IRecipe lllllllllllllIllllllIIIIllIlIllI = CraftingManager.func_193373_a(new ResourceLocation(lllllllllllllIllllllIIIIllIlIlll));
                    if (lllllllllllllIllllllIIIIllIlIllI == null) {
                        ItemKnowledgeBook.field_194126_a.error(String.valueOf(new StringBuilder("Invalid recipe: ").append(lllllllllllllIllllllIIIIllIlIlll)));
                        return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllIllllllIIIIllIlllII);
                    }
                    lllllllllllllIllllllIIIIllIllIIl.add(lllllllllllllIllllllIIIIllIlIllI);
                }
                lllllllllllllIllllllIIIIllIlIIll.func_192021_a(lllllllllllllIllllllIIIIllIllIIl);
                lllllllllllllIllllllIIIIllIlIIll.addStat(StatList.getObjectUseStats(this));
            }
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIllllllIIIIllIlllII);
        }
        ItemKnowledgeBook.field_194126_a.error(String.valueOf(new StringBuilder("Tag not valid: ").append(lllllllllllllIllllllIIIIllIllIll)));
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllIllllllIIIIllIlllII);
    }
    
    public ItemKnowledgeBook() {
        this.setMaxStackSize(1);
    }
    
    static {
        field_194126_a = LogManager.getLogger();
    }
}
