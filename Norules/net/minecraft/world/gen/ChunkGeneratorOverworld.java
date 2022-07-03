package net.minecraft.world.gen;

import net.minecraft.world.biome.*;
import net.minecraft.block.state.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.chunk.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class ChunkGeneratorOverworld implements IChunkGenerator
{
    private /* synthetic */ ChunkGeneratorSettings settings;
    private /* synthetic */ Biome[] biomesForGeneration;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    private final /* synthetic */ NoiseGeneratorOctaves mainPerlinNoise;
    private final /* synthetic */ MapGenMineshaft mineshaftGenerator;
    private final /* synthetic */ NoiseGeneratorOctaves maxLimitPerlinNoise;
    /* synthetic */ double[] minLimitRegion;
    private final /* synthetic */ double[] heightMap;
    public /* synthetic */ NoiseGeneratorOctaves depthNoise;
    private final /* synthetic */ MapGenStronghold strongholdGenerator;
    private final /* synthetic */ NoiseGeneratorPerlin surfaceNoise;
    private final /* synthetic */ StructureOceanMonument oceanMonumentGenerator;
    private final /* synthetic */ Random rand;
    /* synthetic */ double[] maxLimitRegion;
    private /* synthetic */ double[] depthBuffer;
    /* synthetic */ double[] depthRegion;
    protected static final /* synthetic */ IBlockState STONE;
    private /* synthetic */ IBlockState oceanBlock;
    /* synthetic */ double[] mainNoiseRegion;
    private final /* synthetic */ WoodlandMansion field_191060_C;
    private final /* synthetic */ float[] biomeWeights;
    private final /* synthetic */ MapGenBase ravineGenerator;
    private final /* synthetic */ MapGenScatteredFeature scatteredFeatureGenerator;
    public /* synthetic */ NoiseGeneratorOctaves forestNoise;
    private final /* synthetic */ MapGenBase caveGenerator;
    private final /* synthetic */ MapGenVillage villageGenerator;
    private final /* synthetic */ NoiseGeneratorOctaves minLimitPerlinNoise;
    public /* synthetic */ NoiseGeneratorOctaves scaleNoise;
    private final /* synthetic */ WorldType terrainType;
    
    @Override
    public boolean func_193414_a(final World lllllllllllllIIIlIIlIlIIIllllIIl, final String lllllllllllllIIIlIIlIlIIIllllIII, final BlockPos lllllllllllllIIIlIIlIlIIIlllIlll) {
        if (!this.mapFeaturesEnabled) {
            return false;
        }
        if ("Stronghold".equals(lllllllllllllIIIlIIlIlIIIllllIII) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.isInsideStructure(lllllllllllllIIIlIIlIlIIIlllIlll);
        }
        if ("Mansion".equals(lllllllllllllIIIlIIlIlIIIllllIII) && this.field_191060_C != null) {
            return this.field_191060_C.isInsideStructure(lllllllllllllIIIlIIlIlIIIlllIlll);
        }
        if ("Monument".equals(lllllllllllllIIIlIIlIlIIIllllIII) && this.oceanMonumentGenerator != null) {
            return this.oceanMonumentGenerator.isInsideStructure(lllllllllllllIIIlIIlIlIIIlllIlll);
        }
        if ("Village".equals(lllllllllllllIIIlIIlIlIIIllllIII) && this.villageGenerator != null) {
            return this.villageGenerator.isInsideStructure(lllllllllllllIIIlIIlIlIIIlllIlll);
        }
        if ("Mineshaft".equals(lllllllllllllIIIlIIlIlIIIllllIII) && this.mineshaftGenerator != null) {
            return this.mineshaftGenerator.isInsideStructure(lllllllllllllIIIlIIlIlIIIlllIlll);
        }
        return "Temple".equals(lllllllllllllIIIlIIlIlIIIllllIII) && this.scatteredFeatureGenerator != null && this.scatteredFeatureGenerator.isInsideStructure(lllllllllllllIIIlIIlIlIIIlllIlll);
    }
    
    @Override
    public boolean generateStructures(final Chunk lllllllllllllIIIlIIlIlIIlIIIllIl, final int lllllllllllllIIIlIIlIlIIlIIlIIIl, final int lllllllllllllIIIlIIlIlIIlIIlIIII) {
        boolean lllllllllllllIIIlIIlIlIIlIIIllll = false;
        if (this.settings.useMonuments && this.mapFeaturesEnabled && lllllllllllllIIIlIIlIlIIlIIIllIl.getInhabitedTime() < 3600L) {
            lllllllllllllIIIlIIlIlIIlIIIllll |= this.oceanMonumentGenerator.generateStructure(this.worldObj, this.rand, new ChunkPos(lllllllllllllIIIlIIlIlIIlIIlIIIl, lllllllllllllIIIlIIlIlIIlIIlIIII));
        }
        return lllllllllllllIIIlIIlIlIIlIIIllll;
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType lllllllllllllIIIlIIlIlIIlIIIIlII, final BlockPos lllllllllllllIIIlIIlIlIIIlllllll) {
        final Biome lllllllllllllIIIlIIlIlIIlIIIIIlI = this.worldObj.getBiome(lllllllllllllIIIlIIlIlIIIlllllll);
        if (this.mapFeaturesEnabled) {
            if (lllllllllllllIIIlIIlIlIIlIIIIlII == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.isSwampHut(lllllllllllllIIIlIIlIlIIIlllllll)) {
                return this.scatteredFeatureGenerator.getScatteredFeatureSpawnList();
            }
            if (lllllllllllllIIIlIIlIlIIlIIIIlII == EnumCreatureType.MONSTER && this.settings.useMonuments && this.oceanMonumentGenerator.isPositionInStructure(this.worldObj, lllllllllllllIIIlIIlIlIIIlllllll)) {
                return this.oceanMonumentGenerator.getScatteredFeatureSpawnList();
            }
        }
        return lllllllllllllIIIlIIlIlIIlIIIIIlI.getSpawnableList(lllllllllllllIIIlIIlIlIIlIIIIlII);
    }
    
    static {
        STONE = Blocks.STONE.getDefaultState();
    }
    
    public void replaceBiomeBlocks(final int lllllllllllllIIIlIIlIlIlIlIIllll, final int lllllllllllllIIIlIIlIlIlIlIIIlIl, final ChunkPrimer lllllllllllllIIIlIIlIlIlIlIIIlII, final Biome[] lllllllllllllIIIlIIlIlIlIlIIllII) {
        final double lllllllllllllIIIlIIlIlIlIlIIlIll = 0.03125;
        this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, lllllllllllllIIIlIIlIlIlIlIIllll * 16, lllllllllllllIIIlIIlIlIlIlIIIlIl * 16, 16, 16, 0.0625, 0.0625, 1.0);
        for (int lllllllllllllIIIlIIlIlIlIlIIlIlI = 0; lllllllllllllIIIlIIlIlIlIlIIlIlI < 16; ++lllllllllllllIIIlIIlIlIlIlIIlIlI) {
            for (int lllllllllllllIIIlIIlIlIlIlIIlIIl = 0; lllllllllllllIIIlIIlIlIlIlIIlIIl < 16; ++lllllllllllllIIIlIIlIlIlIlIIlIIl) {
                final Biome lllllllllllllIIIlIIlIlIlIlIIlIII = lllllllllllllIIIlIIlIlIlIlIIllII[lllllllllllllIIIlIIlIlIlIlIIlIIl + lllllllllllllIIIlIIlIlIlIlIIlIlI * 16];
                lllllllllllllIIIlIIlIlIlIlIIlIII.genTerrainBlocks(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIlIlIIIlII, lllllllllllllIIIlIIlIlIlIlIIllll * 16 + lllllllllllllIIIlIIlIlIlIlIIlIlI, lllllllllllllIIIlIIlIlIlIlIIIlIl * 16 + lllllllllllllIIIlIIlIlIlIlIIlIIl, this.depthBuffer[lllllllllllllIIIlIIlIlIlIlIIlIIl + lllllllllllllIIIlIIlIlIlIlIIlIlI * 16]);
            }
        }
    }
    
    @Override
    public void recreateStructures(final Chunk lllllllllllllIIIlIIlIlIIIllIIIII, final int lllllllllllllIIIlIIlIlIIIlIlllII, final int lllllllllllllIIIlIIlIlIIIlIllllI) {
        if (this.mapFeaturesEnabled) {
            if (this.settings.useMineShafts) {
                this.mineshaftGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIIIlIlllII, lllllllllllllIIIlIIlIlIIIlIllllI, null);
            }
            if (this.settings.useVillages) {
                this.villageGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIIIlIlllII, lllllllllllllIIIlIIlIlIIIlIllllI, null);
            }
            if (this.settings.useStrongholds) {
                this.strongholdGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIIIlIlllII, lllllllllllllIIIlIIlIlIIIlIllllI, null);
            }
            if (this.settings.useTemples) {
                this.scatteredFeatureGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIIIlIlllII, lllllllllllllIIIlIIlIlIIIlIllllI, null);
            }
            if (this.settings.useMonuments) {
                this.oceanMonumentGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIIIlIlllII, lllllllllllllIIIlIIlIlIIIlIllllI, null);
            }
            if (this.settings.field_191077_z) {
                this.field_191060_C.generate(this.worldObj, lllllllllllllIIIlIIlIlIIIlIlllII, lllllllllllllIIIlIIlIlIIIlIllllI, null);
            }
        }
    }
    
    @Override
    public void populate(final int lllllllllllllIIIlIIlIlIIlIllllll, final int lllllllllllllIIIlIIlIlIIlIlllllI) {
        BlockFalling.fallInstantly = true;
        final int lllllllllllllIIIlIIlIlIIlIllllIl = lllllllllllllIIIlIIlIlIIlIllllll * 16;
        final int lllllllllllllIIIlIIlIlIIlIllllII = lllllllllllllIIIlIIlIlIIlIlllllI * 16;
        BlockPos lllllllllllllIIIlIIlIlIIlIlllIll = new BlockPos(lllllllllllllIIIlIIlIlIIlIllllIl, 0, lllllllllllllIIIlIIlIlIIlIllllII);
        final Biome lllllllllllllIIIlIIlIlIIlIlllIlI = this.worldObj.getBiome(lllllllllllllIIIlIIlIlIIlIlllIll.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        final long lllllllllllllIIIlIIlIlIIlIlllIIl = this.rand.nextLong() / 2L * 2L + 1L;
        final long lllllllllllllIIIlIIlIlIIlIlllIII = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(lllllllllllllIIIlIIlIlIIlIllllll * lllllllllllllIIIlIIlIlIIlIlllIIl + lllllllllllllIIIlIIlIlIIlIlllllI * lllllllllllllIIIlIIlIlIIlIlllIII ^ this.worldObj.getSeed());
        boolean lllllllllllllIIIlIIlIlIIlIllIlll = false;
        final ChunkPos lllllllllllllIIIlIIlIlIIlIllIllI = new ChunkPos(lllllllllllllIIIlIIlIlIIlIllllll, lllllllllllllIIIlIIlIlIIlIlllllI);
        if (this.mapFeaturesEnabled) {
            if (this.settings.useMineShafts) {
                this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIllIllI);
            }
            if (this.settings.useVillages) {
                lllllllllllllIIIlIIlIlIIlIllIlll = this.villageGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIllIllI);
            }
            if (this.settings.useStrongholds) {
                this.strongholdGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIllIllI);
            }
            if (this.settings.useTemples) {
                this.scatteredFeatureGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIllIllI);
            }
            if (this.settings.useMonuments) {
                this.oceanMonumentGenerator.generateStructure(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIllIllI);
            }
            if (this.settings.field_191077_z) {
                this.field_191060_C.generateStructure(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIllIllI);
            }
        }
        if (lllllllllllllIIIlIIlIlIIlIlllIlI != Biomes.DESERT && lllllllllllllIIIlIIlIlIIlIlllIlI != Biomes.DESERT_HILLS && this.settings.useWaterLakes && !lllllllllllllIIIlIIlIlIIlIllIlll && this.rand.nextInt(this.settings.waterLakeChance) == 0) {
            final int lllllllllllllIIIlIIlIlIIlIllIlIl = this.rand.nextInt(16) + 8;
            final int lllllllllllllIIIlIIlIlIIlIllIlII = this.rand.nextInt(256);
            final int lllllllllllllIIIlIIlIlIIlIllIIll = this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.WATER).generate(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIlllIll.add(lllllllllllllIIIlIIlIlIIlIllIlIl, lllllllllllllIIIlIIlIlIIlIllIlII, lllllllllllllIIIlIIlIlIIlIllIIll));
        }
        if (!lllllllllllllIIIlIIlIlIIlIllIlll && this.rand.nextInt(this.settings.lavaLakeChance / 10) == 0 && this.settings.useLavaLakes) {
            final int lllllllllllllIIIlIIlIlIIlIllIIlI = this.rand.nextInt(16) + 8;
            final int lllllllllllllIIIlIIlIlIIlIllIIIl = this.rand.nextInt(this.rand.nextInt(248) + 8);
            final int lllllllllllllIIIlIIlIlIIlIllIIII = this.rand.nextInt(16) + 8;
            if (lllllllllllllIIIlIIlIlIIlIllIIIl < this.worldObj.getSeaLevel() || this.rand.nextInt(this.settings.lavaLakeChance / 8) == 0) {
                new WorldGenLakes(Blocks.LAVA).generate(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIlllIll.add(lllllllllllllIIIlIIlIlIIlIllIIlI, lllllllllllllIIIlIIlIlIIlIllIIIl, lllllllllllllIIIlIIlIlIIlIllIIII));
            }
        }
        if (this.settings.useDungeons) {
            for (int lllllllllllllIIIlIIlIlIIlIlIllll = 0; lllllllllllllIIIlIIlIlIIlIlIllll < this.settings.dungeonChance; ++lllllllllllllIIIlIIlIlIIlIlIllll) {
                final int lllllllllllllIIIlIIlIlIIlIlIlllI = this.rand.nextInt(16) + 8;
                final int lllllllllllllIIIlIIlIlIIlIlIllIl = this.rand.nextInt(256);
                final int lllllllllllllIIIlIIlIlIIlIlIllII = this.rand.nextInt(16) + 8;
                new WorldGenDungeons().generate(this.worldObj, this.rand, lllllllllllllIIIlIIlIlIIlIlllIll.add(lllllllllllllIIIlIIlIlIIlIlIlllI, lllllllllllllIIIlIIlIlIIlIlIllIl, lllllllllllllIIIlIIlIlIIlIlIllII));
            }
        }
        lllllllllllllIIIlIIlIlIIlIlllIlI.decorate(this.worldObj, this.rand, new BlockPos(lllllllllllllIIIlIIlIlIIlIllllIl, 0, lllllllllllllIIIlIIlIlIIlIllllII));
        WorldEntitySpawner.performWorldGenSpawning(this.worldObj, lllllllllllllIIIlIIlIlIIlIlllIlI, lllllllllllllIIIlIIlIlIIlIllllIl + 8, lllllllllllllIIIlIIlIlIIlIllllII + 8, 16, 16, this.rand);
        lllllllllllllIIIlIIlIlIIlIlllIll = lllllllllllllIIIlIIlIlIIlIlllIll.add(8, 0, 8);
        for (int lllllllllllllIIIlIIlIlIIlIlIlIll = 0; lllllllllllllIIIlIIlIlIIlIlIlIll < 16; ++lllllllllllllIIIlIIlIlIIlIlIlIll) {
            for (int lllllllllllllIIIlIIlIlIIlIlIlIlI = 0; lllllllllllllIIIlIIlIlIIlIlIlIlI < 16; ++lllllllllllllIIIlIIlIlIIlIlIlIlI) {
                final BlockPos lllllllllllllIIIlIIlIlIIlIlIlIIl = this.worldObj.getPrecipitationHeight(lllllllllllllIIIlIIlIlIIlIlllIll.add(lllllllllllllIIIlIIlIlIIlIlIlIll, 0, lllllllllllllIIIlIIlIlIIlIlIlIlI));
                final BlockPos lllllllllllllIIIlIIlIlIIlIlIlIII = lllllllllllllIIIlIIlIlIIlIlIlIIl.down();
                if (this.worldObj.canBlockFreezeWater(lllllllllllllIIIlIIlIlIIlIlIlIII)) {
                    this.worldObj.setBlockState(lllllllllllllIIIlIIlIlIIlIlIlIII, Blocks.ICE.getDefaultState(), 2);
                }
                if (this.worldObj.canSnowAt(lllllllllllllIIIlIIlIlIIlIlIlIIl, true)) {
                    this.worldObj.setBlockState(lllllllllllllIIIlIIlIlIIlIlIlIIl, Blocks.SNOW_LAYER.getDefaultState(), 2);
                }
            }
        }
        BlockFalling.fallInstantly = false;
    }
    
    private void generateHeightmap(final int lllllllllllllIIIlIIlIlIIlllIlIll, final int lllllllllllllIIIlIIlIlIlIIIIlIlI, final int lllllllllllllIIIlIIlIlIIlllIlIIl) {
        this.depthRegion = this.depthNoise.generateNoiseOctaves(this.depthRegion, lllllllllllllIIIlIIlIlIIlllIlIll, lllllllllllllIIIlIIlIlIIlllIlIIl, 5, 5, this.settings.depthNoiseScaleX, this.settings.depthNoiseScaleZ, this.settings.depthNoiseScaleExponent);
        final float lllllllllllllIIIlIIlIlIlIIIIlIII = this.settings.coordinateScale;
        final float lllllllllllllIIIlIIlIlIlIIIIIlll = this.settings.heightScale;
        this.mainNoiseRegion = this.mainPerlinNoise.generateNoiseOctaves(this.mainNoiseRegion, lllllllllllllIIIlIIlIlIIlllIlIll, lllllllllllllIIIlIIlIlIlIIIIlIlI, lllllllllllllIIIlIIlIlIIlllIlIIl, 5, 33, 5, lllllllllllllIIIlIIlIlIlIIIIlIII / this.settings.mainNoiseScaleX, lllllllllllllIIIlIIlIlIlIIIIIlll / this.settings.mainNoiseScaleY, lllllllllllllIIIlIIlIlIlIIIIlIII / this.settings.mainNoiseScaleZ);
        this.minLimitRegion = this.minLimitPerlinNoise.generateNoiseOctaves(this.minLimitRegion, lllllllllllllIIIlIIlIlIIlllIlIll, lllllllllllllIIIlIIlIlIlIIIIlIlI, lllllllllllllIIIlIIlIlIIlllIlIIl, 5, 33, 5, lllllllllllllIIIlIIlIlIlIIIIlIII, lllllllllllllIIIlIIlIlIlIIIIIlll, lllllllllllllIIIlIIlIlIlIIIIlIII);
        this.maxLimitRegion = this.maxLimitPerlinNoise.generateNoiseOctaves(this.maxLimitRegion, lllllllllllllIIIlIIlIlIIlllIlIll, lllllllllllllIIIlIIlIlIlIIIIlIlI, lllllllllllllIIIlIIlIlIIlllIlIIl, 5, 33, 5, lllllllllllllIIIlIIlIlIlIIIIlIII, lllllllllllllIIIlIIlIlIlIIIIIlll, lllllllllllllIIIlIIlIlIlIIIIlIII);
        int lllllllllllllIIIlIIlIlIlIIIIIllI = 0;
        int lllllllllllllIIIlIIlIlIlIIIIIlIl = 0;
        for (int lllllllllllllIIIlIIlIlIlIIIIIlII = 0; lllllllllllllIIIlIIlIlIlIIIIIlII < 5; ++lllllllllllllIIIlIIlIlIlIIIIIlII) {
            for (int lllllllllllllIIIlIIlIlIlIIIIIIll = 0; lllllllllllllIIIlIIlIlIlIIIIIIll < 5; ++lllllllllllllIIIlIIlIlIlIIIIIIll) {
                float lllllllllllllIIIlIIlIlIlIIIIIIlI = 0.0f;
                float lllllllllllllIIIlIIlIlIlIIIIIIIl = 0.0f;
                float lllllllllllllIIIlIIlIlIlIIIIIIII = 0.0f;
                final int lllllllllllllIIIlIIlIlIIllllllll = 2;
                final Biome lllllllllllllIIIlIIlIlIIlllllllI = this.biomesForGeneration[lllllllllllllIIIlIIlIlIlIIIIIlII + 2 + (lllllllllllllIIIlIIlIlIlIIIIIIll + 2) * 10];
                for (int lllllllllllllIIIlIIlIlIIllllllIl = -2; lllllllllllllIIIlIIlIlIIllllllIl <= 2; ++lllllllllllllIIIlIIlIlIIllllllIl) {
                    for (int lllllllllllllIIIlIIlIlIIllllllII = -2; lllllllllllllIIIlIIlIlIIllllllII <= 2; ++lllllllllllllIIIlIIlIlIIllllllII) {
                        final Biome lllllllllllllIIIlIIlIlIIlllllIll = this.biomesForGeneration[lllllllllllllIIIlIIlIlIlIIIIIlII + lllllllllllllIIIlIIlIlIIllllllIl + 2 + (lllllllllllllIIIlIIlIlIlIIIIIIll + lllllllllllllIIIlIIlIlIIllllllII + 2) * 10];
                        float lllllllllllllIIIlIIlIlIIlllllIlI = this.settings.biomeDepthOffSet + lllllllllllllIIIlIIlIlIIlllllIll.getBaseHeight() * this.settings.biomeDepthWeight;
                        float lllllllllllllIIIlIIlIlIIlllllIIl = this.settings.biomeScaleOffset + lllllllllllllIIIlIIlIlIIlllllIll.getHeightVariation() * this.settings.biomeScaleWeight;
                        if (this.terrainType == WorldType.AMPLIFIED && lllllllllllllIIIlIIlIlIIlllllIlI > 0.0f) {
                            lllllllllllllIIIlIIlIlIIlllllIlI = 1.0f + lllllllllllllIIIlIIlIlIIlllllIlI * 2.0f;
                            lllllllllllllIIIlIIlIlIIlllllIIl = 1.0f + lllllllllllllIIIlIIlIlIIlllllIIl * 4.0f;
                        }
                        float lllllllllllllIIIlIIlIlIIlllllIII = this.biomeWeights[lllllllllllllIIIlIIlIlIIllllllIl + 2 + (lllllllllllllIIIlIIlIlIIllllllII + 2) * 5] / (lllllllllllllIIIlIIlIlIIlllllIlI + 2.0f);
                        if (lllllllllllllIIIlIIlIlIIlllllIll.getBaseHeight() > lllllllllllllIIIlIIlIlIIlllllllI.getBaseHeight()) {
                            lllllllllllllIIIlIIlIlIIlllllIII /= 2.0f;
                        }
                        lllllllllllllIIIlIIlIlIlIIIIIIlI += lllllllllllllIIIlIIlIlIIlllllIIl * lllllllllllllIIIlIIlIlIIlllllIII;
                        lllllllllllllIIIlIIlIlIlIIIIIIIl += lllllllllllllIIIlIIlIlIIlllllIlI * lllllllllllllIIIlIIlIlIIlllllIII;
                        lllllllllllllIIIlIIlIlIlIIIIIIII += lllllllllllllIIIlIIlIlIIlllllIII;
                    }
                }
                lllllllllllllIIIlIIlIlIlIIIIIIlI /= lllllllllllllIIIlIIlIlIlIIIIIIII;
                lllllllllllllIIIlIIlIlIlIIIIIIIl /= lllllllllllllIIIlIIlIlIlIIIIIIII;
                lllllllllllllIIIlIIlIlIlIIIIIIlI = lllllllllllllIIIlIIlIlIlIIIIIIlI * 0.9f + 0.1f;
                lllllllllllllIIIlIIlIlIlIIIIIIIl = (lllllllllllllIIIlIIlIlIlIIIIIIIl * 4.0f - 1.0f) / 8.0f;
                double lllllllllllllIIIlIIlIlIIllllIlll = this.depthRegion[lllllllllllllIIIlIIlIlIlIIIIIlIl] / 8000.0;
                if (lllllllllllllIIIlIIlIlIIllllIlll < 0.0) {
                    lllllllllllllIIIlIIlIlIIllllIlll = -lllllllllllllIIIlIIlIlIIllllIlll * 0.3;
                }
                lllllllllllllIIIlIIlIlIIllllIlll = lllllllllllllIIIlIIlIlIIllllIlll * 3.0 - 2.0;
                if (lllllllllllllIIIlIIlIlIIllllIlll < 0.0) {
                    lllllllllllllIIIlIIlIlIIllllIlll /= 2.0;
                    if (lllllllllllllIIIlIIlIlIIllllIlll < -1.0) {
                        lllllllllllllIIIlIIlIlIIllllIlll = -1.0;
                    }
                    lllllllllllllIIIlIIlIlIIllllIlll /= 1.4;
                    lllllllllllllIIIlIIlIlIIllllIlll /= 2.0;
                }
                else {
                    if (lllllllllllllIIIlIIlIlIIllllIlll > 1.0) {
                        lllllllllllllIIIlIIlIlIIllllIlll = 1.0;
                    }
                    lllllllllllllIIIlIIlIlIIllllIlll /= 8.0;
                }
                ++lllllllllllllIIIlIIlIlIlIIIIIlIl;
                double lllllllllllllIIIlIIlIlIIllllIllI = lllllllllllllIIIlIIlIlIlIIIIIIIl;
                final double lllllllllllllIIIlIIlIlIIllllIlIl = lllllllllllllIIIlIIlIlIlIIIIIIlI;
                lllllllllllllIIIlIIlIlIIllllIllI += lllllllllllllIIIlIIlIlIIllllIlll * 0.2;
                lllllllllllllIIIlIIlIlIIllllIllI = lllllllllllllIIIlIIlIlIIllllIllI * this.settings.baseSize / 8.0;
                final double lllllllllllllIIIlIIlIlIIllllIlII = this.settings.baseSize + lllllllllllllIIIlIIlIlIIllllIllI * 4.0;
                for (int lllllllllllllIIIlIIlIlIIllllIIll = 0; lllllllllllllIIIlIIlIlIIllllIIll < 33; ++lllllllllllllIIIlIIlIlIIllllIIll) {
                    double lllllllllllllIIIlIIlIlIIllllIIlI = (lllllllllllllIIIlIIlIlIIllllIIll - lllllllllllllIIIlIIlIlIIllllIlII) * this.settings.stretchY * 128.0 / 256.0 / lllllllllllllIIIlIIlIlIIllllIlIl;
                    if (lllllllllllllIIIlIIlIlIIllllIIlI < 0.0) {
                        lllllllllllllIIIlIIlIlIIllllIIlI *= 4.0;
                    }
                    final double lllllllllllllIIIlIIlIlIIllllIIIl = this.minLimitRegion[lllllllllllllIIIlIIlIlIlIIIIIllI] / this.settings.lowerLimitScale;
                    final double lllllllllllllIIIlIIlIlIIllllIIII = this.maxLimitRegion[lllllllllllllIIIlIIlIlIlIIIIIllI] / this.settings.upperLimitScale;
                    final double lllllllllllllIIIlIIlIlIIlllIllll = (this.mainNoiseRegion[lllllllllllllIIIlIIlIlIlIIIIIllI] / 10.0 + 1.0) / 2.0;
                    double lllllllllllllIIIlIIlIlIIlllIlllI = MathHelper.clampedLerp(lllllllllllllIIIlIIlIlIIllllIIIl, lllllllllllllIIIlIIlIlIIllllIIII, lllllllllllllIIIlIIlIlIIlllIllll) - lllllllllllllIIIlIIlIlIIllllIIlI;
                    if (lllllllllllllIIIlIIlIlIIllllIIll > 29) {
                        final double lllllllllllllIIIlIIlIlIIlllIllIl = (lllllllllllllIIIlIIlIlIIllllIIll - 29) / 3.0f;
                        lllllllllllllIIIlIIlIlIIlllIlllI = lllllllllllllIIIlIIlIlIIlllIlllI * (1.0 - lllllllllllllIIIlIIlIlIIlllIllIl) + -10.0 * lllllllllllllIIIlIIlIlIIlllIllIl;
                    }
                    this.heightMap[lllllllllllllIIIlIIlIlIlIIIIIllI] = lllllllllllllIIIlIIlIlIIlllIlllI;
                    ++lllllllllllllIIIlIIlIlIlIIIIIllI;
                }
            }
        }
    }
    
    public ChunkGeneratorOverworld(final World lllllllllllllIIIlIIlIlIlllIIlIll, final long lllllllllllllIIIlIIlIlIlllIIlIlI, final boolean lllllllllllllIIIlIIlIlIlllIIlIIl, final String lllllllllllllIIIlIIlIlIlllIIlIII) {
        this.oceanBlock = Blocks.WATER.getDefaultState();
        this.depthBuffer = new double[256];
        this.caveGenerator = new MapGenCaves();
        this.strongholdGenerator = new MapGenStronghold();
        this.villageGenerator = new MapGenVillage();
        this.mineshaftGenerator = new MapGenMineshaft();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = new MapGenRavine();
        this.oceanMonumentGenerator = new StructureOceanMonument();
        this.field_191060_C = new WoodlandMansion(this);
        this.worldObj = lllllllllllllIIIlIIlIlIlllIIlIll;
        this.mapFeaturesEnabled = lllllllllllllIIIlIIlIlIlllIIlIIl;
        this.terrainType = lllllllllllllIIIlIIlIlIlllIIlIll.getWorldInfo().getTerrainType();
        this.rand = new Random(lllllllllllllIIIlIIlIlIlllIIlIlI);
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.forestNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.heightMap = new double[825];
        this.biomeWeights = new float[25];
        for (int lllllllllllllIIIlIIlIlIlllIIIlll = -2; lllllllllllllIIIlIIlIlIlllIIIlll <= 2; ++lllllllllllllIIIlIIlIlIlllIIIlll) {
            for (int lllllllllllllIIIlIIlIlIlllIIIllI = -2; lllllllllllllIIIlIIlIlIlllIIIllI <= 2; ++lllllllllllllIIIlIIlIlIlllIIIllI) {
                final float lllllllllllllIIIlIIlIlIlllIIIlIl = 10.0f / MathHelper.sqrt(lllllllllllllIIIlIIlIlIlllIIIlll * lllllllllllllIIIlIIlIlIlllIIIlll + lllllllllllllIIIlIIlIlIlllIIIllI * lllllllllllllIIIlIIlIlIlllIIIllI + 0.2f);
                this.biomeWeights[lllllllllllllIIIlIIlIlIlllIIIlll + 2 + (lllllllllllllIIIlIIlIlIlllIIIllI + 2) * 5] = lllllllllllllIIIlIIlIlIlllIIIlIl;
            }
        }
        if (lllllllllllllIIIlIIlIlIlllIIlIII != null) {
            this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(lllllllllllllIIIlIIlIlIlllIIlIII).build();
            this.oceanBlock = (this.settings.useLavaOceans ? Blocks.LAVA.getDefaultState() : Blocks.WATER.getDefaultState());
            lllllllllllllIIIlIIlIlIlllIIlIll.setSeaLevel(this.settings.seaLevel);
        }
    }
    
    public void setBlocksInChunk(final int lllllllllllllIIIlIIlIlIllIIllIlI, final int lllllllllllllIIIlIIlIlIlIllllIII, final ChunkPrimer lllllllllllllIIIlIIlIlIlIlllIlll) {
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, lllllllllllllIIIlIIlIlIllIIllIlI * 4 - 2, lllllllllllllIIIlIIlIlIlIllllIII * 4 - 2, 10, 10);
        this.generateHeightmap(lllllllllllllIIIlIIlIlIllIIllIlI * 4, 0, lllllllllllllIIIlIIlIlIlIllllIII * 4);
        for (int lllllllllllllIIIlIIlIlIllIIlIlll = 0; lllllllllllllIIIlIIlIlIllIIlIlll < 4; ++lllllllllllllIIIlIIlIlIllIIlIlll) {
            final int lllllllllllllIIIlIIlIlIllIIlIllI = lllllllllllllIIIlIIlIlIllIIlIlll * 5;
            final int lllllllllllllIIIlIIlIlIllIIlIlIl = (lllllllllllllIIIlIIlIlIllIIlIlll + 1) * 5;
            for (int lllllllllllllIIIlIIlIlIllIIlIlII = 0; lllllllllllllIIIlIIlIlIllIIlIlII < 4; ++lllllllllllllIIIlIIlIlIllIIlIlII) {
                final int lllllllllllllIIIlIIlIlIllIIlIIll = (lllllllllllllIIIlIIlIlIllIIlIllI + lllllllllllllIIIlIIlIlIllIIlIlII) * 33;
                final int lllllllllllllIIIlIIlIlIllIIlIIlI = (lllllllllllllIIIlIIlIlIllIIlIllI + lllllllllllllIIIlIIlIlIllIIlIlII + 1) * 33;
                final int lllllllllllllIIIlIIlIlIllIIlIIIl = (lllllllllllllIIIlIIlIlIllIIlIlIl + lllllllllllllIIIlIIlIlIllIIlIlII) * 33;
                final int lllllllllllllIIIlIIlIlIllIIlIIII = (lllllllllllllIIIlIIlIlIllIIlIlIl + lllllllllllllIIIlIIlIlIllIIlIlII + 1) * 33;
                for (int lllllllllllllIIIlIIlIlIllIIIllll = 0; lllllllllllllIIIlIIlIlIllIIIllll < 32; ++lllllllllllllIIIlIIlIlIllIIIllll) {
                    final double lllllllllllllIIIlIIlIlIllIIIlllI = 0.125;
                    double lllllllllllllIIIlIIlIlIllIIIllIl = this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIll + lllllllllllllIIIlIIlIlIllIIIllll];
                    double lllllllllllllIIIlIIlIlIllIIIllII = this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIlI + lllllllllllllIIIlIIlIlIllIIIllll];
                    double lllllllllllllIIIlIIlIlIllIIIlIll = this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIIl + lllllllllllllIIIlIIlIlIllIIIllll];
                    double lllllllllllllIIIlIIlIlIllIIIlIlI = this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIII + lllllllllllllIIIlIIlIlIllIIIllll];
                    final double lllllllllllllIIIlIIlIlIllIIIlIIl = (this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIll + lllllllllllllIIIlIIlIlIllIIIllll + 1] - lllllllllllllIIIlIIlIlIllIIIllIl) * 0.125;
                    final double lllllllllllllIIIlIIlIlIllIIIlIII = (this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIlI + lllllllllllllIIIlIIlIlIllIIIllll + 1] - lllllllllllllIIIlIIlIlIllIIIllII) * 0.125;
                    final double lllllllllllllIIIlIIlIlIllIIIIlll = (this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIIl + lllllllllllllIIIlIIlIlIllIIIllll + 1] - lllllllllllllIIIlIIlIlIllIIIlIll) * 0.125;
                    final double lllllllllllllIIIlIIlIlIllIIIIllI = (this.heightMap[lllllllllllllIIIlIIlIlIllIIlIIII + lllllllllllllIIIlIIlIlIllIIIllll + 1] - lllllllllllllIIIlIIlIlIllIIIlIlI) * 0.125;
                    for (int lllllllllllllIIIlIIlIlIllIIIIlIl = 0; lllllllllllllIIIlIIlIlIllIIIIlIl < 8; ++lllllllllllllIIIlIIlIlIllIIIIlIl) {
                        final double lllllllllllllIIIlIIlIlIllIIIIlII = 0.25;
                        double lllllllllllllIIIlIIlIlIllIIIIIll = lllllllllllllIIIlIIlIlIllIIIllIl;
                        double lllllllllllllIIIlIIlIlIllIIIIIlI = lllllllllllllIIIlIIlIlIllIIIllII;
                        final double lllllllllllllIIIlIIlIlIllIIIIIIl = (lllllllllllllIIIlIIlIlIllIIIlIll - lllllllllllllIIIlIIlIlIllIIIllIl) * 0.25;
                        final double lllllllllllllIIIlIIlIlIllIIIIIII = (lllllllllllllIIIlIIlIlIllIIIlIlI - lllllllllllllIIIlIIlIlIllIIIllII) * 0.25;
                        for (int lllllllllllllIIIlIIlIlIlIlllllll = 0; lllllllllllllIIIlIIlIlIlIlllllll < 4; ++lllllllllllllIIIlIIlIlIlIlllllll) {
                            final double lllllllllllllIIIlIIlIlIlIllllllI = 0.25;
                            final double lllllllllllllIIIlIIlIlIlIlllllIl = (lllllllllllllIIIlIIlIlIllIIIIIlI - lllllllllllllIIIlIIlIlIllIIIIIll) * 0.25;
                            double lllllllllllllIIIlIIlIlIlIlllllII = lllllllllllllIIIlIIlIlIllIIIIIll - lllllllllllllIIIlIIlIlIlIlllllIl;
                            for (int lllllllllllllIIIlIIlIlIlIllllIll = 0; lllllllllllllIIIlIIlIlIlIllllIll < 4; ++lllllllllllllIIIlIIlIlIlIllllIll) {
                                if ((lllllllllllllIIIlIIlIlIlIlllllII += lllllllllllllIIIlIIlIlIlIlllllIl) > 0.0) {
                                    lllllllllllllIIIlIIlIlIlIlllIlll.setBlockState(lllllllllllllIIIlIIlIlIllIIlIlll * 4 + lllllllllllllIIIlIIlIlIlIlllllll, lllllllllllllIIIlIIlIlIllIIIllll * 8 + lllllllllllllIIIlIIlIlIllIIIIlIl, lllllllllllllIIIlIIlIlIllIIlIlII * 4 + lllllllllllllIIIlIIlIlIlIllllIll, ChunkGeneratorOverworld.STONE);
                                }
                                else if (lllllllllllllIIIlIIlIlIllIIIllll * 8 + lllllllllllllIIIlIIlIlIllIIIIlIl < this.settings.seaLevel) {
                                    lllllllllllllIIIlIIlIlIlIlllIlll.setBlockState(lllllllllllllIIIlIIlIlIllIIlIlll * 4 + lllllllllllllIIIlIIlIlIlIlllllll, lllllllllllllIIIlIIlIlIllIIIllll * 8 + lllllllllllllIIIlIIlIlIllIIIIlIl, lllllllllllllIIIlIIlIlIllIIlIlII * 4 + lllllllllllllIIIlIIlIlIlIllllIll, this.oceanBlock);
                                }
                            }
                            lllllllllllllIIIlIIlIlIllIIIIIll += lllllllllllllIIIlIIlIlIllIIIIIIl;
                            lllllllllllllIIIlIIlIlIllIIIIIlI += lllllllllllllIIIlIIlIlIllIIIIIII;
                        }
                        lllllllllllllIIIlIIlIlIllIIIllIl += lllllllllllllIIIlIIlIlIllIIIlIIl;
                        lllllllllllllIIIlIIlIlIllIIIllII += lllllllllllllIIIlIIlIlIllIIIlIII;
                        lllllllllllllIIIlIIlIlIllIIIlIll += lllllllllllllIIIlIIlIlIllIIIIlll;
                        lllllllllllllIIIlIIlIlIllIIIlIlI += lllllllllllllIIIlIIlIlIllIIIIllI;
                    }
                }
            }
        }
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllIIIlIIlIlIlIIllIllI, final int lllllllllllllIIIlIIlIlIlIIlIlllI) {
        this.rand.setSeed(lllllllllllllIIIlIIlIlIlIIllIllI * 341873128712L + lllllllllllllIIIlIIlIlIlIIlIlllI * 132897987541L);
        final ChunkPrimer lllllllllllllIIIlIIlIlIlIIllIlII = new ChunkPrimer();
        this.setBlocksInChunk(lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, lllllllllllllIIIlIIlIlIlIIllIllI * 16, lllllllllllllIIIlIIlIlIlIIlIlllI * 16, 16, 16);
        this.replaceBiomeBlocks(lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII, this.biomesForGeneration);
        if (this.settings.useCaves) {
            this.caveGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
        }
        if (this.settings.useRavines) {
            this.ravineGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
        }
        if (this.mapFeaturesEnabled) {
            if (this.settings.useMineShafts) {
                this.mineshaftGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
            }
            if (this.settings.useVillages) {
                this.villageGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
            }
            if (this.settings.useStrongholds) {
                this.strongholdGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
            }
            if (this.settings.useTemples) {
                this.scatteredFeatureGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
            }
            if (this.settings.useMonuments) {
                this.oceanMonumentGenerator.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
            }
            if (this.settings.field_191077_z) {
                this.field_191060_C.generate(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI, lllllllllllllIIIlIIlIlIlIIllIlII);
            }
        }
        final Chunk lllllllllllllIIIlIIlIlIlIIllIIll = new Chunk(this.worldObj, lllllllllllllIIIlIIlIlIlIIllIlII, lllllllllllllIIIlIIlIlIlIIllIllI, lllllllllllllIIIlIIlIlIlIIlIlllI);
        final byte[] lllllllllllllIIIlIIlIlIlIIllIIlI = lllllllllllllIIIlIIlIlIlIIllIIll.getBiomeArray();
        for (int lllllllllllllIIIlIIlIlIlIIllIIIl = 0; lllllllllllllIIIlIIlIlIlIIllIIIl < lllllllllllllIIIlIIlIlIlIIllIIlI.length; ++lllllllllllllIIIlIIlIlIlIIllIIIl) {
            lllllllllllllIIIlIIlIlIlIIllIIlI[lllllllllllllIIIlIIlIlIlIIllIIIl] = (byte)Biome.getIdForBiome(this.biomesForGeneration[lllllllllllllIIIlIIlIlIlIIllIIIl]);
        }
        lllllllllllllIIIlIIlIlIlIIllIIll.generateSkylightMap();
        return lllllllllllllIIIlIIlIlIlIIllIIll;
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World lllllllllllllIIIlIIlIlIIIllIlIII, final String lllllllllllllIIIlIIlIlIIIllIIlll, final BlockPos lllllllllllllIIIlIIlIlIIIllIIllI, final boolean lllllllllllllIIIlIIlIlIIIllIIlIl) {
        if (!this.mapFeaturesEnabled) {
            return null;
        }
        if ("Stronghold".equals(lllllllllllllIIIlIIlIlIIIllIIlll) && this.strongholdGenerator != null) {
            return this.strongholdGenerator.getClosestStrongholdPos(lllllllllllllIIIlIIlIlIIIllIlIII, lllllllllllllIIIlIIlIlIIIllIIllI, lllllllllllllIIIlIIlIlIIIllIIlIl);
        }
        if ("Mansion".equals(lllllllllllllIIIlIIlIlIIIllIIlll) && this.field_191060_C != null) {
            return this.field_191060_C.getClosestStrongholdPos(lllllllllllllIIIlIIlIlIIIllIlIII, lllllllllllllIIIlIIlIlIIIllIIllI, lllllllllllllIIIlIIlIlIIIllIIlIl);
        }
        if ("Monument".equals(lllllllllllllIIIlIIlIlIIIllIIlll) && this.oceanMonumentGenerator != null) {
            return this.oceanMonumentGenerator.getClosestStrongholdPos(lllllllllllllIIIlIIlIlIIIllIlIII, lllllllllllllIIIlIIlIlIIIllIIllI, lllllllllllllIIIlIIlIlIIIllIIlIl);
        }
        if ("Village".equals(lllllllllllllIIIlIIlIlIIIllIIlll) && this.villageGenerator != null) {
            return this.villageGenerator.getClosestStrongholdPos(lllllllllllllIIIlIIlIlIIIllIlIII, lllllllllllllIIIlIIlIlIIIllIIllI, lllllllllllllIIIlIIlIlIIIllIIlIl);
        }
        if ("Mineshaft".equals(lllllllllllllIIIlIIlIlIIIllIIlll) && this.mineshaftGenerator != null) {
            return this.mineshaftGenerator.getClosestStrongholdPos(lllllllllllllIIIlIIlIlIIIllIlIII, lllllllllllllIIIlIIlIlIIIllIIllI, lllllllllllllIIIlIIlIlIIIllIIlIl);
        }
        return ("Temple".equals(lllllllllllllIIIlIIlIlIIIllIIlll) && this.scatteredFeatureGenerator != null) ? this.scatteredFeatureGenerator.getClosestStrongholdPos(lllllllllllllIIIlIIlIlIIIllIlIII, lllllllllllllIIIlIIlIlIIIllIIllI, lllllllllllllIIIlIIlIlIIIllIIlIl) : null;
    }
}
