package net.minecraft.util;

import com.google.common.collect.*;
import java.util.*;

public enum SoundCategory
{
    HOSTILE("HOSTILE", 5, "hostile"), 
    PLAYERS("PLAYERS", 7, "player");
    
    private final /* synthetic */ String name;
    
    WEATHER("WEATHER", 3, "weather");
    
    private static final /* synthetic */ Map<String, SoundCategory> SOUND_CATEGORIES;
    
    NEUTRAL("NEUTRAL", 6, "neutral"), 
    AMBIENT("AMBIENT", 8, "ambient"), 
    MASTER("MASTER", 0, "master"), 
    RECORDS("RECORDS", 2, "record"), 
    MUSIC("MUSIC", 1, "music"), 
    BLOCKS("BLOCKS", 4, "block"), 
    VOICE("VOICE", 9, "voice");
    
    static {
        SOUND_CATEGORIES = Maps.newHashMap();
        final double lllllllllllllIIIIlIIIllIlIIlllII;
        final float lllllllllllllIIIIlIIIllIlIIlllIl = ((SoundCategory[])(Object)(lllllllllllllIIIIlIIIllIlIIlllII = (double)(Object)values())).length;
        for (byte lllllllllllllIIIIlIIIllIlIIllllI = 0; lllllllllllllIIIIlIIIllIlIIllllI < lllllllllllllIIIIlIIIllIlIIlllIl; ++lllllllllllllIIIIlIIIllIlIIllllI) {
            final SoundCategory lllllllllllllIIIIlIIIllIlIlIIIII = lllllllllllllIIIIlIIIllIlIIlllII[lllllllllllllIIIIlIIIllIlIIllllI];
            if (SoundCategory.SOUND_CATEGORIES.containsKey(lllllllllllllIIIIlIIIllIlIlIIIII.getName())) {
                throw new Error(String.valueOf(new StringBuilder("Clash in Sound Category name pools! Cannot insert ").append(lllllllllllllIIIIlIIIllIlIlIIIII)));
            }
            SoundCategory.SOUND_CATEGORIES.put(lllllllllllllIIIIlIIIllIlIlIIIII.getName(), lllllllllllllIIIIlIIIllIlIlIIIII);
        }
    }
    
    public static SoundCategory getByName(final String lllllllllllllIIIIlIIIllIlIIIllIl) {
        return SoundCategory.SOUND_CATEGORIES.get(lllllllllllllIIIIlIIIllIlIIIllIl);
    }
    
    public String getName() {
        return this.name;
    }
    
    public static Set<String> getSoundCategoryNames() {
        return SoundCategory.SOUND_CATEGORIES.keySet();
    }
    
    private SoundCategory(final String lllllllllllllIIIIlIIIllIlIIlIlII, final int lllllllllllllIIIIlIIIllIlIIlIIll, final String lllllllllllllIIIIlIIIllIlIIlIIlI) {
        this.name = lllllllllllllIIIIlIIIllIlIIlIIlI;
    }
}
