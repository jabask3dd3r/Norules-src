package org.yaml.snakeyaml;

public class LoaderOptions
{
    private /* synthetic */ int maxAliasesForCollections;
    private /* synthetic */ boolean wrappedToRootException;
    private /* synthetic */ boolean allowRecursiveKeys;
    private /* synthetic */ boolean allowDuplicateKeys;
    
    public void setMaxAliasesForCollections(final int lllllllllllllllIlllIlllIIIIIIIll) {
        this.maxAliasesForCollections = lllllllllllllllIlllIlllIIIIIIIll;
    }
    
    public int getMaxAliasesForCollections() {
        return this.maxAliasesForCollections;
    }
    
    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }
    
    public boolean getAllowRecursiveKeys() {
        return this.allowRecursiveKeys;
    }
    
    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }
    
    public void setAllowRecursiveKeys(final boolean lllllllllllllllIlllIllIlllllIlll) {
        this.allowRecursiveKeys = lllllllllllllllIlllIllIlllllIlll;
    }
    
    public LoaderOptions() {
        this.allowDuplicateKeys = true;
        this.wrappedToRootException = false;
        this.maxAliasesForCollections = 50;
        this.allowRecursiveKeys = false;
    }
    
    public void setAllowDuplicateKeys(final boolean lllllllllllllllIlllIlllIIIIlllII) {
        this.allowDuplicateKeys = lllllllllllllllIlllIlllIIIIlllII;
    }
    
    public void setWrappedToRootException(final boolean lllllllllllllllIlllIlllIIIIlIlIl) {
        this.wrappedToRootException = lllllllllllllllIlllIlllIIIIlIlIl;
    }
}
