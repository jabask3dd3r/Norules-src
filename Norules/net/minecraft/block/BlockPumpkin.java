package net.minecraft.block;

import com.google.common.base.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import java.util.*;

public class BlockPumpkin extends BlockHorizontal
{
    private /* synthetic */ BlockPattern golemPattern;
    private /* synthetic */ BlockPattern snowmanPattern;
    private static final /* synthetic */ Predicate<IBlockState> IS_PUMPKIN;
    private /* synthetic */ BlockPattern snowmanBasePattern;
    private /* synthetic */ BlockPattern golemBasePattern;
    
    public boolean canDispenserPlace(final World llllllllllllllllIlIllIlIllIIIIIl, final BlockPos llllllllllllllllIlIllIlIllIIIIII) {
        return this.getSnowmanBasePattern().match(llllllllllllllllIlIllIlIllIIIIIl, llllllllllllllllIlIllIlIllIIIIII) != null || this.getGolemBasePattern().match(llllllllllllllllIlIllIlIllIIIIIl, llllllllllllllllIlIllIlIllIIIIII) != null;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllllIlIllIlIlIIIllII, final Rotation llllllllllllllllIlIllIlIlIIIllIl) {
        return llllllllllllllllIlIllIlIlIIIllII.withProperty((IProperty<Comparable>)BlockPumpkin.FACING, llllllllllllllllIlIllIlIlIIIllIl.rotate(llllllllllllllllIlIllIlIlIIIllII.getValue((IProperty<EnumFacing>)BlockPumpkin.FACING)));
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllllIlIllIlIllIIllll, final BlockPos llllllllllllllllIlIllIlIllIIlIlI, final IBlockState llllllllllllllllIlIllIlIllIIlIIl) {
        super.onBlockAdded(llllllllllllllllIlIllIlIllIIllll, llllllllllllllllIlIllIlIllIIlIlI, llllllllllllllllIlIllIlIllIIlIIl);
        this.trySpawnGolem(llllllllllllllllIlIllIlIllIIllll, llllllllllllllllIlIllIlIllIIlIlI);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPumpkin.FACING });
    }
    
    static {
        IS_PUMPKIN = (Predicate)new Predicate<IBlockState>() {
            public boolean apply(@Nullable final IBlockState lllllllllllllIIIlIIlIIlllIlllIlI) {
                return lllllllllllllIIIlIIlIIlllIlllIlI != null && (lllllllllllllIIIlIIlIIlllIlllIlI.getBlock() == Blocks.PUMPKIN || lllllllllllllIIIlIIlIIlllIlllIlI.getBlock() == Blocks.LIT_PUMPKIN);
            }
        };
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllllIlIllIlIIllIllIl) {
        return llllllllllllllllIlIllIlIIllIllIl.getValue((IProperty<EnumFacing>)BlockPumpkin.FACING).getHorizontalIndex();
    }
    
    protected BlockPattern getGolemBasePattern() {
        if (this.golemBasePattern == null) {
            this.golemBasePattern = FactoryBlockPattern.start().aisle("~ ~", "###", "~#~").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.IRON_BLOCK))).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.golemBasePattern;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllllIlIllIlIlIIIIIII, final BlockPos llllllllllllllllIlIllIlIIlllllll, final EnumFacing llllllllllllllllIlIllIlIIllllllI, final float llllllllllllllllIlIllIlIIlllllIl, final float llllllllllllllllIlIllIlIIlllllII, final float llllllllllllllllIlIllIlIIllllIll, final int llllllllllllllllIlIllIlIIllllIlI, final EntityLivingBase llllllllllllllllIlIllIlIIllllIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, llllllllllllllllIlIllIlIIllllIIl.getHorizontalFacing().getOpposite());
    }
    
    protected BlockPattern getGolemPattern() {
        if (this.golemPattern == null) {
            this.golemPattern = FactoryBlockPattern.start().aisle("~^~", "###", "~#~").where('^', BlockWorldState.hasState(BlockPumpkin.IS_PUMPKIN)).where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.IRON_BLOCK))).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.golemPattern;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllllIlIllIlIlIIIIlIl, final Mirror llllllllllllllllIlIllIlIlIIIIllI) {
        return llllllllllllllllIlIllIlIlIIIIlIl.withRotation(llllllllllllllllIlIllIlIlIIIIllI.toRotation(llllllllllllllllIlIllIlIlIIIIlIl.getValue((IProperty<EnumFacing>)BlockPumpkin.FACING)));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllllIlIllIlIIlllIIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, EnumFacing.getHorizontal(llllllllllllllllIlIllIlIIlllIIIl));
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllllIlIllIlIlIIlIIll, final BlockPos llllllllllllllllIlIllIlIlIIlIIlI) {
        return llllllllllllllllIlIllIlIlIIlIIll.getBlockState(llllllllllllllllIlIllIlIlIIlIIlI).getBlock().blockMaterial.isReplaceable() && llllllllllllllllIlIllIlIlIIlIIll.getBlockState(llllllllllllllllIlIllIlIlIIlIIlI.down()).isFullyOpaque();
    }
    
    protected BlockPumpkin() {
        super(Material.GOURD, MapColor.ADOBE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, EnumFacing.NORTH));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    private void trySpawnGolem(final World llllllllllllllllIlIllIlIlIlIIIII, final BlockPos llllllllllllllllIlIllIlIlIIlllll) {
        BlockPattern.PatternHelper llllllllllllllllIlIllIlIlIllIIll = this.getSnowmanPattern().match(llllllllllllllllIlIllIlIlIlIIIII, llllllllllllllllIlIllIlIlIIlllll);
        if (llllllllllllllllIlIllIlIlIllIIll != null) {
            for (int llllllllllllllllIlIllIlIlIllIIlI = 0; llllllllllllllllIlIllIlIlIllIIlI < this.getSnowmanPattern().getThumbLength(); ++llllllllllllllllIlIllIlIlIllIIlI) {
                final BlockWorldState llllllllllllllllIlIllIlIlIllIIIl = llllllllllllllllIlIllIlIlIllIIll.translateOffset(0, llllllllllllllllIlIllIlIlIllIIlI, 0);
                llllllllllllllllIlIllIlIlIlIIIII.setBlockState(llllllllllllllllIlIllIlIlIllIIIl.getPos(), Blocks.AIR.getDefaultState(), 2);
            }
            final EntitySnowman llllllllllllllllIlIllIlIlIllIIII = new EntitySnowman(llllllllllllllllIlIllIlIlIlIIIII);
            final BlockPos llllllllllllllllIlIllIlIlIlIllll = llllllllllllllllIlIllIlIlIllIIll.translateOffset(0, 2, 0).getPos();
            llllllllllllllllIlIllIlIlIllIIII.setLocationAndAngles(llllllllllllllllIlIllIlIlIlIllll.getX() + 0.5, llllllllllllllllIlIllIlIlIlIllll.getY() + 0.05, llllllllllllllllIlIllIlIlIlIllll.getZ() + 0.5, 0.0f, 0.0f);
            llllllllllllllllIlIllIlIlIlIIIII.spawnEntityInWorld(llllllllllllllllIlIllIlIlIllIIII);
            for (final EntityPlayerMP llllllllllllllllIlIllIlIlIlIlllI : llllllllllllllllIlIllIlIlIlIIIII.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, llllllllllllllllIlIllIlIlIllIIII.getEntityBoundingBox().expandXyz(5.0))) {
                CriteriaTriggers.field_192133_m.func_192229_a(llllllllllllllllIlIllIlIlIlIlllI, llllllllllllllllIlIllIlIlIllIIII);
            }
            for (int llllllllllllllllIlIllIlIlIlIllIl = 0; llllllllllllllllIlIllIlIlIlIllIl < 120; ++llllllllllllllllIlIllIlIlIlIllIl) {
                llllllllllllllllIlIllIlIlIlIIIII.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, llllllllllllllllIlIllIlIlIlIllll.getX() + llllllllllllllllIlIllIlIlIlIIIII.rand.nextDouble(), llllllllllllllllIlIllIlIlIlIllll.getY() + llllllllllllllllIlIllIlIlIlIIIII.rand.nextDouble() * 2.5, llllllllllllllllIlIllIlIlIlIllll.getZ() + llllllllllllllllIlIllIlIlIlIIIII.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
            }
            for (int llllllllllllllllIlIllIlIlIlIllII = 0; llllllllllllllllIlIllIlIlIlIllII < this.getSnowmanPattern().getThumbLength(); ++llllllllllllllllIlIllIlIlIlIllII) {
                final BlockWorldState llllllllllllllllIlIllIlIlIlIlIll = llllllllllllllllIlIllIlIlIllIIll.translateOffset(0, llllllllllllllllIlIllIlIlIlIllII, 0);
                llllllllllllllllIlIllIlIlIlIIIII.notifyNeighborsRespectDebug(llllllllllllllllIlIllIlIlIlIlIll.getPos(), Blocks.AIR, false);
            }
        }
        else {
            llllllllllllllllIlIllIlIlIllIIll = this.getGolemPattern().match(llllllllllllllllIlIllIlIlIlIIIII, llllllllllllllllIlIllIlIlIIlllll);
            if (llllllllllllllllIlIllIlIlIllIIll != null) {
                for (int llllllllllllllllIlIllIlIlIlIlIlI = 0; llllllllllllllllIlIllIlIlIlIlIlI < this.getGolemPattern().getPalmLength(); ++llllllllllllllllIlIllIlIlIlIlIlI) {
                    for (int llllllllllllllllIlIllIlIlIlIlIIl = 0; llllllllllllllllIlIllIlIlIlIlIIl < this.getGolemPattern().getThumbLength(); ++llllllllllllllllIlIllIlIlIlIlIIl) {
                        llllllllllllllllIlIllIlIlIlIIIII.setBlockState(llllllllllllllllIlIllIlIlIllIIll.translateOffset(llllllllllllllllIlIllIlIlIlIlIlI, llllllllllllllllIlIllIlIlIlIlIIl, 0).getPos(), Blocks.AIR.getDefaultState(), 2);
                    }
                }
                final BlockPos llllllllllllllllIlIllIlIlIlIlIII = llllllllllllllllIlIllIlIlIllIIll.translateOffset(1, 2, 0).getPos();
                final EntityIronGolem llllllllllllllllIlIllIlIlIlIIlll = new EntityIronGolem(llllllllllllllllIlIllIlIlIlIIIII);
                llllllllllllllllIlIllIlIlIlIIlll.setPlayerCreated(true);
                llllllllllllllllIlIllIlIlIlIIlll.setLocationAndAngles(llllllllllllllllIlIllIlIlIlIlIII.getX() + 0.5, llllllllllllllllIlIllIlIlIlIlIII.getY() + 0.05, llllllllllllllllIlIllIlIlIlIlIII.getZ() + 0.5, 0.0f, 0.0f);
                llllllllllllllllIlIllIlIlIlIIIII.spawnEntityInWorld(llllllllllllllllIlIllIlIlIlIIlll);
                for (final EntityPlayerMP llllllllllllllllIlIllIlIlIlIIllI : llllllllllllllllIlIllIlIlIlIIIII.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, llllllllllllllllIlIllIlIlIlIIlll.getEntityBoundingBox().expandXyz(5.0))) {
                    CriteriaTriggers.field_192133_m.func_192229_a(llllllllllllllllIlIllIlIlIlIIllI, llllllllllllllllIlIllIlIlIlIIlll);
                }
                for (int llllllllllllllllIlIllIlIlIlIIlIl = 0; llllllllllllllllIlIllIlIlIlIIlIl < 120; ++llllllllllllllllIlIllIlIlIlIIlIl) {
                    llllllllllllllllIlIllIlIlIlIIIII.spawnParticle(EnumParticleTypes.SNOWBALL, llllllllllllllllIlIllIlIlIlIlIII.getX() + llllllllllllllllIlIllIlIlIlIIIII.rand.nextDouble(), llllllllllllllllIlIllIlIlIlIlIII.getY() + llllllllllllllllIlIllIlIlIlIIIII.rand.nextDouble() * 3.9, llllllllllllllllIlIllIlIlIlIlIII.getZ() + llllllllllllllllIlIllIlIlIlIIIII.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
                }
                for (int llllllllllllllllIlIllIlIlIlIIlII = 0; llllllllllllllllIlIllIlIlIlIIlII < this.getGolemPattern().getPalmLength(); ++llllllllllllllllIlIllIlIlIlIIlII) {
                    for (int llllllllllllllllIlIllIlIlIlIIIll = 0; llllllllllllllllIlIllIlIlIlIIIll < this.getGolemPattern().getThumbLength(); ++llllllllllllllllIlIllIlIlIlIIIll) {
                        final BlockWorldState llllllllllllllllIlIllIlIlIlIIIlI = llllllllllllllllIlIllIlIlIllIIll.translateOffset(llllllllllllllllIlIllIlIlIlIIlII, llllllllllllllllIlIllIlIlIlIIIll, 0);
                        llllllllllllllllIlIllIlIlIlIIIII.notifyNeighborsRespectDebug(llllllllllllllllIlIllIlIlIlIIIlI.getPos(), Blocks.AIR, false);
                    }
                }
            }
        }
    }
    
    protected BlockPattern getSnowmanBasePattern() {
        if (this.snowmanBasePattern == null) {
            this.snowmanBasePattern = FactoryBlockPattern.start().aisle(" ", "#", "#").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SNOW))).build();
        }
        return this.snowmanBasePattern;
    }
    
    protected BlockPattern getSnowmanPattern() {
        if (this.snowmanPattern == null) {
            this.snowmanPattern = FactoryBlockPattern.start().aisle("^", "#", "#").where('^', BlockWorldState.hasState(BlockPumpkin.IS_PUMPKIN)).where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SNOW))).build();
        }
        return this.snowmanPattern;
    }
}
