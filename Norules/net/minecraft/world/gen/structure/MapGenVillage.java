package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.nbt.*;

public class MapGenVillage extends MapGenStructure
{
    public static final /* synthetic */ List<Biome> VILLAGE_SPAWN_BIOMES;
    private /* synthetic */ int size;
    private /* synthetic */ int distance;
    private final /* synthetic */ int minTownSeparation;
    
    @Override
    protected StructureStart getStructureStart(final int llllllllllllllIIlIlIIIlllIlllIlI, final int llllllllllllllIIlIlIIIlllIlllIIl) {
        return new Start(this.worldObj, this.rand, llllllllllllllIIlIlIIIlllIlllIlI, llllllllllllllIIlIlIIIlllIlllIIl, this.size);
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World llllllllllllllIIlIlIIIllllIIIlIl, final BlockPos llllllllllllllIIlIlIIIllllIIIlII, final boolean llllllllllllllIIlIlIIIlllIllllll) {
        this.worldObj = llllllllllllllIIlIlIIIllllIIIlIl;
        return MapGenStructure.func_191069_a(llllllllllllllIIlIlIIIllllIIIlIl, this, llllllllllllllIIlIlIIIllllIIIlII, this.distance, 8, 10387312, false, 100, llllllllllllllIIlIlIIIlllIllllll);
    }
    
    public MapGenVillage(final Map<String, String> llllllllllllllIIlIlIIIlllllIlIIl) {
        this();
        for (final Map.Entry<String, String> llllllllllllllIIlIlIIIlllllIlIll : llllllllllllllIIlIlIIIlllllIlIIl.entrySet()) {
            if (llllllllllllllIIlIlIIIlllllIlIll.getKey().equals("size")) {
                this.size = MathHelper.getInt(llllllllllllllIIlIlIIIlllllIlIll.getValue(), this.size, 0);
            }
            else {
                if (!llllllllllllllIIlIlIIIlllllIlIll.getKey().equals("distance")) {
                    continue;
                }
                this.distance = MathHelper.getInt(llllllllllllllIIlIlIIIlllllIlIll.getValue(), this.distance, 9);
            }
        }
    }
    
    static {
        VILLAGE_SPAWN_BIOMES = Arrays.asList(Biomes.PLAINS, Biomes.DESERT, Biomes.SAVANNA, Biomes.TAIGA);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int llllllllllllllIIlIlIIIllllIlIIlI, int llllllllllllllIIlIlIIIllllIlIIIl) {
        final int llllllllllllllIIlIlIIIllllIllIIl = (int)llllllllllllllIIlIlIIIllllIlIIlI;
        final int llllllllllllllIIlIlIIIllllIllIII = llllllllllllllIIlIlIIIllllIlIIIl;
        if (llllllllllllllIIlIlIIIllllIlIIlI < 0) {
            llllllllllllllIIlIlIIIllllIlIIlI -= this.distance - 1;
        }
        if (llllllllllllllIIlIlIIIllllIlIIIl < 0) {
            llllllllllllllIIlIlIIIllllIlIIIl -= this.distance - 1;
        }
        int llllllllllllllIIlIlIIIllllIlIlll = (int)(llllllllllllllIIlIlIIIllllIlIIlI / this.distance);
        int llllllllllllllIIlIlIIIllllIlIllI = llllllllllllllIIlIlIIIllllIlIIIl / this.distance;
        final Random llllllllllllllIIlIlIIIllllIlIlIl = this.worldObj.setRandomSeed(llllllllllllllIIlIlIIIllllIlIlll, llllllllllllllIIlIlIIIllllIlIllI, 10387312);
        llllllllllllllIIlIlIIIllllIlIlll *= this.distance;
        llllllllllllllIIlIlIIIllllIlIllI *= this.distance;
        llllllllllllllIIlIlIIIllllIlIlll += llllllllllllllIIlIlIIIllllIlIlIl.nextInt(this.distance - 8);
        llllllllllllllIIlIlIIIllllIlIllI += llllllllllllllIIlIlIIIllllIlIlIl.nextInt(this.distance - 8);
        if (llllllllllllllIIlIlIIIllllIllIIl == llllllllllllllIIlIlIIIllllIlIlll && llllllllllllllIIlIlIIIllllIllIII == llllllllllllllIIlIlIIIllllIlIllI) {
            final boolean llllllllllllllIIlIlIIIllllIlIlII = this.worldObj.getBiomeProvider().areBiomesViable(llllllllllllllIIlIlIIIllllIllIIl * 16 + 8, llllllllllllllIIlIlIIIllllIllIII * 16 + 8, 0, MapGenVillage.VILLAGE_SPAWN_BIOMES);
            if (llllllllllllllIIlIlIIIllllIlIlII) {
                return true;
            }
        }
        return false;
    }
    
    public MapGenVillage() {
        this.distance = 32;
        this.minTownSeparation = 8;
    }
    
    @Override
    public String getStructureName() {
        return "Village";
    }
    
    public static class Start extends StructureStart
    {
        private /* synthetic */ boolean hasMoreThanTwoComponents;
        
        public Start(final World lllllllllllllIlIIllIllIIlIllllII, final Random lllllllllllllIlIIllIllIIlIlllIll, final int lllllllllllllIlIIllIllIIlIlIlIlI, final int lllllllllllllIlIIllIllIIlIlllIIl, final int lllllllllllllIlIIllIllIIlIlIlIII) {
            super(lllllllllllllIlIIllIllIIlIlIlIlI, lllllllllllllIlIIllIllIIlIlllIIl);
            final List<StructureVillagePieces.PieceWeight> lllllllllllllIlIIllIllIIlIllIlll = StructureVillagePieces.getStructureVillageWeightedPieceList(lllllllllllllIlIIllIllIIlIlllIll, lllllllllllllIlIIllIllIIlIlIlIII);
            final StructureVillagePieces.Start lllllllllllllIlIIllIllIIlIllIllI = new StructureVillagePieces.Start(lllllllllllllIlIIllIllIIlIllllII.getBiomeProvider(), 0, lllllllllllllIlIIllIllIIlIlllIll, (lllllllllllllIlIIllIllIIlIlIlIlI << 4) + 2, (lllllllllllllIlIIllIllIIlIlllIIl << 4) + 2, lllllllllllllIlIIllIllIIlIllIlll, lllllllllllllIlIIllIllIIlIlIlIII);
            this.components.add(lllllllllllllIlIIllIllIIlIllIllI);
            lllllllllllllIlIIllIllIIlIllIllI.buildComponent(lllllllllllllIlIIllIllIIlIllIllI, this.components, lllllllllllllIlIIllIllIIlIlllIll);
            final List<StructureComponent> lllllllllllllIlIIllIllIIlIllIlIl = lllllllllllllIlIIllIllIIlIllIllI.pendingRoads;
            final List<StructureComponent> lllllllllllllIlIIllIllIIlIllIlII = lllllllllllllIlIIllIllIIlIllIllI.pendingHouses;
            while (!lllllllllllllIlIIllIllIIlIllIlIl.isEmpty() || !lllllllllllllIlIIllIllIIlIllIlII.isEmpty()) {
                if (lllllllllllllIlIIllIllIIlIllIlIl.isEmpty()) {
                    final int lllllllllllllIlIIllIllIIlIllIIll = lllllllllllllIlIIllIllIIlIlllIll.nextInt(lllllllllllllIlIIllIllIIlIllIlII.size());
                    final StructureComponent lllllllllllllIlIIllIllIIlIllIIlI = lllllllllllllIlIIllIllIIlIllIlII.remove(lllllllllllllIlIIllIllIIlIllIIll);
                    lllllllllllllIlIIllIllIIlIllIIlI.buildComponent(lllllllllllllIlIIllIllIIlIllIllI, this.components, lllllllllllllIlIIllIllIIlIlllIll);
                }
                else {
                    final int lllllllllllllIlIIllIllIIlIllIIIl = lllllllllllllIlIIllIllIIlIlllIll.nextInt(lllllllllllllIlIIllIllIIlIllIlIl.size());
                    final StructureComponent lllllllllllllIlIIllIllIIlIllIIII = lllllllllllllIlIIllIllIIlIllIlIl.remove(lllllllllllllIlIIllIllIIlIllIIIl);
                    lllllllllllllIlIIllIllIIlIllIIII.buildComponent(lllllllllllllIlIIllIllIIlIllIllI, this.components, lllllllllllllIlIIllIllIIlIlllIll);
                }
            }
            this.updateBoundingBox();
            int lllllllllllllIlIIllIllIIlIlIllll = 0;
            for (final StructureComponent lllllllllllllIlIIllIllIIlIlIlllI : this.components) {
                if (!(lllllllllllllIlIIllIllIIlIlIlllI instanceof StructureVillagePieces.Road)) {
                    ++lllllllllllllIlIIllIllIIlIlIllll;
                }
            }
            this.hasMoreThanTwoComponents = (lllllllllllllIlIIllIllIIlIlIllll > 2);
        }
        
        public Start() {
        }
        
        @Override
        public void writeToNBT(final NBTTagCompound lllllllllllllIlIIllIllIIlIIllIII) {
            super.writeToNBT(lllllllllllllIlIIllIllIIlIIllIII);
            lllllllllllllIlIIllIllIIlIIllIII.setBoolean("Valid", this.hasMoreThanTwoComponents);
        }
        
        @Override
        public void readFromNBT(final NBTTagCompound lllllllllllllIlIIllIllIIlIIlIIlI) {
            super.readFromNBT(lllllllllllllIlIIllIllIIlIIlIIlI);
            this.hasMoreThanTwoComponents = lllllllllllllIlIIllIllIIlIIlIIlI.getBoolean("Valid");
        }
        
        @Override
        public boolean isSizeableStructure() {
            return this.hasMoreThanTwoComponents;
        }
    }
}
