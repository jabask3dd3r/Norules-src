package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

public interface TextColor extends Comparable<TextColor>, Examinable, RGBLike, StyleBuilderApplicable, TextFormat
{
    @Nullable
    default TextColor fromCSSHexString(@NotNull final String lllllllllllllIIIIlIlIIIIIIIIlIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "#"
        //     3: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //     6: ifeq            115
        //     9: aload_0         /* lllllllllllllIIIIlIlIIIIIIIIIIll */
        //    10: iconst_1       
        //    11: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    14: astore_1        /* lllllllllllllIIIIlIlIIIIIIIIIIIl */
        //    15: aload_1         /* lllllllllllllIIIIlIlIIIIIIIIIlIl */
        //    16: invokevirtual   java/lang/String.length:()I
        //    19: iconst_3       
        //    20: if_icmpeq       34
        //    23: aload_1         /* lllllllllllllIIIIlIlIIIIIIIIIlIl */
        //    24: invokevirtual   java/lang/String.length:()I
        //    27: bipush          6
        //    29: if_icmpeq       34
        //    32: aconst_null    
        //    33: areturn        
        //    34: aload_1         /* lllllllllllllIIIIlIlIIIIIIIIIlIl */
        //    35: bipush          16
        //    37: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;I)I
        //    40: istore_2        /* lllllllllllllIIIIlIlIIIIIIIIlIlI */
        //    41: goto            47
        //    44: astore_3        /* lllllllllllllIIIIlIIllllllllllll */
        //    45: aconst_null    
        //    46: areturn        
        //    47: aload_1         /* lllllllllllllIIIIlIlIIIIIIIIIlIl */
        //    48: invokevirtual   java/lang/String.length:()I
        //    51: bipush          6
        //    53: if_icmpne       61
        //    56: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //    57: invokestatic    com/viaversion/viaversion/libs/kyori/adventure/text/format/TextColor.color:(I)Lcom/viaversion/viaversion/libs/kyori/adventure/text/format/TextColor;
        //    60: areturn        
        //    61: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //    62: sipush          3840
        //    65: iand           
        //    66: bipush          8
        //    68: ishr           
        //    69: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //    70: sipush          3840
        //    73: iand           
        //    74: iconst_4       
        //    75: ishr           
        //    76: ior            
        //    77: istore_3        /* lllllllllllllIIIIlIIllllllllllll */
        //    78: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //    79: sipush          240
        //    82: iand           
        //    83: iconst_4       
        //    84: ishr           
        //    85: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //    86: sipush          240
        //    89: iand           
        //    90: ior            
        //    91: istore          lllllllllllllIIIIlIlIIIIIIIIIlll
        //    93: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //    94: bipush          15
        //    96: iand           
        //    97: iconst_4       
        //    98: ishl           
        //    99: iload_2         /* lllllllllllllIIIIlIlIIIIIIIIIlII */
        //   100: bipush          15
        //   102: iand           
        //   103: ior            
        //   104: istore          lllllllllllllIIIIlIlIIIIIIIIIllI
        //   106: iload_3         /* lllllllllllllIIIIlIlIIIIIIIIlIII */
        //   107: iload           lllllllllllllIIIIlIlIIIIIIIIIlll
        //   109: iload           lllllllllllllIIIIlIlIIIIIIIIIllI
        //   111: invokestatic    com/viaversion/viaversion/libs/kyori/adventure/text/format/TextColor.color:(III)Lcom/viaversion/viaversion/libs/kyori/adventure/text/format/TextColor;
        //   114: areturn        
        //   115: aconst_null    
        //   116: areturn        
        //    RuntimeInvisibleTypeAnnotations: 00 02 16 00 00 00 19 00 00 14 00 00 18 00 00
        //    MethodParameters:
        //  Name                              Flags  
        //  --------------------------------  -----
        //  lllllllllllllIIIIlIlIIIIIIIIlIll  FINAL
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  34     41     44     47     Ljava/lang/NumberFormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    default TextColor color(@NotNull final HSVLike lllllllllllllIIIIlIlIIIIIlIIIlII) {
        final float lllllllllllllIIIIlIlIIIIIlIIIIlI = lllllllllllllIIIIlIlIIIIIlIIIlII.s();
        final float lllllllllllllIIIIlIlIIIIIlIIIIIl = lllllllllllllIIIIlIlIIIIIlIIIlII.v();
        if (lllllllllllllIIIIlIlIIIIIlIIIIlI == 0.0f) {
            return color(lllllllllllllIIIIlIlIIIIIlIIIIIl, lllllllllllllIIIIlIlIIIIIlIIIIIl, lllllllllllllIIIIlIlIIIIIlIIIIIl);
        }
        final float lllllllllllllIIIIlIlIIIIIlIIIIII = lllllllllllllIIIIlIlIIIIIlIIIlII.h() * 6.0f;
        final int lllllllllllllIIIIlIlIIIIIIllllll = (int)Math.floor(lllllllllllllIIIIlIlIIIIIlIIIIII);
        final float lllllllllllllIIIIlIlIIIIIIlllllI = lllllllllllllIIIIlIlIIIIIlIIIIII - lllllllllllllIIIIlIlIIIIIIllllll;
        final float lllllllllllllIIIIlIlIIIIIIllllIl = lllllllllllllIIIIlIlIIIIIlIIIIIl * (1.0f - lllllllllllllIIIIlIlIIIIIlIIIIlI);
        final float lllllllllllllIIIIlIlIIIIIIllllII = lllllllllllllIIIIlIlIIIIIlIIIIIl * (1.0f - lllllllllllllIIIIlIlIIIIIlIIIIlI * lllllllllllllIIIIlIlIIIIIIlllllI);
        final float lllllllllllllIIIIlIlIIIIIIlllIll = lllllllllllllIIIIlIlIIIIIlIIIIIl * (1.0f - lllllllllllllIIIIlIlIIIIIlIIIIlI * (1.0f - lllllllllllllIIIIlIlIIIIIIlllllI));
        if (lllllllllllllIIIIlIlIIIIIIllllll == 0) {
            return color(lllllllllllllIIIIlIlIIIIIlIIIIIl, lllllllllllllIIIIlIlIIIIIIlllIll, lllllllllllllIIIIlIlIIIIIIllllIl);
        }
        if (lllllllllllllIIIIlIlIIIIIIllllll == 1) {
            return color(lllllllllllllIIIIlIlIIIIIIllllII, lllllllllllllIIIIlIlIIIIIlIIIIIl, lllllllllllllIIIIlIlIIIIIIllllIl);
        }
        if (lllllllllllllIIIIlIlIIIIIIllllll == 2) {
            return color(lllllllllllllIIIIlIlIIIIIIllllIl, lllllllllllllIIIIlIlIIIIIlIIIIIl, lllllllllllllIIIIlIlIIIIIIlllIll);
        }
        if (lllllllllllllIIIIlIlIIIIIIllllll == 3) {
            return color(lllllllllllllIIIIlIlIIIIIIllllIl, lllllllllllllIIIIlIlIIIIIIllllII, lllllllllllllIIIIlIlIIIIIlIIIIIl);
        }
        if (lllllllllllllIIIIlIlIIIIIIllllll == 4) {
            return color(lllllllllllllIIIIlIlIIIIIIlllIll, lllllllllllllIIIIlIlIIIIIIllllIl, lllllllllllllIIIIlIlIIIIIlIIIIIl);
        }
        return color(lllllllllllllIIIIlIlIIIIIlIIIIIl, lllllllllllllIIIIlIlIIIIIIllllIl, lllllllllllllIIIIlIlIIIIIIllllII);
    }
    
    default int red() {
        return this.value() >> 16 & 0xFF;
    }
    
    @NotNull
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of(ExaminableProperty.of("value", this.asHexString()));
    }
    
    default int green() {
        return this.value() >> 8 & 0xFF;
    }
    
    @NotNull
    default TextColor color(final int lllllllllllllIIIIlIlIIIIIlIllIII) {
        final int lllllllllllllIIIIlIlIIIIIlIlIllI = lllllllllllllIIIIlIlIIIIIlIllIII & 0xFFFFFF;
        final NamedTextColor lllllllllllllIIIIlIlIIIIIlIlIlIl = NamedTextColor.ofExact(lllllllllllllIIIIlIlIIIIIlIlIllI);
        return (lllllllllllllIIIIlIlIIIIIlIlIlIl != null) ? lllllllllllllIIIIlIlIIIIIlIlIlIl : new TextColorImpl(lllllllllllllIIIIlIlIIIIIlIlIllI);
    }
    
    @Nullable
    default TextColor fromHexString(@NotNull final String lllllllllllllIIIIlIlIIIIIIIlIlll) {
        if (lllllllllllllIIIIlIlIIIIIIIlIlll.startsWith("#")) {
            try {
                final int lllllllllllllIIIIlIlIIIIIIIlIllI = Integer.parseInt(lllllllllllllIIIIlIlIIIIIIIlIlll.substring(1), 16);
                return color(lllllllllllllIIIIlIlIIIIIIIlIllI);
            }
            catch (NumberFormatException lllllllllllllIIIIlIlIIIIIIIlIlIl) {
                return null;
            }
        }
        return null;
    }
    
    int value();
    
    @NotNull
    default String asHexString() {
        return String.format("#%06x", this.value());
    }
    
    @NotNull
    default TextColor lerp(final float lllllllllllllIIIIlIIlllllllIIlII, @NotNull final RGBLike lllllllllllllIIIIlIIlllllllIIllI, @NotNull final RGBLike lllllllllllllIIIIlIIlllllllIIlIl) {
        final float lllllllllllllIIIIlIIlllllllIIIII = Math.min(1.0f, Math.max(0.0f, lllllllllllllIIIIlIIlllllllIIlII));
        final int lllllllllllllIIIIlIIllllllIlllll = lllllllllllllIIIIlIIlllllllIIllI.red();
        final int lllllllllllllIIIIlIIllllllIllllI = lllllllllllllIIIIlIIlllllllIIlIl.red();
        final int lllllllllllllIIIIlIIllllllIlllIl = lllllllllllllIIIIlIIlllllllIIllI.green();
        final int lllllllllllllIIIIlIIllllllIlllII = lllllllllllllIIIIlIIlllllllIIlIl.green();
        final int lllllllllllllIIIIlIIllllllIllIll = lllllllllllllIIIIlIIlllllllIIllI.blue();
        final int lllllllllllllIIIIlIIllllllIllIlI = lllllllllllllIIIIlIIlllllllIIlIl.blue();
        return color(Math.round(lllllllllllllIIIIlIIllllllIlllll + lllllllllllllIIIIlIIlllllllIIIII * (lllllllllllllIIIIlIIllllllIllllI - lllllllllllllIIIIlIIllllllIlllll)), Math.round(lllllllllllllIIIIlIIllllllIlllIl + lllllllllllllIIIIlIIlllllllIIIII * (lllllllllllllIIIIlIIllllllIlllII - lllllllllllllIIIIlIIllllllIlllIl)), Math.round(lllllllllllllIIIIlIIllllllIllIll + lllllllllllllIIIIlIIlllllllIIIII * (lllllllllllllIIIIlIIllllllIllIlI - lllllllllllllIIIIlIIllllllIllIll)));
    }
    
    @NotNull
    default TextColor color(@NotNull final RGBLike lllllllllllllIIIIlIlIIIIIlIlIIII) {
        return color(lllllllllllllIIIIlIlIIIIIlIlIIII.red(), lllllllllllllIIIIlIlIIIIIlIlIIII.green(), lllllllllllllIIIIlIlIIIIIlIlIIII.blue());
    }
    
    default int blue() {
        return this.value() & 0xFF;
    }
    
    default void styleApply(final Style.Builder lllllllllllllIIIIlIIllllllIIllIl) {
        lllllllllllllIIIIlIIllllllIIllIl.color(this);
    }
    
    @NotNull
    default TextColor color(final int lllllllllllllIIIIlIlIIIIIIlIlllI, final int lllllllllllllIIIIlIlIIIIIIlIllIl, final int lllllllllllllIIIIlIlIIIIIIlIllII) {
        return color((lllllllllllllIIIIlIlIIIIIIlIlllI & 0xFF) << 16 | (lllllllllllllIIIIlIlIIIIIIlIllIl & 0xFF) << 8 | (lllllllllllllIIIIlIlIIIIIIlIllII & 0xFF));
    }
    
    default int compareTo(final TextColor lllllllllllllIIIIlIIllllllIIIllI) {
        return Integer.compare(this.value(), lllllllllllllIIIIlIIllllllIIIllI.value());
    }
    
    @NotNull
    default TextColor color(final float lllllllllllllIIIIlIlIIIIIIlIIIIl, final float lllllllllllllIIIIlIlIIIIIIlIIIII, final float lllllllllllllIIIIlIlIIIIIIlIIIlI) {
        return color((int)(lllllllllllllIIIIlIlIIIIIIlIIIIl * 255.0f), (int)(lllllllllllllIIIIlIlIIIIIIlIIIII * 255.0f), (int)(lllllllllllllIIIIlIlIIIIIIlIIIlI * 255.0f));
    }
}
