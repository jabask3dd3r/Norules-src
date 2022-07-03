package optifine;

import net.minecraft.world.biome.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.texture.*;

public class Matches
{
    public static boolean biome(final Biome llllllllllllllIIllIIIIIllIIlIIll, final Biome[] llllllllllllllIIllIIIIIllIIIllll) {
        if (llllllllllllllIIllIIIIIllIIIllll == null) {
            return true;
        }
        for (int llllllllllllllIIllIIIIIllIIlIIIl = 0; llllllllllllllIIllIIIIIllIIlIIIl < llllllllllllllIIllIIIIIllIIIllll.length; ++llllllllllllllIIllIIIIIllIIlIIIl) {
            if (llllllllllllllIIllIIIIIllIIIllll[llllllllllllllIIllIIIIIllIIlIIIl] == llllllllllllllIIllIIIIIllIIlIIll) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean metadata(final int llllllllllllllIIllIIIIIllIlIIIlI, final int[] llllllllllllllIIllIIIIIllIlIIlII) {
        if (llllllllllllllIIllIIIIIllIlIIlII == null) {
            return true;
        }
        for (int llllllllllllllIIllIIIIIllIlIIIll = 0; llllllllllllllIIllIIIIIllIlIIIll < llllllllllllllIIllIIIIIllIlIIlII.length; ++llllllllllllllIIllIIIIIllIlIIIll) {
            if (llllllllllllllIIllIIIIIllIlIIlII[llllllllllllllIIllIIIIIllIlIIIll] == llllllllllllllIIllIIIIIllIlIIIlI) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean block(final BlockStateBase llllllllllllllIIllIIIIIlllIIIlll, final MatchBlock[] llllllllllllllIIllIIIIIlllIIlIlI) {
        if (llllllllllllllIIllIIIIIlllIIlIlI == null) {
            return true;
        }
        for (int llllllllllllllIIllIIIIIlllIIlIIl = 0; llllllllllllllIIllIIIIIlllIIlIIl < llllllllllllllIIllIIIIIlllIIlIlI.length; ++llllllllllllllIIllIIIIIlllIIlIIl) {
            final MatchBlock llllllllllllllIIllIIIIIlllIIlIII = llllllllllllllIIllIIIIIlllIIlIlI[llllllllllllllIIllIIIIIlllIIlIIl];
            if (llllllllllllllIIllIIIIIlllIIlIII.matches(llllllllllllllIIllIIIIIlllIIIlll)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean block(final int llllllllllllllIIllIIIIIllIlllllI, final int llllllllllllllIIllIIIIIllIlllIII, final MatchBlock[] llllllllllllllIIllIIIIIllIllIlll) {
        if (llllllllllllllIIllIIIIIllIllIlll == null) {
            return true;
        }
        for (int llllllllllllllIIllIIIIIllIlllIll = 0; llllllllllllllIIllIIIIIllIlllIll < llllllllllllllIIllIIIIIllIllIlll.length; ++llllllllllllllIIllIIIIIllIlllIll) {
            final MatchBlock llllllllllllllIIllIIIIIllIlllIlI = llllllllllllllIIllIIIIIllIllIlll[llllllllllllllIIllIIIIIllIlllIll];
            if (llllllllllllllIIllIIIIIllIlllIlI.matches(llllllllllllllIIllIIIIIllIlllllI, llllllllllllllIIllIIIIIllIlllIII)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean blockId(final int llllllllllllllIIllIIIIIllIllIIII, final MatchBlock[] llllllllllllllIIllIIIIIllIlIllll) {
        if (llllllllllllllIIllIIIIIllIlIllll == null) {
            return true;
        }
        for (int llllllllllllllIIllIIIIIllIlIlllI = 0; llllllllllllllIIllIIIIIllIlIlllI < llllllllllllllIIllIIIIIllIlIllll.length; ++llllllllllllllIIllIIIIIllIlIlllI) {
            final MatchBlock llllllllllllllIIllIIIIIllIlIllIl = llllllllllllllIIllIIIIIllIlIllll[llllllllllllllIIllIIIIIllIlIlllI];
            if (llllllllllllllIIllIIIIIllIlIllIl.getBlockId() == llllllllllllllIIllIIIIIllIllIIII) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean sprite(final TextureAtlasSprite llllllllllllllIIllIIIIIllIIllIIl, final TextureAtlasSprite[] llllllllllllllIIllIIIIIllIIllIII) {
        if (llllllllllllllIIllIIIIIllIIllIII == null) {
            return true;
        }
        for (int llllllllllllllIIllIIIIIllIIllIlI = 0; llllllllllllllIIllIIIIIllIIllIlI < llllllllllllllIIllIIIIIllIIllIII.length; ++llllllllllllllIIllIIIIIllIIllIlI) {
            if (llllllllllllllIIllIIIIIllIIllIII[llllllllllllllIIllIIIIIllIIllIlI] == llllllllllllllIIllIIIIIllIIllIIl) {
                return true;
            }
        }
        return false;
    }
}
