package net.minecraft.client.renderer.block.model;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;

public class SimpleBakedModel implements IBakedModel
{
    protected final /* synthetic */ ItemCameraTransforms cameraTransforms;
    protected final /* synthetic */ List<BakedQuad> generalQuads;
    protected final /* synthetic */ Map<EnumFacing, List<BakedQuad>> faceQuads;
    protected final /* synthetic */ boolean ambientOcclusion;
    protected final /* synthetic */ TextureAtlasSprite texture;
    protected final /* synthetic */ boolean gui3d;
    protected final /* synthetic */ ItemOverrideList itemOverrideList;
    
    @Override
    public ItemOverrideList getOverrides() {
        return this.itemOverrideList;
    }
    
    @Override
    public boolean isGui3d() {
        return this.gui3d;
    }
    
    @Override
    public List<BakedQuad> getQuads(@Nullable final IBlockState lllllllllllllllllllIllIIlIlIlIII, @Nullable final EnumFacing lllllllllllllllllllIllIIlIlIIlll, final long lllllllllllllllllllIllIIlIlIIllI) {
        return (lllllllllllllllllllIllIIlIlIIlll == null) ? this.generalQuads : this.faceQuads.get(lllllllllllllllllllIllIIlIlIIlll);
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return this.ambientOcclusion;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.texture;
    }
    
    public SimpleBakedModel(final List<BakedQuad> lllllllllllllllllllIllIIlIllIIlI, final Map<EnumFacing, List<BakedQuad>> lllllllllllllllllllIllIIlIlllIIl, final boolean lllllllllllllllllllIllIIlIllIIII, final boolean lllllllllllllllllllIllIIlIlIllll, final TextureAtlasSprite lllllllllllllllllllIllIIlIllIllI, final ItemCameraTransforms lllllllllllllllllllIllIIlIlIllIl, final ItemOverrideList lllllllllllllllllllIllIIlIllIlII) {
        this.generalQuads = lllllllllllllllllllIllIIlIllIIlI;
        this.faceQuads = lllllllllllllllllllIllIIlIlllIIl;
        this.ambientOcclusion = lllllllllllllllllllIllIIlIllIIII;
        this.gui3d = lllllllllllllllllllIllIIlIlIllll;
        this.texture = lllllllllllllllllllIllIIlIllIllI;
        this.cameraTransforms = lllllllllllllllllllIllIIlIlIllIl;
        this.itemOverrideList = lllllllllllllllllllIllIIlIllIlII;
    }
    
    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }
    
    public static class Builder
    {
        private final /* synthetic */ boolean builderGui3d;
        private final /* synthetic */ List<BakedQuad> builderGeneralQuads;
        private final /* synthetic */ ItemOverrideList builderItemOverrideList;
        private final /* synthetic */ Map<EnumFacing, List<BakedQuad>> builderFaceQuads;
        private /* synthetic */ TextureAtlasSprite builderTexture;
        private final /* synthetic */ boolean builderAmbientOcclusion;
        private final /* synthetic */ ItemCameraTransforms builderCameraTransforms;
        
        public Builder(final IBlockState lllllllllllllIllIIllIIIIIllIIlll, final IBakedModel lllllllllllllIllIIllIIIIIllIIllI, final TextureAtlasSprite lllllllllllllIllIIllIIIIIllIIlIl, final BlockPos lllllllllllllIllIIllIIIIIllIIlII) {
            this(lllllllllllllIllIIllIIIIIllIIllI.isAmbientOcclusion(), lllllllllllllIllIIllIIIIIllIIllI.isGui3d(), lllllllllllllIllIIllIIIIIllIIllI.getItemCameraTransforms(), lllllllllllllIllIIllIIIIIllIIllI.getOverrides());
            this.builderTexture = lllllllllllllIllIIllIIIIIllIIllI.getParticleTexture();
            final long lllllllllllllIllIIllIIIIIllIlIlI = MathHelper.getPositionRandom(lllllllllllllIllIIllIIIIIllIIlII);
            final int lllllllllllllIllIIllIIIIIlIlllll;
            final Exception lllllllllllllIllIIllIIIIIllIIIII = (Exception)((EnumFacing[])(Object)(lllllllllllllIllIIllIIIIIlIlllll = (int)(Object)EnumFacing.values())).length;
            for (boolean lllllllllllllIllIIllIIIIIllIIIIl = false; lllllllllllllIllIIllIIIIIllIIIIl < lllllllllllllIllIIllIIIIIllIIIII; ++lllllllllllllIllIIllIIIIIllIIIIl) {
                final EnumFacing lllllllllllllIllIIllIIIIIllIlIIl = lllllllllllllIllIIllIIIIIlIlllll[lllllllllllllIllIIllIIIIIllIIIIl];
                this.addFaceQuads(lllllllllllllIllIIllIIIIIllIIlll, lllllllllllllIllIIllIIIIIllIIllI, lllllllllllllIllIIllIIIIIllIIlIl, lllllllllllllIllIIllIIIIIllIlIIl, lllllllllllllIllIIllIIIIIllIlIlI);
            }
            this.addGeneralQuads(lllllllllllllIllIIllIIIIIllIIlll, lllllllllllllIllIIllIIIIIllIIllI, lllllllllllllIllIIllIIIIIllIIlIl, lllllllllllllIllIIllIIIIIllIlIlI);
        }
        
        private void addFaceQuads(final IBlockState lllllllllllllIllIIllIIIIIIllIllI, final IBakedModel lllllllllllllIllIIllIIIIIIllIlIl, final TextureAtlasSprite lllllllllllllIllIIllIIIIIIllIlII, final EnumFacing lllllllllllllIllIIllIIIIIIllIIll, final long lllllllllllllIllIIllIIIIIIlllIIl) {
            for (final BakedQuad lllllllllllllIllIIllIIIIIIlllIII : lllllllllllllIllIIllIIIIIIllIlIl.getQuads(lllllllllllllIllIIllIIIIIIllIllI, lllllllllllllIllIIllIIIIIIllIIll, lllllllllllllIllIIllIIIIIIlllIIl)) {
                this.addFaceQuad(lllllllllllllIllIIllIIIIIIllIIll, new BakedQuadRetextured(lllllllllllllIllIIllIIIIIIlllIII, lllllllllllllIllIIllIIIIIIllIlII));
            }
        }
        
        public Builder(final ModelBlock lllllllllllllIllIIllIIIIIllllIll, final ItemOverrideList lllllllllllllIllIIllIIIIIlllllIl) {
            this(lllllllllllllIllIIllIIIIIllllIll.isAmbientOcclusion(), lllllllllllllIllIIllIIIIIllllIll.isGui3d(), lllllllllllllIllIIllIIIIIllllIll.getAllTransforms(), lllllllllllllIllIIllIIIIIlllllIl);
        }
        
        public Builder addFaceQuad(final EnumFacing lllllllllllllIllIIllIIIIIIIlIlII, final BakedQuad lllllllllllllIllIIllIIIIIIIlIllI) {
            this.builderFaceQuads.get(lllllllllllllIllIIllIIIIIIIlIlII).add(lllllllllllllIllIIllIIIIIIIlIllI);
            return this;
        }
        
        public Builder setTexture(final TextureAtlasSprite lllllllllllllIllIIllIIIIIIIIlIIl) {
            this.builderTexture = lllllllllllllIllIIllIIIIIIIIlIIl;
            return this;
        }
        
        private void addGeneralQuads(final IBlockState lllllllllllllIllIIllIIIIIIlIIIIl, final IBakedModel lllllllllllllIllIIllIIIIIIlIIllI, final TextureAtlasSprite lllllllllllllIllIIllIIIIIIlIIlIl, final long lllllllllllllIllIIllIIIIIIlIIlII) {
            for (final BakedQuad lllllllllllllIllIIllIIIIIIlIIIll : lllllllllllllIllIIllIIIIIIlIIllI.getQuads(lllllllllllllIllIIllIIIIIIlIIIIl, null, lllllllllllllIllIIllIIIIIIlIIlII)) {
                this.addGeneralQuad(new BakedQuadRetextured(lllllllllllllIllIIllIIIIIIlIIIll, lllllllllllllIllIIllIIIIIIlIIlIl));
            }
        }
        
        private Builder(final boolean lllllllllllllIllIIllIIIIIlIlIlII, final boolean lllllllllllllIllIIllIIIIIlIlIIll, final ItemCameraTransforms lllllllllllllIllIIllIIIIIlIIllII, final ItemOverrideList lllllllllllllIllIIllIIIIIlIIlIll) {
            this.builderGeneralQuads = (List<BakedQuad>)Lists.newArrayList();
            this.builderFaceQuads = (Map<EnumFacing, List<BakedQuad>>)Maps.newEnumMap((Class)EnumFacing.class);
            final float lllllllllllllIllIIllIIIIIlIIIlll;
            final byte lllllllllllllIllIIllIIIIIlIIlIII = (byte)((EnumFacing[])(Object)(lllllllllllllIllIIllIIIIIlIIIlll = (float)(Object)EnumFacing.values())).length;
            for (String lllllllllllllIllIIllIIIIIlIIlIIl = (String)0; lllllllllllllIllIIllIIIIIlIIlIIl < lllllllllllllIllIIllIIIIIlIIlIII; ++lllllllllllllIllIIllIIIIIlIIlIIl) {
                final EnumFacing lllllllllllllIllIIllIIIIIlIlIIII = lllllllllllllIllIIllIIIIIlIIIlll[lllllllllllllIllIIllIIIIIlIIlIIl];
                this.builderFaceQuads.put(lllllllllllllIllIIllIIIIIlIlIIII, Lists.newArrayList());
            }
            this.builderItemOverrideList = lllllllllllllIllIIllIIIIIlIIlIll;
            this.builderAmbientOcclusion = lllllllllllllIllIIllIIIIIlIlIlII;
            this.builderGui3d = lllllllllllllIllIIllIIIIIlIlIIll;
            this.builderCameraTransforms = lllllllllllllIllIIllIIIIIlIIllII;
        }
        
        public Builder addGeneralQuad(final BakedQuad lllllllllllllIllIIllIIIIIIIIllIl) {
            this.builderGeneralQuads.add(lllllllllllllIllIIllIIIIIIIIllIl);
            return this;
        }
        
        public IBakedModel makeBakedModel() {
            if (this.builderTexture == null) {
                throw new RuntimeException("Missing particle!");
            }
            return new SimpleBakedModel(this.builderGeneralQuads, this.builderFaceQuads, this.builderAmbientOcclusion, this.builderGui3d, this.builderTexture, this.builderCameraTransforms, this.builderItemOverrideList);
        }
    }
}
