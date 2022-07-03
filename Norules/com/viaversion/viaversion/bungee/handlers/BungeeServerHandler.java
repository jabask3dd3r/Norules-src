package com.viaversion.viaversion.bungee.handlers;

import net.md_5.bungee.api.plugin.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.bungee.storage.*;
import com.viaversion.viaversion.bungee.service.*;
import java.lang.reflect.*;
import net.md_5.bungee.event.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import net.md_5.bungee.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.*;
import java.nio.charset.*;
import java.util.function.*;
import java.util.stream.*;
import net.md_5.bungee.api.score.*;
import net.md_5.bungee.api.connection.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import net.md_5.bungee.api.event.*;

public class BungeeServerHandler implements Listener
{
    private static /* synthetic */ Field entityRewrite;
    private static /* synthetic */ Method getEntityMap;
    private static /* synthetic */ Method setVersion;
    private static /* synthetic */ Method getHandshake;
    private static /* synthetic */ Method setProtocol;
    private static /* synthetic */ Field channelWrapper;
    private static /* synthetic */ Method getRelayMessages;
    
    static {
        BungeeServerHandler.getEntityMap = null;
        BungeeServerHandler.setVersion = null;
        BungeeServerHandler.entityRewrite = null;
        BungeeServerHandler.channelWrapper = null;
        try {
            BungeeServerHandler.getHandshake = Class.forName("net.md_5.bungee.connection.InitialHandler").getDeclaredMethod("getHandshake", (Class<?>[])new Class[0]);
            BungeeServerHandler.getRelayMessages = Class.forName("net.md_5.bungee.connection.InitialHandler").getDeclaredMethod("getRelayMessages", (Class<?>[])new Class[0]);
            BungeeServerHandler.setProtocol = Class.forName("net.md_5.bungee.protocol.packet.Handshake").getDeclaredMethod("setProtocolVersion", Integer.TYPE);
            BungeeServerHandler.getEntityMap = Class.forName("net.md_5.bungee.entitymap.EntityMap").getDeclaredMethod("getEntityMap", Integer.TYPE);
            BungeeServerHandler.setVersion = Class.forName("net.md_5.bungee.netty.ChannelWrapper").getDeclaredMethod("setVersion", Integer.TYPE);
            (BungeeServerHandler.channelWrapper = Class.forName("net.md_5.bungee.UserConnection").getDeclaredField("ch")).setAccessible(true);
            (BungeeServerHandler.entityRewrite = Class.forName("net.md_5.bungee.UserConnection").getDeclaredField("entityRewrite")).setAccessible(true);
        }
        catch (Exception lllllllllllllIIIlIllIllIIllIlIIl) {
            lllllllllllllIIIlIllIllIIllIlIIl.printStackTrace();
        }
    }
    
    @EventHandler(priority = 120)
    public void onServerConnect(final ServerConnectEvent lllllllllllllIIIlIllIllIllIIlIlI) {
        if (lllllllllllllIIIlIllIllIllIIlIlI.isCancelled()) {
            return;
        }
        final UserConnection lllllllllllllIIIlIllIllIllIIllIl = Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIIlIllIllIllIIlIlI.getPlayer().getUniqueId());
        if (lllllllllllllIIIlIllIllIllIIllIl == null) {
            return;
        }
        if (!lllllllllllllIIIlIllIllIllIIllIl.has(BungeeStorage.class)) {
            lllllllllllllIIIlIllIllIllIIllIl.put(new BungeeStorage(lllllllllllllIIIlIllIllIllIIlIlI.getPlayer()));
        }
        final int lllllllllllllIIIlIllIllIllIIllII = ProtocolDetectorService.getProtocolId(lllllllllllllIIIlIllIllIllIIlIlI.getTarget().getName());
        final List<ProtocolPathEntry> lllllllllllllIIIlIllIllIllIIlIll = Via.getManager().getProtocolManager().getProtocolPath(lllllllllllllIIIlIllIllIllIIllIl.getProtocolInfo().getProtocolVersion(), lllllllllllllIIIlIllIllIllIIllII);
        try {
            final Object lllllllllllllIIIlIllIllIllIlIIIl = BungeeServerHandler.getHandshake.invoke(lllllllllllllIIIlIllIllIllIIlIlI.getPlayer().getPendingConnection(), new Object[0]);
            BungeeServerHandler.setProtocol.invoke(lllllllllllllIIIlIllIllIllIlIIIl, (lllllllllllllIIIlIllIllIllIIlIll == null) ? lllllllllllllIIIlIllIllIllIIllIl.getProtocolInfo().getProtocolVersion() : lllllllllllllIIIlIllIllIllIIllII);
        }
        catch (InvocationTargetException | IllegalAccessException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIIIlIllIllIllIlIIII = ex;
            lllllllllllllIIIlIllIllIllIlIIII.printStackTrace();
        }
    }
    
    @EventHandler(priority = -120)
    public void onServerConnected(final ServerConnectedEvent lllllllllllllIIIlIllIllIllIIIIII) {
        try {
            this.checkServerChange(lllllllllllllIIIlIllIllIllIIIIII, Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIIlIllIllIllIIIIII.getPlayer().getUniqueId()));
        }
        catch (Exception lllllllllllllIIIlIllIllIllIIIIlI) {
            lllllllllllllIIIlIllIllIllIIIIlI.printStackTrace();
        }
    }
    
    public void checkServerChange(final ServerConnectedEvent lllllllllllllIIIlIllIllIIllllllI, final UserConnection lllllllllllllIIIlIllIllIIllllIll) throws Exception {
        if (lllllllllllllIIIlIllIllIIllllIll == null) {
            return;
        }
        if (lllllllllllllIIIlIllIllIIllllIll.has(BungeeStorage.class)) {
            final BungeeStorage lllllllllllllIIIlIllIllIlIIIIIIl = lllllllllllllIIIlIllIllIIllllIll.get(BungeeStorage.class);
            final ProxiedPlayer lllllllllllllIIIlIllIllIlIIIIIII = lllllllllllllIIIlIllIllIlIIIIIIl.getPlayer();
            if (lllllllllllllIIIlIllIllIIllllllI.getServer() != null && !lllllllllllllIIIlIllIllIIllllllI.getServer().getInfo().getName().equals(lllllllllllllIIIlIllIllIlIIIIIIl.getCurrentServer())) {
                final EntityTracker1_9 lllllllllllllIIIlIllIllIlIIIllII = lllllllllllllIIIlIllIllIIllllIll.getEntityTracker(Protocol1_9To1_8.class);
                if (lllllllllllllIIIlIllIllIlIIIllII != null && lllllllllllllIIIlIllIllIlIIIllII.isAutoTeam() && lllllllllllllIIIlIllIllIlIIIllII.isTeamExists()) {
                    lllllllllllllIIIlIllIllIlIIIllII.sendTeamPacket(false, true);
                }
                final String lllllllllllllIIIlIllIllIlIIIlIll = lllllllllllllIIIlIllIllIIllllllI.getServer().getInfo().getName();
                lllllllllllllIIIlIllIllIlIIIIIIl.setCurrentServer(lllllllllllllIIIlIllIllIlIIIlIll);
                int lllllllllllllIIIlIllIllIlIIIlIlI = ProtocolDetectorService.getProtocolId(lllllllllllllIIIlIllIllIlIIIlIll);
                if (lllllllllllllIIIlIllIllIlIIIlIlI <= ProtocolVersion.v1_8.getVersion() && lllllllllllllIIIlIllIllIlIIIIIIl.getBossbar() != null) {
                    if (lllllllllllllIIIlIllIllIIllllIll.getProtocolInfo().getPipeline().contains(Protocol1_9To1_8.class)) {
                        for (final UUID lllllllllllllIIIlIllIllIlIIlIlll : lllllllllllllIIIlIllIllIlIIIIIIl.getBossbar()) {
                            final PacketWrapper lllllllllllllIIIlIllIllIlIIllIII = PacketWrapper.create(ClientboundPackets1_9.BOSSBAR, null, lllllllllllllIIIlIllIllIIllllIll);
                            lllllllllllllIIIlIllIllIlIIllIII.write(Type.UUID, lllllllllllllIIIlIllIllIlIIlIlll);
                            lllllllllllllIIIlIllIllIlIIllIII.write(Type.VAR_INT, 1);
                            lllllllllllllIIIlIllIllIlIIllIII.send(Protocol1_9To1_8.class);
                        }
                    }
                    lllllllllllllIIIlIllIllIlIIIIIIl.getBossbar().clear();
                }
                final ProtocolInfo lllllllllllllIIIlIllIllIlIIIlIIl = lllllllllllllIIIlIllIllIIllllIll.getProtocolInfo();
                final int lllllllllllllIIIlIllIllIlIIIlIII = lllllllllllllIIIlIllIllIlIIIlIIl.getServerProtocolVersion();
                final List<ProtocolPathEntry> lllllllllllllIIIlIllIllIlIIIIlll = Via.getManager().getProtocolManager().getProtocolPath(lllllllllllllIIIlIllIllIlIIIlIIl.getProtocolVersion(), lllllllllllllIIIlIllIllIlIIIlIlI);
                final ProtocolPipeline lllllllllllllIIIlIllIllIlIIIIllI = lllllllllllllIIIlIllIllIIllllIll.getProtocolInfo().getPipeline();
                lllllllllllllIIIlIllIllIIllllIll.clearStoredObjects();
                lllllllllllllIIIlIllIllIlIIIIllI.cleanPipes();
                if (lllllllllllllIIIlIllIllIlIIIIlll == null) {
                    lllllllllllllIIIlIllIllIlIIIlIlI = lllllllllllllIIIlIllIllIlIIIlIIl.getProtocolVersion();
                }
                else {
                    final List<Protocol> lllllllllllllIIIlIllIllIlIIlIlIl = new ArrayList<Protocol>(lllllllllllllIIIlIllIllIlIIIIlll.size());
                    for (final ProtocolPathEntry lllllllllllllIIIlIllIllIlIIlIllI : lllllllllllllIIIlIllIllIlIIIIlll) {
                        lllllllllllllIIIlIllIllIlIIlIlIl.add(lllllllllllllIIIlIllIllIlIIlIllI.getProtocol());
                    }
                    lllllllllllllIIIlIllIllIlIIIIllI.add(lllllllllllllIIIlIllIllIlIIlIlIl);
                }
                lllllllllllllIIIlIllIllIlIIIlIIl.setServerProtocolVersion(lllllllllllllIIIlIllIllIlIIIlIlI);
                lllllllllllllIIIlIllIllIlIIIIllI.add(Via.getManager().getProtocolManager().getBaseProtocol(lllllllllllllIIIlIllIllIlIIIlIlI));
                final Object lllllllllllllIIIlIllIllIlIIIIlIl = BungeeServerHandler.getRelayMessages.invoke(lllllllllllllIIIlIllIllIIllllllI.getPlayer().getPendingConnection(), new Object[0]);
                for (final Object lllllllllllllIIIlIllIllIlIIlIIII : (List)lllllllllllllIIIlIllIllIlIIIIlIl) {
                    final PluginMessage lllllllllllllIIIlIllIllIlIIlIIll = (PluginMessage)lllllllllllllIIIlIllIllIlIIlIIII;
                    String lllllllllllllIIIlIllIllIlIIlIIlI = lllllllllllllIIIlIllIllIlIIlIIll.getTag();
                    final int lllllllllllllIIIlIllIllIlIIlIIIl = ProtocolVersion.v1_13.getVersion();
                    if (lllllllllllllIIIlIllIllIlIIIlIII != -1) {
                        final String lllllllllllllIIIlIllIllIlIIlIlII = lllllllllllllIIIlIllIllIlIIlIIlI;
                        if (lllllllllllllIIIlIllIllIlIIIlIII < lllllllllllllIIIlIllIllIlIIlIIIl && lllllllllllllIIIlIllIllIlIIIlIlI >= lllllllllllllIIIlIllIllIlIIlIIIl) {
                            lllllllllllllIIIlIllIllIlIIlIIlI = InventoryPackets.getNewPluginChannelId(lllllllllllllIIIlIllIllIlIIlIIlI);
                            if (lllllllllllllIIIlIllIllIlIIlIIlI == null) {
                                throw new RuntimeException(String.valueOf(new StringBuilder().append(lllllllllllllIIIlIllIllIlIIlIlII).append(" found in relayMessages")));
                            }
                            if (lllllllllllllIIIlIllIllIlIIlIIlI.equals("minecraft:register")) {
                                lllllllllllllIIIlIllIllIlIIlIIll.setData(Arrays.stream(new String(lllllllllllllIIIlIllIllIlIIlIIll.getData(), StandardCharsets.UTF_8).split("\u0000")).map((Function<? super String, ?>)InventoryPackets::getNewPluginChannelId).filter(Objects::nonNull).collect((Collector<? super Object, ?, String>)Collectors.joining("\u0000")).getBytes(StandardCharsets.UTF_8));
                            }
                        }
                        else if (lllllllllllllIIIlIllIllIlIIIlIII >= lllllllllllllIIIlIllIllIlIIlIIIl && lllllllllllllIIIlIllIllIlIIIlIlI < lllllllllllllIIIlIllIllIlIIlIIIl) {
                            lllllllllllllIIIlIllIllIlIIlIIlI = InventoryPackets.getOldPluginChannelId(lllllllllllllIIIlIllIllIlIIlIIlI);
                            if (lllllllllllllIIIlIllIllIlIIlIIlI == null) {
                                throw new RuntimeException(String.valueOf(new StringBuilder().append(lllllllllllllIIIlIllIllIlIIlIlII).append(" found in relayMessages")));
                            }
                            if (lllllllllllllIIIlIllIllIlIIlIIlI.equals("REGISTER")) {
                                lllllllllllllIIIlIllIllIlIIlIIll.setData(Arrays.stream(new String(lllllllllllllIIIlIllIllIlIIlIIll.getData(), StandardCharsets.UTF_8).split("\u0000")).map((Function<? super String, ?>)InventoryPackets::getOldPluginChannelId).filter(Objects::nonNull).collect((Collector<? super Object, ?, String>)Collectors.joining("\u0000")).getBytes(StandardCharsets.UTF_8));
                            }
                        }
                    }
                    lllllllllllllIIIlIllIllIlIIlIIll.setTag(lllllllllllllIIIlIllIllIlIIlIIlI);
                }
                lllllllllllllIIIlIllIllIIllllIll.put(lllllllllllllIIIlIllIllIlIIIIIIl);
                lllllllllllllIIIlIllIllIIllllIll.setActive(lllllllllllllIIIlIllIllIlIIIIlll != null);
                for (final Protocol lllllllllllllIIIlIllIllIlIIIllll : lllllllllllllIIIlIllIllIlIIIIllI.pipes()) {
                    lllllllllllllIIIlIllIllIlIIIllll.init(lllllllllllllIIIlIllIllIIllllIll);
                }
                final EntityTracker1_9 lllllllllllllIIIlIllIllIlIIIIlII = lllllllllllllIIIlIllIllIIllllIll.getEntityTracker(Protocol1_9To1_8.class);
                if (lllllllllllllIIIlIllIllIlIIIIlII != null && Via.getConfig().isAutoTeam()) {
                    String lllllllllllllIIIlIllIllIlIIIllIl = null;
                    for (final Team lllllllllllllIIIlIllIllIlIIIlllI : lllllllllllllIIIlIllIllIlIIIIIII.getScoreboard().getTeams()) {
                        if (lllllllllllllIIIlIllIllIlIIIlllI.getPlayers().contains(lllllllllllllIIIlIllIllIlIIIlIIl.getUsername())) {
                            lllllllllllllIIIlIllIllIlIIIllIl = lllllllllllllIIIlIllIllIlIIIlllI.getName();
                        }
                    }
                    lllllllllllllIIIlIllIllIlIIIIlII.setAutoTeam(true);
                    if (lllllllllllllIIIlIllIllIlIIIllIl == null) {
                        lllllllllllllIIIlIllIllIlIIIIlII.sendTeamPacket(true, true);
                        lllllllllllllIIIlIllIllIlIIIIlII.setCurrentTeam("viaversion");
                    }
                    else {
                        lllllllllllllIIIlIllIllIlIIIIlII.setAutoTeam(Via.getConfig().isAutoTeam());
                        lllllllllllllIIIlIllIllIlIIIIlII.setCurrentTeam(lllllllllllllIIIlIllIllIlIIIllIl);
                    }
                }
                final Object lllllllllllllIIIlIllIllIlIIIIIll = BungeeServerHandler.channelWrapper.get(lllllllllllllIIIlIllIllIlIIIIIII);
                BungeeServerHandler.setVersion.invoke(lllllllllllllIIIlIllIllIlIIIIIll, lllllllllllllIIIlIllIllIlIIIlIlI);
                final Object lllllllllllllIIIlIllIllIlIIIIIlI = BungeeServerHandler.getEntityMap.invoke(null, lllllllllllllIIIlIllIllIlIIIlIlI);
                BungeeServerHandler.entityRewrite.set(lllllllllllllIIIlIllIllIlIIIIIII, lllllllllllllIIIlIllIllIlIIIIIlI);
            }
        }
    }
    
    @EventHandler(priority = -120)
    public void onServerSwitch(final ServerSwitchEvent lllllllllllllIIIlIllIllIlIlIllll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokeinterface com/viaversion/viaversion/api/ViaManager.getConnectionManager:()Lcom/viaversion/viaversion/api/connection/ConnectionManager;
        //     8: aload_1         /* lllllllllllllIIIlIllIllIlIllIIlI */
        //     9: invokevirtual   net/md_5/bungee/api/event/ServerSwitchEvent.getPlayer:()Lnet/md_5/bungee/api/connection/ProxiedPlayer;
        //    12: invokeinterface net/md_5/bungee/api/connection/ProxiedPlayer.getUniqueId:()Ljava/util/UUID;
        //    17: invokeinterface com/viaversion/viaversion/api/connection/ConnectionManager.getConnectedClient:(Ljava/util/UUID;)Lcom/viaversion/viaversion/api/connection/UserConnection;
        //    22: astore_2        /* lllllllllllllIIIlIllIllIlIlIlllI */
        //    23: aload_2         /* lllllllllllllIIIlIllIllIlIllIIIl */
        //    24: ifnonnull       28
        //    27: return         
        //    28: invokestatic    com/viaversion/viaversion/api/Via.getManager:()Lcom/viaversion/viaversion/api/ViaManager;
        //    31: invokeinterface com/viaversion/viaversion/api/ViaManager.getProviders:()Lcom/viaversion/viaversion/api/platform/providers/ViaProviders;
        //    36: ldc_w           Lcom/viaversion/viaversion/protocols/protocol1_9to1_8/providers/EntityIdProvider;.class
        //    39: invokevirtual   com/viaversion/viaversion/api/platform/providers/ViaProviders.get:(Ljava/lang/Class;)Lcom/viaversion/viaversion/api/platform/providers/Provider;
        //    42: checkcast       Lcom/viaversion/viaversion/protocols/protocol1_9to1_8/providers/EntityIdProvider;
        //    45: aload_2         /* lllllllllllllIIIlIllIllIlIllIIIl */
        //    46: invokevirtual   com/viaversion/viaversion/protocols/protocol1_9to1_8/providers/EntityIdProvider.getEntityId:(Lcom/viaversion/viaversion/api/connection/UserConnection;)I
        //    49: istore_3        /* lllllllllllllIIIlIllIllIlIllIlll */
        //    50: goto            56
        //    53: astore          lllllllllllllIIIlIllIllIlIllIllI
        //    55: return         
        //    56: aload_2         /* lllllllllllllIIIlIllIllIlIllIIIl */
        //    57: invokeinterface com/viaversion/viaversion/api/connection/UserConnection.getEntityTrackers:()Ljava/util/Collection;
        //    62: invokeinterface java/util/Collection.iterator:()Ljava/util/Iterator;
        //    67: astore          4
        //    69: aload           4
        //    71: invokeinterface java/util/Iterator.hasNext:()Z
        //    76: ifeq            102
        //    79: aload           4
        //    81: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    86: checkcast       Lcom/viaversion/viaversion/api/data/entity/EntityTracker;
        //    89: astore          lllllllllllllIIIlIllIllIlIllIlIl
        //    91: aload           lllllllllllllIIIlIllIllIlIllIlIl
        //    93: iload_3         /* lllllllllllllIIIlIllIllIlIllIIII */
        //    94: invokeinterface com/viaversion/viaversion/api/data/entity/EntityTracker.setClientEntityId:(I)V
        //    99: goto            69
        //   102: aload_2         /* lllllllllllllIIIlIllIllIlIllIIIl */
        //   103: invokeinterface com/viaversion/viaversion/api/connection/UserConnection.getStoredObjects:()Ljava/util/Map;
        //   108: invokeinterface java/util/Map.values:()Ljava/util/Collection;
        //   113: invokeinterface java/util/Collection.iterator:()Ljava/util/Iterator;
        //   118: astore          4
        //   120: aload           4
        //   122: invokeinterface java/util/Iterator.hasNext:()Z
        //   127: ifeq            164
        //   130: aload           4
        //   132: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   137: checkcast       Lcom/viaversion/viaversion/api/connection/StorableObject;
        //   140: astore          lllllllllllllIIIlIllIllIlIllIlII
        //   142: aload           lllllllllllllIIIlIllIllIlIllIlII
        //   144: instanceof      Lcom/viaversion/viaversion/api/data/entity/ClientEntityIdChangeListener;
        //   147: ifeq            161
        //   150: aload           lllllllllllllIIIlIllIllIlIllIlII
        //   152: checkcast       Lcom/viaversion/viaversion/api/data/entity/ClientEntityIdChangeListener;
        //   155: iload_3         /* lllllllllllllIIIlIllIllIlIllIIII */
        //   156: invokeinterface com/viaversion/viaversion/api/data/entity/ClientEntityIdChangeListener.setClientEntityId:(I)V
        //   161: goto            120
        //   164: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     50     53     56     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
