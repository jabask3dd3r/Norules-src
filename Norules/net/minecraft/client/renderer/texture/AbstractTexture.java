package net.minecraft.client.renderer.texture;

import shadersmod.client.*;
import net.minecraft.client.renderer.*;

public abstract class AbstractTexture implements ITextureObject
{
    protected /* synthetic */ boolean mipmap;
    protected /* synthetic */ boolean blurLast;
    protected /* synthetic */ boolean blur;
    protected /* synthetic */ int glTextureId;
    protected /* synthetic */ boolean mipmapLast;
    
    @Override
    public int getGlTextureId() {
        if (this.glTextureId == -1) {
            this.glTextureId = TextureUtil.glGenTextures();
        }
        return this.glTextureId;
    }
    
    public AbstractTexture() {
        this.glTextureId = -1;
    }
    
    @Override
    public MultiTexID getMultiTexID() {
        return ShadersTex.getMultiTexID(this);
    }
    
    public void deleteGlTexture() {
        ShadersTex.deleteTextures(this, this.glTextureId);
        if (this.glTextureId != -1) {
            TextureUtil.deleteTexture(this.glTextureId);
            this.glTextureId = -1;
        }
    }
    
    @Override
    public void restoreLastBlurMipmap() {
        this.setBlurMipmapDirect(this.blurLast, this.mipmapLast);
    }
    
    @Override
    public void setBlurMipmap(final boolean lllllllllllllIIIIIlIlIlIlllIIlII, final boolean lllllllllllllIIIIIlIlIlIlllIIllI) {
        this.blurLast = this.blur;
        this.mipmapLast = this.mipmap;
        this.setBlurMipmapDirect(lllllllllllllIIIIIlIlIlIlllIIlII, lllllllllllllIIIIIlIlIlIlllIIllI);
    }
    
    public void setBlurMipmapDirect(final boolean lllllllllllllIIIIIlIlIlIllllIllI, final boolean lllllllllllllIIIIIlIlIlIlllIlllI) {
        this.blur = lllllllllllllIIIIIlIlIlIllllIllI;
        this.mipmap = lllllllllllllIIIIIlIlIlIlllIlllI;
        int lllllllllllllIIIIIlIlIlIllllIIll = 0;
        int lllllllllllllIIIIIlIlIlIllllIIIl = 0;
        if (lllllllllllllIIIIIlIlIlIllllIllI) {
            final int lllllllllllllIIIIIlIlIlIllllIlII = lllllllllllllIIIIIlIlIlIlllIlllI ? 9987 : 9729;
            final int lllllllllllllIIIIIlIlIlIllllIIlI = 9729;
        }
        else {
            lllllllllllllIIIIIlIlIlIllllIIll = (lllllllllllllIIIIIlIlIlIlllIlllI ? 9986 : 9728);
            lllllllllllllIIIIIlIlIlIllllIIIl = 9728;
        }
        GlStateManager.bindTexture(this.getGlTextureId());
        GlStateManager.glTexParameteri(3553, 10241, lllllllllllllIIIIIlIlIlIllllIIll);
        GlStateManager.glTexParameteri(3553, 10240, lllllllllllllIIIIIlIlIlIllllIIIl);
    }
}
