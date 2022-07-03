package optifine;

import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RandomMobsRule
{
    private /* synthetic */ RangeListInt heights;
    private /* synthetic */ Biome[] biomes;
    private /* synthetic */ int[] skins;
    public /* synthetic */ int sumAllWeights;
    private /* synthetic */ int[] weights;
    public /* synthetic */ int[] sumWeights;
    private /* synthetic */ ResourceLocation[] resourceLocations;
    private /* synthetic */ ResourceLocation baseResLoc;
    
    public ResourceLocation getTextureLocation(final ResourceLocation lllllllllllllIlIIllllIIlIllllIlI, final int lllllllllllllIlIIllllIIlIlllIlII) {
        int lllllllllllllIlIIllllIIlIllllIII = 0;
        if (this.weights == null) {
            lllllllllllllIlIIllllIIlIllllIII = lllllllllllllIlIIllllIIlIlllIlII % this.resourceLocations.length;
        }
        else {
            final int lllllllllllllIlIIllllIIlIlllIlll = lllllllllllllIlIIllllIIlIlllIlII % this.sumAllWeights;
            for (int lllllllllllllIlIIllllIIlIlllIllI = 0; lllllllllllllIlIIllllIIlIlllIllI < this.sumWeights.length; ++lllllllllllllIlIIllllIIlIlllIllI) {
                if (this.sumWeights[lllllllllllllIlIIllllIIlIlllIllI] > lllllllllllllIlIIllllIIlIlllIlll) {
                    lllllllllllllIlIIllllIIlIllllIII = lllllllllllllIlIIllllIIlIlllIllI;
                    break;
                }
            }
        }
        return this.resourceLocations[lllllllllllllIlIIllllIIlIllllIII];
    }
    
    public RandomMobsRule(final ResourceLocation lllllllllllllIlIIllllIIlllIlIlll, final int[] lllllllllllllIlIIllllIIlllIIlIlI, final int[] lllllllllllllIlIIllllIIlllIIlIIl, final Biome[] lllllllllllllIlIIllllIIlllIIIlll, final RangeListInt lllllllllllllIlIIllllIIlllIIIlIl) {
        this.baseResLoc = null;
        this.skins = null;
        this.resourceLocations = null;
        this.weights = null;
        this.biomes = null;
        this.heights = null;
        this.sumWeights = null;
        this.sumAllWeights = 1;
        this.baseResLoc = lllllllllllllIlIIllllIIlllIlIlll;
        this.skins = lllllllllllllIlIIllllIIlllIIlIlI;
        this.weights = lllllllllllllIlIIllllIIlllIIlIIl;
        this.biomes = lllllllllllllIlIIllllIIlllIIIlll;
        this.heights = lllllllllllllIlIIllllIIlllIIIlIl;
    }
    
    public boolean matches(final EntityLiving lllllllllllllIlIIllllIIllIIIIIIl) {
        return Matches.biome(lllllllllllllIlIIllllIIllIIIIIIl.spawnBiome, this.biomes) && (this.heights == null || lllllllllllllIlIIllllIIllIIIIIIl.spawnPosition == null || this.heights.isInRange(lllllllllllllIlIIllllIIllIIIIIIl.spawnPosition.getY()));
    }
    
    public boolean isValid(final String lllllllllllllIlIIllllIIllIIIlIll) {
        this.resourceLocations = new ResourceLocation[this.skins.length];
        final ResourceLocation lllllllllllllIlIIllllIIllIIllIll = RandomMobs.getMcpatcherLocation(this.baseResLoc);
        if (lllllllllllllIlIIllllIIllIIllIll == null) {
            Config.warn(String.valueOf(new StringBuilder("Invalid path: ").append(this.baseResLoc.getResourcePath())));
            return false;
        }
        for (int lllllllllllllIlIIllllIIllIIllIIl = 0; lllllllllllllIlIIllllIIllIIllIIl < this.resourceLocations.length; ++lllllllllllllIlIIllllIIllIIllIIl) {
            final int lllllllllllllIlIIllllIIllIIllIII = this.skins[lllllllllllllIlIIllllIIllIIllIIl];
            if (lllllllllllllIlIIllllIIllIIllIII <= 1) {
                this.resourceLocations[lllllllllllllIlIIllllIIllIIllIIl] = this.baseResLoc;
            }
            else {
                final ResourceLocation lllllllllllllIlIIllllIIllIIlIlll = RandomMobs.getLocationIndexed(lllllllllllllIlIIllllIIllIIllIll, lllllllllllllIlIIllllIIllIIllIII);
                if (lllllllllllllIlIIllllIIllIIlIlll == null) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid path: ").append(this.baseResLoc.getResourcePath())));
                    return false;
                }
                if (!Config.hasResource(lllllllllllllIlIIllllIIllIIlIlll)) {
                    Config.warn(String.valueOf(new StringBuilder("Texture not found: ").append(lllllllllllllIlIIllllIIllIIlIlll.getResourcePath())));
                    return false;
                }
                this.resourceLocations[lllllllllllllIlIIllllIIllIIllIIl] = lllllllllllllIlIIllllIIllIIlIlll;
            }
        }
        if (this.weights != null) {
            if (this.weights.length > this.resourceLocations.length) {
                Config.warn(String.valueOf(new StringBuilder("More weights defined than skins, trimming weights: ").append(lllllllllllllIlIIllllIIllIIIlIll)));
                final int[] lllllllllllllIlIIllllIIllIIlIllI = new int[this.resourceLocations.length];
                System.arraycopy(this.weights, 0, lllllllllllllIlIIllllIIllIIlIllI, 0, lllllllllllllIlIIllllIIllIIlIllI.length);
                this.weights = lllllllllllllIlIIllllIIllIIlIllI;
            }
            if (this.weights.length < this.resourceLocations.length) {
                Config.warn(String.valueOf(new StringBuilder("Less weights defined than skins, expanding weights: ").append(lllllllllllllIlIIllllIIllIIIlIll)));
                final int[] lllllllllllllIlIIllllIIllIIlIlII = new int[this.resourceLocations.length];
                System.arraycopy(this.weights, 0, lllllllllllllIlIIllllIIllIIlIlII, 0, this.weights.length);
                final int lllllllllllllIlIIllllIIllIIlIIlI = MathUtils.getAverage(this.weights);
                for (int lllllllllllllIlIIllllIIllIIlIIIl = this.weights.length; lllllllllllllIlIIllllIIllIIlIIIl < lllllllllllllIlIIllllIIllIIlIlII.length; ++lllllllllllllIlIIllllIIllIIlIIIl) {
                    lllllllllllllIlIIllllIIllIIlIlII[lllllllllllllIlIIllllIIllIIlIIIl] = lllllllllllllIlIIllllIIllIIlIIlI;
                }
                this.weights = lllllllllllllIlIIllllIIllIIlIlII;
            }
            this.sumWeights = new int[this.weights.length];
            int lllllllllllllIlIIllllIIllIIIllll = 0;
            for (int lllllllllllllIlIIllllIIllIIIllIl = 0; lllllllllllllIlIIllllIIllIIIllIl < this.weights.length; ++lllllllllllllIlIIllllIIllIIIllIl) {
                if (this.weights[lllllllllllllIlIIllllIIllIIIllIl] < 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid weight: ").append(this.weights[lllllllllllllIlIIllllIIllIIIllIl])));
                    return false;
                }
                lllllllllllllIlIIllllIIllIIIllll += this.weights[lllllllllllllIlIIllllIIllIIIllIl];
                this.sumWeights[lllllllllllllIlIIllllIIllIIIllIl] = lllllllllllllIlIIllllIIllIIIllll;
            }
            this.sumAllWeights = lllllllllllllIlIIllllIIllIIIllll;
            if (this.sumAllWeights <= 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid sum of all weights: ").append(lllllllllllllIlIIllllIIllIIIllll)));
                this.sumAllWeights = 1;
            }
        }
        return true;
    }
}
