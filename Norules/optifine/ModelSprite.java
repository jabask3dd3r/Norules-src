package optifine;

import net.minecraft.client.model.*;
import net.minecraft.util.math.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class ModelSprite
{
    private /* synthetic */ int textureOffsetY;
    private /* synthetic */ int sizeZ;
    private /* synthetic */ float posY;
    private /* synthetic */ float posX;
    private /* synthetic */ int sizeX;
    private /* synthetic */ float sizeAdd;
    private /* synthetic */ int textureOffsetX;
    private /* synthetic */ float maxV;
    private /* synthetic */ ModelRenderer modelRenderer;
    private /* synthetic */ int sizeY;
    private /* synthetic */ float minU;
    private /* synthetic */ float minV;
    private /* synthetic */ float posZ;
    private /* synthetic */ float maxU;
    
    public void render(final Tessellator lllllllllllllIIllIIlIIIIlIIIllll, final float lllllllllllllIIllIIlIIIIlIIIIlll) {
        GlStateManager.translate(this.posX * lllllllllllllIIllIIlIIIIlIIIIlll, this.posY * lllllllllllllIIllIIlIIIIlIIIIlll, this.posZ * lllllllllllllIIllIIlIIIIlIIIIlll);
        float lllllllllllllIIllIIlIIIIlIIIllIl = this.minU;
        float lllllllllllllIIllIIlIIIIlIIIllII = this.maxU;
        float lllllllllllllIIllIIlIIIIlIIIlIll = this.minV;
        float lllllllllllllIIllIIlIIIIlIIIlIlI = this.maxV;
        if (this.modelRenderer.mirror) {
            lllllllllllllIIllIIlIIIIlIIIllIl = this.maxU;
            lllllllllllllIIllIIlIIIIlIIIllII = this.minU;
        }
        if (this.modelRenderer.mirrorV) {
            lllllllllllllIIllIIlIIIIlIIIlIll = this.maxV;
            lllllllllllllIIllIIlIIIIlIIIlIlI = this.minV;
        }
        renderItemIn2D(lllllllllllllIIllIIlIIIIlIIIllll, lllllllllllllIIllIIlIIIIlIIIllIl, lllllllllllllIIllIIlIIIIlIIIlIll, lllllllllllllIIllIIlIIIIlIIIllII, lllllllllllllIIllIIlIIIIlIIIlIlI, this.sizeX, this.sizeY, lllllllllllllIIllIIlIIIIlIIIIlll * this.sizeZ, this.modelRenderer.textureWidth, this.modelRenderer.textureHeight);
        GlStateManager.translate(-this.posX * lllllllllllllIIllIIlIIIIlIIIIlll, -this.posY * lllllllllllllIIllIIlIIIIlIIIIlll, -this.posZ * lllllllllllllIIllIIlIIIIlIIIIlll);
    }
    
    public static void renderItemIn2D(final Tessellator lllllllllllllIIllIIlIIIIIllIllIl, final float lllllllllllllIIllIIlIIIIIllIllII, final float lllllllllllllIIllIIlIIIIIlIIllII, final float lllllllllllllIIllIIlIIIIIllIlIlI, final float lllllllllllllIIllIIlIIIIIlIIlIlI, final int lllllllllllllIIllIIlIIIIIlIIlIIl, final int lllllllllllllIIllIIlIIIIIllIIlll, float lllllllllllllIIllIIlIIIIIlIIIlll, final float lllllllllllllIIllIIlIIIIIllIIlIl, final float lllllllllllllIIllIIlIIIIIlIIIlIl) {
        if (lllllllllllllIIllIIlIIIIIlIIIlll < 6.25E-4f) {
            lllllllllllllIIllIIlIIIIIlIIIlll = 6.25E-4f;
        }
        final float lllllllllllllIIllIIlIIIIIllIIIll = lllllllllllllIIllIIlIIIIIllIlIlI - lllllllllllllIIllIIlIIIIIllIllII;
        final float lllllllllllllIIllIIlIIIIIllIIIlI = lllllllllllllIIllIIlIIIIIlIIlIlI - lllllllllllllIIllIIlIIIIIlIIllII;
        final double lllllllllllllIIllIIlIIIIIllIIIIl = MathHelper.abs(lllllllllllllIIllIIlIIIIIllIIIll) * (lllllllllllllIIllIIlIIIIIllIIlIl / 16.0f);
        final double lllllllllllllIIllIIlIIIIIllIIIII = MathHelper.abs(lllllllllllllIIllIIlIIIIIllIIIlI) * (lllllllllllllIIllIIlIIIIIlIIIlIl / 16.0f);
        final BufferBuilder lllllllllllllIIllIIlIIIIIlIlllll = lllllllllllllIIllIIlIIIIIllIllIl.getBuffer();
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        lllllllllllllIIllIIlIIIIIlIlllll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
        lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
        lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, 0.0, 0.0).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
        lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, 0.0, 0.0).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
        lllllllllllllIIllIIlIIIIIllIllIl.draw();
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        lllllllllllllIIllIIlIIIIIlIlllll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, 0.0, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
        lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, 0.0, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
        lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
        lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
        lllllllllllllIIllIIlIIIIIllIllIl.draw();
        final float lllllllllllllIIllIIlIIIIIlIllllI = 0.5f * lllllllllllllIIllIIlIIIIIllIIIll / lllllllllllllIIllIIlIIIIIlIIlIIl;
        final float lllllllllllllIIllIIlIIIIIlIlllIl = 0.5f * lllllllllllllIIllIIlIIIIIllIIIlI / lllllllllllllIIllIIlIIIIIllIIlll;
        GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
        lllllllllllllIIllIIlIIIIIlIlllll.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (int lllllllllllllIIllIIlIIIIIlIlllII = 0; lllllllllllllIIllIIlIIIIIlIlllII < lllllllllllllIIllIIlIIIIIlIIlIIl; ++lllllllllllllIIllIIlIIIIIlIlllII) {
            final float lllllllllllllIIllIIlIIIIIlIllIll = lllllllllllllIIllIIlIIIIIlIlllII / (float)lllllllllllllIIllIIlIIIIIlIIlIIl;
            final float lllllllllllllIIllIIlIIIIIlIllIlI = lllllllllllllIIllIIlIIIIIllIllII + lllllllllllllIIllIIlIIIIIllIIIll * lllllllllllllIIllIIlIIIIIlIllIll + lllllllllllllIIllIIlIIIIIlIllllI;
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIllIll * lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIlIllIlI, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIllIll * lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIlIllIlI, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIllIll * lllllllllllllIIllIIlIIIIIllIIIIl, 0.0, 0.0).tex(lllllllllllllIIllIIlIIIIIlIllIlI, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIllIll * lllllllllllllIIllIIlIIIIIllIIIIl, 0.0, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIlIllIlI, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
        }
        lllllllllllllIIllIIlIIIIIllIllIl.draw();
        GL11.glNormal3f(1.0f, 0.0f, 0.0f);
        lllllllllllllIIllIIlIIIIIlIlllll.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (int lllllllllllllIIllIIlIIIIIlIllIIl = 0; lllllllllllllIIllIIlIIIIIlIllIIl < lllllllllllllIIllIIlIIIIIlIIlIIl; ++lllllllllllllIIllIIlIIIIIlIllIIl) {
            final float lllllllllllllIIllIIlIIIIIlIllIII = lllllllllllllIIllIIlIIIIIlIllIIl / (float)lllllllllllllIIllIIlIIIIIlIIlIIl;
            final float lllllllllllllIIllIIlIIIIIlIlIlll = lllllllllllllIIllIIlIIIIIllIllII + lllllllllllllIIllIIlIIIIIllIIIll * lllllllllllllIIllIIlIIIIIlIllIII + lllllllllllllIIllIIlIIIIIlIllllI;
            final float lllllllllllllIIllIIlIIIIIlIlIllI = lllllllllllllIIllIIlIIIIIlIllIII + 1.0f / lllllllllllllIIllIIlIIIIIlIIlIIl;
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIlIllI * lllllllllllllIIllIIlIIIIIllIIIIl, 0.0, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIlIlIlll, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIlIllI * lllllllllllllIIllIIlIIIIIllIIIIl, 0.0, 0.0).tex(lllllllllllllIIllIIlIIIIIlIlIlll, lllllllllllllIIllIIlIIIIIlIIllII).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIlIllI * lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIlIlIlll, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIlIlIllI * lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIlIlIlll, lllllllllllllIIllIIlIIIIIlIIlIlI).endVertex();
        }
        lllllllllllllIIllIIlIIIIIllIllIl.draw();
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        lllllllllllllIIllIIlIIIIIlIlllll.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (int lllllllllllllIIllIIlIIIIIlIlIlIl = 0; lllllllllllllIIllIIlIIIIIlIlIlIl < lllllllllllllIIllIIlIIIIIllIIlll; ++lllllllllllllIIllIIlIIIIIlIlIlIl) {
            final float lllllllllllllIIllIIlIIIIIlIlIlII = lllllllllllllIIllIIlIIIIIlIlIlIl / (float)lllllllllllllIIllIIlIIIIIllIIlll;
            final float lllllllllllllIIllIIlIIIIIlIlIIll = lllllllllllllIIllIIlIIIIIlIIllII + lllllllllllllIIllIIlIIIIIllIIIlI * lllllllllllllIIllIIlIIIIIlIlIlII + lllllllllllllIIllIIlIIIIIlIlllIl;
            final float lllllllllllllIIllIIlIIIIIlIlIIlI = lllllllllllllIIllIIlIIIIIlIlIlII + 1.0f / lllllllllllllIIllIIlIIIIIllIIlll;
            lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, lllllllllllllIIllIIlIIIIIlIlIIlI * lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIlIIll).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIlIlIIlI * lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIlIIll).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIlIlIIlI * lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIlIIll).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, lllllllllllllIIllIIlIIIIIlIlIIlI * lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIlIIll).endVertex();
        }
        lllllllllllllIIllIIlIIIIIllIllIl.draw();
        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        lllllllllllllIIllIIlIIIIIlIlllll.begin(7, DefaultVertexFormats.POSITION_TEX);
        for (int lllllllllllllIIllIIlIIIIIlIlIIIl = 0; lllllllllllllIIllIIlIIIIIlIlIIIl < lllllllllllllIIllIIlIIIIIllIIlll; ++lllllllllllllIIllIIlIIIIIlIlIIIl) {
            final float lllllllllllllIIllIIlIIIIIlIlIIII = lllllllllllllIIllIIlIIIIIlIlIIIl / (float)lllllllllllllIIllIIlIIIIIllIIlll;
            final float lllllllllllllIIllIIlIIIIIlIIllll = lllllllllllllIIllIIlIIIIIlIIllII + lllllllllllllIIllIIlIIIIIllIIIlI * lllllllllllllIIllIIlIIIIIlIlIIII + lllllllllllllIIllIIlIIIIIlIlllIl;
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIlIlIIII * lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIIllll).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, lllllllllllllIIllIIlIIIIIlIlIIII * lllllllllllllIIllIIlIIIIIllIIIII, lllllllllllllIIllIIlIIIIIlIIIlll).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIIllll).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(0.0, lllllllllllllIIllIIlIIIIIlIlIIII * lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIllIllII, lllllllllllllIIllIIlIIIIIlIIllll).endVertex();
            lllllllllllllIIllIIlIIIIIlIlllll.pos(lllllllllllllIIllIIlIIIIIllIIIIl, lllllllllllllIIllIIlIIIIIlIlIIII * lllllllllllllIIllIIlIIIIIllIIIII, 0.0).tex(lllllllllllllIIllIIlIIIIIllIlIlI, lllllllllllllIIllIIlIIIIIlIIllll).endVertex();
        }
        lllllllllllllIIllIIlIIIIIllIllIl.draw();
    }
    
    public ModelSprite(final ModelRenderer lllllllllllllIIllIIlIIIIlIlIllII, final int lllllllllllllIIllIIlIIIIlIlIlIll, final int lllllllllllllIIllIIlIIIIlIIlllll, final float lllllllllllllIIllIIlIIIIlIIllllI, final float lllllllllllllIIllIIlIIIIlIlIlIII, final float lllllllllllllIIllIIlIIIIlIlIIlll, final int lllllllllllllIIllIIlIIIIlIIllIll, final int lllllllllllllIIllIIlIIIIlIlIIlIl, final int lllllllllllllIIllIIlIIIIlIIllIIl, final float lllllllllllllIIllIIlIIIIlIlIIIll) {
        this.modelRenderer = null;
        this.textureOffsetX = 0;
        this.textureOffsetY = 0;
        this.posX = 0.0f;
        this.posY = 0.0f;
        this.posZ = 0.0f;
        this.sizeX = 0;
        this.sizeY = 0;
        this.sizeZ = 0;
        this.sizeAdd = 0.0f;
        this.minU = 0.0f;
        this.minV = 0.0f;
        this.maxU = 0.0f;
        this.maxV = 0.0f;
        this.modelRenderer = lllllllllllllIIllIIlIIIIlIlIllII;
        this.textureOffsetX = lllllllllllllIIllIIlIIIIlIlIlIll;
        this.textureOffsetY = lllllllllllllIIllIIlIIIIlIIlllll;
        this.posX = lllllllllllllIIllIIlIIIIlIIllllI;
        this.posY = lllllllllllllIIllIIlIIIIlIlIlIII;
        this.posZ = lllllllllllllIIllIIlIIIIlIlIIlll;
        this.sizeX = lllllllllllllIIllIIlIIIIlIIllIll;
        this.sizeY = lllllllllllllIIllIIlIIIIlIlIIlIl;
        this.sizeZ = lllllllllllllIIllIIlIIIIlIIllIIl;
        this.sizeAdd = lllllllllllllIIllIIlIIIIlIlIIIll;
        this.minU = lllllllllllllIIllIIlIIIIlIlIlIll / lllllllllllllIIllIIlIIIIlIlIllII.textureWidth;
        this.minV = lllllllllllllIIllIIlIIIIlIIlllll / lllllllllllllIIllIIlIIIIlIlIllII.textureHeight;
        this.maxU = (lllllllllllllIIllIIlIIIIlIlIlIll + lllllllllllllIIllIIlIIIIlIIllIll) / lllllllllllllIIllIIlIIIIlIlIllII.textureWidth;
        this.maxV = (lllllllllllllIIllIIlIIIIlIIlllll + lllllllllllllIIllIIlIIIIlIlIIlIl) / lllllllllllllIIllIIlIIIIlIlIllII.textureHeight;
    }
}
