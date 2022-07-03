package net.minecraft.world;

import net.minecraft.world.end.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class WorldProviderEnd extends WorldProvider
{
    private /* synthetic */ DragonFightManager dragonFightManager;
    
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.THE_END;
    }
    
    @Override
    public boolean isSkyColored() {
        return false;
    }
    
    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public Vec3d getFogColor(final float lllllllllllllIlIIllllIlIIllIIlII, final float lllllllllllllIlIIllllIlIIllIlIlI) {
        final int lllllllllllllIlIIllllIlIIllIlIIl = 10518688;
        float lllllllllllllIlIIllllIlIIllIlIII = MathHelper.cos(lllllllllllllIlIIllllIlIIllIIlII * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllllIlIIllllIlIIllIlIII = MathHelper.clamp(lllllllllllllIlIIllllIlIIllIlIII, 0.0f, 1.0f);
        float lllllllllllllIlIIllllIlIIllIIlll = 0.627451f;
        float lllllllllllllIlIIllllIlIIllIIllI = 0.5019608f;
        float lllllllllllllIlIIllllIlIIllIIlIl = 0.627451f;
        lllllllllllllIlIIllllIlIIllIIlll *= lllllllllllllIlIIllllIlIIllIlIII * 0.0f + 0.15f;
        lllllllllllllIlIIllllIlIIllIIllI *= lllllllllllllIlIIllllIlIIllIlIII * 0.0f + 0.15f;
        lllllllllllllIlIIllllIlIIllIIlIl *= lllllllllllllIlIIllllIlIIllIlIII * 0.0f + 0.15f;
        return new Vec3d(lllllllllllllIlIIllllIlIIllIIlll, lllllllllllllIlIIllllIlIIllIIllI, lllllllllllllIlIIllllIlIIllIIlIl);
    }
    
    @Override
    public void onWorldSave() {
        final NBTTagCompound lllllllllllllIlIIllllIlIIlIIlIII = new NBTTagCompound();
        if (this.dragonFightManager != null) {
            lllllllllllllIlIIllllIlIIlIIlIII.setTag("DragonFight", this.dragonFightManager.getCompound());
        }
        this.worldObj.getWorldInfo().setDimensionData(DimensionType.THE_END, lllllllllllllIlIIllllIlIIlIIlIII);
    }
    
    @Override
    public boolean doesXZShowFog(final int lllllllllllllIlIIllllIlIIlIIlllI, final int lllllllllllllIlIIllllIlIIlIIllIl) {
        return false;
    }
    
    @Override
    public void onWorldUpdateEntities() {
        if (this.dragonFightManager != null) {
            this.dragonFightManager.tick();
        }
    }
    
    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(Biomes.SKY);
        final NBTTagCompound lllllllllllllIlIIllllIlIIllllllI = this.worldObj.getWorldInfo().getDimensionData(DimensionType.THE_END);
        this.dragonFightManager = ((this.worldObj instanceof WorldServer) ? new DragonFightManager((WorldServer)this.worldObj, lllllllllllllIlIIllllIlIIllllllI.getCompoundTag("DragonFight")) : null);
    }
    
    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorEnd(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed(), this.getSpawnCoordinate());
    }
    
    @Override
    public BlockPos getSpawnCoordinate() {
        return new BlockPos(100, 50, 0);
    }
    
    @Override
    public int getAverageGroundLevel() {
        return 50;
    }
    
    @Nullable
    public DragonFightManager getDragonFightManager() {
        return this.dragonFightManager;
    }
    
    @Override
    public boolean canCoordinateBeSpawn(final int lllllllllllllIlIIllllIlIIlIlIIll, final int lllllllllllllIlIIllllIlIIlIlIlIl) {
        return this.worldObj.getGroundAboveSeaLevel(new BlockPos(lllllllllllllIlIIllllIlIIlIlIIll, 0, lllllllllllllIlIIllllIlIIlIlIlIl)).getMaterial().blocksMovement();
    }
    
    @Override
    public float getCloudHeight() {
        return 8.0f;
    }
    
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
    
    @Nullable
    @Override
    public float[] calcSunriseSunsetColors(final float lllllllllllllIlIIllllIlIIlllIlII, final float lllllllllllllIlIIllllIlIIlllIIll) {
        return null;
    }
    
    @Override
    public float calculateCelestialAngle(final long lllllllllllllIlIIllllIlIIlllIlll, final float lllllllllllllIlIIllllIlIIlllIllI) {
        return 0.0f;
    }
}
