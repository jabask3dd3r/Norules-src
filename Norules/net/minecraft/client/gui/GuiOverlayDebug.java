package net.minecraft.client.gui;

import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import optifine.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.text.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class GuiOverlayDebug extends Gui
{
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ FontRenderer fontRenderer;
    
    private void renderLagometer() {
    }
    
    protected void renderDebugInfoLeft() {
        final List<String> lIIIIlIlIIllIlI = this.call();
        lIIIIlIlIIllIlI.add("");
        lIIIIlIlIIllIlI.add(String.valueOf(new StringBuilder("Debug: Pie [shift]: ").append(this.mc.gameSettings.showDebugProfilerChart ? "visible" : "hidden").append(" FPS [alt]: ").append(this.mc.gameSettings.showLagometer ? "visible" : "hidden")));
        lIIIIlIlIIllIlI.add("For help: press F3 + Q");
        for (int lIIIIlIlIIllIIl = 0; lIIIIlIlIIllIIl < lIIIIlIlIIllIlI.size(); ++lIIIIlIlIIllIIl) {
            final String lIIIIlIlIIllIII = lIIIIlIlIIllIlI.get(lIIIIlIlIIllIIl);
            if (!Strings.isNullOrEmpty(lIIIIlIlIIllIII)) {
                final int lIIIIlIlIIlIlll = this.fontRenderer.FONT_HEIGHT;
                final int lIIIIlIlIIlIllI = this.fontRenderer.getStringWidth(lIIIIlIlIIllIII);
                final int lIIIIlIlIIlIlIl = 2;
                final int lIIIIlIlIIlIlII = 2 + lIIIIlIlIIlIlll * lIIIIlIlIIllIIl;
                Gui.drawRect(1.0, lIIIIlIlIIlIlII - 1, 2 + lIIIIlIlIIlIllI + 1, lIIIIlIlIIlIlII + lIIIIlIlIIlIlll - 1, -1873784752);
                this.fontRenderer.drawString(lIIIIlIlIIllIII, 2.0, lIIIIlIlIIlIlII, 14737632);
            }
        }
    }
    
    public void renderDebugInfo(final ScaledResolution lIIIIlIlIlIIlII) {
        this.mc.mcProfiler.startSection("debug");
        GlStateManager.pushMatrix();
        this.renderDebugInfoLeft();
        this.renderDebugInfoRight(lIIIIlIlIlIIlII);
        GlStateManager.popMatrix();
        if (this.mc.gameSettings.showLagometer) {
            this.renderLagometer();
        }
        this.mc.mcProfiler.endSection();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = GuiOverlayDebug.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double lIIIIIllllIllII = (Object)new int[EnumFacing.values().length];
        try {
            lIIIIIllllIllII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lIIIIIllllIllII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lIIIIIllllIllII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lIIIIIllllIllII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lIIIIIllllIllII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lIIIIIllllIllII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return GuiOverlayDebug.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lIIIIIllllIllII;
    }
    
    private static long bytesToMb(final long lIIIIIllllIlllI) {
        return lIIIIIllllIlllI / 1024L / 1024L;
    }
    
    protected <T extends Comparable<T>> List<String> getDebugInfoRight() {
        final long lIIIIlIIlIIIllI = Runtime.getRuntime().maxMemory();
        final long lIIIIlIIlIIIlIl = Runtime.getRuntime().totalMemory();
        final long lIIIIlIIlIIIlII = Runtime.getRuntime().freeMemory();
        final long lIIIIlIIlIIIIll = lIIIIlIIlIIIlIl - lIIIIlIIlIIIlII;
        final List<String> lIIIIlIIlIIIIlI = (List<String>)Lists.newArrayList((Object[])new String[] { String.format("Java: %s %dbit", System.getProperty("java.version"), this.mc.isJava64bit() ? 64 : 32), String.format("Mem: % 2d%% %03d/%03dMB", lIIIIlIIlIIIIll * 100L / lIIIIlIIlIIIllI, bytesToMb(lIIIIlIIlIIIIll), bytesToMb(lIIIIlIIlIIIllI)), String.format("Allocated: % 2d%% %03dMB", lIIIIlIIlIIIlIl * 100L / lIIIIlIIlIIIllI, bytesToMb(lIIIIlIIlIIIlIl)), "", String.format("CPU: %s", OpenGlHelper.getCpu()), "", String.format("Display: %dx%d (%s)", Display.getWidth(), Display.getHeight(), GlStateManager.glGetString(7936)), GlStateManager.glGetString(7937), GlStateManager.glGetString(7938) });
        if (Reflector.FMLCommonHandler_getBrandings.exists()) {
            final Object lIIIIlIIlIIIIIl = Reflector.call(Reflector.FMLCommonHandler_instance, new Object[0]);
            lIIIIlIIlIIIIlI.add("");
            lIIIIlIIlIIIIlI.addAll((Collection<? extends String>)Reflector.call(lIIIIlIIlIIIIIl, Reflector.FMLCommonHandler_getBrandings, false));
        }
        if (this.mc.isReducedDebug()) {
            return lIIIIlIIlIIIIlI;
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK && this.mc.objectMouseOver.getBlockPos() != null) {
            final BlockPos lIIIIlIIlIIIIII = this.mc.objectMouseOver.getBlockPos();
            IBlockState lIIIIlIIIllllll = this.mc.world.getBlockState(lIIIIlIIlIIIIII);
            if (this.mc.world.getWorldType() != WorldType.DEBUG_WORLD) {
                lIIIIlIIIllllll = lIIIIlIIIllllll.getActualState(this.mc.world, lIIIIlIIlIIIIII);
            }
            lIIIIlIIlIIIIlI.add("");
            lIIIIlIIlIIIIlI.add(String.valueOf(Block.REGISTRY.getNameForObject(lIIIIlIIIllllll.getBlock())));
            for (final Map.Entry<IProperty<?>, Comparable<?>> lIIIIlIIIlllIll : lIIIIlIIIllllll.getProperties().entrySet()) {
                final IProperty<T> lIIIIlIIIlllllI = (IProperty<T>)lIIIIlIIIlllIll.getKey();
                final T lIIIIlIIIlllIlI = (T)lIIIIlIIIlllIll.getValue();
                String lIIIIlIIIllllIl = lIIIIlIIIlllllI.getName(lIIIIlIIIlllIlI);
                if (Boolean.TRUE.equals(lIIIIlIIIlllIlI)) {
                    lIIIIlIIIllllIl = String.valueOf(new StringBuilder().append(TextFormatting.GREEN).append(lIIIIlIIIllllIl));
                }
                else if (Boolean.FALSE.equals(lIIIIlIIIlllIlI)) {
                    lIIIIlIIIllllIl = String.valueOf(new StringBuilder().append(TextFormatting.RED).append(lIIIIlIIIllllIl));
                }
                lIIIIlIIlIIIIlI.add(String.valueOf(new StringBuilder(String.valueOf(lIIIIlIIIlllllI.getName())).append(": ").append(lIIIIlIIIllllIl)));
            }
        }
        return lIIIIlIIlIIIIlI;
    }
    
    private int getFrameColor(final int lIIIIlIIIlIIIIl, final int lIIIIlIIIlIIlIl, final int lIIIIlIIIlIIIII, final int lIIIIlIIIlIIIll) {
        return (lIIIIlIIIlIIIIl < lIIIIlIIIlIIIII) ? this.blendColors(-16711936, -256, lIIIIlIIIlIIIIl / (float)lIIIIlIIIlIIIII) : this.blendColors(-256, -65536, (lIIIIlIIIlIIIIl - lIIIIlIIIlIIIII) / (float)(lIIIIlIIIlIIIll - lIIIIlIIIlIIIII));
    }
    
    private int blendColors(final int lIIIIIlllllllll, final int lIIIIIllllllllI, final float lIIIIIlllllllIl) {
        final int lIIIIlIIIIIlIll = lIIIIIlllllllll >> 24 & 0xFF;
        final int lIIIIlIIIIIlIlI = lIIIIIlllllllll >> 16 & 0xFF;
        final int lIIIIlIIIIIlIIl = lIIIIIlllllllll >> 8 & 0xFF;
        final int lIIIIlIIIIIlIII = lIIIIIlllllllll & 0xFF;
        final int lIIIIlIIIIIIlll = lIIIIIllllllllI >> 24 & 0xFF;
        final int lIIIIlIIIIIIllI = lIIIIIllllllllI >> 16 & 0xFF;
        final int lIIIIlIIIIIIlIl = lIIIIIllllllllI >> 8 & 0xFF;
        final int lIIIIlIIIIIIlII = lIIIIIllllllllI & 0xFF;
        final int lIIIIlIIIIIIIll = MathHelper.clamp((int)(lIIIIlIIIIIlIll + (lIIIIlIIIIIIlll - lIIIIlIIIIIlIll) * lIIIIIlllllllIl), 0, 255);
        final int lIIIIlIIIIIIIlI = MathHelper.clamp((int)(lIIIIlIIIIIlIlI + (lIIIIlIIIIIIllI - lIIIIlIIIIIlIlI) * lIIIIIlllllllIl), 0, 255);
        final int lIIIIlIIIIIIIIl = MathHelper.clamp((int)(lIIIIlIIIIIlIIl + (lIIIIlIIIIIIlIl - lIIIIlIIIIIlIIl) * lIIIIIlllllllIl), 0, 255);
        final int lIIIIlIIIIIIIII = MathHelper.clamp((int)(lIIIIlIIIIIlIII + (lIIIIlIIIIIIlII - lIIIIlIIIIIlIII) * lIIIIIlllllllIl), 0, 255);
        return lIIIIlIIIIIIIll << 24 | lIIIIlIIIIIIIlI << 16 | lIIIIlIIIIIIIIl << 8 | lIIIIlIIIIIIIII;
    }
    
    public GuiOverlayDebug(final Minecraft lIIIIlIlIlIlIlI) {
        this.mc = lIIIIlIlIlIlIlI;
        this.fontRenderer = lIIIIlIlIlIlIlI.fontRendererObj;
    }
    
    protected List<String> call() {
        final BlockPos lIIIIlIIllIIllI = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
        if (this.mc.isReducedDebug()) {
            return (List<String>)Lists.newArrayList((Object[])new String[] { String.valueOf(new StringBuilder("Minecraft 1.12.2 (").append(this.mc.getVersion()).append("/").append(ClientBrandRetriever.getClientModName()).append(")")), this.mc.debug, this.mc.renderGlobal.getDebugInfoRenders(), this.mc.renderGlobal.getDebugInfoEntities(), String.valueOf(new StringBuilder("P: ").append(this.mc.effectRenderer.getStatistics()).append(". T: ").append(this.mc.world.getDebugLoadedEntities())), this.mc.world.getProviderName(), "", String.format("Chunk-relative: %d %d %d", lIIIIlIIllIIllI.getX() & 0xF, lIIIIlIIllIIllI.getY() & 0xF, lIIIIlIIllIIllI.getZ() & 0xF) });
        }
        final Entity lIIIIlIIllIIlIl = this.mc.getRenderViewEntity();
        final EnumFacing lIIIIlIIllIIlII = lIIIIlIIllIIlIl.getHorizontalFacing();
        String lIIIIlIIllIIIll = "Invalid";
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lIIIIlIIllIIlII.ordinal()]) {
            case 3: {
                lIIIIlIIllIIIll = "Towards negative Z";
                break;
            }
            case 4: {
                lIIIIlIIllIIIll = "Towards positive Z";
                break;
            }
            case 5: {
                lIIIIlIIllIIIll = "Towards negative X";
                break;
            }
            case 6: {
                lIIIIlIIllIIIll = "Towards positive X";
                break;
            }
        }
        final List<String> lIIIIlIIllIIIlI = (List<String>)Lists.newArrayList((Object[])new String[] { String.valueOf(new StringBuilder("Minecraft 1.12.2 (").append(this.mc.getVersion()).append("/").append(ClientBrandRetriever.getClientModName()).append("release".equalsIgnoreCase(this.mc.getVersionType()) ? "" : String.valueOf(new StringBuilder("/").append(this.mc.getVersionType()))).append(")")), this.mc.debug, this.mc.renderGlobal.getDebugInfoRenders(), this.mc.renderGlobal.getDebugInfoEntities(), String.valueOf(new StringBuilder("P: ").append(this.mc.effectRenderer.getStatistics()).append(". T: ").append(this.mc.world.getDebugLoadedEntities())), this.mc.world.getProviderName(), "", String.format("XYZ: %.3f / %.5f / %.3f", this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ), String.format("Block: %d %d %d", lIIIIlIIllIIllI.getX(), lIIIIlIIllIIllI.getY(), lIIIIlIIllIIllI.getZ()), String.format("Chunk: %d %d %d in %d %d %d", lIIIIlIIllIIllI.getX() & 0xF, lIIIIlIIllIIllI.getY() & 0xF, lIIIIlIIllIIllI.getZ() & 0xF, lIIIIlIIllIIllI.getX() >> 4, lIIIIlIIllIIllI.getY() >> 4, lIIIIlIIllIIllI.getZ() >> 4), String.format("Facing: %s (%s) (%.1f / %.1f)", lIIIIlIIllIIlII, lIIIIlIIllIIIll, MathHelper.wrapDegrees(lIIIIlIIllIIlIl.rotationYaw), MathHelper.wrapDegrees(lIIIIlIIllIIlIl.rotationPitch)) });
        if (this.mc.world != null) {
            final Chunk lIIIIlIIllIIIIl = this.mc.world.getChunkFromBlockCoords(lIIIIlIIllIIllI);
            if (this.mc.world.isBlockLoaded(lIIIIlIIllIIllI) && lIIIIlIIllIIllI.getY() >= 0 && lIIIIlIIllIIllI.getY() < 256) {
                if (!lIIIIlIIllIIIIl.isEmpty()) {
                    lIIIIlIIllIIIlI.add(String.valueOf(new StringBuilder("Biome: ").append(lIIIIlIIllIIIIl.getBiome(lIIIIlIIllIIllI, this.mc.world.getBiomeProvider()).getBiomeName())));
                    lIIIIlIIllIIIlI.add(String.valueOf(new StringBuilder("Light: ").append(lIIIIlIIllIIIIl.getLightSubtracted(lIIIIlIIllIIllI, 0)).append(" (").append(lIIIIlIIllIIIIl.getLightFor(EnumSkyBlock.SKY, lIIIIlIIllIIllI)).append(" sky, ").append(lIIIIlIIllIIIIl.getLightFor(EnumSkyBlock.BLOCK, lIIIIlIIllIIllI)).append(" block)")));
                    DifficultyInstance lIIIIlIIllIIIII = this.mc.world.getDifficultyForLocation(lIIIIlIIllIIllI);
                    if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null) {
                        final EntityPlayerMP lIIIIlIIlIlllll = this.mc.getIntegratedServer().getPlayerList().getPlayerByUUID(this.mc.player.getUniqueID());
                        if (lIIIIlIIlIlllll != null) {
                            lIIIIlIIllIIIII = lIIIIlIIlIlllll.world.getDifficultyForLocation(new BlockPos(lIIIIlIIlIlllll));
                        }
                    }
                    lIIIIlIIllIIIlI.add(String.format("Local Difficulty: %.2f // %.2f (Day %d)", lIIIIlIIllIIIII.getAdditionalDifficulty(), lIIIIlIIllIIIII.getClampedAdditionalDifficulty(), this.mc.world.getWorldTime() / 24000L));
                }
                else {
                    lIIIIlIIllIIIlI.add("Waiting for chunk...");
                }
            }
            else {
                lIIIIlIIllIIIlI.add("Outside of world...");
            }
        }
        if (this.mc.entityRenderer != null && this.mc.entityRenderer.isShaderActive()) {
            lIIIIlIIllIIIlI.add(String.valueOf(new StringBuilder("Shader: ").append(this.mc.entityRenderer.getShaderGroup().getShaderGroupName())));
        }
        if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK && this.mc.objectMouseOver.getBlockPos() != null) {
            final BlockPos lIIIIlIIlIllllI = this.mc.objectMouseOver.getBlockPos();
            lIIIIlIIllIIIlI.add(String.format("Looking at: %d %d %d", lIIIIlIIlIllllI.getX(), lIIIIlIIlIllllI.getY(), lIIIIlIIlIllllI.getZ()));
        }
        return lIIIIlIIllIIIlI;
    }
    
    protected void renderDebugInfoRight(final ScaledResolution lIIIIlIlIIIIIIl) {
        final List<String> lIIIIlIlIIIIIII = this.getDebugInfoRight();
        for (int lIIIIlIIlllllll = 0; lIIIIlIIlllllll < lIIIIlIlIIIIIII.size(); ++lIIIIlIIlllllll) {
            final String lIIIIlIIllllllI = lIIIIlIlIIIIIII.get(lIIIIlIIlllllll);
            if (!Strings.isNullOrEmpty(lIIIIlIIllllllI)) {
                final int lIIIIlIIlllllIl = this.fontRenderer.FONT_HEIGHT;
                final int lIIIIlIIlllllII = this.fontRenderer.getStringWidth(lIIIIlIIllllllI);
                final int lIIIIlIIllllIll = lIIIIlIlIIIIIIl.getScaledWidth() - 2 - lIIIIlIIlllllII;
                final int lIIIIlIIllllIlI = 2 + lIIIIlIIlllllIl * lIIIIlIIlllllll;
                Gui.drawRect(lIIIIlIIllllIll - 1, lIIIIlIIllllIlI - 1, lIIIIlIIllllIll + lIIIIlIIlllllII + 1, lIIIIlIIllllIlI + lIIIIlIIlllllIl - 1, -1873784752);
                this.fontRenderer.drawString(lIIIIlIIllllllI, lIIIIlIIllllIll, lIIIIlIIllllIlI, 14737632);
            }
        }
    }
}
