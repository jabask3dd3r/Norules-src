package net.minecraft.world.biome;

import net.minecraft.world.gen.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.math.*;
import org.apache.logging.log4j.*;
import net.minecraft.init.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.gen.feature.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;

public abstract class Biome
{
    protected /* synthetic */ List<SpawnListEntry> spawnableWaterCreatureList;
    private final /* synthetic */ float temperature;
    protected static final /* synthetic */ NoiseGeneratorPerlin TEMPERATURE_NOISE;
    protected static final /* synthetic */ IBlockState WATER;
    private final /* synthetic */ int waterColor;
    public /* synthetic */ IBlockState topBlock;
    protected static final /* synthetic */ IBlockState ICE;
    protected static final /* synthetic */ WorldGenBigTree BIG_TREE_FEATURE;
    protected static final /* synthetic */ IBlockState GRAVEL;
    @Nullable
    private final /* synthetic */ String baseBiomeRegName;
    protected static final /* synthetic */ IBlockState BEDROCK;
    public static final /* synthetic */ ObjectIntIdentityMap<Biome> MUTATION_TO_BASE_ID_MAP;
    protected static final /* synthetic */ IBlockState STONE;
    private final /* synthetic */ boolean enableSnow;
    private final /* synthetic */ float baseHeight;
    protected /* synthetic */ List<SpawnListEntry> spawnableCaveCreatureList;
    protected static final /* synthetic */ WorldGenTrees TREE_FEATURE;
    private final /* synthetic */ String biomeName;
    private final /* synthetic */ boolean enableRain;
    protected static final /* synthetic */ IBlockState RED_SANDSTONE;
    protected static final /* synthetic */ IBlockState SANDSTONE;
    public static final /* synthetic */ RegistryNamespaced<ResourceLocation, Biome> REGISTRY;
    protected /* synthetic */ List<SpawnListEntry> spawnableMonsterList;
    private final /* synthetic */ float rainfall;
    protected /* synthetic */ List<SpawnListEntry> spawnableCreatureList;
    private final /* synthetic */ float heightVariation;
    public /* synthetic */ BiomeDecorator theBiomeDecorator;
    public /* synthetic */ IBlockState fillerBlock;
    protected static final /* synthetic */ IBlockState AIR;
    
    public final boolean isSnowyBiome() {
        return this.enableSnow;
    }
    
    @Nullable
    public static Biome getBiome(final int lllllllllllllIIIlllllIIIllllIIlI) {
        return getBiome(lllllllllllllIIIlllllIIIllllIIlI, null);
    }
    
    public boolean canRain() {
        return !this.isSnowyBiome() && this.enableRain;
    }
    
    public boolean getEnableSnow() {
        return this.isSnowyBiome();
    }
    
    public final float getFloatTemperature(final BlockPos lllllllllllllIIIlllllIIlIllIlIlI) {
        if (lllllllllllllIIIlllllIIlIllIlIlI.getY() > 64) {
            final float lllllllllllllIIIlllllIIlIllIlIIl = (float)(Biome.TEMPERATURE_NOISE.getValue(lllllllllllllIIIlllllIIlIllIlIlI.getX() / 8.0f, lllllllllllllIIIlllllIIlIllIlIlI.getZ() / 8.0f) * 4.0);
            return this.getTemperature() - (lllllllllllllIIIlllllIIlIllIlIIl + lllllllllllllIIIlllllIIlIllIlIlI.getY() - 64.0f) * 0.05f / 30.0f;
        }
        return this.getTemperature();
    }
    
    public int getSkyColorByTemp(float lllllllllllllIIIlllllIIlIlllllll) {
        lllllllllllllIIIlllllIIlIlllllll /= 3.0f;
        lllllllllllllIIIlllllIIlIlllllll = MathHelper.clamp(lllllllllllllIIIlllllIIlIlllllll, -1.0f, 1.0f);
        return MathHelper.hsvToRGB(0.62222224f - lllllllllllllIIIlllllIIlIlllllll * 0.05f, 0.5f + lllllllllllllIIIlllllIIlIlllllll * 0.1f, 1.0f);
    }
    
    public final float getRainfall() {
        return this.rainfall;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        STONE = Blocks.STONE.getDefaultState();
        AIR = Blocks.AIR.getDefaultState();
        BEDROCK = Blocks.BEDROCK.getDefaultState();
        GRAVEL = Blocks.GRAVEL.getDefaultState();
        RED_SANDSTONE = Blocks.RED_SANDSTONE.getDefaultState();
        SANDSTONE = Blocks.SANDSTONE.getDefaultState();
        ICE = Blocks.ICE.getDefaultState();
        WATER = Blocks.WATER.getDefaultState();
        MUTATION_TO_BASE_ID_MAP = new ObjectIntIdentityMap<Biome>();
        TEMPERATURE_NOISE = new NoiseGeneratorPerlin(new Random(1234L), 1);
        GRASS_COLOR_NOISE = new NoiseGeneratorPerlin(new Random(2345L), 1);
        DOUBLE_PLANT_GENERATOR = new WorldGenDoublePlant();
        TREE_FEATURE = new WorldGenTrees(false);
        BIG_TREE_FEATURE = new WorldGenBigTree(false);
        SWAMP_FEATURE = new WorldGenSwamp();
        REGISTRY = new RegistryNamespaced<ResourceLocation, Biome>();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$EnumCreatureType() {
        final int[] $switch_TABLE$net$minecraft$entity$EnumCreatureType = Biome.$SWITCH_TABLE$net$minecraft$entity$EnumCreatureType;
        if ($switch_TABLE$net$minecraft$entity$EnumCreatureType != null) {
            return $switch_TABLE$net$minecraft$entity$EnumCreatureType;
        }
        final float lllllllllllllIIIlllllIIIllIIIlll = (Object)new int[EnumCreatureType.values().length];
        try {
            lllllllllllllIIIlllllIIIllIIIlll[EnumCreatureType.AMBIENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIlllllIIIllIIIlll[EnumCreatureType.CREATURE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIlllllIIIllIIIlll[EnumCreatureType.MONSTER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIlllllIIIllIIIlll[EnumCreatureType.WATER_CREATURE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Biome.$SWITCH_TABLE$net$minecraft$entity$EnumCreatureType = (int[])(Object)lllllllllllllIIIlllllIIIllIIIlll;
    }
    
    public void genTerrainBlocks(final World lllllllllllllIIIlllllIIlIIlllIIl, final Random lllllllllllllIIIlllllIIlIIllIIIl, final ChunkPrimer lllllllllllllIIIlllllIIlIIllIIII, final int lllllllllllllIIIlllllIIlIIlIllll, final int lllllllllllllIIIlllllIIlIIllIlIl, final double lllllllllllllIIIlllllIIlIIllIlII) {
        this.generateBiomeTerrain(lllllllllllllIIIlllllIIlIIlllIIl, lllllllllllllIIIlllllIIlIIllIIIl, lllllllllllllIIIlllllIIlIIllIIII, lllllllllllllIIIlllllIIlIIlIllll, lllllllllllllIIIlllllIIlIIllIlIl, lllllllllllllIIIlllllIIlIIllIlII);
    }
    
    @Nullable
    public static Biome getBiomeForId(final int lllllllllllllIIIlllllIIllIIllIll) {
        return Biome.REGISTRY.getObjectById(lllllllllllllIIIlllllIIllIIllIll);
    }
    
    public float getSpawningChance() {
        return 0.1f;
    }
    
    protected BiomeDecorator createBiomeDecorator() {
        return new BiomeDecorator();
    }
    
    public final float getBaseHeight() {
        return this.baseHeight;
    }
    
    public boolean isHighHumidity() {
        return this.getRainfall() > 0.85f;
    }
    
    public final int getWaterColor() {
        return this.waterColor;
    }
    
    public static void registerBiomes() {
        registerBiome(0, "ocean", new BiomeOcean(new BiomeProperties("Ocean").setBaseHeight(-1.0f).setHeightVariation(0.1f)));
        registerBiome(1, "plains", new BiomePlains(false, new BiomeProperties("Plains").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(0.8f).setRainfall(0.4f)));
        registerBiome(2, "desert", new BiomeDesert(new BiomeProperties("Desert").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(3, "extreme_hills", new BiomeHills(BiomeHills.Type.NORMAL, new BiomeProperties("Extreme Hills").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(4, "forest", new BiomeForest(BiomeForest.Type.NORMAL, new BiomeProperties("Forest").setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(5, "taiga", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Taiga").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(6, "swampland", new BiomeSwamp(new BiomeProperties("Swampland").setBaseHeight(-0.2f).setHeightVariation(0.1f).setTemperature(0.8f).setRainfall(0.9f).setWaterColor(14745518)));
        registerBiome(7, "river", new BiomeRiver(new BiomeProperties("River").setBaseHeight(-0.5f).setHeightVariation(0.0f)));
        registerBiome(8, "hell", new BiomeHell(new BiomeProperties("Hell").setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(9, "sky", new BiomeEnd(new BiomeProperties("The End").setRainDisabled()));
        registerBiome(10, "frozen_ocean", new BiomeOcean(new BiomeProperties("FrozenOcean").setBaseHeight(-1.0f).setHeightVariation(0.1f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(11, "frozen_river", new BiomeRiver(new BiomeProperties("FrozenRiver").setBaseHeight(-0.5f).setHeightVariation(0.0f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(12, "ice_flats", new BiomeSnow(false, new BiomeProperties("Ice Plains").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(13, "ice_mountains", new BiomeSnow(false, new BiomeProperties("Ice Mountains").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(14, "mushroom_island", new BiomeMushroomIsland(new BiomeProperties("MushroomIsland").setBaseHeight(0.2f).setHeightVariation(0.3f).setTemperature(0.9f).setRainfall(1.0f)));
        registerBiome(15, "mushroom_island_shore", new BiomeMushroomIsland(new BiomeProperties("MushroomIslandShore").setBaseHeight(0.0f).setHeightVariation(0.025f).setTemperature(0.9f).setRainfall(1.0f)));
        registerBiome(16, "beaches", new BiomeBeach(new BiomeProperties("Beach").setBaseHeight(0.0f).setHeightVariation(0.025f).setTemperature(0.8f).setRainfall(0.4f)));
        registerBiome(17, "desert_hills", new BiomeDesert(new BiomeProperties("DesertHills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(18, "forest_hills", new BiomeForest(BiomeForest.Type.NORMAL, new BiomeProperties("ForestHills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(19, "taiga_hills", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("TaigaHills").setTemperature(0.25f).setRainfall(0.8f).setBaseHeight(0.45f).setHeightVariation(0.3f)));
        registerBiome(20, "smaller_extreme_hills", new BiomeHills(BiomeHills.Type.EXTRA_TREES, new BiomeProperties("Extreme Hills Edge").setBaseHeight(0.8f).setHeightVariation(0.3f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(21, "jungle", new BiomeJungle(false, new BiomeProperties("Jungle").setTemperature(0.95f).setRainfall(0.9f)));
        registerBiome(22, "jungle_hills", new BiomeJungle(false, new BiomeProperties("JungleHills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.95f).setRainfall(0.9f)));
        registerBiome(23, "jungle_edge", new BiomeJungle(true, new BiomeProperties("JungleEdge").setTemperature(0.95f).setRainfall(0.8f)));
        registerBiome(24, "deep_ocean", new BiomeOcean(new BiomeProperties("Deep Ocean").setBaseHeight(-1.8f).setHeightVariation(0.1f)));
        registerBiome(25, "stone_beach", new BiomeStoneBeach(new BiomeProperties("Stone Beach").setBaseHeight(0.1f).setHeightVariation(0.8f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(26, "cold_beach", new BiomeBeach(new BiomeProperties("Cold Beach").setBaseHeight(0.0f).setHeightVariation(0.025f).setTemperature(0.05f).setRainfall(0.3f).setSnowEnabled()));
        registerBiome(27, "birch_forest", new BiomeForest(BiomeForest.Type.BIRCH, new BiomeProperties("Birch Forest").setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(28, "birch_forest_hills", new BiomeForest(BiomeForest.Type.BIRCH, new BiomeProperties("Birch Forest Hills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(29, "roofed_forest", new BiomeForest(BiomeForest.Type.ROOFED, new BiomeProperties("Roofed Forest").setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(30, "taiga_cold", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Cold Taiga").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(-0.5f).setRainfall(0.4f).setSnowEnabled()));
        registerBiome(31, "taiga_cold_hills", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Cold Taiga Hills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(-0.5f).setRainfall(0.4f).setSnowEnabled()));
        registerBiome(32, "redwood_taiga", new BiomeTaiga(BiomeTaiga.Type.MEGA, new BiomeProperties("Mega Taiga").setTemperature(0.3f).setRainfall(0.8f).setBaseHeight(0.2f).setHeightVariation(0.2f)));
        registerBiome(33, "redwood_taiga_hills", new BiomeTaiga(BiomeTaiga.Type.MEGA, new BiomeProperties("Mega Taiga Hills").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(0.3f).setRainfall(0.8f)));
        registerBiome(34, "extreme_hills_with_trees", new BiomeHills(BiomeHills.Type.EXTRA_TREES, new BiomeProperties("Extreme Hills+").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(35, "savanna", new BiomeSavanna(new BiomeProperties("Savanna").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(1.2f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(36, "savanna_rock", new BiomeSavanna(new BiomeProperties("Savanna Plateau").setBaseHeight(1.5f).setHeightVariation(0.025f).setTemperature(1.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(37, "mesa", new BiomeMesa(false, false, new BiomeProperties("Mesa").setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(38, "mesa_rock", new BiomeMesa(false, true, new BiomeProperties("Mesa Plateau F").setBaseHeight(1.5f).setHeightVariation(0.025f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(39, "mesa_clear_rock", new BiomeMesa(false, false, new BiomeProperties("Mesa Plateau").setBaseHeight(1.5f).setHeightVariation(0.025f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(127, "void", new BiomeVoid(new BiomeProperties("The Void").setRainDisabled()));
        registerBiome(129, "mutated_plains", new BiomePlains(true, new BiomeProperties("Sunflower Plains").setBaseBiome("plains").setBaseHeight(0.125f).setHeightVariation(0.05f).setTemperature(0.8f).setRainfall(0.4f)));
        registerBiome(130, "mutated_desert", new BiomeDesert(new BiomeProperties("Desert M").setBaseBiome("desert").setBaseHeight(0.225f).setHeightVariation(0.25f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(131, "mutated_extreme_hills", new BiomeHills(BiomeHills.Type.MUTATED, new BiomeProperties("Extreme Hills M").setBaseBiome("extreme_hills").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(132, "mutated_forest", new BiomeForest(BiomeForest.Type.FLOWER, new BiomeProperties("Flower Forest").setBaseBiome("forest").setHeightVariation(0.4f).setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(133, "mutated_taiga", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Taiga M").setBaseBiome("taiga").setBaseHeight(0.3f).setHeightVariation(0.4f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(134, "mutated_swampland", new BiomeSwamp(new BiomeProperties("Swampland M").setBaseBiome("swampland").setBaseHeight(-0.1f).setHeightVariation(0.3f).setTemperature(0.8f).setRainfall(0.9f).setWaterColor(14745518)));
        registerBiome(140, "mutated_ice_flats", new BiomeSnow(true, new BiomeProperties("Ice Plains Spikes").setBaseBiome("ice_flats").setBaseHeight(0.425f).setHeightVariation(0.45000002f).setTemperature(0.0f).setRainfall(0.5f).setSnowEnabled()));
        registerBiome(149, "mutated_jungle", new BiomeJungle(false, new BiomeProperties("Jungle M").setBaseBiome("jungle").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.95f).setRainfall(0.9f)));
        registerBiome(151, "mutated_jungle_edge", new BiomeJungle(true, new BiomeProperties("JungleEdge M").setBaseBiome("jungle_edge").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.95f).setRainfall(0.8f)));
        registerBiome(155, "mutated_birch_forest", new BiomeForestMutated(new BiomeProperties("Birch Forest M").setBaseBiome("birch_forest").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(156, "mutated_birch_forest_hills", new BiomeForestMutated(new BiomeProperties("Birch Forest Hills M").setBaseBiome("birch_forest_hills").setBaseHeight(0.55f).setHeightVariation(0.5f).setTemperature(0.6f).setRainfall(0.6f)));
        registerBiome(157, "mutated_roofed_forest", new BiomeForest(BiomeForest.Type.ROOFED, new BiomeProperties("Roofed Forest M").setBaseBiome("roofed_forest").setBaseHeight(0.2f).setHeightVariation(0.4f).setTemperature(0.7f).setRainfall(0.8f)));
        registerBiome(158, "mutated_taiga_cold", new BiomeTaiga(BiomeTaiga.Type.NORMAL, new BiomeProperties("Cold Taiga M").setBaseBiome("taiga_cold").setBaseHeight(0.3f).setHeightVariation(0.4f).setTemperature(-0.5f).setRainfall(0.4f).setSnowEnabled()));
        registerBiome(160, "mutated_redwood_taiga", new BiomeTaiga(BiomeTaiga.Type.MEGA_SPRUCE, new BiomeProperties("Mega Spruce Taiga").setBaseBiome("redwood_taiga").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(161, "mutated_redwood_taiga_hills", new BiomeTaiga(BiomeTaiga.Type.MEGA_SPRUCE, new BiomeProperties("Redwood Taiga Hills M").setBaseBiome("redwood_taiga_hills").setBaseHeight(0.2f).setHeightVariation(0.2f).setTemperature(0.25f).setRainfall(0.8f)));
        registerBiome(162, "mutated_extreme_hills_with_trees", new BiomeHills(BiomeHills.Type.MUTATED, new BiomeProperties("Extreme Hills+ M").setBaseBiome("extreme_hills_with_trees").setBaseHeight(1.0f).setHeightVariation(0.5f).setTemperature(0.2f).setRainfall(0.3f)));
        registerBiome(163, "mutated_savanna", new BiomeSavannaMutated(new BiomeProperties("Savanna M").setBaseBiome("savanna").setBaseHeight(0.3625f).setHeightVariation(1.225f).setTemperature(1.1f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(164, "mutated_savanna_rock", new BiomeSavannaMutated(new BiomeProperties("Savanna Plateau M").setBaseBiome("savanna_rock").setBaseHeight(1.05f).setHeightVariation(1.2125001f).setTemperature(1.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(165, "mutated_mesa", new BiomeMesa(true, false, new BiomeProperties("Mesa (Bryce)").setBaseBiome("mesa").setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(166, "mutated_mesa_rock", new BiomeMesa(false, true, new BiomeProperties("Mesa Plateau F M").setBaseBiome("mesa_rock").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
        registerBiome(167, "mutated_mesa_clear_rock", new BiomeMesa(false, false, new BiomeProperties("Mesa Plateau M").setBaseBiome("mesa_clear_rock").setBaseHeight(0.45f).setHeightVariation(0.3f).setTemperature(2.0f).setRainfall(0.0f).setRainDisabled()));
    }
    
    public WorldGenAbstractTree genBigTreeChance(final Random lllllllllllllIIIlllllIIllIIIlIll) {
        return (lllllllllllllIIIlllllIIllIIIlIll.nextInt(10) == 0) ? Biome.BIG_TREE_FEATURE : Biome.TREE_FEATURE;
    }
    
    public final void generateBiomeTerrain(final World lllllllllllllIIIlllllIIlIIIIlIIl, final Random lllllllllllllIIIlllllIIlIIIllIIl, final ChunkPrimer lllllllllllllIIIlllllIIlIIIllIII, final int lllllllllllllIIIlllllIIlIIIIIllI, final int lllllllllllllIIIlllllIIlIIIlIllI, final double lllllllllllllIIIlllllIIlIIIIIlII) {
        final int lllllllllllllIIIlllllIIlIIIlIlII = lllllllllllllIIIlllllIIlIIIIlIIl.getSeaLevel();
        IBlockState lllllllllllllIIIlllllIIlIIIlIIll = this.topBlock;
        IBlockState lllllllllllllIIIlllllIIlIIIlIIlI = this.fillerBlock;
        int lllllllllllllIIIlllllIIlIIIlIIIl = -1;
        final int lllllllllllllIIIlllllIIlIIIlIIII = (int)(lllllllllllllIIIlllllIIlIIIIIlII / 3.0 + 3.0 + lllllllllllllIIIlllllIIlIIIllIIl.nextDouble() * 0.25);
        final int lllllllllllllIIIlllllIIlIIIIllll = lllllllllllllIIIlllllIIlIIIIIllI & 0xF;
        final int lllllllllllllIIIlllllIIlIIIIlllI = lllllllllllllIIIlllllIIlIIIlIllI & 0xF;
        final BlockPos.MutableBlockPos lllllllllllllIIIlllllIIlIIIIllIl = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIIIlllllIIlIIIIllII = 255; lllllllllllllIIIlllllIIlIIIIllII >= 0; --lllllllllllllIIIlllllIIlIIIIllII) {
            if (lllllllllllllIIIlllllIIlIIIIllII <= lllllllllllllIIIlllllIIlIIIllIIl.nextInt(5)) {
                lllllllllllllIIIlllllIIlIIIllIII.setBlockState(lllllllllllllIIIlllllIIlIIIIlllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIIllll, Biome.BEDROCK);
            }
            else {
                final IBlockState lllllllllllllIIIlllllIIlIIIIlIll = lllllllllllllIIIlllllIIlIIIllIII.getBlockState(lllllllllllllIIIlllllIIlIIIIlllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIIllll);
                if (lllllllllllllIIIlllllIIlIIIIlIll.getMaterial() == Material.AIR) {
                    lllllllllllllIIIlllllIIlIIIlIIIl = -1;
                }
                else if (lllllllllllllIIIlllllIIlIIIIlIll.getBlock() == Blocks.STONE) {
                    if (lllllllllllllIIIlllllIIlIIIlIIIl == -1) {
                        if (lllllllllllllIIIlllllIIlIIIlIIII <= 0) {
                            lllllllllllllIIIlllllIIlIIIlIIll = Biome.AIR;
                            lllllllllllllIIIlllllIIlIIIlIIlI = Biome.STONE;
                        }
                        else if (lllllllllllllIIIlllllIIlIIIIllII >= lllllllllllllIIIlllllIIlIIIlIlII - 4 && lllllllllllllIIIlllllIIlIIIIllII <= lllllllllllllIIIlllllIIlIIIlIlII + 1) {
                            lllllllllllllIIIlllllIIlIIIlIIll = this.topBlock;
                            lllllllllllllIIIlllllIIlIIIlIIlI = this.fillerBlock;
                        }
                        if (lllllllllllllIIIlllllIIlIIIIllII < lllllllllllllIIIlllllIIlIIIlIlII && (lllllllllllllIIIlllllIIlIIIlIIll == null || lllllllllllllIIIlllllIIlIIIlIIll.getMaterial() == Material.AIR)) {
                            if (this.getFloatTemperature(lllllllllllllIIIlllllIIlIIIIllIl.setPos(lllllllllllllIIIlllllIIlIIIIIllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIlIllI)) < 0.15f) {
                                lllllllllllllIIIlllllIIlIIIlIIll = Biome.ICE;
                            }
                            else {
                                lllllllllllllIIIlllllIIlIIIlIIll = Biome.WATER;
                            }
                        }
                        lllllllllllllIIIlllllIIlIIIlIIIl = lllllllllllllIIIlllllIIlIIIlIIII;
                        if (lllllllllllllIIIlllllIIlIIIIllII >= lllllllllllllIIIlllllIIlIIIlIlII - 1) {
                            lllllllllllllIIIlllllIIlIIIllIII.setBlockState(lllllllllllllIIIlllllIIlIIIIlllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIIllll, lllllllllllllIIIlllllIIlIIIlIIll);
                        }
                        else if (lllllllllllllIIIlllllIIlIIIIllII < lllllllllllllIIIlllllIIlIIIlIlII - 7 - lllllllllllllIIIlllllIIlIIIlIIII) {
                            lllllllllllllIIIlllllIIlIIIlIIll = Biome.AIR;
                            lllllllllllllIIIlllllIIlIIIlIIlI = Biome.STONE;
                            lllllllllllllIIIlllllIIlIIIllIII.setBlockState(lllllllllllllIIIlllllIIlIIIIlllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIIllll, Biome.GRAVEL);
                        }
                        else {
                            lllllllllllllIIIlllllIIlIIIllIII.setBlockState(lllllllllllllIIIlllllIIlIIIIlllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIIllll, lllllllllllllIIIlllllIIlIIIlIIlI);
                        }
                    }
                    else if (lllllllllllllIIIlllllIIlIIIlIIIl > 0) {
                        --lllllllllllllIIIlllllIIlIIIlIIIl;
                        lllllllllllllIIIlllllIIlIIIllIII.setBlockState(lllllllllllllIIIlllllIIlIIIIlllI, lllllllllllllIIIlllllIIlIIIIllII, lllllllllllllIIIlllllIIlIIIIllll, lllllllllllllIIIlllllIIlIIIlIIlI);
                        if (lllllllllllllIIIlllllIIlIIIlIIIl == 0 && lllllllllllllIIIlllllIIlIIIlIIlI.getBlock() == Blocks.SAND && lllllllllllllIIIlllllIIlIIIlIIII > 1) {
                            lllllllllllllIIIlllllIIlIIIlIIIl = lllllllllllllIIIlllllIIlIIIllIIl.nextInt(4) + Math.max(0, lllllllllllllIIIlllllIIlIIIIllII - 63);
                            lllllllllllllIIIlllllIIlIIIlIIlI = ((lllllllllllllIIIlllllIIlIIIlIIlI.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND) ? Biome.RED_SANDSTONE : Biome.SANDSTONE);
                        }
                    }
                }
            }
        }
    }
    
    private static void registerBiome(final int lllllllllllllIIIlllllIIIllIIlllI, final String lllllllllllllIIIlllllIIIllIIllIl, final Biome lllllllllllllIIIlllllIIIllIIllII) {
        Biome.REGISTRY.register(lllllllllllllIIIlllllIIIllIIlllI, new ResourceLocation(lllllllllllllIIIlllllIIIllIIllIl), lllllllllllllIIIlllllIIIllIIllII);
        if (lllllllllllllIIIlllllIIIllIIllII.isMutation()) {
            Biome.MUTATION_TO_BASE_ID_MAP.put(lllllllllllllIIIlllllIIIllIIllII, getIdForBiome(Biome.REGISTRY.getObject(new ResourceLocation(lllllllllllllIIIlllllIIIllIIllII.baseBiomeRegName))));
        }
    }
    
    public final float getTemperature() {
        return this.temperature;
    }
    
    @Nullable
    public static Biome getMutationForBiome(final Biome lllllllllllllIIIlllllIIllIIllIIl) {
        return Biome.MUTATION_TO_BASE_ID_MAP.getByValue(getIdForBiome(lllllllllllllIIIlllllIIllIIllIIl));
    }
    
    public final float getHeightVariation() {
        return this.heightVariation;
    }
    
    public WorldGenerator getRandomWorldGenForGrass(final Random lllllllllllllIIIlllllIIllIIIlIII) {
        return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }
    
    public List<SpawnListEntry> getSpawnableList(final EnumCreatureType lllllllllllllIIIlllllIIlIllllIll) {
        switch ($SWITCH_TABLE$net$minecraft$entity$EnumCreatureType()[lllllllllllllIIIlllllIIlIllllIll.ordinal()]) {
            case 1: {
                return this.spawnableMonsterList;
            }
            case 2: {
                return this.spawnableCreatureList;
            }
            case 4: {
                return this.spawnableWaterCreatureList;
            }
            case 3: {
                return this.spawnableCaveCreatureList;
            }
            default: {
                return Collections.emptyList();
            }
        }
    }
    
    public int getGrassColorAtPos(final BlockPos lllllllllllllIIIlllllIIlIlIlIlII) {
        final double lllllllllllllIIIlllllIIlIlIlIIll = MathHelper.clamp(this.getFloatTemperature(lllllllllllllIIIlllllIIlIlIlIlII), 0.0f, 1.0f);
        final double lllllllllllllIIIlllllIIlIlIlIIlI = MathHelper.clamp(this.getRainfall(), 0.0f, 1.0f);
        return ColorizerGrass.getGrassColor(lllllllllllllIIIlllllIIlIlIlIIll, lllllllllllllIIIlllllIIlIlIlIIlI);
    }
    
    public TempCategory getTempCategory() {
        if (this.getTemperature() < 0.2) {
            return TempCategory.COLD;
        }
        return (this.getTemperature() < 1.0) ? TempCategory.MEDIUM : TempCategory.WARM;
    }
    
    public int getFoliageColorAtPos(final BlockPos lllllllllllllIIIlllllIIlIlIIlIII) {
        final double lllllllllllllIIIlllllIIlIlIIIlll = MathHelper.clamp(this.getFloatTemperature(lllllllllllllIIIlllllIIlIlIIlIII), 0.0f, 1.0f);
        final double lllllllllllllIIIlllllIIlIlIIIllI = MathHelper.clamp(this.getRainfall(), 0.0f, 1.0f);
        return ColorizerFoliage.getFoliageColor(lllllllllllllIIIlllllIIlIlIIIlll, lllllllllllllIIIlllllIIlIlIIIllI);
    }
    
    public BlockFlower.EnumFlowerType pickRandomFlower(final Random lllllllllllllIIIlllllIIllIIIIIll, final BlockPos lllllllllllllIIIlllllIIllIIIIlII) {
        return (lllllllllllllIIIlllllIIllIIIIIll.nextInt(3) > 0) ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
    }
    
    protected Biome(final BiomeProperties lllllllllllllIIIlllllIIllIIlIlII) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        this.spawnableMonsterList = (List<SpawnListEntry>)Lists.newArrayList();
        this.spawnableCreatureList = (List<SpawnListEntry>)Lists.newArrayList();
        this.spawnableWaterCreatureList = (List<SpawnListEntry>)Lists.newArrayList();
        this.spawnableCaveCreatureList = (List<SpawnListEntry>)Lists.newArrayList();
        this.biomeName = lllllllllllllIIIlllllIIllIIlIlII.biomeName;
        this.baseHeight = lllllllllllllIIIlllllIIllIIlIlII.baseHeight;
        this.heightVariation = lllllllllllllIIIlllllIIllIIlIlII.heightVariation;
        this.temperature = lllllllllllllIIIlllllIIllIIlIlII.temperature;
        this.rainfall = lllllllllllllIIIlllllIIllIIlIlII.rainfall;
        this.waterColor = lllllllllllllIIIlllllIIllIIlIlII.waterColor;
        this.enableSnow = lllllllllllllIIIlllllIIllIIlIlII.enableSnow;
        this.enableRain = lllllllllllllIIIlllllIIllIIlIlII.enableRain;
        this.baseBiomeRegName = lllllllllllllIIIlllllIIllIIlIlII.baseBiomeRegName;
        this.theBiomeDecorator = this.createBiomeDecorator();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 95, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieVillager.class, 5, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
    }
    
    public final String getBiomeName() {
        return this.biomeName;
    }
    
    public void decorate(final World lllllllllllllIIIlllllIIlIllIIIII, final Random lllllllllllllIIIlllllIIlIlIlllll, final BlockPos lllllllllllllIIIlllllIIlIlIllIlI) {
        this.theBiomeDecorator.decorate(lllllllllllllIIIlllllIIlIllIIIII, lllllllllllllIIIlllllIIlIlIlllll, this, lllllllllllllIIIlllllIIlIlIllIlI);
    }
    
    public Class<? extends Biome> getBiomeClass() {
        return this.getClass();
    }
    
    public static int getIdForBiome(final Biome lllllllllllllIIIlllllIIllIIlllll) {
        return Biome.REGISTRY.getIDForObject(lllllllllllllIIIlllllIIllIIlllll);
    }
    
    public static Biome getBiome(final int lllllllllllllIIIlllllIIIlllIlIlI, final Biome lllllllllllllIIIlllllIIIlllIllII) {
        final Biome lllllllllllllIIIlllllIIIlllIlIll = getBiomeForId(lllllllllllllIIIlllllIIIlllIlIlI);
        return (lllllllllllllIIIlllllIIIlllIlIll == null) ? lllllllllllllIIIlllllIIIlllIllII : lllllllllllllIIIlllllIIIlllIlIll;
    }
    
    public boolean isMutation() {
        return this.baseBiomeRegName != null;
    }
    
    public boolean ignorePlayerSpawnSuitability() {
        return false;
    }
    
    public static class BiomeProperties
    {
        private /* synthetic */ float heightVariation;
        private final /* synthetic */ String biomeName;
        private /* synthetic */ float rainfall;
        private /* synthetic */ int waterColor;
        private /* synthetic */ float temperature;
        @Nullable
        private /* synthetic */ String baseBiomeRegName;
        private /* synthetic */ boolean enableSnow;
        private /* synthetic */ float baseHeight;
        private /* synthetic */ boolean enableRain;
        
        protected BiomeProperties setTemperature(final float lllllllllllllIIIlIIIlIlIllllIlll) {
            if (lllllllllllllIIIlIIIlIlIllllIlll > 0.1f && lllllllllllllIIIlIIIlIlIllllIlll < 0.2f) {
                throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
            }
            this.temperature = lllllllllllllIIIlIIIlIlIllllIlll;
            return this;
        }
        
        protected BiomeProperties setSnowEnabled() {
            this.enableSnow = true;
            return this;
        }
        
        protected BiomeProperties setRainfall(final float lllllllllllllIIIlIIIlIlIlllIlIII) {
            this.rainfall = lllllllllllllIIIlIIIlIlIlllIlIII;
            return this;
        }
        
        protected BiomeProperties setWaterColor(final int lllllllllllllIIIlIIIlIlIlIlIllIl) {
            this.waterColor = lllllllllllllIIIlIIIlIlIlIlIllIl;
            return this;
        }
        
        protected BiomeProperties setHeightVariation(final float lllllllllllllIIIlIIIlIlIllIIllll) {
            this.heightVariation = lllllllllllllIIIlIIIlIlIllIIllll;
            return this;
        }
        
        public BiomeProperties(final String lllllllllllllIIIlIIIlIllIIIIIIII) {
            this.baseHeight = 0.1f;
            this.heightVariation = 0.2f;
            this.temperature = 0.5f;
            this.rainfall = 0.5f;
            this.waterColor = 16777215;
            this.enableRain = true;
            this.biomeName = lllllllllllllIIIlIIIlIllIIIIIIII;
        }
        
        protected BiomeProperties setBaseBiome(final String lllllllllllllIIIlIIIlIlIlIlIIllI) {
            this.baseBiomeRegName = lllllllllllllIIIlIIIlIlIlIlIIllI;
            return this;
        }
        
        protected BiomeProperties setBaseHeight(final float lllllllllllllIIIlIIIlIlIlllIIIII) {
            this.baseHeight = lllllllllllllIIIlIIIlIlIlllIIIII;
            return this;
        }
        
        protected BiomeProperties setRainDisabled() {
            this.enableRain = false;
            return this;
        }
    }
    
    public static class SpawnListEntry extends WeightedRandom.Item
    {
        public /* synthetic */ int minGroupCount;
        public /* synthetic */ int maxGroupCount;
        public /* synthetic */ Class<? extends EntityLiving> entityClass;
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder(String.valueOf(this.entityClass.getSimpleName())).append("*(").append(this.minGroupCount).append("-").append(this.maxGroupCount).append("):").append(this.itemWeight));
        }
        
        public SpawnListEntry(final Class<? extends EntityLiving> llllllllllllllIIIlIlIllllIlllIlI, final int llllllllllllllIIIlIlIllllIlllIIl, final int llllllllllllllIIIlIlIllllIllIIll, final int llllllllllllllIIIlIlIllllIllIIlI) {
            super(llllllllllllllIIIlIlIllllIlllIIl);
            this.entityClass = llllllllllllllIIIlIlIllllIlllIlI;
            this.minGroupCount = llllllllllllllIIIlIlIllllIllIIll;
            this.maxGroupCount = llllllllllllllIIIlIlIllllIllIIlI;
        }
    }
    
    public enum TempCategory
    {
        WARM("WARM", 3), 
        COLD("COLD", 1), 
        MEDIUM("MEDIUM", 2), 
        OCEAN("OCEAN", 0);
        
        private TempCategory(final String llllllllllllllIlIIIlIllIIllIlIlI, final int llllllllllllllIlIIIlIllIIllIlIIl) {
        }
    }
}
