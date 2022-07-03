package net.minecraft.client.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.text.*;
import com.google.common.collect.*;

public class GuiUtilRenderComponents
{
    public static String removeTextColorsIfConfigured(final String llllllllllllIlllllIllIllIlIlIIll, final boolean llllllllllllIlllllIllIllIlIlIIlI) {
        return (!llllllllllllIlllllIllIllIlIlIIlI && !Minecraft.getMinecraft().gameSettings.chatColours) ? TextFormatting.getTextWithoutFormattingCodes(llllllllllllIlllllIllIllIlIlIIll) : llllllllllllIlllllIllIllIlIlIIll;
    }
    
    public static List<ITextComponent> splitText(final ITextComponent llllllllllllIlllllIllIllIIlIIIlI, final int llllllllllllIlllllIllIllIIlllIIl, final FontRenderer llllllllllllIlllllIllIllIIlllIII, final boolean llllllllllllIlllllIllIllIIllIlll, final boolean llllllllllllIlllllIllIllIIllIllI) {
        int llllllllllllIlllllIllIllIIllIlIl = 0;
        ITextComponent llllllllllllIlllllIllIllIIllIlII = new TextComponentString("");
        final List<ITextComponent> llllllllllllIlllllIllIllIIllIIll = (List<ITextComponent>)Lists.newArrayList();
        final List<ITextComponent> llllllllllllIlllllIllIllIIllIIlI = (List<ITextComponent>)Lists.newArrayList((Iterable)llllllllllllIlllllIllIllIIlIIIlI);
        for (int llllllllllllIlllllIllIllIIllIIIl = 0; llllllllllllIlllllIllIllIIllIIIl < llllllllllllIlllllIllIllIIllIIlI.size(); ++llllllllllllIlllllIllIllIIllIIIl) {
            final ITextComponent llllllllllllIlllllIllIllIIllIIII = llllllllllllIlllllIllIllIIllIIlI.get(llllllllllllIlllllIllIllIIllIIIl);
            String llllllllllllIlllllIllIllIIlIllll = llllllllllllIlllllIllIllIIllIIII.getUnformattedComponentText();
            boolean llllllllllllIlllllIllIllIIlIlllI = false;
            if (llllllllllllIlllllIllIllIIlIllll.contains("\n")) {
                final int llllllllllllIlllllIllIllIIlIllIl = llllllllllllIlllllIllIllIIlIllll.indexOf(10);
                final String llllllllllllIlllllIllIllIIlIllII = llllllllllllIlllllIllIllIIlIllll.substring(llllllllllllIlllllIllIllIIlIllIl + 1);
                llllllllllllIlllllIllIllIIlIllll = llllllllllllIlllllIllIllIIlIllll.substring(0, llllllllllllIlllllIllIllIIlIllIl + 1);
                final ITextComponent llllllllllllIlllllIllIllIIlIlIll = new TextComponentString(llllllllllllIlllllIllIllIIlIllII);
                llllllllllllIlllllIllIllIIlIlIll.setStyle(llllllllllllIlllllIllIllIIllIIII.getStyle().createShallowCopy());
                llllllllllllIlllllIllIllIIllIIlI.add(llllllllllllIlllllIllIllIIllIIIl + 1, llllllllllllIlllllIllIllIIlIlIll);
                llllllllllllIlllllIllIllIIlIlllI = true;
            }
            final String llllllllllllIlllllIllIllIIlIlIlI = removeTextColorsIfConfigured(String.valueOf(new StringBuilder(String.valueOf(llllllllllllIlllllIllIllIIllIIII.getStyle().getFormattingCode())).append(llllllllllllIlllllIllIllIIlIllll)), llllllllllllIlllllIllIllIIllIllI);
            final String llllllllllllIlllllIllIllIIlIlIIl = llllllllllllIlllllIllIllIIlIlIlI.endsWith("\n") ? llllllllllllIlllllIllIllIIlIlIlI.substring(0, llllllllllllIlllllIllIllIIlIlIlI.length() - 1) : llllllllllllIlllllIllIllIIlIlIlI;
            int llllllllllllIlllllIllIllIIlIlIII = llllllllllllIlllllIllIllIIlllIII.getStringWidth(llllllllllllIlllllIllIllIIlIlIIl);
            TextComponentString llllllllllllIlllllIllIllIIlIIlll = new TextComponentString(llllllllllllIlllllIllIllIIlIlIIl);
            llllllllllllIlllllIllIllIIlIIlll.setStyle(llllllllllllIlllllIllIllIIllIIII.getStyle().createShallowCopy());
            if (llllllllllllIlllllIllIllIIllIlIl + llllllllllllIlllllIllIllIIlIlIII > llllllllllllIlllllIllIllIIlllIIl) {
                String llllllllllllIlllllIllIllIIlIIllI = llllllllllllIlllllIllIllIIlllIII.trimStringToWidth(llllllllllllIlllllIllIllIIlIlIlI, llllllllllllIlllllIllIllIIlllIIl - llllllllllllIlllllIllIllIIllIlIl, false);
                String llllllllllllIlllllIllIllIIlIIlIl = (llllllllllllIlllllIllIllIIlIIllI.length() < llllllllllllIlllllIllIllIIlIlIlI.length()) ? llllllllllllIlllllIllIllIIlIlIlI.substring(llllllllllllIlllllIllIllIIlIIllI.length()) : null;
                if (llllllllllllIlllllIllIllIIlIIlIl != null && !llllllllllllIlllllIllIllIIlIIlIl.isEmpty()) {
                    int llllllllllllIlllllIllIllIIlIIlII = llllllllllllIlllllIllIllIIlIIllI.lastIndexOf(32);
                    if (llllllllllllIlllllIllIllIIlIIlII >= 0 && llllllllllllIlllllIllIllIIlllIII.getStringWidth(llllllllllllIlllllIllIllIIlIlIlI.substring(0, llllllllllllIlllllIllIllIIlIIlII)) > 0) {
                        llllllllllllIlllllIllIllIIlIIllI = llllllllllllIlllllIllIllIIlIlIlI.substring(0, llllllllllllIlllllIllIllIIlIIlII);
                        if (llllllllllllIlllllIllIllIIllIlll) {
                            ++llllllllllllIlllllIllIllIIlIIlII;
                        }
                        llllllllllllIlllllIllIllIIlIIlIl = llllllllllllIlllllIllIllIIlIlIlI.substring(llllllllllllIlllllIllIllIIlIIlII);
                    }
                    else if (llllllllllllIlllllIllIllIIllIlIl > 0 && !llllllllllllIlllllIllIllIIlIlIlI.contains(" ")) {
                        llllllllllllIlllllIllIllIIlIIllI = "";
                        llllllllllllIlllllIllIllIIlIIlIl = llllllllllllIlllllIllIllIIlIlIlI;
                    }
                    final TextComponentString llllllllllllIlllllIllIllIIlIIIll = new TextComponentString(llllllllllllIlllllIllIllIIlIIlIl);
                    llllllllllllIlllllIllIllIIlIIIll.setStyle(llllllllllllIlllllIllIllIIllIIII.getStyle().createShallowCopy());
                    llllllllllllIlllllIllIllIIllIIlI.add(llllllllllllIlllllIllIllIIllIIIl + 1, llllllllllllIlllllIllIllIIlIIIll);
                }
                llllllllllllIlllllIllIllIIlIlIII = llllllllllllIlllllIllIllIIlllIII.getStringWidth(llllllllllllIlllllIllIllIIlIIllI);
                llllllllllllIlllllIllIllIIlIIlll = new TextComponentString(llllllllllllIlllllIllIllIIlIIllI);
                llllllllllllIlllllIllIllIIlIIlll.setStyle(llllllllllllIlllllIllIllIIllIIII.getStyle().createShallowCopy());
                llllllllllllIlllllIllIllIIlIlllI = true;
            }
            if (llllllllllllIlllllIllIllIIllIlIl + llllllllllllIlllllIllIllIIlIlIII <= llllllllllllIlllllIllIllIIlllIIl) {
                llllllllllllIlllllIllIllIIllIlIl += llllllllllllIlllllIllIllIIlIlIII;
                llllllllllllIlllllIllIllIIllIlII.appendSibling(llllllllllllIlllllIllIllIIlIIlll);
            }
            else {
                llllllllllllIlllllIllIllIIlIlllI = true;
            }
            if (llllllllllllIlllllIllIllIIlIlllI) {
                llllllllllllIlllllIllIllIIllIIll.add(llllllllllllIlllllIllIllIIllIlII);
                llllllllllllIlllllIllIllIIllIlIl = 0;
                llllllllllllIlllllIllIllIIllIlII = new TextComponentString("");
            }
        }
        llllllllllllIlllllIllIllIIllIIll.add(llllllllllllIlllllIllIllIIllIlII);
        return llllllllllllIlllllIllIllIIllIIll;
    }
}
