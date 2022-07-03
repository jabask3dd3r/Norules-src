package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.world.gen.feature.*;
import com.google.common.base.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class ChunkGeneratorHell implements IChunkGenerator
{
    private final /* synthetic */ WorldGenBush redMushroomFeature;
    /* synthetic */ double[] br;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise2;
    private final /* synthetic */ WorldGenGlowStone2 hellPortalGen;
    protected static final /* synthetic */ IBlockState BEDROCK;
    public final /* synthetic */ NoiseGeneratorOctaves scaleNoise;
    private final /* synthetic */ WorldGenerator quartzGen;
    private final /* synthetic */ NoiseGeneratorOctaves slowsandGravelNoiseGen;
    protected static final /* synthetic */ IBlockState SOUL_SAND;
    private final /* synthetic */ NoiseGeneratorOctaves perlinNoise1;
    /* synthetic */ double[] ar;
    protected static final /* synthetic */ IBlockState GRAVEL;
    protected static final /* synthetic */ IBlockState NETHERRACK;
    private /* synthetic */ double[] slowsandNoise;
    private final /* synthetic */ World world;
    private final /* synthetic */ WorldGenGlowStone1 lightGemGen;
    private final /* synthetic */ MapGenBase genNetherCaves;
    private final /* synthetic */ WorldGenBush brownMushroomFeature;
    protected static final /* synthetic */ IBlockState AIR;
    private final /* synthetic */ WorldGenHellLava hellSpringGen;
    private final /* synthetic */ Random rand;
    private /* synthetic */ double[] buffer;
    private /* synthetic */ double[] gravelNoise;
    /* synthetic */ double[] dr;
    private /* synthetic */ double[] depthBuffer;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise1;
    private final /* synthetic */ MapGenNetherBridge genNetherBridge;
    private final /* synthetic */ WorldGenerator magmaGen;
    private final /* synthetic */ WorldGenHellLava lavaTrapGen;
    private final /* synthetic */ NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
    private final /* synthetic */ boolean generateStructures;
    private final /* synthetic */ WorldGenFire fireFeature;
    public final /* synthetic */ NoiseGeneratorOctaves depthNoise;
    /* synthetic */ double[] noiseData4;
    /* synthetic */ double[] pnr;
    protected static final /* synthetic */ IBlockState LAVA;
    
    static {
        AIR = Blocks.AIR.getDefaultState();
        NETHERRACK = Blocks.NETHERRACK.getDefaultState();
        BEDROCK = Blocks.BEDROCK.getDefaultState();
        LAVA = Blocks.LAVA.getDefaultState();
        GRAVEL = Blocks.GRAVEL.getDefaultState();
        SOUL_SAND = Blocks.SOUL_SAND.getDefaultState();
    }
    
    @Override
    public boolean func_193414_a(final World lllllllllllllllllIIlIlllIIIlllll, final String lllllllllllllllllIIlIlllIIIllIll, final BlockPos lllllllllllllllllIIlIlllIIIlllIl) {
        return "Fortress".equals(lllllllllllllllllIIlIlllIIIllIll) && this.genNetherBridge != null && this.genNetherBridge.isInsideStructure(lllllllllllllllllIIlIlllIIIlllIl);
    }
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllllllllIIlIlllIlIIIIIl, final int lllllllllllllllllIIlIlllIlIIIIII, final int lllllllllllllllllIIlIlllIIllllll) {
        return false;
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllllIIlIllllIllllII, final int lllllllllllllllllIIlIllllIllIIll) {
        this.rand.setSeed(lllllllllllllllllIIlIllllIllllII * 341873128712L + lllllllllllllllllIIlIllllIllIIll * 132897987541L);
        final ChunkPrimer lllllllllllllllllIIlIllllIlllIlI = new ChunkPrimer();
        this.prepareHeights(lllllllllllllllllIIlIllllIllllII, lllllllllllllllllIIlIllllIllIIll, lllllllllllllllllIIlIllllIlllIlI);
        this.buildSurfaces(lllllllllllllllllIIlIllllIllllII, lllllllllllllllllIIlIllllIllIIll, lllllllllllllllllIIlIllllIlllIlI);
        this.genNetherCaves.generate(this.world, lllllllllllllllllIIlIllllIllllII, lllllllllllllllllIIlIllllIllIIll, lllllllllllllllllIIlIllllIlllIlI);
        if (this.generateStructures) {
            this.genNetherBridge.generate(this.world, lllllllllllllllllIIlIllllIllllII, lllllllllllllllllIIlIllllIllIIll, lllllllllllllllllIIlIllllIlllIlI);
        }
        final Chunk lllllllllllllllllIIlIllllIlllIIl = new Chunk(this.world, lllllllllllllllllIIlIllllIlllIlI, lllllllllllllllllIIlIllllIllllII, lllllllllllllllllIIlIllllIllIIll);
        final Biome[] lllllllllllllllllIIlIllllIlllIII = this.world.getBiomeProvider().getBiomes(null, lllllllllllllllllIIlIllllIllllII * 16, lllllllllllllllllIIlIllllIllIIll * 16, 16, 16);
        final byte[] lllllllllllllllllIIlIllllIllIlll = lllllllllllllllllIIlIllllIlllIIl.getBiomeArray();
        for (int lllllllllllllllllIIlIllllIllIllI = 0; lllllllllllllllllIIlIllllIllIllI < lllllllllllllllllIIlIllllIllIlll.length; ++lllllllllllllllllIIlIllllIllIllI) {
            lllllllllllllllllIIlIllllIllIlll[lllllllllllllllllIIlIllllIllIllI] = (byte)Biome.getIdForBiome(lllllllllllllllllIIlIllllIlllIII[lllllllllllllllllIIlIllllIllIllI]);
        }
        lllllllllllllllllIIlIllllIlllIIl.resetRelightChecks();
        return lllllllllllllllllIIlIllllIlllIIl;
    }
    
    public ChunkGeneratorHell(final World lllllllllllllllllIIllIIIIllIIlII, final boolean lllllllllllllllllIIllIIIIllIIlll, final long lllllllllllllllllIIllIIIIllIIIlI) {
        this.slowsandNoise = new double[256];
        this.gravelNoise = new double[256];
        this.depthBuffer = new double[256];
        this.fireFeature = new WorldGenFire();
        this.lightGemGen = new WorldGenGlowStone1();
        this.hellPortalGen = new WorldGenGlowStone2();
        this.quartzGen = new WorldGenMinable(Blocks.QUARTZ_ORE.getDefaultState(), 14, (Predicate<IBlockState>)BlockMatcher.forBlock(Blocks.NETHERRACK));
        this.magmaGen = new WorldGenMinable(Blocks.MAGMA.getDefaultState(), 33, (Predicate<IBlockState>)BlockMatcher.forBlock(Blocks.NETHERRACK));
        this.lavaTrapGen = new WorldGenHellLava(Blocks.FLOWING_LAVA, true);
        this.hellSpringGen = new WorldGenHellLava(Blocks.FLOWING_LAVA, false);
        this.brownMushroomFeature = new WorldGenBush(Blocks.BROWN_MUSHROOM);
        this.redMushroomFeature = new WorldGenBush(Blocks.RED_MUSHROOM);
        this.genNetherBridge = new MapGenNetherBridge();
        this.genNetherCaves = new MapGenCavesHell();
        this.world = lllllllllllllllllIIllIIIIllIIlII;
        this.generateStructures = lllllllllllllllllIIllIIIIllIIlll;
        this.rand = new Random(lllllllllllllllllIIllIIIIllIIIlI);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.rand, 4);
        this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        lllllllllllllllllIIllIIIIllIIlII.setSeaLevel(63);
    }
    
    private double[] getHeights(double[] lllllllllllllllllIIlIlllIllllIll, final int lllllllllllllllllIIlIlllIllllIlI, final int lllllllllllllllllIIlIlllIllllIIl, final int lllllllllllllllllIIlIllllIIlIIll, final int lllllllllllllllllIIlIllllIIlIIlI, final int lllllllllllllllllIIlIllllIIlIIIl, final int lllllllllllllllllIIlIlllIlllIlIl) {
        if (lllllllllllllllllIIlIlllIllllIll == null) {
            lllllllllllllllllIIlIlllIllllIll = new double[lllllllllllllllllIIlIllllIIlIIlI * lllllllllllllllllIIlIllllIIlIIIl * lllllllllllllllllIIlIlllIlllIlIl];
        }
        final double lllllllllllllllllIIlIllllIIIllll = 684.412;
        final double lllllllllllllllllIIlIllllIIIlllI = 2053.236;
        this.noiseData4 = this.scaleNoise.generateNoiseOctaves(this.noiseData4, lllllllllllllllllIIlIlllIllllIlI, lllllllllllllllllIIlIlllIllllIIl, lllllllllllllllllIIlIllllIIlIIll, lllllllllllllllllIIlIllllIIlIIlI, 1, lllllllllllllllllIIlIlllIlllIlIl, 1.0, 0.0, 1.0);
        this.dr = this.depthNoise.generateNoiseOctaves(this.dr, lllllllllllllllllIIlIlllIllllIlI, lllllllllllllllllIIlIlllIllllIIl, lllllllllllllllllIIlIllllIIlIIll, lllllllllllllllllIIlIllllIIlIIlI, 1, lllllllllllllllllIIlIlllIlllIlIl, 100.0, 0.0, 100.0);
        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, lllllllllllllllllIIlIlllIllllIlI, lllllllllllllllllIIlIlllIllllIIl, lllllllllllllllllIIlIllllIIlIIll, lllllllllllllllllIIlIllllIIlIIlI, lllllllllllllllllIIlIllllIIlIIIl, lllllllllllllllllIIlIlllIlllIlIl, 8.555150000000001, 34.2206, 8.555150000000001);
        this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, lllllllllllllllllIIlIlllIllllIlI, lllllllllllllllllIIlIlllIllllIIl, lllllllllllllllllIIlIllllIIlIIll, lllllllllllllllllIIlIllllIIlIIlI, lllllllllllllllllIIlIllllIIlIIIl, lllllllllllllllllIIlIlllIlllIlIl, 684.412, 2053.236, 684.412);
        this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, lllllllllllllllllIIlIlllIllllIlI, lllllllllllllllllIIlIlllIllllIIl, lllllllllllllllllIIlIllllIIlIIll, lllllllllllllllllIIlIllllIIlIIlI, lllllllllllllllllIIlIllllIIlIIIl, lllllllllllllllllIIlIlllIlllIlIl, 684.412, 2053.236, 684.412);
        int lllllllllllllllllIIlIllllIIIllIl = 0;
        final double[] lllllllllllllllllIIlIllllIIIllII = new double[lllllllllllllllllIIlIllllIIlIIIl];
        for (int lllllllllllllllllIIlIllllIIIlIll = 0; lllllllllllllllllIIlIllllIIIlIll < lllllllllllllllllIIlIllllIIlIIIl; ++lllllllllllllllllIIlIllllIIIlIll) {
            lllllllllllllllllIIlIllllIIIllII[lllllllllllllllllIIlIllllIIIlIll] = Math.cos(lllllllllllllllllIIlIllllIIIlIll * 3.141592653589793 * 6.0 / lllllllllllllllllIIlIllllIIlIIIl) * 2.0;
            double lllllllllllllllllIIlIllllIIIlIlI = lllllllllllllllllIIlIllllIIIlIll;
            if (lllllllllllllllllIIlIllllIIIlIll > lllllllllllllllllIIlIllllIIlIIIl / 2) {
                lllllllllllllllllIIlIllllIIIlIlI = lllllllllllllllllIIlIllllIIlIIIl - 1 - lllllllllllllllllIIlIllllIIIlIll;
            }
            if (lllllllllllllllllIIlIllllIIIlIlI < 4.0) {
                lllllllllllllllllIIlIllllIIIlIlI = 4.0 - lllllllllllllllllIIlIllllIIIlIlI;
                final double[] array = lllllllllllllllllIIlIllllIIIllII;
                final int n = lllllllllllllllllIIlIllllIIIlIll;
                array[n] -= lllllllllllllllllIIlIllllIIIlIlI * lllllllllllllllllIIlIllllIIIlIlI * lllllllllllllllllIIlIllllIIIlIlI * 10.0;
            }
        }
        for (int lllllllllllllllllIIlIllllIIIlIIl = 0; lllllllllllllllllIIlIllllIIIlIIl < lllllllllllllllllIIlIllllIIlIIlI; ++lllllllllllllllllIIlIllllIIIlIIl) {
            for (int lllllllllllllllllIIlIllllIIIlIII = 0; lllllllllllllllllIIlIllllIIIlIII < lllllllllllllllllIIlIlllIlllIlIl; ++lllllllllllllllllIIlIllllIIIlIII) {
                final double lllllllllllllllllIIlIllllIIIIlll = 0.0;
                for (int lllllllllllllllllIIlIllllIIIIllI = 0; lllllllllllllllllIIlIllllIIIIllI < lllllllllllllllllIIlIllllIIlIIIl; ++lllllllllllllllllIIlIllllIIIIllI) {
                    final double lllllllllllllllllIIlIllllIIIIlIl = lllllllllllllllllIIlIllllIIIllII[lllllllllllllllllIIlIllllIIIIllI];
                    final double lllllllllllllllllIIlIllllIIIIlII = this.ar[lllllllllllllllllIIlIllllIIIllIl] / 512.0;
                    final double lllllllllllllllllIIlIllllIIIIIll = this.br[lllllllllllllllllIIlIllllIIIllIl] / 512.0;
                    final double lllllllllllllllllIIlIllllIIIIIlI = (this.pnr[lllllllllllllllllIIlIllllIIIllIl] / 10.0 + 1.0) / 2.0;
                    double lllllllllllllllllIIlIlllIlllllll = 0.0;
                    if (lllllllllllllllllIIlIllllIIIIIlI < 0.0) {
                        final double lllllllllllllllllIIlIllllIIIIIIl = lllllllllllllllllIIlIllllIIIIlII;
                    }
                    else if (lllllllllllllllllIIlIllllIIIIIlI > 1.0) {
                        final double lllllllllllllllllIIlIllllIIIIIII = lllllllllllllllllIIlIllllIIIIIll;
                    }
                    else {
                        lllllllllllllllllIIlIlllIlllllll = lllllllllllllllllIIlIllllIIIIlII + (lllllllllllllllllIIlIllllIIIIIll - lllllllllllllllllIIlIllllIIIIlII) * lllllllllllllllllIIlIllllIIIIIlI;
                    }
                    lllllllllllllllllIIlIlllIlllllll -= lllllllllllllllllIIlIllllIIIIlIl;
                    if (lllllllllllllllllIIlIllllIIIIllI > lllllllllllllllllIIlIllllIIlIIIl - 4) {
                        final double lllllllllllllllllIIlIlllIllllllI = (lllllllllllllllllIIlIllllIIIIllI - (lllllllllllllllllIIlIllllIIlIIIl - 4)) / 3.0f;
                        lllllllllllllllllIIlIlllIlllllll = lllllllllllllllllIIlIlllIlllllll * (1.0 - lllllllllllllllllIIlIlllIllllllI) + -10.0 * lllllllllllllllllIIlIlllIllllllI;
                    }
                    if (lllllllllllllllllIIlIllllIIIIllI < 0.0) {
                        double lllllllllllllllllIIlIlllIlllllIl = (0.0 - lllllllllllllllllIIlIllllIIIIllI) / 4.0;
                        lllllllllllllllllIIlIlllIlllllIl = MathHelper.clamp(lllllllllllllllllIIlIlllIlllllIl, 0.0, 1.0);
                        lllllllllllllllllIIlIlllIlllllll = lllllllllllllllllIIlIlllIlllllll * (1.0 - lllllllllllllllllIIlIlllIlllllIl) + -10.0 * lllllllllllllllllIIlIlllIlllllIl;
                    }
                    lllllllllllllllllIIlIlllIllllIll[lllllllllllllllllIIlIllllIIIllIl] = lllllllllllllllllIIlIlllIlllllll;
                    ++lllllllllllllllllIIlIllllIIIllIl;
                }
            }
        }
        return (double[])lllllllllllllllllIIlIlllIllllIll;
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllllllllIIlIlllIIllIlIl, final BlockPos lllllllllllllllllIIlIlllIIllIlII) {
        if (lllllllllllllllllIIlIlllIIllIlIl == EnumCreatureType.MONSTER) {
            if (this.genNetherBridge.isInsideStructure(lllllllllllllllllIIlIlllIIllIlII)) {
                return this.genNetherBridge.getSpawnList();
            }
            if (this.genNetherBridge.isPositionInStructure(this.world, lllllllllllllllllIIlIlllIIllIlII) && this.world.getBlockState(lllllllllllllllllIIlIlllIIllIlII.down()).getBlock() == Blocks.NETHER_BRICK) {
                return this.genNetherBridge.getSpawnList();
            }
        }
        final Biome lllllllllllllllllIIlIlllIIllIlll = this.world.getBiome(lllllllllllllllllIIlIlllIIllIlII);
        return lllllllllllllllllIIlIlllIIllIlll.getSpawnableList(lllllllllllllllllIIlIlllIIllIlIl);
    }
    
    public void prepareHeights(final int lllllllllllllllllIIllIIIIIIllIII, final int lllllllllllllllllIIllIIIIIIlIlll, final ChunkPrimer lllllllllllllllllIIllIIIIIlllIlI) {
        final int lllllllllllllllllIIllIIIIIlllIIl = 4;
        final int lllllllllllllllllIIllIIIIIlllIII = this.world.getSeaLevel() / 2 + 1;
        final int lllllllllllllllllIIllIIIIIllIlll = 5;
        final int lllllllllllllllllIIllIIIIIllIllI = 17;
        final int lllllllllllllllllIIllIIIIIllIlIl = 5;
        this.buffer = this.getHeights(this.buffer, lllllllllllllllllIIllIIIIIIllIII * 4, 0, lllllllllllllllllIIllIIIIIIlIlll * 4, 5, 17, 5);
        for (int lllllllllllllllllIIllIIIIIllIlII = 0; lllllllllllllllllIIllIIIIIllIlII < 4; ++lllllllllllllllllIIllIIIIIllIlII) {
            for (int lllllllllllllllllIIllIIIIIllIIll = 0; lllllllllllllllllIIllIIIIIllIIll < 4; ++lllllllllllllllllIIllIIIIIllIIll) {
                for (int lllllllllllllllllIIllIIIIIllIIlI = 0; lllllllllllllllllIIllIIIIIllIIlI < 16; ++lllllllllllllllllIIllIIIIIllIIlI) {
                    final double lllllllllllllllllIIllIIIIIllIIIl = 0.125;
                    double lllllllllllllllllIIllIIIIIllIIII = this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 0) * 5 + lllllllllllllllllIIllIIIIIllIIll + 0) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 0];
                    double lllllllllllllllllIIllIIIIIlIllll = this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 0) * 5 + lllllllllllllllllIIllIIIIIllIIll + 1) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 0];
                    double lllllllllllllllllIIllIIIIIlIlllI = this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 1) * 5 + lllllllllllllllllIIllIIIIIllIIll + 0) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 0];
                    double lllllllllllllllllIIllIIIIIlIllIl = this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 1) * 5 + lllllllllllllllllIIllIIIIIllIIll + 1) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 0];
                    final double lllllllllllllllllIIllIIIIIlIllII = (this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 0) * 5 + lllllllllllllllllIIllIIIIIllIIll + 0) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 1] - lllllllllllllllllIIllIIIIIllIIII) * 0.125;
                    final double lllllllllllllllllIIllIIIIIlIlIll = (this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 0) * 5 + lllllllllllllllllIIllIIIIIllIIll + 1) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 1] - lllllllllllllllllIIllIIIIIlIllll) * 0.125;
                    final double lllllllllllllllllIIllIIIIIlIlIlI = (this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 1) * 5 + lllllllllllllllllIIllIIIIIllIIll + 0) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 1] - lllllllllllllllllIIllIIIIIlIlllI) * 0.125;
                    final double lllllllllllllllllIIllIIIIIlIlIIl = (this.buffer[((lllllllllllllllllIIllIIIIIllIlII + 1) * 5 + lllllllllllllllllIIllIIIIIllIIll + 1) * 17 + lllllllllllllllllIIllIIIIIllIIlI + 1] - lllllllllllllllllIIllIIIIIlIllIl) * 0.125;
                    for (int lllllllllllllllllIIllIIIIIlIlIII = 0; lllllllllllllllllIIllIIIIIlIlIII < 8; ++lllllllllllllllllIIllIIIIIlIlIII) {
                        final double lllllllllllllllllIIllIIIIIlIIlll = 0.25;
                        double lllllllllllllllllIIllIIIIIlIIllI = lllllllllllllllllIIllIIIIIllIIII;
                        double lllllllllllllllllIIllIIIIIlIIlIl = lllllllllllllllllIIllIIIIIlIllll;
                        final double lllllllllllllllllIIllIIIIIlIIlII = (lllllllllllllllllIIllIIIIIlIlllI - lllllllllllllllllIIllIIIIIllIIII) * 0.25;
                        final double lllllllllllllllllIIllIIIIIlIIIll = (lllllllllllllllllIIllIIIIIlIllIl - lllllllllllllllllIIllIIIIIlIllll) * 0.25;
                        for (int lllllllllllllllllIIllIIIIIlIIIlI = 0; lllllllllllllllllIIllIIIIIlIIIlI < 4; ++lllllllllllllllllIIllIIIIIlIIIlI) {
                            final double lllllllllllllllllIIllIIIIIlIIIIl = 0.25;
                            double lllllllllllllllllIIllIIIIIlIIIII = lllllllllllllllllIIllIIIIIlIIllI;
                            final double lllllllllllllllllIIllIIIIIIlllll = (lllllllllllllllllIIllIIIIIlIIlIl - lllllllllllllllllIIllIIIIIlIIllI) * 0.25;
                            for (int lllllllllllllllllIIllIIIIIIllllI = 0; lllllllllllllllllIIllIIIIIIllllI < 4; ++lllllllllllllllllIIllIIIIIIllllI) {
                                IBlockState lllllllllllllllllIIllIIIIIIlllIl = null;
                                if (lllllllllllllllllIIllIIIIIllIIlI * 8 + lllllllllllllllllIIllIIIIIlIlIII < lllllllllllllllllIIllIIIIIlllIII) {
                                    lllllllllllllllllIIllIIIIIIlllIl = ChunkGeneratorHell.LAVA;
                                }
                                if (lllllllllllllllllIIllIIIIIlIIIII > 0.0) {
                                    lllllllllllllllllIIllIIIIIIlllIl = ChunkGeneratorHell.NETHERRACK;
                                }
                                final int lllllllllllllllllIIllIIIIIIlllII = lllllllllllllllllIIllIIIIIlIIIlI + lllllllllllllllllIIllIIIIIllIlII * 4;
                                final int lllllllllllllllllIIllIIIIIIllIll = lllllllllllllllllIIllIIIIIlIlIII + lllllllllllllllllIIllIIIIIllIIlI * 8;
                                final int lllllllllllllllllIIllIIIIIIllIlI = lllllllllllllllllIIllIIIIIIllllI + lllllllllllllllllIIllIIIIIllIIll * 4;
                                lllllllllllllllllIIllIIIIIlllIlI.setBlockState(lllllllllllllllllIIllIIIIIIlllII, lllllllllllllllllIIllIIIIIIllIll, lllllllllllllllllIIllIIIIIIllIlI, lllllllllllllllllIIllIIIIIIlllIl);
                                lllllllllllllllllIIllIIIIIlIIIII += lllllllllllllllllIIllIIIIIIlllll;
                            }
                            lllllllllllllllllIIllIIIIIlIIllI += lllllllllllllllllIIllIIIIIlIIlII;
                            lllllllllllllllllIIllIIIIIlIIlIl += lllllllllllllllllIIllIIIIIlIIIll;
                        }
                        lllllllllllllllllIIllIIIIIllIIII += lllllllllllllllllIIllIIIIIlIllII;
                        lllllllllllllllllIIllIIIIIlIllll += lllllllllllllllllIIllIIIIIlIlIll;
                        lllllllllllllllllIIllIIIIIlIlllI += lllllllllllllllllIIllIIIIIlIlIlI;
                        lllllllllllllllllIIllIIIIIlIllIl += lllllllllllllllllIIllIIIIIlIlIIl;
                    }
                }
            }
        }
    }
    
    public void buildSurfaces(final int lllllllllllllllllIIlIlllllIlIlII, final int lllllllllllllllllIIlIllllllIIIll, final ChunkPrimer lllllllllllllllllIIlIlllllIlIIlI) {
        final int lllllllllllllllllIIlIllllllIIIIl = this.world.getSeaLevel() + 1;
        final double lllllllllllllllllIIlIllllllIIIII = 0.03125;
        this.slowsandNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.slowsandNoise, lllllllllllllllllIIlIlllllIlIlII * 16, lllllllllllllllllIIlIllllllIIIll * 16, 0, 16, 16, 1, 0.03125, 0.03125, 1.0);
        this.gravelNoise = this.slowsandGravelNoiseGen.generateNoiseOctaves(this.gravelNoise, lllllllllllllllllIIlIlllllIlIlII * 16, 109, lllllllllllllllllIIlIllllllIIIll * 16, 16, 1, 16, 0.03125, 1.0, 0.03125);
        this.depthBuffer = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(this.depthBuffer, lllllllllllllllllIIlIlllllIlIlII * 16, lllllllllllllllllIIlIllllllIIIll * 16, 0, 16, 16, 1, 0.0625, 0.0625, 0.0625);
        for (int lllllllllllllllllIIlIlllllIlllll = 0; lllllllllllllllllIIlIlllllIlllll < 16; ++lllllllllllllllllIIlIlllllIlllll) {
            for (int lllllllllllllllllIIlIlllllIllllI = 0; lllllllllllllllllIIlIlllllIllllI < 16; ++lllllllllllllllllIIlIlllllIllllI) {
                final boolean lllllllllllllllllIIlIlllllIlllIl = this.slowsandNoise[lllllllllllllllllIIlIlllllIlllll + lllllllllllllllllIIlIlllllIllllI * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                final boolean lllllllllllllllllIIlIlllllIlllII = this.gravelNoise[lllllllllllllllllIIlIlllllIlllll + lllllllllllllllllIIlIlllllIllllI * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                final int lllllllllllllllllIIlIlllllIllIll = (int)(this.depthBuffer[lllllllllllllllllIIlIlllllIlllll + lllllllllllllllllIIlIlllllIllllI * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int lllllllllllllllllIIlIlllllIllIlI = -1;
                IBlockState lllllllllllllllllIIlIlllllIllIIl = ChunkGeneratorHell.NETHERRACK;
                IBlockState lllllllllllllllllIIlIlllllIllIII = ChunkGeneratorHell.NETHERRACK;
                for (int lllllllllllllllllIIlIlllllIlIlll = 127; lllllllllllllllllIIlIlllllIlIlll >= 0; --lllllllllllllllllIIlIlllllIlIlll) {
                    if (lllllllllllllllllIIlIlllllIlIlll < 127 - this.rand.nextInt(5) && lllllllllllllllllIIlIlllllIlIlll > this.rand.nextInt(5)) {
                        final IBlockState lllllllllllllllllIIlIlllllIlIllI = lllllllllllllllllIIlIlllllIlIIlI.getBlockState(lllllllllllllllllIIlIlllllIllllI, lllllllllllllllllIIlIlllllIlIlll, lllllllllllllllllIIlIlllllIlllll);
                        if (lllllllllllllllllIIlIlllllIlIllI.getBlock() != null && lllllllllllllllllIIlIlllllIlIllI.getMaterial() != Material.AIR) {
                            if (lllllllllllllllllIIlIlllllIlIllI.getBlock() == Blocks.NETHERRACK) {
                                if (lllllllllllllllllIIlIlllllIllIlI == -1) {
                                    if (lllllllllllllllllIIlIlllllIllIll <= 0) {
                                        lllllllllllllllllIIlIlllllIllIIl = ChunkGeneratorHell.AIR;
                                        lllllllllllllllllIIlIlllllIllIII = ChunkGeneratorHell.NETHERRACK;
                                    }
                                    else if (lllllllllllllllllIIlIlllllIlIlll >= lllllllllllllllllIIlIllllllIIIIl - 4 && lllllllllllllllllIIlIlllllIlIlll <= lllllllllllllllllIIlIllllllIIIIl + 1) {
                                        lllllllllllllllllIIlIlllllIllIIl = ChunkGeneratorHell.NETHERRACK;
                                        lllllllllllllllllIIlIlllllIllIII = ChunkGeneratorHell.NETHERRACK;
                                        if (lllllllllllllllllIIlIlllllIlllII) {
                                            lllllllllllllllllIIlIlllllIllIIl = ChunkGeneratorHell.GRAVEL;
                                            lllllllllllllllllIIlIlllllIllIII = ChunkGeneratorHell.NETHERRACK;
                                        }
                                        if (lllllllllllllllllIIlIlllllIlllIl) {
                                            lllllllllllllllllIIlIlllllIllIIl = ChunkGeneratorHell.SOUL_SAND;
                                            lllllllllllllllllIIlIlllllIllIII = ChunkGeneratorHell.SOUL_SAND;
                                        }
                                    }
                                    if (lllllllllllllllllIIlIlllllIlIlll < lllllllllllllllllIIlIllllllIIIIl && (lllllllllllllllllIIlIlllllIllIIl == null || lllllllllllllllllIIlIlllllIllIIl.getMaterial() == Material.AIR)) {
                                        lllllllllllllllllIIlIlllllIllIIl = ChunkGeneratorHell.LAVA;
                                    }
                                    lllllllllllllllllIIlIlllllIllIlI = lllllllllllllllllIIlIlllllIllIll;
                                    if (lllllllllllllllllIIlIlllllIlIlll >= lllllllllllllllllIIlIllllllIIIIl - 1) {
                                        lllllllllllllllllIIlIlllllIlIIlI.setBlockState(lllllllllllllllllIIlIlllllIllllI, lllllllllllllllllIIlIlllllIlIlll, lllllllllllllllllIIlIlllllIlllll, lllllllllllllllllIIlIlllllIllIIl);
                                    }
                                    else {
                                        lllllllllllllllllIIlIlllllIlIIlI.setBlockState(lllllllllllllllllIIlIlllllIllllI, lllllllllllllllllIIlIlllllIlIlll, lllllllllllllllllIIlIlllllIlllll, lllllllllllllllllIIlIlllllIllIII);
                                    }
                                }
                                else if (lllllllllllllllllIIlIlllllIllIlI > 0) {
                                    --lllllllllllllllllIIlIlllllIllIlI;
                                    lllllllllllllllllIIlIlllllIlIIlI.setBlockState(lllllllllllllllllIIlIlllllIllllI, lllllllllllllllllIIlIlllllIlIlll, lllllllllllllllllIIlIlllllIlllll, lllllllllllllllllIIlIlllllIllIII);
                                }
                            }
                        }
                        else {
                            lllllllllllllllllIIlIlllllIllIlI = -1;
                        }
                    }
                    else {
                        lllllllllllllllllIIlIlllllIlIIlI.setBlockState(lllllllllllllllllIIlIlllllIllllI, lllllllllllllllllIIlIlllllIlIlll, lllllllllllllllllIIlIlllllIlllll, ChunkGeneratorHell.BEDROCK);
                    }
                }
            }
        }
    }
    
    @Override
    public void populate(final int lllllllllllllllllIIlIlllIlIIlIll, final int lllllllllllllllllIIlIlllIlIllIlI) {
        BlockFalling.fallInstantly = true;
        final int lllllllllllllllllIIlIlllIlIllIIl = lllllllllllllllllIIlIlllIlIIlIll * 16;
        final int lllllllllllllllllIIlIlllIlIllIII = lllllllllllllllllIIlIlllIlIllIlI * 16;
        final BlockPos lllllllllllllllllIIlIlllIlIlIlll = new BlockPos(lllllllllllllllllIIlIlllIlIllIIl, 0, lllllllllllllllllIIlIlllIlIllIII);
        final Biome lllllllllllllllllIIlIlllIlIlIllI = this.world.getBiome(lllllllllllllllllIIlIlllIlIlIlll.add(16, 0, 16));
        final ChunkPos lllllllllllllllllIIlIlllIlIlIlIl = new ChunkPos(lllllllllllllllllIIlIlllIlIIlIll, lllllllllllllllllIIlIlllIlIllIlI);
        this.genNetherBridge.generateStructure(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlIl);
        for (int lllllllllllllllllIIlIlllIlIlIlII = 0; lllllllllllllllllIIlIlllIlIlIlII < 8; ++lllllllllllllllllIIlIlllIlIlIlII) {
            this.hellSpringGen.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIIlIlllIlIlIIll = 0; lllllllllllllllllIIlIlllIlIlIIll < this.rand.nextInt(this.rand.nextInt(10) + 1) + 1; ++lllllllllllllllllIIlIlllIlIlIIll) {
            this.fireFeature.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIIlIlllIlIlIIlI = 0; lllllllllllllllllIIlIlllIlIlIIlI < this.rand.nextInt(this.rand.nextInt(10) + 1); ++lllllllllllllllllIIlIlllIlIlIIlI) {
            this.lightGemGen.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(120) + 4, this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIIlIlllIlIlIIIl = 0; lllllllllllllllllIIlIlllIlIlIIIl < 10; ++lllllllllllllllllIIlIlllIlIlIIIl) {
            this.hellPortalGen.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
        }
        if (this.rand.nextBoolean()) {
            this.brownMushroomFeature.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
        }
        if (this.rand.nextBoolean()) {
            this.redMushroomFeature.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16) + 8, this.rand.nextInt(128), this.rand.nextInt(16) + 8));
        }
        for (int lllllllllllllllllIIlIlllIlIlIIII = 0; lllllllllllllllllIIlIlllIlIlIIII < 16; ++lllllllllllllllllIIlIlllIlIlIIII) {
            this.quartzGen.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16), this.rand.nextInt(108) + 10, this.rand.nextInt(16)));
        }
        final int lllllllllllllllllIIlIlllIlIIllll = this.world.getSeaLevel() / 2 + 1;
        for (int lllllllllllllllllIIlIlllIlIIlllI = 0; lllllllllllllllllIIlIlllIlIIlllI < 4; ++lllllllllllllllllIIlIlllIlIIlllI) {
            this.magmaGen.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16), lllllllllllllllllIIlIlllIlIIllll - 5 + this.rand.nextInt(10), this.rand.nextInt(16)));
        }
        for (int lllllllllllllllllIIlIlllIlIIllIl = 0; lllllllllllllllllIIlIlllIlIIllIl < 16; ++lllllllllllllllllIIlIlllIlIIllIl) {
            this.lavaTrapGen.generate(this.world, this.rand, lllllllllllllllllIIlIlllIlIlIlll.add(this.rand.nextInt(16), this.rand.nextInt(108) + 10, this.rand.nextInt(16)));
        }
        lllllllllllllllllIIlIlllIlIlIllI.decorate(this.world, this.rand, new BlockPos(lllllllllllllllllIIlIlllIlIllIIl, 0, lllllllllllllllllIIlIlllIlIllIII));
        BlockFalling.fallInstantly = false;
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllllllllIIlIlllIIlIIlll, final String lllllllllllllllllIIlIlllIIlIIllI, final BlockPos lllllllllllllllllIIlIlllIIlIIlIl, final boolean lllllllllllllllllIIlIlllIIlIIlII) {
        return ("Fortress".equals(lllllllllllllllllIIlIlllIIlIIllI) && this.genNetherBridge != null) ? this.genNetherBridge.getClosestStrongholdPos(lllllllllllllllllIIlIlllIIlIIlll, lllllllllllllllllIIlIlllIIlIIlIl, lllllllllllllllllIIlIlllIIlIIlII) : null;
    }
    
    @Override
    public void recreateStructures(final Chunk lllllllllllllllllIIlIlllIIIlIlIl, final int lllllllllllllllllIIlIlllIIIlIlII, final int lllllllllllllllllIIlIlllIIIlIIII) {
        this.genNetherBridge.generate(this.world, lllllllllllllllllIIlIlllIIIlIlII, lllllllllllllllllIIlIlllIIIlIIII, null);
    }
}
