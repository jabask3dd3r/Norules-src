package net.minecraft.world.biome;

import javax.annotation.*;
import java.util.*;
import net.minecraft.util.math.*;

public class BiomeProviderSingle extends BiomeProvider
{
    private final /* synthetic */ Biome biome;
    
    @Override
    public boolean func_190944_c() {
        return true;
    }
    
    public BiomeProviderSingle(final Biome lllllllllllllllIlIlllIlIllIIllII) {
        this.biome = lllllllllllllllIlIlllIlIllIIllII;
    }
    
    @Override
    public boolean areBiomesViable(final int lllllllllllllllIlIlllIlIlIIIIIll, final int lllllllllllllllIlIlllIlIlIIIIIlI, final int lllllllllllllllIlIlllIlIlIIIIIIl, final List<Biome> lllllllllllllllIlIlllIlIlIIIIIII) {
        return lllllllllllllllIlIlllIlIlIIIIIII.contains(this.biome);
    }
    
    @Override
    public Biome[] getBiomes(@Nullable final Biome[] lllllllllllllllIlIlllIlIlIlIIlII, final int lllllllllllllllIlIlllIlIlIlIIIll, final int lllllllllllllllIlIlllIlIlIIllIll, final int lllllllllllllllIlIlllIlIlIIllIlI, final int lllllllllllllllIlIlllIlIlIIllIIl, final boolean lllllllllllllllIlIlllIlIlIIlllll) {
        return this.getBiomes(lllllllllllllllIlIlllIlIlIlIIlII, lllllllllllllllIlIlllIlIlIlIIIll, lllllllllllllllIlIlllIlIlIIllIll, lllllllllllllllIlIlllIlIlIIllIlI, lllllllllllllllIlIlllIlIlIIllIIl);
    }
    
    @Override
    public Biome[] getBiomesForGeneration(Biome[] lllllllllllllllIlIlllIlIlIllllII, final int lllllllllllllllIlIlllIlIllIIIIIl, final int lllllllllllllllIlIlllIlIllIIIIII, final int lllllllllllllllIlIlllIlIlIllllll, final int lllllllllllllllIlIlllIlIlIlllllI) {
        if (lllllllllllllllIlIlllIlIlIllllII == null || lllllllllllllllIlIlllIlIlIllllII.length < lllllllllllllllIlIlllIlIlIllllll * lllllllllllllllIlIlllIlIlIlllllI) {
            lllllllllllllllIlIlllIlIlIllllII = new Biome[lllllllllllllllIlIlllIlIlIllllll * lllllllllllllllIlIlllIlIlIlllllI];
        }
        Arrays.fill((Object[])lllllllllllllllIlIlllIlIlIllllII, 0, lllllllllllllllIlIlllIlIlIllllll * lllllllllllllllIlIlllIlIlIlllllI, this.biome);
        return (Biome[])lllllllllllllllIlIlllIlIlIllllII;
    }
    
    @Override
    public Biome[] getBiomes(@Nullable Biome[] lllllllllllllllIlIlllIlIlIlIlllI, final int lllllllllllllllIlIlllIlIlIllIIll, final int lllllllllllllllIlIlllIlIlIllIIlI, final int lllllllllllllllIlIlllIlIlIllIIIl, final int lllllllllllllllIlIlllIlIlIllIIII) {
        if (lllllllllllllllIlIlllIlIlIlIlllI == null || lllllllllllllllIlIlllIlIlIlIlllI.length < lllllllllllllllIlIlllIlIlIllIIIl * lllllllllllllllIlIlllIlIlIllIIII) {
            lllllllllllllllIlIlllIlIlIlIlllI = new Biome[lllllllllllllllIlIlllIlIlIllIIIl * lllllllllllllllIlIlllIlIlIllIIII];
        }
        Arrays.fill((Object[])lllllllllllllllIlIlllIlIlIlIlllI, 0, lllllllllllllllIlIlllIlIlIllIIIl * lllllllllllllllIlIlllIlIlIllIIII, this.biome);
        return (Biome[])lllllllllllllllIlIlllIlIlIlIlllI;
    }
    
    @Nullable
    @Override
    public BlockPos findBiomePosition(final int lllllllllllllllIlIlllIlIlIIIlIll, final int lllllllllllllllIlIlllIlIlIIIlIlI, final int lllllllllllllllIlIlllIlIlIIIllll, final List<Biome> lllllllllllllllIlIlllIlIlIIIlllI, final Random lllllllllllllllIlIlllIlIlIIIllIl) {
        return lllllllllllllllIlIlllIlIlIIIlllI.contains(this.biome) ? new BlockPos(lllllllllllllllIlIlllIlIlIIIlIll - lllllllllllllllIlIlllIlIlIIIllll + lllllllllllllllIlIlllIlIlIIIllIl.nextInt(lllllllllllllllIlIlllIlIlIIIllll * 2 + 1), 0, lllllllllllllllIlIlllIlIlIIIlIlI - lllllllllllllllIlIlllIlIlIIIllll + lllllllllllllllIlIlllIlIlIIIllIl.nextInt(lllllllllllllllIlIlllIlIlIIIllll * 2 + 1)) : null;
    }
    
    @Override
    public Biome getBiome(final BlockPos lllllllllllllllIlIlllIlIllIIlIIl) {
        return this.biome;
    }
    
    @Override
    public Biome func_190943_d() {
        return this.biome;
    }
}
