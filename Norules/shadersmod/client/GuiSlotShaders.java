package shadersmod.client;

import net.minecraft.client.gui.*;
import java.util.*;
import optifine.*;

class GuiSlotShaders extends GuiSlot
{
    private /* synthetic */ long lastClickedCached;
    private /* synthetic */ ArrayList shaderslist;
    private /* synthetic */ int selectedIndex;
    final /* synthetic */ GuiShaders shadersGui;
    
    @Override
    protected void elementClicked(final int lllllllllllllllllllIlIIIlllIllll, final boolean lllllllllllllllllllIlIIIlllIlllI, final int lllllllllllllllllllIlIIIlllIllIl, final int lllllllllllllllllllIlIIIlllIllII) {
        if (lllllllllllllllllllIlIIIlllIllll != this.selectedIndex || this.lastClicked != this.lastClickedCached) {
            this.selectedIndex = lllllllllllllllllllIlIIIlllIllll;
            this.lastClickedCached = this.lastClicked;
            Shaders.setShaderPack(this.shaderslist.get(lllllllllllllllllllIlIIIlllIllll));
            Shaders.uninit();
            this.shadersGui.updateButtons();
        }
    }
    
    public void updateList() {
        this.shaderslist = Shaders.listOfShaders();
        this.selectedIndex = 0;
        for (int lllllllllllllllllllIlIIIlllllIlI = 0, lllllllllllllllllllIlIIIlllllIIl = this.shaderslist.size(); lllllllllllllllllllIlIIIlllllIlI < lllllllllllllllllllIlIIIlllllIIl; ++lllllllllllllllllllIlIIIlllllIlI) {
            if (this.shaderslist.get(lllllllllllllllllllIlIIIlllllIlI).equals(Shaders.currentshadername)) {
                this.selectedIndex = lllllllllllllllllllIlIIIlllllIlI;
                break;
            }
        }
    }
    
    @Override
    protected int getContentHeight() {
        return this.getSize() * 18;
    }
    
    public int getSelectedIndex() {
        return this.selectedIndex;
    }
    
    @Override
    protected int getSize() {
        return this.shaderslist.size();
    }
    
    @Override
    protected boolean isSelected(final int lllllllllllllllllllIlIIIlllIIllI) {
        return lllllllllllllllllllIlIIIlllIIllI == this.selectedIndex;
    }
    
    @Override
    protected void drawBackground() {
    }
    
    public GuiSlotShaders(final GuiShaders lllllllllllllllllllIlIIlIIIlIIlI, final int lllllllllllllllllllIlIIlIIIlIIIl, final int lllllllllllllllllllIlIIlIIIlIIII, final int lllllllllllllllllllIlIIlIIIIllll, final int lllllllllllllllllllIlIIlIIIIIlIl, final int lllllllllllllllllllIlIIlIIIIllIl) {
        super(lllllllllllllllllllIlIIlIIIlIIlI.getMc(), lllllllllllllllllllIlIIlIIIlIIIl, lllllllllllllllllllIlIIlIIIlIIII, lllllllllllllllllllIlIIlIIIIllll, lllllllllllllllllllIlIIlIIIIIlIl, lllllllllllllllllllIlIIlIIIIllIl);
        this.lastClickedCached = 0L;
        this.shadersGui = lllllllllllllllllllIlIIlIIIlIIlI;
        this.updateList();
        this.amountScrolled = 0.0f;
        final int lllllllllllllllllllIlIIlIIIIllII = this.selectedIndex * lllllllllllllllllllIlIIlIIIIllIl;
        final int lllllllllllllllllllIlIIlIIIIlIll = (lllllllllllllllllllIlIIlIIIIIlIl - lllllllllllllllllllIlIIlIIIIllll) / 2;
        if (lllllllllllllllllllIlIIlIIIIllII > lllllllllllllllllllIlIIlIIIIlIll) {
            this.scrollBy(lllllllllllllllllllIlIIlIIIIllII - lllllllllllllllllllIlIIlIIIIlIll);
        }
    }
    
    @Override
    protected int getScrollBarX() {
        return this.width - 6;
    }
    
    @Override
    protected void func_192637_a(final int lllllllllllllllllllIlIIIllIIlllI, final int lllllllllllllllllllIlIIIllIlIllI, final int lllllllllllllllllllIlIIIllIIllIl, final int lllllllllllllllllllIlIIIllIlIlII, final int lllllllllllllllllllIlIIIllIlIIll, final int lllllllllllllllllllIlIIIllIlIIlI, final float lllllllllllllllllllIlIIIllIlIIIl) {
        String lllllllllllllllllllIlIIIllIlIIII = this.shaderslist.get(lllllllllllllllllllIlIIIllIIlllI);
        if (lllllllllllllllllllIlIIIllIlIIII.equals(Shaders.packNameNone)) {
            lllllllllllllllllllIlIIIllIlIIII = Lang.get("of.options.shaders.packNone");
        }
        else if (lllllllllllllllllllIlIIIllIlIIII.equals(Shaders.packNameDefault)) {
            lllllllllllllllllllIlIIIllIlIIII = Lang.get("of.options.shaders.packDefault");
        }
        this.shadersGui.drawCenteredString(lllllllllllllllllllIlIIIllIlIIII, this.width / 2, lllllllllllllllllllIlIIIllIIllIl + 1, 16777215);
    }
    
    @Override
    public int getListWidth() {
        return this.width - 20;
    }
}
