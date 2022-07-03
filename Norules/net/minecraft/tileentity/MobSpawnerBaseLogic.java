package net.minecraft.tileentity;

import java.util.*;
import javax.annotation.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public abstract class MobSpawnerBaseLogic
{
    private /* synthetic */ WeightedSpawnerEntity randomEntity;
    private /* synthetic */ double mobRotation;
    private /* synthetic */ int maxSpawnDelay;
    private /* synthetic */ int minSpawnDelay;
    private final /* synthetic */ List<WeightedSpawnerEntity> potentialSpawns;
    private /* synthetic */ int spawnRange;
    private /* synthetic */ int activatingRangeFromPlayer;
    private /* synthetic */ int maxNearbyEntities;
    private /* synthetic */ Entity cachedEntity;
    private /* synthetic */ double prevMobRotation;
    private /* synthetic */ int spawnDelay;
    private /* synthetic */ int spawnCount;
    
    public void func_190894_a(@Nullable final ResourceLocation lllllllllllllIlllllIIlIllllIllll) {
        if (lllllllllllllIlllllIIlIllllIllll != null) {
            this.randomEntity.getNbt().setString("id", lllllllllllllIlllllIIlIllllIllll.toString());
        }
    }
    
    public abstract void broadcastEvent(final int p0);
    
    public Entity getCachedEntity() {
        if (this.cachedEntity == null) {
            this.cachedEntity = AnvilChunkLoader.readWorldEntity(this.randomEntity.getNbt(), this.getSpawnerWorld(), false);
            if (this.randomEntity.getNbt().getSize() == 1 && this.randomEntity.getNbt().hasKey("id", 8) && this.cachedEntity instanceof EntityLiving) {
                ((EntityLiving)this.cachedEntity).onInitialSpawn(this.getSpawnerWorld().getDifficultyForLocation(new BlockPos(this.cachedEntity)), null);
            }
        }
        return this.cachedEntity;
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllllIlllllIIlIllIlIlIlI) {
        this.spawnDelay = lllllllllllllIlllllIIlIllIlIlIlI.getShort("Delay");
        this.potentialSpawns.clear();
        if (lllllllllllllIlllllIIlIllIlIlIlI.hasKey("SpawnPotentials", 9)) {
            final NBTTagList lllllllllllllIlllllIIlIllIlIllIl = lllllllllllllIlllllIIlIllIlIlIlI.getTagList("SpawnPotentials", 10);
            for (int lllllllllllllIlllllIIlIllIlIllII = 0; lllllllllllllIlllllIIlIllIlIllII < lllllllllllllIlllllIIlIllIlIllIl.tagCount(); ++lllllllllllllIlllllIIlIllIlIllII) {
                this.potentialSpawns.add(new WeightedSpawnerEntity(lllllllllllllIlllllIIlIllIlIllIl.getCompoundTagAt(lllllllllllllIlllllIIlIllIlIllII)));
            }
        }
        if (lllllllllllllIlllllIIlIllIlIlIlI.hasKey("SpawnData", 10)) {
            this.setNextSpawnData(new WeightedSpawnerEntity(1, lllllllllllllIlllllIIlIllIlIlIlI.getCompoundTag("SpawnData")));
        }
        else if (!this.potentialSpawns.isEmpty()) {
            this.setNextSpawnData(WeightedRandom.getRandomItem(this.getSpawnerWorld().rand, this.potentialSpawns));
        }
        if (lllllllllllllIlllllIIlIllIlIlIlI.hasKey("MinSpawnDelay", 99)) {
            this.minSpawnDelay = lllllllllllllIlllllIIlIllIlIlIlI.getShort("MinSpawnDelay");
            this.maxSpawnDelay = lllllllllllllIlllllIIlIllIlIlIlI.getShort("MaxSpawnDelay");
            this.spawnCount = lllllllllllllIlllllIIlIllIlIlIlI.getShort("SpawnCount");
        }
        if (lllllllllllllIlllllIIlIllIlIlIlI.hasKey("MaxNearbyEntities", 99)) {
            this.maxNearbyEntities = lllllllllllllIlllllIIlIllIlIlIlI.getShort("MaxNearbyEntities");
            this.activatingRangeFromPlayer = lllllllllllllIlllllIIlIllIlIlIlI.getShort("RequiredPlayerRange");
        }
        if (lllllllllllllIlllllIIlIllIlIlIlI.hasKey("SpawnRange", 99)) {
            this.spawnRange = lllllllllllllIlllllIIlIllIlIlIlI.getShort("SpawnRange");
        }
        if (this.getSpawnerWorld() != null) {
            this.cachedEntity = null;
        }
    }
    
    public void setNextSpawnData(final WeightedSpawnerEntity lllllllllllllIlllllIIlIllIIIlIlI) {
        this.randomEntity = lllllllllllllIlllllIIlIllIIIlIlI;
    }
    
    private void resetTimer() {
        if (this.maxSpawnDelay <= this.minSpawnDelay) {
            this.spawnDelay = this.minSpawnDelay;
        }
        else {
            final int lllllllllllllIlllllIIlIllIllIllI = this.maxSpawnDelay - this.minSpawnDelay;
            this.spawnDelay = this.minSpawnDelay + this.getSpawnerWorld().rand.nextInt(lllllllllllllIlllllIIlIllIllIllI);
        }
        if (!this.potentialSpawns.isEmpty()) {
            this.setNextSpawnData(WeightedRandom.getRandomItem(this.getSpawnerWorld().rand, this.potentialSpawns));
        }
        this.broadcastEvent(1);
    }
    
    public double getPrevMobRotation() {
        return this.prevMobRotation;
    }
    
    private boolean isActivated() {
        final BlockPos lllllllllllllIlllllIIlIllllIlIIl = this.getSpawnerPosition();
        return this.getSpawnerWorld().isAnyPlayerWithinRangeAt(lllllllllllllIlllllIIlIllllIlIIl.getX() + 0.5, lllllllllllllIlllllIIlIllllIlIIl.getY() + 0.5, lllllllllllllIlllllIIlIllllIlIIl.getZ() + 0.5, this.activatingRangeFromPlayer);
    }
    
    public double getMobRotation() {
        return this.mobRotation;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIlllllIIlIllIIllIll) {
        final ResourceLocation lllllllllllllIlllllIIlIllIIlllll = this.func_190895_g();
        if (lllllllllllllIlllllIIlIllIIlllll == null) {
            return lllllllllllllIlllllIIlIllIIllIll;
        }
        lllllllllllllIlllllIIlIllIIllIll.setShort("Delay", (short)this.spawnDelay);
        lllllllllllllIlllllIIlIllIIllIll.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
        lllllllllllllIlllllIIlIllIIllIll.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
        lllllllllllllIlllllIIlIllIIllIll.setShort("SpawnCount", (short)this.spawnCount);
        lllllllllllllIlllllIIlIllIIllIll.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
        lllllllllllllIlllllIIlIllIIllIll.setShort("RequiredPlayerRange", (short)this.activatingRangeFromPlayer);
        lllllllllllllIlllllIIlIllIIllIll.setShort("SpawnRange", (short)this.spawnRange);
        lllllllllllllIlllllIIlIllIIllIll.setTag("SpawnData", this.randomEntity.getNbt().copy());
        final NBTTagList lllllllllllllIlllllIIlIllIIllllI = new NBTTagList();
        if (this.potentialSpawns.isEmpty()) {
            lllllllllllllIlllllIIlIllIIllllI.appendTag(this.randomEntity.toCompoundTag());
        }
        else {
            for (final WeightedSpawnerEntity lllllllllllllIlllllIIlIllIIlllIl : this.potentialSpawns) {
                lllllllllllllIlllllIIlIllIIllllI.appendTag(lllllllllllllIlllllIIlIllIIlllIl.toCompoundTag());
            }
        }
        lllllllllllllIlllllIIlIllIIllIll.setTag("SpawnPotentials", lllllllllllllIlllllIIlIllIIllllI);
        return lllllllllllllIlllllIIlIllIIllIll;
    }
    
    public abstract BlockPos getSpawnerPosition();
    
    @Nullable
    private ResourceLocation func_190895_g() {
        final String lllllllllllllIlllllIIlIlllllIlIl = this.randomEntity.getNbt().getString("id");
        return StringUtils.isNullOrEmpty(lllllllllllllIlllllIIlIlllllIlIl) ? null : new ResourceLocation(lllllllllllllIlllllIIlIlllllIlIl);
    }
    
    public MobSpawnerBaseLogic() {
        this.spawnDelay = 20;
        this.potentialSpawns = (List<WeightedSpawnerEntity>)Lists.newArrayList();
        this.randomEntity = new WeightedSpawnerEntity();
        this.minSpawnDelay = 200;
        this.maxSpawnDelay = 800;
        this.spawnCount = 4;
        this.maxNearbyEntities = 6;
        this.activatingRangeFromPlayer = 16;
        this.spawnRange = 4;
    }
    
    public abstract World getSpawnerWorld();
    
    public void updateSpawner() {
        if (!this.isActivated()) {
            this.prevMobRotation = this.mobRotation;
        }
        else {
            final BlockPos lllllllllllllIlllllIIlIlllIlIlll = this.getSpawnerPosition();
            if (this.getSpawnerWorld().isRemote) {
                final double lllllllllllllIlllllIIlIlllIlIllI = lllllllllllllIlllllIIlIlllIlIlll.getX() + this.getSpawnerWorld().rand.nextFloat();
                final double lllllllllllllIlllllIIlIlllIlIlIl = lllllllllllllIlllllIIlIlllIlIlll.getY() + this.getSpawnerWorld().rand.nextFloat();
                final double lllllllllllllIlllllIIlIlllIlIlII = lllllllllllllIlllllIIlIlllIlIlll.getZ() + this.getSpawnerWorld().rand.nextFloat();
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllIlllllIIlIlllIlIllI, lllllllllllllIlllllIIlIlllIlIlIl, lllllllllllllIlllllIIlIlllIlIlII, 0.0, 0.0, 0.0, new int[0]);
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.FLAME, lllllllllllllIlllllIIlIlllIlIllI, lllllllllllllIlllllIIlIlllIlIlIl, lllllllllllllIlllllIIlIlllIlIlII, 0.0, 0.0, 0.0, new int[0]);
                if (this.spawnDelay > 0) {
                    --this.spawnDelay;
                }
                this.prevMobRotation = this.mobRotation;
                this.mobRotation = (this.mobRotation + 1000.0f / (this.spawnDelay + 200.0f)) % 360.0;
            }
            else {
                if (this.spawnDelay == -1) {
                    this.resetTimer();
                }
                if (this.spawnDelay > 0) {
                    --this.spawnDelay;
                    return;
                }
                boolean lllllllllllllIlllllIIlIlllIlIIll = false;
                for (int lllllllllllllIlllllIIlIlllIlIIlI = 0; lllllllllllllIlllllIIlIlllIlIIlI < this.spawnCount; ++lllllllllllllIlllllIIlIlllIlIIlI) {
                    final NBTTagCompound lllllllllllllIlllllIIlIlllIlIIIl = this.randomEntity.getNbt();
                    final NBTTagList lllllllllllllIlllllIIlIlllIlIIII = lllllllllllllIlllllIIlIlllIlIIIl.getTagList("Pos", 6);
                    final World lllllllllllllIlllllIIlIlllIIllll = this.getSpawnerWorld();
                    final int lllllllllllllIlllllIIlIlllIIlllI = lllllllllllllIlllllIIlIlllIlIIII.tagCount();
                    final double lllllllllllllIlllllIIlIlllIIllIl = (lllllllllllllIlllllIIlIlllIIlllI >= 1) ? lllllllllllllIlllllIIlIlllIlIIII.getDoubleAt(0) : (lllllllllllllIlllllIIlIlllIlIlll.getX() + (lllllllllllllIlllllIIlIlllIIllll.rand.nextDouble() - lllllllllllllIlllllIIlIlllIIllll.rand.nextDouble()) * this.spawnRange + 0.5);
                    final double lllllllllllllIlllllIIlIlllIIllII = (lllllllllllllIlllllIIlIlllIIlllI >= 2) ? lllllllllllllIlllllIIlIlllIlIIII.getDoubleAt(1) : (lllllllllllllIlllllIIlIlllIlIlll.getY() + lllllllllllllIlllllIIlIlllIIllll.rand.nextInt(3) - 1);
                    final double lllllllllllllIlllllIIlIlllIIlIll = (lllllllllllllIlllllIIlIlllIIlllI >= 3) ? lllllllllllllIlllllIIlIlllIlIIII.getDoubleAt(2) : (lllllllllllllIlllllIIlIlllIlIlll.getZ() + (lllllllllllllIlllllIIlIlllIIllll.rand.nextDouble() - lllllllllllllIlllllIIlIlllIIllll.rand.nextDouble()) * this.spawnRange + 0.5);
                    final Entity lllllllllllllIlllllIIlIlllIIlIlI = AnvilChunkLoader.readWorldEntityPos(lllllllllllllIlllllIIlIlllIlIIIl, lllllllllllllIlllllIIlIlllIIllll, lllllllllllllIlllllIIlIlllIIllIl, lllllllllllllIlllllIIlIlllIIllII, lllllllllllllIlllllIIlIlllIIlIll, false);
                    if (lllllllllllllIlllllIIlIlllIIlIlI == null) {
                        return;
                    }
                    final int lllllllllllllIlllllIIlIlllIIlIIl = lllllllllllllIlllllIIlIlllIIllll.getEntitiesWithinAABB(lllllllllllllIlllllIIlIlllIIlIlI.getClass(), new AxisAlignedBB(lllllllllllllIlllllIIlIlllIlIlll.getX(), lllllllllllllIlllllIIlIlllIlIlll.getY(), lllllllllllllIlllllIIlIlllIlIlll.getZ(), lllllllllllllIlllllIIlIlllIlIlll.getX() + 1, lllllllllllllIlllllIIlIlllIlIlll.getY() + 1, lllllllllllllIlllllIIlIlllIlIlll.getZ() + 1).expandXyz(this.spawnRange)).size();
                    if (lllllllllllllIlllllIIlIlllIIlIIl >= this.maxNearbyEntities) {
                        this.resetTimer();
                        return;
                    }
                    final EntityLiving lllllllllllllIlllllIIlIlllIIlIII = (lllllllllllllIlllllIIlIlllIIlIlI instanceof EntityLiving) ? ((EntityLiving)lllllllllllllIlllllIIlIlllIIlIlI) : null;
                    lllllllllllllIlllllIIlIlllIIlIlI.setLocationAndAngles(lllllllllllllIlllllIIlIlllIIlIlI.posX, lllllllllllllIlllllIIlIlllIIlIlI.posY, lllllllllllllIlllllIIlIlllIIlIlI.posZ, lllllllllllllIlllllIIlIlllIIllll.rand.nextFloat() * 360.0f, 0.0f);
                    if (lllllllllllllIlllllIIlIlllIIlIII == null || (lllllllllllllIlllllIIlIlllIIlIII.getCanSpawnHere() && lllllllllllllIlllllIIlIlllIIlIII.isNotColliding())) {
                        if (this.randomEntity.getNbt().getSize() == 1 && this.randomEntity.getNbt().hasKey("id", 8) && lllllllllllllIlllllIIlIlllIIlIlI instanceof EntityLiving) {
                            ((EntityLiving)lllllllllllllIlllllIIlIlllIIlIlI).onInitialSpawn(lllllllllllllIlllllIIlIlllIIllll.getDifficultyForLocation(new BlockPos(lllllllllllllIlllllIIlIlllIIlIlI)), null);
                        }
                        AnvilChunkLoader.spawnEntity(lllllllllllllIlllllIIlIlllIIlIlI, lllllllllllllIlllllIIlIlllIIllll);
                        lllllllllllllIlllllIIlIlllIIllll.playEvent(2004, lllllllllllllIlllllIIlIlllIlIlll, 0);
                        if (lllllllllllllIlllllIIlIlllIIlIII != null) {
                            lllllllllllllIlllllIIlIlllIIlIII.spawnExplosionParticle();
                        }
                        lllllllllllllIlllllIIlIlllIlIIll = true;
                    }
                }
                if (lllllllllllllIlllllIIlIlllIlIIll) {
                    this.resetTimer();
                }
            }
        }
    }
    
    public boolean setDelayToMin(final int lllllllllllllIlllllIIlIllIIlIIII) {
        if (lllllllllllllIlllllIIlIllIIlIIII == 1 && this.getSpawnerWorld().isRemote) {
            this.spawnDelay = this.minSpawnDelay;
            return true;
        }
        return false;
    }
}
