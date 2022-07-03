package net.minecraft.client.resources;

import net.minecraft.client.gui.*;

public class ResourcePackListEntryFound extends ResourcePackListEntry
{
    private final /* synthetic */ ResourcePackRepository.Entry resourcePackEntry;
    
    public ResourcePackRepository.Entry getResourcePackEntry() {
        return this.resourcePackEntry;
    }
    
    @Override
    protected int getResourcePackFormat() {
        return this.resourcePackEntry.getPackFormat();
    }
    
    @Override
    protected String getResourcePackDescription() {
        return this.resourcePackEntry.getTexturePackDescription();
    }
    
    @Override
    protected String getResourcePackName() {
        return this.resourcePackEntry.getResourcePackName();
    }
    
    public ResourcePackListEntryFound(final GuiScreenResourcePacks llllllllllllllIIllIIllllIIllIIII, final ResourcePackRepository.Entry llllllllllllllIIllIIllllIIlIllII) {
        super(llllllllllllllIIllIIllllIIllIIII);
        this.resourcePackEntry = llllllllllllllIIllIIllllIIlIllII;
    }
    
    @Override
    protected void bindResourcePackIcon() {
        this.resourcePackEntry.bindTexturePackIcon(this.mc.getTextureManager());
    }
}
