package net.minecraft.client.shader;

import java.util.*;
import org.lwjgl.util.vector.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import java.io.*;
import net.minecraft.client.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class Shader
{
    private final /* synthetic */ List<Object> listAuxFramebuffers;
    private /* synthetic */ Matrix4f projectionMatrix;
    private final /* synthetic */ ShaderManager manager;
    private final /* synthetic */ List<String> listAuxNames;
    public final /* synthetic */ Framebuffer framebufferOut;
    private final /* synthetic */ List<Integer> listAuxHeights;
    public final /* synthetic */ Framebuffer framebufferIn;
    private final /* synthetic */ List<Integer> listAuxWidths;
    
    public ShaderManager getShaderManager() {
        return this.manager;
    }
    
    public Shader(final IResourceManager lllllllllllllIIIIlIIlllllIIIlIII, final String lllllllllllllIIIIlIIlllllIIIllII, final Framebuffer lllllllllllllIIIIlIIlllllIIIIllI, final Framebuffer lllllllllllllIIIIlIIlllllIIIlIlI) throws IOException, JsonException {
        this.listAuxFramebuffers = (List<Object>)Lists.newArrayList();
        this.listAuxNames = (List<String>)Lists.newArrayList();
        this.listAuxWidths = (List<Integer>)Lists.newArrayList();
        this.listAuxHeights = (List<Integer>)Lists.newArrayList();
        this.manager = new ShaderManager(lllllllllllllIIIIlIIlllllIIIlIII, lllllllllllllIIIIlIIlllllIIIllII);
        this.framebufferIn = lllllllllllllIIIIlIIlllllIIIIllI;
        this.framebufferOut = lllllllllllllIIIIlIIlllllIIIlIlI;
    }
    
    public void setProjectionMatrix(final Matrix4f lllllllllllllIIIIlIIllllIllIllII) {
        this.projectionMatrix = lllllllllllllIIIIlIIllllIllIllII;
    }
    
    public void deleteShader() {
        this.manager.deleteShader();
    }
    
    public void addAuxFramebuffer(final String lllllllllllllIIIIlIIllllIllllIll, final Object lllllllllllllIIIIlIIllllIlllIlIl, final int lllllllllllllIIIIlIIllllIlllIlII, final int lllllllllllllIIIIlIIllllIllllIII) {
        this.listAuxNames.add(this.listAuxNames.size(), lllllllllllllIIIIlIIllllIllllIll);
        this.listAuxFramebuffers.add(this.listAuxFramebuffers.size(), lllllllllllllIIIIlIIllllIlllIlIl);
        this.listAuxWidths.add(this.listAuxWidths.size(), lllllllllllllIIIIlIIllllIlllIlII);
        this.listAuxHeights.add(this.listAuxHeights.size(), lllllllllllllIIIIlIIllllIllllIII);
    }
    
    public void loadShader(final float lllllllllllllIIIIlIIllllIlIllIII) {
        this.preLoadShader();
        this.framebufferIn.unbindFramebuffer();
        final float lllllllllllllIIIIlIIllllIllIIIII = (float)this.framebufferOut.framebufferTextureWidth;
        final float lllllllllllllIIIIlIIllllIlIlllll = (float)this.framebufferOut.framebufferTextureHeight;
        GlStateManager.viewport(0, 0, (int)lllllllllllllIIIIlIIllllIllIIIII, (int)lllllllllllllIIIIlIIllllIlIlllll);
        this.manager.addSamplerTexture("DiffuseSampler", this.framebufferIn);
        for (int lllllllllllllIIIIlIIllllIlIllllI = 0; lllllllllllllIIIIlIIllllIlIllllI < this.listAuxFramebuffers.size(); ++lllllllllllllIIIIlIIllllIlIllllI) {
            this.manager.addSamplerTexture(this.listAuxNames.get(lllllllllllllIIIIlIIllllIlIllllI), this.listAuxFramebuffers.get(lllllllllllllIIIIlIIllllIlIllllI));
            this.manager.getShaderUniformOrDefault(String.valueOf(new StringBuilder("AuxSize").append(lllllllllllllIIIIlIIllllIlIllllI))).set(this.listAuxWidths.get(lllllllllllllIIIIlIIllllIlIllllI), this.listAuxHeights.get(lllllllllllllIIIIlIIllllIlIllllI));
        }
        this.manager.getShaderUniformOrDefault("ProjMat").set(this.projectionMatrix);
        this.manager.getShaderUniformOrDefault("InSize").set((float)this.framebufferIn.framebufferTextureWidth, (float)this.framebufferIn.framebufferTextureHeight);
        this.manager.getShaderUniformOrDefault("OutSize").set(lllllllllllllIIIIlIIllllIllIIIII, lllllllllllllIIIIlIIllllIlIlllll);
        this.manager.getShaderUniformOrDefault("Time").set(lllllllllllllIIIIlIIllllIlIllIII);
        final Minecraft lllllllllllllIIIIlIIllllIlIlllIl = Minecraft.getMinecraft();
        this.manager.getShaderUniformOrDefault("ScreenSize").set((float)lllllllllllllIIIIlIIllllIlIlllIl.displayWidth, (float)lllllllllllllIIIIlIIllllIlIlllIl.displayHeight);
        this.manager.useShader();
        this.framebufferOut.framebufferClear();
        this.framebufferOut.bindFramebuffer(false);
        GlStateManager.depthMask(false);
        GlStateManager.colorMask(true, true, true, true);
        final Tessellator lllllllllllllIIIIlIIllllIlIlllII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIIlIIllllIlIllIll = lllllllllllllIIIIlIIllllIlIlllII.getBuffer();
        lllllllllllllIIIIlIIllllIlIllIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllIIIIlIIllllIlIllIll.pos(0.0, lllllllllllllIIIIlIIllllIlIlllll, 500.0).color(255, 255, 255, 255).endVertex();
        lllllllllllllIIIIlIIllllIlIllIll.pos(lllllllllllllIIIIlIIllllIllIIIII, lllllllllllllIIIIlIIllllIlIlllll, 500.0).color(255, 255, 255, 255).endVertex();
        lllllllllllllIIIIlIIllllIlIllIll.pos(lllllllllllllIIIIlIIllllIllIIIII, 0.0, 500.0).color(255, 255, 255, 255).endVertex();
        lllllllllllllIIIIlIIllllIlIllIll.pos(0.0, 0.0, 500.0).color(255, 255, 255, 255).endVertex();
        lllllllllllllIIIIlIIllllIlIlllII.draw();
        GlStateManager.depthMask(true);
        GlStateManager.colorMask(true, true, true, true);
        this.manager.endShader();
        this.framebufferOut.unbindFramebuffer();
        this.framebufferIn.unbindFramebufferTexture();
        for (final Object lllllllllllllIIIIlIIllllIlIllIlI : this.listAuxFramebuffers) {
            if (lllllllllllllIIIIlIIllllIlIllIlI instanceof Framebuffer) {
                ((Framebuffer)lllllllllllllIIIIlIIllllIlIllIlI).unbindFramebufferTexture();
            }
        }
    }
    
    private void preLoadShader() {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableAlpha();
        GlStateManager.disableFog();
        GlStateManager.disableLighting();
        GlStateManager.disableColorMaterial();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(0);
    }
}
