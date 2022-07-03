package net.minecraft.world.chunk.storage;

import net.minecraft.world.chunk.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class ChunkLoader
{
    public static AnvilConverterData load(final NBTTagCompound lllllllllllllIllllIIlIllllIIIIII) {
        final int lllllllllllllIllllIIlIlllIllllll = lllllllllllllIllllIIlIllllIIIIII.getInteger("xPos");
        final int lllllllllllllIllllIIlIlllIlllllI = lllllllllllllIllllIIlIllllIIIIII.getInteger("zPos");
        final AnvilConverterData lllllllllllllIllllIIlIlllIllllIl = new AnvilConverterData(lllllllllllllIllllIIlIlllIllllll, lllllllllllllIllllIIlIlllIlllllI);
        lllllllllllllIllllIIlIlllIllllIl.blocks = lllllllllllllIllllIIlIllllIIIIII.getByteArray("Blocks");
        lllllllllllllIllllIIlIlllIllllIl.data = new NibbleArrayReader(lllllllllllllIllllIIlIllllIIIIII.getByteArray("Data"), 7);
        lllllllllllllIllllIIlIlllIllllIl.skyLight = new NibbleArrayReader(lllllllllllllIllllIIlIllllIIIIII.getByteArray("SkyLight"), 7);
        lllllllllllllIllllIIlIlllIllllIl.blockLight = new NibbleArrayReader(lllllllllllllIllllIIlIllllIIIIII.getByteArray("BlockLight"), 7);
        lllllllllllllIllllIIlIlllIllllIl.heightmap = lllllllllllllIllllIIlIllllIIIIII.getByteArray("HeightMap");
        lllllllllllllIllllIIlIlllIllllIl.terrainPopulated = lllllllllllllIllllIIlIllllIIIIII.getBoolean("TerrainPopulated");
        lllllllllllllIllllIIlIlllIllllIl.entities = lllllllllllllIllllIIlIllllIIIIII.getTagList("Entities", 10);
        lllllllllllllIllllIIlIlllIllllIl.tileEntities = lllllllllllllIllllIIlIllllIIIIII.getTagList("TileEntities", 10);
        lllllllllllllIllllIIlIlllIllllIl.tileTicks = lllllllllllllIllllIIlIllllIIIIII.getTagList("TileTicks", 10);
        try {
            lllllllllllllIllllIIlIlllIllllIl.lastUpdated = lllllllllllllIllllIIlIllllIIIIII.getLong("LastUpdate");
        }
        catch (ClassCastException lllllllllllllIllllIIlIlllIllllII) {
            lllllllllllllIllllIIlIlllIllllIl.lastUpdated = lllllllllllllIllllIIlIllllIIIIII.getInteger("LastUpdate");
        }
        return lllllllllllllIllllIIlIlllIllllIl;
    }
    
    public static void convertToAnvilFormat(final AnvilConverterData lllllllllllllIllllIIlIlllIlIIllI, final NBTTagCompound lllllllllllllIllllIIlIlllIlIIlIl, final BiomeProvider lllllllllllllIllllIIlIlllIIIlIIl) {
        lllllllllllllIllllIIlIlllIlIIlIl.setInteger("xPos", lllllllllllllIllllIIlIlllIlIIllI.x);
        lllllllllllllIllllIIlIlllIlIIlIl.setInteger("zPos", lllllllllllllIllllIIlIlllIlIIllI.z);
        lllllllllllllIllllIIlIlllIlIIlIl.setLong("LastUpdate", lllllllllllllIllllIIlIlllIlIIllI.lastUpdated);
        final int[] lllllllllllllIllllIIlIlllIlIIIll = new int[lllllllllllllIllllIIlIlllIlIIllI.heightmap.length];
        for (int lllllllllllllIllllIIlIlllIlIIIlI = 0; lllllllllllllIllllIIlIlllIlIIIlI < lllllllllllllIllllIIlIlllIlIIllI.heightmap.length; ++lllllllllllllIllllIIlIlllIlIIIlI) {
            lllllllllllllIllllIIlIlllIlIIIll[lllllllllllllIllllIIlIlllIlIIIlI] = lllllllllllllIllllIIlIlllIlIIllI.heightmap[lllllllllllllIllllIIlIlllIlIIIlI];
        }
        lllllllllllllIllllIIlIlllIlIIlIl.setIntArray("HeightMap", lllllllllllllIllllIIlIlllIlIIIll);
        lllllllllllllIllllIIlIlllIlIIlIl.setBoolean("TerrainPopulated", lllllllllllllIllllIIlIlllIlIIllI.terrainPopulated);
        final NBTTagList lllllllllllllIllllIIlIlllIlIIIIl = new NBTTagList();
        for (int lllllllllllllIllllIIlIlllIlIIIII = 0; lllllllllllllIllllIIlIlllIlIIIII < 8; ++lllllllllllllIllllIIlIlllIlIIIII) {
            boolean lllllllllllllIllllIIlIlllIIlllll = true;
            for (int lllllllllllllIllllIIlIlllIIllllI = 0; lllllllllllllIllllIIlIlllIIllllI < 16 && lllllllllllllIllllIIlIlllIIlllll; ++lllllllllllllIllllIIlIlllIIllllI) {
                for (int lllllllllllllIllllIIlIlllIIlllIl = 0; lllllllllllllIllllIIlIlllIIlllIl < 16 && lllllllllllllIllllIIlIlllIIlllll; ++lllllllllllllIllllIIlIlllIIlllIl) {
                    for (int lllllllllllllIllllIIlIlllIIlllII = 0; lllllllllllllIllllIIlIlllIIlllII < 16; ++lllllllllllllIllllIIlIlllIIlllII) {
                        final int lllllllllllllIllllIIlIlllIIllIll = lllllllllllllIllllIIlIlllIIllllI << 11 | lllllllllllllIllllIIlIlllIIlllII << 7 | lllllllllllllIllllIIlIlllIIlllIl + (lllllllllllllIllllIIlIlllIlIIIII << 4);
                        final int lllllllllllllIllllIIlIlllIIllIlI = lllllllllllllIllllIIlIlllIlIIllI.blocks[lllllllllllllIllllIIlIlllIIllIll];
                        if (lllllllllllllIllllIIlIlllIIllIlI != 0) {
                            lllllllllllllIllllIIlIlllIIlllll = false;
                            break;
                        }
                    }
                }
            }
            if (!lllllllllllllIllllIIlIlllIIlllll) {
                final byte[] lllllllllllllIllllIIlIlllIIllIIl = new byte[4096];
                final NibbleArray lllllllllllllIllllIIlIlllIIllIII = new NibbleArray();
                final NibbleArray lllllllllllllIllllIIlIlllIIlIlll = new NibbleArray();
                final NibbleArray lllllllllllllIllllIIlIlllIIlIllI = new NibbleArray();
                for (int lllllllllllllIllllIIlIlllIIlIlIl = 0; lllllllllllllIllllIIlIlllIIlIlIl < 16; ++lllllllllllllIllllIIlIlllIIlIlIl) {
                    for (int lllllllllllllIllllIIlIlllIIlIlII = 0; lllllllllllllIllllIIlIlllIIlIlII < 16; ++lllllllllllllIllllIIlIlllIIlIlII) {
                        for (int lllllllllllllIllllIIlIlllIIlIIll = 0; lllllllllllllIllllIIlIlllIIlIIll < 16; ++lllllllllllllIllllIIlIlllIIlIIll) {
                            final int lllllllllllllIllllIIlIlllIIlIIlI = lllllllllllllIllllIIlIlllIIlIlIl << 11 | lllllllllllllIllllIIlIlllIIlIIll << 7 | lllllllllllllIllllIIlIlllIIlIlII + (lllllllllllllIllllIIlIlllIlIIIII << 4);
                            final int lllllllllllllIllllIIlIlllIIlIIIl = lllllllllllllIllllIIlIlllIlIIllI.blocks[lllllllllllllIllllIIlIlllIIlIIlI];
                            lllllllllllllIllllIIlIlllIIllIIl[lllllllllllllIllllIIlIlllIIlIlII << 8 | lllllllllllllIllllIIlIlllIIlIIll << 4 | lllllllllllllIllllIIlIlllIIlIlIl] = (byte)(lllllllllllllIllllIIlIlllIIlIIIl & 0xFF);
                            lllllllllllllIllllIIlIlllIIllIII.set(lllllllllllllIllllIIlIlllIIlIlIl, lllllllllllllIllllIIlIlllIIlIlII, lllllllllllllIllllIIlIlllIIlIIll, lllllllllllllIllllIIlIlllIlIIllI.data.get(lllllllllllllIllllIIlIlllIIlIlIl, lllllllllllllIllllIIlIlllIIlIlII + (lllllllllllllIllllIIlIlllIlIIIII << 4), lllllllllllllIllllIIlIlllIIlIIll));
                            lllllllllllllIllllIIlIlllIIlIlll.set(lllllllllllllIllllIIlIlllIIlIlIl, lllllllllllllIllllIIlIlllIIlIlII, lllllllllllllIllllIIlIlllIIlIIll, lllllllllllllIllllIIlIlllIlIIllI.skyLight.get(lllllllllllllIllllIIlIlllIIlIlIl, lllllllllllllIllllIIlIlllIIlIlII + (lllllllllllllIllllIIlIlllIlIIIII << 4), lllllllllllllIllllIIlIlllIIlIIll));
                            lllllllllllllIllllIIlIlllIIlIllI.set(lllllllllllllIllllIIlIlllIIlIlIl, lllllllllllllIllllIIlIlllIIlIlII, lllllllllllllIllllIIlIlllIIlIIll, lllllllllllllIllllIIlIlllIlIIllI.blockLight.get(lllllllllllllIllllIIlIlllIIlIlIl, lllllllllllllIllllIIlIlllIIlIlII + (lllllllllllllIllllIIlIlllIlIIIII << 4), lllllllllllllIllllIIlIlllIIlIIll));
                        }
                    }
                }
                final NBTTagCompound lllllllllllllIllllIIlIlllIIlIIII = new NBTTagCompound();
                lllllllllllllIllllIIlIlllIIlIIII.setByte("Y", (byte)(lllllllllllllIllllIIlIlllIlIIIII & 0xFF));
                lllllllllllllIllllIIlIlllIIlIIII.setByteArray("Blocks", lllllllllllllIllllIIlIlllIIllIIl);
                lllllllllllllIllllIIlIlllIIlIIII.setByteArray("Data", lllllllllllllIllllIIlIlllIIllIII.getData());
                lllllllllllllIllllIIlIlllIIlIIII.setByteArray("SkyLight", lllllllllllllIllllIIlIlllIIlIlll.getData());
                lllllllllllllIllllIIlIlllIIlIIII.setByteArray("BlockLight", lllllllllllllIllllIIlIlllIIlIllI.getData());
                lllllllllllllIllllIIlIlllIlIIIIl.appendTag(lllllllllllllIllllIIlIlllIIlIIII);
            }
        }
        lllllllllllllIllllIIlIlllIlIIlIl.setTag("Sections", lllllllllllllIllllIIlIlllIlIIIIl);
        final byte[] lllllllllllllIllllIIlIlllIIIllll = new byte[256];
        final BlockPos.MutableBlockPos lllllllllllllIllllIIlIlllIIIlllI = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIllllIIlIlllIIIllIl = 0; lllllllllllllIllllIIlIlllIIIllIl < 16; ++lllllllllllllIllllIIlIlllIIIllIl) {
            for (int lllllllllllllIllllIIlIlllIIIllII = 0; lllllllllllllIllllIIlIlllIIIllII < 16; ++lllllllllllllIllllIIlIlllIIIllII) {
                lllllllllllllIllllIIlIlllIIIlllI.setPos(lllllllllllllIllllIIlIlllIlIIllI.x << 4 | lllllllllllllIllllIIlIlllIIIllIl, 0, lllllllllllllIllllIIlIlllIlIIllI.z << 4 | lllllllllllllIllllIIlIlllIIIllII);
                lllllllllllllIllllIIlIlllIIIllll[lllllllllllllIllllIIlIlllIIIllII << 4 | lllllllllllllIllllIIlIlllIIIllIl] = (byte)(Biome.getIdForBiome(lllllllllllllIllllIIlIlllIIIlIIl.getBiome(lllllllllllllIllllIIlIlllIIIlllI, Biomes.DEFAULT)) & 0xFF);
            }
        }
        lllllllllllllIllllIIlIlllIlIIlIl.setByteArray("Biomes", lllllllllllllIllllIIlIlllIIIllll);
        lllllllllllllIllllIIlIlllIlIIlIl.setTag("Entities", lllllllllllllIllllIIlIlllIlIIllI.entities);
        lllllllllllllIllllIIlIlllIlIIlIl.setTag("TileEntities", lllllllllllllIllllIIlIlllIlIIllI.tileEntities);
        if (lllllllllllllIllllIIlIlllIlIIllI.tileTicks != null) {
            lllllllllllllIllllIIlIlllIlIIlIl.setTag("TileTicks", lllllllllllllIllllIIlIlllIlIIllI.tileTicks);
        }
    }
    
    public static class AnvilConverterData
    {
        public /* synthetic */ NibbleArrayReader blockLight;
        public final /* synthetic */ int x;
        public /* synthetic */ NibbleArrayReader data;
        public /* synthetic */ NBTTagList entities;
        public /* synthetic */ byte[] blocks;
        public /* synthetic */ long lastUpdated;
        public final /* synthetic */ int z;
        public /* synthetic */ boolean terrainPopulated;
        public /* synthetic */ NBTTagList tileTicks;
        public /* synthetic */ NBTTagList tileEntities;
        public /* synthetic */ byte[] heightmap;
        public /* synthetic */ NibbleArrayReader skyLight;
        
        public AnvilConverterData(final int lIlIIIlllllIIll, final int lIlIIIlllllIlIl) {
            this.x = lIlIIIlllllIIll;
            this.z = lIlIIIlllllIlIl;
        }
    }
}
