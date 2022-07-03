package com.viaversion.viaversion.api.connection;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;

public interface ProtocolInfo
{
    void setPipeline(final ProtocolPipeline p0);
    
    UserConnection getUser();
    
    void setState(final State p0);
    
    void setUsername(final String p0);
    
    int getServerProtocolVersion();
    
    ProtocolPipeline getPipeline();
    
    int getProtocolVersion();
    
    void setServerProtocolVersion(final int p0);
    
    State getState();
    
    UUID getUuid();
    
    void setUuid(final UUID p0);
    
    String getUsername();
    
    void setProtocolVersion(final int p0);
}
