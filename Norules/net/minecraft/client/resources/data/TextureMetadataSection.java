package net.minecraft.client.resources.data;

public class TextureMetadataSection implements IMetadataSection
{
    private final /* synthetic */ boolean textureClamp;
    private final /* synthetic */ boolean textureBlur;
    
    public boolean getTextureBlur() {
        return this.textureBlur;
    }
    
    public TextureMetadataSection(final boolean llllllllllllllIIIllIIIlIIIIllIIl, final boolean llllllllllllllIIIllIIIlIIIIllIII) {
        this.textureBlur = llllllllllllllIIIllIIIlIIIIllIIl;
        this.textureClamp = llllllllllllllIIIllIIIlIIIIllIII;
    }
    
    public boolean getTextureClamp() {
        return this.textureClamp;
    }
}
