package org.yaml.snakeyaml.util;

public class PlatformFeatureDetector
{
    private /* synthetic */ Boolean isRunningOnAndroid;
    
    public boolean isRunningOnAndroid() {
        if (this.isRunningOnAndroid == null) {
            final String lllllllllllllIllllIlllllIIlllIlI = System.getProperty("java.runtime.name");
            this.isRunningOnAndroid = (lllllllllllllIllllIlllllIIlllIlI != null && lllllllllllllIllllIlllllIIlllIlI.startsWith("Android Runtime"));
        }
        return this.isRunningOnAndroid;
    }
    
    public PlatformFeatureDetector() {
        this.isRunningOnAndroid = null;
    }
}
