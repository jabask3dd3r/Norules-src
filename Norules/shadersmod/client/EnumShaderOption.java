package shadersmod.client;

public enum EnumShaderOption
{
    SHADOW_RES_MUL("SHADOW_RES_MUL", 4, "of.options.shaders.SHADOW_RES_MUL", "shadowResMul", "1.0");
    
    private /* synthetic */ String propertyKey;
    
    CLOUD_SHADOW("CLOUD_SHADOW", 6, "of.options.shaders.CLOUD_SHADOW", "cloudShadow", "true"), 
    TEX_MAG_FIL_S("TEX_MAG_FIL_S", 17, "of.options.shaders.TEX_MAG_FIL_S", "TexMagFilS", "0"), 
    TEX_MIN_FIL_N("TEX_MIN_FIL_N", 13, "of.options.shaders.TEX_MIN_FIL_N", "TexMinFilN", "0"), 
    NORMAL_MAP("NORMAL_MAP", 1, "of.options.shaders.NORMAL_MAP", "normalMapEnabled", "true"), 
    ANTIALIASING("ANTIALIASING", 0, "of.options.shaders.ANTIALIASING", "antialiasingLevel", "0"), 
    TEX_MIN_FIL_B("TEX_MIN_FIL_B", 12, "of.options.shaders.TEX_MIN_FIL_B", "TexMinFilB", "0"), 
    SHADER_PACK("SHADER_PACK", 9, "of.options.shaders.SHADER_PACK", "shaderPack", "");
    
    private /* synthetic */ String resourceKey;
    private /* synthetic */ String valueDefault;
    
    SPECULAR_MAP("SPECULAR_MAP", 2, "of.options.shaders.SPECULAR_MAP", "specularMapEnabled", "true"), 
    TWEAK_BLOCK_DAMAGE("TWEAK_BLOCK_DAMAGE", 10, "of.options.shaders.TWEAK_BLOCK_DAMAGE", "tweakBlockDamage", "false"), 
    SHADOW_CLIP_FRUSTRUM("SHADOW_CLIP_FRUSTRUM", 11, "of.options.shaders.SHADOW_CLIP_FRUSTRUM", "shadowClipFrustrum", "true"), 
    TEX_MAG_FIL_N("TEX_MAG_FIL_N", 16, "of.options.shaders.TEX_MAG_FIL_N", "TexMagFilN", "0"), 
    OLD_LIGHTING("OLD_LIGHTING", 8, "of.options.shaders.OLD_LIGHTING", "oldLighting", "default"), 
    HAND_DEPTH_MUL("HAND_DEPTH_MUL", 5, "of.options.shaders.HAND_DEPTH_MUL", "handDepthMul", "0.125"), 
    TEX_MAG_FIL_B("TEX_MAG_FIL_B", 15, "of.options.shaders.TEX_MAG_FIL_B", "TexMagFilB", "0"), 
    TEX_MIN_FIL_S("TEX_MIN_FIL_S", 14, "of.options.shaders.TEX_MIN_FIL_S", "TexMinFilS", "0"), 
    OLD_HAND_LIGHT("OLD_HAND_LIGHT", 7, "of.options.shaders.OLD_HAND_LIGHT", "oldHandLight", "default"), 
    RENDER_RES_MUL("RENDER_RES_MUL", 3, "of.options.shaders.RENDER_RES_MUL", "renderResMul", "1.0");
    
    public String getPropertyKey() {
        return this.propertyKey;
    }
    
    public String getResourceKey() {
        return this.resourceKey;
    }
    
    public String getValueDefault() {
        return this.valueDefault;
    }
    
    private EnumShaderOption(final String lllllllllllllIIIllllIllIllIIlllI, final int lllllllllllllIIIllllIllIllIIllIl, final String lllllllllllllIIIllllIllIllIlIIlI, final String lllllllllllllIIIllllIllIllIIlIll, final String lllllllllllllIIIllllIllIllIIlIlI) {
        this.resourceKey = null;
        this.propertyKey = null;
        this.valueDefault = null;
        this.resourceKey = lllllllllllllIIIllllIllIllIlIIlI;
        this.propertyKey = lllllllllllllIIIllllIllIllIIlIll;
        this.valueDefault = lllllllllllllIIIllllIllIllIIlIlI;
    }
}
