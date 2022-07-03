package net.minecraft.client;

import net.minecraft.client.shader.*;
import net.minecraft.client.particle.*;
import javax.annotation.*;
import net.minecraft.client.renderer.color.*;
import net.minecraft.client.renderer.debug.*;
import net.minecraft.client.gui.toasts.*;
import net.minecraft.client.renderer.entity.*;
import com.mojang.authlib.properties.*;
import net.minecraft.client.tutorial.*;
import net.minecraft.server.integrated.*;
import net.minecraft.client.audio.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.profiler.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.settings.*;
import org.lwjgl.input.*;
import java.io.*;
import net.minecraft.item.crafting.*;
import net.minecraft.server.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.chunk.*;
import javax.imageio.*;
import java.awt.image.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import org.apache.commons.lang3.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.math.*;
import java.text.*;
import net.minecraft.client.renderer.*;
import net.minecraft.stats.*;
import com.google.common.hash.*;
import org.apache.commons.io.*;
import org.lwjgl.*;
import me.nrules.*;
import net.minecraft.client.gui.recipebook.*;
import java.util.stream.*;
import net.minecraft.client.main.*;
import com.mojang.authlib.yggdrasil.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.util.datafix.*;
import me.nrules.event.events.*;
import net.minecraft.world.chunk.storage.*;
import net.minecraft.client.multiplayer.*;
import java.nio.*;
import org.lwjgl.util.glu.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.gui.advancements.*;
import net.minecraft.network.play.client.*;
import net.minecraft.client.renderer.texture.*;
import java.util.concurrent.*;
import com.google.common.util.concurrent.*;
import net.minecraft.crash.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.chat.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.server.management.*;
import net.minecraft.tileentity.*;
import com.mojang.authlib.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import java.util.function.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.network.*;
import net.minecraft.network.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.login.client.*;
import net.minecraft.world.storage.*;
import java.net.*;
import net.minecraft.client.util.*;
import net.minecraft.client.resources.data.*;

public class Minecraft implements IThreadListener, ISnooperInfo
{
    private final /* synthetic */ File fileResourcepacks;
    private final /* synthetic */ File fileAssets;
    private final /* synthetic */ String versionType;
    public /* synthetic */ boolean renderChunksMany;
    private /* synthetic */ MusicTicker mcMusicTicker;
    private /* synthetic */ Framebuffer framebufferMc;
    private /* synthetic */ int leftClickCounter;
    public /* synthetic */ ParticleManager effectRenderer;
    public /* synthetic */ WorldClient world;
    private /* synthetic */ ItemColors itemColors;
    public /* synthetic */ CreativeSettings field_191950_u;
    public /* synthetic */ LoadingScreenRenderer loadingScreen;
    private /* synthetic */ long debugUpdateTime;
    private /* synthetic */ boolean integratedServerIsRunning;
    @Nullable
    private /* synthetic */ NetworkManager myNetworkManager;
    private /* synthetic */ BlockColors blockColors;
    public /* synthetic */ boolean inGameHasFocus;
    private static /* synthetic */ Minecraft theMinecraft;
    volatile /* synthetic */ boolean running;
    private /* synthetic */ int fpsCounter;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
    private final /* synthetic */ DataFixer dataFixer;
    public final /* synthetic */ FrameTimer frameTimer;
    private final /* synthetic */ List<IResourcePack> defaultResourcePacks;
    private /* synthetic */ RenderItem renderItem;
    public /* synthetic */ DebugRenderer debugRenderer;
    public /* synthetic */ RenderGlobal renderGlobal;
    private /* synthetic */ ServerData currentServerData;
    private /* synthetic */ boolean fullscreen;
    public /* synthetic */ int displayHeight;
    private final /* synthetic */ Snooper usageSnooper;
    public /* synthetic */ GuiIngame ingameGUI;
    /* synthetic */ long startNanoTime;
    public static /* synthetic */ double frameTime;
    public /* synthetic */ GameSettings gameSettings;
    private final /* synthetic */ GuiToast field_193034_aS;
    private /* synthetic */ RenderManager renderManager;
    public final /* synthetic */ Timer timer;
    private /* synthetic */ boolean connectedToRealms;
    private final /* synthetic */ int tempDisplayHeight;
    public /* synthetic */ RayTraceResult objectMouseOver;
    public static /* synthetic */ int debugFPS;
    private /* synthetic */ ItemRenderer itemRenderer;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ TextureMap textureMapBlocks;
    private /* synthetic */ String serverName;
    private final /* synthetic */ int tempDisplayWidth;
    private final /* synthetic */ boolean isDemo;
    public final /* synthetic */ File mcDataDir;
    @Nullable
    public /* synthetic */ GuiScreen currentScreen;
    private final /* synthetic */ PropertyMap profileProperties;
    private /* synthetic */ int serverPort;
    private static final /* synthetic */ ResourceLocation LOCATION_MOJANG_PNG;
    private final /* synthetic */ Tutorial field_193035_aW;
    public /* synthetic */ boolean skipRenderWorld;
    private final /* synthetic */ PropertyMap twitchDetails;
    private /* synthetic */ LanguageManager mcLanguageManager;
    private /* synthetic */ boolean hasCrashed;
    private final /* synthetic */ MetadataSerializer metadataSerializer_;
    private /* synthetic */ ResourcePackRepository mcResourcePackRepository;
    public /* synthetic */ EntityRenderer entityRenderer;
    public static /* synthetic */ byte[] memoryReserve;
    /* synthetic */ long systemTime;
    private /* synthetic */ CrashReport crashReporter;
    public static final /* synthetic */ boolean IS_RUNNING_ON_MAC;
    public /* synthetic */ MouseHelper mouseHelper;
    private static final /* synthetic */ List<DisplayMode> MAC_DISPLAY_MODES;
    public /* synthetic */ Session session;
    private /* synthetic */ float field_193996_ah;
    private /* synthetic */ BlockRendererDispatcher blockRenderDispatcher;
    public /* synthetic */ FontRenderer standardGalacticFontRenderer;
    public /* synthetic */ int displayWidth;
    private /* synthetic */ SkinManager skinManager;
    @Nullable
    private /* synthetic */ IntegratedServer theIntegratedServer;
    private /* synthetic */ boolean isGamePaused;
    public /* synthetic */ String debug;
    private final /* synthetic */ Proxy proxy;
    private final /* synthetic */ Queue<FutureTask<?>> scheduledTasks;
    private final /* synthetic */ boolean jvm64bit;
    private final /* synthetic */ DefaultResourcePack mcDefaultResourcePack;
    private /* synthetic */ SoundHandler mcSoundHandler;
    private final /* synthetic */ Thread mcThread;
    private /* synthetic */ boolean actionKeyF3;
    private final /* synthetic */ MinecraftSessionService sessionService;
    public final /* synthetic */ Profiler mcProfiler;
    private /* synthetic */ SearchTreeManager field_193995_ae;
    private /* synthetic */ long debugCrashKeyPressTime;
    public /* synthetic */ EntityPlayerSP player;
    public /* synthetic */ int rightClickDelayTimer;
    private /* synthetic */ TextureManager renderEngine;
    private final /* synthetic */ String launchedVersion;
    public /* synthetic */ FontRenderer fontRendererObj;
    private /* synthetic */ ISaveFormat saveLoader;
    private /* synthetic */ ModelManager modelManager;
    private /* synthetic */ IReloadableResourceManager mcResourceManager;
    private /* synthetic */ ResourceLocation mojangLogo;
    private /* synthetic */ int joinPlayerCounter;
    @Nullable
    private /* synthetic */ Entity renderViewEntity;
    private /* synthetic */ String debugProfilerName;
    public /* synthetic */ PlayerControllerMP playerController;
    /* synthetic */ long prevFrameTime;
    
    public void displayGuiScreen(@Nullable GuiScreen lIlIlIlllIIIIII) {
        if (this.currentScreen != null) {
            this.currentScreen.onGuiClosed();
        }
        if (lIlIlIlllIIIIII == null && this.world == null) {
            lIlIlIlllIIIIII = new GuiMainMenu();
        }
        else if (lIlIlIlllIIIIII == null && this.player.getHealth() <= 0.0f) {
            lIlIlIlllIIIIII = new GuiGameOver(null);
        }
        if (lIlIlIlllIIIIII instanceof GuiMainMenu || lIlIlIlllIIIIII instanceof GuiMultiplayer) {
            this.gameSettings.showDebugInfo = false;
            this.ingameGUI.getChatGUI().clearChatMessages(true);
        }
        if ((this.currentScreen = lIlIlIlllIIIIII) != null) {
            this.setIngameNotInFocus();
            KeyBinding.unPressAllKeys();
            while (Mouse.next()) {}
            while (Keyboard.next()) {}
            final ScaledResolution lIlIlIlllIIIlII = new ScaledResolution(this);
            final int lIlIlIlllIIIIll = lIlIlIlllIIIlII.getScaledWidth();
            final int lIlIlIlllIIIIlI = lIlIlIlllIIIlII.getScaledHeight();
            lIlIlIlllIIIIII.setWorldAndResolution(this, lIlIlIlllIIIIll, lIlIlIlllIIIIlI);
            this.skipRenderWorld = false;
        }
        else {
            this.mcSoundHandler.resumeSounds();
            this.setIngameFocus();
        }
    }
    
    public TextureMap getTextureMapBlocks() {
        return this.textureMapBlocks;
    }
    
    public MusicTicker getMusicTicker() {
        return this.mcMusicTicker;
    }
    
    private void setWindowIcon() {
        final Util.EnumOS lIlIllIlIIIlIlI = Util.getOSType();
        if (lIlIllIlIIIlIlI != Util.EnumOS.OSX) {
            InputStream lIlIllIlIIIlIIl = null;
            InputStream lIlIllIlIIIlIII = null;
            try {
                lIlIllIlIIIlIIl = Minecraft.class.getResourceAsStream("/assets/minecraft/icon16.png");
                lIlIllIlIIIlIII = Minecraft.class.getResourceAsStream("/assets/minecraft/icon32.png");
                if (lIlIllIlIIIlIIl != null && lIlIllIlIIIlIII != null) {
                    Display.setIcon(new ByteBuffer[] { this.readImageToBuffer(lIlIllIlIIIlIIl), this.readImageToBuffer(lIlIllIlIIIlIII) });
                }
            }
            catch (IOException lIlIllIlIIIIlll) {
                Minecraft.LOGGER.error("Couldn't set icon", (Throwable)lIlIllIlIIIIlll);
                return;
            }
            finally {
                IOUtils.closeQuietly(lIlIllIlIIIlIIl);
                IOUtils.closeQuietly(lIlIllIlIIIlIII);
            }
            IOUtils.closeQuietly(lIlIllIlIIIlIIl);
            IOUtils.closeQuietly(lIlIllIlIIIlIII);
        }
    }
    
    public float func_193989_ak() {
        return (float)this.timer.elapsedTicks;
    }
    
    @Override
    public void addServerStatsToSnooper(final Snooper lIlIIlllIlIIIIl) {
        lIlIIlllIlIIIIl.addClientStat("fps", Minecraft.debugFPS);
        lIlIIlllIlIIIIl.addClientStat("vsync_enabled", this.gameSettings.enableVsync);
        lIlIIlllIlIIIIl.addClientStat("display_frequency", Display.getDisplayMode().getFrequency());
        lIlIIlllIlIIIIl.addClientStat("display_type", this.fullscreen ? "fullscreen" : "windowed");
        lIlIIlllIlIIIIl.addClientStat("run_time", (MinecraftServer.getCurrentTimeMillis() - lIlIIlllIlIIIIl.getMinecraftStartTimeMillis()) / 60L * 1000L);
        lIlIIlllIlIIIIl.addClientStat("current_action", this.getCurrentAction());
        lIlIIlllIlIIIIl.addClientStat("language", (this.gameSettings.language == null) ? "en_us" : this.gameSettings.language);
        final String lIlIIlllIlIIlIl = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) ? "little" : "big";
        lIlIIlllIlIIIIl.addClientStat("endianness", lIlIIlllIlIIlIl);
        lIlIIlllIlIIIIl.addClientStat("subtitles", this.gameSettings.showSubtitles);
        lIlIIlllIlIIIIl.addClientStat("touch", this.gameSettings.touchscreen ? "touch" : "mouse");
        lIlIIlllIlIIIIl.addClientStat("resource_packs", this.mcResourcePackRepository.getRepositoryEntries().size());
        int lIlIIlllIlIIlII = 0;
        for (final ResourcePackRepository.Entry lIlIIlllIlIIIll : this.mcResourcePackRepository.getRepositoryEntries()) {
            lIlIIlllIlIIIIl.addClientStat(String.valueOf(new StringBuilder("resource_pack[").append(lIlIIlllIlIIlII++).append("]")), lIlIIlllIlIIIll.getResourcePackName());
        }
        if (this.theIntegratedServer != null && this.theIntegratedServer.getPlayerUsageSnooper() != null) {
            lIlIIlllIlIIIIl.addClientStat("snooper_partner", this.theIntegratedServer.getPlayerUsageSnooper().getUniqueID());
        }
    }
    
    public void displayCrashReport(final CrashReport lIlIllIIlIlIlIl) {
        final File lIlIllIIlIlIlll = new File(getMinecraft().mcDataDir, "crash-reports");
        final File lIlIllIIlIlIllI = new File(lIlIllIIlIlIlll, String.valueOf(new StringBuilder("crash-").append(new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date())).append("-client.txt")));
        Bootstrap.printToSYSOUT(lIlIllIIlIlIlIl.getCompleteReport());
        if (lIlIllIIlIlIlIl.getFile() != null) {
            Bootstrap.printToSYSOUT(String.valueOf(new StringBuilder("#@!@# Game crashed! Crash report saved to: #@!@# ").append(lIlIllIIlIlIlIl.getFile())));
            System.exit(-1);
        }
        else if (lIlIllIIlIlIlIl.saveToFile(lIlIllIIlIlIllI)) {
            Bootstrap.printToSYSOUT(String.valueOf(new StringBuilder("#@!@# Game crashed! Crash report saved to: #@!@# ").append(lIlIllIIlIlIllI.getAbsolutePath())));
            System.exit(-1);
        }
        else {
            Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }
    
    public boolean isUnicode() {
        return this.mcLanguageManager.isCurrentLocaleUnicode() || this.gameSettings.forceUnicodeFont;
    }
    
    private void clickMouse() {
        if (this.leftClickCounter <= 0) {
            if (this.objectMouseOver == null) {
                Minecraft.LOGGER.error("Null returned as 'hitResult', this shouldn't happen!");
                if (this.playerController.isNotCreative()) {
                    this.leftClickCounter = 10;
                }
            }
            else if (!this.player.isRowingBoat()) {
                switch ($SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type()[this.objectMouseOver.typeOfHit.ordinal()]) {
                    case 3: {
                        this.playerController.attackEntity(this.player, this.objectMouseOver.entityHit);
                        break;
                    }
                    case 2: {
                        final BlockPos lIlIlIIlllIIllI = this.objectMouseOver.getBlockPos();
                        if (this.world.getBlockState(lIlIlIIlllIIllI).getMaterial() != Material.AIR) {
                            this.playerController.clickBlock(lIlIlIIlllIIllI, this.objectMouseOver.sideHit);
                            break;
                        }
                    }
                    case 1: {
                        if (this.playerController.isNotCreative()) {
                            this.leftClickCounter = 10;
                        }
                        this.player.resetCooldown();
                        break;
                    }
                }
                this.player.swingArm(EnumHand.MAIN_HAND);
            }
        }
    }
    
    public String getVersionType() {
        return this.versionType;
    }
    
    public void displayInGameMenu() {
        if (this.currentScreen == null) {
            this.displayGuiScreen(new GuiIngameMenu());
            if (this.isSingleplayer() && !this.theIntegratedServer.getPublic()) {
                this.mcSoundHandler.pauseSounds();
            }
        }
    }
    
    public void setServerData(final ServerData lIlIIllIlllllll) {
        this.currentServerData = lIlIIllIlllllll;
    }
    
    private void startTimerHackThread() {
        final Thread lIlIllIIllIIlIl = new Thread("Timer hack thread") {
            @Override
            public void run() {
                while (Minecraft.this.running) {
                    try {
                        Thread.sleep(2147483647L);
                    }
                    catch (InterruptedException ex) {}
                }
            }
        };
        lIlIllIIllIIlIl.setDaemon(true);
        lIlIllIIllIIlIl.start();
    }
    
    public void setIngameFocus() {
        if (Display.isActive() && !this.inGameHasFocus) {
            if (!Minecraft.IS_RUNNING_ON_MAC) {
                KeyBinding.updateKeyBindState();
            }
            this.inGameHasFocus = true;
            this.mouseHelper.grabMouseCursor();
            this.displayGuiScreen(null);
            this.leftClickCounter = 10000;
        }
    }
    
    private void runGameLoop() throws IOException {
        final long lIlIlIllIlIIlII = System.nanoTime();
        this.mcProfiler.startSection("root");
        if (Display.isCreated() && Display.isCloseRequested()) {
            this.shutdown();
        }
        this.timer.updateTimer();
        this.mcProfiler.startSection("scheduledExecutables");
        synchronized (this.scheduledTasks) {
            while (!this.scheduledTasks.isEmpty()) {
                Util.runTask(this.scheduledTasks.poll(), Minecraft.LOGGER);
            }
        }
        // monitorexit(this.scheduledTasks)
        this.mcProfiler.endSection();
        final long lIlIlIllIlIIIll = System.nanoTime();
        this.mcProfiler.startSection("tick");
        for (int lIlIlIllIlIIIlI = 0; lIlIlIllIlIIIlI < Math.min(10, this.timer.elapsedTicks); ++lIlIlIllIlIIIlI) {
            this.runTick();
        }
        this.mcProfiler.endStartSection("preRenderErrors");
        final long lIlIlIllIlIIIIl = System.nanoTime() - lIlIlIllIlIIIll;
        this.checkGLError("Pre render");
        this.mcProfiler.endStartSection("sound");
        this.mcSoundHandler.setListener(this.player, this.timer.elapsedPartialTicks);
        this.mcProfiler.endSection();
        this.mcProfiler.startSection("render");
        GlStateManager.pushMatrix();
        GlStateManager.clear(16640);
        this.framebufferMc.bindFramebuffer(true);
        this.mcProfiler.startSection("display");
        GlStateManager.enableTexture2D();
        this.mcProfiler.endSection();
        if (!this.skipRenderWorld) {
            this.mcProfiler.endStartSection("gameRenderer");
            this.entityRenderer.updateCameraAndRender(this.isGamePaused ? this.field_193996_ah : this.timer.elapsedPartialTicks, lIlIlIllIlIIlII);
            this.mcProfiler.endStartSection("toasts");
            this.field_193034_aS.func_191783_a(new ScaledResolution(this));
            this.mcProfiler.endSection();
        }
        this.mcProfiler.endSection();
        if (this.gameSettings.showDebugInfo && this.gameSettings.showDebugProfilerChart && !this.gameSettings.hideGUI) {
            if (!this.mcProfiler.profilingEnabled) {
                this.mcProfiler.clearProfiling();
            }
            this.mcProfiler.profilingEnabled = true;
            this.displayDebugInfo(lIlIlIllIlIIIIl);
        }
        else {
            this.mcProfiler.profilingEnabled = false;
            this.prevFrameTime = System.nanoTime();
        }
        this.framebufferMc.unbindFramebuffer();
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.framebufferMc.framebufferRender(this.displayWidth, this.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        this.entityRenderer.renderStreamIndicator(this.timer.elapsedPartialTicks);
        GlStateManager.popMatrix();
        this.mcProfiler.startSection("root");
        this.updateDisplay();
        Thread.yield();
        this.checkGLError("Post render");
        ++this.fpsCounter;
        final boolean lIlIlIllIlIIIII = this.isSingleplayer() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame() && !this.theIntegratedServer.getPublic();
        if (this.isGamePaused != lIlIlIllIlIIIII) {
            if (this.isGamePaused) {
                this.field_193996_ah = this.timer.elapsedPartialTicks;
            }
            else {
                this.timer.elapsedPartialTicks = this.field_193996_ah;
            }
            this.isGamePaused = lIlIlIllIlIIIII;
        }
        final long lIlIlIllIIlllll = System.nanoTime();
        this.frameTimer.addFrame(lIlIlIllIIlllll - this.startNanoTime);
        this.startNanoTime = lIlIlIllIIlllll;
        while (getSystemTime() >= this.debugUpdateTime + 1000L) {
            Minecraft.debugFPS = this.fpsCounter;
            this.debug = String.format("%d fps (%d chunk update%s) T: %s%s%s%s%s", Minecraft.debugFPS, RenderChunk.renderChunksUpdated, (RenderChunk.renderChunksUpdated == 1) ? "" : "s", (this.gameSettings.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax()) ? "inf" : Integer.valueOf(this.gameSettings.limitFramerate), this.gameSettings.enableVsync ? " vsync" : "", this.gameSettings.fancyGraphics ? "" : " fast", (this.gameSettings.clouds == 0) ? "" : ((this.gameSettings.clouds == 1) ? " fast-clouds" : " fancy-clouds"), OpenGlHelper.useVbo() ? " vbo" : "");
            RenderChunk.renderChunksUpdated = 0;
            this.debugUpdateTime += 1000L;
            this.fpsCounter = 0;
            this.usageSnooper.addMemoryStatsToSnooper();
            if (!this.usageSnooper.isSnooperRunning()) {
                this.usageSnooper.startSnooper();
            }
        }
        if (this.isFramerateLimitBelowMax()) {
            this.mcProfiler.startSection("fpslimit_wait");
            Display.sync(this.getLimitFramerate());
            this.mcProfiler.endSection();
        }
        Minecraft.frameTime = (System.nanoTime() - lIlIlIllIlIIlII) / 1000000.0;
        this.mcProfiler.endSection();
    }
    
    private ByteBuffer readImageToBuffer(final InputStream lIlIllIIIllIlIl) throws IOException {
        final BufferedImage lIlIllIIIlllIIl = ImageIO.read(lIlIllIIIllIlIl);
        final int[] lIlIllIIIlllIII = lIlIllIIIlllIIl.getRGB(0, 0, lIlIllIIIlllIIl.getWidth(), lIlIllIIIlllIIl.getHeight(), null, 0, lIlIllIIIlllIIl.getWidth());
        final ByteBuffer lIlIllIIIllIlll = ByteBuffer.allocate(4 * lIlIllIIIlllIII.length);
        final byte lIlIllIIIlIlllI;
        final double lIlIllIIIlIllll = ((int[])(Object)(lIlIllIIIlIlllI = (byte)(Object)lIlIllIIIlllIII)).length;
        for (char lIlIllIIIllIIII = '\0'; lIlIllIIIllIIII < lIlIllIIIlIllll; ++lIlIllIIIllIIII) {
            final int lIlIllIIIllIllI = lIlIllIIIlIlllI[lIlIllIIIllIIII];
            lIlIllIIIllIlll.putInt(lIlIllIIIllIllI << 8 | (lIlIllIIIllIllI >> 24 & 0xFF));
        }
        lIlIllIIIllIlll.flip();
        return lIlIllIIIllIlll;
    }
    
    private void middleClickMouse() {
        if (this.objectMouseOver != null && this.objectMouseOver.typeOfHit != RayTraceResult.Type.MISS) {
            final boolean lIlIIlllllIlIll = this.player.capabilities.isCreativeMode;
            TileEntity lIlIIlllllIlIlI = null;
            ItemStack lIlIIlllllIIIII = null;
            if (this.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                final BlockPos lIlIIllllIlllll = this.objectMouseOver.getBlockPos();
                final IBlockState lIlIIllllIllllI = this.world.getBlockState(lIlIIllllIlllll);
                final Block lIlIIllllIlllIl = lIlIIllllIllllI.getBlock();
                if (lIlIIllllIllllI.getMaterial() == Material.AIR) {
                    return;
                }
                final ItemStack lIlIIlllllIlIIl = lIlIIllllIlllIl.getItem(this.world, lIlIIllllIlllll, lIlIIllllIllllI);
                if (lIlIIlllllIlIIl.func_190926_b()) {
                    return;
                }
                if (lIlIIlllllIlIll && GuiScreen.isCtrlKeyDown() && lIlIIllllIlllIl.hasTileEntity()) {
                    lIlIIlllllIlIlI = this.world.getTileEntity(lIlIIllllIlllll);
                }
            }
            else {
                if (this.objectMouseOver.typeOfHit != RayTraceResult.Type.ENTITY || this.objectMouseOver.entityHit == null || !lIlIIlllllIlIll) {
                    return;
                }
                if (this.objectMouseOver.entityHit instanceof EntityPainting) {
                    final ItemStack lIlIIlllllIlIII = new ItemStack(Items.PAINTING);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityLeashKnot) {
                    final ItemStack lIlIIlllllIIlll = new ItemStack(Items.LEAD);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityItemFrame) {
                    final EntityItemFrame lIlIIllllIlllII = (EntityItemFrame)this.objectMouseOver.entityHit;
                    final ItemStack lIlIIllllIllIll = lIlIIllllIlllII.getDisplayedItem();
                    if (lIlIIllllIllIll.func_190926_b()) {
                        final ItemStack lIlIIlllllIIllI = new ItemStack(Items.ITEM_FRAME);
                    }
                    else {
                        final ItemStack lIlIIlllllIIlIl = lIlIIllllIllIll.copy();
                    }
                }
                else if (this.objectMouseOver.entityHit instanceof EntityMinecart) {
                    final EntityMinecart lIlIIllllIllIlI = (EntityMinecart)this.objectMouseOver.entityHit;
                    final Item lIlIIllllIlIlII;
                    switch ($SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type()[lIlIIllllIllIlI.getType().ordinal()]) {
                        case 3: {
                            final Item lIlIIllllIllIIl = Items.FURNACE_MINECART;
                            break;
                        }
                        case 2: {
                            final Item lIlIIllllIllIII = Items.CHEST_MINECART;
                            break;
                        }
                        case 4: {
                            final Item lIlIIllllIlIlll = Items.TNT_MINECART;
                            break;
                        }
                        case 6: {
                            final Item lIlIIllllIlIllI = Items.HOPPER_MINECART;
                            break;
                        }
                        case 7: {
                            final Item lIlIIllllIlIlIl = Items.COMMAND_BLOCK_MINECART;
                            break;
                        }
                        default: {
                            lIlIIllllIlIlII = Items.MINECART;
                            break;
                        }
                    }
                    final ItemStack lIlIIlllllIIlII = new ItemStack(lIlIIllllIlIlII);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityBoat) {
                    final ItemStack lIlIIlllllIIIll = new ItemStack(((EntityBoat)this.objectMouseOver.entityHit).getItemBoat());
                }
                else if (this.objectMouseOver.entityHit instanceof EntityArmorStand) {
                    final ItemStack lIlIIlllllIIIlI = new ItemStack(Items.ARMOR_STAND);
                }
                else if (this.objectMouseOver.entityHit instanceof EntityEnderCrystal) {
                    final ItemStack lIlIIlllllIIIIl = new ItemStack(Items.END_CRYSTAL);
                }
                else {
                    final ResourceLocation lIlIIllllIlIIll = EntityList.func_191301_a(this.objectMouseOver.entityHit);
                    if (lIlIIllllIlIIll == null || !EntityList.ENTITY_EGGS.containsKey(lIlIIllllIlIIll)) {
                        return;
                    }
                    lIlIIlllllIIIII = new ItemStack(Items.SPAWN_EGG);
                    ItemMonsterPlacer.applyEntityIdToItemStack(lIlIIlllllIIIII, lIlIIllllIlIIll);
                }
            }
            if (lIlIIlllllIIIII.func_190926_b()) {
                String lIlIIllllIlIIlI = "";
                if (this.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                    lIlIIllllIlIIlI = Block.REGISTRY.getNameForObject(this.world.getBlockState(this.objectMouseOver.getBlockPos()).getBlock()).toString();
                }
                else if (this.objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY) {
                    lIlIIllllIlIIlI = EntityList.func_191301_a(this.objectMouseOver.entityHit).toString();
                }
                Minecraft.LOGGER.warn("Picking on: [{}] {} gave null item", (Object)this.objectMouseOver.typeOfHit, (Object)lIlIIllllIlIIlI);
            }
            else {
                final InventoryPlayer lIlIIllllIlIIIl = this.player.inventory;
                if (lIlIIlllllIlIlI != null) {
                    this.storeTEInStack(lIlIIlllllIIIII, lIlIIlllllIlIlI);
                }
                final int lIlIIllllIlIIII = lIlIIllllIlIIIl.getSlotFor(lIlIIlllllIIIII);
                if (lIlIIlllllIlIll) {
                    lIlIIllllIlIIIl.setPickedItemStack(lIlIIlllllIIIII);
                    this.playerController.sendSlotPacket(this.player.getHeldItem(EnumHand.MAIN_HAND), 36 + lIlIIllllIlIIIl.currentItem);
                }
                else if (lIlIIllllIlIIII != -1) {
                    if (InventoryPlayer.isHotbar(lIlIIllllIlIIII)) {
                        lIlIIllllIlIIIl.currentItem = lIlIIllllIlIIII;
                    }
                    else {
                        this.playerController.pickItem(lIlIIllllIlIIII);
                    }
                }
            }
        }
    }
    
    @Override
    public ListenableFuture<Object> addScheduledTask(final Runnable lIlIIllIIIlllII) {
        Validate.notNull((Object)lIlIIllIIIlllII);
        return this.addScheduledTask(Executors.callable(lIlIIllIIIlllII));
    }
    
    private void updateDisplayMode() throws LWJGLException {
        final Set<DisplayMode> lIlIllIIIlIIlII = (Set<DisplayMode>)Sets.newHashSet();
        Collections.addAll(lIlIllIIIlIIlII, Display.getAvailableDisplayModes());
        DisplayMode lIlIllIIIlIIIll = Display.getDesktopDisplayMode();
        if (!lIlIllIIIlIIlII.contains(lIlIllIIIlIIIll) && Util.getOSType() == Util.EnumOS.OSX) {
            for (final DisplayMode lIlIllIIIlIIIlI : Minecraft.MAC_DISPLAY_MODES) {
                boolean lIlIllIIIlIIIIl = true;
                for (final DisplayMode lIlIllIIIlIIIII : lIlIllIIIlIIlII) {
                    if (lIlIllIIIlIIIII.getBitsPerPixel() == 32 && lIlIllIIIlIIIII.getWidth() == lIlIllIIIlIIIlI.getWidth() && lIlIllIIIlIIIII.getHeight() == lIlIllIIIlIIIlI.getHeight()) {
                        lIlIllIIIlIIIIl = false;
                        break;
                    }
                }
                if (!lIlIllIIIlIIIIl) {
                    for (final DisplayMode lIlIllIIIIllllI : lIlIllIIIlIIlII) {
                        if (lIlIllIIIIllllI.getBitsPerPixel() == 32 && lIlIllIIIIllllI.getWidth() == lIlIllIIIlIIIlI.getWidth() / 2 && lIlIllIIIIllllI.getHeight() == lIlIllIIIlIIIlI.getHeight() / 2) {
                            lIlIllIIIlIIIll = lIlIllIIIIllllI;
                            break;
                        }
                    }
                }
            }
        }
        Display.setDisplayMode(lIlIllIIIlIIIll);
        this.displayWidth = lIlIllIIIlIIIll.getWidth();
        this.displayHeight = lIlIllIIIlIIIll.getHeight();
    }
    
    public ISaveFormat getSaveLoader() {
        return this.saveLoader;
    }
    
    @Nullable
    public NetHandlerPlayClient getConnection() {
        return (this.player == null) ? null : this.player.connection;
    }
    
    @Nullable
    public ServerData getCurrentServerData() {
        return this.currentServerData;
    }
    
    public boolean isSingleplayer() {
        return this.integratedServerIsRunning && this.theIntegratedServer != null;
    }
    
    public void dispatchKeypresses() {
        final int lIlIIllIIllllll = (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
        if (lIlIIllIIllllll != 0 && !Keyboard.isRepeatEvent() && (!(this.currentScreen instanceof GuiControls) || ((GuiControls)this.currentScreen).time <= getSystemTime() - 20L) && Keyboard.getEventKeyState()) {
            if (lIlIIllIIllllll == this.gameSettings.keyBindFullscreen.getKeyCode()) {
                this.toggleFullscreen();
            }
            else if (lIlIIllIIllllll == this.gameSettings.keyBindScreenshot.getKeyCode()) {
                this.ingameGUI.getChatGUI().printChatMessage(ScreenShotHelper.saveScreenshot(this.mcDataDir, this.displayWidth, this.displayHeight, this.framebufferMc));
            }
            else if (lIlIIllIIllllll == 48 && GuiScreen.isCtrlKeyDown() && (this.currentScreen == null || (this.currentScreen != null && !this.currentScreen.func_193976_p()))) {
                this.gameSettings.setOptionValue(GameSettings.Options.NARRATOR, 1);
                if (this.currentScreen instanceof ScreenChatOptions) {
                    ((ScreenChatOptions)this.currentScreen).func_193024_a();
                }
            }
        }
    }
    
    public void freeMemory() {
        try {
            Minecraft.memoryReserve = new byte[0];
            this.renderGlobal.deleteAllDisplayLists();
        }
        catch (Throwable t) {}
        try {
            System.gc();
            this.loadWorld(null);
        }
        catch (Throwable t2) {}
        System.gc();
    }
    
    private void displayDebugInfo(final long lIlIlIlIlIlIlll) {
        if (this.mcProfiler.profilingEnabled) {
            final List<Profiler.Result> lIlIlIlIlIlIllI = this.mcProfiler.getProfilingData(this.debugProfilerName);
            final Profiler.Result lIlIlIlIlIlIlIl = lIlIlIlIlIlIllI.remove(0);
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.enableColorMaterial();
            GlStateManager.loadIdentity();
            GlStateManager.ortho(0.0, this.displayWidth, this.displayHeight, 0.0, 1000.0, 3000.0);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -2000.0f);
            GlStateManager.glLineWidth(1.0f);
            GlStateManager.disableTexture2D();
            final Tessellator lIlIlIlIlIlIlII = Tessellator.getInstance();
            final BufferBuilder lIlIlIlIlIlIIll = lIlIlIlIlIlIlII.getBuffer();
            final int lIlIlIlIlIlIIlI = 160;
            final int lIlIlIlIlIlIIIl = this.displayWidth - 160 - 10;
            final int lIlIlIlIlIlIIII = this.displayHeight - 320;
            GlStateManager.enableBlend();
            lIlIlIlIlIlIIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
            lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl - 176.0f, lIlIlIlIlIlIIII - 96.0f - 16.0f, 0.0).color(200, 0, 0, 0).endVertex();
            lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl - 176.0f, lIlIlIlIlIlIIII + 320, 0.0).color(200, 0, 0, 0).endVertex();
            lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl + 176.0f, lIlIlIlIlIlIIII + 320, 0.0).color(200, 0, 0, 0).endVertex();
            lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl + 176.0f, lIlIlIlIlIlIIII - 96.0f - 16.0f, 0.0).color(200, 0, 0, 0).endVertex();
            lIlIlIlIlIlIlII.draw();
            GlStateManager.disableBlend();
            double lIlIlIlIlIIllll = 0.0;
            for (int lIlIlIlIlIIlllI = 0; lIlIlIlIlIIlllI < lIlIlIlIlIlIllI.size(); ++lIlIlIlIlIIlllI) {
                final Profiler.Result lIlIlIlIlIIllIl = lIlIlIlIlIlIllI.get(lIlIlIlIlIIlllI);
                final int lIlIlIlIlIIllII = MathHelper.floor(lIlIlIlIlIIllIl.usePercentage / 4.0) + 1;
                lIlIlIlIlIlIIll.begin(6, DefaultVertexFormats.POSITION_COLOR);
                final int lIlIlIlIlIIlIll = lIlIlIlIlIIllIl.getColor();
                final int lIlIlIlIlIIlIlI = lIlIlIlIlIIlIll >> 16 & 0xFF;
                final int lIlIlIlIlIIlIIl = lIlIlIlIlIIlIll >> 8 & 0xFF;
                final int lIlIlIlIlIIlIII = lIlIlIlIlIIlIll & 0xFF;
                lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl, lIlIlIlIlIlIIII, 0.0).color(lIlIlIlIlIIlIlI, lIlIlIlIlIIlIIl, lIlIlIlIlIIlIII, 255).endVertex();
                for (int lIlIlIlIlIIIlll = lIlIlIlIlIIllII; lIlIlIlIlIIIlll >= 0; --lIlIlIlIlIIIlll) {
                    final float lIlIlIlIlIIIllI = (float)((lIlIlIlIlIIllll + lIlIlIlIlIIllIl.usePercentage * lIlIlIlIlIIIlll / lIlIlIlIlIIllII) * 6.283185307179586 / 100.0);
                    final float lIlIlIlIlIIIlIl = MathHelper.sin(lIlIlIlIlIIIllI) * 160.0f;
                    final float lIlIlIlIlIIIlII = MathHelper.cos(lIlIlIlIlIIIllI) * 160.0f * 0.5f;
                    lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl + lIlIlIlIlIIIlIl, lIlIlIlIlIlIIII - lIlIlIlIlIIIlII, 0.0).color(lIlIlIlIlIIlIlI, lIlIlIlIlIIlIIl, lIlIlIlIlIIlIII, 255).endVertex();
                }
                lIlIlIlIlIlIlII.draw();
                lIlIlIlIlIlIIll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (int lIlIlIlIlIIIIll = lIlIlIlIlIIllII; lIlIlIlIlIIIIll >= 0; --lIlIlIlIlIIIIll) {
                    final float lIlIlIlIlIIIIlI = (float)((lIlIlIlIlIIllll + lIlIlIlIlIIllIl.usePercentage * lIlIlIlIlIIIIll / lIlIlIlIlIIllII) * 6.283185307179586 / 100.0);
                    final float lIlIlIlIlIIIIIl = MathHelper.sin(lIlIlIlIlIIIIlI) * 160.0f;
                    final float lIlIlIlIlIIIIII = MathHelper.cos(lIlIlIlIlIIIIlI) * 160.0f * 0.5f;
                    lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl + lIlIlIlIlIIIIIl, lIlIlIlIlIlIIII - lIlIlIlIlIIIIII, 0.0).color(lIlIlIlIlIIlIlI >> 1, lIlIlIlIlIIlIIl >> 1, lIlIlIlIlIIlIII >> 1, 255).endVertex();
                    lIlIlIlIlIlIIll.pos(lIlIlIlIlIlIIIl + lIlIlIlIlIIIIIl, lIlIlIlIlIlIIII - lIlIlIlIlIIIIII + 10.0f, 0.0).color(lIlIlIlIlIIlIlI >> 1, lIlIlIlIlIIlIIl >> 1, lIlIlIlIlIIlIII >> 1, 255).endVertex();
                }
                lIlIlIlIlIlIlII.draw();
                lIlIlIlIlIIllll += lIlIlIlIlIIllIl.usePercentage;
            }
            final DecimalFormat lIlIlIlIIllllll = new DecimalFormat("##0.00");
            GlStateManager.enableTexture2D();
            String lIlIlIlIIlllllI = "";
            if (!"unspecified".equals(lIlIlIlIlIlIlIl.profilerName)) {
                lIlIlIlIIlllllI = String.valueOf(new StringBuilder(String.valueOf(lIlIlIlIIlllllI)).append("[0] "));
            }
            if (lIlIlIlIlIlIlIl.profilerName.isEmpty()) {
                lIlIlIlIIlllllI = String.valueOf(new StringBuilder(String.valueOf(lIlIlIlIIlllllI)).append("ROOT "));
            }
            else {
                lIlIlIlIIlllllI = String.valueOf(new StringBuilder(String.valueOf(lIlIlIlIIlllllI)).append(lIlIlIlIlIlIlIl.profilerName).append(' '));
            }
            final int lIlIlIlIIllllIl = 16777215;
            this.fontRendererObj.drawStringWithShadow(lIlIlIlIIlllllI, (float)(lIlIlIlIlIlIIIl - 160), (float)(lIlIlIlIlIlIIII - 80 - 16), 16777215);
            lIlIlIlIIlllllI = String.valueOf(new StringBuilder(String.valueOf(lIlIlIlIIllllll.format(lIlIlIlIlIlIlIl.totalUsePercentage))).append("%"));
            this.fontRendererObj.drawStringWithShadow(lIlIlIlIIlllllI, (float)(lIlIlIlIlIlIIIl + 160 - this.fontRendererObj.getStringWidth(lIlIlIlIIlllllI)), (float)(lIlIlIlIlIlIIII - 80 - 16), 16777215);
            for (int lIlIlIlIIllllII = 0; lIlIlIlIIllllII < lIlIlIlIlIlIllI.size(); ++lIlIlIlIIllllII) {
                final Profiler.Result lIlIlIlIIlllIll = lIlIlIlIlIlIllI.get(lIlIlIlIIllllII);
                final StringBuilder lIlIlIlIIlllIlI = new StringBuilder();
                if ("unspecified".equals(lIlIlIlIIlllIll.profilerName)) {
                    lIlIlIlIIlllIlI.append("[?] ");
                }
                else {
                    lIlIlIlIIlllIlI.append("[").append(lIlIlIlIIllllII + 1).append("] ");
                }
                String lIlIlIlIIlllIIl = String.valueOf(lIlIlIlIIlllIlI.append(lIlIlIlIIlllIll.profilerName));
                this.fontRendererObj.drawStringWithShadow(lIlIlIlIIlllIIl, (float)(lIlIlIlIlIlIIIl - 160), (float)(lIlIlIlIlIlIIII + 80 + lIlIlIlIIllllII * 8 + 20), lIlIlIlIIlllIll.getColor());
                lIlIlIlIIlllIIl = String.valueOf(new StringBuilder(String.valueOf(lIlIlIlIIllllll.format(lIlIlIlIIlllIll.usePercentage))).append("%"));
                this.fontRendererObj.drawStringWithShadow(lIlIlIlIIlllIIl, (float)(lIlIlIlIlIlIIIl + 160 - 50 - this.fontRendererObj.getStringWidth(lIlIlIlIIlllIIl)), (float)(lIlIlIlIlIlIIII + 80 + lIlIlIlIIllllII * 8 + 20), lIlIlIlIIlllIll.getColor());
                lIlIlIlIIlllIIl = String.valueOf(new StringBuilder(String.valueOf(lIlIlIlIIllllll.format(lIlIlIlIIlllIll.totalUsePercentage))).append("%"));
                this.fontRendererObj.drawStringWithShadow(lIlIlIlIIlllIIl, (float)(lIlIlIlIlIlIIIl + 160 - this.fontRendererObj.getStringWidth(lIlIlIlIIlllIIl)), (float)(lIlIlIlIlIlIIII + 80 + lIlIlIlIIllllII * 8 + 20), lIlIlIlIIlllIll.getColor());
            }
        }
    }
    
    public IResourceManager getResourceManager() {
        return this.mcResourceManager;
    }
    
    public void setDimensionAndSpawnPlayer(final int lIlIlIIIIIIIIlI) {
        this.world.setInitialSpawnLocation();
        this.world.removeAllEntities();
        int lIlIlIIIIIIIIIl = 0;
        String lIlIlIIIIIIIIII = null;
        if (this.player != null) {
            lIlIlIIIIIIIIIl = this.player.getEntityId();
            this.world.removeEntity(this.player);
            lIlIlIIIIIIIIII = this.player.getServerBrand();
        }
        this.renderViewEntity = null;
        final EntityPlayerSP lIlIIllllllllll = this.player;
        this.player = this.playerController.func_192830_a(this.world, (this.player == null) ? new StatisticsManager() : this.player.getStatFileWriter(), (this.player == null) ? new RecipeBook() : this.player.func_192035_E());
        this.player.getDataManager().setEntryValues(lIlIIllllllllll.getDataManager().getAll());
        this.player.dimension = lIlIlIIIIIIIIlI;
        this.renderViewEntity = this.player;
        this.player.preparePlayerToSpawn();
        this.player.setServerBrand(lIlIlIIIIIIIIII);
        this.world.spawnEntityInWorld(this.player);
        this.playerController.flipPlayer(this.player);
        this.player.movementInput = new MovementInputFromOptions(this.gameSettings);
        this.player.setEntityId(lIlIlIIIIIIIIIl);
        this.playerController.setPlayerCapabilities(this.player);
        this.player.setReducedDebug(lIlIIllllllllll.hasReducedDebug());
        if (this.currentScreen instanceof GuiGameOver) {
            this.displayGuiScreen(null);
        }
    }
    
    private void sendClickBlockToController(final boolean lIlIlIIlllllIll) {
        if (!lIlIlIIlllllIll) {
            this.leftClickCounter = 0;
        }
        if (this.leftClickCounter <= 0 && !this.player.isHandActive()) {
            if (lIlIlIIlllllIll && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                final BlockPos lIlIlIIlllllIlI = this.objectMouseOver.getBlockPos();
                if (this.world.getBlockState(lIlIlIIlllllIlI).getMaterial() != Material.AIR && this.playerController.onPlayerDamageBlock(lIlIlIIlllllIlI, this.objectMouseOver.sideHit)) {
                    this.effectRenderer.addBlockHitEffects(lIlIlIIlllllIlI, this.objectMouseOver.sideHit);
                    this.player.swingArm(EnumHand.MAIN_HAND);
                }
            }
            else {
                this.playerController.resetBlockRemoving();
            }
        }
    }
    
    @Override
    public void addServerTypeToSnooper(final Snooper lIlIIlllIIlIIII) {
        lIlIIlllIIlIIII.addStatToSnooper("opengl_version", GlStateManager.glGetString(7938));
        lIlIIlllIIlIIII.addStatToSnooper("opengl_vendor", GlStateManager.glGetString(7936));
        lIlIIlllIIlIIII.addStatToSnooper("client_brand", ClientBrandRetriever.getClientModName());
        lIlIIlllIIlIIII.addStatToSnooper("launched_version", this.launchedVersion);
        final ContextCapabilities lIlIIlllIIlIIll = GLContext.getCapabilities();
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_arrays_of_arrays]", lIlIIlllIIlIIll.GL_ARB_arrays_of_arrays);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_base_instance]", lIlIIlllIIlIIll.GL_ARB_base_instance);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_blend_func_extended]", lIlIIlllIIlIIll.GL_ARB_blend_func_extended);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_clear_buffer_object]", lIlIIlllIIlIIll.GL_ARB_clear_buffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_color_buffer_float]", lIlIIlllIIlIIll.GL_ARB_color_buffer_float);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_compatibility]", lIlIIlllIIlIIll.GL_ARB_compatibility);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_compressed_texture_pixel_storage]", lIlIIlllIIlIIll.GL_ARB_compressed_texture_pixel_storage);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_compute_shader]", lIlIIlllIIlIIll.GL_ARB_compute_shader);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_copy_buffer]", lIlIIlllIIlIIll.GL_ARB_copy_buffer);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_copy_image]", lIlIIlllIIlIIll.GL_ARB_copy_image);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", lIlIIlllIIlIIll.GL_ARB_depth_buffer_float);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_compute_shader]", lIlIIlllIIlIIll.GL_ARB_compute_shader);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_copy_buffer]", lIlIIlllIIlIIll.GL_ARB_copy_buffer);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_copy_image]", lIlIIlllIIlIIll.GL_ARB_copy_image);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_depth_buffer_float]", lIlIIlllIIlIIll.GL_ARB_depth_buffer_float);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_depth_clamp]", lIlIIlllIIlIIll.GL_ARB_depth_clamp);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_depth_texture]", lIlIIlllIIlIIll.GL_ARB_depth_texture);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_draw_buffers]", lIlIIlllIIlIIll.GL_ARB_draw_buffers);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_draw_buffers_blend]", lIlIIlllIIlIIll.GL_ARB_draw_buffers_blend);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_draw_elements_base_vertex]", lIlIIlllIIlIIll.GL_ARB_draw_elements_base_vertex);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_draw_indirect]", lIlIIlllIIlIIll.GL_ARB_draw_indirect);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_draw_instanced]", lIlIIlllIIlIIll.GL_ARB_draw_instanced);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_explicit_attrib_location]", lIlIIlllIIlIIll.GL_ARB_explicit_attrib_location);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_explicit_uniform_location]", lIlIIlllIIlIIll.GL_ARB_explicit_uniform_location);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_fragment_layer_viewport]", lIlIIlllIIlIIll.GL_ARB_fragment_layer_viewport);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_fragment_program]", lIlIIlllIIlIIll.GL_ARB_fragment_program);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_fragment_shader]", lIlIIlllIIlIIll.GL_ARB_fragment_shader);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_fragment_program_shadow]", lIlIIlllIIlIIll.GL_ARB_fragment_program_shadow);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_framebuffer_object]", lIlIIlllIIlIIll.GL_ARB_framebuffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_framebuffer_sRGB]", lIlIIlllIIlIIll.GL_ARB_framebuffer_sRGB);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_geometry_shader4]", lIlIIlllIIlIIll.GL_ARB_geometry_shader4);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_gpu_shader5]", lIlIIlllIIlIIll.GL_ARB_gpu_shader5);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_half_float_pixel]", lIlIIlllIIlIIll.GL_ARB_half_float_pixel);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_half_float_vertex]", lIlIIlllIIlIIll.GL_ARB_half_float_vertex);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_instanced_arrays]", lIlIIlllIIlIIll.GL_ARB_instanced_arrays);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_map_buffer_alignment]", lIlIIlllIIlIIll.GL_ARB_map_buffer_alignment);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_map_buffer_range]", lIlIIlllIIlIIll.GL_ARB_map_buffer_range);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_multisample]", lIlIIlllIIlIIll.GL_ARB_multisample);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_multitexture]", lIlIIlllIIlIIll.GL_ARB_multitexture);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_occlusion_query2]", lIlIIlllIIlIIll.GL_ARB_occlusion_query2);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_pixel_buffer_object]", lIlIIlllIIlIIll.GL_ARB_pixel_buffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_seamless_cube_map]", lIlIIlllIIlIIll.GL_ARB_seamless_cube_map);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_shader_objects]", lIlIIlllIIlIIll.GL_ARB_shader_objects);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_shader_stencil_export]", lIlIIlllIIlIIll.GL_ARB_shader_stencil_export);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_shader_texture_lod]", lIlIIlllIIlIIll.GL_ARB_shader_texture_lod);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_shadow]", lIlIIlllIIlIIll.GL_ARB_shadow);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_shadow_ambient]", lIlIIlllIIlIIll.GL_ARB_shadow_ambient);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_stencil_texturing]", lIlIIlllIIlIIll.GL_ARB_stencil_texturing);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_sync]", lIlIIlllIIlIIll.GL_ARB_sync);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_tessellation_shader]", lIlIIlllIIlIIll.GL_ARB_tessellation_shader);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_texture_border_clamp]", lIlIIlllIIlIIll.GL_ARB_texture_border_clamp);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_texture_buffer_object]", lIlIIlllIIlIIll.GL_ARB_texture_buffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_texture_cube_map]", lIlIIlllIIlIIll.GL_ARB_texture_cube_map);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_texture_cube_map_array]", lIlIIlllIIlIIll.GL_ARB_texture_cube_map_array);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_texture_non_power_of_two]", lIlIIlllIIlIIll.GL_ARB_texture_non_power_of_two);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_uniform_buffer_object]", lIlIIlllIIlIIll.GL_ARB_uniform_buffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_vertex_blend]", lIlIIlllIIlIIll.GL_ARB_vertex_blend);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_vertex_buffer_object]", lIlIIlllIIlIIll.GL_ARB_vertex_buffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_vertex_program]", lIlIIlllIIlIIll.GL_ARB_vertex_program);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[ARB_vertex_shader]", lIlIIlllIIlIIll.GL_ARB_vertex_shader);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_bindable_uniform]", lIlIIlllIIlIIll.GL_EXT_bindable_uniform);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_blend_equation_separate]", lIlIIlllIIlIIll.GL_EXT_blend_equation_separate);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_blend_func_separate]", lIlIIlllIIlIIll.GL_EXT_blend_func_separate);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_blend_minmax]", lIlIIlllIIlIIll.GL_EXT_blend_minmax);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_blend_subtract]", lIlIIlllIIlIIll.GL_EXT_blend_subtract);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_draw_instanced]", lIlIIlllIIlIIll.GL_EXT_draw_instanced);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_framebuffer_multisample]", lIlIIlllIIlIIll.GL_EXT_framebuffer_multisample);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_framebuffer_object]", lIlIIlllIIlIIll.GL_EXT_framebuffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_framebuffer_sRGB]", lIlIIlllIIlIIll.GL_EXT_framebuffer_sRGB);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_geometry_shader4]", lIlIIlllIIlIIll.GL_EXT_geometry_shader4);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_gpu_program_parameters]", lIlIIlllIIlIIll.GL_EXT_gpu_program_parameters);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_gpu_shader4]", lIlIIlllIIlIIll.GL_EXT_gpu_shader4);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_multi_draw_arrays]", lIlIIlllIIlIIll.GL_EXT_multi_draw_arrays);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_packed_depth_stencil]", lIlIIlllIIlIIll.GL_EXT_packed_depth_stencil);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_paletted_texture]", lIlIIlllIIlIIll.GL_EXT_paletted_texture);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_rescale_normal]", lIlIIlllIIlIIll.GL_EXT_rescale_normal);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_separate_shader_objects]", lIlIIlllIIlIIll.GL_EXT_separate_shader_objects);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_shader_image_load_store]", lIlIIlllIIlIIll.GL_EXT_shader_image_load_store);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_shadow_funcs]", lIlIIlllIIlIIll.GL_EXT_shadow_funcs);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_shared_texture_palette]", lIlIIlllIIlIIll.GL_EXT_shared_texture_palette);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_stencil_clear_tag]", lIlIIlllIIlIIll.GL_EXT_stencil_clear_tag);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_stencil_two_side]", lIlIIlllIIlIIll.GL_EXT_stencil_two_side);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_stencil_wrap]", lIlIIlllIIlIIll.GL_EXT_stencil_wrap);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_texture_3d]", lIlIIlllIIlIIll.GL_EXT_texture_3d);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_texture_array]", lIlIIlllIIlIIll.GL_EXT_texture_array);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_texture_buffer_object]", lIlIIlllIIlIIll.GL_EXT_texture_buffer_object);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_texture_integer]", lIlIIlllIIlIIll.GL_EXT_texture_integer);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_texture_lod_bias]", lIlIIlllIIlIIll.GL_EXT_texture_lod_bias);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_texture_sRGB]", lIlIIlllIIlIIll.GL_EXT_texture_sRGB);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_vertex_shader]", lIlIIlllIIlIIll.GL_EXT_vertex_shader);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[EXT_vertex_weighting]", lIlIIlllIIlIIll.GL_EXT_vertex_weighting);
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[gl_max_vertex_uniforms]", GlStateManager.glGetInteger(35658));
        GlStateManager.glGetError();
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[gl_max_fragment_uniforms]", GlStateManager.glGetInteger(35657));
        GlStateManager.glGetError();
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[gl_max_vertex_attribs]", GlStateManager.glGetInteger(34921));
        GlStateManager.glGetError();
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[gl_max_vertex_texture_image_units]", GlStateManager.glGetInteger(35660));
        GlStateManager.glGetError();
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[gl_max_texture_image_units]", GlStateManager.glGetInteger(34930));
        GlStateManager.glGetError();
        lIlIIlllIIlIIII.addStatToSnooper("gl_caps[gl_max_array_texture_layers]", GlStateManager.glGetInteger(35071));
        GlStateManager.glGetError();
        lIlIIlllIIlIIII.addStatToSnooper("gl_max_texture_size", getGLMaximumTextureSize());
        final GameProfile lIlIIlllIIlIIlI = this.session.getProfile();
        if (lIlIIlllIIlIIlI != null && lIlIIlllIIlIIlI.getId() != null) {
            lIlIIlllIIlIIII.addStatToSnooper("uuid", Hashing.sha1().hashBytes(lIlIIlllIIlIIlI.getId().toString().getBytes(Charsets.ISO_8859_1)).toString());
        }
    }
    
    public Snooper getPlayerUsageSnooper() {
        return this.usageSnooper;
    }
    
    @Nullable
    public IntegratedServer getIntegratedServer() {
        return this.theIntegratedServer;
    }
    
    private void rightClickMouse() {
        if (!this.playerController.getIsHittingBlock()) {
            this.rightClickDelayTimer = 4;
            if (!this.player.isRowingBoat()) {
                if (this.objectMouseOver == null) {
                    Minecraft.LOGGER.warn("Null returned as 'hitResult', this shouldn't happen!");
                }
                final short lIlIlIIlIllllll;
                final long lIlIlIIllIIIIII = ((EnumHand[])(Object)(lIlIlIIlIllllll = (short)(Object)EnumHand.values())).length;
                for (Exception lIlIlIIllIIIIlI = (Exception)0; lIlIlIIllIIIIlI < lIlIlIIllIIIIII; ++lIlIlIIllIIIIlI) {
                    final EnumHand lIlIlIIllIIlIIl = lIlIlIIlIllllll[lIlIlIIllIIIIlI];
                    final ItemStack lIlIlIIllIIlIII = this.player.getHeldItem(lIlIlIIllIIlIIl);
                    if (this.objectMouseOver != null) {
                        switch ($SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type()[this.objectMouseOver.typeOfHit.ordinal()]) {
                            case 3: {
                                if (this.playerController.interactWithEntity(this.player, this.objectMouseOver.entityHit, this.objectMouseOver, lIlIlIIllIIlIIl) == EnumActionResult.SUCCESS) {
                                    return;
                                }
                                if (this.playerController.interactWithEntity(this.player, this.objectMouseOver.entityHit, lIlIlIIllIIlIIl) == EnumActionResult.SUCCESS) {
                                    return;
                                }
                                break;
                            }
                            case 2: {
                                final BlockPos lIlIlIIllIIIlll = this.objectMouseOver.getBlockPos();
                                if (this.world.getBlockState(lIlIlIIllIIIlll).getMaterial() == Material.AIR) {
                                    break;
                                }
                                final int lIlIlIIllIIIllI = lIlIlIIllIIlIII.func_190916_E();
                                final EnumActionResult lIlIlIIllIIIlIl = this.playerController.processRightClickBlock(this.player, this.world, lIlIlIIllIIIlll, this.objectMouseOver.sideHit, this.objectMouseOver.hitVec, lIlIlIIllIIlIIl);
                                if (lIlIlIIllIIIlIl == EnumActionResult.SUCCESS) {
                                    this.player.swingArm(lIlIlIIllIIlIIl);
                                    if (!lIlIlIIllIIlIII.func_190926_b() && (lIlIlIIllIIlIII.func_190916_E() != lIlIlIIllIIIllI || this.playerController.isInCreativeMode())) {
                                        this.entityRenderer.itemRenderer.resetEquippedProgress(lIlIlIIllIIlIIl);
                                    }
                                    return;
                                }
                                break;
                            }
                        }
                    }
                    if (!lIlIlIIllIIlIII.func_190926_b() && this.playerController.processRightClick(this.player, this.world, lIlIlIIllIIlIIl) == EnumActionResult.SUCCESS) {
                        this.entityRenderer.itemRenderer.resetEquippedProgress(lIlIlIIllIIlIIl);
                        return;
                    }
                }
            }
        }
    }
    
    public static long getSystemTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }
    
    public void shutdownMinecraftApplet() {
        try {
            Main.stopClient();
            Minecraft.LOGGER.info("Stopping!");
            try {
                this.loadWorld(null);
            }
            catch (Throwable t) {}
            this.mcSoundHandler.unloadSounds();
        }
        finally {
            Display.destroy();
            if (!this.hasCrashed) {
                System.exit(0);
            }
        }
        Display.destroy();
        if (!this.hasCrashed) {
            System.exit(0);
        }
        System.gc();
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return Thread.currentThread() == this.mcThread;
    }
    
    public boolean isJava64bit() {
        return this.jvm64bit;
    }
    
    private void func_190521_a(final String lIlIlIIIlIIlIlI, final Object... lIlIlIIIlIIlIIl) {
        this.ingameGUI.getChatGUI().printChatMessage(new TextComponentString("").appendSibling(new TextComponentTranslation("debug.prefix", new Object[0]).setStyle(new Style().setColor(TextFormatting.YELLOW).setBold(true))).appendText(" ").appendSibling(new TextComponentTranslation(lIlIlIIIlIIlIlI, lIlIlIIIlIIlIIl)));
    }
    
    private boolean processKeyF3(final int lIlIlIIIlllIIII) {
        if (lIlIlIIIlllIIII == 30) {
            this.renderGlobal.loadRenderers();
            this.func_190521_a("debug.reload_chunks.message", new Object[0]);
            return true;
        }
        if (lIlIlIIIlllIIII == 48) {
            final boolean lIlIlIIIlllIlII = !this.renderManager.isDebugBoundingBox();
            this.renderManager.setDebugBoundingBox(lIlIlIIIlllIlII);
            this.func_190521_a(lIlIlIIIlllIlII ? "debug.show_hitboxes.on" : "debug.show_hitboxes.off", new Object[0]);
            return true;
        }
        if (lIlIlIIIlllIIII == 32) {
            if (this.ingameGUI != null) {
                this.ingameGUI.getChatGUI().clearChatMessages(false);
            }
            return true;
        }
        if (lIlIlIIIlllIIII == 33) {
            this.gameSettings.setOptionValue(GameSettings.Options.RENDER_DISTANCE, GuiScreen.isShiftKeyDown() ? -1 : 1);
            this.func_190521_a("debug.cycle_renderdistance.message", this.gameSettings.renderDistanceChunks);
            return true;
        }
        if (lIlIlIIIlllIIII == 34) {
            final boolean lIlIlIIIlllIIll = this.debugRenderer.toggleDebugScreen();
            this.func_190521_a(lIlIlIIIlllIIll ? "debug.chunk_boundaries.on" : "debug.chunk_boundaries.off", new Object[0]);
            return true;
        }
        if (lIlIlIIIlllIIII == 35) {
            this.gameSettings.advancedItemTooltips = !this.gameSettings.advancedItemTooltips;
            this.func_190521_a(this.gameSettings.advancedItemTooltips ? "debug.advanced_tooltips.on" : "debug.advanced_tooltips.off", new Object[0]);
            this.gameSettings.saveOptions();
            return true;
        }
        if (lIlIlIIIlllIIII == 49) {
            if (!this.player.canCommandSenderUseCommand(2, "")) {
                this.func_190521_a("debug.creative_spectator.error", new Object[0]);
            }
            else if (this.player.isCreative()) {
                this.player.sendChatMessage("/gamemode spectator");
            }
            else if (this.player.isSpectator()) {
                this.player.sendChatMessage("/gamemode creative");
            }
            return true;
        }
        if (lIlIlIIIlllIIII == 25) {
            this.gameSettings.pauseOnLostFocus = !this.gameSettings.pauseOnLostFocus;
            this.gameSettings.saveOptions();
            this.func_190521_a(this.gameSettings.pauseOnLostFocus ? "debug.pause_focus.on" : "debug.pause_focus.off", new Object[0]);
            return true;
        }
        if (lIlIlIIIlllIIII == 16) {
            this.func_190521_a("debug.help.message", new Object[0]);
            final GuiNewChat lIlIlIIIlllIIlI = this.ingameGUI.getChatGUI();
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.reload_chunks.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.show_hitboxes.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.clear_chat.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.cycle_renderdistance.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.chunk_boundaries.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.advanced_tooltips.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.creative_spectator.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.pause_focus.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.help.help", new Object[0]));
            lIlIlIIIlllIIlI.printChatMessage(new TextComponentTranslation("debug.reload_resourcepacks.help", new Object[0]));
            return true;
        }
        if (lIlIlIIIlllIIII == 20) {
            this.func_190521_a("debug.reload_resourcepacks.message", new Object[0]);
            this.refreshResources();
            return true;
        }
        return false;
    }
    
    public BlockRendererDispatcher getBlockRendererDispatcher() {
        return this.blockRenderDispatcher;
    }
    
    public void run() {
        this.running = true;
        try {
            this.startGame();
        }
        catch (Throwable lIlIllIllIIIIlI) {
            final CrashReport lIlIllIllIIIIIl = CrashReport.makeCrashReport(lIlIllIllIIIIlI, "Initializing game");
            lIlIllIllIIIIIl.makeCategory("Initialization");
            this.displayCrashReport(this.addGraphicsAndWorldToCrashReport(lIlIllIllIIIIIl));
            return;
        }
        try {
            do {
                if (this.hasCrashed) {
                    if (this.crashReporter != null) {
                        this.displayCrashReport(this.crashReporter);
                        continue;
                    }
                }
                try {
                    this.runGameLoop();
                }
                catch (OutOfMemoryError lIlIllIllIIIIII) {
                    this.freeMemory();
                    this.displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            } while (this.running);
        }
        catch (MinecraftError lIlIllIlIllllll) {}
        catch (ReportedException lIlIllIlIlllllI) {
            this.addGraphicsAndWorldToCrashReport(lIlIllIlIlllllI.getCrashReport());
            this.freeMemory();
            Minecraft.LOGGER.fatal("Reported exception thrown!", (Throwable)lIlIllIlIlllllI);
            this.displayCrashReport(lIlIllIlIlllllI.getCrashReport());
        }
        catch (Throwable lIlIllIlIllllIl) {
            final CrashReport lIlIllIlIllllII = this.addGraphicsAndWorldToCrashReport(new CrashReport("Unexpected error", lIlIllIlIllllIl));
            this.freeMemory();
            Minecraft.LOGGER.fatal("Unreported exception thrown!", lIlIllIlIllllIl);
            this.displayCrashReport(lIlIllIlIllllII);
        }
        finally {
            this.shutdownMinecraftApplet();
        }
        this.shutdownMinecraftApplet();
    }
    
    public boolean isGamePaused() {
        return this.isGamePaused;
    }
    
    public void toggleFullscreen() {
        try {
            this.fullscreen = !this.fullscreen;
            this.gameSettings.fullScreen = this.fullscreen;
            if (this.fullscreen) {
                this.updateDisplayMode();
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            }
            else {
                Display.setDisplayMode(new DisplayMode(this.tempDisplayWidth, this.tempDisplayHeight));
                this.displayWidth = this.tempDisplayWidth;
                this.displayHeight = this.tempDisplayHeight;
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            }
            if (this.currentScreen != null) {
                this.resize(this.displayWidth, this.displayHeight);
            }
            else {
                this.updateFramebufferSize();
            }
            Display.setFullscreen(this.fullscreen);
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
            this.updateDisplay();
        }
        catch (Exception lIlIlIIlIllIIlI) {
            Minecraft.LOGGER.error("Couldn't toggle fullscreen", (Throwable)lIlIlIIlIllIIlI);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type() {
        final int[] $switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type = Minecraft.$SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
        if ($switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type != null) {
            return $switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
        }
        final long lIlIIlIlllIIIlI = (Object)new int[EntityMinecart.Type.values().length];
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.CHEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.COMMAND_BLOCK.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.FURNACE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.HOPPER.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.RIDEABLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.SPAWNER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lIlIIlIlllIIIlI[EntityMinecart.Type.TNT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return Minecraft.$SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type = (int[])(Object)lIlIIlIlllIIIlI;
    }
    
    private static boolean isJvm64bit() {
        final String[] lIlIllIIllllIlI = { "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch" };
        final Exception lIlIllIIlllIIll;
        final char lIlIllIIlllIlII = (char)((String[])(Object)(lIlIllIIlllIIll = (Exception)(Object)lIlIllIIllllIlI)).length;
        for (String lIlIllIIlllIlIl = (String)0; lIlIllIIlllIlIl < lIlIllIIlllIlII; ++lIlIllIIlllIlIl) {
            final String lIlIllIIllllIIl = lIlIllIIlllIIll[lIlIllIIlllIlIl];
            final String lIlIllIIllllIII = System.getProperty(lIlIllIIllllIIl);
            if (lIlIllIIllllIII != null && lIlIllIIllllIII.contains("64")) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isConnectedToRealms() {
        return this.connectedToRealms;
    }
    
    public SoundHandler getSoundHandler() {
        return this.mcSoundHandler;
    }
    
    public String getVersion() {
        return this.launchedVersion;
    }
    
    private void runTickKeyboard() throws IOException {
        while (Keyboard.next()) {
            final int lIlIlIIlIIIIlII = (Keyboard.getEventKey() == 0) ? (Keyboard.getEventCharacter() + '\u0100') : Keyboard.getEventKey();
            if (this.debugCrashKeyPressTime > 0L) {
                if (getSystemTime() - this.debugCrashKeyPressTime >= 6000L) {
                    throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                }
                if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
                    this.debugCrashKeyPressTime = -1L;
                }
            }
            else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
                this.actionKeyF3 = true;
                this.debugCrashKeyPressTime = getSystemTime();
            }
            this.dispatchKeypresses();
            if (this.currentScreen != null) {
                this.currentScreen.handleKeyboardInput();
            }
            final boolean lIlIlIIlIIIIIll = Keyboard.getEventKeyState();
            if (lIlIlIIlIIIIIll) {
                if (lIlIlIIlIIIIlII == 62 && this.entityRenderer != null) {
                    this.entityRenderer.switchUseShader();
                }
                boolean lIlIlIIlIIIIIlI = false;
                final EventKey lIlIlIIlIIIIIIl = new EventKey(lIlIlIIlIIIIlII);
                lIlIlIIlIIIIIIl.call();
                if (this.currentScreen == null) {
                    if (lIlIlIIlIIIIlII == 1) {
                        this.displayInGameMenu();
                    }
                    lIlIlIIlIIIIIlI = (Keyboard.isKeyDown(61) && this.processKeyF3(lIlIlIIlIIIIlII));
                    this.actionKeyF3 |= lIlIlIIlIIIIIlI;
                    if (lIlIlIIlIIIIlII == 59) {
                        this.gameSettings.hideGUI = !this.gameSettings.hideGUI;
                    }
                }
                if (lIlIlIIlIIIIIlI) {
                    KeyBinding.setKeyBindState(lIlIlIIlIIIIlII, false);
                }
                else {
                    KeyBinding.setKeyBindState(lIlIlIIlIIIIlII, true);
                    KeyBinding.onTick(lIlIlIIlIIIIlII);
                }
                if (!this.gameSettings.showDebugProfilerChart) {
                    continue;
                }
                if (lIlIlIIlIIIIlII == 11) {
                    this.updateDebugProfilerName(0);
                }
                for (int lIlIlIIlIIIIIII = 0; lIlIlIIlIIIIIII < 9; ++lIlIlIIlIIIIIII) {
                    if (lIlIlIIlIIIIlII == 2 + lIlIlIIlIIIIIII) {
                        this.updateDebugProfilerName(lIlIlIIlIIIIIII + 1);
                    }
                }
            }
            else {
                KeyBinding.setKeyBindState(lIlIlIIlIIIIlII, false);
                if (lIlIlIIlIIIIlII != 61) {
                    continue;
                }
                if (this.actionKeyF3) {
                    this.actionKeyF3 = false;
                }
                else {
                    this.gameSettings.showDebugInfo = !this.gameSettings.showDebugInfo;
                    this.gameSettings.showDebugProfilerChart = (this.gameSettings.showDebugInfo && GuiScreen.isShiftKeyDown());
                    this.gameSettings.showLagometer = (this.gameSettings.showDebugInfo && GuiScreen.isAltKeyDown());
                }
            }
        }
        this.processKeyBinds();
    }
    
    public void crashed(final CrashReport lIlIllIIlIlllll) {
        this.hasCrashed = true;
        this.crashReporter = lIlIllIIlIlllll;
    }
    
    public RenderManager getRenderManager() {
        return this.renderManager;
    }
    
    public void updateDisplay() {
        this.mcProfiler.startSection("display_update");
        Display.update();
        this.mcProfiler.endSection();
        this.checkWindowResize();
    }
    
    public GuiToast func_193033_an() {
        return this.field_193034_aS;
    }
    
    public boolean isFullScreen() {
        return this.fullscreen;
    }
    
    public void loadWorld(@Nullable final WorldClient lIlIlIIIIIlllll) {
        this.loadWorld(lIlIlIIIIIlllll, "");
    }
    
    public void refreshResources() {
        final List<IResourcePack> lIlIllIIlIIlIlI = (List<IResourcePack>)Lists.newArrayList((Iterable)this.defaultResourcePacks);
        if (this.theIntegratedServer != null) {
            this.theIntegratedServer.func_193031_aM();
        }
        for (final ResourcePackRepository.Entry lIlIllIIlIIlIIl : this.mcResourcePackRepository.getRepositoryEntries()) {
            lIlIllIIlIIlIlI.add(lIlIllIIlIIlIIl.getResourcePack());
        }
        if (this.mcResourcePackRepository.getResourcePackInstance() != null) {
            lIlIllIIlIIlIlI.add(this.mcResourcePackRepository.getResourcePackInstance());
        }
        try {
            this.mcResourceManager.reloadResources(lIlIllIIlIIlIlI);
        }
        catch (RuntimeException lIlIllIIlIIlIII) {
            Minecraft.LOGGER.info("Caught error stitching, removing all assigned resourcepacks", (Throwable)lIlIllIIlIIlIII);
            lIlIllIIlIIlIlI.clear();
            lIlIllIIlIIlIlI.addAll(this.defaultResourcePacks);
            this.mcResourcePackRepository.setRepositories(Collections.emptyList());
            this.mcResourceManager.reloadResources(lIlIllIIlIIlIlI);
            this.gameSettings.resourcePacks.clear();
            this.gameSettings.incompatibleResourcePacks.clear();
            this.gameSettings.saveOptions();
        }
        this.mcLanguageManager.parseLanguageMetadata(lIlIllIIlIIlIlI);
        if (this.renderGlobal != null) {
            this.renderGlobal.loadRenderers();
        }
    }
    
    public Minecraft(final GameConfiguration lIlIllIllIIlIlI) {
        this.timer = new Timer(20.0f);
        this.usageSnooper = new Snooper("client", this, MinecraftServer.getCurrentTimeMillis());
        this.field_193995_ae = new SearchTreeManager();
        this.systemTime = getSystemTime();
        this.frameTimer = new FrameTimer();
        this.startNanoTime = System.nanoTime();
        this.mcProfiler = new Profiler();
        this.debugCrashKeyPressTime = -1L;
        this.metadataSerializer_ = new MetadataSerializer();
        this.defaultResourcePacks = (List<IResourcePack>)Lists.newArrayList();
        this.scheduledTasks = (Queue<FutureTask<?>>)Queues.newArrayDeque();
        this.mcThread = Thread.currentThread();
        this.running = true;
        this.debug = "";
        this.renderChunksMany = true;
        this.debugUpdateTime = getSystemTime();
        this.prevFrameTime = -1L;
        this.debugProfilerName = "root";
        Minecraft.theMinecraft = this;
        this.mcDataDir = lIlIllIllIIlIlI.folderInfo.mcDataDir;
        this.fileAssets = lIlIllIllIIlIlI.folderInfo.assetsDir;
        this.fileResourcepacks = lIlIllIllIIlIlI.folderInfo.resourcePacksDir;
        this.launchedVersion = lIlIllIllIIlIlI.gameInfo.version;
        this.versionType = lIlIllIllIIlIlI.gameInfo.versionType;
        this.twitchDetails = lIlIllIllIIlIlI.userInfo.userProperties;
        this.profileProperties = lIlIllIllIIlIlI.userInfo.profileProperties;
        this.mcDefaultResourcePack = new DefaultResourcePack(lIlIllIllIIlIlI.folderInfo.getAssetsIndex());
        this.proxy = ((lIlIllIllIIlIlI.userInfo.proxy == null) ? Proxy.NO_PROXY : lIlIllIllIIlIlI.userInfo.proxy);
        this.sessionService = new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString()).createMinecraftSessionService();
        this.session = lIlIllIllIIlIlI.userInfo.session;
        Minecraft.LOGGER.info("Setting user: {}", (Object)this.session.getUsername());
        Minecraft.LOGGER.debug("(Session ID is {})", (Object)this.session.getSessionID());
        this.isDemo = lIlIllIllIIlIlI.gameInfo.isDemo;
        this.displayWidth = ((lIlIllIllIIlIlI.displayInfo.width > 0) ? lIlIllIllIIlIlI.displayInfo.width : 1);
        this.displayHeight = ((lIlIllIllIIlIlI.displayInfo.height > 0) ? lIlIllIllIIlIlI.displayInfo.height : 1);
        this.tempDisplayWidth = lIlIllIllIIlIlI.displayInfo.width;
        this.tempDisplayHeight = lIlIllIllIIlIlI.displayInfo.height;
        this.fullscreen = lIlIllIllIIlIlI.displayInfo.fullscreen;
        this.jvm64bit = isJvm64bit();
        this.theIntegratedServer = null;
        if (lIlIllIllIIlIlI.serverInfo.serverName != null) {
            this.serverName = lIlIllIllIIlIlI.serverInfo.serverName;
            this.serverPort = lIlIllIllIIlIlI.serverInfo.serverPort;
        }
        ImageIO.setUseCache(false);
        Locale.setDefault(Locale.ROOT);
        Bootstrap.register();
        TextComponentKeybind.field_193637_b = KeyBinding::func_193626_b;
        this.dataFixer = DataFixesManager.createFixer();
        this.field_193034_aS = new GuiToast(this);
        this.field_193035_aW = new Tutorial(this);
    }
    
    public CrashReport addGraphicsAndWorldToCrashReport(final CrashReport lIlIIlllIllIIll) {
        lIlIIlllIllIIll.getCategory().setDetail("Launched Version", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Minecraft.this.launchedVersion;
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("LWJGL", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Sys.getVersion();
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("OpenGL", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(new StringBuilder(String.valueOf(GlStateManager.glGetString(7937))).append(" GL version ").append(GlStateManager.glGetString(7938)).append(", ").append(GlStateManager.glGetString(7936)));
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("GL Caps", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return OpenGlHelper.getLogText();
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("Using VBOs", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return Minecraft.this.gameSettings.useVbo ? "Yes" : "No";
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("Is Modded", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                final String lllllllllllllIlIlIlllIIlIIllllII = ClientBrandRetriever.getClientModName();
                if (!"vanilla".equals(lllllllllllllIlIlIlllIIlIIllllII)) {
                    return String.valueOf(new StringBuilder("Definitely; Client brand changed to '").append(lllllllllllllIlIlIlllIIlIIllllII).append("'"));
                }
                return (Minecraft.class.getSigners() == null) ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.";
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("Type", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return "Client (map_client.txt)";
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("Resource Packs", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                final StringBuilder llllllllllllllllIIlIlIIIlllllIll = new StringBuilder();
                for (final String llllllllllllllllIIlIlIIIlllllIlI : Minecraft.this.gameSettings.resourcePacks) {
                    if (llllllllllllllllIIlIlIIIlllllIll.length() > 0) {
                        llllllllllllllllIIlIlIIIlllllIll.append(", ");
                    }
                    llllllllllllllllIIlIlIIIlllllIll.append(llllllllllllllllIIlIlIIIlllllIlI);
                    if (Minecraft.this.gameSettings.incompatibleResourcePacks.contains(llllllllllllllllIIlIlIIIlllllIlI)) {
                        llllllllllllllllIIlIlIIIlllllIll.append(" (incompatible)");
                    }
                }
                return String.valueOf(llllllllllllllllIIlIlIIIlllllIll);
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("Current Language", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Minecraft.this.mcLanguageManager.getCurrentLanguage().toString();
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("Profiler Position", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return Minecraft.this.mcProfiler.profilingEnabled ? Minecraft.this.mcProfiler.getNameOfLastSection() : "N/A (disabled)";
            }
        });
        lIlIIlllIllIIll.getCategory().setDetail("CPU", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return OpenGlHelper.getCpu();
            }
        });
        if (this.world != null) {
            this.world.addWorldInfoToCrashReport(lIlIIlllIllIIll);
        }
        return lIlIIlllIllIIll;
    }
    
    public MusicTicker.MusicType getAmbientMusicType() {
        if (this.currentScreen instanceof GuiWinGame) {
            return MusicTicker.MusicType.CREDITS;
        }
        if (this.player == null) {
            return MusicTicker.MusicType.MENU;
        }
        if (this.player.world.provider instanceof WorldProviderHell) {
            return MusicTicker.MusicType.NETHER;
        }
        if (this.player.world.provider instanceof WorldProviderEnd) {
            return this.ingameGUI.getBossOverlay().shouldPlayEndBossMusic() ? MusicTicker.MusicType.END_BOSS : MusicTicker.MusicType.END;
        }
        return (this.player.capabilities.isCreativeMode && this.player.capabilities.allowFlying) ? MusicTicker.MusicType.CREATIVE : MusicTicker.MusicType.GAME;
    }
    
    private void runTickMouse() throws IOException {
        while (Mouse.next()) {
            final int lIlIlIIIlIllIll = Mouse.getEventButton();
            KeyBinding.setKeyBindState(lIlIlIIIlIllIll - 100, Mouse.getEventButtonState());
            if (Mouse.getEventButtonState()) {
                final EventMouse lIlIlIIIlIllIlI = new EventMouse(lIlIlIIIlIllIll);
                lIlIlIIIlIllIlI.call();
                if (this.player.isSpectator() && lIlIlIIIlIllIll == 2) {
                    this.ingameGUI.getSpectatorGui().onMiddleClick();
                }
                else {
                    KeyBinding.onTick(lIlIlIIIlIllIll - 100);
                }
            }
            final long lIlIlIIIlIllIIl = getSystemTime() - this.systemTime;
            if (lIlIlIIIlIllIIl <= 200L) {
                int lIlIlIIIlIllIII = Mouse.getEventDWheel();
                if (lIlIlIIIlIllIII != 0) {
                    if (this.player.isSpectator()) {
                        lIlIlIIIlIllIII = ((lIlIlIIIlIllIII < 0) ? -1 : 1);
                        if (this.ingameGUI.getSpectatorGui().isMenuActive()) {
                            this.ingameGUI.getSpectatorGui().onMouseScroll(-lIlIlIIIlIllIII);
                        }
                        else {
                            final float lIlIlIIIlIlIlll = MathHelper.clamp(this.player.capabilities.getFlySpeed() + lIlIlIIIlIllIII * 0.005f, 0.0f, 0.2f);
                            this.player.capabilities.setFlySpeed(lIlIlIIIlIlIlll);
                        }
                    }
                    else {
                        this.player.inventory.changeCurrentItem(lIlIlIIIlIllIII);
                    }
                }
                if (this.currentScreen == null) {
                    if (this.inGameHasFocus || !Mouse.getEventButtonState()) {
                        continue;
                    }
                    this.setIngameFocus();
                }
                else {
                    if (this.currentScreen == null) {
                        continue;
                    }
                    this.currentScreen.handleMouseInput();
                }
            }
        }
    }
    
    private void startGame() throws LWJGLException, IOException {
        this.gameSettings = new GameSettings(this, this.mcDataDir);
        this.field_191950_u = new CreativeSettings(this, this.mcDataDir);
        this.defaultResourcePacks.add(this.mcDefaultResourcePack);
        this.startTimerHackThread();
        if (this.gameSettings.overrideHeight > 0 && this.gameSettings.overrideWidth > 0) {
            this.displayWidth = this.gameSettings.overrideWidth;
            this.displayHeight = this.gameSettings.overrideHeight;
        }
        Minecraft.LOGGER.info("LWJGL Version: {}", (Object)Sys.getVersion());
        this.setWindowIcon();
        this.setInitialDisplayMode();
        this.createDisplay();
        OpenGlHelper.initializeTextures();
        this.framebufferMc = new Framebuffer(this.displayWidth, this.displayHeight, true);
        this.framebufferMc.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.registerMetadataSerializers();
        this.mcResourcePackRepository = new ResourcePackRepository(this.fileResourcepacks, new File(this.mcDataDir, "server-resource-packs"), this.mcDefaultResourcePack, this.metadataSerializer_, this.gameSettings);
        this.mcResourceManager = new SimpleReloadableResourceManager(this.metadataSerializer_);
        this.mcLanguageManager = new LanguageManager(this.metadataSerializer_, this.gameSettings.language);
        this.mcResourceManager.registerReloadListener(this.mcLanguageManager);
        this.refreshResources();
        this.renderEngine = new TextureManager(this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.renderEngine);
        this.drawSplashScreen(this.renderEngine);
        this.skinManager = new SkinManager(this.renderEngine, new File(this.fileAssets, "skins"), this.sessionService);
        this.saveLoader = new AnvilSaveConverter(new File(this.mcDataDir, "saves"), this.dataFixer);
        this.mcSoundHandler = new SoundHandler(this.mcResourceManager, this.gameSettings);
        this.mcResourceManager.registerReloadListener(this.mcSoundHandler);
        this.mcMusicTicker = new MusicTicker(this);
        this.fontRendererObj = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii.png"), this.renderEngine, false);
        if (this.gameSettings.language != null) {
            this.fontRendererObj.setUnicodeFlag(this.isUnicode());
            this.fontRendererObj.setBidiFlag(this.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        this.standardGalacticFontRenderer = new FontRenderer(this.gameSettings, new ResourceLocation("textures/font/ascii_sga.png"), this.renderEngine, false);
        this.mcResourceManager.registerReloadListener(this.fontRendererObj);
        this.mcResourceManager.registerReloadListener(this.standardGalacticFontRenderer);
        this.mcResourceManager.registerReloadListener(new GrassColorReloadListener());
        this.mcResourceManager.registerReloadListener(new FoliageColorReloadListener());
        this.mouseHelper = new MouseHelper();
        this.checkGLError("Pre startup");
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel(7425);
        GlStateManager.clearDepth(1.0);
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.cullFace(GlStateManager.CullFace.BACK);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        this.checkGLError("Startup");
        this.textureMapBlocks = new TextureMap("textures");
        this.textureMapBlocks.setMipmapLevels(this.gameSettings.mipmapLevels);
        this.renderEngine.loadTickableTexture(TextureMap.LOCATION_BLOCKS_TEXTURE, this.textureMapBlocks);
        this.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        this.textureMapBlocks.setBlurMipmapDirect(false, this.gameSettings.mipmapLevels > 0);
        this.modelManager = new ModelManager(this.textureMapBlocks);
        this.mcResourceManager.registerReloadListener(this.modelManager);
        this.blockColors = BlockColors.init();
        this.itemColors = ItemColors.init(this.blockColors);
        this.renderItem = new RenderItem(this.renderEngine, this.modelManager, this.itemColors);
        this.renderManager = new RenderManager(this.renderEngine, this.renderItem);
        this.itemRenderer = new ItemRenderer(this);
        this.mcResourceManager.registerReloadListener(this.renderItem);
        this.entityRenderer = new EntityRenderer(this, this.mcResourceManager);
        this.mcResourceManager.registerReloadListener(this.entityRenderer);
        this.blockRenderDispatcher = new BlockRendererDispatcher(this.modelManager.getBlockModelShapes(), this.blockColors);
        this.mcResourceManager.registerReloadListener(this.blockRenderDispatcher);
        this.renderGlobal = new RenderGlobal(this);
        this.mcResourceManager.registerReloadListener(this.renderGlobal);
        this.func_193986_ar();
        this.mcResourceManager.registerReloadListener(this.field_193995_ae);
        GlStateManager.viewport(0, 0, this.displayWidth, this.displayHeight);
        this.effectRenderer = new ParticleManager(this.world, this.renderEngine);
        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);
        if (this.serverName != null) {
            this.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), this, this.serverName, this.serverPort));
        }
        else {
            this.displayGuiScreen(new GuiMainMenu());
        }
        this.renderEngine.deleteTexture(this.mojangLogo);
        this.mojangLogo = null;
        this.loadingScreen = new LoadingScreenRenderer(this);
        this.debugRenderer = new DebugRenderer(this);
        if (this.gameSettings.fullScreen && !this.fullscreen) {
            this.toggleFullscreen();
        }
        try {
            Display.setVSyncEnabled(this.gameSettings.enableVsync);
        }
        catch (OpenGLException lIlIllIlIllIlII) {
            this.gameSettings.enableVsync = false;
            this.gameSettings.saveOptions();
        }
        Main.startClient();
        this.renderGlobal.makeEntityOutlineShader();
    }
    
    private void updateDebugProfilerName(int lIlIlIlIlllIllI) {
        final List<Profiler.Result> lIlIlIlIllllIlI = this.mcProfiler.getProfilingData(this.debugProfilerName);
        if (!lIlIlIlIllllIlI.isEmpty()) {
            final Profiler.Result lIlIlIlIllllIIl = lIlIlIlIllllIlI.remove(0);
            if (lIlIlIlIlllIllI == 0) {
                if (!lIlIlIlIllllIIl.profilerName.isEmpty()) {
                    final int lIlIlIlIllllIII = this.debugProfilerName.lastIndexOf(46);
                    if (lIlIlIlIllllIII >= 0) {
                        this.debugProfilerName = this.debugProfilerName.substring(0, lIlIlIlIllllIII);
                    }
                }
            }
            else if (--lIlIlIlIlllIllI < lIlIlIlIllllIlI.size() && !"unspecified".equals(lIlIlIlIllllIlI.get(lIlIlIlIlllIllI).profilerName)) {
                if (!this.debugProfilerName.isEmpty()) {
                    this.debugProfilerName = String.valueOf(new StringBuilder(String.valueOf(this.debugProfilerName)).append("."));
                }
                this.debugProfilerName = String.valueOf(new StringBuilder(String.valueOf(this.debugProfilerName)).append(lIlIlIlIllllIlI.get(lIlIlIlIlllIllI).profilerName));
            }
        }
    }
    
    public static int getGLMaximumTextureSize() {
        for (int lIlIIlllIIIlIll = 16384; lIlIIlllIIIlIll > 0; lIlIIlllIIIlIll >>= 1) {
            GlStateManager.glTexImage2D(32868, 0, 6408, lIlIIlllIIIlIll, lIlIIlllIIIlIll, 0, 6408, 5121, null);
            final int lIlIIlllIIIlIlI = GlStateManager.glGetTexLevelParameteri(32868, 0, 4096);
            if (lIlIIlllIIIlIlI != 0) {
                return lIlIIlllIIIlIll;
            }
        }
        return -1;
    }
    
    private void checkGLError(final String lIlIlIllIllIlIl) {
        final int lIlIlIllIllIlll = GlStateManager.glGetError();
        if (lIlIlIllIllIlll != 0) {
            final String lIlIlIllIllIllI = GLU.gluErrorString(lIlIlIllIllIlll);
            Minecraft.LOGGER.error("########## GL ERROR ##########");
            Minecraft.LOGGER.error("@ {}", (Object)lIlIlIllIllIlIl);
            Minecraft.LOGGER.error("{}: {}", (Object)lIlIlIllIllIlll, (Object)lIlIlIllIllIllI);
        }
    }
    
    public BlockColors getBlockColors() {
        return this.blockColors;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        LOCATION_MOJANG_PNG = new ResourceLocation("textures/gui/title/mojang.png");
        IS_RUNNING_ON_MAC = (Util.getOSType() == Util.EnumOS.OSX);
        Minecraft.memoryReserve = new byte[10485760];
        MAC_DISPLAY_MODES = Lists.newArrayList((Object[])new DisplayMode[] { new DisplayMode(2560, 1600), new DisplayMode(2880, 1800) });
    }
    
    @Nullable
    public Entity getRenderViewEntity() {
        return this.renderViewEntity;
    }
    
    public static boolean isGuiEnabled() {
        return Minecraft.theMinecraft == null || !Minecraft.theMinecraft.gameSettings.hideGUI;
    }
    
    public static Minecraft getMinecraft() {
        return Minecraft.theMinecraft;
    }
    
    private void processKeyBinds() {
        while (this.gameSettings.keyBindTogglePerspective.isPressed()) {
            final GameSettings gameSettings = this.gameSettings;
            ++gameSettings.thirdPersonView;
            if (this.gameSettings.thirdPersonView > 2) {
                this.gameSettings.thirdPersonView = 0;
            }
            if (this.gameSettings.thirdPersonView == 0) {
                this.entityRenderer.loadEntityShader(this.getRenderViewEntity());
            }
            else if (this.gameSettings.thirdPersonView == 1) {
                this.entityRenderer.loadEntityShader(null);
            }
            this.renderGlobal.setDisplayListEntitiesDirty();
        }
        while (this.gameSettings.keyBindSmoothCamera.isPressed()) {
            this.gameSettings.smoothCamera = !this.gameSettings.smoothCamera;
        }
        for (int lIlIlIIIllIlIIl = 0; lIlIlIIIllIlIIl < 9; ++lIlIlIIIllIlIIl) {
            final boolean lIlIlIIIllIlIII = this.gameSettings.field_193629_ap.isKeyDown();
            final boolean lIlIlIIIllIIlll = this.gameSettings.field_193630_aq.isKeyDown();
            if (this.gameSettings.keyBindsHotbar[lIlIlIIIllIlIIl].isPressed()) {
                if (this.player.isSpectator()) {
                    this.ingameGUI.getSpectatorGui().onHotbarSelected(lIlIlIIIllIlIIl);
                }
                else if (!this.player.isCreative() || this.currentScreen != null || (!lIlIlIIIllIIlll && !lIlIlIIIllIlIII)) {
                    this.player.inventory.currentItem = lIlIlIIIllIlIIl;
                }
                else {
                    GuiContainerCreative.func_192044_a(this, lIlIlIIIllIlIIl, lIlIlIIIllIIlll, lIlIlIIIllIlIII);
                }
            }
        }
        while (this.gameSettings.keyBindInventory.isPressed()) {
            if (this.playerController.isRidingHorse()) {
                this.player.sendHorseInventory();
            }
            else {
                this.field_193035_aW.func_193296_a();
                this.displayGuiScreen(new GuiInventory(this.player));
            }
        }
        while (this.gameSettings.field_194146_ao.isPressed()) {
            this.displayGuiScreen(new GuiScreenAdvancements(this.player.connection.func_191982_f()));
        }
        while (this.gameSettings.keyBindSwapHands.isPressed()) {
            if (!this.player.isSpectator()) {
                this.getConnection().sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.SWAP_HELD_ITEMS, BlockPos.ORIGIN, EnumFacing.DOWN));
            }
        }
        while (this.gameSettings.keyBindDrop.isPressed()) {
            if (!this.player.isSpectator()) {
                this.player.dropItem(GuiScreen.isCtrlKeyDown());
            }
        }
        final boolean lIlIlIIIllIIllI = this.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN;
        if (lIlIlIIIllIIllI) {
            while (this.gameSettings.keyBindChat.isPressed()) {
                this.displayGuiScreen(new GuiChat());
            }
            if (this.currentScreen == null && this.gameSettings.keyBindCommand.isPressed()) {
                this.displayGuiScreen(new GuiChat("/"));
            }
        }
        if (this.player.isHandActive()) {
            if (!this.gameSettings.keyBindUseItem.isKeyDown()) {
                this.playerController.onStoppedUsingItem(this.player);
            }
            while (this.gameSettings.keyBindAttack.isPressed()) {}
            while (this.gameSettings.keyBindUseItem.isPressed()) {}
            while (this.gameSettings.keyBindPickBlock.isPressed()) {}
        }
        else {
            while (this.gameSettings.keyBindAttack.isPressed()) {
                this.clickMouse();
            }
            while (this.gameSettings.keyBindUseItem.isPressed()) {
                this.rightClickMouse();
            }
            while (this.gameSettings.keyBindPickBlock.isPressed()) {
                this.middleClickMouse();
            }
        }
        if (this.gameSettings.keyBindUseItem.isKeyDown() && this.rightClickDelayTimer == 0 && !this.player.isHandActive()) {
            this.rightClickMouse();
        }
        this.sendClickBlockToController(this.currentScreen == null && this.gameSettings.keyBindAttack.isKeyDown() && this.inGameHasFocus);
    }
    
    public ResourcePackRepository getResourcePackRepository() {
        return this.mcResourcePackRepository;
    }
    
    public MinecraftSessionService getSessionService() {
        return this.sessionService;
    }
    
    public void setIngameNotInFocus() {
        if (this.inGameHasFocus) {
            this.inGameHasFocus = false;
            this.mouseHelper.ungrabMouseCursor();
        }
    }
    
    public FrameTimer getFrameTimer() {
        return this.frameTimer;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type() {
        final int[] $switch_TABLE$net$minecraft$util$math$RayTraceResult$Type = Minecraft.$SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type;
        if ($switch_TABLE$net$minecraft$util$math$RayTraceResult$Type != null) {
            return $switch_TABLE$net$minecraft$util$math$RayTraceResult$Type;
        }
        final float lIlIIlIlllIIlII = (Object)new int[RayTraceResult.Type.values().length];
        try {
            lIlIIlIlllIIlII[RayTraceResult.Type.BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lIlIIlIlllIIlII[RayTraceResult.Type.ENTITY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lIlIIlIlllIIlII[RayTraceResult.Type.MISS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Minecraft.$SWITCH_TABLE$net$minecraft$util$math$RayTraceResult$Type = (int[])(Object)lIlIIlIlllIIlII;
    }
    
    public Session getSession() {
        return this.session;
    }
    
    public SkinManager getSkinManager() {
        return this.skinManager;
    }
    
    public void setConnectedToRealms(final boolean lIlIIlIlllllIll) {
        this.connectedToRealms = lIlIIlIlllllIll;
    }
    
    private void drawSplashScreen(final TextureManager lIlIlIlllllllll) throws LWJGLException {
        final ScaledResolution lIlIllIIIIIlIIl = new ScaledResolution(this);
        final int lIlIllIIIIIlIII = lIlIllIIIIIlIIl.getScaleFactor();
        final Framebuffer lIlIllIIIIIIlll = new Framebuffer(lIlIllIIIIIlIIl.getScaledWidth() * lIlIllIIIIIlIII, lIlIllIIIIIlIIl.getScaledHeight() * lIlIllIIIIIlIII, true);
        lIlIllIIIIIIlll.bindFramebuffer(false);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, lIlIllIIIIIlIIl.getScaledWidth(), lIlIllIIIIIlIIl.getScaledHeight(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        InputStream lIlIllIIIIIIllI = null;
        Label_0191: {
            try {
                lIlIllIIIIIIllI = this.mcDefaultResourcePack.getInputStream(Minecraft.LOCATION_MOJANG_PNG);
                this.mojangLogo = lIlIlIlllllllll.getDynamicTextureLocation("logo", new DynamicTexture(ImageIO.read(lIlIllIIIIIIllI)));
                lIlIlIlllllllll.bindTexture(this.mojangLogo);
            }
            catch (IOException lIlIllIIIIIIlIl) {
                Minecraft.LOGGER.error("Unable to load logo: {}", (Object)Minecraft.LOCATION_MOJANG_PNG, (Object)lIlIllIIIIIIlIl);
                break Label_0191;
            }
            finally {
                IOUtils.closeQuietly(lIlIllIIIIIIllI);
            }
            IOUtils.closeQuietly(lIlIllIIIIIIllI);
        }
        final Tessellator lIlIllIIIIIIlII = Tessellator.getInstance();
        final BufferBuilder lIlIllIIIIIIIll = lIlIllIIIIIIlII.getBuffer();
        lIlIllIIIIIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lIlIllIIIIIIIll.pos(0.0, this.displayHeight, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lIlIllIIIIIIIll.pos(this.displayWidth, this.displayHeight, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lIlIllIIIIIIIll.pos(this.displayWidth, 0.0, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lIlIllIIIIIIIll.pos(0.0, 0.0, 0.0).tex(0.0, 0.0).color(255, 255, 255, 255).endVertex();
        lIlIllIIIIIIlII.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lIlIllIIIIIIIlI = 256;
        final int lIlIllIIIIIIIIl = 256;
        this.draw((lIlIllIIIIIlIIl.getScaledWidth() - 256) / 2, (lIlIllIIIIIlIIl.getScaledHeight() - 256) / 2, 0, 0, 256, 256, 255, 255, 255, 255);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        lIlIllIIIIIIlll.unbindFramebuffer();
        lIlIllIIIIIIlll.framebufferRender(lIlIllIIIIIlIIl.getScaledWidth() * lIlIllIIIIIlIII, lIlIllIIIIIlIIl.getScaledHeight() * lIlIllIIIIIlIII);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.updateDisplay();
    }
    
    public <V> ListenableFuture<V> addScheduledTask(final Callable<V> lIlIIllIIlIlIII) {
        Validate.notNull((Object)lIlIIllIIlIlIII);
        if (this.isCallingFromMinecraftThread()) {
            try {
                return (ListenableFuture<V>)Futures.immediateFuture((Object)lIlIIllIIlIlIII.call());
            }
            catch (Exception lIlIIllIIlIIlll) {
                return (ListenableFuture<V>)Futures.immediateFailedCheckedFuture(lIlIIllIIlIIlll);
            }
        }
        final ListenableFutureTask<V> lIlIIllIIlIIllI = (ListenableFutureTask<V>)ListenableFutureTask.create((Callable)lIlIIllIIlIlIII);
        synchronized (this.scheduledTasks) {
            this.scheduledTasks.add((FutureTask<?>)lIlIIllIIlIIllI);
            final ListenableFutureTask<V> listenableFutureTask = lIlIIllIIlIIllI;
            // monitorexit(this.scheduledTasks)
            return (ListenableFuture<V>)listenableFutureTask;
        }
    }
    
    public void runTick() throws IOException {
        if (this.rightClickDelayTimer > 0) {
            --this.rightClickDelayTimer;
        }
        this.mcProfiler.startSection("gui");
        if (!this.isGamePaused) {
            this.ingameGUI.updateTick();
        }
        this.mcProfiler.endSection();
        this.entityRenderer.getMouseOver(1.0f);
        this.field_193035_aW.func_193297_a(this.world, this.objectMouseOver);
        this.mcProfiler.startSection("gameMode");
        if (!this.isGamePaused && this.world != null) {
            this.playerController.updateController();
        }
        this.mcProfiler.endStartSection("textures");
        if (this.world != null) {
            this.renderEngine.tick();
        }
        if (this.currentScreen == null && this.player != null) {
            if (this.player.getHealth() <= 0.0f && !(this.currentScreen instanceof GuiGameOver)) {
                this.displayGuiScreen(null);
            }
            else if (this.player.isPlayerSleeping() && this.world != null) {
                this.displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (this.currentScreen != null && this.currentScreen instanceof GuiSleepMP && !this.player.isPlayerSleeping()) {
            this.displayGuiScreen(null);
        }
        if (this.currentScreen != null) {
            this.leftClickCounter = 10000;
        }
        if (this.currentScreen != null) {
            try {
                this.currentScreen.handleInput();
            }
            catch (Throwable lIlIlIIlIIllIII) {
                final CrashReport lIlIlIIlIIlIlll = CrashReport.makeCrashReport(lIlIlIIlIIllIII, "Updating screen events");
                final CrashReportCategory lIlIlIIlIIlIllI = lIlIlIIlIIlIlll.makeCategory("Affected screen");
                lIlIlIIlIIlIllI.setDetail("Screen name", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return Minecraft.this.currentScreen.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(lIlIlIIlIIlIlll);
            }
            if (this.currentScreen != null) {
                try {
                    this.currentScreen.updateScreen();
                }
                catch (Throwable lIlIlIIlIIlIlIl) {
                    final CrashReport lIlIlIIlIIlIlII = CrashReport.makeCrashReport(lIlIlIIlIIlIlIl, "Ticking screen");
                    final CrashReportCategory lIlIlIIlIIlIIll = lIlIlIIlIIlIlII.makeCategory("Affected screen");
                    lIlIlIIlIIlIIll.setDetail("Screen name", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return Minecraft.this.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    throw new ReportedException(lIlIlIIlIIlIlII);
                }
            }
        }
        if (this.currentScreen == null || this.currentScreen.allowUserInput) {
            this.mcProfiler.endStartSection("mouse");
            this.runTickMouse();
            if (this.leftClickCounter > 0) {
                --this.leftClickCounter;
            }
            this.mcProfiler.endStartSection("keyboard");
            this.runTickKeyboard();
        }
        if (this.world != null) {
            if (this.player != null) {
                ++this.joinPlayerCounter;
                if (this.joinPlayerCounter == 30) {
                    this.joinPlayerCounter = 0;
                    this.world.joinEntityInSurroundings(this.player);
                }
            }
            this.mcProfiler.endStartSection("gameRenderer");
            if (!this.isGamePaused) {
                this.entityRenderer.updateRenderer();
            }
            this.mcProfiler.endStartSection("levelRenderer");
            if (!this.isGamePaused) {
                this.renderGlobal.updateClouds();
            }
            this.mcProfiler.endStartSection("level");
            if (!this.isGamePaused) {
                if (this.world.getLastLightningBolt() > 0) {
                    this.world.setLastLightningBolt(this.world.getLastLightningBolt() - 1);
                }
                this.world.updateEntities();
            }
        }
        else if (this.entityRenderer.isShaderActive()) {
            this.entityRenderer.stopUseShader();
        }
        if (!this.isGamePaused) {
            this.mcMusicTicker.update();
            this.mcSoundHandler.update();
        }
        if (this.world != null) {
            if (!this.isGamePaused) {
                this.world.setAllowedSpawnTypes(this.world.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                this.field_193035_aW.func_193303_d();
                try {
                    this.world.tick();
                }
                catch (Throwable lIlIlIIlIIlIIlI) {
                    final CrashReport lIlIlIIlIIlIIIl = CrashReport.makeCrashReport(lIlIlIIlIIlIIlI, "Exception in world tick");
                    if (this.world == null) {
                        final CrashReportCategory lIlIlIIlIIlIIII = lIlIlIIlIIlIIIl.makeCategory("Affected level");
                        lIlIlIIlIIlIIII.addCrashSection("Problem", "Level is null!");
                    }
                    else {
                        this.world.addWorldInfoToCrashReport(lIlIlIIlIIlIIIl);
                    }
                    throw new ReportedException(lIlIlIIlIIlIIIl);
                }
            }
            this.mcProfiler.endStartSection("animateTick");
            if (!this.isGamePaused && this.world != null) {
                this.world.doVoidFogParticles(MathHelper.floor(this.player.posX), MathHelper.floor(this.player.posY), MathHelper.floor(this.player.posZ));
            }
            this.mcProfiler.endStartSection("particles");
            if (!this.isGamePaused) {
                this.effectRenderer.updateEffects();
            }
        }
        else if (this.myNetworkManager != null) {
            this.mcProfiler.endStartSection("pendingConnection");
            this.myNetworkManager.processReceivedPackets();
        }
        this.mcProfiler.endSection();
        this.systemTime = getSystemTime();
    }
    
    private String getCurrentAction() {
        if (this.theIntegratedServer != null) {
            return this.theIntegratedServer.getPublic() ? "hosting_lan" : "singleplayer";
        }
        if (this.currentServerData != null) {
            return this.currentServerData.isOnLAN() ? "playing_lan" : "multiplayer";
        }
        return "out_of_game";
    }
    
    private void createDisplay() throws LWJGLException {
        Display.setResizable(true);
        Display.setTitle(Main.name);
        try {
            Display.create(new PixelFormat().withDepthBits(24));
        }
        catch (LWJGLException lIlIllIlIIllIll) {
            Minecraft.LOGGER.error("Couldn't set pixel format", (Throwable)lIlIllIlIIllIll);
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex) {}
            if (this.fullscreen) {
                this.updateDisplayMode();
            }
            Display.create();
        }
    }
    
    public void loadWorld(@Nullable final WorldClient lIlIlIIIIIlIllI, final String lIlIlIIIIIIllIl) {
        if (lIlIlIIIIIlIllI == null) {
            final NetHandlerPlayClient lIlIlIIIIIlIlII = this.getConnection();
            if (lIlIlIIIIIlIlII != null) {
                lIlIlIIIIIlIlII.cleanup();
            }
            if (this.theIntegratedServer != null && this.theIntegratedServer.isAnvilFileSet()) {
                this.theIntegratedServer.initiateShutdown();
            }
            this.theIntegratedServer = null;
            this.entityRenderer.func_190564_k();
            this.playerController = null;
            NarratorChatListener.field_193643_a.func_193642_b();
        }
        this.renderViewEntity = null;
        this.myNetworkManager = null;
        if (this.loadingScreen != null) {
            this.loadingScreen.resetProgressAndMessage(lIlIlIIIIIIllIl);
            this.loadingScreen.displayLoadingString("");
        }
        if (lIlIlIIIIIlIllI == null && this.world != null) {
            this.mcResourcePackRepository.clearResourcePack();
            this.ingameGUI.resetPlayersOverlayFooterHeader();
            this.setServerData(null);
            this.integratedServerIsRunning = false;
        }
        this.mcSoundHandler.stopSounds();
        this.world = lIlIlIIIIIlIllI;
        if (this.renderGlobal != null) {
            this.renderGlobal.setWorldAndLoadRenderers(lIlIlIIIIIlIllI);
        }
        if (this.effectRenderer != null) {
            this.effectRenderer.clearEffects(lIlIlIIIIIlIllI);
        }
        TileEntityRendererDispatcher.instance.setWorld(lIlIlIIIIIlIllI);
        if (lIlIlIIIIIlIllI != null) {
            if (!this.integratedServerIsRunning) {
                final AuthenticationService lIlIlIIIIIlIIll = (AuthenticationService)new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString());
                final MinecraftSessionService lIlIlIIIIIlIIlI = lIlIlIIIIIlIIll.createMinecraftSessionService();
                final GameProfileRepository lIlIlIIIIIlIIIl = lIlIlIIIIIlIIll.createProfileRepository();
                final PlayerProfileCache lIlIlIIIIIlIIII = new PlayerProfileCache(lIlIlIIIIIlIIIl, new File(this.mcDataDir, MinecraftServer.USER_CACHE_FILE.getName()));
                TileEntitySkull.setProfileCache(lIlIlIIIIIlIIII);
                TileEntitySkull.setSessionService(lIlIlIIIIIlIIlI);
                PlayerProfileCache.setOnlineMode(false);
            }
            if (this.player == null) {
                this.player = this.playerController.func_192830_a(lIlIlIIIIIlIllI, new StatisticsManager(), new RecipeBookClient());
                this.playerController.flipPlayer(this.player);
            }
            this.player.preparePlayerToSpawn();
            lIlIlIIIIIlIllI.spawnEntityInWorld(this.player);
            this.player.movementInput = new MovementInputFromOptions(this.gameSettings);
            this.playerController.setPlayerCapabilities(this.player);
            this.renderViewEntity = this.player;
        }
        else {
            this.saveLoader.flushCache();
            this.player = null;
        }
        System.gc();
        this.systemTime = 0L;
    }
    
    public PropertyMap getProfileProperties() {
        if (this.profileProperties.isEmpty()) {
            final GameProfile lIlIIllIllIIIll = this.getSessionService().fillProfileProperties(this.session.getProfile(), false);
            this.profileProperties.putAll((Multimap)lIlIIllIllIIIll.getProperties());
        }
        return this.profileProperties;
    }
    
    private void func_193986_ar() {
        final SearchTree<ItemStack> lIlIllIlIlIlIll = new SearchTree<ItemStack>(lIlIIlIllIlllII -> lIlIIlIllIlllII.getTooltip(null, ITooltipFlag.TooltipFlags.NORMAL).stream().map((Function<? super Object, ?>)TextFormatting::getTextWithoutFormattingCodes).map((Function<? super Object, ?>)String::trim).filter(lIlIIlIllIlIIII -> !lIlIIlIllIlIIII.isEmpty()).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()), lIlIIlIllIllIII -> Collections.singleton(Item.REGISTRY.getNameForObject(lIlIIlIllIllIII.getItem())));
        final NonNullList<ItemStack> lIlIllIlIlIlIlI = NonNullList.func_191196_a();
        for (final Item lIlIllIlIlIlIIl : Item.REGISTRY) {
            lIlIllIlIlIlIIl.getSubItems(CreativeTabs.SEARCH, lIlIllIlIlIlIlI);
        }
        lIlIllIlIlIlIlI.forEach(lIlIllIlIlIlIll::func_194043_a);
        final SearchTree<RecipeList> lIlIllIlIlIlIII = new SearchTree<RecipeList>(lIlIIlIllIlIllI -> lIlIIlIllIlIllI.func_192711_b().stream().flatMap(lIlIIlIllIIllIl -> lIlIIlIllIIllIl.getRecipeOutput().getTooltip(null, ITooltipFlag.TooltipFlags.NORMAL).stream()).map((Function<? super Object, ?>)TextFormatting::getTextWithoutFormattingCodes).map((Function<? super Object, ?>)String::trim).filter(lIlIIlIllIIlIIl -> !lIlIIlIllIIlIIl.isEmpty()).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()), lIlIIlIllIlIIll -> lIlIIlIllIlIIll.func_192711_b().stream().map(lIlIIlIllIIIllI -> Item.REGISTRY.getNameForObject(lIlIIlIllIIIllI.getRecipeOutput().getItem())).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
        RecipeBookClient.field_194087_f.forEach(lIlIllIlIlIlIII::func_194043_a);
        this.field_193995_ae.func_194009_a(SearchTreeManager.field_194011_a, lIlIllIlIlIlIll);
        this.field_193995_ae.func_194009_a(SearchTreeManager.field_194012_b, lIlIllIlIlIlIII);
    }
    
    public ListenableFuture<Object> scheduleResourcesRefresh() {
        return this.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                Minecraft.this.refreshResources();
            }
        });
    }
    
    public DataFixer getDataFixer() {
        return this.dataFixer;
    }
    
    private void updateFramebufferSize() {
        this.framebufferMc.createBindFramebuffer(this.displayWidth, this.displayHeight);
        if (this.entityRenderer != null) {
            this.entityRenderer.updateShaderGroupSize(this.displayWidth, this.displayHeight);
        }
    }
    
    public boolean isIntegratedServerRunning() {
        return this.integratedServerIsRunning;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public RenderItem getRenderItem() {
        return this.renderItem;
    }
    
    public LanguageManager getLanguageManager() {
        return this.mcLanguageManager;
    }
    
    private ItemStack storeTEInStack(final ItemStack lIlIIlllIlllIll, final TileEntity lIlIIllllIIIIIl) {
        final NBTTagCompound lIlIIllllIIIIII = lIlIIllllIIIIIl.writeToNBT(new NBTTagCompound());
        if (lIlIIlllIlllIll.getItem() == Items.SKULL && lIlIIllllIIIIII.hasKey("Owner")) {
            final NBTTagCompound lIlIIlllIllllll = lIlIIllllIIIIII.getCompoundTag("Owner");
            final NBTTagCompound lIlIIlllIlllllI = new NBTTagCompound();
            lIlIIlllIlllllI.setTag("SkullOwner", lIlIIlllIllllll);
            lIlIIlllIlllIll.setTagCompound(lIlIIlllIlllllI);
            return lIlIIlllIlllIll;
        }
        lIlIIlllIlllIll.setTagInfo("BlockEntityTag", lIlIIllllIIIIII);
        final NBTTagCompound lIlIIlllIllllIl = new NBTTagCompound();
        final NBTTagList lIlIIlllIllllII = new NBTTagList();
        lIlIIlllIllllII.appendTag(new NBTTagString("(+NBT)"));
        lIlIIlllIllllIl.setTag("Lore", lIlIIlllIllllII);
        lIlIIlllIlllIll.setTagInfo("display", lIlIIlllIllllIl);
        return lIlIIlllIlllIll;
    }
    
    public void launchIntegratedServer(final String lIlIlIIIIlIllIl, final String lIlIlIIIIlIllII, @Nullable WorldSettings lIlIlIIIIlIlIll) {
        this.loadWorld(null);
        System.gc();
        final ISaveHandler lIlIlIIIIlllIlI = this.saveLoader.getSaveLoader(lIlIlIIIIlIllIl, false);
        WorldInfo lIlIlIIIIlllIIl = lIlIlIIIIlllIlI.loadWorldInfo();
        if (lIlIlIIIIlllIIl == null && lIlIlIIIIlIlIll != null) {
            lIlIlIIIIlllIIl = new WorldInfo((WorldSettings)lIlIlIIIIlIlIll, lIlIlIIIIlIllIl);
            lIlIlIIIIlllIlI.saveWorldInfo(lIlIlIIIIlllIIl);
        }
        if (lIlIlIIIIlIlIll == null) {
            lIlIlIIIIlIlIll = new WorldSettings(lIlIlIIIIlllIIl);
        }
        try {
            final YggdrasilAuthenticationService lIlIlIIIIlllIII = new YggdrasilAuthenticationService(this.proxy, UUID.randomUUID().toString());
            final MinecraftSessionService lIlIlIIIIllIlll = lIlIlIIIIlllIII.createMinecraftSessionService();
            final GameProfileRepository lIlIlIIIIllIllI = lIlIlIIIIlllIII.createProfileRepository();
            final PlayerProfileCache lIlIlIIIIllIlIl = new PlayerProfileCache(lIlIlIIIIllIllI, new File(this.mcDataDir, MinecraftServer.USER_CACHE_FILE.getName()));
            TileEntitySkull.setProfileCache(lIlIlIIIIllIlIl);
            TileEntitySkull.setSessionService(lIlIlIIIIllIlll);
            PlayerProfileCache.setOnlineMode(false);
            this.theIntegratedServer = new IntegratedServer(this, lIlIlIIIIlIllIl, lIlIlIIIIlIllII, (WorldSettings)lIlIlIIIIlIlIll, lIlIlIIIIlllIII, lIlIlIIIIllIlll, lIlIlIIIIllIllI, lIlIlIIIIllIlIl);
            this.theIntegratedServer.startServerThread();
            this.integratedServerIsRunning = true;
        }
        catch (Throwable lIlIlIIIIllIlII) {
            final CrashReport lIlIlIIIIllIIll = CrashReport.makeCrashReport(lIlIlIIIIllIlII, "Starting integrated server");
            final CrashReportCategory lIlIlIIIIllIIlI = lIlIlIIIIllIIll.makeCategory("Starting integrated server");
            lIlIlIIIIllIIlI.addCrashSection("Level ID", lIlIlIIIIlIllIl);
            lIlIlIIIIllIIlI.addCrashSection("Level Name", lIlIlIIIIlIllII);
            throw new ReportedException(lIlIlIIIIllIIll);
        }
        this.loadingScreen.displaySavingString(I18n.format("menu.loadingLevel", new Object[0]));
        while (!this.theIntegratedServer.serverIsInRunLoop()) {
            final String lIlIlIIIIllIIIl = this.theIntegratedServer.getUserMessage();
            if (lIlIlIIIIllIIIl != null) {
                this.loadingScreen.displayLoadingString(I18n.format(lIlIlIIIIllIIIl, new Object[0]));
            }
            else {
                this.loadingScreen.displayLoadingString("");
            }
            try {
                Thread.sleep(200L);
            }
            catch (InterruptedException ex) {}
        }
        this.displayGuiScreen(new GuiScreenWorking());
        final SocketAddress lIlIlIIIIllIIII = this.theIntegratedServer.getNetworkSystem().addLocalEndpoint();
        final NetworkManager lIlIlIIIIlIllll = NetworkManager.provideLocalClient(lIlIlIIIIllIIII);
        lIlIlIIIIlIllll.setNetHandler(new NetHandlerLoginClient(lIlIlIIIIlIllll, this, null));
        lIlIlIIIIlIllll.sendPacket(new C00Handshake(lIlIlIIIIllIIII.toString(), 0, EnumConnectionState.LOGIN));
        lIlIlIIIIlIllll.sendPacket(new CPacketLoginStart(this.getSession().getProfile()));
        this.myNetworkManager = lIlIlIIIIlIllll;
    }
    
    protected void checkWindowResize() {
        if (!this.fullscreen && Display.wasResized()) {
            final int lIlIlIllIIlIIIl = this.displayWidth;
            final int lIlIlIllIIlIIII = this.displayHeight;
            this.displayWidth = Display.getWidth();
            this.displayHeight = Display.getHeight();
            if (this.displayWidth != lIlIlIllIIlIIIl || this.displayHeight != lIlIlIllIIlIIII) {
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
                this.resize(this.displayWidth, this.displayHeight);
            }
        }
    }
    
    @Override
    public boolean isSnooperEnabled() {
        return this.gameSettings.snooperEnabled;
    }
    
    public <T> ISearchTree<T> func_193987_a(final SearchTreeManager.Key<T> lIlIIllIIIIlIIl) {
        return this.field_193995_ae.func_194010_a(lIlIIllIIIIlIIl);
    }
    
    public final boolean isDemo() {
        return this.isDemo;
    }
    
    public static boolean isFancyGraphicsEnabled() {
        return Minecraft.theMinecraft != null && Minecraft.theMinecraft.gameSettings.fancyGraphics;
    }
    
    public int getLimitFramerate() {
        return (this.world == null && this.currentScreen != null) ? 30 : this.gameSettings.limitFramerate;
    }
    
    public Framebuffer getFramebuffer() {
        return this.framebufferMc;
    }
    
    private void resize(final int lIlIlIIlIlIIllI, final int lIlIlIIlIlIlIIl) {
        this.displayWidth = Math.max(1, lIlIlIIlIlIIllI);
        this.displayHeight = Math.max(1, lIlIlIIlIlIlIIl);
        if (this.currentScreen != null) {
            final ScaledResolution lIlIlIIlIlIlIII = new ScaledResolution(this);
            this.currentScreen.onResize(this, lIlIlIIlIlIlIII.getScaledWidth(), lIlIlIIlIlIlIII.getScaledHeight());
        }
        this.loadingScreen = new LoadingScreenRenderer(this);
        this.updateFramebufferSize();
    }
    
    public static int getDebugFPS() {
        return Minecraft.debugFPS;
    }
    
    public static void stopIntegratedServer() {
        if (Minecraft.theMinecraft != null) {
            final IntegratedServer lIlIIllIlllIIIl = Minecraft.theMinecraft.getIntegratedServer();
            if (lIlIIllIlllIIIl != null) {
                lIlIIllIlllIIIl.stopServer();
            }
        }
    }
    
    public Tutorial func_193032_ao() {
        return this.field_193035_aW;
    }
    
    public boolean isFramerateLimitBelowMax() {
        return this.getLimitFramerate() < GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
    }
    
    public float getRenderPartialTicks() {
        return this.timer.elapsedPartialTicks;
    }
    
    public void draw(final int lIlIlIllllIlIII, final int lIlIlIllllIIlll, final int lIlIlIllllIIllI, final int lIlIlIllllIIlIl, final int lIlIlIlllIlIlll, final int lIlIlIlllIlIllI, final int lIlIlIlllIlIlIl, final int lIlIlIlllIlIlII, final int lIlIlIlllIlIIll, final int lIlIlIlllIlllll) {
        final BufferBuilder lIlIlIlllIllllI = Tessellator.getInstance().getBuffer();
        lIlIlIlllIllllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        final float lIlIlIlllIlllIl = 0.00390625f;
        final float lIlIlIlllIlllII = 0.00390625f;
        lIlIlIlllIllllI.pos(lIlIlIllllIlIII, lIlIlIllllIIlll + lIlIlIlllIlIllI, 0.0).tex(lIlIlIllllIIllI * 0.00390625f, (lIlIlIllllIIlIl + lIlIlIlllIlIllI) * 0.00390625f).color(lIlIlIlllIlIlIl, lIlIlIlllIlIlII, lIlIlIlllIlIIll, lIlIlIlllIlllll).endVertex();
        lIlIlIlllIllllI.pos(lIlIlIllllIlIII + lIlIlIlllIlIlll, lIlIlIllllIIlll + lIlIlIlllIlIllI, 0.0).tex((lIlIlIllllIIllI + lIlIlIlllIlIlll) * 0.00390625f, (lIlIlIllllIIlIl + lIlIlIlllIlIllI) * 0.00390625f).color(lIlIlIlllIlIlIl, lIlIlIlllIlIlII, lIlIlIlllIlIIll, lIlIlIlllIlllll).endVertex();
        lIlIlIlllIllllI.pos(lIlIlIllllIlIII + lIlIlIlllIlIlll, lIlIlIllllIIlll, 0.0).tex((lIlIlIllllIIllI + lIlIlIlllIlIlll) * 0.00390625f, lIlIlIllllIIlIl * 0.00390625f).color(lIlIlIlllIlIlIl, lIlIlIlllIlIlII, lIlIlIlllIlIIll, lIlIlIlllIlllll).endVertex();
        lIlIlIlllIllllI.pos(lIlIlIllllIlIII, lIlIlIllllIIlll, 0.0).tex(lIlIlIllllIIllI * 0.00390625f, lIlIlIllllIIlIl * 0.00390625f).color(lIlIlIlllIlIlIl, lIlIlIlllIlIlII, lIlIlIlllIlIIll, lIlIlIlllIlllll).endVertex();
        Tessellator.getInstance().draw();
    }
    
    private void setInitialDisplayMode() throws LWJGLException {
        if (this.fullscreen) {
            Display.setFullscreen(true);
            final DisplayMode lIlIllIlIIlIlII = Display.getDisplayMode();
            this.displayWidth = Math.max(1, lIlIllIlIIlIlII.getWidth());
            this.displayHeight = Math.max(1, lIlIllIlIIlIlII.getHeight());
        }
        else {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }
    }
    
    public ItemRenderer getItemRenderer() {
        return this.itemRenderer;
    }
    
    private void registerMetadataSerializers() {
        this.metadataSerializer_.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        this.metadataSerializer_.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
    }
    
    public boolean isReducedDebug() {
        return (this.player != null && this.player.hasReducedDebug()) || this.gameSettings.reducedDebugInfo;
    }
    
    public TextureManager getTextureManager() {
        return this.renderEngine;
    }
    
    public void setRenderViewEntity(final Entity lIlIIllIIlIlllI) {
        this.renderViewEntity = lIlIIllIIlIlllI;
        this.entityRenderer.loadEntityShader(lIlIIllIIlIlllI);
    }
    
    public static boolean isAmbientOcclusionEnabled() {
        return Minecraft.theMinecraft != null && Minecraft.theMinecraft.gameSettings.ambientOcclusion != 0;
    }
    
    public void shutdown() {
        this.running = false;
    }
}
