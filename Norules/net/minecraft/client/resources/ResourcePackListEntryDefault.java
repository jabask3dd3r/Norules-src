package net.minecraft.client.resources;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;

public class ResourcePackListEntryDefault extends ResourcePackListEntryServer
{
    @Override
    public boolean isServerPack() {
        return false;
    }
    
    @Override
    protected String getResourcePackName() {
        return "Default";
    }
    
    public ResourcePackListEntryDefault(final GuiScreenResourcePacks lllllllllllllIllIIlIllIlllIllIlI) {
        super(lllllllllllllIllIIlIllIlllIllIlI, Minecraft.getMinecraft().getResourcePackRepository().rprDefaultResourcePack);
    }
}
