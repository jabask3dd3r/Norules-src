package shadersmod.client;

import optifine.*;
import net.minecraft.util.*;

public class ShaderMacros
{
    private static /* synthetic */ String[] extensionMacros;
    private static /* synthetic */ String PREFIX_MACRO;
    
    private static void addMacroLine(final StringBuilder llllllllllllllIllIIIIIIllIIIIIIl, final String llllllllllllllIllIIIIIIllIIIIIII) {
        llllllllllllllIllIIIIIIllIIIIIIl.append("#define ");
        llllllllllllllIllIIIIIIllIIIIIIl.append(llllllllllllllIllIIIIIIllIIIIIII);
        llllllllllllllIllIIIIIIllIIIIIIl.append("\n");
    }
    
    private static void addMacroLine(final StringBuilder llllllllllllllIllIIIIIIllIIIlIII, final String llllllllllllllIllIIIIIIllIIIIlll, final float llllllllllllllIllIIIIIIllIIIIllI) {
        llllllllllllllIllIIIIIIllIIIlIII.append("#define ");
        llllllllllllllIllIIIIIIllIIIlIII.append(llllllllllllllIllIIIIIIllIIIIlll);
        llllllllllllllIllIIIIIIllIIIlIII.append(" ");
        llllllllllllllIllIIIIIIllIIIlIII.append(llllllllllllllIllIIIIIIllIIIIllI);
        llllllllllllllIllIIIIIIllIIIlIII.append("\n");
    }
    
    public static String[] getExtensions() {
        if (ShaderMacros.extensionMacros == null) {
            final String[] llllllllllllllIllIIIIIIllIlIIIII = Config.getOpenGlExtensions();
            final String[] llllllllllllllIllIIIIIIllIIlllll = new String[llllllllllllllIllIIIIIIllIlIIIII.length];
            for (int llllllllllllllIllIIIIIIllIIllllI = 0; llllllllllllllIllIIIIIIllIIllllI < llllllllllllllIllIIIIIIllIlIIIII.length; ++llllllllllllllIllIIIIIIllIIllllI) {
                llllllllllllllIllIIIIIIllIIlllll[llllllllllllllIllIIIIIIllIIllllI] = String.valueOf(new StringBuilder(String.valueOf(ShaderMacros.PREFIX_MACRO)).append(llllllllllllllIllIIIIIIllIlIIIII[llllllllllllllIllIIIIIIllIIllllI]));
            }
            ShaderMacros.extensionMacros = llllllllllllllIllIIIIIIllIIlllll;
        }
        return ShaderMacros.extensionMacros;
    }
    
    public static String getVendor() {
        String llllllllllllllIllIIIIIIllIlIlIII = Config.openGlVendor;
        if (llllllllllllllIllIIIIIIllIlIlIII == null) {
            return "MC_GL_VENDOR_OTHER";
        }
        llllllllllllllIllIIIIIIllIlIlIII = llllllllllllllIllIIIIIIllIlIlIII.toLowerCase();
        if (llllllllllllllIllIIIIIIllIlIlIII.startsWith("ati")) {
            return "MC_GL_VENDOR_ATI";
        }
        if (llllllllllllllIllIIIIIIllIlIlIII.startsWith("intel")) {
            return "MC_GL_VENDOR_INTEL";
        }
        if (llllllllllllllIllIIIIIIllIlIlIII.startsWith("nvidia")) {
            return "MC_GL_VENDOR_NVIDIA";
        }
        return llllllllllllllIllIIIIIIllIlIlIII.startsWith("x.org") ? "MC_GL_VENDOR_XORG" : "MC_GL_VENDOR_OTHER";
    }
    
    public static String getPrefixMacro() {
        return ShaderMacros.PREFIX_MACRO;
    }
    
    public static String getMacroLines() {
        final StringBuilder llllllllllllllIllIIIIIIllIIllIIl = new StringBuilder();
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_VERSION", Config.getMinecraftVersionInt());
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, String.valueOf(new StringBuilder("MC_GL_VERSION ").append(Config.getGlVersion().toInt())));
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, String.valueOf(new StringBuilder("MC_GLSL_VERSION ").append(Config.getGlslVersion().toInt())));
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, getOs());
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, getVendor());
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, getRenderer());
        if (Shaders.configAntialiasingLevel > 0) {
            addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_FXAA_LEVEL", Shaders.configAntialiasingLevel);
        }
        if (Shaders.configNormalMap) {
            addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_NORMAL_MAP");
        }
        if (Shaders.configSpecularMap) {
            addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_SPECULAR_MAP");
        }
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_RENDER_QUALITY", Shaders.configRenderResMul);
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_SHADOW_QUALITY", Shaders.configShadowResMul);
        addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_HAND_DEPTH", Shaders.configHandDepthMul);
        if (Shaders.isOldHandLight()) {
            addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_OLD_HAND_LIGHT");
        }
        if (Shaders.isOldLighting()) {
            addMacroLine(llllllllllllllIllIIIIIIllIIllIIl, "MC_OLD_LIGHTING");
        }
        return String.valueOf(llllllllllllllIllIIIIIIllIIllIIl);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Util$EnumOS() {
        final int[] $switch_TABLE$net$minecraft$util$Util$EnumOS = ShaderMacros.$SWITCH_TABLE$net$minecraft$util$Util$EnumOS;
        if ($switch_TABLE$net$minecraft$util$Util$EnumOS != null) {
            return $switch_TABLE$net$minecraft$util$Util$EnumOS;
        }
        final float llllllllllllllIllIIIIIIlIllllllI = (Object)new int[Util.EnumOS.values().length];
        try {
            llllllllllllllIllIIIIIIlIllllllI[Util.EnumOS.LINUX.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIIIIIIlIllllllI[Util.EnumOS.OSX.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIIIIIIlIllllllI[Util.EnumOS.SOLARIS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIllIIIIIIlIllllllI[Util.EnumOS.UNKNOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIllIIIIIIlIllllllI[Util.EnumOS.WINDOWS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return ShaderMacros.$SWITCH_TABLE$net$minecraft$util$Util$EnumOS = (int[])(Object)llllllllllllllIllIIIIIIlIllllllI;
    }
    
    static {
        MC_GL_RENDERER_MESA = "MC_GL_RENDERER_MESA";
        MC_RENDER_QUALITY = "MC_RENDER_QUALITY";
        MC_NORMAL_MAP = "MC_NORMAL_MAP";
        MC_GLSL_VERSION = "MC_GLSL_VERSION";
        MC_GL_VENDOR_NVIDIA = "MC_GL_VENDOR_NVIDIA";
        MC_GL_RENDERER_QUADRO = "MC_GL_RENDERER_QUADRO";
        MC_GL_RENDERER_RADEON = "MC_GL_RENDERER_RADEON";
        MC_OS_OTHER = "MC_OS_OTHER";
        MC_HAND_DEPTH = "MC_HAND_DEPTH";
        MC_OLD_LIGHTING = "MC_OLD_LIGHTING";
        MC_OS_WINDOWS = "MC_OS_WINDOWS";
        MC_OLD_HAND_LIGHT = "MC_OLD_HAND_LIGHT";
        MC_GL_VERSION = "MC_GL_VERSION";
        MC_GL_RENDERER_OTHER = "MC_GL_RENDERER_OTHER";
        MC_FXAA_LEVEL = "MC_FXAA_LEVEL";
        MC_GL_VENDOR_OTHER = "MC_GL_VENDOR_OTHER";
        MC_GL_RENDERER_GEFORCE = "MC_GL_RENDERER_GEFORCE";
        MC_GL_VENDOR_XORG = "MC_GL_VENDOR_XORG";
        MC_OS_LINUX = "MC_OS_LINUX";
        MC_OS_MAC = "MC_OS_MAC";
        MC_GL_VENDOR_ATI = "MC_GL_VENDOR_ATI";
        MC_GL_RENDERER_GALLIUM = "MC_GL_RENDERER_GALLIUM";
        MC_VERSION = "MC_VERSION";
        MC_SPECULAR_MAP = "MC_SPECULAR_MAP";
        MC_SHADOW_QUALITY = "MC_SHADOW_QUALITY";
        MC_GL_VENDOR_INTEL = "MC_GL_VENDOR_INTEL";
        MC_GL_RENDERER_INTEL = "MC_GL_RENDERER_INTEL";
        ShaderMacros.PREFIX_MACRO = "MC_";
    }
    
    public static String getRenderer() {
        String llllllllllllllIllIIIIIIllIlIIlIl = Config.openGlRenderer;
        if (llllllllllllllIllIIIIIIllIlIIlIl == null) {
            return "MC_GL_RENDERER_OTHER";
        }
        llllllllllllllIllIIIIIIllIlIIlIl = llllllllllllllIllIIIIIIllIlIIlIl.toLowerCase();
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("amd")) {
            return "MC_GL_RENDERER_RADEON";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("ati")) {
            return "MC_GL_RENDERER_RADEON";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("radeon")) {
            return "MC_GL_RENDERER_RADEON";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("gallium")) {
            return "MC_GL_RENDERER_GALLIUM";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("intel")) {
            return "MC_GL_RENDERER_INTEL";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("geforce")) {
            return "MC_GL_RENDERER_GEFORCE";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("nvidia")) {
            return "MC_GL_RENDERER_GEFORCE";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("quadro")) {
            return "MC_GL_RENDERER_QUADRO";
        }
        if (llllllllllllllIllIIIIIIllIlIIlIl.startsWith("nvs")) {
            return "MC_GL_RENDERER_QUADRO";
        }
        return llllllllllllllIllIIIIIIllIlIIlIl.startsWith("mesa") ? "MC_GL_RENDERER_MESA" : "MC_GL_RENDERER_OTHER";
    }
    
    private static void addMacroLine(final StringBuilder llllllllllllllIllIIIIIIllIIlIIIl, final String llllllllllllllIllIIIIIIllIIlIIII, final int llllllllllllllIllIIIIIIllIIlIIlI) {
        llllllllllllllIllIIIIIIllIIlIIIl.append("#define ");
        llllllllllllllIllIIIIIIllIIlIIIl.append(llllllllllllllIllIIIIIIllIIlIIII);
        llllllllllllllIllIIIIIIllIIlIIIl.append(" ");
        llllllllllllllIllIIIIIIllIIlIIIl.append(llllllllllllllIllIIIIIIllIIlIIlI);
        llllllllllllllIllIIIIIIllIIlIIIl.append("\n");
    }
    
    public static String getOs() {
        final Util.EnumOS llllllllllllllIllIIIIIIllIlIlIll = Util.getOSType();
        switch ($SWITCH_TABLE$net$minecraft$util$Util$EnumOS()[llllllllllllllIllIIIIIIllIlIlIll.ordinal()]) {
            case 3: {
                return "MC_OS_WINDOWS";
            }
            case 4: {
                return "MC_OS_MAC";
            }
            case 1: {
                return "MC_OS_LINUX";
            }
            default: {
                return "MC_OS_OTHER";
            }
        }
    }
}
