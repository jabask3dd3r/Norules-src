package optifine;

import java.util.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class TooltipManager
{
    private /* synthetic */ int lastMouseX;
    private /* synthetic */ int lastMouseY;
    private /* synthetic */ GuiScreen guiScreen;
    private /* synthetic */ long mouseStillTime;
    
    private static String[] getTooltipLines(final String lllllllllllllIllIlIIllIlIIIlIlII) {
        final List<String> lllllllllllllIllIlIIllIlIIIllIIl = new ArrayList<String>();
        for (int lllllllllllllIllIlIIllIlIIIllIII = 0; lllllllllllllIllIlIIllIlIIIllIII < 10; ++lllllllllllllIllIlIIllIlIIIllIII) {
            final String lllllllllllllIllIlIIllIlIIIlIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIlIIllIlIIIlIlII)).append(".tooltip.").append(lllllllllllllIllIlIIllIlIIIllIII + 1));
            final String lllllllllllllIllIlIIllIlIIIlIllI = Lang.get(lllllllllllllIllIlIIllIlIIIlIlll, null);
            if (lllllllllllllIllIlIIllIlIIIlIllI == null) {
                break;
            }
            lllllllllllllIllIlIIllIlIIIllIIl.add(lllllllllllllIllIlIIllIlIIIlIllI);
        }
        if (lllllllllllllIllIlIIllIlIIIllIIl.size() <= 0) {
            return null;
        }
        final String[] lllllllllllllIllIlIIllIlIIIlIlIl = lllllllllllllIllIlIIllIlIIIllIIl.toArray(new String[lllllllllllllIllIlIIllIlIIIllIIl.size()]);
        return lllllllllllllIllIlIIllIlIIIlIlIl;
    }
    
    private static String[] getTooltipLines(final GameSettings.Options lllllllllllllIllIlIIllIlIIlIIIII) {
        return getTooltipLines(lllllllllllllIllIlIIllIlIIlIIIII.getEnumString());
    }
    
    public void drawTooltips(final int lllllllllllllIllIlIIllIlIlIlllII, final int lllllllllllllIllIlIIllIlIlIllIll, final List lllllllllllllIllIlIIllIlIlIIlIIl) {
        if (Math.abs(lllllllllllllIllIlIIllIlIlIlllII - this.lastMouseX) <= 5 && Math.abs(lllllllllllllIllIlIIllIlIlIllIll - this.lastMouseY) <= 5) {
            final int lllllllllllllIllIlIIllIlIlIllIIl = 700;
            if (System.currentTimeMillis() >= this.mouseStillTime + lllllllllllllIllIlIIllIlIlIllIIl) {
                final int lllllllllllllIllIlIIllIlIlIllIII = this.guiScreen.width / 2 - 150;
                int lllllllllllllIllIlIIllIlIlIlIlll = this.guiScreen.height / 6 - 7;
                if (lllllllllllllIllIlIIllIlIlIllIll <= lllllllllllllIllIlIIllIlIlIlIlll + 98) {
                    lllllllllllllIllIlIIllIlIlIlIlll += 105;
                }
                final int lllllllllllllIllIlIIllIlIlIlIllI = lllllllllllllIllIlIIllIlIlIllIII + 150 + 150;
                final int lllllllllllllIllIlIIllIlIlIlIlIl = lllllllllllllIllIlIIllIlIlIlIlll + 84 + 10;
                final GuiButton lllllllllllllIllIlIIllIlIlIlIlII = this.getSelectedButton(lllllllllllllIllIlIIllIlIlIlllII, lllllllllllllIllIlIIllIlIlIllIll, lllllllllllllIllIlIIllIlIlIIlIIl);
                if (lllllllllllllIllIlIIllIlIlIlIlII instanceof IOptionControl) {
                    final IOptionControl lllllllllllllIllIlIIllIlIlIlIIll = (IOptionControl)lllllllllllllIllIlIIllIlIlIlIlII;
                    final GameSettings.Options lllllllllllllIllIlIIllIlIlIlIIlI = lllllllllllllIllIlIIllIlIlIlIIll.getOption();
                    final String[] lllllllllllllIllIlIIllIlIlIlIIIl = getTooltipLines(lllllllllllllIllIlIIllIlIlIlIIlI);
                    if (lllllllllllllIllIlIIllIlIlIlIIIl == null) {
                        return;
                    }
                    Gui.drawRect(lllllllllllllIllIlIIllIlIlIllIII, lllllllllllllIllIlIIllIlIlIlIlll, lllllllllllllIllIlIIllIlIlIlIllI, lllllllllllllIllIlIIllIlIlIlIlIl, -536870912);
                    for (int lllllllllllllIllIlIIllIlIlIlIIII = 0; lllllllllllllIllIlIIllIlIlIlIIII < lllllllllllllIllIlIIllIlIlIlIIIl.length; ++lllllllllllllIllIlIIllIlIlIlIIII) {
                        final String lllllllllllllIllIlIIllIlIlIIllll = lllllllllllllIllIlIIllIlIlIlIIIl[lllllllllllllIllIlIIllIlIlIlIIII];
                        int lllllllllllllIllIlIIllIlIlIIlllI = 14540253;
                        if (lllllllllllllIllIlIIllIlIlIIllll.endsWith("!")) {
                            lllllllllllllIllIlIIllIlIlIIlllI = 16719904;
                        }
                        final FontRenderer lllllllllllllIllIlIIllIlIlIIllIl = Minecraft.getMinecraft().fontRendererObj;
                        lllllllllllllIllIlIIllIlIlIIllIl.drawStringWithShadow(lllllllllllllIllIlIIllIlIlIIllll, (float)(lllllllllllllIllIlIIllIlIlIllIII + 5), (float)(lllllllllllllIllIlIIllIlIlIlIlll + 5 + lllllllllllllIllIlIIllIlIlIlIIII * 11), lllllllllllllIllIlIIllIlIlIIlllI);
                    }
                }
            }
        }
        else {
            this.lastMouseX = lllllllllllllIllIlIIllIlIlIlllII;
            this.lastMouseY = lllllllllllllIllIlIIllIlIlIllIll;
            this.mouseStillTime = System.currentTimeMillis();
        }
    }
    
    private GuiButton getSelectedButton(final int lllllllllllllIllIlIIllIlIIlIlIlI, final int lllllllllllllIllIlIIllIlIIllIIIl, final List lllllllllllllIllIlIIllIlIIlIlIII) {
        for (int lllllllllllllIllIlIIllIlIIlIllll = 0; lllllllllllllIllIlIIllIlIIlIllll < lllllllllllllIllIlIIllIlIIlIlIII.size(); ++lllllllllllllIllIlIIllIlIIlIllll) {
            final GuiButton lllllllllllllIllIlIIllIlIIlIlllI = lllllllllllllIllIlIIllIlIIlIlIII.get(lllllllllllllIllIlIIllIlIIlIllll);
            final int lllllllllllllIllIlIIllIlIIlIllIl = GuiVideoSettings.getButtonWidth(lllllllllllllIllIlIIllIlIIlIlllI);
            final int lllllllllllllIllIlIIllIlIIlIllII = GuiVideoSettings.getButtonHeight(lllllllllllllIllIlIIllIlIIlIlllI);
            final boolean lllllllllllllIllIlIIllIlIIlIlIll = lllllllllllllIllIlIIllIlIIlIlIlI >= lllllllllllllIllIlIIllIlIIlIlllI.xPosition && lllllllllllllIllIlIIllIlIIllIIIl >= lllllllllllllIllIlIIllIlIIlIlllI.yPosition && lllllllllllllIllIlIIllIlIIlIlIlI < lllllllllllllIllIlIIllIlIIlIlllI.xPosition + lllllllllllllIllIlIIllIlIIlIllIl && lllllllllllllIllIlIIllIlIIllIIIl < lllllllllllllIllIlIIllIlIIlIlllI.yPosition + lllllllllllllIllIlIIllIlIIlIllII;
            if (lllllllllllllIllIlIIllIlIIlIlIll) {
                return lllllllllllllIllIlIIllIlIIlIlllI;
            }
        }
        return null;
    }
    
    public TooltipManager(final GuiScreen lllllllllllllIllIlIIllIlIlllIIIl) {
        this.guiScreen = null;
        this.lastMouseX = 0;
        this.lastMouseY = 0;
        this.mouseStillTime = 0L;
        this.guiScreen = lllllllllllllIllIlIIllIlIlllIIIl;
    }
}
