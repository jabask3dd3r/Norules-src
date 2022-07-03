package net.minecraft.world.gen;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import java.util.*;

public class ChunkGeneratorFlat implements IChunkGenerator
{
    private final /* synthetic */ Map<String, MapGenStructure> structureGenerators;
    private final /* synthetic */ Random random;
    private final /* synthetic */ World worldObj;
    private /* synthetic */ WorldGenLakes waterLakeGenerator;
    private /* synthetic */ WorldGenLakes lavaLakeGenerator;
    private final /* synthetic */ IBlockState[] cachedBlockIDs;
    private final /* synthetic */ boolean hasDecoration;
    private final /* synthetic */ boolean hasDungeons;
    private final /* synthetic */ FlatGeneratorInfo flatWorldGenInfo;
    
    @Override
    public void populate(final int llllllllllllllllIIlIIIIlIlIIIIII, final int llllllllllllllllIIlIIIIlIlIIlllI) {
        final int llllllllllllllllIIlIIIIlIlIIllIl = llllllllllllllllIIlIIIIlIlIIIIII * 16;
        final int llllllllllllllllIIlIIIIlIlIIllII = llllllllllllllllIIlIIIIlIlIIlllI * 16;
        final BlockPos llllllllllllllllIIlIIIIlIlIIlIll = new BlockPos(llllllllllllllllIIlIIIIlIlIIllIl, 0, llllllllllllllllIIlIIIIlIlIIllII);
        final Biome llllllllllllllllIIlIIIIlIlIIlIlI = this.worldObj.getBiome(new BlockPos(llllllllllllllllIIlIIIIlIlIIllIl + 16, 0, llllllllllllllllIIlIIIIlIlIIllII + 16));
        boolean llllllllllllllllIIlIIIIlIlIIlIIl = false;
        this.random.setSeed(this.worldObj.getSeed());
        final long llllllllllllllllIIlIIIIlIlIIlIII = this.random.nextLong() / 2L * 2L + 1L;
        final long llllllllllllllllIIlIIIIlIlIIIlll = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed(llllllllllllllllIIlIIIIlIlIIIIII * llllllllllllllllIIlIIIIlIlIIlIII + llllllllllllllllIIlIIIIlIlIIlllI * llllllllllllllllIIlIIIIlIlIIIlll ^ this.worldObj.getSeed());
        final ChunkPos llllllllllllllllIIlIIIIlIlIIIllI = new ChunkPos(llllllllllllllllIIlIIIIlIlIIIIII, llllllllllllllllIIlIIIIlIlIIlllI);
        for (final MapGenStructure llllllllllllllllIIlIIIIlIlIIIlIl : this.structureGenerators.values()) {
            final boolean llllllllllllllllIIlIIIIlIlIIIlII = llllllllllllllllIIlIIIIlIlIIIlIl.generateStructure(this.worldObj, this.random, llllllllllllllllIIlIIIIlIlIIIllI);
            if (llllllllllllllllIIlIIIIlIlIIIlIl instanceof MapGenVillage) {
                llllllllllllllllIIlIIIIlIlIIlIIl |= llllllllllllllllIIlIIIIlIlIIIlII;
            }
        }
        if (this.waterLakeGenerator != null && !llllllllllllllllIIlIIIIlIlIIlIIl && this.random.nextInt(4) == 0) {
            this.waterLakeGenerator.generate(this.worldObj, this.random, llllllllllllllllIIlIIIIlIlIIlIll.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
        }
        if (this.lavaLakeGenerator != null && !llllllllllllllllIIlIIIIlIlIIlIIl && this.random.nextInt(8) == 0) {
            final BlockPos llllllllllllllllIIlIIIIlIlIIIIll = llllllllllllllllIIlIIIIlIlIIlIll.add(this.random.nextInt(16) + 8, this.random.nextInt(this.random.nextInt(248) + 8), this.random.nextInt(16) + 8);
            if (llllllllllllllllIIlIIIIlIlIIIIll.getY() < this.worldObj.getSeaLevel() || this.random.nextInt(10) == 0) {
                this.lavaLakeGenerator.generate(this.worldObj, this.random, llllllllllllllllIIlIIIIlIlIIIIll);
            }
        }
        if (this.hasDungeons) {
            for (int llllllllllllllllIIlIIIIlIlIIIIlI = 0; llllllllllllllllIIlIIIIlIlIIIIlI < 8; ++llllllllllllllllIIlIIIIlIlIIIIlI) {
                new WorldGenDungeons().generate(this.worldObj, this.random, llllllllllllllllIIlIIIIlIlIIlIll.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
            }
        }
        if (this.hasDecoration) {
            llllllllllllllllIIlIIIIlIlIIlIlI.decorate(this.worldObj, this.random, llllllllllllllllIIlIIIIlIlIIlIll);
        }
    }
    
    @Override
    public boolean generateStructures(final Chunk llllllllllllllllIIlIIIIlIIllIIlI, final int llllllllllllllllIIlIIIIlIIllIIIl, final int llllllllllllllllIIlIIIIlIIllIIII) {
        return false;
    }
    
    @Override
    public boolean func_193414_a(final World llllllllllllllllIIlIIIIlIIIIllII, final String llllllllllllllllIIlIIIIlIIIIIlll, final BlockPos llllllllllllllllIIlIIIIlIIIIIllI) {
        final MapGenStructure llllllllllllllllIIlIIIIlIIIIlIIl = this.structureGenerators.get(llllllllllllllllIIlIIIIlIIIIIlll);
        return llllllllllllllllIIlIIIIlIIIIlIIl != null && llllllllllllllllIIlIIIIlIIIIlIIl.isInsideStructure(llllllllllllllllIIlIIIIlIIIIIllI);
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllllllIIlIIIIlIllIIlIl, final int llllllllllllllllIIlIIIIlIllIIlII) {
        final ChunkPrimer llllllllllllllllIIlIIIIlIlllIIII = new ChunkPrimer();
        for (int llllllllllllllllIIlIIIIlIllIllll = 0; llllllllllllllllIIlIIIIlIllIllll < this.cachedBlockIDs.length; ++llllllllllllllllIIlIIIIlIllIllll) {
            final IBlockState llllllllllllllllIIlIIIIlIllIlllI = this.cachedBlockIDs[llllllllllllllllIIlIIIIlIllIllll];
            if (llllllllllllllllIIlIIIIlIllIlllI != null) {
                for (int llllllllllllllllIIlIIIIlIllIllIl = 0; llllllllllllllllIIlIIIIlIllIllIl < 16; ++llllllllllllllllIIlIIIIlIllIllIl) {
                    for (int llllllllllllllllIIlIIIIlIllIllII = 0; llllllllllllllllIIlIIIIlIllIllII < 16; ++llllllllllllllllIIlIIIIlIllIllII) {
                        llllllllllllllllIIlIIIIlIlllIIII.setBlockState(llllllllllllllllIIlIIIIlIllIllIl, llllllllllllllllIIlIIIIlIllIllll, llllllllllllllllIIlIIIIlIllIllII, llllllllllllllllIIlIIIIlIllIlllI);
                    }
                }
            }
        }
        for (final MapGenBase llllllllllllllllIIlIIIIlIllIlIll : this.structureGenerators.values()) {
            llllllllllllllllIIlIIIIlIllIlIll.generate(this.worldObj, llllllllllllllllIIlIIIIlIllIIlIl, llllllllllllllllIIlIIIIlIllIIlII, llllllllllllllllIIlIIIIlIlllIIII);
        }
        final Chunk llllllllllllllllIIlIIIIlIllIlIlI = new Chunk(this.worldObj, llllllllllllllllIIlIIIIlIlllIIII, llllllllllllllllIIlIIIIlIllIIlIl, llllllllllllllllIIlIIIIlIllIIlII);
        final Biome[] llllllllllllllllIIlIIIIlIllIlIIl = this.worldObj.getBiomeProvider().getBiomes(null, llllllllllllllllIIlIIIIlIllIIlIl * 16, llllllllllllllllIIlIIIIlIllIIlII * 16, 16, 16);
        final byte[] llllllllllllllllIIlIIIIlIllIlIII = llllllllllllllllIIlIIIIlIllIlIlI.getBiomeArray();
        for (int llllllllllllllllIIlIIIIlIllIIlll = 0; llllllllllllllllIIlIIIIlIllIIlll < llllllllllllllllIIlIIIIlIllIlIII.length; ++llllllllllllllllIIlIIIIlIllIIlll) {
            llllllllllllllllIIlIIIIlIllIlIII[llllllllllllllllIIlIIIIlIllIIlll] = (byte)Biome.getIdForBiome(llllllllllllllllIIlIIIIlIllIlIIl[llllllllllllllllIIlIIIIlIllIIlll]);
        }
        llllllllllllllllIIlIIIIlIllIlIlI.generateSkylightMap();
        return llllllllllllllllIIlIIIIlIllIlIlI;
    }
    
    public ChunkGeneratorFlat(final World llllllllllllllllIIlIIIIllIIIIllI, final long llllllllllllllllIIlIIIIllIIIIlIl, final boolean llllllllllllllllIIlIIIIllIIlIIIl, final String llllllllllllllllIIlIIIIllIIlIIII) {
        this.cachedBlockIDs = new IBlockState[256];
        this.structureGenerators = new HashMap<String, MapGenStructure>();
        this.worldObj = llllllllllllllllIIlIIIIllIIIIllI;
        this.random = new Random(llllllllllllllllIIlIIIIllIIIIlIl);
        this.flatWorldGenInfo = FlatGeneratorInfo.createFlatGeneratorFromString(llllllllllllllllIIlIIIIllIIlIIII);
        if (llllllllllllllllIIlIIIIllIIlIIIl) {
            final Map<String, Map<String, String>> llllllllllllllllIIlIIIIllIIIllll = this.flatWorldGenInfo.getWorldFeatures();
            if (llllllllllllllllIIlIIIIllIIIllll.containsKey("village")) {
                final Map<String, String> llllllllllllllllIIlIIIIllIIIlllI = llllllllllllllllIIlIIIIllIIIllll.get("village");
                if (!llllllllllllllllIIlIIIIllIIIlllI.containsKey("size")) {
                    llllllllllllllllIIlIIIIllIIIlllI.put("size", "1");
                }
                this.structureGenerators.put("Village", new MapGenVillage(llllllllllllllllIIlIIIIllIIIlllI));
            }
            if (llllllllllllllllIIlIIIIllIIIllll.containsKey("biome_1")) {
                this.structureGenerators.put("Temple", new MapGenScatteredFeature(llllllllllllllllIIlIIIIllIIIllll.get("biome_1")));
            }
            if (llllllllllllllllIIlIIIIllIIIllll.containsKey("mineshaft")) {
                this.structureGenerators.put("Mineshaft", new MapGenMineshaft(llllllllllllllllIIlIIIIllIIIllll.get("mineshaft")));
            }
            if (llllllllllllllllIIlIIIIllIIIllll.containsKey("stronghold")) {
                this.structureGenerators.put("Stronghold", new MapGenStronghold(llllllllllllllllIIlIIIIllIIIllll.get("stronghold")));
            }
            if (llllllllllllllllIIlIIIIllIIIllll.containsKey("oceanmonument")) {
                this.structureGenerators.put("Monument", new StructureOceanMonument(llllllllllllllllIIlIIIIllIIIllll.get("oceanmonument")));
            }
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lake")) {
            this.waterLakeGenerator = new WorldGenLakes(Blocks.WATER);
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lava_lake")) {
            this.lavaLakeGenerator = new WorldGenLakes(Blocks.LAVA);
        }
        this.hasDungeons = this.flatWorldGenInfo.getWorldFeatures().containsKey("dungeon");
        int llllllllllllllllIIlIIIIllIIIllIl = 0;
        int llllllllllllllllIIlIIIIllIIIllII = 0;
        boolean llllllllllllllllIIlIIIIllIIIlIll = true;
        for (final FlatLayerInfo llllllllllllllllIIlIIIIllIIIlIlI : this.flatWorldGenInfo.getFlatLayers()) {
            for (int llllllllllllllllIIlIIIIllIIIlIIl = llllllllllllllllIIlIIIIllIIIlIlI.getMinY(); llllllllllllllllIIlIIIIllIIIlIIl < llllllllllllllllIIlIIIIllIIIlIlI.getMinY() + llllllllllllllllIIlIIIIllIIIlIlI.getLayerCount(); ++llllllllllllllllIIlIIIIllIIIlIIl) {
                final IBlockState llllllllllllllllIIlIIIIllIIIlIII = llllllllllllllllIIlIIIIllIIIlIlI.getLayerMaterial();
                if (llllllllllllllllIIlIIIIllIIIlIII.getBlock() != Blocks.AIR) {
                    llllllllllllllllIIlIIIIllIIIlIll = false;
                    this.cachedBlockIDs[llllllllllllllllIIlIIIIllIIIlIIl] = llllllllllllllllIIlIIIIllIIIlIII;
                }
            }
            if (llllllllllllllllIIlIIIIllIIIlIlI.getLayerMaterial().getBlock() == Blocks.AIR) {
                llllllllllllllllIIlIIIIllIIIllII += llllllllllllllllIIlIIIIllIIIlIlI.getLayerCount();
            }
            else {
                llllllllllllllllIIlIIIIllIIIllIl += llllllllllllllllIIlIIIIllIIIlIlI.getLayerCount() + llllllllllllllllIIlIIIIllIIIllII;
                llllllllllllllllIIlIIIIllIIIllII = 0;
            }
        }
        llllllllllllllllIIlIIIIllIIIIllI.setSeaLevel(llllllllllllllllIIlIIIIllIIIllIl);
        this.hasDecoration = ((!llllllllllllllllIIlIIIIllIIIlIll || this.flatWorldGenInfo.getBiome() == Biome.getIdForBiome(Biomes.VOID)) && this.flatWorldGenInfo.getWorldFeatures().containsKey("decoration"));
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World llllllllllllllllIIlIIIIlIIIlIllI, final String llllllllllllllllIIlIIIIlIIIllIll, final BlockPos llllllllllllllllIIlIIIIlIIIlIlII, final boolean llllllllllllllllIIlIIIIlIIIllIIl) {
        final MapGenStructure llllllllllllllllIIlIIIIlIIIllIII = this.structureGenerators.get(llllllllllllllllIIlIIIIlIIIllIll);
        return (llllllllllllllllIIlIIIIlIIIllIII != null) ? llllllllllllllllIIlIIIIlIIIllIII.getClosestStrongholdPos(llllllllllllllllIIlIIIIlIIIlIllI, llllllllllllllllIIlIIIIlIIIlIlII, llllllllllllllllIIlIIIIlIIIllIIl) : null;
    }
    
    @Override
    public void recreateStructures(final Chunk llllllllllllllllIIlIIIIIlllllllI, final int llllllllllllllllIIlIIIIIllllllIl, final int llllllllllllllllIIlIIIIIllllllII) {
        for (final MapGenStructure llllllllllllllllIIlIIIIIlllllIll : this.structureGenerators.values()) {
            llllllllllllllllIIlIIIIIlllllIll.generate(this.worldObj, llllllllllllllllIIlIIIIIllllllIl, llllllllllllllllIIlIIIIIllllllII, null);
        }
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType llllllllllllllllIIlIIIIlIIlIIllI, final BlockPos llllllllllllllllIIlIIIIlIIlIlIIl) {
        final Biome llllllllllllllllIIlIIIIlIIlIlIII = this.worldObj.getBiome(llllllllllllllllIIlIIIIlIIlIlIIl);
        return llllllllllllllllIIlIIIIlIIlIlIII.getSpawnableList(llllllllllllllllIIlIIIIlIIlIIllI);
    }
}
