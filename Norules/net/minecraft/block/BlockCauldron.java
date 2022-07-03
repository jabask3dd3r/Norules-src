package net.minecraft.block;

import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.math.*;

public class BlockCauldron extends Block
{
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_SOUTH;
    public static final /* synthetic */ PropertyInteger LEVEL;
    protected static final /* synthetic */ AxisAlignedBB AABB_LEGS;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_NORTH;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_WEST;
    protected static final /* synthetic */ AxisAlignedBB AABB_WALL_EAST;
    
    @Override
    public void addCollisionBoxToList(final IBlockState llllllllllllIlllllIllIlIlIIlllII, final World llllllllllllIlllllIllIlIlIIllIll, final BlockPos llllllllllllIlllllIllIlIlIIllIlI, final AxisAlignedBB llllllllllllIlllllIllIlIlIIlIlII, final List<AxisAlignedBB> llllllllllllIlllllIllIlIlIIlIIll, @Nullable final Entity llllllllllllIlllllIllIlIlIIlIlll, final boolean llllllllllllIlllllIllIlIlIIlIllI) {
        Block.addCollisionBoxToList(llllllllllllIlllllIllIlIlIIllIlI, llllllllllllIlllllIllIlIlIIlIlII, llllllllllllIlllllIllIlIlIIlIIll, BlockCauldron.AABB_LEGS);
        Block.addCollisionBoxToList(llllllllllllIlllllIllIlIlIIllIlI, llllllllllllIlllllIllIlIlIIlIlII, llllllllllllIlllllIllIlIlIIlIIll, BlockCauldron.AABB_WALL_WEST);
        Block.addCollisionBoxToList(llllllllllllIlllllIllIlIlIIllIlI, llllllllllllIlllllIllIlIlIIlIlII, llllllllllllIlllllIllIlIlIIlIIll, BlockCauldron.AABB_WALL_NORTH);
        Block.addCollisionBoxToList(llllllllllllIlllllIllIlIlIIllIlI, llllllllllllIlllllIllIlIlIIlIlII, llllllllllllIlllllIllIlIlIIlIIll, BlockCauldron.AABB_WALL_EAST);
        Block.addCollisionBoxToList(llllllllllllIlllllIllIlIlIIllIlI, llllllllllllIlllllIllIlIlIIlIlII, llllllllllllIlllllIllIlIlIIlIIll, BlockCauldron.AABB_WALL_SOUTH);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIlllllIllIlIIIIlIIlI, final IBlockState llllllllllllIlllllIllIlIIIIlIIIl, final BlockPos llllllllllllIlllllIllIlIIIIlIIII, final EnumFacing llllllllllllIlllllIllIlIIIIIllll) {
        if (llllllllllllIlllllIllIlIIIIIllll == EnumFacing.UP) {
            return BlockFaceShape.BOWL;
        }
        return (llllllllllllIlllllIllIlIIIIIllll == EnumFacing.DOWN) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllIlllllIllIlIlIIIIIlI, final BlockPos llllllllllllIlllllIllIlIlIIIIIIl, final IBlockState llllllllllllIlllllIllIlIlIIIIIII, final Entity llllllllllllIlllllIllIlIIllllIII) {
        final int llllllllllllIlllllIllIlIIllllllI = llllllllllllIlllllIllIlIlIIIIIII.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
        final float llllllllllllIlllllIllIlIIlllllIl = llllllllllllIlllllIllIlIlIIIIIIl.getY() + (6.0f + 3 * llllllllllllIlllllIllIlIIllllllI) / 16.0f;
        if (!llllllllllllIlllllIllIlIlIIIIIlI.isRemote && llllllllllllIlllllIllIlIIllllIII.isBurning() && llllllllllllIlllllIllIlIIllllllI > 0 && llllllllllllIlllllIllIlIIllllIII.getEntityBoundingBox().minY <= llllllllllllIlllllIllIlIIlllllIl) {
            llllllllllllIlllllIllIlIIllllIII.extinguish();
            this.setWaterLevel(llllllllllllIlllllIllIlIlIIIIIlI, llllllllllllIlllllIllIlIlIIIIIIl, llllllllllllIlllllIllIlIlIIIIIII, llllllllllllIlllllIllIlIIllllllI - 1);
        }
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState llllllllllllIlllllIllIlIIIlIIlIl, final World llllllllllllIlllllIllIlIIIlIIlll, final BlockPos llllllllllllIlllllIllIlIIIlIIllI) {
        return llllllllllllIlllllIllIlIIIlIIlIl.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIlllllIllIlIlIIIlIll) {
        return false;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState llllllllllllIlllllIllIlIIIlIlIll) {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlllllIllIlIIIIllIll) {
        return llllllllllllIlllllIllIlIIIIllIll.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIlllllIllIlIIlIllIIl, final BlockPos llllllllllllIlllllIllIlIIllIlIIl, final IBlockState llllllllllllIlllllIllIlIIlIlIlll, final EntityPlayer llllllllllllIlllllIllIlIIlIlIllI, final EnumHand llllllllllllIlllllIllIlIIllIIllI, final EnumFacing llllllllllllIlllllIllIlIIllIIlIl, final float llllllllllllIlllllIllIlIIllIIlII, final float llllllllllllIlllllIllIlIIllIIIll, final float llllllllllllIlllllIllIlIIllIIIlI) {
        final ItemStack llllllllllllIlllllIllIlIIllIIIIl = llllllllllllIlllllIllIlIIlIlIllI.getHeldItem(llllllllllllIlllllIllIlIIllIIllI);
        if (llllllllllllIlllllIllIlIIllIIIIl.func_190926_b()) {
            return true;
        }
        final int llllllllllllIlllllIllIlIIllIIIII = llllllllllllIlllllIllIlIIlIlIlll.getValue((IProperty<Integer>)BlockCauldron.LEVEL);
        final Item llllllllllllIlllllIllIlIIlIlllll = llllllllllllIlllllIllIlIIllIIIIl.getItem();
        if (llllllllllllIlllllIllIlIIlIlllll == Items.WATER_BUCKET) {
            if (llllllllllllIlllllIllIlIIllIIIII < 3 && !llllllllllllIlllllIllIlIIlIllIIl.isRemote) {
                if (!llllllllllllIlllllIllIlIIlIlIllI.capabilities.isCreativeMode) {
                    llllllllllllIlllllIllIlIIlIlIllI.setHeldItem(llllllllllllIlllllIllIlIIllIIllI, new ItemStack(Items.BUCKET));
                }
                llllllllllllIlllllIllIlIIlIlIllI.addStat(StatList.CAULDRON_FILLED);
                this.setWaterLevel(llllllllllllIlllllIllIlIIlIllIIl, llllllllllllIlllllIllIlIIllIlIIl, llllllllllllIlllllIllIlIIlIlIlll, 3);
                llllllllllllIlllllIllIlIIlIllIIl.playSound(null, llllllllllllIlllllIllIlIIllIlIIl, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return true;
        }
        if (llllllllllllIlllllIllIlIIlIlllll == Items.BUCKET) {
            if (llllllllllllIlllllIllIlIIllIIIII == 3 && !llllllllllllIlllllIllIlIIlIllIIl.isRemote) {
                if (!llllllllllllIlllllIllIlIIlIlIllI.capabilities.isCreativeMode) {
                    llllllllllllIlllllIllIlIIllIIIIl.func_190918_g(1);
                    if (llllllllllllIlllllIllIlIIllIIIIl.func_190926_b()) {
                        llllllllllllIlllllIllIlIIlIlIllI.setHeldItem(llllllllllllIlllllIllIlIIllIIllI, new ItemStack(Items.WATER_BUCKET));
                    }
                    else if (!llllllllllllIlllllIllIlIIlIlIllI.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
                        llllllllllllIlllllIllIlIIlIlIllI.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                    }
                }
                llllllllllllIlllllIllIlIIlIlIllI.addStat(StatList.CAULDRON_USED);
                this.setWaterLevel(llllllllllllIlllllIllIlIIlIllIIl, llllllllllllIlllllIllIlIIllIlIIl, llllllllllllIlllllIllIlIIlIlIlll, 0);
                llllllllllllIlllllIllIlIIlIllIIl.playSound(null, llllllllllllIlllllIllIlIIllIlIIl, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            return true;
        }
        if (llllllllllllIlllllIllIlIIlIlllll == Items.GLASS_BOTTLE) {
            if (llllllllllllIlllllIllIlIIllIIIII > 0 && !llllllllllllIlllllIllIlIIlIllIIl.isRemote) {
                if (!llllllllllllIlllllIllIlIIlIlIllI.capabilities.isCreativeMode) {
                    final ItemStack llllllllllllIlllllIllIlIIlIllllI = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
                    llllllllllllIlllllIllIlIIlIlIllI.addStat(StatList.CAULDRON_USED);
                    llllllllllllIlllllIllIlIIllIIIIl.func_190918_g(1);
                    if (llllllllllllIlllllIllIlIIllIIIIl.func_190926_b()) {
                        llllllllllllIlllllIllIlIIlIlIllI.setHeldItem(llllllllllllIlllllIllIlIIllIIllI, llllllllllllIlllllIllIlIIlIllllI);
                    }
                    else if (!llllllllllllIlllllIllIlIIlIlIllI.inventory.addItemStackToInventory(llllllllllllIlllllIllIlIIlIllllI)) {
                        llllllllllllIlllllIllIlIIlIlIllI.dropItem(llllllllllllIlllllIllIlIIlIllllI, false);
                    }
                    else if (llllllllllllIlllllIllIlIIlIlIllI instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)llllllllllllIlllllIllIlIIlIlIllI).sendContainerToPlayer(llllllllllllIlllllIllIlIIlIlIllI.inventoryContainer);
                    }
                }
                llllllllllllIlllllIllIlIIlIllIIl.playSound(null, llllllllllllIlllllIllIlIIllIlIIl, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
                this.setWaterLevel(llllllllllllIlllllIllIlIIlIllIIl, llllllllllllIlllllIllIlIIllIlIIl, llllllllllllIlllllIllIlIIlIlIlll, llllllllllllIlllllIllIlIIllIIIII - 1);
            }
            return true;
        }
        if (llllllllllllIlllllIllIlIIlIlllll == Items.POTIONITEM && PotionUtils.getPotionFromItem(llllllllllllIlllllIllIlIIllIIIIl) == PotionTypes.WATER) {
            if (llllllllllllIlllllIllIlIIllIIIII < 3 && !llllllllllllIlllllIllIlIIlIllIIl.isRemote) {
                if (!llllllllllllIlllllIllIlIIlIlIllI.capabilities.isCreativeMode) {
                    final ItemStack llllllllllllIlllllIllIlIIlIlllIl = new ItemStack(Items.GLASS_BOTTLE);
                    llllllllllllIlllllIllIlIIlIlIllI.addStat(StatList.CAULDRON_USED);
                    llllllllllllIlllllIllIlIIlIlIllI.setHeldItem(llllllllllllIlllllIllIlIIllIIllI, llllllllllllIlllllIllIlIIlIlllIl);
                    if (llllllllllllIlllllIllIlIIlIlIllI instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)llllllllllllIlllllIllIlIIlIlIllI).sendContainerToPlayer(llllllllllllIlllllIllIlIIlIlIllI.inventoryContainer);
                    }
                }
                llllllllllllIlllllIllIlIIlIllIIl.playSound(null, llllllllllllIlllllIllIlIIllIlIIl, SoundEvents.field_191241_J, SoundCategory.BLOCKS, 1.0f, 1.0f);
                this.setWaterLevel(llllllllllllIlllllIllIlIIlIllIIl, llllllllllllIlllllIllIlIIllIlIIl, llllllllllllIlllllIllIlIIlIlIlll, llllllllllllIlllllIllIlIIllIIIII + 1);
            }
            return true;
        }
        if (llllllllllllIlllllIllIlIIllIIIII > 0 && llllllllllllIlllllIllIlIIlIlllll instanceof ItemArmor) {
            final ItemArmor llllllllllllIlllllIllIlIIlIlllII = (ItemArmor)llllllllllllIlllllIllIlIIlIlllll;
            if (llllllllllllIlllllIllIlIIlIlllII.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && llllllllllllIlllllIllIlIIlIlllII.hasColor(llllllllllllIlllllIllIlIIllIIIIl) && !llllllllllllIlllllIllIlIIlIllIIl.isRemote) {
                llllllllllllIlllllIllIlIIlIlllII.removeColor(llllllllllllIlllllIllIlIIllIIIIl);
                this.setWaterLevel(llllllllllllIlllllIllIlIIlIllIIl, llllllllllllIlllllIllIlIIllIlIIl, llllllllllllIlllllIllIlIIlIlIlll, llllllllllllIlllllIllIlIIllIIIII - 1);
                llllllllllllIlllllIllIlIIlIlIllI.addStat(StatList.ARMOR_CLEANED);
                return true;
            }
        }
        if (llllllllllllIlllllIllIlIIllIIIII > 0 && llllllllllllIlllllIllIlIIlIlllll instanceof ItemBanner) {
            if (TileEntityBanner.getPatterns(llllllllllllIlllllIllIlIIllIIIIl) > 0 && !llllllllllllIlllllIllIlIIlIllIIl.isRemote) {
                final ItemStack llllllllllllIlllllIllIlIIlIllIll = llllllllllllIlllllIllIlIIllIIIIl.copy();
                llllllllllllIlllllIllIlIIlIllIll.func_190920_e(1);
                TileEntityBanner.removeBannerData(llllllllllllIlllllIllIlIIlIllIll);
                llllllllllllIlllllIllIlIIlIlIllI.addStat(StatList.BANNER_CLEANED);
                if (!llllllllllllIlllllIllIlIIlIlIllI.capabilities.isCreativeMode) {
                    llllllllllllIlllllIllIlIIllIIIIl.func_190918_g(1);
                    this.setWaterLevel(llllllllllllIlllllIllIlIIlIllIIl, llllllllllllIlllllIllIlIIllIlIIl, llllllllllllIlllllIllIlIIlIlIlll, llllllllllllIlllllIllIlIIllIIIII - 1);
                }
                if (llllllllllllIlllllIllIlIIllIIIIl.func_190926_b()) {
                    llllllllllllIlllllIllIlIIlIlIllI.setHeldItem(llllllllllllIlllllIllIlIIllIIllI, llllllllllllIlllllIllIlIIlIllIll);
                }
                else if (!llllllllllllIlllllIllIlIIlIlIllI.inventory.addItemStackToInventory(llllllllllllIlllllIllIlIIlIllIll)) {
                    llllllllllllIlllllIllIlIIlIlIllI.dropItem(llllllllllllIlllllIllIlIIlIllIll, false);
                }
                else if (llllllllllllIlllllIllIlIIlIlIllI instanceof EntityPlayerMP) {
                    ((EntityPlayerMP)llllllllllllIlllllIllIlIIlIlIllI).sendContainerToPlayer(llllllllllllIlllllIllIlIIlIlIllI.inventoryContainer);
                }
            }
            return true;
        }
        return false;
    }
    
    public BlockCauldron() {
        super(Material.IRON, MapColor.STONE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCauldron.LEVEL, 0));
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllIlllllIllIlIIIIlIllI, final BlockPos llllllllllllIlllllIllIlIIIIlIlIl) {
        return true;
    }
    
    static {
        LEVEL = PropertyInteger.create("level", 0, 3);
        AABB_LEGS = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0);
        AABB_WALL_NORTH = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.125);
        AABB_WALL_SOUTH = new AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 1.0, 1.0);
        AABB_WALL_EAST = new AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 1.0, 1.0);
        AABB_WALL_WEST = new AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 1.0, 1.0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCauldron.LEVEL });
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIlllllIllIlIIIllIIll, final Random llllllllllllIlllllIllIlIIIllIIlI, final int llllllllllllIlllllIllIlIIIllIIIl) {
        return Items.CAULDRON;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIlllllIllIlIlIIlIIIl, final IBlockAccess llllllllllllIlllllIllIlIlIIlIIII, final BlockPos llllllllllllIlllllIllIlIlIIIllll) {
        return BlockCauldron.FULL_BLOCK_AABB;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlllllIllIlIIIIlllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCauldron.LEVEL, llllllllllllIlllllIllIlIIIIlllll);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIlllllIllIlIlIIIllIl) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIlllllIllIlIIIlIllll, final BlockPos llllllllllllIlllllIllIlIIIlIlllI, final IBlockState llllllllllllIlllllIllIlIIIlIllIl) {
        return new ItemStack(Items.CAULDRON);
    }
    
    public void setWaterLevel(final World llllllllllllIlllllIllIlIIlIIlIlI, final BlockPos llllllllllllIlllllIllIlIIlIIlIIl, final IBlockState llllllllllllIlllllIllIlIIlIIIIll, final int llllllllllllIlllllIllIlIIlIIIIlI) {
        llllllllllllIlllllIllIlIIlIIlIlI.setBlockState(llllllllllllIlllllIllIlIIlIIlIIl, llllllllllllIlllllIllIlIIlIIIIll.withProperty((IProperty<Comparable>)BlockCauldron.LEVEL, MathHelper.clamp(llllllllllllIlllllIllIlIIlIIIIlI, 0, 3)), 2);
        llllllllllllIlllllIllIlIIlIIlIlI.updateComparatorOutputLevel(llllllllllllIlllllIllIlIIlIIlIIl, this);
    }
    
    @Override
    public void fillWithRain(final World llllllllllllIlllllIllIlIIIllllII, final BlockPos llllllllllllIlllllIllIlIIIlllIll) {
        if (llllllllllllIlllllIllIlIIIllllII.rand.nextInt(20) == 1) {
            final float llllllllllllIlllllIllIlIIIlllIlI = llllllllllllIlllllIllIlIIIllllII.getBiome(llllllllllllIlllllIllIlIIIlllIll).getFloatTemperature(llllllllllllIlllllIllIlIIIlllIll);
            if (llllllllllllIlllllIllIlIIIllllII.getBiomeProvider().getTemperatureAtHeight(llllllllllllIlllllIllIlIIIlllIlI, llllllllllllIlllllIllIlIIIlllIll.getY()) >= 0.15f) {
                final IBlockState llllllllllllIlllllIllIlIIIlllIIl = llllllllllllIlllllIllIlIIIllllII.getBlockState(llllllllllllIlllllIllIlIIIlllIll);
                if (llllllllllllIlllllIllIlIIIlllIIl.getValue((IProperty<Integer>)BlockCauldron.LEVEL) < 3) {
                    llllllllllllIlllllIllIlIIIllllII.setBlockState(llllllllllllIlllllIllIlIIIlllIll, llllllllllllIlllllIllIlIIIlllIIl.cycleProperty((IProperty<Comparable>)BlockCauldron.LEVEL), 2);
                }
            }
        }
    }
}
