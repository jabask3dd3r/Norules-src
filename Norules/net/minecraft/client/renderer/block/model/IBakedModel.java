package net.minecraft.client.renderer.block.model;

import net.minecraft.block.state.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;

public interface IBakedModel
{
    ItemOverrideList getOverrides();
    
    List<BakedQuad> getQuads(final IBlockState p0, final EnumFacing p1, final long p2);
    
    boolean isBuiltInRenderer();
    
    boolean isAmbientOcclusion();
    
    ItemCameraTransforms getItemCameraTransforms();
    
    boolean isGui3d();
    
    TextureAtlasSprite getParticleTexture();
}
