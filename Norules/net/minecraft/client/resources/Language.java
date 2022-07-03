package net.minecraft.client.resources;

public class Language implements Comparable<Language>
{
    private final /* synthetic */ String languageCode;
    private final /* synthetic */ String name;
    private final /* synthetic */ String region;
    private final /* synthetic */ boolean bidirectional;
    
    public String getLanguageCode() {
        return this.languageCode;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlllIlIllIllIIlIl) {
        return this == lllllllllllllllIlllIlIllIllIIlIl || (lllllllllllllllIlllIlIllIllIIlIl instanceof Language && this.languageCode.equals(((Language)lllllllllllllllIlllIlIllIllIIlIl).languageCode));
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", this.name, this.region);
    }
    
    public boolean isBidirectional() {
        return this.bidirectional;
    }
    
    public Language(final String lllllllllllllllIlllIlIlllIIIIlIl, final String lllllllllllllllIlllIlIllIlllllIl, final String lllllllllllllllIlllIlIllIlllllII, final boolean lllllllllllllllIlllIlIlllIIIIIII) {
        this.languageCode = lllllllllllllllIlllIlIlllIIIIlIl;
        this.region = lllllllllllllllIlllIlIllIlllllIl;
        this.name = lllllllllllllllIlllIlIllIlllllII;
        this.bidirectional = lllllllllllllllIlllIlIlllIIIIIII;
    }
    
    @Override
    public int hashCode() {
        return this.languageCode.hashCode();
    }
    
    @Override
    public int compareTo(final Language lllllllllllllllIlllIlIllIlIlIIIl) {
        return this.languageCode.compareTo(lllllllllllllllIlllIlIllIlIlIIIl.languageCode);
    }
}
