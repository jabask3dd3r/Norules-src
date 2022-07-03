package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;

public class RenderHorse extends RenderLiving<EntityHorse>
{
    private static final /* synthetic */ Map<String, ResourceLocation> LAYERED_LOCATION_CACHE;
    
    static {
        LAYERED_LOCATION_CACHE = Maps.newHashMap();
    }
    
    public RenderHorse(final RenderManager lllllllllllllllIlIIllIlIIllIIIII) {
        super(lllllllllllllllIlIIllIlIIllIIIII, new ModelHorse(), 0.75f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityHorse lllllllllllllllIlIIllIlIIlIlIllI) {
        final String lllllllllllllllIlIIllIlIIlIllIII = lllllllllllllllIlIIllIlIIlIlIllI.getHorseTexture();
        ResourceLocation lllllllllllllllIlIIllIlIIlIlIlll = RenderHorse.LAYERED_LOCATION_CACHE.get(lllllllllllllllIlIIllIlIIlIllIII);
        if (lllllllllllllllIlIIllIlIIlIlIlll == null) {
            lllllllllllllllIlIIllIlIIlIlIlll = new ResourceLocation(lllllllllllllllIlIIllIlIIlIllIII);
            Minecraft.getMinecraft().getTextureManager().loadTexture(lllllllllllllllIlIIllIlIIlIlIlll, new LayeredTexture(lllllllllllllllIlIIllIlIIlIlIllI.getVariantTexturePaths()));
            RenderHorse.LAYERED_LOCATION_CACHE.put(lllllllllllllllIlIIllIlIIlIllIII, lllllllllllllllIlIIllIlIIlIlIlll);
        }
        return lllllllllllllllIlIIllIlIIlIlIlll;
    }
}
