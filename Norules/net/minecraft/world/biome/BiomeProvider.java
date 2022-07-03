package net.minecraft.world.biome;

import net.minecraft.world.gen.*;
import javax.annotation.*;
import net.minecraft.world.gen.layer.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.world.storage.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;

public class BiomeProvider
{
    private /* synthetic */ ChunkGeneratorSettings field_190945_a;
    private final /* synthetic */ List<Biome> biomesToSpawnIn;
    private final /* synthetic */ BiomeCache biomeCache;
    private /* synthetic */ GenLayer genBiomes;
    private /* synthetic */ GenLayer biomeIndexLayer;
    
    public Biome[] getBiomes(@Nullable Biome[] lllllllllllllllIIIIllIllIlIlIllI, final int lllllllllllllllIIIIllIllIlIlllll, final int lllllllllllllllIIIIllIllIlIllllI, final int lllllllllllllllIIIIllIllIlIlllIl, final int lllllllllllllllIIIIllIllIlIlIIlI, final boolean lllllllllllllllIIIIllIllIlIlIIIl) {
        IntCache.resetIntCache();
        if (lllllllllllllllIIIIllIllIlIlIllI == null || lllllllllllllllIIIIllIllIlIlIllI.length < lllllllllllllllIIIIllIllIlIlllIl * lllllllllllllllIIIIllIllIlIlIIlI) {
            lllllllllllllllIIIIllIllIlIlIllI = new Biome[lllllllllllllllIIIIllIllIlIlllIl * lllllllllllllllIIIIllIllIlIlIIlI];
        }
        if (lllllllllllllllIIIIllIllIlIlIIIl && lllllllllllllllIIIIllIllIlIlllIl == 16 && lllllllllllllllIIIIllIllIlIlIIlI == 16 && (lllllllllllllllIIIIllIllIlIlllll & 0xF) == 0x0 && (lllllllllllllllIIIIllIllIlIllllI & 0xF) == 0x0) {
            final Biome[] lllllllllllllllIIIIllIllIlIllIlI = this.biomeCache.getCachedBiomes(lllllllllllllllIIIIllIllIlIlllll, lllllllllllllllIIIIllIllIlIllllI);
            System.arraycopy(lllllllllllllllIIIIllIllIlIllIlI, 0, lllllllllllllllIIIIllIllIlIlIllI, 0, lllllllllllllllIIIIllIllIlIlllIl * lllllllllllllllIIIIllIllIlIlIIlI);
            return lllllllllllllllIIIIllIllIlIlIllI;
        }
        final int[] lllllllllllllllIIIIllIllIlIllIIl = this.biomeIndexLayer.getInts(lllllllllllllllIIIIllIllIlIlllll, lllllllllllllllIIIIllIllIlIllllI, lllllllllllllllIIIIllIllIlIlllIl, lllllllllllllllIIIIllIllIlIlIIlI);
        for (int lllllllllllllllIIIIllIllIlIllIII = 0; lllllllllllllllIIIIllIllIlIllIII < lllllllllllllllIIIIllIllIlIlllIl * lllllllllllllllIIIIllIllIlIlIIlI; ++lllllllllllllllIIIIllIllIlIllIII) {
            lllllllllllllllIIIIllIllIlIlIllI[lllllllllllllllIIIIllIllIlIllIII] = Biome.getBiome(lllllllllllllllIIIIllIllIlIllIIl[lllllllllllllllIIIIllIllIlIllIII], Biomes.DEFAULT);
        }
        return lllllllllllllllIIIIllIllIlIlIllI;
    }
    
    public float getTemperatureAtHeight(final float lllllllllllllllIIIIllIlllIIllllI, final int lllllllllllllllIIIIllIlllIIlllIl) {
        return lllllllllllllllIIIIllIlllIIllllI;
    }
    
    @Nullable
    public BlockPos findBiomePosition(final int lllllllllllllllIIIIllIlIlllllIII, final int lllllllllllllllIIIIllIllIIIIlIlI, final int lllllllllllllllIIIIllIllIIIIlIIl, final List<Biome> lllllllllllllllIIIIllIlIllllIlIl, final Random lllllllllllllllIIIIllIllIIIIIlll) {
        IntCache.resetIntCache();
        final int lllllllllllllllIIIIllIllIIIIIllI = lllllllllllllllIIIIllIlIlllllIII - lllllllllllllllIIIIllIllIIIIlIIl >> 2;
        final int lllllllllllllllIIIIllIllIIIIIlIl = lllllllllllllllIIIIllIllIIIIlIlI - lllllllllllllllIIIIllIllIIIIlIIl >> 2;
        final int lllllllllllllllIIIIllIllIIIIIlII = lllllllllllllllIIIIllIlIlllllIII + lllllllllllllllIIIIllIllIIIIlIIl >> 2;
        final int lllllllllllllllIIIIllIllIIIIIIll = lllllllllllllllIIIIllIllIIIIlIlI + lllllllllllllllIIIIllIllIIIIlIIl >> 2;
        final int lllllllllllllllIIIIllIllIIIIIIlI = lllllllllllllllIIIIllIllIIIIIlII - lllllllllllllllIIIIllIllIIIIIllI + 1;
        final int lllllllllllllllIIIIllIllIIIIIIIl = lllllllllllllllIIIIllIllIIIIIIll - lllllllllllllllIIIIllIllIIIIIlIl + 1;
        final int[] lllllllllllllllIIIIllIllIIIIIIII = this.genBiomes.getInts(lllllllllllllllIIIIllIllIIIIIllI, lllllllllllllllIIIIllIllIIIIIlIl, lllllllllllllllIIIIllIllIIIIIIlI, lllllllllllllllIIIIllIllIIIIIIIl);
        BlockPos lllllllllllllllIIIIllIlIllllllll = null;
        int lllllllllllllllIIIIllIlIlllllllI = 0;
        for (int lllllllllllllllIIIIllIlIllllllIl = 0; lllllllllllllllIIIIllIlIllllllIl < lllllllllllllllIIIIllIllIIIIIIlI * lllllllllllllllIIIIllIllIIIIIIIl; ++lllllllllllllllIIIIllIlIllllllIl) {
            final int lllllllllllllllIIIIllIlIllllllII = lllllllllllllllIIIIllIllIIIIIllI + lllllllllllllllIIIIllIlIllllllIl % lllllllllllllllIIIIllIllIIIIIIlI << 2;
            final int lllllllllllllllIIIIllIlIlllllIll = lllllllllllllllIIIIllIllIIIIIlIl + lllllllllllllllIIIIllIlIllllllIl / lllllllllllllllIIIIllIllIIIIIIlI << 2;
            final Biome lllllllllllllllIIIIllIlIlllllIlI = Biome.getBiome(lllllllllllllllIIIIllIllIIIIIIII[lllllllllllllllIIIIllIlIllllllIl]);
            if (lllllllllllllllIIIIllIlIllllIlIl.contains(lllllllllllllllIIIIllIlIlllllIlI) && (lllllllllllllllIIIIllIlIllllllll == null || lllllllllllllllIIIIllIllIIIIIlll.nextInt(lllllllllllllllIIIIllIlIlllllllI + 1) == 0)) {
                lllllllllllllllIIIIllIlIllllllll = new BlockPos(lllllllllllllllIIIIllIlIllllllII, 0, lllllllllllllllIIIIllIlIlllllIll);
                ++lllllllllllllllIIIIllIlIlllllllI;
            }
        }
        return lllllllllllllllIIIIllIlIllllllll;
    }
    
    protected BiomeProvider() {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = (List<Biome>)Lists.newArrayList((Object[])new Biome[] { Biomes.FOREST, Biomes.PLAINS, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.FOREST_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_HILLS });
    }
    
    public Biome func_190943_d() {
        return (this.field_190945_a != null && this.field_190945_a.fixedBiome >= 0) ? Biome.getBiomeForId(this.field_190945_a.fixedBiome) : null;
    }
    
    public Biome[] getBiomes(@Nullable final Biome[] lllllllllllllllIIIIllIllIlllIlIl, final int lllllllllllllllIIIIllIllIllIlllI, final int lllllllllllllllIIIIllIllIlllIIll, final int lllllllllllllllIIIIllIllIlllIIlI, final int lllllllllllllllIIIIllIllIllIlIll) {
        return this.getBiomes(lllllllllllllllIIIIllIllIlllIlIl, lllllllllllllllIIIIllIllIllIlllI, lllllllllllllllIIIIllIllIlllIIll, lllllllllllllllIIIIllIllIlllIIlI, lllllllllllllllIIIIllIllIllIlIll, true);
    }
    
    public BiomeProvider(final WorldInfo lllllllllllllllIIIIllIlllIllIIll) {
        this(lllllllllllllllIIIIllIlllIllIIll.getSeed(), lllllllllllllllIIIIllIlllIllIIll.getTerrainType(), lllllllllllllllIIIIllIlllIllIIll.getGeneratorOptions());
    }
    
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
    
    public List<Biome> getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }
    
    private BiomeProvider(final long lllllllllllllllIIIIllIllllIIIIIl, final WorldType lllllllllllllllIIIIllIllllIIIIII, final String lllllllllllllllIIIIllIlllIllllll) {
        this();
        if (lllllllllllllllIIIIllIllllIIIIII == WorldType.CUSTOMIZED && !lllllllllllllllIIIIllIlllIllllll.isEmpty()) {
            this.field_190945_a = ChunkGeneratorSettings.Factory.jsonToFactory(lllllllllllllllIIIIllIlllIllllll).build();
        }
        final GenLayer[] lllllllllllllllIIIIllIlllIlllllI = GenLayer.initializeAllBiomeGenerators(lllllllllllllllIIIIllIllllIIIIIl, lllllllllllllllIIIIllIllllIIIIII, this.field_190945_a);
        this.genBiomes = lllllllllllllllIIIIllIlllIlllllI[0];
        this.biomeIndexLayer = lllllllllllllllIIIIllIlllIlllllI[1];
    }
    
    public boolean areBiomesViable(final int lllllllllllllllIIIIllIllIIlIllIl, final int lllllllllllllllIIIIllIllIIllllIl, final int lllllllllllllllIIIIllIllIIllllII, final List<Biome> lllllllllllllllIIIIllIllIIlIlIlI) {
        IntCache.resetIntCache();
        final int lllllllllllllllIIIIllIllIIlllIlI = lllllllllllllllIIIIllIllIIlIllIl - lllllllllllllllIIIIllIllIIllllII >> 2;
        final int lllllllllllllllIIIIllIllIIlllIIl = lllllllllllllllIIIIllIllIIllllIl - lllllllllllllllIIIIllIllIIllllII >> 2;
        final int lllllllllllllllIIIIllIllIIlllIII = lllllllllllllllIIIIllIllIIlIllIl + lllllllllllllllIIIIllIllIIllllII >> 2;
        final int lllllllllllllllIIIIllIllIIllIlll = lllllllllllllllIIIIllIllIIllllIl + lllllllllllllllIIIIllIllIIllllII >> 2;
        final int lllllllllllllllIIIIllIllIIllIllI = lllllllllllllllIIIIllIllIIlllIII - lllllllllllllllIIIIllIllIIlllIlI + 1;
        final int lllllllllllllllIIIIllIllIIllIlIl = lllllllllllllllIIIIllIllIIllIlll - lllllllllllllllIIIIllIllIIlllIIl + 1;
        final int[] lllllllllllllllIIIIllIllIIllIlII = this.genBiomes.getInts(lllllllllllllllIIIIllIllIIlllIlI, lllllllllllllllIIIIllIllIIlllIIl, lllllllllllllllIIIIllIllIIllIllI, lllllllllllllllIIIIllIllIIllIlIl);
        try {
            for (int lllllllllllllllIIIIllIllIIllIIll = 0; lllllllllllllllIIIIllIllIIllIIll < lllllllllllllllIIIIllIllIIllIllI * lllllllllllllllIIIIllIllIIllIlIl; ++lllllllllllllllIIIIllIllIIllIIll) {
                final Biome lllllllllllllllIIIIllIllIIllIIlI = Biome.getBiome(lllllllllllllllIIIIllIllIIllIlII[lllllllllllllllIIIIllIllIIllIIll]);
                if (!lllllllllllllllIIIIllIllIIlIlIlI.contains(lllllllllllllllIIIIllIllIIllIIlI)) {
                    return false;
                }
            }
            return true;
        }
        catch (Throwable lllllllllllllllIIIIllIllIIllIIIl) {
            final CrashReport lllllllllllllllIIIIllIllIIllIIII = CrashReport.makeCrashReport(lllllllllllllllIIIIllIllIIllIIIl, "Invalid Biome id");
            final CrashReportCategory lllllllllllllllIIIIllIllIIlIllll = lllllllllllllllIIIIllIllIIllIIII.makeCategory("Layer");
            lllllllllllllllIIIIllIllIIlIllll.addCrashSection("Layer", this.genBiomes.toString());
            lllllllllllllllIIIIllIllIIlIllll.addCrashSection("x", lllllllllllllllIIIIllIllIIlIllIl);
            lllllllllllllllIIIIllIllIIlIllll.addCrashSection("z", lllllllllllllllIIIIllIllIIllllIl);
            lllllllllllllllIIIIllIllIIlIllll.addCrashSection("radius", lllllllllllllllIIIIllIllIIllllII);
            lllllllllllllllIIIIllIllIIlIllll.addCrashSection("allowed", lllllllllllllllIIIIllIllIIlIlIlI);
            throw new ReportedException(lllllllllllllllIIIIllIllIIllIIII);
        }
    }
    
    public Biome[] getBiomesForGeneration(Biome[] lllllllllllllllIIIIllIlllIIIIlIl, final int lllllllllllllllIIIIllIlllIIIllll, final int lllllllllllllllIIIIllIlllIIIIIll, final int lllllllllllllllIIIIllIlllIIIIIlI, final int lllllllllllllllIIIIllIlllIIIIIIl) {
        IntCache.resetIntCache();
        if (lllllllllllllllIIIIllIlllIIIIlIl == null || lllllllllllllllIIIIllIlllIIIIlIl.length < lllllllllllllllIIIIllIlllIIIIIlI * lllllllllllllllIIIIllIlllIIIIIIl) {
            lllllllllllllllIIIIllIlllIIIIlIl = new Biome[lllllllllllllllIIIIllIlllIIIIIlI * lllllllllllllllIIIIllIlllIIIIIIl];
        }
        final int[] lllllllllllllllIIIIllIlllIIIlIll = this.genBiomes.getInts(lllllllllllllllIIIIllIlllIIIllll, lllllllllllllllIIIIllIlllIIIIIll, lllllllllllllllIIIIllIlllIIIIIlI, lllllllllllllllIIIIllIlllIIIIIIl);
        try {
            for (int lllllllllllllllIIIIllIlllIIIlIlI = 0; lllllllllllllllIIIIllIlllIIIlIlI < lllllllllllllllIIIIllIlllIIIIIlI * lllllllllllllllIIIIllIlllIIIIIIl; ++lllllllllllllllIIIIllIlllIIIlIlI) {
                lllllllllllllllIIIIllIlllIIIIlIl[lllllllllllllllIIIIllIlllIIIlIlI] = Biome.getBiome(lllllllllllllllIIIIllIlllIIIlIll[lllllllllllllllIIIIllIlllIIIlIlI], Biomes.DEFAULT);
            }
            return lllllllllllllllIIIIllIlllIIIIlIl;
        }
        catch (Throwable lllllllllllllllIIIIllIlllIIIlIIl) {
            final CrashReport lllllllllllllllIIIIllIlllIIIlIII = CrashReport.makeCrashReport(lllllllllllllllIIIIllIlllIIIlIIl, "Invalid Biome id");
            final CrashReportCategory lllllllllllllllIIIIllIlllIIIIlll = lllllllllllllllIIIIllIlllIIIlIII.makeCategory("RawBiomeBlock");
            lllllllllllllllIIIIllIlllIIIIlll.addCrashSection("biomes[] size", lllllllllllllllIIIIllIlllIIIIlIl.length);
            lllllllllllllllIIIIllIlllIIIIlll.addCrashSection("x", lllllllllllllllIIIIllIlllIIIllll);
            lllllllllllllllIIIIllIlllIIIIlll.addCrashSection("z", lllllllllllllllIIIIllIlllIIIIIll);
            lllllllllllllllIIIIllIlllIIIIlll.addCrashSection("w", lllllllllllllllIIIIllIlllIIIIIlI);
            lllllllllllllllIIIIllIlllIIIIlll.addCrashSection("h", lllllllllllllllIIIIllIlllIIIIIIl);
            throw new ReportedException(lllllllllllllllIIIIllIlllIIIlIII);
        }
    }
    
    public Biome getBiome(final BlockPos lllllllllllllllIIIIllIlllIlIllII) {
        return this.getBiome(lllllllllllllllIIIIllIlllIlIllII, null);
    }
    
    public boolean func_190944_c() {
        return this.field_190945_a != null && this.field_190945_a.fixedBiome >= 0;
    }
    
    public Biome getBiome(final BlockPos lllllllllllllllIIIIllIlllIlIIlIl, final Biome lllllllllllllllIIIIllIlllIlIIIIl) {
        return this.biomeCache.getBiome(lllllllllllllllIIIIllIlllIlIIlIl.getX(), lllllllllllllllIIIIllIlllIlIIlIl.getZ(), lllllllllllllllIIIIllIlllIlIIIIl);
    }
}
