package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;

public class DebugRendererChunkBorder implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Minecraft minecraft;
    
    public DebugRendererChunkBorder(final Minecraft lllllllllllllllIlIIllIlIllIlIllI) {
        this.minecraft = lllllllllllllllIlIIllIlIllIlIllI;
    }
    
    @Override
    public void render(final float lllllllllllllllIlIIllIlIllIIIlII, final long lllllllllllllllIlIIllIlIllIIIIll) {
        final EntityPlayer lllllllllllllllIlIIllIlIllIIIIlI = this.minecraft.player;
        final Tessellator lllllllllllllllIlIIllIlIllIIIIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlIIllIlIllIIIIII = lllllllllllllllIlIIllIlIllIIIIIl.getBuffer();
        final double lllllllllllllllIlIIllIlIlIllllll = lllllllllllllllIlIIllIlIllIIIIlI.lastTickPosX + (lllllllllllllllIlIIllIlIllIIIIlI.posX - lllllllllllllllIlIIllIlIllIIIIlI.lastTickPosX) * lllllllllllllllIlIIllIlIllIIIlII;
        final double lllllllllllllllIlIIllIlIlIlllllI = lllllllllllllllIlIIllIlIllIIIIlI.lastTickPosY + (lllllllllllllllIlIIllIlIllIIIIlI.posY - lllllllllllllllIlIIllIlIllIIIIlI.lastTickPosY) * lllllllllllllllIlIIllIlIllIIIlII;
        final double lllllllllllllllIlIIllIlIlIllllIl = lllllllllllllllIlIIllIlIllIIIIlI.lastTickPosZ + (lllllllllllllllIlIIllIlIllIIIIlI.posZ - lllllllllllllllIlIIllIlIllIIIIlI.lastTickPosZ) * lllllllllllllllIlIIllIlIllIIIlII;
        final double lllllllllllllllIlIIllIlIlIllllII = 0.0 - lllllllllllllllIlIIllIlIlIlllllI;
        final double lllllllllllllllIlIIllIlIlIlllIll = 256.0 - lllllllllllllllIlIIllIlIlIlllllI;
        GlStateManager.disableTexture2D();
        GlStateManager.disableBlend();
        final double lllllllllllllllIlIIllIlIlIlllIlI = (lllllllllllllllIlIIllIlIllIIIIlI.chunkCoordX << 4) - lllllllllllllllIlIIllIlIlIllllll;
        final double lllllllllllllllIlIIllIlIlIlllIIl = (lllllllllllllllIlIIllIlIllIIIIlI.chunkCoordZ << 4) - lllllllllllllllIlIIllIlIlIllllIl;
        GlStateManager.glLineWidth(1.0f);
        lllllllllllllllIlIIllIlIllIIIIII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int lllllllllllllllIlIIllIlIlIlllIII = -16; lllllllllllllllIlIIllIlIlIlllIII <= 32; lllllllllllllllIlIIllIlIlIlllIII += 16) {
            for (int lllllllllllllllIlIIllIlIlIllIlll = -16; lllllllllllllllIlIIllIlIlIllIlll <= 32; lllllllllllllllIlIIllIlIlIllIlll += 16) {
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIlllIII, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlll).color(1.0f, 0.0f, 0.0f, 0.0f).endVertex();
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIlllIII, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIlllIII, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlll).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIlllIII, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlll).color(1.0f, 0.0f, 0.0f, 0.0f).endVertex();
            }
        }
        for (int lllllllllllllllIlIIllIlIlIllIllI = 2; lllllllllllllllIlIIllIlIlIllIllI < 16; lllllllllllllllIlIIllIlIlIllIllI += 2) {
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIllI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
        }
        for (int lllllllllllllllIlIIllIlIlIllIlIl = 2; lllllllllllllllIlIIllIlIlIllIlIl < 16; lllllllllllllllIlIIllIlIlIllIlIl += 2) {
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIlIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
        }
        for (int lllllllllllllllIlIIllIlIlIllIlII = 0; lllllllllllllllIlIIllIlIlIllIlII <= 256; lllllllllllllllIlIIllIlIlIllIlII += 2) {
            final double lllllllllllllllIlIIllIlIlIllIIll = lllllllllllllllIlIIllIlIlIllIlII - lllllllllllllllIlIIllIlIlIlllllI;
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIllIIll, lllllllllllllllIlIIllIlIlIlllIIl).color(1.0f, 1.0f, 0.0f, 0.0f).endVertex();
        }
        lllllllllllllllIlIIllIlIllIIIIIl.draw();
        GlStateManager.glLineWidth(2.0f);
        lllllllllllllllIlIIllIlIllIIIIII.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int lllllllllllllllIlIIllIlIlIllIIlI = 0; lllllllllllllllIlIIllIlIlIllIIlI <= 16; lllllllllllllllIlIIllIlIlIllIIlI += 16) {
            for (int lllllllllllllllIlIIllIlIlIllIIIl = 0; lllllllllllllllIlIIllIlIlIllIIIl <= 16; lllllllllllllllIlIIllIlIlIllIIIl += 16) {
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIIlI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIIIl).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIIlI, lllllllllllllllIlIIllIlIlIllllII, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIIIl).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIIlI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIIIl).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
                lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + lllllllllllllllIlIIllIlIlIllIIlI, lllllllllllllllIlIIllIlIlIlllIll, lllllllllllllllIlIIllIlIlIlllIIl + lllllllllllllllIlIIllIlIlIllIIIl).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
            }
        }
        for (int lllllllllllllllIlIIllIlIlIllIIII = 0; lllllllllllllllIlIIllIlIlIllIIII <= 256; lllllllllllllllIlIIllIlIlIllIIII += 16) {
            final double lllllllllllllllIlIIllIlIlIlIllll = lllllllllllllllIlIIllIlIlIllIIII - lllllllllllllllIlIIllIlIlIlllllI;
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl + 16.0).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI + 16.0, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl).color(0.25f, 0.25f, 1.0f, 1.0f).endVertex();
            lllllllllllllllIlIIllIlIllIIIIII.pos(lllllllllllllllIlIIllIlIlIlllIlI, lllllllllllllllIlIIllIlIlIlIllll, lllllllllllllllIlIIllIlIlIlllIIl).color(0.25f, 0.25f, 1.0f, 0.0f).endVertex();
        }
        lllllllllllllllIlIIllIlIllIIIIIl.draw();
        GlStateManager.glLineWidth(1.0f);
        GlStateManager.enableBlend();
        GlStateManager.enableTexture2D();
    }
}
