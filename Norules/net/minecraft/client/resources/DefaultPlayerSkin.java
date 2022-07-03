package net.minecraft.client.resources;

import net.minecraft.util.*;
import java.util.*;

public class DefaultPlayerSkin
{
    private static final /* synthetic */ ResourceLocation TEXTURE_STEVE;
    private static final /* synthetic */ ResourceLocation TEXTURE_ALEX;
    
    public static ResourceLocation getDefaultSkinLegacy() {
        return DefaultPlayerSkin.TEXTURE_STEVE;
    }
    
    static {
        TEXTURE_STEVE = new ResourceLocation("textures/entity/steve.png");
        TEXTURE_ALEX = new ResourceLocation("textures/entity/alex.png");
    }
    
    public static ResourceLocation getDefaultSkin(final UUID lllllllllllllllllllIlIIIlIIllIll) {
        return isSlimSkin(lllllllllllllllllllIlIIIlIIllIll) ? DefaultPlayerSkin.TEXTURE_ALEX : DefaultPlayerSkin.TEXTURE_STEVE;
    }
    
    public static String getSkinType(final UUID lllllllllllllllllllIlIIIlIIllIIl) {
        return isSlimSkin(lllllllllllllllllllIlIIIlIIllIIl) ? "slim" : "default";
    }
    
    private static boolean isSlimSkin(final UUID lllllllllllllllllllIlIIIlIIlIlIl) {
        return (lllllllllllllllllllIlIIIlIIlIlIl.hashCode() & 0x1) == 0x1;
    }
}
