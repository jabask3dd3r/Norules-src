package net.optifine.entity.model.anim;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.*;

public enum EnumRenderParameterEntity implements IExpression
{
    LIMB_SWING_SPEED("LIMB_SWING_SPEED", 1, "limb_speed"), 
    HEAD_PITCH("HEAD_PITCH", 4, "head_pitch");
    
    private static final /* synthetic */ EnumRenderParameterEntity[] VALUES;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity;
    private /* synthetic */ RenderManager renderManager;
    
    LIMB_SWING("LIMB_SWING", 0, "limb_swing"), 
    SCALE("SCALE", 5, "scale"), 
    AGE("AGE", 2, "age"), 
    HEAD_YAW("HEAD_YAW", 3, "head_yaw");
    
    private /* synthetic */ String name;
    
    @Override
    public float eval() {
        final Render lllllllllllllIIlIlIIlIllllIlllll = this.renderManager.renderRender;
        if (lllllllllllllIIlIlIIlIllllIlllll == null) {
            return 0.0f;
        }
        if (lllllllllllllIIlIlIIlIllllIlllll instanceof RenderLivingBase) {
            final RenderLivingBase lllllllllllllIIlIlIIlIllllIllllI = (RenderLivingBase)lllllllllllllIIlIlIIlIllllIlllll;
            switch ($SWITCH_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity()[this.ordinal()]) {
                case 1: {
                    return lllllllllllllIIlIlIIlIllllIllllI.renderLimbSwing;
                }
                case 2: {
                    return lllllllllllllIIlIlIIlIllllIllllI.renderLimbSwingAmount;
                }
                case 3: {
                    return lllllllllllllIIlIlIIlIllllIllllI.renderAgeInTicks;
                }
                case 4: {
                    return lllllllllllllIIlIlIIlIllllIllllI.renderHeadYaw;
                }
                case 5: {
                    return lllllllllllllIIlIlIIlIllllIllllI.renderHeadPitch;
                }
                case 6: {
                    return lllllllllllllIIlIlIIlIllllIllllI.renderScaleFactor;
                }
            }
        }
        return 0.0f;
    }
    
    static {
        VALUES = values();
    }
    
    public static EnumRenderParameterEntity parse(final String lllllllllllllIIlIlIIlIllllIlIlll) {
        if (lllllllllllllIIlIlIIlIllllIlIlll == null) {
            return null;
        }
        for (int lllllllllllllIIlIlIIlIllllIlIllI = 0; lllllllllllllIIlIlIIlIllllIlIllI < EnumRenderParameterEntity.VALUES.length; ++lllllllllllllIIlIlIIlIllllIlIllI) {
            final EnumRenderParameterEntity lllllllllllllIIlIlIIlIllllIlIlIl = EnumRenderParameterEntity.VALUES[lllllllllllllIIlIlIIlIllllIlIllI];
            if (lllllllllllllIIlIlIIlIllllIlIlIl.getName().equals(lllllllllllllIIlIlIIlIllllIlIlll)) {
                return lllllllllllllIIlIlIIlIllllIlIlIl;
            }
        }
        return null;
    }
    
    private EnumRenderParameterEntity(final String lllllllllllllIIlIlIIlIlllllIlIIl, final int lllllllllllllIIlIlIIlIlllllIlIII, final String lllllllllllllIIlIlIIlIlllllIlIll) {
        this.name = lllllllllllllIIlIlIIlIlllllIlIll;
        this.renderManager = Minecraft.getMinecraft().getRenderManager();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity() {
        final int[] $switch_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity = EnumRenderParameterEntity.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity;
        if ($switch_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity != null) {
            return $switch_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity;
        }
        final int lllllllllllllIIlIlIIlIllllIIlIII = (Object)new int[values().length];
        try {
            lllllllllllllIIlIlIIlIllllIIlIII[EnumRenderParameterEntity.AGE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIlIIlIllllIIlIII[EnumRenderParameterEntity.HEAD_PITCH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIlIIlIllllIIlIII[EnumRenderParameterEntity.HEAD_YAW.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIlIIlIllllIIlIII[EnumRenderParameterEntity.LIMB_SWING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIlIIlIllllIIlIII[EnumRenderParameterEntity.LIMB_SWING_SPEED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlIlIIlIllllIIlIII[EnumRenderParameterEntity.SCALE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return EnumRenderParameterEntity.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumRenderParameterEntity = (int[])(Object)lllllllllllllIIlIlIIlIllllIIlIII;
    }
    
    public String getName() {
        return this.name;
    }
}
