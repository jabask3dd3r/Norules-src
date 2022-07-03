package net.minecraft.village;

import net.minecraft.world.*;
import net.minecraft.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.server.management.*;
import com.mojang.authlib.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class Village
{
    private final /* synthetic */ Map<String, Integer> playerReputation;
    private final /* synthetic */ List<VillageDoorInfo> villageDoorInfoList;
    private /* synthetic */ int noBreedTicks;
    private /* synthetic */ int numIronGolems;
    private /* synthetic */ int numVillagers;
    private /* synthetic */ World worldObj;
    private final /* synthetic */ List<VillageAggressor> villageAgressors;
    private /* synthetic */ BlockPos center;
    private /* synthetic */ BlockPos centerHelper;
    private /* synthetic */ int lastAddDoorTimestamp;
    private /* synthetic */ int villageRadius;
    private /* synthetic */ int tickCounter;
    
    public int getNumVillageDoors() {
        return this.villageDoorInfoList.size();
    }
    
    public boolean isPlayerReputationTooLow(final String lllllllllllllIlIllIlIlllllIllllI) {
        return this.getPlayerReputation(lllllllllllllIlIllIlIlllllIllllI) <= -15;
    }
    
    public VillageDoorInfo getDoorInfo(final BlockPos lllllllllllllIlIllIllIIIlIIIIIII) {
        VillageDoorInfo lllllllllllllIlIllIllIIIlIIIIlll = null;
        int lllllllllllllIlIllIllIIIlIIIIllI = Integer.MAX_VALUE;
        for (final VillageDoorInfo lllllllllllllIlIllIllIIIlIIIIlIl : this.villageDoorInfoList) {
            int lllllllllllllIlIllIllIIIlIIIIlII = lllllllllllllIlIllIllIIIlIIIIlIl.getDistanceToDoorBlockSq(lllllllllllllIlIllIllIIIlIIIIIII);
            if (lllllllllllllIlIllIllIIIlIIIIlII > 256) {
                lllllllllllllIlIllIllIIIlIIIIlII *= 1000;
            }
            else {
                lllllllllllllIlIllIllIIIlIIIIlII = lllllllllllllIlIllIllIIIlIIIIlIl.getDoorOpeningRestrictionCounter();
            }
            if (lllllllllllllIlIllIllIIIlIIIIlII < lllllllllllllIlIllIllIIIlIIIIllI) {
                final BlockPos lllllllllllllIlIllIllIIIlIIIIIll = lllllllllllllIlIllIllIIIlIIIIlIl.getDoorBlockPos();
                final EnumFacing lllllllllllllIlIllIllIIIlIIIIIlI = lllllllllllllIlIllIllIIIlIIIIlIl.getInsideDirection();
                if (!this.worldObj.getBlockState(lllllllllllllIlIllIllIIIlIIIIIll.offset(lllllllllllllIlIllIllIIIlIIIIIlI, 1)).getBlock().isPassable(this.worldObj, lllllllllllllIlIllIllIIIlIIIIIll.offset(lllllllllllllIlIllIllIIIlIIIIIlI, 1)) || !this.worldObj.getBlockState(lllllllllllllIlIllIllIIIlIIIIIll.offset(lllllllllllllIlIllIllIIIlIIIIIlI, -1)).getBlock().isPassable(this.worldObj, lllllllllllllIlIllIllIIIlIIIIIll.offset(lllllllllllllIlIllIllIIIlIIIIIlI, -1)) || !this.worldObj.getBlockState(lllllllllllllIlIllIllIIIlIIIIIll.up().offset(lllllllllllllIlIllIllIIIlIIIIIlI, 1)).getBlock().isPassable(this.worldObj, lllllllllllllIlIllIllIIIlIIIIIll.up().offset(lllllllllllllIlIllIllIIIlIIIIIlI, 1)) || !this.worldObj.getBlockState(lllllllllllllIlIllIllIIIlIIIIIll.up().offset(lllllllllllllIlIllIllIIIlIIIIIlI, -1)).getBlock().isPassable(this.worldObj, lllllllllllllIlIllIllIIIlIIIIIll.up().offset(lllllllllllllIlIllIllIIIlIIIIIlI, -1))) {
                    continue;
                }
                lllllllllllllIlIllIllIIIlIIIIlll = lllllllllllllIlIllIllIIIlIIIIlIl;
                lllllllllllllIlIllIllIIIlIIIIllI = lllllllllllllIlIllIllIIIlIIIIlII;
            }
        }
        return lllllllllllllIlIllIllIIIlIIIIlll;
    }
    
    public List<VillageDoorInfo> getVillageDoorInfoList() {
        return this.villageDoorInfoList;
    }
    
    private void updateVillageRadiusAndCenter() {
        final int lllllllllllllIlIllIllIIIIIIIIIll = this.villageDoorInfoList.size();
        if (lllllllllllllIlIllIllIIIIIIIIIll == 0) {
            this.center = BlockPos.ORIGIN;
            this.villageRadius = 0;
        }
        else {
            this.center = new BlockPos(this.centerHelper.getX() / lllllllllllllIlIllIllIIIIIIIIIll, this.centerHelper.getY() / lllllllllllllIlIllIllIIIIIIIIIll, this.centerHelper.getZ() / lllllllllllllIlIllIllIIIIIIIIIll);
            int lllllllllllllIlIllIllIIIIIIIIIlI = 0;
            for (final VillageDoorInfo lllllllllllllIlIllIllIIIIIIIIIIl : this.villageDoorInfoList) {
                lllllllllllllIlIllIllIIIIIIIIIlI = Math.max(lllllllllllllIlIllIllIIIIIIIIIIl.getDistanceToDoorBlockSq(this.center), lllllllllllllIlIllIllIIIIIIIIIlI);
            }
            this.villageRadius = Math.max(32, (int)Math.sqrt(lllllllllllllIlIllIllIIIIIIIIIlI) + 1);
        }
    }
    
    public void addVillageDoorInfo(final VillageDoorInfo lllllllllllllIlIllIllIIIIllIlIlI) {
        this.villageDoorInfoList.add(lllllllllllllIlIllIllIIIIllIlIlI);
        this.centerHelper = this.centerHelper.add(lllllllllllllIlIllIllIIIIllIlIlI.getDoorBlockPos());
        this.updateVillageRadiusAndCenter();
        this.lastAddDoorTimestamp = lllllllllllllIlIllIllIIIIllIlIlI.getInsidePosY();
    }
    
    public void setWorld(final World lllllllllllllIlIllIllIIlIIIIIlll) {
        this.worldObj = lllllllllllllIlIllIllIIlIIIIIlll;
    }
    
    @Nullable
    public VillageDoorInfo getExistedDoor(final BlockPos lllllllllllllIlIllIllIIIIlllIIll) {
        if (this.center.distanceSq(lllllllllllllIlIllIllIIIIlllIIll) > this.villageRadius * this.villageRadius) {
            return null;
        }
        for (final VillageDoorInfo lllllllllllllIlIllIllIIIIlllIIlI : this.villageDoorInfoList) {
            if (lllllllllllllIlIllIllIIIIlllIIlI.getDoorBlockPos().getX() == lllllllllllllIlIllIllIIIIlllIIll.getX() && lllllllllllllIlIllIllIIIIlllIIlI.getDoorBlockPos().getZ() == lllllllllllllIlIllIllIIIIlllIIll.getZ() && Math.abs(lllllllllllllIlIllIllIIIIlllIIlI.getDoorBlockPos().getY() - lllllllllllllIlIllIllIIIIlllIIll.getY()) <= 1) {
                return lllllllllllllIlIllIllIIIIlllIIlI;
            }
        }
        return null;
    }
    
    public void setDefaultPlayerReputation(final int lllllllllllllIlIllIlIllllIIllIII) {
        for (final String lllllllllllllIlIllIlIllllIIllIlI : this.playerReputation.keySet()) {
            this.modifyPlayerReputation(lllllllllllllIlIllIlIllllIIllIlI, lllllllllllllIlIllIlIllllIIllIII);
        }
    }
    
    public boolean isBlockPosWithinSqVillageRadius(final BlockPos lllllllllllllIlIllIllIIIlIlIlIlI) {
        return this.center.distanceSq(lllllllllllllIlIllIllIIIlIlIlIlI) < this.villageRadius * this.villageRadius;
    }
    
    private boolean isAreaClearAround(final BlockPos lllllllllllllIlIllIllIIIllIlIIIl, final BlockPos lllllllllllllIlIllIllIIIllIllIII) {
        if (!this.worldObj.getBlockState(lllllllllllllIlIllIllIIIllIllIII.down()).isFullyOpaque()) {
            return false;
        }
        final int lllllllllllllIlIllIllIIIllIlIlll = lllllllllllllIlIllIllIIIllIllIII.getX() - lllllllllllllIlIllIllIIIllIlIIIl.getX() / 2;
        final int lllllllllllllIlIllIllIIIllIlIllI = lllllllllllllIlIllIllIIIllIllIII.getZ() - lllllllllllllIlIllIllIIIllIlIIIl.getZ() / 2;
        for (int lllllllllllllIlIllIllIIIllIlIlIl = lllllllllllllIlIllIllIIIllIlIlll; lllllllllllllIlIllIllIIIllIlIlIl < lllllllllllllIlIllIllIIIllIlIlll + lllllllllllllIlIllIllIIIllIlIIIl.getX(); ++lllllllllllllIlIllIllIIIllIlIlIl) {
            for (int lllllllllllllIlIllIllIIIllIlIlII = lllllllllllllIlIllIllIIIllIllIII.getY(); lllllllllllllIlIllIllIIIllIlIlII < lllllllllllllIlIllIllIIIllIllIII.getY() + lllllllllllllIlIllIllIIIllIlIIIl.getY(); ++lllllllllllllIlIllIllIIIllIlIlII) {
                for (int lllllllllllllIlIllIllIIIllIlIIll = lllllllllllllIlIllIllIIIllIlIllI; lllllllllllllIlIllIllIIIllIlIIll < lllllllllllllIlIllIllIIIllIlIllI + lllllllllllllIlIllIllIIIllIlIIIl.getZ(); ++lllllllllllllIlIllIllIIIllIlIIll) {
                    if (this.worldObj.getBlockState(new BlockPos(lllllllllllllIlIllIllIIIllIlIlIl, lllllllllllllIlIllIllIIIllIlIlII, lllllllllllllIlIllIllIIIllIlIIll)).isNormalCube()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public Village(final World lllllllllllllIlIllIllIIlIIIIllIl) {
        this.villageDoorInfoList = (List<VillageDoorInfo>)Lists.newArrayList();
        this.centerHelper = BlockPos.ORIGIN;
        this.center = BlockPos.ORIGIN;
        this.playerReputation = (Map<String, Integer>)Maps.newHashMap();
        this.villageAgressors = (List<VillageAggressor>)Lists.newArrayList();
        this.worldObj = lllllllllllllIlIllIllIIlIIIIllIl;
    }
    
    private void updateNumVillagers() {
        final List<EntityVillager> lllllllllllllIlIllIllIIIllIIIIIl = this.worldObj.getEntitiesWithinAABB((Class<? extends EntityVillager>)EntityVillager.class, new AxisAlignedBB(this.center.getX() - this.villageRadius, this.center.getY() - 4, this.center.getZ() - this.villageRadius, this.center.getX() + this.villageRadius, this.center.getY() + 4, this.center.getZ() + this.villageRadius));
        this.numVillagers = lllllllllllllIlIllIllIIIllIIIIIl.size();
        if (this.numVillagers == 0) {
            this.playerReputation.clear();
        }
    }
    
    public boolean isMatingSeason() {
        return this.noBreedTicks == 0 || this.tickCounter - this.noBreedTicks >= 3600;
    }
    
    private void removeDeadAndOutOfRangeDoors() {
        boolean lllllllllllllIlIllIllIIIIIIllllI = false;
        final boolean lllllllllllllIlIllIllIIIIIIlllIl = this.worldObj.rand.nextInt(50) == 0;
        final Iterator<VillageDoorInfo> lllllllllllllIlIllIllIIIIIIlllII = this.villageDoorInfoList.iterator();
        while (lllllllllllllIlIllIllIIIIIIlllII.hasNext()) {
            final VillageDoorInfo lllllllllllllIlIllIllIIIIIIllIll = lllllllllllllIlIllIllIIIIIIlllII.next();
            if (lllllllllllllIlIllIllIIIIIIlllIl) {
                lllllllllllllIlIllIllIIIIIIllIll.resetDoorOpeningRestrictionCounter();
            }
            if (!this.isWoodDoor(lllllllllllllIlIllIllIIIIIIllIll.getDoorBlockPos()) || Math.abs(this.tickCounter - lllllllllllllIlIllIllIIIIIIllIll.getInsidePosY()) > 1200) {
                this.centerHelper = this.centerHelper.subtract(lllllllllllllIlIllIllIIIIIIllIll.getDoorBlockPos());
                lllllllllllllIlIllIllIIIIIIllllI = true;
                lllllllllllllIlIllIllIIIIIIllIll.setIsDetachedFromVillageFlag(true);
                lllllllllllllIlIllIllIIIIIIlllII.remove();
            }
        }
        if (lllllllllllllIlIllIllIIIIIIllllI) {
            this.updateVillageRadiusAndCenter();
        }
    }
    
    public int getTicksSinceLastDoorAdding() {
        return this.tickCounter - this.lastAddDoorTimestamp;
    }
    
    public void tick(final int lllllllllllllIlIllIllIIIlllllIll) {
        this.tickCounter = lllllllllllllIlIllIllIIIlllllIll;
        this.removeDeadAndOutOfRangeDoors();
        this.removeDeadAndOldAgressors();
        if (lllllllllllllIlIllIllIIIlllllIll % 20 == 0) {
            this.updateNumVillagers();
        }
        if (lllllllllllllIlIllIllIIIlllllIll % 30 == 0) {
            this.updateNumIronGolems();
        }
        final int lllllllllllllIlIllIllIIIllllllll = this.numVillagers / 10;
        if (this.numIronGolems < lllllllllllllIlIllIllIIIllllllll && this.villageDoorInfoList.size() > 20 && this.worldObj.rand.nextInt(7000) == 0) {
            final Vec3d lllllllllllllIlIllIllIIIlllllllI = this.findRandomSpawnPos(this.center, 2, 4, 2);
            if (lllllllllllllIlIllIllIIIlllllllI != null) {
                final EntityIronGolem lllllllllllllIlIllIllIIIllllllIl = new EntityIronGolem(this.worldObj);
                lllllllllllllIlIllIllIIIllllllIl.setPosition(lllllllllllllIlIllIllIIIlllllllI.xCoord, lllllllllllllIlIllIllIIIlllllllI.yCoord, lllllllllllllIlIllIllIIIlllllllI.zCoord);
                this.worldObj.spawnEntityInWorld(lllllllllllllIlIllIllIIIllllllIl);
                ++this.numIronGolems;
            }
        }
    }
    
    public int modifyPlayerReputation(final String lllllllllllllIlIllIlIllllllIIlll, final int lllllllllllllIlIllIlIllllllIIllI) {
        final int lllllllllllllIlIllIlIllllllIlIlI = this.getPlayerReputation(lllllllllllllIlIllIlIllllllIIlll);
        final int lllllllllllllIlIllIlIllllllIlIIl = MathHelper.clamp(lllllllllllllIlIllIlIllllllIlIlI + lllllllllllllIlIllIlIllllllIIllI, -30, 10);
        this.playerReputation.put(lllllllllllllIlIllIlIllllllIIlll, lllllllllllllIlIllIlIllllllIlIIl);
        return lllllllllllllIlIllIlIllllllIlIIl;
    }
    
    private Vec3d findRandomSpawnPos(final BlockPos lllllllllllllIlIllIllIIIlllIlIII, final int lllllllllllllIlIllIllIIIlllIlllI, final int lllllllllllllIlIllIllIIIlllIllIl, final int lllllllllllllIlIllIllIIIlllIIlIl) {
        for (int lllllllllllllIlIllIllIIIlllIlIll = 0; lllllllllllllIlIllIllIIIlllIlIll < 10; ++lllllllllllllIlIllIllIIIlllIlIll) {
            final BlockPos lllllllllllllIlIllIllIIIlllIlIlI = lllllllllllllIlIllIllIIIlllIlIII.add(this.worldObj.rand.nextInt(16) - 8, this.worldObj.rand.nextInt(6) - 3, this.worldObj.rand.nextInt(16) - 8);
            if (this.isBlockPosWithinSqVillageRadius(lllllllllllllIlIllIllIIIlllIlIlI) && this.isAreaClearAround(new BlockPos(lllllllllllllIlIllIllIIIlllIlllI, lllllllllllllIlIllIllIIIlllIllIl, lllllllllllllIlIllIllIIIlllIIlIl), lllllllllllllIlIllIllIIIlllIlIlI)) {
                return new Vec3d(lllllllllllllIlIllIllIIIlllIlIlI.getX(), lllllllllllllIlIllIllIIIlllIlIlI.getY(), lllllllllllllIlIllIllIIIlllIlIlI.getZ());
            }
        }
        return null;
    }
    
    public void addOrRenewAgressor(final EntityLivingBase lllllllllllllIlIllIllIIIIlIlllII) {
        for (final VillageAggressor lllllllllllllIlIllIllIIIIlIllllI : this.villageAgressors) {
            if (lllllllllllllIlIllIllIIIIlIllllI.agressor == lllllllllllllIlIllIllIIIIlIlllII) {
                lllllllllllllIlIllIllIIIIlIllllI.agressionTime = this.tickCounter;
                return;
            }
        }
        this.villageAgressors.add(new VillageAggressor(lllllllllllllIlIllIllIIIIlIlllII, this.tickCounter));
    }
    
    public void writeVillageDataToNBT(final NBTTagCompound lllllllllllllIlIllIlIllllIlIlllI) {
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("PopSize", this.numVillagers);
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("Radius", this.villageRadius);
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("Golems", this.numIronGolems);
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("Stable", this.lastAddDoorTimestamp);
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("Tick", this.tickCounter);
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("MTick", this.noBreedTicks);
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("CX", this.center.getX());
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("CY", this.center.getY());
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("CZ", this.center.getZ());
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("ACX", this.centerHelper.getX());
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("ACY", this.centerHelper.getY());
        lllllllllllllIlIllIlIllllIlIlllI.setInteger("ACZ", this.centerHelper.getZ());
        final NBTTagList lllllllllllllIlIllIlIllllIllIlll = new NBTTagList();
        for (final VillageDoorInfo lllllllllllllIlIllIlIllllIllIllI : this.villageDoorInfoList) {
            final NBTTagCompound lllllllllllllIlIllIlIllllIllIlIl = new NBTTagCompound();
            lllllllllllllIlIllIlIllllIllIlIl.setInteger("X", lllllllllllllIlIllIlIllllIllIllI.getDoorBlockPos().getX());
            lllllllllllllIlIllIlIllllIllIlIl.setInteger("Y", lllllllllllllIlIllIlIllllIllIllI.getDoorBlockPos().getY());
            lllllllllllllIlIllIlIllllIllIlIl.setInteger("Z", lllllllllllllIlIllIlIllllIllIllI.getDoorBlockPos().getZ());
            lllllllllllllIlIllIlIllllIllIlIl.setInteger("IDX", lllllllllllllIlIllIlIllllIllIllI.getInsideOffsetX());
            lllllllllllllIlIllIlIllllIllIlIl.setInteger("IDZ", lllllllllllllIlIllIlIllllIllIllI.getInsideOffsetZ());
            lllllllllllllIlIllIlIllllIllIlIl.setInteger("TS", lllllllllllllIlIllIlIllllIllIllI.getInsidePosY());
            lllllllllllllIlIllIlIllllIllIlll.appendTag(lllllllllllllIlIllIlIllllIllIlIl);
        }
        lllllllllllllIlIllIlIllllIlIlllI.setTag("Doors", lllllllllllllIlIllIlIllllIllIlll);
        final NBTTagList lllllllllllllIlIllIlIllllIllIlII = new NBTTagList();
        for (final String lllllllllllllIlIllIlIllllIllIIll : this.playerReputation.keySet()) {
            final NBTTagCompound lllllllllllllIlIllIlIllllIllIIlI = new NBTTagCompound();
            final PlayerProfileCache lllllllllllllIlIllIlIllllIllIIIl = this.worldObj.getMinecraftServer().getPlayerProfileCache();
            try {
                final GameProfile lllllllllllllIlIllIlIllllIllIIII = lllllllllllllIlIllIlIllllIllIIIl.getGameProfileForUsername(lllllllllllllIlIllIlIllllIllIIll);
                if (lllllllllllllIlIllIlIllllIllIIII == null) {
                    continue;
                }
                lllllllllllllIlIllIlIllllIllIIlI.setString("UUID", lllllllllllllIlIllIlIllllIllIIII.getId().toString());
                lllllllllllllIlIllIlIllllIllIIlI.setInteger("S", this.playerReputation.get(lllllllllllllIlIllIlIllllIllIIll));
                lllllllllllllIlIllIlIllllIllIlII.appendTag(lllllllllllllIlIllIlIllllIllIIlI);
            }
            catch (RuntimeException ex) {}
        }
        lllllllllllllIlIllIlIllllIlIlllI.setTag("Players", lllllllllllllIlIllIlIllllIllIlII);
    }
    
    public Village() {
        this.villageDoorInfoList = (List<VillageDoorInfo>)Lists.newArrayList();
        this.centerHelper = BlockPos.ORIGIN;
        this.center = BlockPos.ORIGIN;
        this.playerReputation = (Map<String, Integer>)Maps.newHashMap();
        this.villageAgressors = (List<VillageAggressor>)Lists.newArrayList();
    }
    
    public VillageDoorInfo getNearestDoor(final BlockPos lllllllllllllIlIllIllIIIlIIllllI) {
        VillageDoorInfo lllllllllllllIlIllIllIIIlIIlllIl = null;
        int lllllllllllllIlIllIllIIIlIIlllII = Integer.MAX_VALUE;
        for (final VillageDoorInfo lllllllllllllIlIllIllIIIlIIllIll : this.villageDoorInfoList) {
            final int lllllllllllllIlIllIllIIIlIIllIlI = lllllllllllllIlIllIllIIIlIIllIll.getDistanceToDoorBlockSq(lllllllllllllIlIllIllIIIlIIllllI);
            if (lllllllllllllIlIllIllIIIlIIllIlI < lllllllllllllIlIllIllIIIlIIlllII) {
                lllllllllllllIlIllIllIIIlIIlllIl = lllllllllllllIlIllIllIIIlIIllIll;
                lllllllllllllIlIllIllIIIlIIlllII = lllllllllllllIlIllIllIIIlIIllIlI;
            }
        }
        return lllllllllllllIlIllIllIIIlIIlllIl;
    }
    
    private boolean isWoodDoor(final BlockPos lllllllllllllIlIllIllIIIIIIlIIII) {
        final IBlockState lllllllllllllIlIllIllIIIIIIIllll = this.worldObj.getBlockState(lllllllllllllIlIllIllIIIIIIlIIII);
        final Block lllllllllllllIlIllIllIIIIIIIlllI = lllllllllllllIlIllIllIIIIIIIllll.getBlock();
        return lllllllllllllIlIllIllIIIIIIIlllI instanceof BlockDoor && lllllllllllllIlIllIllIIIIIIIllll.getMaterial() == Material.WOOD;
    }
    
    public int getVillageRadius() {
        return this.villageRadius;
    }
    
    public boolean isAnnihilated() {
        return this.villageDoorInfoList.isEmpty();
    }
    
    public int getPlayerReputation(final String lllllllllllllIlIllIlIlllllllIlll) {
        final Integer lllllllllllllIlIllIlIlllllllIllI = this.playerReputation.get(lllllllllllllIlIllIlIlllllllIlll);
        return (lllllllllllllIlIllIlIlllllllIllI == null) ? 0 : lllllllllllllIlIllIlIlllllllIllI;
    }
    
    private void updateNumIronGolems() {
        final List<EntityIronGolem> lllllllllllllIlIllIllIIIllIIIlll = this.worldObj.getEntitiesWithinAABB((Class<? extends EntityIronGolem>)EntityIronGolem.class, new AxisAlignedBB(this.center.getX() - this.villageRadius, this.center.getY() - 4, this.center.getZ() - this.villageRadius, this.center.getX() + this.villageRadius, this.center.getY() + 4, this.center.getZ() + this.villageRadius));
        this.numIronGolems = lllllllllllllIlIllIllIIIllIIIlll.size();
    }
    
    @Nullable
    public EntityLivingBase findNearestVillageAggressor(final EntityLivingBase lllllllllllllIlIllIllIIIIlIlIIIl) {
        double lllllllllllllIlIllIllIIIIlIlIIII = Double.MAX_VALUE;
        VillageAggressor lllllllllllllIlIllIllIIIIlIIllll = null;
        for (int lllllllllllllIlIllIllIIIIlIIlllI = 0; lllllllllllllIlIllIllIIIIlIIlllI < this.villageAgressors.size(); ++lllllllllllllIlIllIllIIIIlIIlllI) {
            final VillageAggressor lllllllllllllIlIllIllIIIIlIIllIl = this.villageAgressors.get(lllllllllllllIlIllIllIIIIlIIlllI);
            final double lllllllllllllIlIllIllIIIIlIIllII = lllllllllllllIlIllIllIIIIlIIllIl.agressor.getDistanceSqToEntity(lllllllllllllIlIllIllIIIIlIlIIIl);
            if (lllllllllllllIlIllIllIIIIlIIllII <= lllllllllllllIlIllIllIIIIlIlIIII) {
                lllllllllllllIlIllIllIIIIlIIllll = lllllllllllllIlIllIllIIIIlIIllIl;
                lllllllllllllIlIllIllIIIIlIlIIII = lllllllllllllIlIllIllIIIIlIIllII;
            }
        }
        return (lllllllllllllIlIllIllIIIIlIIllll == null) ? null : lllllllllllllIlIllIllIIIIlIIllll.agressor;
    }
    
    public void endMatingSeason() {
        this.noBreedTicks = this.tickCounter;
    }
    
    private void removeDeadAndOldAgressors() {
        final Iterator<VillageAggressor> lllllllllllllIlIllIllIIIIIlIlIIl = this.villageAgressors.iterator();
        while (lllllllllllllIlIllIllIIIIIlIlIIl.hasNext()) {
            final VillageAggressor lllllllllllllIlIllIllIIIIIlIlIII = lllllllllllllIlIllIllIIIIIlIlIIl.next();
            if (!lllllllllllllIlIllIllIIIIIlIlIII.agressor.isEntityAlive() || Math.abs(this.tickCounter - lllllllllllllIlIllIllIIIIIlIlIII.agressionTime) > 300) {
                lllllllllllllIlIllIllIIIIIlIlIIl.remove();
            }
        }
    }
    
    public int getNumVillagers() {
        return this.numVillagers;
    }
    
    public EntityPlayer getNearestTargetPlayer(final EntityLivingBase lllllllllllllIlIllIllIIIIIlllIll) {
        double lllllllllllllIlIllIllIIIIIlllIlI = Double.MAX_VALUE;
        EntityPlayer lllllllllllllIlIllIllIIIIIlllIIl = null;
        for (final String lllllllllllllIlIllIllIIIIIlllIII : this.playerReputation.keySet()) {
            if (this.isPlayerReputationTooLow(lllllllllllllIlIllIllIIIIIlllIII)) {
                final EntityPlayer lllllllllllllIlIllIllIIIIIllIlll = this.worldObj.getPlayerEntityByName(lllllllllllllIlIllIllIIIIIlllIII);
                if (lllllllllllllIlIllIllIIIIIllIlll == null) {
                    continue;
                }
                final double lllllllllllllIlIllIllIIIIIllIllI = lllllllllllllIlIllIllIIIIIllIlll.getDistanceSqToEntity(lllllllllllllIlIllIllIIIIIlllIll);
                if (lllllllllllllIlIllIllIIIIIllIllI > lllllllllllllIlIllIllIIIIIlllIlI) {
                    continue;
                }
                lllllllllllllIlIllIllIIIIIlllIIl = lllllllllllllIlIllIllIIIIIllIlll;
                lllllllllllllIlIllIllIIIIIlllIlI = lllllllllllllIlIllIllIIIIIllIllI;
            }
        }
        return lllllllllllllIlIllIllIIIIIlllIIl;
    }
    
    public BlockPos getCenter() {
        return this.center;
    }
    
    public void readVillageDataFromNBT(final NBTTagCompound lllllllllllllIlIllIlIlllllIlIlII) {
        this.numVillagers = lllllllllllllIlIllIlIlllllIlIlII.getInteger("PopSize");
        this.villageRadius = lllllllllllllIlIllIlIlllllIlIlII.getInteger("Radius");
        this.numIronGolems = lllllllllllllIlIllIlIlllllIlIlII.getInteger("Golems");
        this.lastAddDoorTimestamp = lllllllllllllIlIllIlIlllllIlIlII.getInteger("Stable");
        this.tickCounter = lllllllllllllIlIllIlIlllllIlIlII.getInteger("Tick");
        this.noBreedTicks = lllllllllllllIlIllIlIlllllIlIlII.getInteger("MTick");
        this.center = new BlockPos(lllllllllllllIlIllIlIlllllIlIlII.getInteger("CX"), lllllllllllllIlIllIlIlllllIlIlII.getInteger("CY"), lllllllllllllIlIllIlIlllllIlIlII.getInteger("CZ"));
        this.centerHelper = new BlockPos(lllllllllllllIlIllIlIlllllIlIlII.getInteger("ACX"), lllllllllllllIlIllIlIlllllIlIlII.getInteger("ACY"), lllllllllllllIlIllIlIlllllIlIlII.getInteger("ACZ"));
        final NBTTagList lllllllllllllIlIllIlIlllllIlIIll = lllllllllllllIlIllIlIlllllIlIlII.getTagList("Doors", 10);
        for (int lllllllllllllIlIllIlIlllllIlIIlI = 0; lllllllllllllIlIllIlIlllllIlIIlI < lllllllllllllIlIllIlIlllllIlIIll.tagCount(); ++lllllllllllllIlIllIlIlllllIlIIlI) {
            final NBTTagCompound lllllllllllllIlIllIlIlllllIlIIIl = lllllllllllllIlIllIlIlllllIlIIll.getCompoundTagAt(lllllllllllllIlIllIlIlllllIlIIlI);
            final VillageDoorInfo lllllllllllllIlIllIlIlllllIlIIII = new VillageDoorInfo(new BlockPos(lllllllllllllIlIllIlIlllllIlIIIl.getInteger("X"), lllllllllllllIlIllIlIlllllIlIIIl.getInteger("Y"), lllllllllllllIlIllIlIlllllIlIIIl.getInteger("Z")), lllllllllllllIlIllIlIlllllIlIIIl.getInteger("IDX"), lllllllllllllIlIllIlIlllllIlIIIl.getInteger("IDZ"), lllllllllllllIlIllIlIlllllIlIIIl.getInteger("TS"));
            this.villageDoorInfoList.add(lllllllllllllIlIllIlIlllllIlIIII);
        }
        final NBTTagList lllllllllllllIlIllIlIlllllIIllll = lllllllllllllIlIllIlIlllllIlIlII.getTagList("Players", 10);
        for (int lllllllllllllIlIllIlIlllllIIlllI = 0; lllllllllllllIlIllIlIlllllIIlllI < lllllllllllllIlIllIlIlllllIIllll.tagCount(); ++lllllllllllllIlIllIlIlllllIIlllI) {
            final NBTTagCompound lllllllllllllIlIllIlIlllllIIllIl = lllllllllllllIlIllIlIlllllIIllll.getCompoundTagAt(lllllllllllllIlIllIlIlllllIIlllI);
            if (lllllllllllllIlIllIlIlllllIIllIl.hasKey("UUID") && this.worldObj != null && this.worldObj.getMinecraftServer() != null) {
                final PlayerProfileCache lllllllllllllIlIllIlIlllllIIllII = this.worldObj.getMinecraftServer().getPlayerProfileCache();
                final GameProfile lllllllllllllIlIllIlIlllllIIlIll = lllllllllllllIlIllIlIlllllIIllII.getProfileByUUID(UUID.fromString(lllllllllllllIlIllIlIlllllIIllIl.getString("UUID")));
                if (lllllllllllllIlIllIlIlllllIIlIll != null) {
                    this.playerReputation.put(lllllllllllllIlIllIlIlllllIIlIll.getName(), lllllllllllllIlIllIlIlllllIIllIl.getInteger("S"));
                }
            }
            else {
                this.playerReputation.put(lllllllllllllIlIllIlIlllllIIllIl.getString("Name"), lllllllllllllIlIllIlIlllllIIllIl.getInteger("S"));
            }
        }
    }
    
    class VillageAggressor
    {
        public /* synthetic */ int agressionTime;
        public /* synthetic */ EntityLivingBase agressor;
        
        VillageAggressor(final EntityLivingBase lllllllllllllIIllIlIIIIllIlIIlll, final int lllllllllllllIIllIlIIIIllIlIIllI) {
            this.agressor = lllllllllllllIIllIlIIIIllIlIIlll;
            this.agressionTime = lllllllllllllIIllIlIIIIllIlIIllI;
        }
    }
}
