package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.error.*;

final class SimpleKey
{
    private /* synthetic */ int tokenNumber;
    private /* synthetic */ int index;
    private /* synthetic */ int column;
    private /* synthetic */ boolean required;
    private /* synthetic */ Mark mark;
    private /* synthetic */ int line;
    
    public Mark getMark() {
        return this.mark;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("SimpleKey - tokenNumber=").append(this.tokenNumber).append(" required=").append(this.required).append(" index=").append(this.index).append(" line=").append(this.line).append(" column=").append(this.column));
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public SimpleKey(final int lllllllllllllIIllIIlllllllIlllll, final boolean lllllllllllllIIllIIllllllllIIlIl, final int lllllllllllllIIllIIllllllllIIlII, final int lllllllllllllIIllIIlllllllIlllII, final int lllllllllllllIIllIIllllllllIIIlI, final Mark lllllllllllllIIllIIllllllllIIIIl) {
        this.tokenNumber = lllllllllllllIIllIIlllllllIlllll;
        this.required = lllllllllllllIIllIIllllllllIIlIl;
        this.index = lllllllllllllIIllIIllllllllIIlII;
        this.line = lllllllllllllIIllIIlllllllIlllII;
        this.column = lllllllllllllIIllIIllllllllIIIlI;
        this.mark = lllllllllllllIIllIIllllllllIIIIl;
    }
    
    public int getLine() {
        return this.line;
    }
    
    public boolean isRequired() {
        return this.required;
    }
    
    public int getColumn() {
        return this.column;
    }
    
    public int getTokenNumber() {
        return this.tokenNumber;
    }
}
