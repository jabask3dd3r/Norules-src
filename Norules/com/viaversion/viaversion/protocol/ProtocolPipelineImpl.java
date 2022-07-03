package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.logging.*;
import com.viaversion.viaversion.api.platform.*;
import java.util.*;

public class ProtocolPipelineImpl extends AbstractSimpleProtocol implements ProtocolPipeline
{
    private /* synthetic */ Set<Class<? extends Protocol>> protocolSet;
    private final /* synthetic */ UserConnection userConnection;
    private /* synthetic */ List<Protocol> protocolList;
    
    @Override
    public boolean contains(final Class<? extends Protocol> llllllllllllllllIIIIIIllIlllIIll) {
        return this.protocolSet.contains(llllllllllllllllIIIIIIllIlllIIll);
    }
    
    @Override
    public <P extends Protocol> P getProtocol(final Class<P> llllllllllllllllIIIIIIllIllIllII) {
        for (final Protocol llllllllllllllllIIIIIIllIllIlllI : this.protocolList) {
            if (llllllllllllllllIIIIIIllIllIlllI.getClass() == llllllllllllllllIIIIIIllIllIllII) {
                return (P)llllllllllllllllIIIIIIllIllIlllI;
            }
        }
        return null;
    }
    
    @Override
    public List<Protocol> pipes() {
        return this.protocolList;
    }
    
    @Override
    public void add(final Protocol llllllllllllllllIIIIIIlllIlllIll) {
        this.protocolList.add(llllllllllllllllIIIIIIlllIlllIll);
        this.protocolSet.add(llllllllllllllllIIIIIIlllIlllIll.getClass());
        llllllllllllllllIIIIIIlllIlllIll.init(this.userConnection);
        if (!llllllllllllllllIIIIIIlllIlllIll.isBaseProtocol()) {
            this.moveBaseProtocolsToTail();
        }
    }
    
    @Override
    public void init(final UserConnection llllllllllllllllIIIIIIlllIllllll) {
        throw new UnsupportedOperationException("ProtocolPipeline can only be initialized once");
    }
    
    @Override
    protected void registerPackets() {
        this.protocolList = new CopyOnWriteArrayList<Protocol>();
        this.protocolSet = (Set<Class<? extends Protocol>>)Sets.newSetFromMap((Map)new ConcurrentHashMap());
        final Protocol llllllllllllllllIIIIIIllllIIIIll = Via.getManager().getProtocolManager().getBaseProtocol();
        this.protocolList.add(llllllllllllllllIIIIIIllllIIIIll);
        this.protocolSet.add(llllllllllllllllIIIIIIllllIIIIll.getClass());
    }
    
    @Override
    public boolean hasNonBaseProtocols() {
        for (final Protocol llllllllllllllllIIIIIIllIllIIIIl : this.protocolList) {
            if (!llllllllllllllllIIIIIIllIllIIIIl.isBaseProtocol()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void add(final Collection<Protocol> llllllllllllllllIIIIIIlllIllIIII) {
        this.protocolList.addAll(llllllllllllllllIIIIIIlllIllIIII);
        for (final Protocol llllllllllllllllIIIIIIlllIllIlII : llllllllllllllllIIIIIIlllIllIIII) {
            llllllllllllllllIIIIIIlllIllIlII.init(this.userConnection);
            this.protocolSet.add(llllllllllllllllIIIIIIlllIllIlII.getClass());
        }
        this.moveBaseProtocolsToTail();
    }
    
    private void logPacket(final Direction llllllllllllllllIIIIIIlllIIIIIII, final State llllllllllllllllIIIIIIlllIIIlIII, final PacketWrapper llllllllllllllllIIIIIIllIllllllI, final int llllllllllllllllIIIIIIlllIIIIllI) {
        final int llllllllllllllllIIIIIIlllIIIIlIl = this.userConnection.getProtocolInfo().getProtocolVersion();
        final ViaPlatform llllllllllllllllIIIIIIlllIIIIlII = Via.getPlatform();
        final String llllllllllllllllIIIIIIlllIIIIIll = llllllllllllllllIIIIIIllIllllllI.user().getProtocolInfo().getUsername();
        final String llllllllllllllllIIIIIIlllIIIIIlI = (llllllllllllllllIIIIIIlllIIIIIll != null) ? String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIIlllIIIIIll).append(" ")) : "";
        llllllllllllllllIIIIIIlllIIIIlII.getLogger().log(Level.INFO, "{0}{1} {2}: {3} (0x{4}) -> {5} (0x{6}) [{7}] {8}", new Object[] { llllllllllllllllIIIIIIlllIIIIIlI, llllllllllllllllIIIIIIlllIIIIIII, llllllllllllllllIIIIIIlllIIIlIII, llllllllllllllllIIIIIIlllIIIIllI, Integer.toHexString(llllllllllllllllIIIIIIlllIIIIllI), llllllllllllllllIIIIIIllIllllllI.getId(), Integer.toHexString(llllllllllllllllIIIIIIllIllllllI.getId()), Integer.toString(llllllllllllllllIIIIIIlllIIIIlIl), llllllllllllllllIIIIIIllIllllllI });
    }
    
    @Override
    public void transform(final Direction llllllllllllllllIIIIIIlllIIlllII, final State llllllllllllllllIIIIIIlllIIllIll, final PacketWrapper llllllllllllllllIIIIIIlllIIllIlI) throws Exception {
        final int llllllllllllllllIIIIIIlllIIllIIl = llllllllllllllllIIIIIIlllIIllIlI.getId();
        llllllllllllllllIIIIIIlllIIllIlI.apply(llllllllllllllllIIIIIIlllIIlllII, llllllllllllllllIIIIIIlllIIllIll, 0, this.protocolList, llllllllllllllllIIIIIIlllIIlllII == Direction.CLIENTBOUND);
        super.transform(llllllllllllllllIIIIIIlllIIlllII, llllllllllllllllIIIIIIlllIIllIll, llllllllllllllllIIIIIIlllIIllIlI);
        if (Via.getManager().isDebug()) {
            this.logPacket(llllllllllllllllIIIIIIlllIIlllII, llllllllllllllllIIIIIIlllIIllIll, llllllllllllllllIIIIIIlllIIllIlI, llllllllllllllllIIIIIIlllIIllIIl);
        }
    }
    
    @Override
    public void cleanPipes() {
        this.registerPackets();
    }
    
    private void moveBaseProtocolsToTail() {
        List<Protocol> llllllllllllllllIIIIIIlllIlIIlll = null;
        for (final Protocol llllllllllllllllIIIIIIlllIlIlIIl : this.protocolList) {
            if (llllllllllllllllIIIIIIlllIlIlIIl.isBaseProtocol()) {
                if (llllllllllllllllIIIIIIlllIlIIlll == null) {
                    llllllllllllllllIIIIIIlllIlIIlll = new ArrayList<Protocol>();
                }
                llllllllllllllllIIIIIIlllIlIIlll.add(llllllllllllllllIIIIIIlllIlIlIIl);
            }
        }
        if (llllllllllllllllIIIIIIlllIlIIlll != null) {
            this.protocolList.removeAll(llllllllllllllllIIIIIIlllIlIIlll);
            this.protocolList.addAll(llllllllllllllllIIIIIIlllIlIIlll);
        }
    }
    
    public ProtocolPipelineImpl(final UserConnection llllllllllllllllIIIIIIllllIIIlll) {
        this.userConnection = llllllllllllllllIIIIIIllllIIIlll;
        llllllllllllllllIIIIIIllllIIIlll.getProtocolInfo().setPipeline(this);
        this.registerPackets();
    }
}
