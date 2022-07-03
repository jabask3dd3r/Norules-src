package com.viaversion.viaversion.protocol.packet;

import com.viaversion.viaversion.api.connection.*;
import java.util.function.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.google.common.base.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;

public class VersionedPacketTransformerImpl<C extends ClientboundPacketType, S extends ServerboundPacketType> implements VersionedPacketTransformer<C, S>
{
    private final /* synthetic */ Class<C> clientboundPacketsClass;
    private final /* synthetic */ Class<S> serverboundPacketsClass;
    private final /* synthetic */ int inputProtocolVersion;
    
    private boolean createAndSend(final UserConnection lllllllllllllIIlIllIIllIllIlIIll, final PacketType lllllllllllllIIlIllIIllIllIlIIlI, final Consumer<PacketWrapper> lllllllllllllIIlIllIIllIllIIllII) throws Exception {
        final PacketWrapper lllllllllllllIIlIllIIllIllIlIIII = PacketWrapper.create(lllllllllllllIIlIllIIllIllIlIIlI, lllllllllllllIIlIllIIllIllIlIIll);
        lllllllllllllIIlIllIIllIllIIllII.accept(lllllllllllllIIlIllIIllIllIlIIII);
        return this.send(lllllllllllllIIlIllIIllIllIlIIII);
    }
    
    @Override
    public boolean scheduleSend(final UserConnection lllllllllllllIIlIllIIlllIIlIllIl, final S lllllllllllllIIlIllIIlllIIlIllII, final Consumer<PacketWrapper> lllllllllllllIIlIllIIlllIIlIlIll) throws Exception {
        return this.scheduleCreateAndSend(lllllllllllllIIlIllIIlllIIlIllIl, lllllllllllllIIlIllIIlllIIlIllII, lllllllllllllIIlIllIIlllIIlIlIll);
    }
    
    public VersionedPacketTransformerImpl(final ProtocolVersion lllllllllllllIIlIllIIlllIllIllIl, final Class<C> lllllllllllllIIlIllIIlllIllIllII, final Class<S> lllllllllllllIIlIllIIlllIllIIlll) {
        Preconditions.checkNotNull((Object)lllllllllllllIIlIllIIlllIllIllIl);
        Preconditions.checkArgument(lllllllllllllIIlIllIIlllIllIllII != null || lllllllllllllIIlIllIIlllIllIIlll != null, (Object)"Either the clientbound or serverbound packets class has to be non-null");
        this.inputProtocolVersion = lllllllllllllIIlIllIIlllIllIllIl.getVersion();
        this.clientboundPacketsClass = lllllllllllllIIlIllIIlllIllIllII;
        this.serverboundPacketsClass = lllllllllllllIIlIllIIlllIllIIlll;
    }
    
    @Override
    public PacketWrapper transform(final UserConnection lllllllllllllIIlIllIIlllIIIlllll, final C lllllllllllllIIlIllIIlllIIIllIlI, final Consumer<PacketWrapper> lllllllllllllIIlIllIIlllIIIlllIl) throws Exception {
        return this.createAndTransform(lllllllllllllIIlIllIIlllIIIlllll, lllllllllllllIIlIllIIlllIIIllIlI, lllllllllllllIIlIllIIlllIIIlllIl);
    }
    
    @Override
    public boolean send(final UserConnection lllllllllllllIIlIllIIlllIlIIlIll, final S lllllllllllllIIlIllIIlllIlIIlIlI, final Consumer<PacketWrapper> lllllllllllllIIlIllIIlllIlIIllIl) throws Exception {
        return this.createAndSend(lllllllllllllIIlIllIIlllIlIIlIll, lllllllllllllIIlIllIIlllIlIIlIlI, lllllllllllllIIlIllIIlllIlIIllIl);
    }
    
    @Override
    public PacketWrapper transform(final PacketWrapper lllllllllllllIIlIllIIlllIIlIIlIl) throws Exception {
        this.validatePacket(lllllllllllllIIlIllIIlllIIlIIlIl);
        this.transformPacket(lllllllllllllIIlIllIIlllIIlIIlIl);
        return lllllllllllllIIlIllIIlllIIlIIlIl.isCancelled() ? null : lllllllllllllIIlIllIIlllIIlIIlIl;
    }
    
    @Override
    public boolean send(final PacketWrapper lllllllllllllIIlIllIIlllIllIIIll) throws Exception {
        this.validatePacket(lllllllllllllIIlIllIIlllIllIIIll);
        return this.transformAndSendPacket(lllllllllllllIIlIllIIlllIllIIIll, true);
    }
    
    @Override
    public boolean scheduleSend(final UserConnection lllllllllllllIIlIllIIlllIIlllIIl, final C lllllllllllllIIlIllIIlllIIllllII, final Consumer<PacketWrapper> lllllllllllllIIlIllIIlllIIllIlll) throws Exception {
        return this.scheduleCreateAndSend(lllllllllllllIIlIllIIlllIIlllIIl, lllllllllllllIIlIllIIlllIIllllII, lllllllllllllIIlIllIIlllIIllIlll);
    }
    
    private boolean scheduleCreateAndSend(final UserConnection lllllllllllllIIlIllIIllIlIllllll, final PacketType lllllllllllllIIlIllIIllIllIIIIll, final Consumer<PacketWrapper> lllllllllllllIIlIllIIllIllIIIIlI) throws Exception {
        final PacketWrapper lllllllllllllIIlIllIIllIllIIIIIl = PacketWrapper.create(lllllllllllllIIlIllIIllIllIIIIll, lllllllllllllIIlIllIIllIlIllllll);
        lllllllllllllIIlIllIIllIllIIIIlI.accept(lllllllllllllIIlIllIIllIllIIIIIl);
        return this.scheduleSend(lllllllllllllIIlIllIIllIllIIIIIl);
    }
    
    @Override
    public boolean send(final UserConnection lllllllllllllIIlIllIIlllIlIlIlll, final C lllllllllllllIIlIllIIlllIlIlIllI, final Consumer<PacketWrapper> lllllllllllllIIlIllIIlllIlIllIIl) throws Exception {
        return this.createAndSend(lllllllllllllIIlIllIIlllIlIlIlll, lllllllllllllIIlIllIIlllIlIlIllI, lllllllllllllIIlIllIIlllIlIllIIl);
    }
    
    @Override
    public PacketWrapper transform(final UserConnection lllllllllllllIIlIllIIlllIIIlIIll, final S lllllllllllllIIlIllIIlllIIIIlllI, final Consumer<PacketWrapper> lllllllllllllIIlIllIIlllIIIlIIIl) throws Exception {
        return this.createAndTransform(lllllllllllllIIlIllIIlllIIIlIIll, lllllllllllllIIlIllIIlllIIIIlllI, lllllllllllllIIlIllIIlllIIIlIIIl);
    }
    
    @Override
    public boolean scheduleSend(final PacketWrapper lllllllllllllIIlIllIIlllIlIIIIll) throws Exception {
        this.validatePacket(lllllllllllllIIlIllIIlllIlIIIIll);
        return this.transformAndSendPacket(lllllllllllllIIlIllIIlllIlIIIIll, false);
    }
    
    private void transformPacket(final PacketWrapper lllllllllllllIIlIllIIllIlllIllII) throws Exception {
        final PacketType lllllllllllllIIlIllIIllIlllIlIll = lllllllllllllIIlIllIIllIlllIllII.getPacketType();
        final UserConnection lllllllllllllIIlIllIIllIlllIlIlI = lllllllllllllIIlIllIIllIlllIllII.user();
        final boolean lllllllllllllIIlIllIIllIlllIlIIl = lllllllllllllIIlIllIIllIlllIlIll.direction() == Direction.CLIENTBOUND;
        final int lllllllllllllIIlIllIIllIlllIlIII = lllllllllllllIIlIllIIllIlllIlIIl ? this.inputProtocolVersion : lllllllllllllIIlIllIIllIlllIlIlI.getProtocolInfo().getServerProtocolVersion();
        final int lllllllllllllIIlIllIIllIlllIIlll = lllllllllllllIIlIllIIllIlllIlIIl ? lllllllllllllIIlIllIIllIlllIlIlI.getProtocolInfo().getProtocolVersion() : this.inputProtocolVersion;
        final List<ProtocolPathEntry> lllllllllllllIIlIllIIllIlllIIllI = Via.getManager().getProtocolManager().getProtocolPath(lllllllllllllIIlIllIIllIlllIIlll, lllllllllllllIIlIllIIllIlllIlIII);
        List<Protocol> lllllllllllllIIlIllIIllIlllIIlIl = null;
        if (lllllllllllllIIlIllIIllIlllIIllI != null) {
            lllllllllllllIIlIllIIllIlllIIlIl = new ArrayList<Protocol>(lllllllllllllIIlIllIIllIlllIIllI.size());
            for (final ProtocolPathEntry lllllllllllllIIlIllIIllIlllIllll : lllllllllllllIIlIllIIllIlllIIllI) {
                lllllllllllllIIlIllIIllIlllIIlIl.add(lllllllllllllIIlIllIIllIlllIllll.getProtocol());
            }
        }
        else if (lllllllllllllIIlIllIIllIlllIlIII != lllllllllllllIIlIllIIllIlllIIlll) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("No protocol path between client version ").append(lllllllllllllIIlIllIIllIlllIIlll).append(" and server version ").append(lllllllllllllIIlIllIIllIlllIlIII)));
        }
        if (lllllllllllllIIlIllIIllIlllIIlIl != null) {
            lllllllllllllIIlIllIIllIlllIllII.resetReader();
            try {
                lllllllllllllIIlIllIIllIlllIllII.apply(lllllllllllllIIlIllIIllIlllIlIll.direction(), State.PLAY, 0, lllllllllllllIIlIllIIllIlllIIlIl, lllllllllllllIIlIllIIllIlllIlIIl);
            }
            catch (Exception lllllllllllllIIlIllIIllIlllIlllI) {
                throw new Exception(String.valueOf(new StringBuilder().append("Exception trying to transform packet between client version ").append(lllllllllllllIIlIllIIllIlllIIlll).append(" and server version ").append(lllllllllllllIIlIllIIllIlllIlIII).append(". Are you sure you used the correct input version and packet write types?")), lllllllllllllIIlIllIIllIlllIlllI);
            }
        }
    }
    
    private void validatePacket(final PacketWrapper lllllllllllllIIlIllIIlllIIIIlIII) {
        if (lllllllllllllIIlIllIIlllIIIIlIII.user() == null) {
            throw new IllegalArgumentException("PacketWrapper does not have a targetted UserConnection");
        }
        if (lllllllllllllIIlIllIIlllIIIIlIII.getPacketType() == null) {
            throw new IllegalArgumentException("PacketWrapper does not have a valid packet type");
        }
        final Class<? extends PacketType> lllllllllllllIIlIllIIlllIIIIIlll = (Class<? extends PacketType>)((lllllllllllllIIlIllIIlllIIIIlIII.getPacketType().direction() == Direction.CLIENTBOUND) ? this.clientboundPacketsClass : this.serverboundPacketsClass);
        if (lllllllllllllIIlIllIIlllIIIIlIII.getPacketType().getClass() != lllllllllllllIIlIllIIlllIIIIIlll) {
            throw new IllegalArgumentException("PacketWrapper packet type is of the wrong packet class");
        }
    }
    
    private boolean transformAndSendPacket(final PacketWrapper lllllllllllllIIlIllIIllIllllllII, final boolean lllllllllllllIIlIllIIllIlllllllI) throws Exception {
        this.transformPacket(lllllllllllllIIlIllIIllIllllllII);
        if (lllllllllllllIIlIllIIllIllllllII.isCancelled()) {
            return false;
        }
        if (lllllllllllllIIlIllIIllIlllllllI) {
            if (lllllllllllllIIlIllIIllIllllllII.getPacketType().direction() == Direction.CLIENTBOUND) {
                lllllllllllllIIlIllIIllIllllllII.sendRaw();
            }
            else {
                lllllllllllllIIlIllIIllIllllllII.sendToServerRaw();
            }
        }
        else if (lllllllllllllIIlIllIIllIllllllII.getPacketType().direction() == Direction.CLIENTBOUND) {
            lllllllllllllIIlIllIIllIllllllII.scheduleSendRaw();
        }
        else {
            lllllllllllllIIlIllIIllIllllllII.scheduleSendToServerRaw();
        }
        return true;
    }
    
    private PacketWrapper createAndTransform(final UserConnection lllllllllllllIIlIllIIllIlIllIlIl, final PacketType lllllllllllllIIlIllIIllIlIllIlII, final Consumer<PacketWrapper> lllllllllllllIIlIllIIllIlIlIlllI) throws Exception {
        final PacketWrapper lllllllllllllIIlIllIIllIlIllIIlI = PacketWrapper.create(lllllllllllllIIlIllIIllIlIllIlII, lllllllllllllIIlIllIIllIlIllIlIl);
        lllllllllllllIIlIllIIllIlIlIlllI.accept(lllllllllllllIIlIllIIllIlIllIIlI);
        return this.transform(lllllllllllllIIlIllIIllIlIllIIlI);
    }
}
