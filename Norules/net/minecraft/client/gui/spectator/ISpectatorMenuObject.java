package net.minecraft.client.gui.spectator;

import net.minecraft.util.text.*;

public interface ISpectatorMenuObject
{
    void selectItem(final SpectatorMenu p0);
    
    void renderIcon(final float p0, final int p1);
    
    boolean isEnabled();
    
    ITextComponent getSpectatorName();
}
