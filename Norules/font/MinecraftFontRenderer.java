package font;

import java.util.*;
import java.awt.*;
import net.minecraft.client.renderer.*;

public final class MinecraftFontRenderer extends BasicFontRenderer
{
    private final /* synthetic */ FontData boldFont;
    private final /* synthetic */ FontData italicFont;
    private final /* synthetic */ FontData boldItalicFont;
    private final /* synthetic */ int[] colorCode;
    
    public int drawStringWithShadow(final String llllllllllllllIIIIIIIIIlIlIlIIll, final int llllllllllllllIIIIIIIIIlIlIlIIlI, final int llllllllllllllIIIIIIIIIlIlIlIllI, final int llllllllllllllIIIIIIIIIlIlIlIlIl) {
        return Math.max(this.drawString(llllllllllllllIIIIIIIIIlIlIlIIll, llllllllllllllIIIIIIIIIlIlIlIIlI + 1, llllllllllllllIIIIIIIIIlIlIlIllI + 1, llllllllllllllIIIIIIIIIlIlIlIlIl, true, 0.0f), this.drawString(llllllllllllllIIIIIIIIIlIlIlIIll, llllllllllllllIIIIIIIIIlIlIlIIlI, llllllllllllllIIIIIIIIIlIlIlIllI, llllllllllllllIIIIIIIIIlIlIlIlIl, false, 0.0f));
    }
    
    public int drawString(final String llllllllllllllIIIIIIIIIlIIlIlIlI, final int llllllllllllllIIIIIIIIIlIIlIIIll, final int llllllllllllllIIIIIIIIIlIIlIIIlI, final int llllllllllllllIIIIIIIIIlIIlIIlll, final float llllllllllllllIIIIIIIIIlIIlIIIII) {
        return this.drawString(llllllllllllllIIIIIIIIIlIIlIlIlI, llllllllllllllIIIIIIIIIlIIlIIIll, llllllllllllllIIIIIIIIIlIIlIIIlI, llllllllllllllIIIIIIIIIlIIlIIlll, false, llllllllllllllIIIIIIIIIlIIlIIIII);
    }
    
    public List<String> formatString(final String llllllllllllllIIIIIIIIIllIIlllII, final double llllllllllllllIIIIIIIIIllIIllIll) {
        final ArrayList<String> llllllllllllllIIIIIIIIIllIIllIlI = new ArrayList<String>();
        StringBuilder llllllllllllllIIIIIIIIIllIIllIIl = new StringBuilder();
        char llllllllllllllIIIIIIIIIllIIllIII = '\uffff';
        final char[] llllllllllllllIIIIIIIIIllIIlIlll = llllllllllllllIIIIIIIIIllIIlllII.toCharArray();
        for (int llllllllllllllIIIIIIIIIllIIlIllI = 0; llllllllllllllIIIIIIIIIllIIlIllI < llllllllllllllIIIIIIIIIllIIlIlll.length; ++llllllllllllllIIIIIIIIIllIIlIllI) {
            final char llllllllllllllIIIIIIIIIllIIlIlIl = llllllllllllllIIIIIIIIIllIIlIlll[llllllllllllllIIIIIIIIIllIIlIllI];
            if (llllllllllllllIIIIIIIIIllIIlIlIl == '§' && llllllllllllllIIIIIIIIIllIIlIllI < llllllllllllllIIIIIIIIIllIIlIlll.length - 1) {
                llllllllllllllIIIIIIIIIllIIllIII = llllllllllllllIIIIIIIIIllIIlIlll[llllllllllllllIIIIIIIIIllIIlIllI + 1];
            }
            if (this.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(String.valueOf(llllllllllllllIIIIIIIIIllIIllIIl))).append(llllllllllllllIIIIIIIIIllIIlIlIl))) < llllllllllllllIIIIIIIIIllIIllIll) {
                llllllllllllllIIIIIIIIIllIIllIIl.append(llllllllllllllIIIIIIIIIllIIlIlIl);
            }
            else {
                llllllllllllllIIIIIIIIIllIIllIlI.add(String.valueOf(llllllllllllllIIIIIIIIIllIIllIIl));
                llllllllllllllIIIIIIIIIllIIllIIl = new StringBuilder(String.valueOf(new StringBuilder("§").append(llllllllllllllIIIIIIIIIllIIllIII).append(llllllllllllllIIIIIIIIIllIIlIlIl)));
            }
        }
        if (llllllllllllllIIIIIIIIIllIIllIIl.length() > 0) {
            llllllllllllllIIIIIIIIIllIIllIlI.add(String.valueOf(llllllllllllllIIIIIIIIIllIIllIIl));
        }
        return llllllllllllllIIIIIIIIIllIIllIlI;
    }
    
    @Override
    public int drawString(final String llllllllllllllIIIIIIIIIlIllIIIlI, final int llllllllllllllIIIIIIIIIlIllIIllI, final int llllllllllllllIIIIIIIIIlIllIIlIl, final int llllllllllllllIIIIIIIIIlIllIIlII) {
        return this.drawString(llllllllllllllIIIIIIIIIlIllIIIlI, llllllllllllllIIIIIIIIIlIllIIllI, llllllllllllllIIIIIIIIIlIllIIlIl, llllllllllllllIIIIIIIIIlIllIIlII, false, 0.0f);
    }
    
    public void drawCenteredStringWithShadow(final String llllllllllllllIIIIIIIIIlIIIIIllI, final int llllllllllllllIIIIIIIIIlIIIIIlIl, final int llllllllllllllIIIIIIIIIlIIIIIlII, final int llllllllllllllIIIIIIIIIlIIIIIIll, final float llllllllllllllIIIIIIIIIlIIIIIIlI) {
        this.drawStringWithShadow(llllllllllllllIIIIIIIIIlIIIIIllI, llllllllllllllIIIIIIIIIlIIIIIlIl - this.getStringWidth(llllllllllllllIIIIIIIIIlIIIIIllI) / 2, llllllllllllllIIIIIIIIIlIIIIIlII - this.getStringHeight(llllllllllllllIIIIIIIIIlIIIIIllI) / 2, llllllllllllllIIIIIIIIIlIIIIIIll, llllllllllllllIIIIIIIIIlIIIIIIlI);
    }
    
    public int drawStringWithShadow(final String llllllllllllllIIIIIIIIIlIIIlIIlI, final int llllllllllllllIIIIIIIIIlIIIlIIIl, final int llllllllllllllIIIIIIIIIlIIIlIIII, final int llllllllllllllIIIIIIIIIlIIIlIlIl, final float llllllllllllllIIIIIIIIIlIIIIlllI) {
        return Math.max(this.drawString(llllllllllllllIIIIIIIIIlIIIlIIlI, llllllllllllllIIIIIIIIIlIIIlIIIl + 1, llllllllllllllIIIIIIIIIlIIIlIIII + 1, llllllllllllllIIIIIIIIIlIIIlIlIl, true, llllllllllllllIIIIIIIIIlIIIIlllI), this.drawString(llllllllllllllIIIIIIIIIlIIIlIIlI, llllllllllllllIIIIIIIIIlIIIlIIIl, llllllllllllllIIIIIIIIIlIIIlIIII, llllllllllllllIIIIIIIIIlIIIlIlIl, false, llllllllllllllIIIIIIIIIlIIIIlllI));
    }
    
    @Deprecated
    @Override
    public int drawString(final FontData llllllllllllllIIIIIIIIIlIlllIIlI, final String llllllllllllllIIIIIIIIIlIlllIIIl, final int llllllllllllllIIIIIIIIIlIlllIIII, final int llllllllllllllIIIIIIIIIlIllIllll, final int llllllllllllllIIIIIIIIIlIllIlllI) {
        return 0;
    }
    
    public void drawCenteredStringWithShadow(final String llllllllllllllIIIIIIIIIlIlIIIlII, final int llllllllllllllIIIIIIIIIlIlIIlIII, final int llllllllllllllIIIIIIIIIlIlIIIIlI, final int llllllllllllllIIIIIIIIIlIlIIIIIl) {
        this.drawStringWithShadow(llllllllllllllIIIIIIIIIlIlIIIlII, llllllllllllllIIIIIIIIIlIlIIlIII - this.getStringWidth(llllllllllllllIIIIIIIIIlIlIIIlII) / 2, llllllllllllllIIIIIIIIIlIlIIIIlI - this.getStringHeight(llllllllllllllIIIIIIIIIlIlIIIlII) / 2, llllllllllllllIIIIIIIIIlIlIIIIIl);
    }
    
    public MinecraftFontRenderer() {
        this.boldFont = new FontData();
        this.italicFont = new FontData();
        this.boldItalicFont = new FontData();
        this.colorCode = new int[32];
        for (int llllllllllllllIIIIIIIIIlllIlIlIl = 0; llllllllllllllIIIIIIIIIlllIlIlIl < 32; ++llllllllllllllIIIIIIIIIlllIlIlIl) {
            final int llllllllllllllIIIIIIIIIlllIlIlII = (llllllllllllllIIIIIIIIIlllIlIlIl >> 3 & 0x1) * 85;
            int llllllllllllllIIIIIIIIIlllIlIIll = (llllllllllllllIIIIIIIIIlllIlIlIl >> 2 & 0x1) * 170 + llllllllllllllIIIIIIIIIlllIlIlII;
            int llllllllllllllIIIIIIIIIlllIlIIlI = (llllllllllllllIIIIIIIIIlllIlIlIl >> 1 & 0x1) * 170 + llllllllllllllIIIIIIIIIlllIlIlII;
            int llllllllllllllIIIIIIIIIlllIlIIIl = (llllllllllllllIIIIIIIIIlllIlIlIl & 0x1) * 170 + llllllllllllllIIIIIIIIIlllIlIlII;
            if (llllllllllllllIIIIIIIIIlllIlIlIl == 6) {
                llllllllllllllIIIIIIIIIlllIlIIll += 85;
            }
            if (llllllllllllllIIIIIIIIIlllIlIlIl >= 16) {
                llllllllllllllIIIIIIIIIlllIlIIll /= 4;
                llllllllllllllIIIIIIIIIlllIlIIlI /= 4;
                llllllllllllllIIIIIIIIIlllIlIIIl /= 4;
            }
            this.colorCode[llllllllllllllIIIIIIIIIlllIlIlIl] = ((llllllllllllllIIIIIIIIIlllIlIIll & 0xFF) << 16 | (llllllllllllllIIIIIIIIIlllIlIIlI & 0xFF) << 8 | (llllllllllllllIIIIIIIIIlllIlIIIl & 0xFF));
        }
    }
    
    public List<String> wrapWords(final String llllllllllllllIIIIIIIIIllIllIIlI, final double llllllllllllllIIIIIIIIIllIlllIll) {
        final ArrayList<String> llllllllllllllIIIIIIIIIllIlllIlI = new ArrayList<String>();
        if (this.getStringWidth(llllllllllllllIIIIIIIIIllIllIIlI) > llllllllllllllIIIIIIIIIllIlllIll) {
            final String[] llllllllllllllIIIIIIIIIllIlllIIl = llllllllllllllIIIIIIIIIllIllIIlI.split(" ");
            StringBuilder llllllllllllllIIIIIIIIIllIlllIII = new StringBuilder();
            char llllllllllllllIIIIIIIIIllIllIlll = '\uffff';
            final String llllllllllllllIIIIIIIIIllIlIlIIl;
            final Exception llllllllllllllIIIIIIIIIllIlIlIlI = (Exception)((String[])(Object)(llllllllllllllIIIIIIIIIllIlIlIIl = (String)(Object)llllllllllllllIIIIIIIIIllIlllIIl)).length;
            for (final String llllllllllllllIIIIIIIIIllIllIllI : llllllllllllllIIIIIIIIIllIlIlIIl) {
                for (int llllllllllllllIIIIIIIIIllIllIlIl = 0; llllllllllllllIIIIIIIIIllIllIlIl < llllllllllllllIIIIIIIIIllIllIllI.toCharArray().length; ++llllllllllllllIIIIIIIIIllIllIlIl) {
                    final char llllllllllllllIIIIIIIIIllIllIlII = llllllllllllllIIIIIIIIIllIllIllI.toCharArray()[llllllllllllllIIIIIIIIIllIllIlIl];
                    if (llllllllllllllIIIIIIIIIllIllIlII == '§' && llllllllllllllIIIIIIIIIllIllIlIl < llllllllllllllIIIIIIIIIllIllIllI.toCharArray().length - 1) {
                        llllllllllllllIIIIIIIIIllIllIlll = llllllllllllllIIIIIIIIIllIllIllI.toCharArray()[llllllllllllllIIIIIIIIIllIllIlIl + 1];
                    }
                }
                if (this.getStringWidth(String.valueOf(new StringBuilder().append((Object)llllllllllllllIIIIIIIIIllIlllIII).append(llllllllllllllIIIIIIIIIllIllIllI).append(" "))) < llllllllllllllIIIIIIIIIllIlllIll) {
                    llllllllllllllIIIIIIIIIllIlllIII.append(llllllllllllllIIIIIIIIIllIllIllI).append(" ");
                }
                else {
                    llllllllllllllIIIIIIIIIllIlllIlI.add(String.valueOf(llllllllllllllIIIIIIIIIllIlllIII));
                    llllllllllllllIIIIIIIIIllIlllIII = new StringBuilder(String.valueOf(new StringBuilder("§").append(llllllllllllllIIIIIIIIIllIllIlll).append(llllllllllllllIIIIIIIIIllIllIllI).append(" ")));
                }
            }
            if (llllllllllllllIIIIIIIIIllIlllIII.length() > 0) {
                if (this.getStringWidth(String.valueOf(llllllllllllllIIIIIIIIIllIlllIII)) < llllllllllllllIIIIIIIIIllIlllIll) {
                    llllllllllllllIIIIIIIIIllIlllIlI.add(String.valueOf(new StringBuilder("§").append(llllllllllllllIIIIIIIIIllIllIlll).append((Object)llllllllllllllIIIIIIIIIllIlllIII).append(" ")));
                    llllllllllllllIIIIIIIIIllIlllIII = new StringBuilder();
                }
                else {
                    llllllllllllllIIIIIIIIIllIlllIlI.addAll(this.formatString(String.valueOf(llllllllllllllIIIIIIIIIllIlllIII), llllllllllllllIIIIIIIIIllIlllIll));
                }
            }
        }
        else {
            llllllllllllllIIIIIIIIIllIlllIlI.add(llllllllllllllIIIIIIIIIllIllIIlI);
        }
        return llllllllllllllIIIIIIIIIllIlllIlI;
    }
    
    public int getStringWidth(final String llllllllllllllIIIIIIIIIIIllllIll) {
        if (llllllllllllllIIIIIIIIIIIllllIll == null) {
            return 0;
        }
        int llllllllllllllIIIIIIIIIIlIIIIlII = 0;
        FontData llllllllllllllIIIIIIIIIIlIIIIIll = this.fontData;
        boolean llllllllllllllIIIIIIIIIIlIIIIIlI = false;
        boolean llllllllllllllIIIIIIIIIIlIIIIIIl = false;
        for (int llllllllllllllIIIIIIIIIIlIIIIIII = llllllllllllllIIIIIIIIIIIllllIll.length(), llllllllllllllIIIIIIIIIIIlllllll = 0; llllllllllllllIIIIIIIIIIIlllllll < llllllllllllllIIIIIIIIIIlIIIIIII; ++llllllllllllllIIIIIIIIIIIlllllll) {
            final char llllllllllllllIIIIIIIIIIIllllllI = llllllllllllllIIIIIIIIIIIllllIll.charAt(llllllllllllllIIIIIIIIIIIlllllll);
            if (llllllllllllllIIIIIIIIIIIllllllI == '§' && llllllllllllllIIIIIIIIIIIlllllll < llllllllllllllIIIIIIIIIIlIIIIIII) {
                final int llllllllllllllIIIIIIIIIIIlllllIl = "0123456789abcdefklmnor".indexOf(llllllllllllllIIIIIIIIIIIllllllI);
                if (llllllllllllllIIIIIIIIIIIlllllIl < 16) {
                    llllllllllllllIIIIIIIIIIlIIIIIlI = false;
                    llllllllllllllIIIIIIIIIIlIIIIIIl = false;
                }
                else if (llllllllllllllIIIIIIIIIIIlllllIl == 17) {
                    llllllllllllllIIIIIIIIIIlIIIIIlI = true;
                    if (llllllllllllllIIIIIIIIIIlIIIIIIl) {
                        llllllllllllllIIIIIIIIIIlIIIIIll = this.boldItalicFont;
                    }
                    else {
                        llllllllllllllIIIIIIIIIIlIIIIIll = this.boldFont;
                    }
                }
                else if (llllllllllllllIIIIIIIIIIIlllllIl == 20) {
                    llllllllllllllIIIIIIIIIIlIIIIIIl = true;
                    if (llllllllllllllIIIIIIIIIIlIIIIIlI) {
                        llllllllllllllIIIIIIIIIIlIIIIIll = this.boldItalicFont;
                    }
                    else {
                        llllllllllllllIIIIIIIIIIlIIIIIll = this.italicFont;
                    }
                }
                else if (llllllllllllllIIIIIIIIIIIlllllIl == 21) {
                    llllllllllllllIIIIIIIIIIlIIIIIlI = false;
                    llllllllllllllIIIIIIIIIIlIIIIIIl = false;
                    llllllllllllllIIIIIIIIIIlIIIIIll = this.fontData;
                }
                ++llllllllllllllIIIIIIIIIIIlllllll;
            }
            else if (llllllllllllllIIIIIIIIIIlIIIIIll.hasBounds(llllllllllllllIIIIIIIIIIIllllllI)) {
                llllllllllllllIIIIIIIIIIlIIIIlII += llllllllllllllIIIIIIIIIIlIIIIIll.getCharacterBounds(llllllllllllllIIIIIIIIIIIllllllI).width + this.kerning;
            }
        }
        return llllllllllllllIIIIIIIIIIlIIIIlII / 2;
    }
    
    public void drawCenteredString(final String llllllllllllllIIIIIIIIIlIIllIlIl, final int llllllllllllllIIIIIIIIIlIIlllIIl, final int llllllllllllllIIIIIIIIIlIIllIIll, final int llllllllllllllIIIIIIIIIlIIllIIlI) {
        this.drawString(llllllllllllllIIIIIIIIIlIIllIlIl, llllllllllllllIIIIIIIIIlIIlllIIl - this.getStringWidth(llllllllllllllIIIIIIIIIlIIllIlIl) / 2, llllllllllllllIIIIIIIIIlIIllIIll - this.getStringHeight(llllllllllllllIIIIIIIIIlIIllIlIl) / 2, llllllllllllllIIIIIIIIIlIIllIIlI);
    }
    
    public int getStringHeight(final String llllllllllllllIIIIIIIIIIlIIllIIl) {
        if (llllllllllllllIIIIIIIIIIlIIllIIl == null) {
            return 0;
        }
        int llllllllllllllIIIIIIIIIIlIlIIIlI = 0;
        FontData llllllllllllllIIIIIIIIIIlIlIIIIl = this.fontData;
        boolean llllllllllllllIIIIIIIIIIlIlIIIII = false;
        boolean llllllllllllllIIIIIIIIIIlIIlllll = false;
        for (int llllllllllllllIIIIIIIIIIlIIllllI = llllllllllllllIIIIIIIIIIlIIllIIl.length(), llllllllllllllIIIIIIIIIIlIIlllIl = 0; llllllllllllllIIIIIIIIIIlIIlllIl < llllllllllllllIIIIIIIIIIlIIllllI; ++llllllllllllllIIIIIIIIIIlIIlllIl) {
            final char llllllllllllllIIIIIIIIIIlIIlllII = llllllllllllllIIIIIIIIIIlIIllIIl.charAt(llllllllllllllIIIIIIIIIIlIIlllIl);
            if (llllllllllllllIIIIIIIIIIlIIlllII == '§' && llllllllllllllIIIIIIIIIIlIIlllIl < llllllllllllllIIIIIIIIIIlIIllllI) {
                final int llllllllllllllIIIIIIIIIIlIIllIll = "0123456789abcdefklmnor".indexOf(llllllllllllllIIIIIIIIIIlIIlllII);
                if (llllllllllllllIIIIIIIIIIlIIllIll < 16) {
                    llllllllllllllIIIIIIIIIIlIlIIIII = false;
                    llllllllllllllIIIIIIIIIIlIIlllll = false;
                }
                else if (llllllllllllllIIIIIIIIIIlIIllIll == 17) {
                    llllllllllllllIIIIIIIIIIlIlIIIII = true;
                    if (llllllllllllllIIIIIIIIIIlIIlllll) {
                        llllllllllllllIIIIIIIIIIlIlIIIIl = this.boldItalicFont;
                    }
                    else {
                        llllllllllllllIIIIIIIIIIlIlIIIIl = this.boldFont;
                    }
                }
                else if (llllllllllllllIIIIIIIIIIlIIllIll == 20) {
                    llllllllllllllIIIIIIIIIIlIIlllll = true;
                    if (llllllllllllllIIIIIIIIIIlIlIIIII) {
                        llllllllllllllIIIIIIIIIIlIlIIIIl = this.boldItalicFont;
                    }
                    else {
                        llllllllllllllIIIIIIIIIIlIlIIIIl = this.italicFont;
                    }
                }
                else if (llllllllllllllIIIIIIIIIIlIIllIll == 21) {
                    llllllllllllllIIIIIIIIIIlIlIIIII = false;
                    llllllllllllllIIIIIIIIIIlIIlllll = false;
                    llllllllllllllIIIIIIIIIIlIlIIIIl = this.fontData;
                }
                ++llllllllllllllIIIIIIIIIIlIIlllIl;
            }
            else if (llllllllllllllIIIIIIIIIIlIlIIIIl.hasBounds(llllllllllllllIIIIIIIIIIlIIlllII) && llllllllllllllIIIIIIIIIIlIlIIIIl.getCharacterBounds(llllllllllllllIIIIIIIIIIlIIlllII).height > llllllllllllllIIIIIIIIIIlIlIIIlI) {
                llllllllllllllIIIIIIIIIIlIlIIIlI = llllllllllllllIIIIIIIIIIlIlIIIIl.getCharacterBounds(llllllllllllllIIIIIIIIIIlIIlllII).height;
            }
        }
        return llllllllllllllIIIIIIIIIIlIlIIIlI / 2;
    }
    
    public void setFont(final Font llllllllllllllIIIIIIIIIIIllIlllI, final boolean llllllllllllllIIIIIIIIIIIllIlIlI) {
        this.fontData.setFont(llllllllllllllIIIIIIIIIIIllIlllI, llllllllllllllIIIIIIIIIIIllIlIlI);
        this.boldFont.setFont(llllllllllllllIIIIIIIIIIIllIlllI.deriveFont(1), llllllllllllllIIIIIIIIIIIllIlIlI);
        this.italicFont.setFont(llllllllllllllIIIIIIIIIIIllIlllI.deriveFont(2), llllllllllllllIIIIIIIIIIIllIlIlI);
        this.boldItalicFont.setFont(llllllllllllllIIIIIIIIIIIllIlllI.deriveFont(3), llllllllllllllIIIIIIIIIIIllIlIlI);
    }
    
    public int drawString(final String llllllllllllllIIIIIIIIIIllIlIlIl, int llllllllllllllIIIIIIIIIIlIllllll, int llllllllllllllIIIIIIIIIIlIlllllI, int llllllllllllllIIIIIIIIIIlIllllIl, final boolean llllllllllllllIIIIIIIIIIlIllllII, final float llllllllllllllIIIIIIIIIIllIlIIII) {
        if (llllllllllllllIIIIIIIIIIllIlIlIl == null) {
            return 0;
        }
        if (llllllllllllllIIIIIIIIIIlIllllIl == 553648127) {
            llllllllllllllIIIIIIIIIIlIllllIl = 16777215;
        }
        if ((llllllllllllllIIIIIIIIIIlIllllIl & 0xFC000000) == 0x0) {
            llllllllllllllIIIIIIIIIIlIllllIl |= 0xFF000000;
        }
        if (llllllllllllllIIIIIIIIIIlIllllII) {
            llllllllllllllIIIIIIIIIIlIllllIl = ((llllllllllllllIIIIIIIIIIlIllllIl & 0xFCFCFC) >> 2 | (llllllllllllllIIIIIIIIIIlIllllIl & 0xFF000000));
        }
        FontData llllllllllllllIIIIIIIIIIllIIllll = this.fontData;
        final float llllllllllllllIIIIIIIIIIllIIlllI = (llllllllllllllIIIIIIIIIIlIllllIl >> 24 & 0xFF) / 255.0f;
        boolean llllllllllllllIIIIIIIIIIllIIllIl = false;
        boolean llllllllllllllIIIIIIIIIIllIIllII = false;
        boolean llllllllllllllIIIIIIIIIIllIIlIll = false;
        boolean llllllllllllllIIIIIIIIIIllIIlIlI = false;
        boolean llllllllllllllIIIIIIIIIIllIIlIIl = false;
        llllllllllllllIIIIIIIIIIlIllllll *= (int)2.0f;
        llllllllllllllIIIIIIIIIIlIlllllI = (String)(int)((float)llllllllllllllIIIIIIIIIIlIlllllI * 2.0f);
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5f, 0.5f, 0.5f);
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((llllllllllllllIIIIIIIIIIlIllllIl >> 16 & 0xFF) / 255.0f, (llllllllllllllIIIIIIIIIIlIllllIl >> 8 & 0xFF) / 255.0f, (llllllllllllllIIIIIIIIIIlIllllIl & 0xFF) / 255.0f, llllllllllllllIIIIIIIIIIllIIlllI);
        final int llllllllllllllIIIIIIIIIIllIIlIII = llllllllllllllIIIIIIIIIIllIlIlIl.length();
        llllllllllllllIIIIIIIIIIllIIllll.bind();
        for (int llllllllllllllIIIIIIIIIIllIIIlll = 0; llllllllllllllIIIIIIIIIIllIIIlll < llllllllllllllIIIIIIIIIIllIIlIII; ++llllllllllllllIIIIIIIIIIllIIIlll) {
            char llllllllllllllIIIIIIIIIIllIIIllI = llllllllllllllIIIIIIIIIIllIlIlIl.charAt(llllllllllllllIIIIIIIIIIllIIIlll);
            if (llllllllllllllIIIIIIIIIIllIIIllI == '§' && llllllllllllllIIIIIIIIIIllIIIlll < llllllllllllllIIIIIIIIIIllIIlIII && llllllllllllllIIIIIIIIIIllIIIlll + 1 < llllllllllllllIIIIIIIIIIllIIlIII) {
                int llllllllllllllIIIIIIIIIIllIIIlIl = "0123456789abcdefklmnor".indexOf(llllllllllllllIIIIIIIIIIllIlIlIl.charAt(llllllllllllllIIIIIIIIIIllIIIlll + 1));
                if (llllllllllllllIIIIIIIIIIllIIIlIl < 16) {
                    llllllllllllllIIIIIIIIIIllIIllII = false;
                    llllllllllllllIIIIIIIIIIllIIlIll = false;
                    llllllllllllllIIIIIIIIIIllIIllIl = false;
                    llllllllllllllIIIIIIIIIIllIIlIIl = false;
                    llllllllllllllIIIIIIIIIIllIIlIlI = false;
                    llllllllllllllIIIIIIIIIIllIIllll = this.fontData;
                    llllllllllllllIIIIIIIIIIllIIllll.bind();
                    if (llllllllllllllIIIIIIIIIIllIIIlIl < 0 || llllllllllllllIIIIIIIIIIllIIIlIl > 15) {
                        llllllllllllllIIIIIIIIIIllIIIlIl = 15;
                    }
                    if (llllllllllllllIIIIIIIIIIlIllllII) {
                        llllllllllllllIIIIIIIIIIllIIIlIl += 16;
                    }
                    final int llllllllllllllIIIIIIIIIIllIIIlII = this.colorCode[llllllllllllllIIIIIIIIIIllIIIlIl];
                    GlStateManager.color((llllllllllllllIIIIIIIIIIllIIIlII >> 16 & 0xFF) / 255.0f, (llllllllllllllIIIIIIIIIIllIIIlII >> 8 & 0xFF) / 255.0f, (llllllllllllllIIIIIIIIIIllIIIlII & 0xFF) / 255.0f, llllllllllllllIIIIIIIIIIllIIlllI);
                }
                else if (llllllllllllllIIIIIIIIIIllIIIlIl == 16) {
                    llllllllllllllIIIIIIIIIIllIIllIl = true;
                }
                else if (llllllllllllllIIIIIIIIIIllIIIlIl == 17) {
                    llllllllllllllIIIIIIIIIIllIIllII = true;
                    if (llllllllllllllIIIIIIIIIIllIIlIll) {
                        llllllllllllllIIIIIIIIIIllIIllll = this.boldItalicFont;
                        llllllllllllllIIIIIIIIIIllIIllll.bind();
                    }
                    else {
                        llllllllllllllIIIIIIIIIIllIIllll = this.boldFont;
                        llllllllllllllIIIIIIIIIIllIIllll.bind();
                    }
                }
                else if (llllllllllllllIIIIIIIIIIllIIIlIl == 18) {
                    llllllllllllllIIIIIIIIIIllIIlIlI = true;
                }
                else if (llllllllllllllIIIIIIIIIIllIIIlIl == 19) {
                    llllllllllllllIIIIIIIIIIllIIlIIl = true;
                }
                else if (llllllllllllllIIIIIIIIIIllIIIlIl == 20) {
                    llllllllllllllIIIIIIIIIIllIIlIll = true;
                    if (llllllllllllllIIIIIIIIIIllIIllII) {
                        llllllllllllllIIIIIIIIIIllIIllll = this.boldItalicFont;
                        llllllllllllllIIIIIIIIIIllIIllll.bind();
                    }
                    else {
                        llllllllllllllIIIIIIIIIIllIIllll = this.italicFont;
                        llllllllllllllIIIIIIIIIIllIIllll.bind();
                    }
                }
                else if (llllllllllllllIIIIIIIIIIllIIIlIl == 21) {
                    llllllllllllllIIIIIIIIIIllIIllII = false;
                    llllllllllllllIIIIIIIIIIllIIlIll = false;
                    llllllllllllllIIIIIIIIIIllIIllIl = false;
                    llllllllllllllIIIIIIIIIIllIIlIIl = false;
                    llllllllllllllIIIIIIIIIIllIIlIlI = false;
                    GlStateManager.color((llllllllllllllIIIIIIIIIIlIllllIl >> 16 & 0xFF) / 255.0f, (llllllllllllllIIIIIIIIIIlIllllIl >> 8 & 0xFF) / 255.0f, (llllllllllllllIIIIIIIIIIlIllllIl & 0xFF) / 255.0f, llllllllllllllIIIIIIIIIIllIIlllI);
                    llllllllllllllIIIIIIIIIIllIIllll = this.fontData;
                    llllllllllllllIIIIIIIIIIllIIllll.bind();
                }
                ++llllllllllllllIIIIIIIIIIllIIIlll;
            }
            else if (llllllllllllllIIIIIIIIIIllIIllll.hasBounds(llllllllllllllIIIIIIIIIIllIIIllI)) {
                if (llllllllllllllIIIIIIIIIIllIIllIl) {
                    char llllllllllllllIIIIIIIIIIllIIIIll;
                    for (llllllllllllllIIIIIIIIIIllIIIIll = '\0'; llllllllllllllIIIIIIIIIIllIIllll.getCharacterBounds(llllllllllllllIIIIIIIIIIllIIIIll).width != llllllllllllllIIIIIIIIIIllIIllll.getCharacterBounds(llllllllllllllIIIIIIIIIIllIIIllI).width; llllllllllllllIIIIIIIIIIllIIIIll = (char)(Math.random() * 256.0)) {}
                    llllllllllllllIIIIIIIIIIllIIIllI = llllllllllllllIIIIIIIIIIllIIIIll;
                }
                final FontData.CharacterData llllllllllllllIIIIIIIIIIllIIIIlI = llllllllllllllIIIIIIIIIIllIIllll.getCharacterBounds(llllllllllllllIIIIIIIIIIllIIIllI);
                FontUtils.drawTextureRect((float)llllllllllllllIIIIIIIIIIlIllllll, (float)llllllllllllllIIIIIIIIIIlIlllllI, (float)llllllllllllllIIIIIIIIIIllIIIIlI.width, (float)llllllllllllllIIIIIIIIIIllIIIIlI.height, llllllllllllllIIIIIIIIIIllIIIIlI.x / (float)llllllllllllllIIIIIIIIIIllIIllll.getTextureWidth(), llllllllllllllIIIIIIIIIIllIIIIlI.y / (float)llllllllllllllIIIIIIIIIIllIIllll.getTextureHeight(), (llllllllllllllIIIIIIIIIIllIIIIlI.x + llllllllllllllIIIIIIIIIIllIIIIlI.width) / (float)llllllllllllllIIIIIIIIIIllIIllll.getTextureWidth(), (llllllllllllllIIIIIIIIIIllIIIIlI.y + llllllllllllllIIIIIIIIIIllIIIIlI.height) / (float)llllllllllllllIIIIIIIIIIllIIllll.getTextureHeight(), llllllllllllllIIIIIIIIIIllIlIIII);
                if (llllllllllllllIIIIIIIIIIllIIlIlI) {
                    FontUtils.drawLine((float)llllllllllllllIIIIIIIIIIlIllllll, (float)(llllllllllllllIIIIIIIIIIlIlllllI + llllllllllllllIIIIIIIIIIllIIIIlI.height / 4 + 2), (float)(llllllllllllllIIIIIIIIIIlIllllll + llllllllllllllIIIIIIIIIIllIIIIlI.width / 2), (float)(llllllllllllllIIIIIIIIIIlIlllllI + llllllllllllllIIIIIIIIIIllIIIIlI.height / 4 + 2), 1.0f);
                }
                if (llllllllllllllIIIIIIIIIIllIIlIIl) {
                    FontUtils.drawLine((float)llllllllllllllIIIIIIIIIIlIllllll, (float)(llllllllllllllIIIIIIIIIIlIlllllI + llllllllllllllIIIIIIIIIIllIIIIlI.height / 2), (float)(llllllllllllllIIIIIIIIIIlIllllll + llllllllllllllIIIIIIIIIIllIIIIlI.width / 2), (float)(llllllllllllllIIIIIIIIIIlIlllllI + llllllllllllllIIIIIIIIIIllIIIIlI.height / 2), 1.0f);
                }
                llllllllllllllIIIIIIIIIIlIllllll += llllllllllllllIIIIIIIIIIllIIIIlI.width + this.kerning;
            }
        }
        GlStateManager.popMatrix();
        return llllllllllllllIIIIIIIIIIlIllllll;
    }
    
    public void drawCenteredString(final String llllllllllllllIIIIIIIIIIlllIlllI, final int llllllllllllllIIIIIIIIIIlllIllIl, final int llllllllllllllIIIIIIIIIIllllIIlI, final int llllllllllllllIIIIIIIIIIllllIIIl, final float llllllllllllllIIIIIIIIIIlllIlIlI) {
        this.drawString(llllllllllllllIIIIIIIIIIlllIlllI, llllllllllllllIIIIIIIIIIlllIllIl - this.getStringWidth(llllllllllllllIIIIIIIIIIlllIlllI) / 2, llllllllllllllIIIIIIIIIIllllIIlI - this.getStringHeight(llllllllllllllIIIIIIIIIIlllIlllI) / 2, llllllllllllllIIIIIIIIIIllllIIIl, llllllllllllllIIIIIIIIIIlllIlIlI);
    }
    
    public MinecraftFontRenderer(final Font llllllllllllllIIIIIIIIIllIIIIIlI, final boolean llllllllllllllIIIIIIIIIllIIIIIIl) {
        this.boldFont = new FontData();
        this.italicFont = new FontData();
        this.boldItalicFont = new FontData();
        this.colorCode = new int[32];
        this.setFont(llllllllllllllIIIIIIIIIllIIIIIlI, llllllllllllllIIIIIIIIIllIIIIIIl);
        for (int llllllllllllllIIIIIIIIIllIIIIIII = 0; llllllllllllllIIIIIIIIIllIIIIIII < 32; ++llllllllllllllIIIIIIIIIllIIIIIII) {
            final int llllllllllllllIIIIIIIIIlIlllllll = (llllllllllllllIIIIIIIIIllIIIIIII >> 3 & 0x1) * 85;
            int llllllllllllllIIIIIIIIIlIllllllI = (llllllllllllllIIIIIIIIIllIIIIIII >> 2 & 0x1) * 170 + llllllllllllllIIIIIIIIIlIlllllll;
            int llllllllllllllIIIIIIIIIlIlllllIl = (llllllllllllllIIIIIIIIIllIIIIIII >> 1 & 0x1) * 170 + llllllllllllllIIIIIIIIIlIlllllll;
            int llllllllllllllIIIIIIIIIlIlllllII = (llllllllllllllIIIIIIIIIllIIIIIII & 0x1) * 170 + llllllllllllllIIIIIIIIIlIlllllll;
            if (llllllllllllllIIIIIIIIIllIIIIIII == 6) {
                llllllllllllllIIIIIIIIIlIllllllI += 85;
            }
            if (llllllllllllllIIIIIIIIIllIIIIIII >= 16) {
                llllllllllllllIIIIIIIIIlIllllllI /= 4;
                llllllllllllllIIIIIIIIIlIlllllIl /= 4;
                llllllllllllllIIIIIIIIIlIlllllII /= 4;
            }
            this.colorCode[llllllllllllllIIIIIIIIIllIIIIIII] = ((llllllllllllllIIIIIIIIIlIllllllI & 0xFF) << 16 | (llllllllllllllIIIIIIIIIlIlllllIl & 0xFF) << 8 | (llllllllllllllIIIIIIIIIlIlllllII & 0xFF));
        }
    }
}
