package net.minecraft.item;

import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;

public class ItemBanner extends ItemBlock
{
    @Override
    public void addInformation(final ItemStack llllIlllIIIllI, @Nullable final World llllIlllIIIlIl, final List<String> llllIlllIIIlII, final ITooltipFlag llllIlllIIIIll) {
        appendHoverTextFromTileEntityTag(llllIlllIIIllI, llllIlllIIIlII);
    }
    
    @Override
    public CreativeTabs getCreativeTab() {
        return CreativeTabs.DECORATIONS;
    }
    
    public ItemBanner() {
        super(Blocks.STANDING_BANNER);
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllIIIIIlllI, final World lllllIIIIllIlI, BlockPos lllllIIIIIllII, final EnumHand lllllIIIIIlIll, final EnumFacing lllllIIIIlIlll, final float lllllIIIIlIllI, final float lllllIIIIlIlIl, final float lllllIIIIlIlII) {
        final IBlockState lllllIIIIlIIll = lllllIIIIllIlI.getBlockState(lllllIIIIIllII);
        final boolean lllllIIIIlIIlI = lllllIIIIlIIll.getBlock().isReplaceable(lllllIIIIllIlI, lllllIIIIIllII);
        if (lllllIIIIlIlll == EnumFacing.DOWN || (!lllllIIIIlIIll.getMaterial().isSolid() && !lllllIIIIlIIlI) || (lllllIIIIlIIlI && lllllIIIIlIlll != EnumFacing.UP)) {
            return EnumActionResult.FAIL;
        }
        lllllIIIIIllII = lllllIIIIIllII.offset(lllllIIIIlIlll);
        final ItemStack lllllIIIIlIIIl = lllllIIIIIlllI.getHeldItem(lllllIIIIIlIll);
        if (!lllllIIIIIlllI.canPlayerEdit(lllllIIIIIllII, lllllIIIIlIlll, lllllIIIIlIIIl) || !Blocks.STANDING_BANNER.canPlaceBlockAt(lllllIIIIllIlI, lllllIIIIIllII)) {
            return EnumActionResult.FAIL;
        }
        if (lllllIIIIllIlI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        lllllIIIIIllII = (lllllIIIIlIIlI ? lllllIIIIIllII.down() : lllllIIIIIllII);
        if (lllllIIIIlIlll == EnumFacing.UP) {
            final int lllllIIIIlIIII = MathHelper.floor((lllllIIIIIlllI.rotationYaw + 180.0f) * 16.0f / 360.0f + 0.5) & 0xF;
            lllllIIIIllIlI.setBlockState(lllllIIIIIllII, Blocks.STANDING_BANNER.getDefaultState().withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllIIIIlIIII), 3);
        }
        else {
            lllllIIIIllIlI.setBlockState(lllllIIIIIllII, Blocks.WALL_BANNER.getDefaultState().withProperty((IProperty<Comparable>)BlockWallSign.FACING, lllllIIIIlIlll), 3);
        }
        final TileEntity lllllIIIIIllll = lllllIIIIllIlI.getTileEntity(lllllIIIIIllII);
        if (lllllIIIIIllll instanceof TileEntityBanner) {
            ((TileEntityBanner)lllllIIIIIllll).setItemValues(lllllIIIIlIIIl, false);
        }
        if (lllllIIIIIlllI instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllIIIIIlllI, lllllIIIIIllII, lllllIIIIlIIIl);
        }
        lllllIIIIlIIIl.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    public static EnumDyeColor getBaseColor(final ItemStack llllIllIIIlIIl) {
        return EnumDyeColor.byDyeDamage(llllIllIIIlIIl.getMetadata() & 0xF);
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllIIIIIIIIl) {
        String lllllIIIIIIIII = "item.banner.";
        final EnumDyeColor llllIlllllllll = getBaseColor(lllllIIIIIIIIl);
        lllllIIIIIIIII = String.valueOf(new StringBuilder(String.valueOf(lllllIIIIIIIII)).append(llllIlllllllll.getUnlocalizedName()).append(".name"));
        return I18n.translateToLocal(lllllIIIIIIIII);
    }
    
    @Override
    public void getSubItems(final CreativeTabs llllIllIlIlllI, final NonNullList<ItemStack> llllIllIlIllII) {
        if (this.func_194125_a(llllIllIlIlllI)) {
            final long llllIllIIlllII;
            final char llllIllIIllllI = (char)((EnumDyeColor[])(Object)(llllIllIIlllII = (long)(Object)EnumDyeColor.values())).length;
            for (short llllIllIlIIIIl = 0; llllIllIlIIIIl < llllIllIIllllI; ++llllIllIlIIIIl) {
                final EnumDyeColor llllIllIlIlIlI = llllIllIIlllII[llllIllIlIIIIl];
                llllIllIlIllII.add(func_190910_a(llllIllIlIlIlI, null));
            }
        }
    }
    
    public static ItemStack func_190910_a(final EnumDyeColor llllIllIIlIllI, @Nullable final NBTTagList llllIllIIlIlIl) {
        final ItemStack llllIllIIlIlII = new ItemStack(Items.BANNER, 1, llllIllIIlIllI.getDyeDamage());
        if (llllIllIIlIlIl != null && !llllIllIIlIlIl.hasNoTags()) {
            llllIllIIlIlII.func_190925_c("BlockEntityTag").setTag("Patterns", llllIllIIlIlIl.copy());
        }
        return llllIllIIlIlII;
    }
    
    public static void appendHoverTextFromTileEntityTag(final ItemStack llllIlllIllIll, final List<String> llllIllllIIIlI) {
        final NBTTagCompound llllIllllIIIIl = llllIlllIllIll.getSubCompound("BlockEntityTag");
        if (llllIllllIIIIl != null && llllIllllIIIIl.hasKey("Patterns")) {
            final NBTTagList llllIllllIIIII = llllIllllIIIIl.getTagList("Patterns", 10);
            for (int llllIlllIlllll = 0; llllIlllIlllll < llllIllllIIIII.tagCount() && llllIlllIlllll < 6; ++llllIlllIlllll) {
                final NBTTagCompound llllIlllIllllI = llllIllllIIIII.getCompoundTagAt(llllIlllIlllll);
                final EnumDyeColor llllIlllIlllIl = EnumDyeColor.byDyeDamage(llllIlllIllllI.getInteger("Color"));
                final BannerPattern llllIlllIlllII = BannerPattern.func_190994_a(llllIlllIllllI.getString("Pattern"));
                if (llllIlllIlllII != null) {
                    llllIllllIIIlI.add(I18n.translateToLocal(String.valueOf(new StringBuilder("item.banner.").append(llllIlllIlllII.func_190997_a()).append(".").append(llllIlllIlllIl.getUnlocalizedName()))));
                }
            }
        }
    }
}
