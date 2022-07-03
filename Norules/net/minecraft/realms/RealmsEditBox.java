package net.minecraft.realms;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class RealmsEditBox
{
    private final /* synthetic */ GuiTextField editBox;
    
    public String getValue() {
        return this.editBox.getText();
    }
    
    public void tick() {
        this.editBox.updateCursorCounter();
    }
    
    public RealmsEditBox(final int lllllllllllllIIlllllIIllIIlIlIlI, final int lllllllllllllIIlllllIIllIIlIIIll, final int lllllllllllllIIlllllIIllIIlIIIlI, final int lllllllllllllIIlllllIIllIIlIIlll, final int lllllllllllllIIlllllIIllIIlIIIII) {
        this.editBox = new GuiTextField(lllllllllllllIIlllllIIllIIlIlIlI, Minecraft.getMinecraft().fontRendererObj, lllllllllllllIIlllllIIllIIlIIIll, lllllllllllllIIlllllIIllIIlIIIlI, lllllllllllllIIlllllIIllIIlIIlll, lllllllllllllIIlllllIIllIIlIIIII);
    }
    
    public boolean isFocused() {
        return this.editBox.isFocused();
    }
    
    public void render() {
        this.editBox.drawTextBox();
    }
    
    public void setValue(final String lllllllllllllIIlllllIIllIIIlIIII) {
        this.editBox.setText(lllllllllllllIIlllllIIllIIIlIIII);
    }
    
    public void mouseClicked(final int lllllllllllllIIlllllIIlIllllllII, final int lllllllllllllIIlllllIIlIllllIlll, final int lllllllllllllIIlllllIIlIlllllIlI) {
        this.editBox.mouseClicked(lllllllllllllIIlllllIIlIllllllII, lllllllllllllIIlllllIIlIllllIlll, lllllllllllllIIlllllIIlIlllllIlI);
    }
    
    public void setFocus(final boolean lllllllllllllIIlllllIIllIIIlIllI) {
        this.editBox.setFocused(lllllllllllllIIlllllIIllIIIlIllI);
    }
    
    public void setMaxLength(final int lllllllllllllIIlllllIIlIlllIllll) {
        this.editBox.setMaxStringLength(lllllllllllllIIlllllIIlIlllIllll);
    }
    
    public void keyPressed(final char lllllllllllllIIlllllIIllIIIIIllI, final int lllllllllllllIIlllllIIllIIIIlIII) {
        this.editBox.textboxKeyTyped(lllllllllllllIIlllllIIllIIIIIllI, lllllllllllllIIlllllIIllIIIIlIII);
    }
    
    public void setIsEditable(final boolean lllllllllllllIIlllllIIlIlllIlIIl) {
        this.editBox.setEnabled(lllllllllllllIIlllllIIlIlllIlIIl);
    }
}
