package net.minecraft.client.resources.data;

import net.minecraft.util.text.*;

public class PackMetadataSection implements IMetadataSection
{
    private final /* synthetic */ ITextComponent packDescription;
    private final /* synthetic */ int packFormat;
    
    public ITextComponent getPackDescription() {
        return this.packDescription;
    }
    
    public int getPackFormat() {
        return this.packFormat;
    }
    
    public PackMetadataSection(final ITextComponent lllllllllllllIIIIIIIIIllIlIIIlll, final int lllllllllllllIIIIIIIIIllIlIIIIll) {
        this.packDescription = lllllllllllllIIIIIIIIIllIlIIIlll;
        this.packFormat = lllllllllllllIIIIIIIIIllIlIIIIll;
    }
}
