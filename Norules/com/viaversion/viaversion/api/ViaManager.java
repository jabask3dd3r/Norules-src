package com.viaversion.viaversion.api;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.command.*;
import java.util.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.protocol.*;

public interface ViaManager
{
    ConnectionManager getConnectionManager();
    
    ViaVersionCommand getCommandHandler();
    
    Set<String> getSubPlatforms();
    
    ViaPlatformLoader getLoader();
    
    boolean isDebug();
    
    ViaInjector getInjector();
    
    void addEnableListener(final Runnable p0);
    
    ViaProviders getProviders();
    
    ViaPlatform<?> getPlatform();
    
    ProtocolManager getProtocolManager();
    
    void setDebug(final boolean p0);
}
