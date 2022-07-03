package net.minecraft.item;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.nbt.*;
import net.minecraft.server.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;

public class ItemBlock extends Item
{
    protected final /* synthetic */ Block block;
    
    public Block getBlock() {
        return this.block;
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllIlIIllIIIlIIIllIlI, final World llllllllllllllIlIIllIIIlIIIIlIlI, BlockPos llllllllllllllIlIIllIIIlIIIIlIIl, final EnumHand llllllllllllllIlIIllIIIlIIIlIlll, final EnumFacing llllllllllllllIlIIllIIIlIIIlIllI, final float llllllllllllllIlIIllIIIlIIIIIllI, final float llllllllllllllIlIIllIIIlIIIlIlII, final float llllllllllllllIlIIllIIIlIIIIIlII) {
        final IBlockState llllllllllllllIlIIllIIIlIIIlIIlI = llllllllllllllIlIIllIIIlIIIIlIlI.getBlockState(llllllllllllllIlIIllIIIlIIIIlIIl);
        final Block llllllllllllllIlIIllIIIlIIIlIIIl = llllllllllllllIlIIllIIIlIIIlIIlI.getBlock();
        if (!llllllllllllllIlIIllIIIlIIIlIIIl.isReplaceable(llllllllllllllIlIIllIIIlIIIIlIlI, llllllllllllllIlIIllIIIlIIIIlIIl)) {
            llllllllllllllIlIIllIIIlIIIIlIIl = llllllllllllllIlIIllIIIlIIIIlIIl.offset(llllllllllllllIlIIllIIIlIIIlIllI);
        }
        final ItemStack llllllllllllllIlIIllIIIlIIIlIIII = llllllllllllllIlIIllIIIlIIIllIlI.getHeldItem(llllllllllllllIlIIllIIIlIIIlIlll);
        if (!llllllllllllllIlIIllIIIlIIIlIIII.func_190926_b() && llllllllllllllIlIIllIIIlIIIllIlI.canPlayerEdit(llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIlIllI, llllllllllllllIlIIllIIIlIIIlIIII) && llllllllllllllIlIIllIIIlIIIIlIlI.func_190527_a(this.block, llllllllllllllIlIIllIIIlIIIIlIIl, false, llllllllllllllIlIIllIIIlIIIlIllI, null)) {
            final int llllllllllllllIlIIllIIIlIIIIllll = this.getMetadata(llllllllllllllIlIIllIIIlIIIlIIII.getMetadata());
            IBlockState llllllllllllllIlIIllIIIlIIIIlllI = this.block.onBlockPlaced(llllllllllllllIlIIllIIIlIIIIlIlI, llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIlIllI, llllllllllllllIlIIllIIIlIIIIIllI, llllllllllllllIlIIllIIIlIIIlIlII, llllllllllllllIlIIllIIIlIIIIIlII, llllllllllllllIlIIllIIIlIIIIllll, llllllllllllllIlIIllIIIlIIIllIlI);
            if (llllllllllllllIlIIllIIIlIIIIlIlI.setBlockState(llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIIlllI, 11)) {
                llllllllllllllIlIIllIIIlIIIIlllI = llllllllllllllIlIIllIIIlIIIIlIlI.getBlockState(llllllllllllllIlIIllIIIlIIIIlIIl);
                if (llllllllllllllIlIIllIIIlIIIIlllI.getBlock() == this.block) {
                    setTileEntityNBT(llllllllllllllIlIIllIIIlIIIIlIlI, llllllllllllllIlIIllIIIlIIIllIlI, llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIlIIII);
                    this.block.onBlockPlacedBy(llllllllllllllIlIIllIIIlIIIIlIlI, llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIIlllI, llllllllllllllIlIIllIIIlIIIllIlI, llllllllllllllIlIIllIIIlIIIlIIII);
                    if (llllllllllllllIlIIllIIIlIIIllIlI instanceof EntityPlayerMP) {
                        CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)llllllllllllllIlIIllIIIlIIIllIlI, llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIlIIII);
                    }
                }
                final SoundType llllllllllllllIlIIllIIIlIIIIllIl = this.block.getSoundType();
                llllllllllllllIlIIllIIIlIIIIlIlI.playSound(llllllllllllllIlIIllIIIlIIIllIlI, llllllllllllllIlIIllIIIlIIIIlIIl, llllllllllllllIlIIllIIIlIIIIllIl.getPlaceSound(), SoundCategory.BLOCKS, (llllllllllllllIlIIllIIIlIIIIllIl.getVolume() + 1.0f) / 2.0f, llllllllllllllIlIIllIIIlIIIIllIl.getPitch() * 0.8f);
                llllllllllllllIlIIllIIIlIIIlIIII.func_190918_g(1);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
    
    public boolean canPlaceBlockOnSide(final World llllllllllllllIlIIllIIIIllIlIlIl, BlockPos llllllllllllllIlIIllIIIIllIlIlII, EnumFacing llllllllllllllIlIIllIIIIllIlIIll, final EntityPlayer llllllllllllllIlIIllIIIIllIllIIl, final ItemStack llllllllllllllIlIIllIIIIllIllIII) {
        final Block llllllllllllllIlIIllIIIIllIlIlll = llllllllllllllIlIIllIIIIllIlIlIl.getBlockState((BlockPos)llllllllllllllIlIIllIIIIllIlIlII).getBlock();
        if (llllllllllllllIlIIllIIIIllIlIlll == Blocks.SNOW_LAYER) {
            llllllllllllllIlIIllIIIIllIlIIll = EnumFacing.UP;
        }
        else if (!llllllllllllllIlIIllIIIIllIlIlll.isReplaceable(llllllllllllllIlIIllIIIIllIlIlIl, (BlockPos)llllllllllllllIlIIllIIIIllIlIlII)) {
            llllllllllllllIlIIllIIIIllIlIlII = ((BlockPos)llllllllllllllIlIIllIIIIllIlIlII).offset((EnumFacing)llllllllllllllIlIIllIIIIllIlIIll);
        }
        return llllllllllllllIlIIllIIIIllIlIlIl.func_190527_a(this.block, (BlockPos)llllllllllllllIlIIllIIIIllIlIlII, false, (EnumFacing)llllllllllllllIlIIllIIIIllIlIIll, null);
    }
    
    @Override
    public String getUnlocalizedName() {
        return this.block.getUnlocalizedName();
    }
    
    @Override
    public void addInformation(final ItemStack llllllllllllllIlIIllIIIIlIlllIII, @Nullable final World llllllllllllllIlIIllIIIIlIllIIlI, final List<String> llllllllllllllIlIIllIIIIlIllIIIl, final ITooltipFlag llllllllllllllIlIIllIIIIlIllIlIl) {
        super.addInformation(llllllllllllllIlIIllIIIIlIlllIII, llllllllllllllIlIIllIIIIlIllIIlI, llllllllllllllIlIIllIIIIlIllIIIl, llllllllllllllIlIIllIIIIlIllIlIl);
        this.block.func_190948_a(llllllllllllllIlIIllIIIIlIlllIII, llllllllllllllIlIIllIIIIlIllIIlI, llllllllllllllIlIIllIIIIlIllIIIl, llllllllllllllIlIIllIIIIlIllIlIl);
    }
    
    @Override
    public CreativeTabs getCreativeTab() {
        return this.block.getCreativeTabToDisplayOn();
    }
    
    public static boolean setTileEntityNBT(final World llllllllllllllIlIIllIIIIllllIlII, @Nullable final EntityPlayer llllllllllllllIlIIllIIIIllllIIll, final BlockPos llllllllllllllIlIIllIIIIllllIIlI, final ItemStack llllllllllllllIlIIllIIIIllllIIIl) {
        final MinecraftServer llllllllllllllIlIIllIIIIllllIIII = llllllllllllllIlIIllIIIIllllIlII.getMinecraftServer();
        if (llllllllllllllIlIIllIIIIllllIIII == null) {
            return false;
        }
        final NBTTagCompound llllllllllllllIlIIllIIIIlllIllll = llllllllllllllIlIIllIIIIllllIIIl.getSubCompound("BlockEntityTag");
        if (llllllllllllllIlIIllIIIIlllIllll != null) {
            final TileEntity llllllllllllllIlIIllIIIIlllIlllI = llllllllllllllIlIIllIIIIllllIlII.getTileEntity(llllllllllllllIlIIllIIIIllllIIlI);
            if (llllllllllllllIlIIllIIIIlllIlllI != null) {
                if (!llllllllllllllIlIIllIIIIllllIlII.isRemote && llllllllllllllIlIIllIIIIlllIlllI.onlyOpsCanSetNbt() && (llllllllllllllIlIIllIIIIllllIIll == null || !llllllllllllllIlIIllIIIIllllIIll.canUseCommandBlock())) {
                    return false;
                }
                final NBTTagCompound llllllllllllllIlIIllIIIIlllIllIl = llllllllllllllIlIIllIIIIlllIlllI.writeToNBT(new NBTTagCompound());
                final NBTTagCompound llllllllllllllIlIIllIIIIlllIllII = llllllllllllllIlIIllIIIIlllIllIl.copy();
                llllllllllllllIlIIllIIIIlllIllIl.merge(llllllllllllllIlIIllIIIIlllIllll);
                llllllllllllllIlIIllIIIIlllIllIl.setInteger("x", llllllllllllllIlIIllIIIIllllIIlI.getX());
                llllllllllllllIlIIllIIIIlllIllIl.setInteger("y", llllllllllllllIlIIllIIIIllllIIlI.getY());
                llllllllllllllIlIIllIIIIlllIllIl.setInteger("z", llllllllllllllIlIIllIIIIllllIIlI.getZ());
                if (!llllllllllllllIlIIllIIIIlllIllIl.equals(llllllllllllllIlIIllIIIIlllIllII)) {
                    llllllllllllllIlIIllIIIIlllIlllI.readFromNBT(llllllllllllllIlIIllIIIIlllIllIl);
                    llllllllllllllIlIIllIIIIlllIlllI.markDirty();
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack llllllllllllllIlIIllIIIIllIIllll) {
        return this.block.getUnlocalizedName();
    }
    
    public ItemBlock(final Block llllllllllllllIlIIllIIIlIIllIIll) {
        this.block = llllllllllllllIlIIllIIIlIIllIIll;
    }
    
    @Override
    public void getSubItems(final CreativeTabs llllllllllllllIlIIllIIIIllIIIIII, final NonNullList<ItemStack> llllllllllllllIlIIllIIIIllIIIIlI) {
        if (this.func_194125_a(llllllllllllllIlIIllIIIIllIIIIII)) {
            this.block.getSubBlocks(llllllllllllllIlIIllIIIIllIIIIII, llllllllllllllIlIIllIIIIllIIIIlI);
        }
    }
}
