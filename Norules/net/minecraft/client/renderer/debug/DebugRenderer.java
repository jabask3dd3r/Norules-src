package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.entity.*;

public class DebugRenderer
{
    private /* synthetic */ boolean field_193853_n;
    public final /* synthetic */ IDebugRenderer field_191325_e;
    private /* synthetic */ boolean chunkBordersEnabled;
    private /* synthetic */ boolean waterEnabled;
    private /* synthetic */ boolean pathfindingEnabled;
    public final /* synthetic */ IDebugRenderer debugRendererHeightMap;
    private /* synthetic */ boolean heightmapEnabled;
    private /* synthetic */ boolean field_191326_j;
    public final /* synthetic */ IDebugRenderer debugRendererChunkBorder;
    public final /* synthetic */ IDebugRenderer field_191557_f;
    public final /* synthetic */ IDebugRenderer debugRendererWater;
    public final /* synthetic */ IDebugRenderer debugRendererPathfinding;
    public final /* synthetic */ IDebugRenderer field_193852_g;
    private /* synthetic */ boolean field_191558_l;
    
    public boolean shouldRender() {
        return this.chunkBordersEnabled || this.pathfindingEnabled || this.waterEnabled || this.heightmapEnabled || this.field_191326_j || this.field_191558_l || this.field_193853_n;
    }
    
    public static void renderDebugText(final String lllllllllllllIIIlIlllIllIllllIlI, final double lllllllllllllIIIlIlllIllIllllIIl, final double lllllllllllllIIIlIlllIlllIIIIlIl, final double lllllllllllllIIIlIlllIlllIIIIlII, final float lllllllllllllIIIlIlllIllIlllIllI, final int lllllllllllllIIIlIlllIllIlllIlIl) {
        final Minecraft lllllllllllllIIIlIlllIlllIIIIIIl = Minecraft.getMinecraft();
        if (lllllllllllllIIIlIlllIlllIIIIIIl.player != null && lllllllllllllIIIlIlllIlllIIIIIIl.getRenderManager() != null && lllllllllllllIIIlIlllIlllIIIIIIl.getRenderManager().options != null) {
            final FontRenderer lllllllllllllIIIlIlllIlllIIIIIII = lllllllllllllIIIlIlllIlllIIIIIIl.fontRendererObj;
            final EntityPlayer lllllllllllllIIIlIlllIllIlllllll = lllllllllllllIIIlIlllIlllIIIIIIl.player;
            final double lllllllllllllIIIlIlllIllIllllllI = lllllllllllllIIIlIlllIllIlllllll.lastTickPosX + (lllllllllllllIIIlIlllIllIlllllll.posX - lllllllllllllIIIlIlllIllIlllllll.lastTickPosX) * lllllllllllllIIIlIlllIllIlllIllI;
            final double lllllllllllllIIIlIlllIllIlllllIl = lllllllllllllIIIlIlllIllIlllllll.lastTickPosY + (lllllllllllllIIIlIlllIllIlllllll.posY - lllllllllllllIIIlIlllIllIlllllll.lastTickPosY) * lllllllllllllIIIlIlllIllIlllIllI;
            final double lllllllllllllIIIlIlllIllIlllllII = lllllllllllllIIIlIlllIllIlllllll.lastTickPosZ + (lllllllllllllIIIlIlllIllIlllllll.posZ - lllllllllllllIIIlIlllIllIlllllll.lastTickPosZ) * lllllllllllllIIIlIlllIllIlllIllI;
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)(lllllllllllllIIIlIlllIllIllllIIl - lllllllllllllIIIlIlllIllIllllllI), (float)(lllllllllllllIIIlIlllIlllIIIIlIl - lllllllllllllIIIlIlllIllIlllllIl) + 0.07f, (float)(lllllllllllllIIIlIlllIlllIIIIlII - lllllllllllllIIIlIlllIllIlllllII));
            GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.scale(0.02f, -0.02f, 0.02f);
            final RenderManager lllllllllllllIIIlIlllIllIllllIll = lllllllllllllIIIlIlllIlllIIIIIIl.getRenderManager();
            GlStateManager.rotate(-lllllllllllllIIIlIlllIllIllllIll.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(((lllllllllllllIIIlIlllIllIllllIll.options.thirdPersonView == 2) ? 1 : -1) * lllllllllllllIIIlIlllIllIllllIll.playerViewX, 1.0f, 0.0f, 0.0f);
            GlStateManager.disableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            GlStateManager.scale(-1.0f, 1.0f, 1.0f);
            lllllllllllllIIIlIlllIlllIIIIIII.drawString(lllllllllllllIIIlIlllIllIllllIlI, -lllllllllllllIIIlIlllIlllIIIIIII.getStringWidth(lllllllllllllIIIlIlllIllIllllIlI) / 2, 0.0, lllllllllllllIIIlIlllIllIlllIlIl);
            GlStateManager.enableLighting();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }
    
    public void renderDebug(final float lllllllllllllIIIlIlllIlllIlIlIll, final long lllllllllllllIIIlIlllIlllIlIIlll) {
        if (this.pathfindingEnabled) {
            this.debugRendererPathfinding.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
        if (this.chunkBordersEnabled && !Minecraft.getMinecraft().isReducedDebug()) {
            this.debugRendererChunkBorder.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
        if (this.waterEnabled) {
            this.debugRendererWater.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
        if (this.heightmapEnabled) {
            this.debugRendererHeightMap.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
        if (this.field_191326_j) {
            this.field_191325_e.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
        if (this.field_191558_l) {
            this.field_191557_f.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
        if (this.field_193853_n) {
            this.field_193852_g.render(lllllllllllllIIIlIlllIlllIlIlIll, lllllllllllllIIIlIlllIlllIlIIlll);
        }
    }
    
    public boolean toggleDebugScreen() {
        this.chunkBordersEnabled = !this.chunkBordersEnabled;
        return this.chunkBordersEnabled;
    }
    
    public DebugRenderer(final Minecraft lllllllllllllIIIlIlllIlllIllIllI) {
        this.debugRendererPathfinding = new DebugRendererPathfinding(lllllllllllllIIIlIlllIlllIllIllI);
        this.debugRendererWater = new DebugRendererWater(lllllllllllllIIIlIlllIlllIllIllI);
        this.debugRendererChunkBorder = new DebugRendererChunkBorder(lllllllllllllIIIlIlllIlllIllIllI);
        this.debugRendererHeightMap = new DebugRendererHeightMap(lllllllllllllIIIlIlllIlllIllIllI);
        this.field_191325_e = new DebugRendererCollisionBox(lllllllllllllIIIlIlllIlllIllIllI);
        this.field_191557_f = new DebugRendererNeighborsUpdate(lllllllllllllIIIlIlllIlllIllIllI);
        this.field_193852_g = new DebugRendererSolidFace(lllllllllllllIIIlIlllIlllIllIllI);
    }
    
    public static void func_191556_a(final String lllllllllllllIIIlIlllIlllIIllIlI, final int lllllllllllllIIIlIlllIlllIIllIIl, final int lllllllllllllIIIlIlllIlllIIllIII, final int lllllllllllllIIIlIlllIlllIIlllIl, final float lllllllllllllIIIlIlllIlllIIlIllI, final int lllllllllllllIIIlIlllIlllIIllIll) {
        renderDebugText(lllllllllllllIIIlIlllIlllIIllIlI, lllllllllllllIIIlIlllIlllIIllIIl + 0.5, lllllllllllllIIIlIlllIlllIIllIII + 0.5, lllllllllllllIIIlIlllIlllIIlllIl + 0.5, lllllllllllllIIIlIlllIlllIIlIllI, lllllllllllllIIIlIlllIlllIIllIll);
    }
    
    public interface IDebugRenderer
    {
        void render(final float p0, final long p1);
    }
}
