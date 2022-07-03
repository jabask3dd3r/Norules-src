package net.minecraft.client.resources.data;

public class FontMetadataSection implements IMetadataSection
{
    private final /* synthetic */ float[] charWidths;
    private final /* synthetic */ float[] charLefts;
    private final /* synthetic */ float[] charSpacings;
    
    public FontMetadataSection(final float[] lllllllllllllIIIlIIlllIlIIIIllII, final float[] lllllllllllllIIIlIIlllIlIIIIllll, final float[] lllllllllllllIIIlIIlllIlIIIIlllI) {
        this.charWidths = lllllllllllllIIIlIIlllIlIIIIllII;
        this.charLefts = lllllllllllllIIIlIIlllIlIIIIllll;
        this.charSpacings = lllllllllllllIIIlIIlllIlIIIIlllI;
    }
}
