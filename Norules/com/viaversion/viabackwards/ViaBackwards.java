package com.viaversion.viabackwards;

import com.viaversion.viabackwards.api.*;
import com.google.common.base.*;

public class ViaBackwards
{
    private static /* synthetic */ ViaBackwardsPlatform platform;
    private static /* synthetic */ ViaBackwardsConfig config;
    
    public static ViaBackwardsPlatform getPlatform() {
        return ViaBackwards.platform;
    }
    
    public static ViaBackwardsConfig getConfig() {
        return ViaBackwards.config;
    }
    
    public static void init(final ViaBackwardsPlatform lllllllllllllIllllllllIlIIIlIIll, final ViaBackwardsConfig lllllllllllllIllllllllIlIIIlIIII) {
        Preconditions.checkArgument(lllllllllllllIllllllllIlIIIlIIll != null, (Object)"ViaBackwards is already initialized");
        ViaBackwards.platform = lllllllllllllIllllllllIlIIIlIIll;
        ViaBackwards.config = lllllllllllllIllllllllIlIIIlIIII;
    }
}
