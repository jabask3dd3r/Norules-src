package optifine;

import net.minecraft.client.settings.*;
import net.minecraft.client.*;
import net.minecraft.profiler.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.gui.*;

public class Lagometer
{
    public static /* synthetic */ TimerNano timerChunkUpdate;
    private static /* synthetic */ long memStart;
    private static /* synthetic */ long[] timesServer;
    private static /* synthetic */ long memTimeDiffMs;
    public static /* synthetic */ TimerNano timerVisibility;
    private static /* synthetic */ long[] timesChunkUpload;
    public static /* synthetic */ boolean active;
    private static /* synthetic */ int numRecordedFrameTimes;
    private static /* synthetic */ long[] timesTick;
    private static /* synthetic */ long renderTimeNano;
    private static /* synthetic */ GameSettings gameSettings;
    private static /* synthetic */ long[] timesScheduledExecutables;
    public static /* synthetic */ TimerNano timerScheduledExecutables;
    private static /* synthetic */ long memLast;
    private static /* synthetic */ long prevFrameTimeNano;
    public static /* synthetic */ TimerNano timerTick;
    private static /* synthetic */ long memTimeStartMs;
    private static /* synthetic */ long[] timesTerrain;
    private static /* synthetic */ int memMbSec;
    private static /* synthetic */ long memTimeLast;
    private static /* synthetic */ Minecraft mc;
    private static /* synthetic */ boolean[] gcs;
    public static /* synthetic */ TimerNano timerChunkUpload;
    private static /* synthetic */ long[] timesVisibility;
    public static /* synthetic */ TimerNano timerTerrain;
    private static /* synthetic */ Profiler profiler;
    public static /* synthetic */ TimerNano timerServer;
    private static /* synthetic */ long[] timesChunkUpdate;
    private static /* synthetic */ long[] timesFrame;
    private static /* synthetic */ long memDiff;
    
    private static long renderTimeDivider(final int lllllllllllllIlIIIIlIIIIIIIIllIl, final int lllllllllllllIlIIIIlIIIIIIIIllII, final long lllllllllllllIlIIIIlIIIIIIIIlIll, final int lllllllllllllIlIIIIlIIIIIIIIlIlI, final int lllllllllllllIlIIIIlIIIIIIIIlIIl, final int lllllllllllllIlIIIIlIIIIIIIIlIII, final float lllllllllllllIlIIIIlIIIIIIIIIlll, final BufferBuilder lllllllllllllIlIIIIlIIIIIIIIIllI) {
        final long lllllllllllllIlIIIIlIIIIIIIIIlIl = lllllllllllllIlIIIIlIIIIIIIIlIll / 200000L;
        if (lllllllllllllIlIIIIlIIIIIIIIIlIl < 3L) {
            return 0L;
        }
        lllllllllllllIlIIIIlIIIIIIIIIllI.pos(lllllllllllllIlIIIIlIIIIIIIIllIl + 0.5f, lllllllllllllIlIIIIlIIIIIIIIIlll - lllllllllllllIlIIIIlIIIIIIIIIlIl + 0.5f, 0.0).color(lllllllllllllIlIIIIlIIIIIIIIlIlI, lllllllllllllIlIIIIlIIIIIIIIlIIl, lllllllllllllIlIIIIlIIIIIIIIlIII, 255).endVertex();
        lllllllllllllIlIIIIlIIIIIIIIIllI.pos(lllllllllllllIlIIIIlIIIIIIIIllII + 0.5f, lllllllllllllIlIIIIlIIIIIIIIIlll - lllllllllllllIlIIIIlIIIIIIIIIlIl + 0.5f, 0.0).color(lllllllllllllIlIIIIlIIIIIIIIlIlI, lllllllllllllIlIIIIlIIIIIIIIlIIl, lllllllllllllIlIIIIlIIIIIIIIlIII, 255).endVertex();
        return lllllllllllllIlIIIIlIIIIIIIIIlIl;
    }
    
    private static long renderTime(final int lllllllllllllIlIIIIlIIIIIIIllllI, final long lllllllllllllIlIIIIlIIIIIIlIIlIl, final int lllllllllllllIlIIIIlIIIIIIlIIlII, final int lllllllllllllIlIIIIlIIIIIIIllIll, final int lllllllllllllIlIIIIlIIIIIIlIIIlI, final float lllllllllllllIlIIIIlIIIIIIlIIIIl, final BufferBuilder lllllllllllllIlIIIIlIIIIIIlIIIII) {
        final long lllllllllllllIlIIIIlIIIIIIIlllll = lllllllllllllIlIIIIlIIIIIIlIIlIl / 200000L;
        if (lllllllllllllIlIIIIlIIIIIIIlllll < 3L) {
            return 0L;
        }
        lllllllllllllIlIIIIlIIIIIIlIIIII.pos(lllllllllllllIlIIIIlIIIIIIIllllI + 0.5f, lllllllllllllIlIIIIlIIIIIIlIIIIl - lllllllllllllIlIIIIlIIIIIIIlllll + 0.5f, 0.0).color(lllllllllllllIlIIIIlIIIIIIlIIlII, lllllllllllllIlIIIIlIIIIIIIllIll, lllllllllllllIlIIIIlIIIIIIlIIIlI, 255).endVertex();
        lllllllllllllIlIIIIlIIIIIIlIIIII.pos(lllllllllllllIlIIIIlIIIIIIIllllI + 0.5f, lllllllllllllIlIIIIlIIIIIIlIIIIl + 0.5f, 0.0).color(lllllllllllllIlIIIIlIIIIIIlIIlII, lllllllllllllIlIIIIlIIIIIIIllIll, lllllllllllllIlIIIIlIIIIIIlIIIlI, 255).endVertex();
        return lllllllllllllIlIIIIlIIIIIIIlllll;
    }
    
    public static boolean updateMemoryAllocation() {
        final long lllllllllllllIlIIIIlIIIIIlllIlII = System.currentTimeMillis();
        final long lllllllllllllIlIIIIlIIIIIlllIIll = getMemoryUsed();
        boolean lllllllllllllIlIIIIlIIIIIlllIIlI = false;
        if (lllllllllllllIlIIIIlIIIIIlllIIll < Lagometer.memLast) {
            final double lllllllllllllIlIIIIlIIIIIlllIIIl = Lagometer.memDiff / 1000000.0;
            final double lllllllllllllIlIIIIlIIIIIlllIIII = Lagometer.memTimeDiffMs / 1000.0;
            final int lllllllllllllIlIIIIlIIIIIllIllll = (int)(lllllllllllllIlIIIIlIIIIIlllIIIl / lllllllllllllIlIIIIlIIIIIlllIIII);
            if (lllllllllllllIlIIIIlIIIIIllIllll > 0) {
                Lagometer.memMbSec = lllllllllllllIlIIIIlIIIIIllIllll;
            }
            Lagometer.memTimeStartMs = lllllllllllllIlIIIIlIIIIIlllIlII;
            Lagometer.memStart = lllllllllllllIlIIIIlIIIIIlllIIll;
            Lagometer.memTimeDiffMs = 0L;
            Lagometer.memDiff = 0L;
            lllllllllllllIlIIIIlIIIIIlllIIlI = true;
        }
        else {
            Lagometer.memTimeDiffMs = lllllllllllllIlIIIIlIIIIIlllIlII - Lagometer.memTimeStartMs;
            Lagometer.memDiff = lllllllllllllIlIIIIlIIIIIlllIIll - Lagometer.memStart;
        }
        Lagometer.memTimeLast = lllllllllllllIlIIIIlIIIIIlllIlII;
        Lagometer.memLast = lllllllllllllIlIIIIlIIIIIlllIIll;
        return lllllllllllllIlIIIIlIIIIIlllIIlI;
    }
    
    public static void showLagometer(final ScaledResolution lllllllllllllIlIIIIlIIIIIlIIlllI) {
        if (Lagometer.gameSettings != null && (Lagometer.gameSettings.ofLagometer || Lagometer.gameSettings.showLagometer)) {
            final long lllllllllllllIlIIIIlIIIIIlIIllIl = System.nanoTime();
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.pushMatrix();
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, Lagometer.mc.displayWidth, Lagometer.mc.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GlStateManager.disableTexture2D();
            final Tessellator lllllllllllllIlIIIIlIIIIIlIIllII = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIlIIIIlIIIIIlIIlIll = lllllllllllllIlIIIIlIIIIIlIIllII.getBuffer();
            lllllllllllllIlIIIIlIIIIIlIIlIll.begin(1, DefaultVertexFormats.POSITION_COLOR);
            for (int lllllllllllllIlIIIIlIIIIIlIIlIlI = 0; lllllllllllllIlIIIIlIIIIIlIIlIlI < Lagometer.timesFrame.length; ++lllllllllllllIlIIIIlIIIIIlIIlIlI) {
                int lllllllllllllIlIIIIlIIIIIlIIlIIl = (lllllllllllllIlIIIIlIIIIIlIIlIlI - Lagometer.numRecordedFrameTimes & Lagometer.timesFrame.length - 1) * 100 / Lagometer.timesFrame.length;
                lllllllllllllIlIIIIlIIIIIlIIlIIl += 155;
                float lllllllllllllIlIIIIlIIIIIlIIlIII = (float)Lagometer.mc.displayHeight;
                final long lllllllllllllIlIIIIlIIIIIlIIIlll = 0L;
                if (Lagometer.gcs[lllllllllllllIlIIIIlIIIIIlIIlIlI]) {
                    renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesFrame[lllllllllllllIlIIIIlIIIIIlIIlIlI], lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIIl / 2, 0, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                }
                else {
                    renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesFrame[lllllllllllllIlIIIIlIIIIIlIIlIlI], lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    lllllllllllllIlIIIIlIIIIIlIIlIII -= renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesServer[lllllllllllllIlIIIIlIIIIIlIIlIlI], lllllllllllllIlIIIIlIIIIIlIIlIIl / 2, lllllllllllllIlIIIIlIIIIIlIIlIIl / 2, lllllllllllllIlIIIIlIIIIIlIIlIIl / 2, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    lllllllllllllIlIIIIlIIIIIlIIlIII -= renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesTerrain[lllllllllllllIlIIIIlIIIIIlIIlIlI], 0, lllllllllllllIlIIIIlIIIIIlIIlIIl, 0, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    lllllllllllllIlIIIIlIIIIIlIIlIII -= renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesVisibility[lllllllllllllIlIIIIlIIIIIlIIlIlI], lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIIl, 0, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    lllllllllllllIlIIIIlIIIIIlIIlIII -= renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesChunkUpdate[lllllllllllllIlIIIIlIIIIIlIIlIlI], lllllllllllllIlIIIIlIIIIIlIIlIIl, 0, 0, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    lllllllllllllIlIIIIlIIIIIlIIlIII -= renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesChunkUpload[lllllllllllllIlIIIIlIIIIIlIIlIlI], lllllllllllllIlIIIIlIIIIIlIIlIIl, 0, lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    lllllllllllllIlIIIIlIIIIIlIIlIII -= renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesScheduledExecutables[lllllllllllllIlIIIIlIIIIIlIIlIlI], 0, 0, lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                    final float n = lllllllllllllIlIIIIlIIIIIlIIlIII - renderTime(lllllllllllllIlIIIIlIIIIIlIIlIlI, Lagometer.timesTick[lllllllllllllIlIIIIlIIIIIlIIlIlI], 0, lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIIl, lllllllllllllIlIIIIlIIIIIlIIlIII, lllllllllllllIlIIIIlIIIIIlIIlIll);
                }
            }
            renderTimeDivider(0, Lagometer.timesFrame.length, 33333333L, 196, 196, 196, (float)Lagometer.mc.displayHeight, lllllllllllllIlIIIIlIIIIIlIIlIll);
            renderTimeDivider(0, Lagometer.timesFrame.length, 16666666L, 196, 196, 196, (float)Lagometer.mc.displayHeight, lllllllllllllIlIIIIlIIIIIlIIlIll);
            lllllllllllllIlIIIIlIIIIIlIIllII.draw();
            GlStateManager.enableTexture2D();
            final int lllllllllllllIlIIIIlIIIIIlIIIllI = Lagometer.mc.displayHeight - 80;
            final int lllllllllllllIlIIIIlIIIIIlIIIlIl = Lagometer.mc.displayHeight - 160;
            Lagometer.mc.fontRendererObj.drawString("30", 2.0, lllllllllllllIlIIIIlIIIIIlIIIlIl + 1, -8947849);
            Lagometer.mc.fontRendererObj.drawString("30", 1.0, lllllllllllllIlIIIIlIIIIIlIIIlIl, -3881788);
            Lagometer.mc.fontRendererObj.drawString("60", 2.0, lllllllllllllIlIIIIlIIIIIlIIIllI + 1, -8947849);
            Lagometer.mc.fontRendererObj.drawString("60", 1.0, lllllllllllllIlIIIIlIIIIIlIIIllI, -3881788);
            GlStateManager.matrixMode(5889);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.enableTexture2D();
            float lllllllllllllIlIIIIlIIIIIlIIIlII = 1.0f - (float)((System.currentTimeMillis() - Lagometer.memTimeStartMs) / 1000.0);
            lllllllllllllIlIIIIlIIIIIlIIIlII = Config.limit(lllllllllllllIlIIIIlIIIIIlIIIlII, 0.0f, 1.0f);
            final int lllllllllllllIlIIIIlIIIIIlIIIIll = (int)(170.0f + lllllllllllllIlIIIIlIIIIIlIIIlII * 85.0f);
            final int lllllllllllllIlIIIIlIIIIIlIIIIlI = (int)(100.0f + lllllllllllllIlIIIIlIIIIIlIIIlII * 55.0f);
            final int lllllllllllllIlIIIIlIIIIIlIIIIIl = (int)(10.0f + lllllllllllllIlIIIIlIIIIIlIIIlII * 10.0f);
            final int lllllllllllllIlIIIIlIIIIIlIIIIII = lllllllllllllIlIIIIlIIIIIlIIIIll << 16 | lllllllllllllIlIIIIlIIIIIlIIIIlI << 8 | lllllllllllllIlIIIIlIIIIIlIIIIIl;
            final int lllllllllllllIlIIIIlIIIIIIllllll = 512 / lllllllllllllIlIIIIlIIIIIlIIlllI.getScaleFactor() + 2;
            final int lllllllllllllIlIIIIlIIIIIIlllllI = Lagometer.mc.displayHeight / lllllllllllllIlIIIIlIIIIIlIIlllI.getScaleFactor() - 8;
            final GuiIngame lllllllllllllIlIIIIlIIIIIIllllIl = Lagometer.mc.ingameGUI;
            Gui.drawRect(lllllllllllllIlIIIIlIIIIIIllllll - 1, lllllllllllllIlIIIIlIIIIIIlllllI - 1, lllllllllllllIlIIIIlIIIIIIllllll + 50, lllllllllllllIlIIIIlIIIIIIlllllI + 10, -1605349296);
            Lagometer.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder(" ").append(Lagometer.memMbSec).append(" MB/s")), lllllllllllllIlIIIIlIIIIIIllllll, lllllllllllllIlIIIIlIIIIIIlllllI, lllllllllllllIlIIIIlIIIIIlIIIIII);
            Lagometer.renderTimeNano = System.nanoTime() - lllllllllllllIlIIIIlIIIIIlIIllIl;
        }
    }
    
    static {
        Lagometer.active = false;
        Lagometer.timerTick = new TimerNano();
        Lagometer.timerScheduledExecutables = new TimerNano();
        Lagometer.timerChunkUpload = new TimerNano();
        Lagometer.timerChunkUpdate = new TimerNano();
        Lagometer.timerVisibility = new TimerNano();
        Lagometer.timerTerrain = new TimerNano();
        Lagometer.timerServer = new TimerNano();
        Lagometer.timesFrame = new long[512];
        Lagometer.timesTick = new long[512];
        Lagometer.timesScheduledExecutables = new long[512];
        Lagometer.timesChunkUpload = new long[512];
        Lagometer.timesChunkUpdate = new long[512];
        Lagometer.timesVisibility = new long[512];
        Lagometer.timesTerrain = new long[512];
        Lagometer.timesServer = new long[512];
        Lagometer.gcs = new boolean[512];
        Lagometer.numRecordedFrameTimes = 0;
        Lagometer.prevFrameTimeNano = -1L;
        Lagometer.renderTimeNano = 0L;
        Lagometer.memTimeStartMs = System.currentTimeMillis();
        Lagometer.memStart = getMemoryUsed();
        Lagometer.memTimeLast = Lagometer.memTimeStartMs;
        Lagometer.memLast = Lagometer.memStart;
        Lagometer.memTimeDiffMs = 1L;
        Lagometer.memDiff = 0L;
        Lagometer.memMbSec = 0;
    }
    
    public static boolean isActive() {
        return Lagometer.active;
    }
    
    private static long getMemoryUsed() {
        final Runtime lllllllllllllIlIIIIlIIIIIllIIlll = Runtime.getRuntime();
        return lllllllllllllIlIIIIlIIIIIllIIlll.totalMemory() - lllllllllllllIlIIIIlIIIIIllIIlll.freeMemory();
    }
    
    public static void updateLagometer() {
        if (Lagometer.mc == null) {
            Lagometer.mc = Minecraft.getMinecraft();
            Lagometer.gameSettings = Lagometer.mc.gameSettings;
            Lagometer.profiler = Lagometer.mc.mcProfiler;
        }
        if (Lagometer.gameSettings.showDebugInfo && (Lagometer.gameSettings.ofLagometer || Lagometer.gameSettings.showLagometer)) {
            Lagometer.active = true;
            final long lllllllllllllIlIIIIlIIIIIllIIIlI = System.nanoTime();
            if (Lagometer.prevFrameTimeNano == -1L) {
                Lagometer.prevFrameTimeNano = lllllllllllllIlIIIIlIIIIIllIIIlI;
            }
            else {
                final int lllllllllllllIlIIIIlIIIIIllIIIIl = Lagometer.numRecordedFrameTimes & Lagometer.timesFrame.length - 1;
                ++Lagometer.numRecordedFrameTimes;
                final boolean lllllllllllllIlIIIIlIIIIIllIIIII = updateMemoryAllocation();
                Lagometer.timesFrame[lllllllllllllIlIIIIlIIIIIllIIIIl] = lllllllllllllIlIIIIlIIIIIllIIIlI - Lagometer.prevFrameTimeNano - Lagometer.renderTimeNano;
                Lagometer.timesTick[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerTick.timeNano;
                Lagometer.timesScheduledExecutables[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerScheduledExecutables.timeNano;
                Lagometer.timesChunkUpload[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerChunkUpload.timeNano;
                Lagometer.timesChunkUpdate[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerChunkUpdate.timeNano;
                Lagometer.timesVisibility[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerVisibility.timeNano;
                Lagometer.timesTerrain[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerTerrain.timeNano;
                Lagometer.timesServer[lllllllllllllIlIIIIlIIIIIllIIIIl] = Lagometer.timerServer.timeNano;
                Lagometer.gcs[lllllllllllllIlIIIIlIIIIIllIIIIl] = lllllllllllllIlIIIIlIIIIIllIIIII;
                Lagometer.timerTick.reset();
                Lagometer.timerScheduledExecutables.reset();
                Lagometer.timerVisibility.reset();
                Lagometer.timerChunkUpdate.reset();
                Lagometer.timerChunkUpload.reset();
                Lagometer.timerTerrain.reset();
                Lagometer.timerServer.reset();
                Lagometer.prevFrameTimeNano = System.nanoTime();
            }
        }
        else {
            Lagometer.active = false;
            Lagometer.prevFrameTimeNano = -1L;
        }
    }
    
    public static class TimerNano
    {
        public /* synthetic */ long timeNano;
        public /* synthetic */ long timeStartNano;
        
        public TimerNano() {
            this.timeStartNano = 0L;
            this.timeNano = 0L;
        }
        
        public void start() {
            if (Lagometer.active && this.timeStartNano == 0L) {
                this.timeStartNano = System.nanoTime();
            }
        }
        
        public void end() {
            if (Lagometer.active && this.timeStartNano != 0L) {
                this.timeNano += System.nanoTime() - this.timeStartNano;
                this.timeStartNano = 0L;
            }
        }
        
        private void reset() {
            this.timeNano = 0L;
            this.timeStartNano = 0L;
        }
    }
}
