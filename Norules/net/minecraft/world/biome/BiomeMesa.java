package net.minecraft.world.biome;

import net.minecraft.block.state.*;
import net.minecraft.world.gen.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;
import java.util.*;

public class BiomeMesa extends Biome
{
    private /* synthetic */ IBlockState[] clayBands;
    protected static final /* synthetic */ IBlockState ORANGE_STAINED_HARDENED_CLAY;
    private /* synthetic */ NoiseGeneratorPerlin pillarNoise;
    private /* synthetic */ NoiseGeneratorPerlin pillarRoofNoise;
    private final /* synthetic */ boolean brycePillars;
    protected static final /* synthetic */ IBlockState RED_SAND;
    private final /* synthetic */ boolean hasForest;
    protected static final /* synthetic */ IBlockState GRASS;
    protected static final /* synthetic */ IBlockState COARSE_DIRT;
    private /* synthetic */ NoiseGeneratorPerlin clayBandsOffsetNoise;
    private /* synthetic */ long worldSeed;
    protected static final /* synthetic */ IBlockState HARDENED_CLAY;
    protected static final /* synthetic */ IBlockState STAINED_HARDENED_CLAY;
    
    static {
        COARSE_DIRT = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        GRASS = Blocks.GRASS.getDefaultState();
        HARDENED_CLAY = Blocks.HARDENED_CLAY.getDefaultState();
        STAINED_HARDENED_CLAY = Blocks.STAINED_HARDENED_CLAY.getDefaultState();
        ORANGE_STAINED_HARDENED_CLAY = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE);
        RED_SAND = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
    }
    
    @Override
    public void genTerrainBlocks(final World llllllllllllllIlIIlIlllllIlllllI, final Random llllllllllllllIlIIlIllllllIllIll, final ChunkPrimer llllllllllllllIlIIlIlllllIllllII, final int llllllllllllllIlIIlIllllllIllIIl, final int llllllllllllllIlIIlIllllllIllIII, final double llllllllllllllIlIIlIlllllIlllIIl) {
        if (this.clayBands == null || this.worldSeed != llllllllllllllIlIIlIlllllIlllllI.getSeed()) {
            this.generateBands(llllllllllllllIlIIlIlllllIlllllI.getSeed());
        }
        if (this.pillarNoise == null || this.pillarRoofNoise == null || this.worldSeed != llllllllllllllIlIIlIlllllIlllllI.getSeed()) {
            final Random llllllllllllllIlIIlIllllllIlIllI = new Random(this.worldSeed);
            this.pillarNoise = new NoiseGeneratorPerlin(llllllllllllllIlIIlIllllllIlIllI, 4);
            this.pillarRoofNoise = new NoiseGeneratorPerlin(llllllllllllllIlIIlIllllllIlIllI, 1);
        }
        this.worldSeed = llllllllllllllIlIIlIlllllIlllllI.getSeed();
        double llllllllllllllIlIIlIllllllIlIlIl = 0.0;
        if (this.brycePillars) {
            final int llllllllllllllIlIIlIllllllIlIlII = (llllllllllllllIlIIlIllllllIllIIl & 0xFFFFFFF0) + (llllllllllllllIlIIlIllllllIllIII & 0xF);
            final int llllllllllllllIlIIlIllllllIlIIll = (llllllllllllllIlIIlIllllllIllIII & 0xFFFFFFF0) + (llllllllllllllIlIIlIllllllIllIIl & 0xF);
            final double llllllllllllllIlIIlIllllllIlIIlI = Math.min(Math.abs(llllllllllllllIlIIlIlllllIlllIIl), this.pillarNoise.getValue(llllllllllllllIlIIlIllllllIlIlII * 0.25, llllllllllllllIlIIlIllllllIlIIll * 0.25));
            if (llllllllllllllIlIIlIllllllIlIIlI > 0.0) {
                final double llllllllllllllIlIIlIllllllIlIIIl = 0.001953125;
                final double llllllllllllllIlIIlIllllllIlIIII = Math.abs(this.pillarRoofNoise.getValue(llllllllllllllIlIIlIllllllIlIlII * 0.001953125, llllllllllllllIlIIlIllllllIlIIll * 0.001953125));
                llllllllllllllIlIIlIllllllIlIlIl = llllllllllllllIlIIlIllllllIlIIlI * llllllllllllllIlIIlIllllllIlIIlI * 2.5;
                final double llllllllllllllIlIIlIllllllIIllll = Math.ceil(llllllllllllllIlIIlIllllllIlIIII * 50.0) + 14.0;
                if (llllllllllllllIlIIlIllllllIlIlIl > llllllllllllllIlIIlIllllllIIllll) {
                    llllllllllllllIlIIlIllllllIlIlIl = llllllllllllllIlIIlIllllllIIllll;
                }
                llllllllllllllIlIIlIllllllIlIlIl += 64.0;
            }
        }
        final int llllllllllllllIlIIlIllllllIIlllI = llllllllllllllIlIIlIllllllIllIIl & 0xF;
        final int llllllllllllllIlIIlIllllllIIllIl = llllllllllllllIlIIlIllllllIllIII & 0xF;
        final int llllllllllllllIlIIlIllllllIIllII = llllllllllllllIlIIlIlllllIlllllI.getSeaLevel();
        IBlockState llllllllllllllIlIIlIllllllIIlIll = BiomeMesa.STAINED_HARDENED_CLAY;
        IBlockState llllllllllllllIlIIlIllllllIIlIlI = this.fillerBlock;
        final int llllllllllllllIlIIlIllllllIIlIIl = (int)(llllllllllllllIlIIlIlllllIlllIIl / 3.0 + 3.0 + llllllllllllllIlIIlIllllllIllIll.nextDouble() * 0.25);
        final boolean llllllllllllllIlIIlIllllllIIlIII = Math.cos(llllllllllllllIlIIlIlllllIlllIIl / 3.0 * 3.141592653589793) > 0.0;
        int llllllllllllllIlIIlIllllllIIIlll = -1;
        boolean llllllllllllllIlIIlIllllllIIIllI = false;
        int llllllllllllllIlIIlIllllllIIIlIl = 0;
        for (int llllllllllllllIlIIlIllllllIIIlII = 255; llllllllllllllIlIIlIllllllIIIlII >= 0; --llllllllllllllIlIIlIllllllIIIlII) {
            if (llllllllllllllIlIIlIlllllIllllII.getBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI).getMaterial() == Material.AIR && llllllllllllllIlIIlIllllllIIIlII < (int)llllllllllllllIlIIlIllllllIlIlIl) {
                llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, BiomeMesa.STONE);
            }
            if (llllllllllllllIlIIlIllllllIIIlII <= llllllllllllllIlIIlIllllllIllIll.nextInt(5)) {
                llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, BiomeMesa.BEDROCK);
            }
            else if (llllllllllllllIlIIlIllllllIIIlIl < 15 || this.brycePillars) {
                final IBlockState llllllllllllllIlIIlIllllllIIIIll = llllllllllllllIlIIlIlllllIllllII.getBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI);
                if (llllllllllllllIlIIlIllllllIIIIll.getMaterial() == Material.AIR) {
                    llllllllllllllIlIIlIllllllIIIlll = -1;
                }
                else if (llllllllllllllIlIIlIllllllIIIIll.getBlock() == Blocks.STONE) {
                    if (llllllllllllllIlIIlIllllllIIIlll == -1) {
                        llllllllllllllIlIIlIllllllIIIllI = false;
                        if (llllllllllllllIlIIlIllllllIIlIIl <= 0) {
                            llllllllllllllIlIIlIllllllIIlIll = BiomeMesa.AIR;
                            llllllllllllllIlIIlIllllllIIlIlI = BiomeMesa.STONE;
                        }
                        else if (llllllllllllllIlIIlIllllllIIIlII >= llllllllllllllIlIIlIllllllIIllII - 4 && llllllllllllllIlIIlIllllllIIIlII <= llllllllllllllIlIIlIllllllIIllII + 1) {
                            llllllllllllllIlIIlIllllllIIlIll = BiomeMesa.STAINED_HARDENED_CLAY;
                            llllllllllllllIlIIlIllllllIIlIlI = this.fillerBlock;
                        }
                        if (llllllllllllllIlIIlIllllllIIIlII < llllllllllllllIlIIlIllllllIIllII && (llllllllllllllIlIIlIllllllIIlIll == null || llllllllllllllIlIIlIllllllIIlIll.getMaterial() == Material.AIR)) {
                            llllllllllllllIlIIlIllllllIIlIll = BiomeMesa.WATER;
                        }
                        llllllllllllllIlIIlIllllllIIIlll = llllllllllllllIlIIlIllllllIIlIIl + Math.max(0, llllllllllllllIlIIlIllllllIIIlII - llllllllllllllIlIIlIllllllIIllII);
                        if (llllllllllllllIlIIlIllllllIIIlII >= llllllllllllllIlIIlIllllllIIllII - 1) {
                            if (this.hasForest && llllllllllllllIlIIlIllllllIIIlII > 86 + llllllllllllllIlIIlIllllllIIlIIl * 2) {
                                if (llllllllllllllIlIIlIllllllIIlIII) {
                                    llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, BiomeMesa.COARSE_DIRT);
                                }
                                else {
                                    llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, BiomeMesa.GRASS);
                                }
                            }
                            else if (llllllllllllllIlIIlIllllllIIIlII > llllllllllllllIlIIlIllllllIIllII + 3 + llllllllllllllIlIIlIllllllIIlIIl) {
                                IBlockState llllllllllllllIlIIlIllllllIIIIII = null;
                                if (llllllllllllllIlIIlIllllllIIIlII >= 64 && llllllllllllllIlIIlIllllllIIIlII <= 127) {
                                    if (llllllllllllllIlIIlIllllllIIlIII) {
                                        final IBlockState llllllllllllllIlIIlIllllllIIIIlI = BiomeMesa.HARDENED_CLAY;
                                    }
                                    else {
                                        final IBlockState llllllllllllllIlIIlIllllllIIIIIl = this.getBand(llllllllllllllIlIIlIllllllIllIIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIllIII);
                                    }
                                }
                                else {
                                    llllllllllllllIlIIlIllllllIIIIII = BiomeMesa.ORANGE_STAINED_HARDENED_CLAY;
                                }
                                llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, llllllllllllllIlIIlIllllllIIIIII);
                            }
                            else {
                                llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, this.topBlock);
                                llllllllllllllIlIIlIllllllIIIllI = true;
                            }
                        }
                        else {
                            llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, llllllllllllllIlIIlIllllllIIlIlI);
                            if (llllllllllllllIlIIlIllllllIIlIlI.getBlock() == Blocks.STAINED_HARDENED_CLAY) {
                                llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, BiomeMesa.ORANGE_STAINED_HARDENED_CLAY);
                            }
                        }
                    }
                    else if (llllllllllllllIlIIlIllllllIIIlll > 0) {
                        --llllllllllllllIlIIlIllllllIIIlll;
                        if (llllllllllllllIlIIlIllllllIIIllI) {
                            llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, BiomeMesa.ORANGE_STAINED_HARDENED_CLAY);
                        }
                        else {
                            llllllllllllllIlIIlIlllllIllllII.setBlockState(llllllllllllllIlIIlIllllllIIllIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIIlllI, this.getBand(llllllllllllllIlIIlIllllllIllIIl, llllllllllllllIlIIlIllllllIIIlII, llllllllllllllIlIIlIllllllIllIII));
                        }
                    }
                    ++llllllllllllllIlIIlIllllllIIIlIl;
                }
            }
        }
    }
    
    public BiomeMesa(final boolean llllllllllllllIlIIllIIIIIIIIIIlI, final boolean llllllllllllllIlIIlIllllllllllIl, final BiomeProperties llllllllllllllIlIIllIIIIIIIIIIII) {
        super(llllllllllllllIlIIllIIIIIIIIIIII);
        this.brycePillars = llllllllllllllIlIIllIIIIIIIIIIlI;
        this.hasForest = llllllllllllllIlIIlIllllllllllIl;
        this.spawnableCreatureList.clear();
        this.topBlock = BiomeMesa.RED_SAND;
        this.fillerBlock = BiomeMesa.STAINED_HARDENED_CLAY;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 20;
        this.theBiomeDecorator.reedsPerChunk = 3;
        this.theBiomeDecorator.cactiPerChunk = 5;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.spawnableCreatureList.clear();
        if (llllllllllllllIlIIlIllllllllllIl) {
            this.theBiomeDecorator.treesPerChunk = 5;
        }
    }
    
    @Override
    protected BiomeDecorator createBiomeDecorator() {
        return new Decorator((Decorator)null);
    }
    
    @Override
    public int getGrassColorAtPos(final BlockPos llllllllllllllIlIIlIllllllllIIll) {
        return 9470285;
    }
    
    @Override
    public WorldGenAbstractTree genBigTreeChance(final Random llllllllllllllIlIIlIllllllllIlll) {
        return BiomeMesa.TREE_FEATURE;
    }
    
    @Override
    public int getFoliageColorAtPos(final BlockPos llllllllllllllIlIIlIllllllllIlIl) {
        return 10387789;
    }
    
    private void generateBands(final long llllllllllllllIlIIlIlllllIIIIllI) {
        this.clayBands = new IBlockState[64];
        Arrays.fill(this.clayBands, BiomeMesa.HARDENED_CLAY);
        final Random llllllllllllllIlIIlIlllllIIlllIl = new Random(llllllllllllllIlIIlIlllllIIIIllI);
        this.clayBandsOffsetNoise = new NoiseGeneratorPerlin(llllllllllllllIlIIlIlllllIIlllIl, 1);
        for (int llllllllllllllIlIIlIlllllIIlllII = 0; llllllllllllllIlIIlIlllllIIlllII < 64; ++llllllllllllllIlIIlIlllllIIlllII) {
            llllllllllllllIlIIlIlllllIIlllII += llllllllllllllIlIIlIlllllIIlllIl.nextInt(5) + 1;
            if (llllllllllllllIlIIlIlllllIIlllII < 64) {
                this.clayBands[llllllllllllllIlIIlIlllllIIlllII] = BiomeMesa.ORANGE_STAINED_HARDENED_CLAY;
            }
        }
        for (int llllllllllllllIlIIlIlllllIIllIll = llllllllllllllIlIIlIlllllIIlllIl.nextInt(4) + 2, llllllllllllllIlIIlIlllllIIllIlI = 0; llllllllllllllIlIIlIlllllIIllIlI < llllllllllllllIlIIlIlllllIIllIll; ++llllllllllllllIlIIlIlllllIIllIlI) {
            for (int llllllllllllllIlIIlIlllllIIllIIl = llllllllllllllIlIIlIlllllIIlllIl.nextInt(3) + 1, llllllllllllllIlIIlIlllllIIllIII = llllllllllllllIlIIlIlllllIIlllIl.nextInt(64), llllllllllllllIlIIlIlllllIIlIlll = 0; llllllllllllllIlIIlIlllllIIllIII + llllllllllllllIlIIlIlllllIIlIlll < 64 && llllllllllllllIlIIlIlllllIIlIlll < llllllllllllllIlIIlIlllllIIllIIl; ++llllllllllllllIlIIlIlllllIIlIlll) {
                this.clayBands[llllllllllllllIlIIlIlllllIIllIII + llllllllllllllIlIIlIlllllIIlIlll] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.YELLOW);
            }
        }
        for (int llllllllllllllIlIIlIlllllIIlIllI = llllllllllllllIlIIlIlllllIIlllIl.nextInt(4) + 2, llllllllllllllIlIIlIlllllIIlIlIl = 0; llllllllllllllIlIIlIlllllIIlIlIl < llllllllllllllIlIIlIlllllIIlIllI; ++llllllllllllllIlIIlIlllllIIlIlIl) {
            for (int llllllllllllllIlIIlIlllllIIlIlII = llllllllllllllIlIIlIlllllIIlllIl.nextInt(3) + 2, llllllllllllllIlIIlIlllllIIlIIll = llllllllllllllIlIIlIlllllIIlllIl.nextInt(64), llllllllllllllIlIIlIlllllIIlIIlI = 0; llllllllllllllIlIIlIlllllIIlIIll + llllllllllllllIlIIlIlllllIIlIIlI < 64 && llllllllllllllIlIIlIlllllIIlIIlI < llllllllllllllIlIIlIlllllIIlIlII; ++llllllllllllllIlIIlIlllllIIlIIlI) {
                this.clayBands[llllllllllllllIlIIlIlllllIIlIIll + llllllllllllllIlIIlIlllllIIlIIlI] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.BROWN);
            }
        }
        for (int llllllllllllllIlIIlIlllllIIlIIIl = llllllllllllllIlIIlIlllllIIlllIl.nextInt(4) + 2, llllllllllllllIlIIlIlllllIIlIIII = 0; llllllllllllllIlIIlIlllllIIlIIII < llllllllllllllIlIIlIlllllIIlIIIl; ++llllllllllllllIlIIlIlllllIIlIIII) {
            for (int llllllllllllllIlIIlIlllllIIIllll = llllllllllllllIlIIlIlllllIIlllIl.nextInt(3) + 1, llllllllllllllIlIIlIlllllIIIlllI = llllllllllllllIlIIlIlllllIIlllIl.nextInt(64), llllllllllllllIlIIlIlllllIIIllIl = 0; llllllllllllllIlIIlIlllllIIIlllI + llllllllllllllIlIIlIlllllIIIllIl < 64 && llllllllllllllIlIIlIlllllIIIllIl < llllllllllllllIlIIlIlllllIIIllll; ++llllllllllllllIlIIlIlllllIIIllIl) {
                this.clayBands[llllllllllllllIlIIlIlllllIIIlllI + llllllllllllllIlIIlIlllllIIIllIl] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.RED);
            }
        }
        final int llllllllllllllIlIIlIlllllIIIllII = llllllllllllllIlIIlIlllllIIlllIl.nextInt(3) + 3;
        int llllllllllllllIlIIlIlllllIIIlIll = 0;
        for (int llllllllllllllIlIIlIlllllIIIlIlI = 0; llllllllllllllIlIIlIlllllIIIlIlI < llllllllllllllIlIIlIlllllIIIllII; ++llllllllllllllIlIIlIlllllIIIlIlI) {
            final int llllllllllllllIlIIlIlllllIIIlIIl = 1;
            llllllllllllllIlIIlIlllllIIIlIll += llllllllllllllIlIIlIlllllIIlllIl.nextInt(16) + 4;
            for (int llllllllllllllIlIIlIlllllIIIlIII = 0; llllllllllllllIlIIlIlllllIIIlIll + llllllllllllllIlIIlIlllllIIIlIII < 64 && llllllllllllllIlIIlIlllllIIIlIII < 1; ++llllllllllllllIlIIlIlllllIIIlIII) {
                this.clayBands[llllllllllllllIlIIlIlllllIIIlIll + llllllllllllllIlIIlIlllllIIIlIII] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.WHITE);
                if (llllllllllllllIlIIlIlllllIIIlIll + llllllllllllllIlIIlIlllllIIIlIII > 1 && llllllllllllllIlIIlIlllllIIlllIl.nextBoolean()) {
                    this.clayBands[llllllllllllllIlIIlIlllllIIIlIll + llllllllllllllIlIIlIlllllIIIlIII - 1] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
                if (llllllllllllllIlIIlIlllllIIIlIll + llllllllllllllIlIIlIlllllIIIlIII < 63 && llllllllllllllIlIIlIlllllIIlllIl.nextBoolean()) {
                    this.clayBands[llllllllllllllIlIIlIlllllIIIlIll + llllllllllllllIlIIlIlllllIIIlIII + 1] = BiomeMesa.STAINED_HARDENED_CLAY.withProperty(BlockColored.COLOR, EnumDyeColor.SILVER);
                }
            }
        }
    }
    
    private IBlockState getBand(final int llllllllllllllIlIIlIllllIlllIIlI, final int llllllllllllllIlIIlIllllIlllIIIl, final int llllllllllllllIlIIlIllllIlllIlIl) {
        final int llllllllllllllIlIIlIllllIlllIlII = (int)Math.round(this.clayBandsOffsetNoise.getValue(llllllllllllllIlIIlIllllIlllIIlI / 512.0, llllllllllllllIlIIlIllllIlllIIlI / 512.0) * 2.0);
        return this.clayBands[(llllllllllllllIlIIlIllllIlllIIIl + llllllllllllllIlIIlIllllIlllIlII + 64) % 64];
    }
    
    class Decorator extends BiomeDecorator
    {
        @Override
        protected void generateOres(final World lllllllllllllIIlIIllIlllIIllIlIl, final Random lllllllllllllIIlIIllIlllIIllIlII) {
            super.generateOres(lllllllllllllIIlIIllIlllIIllIlIl, lllllllllllllIIlIIllIlllIIllIlII);
            this.genStandardOre1(lllllllllllllIIlIIllIlllIIllIlIl, lllllllllllllIIlIIllIlllIIllIlII, 20, this.goldGen, 32, 80);
        }
        
        private Decorator() {
        }
    }
}
