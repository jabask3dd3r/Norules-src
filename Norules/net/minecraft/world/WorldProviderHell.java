package net.minecraft.world;

import net.minecraft.world.gen.*;
import net.minecraft.world.border.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class WorldProviderHell extends WorldProvider
{
    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public boolean doesXZShowFog(final int lllllllllllllllllIIllIlIIlIllIII, final int lllllllllllllllllIIllIlIIlIlIlll) {
        return true;
    }
    
    @Override
    public boolean canCoordinateBeSpawn(final int lllllllllllllllllIIllIlIIlIlllll, final int lllllllllllllllllIIllIlIIlIllllI) {
        return false;
    }
    
    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorHell(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
    }
    
    @Override
    public WorldBorder createWorldBorder() {
        return new WorldBorder() {
            @Override
            public double getCenterZ() {
                return super.getCenterZ() / 8.0;
            }
            
            @Override
            public double getCenterX() {
                return super.getCenterX() / 8.0;
            }
        };
    }
    
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.NETHER;
    }
    
    @Override
    public float calculateCelestialAngle(final long lllllllllllllllllIIllIlIIlIlllII, final float lllllllllllllllllIIllIlIIlIllIll) {
        return 0.5f;
    }
    
    @Override
    protected void generateLightBrightnessTable() {
        final float lllllllllllllllllIIllIlIIllIlIll = 0.1f;
        for (int lllllllllllllllllIIllIlIIllIlIlI = 0; lllllllllllllllllIIllIlIIllIlIlI <= 15; ++lllllllllllllllllIIllIlIIllIlIlI) {
            final float lllllllllllllllllIIllIlIIllIlIIl = 1.0f - lllllllllllllllllIIllIlIIllIlIlI / 15.0f;
            this.lightBrightnessTable[lllllllllllllllllIIllIlIIllIlIlI] = (1.0f - lllllllllllllllllIIllIlIIllIlIIl) / (lllllllllllllllllIIllIlIIllIlIIl * 3.0f + 1.0f) * 0.9f + 0.1f;
        }
    }
    
    @Override
    public Vec3d getFogColor(final float lllllllllllllllllIIllIlIIlllIIlI, final float lllllllllllllllllIIllIlIIlllIIIl) {
        return new Vec3d(0.20000000298023224, 0.029999999329447746, 0.029999999329447746);
    }
    
    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(Biomes.HELL);
        this.isHellWorld = true;
        this.hasNoSky = true;
    }
    
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
}
