package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.version.*;

public class ProtocolInfoImpl implements ProtocolInfo
{
    private /* synthetic */ int serverProtocolVersion;
    private /* synthetic */ String username;
    private final /* synthetic */ UserConnection connection;
    private /* synthetic */ ProtocolPipeline pipeline;
    private /* synthetic */ State state;
    private /* synthetic */ int protocolVersion;
    private /* synthetic */ UUID uuid;
    
    @Override
    public void setUsername(final String llllllllllllllllllIIlllIIlIIllIl) {
        this.username = llllllllllllllllllIIlllIIlIIllIl;
    }
    
    @Override
    public void setProtocolVersion(final int llllllllllllllllllIIlllIIllIIIIl) {
        final ProtocolVersion llllllllllllllllllIIlllIIllIIIll = ProtocolVersion.getProtocol(llllllllllllllllllIIlllIIllIIIIl);
        this.protocolVersion = llllllllllllllllllIIlllIIllIIIll.getVersion();
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("ProtocolInfo{state=").append(this.state).append(", protocolVersion=").append(this.protocolVersion).append(", serverProtocolVersion=").append(this.serverProtocolVersion).append(", username='").append(this.username).append('\'').append(", uuid=").append(this.uuid).append('}'));
    }
    
    @Override
    public ProtocolPipeline getPipeline() {
        return this.pipeline;
    }
    
    @Override
    public void setPipeline(final ProtocolPipeline llllllllllllllllllIIlllIIIlllIll) {
        this.pipeline = llllllllllllllllllIIlllIIIlllIll;
    }
    
    public ProtocolInfoImpl(final UserConnection llllllllllllllllllIIlllIIlllIlll) {
        this.state = State.HANDSHAKE;
        this.protocolVersion = -1;
        this.serverProtocolVersion = -1;
        this.connection = llllllllllllllllllIIlllIIlllIlll;
    }
    
    @Override
    public void setServerProtocolVersion(final int llllllllllllllllllIIlllIIlIlIlIl) {
        final ProtocolVersion llllllllllllllllllIIlllIIlIlIlll = ProtocolVersion.getProtocol(llllllllllllllllllIIlllIIlIlIlIl);
        this.serverProtocolVersion = llllllllllllllllllIIlllIIlIlIlll.getVersion();
    }
    
    @Override
    public void setState(final State llllllllllllllllllIIlllIIllIlllI) {
        this.state = llllllllllllllllllIIlllIIllIlllI;
    }
    
    @Override
    public UUID getUuid() {
        return this.uuid;
    }
    
    @Override
    public State getState() {
        return this.state;
    }
    
    @Override
    public int getProtocolVersion() {
        return this.protocolVersion;
    }
    
    @Override
    public void setUuid(final UUID llllllllllllllllllIIlllIIlIIIlII) {
        this.uuid = llllllllllllllllllIIlllIIlIIIlII;
    }
    
    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public int getServerProtocolVersion() {
        return this.serverProtocolVersion;
    }
    
    @Override
    public UserConnection getUser() {
        return this.connection;
    }
}
