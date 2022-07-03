package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.text.translation.*;

public class ItemShield extends Item
{
    @Override
    public EnumAction getItemUseAction(final ItemStack lllllllllllllIIIlllIIllIlIIlllIl) {
        return EnumAction.BLOCK;
    }
    
    @Override
    public int getMaxItemUseDuration(final ItemStack lllllllllllllIIIlllIIllIlIIllIll) {
        return 72000;
    }
    
    public ItemShield() {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.setMaxDamage(336);
        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @Override
            public float apply(final ItemStack llllllllllllllIIlIllIlIlIIIllIIl, @Nullable final World llllllllllllllIIlIllIlIlIIIllIll, @Nullable final EntityLivingBase llllllllllllllIIlIllIlIlIIIllIII) {
                return (llllllllllllllIIlIllIlIlIIIllIII != null && llllllllllllllIIlIllIlIlIIIllIII.isHandActive() && llllllllllllllIIlIllIlIlIIIllIII.getActiveItemStack() == llllllllllllllIIlIllIlIlIIIllIIl) ? 1.0f : 0.0f;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIIlllIIllIlIIlIllI, final EntityPlayer lllllllllllllIIIlllIIllIlIIlIIlI, final EnumHand lllllllllllllIIIlllIIllIlIIlIlII) {
        final ItemStack lllllllllllllIIIlllIIllIlIIlIIll = lllllllllllllIIIlllIIllIlIIlIIlI.getHeldItem(lllllllllllllIIIlllIIllIlIIlIlII);
        lllllllllllllIIIlllIIllIlIIlIIlI.setActiveHand(lllllllllllllIIIlllIIllIlIIlIlII);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIlllIIllIlIIlIIll);
    }
    
    @Override
    public void addInformation(final ItemStack lllllllllllllIIIlllIIllIlIlIIlII, @Nullable final World lllllllllllllIIIlllIIllIlIlIIIll, final List<String> lllllllllllllIIIlllIIllIlIIlllll, final ITooltipFlag lllllllllllllIIIlllIIllIlIlIIIIl) {
        ItemBanner.appendHoverTextFromTileEntityTag(lllllllllllllIIIlllIIllIlIlIIlII, lllllllllllllIIIlllIIllIlIIlllll);
    }
    
    @Override
    public boolean getIsRepairable(final ItemStack lllllllllllllIIIlllIIllIlIIIlIII, final ItemStack lllllllllllllIIIlllIIllIlIIIIlll) {
        return lllllllllllllIIIlllIIllIlIIIIlll.getItem() == Item.getItemFromBlock(Blocks.PLANKS) || super.getIsRepairable(lllllllllllllIIIlllIIllIlIIIlIII, lllllllllllllIIIlllIIllIlIIIIlll);
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllIIIlllIIllIlIlIlIll) {
        if (lllllllllllllIIIlllIIllIlIlIlIll.getSubCompound("BlockEntityTag") != null) {
            final EnumDyeColor lllllllllllllIIIlllIIllIlIlIlIlI = TileEntityBanner.func_190616_d(lllllllllllllIIIlllIIllIlIlIlIll);
            return I18n.translateToLocal(String.valueOf(new StringBuilder("item.shield.").append(lllllllllllllIIIlllIIllIlIlIlIlI.getUnlocalizedName()).append(".name")));
        }
        return I18n.translateToLocal("item.shield.name");
    }
}
