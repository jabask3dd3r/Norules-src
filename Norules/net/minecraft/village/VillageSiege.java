package net.minecraft.village;

import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import javax.annotation.*;

public class VillageSiege
{
    private /* synthetic */ int nextSpawnTime;
    private /* synthetic */ int siegeCount;
    private /* synthetic */ Village theVillage;
    private final /* synthetic */ World worldObj;
    private /* synthetic */ int siegeState;
    private /* synthetic */ int spawnX;
    private /* synthetic */ int spawnY;
    private /* synthetic */ boolean hasSetupSiege;
    private /* synthetic */ int spawnZ;
    
    public void tick() {
        if (this.worldObj.isDaytime()) {
            this.siegeState = 0;
        }
        else if (this.siegeState != 2) {
            if (this.siegeState == 0) {
                final float lllllllllllllIIIIlllllIlIlIllIIl = this.worldObj.getCelestialAngle(0.0f);
                if (lllllllllllllIIIIlllllIlIlIllIIl < 0.5 || lllllllllllllIIIIlllllIlIlIllIIl > 0.501) {
                    return;
                }
                this.siegeState = ((this.worldObj.rand.nextInt(10) == 0) ? 1 : 2);
                this.hasSetupSiege = false;
                if (this.siegeState == 2) {
                    return;
                }
            }
            if (this.siegeState != -1) {
                if (!this.hasSetupSiege) {
                    if (!this.trySetupSiege()) {
                        return;
                    }
                    this.hasSetupSiege = true;
                }
                if (this.nextSpawnTime > 0) {
                    --this.nextSpawnTime;
                }
                else {
                    this.nextSpawnTime = 2;
                    if (this.siegeCount > 0) {
                        this.spawnZombie();
                        --this.siegeCount;
                    }
                    else {
                        this.siegeState = 2;
                    }
                }
            }
        }
    }
    
    public VillageSiege(final World lllllllllllllIIIIlllllIlIlIlllIl) {
        this.siegeState = -1;
        this.worldObj = lllllllllllllIIIIlllllIlIlIlllIl;
    }
    
    private boolean spawnZombie() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: new             Lnet/minecraft/util/math/BlockPos;
        //     4: dup            
        //     5: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //     6: getfield        net/minecraft/village/VillageSiege.spawnX:I
        //     9: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //    10: getfield        net/minecraft/village/VillageSiege.spawnY:I
        //    13: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //    14: getfield        net/minecraft/village/VillageSiege.spawnZ:I
        //    17: invokespecial   net/minecraft/util/math/BlockPos.<init>:(III)V
        //    20: invokespecial   net/minecraft/village/VillageSiege.findRandomSpawnPos:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/math/Vec3d;
        //    23: astore_1        /* lllllllllllllIIIIlllllIlIIllIIII */
        //    24: aload_1         /* lllllllllllllIIIIlllllIlIIllIIII */
        //    25: ifnonnull       30
        //    28: iconst_0       
        //    29: ireturn        
        //    30: new             Lnet/minecraft/entity/monster/EntityZombie;
        //    33: dup            
        //    34: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //    35: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //    38: invokespecial   net/minecraft/entity/monster/EntityZombie.<init>:(Lnet/minecraft/world/World;)V
        //    41: astore_2        /* lllllllllllllIIIIlllllIlIIlIllll */
        //    42: aload_2         /* lllllllllllllIIIIlllllIlIIlIllll */
        //    43: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //    44: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //    47: new             Lnet/minecraft/util/math/BlockPos;
        //    50: dup            
        //    51: aload_2         /* lllllllllllllIIIIlllllIlIIlIllll */
        //    52: invokespecial   net/minecraft/util/math/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //    55: invokevirtual   net/minecraft/world/World.getDifficultyForLocation:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //    58: aconst_null    
        //    59: invokevirtual   net/minecraft/entity/monster/EntityZombie.onInitialSpawn:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //    62: pop            
        //    63: goto            73
        //    66: astore_3        /* lllllllllllllIIIIlllllIlIIlIllIl */
        //    67: aload_3         /* lllllllllllllIIIIlllllIlIIlIllIl */
        //    68: invokevirtual   java/lang/Exception.printStackTrace:()V
        //    71: iconst_0       
        //    72: ireturn        
        //    73: aload_2         /* lllllllllllllIIIIlllllIlIIlIlllI */
        //    74: aload_1         /* lllllllllllllIIIIlllllIlIIllIIII */
        //    75: getfield        net/minecraft/util/math/Vec3d.xCoord:D
        //    78: aload_1         /* lllllllllllllIIIIlllllIlIIllIIII */
        //    79: getfield        net/minecraft/util/math/Vec3d.yCoord:D
        //    82: aload_1         /* lllllllllllllIIIIlllllIlIIllIIII */
        //    83: getfield        net/minecraft/util/math/Vec3d.zCoord:D
        //    86: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //    87: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //    90: getfield        net/minecraft/world/World.rand:Ljava/util/Random;
        //    93: invokevirtual   java/util/Random.nextFloat:()F
        //    96: ldc             360.0
        //    98: fmul           
        //    99: fconst_0       
        //   100: invokevirtual   net/minecraft/entity/monster/EntityZombie.setLocationAndAngles:(DDDFF)V
        //   103: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //   104: getfield        net/minecraft/village/VillageSiege.worldObj:Lnet/minecraft/world/World;
        //   107: aload_2         /* lllllllllllllIIIIlllllIlIIlIlllI */
        //   108: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   111: pop            
        //   112: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //   113: getfield        net/minecraft/village/VillageSiege.theVillage:Lnet/minecraft/village/Village;
        //   116: invokevirtual   net/minecraft/village/Village.getCenter:()Lnet/minecraft/util/math/BlockPos;
        //   119: astore_3        /* lllllllllllllIIIIlllllIlIIlIllII */
        //   120: aload_2         /* lllllllllllllIIIIlllllIlIIlIlllI */
        //   121: aload_3         /* lllllllllllllIIIIlllllIlIIlIllII */
        //   122: aload_0         /* lllllllllllllIIIIlllllIlIIlIlIll */
        //   123: getfield        net/minecraft/village/VillageSiege.theVillage:Lnet/minecraft/village/Village;
        //   126: invokevirtual   net/minecraft/village/Village.getVillageRadius:()I
        //   129: invokevirtual   net/minecraft/entity/monster/EntityZombie.setHomePosAndDistance:(Lnet/minecraft/util/math/BlockPos;I)V
        //   132: iconst_1       
        //   133: ireturn        
        //    StackMapTable: 00 03 FC 00 1E 07 00 76 63 07 00 53 FC 00 06 07 00 64
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  30     63     66     73     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean trySetupSiege() {
        final List<EntityPlayer> lllllllllllllIIIIlllllIlIlIIlIlI = this.worldObj.playerEntities;
        for (final EntityPlayer lllllllllllllIIIIlllllIlIlIIlIII : lllllllllllllIIIIlllllIlIlIIlIlI) {
            if (!lllllllllllllIIIIlllllIlIlIIlIII.isSpectator()) {
                this.theVillage = this.worldObj.getVillageCollection().getNearestVillage(new BlockPos(lllllllllllllIIIIlllllIlIlIIlIII), 1);
                if (this.theVillage == null || this.theVillage.getNumVillageDoors() < 10 || this.theVillage.getTicksSinceLastDoorAdding() < 20 || this.theVillage.getNumVillagers() < 20) {
                    continue;
                }
                final BlockPos lllllllllllllIIIIlllllIlIlIIIlll = this.theVillage.getCenter();
                final float lllllllllllllIIIIlllllIlIlIIIllI = (float)this.theVillage.getVillageRadius();
                boolean lllllllllllllIIIIlllllIlIlIIIlIl = false;
                for (int lllllllllllllIIIIlllllIlIlIIIlII = 0; lllllllllllllIIIIlllllIlIlIIIlII < 10; ++lllllllllllllIIIIlllllIlIlIIIlII) {
                    final float lllllllllllllIIIIlllllIlIlIIIIll = this.worldObj.rand.nextFloat() * 6.2831855f;
                    this.spawnX = lllllllllllllIIIIlllllIlIlIIIlll.getX() + (int)(MathHelper.cos(lllllllllllllIIIIlllllIlIlIIIIll) * lllllllllllllIIIIlllllIlIlIIIllI * 0.9);
                    this.spawnY = lllllllllllllIIIIlllllIlIlIIIlll.getY();
                    this.spawnZ = lllllllllllllIIIIlllllIlIlIIIlll.getZ() + (int)(MathHelper.sin(lllllllllllllIIIIlllllIlIlIIIIll) * lllllllllllllIIIIlllllIlIlIIIllI * 0.9);
                    lllllllllllllIIIIlllllIlIlIIIlIl = false;
                    for (final Village lllllllllllllIIIIlllllIlIlIIIIlI : this.worldObj.getVillageCollection().getVillageList()) {
                        if (lllllllllllllIIIIlllllIlIlIIIIlI != this.theVillage && lllllllllllllIIIIlllllIlIlIIIIlI.isBlockPosWithinSqVillageRadius(new BlockPos(this.spawnX, this.spawnY, this.spawnZ))) {
                            lllllllllllllIIIIlllllIlIlIIIlIl = true;
                            break;
                        }
                    }
                    if (!lllllllllllllIIIIlllllIlIlIIIlIl) {
                        break;
                    }
                }
                if (lllllllllllllIIIIlllllIlIlIIIlIl) {
                    return false;
                }
                final Vec3d lllllllllllllIIIIlllllIlIlIIIIIl = this.findRandomSpawnPos(new BlockPos(this.spawnX, this.spawnY, this.spawnZ));
                if (lllllllllllllIIIIlllllIlIlIIIIIl != null) {
                    this.nextSpawnTime = 0;
                    this.siegeCount = 20;
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    @Nullable
    private Vec3d findRandomSpawnPos(final BlockPos lllllllllllllIIIIlllllIlIIlIIIlI) {
        for (int lllllllllllllIIIIlllllIlIIlIIIIl = 0; lllllllllllllIIIIlllllIlIIlIIIIl < 10; ++lllllllllllllIIIIlllllIlIIlIIIIl) {
            final BlockPos lllllllllllllIIIIlllllIlIIlIIIII = lllllllllllllIIIIlllllIlIIlIIIlI.add(this.worldObj.rand.nextInt(16) - 8, this.worldObj.rand.nextInt(6) - 3, this.worldObj.rand.nextInt(16) - 8);
            if (this.theVillage.isBlockPosWithinSqVillageRadius(lllllllllllllIIIIlllllIlIIlIIIII) && WorldEntitySpawner.canCreatureTypeSpawnAtLocation(EntityLiving.SpawnPlacementType.ON_GROUND, this.worldObj, lllllllllllllIIIIlllllIlIIlIIIII)) {
                return new Vec3d(lllllllllllllIIIIlllllIlIIlIIIII.getX(), lllllllllllllIIIIlllllIlIIlIIIII.getY(), lllllllllllllIIIIlllllIlIIlIIIII.getZ());
            }
        }
        return null;
    }
}
