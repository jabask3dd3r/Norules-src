package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;

public abstract class BlockLeaves extends Block
{
    public static final /* synthetic */ PropertyBool DECAYABLE;
    protected /* synthetic */ boolean leavesFancy;
    public static final /* synthetic */ PropertyBool CHECK_DECAY;
    /* synthetic */ int[] surroundings;
    
    @Override
    public void breakBlock(final World llllllllllllllIIlIlllIIllIlllIlI, final BlockPos llllllllllllllIIlIlllIIllIlllIII, final IBlockState llllllllllllllIIlIlllIIlllIIllII) {
        final int llllllllllllllIIlIlllIIlllIIlIll = 1;
        final int llllllllllllllIIlIlllIIlllIIlIlI = 2;
        final int llllllllllllllIIlIlllIIlllIIlIII = llllllllllllllIIlIlllIIllIlllIII.getX();
        final int llllllllllllllIIlIlllIIlllIIIllI = llllllllllllllIIlIlllIIllIlllIII.getY();
        final int llllllllllllllIIlIlllIIlllIIIlIl = llllllllllllllIIlIlllIIllIlllIII.getZ();
        if (llllllllllllllIIlIlllIIllIlllIlI.isAreaLoaded(new BlockPos(llllllllllllllIIlIlllIIlllIIlIII - 2, llllllllllllllIIlIlllIIlllIIIllI - 2, llllllllllllllIIlIlllIIlllIIIlIl - 2), new BlockPos(llllllllllllllIIlIlllIIlllIIlIII + 2, llllllllllllllIIlIlllIIlllIIIllI + 2, llllllllllllllIIlIlllIIlllIIIlIl + 2))) {
            for (int llllllllllllllIIlIlllIIlllIIIIll = -1; llllllllllllllIIlIlllIIlllIIIIll <= 1; ++llllllllllllllIIlIlllIIlllIIIIll) {
                for (int llllllllllllllIIlIlllIIlllIIIIIl = -1; llllllllllllllIIlIlllIIlllIIIIIl <= 1; ++llllllllllllllIIlIlllIIlllIIIIIl) {
                    for (int llllllllllllllIIlIlllIIllIllllll = -1; llllllllllllllIIlIlllIIllIllllll <= 1; ++llllllllllllllIIlIlllIIllIllllll) {
                        final BlockPos llllllllllllllIIlIlllIIllIllllIl = llllllllllllllIIlIlllIIllIlllIII.add(llllllllllllllIIlIlllIIlllIIIIll, llllllllllllllIIlIlllIIlllIIIIIl, llllllllllllllIIlIlllIIllIllllll);
                        final IBlockState llllllllllllllIIlIlllIIllIllllII = llllllllllllllIIlIlllIIllIlllIlI.getBlockState(llllllllllllllIIlIlllIIllIllllIl);
                        if (llllllllllllllIIlIlllIIllIllllII.getMaterial() == Material.LEAVES && !llllllllllllllIIlIlllIIllIllllII.getValue((IProperty<Boolean>)BlockLeaves.CHECK_DECAY)) {
                            llllllllllllllIIlIlllIIllIlllIlI.setBlockState(llllllllllllllIIlIlllIIllIllllIl, llllllllllllllIIlIlllIIllIllllII.withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, true), 4);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIIlIlllIIlIIIIlllI, final World llllllllllllllIIlIlllIIlIIIIllIl, final BlockPos llllllllllllllIIlIlllIIlIIIIIllI, final Random llllllllllllllIIlIlllIIlIIIIlIll) {
        if (llllllllllllllIIlIlllIIlIIIIllIl.isRainingAt(llllllllllllllIIlIlllIIlIIIIIllI.up()) && !llllllllllllllIIlIlllIIlIIIIllIl.getBlockState(llllllllllllllIIlIlllIIlIIIIIllI.down()).isFullyOpaque() && llllllllllllllIIlIlllIIlIIIIlIll.nextInt(15) == 1) {
            final double llllllllllllllIIlIlllIIlIIIIlIlI = llllllllllllllIIlIlllIIlIIIIIllI.getX() + llllllllllllllIIlIlllIIlIIIIlIll.nextFloat();
            final double llllllllllllllIIlIlllIIlIIIIlIIl = llllllllllllllIIlIlllIIlIIIIIllI.getY() - 0.05;
            final double llllllllllllllIIlIlllIIlIIIIlIII = llllllllllllllIIlIlllIIlIIIIIllI.getZ() + llllllllllllllIIlIlllIIlIIIIlIll.nextFloat();
            llllllllllllllIIlIlllIIlIIIIllIl.spawnParticle(EnumParticleTypes.DRIP_WATER, llllllllllllllIIlIlllIIlIIIIlIlI, llllllllllllllIIlIlllIIlIIIIlIIl, llllllllllllllIIlIlllIIlIIIIlIII, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    protected void dropApple(final World llllllllllllllIIlIlllIIIllIllIIl, final BlockPos llllllllllllllIIlIlllIIIllIllIII, final IBlockState llllllllllllllIIlIlllIIIllIlIlll, final int llllllllllllllIIlIlllIIIllIlIllI) {
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIlIlllIIIllIlIIIl) {
        return !this.leavesFancy;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIlIlllIIIllllIlIl) {
        return (llllllllllllllIIlIlllIIIllllIlIl.nextInt(20) == 0) ? 1 : 0;
    }
    
    public abstract BlockPlanks.EnumType getWoodType(final int p0);
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIlIlllIIIlllIlIII, final BlockPos llllllllllllllIIlIlllIIIlllIIlll, final IBlockState llllllllllllllIIlIlllIIIlllIIllI, final float llllllllllllllIIlIlllIIIlllIIlIl, final int llllllllllllllIIlIlllIIIllIlllIl) {
        if (!llllllllllllllIIlIlllIIIlllIlIII.isRemote) {
            int llllllllllllllIIlIlllIIIlllIIIll = this.getSaplingDropChance(llllllllllllllIIlIlllIIIlllIIllI);
            if (llllllllllllllIIlIlllIIIllIlllIl > 0) {
                llllllllllllllIIlIlllIIIlllIIIll -= 2 << llllllllllllllIIlIlllIIIllIlllIl;
                if (llllllllllllllIIlIlllIIIlllIIIll < 10) {
                    llllllllllllllIIlIlllIIIlllIIIll = 10;
                }
            }
            if (llllllllllllllIIlIlllIIIlllIlIII.rand.nextInt(llllllllllllllIIlIlllIIIlllIIIll) == 0) {
                final Item llllllllllllllIIlIlllIIIlllIIIlI = this.getItemDropped(llllllllllllllIIlIlllIIIlllIIllI, llllllllllllllIIlIlllIIIlllIlIII.rand, llllllllllllllIIlIlllIIIllIlllIl);
                Block.spawnAsEntity(llllllllllllllIIlIlllIIIlllIlIII, llllllllllllllIIlIlllIIIlllIIlll, new ItemStack(llllllllllllllIIlIlllIIIlllIIIlI, 1, this.damageDropped(llllllllllllllIIlIlllIIIlllIIllI)));
            }
            llllllllllllllIIlIlllIIIlllIIIll = 200;
            if (llllllllllllllIIlIlllIIIllIlllIl > 0) {
                llllllllllllllIIlIlllIIIlllIIIll -= 10 << llllllllllllllIIlIlllIIIllIlllIl;
                if (llllllllllllllIIlIlllIIIlllIIIll < 40) {
                    llllllllllllllIIlIlllIIIlllIIIll = 40;
                }
            }
            this.dropApple(llllllllllllllIIlIlllIIIlllIlIII, llllllllllllllIIlIlllIIIlllIIlll, llllllllllllllIIlIlllIIIlllIIllI, llllllllllllllIIlIlllIIIlllIIIll);
        }
    }
    
    private void destroy(final World llllllllllllllIIlIlllIIIllllllIl, final BlockPos llllllllllllllIIlIlllIIIlllllIIl) {
        this.dropBlockAsItem(llllllllllllllIIlIlllIIIllllllIl, llllllllllllllIIlIlllIIIlllllIIl, llllllllllllllIIlIlllIIIllllllIl.getBlockState(llllllllllllllIIlIlllIIIlllllIIl), 0);
        llllllllllllllIIlIlllIIIllllllIl.setBlockToAir(llllllllllllllIIlIlllIIIlllllIIl);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllIIlIlllIIIlIlllIIl, final IBlockAccess llllllllllllllIIlIlllIIIlIllllIl, final BlockPos llllllllllllllIIlIlllIIIlIllIlll, final EnumFacing llllllllllllllIIlIlllIIIlIlllIll) {
        return (this.leavesFancy || llllllllllllllIIlIlllIIIlIllllIl.getBlockState(llllllllllllllIIlIlllIIIlIllIlll.offset(llllllllllllllIIlIlllIIIlIlllIll)).getBlock() != this) && super.shouldSideBeRendered(llllllllllllllIIlIlllIIIlIlllIIl, llllllllllllllIIlIlllIIIlIllllIl, llllllllllllllIIlIlllIIIlIllIlll, llllllllllllllIIlIlllIIIlIlllIll);
    }
    
    static {
        DECAYABLE = PropertyBool.create("decayable");
        CHECK_DECAY = PropertyBool.create("check_decay");
    }
    
    @Override
    public boolean causesSuffocation(final IBlockState llllllllllllllIIlIlllIIIllIIIlIl) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return this.leavesFancy ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }
    
    public BlockLeaves() {
        super(Material.LEAVES);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.2f);
        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIlllIIIllllIIll, final Random llllllllllllllIIlIlllIIIllllIIlI, final int llllllllllllllIIlIlllIIIllllIIIl) {
        return Item.getItemFromBlock(Blocks.SAPLING);
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIlIlllIIlIIlIIllI, final BlockPos llllllllllllllIIlIlllIIlIIlIIlIl, final IBlockState llllllllllllllIIlIlllIIlIlIIIIlI, final Random llllllllllllllIIlIlllIIlIlIIIIII) {
        if (!llllllllllllllIIlIlllIIlIIlIIllI.isRemote && llllllllllllllIIlIlllIIlIlIIIIlI.getValue((IProperty<Boolean>)BlockLeaves.CHECK_DECAY) && llllllllllllllIIlIlllIIlIlIIIIlI.getValue((IProperty<Boolean>)BlockLeaves.DECAYABLE)) {
            final int llllllllllllllIIlIlllIIlIIlllllI = 4;
            final int llllllllllllllIIlIlllIIlIIllllIl = 5;
            final int llllllllllllllIIlIlllIIlIIllllII = llllllllllllllIIlIlllIIlIIlIIlIl.getX();
            final int llllllllllllllIIlIlllIIlIIlllIll = llllllllllllllIIlIlllIIlIIlIIlIl.getY();
            final int llllllllllllllIIlIlllIIlIIlllIlI = llllllllllllllIIlIlllIIlIIlIIlIl.getZ();
            final int llllllllllllllIIlIlllIIlIIlllIIl = 32;
            final int llllllllllllllIIlIlllIIlIIllIlll = 1024;
            final int llllllllllllllIIlIlllIIlIIllIllI = 16;
            if (this.surroundings == null) {
                this.surroundings = new int[32768];
            }
            if (llllllllllllllIIlIlllIIlIIlIIllI.isAreaLoaded(new BlockPos(llllllllllllllIIlIlllIIlIIllllII - 5, llllllllllllllIIlIlllIIlIIlllIll - 5, llllllllllllllIIlIlllIIlIIlllIlI - 5), new BlockPos(llllllllllllllIIlIlllIIlIIllllII + 5, llllllllllllllIIlIlllIIlIIlllIll + 5, llllllllllllllIIlIlllIIlIIlllIlI + 5))) {
                final BlockPos.MutableBlockPos llllllllllllllIIlIlllIIlIIllIlII = new BlockPos.MutableBlockPos();
                for (int llllllllllllllIIlIlllIIlIIllIIlI = -4; llllllllllllllIIlIlllIIlIIllIIlI <= 4; ++llllllllllllllIIlIlllIIlIIllIIlI) {
                    for (int llllllllllllllIIlIlllIIlIIllIIII = -4; llllllllllllllIIlIlllIIlIIllIIII <= 4; ++llllllllllllllIIlIlllIIlIIllIIII) {
                        for (int llllllllllllllIIlIlllIIlIIlIllll = -4; llllllllllllllIIlIlllIIlIIlIllll <= 4; ++llllllllllllllIIlIlllIIlIIlIllll) {
                            final IBlockState llllllllllllllIIlIlllIIlIIlIlllI = llllllllllllllIIlIlllIIlIIlIIllI.getBlockState(llllllllllllllIIlIlllIIlIIllIlII.setPos(llllllllllllllIIlIlllIIlIIllllII + llllllllllllllIIlIlllIIlIIllIIlI, llllllllllllllIIlIlllIIlIIlllIll + llllllllllllllIIlIlllIIlIIllIIII, llllllllllllllIIlIlllIIlIIlllIlI + llllllllllllllIIlIlllIIlIIlIllll));
                            final Block llllllllllllllIIlIlllIIlIIlIllIl = llllllllllllllIIlIlllIIlIIlIlllI.getBlock();
                            if (llllllllllllllIIlIlllIIlIIlIllIl != Blocks.LOG && llllllllllllllIIlIlllIIlIIlIllIl != Blocks.LOG2) {
                                if (llllllllllllllIIlIlllIIlIIlIlllI.getMaterial() == Material.LEAVES) {
                                    this.surroundings[(llllllllllllllIIlIlllIIlIIllIIlI + 16) * 1024 + (llllllllllllllIIlIlllIIlIIllIIII + 16) * 32 + llllllllllllllIIlIlllIIlIIlIllll + 16] = -2;
                                }
                                else {
                                    this.surroundings[(llllllllllllllIIlIlllIIlIIllIIlI + 16) * 1024 + (llllllllllllllIIlIlllIIlIIllIIII + 16) * 32 + llllllllllllllIIlIlllIIlIIlIllll + 16] = -1;
                                }
                            }
                            else {
                                this.surroundings[(llllllllllllllIIlIlllIIlIIllIIlI + 16) * 1024 + (llllllllllllllIIlIlllIIlIIllIIII + 16) * 32 + llllllllllllllIIlIlllIIlIIlIllll + 16] = 0;
                            }
                        }
                    }
                }
                for (int llllllllllllllIIlIlllIIlIIlIllII = 1; llllllllllllllIIlIlllIIlIIlIllII <= 4; ++llllllllllllllIIlIlllIIlIIlIllII) {
                    for (int llllllllllllllIIlIlllIIlIIlIlIll = -4; llllllllllllllIIlIlllIIlIIlIlIll <= 4; ++llllllllllllllIIlIlllIIlIIlIlIll) {
                        for (int llllllllllllllIIlIlllIIlIIlIlIlI = -4; llllllllllllllIIlIlllIIlIIlIlIlI <= 4; ++llllllllllllllIIlIlllIIlIIlIlIlI) {
                            for (int llllllllllllllIIlIlllIIlIIlIlIIl = -4; llllllllllllllIIlIlllIIlIIlIlIIl <= 4; ++llllllllllllllIIlIlllIIlIIlIlIIl) {
                                if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] == llllllllllllllIIlIlllIIlIIlIllII - 1) {
                                    if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16 - 1) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16 - 1) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] = llllllllllllllIIlIlllIIlIIlIllII;
                                    }
                                    if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16 + 1) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16 + 1) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] = llllllllllllllIIlIlllIIlIIlIllII;
                                    }
                                    if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16 - 1) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16 - 1) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] = llllllllllllllIIlIlllIIlIIlIllII;
                                    }
                                    if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16 + 1) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] == -2) {
                                        this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16 + 1) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16] = llllllllllllllIIlIlllIIlIIlIllII;
                                    }
                                    if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + (llllllllllllllIIlIlllIIlIIlIlIIl + 16 - 1)] == -2) {
                                        this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + (llllllllllllllIIlIlllIIlIIlIlIIl + 16 - 1)] = llllllllllllllIIlIlllIIlIIlIllII;
                                    }
                                    if (this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16 + 1] == -2) {
                                        this.surroundings[(llllllllllllllIIlIlllIIlIIlIlIll + 16) * 1024 + (llllllllllllllIIlIlllIIlIIlIlIlI + 16) * 32 + llllllllllllllIIlIlllIIlIIlIlIIl + 16 + 1] = llllllllllllllIIlIlllIIlIIlIllII;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final int llllllllllllllIIlIlllIIlIIlIlIII = this.surroundings[16912];
            if (llllllllllllllIIlIlllIIlIIlIlIII >= 0) {
                llllllllllllllIIlIlllIIlIIlIIllI.setBlockState(llllllllllllllIIlIlllIIlIIlIIlIl, llllllllllllllIIlIlllIIlIlIIIIlI.withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false), 4);
            }
            else {
                this.destroy(llllllllllllllIIlIlllIIlIIlIIllI, llllllllllllllIIlIlllIIlIIlIIlIl);
            }
        }
    }
    
    public void setGraphicsLevel(final boolean llllllllllllllIIlIlllIIIllIIlIlI) {
        this.leavesFancy = llllllllllllllIIlIlllIIIllIIlIlI;
    }
    
    protected int getSaplingDropChance(final IBlockState llllllllllllllIIlIlllIIIllIlIlII) {
        return 20;
    }
}
