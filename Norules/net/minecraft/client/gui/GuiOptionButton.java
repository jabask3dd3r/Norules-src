package net.minecraft.client.gui;

import net.minecraft.client.settings.*;

public class GuiOptionButton extends GuiButton
{
    private final /* synthetic */ GameSettings.Options enumOptions;
    
    public GameSettings.Options returnEnumOptions() {
        return this.enumOptions;
    }
    
    public GuiOptionButton(final int lllllllllllllIlIIIlIIIlIIlIIIIII, final int lllllllllllllIlIIIlIIIlIIIlllIIl, final int lllllllllllllIlIIIlIIIlIIIlllllI, final GameSettings.Options lllllllllllllIlIIIlIIIlIIIllIlll, final String lllllllllllllIlIIIlIIIlIIIllIllI) {
        super(lllllllllllllIlIIIlIIIlIIlIIIIII, lllllllllllllIlIIIlIIIlIIIlllIIl, lllllllllllllIlIIIlIIIlIIIlllllI, 150, 20, lllllllllllllIlIIIlIIIlIIIllIllI);
        this.enumOptions = lllllllllllllIlIIIlIIIlIIIllIlll;
    }
    
    public GuiOptionButton(final int lllllllllllllIlIIIlIIIlIIlIIlIll, final int lllllllllllllIlIIIlIIIlIIlIIllll, final int lllllllllllllIlIIIlIIIlIIlIIlIIl, final String lllllllllllllIlIIIlIIIlIIlIIlIII) {
        this(lllllllllllllIlIIIlIIIlIIlIIlIll, lllllllllllllIlIIIlIIIlIIlIIllll, lllllllllllllIlIIIlIIIlIIlIIlIIl, null, lllllllllllllIlIIIlIIIlIIlIIlIII);
    }
}
