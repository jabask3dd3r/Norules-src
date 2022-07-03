package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;

public class BuiltInModel implements IBakedModel
{
    private final /* synthetic */ ItemOverrideList overrideList;
    private final /* synthetic */ ItemCameraTransforms cameraTransforms;
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.overrideList;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return null;
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }
    
    @Override
    public boolean isGui3d() {
        return true;
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState lllllllllllllllIIIIIlIlIIlIIIlII, @Nullable final EnumFacing lllllllllllllllIIIIIlIlIIlIIIIll, final long lllllllllllllllIIIIIlIlIIlIIIIlI) {
        return Collections.emptyList();
    }
    
    public BuiltInModel(final ItemCameraTransforms lllllllllllllllIIIIIlIlIIlIIIlll, final ItemOverrideList lllllllllllllllIIIIIlIlIIlIIlIIl) {
        this.cameraTransforms = lllllllllllllllIIIIIlIlIIlIIIlll;
        this.overrideList = lllllllllllllllIIIIIlIlIIlIIlIIl;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return true;
    }
}
