package net.minecraft.village;

import net.minecraft.world.storage.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class VillageCollection extends WorldSavedData
{
    private final /* synthetic */ List<VillageDoorInfo> newDoors;
    private final /* synthetic */ List<Village> villageList;
    private /* synthetic */ int tickCounter;
    private /* synthetic */ World worldObj;
    private final /* synthetic */ List<BlockPos> villagerPositionsList;
    
    private boolean positionInList(final BlockPos lllllllllllllIlIlIllllIIllIIIIIl) {
        for (final BlockPos lllllllllllllIlIlIllllIIllIIIIll : this.villagerPositionsList) {
            if (lllllllllllllIlIlIllllIIllIIIIll.equals(lllllllllllllIlIlIllllIIllIIIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    public static String fileNameForProvider(final WorldProvider lllllllllllllIlIlIllllIIlIIIlllI) {
        return String.valueOf(new StringBuilder("villages").append(lllllllllllllIlIlIllllIIlIIIlllI.getDimensionType().getSuffix()));
    }
    
    public void addToVillagerPositionList(final BlockPos lllllllllllllIlIlIllllIllIllIlIl) {
        if (this.villagerPositionsList.size() <= 64 && !this.positionInList(lllllllllllllIlIlIllllIllIllIlIl)) {
            this.villagerPositionsList.add(lllllllllllllIlIlIllllIllIllIlIl);
        }
    }
    
    public void setWorldsForAll(final World lllllllllllllIlIlIllllIlllIIlIIl) {
        this.worldObj = lllllllllllllIlIlIllllIlllIIlIIl;
        for (final Village lllllllllllllIlIlIllllIlllIIIlll : this.villageList) {
            lllllllllllllIlIlIllllIlllIIIlll.setWorld(lllllllllllllIlIlIllllIlllIIlIIl);
        }
    }
    
    private void removeAnnihilatedVillages() {
        final Iterator<Village> lllllllllllllIlIlIllllIllIIllIlI = this.villageList.iterator();
        while (lllllllllllllIlIlIllllIllIIllIlI.hasNext()) {
            final Village lllllllllllllIlIlIllllIllIIllIII = lllllllllllllIlIlIllllIllIIllIlI.next();
            if (lllllllllllllIlIlIllllIllIIllIII.isAnnihilated()) {
                lllllllllllllIlIlIllllIllIIllIlI.remove();
                this.markDirty();
            }
        }
    }
    
    private boolean isWoodDoor(final BlockPos lllllllllllllIlIlIllllIIlIllIlIl) {
        final IBlockState lllllllllllllIlIlIllllIIlIlllIII = this.worldObj.getBlockState(lllllllllllllIlIlIllllIIlIllIlIl);
        final Block lllllllllllllIlIlIllllIIlIllIlll = lllllllllllllIlIlIllllIIlIlllIII.getBlock();
        return lllllllllllllIlIlIllllIIlIllIlll instanceof BlockDoor && lllllllllllllIlIlIllllIIlIlllIII.getMaterial() == Material.WOOD;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIlIlIllllIIlIlIlIll) {
        this.tickCounter = lllllllllllllIlIlIllllIIlIlIlIll.getInteger("Tick");
        final NBTTagList lllllllllllllIlIlIllllIIlIlIlIlI = lllllllllllllIlIlIllllIIlIlIlIll.getTagList("Villages", 10);
        for (int lllllllllllllIlIlIllllIIlIlIlIIl = 0; lllllllllllllIlIlIllllIIlIlIlIIl < lllllllllllllIlIlIllllIIlIlIlIlI.tagCount(); ++lllllllllllllIlIlIllllIIlIlIlIIl) {
            final NBTTagCompound lllllllllllllIlIlIllllIIlIlIlIII = lllllllllllllIlIlIllllIIlIlIlIlI.getCompoundTagAt(lllllllllllllIlIlIllllIIlIlIlIIl);
            final Village lllllllllllllIlIlIllllIIlIlIIlll = new Village();
            lllllllllllllIlIlIllllIIlIlIIlll.readVillageDataFromNBT(lllllllllllllIlIlIllllIIlIlIlIII);
            this.villageList.add(lllllllllllllIlIlIllllIIlIlIIlll);
        }
    }
    
    private int countBlocksCanSeeSky(final BlockPos lllllllllllllIlIlIllllIIllIIlllI, final EnumFacing lllllllllllllIlIlIllllIIllIlIIll, final int lllllllllllllIlIlIllllIIllIlIIlI) {
        int lllllllllllllIlIlIllllIIllIlIIIl = 0;
        for (int lllllllllllllIlIlIllllIIllIlIIII = 1; lllllllllllllIlIlIllllIIllIlIIII <= 5; ++lllllllllllllIlIlIllllIIllIlIIII) {
            if (this.worldObj.canSeeSky(lllllllllllllIlIlIllllIIllIIlllI.offset(lllllllllllllIlIlIllllIIllIlIIll, lllllllllllllIlIlIllllIIllIlIIII)) && ++lllllllllllllIlIlIllllIIllIlIIIl >= lllllllllllllIlIlIllllIIllIlIIlI) {
                return lllllllllllllIlIlIllllIIllIlIIIl;
            }
        }
        return lllllllllllllIlIlIllllIIllIlIIIl;
    }
    
    @Nullable
    private VillageDoorInfo checkDoorExistence(final BlockPos lllllllllllllIlIlIllllIIllllIllI) {
        for (final VillageDoorInfo lllllllllllllIlIlIllllIIllllIlIl : this.newDoors) {
            if (lllllllllllllIlIlIllllIIllllIlIl.getDoorBlockPos().getX() == lllllllllllllIlIlIllllIIllllIllI.getX() && lllllllllllllIlIlIllllIIllllIlIl.getDoorBlockPos().getZ() == lllllllllllllIlIlIllllIIllllIllI.getZ() && Math.abs(lllllllllllllIlIlIllllIIllllIlIl.getDoorBlockPos().getY() - lllllllllllllIlIlIllllIIllllIllI.getY()) <= 1) {
                return lllllllllllllIlIlIllllIIllllIlIl;
            }
        }
        for (final Village lllllllllllllIlIlIllllIIllllIlII : this.villageList) {
            final VillageDoorInfo lllllllllllllIlIlIllllIIllllIIll = lllllllllllllIlIlIllllIIllllIlII.getExistedDoor(lllllllllllllIlIlIllllIIllllIllI);
            if (lllllllllllllIlIlIllllIIllllIIll != null) {
                return lllllllllllllIlIlIllllIIllllIIll;
            }
        }
        return null;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIlIlIllllIIlIIllIIl) {
        lllllllllllllIlIlIllllIIlIIllIIl.setInteger("Tick", this.tickCounter);
        final NBTTagList lllllllllllllIlIlIllllIIlIIllIII = new NBTTagList();
        for (final Village lllllllllllllIlIlIllllIIlIIlIlll : this.villageList) {
            final NBTTagCompound lllllllllllllIlIlIllllIIlIIlIllI = new NBTTagCompound();
            lllllllllllllIlIlIllllIIlIIlIlll.writeVillageDataToNBT(lllllllllllllIlIlIllllIIlIIlIllI);
            lllllllllllllIlIlIllllIIlIIllIII.appendTag(lllllllllllllIlIlIllllIIlIIlIllI);
        }
        lllllllllllllIlIlIllllIIlIIllIIl.setTag("Villages", lllllllllllllIlIlIllllIIlIIllIII);
        return lllllllllllllIlIlIllllIIlIIllIIl;
    }
    
    public void tick() {
        ++this.tickCounter;
        for (final Village lllllllllllllIlIlIllllIllIlIIlIl : this.villageList) {
            lllllllllllllIlIlIllllIllIlIIlIl.tick(this.tickCounter);
        }
        this.removeAnnihilatedVillages();
        this.dropOldestVillagerPosition();
        this.addNewDoorsToVillageOrCreateVillage();
        if (this.tickCounter % 400 == 0) {
            this.markDirty();
        }
    }
    
    public VillageCollection(final String lllllllllllllIlIlIllllIllllIIlll) {
        super(lllllllllllllIlIlIllllIllllIIlll);
        this.villagerPositionsList = (List<BlockPos>)Lists.newArrayList();
        this.newDoors = (List<VillageDoorInfo>)Lists.newArrayList();
        this.villageList = (List<Village>)Lists.newArrayList();
    }
    
    public VillageCollection(final World lllllllllllllIlIlIllllIlllIlIllI) {
        super(fileNameForProvider(lllllllllllllIlIlIllllIlllIlIllI.provider));
        this.villagerPositionsList = (List<BlockPos>)Lists.newArrayList();
        this.newDoors = (List<VillageDoorInfo>)Lists.newArrayList();
        this.villageList = (List<Village>)Lists.newArrayList();
        this.worldObj = lllllllllllllIlIlIllllIlllIlIllI;
        this.markDirty();
    }
    
    private void dropOldestVillagerPosition() {
        if (!this.villagerPositionsList.isEmpty()) {
            this.addDoorsAround(this.villagerPositionsList.remove(0));
        }
    }
    
    private void addToNewDoorsList(final BlockPos lllllllllllllIlIlIllllIIlllIIllI) {
        final EnumFacing lllllllllllllIlIlIllllIIlllIIlIl = BlockDoor.getFacing(this.worldObj, lllllllllllllIlIlIllllIIlllIIllI);
        final EnumFacing lllllllllllllIlIlIllllIIlllIIlII = lllllllllllllIlIlIllllIIlllIIlIl.getOpposite();
        final int lllllllllllllIlIlIllllIIlllIIIll = this.countBlocksCanSeeSky(lllllllllllllIlIlIllllIIlllIIllI, lllllllllllllIlIlIllllIIlllIIlIl, 5);
        final int lllllllllllllIlIlIllllIIlllIIIlI = this.countBlocksCanSeeSky(lllllllllllllIlIlIllllIIlllIIllI, lllllllllllllIlIlIllllIIlllIIlII, lllllllllllllIlIlIllllIIlllIIIll + 1);
        if (lllllllllllllIlIlIllllIIlllIIIll != lllllllllllllIlIlIllllIIlllIIIlI) {
            this.newDoors.add(new VillageDoorInfo(lllllllllllllIlIlIllllIIlllIIllI, (lllllllllllllIlIlIllllIIlllIIIll < lllllllllllllIlIlIllllIIlllIIIlI) ? lllllllllllllIlIlIllllIIlllIIlIl : lllllllllllllIlIlIllllIIlllIIlII, this.tickCounter));
        }
    }
    
    public Village getNearestVillage(final BlockPos lllllllllllllIlIlIllllIlIlllllII, final int lllllllllllllIlIlIllllIlIllllIll) {
        Village lllllllllllllIlIlIllllIlIllllIlI = null;
        double lllllllllllllIlIlIllllIlIllllIIl = 3.4028234663852886E38;
        for (final Village lllllllllllllIlIlIllllIlIllllIII : this.villageList) {
            final double lllllllllllllIlIlIllllIlIlllIlll = lllllllllllllIlIlIllllIlIllllIII.getCenter().distanceSq(lllllllllllllIlIlIllllIlIlllllII);
            if (lllllllllllllIlIlIllllIlIlllIlll < lllllllllllllIlIlIllllIlIllllIIl) {
                final float lllllllllllllIlIlIllllIlIlllIllI = (float)(lllllllllllllIlIlIllllIlIllllIll + lllllllllllllIlIlIllllIlIllllIII.getVillageRadius());
                if (lllllllllllllIlIlIllllIlIlllIlll > lllllllllllllIlIlIllllIlIlllIllI * lllllllllllllIlIlIllllIlIlllIllI) {
                    continue;
                }
                lllllllllllllIlIlIllllIlIllllIlI = lllllllllllllIlIlIllllIlIllllIII;
                lllllllllllllIlIlIllllIlIllllIIl = lllllllllllllIlIlIllllIlIlllIlll;
            }
        }
        return lllllllllllllIlIlIllllIlIllllIlI;
    }
    
    private void addNewDoorsToVillageOrCreateVillage() {
        for (int lllllllllllllIlIlIllllIlIIlIlIIl = 0; lllllllllllllIlIlIllllIlIIlIlIIl < this.newDoors.size(); ++lllllllllllllIlIlIllllIlIIlIlIIl) {
            final VillageDoorInfo lllllllllllllIlIlIllllIlIIlIlIII = this.newDoors.get(lllllllllllllIlIlIllllIlIIlIlIIl);
            Village lllllllllllllIlIlIllllIlIIlIIlll = this.getNearestVillage(lllllllllllllIlIlIllllIlIIlIlIII.getDoorBlockPos(), 32);
            if (lllllllllllllIlIlIllllIlIIlIIlll == null) {
                lllllllllllllIlIlIllllIlIIlIIlll = new Village(this.worldObj);
                this.villageList.add(lllllllllllllIlIlIllllIlIIlIIlll);
                this.markDirty();
            }
            lllllllllllllIlIlIllllIlIIlIIlll.addVillageDoorInfo(lllllllllllllIlIlIllllIlIIlIlIII);
        }
        this.newDoors.clear();
    }
    
    public List<Village> getVillageList() {
        return this.villageList;
    }
    
    private void addDoorsAround(final BlockPos lllllllllllllIlIlIllllIlIIIIIlIl) {
        final int lllllllllllllIlIlIllllIlIIIIlllI = 16;
        final int lllllllllllllIlIlIllllIlIIIIllIl = 4;
        final int lllllllllllllIlIlIllllIlIIIIllII = 16;
        for (int lllllllllllllIlIlIllllIlIIIIlIll = -16; lllllllllllllIlIlIllllIlIIIIlIll < 16; ++lllllllllllllIlIlIllllIlIIIIlIll) {
            for (int lllllllllllllIlIlIllllIlIIIIlIlI = -4; lllllllllllllIlIlIllllIlIIIIlIlI < 4; ++lllllllllllllIlIlIllllIlIIIIlIlI) {
                for (int lllllllllllllIlIlIllllIlIIIIlIIl = -16; lllllllllllllIlIlIllllIlIIIIlIIl < 16; ++lllllllllllllIlIlIllllIlIIIIlIIl) {
                    final BlockPos lllllllllllllIlIlIllllIlIIIIlIII = lllllllllllllIlIlIllllIlIIIIIlIl.add(lllllllllllllIlIlIllllIlIIIIlIll, lllllllllllllIlIlIllllIlIIIIlIlI, lllllllllllllIlIlIllllIlIIIIlIIl);
                    if (this.isWoodDoor(lllllllllllllIlIlIllllIlIIIIlIII)) {
                        final VillageDoorInfo lllllllllllllIlIlIllllIlIIIIIlll = this.checkDoorExistence(lllllllllllllIlIlIllllIlIIIIlIII);
                        if (lllllllllllllIlIlIllllIlIIIIIlll == null) {
                            this.addToNewDoorsList(lllllllllllllIlIlIllllIlIIIIlIII);
                        }
                        else {
                            lllllllllllllIlIlIllllIlIIIIIlll.setLastActivityTimestamp(this.tickCounter);
                        }
                    }
                }
            }
        }
    }
}
