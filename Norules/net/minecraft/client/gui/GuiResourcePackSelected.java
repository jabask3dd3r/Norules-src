package net.minecraft.client.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.resources.*;

public class GuiResourcePackSelected extends GuiResourcePackList
{
    public GuiResourcePackSelected(final Minecraft lllllllllllllIIlIlIIIlIIlIIIIlll, final int lllllllllllllIIlIlIIIlIIlIIIIIIl, final int lllllllllllllIIlIlIIIlIIlIIIIlIl, final List<ResourcePackListEntry> lllllllllllllIIlIlIIIlIIIlllllll) {
        super(lllllllllllllIIlIlIIIlIIlIIIIlll, lllllllllllllIIlIlIIIlIIlIIIIIIl, lllllllllllllIIlIlIIIlIIlIIIIlIl, lllllllllllllIIlIlIIIlIIIlllllll);
    }
    
    @Override
    protected String getListHeader() {
        return I18n.format("resourcePack.selected.title", new Object[0]);
    }
}
