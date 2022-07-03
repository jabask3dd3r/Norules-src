package org.yaml.snakeyaml.reader;

import org.yaml.snakeyaml.error.*;

public class ReaderException extends YAMLException
{
    private final /* synthetic */ int codePoint;
    private final /* synthetic */ int position;
    private final /* synthetic */ String name;
    
    public String getName() {
        return this.name;
    }
    
    public ReaderException(final String lllllllllllllllIIIIIIIlIllllIllI, final int lllllllllllllllIIIIIIIlIllllIlIl, final int lllllllllllllllIIIIIIIlIlllllIIl, final String lllllllllllllllIIIIIIIlIlllllIII) {
        super(lllllllllllllllIIIIIIIlIlllllIII);
        this.name = lllllllllllllllIIIIIIIlIllllIllI;
        this.codePoint = lllllllllllllllIIIIIIIlIlllllIIl;
        this.position = lllllllllllllllIIIIIIIlIllllIlIl;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    @Override
    public String toString() {
        final String lllllllllllllllIIIIIIIlIlllIIllI = new String(Character.toChars(this.codePoint));
        return String.valueOf(new StringBuilder().append("unacceptable code point '").append(lllllllllllllllIIIIIIIlIlllIIllI).append("' (0x").append(Integer.toHexString(this.codePoint).toUpperCase()).append(") ").append(this.getMessage()).append("\nin \"").append(this.name).append("\", position ").append(this.position));
    }
    
    public int getCodePoint() {
        return this.codePoint;
    }
}
