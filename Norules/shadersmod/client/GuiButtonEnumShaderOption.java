package shadersmod.client;

import net.minecraft.client.gui.*;
import net.minecraft.client.resources.*;

public class GuiButtonEnumShaderOption extends GuiButton
{
    private /* synthetic */ EnumShaderOption enumShaderOption;
    
    public void updateButtonText() {
        this.displayString = getButtonText(this.enumShaderOption);
    }
    
    public EnumShaderOption getEnumShaderOption() {
        return this.enumShaderOption;
    }
    
    public GuiButtonEnumShaderOption(final EnumShaderOption llllllllllllllIllIIIIlllIlIIlIII, final int llllllllllllllIllIIIIlllIlIIIIIl, final int llllllllllllllIllIIIIlllIlIIIllI, final int llllllllllllllIllIIIIlllIlIIIlIl, final int llllllllllllllIllIIIIlllIlIIIlII) {
        super(llllllllllllllIllIIIIlllIlIIlIII.ordinal(), llllllllllllllIllIIIIlllIlIIIIIl, llllllllllllllIllIIIIlllIlIIIllI, llllllllllllllIllIIIIlllIlIIIlIl, llllllllllllllIllIIIIlllIlIIIlII, getButtonText(llllllllllllllIllIIIIlllIlIIlIII));
        this.enumShaderOption = null;
        this.enumShaderOption = llllllllllllllIllIIIIlllIlIIlIII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$shadersmod$client$EnumShaderOption() {
        final int[] $switch_TABLE$shadersmod$client$EnumShaderOption = GuiButtonEnumShaderOption.$SWITCH_TABLE$shadersmod$client$EnumShaderOption;
        if ($switch_TABLE$shadersmod$client$EnumShaderOption != null) {
            return $switch_TABLE$shadersmod$client$EnumShaderOption;
        }
        final double llllllllllllllIllIIIIlllIIllIIII = (Object)new int[EnumShaderOption.values().length];
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.ANTIALIASING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.OLD_HAND_LIGHT.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.OLD_LIGHTING.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.SHADER_PACK.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TEX_MAG_FIL_B.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TEX_MAG_FIL_N.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TEX_MAG_FIL_S.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TEX_MIN_FIL_B.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TEX_MIN_FIL_N.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TEX_MIN_FIL_S.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError17) {}
        try {
            llllllllllllllIllIIIIlllIIllIIII[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError18) {}
        return GuiButtonEnumShaderOption.$SWITCH_TABLE$shadersmod$client$EnumShaderOption = (int[])(Object)llllllllllllllIllIIIIlllIIllIIII;
    }
    
    private static String getButtonText(final EnumShaderOption llllllllllllllIllIIIIlllIIllIllI) {
        final String llllllllllllllIllIIIIlllIIllIlll = String.valueOf(new StringBuilder(String.valueOf(I18n.format(llllllllllllllIllIIIIlllIIllIllI.getResourceKey(), new Object[0]))).append(": "));
        switch ($SWITCH_TABLE$shadersmod$client$EnumShaderOption()[llllllllllllllIllIIIIlllIIllIllI.ordinal()]) {
            case 1: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringAa(Shaders.configAntialiasingLevel)));
            }
            case 2: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringOnOff(Shaders.configNormalMap)));
            }
            case 3: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringOnOff(Shaders.configSpecularMap)));
            }
            case 4: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringQuality(Shaders.configRenderResMul)));
            }
            case 5: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringQuality(Shaders.configShadowResMul)));
            }
            case 6: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringHandDepth(Shaders.configHandDepthMul)));
            }
            case 7: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringOnOff(Shaders.configCloudShadow)));
            }
            case 8: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(Shaders.configOldHandLight.getUserValue()));
            }
            case 9: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(Shaders.configOldLighting.getUserValue()));
            }
            case 12: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringOnOff(Shaders.configShadowClipFrustrum)));
            }
            case 11: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(GuiShaders.toStringOnOff(Shaders.configTweakBlockDamage)));
            }
            default: {
                return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllIIIIlllIIllIlll)).append(Shaders.getEnumShaderOption(llllllllllllllIllIIIIlllIIllIllI)));
            }
        }
    }
}
