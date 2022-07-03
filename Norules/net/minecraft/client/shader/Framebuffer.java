package net.minecraft.client.shader;

import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import java.nio.*;

public class Framebuffer
{
    public /* synthetic */ int depthBuffer;
    public /* synthetic */ int framebufferObject;
    public /* synthetic */ int framebufferFilter;
    public /* synthetic */ int framebufferTextureHeight;
    public /* synthetic */ int framebufferHeight;
    public /* synthetic */ float[] framebufferColor;
    public /* synthetic */ boolean useDepth;
    public /* synthetic */ int framebufferTexture;
    public /* synthetic */ int framebufferWidth;
    public /* synthetic */ int framebufferTextureWidth;
    
    public void unbindFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        }
    }
    
    public Framebuffer(final int lIlIllIIlIlI, final int lIlIllIIIlIl, final boolean lIlIllIIlIII) {
        this.useDepth = lIlIllIIlIII;
        this.framebufferObject = -1;
        this.framebufferTexture = -1;
        this.depthBuffer = -1;
        this.framebufferColor = new float[4];
        this.framebufferColor[0] = 1.0f;
        this.framebufferColor[1] = 1.0f;
        this.framebufferColor[2] = 1.0f;
        this.framebufferColor[3] = 0.0f;
        this.createBindFramebuffer(lIlIllIIlIlI, lIlIllIIIlIl);
    }
    
    public void framebufferRenderExt(final int lIlIIlllIllI, final int lIlIIllIlIll, final boolean lIlIIllIlIlI) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.colorMask(true, true, true, false);
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, lIlIIlllIllI, lIlIIllIlIll, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GlStateManager.viewport(0, 0, lIlIIlllIllI, lIlIIllIlIll);
            GlStateManager.enableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableAlpha();
            if (lIlIIllIlIlI) {
                GlStateManager.disableBlend();
                GlStateManager.enableColorMaterial();
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindFramebufferTexture();
            final float lIlIIlllIIll = (float)lIlIIlllIllI;
            final float lIlIIlllIIlI = (float)lIlIIllIlIll;
            final float lIlIIlllIIIl = this.framebufferWidth / (float)this.framebufferTextureWidth;
            final float lIlIIlllIIII = this.framebufferHeight / (float)this.framebufferTextureHeight;
            final Tessellator lIlIIllIllll = Tessellator.getInstance();
            final BufferBuilder lIlIIllIlllI = lIlIIllIllll.getBuffer();
            lIlIIllIlllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            lIlIIllIlllI.pos(0.0, lIlIIlllIIlI, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
            lIlIIllIlllI.pos(lIlIIlllIIll, lIlIIlllIIlI, 0.0).tex(lIlIIlllIIIl, 0.0).color(255, 255, 255, 255).endVertex();
            lIlIIllIlllI.pos(lIlIIlllIIll, 0.0, 0.0).tex(lIlIIlllIIIl, lIlIIlllIIII).color(255, 255, 255, 255).endVertex();
            lIlIIllIlllI.pos(0.0, 0.0, 0.0).tex(0.0, lIlIIlllIIII).color(255, 255, 255, 255).endVertex();
            lIlIIllIllll.draw();
            this.unbindFramebufferTexture();
            GlStateManager.depthMask(true);
            GlStateManager.colorMask(true, true, true, true);
        }
    }
    
    public void framebufferRender(final int lIlIlIIIIllI, final int lIlIlIIIIlIl) {
        this.framebufferRenderExt(lIlIlIIIIllI, lIlIlIIIIlIl, true);
    }
    
    public void createFramebuffer(final int lIlIlIllIIII, final int lIlIlIlIllll) {
        this.framebufferWidth = lIlIlIllIIII;
        this.framebufferHeight = lIlIlIlIllll;
        this.framebufferTextureWidth = lIlIlIllIIII;
        this.framebufferTextureHeight = lIlIlIlIllll;
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferClear();
        }
        else {
            this.framebufferObject = OpenGlHelper.glGenFramebuffers();
            this.framebufferTexture = TextureUtil.glGenTextures();
            if (this.useDepth) {
                this.depthBuffer = OpenGlHelper.glGenRenderbuffers();
            }
            this.setFramebufferFilter(9728);
            GlStateManager.bindTexture(this.framebufferTexture);
            GlStateManager.glTexImage2D(3553, 0, 32856, this.framebufferTextureWidth, this.framebufferTextureHeight, 0, 6408, 5121, null);
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, this.framebufferObject);
            OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, this.framebufferTexture, 0);
            if (this.useDepth) {
                OpenGlHelper.glBindRenderbuffer(OpenGlHelper.GL_RENDERBUFFER, this.depthBuffer);
                OpenGlHelper.glRenderbufferStorage(OpenGlHelper.GL_RENDERBUFFER, 33190, this.framebufferTextureWidth, this.framebufferTextureHeight);
                OpenGlHelper.glFramebufferRenderbuffer(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_DEPTH_ATTACHMENT, OpenGlHelper.GL_RENDERBUFFER, this.depthBuffer);
            }
            this.framebufferClear();
            this.unbindFramebufferTexture();
        }
    }
    
    public void bindFramebufferTexture() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(this.framebufferTexture);
        }
    }
    
    public void unbindFramebufferTexture() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(0);
        }
    }
    
    public void setFramebufferColor(final float lIlIlIIIlllI, final float lIlIlIIlIIlI, final float lIlIlIIlIIIl, final float lIlIlIIIlIll) {
        this.framebufferColor[0] = lIlIlIIIlllI;
        this.framebufferColor[1] = lIlIlIIlIIlI;
        this.framebufferColor[2] = lIlIlIIlIIIl;
        this.framebufferColor[3] = lIlIlIIIlIll;
    }
    
    public void bindFramebuffer(final boolean lIlIlIIlllIl) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, this.framebufferObject);
            if (lIlIlIIlllIl) {
                GlStateManager.viewport(0, 0, this.framebufferWidth, this.framebufferHeight);
            }
        }
    }
    
    public void checkFramebufferComplete() {
        final int lIlIlIlIIllI = OpenGlHelper.glCheckFramebufferStatus(OpenGlHelper.GL_FRAMEBUFFER);
        if (lIlIlIlIIllI == OpenGlHelper.GL_FRAMEBUFFER_COMPLETE) {
            return;
        }
        if (lIlIlIlIIllI == OpenGlHelper.GL_FB_INCOMPLETE_ATTACHMENT) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
        }
        if (lIlIlIlIIllI == OpenGlHelper.GL_FB_INCOMPLETE_MISS_ATTACH) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
        }
        if (lIlIlIlIIllI == OpenGlHelper.GL_FB_INCOMPLETE_DRAW_BUFFER) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER");
        }
        if (lIlIlIlIIllI == OpenGlHelper.GL_FB_INCOMPLETE_READ_BUFFER) {
            throw new RuntimeException("GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
        }
        throw new RuntimeException(String.valueOf(new StringBuilder("glCheckFramebufferStatus returned unknown status:").append(lIlIlIlIIllI)));
    }
    
    public void setFramebufferFilter(final int lIlIlIlIlIIl) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferFilter = lIlIlIlIlIIl;
            GlStateManager.bindTexture(this.framebufferTexture);
            GlStateManager.glTexParameteri(3553, 10241, lIlIlIlIlIIl);
            GlStateManager.glTexParameteri(3553, 10240, lIlIlIlIlIIl);
            GlStateManager.glTexParameteri(3553, 10242, 10496);
            GlStateManager.glTexParameteri(3553, 10243, 10496);
            GlStateManager.bindTexture(0);
        }
    }
    
    public void deleteFramebuffer() {
        if (OpenGlHelper.isFramebufferEnabled()) {
            this.unbindFramebufferTexture();
            this.unbindFramebuffer();
            if (this.depthBuffer > -1) {
                OpenGlHelper.glDeleteRenderbuffers(this.depthBuffer);
                this.depthBuffer = -1;
            }
            if (this.framebufferTexture > -1) {
                TextureUtil.deleteTexture(this.framebufferTexture);
                this.framebufferTexture = -1;
            }
            if (this.framebufferObject > -1) {
                OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
                OpenGlHelper.glDeleteFramebuffers(this.framebufferObject);
                this.framebufferObject = -1;
            }
        }
    }
    
    public void createBindFramebuffer(final int lIlIlIllllll, final int lIlIlIlllIll) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            this.framebufferWidth = lIlIlIllllll;
            this.framebufferHeight = lIlIlIlllIll;
        }
        else {
            GlStateManager.enableDepth();
            if (this.framebufferObject >= 0) {
                this.deleteFramebuffer();
            }
            this.createFramebuffer(lIlIlIllllll, lIlIlIlllIll);
            this.checkFramebufferComplete();
            OpenGlHelper.glBindFramebuffer(OpenGlHelper.GL_FRAMEBUFFER, 0);
        }
    }
    
    public void framebufferClear() {
        this.bindFramebuffer(true);
        GlStateManager.clearColor(this.framebufferColor[0], this.framebufferColor[1], this.framebufferColor[2], this.framebufferColor[3]);
        int lIlIIllIIIII = 16384;
        if (this.useDepth) {
            GlStateManager.clearDepth(1.0);
            lIlIIllIIIII |= 0x100;
        }
        GlStateManager.clear(lIlIIllIIIII);
        this.unbindFramebuffer();
    }
}
