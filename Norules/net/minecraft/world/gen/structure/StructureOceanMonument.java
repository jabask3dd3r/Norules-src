package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class StructureOceanMonument extends MapGenStructure
{
    private /* synthetic */ int spacing;
    public static final /* synthetic */ List<Biome> WATER_BIOMES;
    private static final /* synthetic */ List<Biome.SpawnListEntry> MONUMENT_ENEMIES;
    private /* synthetic */ int separation;
    public static final /* synthetic */ List<Biome> SPAWN_BIOMES;
    
    @Override
    protected StructureStart getStructureStart(final int lllllllllllllIIlllIIlIlIIIIllIII, final int lllllllllllllIIlllIIlIlIIIIlIlll) {
        return new StartMonument(this.worldObj, this.rand, lllllllllllllIIlllIIlIlIIIIllIII, lllllllllllllIIlllIIlIlIIIIlIlll);
    }
    
    @Override
    public String getStructureName() {
        return "Monument";
    }
    
    public StructureOceanMonument(final Map<String, String> lllllllllllllIIlllIIlIlIIlIlIIII) {
        this();
        for (final Map.Entry<String, String> lllllllllllllIIlllIIlIlIIlIIllll : lllllllllllllIIlllIIlIlIIlIlIIII.entrySet()) {
            if (lllllllllllllIIlllIIlIlIIlIIllll.getKey().equals("spacing")) {
                this.spacing = MathHelper.getInt(lllllllllllllIIlllIIlIlIIlIIllll.getValue(), this.spacing, 1);
            }
            else {
                if (!lllllllllllllIIlllIIlIlIIlIIllll.getKey().equals("separation")) {
                    continue;
                }
                this.separation = MathHelper.getInt(lllllllllllllIIlllIIlIlIIlIIllll.getValue(), this.separation, 1);
            }
        }
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lllllllllllllIIlllIIlIlIIIlIIIll, final BlockPos lllllllllllllIIlllIIlIlIIIIllllI, final boolean lllllllllllllIIlllIIlIlIIIIlllIl) {
        this.worldObj = lllllllllllllIIlllIIlIlIIIlIIIll;
        return MapGenStructure.func_191069_a(lllllllllllllIIlllIIlIlIIIlIIIll, this, lllllllllllllIIlllIIlIlIIIIllllI, this.spacing, this.separation, 10387313, true, 100, lllllllllllllIIlllIIlIlIIIIlllIl);
    }
    
    public StructureOceanMonument() {
        this.spacing = 32;
        this.separation = 5;
    }
    
    static {
        WATER_BIOMES = Arrays.asList(Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER);
        SPAWN_BIOMES = Arrays.asList(Biomes.DEEP_OCEAN);
        (MONUMENT_ENEMIES = Lists.newArrayList()).add(new Biome.SpawnListEntry(EntityGuardian.class, 1, 2, 4));
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int lllllllllllllIIlllIIlIlIIIllIIII, int lllllllllllllIIlllIIlIlIIIlIllll) {
        final int lllllllllllllIIlllIIlIlIIIllIlll = (int)lllllllllllllIIlllIIlIlIIIllIIII;
        final int lllllllllllllIIlllIIlIlIIIllIllI = lllllllllllllIIlllIIlIlIIIlIllll;
        if (lllllllllllllIIlllIIlIlIIIllIIII < 0) {
            lllllllllllllIIlllIIlIlIIIllIIII -= this.spacing - 1;
        }
        if (lllllllllllllIIlllIIlIlIIIlIllll < 0) {
            lllllllllllllIIlllIIlIlIIIlIllll -= this.spacing - 1;
        }
        int lllllllllllllIIlllIIlIlIIIllIlIl = (int)(lllllllllllllIIlllIIlIlIIIllIIII / this.spacing);
        int lllllllllllllIIlllIIlIlIIIllIlII = lllllllllllllIIlllIIlIlIIIlIllll / this.spacing;
        final Random lllllllllllllIIlllIIlIlIIIllIIll = this.worldObj.setRandomSeed(lllllllllllllIIlllIIlIlIIIllIlIl, lllllllllllllIIlllIIlIlIIIllIlII, 10387313);
        lllllllllllllIIlllIIlIlIIIllIlIl *= this.spacing;
        lllllllllllllIIlllIIlIlIIIllIlII *= this.spacing;
        lllllllllllllIIlllIIlIlIIIllIlIl += (lllllllllllllIIlllIIlIlIIIllIIll.nextInt(this.spacing - this.separation) + lllllllllllllIIlllIIlIlIIIllIIll.nextInt(this.spacing - this.separation)) / 2;
        lllllllllllllIIlllIIlIlIIIllIlII += (lllllllllllllIIlllIIlIlIIIllIIll.nextInt(this.spacing - this.separation) + lllllllllllllIIlllIIlIlIIIllIIll.nextInt(this.spacing - this.separation)) / 2;
        if (lllllllllllllIIlllIIlIlIIIllIlll == lllllllllllllIIlllIIlIlIIIllIlIl && lllllllllllllIIlllIIlIlIIIllIllI == lllllllllllllIIlllIIlIlIIIllIlII) {
            if (!this.worldObj.getBiomeProvider().areBiomesViable(lllllllllllllIIlllIIlIlIIIllIlll * 16 + 8, lllllllllllllIIlllIIlIlIIIllIllI * 16 + 8, 16, StructureOceanMonument.SPAWN_BIOMES)) {
                return false;
            }
            final boolean lllllllllllllIIlllIIlIlIIIllIIlI = this.worldObj.getBiomeProvider().areBiomesViable(lllllllllllllIIlllIIlIlIIIllIlll * 16 + 8, lllllllllllllIIlllIIlIlIIIllIllI * 16 + 8, 29, StructureOceanMonument.WATER_BIOMES);
            if (lllllllllllllIIlllIIlIlIIIllIIlI) {
                return true;
            }
        }
        return false;
    }
    
    public List<Biome.SpawnListEntry> getScatteredFeatureSpawnList() {
        return StructureOceanMonument.MONUMENT_ENEMIES;
    }
    
    public static class StartMonument extends StructureStart
    {
        private final /* synthetic */ Set<ChunkPos> processed;
        private /* synthetic */ boolean wasCreated;
        
        @Override
        public void notifyPostProcessAt(final ChunkPos llllllllllllllIIIIIIlllIIlIlIIII) {
            super.notifyPostProcessAt(llllllllllllllIIIIIIlllIIlIlIIII);
            this.processed.add(llllllllllllllIIIIIIlllIIlIlIIII);
        }
        
        @Override
        public boolean isValidForPostProcess(final ChunkPos llllllllllllllIIIIIIlllIIlIllIII) {
            return !this.processed.contains(llllllllllllllIIIIIIlllIIlIllIII) && super.isValidForPostProcess(llllllllllllllIIIIIIlllIIlIllIII);
        }
        
        @Override
        public void readFromNBT(final NBTTagCompound llllllllllllllIIIIIIlllIIIlllIII) {
            super.readFromNBT(llllllllllllllIIIIIIlllIIIlllIII);
            if (llllllllllllllIIIIIIlllIIIlllIII.hasKey("Processed", 9)) {
                final NBTTagList llllllllllllllIIIIIIlllIIIllIlll = llllllllllllllIIIIIIlllIIIlllIII.getTagList("Processed", 10);
                for (int llllllllllllllIIIIIIlllIIIllIllI = 0; llllllllllllllIIIIIIlllIIIllIllI < llllllllllllllIIIIIIlllIIIllIlll.tagCount(); ++llllllllllllllIIIIIIlllIIIllIllI) {
                    final NBTTagCompound llllllllllllllIIIIIIlllIIIllIlIl = llllllllllllllIIIIIIlllIIIllIlll.getCompoundTagAt(llllllllllllllIIIIIIlllIIIllIllI);
                    this.processed.add(new ChunkPos(llllllllllllllIIIIIIlllIIIllIlIl.getInteger("X"), llllllllllllllIIIIIIlllIIIllIlIl.getInteger("Z")));
                }
            }
        }
        
        public StartMonument() {
            this.processed = (Set<ChunkPos>)Sets.newHashSet();
        }
        
        @Override
        public void writeToNBT(final NBTTagCompound llllllllllllllIIIIIIlllIIlIIIIll) {
            super.writeToNBT(llllllllllllllIIIIIIlllIIlIIIIll);
            final NBTTagList llllllllllllllIIIIIIlllIIlIIIlll = new NBTTagList();
            for (final ChunkPos llllllllllllllIIIIIIlllIIlIIIllI : this.processed) {
                final NBTTagCompound llllllllllllllIIIIIIlllIIlIIIlIl = new NBTTagCompound();
                llllllllllllllIIIIIIlllIIlIIIlIl.setInteger("X", llllllllllllllIIIIIIlllIIlIIIllI.chunkXPos);
                llllllllllllllIIIIIIlllIIlIIIlIl.setInteger("Z", llllllllllllllIIIIIIlllIIlIIIllI.chunkZPos);
                llllllllllllllIIIIIIlllIIlIIIlll.appendTag(llllllllllllllIIIIIIlllIIlIIIlIl);
            }
            llllllllllllllIIIIIIlllIIlIIIIll.setTag("Processed", llllllllllllllIIIIIIlllIIlIIIlll);
        }
        
        private void create(final World llllllllllllllIIIIIIlllIIllllllI, final Random llllllllllllllIIIIIIlllIIlllIIIl, final int llllllllllllllIIIIIIlllIIlllllII, final int llllllllllllllIIIIIIlllIIllIllll) {
            llllllllllllllIIIIIIlllIIlllIIIl.setSeed(llllllllllllllIIIIIIlllIIllllllI.getSeed());
            final long llllllllllllllIIIIIIlllIIllllIlI = llllllllllllllIIIIIIlllIIlllIIIl.nextLong();
            final long llllllllllllllIIIIIIlllIIllllIIl = llllllllllllllIIIIIIlllIIlllIIIl.nextLong();
            final long llllllllllllllIIIIIIlllIIllllIII = llllllllllllllIIIIIIlllIIlllllII * llllllllllllllIIIIIIlllIIllllIlI;
            final long llllllllllllllIIIIIIlllIIlllIlll = llllllllllllllIIIIIIlllIIllIllll * llllllllllllllIIIIIIlllIIllllIIl;
            llllllllllllllIIIIIIlllIIlllIIIl.setSeed(llllllllllllllIIIIIIlllIIllllIII ^ llllllllllllllIIIIIIlllIIlllIlll ^ llllllllllllllIIIIIIlllIIllllllI.getSeed());
            final int llllllllllllllIIIIIIlllIIlllIllI = llllllllllllllIIIIIIlllIIlllllII * 16 + 8 - 29;
            final int llllllllllllllIIIIIIlllIIlllIlIl = llllllllllllllIIIIIIlllIIllIllll * 16 + 8 - 29;
            final EnumFacing llllllllllllllIIIIIIlllIIlllIlII = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIIIIIIlllIIlllIIIl);
            this.components.add(new StructureOceanMonumentPieces.MonumentBuilding(llllllllllllllIIIIIIlllIIlllIIIl, llllllllllllllIIIIIIlllIIlllIllI, llllllllllllllIIIIIIlllIIlllIlIl, llllllllllllllIIIIIIlllIIlllIlII));
            this.updateBoundingBox();
            this.wasCreated = true;
        }
        
        public StartMonument(final World llllllllllllllIIIIIIlllIlIIllIll, final Random llllllllllllllIIIIIIlllIlIIllIIl, final int llllllllllllllIIIIIIlllIlIlIIIIl, final int llllllllllllllIIIIIIlllIlIIlllll) {
            super(llllllllllllllIIIIIIlllIlIlIIIIl, llllllllllllllIIIIIIlllIlIIlllll);
            this.processed = (Set<ChunkPos>)Sets.newHashSet();
            this.create(llllllllllllllIIIIIIlllIlIIllIll, llllllllllllllIIIIIIlllIlIIllIIl, llllllllllllllIIIIIIlllIlIlIIIIl, llllllllllllllIIIIIIlllIlIIlllll);
        }
        
        @Override
        public void generateStructure(final World llllllllllllllIIIIIIlllIIllIIIlI, final Random llllllllllllllIIIIIIlllIIlIlllIl, final StructureBoundingBox llllllllllllllIIIIIIlllIIllIIIII) {
            if (!this.wasCreated) {
                this.components.clear();
                this.create(llllllllllllllIIIIIIlllIIllIIIlI, llllllllllllllIIIIIIlllIIlIlllIl, this.getChunkPosX(), this.getChunkPosZ());
            }
            super.generateStructure(llllllllllllllIIIIIIlllIIllIIIlI, llllllllllllllIIIIIIlllIIlIlllIl, llllllllllllllIIIIIIlllIIllIIIII);
        }
    }
}
