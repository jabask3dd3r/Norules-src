package net.minecraft.client.renderer.block.model;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.texture.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.common.collect.*;

public class MultipartBakedModel implements IBakedModel
{
    private final /* synthetic */ Map<Predicate<IBlockState>, IBakedModel> selectors;
    protected final /* synthetic */ TextureAtlasSprite particleTexture;
    protected final /* synthetic */ ItemOverrideList overrides;
    protected final /* synthetic */ ItemCameraTransforms cameraTransforms;
    protected final /* synthetic */ boolean gui3D;
    protected final /* synthetic */ boolean ambientOcclusion;
    
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.overrides;
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }
    
    public MultipartBakedModel(final Map<Predicate<IBlockState>, IBakedModel> lllllllllllllIllIlIIlIlIIlIIlIIl) {
        this.selectors = lllllllllllllIllIlIIlIlIIlIIlIIl;
        final IBakedModel lllllllllllllIllIlIIlIlIIlIIlIll = lllllllllllllIllIlIIlIlIIlIIlIIl.values().iterator().next();
        this.ambientOcclusion = lllllllllllllIllIlIIlIlIIlIIlIll.isAmbientOcclusion();
        this.gui3D = lllllllllllllIllIlIIlIlIIlIIlIll.isGui3d();
        this.particleTexture = lllllllllllllIllIlIIlIlIIlIIlIll.getParticleTexture();
        this.cameraTransforms = lllllllllllllIllIlIIlIlIIlIIlIll.getItemCameraTransforms();
        this.overrides = lllllllllllllIllIlIIlIlIIlIIlIll.getOverrides();
    }
    
    @Override
    public boolean isGui3d() {
        return this.gui3D;
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return this.ambientOcclusion;
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState lllllllllllllIllIlIIlIlIIIllllll, @Nullable final EnumFacing lllllllllllllIllIlIIlIlIIIlllIII, long lllllllllllllIllIlIIlIlIIIllIlll) {
        final List<BakedQuad> lllllllllllllIllIlIIlIlIIIllllII = (List<BakedQuad>)Lists.newArrayList();
        if (lllllllllllllIllIlIIlIlIIIllllll != null) {
            for (final Map.Entry<Predicate<IBlockState>, IBakedModel> lllllllllllllIllIlIIlIlIIIlllIll : this.selectors.entrySet()) {
                if (lllllllllllllIllIlIIlIlIIIlllIll.getKey().apply((Object)lllllllllllllIllIlIIlIlIIIllllll)) {
                    lllllllllllllIllIlIIlIlIIIllllII.addAll(lllllllllllllIllIlIIlIlIIIlllIll.getValue().getQuads(lllllllllllllIllIlIIlIlIIIllllll, lllllllllllllIllIlIIlIlIIIlllIII, lllllllllllllIllIlIIlIlIIIllIlll++));
                }
            }
        }
        return lllllllllllllIllIlIIlIlIIIllllII;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.particleTexture;
    }
    
    public static class Builder
    {
        private final /* synthetic */ Map<Predicate<IBlockState>, IBakedModel> builderSelectors;
        
        public Builder() {
            this.builderSelectors = (Map<Predicate<IBlockState>, IBakedModel>)Maps.newLinkedHashMap();
        }
        
        public IBakedModel makeMultipartModel() {
            return new MultipartBakedModel(this.builderSelectors);
        }
        
        public void putModel(final Predicate<IBlockState> llllllllllllllIIIIlIllllIllIllll, final IBakedModel llllllllllllllIIIIlIllllIllIlllI) {
            this.builderSelectors.put(llllllllllllllIIIIlIllllIllIllll, llllllllllllllIIIIlIllllIllIlllI);
        }
    }
}
