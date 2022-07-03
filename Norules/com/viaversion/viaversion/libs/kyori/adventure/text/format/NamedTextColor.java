package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

public final class NamedTextColor implements TextColor
{
    public static final /* synthetic */ NamedTextColor DARK_RED;
    public static final /* synthetic */ NamedTextColor DARK_PURPLE;
    public static final /* synthetic */ NamedTextColor GREEN;
    public static final /* synthetic */ NamedTextColor BLACK;
    private final /* synthetic */ HSVLike hsv;
    public static final /* synthetic */ NamedTextColor DARK_GRAY;
    public static final /* synthetic */ NamedTextColor GRAY;
    public static final /* synthetic */ NamedTextColor DARK_GREEN;
    public static final /* synthetic */ NamedTextColor AQUA;
    private final /* synthetic */ String name;
    public static final /* synthetic */ NamedTextColor WHITE;
    public static final /* synthetic */ NamedTextColor DARK_BLUE;
    public static final /* synthetic */ NamedTextColor GOLD;
    public static final /* synthetic */ NamedTextColor YELLOW;
    private final /* synthetic */ int value;
    public static final /* synthetic */ NamedTextColor RED;
    private static final /* synthetic */ List<NamedTextColor> VALUES;
    public static final /* synthetic */ NamedTextColor DARK_AQUA;
    public static final /* synthetic */ NamedTextColor BLUE;
    public static final /* synthetic */ NamedTextColor LIGHT_PURPLE;
    
    static {
        GOLD_VALUE = 16755200;
        AQUA_VALUE = 5636095;
        WHITE_VALUE = 16777215;
        DARK_GREEN_VALUE = 43520;
        DARK_AQUA_VALUE = 43690;
        LIGHT_PURPLE_VALUE = 16733695;
        GRAY_VALUE = 11184810;
        BLUE_VALUE = 5592575;
        DARK_RED_VALUE = 11141120;
        DARK_GRAY_VALUE = 5592405;
        GREEN_VALUE = 5635925;
        DARK_BLUE_VALUE = 170;
        BLACK_VALUE = 0;
        RED_VALUE = 16733525;
        DARK_PURPLE_VALUE = 11141290;
        YELLOW_VALUE = 16777045;
        BLACK = new NamedTextColor("black", 0);
        DARK_BLUE = new NamedTextColor("dark_blue", 170);
        DARK_GREEN = new NamedTextColor("dark_green", 43520);
        DARK_AQUA = new NamedTextColor("dark_aqua", 43690);
        DARK_RED = new NamedTextColor("dark_red", 11141120);
        DARK_PURPLE = new NamedTextColor("dark_purple", 11141290);
        GOLD = new NamedTextColor("gold", 16755200);
        GRAY = new NamedTextColor("gray", 11184810);
        DARK_GRAY = new NamedTextColor("dark_gray", 5592405);
        BLUE = new NamedTextColor("blue", 5592575);
        GREEN = new NamedTextColor("green", 5635925);
        AQUA = new NamedTextColor("aqua", 5636095);
        RED = new NamedTextColor("red", 16733525);
        LIGHT_PURPLE = new NamedTextColor("light_purple", 16733695);
        YELLOW = new NamedTextColor("yellow", 16777045);
        WHITE = new NamedTextColor("white", 16777215);
        VALUES = Collections.unmodifiableList((List<? extends NamedTextColor>)Arrays.asList(NamedTextColor.BLACK, NamedTextColor.DARK_BLUE, NamedTextColor.DARK_GREEN, NamedTextColor.DARK_AQUA, NamedTextColor.DARK_RED, NamedTextColor.DARK_PURPLE, NamedTextColor.GOLD, NamedTextColor.GRAY, NamedTextColor.DARK_GRAY, NamedTextColor.BLUE, NamedTextColor.GREEN, NamedTextColor.AQUA, NamedTextColor.RED, NamedTextColor.LIGHT_PURPLE, NamedTextColor.YELLOW, NamedTextColor.WHITE));
        NAMES = Index.create(lllllllllllllllIlIllIIllIlllIlII -> lllllllllllllllIlIllIIllIlllIlII.name, NamedTextColor.VALUES);
    }
    
    @NotNull
    public static NamedTextColor nearestTo(@NotNull final TextColor lllllllllllllllIlIllIIlllIlIllII) {
        if (lllllllllllllllIlIllIIlllIlIllII instanceof NamedTextColor) {
            return (NamedTextColor)lllllllllllllllIlIllIIlllIlIllII;
        }
        Objects.requireNonNull(lllllllllllllllIlIllIIlllIlIllII, "color");
        float lllllllllllllllIlIllIIlllIlIIllI = Float.MAX_VALUE;
        NamedTextColor lllllllllllllllIlIllIIlllIlIIlIl = NamedTextColor.VALUES.get(0);
        for (int lllllllllllllllIlIllIIlllIlIlIIl = 0, lllllllllllllllIlIllIIlllIlIlIII = NamedTextColor.VALUES.size(); lllllllllllllllIlIllIIlllIlIlIIl < lllllllllllllllIlIllIIlllIlIlIII; ++lllllllllllllllIlIllIIlllIlIlIIl) {
            final NamedTextColor lllllllllllllllIlIllIIlllIlIlIll = NamedTextColor.VALUES.get(lllllllllllllllIlIllIIlllIlIlIIl);
            final float lllllllllllllllIlIllIIlllIlIlIlI = distance(lllllllllllllllIlIllIIlllIlIllII.asHSV(), lllllllllllllllIlIllIIlllIlIlIll.asHSV());
            if (lllllllllllllllIlIllIIlllIlIlIlI < lllllllllllllllIlIllIIlllIlIIllI) {
                lllllllllllllllIlIllIIlllIlIIlIl = lllllllllllllllIlIllIIlllIlIlIll;
                lllllllllllllllIlIllIIlllIlIIllI = lllllllllllllllIlIllIIlllIlIlIlI;
            }
            if (lllllllllllllllIlIllIIlllIlIlIlI == 0.0f) {
                break;
            }
        }
        return lllllllllllllllIlIllIIlllIlIIlIl;
    }
    
    @Nullable
    public static NamedTextColor ofExact(final int lllllllllllllllIlIllIIlllIllIllI) {
        if (lllllllllllllllIlIllIIlllIllIllI == 0) {
            return NamedTextColor.BLACK;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 170) {
            return NamedTextColor.DARK_BLUE;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 43520) {
            return NamedTextColor.DARK_GREEN;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 43690) {
            return NamedTextColor.DARK_AQUA;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 11141120) {
            return NamedTextColor.DARK_RED;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 11141290) {
            return NamedTextColor.DARK_PURPLE;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 16755200) {
            return NamedTextColor.GOLD;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 11184810) {
            return NamedTextColor.GRAY;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 5592405) {
            return NamedTextColor.DARK_GRAY;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 5592575) {
            return NamedTextColor.BLUE;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 5635925) {
            return NamedTextColor.GREEN;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 5636095) {
            return NamedTextColor.AQUA;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 16733525) {
            return NamedTextColor.RED;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 16733695) {
            return NamedTextColor.LIGHT_PURPLE;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 16777045) {
            return NamedTextColor.YELLOW;
        }
        if (lllllllllllllllIlIllIIlllIllIllI == 16777215) {
            return NamedTextColor.WHITE;
        }
        return null;
    }
    
    @Override
    public int value() {
        return this.value;
    }
    
    private NamedTextColor(final String lllllllllllllllIlIllIIlllIIIlIIl, final int lllllllllllllllIlIllIIlllIIIlIII) {
        this.name = lllllllllllllllIlIllIIlllIIIlIIl;
        this.value = lllllllllllllllIlIllIIlllIIIlIII;
        this.hsv = HSVLike.fromRGB(this.red(), this.green(), this.blue());
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.name;
    }
    
    private static float distance(@NotNull final HSVLike lllllllllllllllIlIllIIlllIIllIII, @NotNull final HSVLike lllllllllllllllIlIllIIlllIIlIlll) {
        final float lllllllllllllllIlIllIIlllIIlIlII = 3.0f * Math.min(Math.abs(lllllllllllllllIlIllIIlllIIllIII.h() - lllllllllllllllIlIllIIlllIIlIlll.h()), 1.0f - Math.abs(lllllllllllllllIlIllIIlllIIllIII.h() - lllllllllllllllIlIllIIlllIIlIlll.h()));
        final float lllllllllllllllIlIllIIlllIIlIIll = lllllllllllllllIlIllIIlllIIllIII.s() - lllllllllllllllIlIllIIlllIIlIlll.s();
        final float lllllllllllllllIlIllIIlllIIlIIlI = lllllllllllllllIlIllIIlllIIllIII.v() - lllllllllllllllIlIllIIlllIIlIlll.v();
        return lllllllllllllllIlIllIIlllIIlIlII * lllllllllllllllIlIllIIlllIIlIlII + lllllllllllllllIlIllIIlllIIlIIll * lllllllllllllllIlIllIIlllIIlIIll + lllllllllllllllIlIllIIlllIIlIIlI * lllllllllllllllIlIllIIlllIIlIIlI;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("name", this.name)), super.examinableProperties());
    }
    
    @NotNull
    @Override
    public HSVLike asHSV() {
        return this.hsv;
    }
}
