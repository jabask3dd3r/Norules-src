package net.minecraft.client.renderer.block.model;

import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.collect.*;
import java.util.*;

public class WeightedBakedModel implements IBakedModel
{
    private final /* synthetic */ IBakedModel baseModel;
    private final /* synthetic */ int totalWeight;
    private final /* synthetic */ List<WeightedModel> models;
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState llllllllllllllllIIllIIIIIIlllIll, @Nullable final EnumFacing llllllllllllllllIIllIIIIIIlllllI, final long llllllllllllllllIIllIIIIIIlllIIl) {
        return this.getRandomModel(llllllllllllllllIIllIIIIIIlllIIl).getQuads(llllllllllllllllIIllIIIIIIlllIll, llllllllllllllllIIllIIIIIIlllllI, llllllllllllllllIIllIIIIIIlllIIl);
    }
    
    private IBakedModel getRandomModel(final long llllllllllllllllIIllIIIIIlIIIlll) {
        return WeightedRandom.getRandomItem(this.models, Math.abs((int)llllllllllllllllIIllIIIIIlIIIlll >> 16) % this.totalWeight).model;
    }
    
    public WeightedBakedModel(final List<WeightedModel> llllllllllllllllIIllIIIIIlIIllIl) {
        this.models = llllllllllllllllIIllIIIIIlIIllIl;
        this.totalWeight = WeightedRandom.getTotalWeight(llllllllllllllllIIllIIIIIlIIllIl);
        this.baseModel = llllllllllllllllIIllIIIIIlIIllIl.get(0).model;
    }
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.baseModel.getOverrides();
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.baseModel.getParticleTexture();
    }
    
    @Override
    public boolean isGui3d() {
        return this.baseModel.isGui3d();
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return this.baseModel.isBuiltInRenderer();
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return this.baseModel.isAmbientOcclusion();
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.baseModel.getItemCameraTransforms();
    }
    
    static class WeightedModel extends WeightedRandom.Item implements Comparable<WeightedModel>
    {
        protected final /* synthetic */ IBakedModel model;
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder("MyWeighedRandomItem{weight=").append(this.itemWeight).append(", model=").append(this.model).append('}'));
        }
        
        @Override
        public int compareTo(final WeightedModel lllllllllllllIlIIIIIIIllIIIlllll) {
            return ComparisonChain.start().compare(lllllllllllllIlIIIIIIIllIIIlllll.itemWeight, this.itemWeight).result();
        }
        
        public WeightedModel(final IBakedModel lllllllllllllIlIIIIIIIllIIlIIllI, final int lllllllllllllIlIIIIIIIllIIlIIlIl) {
            super(lllllllllllllIlIIIIIIIllIIlIIlIl);
            this.model = lllllllllllllIlIIIIIIIllIIlIIllI;
        }
    }
    
    public static class Builder
    {
        private final /* synthetic */ List<WeightedModel> listItems;
        
        public IBakedModel first() {
            return this.listItems.get(0).model;
        }
        
        public Builder add(final IBakedModel lllllllllllllIlIlIIllIlIIlIIlIll, final int lllllllllllllIlIlIIllIlIIlIIllIl) {
            this.listItems.add(new WeightedModel(lllllllllllllIlIlIIllIlIIlIIlIll, lllllllllllllIlIlIIllIlIIlIIllIl));
            return this;
        }
        
        public Builder() {
            this.listItems = (List<WeightedModel>)Lists.newArrayList();
        }
        
        public WeightedBakedModel build() {
            Collections.sort(this.listItems);
            return new WeightedBakedModel(this.listItems);
        }
    }
}
