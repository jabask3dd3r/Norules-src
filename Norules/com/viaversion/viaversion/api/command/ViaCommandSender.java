package com.viaversion.viaversion.api.command;

import java.util.*;

public interface ViaCommandSender
{
    UUID getUUID();
    
    boolean hasPermission(final String p0);
    
    void sendMessage(final String p0);
    
    String getName();
}
