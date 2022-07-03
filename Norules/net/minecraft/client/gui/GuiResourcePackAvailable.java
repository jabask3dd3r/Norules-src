package net.minecraft.client.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.resources.*;

public class GuiResourcePackAvailable extends GuiResourcePackList
{
    public GuiResourcePackAvailable(final Minecraft llllllllllllllIlIlllIlIllIlIIlIl, final int llllllllllllllIlIlllIlIllIlIIlII, final int llllllllllllllIlIlllIlIllIIllllI, final List<ResourcePackListEntry> llllllllllllllIlIlllIlIllIIlllIl) {
        super(llllllllllllllIlIlllIlIllIlIIlIl, llllllllllllllIlIlllIlIllIlIIlII, llllllllllllllIlIlllIlIllIIllllI, llllllllllllllIlIlllIlIllIIlllIl);
    }
    
    @Override
    protected String getListHeader() {
        return I18n.format("resourcePack.available.title", new Object[0]);
    }
}
