package com.viaversion.viaversion.api.protocol;

import java.util.*;

public interface ProtocolPipeline extends SimpleProtocol
{
    List<Protocol> pipes();
    
    boolean contains(final Class<? extends Protocol> p0);
    
     <P extends Protocol> P getProtocol(final Class<P> p0);
    
    boolean hasNonBaseProtocols();
    
    void add(final Protocol p0);
    
    void cleanPipes();
    
    void add(final Collection<Protocol> p0);
}
