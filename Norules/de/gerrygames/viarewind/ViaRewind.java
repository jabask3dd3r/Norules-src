package de.gerrygames.viarewind;

import de.gerrygames.viarewind.api.*;

public class ViaRewind
{
    private static /* synthetic */ ViaRewindConfig config;
    private static /* synthetic */ ViaRewindPlatform platform;
    
    public static ViaRewindPlatform getPlatform() {
        return ViaRewind.platform;
    }
    
    public static void init(final ViaRewindPlatform lllllllllllllIlIllIllIllllIlIlII, final ViaRewindConfig lllllllllllllIlIllIllIllllIlIIll) {
        ViaRewind.platform = lllllllllllllIlIllIllIllllIlIlII;
        ViaRewind.config = lllllllllllllIlIllIllIllllIlIIll;
    }
    
    public static ViaRewindConfig getConfig() {
        return ViaRewind.config;
    }
}
