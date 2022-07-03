package optifine;

import java.lang.reflect.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraftforge.common.property.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import javax.vecmath.*;
import net.minecraft.item.*;
import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.block.model.*;
import java.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.client.multiplayer.*;
import it.unimi.dsi.fastutil.longs.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.tileentity.*;

public class Reflector
{
    public static /* synthetic */ ReflectorMethod ForgeKeyBinding_setKeyModifierAndCode;
    public static /* synthetic */ ReflectorClass ModelWitch;
    public static /* synthetic */ ReflectorField ModelWitch_hat;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getCloudRenderer;
    private static /* synthetic */ boolean logVanilla;
    public static /* synthetic */ ReflectorClass GuiModList;
    public static /* synthetic */ ReflectorClass TileEntityBannerRenderer;
    public static /* synthetic */ ReflectorClass ForgeEntity;
    public static /* synthetic */ ReflectorMethod EntityViewRenderEvent_CameraSetup_getYaw;
    public static /* synthetic */ ReflectorClass MinecraftForgeClient;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_putQuadColor;
    public static /* synthetic */ ReflectorConstructor GuiModList_Constructor;
    public static /* synthetic */ ReflectorField ForgeItem_delegate;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_applyUVLock;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Pre;
    public static /* synthetic */ ReflectorMethod ForgeBiome_getWaterColorMultiplier;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingDeath;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getFOVModifier;
    public static /* synthetic */ ReflectorClass ScreenshotEvent;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getLightmapColors;
    public static /* synthetic */ ReflectorMethod ForgeBlock_canCreatureSpawn;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getFogColor;
    public static /* synthetic */ ReflectorMethod BlamingTransformer_onCrash;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_handleCameraTransforms;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingJump;
    public static /* synthetic */ ReflectorMethod ForgeItem_shouldCauseReequipAnimation;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getFogDensity;
    public static /* synthetic */ ReflectorField RenderMinecart_modelMinecart;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_isLoading;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getLightOpacity;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isBedFoot;
    public static /* synthetic */ ReflectorField RenderEnderCrystal_modelEnderCrystalNoBase;
    public static /* synthetic */ ReflectorField ModelGhast_tentacles;
    public static /* synthetic */ ReflectorMethod ForgePotion_renderHUDEffect;
    public static /* synthetic */ ReflectorClass ForgeItemOverrideList;
    public static /* synthetic */ ReflectorClass TileEntityEnchantmentTableRenderer;
    public static /* synthetic */ ReflectorField MinecraftForge_EVENT_BUS;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getOffsetFOV;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getMatrix;
    public static /* synthetic */ ReflectorClass CoreModManager;
    public static /* synthetic */ ReflectorMethod ForgeItem_isShield;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_canEntityDespawn;
    public static /* synthetic */ ReflectorClass DrawScreenEvent_Post;
    public static /* synthetic */ ReflectorClass ModelBat;
    public static /* synthetic */ ReflectorMethod ForgeBlock_hasTileEntity;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_shouldCauseReequipAnimation;
    public static /* synthetic */ ReflectorField TileEntityBannerRenderer_bannerModel;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onTextureStitchedPost;
    public static /* synthetic */ ReflectorClass ForgeModelBlockDefinition;
    public static /* synthetic */ ReflectorMethod LightUtil_renderQuadColor;
    public static /* synthetic */ ReflectorMethod ForgeWorld_getPerWorldStorage;
    public static /* synthetic */ ReflectorClass ModelWither;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_renderFirstPersonHand;
    public static /* synthetic */ ReflectorMethod MinecraftForgeClient_getRenderPass;
    public static /* synthetic */ ReflectorFields ModelEnderCrystal_ModelRenderers;
    public static /* synthetic */ ReflectorClass Launch;
    public static /* synthetic */ ReflectorMethod EventBus_post;
    public static /* synthetic */ ReflectorMethod ForgeVertexFormatElementEnumUseage_preDraw;
    public static /* synthetic */ ReflectorFields ModelEvokerFangs_ModelRenderers;
    public static /* synthetic */ ReflectorClass RenderMinecart;
    public static /* synthetic */ ReflectorField ModelVex_leftWing;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingHurt;
    public static /* synthetic */ ReflectorField RenderWitherSkull_model;
    public static /* synthetic */ ReflectorClass FMLCommonHandler;
    public static /* synthetic */ ReflectorField RenderShulkerBullet_model;
    public static /* synthetic */ ReflectorClass KeyModifier;
    public static /* synthetic */ ReflectorMethod ScreenshotEvent_getCancelMessage;
    public static /* synthetic */ ReflectorMethod CoreModManager_onCrash;
    public static /* synthetic */ ReflectorClass RenderEvokerFangs;
    public static /* synthetic */ ReflectorMethod EntityViewRenderEvent_FogColors_getGreen;
    public static /* synthetic */ ReflectorMethod ForgeBlock_doesSideBlockRendering;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_fillNormal;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_renderFireOverlay;
    public static /* synthetic */ ReflectorMethod IExtendedBlockState_getClean;
    public static /* synthetic */ ReflectorMethod ScreenshotEvent_getResultMessage;
    public static /* synthetic */ ReflectorClass ModelWolf;
    public static /* synthetic */ ReflectorClass ModelEvokerFangs;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Post;
    public static /* synthetic */ ReflectorClass ChunkWatchEvent_UnWatch;
    public static /* synthetic */ ReflectorClass RenderBoat;
    public static /* synthetic */ ReflectorClass ForgeBiome;
    public static /* synthetic */ ReflectorClass GuiMainMenu;
    public static /* synthetic */ ReflectorField ForgeModContainer_forgeLightPipelineEnabled;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_enhanceCrashReport;
    public static /* synthetic */ ReflectorClass RenderEnderCrystal;
    public static /* synthetic */ ReflectorClass KeyConflictContext;
    public static /* synthetic */ ReflectorConstructor EntityViewRenderEvent_CameraSetup_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_loadEntityShader;
    public static /* synthetic */ ReflectorClass ModelSilverfish;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_dispatchRenderLast;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_instance;
    public static /* synthetic */ ReflectorClass ForgePotionEffect;
    public static /* synthetic */ ReflectorClass ForgeHooksClient;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Specials_Post_Constructor;
    public static /* synthetic */ ReflectorClass FMLClientHandler;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onDrawBlockHighlight;
    public static /* synthetic */ ReflectorClass IRenderHandler;
    public static /* synthetic */ ReflectorField RenderEnderCrystal_modelEnderCrystal;
    public static /* synthetic */ ReflectorField ModelGuardian_body;
    public static /* synthetic */ ReflectorClass EntityViewRenderEvent_CameraSetup;
    public static /* synthetic */ ReflectorMethod ForgeItem_getRGBDurabilityForDisplay;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onTextureStitchedPre;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getSkyRenderer;
    public static /* synthetic */ ReflectorClass Minecraft;
    public static /* synthetic */ ReflectorField ModelLoaderRegistry_textures;
    public static /* synthetic */ ReflectorClass ForgeModContainer;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Specials_Pre_Constructor;
    public static /* synthetic */ ReflectorClass ForgeVertexFormatElementEnumUseage;
    public static /* synthetic */ ReflectorField Minecraft_actionKeyF3;
    public static /* synthetic */ ReflectorClass BlamingTransformer;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onFogRender;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Post_Constructor;
    public static /* synthetic */ ReflectorConstructor RenderLivingEvent_Pre_Constructor;
    public static /* synthetic */ ReflectorField TileEntitySkullRenderer_dragonHead;
    public static /* synthetic */ ReflectorClass ItemModelMesherForge;
    public static /* synthetic */ ReflectorClass EventBus;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isAir;
    public static /* synthetic */ ReflectorConstructor DrawScreenEvent_Post_Constructor;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isBed;
    public static /* synthetic */ ReflectorField LightUtil_tessellator;
    public static /* synthetic */ ReflectorField ModelVex_rightWing;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getExtendedState;
    public static /* synthetic */ ReflectorMethod ScreenshotEvent_getScreenshotFile;
    public static /* synthetic */ ReflectorMethod ForgeItemArmor_hasOverlay;
    public static /* synthetic */ ReflectorField ForgeEntity_captureDrops;
    public static /* synthetic */ ReflectorClass DimensionManager;
    public static /* synthetic */ ReflectorField TileEntityEnchantmentTableRenderer_modelBook;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingUpdate;
    public static /* synthetic */ ReflectorClass SplashScreen;
    public static /* synthetic */ ReflectorField LightUtil_itemConsumer;
    public static /* synthetic */ ReflectorField ModelWither_heads;
    public static /* synthetic */ ReflectorClass WorldEvent_Load;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_renderWaterOverlay;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_drawScreen;
    public static /* synthetic */ ReflectorMethod DimensionManager_getStaticDimensionIDs;
    public static /* synthetic */ ReflectorField TileEntityShulkerBoxRenderer_model;
    public static /* synthetic */ ReflectorClass RenderBlockOverlayEvent_OverlayType;
    public static /* synthetic */ ReflectorMethod LightUtil_putBakedQuad;
    public static /* synthetic */ ReflectorClass ModelBlaze;
    public static /* synthetic */ ReflectorMethod ForgeItem_onEntitySwing;
    public static /* synthetic */ ReflectorField ModelSquid_tentacles;
    public static /* synthetic */ ReflectorMethod ForgeKeyBinding_setKeyConflictContext;
    public static /* synthetic */ ReflectorField ModelGuardian_tail;
    public static /* synthetic */ ReflectorClass ForgeEventFactory;
    public static /* synthetic */ ReflectorMethod ForgeVertexFormatElementEnumUseage_postDraw;
    public static /* synthetic */ ReflectorFields ModelOcelot_ModelRenderers;
    public static /* synthetic */ ReflectorField ModelEnderMite_bodyParts;
    public static /* synthetic */ ReflectorMethod RenderingRegistry_loadEntityRenderers;
    public static /* synthetic */ ReflectorMethod ForgePotionEffect_isCurativeItem;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingDrops;
    public static /* synthetic */ ReflectorMethod ForgeBlock_isSideSolid;
    public static /* synthetic */ ReflectorField OptiFineClassTransformer_instance;
    public static /* synthetic */ ReflectorField Event_Result_DEFAULT;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getLightValue;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getArmorModel;
    public static /* synthetic */ ReflectorClass RenderItemInFrameEvent;
    public static /* synthetic */ ReflectorField ModelGuardian_eye;
    public static /* synthetic */ ReflectorClass Event_Result;
    public static /* synthetic */ ReflectorField TileEntityChestRenderer_simpleChest;
    public static /* synthetic */ ReflectorMethod ForgeItem_getDurabilityForDisplay;
    public static /* synthetic */ ReflectorConstructor ExtendedBlockState_Constructor;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_callFuture;
    public static /* synthetic */ ReflectorClass NotificationModUpdateScreen;
    public static /* synthetic */ ReflectorClass TileEntityChestRenderer;
    public static /* synthetic */ ReflectorField ModelGhast_body;
    public static /* synthetic */ ReflectorClass RenderShulkerBullet;
    public static /* synthetic */ ReflectorField ModelBlaze_blazeSticks;
    public static /* synthetic */ ReflectorConstructor DrawScreenEvent_Pre_Constructor;
    public static /* synthetic */ ReflectorMethod EntityViewRenderEvent_CameraSetup_getRoll;
    public static /* synthetic */ ReflectorMethod ForgePotion_shouldRenderHUD;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_shouldRenderInPass;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_trackMissingTexture;
    public static /* synthetic */ ReflectorMethod ForgeItem_showDurabilityBar;
    public static /* synthetic */ ReflectorField GuiMainMenu_splashText;
    public static /* synthetic */ ReflectorClass LightUtil;
    public static /* synthetic */ ReflectorClass TileEntityEnderChestRenderer;
    public static /* synthetic */ ReflectorClass ModelHumanoidHead;
    public static /* synthetic */ ReflectorField RenderBoat_modelBoat;
    public static /* synthetic */ ReflectorClass ForgeBlock;
    public static /* synthetic */ ReflectorClass ModelRabbit;
    public static /* synthetic */ ReflectorMethod NotificationModUpdateScreen_init;
    public static /* synthetic */ ReflectorField ModelMagmaCube_segments;
    public static /* synthetic */ ReflectorClass ModelDragon;
    public static /* synthetic */ ReflectorMethod ModelLoader_getInventoryVariant;
    public static /* synthetic */ ReflectorMethod ForgeWorld_initCapabilities;
    public static /* synthetic */ ReflectorMethod ModelLoader_onRegisterItems;
    public static /* synthetic */ ReflectorMethod ForgeWorldProvider_getWeatherRenderer;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Specials_Pre;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getBedDirection;
    public static /* synthetic */ ReflectorField RenderEvokerFangs_model;
    public static /* synthetic */ ReflectorField ModelWither_bodyParts;
    public static /* synthetic */ ReflectorClass ExtendedBlockState;
    public static /* synthetic */ ReflectorField RenderBlockOverlayEvent_OverlayType_BLOCK;
    public static /* synthetic */ ReflectorMethod EntityViewRenderEvent_FogColors_getBlue;
    public static /* synthetic */ ReflectorMethod EntityViewRenderEvent_CameraSetup_getPitch;
    public static /* synthetic */ ReflectorConstructor RenderItemInFrameEvent_Constructor;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_getBrandings;
    public static /* synthetic */ ReflectorClass ForgeItemArmor;
    public static /* synthetic */ ReflectorMethod DimensionManager_createProviderFor;
    public static /* synthetic */ ReflectorMethod OptiFineClassTransformer_getOptiFineResource;
    public static /* synthetic */ ReflectorClass ModelOcelot;
    public static /* synthetic */ ReflectorField TileEntitySignRenderer_model;
    public static /* synthetic */ ReflectorMethod ForgeBlock_addDestroyEffects;
    public static /* synthetic */ ReflectorClass ModelEnderCrystal;
    public static /* synthetic */ ReflectorMethod ForgeBlock_canRenderInLayer;
    public static /* synthetic */ ReflectorClass TileEntityShulkerBoxRenderer;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingSetAttackTarget;
    public static /* synthetic */ ReflectorFields ModelSlime_ModelRenderers;
    public static /* synthetic */ ReflectorMethod Event_isCanceled;
    public static /* synthetic */ ReflectorMethod KeyModifier_valueFromString;
    public static /* synthetic */ ReflectorClass TileEntitySkullRenderer;
    public static /* synthetic */ ReflectorMethod IRenderHandler_render;
    public static /* synthetic */ ReflectorClass MinecraftForge;
    public static /* synthetic */ ReflectorClass ForgeHooks;
    public static /* synthetic */ ReflectorMethod ForgeEntity_shouldRenderInPass;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_instance;
    public static /* synthetic */ ReflectorClass LegacyV2Adapter;
    public static /* synthetic */ ReflectorField ModelSilverfish_bodyParts;
    public static /* synthetic */ ReflectorClass IModel;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_onScreenshot;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_handleServerAboutToStart;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingAttack;
    public static /* synthetic */ ReflectorClass RenderLeashKnot;
    public static /* synthetic */ ReflectorField ChunkProviderClient_chunkMapping;
    public static /* synthetic */ ReflectorField Launch_blackboard;
    public static /* synthetic */ ReflectorMethod IModel_getTextures;
    public static /* synthetic */ ReflectorClass ModelLoader;
    public static /* synthetic */ ReflectorField ModelBlaze_blazeHead;
    public static /* synthetic */ ReflectorMethod EntityViewRenderEvent_FogColors_getRed;
    public static /* synthetic */ ReflectorClass Event;
    public static /* synthetic */ ReflectorField TileEntitySkullRenderer_humanoidHead;
    public static /* synthetic */ ReflectorClass ModelGhast;
    public static /* synthetic */ ReflectorField ModelHumanoidHead_head;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_setRenderPass;
    public static /* synthetic */ ReflectorMethod ForgeHooks_onLivingFall;
    public static /* synthetic */ ReflectorField KeyConflictContext_IN_GAME;
    public static /* synthetic */ ReflectorClass RenderLivingEvent_Specials_Post;
    public static /* synthetic */ ReflectorField ModelDragonHead_jaw;
    public static /* synthetic */ ReflectorMethod MinecraftForgeClient_onRebuildChunk;
    public static /* synthetic */ ReflectorField ForgeEntity_capturedDrops;
    public static /* synthetic */ ReflectorClass ChunkProviderClient;
    public static /* synthetic */ ReflectorField Event_Result_ALLOW;
    public static /* synthetic */ ReflectorMethod ForgeBlock_getSoundType;
    public static /* synthetic */ ReflectorMethod FMLClientHandler_trackBrokenTexture;
    public static /* synthetic */ ReflectorClass ForgeItem;
    public static /* synthetic */ ReflectorField RenderLeashKnot_leashKnotModel;
    public static /* synthetic */ ReflectorMethod ForgeEventFactory_renderBlockOverlay;
    public static /* synthetic */ ReflectorClass ModelSquid;
    public static /* synthetic */ ReflectorField ModelGuardian_spines;
    public static /* synthetic */ ReflectorFields ModelBat_ModelRenderers;
    public static /* synthetic */ ReflectorClass ModelVex;
    private static /* synthetic */ boolean logForge;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_getRenderBoundingBox;
    public static /* synthetic */ ReflectorClass ModelGuardian;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_orientBedCamera;
    public static /* synthetic */ ReflectorConstructor EntityViewRenderEvent_RenderFogEvent_Constructor;
    public static /* synthetic */ ReflectorClass DrawScreenEvent_Pre;
    public static /* synthetic */ ReflectorField TileEntityEnderChestRenderer_modelChest;
    public static /* synthetic */ ReflectorClass ModelEnderMite;
    public static /* synthetic */ ReflectorMethod ForgeBlock_addHitEffects;
    public static /* synthetic */ ReflectorClass ForgeWorld;
    public static /* synthetic */ ReflectorMethod ForgeItemOverrideList_handleItemState;
    public static /* synthetic */ ReflectorMethod ForgeWorld_countEntities;
    public static /* synthetic */ ReflectorField LegacyV2Adapter_pack;
    public static /* synthetic */ ReflectorClass EntityViewRenderEvent_FogColors;
    public static /* synthetic */ ReflectorField ModelLoader_stateModels;
    public static /* synthetic */ ReflectorField Minecraft_defaultResourcePack;
    public static /* synthetic */ ReflectorFields ModelDragon_ModelRenderers;
    public static /* synthetic */ ReflectorMethod ModelLoader_VanillaLoader_loadModel;
    public static /* synthetic */ ReflectorMethod ForgeEntity_canRiderInteract;
    public static /* synthetic */ ReflectorField ModelWolf_mane;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_canRenderBreaking;
    public static /* synthetic */ ReflectorClass Attributes;
    public static /* synthetic */ ReflectorField TileEntityChestRenderer_largeChest;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_applyTransform;
    public static /* synthetic */ ReflectorField ModelWitch_mole;
    public static /* synthetic */ ReflectorMethod FMLCommonHandler_handleServerStarting;
    public static /* synthetic */ ReflectorFields ModelRabbit_renderers;
    public static /* synthetic */ ReflectorClass EntityViewRenderEvent_RenderFogEvent;
    public static /* synthetic */ ReflectorConstructor ItemModelMesherForge_Constructor;
    public static /* synthetic */ ReflectorClass ForgeTileEntity;
    public static /* synthetic */ ReflectorClass ForgeIBlockProperties;
    public static /* synthetic */ ReflectorConstructor EntityViewRenderEvent_FogColors_Constructor;
    public static /* synthetic */ ReflectorClass ForgePotion;
    public static /* synthetic */ ReflectorClass ForgeWorldProvider;
    public static /* synthetic */ ReflectorField ModelDragonHead_head;
    public static /* synthetic */ ReflectorClass BetterFoliageClient;
    public static /* synthetic */ ReflectorClass ForgeKeyBinding;
    public static /* synthetic */ ReflectorField TileEntitySkullRenderer_skeletonHead;
    public static /* synthetic */ ReflectorMethod ForgeTileEntity_hasFastRenderer;
    public static /* synthetic */ ReflectorClass TileEntitySignRenderer;
    public static /* synthetic */ ReflectorField ModelSquid_body;
    public static /* synthetic */ ReflectorField ModelWolf_tail;
    public static /* synthetic */ ReflectorField Event_Result_DENY;
    public static /* synthetic */ ReflectorConstructor WorldEvent_Load_Constructor;
    public static /* synthetic */ ReflectorField ModelSilverfish_wingParts;
    public static /* synthetic */ ReflectorClass ModelMagmaCube;
    public static /* synthetic */ ReflectorField KeyModifier_NONE;
    public static /* synthetic */ ReflectorClass ForgeChunkCache;
    public static /* synthetic */ ReflectorClass IExtendedBlockState;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_renderSpecificFirstPersonHand;
    public static /* synthetic */ ReflectorMethod ForgeIBlockProperties_getLightValue2;
    public static /* synthetic */ ReflectorClass ModelLoaderRegistry;
    public static /* synthetic */ ReflectorMethod ForgeModelBlockDefinition_parseFromReader2;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_transform;
    public static /* synthetic */ ReflectorMethod ForgeChunkCache_isSideSolid;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_renderMainMenu;
    public static /* synthetic */ ReflectorFields ModelHorse_ModelRenderers;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_getArmorTexture;
    public static /* synthetic */ ReflectorClass ModelDragonHead;
    public static /* synthetic */ ReflectorMethod ForgeEntity_shouldRiderSit;
    public static /* synthetic */ ReflectorMethod ForgeKeyBinding_getKeyModifier;
    public static /* synthetic */ ReflectorClass OptiFineClassTransformer;
    public static /* synthetic */ ReflectorField ModelMagmaCube_core;
    public static /* synthetic */ ReflectorClass RenderingRegistry;
    public static /* synthetic */ ReflectorClass ModelHorse;
    public static /* synthetic */ ReflectorClass ModelSlime;
    public static /* synthetic */ ReflectorConstructor ChunkWatchEvent_UnWatch_Constructor;
    public static /* synthetic */ ReflectorField Attributes_DEFAULT_BAKED_FORMAT;
    public static /* synthetic */ ReflectorMethod ForgeHooksClient_setRenderLayer;
    public static /* synthetic */ ReflectorClass RenderWitherSkull;
    public static /* synthetic */ ReflectorClass ModelLoader_VanillaLoader;
    public static /* synthetic */ ReflectorField ModelLoader_VanillaLoader_INSTANCE;
    
    public static Object getFieldValue(final ReflectorFields lllllllllllllIlllllllIIllIIIIIII, final int lllllllllllllIlllllllIIllIIIIIlI) {
        final ReflectorField lllllllllllllIlllllllIIllIIIIIIl = lllllllllllllIlllllllIIllIIIIIII.getReflectorField(lllllllllllllIlllllllIIllIIIIIlI);
        return (lllllllllllllIlllllllIIllIIIIIIl == null) ? null : getFieldValue(lllllllllllllIlllllllIIllIIIIIIl);
    }
    
    public static boolean callBoolean(final ReflectorMethod lllllllllllllIlllllllIlIIlIIllIl, final Object... lllllllllllllIlllllllIlIIlIIIlll) {
        try {
            final Method lllllllllllllIlllllllIlIIlIIlIll = lllllllllllllIlllllllIlIIlIIllIl.getTargetMethod();
            if (lllllllllllllIlllllllIlIIlIIlIll == null) {
                return false;
            }
            final Boolean lllllllllllllIlllllllIlIIlIIlIlI = (Boolean)lllllllllllllIlllllllIlIIlIIlIll.invoke(null, lllllllllllllIlllllllIlIIlIIIlll);
            return lllllllllllllIlllllllIlIIlIIlIlI;
        }
        catch (Throwable lllllllllllllIlllllllIlIIlIIlIIl) {
            handleException(lllllllllllllIlllllllIlIIlIIlIIl, null, lllllllllllllIlllllllIlIIlIIllIl, lllllllllllllIlllllllIlIIlIIIlll);
            return false;
        }
    }
    
    public static Object newInstance(final ReflectorConstructor lllllllllllllIlllllllIIlIIlIlIIl, final Object... lllllllllllllIlllllllIIlIIlIlIII) {
        final Constructor lllllllllllllIlllllllIIlIIlIllII = lllllllllllllIlllllllIIlIIlIlIIl.getTargetConstructor();
        if (lllllllllllllIlllllllIIlIIlIllII == null) {
            return null;
        }
        try {
            final Object lllllllllllllIlllllllIIlIIlIlIll = lllllllllllllIlllllllIIlIIlIllII.newInstance(lllllllllllllIlllllllIIlIIlIlIII);
            return lllllllllllllIlllllllIIlIIlIlIll;
        }
        catch (Throwable lllllllllllllIlllllllIIlIIlIlIlI) {
            handleException(lllllllllllllIlllllllIIlIIlIlIlI, lllllllllllllIlllllllIIlIIlIlIIl, lllllllllllllIlllllllIIlIIlIlIII);
            return null;
        }
    }
    
    public static boolean matchesTypes(final Class[] lllllllllllllIlllllllIIlIIIllIll, final Class[] lllllllllllllIlllllllIIlIIIlllll) {
        if (lllllllllllllIlllllllIIlIIIllIll.length != lllllllllllllIlllllllIIlIIIlllll.length) {
            return false;
        }
        for (int lllllllllllllIlllllllIIlIIIllllI = 0; lllllllllllllIlllllllIIlIIIllllI < lllllllllllllIlllllllIIlIIIlllll.length; ++lllllllllllllIlllllllIIlIIIllllI) {
            final Class lllllllllllllIlllllllIIlIIIlllIl = lllllllllllllIlllllllIIlIIIllIll[lllllllllllllIlllllllIIlIIIllllI];
            final Class lllllllllllllIlllllllIIlIIIlllII = lllllllllllllIlllllllIIlIIIlllll[lllllllllllllIlllllllIIlIIIllllI];
            if (lllllllllllllIlllllllIIlIIIlllIl != lllllllllllllIlllllllIIlIIIlllII) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean postForgeBusEvent(final Object lllllllllllllIlllllllIIlIIlllIlI) {
        if (lllllllllllllIlllllllIIlIIlllIlI == null) {
            return false;
        }
        final Object lllllllllllllIlllllllIIlIIlllIIl = getFieldValue(Reflector.MinecraftForge_EVENT_BUS);
        if (lllllllllllllIlllllllIIlIIlllIIl == null) {
            return false;
        }
        final Object lllllllllllllIlllllllIIlIIlllIII = call(lllllllllllllIlllllllIIlIIlllIIl, Reflector.EventBus_post, lllllllllllllIlllllllIIlIIlllIlI);
        if (!(lllllllllllllIlllllllIIlIIlllIII instanceof Boolean)) {
            return false;
        }
        final Boolean lllllllllllllIlllllllIIlIIllIlll = (Boolean)lllllllllllllIlllllllIIlIIlllIII;
        return lllllllllllllIlllllllIIlIIllIlll;
    }
    
    public static float callFloat(final Object lllllllllllllIlllllllIIlllIIlIll, final ReflectorMethod lllllllllllllIlllllllIIlllIIlIlI, final Object... lllllllllllllIlllllllIIlllIIllll) {
        try {
            final Method lllllllllllllIlllllllIIlllIIlllI = lllllllllllllIlllllllIIlllIIlIlI.getTargetMethod();
            if (lllllllllllllIlllllllIIlllIIlllI == null) {
                return 0.0f;
            }
            final Float lllllllllllllIlllllllIIlllIIllIl = (Float)lllllllllllllIlllllllIIlllIIlllI.invoke(lllllllllllllIlllllllIIlllIIlIll, lllllllllllllIlllllllIIlllIIllll);
            return lllllllllllllIlllllllIIlllIIllIl;
        }
        catch (Throwable lllllllllllllIlllllllIIlllIIllII) {
            handleException(lllllllllllllIlllllllIIlllIIllII, lllllllllllllIlllllllIIlllIIlIll, lllllllllllllIlllllllIIlllIIlIlI, lllllllllllllIlllllllIIlllIIllll);
            return 0.0f;
        }
    }
    
    private static void handleException(final Throwable lllllllllllllIlllllllIIIlIllllll, final ReflectorConstructor lllllllllllllIlllllllIIIlIlllllI, final Object[] lllllllllllllIlllllllIIIlIlllIlI) {
        if (lllllllllllllIlllllllIIIlIllllll instanceof InvocationTargetException) {
            lllllllllllllIlllllllIIIlIllllll.printStackTrace();
        }
        else {
            if (lllllllllllllIlllllllIIIlIllllll instanceof IllegalArgumentException) {
                Config.warn("*** IllegalArgumentException ***");
                Config.warn(String.valueOf(new StringBuilder("Constructor: ").append(lllllllllllllIlllllllIIIlIlllllI.getTargetConstructor())));
                Config.warn(String.valueOf(new StringBuilder("Parameter classes: ").append(Config.arrayToString(getClasses(lllllllllllllIlllllllIIIlIlllIlI)))));
                Config.warn(String.valueOf(new StringBuilder("Parameters: ").append(Config.arrayToString(lllllllllllllIlllllllIIIlIlllIlI))));
            }
            Config.warn("*** Exception outside of constructor ***");
            Config.warn(String.valueOf(new StringBuilder("Constructor deactivated: ").append(lllllllllllllIlllllllIIIlIlllllI.getTargetConstructor())));
            lllllllllllllIlllllllIIIlIlllllI.deactivate();
            lllllllllllllIlllllllIIIlIllllll.printStackTrace();
        }
    }
    
    public static float getFieldValueFloat(final Object lllllllllllllIlllllllIIlIllIIlll, final ReflectorField lllllllllllllIlllllllIIlIllIlIll, final float lllllllllllllIlllllllIIlIllIlIlI) {
        final Object lllllllllllllIlllllllIIlIllIlIIl = getFieldValue(lllllllllllllIlllllllIIlIllIIlll, lllllllllllllIlllllllIIlIllIlIll);
        if (!(lllllllllllllIlllllllIIlIllIlIIl instanceof Float)) {
            return lllllllllllllIlllllllIIlIllIlIlI;
        }
        final Float lllllllllllllIlllllllIIlIllIlIII = (Float)lllllllllllllIlllllllIIlIllIlIIl;
        return lllllllllllllIlllllllIIlIllIlIII;
    }
    
    private static void dbgCall(final boolean lllllllllllllIlllllllIIlIIIIIllI, final String lllllllllllllIlllllllIIlIIIIIlIl, final ReflectorMethod lllllllllllllIlllllllIIlIIIIllII, final Object[] lllllllllllllIlllllllIIlIIIIlIll, final Object lllllllllllllIlllllllIIlIIIIlIlI) {
        final String lllllllllllllIlllllllIIlIIIIlIIl = lllllllllllllIlllllllIIlIIIIllII.getTargetMethod().getDeclaringClass().getName();
        final String lllllllllllllIlllllllIIlIIIIlIII = lllllllllllllIlllllllIIlIIIIllII.getTargetMethod().getName();
        String lllllllllllllIlllllllIIlIIIIIlll = "";
        if (lllllllllllllIlllllllIIlIIIIIllI) {
            lllllllllllllIlllllllIIlIIIIIlll = " static";
        }
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllllllIIlIIIIIlIl)).append(lllllllllllllIlllllllIIlIIIIIlll).append(" ").append(lllllllllllllIlllllllIIlIIIIlIIl).append(".").append(lllllllllllllIlllllllIIlIIIIlIII).append("(").append(Config.arrayToString(lllllllllllllIlllllllIIlIIIIlIll)).append(") => ").append(lllllllllllllIlllllllIIlIIIIlIlI)));
    }
    
    public static boolean setFieldValue(final ReflectorField lllllllllllllIlllllllIIlIllIIIII, final Object lllllllllllllIlllllllIIlIlIlllIl) {
        return setFieldValue(null, lllllllllllllIlllllllIIlIllIIIII, lllllllllllllIlllllllIIlIlIlllIl);
    }
    
    public static void callVoid(final ReflectorMethod lllllllllllllIlllllllIlIIlIllIII, final Object... lllllllllllllIlllllllIlIIlIlIIll) {
        try {
            final Method lllllllllllllIlllllllIlIIlIlIllI = lllllllllllllIlllllllIlIIlIllIII.getTargetMethod();
            if (lllllllllllllIlllllllIlIIlIlIllI == null) {
                return;
            }
            lllllllllllllIlllllllIlIIlIlIllI.invoke(null, lllllllllllllIlllllllIlIIlIlIIll);
        }
        catch (Throwable lllllllllllllIlllllllIlIIlIlIlIl) {
            handleException(lllllllllllllIlllllllIlIIlIlIlIl, null, lllllllllllllIlllllllIlIIlIllIII, lllllllllllllIlllllllIlIIlIlIIll);
        }
    }
    
    public static void callVoid(final Object lllllllllllllIlllllllIIllllllIlI, final ReflectorMethod lllllllllllllIlllllllIIllllllllI, final Object... lllllllllllllIlllllllIIlllllllIl) {
        try {
            if (lllllllllllllIlllllllIIllllllIlI == null) {
                return;
            }
            final Method lllllllllllllIlllllllIIlllllllII = lllllllllllllIlllllllIIllllllllI.getTargetMethod();
            if (lllllllllllllIlllllllIIlllllllII == null) {
                return;
            }
            lllllllllllllIlllllllIIlllllllII.invoke(lllllllllllllIlllllllIIllllllIlI, lllllllllllllIlllllllIIlllllllIl);
        }
        catch (Throwable lllllllllllllIlllllllIIllllllIll) {
            handleException(lllllllllllllIlllllllIIllllllIll, lllllllllllllIlllllllIIllllllIlI, lllllllllllllIlllllllIIllllllllI, lllllllllllllIlllllllIIlllllllIl);
        }
    }
    
    public static String callString(final Object lllllllllllllIlllllllIIllIlIlIll, final ReflectorMethod lllllllllllllIlllllllIIllIlIlIlI, final Object... lllllllllllllIlllllllIIllIlIlIIl) {
        try {
            final Method lllllllllllllIlllllllIIllIlIlllI = lllllllllllllIlllllllIIllIlIlIlI.getTargetMethod();
            if (lllllllllllllIlllllllIIllIlIlllI == null) {
                return null;
            }
            final String lllllllllllllIlllllllIIllIlIllIl = (String)lllllllllllllIlllllllIIllIlIlllI.invoke(lllllllllllllIlllllllIIllIlIlIll, lllllllllllllIlllllllIIllIlIlIIl);
            return lllllllllllllIlllllllIIllIlIllIl;
        }
        catch (Throwable lllllllllllllIlllllllIIllIlIllII) {
            handleException(lllllllllllllIlllllllIIllIlIllII, lllllllllllllIlllllllIIllIlIlIll, lllllllllllllIlllllllIIllIlIlIlI, lllllllllllllIlllllllIIllIlIlIIl);
            return null;
        }
    }
    
    public static Object call(final ReflectorMethod lllllllllllllIlllllllIlIIIIIllII, final Object... lllllllllllllIlllllllIlIIIIIlIll) {
        try {
            final Method lllllllllllllIlllllllIlIIIIIlIlI = lllllllllllllIlllllllIlIIIIIllII.getTargetMethod();
            if (lllllllllllllIlllllllIlIIIIIlIlI == null) {
                return null;
            }
            final Object lllllllllllllIlllllllIlIIIIIlIIl = lllllllllllllIlllllllIlIIIIIlIlI.invoke(null, lllllllllllllIlllllllIlIIIIIlIll);
            return lllllllllllllIlllllllIlIIIIIlIIl;
        }
        catch (Throwable lllllllllllllIlllllllIlIIIIIlIII) {
            handleException(lllllllllllllIlllllllIlIIIIIlIII, null, lllllllllllllIlllllllIlIIIIIllII, lllllllllllllIlllllllIlIIIIIlIll);
            return null;
        }
    }
    
    public static String callString(final ReflectorMethod lllllllllllllIlllllllIlIIIIlIlII, final Object... lllllllllllllIlllllllIlIIIIllIII) {
        try {
            final Method lllllllllllllIlllllllIlIIIIlIlll = lllllllllllllIlllllllIlIIIIlIlII.getTargetMethod();
            if (lllllllllllllIlllllllIlIIIIlIlll == null) {
                return null;
            }
            final String lllllllllllllIlllllllIlIIIIlIllI = (String)lllllllllllllIlllllllIlIIIIlIlll.invoke(null, lllllllllllllIlllllllIlIIIIllIII);
            return lllllllllllllIlllllllIlIIIIlIllI;
        }
        catch (Throwable lllllllllllllIlllllllIlIIIIlIlIl) {
            handleException(lllllllllllllIlllllllIlIIIIlIlIl, null, lllllllllllllIlllllllIlIIIIlIlII, lllllllllllllIlllllllIlIIIIllIII);
            return null;
        }
    }
    
    private static void dbgCallVoid(final boolean lllllllllllllIlllllllIIIllllIIII, final String lllllllllllllIlllllllIIIllllIllI, final ReflectorMethod lllllllllllllIlllllllIIIllllIlIl, final Object[] lllllllllllllIlllllllIIIllllIlII) {
        final String lllllllllllllIlllllllIIIllllIIll = lllllllllllllIlllllllIIIllllIlIl.getTargetMethod().getDeclaringClass().getName();
        final String lllllllllllllIlllllllIIIllllIIlI = lllllllllllllIlllllllIIIllllIlIl.getTargetMethod().getName();
        String lllllllllllllIlllllllIIIllllIIIl = "";
        if (lllllllllllllIlllllllIIIllllIIII) {
            lllllllllllllIlllllllIIIllllIIIl = " static";
        }
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllllllIIIllllIllI)).append(lllllllllllllIlllllllIIIllllIIIl).append(" ").append(lllllllllllllIlllllllIIIllllIIll).append(".").append(lllllllllllllIlllllllIIIllllIIlI).append("(").append(Config.arrayToString(lllllllllllllIlllllllIIIllllIlII)).append(")")));
    }
    
    public static Object getFieldValue(final ReflectorField lllllllllllllIlllllllIIllIIlIlII) {
        return getFieldValue(null, lllllllllllllIlllllllIIllIIlIlII);
    }
    
    public static int callInt(final ReflectorMethod lllllllllllllIlllllllIlIIlIIIIII, final Object... lllllllllllllIlllllllIlIIIlllIlI) {
        try {
            final Method lllllllllllllIlllllllIlIIIlllllI = lllllllllllllIlllllllIlIIlIIIIII.getTargetMethod();
            if (lllllllllllllIlllllllIlIIIlllllI == null) {
                return 0;
            }
            final Integer lllllllllllllIlllllllIlIIIllllIl = (Integer)lllllllllllllIlllllllIlIIIlllllI.invoke(null, lllllllllllllIlllllllIlIIIlllIlI);
            return lllllllllllllIlllllllIlIIIllllIl;
        }
        catch (Throwable lllllllllllllIlllllllIlIIIllllII) {
            handleException(lllllllllllllIlllllllIlIIIllllII, null, lllllllllllllIlllllllIlIIlIIIIII, lllllllllllllIlllllllIlIIIlllIlI);
            return 0;
        }
    }
    
    public static float callFloat(final ReflectorMethod lllllllllllllIlllllllIlIIIllIIll, final Object... lllllllllllllIlllllllIlIIIlIllIl) {
        try {
            final Method lllllllllllllIlllllllIlIIIllIIIl = lllllllllllllIlllllllIlIIIllIIll.getTargetMethod();
            if (lllllllllllllIlllllllIlIIIllIIIl == null) {
                return 0.0f;
            }
            final Float lllllllllllllIlllllllIlIIIllIIII = (Float)lllllllllllllIlllllllIlIIIllIIIl.invoke(null, lllllllllllllIlllllllIlIIIlIllIl);
            return lllllllllllllIlllllllIlIIIllIIII;
        }
        catch (Throwable lllllllllllllIlllllllIlIIIlIllll) {
            handleException(lllllllllllllIlllllllIlIIIlIllll, null, lllllllllllllIlllllllIlIIIllIIll, lllllllllllllIlllllllIlIIIlIllIl);
            return 0.0f;
        }
    }
    
    public static double callDouble(final Object lllllllllllllIlllllllIIlllIIIIIl, final ReflectorMethod lllllllllllllIlllllllIIlllIIIIII, final Object... lllllllllllllIlllllllIIllIllllll) {
        try {
            final Method lllllllllllllIlllllllIIllIlllllI = lllllllllllllIlllllllIIlllIIIIII.getTargetMethod();
            if (lllllllllllllIlllllllIIllIlllllI == null) {
                return 0.0;
            }
            final Double lllllllllllllIlllllllIIllIllllIl = (Double)lllllllllllllIlllllllIIllIlllllI.invoke(lllllllllllllIlllllllIIlllIIIIIl, lllllllllllllIlllllllIIllIllllll);
            return lllllllllllllIlllllllIIllIllllIl;
        }
        catch (Throwable lllllllllllllIlllllllIIllIllllII) {
            handleException(lllllllllllllIlllllllIIllIllllII, lllllllllllllIlllllllIIlllIIIIIl, lllllllllllllIlllllllIIlllIIIIII, lllllllllllllIlllllllIIllIllllll);
            return 0.0;
        }
    }
    
    private static Object[] getClasses(final Object[] lllllllllllllIlllllllIIIlIllIlIl) {
        if (lllllllllllllIlllllllIIIlIllIlIl == null) {
            return new Class[0];
        }
        final Class[] lllllllllllllIlllllllIIIlIllIlII = new Class[lllllllllllllIlllllllIIIlIllIlIl.length];
        for (int lllllllllllllIlllllllIIIlIllIIll = 0; lllllllllllllIlllllllIIIlIllIIll < lllllllllllllIlllllllIIIlIllIlII.length; ++lllllllllllllIlllllllIIIlIllIIll) {
            final Object lllllllllllllIlllllllIIIlIllIIlI = lllllllllllllIlllllllIIIlIllIlIl[lllllllllllllIlllllllIIIlIllIIll];
            if (lllllllllllllIlllllllIIIlIllIIlI != null) {
                lllllllllllllIlllllllIIIlIllIlII[lllllllllllllIlllllllIIIlIllIIll] = lllllllllllllIlllllllIIIlIllIIlI.getClass();
            }
        }
        return lllllllllllllIlllllllIIIlIllIlII;
    }
    
    public static Object getFieldValue(final Object lllllllllllllIlllllllIIllIIIlIlI, final ReflectorField lllllllllllllIlllllllIIllIIIlIIl) {
        try {
            final Field lllllllllllllIlllllllIIllIIIllIl = lllllllllllllIlllllllIIllIIIlIIl.getTargetField();
            if (lllllllllllllIlllllllIIllIIIllIl == null) {
                return null;
            }
            final Object lllllllllllllIlllllllIIllIIIllII = lllllllllllllIlllllllIIllIIIllIl.get(lllllllllllllIlllllllIIllIIIlIlI);
            return lllllllllllllIlllllllIIllIIIllII;
        }
        catch (Throwable lllllllllllllIlllllllIIllIIIlIll) {
            lllllllllllllIlllllllIIllIIIlIll.printStackTrace();
            return null;
        }
    }
    
    private static ReflectorField[] getReflectorFields(final ReflectorClass lllllllllllllIlllllllIIIlIlIIIll, final Class lllllllllllllIlllllllIIIlIlIIlll, final int lllllllllllllIlllllllIIIlIlIIIIl) {
        final ReflectorField[] lllllllllllllIlllllllIIIlIlIIlIl = new ReflectorField[lllllllllllllIlllllllIIIlIlIIIIl];
        for (int lllllllllllllIlllllllIIIlIlIIlII = 0; lllllllllllllIlllllllIIIlIlIIlII < lllllllllllllIlllllllIIIlIlIIlIl.length; ++lllllllllllllIlllllllIIIlIlIIlII) {
            lllllllllllllIlllllllIIIlIlIIlIl[lllllllllllllIlllllllIIIlIlIIlII] = new ReflectorField(lllllllllllllIlllllllIIIlIlIIIll, lllllllllllllIlllllllIIIlIlIIlll, lllllllllllllIlllllllIIIlIlIIlII);
        }
        return lllllllllllllIlllllllIIIlIlIIlIl;
    }
    
    public static Object call(final Object lllllllllllllIlllllllIIllIlIIIIl, final ReflectorMethod lllllllllllllIlllllllIIllIIllIlI, final Object... lllllllllllllIlllllllIIllIIlllll) {
        try {
            final Method lllllllllllllIlllllllIIllIIllllI = lllllllllllllIlllllllIIllIIllIlI.getTargetMethod();
            if (lllllllllllllIlllllllIIllIIllllI == null) {
                return null;
            }
            final Object lllllllllllllIlllllllIIllIIlllIl = lllllllllllllIlllllllIIllIIllllI.invoke(lllllllllllllIlllllllIIllIlIIIIl, lllllllllllllIlllllllIIllIIlllll);
            return lllllllllllllIlllllllIIllIIlllIl;
        }
        catch (Throwable lllllllllllllIlllllllIIllIIlllII) {
            handleException(lllllllllllllIlllllllIIllIIlllII, lllllllllllllIlllllllIIllIlIIIIl, lllllllllllllIlllllllIIllIIllIlI, lllllllllllllIlllllllIIllIIlllll);
            return null;
        }
    }
    
    public static boolean postForgeBusEvent(final ReflectorConstructor lllllllllllllIlllllllIIlIlIIIlll, final Object... lllllllllllllIlllllllIIlIlIIIllI) {
        final Object lllllllllllllIlllllllIIlIlIIIlIl = newInstance(lllllllllllllIlllllllIIlIlIIIlll, lllllllllllllIlllllllIIlIlIIIllI);
        return lllllllllllllIlllllllIIlIlIIIlIl != null && postForgeBusEvent(lllllllllllllIlllllllIIlIlIIIlIl);
    }
    
    private static void dbgFieldValue(final boolean lllllllllllllIlllllllIIIlllIIIlI, final String lllllllllllllIlllllllIIIlllIIIIl, final ReflectorField lllllllllllllIlllllllIIIllIllIIl, final Object lllllllllllllIlllllllIIIllIlllll) {
        final String lllllllllllllIlllllllIIIllIllllI = lllllllllllllIlllllllIIIllIllIIl.getTargetField().getDeclaringClass().getName();
        final String lllllllllllllIlllllllIIIllIlllIl = lllllllllllllIlllllllIIIllIllIIl.getTargetField().getName();
        String lllllllllllllIlllllllIIIllIlllII = "";
        if (lllllllllllllIlllllllIIIlllIIIlI) {
            lllllllllllllIlllllllIIIllIlllII = " static";
        }
        Config.dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllllllIIIlllIIIIl)).append(lllllllllllllIlllllllIIIllIlllII).append(" ").append(lllllllllllllIlllllllIIIllIllllI).append(".").append(lllllllllllllIlllllllIIIllIlllIl).append(" => ").append(lllllllllllllIlllllllIIIllIlllll)));
    }
    
    private static boolean logEntry(final String lllllllllllllIlllllllIIIlIIlllII) {
        Config.dbg(lllllllllllllIlllllllIIIlIIlllII);
        return true;
    }
    
    static {
        Reflector.logForge = logEntry("*** Reflector Forge ***");
        Reflector.Attributes = new ReflectorClass("net.minecraftforge.client.model.Attributes");
        Reflector.Attributes_DEFAULT_BAKED_FORMAT = new ReflectorField(Reflector.Attributes, "DEFAULT_BAKED_FORMAT");
        Reflector.BetterFoliageClient = new ReflectorClass("mods.betterfoliage.client.BetterFoliageClient");
        Reflector.BlamingTransformer = new ReflectorClass("net.minecraftforge.fml.common.asm.transformers.BlamingTransformer");
        Reflector.BlamingTransformer_onCrash = new ReflectorMethod(Reflector.BlamingTransformer, "onCrash");
        Reflector.ChunkWatchEvent_UnWatch = new ReflectorClass("net.minecraftforge.event.world.ChunkWatchEvent$UnWatch");
        Reflector.ChunkWatchEvent_UnWatch_Constructor = new ReflectorConstructor(Reflector.ChunkWatchEvent_UnWatch, new Class[] { ChunkPos.class, EntityPlayerMP.class });
        Reflector.CoreModManager = new ReflectorClass("net.minecraftforge.fml.relauncher.CoreModManager");
        Reflector.CoreModManager_onCrash = new ReflectorMethod(Reflector.CoreModManager, "onCrash");
        Reflector.DimensionManager = new ReflectorClass("net.minecraftforge.common.DimensionManager");
        Reflector.DimensionManager_createProviderFor = new ReflectorMethod(Reflector.DimensionManager, "createProviderFor");
        Reflector.DimensionManager_getStaticDimensionIDs = new ReflectorMethod(Reflector.DimensionManager, "getStaticDimensionIDs");
        Reflector.DrawScreenEvent_Pre = new ReflectorClass("net.minecraftforge.client.event.GuiScreenEvent$DrawScreenEvent$Pre");
        Reflector.DrawScreenEvent_Pre_Constructor = new ReflectorConstructor(Reflector.DrawScreenEvent_Pre, new Class[] { GuiScreen.class, Integer.TYPE, Integer.TYPE, Float.TYPE });
        Reflector.DrawScreenEvent_Post = new ReflectorClass("net.minecraftforge.client.event.GuiScreenEvent$DrawScreenEvent$Post");
        Reflector.DrawScreenEvent_Post_Constructor = new ReflectorConstructor(Reflector.DrawScreenEvent_Post, new Class[] { GuiScreen.class, Integer.TYPE, Integer.TYPE, Float.TYPE });
        Reflector.EntityViewRenderEvent_CameraSetup = new ReflectorClass("net.minecraftforge.client.event.EntityViewRenderEvent$CameraSetup");
        Reflector.EntityViewRenderEvent_CameraSetup_Constructor = new ReflectorConstructor(Reflector.EntityViewRenderEvent_CameraSetup, new Class[] { EntityRenderer.class, Entity.class, IBlockState.class, Double.TYPE, Float.TYPE, Float.TYPE, Float.TYPE });
        Reflector.EntityViewRenderEvent_CameraSetup_getRoll = new ReflectorMethod(Reflector.EntityViewRenderEvent_CameraSetup, "getRoll");
        Reflector.EntityViewRenderEvent_CameraSetup_getPitch = new ReflectorMethod(Reflector.EntityViewRenderEvent_CameraSetup, "getPitch");
        Reflector.EntityViewRenderEvent_CameraSetup_getYaw = new ReflectorMethod(Reflector.EntityViewRenderEvent_CameraSetup, "getYaw");
        Reflector.EntityViewRenderEvent_FogColors = new ReflectorClass("net.minecraftforge.client.event.EntityViewRenderEvent$FogColors");
        Reflector.EntityViewRenderEvent_FogColors_Constructor = new ReflectorConstructor(Reflector.EntityViewRenderEvent_FogColors, new Class[] { EntityRenderer.class, Entity.class, IBlockState.class, Double.TYPE, Float.TYPE, Float.TYPE, Float.TYPE });
        Reflector.EntityViewRenderEvent_FogColors_getRed = new ReflectorMethod(Reflector.EntityViewRenderEvent_FogColors, "getRed");
        Reflector.EntityViewRenderEvent_FogColors_getGreen = new ReflectorMethod(Reflector.EntityViewRenderEvent_FogColors, "getGreen");
        Reflector.EntityViewRenderEvent_FogColors_getBlue = new ReflectorMethod(Reflector.EntityViewRenderEvent_FogColors, "getBlue");
        Reflector.EntityViewRenderEvent_RenderFogEvent = new ReflectorClass("net.minecraftforge.client.event.EntityViewRenderEvent$RenderFogEvent");
        Reflector.EntityViewRenderEvent_RenderFogEvent_Constructor = new ReflectorConstructor(Reflector.EntityViewRenderEvent_RenderFogEvent, new Class[] { EntityRenderer.class, Entity.class, IBlockState.class, Double.TYPE, Integer.TYPE, Float.TYPE });
        Reflector.Event = new ReflectorClass("net.minecraftforge.fml.common.eventhandler.Event");
        Reflector.Event_isCanceled = new ReflectorMethod(Reflector.Event, "isCanceled");
        Reflector.EventBus = new ReflectorClass("net.minecraftforge.fml.common.eventhandler.EventBus");
        Reflector.EventBus_post = new ReflectorMethod(Reflector.EventBus, "post");
        Reflector.Event_Result = new ReflectorClass("net.minecraftforge.fml.common.eventhandler.Event$Result");
        Reflector.Event_Result_DENY = new ReflectorField(Reflector.Event_Result, "DENY");
        Reflector.Event_Result_ALLOW = new ReflectorField(Reflector.Event_Result, "ALLOW");
        Reflector.Event_Result_DEFAULT = new ReflectorField(Reflector.Event_Result, "DEFAULT");
        Reflector.ExtendedBlockState = new ReflectorClass("net.minecraftforge.common.property.ExtendedBlockState");
        Reflector.ExtendedBlockState_Constructor = new ReflectorConstructor(Reflector.ExtendedBlockState, new Class[] { Block.class, IProperty[].class, IUnlistedProperty[].class });
        Reflector.FMLClientHandler = new ReflectorClass("net.minecraftforge.fml.client.FMLClientHandler");
        Reflector.FMLClientHandler_instance = new ReflectorMethod(Reflector.FMLClientHandler, "instance");
        Reflector.FMLClientHandler_isLoading = new ReflectorMethod(Reflector.FMLClientHandler, "isLoading");
        Reflector.FMLClientHandler_trackBrokenTexture = new ReflectorMethod(Reflector.FMLClientHandler, "trackBrokenTexture");
        Reflector.FMLClientHandler_trackMissingTexture = new ReflectorMethod(Reflector.FMLClientHandler, "trackMissingTexture");
        Reflector.FMLCommonHandler = new ReflectorClass("net.minecraftforge.fml.common.FMLCommonHandler");
        Reflector.FMLCommonHandler_callFuture = new ReflectorMethod(Reflector.FMLCommonHandler, "callFuture");
        Reflector.FMLCommonHandler_enhanceCrashReport = new ReflectorMethod(Reflector.FMLCommonHandler, "enhanceCrashReport");
        Reflector.FMLCommonHandler_getBrandings = new ReflectorMethod(Reflector.FMLCommonHandler, "getBrandings");
        Reflector.FMLCommonHandler_handleServerAboutToStart = new ReflectorMethod(Reflector.FMLCommonHandler, "handleServerAboutToStart");
        Reflector.FMLCommonHandler_handleServerStarting = new ReflectorMethod(Reflector.FMLCommonHandler, "handleServerStarting");
        Reflector.FMLCommonHandler_instance = new ReflectorMethod(Reflector.FMLCommonHandler, "instance");
        Reflector.ForgeBiome = new ReflectorClass(Biome.class);
        Reflector.ForgeBiome_getWaterColorMultiplier = new ReflectorMethod(Reflector.ForgeBiome, "getWaterColorMultiplier");
        Reflector.ForgeBlock = new ReflectorClass(Block.class);
        Reflector.ForgeBlock_addDestroyEffects = new ReflectorMethod(Reflector.ForgeBlock, "addDestroyEffects");
        Reflector.ForgeBlock_addHitEffects = new ReflectorMethod(Reflector.ForgeBlock, "addHitEffects");
        Reflector.ForgeBlock_canCreatureSpawn = new ReflectorMethod(Reflector.ForgeBlock, "canCreatureSpawn");
        Reflector.ForgeBlock_canRenderInLayer = new ReflectorMethod(Reflector.ForgeBlock, "canRenderInLayer", new Class[] { IBlockState.class, BlockRenderLayer.class });
        Reflector.ForgeBlock_doesSideBlockRendering = new ReflectorMethod(Reflector.ForgeBlock, "doesSideBlockRendering");
        Reflector.ForgeBlock_getBedDirection = new ReflectorMethod(Reflector.ForgeBlock, "getBedDirection");
        Reflector.ForgeBlock_getExtendedState = new ReflectorMethod(Reflector.ForgeBlock, "getExtendedState");
        Reflector.ForgeBlock_getFogColor = new ReflectorMethod(Reflector.ForgeBlock, "getFogColor");
        Reflector.ForgeBlock_getLightOpacity = new ReflectorMethod(Reflector.ForgeBlock, "getLightOpacity", new Class[] { IBlockState.class, IBlockAccess.class, BlockPos.class });
        Reflector.ForgeBlock_getLightValue = new ReflectorMethod(Reflector.ForgeBlock, "getLightValue", new Class[] { IBlockState.class, IBlockAccess.class, BlockPos.class });
        Reflector.ForgeBlock_getSoundType = new ReflectorMethod(Reflector.ForgeBlock, "getSoundType", new Class[] { IBlockState.class, World.class, BlockPos.class, Entity.class });
        Reflector.ForgeBlock_hasTileEntity = new ReflectorMethod(Reflector.ForgeBlock, "hasTileEntity", new Class[] { IBlockState.class });
        Reflector.ForgeBlock_isAir = new ReflectorMethod(Reflector.ForgeBlock, "isAir");
        Reflector.ForgeBlock_isBed = new ReflectorMethod(Reflector.ForgeBlock, "isBed");
        Reflector.ForgeBlock_isBedFoot = new ReflectorMethod(Reflector.ForgeBlock, "isBedFoot");
        Reflector.ForgeBlock_isSideSolid = new ReflectorMethod(Reflector.ForgeBlock, "isSideSolid");
        Reflector.ForgeIBlockProperties = new ReflectorClass(IBlockProperties.class);
        Reflector.ForgeIBlockProperties_getLightValue2 = new ReflectorMethod(Reflector.ForgeIBlockProperties, "getLightValue", new Class[] { IBlockAccess.class, BlockPos.class });
        Reflector.ForgeChunkCache = new ReflectorClass(ChunkCache.class);
        Reflector.ForgeChunkCache_isSideSolid = new ReflectorMethod(Reflector.ForgeChunkCache, "isSideSolid");
        Reflector.ForgeEntity = new ReflectorClass(Entity.class);
        Reflector.ForgeEntity_canRiderInteract = new ReflectorMethod(Reflector.ForgeEntity, "canRiderInteract");
        Reflector.ForgeEntity_captureDrops = new ReflectorField(Reflector.ForgeEntity, "captureDrops");
        Reflector.ForgeEntity_capturedDrops = new ReflectorField(Reflector.ForgeEntity, "capturedDrops");
        Reflector.ForgeEntity_shouldRenderInPass = new ReflectorMethod(Reflector.ForgeEntity, "shouldRenderInPass");
        Reflector.ForgeEntity_shouldRiderSit = new ReflectorMethod(Reflector.ForgeEntity, "shouldRiderSit");
        Reflector.ForgeEventFactory = new ReflectorClass("net.minecraftforge.event.ForgeEventFactory");
        Reflector.ForgeEventFactory_canEntityDespawn = new ReflectorMethod(Reflector.ForgeEventFactory, "canEntityDespawn");
        Reflector.ForgeEventFactory_renderBlockOverlay = new ReflectorMethod(Reflector.ForgeEventFactory, "renderBlockOverlay");
        Reflector.ForgeEventFactory_renderFireOverlay = new ReflectorMethod(Reflector.ForgeEventFactory, "renderFireOverlay");
        Reflector.ForgeEventFactory_renderWaterOverlay = new ReflectorMethod(Reflector.ForgeEventFactory, "renderWaterOverlay");
        Reflector.ForgeHooks = new ReflectorClass("net.minecraftforge.common.ForgeHooks");
        Reflector.ForgeHooks_onLivingAttack = new ReflectorMethod(Reflector.ForgeHooks, "onLivingAttack");
        Reflector.ForgeHooks_onLivingDeath = new ReflectorMethod(Reflector.ForgeHooks, "onLivingDeath");
        Reflector.ForgeHooks_onLivingDrops = new ReflectorMethod(Reflector.ForgeHooks, "onLivingDrops");
        Reflector.ForgeHooks_onLivingFall = new ReflectorMethod(Reflector.ForgeHooks, "onLivingFall");
        Reflector.ForgeHooks_onLivingHurt = new ReflectorMethod(Reflector.ForgeHooks, "onLivingHurt");
        Reflector.ForgeHooks_onLivingJump = new ReflectorMethod(Reflector.ForgeHooks, "onLivingJump");
        Reflector.ForgeHooks_onLivingSetAttackTarget = new ReflectorMethod(Reflector.ForgeHooks, "onLivingSetAttackTarget");
        Reflector.ForgeHooks_onLivingUpdate = new ReflectorMethod(Reflector.ForgeHooks, "onLivingUpdate");
        Reflector.ForgeHooksClient = new ReflectorClass("net.minecraftforge.client.ForgeHooksClient");
        Reflector.ForgeHooksClient_applyTransform = new ReflectorMethod(Reflector.ForgeHooksClient, "applyTransform", new Class[] { Matrix4f.class, Optional.class });
        Reflector.ForgeHooksClient_applyUVLock = new ReflectorMethod(Reflector.ForgeHooksClient, "applyUVLock");
        Reflector.ForgeHooksClient_dispatchRenderLast = new ReflectorMethod(Reflector.ForgeHooksClient, "dispatchRenderLast");
        Reflector.ForgeHooksClient_drawScreen = new ReflectorMethod(Reflector.ForgeHooksClient, "drawScreen");
        Reflector.ForgeHooksClient_fillNormal = new ReflectorMethod(Reflector.ForgeHooksClient, "fillNormal");
        Reflector.ForgeHooksClient_handleCameraTransforms = new ReflectorMethod(Reflector.ForgeHooksClient, "handleCameraTransforms");
        Reflector.ForgeHooksClient_getArmorModel = new ReflectorMethod(Reflector.ForgeHooksClient, "getArmorModel");
        Reflector.ForgeHooksClient_getArmorTexture = new ReflectorMethod(Reflector.ForgeHooksClient, "getArmorTexture");
        Reflector.ForgeHooksClient_getFogDensity = new ReflectorMethod(Reflector.ForgeHooksClient, "getFogDensity");
        Reflector.ForgeHooksClient_getFOVModifier = new ReflectorMethod(Reflector.ForgeHooksClient, "getFOVModifier");
        Reflector.ForgeHooksClient_getMatrix = new ReflectorMethod(Reflector.ForgeHooksClient, "getMatrix", new Class[] { ModelRotation.class });
        Reflector.ForgeHooksClient_getOffsetFOV = new ReflectorMethod(Reflector.ForgeHooksClient, "getOffsetFOV");
        Reflector.ForgeHooksClient_loadEntityShader = new ReflectorMethod(Reflector.ForgeHooksClient, "loadEntityShader");
        Reflector.ForgeHooksClient_onDrawBlockHighlight = new ReflectorMethod(Reflector.ForgeHooksClient, "onDrawBlockHighlight");
        Reflector.ForgeHooksClient_onFogRender = new ReflectorMethod(Reflector.ForgeHooksClient, "onFogRender");
        Reflector.ForgeHooksClient_onScreenshot = new ReflectorMethod(Reflector.ForgeHooksClient, "onScreenshot");
        Reflector.ForgeHooksClient_onTextureStitchedPre = new ReflectorMethod(Reflector.ForgeHooksClient, "onTextureStitchedPre");
        Reflector.ForgeHooksClient_onTextureStitchedPost = new ReflectorMethod(Reflector.ForgeHooksClient, "onTextureStitchedPost");
        Reflector.ForgeHooksClient_orientBedCamera = new ReflectorMethod(Reflector.ForgeHooksClient, "orientBedCamera");
        Reflector.ForgeHooksClient_putQuadColor = new ReflectorMethod(Reflector.ForgeHooksClient, "putQuadColor");
        Reflector.ForgeHooksClient_renderFirstPersonHand = new ReflectorMethod(Reflector.ForgeHooksClient, "renderFirstPersonHand");
        Reflector.ForgeHooksClient_renderMainMenu = new ReflectorMethod(Reflector.ForgeHooksClient, "renderMainMenu");
        Reflector.ForgeHooksClient_renderSpecificFirstPersonHand = new ReflectorMethod(Reflector.ForgeHooksClient, "renderSpecificFirstPersonHand");
        Reflector.ForgeHooksClient_setRenderLayer = new ReflectorMethod(Reflector.ForgeHooksClient, "setRenderLayer");
        Reflector.ForgeHooksClient_setRenderPass = new ReflectorMethod(Reflector.ForgeHooksClient, "setRenderPass");
        Reflector.ForgeHooksClient_shouldCauseReequipAnimation = new ReflectorMethod(Reflector.ForgeHooksClient, "shouldCauseReequipAnimation");
        Reflector.ForgeHooksClient_transform = new ReflectorMethod(Reflector.ForgeHooksClient, "transform");
        Reflector.ForgeItem = new ReflectorClass(Item.class);
        Reflector.ForgeItem_delegate = new ReflectorField(Reflector.ForgeItem, "delegate");
        Reflector.ForgeItem_getDurabilityForDisplay = new ReflectorMethod(Reflector.ForgeItem, "getDurabilityForDisplay");
        Reflector.ForgeItem_getRGBDurabilityForDisplay = new ReflectorMethod(Reflector.ForgeItem, "getRGBDurabilityForDisplay");
        Reflector.ForgeItem_isShield = new ReflectorMethod(Reflector.ForgeItem, "isShield");
        Reflector.ForgeItem_onEntitySwing = new ReflectorMethod(Reflector.ForgeItem, "onEntitySwing");
        Reflector.ForgeItem_shouldCauseReequipAnimation = new ReflectorMethod(Reflector.ForgeItem, "shouldCauseReequipAnimation");
        Reflector.ForgeItem_showDurabilityBar = new ReflectorMethod(Reflector.ForgeItem, "showDurabilityBar");
        Reflector.ForgeItemOverrideList = new ReflectorClass(ItemOverrideList.class);
        Reflector.ForgeItemOverrideList_handleItemState = new ReflectorMethod(Reflector.ForgeItemOverrideList, "handleItemState");
        Reflector.ForgeItemArmor = new ReflectorClass(ItemArmor.class);
        Reflector.ForgeItemArmor_hasOverlay = new ReflectorMethod(Reflector.ForgeItemArmor, "hasOverlay");
        Reflector.ForgeKeyBinding = new ReflectorClass(KeyBinding.class);
        Reflector.ForgeKeyBinding_setKeyConflictContext = new ReflectorMethod(Reflector.ForgeKeyBinding, "setKeyConflictContext");
        Reflector.ForgeKeyBinding_setKeyModifierAndCode = new ReflectorMethod(Reflector.ForgeKeyBinding, "setKeyModifierAndCode");
        Reflector.ForgeKeyBinding_getKeyModifier = new ReflectorMethod(Reflector.ForgeKeyBinding, "getKeyModifier");
        Reflector.ForgeModContainer = new ReflectorClass("net.minecraftforge.common.ForgeModContainer");
        Reflector.ForgeModContainer_forgeLightPipelineEnabled = new ReflectorField(Reflector.ForgeModContainer, "forgeLightPipelineEnabled");
        Reflector.ForgeModelBlockDefinition = new ReflectorClass(ModelBlockDefinition.class);
        Reflector.ForgeModelBlockDefinition_parseFromReader2 = new ReflectorMethod(Reflector.ForgeModelBlockDefinition, "parseFromReader", new Class[] { Reader.class, ResourceLocation.class });
        Reflector.ForgePotion = new ReflectorClass(Potion.class);
        Reflector.ForgePotion_shouldRenderHUD = Reflector.ForgePotion.makeMethod("shouldRenderHUD");
        Reflector.ForgePotion_renderHUDEffect = Reflector.ForgePotion.makeMethod("renderHUDEffect");
        Reflector.ForgePotionEffect = new ReflectorClass(PotionEffect.class);
        Reflector.ForgePotionEffect_isCurativeItem = new ReflectorMethod(Reflector.ForgePotionEffect, "isCurativeItem");
        Reflector.ForgeTileEntity = new ReflectorClass(TileEntity.class);
        Reflector.ForgeTileEntity_canRenderBreaking = new ReflectorMethod(Reflector.ForgeTileEntity, "canRenderBreaking");
        Reflector.ForgeTileEntity_getRenderBoundingBox = new ReflectorMethod(Reflector.ForgeTileEntity, "getRenderBoundingBox");
        Reflector.ForgeTileEntity_hasFastRenderer = new ReflectorMethod(Reflector.ForgeTileEntity, "hasFastRenderer");
        Reflector.ForgeTileEntity_shouldRenderInPass = new ReflectorMethod(Reflector.ForgeTileEntity, "shouldRenderInPass");
        Reflector.ForgeVertexFormatElementEnumUseage = new ReflectorClass(VertexFormatElement.EnumUsage.class);
        Reflector.ForgeVertexFormatElementEnumUseage_preDraw = new ReflectorMethod(Reflector.ForgeVertexFormatElementEnumUseage, "preDraw");
        Reflector.ForgeVertexFormatElementEnumUseage_postDraw = new ReflectorMethod(Reflector.ForgeVertexFormatElementEnumUseage, "postDraw");
        Reflector.ForgeWorld = new ReflectorClass(World.class);
        Reflector.ForgeWorld_countEntities = new ReflectorMethod(Reflector.ForgeWorld, "countEntities", new Class[] { EnumCreatureType.class, Boolean.TYPE });
        Reflector.ForgeWorld_getPerWorldStorage = new ReflectorMethod(Reflector.ForgeWorld, "getPerWorldStorage");
        Reflector.ForgeWorld_initCapabilities = new ReflectorMethod(Reflector.ForgeWorld, "initCapabilities");
        Reflector.ForgeWorldProvider = new ReflectorClass(WorldProvider.class);
        Reflector.ForgeWorldProvider_getCloudRenderer = new ReflectorMethod(Reflector.ForgeWorldProvider, "getCloudRenderer");
        Reflector.ForgeWorldProvider_getSkyRenderer = new ReflectorMethod(Reflector.ForgeWorldProvider, "getSkyRenderer");
        Reflector.ForgeWorldProvider_getWeatherRenderer = new ReflectorMethod(Reflector.ForgeWorldProvider, "getWeatherRenderer");
        Reflector.ForgeWorldProvider_getLightmapColors = new ReflectorMethod(Reflector.ForgeWorldProvider, "getLightmapColors");
        Reflector.GuiModList = new ReflectorClass("net.minecraftforge.fml.client.GuiModList");
        Reflector.GuiModList_Constructor = new ReflectorConstructor(Reflector.GuiModList, new Class[] { GuiScreen.class });
        Reflector.IExtendedBlockState = new ReflectorClass("net.minecraftforge.common.property.IExtendedBlockState");
        Reflector.IExtendedBlockState_getClean = new ReflectorMethod(Reflector.IExtendedBlockState, "getClean");
        Reflector.IModel = new ReflectorClass("net.minecraftforge.client.model.IModel");
        Reflector.IModel_getTextures = new ReflectorMethod(Reflector.IModel, "getTextures");
        Reflector.IRenderHandler = new ReflectorClass("net.minecraftforge.client.IRenderHandler");
        Reflector.IRenderHandler_render = new ReflectorMethod(Reflector.IRenderHandler, "render");
        Reflector.ItemModelMesherForge = new ReflectorClass("net.minecraftforge.client.ItemModelMesherForge");
        Reflector.ItemModelMesherForge_Constructor = new ReflectorConstructor(Reflector.ItemModelMesherForge, new Class[] { ModelManager.class });
        Reflector.KeyConflictContext = new ReflectorClass("net.minecraftforge.client.settings.KeyConflictContext");
        Reflector.KeyConflictContext_IN_GAME = new ReflectorField(Reflector.KeyConflictContext, "IN_GAME");
        Reflector.KeyModifier = new ReflectorClass("net.minecraftforge.client.settings.KeyModifier");
        Reflector.KeyModifier_valueFromString = new ReflectorMethod(Reflector.KeyModifier, "valueFromString");
        Reflector.KeyModifier_NONE = new ReflectorField(Reflector.KeyModifier, "NONE");
        Reflector.Launch = new ReflectorClass("net.minecraft.launchwrapper.Launch");
        Reflector.Launch_blackboard = new ReflectorField(Reflector.Launch, "blackboard");
        Reflector.LightUtil = new ReflectorClass("net.minecraftforge.client.model.pipeline.LightUtil");
        Reflector.LightUtil_itemConsumer = new ReflectorField(Reflector.LightUtil, "itemConsumer");
        Reflector.LightUtil_putBakedQuad = new ReflectorMethod(Reflector.LightUtil, "putBakedQuad");
        Reflector.LightUtil_renderQuadColor = new ReflectorMethod(Reflector.LightUtil, "renderQuadColor");
        Reflector.LightUtil_tessellator = new ReflectorField(Reflector.LightUtil, "tessellator");
        Reflector.MinecraftForge = new ReflectorClass("net.minecraftforge.common.MinecraftForge");
        Reflector.MinecraftForge_EVENT_BUS = new ReflectorField(Reflector.MinecraftForge, "EVENT_BUS");
        Reflector.MinecraftForgeClient = new ReflectorClass("net.minecraftforge.client.MinecraftForgeClient");
        Reflector.MinecraftForgeClient_getRenderPass = new ReflectorMethod(Reflector.MinecraftForgeClient, "getRenderPass");
        Reflector.MinecraftForgeClient_onRebuildChunk = new ReflectorMethod(Reflector.MinecraftForgeClient, "onRebuildChunk");
        Reflector.ModelLoader = new ReflectorClass("net.minecraftforge.client.model.ModelLoader");
        Reflector.ModelLoader_stateModels = new ReflectorField(Reflector.ModelLoader, "stateModels");
        Reflector.ModelLoader_onRegisterItems = new ReflectorMethod(Reflector.ModelLoader, "onRegisterItems");
        Reflector.ModelLoader_getInventoryVariant = new ReflectorMethod(Reflector.ModelLoader, "getInventoryVariant");
        Reflector.ModelLoader_VanillaLoader = new ReflectorClass("net.minecraftforge.client.model.ModelLoader$VanillaLoader", true);
        Reflector.ModelLoader_VanillaLoader_INSTANCE = new ReflectorField(Reflector.ModelLoader_VanillaLoader, "INSTANCE", true);
        Reflector.ModelLoader_VanillaLoader_loadModel = new ReflectorMethod(Reflector.ModelLoader_VanillaLoader, "loadModel", null, true);
        Reflector.ModelLoaderRegistry = new ReflectorClass("net.minecraftforge.client.model.ModelLoaderRegistry", true);
        Reflector.ModelLoaderRegistry_textures = new ReflectorField(Reflector.ModelLoaderRegistry, "textures", true);
        Reflector.NotificationModUpdateScreen = new ReflectorClass("net.minecraftforge.client.gui.NotificationModUpdateScreen");
        Reflector.NotificationModUpdateScreen_init = new ReflectorMethod(Reflector.NotificationModUpdateScreen, "init");
        Reflector.RenderBlockOverlayEvent_OverlayType = new ReflectorClass("net.minecraftforge.client.event.RenderBlockOverlayEvent$OverlayType");
        Reflector.RenderBlockOverlayEvent_OverlayType_BLOCK = new ReflectorField(Reflector.RenderBlockOverlayEvent_OverlayType, "BLOCK");
        Reflector.RenderingRegistry = new ReflectorClass("net.minecraftforge.fml.client.registry.RenderingRegistry");
        Reflector.RenderingRegistry_loadEntityRenderers = new ReflectorMethod(Reflector.RenderingRegistry, "loadEntityRenderers", new Class[] { RenderManager.class, Map.class });
        Reflector.RenderItemInFrameEvent = new ReflectorClass("net.minecraftforge.client.event.RenderItemInFrameEvent");
        Reflector.RenderItemInFrameEvent_Constructor = new ReflectorConstructor(Reflector.RenderItemInFrameEvent, new Class[] { EntityItemFrame.class, RenderItemFrame.class });
        Reflector.RenderLivingEvent_Pre = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Pre");
        Reflector.RenderLivingEvent_Pre_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Pre, new Class[] { EntityLivingBase.class, RenderLivingBase.class, Float.TYPE, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.RenderLivingEvent_Post = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Post");
        Reflector.RenderLivingEvent_Post_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Post, new Class[] { EntityLivingBase.class, RenderLivingBase.class, Float.TYPE, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.RenderLivingEvent_Specials_Pre = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Specials$Pre");
        Reflector.RenderLivingEvent_Specials_Pre_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Specials_Pre, new Class[] { EntityLivingBase.class, RenderLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.RenderLivingEvent_Specials_Post = new ReflectorClass("net.minecraftforge.client.event.RenderLivingEvent$Specials$Post");
        Reflector.RenderLivingEvent_Specials_Post_Constructor = new ReflectorConstructor(Reflector.RenderLivingEvent_Specials_Post, new Class[] { EntityLivingBase.class, RenderLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE });
        Reflector.ScreenshotEvent = new ReflectorClass("net.minecraftforge.client.event.ScreenshotEvent");
        Reflector.ScreenshotEvent_getCancelMessage = new ReflectorMethod(Reflector.ScreenshotEvent, "getCancelMessage");
        Reflector.ScreenshotEvent_getScreenshotFile = new ReflectorMethod(Reflector.ScreenshotEvent, "getScreenshotFile");
        Reflector.ScreenshotEvent_getResultMessage = new ReflectorMethod(Reflector.ScreenshotEvent, "getResultMessage");
        Reflector.SplashScreen = new ReflectorClass("net.minecraftforge.fml.client.SplashProgress");
        Reflector.WorldEvent_Load = new ReflectorClass("net.minecraftforge.event.world.WorldEvent$Load");
        Reflector.WorldEvent_Load_Constructor = new ReflectorConstructor(Reflector.WorldEvent_Load, new Class[] { World.class });
        Reflector.logVanilla = logEntry("*** Reflector Vanilla ***");
        Reflector.ChunkProviderClient = new ReflectorClass(ChunkProviderClient.class);
        Reflector.ChunkProviderClient_chunkMapping = new ReflectorField(Reflector.ChunkProviderClient, Long2ObjectMap.class);
        Reflector.GuiMainMenu = new ReflectorClass(GuiMainMenu.class);
        Reflector.GuiMainMenu_splashText = new ReflectorField(Reflector.GuiMainMenu, String.class);
        Reflector.LegacyV2Adapter = new ReflectorClass(LegacyV2Adapter.class);
        Reflector.LegacyV2Adapter_pack = new ReflectorField(Reflector.LegacyV2Adapter, IResourcePack.class);
        Reflector.Minecraft = new ReflectorClass(Minecraft.class);
        Reflector.Minecraft_defaultResourcePack = new ReflectorField(Reflector.Minecraft, DefaultResourcePack.class);
        Reflector.Minecraft_actionKeyF3 = new ReflectorField(new FieldLocatorActionKeyF3());
        Reflector.ModelHumanoidHead = new ReflectorClass(ModelHumanoidHead.class);
        Reflector.ModelHumanoidHead_head = new ReflectorField(Reflector.ModelHumanoidHead, ModelRenderer.class);
        Reflector.ModelBat = new ReflectorClass(ModelBat.class);
        Reflector.ModelBat_ModelRenderers = new ReflectorFields(Reflector.ModelBat, ModelRenderer.class, 6);
        Reflector.ModelBlaze = new ReflectorClass(ModelBlaze.class);
        Reflector.ModelBlaze_blazeHead = new ReflectorField(Reflector.ModelBlaze, ModelRenderer.class);
        Reflector.ModelBlaze_blazeSticks = new ReflectorField(Reflector.ModelBlaze, ModelRenderer[].class);
        Reflector.ModelDragon = new ReflectorClass(ModelDragon.class);
        Reflector.ModelDragon_ModelRenderers = new ReflectorFields(Reflector.ModelDragon, ModelRenderer.class, 12);
        Reflector.ModelEnderCrystal = new ReflectorClass(ModelEnderCrystal.class);
        Reflector.ModelEnderCrystal_ModelRenderers = new ReflectorFields(Reflector.ModelEnderCrystal, ModelRenderer.class, 3);
        Reflector.RenderEnderCrystal = new ReflectorClass(RenderEnderCrystal.class);
        Reflector.RenderEnderCrystal_modelEnderCrystal = new ReflectorField(Reflector.RenderEnderCrystal, ModelBase.class, 0);
        Reflector.RenderEnderCrystal_modelEnderCrystalNoBase = new ReflectorField(Reflector.RenderEnderCrystal, ModelBase.class, 1);
        Reflector.ModelEnderMite = new ReflectorClass(ModelEnderMite.class);
        Reflector.ModelEnderMite_bodyParts = new ReflectorField(Reflector.ModelEnderMite, ModelRenderer[].class);
        Reflector.ModelEvokerFangs = new ReflectorClass(ModelEvokerFangs.class);
        Reflector.ModelEvokerFangs_ModelRenderers = new ReflectorFields(Reflector.ModelEvokerFangs, ModelRenderer.class, 3);
        Reflector.ModelGhast = new ReflectorClass(ModelGhast.class);
        Reflector.ModelGhast_body = new ReflectorField(Reflector.ModelGhast, ModelRenderer.class);
        Reflector.ModelGhast_tentacles = new ReflectorField(Reflector.ModelGhast, ModelRenderer[].class);
        Reflector.ModelGuardian = new ReflectorClass(ModelGuardian.class);
        Reflector.ModelGuardian_body = new ReflectorField(Reflector.ModelGuardian, ModelRenderer.class, 0);
        Reflector.ModelGuardian_eye = new ReflectorField(Reflector.ModelGuardian, ModelRenderer.class, 1);
        Reflector.ModelGuardian_spines = new ReflectorField(Reflector.ModelGuardian, ModelRenderer[].class, 0);
        Reflector.ModelGuardian_tail = new ReflectorField(Reflector.ModelGuardian, ModelRenderer[].class, 1);
        Reflector.ModelDragonHead = new ReflectorClass(ModelDragonHead.class);
        Reflector.ModelDragonHead_head = new ReflectorField(Reflector.ModelDragonHead, ModelRenderer.class, 0);
        Reflector.ModelDragonHead_jaw = new ReflectorField(Reflector.ModelDragonHead, ModelRenderer.class, 1);
        Reflector.ModelHorse = new ReflectorClass(ModelHorse.class);
        Reflector.ModelHorse_ModelRenderers = new ReflectorFields(Reflector.ModelHorse, ModelRenderer.class, 39);
        Reflector.RenderLeashKnot = new ReflectorClass(RenderLeashKnot.class);
        Reflector.RenderLeashKnot_leashKnotModel = new ReflectorField(Reflector.RenderLeashKnot, ModelLeashKnot.class);
        Reflector.ModelMagmaCube = new ReflectorClass(ModelMagmaCube.class);
        Reflector.ModelMagmaCube_core = new ReflectorField(Reflector.ModelMagmaCube, ModelRenderer.class);
        Reflector.ModelMagmaCube_segments = new ReflectorField(Reflector.ModelMagmaCube, ModelRenderer[].class);
        Reflector.ModelOcelot = new ReflectorClass(ModelOcelot.class);
        Reflector.ModelOcelot_ModelRenderers = new ReflectorFields(Reflector.ModelOcelot, ModelRenderer.class, 8);
        Reflector.ModelRabbit = new ReflectorClass(ModelRabbit.class);
        Reflector.ModelRabbit_renderers = new ReflectorFields(Reflector.ModelRabbit, ModelRenderer.class, 12);
        Reflector.ModelSilverfish = new ReflectorClass(ModelSilverfish.class);
        Reflector.ModelSilverfish_bodyParts = new ReflectorField(Reflector.ModelSilverfish, ModelRenderer[].class, 0);
        Reflector.ModelSilverfish_wingParts = new ReflectorField(Reflector.ModelSilverfish, ModelRenderer[].class, 1);
        Reflector.ModelSlime = new ReflectorClass(ModelSlime.class);
        Reflector.ModelSlime_ModelRenderers = new ReflectorFields(Reflector.ModelSlime, ModelRenderer.class, 4);
        Reflector.ModelSquid = new ReflectorClass(ModelSquid.class);
        Reflector.ModelSquid_body = new ReflectorField(Reflector.ModelSquid, ModelRenderer.class);
        Reflector.ModelSquid_tentacles = new ReflectorField(Reflector.ModelSquid, ModelRenderer[].class);
        Reflector.ModelVex = new ReflectorClass(ModelVex.class);
        Reflector.ModelVex_leftWing = new ReflectorField(Reflector.ModelVex, ModelRenderer.class, 0);
        Reflector.ModelVex_rightWing = new ReflectorField(Reflector.ModelVex, ModelRenderer.class, 1);
        Reflector.ModelWitch = new ReflectorClass(ModelWitch.class);
        Reflector.ModelWitch_mole = new ReflectorField(Reflector.ModelWitch, ModelRenderer.class, 0);
        Reflector.ModelWitch_hat = new ReflectorField(Reflector.ModelWitch, ModelRenderer.class, 1);
        Reflector.ModelWither = new ReflectorClass(ModelWither.class);
        Reflector.ModelWither_bodyParts = new ReflectorField(Reflector.ModelWither, ModelRenderer[].class, 0);
        Reflector.ModelWither_heads = new ReflectorField(Reflector.ModelWither, ModelRenderer[].class, 1);
        Reflector.ModelWolf = new ReflectorClass(ModelWolf.class);
        Reflector.ModelWolf_tail = new ReflectorField(Reflector.ModelWolf, ModelRenderer.class, 6);
        Reflector.ModelWolf_mane = new ReflectorField(Reflector.ModelWolf, ModelRenderer.class, 7);
        Reflector.OptiFineClassTransformer = new ReflectorClass("optifine.OptiFineClassTransformer");
        Reflector.OptiFineClassTransformer_instance = new ReflectorField(Reflector.OptiFineClassTransformer, "instance");
        Reflector.OptiFineClassTransformer_getOptiFineResource = new ReflectorMethod(Reflector.OptiFineClassTransformer, "getOptiFineResource");
        Reflector.RenderBoat = new ReflectorClass(RenderBoat.class);
        Reflector.RenderBoat_modelBoat = new ReflectorField(Reflector.RenderBoat, ModelBase.class);
        Reflector.RenderEvokerFangs = new ReflectorClass(RenderEvokerFangs.class);
        Reflector.RenderEvokerFangs_model = new ReflectorField(Reflector.RenderEvokerFangs, ModelEvokerFangs.class);
        Reflector.RenderMinecart = new ReflectorClass(RenderMinecart.class);
        Reflector.RenderMinecart_modelMinecart = new ReflectorField(Reflector.RenderMinecart, ModelBase.class);
        Reflector.RenderShulkerBullet = new ReflectorClass(RenderShulkerBullet.class);
        Reflector.RenderShulkerBullet_model = new ReflectorField(Reflector.RenderShulkerBullet, ModelShulkerBullet.class);
        Reflector.RenderWitherSkull = new ReflectorClass(RenderWitherSkull.class);
        Reflector.RenderWitherSkull_model = new ReflectorField(Reflector.RenderWitherSkull, ModelSkeletonHead.class);
        Reflector.TileEntityBannerRenderer = new ReflectorClass(TileEntityBannerRenderer.class);
        Reflector.TileEntityBannerRenderer_bannerModel = new ReflectorField(Reflector.TileEntityBannerRenderer, ModelBanner.class);
        Reflector.TileEntityChestRenderer = new ReflectorClass(TileEntityChestRenderer.class);
        Reflector.TileEntityChestRenderer_simpleChest = new ReflectorField(Reflector.TileEntityChestRenderer, ModelChest.class, 0);
        Reflector.TileEntityChestRenderer_largeChest = new ReflectorField(Reflector.TileEntityChestRenderer, ModelChest.class, 1);
        Reflector.TileEntityEnchantmentTableRenderer = new ReflectorClass(TileEntityEnchantmentTableRenderer.class);
        Reflector.TileEntityEnchantmentTableRenderer_modelBook = new ReflectorField(Reflector.TileEntityEnchantmentTableRenderer, ModelBook.class);
        Reflector.TileEntityEnderChestRenderer = new ReflectorClass(TileEntityEnderChestRenderer.class);
        Reflector.TileEntityEnderChestRenderer_modelChest = new ReflectorField(Reflector.TileEntityEnderChestRenderer, ModelChest.class);
        Reflector.TileEntityShulkerBoxRenderer = new ReflectorClass(TileEntityShulkerBoxRenderer.class);
        Reflector.TileEntityShulkerBoxRenderer_model = new ReflectorField(Reflector.TileEntityShulkerBoxRenderer, ModelShulker.class);
        Reflector.TileEntitySignRenderer = new ReflectorClass(TileEntitySignRenderer.class);
        Reflector.TileEntitySignRenderer_model = new ReflectorField(Reflector.TileEntitySignRenderer, ModelSign.class);
        Reflector.TileEntitySkullRenderer = new ReflectorClass(TileEntitySkullRenderer.class);
        Reflector.TileEntitySkullRenderer_dragonHead = new ReflectorField(Reflector.TileEntitySkullRenderer, ModelDragonHead.class, 0);
        Reflector.TileEntitySkullRenderer_skeletonHead = new ReflectorField(Reflector.TileEntitySkullRenderer, ModelSkeletonHead.class, 0);
        Reflector.TileEntitySkullRenderer_humanoidHead = new ReflectorField(Reflector.TileEntitySkullRenderer, ModelSkeletonHead.class, 1);
    }
    
    public static double callDouble(final ReflectorMethod lllllllllllllIlllllllIlIIIlIIllI, final Object... lllllllllllllIlllllllIlIIIlIIlIl) {
        try {
            final Method lllllllllllllIlllllllIlIIIlIIlII = lllllllllllllIlllllllIlIIIlIIllI.getTargetMethod();
            if (lllllllllllllIlllllllIlIIIlIIlII == null) {
                return 0.0;
            }
            final Double lllllllllllllIlllllllIlIIIlIIIll = (Double)lllllllllllllIlllllllIlIIIlIIlII.invoke(null, lllllllllllllIlllllllIlIIIlIIlIl);
            return lllllllllllllIlllllllIlIIIlIIIll;
        }
        catch (Throwable lllllllllllllIlllllllIlIIIlIIIlI) {
            handleException(lllllllllllllIlllllllIlIIIlIIIlI, null, lllllllllllllIlllllllIlIIIlIIllI, lllllllllllllIlllllllIlIIIlIIlIl);
            return 0.0;
        }
    }
    
    private static void handleException(final Throwable lllllllllllllIlllllllIIIllIIlIII, final Object lllllllllllllIlllllllIIIllIIIlll, final ReflectorMethod lllllllllllllIlllllllIIIllIIIllI, final Object[] lllllllllllllIlllllllIIIllIIIlIl) {
        if (lllllllllllllIlllllllIIIllIIlIII instanceof InvocationTargetException) {
            final Throwable lllllllllllllIlllllllIIIllIIlIlI = lllllllllllllIlllllllIIIllIIlIII.getCause();
            if (lllllllllllllIlllllllIIIllIIlIlI instanceof RuntimeException) {
                final RuntimeException lllllllllllllIlllllllIIIllIIlIIl = (RuntimeException)lllllllllllllIlllllllIIIllIIlIlI;
                throw lllllllllllllIlllllllIIIllIIlIIl;
            }
            lllllllllllllIlllllllIIIllIIlIII.printStackTrace();
        }
        else {
            if (lllllllllllllIlllllllIIIllIIlIII instanceof IllegalArgumentException) {
                Config.warn("*** IllegalArgumentException ***");
                Config.warn(String.valueOf(new StringBuilder("Method: ").append(lllllllllllllIlllllllIIIllIIIllI.getTargetMethod())));
                Config.warn(String.valueOf(new StringBuilder("Object: ").append(lllllllllllllIlllllllIIIllIIIlll)));
                Config.warn(String.valueOf(new StringBuilder("Parameter classes: ").append(Config.arrayToString(getClasses(lllllllllllllIlllllllIIIllIIIlIl)))));
                Config.warn(String.valueOf(new StringBuilder("Parameters: ").append(Config.arrayToString(lllllllllllllIlllllllIIIllIIIlIl))));
            }
            Config.warn("*** Exception outside of method ***");
            Config.warn(String.valueOf(new StringBuilder("Method deactivated: ").append(lllllllllllllIlllllllIIIllIIIllI.getTargetMethod())));
            lllllllllllllIlllllllIIIllIIIllI.deactivate();
            lllllllllllllIlllllllIIIllIIlIII.printStackTrace();
        }
    }
    
    public static boolean callBoolean(final Object lllllllllllllIlllllllIIllllIlIll, final ReflectorMethod lllllllllllllIlllllllIIllllIlIlI, final Object... lllllllllllllIlllllllIIllllIllll) {
        try {
            final Method lllllllllllllIlllllllIIllllIlllI = lllllllllllllIlllllllIIllllIlIlI.getTargetMethod();
            if (lllllllllllllIlllllllIIllllIlllI == null) {
                return false;
            }
            final Boolean lllllllllllllIlllllllIIllllIllIl = (Boolean)lllllllllllllIlllllllIIllllIlllI.invoke(lllllllllllllIlllllllIIllllIlIll, lllllllllllllIlllllllIIllllIllll);
            return lllllllllllllIlllllllIIllllIllIl;
        }
        catch (Throwable lllllllllllllIlllllllIIllllIllII) {
            handleException(lllllllllllllIlllllllIIllllIllII, lllllllllllllIlllllllIIllllIlIll, lllllllllllllIlllllllIIllllIlIlI, lllllllllllllIlllllllIIllllIllll);
            return false;
        }
    }
    
    public static boolean setFieldValue(final Object lllllllllllllIlllllllIIlIlIlIIll, final ReflectorField lllllllllllllIlllllllIIlIlIlIIlI, final Object lllllllllllllIlllllllIIlIlIlIllI) {
        try {
            final Field lllllllllllllIlllllllIIlIlIlIlIl = lllllllllllllIlllllllIIlIlIlIIlI.getTargetField();
            if (lllllllllllllIlllllllIIlIlIlIlIl == null) {
                return false;
            }
            lllllllllllllIlllllllIIlIlIlIlIl.set(lllllllllllllIlllllllIIlIlIlIIll, lllllllllllllIlllllllIIlIlIlIllI);
            return true;
        }
        catch (Throwable lllllllllllllIlllllllIIlIlIlIlII) {
            lllllllllllllIlllllllIIlIlIlIlII.printStackTrace();
            return false;
        }
    }
    
    public static Object getFieldValue(final Object lllllllllllllIlllllllIIlIllllIIl, final ReflectorFields lllllllllllllIlllllllIIlIllllIII, final int lllllllllllllIlllllllIIlIlllIlll) {
        final ReflectorField lllllllllllllIlllllllIIlIlllIllI = lllllllllllllIlllllllIIlIllllIII.getReflectorField(lllllllllllllIlllllllIIlIlllIlll);
        return (lllllllllllllIlllllllIIlIlllIllI == null) ? null : getFieldValue(lllllllllllllIlllllllIIlIllllIIl, lllllllllllllIlllllllIIlIlllIllI);
    }
    
    public static int callInt(final Object lllllllllllllIlllllllIIllllIIIIl, final ReflectorMethod lllllllllllllIlllllllIIllllIIIII, final Object... lllllllllllllIlllllllIIlllIlllll) {
        try {
            final Method lllllllllllllIlllllllIIlllIllllI = lllllllllllllIlllllllIIllllIIIII.getTargetMethod();
            if (lllllllllllllIlllllllIIlllIllllI == null) {
                return 0;
            }
            final Integer lllllllllllllIlllllllIIlllIlllIl = (Integer)lllllllllllllIlllllllIIlllIllllI.invoke(lllllllllllllIlllllllIIllllIIIIl, lllllllllllllIlllllllIIlllIlllll);
            return lllllllllllllIlllllllIIlllIlllIl;
        }
        catch (Throwable lllllllllllllIlllllllIIlllIlllII) {
            handleException(lllllllllllllIlllllllIIlllIlllII, lllllllllllllIlllllllIIllllIIIIl, lllllllllllllIlllllllIIllllIIIII, lllllllllllllIlllllllIIlllIlllll);
            return 0;
        }
    }
}
