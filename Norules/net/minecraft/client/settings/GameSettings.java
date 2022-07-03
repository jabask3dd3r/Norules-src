package net.minecraft.client.settings;

import net.minecraft.client.tutorial.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import com.google.common.base.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import java.nio.charset.*;
import java.io.*;
import shadersmod.client.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import net.minecraft.client.resources.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;
import net.minecraft.client.gui.chat.*;
import org.apache.commons.io.*;
import net.minecraft.util.*;
import java.util.*;
import optifine.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import org.apache.commons.lang3.*;
import net.minecraft.client.renderer.texture.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class GameSettings
{
    public /* synthetic */ int ofFogType;
    public /* synthetic */ int ofBetterGrass;
    public /* synthetic */ KeyBinding keyBindJump;
    public /* synthetic */ int field_192571_R;
    private static final /* synthetic */ String[] PARTICLES;
    public /* synthetic */ boolean fboEnable;
    public /* synthetic */ int guiScale;
    public /* synthetic */ EnumHandSide mainHand;
    public /* synthetic */ boolean ofAnimatedTextures;
    public /* synthetic */ boolean ofLazyChunkLoading;
    public /* synthetic */ boolean ofDrippingWaterLava;
    public /* synthetic */ KeyBinding keyBindScreenshot;
    private final /* synthetic */ Set<EnumPlayerModelParts> setModelParts;
    public /* synthetic */ KeyBinding keyBindDrop;
    public /* synthetic */ boolean ofCustomSky;
    public /* synthetic */ KeyBinding keyBindInventory;
    public /* synthetic */ float chatOpacity;
    public /* synthetic */ boolean enableWeakAttacks;
    public /* synthetic */ boolean ofCustomItems;
    public /* synthetic */ KeyBinding keyBindBack;
    public /* synthetic */ boolean useNativeTransport;
    private static final /* synthetic */ int[] OF_TREES_VALUES;
    public /* synthetic */ TutorialSteps field_193631_S;
    public /* synthetic */ int ofClouds;
    public /* synthetic */ boolean forceUnicodeFont;
    public /* synthetic */ boolean heldItemTooltips;
    public /* synthetic */ boolean ofWaterParticles;
    public /* synthetic */ KeyBinding keyBindForward;
    public /* synthetic */ EnumDifficulty difficulty;
    public /* synthetic */ boolean ofRainSplash;
    public /* synthetic */ boolean ofShowCapes;
    public /* synthetic */ boolean realmsNotifications;
    public /* synthetic */ List<String> resourcePacks;
    public /* synthetic */ boolean ofBetterSnow;
    private /* synthetic */ File optionsFileOF;
    public /* synthetic */ String lastServer;
    public /* synthetic */ boolean ofShowFps;
    public /* synthetic */ boolean touchscreen;
    public /* synthetic */ boolean ofClearWater;
    public /* synthetic */ List<String> incompatibleResourcePacks;
    public static final /* synthetic */ String[] field_193632_b;
    private static final /* synthetic */ String[] KEYS_DYNAMIC_LIGHTS;
    public /* synthetic */ boolean ofPortalParticles;
    public /* synthetic */ float chatHeightUnfocused;
    public /* synthetic */ boolean viewBobbing;
    private static final /* synthetic */ String[] AMBIENT_OCCLUSIONS;
    public /* synthetic */ boolean ofOcclusionFancy;
    public /* synthetic */ int renderDistanceChunks;
    public /* synthetic */ KeyBinding keyBindChat;
    private /* synthetic */ boolean needsResourceRefresh;
    public /* synthetic */ float mouseSensitivity;
    private static final /* synthetic */ String[] GUISCALES;
    public /* synthetic */ KeyBinding keyBindSpectatorOutlines;
    public /* synthetic */ boolean ofAnimatedSmoke;
    private static final /* synthetic */ String[] ATTACK_INDICATORS;
    public /* synthetic */ boolean ofLagometer;
    private static final /* synthetic */ Gson GSON;
    public /* synthetic */ boolean fancyGraphics;
    public /* synthetic */ KeyBinding keyBindUseItem;
    public /* synthetic */ int limitFramerate;
    public /* synthetic */ boolean ofProfiler;
    private static final /* synthetic */ String[] CLOUDS_TYPES;
    private static final /* synthetic */ Type TYPE_LIST_STRING;
    public /* synthetic */ boolean entityShadows;
    public /* synthetic */ float gammaSetting;
    public /* synthetic */ int overrideWidth;
    public /* synthetic */ String ofFullscreenMode;
    public /* synthetic */ boolean chatLinksPrompt;
    public /* synthetic */ int ofVignette;
    public /* synthetic */ float ofCloudsHeight;
    public /* synthetic */ boolean ofPotionParticles;
    public /* synthetic */ int ofAutoSaveTicks;
    public /* synthetic */ int ofDynamicLights;
    public /* synthetic */ float saturation;
    public /* synthetic */ boolean ofCustomColors;
    public /* synthetic */ boolean ofCustomEntityModels;
    public /* synthetic */ KeyBinding[] keyBindings;
    public /* synthetic */ boolean ofSky;
    private final /* synthetic */ Map<SoundCategory, Float> soundLevels;
    public /* synthetic */ EntityPlayer.EnumChatVisibility chatVisibility;
    public /* synthetic */ boolean ofCustomFonts;
    public /* synthetic */ int ofAnimatedWater;
    public /* synthetic */ int ofAaLevel;
    public /* synthetic */ KeyBinding keyBindCommand;
    public /* synthetic */ KeyBinding keyBindPlayerList;
    public /* synthetic */ boolean ofAnimatedRedstone;
    public /* synthetic */ KeyBinding keyBindSprint;
    public /* synthetic */ float chatWidth;
    public /* synthetic */ String language;
    public /* synthetic */ float ofAoLevel;
    public /* synthetic */ int ofMipmapType;
    public /* synthetic */ KeyBinding keyBindSwapHands;
    public /* synthetic */ boolean useVbo;
    public /* synthetic */ boolean ofRandomMobs;
    public /* synthetic */ float chatHeightFocused;
    public /* synthetic */ KeyBinding keyBindFullscreen;
    public /* synthetic */ int ofChunkUpdates;
    public /* synthetic */ KeyBinding keyBindSneak;
    public /* synthetic */ boolean hideServerAddress;
    public /* synthetic */ int particleSetting;
    public /* synthetic */ KeyBinding keyBindSmoothCamera;
    public /* synthetic */ boolean chatLinks;
    public /* synthetic */ boolean chatColours;
    public /* synthetic */ int overrideHeight;
    public /* synthetic */ boolean ofChunkUpdatesDynamic;
    public /* synthetic */ int ofConnectedTextures;
    public /* synthetic */ boolean ofSmoothBiomes;
    public static final /* synthetic */ Splitter COLON_SPLITTER;
    public /* synthetic */ boolean ofVoidParticles;
    public /* synthetic */ KeyBinding field_194146_ao;
    public /* synthetic */ KeyBinding keyBindRight;
    public /* synthetic */ boolean ofAnimatedPortal;
    public /* synthetic */ KeyBinding keyBindAttack;
    public /* synthetic */ boolean ofAnimatedFire;
    public /* synthetic */ KeyBinding field_193629_ap;
    public /* synthetic */ boolean autoJump;
    public /* synthetic */ int ofTrees;
    public /* synthetic */ int ofDroppedItems;
    public /* synthetic */ boolean ofWeather;
    public /* synthetic */ int ofTime;
    public /* synthetic */ KeyBinding[] keyBindsHotbar;
    public /* synthetic */ int ofScreenshotSize;
    public /* synthetic */ int ofAnimatedLava;
    public /* synthetic */ boolean invertMouse;
    public /* synthetic */ boolean ofAlternateBlocks;
    public /* synthetic */ KeyBinding field_193630_aq;
    private static final /* synthetic */ int[] OF_DYNAMIC_LIGHTS;
    public /* synthetic */ int ambientOcclusion;
    public /* synthetic */ boolean ofSunMoon;
    private static final /* synthetic */ Logger LOGGER;
    protected /* synthetic */ Minecraft mc;
    public /* synthetic */ int mipmapLevels;
    public /* synthetic */ boolean ofSmoothFps;
    public /* synthetic */ int ofRain;
    public /* synthetic */ boolean advancedItemTooltips;
    public /* synthetic */ int ofAfLevel;
    public /* synthetic */ float chatScale;
    public /* synthetic */ boolean pauseOnLostFocus;
    public /* synthetic */ boolean anaglyph;
    public /* synthetic */ boolean fullScreen;
    public /* synthetic */ float ofFogStart;
    public /* synthetic */ boolean ofFireworkParticles;
    public /* synthetic */ int ofTranslucentBlocks;
    public /* synthetic */ boolean ofAnimatedExplosion;
    public /* synthetic */ boolean ofNaturalTextures;
    public /* synthetic */ int clouds;
    public /* synthetic */ boolean ofDynamicFov;
    public /* synthetic */ boolean ofCustomGuis;
    public /* synthetic */ boolean ofStars;
    public /* synthetic */ float fovSetting;
    public /* synthetic */ boolean ofFastMath;
    public /* synthetic */ KeyBinding keyBindTogglePerspective;
    public /* synthetic */ boolean reducedDebugInfo;
    public /* synthetic */ boolean enableVsync;
    public /* synthetic */ KeyBinding keyBindLeft;
    public /* synthetic */ boolean showSubtitles;
    public /* synthetic */ boolean ofSmoothWorld;
    public /* synthetic */ boolean ofFastRender;
    public /* synthetic */ boolean ofSwampColors;
    public /* synthetic */ KeyBinding ofKeyBindZoom;
    public /* synthetic */ int attackIndicator;
    public /* synthetic */ boolean snooperEnabled;
    public /* synthetic */ boolean ofAnimatedFlame;
    public /* synthetic */ KeyBinding keyBindPickBlock;
    public /* synthetic */ boolean ofAnimatedTerrain;
    private /* synthetic */ File optionsFile;
    
    public float getSoundLevel(final SoundCategory llllllllllllllIIlIllIlllIIlIlllI) {
        return this.soundLevels.containsKey(llllllllllllllIIlIllIlllIIlIlllI) ? this.soundLevels.get(llllllllllllllIIlIllIlllIIlIlllI) : 1.0f;
    }
    
    private void setOptionValueOF(final Options llllllllllllllIIlIllIllIllIlIlll, final int llllllllllllllIIlIllIllIllIllIIl) {
        if (llllllllllllllIIlIllIllIllIlIlll == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    this.ofFogType = 2;
                    if (!Config.isFancyFogAvailable()) {
                        this.ofFogType = 3;
                        break;
                    }
                    break;
                }
                case 2: {
                    this.ofFogType = 3;
                    break;
                }
                case 3: {
                    this.ofFogType = 1;
                    break;
                }
                default: {
                    this.ofFogType = 1;
                    break;
                }
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.FOG_START) {
            this.ofFogStart += 0.2f;
            if (this.ofFogStart > 0.81f) {
                this.ofFogStart = 0.2f;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SMOOTH_FPS) {
            this.ofSmoothFps = !this.ofSmoothFps;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SMOOTH_WORLD) {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CLOUDS) {
            ++this.ofClouds;
            if (this.ofClouds > 3) {
                this.ofClouds = 0;
            }
            this.updateRenderClouds();
            this.mc.renderGlobal.resetClouds();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.TREES) {
            this.ofTrees = nextValue(this.ofTrees, GameSettings.OF_TREES_VALUES);
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.DROPPED_ITEMS) {
            ++this.ofDroppedItems;
            if (this.ofDroppedItems > 2) {
                this.ofDroppedItems = 0;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.RAIN) {
            ++this.ofRain;
            if (this.ofRain > 3) {
                this.ofRain = 0;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_WATER) {
            ++this.ofAnimatedWater;
            if (this.ofAnimatedWater == 1) {
                ++this.ofAnimatedWater;
            }
            if (this.ofAnimatedWater > 2) {
                this.ofAnimatedWater = 0;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_LAVA) {
            ++this.ofAnimatedLava;
            if (this.ofAnimatedLava == 1) {
                ++this.ofAnimatedLava;
            }
            if (this.ofAnimatedLava > 2) {
                this.ofAnimatedLava = 0;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_FIRE) {
            this.ofAnimatedFire = !this.ofAnimatedFire;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_PORTAL) {
            this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_REDSTONE) {
            this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_EXPLOSION) {
            this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_FLAME) {
            this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_SMOKE) {
            this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.VOID_PARTICLES) {
            this.ofVoidParticles = !this.ofVoidParticles;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.WATER_PARTICLES) {
            this.ofWaterParticles = !this.ofWaterParticles;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.PORTAL_PARTICLES) {
            this.ofPortalParticles = !this.ofPortalParticles;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.POTION_PARTICLES) {
            this.ofPotionParticles = !this.ofPotionParticles;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.FIREWORK_PARTICLES) {
            this.ofFireworkParticles = !this.ofFireworkParticles;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.DRIPPING_WATER_LAVA) {
            this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_TERRAIN) {
            this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ANIMATED_TEXTURES) {
            this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.RAIN_SPLASH) {
            this.ofRainSplash = !this.ofRainSplash;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.LAGOMETER) {
            this.ofLagometer = !this.ofLagometer;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SHOW_FPS) {
            this.ofShowFps = !this.ofShowFps;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.AUTOSAVE_TICKS) {
            this.ofAutoSaveTicks *= 10;
            if (this.ofAutoSaveTicks > 40000) {
                this.ofAutoSaveTicks = 40;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.BETTER_GRASS) {
            ++this.ofBetterGrass;
            if (this.ofBetterGrass > 3) {
                this.ofBetterGrass = 1;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CONNECTED_TEXTURES) {
            ++this.ofConnectedTextures;
            if (this.ofConnectedTextures > 3) {
                this.ofConnectedTextures = 1;
            }
            if (this.ofConnectedTextures == 2) {
                this.mc.renderGlobal.loadRenderers();
            }
            else {
                this.mc.refreshResources();
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.WEATHER) {
            this.ofWeather = !this.ofWeather;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SKY) {
            this.ofSky = !this.ofSky;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.STARS) {
            this.ofStars = !this.ofStars;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SUN_MOON) {
            this.ofSunMoon = !this.ofSunMoon;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.VIGNETTE) {
            ++this.ofVignette;
            if (this.ofVignette > 2) {
                this.ofVignette = 0;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CHUNK_UPDATES) {
            ++this.ofChunkUpdates;
            if (this.ofChunkUpdates > 5) {
                this.ofChunkUpdates = 1;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CHUNK_UPDATES_DYNAMIC) {
            this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.TIME) {
            ++this.ofTime;
            if (this.ofTime > 2) {
                this.ofTime = 0;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CLEAR_WATER) {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.PROFILER) {
            this.ofProfiler = !this.ofProfiler;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.BETTER_SNOW) {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SWAMP_COLORS) {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.RANDOM_MOBS) {
            this.ofRandomMobs = !this.ofRandomMobs;
            RandomMobs.resetTextures();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SMOOTH_BIOMES) {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColors.updateUseDefaultGrassFoliageColors();
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CUSTOM_FONTS) {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.mc.fontRendererObj.onResourceManagerReload(Config.getResourceManager());
            this.mc.standardGalacticFontRenderer.onResourceManagerReload(Config.getResourceManager());
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CUSTOM_COLORS) {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColors.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CUSTOM_ITEMS) {
            this.ofCustomItems = !this.ofCustomItems;
            this.mc.refreshResources();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CUSTOM_SKY) {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SHOW_CAPES) {
            this.ofShowCapes = !this.ofShowCapes;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.NATURAL_TEXTURES) {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.FAST_MATH) {
            this.ofFastMath = !this.ofFastMath;
            MathHelper.fastMath = this.ofFastMath;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.FAST_RENDER) {
            if (!this.ofFastRender && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.fr.shaders1"), Lang.get("of.message.fr.shaders2"));
                return;
            }
            this.ofFastRender = !this.ofFastRender;
            if (this.ofFastRender) {
                this.mc.entityRenderer.stopUseShader();
            }
            Config.updateFramebufferSize();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.TRANSLUCENT_BLOCKS) {
            if (this.ofTranslucentBlocks == 0) {
                this.ofTranslucentBlocks = 1;
            }
            else if (this.ofTranslucentBlocks == 1) {
                this.ofTranslucentBlocks = 2;
            }
            else if (this.ofTranslucentBlocks == 2) {
                this.ofTranslucentBlocks = 0;
            }
            else {
                this.ofTranslucentBlocks = 0;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.LAZY_CHUNK_LOADING) {
            this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
            Config.updateAvailableProcessors();
            if (!Config.isSingleProcessor()) {
                this.ofLazyChunkLoading = false;
            }
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.DYNAMIC_FOV) {
            this.ofDynamicFov = !this.ofDynamicFov;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ALTERNATE_BLOCKS) {
            this.ofAlternateBlocks = !this.ofAlternateBlocks;
            this.mc.refreshResources();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.DYNAMIC_LIGHTS) {
            this.ofDynamicLights = nextValue(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
            DynamicLights.removeLights(this.mc.renderGlobal);
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.SCREENSHOT_SIZE) {
            ++this.ofScreenshotSize;
            if (this.ofScreenshotSize > 4) {
                this.ofScreenshotSize = 1;
            }
            if (!OpenGlHelper.isFramebufferEnabled()) {
                this.ofScreenshotSize = 1;
            }
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CUSTOM_ENTITY_MODELS) {
            this.ofCustomEntityModels = !this.ofCustomEntityModels;
            this.mc.refreshResources();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.CUSTOM_GUIS) {
            this.ofCustomGuis = !this.ofCustomGuis;
            CustomGuis.update();
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.HELD_ITEM_TOOLTIPS) {
            this.heldItemTooltips = !this.heldItemTooltips;
        }
        if (llllllllllllllIIlIllIllIllIlIlll == Options.ADVANCED_TOOLTIPS) {
            this.advancedItemTooltips = !this.advancedItemTooltips;
        }
    }
    
    public void saveOfOptions() {
        try {
            final PrintWriter llllllllllllllIIlIllIllIlIlIIlll = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.optionsFileOF), StandardCharsets.UTF_8));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofRenderDistanceChunks:").append(this.renderDistanceChunks)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofFogType:").append(this.ofFogType)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofFogStart:").append(this.ofFogStart)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofMipmapType:").append(this.ofMipmapType)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofOcclusionFancy:").append(this.ofOcclusionFancy)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofSmoothFps:").append(this.ofSmoothFps)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofSmoothWorld:").append(this.ofSmoothWorld)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAoLevel:").append(this.ofAoLevel)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofClouds:").append(this.ofClouds)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCloudsHeight:").append(this.ofCloudsHeight)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofTrees:").append(this.ofTrees)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofDroppedItems:").append(this.ofDroppedItems)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofRain:").append(this.ofRain)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedWater:").append(this.ofAnimatedWater)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedLava:").append(this.ofAnimatedLava)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedFire:").append(this.ofAnimatedFire)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedPortal:").append(this.ofAnimatedPortal)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedRedstone:").append(this.ofAnimatedRedstone)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedExplosion:").append(this.ofAnimatedExplosion)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedFlame:").append(this.ofAnimatedFlame)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedSmoke:").append(this.ofAnimatedSmoke)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofVoidParticles:").append(this.ofVoidParticles)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofWaterParticles:").append(this.ofWaterParticles)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofPortalParticles:").append(this.ofPortalParticles)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofPotionParticles:").append(this.ofPotionParticles)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofFireworkParticles:").append(this.ofFireworkParticles)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofDrippingWaterLava:").append(this.ofDrippingWaterLava)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedTerrain:").append(this.ofAnimatedTerrain)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAnimatedTextures:").append(this.ofAnimatedTextures)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofRainSplash:").append(this.ofRainSplash)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofLagometer:").append(this.ofLagometer)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofShowFps:").append(this.ofShowFps)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAutoSaveTicks:").append(this.ofAutoSaveTicks)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofBetterGrass:").append(this.ofBetterGrass)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofConnectedTextures:").append(this.ofConnectedTextures)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofWeather:").append(this.ofWeather)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofSky:").append(this.ofSky)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofStars:").append(this.ofStars)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofSunMoon:").append(this.ofSunMoon)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofVignette:").append(this.ofVignette)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofChunkUpdates:").append(this.ofChunkUpdates)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofChunkUpdatesDynamic:").append(this.ofChunkUpdatesDynamic)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofTime:").append(this.ofTime)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofClearWater:").append(this.ofClearWater)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAaLevel:").append(this.ofAaLevel)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAfLevel:").append(this.ofAfLevel)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofProfiler:").append(this.ofProfiler)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofBetterSnow:").append(this.ofBetterSnow)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofSwampColors:").append(this.ofSwampColors)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofRandomMobs:").append(this.ofRandomMobs)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofSmoothBiomes:").append(this.ofSmoothBiomes)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCustomFonts:").append(this.ofCustomFonts)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCustomColors:").append(this.ofCustomColors)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCustomItems:").append(this.ofCustomItems)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCustomSky:").append(this.ofCustomSky)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofShowCapes:").append(this.ofShowCapes)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofNaturalTextures:").append(this.ofNaturalTextures)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofLazyChunkLoading:").append(this.ofLazyChunkLoading)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofDynamicFov:").append(this.ofDynamicFov)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofAlternateBlocks:").append(this.ofAlternateBlocks)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofDynamicLights:").append(this.ofDynamicLights)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofScreenshotSize:").append(this.ofScreenshotSize)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCustomEntityModels:").append(this.ofCustomEntityModels)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofCustomGuis:").append(this.ofCustomGuis)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofFullscreenMode:").append(this.ofFullscreenMode)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofFastMath:").append(this.ofFastMath)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofFastRender:").append(this.ofFastRender)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("ofTranslucentBlocks:").append(this.ofTranslucentBlocks)));
            llllllllllllllIIlIllIllIlIlIIlll.println(String.valueOf(new StringBuilder("key_").append(this.ofKeyBindZoom.getKeyDescription()).append(":").append(this.ofKeyBindZoom.getKeyCode())));
            llllllllllllllIIlIllIllIlIlIIlll.close();
        }
        catch (Exception llllllllllllllIIlIllIllIlIlIIllI) {
            Config.warn("Failed to save options");
            llllllllllllllIIlIllIllIlIlIIllI.printStackTrace();
        }
    }
    
    public void switchModelPartEnabled(final EnumPlayerModelParts llllllllllllllIIlIllIlllIIIIlIII) {
        if (this.getModelParts().contains(llllllllllllllIIlIllIlllIIIIlIII)) {
            this.setModelParts.remove(llllllllllllllIIlIllIlllIIIIlIII);
        }
        else {
            this.setModelParts.add(llllllllllllllIIlIllIlllIIIIlIII);
        }
        this.sendSettingsToServer();
    }
    
    public Set<EnumPlayerModelParts> getModelParts() {
        return (Set<EnumPlayerModelParts>)ImmutableSet.copyOf((Collection)this.setModelParts);
    }
    
    public void loadOfOptions() {
        try {
            File llllllllllllllIIlIllIllIlIllIlIl = this.optionsFileOF;
            if (!llllllllllllllIIlIllIllIlIllIlIl.exists()) {
                llllllllllllllIIlIllIllIlIllIlIl = this.optionsFile;
            }
            if (!llllllllllllllIIlIllIllIlIllIlIl.exists()) {
                return;
            }
            final BufferedReader llllllllllllllIIlIllIllIlIllIlII = new BufferedReader(new InputStreamReader(new FileInputStream(llllllllllllllIIlIllIllIlIllIlIl), StandardCharsets.UTF_8));
            String llllllllllllllIIlIllIllIlIllIIll = "";
            while ((llllllllllllllIIlIllIllIlIllIIll = llllllllllllllIIlIllIllIlIllIlII.readLine()) != null) {
                try {
                    final String[] llllllllllllllIIlIllIllIlIllIIlI = llllllllllllllIIlIllIllIlIllIIll.split(":");
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofRenderDistanceChunks") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.renderDistanceChunks = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.renderDistanceChunks = Config.limit(this.renderDistanceChunks, 2, 1024);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofFogType") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofFogType = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofFogType = Config.limit(this.ofFogType, 1, 3);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofFogStart") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofFogStart = Float.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        if (this.ofFogStart < 0.2f) {
                            this.ofFogStart = 0.2f;
                        }
                        if (this.ofFogStart > 0.81f) {
                            this.ofFogStart = 0.8f;
                        }
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofMipmapType") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofMipmapType = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofMipmapType = Config.limit(this.ofMipmapType, 0, 3);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofOcclusionFancy") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofOcclusionFancy = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofSmoothFps") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofSmoothFps = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofSmoothWorld") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofSmoothWorld = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAoLevel") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAoLevel = Float.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0f, 1.0f);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofClouds") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofClouds = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                        this.updateRenderClouds();
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCloudsHeight") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCloudsHeight = Float.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0f, 1.0f);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofTrees") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofTrees = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofTrees = limit(this.ofTrees, GameSettings.OF_TREES_VALUES);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofDroppedItems") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofDroppedItems = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, 2);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofRain") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofRain = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofRain = Config.limit(this.ofRain, 0, 3);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedWater") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedWater = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedLava") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedLava = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedFire") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedFire = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedPortal") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedPortal = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedRedstone") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedRedstone = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedExplosion") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedExplosion = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedFlame") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedFlame = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedSmoke") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedSmoke = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofVoidParticles") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofVoidParticles = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofWaterParticles") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofWaterParticles = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofPortalParticles") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofPortalParticles = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofPotionParticles") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofPotionParticles = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofFireworkParticles") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofFireworkParticles = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofDrippingWaterLava") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofDrippingWaterLava = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedTerrain") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedTerrain = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAnimatedTextures") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAnimatedTextures = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofRainSplash") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofRainSplash = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofLagometer") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofLagometer = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofShowFps") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofShowFps = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAutoSaveTicks") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAutoSaveTicks = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofBetterGrass") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofBetterGrass = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, 3);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofConnectedTextures") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofConnectedTextures = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofWeather") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofWeather = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofSky") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofSky = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofStars") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofStars = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofSunMoon") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofSunMoon = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofVignette") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofVignette = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofVignette = Config.limit(this.ofVignette, 0, 2);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofChunkUpdates") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofChunkUpdates = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofChunkUpdatesDynamic") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofTime") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofTime = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofTime = Config.limit(this.ofTime, 0, 2);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofClearWater") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofClearWater = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.updateWaterOpacity();
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAaLevel") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAaLevel = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAfLevel") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAfLevel = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofProfiler") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofProfiler = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofBetterSnow") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofBetterSnow = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofSwampColors") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofSwampColors = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofRandomMobs") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofRandomMobs = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofSmoothBiomes") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofSmoothBiomes = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCustomFonts") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCustomFonts = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCustomColors") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCustomColors = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCustomItems") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCustomItems = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCustomSky") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCustomSky = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofShowCapes") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofShowCapes = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofNaturalTextures") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofNaturalTextures = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofLazyChunkLoading") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofLazyChunkLoading = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofDynamicFov") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofDynamicFov = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofAlternateBlocks") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofAlternateBlocks = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofDynamicLights") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofDynamicLights = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofDynamicLights = limit(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofScreenshotSize") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofScreenshotSize = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofScreenshotSize = Config.limit(this.ofScreenshotSize, 1, 4);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCustomEntityModels") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCustomEntityModels = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofCustomGuis") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofCustomGuis = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofFullscreenMode") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofFullscreenMode = llllllllllllllIIlIllIllIlIllIIlI[1];
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofFastMath") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofFastMath = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        MathHelper.fastMath = this.ofFastMath;
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofFastRender") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofFastRender = Boolean.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                    }
                    if (llllllllllllllIIlIllIllIlIllIIlI[0].equals("ofTranslucentBlocks") && llllllllllllllIIlIllIllIlIllIIlI.length >= 2) {
                        this.ofTranslucentBlocks = Integer.valueOf(llllllllllllllIIlIllIllIlIllIIlI[1]);
                        this.ofTranslucentBlocks = Config.limit(this.ofTranslucentBlocks, 0, 2);
                    }
                    if (!llllllllllllllIIlIllIllIlIllIIlI[0].equals(String.valueOf(new StringBuilder("key_").append(this.ofKeyBindZoom.getKeyDescription())))) {
                        continue;
                    }
                    this.ofKeyBindZoom.setKeyCode(Integer.parseInt(llllllllllllllIIlIllIllIlIllIIlI[1]));
                }
                catch (Exception llllllllllllllIIlIllIllIlIllIIIl) {
                    Config.dbg(String.valueOf(new StringBuilder("Skipping bad option: ").append(llllllllllllllIIlIllIllIlIllIIll)));
                    llllllllllllllIIlIllIllIlIllIIIl.printStackTrace();
                }
            }
            KeyBinding.resetKeyBindingArrayAndHash();
            llllllllllllllIIlIllIllIlIllIlII.close();
        }
        catch (Exception llllllllllllllIIlIllIllIlIllIIII) {
            Config.warn("Failed to load options");
            llllllllllllllIIlIllIllIlIllIIII.printStackTrace();
        }
    }
    
    public void resetSettings() {
        this.renderDistanceChunks = 8;
        this.viewBobbing = true;
        this.anaglyph = false;
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.enableVsync = false;
        this.updateVSync();
        this.mipmapLevels = 4;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.clouds = 2;
        this.fovSetting = 70.0f;
        this.gammaSetting = 0.0f;
        this.guiScale = 0;
        this.particleSetting = 0;
        this.heldItemTooltips = true;
        this.useVbo = false;
        this.forceUnicodeFont = false;
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        Config.updateAvailableProcessors();
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofScreenshotSize = 1;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofShowFps = false;
        this.ofProfiler = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomItems = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofNaturalTextures = false;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        Shaders.setShaderPack(Shaders.packNameNone);
        Shaders.configAntialiasingLevel = 0;
        Shaders.uninit();
        Shaders.storeConfig();
        this.updateWaterOpacity();
        this.mc.refreshResources();
        this.saveOptions();
    }
    
    static {
        ANIM_ON = 0;
        OFF = 3;
        DEFAULT_STR = "Default";
        DEFAULT = 0;
        FANCY = 2;
        FAST = 1;
        SMART = 4;
        ANIM_GENERATED = 1;
        ANIM_OFF = 2;
        LOGGER = LogManager.getLogger();
        GSON = new Gson();
        TYPE_LIST_STRING = new ParameterizedType() {
            @Override
            public Type getRawType() {
                return List.class;
            }
            
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class };
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        COLON_SPLITTER = Splitter.on(':');
        GUISCALES = new String[] { "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large" };
        PARTICLES = new String[] { "options.particles.all", "options.particles.decreased", "options.particles.minimal" };
        AMBIENT_OCCLUSIONS = new String[] { "options.ao.off", "options.ao.min", "options.ao.max" };
        CLOUDS_TYPES = new String[] { "options.off", "options.clouds.fast", "options.clouds.fancy" };
        ATTACK_INDICATORS = new String[] { "options.off", "options.attack.crosshair", "options.attack.hotbar" };
        field_193632_b = new String[] { "options.narrator.off", "options.narrator.all", "options.narrator.chat", "options.narrator.system" };
        OF_TREES_VALUES = new int[] { 0, 1, 4, 2 };
        OF_DYNAMIC_LIGHTS = new int[] { 3, 1, 2 };
        KEYS_DYNAMIC_LIGHTS = new String[] { "options.off", "options.graphics.fast", "options.graphics.fancy" };
    }
    
    private static int limit(final int llllllllllllllIIlIllIllIIlllllll, final int[] llllllllllllllIIlIllIllIIllllllI) {
        final int llllllllllllllIIlIllIllIlIIIIIII = indexOf(llllllllllllllIIlIllIllIIlllllll, llllllllllllllIIlIllIllIIllllllI);
        return (llllllllllllllIIlIllIllIlIIIIIII < 0) ? llllllllllllllIIlIllIllIIllllllI[0] : llllllllllllllIIlIllIllIIlllllll;
    }
    
    private static String getTranslation(final String[] llllllllllllllIIlIllIllllIIlllII, int llllllllllllllIIlIllIllllIIllIll) {
        if (llllllllllllllIIlIllIllllIIllIll < 0 || llllllllllllllIIlIllIllllIIllIll >= llllllllllllllIIlIllIllllIIlllII.length) {
            llllllllllllllIIlIllIllllIIllIll = 0;
        }
        return I18n.format(llllllllllllllIIlIllIllllIIlllII[llllllllllllllIIlIllIllllIIllIll], new Object[0]);
    }
    
    public void updateVSync() {
        Display.setVSyncEnabled(this.enableVsync);
    }
    
    private NBTTagCompound dataFix(final NBTTagCompound llllllllllllllIIlIllIlllIlIlIllI) {
        int llllllllllllllIIlIllIlllIlIllIII = 0;
        try {
            llllllllllllllIIlIllIlllIlIllIII = Integer.parseInt(llllllllllllllIIlIllIlllIlIlIllI.getString("version"));
        }
        catch (RuntimeException ex) {}
        return this.mc.getDataFixer().process(FixTypes.OPTIONS, llllllllllllllIIlIllIlllIlIlIllI, llllllllllllllIIlIllIlllIlIllIII);
    }
    
    public String getKeyBinding(final Options llllllllllllllIIlIllIllllIIlIIll) {
        final String llllllllllllllIIlIllIllllIIlIIlI = this.getKeyBindingOF(llllllllllllllIIlIllIllllIIlIIll);
        if (llllllllllllllIIlIllIllllIIlIIlI != null) {
            return llllllllllllllIIlIllIllllIIlIIlI;
        }
        final String llllllllllllllIIlIllIllllIIlIIIl = String.valueOf(new StringBuilder(String.valueOf(I18n.format(llllllllllllllIIlIllIllllIIlIIll.getEnumString(), new Object[0]))).append(": "));
        if (llllllllllllllIIlIllIllllIIlIIll.getEnumFloat()) {
            final float llllllllllllllIIlIllIllllIIlIIII = this.getOptionFloatValue(llllllllllllllIIlIllIllllIIlIIll);
            final float llllllllllllllIIlIllIllllIIIllll = llllllllllllllIIlIllIllllIIlIIll.normalizeValue(llllllllllllllIIlIllIllllIIlIIII);
            if (llllllllllllllIIlIllIllllIIlIIll == Options.SENSITIVITY) {
                if (llllllllllllllIIlIllIllllIIIllll == 0.0f) {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.sensitivity.min", new Object[0])));
                }
                return (llllllllllllllIIlIllIllllIIIllll == 1.0f) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.sensitivity.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)(llllllllllllllIIlIllIllllIIIllll * 200.0f)).append("%"));
            }
            else if (llllllllllllllIIlIllIllllIIlIIll == Options.FOV) {
                if (llllllllllllllIIlIllIllllIIlIIII == 70.0f) {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.fov.min", new Object[0])));
                }
                return (llllllllllllllIIlIllIllllIIlIIII == 110.0f) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.fov.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)llllllllllllllIIlIllIllllIIlIIII));
            }
            else {
                if (llllllllllllllIIlIllIllllIIlIIll == Options.FRAMERATE_LIMIT) {
                    return (llllllllllllllIIlIllIllllIIlIIII == llllllllllllllIIlIllIllllIIlIIll.valueMax) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.framerateLimit.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.framerate", (int)llllllllllllllIIlIllIllllIIlIIII)));
                }
                if (llllllllllllllIIlIllIllllIIlIIll == Options.RENDER_CLOUDS) {
                    return (llllllllllllllIIlIllIllllIIlIIII == llllllllllllllIIlIllIllllIIlIIll.valueMin) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.cloudHeight.min", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)llllllllllllllIIlIllIllllIIlIIII + 128));
                }
                if (llllllllllllllIIlIllIllllIIlIIll == Options.GAMMA) {
                    if (llllllllllllllIIlIllIllllIIIllll == 0.0f) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.gamma.min", new Object[0])));
                    }
                    return (llllllllllllllIIlIllIllllIIIllll == 1.0f) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.gamma.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append("+").append((int)(llllllllllllllIIlIllIllllIIIllll * 100.0f)).append("%"));
                }
                else {
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.SATURATION) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)(llllllllllllllIIlIllIllllIIIllll * 400.0f)).append("%"));
                    }
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.CHAT_OPACITY) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)(llllllllllllllIIlIllIllllIIIllll * 90.0f + 10.0f)).append("%"));
                    }
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.CHAT_HEIGHT_UNFOCUSED) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(GuiNewChat.calculateChatboxHeight(llllllllllllllIIlIllIllllIIIllll)).append("px"));
                    }
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.CHAT_HEIGHT_FOCUSED) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(GuiNewChat.calculateChatboxHeight(llllllllllllllIIlIllIllllIIIllll)).append("px"));
                    }
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.CHAT_WIDTH) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(GuiNewChat.calculateChatboxWidth(llllllllllllllIIlIllIllllIIIllll)).append("px"));
                    }
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.RENDER_DISTANCE) {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.chunks", (int)llllllllllllllIIlIllIllllIIlIIII)));
                    }
                    if (llllllllllllllIIlIllIllllIIlIIll == Options.MIPMAP_LEVELS) {
                        return (llllllllllllllIIlIllIllllIIlIIII == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.off", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)llllllllllllllIIlIllIllllIIlIIII));
                    }
                    return (llllllllllllllIIlIllIllllIIIllll == 0.0f) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.off", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append((int)(llllllllllllllIIlIllIllllIIIllll * 100.0f)).append("%"));
                }
            }
        }
        else {
            if (llllllllllllllIIlIllIllllIIlIIll.getEnumBoolean()) {
                final boolean llllllllllllllIIlIllIllllIIIlllI = this.getOptionOrdinalValue(llllllllllllllIIlIllIllllIIlIIll);
                return llllllllllllllIIlIllIllllIIIlllI ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.on", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.off", new Object[0])));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.MAIN_HAND) {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(this.mainHand));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.GUI_SCALE) {
                return (this.guiScale >= GameSettings.GUISCALES.length) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(this.guiScale).append("x")) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(getTranslation(GameSettings.GUISCALES, this.guiScale)));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.CHAT_VISIBILITY) {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format(this.chatVisibility.getResourceKey(), new Object[0])));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.PARTICLES) {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(getTranslation(GameSettings.PARTICLES, this.particleSetting)));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.AMBIENT_OCCLUSION) {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(getTranslation(GameSettings.AMBIENT_OCCLUSIONS, this.ambientOcclusion)));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.RENDER_CLOUDS) {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(getTranslation(GameSettings.CLOUDS_TYPES, this.clouds)));
            }
            if (llllllllllllllIIlIllIllllIIlIIll == Options.GRAPHICS) {
                if (this.fancyGraphics) {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.graphics.fancy", new Object[0])));
                }
                final String llllllllllllllIIlIllIllllIIIllIl = "options.graphics.fast";
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.graphics.fast", new Object[0])));
            }
            else {
                if (llllllllllllllIIlIllIllllIIlIIll == Options.ATTACK_INDICATOR) {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(getTranslation(GameSettings.ATTACK_INDICATORS, this.attackIndicator)));
                }
                if (llllllllllllllIIlIllIllllIIlIIll == Options.NARRATOR) {
                    return NarratorChatListener.field_193643_a.func_193640_a() ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(getTranslation(GameSettings.field_193632_b, this.field_192571_R))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllllIIlIIIl)).append(I18n.format("options.narrator.notavailable", new Object[0])));
                }
                return llllllllllllllIIlIllIllllIIlIIIl;
            }
        }
    }
    
    public static String getKeyDisplayString(final int llllllllllllllIIlIllIllllllIIIII) {
        if (llllllllllllllIIlIllIllllllIIIII >= 0) {
            return (llllllllllllllIIlIllIllllllIIIII < 256) ? Keyboard.getKeyName(llllllllllllllIIlIllIllllllIIIII) : String.format("%c", (char)(llllllllllllllIIlIllIllllllIIIII - 256)).toUpperCase();
        }
        switch (llllllllllllllIIlIllIllllllIIIII) {
            case -100: {
                return I18n.format("key.mouse.left", new Object[0]);
            }
            case -99: {
                return I18n.format("key.mouse.right", new Object[0]);
            }
            case -98: {
                return I18n.format("key.mouse.middle", new Object[0]);
            }
            default: {
                return I18n.format("key.mouseButton", llllllllllllllIIlIllIllllllIIIII + 101);
            }
        }
    }
    
    private float getOptionFloatValueOF(final Options llllllllllllllIIlIllIllIlllIIIII) {
        if (llllllllllllllIIlIllIllIlllIIIII == Options.CLOUD_HEIGHT) {
            return this.ofCloudsHeight;
        }
        if (llllllllllllllIIlIllIllIlllIIIII == Options.AO_LEVEL) {
            return this.ofAoLevel;
        }
        if (llllllllllllllIIlIllIllIlllIIIII == Options.AA_LEVEL) {
            return (float)this.ofAaLevel;
        }
        if (llllllllllllllIIlIllIllIlllIIIII == Options.AF_LEVEL) {
            return (float)this.ofAfLevel;
        }
        if (llllllllllllllIIlIllIllIlllIIIII == Options.MIPMAP_TYPE) {
            return (float)this.ofMipmapType;
        }
        if (llllllllllllllIIlIllIllIlllIIIII == Options.FRAMERATE_LIMIT) {
            return (this.limitFramerate == Options.FRAMERATE_LIMIT.getValueMax() && this.enableVsync) ? 0.0f : ((float)this.limitFramerate);
        }
        if (llllllllllllllIIlIllIllIlllIIIII != Options.FULLSCREEN_MODE) {
            return Float.MAX_VALUE;
        }
        if (this.ofFullscreenMode.equals("Default")) {
            return 0.0f;
        }
        final List llllllllllllllIIlIllIllIlllIIIll = Arrays.asList(Config.getDisplayModeNames());
        final int llllllllllllllIIlIllIllIlllIIIlI = llllllllllllllIIlIllIllIlllIIIll.indexOf(this.ofFullscreenMode);
        return (llllllllllllllIIlIllIllIlllIIIlI < 0) ? 0.0f : ((float)(llllllllllllllIIlIllIllIlllIIIlI + 1));
    }
    
    public void loadOptions() {
        try {
            if (!this.optionsFile.exists()) {
                return;
            }
            this.soundLevels.clear();
            final List<String> llllllllllllllIIlIllIlllIllllIIl = (List<String>)IOUtils.readLines((InputStream)new FileInputStream(this.optionsFile), StandardCharsets.UTF_8);
            NBTTagCompound llllllllllllllIIlIllIlllIllllIII = new NBTTagCompound();
            for (final String llllllllllllllIIlIllIlllIlllIlll : llllllllllllllIIlIllIlllIllllIIl) {
                try {
                    final Iterator<String> llllllllllllllIIlIllIlllIlllIllI = GameSettings.COLON_SPLITTER.omitEmptyStrings().limit(2).split((CharSequence)llllllllllllllIIlIllIlllIlllIlll).iterator();
                    llllllllllllllIIlIllIlllIllllIII.setString(llllllllllllllIIlIllIlllIlllIllI.next(), llllllllllllllIIlIllIlllIlllIllI.next());
                }
                catch (Exception llllllllllllllIIlIllIlllIlllIlIl) {
                    GameSettings.LOGGER.warn("Skipping bad option: {}", (Object)llllllllllllllIIlIllIlllIlllIlll);
                }
            }
            llllllllllllllIIlIllIlllIllllIII = this.dataFix(llllllllllllllIIlIllIlllIllllIII);
            for (final String llllllllllllllIIlIllIlllIlllIlII : llllllllllllllIIlIllIlllIllllIII.getKeySet()) {
                final String llllllllllllllIIlIllIlllIlllIIll = llllllllllllllIIlIllIlllIllllIII.getString(llllllllllllllIIlIllIlllIlllIlII);
                try {
                    if ("mouseSensitivity".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.mouseSensitivity = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("fov".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.fovSetting = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll) * 40.0f + 70.0f;
                    }
                    if ("gamma".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.gammaSetting = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("saturation".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.saturation = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("invertYMouse".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.invertMouse = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("renderDistance".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.renderDistanceChunks = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("guiScale".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.guiScale = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("particles".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.particleSetting = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("bobView".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.viewBobbing = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("anaglyph3d".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.anaglyph = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("maxFps".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.limitFramerate = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                        if (this.enableVsync) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                        }
                        if (this.limitFramerate <= 0) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                        }
                    }
                    if ("fboEnable".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.fboEnable = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("difficulty".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.difficulty = EnumDifficulty.getDifficultyEnum(Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll));
                    }
                    if ("fancyGraphics".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.fancyGraphics = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                        this.updateRenderClouds();
                    }
                    if ("tutorialStep".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.field_193631_S = TutorialSteps.func_193307_a(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("ao".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        if ("true".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.ambientOcclusion = 2;
                        }
                        else if ("false".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.ambientOcclusion = 0;
                        }
                        else {
                            this.ambientOcclusion = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                        }
                    }
                    if ("renderClouds".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        if ("true".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.clouds = 2;
                        }
                        else if ("false".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.clouds = 0;
                        }
                        else if ("fast".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.clouds = 1;
                        }
                    }
                    if ("attackIndicator".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        if ("0".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.attackIndicator = 0;
                        }
                        else if ("1".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.attackIndicator = 1;
                        }
                        else if ("2".equals(llllllllllllllIIlIllIlllIlllIIll)) {
                            this.attackIndicator = 2;
                        }
                    }
                    if ("resourcePacks".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.resourcePacks = JsonUtils.func_193840_a(GameSettings.GSON, llllllllllllllIIlIllIlllIlllIIll, GameSettings.TYPE_LIST_STRING);
                        if (this.resourcePacks == null) {
                            this.resourcePacks = (List<String>)Lists.newArrayList();
                        }
                    }
                    if ("incompatibleResourcePacks".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.incompatibleResourcePacks = JsonUtils.func_193840_a(GameSettings.GSON, llllllllllllllIIlIllIlllIlllIIll, GameSettings.TYPE_LIST_STRING);
                        if (this.incompatibleResourcePacks == null) {
                            this.incompatibleResourcePacks = (List<String>)Lists.newArrayList();
                        }
                    }
                    if ("lastServer".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.lastServer = llllllllllllllIIlIllIlllIlllIIll;
                    }
                    if ("lang".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.language = llllllllllllllIIlIllIlllIlllIIll;
                    }
                    if ("chatVisibility".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll));
                    }
                    if ("chatColors".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatColours = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatLinks".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatLinks = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatLinksPrompt".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatLinksPrompt = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatOpacity".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatOpacity = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("snooperEnabled".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.snooperEnabled = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("fullscreen".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.fullScreen = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("enableVsync".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.enableVsync = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                        if (this.enableVsync) {
                            this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                        }
                        this.updateVSync();
                    }
                    if ("useVbo".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.useVbo = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("hideServerAddress".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.hideServerAddress = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("advancedItemTooltips".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.advancedItemTooltips = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("pauseOnLostFocus".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.pauseOnLostFocus = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("touchscreen".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.touchscreen = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("overrideHeight".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.overrideHeight = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("overrideWidth".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.overrideWidth = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("heldItemTooltips".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.heldItemTooltips = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatHeightFocused".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatHeightFocused = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatHeightUnfocused".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatHeightUnfocused = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatScale".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatScale = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("chatWidth".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.chatWidth = this.parseFloat(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("mipmapLevels".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.mipmapLevels = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("forceUnicodeFont".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.forceUnicodeFont = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("reducedDebugInfo".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.reducedDebugInfo = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("useNativeTransport".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.useNativeTransport = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("entityShadows".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.entityShadows = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("mainHand".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.mainHand = ("left".equals(llllllllllllllIIlIllIlllIlllIIll) ? EnumHandSide.LEFT : EnumHandSide.RIGHT);
                    }
                    if ("showSubtitles".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.showSubtitles = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("realmsNotifications".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.realmsNotifications = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("enableWeakAttacks".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.enableWeakAttacks = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("autoJump".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.autoJump = "true".equals(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    if ("narrator".equals(llllllllllllllIIlIllIlllIlllIlII)) {
                        this.field_192571_R = Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll);
                    }
                    char llllllllllllllIIlIllIlllIllIIIIl;
                    float llllllllllllllIIlIllIlllIllIIIlI = ((KeyBinding[])(Object)(llllllllllllllIIlIllIlllIllIIIIl = (char)(Object)this.keyBindings)).length;
                    for (double llllllllllllllIIlIllIlllIllIIIll = 0; llllllllllllllIIlIllIlllIllIIIll < llllllllllllllIIlIllIlllIllIIIlI; ++llllllllllllllIIlIllIlllIllIIIll) {
                        final KeyBinding llllllllllllllIIlIllIlllIlllIIlI = llllllllllllllIIlIllIlllIllIIIIl[llllllllllllllIIlIllIlllIllIIIll];
                        if (llllllllllllllIIlIllIlllIlllIlII.equals(String.valueOf(new StringBuilder("key_").append(llllllllllllllIIlIllIlllIlllIIlI.getKeyDescription())))) {
                            if (Reflector.KeyModifier_valueFromString.exists()) {
                                if (llllllllllllllIIlIllIlllIlllIIll.indexOf(58) != -1) {
                                    final String[] llllllllllllllIIlIllIlllIlllIIIl = llllllllllllllIIlIllIlllIlllIIll.split(":");
                                    final Object llllllllllllllIIlIllIlllIlllIIII = Reflector.call(Reflector.KeyModifier_valueFromString, llllllllllllllIIlIllIlllIlllIIIl[1]);
                                    Reflector.call(llllllllllllllIIlIllIlllIlllIIlI, Reflector.ForgeKeyBinding_setKeyModifierAndCode, llllllllllllllIIlIllIlllIlllIIII, Integer.parseInt(llllllllllllllIIlIllIlllIlllIIIl[0]));
                                }
                                else {
                                    final Object llllllllllllllIIlIllIlllIllIllll = Reflector.getFieldValue(Reflector.KeyModifier_NONE);
                                    Reflector.call(llllllllllllllIIlIllIlllIlllIIlI, Reflector.ForgeKeyBinding_setKeyModifierAndCode, llllllllllllllIIlIllIlllIllIllll, Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll));
                                }
                            }
                            else {
                                llllllllllllllIIlIllIlllIlllIIlI.setKeyCode(Integer.parseInt(llllllllllllllIIlIllIlllIlllIIll));
                            }
                        }
                    }
                    llllllllllllllIIlIllIlllIllIIIlI = ((SoundCategory[])(Object)(llllllllllllllIIlIllIlllIllIIIIl = (char)(Object)SoundCategory.values())).length;
                    for (double llllllllllllllIIlIllIlllIllIIIll = 0; llllllllllllllIIlIllIlllIllIIIll < llllllllllllllIIlIllIlllIllIIIlI; ++llllllllllllllIIlIllIlllIllIIIll) {
                        final SoundCategory llllllllllllllIIlIllIlllIllIlllI = llllllllllllllIIlIllIlllIllIIIIl[llllllllllllllIIlIllIlllIllIIIll];
                        if (llllllllllllllIIlIllIlllIlllIlII.equals(String.valueOf(new StringBuilder("soundCategory_").append(llllllllllllllIIlIllIlllIllIlllI.getName())))) {
                            this.soundLevels.put(llllllllllllllIIlIllIlllIllIlllI, this.parseFloat(llllllllllllllIIlIllIlllIlllIIll));
                        }
                    }
                    llllllllllllllIIlIllIlllIllIIIlI = ((EnumPlayerModelParts[])(Object)(llllllllllllllIIlIllIlllIllIIIIl = (char)(Object)EnumPlayerModelParts.values())).length;
                    for (double llllllllllllllIIlIllIlllIllIIIll = 0; llllllllllllllIIlIllIlllIllIIIll < llllllllllllllIIlIllIlllIllIIIlI; ++llllllllllllllIIlIllIlllIllIIIll) {
                        final EnumPlayerModelParts llllllllllllllIIlIllIlllIllIllIl = llllllllllllllIIlIllIlllIllIIIIl[llllllllllllllIIlIllIlllIllIIIll];
                        if (llllllllllllllIIlIllIlllIlllIlII.equals(String.valueOf(new StringBuilder("modelPart_").append(llllllllllllllIIlIllIlllIllIllIl.getPartName())))) {
                            this.setModelPartEnabled(llllllllllllllIIlIllIlllIllIllIl, "true".equals(llllllllllllllIIlIllIlllIlllIIll));
                        }
                    }
                }
                catch (Exception llllllllllllllIIlIllIlllIllIllII) {
                    GameSettings.LOGGER.warn("Skipping bad option: {}:{}", (Object)llllllllllllllIIlIllIlllIlllIlII, (Object)llllllllllllllIIlIllIlllIlllIIll);
                    llllllllllllllIIlIllIlllIllIllII.printStackTrace();
                }
            }
            KeyBinding.resetKeyBindingArrayAndHash();
        }
        catch (Exception llllllllllllllIIlIllIlllIllIlIll) {
            GameSettings.LOGGER.error("Failed to load options", (Throwable)llllllllllllllIIlIllIlllIllIlIll);
        }
        this.loadOfOptions();
    }
    
    public int shouldRenderClouds() {
        return (this.renderDistanceChunks >= 4) ? this.clouds : 0;
    }
    
    private void setOptionFloatValueOF(final Options llllllllllllllIIlIllIllIlllIlllI, final float llllllllllllllIIlIllIllIllllIlll) {
        if (llllllllllllllIIlIllIllIlllIlllI == Options.CLOUD_HEIGHT) {
            this.ofCloudsHeight = llllllllllllllIIlIllIllIllllIlll;
            this.mc.renderGlobal.resetClouds();
        }
        if (llllllllllllllIIlIllIllIlllIlllI == Options.AO_LEVEL) {
            this.ofAoLevel = llllllllllllllIIlIllIllIllllIlll;
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllIlllIlllI == Options.AA_LEVEL) {
            final int llllllllllllllIIlIllIllIllllIllI = (int)llllllllllllllIIlIllIllIllllIlll;
            if (llllllllllllllIIlIllIllIllllIllI > 0 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.aa.shaders1"), Lang.get("of.message.aa.shaders2"));
                return;
            }
            final int[] llllllllllllllIIlIllIllIllllIlIl = { 0, 2, 4, 6, 8, 12, 16 };
            this.ofAaLevel = 0;
            for (int llllllllllllllIIlIllIllIllllIlII = 0; llllllllllllllIIlIllIllIllllIlII < llllllllllllllIIlIllIllIllllIlIl.length; ++llllllllllllllIIlIllIllIllllIlII) {
                if (llllllllllllllIIlIllIllIllllIllI >= llllllllllllllIIlIllIllIllllIlIl[llllllllllllllIIlIllIllIllllIlII]) {
                    this.ofAaLevel = llllllllllllllIIlIllIllIllllIlIl[llllllllllllllIIlIllIllIllllIlII];
                }
            }
            this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
        }
        if (llllllllllllllIIlIllIllIlllIlllI == Options.AF_LEVEL) {
            final int llllllllllllllIIlIllIllIllllIIll = (int)llllllllllllllIIlIllIllIllllIlll;
            if (llllllllllllllIIlIllIllIllllIIll > 1 && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.af.shaders1"), Lang.get("of.message.af.shaders2"));
                return;
            }
            this.ofAfLevel = 1;
            while (this.ofAfLevel * 2 <= llllllllllllllIIlIllIllIllllIIll) {
                this.ofAfLevel *= 2;
            }
            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
            this.mc.refreshResources();
        }
        if (llllllllllllllIIlIllIllIlllIlllI == Options.MIPMAP_TYPE) {
            final int llllllllllllllIIlIllIllIllllIIlI = (int)llllllllllllllIIlIllIllIllllIlll;
            this.ofMipmapType = Config.limit(llllllllllllllIIlIllIllIllllIIlI, 0, 3);
            this.mc.refreshResources();
        }
        if (llllllllllllllIIlIllIllIlllIlllI == Options.FULLSCREEN_MODE) {
            final int llllllllllllllIIlIllIllIllllIIIl = (int)llllllllllllllIIlIllIllIllllIlll - 1;
            final String[] llllllllllllllIIlIllIllIllllIIII = Config.getDisplayModeNames();
            if (llllllllllllllIIlIllIllIllllIIIl < 0 || llllllllllllllIIlIllIllIllllIIIl >= llllllllllllllIIlIllIllIllllIIII.length) {
                this.ofFullscreenMode = "Default";
                return;
            }
            this.ofFullscreenMode = llllllllllllllIIlIllIllIllllIIII[llllllllllllllIIlIllIllIllllIIIl];
        }
    }
    
    public boolean isUsingNativeTransport() {
        return this.useNativeTransport;
    }
    
    public void onGuiClosed() {
        if (this.needsResourceRefresh) {
            this.mc.scheduleResourcesRefresh();
            this.needsResourceRefresh = false;
        }
    }
    
    private void updateWaterOpacity() {
        if (this.mc.isIntegratedServerRunning() && this.mc.getIntegratedServer() != null) {
            Config.waterOpacityChanged = true;
        }
        ClearWater.updateWaterOpacity(this, this.mc.world);
    }
    
    private static int indexOf(final int llllllllllllllIIlIllIllIIllllIIl, final int[] llllllllllllllIIlIllIllIIllllIII) {
        for (int llllllllllllllIIlIllIllIIlllIlll = 0; llllllllllllllIIlIllIllIIlllIlll < llllllllllllllIIlIllIllIIllllIII.length; ++llllllllllllllIIlIllIllIIlllIlll) {
            if (llllllllllllllIIlIllIllIIllllIII[llllllllllllllIIlIllIllIIlllIlll] == llllllllllllllIIlIllIllIIllllIIl) {
                return llllllllllllllIIlIllIllIIlllIlll;
            }
        }
        return -1;
    }
    
    public void setAllAnimations(final boolean llllllllllllllIIlIllIllIlIIlIIII) {
        final int llllllllllllllIIlIllIllIlIIlIIlI = llllllllllllllIIlIllIllIlIIlIIII ? 0 : 2;
        this.ofAnimatedWater = llllllllllllllIIlIllIllIlIIlIIlI;
        this.ofAnimatedLava = llllllllllllllIIlIllIllIlIIlIIlI;
        this.ofAnimatedFire = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedPortal = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedRedstone = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedExplosion = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedFlame = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedSmoke = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofVoidParticles = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofWaterParticles = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofRainSplash = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofPortalParticles = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofPotionParticles = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofFireworkParticles = llllllllllllllIIlIllIllIlIIlIIII;
        this.particleSetting = (llllllllllllllIIlIllIllIlIIlIIII ? 0 : 2);
        this.ofDrippingWaterLava = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedTerrain = llllllllllllllIIlIllIllIlIIlIIII;
        this.ofAnimatedTextures = llllllllllllllIIlIllIllIlIIlIIII;
    }
    
    private void setForgeKeybindProperties() {
        if (Reflector.KeyConflictContext_IN_GAME.exists() && Reflector.ForgeKeyBinding_setKeyConflictContext.exists()) {
            final Object llllllllllllllIIlIllIllIIlllIIII = Reflector.getFieldValue(Reflector.KeyConflictContext_IN_GAME);
            Reflector.call(this.keyBindForward, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindLeft, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindBack, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindRight, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindJump, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindSneak, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindSprint, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindAttack, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindChat, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindPlayerList, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindCommand, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindTogglePerspective, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindSmoothCamera, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
            Reflector.call(this.keyBindSwapHands, Reflector.ForgeKeyBinding_setKeyConflictContext, llllllllllllllIIlIllIllIIlllIIII);
        }
    }
    
    public GameSettings() {
        this.mouseSensitivity = 0.5f;
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = 120;
        this.clouds = 2;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.resourcePacks = (List<String>)Lists.newArrayList();
        this.incompatibleResourcePacks = (List<String>)Lists.newArrayList();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0f;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.useVbo = true;
        this.pauseOnLostFocus = true;
        this.setModelParts = (Set<EnumPlayerModelParts>)Sets.newHashSet((Object[])EnumPlayerModelParts.values());
        this.mainHand = EnumHandSide.RIGHT;
        this.heldItemTooltips = true;
        this.chatScale = 1.0f;
        this.chatWidth = 1.0f;
        this.chatHeightUnfocused = 0.44366196f;
        this.chatHeightFocused = 1.0f;
        this.mipmapLevels = 4;
        this.soundLevels = (Map<SoundCategory, Float>)Maps.newEnumMap((Class)SoundCategory.class);
        this.useNativeTransport = true;
        this.entityShadows = true;
        this.attackIndicator = 1;
        this.realmsNotifications = true;
        this.autoJump = true;
        this.field_193631_S = TutorialSteps.MOVEMENT;
        this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
        this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
        this.keyBindSwapHands = new KeyBinding("key.swapHands", 33, "key.categories.inventory");
        this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
        this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.field_194146_ao = new KeyBinding("key.advancements", 38, "key.categories.misc");
        this.keyBindsHotbar = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
        this.field_193629_ap = new KeyBinding("key.saveToolbarActivator", 46, "key.categories.creative");
        this.field_193630_aq = new KeyBinding("key.loadToolbarActivator", 45, "key.categories.creative");
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofScreenshotSize = 1;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        this.needsResourceRefresh = false;
        this.setForgeKeybindProperties();
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindFullscreen, this.keyBindSpectatorOutlines, this.keyBindSwapHands, this.field_193629_ap, this.field_193630_aq, this.field_194146_ao }, (Object[])this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = 70.0f;
        this.language = "en_us";
    }
    
    public void setOptionFloatValue(final Options llllllllllllllIIlIllIlllllIIIlll, final float llllllllllllllIIlIllIlllllIIIllI) {
        this.setOptionFloatValueOF(llllllllllllllIIlIllIlllllIIIlll, llllllllllllllIIlIllIlllllIIIllI);
        if (llllllllllllllIIlIllIlllllIIIlll == Options.SENSITIVITY) {
            this.mouseSensitivity = llllllllllllllIIlIllIlllllIIIllI;
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.FOV) {
            this.fovSetting = llllllllllllllIIlIllIlllllIIIllI;
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.GAMMA) {
            this.gammaSetting = llllllllllllllIIlIllIlllllIIIllI;
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.FRAMERATE_LIMIT) {
            this.limitFramerate = (int)llllllllllllllIIlIllIlllllIIIllI;
            this.enableVsync = false;
            if (this.limitFramerate <= 0) {
                this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
                this.enableVsync = true;
            }
            this.updateVSync();
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.CHAT_OPACITY) {
            this.chatOpacity = llllllllllllllIIlIllIlllllIIIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.CHAT_HEIGHT_FOCUSED) {
            this.chatHeightFocused = llllllllllllllIIlIllIlllllIIIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.CHAT_HEIGHT_UNFOCUSED) {
            this.chatHeightUnfocused = llllllllllllllIIlIllIlllllIIIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.CHAT_WIDTH) {
            this.chatWidth = llllllllllllllIIlIllIlllllIIIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.CHAT_SCALE) {
            this.chatScale = llllllllllllllIIlIllIlllllIIIllI;
            this.mc.ingameGUI.getChatGUI().refreshChat();
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.MIPMAP_LEVELS) {
            final int llllllllllllllIIlIllIlllllIIlIIl = this.mipmapLevels;
            this.mipmapLevels = (int)llllllllllllllIIlIllIlllllIIIllI;
            if (llllllllllllllIIlIllIlllllIIlIIl != llllllllllllllIIlIllIlllllIIIllI) {
                this.mc.getTextureMapBlocks().setMipmapLevels(this.mipmapLevels);
                this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                this.mc.getTextureMapBlocks().setBlurMipmapDirect(false, this.mipmapLevels > 0);
                this.mc.scheduleResourcesRefresh();
            }
        }
        if (llllllllllllllIIlIllIlllllIIIlll == Options.RENDER_DISTANCE) {
            this.renderDistanceChunks = (int)llllllllllllllIIlIllIlllllIIIllI;
            this.mc.renderGlobal.setDisplayListEntitiesDirty();
        }
    }
    
    public static boolean isKeyDown(final KeyBinding llllllllllllllIIlIllIlllllIlllIl) {
        final int llllllllllllllIIlIllIlllllIlllII = llllllllllllllIIlIllIlllllIlllIl.getKeyCode();
        return llllllllllllllIIlIllIlllllIlllII != 0 && llllllllllllllIIlIllIlllllIlllII < 256 && ((llllllllllllllIIlIllIlllllIlllII < 0) ? Mouse.isButtonDown(llllllllllllllIIlIllIlllllIlllII + 100) : Keyboard.isKeyDown(llllllllllllllIIlIllIlllllIlllII));
    }
    
    public GameSettings(final Minecraft llllllllllllllIIlIllIllllllIlIlI, final File llllllllllllllIIlIllIllllllIlIIl) {
        this.mouseSensitivity = 0.5f;
        this.renderDistanceChunks = -1;
        this.viewBobbing = true;
        this.fboEnable = true;
        this.limitFramerate = 120;
        this.clouds = 2;
        this.fancyGraphics = true;
        this.ambientOcclusion = 2;
        this.resourcePacks = (List<String>)Lists.newArrayList();
        this.incompatibleResourcePacks = (List<String>)Lists.newArrayList();
        this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
        this.chatColours = true;
        this.chatLinks = true;
        this.chatLinksPrompt = true;
        this.chatOpacity = 1.0f;
        this.snooperEnabled = true;
        this.enableVsync = true;
        this.useVbo = true;
        this.pauseOnLostFocus = true;
        this.setModelParts = (Set<EnumPlayerModelParts>)Sets.newHashSet((Object[])EnumPlayerModelParts.values());
        this.mainHand = EnumHandSide.RIGHT;
        this.heldItemTooltips = true;
        this.chatScale = 1.0f;
        this.chatWidth = 1.0f;
        this.chatHeightUnfocused = 0.44366196f;
        this.chatHeightFocused = 1.0f;
        this.mipmapLevels = 4;
        this.soundLevels = (Map<SoundCategory, Float>)Maps.newEnumMap((Class)SoundCategory.class);
        this.useNativeTransport = true;
        this.entityShadows = true;
        this.attackIndicator = 1;
        this.realmsNotifications = true;
        this.autoJump = true;
        this.field_193631_S = TutorialSteps.MOVEMENT;
        this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
        this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
        this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
        this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
        this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
        this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
        this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
        this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
        this.keyBindSwapHands = new KeyBinding("key.swapHands", 33, "key.categories.inventory");
        this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.inventory");
        this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
        this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
        this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
        this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
        this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
        this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
        this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
        this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
        this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
        this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
        this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
        this.field_194146_ao = new KeyBinding("key.advancements", 38, "key.categories.misc");
        this.keyBindsHotbar = new KeyBinding[] { new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory") };
        this.field_193629_ap = new KeyBinding("key.saveToolbarActivator", 46, "key.categories.creative");
        this.field_193630_aq = new KeyBinding("key.loadToolbarActivator", 45, "key.categories.creative");
        this.ofFogType = 1;
        this.ofFogStart = 0.8f;
        this.ofMipmapType = 0;
        this.ofOcclusionFancy = false;
        this.ofSmoothFps = false;
        this.ofSmoothWorld = Config.isSingleProcessor();
        this.ofLazyChunkLoading = Config.isSingleProcessor();
        this.ofAoLevel = 1.0f;
        this.ofAaLevel = 0;
        this.ofAfLevel = 1;
        this.ofClouds = 0;
        this.ofCloudsHeight = 0.0f;
        this.ofTrees = 0;
        this.ofRain = 0;
        this.ofDroppedItems = 0;
        this.ofBetterGrass = 3;
        this.ofAutoSaveTicks = 4000;
        this.ofLagometer = false;
        this.ofProfiler = false;
        this.ofShowFps = false;
        this.ofWeather = true;
        this.ofSky = true;
        this.ofStars = true;
        this.ofSunMoon = true;
        this.ofVignette = 0;
        this.ofChunkUpdates = 1;
        this.ofChunkUpdatesDynamic = false;
        this.ofTime = 0;
        this.ofClearWater = false;
        this.ofBetterSnow = false;
        this.ofFullscreenMode = "Default";
        this.ofSwampColors = true;
        this.ofRandomMobs = true;
        this.ofSmoothBiomes = true;
        this.ofCustomFonts = true;
        this.ofCustomColors = true;
        this.ofCustomSky = true;
        this.ofShowCapes = true;
        this.ofConnectedTextures = 2;
        this.ofCustomItems = true;
        this.ofNaturalTextures = false;
        this.ofFastMath = false;
        this.ofFastRender = false;
        this.ofTranslucentBlocks = 0;
        this.ofDynamicFov = true;
        this.ofAlternateBlocks = true;
        this.ofDynamicLights = 3;
        this.ofCustomEntityModels = true;
        this.ofCustomGuis = true;
        this.ofScreenshotSize = 1;
        this.ofAnimatedWater = 0;
        this.ofAnimatedLava = 0;
        this.ofAnimatedFire = true;
        this.ofAnimatedPortal = true;
        this.ofAnimatedRedstone = true;
        this.ofAnimatedExplosion = true;
        this.ofAnimatedFlame = true;
        this.ofAnimatedSmoke = true;
        this.ofVoidParticles = true;
        this.ofWaterParticles = true;
        this.ofRainSplash = true;
        this.ofPortalParticles = true;
        this.ofPotionParticles = true;
        this.ofFireworkParticles = true;
        this.ofDrippingWaterLava = true;
        this.ofAnimatedTerrain = true;
        this.ofAnimatedTextures = true;
        this.needsResourceRefresh = false;
        this.setForgeKeybindProperties();
        this.keyBindings = (KeyBinding[])ArrayUtils.addAll((Object[])new KeyBinding[] { this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindFullscreen, this.keyBindSpectatorOutlines, this.keyBindSwapHands, this.field_193629_ap, this.field_193630_aq, this.field_194146_ao }, (Object[])this.keyBindsHotbar);
        this.difficulty = EnumDifficulty.NORMAL;
        this.lastServer = "";
        this.fovSetting = 70.0f;
        this.language = "en_us";
        this.mc = llllllllllllllIIlIllIllllllIlIlI;
        this.optionsFile = new File(llllllllllllllIIlIllIllllllIlIIl, "options.txt");
        if (llllllllllllllIIlIllIllllllIlIlI.isJava64bit() && Runtime.getRuntime().maxMemory() >= 1000000000L) {
            Options.RENDER_DISTANCE.setValueMax(32.0f);
        }
        else {
            Options.RENDER_DISTANCE.setValueMax(16.0f);
        }
        this.renderDistanceChunks = (llllllllllllllIIlIllIllllllIlIlI.isJava64bit() ? 12 : 8);
        this.optionsFileOF = new File(llllllllllllllIIlIllIllllllIlIIl, "optionsof.txt");
        this.limitFramerate = (int)Options.FRAMERATE_LIMIT.getValueMax();
        this.ofKeyBindZoom = new KeyBinding("of.key.zoom", 46, "key.categories.misc");
        this.keyBindings = (KeyBinding[])ArrayUtils.add((Object[])this.keyBindings, (Object)this.ofKeyBindZoom);
        Options.RENDER_DISTANCE.setValueMax(32.0f);
        this.renderDistanceChunks = 8;
        this.loadOptions();
        Config.initGameSettings(this);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options() {
        final int[] $switch_TABLE$net$minecraft$client$settings$GameSettings$Options = GameSettings.$SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options;
        if ($switch_TABLE$net$minecraft$client$settings$GameSettings$Options != null) {
            return $switch_TABLE$net$minecraft$client$settings$GameSettings$Options;
        }
        final float llllllllllllllIIlIllIllIIllIlIIl = (Object)new int[Options.values().length];
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.AA_LEVEL.ordinal()] = 91;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ADVANCED_TOOLTIPS.ordinal()] = 106;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.AF_LEVEL.ordinal()] = 92;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ALTERNATE_BLOCKS.ordinal()] = 104;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.AMBIENT_OCCLUSION.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANAGLYPH.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_EXPLOSION.ordinal()] = 59;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_FIRE.ordinal()] = 51;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_FLAME.ordinal()] = 60;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_LAVA.ordinal()] = 50;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_PORTAL.ordinal()] = 52;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_REDSTONE.ordinal()] = 58;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_SMOKE.ordinal()] = 61;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_TERRAIN.ordinal()] = 82;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_TEXTURES.ordinal()] = 93;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ANIMATED_WATER.ordinal()] = 49;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.AO_LEVEL.ordinal()] = 53;
        }
        catch (NoSuchFieldError noSuchFieldError17) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ATTACK_INDICATOR.ordinal()] = 35;
        }
        catch (NoSuchFieldError noSuchFieldError18) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.AUTOSAVE_TICKS.ordinal()] = 56;
        }
        catch (NoSuchFieldError noSuchFieldError19) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.AUTO_JUMP.ordinal()] = 39;
        }
        catch (NoSuchFieldError noSuchFieldError20) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.BETTER_GRASS.ordinal()] = 57;
        }
        catch (NoSuchFieldError noSuchFieldError21) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.BETTER_SNOW.ordinal()] = 80;
        }
        catch (NoSuchFieldError noSuchFieldError22) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_COLOR.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError23) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_HEIGHT_FOCUSED.ordinal()] = 28;
        }
        catch (NoSuchFieldError noSuchFieldError24) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_HEIGHT_UNFOCUSED.ordinal()] = 29;
        }
        catch (NoSuchFieldError noSuchFieldError25) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_LINKS.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError26) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_LINKS_PROMPT.ordinal()] = 20;
        }
        catch (NoSuchFieldError noSuchFieldError27) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_OPACITY.ordinal()] = 19;
        }
        catch (NoSuchFieldError noSuchFieldError28) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_SCALE.ordinal()] = 26;
        }
        catch (NoSuchFieldError noSuchFieldError29) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_VISIBILITY.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError30) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHAT_WIDTH.ordinal()] = 27;
        }
        catch (NoSuchFieldError noSuchFieldError31) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHUNK_UPDATES.ordinal()] = 67;
        }
        catch (NoSuchFieldError noSuchFieldError32) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CHUNK_UPDATES_DYNAMIC.ordinal()] = 68;
        }
        catch (NoSuchFieldError noSuchFieldError33) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CLEAR_WATER.ordinal()] = 70;
        }
        catch (NoSuchFieldError noSuchFieldError34) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CLOUDS.ordinal()] = 45;
        }
        catch (NoSuchFieldError noSuchFieldError35) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CLOUD_HEIGHT.ordinal()] = 46;
        }
        catch (NoSuchFieldError noSuchFieldError36) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CONNECTED_TEXTURES.ordinal()] = 89;
        }
        catch (NoSuchFieldError noSuchFieldError37) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CUSTOM_COLORS.ordinal()] = 87;
        }
        catch (NoSuchFieldError noSuchFieldError38) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CUSTOM_ENTITY_MODELS.ordinal()] = 105;
        }
        catch (NoSuchFieldError noSuchFieldError39) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CUSTOM_FONTS.ordinal()] = 86;
        }
        catch (NoSuchFieldError noSuchFieldError40) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CUSTOM_GUIS.ordinal()] = 108;
        }
        catch (NoSuchFieldError noSuchFieldError41) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CUSTOM_ITEMS.ordinal()] = 90;
        }
        catch (NoSuchFieldError noSuchFieldError42) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.CUSTOM_SKY.ordinal()] = 98;
        }
        catch (NoSuchFieldError noSuchFieldError43) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.DRIPPING_WATER_LAVA.ordinal()] = 79;
        }
        catch (NoSuchFieldError noSuchFieldError44) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.DROPPED_ITEMS.ordinal()] = 96;
        }
        catch (NoSuchFieldError noSuchFieldError45) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.DYNAMIC_FOV.ordinal()] = 102;
        }
        catch (NoSuchFieldError noSuchFieldError46) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.DYNAMIC_LIGHTS.ordinal()] = 103;
        }
        catch (NoSuchFieldError noSuchFieldError47) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ENABLE_VSYNC.ordinal()] = 23;
        }
        catch (NoSuchFieldError noSuchFieldError48) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ENABLE_WEAK_ATTACKS.ordinal()] = 36;
        }
        catch (NoSuchFieldError noSuchFieldError49) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.ENTITY_SHADOWS.ordinal()] = 33;
        }
        catch (NoSuchFieldError noSuchFieldError50) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FAST_MATH.ordinal()] = 99;
        }
        catch (NoSuchFieldError noSuchFieldError51) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FAST_RENDER.ordinal()] = 100;
        }
        catch (NoSuchFieldError noSuchFieldError52) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FBO_ENABLE.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError53) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FIREWORK_PARTICLES.ordinal()] = 77;
        }
        catch (NoSuchFieldError noSuchFieldError54) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FOG_FANCY.ordinal()] = 41;
        }
        catch (NoSuchFieldError noSuchFieldError55) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FOG_START.ordinal()] = 42;
        }
        catch (NoSuchFieldError noSuchFieldError56) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FORCE_UNICODE_FONT.ordinal()] = 31;
        }
        catch (NoSuchFieldError noSuchFieldError57) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FOV.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError58) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FRAMERATE_LIMIT.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError59) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.FULLSCREEN_MODE.ordinal()] = 81;
        }
        catch (NoSuchFieldError noSuchFieldError60) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.GAMMA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError61) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.GRAPHICS.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError62) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.GUI_SCALE.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError63) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.HELD_ITEM_TOOLTIPS.ordinal()] = 95;
        }
        catch (NoSuchFieldError noSuchFieldError64) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.INVERT_MOUSE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError65) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.LAGOMETER.ordinal()] = 54;
        }
        catch (NoSuchFieldError noSuchFieldError66) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.LAZY_CHUNK_LOADING.ordinal()] = 97;
        }
        catch (NoSuchFieldError noSuchFieldError67) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.MAIN_HAND.ordinal()] = 34;
        }
        catch (NoSuchFieldError noSuchFieldError68) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.MIPMAP_LEVELS.ordinal()] = 30;
        }
        catch (NoSuchFieldError noSuchFieldError69) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.MIPMAP_TYPE.ordinal()] = 43;
        }
        catch (NoSuchFieldError noSuchFieldError70) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.NARRATOR.ordinal()] = 40;
        }
        catch (NoSuchFieldError noSuchFieldError71) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.NATURAL_TEXTURES.ordinal()] = 94;
        }
        catch (NoSuchFieldError noSuchFieldError72) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.PARTICLES.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError73) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.PORTAL_PARTICLES.ordinal()] = 75;
        }
        catch (NoSuchFieldError noSuchFieldError74) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.POTION_PARTICLES.ordinal()] = 76;
        }
        catch (NoSuchFieldError noSuchFieldError75) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.PROFILER.ordinal()] = 78;
        }
        catch (NoSuchFieldError noSuchFieldError76) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.RAIN.ordinal()] = 48;
        }
        catch (NoSuchFieldError noSuchFieldError77) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.RAIN_SPLASH.ordinal()] = 74;
        }
        catch (NoSuchFieldError noSuchFieldError78) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.RANDOM_MOBS.ordinal()] = 84;
        }
        catch (NoSuchFieldError noSuchFieldError79) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.REALMS_NOTIFICATIONS.ordinal()] = 38;
        }
        catch (NoSuchFieldError noSuchFieldError80) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.REDUCED_DEBUG_INFO.ordinal()] = 32;
        }
        catch (NoSuchFieldError noSuchFieldError81) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.RENDER_CLOUDS.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError82) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.RENDER_DISTANCE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError83) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SATURATION.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError84) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SCREENSHOT_SIZE.ordinal()] = 107;
        }
        catch (NoSuchFieldError noSuchFieldError85) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SENSITIVITY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError86) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SHOW_CAPES.ordinal()] = 88;
        }
        catch (NoSuchFieldError noSuchFieldError87) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SHOW_FPS.ordinal()] = 55;
        }
        catch (NoSuchFieldError noSuchFieldError88) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SHOW_SUBTITLES.ordinal()] = 37;
        }
        catch (NoSuchFieldError noSuchFieldError89) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SKY.ordinal()] = 63;
        }
        catch (NoSuchFieldError noSuchFieldError90) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SMOOTH_BIOMES.ordinal()] = 85;
        }
        catch (NoSuchFieldError noSuchFieldError91) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SMOOTH_FPS.ordinal()] = 44;
        }
        catch (NoSuchFieldError noSuchFieldError92) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SMOOTH_WORLD.ordinal()] = 71;
        }
        catch (NoSuchFieldError noSuchFieldError93) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SNOOPER_ENABLED.ordinal()] = 21;
        }
        catch (NoSuchFieldError noSuchFieldError94) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.STARS.ordinal()] = 64;
        }
        catch (NoSuchFieldError noSuchFieldError95) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SUN_MOON.ordinal()] = 65;
        }
        catch (NoSuchFieldError noSuchFieldError96) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.SWAMP_COLORS.ordinal()] = 83;
        }
        catch (NoSuchFieldError noSuchFieldError97) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.TIME.ordinal()] = 69;
        }
        catch (NoSuchFieldError noSuchFieldError98) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.TOUCHSCREEN.ordinal()] = 25;
        }
        catch (NoSuchFieldError noSuchFieldError99) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.TRANSLUCENT_BLOCKS.ordinal()] = 101;
        }
        catch (NoSuchFieldError noSuchFieldError100) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.TREES.ordinal()] = 47;
        }
        catch (NoSuchFieldError noSuchFieldError101) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.USE_FULLSCREEN.ordinal()] = 22;
        }
        catch (NoSuchFieldError noSuchFieldError102) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.USE_VBO.ordinal()] = 24;
        }
        catch (NoSuchFieldError noSuchFieldError103) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.VIEW_BOBBING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError104) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.VIGNETTE.ordinal()] = 66;
        }
        catch (NoSuchFieldError noSuchFieldError105) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.VOID_PARTICLES.ordinal()] = 72;
        }
        catch (NoSuchFieldError noSuchFieldError106) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.WATER_PARTICLES.ordinal()] = 73;
        }
        catch (NoSuchFieldError noSuchFieldError107) {}
        try {
            llllllllllllllIIlIllIllIIllIlIIl[Options.WEATHER.ordinal()] = 62;
        }
        catch (NoSuchFieldError noSuchFieldError108) {}
        return GameSettings.$SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options = (int[])(Object)llllllllllllllIIlIllIllIIllIlIIl;
    }
    
    private void updateRenderClouds() {
        switch (this.ofClouds) {
            case 1: {
                this.clouds = 1;
                break;
            }
            case 2: {
                this.clouds = 2;
                break;
            }
            case 3: {
                this.clouds = 0;
                break;
            }
            default: {
                if (this.fancyGraphics) {
                    this.clouds = 2;
                    break;
                }
                this.clouds = 1;
                break;
            }
        }
    }
    
    public void setModelPartEnabled(final EnumPlayerModelParts llllllllllllllIIlIllIlllIIIIllIl, final boolean llllllllllllllIIlIllIlllIIIIllll) {
        if (llllllllllllllIIlIllIlllIIIIllll) {
            this.setModelParts.add(llllllllllllllIIlIllIlllIIIIllIl);
        }
        else {
            this.setModelParts.remove(llllllllllllllIIlIllIlllIIIIllIl);
        }
        this.sendSettingsToServer();
    }
    
    private static int nextValue(final int llllllllllllllIIlIllIllIlIIIlIII, final int[] llllllllllllllIIlIllIllIlIIIIlll) {
        int llllllllllllllIIlIllIllIlIIIlIIl = indexOf(llllllllllllllIIlIllIllIlIIIlIII, llllllllllllllIIlIllIllIlIIIIlll);
        if (llllllllllllllIIlIllIllIlIIIlIIl < 0) {
            return llllllllllllllIIlIllIllIlIIIIlll[0];
        }
        if (++llllllllllllllIIlIllIllIlIIIlIIl >= llllllllllllllIIlIllIllIlIIIIlll.length) {
            llllllllllllllIIlIllIllIlIIIlIIl = 0;
        }
        return llllllllllllllIIlIllIllIlIIIIlll[llllllllllllllIIlIllIllIlIIIlIIl];
    }
    
    public void setSoundLevel(final SoundCategory llllllllllllllIIlIllIlllIIlIIlII, final float llllllllllllllIIlIllIlllIIlIIIll) {
        this.mc.getSoundHandler().setSoundLevel(llllllllllllllIIlIllIlllIIlIIlII, llllllllllllllIIlIllIlllIIlIIIll);
        this.soundLevels.put(llllllllllllllIIlIllIlllIIlIIlII, llllllllllllllIIlIllIlllIIlIIIll);
    }
    
    public void setOptionKeyBinding(final KeyBinding llllllllllllllIIlIllIlllllIlIlIl, final int llllllllllllllIIlIllIlllllIlIIIl) {
        llllllllllllllIIlIllIlllllIlIlIl.setKeyCode(llllllllllllllIIlIllIlllllIlIIIl);
        this.saveOptions();
    }
    
    public void setOptionValue(final Options llllllllllllllIIlIllIllllIllllII, final int llllllllllllllIIlIllIllllIlllIll) {
        this.setOptionValueOF(llllllllllllllIIlIllIllllIllllII, llllllllllllllIIlIllIllllIlllIll);
        if (llllllllllllllIIlIllIllllIllllII == Options.RENDER_DISTANCE) {
            this.setOptionFloatValue(llllllllllllllIIlIllIllllIllllII, MathHelper.clamp((float)(this.renderDistanceChunks + llllllllllllllIIlIllIllllIlllIll), llllllllllllllIIlIllIllllIllllII.getValueMin(), llllllllllllllIIlIllIllllIllllII.getValueMax()));
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.MAIN_HAND) {
            this.mainHand = this.mainHand.opposite();
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.INVERT_MOUSE) {
            this.invertMouse = !this.invertMouse;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.GUI_SCALE) {
            this.guiScale += llllllllllllllIIlIllIllllIlllIll;
            if (GuiScreen.isShiftKeyDown()) {
                this.guiScale = 0;
            }
            final DisplayMode llllllllllllllIIlIllIllllIlllIlI = Config.getLargestDisplayMode();
            final int llllllllllllllIIlIllIllllIlllIIl = llllllllllllllIIlIllIllllIlllIlI.getWidth() / 320;
            final int llllllllllllllIIlIllIllllIlllIII = llllllllllllllIIlIllIllllIlllIlI.getHeight() / 240;
            final int llllllllllllllIIlIllIllllIllIlll = Math.min(llllllllllllllIIlIllIllllIlllIIl, llllllllllllllIIlIllIllllIlllIII);
            if (this.guiScale < 0) {
                this.guiScale = llllllllllllllIIlIllIllllIllIlll - 1;
            }
            if (this.mc.isUnicode() && this.guiScale % 2 != 0) {
                this.guiScale += llllllllllllllIIlIllIllllIlllIll;
            }
            if (this.guiScale < 0 || this.guiScale >= llllllllllllllIIlIllIllllIllIlll) {
                this.guiScale = 0;
            }
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.PARTICLES) {
            this.particleSetting = (this.particleSetting + llllllllllllllIIlIllIllllIlllIll) % 3;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.VIEW_BOBBING) {
            this.viewBobbing = !this.viewBobbing;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.RENDER_CLOUDS) {
            this.clouds = (this.clouds + llllllllllllllIIlIllIllllIlllIll) % 3;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.FORCE_UNICODE_FONT) {
            this.forceUnicodeFont = !this.forceUnicodeFont;
            this.mc.fontRendererObj.setUnicodeFlag(this.mc.getLanguageManager().isCurrentLocaleUnicode() || this.forceUnicodeFont);
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.FBO_ENABLE) {
            this.fboEnable = !this.fboEnable;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.ANAGLYPH) {
            if (!this.anaglyph && Config.isShaders()) {
                Config.showGuiMessage(Lang.get("of.message.an.shaders1"), Lang.get("of.message.an.shaders2"));
                return;
            }
            this.anaglyph = !this.anaglyph;
            this.mc.refreshResources();
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.GRAPHICS) {
            this.fancyGraphics = !this.fancyGraphics;
            this.updateRenderClouds();
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.AMBIENT_OCCLUSION) {
            this.ambientOcclusion = (this.ambientOcclusion + llllllllllllllIIlIllIllllIlllIll) % 3;
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.CHAT_VISIBILITY) {
            this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility((this.chatVisibility.getChatVisibility() + llllllllllllllIIlIllIllllIlllIll) % 3);
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.CHAT_COLOR) {
            this.chatColours = !this.chatColours;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.CHAT_LINKS) {
            this.chatLinks = !this.chatLinks;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.CHAT_LINKS_PROMPT) {
            this.chatLinksPrompt = !this.chatLinksPrompt;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.SNOOPER_ENABLED) {
            this.snooperEnabled = !this.snooperEnabled;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.TOUCHSCREEN) {
            this.touchscreen = !this.touchscreen;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.USE_FULLSCREEN) {
            this.fullScreen = !this.fullScreen;
            if (this.mc.isFullScreen() != this.fullScreen) {
                this.mc.toggleFullscreen();
            }
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.ENABLE_VSYNC) {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.USE_VBO) {
            this.useVbo = !this.useVbo;
            this.mc.renderGlobal.loadRenderers();
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.REDUCED_DEBUG_INFO) {
            this.reducedDebugInfo = !this.reducedDebugInfo;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.ENTITY_SHADOWS) {
            this.entityShadows = !this.entityShadows;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.ATTACK_INDICATOR) {
            this.attackIndicator = (this.attackIndicator + llllllllllllllIIlIllIllllIlllIll) % 3;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.SHOW_SUBTITLES) {
            this.showSubtitles = !this.showSubtitles;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.REALMS_NOTIFICATIONS) {
            this.realmsNotifications = !this.realmsNotifications;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.AUTO_JUMP) {
            this.autoJump = !this.autoJump;
        }
        if (llllllllllllllIIlIllIllllIllllII == Options.NARRATOR) {
            if (NarratorChatListener.field_193643_a.func_193640_a()) {
                this.field_192571_R = (this.field_192571_R + llllllllllllllIIlIllIllllIlllIll) % GameSettings.field_193632_b.length;
            }
            else {
                this.field_192571_R = 0;
            }
            NarratorChatListener.field_193643_a.func_193641_a(this.field_192571_R);
        }
        this.saveOptions();
    }
    
    public boolean getOptionOrdinalValue(final Options llllllllllllllIIlIllIllllIlIIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options()[llllllllllllllIIlIllIllllIlIIIIl.ordinal()]) {
            case 1: {
                return this.invertMouse;
            }
            case 7: {
                return this.viewBobbing;
            }
            case 8: {
                return this.anaglyph;
            }
            case 10: {
                return this.fboEnable;
            }
            case 17: {
                return this.chatColours;
            }
            case 18: {
                return this.chatLinks;
            }
            case 20: {
                return this.chatLinksPrompt;
            }
            case 21: {
                return this.snooperEnabled;
            }
            case 22: {
                return this.fullScreen;
            }
            case 23: {
                return this.enableVsync;
            }
            case 24: {
                return this.useVbo;
            }
            case 25: {
                return this.touchscreen;
            }
            case 31: {
                return this.forceUnicodeFont;
            }
            case 32: {
                return this.reducedDebugInfo;
            }
            case 33: {
                return this.entityShadows;
            }
            case 37: {
                return this.showSubtitles;
            }
            case 38: {
                return this.realmsNotifications;
            }
            case 36: {
                return this.enableWeakAttacks;
            }
            case 39: {
                return this.autoJump;
            }
            default: {
                return false;
            }
        }
    }
    
    public float getOptionFloatValue(final Options llllllllllllllIIlIllIllllIlIlIII) {
        final float llllllllllllllIIlIllIllllIlIlIlI = this.getOptionFloatValueOF(llllllllllllllIIlIllIllllIlIlIII);
        if (llllllllllllllIIlIllIllllIlIlIlI != Float.MAX_VALUE) {
            return llllllllllllllIIlIllIllllIlIlIlI;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.FOV) {
            return this.fovSetting;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.GAMMA) {
            return this.gammaSetting;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.SATURATION) {
            return this.saturation;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.SENSITIVITY) {
            return this.mouseSensitivity;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.CHAT_OPACITY) {
            return this.chatOpacity;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.CHAT_HEIGHT_FOCUSED) {
            return this.chatHeightFocused;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.CHAT_HEIGHT_UNFOCUSED) {
            return this.chatHeightUnfocused;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.CHAT_SCALE) {
            return this.chatScale;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.CHAT_WIDTH) {
            return this.chatWidth;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.FRAMERATE_LIMIT) {
            return (float)this.limitFramerate;
        }
        if (llllllllllllllIIlIllIllllIlIlIII == Options.MIPMAP_LEVELS) {
            return (float)this.mipmapLevels;
        }
        return (llllllllllllllIIlIllIllllIlIlIII == Options.RENDER_DISTANCE) ? ((float)this.renderDistanceChunks) : 0.0f;
    }
    
    public void saveOptions() {
        if (Reflector.FMLClientHandler.exists()) {
            final Object llllllllllllllIIlIllIlllIlIIIlII = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            if (llllllllllllllIIlIllIlllIlIIIlII != null && Reflector.callBoolean(llllllllllllllIIlIllIlllIlIIIlII, Reflector.FMLClientHandler_isLoading, new Object[0])) {
                return;
            }
        }
        PrintWriter llllllllllllllIIlIllIlllIlIIIIll = null;
        Label_1777: {
            try {
                llllllllllllllIIlIllIlllIlIIIIll = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.optionsFile), StandardCharsets.UTF_8));
                llllllllllllllIIlIllIlllIlIIIIll.println("version:1343");
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("invertYMouse:").append(this.invertMouse)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("mouseSensitivity:").append(this.mouseSensitivity)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("fov:").append((this.fovSetting - 70.0f) / 40.0f)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("gamma:").append(this.gammaSetting)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("saturation:").append(this.saturation)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("renderDistance:").append(this.renderDistanceChunks)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("guiScale:").append(this.guiScale)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("particles:").append(this.particleSetting)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("bobView:").append(this.viewBobbing)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("anaglyph3d:").append(this.anaglyph)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("maxFps:").append(this.limitFramerate)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("fboEnable:").append(this.fboEnable)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("difficulty:").append(this.difficulty.getDifficultyId())));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("fancyGraphics:").append(this.fancyGraphics)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("ao:").append(this.ambientOcclusion)));
                switch (this.clouds) {
                    case 0: {
                        llllllllllllllIIlIllIlllIlIIIIll.println("renderClouds:false");
                        break;
                    }
                    case 1: {
                        llllllllllllllIIlIllIlllIlIIIIll.println("renderClouds:fast");
                        break;
                    }
                    case 2: {
                        llllllllllllllIIlIllIlllIlIIIIll.println("renderClouds:true");
                        break;
                    }
                }
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("resourcePacks:").append(GameSettings.GSON.toJson((Object)this.resourcePacks))));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("incompatibleResourcePacks:").append(GameSettings.GSON.toJson((Object)this.incompatibleResourcePacks))));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("lastServer:").append(this.lastServer)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("lang:").append(this.language)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatVisibility:").append(this.chatVisibility.getChatVisibility())));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatColors:").append(this.chatColours)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatLinks:").append(this.chatLinks)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatLinksPrompt:").append(this.chatLinksPrompt)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatOpacity:").append(this.chatOpacity)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("snooperEnabled:").append(this.snooperEnabled)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("fullscreen:").append(this.fullScreen)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("enableVsync:").append(this.enableVsync)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("useVbo:").append(this.useVbo)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("hideServerAddress:").append(this.hideServerAddress)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("advancedItemTooltips:").append(this.advancedItemTooltips)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("pauseOnLostFocus:").append(this.pauseOnLostFocus)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("touchscreen:").append(this.touchscreen)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("overrideWidth:").append(this.overrideWidth)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("overrideHeight:").append(this.overrideHeight)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("heldItemTooltips:").append(this.heldItemTooltips)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatHeightFocused:").append(this.chatHeightFocused)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatHeightUnfocused:").append(this.chatHeightUnfocused)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatScale:").append(this.chatScale)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("chatWidth:").append(this.chatWidth)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("mipmapLevels:").append(this.mipmapLevels)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("forceUnicodeFont:").append(this.forceUnicodeFont)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("reducedDebugInfo:").append(this.reducedDebugInfo)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("useNativeTransport:").append(this.useNativeTransport)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("entityShadows:").append(this.entityShadows)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("mainHand:").append((this.mainHand == EnumHandSide.LEFT) ? "left" : "right")));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("attackIndicator:").append(this.attackIndicator)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("showSubtitles:").append(this.showSubtitles)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("realmsNotifications:").append(this.realmsNotifications)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("enableWeakAttacks:").append(this.enableWeakAttacks)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("autoJump:").append(this.autoJump)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("narrator:").append(this.field_192571_R)));
                llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("tutorialStep:").append(this.field_193631_S.func_193308_a())));
                char llllllllllllllIIlIllIlllIIllIllI;
                long llllllllllllllIIlIllIlllIIllIlll = ((KeyBinding[])(Object)(llllllllllllllIIlIllIlllIIllIllI = (char)(Object)this.keyBindings)).length;
                for (Exception llllllllllllllIIlIllIlllIIlllIII = (Exception)0; llllllllllllllIIlIllIlllIIlllIII < llllllllllllllIIlIllIlllIIllIlll; ++llllllllllllllIIlIllIlllIIlllIII) {
                    final KeyBinding llllllllllllllIIlIllIlllIlIIIIlI = llllllllllllllIIlIllIlllIIllIllI[llllllllllllllIIlIllIlllIIlllIII];
                    if (Reflector.ForgeKeyBinding_getKeyModifier.exists()) {
                        final String llllllllllllllIIlIllIlllIlIIIIIl = String.valueOf(new StringBuilder("key_").append(llllllllllllllIIlIllIlllIlIIIIlI.getKeyDescription()).append(":").append(llllllllllllllIIlIllIlllIlIIIIlI.getKeyCode()));
                        final Object llllllllllllllIIlIllIlllIlIIIIII = Reflector.call(llllllllllllllIIlIllIlllIlIIIIlI, Reflector.ForgeKeyBinding_getKeyModifier, new Object[0]);
                        final Object llllllllllllllIIlIllIlllIIllllll = Reflector.getFieldValue(Reflector.KeyModifier_NONE);
                        llllllllllllllIIlIllIlllIlIIIIll.println((llllllllllllllIIlIllIlllIlIIIIII != llllllllllllllIIlIllIlllIIllllll) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIlllIlIIIIIl)).append(":").append(llllllllllllllIIlIllIlllIlIIIIII)) : llllllllllllllIIlIllIlllIlIIIIIl);
                    }
                    else {
                        llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("key_").append(llllllllllllllIIlIllIlllIlIIIIlI.getKeyDescription()).append(":").append(llllllllllllllIIlIllIlllIlIIIIlI.getKeyCode())));
                    }
                }
                llllllllllllllIIlIllIlllIIllIlll = ((SoundCategory[])(Object)(llllllllllllllIIlIllIlllIIllIllI = (char)(Object)SoundCategory.values())).length;
                for (Exception llllllllllllllIIlIllIlllIIlllIII = (Exception)0; llllllllllllllIIlIllIlllIIlllIII < llllllllllllllIIlIllIlllIIllIlll; ++llllllllllllllIIlIllIlllIIlllIII) {
                    final SoundCategory llllllllllllllIIlIllIlllIIlllllI = llllllllllllllIIlIllIlllIIllIllI[llllllllllllllIIlIllIlllIIlllIII];
                    llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("soundCategory_").append(llllllllllllllIIlIllIlllIIlllllI.getName()).append(":").append(this.getSoundLevel(llllllllllllllIIlIllIlllIIlllllI))));
                }
                llllllllllllllIIlIllIlllIIllIlll = ((EnumPlayerModelParts[])(Object)(llllllllllllllIIlIllIlllIIllIllI = (char)(Object)EnumPlayerModelParts.values())).length;
                for (Exception llllllllllllllIIlIllIlllIIlllIII = (Exception)0; llllllllllllllIIlIllIlllIIlllIII < llllllllllllllIIlIllIlllIIllIlll; ++llllllllllllllIIlIllIlllIIlllIII) {
                    final EnumPlayerModelParts llllllllllllllIIlIllIlllIIllllIl = llllllllllllllIIlIllIlllIIllIllI[llllllllllllllIIlIllIlllIIlllIII];
                    llllllllllllllIIlIllIlllIlIIIIll.println(String.valueOf(new StringBuilder("modelPart_").append(llllllllllllllIIlIllIlllIIllllIl.getPartName()).append(":").append(this.setModelParts.contains(llllllllllllllIIlIllIlllIIllllIl))));
                }
            }
            catch (Exception llllllllllllllIIlIllIlllIIllllII) {
                GameSettings.LOGGER.error("Failed to save options", (Throwable)llllllllllllllIIlIllIlllIIllllII);
                break Label_1777;
            }
            finally {
                IOUtils.closeQuietly((Writer)llllllllllllllIIlIllIlllIlIIIIll);
            }
            IOUtils.closeQuietly((Writer)llllllllllllllIIlIllIlllIlIIIIll);
        }
        this.saveOfOptions();
        this.sendSettingsToServer();
    }
    
    public void sendSettingsToServer() {
        if (this.mc.player != null) {
            int llllllllllllllIIlIllIlllIIIlllIl = 0;
            for (final EnumPlayerModelParts llllllllllllllIIlIllIlllIIIlllII : this.setModelParts) {
                llllllllllllllIIlIllIlllIIIlllIl |= llllllllllllllIIlIllIlllIIIlllII.getPartMask();
            }
            this.mc.player.connection.sendPacket(new CPacketClientSettings(this.language, this.renderDistanceChunks, this.chatVisibility, this.chatColours, llllllllllllllIIlIllIlllIIIlllIl, this.mainHand));
        }
    }
    
    private float parseFloat(final String llllllllllllllIIlIllIlllIlIlIIIl) {
        if ("true".equals(llllllllllllllIIlIllIlllIlIlIIIl)) {
            return 1.0f;
        }
        return "false".equals(llllllllllllllIIlIllIlllIlIlIIIl) ? 0.0f : Float.parseFloat(llllllllllllllIIlIllIlllIlIlIIIl);
    }
    
    private String getKeyBindingOF(final Options llllllllllllllIIlIllIllIllIIIIlI) {
        String llllllllllllllIIlIllIllIllIIllII = String.valueOf(new StringBuilder(String.valueOf(I18n.format(llllllllllllllIIlIllIllIllIIIIlI.getEnumString(), new Object[0]))).append(": "));
        if (llllllllllllllIIlIllIllIllIIllII == null) {
            llllllllllllllIIlIllIllIllIIllII = llllllllllllllIIlIllIllIllIIIIlI.getEnumString();
        }
        if (llllllllllllllIIlIllIllIllIIIIlI == Options.RENDER_DISTANCE) {
            final int llllllllllllllIIlIllIllIllIIlIll = (int)this.getOptionFloatValue(llllllllllllllIIlIllIllIllIIIIlI);
            String llllllllllllllIIlIllIllIllIIlIlI = I18n.format("of.options.renderDistance.tiny", new Object[0]);
            int llllllllllllllIIlIllIllIllIIlIIl = 2;
            if (llllllllllllllIIlIllIllIllIIlIll >= 4) {
                llllllllllllllIIlIllIllIllIIlIlI = I18n.format("of.options.renderDistance.short", new Object[0]);
                llllllllllllllIIlIllIllIllIIlIIl = 4;
            }
            if (llllllllllllllIIlIllIllIllIIlIll >= 8) {
                llllllllllllllIIlIllIllIllIIlIlI = I18n.format("of.options.renderDistance.normal", new Object[0]);
                llllllllllllllIIlIllIllIllIIlIIl = 8;
            }
            if (llllllllllllllIIlIllIllIllIIlIll >= 16) {
                llllllllllllllIIlIllIllIllIIlIlI = I18n.format("of.options.renderDistance.far", new Object[0]);
                llllllllllllllIIlIllIllIllIIlIIl = 16;
            }
            if (llllllllllllllIIlIllIllIllIIlIll >= 32) {
                llllllllllllllIIlIllIllIllIIlIlI = Lang.get("of.options.renderDistance.extreme");
                llllllllllllllIIlIllIllIllIIlIIl = 32;
            }
            final int llllllllllllllIIlIllIllIllIIlIII = this.renderDistanceChunks - llllllllllllllIIlIllIllIllIIlIIl;
            String llllllllllllllIIlIllIllIllIIIlll = llllllllllllllIIlIllIllIllIIlIlI;
            if (llllllllllllllIIlIllIllIllIIlIII > 0) {
                llllllllllllllIIlIllIllIllIIIlll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIlIlI)).append("+"));
            }
            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(llllllllllllllIIlIllIllIllIIlIll).append(" ").append(llllllllllllllIIlIllIllIllIIIlll));
        }
        if (llllllllllllllIIlIllIllIllIIIIlI == Options.FOG_FANCY) {
            switch (this.ofFogType) {
                case 1: {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                }
                case 2: {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                }
                case 3: {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                }
                default: {
                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                }
            }
        }
        else {
            if (llllllllllllllIIlIllIllIllIIIIlI == Options.FOG_START) {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(this.ofFogStart));
            }
            if (llllllllllllllIIlIllIllIllIIIIlI == Options.MIPMAP_TYPE) {
                switch (this.ofMipmapType) {
                    case 0: {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.mipmap.nearest")));
                    }
                    case 1: {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.mipmap.linear")));
                    }
                    case 2: {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.mipmap.bilinear")));
                    }
                    case 3: {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.mipmap.trilinear")));
                    }
                    default: {
                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append("of.options.mipmap.nearest"));
                    }
                }
            }
            else {
                if (llllllllllllllIIlIllIllIllIIIIlI == Options.SMOOTH_FPS) {
                    return this.ofSmoothFps ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                }
                if (llllllllllllllIIlIllIllIllIIIIlI == Options.SMOOTH_WORLD) {
                    return this.ofSmoothWorld ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                }
                if (llllllllllllllIIlIllIllIllIIIIlI == Options.CLOUDS) {
                    switch (this.ofClouds) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                        }
                        case 3: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                        }
                    }
                }
                else if (llllllllllllllIIlIllIllIllIIIIlI == Options.TREES) {
                    switch (this.ofTrees) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                        }
                        case 4: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.general.smart")));
                        }
                    }
                }
                else if (llllllllllllllIIlIllIllIllIIIIlI == Options.DROPPED_ITEMS) {
                    switch (this.ofDroppedItems) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                        }
                    }
                }
                else if (llllllllllllllIIlIllIllIllIIIIlI == Options.RAIN) {
                    switch (this.ofRain) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                        }
                        case 3: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                        }
                    }
                }
                else if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_WATER) {
                    switch (this.ofAnimatedWater) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.animation.dynamic")));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn()));
                        }
                    }
                }
                else if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_LAVA) {
                    switch (this.ofAnimatedLava) {
                        case 1: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.animation.dynamic")));
                        }
                        case 2: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        default: {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn()));
                        }
                    }
                }
                else {
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_FIRE) {
                        return this.ofAnimatedFire ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_PORTAL) {
                        return this.ofAnimatedPortal ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_REDSTONE) {
                        return this.ofAnimatedRedstone ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_EXPLOSION) {
                        return this.ofAnimatedExplosion ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_FLAME) {
                        return this.ofAnimatedFlame ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_SMOKE) {
                        return this.ofAnimatedSmoke ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.VOID_PARTICLES) {
                        return this.ofVoidParticles ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.WATER_PARTICLES) {
                        return this.ofWaterParticles ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.PORTAL_PARTICLES) {
                        return this.ofPortalParticles ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.POTION_PARTICLES) {
                        return this.ofPotionParticles ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.FIREWORK_PARTICLES) {
                        return this.ofFireworkParticles ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.DRIPPING_WATER_LAVA) {
                        return this.ofDrippingWaterLava ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_TERRAIN) {
                        return this.ofAnimatedTerrain ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ANIMATED_TEXTURES) {
                        return this.ofAnimatedTextures ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.RAIN_SPLASH) {
                        return this.ofRainSplash ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.LAGOMETER) {
                        return this.ofLagometer ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.SHOW_FPS) {
                        return this.ofShowFps ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                    }
                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.AUTOSAVE_TICKS) {
                        if (this.ofAutoSaveTicks <= 40) {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.save.default")));
                        }
                        if (this.ofAutoSaveTicks <= 400) {
                            return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.save.20s")));
                        }
                        return (this.ofAutoSaveTicks <= 4000) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.save.3min"))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.save.30min")));
                    }
                    else if (llllllllllllllIIlIllIllIllIIIIlI == Options.BETTER_GRASS) {
                        switch (this.ofBetterGrass) {
                            case 1: {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                            }
                            case 2: {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                            }
                            default: {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                            }
                        }
                    }
                    else if (llllllllllllllIIlIllIllIllIIIIlI == Options.CONNECTED_TEXTURES) {
                        switch (this.ofConnectedTextures) {
                            case 1: {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                            }
                            case 2: {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                            }
                            default: {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                            }
                        }
                    }
                    else {
                        if (llllllllllllllIIlIllIllIllIIIIlI == Options.WEATHER) {
                            return this.ofWeather ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        if (llllllllllllllIIlIllIllIllIIIIlI == Options.SKY) {
                            return this.ofSky ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        if (llllllllllllllIIlIllIllIllIIIIlI == Options.STARS) {
                            return this.ofStars ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        if (llllllllllllllIIlIllIllIllIIIIlI == Options.SUN_MOON) {
                            return this.ofSunMoon ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                        }
                        if (llllllllllllllIIlIllIllIllIIIIlI == Options.VIGNETTE) {
                            switch (this.ofVignette) {
                                case 1: {
                                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                                }
                                case 2: {
                                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy()));
                                }
                                default: {
                                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                                }
                            }
                        }
                        else {
                            if (llllllllllllllIIlIllIllIllIIIIlI == Options.CHUNK_UPDATES) {
                                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(this.ofChunkUpdates));
                            }
                            if (llllllllllllllIIlIllIllIllIIIIlI == Options.CHUNK_UPDATES_DYNAMIC) {
                                return this.ofChunkUpdatesDynamic ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                            }
                            if (llllllllllllllIIlIllIllIllIIIIlI == Options.TIME) {
                                if (this.ofTime == 1) {
                                    return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.time.dayOnly")));
                                }
                                return (this.ofTime == 2) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.time.nightOnly"))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                            }
                            else {
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.CLEAR_WATER) {
                                    return this.ofClearWater ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.AA_LEVEL) {
                                    String llllllllllllllIIlIllIllIllIIIllI = "";
                                    if (this.ofAaLevel != Config.getAntialiasingLevel()) {
                                        llllllllllllllIIlIllIllIllIIIllI = String.valueOf(new StringBuilder(" (").append(Lang.get("of.general.restart")).append(")"));
                                    }
                                    return (this.ofAaLevel == 0) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()).append(llllllllllllllIIlIllIllIllIIIllI)) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(this.ofAaLevel).append(llllllllllllllIIlIllIllIllIIIllI));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.AF_LEVEL) {
                                    return (this.ofAfLevel == 1) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(this.ofAfLevel));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.PROFILER) {
                                    return this.ofProfiler ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.BETTER_SNOW) {
                                    return this.ofBetterSnow ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.SWAMP_COLORS) {
                                    return this.ofSwampColors ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.RANDOM_MOBS) {
                                    return this.ofRandomMobs ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.SMOOTH_BIOMES) {
                                    return this.ofSmoothBiomes ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.CUSTOM_FONTS) {
                                    return this.ofCustomFonts ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.CUSTOM_COLORS) {
                                    return this.ofCustomColors ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.CUSTOM_SKY) {
                                    return this.ofCustomSky ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.SHOW_CAPES) {
                                    return this.ofShowCapes ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.CUSTOM_ITEMS) {
                                    return this.ofCustomItems ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.NATURAL_TEXTURES) {
                                    return this.ofNaturalTextures ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.FAST_MATH) {
                                    return this.ofFastMath ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.FAST_RENDER) {
                                    return this.ofFastRender ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                }
                                if (llllllllllllllIIlIllIllIllIIIIlI == Options.TRANSLUCENT_BLOCKS) {
                                    if (this.ofTranslucentBlocks == 1) {
                                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFast()));
                                    }
                                    return (this.ofTranslucentBlocks == 2) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getFancy())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault()));
                                }
                                else {
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.LAZY_CHUNK_LOADING) {
                                        return this.ofLazyChunkLoading ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.DYNAMIC_FOV) {
                                        return this.ofDynamicFov ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ALTERNATE_BLOCKS) {
                                        return this.ofAlternateBlocks ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.DYNAMIC_LIGHTS) {
                                        final int llllllllllllllIIlIllIllIllIIIlIl = indexOf(this.ofDynamicLights, GameSettings.OF_DYNAMIC_LIGHTS);
                                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(getTranslation(GameSettings.KEYS_DYNAMIC_LIGHTS, llllllllllllllIIlIllIllIllIIIlIl)));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.SCREENSHOT_SIZE) {
                                        return (this.ofScreenshotSize <= 1) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(this.ofScreenshotSize).append("x"));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.CUSTOM_ENTITY_MODELS) {
                                        return this.ofCustomEntityModels ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.CUSTOM_GUIS) {
                                        return this.ofCustomGuis ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.FULLSCREEN_MODE) {
                                        return this.ofFullscreenMode.equals("Default") ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getDefault())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(this.ofFullscreenMode));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.HELD_ITEM_TOOLTIPS) {
                                        return this.heldItemTooltips ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI == Options.ADVANCED_TOOLTIPS) {
                                        return this.advancedItemTooltips ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOn())) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.getOff()));
                                    }
                                    if (llllllllllllllIIlIllIllIllIIIIlI != Options.FRAMERATE_LIMIT) {
                                        return null;
                                    }
                                    final float llllllllllllllIIlIllIllIllIIIlII = this.getOptionFloatValue(llllllllllllllIIlIllIllIllIIIIlI);
                                    if (llllllllllllllIIlIllIllIllIIIlII == 0.0f) {
                                        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(Lang.get("of.options.framerateLimit.vsync")));
                                    }
                                    return (llllllllllllllIIlIllIllIllIIIlII == llllllllllllllIIlIllIllIllIIIIlI.valueMax) ? String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append(I18n.format("options.framerateLimit.max", new Object[0]))) : String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIllIllIllIIllII)).append((int)llllllllllllllIIlIllIllIllIIIlII).append(" fps"));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public enum Options
    {
        ENABLE_WEAK_ATTACKS("ENABLE_WEAK_ATTACKS", 35, "options.enableWeakAttacks", false, true), 
        SNOOPER_ENABLED("SNOOPER_ENABLED", 20, "options.snooper", false, true), 
        CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 27, "options.chat.height.focused", true, false), 
        ANIMATED_SMOKE("ANIMATED_SMOKE", 60, "of.options.ANIMATED_SMOKE", false, false), 
        FOG_FANCY("FOG_FANCY", 40, "of.options.FOG_FANCY", false, false), 
        CONNECTED_TEXTURES("CONNECTED_TEXTURES", 88, "of.options.CONNECTED_TEXTURES", false, false);
        
        private /* synthetic */ float valueMax;
        
        DYNAMIC_LIGHTS("DYNAMIC_LIGHTS", 102, "of.options.DYNAMIC_LIGHTS", false, false), 
        ENTITY_SHADOWS("ENTITY_SHADOWS", 32, "options.entityShadows", false, true), 
        SHOW_CAPES("SHOW_CAPES", 87, "of.options.SHOW_CAPES", false, false), 
        ANIMATED_FLAME("ANIMATED_FLAME", 59, "of.options.ANIMATED_FLAME", false, false), 
        BETTER_GRASS("BETTER_GRASS", 56, "of.options.BETTER_GRASS", false, false), 
        SCREENSHOT_SIZE("SCREENSHOT_SIZE", 106, "of.options.SCREENSHOT_SIZE", false, false), 
        USE_VBO("USE_VBO", 23, "options.vbo", false, true), 
        DROPPED_ITEMS("DROPPED_ITEMS", 95, "of.options.DROPPED_ITEMS", false, false), 
        SKY("SKY", 62, "of.options.SKY", false, false), 
        NATURAL_TEXTURES("NATURAL_TEXTURES", 93, "of.options.NATURAL_TEXTURES", false, false), 
        CHUNK_UPDATES_DYNAMIC("CHUNK_UPDATES_DYNAMIC", 67, "of.options.CHUNK_UPDATES_DYNAMIC", false, false), 
        PROFILER("PROFILER", 77, "of.options.PROFILER", false, false), 
        ADVANCED_TOOLTIPS("ADVANCED_TOOLTIPS", 105, "of.options.ADVANCED_TOOLTIPS", false, false), 
        CUSTOM_FONTS("CUSTOM_FONTS", 85, "of.options.CUSTOM_FONTS", false, false), 
        CUSTOM_ENTITY_MODELS("CUSTOM_ENTITY_MODELS", 104, "of.options.CUSTOM_ENTITY_MODELS", false, false), 
        FIREWORK_PARTICLES("FIREWORK_PARTICLES", 76, "of.options.FIREWORK_PARTICLES", false, false), 
        SWAMP_COLORS("SWAMP_COLORS", 82, "of.options.SWAMP_COLORS", false, false), 
        VIGNETTE("VIGNETTE", 65, "of.options.VIGNETTE", false, false), 
        REDUCED_DEBUG_INFO("REDUCED_DEBUG_INFO", 31, "options.reducedDebugInfo", false, true), 
        DRIPPING_WATER_LAVA("DRIPPING_WATER_LAVA", 78, "of.options.DRIPPING_WATER_LAVA", false, false), 
        FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "options.framerateLimit", true, false, 0.0f, 260.0f, 5.0f), 
        ENABLE_VSYNC("ENABLE_VSYNC", 22, "options.vsync", false, true), 
        STARS("STARS", 63, "of.options.STARS", false, false), 
        FULLSCREEN_MODE("FULLSCREEN_MODE", 80, "of.options.FULLSCREEN_MODE", true, false, 0.0f, (float)Config.getDisplayModes().length, 1.0f), 
        AF_LEVEL("AF_LEVEL", 91, "of.options.AF_LEVEL", true, false, 1.0f, 16.0f, 1.0f), 
        FAST_MATH("FAST_MATH", 98, "of.options.FAST_MATH", false, false), 
        AO_LEVEL("AO_LEVEL", 52, "of.options.AO_LEVEL", true, false), 
        TOUCHSCREEN("TOUCHSCREEN", 24, "options.touchscreen", false, true), 
        CLEAR_WATER("CLEAR_WATER", 69, "of.options.CLEAR_WATER", false, false), 
        RANDOM_MOBS("RANDOM_MOBS", 83, "of.options.RANDOM_MOBS", false, false), 
        CUSTOM_SKY("CUSTOM_SKY", 97, "of.options.CUSTOM_SKY", false, false);
        
        private final /* synthetic */ float valueStep;
        
        NARRATOR("NARRATOR", 39, "options.narrator", false, false), 
        CLOUD_HEIGHT("CLOUD_HEIGHT", 45, "of.options.CLOUD_HEIGHT", true, false), 
        AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 12, "options.ao", false, false), 
        FAST_RENDER("FAST_RENDER", 99, "of.options.FAST_RENDER", false, false);
        
        private /* synthetic */ float valueMin;
        
        RAIN("RAIN", 47, "of.options.RAIN", false, false), 
        CHAT_WIDTH("CHAT_WIDTH", 26, "options.chat.width", true, false), 
        SHOW_FPS("SHOW_FPS", 54, "of.options.SHOW_FPS", false, false), 
        MAIN_HAND("MAIN_HAND", 33, "options.mainHand", false, false), 
        RENDER_DISTANCE("RENDER_DISTANCE", 5, "options.renderDistance", true, false, 2.0f, 16.0f, 1.0f);
        
        private final /* synthetic */ boolean enumBoolean;
        
        FBO_ENABLE("FBO_ENABLE", 9, "options.fboEnable", false, true), 
        CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 28, "options.chat.height.unfocused", true, false), 
        ANIMATED_PORTAL("ANIMATED_PORTAL", 51, "of.options.ANIMATED_PORTAL", false, false), 
        VOID_PARTICLES("VOID_PARTICLES", 71, "of.options.VOID_PARTICLES", false, false), 
        SHOW_SUBTITLES("SHOW_SUBTITLES", 36, "options.showSubtitles", false, true), 
        AA_LEVEL("AA_LEVEL", 90, "of.options.AA_LEVEL", true, false, 0.0f, 16.0f, 1.0f), 
        ANIMATED_FIRE("ANIMATED_FIRE", 50, "of.options.ANIMATED_FIRE", false, false), 
        FOG_START("FOG_START", 41, "of.options.FOG_START", false, false), 
        LAZY_CHUNK_LOADING("LAZY_CHUNK_LOADING", 96, "of.options.LAZY_CHUNK_LOADING", false, false), 
        WATER_PARTICLES("WATER_PARTICLES", 72, "of.options.WATER_PARTICLES", false, false), 
        SMOOTH_BIOMES("SMOOTH_BIOMES", 84, "of.options.SMOOTH_BIOMES", false, false), 
        AUTO_JUMP("AUTO_JUMP", 38, "options.autoJump", false, true), 
        ALTERNATE_BLOCKS("ALTERNATE_BLOCKS", 103, "of.options.ALTERNATE_BLOCKS", false, false), 
        LAGOMETER("LAGOMETER", 53, "of.options.LAGOMETER", false, false), 
        ANAGLYPH("ANAGLYPH", 7, "options.anaglyph", false, true), 
        GAMMA("GAMMA", 3, "options.gamma", true, false), 
        CHAT_SCALE("CHAT_SCALE", 25, "options.chat.scale", true, false), 
        SATURATION("SATURATION", 4, "options.saturation", true, false), 
        FOV("FOV", 2, "options.fov", true, false, 30.0f, 110.0f, 1.0f), 
        CHAT_COLOR("CHAT_COLOR", 16, "options.chat.color", false, true), 
        CHAT_LINKS("CHAT_LINKS", 17, "options.chat.links", false, true), 
        SENSITIVITY("SENSITIVITY", 1, "options.sensitivity", true, false), 
        GRAPHICS("GRAPHICS", 11, "options.graphics", false, false), 
        AUTOSAVE_TICKS("AUTOSAVE_TICKS", 55, "of.options.AUTOSAVE_TICKS", false, false), 
        CUSTOM_ITEMS("CUSTOM_ITEMS", 89, "of.options.CUSTOM_ITEMS", false, false), 
        BETTER_SNOW("BETTER_SNOW", 79, "of.options.BETTER_SNOW", false, false);
        
        private final /* synthetic */ String enumString;
        
        ATTACK_INDICATOR("ATTACK_INDICATOR", 34, "options.attackIndicator", false, false), 
        RAIN_SPLASH("RAIN_SPLASH", 73, "of.options.RAIN_SPLASH", false, false), 
        REALMS_NOTIFICATIONS("REALMS_NOTIFICATIONS", 37, "options.realmsNotifications", false, true), 
        CUSTOM_COLORS("CUSTOM_COLORS", 86, "of.options.CUSTOM_COLORS", false, false), 
        PORTAL_PARTICLES("PORTAL_PARTICLES", 74, "of.options.PORTAL_PARTICLES", false, false), 
        WEATHER("WEATHER", 61, "of.options.WEATHER", false, false), 
        CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 19, "options.chat.links.prompt", false, true), 
        USE_FULLSCREEN("USE_FULLSCREEN", 21, "options.fullscreen", false, true), 
        HELD_ITEM_TOOLTIPS("HELD_ITEM_TOOLTIPS", 94, "of.options.HELD_ITEM_TOOLTIPS", false, false), 
        INVERT_MOUSE("INVERT_MOUSE", 0, "options.invertMouse", false, true), 
        ANIMATED_TERRAIN("ANIMATED_TERRAIN", 81, "of.options.ANIMATED_TERRAIN", false, false), 
        SUN_MOON("SUN_MOON", 64, "of.options.SUN_MOON", false, false), 
        RENDER_CLOUDS("RENDER_CLOUDS", 10, "options.renderClouds", false, false), 
        ANIMATED_EXPLOSION("ANIMATED_EXPLOSION", 58, "of.options.ANIMATED_EXPLOSION", false, false), 
        CHAT_VISIBILITY("CHAT_VISIBILITY", 15, "options.chat.visibility", false, false), 
        TREES("TREES", 46, "of.options.TREES", false, false), 
        FORCE_UNICODE_FONT("FORCE_UNICODE_FONT", 30, "options.forceUnicodeFont", false, true), 
        CLOUDS("CLOUDS", 44, "of.options.CLOUDS", false, false), 
        ANIMATED_TEXTURES("ANIMATED_TEXTURES", 92, "of.options.ANIMATED_TEXTURES", false, false), 
        MIPMAP_TYPE("MIPMAP_TYPE", 42, "of.options.MIPMAP_TYPE", true, false, 0.0f, 3.0f, 1.0f), 
        CHAT_OPACITY("CHAT_OPACITY", 18, "options.chat.opacity", true, false), 
        CUSTOM_GUIS("CUSTOM_GUIS", 107, "of.options.CUSTOM_GUIS", false, false), 
        SMOOTH_WORLD("SMOOTH_WORLD", 70, "of.options.SMOOTH_WORLD", false, false), 
        MIPMAP_LEVELS("MIPMAP_LEVELS", 29, "options.mipmapLevels", true, false, 0.0f, 4.0f, 1.0f), 
        VIEW_BOBBING("VIEW_BOBBING", 6, "options.viewBobbing", false, true), 
        TIME("TIME", 68, "of.options.TIME", false, false), 
        TRANSLUCENT_BLOCKS("TRANSLUCENT_BLOCKS", 100, "of.options.TRANSLUCENT_BLOCKS", false, false), 
        POTION_PARTICLES("POTION_PARTICLES", 75, "of.options.POTION_PARTICLES", false, false), 
        CHUNK_UPDATES("CHUNK_UPDATES", 66, "of.options.CHUNK_UPDATES", false, false), 
        PARTICLES("PARTICLES", 14, "options.particles", false, false), 
        DYNAMIC_FOV("DYNAMIC_FOV", 101, "of.options.DYNAMIC_FOV", false, false), 
        ANIMATED_REDSTONE("ANIMATED_REDSTONE", 57, "of.options.ANIMATED_REDSTONE", false, false), 
        SMOOTH_FPS("SMOOTH_FPS", 43, "of.options.SMOOTH_FPS", false, false), 
        GUI_SCALE("GUI_SCALE", 13, "options.guiScale", false, false);
        
        private final /* synthetic */ boolean enumFloat;
        
        ANIMATED_LAVA("ANIMATED_LAVA", 49, "of.options.ANIMATED_LAVA", false, false), 
        ANIMATED_WATER("ANIMATED_WATER", 48, "of.options.ANIMATED_WATER", false, false);
        
        private float snapToStep(float llllllllllllllIIIlIIIllIlIllIIlI) {
            if (this.valueStep > 0.0f) {
                llllllllllllllIIIlIIIllIlIllIIlI = this.valueStep * Math.round((float)(llllllllllllllIIIlIIIllIlIllIIlI / this.valueStep));
            }
            return (float)llllllllllllllIIIlIIIllIlIllIIlI;
        }
        
        public boolean getEnumBoolean() {
            return this.enumBoolean;
        }
        
        private Options(final String llllllllllllllIIIlIIIllIllllllll, final int llllllllllllllIIIlIIIllIlllllllI, final String llllllllllllllIIIlIIIllIllllllIl, final boolean llllllllllllllIIIlIIIlllIIIIIIlI, final boolean llllllllllllllIIIlIIIllIlllllIll) {
            this(llllllllllllllIIIlIIIllIllllllll, llllllllllllllIIIlIIIllIlllllllI, llllllllllllllIIIlIIIllIllllllIl, llllllllllllllIIIlIIIlllIIIIIIlI, llllllllllllllIIIlIIIllIlllllIll, 0.0f, 1.0f, 0.0f);
        }
        
        public static Options getEnumOptions(final int llllllllllllllIIIlIIIlllIIIIllll) {
            Exception llllllllllllllIIIlIIIlllIIIIlIll;
            for (short llllllllllllllIIIlIIIlllIIIIllII = (short)((Options[])(Object)(llllllllllllllIIIlIIIlllIIIIlIll = (Exception)(Object)values())).length, llllllllllllllIIIlIIIlllIIIIllIl = 0; llllllllllllllIIIlIIIlllIIIIllIl < llllllllllllllIIIlIIIlllIIIIllII; ++llllllllllllllIIIlIIIlllIIIIllIl) {
                final Options llllllllllllllIIIlIIIlllIIIlIIII = llllllllllllllIIIlIIIlllIIIIlIll[llllllllllllllIIIlIIIlllIIIIllIl];
                if (llllllllllllllIIIlIIIlllIIIlIIII.returnEnumOrdinal() == llllllllllllllIIIlIIIlllIIIIllll) {
                    return llllllllllllllIIIlIIIlllIIIlIIII;
                }
            }
            return null;
        }
        
        public float denormalizeValue(final float llllllllllllllIIIlIIIllIlIlllllI) {
            return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.clamp(llllllllllllllIIIlIIIllIlIlllllI, 0.0f, 1.0f));
        }
        
        public float snapToStepClamp(float llllllllllllllIIIlIIIllIlIlllIII) {
            llllllllllllllIIIlIIIllIlIlllIII = (this.snapToStep((float)(llllllllllllllIIIlIIIllIlIlllIII ? 1 : 0)) != 0.0f);
            return MathHelper.clamp((float)(llllllllllllllIIIlIIIllIlIlllIII ? 1 : 0), this.valueMin, this.valueMax);
        }
        
        public boolean getEnumFloat() {
            return this.enumFloat;
        }
        
        public float getValueMax() {
            return this.valueMax;
        }
        
        public int returnEnumOrdinal() {
            return this.ordinal();
        }
        
        public float normalizeValue(final float llllllllllllllIIIlIIIllIllIIIlII) {
            return MathHelper.clamp((this.snapToStepClamp(llllllllllllllIIIlIIIllIllIIIlII) - this.valueMin) / (this.valueMax - this.valueMin), 0.0f, 1.0f);
        }
        
        private Options(final String llllllllllllllIIIlIIIllIlllIlIIl, final int llllllllllllllIIIlIIIllIlllIlIII, final String llllllllllllllIIIlIIIllIllllIIII, final boolean llllllllllllllIIIlIIIllIlllIIllI, final boolean llllllllllllllIIIlIIIllIlllIIlIl, final float llllllllllllllIIIlIIIllIlllIIlII, final float llllllllllllllIIIlIIIllIlllIIIll, final float llllllllllllllIIIlIIIllIlllIlIll) {
            this.enumString = llllllllllllllIIIlIIIllIllllIIII;
            this.enumFloat = llllllllllllllIIIlIIIllIlllIIllI;
            this.enumBoolean = llllllllllllllIIIlIIIllIlllIIlIl;
            this.valueMin = llllllllllllllIIIlIIIllIlllIIlII;
            this.valueMax = llllllllllllllIIIlIIIllIlllIIIll;
            this.valueStep = llllllllllllllIIIlIIIllIlllIlIll;
        }
        
        public String getEnumString() {
            return this.enumString;
        }
        
        public float getValueMin() {
            return this.valueMin;
        }
        
        public void setValueMax(final float llllllllllllllIIIlIIIllIllIIlIlI) {
            this.valueMax = llllllllllllllIIIlIIIllIllIIlIlI;
        }
    }
}
