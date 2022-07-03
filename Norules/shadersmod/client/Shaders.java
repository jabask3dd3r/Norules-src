package shadersmod.client;

import net.minecraft.client.renderer.texture.*;
import java.util.regex.*;
import net.minecraft.client.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import java.nio.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.tileentity.*;
import org.lwjgl.util.glu.*;
import org.lwjgl.*;
import shadersmod.common.*;
import net.minecraft.util.*;
import net.minecraft.client.settings.*;
import net.minecraft.item.*;
import org.apache.commons.io.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import java.io.*;
import optifine.*;
import net.minecraft.client.model.*;
import java.util.*;

public class Shaders
{
    static /* synthetic */ float celestialAngle;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackVignette;
    public static /* synthetic */ ITextureObject defaultTexture;
    private static /* synthetic */ int[] gbuffersFormat;
    public static /* synthetic */ float wetnessHalfLife;
    static final /* synthetic */ FloatBuffer shadowProjectionInverse;
    static /* synthetic */ double cameraPositionY;
    static /* synthetic */ float nightVision;
    public static /* synthetic */ boolean useMultiTexCoord3Attrib;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackBackFaceCutout;
    static /* synthetic */ Set<String> shaderPackOptionSliders;
    public static /* synthetic */ int fogMode;
    static /* synthetic */ long lastWorldTime;
    static /* synthetic */ float[] shadowLightPositionVector;
    public static /* synthetic */ int midTexCoordAttrib;
    static final /* synthetic */ FloatBuffer projectionInverse;
    static /* synthetic */ float[] sunPosModelView;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackOldLighting;
    private static /* synthetic */ int noiseTextureResolution;
    public static /* synthetic */ int configTexMinFilN;
    static /* synthetic */ IShaderPack shaderPack;
    static /* synthetic */ int[] programsID;
    public static /* synthetic */ ShaderUniformFloat4 uniformEntityColor;
    public static /* synthetic */ PropertyDefaultTrueFalse configOldLighting;
    static final /* synthetic */ FloatBuffer previousModelView;
    static /* synthetic */ boolean usewetness;
    static /* synthetic */ File shaderpacksdir;
    private static /* synthetic */ int[] programsRef;
    static /* synthetic */ int shadowMapWidth;
    public static /* synthetic */ int tangentAttrib;
    static final /* synthetic */ float[] faShadowProjection;
    public static /* synthetic */ boolean[] shadowColorFilterNearest;
    public static /* synthetic */ int entityAttrib;
    public static /* synthetic */ Properties loadedShaders;
    public static /* synthetic */ int atlasSizeY;
    static /* synthetic */ int usedShadowDepthBuffers;
    static /* synthetic */ float frameTimeCounter;
    private static /* synthetic */ String activeColorAtmSettings;
    public static /* synthetic */ boolean normalMapEnabled;
    private static /* synthetic */ boolean skipRenderHandOff;
    public static /* synthetic */ boolean progUseTangentAttrib;
    static /* synthetic */ int moonPhase;
    public static /* synthetic */ int terrainIconSize;
    public static /* synthetic */ int configAntialiasingLevel;
    static /* synthetic */ float eyePosY;
    public static /* synthetic */ boolean itemToRenderOffTranslucent;
    static final /* synthetic */ FloatBuffer shadowModelViewInverse;
    static /* synthetic */ float eyeBrightnessFadeY;
    static final /* synthetic */ int[] dfbColorTexturesA;
    static final /* synthetic */ float[] faModelViewInverse;
    private static /* synthetic */ List<Integer> shaderPackDimensions;
    public static /* synthetic */ float sunPathRotation;
    static /* synthetic */ long diffSystemTime;
    private static /* synthetic */ String noiseTexturePath;
    private static /* synthetic */ int activeCompositeMipmapSetting;
    public static /* synthetic */ int[] entityData;
    private static /* synthetic */ CustomTexture[] customTexturesComposite;
    static final /* synthetic */ float[] faShadowProjectionInverse;
    private static final /* synthetic */ String[] STAGE_NAMES;
    static /* synthetic */ float skyColorB;
    static /* synthetic */ float blindness;
    private static /* synthetic */ boolean noiseTextureEnabled;
    static /* synthetic */ float shadowMapHalfPlane;
    static /* synthetic */ long worldTime;
    public static /* synthetic */ boolean isSleeping;
    static final /* synthetic */ IntBuffer dfbDepthTextures;
    static final /* synthetic */ IntBuffer dfbColorTextures;
    static /* synthetic */ String currentshadername;
    static /* synthetic */ int superSamplingLevel;
    static final /* synthetic */ float[] faShadowModelViewInverse;
    static final /* synthetic */ int[] colorTextureTextureImageUnit;
    static /* synthetic */ float sunAngle;
    public static /* synthetic */ float drynessHalfLife;
    public static /* synthetic */ int configTexMagFilS;
    static /* synthetic */ String shaderpacksdirname;
    public static /* synthetic */ boolean[] shadowMipmapEnabled;
    static /* synthetic */ float shadowDistanceRenderMul;
    static /* synthetic */ double cameraPositionX;
    static final /* synthetic */ float[] faProjectionInverse;
    static /* synthetic */ float shadowAngle;
    static /* synthetic */ long diffWorldTime;
    static final /* synthetic */ FloatBuffer projection;
    private static final /* synthetic */ String[] programNames;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackBackFaceSolid;
    public static /* synthetic */ boolean configSpecularMap;
    static /* synthetic */ float shadowMapFOV;
    public static /* synthetic */ int activeProgram;
    static /* synthetic */ String packNameDefault;
    public static /* synthetic */ boolean isRenderingWorld;
    static /* synthetic */ float centerDepthSmoothHalflife;
    public static /* synthetic */ PropertyDefaultTrueFalse configOldHandLight;
    private static /* synthetic */ boolean isHandRenderedMain;
    static /* synthetic */ float clearColorG;
    static final /* synthetic */ IntBuffer dfbDrawBuffers;
    public static /* synthetic */ boolean[] shadowColorMipmapEnabled;
    static final /* synthetic */ FloatBuffer tempDirectFloatBuffer;
    private static final /* synthetic */ boolean saveFinalShaders;
    static /* synthetic */ double cameraPositionZ;
    private static /* synthetic */ String newColorAtmSetting;
    static /* synthetic */ Minecraft mc;
    static /* synthetic */ ShaderProfile[] shaderPackProfiles;
    static /* synthetic */ long lastSystemTime;
    static /* synthetic */ int usedColorBuffers;
    static /* synthetic */ boolean shadowMapIsOrtho;
    public static /* synthetic */ int renderHeight;
    static final /* synthetic */ int[] colorTexturesToggle;
    static final /* synthetic */ FloatBuffer modelViewInverse;
    static final /* synthetic */ IntBuffer sfbDepthTextures;
    static /* synthetic */ int usedDepthBuffers;
    static /* synthetic */ float rainStrength;
    static /* synthetic */ float skyColorG;
    static /* synthetic */ int isEyeInWater;
    static /* synthetic */ double previousCameraPositionX;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$BlockRenderLayer;
    static final /* synthetic */ IntBuffer drawBuffersNone;
    public static /* synthetic */ boolean progUseMidTexCoordAttrib;
    static /* synthetic */ int systemTimeInt32;
    static /* synthetic */ float eyeBrightnessFadeX;
    static final /* synthetic */ IntBuffer sfbColorTextures;
    static final /* synthetic */ IntBuffer sfbDrawBuffers;
    static /* synthetic */ float skyColorR;
    public static /* synthetic */ boolean hasForge;
    static /* synthetic */ double previousCameraPositionY;
    public static /* synthetic */ ContextCapabilities capabilities;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackMoon;
    public static /* synthetic */ float configHandDepthMul;
    private static /* synthetic */ CustomTexture[] customTexturesGbuffers;
    static /* synthetic */ int usedShadowColorBuffers;
    static /* synthetic */ float[] sunPosition;
    private static /* synthetic */ World currentWorld;
    public static /* synthetic */ float configRenderResMul;
    static /* synthetic */ boolean lightmapEnabled;
    static final /* synthetic */ float[] faModelView;
    static /* synthetic */ float[] upPosModelView;
    static /* synthetic */ boolean updateChunksErrorRecorded;
    public static /* synthetic */ float shadowAngleInterval;
    public static /* synthetic */ boolean shaderPackLoaded;
    static /* synthetic */ boolean fogEnabled;
    static /* synthetic */ ShaderOption[] shaderPackOptions;
    public static /* synthetic */ String glVersionString;
    static /* synthetic */ float centerDepth;
    static /* synthetic */ float clearColorR;
    static final /* synthetic */ IntBuffer drawBuffersColorAtt0;
    static /* synthetic */ File configFile;
    private static /* synthetic */ boolean skipRenderHandMain;
    public static /* synthetic */ boolean isShaderPackInitialized;
    static /* synthetic */ float clearColorB;
    public static /* synthetic */ boolean isInitializedOnce;
    public static /* synthetic */ int numberResetDisplayList;
    public static /* synthetic */ boolean itemToRenderMainTranslucent;
    static /* synthetic */ float[] moonPosition;
    public static /* synthetic */ PropertyDefaultFastFancyOff shaderPackClouds;
    public static /* synthetic */ boolean configCloudShadow;
    static /* synthetic */ float centerDepthSmooth;
    public static /* synthetic */ String packNameNone;
    private static final /* synthetic */ int[] formatIds;
    static final /* synthetic */ FloatBuffer tempMatrixDirectBuffer;
    static /* synthetic */ float[] moonPosModelView;
    public static /* synthetic */ float fogColorG;
    public static /* synthetic */ boolean isRenderingDfb;
    public static /* synthetic */ int renderWidth;
    static final /* synthetic */ FloatBuffer modelView;
    public static /* synthetic */ float fogColorB;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackShadowTranslucent;
    static /* synthetic */ IntBuffer[] programsDrawBuffers;
    private static final /* synthetic */ int[] programBackups;
    public static /* synthetic */ boolean configShadowClipFrustrum;
    private static /* synthetic */ int renderDisplayWidth;
    static final /* synthetic */ boolean[][] programsToggleColorTextures;
    public static /* synthetic */ boolean renderItemKeepDepthMask;
    static /* synthetic */ Map<String, ScreenShaderOptions> shaderPackGuiScreens;
    public static /* synthetic */ String glVendorString;
    public static /* synthetic */ boolean useEntityAttrib;
    static /* synthetic */ boolean needResetModels;
    public static /* synthetic */ boolean hasGlGenMipmap;
    static /* synthetic */ String optionsfilename;
    static final /* synthetic */ float[] faShadowModelView;
    static /* synthetic */ IntBuffer activeDrawBuffers;
    static /* synthetic */ int usedColorAttachs;
    public static /* synthetic */ boolean configTweakBlockDamage;
    public static /* synthetic */ int configTexMinFilS;
    static /* synthetic */ int shadowPassCounter;
    public static /* synthetic */ boolean useTangentAttrib;
    static final /* synthetic */ float[] faProjection;
    static /* synthetic */ double previousCameraPositionZ;
    public static /* synthetic */ int configTexMagFilN;
    static /* synthetic */ float[] shadowLightPosition;
    static /* synthetic */ int shadowPassInterval;
    public static /* synthetic */ boolean shouldSkipDefaultShadow;
    static /* synthetic */ int sfb;
    public static /* synthetic */ boolean isRenderingSky;
    public static /* synthetic */ float fogColorR;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackUnderwaterOverlay;
    public static /* synthetic */ boolean useMidTexCoordAttrib;
    public static /* synthetic */ int entityDataIndex;
    public static /* synthetic */ float blockLightLevel05;
    public static /* synthetic */ float shadowIntervalSize;
    private static /* synthetic */ boolean isHandRenderedOff;
    public static /* synthetic */ float aoLevel;
    public static /* synthetic */ float blockLightLevel08;
    static /* synthetic */ boolean centerDepthSmoothEnabled;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackBackFaceTranslucent;
    public static /* synthetic */ ShaderUniformInt uniformEntityId;
    static /* synthetic */ float wetness;
    private static /* synthetic */ float[] tempMat;
    public static /* synthetic */ boolean progUseEntityAttrib;
    public static /* synthetic */ float eyeBrightnessHalflife;
    static /* synthetic */ boolean waterShadowEnabled;
    private static /* synthetic */ int[] programsCompositeMipmapSetting;
    public static /* synthetic */ boolean configNormalMap;
    public static /* synthetic */ boolean[] shadowHardwareFilteringEnabled;
    public static /* synthetic */ int configTexMagFilB;
    public static /* synthetic */ boolean isCompositeRendered;
    private static /* synthetic */ int programIDCopyDepth;
    public static /* synthetic */ float configShadowResMul;
    static /* synthetic */ float[] upPosition;
    static /* synthetic */ float frameTime;
    private static /* synthetic */ int renderDisplayHeight;
    private static final /* synthetic */ ByteBuffer bigBuffer;
    static final /* synthetic */ FloatBuffer shadowModelView;
    private static final /* synthetic */ String[] formatNames;
    static /* synthetic */ int eyeBrightness;
    public static /* synthetic */ boolean[] shadowFilterNearest;
    static /* synthetic */ int frameCounter;
    static /* synthetic */ long systemTime;
    public static /* synthetic */ int configTexMinFilB;
    public static /* synthetic */ int atlasSizeX;
    private static /* synthetic */ String newDrawBufSetting;
    static /* synthetic */ int dfb;
    private static /* synthetic */ ICustomTexture noiseTexture;
    public static /* synthetic */ int[] terrainTextureSize;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackOldHandLight;
    public static /* synthetic */ String glRendererString;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackDynamicHandLight;
    private static /* synthetic */ Map<String, String> shaderPackResources;
    private static /* synthetic */ boolean isRenderingFirstPersonHand;
    static /* synthetic */ int shadowMapHeight;
    static final /* synthetic */ IntBuffer[] drawBuffersBuffer;
    private static /* synthetic */ String[] programsDrawBufSettings;
    static /* synthetic */ EntityRenderer entityRenderer;
    public static /* synthetic */ boolean isShadowPass;
    static /* synthetic */ int spShadowMapWidth;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackSun;
    static /* synthetic */ int usedDrawBuffers;
    public static /* synthetic */ boolean needResizeShadow;
    public static /* synthetic */ float blockLightLevel06;
    public static /* synthetic */ PropertyDefaultTrueFalse shaderPackBackFaceCutoutMipped;
    public static /* synthetic */ Properties shadersConfig;
    static /* synthetic */ File shadersdir;
    static final /* synthetic */ FloatBuffer shadowProjection;
    public static /* synthetic */ ShaderUniformInt uniformBlockEntityId;
    private static /* synthetic */ boolean[] gbuffersClear;
    private static /* synthetic */ String[] programsColorAtmSettings;
    private static /* synthetic */ int newCompositeMipmapSetting;
    static final /* synthetic */ FloatBuffer previousProjection;
    static /* synthetic */ int spShadowMapHeight;
    
    public static boolean isRenderBothHands() {
        return !Shaders.skipRenderHandMain && !Shaders.skipRenderHandOff;
    }
    
    public static void setItemToRenderOff(final ItemStack llllllllllllllIllIlIllllIIlIIIlI) {
        Shaders.itemToRenderOffTranslucent = isTranslucentBlock(llllllllllllllIllIlIllllIIlIIIlI);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$shadersmod$client$EnumShaderOption() {
        final int[] $switch_TABLE$shadersmod$client$EnumShaderOption = Shaders.$SWITCH_TABLE$shadersmod$client$EnumShaderOption;
        if ($switch_TABLE$shadersmod$client$EnumShaderOption != null) {
            return $switch_TABLE$shadersmod$client$EnumShaderOption;
        }
        final char llllllllllllllIllIlIlllIllllllll = (Object)new int[EnumShaderOption.values().length];
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.ANTIALIASING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.OLD_HAND_LIGHT.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.OLD_LIGHTING.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.SHADER_PACK.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TEX_MAG_FIL_B.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TEX_MAG_FIL_N.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TEX_MAG_FIL_S.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TEX_MIN_FIL_B.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TEX_MIN_FIL_N.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TEX_MIN_FIL_S.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError17) {}
        try {
            llllllllllllllIllIlIlllIllllllll[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError18) {}
        return Shaders.$SWITCH_TABLE$shadersmod$client$EnumShaderOption = (int[])(Object)llllllllllllllIllIlIlllIllllllll;
    }
    
    public static void beginSky() {
        Shaders.isRenderingSky = true;
        Shaders.fogEnabled = true;
        setDrawBuffers(Shaders.dfbDrawBuffers);
        useProgram(5);
        pushEntity(-2, 0);
    }
    
    public static int setFogMode(final int llllllllllllllIllIllIIIIIlIIIIIl) {
        return Shaders.fogMode = llllllllllllllIllIllIIIIIlIIIIIl;
    }
    
    public static void setProgramUniform1i(final String llllllllllllllIllIllIIIlIIIIIIlI, final int llllllllllllllIllIllIIIlIIIIIIIl) {
        final int llllllllllllllIllIllIIIlIIIIIIII = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllIllIllIIIlIIIIIIII != 0) {
            final int llllllllllllllIllIllIIIIllllllll = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIllIllIIIlIIIIIIII, (CharSequence)llllllllllllllIllIllIIIlIIIIIIlI);
            ARBShaderObjects.glUniform1iARB(llllllllllllllIllIllIIIIllllllll, llllllllllllllIllIllIIIlIIIIIIIl);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllIllIllIIIlIIIIIIlI);
        }
    }
    
    private static void loadEntityDataMap() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: sipush          300
        //     7: invokespecial   java/util/IdentityHashMap.<init>:(I)V
        //    10: putstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //    13: getstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //    16: invokeinterface java/util/Map.isEmpty:()Z
        //    21: ifeq            91
        //    24: getstatic       net/minecraft/block/Block.REGISTRY:Lnet/minecraft/util/registry/RegistryNamespacedDefaultedByKey;
        //    27: invokevirtual   net/minecraft/util/registry/RegistryNamespacedDefaultedByKey.getKeys:()Ljava/util/Set;
        //    30: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    35: astore_1        /* llllllllllllllIllIllIIIIlIIllllI */
        //    36: goto            82
        //    39: aload_1         /* llllllllllllllIllIllIIIIlIIllllI */
        //    40: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    45: checkcast       Lnet/minecraft/util/ResourceLocation;
        //    48: astore_0        /* llllllllllllllIllIllIIIIlIlIlIll */
        //    49: getstatic       net/minecraft/block/Block.REGISTRY:Lnet/minecraft/util/registry/RegistryNamespacedDefaultedByKey;
        //    52: aload_0         /* llllllllllllllIllIllIIIIlIlIlIll */
        //    53: invokevirtual   net/minecraft/util/registry/RegistryNamespacedDefaultedByKey.getObject:(Ljava/lang/Object;)Ljava/lang/Object;
        //    56: checkcast       Lnet/minecraft/block/Block;
        //    59: astore_2        /* llllllllllllllIllIllIIIIlIlIlIlI */
        //    60: getstatic       net/minecraft/block/Block.REGISTRY:Lnet/minecraft/util/registry/RegistryNamespacedDefaultedByKey;
        //    63: aload_2         /* llllllllllllllIllIllIIIIlIlIlIlI */
        //    64: invokevirtual   net/minecraft/util/registry/RegistryNamespacedDefaultedByKey.getIDForObject:(Ljava/lang/Object;)I
        //    67: istore_3        /* llllllllllllllIllIllIIIIlIIlllII */
        //    68: getstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //    71: aload_2         /* llllllllllllllIllIllIIIIlIlIlIlI */
        //    72: iload_3         /* llllllllllllllIllIllIIIIlIlIlIIl */
        //    73: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    76: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    81: pop            
        //    82: aload_1         /* llllllllllllllIllIllIIIIlIIllllI */
        //    83: invokeinterface java/util/Iterator.hasNext:()Z
        //    88: ifne            39
        //    91: aconst_null    
        //    92: astore_0        /* llllllllllllllIllIllIIIIlIlIlIII */
        //    93: new             Ljava/io/BufferedReader;
        //    96: dup            
        //    97: new             Ljava/io/InputStreamReader;
        //   100: dup            
        //   101: getstatic       shadersmod/client/Shaders.shaderPack:Lshadersmod/client/IShaderPack;
        //   104: ldc_w           "/mc_Entity_x.txt"
        //   107: invokeinterface shadersmod/client/IShaderPack.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   112: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   115: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   118: astore_0        /* llllllllllllllIllIllIIIIlIlIlIII */
        //   119: goto            123
        //   122: astore_1        /* llllllllllllllIllIllIIIIlIIllllI */
        //   123: aload_0         /* llllllllllllllIllIllIIIIlIlIlIII */
        //   124: ifnull          245
        //   127: goto            226
        //   130: getstatic       shadersmod/client/Shaders.patternLoadEntityDataMap:Ljava/util/regex/Pattern;
        //   133: aload_1         /* llllllllllllllIllIllIIIIlIlIIlll */
        //   134: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //   137: astore_2        /* llllllllllllllIllIllIIIIlIlIIlIl */
        //   138: aload_2         /* llllllllllllllIllIllIIIIlIlIIlIl */
        //   139: invokevirtual   java/util/regex/Matcher.matches:()Z
        //   142: ifeq            212
        //   145: aload_2         /* llllllllllllllIllIllIIIIlIlIIlIl */
        //   146: iconst_1       
        //   147: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   150: astore_3        /* llllllllllllllIllIllIIIIlIIlllII */
        //   151: aload_2         /* llllllllllllllIllIllIIIIlIlIIlIl */
        //   152: iconst_2       
        //   153: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //   156: astore          llllllllllllllIllIllIIIIlIlIIIll
        //   158: aload           llllllllllllllIllIllIIIIlIlIIIll
        //   160: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   163: istore          llllllllllllllIllIllIIIIlIlIIIlI
        //   165: aload_3         /* llllllllllllllIllIllIIIIlIlIIlII */
        //   166: invokestatic    net/minecraft/block/Block.getBlockFromName:(Ljava/lang/String;)Lnet/minecraft/block/Block;
        //   169: astore          llllllllllllllIllIllIIIIlIlIIIIl
        //   171: aload           llllllllllllllIllIllIIIIlIlIIIIl
        //   173: ifnull          195
        //   176: getstatic       shadersmod/client/Shaders.mapBlockToEntityData:Ljava/util/Map;
        //   179: aload           llllllllllllllIllIllIIIIlIlIIIIl
        //   181: iload           llllllllllllllIllIllIIIIlIlIIIlI
        //   183: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   186: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   191: pop            
        //   192: goto            226
        //   195: ldc_w           "Unknown block name %s"
        //   198: iconst_1       
        //   199: anewarray       Ljava/lang/Object;
        //   202: dup            
        //   203: iconst_0       
        //   204: aload_3         /* llllllllllllllIllIllIIIIlIlIIlII */
        //   205: aastore        
        //   206: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   209: goto            226
        //   212: ldc_w           "unmatched %s\n"
        //   215: iconst_1       
        //   216: anewarray       Ljava/lang/Object;
        //   219: dup            
        //   220: iconst_0       
        //   221: aload_1         /* llllllllllllllIllIllIIIIlIlIIlll */
        //   222: aastore        
        //   223: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   226: aload_0         /* llllllllllllllIllIllIIIIlIlIlIII */
        //   227: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   230: dup            
        //   231: astore_1        /* llllllllllllllIllIllIIIIlIIllllI */
        //   232: ifnonnull       130
        //   235: goto            245
        //   238: astore_2        /* llllllllllllllIllIllIIIIlIlIIIII */
        //   239: ldc_w           "Error parsing mc_Entity_x.txt"
        //   242: invokestatic    shadersmod/common/SMCLog.warning:(Ljava/lang/String;)V
        //   245: aload_0         /* llllllllllllllIllIllIIIIlIlIlIII */
        //   246: ifnull          257
        //   249: aload_0         /* llllllllllllllIllIllIIIIlIlIlIII */
        //   250: invokevirtual   java/io/BufferedReader.close:()V
        //   253: goto            257
        //   256: astore_1        /* llllllllllllllIllIllIIIIlIIllllI */
        //   257: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  93     119    122    123    Ljava/lang/Exception;
        //  127    235    238    245    Ljava/lang/Exception;
        //  249    253    256    257    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void glDisableWrapper(final int llllllllllllllIllIlIlllllIIIlIII) {
        GL11.glDisable(llllllllllllllIllIlIlllllIIIlIII);
        if (llllllllllllllIllIlIlllllIIIlIII == 3553) {
            disableTexture2D();
        }
        else if (llllllllllllllIllIlIlllllIIIlIII == 2912) {
            disableFog();
        }
    }
    
    private static void saveOptionProperties(final IShaderPack llllllllllllllIllIllIIllIlIIIlll, final Properties llllllllllllllIllIllIIllIlIIIllI) throws IOException {
        final String llllllllllllllIllIllIIllIlIIlIlI = String.valueOf(new StringBuilder(String.valueOf(Shaders.shaderpacksdirname)).append("/").append(llllllllllllllIllIllIIllIlIIIlll.getName()).append(".txt"));
        final File llllllllllllllIllIllIIllIlIIlIIl = new File(Minecraft.getMinecraft().mcDataDir, llllllllllllllIllIllIIllIlIIlIlI);
        if (llllllllllllllIllIllIIllIlIIIllI.isEmpty()) {
            llllllllllllllIllIllIIllIlIIlIIl.delete();
        }
        else {
            final FileOutputStream llllllllllllllIllIllIIllIlIIlIII = new FileOutputStream(llllllllllllllIllIllIIllIlIIlIIl);
            llllllllllllllIllIllIIllIlIIIllI.store(llllllllllllllIllIllIIllIlIIlIII, null);
            llllllllllllllIllIllIIllIlIIlIII.flush();
            llllllllllllllIllIllIIllIlIIlIII.close();
        }
    }
    
    public static void clearRenderBuffer() {
        if (Shaders.isShadowPass) {
            checkGLError("shadow clear pre");
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.sfbDepthTextures.get(0), 0);
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL20.glDrawBuffers(Shaders.programsDrawBuffers[30]);
            checkFramebufferStatus("shadow clear");
            GL11.glClear(16640);
            checkGLError("shadow clear");
        }
        else {
            checkGLError("clear pre");
            if (Shaders.gbuffersClear[0]) {
                GL20.glDrawBuffers(36064);
                GL11.glClear(16384);
            }
            if (Shaders.gbuffersClear[1]) {
                GL20.glDrawBuffers(36065);
                GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glClear(16384);
            }
            for (int llllllllllllllIllIllIIIIIIlIlIlI = 2; llllllllllllllIllIllIIIIIIlIlIlI < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIIIlIlIlI) {
                if (Shaders.gbuffersClear[llllllllllllllIllIllIIIIIIlIlIlI]) {
                    GL20.glDrawBuffers(36064 + llllllllllllllIllIllIIIIIIlIlIlI);
                    GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GL11.glClear(16384);
                }
            }
            setDrawBuffers(Shaders.dfbDrawBuffers);
            checkFramebufferStatus("clear");
            checkGLError("clear");
        }
    }
    
    public static void beginEntities() {
        if (Shaders.isRenderingWorld) {
            useProgram(16);
            resetDisplayListModels();
        }
    }
    
    private static void loadShaderPackResources() {
        Shaders.shaderPackResources = new HashMap<String, String>();
        if (Shaders.shaderPackLoaded) {
            final List<String> llllllllllllllIllIlIllllIlIIlIll = new ArrayList<String>();
            final String llllllllllllllIllIlIllllIlIIlIlI = "/shaders/lang/";
            final String llllllllllllllIllIlIllllIlIIlIIl = "en_US";
            final String llllllllllllllIllIlIllllIlIIlIII = ".lang";
            llllllllllllllIllIlIllllIlIIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIlIllllIlIIlIlI)).append(llllllllllllllIllIlIllllIlIIlIIl).append(llllllllllllllIllIlIllllIlIIlIII)));
            if (!Config.getGameSettings().language.equals(llllllllllllllIllIlIllllIlIIlIIl)) {
                llllllllllllllIllIlIllllIlIIlIll.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIlIllllIlIIlIlI)).append(Config.getGameSettings().language).append(llllllllllllllIllIlIllllIlIIlIII)));
            }
            try {
                for (final String llllllllllllllIllIlIllllIlIIIlll : llllllllllllllIllIlIllllIlIIlIll) {
                    final InputStream llllllllllllllIllIlIllllIlIIIllI = Shaders.shaderPack.getResourceAsStream(llllllllllllllIllIlIllllIlIIIlll);
                    if (llllllllllllllIllIlIllllIlIIIllI != null) {
                        final Properties llllllllllllllIllIlIllllIlIIIlIl = new Properties();
                        Lang.loadLocaleData(llllllllllllllIllIlIllllIlIIIllI, llllllllllllllIllIlIllllIlIIIlIl);
                        llllllllllllllIllIlIllllIlIIIllI.close();
                        for (final Object llllllllllllllIllIlIllllIlIIIlII : ((Hashtable<Object, V>)llllllllllllllIllIlIllllIlIIIlIl).keySet()) {
                            final String llllllllllllllIllIlIllllIlIIIIll = llllllllllllllIllIlIllllIlIIIlIl.getProperty((String)llllllllllllllIllIlIllllIlIIIlII);
                            Shaders.shaderPackResources.put((String)llllllllllllllIllIlIllllIlIIIlII, llllllllllllllIllIlIllllIlIIIIll);
                        }
                    }
                }
            }
            catch (IOException llllllllllllllIllIlIllllIlIIIIlI) {
                llllllllllllllIllIlIllllIlIIIIlI.printStackTrace();
            }
        }
    }
    
    private static void setEnumShaderOption(final EnumShaderOption llllllllllllllIllIllIlIIIlIIllIl, String llllllllllllllIllIllIlIIIlIIlIlI) {
        if (llllllllllllllIllIllIlIIIlIIlIlI == null) {
            llllllllllllllIllIllIlIIIlIIlIlI = llllllllllllllIllIllIlIIIlIIllIl.getValueDefault();
        }
        switch ($SWITCH_TABLE$shadersmod$client$EnumShaderOption()[llllllllllllllIllIllIlIIIlIIllIl.ordinal()]) {
            case 1: {
                Shaders.configAntialiasingLevel = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            case 2: {
                Shaders.configNormalMap = Config.parseBoolean(llllllllllllllIllIllIlIIIlIIlIlI, true);
                break;
            }
            case 3: {
                Shaders.configSpecularMap = Config.parseBoolean(llllllllllllllIllIllIlIIIlIIlIlI, true);
                break;
            }
            case 4: {
                Shaders.configRenderResMul = Config.parseFloat(llllllllllllllIllIllIlIIIlIIlIlI, 1.0f);
                break;
            }
            case 5: {
                Shaders.configShadowResMul = Config.parseFloat(llllllllllllllIllIllIlIIIlIIlIlI, 1.0f);
                break;
            }
            case 6: {
                Shaders.configHandDepthMul = Config.parseFloat(llllllllllllllIllIllIlIIIlIIlIlI, 0.125f);
                break;
            }
            case 7: {
                Shaders.configCloudShadow = Config.parseBoolean(llllllllllllllIllIllIlIIIlIIlIlI, true);
                break;
            }
            case 8: {
                Shaders.configOldHandLight.setPropertyValue(llllllllllllllIllIllIlIIIlIIlIlI);
                break;
            }
            case 9: {
                Shaders.configOldLighting.setPropertyValue(llllllllllllllIllIllIlIIIlIIlIlI);
                break;
            }
            case 10: {
                Shaders.currentshadername = llllllllllllllIllIllIlIIIlIIlIlI;
                break;
            }
            case 11: {
                Shaders.configTweakBlockDamage = Config.parseBoolean(llllllllllllllIllIllIlIIIlIIlIlI, true);
                break;
            }
            case 12: {
                Shaders.configShadowClipFrustrum = Config.parseBoolean(llllllllllllllIllIllIlIIIlIIlIlI, true);
                break;
            }
            case 13: {
                Shaders.configTexMinFilB = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            case 14: {
                Shaders.configTexMinFilN = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            case 15: {
                Shaders.configTexMinFilS = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            case 16: {
                Shaders.configTexMagFilB = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            case 17: {
                Shaders.configTexMagFilB = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            case 18: {
                Shaders.configTexMagFilB = Config.parseInt(llllllllllllllIllIllIlIIIlIIlIlI, 0);
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown option: ").append(llllllllllllllIllIllIlIIIlIIllIl)));
            }
        }
    }
    
    public static void beginRender(final Minecraft llllllllllllllIllIllIIIIIlllIIlI, final float llllllllllllllIllIllIIIIIllIIIll, final long llllllllllllllIllIllIIIIIllIIIlI) {
        checkGLError("pre beginRender");
        checkWorldChanged(Shaders.mc.world);
        Shaders.mc = llllllllllllllIllIllIIIIIlllIIlI;
        Shaders.mc.mcProfiler.startSection("init");
        Shaders.entityRenderer = Shaders.mc.entityRenderer;
        if (!Shaders.isShaderPackInitialized) {
            try {
                init();
            }
            catch (IllegalStateException llllllllllllllIllIllIIIIIllIllll) {
                if (Config.normalize(llllllllllllllIllIllIIIIIllIllll.getMessage()).equals("Function is not supported")) {
                    printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: ").append(llllllllllllllIllIllIIIIIllIllll.getMessage())));
                    llllllllllllllIllIllIIIIIllIllll.printStackTrace();
                    setShaderPack(Shaders.packNameNone);
                    return;
                }
            }
        }
        if (Shaders.mc.displayWidth != Shaders.renderDisplayWidth || Shaders.mc.displayHeight != Shaders.renderDisplayHeight) {
            resize();
        }
        if (Shaders.needResizeShadow) {
            resizeShadow();
        }
        Shaders.worldTime = Shaders.mc.world.getWorldTime();
        Shaders.diffWorldTime = (Shaders.worldTime - Shaders.lastWorldTime) % 24000L;
        if (Shaders.diffWorldTime < 0L) {
            Shaders.diffWorldTime += 24000L;
        }
        Shaders.lastWorldTime = Shaders.worldTime;
        Shaders.moonPhase = Shaders.mc.world.getMoonPhase();
        ++Shaders.frameCounter;
        if (Shaders.frameCounter >= 720720) {
            Shaders.frameCounter = 0;
        }
        Shaders.systemTime = System.currentTimeMillis();
        if (Shaders.lastSystemTime == 0L) {
            Shaders.lastSystemTime = Shaders.systemTime;
        }
        Shaders.diffSystemTime = Shaders.systemTime - Shaders.lastSystemTime;
        Shaders.lastSystemTime = Shaders.systemTime;
        Shaders.frameTime = Shaders.diffSystemTime / 1000.0f;
        Shaders.frameTimeCounter += Shaders.frameTime;
        Shaders.frameTimeCounter %= 3600.0f;
        Shaders.rainStrength = llllllllllllllIllIllIIIIIlllIIlI.world.getRainStrength(llllllllllllllIllIllIIIIIllIIIll);
        final float llllllllllllllIllIllIIIIIllIlllI = Shaders.diffSystemTime * 0.01f;
        float llllllllllllllIllIllIIIIIllIllIl = (float)Math.exp(Math.log(0.5) * llllllllllllllIllIllIIIIIllIlllI / ((Shaders.wetness < Shaders.rainStrength) ? Shaders.drynessHalfLife : Shaders.wetnessHalfLife));
        Shaders.wetness = Shaders.wetness * llllllllllllllIllIllIIIIIllIllIl + Shaders.rainStrength * (1.0f - llllllllllllllIllIllIIIIIllIllIl);
        final Entity llllllllllllllIllIllIIIIIllIllII = Shaders.mc.getRenderViewEntity();
        if (llllllllllllllIllIllIIIIIllIllII != null) {
            Shaders.isSleeping = (llllllllllllllIllIllIIIIIllIllII instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllllIllIllIIIIIllIllII).isPlayerSleeping());
            Shaders.eyePosY = (float)llllllllllllllIllIllIIIIIllIllII.posY * llllllllllllllIllIllIIIIIllIIIll + (float)llllllllllllllIllIllIIIIIllIllII.lastTickPosY * (1.0f - llllllllllllllIllIllIIIIIllIIIll);
            Shaders.eyeBrightness = llllllllllllllIllIllIIIIIllIllII.getBrightnessForRender();
            llllllllllllllIllIllIIIIIllIllIl = Shaders.diffSystemTime * 0.01f;
            final float llllllllllllllIllIllIIIIIllIlIll = (float)Math.exp(Math.log(0.5) * llllllllllllllIllIllIIIIIllIllIl / Shaders.eyeBrightnessHalflife);
            Shaders.eyeBrightnessFadeX = Shaders.eyeBrightnessFadeX * llllllllllllllIllIllIIIIIllIlIll + (Shaders.eyeBrightness & 0xFFFF) * (1.0f - llllllllllllllIllIllIIIIIllIlIll);
            Shaders.eyeBrightnessFadeY = Shaders.eyeBrightnessFadeY * llllllllllllllIllIllIIIIIllIlIll + (Shaders.eyeBrightness >> 16) * (1.0f - llllllllllllllIllIllIIIIIllIlIll);
            Shaders.isEyeInWater = 0;
            if (Shaders.mc.gameSettings.thirdPersonView == 0 && !Shaders.isSleeping) {
                if (llllllllllllllIllIllIIIIIllIllII.isInsideOfMaterial(Material.WATER)) {
                    Shaders.isEyeInWater = 1;
                }
                else if (llllllllllllllIllIllIIIIIllIllII.isInsideOfMaterial(Material.LAVA)) {
                    Shaders.isEyeInWater = 2;
                }
            }
            if (Shaders.mc.player != null) {
                Shaders.nightVision = 0.0f;
                if (Shaders.mc.player.isPotionActive(MobEffects.NIGHT_VISION)) {
                    Shaders.nightVision = Config.getMinecraft().entityRenderer.getNightVisionBrightness(Shaders.mc.player, llllllllllllllIllIllIIIIIllIIIll);
                }
                Shaders.blindness = 0.0f;
                if (Shaders.mc.player.isPotionActive(MobEffects.BLINDNESS)) {
                    final int llllllllllllllIllIllIIIIIllIlIlI = Shaders.mc.player.getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
                    Shaders.blindness = Config.limit(llllllllllllllIllIllIIIIIllIlIlI / 20.0f, 0.0f, 1.0f);
                }
            }
            Vec3d llllllllllllllIllIllIIIIIllIlIIl = Shaders.mc.world.getSkyColor(llllllllllllllIllIllIIIIIllIllII, llllllllllllllIllIllIIIIIllIIIll);
            llllllllllllllIllIllIIIIIllIlIIl = CustomColors.getWorldSkyColor(llllllllllllllIllIllIIIIIllIlIIl, Shaders.currentWorld, llllllllllllllIllIllIIIIIllIllII, llllllllllllllIllIllIIIIIllIIIll);
            Shaders.skyColorR = (float)llllllllllllllIllIllIIIIIllIlIIl.xCoord;
            Shaders.skyColorG = (float)llllllllllllllIllIllIIIIIllIlIIl.yCoord;
            Shaders.skyColorB = (float)llllllllllllllIllIllIIIIIllIlIIl.zCoord;
        }
        Shaders.isRenderingWorld = true;
        Shaders.isCompositeRendered = false;
        Shaders.isHandRenderedMain = false;
        Shaders.isHandRenderedOff = false;
        Shaders.skipRenderHandMain = false;
        Shaders.skipRenderHandOff = false;
        if (Shaders.usedShadowDepthBuffers >= 1) {
            GlStateManager.setActiveTexture(33988);
            GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(0));
            if (Shaders.usedShadowDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33989);
                GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(1));
            }
        }
        GlStateManager.setActiveTexture(33984);
        for (int llllllllllllllIllIllIIIIIllIlIII = 0; llllllllllllllIllIllIIIIIllIlIII < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIIllIlIII) {
            GlStateManager.bindTexture(Shaders.dfbColorTexturesA[llllllllllllllIllIllIIIIIllIlIII]);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
            GlStateManager.bindTexture(Shaders.dfbColorTexturesA[8 + llllllllllllllIllIllIIIIIllIlIII]);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
        }
        GlStateManager.bindTexture(0);
        for (int llllllllllllllIllIllIIIIIllIIlll = 0; llllllllllllllIllIllIIIIIllIIlll < 4 && 4 + llllllllllllllIllIllIIIIIllIIlll < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIIllIIlll) {
            GlStateManager.setActiveTexture(33991 + llllllllllllllIllIllIIIIIllIIlll);
            GlStateManager.bindTexture(Shaders.dfbColorTextures.get(4 + llllllllllllllIllIllIIIIIllIIlll));
        }
        GlStateManager.setActiveTexture(33990);
        GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(0));
        if (Shaders.usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(1));
            if (Shaders.usedDepthBuffers >= 3) {
                GlStateManager.setActiveTexture(33996);
                GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(2));
            }
        }
        for (int llllllllllllllIllIllIIIIIllIIllI = 0; llllllllllllllIllIllIIIIIllIIllI < Shaders.usedShadowColorBuffers; ++llllllllllllllIllIllIIIIIllIIllI) {
            GlStateManager.setActiveTexture(33997 + llllllllllllllIllIllIIIIIllIIllI);
            GlStateManager.bindTexture(Shaders.sfbColorTextures.get(llllllllllllllIllIllIIIIIllIIllI));
        }
        if (Shaders.noiseTextureEnabled) {
            GlStateManager.setActiveTexture(33984 + Shaders.noiseTexture.getTextureUnit());
            GlStateManager.bindTexture(Shaders.noiseTexture.getTextureId());
            GL11.glTexParameteri(3553, 10242, 10497);
            GL11.glTexParameteri(3553, 10243, 10497);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexParameteri(3553, 10241, 9729);
        }
        bindCustomTextures(Shaders.customTexturesGbuffers);
        GlStateManager.setActiveTexture(33984);
        Shaders.previousCameraPositionX = Shaders.cameraPositionX;
        Shaders.previousCameraPositionY = Shaders.cameraPositionY;
        Shaders.previousCameraPositionZ = Shaders.cameraPositionZ;
        Shaders.previousProjection.position(0);
        Shaders.projection.position(0);
        Shaders.previousProjection.put(Shaders.projection);
        Shaders.previousProjection.position(0);
        Shaders.projection.position(0);
        Shaders.previousModelView.position(0);
        Shaders.modelView.position(0);
        Shaders.previousModelView.put(Shaders.modelView);
        Shaders.previousModelView.position(0);
        Shaders.modelView.position(0);
        checkGLError("beginRender");
        ShadersRender.renderShadowMap(Shaders.entityRenderer, 0, llllllllllllllIllIllIIIIIllIIIll, llllllllllllllIllIllIIIIIllIIIlI);
        Shaders.mc.mcProfiler.endSection();
        EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
        for (int llllllllllllllIllIllIIIIIllIIlIl = 0; llllllllllllllIllIllIIIIIllIIlIl < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIIllIIlIl) {
            Shaders.colorTexturesToggle[llllllllllllllIllIllIIIIIllIIlIl] = 0;
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllIllIllIIIIIllIIlIl, 3553, Shaders.dfbColorTexturesA[llllllllllllllIllIllIIIIIllIIlIl], 0);
        }
        checkGLError("end beginRender");
    }
    
    private static void printChat(final String llllllllllllllIllIllIIlIlIIllIlI) {
        Shaders.mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(llllllllllllllIllIllIIlIlIIllIlI));
    }
    
    public static void beginLivingDamage() {
        if (Shaders.isRenderingWorld) {
            ShadersTex.bindTexture(Shaders.defaultTexture);
            if (!Shaders.isShadowPass) {
                setDrawBuffers(Shaders.drawBuffersColorAtt0);
            }
        }
    }
    
    public static boolean isItemToRenderOffTranslucent() {
        return Shaders.itemToRenderOffTranslucent;
    }
    
    public static void drawComposite() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(0.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f(1.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f(1.0f, 1.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(0.0f, 1.0f, 0.0f);
        GL11.glEnd();
    }
    
    public static boolean isProgramPath(String llllllllllllllIllIlIllllIIlIlIIl) {
        if (llllllllllllllIllIlIllllIIlIlIIl == null) {
            return false;
        }
        if (llllllllllllllIllIlIllllIIlIlIIl.length() <= 0) {
            return false;
        }
        final int llllllllllllllIllIlIllllIIlIlIlI = llllllllllllllIllIlIllllIIlIlIIl.lastIndexOf("/");
        if (llllllllllllllIllIlIllllIIlIlIlI >= 0) {
            llllllllllllllIllIlIllllIIlIlIIl = llllllllllllllIllIlIllllIIlIlIIl.substring(llllllllllllllIllIlIllllIIlIlIlI + 1);
        }
        return Arrays.asList(Shaders.programNames).contains(llllllllllllllIllIlIllllIIlIlIIl);
    }
    
    public static void beginClouds() {
        Shaders.fogEnabled = true;
        pushEntity(-3, 0);
        useProgram(6);
    }
    
    public static void renderCompositeFinal() {
        if (!Shaders.isShadowPass) {
            checkGLError("pre-renderCompositeFinal");
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, 1.0, 0.0, 1.0, 0.0, 1.0);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(519);
            GlStateManager.depthMask(false);
            GlStateManager.disableLighting();
            if (Shaders.usedShadowDepthBuffers >= 1) {
                GlStateManager.setActiveTexture(33988);
                GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(0));
                if (Shaders.usedShadowDepthBuffers >= 2) {
                    GlStateManager.setActiveTexture(33989);
                    GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(1));
                }
            }
            for (int llllllllllllllIllIlIllllllIlllll = 0; llllllllllllllIllIlIllllllIlllll < Shaders.usedColorBuffers; ++llllllllllllllIllIlIllllllIlllll) {
                GlStateManager.setActiveTexture(33984 + Shaders.colorTextureTextureImageUnit[llllllllllllllIllIlIllllllIlllll]);
                GlStateManager.bindTexture(Shaders.dfbColorTexturesA[llllllllllllllIllIlIllllllIlllll]);
            }
            GlStateManager.setActiveTexture(33990);
            GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(0));
            if (Shaders.usedDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33995);
                GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(1));
                if (Shaders.usedDepthBuffers >= 3) {
                    GlStateManager.setActiveTexture(33996);
                    GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(2));
                }
            }
            for (int llllllllllllllIllIlIllllllIllllI = 0; llllllllllllllIllIlIllllllIllllI < Shaders.usedShadowColorBuffers; ++llllllllllllllIllIlIllllllIllllI) {
                GlStateManager.setActiveTexture(33997 + llllllllllllllIllIlIllllllIllllI);
                GlStateManager.bindTexture(Shaders.sfbColorTextures.get(llllllllllllllIllIlIllllllIllllI));
            }
            if (Shaders.noiseTextureEnabled) {
                GlStateManager.setActiveTexture(33984 + Shaders.noiseTexture.getTextureUnit());
                GlStateManager.bindTexture(Shaders.noiseTexture.getTextureId());
                GL11.glTexParameteri(3553, 10242, 10497);
                GL11.glTexParameteri(3553, 10243, 10497);
                GL11.glTexParameteri(3553, 10240, 9729);
                GL11.glTexParameteri(3553, 10241, 9729);
            }
            bindCustomTextures(Shaders.customTexturesComposite);
            GlStateManager.setActiveTexture(33984);
            final boolean llllllllllllllIllIlIllllllIlllIl = true;
            for (int llllllllllllllIllIlIllllllIlllII = 0; llllllllllllllIllIlIllllllIlllII < Shaders.usedColorBuffers; ++llllllllllllllIllIlIllllllIlllII) {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllIllIlIllllllIlllII, 3553, Shaders.dfbColorTexturesA[8 + llllllllllllllIllIlIllllllIlllII], 0);
            }
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.dfbDepthTextures.get(0), 0);
            GL20.glDrawBuffers(Shaders.dfbDrawBuffers);
            checkGLError("pre-composite");
            for (int llllllllllllllIllIlIllllllIllIll = 0; llllllllllllllIllIlIllllllIllIll < 8; ++llllllllllllllIllIlIllllllIllIll) {
                if (Shaders.programsID[21 + llllllllllllllIllIlIllllllIllIll] != 0) {
                    useProgram(21 + llllllllllllllIllIlIllllllIllIll);
                    checkGLError(Shaders.programNames[21 + llllllllllllllIllIlIllllllIllIll]);
                    if (Shaders.activeCompositeMipmapSetting != 0) {
                        genCompositeMipmap();
                    }
                    drawComposite();
                    for (int llllllllllllllIllIlIllllllIllIlI = 0; llllllllllllllIllIlIllllllIllIlI < Shaders.usedColorBuffers; ++llllllllllllllIllIlIllllllIllIlI) {
                        if (Shaders.programsToggleColorTextures[21 + llllllllllllllIllIlIllllllIllIll][llllllllllllllIllIlIllllllIllIlI]) {
                            final int llllllllllllllIllIlIllllllIllIIl = Shaders.colorTexturesToggle[llllllllllllllIllIlIllllllIllIlI];
                            final int[] colorTexturesToggle = Shaders.colorTexturesToggle;
                            final int n = llllllllllllllIllIlIllllllIllIlI;
                            final int n2 = 8 - llllllllllllllIllIlIllllllIllIIl;
                            colorTexturesToggle[n] = n2;
                            final int llllllllllllllIllIlIllllllIllIII = n2;
                            GlStateManager.setActiveTexture(33984 + Shaders.colorTextureTextureImageUnit[llllllllllllllIllIlIllllllIllIlI]);
                            GlStateManager.bindTexture(Shaders.dfbColorTexturesA[llllllllllllllIllIlIllllllIllIII + llllllllllllllIllIlIllllllIllIlI]);
                            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllIllIlIllllllIllIlI, 3553, Shaders.dfbColorTexturesA[llllllllllllllIllIlIllllllIllIIl + llllllllllllllIllIlIllllllIllIlI], 0);
                        }
                    }
                    GlStateManager.setActiveTexture(33984);
                }
            }
            checkGLError("composite");
            Shaders.isRenderingDfb = false;
            Shaders.mc.getFramebuffer().bindFramebuffer(true);
            OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, Shaders.mc.getFramebuffer().framebufferTexture, 0);
            GL11.glViewport(0, 0, Shaders.mc.displayWidth, Shaders.mc.displayHeight);
            if (EntityRenderer.anaglyphEnable) {
                final boolean llllllllllllllIllIlIllllllIlIlll = EntityRenderer.anaglyphField != 0;
                GlStateManager.colorMask(llllllllllllllIllIlIllllllIlIlll, !llllllllllllllIllIlIllllllIlIlll, !llllllllllllllIllIlIllllllIlIlll, true);
            }
            GlStateManager.depthMask(true);
            GL11.glClearColor(Shaders.clearColorR, Shaders.clearColorG, Shaders.clearColorB, 1.0f);
            GL11.glClear(16640);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(519);
            GlStateManager.depthMask(false);
            checkGLError("pre-final");
            useProgram(29);
            checkGLError("final");
            if (Shaders.activeCompositeMipmapSetting != 0) {
                genCompositeMipmap();
            }
            drawComposite();
            checkGLError("renderCompositeFinal");
            Shaders.isCompositeRendered = true;
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            useProgram(0);
        }
    }
    
    private static void bindCustomTextures(final CustomTexture[] llllllllllllllIllIllIIllllIIlIIl) {
        if (llllllllllllllIllIllIIllllIIlIIl != null) {
            for (int llllllllllllllIllIllIIllllIIllII = 0; llllllllllllllIllIllIIllllIIllII < llllllllllllllIllIllIIllllIIlIIl.length; ++llllllllllllllIllIllIIllllIIllII) {
                final CustomTexture llllllllllllllIllIllIIllllIIlIll = llllllllllllllIllIllIIllllIIlIIl[llllllllllllllIllIllIIllllIIllII];
                GlStateManager.setActiveTexture(33984 + llllllllllllllIllIllIIllllIIlIll.getTextureUnit());
                final ITextureObject llllllllllllllIllIllIIllllIIlIlI = llllllllllllllIllIllIIllllIIlIll.getTexture();
                GlStateManager.bindTexture(llllllllllllllIllIllIIllllIIlIlI.getGlTextureId());
            }
        }
    }
    
    private static void setupNoiseTexture() {
        if (Shaders.noiseTexture == null && Shaders.noiseTexturePath != null) {
            Shaders.noiseTexture = loadCustomTexture(15, Shaders.noiseTexturePath);
        }
        if (Shaders.noiseTexture == null) {
            Shaders.noiseTexture = new HFNoiseTexture(Shaders.noiseTextureResolution, Shaders.noiseTextureResolution);
        }
    }
    
    private static void resizeShadow() {
        Shaders.needResizeShadow = false;
        Shaders.shadowMapWidth = Math.round(Shaders.spShadowMapWidth * Shaders.configShadowResMul);
        Shaders.shadowMapHeight = Math.round(Shaders.spShadowMapHeight * Shaders.configShadowResMul);
        setupShadowFrameBuffer();
    }
    
    public static void setBlockEntityId(final TileEntity llllllllllllllIllIlIlllllIIllIII) {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass && Shaders.uniformBlockEntityId.isDefined()) {
            final Block llllllllllllllIllIlIlllllIIlIlll = llllllllllllllIllIlIlllllIIllIII.getBlockType();
            final int llllllllllllllIllIlIlllllIIlIllI = Block.getIdFromBlock(llllllllllllllIllIlIlllllIIlIlll);
            Shaders.uniformBlockEntityId.setValue(llllllllllllllIllIlIlllllIIlIllI);
        }
    }
    
    private static FloatBuffer nextFloatBuffer(final int llllllllllllllIllIllIlIIIlllIIlI) {
        final ByteBuffer llllllllllllllIllIllIlIIIlllIlII = Shaders.bigBuffer;
        final int llllllllllllllIllIllIlIIIlllIIll = llllllllllllllIllIllIlIIIlllIlII.limit();
        llllllllllllllIllIllIlIIIlllIlII.position(llllllllllllllIllIllIlIIIlllIIll).limit(llllllllllllllIllIllIlIIIlllIIll + llllllllllllllIllIllIlIIIlllIIlI * 4);
        return llllllllllllllIllIllIlIIIlllIlII.asFloatBuffer();
    }
    
    public static boolean isSkipRenderHand(final EnumHand llllllllllllllIllIlIllllIIIlIIIl) {
        return (llllllllllllllIllIlIllllIIIlIIIl == EnumHand.MAIN_HAND && Shaders.skipRenderHandMain) || (llllllllllllllIllIlIllllIIIlIIIl == EnumHand.OFF_HAND && Shaders.skipRenderHandOff);
    }
    
    public static void endLivingDamage() {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass) {
            setDrawBuffers(Shaders.programsDrawBuffers[16]);
        }
    }
    
    public static void setDrawBuffers(IntBuffer llllllllllllllIllIllIIIlIIlIlIll) {
        if (llllllllllllllIllIllIIIlIIlIlIll == null) {
            llllllllllllllIllIllIIIlIIlIlIll = Shaders.drawBuffersNone;
        }
        if (Shaders.activeDrawBuffers != llllllllllllllIllIllIIIlIIlIlIll) {
            GL20.glDrawBuffers(Shaders.activeDrawBuffers = (IntBuffer)llllllllllllllIllIllIIIlIIlIlIll);
        }
    }
    
    public static void setCamera(final float llllllllllllllIllIllIIIIIIlIIIll) {
        final Entity llllllllllllllIllIllIIIIIIlIIIlI = Shaders.mc.getRenderViewEntity();
        final double llllllllllllllIllIllIIIIIIlIIIIl = llllllllllllllIllIllIIIIIIlIIIlI.lastTickPosX + (llllllllllllllIllIllIIIIIIlIIIlI.posX - llllllllllllllIllIllIIIIIIlIIIlI.lastTickPosX) * llllllllllllllIllIllIIIIIIlIIIll;
        final double llllllllllllllIllIllIIIIIIlIIIII = llllllllllllllIllIllIIIIIIlIIIlI.lastTickPosY + (llllllllllllllIllIllIIIIIIlIIIlI.posY - llllllllllllllIllIllIIIIIIlIIIlI.lastTickPosY) * llllllllllllllIllIllIIIIIIlIIIll;
        final double llllllllllllllIllIllIIIIIIIlllll = llllllllllllllIllIllIIIIIIlIIIlI.lastTickPosZ + (llllllllllllllIllIllIIIIIIlIIIlI.posZ - llllllllllllllIllIllIIIIIIlIIIlI.lastTickPosZ) * llllllllllllllIllIllIIIIIIlIIIll;
        Shaders.cameraPositionX = llllllllllllllIllIllIIIIIIlIIIIl;
        Shaders.cameraPositionY = llllllllllllllIllIllIIIIIIlIIIII;
        Shaders.cameraPositionZ = llllllllllllllIllIllIIIIIIIlllll;
        GL11.glGetFloat(2983, (FloatBuffer)Shaders.projection.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.projectionInverse.position(0), (FloatBuffer)Shaders.projection.position(0), Shaders.faProjectionInverse, Shaders.faProjection);
        Shaders.projection.position(0);
        Shaders.projectionInverse.position(0);
        GL11.glGetFloat(2982, (FloatBuffer)Shaders.modelView.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.modelViewInverse.position(0), (FloatBuffer)Shaders.modelView.position(0), Shaders.faModelViewInverse, Shaders.faModelView);
        Shaders.modelView.position(0);
        Shaders.modelViewInverse.position(0);
        checkGLError("setCamera");
    }
    
    private static void loadShaderPackDimensions() {
        Shaders.shaderPackDimensions.clear();
        for (int llllllllllllllIllIllIlIIIIIlllIl = -128; llllllllllllllIllIllIlIIIIIlllIl <= 128; ++llllllllllllllIllIllIlIIIIIlllIl) {
            final String llllllllllllllIllIllIlIIIIIlllII = String.valueOf(new StringBuilder("/shaders/world").append(llllllllllllllIllIllIlIIIIIlllIl));
            if (Shaders.shaderPack.hasDirectory(llllllllllllllIllIllIlIIIIIlllII)) {
                Shaders.shaderPackDimensions.add(llllllllllllllIllIllIlIIIIIlllIl);
            }
        }
        if (Shaders.shaderPackDimensions.size() > 0) {
            final Integer[] llllllllllllllIllIllIlIIIIIllIll = Shaders.shaderPackDimensions.toArray(new Integer[Shaders.shaderPackDimensions.size()]);
            Config.dbg(String.valueOf(new StringBuilder("[Shaders] Worlds: ").append(Config.arrayToString(llllllllllllllIllIllIlIIIIIllIll))));
        }
    }
    
    public static void disableFog() {
        Shaders.fogEnabled = false;
        setProgramUniform1i("fogMode", 0);
    }
    
    public static int checkGLError(final String llllllllllllllIllIllIIlIllIIIIll, final String llllllllllllllIllIllIIlIllIIIIII) {
        final int llllllllllllllIllIllIIlIlIlllllI = GL11.glGetError();
        if (llllllllllllllIllIllIIlIlIlllllI != 0) {
            System.err.format("GL error 0x%04x: %s at %s %s\n", llllllllllllllIllIllIIlIlIlllllI, GLU.gluErrorString(llllllllllllllIllIllIIlIlIlllllI), llllllllllllllIllIllIIlIllIIIIll, llllllllllllllIllIllIIlIllIIIIII);
        }
        return llllllllllllllIllIllIIlIlIlllllI;
    }
    
    private static void resetCustomTextures() {
        deleteCustomTextures(Shaders.customTexturesGbuffers);
        deleteCustomTextures(Shaders.customTexturesComposite);
        Shaders.customTexturesGbuffers = null;
        Shaders.customTexturesComposite = null;
    }
    
    public static ShaderOption[] getShaderPackOptions() {
        return Shaders.shaderPackOptions;
    }
    
    public static boolean isRenderShadowTranslucent() {
        return !Shaders.shaderPackShadowTranslucent.isFalse();
    }
    
    private static Properties loadOptionProperties(final IShaderPack llllllllllllllIllIllIIllIIlIllIl) throws IOException {
        final Properties llllllllllllllIllIllIIllIIlIllII = new Properties();
        final String llllllllllllllIllIllIIllIIlIlIll = String.valueOf(new StringBuilder(String.valueOf(Shaders.shaderpacksdirname)).append("/").append(llllllllllllllIllIllIIllIIlIllIl.getName()).append(".txt"));
        final File llllllllllllllIllIllIIllIIlIlIlI = new File(Minecraft.getMinecraft().mcDataDir, llllllllllllllIllIllIIllIIlIlIll);
        if (llllllllllllllIllIllIIllIIlIlIlI.exists() && llllllllllllllIllIllIIllIIlIlIlI.isFile() && llllllllllllllIllIllIIllIIlIlIlI.canRead()) {
            final FileInputStream llllllllllllllIllIllIIllIIlIlIIl = new FileInputStream(llllllllllllllIllIllIIllIIlIlIlI);
            llllllllllllllIllIllIIllIIlIllII.load(llllllllllllllIllIllIIllIIlIlIIl);
            llllllllllllllIllIllIIllIIlIlIIl.close();
            return llllllllllllllIllIllIIllIIlIllII;
        }
        return llllllllllllllIllIllIIllIIlIllII;
    }
    
    public static void preSkyList() {
        setUpPosition();
        GL11.glColor3f(Shaders.fogColorR, Shaders.fogColorG, Shaders.fogColorB);
        drawHorizon();
        GL11.glColor3f(Shaders.skyColorR, Shaders.skyColorG, Shaders.skyColorB);
    }
    
    static {
        ProgramShadowCutout = 32;
        MaxDepthBuffers = 3;
        texMinFilRange = 3;
        ProgramBlock = 13;
        ProgramBasic = 1;
        ProgramClouds = 6;
        ProgramBeaconBeam = 14;
        ProgramComposite5 = 26;
        ProgramComposite1 = 22;
        ProgramShadow = 30;
        enableShadersOption = true;
        STAGE_GBUFFERS = 0;
        ProgramCount = 33;
        MaxColorBuffers = 8;
        ProgramHand = 19;
        MaxShadowDepthBuffers = 2;
        ProgramDamagedBlock = 11;
        MaxShadowColorBuffers = 8;
        ProgramWeather = 20;
        texMagFilRange = 2;
        ProgramEntities = 16;
        ProgramTextured = 2;
        ProgramWater = 12;
        ProgramComposite3 = 24;
        ProgramSkyTextured = 5;
        ProgramComposite = 21;
        ProgramFinal = 29;
        ProgramSkyBasic = 4;
        ProgramTerrainCutout = 10;
        enableShadersDebug = true;
        STAGE_COMPOSITE = 1;
        ProgramTerrainSolid = 8;
        ProgramArmorGlint = 17;
        ProgramSpiderEyes = 18;
        ProgramTexturedLit = 3;
        ProgramComposite4 = 25;
        MaxCompositePasses = 8;
        ProgramComposite2 = 23;
        ProgramTerrainCutoutMip = 9;
        ProgramTerrain = 7;
        ProgramShadowSolid = 31;
        ProgramComposite6 = 27;
        MaxDrawBuffers = 8;
        ProgramNone = 0;
        ProgramItem = 15;
        ProgramComposite7 = 28;
        bigBufferSize = 2196;
        Shaders.isInitializedOnce = false;
        Shaders.isShaderPackInitialized = false;
        Shaders.hasGlGenMipmap = false;
        Shaders.hasForge = false;
        Shaders.numberResetDisplayList = 0;
        Shaders.needResetModels = false;
        Shaders.renderDisplayWidth = 0;
        Shaders.renderDisplayHeight = 0;
        Shaders.renderWidth = 0;
        Shaders.renderHeight = 0;
        Shaders.isRenderingWorld = false;
        Shaders.isRenderingSky = false;
        Shaders.isCompositeRendered = false;
        Shaders.isRenderingDfb = false;
        Shaders.isShadowPass = false;
        Shaders.renderItemKeepDepthMask = false;
        Shaders.itemToRenderMainTranslucent = false;
        Shaders.itemToRenderOffTranslucent = false;
        Shaders.sunPosition = new float[4];
        Shaders.moonPosition = new float[4];
        Shaders.shadowLightPosition = new float[4];
        Shaders.upPosition = new float[4];
        Shaders.shadowLightPositionVector = new float[4];
        Shaders.upPosModelView = new float[] { 0.0f, 100.0f, 0.0f, 0.0f };
        Shaders.sunPosModelView = new float[] { 0.0f, 100.0f, 0.0f, 0.0f };
        Shaders.moonPosModelView = new float[] { 0.0f, -100.0f, 0.0f, 0.0f };
        Shaders.tempMat = new float[16];
        Shaders.worldTime = 0L;
        Shaders.lastWorldTime = 0L;
        Shaders.diffWorldTime = 0L;
        Shaders.celestialAngle = 0.0f;
        Shaders.sunAngle = 0.0f;
        Shaders.shadowAngle = 0.0f;
        Shaders.moonPhase = 0;
        Shaders.systemTime = 0L;
        Shaders.lastSystemTime = 0L;
        Shaders.diffSystemTime = 0L;
        Shaders.frameCounter = 0;
        Shaders.frameTime = 0.0f;
        Shaders.frameTimeCounter = 0.0f;
        Shaders.systemTimeInt32 = 0;
        Shaders.rainStrength = 0.0f;
        Shaders.wetness = 0.0f;
        Shaders.wetnessHalfLife = 600.0f;
        Shaders.drynessHalfLife = 200.0f;
        Shaders.eyeBrightnessHalflife = 10.0f;
        Shaders.usewetness = false;
        Shaders.isEyeInWater = 0;
        Shaders.eyeBrightness = 0;
        Shaders.eyeBrightnessFadeX = 0.0f;
        Shaders.eyeBrightnessFadeY = 0.0f;
        Shaders.eyePosY = 0.0f;
        Shaders.centerDepth = 0.0f;
        Shaders.centerDepthSmooth = 0.0f;
        Shaders.centerDepthSmoothHalflife = 1.0f;
        Shaders.centerDepthSmoothEnabled = false;
        Shaders.superSamplingLevel = 1;
        Shaders.nightVision = 0.0f;
        Shaders.blindness = 0.0f;
        Shaders.updateChunksErrorRecorded = false;
        Shaders.lightmapEnabled = false;
        Shaders.fogEnabled = true;
        Shaders.entityAttrib = 10;
        Shaders.midTexCoordAttrib = 11;
        Shaders.tangentAttrib = 12;
        Shaders.useEntityAttrib = false;
        Shaders.useMidTexCoordAttrib = false;
        Shaders.useMultiTexCoord3Attrib = false;
        Shaders.useTangentAttrib = false;
        Shaders.progUseEntityAttrib = false;
        Shaders.progUseMidTexCoordAttrib = false;
        Shaders.progUseTangentAttrib = false;
        Shaders.atlasSizeX = 0;
        Shaders.atlasSizeY = 0;
        Shaders.uniformEntityColor = new ShaderUniformFloat4("entityColor");
        Shaders.uniformEntityId = new ShaderUniformInt("entityId");
        Shaders.uniformBlockEntityId = new ShaderUniformInt("blockEntityId");
        Shaders.shadowPassInterval = 0;
        Shaders.needResizeShadow = false;
        Shaders.shadowMapWidth = 1024;
        Shaders.shadowMapHeight = 1024;
        Shaders.spShadowMapWidth = 1024;
        Shaders.spShadowMapHeight = 1024;
        Shaders.shadowMapFOV = 90.0f;
        Shaders.shadowMapHalfPlane = 160.0f;
        Shaders.shadowMapIsOrtho = true;
        Shaders.shadowDistanceRenderMul = -1.0f;
        Shaders.shadowPassCounter = 0;
        Shaders.shouldSkipDefaultShadow = false;
        Shaders.waterShadowEnabled = false;
        Shaders.usedColorBuffers = 0;
        Shaders.usedDepthBuffers = 0;
        Shaders.usedShadowColorBuffers = 0;
        Shaders.usedShadowDepthBuffers = 0;
        Shaders.usedColorAttachs = 0;
        Shaders.usedDrawBuffers = 0;
        Shaders.dfb = 0;
        Shaders.sfb = 0;
        Shaders.gbuffersFormat = new int[8];
        Shaders.gbuffersClear = new boolean[8];
        Shaders.activeProgram = 0;
        programNames = new String[] { "", "gbuffers_basic", "gbuffers_textured", "gbuffers_textured_lit", "gbuffers_skybasic", "gbuffers_skytextured", "gbuffers_clouds", "gbuffers_terrain", "gbuffers_terrain_solid", "gbuffers_terrain_cutout_mip", "gbuffers_terrain_cutout", "gbuffers_damagedblock", "gbuffers_water", "gbuffers_block", "gbuffers_beaconbeam", "gbuffers_item", "gbuffers_entities", "gbuffers_armor_glint", "gbuffers_spidereyes", "gbuffers_hand", "gbuffers_weather", "composite", "composite1", "composite2", "composite3", "composite4", "composite5", "composite6", "composite7", "final", "shadow", "shadow_solid", "shadow_cutout" };
        programBackups = new int[] { 0, 0, 1, 2, 1, 2, 2, 3, 7, 7, 7, 7, 7, 7, 2, 3, 3, 2, 2, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 30 };
        Shaders.programsID = new int[33];
        Shaders.programsRef = new int[33];
        Shaders.programIDCopyDepth = 0;
        Shaders.programsDrawBufSettings = new String[33];
        Shaders.newDrawBufSetting = null;
        Shaders.programsDrawBuffers = new IntBuffer[33];
        Shaders.activeDrawBuffers = null;
        Shaders.programsColorAtmSettings = new String[33];
        Shaders.newColorAtmSetting = null;
        Shaders.activeColorAtmSettings = null;
        Shaders.programsCompositeMipmapSetting = new int[33];
        Shaders.newCompositeMipmapSetting = 0;
        Shaders.activeCompositeMipmapSetting = 0;
        Shaders.loadedShaders = null;
        Shaders.shadersConfig = null;
        Shaders.defaultTexture = null;
        Shaders.normalMapEnabled = false;
        Shaders.shadowHardwareFilteringEnabled = new boolean[2];
        Shaders.shadowMipmapEnabled = new boolean[2];
        Shaders.shadowFilterNearest = new boolean[2];
        Shaders.shadowColorMipmapEnabled = new boolean[8];
        Shaders.shadowColorFilterNearest = new boolean[8];
        Shaders.configTweakBlockDamage = false;
        Shaders.configCloudShadow = false;
        Shaders.configHandDepthMul = 0.125f;
        Shaders.configRenderResMul = 1.0f;
        Shaders.configShadowResMul = 1.0f;
        Shaders.configTexMinFilB = 0;
        Shaders.configTexMinFilN = 0;
        Shaders.configTexMinFilS = 0;
        Shaders.configTexMagFilB = 0;
        Shaders.configTexMagFilN = 0;
        Shaders.configTexMagFilS = 0;
        Shaders.configShadowClipFrustrum = true;
        Shaders.configNormalMap = true;
        Shaders.configSpecularMap = true;
        Shaders.configOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
        Shaders.configOldHandLight = new PropertyDefaultTrueFalse("oldHandLight", "Old Hand Light", 0);
        Shaders.configAntialiasingLevel = 0;
        texMinFilDesc = new String[] { "Nearest", "Nearest-Nearest", "Nearest-Linear" };
        texMagFilDesc = new String[] { "Nearest", "Linear" };
        texMinFilValue = new int[] { 9728, 9984, 9986 };
        texMagFilValue = new int[] { 9728, 9729 };
        Shaders.shaderPack = null;
        Shaders.shaderPackLoaded = false;
        Shaders.packNameNone = "OFF";
        Shaders.packNameDefault = "(internal)";
        Shaders.shaderpacksdirname = "shaderpacks";
        Shaders.optionsfilename = "optionsshaders.txt";
        Shaders.shaderPackOptions = null;
        Shaders.shaderPackOptionSliders = null;
        Shaders.shaderPackProfiles = null;
        Shaders.shaderPackGuiScreens = null;
        Shaders.shaderPackClouds = new PropertyDefaultFastFancyOff("clouds", "Clouds", 0);
        Shaders.shaderPackOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
        Shaders.shaderPackOldHandLight = new PropertyDefaultTrueFalse("oldHandLight", "Old Hand Light", 0);
        Shaders.shaderPackDynamicHandLight = new PropertyDefaultTrueFalse("dynamicHandLight", "Dynamic Hand Light", 0);
        Shaders.shaderPackShadowTranslucent = new PropertyDefaultTrueFalse("shadowTranslucent", "Shadow Translucent", 0);
        Shaders.shaderPackUnderwaterOverlay = new PropertyDefaultTrueFalse("underwaterOverlay", "Underwater Overlay", 0);
        Shaders.shaderPackSun = new PropertyDefaultTrueFalse("sun", "Sun", 0);
        Shaders.shaderPackMoon = new PropertyDefaultTrueFalse("moon", "Moon", 0);
        Shaders.shaderPackVignette = new PropertyDefaultTrueFalse("vignette", "Vignette", 0);
        Shaders.shaderPackBackFaceSolid = new PropertyDefaultTrueFalse("backFace.solid", "Back-face Solid", 0);
        Shaders.shaderPackBackFaceCutout = new PropertyDefaultTrueFalse("backFace.cutout", "Back-face Cutout", 0);
        Shaders.shaderPackBackFaceCutoutMipped = new PropertyDefaultTrueFalse("backFace.cutoutMipped", "Back-face Cutout Mipped", 0);
        Shaders.shaderPackBackFaceTranslucent = new PropertyDefaultTrueFalse("backFace.translucent", "Back-face Translucent", 0);
        Shaders.shaderPackResources = new HashMap<String, String>();
        Shaders.currentWorld = null;
        Shaders.shaderPackDimensions = new ArrayList<Integer>();
        Shaders.customTexturesGbuffers = null;
        Shaders.customTexturesComposite = null;
        Shaders.noiseTexturePath = null;
        STAGE_NAMES = new String[] { "gbuffers", "composite" };
        saveFinalShaders = System.getProperty("shaders.debug.save", "false").equals("true");
        Shaders.blockLightLevel05 = 0.5f;
        Shaders.blockLightLevel06 = 0.6f;
        Shaders.blockLightLevel08 = 0.8f;
        Shaders.aoLevel = -1.0f;
        Shaders.sunPathRotation = 0.0f;
        Shaders.shadowAngleInterval = 0.0f;
        Shaders.fogMode = 0;
        Shaders.shadowIntervalSize = 2.0f;
        Shaders.terrainIconSize = 16;
        Shaders.terrainTextureSize = new int[2];
        Shaders.noiseTextureEnabled = false;
        Shaders.noiseTextureResolution = 256;
        dfbColorTexturesA = new int[16];
        colorTexturesToggle = new int[8];
        colorTextureTextureImageUnit = new int[] { 0, 1, 2, 3, 7, 8, 9, 10 };
        programsToggleColorTextures = new boolean[33][8];
        bigBuffer = (ByteBuffer)BufferUtils.createByteBuffer(2196).limit(0);
        faProjection = new float[16];
        faProjectionInverse = new float[16];
        faModelView = new float[16];
        faModelViewInverse = new float[16];
        faShadowProjection = new float[16];
        faShadowProjectionInverse = new float[16];
        faShadowModelView = new float[16];
        faShadowModelViewInverse = new float[16];
        projection = nextFloatBuffer(16);
        projectionInverse = nextFloatBuffer(16);
        modelView = nextFloatBuffer(16);
        modelViewInverse = nextFloatBuffer(16);
        shadowProjection = nextFloatBuffer(16);
        shadowProjectionInverse = nextFloatBuffer(16);
        shadowModelView = nextFloatBuffer(16);
        shadowModelViewInverse = nextFloatBuffer(16);
        previousProjection = nextFloatBuffer(16);
        previousModelView = nextFloatBuffer(16);
        tempMatrixDirectBuffer = nextFloatBuffer(16);
        tempDirectFloatBuffer = nextFloatBuffer(16);
        dfbColorTextures = nextIntBuffer(16);
        dfbDepthTextures = nextIntBuffer(3);
        sfbColorTextures = nextIntBuffer(8);
        sfbDepthTextures = nextIntBuffer(2);
        dfbDrawBuffers = nextIntBuffer(8);
        sfbDrawBuffers = nextIntBuffer(8);
        drawBuffersNone = nextIntBuffer(8);
        drawBuffersAll = nextIntBuffer(8);
        drawBuffersClear0 = nextIntBuffer(8);
        drawBuffersClear1 = nextIntBuffer(8);
        drawBuffersClearColor = nextIntBuffer(8);
        drawBuffersColorAtt0 = nextIntBuffer(8);
        drawBuffersBuffer = nextIntBufferArray(33, 8);
        formatNames = new String[] { "R8", "RG8", "RGB8", "RGBA8", "R8_SNORM", "RG8_SNORM", "RGB8_SNORM", "RGBA8_SNORM", "R16", "RG16", "RGB16", "RGBA16", "R16_SNORM", "RG16_SNORM", "RGB16_SNORM", "RGBA16_SNORM", "R16F", "RG16F", "RGB16F", "RGBA16F", "R32F", "RG32F", "RGB32F", "RGBA32F", "R32I", "RG32I", "RGB32I", "RGBA32I", "R32UI", "RG32UI", "RGB32UI", "RGBA32UI", "R3_G3_B2", "RGB5_A1", "RGB10_A2", "R11F_G11F_B10F", "RGB9_E5" };
        formatIds = new int[] { 33321, 33323, 32849, 32856, 36756, 36757, 36758, 36759, 33322, 33324, 32852, 32859, 36760, 36761, 36762, 36763, 33325, 33327, 34843, 34842, 33326, 33328, 34837, 34836, 33333, 33339, 36227, 36226, 33334, 33340, 36209, 36208, 10768, 32855, 32857, 35898, 35901 };
        patternLoadEntityDataMap = Pattern.compile("\\s*([\\w:]+)\\s*=\\s*([-]?\\d+)\\s*");
        Shaders.entityData = new int[32];
        Shaders.entityDataIndex = 0;
        Shaders.shadersdir = new File(Minecraft.getMinecraft().mcDataDir, "shaders");
        Shaders.shaderpacksdir = new File(Minecraft.getMinecraft().mcDataDir, Shaders.shaderpacksdirname);
        Shaders.configFile = new File(Minecraft.getMinecraft().mcDataDir, Shaders.optionsfilename);
        Shaders.drawBuffersNone.limit(0);
        Shaders.drawBuffersColorAtt0.put(36064).position(0).limit(1);
    }
    
    private static IntBuffer[] nextIntBufferArray(final int llllllllllllllIllIllIlIIIllIlIll, final int llllllllllllllIllIllIlIIIllIlIlI) {
        final IntBuffer[] llllllllllllllIllIllIlIIIllIlIIl = new IntBuffer[llllllllllllllIllIllIlIIIllIlIll];
        for (int llllllllllllllIllIllIlIIIllIlIII = 0; llllllllllllllIllIllIlIIIllIlIII < llllllllllllllIllIllIlIIIllIlIll; ++llllllllllllllIllIllIlIIIllIlIII) {
            llllllllllllllIllIllIlIIIllIlIIl[llllllllllllllIllIllIlIIIllIlIII] = nextIntBuffer(llllllllllllllIllIllIlIIIllIlIlI);
        }
        return llllllllllllllIllIllIlIIIllIlIIl;
    }
    
    private static int createVertShader(final String llllllllllllllIllIllIIIllIlIIIll) {
        final int llllllllllllllIllIllIIIllIlIlIll = ARBShaderObjects.glCreateShaderObjectARB(35633);
        if (llllllllllllllIllIllIIIllIlIlIll == 0) {
            return 0;
        }
        final StringBuilder llllllllllllllIllIllIIIllIlIlIlI = new StringBuilder(131072);
        BufferedReader llllllllllllllIllIllIIIllIlIlIIl = null;
        try {
            llllllllllllllIllIllIIIllIlIlIIl = new BufferedReader(new InputStreamReader(Shaders.shaderPack.getResourceAsStream(llllllllllllllIllIllIIIllIlIIIll)));
        }
        catch (Exception llllllllllllllIllIllIIIllIlIlIII) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIllIlIlIll);
            return 0;
        }
        final ShaderOption[] llllllllllllllIllIllIIIllIlIIlll = getChangedOptions(Shaders.shaderPackOptions);
        final List<String> llllllllllllllIllIllIIIllIlIIllI = new ArrayList<String>();
        if (llllllllllllllIllIllIIIllIlIlIIl != null) {
            try {
                llllllllllllllIllIllIIIllIlIlIIl = ShaderPackParser.resolveIncludes(llllllllllllllIllIllIIIllIlIlIIl, llllllllllllllIllIllIIIllIlIIIll, Shaders.shaderPack, 0, llllllllllllllIllIllIIIllIlIIllI, 0);
                while (true) {
                    String llllllllllllllIllIllIIIllIlIIlIl = llllllllllllllIllIllIIIllIlIlIIl.readLine();
                    if (llllllllllllllIllIllIIIllIlIIlIl == null) {
                        break;
                    }
                    llllllllllllllIllIllIIIllIlIIlIl = applyOptions(llllllllllllllIllIllIIIllIlIIlIl, llllllllllllllIllIllIIIllIlIIlll);
                    llllllllllllllIllIllIIIllIlIlIlI.append(llllllllllllllIllIllIIIllIlIIlIl).append('\n');
                    if (llllllllllllllIllIllIIIllIlIIlIl.matches("attribute [_a-zA-Z0-9]+ mc_Entity.*")) {
                        Shaders.useEntityAttrib = true;
                        Shaders.progUseEntityAttrib = true;
                    }
                    else if (llllllllllllllIllIllIIIllIlIIlIl.matches("attribute [_a-zA-Z0-9]+ mc_midTexCoord.*")) {
                        Shaders.useMidTexCoordAttrib = true;
                        Shaders.progUseMidTexCoordAttrib = true;
                    }
                    else if (llllllllllllllIllIllIIIllIlIIlIl.matches(".*gl_MultiTexCoord3.*")) {
                        Shaders.useMultiTexCoord3Attrib = true;
                    }
                    else {
                        if (!llllllllllllllIllIllIIIllIlIIlIl.matches("attribute [_a-zA-Z0-9]+ at_tangent.*")) {
                            continue;
                        }
                        Shaders.useTangentAttrib = true;
                        Shaders.progUseTangentAttrib = true;
                    }
                }
                llllllllllllllIllIllIIIllIlIlIIl.close();
            }
            catch (Exception llllllllllllllIllIllIIIllIlIIlII) {
                SMCLog.severe(String.valueOf(new StringBuilder("Couldn't read ").append(llllllllllllllIllIllIIIllIlIIIll).append("!")));
                llllllllllllllIllIllIIIllIlIIlII.printStackTrace();
                ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIllIlIlIll);
                return 0;
            }
        }
        if (Shaders.saveFinalShaders) {
            saveShader(llllllllllllllIllIllIIIllIlIIIll, String.valueOf(llllllllllllllIllIllIIIllIlIlIlI));
        }
        ARBShaderObjects.glShaderSourceARB(llllllllllllllIllIllIIIllIlIlIll, (CharSequence)llllllllllllllIllIllIIIllIlIlIlI);
        ARBShaderObjects.glCompileShaderARB(llllllllllllllIllIllIIIllIlIlIll);
        if (GL20.glGetShaderi(llllllllllllllIllIllIIIllIlIlIll, 35713) != 1) {
            SMCLog.severe(String.valueOf(new StringBuilder("Error compiling vertex shader: ").append(llllllllllllllIllIllIIIllIlIIIll)));
        }
        printShaderLogInfo(llllllllllllllIllIllIIIllIlIlIll, llllllllllllllIllIllIIIllIlIIIll, llllllllllllllIllIllIIIllIlIIllI);
        return llllllllllllllIllIllIIIllIlIlIll;
    }
    
    public static void postCelestialRotate() {
        final FloatBuffer llllllllllllllIllIlIlllllllIllII = Shaders.tempMatrixDirectBuffer;
        llllllllllllllIllIlIlllllllIllII.clear();
        GL11.glGetFloat(2982, llllllllllllllIllIlIlllllllIllII);
        llllllllllllllIllIlIlllllllIllII.get(Shaders.tempMat, 0, 16);
        SMath.multiplyMat4xVec4(Shaders.sunPosition, Shaders.tempMat, Shaders.sunPosModelView);
        SMath.multiplyMat4xVec4(Shaders.moonPosition, Shaders.tempMat, Shaders.moonPosModelView);
        System.arraycopy((Shaders.shadowAngle == Shaders.sunAngle) ? Shaders.sunPosition : Shaders.moonPosition, 0, Shaders.shadowLightPosition, 0, 3);
        setProgramUniform3f("sunPosition", Shaders.sunPosition[0], Shaders.sunPosition[1], Shaders.sunPosition[2]);
        setProgramUniform3f("moonPosition", Shaders.moonPosition[0], Shaders.moonPosition[1], Shaders.moonPosition[2]);
        setProgramUniform3f("shadowLightPosition", Shaders.shadowLightPosition[0], Shaders.shadowLightPosition[1], Shaders.shadowLightPosition[2]);
        checkGLError("postCelestialRotate");
    }
    
    public static void beginParticles() {
        useProgram(2);
    }
    
    public static void endParticles() {
        useProgram(3);
    }
    
    private static int getTextureIndex(final int llllllllllllllIllIllIIllllIlIIll, final String llllllllllllllIllIllIIllllIlIIlI) {
        if (llllllllllllllIllIllIIllllIlIIll == 0) {
            if (llllllllllllllIllIllIIllllIlIIlI.equals("texture")) {
                return 0;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("lightmap")) {
                return 1;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("normals")) {
                return 2;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("specular")) {
                return 3;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowtex0") || llllllllllllllIllIllIIllllIlIIlI.equals("watershadow")) {
                return 4;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadow")) {
                return Shaders.waterShadowEnabled ? 5 : 4;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowtex1")) {
                return 5;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("depthtex0")) {
                return 6;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("gaux1")) {
                return 7;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("gaux2")) {
                return 8;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("gaux3")) {
                return 9;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("gaux4")) {
                return 10;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("depthtex1")) {
                return 12;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowcolor0") || llllllllllllllIllIllIIllllIlIIlI.equals("shadowcolor")) {
                return 13;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowcolor1")) {
                return 14;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("noisetex")) {
                return 15;
            }
        }
        if (llllllllllllllIllIllIIllllIlIIll == 1) {
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex0") || llllllllllllllIllIllIIllllIlIIlI.equals("colortex0")) {
                return 0;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex1") || llllllllllllllIllIllIIllllIlIIlI.equals("gdepth")) {
                return 1;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex2") || llllllllllllllIllIllIIllllIlIIlI.equals("gnormal")) {
                return 2;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex3") || llllllllllllllIllIllIIllllIlIIlI.equals("composite")) {
                return 3;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowtex0") || llllllllllllllIllIllIIllllIlIIlI.equals("watershadow")) {
                return 4;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadow")) {
                return Shaders.waterShadowEnabled ? 5 : 4;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowtex1")) {
                return 5;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("depthtex0") || llllllllllllllIllIllIIllllIlIIlI.equals("gdepthtex")) {
                return 6;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex4") || llllllllllllllIllIllIIllllIlIIlI.equals("gaux1")) {
                return 7;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex5") || llllllllllllllIllIllIIllllIlIIlI.equals("gaux2")) {
                return 8;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex6") || llllllllllllllIllIllIIllllIlIIlI.equals("gaux3")) {
                return 9;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("colortex7") || llllllllllllllIllIllIIllllIlIIlI.equals("gaux4")) {
                return 10;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("depthtex1")) {
                return 11;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("depthtex2")) {
                return 12;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowcolor0") || llllllllllllllIllIllIIllllIlIIlI.equals("shadowcolor")) {
                return 13;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("shadowcolor1")) {
                return 14;
            }
            if (llllllllllllllIllIllIIllllIlIIlI.equals("noisetex")) {
                return 15;
            }
        }
        return -1;
    }
    
    public static int checkGLError(final String llllllllllllllIllIllIIlIlIllIIlI, final String llllllllllllllIllIllIIlIlIllIIIl, final String llllllllllllllIllIllIIlIlIlIlIIl) {
        final int llllllllllllllIllIllIIlIlIlIllll = GL11.glGetError();
        if (llllllllllllllIllIllIIlIlIlIllll != 0) {
            System.err.format("GL error 0x%04x: %s at %s %s %s\n", llllllllllllllIllIllIIlIlIlIllll, GLU.gluErrorString(llllllllllllllIllIllIIlIlIlIllll), llllllllllllllIllIllIIlIlIllIIlI, llllllllllllllIllIllIIlIlIllIIIl, llllllllllllllIllIllIIlIlIlIlIIl);
        }
        return llllllllllllllIllIllIIlIlIlIllll;
    }
    
    public static void setProgramUniform1f(final String llllllllllllllIllIllIIIIlllIIIll, final float llllllllllllllIllIllIIIIlllIIIlI) {
        final int llllllllllllllIllIllIIIIlllIIlIl = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllIllIllIIIIlllIIlIl != 0) {
            final int llllllllllllllIllIllIIIIlllIIlII = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIllIllIIIIlllIIlIl, (CharSequence)llllllllllllllIllIllIIIIlllIIIll);
            ARBShaderObjects.glUniform1fARB(llllllllllllllIllIllIIIIlllIIlII, llllllllllllllIllIllIIIIlllIIIlI);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllIllIllIIIIlllIIIll);
        }
    }
    
    public static boolean isItemToRenderMainTranslucent() {
        return Shaders.itemToRenderMainTranslucent;
    }
    
    public static String getEnumShaderOption(final EnumShaderOption llllllllllllllIllIllIlIIIIllIllI) {
        switch ($SWITCH_TABLE$shadersmod$client$EnumShaderOption()[llllllllllllllIllIllIlIIIIllIllI.ordinal()]) {
            case 1: {
                return Integer.toString(Shaders.configAntialiasingLevel);
            }
            case 2: {
                return Boolean.toString(Shaders.configNormalMap);
            }
            case 3: {
                return Boolean.toString(Shaders.configSpecularMap);
            }
            case 4: {
                return Float.toString(Shaders.configRenderResMul);
            }
            case 5: {
                return Float.toString(Shaders.configShadowResMul);
            }
            case 6: {
                return Float.toString(Shaders.configHandDepthMul);
            }
            case 7: {
                return Boolean.toString(Shaders.configCloudShadow);
            }
            case 8: {
                return Shaders.configOldHandLight.getPropertyValue();
            }
            case 9: {
                return Shaders.configOldLighting.getPropertyValue();
            }
            case 10: {
                return Shaders.currentshadername;
            }
            case 11: {
                return Boolean.toString(Shaders.configTweakBlockDamage);
            }
            case 12: {
                return Boolean.toString(Shaders.configShadowClipFrustrum);
            }
            case 13: {
                return Integer.toString(Shaders.configTexMinFilB);
            }
            case 14: {
                return Integer.toString(Shaders.configTexMinFilN);
            }
            case 15: {
                return Integer.toString(Shaders.configTexMinFilS);
            }
            case 16: {
                return Integer.toString(Shaders.configTexMagFilB);
            }
            case 17: {
                return Integer.toString(Shaders.configTexMagFilB);
            }
            case 18: {
                return Integer.toString(Shaders.configTexMagFilB);
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Unknown option: ").append(llllllllllllllIllIllIlIIIIllIllI)));
            }
        }
    }
    
    public static void setShaderPack(final String llllllllllllllIllIllIlIIIIllIIll) {
        Shaders.currentshadername = llllllllllllllIllIllIlIIIIllIIll;
        Shaders.shadersConfig.setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), llllllllllllllIllIllIlIIIIllIIll);
        loadShaderPack();
    }
    
    private static void deleteCustomTextures(final CustomTexture[] llllllllllllllIllIllIIlllIllllll) {
        if (llllllllllllllIllIllIIlllIllllll != null) {
            for (int llllllllllllllIllIllIIllllIIIIIl = 0; llllllllllllllIllIllIIllllIIIIIl < llllllllllllllIllIllIIlllIllllll.length; ++llllllllllllllIllIllIIllllIIIIIl) {
                final CustomTexture llllllllllllllIllIllIIllllIIIIII = llllllllllllllIllIllIIlllIllllll[llllllllllllllIllIllIIllllIIIIIl];
                llllllllllllllIllIllIIllllIIIIII.deleteTexture();
            }
        }
    }
    
    public static boolean isRenderBackFace(final BlockRenderLayer llllllllllllllIllIllIIlIIIIlIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$BlockRenderLayer()[llllllllllllllIllIllIIlIIIIlIIIl.ordinal()]) {
            case 1: {
                return Shaders.shaderPackBackFaceSolid.isTrue();
            }
            case 3: {
                return Shaders.shaderPackBackFaceCutout.isTrue();
            }
            case 2: {
                return Shaders.shaderPackBackFaceCutoutMipped.isTrue();
            }
            case 4: {
                return Shaders.shaderPackBackFaceTranslucent.isTrue();
            }
            default: {
                return false;
            }
        }
    }
    
    public static void nextBlockEntity(final TileEntity llllllllllllllIllIlIlllllIIlllII) {
        if (Shaders.isRenderingWorld) {
            checkGLError("nextBlockEntity");
            useProgram(13);
            setBlockEntityId(llllllllllllllIllIlIlllllIIlllII);
        }
    }
    
    public static void beginHand() {
        GL11.glMatrixMode(5888);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5889);
        GL11.glPushMatrix();
        GL11.glMatrixMode(5888);
        useProgram(19);
        checkGLError("beginHand");
        checkFramebufferStatus("beginHand");
    }
    
    public static void setHandsRendered(final boolean llllllllllllllIllIlIllllIIIIIlll, final boolean llllllllllllllIllIlIllllIIIIIlII) {
        Shaders.isHandRenderedMain = llllllllllllllIllIlIllllIIIIIlll;
        Shaders.isHandRenderedOff = llllllllllllllIllIlIllllIIIIIlII;
    }
    
    private static ShaderOption[] getVisibleOptions(final ShaderOption[] llllllllllllllIllIllIIllIllIIlIl) {
        final List<ShaderOption> llllllllllllllIllIllIIllIllIlIIl = new ArrayList<ShaderOption>();
        for (int llllllllllllllIllIllIIllIllIlIII = 0; llllllllllllllIllIllIIllIllIlIII < llllllllllllllIllIllIIllIllIIlIl.length; ++llllllllllllllIllIllIIllIllIlIII) {
            final ShaderOption llllllllllllllIllIllIIllIllIIlll = llllllllllllllIllIllIIllIllIIlIl[llllllllllllllIllIllIIllIllIlIII];
            if (llllllllllllllIllIllIIllIllIIlll.isVisible()) {
                llllllllllllllIllIllIIllIllIlIIl.add(llllllllllllllIllIllIIllIllIIlll);
            }
        }
        final ShaderOption[] llllllllllllllIllIllIIllIllIIllI = llllllllllllllIllIllIIllIllIlIIl.toArray(new ShaderOption[llllllllllllllIllIllIIllIllIlIIl.size()]);
        return llllllllllllllIllIllIIllIllIIllI;
    }
    
    public static boolean shouldRenderClouds(final GameSettings llllllllllllllIllIlIlllllIllIlIl) {
        if (!Shaders.shaderPackLoaded) {
            return true;
        }
        checkGLError("shouldRenderClouds");
        return Shaders.isShadowPass ? Shaders.configCloudShadow : (llllllllllllllIllIlIlllllIllIlIl.clouds > 0);
    }
    
    private static IntBuffer nextIntBuffer(final int llllllllllllllIllIllIlIIIllllllI) {
        final ByteBuffer llllllllllllllIllIllIlIIIlllllIl = Shaders.bigBuffer;
        final int llllllllllllllIllIllIlIIIlllllII = llllllllllllllIllIllIlIIIlllllIl.limit();
        llllllllllllllIllIllIlIIIlllllIl.position(llllllllllllllIllIllIlIIIlllllII).limit(llllllllllllllIllIllIlIIIlllllII + llllllllllllllIllIllIlIIIllllllI * 4);
        return llllllllllllllIllIllIlIIIlllllIl.asIntBuffer();
    }
    
    static ArrayList listOfShaders() {
        final ArrayList<String> llllllllllllllIllIllIIllIIIIIIIl = new ArrayList<String>();
        llllllllllllllIllIllIIllIIIIIIIl.add(Shaders.packNameNone);
        llllllllllllllIllIllIIllIIIIIIIl.add(Shaders.packNameDefault);
        try {
            if (!Shaders.shaderpacksdir.exists()) {
                Shaders.shaderpacksdir.mkdir();
            }
            final File[] llllllllllllllIllIllIIllIIIIIIII = Shaders.shaderpacksdir.listFiles();
            for (int llllllllllllllIllIllIIlIllllllll = 0; llllllllllllllIllIllIIlIllllllll < llllllllllllllIllIllIIllIIIIIIII.length; ++llllllllllllllIllIllIIlIllllllll) {
                final File llllllllllllllIllIllIIlIlllllllI = llllllllllllllIllIllIIllIIIIIIII[llllllllllllllIllIllIIlIllllllll];
                final String llllllllllllllIllIllIIlIllllllIl = llllllllllllllIllIllIIlIlllllllI.getName();
                if (llllllllllllllIllIllIIlIlllllllI.isDirectory()) {
                    final File llllllllllllllIllIllIIlIllllllII = new File(llllllllllllllIllIllIIlIlllllllI, "shaders");
                    if (llllllllllllllIllIllIIlIllllllII.exists() && llllllllllllllIllIllIIlIllllllII.isDirectory()) {
                        llllllllllllllIllIllIIllIIIIIIIl.add(llllllllllllllIllIllIIlIllllllIl);
                    }
                }
                else if (llllllllllllllIllIllIIlIlllllllI.isFile() && llllllllllllllIllIllIIlIllllllIl.toLowerCase().endsWith(".zip")) {
                    llllllllllllllIllIllIIllIIIIIIIl.add(llllllllllllllIllIllIIlIllllllIl);
                }
            }
        }
        catch (Exception ex) {}
        return llllllllllllllIllIllIIllIIIIIIIl;
    }
    
    public static void pushEntity(final int llllllllllllllIllIlIllllIllIIIll) {
        ++Shaders.entityDataIndex;
        Shaders.entityData[Shaders.entityDataIndex * 2] = (llllllllllllllIllIlIllllIllIIIll & 0xFFFF);
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }
    
    public static int getEntityData() {
        return Shaders.entityData[Shaders.entityDataIndex * 2];
    }
    
    public static void resetDisplayList() {
        ++Shaders.numberResetDisplayList;
        Shaders.needResetModels = true;
        SMCLog.info("Reset world renderers");
        Shaders.mc.renderGlobal.loadRenderers();
    }
    
    public static void beginUpdateChunks() {
        checkGLError("beginUpdateChunks1");
        checkFramebufferStatus("beginUpdateChunks1");
        if (!Shaders.isShadowPass) {
            useProgram(7);
        }
        checkGLError("beginUpdateChunks2");
        checkFramebufferStatus("beginUpdateChunks2");
    }
    
    private static void saveShaderPackOptions(final ShaderOption[] llllllllllllllIllIllIIllIlIlIllI, final IShaderPack llllllllllllllIllIllIIllIlIlIlIl) {
        final Properties llllllllllllllIllIllIIllIlIllIlI = new Properties();
        if (Shaders.shaderPackOptions != null) {
            for (int llllllllllllllIllIllIIllIlIllIIl = 0; llllllllllllllIllIllIIllIlIllIIl < llllllllllllllIllIllIIllIlIlIllI.length; ++llllllllllllllIllIllIIllIlIllIIl) {
                final ShaderOption llllllllllllllIllIllIIllIlIllIII = llllllllllllllIllIllIIllIlIlIllI[llllllllllllllIllIllIIllIlIllIIl];
                if (llllllllllllllIllIllIIllIlIllIII.isChanged() && llllllllllllllIllIllIIllIlIllIII.isEnabled()) {
                    llllllllllllllIllIllIIllIlIllIlI.setProperty(llllllllllllllIllIllIIllIlIllIII.getName(), llllllllllllllIllIllIIllIlIllIII.getValue());
                }
            }
        }
        try {
            saveOptionProperties(llllllllllllllIllIllIIllIlIlIlIl, llllllllllllllIllIllIIllIlIllIlI);
        }
        catch (IOException llllllllllllllIllIllIIllIlIlIlll) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Error saving configuration for ").append(Shaders.shaderPack.getName())));
            llllllllllllllIllIllIIllIlIlIlll.printStackTrace();
        }
    }
    
    public static String translate(final String llllllllllllllIllIlIllllIIllIIll, final String llllllllllllllIllIlIllllIIllIIlI) {
        final String llllllllllllllIllIlIllllIIllIIIl = Shaders.shaderPackResources.get(llllllllllllllIllIlIllllIIllIIll);
        return (llllllllllllllIllIlIllllIIllIIIl == null) ? llllllllllllllIllIlIllllIIllIIlI : llllllllllllllIllIlIllllIIllIIIl;
    }
    
    public static void setItemToRenderMain(final ItemStack llllllllllllllIllIlIllllIIlIIlIl) {
        Shaders.itemToRenderMainTranslucent = isTranslucentBlock(llllllllllllllIllIlIllllIIlIIlIl);
    }
    
    public static void printIntBuffer(final String llllllllllllllIllIllIIlIIllIlIll, final IntBuffer llllllllllllllIllIllIIlIIllIIlIl) {
        final StringBuilder llllllllllllllIllIllIIlIIllIlIIl = new StringBuilder(128);
        llllllllllllllIllIllIIlIIllIlIIl.append(llllllllllllllIllIllIIlIIllIlIll).append(" [pos ").append(llllllllllllllIllIllIIlIIllIIlIl.position()).append(" lim ").append(llllllllllllllIllIllIIlIIllIIlIl.limit()).append(" cap ").append(llllllllllllllIllIllIIlIIllIIlIl.capacity()).append(" :");
        for (int llllllllllllllIllIllIIlIIllIlIII = llllllllllllllIllIllIIlIIllIIlIl.limit(), llllllllllllllIllIllIIlIIllIIlll = 0; llllllllllllllIllIllIIlIIllIIlll < llllllllllllllIllIllIIlIIllIlIII; ++llllllllllllllIllIllIIlIIllIIlll) {
            llllllllllllllIllIllIIlIIllIlIIl.append(" ").append(llllllllllllllIllIllIIlIIllIIlIl.get(llllllllllllllIllIllIIlIIllIIlll));
        }
        llllllllllllllIllIllIIlIIllIlIIl.append("]");
        SMCLog.info(String.valueOf(llllllllllllllIllIllIIlIIllIlIIl));
    }
    
    public static void setEntityId(final Entity llllllllllllllIllIlIlllllIlIllII) {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass && Shaders.uniformEntityId.isDefined()) {
            final int llllllllllllllIllIlIlllllIlIllIl = EntityUtils.getEntityIdByClass(llllllllllllllIllIlIlllllIlIllII);
            Shaders.uniformEntityId.setValue(llllllllllllllIllIlIlllllIlIllIl);
        }
    }
    
    public static boolean isDynamicHandLight() {
        return Shaders.shaderPackDynamicHandLight.isDefault() || Shaders.shaderPackDynamicHandLight.isTrue();
    }
    
    public static void disableTexture2D() {
        if (Shaders.isRenderingSky) {
            useProgram(4);
        }
        else if (Shaders.activeProgram == 2 || Shaders.activeProgram == 3) {
            useProgram(1);
        }
    }
    
    public static void checkShadersModInstalled() {
        try {
            Class.forName("shadersmod.transform.SMCClassTransformer");
        }
        catch (Throwable llllllllllllllIllIlIllllIlIllIII) {
            return;
        }
        throw new RuntimeException("Shaders Mod detected. Please remove it, OptiFine has built-in support for shaders.");
    }
    
    public static void uninit() {
        if (Shaders.isShaderPackInitialized) {
            checkGLError("Shaders.uninit pre");
            for (int llllllllllllllIllIllIIIIlIIIlllI = 0; llllllllllllllIllIllIIIIlIIIlllI < 33; ++llllllllllllllIllIllIIIIlIIIlllI) {
                if (Shaders.programsRef[llllllllllllllIllIllIIIIlIIIlllI] != 0) {
                    ARBShaderObjects.glDeleteObjectARB(Shaders.programsRef[llllllllllllllIllIllIIIIlIIIlllI]);
                    checkGLError("del programRef");
                }
                Shaders.programsRef[llllllllllllllIllIllIIIIlIIIlllI] = 0;
                Shaders.programsID[llllllllllllllIllIllIIIIlIIIlllI] = 0;
                Shaders.programsDrawBufSettings[llllllllllllllIllIllIIIIlIIIlllI] = null;
                Shaders.programsDrawBuffers[llllllllllllllIllIllIIIIlIIIlllI] = null;
                Shaders.programsCompositeMipmapSetting[llllllllllllllIllIllIIIIlIIIlllI] = 0;
            }
            if (Shaders.dfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.dfb);
                Shaders.dfb = 0;
                checkGLError("del dfb");
            }
            if (Shaders.sfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.sfb);
                Shaders.sfb = 0;
                checkGLError("del sfb");
            }
            if (Shaders.dfbDepthTextures != null) {
                GlStateManager.deleteTextures(Shaders.dfbDepthTextures);
                fillIntBufferZero(Shaders.dfbDepthTextures);
                checkGLError("del dfbDepthTextures");
            }
            if (Shaders.dfbColorTextures != null) {
                GlStateManager.deleteTextures(Shaders.dfbColorTextures);
                fillIntBufferZero(Shaders.dfbColorTextures);
                checkGLError("del dfbTextures");
            }
            if (Shaders.sfbDepthTextures != null) {
                GlStateManager.deleteTextures(Shaders.sfbDepthTextures);
                fillIntBufferZero(Shaders.sfbDepthTextures);
                checkGLError("del shadow depth");
            }
            if (Shaders.sfbColorTextures != null) {
                GlStateManager.deleteTextures(Shaders.sfbColorTextures);
                fillIntBufferZero(Shaders.sfbColorTextures);
                checkGLError("del shadow color");
            }
            if (Shaders.dfbDrawBuffers != null) {
                fillIntBufferZero(Shaders.dfbDrawBuffers);
            }
            if (Shaders.noiseTexture != null) {
                Shaders.noiseTexture.deleteTexture();
                Shaders.noiseTexture = null;
            }
            SMCLog.info("Uninit");
            Shaders.shadowPassInterval = 0;
            Shaders.shouldSkipDefaultShadow = false;
            Shaders.isShaderPackInitialized = false;
            checkGLError("Shaders.uninit");
        }
    }
    
    public static void endFPOverlay() {
    }
    
    public static void endWeather() {
        GlStateManager.disableBlend();
        useProgram(3);
    }
    
    public static void setFog(final GlStateManager.FogMode llllllllllllllIllIlIllllIllllIII) {
        GlStateManager.setFog(llllllllllllllIllIlIllllIllllIII);
        if (Shaders.fogEnabled) {
            setProgramUniform1i("fogMode", llllllllllllllIllIlIllllIllllIII.capabilityId);
        }
    }
    
    public static ShaderOption[] getChangedOptions(final ShaderOption[] llllllllllllllIllIllIIllIIIlllll) {
        final List<ShaderOption> llllllllllllllIllIllIIllIIIllllI = new ArrayList<ShaderOption>();
        for (int llllllllllllllIllIllIIllIIIlllIl = 0; llllllllllllllIllIllIIllIIIlllIl < llllllllllllllIllIllIIllIIIlllll.length; ++llllllllllllllIllIllIIllIIIlllIl) {
            final ShaderOption llllllllllllllIllIllIIllIIIlllII = llllllllllllllIllIllIIllIIIlllll[llllllllllllllIllIllIIllIIIlllIl];
            if (llllllllllllllIllIllIIllIIIlllII.isEnabled() && llllllllllllllIllIllIIllIIIlllII.isChanged()) {
                llllllllllllllIllIllIIllIIIllllI.add(llllllllllllllIllIllIIllIIIlllII);
            }
        }
        final ShaderOption[] llllllllllllllIllIllIIllIIIllIll = llllllllllllllIllIllIIllIIIllllI.toArray(new ShaderOption[llllllllllllllIllIllIIllIIIllllI.size()]);
        return llllllllllllllIllIllIIllIIIllIll;
    }
    
    public static boolean isOldHandLight() {
        if (!Shaders.configOldHandLight.isDefault()) {
            return Shaders.configOldHandLight.isTrue();
        }
        return Shaders.shaderPackOldHandLight.isDefault() || Shaders.shaderPackOldHandLight.isTrue();
    }
    
    public static void endRender() {
        if (Shaders.isShadowPass) {
            checkGLError("shadow endRender");
        }
        else {
            if (!Shaders.isCompositeRendered) {
                renderCompositeFinal();
            }
            Shaders.isRenderingWorld = false;
            GlStateManager.colorMask(true, true, true, true);
            useProgram(0);
            RenderHelper.disableStandardItemLighting();
            checkGLError("endRender end");
        }
    }
    
    public static boolean isSun() {
        return !Shaders.shaderPackSun.isFalse();
    }
    
    public static void setRenderingFirstPersonHand(final boolean llllllllllllllIllIlIllllIIIIIIlI) {
        Shaders.isRenderingFirstPersonHand = llllllllllllllIllIlIllllIIIIIIlI;
    }
    
    public static void enableTexture2D() {
        if (Shaders.isRenderingSky) {
            useProgram(5);
        }
        else if (Shaders.activeProgram == 1) {
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
        }
    }
    
    public static void endClouds() {
        disableFog();
        popEntity();
        useProgram(Shaders.lightmapEnabled ? 3 : 2);
    }
    
    public static void sglEnableT2D(final int llllllllllllllIllIlIlllllIIIIlII) {
        GL11.glEnable(llllllllllllllIllIlIlllllIIIIlII);
        enableTexture2D();
    }
    
    public static void beginFPOverlay() {
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$BlockRenderLayer() {
        final int[] $switch_TABLE$net$minecraft$util$BlockRenderLayer = Shaders.$SWITCH_TABLE$net$minecraft$util$BlockRenderLayer;
        if ($switch_TABLE$net$minecraft$util$BlockRenderLayer != null) {
            return $switch_TABLE$net$minecraft$util$BlockRenderLayer;
        }
        final double llllllllllllllIllIlIlllIllllllIl = (Object)new int[BlockRenderLayer.values().length];
        try {
            llllllllllllllIllIlIlllIllllllIl[BlockRenderLayer.CUTOUT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIlIlllIllllllIl[BlockRenderLayer.CUTOUT_MIPPED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIlIlllIllllllIl[BlockRenderLayer.SOLID.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIllIlIlllIllllllIl[BlockRenderLayer.TRANSLUCENT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return Shaders.$SWITCH_TABLE$net$minecraft$util$BlockRenderLayer = (int[])(Object)llllllllllllllIllIlIlllIllllllIl;
    }
    
    private static ShaderOption[] loadShaderPackOptions() {
        try {
            final ShaderOption[] llllllllllllllIllIllIIllIIllllIl = ShaderPackParser.parseShaderPackOptions(Shaders.shaderPack, Shaders.programNames, Shaders.shaderPackDimensions);
            final Properties llllllllllllllIllIllIIllIIllllII = loadOptionProperties(Shaders.shaderPack);
            for (int llllllllllllllIllIllIIllIIlllIll = 0; llllllllllllllIllIllIIllIIlllIll < llllllllllllllIllIllIIllIIllllIl.length; ++llllllllllllllIllIllIIllIIlllIll) {
                final ShaderOption llllllllllllllIllIllIIllIIlllIlI = llllllllllllllIllIllIIllIIllllIl[llllllllllllllIllIllIIllIIlllIll];
                final String llllllllllllllIllIllIIllIIlllIIl = llllllllllllllIllIllIIllIIllllII.getProperty(llllllllllllllIllIllIIllIIlllIlI.getName());
                if (llllllllllllllIllIllIIllIIlllIIl != null) {
                    llllllllllllllIllIllIIllIIlllIlI.resetValue();
                    if (!llllllllllllllIllIllIIllIIlllIlI.setValue(llllllllllllllIllIllIIllIIlllIIl)) {
                        Config.warn(String.valueOf(new StringBuilder("[Shaders] Invalid value, option: ").append(llllllllllllllIllIllIIllIIlllIlI.getName()).append(", value: ").append(llllllllllllllIllIllIIllIIlllIIl)));
                    }
                }
            }
            return llllllllllllllIllIllIIllIIllllIl;
        }
        catch (IOException llllllllllllllIllIllIIllIIlllIII) {
            Config.warn(String.valueOf(new StringBuilder("[Shaders] Error reading configuration for ").append(Shaders.shaderPack.getName())));
            llllllllllllllIllIllIIllIIlllIII.printStackTrace();
            return null;
        }
    }
    
    private static int createFragShader(final String llllllllllllllIllIllIIIlIllllIlI) {
        final int llllllllllllllIllIllIIIllIIIllll = ARBShaderObjects.glCreateShaderObjectARB(35632);
        if (llllllllllllllIllIllIIIllIIIllll == 0) {
            return 0;
        }
        final StringBuilder llllllllllllllIllIllIIIllIIIlllI = new StringBuilder(131072);
        BufferedReader llllllllllllllIllIllIIIllIIIllIl = null;
        try {
            llllllllllllllIllIllIIIllIIIllIl = new BufferedReader(new InputStreamReader(Shaders.shaderPack.getResourceAsStream(llllllllllllllIllIllIIIlIllllIlI)));
        }
        catch (Exception llllllllllllllIllIllIIIllIIIllII) {
            ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIllIIIllll);
            return 0;
        }
        final ShaderOption[] llllllllllllllIllIllIIIllIIIlIll = getChangedOptions(Shaders.shaderPackOptions);
        final List<String> llllllllllllllIllIllIIIllIIIlIlI = new ArrayList<String>();
        if (llllllllllllllIllIllIIIllIIIllIl != null) {
            try {
                llllllllllllllIllIllIIIllIIIllIl = ShaderPackParser.resolveIncludes(llllllllllllllIllIllIIIllIIIllIl, llllllllllllllIllIllIIIlIllllIlI, Shaders.shaderPack, 0, llllllllllllllIllIllIIIllIIIlIlI, 0);
                while (true) {
                    String llllllllllllllIllIllIIIllIIIlIIl = llllllllllllllIllIllIIIllIIIllIl.readLine();
                    if (llllllllllllllIllIllIIIllIIIlIIl == null) {
                        break;
                    }
                    llllllllllllllIllIllIIIllIIIlIIl = applyOptions(llllllllllllllIllIllIIIllIIIlIIl, llllllllllllllIllIllIIIllIIIlIll);
                    llllllllllllllIllIllIIIllIIIlllI.append(llllllllllllllIllIllIIIllIIIlIIl).append('\n');
                    final ShaderLine llllllllllllllIllIllIIIllIIIlIII = ShaderParser.parseLine(llllllllllllllIllIllIIIllIIIlIIl);
                    if (llllllllllllllIllIllIIIllIIIlIII == null) {
                        continue;
                    }
                    if (llllllllllllllIllIllIIIllIIIlIII.isUniform()) {
                        final String llllllllllllllIllIllIIIllIIIIlll = llllllllllllllIllIllIIIllIIIlIII.getName();
                        int llllllllllllllIllIllIIIllIIIIllI;
                        if ((llllllllllllllIllIllIIIllIIIIllI = ShaderParser.getShadowDepthIndex(llllllllllllllIllIllIIIllIIIIlll)) >= 0) {
                            Shaders.usedShadowDepthBuffers = Math.max(Shaders.usedShadowDepthBuffers, llllllllllllllIllIllIIIllIIIIllI + 1);
                        }
                        else if ((llllllllllllllIllIllIIIllIIIIllI = ShaderParser.getShadowColorIndex(llllllllllllllIllIllIIIllIIIIlll)) >= 0) {
                            Shaders.usedShadowColorBuffers = Math.max(Shaders.usedShadowColorBuffers, llllllllllllllIllIllIIIllIIIIllI + 1);
                        }
                        else if ((llllllllllllllIllIllIIIllIIIIllI = ShaderParser.getDepthIndex(llllllllllllllIllIllIIIllIIIIlll)) >= 0) {
                            Shaders.usedDepthBuffers = Math.max(Shaders.usedDepthBuffers, llllllllllllllIllIllIIIllIIIIllI + 1);
                        }
                        else if (llllllllllllllIllIllIIIllIIIIlll.equals("gdepth") && Shaders.gbuffersFormat[1] == 6408) {
                            Shaders.gbuffersFormat[1] = 34836;
                        }
                        else if ((llllllllllllllIllIllIIIllIIIIllI = ShaderParser.getColorIndex(llllllllllllllIllIllIIIllIIIIlll)) >= 0) {
                            Shaders.usedColorBuffers = Math.max(Shaders.usedColorBuffers, llllllllllllllIllIllIIIllIIIIllI + 1);
                        }
                        else {
                            if (!llllllllllllllIllIllIIIllIIIIlll.equals("centerDepthSmooth")) {
                                continue;
                            }
                            Shaders.centerDepthSmoothEnabled = true;
                        }
                    }
                    else if (!llllllllllllllIllIllIIIllIIIlIII.isConstInt("shadowMapResolution") && !llllllllllllllIllIllIIIllIIIlIII.isComment("SHADOWRES")) {
                        if (!llllllllllllllIllIllIIIllIIIlIII.isConstFloat("shadowMapFov") && !llllllllllllllIllIllIIIllIIIlIII.isComment("SHADOWFOV")) {
                            if (!llllllllllllllIllIllIIIllIIIlIII.isConstFloat("shadowDistance") && !llllllllllllllIllIllIIIllIIIlIII.isComment("SHADOWHPL")) {
                                if (llllllllllllllIllIllIIIllIIIlIII.isConstFloat("shadowDistanceRenderMul")) {
                                    Shaders.shadowDistanceRenderMul = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                    SMCLog.info(String.valueOf(new StringBuilder("Shadow distance render mul: ").append(Shaders.shadowDistanceRenderMul)));
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstFloat("shadowIntervalSize")) {
                                    Shaders.shadowIntervalSize = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                    SMCLog.info(String.valueOf(new StringBuilder("Shadow map interval size: ").append(Shaders.shadowIntervalSize)));
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("generateShadowMipmap", true)) {
                                    Arrays.fill(Shaders.shadowMipmapEnabled, true);
                                    SMCLog.info("Generate shadow mipmap");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("generateShadowColorMipmap", true)) {
                                    Arrays.fill(Shaders.shadowColorMipmapEnabled, true);
                                    SMCLog.info("Generate shadow color mipmap");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowHardwareFiltering", true)) {
                                    Arrays.fill(Shaders.shadowHardwareFilteringEnabled, true);
                                    SMCLog.info("Hardware shadow filtering enabled.");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowHardwareFiltering0", true)) {
                                    Shaders.shadowHardwareFilteringEnabled[0] = true;
                                    SMCLog.info("shadowHardwareFiltering0");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowHardwareFiltering1", true)) {
                                    Shaders.shadowHardwareFilteringEnabled[1] = true;
                                    SMCLog.info("shadowHardwareFiltering1");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowtex0Mipmap", "shadowtexMipmap", true)) {
                                    Shaders.shadowMipmapEnabled[0] = true;
                                    SMCLog.info("shadowtex0Mipmap");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowtex1Mipmap", true)) {
                                    Shaders.shadowMipmapEnabled[1] = true;
                                    SMCLog.info("shadowtex1Mipmap");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowcolor0Mipmap", "shadowColor0Mipmap", true)) {
                                    Shaders.shadowColorMipmapEnabled[0] = true;
                                    SMCLog.info("shadowcolor0Mipmap");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowcolor1Mipmap", "shadowColor1Mipmap", true)) {
                                    Shaders.shadowColorMipmapEnabled[1] = true;
                                    SMCLog.info("shadowcolor1Mipmap");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowtex0Nearest", "shadowtexNearest", "shadow0MinMagNearest", true)) {
                                    Shaders.shadowFilterNearest[0] = true;
                                    SMCLog.info("shadowtex0Nearest");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowtex1Nearest", "shadow1MinMagNearest", true)) {
                                    Shaders.shadowFilterNearest[1] = true;
                                    SMCLog.info("shadowtex1Nearest");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowcolor0Nearest", "shadowColor0Nearest", "shadowColor0MinMagNearest", true)) {
                                    Shaders.shadowColorFilterNearest[0] = true;
                                    SMCLog.info("shadowcolor0Nearest");
                                }
                                else if (llllllllllllllIllIllIIIllIIIlIII.isConstBool("shadowcolor1Nearest", "shadowColor1Nearest", "shadowColor1MinMagNearest", true)) {
                                    Shaders.shadowColorFilterNearest[1] = true;
                                    SMCLog.info("shadowcolor1Nearest");
                                }
                                else if (!llllllllllllllIllIllIIIllIIIlIII.isConstFloat("wetnessHalflife") && !llllllllllllllIllIllIIIllIIIlIII.isComment("WETNESSHL")) {
                                    if (!llllllllllllllIllIllIIIllIIIlIII.isConstFloat("drynessHalflife") && !llllllllllllllIllIllIIIllIIIlIII.isComment("DRYNESSHL")) {
                                        if (llllllllllllllIllIllIIIllIIIlIII.isConstFloat("eyeBrightnessHalflife")) {
                                            Shaders.eyeBrightnessHalflife = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                            SMCLog.info(String.valueOf(new StringBuilder("Eye brightness halflife: ").append(Shaders.eyeBrightnessHalflife)));
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstFloat("centerDepthHalflife")) {
                                            Shaders.centerDepthSmoothHalflife = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                            SMCLog.info(String.valueOf(new StringBuilder("Center depth halflife: ").append(Shaders.centerDepthSmoothHalflife)));
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstFloat("sunPathRotation")) {
                                            Shaders.sunPathRotation = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                            SMCLog.info(String.valueOf(new StringBuilder("Sun path rotation: ").append(Shaders.sunPathRotation)));
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstFloat("ambientOcclusionLevel")) {
                                            Shaders.aoLevel = Config.limit(llllllllllllllIllIllIIIllIIIlIII.getValueFloat(), 0.0f, 1.0f);
                                            SMCLog.info(String.valueOf(new StringBuilder("AO Level: ").append(Shaders.aoLevel)));
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstInt("superSamplingLevel")) {
                                            final int llllllllllllllIllIllIIIllIIIIlIl = llllllllllllllIllIllIIIllIIIlIII.getValueInt();
                                            if (llllllllllllllIllIllIIIllIIIIlIl > 1) {
                                                SMCLog.info(String.valueOf(new StringBuilder("Super sampling level: ").append(llllllllllllllIllIllIIIllIIIIlIl).append("x")));
                                                Shaders.superSamplingLevel = llllllllllllllIllIllIIIllIIIIlIl;
                                            }
                                            else {
                                                Shaders.superSamplingLevel = 1;
                                            }
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstInt("noiseTextureResolution")) {
                                            Shaders.noiseTextureResolution = llllllllllllllIllIllIIIllIIIlIII.getValueInt();
                                            Shaders.noiseTextureEnabled = true;
                                            SMCLog.info("Noise texture enabled");
                                            SMCLog.info(String.valueOf(new StringBuilder("Noise texture resolution: ").append(Shaders.noiseTextureResolution)));
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstIntSuffix("Format")) {
                                            final String llllllllllllllIllIllIIIllIIIIlII = StrUtils.removeSuffix(llllllllllllllIllIllIIIllIIIlIII.getName(), "Format");
                                            final String llllllllllllllIllIllIIIllIIIIIll = llllllllllllllIllIllIIIllIIIlIII.getValue();
                                            final int llllllllllllllIllIllIIIllIIIIIlI = getBufferIndexFromString(llllllllllllllIllIllIIIllIIIIlII);
                                            final int llllllllllllllIllIllIIIllIIIIIIl = getTextureFormatFromString(llllllllllllllIllIllIIIllIIIIIll);
                                            if (llllllllllllllIllIllIIIllIIIIIlI < 0 || llllllllllllllIllIllIIIllIIIIIIl == 0) {
                                                continue;
                                            }
                                            Shaders.gbuffersFormat[llllllllllllllIllIllIIIllIIIIIlI] = llllllllllllllIllIllIIIllIIIIIIl;
                                            SMCLog.info("%s format: %s", llllllllllllllIllIllIIIllIIIIlII, llllllllllllllIllIllIIIllIIIIIll);
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstBoolSuffix("Clear", false)) {
                                            if (!ShaderParser.isComposite(llllllllllllllIllIllIIIlIllllIlI)) {
                                                continue;
                                            }
                                            final String llllllllllllllIllIllIIIllIIIIIII = StrUtils.removeSuffix(llllllllllllllIllIllIIIllIIIlIII.getName(), "Clear");
                                            final int llllllllllllllIllIllIIIlIlllllll = getBufferIndexFromString(llllllllllllllIllIllIIIllIIIIIII);
                                            if (llllllllllllllIllIllIIIlIlllllll < 0) {
                                                continue;
                                            }
                                            Shaders.gbuffersClear[llllllllllllllIllIllIIIlIlllllll] = false;
                                            SMCLog.info("%s clear disabled", llllllllllllllIllIllIIIllIIIIIII);
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isComment("GAUX4FORMAT", "RGBA32F")) {
                                            Shaders.gbuffersFormat[7] = 34836;
                                            SMCLog.info("gaux4 format : RGB32AF");
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isComment("GAUX4FORMAT", "RGB32F")) {
                                            Shaders.gbuffersFormat[7] = 34837;
                                            SMCLog.info("gaux4 format : RGB32F");
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isComment("GAUX4FORMAT", "RGB16")) {
                                            Shaders.gbuffersFormat[7] = 32852;
                                            SMCLog.info("gaux4 format : RGB16");
                                        }
                                        else if (llllllllllllllIllIllIIIllIIIlIII.isConstBoolSuffix("MipmapEnabled", true)) {
                                            if (!ShaderParser.isComposite(llllllllllllllIllIllIIIlIllllIlI) && !ShaderParser.isFinal(llllllllllllllIllIllIIIlIllllIlI)) {
                                                continue;
                                            }
                                            final String llllllllllllllIllIllIIIlIllllllI = StrUtils.removeSuffix(llllllllllllllIllIllIIIllIIIlIII.getName(), "MipmapEnabled");
                                            final int llllllllllllllIllIllIIIlIlllllIl = getBufferIndexFromString(llllllllllllllIllIllIIIlIllllllI);
                                            if (llllllllllllllIllIllIIIlIlllllIl < 0) {
                                                continue;
                                            }
                                            Shaders.newCompositeMipmapSetting |= 1 << llllllllllllllIllIllIIIlIlllllIl;
                                            SMCLog.info("%s mipmap enabled", llllllllllllllIllIllIIIlIllllllI);
                                        }
                                        else {
                                            if (!llllllllllllllIllIllIIIllIIIlIII.isComment("DRAWBUFFERS")) {
                                                continue;
                                            }
                                            final String llllllllllllllIllIllIIIlIlllllII = llllllllllllllIllIllIIIllIIIlIII.getValue();
                                            if (ShaderParser.isValidDrawBuffers(llllllllllllllIllIllIIIlIlllllII)) {
                                                Shaders.newDrawBufSetting = llllllllllllllIllIllIIIlIlllllII;
                                            }
                                            else {
                                                SMCLog.warning(String.valueOf(new StringBuilder("Invalid draw buffers: ").append(llllllllllllllIllIllIIIlIlllllII)));
                                            }
                                        }
                                    }
                                    else {
                                        Shaders.drynessHalfLife = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                        SMCLog.info(String.valueOf(new StringBuilder("Dryness halflife: ").append(Shaders.drynessHalfLife)));
                                    }
                                }
                                else {
                                    Shaders.wetnessHalfLife = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                    SMCLog.info(String.valueOf(new StringBuilder("Wetness halflife: ").append(Shaders.wetnessHalfLife)));
                                }
                            }
                            else {
                                Shaders.shadowMapHalfPlane = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                                Shaders.shadowMapIsOrtho = true;
                                SMCLog.info(String.valueOf(new StringBuilder("Shadow map distance: ").append(Shaders.shadowMapHalfPlane)));
                            }
                        }
                        else {
                            Shaders.shadowMapFOV = llllllllllllllIllIllIIIllIIIlIII.getValueFloat();
                            Shaders.shadowMapIsOrtho = false;
                            SMCLog.info(String.valueOf(new StringBuilder("Shadow map field of view: ").append(Shaders.shadowMapFOV)));
                        }
                    }
                    else {
                        Shaders.spShadowMapWidth = (Shaders.spShadowMapHeight = llllllllllllllIllIllIIIllIIIlIII.getValueInt());
                        Shaders.shadowMapWidth = (Shaders.shadowMapHeight = Math.round(Shaders.spShadowMapWidth * Shaders.configShadowResMul));
                        SMCLog.info(String.valueOf(new StringBuilder("Shadow map resolution: ").append(Shaders.spShadowMapWidth)));
                    }
                }
                llllllllllllllIllIllIIIllIIIllIl.close();
            }
            catch (Exception llllllllllllllIllIllIIIlIllllIll) {
                SMCLog.severe(String.valueOf(new StringBuilder("Couldn't read ").append(llllllllllllllIllIllIIIlIllllIlI).append("!")));
                llllllllllllllIllIllIIIlIllllIll.printStackTrace();
                ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIllIIIllll);
                return 0;
            }
        }
        if (Shaders.saveFinalShaders) {
            saveShader(llllllllllllllIllIllIIIlIllllIlI, String.valueOf(llllllllllllllIllIllIIIllIIIlllI));
        }
        ARBShaderObjects.glShaderSourceARB(llllllllllllllIllIllIIIllIIIllll, (CharSequence)llllllllllllllIllIllIIIllIIIlllI);
        ARBShaderObjects.glCompileShaderARB(llllllllllllllIllIllIIIllIIIllll);
        if (GL20.glGetShaderi(llllllllllllllIllIllIIIllIIIllll, 35713) != 1) {
            SMCLog.severe(String.valueOf(new StringBuilder("Error compiling fragment shader: ").append(llllllllllllllIllIllIIIlIllllIlI)));
        }
        printShaderLogInfo(llllllllllllllIllIllIIIllIIIllll, llllllllllllllIllIllIIIlIllllIlI, llllllllllllllIllIllIIIllIIIlIlI);
        return llllllllllllllIllIllIIIllIIIllll;
    }
    
    public static void applyHandDepth() {
        if (Shaders.configHandDepthMul != 1.0) {
            GL11.glScaled(1.0, 1.0, (double)Shaders.configHandDepthMul);
        }
    }
    
    public static void saveShaderPackOptions() {
        saveShaderPackOptions(Shaders.shaderPackOptions, Shaders.shaderPack);
    }
    
    public static void endEntities() {
        if (Shaders.isRenderingWorld) {
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
        }
    }
    
    public static void endSky() {
        Shaders.isRenderingSky = false;
        setDrawBuffers(Shaders.dfbDrawBuffers);
        useProgram(Shaders.lightmapEnabled ? 3 : 2);
        popEntity();
    }
    
    public static void beginRenderPass(final int llllllllllllllIllIllIIIIIlIIlIlI, final float llllllllllllllIllIllIIIIIlIIlIIl, final long llllllllllllllIllIllIIIIIlIIlIII) {
        if (!Shaders.isShadowPass) {
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
            GL11.glViewport(0, 0, Shaders.renderWidth, Shaders.renderHeight);
            Shaders.activeDrawBuffers = null;
            ShadersTex.bindNSTextures(Shaders.defaultTexture.getMultiTexID());
            useProgram(2);
            checkGLError("end beginRenderPass");
        }
    }
    
    public static float getShadowRenderDistance() {
        return (Shaders.shadowDistanceRenderMul < 0.0f) ? -1.0f : (Shaders.shadowMapHalfPlane * Shaders.shadowDistanceRenderMul);
    }
    
    private static void saveShader(final String llllllllllllllIllIllIIIlIllIlIll, final String llllllllllllllIllIllIIIlIllIIllI) {
        try {
            final File llllllllllllllIllIllIIIlIllIlIIl = new File(Shaders.shaderpacksdir, String.valueOf(new StringBuilder("debug/").append(llllllllllllllIllIllIIIlIllIlIll)));
            llllllllllllllIllIllIIIlIllIlIIl.getParentFile().mkdirs();
            Config.writeFile(llllllllllllllIllIllIIIlIllIlIIl, llllllllllllllIllIllIIIlIllIIllI);
        }
        catch (IOException llllllllllllllIllIllIIIlIllIlIII) {
            Config.warn(String.valueOf(new StringBuilder("Error saving: ").append(llllllllllllllIllIllIIIlIllIlIll)));
            llllllllllllllIllIllIIIlIllIlIII.printStackTrace();
        }
    }
    
    private static void resize() {
        Shaders.renderDisplayWidth = Shaders.mc.displayWidth;
        Shaders.renderDisplayHeight = Shaders.mc.displayHeight;
        Shaders.renderWidth = Math.round(Shaders.renderDisplayWidth * Shaders.configRenderResMul);
        Shaders.renderHeight = Math.round(Shaders.renderDisplayHeight * Shaders.configRenderResMul);
        setupFrameBuffer();
    }
    
    public static boolean isHandRenderedOff() {
        return Shaders.isHandRenderedOff;
    }
    
    public static void sglEnableFog(final int llllllllllllllIllIlIllllIlllllll) {
        GL11.glEnable(llllllllllllllIllIlIllllIlllllll);
        enableFog();
    }
    
    private static int setupProgram(final int llllllllllllllIllIllIIIlllIIIIll, final String llllllllllllllIllIllIIIllIlllIlI, final String llllllllllllllIllIllIIIlllIIIIIl) {
        checkGLError("pre setupProgram");
        int llllllllllllllIllIllIIIlllIIIIII = ARBShaderObjects.glCreateProgramObjectARB();
        checkGLError("create");
        if (llllllllllllllIllIllIIIlllIIIIII != 0) {
            Shaders.progUseEntityAttrib = false;
            Shaders.progUseMidTexCoordAttrib = false;
            Shaders.progUseTangentAttrib = false;
            final int llllllllllllllIllIllIIIllIllllll = createVertShader(llllllllllllllIllIllIIIllIlllIlI);
            final int llllllllllllllIllIllIIIllIlllllI = createFragShader(llllllllllllllIllIllIIIlllIIIIIl);
            checkGLError("create");
            if (llllllllllllllIllIllIIIllIllllll == 0 && llllllllllllllIllIllIIIllIlllllI == 0) {
                ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIlllIIIIII);
                llllllllllllllIllIllIIIlllIIIIII = 0;
            }
            else {
                if (llllllllllllllIllIllIIIllIllllll != 0) {
                    ARBShaderObjects.glAttachObjectARB(llllllllllllllIllIllIIIlllIIIIII, llllllllllllllIllIllIIIllIllllll);
                    checkGLError("attach");
                }
                if (llllllllllllllIllIllIIIllIlllllI != 0) {
                    ARBShaderObjects.glAttachObjectARB(llllllllllllllIllIllIIIlllIIIIII, llllllllllllllIllIllIIIllIlllllI);
                    checkGLError("attach");
                }
                if (Shaders.progUseEntityAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(llllllllllllllIllIllIIIlllIIIIII, Shaders.entityAttrib, (CharSequence)"mc_Entity");
                    checkGLError("mc_Entity");
                }
                if (Shaders.progUseMidTexCoordAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(llllllllllllllIllIllIIIlllIIIIII, Shaders.midTexCoordAttrib, (CharSequence)"mc_midTexCoord");
                    checkGLError("mc_midTexCoord");
                }
                if (Shaders.progUseTangentAttrib) {
                    ARBVertexShader.glBindAttribLocationARB(llllllllllllllIllIllIIIlllIIIIII, Shaders.tangentAttrib, (CharSequence)"at_tangent");
                    checkGLError("at_tangent");
                }
                ARBShaderObjects.glLinkProgramARB(llllllllllllllIllIllIIIlllIIIIII);
                if (GL20.glGetProgrami(llllllllllllllIllIllIIIlllIIIIII, 35714) != 1) {
                    SMCLog.severe(String.valueOf(new StringBuilder("Error linking program: ").append(llllllllllllllIllIllIIIlllIIIIII)));
                }
                printLogInfo(llllllllllllllIllIllIIIlllIIIIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIIllIlllIlI)).append(", ").append(llllllllllllllIllIllIIIlllIIIIIl)));
                if (llllllllllllllIllIllIIIllIllllll != 0) {
                    ARBShaderObjects.glDetachObjectARB(llllllllllllllIllIllIIIlllIIIIII, llllllllllllllIllIllIIIllIllllll);
                    ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIllIllllll);
                }
                if (llllllllllllllIllIllIIIllIlllllI != 0) {
                    ARBShaderObjects.glDetachObjectARB(llllllllllllllIllIllIIIlllIIIIII, llllllllllllllIllIllIIIllIlllllI);
                    ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIllIlllllI);
                }
                Shaders.programsID[llllllllllllllIllIllIIIlllIIIIll] = llllllllllllllIllIllIIIlllIIIIII;
                useProgram(llllllllllllllIllIllIIIlllIIIIll);
                ARBShaderObjects.glValidateProgramARB(llllllllllllllIllIllIIIlllIIIIII);
                useProgram(0);
                printLogInfo(llllllllllllllIllIllIIIlllIIIIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIIllIlllIlI)).append(", ").append(llllllllllllllIllIllIIIlllIIIIIl)));
                final int llllllllllllllIllIllIIIllIllllIl = GL20.glGetProgrami(llllllllllllllIllIllIIIlllIIIIII, 35715);
                if (llllllllllllllIllIllIIIllIllllIl != 1) {
                    final String llllllllllllllIllIllIIIllIllllII = "\"";
                    printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Invalid program ").append(llllllllllllllIllIllIIIllIllllII).append(Shaders.programNames[llllllllllllllIllIllIIIlllIIIIll]).append(llllllllllllllIllIllIIIllIllllII)));
                    ARBShaderObjects.glDeleteObjectARB(llllllllllllllIllIllIIIlllIIIIII);
                    llllllllllllllIllIllIIIlllIIIIII = 0;
                }
            }
        }
        return llllllllllllllIllIllIIIlllIIIIII;
    }
    
    private static void printChatAndLogError(final String llllllllllllllIllIllIIlIlIIIllIl) {
        SMCLog.severe(llllllllllllllIllIllIIlIlIIIllIl);
        Shaders.mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentString(llllllllllllllIllIllIIlIlIIIllIl));
    }
    
    public static void beginSpiderEyes() {
        if (Shaders.isRenderingWorld && Shaders.programsID[18] != Shaders.programsID[0]) {
            useProgram(18);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.0f);
            GlStateManager.blendFunc(770, 771);
        }
    }
    
    public static boolean isShaderPackOptionSlider(final String llllllllllllllIllIllIIllIllIllll) {
        return Shaders.shaderPackOptionSliders != null && Shaders.shaderPackOptionSliders.contains(llllllllllllllIllIllIIllIllIllll);
    }
    
    private static void loadShaderPackProperties() {
        Shaders.shaderPackClouds.resetValue();
        Shaders.shaderPackOldHandLight.resetValue();
        Shaders.shaderPackDynamicHandLight.resetValue();
        Shaders.shaderPackOldLighting.resetValue();
        Shaders.shaderPackShadowTranslucent.resetValue();
        Shaders.shaderPackUnderwaterOverlay.resetValue();
        Shaders.shaderPackSun.resetValue();
        Shaders.shaderPackMoon.resetValue();
        Shaders.shaderPackVignette.resetValue();
        Shaders.shaderPackBackFaceSolid.resetValue();
        Shaders.shaderPackBackFaceCutout.resetValue();
        Shaders.shaderPackBackFaceCutoutMipped.resetValue();
        Shaders.shaderPackBackFaceTranslucent.resetValue();
        BlockAliases.reset();
        if (Shaders.shaderPack != null) {
            BlockAliases.update(Shaders.shaderPack);
            final String llllllllllllllIllIllIlIIIIIlIlIl = "/shaders/shaders.properties";
            try {
                final InputStream llllllllllllllIllIllIlIIIIIlIlII = Shaders.shaderPack.getResourceAsStream(llllllllllllllIllIllIlIIIIIlIlIl);
                if (llllllllllllllIllIllIlIIIIIlIlII == null) {
                    return;
                }
                final Properties llllllllllllllIllIllIlIIIIIlIIll = new PropertiesOrdered();
                llllllllllllllIllIllIlIIIIIlIIll.load(llllllllllllllIllIllIlIIIIIlIlII);
                llllllllllllllIllIllIlIIIIIlIlII.close();
                Shaders.shaderPackClouds.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackOldHandLight.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackDynamicHandLight.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackOldLighting.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackShadowTranslucent.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackUnderwaterOverlay.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackSun.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackVignette.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackMoon.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackBackFaceSolid.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackBackFaceCutout.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackBackFaceCutoutMipped.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackBackFaceTranslucent.loadFrom(llllllllllllllIllIllIlIIIIIlIIll);
                Shaders.shaderPackOptionSliders = ShaderPackParser.parseOptionSliders(llllllllllllllIllIllIlIIIIIlIIll, Shaders.shaderPackOptions);
                Shaders.shaderPackProfiles = ShaderPackParser.parseProfiles(llllllllllllllIllIllIlIIIIIlIIll, Shaders.shaderPackOptions);
                Shaders.shaderPackGuiScreens = ShaderPackParser.parseGuiScreens(llllllllllllllIllIllIlIIIIIlIIll, Shaders.shaderPackProfiles, Shaders.shaderPackOptions);
                Shaders.customTexturesGbuffers = loadCustomTextures(llllllllllllllIllIllIlIIIIIlIIll, 0);
                Shaders.customTexturesComposite = loadCustomTextures(llllllllllllllIllIllIlIIIIIlIIll, 1);
                Shaders.noiseTexturePath = llllllllllllllIllIllIlIIIIIlIIll.getProperty("texture.noise");
                if (Shaders.noiseTexturePath != null) {
                    Shaders.noiseTextureEnabled = true;
                }
            }
            catch (IOException llllllllllllllIllIllIlIIIIIlIIlI) {
                Config.warn(String.valueOf(new StringBuilder("[Shaders] Error reading: ").append(llllllllllllllIllIllIlIIIIIlIlIl)));
            }
        }
    }
    
    private static ShaderOption[] getShaderOptionsRest(final Map<String, ScreenShaderOptions> llllllllllllllIllIllIIlllIIIlIlI, final ShaderOption[] llllllllllllllIllIllIIlllIIIlIIl) {
        final Set<String> llllllllllllllIllIllIIlllIIIlIII = new HashSet<String>();
        for (final String llllllllllllllIllIllIIlllIIIIlll : llllllllllllllIllIllIIlllIIIlIlI.keySet()) {
            final ScreenShaderOptions llllllllllllllIllIllIIlllIIIIllI = llllllllllllllIllIllIIlllIIIlIlI.get(llllllllllllllIllIllIIlllIIIIlll);
            final ShaderOption[] llllllllllllllIllIllIIlllIIIIlIl = llllllllllllllIllIllIIlllIIIIllI.getShaderOptions();
            for (int llllllllllllllIllIllIIlllIIIIlII = 0; llllllllllllllIllIllIIlllIIIIlII < llllllllllllllIllIllIIlllIIIIlIl.length; ++llllllllllllllIllIllIIlllIIIIlII) {
                final ShaderOption llllllllllllllIllIllIIlllIIIIIll = llllllllllllllIllIllIIlllIIIIlIl[llllllllllllllIllIllIIlllIIIIlII];
                if (llllllllllllllIllIllIIlllIIIIIll != null) {
                    llllllllllllllIllIllIIlllIIIlIII.add(llllllllllllllIllIllIIlllIIIIIll.getName());
                }
            }
        }
        final List<ShaderOption> llllllllllllllIllIllIIlllIIIIIlI = new ArrayList<ShaderOption>();
        for (int llllllllllllllIllIllIIlllIIIIIIl = 0; llllllllllllllIllIllIIlllIIIIIIl < llllllllllllllIllIllIIlllIIIlIIl.length; ++llllllllllllllIllIllIIlllIIIIIIl) {
            final ShaderOption llllllllllllllIllIllIIlllIIIIIII = llllllllllllllIllIllIIlllIIIlIIl[llllllllllllllIllIllIIlllIIIIIIl];
            if (llllllllllllllIllIllIIlllIIIIIII.isVisible()) {
                final String llllllllllllllIllIllIIllIlllllll = llllllllllllllIllIllIIlllIIIIIII.getName();
                if (!llllllllllllllIllIllIIlllIIIlIII.contains(llllllllllllllIllIllIIllIlllllll)) {
                    llllllllllllllIllIllIIlllIIIIIlI.add(llllllllllllllIllIllIIlllIIIIIII);
                }
            }
        }
        final ShaderOption[] llllllllllllllIllIllIIllIllllllI = llllllllllllllIllIllIIlllIIIIIlI.toArray(new ShaderOption[llllllllllllllIllIllIIlllIIIIIlI.size()]);
        return llllllllllllllIllIllIIllIllllllI;
    }
    
    public static void setUpPosition() {
        final FloatBuffer llllllllllllllIllIlIlllllllIlIIl = Shaders.tempMatrixDirectBuffer;
        llllllllllllllIllIlIlllllllIlIIl.clear();
        GL11.glGetFloat(2982, llllllllllllllIllIlIlllllllIlIIl);
        llllllllllllllIllIlIlllllllIlIIl.get(Shaders.tempMat, 0, 16);
        SMath.multiplyMat4xVec4(Shaders.upPosition, Shaders.tempMat, Shaders.upPosModelView);
        setProgramUniform3f("upPosition", Shaders.upPosition[0], Shaders.upPosition[1], Shaders.upPosition[2]);
    }
    
    public static void genCompositeMipmap() {
        if (Shaders.hasGlGenMipmap) {
            for (int llllllllllllllIllIlIlllllllIIllI = 0; llllllllllllllIllIlIlllllllIIllI < Shaders.usedColorBuffers; ++llllllllllllllIllIlIlllllllIIllI) {
                if ((Shaders.activeCompositeMipmapSetting & 1 << llllllllllllllIllIlIlllllllIIllI) != 0x0) {
                    GlStateManager.setActiveTexture(33984 + Shaders.colorTextureTextureImageUnit[llllllllllllllIllIlIlllllllIIllI]);
                    GL11.glTexParameteri(3553, 10241, 9987);
                    GL30.glGenerateMipmap(3553);
                }
            }
            GlStateManager.setActiveTexture(33984);
        }
    }
    
    public static void storeConfig() {
        SMCLog.info("Save ShadersMod configuration.");
        if (Shaders.shadersConfig == null) {
            Shaders.shadersConfig = new PropertiesOrdered();
        }
        final EnumShaderOption[] llllllllllllllIllIllIlIIIlIIIlII = EnumShaderOption.values();
        for (int llllllllllllllIllIllIlIIIlIIIIll = 0; llllllllllllllIllIllIlIIIlIIIIll < llllllllllllllIllIllIlIIIlIIIlII.length; ++llllllllllllllIllIllIlIIIlIIIIll) {
            final EnumShaderOption llllllllllllllIllIllIlIIIlIIIIlI = llllllllllllllIllIllIlIIIlIIIlII[llllllllllllllIllIllIlIIIlIIIIll];
            final String llllllllllllllIllIllIlIIIlIIIIIl = llllllllllllllIllIllIlIIIlIIIIlI.getPropertyKey();
            final String llllllllllllllIllIllIlIIIlIIIIII = getEnumShaderOption(llllllllllllllIllIllIlIIIlIIIIlI);
            Shaders.shadersConfig.setProperty(llllllllllllllIllIllIlIIIlIIIIIl, llllllllllllllIllIllIlIIIlIIIIII);
        }
        try {
            final FileWriter llllllllllllllIllIllIlIIIIllllll = new FileWriter(Shaders.configFile);
            Shaders.shadersConfig.store(llllllllllllllIllIllIlIIIIllllll, null);
            llllllllllllllIllIllIlIIIIllllll.close();
        }
        catch (Exception llllllllllllllIllIllIlIIIIlllllI) {
            SMCLog.severe(String.valueOf(new StringBuilder("Error saving configuration: ").append(llllllllllllllIllIllIlIIIIlllllI.getClass().getName()).append(": ").append(llllllllllllllIllIllIlIIIIlllllI.getMessage())));
        }
    }
    
    public static void endSpiderEyes() {
        if (Shaders.isRenderingWorld && Shaders.programsID[18] != Shaders.programsID[0]) {
            useProgram(16);
            GlStateManager.disableAlpha();
        }
    }
    
    private static void setupFrameBuffer() {
        if (Shaders.dfb != 0) {
            EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.dfb);
            GlStateManager.deleteTextures(Shaders.dfbDepthTextures);
            GlStateManager.deleteTextures(Shaders.dfbColorTextures);
        }
        Shaders.dfb = EXTFramebufferObject.glGenFramebuffersEXT();
        GL11.glGenTextures((IntBuffer)Shaders.dfbDepthTextures.clear().limit(Shaders.usedDepthBuffers));
        GL11.glGenTextures((IntBuffer)Shaders.dfbColorTextures.clear().limit(16));
        Shaders.dfbDepthTextures.position(0);
        Shaders.dfbColorTextures.position(0);
        Shaders.dfbColorTextures.get(Shaders.dfbColorTexturesA).position(0);
        EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
        GL20.glDrawBuffers(0);
        GL11.glReadBuffer(0);
        for (int llllllllllllllIllIllIIIIlIIIlIlI = 0; llllllllllllllIllIllIIIIlIIIlIlI < Shaders.usedDepthBuffers; ++llllllllllllllIllIllIIIIlIIIlIlI) {
            GlStateManager.bindTexture(Shaders.dfbDepthTextures.get(llllllllllllllIllIllIIIIlIIIlIlI));
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
            GL11.glTexParameteri(3553, 10241, 9728);
            GL11.glTexParameteri(3553, 10240, 9728);
            GL11.glTexParameteri(3553, 34891, 6409);
            GL11.glTexImage2D(3553, 0, 6402, Shaders.renderWidth, Shaders.renderHeight, 0, 6402, 5126, (FloatBuffer)null);
        }
        EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.dfbDepthTextures.get(0), 0);
        GL20.glDrawBuffers(Shaders.dfbDrawBuffers);
        GL11.glReadBuffer(0);
        checkGLError("FT d");
        for (int llllllllllllllIllIllIIIIlIIIlIIl = 0; llllllllllllllIllIllIIIIlIIIlIIl < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIlIIIlIIl) {
            GlStateManager.bindTexture(Shaders.dfbColorTexturesA[llllllllllllllIllIllIIIIlIIIlIIl]);
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, Shaders.gbuffersFormat[llllllllllllllIllIllIIIIlIIIlIIl], Shaders.renderWidth, Shaders.renderHeight, 0, 32993, 33639, (ByteBuffer)null);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllIllIllIIIIlIIIlIIl, 3553, Shaders.dfbColorTexturesA[llllllllllllllIllIllIIIIlIIIlIIl], 0);
            checkGLError("FT c");
        }
        for (int llllllllllllllIllIllIIIIlIIIlIII = 0; llllllllllllllIllIllIIIIlIIIlIII < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIlIIIlIII) {
            GlStateManager.bindTexture(Shaders.dfbColorTexturesA[8 + llllllllllllllIllIllIIIIlIIIlIII]);
            GL11.glTexParameteri(3553, 10242, 10496);
            GL11.glTexParameteri(3553, 10243, 10496);
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            GL11.glTexImage2D(3553, 0, Shaders.gbuffersFormat[llllllllllllllIllIllIIIIlIIIlIII], Shaders.renderWidth, Shaders.renderHeight, 0, 32993, 33639, (ByteBuffer)null);
            checkGLError("FT ca");
        }
        int llllllllllllllIllIllIIIIlIIIIlll = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
        if (llllllllllllllIllIllIIIIlIIIIlll == 36058) {
            printChatAndLogError("[Shaders] Error: Failed framebuffer incomplete formats");
            for (int llllllllllllllIllIllIIIIlIIIIllI = 0; llllllllllllllIllIllIIIIlIIIIllI < Shaders.usedColorBuffers; ++llllllllllllllIllIllIIIIlIIIIllI) {
                GlStateManager.bindTexture(Shaders.dfbColorTextures.get(llllllllllllllIllIllIIIIlIIIIllI));
                GL11.glTexImage2D(3553, 0, 6408, Shaders.renderWidth, Shaders.renderHeight, 0, 32993, 33639, (ByteBuffer)null);
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllIllIllIIIIlIIIIllI, 3553, Shaders.dfbColorTextures.get(llllllllllllllIllIllIIIIlIIIIllI), 0);
                checkGLError("FT c");
            }
            llllllllllllllIllIllIIIIlIIIIlll = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
            if (llllllllllllllIllIllIIIIlIIIIlll == 36053) {
                SMCLog.info("complete");
            }
        }
        GlStateManager.bindTexture(0);
        if (llllllllllllllIllIllIIIIlIIIIlll != 36053) {
            printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Failed creating framebuffer! (Status ").append(llllllllllllllIllIllIIIIlIIIIlll).append(")")));
        }
        else {
            SMCLog.info("Framebuffer created.");
        }
    }
    
    public static void beginWater() {
        if (Shaders.isRenderingWorld) {
            if (!Shaders.isShadowPass) {
                useProgram(12);
                GlStateManager.enableBlend();
                GlStateManager.depthMask(true);
            }
            else {
                GlStateManager.depthMask(true);
            }
        }
    }
    
    public static void beginWeather() {
        if (!Shaders.isShadowPass) {
            if (Shaders.usedDepthBuffers >= 3) {
                GlStateManager.setActiveTexture(33996);
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.renderWidth, Shaders.renderHeight);
                GlStateManager.setActiveTexture(33984);
            }
            GlStateManager.enableDepth();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.enableAlpha();
            useProgram(20);
        }
    }
    
    public static boolean isHandRenderedMain() {
        return Shaders.isHandRenderedMain;
    }
    
    static void checkOptifine() {
    }
    
    private static boolean printShaderLogInfo(final int llllllllllllllIllIllIIIlIIllIlII, final String llllllllllllllIllIllIIIlIIlllIll, final List<String> llllllllllllllIllIllIIIlIIllIIlI) {
        final IntBuffer llllllllllllllIllIllIIIlIIlllIIl = BufferUtils.createIntBuffer(1);
        final int llllllllllllllIllIllIIIlIIlllIII = GL20.glGetShaderi(llllllllllllllIllIllIIIlIIllIlII, 35716);
        if (llllllllllllllIllIllIIIlIIlllIII <= 1) {
            return true;
        }
        for (int llllllllllllllIllIllIIIlIIllIlll = 0; llllllllllllllIllIllIIIlIIllIlll < llllllllllllllIllIllIIIlIIllIIlI.size(); ++llllllllllllllIllIllIIIlIIllIlll) {
            final String llllllllllllllIllIllIIIlIIllIllI = llllllllllllllIllIllIIIlIIllIIlI.get(llllllllllllllIllIllIIIlIIllIlll);
            SMCLog.info(String.valueOf(new StringBuilder("File: ").append(llllllllllllllIllIllIIIlIIllIlll + 1).append(" = ").append(llllllllllllllIllIllIIIlIIllIllI)));
        }
        final String llllllllllllllIllIllIIIlIIllIlIl = GL20.glGetShaderInfoLog(llllllllllllllIllIllIIIlIIllIlII, llllllllllllllIllIllIIIlIIlllIII);
        SMCLog.info(String.valueOf(new StringBuilder("Shader info log: ").append(llllllllllllllIllIllIIIlIIlllIll).append("\n").append(llllllllllllllIllIllIIIlIIllIlIl)));
        return false;
    }
    
    public static int getShaderPackColumns(final String llllllllllllllIllIllIIlllIIlIlll, final int llllllllllllllIllIllIIlllIIllIlI) {
        final String llllllllllllllIllIllIIlllIIllIIl = (llllllllllllllIllIllIIlllIIlIlll != null) ? String.valueOf(new StringBuilder("screen.").append(llllllllllllllIllIllIIlllIIlIlll)) : "screen";
        if (Shaders.shaderPackGuiScreens == null) {
            return llllllllllllllIllIllIIlllIIllIlI;
        }
        final ScreenShaderOptions llllllllllllllIllIllIIlllIIllIII = Shaders.shaderPackGuiScreens.get(llllllllllllllIllIllIIlllIIllIIl);
        return (llllllllllllllIllIllIIlllIIllIII == null) ? llllllllllllllIllIllIIlllIIllIlI : llllllllllllllIllIllIIlllIIllIII.getColumns();
    }
    
    private static String toStringYN(final boolean llllllllllllllIllIllIIlIIIIlllIl) {
        return llllllllllllllIllIllIIlIIIIlllIl ? "Y" : "N";
    }
    
    public static void setFogColor(final float llllllllllllllIllIllIIIIIIlllIlI, final float llllllllllllllIllIllIIIIIIlllIIl, final float llllllllllllllIllIllIIIIIIlllIII) {
        Shaders.fogColorR = llllllllllllllIllIllIIIIIIlllIlI;
        Shaders.fogColorG = llllllllllllllIllIllIIIIIIlllIIl;
        Shaders.fogColorB = llllllllllllllIllIllIIIIIIlllIII;
    }
    
    private static int getTextureFormatFromString(String llllllllllllllIllIllIIIIlIllIlIl) {
        llllllllllllllIllIllIIIIlIllIlIl = llllllllllllllIllIllIIIIlIllIlIl.trim();
        for (int llllllllllllllIllIllIIIIlIllIlll = 0; llllllllllllllIllIllIIIIlIllIlll < Shaders.formatNames.length; ++llllllllllllllIllIllIIIIlIllIlll) {
            final String llllllllllllllIllIllIIIIlIllIllI = Shaders.formatNames[llllllllllllllIllIllIIIIlIllIlll];
            if (llllllllllllllIllIllIIIIlIllIlIl.equals(llllllllllllllIllIllIIIIlIllIllI)) {
                return Shaders.formatIds[llllllllllllllIllIllIIIIlIllIlll];
            }
        }
        return 0;
    }
    
    public static void setProgramUniform2i(final String llllllllllllllIllIllIIIIllllIlIl, final int llllllllllllllIllIllIIIIllllIlII, final int llllllllllllllIllIllIIIIlllIlllI) {
        final int llllllllllllllIllIllIIIIllllIIlI = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllIllIllIIIIllllIIlI != 0) {
            final int llllllllllllllIllIllIIIIllllIIIl = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIllIllIIIIllllIIlI, (CharSequence)llllllllllllllIllIllIIIIllllIlIl);
            ARBShaderObjects.glUniform2iARB(llllllllllllllIllIllIIIIllllIIIl, llllllllllllllIllIllIIIIllllIlII, llllllllllllllIllIllIIIIlllIlllI);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllIllIllIIIIllllIlIl);
        }
    }
    
    private static void checkWorldChanged(final World llllllllllllllIllIllIIIIIlIlIllI) {
        if (Shaders.currentWorld != llllllllllllllIllIllIIIIIlIlIllI) {
            final World llllllllllllllIllIllIIIIIlIlIlIl = Shaders.currentWorld;
            Shaders.currentWorld = llllllllllllllIllIllIIIIIlIlIllI;
            if (llllllllllllllIllIllIIIIIlIlIlIl != null && llllllllllllllIllIllIIIIIlIlIllI != null) {
                final int llllllllllllllIllIllIIIIIlIlIlII = llllllllllllllIllIllIIIIIlIlIlIl.provider.getDimensionType().getId();
                final int llllllllllllllIllIllIIIIIlIlIIll = llllllllllllllIllIllIIIIIlIlIllI.provider.getDimensionType().getId();
                final boolean llllllllllllllIllIllIIIIIlIlIIlI = Shaders.shaderPackDimensions.contains(llllllllllllllIllIllIIIIIlIlIlII);
                final boolean llllllllllllllIllIllIIIIIlIlIIIl = Shaders.shaderPackDimensions.contains(llllllllllllllIllIllIIIIIlIlIIll);
                if (llllllllllllllIllIllIIIIIlIlIIlI || llllllllllllllIllIllIIIIIlIlIIIl) {
                    uninit();
                }
            }
        }
    }
    
    public static void endHand() {
        checkGLError("pre endHand");
        checkFramebufferStatus("pre endHand");
        GL11.glMatrixMode(5889);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glPopMatrix();
        GlStateManager.blendFunc(770, 771);
        checkGLError("endHand");
    }
    
    public static int checkGLError(final String llllllllllllllIllIllIIlIllIllllI) {
        final int llllllllllllllIllIllIIlIlllIIIIl = GL11.glGetError();
        if (llllllllllllllIllIllIIlIlllIIIIl != 0) {
            final boolean llllllllllllllIllIllIIlIlllIIIII = false;
            if (!llllllllllllllIllIllIIlIlllIIIII) {
                if (llllllllllllllIllIllIIlIlllIIIIl == 1286) {
                    final int llllllllllllllIllIllIIlIllIlllll = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
                    System.err.format("GL error 0x%04X: %s (Fb status 0x%04X) at %s\n", llllllllllllllIllIllIIlIlllIIIIl, GLU.gluErrorString(llllllllllllllIllIllIIlIlllIIIIl), llllllllllllllIllIllIIlIllIlllll, llllllllllllllIllIllIIlIllIllllI);
                }
                else {
                    System.err.format("GL error 0x%04X: %s at %s\n", llllllllllllllIllIllIIlIlllIIIIl, GLU.gluErrorString(llllllllllllllIllIllIIlIlllIIIIl), llllllllllllllIllIllIIlIllIllllI);
                }
            }
        }
        return llllllllllllllIllIllIIlIlllIIIIl;
    }
    
    public static void endBeacon() {
        if (Shaders.isRenderingWorld) {
            useProgram(13);
        }
    }
    
    public static void enableFog() {
        Shaders.fogEnabled = true;
        setProgramUniform1i("fogMode", Shaders.fogMode);
    }
    
    public static void setSkyColor(final Vec3d llllllllllllllIllIlIllllllIlIIII) {
        Shaders.skyColorR = (float)llllllllllllllIllIlIllllllIlIIII.xCoord;
        Shaders.skyColorG = (float)llllllllllllllIllIlIllllllIlIIII.yCoord;
        Shaders.skyColorB = (float)llllllllllllllIllIlIllllllIlIIII.zCoord;
        setProgramUniform3f("skyColor", Shaders.skyColorR, Shaders.skyColorG, Shaders.skyColorB);
    }
    
    private static boolean isTranslucentBlock(final ItemStack llllllllllllllIllIlIllllIIIlllII) {
        if (llllllllllllllIllIlIllllIIIlllII == null) {
            return false;
        }
        final Item llllllllllllllIllIlIllllIIIllIll = llllllllllllllIllIlIllllIIIlllII.getItem();
        if (llllllllllllllIllIlIllllIIIllIll == null) {
            return false;
        }
        if (!(llllllllllllllIllIlIllllIIIllIll instanceof ItemBlock)) {
            return false;
        }
        final ItemBlock llllllllllllllIllIlIllllIIIllIlI = (ItemBlock)llllllllllllllIllIlIllllIIIllIll;
        final Block llllllllllllllIllIlIllllIIIllIIl = llllllllllllllIllIlIllllIIIllIlI.getBlock();
        if (llllllllllllllIllIlIllllIIIllIIl == null) {
            return false;
        }
        final BlockRenderLayer llllllllllllllIllIlIllllIIIllIII = llllllllllllllIllIlIllllIIIllIIl.getBlockLayer();
        return llllllllllllllIllIlIllllIIIllIII == BlockRenderLayer.TRANSLUCENT;
    }
    
    public static void preWater() {
        if (Shaders.usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            checkGLError("pre copy depth");
            GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.renderWidth, Shaders.renderHeight);
            checkGLError("copy depth");
            GlStateManager.setActiveTexture(33984);
        }
        ShadersTex.bindNSTextures(Shaders.defaultTexture.getMultiTexID());
    }
    
    public static boolean isUnderwaterOverlay() {
        return !Shaders.shaderPackUnderwaterOverlay.isFalse();
    }
    
    public static ShaderOption[] getShaderPackOptions(final String llllllllllllllIllIllIIlllIlIlIII) {
        ShaderOption[] llllllllllllllIllIllIIlllIllIIlI = Shaders.shaderPackOptions.clone();
        if (Shaders.shaderPackGuiScreens == null) {
            if (Shaders.shaderPackProfiles != null) {
                final ShaderOptionProfile llllllllllllllIllIllIIlllIllIIIl = new ShaderOptionProfile(Shaders.shaderPackProfiles, llllllllllllllIllIllIIlllIllIIlI);
                llllllllllllllIllIllIIlllIllIIlI = (ShaderOption[])Config.addObjectToArray(llllllllllllllIllIllIIlllIllIIlI, llllllllllllllIllIllIIlllIllIIIl, 0);
            }
            llllllllllllllIllIllIIlllIllIIlI = getVisibleOptions(llllllllllllllIllIllIIlllIllIIlI);
            return llllllllllllllIllIllIIlllIllIIlI;
        }
        final String llllllllllllllIllIllIIlllIllIIII = (llllllllllllllIllIllIIlllIlIlIII != null) ? String.valueOf(new StringBuilder("screen.").append(llllllllllllllIllIllIIlllIlIlIII)) : "screen";
        final ScreenShaderOptions llllllllllllllIllIllIIlllIlIllll = Shaders.shaderPackGuiScreens.get(llllllllllllllIllIllIIlllIllIIII);
        if (llllllllllllllIllIllIIlllIlIllll == null) {
            return new ShaderOption[0];
        }
        final ShaderOption[] llllllllllllllIllIllIIlllIlIlllI = llllllllllllllIllIllIIlllIlIllll.getShaderOptions();
        final List<ShaderOption> llllllllllllllIllIllIIlllIlIllIl = new ArrayList<ShaderOption>();
        for (int llllllllllllllIllIllIIlllIlIllII = 0; llllllllllllllIllIllIIlllIlIllII < llllllllllllllIllIllIIlllIlIlllI.length; ++llllllllllllllIllIllIIlllIlIllII) {
            final ShaderOption llllllllllllllIllIllIIlllIlIlIll = llllllllllllllIllIllIIlllIlIlllI[llllllllllllllIllIllIIlllIlIllII];
            if (llllllllllllllIllIllIIlllIlIlIll == null) {
                llllllllllllllIllIllIIlllIlIllIl.add(null);
            }
            else if (llllllllllllllIllIllIIlllIlIlIll instanceof ShaderOptionRest) {
                final ShaderOption[] llllllllllllllIllIllIIlllIlIlIlI = getShaderOptionsRest(Shaders.shaderPackGuiScreens, llllllllllllllIllIllIIlllIllIIlI);
                llllllllllllllIllIllIIlllIlIllIl.addAll(Arrays.asList(llllllllllllllIllIllIIlllIlIlIlI));
            }
            else {
                llllllllllllllIllIllIIlllIlIllIl.add(llllllllllllllIllIllIIlllIlIlIll);
            }
        }
        final ShaderOption[] llllllllllllllIllIllIIlllIlIlIIl = llllllllllllllIllIllIIlllIlIllIl.toArray(new ShaderOption[llllllllllllllIllIllIIlllIlIllIl.size()]);
        return llllllllllllllIllIllIIlllIlIlIIl;
    }
    
    public static void endUpdateChunks() {
        checkGLError("endUpdateChunks1");
        checkFramebufferStatus("endUpdateChunks1");
        if (!Shaders.isShadowPass) {
            useProgram(7);
        }
        checkGLError("endUpdateChunks2");
        checkFramebufferStatus("endUpdateChunks2");
    }
    
    public static boolean isVignette() {
        return !Shaders.shaderPackVignette.isFalse();
    }
    
    public static void sglFogi(final int llllllllllllllIllIlIllllIlllIIll, final int llllllllllllllIllIlIllllIlllIIlI) {
        GL11.glFogi(llllllllllllllIllIlIllllIlllIIll, llllllllllllllIllIlIllllIlllIIlI);
        if (llllllllllllllIllIlIllllIlllIIll == 2917) {
            Shaders.fogMode = llllllllllllllIllIlIllllIlllIIlI;
            if (Shaders.fogEnabled) {
                setProgramUniform1i("fogMode", Shaders.fogMode);
            }
        }
    }
    
    public static void nextEntity(final Entity llllllllllllllIllIlIlllllIllIIIl) {
        if (Shaders.isRenderingWorld) {
            useProgram(16);
            setEntityId(llllllllllllllIllIlIlllllIllIIIl);
        }
    }
    
    private static CustomTexture loadCustomTexture(final int llllllllllllllIllIllIIllllIlllIl, String llllllllllllllIllIllIIllllIlllII) {
        if (llllllllllllllIllIllIIllllIlllII == null) {
            return null;
        }
        llllllllllllllIllIllIIllllIlllII = llllllllllllllIllIllIIllllIlllII.trim();
        if (llllllllllllllIllIllIIllllIlllII.indexOf(46) < 0) {
            llllllllllllllIllIllIIllllIlllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIllllIlllII)).append(".png"));
        }
        try {
            final String llllllllllllllIllIllIIlllllIIIlI = String.valueOf(new StringBuilder("shaders/").append(StrUtils.removePrefix(llllllllllllllIllIllIIllllIlllII, "/")));
            final InputStream llllllllllllllIllIllIIlllllIIIIl = Shaders.shaderPack.getResourceAsStream(llllllllllllllIllIllIIlllllIIIlI);
            if (llllllllllllllIllIllIIlllllIIIIl == null) {
                SMCLog.warning(String.valueOf(new StringBuilder("Texture not found: ").append(llllllllllllllIllIllIIllllIlllII)));
                return null;
            }
            IOUtils.closeQuietly(llllllllllllllIllIllIIlllllIIIIl);
            final SimpleShaderTexture llllllllllllllIllIllIIlllllIIIII = new SimpleShaderTexture(llllllllllllllIllIllIIlllllIIIlI);
            llllllllllllllIllIllIIlllllIIIII.loadTexture(Shaders.mc.getResourceManager());
            final CustomTexture llllllllllllllIllIllIIllllIlllll = new CustomTexture(llllllllllllllIllIllIIllllIlllIl, llllllllllllllIllIllIIlllllIIIlI, llllllllllllllIllIllIIlllllIIIII);
            return llllllllllllllIllIllIIllllIlllll;
        }
        catch (IOException llllllllllllllIllIllIIllllIllllI) {
            SMCLog.warning(String.valueOf(new StringBuilder("Error loading texture: ").append(llllllllllllllIllIllIIllllIlllII)));
            SMCLog.warning(String.valueOf(new StringBuilder().append(llllllllllllllIllIllIIllllIllllI.getClass().getName()).append(": ").append(llllllllllllllIllIllIIllllIllllI.getMessage())));
            return null;
        }
    }
    
    public static void setProgramUniform3f(final String llllllllllllllIllIllIIIIllIlIIll, final float llllllllllllllIllIllIIIIllIlIIlI, final float llllllllllllllIllIllIIIIllIlIIIl, final float llllllllllllllIllIllIIIIllIlIIII) {
        final int llllllllllllllIllIllIIIIllIlIlIl = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllIllIllIIIIllIlIlIl != 0) {
            final int llllllllllllllIllIllIIIIllIlIlII = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIllIllIIIIllIlIlIl, (CharSequence)llllllllllllllIllIllIIIIllIlIIll);
            ARBShaderObjects.glUniform3fARB(llllllllllllllIllIllIIIIllIlIlII, llllllllllllllIllIllIIIIllIlIIlI, llllllllllllllIllIllIIIIllIlIIIl, llllllllllllllIllIllIIIIllIlIIII);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllIllIllIIIIllIlIIll);
        }
    }
    
    public static void glEnableWrapper(final int llllllllllllllIllIlIlllllIIIlIll) {
        GL11.glEnable(llllllllllllllIllIlIlllllIIIlIll);
        if (llllllllllllllIllIlIlllllIIIlIll == 3553) {
            enableTexture2D();
        }
        else if (llllllllllllllIllIlIlllllIIIlIll == 2912) {
            enableFog();
        }
    }
    
    public static void resetDisplayListModels() {
        if (Shaders.needResetModels) {
            Shaders.needResetModels = false;
            SMCLog.info("Reset model renderers");
            for (final Render llllllllllllllIllIllIIIllllIIIIl : Shaders.mc.getRenderManager().getEntityRenderMap().values()) {
                if (llllllllllllllIllIllIIIllllIIIIl instanceof RenderLiving) {
                    final RenderLiving llllllllllllllIllIllIIIllllIIIII = (RenderLiving)llllllllllllllIllIllIIIllllIIIIl;
                    resetDisplayListModel(llllllllllllllIllIllIIIllllIIIII.getMainModel());
                }
            }
        }
    }
    
    public static void setViewport(final int llllllllllllllIllIllIIIIIlIIIlll, final int llllllllllllllIllIllIIIIIlIIIllI, final int llllllllllllllIllIllIIIIIlIIIlIl, final int llllllllllllllIllIllIIIIIlIIIlII) {
        GlStateManager.colorMask(true, true, true, true);
        if (Shaders.isShadowPass) {
            GL11.glViewport(0, 0, Shaders.shadowMapWidth, Shaders.shadowMapHeight);
        }
        else {
            GL11.glViewport(0, 0, Shaders.renderWidth, Shaders.renderHeight);
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
            Shaders.isRenderingDfb = true;
            GlStateManager.enableCull();
            GlStateManager.enableDepth();
            setDrawBuffers(Shaders.drawBuffersNone);
            useProgram(2);
            checkGLError("beginRenderPass");
        }
    }
    
    public static void scheduleResizeShadow() {
        Shaders.needResizeShadow = true;
    }
    
    public static void beginProjectRedHalo() {
        if (Shaders.isRenderingWorld) {
            useProgram(1);
        }
    }
    
    public static void drawHorizon() {
        final BufferBuilder llllllllllllllIllIlIllllllIIIllI = Tessellator.getInstance().getBuffer();
        final float llllllllllllllIllIlIllllllIIIlIl = (float)(Shaders.mc.gameSettings.renderDistanceChunks * 16);
        final double llllllllllllllIllIlIllllllIIIlII = llllllllllllllIllIlIllllllIIIlIl * 0.9238;
        final double llllllllllllllIllIlIllllllIIIIll = llllllllllllllIllIlIllllllIIIlIl * 0.3826;
        final double llllllllllllllIllIlIllllllIIIIlI = -llllllllllllllIllIlIllllllIIIIll;
        final double llllllllllllllIllIlIllllllIIIIIl = -llllllllllllllIllIlIllllllIIIlII;
        final double llllllllllllllIllIlIllllllIIIIII = 16.0;
        final double llllllllllllllIllIlIlllllIllllll = -Shaders.cameraPositionY;
        llllllllllllllIllIlIllllllIIIllI.begin(7, DefaultVertexFormats.POSITION);
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIIl, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIlII).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIlII).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIlII).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIlII).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIll).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIlII, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIlI).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIll, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIllllllIIIIII, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        llllllllllllllIllIlIllllllIIIllI.pos(llllllllllllllIllIlIllllllIIIIlI, llllllllllllllIllIlIlllllIllllll, llllllllllllllIllIlIllllllIIIIIl).endVertex();
        Tessellator.getInstance().draw();
    }
    
    private static IntBuffer fillIntBufferZero(final IntBuffer llllllllllllllIllIllIIIIlIIlIIlI) {
        for (int llllllllllllllIllIllIIIIlIIlIlII = llllllllllllllIllIllIIIIlIIlIIlI.limit(), llllllllllllllIllIllIIIIlIIlIIll = llllllllllllllIllIllIIIIlIIlIIlI.position(); llllllllllllllIllIllIIIIlIIlIIll < llllllllllllllIllIllIIIIlIIlIlII; ++llllllllllllllIllIllIIIIlIIlIIll) {
            llllllllllllllIllIllIIIIlIIlIIlI.put(llllllllllllllIllIllIIIIlIIlIIll, 0);
        }
        return llllllllllllllIllIllIIIIlIIlIIlI;
    }
    
    public static void resetDisplayListModelRenderer(final ModelRenderer llllllllllllllIllIllIIIlllIIlllI) {
        llllllllllllllIllIllIIIlllIIlllI.resetDisplayList();
        if (llllllllllllllIllIllIIIlllIIlllI.childModels != null) {
            for (int llllllllllllllIllIllIIIlllIlIIII = 0, llllllllllllllIllIllIIIlllIIllll = llllllllllllllIllIllIIIlllIIlllI.childModels.size(); llllllllllllllIllIllIIIlllIlIIII < llllllllllllllIllIllIIIlllIIllll; ++llllllllllllllIllIllIIIlllIlIIII) {
                resetDisplayListModelRenderer(llllllllllllllIllIllIIIlllIIlllI.childModels.get(llllllllllllllIllIllIIIlllIlIIII));
            }
        }
    }
    
    public static boolean isBothHandsRendered() {
        return Shaders.isHandRenderedMain && Shaders.isHandRenderedOff;
    }
    
    public static void readCenterDepth() {
        if (!Shaders.isShadowPass && Shaders.centerDepthSmoothEnabled) {
            Shaders.tempDirectFloatBuffer.clear();
            GL11.glReadPixels(Shaders.renderWidth / 2, Shaders.renderHeight / 2, 1, 1, 6402, 5126, Shaders.tempDirectFloatBuffer);
            Shaders.centerDepth = Shaders.tempDirectFloatBuffer.get(0);
            final float llllllllllllllIllIlIlllllIIlIIII = Shaders.diffSystemTime * 0.01f;
            final float llllllllllllllIllIlIlllllIIIllll = (float)Math.exp(Math.log(0.5) * llllllllllllllIllIlIlllllIIlIIII / Shaders.centerDepthSmoothHalflife);
            Shaders.centerDepthSmooth = Shaders.centerDepthSmooth * llllllllllllllIllIlIlllllIIIllll + Shaders.centerDepth * (1.0f - llllllllllllllIllIlIlllllIIIllll);
        }
    }
    
    public static void setCameraShadow(final float llllllllllllllIllIlIlllllllllIll) {
        final Entity llllllllllllllIllIllIIIIIIIIlIlI = Shaders.mc.getRenderViewEntity();
        final double llllllllllllllIllIllIIIIIIIIlIIl = llllllllllllllIllIllIIIIIIIIlIlI.lastTickPosX + (llllllllllllllIllIllIIIIIIIIlIlI.posX - llllllllllllllIllIllIIIIIIIIlIlI.lastTickPosX) * llllllllllllllIllIlIlllllllllIll;
        final double llllllllllllllIllIllIIIIIIIIlIII = llllllllllllllIllIllIIIIIIIIlIlI.lastTickPosY + (llllllllllllllIllIllIIIIIIIIlIlI.posY - llllllllllllllIllIllIIIIIIIIlIlI.lastTickPosY) * llllllllllllllIllIlIlllllllllIll;
        final double llllllllllllllIllIllIIIIIIIIIlll = llllllllllllllIllIllIIIIIIIIlIlI.lastTickPosZ + (llllllllllllllIllIllIIIIIIIIlIlI.posZ - llllllllllllllIllIllIIIIIIIIlIlI.lastTickPosZ) * llllllllllllllIllIlIlllllllllIll;
        Shaders.cameraPositionX = llllllllllllllIllIllIIIIIIIIlIIl;
        Shaders.cameraPositionY = llllllllllllllIllIllIIIIIIIIlIII;
        Shaders.cameraPositionZ = llllllllllllllIllIllIIIIIIIIIlll;
        GL11.glGetFloat(2983, (FloatBuffer)Shaders.projection.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.projectionInverse.position(0), (FloatBuffer)Shaders.projection.position(0), Shaders.faProjectionInverse, Shaders.faProjection);
        Shaders.projection.position(0);
        Shaders.projectionInverse.position(0);
        GL11.glGetFloat(2982, (FloatBuffer)Shaders.modelView.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.modelViewInverse.position(0), (FloatBuffer)Shaders.modelView.position(0), Shaders.faModelViewInverse, Shaders.faModelView);
        Shaders.modelView.position(0);
        Shaders.modelViewInverse.position(0);
        GL11.glViewport(0, 0, Shaders.shadowMapWidth, Shaders.shadowMapHeight);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        if (Shaders.shadowMapIsOrtho) {
            GL11.glOrtho((double)(-Shaders.shadowMapHalfPlane), (double)Shaders.shadowMapHalfPlane, (double)(-Shaders.shadowMapHalfPlane), (double)Shaders.shadowMapHalfPlane, 0.05000000074505806, 256.0);
        }
        else {
            GLU.gluPerspective(Shaders.shadowMapFOV, Shaders.shadowMapWidth / (float)Shaders.shadowMapHeight, 0.05f, 256.0f);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -100.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        Shaders.celestialAngle = Shaders.mc.world.getCelestialAngle(llllllllllllllIllIlIlllllllllIll);
        Shaders.sunAngle = ((Shaders.celestialAngle < 0.75f) ? (Shaders.celestialAngle + 0.25f) : (Shaders.celestialAngle - 0.75f));
        final float llllllllllllllIllIllIIIIIIIIIllI = Shaders.celestialAngle * -360.0f;
        final float llllllllllllllIllIllIIIIIIIIIlIl = (Shaders.shadowAngleInterval > 0.0f) ? (llllllllllllllIllIllIIIIIIIIIllI % Shaders.shadowAngleInterval - Shaders.shadowAngleInterval * 0.5f) : 0.0f;
        if (Shaders.sunAngle <= 0.5) {
            GL11.glRotatef(llllllllllllllIllIllIIIIIIIIIllI - llllllllllllllIllIllIIIIIIIIIlIl, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Shaders.sunPathRotation, 1.0f, 0.0f, 0.0f);
            Shaders.shadowAngle = Shaders.sunAngle;
        }
        else {
            GL11.glRotatef(llllllllllllllIllIllIIIIIIIIIllI + 180.0f - llllllllllllllIllIllIIIIIIIIIlIl, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Shaders.sunPathRotation, 1.0f, 0.0f, 0.0f);
            Shaders.shadowAngle = Shaders.sunAngle - 0.5f;
        }
        if (Shaders.shadowMapIsOrtho) {
            final float llllllllllllllIllIllIIIIIIIIIlII = Shaders.shadowIntervalSize;
            final float llllllllllllllIllIllIIIIIIIIIIll = llllllllllllllIllIllIIIIIIIIIlII / 2.0f;
            GL11.glTranslatef((float)llllllllllllllIllIllIIIIIIIIlIIl % llllllllllllllIllIllIIIIIIIIIlII - llllllllllllllIllIllIIIIIIIIIIll, (float)llllllllllllllIllIllIIIIIIIIlIII % llllllllllllllIllIllIIIIIIIIIlII - llllllllllllllIllIllIIIIIIIIIIll, (float)llllllllllllllIllIllIIIIIIIIIlll % llllllllllllllIllIllIIIIIIIIIlII - llllllllllllllIllIllIIIIIIIIIIll);
        }
        final float llllllllllllllIllIllIIIIIIIIIIlI = Shaders.sunAngle * 6.2831855f;
        final float llllllllllllllIllIllIIIIIIIIIIIl = (float)Math.cos(llllllllllllllIllIllIIIIIIIIIIlI);
        final float llllllllllllllIllIllIIIIIIIIIIII = (float)Math.sin(llllllllllllllIllIllIIIIIIIIIIlI);
        final float llllllllllllllIllIlIllllllllllll = Shaders.sunPathRotation * 6.2831855f;
        float llllllllllllllIllIlIlllllllllllI = llllllllllllllIllIllIIIIIIIIIIIl;
        float llllllllllllllIllIlIllllllllllIl = llllllllllllllIllIllIIIIIIIIIIII * (float)Math.cos(llllllllllllllIllIlIllllllllllll);
        float llllllllllllllIllIlIllllllllllII = llllllllllllllIllIllIIIIIIIIIIII * (float)Math.sin(llllllllllllllIllIlIllllllllllll);
        if (Shaders.sunAngle > 0.5) {
            llllllllllllllIllIlIlllllllllllI = -llllllllllllllIllIllIIIIIIIIIIIl;
            llllllllllllllIllIlIllllllllllIl = -llllllllllllllIllIlIllllllllllIl;
            llllllllllllllIllIlIllllllllllII = -llllllllllllllIllIlIllllllllllII;
        }
        Shaders.shadowLightPositionVector[0] = llllllllllllllIllIlIlllllllllllI;
        Shaders.shadowLightPositionVector[1] = llllllllllllllIllIlIllllllllllIl;
        Shaders.shadowLightPositionVector[2] = llllllllllllllIllIlIllllllllllII;
        Shaders.shadowLightPositionVector[3] = 0.0f;
        GL11.glGetFloat(2983, (FloatBuffer)Shaders.shadowProjection.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.shadowProjectionInverse.position(0), (FloatBuffer)Shaders.shadowProjection.position(0), Shaders.faShadowProjectionInverse, Shaders.faShadowProjection);
        Shaders.shadowProjection.position(0);
        Shaders.shadowProjectionInverse.position(0);
        GL11.glGetFloat(2982, (FloatBuffer)Shaders.shadowModelView.position(0));
        SMath.invertMat4FBFA((FloatBuffer)Shaders.shadowModelViewInverse.position(0), (FloatBuffer)Shaders.shadowModelView.position(0), Shaders.faShadowModelViewInverse, Shaders.faShadowModelView);
        Shaders.shadowModelView.position(0);
        Shaders.shadowModelViewInverse.position(0);
        setProgramUniformMatrix4ARB("gbufferProjection", false, Shaders.projection);
        setProgramUniformMatrix4ARB("gbufferProjectionInverse", false, Shaders.projectionInverse);
        setProgramUniformMatrix4ARB("gbufferPreviousProjection", false, Shaders.previousProjection);
        setProgramUniformMatrix4ARB("gbufferModelView", false, Shaders.modelView);
        setProgramUniformMatrix4ARB("gbufferModelViewInverse", false, Shaders.modelViewInverse);
        setProgramUniformMatrix4ARB("gbufferPreviousModelView", false, Shaders.previousModelView);
        setProgramUniformMatrix4ARB("shadowProjection", false, Shaders.shadowProjection);
        setProgramUniformMatrix4ARB("shadowProjectionInverse", false, Shaders.shadowProjectionInverse);
        setProgramUniformMatrix4ARB("shadowModelView", false, Shaders.shadowModelView);
        setProgramUniformMatrix4ARB("shadowModelViewInverse", false, Shaders.shadowModelViewInverse);
        Shaders.mc.gameSettings.thirdPersonView = 1;
        checkGLError("setCamera");
    }
    
    public static void setProgramUniformMatrix4ARB(final String llllllllllllllIllIllIIIIllIIlIII, final boolean llllllllllllllIllIllIIIIllIIIIlI, final FloatBuffer llllllllllllllIllIllIIIIllIIIllI) {
        final int llllllllllllllIllIllIIIIllIIIlIl = Shaders.programsID[Shaders.activeProgram];
        if (llllllllllllllIllIllIIIIllIIIlIl != 0 && llllllllllllllIllIllIIIIllIIIllI != null) {
            final int llllllllllllllIllIllIIIIllIIIlII = ARBShaderObjects.glGetUniformLocationARB(llllllllllllllIllIllIIIIllIIIlIl, (CharSequence)llllllllllllllIllIllIIIIllIIlIII);
            ARBShaderObjects.glUniformMatrix4ARB(llllllllllllllIllIllIIIIllIIIlII, llllllllllllllIllIllIIIIllIIIIlI, llllllllllllllIllIllIIIIllIIIllI);
            checkGLError(Shaders.programNames[Shaders.activeProgram], llllllllllllllIllIllIIIIllIIlIII);
        }
    }
    
    public static void pushEntity(final Block llllllllllllllIllIlIllllIlIllllI) {
        ++Shaders.entityDataIndex;
        final int llllllllllllllIllIlIllllIlIlllll = llllllllllllllIllIlIllllIlIllllI.getRenderType(llllllllllllllIllIlIllllIlIllllI.getDefaultState()).ordinal();
        Shaders.entityData[Shaders.entityDataIndex * 2] = ((Block.REGISTRY.getIDForObject(llllllllllllllIllIlIllllIlIllllI) & 0xFFFF) | llllllllllllllIllIlIllllIlIlllll << 16);
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }
    
    public static void startup(Minecraft llllllllllllllIllIllIIlIIIlIIllI) {
        checkShadersModInstalled();
        Shaders.mc = llllllllllllllIllIllIIlIIIlIIllI;
        llllllllllllllIllIllIIlIIIlIIllI = Minecraft.getMinecraft();
        Shaders.capabilities = GLContext.getCapabilities();
        Shaders.glVersionString = GL11.glGetString(7938);
        Shaders.glVendorString = GL11.glGetString(7936);
        Shaders.glRendererString = GL11.glGetString(7937);
        SMCLog.info("ShadersMod version: 2.4.12");
        SMCLog.info(String.valueOf(new StringBuilder("OpenGL Version: ").append(Shaders.glVersionString)));
        SMCLog.info(String.valueOf(new StringBuilder("Vendor:  ").append(Shaders.glVendorString)));
        SMCLog.info(String.valueOf(new StringBuilder("Renderer: ").append(Shaders.glRendererString)));
        SMCLog.info(String.valueOf(new StringBuilder("Capabilities: ").append(Shaders.capabilities.OpenGL20 ? " 2.0 " : " - ").append(Shaders.capabilities.OpenGL21 ? " 2.1 " : " - ").append(Shaders.capabilities.OpenGL30 ? " 3.0 " : " - ").append(Shaders.capabilities.OpenGL32 ? " 3.2 " : " - ").append(Shaders.capabilities.OpenGL40 ? " 4.0 " : " - ")));
        SMCLog.info(String.valueOf(new StringBuilder("GL_MAX_DRAW_BUFFERS: ").append(GL11.glGetInteger(34852))));
        SMCLog.info(String.valueOf(new StringBuilder("GL_MAX_COLOR_ATTACHMENTS_EXT: ").append(GL11.glGetInteger(36063))));
        SMCLog.info(String.valueOf(new StringBuilder("GL_MAX_TEXTURE_IMAGE_UNITS: ").append(GL11.glGetInteger(34930))));
        Shaders.hasGlGenMipmap = Shaders.capabilities.OpenGL30;
        loadConfig();
    }
    
    public static boolean isRenderingFirstPersonHand() {
        return Shaders.isRenderingFirstPersonHand;
    }
    
    static String versiontostring(final int llllllllllllllIllIllIIlIllllIIIl) {
        final String llllllllllllllIllIllIIlIllllIIlI = Integer.toString(llllllllllllllIllIllIIlIllllIIIl);
        return String.valueOf(new StringBuilder(String.valueOf(Integer.toString(Integer.parseInt(llllllllllllllIllIllIIlIllllIIlI.substring(1, 3))))).append(".").append(Integer.toString(Integer.parseInt(llllllllllllllIllIllIIlIllllIIlI.substring(3, 5)))).append(".").append(Integer.toString(Integer.parseInt(llllllllllllllIllIllIIlIllllIIlI.substring(5)))));
    }
    
    private static void clearDirectory(final File llllllllllllllIllIllIIIlIllIIIII) {
        if (llllllllllllllIllIllIIIlIllIIIII.exists() && llllllllllllllIllIllIIIlIllIIIII.isDirectory()) {
            final File[] llllllllllllllIllIllIIIlIlIlllll = llllllllllllllIllIllIIIlIllIIIII.listFiles();
            if (llllllllllllllIllIllIIIlIlIlllll != null) {
                for (int llllllllllllllIllIllIIIlIlIllllI = 0; llllllllllllllIllIllIIIlIlIllllI < llllllllllllllIllIllIIIlIlIlllll.length; ++llllllllllllllIllIllIIIlIlIllllI) {
                    final File llllllllllllllIllIllIIIlIlIlllIl = llllllllllllllIllIllIIIlIlIlllll[llllllllllllllIllIllIIIlIlIllllI];
                    if (llllllllllllllIllIllIIIlIlIlllIl.isDirectory()) {
                        clearDirectory(llllllllllllllIllIllIIIlIlIlllIl);
                    }
                    llllllllllllllIllIllIIIlIlIlllIl.delete();
                }
            }
        }
    }
    
    public static void mcProfilerEndSection() {
        Shaders.mc.mcProfiler.endSection();
    }
    
    private static void setupShadowFrameBuffer() {
        if (Shaders.usedShadowDepthBuffers != 0) {
            if (Shaders.sfb != 0) {
                EXTFramebufferObject.glDeleteFramebuffersEXT(Shaders.sfb);
                GlStateManager.deleteTextures(Shaders.sfbDepthTextures);
                GlStateManager.deleteTextures(Shaders.sfbColorTextures);
            }
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.sfb = EXTFramebufferObject.glGenFramebuffersEXT());
            GL11.glDrawBuffer(0);
            GL11.glReadBuffer(0);
            GL11.glGenTextures((IntBuffer)Shaders.sfbDepthTextures.clear().limit(Shaders.usedShadowDepthBuffers));
            GL11.glGenTextures((IntBuffer)Shaders.sfbColorTextures.clear().limit(Shaders.usedShadowColorBuffers));
            Shaders.sfbDepthTextures.position(0);
            Shaders.sfbColorTextures.position(0);
            for (int llllllllllllllIllIllIIIIlIIIIIIl = 0; llllllllllllllIllIllIIIIlIIIIIIl < Shaders.usedShadowDepthBuffers; ++llllllllllllllIllIllIIIIlIIIIIIl) {
                GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(llllllllllllllIllIllIIIIlIIIIIIl));
                GL11.glTexParameterf(3553, 10242, 10496.0f);
                GL11.glTexParameterf(3553, 10243, 10496.0f);
                final int llllllllllllllIllIllIIIIlIIIIIII = Shaders.shadowFilterNearest[llllllllllllllIllIllIIIIlIIIIIIl] ? 9728 : 9729;
                GL11.glTexParameteri(3553, 10241, llllllllllllllIllIllIIIIlIIIIIII);
                GL11.glTexParameteri(3553, 10240, llllllllllllllIllIllIIIIlIIIIIII);
                if (Shaders.shadowHardwareFilteringEnabled[llllllllllllllIllIllIIIIlIIIIIIl]) {
                    GL11.glTexParameteri(3553, 34892, 34894);
                }
                GL11.glTexImage2D(3553, 0, 6402, Shaders.shadowMapWidth, Shaders.shadowMapHeight, 0, 6402, 5126, (FloatBuffer)null);
            }
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.sfbDepthTextures.get(0), 0);
            checkGLError("FT sd");
            for (int llllllllllllllIllIllIIIIIlllllll = 0; llllllllllllllIllIllIIIIIlllllll < Shaders.usedShadowColorBuffers; ++llllllllllllllIllIllIIIIIlllllll) {
                GlStateManager.bindTexture(Shaders.sfbColorTextures.get(llllllllllllllIllIllIIIIIlllllll));
                GL11.glTexParameterf(3553, 10242, 10496.0f);
                GL11.glTexParameterf(3553, 10243, 10496.0f);
                final int llllllllllllllIllIllIIIIIllllllI = Shaders.shadowColorFilterNearest[llllllllllllllIllIllIIIIIlllllll] ? 9728 : 9729;
                GL11.glTexParameteri(3553, 10241, llllllllllllllIllIllIIIIIllllllI);
                GL11.glTexParameteri(3553, 10240, llllllllllllllIllIllIIIIIllllllI);
                GL11.glTexImage2D(3553, 0, 6408, Shaders.shadowMapWidth, Shaders.shadowMapHeight, 0, 32993, 33639, (ByteBuffer)null);
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064 + llllllllllllllIllIllIIIIIlllllll, 3553, Shaders.sfbColorTextures.get(llllllllllllllIllIllIIIIIlllllll), 0);
                checkGLError("FT sc");
            }
            GlStateManager.bindTexture(0);
            if (Shaders.usedShadowColorBuffers > 0) {
                GL20.glDrawBuffers(Shaders.sfbDrawBuffers);
            }
            final int llllllllllllllIllIllIIIIIlllllIl = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
            if (llllllllllllllIllIllIIIIIlllllIl != 36053) {
                printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Failed creating shadow framebuffer! (Status ").append(llllllllllllllIllIllIIIIIlllllIl).append(")")));
            }
            else {
                SMCLog.info("Shadow framebuffer created.");
            }
        }
    }
    
    private static boolean printLogInfo(final int llllllllllllllIllIllIIIlIlIlIIIl, final String llllllllllllllIllIllIIIlIlIlIIII) {
        final IntBuffer llllllllllllllIllIllIIIlIlIIllll = BufferUtils.createIntBuffer(1);
        ARBShaderObjects.glGetObjectParameterARB(llllllllllllllIllIllIIIlIlIlIIIl, 35716, llllllllllllllIllIllIIIlIlIIllll);
        final int llllllllllllllIllIllIIIlIlIIlllI = llllllllllllllIllIllIIIlIlIIllll.get();
        if (llllllllllllllIllIllIIIlIlIIlllI > 1) {
            final ByteBuffer llllllllllllllIllIllIIIlIlIIllIl = BufferUtils.createByteBuffer(llllllllllllllIllIllIIIlIlIIlllI);
            llllllllllllllIllIllIIIlIlIIllll.flip();
            ARBShaderObjects.glGetInfoLogARB(llllllllllllllIllIllIIIlIlIlIIIl, llllllllllllllIllIllIIIlIlIIllll, llllllllllllllIllIllIIIlIlIIllIl);
            final byte[] llllllllllllllIllIllIIIlIlIIllII = new byte[llllllllllllllIllIllIIIlIlIIlllI];
            llllllllllllllIllIllIIIlIlIIllIl.get(llllllllllllllIllIllIIIlIlIIllII);
            if (llllllllllllllIllIllIIIlIlIIllII[llllllllllllllIllIllIIIlIlIIlllI - 1] == 0) {
                llllllllllllllIllIllIIIlIlIIllII[llllllllllllllIllIllIIIlIlIIlllI - 1] = 10;
            }
            final String llllllllllllllIllIllIIIlIlIIlIll = new String(llllllllllllllIllIllIIIlIlIIllII);
            SMCLog.info(String.valueOf(new StringBuilder("Info log: ").append(llllllllllllllIllIllIIIlIlIlIIII).append("\n").append(llllllllllllllIllIllIIIlIlIIlIll)));
            return false;
        }
        return true;
    }
    
    public static void loadConfig() {
        SMCLog.info("Load ShadersMod configuration.");
        try {
            if (!Shaders.shaderpacksdir.exists()) {
                Shaders.shaderpacksdir.mkdir();
            }
        }
        catch (Exception llllllllllllllIllIllIlIIIlIlllIl) {
            SMCLog.severe(String.valueOf(new StringBuilder("Failed to open the shaderpacks directory: ").append(Shaders.shaderpacksdir)));
        }
        (Shaders.shadersConfig = new PropertiesOrdered()).setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), "");
        if (Shaders.configFile.exists()) {
            try {
                final FileReader llllllllllllllIllIllIlIIIlIlllII = new FileReader(Shaders.configFile);
                Shaders.shadersConfig.load(llllllllllllllIllIllIlIIIlIlllII);
                llllllllllllllIllIllIlIIIlIlllII.close();
            }
            catch (Exception ex) {}
        }
        if (!Shaders.configFile.exists()) {
            try {
                storeConfig();
            }
            catch (Exception ex2) {}
        }
        final EnumShaderOption[] llllllllllllllIllIllIlIIIlIllIll = EnumShaderOption.values();
        for (int llllllllllllllIllIllIlIIIlIllIlI = 0; llllllllllllllIllIllIlIIIlIllIlI < llllllllllllllIllIllIlIIIlIllIll.length; ++llllllllllllllIllIllIlIIIlIllIlI) {
            final EnumShaderOption llllllllllllllIllIllIlIIIlIllIIl = llllllllllllllIllIllIlIIIlIllIll[llllllllllllllIllIllIlIIIlIllIlI];
            final String llllllllllllllIllIllIlIIIlIllIII = llllllllllllllIllIllIlIIIlIllIIl.getPropertyKey();
            final String llllllllllllllIllIllIlIIIlIlIlll = llllllllllllllIllIllIlIIIlIllIIl.getValueDefault();
            final String llllllllllllllIllIllIlIIIlIlIllI = Shaders.shadersConfig.getProperty(llllllllllllllIllIllIlIIIlIllIII, llllllllllllllIllIllIlIIIlIlIlll);
            setEnumShaderOption(llllllllllllllIllIllIlIIIlIllIIl, llllllllllllllIllIllIlIIIlIlIllI);
        }
        loadShaderPack();
    }
    
    private static String applyOptions(String llllllllllllllIllIllIIllIIIIllII, final ShaderOption[] llllllllllllllIllIllIIllIIIIlIll) {
        if (llllllllllllllIllIllIIllIIIIlIll != null && llllllllllllllIllIllIIllIIIIlIll.length > 0) {
            for (int llllllllllllllIllIllIIllIIIIllll = 0; llllllllllllllIllIllIIllIIIIllll < llllllllllllllIllIllIIllIIIIlIll.length; ++llllllllllllllIllIllIIllIIIIllll) {
                final ShaderOption llllllllllllllIllIllIIllIIIIlllI = llllllllllllllIllIllIIllIIIIlIll[llllllllllllllIllIllIIllIIIIllll];
                final String llllllllllllllIllIllIIllIIIIllIl = llllllllllllllIllIllIIllIIIIlllI.getName();
                if (llllllllllllllIllIllIIllIIIIlllI.matchesLine(llllllllllllllIllIllIIllIIIIllII)) {
                    llllllllllllllIllIllIIllIIIIllII = llllllllllllllIllIllIIllIIIIlllI.getSourceLine();
                    break;
                }
            }
            return llllllllllllllIllIllIIllIIIIllII;
        }
        return llllllllllllllIllIllIIllIIIIllII;
    }
    
    public static void beginBeacon() {
        if (Shaders.isRenderingWorld) {
            useProgram(14);
        }
    }
    
    public static void beginLitParticles() {
        useProgram(3);
    }
    
    public static void updateBlockLightLevel() {
        if (isOldLighting()) {
            Shaders.blockLightLevel05 = 0.5f;
            Shaders.blockLightLevel06 = 0.6f;
            Shaders.blockLightLevel08 = 0.8f;
        }
        else {
            Shaders.blockLightLevel05 = 1.0f;
            Shaders.blockLightLevel06 = 1.0f;
            Shaders.blockLightLevel08 = 1.0f;
        }
    }
    
    public static boolean isMoon() {
        return !Shaders.shaderPackMoon.isFalse();
    }
    
    public static void loadShaderPack() {
        final boolean llllllllllllllIllIllIlIIIIlIllII = Shaders.shaderPackLoaded;
        final boolean llllllllllllllIllIllIlIIIIlIlIll = isOldLighting();
        Shaders.shaderPackLoaded = false;
        if (Shaders.shaderPack != null) {
            Shaders.shaderPack.close();
            Shaders.shaderPack = null;
            Shaders.shaderPackResources.clear();
            Shaders.shaderPackDimensions.clear();
            Shaders.shaderPackOptions = null;
            Shaders.shaderPackOptionSliders = null;
            Shaders.shaderPackProfiles = null;
            Shaders.shaderPackGuiScreens = null;
            Shaders.shaderPackClouds.resetValue();
            Shaders.shaderPackOldHandLight.resetValue();
            Shaders.shaderPackDynamicHandLight.resetValue();
            Shaders.shaderPackOldLighting.resetValue();
            resetCustomTextures();
            Shaders.noiseTexturePath = null;
        }
        boolean llllllllllllllIllIllIlIIIIlIlIlI = false;
        if (Config.isAntialiasing()) {
            SMCLog.info(String.valueOf(new StringBuilder("Shaders can not be loaded, Antialiasing is enabled: ").append(Config.getAntialiasingLevel()).append("x")));
            llllllllllllllIllIllIlIIIIlIlIlI = true;
        }
        if (Config.isAnisotropicFiltering()) {
            SMCLog.info(String.valueOf(new StringBuilder("Shaders can not be loaded, Anisotropic Filtering is enabled: ").append(Config.getAnisotropicFilterLevel()).append("x")));
            llllllllllllllIllIllIlIIIIlIlIlI = true;
        }
        if (Config.isFastRender()) {
            SMCLog.info("Shaders can not be loaded, Fast Render is enabled.");
            llllllllllllllIllIllIlIIIIlIlIlI = true;
        }
        final String llllllllllllllIllIllIlIIIIlIlIIl = Shaders.shadersConfig.getProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), Shaders.packNameDefault);
        if (!llllllllllllllIllIllIlIIIIlIlIIl.isEmpty() && !llllllllllllllIllIllIlIIIIlIlIIl.equals(Shaders.packNameNone) && !llllllllllllllIllIllIlIIIIlIlIlI) {
            if (llllllllllllllIllIllIlIIIIlIlIIl.equals(Shaders.packNameDefault)) {
                Shaders.shaderPack = new ShaderPackDefault();
                Shaders.shaderPackLoaded = true;
            }
            else {
                try {
                    final File llllllllllllllIllIllIlIIIIlIlIII = new File(Shaders.shaderpacksdir, llllllllllllllIllIllIlIIIIlIlIIl);
                    if (llllllllllllllIllIllIlIIIIlIlIII.isDirectory()) {
                        Shaders.shaderPack = new ShaderPackFolder(llllllllllllllIllIllIlIIIIlIlIIl, llllllllllllllIllIllIlIIIIlIlIII);
                        Shaders.shaderPackLoaded = true;
                    }
                    else if (llllllllllllllIllIllIlIIIIlIlIII.isFile() && llllllllllllllIllIllIlIIIIlIlIIl.toLowerCase().endsWith(".zip")) {
                        Shaders.shaderPack = new ShaderPackZip(llllllllllllllIllIllIlIIIIlIlIIl, llllllllllllllIllIllIlIIIIlIlIII);
                        Shaders.shaderPackLoaded = true;
                    }
                }
                catch (Exception ex) {}
            }
        }
        if (Shaders.shaderPack != null) {
            SMCLog.info(String.valueOf(new StringBuilder("Loaded shaderpack: ").append(getShaderPackName())));
        }
        else {
            SMCLog.info("No shaderpack loaded.");
            Shaders.shaderPack = new ShaderPackNone();
        }
        loadShaderPackResources();
        loadShaderPackDimensions();
        Shaders.shaderPackOptions = loadShaderPackOptions();
        loadShaderPackProperties();
        final boolean llllllllllllllIllIllIlIIIIlIIlll = Shaders.shaderPackLoaded ^ llllllllllllllIllIllIlIIIIlIllII;
        final boolean llllllllllllllIllIllIlIIIIlIIllI = isOldLighting() ^ llllllllllllllIllIllIlIIIIlIlIll;
        if (llllllllllllllIllIllIlIIIIlIIlll || llllllllllllllIllIllIlIIIIlIIllI) {
            DefaultVertexFormats.updateVertexFormats();
            if (Reflector.LightUtil.exists()) {
                Reflector.LightUtil_itemConsumer.setValue(null);
                Reflector.LightUtil_tessellator.setValue(null);
            }
            updateBlockLightLevel();
            Shaders.mc.scheduleResourcesRefresh();
        }
    }
    
    public static void sglDisableFog(final int llllllllllllllIllIlIllllIlllllII) {
        GL11.glDisable(llllllllllllllIllIlIllllIlllllII);
        disableFog();
    }
    
    public static void endLeash() {
        useProgram(16);
    }
    
    public static void resetDisplayListModel(final ModelBase llllllllllllllIllIllIIIlllIllIIl) {
        if (llllllllllllllIllIllIIIlllIllIIl != null) {
            for (final Object llllllllllllllIllIllIIIlllIllIII : llllllllllllllIllIllIIIlllIllIIl.boxList) {
                if (llllllllllllllIllIllIIIlllIllIII instanceof ModelRenderer) {
                    resetDisplayListModelRenderer((ModelRenderer)llllllllllllllIllIllIIIlllIllIII);
                }
            }
        }
    }
    
    public static InputStream getShaderPackResourceStream(final String llllllllllllllIllIlIllllIlIllIll) {
        return (Shaders.shaderPack == null) ? null : Shaders.shaderPack.getResourceAsStream(llllllllllllllIllIlIllllIlIllIll);
    }
    
    public static void preCelestialRotate() {
        GL11.glRotatef(Shaders.sunPathRotation * 1.0f, 0.0f, 0.0f, 1.0f);
        checkGLError("preCelestialRotate");
    }
    
    public static int getEntityData2() {
        return Shaders.entityData[Shaders.entityDataIndex * 2 + 1];
    }
    
    public static int checkFramebufferStatus(final String llllllllllllllIllIllIIlIlllIllIl) {
        final int llllllllllllllIllIllIIlIlllIllII = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
        if (llllllllllllllIllIllIIlIlllIllII != 36053) {
            System.err.format("FramebufferStatus 0x%04X at %s\n", llllllllllllllIllIllIIlIlllIllII, llllllllllllllIllIllIIlIlllIllIl);
        }
        return llllllllllllllIllIllIIlIlllIllII;
    }
    
    public static void setEntityColor(final float llllllllllllllIllIlIlllllIlIIllI, final float llllllllllllllIllIlIlllllIlIIIIl, final float llllllllllllllIllIlIlllllIlIIlII, final float llllllllllllllIllIlIlllllIIlllll) {
        if (Shaders.isRenderingWorld && !Shaders.isShadowPass) {
            Shaders.uniformEntityColor.setValue(llllllllllllllIllIlIlllllIlIIllI, llllllllllllllIllIlIlllllIlIIIIl, llllllllllllllIllIlIlllllIlIIlII, llllllllllllllIllIlIlllllIIlllll);
        }
    }
    
    public static String getShaderPackName() {
        if (Shaders.shaderPack == null) {
            return null;
        }
        return (Shaders.shaderPack instanceof ShaderPackNone) ? null : Shaders.shaderPack.getName();
    }
    
    public static void beginLeash() {
        useProgram(1);
    }
    
    public static void setClearColor(final float llllllllllllllIllIllIIIIIIllIIll, final float llllllllllllllIllIllIIIIIIllIIlI, final float llllllllllllllIllIllIIIIIIllIIIl, final float llllllllllllllIllIllIIIIIIlIllII) {
        GlStateManager.clearColor(llllllllllllllIllIllIIIIIIllIIll, llllllllllllllIllIllIIIIIIllIIlI, llllllllllllllIllIllIIIIIIllIIIl, llllllllllllllIllIllIIIIIIlIllII);
        Shaders.clearColorR = llllllllllllllIllIllIIIIIIllIIll;
        Shaders.clearColorG = llllllllllllllIllIllIIIIIIllIIlI;
        Shaders.clearColorB = llllllllllllllIllIllIIIIIIllIIIl;
    }
    
    public static ShaderOption getShaderOption(final String llllllllllllllIllIllIIllIlllIIll) {
        return ShaderUtils.getShaderOption(llllllllllllllIllIllIIllIlllIIll, Shaders.shaderPackOptions);
    }
    
    public static void endProjectRedHalo() {
        if (Shaders.isRenderingWorld) {
            useProgram(3);
        }
    }
    
    private static int getBufferIndexFromString(final String llllllllllllllIllIllIIIIlIllllII) {
        if (llllllllllllllIllIllIIIIlIllllII.equals("colortex0") || llllllllllllllIllIllIIIIlIllllII.equals("gcolor")) {
            return 0;
        }
        if (llllllllllllllIllIllIIIIlIllllII.equals("colortex1") || llllllllllllllIllIllIIIIlIllllII.equals("gdepth")) {
            return 1;
        }
        if (llllllllllllllIllIllIIIIlIllllII.equals("colortex2") || llllllllllllllIllIllIIIIlIllllII.equals("gnormal")) {
            return 2;
        }
        if (llllllllllllllIllIllIIIIlIllllII.equals("colortex3") || llllllllllllllIllIllIIIIlIllllII.equals("composite")) {
            return 3;
        }
        if (llllllllllllllIllIllIIIIlIllllII.equals("colortex4") || llllllllllllllIllIllIIIIlIllllII.equals("gaux1")) {
            return 4;
        }
        if (llllllllllllllIllIllIIIIlIllllII.equals("colortex5") || llllllllllllllIllIllIIIIlIllllII.equals("gaux2")) {
            return 5;
        }
        if (!llllllllllllllIllIllIIIIlIllllII.equals("colortex6") && !llllllllllllllIllIllIIIIlIllllII.equals("gaux3")) {
            return (!llllllllllllllIllIllIIIIlIllllII.equals("colortex7") && !llllllllllllllIllIllIIIIlIllllII.equals("gaux4")) ? -1 : 7;
        }
        return 6;
    }
    
    public static void disableLightmap() {
        Shaders.lightmapEnabled = false;
        if (Shaders.activeProgram == 3) {
            useProgram(2);
        }
    }
    
    public static void popEntity() {
        Shaders.entityData[Shaders.entityDataIndex * 2] = 0;
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
        --Shaders.entityDataIndex;
    }
    
    public static void endBlockEntities() {
        if (Shaders.isRenderingWorld) {
            checkGLError("endBlockEntities");
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
            ShadersTex.bindNSTextures(Shaders.defaultTexture.getMultiTexID());
        }
    }
    
    public static void pushEntity(final int llllllllllllllIllIlIllllIllIlIIl, final int llllllllllllllIllIlIllllIllIIllI) {
        ++Shaders.entityDataIndex;
        Shaders.entityData[Shaders.entityDataIndex * 2] = ((llllllllllllllIllIlIllllIllIlIIl & 0xFFFF) | llllllllllllllIllIlIllllIllIIllI << 16);
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = 0;
    }
    
    public static void endWater() {
        if (Shaders.isRenderingWorld) {
            if (Shaders.isShadowPass) {}
            useProgram(Shaders.lightmapEnabled ? 3 : 2);
        }
    }
    
    public static int setEntityData2(final int llllllllllllllIllIlIllllIllIllIl) {
        Shaders.entityData[Shaders.entityDataIndex * 2 + 1] = ((Shaders.entityData[Shaders.entityDataIndex * 2 + 1] & 0xFFFF0000) | (llllllllllllllIllIlIllllIllIllIl & 0xFFFF));
        return llllllllllllllIllIlIllllIllIllIl;
    }
    
    public static void setSkipRenderHands(final boolean llllllllllllllIllIlIllllIIIIllIl, final boolean llllllllllllllIllIlIllllIIIIlIlI) {
        Shaders.skipRenderHandMain = llllllllllllllIllIlIllllIIIIllIl;
        Shaders.skipRenderHandOff = llllllllllllllIllIlIllllIIIIlIlI;
    }
    
    public static void init() {
        boolean llllllllllllllIllIllIIlIIIIIIlII = false;
        if (!Shaders.isInitializedOnce) {
            Shaders.isInitializedOnce = true;
            final boolean llllllllllllllIllIllIIlIIIIIIlIl = true;
        }
        else {
            llllllllllllllIllIllIIlIIIIIIlII = false;
        }
        if (!Shaders.isShaderPackInitialized) {
            checkGLError("Shaders.init pre");
            if (getShaderPackName() != null) {}
            if (!Shaders.capabilities.OpenGL20) {
                printChatAndLogError("No OpenGL 2.0");
            }
            if (!Shaders.capabilities.GL_EXT_framebuffer_object) {
                printChatAndLogError("No EXT_framebuffer_object");
            }
            Shaders.dfbDrawBuffers.position(0).limit(8);
            Shaders.dfbColorTextures.position(0).limit(16);
            Shaders.dfbDepthTextures.position(0).limit(3);
            Shaders.sfbDrawBuffers.position(0).limit(8);
            Shaders.sfbDepthTextures.position(0).limit(2);
            Shaders.sfbColorTextures.position(0).limit(8);
            Shaders.usedColorBuffers = 4;
            Shaders.usedDepthBuffers = 1;
            Shaders.usedShadowColorBuffers = 0;
            Shaders.usedShadowDepthBuffers = 0;
            Shaders.usedColorAttachs = 1;
            Shaders.usedDrawBuffers = 1;
            Arrays.fill(Shaders.gbuffersFormat, 6408);
            Arrays.fill(Shaders.gbuffersClear, true);
            Arrays.fill(Shaders.shadowHardwareFilteringEnabled, false);
            Arrays.fill(Shaders.shadowMipmapEnabled, false);
            Arrays.fill(Shaders.shadowFilterNearest, false);
            Arrays.fill(Shaders.shadowColorMipmapEnabled, false);
            Arrays.fill(Shaders.shadowColorFilterNearest, false);
            Shaders.centerDepthSmoothEnabled = false;
            Shaders.noiseTextureEnabled = false;
            Shaders.sunPathRotation = 0.0f;
            Shaders.shadowIntervalSize = 2.0f;
            Shaders.shadowDistanceRenderMul = -1.0f;
            Shaders.aoLevel = -1.0f;
            Shaders.useEntityAttrib = false;
            Shaders.useMidTexCoordAttrib = false;
            Shaders.useMultiTexCoord3Attrib = false;
            Shaders.useTangentAttrib = false;
            Shaders.waterShadowEnabled = false;
            Shaders.updateChunksErrorRecorded = false;
            updateBlockLightLevel();
            final ShaderProfile llllllllllllllIllIllIIlIIIIIIIll = ShaderUtils.detectProfile(Shaders.shaderPackProfiles, Shaders.shaderPackOptions, false);
            String llllllllllllllIllIllIIlIIIIIIIlI = "";
            if (Shaders.currentWorld != null) {
                final int llllllllllllllIllIllIIlIIIIIIIIl = Shaders.currentWorld.provider.getDimensionType().getId();
                if (Shaders.shaderPackDimensions.contains(llllllllllllllIllIllIIlIIIIIIIIl)) {
                    llllllllllllllIllIllIIlIIIIIIIlI = String.valueOf(new StringBuilder("world").append(llllllllllllllIllIllIIlIIIIIIIIl).append("/"));
                }
            }
            if (Shaders.saveFinalShaders) {
                clearDirectory(new File(Shaders.shaderpacksdir, "debug"));
            }
            for (int llllllllllllllIllIllIIlIIIIIIIII = 0; llllllllllllllIllIllIIlIIIIIIIII < 33; ++llllllllllllllIllIllIIlIIIIIIIII) {
                String llllllllllllllIllIllIIIlllllllll = Shaders.programNames[llllllllllllllIllIllIIlIIIIIIIII];
                if (llllllllllllllIllIllIIIlllllllll.equals("")) {
                    Shaders.programsID[llllllllllllllIllIllIIlIIIIIIIII] = (Shaders.programsRef[llllllllllllllIllIllIIlIIIIIIIII] = 0);
                    Shaders.programsDrawBufSettings[llllllllllllllIllIllIIlIIIIIIIII] = null;
                    Shaders.programsColorAtmSettings[llllllllllllllIllIllIIlIIIIIIIII] = null;
                    Shaders.programsCompositeMipmapSetting[llllllllllllllIllIllIIlIIIIIIIII] = 0;
                }
                else {
                    Shaders.newDrawBufSetting = null;
                    Shaders.newColorAtmSetting = null;
                    Shaders.newCompositeMipmapSetting = 0;
                    String llllllllllllllIllIllIIIllllllllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIlIIIIIIIlI)).append(llllllllllllllIllIllIIIlllllllll));
                    if (llllllllllllllIllIllIIlIIIIIIIll != null && llllllllllllllIllIllIIlIIIIIIIll.isProgramDisabled(llllllllllllllIllIllIIIllllllllI)) {
                        SMCLog.info(String.valueOf(new StringBuilder("Program disabled: ").append(llllllllllllllIllIllIIIllllllllI)));
                        llllllllllllllIllIllIIIlllllllll = "<disabled>";
                        llllllllllllllIllIllIIIllllllllI = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIlIIIIIIIlI)).append(llllllllllllllIllIllIIIlllllllll));
                    }
                    final String llllllllllllllIllIllIIIlllllllIl = String.valueOf(new StringBuilder("/shaders/").append(llllllllllllllIllIllIIIllllllllI));
                    final int llllllllllllllIllIllIIIlllllllII = setupProgram(llllllllllllllIllIllIIlIIIIIIIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIIlllllllIl)).append(".vsh")), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIllIIIlllllllIl)).append(".fsh")));
                    if (llllllllllllllIllIllIIIlllllllII > 0) {
                        SMCLog.info(String.valueOf(new StringBuilder("Program loaded: ").append(llllllllllllllIllIllIIIllllllllI)));
                    }
                    Shaders.programsID[llllllllllllllIllIllIIlIIIIIIIII] = (Shaders.programsRef[llllllllllllllIllIllIIlIIIIIIIII] = llllllllllllllIllIllIIIlllllllII);
                    Shaders.programsDrawBufSettings[llllllllllllllIllIllIIlIIIIIIIII] = ((llllllllllllllIllIllIIIlllllllII != 0) ? Shaders.newDrawBufSetting : null);
                    Shaders.programsColorAtmSettings[llllllllllllllIllIllIIlIIIIIIIII] = ((llllllllllllllIllIllIIIlllllllII != 0) ? Shaders.newColorAtmSetting : null);
                    Shaders.programsCompositeMipmapSetting[llllllllllllllIllIllIIlIIIIIIIII] = ((llllllllllllllIllIllIIIlllllllII != 0) ? Shaders.newCompositeMipmapSetting : 0);
                }
            }
            final int llllllllllllllIllIllIIIllllllIll = GL11.glGetInteger(34852);
            new HashMap();
            for (int llllllllllllllIllIllIIIllllllIlI = 0; llllllllllllllIllIllIIIllllllIlI < 33; ++llllllllllllllIllIllIIIllllllIlI) {
                Arrays.fill(Shaders.programsToggleColorTextures[llllllllllllllIllIllIIIllllllIlI], false);
                if (llllllllllllllIllIllIIIllllllIlI == 29) {
                    Shaders.programsDrawBuffers[llllllllllllllIllIllIIIllllllIlI] = null;
                }
                else if (Shaders.programsID[llllllllllllllIllIllIIIllllllIlI] == 0) {
                    if (llllllllllllllIllIllIIIllllllIlI == 30) {
                        Shaders.programsDrawBuffers[llllllllllllllIllIllIIIllllllIlI] = Shaders.drawBuffersNone;
                    }
                    else {
                        Shaders.programsDrawBuffers[llllllllllllllIllIllIIIllllllIlI] = Shaders.drawBuffersColorAtt0;
                    }
                }
                else {
                    final String llllllllllllllIllIllIIIllllllIIl = Shaders.programsDrawBufSettings[llllllllllllllIllIllIIIllllllIlI];
                    if (llllllllllllllIllIllIIIllllllIIl != null) {
                        final IntBuffer llllllllllllllIllIllIIIllllllIII = Shaders.drawBuffersBuffer[llllllllllllllIllIllIIIllllllIlI];
                        int llllllllllllllIllIllIIIlllllIlll = llllllllllllllIllIllIIIllllllIIl.length();
                        if (llllllllllllllIllIllIIIlllllIlll > Shaders.usedDrawBuffers) {
                            Shaders.usedDrawBuffers = llllllllllllllIllIllIIIlllllIlll;
                        }
                        if (llllllllllllllIllIllIIIlllllIlll > llllllllllllllIllIllIIIllllllIll) {
                            llllllllllllllIllIllIIIlllllIlll = llllllllllllllIllIllIIIllllllIll;
                        }
                        (Shaders.programsDrawBuffers[llllllllllllllIllIllIIIllllllIlI] = llllllllllllllIllIllIIIllllllIII).limit(llllllllllllllIllIllIIIlllllIlll);
                        for (int llllllllllllllIllIllIIIlllllIllI = 0; llllllllllllllIllIllIIIlllllIllI < llllllllllllllIllIllIIIlllllIlll; ++llllllllllllllIllIllIIIlllllIllI) {
                            int llllllllllllllIllIllIIIlllllIlIl = 0;
                            if (llllllllllllllIllIllIIIllllllIIl.length() > llllllllllllllIllIllIIIlllllIllI) {
                                final int llllllllllllllIllIllIIIlllllIlII = llllllllllllllIllIllIIIllllllIIl.charAt(llllllllllllllIllIllIIIlllllIllI) - '0';
                                if (llllllllllllllIllIllIIIllllllIlI != 30) {
                                    if (llllllllllllllIllIllIIIlllllIlII >= 0 && llllllllllllllIllIllIIIlllllIlII <= 7) {
                                        Shaders.programsToggleColorTextures[llllllllllllllIllIllIIIllllllIlI][llllllllllllllIllIllIIIlllllIlII] = true;
                                        llllllllllllllIllIllIIIlllllIlIl = llllllllllllllIllIllIIIlllllIlII + 36064;
                                        if (llllllllllllllIllIllIIIlllllIlII > Shaders.usedColorAttachs) {
                                            Shaders.usedColorAttachs = llllllllllllllIllIllIIIlllllIlII;
                                        }
                                        if (llllllllllllllIllIllIIIlllllIlII > Shaders.usedColorBuffers) {
                                            Shaders.usedColorBuffers = llllllllllllllIllIllIIIlllllIlII;
                                        }
                                    }
                                }
                                else if (llllllllllllllIllIllIIIlllllIlII >= 0 && llllllllllllllIllIllIIIlllllIlII <= 1) {
                                    llllllllllllllIllIllIIIlllllIlIl = llllllllllllllIllIllIIIlllllIlII + 36064;
                                    if (llllllllllllllIllIllIIIlllllIlII > Shaders.usedShadowColorBuffers) {
                                        Shaders.usedShadowColorBuffers = llllllllllllllIllIllIIIlllllIlII;
                                    }
                                }
                            }
                            llllllllllllllIllIllIIIllllllIII.put(llllllllllllllIllIllIIIlllllIllI, llllllllllllllIllIllIIIlllllIlIl);
                        }
                    }
                    else if (llllllllllllllIllIllIIIllllllIlI != 30 && llllllllllllllIllIllIIIllllllIlI != 31 && llllllllllllllIllIllIIIllllllIlI != 32) {
                        Shaders.programsDrawBuffers[llllllllllllllIllIllIIIllllllIlI] = Shaders.dfbDrawBuffers;
                        Shaders.usedDrawBuffers = Shaders.usedColorBuffers;
                        Arrays.fill(Shaders.programsToggleColorTextures[llllllllllllllIllIllIIIllllllIlI], 0, Shaders.usedColorBuffers, true);
                    }
                    else {
                        Shaders.programsDrawBuffers[llllllllllllllIllIllIIIllllllIlI] = Shaders.sfbDrawBuffers;
                    }
                }
            }
            Shaders.usedColorAttachs = Shaders.usedColorBuffers;
            Shaders.shadowPassInterval = ((Shaders.usedShadowDepthBuffers > 0) ? 1 : 0);
            Shaders.shouldSkipDefaultShadow = (Shaders.usedShadowDepthBuffers > 0);
            SMCLog.info(String.valueOf(new StringBuilder("usedColorBuffers: ").append(Shaders.usedColorBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedDepthBuffers: ").append(Shaders.usedDepthBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedShadowColorBuffers: ").append(Shaders.usedShadowColorBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedShadowDepthBuffers: ").append(Shaders.usedShadowDepthBuffers)));
            SMCLog.info(String.valueOf(new StringBuilder("usedColorAttachs: ").append(Shaders.usedColorAttachs)));
            SMCLog.info(String.valueOf(new StringBuilder("usedDrawBuffers: ").append(Shaders.usedDrawBuffers)));
            Shaders.dfbDrawBuffers.position(0).limit(Shaders.usedDrawBuffers);
            Shaders.dfbColorTextures.position(0).limit(Shaders.usedColorBuffers * 2);
            for (int llllllllllllllIllIllIIIlllllIIll = 0; llllllllllllllIllIllIIIlllllIIll < Shaders.usedDrawBuffers; ++llllllllllllllIllIllIIIlllllIIll) {
                Shaders.dfbDrawBuffers.put(llllllllllllllIllIllIIIlllllIIll, 36064 + llllllllllllllIllIllIIIlllllIIll);
            }
            if (Shaders.usedDrawBuffers > llllllllllllllIllIllIIIllllllIll) {
                printChatAndLogError(String.valueOf(new StringBuilder("[Shaders] Error: Not enough draw buffers, needed: ").append(Shaders.usedDrawBuffers).append(", available: ").append(llllllllllllllIllIllIIIllllllIll)));
            }
            Shaders.sfbDrawBuffers.position(0).limit(Shaders.usedShadowColorBuffers);
            for (int llllllllllllllIllIllIIIlllllIIlI = 0; llllllllllllllIllIllIIIlllllIIlI < Shaders.usedShadowColorBuffers; ++llllllllllllllIllIllIIIlllllIIlI) {
                Shaders.sfbDrawBuffers.put(llllllllllllllIllIllIIIlllllIIlI, 36064 + llllllllllllllIllIllIIIlllllIIlI);
            }
            for (int llllllllllllllIllIllIIIlllllIIIl = 0; llllllllllllllIllIllIIIlllllIIIl < 33; ++llllllllllllllIllIllIIIlllllIIIl) {
                int llllllllllllllIllIllIIIlllllIIII;
                for (llllllllllllllIllIllIIIlllllIIII = llllllllllllllIllIllIIIlllllIIIl; Shaders.programsID[llllllllllllllIllIllIIIlllllIIII] == 0 && Shaders.programBackups[llllllllllllllIllIllIIIlllllIIII] != llllllllllllllIllIllIIIlllllIIII; llllllllllllllIllIllIIIlllllIIII = Shaders.programBackups[llllllllllllllIllIllIIIlllllIIII]) {}
                if (llllllllllllllIllIllIIIlllllIIII != llllllllllllllIllIllIIIlllllIIIl && llllllllllllllIllIllIIIlllllIIIl != 30) {
                    Shaders.programsID[llllllllllllllIllIllIIIlllllIIIl] = Shaders.programsID[llllllllllllllIllIllIIIlllllIIII];
                    Shaders.programsDrawBufSettings[llllllllllllllIllIllIIIlllllIIIl] = Shaders.programsDrawBufSettings[llllllllllllllIllIllIIIlllllIIII];
                    Shaders.programsDrawBuffers[llllllllllllllIllIllIIIlllllIIIl] = Shaders.programsDrawBuffers[llllllllllllllIllIllIIIlllllIIII];
                }
            }
            resize();
            resizeShadow();
            if (Shaders.noiseTextureEnabled) {
                setupNoiseTexture();
            }
            if (Shaders.defaultTexture == null) {
                Shaders.defaultTexture = ShadersTex.createDefaultTexture();
            }
            GlStateManager.pushMatrix();
            GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
            preCelestialRotate();
            postCelestialRotate();
            GlStateManager.popMatrix();
            Shaders.isShaderPackInitialized = true;
            loadEntityDataMap();
            resetDisplayList();
            if (!llllllllllllllIllIllIIlIIIIIIlII) {}
            checkGLError("Shaders.init");
        }
    }
    
    public static void useProgram(int llllllllllllllIllIllIIIlIIIlIIlI) {
        checkGLError("pre-useProgram");
        if (Shaders.isShadowPass) {
            llllllllllllllIllIllIIIlIIIlIIlI = 30;
            if (Shaders.programsID[30] == 0) {
                Shaders.normalMapEnabled = false;
                return;
            }
        }
        if (Shaders.activeProgram != llllllllllllllIllIllIIIlIIIlIIlI) {
            Shaders.activeProgram = llllllllllllllIllIllIIIlIIIlIIlI;
            ARBShaderObjects.glUseProgramObjectARB(Shaders.programsID[llllllllllllllIllIllIIIlIIIlIIlI]);
            if (Shaders.programsID[llllllllllllllIllIllIIIlIIIlIIlI] == 0) {
                Shaders.normalMapEnabled = false;
            }
            else {
                if (checkGLError("useProgram ", Shaders.programNames[llllllllllllllIllIllIIIlIIIlIIlI]) != 0) {
                    Shaders.programsID[llllllllllllllIllIllIIIlIIIlIIlI] = 0;
                }
                final IntBuffer llllllllllllllIllIllIIIlIIIlllIl = Shaders.programsDrawBuffers[llllllllllllllIllIllIIIlIIIlIIlI];
                if (Shaders.isRenderingDfb) {
                    setDrawBuffers(llllllllllllllIllIllIIIlIIIlllIl);
                    checkGLError(Shaders.programNames[llllllllllllllIllIllIIIlIIIlIIlI], " draw buffers = ", Shaders.programsDrawBufSettings[llllllllllllllIllIllIIIlIIIlIIlI]);
                }
                Shaders.activeCompositeMipmapSetting = Shaders.programsCompositeMipmapSetting[llllllllllllllIllIllIIIlIIIlIIlI];
                Shaders.uniformEntityColor.setProgram(Shaders.programsID[Shaders.activeProgram]);
                Shaders.uniformEntityId.setProgram(Shaders.programsID[Shaders.activeProgram]);
                Shaders.uniformBlockEntityId.setProgram(Shaders.programsID[Shaders.activeProgram]);
                switch (llllllllllllllIllIllIIIlIIIlIIlI) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 16:
                    case 18:
                    case 19:
                    case 20: {
                        Shaders.normalMapEnabled = true;
                        setProgramUniform1i("texture", 0);
                        setProgramUniform1i("lightmap", 1);
                        setProgramUniform1i("normals", 2);
                        setProgramUniform1i("specular", 3);
                        setProgramUniform1i("shadow", Shaders.waterShadowEnabled ? 5 : 4);
                        setProgramUniform1i("watershadow", 4);
                        setProgramUniform1i("shadowtex0", 4);
                        setProgramUniform1i("shadowtex1", 5);
                        setProgramUniform1i("depthtex0", 6);
                        if (Shaders.customTexturesGbuffers != null) {
                            setProgramUniform1i("gaux1", 7);
                            setProgramUniform1i("gaux2", 8);
                            setProgramUniform1i("gaux3", 9);
                            setProgramUniform1i("gaux4", 10);
                        }
                        setProgramUniform1i("depthtex1", 12);
                        setProgramUniform1i("shadowcolor", 13);
                        setProgramUniform1i("shadowcolor0", 13);
                        setProgramUniform1i("shadowcolor1", 14);
                        setProgramUniform1i("noisetex", 15);
                        break;
                    }
                    default: {
                        Shaders.normalMapEnabled = false;
                        break;
                    }
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29: {
                        Shaders.normalMapEnabled = false;
                        setProgramUniform1i("gcolor", 0);
                        setProgramUniform1i("gdepth", 1);
                        setProgramUniform1i("gnormal", 2);
                        setProgramUniform1i("composite", 3);
                        setProgramUniform1i("gaux1", 7);
                        setProgramUniform1i("gaux2", 8);
                        setProgramUniform1i("gaux3", 9);
                        setProgramUniform1i("gaux4", 10);
                        setProgramUniform1i("colortex0", 0);
                        setProgramUniform1i("colortex1", 1);
                        setProgramUniform1i("colortex2", 2);
                        setProgramUniform1i("colortex3", 3);
                        setProgramUniform1i("colortex4", 7);
                        setProgramUniform1i("colortex5", 8);
                        setProgramUniform1i("colortex6", 9);
                        setProgramUniform1i("colortex7", 10);
                        setProgramUniform1i("shadow", Shaders.waterShadowEnabled ? 5 : 4);
                        setProgramUniform1i("watershadow", 4);
                        setProgramUniform1i("shadowtex0", 4);
                        setProgramUniform1i("shadowtex1", 5);
                        setProgramUniform1i("gdepthtex", 6);
                        setProgramUniform1i("depthtex0", 6);
                        setProgramUniform1i("depthtex1", 11);
                        setProgramUniform1i("depthtex2", 12);
                        setProgramUniform1i("shadowcolor", 13);
                        setProgramUniform1i("shadowcolor0", 13);
                        setProgramUniform1i("shadowcolor1", 14);
                        setProgramUniform1i("noisetex", 15);
                        break;
                    }
                    case 30:
                    case 31:
                    case 32: {
                        setProgramUniform1i("tex", 0);
                        setProgramUniform1i("texture", 0);
                        setProgramUniform1i("lightmap", 1);
                        setProgramUniform1i("normals", 2);
                        setProgramUniform1i("specular", 3);
                        setProgramUniform1i("shadow", Shaders.waterShadowEnabled ? 5 : 4);
                        setProgramUniform1i("watershadow", 4);
                        setProgramUniform1i("shadowtex0", 4);
                        setProgramUniform1i("shadowtex1", 5);
                        if (Shaders.customTexturesGbuffers != null) {
                            setProgramUniform1i("gaux1", 7);
                            setProgramUniform1i("gaux2", 8);
                            setProgramUniform1i("gaux3", 9);
                            setProgramUniform1i("gaux4", 10);
                        }
                        setProgramUniform1i("shadowcolor", 13);
                        setProgramUniform1i("shadowcolor0", 13);
                        setProgramUniform1i("shadowcolor1", 14);
                        setProgramUniform1i("noisetex", 15);
                        break;
                    }
                }
                final ItemStack llllllllllllllIllIllIIIlIIIlllII = (Shaders.mc.player != null) ? Shaders.mc.player.getHeldItemMainhand() : null;
                final Item llllllllllllllIllIllIIIlIIIllIll = (llllllllllllllIllIllIIIlIIIlllII != null) ? llllllllllllllIllIllIIIlIIIlllII.getItem() : null;
                int llllllllllllllIllIllIIIlIIIllIlI = -1;
                Block llllllllllllllIllIllIIIlIIIllIIl = null;
                if (llllllllllllllIllIllIIIlIIIllIll != null) {
                    llllllllllllllIllIllIIIlIIIllIlI = Item.REGISTRY.getIDForObject(llllllllllllllIllIllIIIlIIIllIll);
                    llllllllllllllIllIllIIIlIIIllIIl = Block.REGISTRY.getObjectById(llllllllllllllIllIllIIIlIIIllIlI);
                }
                int llllllllllllllIllIllIIIlIIIllIII = (llllllllllllllIllIllIIIlIIIllIIl != null) ? llllllllllllllIllIllIIIlIIIllIIl.getLightValue(llllllllllllllIllIllIIIlIIIllIIl.getDefaultState()) : 0;
                final ItemStack llllllllllllllIllIllIIIlIIIlIlll = (Shaders.mc.player != null) ? Shaders.mc.player.getHeldItemOffhand() : null;
                final Item llllllllllllllIllIllIIIlIIIlIllI = (llllllllllllllIllIllIIIlIIIlIlll != null) ? llllllllllllllIllIllIIIlIIIlIlll.getItem() : null;
                int llllllllllllllIllIllIIIlIIIlIlIl = -1;
                Block llllllllllllllIllIllIIIlIIIlIlII = null;
                if (llllllllllllllIllIllIIIlIIIlIllI != null) {
                    llllllllllllllIllIllIIIlIIIlIlIl = Item.REGISTRY.getIDForObject(llllllllllllllIllIllIIIlIIIlIllI);
                    llllllllllllllIllIllIIIlIIIlIlII = Block.REGISTRY.getObjectById(llllllllllllllIllIllIIIlIIIlIlIl);
                }
                final int llllllllllllllIllIllIIIlIIIlIIll = (llllllllllllllIllIllIIIlIIIlIlII != null) ? llllllllllllllIllIllIIIlIIIlIlII.getLightValue(llllllllllllllIllIllIIIlIIIlIlII.getDefaultState()) : 0;
                if (isOldHandLight() && llllllllllllllIllIllIIIlIIIlIIll > llllllllllllllIllIllIIIlIIIllIII) {
                    llllllllllllllIllIllIIIlIIIllIlI = llllllllllllllIllIllIIIlIIIlIlIl;
                    llllllllllllllIllIllIIIlIIIllIII = llllllllllllllIllIllIIIlIIIlIIll;
                }
                setProgramUniform1i("heldItemId", llllllllllllllIllIllIIIlIIIllIlI);
                setProgramUniform1i("heldBlockLightValue", llllllllllllllIllIllIIIlIIIllIII);
                setProgramUniform1i("heldItemId2", llllllllllllllIllIllIIIlIIIlIlIl);
                setProgramUniform1i("heldBlockLightValue2", llllllllllllllIllIllIIIlIIIlIIll);
                setProgramUniform1i("fogMode", Shaders.fogEnabled ? Shaders.fogMode : 0);
                setProgramUniform3f("fogColor", Shaders.fogColorR, Shaders.fogColorG, Shaders.fogColorB);
                setProgramUniform3f("skyColor", Shaders.skyColorR, Shaders.skyColorG, Shaders.skyColorB);
                setProgramUniform1i("worldTime", (int)(Shaders.worldTime % 24000L));
                setProgramUniform1i("worldDay", (int)(Shaders.worldTime / 24000L));
                setProgramUniform1i("moonPhase", Shaders.moonPhase);
                setProgramUniform1i("frameCounter", Shaders.frameCounter);
                setProgramUniform1f("frameTime", Shaders.frameTime);
                setProgramUniform1f("frameTimeCounter", Shaders.frameTimeCounter);
                setProgramUniform1f("sunAngle", Shaders.sunAngle);
                setProgramUniform1f("shadowAngle", Shaders.shadowAngle);
                setProgramUniform1f("rainStrength", Shaders.rainStrength);
                setProgramUniform1f("aspectRatio", Shaders.renderWidth / (float)Shaders.renderHeight);
                setProgramUniform1f("viewWidth", (float)Shaders.renderWidth);
                setProgramUniform1f("viewHeight", (float)Shaders.renderHeight);
                setProgramUniform1f("near", 0.05f);
                setProgramUniform1f("far", (float)(Shaders.mc.gameSettings.renderDistanceChunks * 16));
                setProgramUniform3f("sunPosition", Shaders.sunPosition[0], Shaders.sunPosition[1], Shaders.sunPosition[2]);
                setProgramUniform3f("moonPosition", Shaders.moonPosition[0], Shaders.moonPosition[1], Shaders.moonPosition[2]);
                setProgramUniform3f("shadowLightPosition", Shaders.shadowLightPosition[0], Shaders.shadowLightPosition[1], Shaders.shadowLightPosition[2]);
                setProgramUniform3f("upPosition", Shaders.upPosition[0], Shaders.upPosition[1], Shaders.upPosition[2]);
                setProgramUniform3f("previousCameraPosition", (float)Shaders.previousCameraPositionX, (float)Shaders.previousCameraPositionY, (float)Shaders.previousCameraPositionZ);
                setProgramUniform3f("cameraPosition", (float)Shaders.cameraPositionX, (float)Shaders.cameraPositionY, (float)Shaders.cameraPositionZ);
                setProgramUniformMatrix4ARB("gbufferModelView", false, Shaders.modelView);
                setProgramUniformMatrix4ARB("gbufferModelViewInverse", false, Shaders.modelViewInverse);
                setProgramUniformMatrix4ARB("gbufferPreviousProjection", false, Shaders.previousProjection);
                setProgramUniformMatrix4ARB("gbufferProjection", false, Shaders.projection);
                setProgramUniformMatrix4ARB("gbufferProjectionInverse", false, Shaders.projectionInverse);
                setProgramUniformMatrix4ARB("gbufferPreviousModelView", false, Shaders.previousModelView);
                if (Shaders.usedShadowDepthBuffers > 0) {
                    setProgramUniformMatrix4ARB("shadowProjection", false, Shaders.shadowProjection);
                    setProgramUniformMatrix4ARB("shadowProjectionInverse", false, Shaders.shadowProjectionInverse);
                    setProgramUniformMatrix4ARB("shadowModelView", false, Shaders.shadowModelView);
                    setProgramUniformMatrix4ARB("shadowModelViewInverse", false, Shaders.shadowModelViewInverse);
                }
                setProgramUniform1f("wetness", Shaders.wetness);
                setProgramUniform1f("eyeAltitude", Shaders.eyePosY);
                setProgramUniform2i("eyeBrightness", Shaders.eyeBrightness & 0xFFFF, Shaders.eyeBrightness >> 16);
                setProgramUniform2i("eyeBrightnessSmooth", Math.round(Shaders.eyeBrightnessFadeX), Math.round(Shaders.eyeBrightnessFadeY));
                setProgramUniform2i("terrainTextureSize", Shaders.terrainTextureSize[0], Shaders.terrainTextureSize[1]);
                setProgramUniform1i("terrainIconSize", Shaders.terrainIconSize);
                setProgramUniform1i("isEyeInWater", Shaders.isEyeInWater);
                setProgramUniform1f("nightVision", Shaders.nightVision);
                setProgramUniform1f("blindness", Shaders.blindness);
                setProgramUniform1f("screenBrightness", Shaders.mc.gameSettings.gammaSetting);
                setProgramUniform1i("hideGUI", Shaders.mc.gameSettings.hideGUI ? 1 : 0);
                setProgramUniform1f("centerDepthSmooth", Shaders.centerDepthSmooth);
                setProgramUniform2i("atlasSize", Shaders.atlasSizeX, Shaders.atlasSizeY);
                checkGLError("useProgram ", Shaders.programNames[llllllllllllllIllIllIIIlIIIlIIlI]);
            }
        }
    }
    
    public static void resourcesReloaded() {
        loadShaderPackResources();
    }
    
    public static void sglDisableT2D(final int llllllllllllllIllIlIlllllIIIIIIl) {
        GL11.glDisable(llllllllllllllIllIlIlllllIIIIIIl);
        disableTexture2D();
    }
    
    public static void nextAntialiasingLevel() {
        Shaders.configAntialiasingLevel += 2;
        Shaders.configAntialiasingLevel = Shaders.configAntialiasingLevel / 2 * 2;
        if (Shaders.configAntialiasingLevel > 4) {
            Shaders.configAntialiasingLevel = 0;
        }
        Shaders.configAntialiasingLevel = Config.limit(Shaders.configAntialiasingLevel, 0, 4);
    }
    
    public static boolean isOldLighting() {
        if (!Shaders.configOldLighting.isDefault()) {
            return Shaders.configOldLighting.isTrue();
        }
        return Shaders.shaderPackOldLighting.isDefault() || Shaders.shaderPackOldLighting.isTrue();
    }
    
    public static void beginBlockEntities() {
        if (Shaders.isRenderingWorld) {
            checkGLError("beginBlockEntities");
            useProgram(13);
        }
    }
    
    public static int setEntityData1(final int llllllllllllllIllIlIllllIlllIIII) {
        Shaders.entityData[Shaders.entityDataIndex * 2] = ((Shaders.entityData[Shaders.entityDataIndex * 2] & 0xFFFF) | llllllllllllllIllIlIllllIlllIIII << 16);
        return llllllllllllllIllIlIllllIlllIIII;
    }
    
    private static ByteBuffer nextByteBuffer(final int llllllllllllllIllIllIlIIlIIIIlII) {
        final ByteBuffer llllllllllllllIllIllIlIIlIIIIllI = Shaders.bigBuffer;
        final int llllllllllllllIllIllIlIIlIIIIlIl = llllllllllllllIllIllIlIIlIIIIllI.limit();
        llllllllllllllIllIllIlIIlIIIIllI.position(llllllllllllllIllIllIlIIlIIIIlIl).limit(llllllllllllllIllIllIlIIlIIIIlIl + llllllllllllllIllIllIlIIlIIIIlII);
        return llllllllllllllIllIllIlIIlIIIIllI.slice();
    }
    
    public static void scheduleResize() {
        Shaders.renderDisplayHeight = 0;
    }
    
    private static CustomTexture[] loadCustomTextures(final Properties llllllllllllllIllIllIIllllllIllI, final int llllllllllllllIllIllIlIIIIIIIIIl) {
        final String llllllllllllllIllIllIlIIIIIIIIII = String.valueOf(new StringBuilder("texture.").append(Shaders.STAGE_NAMES[llllllllllllllIllIllIlIIIIIIIIIl]).append("."));
        final Set llllllllllllllIllIllIIllllllllll = llllllllllllllIllIllIIllllllIllI.keySet();
        final List<CustomTexture> llllllllllllllIllIllIIlllllllllI = new ArrayList<CustomTexture>();
        for (final Object llllllllllllllIllIllIIllllllllIl : llllllllllllllIllIllIIllllllllll) {
            final String llllllllllllllIllIllIIllllllllII = (String)llllllllllllllIllIllIIllllllllIl;
            if (llllllllllllllIllIllIIllllllllII.startsWith(llllllllllllllIllIllIlIIIIIIIIII)) {
                final String llllllllllllllIllIllIIlllllllIll = llllllllllllllIllIllIIllllllllII.substring(llllllllllllllIllIllIlIIIIIIIIII.length());
                final String llllllllllllllIllIllIIlllllllIlI = llllllllllllllIllIllIIllllllIllI.getProperty(llllllllllllllIllIllIIllllllllII).trim();
                final int llllllllllllllIllIllIIlllllllIIl = getTextureIndex(llllllllllllllIllIllIlIIIIIIIIIl, llllllllllllllIllIllIIlllllllIll);
                if (llllllllllllllIllIllIIlllllllIIl < 0) {
                    SMCLog.warning(String.valueOf(new StringBuilder("Invalid texture name: ").append(llllllllllllllIllIllIIllllllllII)));
                }
                else {
                    final CustomTexture llllllllllllllIllIllIIlllllllIII = loadCustomTexture(llllllllllllllIllIllIIlllllllIIl, llllllllllllllIllIllIIlllllllIlI);
                    if (llllllllllllllIllIllIIlllllllIII == null) {
                        continue;
                    }
                    llllllllllllllIllIllIIlllllllllI.add(llllllllllllllIllIllIIlllllllIII);
                }
            }
        }
        if (llllllllllllllIllIllIIlllllllllI.size() <= 0) {
            return null;
        }
        final CustomTexture[] llllllllllllllIllIllIIllllllIlll = llllllllllllllIllIllIIlllllllllI.toArray(new CustomTexture[llllllllllllllIllIllIIlllllllllI.size()]);
        return llllllllllllllIllIllIIllllllIlll;
    }
    
    public static void enableLightmap() {
        Shaders.lightmapEnabled = true;
        if (Shaders.activeProgram == 2) {
            useProgram(3);
        }
    }
}
