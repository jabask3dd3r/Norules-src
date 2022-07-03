package optifine;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.biome.*;

public class RandomMobsProperties
{
    public /* synthetic */ String basePath;
    public /* synthetic */ RandomMobsRule[] rules;
    public /* synthetic */ String name;
    public /* synthetic */ ResourceLocation[] resourceLocations;
    
    public RandomMobsProperties(final String llllllllllllllllllIlllllIIlIIllI, final ResourceLocation[] llllllllllllllllllIlllllIIlIIlIl) {
        this.name = null;
        this.basePath = null;
        this.resourceLocations = null;
        this.rules = null;
        final ConnectedParser llllllllllllllllllIlllllIIlIlIII = new ConnectedParser("RandomMobs");
        this.name = llllllllllllllllllIlllllIIlIlIII.parseName(llllllllllllllllllIlllllIIlIIllI);
        this.basePath = llllllllllllllllllIlllllIIlIlIII.parseBasePath(llllllllllllllllllIlllllIIlIIllI);
        this.resourceLocations = llllllllllllllllllIlllllIIlIIlIl;
    }
    
    public RandomMobsProperties(final Properties llllllllllllllllllIlllllIIIlllIl, final String llllllllllllllllllIlllllIIIlllII, final ResourceLocation llllllllllllllllllIlllllIIIllIll) {
        this.name = null;
        this.basePath = null;
        this.resourceLocations = null;
        this.rules = null;
        final ConnectedParser llllllllllllllllllIlllllIIIllIlI = new ConnectedParser("RandomMobs");
        this.name = llllllllllllllllllIlllllIIIllIlI.parseName(llllllllllllllllllIlllllIIIlllII);
        this.basePath = llllllllllllllllllIlllllIIIllIlI.parseBasePath(llllllllllllllllllIlllllIIIlllII);
        this.rules = this.parseRules(llllllllllllllllllIlllllIIIlllIl, llllllllllllllllllIlllllIIIllIll, llllllllllllllllllIlllllIIIllIlI);
    }
    
    public ResourceLocation getTextureLocation(final ResourceLocation llllllllllllllllllIlllllIIIIIlll, final EntityLiving llllllllllllllllllIlllllIIIIIllI) {
        if (this.rules != null) {
            for (int llllllllllllllllllIlllllIIIIllII = 0; llllllllllllllllllIlllllIIIIllII < this.rules.length; ++llllllllllllllllllIlllllIIIIllII) {
                final RandomMobsRule llllllllllllllllllIlllllIIIIlIll = this.rules[llllllllllllllllllIlllllIIIIllII];
                if (llllllllllllllllllIlllllIIIIlIll.matches(llllllllllllllllllIlllllIIIIIllI)) {
                    return llllllllllllllllllIlllllIIIIlIll.getTextureLocation(llllllllllllllllllIlllllIIIIIlll, llllllllllllllllllIlllllIIIIIllI.randomMobsId);
                }
            }
        }
        if (this.resourceLocations != null) {
            final int llllllllllllllllllIlllllIIIIlIlI = llllllllllllllllllIlllllIIIIIllI.randomMobsId;
            final int llllllllllllllllllIlllllIIIIlIIl = llllllllllllllllllIlllllIIIIlIlI % this.resourceLocations.length;
            return this.resourceLocations[llllllllllllllllllIlllllIIIIlIIl];
        }
        return llllllllllllllllllIlllllIIIIIlll;
    }
    
    private RandomMobsRule[] parseRules(final Properties llllllllllllllllllIllllIllllIlII, final ResourceLocation llllllllllllllllllIllllIllllIIll, final ConnectedParser llllllllllllllllllIllllIllllIIlI) {
        final List llllllllllllllllllIllllIllllIIIl = new ArrayList();
        for (int llllllllllllllllllIllllIllllIIII = llllllllllllllllllIllllIllllIlII.size(), llllllllllllllllllIllllIlllIllll = 0; llllllllllllllllllIllllIlllIllll < llllllllllllllllllIllllIllllIIII; ++llllllllllllllllllIllllIlllIllll) {
            final int llllllllllllllllllIllllIlllIlllI = llllllllllllllllllIllllIlllIllll + 1;
            final String llllllllllllllllllIllllIlllIllIl = llllllllllllllllllIllllIllllIlII.getProperty(String.valueOf(new StringBuilder("skins.").append(llllllllllllllllllIllllIlllIlllI)));
            if (llllllllllllllllllIllllIlllIllIl != null) {
                final int[] llllllllllllllllllIllllIlllIllII = llllllllllllllllllIllllIllllIIlI.parseIntList(llllllllllllllllllIllllIlllIllIl);
                final int[] llllllllllllllllllIllllIlllIlIll = llllllllllllllllllIllllIllllIIlI.parseIntList(llllllllllllllllllIllllIllllIlII.getProperty(String.valueOf(new StringBuilder("weights.").append(llllllllllllllllllIllllIlllIlllI))));
                final Biome[] llllllllllllllllllIllllIlllIlIlI = llllllllllllllllllIllllIllllIIlI.parseBiomes(llllllllllllllllllIllllIllllIlII.getProperty(String.valueOf(new StringBuilder("biomes.").append(llllllllllllllllllIllllIlllIlllI))));
                RangeListInt llllllllllllllllllIllllIlllIlIIl = llllllllllllllllllIllllIllllIIlI.parseRangeListInt(llllllllllllllllllIllllIllllIlII.getProperty(String.valueOf(new StringBuilder("heights.").append(llllllllllllllllllIllllIlllIlllI))));
                if (llllllllllllllllllIllllIlllIlIIl == null) {
                    llllllllllllllllllIllllIlllIlIIl = this.parseMinMaxHeight(llllllllllllllllllIllllIllllIlII, llllllllllllllllllIllllIlllIlllI);
                }
                final RandomMobsRule llllllllllllllllllIllllIlllIlIII = new RandomMobsRule(llllllllllllllllllIllllIllllIIll, llllllllllllllllllIllllIlllIllII, llllllllllllllllllIllllIlllIlIll, llllllllllllllllllIllllIlllIlIlI, llllllllllllllllllIllllIlllIlIIl);
                llllllllllllllllllIllllIllllIIIl.add(llllllllllllllllllIllllIlllIlIII);
            }
        }
        final RandomMobsRule[] llllllllllllllllllIllllIlllIIlll = llllllllllllllllllIllllIllllIIIl.toArray(new RandomMobsRule[llllllllllllllllllIllllIllllIIIl.size()]);
        return llllllllllllllllllIllllIlllIIlll;
    }
    
    private RangeListInt parseMinMaxHeight(final Properties llllllllllllllllllIllllIllIlIIII, final int llllllllllllllllllIllllIllIIllll) {
        final String llllllllllllllllllIllllIllIIlllI = llllllllllllllllllIllllIllIlIIII.getProperty(String.valueOf(new StringBuilder("minHeight.").append(llllllllllllllllllIllllIllIIllll)));
        final String llllllllllllllllllIllllIllIIllIl = llllllllllllllllllIllllIllIlIIII.getProperty(String.valueOf(new StringBuilder("maxHeight.").append(llllllllllllllllllIllllIllIIllll)));
        if (llllllllllllllllllIllllIllIIlllI == null && llllllllllllllllllIllllIllIIllIl == null) {
            return null;
        }
        int llllllllllllllllllIllllIllIIllII = 0;
        if (llllllllllllllllllIllllIllIIlllI != null) {
            llllllllllllllllllIllllIllIIllII = Config.parseInt(llllllllllllllllllIllllIllIIlllI, -1);
            if (llllllllllllllllllIllllIllIIllII < 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid minHeight: ").append(llllllllllllllllllIllllIllIIlllI)));
                return null;
            }
        }
        int llllllllllllllllllIllllIllIIlIll = 256;
        if (llllllllllllllllllIllllIllIIllIl != null) {
            llllllllllllllllllIllllIllIIlIll = Config.parseInt(llllllllllllllllllIllllIllIIllIl, -1);
            if (llllllllllllllllllIllllIllIIlIll < 0) {
                Config.warn(String.valueOf(new StringBuilder("Invalid maxHeight: ").append(llllllllllllllllllIllllIllIIllIl)));
                return null;
            }
        }
        if (llllllllllllllllllIllllIllIIlIll < 0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid minHeight, maxHeight: ").append(llllllllllllllllllIllllIllIIlllI).append(", ").append(llllllllllllllllllIllllIllIIllIl)));
            return null;
        }
        final RangeListInt llllllllllllllllllIllllIllIIlIlI = new RangeListInt();
        llllllllllllllllllIllllIllIIlIlI.addRange(new RangeInt(llllllllllllllllllIllllIllIIllII, llllllllllllllllllIllllIllIIlIll));
        return llllllllllllllllllIllllIllIIlIlI;
    }
    
    public boolean isValid(final String llllllllllllllllllIllllIlIllllIl) {
        if (this.resourceLocations == null && this.rules == null) {
            Config.warn(String.valueOf(new StringBuilder("No skins specified: ").append(llllllllllllllllllIllllIlIllllIl)));
            return false;
        }
        if (this.rules != null) {
            for (int llllllllllllllllllIllllIlIllllII = 0; llllllllllllllllllIllllIlIllllII < this.rules.length; ++llllllllllllllllllIllllIlIllllII) {
                final RandomMobsRule llllllllllllllllllIllllIlIlllIll = this.rules[llllllllllllllllllIllllIlIllllII];
                if (!llllllllllllllllllIllllIlIlllIll.isValid(llllllllllllllllllIllllIlIllllIl)) {
                    return false;
                }
            }
        }
        if (this.resourceLocations != null) {
            for (int llllllllllllllllllIllllIlIlllIlI = 0; llllllllllllllllllIllllIlIlllIlI < this.resourceLocations.length; ++llllllllllllllllllIllllIlIlllIlI) {
                final ResourceLocation llllllllllllllllllIllllIlIlllIIl = this.resourceLocations[llllllllllllllllllIllllIlIlllIlI];
                if (!Config.hasResource(llllllllllllllllllIllllIlIlllIIl)) {
                    Config.warn(String.valueOf(new StringBuilder("Texture not found: ").append(llllllllllllllllllIllllIlIlllIIl.getResourcePath())));
                    return false;
                }
            }
        }
        return true;
    }
}
