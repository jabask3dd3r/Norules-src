package net.minecraft.world.gen.structure;

import net.minecraft.world.biome.*;
import com.google.common.collect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import java.util.*;

public class MapGenScatteredFeature extends MapGenStructure
{
    private static final /* synthetic */ List<Biome> BIOMELIST;
    private /* synthetic */ int maxDistanceBetweenScatteredFeatures;
    private final /* synthetic */ int minDistanceBetweenScatteredFeatures;
    private final /* synthetic */ List<Biome.SpawnListEntry> scatteredFeatureSpawnList;
    
    public boolean isSwampHut(final BlockPos lIllIIllIIIIII) {
        final StructureStart lIllIIllIIIIll = this.getStructureAt(lIllIIllIIIIII);
        if (lIllIIllIIIIll != null && lIllIIllIIIIll instanceof Start && !lIllIIllIIIIll.components.isEmpty()) {
            final StructureComponent lIllIIllIIIIlI = lIllIIllIIIIll.components.get(0);
            return lIllIIllIIIIlI instanceof ComponentScatteredFeaturePieces.SwampHut;
        }
        return false;
    }
    
    public MapGenScatteredFeature() {
        this.scatteredFeatureSpawnList = (List<Biome.SpawnListEntry>)Lists.newArrayList();
        this.maxDistanceBetweenScatteredFeatures = 32;
        this.minDistanceBetweenScatteredFeatures = 8;
        this.scatteredFeatureSpawnList.add(new Biome.SpawnListEntry(EntityWitch.class, 1, 1, 1));
    }
    
    @Override
    public BlockPos getClosestStrongholdPos(final World lIllIIllIllIIl, final BlockPos lIllIIllIlIlII, final boolean lIllIIllIlIIll) {
        this.worldObj = lIllIIllIllIIl;
        return MapGenStructure.func_191069_a(lIllIIllIllIIl, this, lIllIIllIlIlII, this.maxDistanceBetweenScatteredFeatures, 8, 14357617, false, 100, lIllIIllIlIIll);
    }
    
    public List<Biome.SpawnListEntry> getScatteredFeatureSpawnList() {
        return this.scatteredFeatureSpawnList;
    }
    
    public MapGenScatteredFeature(final Map<String, String> lIllIlIIIIIIlI) {
        this();
        for (final Map.Entry<String, String> lIllIlIIIIIlII : lIllIlIIIIIIlI.entrySet()) {
            if (lIllIlIIIIIlII.getKey().equals("distance")) {
                this.maxDistanceBetweenScatteredFeatures = MathHelper.getInt(lIllIlIIIIIlII.getValue(), this.maxDistanceBetweenScatteredFeatures, 9);
            }
        }
    }
    
    @Override
    public String getStructureName() {
        return "Temple";
    }
    
    static {
        BIOMELIST = Arrays.asList(Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.SWAMPLAND, Biomes.ICE_PLAINS, Biomes.COLD_TAIGA);
    }
    
    @Override
    protected StructureStart getStructureStart(final int lIllIIllIIlIll, final int lIllIIllIIlIlI) {
        return new Start(this.worldObj, this.rand, lIllIIllIIlIll, lIllIIllIIlIlI);
    }
    
    @Override
    protected boolean canSpawnStructureAtCoords(int lIllIIlllIlIII, int lIllIIlllIIlll) {
        final int lIllIIllllIIII = lIllIIlllIlIII;
        final int lIllIIlllIllll = (int)lIllIIlllIIlll;
        if (lIllIIlllIlIII < 0) {
            lIllIIlllIlIII -= this.maxDistanceBetweenScatteredFeatures - 1;
        }
        if (lIllIIlllIIlll < 0) {
            lIllIIlllIIlll -= this.maxDistanceBetweenScatteredFeatures - 1;
        }
        int lIllIIlllIlllI = lIllIIlllIlIII / this.maxDistanceBetweenScatteredFeatures;
        int lIllIIlllIllIl = (int)(lIllIIlllIIlll / this.maxDistanceBetweenScatteredFeatures);
        final Random lIllIIlllIllII = this.worldObj.setRandomSeed(lIllIIlllIlllI, lIllIIlllIllIl, 14357617);
        lIllIIlllIlllI *= this.maxDistanceBetweenScatteredFeatures;
        lIllIIlllIllIl *= this.maxDistanceBetweenScatteredFeatures;
        lIllIIlllIlllI += lIllIIlllIllII.nextInt(this.maxDistanceBetweenScatteredFeatures - 8);
        lIllIIlllIllIl += lIllIIlllIllII.nextInt(this.maxDistanceBetweenScatteredFeatures - 8);
        if (lIllIIllllIIII == lIllIIlllIlllI && lIllIIlllIllll == lIllIIlllIllIl) {
            final Biome lIllIIlllIlIll = this.worldObj.getBiomeProvider().getBiome(new BlockPos(lIllIIllllIIII * 16 + 8, 0, lIllIIlllIllll * 16 + 8));
            if (lIllIIlllIlIll == null) {
                return false;
            }
            for (final Biome lIllIIlllIlIlI : MapGenScatteredFeature.BIOMELIST) {
                if (lIllIIlllIlIll == lIllIIlllIlIlI) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static class Start extends StructureStart
    {
        public Start(final World llllllllllllllllllIlIIlIlIIlIIlI, final Random llllllllllllllllllIlIIlIlIIlIIIl, final int llllllllllllllllllIlIIlIlIIlIIII, final int llllllllllllllllllIlIIlIlIIIllll, final Biome llllllllllllllllllIlIIlIlIIIlllI) {
            super(llllllllllllllllllIlIIlIlIIlIIII, llllllllllllllllllIlIIlIlIIIllll);
            if (llllllllllllllllllIlIIlIlIIIlllI != Biomes.JUNGLE && llllllllllllllllllIlIIlIlIIIlllI != Biomes.JUNGLE_HILLS) {
                if (llllllllllllllllllIlIIlIlIIIlllI == Biomes.SWAMPLAND) {
                    final ComponentScatteredFeaturePieces.SwampHut llllllllllllllllllIlIIlIlIIIllIl = new ComponentScatteredFeaturePieces.SwampHut(llllllllllllllllllIlIIlIlIIlIIIl, llllllllllllllllllIlIIlIlIIlIIII * 16, llllllllllllllllllIlIIlIlIIIllll * 16);
                    this.components.add(llllllllllllllllllIlIIlIlIIIllIl);
                }
                else if (llllllllllllllllllIlIIlIlIIIlllI != Biomes.DESERT && llllllllllllllllllIlIIlIlIIIlllI != Biomes.DESERT_HILLS) {
                    if (llllllllllllllllllIlIIlIlIIIlllI == Biomes.ICE_PLAINS || llllllllllllllllllIlIIlIlIIIlllI == Biomes.COLD_TAIGA) {
                        final ComponentScatteredFeaturePieces.Igloo llllllllllllllllllIlIIlIlIIIllII = new ComponentScatteredFeaturePieces.Igloo(llllllllllllllllllIlIIlIlIIlIIIl, llllllllllllllllllIlIIlIlIIlIIII * 16, llllllllllllllllllIlIIlIlIIIllll * 16);
                        this.components.add(llllllllllllllllllIlIIlIlIIIllII);
                    }
                }
                else {
                    final ComponentScatteredFeaturePieces.DesertPyramid llllllllllllllllllIlIIlIlIIIlIll = new ComponentScatteredFeaturePieces.DesertPyramid(llllllllllllllllllIlIIlIlIIlIIIl, llllllllllllllllllIlIIlIlIIlIIII * 16, llllllllllllllllllIlIIlIlIIIllll * 16);
                    this.components.add(llllllllllllllllllIlIIlIlIIIlIll);
                }
            }
            else {
                final ComponentScatteredFeaturePieces.JunglePyramid llllllllllllllllllIlIIlIlIIIlIlI = new ComponentScatteredFeaturePieces.JunglePyramid(llllllllllllllllllIlIIlIlIIlIIIl, llllllllllllllllllIlIIlIlIIlIIII * 16, llllllllllllllllllIlIIlIlIIIllll * 16);
                this.components.add(llllllllllllllllllIlIIlIlIIIlIlI);
            }
            this.updateBoundingBox();
        }
        
        public Start(final World llllllllllllllllllIlIIlIlIIlllIl, final Random llllllllllllllllllIlIIlIlIIlllII, final int llllllllllllllllllIlIIlIlIIllIll, final int llllllllllllllllllIlIIlIlIIlllll) {
            this(llllllllllllllllllIlIIlIlIIlllIl, llllllllllllllllllIlIIlIlIIlllII, llllllllllllllllllIlIIlIlIIllIll, llllllllllllllllllIlIIlIlIIlllll, llllllllllllllllllIlIIlIlIIlllIl.getBiome(new BlockPos(llllllllllllllllllIlIIlIlIIllIll * 16 + 8, 0, llllllllllllllllllIlIIlIlIIlllll * 16 + 8)));
        }
        
        public Start() {
        }
    }
}
