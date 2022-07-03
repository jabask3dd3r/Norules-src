package net.minecraft.client.gui.spectator;

import java.util.*;
import net.minecraft.util.text.*;
import com.google.common.collect.*;
import net.minecraft.client.gui.spectator.categories.*;

public class BaseSpectatorGroup implements ISpectatorMenuView
{
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    
    @Override
    public ITextComponent getPrompt() {
        return new TextComponentTranslation("spectatorMenu.root.prompt", new Object[0]);
    }
    
    @Override
    public List<ISpectatorMenuObject> getItems() {
        return this.items;
    }
    
    public BaseSpectatorGroup() {
        this.items = (List<ISpectatorMenuObject>)Lists.newArrayList();
        this.items.add(new TeleportToPlayer());
        this.items.add(new TeleportToTeam());
    }
}
