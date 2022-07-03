package me.nrules.font;

import java.awt.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import java.io.*;

public class Fonts
{
    public static /* synthetic */ CFontRenderer mine;
    public static /* synthetic */ CFontRenderer comfortaal16;
    public static /* synthetic */ CFontRenderer comfortaal18;
    public static /* synthetic */ CFontRenderer comfortaal20;
    
    private static Font getDefault(final int llllllllllllllllIIIllIIIlllIIIIl) {
        final Font llllllllllllllllIIIllIIIlllIIIlI = new Font("default", 0, llllllllllllllllIIIllIIIlllIIIIl);
        return llllllllllllllllIIIllIIIlllIIIlI;
    }
    
    private static Font getFontOTF(final String llllllllllllllllIIIllIIIlllIlIIl, final int llllllllllllllllIIIllIIIlllIlllI) {
        Font llllllllllllllllIIIllIIIlllIllII = null;
        try {
            final InputStream llllllllllllllllIIIllIIIlllIlIll = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(String.valueOf(new StringBuilder("font/").append(llllllllllllllllIIIllIIIlllIlIIl).append(".otf")))).getInputStream();
            Font llllllllllllllllIIIllIIIlllIllIl = Font.createFont(0, llllllllllllllllIIIllIIIlllIlIll);
            llllllllllllllllIIIllIIIlllIllIl = llllllllllllllllIIIllIIIlllIllIl.deriveFont(0, (float)llllllllllllllllIIIllIIIlllIlllI);
        }
        catch (Exception llllllllllllllllIIIllIIIlllIlIlI) {
            llllllllllllllllIIIllIIIlllIlIlI.printStackTrace();
            System.out.println("Error loading font");
            llllllllllllllllIIIllIIIlllIllII = new Font("default", 0, llllllllllllllllIIIllIIIlllIlllI);
        }
        return llllllllllllllllIIIllIIIlllIllII;
    }
    
    static {
        Fonts.comfortaal20 = new CFontRenderer(getFontTTF("comfortaa-light", 22), true, true);
        Fonts.comfortaal18 = new CFontRenderer(getFontTTF("comfortaa-light", 18), true, true);
        Fonts.comfortaal16 = new CFontRenderer(getFontTTF("comfortaa-light", 16), true, true);
        Fonts.mine = new CFontRenderer(getFontOTF("minecraft", 17), false, true);
    }
    
    private static Font getFontTTF(final String llllllllllllllllIIIllIIIllllllIl, final int llllllllllllllllIIIllIIIllllIllI) {
        Font llllllllllllllllIIIllIIIlllllIlI = null;
        try {
            final InputStream llllllllllllllllIIIllIIIlllllIIl = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(String.valueOf(new StringBuilder("font/").append(llllllllllllllllIIIllIIIllllllIl).append(".ttf")))).getInputStream();
            Font llllllllllllllllIIIllIIIlllllIll = Font.createFont(0, llllllllllllllllIIIllIIIlllllIIl);
            llllllllllllllllIIIllIIIlllllIll = llllllllllllllllIIIllIIIlllllIll.deriveFont(0, (float)llllllllllllllllIIIllIIIllllIllI);
        }
        catch (Exception llllllllllllllllIIIllIIIlllllIII) {
            llllllllllllllllIIIllIIIlllllIII.printStackTrace();
            System.out.println("Error loading font");
            llllllllllllllllIIIllIIIlllllIlI = new Font("default", 0, llllllllllllllllIIIllIIIllllIllI);
        }
        return llllllllllllllllIIIllIIIlllllIlI;
    }
}
