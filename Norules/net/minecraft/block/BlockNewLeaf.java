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
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import com.google.common.base.*;

public class BlockNewLeaf extends BlockLeaves
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public void harvestBlock(final World lllllllllllllllIIIIlllIIIIlIIIIl, final EntityPlayer lllllllllllllllIIIIlllIIIIlIIIII, final BlockPos lllllllllllllllIIIIlllIIIIIlllll, final IBlockState lllllllllllllllIIIIlllIIIIIlIlll, @Nullable final TileEntity lllllllllllllllIIIIlllIIIIIlllIl, final ItemStack lllllllllllllllIIIIlllIIIIIlllII) {
        if (!lllllllllllllllIIIIlllIIIIlIIIIl.isRemote && lllllllllllllllIIIIlllIIIIIlllII.getItem() == Items.SHEARS) {
            lllllllllllllllIIIIlllIIIIlIIIII.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(lllllllllllllllIIIIlllIIIIlIIIIl, lllllllllllllllIIIIlllIIIIIlllll, new ItemStack(Item.getItemFromBlock(this), 1, lllllllllllllllIIIIlllIIIIIlIlll.getValue(BlockNewLeaf.VARIANT).getMetadata() - 4));
        }
        else {
            super.harvestBlock(lllllllllllllllIIIIlllIIIIlIIIIl, lllllllllllllllIIIIlllIIIIlIIIII, lllllllllllllllIIIIlllIIIIIlllll, lllllllllllllllIIIIlllIIIIIlIlll, lllllllllllllllIIIIlllIIIIIlllIl, lllllllllllllllIIIIlllIIIIIlllII);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIIlllIIIIllIlII) {
        int lllllllllllllllIIIIlllIIIIllIIll = 0;
        lllllllllllllllIIIIlllIIIIllIIll |= lllllllllllllllIIIIlllIIIIllIlII.getValue(BlockNewLeaf.VARIANT).getMetadata() - 4;
        if (!lllllllllllllllIIIIlllIIIIllIlII.getValue((IProperty<Boolean>)BlockNewLeaf.DECAYABLE)) {
            lllllllllllllllIIIIlllIIIIllIIll |= 0x4;
        }
        if (lllllllllllllllIIIIlllIIIIllIlII.getValue((IProperty<Boolean>)BlockNewLeaf.CHECK_DECAY)) {
            lllllllllllllllIIIIlllIIIIllIIll |= 0x8;
        }
        return lllllllllllllllIIIIlllIIIIllIIll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockNewLeaf.VARIANT, BlockNewLeaf.CHECK_DECAY, BlockNewLeaf.DECAYABLE });
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllllIIIIlllIIIIlllllI) {
        return new ItemStack(Item.getItemFromBlock(this), 1, lllllllllllllllIIIIlllIIIIlllllI.getValue(BlockNewLeaf.VARIANT).getMetadata() - 4);
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllllIIIIlllIIIlIlIllI) {
        return lllllllllllllllIIIIlllIIIlIlIllI.getValue(BlockNewLeaf.VARIANT).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIIIIlllIIIlIIIlll, final NonNullList<ItemStack> lllllllllllllllIIIIlllIIIlIIIlII) {
        lllllllllllllllIIIIlllIIIlIIIlII.add(new ItemStack(this, 1, 0));
        lllllllllllllllIIIIlllIIIlIIIlII.add(new ItemStack(this, 1, 1));
    }
    
    @Override
    protected void dropApple(final World lllllllllllllllIIIIlllIIIllIIIII, final BlockPos lllllllllllllllIIIIlllIIIlIllllI, final IBlockState lllllllllllllllIIIIlllIIIllIIIll, final int lllllllllllllllIIIIlllIIIllIIIlI) {
        if (lllllllllllllllIIIIlllIIIllIIIll.getValue(BlockNewLeaf.VARIANT) == BlockPlanks.EnumType.DARK_OAK && lllllllllllllllIIIIlllIIIllIIIII.rand.nextInt(lllllllllllllllIIIIlllIIIllIIIlI) == 0) {
            Block.spawnAsEntity(lllllllllllllllIIIIlllIIIllIIIII, lllllllllllllllIIIIlllIIIlIllllI, new ItemStack(Items.APPLE));
        }
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIIIIlllIIIlIIllll, final BlockPos lllllllllllllllIIIIlllIIIlIIlllI, final IBlockState lllllllllllllllIIIIlllIIIlIIlIll) {
        return new ItemStack(this, 1, lllllllllllllllIIIIlllIIIlIIlIll.getBlock().getMetaFromState(lllllllllllllllIIIIlllIIIlIIlIll) & 0x3);
    }
    
    @Override
    public BlockPlanks.EnumType getWoodType(final int lllllllllllllllIIIIlllIIIIlIlllI) {
        return BlockPlanks.EnumType.byMetadata((lllllllllllllllIIIIlllIIIIlIlllI & 0x3) + 4);
    }
    
    public BlockNewLeaf() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty((IProperty<Comparable>)BlockNewLeaf.CHECK_DECAY, true).withProperty((IProperty<Comparable>)BlockNewLeaf.DECAYABLE, true));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType lllllllllllllIIllIIllllllllllIII) {
                return lllllllllllllIIllIIllllllllllIII.getMetadata() >= 4;
            }
        });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIIlllIIIIlllIlI) {
        return this.getDefaultState().withProperty(BlockNewLeaf.VARIANT, this.getWoodType(lllllllllllllllIIIIlllIIIIlllIlI)).withProperty((IProperty<Comparable>)BlockNewLeaf.DECAYABLE, (lllllllllllllllIIIIlllIIIIlllIlI & 0x4) == 0x0).withProperty((IProperty<Comparable>)BlockNewLeaf.CHECK_DECAY, (lllllllllllllllIIIIlllIIIIlllIlI & 0x8) > 0);
    }
}
