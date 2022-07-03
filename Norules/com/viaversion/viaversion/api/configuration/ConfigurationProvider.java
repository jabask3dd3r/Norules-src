package com.viaversion.viaversion.api.configuration;

import java.util.*;

public interface ConfigurationProvider
{
    void saveConfig();
    
    Map<String, Object> getValues();
    
    void set(final String p0, final Object p1);
    
    void reloadConfig();
}
