package font;

import java.awt.*;
import java.io.*;

public enum FontLoader
{
    INSTANCE("INSTANCE", 0);
    
    public final /* synthetic */ MinecraftFontRenderer comforta_light_20;
    public final /* synthetic */ MinecraftFontRenderer open_sans_19;
    public final /* synthetic */ MinecraftFontRenderer consola_20;
    public final /* synthetic */ MinecraftFontRenderer garamond_20;
    public final /* synthetic */ MinecraftFontRenderer lato_19;
    public final /* synthetic */ MinecraftFontRenderer roboto_bold_12;
    public final /* synthetic */ MinecraftFontRenderer open_sans_20;
    public final /* synthetic */ MinecraftFontRenderer comfortaa_bold_16;
    public final /* synthetic */ MinecraftFontRenderer arial_narrow_20;
    public final /* synthetic */ MinecraftFontRenderer sfui_19;
    public final /* synthetic */ MinecraftFontRenderer comfortaa_bold_10;
    public final /* synthetic */ MinecraftFontRenderer consola_19;
    public final /* synthetic */ MinecraftFontRenderer comfortaa_bold_19;
    public final /* synthetic */ MinecraftFontRenderer futura_normal_20;
    public final /* synthetic */ MinecraftFontRenderer sfui_20;
    public final /* synthetic */ MinecraftFontRenderer comforta_light_19;
    public final /* synthetic */ MinecraftFontRenderer comfortaa_bold_20;
    public final /* synthetic */ MinecraftFontRenderer roboto_bold_14;
    public final /* synthetic */ MinecraftFontRenderer hind_19;
    public final /* synthetic */ MinecraftFontRenderer consola_16;
    public final /* synthetic */ MinecraftFontRenderer roboto_bold_20;
    public final /* synthetic */ MinecraftFontRenderer comfortaa_bold_15;
    
    private FontLoader(final String lllllllllllllIllIIIlIllIlllllllI, final int lllllllllllllIllIIIlIllIllllllIl) {
        this.roboto_bold_12 = loadFonts("roboto-bold.ttf", 0, 12.0f);
        this.roboto_bold_14 = loadFonts("roboto-bold.ttf", 0, 14.0f);
        this.roboto_bold_20 = loadFonts("roboto-bold.ttf", 0, 20.0f);
        this.arial_narrow_20 = loadFonts("arial-narrow.ttf", 0, 20.0f);
        this.comfortaa_bold_20 = loadFonts("comfortaa-bold.ttf", 0, 20.0f);
        this.comfortaa_bold_19 = loadFonts("comfortaa-bold.ttf", 0, 19.0f);
        this.consola_19 = loadFonts("consola.ttf", 0, 19.0f);
        this.consola_20 = loadFonts("consola.ttf", 0, 20.0f);
        this.consola_16 = loadFonts("consola.ttf", 0, 16.0f);
        this.comfortaa_bold_10 = loadFonts("comfortaa-bold.ttf", 0, 10.0f);
        this.comfortaa_bold_15 = loadFonts("comfortaa-bold.ttf", 0, 15.0f);
        this.comfortaa_bold_16 = loadFonts("comfortaa-bold.ttf", 0, 16.0f);
        this.comforta_light_20 = loadFonts("comfortaa-light.ttf", 0, 20.0f);
        this.comforta_light_19 = loadFonts("comfortaa-light.ttf", 0, 19.0f);
        this.futura_normal_20 = loadFonts("futura-normal.ttf", 0, 20.0f);
        this.lato_19 = loadFonts("lato.ttf", 0, 19.0f);
        this.hind_19 = loadFonts("arial.ttf", 0, 19.0f);
        this.open_sans_20 = loadFonts("open-sans.ttf", 0, 20.0f);
        this.open_sans_19 = loadFonts("open-sans.ttf", 0, 19.0f);
        this.garamond_20 = loadFonts("garamond.ttf", 0, 20.0f);
        this.sfui_19 = loadFonts("sf-ui.ttf", 0, 19.0f);
        this.sfui_20 = loadFonts("sf-ui.ttf", 0, 20.0f);
    }
    
    private static MinecraftFontRenderer loadFonts(String lllllllllllllIllIIIlIllIllllIIIl, final int lllllllllllllIllIIIlIllIllllIIII, final float lllllllllllllIllIIIlIllIlllIllll) {
        lllllllllllllIllIIIlIllIllllIIIl = String.valueOf(new StringBuilder("/assets/minecraft/font/").append(lllllllllllllIllIIIlIllIllllIIIl));
        try {
            final InputStream lllllllllllllIllIIIlIllIllllIlII = FontLoader.class.getResourceAsStream(lllllllllllllIllIIIlIllIllllIIIl);
            Font lllllllllllllIllIIIlIllIllllIIll = Font.createFont(0, lllllllllllllIllIIIlIllIllllIlII);
            lllllllllllllIllIIIlIllIllllIIll = lllllllllllllIllIIIlIllIllllIIll.deriveFont(lllllllllllllIllIIIlIllIllllIIII, lllllllllllllIllIIIlIllIlllIllll);
            return new MinecraftFontRenderer(lllllllllllllIllIIIlIllIllllIIll, true);
        }
        catch (Exception lllllllllllllIllIIIlIllIllllIIlI) {
            lllllllllllllIllIIIlIllIllllIIlI.printStackTrace();
            return new MinecraftFontRenderer(new Font("Comic Sans MS", 0, (int)lllllllllllllIllIIIlIllIlllIllll), true);
        }
    }
}
