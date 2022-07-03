package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class WorldGenBigTree extends WorldGenAbstractTree
{
    private /* synthetic */ Random rand;
    private /* synthetic */ World world;
    /* synthetic */ double branchSlope;
    /* synthetic */ List<FoliageCoordinates> foliageCoords;
    /* synthetic */ double heightAttenuation;
    private /* synthetic */ BlockPos basePos;
    /* synthetic */ double leafDensity;
    /* synthetic */ double scaleWidth;
    /* synthetic */ int heightLimitLimit;
    /* synthetic */ int height;
    /* synthetic */ int heightLimit;
    /* synthetic */ int trunkSize;
    /* synthetic */ int leafDistanceLimit;
    
    boolean leafNodeNeedsBase(final int lllllllllllllIlllIllllIlIllllIIl) {
        return lllllllllllllIlllIllllIlIllllIIl >= this.heightLimit * 0.2;
    }
    
    void generateLeafNodeList() {
        this.height = (int)(this.heightLimit * this.heightAttenuation);
        if (this.height >= this.heightLimit) {
            this.height = this.heightLimit - 1;
        }
        int lllllllllllllIlllIlllllIIIlIIIlI = (int)(1.382 + Math.pow(this.leafDensity * this.heightLimit / 13.0, 2.0));
        if (lllllllllllllIlllIlllllIIIlIIIlI < 1) {
            lllllllllllllIlllIlllllIIIlIIIlI = 1;
        }
        final int lllllllllllllIlllIlllllIIIlIIIIl = this.basePos.getY() + this.height;
        int lllllllllllllIlllIlllllIIIlIIIII = this.heightLimit - this.leafDistanceLimit;
        this.foliageCoords = (List<FoliageCoordinates>)Lists.newArrayList();
        this.foliageCoords.add(new FoliageCoordinates(this.basePos.up(lllllllllllllIlllIlllllIIIlIIIII), lllllllllllllIlllIlllllIIIlIIIIl));
        while (lllllllllllllIlllIlllllIIIlIIIII >= 0) {
            final float lllllllllllllIlllIlllllIIIIlllll = this.layerSize(lllllllllllllIlllIlllllIIIlIIIII);
            if (lllllllllllllIlllIlllllIIIIlllll >= 0.0f) {
                for (int lllllllllllllIlllIlllllIIIIllllI = 0; lllllllllllllIlllIlllllIIIIllllI < lllllllllllllIlllIlllllIIIlIIIlI; ++lllllllllllllIlllIlllllIIIIllllI) {
                    final double lllllllllllllIlllIlllllIIIIlllIl = this.scaleWidth * lllllllllllllIlllIlllllIIIIlllll * (this.rand.nextFloat() + 0.328);
                    final double lllllllllllllIlllIlllllIIIIlllII = this.rand.nextFloat() * 2.0f * 3.141592653589793;
                    final double lllllllllllllIlllIlllllIIIIllIll = lllllllllllllIlllIlllllIIIIlllIl * Math.sin(lllllllllllllIlllIlllllIIIIlllII) + 0.5;
                    final double lllllllllllllIlllIlllllIIIIllIlI = lllllllllllllIlllIlllllIIIIlllIl * Math.cos(lllllllllllllIlllIlllllIIIIlllII) + 0.5;
                    final BlockPos lllllllllllllIlllIlllllIIIIllIIl = this.basePos.add(lllllllllllllIlllIlllllIIIIllIll, lllllllllllllIlllIlllllIIIlIIIII - 1, lllllllllllllIlllIlllllIIIIllIlI);
                    final BlockPos lllllllllllllIlllIlllllIIIIllIII = lllllllllllllIlllIlllllIIIIllIIl.up(this.leafDistanceLimit);
                    if (this.checkBlockLine(lllllllllllllIlllIlllllIIIIllIIl, lllllllllllllIlllIlllllIIIIllIII) == -1) {
                        final int lllllllllllllIlllIlllllIIIIlIlll = this.basePos.getX() - lllllllllllllIlllIlllllIIIIllIIl.getX();
                        final int lllllllllllllIlllIlllllIIIIlIllI = this.basePos.getZ() - lllllllllllllIlllIlllllIIIIllIIl.getZ();
                        final double lllllllllllllIlllIlllllIIIIlIlIl = lllllllllllllIlllIlllllIIIIllIIl.getY() - Math.sqrt(lllllllllllllIlllIlllllIIIIlIlll * lllllllllllllIlllIlllllIIIIlIlll + lllllllllllllIlllIlllllIIIIlIllI * lllllllllllllIlllIlllllIIIIlIllI) * this.branchSlope;
                        final int lllllllllllllIlllIlllllIIIIlIlII = (lllllllllllllIlllIlllllIIIIlIlIl > lllllllllllllIlllIlllllIIIlIIIIl) ? lllllllllllllIlllIlllllIIIlIIIIl : ((int)lllllllllllllIlllIlllllIIIIlIlIl);
                        final BlockPos lllllllllllllIlllIlllllIIIIlIIll = new BlockPos(this.basePos.getX(), lllllllllllllIlllIlllllIIIIlIlII, this.basePos.getZ());
                        if (this.checkBlockLine(lllllllllllllIlllIlllllIIIIlIIll, lllllllllllllIlllIlllllIIIIllIIl) == -1) {
                            this.foliageCoords.add(new FoliageCoordinates(lllllllllllllIlllIlllllIIIIllIIl, lllllllllllllIlllIlllllIIIIlIIll.getY()));
                        }
                    }
                }
            }
            --lllllllllllllIlllIlllllIIIlIIIII;
        }
    }
    
    private int getGreatestDistance(final BlockPos lllllllllllllIlllIllllIllIIllIll) {
        final int lllllllllllllIlllIllllIllIIllllI = MathHelper.abs(lllllllllllllIlllIllllIllIIllIll.getX());
        final int lllllllllllllIlllIllllIllIIlllIl = MathHelper.abs(lllllllllllllIlllIllllIllIIllIll.getY());
        final int lllllllllllllIlllIllllIllIIlllII = MathHelper.abs(lllllllllllllIlllIllllIllIIllIll.getZ());
        if (lllllllllllllIlllIllllIllIIlllII > lllllllllllllIlllIllllIllIIllllI && lllllllllllllIlllIllllIllIIlllII > lllllllllllllIlllIllllIllIIlllIl) {
            return lllllllllllllIlllIllllIllIIlllII;
        }
        return (lllllllllllllIlllIllllIllIIlllIl > lllllllllllllIlllIllllIllIIllllI) ? lllllllllllllIlllIllllIllIIlllIl : lllllllllllllIlllIllllIllIIllllI;
    }
    
    void generateLeaves() {
        for (final FoliageCoordinates lllllllllllllIlllIllllIllIIIIIII : this.foliageCoords) {
            this.generateLeafNode(lllllllllllllIlllIllllIllIIIIIII);
        }
    }
    
    float layerSize(final int lllllllllllllIlllIllllIlllIllIll) {
        if (lllllllllllllIlllIllllIlllIllIll < this.heightLimit * 0.3f) {
            return -1.0f;
        }
        final float lllllllllllllIlllIllllIlllIlllll = this.heightLimit / 2.0f;
        final float lllllllllllllIlllIllllIlllIllllI = lllllllllllllIlllIllllIlllIlllll - lllllllllllllIlllIllllIlllIllIll;
        float lllllllllllllIlllIllllIlllIlllIl = MathHelper.sqrt(lllllllllllllIlllIllllIlllIlllll * lllllllllllllIlllIllllIlllIlllll - lllllllllllllIlllIllllIlllIllllI * lllllllllllllIlllIllllIlllIllllI);
        if (lllllllllllllIlllIllllIlllIllllI == 0.0f) {
            lllllllllllllIlllIllllIlllIlllIl = lllllllllllllIlllIllllIlllIlllll;
        }
        else if (Math.abs(lllllllllllllIlllIllllIlllIllllI) >= lllllllllllllIlllIllllIlllIlllll) {
            return 0.0f;
        }
        return lllllllllllllIlllIllllIlllIlllIl * 0.5f;
    }
    
    private boolean validTreeLocation() {
        final Block lllllllllllllIlllIllllIlIIlIlIll = this.world.getBlockState(this.basePos.down()).getBlock();
        if (lllllllllllllIlllIllllIlIIlIlIll != Blocks.DIRT && lllllllllllllIlllIllllIlIIlIlIll != Blocks.GRASS && lllllllllllllIlllIllllIlIIlIlIll != Blocks.FARMLAND) {
            return false;
        }
        final int lllllllllllllIlllIllllIlIIlIlIlI = this.checkBlockLine(this.basePos, this.basePos.up(this.heightLimit - 1));
        if (lllllllllllllIlllIllllIlIIlIlIlI == -1) {
            return true;
        }
        if (lllllllllllllIlllIllllIlIIlIlIlI < 6) {
            return false;
        }
        this.heightLimit = lllllllllllllIlllIllllIlIIlIlIlI;
        return true;
    }
    
    float leafSize(final int lllllllllllllIlllIllllIlllIlIlII) {
        if (lllllllllllllIlllIllllIlllIlIlII >= 0 && lllllllllllllIlllIllllIlllIlIlII < this.leafDistanceLimit) {
            return (lllllllllllllIlllIllllIlllIlIlII != 0 && lllllllllllllIlllIllllIlllIlIlII != this.leafDistanceLimit - 1) ? 3.0f : 2.0f;
        }
        return -1.0f;
    }
    
    public WorldGenBigTree(final boolean lllllllllllllIlllIlllllIIIllIlIl) {
        super(lllllllllllllIlllIlllllIIIllIlIl);
        this.basePos = BlockPos.ORIGIN;
        this.heightAttenuation = 0.618;
        this.branchSlope = 0.381;
        this.scaleWidth = 1.0;
        this.leafDensity = 1.0;
        this.trunkSize = 1;
        this.heightLimitLimit = 12;
        this.leafDistanceLimit = 4;
    }
    
    void generateLeafNode(final BlockPos lllllllllllllIlllIllllIlllIIlIlI) {
        for (int lllllllllllllIlllIllllIlllIIllII = 0; lllllllllllllIlllIllllIlllIIllII < this.leafDistanceLimit; ++lllllllllllllIlllIllllIlllIIllII) {
            this.crosSection(lllllllllllllIlllIllllIlllIIlIlI.up(lllllllllllllIlllIllllIlllIIllII), this.leafSize(lllllllllllllIlllIllllIlllIIllII), Blocks.LEAVES.getDefaultState().withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false));
        }
    }
    
    void generateTrunk() {
        final BlockPos lllllllllllllIlllIllllIlIlllIIIl = this.basePos;
        final BlockPos lllllllllllllIlllIllllIlIlllIIII = this.basePos.up(this.height);
        final Block lllllllllllllIlllIllllIlIllIllll = Blocks.LOG;
        this.limb(lllllllllllllIlllIllllIlIlllIIIl, lllllllllllllIlllIllllIlIlllIIII, lllllllllllllIlllIllllIlIllIllll);
        if (this.trunkSize == 2) {
            this.limb(lllllllllllllIlllIllllIlIlllIIIl.east(), lllllllllllllIlllIllllIlIlllIIII.east(), lllllllllllllIlllIllllIlIllIllll);
            this.limb(lllllllllllllIlllIllllIlIlllIIIl.east().south(), lllllllllllllIlllIllllIlIlllIIII.east().south(), lllllllllllllIlllIllllIlIllIllll);
            this.limb(lllllllllllllIlllIllllIlIlllIIIl.south(), lllllllllllllIlllIllllIlIlllIIII.south(), lllllllllllllIlllIllllIlIllIllll);
        }
    }
    
    @Override
    public boolean generate(final World lllllllllllllIlllIllllIlIIllIIlI, final Random lllllllllllllIlllIllllIlIIllIIIl, final BlockPos lllllllllllllIlllIllllIlIIllIIII) {
        this.world = lllllllllllllIlllIllllIlIIllIIlI;
        this.basePos = lllllllllllllIlllIllllIlIIllIIII;
        this.rand = new Random(lllllllllllllIlllIllllIlIIllIIIl.nextLong());
        if (this.heightLimit == 0) {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }
        if (!this.validTreeLocation()) {
            return false;
        }
        this.generateLeafNodeList();
        this.generateLeaves();
        this.generateTrunk();
        this.generateLeafNodeBases();
        return true;
    }
    
    private BlockLog.EnumAxis getLogAxis(final BlockPos lllllllllllllIlllIllllIllIIlIIII, final BlockPos lllllllllllllIlllIllllIllIIIlIIl) {
        BlockLog.EnumAxis lllllllllllllIlllIllllIllIIIlllI = BlockLog.EnumAxis.Y;
        final int lllllllllllllIlllIllllIllIIIllIl = Math.abs(lllllllllllllIlllIllllIllIIIlIIl.getX() - lllllllllllllIlllIllllIllIIlIIII.getX());
        final int lllllllllllllIlllIllllIllIIIllII = Math.abs(lllllllllllllIlllIllllIllIIIlIIl.getZ() - lllllllllllllIlllIllllIllIIlIIII.getZ());
        final int lllllllllllllIlllIllllIllIIIlIll = Math.max(lllllllllllllIlllIllllIllIIIllIl, lllllllllllllIlllIllllIllIIIllII);
        if (lllllllllllllIlllIllllIllIIIlIll > 0) {
            if (lllllllllllllIlllIllllIllIIIllIl == lllllllllllllIlllIllllIllIIIlIll) {
                lllllllllllllIlllIllllIllIIIlllI = BlockLog.EnumAxis.X;
            }
            else if (lllllllllllllIlllIllllIllIIIllII == lllllllllllllIlllIllllIllIIIlIll) {
                lllllllllllllIlllIllllIllIIIlllI = BlockLog.EnumAxis.Z;
            }
        }
        return lllllllllllllIlllIllllIllIIIlllI;
    }
    
    int checkBlockLine(final BlockPos lllllllllllllIlllIllllIlIlIIIlll, final BlockPos lllllllllllllIlllIllllIlIlIIIllI) {
        final BlockPos lllllllllllllIlllIllllIlIlIIllll = lllllllllllllIlllIllllIlIlIIIllI.add(-lllllllllllllIlllIllllIlIlIIIlll.getX(), -lllllllllllllIlllIllllIlIlIIIlll.getY(), -lllllllllllllIlllIllllIlIlIIIlll.getZ());
        final int lllllllllllllIlllIllllIlIlIIlllI = this.getGreatestDistance(lllllllllllllIlllIllllIlIlIIllll);
        final float lllllllllllllIlllIllllIlIlIIllIl = lllllllllllllIlllIllllIlIlIIllll.getX() / (float)lllllllllllllIlllIllllIlIlIIlllI;
        final float lllllllllllllIlllIllllIlIlIIllII = lllllllllllllIlllIllllIlIlIIllll.getY() / (float)lllllllllllllIlllIllllIlIlIIlllI;
        final float lllllllllllllIlllIllllIlIlIIlIll = lllllllllllllIlllIllllIlIlIIllll.getZ() / (float)lllllllllllllIlllIllllIlIlIIlllI;
        if (lllllllllllllIlllIllllIlIlIIlllI == 0) {
            return -1;
        }
        for (int lllllllllllllIlllIllllIlIlIIlIlI = 0; lllllllllllllIlllIllllIlIlIIlIlI <= lllllllllllllIlllIllllIlIlIIlllI; ++lllllllllllllIlllIllllIlIlIIlIlI) {
            final BlockPos lllllllllllllIlllIllllIlIlIIlIIl = lllllllllllllIlllIllllIlIlIIIlll.add(0.5f + lllllllllllllIlllIllllIlIlIIlIlI * lllllllllllllIlllIllllIlIlIIllIl, 0.5f + lllllllllllllIlllIllllIlIlIIlIlI * lllllllllllllIlllIllllIlIlIIllII, 0.5f + lllllllllllllIlllIllllIlIlIIlIlI * lllllllllllllIlllIllllIlIlIIlIll);
            if (!this.canGrowInto(this.world.getBlockState(lllllllllllllIlllIllllIlIlIIlIIl).getBlock())) {
                return lllllllllllllIlllIllllIlIlIIlIlI;
            }
        }
        return -1;
    }
    
    @Override
    public void setDecorationDefaults() {
        this.leafDistanceLimit = 5;
    }
    
    void limb(final BlockPos lllllllllllllIlllIllllIllIlllIll, final BlockPos lllllllllllllIlllIllllIllIlllIlI, final Block lllllllllllllIlllIllllIllIlIllIl) {
        final BlockPos lllllllllllllIlllIllllIllIlllIII = lllllllllllllIlllIllllIllIlllIlI.add(-lllllllllllllIlllIllllIllIlllIll.getX(), -lllllllllllllIlllIllllIllIlllIll.getY(), -lllllllllllllIlllIllllIllIlllIll.getZ());
        final int lllllllllllllIlllIllllIllIllIlll = this.getGreatestDistance(lllllllllllllIlllIllllIllIlllIII);
        final float lllllllllllllIlllIllllIllIllIllI = lllllllllllllIlllIllllIllIlllIII.getX() / (float)lllllllllllllIlllIllllIllIllIlll;
        final float lllllllllllllIlllIllllIllIllIlIl = lllllllllllllIlllIllllIllIlllIII.getY() / (float)lllllllllllllIlllIllllIllIllIlll;
        final float lllllllllllllIlllIllllIllIllIlII = lllllllllllllIlllIllllIllIlllIII.getZ() / (float)lllllllllllllIlllIllllIllIllIlll;
        for (int lllllllllllllIlllIllllIllIllIIll = 0; lllllllllllllIlllIllllIllIllIIll <= lllllllllllllIlllIllllIllIllIlll; ++lllllllllllllIlllIllllIllIllIIll) {
            final BlockPos lllllllllllllIlllIllllIllIllIIlI = lllllllllllllIlllIllllIllIlllIll.add(0.5f + lllllllllllllIlllIllllIllIllIIll * lllllllllllllIlllIllllIllIllIllI, 0.5f + lllllllllllllIlllIllllIllIllIIll * lllllllllllllIlllIllllIllIllIlIl, 0.5f + lllllllllllllIlllIllllIllIllIIll * lllllllllllllIlllIllllIllIllIlII);
            final BlockLog.EnumAxis lllllllllllllIlllIllllIllIllIIIl = this.getLogAxis(lllllllllllllIlllIllllIllIlllIll, lllllllllllllIlllIllllIllIllIIlI);
            this.setBlockAndNotifyAdequately(this.world, lllllllllllllIlllIllllIllIllIIlI, lllllllllllllIlllIllllIllIlIllIl.getDefaultState().withProperty(BlockLog.LOG_AXIS, lllllllllllllIlllIllllIllIllIIIl));
        }
    }
    
    void crosSection(final BlockPos lllllllllllllIlllIllllIllllIlllI, final float lllllllllllllIlllIllllIllllIllIl, final IBlockState lllllllllllllIlllIllllIlllllIlIl) {
        for (int lllllllllllllIlllIllllIlllllIlII = (int)(lllllllllllllIlllIllllIllllIllIl + 0.618), lllllllllllllIlllIllllIlllllIIll = -lllllllllllllIlllIllllIlllllIlII; lllllllllllllIlllIllllIlllllIIll <= lllllllllllllIlllIllllIlllllIlII; ++lllllllllllllIlllIllllIlllllIIll) {
            for (int lllllllllllllIlllIllllIlllllIIlI = -lllllllllllllIlllIllllIlllllIlII; lllllllllllllIlllIllllIlllllIIlI <= lllllllllllllIlllIllllIlllllIlII; ++lllllllllllllIlllIllllIlllllIIlI) {
                if (Math.pow(Math.abs(lllllllllllllIlllIllllIlllllIIll) + 0.5, 2.0) + Math.pow(Math.abs(lllllllllllllIlllIllllIlllllIIlI) + 0.5, 2.0) <= lllllllllllllIlllIllllIllllIllIl * lllllllllllllIlllIllllIllllIllIl) {
                    final BlockPos lllllllllllllIlllIllllIlllllIIIl = lllllllllllllIlllIllllIllllIlllI.add(lllllllllllllIlllIllllIlllllIIll, 0, lllllllllllllIlllIllllIlllllIIlI);
                    final Material lllllllllllllIlllIllllIlllllIIII = this.world.getBlockState(lllllllllllllIlllIllllIlllllIIIl).getMaterial();
                    if (lllllllllllllIlllIllllIlllllIIII == Material.AIR || lllllllllllllIlllIllllIlllllIIII == Material.LEAVES) {
                        this.setBlockAndNotifyAdequately(this.world, lllllllllllllIlllIllllIlllllIIIl, lllllllllllllIlllIllllIlllllIlIl);
                    }
                }
            }
        }
    }
    
    void generateLeafNodeBases() {
        for (final FoliageCoordinates lllllllllllllIlllIllllIlIllIIlII : this.foliageCoords) {
            final int lllllllllllllIlllIllllIlIllIIIll = lllllllllllllIlllIllllIlIllIIlII.getBranchBase();
            final BlockPos lllllllllllllIlllIllllIlIllIIIlI = new BlockPos(this.basePos.getX(), lllllllllllllIlllIllllIlIllIIIll, this.basePos.getZ());
            if (!lllllllllllllIlllIllllIlIllIIIlI.equals(lllllllllllllIlllIllllIlIllIIlII) && this.leafNodeNeedsBase(lllllllllllllIlllIllllIlIllIIIll - this.basePos.getY())) {
                this.limb(lllllllllllllIlllIllllIlIllIIIlI, lllllllllllllIlllIllllIlIllIIlII, Blocks.LOG);
            }
        }
    }
    
    static class FoliageCoordinates extends BlockPos
    {
        private final /* synthetic */ int branchBase;
        
        public int getBranchBase() {
            return this.branchBase;
        }
        
        public FoliageCoordinates(final BlockPos lllllllllllllIIIlIllIIIlIIIllIIl, final int lllllllllllllIIIlIllIIIlIIIllIll) {
            super(lllllllllllllIIIlIllIIIlIIIllIIl.getX(), lllllllllllllIIIlIllIIIlIIIllIIl.getY(), lllllllllllllIIIlIllIIIlIIIllIIl.getZ());
            this.branchBase = lllllllllllllIIIlIllIIIlIIIllIll;
        }
    }
}
