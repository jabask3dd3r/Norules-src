package com.viaversion.viaversion.dump;

import com.viaversion.viaversion.libs.gson.*;
import java.util.*;

public class DumpTemplate
{
    private final /* synthetic */ JsonObject injectionDump;
    private final /* synthetic */ JsonObject platformDump;
    private final /* synthetic */ VersionInfo versionInfo;
    private final /* synthetic */ Map<String, Object> configuration;
    
    public DumpTemplate(final VersionInfo llllllllllllllIlIIlllIllIIIllIII, final Map<String, Object> llllllllllllllIlIIlllIllIIIlIlll, final JsonObject llllllllllllllIlIIlllIllIIIllIll, final JsonObject llllllllllllllIlIIlllIllIIIllIlI) {
        this.versionInfo = llllllllllllllIlIIlllIllIIIllIII;
        this.configuration = llllllllllllllIlIIlllIllIIIlIlll;
        this.platformDump = llllllllllllllIlIIlllIllIIIllIll;
        this.injectionDump = llllllllllllllIlIIlllIllIIIllIlI;
    }
    
    public Map<String, Object> getConfiguration() {
        return this.configuration;
    }
    
    public VersionInfo getVersionInfo() {
        return this.versionInfo;
    }
    
    public JsonObject getInjectionDump() {
        return this.injectionDump;
    }
    
    public JsonObject getPlatformDump() {
        return this.platformDump;
    }
}
