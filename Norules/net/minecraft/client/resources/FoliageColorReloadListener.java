package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import java.io.*;

public class FoliageColorReloadListener implements IResourceManagerReloadListener
{
    private static final /* synthetic */ ResourceLocation LOC_FOLIAGE_PNG;
    
    static {
        LOC_FOLIAGE_PNG = new ResourceLocation("textures/colormap/foliage.png");
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllIIlllIIIlIIlllIIIl) {
        try {
            ColorizerFoliage.setFoliageBiomeColorizer(TextureUtil.readImageData(llllllllllllllIIlllIIIlIIlllIIIl, FoliageColorReloadListener.LOC_FOLIAGE_PNG));
        }
        catch (IOException ex) {}
    }
}
