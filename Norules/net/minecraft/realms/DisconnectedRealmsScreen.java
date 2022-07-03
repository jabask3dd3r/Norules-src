package net.minecraft.realms;

import java.util.*;
import net.minecraft.util.text.*;

public class DisconnectedRealmsScreen extends RealmsScreen
{
    private final /* synthetic */ RealmsScreen parent;
    private /* synthetic */ int textHeight;
    private /* synthetic */ List<String> lines;
    private final /* synthetic */ ITextComponent reason;
    private final /* synthetic */ String title;
    
    public DisconnectedRealmsScreen(final RealmsScreen llllllllllllllIlIllllIlIlllIlIII, final String llllllllllllllIlIllllIlIlllIIIll, final ITextComponent llllllllllllllIlIllllIlIlllIIllI) {
        this.parent = llllllllllllllIlIllllIlIlllIlIII;
        this.title = RealmsScreen.getLocalizedString(llllllllllllllIlIllllIlIlllIIIll);
        this.reason = llllllllllllllIlIllllIlIlllIIllI;
    }
    
    @Override
    public void render(final int llllllllllllllIlIllllIlIllIIIIll, final int llllllllllllllIlIllllIlIllIIlIII, final float llllllllllllllIlIllllIlIllIIIIIl) {
        this.renderBackground();
        this.drawCenteredString(this.title, this.width() / 2, this.height() / 2 - this.textHeight / 2 - this.fontLineHeight() * 2, 11184810);
        int llllllllllllllIlIllllIlIllIIIllI = this.height() / 2 - this.textHeight / 2;
        if (this.lines != null) {
            for (final String llllllllllllllIlIllllIlIllIIIlIl : this.lines) {
                this.drawCenteredString(llllllllllllllIlIllllIlIllIIIlIl, this.width() / 2, llllllllllllllIlIllllIlIllIIIllI, 16777215);
                llllllllllllllIlIllllIlIllIIIllI += this.fontLineHeight();
            }
        }
        super.render(llllllllllllllIlIllllIlIllIIIIll, llllllllllllllIlIllllIlIllIIlIII, llllllllllllllIlIllllIlIllIIIIIl);
    }
    
    @Override
    public void buttonClicked(final RealmsButton llllllllllllllIlIllllIlIllIlIlII) {
        if (llllllllllllllIlIllllIlIllIlIlII.id() == 0) {
            Realms.setScreen(this.parent);
        }
    }
    
    @Override
    public void keyPressed(final char llllllllllllllIlIllllIlIllIllIll, final int llllllllllllllIlIllllIlIllIllIII) {
        if (llllllllllllllIlIllllIlIllIllIII == 1) {
            Realms.setScreen(this.parent);
        }
    }
    
    @Override
    public void init() {
        Realms.setConnectedToRealms(false);
        Realms.clearResourcePack();
        this.buttonsClear();
        this.lines = this.fontSplit(this.reason.getFormattedText(), this.width() - 50);
        this.textHeight = this.lines.size() * this.fontLineHeight();
        this.buttonsAdd(RealmsScreen.newButton(0, this.width() / 2 - 100, this.height() / 2 + this.textHeight / 2 + this.fontLineHeight(), RealmsScreen.getLocalizedString("gui.back")));
    }
}
