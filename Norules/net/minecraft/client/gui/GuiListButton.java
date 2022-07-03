package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.resources.*;

public class GuiListButton extends GuiButton
{
    private final /* synthetic */ String localizationStr;
    private final /* synthetic */ GuiPageButtonList.GuiResponder guiResponder;
    private /* synthetic */ boolean value;
    
    public GuiListButton(final GuiPageButtonList.GuiResponder llllllllllllllIIlllIlIlllIlIIIll, final int llllllllllllllIIlllIlIlllIlIIIlI, final int llllllllllllllIIlllIlIlllIlIIIIl, final int llllllllllllllIIlllIlIlllIlIIIII, final String llllllllllllllIIlllIlIlllIlIIllI, final boolean llllllllllllllIIlllIlIlllIlIIlIl) {
        super(llllllllllllllIIlllIlIlllIlIIIlI, llllllllllllllIIlllIlIlllIlIIIIl, llllllllllllllIIlllIlIlllIlIIIII, 150, 20, "");
        this.localizationStr = llllllllllllllIIlllIlIlllIlIIllI;
        this.value = llllllllllllllIIlllIlIlllIlIIlIl;
        this.displayString = this.buildDisplayString();
        this.guiResponder = llllllllllllllIIlllIlIlllIlIIIll;
    }
    
    @Override
    public boolean mousePressed(final Minecraft llllllllllllllIIlllIlIlllIIIlIll, final int llllllllllllllIIlllIlIlllIIIlllI, final int llllllllllllllIIlllIlIlllIIIlIIl) {
        if (super.mousePressed(llllllllllllllIIlllIlIlllIIIlIll, llllllllllllllIIlllIlIlllIIIlllI, llllllllllllllIIlllIlIlllIIIlIIl)) {
            this.value = !this.value;
            this.displayString = this.buildDisplayString();
            this.guiResponder.setEntryValue(this.id, this.value);
            return true;
        }
        return false;
    }
    
    private String buildDisplayString() {
        return String.valueOf(new StringBuilder(String.valueOf(I18n.format(this.localizationStr, new Object[0]))).append(": ").append(I18n.format(this.value ? "gui.yes" : "gui.no", new Object[0])));
    }
    
    public void setValue(final boolean llllllllllllllIIlllIlIlllIIlIlIl) {
        this.value = llllllllllllllIIlllIlIlllIIlIlIl;
        this.displayString = this.buildDisplayString();
        this.guiResponder.setEntryValue(this.id, llllllllllllllIIlllIlIlllIIlIlIl);
    }
}
