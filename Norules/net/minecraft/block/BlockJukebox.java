package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class BlockJukebox extends BlockContainer
{
    public static final /* synthetic */ PropertyBool HAS_RECORD;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIIlllIlIllllIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, lllllllllllllllIIIlllIlIllllIIll > 0);
    }
    
    static {
        HAS_RECORD = PropertyBool.create("has_record");
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllllIIIlllIllIIIIIIll, final World lllllllllllllllIIIlllIlIlllllllI, final BlockPos lllllllllllllllIIIlllIllIIIIIIIl) {
        final TileEntity lllllllllllllllIIIlllIllIIIIIIII = lllllllllllllllIIIlllIlIlllllllI.getTileEntity(lllllllllllllllIIIlllIllIIIIIIIl);
        if (lllllllllllllllIIIlllIllIIIIIIII instanceof TileEntityJukebox) {
            final ItemStack lllllllllllllllIIIlllIlIllllllll = ((TileEntityJukebox)lllllllllllllllIIIlllIllIIIIIIII).getRecord();
            if (!lllllllllllllllIIIlllIlIllllllll.func_190926_b()) {
                return Item.getIdFromItem(lllllllllllllllIIIlllIlIllllllll.getItem()) + 1 - Item.getIdFromItem(Items.RECORD_13);
            }
        }
        return 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockJukebox.HAS_RECORD });
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllIIIlllIlIlllllIIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    protected BlockJukebox() {
        super(Material.WOOD, MapColor.DIRT);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, false));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIIIlllIllIllIlIIl, final BlockPos lllllllllllllllIIIlllIllIlIllllI, IBlockState lllllllllllllllIIIlllIllIllIIlll, final EntityPlayer lllllllllllllllIIIlllIllIllIIllI, final EnumHand lllllllllllllllIIIlllIllIllIIlIl, final EnumFacing lllllllllllllllIIIlllIllIllIIlII, final float lllllllllllllllIIIlllIllIllIIIll, final float lllllllllllllllIIIlllIllIllIIIlI, final float lllllllllllllllIIIlllIllIllIIIIl) {
        if (lllllllllllllllIIIlllIllIllIIlll.getValue((IProperty<Boolean>)BlockJukebox.HAS_RECORD)) {
            this.dropRecord(lllllllllllllllIIIlllIllIllIlIIl, lllllllllllllllIIIlllIllIlIllllI, lllllllllllllllIIIlllIllIllIIlll);
            lllllllllllllllIIIlllIllIllIIlll = lllllllllllllllIIIlllIllIllIIlll.withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, false);
            lllllllllllllllIIIlllIllIllIlIIl.setBlockState(lllllllllllllllIIIlllIllIlIllllI, lllllllllllllllIIIlllIllIllIIlll, 2);
            return true;
        }
        return false;
    }
    
    public void insertRecord(final World lllllllllllllllIIIlllIllIlIlIIIl, final BlockPos lllllllllllllllIIIlllIllIlIlIlIl, final IBlockState lllllllllllllllIIIlllIllIlIlIlII, final ItemStack lllllllllllllllIIIlllIllIlIIlllI) {
        final TileEntity lllllllllllllllIIIlllIllIlIlIIlI = lllllllllllllllIIIlllIllIlIlIIIl.getTileEntity(lllllllllllllllIIIlllIllIlIlIlIl);
        if (lllllllllllllllIIIlllIllIlIlIIlI instanceof TileEntityJukebox) {
            ((TileEntityJukebox)lllllllllllllllIIIlllIllIlIlIIlI).setRecord(lllllllllllllllIIIlllIllIlIIlllI.copy());
            lllllllllllllllIIIlllIllIlIlIIIl.setBlockState(lllllllllllllllIIIlllIllIlIlIlIl, lllllllllllllllIIIlllIllIlIlIlII.withProperty((IProperty<Comparable>)BlockJukebox.HAS_RECORD, true), 2);
        }
    }
    
    private void dropRecord(final World lllllllllllllllIIIlllIllIIllIlII, final BlockPos lllllllllllllllIIIlllIllIIllllll, final IBlockState lllllllllllllllIIIlllIllIIlllllI) {
        if (!lllllllllllllllIIIlllIllIIllIlII.isRemote) {
            final TileEntity lllllllllllllllIIIlllIllIIllllIl = lllllllllllllllIIIlllIllIIllIlII.getTileEntity(lllllllllllllllIIIlllIllIIllllll);
            if (lllllllllllllllIIIlllIllIIllllIl instanceof TileEntityJukebox) {
                final TileEntityJukebox lllllllllllllllIIIlllIllIIllllII = (TileEntityJukebox)lllllllllllllllIIIlllIllIIllllIl;
                final ItemStack lllllllllllllllIIIlllIllIIlllIll = lllllllllllllllIIIlllIllIIllllII.getRecord();
                if (!lllllllllllllllIIIlllIllIIlllIll.func_190926_b()) {
                    lllllllllllllllIIIlllIllIIllIlII.playEvent(1010, lllllllllllllllIIIlllIllIIllllll, 0);
                    lllllllllllllllIIIlllIllIIllIlII.playRecord(lllllllllllllllIIIlllIllIIllllll, null);
                    lllllllllllllllIIIlllIllIIllllII.setRecord(ItemStack.field_190927_a);
                    final float lllllllllllllllIIIlllIllIIlllIlI = 0.7f;
                    final double lllllllllllllllIIIlllIllIIlllIIl = lllllllllllllllIIIlllIllIIllIlII.rand.nextFloat() * 0.7f + 0.15000000596046448;
                    final double lllllllllllllllIIIlllIllIIlllIII = lllllllllllllllIIIlllIllIIllIlII.rand.nextFloat() * 0.7f + 0.06000000238418579 + 0.6;
                    final double lllllllllllllllIIIlllIllIIllIlll = lllllllllllllllIIIlllIllIIllIlII.rand.nextFloat() * 0.7f + 0.15000000596046448;
                    final ItemStack lllllllllllllllIIIlllIllIIllIllI = lllllllllllllllIIIlllIllIIlllIll.copy();
                    final EntityItem lllllllllllllllIIIlllIllIIllIlIl = new EntityItem(lllllllllllllllIIIlllIllIIllIlII, lllllllllllllllIIIlllIllIIllllll.getX() + lllllllllllllllIIIlllIllIIlllIIl, lllllllllllllllIIIlllIllIIllllll.getY() + lllllllllllllllIIIlllIllIIlllIII, lllllllllllllllIIIlllIllIIllllll.getZ() + lllllllllllllllIIIlllIllIIllIlll, lllllllllllllllIIIlllIllIIllIllI);
                    lllllllllllllllIIIlllIllIIllIlIl.setDefaultPickupDelay();
                    lllllllllllllllIIIlllIllIIllIlII.spawnEntityInWorld(lllllllllllllllIIIlllIllIIllIlIl);
                }
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIIIlllIllIIIIllII, final int lllllllllllllllIIIlllIllIIIIlIll) {
        return new TileEntityJukebox();
    }
    
    public static void registerFixesJukebox(final DataFixer lllllllllllllllIIIlllIllIlllIIll) {
        lllllllllllllllIIIlllIllIlllIIll.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackData(TileEntityJukebox.class, new String[] { "RecordItem" }));
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIIIlllIllIIIlIlll, final BlockPos lllllllllllllllIIIlllIllIIIlIIII, final IBlockState lllllllllllllllIIIlllIllIIIIllll, final float lllllllllllllllIIIlllIllIIIlIlII, final int lllllllllllllllIIIlllIllIIIlIIll) {
        if (!lllllllllllllllIIIlllIllIIIlIlll.isRemote) {
            super.dropBlockAsItemWithChance(lllllllllllllllIIIlllIllIIIlIlll, lllllllllllllllIIIlllIllIIIlIIII, lllllllllllllllIIIlllIllIIIIllll, lllllllllllllllIIIlllIllIIIlIlII, 0);
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIIIlllIllIIlIIIII, final BlockPos lllllllllllllllIIIlllIllIIlIIIll, final IBlockState lllllllllllllllIIIlllIllIIIllllI) {
        this.dropRecord(lllllllllllllllIIIlllIllIIlIIIII, lllllllllllllllIIIlllIllIIlIIIll, lllllllllllllllIIIlllIllIIIllllI);
        super.breakBlock(lllllllllllllllIIIlllIllIIlIIIII, lllllllllllllllIIIlllIllIIlIIIll, lllllllllllllllIIIlllIllIIIllllI);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllllIIIlllIllIIIIlIIl) {
        return true;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIlllIlIlllIllll) {
        return ((boolean)lllllllllllllllIIIlllIlIlllIllll.getValue((IProperty<Boolean>)BlockJukebox.HAS_RECORD)) ? 1 : 0;
    }
    
    public static class TileEntityJukebox extends TileEntity
    {
        private /* synthetic */ ItemStack record;
        
        public TileEntityJukebox() {
            this.record = ItemStack.field_190927_a;
        }
        
        public ItemStack getRecord() {
            return this.record;
        }
        
        @Override
        public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIIllIlllIllllllIl) {
            super.writeToNBT(llllllllllllllIIIllIlllIllllllIl);
            if (!this.getRecord().func_190926_b()) {
                llllllllllllllIIIllIlllIllllllIl.setTag("RecordItem", this.getRecord().writeToNBT(new NBTTagCompound()));
            }
            return llllllllllllllIIIllIlllIllllllIl;
        }
        
        @Override
        public void readFromNBT(final NBTTagCompound llllllllllllllIIIllIllllIIIIIIll) {
            super.readFromNBT(llllllllllllllIIIllIllllIIIIIIll);
            if (llllllllllllllIIIllIllllIIIIIIll.hasKey("RecordItem", 10)) {
                this.setRecord(new ItemStack(llllllllllllllIIIllIllllIIIIIIll.getCompoundTag("RecordItem")));
            }
            else if (llllllllllllllIIIllIllllIIIIIIll.getInteger("Record") > 0) {
                this.setRecord(new ItemStack(Item.getItemById(llllllllllllllIIIllIllllIIIIIIll.getInteger("Record"))));
            }
        }
        
        public void setRecord(final ItemStack llllllllllllllIIIllIlllIllllIIlI) {
            this.record = llllllllllllllIIIllIlllIllllIIlI;
            this.markDirty();
        }
    }
}
