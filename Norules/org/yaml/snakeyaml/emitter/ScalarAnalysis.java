package org.yaml.snakeyaml.emitter;

public final class ScalarAnalysis
{
    private /* synthetic */ boolean allowBlock;
    private /* synthetic */ boolean allowBlockPlain;
    private /* synthetic */ boolean empty;
    private /* synthetic */ boolean allowFlowPlain;
    private /* synthetic */ boolean allowSingleQuoted;
    private /* synthetic */ String scalar;
    private /* synthetic */ boolean multiline;
    
    public boolean isEmpty() {
        return this.empty;
    }
    
    public ScalarAnalysis(final String lllllllllllllllIIIIllIlllllIIllI, final boolean lllllllllllllllIIIIllIlllllIllIl, final boolean lllllllllllllllIIIIllIlllllIllII, final boolean lllllllllllllllIIIIllIlllllIlIll, final boolean lllllllllllllllIIIIllIlllllIIIlI, final boolean lllllllllllllllIIIIllIlllllIIIIl, final boolean lllllllllllllllIIIIllIlllllIlIII) {
        this.scalar = lllllllllllllllIIIIllIlllllIIllI;
        this.empty = lllllllllllllllIIIIllIlllllIllIl;
        this.multiline = lllllllllllllllIIIIllIlllllIllII;
        this.allowFlowPlain = lllllllllllllllIIIIllIlllllIlIll;
        this.allowBlockPlain = lllllllllllllllIIIIllIlllllIIIlI;
        this.allowSingleQuoted = lllllllllllllllIIIIllIlllllIIIIl;
        this.allowBlock = lllllllllllllllIIIIllIlllllIlIII;
    }
    
    public boolean isAllowBlockPlain() {
        return this.allowBlockPlain;
    }
    
    public boolean isAllowSingleQuoted() {
        return this.allowSingleQuoted;
    }
    
    public boolean isAllowFlowPlain() {
        return this.allowFlowPlain;
    }
    
    public boolean isMultiline() {
        return this.multiline;
    }
    
    public boolean isAllowBlock() {
        return this.allowBlock;
    }
    
    public String getScalar() {
        return this.scalar;
    }
}
