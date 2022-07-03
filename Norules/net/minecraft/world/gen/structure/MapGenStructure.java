package net.minecraft.world.gen.structure;

import net.minecraft.world.gen.*;
import net.minecraft.world.*;
import it.unimi.dsi.fastutil.objects.*;
import javax.annotation.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import net.minecraft.util.math.*;
import java.util.*;
import it.unimi.dsi.fastutil.longs.*;
import net.minecraft.world.storage.*;
import net.minecraft.nbt.*;

public abstract class MapGenStructure extends MapGenBase
{
    private /* synthetic */ MapGenStructureData structureData;
    protected /* synthetic */ Long2ObjectMap<StructureStart> structureMap;
    
    public synchronized boolean generateStructure(final World lllllllllllllIlIIIIIlllIlIIIIlll, final Random lllllllllllllIlIIIIIlllIlIIIIllI, final ChunkPos lllllllllllllIlIIIIIlllIlIIIIlIl) {
        this.initializeStructureData(lllllllllllllIlIIIIIlllIlIIIIlll);
        final int lllllllllllllIlIIIIIlllIlIIIllIl = (lllllllllllllIlIIIIIlllIlIIIIlIl.chunkXPos << 4) + 8;
        final int lllllllllllllIlIIIIIlllIlIIIllII = (lllllllllllllIlIIIIIlllIlIIIIlIl.chunkZPos << 4) + 8;
        boolean lllllllllllllIlIIIIIlllIlIIIlIll = false;
        for (final StructureStart lllllllllllllIlIIIIIlllIlIIIlIIl : this.structureMap.values()) {
            if (lllllllllllllIlIIIIIlllIlIIIlIIl.isSizeableStructure() && lllllllllllllIlIIIIIlllIlIIIlIIl.isValidForPostProcess(lllllllllllllIlIIIIIlllIlIIIIlIl) && lllllllllllllIlIIIIIlllIlIIIlIIl.getBoundingBox().intersectsWith(lllllllllllllIlIIIIIlllIlIIIllIl, lllllllllllllIlIIIIIlllIlIIIllII, lllllllllllllIlIIIIIlllIlIIIllIl + 15, lllllllllllllIlIIIIIlllIlIIIllII + 15)) {
                lllllllllllllIlIIIIIlllIlIIIlIIl.generateStructure(lllllllllllllIlIIIIIlllIlIIIIlll, lllllllllllllIlIIIIIlllIlIIIIllI, new StructureBoundingBox(lllllllllllllIlIIIIIlllIlIIIllIl, lllllllllllllIlIIIIIlllIlIIIllII, lllllllllllllIlIIIIIlllIlIIIllIl + 15, lllllllllllllIlIIIIIlllIlIIIllII + 15));
                lllllllllllllIlIIIIIlllIlIIIlIIl.notifyPostProcessAt(lllllllllllllIlIIIIIlllIlIIIIlIl);
                lllllllllllllIlIIIIIlllIlIIIlIll = true;
                this.setStructureStart(lllllllllllllIlIIIIIlllIlIIIlIIl.getChunkPosX(), lllllllllllllIlIIIIIlllIlIIIlIIl.getChunkPosZ(), lllllllllllllIlIIIIIlllIlIIIlIIl);
            }
        }
        return lllllllllllllIlIIIIIlllIlIIIlIll;
    }
    
    protected static BlockPos func_191069_a(final World lllllllllllllIlIIIIIlllIIIIIIIll, final MapGenStructure lllllllllllllIlIIIIIlllIIIIllIII, final BlockPos lllllllllllllIlIIIIIlllIIIIlIlll, final int lllllllllllllIlIIIIIlllIIIIlIllI, final int lllllllllllllIlIIIIIllIlllllllll, final int lllllllllllllIlIIIIIlllIIIIlIlII, final boolean lllllllllllllIlIIIIIllIlllllllIl, final int lllllllllllllIlIIIIIlllIIIIlIIlI, final boolean lllllllllllllIlIIIIIlllIIIIlIIIl) {
        final int lllllllllllllIlIIIIIlllIIIIlIIII = lllllllllllllIlIIIIIlllIIIIlIlll.getX() >> 4;
        final int lllllllllllllIlIIIIIlllIIIIIllll = lllllllllllllIlIIIIIlllIIIIlIlll.getZ() >> 4;
        int lllllllllllllIlIIIIIlllIIIIIlllI = 0;
        final Random lllllllllllllIlIIIIIlllIIIIIllIl = new Random();
        while (lllllllllllllIlIIIIIlllIIIIIlllI <= lllllllllllllIlIIIIIlllIIIIlIIlI) {
            for (int lllllllllllllIlIIIIIlllIIIIIllII = -lllllllllllllIlIIIIIlllIIIIIlllI; lllllllllllllIlIIIIIlllIIIIIllII <= lllllllllllllIlIIIIIlllIIIIIlllI; ++lllllllllllllIlIIIIIlllIIIIIllII) {
                final boolean lllllllllllllIlIIIIIlllIIIIIlIll = lllllllllllllIlIIIIIlllIIIIIllII == -lllllllllllllIlIIIIIlllIIIIIlllI || lllllllllllllIlIIIIIlllIIIIIllII == lllllllllllllIlIIIIIlllIIIIIlllI;
                for (int lllllllllllllIlIIIIIlllIIIIIlIlI = -lllllllllllllIlIIIIIlllIIIIIlllI; lllllllllllllIlIIIIIlllIIIIIlIlI <= lllllllllllllIlIIIIIlllIIIIIlllI; ++lllllllllllllIlIIIIIlllIIIIIlIlI) {
                    final boolean lllllllllllllIlIIIIIlllIIIIIlIIl = lllllllllllllIlIIIIIlllIIIIIlIlI == -lllllllllllllIlIIIIIlllIIIIIlllI || lllllllllllllIlIIIIIlllIIIIIlIlI == lllllllllllllIlIIIIIlllIIIIIlllI;
                    if (lllllllllllllIlIIIIIlllIIIIIlIll || lllllllllllllIlIIIIIlllIIIIIlIIl) {
                        int lllllllllllllIlIIIIIlllIIIIIlIII = lllllllllllllIlIIIIIlllIIIIlIIII + lllllllllllllIlIIIIIlllIIIIlIllI * lllllllllllllIlIIIIIlllIIIIIllII;
                        int lllllllllllllIlIIIIIlllIIIIIIlll = lllllllllllllIlIIIIIlllIIIIIllll + lllllllllllllIlIIIIIlllIIIIlIllI * lllllllllllllIlIIIIIlllIIIIIlIlI;
                        if (lllllllllllllIlIIIIIlllIIIIIlIII < 0) {
                            lllllllllllllIlIIIIIlllIIIIIlIII -= lllllllllllllIlIIIIIlllIIIIlIllI - 1;
                        }
                        if (lllllllllllllIlIIIIIlllIIIIIIlll < 0) {
                            lllllllllllllIlIIIIIlllIIIIIIlll -= lllllllllllllIlIIIIIlllIIIIlIllI - 1;
                        }
                        int lllllllllllllIlIIIIIlllIIIIIIllI = lllllllllllllIlIIIIIlllIIIIIlIII / lllllllllllllIlIIIIIlllIIIIlIllI;
                        int lllllllllllllIlIIIIIlllIIIIIIlIl = lllllllllllllIlIIIIIlllIIIIIIlll / lllllllllllllIlIIIIIlllIIIIlIllI;
                        final Random lllllllllllllIlIIIIIlllIIIIIIlII = lllllllllllllIlIIIIIlllIIIIIIIll.setRandomSeed(lllllllllllllIlIIIIIlllIIIIIIllI, lllllllllllllIlIIIIIlllIIIIIIlIl, lllllllllllllIlIIIIIlllIIIIlIlII);
                        lllllllllllllIlIIIIIlllIIIIIIllI *= lllllllllllllIlIIIIIlllIIIIlIllI;
                        lllllllllllllIlIIIIIlllIIIIIIlIl *= lllllllllllllIlIIIIIlllIIIIlIllI;
                        if (lllllllllllllIlIIIIIllIlllllllIl) {
                            lllllllllllllIlIIIIIlllIIIIIIllI += (lllllllllllllIlIIIIIlllIIIIIIlII.nextInt(lllllllllllllIlIIIIIlllIIIIlIllI - lllllllllllllIlIIIIIllIlllllllll) + lllllllllllllIlIIIIIlllIIIIIIlII.nextInt(lllllllllllllIlIIIIIlllIIIIlIllI - lllllllllllllIlIIIIIllIlllllllll)) / 2;
                            lllllllllllllIlIIIIIlllIIIIIIlIl += (lllllllllllllIlIIIIIlllIIIIIIlII.nextInt(lllllllllllllIlIIIIIlllIIIIlIllI - lllllllllllllIlIIIIIllIlllllllll) + lllllllllllllIlIIIIIlllIIIIIIlII.nextInt(lllllllllllllIlIIIIIlllIIIIlIllI - lllllllllllllIlIIIIIllIlllllllll)) / 2;
                        }
                        else {
                            lllllllllllllIlIIIIIlllIIIIIIllI += lllllllllllllIlIIIIIlllIIIIIIlII.nextInt(lllllllllllllIlIIIIIlllIIIIlIllI - lllllllllllllIlIIIIIllIlllllllll);
                            lllllllllllllIlIIIIIlllIIIIIIlIl += lllllllllllllIlIIIIIlllIIIIIIlII.nextInt(lllllllllllllIlIIIIIlllIIIIlIllI - lllllllllllllIlIIIIIllIlllllllll);
                        }
                        MapGenBase.func_191068_a(lllllllllllllIlIIIIIlllIIIIIIIll.getSeed(), lllllllllllllIlIIIIIlllIIIIIllIl, lllllllllllllIlIIIIIlllIIIIIIllI, lllllllllllllIlIIIIIlllIIIIIIlIl);
                        lllllllllllllIlIIIIIlllIIIIIllIl.nextInt();
                        if (lllllllllllllIlIIIIIlllIIIIllIII.canSpawnStructureAtCoords(lllllllllllllIlIIIIIlllIIIIIIllI, lllllllllllllIlIIIIIlllIIIIIIlIl)) {
                            if (!lllllllllllllIlIIIIIlllIIIIlIIIl || !lllllllllllllIlIIIIIlllIIIIIIIll.func_190526_b(lllllllllllllIlIIIIIlllIIIIIIllI, lllllllllllllIlIIIIIlllIIIIIIlIl)) {
                                return new BlockPos((lllllllllllllIlIIIIIlllIIIIIIllI << 4) + 8, 64, (lllllllllllllIlIIIIIlllIIIIIIlIl << 4) + 8);
                            }
                        }
                        else if (lllllllllllllIlIIIIIlllIIIIIlllI == 0) {
                            break;
                        }
                    }
                }
                if (lllllllllllllIlIIIIIlllIIIIIlllI == 0) {
                    break;
                }
            }
            ++lllllllllllllIlIIIIIlllIIIIIlllI;
        }
        return null;
    }
    
    @Nullable
    public abstract BlockPos getClosestStrongholdPos(final World p0, final BlockPos p1, final boolean p2);
    
    protected abstract StructureStart getStructureStart(final int p0, final int p1);
    
    @Override
    protected final synchronized void recursiveGenerate(final World lllllllllllllIlIIIIIlllIlIlIlIll, final int lllllllllllllIlIIIIIlllIlIIlllll, final int lllllllllllllIlIIIIIlllIlIIllllI, final int lllllllllllllIlIIIIIlllIlIlIlIII, final int lllllllllllllIlIIIIIlllIlIlIIlll, final ChunkPrimer lllllllllllllIlIIIIIlllIlIlIIllI) {
        this.initializeStructureData(lllllllllllllIlIIIIIlllIlIlIlIll);
        if (!this.structureMap.containsKey(ChunkPos.asLong(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI))) {
            this.rand.nextInt();
            try {
                if (this.canSpawnStructureAtCoords(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI)) {
                    final StructureStart lllllllllllllIlIIIIIlllIlIlIIlIl = this.getStructureStart(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI);
                    this.structureMap.put(ChunkPos.asLong(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI), (Object)lllllllllllllIlIIIIIlllIlIlIIlIl);
                    if (lllllllllllllIlIIIIIlllIlIlIIlIl.isSizeableStructure()) {
                        this.setStructureStart(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI, lllllllllllllIlIIIIIlllIlIlIIlIl);
                    }
                }
            }
            catch (Throwable lllllllllllllIlIIIIIlllIlIlIIlII) {
                final CrashReport lllllllllllllIlIIIIIlllIlIlIIIll = CrashReport.makeCrashReport(lllllllllllllIlIIIIIlllIlIlIIlII, "Exception preparing structure feature");
                final CrashReportCategory lllllllllllllIlIIIIIlllIlIlIIIlI = lllllllllllllIlIIIIIlllIlIlIIIll.makeCategory("Feature being prepared");
                lllllllllllllIlIIIIIlllIlIlIIIlI.setDetail("Is feature chunk", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return MapGenStructure.this.canSpawnStructureAtCoords(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI) ? "True" : "False";
                    }
                });
                lllllllllllllIlIIIIIlllIlIlIIIlI.addCrashSection("Chunk location", String.format("%d,%d", lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI));
                lllllllllllllIlIIIIIlllIlIlIIIlI.setDetail("Chunk pos hash", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return String.valueOf(ChunkPos.asLong(lllllllllllllIlIIIIIlllIlIIlllll, lllllllllllllIlIIIIIlllIlIIllllI));
                    }
                });
                lllllllllllllIlIIIIIlllIlIlIIIlI.setDetail("Structure type", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return MapGenStructure.this.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(lllllllllllllIlIIIIIlllIlIlIIIll);
            }
        }
    }
    
    @Nullable
    protected StructureStart getStructureAt(final BlockPos lllllllllllllIlIIIIIlllIIlllIIlI) {
        for (final StructureStart lllllllllllllIlIIIIIlllIIlllIIII : this.structureMap.values()) {
            if (lllllllllllllIlIIIIIlllIIlllIIII.isSizeableStructure() && lllllllllllllIlIIIIIlllIIlllIIII.getBoundingBox().isVecInside(lllllllllllllIlIIIIIlllIIlllIIlI)) {
                for (final StructureComponent lllllllllllllIlIIIIIlllIIllIlllI : lllllllllllllIlIIIIIlllIIlllIIII.getComponents()) {
                    if (lllllllllllllIlIIIIIlllIIllIlllI.getBoundingBox().isVecInside(lllllllllllllIlIIIIIlllIIlllIIlI)) {
                        return lllllllllllllIlIIIIIlllIIlllIIII;
                    }
                }
            }
        }
        return null;
    }
    
    public boolean isPositionInStructure(final World lllllllllllllIlIIIIIlllIIlIlllII, final BlockPos lllllllllllllIlIIIIIlllIIlIllIll) {
        this.initializeStructureData(lllllllllllllIlIIIIIlllIIlIlllII);
        for (final StructureStart lllllllllllllIlIIIIIlllIIlIllllI : this.structureMap.values()) {
            if (lllllllllllllIlIIIIIlllIIlIllllI.isSizeableStructure() && lllllllllllllIlIIIIIlllIIlIllllI.getBoundingBox().isVecInside(lllllllllllllIlIIIIIlllIIlIllIll)) {
                return true;
            }
        }
        return false;
    }
    
    private void setStructureStart(final int lllllllllllllIlIIIIIlllIIIllIIlI, final int lllllllllllllIlIIIIIlllIIIllIlIl, final StructureStart lllllllllllllIlIIIIIlllIIIllIIII) {
        this.structureData.writeInstance(lllllllllllllIlIIIIIlllIIIllIIII.writeStructureComponentsToNBT(lllllllllllllIlIIIIIlllIIIllIIlI, lllllllllllllIlIIIIIlllIIIllIlIl), lllllllllllllIlIIIIIlllIIIllIIlI, lllllllllllllIlIIIIIlllIIIllIlIl);
        this.structureData.markDirty();
    }
    
    public abstract String getStructureName();
    
    public boolean isInsideStructure(final BlockPos lllllllllllllIlIIIIIlllIIllllIlI) {
        if (this.worldObj == null) {
            return false;
        }
        this.initializeStructureData(this.worldObj);
        return this.getStructureAt(lllllllllllllIlIIIIIlllIIllllIlI) != null;
    }
    
    public MapGenStructure() {
        this.structureMap = (Long2ObjectMap<StructureStart>)new Long2ObjectOpenHashMap(1024);
    }
    
    protected abstract boolean canSpawnStructureAtCoords(final int p0, final int p1);
    
    protected void initializeStructureData(final World lllllllllllllIlIIIIIlllIIlIIIlII) {
        if (this.structureData == null && lllllllllllllIlIIIIIlllIIlIIIlII != null) {
            this.structureData = (MapGenStructureData)lllllllllllllIlIIIIIlllIIlIIIlII.loadItemData(MapGenStructureData.class, this.getStructureName());
            if (this.structureData == null) {
                this.structureData = new MapGenStructureData(this.getStructureName());
                lllllllllllllIlIIIIIlllIIlIIIlII.setItemData(this.getStructureName(), this.structureData);
            }
            else {
                final NBTTagCompound lllllllllllllIlIIIIIlllIIlIIllII = this.structureData.getTagCompound();
                for (final String lllllllllllllIlIIIIIlllIIlIIlIll : lllllllllllllIlIIIIIlllIIlIIllII.getKeySet()) {
                    final NBTBase lllllllllllllIlIIIIIlllIIlIIlIlI = lllllllllllllIlIIIIIlllIIlIIllII.getTag(lllllllllllllIlIIIIIlllIIlIIlIll);
                    if (lllllllllllllIlIIIIIlllIIlIIlIlI.getId() == 10) {
                        final NBTTagCompound lllllllllllllIlIIIIIlllIIlIIlIIl = (NBTTagCompound)lllllllllllllIlIIIIIlllIIlIIlIlI;
                        if (!lllllllllllllIlIIIIIlllIIlIIlIIl.hasKey("ChunkX") || !lllllllllllllIlIIIIIlllIIlIIlIIl.hasKey("ChunkZ")) {
                            continue;
                        }
                        final int lllllllllllllIlIIIIIlllIIlIIlIII = lllllllllllllIlIIIIIlllIIlIIlIIl.getInteger("ChunkX");
                        final int lllllllllllllIlIIIIIlllIIlIIIlll = lllllllllllllIlIIIIIlllIIlIIlIIl.getInteger("ChunkZ");
                        final StructureStart lllllllllllllIlIIIIIlllIIlIIIllI = MapGenStructureIO.getStructureStart(lllllllllllllIlIIIIIlllIIlIIlIIl, lllllllllllllIlIIIIIlllIIlIIIlII);
                        if (lllllllllllllIlIIIIIlllIIlIIIllI == null) {
                            continue;
                        }
                        this.structureMap.put(ChunkPos.asLong(lllllllllllllIlIIIIIlllIIlIIlIII, lllllllllllllIlIIIIIlllIIlIIIlll), (Object)lllllllllllllIlIIIIIlllIIlIIIllI);
                    }
                }
            }
        }
    }
}
