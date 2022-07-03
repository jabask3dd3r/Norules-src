package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocol.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.logging.*;
import com.google.common.base.*;
import java.util.*;
import io.netty.util.concurrent.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.protocol.*;
import io.netty.channel.*;

public class BaseProtocol1_7 extends AbstractProtocol
{
    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundStatusPackets.STATUS_RESPONSE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllIllIIlIIl) throws Exception {
                        final ProtocolInfo llllllIllIIlIII = llllllIllIIlIIl.user().getProtocolInfo();
                        final String llllllIllIIIlll = llllllIllIIlIIl.get(Type.STRING, 0);
                        try {
                            JsonElement llllllIllIlIIIl = GsonUtil.getGson().fromJson(llllllIllIIIlll, JsonElement.class);
                            int llllllIllIIllll = 0;
                            JsonObject llllllIllIlIIII;
                            if (llllllIllIlIIIl.isJsonObject()) {
                                if (llllllIllIlIIIl.getAsJsonObject().has("version")) {
                                    final JsonObject llllllIllIlIlIl = llllllIllIlIIIl.getAsJsonObject().get("version").getAsJsonObject();
                                    if (llllllIllIlIlIl.has("protocol")) {
                                        llllllIllIIllll = llllllIllIlIlIl.get("protocol").getAsLong().intValue();
                                    }
                                }
                                else {
                                    final JsonObject llllllIllIlIlII;
                                    llllllIllIlIIIl.getAsJsonObject().add("version", llllllIllIlIlII = new JsonObject());
                                }
                            }
                            else {
                                llllllIllIlIIIl = new JsonObject();
                                llllllIllIlIIIl.getAsJsonObject().add("version", llllllIllIlIIII = new JsonObject());
                            }
                            if (Via.getConfig().isSendSupportedVersions()) {
                                llllllIllIlIIII.add("supportedVersions", GsonUtil.getGson().toJsonTree(Via.getAPI().getSupportedVersions()));
                            }
                            if (!Via.getAPI().getServerVersion().isKnown()) {
                                final ProtocolManagerImpl llllllIllIlIIll = (ProtocolManagerImpl)Via.getManager().getProtocolManager();
                                llllllIllIlIIll.setServerProtocol(new ServerProtocolVersionSingleton(ProtocolVersion.getProtocol(llllllIllIIllll).getVersion()));
                            }
                            final VersionProvider llllllIllIIlllI = Via.getManager().getProviders().get(VersionProvider.class);
                            if (llllllIllIIlllI == null) {
                                llllllIllIIlIIl.user().setActive(false);
                                return;
                            }
                            final int llllllIllIIllIl = llllllIllIIlllI.getClosestServerProtocol(llllllIllIIlIIl.user());
                            List<ProtocolPathEntry> llllllIllIIllII = null;
                            if (llllllIllIIlIII.getProtocolVersion() >= llllllIllIIllIl || Via.getPlatform().isOldClientsAllowed()) {
                                llllllIllIIllII = Via.getManager().getProtocolManager().getProtocolPath(llllllIllIIlIII.getProtocolVersion(), llllllIllIIllIl);
                            }
                            if (llllllIllIIllII != null) {
                                if (llllllIllIIllll == llllllIllIIllIl || llllllIllIIllll == 0) {
                                    final ProtocolVersion llllllIllIlIIlI = ProtocolVersion.getProtocol(llllllIllIIlIII.getProtocolVersion());
                                    llllllIllIlIIII.addProperty("protocol", llllllIllIlIIlI.getOriginalVersion());
                                }
                            }
                            else {
                                llllllIllIIlIIl.user().setActive(false);
                            }
                            if (Via.getConfig().getBlockedProtocols().contains(llllllIllIIlIII.getProtocolVersion())) {
                                llllllIllIlIIII.addProperty("protocol", -1);
                            }
                            llllllIllIIlIIl.set(Type.STRING, 0, GsonUtil.getGson().toJson(llllllIllIlIIIl));
                        }
                        catch (JsonParseException llllllIllIIlIll) {
                            llllllIllIIlIll.printStackTrace();
                        }
                    }
                });
            }
        });
        this.registerClientbound(ClientboundLoginPackets.GAME_PROFILE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlllIIlIlllIIllll) throws Exception {
                        final ProtocolInfo lllllllllllllIlIlllIIlIlllIlIIll = lllllllllllllIlIlllIIlIlllIIllll.user().getProtocolInfo();
                        lllllllllllllIlIlllIIlIlllIlIIll.setState(State.PLAY);
                        final UUID lllllllllllllIlIlllIIlIlllIlIIlI = BaseProtocol1_7.this.passthroughLoginUUID(lllllllllllllIlIlllIIlIlllIIllll);
                        lllllllllllllIlIlllIIlIlllIlIIll.setUuid(lllllllllllllIlIlllIIlIlllIlIIlI);
                        final String lllllllllllllIlIlllIIlIlllIlIIIl = lllllllllllllIlIlllIIlIlllIIllll.passthrough(Type.STRING);
                        lllllllllllllIlIlllIIlIlllIlIIll.setUsername(lllllllllllllIlIlllIIlIlllIlIIIl);
                        Via.getManager().getConnectionManager().onLoginSuccess(lllllllllllllIlIlllIIlIlllIIllll.user());
                        if (!lllllllllllllIlIlllIIlIlllIlIIll.getPipeline().hasNonBaseProtocols()) {
                            lllllllllllllIlIlllIIlIlllIIllll.user().setActive(false);
                        }
                        if (Via.getManager().isDebug()) {
                            Via.getPlatform().getLogger().log(Level.INFO, "{0} logged in with protocol {1}, Route: {2}", new Object[] { lllllllllllllIlIlllIIlIlllIlIIIl, lllllllllllllIlIlllIIlIlllIlIIll.getProtocolVersion(), Joiner.on(", ").join((Object)lllllllllllllIlIlllIIlIlllIlIIll.getPipeline().pipes(), (Object)", ", new Object[0]) });
                        }
                    }
                });
            }
        });
        this.registerServerbound(ServerboundLoginPackets.HELLO, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIlIlIllIIlllIllI) throws Exception {
                        final int llllllllllllllIlIlIlIllIIlllIlIl = llllllllllllllIlIlIlIllIIlllIllI.user().getProtocolInfo().getProtocolVersion();
                        if (Via.getConfig().getBlockedProtocols().contains(llllllllllllllIlIlIlIllIIlllIlIl)) {
                            if (!llllllllllllllIlIlIlIllIIlllIllI.user().getChannel().isOpen()) {
                                return;
                            }
                            if (!llllllllllllllIlIlIlIllIIlllIllI.user().shouldApplyBlockProtocol()) {
                                return;
                            }
                            final PacketWrapper llllllllllllllIlIlIlIllIIllllIIl = PacketWrapper.create(ClientboundLoginPackets.LOGIN_DISCONNECT, llllllllllllllIlIlIlIllIIlllIllI.user());
                            Protocol1_9To1_8.FIX_JSON.write(llllllllllllllIlIlIlIllIIllllIIl, ChatColorUtil.translateAlternateColorCodes(Via.getConfig().getBlockedDisconnectMsg()));
                            llllllllllllllIlIlIlIllIIlllIllI.cancel();
                            final ChannelFuture llllllllllllllIlIlIlIllIIllllIII = llllllllllllllIlIlIlIllIIllllIIl.sendFuture(BaseProtocol.class);
                            llllllllllllllIlIlIlIllIIllllIII.addListener(llllllllllllllIlIlIlIllIIllIlllI -> llllllllllllllIlIlIlIllIIlllIllI.user().getChannel().close());
                        }
                    }
                });
            }
        });
    }
    
    protected UUID passthroughLoginUUID(final PacketWrapper lllllllllllllIIIlIlIIIlllIlllIII) throws Exception {
        String lllllllllllllIIIlIlIIIlllIlllIIl = lllllllllllllIIIlIlIIIlllIlllIII.passthrough(Type.STRING);
        if (lllllllllllllIIIlIlIIIlllIlllIIl.length() == 32) {
            lllllllllllllIIIlIlIIIlllIlllIIl = addDashes(lllllllllllllIIIlIlIIIlllIlllIIl);
        }
        return UUID.fromString(lllllllllllllIIIlIlIIIlllIlllIIl);
    }
    
    @Override
    public boolean isBaseProtocol() {
        return true;
    }
    
    public static String addDashes(final String lllllllllllllIIIlIlIIIllllIIIIIl) {
        final StringBuilder lllllllllllllIIIlIlIIIllllIIIIII = new StringBuilder(lllllllllllllIIIlIlIIIllllIIIIIl);
        lllllllllllllIIIlIlIIIllllIIIIII.insert(20, '-');
        lllllllllllllIIIlIlIIIllllIIIIII.insert(16, '-');
        lllllllllllllIIIlIlIIIllllIIIIII.insert(12, '-');
        lllllllllllllIIIlIlIIIllllIIIIII.insert(8, '-');
        return String.valueOf(lllllllllllllIIIlIlIIIllllIIIIII);
    }
}
