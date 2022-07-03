package com.viaversion.viaversion.dump;

import java.util.*;

public class PluginInfo
{
    private final /* synthetic */ String version;
    private final /* synthetic */ boolean enabled;
    private final /* synthetic */ String name;
    private final /* synthetic */ List<String> authors;
    private final /* synthetic */ String main;
    
    public String getVersion() {
        return this.version;
    }
    
    public String getMain() {
        return this.main;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public PluginInfo(final boolean lllllllllllllIIlIlllIllIIIllIIlI, final String lllllllllllllIIlIlllIllIIIllIIIl, final String lllllllllllllIIlIlllIllIIIlIlIlI, final String lllllllllllllIIlIlllIllIIIlIllll, final List<String> lllllllllllllIIlIlllIllIIIlIlllI) {
        this.enabled = lllllllllllllIIlIlllIllIIIllIIlI;
        this.name = lllllllllllllIIlIlllIllIIIllIIIl;
        this.version = lllllllllllllIIlIlllIllIIIlIlIlI;
        this.main = lllllllllllllIIlIlllIllIIIlIllll;
        this.authors = lllllllllllllIIlIlllIllIIIlIlllI;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<String> getAuthors() {
        return this.authors;
    }
}
