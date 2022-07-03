package net.minecraft.client.gui.spectator;

import net.minecraft.util.text.*;
import java.util.*;

public interface ISpectatorMenuView
{
    ITextComponent getPrompt();
    
    List<ISpectatorMenuObject> getItems();
}
