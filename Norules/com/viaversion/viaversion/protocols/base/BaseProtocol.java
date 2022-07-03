package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class BaseProtocol extends AbstractProtocol
{
    @Override
    public void register(final ViaProviders llllllllllllllIIlIlIIlIIIIIIIlll) {
        llllllllllllllIIlIlIIlIIIIIIIlll.register((Class<BaseVersionProvider>)VersionProvider.class, new BaseVersionProvider());
    }
    
    @Override
    public boolean isBaseProtocol() {
        return true;
    }
    
    @Override
    public void transform(final Direction llllllllllllllIIlIlIIIllllllllIl, final State llllllllllllllIIlIlIIlIIIIIIIIII, final PacketWrapper llllllllllllllIIlIlIIIlllllllIll) throws Exception {
        super.transform(llllllllllllllIIlIlIIIllllllllIl, llllllllllllllIIlIlIIlIIIIIIIIII, llllllllllllllIIlIlIIIlllllllIll);
        if (llllllllllllllIIlIlIIIllllllllIl == Direction.SERVERBOUND && llllllllllllllIIlIlIIlIIIIIIIIII == State.HANDSHAKE && llllllllllllllIIlIlIIIlllllllIll.getId() != 0) {
            llllllllllllllIIlIlIIIlllllllIll.user().setActive(false);
        }
    }
    
    @Override
    protected void registerPackets() {
        this.registerServerbound(ServerboundHandshakePackets.CLIENT_INTENTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIlIIlllIlllIIIIlII;
                final int lllllllllllllIIlIIlllIlllIIIIIll;
                final ProtocolInfo lllllllllllllIIlIIlllIlllIIIIIlI;
                final VersionProvider lllllllllllllIIlIIlllIlllIIIIIIl;
                int lllllllllllllIIlIIlllIlllIIIIIII;
                List<ProtocolPathEntry> lllllllllllllIIlIIlllIllIlllllll;
                ProtocolPipeline lllllllllllllIIlIIlllIllIllllllI;
                ArrayList lllllllllllllIIlIIlllIlllIIIIlll;
                long lllllllllllllIIlIIlllIllIlllIlII;
                ProtocolPathEntry lllllllllllllIIlIIlllIlllIIIlIII;
                ProtocolVersion lllllllllllllIIlIIlllIlllIIIIllI;
                this.handler(lllllllllllllIIlIIlllIlllIIIIlIl -> {
                    lllllllllllllIIlIIlllIlllIIIIlII = lllllllllllllIIlIIlllIlllIIIIlIl.passthrough((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIlIIlllIlllIIIIlIl.passthrough(Type.STRING);
                    lllllllllllllIIlIIlllIlllIIIIlIl.passthrough((Type<Object>)Type.UNSIGNED_SHORT);
                    lllllllllllllIIlIIlllIlllIIIIIll = lllllllllllllIIlIIlllIlllIIIIlIl.passthrough((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIlIIlllIlllIIIIIlI = lllllllllllllIIlIIlllIlllIIIIlIl.user().getProtocolInfo();
                    lllllllllllllIIlIIlllIlllIIIIIlI.setProtocolVersion(lllllllllllllIIlIIlllIlllIIIIlII);
                    lllllllllllllIIlIIlllIlllIIIIIIl = Via.getManager().getProviders().get(VersionProvider.class);
                    if (lllllllllllllIIlIIlllIlllIIIIIIl == null) {
                        lllllllllllllIIlIIlllIlllIIIIlIl.user().setActive(false);
                    }
                    else {
                        lllllllllllllIIlIIlllIlllIIIIIII = lllllllllllllIIlIIlllIlllIIIIIIl.getClosestServerProtocol(lllllllllllllIIlIIlllIlllIIIIlIl.user());
                        lllllllllllllIIlIIlllIlllIIIIIlI.setServerProtocolVersion(lllllllllllllIIlIIlllIlllIIIIIII);
                        lllllllllllllIIlIIlllIllIlllllll = null;
                        if (lllllllllllllIIlIIlllIlllIIIIIlI.getProtocolVersion() >= lllllllllllllIIlIIlllIlllIIIIIII || Via.getPlatform().isOldClientsAllowed()) {
                            lllllllllllllIIlIIlllIllIlllllll = Via.getManager().getProtocolManager().getProtocolPath(lllllllllllllIIlIIlllIlllIIIIIlI.getProtocolVersion(), lllllllllllllIIlIIlllIlllIIIIIII);
                        }
                        lllllllllllllIIlIIlllIllIllllllI = lllllllllllllIIlIIlllIlllIIIIlIl.user().getProtocolInfo().getPipeline();
                        if (lllllllllllllIIlIIlllIllIlllllll != null) {
                            lllllllllllllIIlIIlllIlllIIIIlll = new ArrayList<Protocol>(lllllllllllllIIlIIlllIllIlllllll.size());
                            lllllllllllllIIlIIlllIllIlllIlII = (long)lllllllllllllIIlIIlllIllIlllllll.iterator();
                            while (((Iterator)lllllllllllllIIlIIlllIllIlllIlII).hasNext()) {
                                lllllllllllllIIlIIlllIlllIIIlIII = ((Iterator<ProtocolPathEntry>)lllllllllllllIIlIIlllIllIlllIlII).next();
                                lllllllllllllIIlIIlllIlllIIIIlll.add(lllllllllllllIIlIIlllIlllIIIlIII.getProtocol());
                                Via.getManager().getProtocolManager().completeMappingDataLoading(lllllllllllllIIlIIlllIlllIIIlIII.getProtocol().getClass());
                            }
                            lllllllllllllIIlIIlllIllIllllllI.add((Collection<Protocol>)lllllllllllllIIlIIlllIlllIIIIlll);
                            lllllllllllllIIlIIlllIlllIIIIllI = ProtocolVersion.getProtocol(lllllllllllllIIlIIlllIlllIIIIIII);
                            lllllllllllllIIlIIlllIlllIIIIlIl.set(Type.VAR_INT, 0, lllllllllllllIIlIIlllIlllIIIIllI.getOriginalVersion());
                        }
                        lllllllllllllIIlIIlllIllIllllllI.add(Via.getManager().getProtocolManager().getBaseProtocol(lllllllllllllIIlIIlllIlllIIIIIII));
                        if (lllllllllllllIIlIIlllIlllIIIIIll == 1) {
                            lllllllllllllIIlIIlllIlllIIIIIlI.setState(State.STATUS);
                        }
                        else if (lllllllllllllIIlIIlllIlllIIIIIll == 2) {
                            lllllllllllllIIlIIlllIlllIIIIIlI.setState(State.LOGIN);
                        }
                    }
                });
            }
        });
    }
}
