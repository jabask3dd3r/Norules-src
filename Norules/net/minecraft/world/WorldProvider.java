package net.minecraft.world;

import net.minecraft.world.gen.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.border.*;
import javax.annotation.*;

public abstract class WorldProvider
{
    private final /* synthetic */ float[] colorsSunriseSunset;
    private /* synthetic */ WorldType terrainType;
    protected final /* synthetic */ float[] lightBrightnessTable;
    private /* synthetic */ String generatorSettings;
    protected /* synthetic */ boolean field_191067_f;
    protected /* synthetic */ boolean hasNoSky;
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ boolean isHellWorld;
    protected /* synthetic */ BiomeProvider biomeProvider;
    
    public float calculateCelestialAngle(final long llllllllllllllIlIIIlIllllIIIlIIl, final float llllllllllllllIlIIIlIllllIIIllIl) {
        final int llllllllllllllIlIIIlIllllIIIllII = (int)(llllllllllllllIlIIIlIllllIIIlIIl % 24000L);
        float llllllllllllllIlIIIlIllllIIIlIll = (llllllllllllllIlIIIlIllllIIIllII + llllllllllllllIlIIIlIllllIIIllIl) / 24000.0f - 0.25f;
        if (llllllllllllllIlIIIlIllllIIIlIll < 0.0f) {
            ++llllllllllllllIlIIIlIllllIIIlIll;
        }
        if (llllllllllllllIlIIIlIllllIIIlIll > 1.0f) {
            --llllllllllllllIlIIIlIllllIIIlIll;
        }
        final float llllllllllllllIlIIIlIllllIIIlIlI = 1.0f - (float)((Math.cos(llllllllllllllIlIIIlIllllIIIlIll * 3.141592653589793) + 1.0) / 2.0);
        llllllllllllllIlIIIlIllllIIIlIll += (llllllllllllllIlIIIlIllllIIIlIlI - llllllllllllllIlIIIlIllllIIIlIll) / 3.0f;
        return llllllllllllllIlIIIlIllllIIIlIll;
    }
    
    public Vec3d getFogColor(final float llllllllllllllIlIIIlIlllIlIlllIl, final float llllllllllllllIlIIIlIlllIllIIIlI) {
        float llllllllllllllIlIIIlIlllIllIIIIl = MathHelper.cos(llllllllllllllIlIIIlIlllIlIlllIl * 6.2831855f) * 2.0f + 0.5f;
        llllllllllllllIlIIIlIlllIllIIIIl = MathHelper.clamp(llllllllllllllIlIIIlIlllIllIIIIl, 0.0f, 1.0f);
        float llllllllllllllIlIIIlIlllIllIIIII = 0.7529412f;
        float llllllllllllllIlIIIlIlllIlIlllll = 0.84705883f;
        float llllllllllllllIlIIIlIlllIlIllllI = 1.0f;
        llllllllllllllIlIIIlIlllIllIIIII *= llllllllllllllIlIIIlIlllIllIIIIl * 0.94f + 0.06f;
        llllllllllllllIlIIIlIlllIlIlllll *= llllllllllllllIlIIIlIlllIllIIIIl * 0.94f + 0.06f;
        llllllllllllllIlIIIlIlllIlIllllI *= llllllllllllllIlIIIlIlllIllIIIIl * 0.91f + 0.09f;
        return new Vec3d(llllllllllllllIlIIIlIlllIllIIIII, llllllllllllllIlIIIlIlllIlIlllll, llllllllllllllIlIIIlIlllIlIllllI);
    }
    
    public void onWorldSave() {
    }
    
    public IChunkGenerator createChunkGenerator() {
        if (this.terrainType == WorldType.FLAT) {
            return new ChunkGeneratorFlat(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings);
        }
        if (this.terrainType == WorldType.DEBUG_WORLD) {
            return new ChunkGeneratorDebug(this.worldObj);
        }
        return (this.terrainType == WorldType.CUSTOMIZED) ? new ChunkGeneratorOverworld(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings) : new ChunkGeneratorOverworld(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.generatorSettings);
    }
    
    public BiomeProvider getBiomeProvider() {
        return this.biomeProvider;
    }
    
    protected void createBiomeProvider() {
        this.field_191067_f = true;
        final WorldType llllllllllllllIlIIIlIllllIlllIll = this.worldObj.getWorldInfo().getTerrainType();
        if (llllllllllllllIlIIIlIllllIlllIll == WorldType.FLAT) {
            final FlatGeneratorInfo llllllllllllllIlIIIlIllllIlllIIl = FlatGeneratorInfo.createFlatGeneratorFromString(this.worldObj.getWorldInfo().getGeneratorOptions());
            this.biomeProvider = new BiomeProviderSingle(Biome.getBiome(llllllllllllllIlIIIlIllllIlllIIl.getBiome(), Biomes.DEFAULT));
        }
        else if (llllllllllllllIlIIIlIllllIlllIll == WorldType.DEBUG_WORLD) {
            this.biomeProvider = new BiomeProviderSingle(Biomes.PLAINS);
        }
        else {
            this.biomeProvider = new BiomeProvider(this.worldObj.getWorldInfo());
        }
    }
    
    public boolean func_191066_m() {
        return this.field_191067_f;
    }
    
    public abstract DimensionType getDimensionType();
    
    public int getMoonPhase(final long llllllllllllllIlIIIlIllllIIIIIlI) {
        return (int)(llllllllllllllIlIIIlIllllIIIIIlI / 24000L % 8L + 8L) % 8;
    }
    
    public boolean canRespawnHere() {
        return true;
    }
    
    public boolean isSurfaceWorld() {
        return true;
    }
    
    public boolean isSkyColored() {
        return true;
    }
    
    public float getCloudHeight() {
        return 128.0f;
    }
    
    public boolean getHasNoSky() {
        return this.hasNoSky;
    }
    
    public boolean canCoordinateBeSpawn(final int llllllllllllllIlIIIlIllllIIllIll, final int llllllllllllllIlIIIlIllllIIllIlI) {
        final BlockPos llllllllllllllIlIIIlIllllIIllIIl = new BlockPos(llllllllllllllIlIIIlIllllIIllIll, 0, llllllllllllllIlIIIlIllllIIllIlI);
        return this.worldObj.getBiome(llllllllllllllIlIIIlIllllIIllIIl).ignorePlayerSpawnSuitability() || this.worldObj.getGroundAboveSeaLevel(llllllllllllllIlIIIlIllllIIllIIl).getBlock() == Blocks.GRASS;
    }
    
    public void onWorldUpdateEntities() {
    }
    
    public void onPlayerAdded(final EntityPlayerMP llllllllllllllIlIIIlIlllIIlllIlI) {
    }
    
    public void onPlayerRemoved(final EntityPlayerMP llllllllllllllIlIIIlIlllIIlllIII) {
    }
    
    public int getAverageGroundLevel() {
        return (this.terrainType == WorldType.FLAT) ? 4 : (this.worldObj.getSeaLevel() + 1);
    }
    
    public WorldBorder createWorldBorder() {
        return new WorldBorder();
    }
    
    public boolean doesXZShowFog(final int llllllllllllllIlIIIlIlllIlIIllIl, final int llllllllllllllIlIIIlIlllIlIIllII) {
        return false;
    }
    
    protected void generateLightBrightnessTable() {
        final float llllllllllllllIlIIIlIlllllIIIlll = 0.0f;
        for (int llllllllllllllIlIIIlIlllllIIIllI = 0; llllllllllllllIlIIIlIlllllIIIllI <= 15; ++llllllllllllllIlIIIlIlllllIIIllI) {
            final float llllllllllllllIlIIIlIlllllIIIlIl = 1.0f - llllllllllllllIlIIIlIlllllIIIllI / 15.0f;
            this.lightBrightnessTable[llllllllllllllIlIIIlIlllllIIIllI] = (1.0f - llllllllllllllIlIIIlIlllllIIIlIl) / (llllllllllllllIlIIIlIlllllIIIlIl * 3.0f + 1.0f) * 1.0f + 0.0f;
        }
    }
    
    public boolean doesWaterVaporize() {
        return this.isHellWorld;
    }
    
    public double getVoidFogYFactor() {
        return (this.terrainType == WorldType.FLAT) ? 1.0 : 0.03125;
    }
    
    public final void registerWorld(final World llllllllllllllIlIIIlIlllllIIllll) {
        this.worldObj = llllllllllllllIlIIIlIlllllIIllll;
        this.terrainType = llllllllllllllIlIIIlIlllllIIllll.getWorldInfo().getTerrainType();
        this.generatorSettings = llllllllllllllIlIIIlIlllllIIllll.getWorldInfo().getGeneratorOptions();
        this.createBiomeProvider();
        this.generateLightBrightnessTable();
    }
    
    @Nullable
    public float[] calcSunriseSunsetColors(final float llllllllllllllIlIIIlIlllIllIllll, final float llllllllllllllIlIIIlIlllIlllIllI) {
        final float llllllllllllllIlIIIlIlllIlllIlIl = 0.4f;
        final float llllllllllllllIlIIIlIlllIlllIlII = MathHelper.cos(llllllllllllllIlIIIlIlllIllIllll * 6.2831855f) - 0.0f;
        final float llllllllllllllIlIIIlIlllIlllIIll = -0.0f;
        if (llllllllllllllIlIIIlIlllIlllIlII >= -0.4f && llllllllllllllIlIIIlIlllIlllIlII <= 0.4f) {
            final float llllllllllllllIlIIIlIlllIlllIIlI = (llllllllllllllIlIIIlIlllIlllIlII + 0.0f) / 0.4f * 0.5f + 0.5f;
            float llllllllllllllIlIIIlIlllIlllIIIl = 1.0f - (1.0f - MathHelper.sin(llllllllllllllIlIIIlIlllIlllIIlI * 3.1415927f)) * 0.99f;
            llllllllllllllIlIIIlIlllIlllIIIl *= llllllllllllllIlIIIlIlllIlllIIIl;
            this.colorsSunriseSunset[0] = llllllllllllllIlIIIlIlllIlllIIlI * 0.3f + 0.7f;
            this.colorsSunriseSunset[1] = llllllllllllllIlIIIlIlllIlllIIlI * llllllllllllllIlIIIlIlllIlllIIlI * 0.7f + 0.2f;
            this.colorsSunriseSunset[2] = llllllllllllllIlIIIlIlllIlllIIlI * llllllllllllllIlIIIlIlllIlllIIlI * 0.0f + 0.2f;
            this.colorsSunriseSunset[3] = llllllllllllllIlIIIlIlllIlllIIIl;
            return this.colorsSunriseSunset;
        }
        return null;
    }
    
    public float[] getLightBrightnessTable() {
        return this.lightBrightnessTable;
    }
    
    static {
        MOON_PHASE_FACTORS = new float[] { 1.0f, 0.75f, 0.5f, 0.25f, 0.0f, 0.25f, 0.5f, 0.75f };
    }
    
    public WorldProvider() {
        this.lightBrightnessTable = new float[16];
        this.colorsSunriseSunset = new float[4];
    }
    
    @Nullable
    public BlockPos getSpawnCoordinate() {
        return null;
    }
    
    public boolean canDropChunk(final int llllllllllllllIlIIIlIlllIIllIlII, final int llllllllllllllIlIIIlIlllIIllIIll) {
        return true;
    }
}
