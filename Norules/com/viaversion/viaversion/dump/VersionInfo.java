package com.viaversion.viaversion.dump;

import java.util.*;

public class VersionInfo
{
    private final /* synthetic */ String pluginVersion;
    private final /* synthetic */ String implementationVersion;
    private final /* synthetic */ String operatingSystem;
    private final /* synthetic */ int serverProtocol;
    private final /* synthetic */ String platformName;
    private final /* synthetic */ String javaVersion;
    private final /* synthetic */ Set<String> subPlatforms;
    private final /* synthetic */ String platformVersion;
    private final /* synthetic */ Set<Integer> enabledProtocols;
    
    public String getJavaVersion() {
        return this.javaVersion;
    }
    
    public String getPlatformName() {
        return this.platformName;
    }
    
    public String getOperatingSystem() {
        return this.operatingSystem;
    }
    
    public Set<String> getSubPlatforms() {
        return this.subPlatforms;
    }
    
    public String getPlatformVersion() {
        return this.platformVersion;
    }
    
    public Set<Integer> getEnabledProtocols() {
        return this.enabledProtocols;
    }
    
    public String getImplementationVersion() {
        return this.implementationVersion;
    }
    
    public String getPluginVersion() {
        return this.pluginVersion;
    }
    
    public VersionInfo(final String lllllllllllllllIlIlllIIlIllllllI, final String lllllllllllllllIlIlllIIlIlllIIll, final int lllllllllllllllIlIlllIIlIlllIIlI, final Set<Integer> lllllllllllllllIlIlllIIlIllllIll, final String lllllllllllllllIlIlllIIlIlllIIII, final String lllllllllllllllIlIlllIIlIllllIIl, final String lllllllllllllllIlIlllIIlIllllIII, final String lllllllllllllllIlIlllIIlIlllIlll, final Set<String> lllllllllllllllIlIlllIIlIllIllII) {
        this.javaVersion = lllllllllllllllIlIlllIIlIllllllI;
        this.operatingSystem = lllllllllllllllIlIlllIIlIlllIIll;
        this.serverProtocol = lllllllllllllllIlIlllIIlIlllIIlI;
        this.enabledProtocols = lllllllllllllllIlIlllIIlIllllIll;
        this.platformName = lllllllllllllllIlIlllIIlIlllIIII;
        this.platformVersion = lllllllllllllllIlIlllIIlIllllIIl;
        this.pluginVersion = lllllllllllllllIlIlllIIlIllllIII;
        this.implementationVersion = lllllllllllllllIlIlllIIlIlllIlll;
        this.subPlatforms = lllllllllllllllIlIlllIIlIllIllII;
    }
    
    public int getServerProtocol() {
        return this.serverProtocol;
    }
}
