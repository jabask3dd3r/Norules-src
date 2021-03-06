package net.minecraft.client.resources;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import java.io.*;

public class GrassColorReloadListener implements IResourceManagerReloadListener
{
    private static final /* synthetic */ ResourceLocation LOC_GRASS_PNG;
    
    static {
        LOC_GRASS_PNG = new ResourceLocation("textures/colormap/grass.png");
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllllIIIllIllllIIllIIlI) {
        try {
            ColorizerGrass.setGrassBiomeColorizer(TextureUtil.readImageData(llllllllllllllIIIllIllllIIllIIlI, GrassColorReloadListener.LOC_GRASS_PNG));
        }
        catch (IOException ex) {}
    }
}
