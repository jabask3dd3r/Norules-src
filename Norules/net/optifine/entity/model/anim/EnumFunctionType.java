package net.optifine.entity.model.anim;

import net.minecraft.util.math.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.world.*;

public enum EnumFunctionType
{
    TORAD("TORAD", 12, "torad", 1), 
    NEG("NEG", 5, "neg", 1), 
    ATAN2("ATAN2", 11, "atan2", 2), 
    CEIL("CEIL", 19, "ceil", 1), 
    COS("COS", 8, "cos", 1), 
    TAN("TAN", 9, "tan", 1), 
    TIME("TIME", 24, "time", 0), 
    MIN("MIN", 14, "min", 2), 
    MUL("MUL", 2, "*", 2, 1), 
    DIV("DIV", 3, "/", 2, 1), 
    ABS("ABS", 17, "abs", 1), 
    MINUS("MINUS", 1, "-", 2, 0), 
    FLOOR("FLOOR", 18, "floor", 1);
    
    private /* synthetic */ int precedence;
    
    ROUND("ROUND", 21, "round", 1), 
    FRAC("FRAC", 20, "frac", 1);
    
    public static /* synthetic */ EnumFunctionType[] VALUES;
    
    PLUS("PLUS", 0, "+", 2, 0), 
    SQRT("SQRT", 22, "sqrt", 1), 
    CLAMP("CLAMP", 16, "clamp", 3), 
    SIN("SIN", 7, "sin", 1), 
    PI("PI", 6, "pi", 0), 
    ATAN("ATAN", 10, "atan", 1), 
    TODEG("TODEG", 13, "todeg", 1);
    
    private /* synthetic */ String name;
    private /* synthetic */ int countArguments;
    
    MAX("MAX", 15, "max", 2), 
    MOD("MOD", 4, "%", 2, 1), 
    FMOD("FMOD", 23, "fmod", 2);
    
    private EnumFunctionType(final String lllllllllllllIlIlIIIIlIlIIIlIlll, final int lllllllllllllIlIlIIIIlIlIIIlIllI, final String lllllllllllllIlIlIIIIlIlIIIlIlIl, final int lllllllllllllIlIlIIIIlIlIIIllIlI, final int lllllllllllllIlIlIIIIlIlIIIlIIll) {
        this.name = lllllllllllllIlIlIIIIlIlIIIlIlIl;
        this.countArguments = lllllllllllllIlIlIIIIlIlIIIllIlI;
        this.precedence = lllllllllllllIlIlIIIIlIlIIIlIIll;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$optifine$entity$model$anim$EnumFunctionType() {
        final int[] $switch_TABLE$net$optifine$entity$model$anim$EnumFunctionType = EnumFunctionType.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumFunctionType;
        if ($switch_TABLE$net$optifine$entity$model$anim$EnumFunctionType != null) {
            return $switch_TABLE$net$optifine$entity$model$anim$EnumFunctionType;
        }
        final Exception lllllllllllllIlIlIIIIlIIllIlllll = (Object)new int[values().length];
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.ABS.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.ATAN.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.ATAN2.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.CEIL.ordinal()] = 20;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.CLAMP.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.COS.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.DIV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.FLOOR.ordinal()] = 19;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.FMOD.ordinal()] = 24;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.FRAC.ordinal()] = 21;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.MAX.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.MIN.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.MINUS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.MOD.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.MUL.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.NEG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.PI.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError17) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.PLUS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError18) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.ROUND.ordinal()] = 22;
        }
        catch (NoSuchFieldError noSuchFieldError19) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.SIN.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError20) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.SQRT.ordinal()] = 23;
        }
        catch (NoSuchFieldError noSuchFieldError21) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.TAN.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError22) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.TIME.ordinal()] = 25;
        }
        catch (NoSuchFieldError noSuchFieldError23) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.TODEG.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError24) {}
        try {
            lllllllllllllIlIlIIIIlIIllIlllll[EnumFunctionType.TORAD.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError25) {}
        return EnumFunctionType.$SWITCH_TABLE$net$optifine$entity$model$anim$EnumFunctionType = (int[])(Object)lllllllllllllIlIlIIIIlIIllIlllll;
    }
    
    private EnumFunctionType(final String lllllllllllllIlIlIIIIlIlIIlIIllI, final int lllllllllllllIlIlIIIIlIlIIlIIlIl, final String lllllllllllllIlIlIIIIlIlIIlIlIIl, final int lllllllllllllIlIlIIIIlIlIIlIIIll) {
        this.name = lllllllllllllIlIlIIIIlIlIIlIlIIl;
        this.countArguments = lllllllllllllIlIlIIIIlIlIIlIIIll;
    }
    
    public int getPrecedence() {
        return this.precedence;
    }
    
    public float eval(final IExpression[] lllllllllllllIlIlIIIIlIIlllllIII) {
        if (lllllllllllllIlIlIIIIlIIlllllIII.length != this.countArguments) {
            Config.warn(String.valueOf(new StringBuilder("Invalid number of arguments, function: ").append(this).append(", arguments: ").append(lllllllllllllIlIlIIIIlIIlllllIII.length).append(", should be: ").append(this.countArguments)));
            return 0.0f;
        }
        switch ($SWITCH_TABLE$net$optifine$entity$model$anim$EnumFunctionType()[this.ordinal()]) {
            case 1: {
                return lllllllllllllIlIlIIIIlIIlllllIII[0].eval() + lllllllllllllIlIlIIIIlIIlllllIII[1].eval();
            }
            case 2: {
                return lllllllllllllIlIlIIIIlIIlllllIII[0].eval() - lllllllllllllIlIlIIIIlIIlllllIII[1].eval();
            }
            case 3: {
                return lllllllllllllIlIlIIIIlIIlllllIII[0].eval() * lllllllllllllIlIlIIIIlIIlllllIII[1].eval();
            }
            case 4: {
                return lllllllllllllIlIlIIIIlIIlllllIII[0].eval() / lllllllllllllIlIlIIIIlIIlllllIII[1].eval();
            }
            case 5: {
                final float lllllllllllllIlIlIIIIlIIllllllll = lllllllllllllIlIlIIIIlIIlllllIII[0].eval();
                final float lllllllllllllIlIlIIIIlIIlllllllI = lllllllllllllIlIlIIIIlIIlllllIII[1].eval();
                return lllllllllllllIlIlIIIIlIIllllllll - lllllllllllllIlIlIIIIlIIlllllllI * (int)(lllllllllllllIlIlIIIIlIIllllllll / lllllllllllllIlIlIIIIlIIlllllllI);
            }
            case 6: {
                return -lllllllllllllIlIlIIIIlIIlllllIII[0].eval();
            }
            case 7: {
                return 3.1415927f;
            }
            case 8: {
                return MathHelper.sin(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 9: {
                return MathHelper.cos(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 10: {
                return (float)Math.tan(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 11: {
                return (float)Math.atan(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 12: {
                return (float)MathHelper.atan2(lllllllllllllIlIlIIIIlIIlllllIII[0].eval(), lllllllllllllIlIlIIIIlIIlllllIII[1].eval());
            }
            case 13: {
                return MathUtils.toRad(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 14: {
                return MathUtils.toDeg(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 15: {
                return Math.min(lllllllllllllIlIlIIIIlIIlllllIII[0].eval(), lllllllllllllIlIlIIIIlIIlllllIII[1].eval());
            }
            case 16: {
                return Math.max(lllllllllllllIlIlIIIIlIIlllllIII[0].eval(), lllllllllllllIlIlIIIIlIIlllllIII[1].eval());
            }
            case 17: {
                return MathHelper.clamp(lllllllllllllIlIlIIIIlIIlllllIII[0].eval(), lllllllllllllIlIlIIIIlIIlllllIII[1].eval(), lllllllllllllIlIlIIIIlIIlllllIII[2].eval());
            }
            case 18: {
                return MathHelper.abs(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 19: {
                return (float)MathHelper.floor(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 20: {
                return (float)MathHelper.ceil(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 21: {
                return (float)MathHelper.frac(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 22: {
                return (float)Math.round(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 23: {
                return MathHelper.sqrt(lllllllllllllIlIlIIIIlIIlllllIII[0].eval());
            }
            case 24: {
                final float lllllllllllllIlIlIIIIlIIllllllIl = lllllllllllllIlIlIIIIlIIlllllIII[0].eval();
                final float lllllllllllllIlIlIIIIlIIllllllII = lllllllllllllIlIlIIIIlIIlllllIII[1].eval();
                return lllllllllllllIlIlIIIIlIIllllllIl - lllllllllllllIlIlIIIIlIIllllllII * MathHelper.floor(lllllllllllllIlIlIIIIlIIllllllIl / lllllllllllllIlIlIIIIlIIllllllII);
            }
            case 25: {
                final Minecraft lllllllllllllIlIlIIIIlIIlllllIll = Minecraft.getMinecraft();
                final World lllllllllllllIlIlIIIIlIIlllllIlI = lllllllllllllIlIlIIIIlIIlllllIll.world;
                if (lllllllllllllIlIlIIIIlIIlllllIlI == null) {
                    return 0.0f;
                }
                return lllllllllllllIlIlIIIIlIIlllllIlI.getTotalWorldTime() % 24000L + lllllllllllllIlIlIIIIlIIlllllIll.getRenderPartialTicks();
            }
            default: {
                Config.warn(String.valueOf(new StringBuilder("Unknown function type: ").append(this)));
                return 0.0f;
            }
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getCountArguments() {
        return this.countArguments;
    }
    
    public static EnumFunctionType parse(final String lllllllllllllIlIlIIIIlIIlllIlIll) {
        for (int lllllllllllllIlIlIIIIlIIlllIllIl = 0; lllllllllllllIlIlIIIIlIIlllIllIl < EnumFunctionType.VALUES.length; ++lllllllllllllIlIlIIIIlIIlllIllIl) {
            final EnumFunctionType lllllllllllllIlIlIIIIlIIlllIllII = EnumFunctionType.VALUES[lllllllllllllIlIlIIIIlIIlllIllIl];
            if (lllllllllllllIlIlIIIIlIIlllIllII.getName().equals(lllllllllllllIlIlIIIIlIIlllIlIll)) {
                return lllllllllllllIlIlIIIIlIIlllIllII;
            }
        }
        return null;
    }
    
    static {
        EnumFunctionType.VALUES = values();
    }
}
