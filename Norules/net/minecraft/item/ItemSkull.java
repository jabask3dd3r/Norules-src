package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import org.apache.commons.lang3.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public class ItemSkull extends Item
{
    private static final /* synthetic */ String[] SKULL_TYPES;
    
    public ItemSkull() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllIlIlIllIllllIIlllII) {
        if (lllllllllllllIlIlIllIllllIIlllII.getMetadata() == 3 && lllllllllllllIlIlIllIllllIIlllII.hasTagCompound()) {
            if (lllllllllllllIlIlIllIllllIIlllII.getTagCompound().hasKey("SkullOwner", 8)) {
                return I18n.translateToLocalFormatted("item.skull.player.name", lllllllllllllIlIlIllIllllIIlllII.getTagCompound().getString("SkullOwner"));
            }
            if (lllllllllllllIlIlIllIllllIIlllII.getTagCompound().hasKey("SkullOwner", 10)) {
                final NBTTagCompound lllllllllllllIlIlIllIllllIIllIll = lllllllllllllIlIlIllIllllIIlllII.getTagCompound().getCompoundTag("SkullOwner");
                if (lllllllllllllIlIlIllIllllIIllIll.hasKey("Name", 8)) {
                    return I18n.translateToLocalFormatted("item.skull.player.name", lllllllllllllIlIlIllIllllIIllIll.getString("Name"));
                }
            }
        }
        return super.getItemStackDisplayName(lllllllllllllIlIlIllIllllIIlllII);
    }
    
    static {
        SKULL_TYPES = new String[] { "skeleton", "wither", "zombie", "char", "creeper", "dragon" };
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIlIlIllIlllllIIIlll, final World lllllllllllllIlIlIllIlllllIIIllI, BlockPos lllllllllllllIlIlIllIlllllIIIlIl, final EnumHand lllllllllllllIlIlIllIlllllIlIlIl, final EnumFacing lllllllllllllIlIlIllIlllllIlIlII, final float lllllllllllllIlIlIllIlllllIlIIll, final float lllllllllllllIlIlIllIlllllIlIIlI, final float lllllllllllllIlIlIllIlllllIlIIIl) {
        if (lllllllllllllIlIlIllIlllllIlIlII == EnumFacing.DOWN) {
            return EnumActionResult.FAIL;
        }
        final IBlockState lllllllllllllIlIlIllIlllllIlIIII = lllllllllllllIlIlIllIlllllIIIllI.getBlockState(lllllllllllllIlIlIllIlllllIIIlIl);
        final Block lllllllllllllIlIlIllIlllllIIllll = lllllllllllllIlIlIllIlllllIlIIII.getBlock();
        final boolean lllllllllllllIlIlIllIlllllIIlllI = lllllllllllllIlIlIllIlllllIIllll.isReplaceable(lllllllllllllIlIlIllIlllllIIIllI, lllllllllllllIlIlIllIlllllIIIlIl);
        if (!lllllllllllllIlIlIllIlllllIIlllI) {
            if (!lllllllllllllIlIlIllIlllllIIIllI.getBlockState(lllllllllllllIlIlIllIlllllIIIlIl).getMaterial().isSolid()) {
                return EnumActionResult.FAIL;
            }
            lllllllllllllIlIlIllIlllllIIIlIl = lllllllllllllIlIlIllIlllllIIIlIl.offset(lllllllllllllIlIlIllIlllllIlIlII);
        }
        final ItemStack lllllllllllllIlIlIllIlllllIIllIl = lllllllllllllIlIlIllIlllllIIIlll.getHeldItem(lllllllllllllIlIlIllIlllllIlIlIl);
        if (!lllllllllllllIlIlIllIlllllIIIlll.canPlayerEdit(lllllllllllllIlIlIllIlllllIIIlIl, lllllllllllllIlIlIllIlllllIlIlII, lllllllllllllIlIlIllIlllllIIllIl) || !Blocks.SKULL.canPlaceBlockAt(lllllllllllllIlIlIllIlllllIIIllI, lllllllllllllIlIlIllIlllllIIIlIl)) {
            return EnumActionResult.FAIL;
        }
        if (lllllllllllllIlIlIllIlllllIIIllI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        lllllllllllllIlIlIllIlllllIIIllI.setBlockState(lllllllllllllIlIlIllIlllllIIIlIl, Blocks.SKULL.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, lllllllllllllIlIlIllIlllllIlIlII), 11);
        int lllllllllllllIlIlIllIlllllIIllII = 0;
        if (lllllllllllllIlIlIllIlllllIlIlII == EnumFacing.UP) {
            lllllllllllllIlIlIllIlllllIIllII = (MathHelper.floor(lllllllllllllIlIlIllIlllllIIIlll.rotationYaw * 16.0f / 360.0f + 0.5) & 0xF);
        }
        final TileEntity lllllllllllllIlIlIllIlllllIIlIll = lllllllllllllIlIlIllIlllllIIIllI.getTileEntity(lllllllllllllIlIlIllIlllllIIIlIl);
        if (lllllllllllllIlIlIllIlllllIIlIll instanceof TileEntitySkull) {
            final TileEntitySkull lllllllllllllIlIlIllIlllllIIlIlI = (TileEntitySkull)lllllllllllllIlIlIllIlllllIIlIll;
            if (lllllllllllllIlIlIllIlllllIIllIl.getMetadata() == 3) {
                GameProfile lllllllllllllIlIlIllIlllllIIlIIl = null;
                if (lllllllllllllIlIlIllIlllllIIllIl.hasTagCompound()) {
                    final NBTTagCompound lllllllllllllIlIlIllIlllllIIlIII = lllllllllllllIlIlIllIlllllIIllIl.getTagCompound();
                    if (lllllllllllllIlIlIllIlllllIIlIII.hasKey("SkullOwner", 10)) {
                        lllllllllllllIlIlIllIlllllIIlIIl = NBTUtil.readGameProfileFromNBT(lllllllllllllIlIlIllIlllllIIlIII.getCompoundTag("SkullOwner"));
                    }
                    else if (lllllllllllllIlIlIllIlllllIIlIII.hasKey("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)lllllllllllllIlIlIllIlllllIIlIII.getString("SkullOwner"))) {
                        lllllllllllllIlIlIllIlllllIIlIIl = new GameProfile((UUID)null, lllllllllllllIlIlIllIlllllIIlIII.getString("SkullOwner"));
                    }
                }
                lllllllllllllIlIlIllIlllllIIlIlI.setPlayerProfile(lllllllllllllIlIlIllIlllllIIlIIl);
            }
            else {
                lllllllllllllIlIlIllIlllllIIlIlI.setType(lllllllllllllIlIlIllIlllllIIllIl.getMetadata());
            }
            lllllllllllllIlIlIllIlllllIIlIlI.setSkullRotation(lllllllllllllIlIlIllIlllllIIllII);
            Blocks.SKULL.checkWitherSpawn(lllllllllllllIlIlIllIlllllIIIllI, lllllllllllllIlIlIllIlllllIIIlIl, lllllllllllllIlIlIllIlllllIIlIlI);
        }
        if (lllllllllllllIlIlIllIlllllIIIlll instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllIlIlIllIlllllIIIlll, lllllllllllllIlIlIllIlllllIIIlIl, lllllllllllllIlIlIllIlllllIIllIl);
        }
        lllllllllllllIlIlIllIlllllIIllIl.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public void getSubItems(final CreativeTabs lllllllllllllIlIlIllIllllIllIlII, final NonNullList<ItemStack> lllllllllllllIlIlIllIllllIlIllll) {
        if (this.func_194125_a(lllllllllllllIlIlIllIllllIllIlII)) {
            for (int lllllllllllllIlIlIllIllllIllIIlI = 0; lllllllllllllIlIlIllIllllIllIIlI < ItemSkull.SKULL_TYPES.length; ++lllllllllllllIlIlIllIllllIllIIlI) {
                lllllllllllllIlIlIllIllllIlIllll.add(new ItemStack(this, 1, lllllllllllllIlIlIllIllllIllIIlI));
            }
        }
    }
    
    @Override
    public int getMetadata(final int lllllllllllllIlIlIllIllllIlIlIlI) {
        return lllllllllllllIlIlIllIllllIlIlIlI;
    }
    
    @Override
    public boolean updateItemStackNBT(final NBTTagCompound lllllllllllllIlIlIllIllllIIlIIll) {
        super.updateItemStackNBT(lllllllllllllIlIlIllIllllIIlIIll);
        if (lllllllllllllIlIlIllIllllIIlIIll.hasKey("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)lllllllllllllIlIlIllIllllIIlIIll.getString("SkullOwner"))) {
            GameProfile lllllllllllllIlIlIllIllllIIlIIlI = new GameProfile((UUID)null, lllllllllllllIlIlIllIllllIIlIIll.getString("SkullOwner"));
            lllllllllllllIlIlIllIllllIIlIIlI = TileEntitySkull.updateGameprofile(lllllllllllllIlIlIllIllllIIlIIlI);
            lllllllllllllIlIlIllIllllIIlIIll.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), lllllllllllllIlIlIllIllllIIlIIlI));
            return true;
        }
        return false;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack lllllllllllllIlIlIllIllllIlIIlIl) {
        int lllllllllllllIlIlIllIllllIlIIlII = lllllllllllllIlIlIllIllllIlIIlIl.getMetadata();
        if (lllllllllllllIlIlIllIllllIlIIlII < 0 || lllllllllllllIlIlIllIllllIlIIlII >= ItemSkull.SKULL_TYPES.length) {
            lllllllllllllIlIlIllIllllIlIIlII = 0;
        }
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(ItemSkull.SKULL_TYPES[lllllllllllllIlIlIllIllllIlIIlII]));
    }
}
