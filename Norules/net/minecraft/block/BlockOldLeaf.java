package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockOldLeaf extends BlockLeaves
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public void harvestBlock(final World llIIllIlIlIIlll, final EntityPlayer llIIllIlIlIIlIl, final BlockPos llIIllIlIlIIlII, final IBlockState llIIllIlIlIIIlI, @Nullable final TileEntity llIIllIlIlIIIII, final ItemStack llIIllIlIIllllI) {
        if (!llIIllIlIlIIlll.isRemote && llIIllIlIIllllI.getItem() == Items.SHEARS) {
            llIIllIlIlIIlIl.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(llIIllIlIlIIlll, llIIllIlIlIIlII, new ItemStack(Item.getItemFromBlock(this), 1, llIIllIlIlIIIlI.getValue(BlockOldLeaf.VARIANT).getMetadata()));
        }
        else {
            super.harvestBlock(llIIllIlIlIIlll, llIIllIlIlIIlIl, llIIllIlIlIIlII, llIIllIlIlIIIlI, llIIllIlIlIIIII, llIIllIlIIllllI);
        }
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llIIllIlllIIIII) {
        return new ItemStack(Item.getItemFromBlock(this), 1, llIIllIlllIIIII.getValue(BlockOldLeaf.VARIANT).getMetadata());
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType llllllllllllllIlllIIllIlIllllIII) {
                return llllllllllllllIlllIIllIlIllllIII.getMetadata() < 4;
            }
        });
    }
    
    @Override
    protected void dropApple(final World llIIllIllllIlII, final BlockPos llIIllIllllIIll, final IBlockState llIIllIllllIIlI, final int llIIllIllllIlIl) {
        if (llIIllIllllIIlI.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.OAK && llIIllIllllIlII.rand.nextInt(llIIllIllllIlIl) == 0) {
            Block.spawnAsEntity(llIIllIllllIlII, llIIllIllllIIll, new ItemStack(Items.APPLE));
        }
    }
    
    @Override
    protected int getSaplingDropChance(final IBlockState llIIllIlllIlIll) {
        return (llIIllIlllIlIll.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.JUNGLE) ? 40 : super.getSaplingDropChance(llIIllIlllIlIll);
    }
    
    public BlockOldLeaf() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, true).withProperty((IProperty<Comparable>)BlockOldLeaf.DECAYABLE, true));
    }
    
    @Override
    public BlockPlanks.EnumType getWoodType(final int llIIllIllIIlIll) {
        return BlockPlanks.EnumType.byMetadata((llIIllIllIIlIll & 0x3) % 4);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIIllIllIllIII) {
        return this.getDefaultState().withProperty(BlockOldLeaf.VARIANT, this.getWoodType(llIIllIllIllIII)).withProperty((IProperty<Comparable>)BlockOldLeaf.DECAYABLE, (llIIllIllIllIII & 0x4) == 0x0).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, (llIIllIllIllIII & 0x8) > 0);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIIllIllIlIlII) {
        int llIIllIllIlIIll = 0;
        llIIllIllIlIIll |= llIIllIllIlIlII.getValue(BlockOldLeaf.VARIANT).getMetadata();
        if (!llIIllIllIlIlII.getValue((IProperty<Boolean>)BlockOldLeaf.DECAYABLE)) {
            llIIllIllIlIIll |= 0x4;
        }
        if (llIIllIllIlIlII.getValue((IProperty<Boolean>)BlockOldLeaf.CHECK_DECAY)) {
            llIIllIllIlIIll |= 0x8;
        }
        return llIIllIllIlIIll;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llIIllIlllIIlll, final NonNullList<ItemStack> llIIllIlllIIlII) {
        llIIllIlllIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.OAK.getMetadata()));
        llIIllIlllIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.SPRUCE.getMetadata()));
        llIIllIlllIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.BIRCH.getMetadata()));
        llIIllIlllIIlII.add(new ItemStack(this, 1, BlockPlanks.EnumType.JUNGLE.getMetadata()));
    }
    
    @Override
    public int damageDropped(final IBlockState llIIllIlIlllIll) {
        return llIIllIlIlllIll.getValue(BlockOldLeaf.VARIANT).getMetadata();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockOldLeaf.VARIANT, BlockOldLeaf.CHECK_DECAY, BlockOldLeaf.DECAYABLE });
    }
}
