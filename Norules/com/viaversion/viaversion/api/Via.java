package com.viaversion.viaversion.api;

import com.google.common.base.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.configuration.*;

public final class Via
{
    private static /* synthetic */ ViaManager manager;
    
    public static void init(final ViaManager lllllllllllllllIIIIIIIlIIIIIIIlI) {
        Preconditions.checkArgument(Via.manager == null, (Object)"ViaManager is already set");
        Via.manager = lllllllllllllllIIIIIIIlIIIIIIIlI;
    }
    
    public static ViaPlatform getPlatform() {
        return manager().getPlatform();
    }
    
    public static ViaAPI getAPI() {
        return manager().getPlatform().getApi();
    }
    
    private static ViaManager manager() {
        Preconditions.checkArgument(Via.manager != null, (Object)"ViaVersion has not loaded the platform yet");
        return Via.manager;
    }
    
    public static ViaVersionConfig getConfig() {
        return manager().getPlatform().getConf();
    }
    
    public static ViaManager getManager() {
        return manager();
    }
}
