package shadersmod.client;

import optifine.*;
import net.minecraft.client.gui.*;
import java.net.*;
import java.io.*;
import org.lwjgl.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;

public class GuiShaders extends GuiScreen
{
    private static /* synthetic */ float[] HAND_DEPTH_VALUES;
    protected /* synthetic */ GuiScreen parentGui;
    private static /* synthetic */ float[] QUALITY_MULTIPLIERS;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$shadersmod$client$EnumShaderOption;
    protected /* synthetic */ String screenTitle;
    private static /* synthetic */ String[] HAND_DEPTH_NAMES;
    private /* synthetic */ GuiSlotShaders shaderList;
    private /* synthetic */ boolean saved;
    private static /* synthetic */ String[] QUALITY_MULTIPLIER_NAMES;
    private /* synthetic */ int updateTimer;
    
    @Override
    public void drawScreen(final int llllllllllllllIlIlIIlIIIlllIIlll, final int llllllllllllllIlIlIIlIIIlllIllII, final float llllllllllllllIlIlIIlIIIlllIIlIl) {
        this.drawDefaultBackground();
        this.shaderList.drawScreen(llllllllllllllIlIlIIlIIIlllIIlll, llllllllllllllIlIlIIlIIIlllIllII, llllllllllllllIlIlIIlIIIlllIIlIl);
        if (this.updateTimer <= 0) {
            this.shaderList.updateList();
            this.updateTimer += 20;
        }
        this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(this.screenTitle)).append(" ")), this.width / 2, 15, 16777215);
        final String llllllllllllllIlIlIIlIIIlllIlIlI = String.valueOf(new StringBuilder("OpenGL: ").append(Shaders.glVersionString).append(", ").append(Shaders.glVendorString).append(", ").append(Shaders.glRendererString));
        final int llllllllllllllIlIlIIlIIIlllIlIIl = this.fontRendererObj.getStringWidth(llllllllllllllIlIlIIlIIIlllIlIlI);
        if (llllllllllllllIlIlIIlIIIlllIlIIl < this.width - 5) {
            this.drawCenteredString(this.fontRendererObj, llllllllllllllIlIlIIlIIIlllIlIlI, this.width / 2, this.height - 40, 8421504);
        }
        else {
            this.drawString(this.fontRendererObj, llllllllllllllIlIlIIlIIIlllIlIlI, 5, this.height - 40, 8421504);
        }
        super.drawScreen(llllllllllllllIlIlIIlIIIlllIIlll, llllllllllllllIlIlIIlIIIlllIllII, llllllllllllllIlIlIIlIIIlllIIlIl);
    }
    
    public static String toStringOnOff(final boolean llllllllllllllIlIlIIlIIIllIIlIlI) {
        final String llllllllllllllIlIlIIlIIIllIIlIIl = Lang.getOn();
        final String llllllllllllllIlIlIIlIIIllIIlIII = Lang.getOff();
        return llllllllllllllIlIlIIlIIIllIIlIlI ? llllllllllllllIlIlIIlIIIllIIlIIl : llllllllllllllIlIlIIlIIIllIIlIII;
    }
    
    public void updateButtons() {
        final boolean llllllllllllllIlIlIIlIIlIIllIlIl = Config.isShaders();
        for (final GuiButton llllllllllllllIlIlIIlIIlIIllIlII : this.buttonList) {
            if (llllllllllllllIlIlIIlIIlIIllIlII.id != 201 && llllllllllllllIlIlIIlIIlIIllIlII.id != 202 && llllllllllllllIlIlIIlIIlIIllIlII.id != EnumShaderOption.ANTIALIASING.ordinal()) {
                llllllllllllllIlIlIIlIIlIIllIlII.enabled = llllllllllllllIlIlIIlIIlIIllIlIl;
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIlIIlIIlIIIlllII) {
        if (llllllllllllllIlIlIIlIIlIIIlllII.enabled) {
            if (llllllllllllllIlIlIIlIIlIIIlllII instanceof GuiButtonEnumShaderOption) {
                final GuiButtonEnumShaderOption llllllllllllllIlIlIIlIIlIIIllIll = (GuiButtonEnumShaderOption)llllllllllllllIlIlIIlIIlIIIlllII;
                switch ($SWITCH_TABLE$shadersmod$client$EnumShaderOption()[llllllllllllllIlIlIIlIIlIIIllIll.getEnumShaderOption().ordinal()]) {
                    case 1: {
                        Shaders.nextAntialiasingLevel();
                        Shaders.uninit();
                        break;
                    }
                    case 2: {
                        Shaders.configNormalMap = !Shaders.configNormalMap;
                        Shaders.uninit();
                        this.mc.scheduleResourcesRefresh();
                        break;
                    }
                    case 3: {
                        Shaders.configSpecularMap = !Shaders.configSpecularMap;
                        Shaders.uninit();
                        this.mc.scheduleResourcesRefresh();
                        break;
                    }
                    case 4: {
                        final float llllllllllllllIlIlIIlIIlIIIllIlI = Shaders.configRenderResMul;
                        final float[] llllllllllllllIlIlIIlIIlIIIllIIl = GuiShaders.QUALITY_MULTIPLIERS;
                        final String[] llllllllllllllIlIlIIlIIlIIIllIII = GuiShaders.QUALITY_MULTIPLIER_NAMES;
                        int llllllllllllllIlIlIIlIIlIIIlIlll = getValueIndex(llllllllllllllIlIlIIlIIlIIIllIlI, llllllllllllllIlIlIIlIIlIIIllIIl);
                        if (isShiftKeyDown()) {
                            if (--llllllllllllllIlIlIIlIIlIIIlIlll < 0) {
                                llllllllllllllIlIlIIlIIlIIIlIlll = llllllllllllllIlIlIIlIIlIIIllIIl.length - 1;
                            }
                        }
                        else if (++llllllllllllllIlIlIIlIIlIIIlIlll >= llllllllllllllIlIlIIlIIlIIIllIIl.length) {
                            llllllllllllllIlIlIIlIIlIIIlIlll = 0;
                        }
                        Shaders.configRenderResMul = llllllllllllllIlIlIIlIIlIIIllIIl[llllllllllllllIlIlIIlIIlIIIlIlll];
                        Shaders.uninit();
                        Shaders.scheduleResize();
                        break;
                    }
                    case 5: {
                        final float llllllllllllllIlIlIIlIIlIIIlIllI = Shaders.configShadowResMul;
                        final float[] llllllllllllllIlIlIIlIIlIIIlIlIl = GuiShaders.QUALITY_MULTIPLIERS;
                        final String[] llllllllllllllIlIlIIlIIlIIIlIlII = GuiShaders.QUALITY_MULTIPLIER_NAMES;
                        int llllllllllllllIlIlIIlIIlIIIlIIll = getValueIndex(llllllllllllllIlIlIIlIIlIIIlIllI, llllllllllllllIlIlIIlIIlIIIlIlIl);
                        if (isShiftKeyDown()) {
                            if (--llllllllllllllIlIlIIlIIlIIIlIIll < 0) {
                                llllllllllllllIlIlIIlIIlIIIlIIll = llllllllllllllIlIlIIlIIlIIIlIlIl.length - 1;
                            }
                        }
                        else if (++llllllllllllllIlIlIIlIIlIIIlIIll >= llllllllllllllIlIlIIlIIlIIIlIlIl.length) {
                            llllllllllllllIlIlIIlIIlIIIlIIll = 0;
                        }
                        Shaders.configShadowResMul = llllllllllllllIlIlIIlIIlIIIlIlIl[llllllllllllllIlIlIIlIIlIIIlIIll];
                        Shaders.uninit();
                        Shaders.scheduleResizeShadow();
                        break;
                    }
                    case 6: {
                        final float llllllllllllllIlIlIIlIIlIIIlIIlI = Shaders.configHandDepthMul;
                        final float[] llllllllllllllIlIlIIlIIlIIIlIIIl = GuiShaders.HAND_DEPTH_VALUES;
                        final String[] llllllllllllllIlIlIIlIIlIIIlIIII = GuiShaders.HAND_DEPTH_NAMES;
                        int llllllllllllllIlIlIIlIIlIIIIllll = getValueIndex(llllllllllllllIlIlIIlIIlIIIlIIlI, llllllllllllllIlIlIIlIIlIIIlIIIl);
                        if (isShiftKeyDown()) {
                            if (--llllllllllllllIlIlIIlIIlIIIIllll < 0) {
                                llllllllllllllIlIlIIlIIlIIIIllll = llllllllllllllIlIlIIlIIlIIIlIIIl.length - 1;
                            }
                        }
                        else if (++llllllllllllllIlIlIIlIIlIIIIllll >= llllllllllllllIlIlIIlIIlIIIlIIIl.length) {
                            llllllllllllllIlIlIIlIIlIIIIllll = 0;
                        }
                        Shaders.configHandDepthMul = llllllllllllllIlIlIIlIIlIIIlIIIl[llllllllllllllIlIlIIlIIlIIIIllll];
                        Shaders.uninit();
                        break;
                    }
                    case 8: {
                        Shaders.configOldHandLight.nextValue();
                        Shaders.uninit();
                        break;
                    }
                    case 9: {
                        Shaders.configOldLighting.nextValue();
                        Shaders.updateBlockLightLevel();
                        Shaders.uninit();
                        this.mc.scheduleResourcesRefresh();
                        break;
                    }
                    case 11: {
                        Shaders.configTweakBlockDamage = !Shaders.configTweakBlockDamage;
                        break;
                    }
                    case 7: {
                        Shaders.configCloudShadow = !Shaders.configCloudShadow;
                        break;
                    }
                    case 13: {
                        Shaders.configTexMinFilB = (Shaders.configTexMinFilB + 1) % 3;
                        Shaders.configTexMinFilN = (Shaders.configTexMinFilS = Shaders.configTexMinFilB);
                        llllllllllllllIlIlIIlIIlIIIlllII.displayString = String.valueOf(new StringBuilder("Tex Min: ").append(Shaders.texMinFilDesc[Shaders.configTexMinFilB]));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                    case 17: {
                        Shaders.configTexMagFilN = (Shaders.configTexMagFilN + 1) % 2;
                        llllllllllllllIlIlIIlIIlIIIlllII.displayString = String.valueOf(new StringBuilder("Tex_n Mag: ").append(Shaders.texMagFilDesc[Shaders.configTexMagFilN]));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                    case 18: {
                        Shaders.configTexMagFilS = (Shaders.configTexMagFilS + 1) % 2;
                        llllllllllllllIlIlIIlIIlIIIlllII.displayString = String.valueOf(new StringBuilder("Tex_s Mag: ").append(Shaders.texMagFilDesc[Shaders.configTexMagFilS]));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                    case 12: {
                        Shaders.configShadowClipFrustrum = !Shaders.configShadowClipFrustrum;
                        llllllllllllllIlIlIIlIIlIIIlllII.displayString = String.valueOf(new StringBuilder("ShadowClipFrustrum: ").append(toStringOnOff(Shaders.configShadowClipFrustrum)));
                        ShadersTex.updateTextureMinMagFilter();
                        break;
                    }
                }
                llllllllllllllIlIlIIlIIlIIIllIll.updateButtonText();
            }
            else {
                switch (llllllllllllllIlIlIIlIIlIIIlllII.id) {
                    case 201: {
                        switch (getOSType()) {
                            case 1: {
                                final String llllllllllllllIlIlIIlIIlIIIIlllI = String.format("cmd.exe /C start \"Open file\" \"%s\"", Shaders.shaderpacksdir.getAbsolutePath());
                                try {
                                    Runtime.getRuntime().exec(llllllllllllllIlIlIIlIIlIIIIlllI);
                                    return;
                                }
                                catch (IOException llllllllllllllIlIlIIlIIlIIIIllIl) {
                                    llllllllllllllIlIlIIlIIlIIIIllIl.printStackTrace();
                                    break;
                                }
                            }
                            case 2: {
                                try {
                                    Runtime.getRuntime().exec(new String[] { "/usr/bin/open", Shaders.shaderpacksdir.getAbsolutePath() });
                                    return;
                                }
                                catch (IOException llllllllllllllIlIlIIlIIlIIIIllII) {
                                    llllllllllllllIlIlIIlIIlIIIIllII.printStackTrace();
                                }
                                break;
                            }
                        }
                        boolean llllllllllllllIlIlIIlIIlIIIIlIll = false;
                        try {
                            final Class llllllllllllllIlIlIIlIIlIIIIlIlI = Class.forName("java.awt.Desktop");
                            final Object llllllllllllllIlIlIIlIIlIIIIlIIl = llllllllllllllIlIlIIlIIlIIIIlIlI.getMethod("getDesktop", (Class[])new Class[0]).invoke(null, new Object[0]);
                            llllllllllllllIlIlIIlIIlIIIIlIlI.getMethod("browse", URI.class).invoke(llllllllllllllIlIlIIlIIlIIIIlIIl, new File(this.mc.mcDataDir, Shaders.shaderpacksdirname).toURI());
                        }
                        catch (Throwable llllllllllllllIlIlIIlIIlIIIIlIII) {
                            llllllllllllllIlIlIIlIIlIIIIlIII.printStackTrace();
                            llllllllllllllIlIlIIlIIlIIIIlIll = true;
                        }
                        if (llllllllllllllIlIlIIlIIlIIIIlIll) {
                            Config.dbg("Opening via system class!");
                            Sys.openURL(String.valueOf(new StringBuilder("file://").append(Shaders.shaderpacksdir.getAbsolutePath())));
                            break;
                        }
                        break;
                    }
                    case 202: {
                        new File(Shaders.shadersdir, "current.cfg");
                        Shaders.storeConfig();
                        this.saved = true;
                        this.mc.displayGuiScreen(this.parentGui);
                        break;
                    }
                    case 203: {
                        final GuiShaderOptions llllllllllllllIlIlIIlIIlIIIIIlll = new GuiShaderOptions(this, Config.getGameSettings());
                        Config.getMinecraft().displayGuiScreen(llllllllllllllIlIlIIlIIlIIIIIlll);
                        break;
                    }
                    default: {
                        this.shaderList.actionPerformed(llllllllllllllIlIlIIlIIlIIIlllII);
                        break;
                    }
                }
            }
        }
    }
    
    public static String toStringQuality(final float llllllllllllllIlIlIIlIIIlIlIIlll) {
        return toStringValue(llllllllllllllIlIlIIlIIIlIlIIlll, GuiShaders.QUALITY_MULTIPLIERS, GuiShaders.QUALITY_MULTIPLIER_NAMES);
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (!this.saved) {
            Shaders.storeConfig();
        }
    }
    
    public static String toStringAa(final int llllllllllllllIlIlIIlIIIllIIIIll) {
        if (llllllllllllllIlIlIIlIIIllIIIIll == 2) {
            return "FXAA 2x";
        }
        return (llllllllllllllIlIlIIlIIIllIIIIll == 4) ? "FXAA 4x" : Lang.getOff();
    }
    
    public static int getValueIndex(final float llllllllllllllIlIlIIlIIIlIlIllIl, final float[] llllllllllllllIlIlIIlIIIlIllIIII) {
        for (int llllllllllllllIlIlIIlIIIlIlIllll = 0; llllllllllllllIlIlIIlIIIlIlIllll < llllllllllllllIlIlIIlIIIlIllIIII.length; ++llllllllllllllIlIlIIlIIIlIlIllll) {
            final float llllllllllllllIlIlIIlIIIlIlIlllI = llllllllllllllIlIlIIlIIIlIllIIII[llllllllllllllIlIlIIlIIIlIlIllll];
            if (llllllllllllllIlIlIIlIIIlIlIlllI >= llllllllllllllIlIlIIlIIIlIlIllIl) {
                return llllllllllllllIlIlIIlIIIlIlIllll;
            }
        }
        return llllllllllllllIlIlIIlIIIlIllIIII.length - 1;
    }
    
    public static String toStringHandDepth(final float llllllllllllllIlIlIIlIIIlIlIIlIl) {
        return toStringValue(llllllllllllllIlIlIIlIIIlIlIIlIl, GuiShaders.HAND_DEPTH_VALUES, GuiShaders.HAND_DEPTH_NAMES);
    }
    
    public Minecraft getMc() {
        return this.mc;
    }
    
    public static String toStringValue(final float llllllllllllllIlIlIIlIIIlIlllIIl, final float[] llllllllllllllIlIlIIlIIIlIllllII, final String[] llllllllllllllIlIlIIlIIIlIllIlll) {
        final int llllllllllllllIlIlIIlIIIlIlllIlI = getValueIndex(llllllllllllllIlIlIIlIIIlIlllIIl, llllllllllllllIlIlIIlIIIlIllllII);
        return llllllllllllllIlIlIIlIIIlIllIlll[llllllllllllllIlIlIIlIIIlIlllIlI];
    }
    
    public static int getOSType() {
        final String llllllllllllllIlIlIIlIIIlIlIIIlI = System.getProperty("os.name").toLowerCase();
        if (llllllllllllllIlIlIIlIIIlIlIIIlI.contains("win")) {
            return 1;
        }
        if (llllllllllllllIlIlIIlIIIlIlIIIlI.contains("mac")) {
            return 2;
        }
        if (llllllllllllllIlIlIIlIIIlIlIIIlI.contains("solaris")) {
            return 3;
        }
        if (llllllllllllllIlIlIIlIIIlIlIIIlI.contains("sunos")) {
            return 3;
        }
        if (llllllllllllllIlIlIIlIIIlIlIIIlI.contains("linux")) {
            return 4;
        }
        return llllllllllllllIlIlIIlIIIlIlIIIlI.contains("unix") ? 4 : 0;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        --this.updateTimer;
    }
    
    public void drawCenteredString(final String llllllllllllllIlIlIIlIIIllIlIllI, final int llllllllllllllIlIlIIlIIIllIlIIII, final int llllllllllllllIlIlIIlIIIllIlIlII, final int llllllllllllllIlIlIIlIIIllIlIIll) {
        this.drawCenteredString(this.fontRendererObj, llllllllllllllIlIlIIlIIIllIlIllI, llllllllllllllIlIlIIlIIIllIlIIII, llllllllllllllIlIlIIlIIIllIlIlII, llllllllllllllIlIlIIlIIIllIlIIll);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.shaderList.handleMouseInput();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$shadersmod$client$EnumShaderOption() {
        final int[] $switch_TABLE$shadersmod$client$EnumShaderOption = GuiShaders.$SWITCH_TABLE$shadersmod$client$EnumShaderOption;
        if ($switch_TABLE$shadersmod$client$EnumShaderOption != null) {
            return $switch_TABLE$shadersmod$client$EnumShaderOption;
        }
        final long llllllllllllllIlIlIIlIIIlIIlllll = (Object)new int[EnumShaderOption.values().length];
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.ANTIALIASING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.OLD_HAND_LIGHT.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.OLD_LIGHTING.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.SHADER_PACK.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TEX_MAG_FIL_B.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TEX_MAG_FIL_N.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TEX_MAG_FIL_S.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TEX_MIN_FIL_B.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TEX_MIN_FIL_N.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TEX_MIN_FIL_S.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError17) {}
        try {
            llllllllllllllIlIlIIlIIIlIIlllll[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError18) {}
        return GuiShaders.$SWITCH_TABLE$shadersmod$client$EnumShaderOption = (int[])(Object)llllllllllllllIlIlIIlIIIlIIlllll;
    }
    
    public GuiShaders(final GuiScreen llllllllllllllIlIlIIlIIlIlIlIllI, final GameSettings llllllllllllllIlIlIIlIIlIlIlIlIl) {
        this.screenTitle = "Shaders";
        this.updateTimer = -1;
        this.saved = false;
        this.parentGui = llllllllllllllIlIlIIlIIlIlIlIllI;
    }
    
    static {
        EnumOS_WINDOWS = 1;
        EnumOS_OSX = 2;
        EnumOS_LINUX = 4;
        EnumOS_UNKNOWN = 0;
        EnumOS_SOLARIS = 3;
        GuiShaders.QUALITY_MULTIPLIERS = new float[] { 0.5f, 0.70710677f, 1.0f, 1.4142135f, 2.0f };
        GuiShaders.QUALITY_MULTIPLIER_NAMES = new String[] { "0.5x", "0.7x", "1x", "1.5x", "2x" };
        GuiShaders.HAND_DEPTH_VALUES = new float[] { 0.0625f, 0.125f, 0.25f };
        GuiShaders.HAND_DEPTH_NAMES = new String[] { "0.5x", "1x", "2x" };
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("of.options.shadersTitle", new Object[0]);
        if (Shaders.shadersConfig == null) {
            Shaders.loadConfig();
        }
        final int llllllllllllllIlIlIIlIIlIlIIlIIl = 120;
        final int llllllllllllllIlIlIIlIIlIlIIlIII = 20;
        final int llllllllllllllIlIlIIlIIlIlIIIlll = this.width - llllllllllllllIlIlIIlIIlIlIIlIIl - 10;
        final int llllllllllllllIlIlIIlIIlIlIIIllI = 30;
        final int llllllllllllllIlIlIIlIIlIlIIIlIl = 20;
        final int llllllllllllllIlIlIIlIIlIlIIIlII = this.width - llllllllllllllIlIlIIlIIlIlIIlIIl - 20;
        this.shaderList = new GuiSlotShaders(this, llllllllllllllIlIlIIlIIlIlIIIlII, this.height, llllllllllllllIlIlIIlIIlIlIIIllI, this.height - 50, 16);
        this.shaderList.registerScrollButtons(7, 8);
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.ANTIALIASING, llllllllllllllIlIlIIlIIlIlIIIlll, 0 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.NORMAL_MAP, llllllllllllllIlIlIIlIIlIlIIIlll, 1 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.SPECULAR_MAP, llllllllllllllIlIlIIlIIlIlIIIlll, 2 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.RENDER_RES_MUL, llllllllllllllIlIlIIlIIlIlIIIlll, 3 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.SHADOW_RES_MUL, llllllllllllllIlIlIIlIIlIlIIIlll, 4 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.HAND_DEPTH_MUL, llllllllllllllIlIlIIlIIlIlIIIlll, 5 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.OLD_HAND_LIGHT, llllllllllllllIlIlIIlIIlIlIIIlll, 6 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        this.buttonList.add(new GuiButtonEnumShaderOption(EnumShaderOption.OLD_LIGHTING, llllllllllllllIlIlIIlIIlIlIIIlll, 7 * llllllllllllllIlIlIIlIIlIlIIIlIl + llllllllllllllIlIlIIlIIlIlIIIllI, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII));
        final int llllllllllllllIlIlIIlIIlIlIIIIll = Math.min(150, llllllllllllllIlIlIIlIIlIlIIIlII / 2 - 10);
        this.buttonList.add(new GuiButton(201, llllllllllllllIlIlIIlIIlIlIIIlII / 4 - llllllllllllllIlIlIIlIIlIlIIIIll / 2, this.height - 25, llllllllllllllIlIlIIlIIlIlIIIIll, llllllllllllllIlIlIIlIIlIlIIlIII, Lang.get("of.options.shaders.shadersFolder")));
        this.buttonList.add(new GuiButton(202, llllllllllllllIlIlIIlIIlIlIIIlII / 4 * 3 - llllllllllllllIlIlIIlIIlIlIIIIll / 2, this.height - 25, llllllllllllllIlIlIIlIIlIlIIIIll, llllllllllllllIlIlIIlIIlIlIIlIII, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(203, llllllllllllllIlIlIIlIIlIlIIIlll, this.height - 25, llllllllllllllIlIlIIlIIlIlIIlIIl, llllllllllllllIlIlIIlIIlIlIIlIII, Lang.get("of.options.shaders.shaderOptions")));
        this.updateButtons();
    }
}
