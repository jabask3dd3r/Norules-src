package net.minecraft.world.gen;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.structure.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.world.chunk.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class ChunkGeneratorEnd implements IChunkGenerator
{
    /* synthetic */ double[] pnr;
    /* synthetic */ double[] br;
    private final /* synthetic */ Random rand;
    protected static final /* synthetic */ IBlockState AIR;
    private final /* synthetic */ BlockPos field_191061_n;
    protected static final /* synthetic */ IBlockState END_STONE;
    private final /* synthetic */ NoiseGeneratorSimplex islandNoise;
    private final /* synthetic */ NoiseGeneratorOctaves perlinNoise1;
    private final /* synthetic */ WorldGenEndIsland endIslands;
    private final /* synthetic */ World worldObj;
    /* synthetic */ double[] ar;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise1;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen5;
    private /* synthetic */ Biome[] biomesForGeneration;
    private final /* synthetic */ NoiseGeneratorOctaves lperlinNoise2;
    private /* synthetic */ double[] buffer;
    public /* synthetic */ NoiseGeneratorOctaves noiseGen6;
    private final /* synthetic */ MapGenEndCity endCityGen;
    
    @Override
    public void populate(final int llllllllllllIlllllIIllIIlllIIllI, final int llllllllllllIlllllIIllIIlllIIlIl) {
        BlockFalling.fallInstantly = true;
        final BlockPos llllllllllllIlllllIIllIIlllIIlII = new BlockPos(llllllllllllIlllllIIllIIlllIIllI * 16, 0, llllllllllllIlllllIIllIIlllIIlIl * 16);
        if (this.mapFeaturesEnabled) {
            this.endCityGen.generateStructure(this.worldObj, this.rand, new ChunkPos(llllllllllllIlllllIIllIIlllIIllI, llllllllllllIlllllIIllIIlllIIlIl));
        }
        this.worldObj.getBiome(llllllllllllIlllllIIllIIlllIIlII.add(16, 0, 16)).decorate(this.worldObj, this.worldObj.rand, llllllllllllIlllllIIllIIlllIIlII);
        final long llllllllllllIlllllIIllIIlllIIIll = llllllllllllIlllllIIllIIlllIIllI * (long)llllllllllllIlllllIIllIIlllIIllI + llllllllllllIlllllIIllIIlllIIlIl * (long)llllllllllllIlllllIIllIIlllIIlIl;
        if (llllllllllllIlllllIIllIIlllIIIll > 4096L) {
            final float llllllllllllIlllllIIllIIlllIIIlI = this.getIslandHeightValue(llllllllllllIlllllIIllIIlllIIllI, llllllllllllIlllllIIllIIlllIIlIl, 1, 1);
            if (llllllllllllIlllllIIllIIlllIIIlI < -20.0f && this.rand.nextInt(14) == 0) {
                this.endIslands.generate(this.worldObj, this.rand, llllllllllllIlllllIIllIIlllIIlII.add(this.rand.nextInt(16) + 8, 55 + this.rand.nextInt(16), this.rand.nextInt(16) + 8));
                if (this.rand.nextInt(4) == 0) {
                    this.endIslands.generate(this.worldObj, this.rand, llllllllllllIlllllIIllIIlllIIlII.add(this.rand.nextInt(16) + 8, 55 + this.rand.nextInt(16), this.rand.nextInt(16) + 8));
                }
            }
            if (this.getIslandHeightValue(llllllllllllIlllllIIllIIlllIIllI, llllllllllllIlllllIIllIIlllIIlIl, 1, 1) > 40.0f) {
                for (int llllllllllllIlllllIIllIIlllIIIIl = this.rand.nextInt(5), llllllllllllIlllllIIllIIlllIIIII = 0; llllllllllllIlllllIIllIIlllIIIII < llllllllllllIlllllIIllIIlllIIIIl; ++llllllllllllIlllllIIllIIlllIIIII) {
                    final int llllllllllllIlllllIIllIIllIlllll = this.rand.nextInt(16) + 8;
                    final int llllllllllllIlllllIIllIIllIllllI = this.rand.nextInt(16) + 8;
                    final int llllllllllllIlllllIIllIIllIlllIl = this.worldObj.getHeight(llllllllllllIlllllIIllIIlllIIlII.add(llllllllllllIlllllIIllIIllIlllll, 0, llllllllllllIlllllIIllIIllIllllI)).getY();
                    if (llllllllllllIlllllIIllIIllIlllIl > 0) {
                        final int llllllllllllIlllllIIllIIllIlllII = llllllllllllIlllllIIllIIllIlllIl - 1;
                        if (this.worldObj.isAirBlock(llllllllllllIlllllIIllIIlllIIlII.add(llllllllllllIlllllIIllIIllIlllll, llllllllllllIlllllIIllIIllIlllII + 1, llllllllllllIlllllIIllIIllIllllI)) && this.worldObj.getBlockState(llllllllllllIlllllIIllIIlllIIlII.add(llllllllllllIlllllIIllIIllIlllll, llllllllllllIlllllIIllIIllIlllII, llllllllllllIlllllIIllIIllIllllI)).getBlock() == Blocks.END_STONE) {
                            BlockChorusFlower.generatePlant(this.worldObj, llllllllllllIlllllIIllIIlllIIlII.add(llllllllllllIlllllIIllIIllIlllll, llllllllllllIlllllIIllIIllIlllII + 1, llllllllllllIlllllIIllIIllIllllI), this.rand, 8);
                        }
                    }
                }
                if (this.rand.nextInt(700) == 0) {
                    final int llllllllllllIlllllIIllIIllIllIll = this.rand.nextInt(16) + 8;
                    final int llllllllllllIlllllIIllIIllIllIlI = this.rand.nextInt(16) + 8;
                    final int llllllllllllIlllllIIllIIllIllIIl = this.worldObj.getHeight(llllllllllllIlllllIIllIIlllIIlII.add(llllllllllllIlllllIIllIIllIllIll, 0, llllllllllllIlllllIIllIIllIllIlI)).getY();
                    if (llllllllllllIlllllIIllIIllIllIIl > 0) {
                        final int llllllllllllIlllllIIllIIllIllIII = llllllllllllIlllllIIllIIllIllIIl + 3 + this.rand.nextInt(7);
                        final BlockPos llllllllllllIlllllIIllIIllIlIlll = llllllllllllIlllllIIllIIlllIIlII.add(llllllllllllIlllllIIllIIllIllIll, llllllllllllIlllllIIllIIllIllIII, llllllllllllIlllllIIllIIllIllIlI);
                        new WorldGenEndGateway().generate(this.worldObj, this.rand, llllllllllllIlllllIIllIIllIlIlll);
                        final TileEntity llllllllllllIlllllIIllIIllIlIllI = this.worldObj.getTileEntity(llllllllllllIlllllIIllIIllIlIlll);
                        if (llllllllllllIlllllIIllIIllIlIllI instanceof TileEntityEndGateway) {
                            final TileEntityEndGateway llllllllllllIlllllIIllIIllIlIlIl = (TileEntityEndGateway)llllllllllllIlllllIIllIIllIlIllI;
                            llllllllllllIlllllIIllIIllIlIlIl.func_190603_b(this.field_191061_n);
                        }
                    }
                }
            }
        }
        BlockFalling.fallInstantly = false;
    }
    
    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType llllllllllllIlllllIIllIIlIlllllI, final BlockPos llllllllllllIlllllIIllIIlIllllIl) {
        return this.worldObj.getBiome(llllllllllllIlllllIIllIIlIllllIl).getSpawnableList(llllllllllllIlllllIIllIIlIlllllI);
    }
    
    public ChunkGeneratorEnd(final World llllllllllllIlllllIIlllIIIIIlllI, final boolean llllllllllllIlllllIIlllIIIIlIIlI, final long llllllllllllIlllllIIlllIIIIlIIIl, final BlockPos llllllllllllIlllllIIlllIIIIIlIll) {
        this.endCityGen = new MapGenEndCity(this);
        this.endIslands = new WorldGenEndIsland();
        this.worldObj = llllllllllllIlllllIIlllIIIIIlllI;
        this.mapFeaturesEnabled = llllllllllllIlllllIIlllIIIIlIIlI;
        this.field_191061_n = llllllllllllIlllllIIlllIIIIIlIll;
        this.rand = new Random(llllllllllllIlllllIIlllIIIIlIIIl);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.islandNoise = new NoiseGeneratorSimplex(this.rand);
    }
    
    public boolean isIslandChunk(final int llllllllllllIlllllIIllIlIlIIIIlI, final int llllllllllllIlllllIIllIlIlIIIIIl) {
        return llllllllllllIlllllIIllIlIlIIIIlI * (long)llllllllllllIlllllIIllIlIlIIIIlI + llllllllllllIlllllIIllIlIlIIIIIl * (long)llllllllllllIlllllIIllIlIlIIIIIl > 4096L && this.getIslandHeightValue(llllllllllllIlllllIIllIlIlIIIIlI, llllllllllllIlllllIIllIlIlIIIIIl, 1, 1) >= 0.0f;
    }
    
    public void setBlocksInChunk(final int llllllllllllIlllllIIllIlllIIIIll, final int llllllllllllIlllllIIllIlllIIIIlI, final ChunkPrimer llllllllllllIlllllIIllIlllIIIIIl) {
        final int llllllllllllIlllllIIllIllllIIIll = 2;
        final int llllllllllllIlllllIIllIllllIIIlI = 3;
        final int llllllllllllIlllllIIllIllllIIIIl = 33;
        final int llllllllllllIlllllIIllIllllIIIII = 3;
        this.buffer = this.getHeights(this.buffer, llllllllllllIlllllIIllIlllIIIIll * 2, 0, llllllllllllIlllllIIllIlllIIIIlI * 2, 3, 33, 3);
        for (int llllllllllllIlllllIIllIlllIlllll = 0; llllllllllllIlllllIIllIlllIlllll < 2; ++llllllllllllIlllllIIllIlllIlllll) {
            for (int llllllllllllIlllllIIllIlllIllllI = 0; llllllllllllIlllllIIllIlllIllllI < 2; ++llllllllllllIlllllIIllIlllIllllI) {
                for (int llllllllllllIlllllIIllIlllIlllIl = 0; llllllllllllIlllllIIllIlllIlllIl < 32; ++llllllllllllIlllllIIllIlllIlllIl) {
                    final double llllllllllllIlllllIIllIlllIlllII = 0.25;
                    double llllllllllllIlllllIIllIlllIllIll = this.buffer[((llllllllllllIlllllIIllIlllIlllll + 0) * 3 + llllllllllllIlllllIIllIlllIllllI + 0) * 33 + llllllllllllIlllllIIllIlllIlllIl + 0];
                    double llllllllllllIlllllIIllIlllIllIlI = this.buffer[((llllllllllllIlllllIIllIlllIlllll + 0) * 3 + llllllllllllIlllllIIllIlllIllllI + 1) * 33 + llllllllllllIlllllIIllIlllIlllIl + 0];
                    double llllllllllllIlllllIIllIlllIllIIl = this.buffer[((llllllllllllIlllllIIllIlllIlllll + 1) * 3 + llllllllllllIlllllIIllIlllIllllI + 0) * 33 + llllllllllllIlllllIIllIlllIlllIl + 0];
                    double llllllllllllIlllllIIllIlllIllIII = this.buffer[((llllllllllllIlllllIIllIlllIlllll + 1) * 3 + llllllllllllIlllllIIllIlllIllllI + 1) * 33 + llllllllllllIlllllIIllIlllIlllIl + 0];
                    final double llllllllllllIlllllIIllIlllIlIlll = (this.buffer[((llllllllllllIlllllIIllIlllIlllll + 0) * 3 + llllllllllllIlllllIIllIlllIllllI + 0) * 33 + llllllllllllIlllllIIllIlllIlllIl + 1] - llllllllllllIlllllIIllIlllIllIll) * 0.25;
                    final double llllllllllllIlllllIIllIlllIlIllI = (this.buffer[((llllllllllllIlllllIIllIlllIlllll + 0) * 3 + llllllllllllIlllllIIllIlllIllllI + 1) * 33 + llllllllllllIlllllIIllIlllIlllIl + 1] - llllllllllllIlllllIIllIlllIllIlI) * 0.25;
                    final double llllllllllllIlllllIIllIlllIlIlIl = (this.buffer[((llllllllllllIlllllIIllIlllIlllll + 1) * 3 + llllllllllllIlllllIIllIlllIllllI + 0) * 33 + llllllllllllIlllllIIllIlllIlllIl + 1] - llllllllllllIlllllIIllIlllIllIIl) * 0.25;
                    final double llllllllllllIlllllIIllIlllIlIlII = (this.buffer[((llllllllllllIlllllIIllIlllIlllll + 1) * 3 + llllllllllllIlllllIIllIlllIllllI + 1) * 33 + llllllllllllIlllllIIllIlllIlllIl + 1] - llllllllllllIlllllIIllIlllIllIII) * 0.25;
                    for (int llllllllllllIlllllIIllIlllIlIIll = 0; llllllllllllIlllllIIllIlllIlIIll < 4; ++llllllllllllIlllllIIllIlllIlIIll) {
                        final double llllllllllllIlllllIIllIlllIlIIlI = 0.125;
                        double llllllllllllIlllllIIllIlllIlIIIl = llllllllllllIlllllIIllIlllIllIll;
                        double llllllllllllIlllllIIllIlllIlIIII = llllllllllllIlllllIIllIlllIllIlI;
                        final double llllllllllllIlllllIIllIlllIIllll = (llllllllllllIlllllIIllIlllIllIIl - llllllllllllIlllllIIllIlllIllIll) * 0.125;
                        final double llllllllllllIlllllIIllIlllIIlllI = (llllllllllllIlllllIIllIlllIllIII - llllllllllllIlllllIIllIlllIllIlI) * 0.125;
                        for (int llllllllllllIlllllIIllIlllIIllIl = 0; llllllllllllIlllllIIllIlllIIllIl < 8; ++llllllllllllIlllllIIllIlllIIllIl) {
                            final double llllllllllllIlllllIIllIlllIIllII = 0.125;
                            double llllllllllllIlllllIIllIlllIIlIll = llllllllllllIlllllIIllIlllIlIIIl;
                            final double llllllllllllIlllllIIllIlllIIlIlI = (llllllllllllIlllllIIllIlllIlIIII - llllllllllllIlllllIIllIlllIlIIIl) * 0.125;
                            for (int llllllllllllIlllllIIllIlllIIlIIl = 0; llllllllllllIlllllIIllIlllIIlIIl < 8; ++llllllllllllIlllllIIllIlllIIlIIl) {
                                IBlockState llllllllllllIlllllIIllIlllIIlIII = ChunkGeneratorEnd.AIR;
                                if (llllllllllllIlllllIIllIlllIIlIll > 0.0) {
                                    llllllllllllIlllllIIllIlllIIlIII = ChunkGeneratorEnd.END_STONE;
                                }
                                final int llllllllllllIlllllIIllIlllIIIlll = llllllllllllIlllllIIllIlllIIllIl + llllllllllllIlllllIIllIlllIlllll * 8;
                                final int llllllllllllIlllllIIllIlllIIIllI = llllllllllllIlllllIIllIlllIlIIll + llllllllllllIlllllIIllIlllIlllIl * 4;
                                final int llllllllllllIlllllIIllIlllIIIlIl = llllllllllllIlllllIIllIlllIIlIIl + llllllllllllIlllllIIllIlllIllllI * 8;
                                llllllllllllIlllllIIllIlllIIIIIl.setBlockState(llllllllllllIlllllIIllIlllIIIlll, llllllllllllIlllllIIllIlllIIIllI, llllllllllllIlllllIIllIlllIIIlIl, llllllllllllIlllllIIllIlllIIlIII);
                                llllllllllllIlllllIIllIlllIIlIll += llllllllllllIlllllIIllIlllIIlIlI;
                            }
                            llllllllllllIlllllIIllIlllIlIIIl += llllllllllllIlllllIIllIlllIIllll;
                            llllllllllllIlllllIIllIlllIlIIII += llllllllllllIlllllIIllIlllIIlllI;
                        }
                        llllllllllllIlllllIIllIlllIllIll += llllllllllllIlllllIIllIlllIlIlll;
                        llllllllllllIlllllIIllIlllIllIlI += llllllllllllIlllllIIllIlllIlIllI;
                        llllllllllllIlllllIIllIlllIllIIl += llllllllllllIlllllIIllIlllIlIlIl;
                        llllllllllllIlllllIIllIlllIllIII += llllllllllllIlllllIIllIlllIlIlII;
                    }
                }
            }
        }
    }
    
    @Nullable
    @Override
    public BlockPos getStrongholdGen(final World llllllllllllIlllllIIllIIlIlIlllI, final String llllllllllllIlllllIIllIIlIllIIlI, final BlockPos llllllllllllIlllllIIllIIlIllIIIl, final boolean llllllllllllIlllllIIllIIlIllIIII) {
        return ("EndCity".equals(llllllllllllIlllllIIllIIlIllIIlI) && this.endCityGen != null) ? this.endCityGen.getClosestStrongholdPos(llllllllllllIlllllIIllIIlIlIlllI, llllllllllllIlllllIIllIIlIllIIIl, llllllllllllIlllllIIllIIlIllIIII) : null;
    }
    
    @Override
    public void recreateStructures(final Chunk llllllllllllIlllllIIllIIlIIlllll, final int llllllllllllIlllllIIllIIlIIllllI, final int llllllllllllIlllllIIllIIlIIlllIl) {
    }
    
    private float getIslandHeightValue(final int llllllllllllIlllllIIllIlIllIIIIl, final int llllllllllllIlllllIIllIlIllIIIII, final int llllllllllllIlllllIIllIlIlIlIIIl, final int llllllllllllIlllllIIllIlIlIlIIII) {
        float llllllllllllIlllllIIllIlIlIlllIl = (float)(llllllllllllIlllllIIllIlIllIIIIl * 2 + llllllllllllIlllllIIllIlIlIlIIIl);
        float llllllllllllIlllllIIllIlIlIlllII = (float)(llllllllllllIlllllIIllIlIllIIIII * 2 + llllllllllllIlllllIIllIlIlIlIIII);
        float llllllllllllIlllllIIllIlIlIllIll = 100.0f - MathHelper.sqrt(llllllllllllIlllllIIllIlIlIlllIl * llllllllllllIlllllIIllIlIlIlllIl + llllllllllllIlllllIIllIlIlIlllII * llllllllllllIlllllIIllIlIlIlllII) * 8.0f;
        if (llllllllllllIlllllIIllIlIlIllIll > 80.0f) {
            llllllllllllIlllllIIllIlIlIllIll = 80.0f;
        }
        if (llllllllllllIlllllIIllIlIlIllIll < -100.0f) {
            llllllllllllIlllllIIllIlIlIllIll = -100.0f;
        }
        for (int llllllllllllIlllllIIllIlIlIllIlI = -12; llllllllllllIlllllIIllIlIlIllIlI <= 12; ++llllllllllllIlllllIIllIlIlIllIlI) {
            for (int llllllllllllIlllllIIllIlIlIllIIl = -12; llllllllllllIlllllIIllIlIlIllIIl <= 12; ++llllllllllllIlllllIIllIlIlIllIIl) {
                final long llllllllllllIlllllIIllIlIlIllIII = llllllllllllIlllllIIllIlIllIIIIl + llllllllllllIlllllIIllIlIlIllIlI;
                final long llllllllllllIlllllIIllIlIlIlIlll = llllllllllllIlllllIIllIlIllIIIII + llllllllllllIlllllIIllIlIlIllIIl;
                if (llllllllllllIlllllIIllIlIlIllIII * llllllllllllIlllllIIllIlIlIllIII + llllllllllllIlllllIIllIlIlIlIlll * llllllllllllIlllllIIllIlIlIlIlll > 4096L && this.islandNoise.getValue((double)llllllllllllIlllllIIllIlIlIllIII, (double)llllllllllllIlllllIIllIlIlIlIlll) < -0.8999999761581421) {
                    final float llllllllllllIlllllIIllIlIlIlIllI = (MathHelper.abs((float)llllllllllllIlllllIIllIlIlIllIII) * 3439.0f + MathHelper.abs((float)llllllllllllIlllllIIllIlIlIlIlll) * 147.0f) % 13.0f + 9.0f;
                    llllllllllllIlllllIIllIlIlIlllIl = (float)(llllllllllllIlllllIIllIlIlIlIIIl - llllllllllllIlllllIIllIlIlIllIlI * 2);
                    llllllllllllIlllllIIllIlIlIlllII = (float)(llllllllllllIlllllIIllIlIlIlIIII - llllllllllllIlllllIIllIlIlIllIIl * 2);
                    float llllllllllllIlllllIIllIlIlIlIlIl = 100.0f - MathHelper.sqrt(llllllllllllIlllllIIllIlIlIlllIl * llllllllllllIlllllIIllIlIlIlllIl + llllllllllllIlllllIIllIlIlIlllII * llllllllllllIlllllIIllIlIlIlllII) * llllllllllllIlllllIIllIlIlIlIllI;
                    if (llllllllllllIlllllIIllIlIlIlIlIl > 80.0f) {
                        llllllllllllIlllllIIllIlIlIlIlIl = 80.0f;
                    }
                    if (llllllllllllIlllllIIllIlIlIlIlIl < -100.0f) {
                        llllllllllllIlllllIIllIlIlIlIlIl = -100.0f;
                    }
                    if (llllllllllllIlllllIIllIlIlIlIlIl > llllllllllllIlllllIIllIlIlIllIll) {
                        llllllllllllIlllllIIllIlIlIllIll = llllllllllllIlllllIIllIlIlIlIlIl;
                    }
                }
            }
        }
        return llllllllllllIlllllIIllIlIlIllIll;
    }
    
    @Override
    public boolean generateStructures(final Chunk llllllllllllIlllllIIllIIllIIIlIl, final int llllllllllllIlllllIIllIIllIIIlII, final int llllllllllllIlllllIIllIIllIIIIll) {
        return false;
    }
    
    private double[] getHeights(double[] llllllllllllIlllllIIllIlIIIIlIll, final int llllllllllllIlllllIIllIlIIIIlIlI, final int llllllllllllIlllllIIllIlIIlIIIll, final int llllllllllllIlllllIIllIlIIIIlIII, final int llllllllllllIlllllIIllIlIIlIIIIl, final int llllllllllllIlllllIIllIlIIIIIllI, final int llllllllllllIlllllIIllIlIIIIIlIl) {
        if (llllllllllllIlllllIIllIlIIIIlIll == null) {
            llllllllllllIlllllIIllIlIIIIlIll = new double[llllllllllllIlllllIIllIlIIlIIIIl * llllllllllllIlllllIIllIlIIIIIllI * llllllllllllIlllllIIllIlIIIIIlIl];
        }
        double llllllllllllIlllllIIllIlIIIllllI = 684.412;
        final double llllllllllllIlllllIIllIlIIIlllIl = 684.412;
        llllllllllllIlllllIIllIlIIIllllI *= 2.0;
        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, llllllllllllIlllllIIllIlIIIIlIlI, llllllllllllIlllllIIllIlIIlIIIll, llllllllllllIlllllIIllIlIIIIlIII, llllllllllllIlllllIIllIlIIlIIIIl, llllllllllllIlllllIIllIlIIIIIllI, llllllllllllIlllllIIllIlIIIIIlIl, llllllllllllIlllllIIllIlIIIllllI / 80.0, 4.277575000000001, llllllllllllIlllllIIllIlIIIllllI / 80.0);
        this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, llllllllllllIlllllIIllIlIIIIlIlI, llllllllllllIlllllIIllIlIIlIIIll, llllllllllllIlllllIIllIlIIIIlIII, llllllllllllIlllllIIllIlIIlIIIIl, llllllllllllIlllllIIllIlIIIIIllI, llllllllllllIlllllIIllIlIIIIIlIl, llllllllllllIlllllIIllIlIIIllllI, 684.412, llllllllllllIlllllIIllIlIIIllllI);
        this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, llllllllllllIlllllIIllIlIIIIlIlI, llllllllllllIlllllIIllIlIIlIIIll, llllllllllllIlllllIIllIlIIIIlIII, llllllllllllIlllllIIllIlIIlIIIIl, llllllllllllIlllllIIllIlIIIIIllI, llllllllllllIlllllIIllIlIIIIIlIl, llllllllllllIlllllIIllIlIIIllllI, 684.412, llllllllllllIlllllIIllIlIIIllllI);
        final int llllllllllllIlllllIIllIlIIIlllII = llllllllllllIlllllIIllIlIIIIlIlI / 2;
        final int llllllllllllIlllllIIllIlIIIllIll = llllllllllllIlllllIIllIlIIIIlIII / 2;
        int llllllllllllIlllllIIllIlIIIllIlI = 0;
        for (int llllllllllllIlllllIIllIlIIIllIIl = 0; llllllllllllIlllllIIllIlIIIllIIl < llllllllllllIlllllIIllIlIIlIIIIl; ++llllllllllllIlllllIIllIlIIIllIIl) {
            for (int llllllllllllIlllllIIllIlIIIllIII = 0; llllllllllllIlllllIIllIlIIIllIII < llllllllllllIlllllIIllIlIIIIIlIl; ++llllllllllllIlllllIIllIlIIIllIII) {
                final float llllllllllllIlllllIIllIlIIIlIlll = this.getIslandHeightValue(llllllllllllIlllllIIllIlIIIlllII, llllllllllllIlllllIIllIlIIIllIll, llllllllllllIlllllIIllIlIIIllIIl, llllllllllllIlllllIIllIlIIIllIII);
                for (int llllllllllllIlllllIIllIlIIIlIllI = 0; llllllllllllIlllllIIllIlIIIlIllI < llllllllllllIlllllIIllIlIIIIIllI; ++llllllllllllIlllllIIllIlIIIlIllI) {
                    final double llllllllllllIlllllIIllIlIIIlIlIl = this.ar[llllllllllllIlllllIIllIlIIIllIlI] / 512.0;
                    final double llllllllllllIlllllIIllIlIIIlIlII = this.br[llllllllllllIlllllIIllIlIIIllIlI] / 512.0;
                    final double llllllllllllIlllllIIllIlIIIlIIll = (this.pnr[llllllllllllIlllllIIllIlIIIllIlI] / 10.0 + 1.0) / 2.0;
                    double llllllllllllIlllllIIllIlIIIlIIII = 0.0;
                    if (llllllllllllIlllllIIllIlIIIlIIll < 0.0) {
                        final double llllllllllllIlllllIIllIlIIIlIIlI = llllllllllllIlllllIIllIlIIIlIlIl;
                    }
                    else if (llllllllllllIlllllIIllIlIIIlIIll > 1.0) {
                        final double llllllllllllIlllllIIllIlIIIlIIIl = llllllllllllIlllllIIllIlIIIlIlII;
                    }
                    else {
                        llllllllllllIlllllIIllIlIIIlIIII = llllllllllllIlllllIIllIlIIIlIlIl + (llllllllllllIlllllIIllIlIIIlIlII - llllllllllllIlllllIIllIlIIIlIlIl) * llllllllllllIlllllIIllIlIIIlIIll;
                    }
                    llllllllllllIlllllIIllIlIIIlIIII -= 8.0;
                    llllllllllllIlllllIIllIlIIIlIIII += llllllllllllIlllllIIllIlIIIlIlll;
                    int llllllllllllIlllllIIllIlIIIIllll = 2;
                    if (llllllllllllIlllllIIllIlIIIlIllI > llllllllllllIlllllIIllIlIIIIIllI / 2 - llllllllllllIlllllIIllIlIIIIllll) {
                        double llllllllllllIlllllIIllIlIIIIlllI = (llllllllllllIlllllIIllIlIIIlIllI - (llllllllllllIlllllIIllIlIIIIIllI / 2 - llllllllllllIlllllIIllIlIIIIllll)) / 64.0f;
                        llllllllllllIlllllIIllIlIIIIlllI = MathHelper.clamp(llllllllllllIlllllIIllIlIIIIlllI, 0.0, 1.0);
                        llllllllllllIlllllIIllIlIIIlIIII = llllllllllllIlllllIIllIlIIIlIIII * (1.0 - llllllllllllIlllllIIllIlIIIIlllI) + -3000.0 * llllllllllllIlllllIIllIlIIIIlllI;
                    }
                    llllllllllllIlllllIIllIlIIIIllll = 8;
                    if (llllllllllllIlllllIIllIlIIIlIllI < llllllllllllIlllllIIllIlIIIIllll) {
                        final double llllllllllllIlllllIIllIlIIIIllIl = (llllllllllllIlllllIIllIlIIIIllll - llllllllllllIlllllIIllIlIIIlIllI) / (llllllllllllIlllllIIllIlIIIIllll - 1.0f);
                        llllllllllllIlllllIIllIlIIIlIIII = llllllllllllIlllllIIllIlIIIlIIII * (1.0 - llllllllllllIlllllIIllIlIIIIllIl) + -30.0 * llllllllllllIlllllIIllIlIIIIllIl;
                    }
                    llllllllllllIlllllIIllIlIIIIlIll[llllllllllllIlllllIIllIlIIIllIlI] = llllllllllllIlllllIIllIlIIIlIIII;
                    ++llllllllllllIlllllIIllIlIIIllIlI;
                }
            }
        }
        return (double[])llllllllllllIlllllIIllIlIIIIlIll;
    }
    
    @Override
    public Chunk provideChunk(final int llllllllllllIlllllIIllIlIlllllIl, final int llllllllllllIlllllIIllIlIlllllII) {
        this.rand.setSeed(llllllllllllIlllllIIllIlIlllllIl * 341873128712L + llllllllllllIlllllIIllIlIlllllII * 132897987541L);
        final ChunkPrimer llllllllllllIlllllIIllIlIllllIll = new ChunkPrimer();
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, llllllllllllIlllllIIllIlIlllllIl * 16, llllllllllllIlllllIIllIlIlllllII * 16, 16, 16);
        this.setBlocksInChunk(llllllllllllIlllllIIllIlIlllllIl, llllllllllllIlllllIIllIlIlllllII, llllllllllllIlllllIIllIlIllllIll);
        this.buildSurfaces(llllllllllllIlllllIIllIlIllllIll);
        if (this.mapFeaturesEnabled) {
            this.endCityGen.generate(this.worldObj, llllllllllllIlllllIIllIlIlllllIl, llllllllllllIlllllIIllIlIlllllII, llllllllllllIlllllIIllIlIllllIll);
        }
        final Chunk llllllllllllIlllllIIllIlIllllIlI = new Chunk(this.worldObj, llllllllllllIlllllIIllIlIllllIll, llllllllllllIlllllIIllIlIlllllIl, llllllllllllIlllllIIllIlIlllllII);
        final byte[] llllllllllllIlllllIIllIlIllllIIl = llllllllllllIlllllIIllIlIllllIlI.getBiomeArray();
        for (int llllllllllllIlllllIIllIlIllllIII = 0; llllllllllllIlllllIIllIlIllllIII < llllllllllllIlllllIIllIlIllllIIl.length; ++llllllllllllIlllllIIllIlIllllIII) {
            llllllllllllIlllllIIllIlIllllIIl[llllllllllllIlllllIIllIlIllllIII] = (byte)Biome.getIdForBiome(this.biomesForGeneration[llllllllllllIlllllIIllIlIllllIII]);
        }
        llllllllllllIlllllIIllIlIllllIlI.generateSkylightMap();
        return llllllllllllIlllllIIllIlIllllIlI;
    }
    
    public void buildSurfaces(final ChunkPrimer llllllllllllIlllllIIllIllIIIlllI) {
        for (int llllllllllllIlllllIIllIllIIlIllI = 0; llllllllllllIlllllIIllIllIIlIllI < 16; ++llllllllllllIlllllIIllIllIIlIllI) {
            for (int llllllllllllIlllllIIllIllIIlIlIl = 0; llllllllllllIlllllIIllIllIIlIlIl < 16; ++llllllllllllIlllllIIllIllIIlIlIl) {
                final int llllllllllllIlllllIIllIllIIlIlII = 1;
                int llllllllllllIlllllIIllIllIIlIIll = -1;
                final IBlockState llllllllllllIlllllIIllIllIIlIIlI = ChunkGeneratorEnd.END_STONE;
                final IBlockState llllllllllllIlllllIIllIllIIlIIIl = ChunkGeneratorEnd.END_STONE;
                for (int llllllllllllIlllllIIllIllIIlIIII = 127; llllllllllllIlllllIIllIllIIlIIII >= 0; --llllllllllllIlllllIIllIllIIlIIII) {
                    final IBlockState llllllllllllIlllllIIllIllIIIllll = llllllllllllIlllllIIllIllIIIlllI.getBlockState(llllllllllllIlllllIIllIllIIlIllI, llllllllllllIlllllIIllIllIIlIIII, llllllllllllIlllllIIllIllIIlIlIl);
                    if (llllllllllllIlllllIIllIllIIIllll.getMaterial() == Material.AIR) {
                        llllllllllllIlllllIIllIllIIlIIll = -1;
                    }
                    else if (llllllllllllIlllllIIllIllIIIllll.getBlock() == Blocks.STONE) {
                        if (llllllllllllIlllllIIllIllIIlIIll == -1) {
                            llllllllllllIlllllIIllIllIIlIIll = 1;
                            if (llllllllllllIlllllIIllIllIIlIIII >= 0) {
                                llllllllllllIlllllIIllIllIIIlllI.setBlockState(llllllllllllIlllllIIllIllIIlIllI, llllllllllllIlllllIIllIllIIlIIII, llllllllllllIlllllIIllIllIIlIlIl, llllllllllllIlllllIIllIllIIlIIlI);
                            }
                            else {
                                llllllllllllIlllllIIllIllIIIlllI.setBlockState(llllllllllllIlllllIIllIllIIlIllI, llllllllllllIlllllIIllIllIIlIIII, llllllllllllIlllllIIllIllIIlIlIl, llllllllllllIlllllIIllIllIIlIIIl);
                            }
                        }
                        else if (llllllllllllIlllllIIllIllIIlIIll > 0) {
                            --llllllllllllIlllllIIllIllIIlIIll;
                            llllllllllllIlllllIIllIllIIIlllI.setBlockState(llllllllllllIlllllIIllIllIIlIllI, llllllllllllIlllllIIllIllIIlIIII, llllllllllllIlllllIIllIllIIlIlIl, llllllllllllIlllllIIllIllIIlIIIl);
                        }
                    }
                }
            }
        }
    }
    
    static {
        END_STONE = Blocks.END_STONE.getDefaultState();
        AIR = Blocks.AIR.getDefaultState();
    }
    
    @Override
    public boolean func_193414_a(final World llllllllllllIlllllIIllIIlIlIIllI, final String llllllllllllIlllllIIllIIlIlIIlIl, final BlockPos llllllllllllIlllllIIllIIlIlIIlII) {
        return "EndCity".equals(llllllllllllIlllllIIllIIlIlIIlIl) && this.endCityGen != null && this.endCityGen.isInsideStructure(llllllllllllIlllllIIllIIlIlIIlII);
    }
}
