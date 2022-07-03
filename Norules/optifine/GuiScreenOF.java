package optifine;

import java.io.*;
import java.util.*;
import net.minecraft.client.gui.*;

public class GuiScreenOF extends GuiScreen
{
    @Override
    protected void mouseClicked(final int lllllllllllllllIIlIIIIllllIIIlll, final int lllllllllllllllIIlIIIIllllIIlIll, final int lllllllllllllllIIlIIIIllllIIlIlI) throws IOException {
        super.mouseClicked(lllllllllllllllIIlIIIIllllIIIlll, lllllllllllllllIIlIIIIllllIIlIll, lllllllllllllllIIlIIIIllllIIlIlI);
        if (lllllllllllllllIIlIIIIllllIIlIlI == 1) {
            final GuiButton lllllllllllllllIIlIIIIllllIIlIIl = getSelectedButton(this.buttonList, lllllllllllllllIIlIIIIllllIIIlll, lllllllllllllllIIlIIIIllllIIlIll);
            if (lllllllllllllllIIlIIIIllllIIlIIl != null && lllllllllllllllIIlIIIIllllIIlIIl.enabled) {
                lllllllllllllllIIlIIIIllllIIlIIl.playPressSound(this.mc.getSoundHandler());
                this.actionPerformedRightClick(lllllllllllllllIIlIIIIllllIIlIIl);
            }
        }
    }
    
    protected void actionPerformedRightClick(final GuiButton lllllllllllllllIIlIIIIllllIlIIll) throws IOException {
    }
    
    public static GuiButton getSelectedButton(final List<GuiButton> lllllllllllllllIIlIIIIlllIllllII, final int lllllllllllllllIIlIIIIlllIllIlII, final int lllllllllllllllIIlIIIIlllIllIIll) {
        for (int lllllllllllllllIIlIIIIlllIlllIIl = 0; lllllllllllllllIIlIIIIlllIlllIIl < lllllllllllllllIIlIIIIlllIllllII.size(); ++lllllllllllllllIIlIIIIlllIlllIIl) {
            final GuiButton lllllllllllllllIIlIIIIlllIlllIII = lllllllllllllllIIlIIIIlllIllllII.get(lllllllllllllllIIlIIIIlllIlllIIl);
            if (lllllllllllllllIIlIIIIlllIlllIII.visible) {
                final int lllllllllllllllIIlIIIIlllIllIlll = GuiVideoSettings.getButtonWidth(lllllllllllllllIIlIIIIlllIlllIII);
                final int lllllllllllllllIIlIIIIlllIllIllI = GuiVideoSettings.getButtonHeight(lllllllllllllllIIlIIIIlllIlllIII);
                if (lllllllllllllllIIlIIIIlllIllIlII >= lllllllllllllllIIlIIIIlllIlllIII.xPosition && lllllllllllllllIIlIIIIlllIllIIll >= lllllllllllllllIIlIIIIlllIlllIII.yPosition && lllllllllllllllIIlIIIIlllIllIlII < lllllllllllllllIIlIIIIlllIlllIII.xPosition + lllllllllllllllIIlIIIIlllIllIlll && lllllllllllllllIIlIIIIlllIllIIll < lllllllllllllllIIlIIIIlllIlllIII.yPosition + lllllllllllllllIIlIIIIlllIllIllI) {
                    return lllllllllllllllIIlIIIIlllIlllIII;
                }
            }
        }
        return null;
    }
}
