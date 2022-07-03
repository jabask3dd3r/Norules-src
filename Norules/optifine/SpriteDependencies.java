package optifine;

import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;

public class SpriteDependencies
{
    public static TextureAtlasSprite resolveDependencies(final List<TextureAtlasSprite> lllllllllllllIlIIllllIlllIllIIII, final int lllllllllllllIlIIllllIlllIlIllll, final TextureMap lllllllllllllIlIIllllIlllIllIIlI) {
        TextureAtlasSprite lllllllllllllIlIIllllIlllIllIIIl;
        for (lllllllllllllIlIIllllIlllIllIIIl = lllllllllllllIlIIllllIlllIllIIII.get(lllllllllllllIlIIllllIlllIlIllll); resolveOne(lllllllllllllIlIIllllIlllIllIIII, lllllllllllllIlIIllllIlllIlIllll, lllllllllllllIlIIllllIlllIllIIIl, lllllllllllllIlIIllllIlllIllIIlI); lllllllllllllIlIIllllIlllIllIIIl = lllllllllllllIlIIllllIlllIllIIII.get(lllllllllllllIlIIllllIlllIlIllll)) {}
        lllllllllllllIlIIllllIlllIllIIIl.isDependencyParent = false;
        return lllllllllllllIlIIllllIlllIllIIIl;
    }
    
    private static boolean resolveOne(final List<TextureAtlasSprite> lllllllllllllIlIIllllIlllIlIIIIl, final int lllllllllllllIlIIllllIlllIlIIIII, final TextureAtlasSprite lllllllllllllIlIIllllIlllIIlllll, final TextureMap lllllllllllllIlIIllllIlllIIlIlII) {
        int lllllllllllllIlIIllllIlllIIlllIl = 0;
        for (final ResourceLocation lllllllllllllIlIIllllIlllIIlllII : lllllllllllllIlIIllllIlllIIlllll.getDependencies()) {
            Config.dbg(String.valueOf(new StringBuilder("Sprite dependency: ").append(lllllllllllllIlIIllllIlllIIlllll.getIconName()).append(" <- ").append(lllllllllllllIlIIllllIlllIIlllII)));
            TextureAtlasSprite lllllllllllllIlIIllllIlllIIllIll = lllllllllllllIlIIllllIlllIIlIlII.getRegisteredSprite(lllllllllllllIlIIllllIlllIIlllII);
            if (lllllllllllllIlIIllllIlllIIllIll == null) {
                lllllllllllllIlIIllllIlllIIllIll = lllllllllllllIlIIllllIlllIIlIlII.registerSprite(lllllllllllllIlIIllllIlllIIlllII);
            }
            else {
                final int lllllllllllllIlIIllllIlllIIllIlI = lllllllllllllIlIIllllIlllIlIIIIl.indexOf(lllllllllllllIlIIllllIlllIIllIll);
                if (lllllllllllllIlIIllllIlllIIllIlI <= lllllllllllllIlIIllllIlllIlIIIII + lllllllllllllIlIIllllIlllIIlllIl) {
                    continue;
                }
                if (lllllllllllllIlIIllllIlllIIllIll.isDependencyParent) {
                    final String lllllllllllllIlIIllllIlllIIllIIl = String.valueOf(new StringBuilder("circular dependency: ").append(lllllllllllllIlIIllllIlllIIlllll.getIconName()).append(" -> ").append(lllllllllllllIlIIllllIlllIIllIll.getIconName()));
                    final ResourceLocation lllllllllllllIlIIllllIlllIIllIII = lllllllllllllIlIIllllIlllIIlIlII.getResourceLocation(lllllllllllllIlIIllllIlllIIlllll);
                    ReflectorForge.FMLClientHandler_trackBrokenTexture(lllllllllllllIlIIllllIlllIIllIII, lllllllllllllIlIIllllIlllIIllIIl);
                    break;
                }
                lllllllllllllIlIIllllIlllIlIIIIl.remove(lllllllllllllIlIIllllIlllIIllIlI);
            }
            lllllllllllllIlIIllllIlllIIlllll.isDependencyParent = true;
            lllllllllllllIlIIllllIlllIlIIIIl.add(lllllllllllllIlIIllllIlllIlIIIII + lllllllllllllIlIIllllIlllIIlllIl, lllllllllllllIlIIllllIlllIIllIll);
            ++lllllllllllllIlIIllllIlllIIlllIl;
        }
        return lllllllllllllIlIIllllIlllIIlllIl > 0;
    }
}
