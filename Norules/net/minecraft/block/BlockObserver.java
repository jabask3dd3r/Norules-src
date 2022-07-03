package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockObserver extends BlockDirectional
{
    public static final /* synthetic */ PropertyBool field_190963_a;
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIlllllIIlIIIIIIIIlI) {
        return true;
    }
    
    public void func_190962_b(final IBlockState lllllllllllllIlllllIIlIIIIlIlIll, final World lllllllllllllIlllllIIlIIIIlIIlII, final BlockPos lllllllllllllIlllllIIlIIIIlIlIIl, final Block lllllllllllllIlllllIIlIIIIlIlIII, final BlockPos lllllllllllllIlllllIIlIIIIlIIIlI) {
        if (!lllllllllllllIlllllIIlIIIIlIIlII.isRemote && lllllllllllllIlllllIIlIIIIlIlIIl.offset(lllllllllllllIlllllIIlIIIIlIlIll.getValue((IProperty<EnumFacing>)BlockObserver.FACING)).equals(lllllllllllllIlllllIIlIIIIlIIIlI)) {
            this.func_190960_d(lllllllllllllIlllllIIlIIIIlIlIll, lllllllllllllIlllllIIlIIIIlIIlII, lllllllllllllIlllllIIlIIIIlIlIIl);
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlllllIIlIIIlIIllIl, final Rotation lllllllllllllIlllllIIlIIIlIIlllI) {
        return lllllllllllllIlllllIIlIIIlIIllIl.withProperty((IProperty<Comparable>)BlockObserver.FACING, lllllllllllllIlllllIIlIIIlIIlllI.rotate(lllllllllllllIlllllIIlIIIlIIllIl.getValue((IProperty<EnumFacing>)BlockObserver.FACING)));
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIlllllIIIlllllIlllI, final IBlockAccess lllllllllllllIlllllIIIlllllIllIl, final BlockPos lllllllllllllIlllllIIIlllllIllII, final EnumFacing lllllllllllllIlllllIIIlllllIIlll) {
        return (lllllllllllllIlllllIIIlllllIlllI.getValue((IProperty<Boolean>)BlockObserver.field_190963_a) && lllllllllllllIlllllIIIlllllIlllI.getValue((IProperty<Comparable>)BlockObserver.FACING) == lllllllllllllIlllllIIIlllllIIlll) ? 15 : 0;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockObserver.FACING, BlockObserver.field_190963_a });
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlllllIIIllllIIIllI, final BlockPos lllllllllllllIlllllIIIllllIIIlIl, final IBlockState lllllllllllllIlllllIIIllllIIIIII) {
        if (lllllllllllllIlllllIIIllllIIIIII.getValue((IProperty<Boolean>)BlockObserver.field_190963_a) && lllllllllllllIlllllIIIllllIIIllI.isUpdateScheduled(lllllllllllllIlllllIIIllllIIIlIl, this)) {
            this.func_190961_e(lllllllllllllIlllllIIIllllIIIllI, lllllllllllllIlllllIIIllllIIIlIl, lllllllllllllIlllllIIIllllIIIIII.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, false));
        }
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIlllllIIIlllllllIII, final IBlockAccess lllllllllllllIlllllIIIllllllIlll, final BlockPos lllllllllllllIlllllIIIlllllllIlI, final EnumFacing lllllllllllllIlllllIIIllllllIlIl) {
        return lllllllllllllIlllllIIIlllllllIII.getWeakPower(lllllllllllllIlllllIIIllllllIlll, lllllllllllllIlllllIIIlllllllIlI, lllllllllllllIlllllIIIllllllIlIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlllllIIIlllIlIIlII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockObserver.FACING, EnumFacing.getFront(lllllllllllllIlllllIIIlllIlIIlII & 0x7));
    }
    
    @Override
    public void updateTick(final World lllllllllllllIlllllIIlIIIIlllIlI, final BlockPos lllllllllllllIlllllIIlIIIIlllIIl, final IBlockState lllllllllllllIlllllIIlIIIIllllIl, final Random lllllllllllllIlllllIIlIIIIllllII) {
        if (lllllllllllllIlllllIIlIIIIllllIl.getValue((IProperty<Boolean>)BlockObserver.field_190963_a)) {
            lllllllllllllIlllllIIlIIIIlllIlI.setBlockState(lllllllllllllIlllllIIlIIIIlllIIl, lllllllllllllIlllllIIlIIIIllllIl.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, false), 2);
        }
        else {
            lllllllllllllIlllllIIlIIIIlllIlI.setBlockState(lllllllllllllIlllllIIlIIIIlllIIl, lllllllllllllIlllllIIlIIIIllllIl.withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, true), 2);
            lllllllllllllIlllllIIlIIIIlllIlI.scheduleUpdate(lllllllllllllIlllllIIlIIIIlllIIl, this, 2);
        }
        this.func_190961_e(lllllllllllllIlllllIIlIIIIlllIlI, lllllllllllllIlllllIIlIIIIlllIIl, lllllllllllllIlllllIIlIIIIllllIl);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIlllllIIIlllIlllIll, final BlockPos lllllllllllllIlllllIIIlllIllIIlI, final EnumFacing lllllllllllllIlllllIIIlllIlllIIl, final float lllllllllllllIlllllIIIlllIlllIII, final float lllllllllllllIlllllIIIlllIllIlll, final float lllllllllllllIlllllIIIlllIllIllI, final int lllllllllllllIlllllIIIlllIllIlIl, final EntityLivingBase lllllllllllllIlllllIIIlllIllIIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockObserver.FACING, EnumFacing.func_190914_a(lllllllllllllIlllllIIIlllIllIIlI, lllllllllllllIlllllIIIlllIllIIIl).getOpposite());
    }
    
    protected void func_190961_e(final World lllllllllllllIlllllIIlIIIIIIlIII, final BlockPos lllllllllllllIlllllIIlIIIIIIllIl, final IBlockState lllllllllllllIlllllIIlIIIIIIIllI) {
        final EnumFacing lllllllllllllIlllllIIlIIIIIIlIll = lllllllllllllIlllllIIlIIIIIIIllI.getValue((IProperty<EnumFacing>)BlockObserver.FACING);
        final BlockPos lllllllllllllIlllllIIlIIIIIIlIlI = lllllllllllllIlllllIIlIIIIIIllIl.offset(lllllllllllllIlllllIIlIIIIIIlIll.getOpposite());
        lllllllllllllIlllllIIlIIIIIIlIII.func_190524_a(lllllllllllllIlllllIIlIIIIIIlIlI, this, lllllllllllllIlllllIIlIIIIIIllIl);
        lllllllllllllIlllllIIlIIIIIIlIII.notifyNeighborsOfStateExcept(lllllllllllllIlllllIIlIIIIIIlIlI, this, lllllllllllllIlllllIIlIIIIIIlIll);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIlllllIIIllllIlIIII, final BlockPos lllllllllllllIlllllIIIllllIlIlII, final IBlockState lllllllllllllIlllllIIIllllIIllIl) {
        if (!lllllllllllllIlllllIIIllllIlIIII.isRemote) {
            if (lllllllllllllIlllllIIIllllIIllIl.getValue((IProperty<Boolean>)BlockObserver.field_190963_a)) {
                this.updateTick(lllllllllllllIlllllIIIllllIlIIII, lllllllllllllIlllllIIIllllIlIlII, lllllllllllllIlllllIIIllllIIllIl, lllllllllllllIlllllIIIllllIlIIII.rand);
            }
            this.func_190960_d(lllllllllllllIlllllIIIllllIIllIl, lllllllllllllIlllllIIIllllIlIIII, lllllllllllllIlllllIIIllllIlIlII);
        }
    }
    
    static {
        field_190963_a = PropertyBool.create("powered");
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlllllIIIlllIlIllIl) {
        int lllllllllllllIlllllIIIlllIlIllII = 0;
        lllllllllllllIlllllIIIlllIlIllII |= lllllllllllllIlllllIIIlllIlIllIl.getValue((IProperty<EnumFacing>)BlockObserver.FACING).getIndex();
        if (lllllllllllllIlllllIIIlllIlIllIl.getValue((IProperty<Boolean>)BlockObserver.field_190963_a)) {
            lllllllllllllIlllllIIIlllIlIllII |= 0x8;
        }
        return lllllllllllllIlllllIIIlllIlIllII;
    }
    
    public BlockObserver() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockObserver.FACING, EnumFacing.SOUTH).withProperty((IProperty<Comparable>)BlockObserver.field_190963_a, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    private void func_190960_d(final IBlockState lllllllllllllIlllllIIlIIIIIllIII, final World lllllllllllllIlllllIIlIIIIIlIlll, final BlockPos lllllllllllllIlllllIIlIIIIIllIlI) {
        if (!lllllllllllllIlllllIIlIIIIIllIII.getValue((IProperty<Boolean>)BlockObserver.field_190963_a) && !lllllllllllllIlllllIIlIIIIIlIlll.isUpdateScheduled(lllllllllllllIlllllIIlIIIIIllIlI, this)) {
            lllllllllllllIlllllIIlIIIIIlIlll.scheduleUpdate(lllllllllllllIlllllIIlIIIIIllIlI, this, 2);
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlllllIIlIIIlIIlIII, final Mirror lllllllllllllIlllllIIlIIIlIIIlll) {
        return lllllllllllllIlllllIIlIIIlIIlIII.withRotation(lllllllllllllIlllllIIlIIIlIIIlll.toRotation(lllllllllllllIlllllIIlIIIlIIlIII.getValue((IProperty<EnumFacing>)BlockObserver.FACING)));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlllllIIlIIIIllIllI, final World lllllllllllllIlllllIIlIIIIllIlIl, final BlockPos lllllllllllllIlllllIIlIIIIllIlII, final Block lllllllllllllIlllllIIlIIIIllIIll, final BlockPos lllllllllllllIlllllIIlIIIIllIIlI) {
    }
}
