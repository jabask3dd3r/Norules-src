package net.optifine.entity.model.anim;

import net.minecraft.client.model.*;
import optifine.*;

public enum EnumModelVariable
{
    ANGLE_Y("ANGLE_Y", 4, "ry"), 
    ANGLE_Z("ANGLE_Z", 5, "rz");
    
    public static /* synthetic */ EnumModelVariable[] VALUES;
    
    POS_Y("POS_Y", 1, "ty"), 
    OFFSET_X("OFFSET_X", 6, "ox"), 
    ANGLE_X("ANGLE_X", 3, "rx");
    
    private /* synthetic */ String name;
    
    SCALE_Z("SCALE_Z", 11, "sz"), 
    SCALE_X("SCALE_X", 9, "sx"), 
    OFFSET_Z("OFFSET_Z", 8, "oz"), 
    OFFSET_Y("OFFSET_Y", 7, "oy");
    
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumModelVariable;
    
    POS_Z("POS_Z", 2, "tz"), 
    POS_X("POS_X", 0, "tx"), 
    SCALE_Y("SCALE_Y", 10, "sy");
    
    private EnumModelVariable(final String lllllllllllllllIllIlIlllIIIlllIl, final int lllllllllllllllIllIlIlllIIIlllII, final String lllllllllllllllIllIlIlllIIIllIll) {
        this.name = lllllllllllllllIllIlIlllIIIllIll;
    }
    
    static {
        EnumModelVariable.VALUES = values();
    }
    
    public String getName() {
        return this.name;
    }
    
    public float getFloat(final ModelRenderer lllllllllllllllIllIlIlllIIIlIIlI) {
        switch ($SWITCH_TABLE$net$optifine$entity$model$anim$EnumModelVariable()[this.ordinal()]) {
            case 1: {
                return lllllllllllllllIllIlIlllIIIlIIlI.rotationPointX;
            }
            case 2: {
                return lllllllllllllllIllIlIlllIIIlIIlI.rotationPointY;
            }
            case 3: {
                return lllllllllllllllIllIlIlllIIIlIIlI.rotationPointZ;
            }
            case 4: {
                return lllllllllllllllIllIlIlllIIIlIIlI.rotateAngleX;
            }
            case 5: {
                return lllllllllllllllIllIlIlllIIIlIIlI.rotateAngleY;
            }
            case 6: {
                return lllllllllllllllIllIlIlllIIIlIIlI.rotateAngleZ;
            }
            case 7: {
                return lllllllllllllllIllIlIlllIIIlIIlI.offsetX;
            }
            case 8: {
                return lllllllllllllllIllIlIlllIIIlIIlI.offsetY;
            }
            case 9: {
                return lllllllllllllllIllIlIlllIIIlIIlI.offsetZ;
            }
            case 10: {
                return lllllllllllllllIllIlIlllIIIlIIlI.scaleX;
            }
            case 11: {
                return lllllllllllllllIllIlIlllIIIlIIlI.scaleY;
            }
            case 12: {
                return lllllllllllllllIllIlIlllIIIlIIlI.scaleZ;
            }
            default: {
                Config.warn(String.valueOf(new StringBuilder("GetFloat not supported for: ").append(this)));
                return 0.0f;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumModelVariable() {
        final int[] $switch_TABLE$net$optifine$entity$model$anim$EnumModelVariable = EnumModelVariable.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumModelVariable;
        if ($switch_TABLE$net$optifine$entity$model$anim$EnumModelVariable != null) {
            return $switch_TABLE$net$optifine$entity$model$anim$EnumModelVariable;
        }
        final Exception lllllllllllllllIllIlIllIllllIllI = (Object)new int[values().length];
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.ANGLE_X.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.ANGLE_Y.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.ANGLE_Z.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.OFFSET_X.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.OFFSET_Y.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.OFFSET_Z.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.POS_X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.POS_Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.POS_Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.SCALE_X.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.SCALE_Y.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            lllllllllllllllIllIlIllIllllIllI[EnumModelVariable.SCALE_Z.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        return EnumModelVariable.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumModelVariable = (int[])(Object)lllllllllllllllIllIlIllIllllIllI;
    }
    
    public static EnumModelVariable parse(final String lllllllllllllllIllIlIlllIIIIIIlI) {
        for (int lllllllllllllllIllIlIlllIIIIIlII = 0; lllllllllllllllIllIlIlllIIIIIlII < EnumModelVariable.VALUES.length; ++lllllllllllllllIllIlIlllIIIIIlII) {
            final EnumModelVariable lllllllllllllllIllIlIlllIIIIIIll = EnumModelVariable.VALUES[lllllllllllllllIllIlIlllIIIIIlII];
            if (lllllllllllllllIllIlIlllIIIIIIll.getName().equals(lllllllllllllllIllIlIlllIIIIIIlI)) {
                return lllllllllllllllIllIlIlllIIIIIIll;
            }
        }
        return null;
    }
    
    public void setFloat(final ModelRenderer lllllllllllllllIllIlIlllIIIIllIl, final float lllllllllllllllIllIlIlllIIIIllII) {
        switch ($SWITCH_TABLE$net$optifine$entity$model$anim$EnumModelVariable()[this.ordinal()]) {
            case 1: {
                lllllllllllllllIllIlIlllIIIIllIl.rotationPointX = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 2: {
                lllllllllllllllIllIlIlllIIIIllIl.rotationPointY = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 3: {
                lllllllllllllllIllIlIlllIIIIllIl.rotationPointZ = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 4: {
                lllllllllllllllIllIlIlllIIIIllIl.rotateAngleX = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 5: {
                lllllllllllllllIllIlIlllIIIIllIl.rotateAngleY = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 6: {
                lllllllllllllllIllIlIlllIIIIllIl.rotateAngleZ = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 7: {
                lllllllllllllllIllIlIlllIIIIllIl.offsetX = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 8: {
                lllllllllllllllIllIlIlllIIIIllIl.offsetY = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 9: {
                lllllllllllllllIllIlIlllIIIIllIl.offsetZ = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 10: {
                lllllllllllllllIllIlIlllIIIIllIl.scaleX = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 11: {
                lllllllllllllllIllIlIlllIIIIllIl.scaleY = lllllllllllllllIllIlIlllIIIIllII;
            }
            case 12: {
                lllllllllllllllIllIlIlllIIIIllIl.scaleZ = lllllllllllllllIllIlIlllIIIIllII;
            }
            default: {
                Config.warn(String.valueOf(new StringBuilder("SetFloat not supported for: ").append(this)));
            }
        }
    }
}
