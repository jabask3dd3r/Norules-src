package net.minecraft.client.renderer.debug;

import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import net.minecraft.pathfinding.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;

public class DebugRendererPathfinding implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Map<Integer, Path> pathMap;
    private /* synthetic */ double xo;
    private /* synthetic */ EntityPlayer player;
    private final /* synthetic */ Map<Integer, Long> creationMap;
    private /* synthetic */ double yo;
    private final /* synthetic */ Map<Integer, Float> pathMaxDistance;
    private /* synthetic */ double zo;
    private final /* synthetic */ Minecraft minecraft;
    
    private float addDistanceToPlayer(final PathPoint lllllllllllllIIlIlIIlllIlllllIIl) {
        return (float)(Math.abs(lllllllllllllIIlIlIIlllIlllllIIl.xCoord - this.player.posX) + Math.abs(lllllllllllllIIlIlIIlllIlllllIIl.yCoord - this.player.posY) + Math.abs(lllllllllllllIIlIlIIlllIlllllIIl.zCoord - this.player.posZ));
    }
    
    @Override
    public void render(final float lllllllllllllIIlIlIIllllIIllllII, final long lllllllllllllIIlIlIIllllIIlllIll) {
        if (!this.pathMap.isEmpty()) {
            final long lllllllllllllIIlIlIIllllIIlllIlI = System.currentTimeMillis();
            this.player = this.minecraft.player;
            this.xo = this.player.lastTickPosX + (this.player.posX - this.player.lastTickPosX) * lllllllllllllIIlIlIIllllIIllllII;
            this.yo = this.player.lastTickPosY + (this.player.posY - this.player.lastTickPosY) * lllllllllllllIIlIlIIllllIIllllII;
            this.zo = this.player.lastTickPosZ + (this.player.posZ - this.player.lastTickPosZ) * lllllllllllllIIlIlIIllllIIllllII;
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.color(0.0f, 1.0f, 0.0f, 0.75f);
            GlStateManager.disableTexture2D();
            GlStateManager.glLineWidth(6.0f);
            for (final Integer lllllllllllllIIlIlIIllllIIlllIIl : this.pathMap.keySet()) {
                final Path lllllllllllllIIlIlIIllllIIlllIII = this.pathMap.get(lllllllllllllIIlIlIIllllIIlllIIl);
                final float lllllllllllllIIlIlIIllllIIllIlll = this.pathMaxDistance.get(lllllllllllllIIlIlIIllllIIlllIIl);
                this.renderPathLine(lllllllllllllIIlIlIIllllIIllllII, lllllllllllllIIlIlIIllllIIlllIII);
                final PathPoint lllllllllllllIIlIlIIllllIIllIllI = lllllllllllllIIlIlIIllllIIlllIII.getTarget();
                if (this.addDistanceToPlayer(lllllllllllllIIlIlIIllllIIllIllI) <= 40.0f) {
                    RenderGlobal.renderFilledBox(new AxisAlignedBB(lllllllllllllIIlIlIIllllIIllIllI.xCoord + 0.25f, lllllllllllllIIlIlIIllllIIllIllI.yCoord + 0.25f, lllllllllllllIIlIlIIllllIIllIllI.zCoord + 0.25, lllllllllllllIIlIlIIllllIIllIllI.xCoord + 0.75f, lllllllllllllIIlIlIIllllIIllIllI.yCoord + 0.75f, lllllllllllllIIlIlIIllllIIllIllI.zCoord + 0.75f).offset(-this.xo, -this.yo, -this.zo), 0.0f, 1.0f, 0.0f, 0.5f);
                    for (int lllllllllllllIIlIlIIllllIIllIlIl = 0; lllllllllllllIIlIlIIllllIIllIlIl < lllllllllllllIIlIlIIllllIIlllIII.getCurrentPathLength(); ++lllllllllllllIIlIlIIllllIIllIlIl) {
                        final PathPoint lllllllllllllIIlIlIIllllIIllIlII = lllllllllllllIIlIlIIllllIIlllIII.getPathPointFromIndex(lllllllllllllIIlIlIIllllIIllIlIl);
                        if (this.addDistanceToPlayer(lllllllllllllIIlIlIIllllIIllIlII) <= 40.0f) {
                            final float lllllllllllllIIlIlIIllllIIllIIll = (lllllllllllllIIlIlIIllllIIllIlIl == lllllllllllllIIlIlIIllllIIlllIII.getCurrentPathIndex()) ? 1.0f : 0.0f;
                            final float lllllllllllllIIlIlIIllllIIllIIlI = (lllllllllllllIIlIlIIllllIIllIlIl == lllllllllllllIIlIlIIllllIIlllIII.getCurrentPathIndex()) ? 0.0f : 1.0f;
                            RenderGlobal.renderFilledBox(new AxisAlignedBB(lllllllllllllIIlIlIIllllIIllIlII.xCoord + 0.5f - lllllllllllllIIlIlIIllllIIllIlll, lllllllllllllIIlIlIIllllIIllIlII.yCoord + 0.01f * lllllllllllllIIlIlIIllllIIllIlIl, lllllllllllllIIlIlIIllllIIllIlII.zCoord + 0.5f - lllllllllllllIIlIlIIllllIIllIlll, lllllllllllllIIlIlIIllllIIllIlII.xCoord + 0.5f + lllllllllllllIIlIlIIllllIIllIlll, lllllllllllllIIlIlIIllllIIllIlII.yCoord + 0.25f + 0.01f * lllllllllllllIIlIlIIllllIIllIlIl, lllllllllllllIIlIlIIllllIIllIlII.zCoord + 0.5f + lllllllllllllIIlIlIIllllIIllIlll).offset(-this.xo, -this.yo, -this.zo), lllllllllllllIIlIlIIllllIIllIIll, 0.0f, lllllllllllllIIlIlIIllllIIllIIlI, 0.5f);
                        }
                    }
                }
            }
            for (final Integer lllllllllllllIIlIlIIllllIIllIIIl : this.pathMap.keySet()) {
                final Path lllllllllllllIIlIlIIllllIIllIIII = this.pathMap.get(lllllllllllllIIlIlIIllllIIllIIIl);
                final PathPoint[] closedSet;
                byte lllllllllllllIIlIlIIllllIIlIIIlI = (byte)(closedSet = lllllllllllllIIlIlIIllllIIllIIII.getClosedSet()).length;
                for (float lllllllllllllIIlIlIIllllIIlIIIll = 0; lllllllllllllIIlIlIIllllIIlIIIll < lllllllllllllIIlIlIIllllIIlIIIlI; ++lllllllllllllIIlIlIIllllIIlIIIll) {
                    final PathPoint lllllllllllllIIlIlIIllllIIlIllll = closedSet[lllllllllllllIIlIlIIllllIIlIIIll];
                    if (this.addDistanceToPlayer(lllllllllllllIIlIlIIllllIIlIllll) <= 40.0f) {
                        DebugRenderer.renderDebugText(String.format("%s", lllllllllllllIIlIlIIllllIIlIllll.nodeType), lllllllllllllIIlIlIIllllIIlIllll.xCoord + 0.5, lllllllllllllIIlIlIIllllIIlIllll.yCoord + 0.75, lllllllllllllIIlIlIIllllIIlIllll.zCoord + 0.5, lllllllllllllIIlIlIIllllIIllllII, -65536);
                        DebugRenderer.renderDebugText(String.format("%.2f", lllllllllllllIIlIlIIllllIIlIllll.costMalus), lllllllllllllIIlIlIIllllIIlIllll.xCoord + 0.5, lllllllllllllIIlIlIIllllIIlIllll.yCoord + 0.25, lllllllllllllIIlIlIIllllIIlIllll.zCoord + 0.5, lllllllllllllIIlIlIIllllIIllllII, -65536);
                    }
                }
                final PathPoint[] openSet;
                lllllllllllllIIlIlIIllllIIlIIIlI = (byte)(openSet = lllllllllllllIIlIlIIllllIIllIIII.getOpenSet()).length;
                for (float lllllllllllllIIlIlIIllllIIlIIIll = 0; lllllllllllllIIlIlIIllllIIlIIIll < lllllllllllllIIlIlIIllllIIlIIIlI; ++lllllllllllllIIlIlIIllllIIlIIIll) {
                    final PathPoint lllllllllllllIIlIlIIllllIIlIlllI = openSet[lllllllllllllIIlIlIIllllIIlIIIll];
                    if (this.addDistanceToPlayer(lllllllllllllIIlIlIIllllIIlIlllI) <= 40.0f) {
                        DebugRenderer.renderDebugText(String.format("%s", lllllllllllllIIlIlIIllllIIlIlllI.nodeType), lllllllllllllIIlIlIIllllIIlIlllI.xCoord + 0.5, lllllllllllllIIlIlIIllllIIlIlllI.yCoord + 0.75, lllllllllllllIIlIlIIllllIIlIlllI.zCoord + 0.5, lllllllllllllIIlIlIIllllIIllllII, -16776961);
                        DebugRenderer.renderDebugText(String.format("%.2f", lllllllllllllIIlIlIIllllIIlIlllI.costMalus), lllllllllllllIIlIlIIllllIIlIlllI.xCoord + 0.5, lllllllllllllIIlIlIIllllIIlIlllI.yCoord + 0.25, lllllllllllllIIlIlIIllllIIlIlllI.zCoord + 0.5, lllllllllllllIIlIlIIllllIIllllII, -16776961);
                    }
                }
                for (int lllllllllllllIIlIlIIllllIIlIllIl = 0; lllllllllllllIIlIlIIllllIIlIllIl < lllllllllllllIIlIlIIllllIIllIIII.getCurrentPathLength(); ++lllllllllllllIIlIlIIllllIIlIllIl) {
                    final PathPoint lllllllllllllIIlIlIIllllIIlIllII = lllllllllllllIIlIlIIllllIIllIIII.getPathPointFromIndex(lllllllllllllIIlIlIIllllIIlIllIl);
                    if (this.addDistanceToPlayer(lllllllllllllIIlIlIIllllIIlIllII) <= 40.0f) {
                        DebugRenderer.renderDebugText(String.format("%s", lllllllllllllIIlIlIIllllIIlIllII.nodeType), lllllllllllllIIlIlIIllllIIlIllII.xCoord + 0.5, lllllllllllllIIlIlIIllllIIlIllII.yCoord + 0.75, lllllllllllllIIlIlIIllllIIlIllII.zCoord + 0.5, lllllllllllllIIlIlIIllllIIllllII, -1);
                        DebugRenderer.renderDebugText(String.format("%.2f", lllllllllllllIIlIlIIllllIIlIllII.costMalus), lllllllllllllIIlIlIIllllIIlIllII.xCoord + 0.5, lllllllllllllIIlIlIIllllIIlIllII.yCoord + 0.25, lllllllllllllIIlIlIIllllIIlIllII.zCoord + 0.5, lllllllllllllIIlIlIIllllIIllllII, -1);
                    }
                }
            }
            final short lllllllllllllIIlIlIIllllIIlIIlII;
            final int length = (lllllllllllllIIlIlIIllllIIlIIlII = (short)(Object)this.creationMap.keySet().toArray(new Integer[0])).length;
            for (boolean lllllllllllllIIlIlIIllllIIlIIllI = false; (lllllllllllllIIlIlIIllllIIlIIllI ? 1 : 0) < length; ++lllllllllllllIIlIlIIllllIIlIIllI) {
                final Integer lllllllllllllIIlIlIIllllIIlIlIll = lllllllllllllIIlIlIIllllIIlIIlII[lllllllllllllIIlIlIIllllIIlIIllI];
                if (lllllllllllllIIlIlIIllllIIlllIlI - this.creationMap.get(lllllllllllllIIlIlIIllllIIlIlIll) > 20000L) {
                    this.pathMap.remove(lllllllllllllIIlIlIIllllIIlIlIll);
                    this.creationMap.remove(lllllllllllllIIlIlIIllllIIlIlIll);
                }
            }
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
    
    public void addPath(final int lllllllllllllIIlIlIIllllIlIlIIII, final Path lllllllllllllIIlIlIIllllIlIIlIll, final float lllllllllllllIIlIlIIllllIlIIlllI) {
        this.pathMap.put(lllllllllllllIIlIlIIllllIlIlIIII, lllllllllllllIIlIlIIllllIlIIlIll);
        this.creationMap.put(lllllllllllllIIlIlIIllllIlIlIIII, System.currentTimeMillis());
        this.pathMaxDistance.put(lllllllllllllIIlIlIIllllIlIlIIII, lllllllllllllIIlIlIIllllIlIIlllI);
    }
    
    public void renderPathLine(final float lllllllllllllIIlIlIIllllIIIlIIlI, final Path lllllllllllllIIlIlIIllllIIIlIIIl) {
        final Tessellator lllllllllllllIIlIlIIllllIIIlIIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlIlIIllllIIIIllll = lllllllllllllIIlIlIIllllIIIlIIII.getBuffer();
        lllllllllllllIIlIlIIllllIIIIllll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        for (int lllllllllllllIIlIlIIllllIIIIlllI = 0; lllllllllllllIIlIlIIllllIIIIlllI < lllllllllllllIIlIlIIllllIIIlIIIl.getCurrentPathLength(); ++lllllllllllllIIlIlIIllllIIIIlllI) {
            final PathPoint lllllllllllllIIlIlIIllllIIIIllIl = lllllllllllllIIlIlIIllllIIIlIIIl.getPathPointFromIndex(lllllllllllllIIlIlIIllllIIIIlllI);
            if (this.addDistanceToPlayer(lllllllllllllIIlIlIIllllIIIIllIl) <= 40.0f) {
                final float lllllllllllllIIlIlIIllllIIIIllII = lllllllllllllIIlIlIIllllIIIIlllI / (float)lllllllllllllIIlIlIIllllIIIlIIIl.getCurrentPathLength() * 0.33f;
                final int lllllllllllllIIlIlIIllllIIIIlIll = (lllllllllllllIIlIlIIllllIIIIlllI == 0) ? 0 : MathHelper.hsvToRGB(lllllllllllllIIlIlIIllllIIIIllII, 0.9f, 0.9f);
                final int lllllllllllllIIlIlIIllllIIIIlIlI = lllllllllllllIIlIlIIllllIIIIlIll >> 16 & 0xFF;
                final int lllllllllllllIIlIlIIllllIIIIlIIl = lllllllllllllIIlIlIIllllIIIIlIll >> 8 & 0xFF;
                final int lllllllllllllIIlIlIIllllIIIIlIII = lllllllllllllIIlIlIIllllIIIIlIll & 0xFF;
                lllllllllllllIIlIlIIllllIIIIllll.pos(lllllllllllllIIlIlIIllllIIIIllIl.xCoord - this.xo + 0.5, lllllllllllllIIlIlIIllllIIIIllIl.yCoord - this.yo + 0.5, lllllllllllllIIlIlIIllllIIIIllIl.zCoord - this.zo + 0.5).color(lllllllllllllIIlIlIIllllIIIIlIlI, lllllllllllllIIlIlIIllllIIIIlIIl, lllllllllllllIIlIlIIllllIIIIlIII, 255).endVertex();
            }
        }
        lllllllllllllIIlIlIIllllIIIlIIII.draw();
    }
    
    public DebugRendererPathfinding(final Minecraft lllllllllllllIIlIlIIllllIlIlIllI) {
        this.pathMap = (Map<Integer, Path>)Maps.newHashMap();
        this.pathMaxDistance = (Map<Integer, Float>)Maps.newHashMap();
        this.creationMap = (Map<Integer, Long>)Maps.newHashMap();
        this.minecraft = lllllllllllllIIlIlIIllllIlIlIllI;
    }
}
