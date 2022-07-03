package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;

public class ConnectionData
{
    static /* synthetic */ Int2ObjectMap<String> idToKey;
    private static final /* synthetic */ BlockChangeRecord1_8[] EMPTY_RECORDS;
    public static /* synthetic */ BlockConnectionProvider blockConnectionProvider;
    static /* synthetic */ IntSet occludingStates;
    static /* synthetic */ Map<String, Integer> keyToId;
    static /* synthetic */ Int2ObjectMap<ConnectionHandler> connectionHandlerMap;
    static /* synthetic */ Int2ObjectMap<BlockData> blockConnectionData;
    
    public static boolean isWelcome(final int llllllllllllllIlllllIllIlIlIllll) {
        return ConnectionData.blockConnectionData.containsKey(llllllllllllllIlllllIllIlIlIllll) || ConnectionData.connectionHandlerMap.containsKey(llllllllllllllIlllllIllIlIlIllll);
    }
    
    public static int connect(final UserConnection llllllllllllllIlllllIllIlIlIIllI, final Position llllllllllllllIlllllIllIlIlIIlIl, final int llllllllllllllIlllllIllIlIlIIIII) {
        final ConnectionHandler llllllllllllllIlllllIllIlIlIIIll = ConnectionData.connectionHandlerMap.get(llllllllllllllIlllllIllIlIlIIIII);
        return (llllllllllllllIlllllIllIlIlIIIll != null) ? llllllllllllllIlllllIllIlIlIIIll.connect(llllllllllllllIlllllIllIlIlIIllI, llllllllllllllIlllllIllIlIlIIlIl, llllllllllllllIlllllIllIlIlIIIII) : llllllllllllllIlllllIllIlIlIIIII;
    }
    
    public static boolean needStoreBlocks() {
        return ConnectionData.blockConnectionProvider.storesBlocks();
    }
    
    public static int getId(final String llllllllllllllIlllllIllIlIIllIIl) {
        return ConnectionData.keyToId.getOrDefault(llllllllllllllIlllllIllIlIIllIIl, -1);
    }
    
    static {
        EMPTY_RECORDS = new BlockChangeRecord1_8[0];
        ConnectionData.idToKey = new Int2ObjectOpenHashMap<String>(8582, 1.0f);
        ConnectionData.keyToId = new HashMap<String, Integer>(8582, 1.0f);
        ConnectionData.connectionHandlerMap = new Int2ObjectOpenHashMap<ConnectionHandler>(1);
        ConnectionData.blockConnectionData = new Int2ObjectOpenHashMap<BlockData>(1);
        ConnectionData.occludingStates = new IntOpenHashSet(377, 1.0f);
    }
    
    public static boolean connects(final int llllllllllllllIlllllIllIlIlIllII) {
        return ConnectionData.connectionHandlerMap.containsKey(llllllllllllllIlllllIllIlIlIllII);
    }
    
    public static void updateBlock(final UserConnection llllllllllllllIlllllIlllIIllIIIl, final Position llllllllllllllIlllllIlllIIllIIII, final List<BlockChangeRecord1_8> llllllllllllllIlllllIlllIIlIlIIl) {
        final int llllllllllllllIlllllIlllIIlIlllI = ConnectionData.blockConnectionProvider.getBlockData(llllllllllllllIlllllIlllIIllIIIl, llllllllllllllIlllllIlllIIllIIII.getX(), llllllllllllllIlllllIlllIIllIIII.getY(), llllllllllllllIlllllIlllIIllIIII.getZ());
        final ConnectionHandler llllllllllllllIlllllIlllIIlIllIl = getConnectionHandler(llllllllllllllIlllllIlllIIlIlllI);
        if (llllllllllllllIlllllIlllIIlIllIl == null) {
            return;
        }
        final int llllllllllllllIlllllIlllIIlIllII = llllllllllllllIlllllIlllIIlIllIl.connect(llllllllllllllIlllllIlllIIllIIIl, llllllllllllllIlllllIlllIIllIIII, llllllllllllllIlllllIlllIIlIlllI);
        llllllllllllllIlllllIlllIIlIlIIl.add(new BlockChangeRecord1_8(llllllllllllllIlllllIlllIIllIIII.getX() & 0xF, llllllllllllllIlllllIlllIIllIIII.getY(), llllllllllllllIlllllIlllIIllIIII.getZ() & 0xF, llllllllllllllIlllllIlllIIlIllII));
    }
    
    public static void clearBlockStorage(final UserConnection llllllllllllllIlllllIlllIIIlIlII) {
        if (!needStoreBlocks()) {
            return;
        }
        ConnectionData.blockConnectionProvider.clearStorage(llllllllllllllIlllllIlllIIIlIlII);
    }
    
    public static void update(final UserConnection llllllllllllllIlllllIllllIIIIIII, final Position llllllllllllllIlllllIlllIlllllll) {
        final short llllllllllllllIlllllIlllIlllllII = (Object)BlockFace.values();
        final short llllllllllllllIlllllIlllIllllIll = (short)llllllllllllllIlllllIlllIlllllII.length;
        for (double llllllllllllllIlllllIlllIllllIlI = 0; llllllllllllllIlllllIlllIllllIlI < llllllllllllllIlllllIlllIllllIll; ++llllllllllllllIlllllIlllIllllIlI) {
            final BlockFace llllllllllllllIlllllIllllIIIIIIl = llllllllllllllIlllllIlllIlllllII[llllllllllllllIlllllIlllIllllIlI];
            final Position llllllllllllllIlllllIllllIIIIllI = llllllllllllllIlllllIlllIlllllll.getRelative(llllllllllllllIlllllIllllIIIIIIl);
            final int llllllllllllllIlllllIllllIIIIlIl = ConnectionData.blockConnectionProvider.getBlockData(llllllllllllllIlllllIllllIIIIIII, llllllllllllllIlllllIllllIIIIllI.getX(), llllllllllllllIlllllIllllIIIIllI.getY(), llllllllllllllIlllllIllllIIIIllI.getZ());
            final ConnectionHandler llllllllllllllIlllllIllllIIIIlII = ConnectionData.connectionHandlerMap.get(llllllllllllllIlllllIllllIIIIlIl);
            if (llllllllllllllIlllllIllllIIIIlII != null) {
                final int llllllllllllllIlllllIllllIIIIIll = llllllllllllllIlllllIllllIIIIlII.connect(llllllllllllllIlllllIllllIIIIIII, llllllllllllllIlllllIllllIIIIllI, llllllllllllllIlllllIllllIIIIlIl);
                final PacketWrapper llllllllllllllIlllllIllllIIIIIlI = PacketWrapper.create(ClientboundPackets1_13.BLOCK_CHANGE, null, llllllllllllllIlllllIllllIIIIIII);
                llllllllllllllIlllllIllllIIIIIlI.write(Type.POSITION, llllllllllllllIlllllIllllIIIIllI);
                llllllllllllllIlllllIllllIIIIIlI.write(Type.VAR_INT, llllllllllllllIlllllIllllIIIIIll);
                try {
                    llllllllllllllIlllllIllllIIIIIlI.send(Protocol1_13To1_12_2.class);
                }
                catch (Exception llllllllllllllIlllllIllllIIIIlll) {
                    llllllllllllllIlllllIllllIIIIlll.printStackTrace();
                }
            }
        }
    }
    
    public static void updateChunkSectionNeighbours(final UserConnection llllllllllllllIlllllIlllIlIIIlIl, final int llllllllllllllIlllllIlllIlIIlIII, final int llllllllllllllIlllllIlllIlIIIIll, final int llllllllllllllIlllllIlllIlIIIIlI) {
        for (int llllllllllllllIlllllIlllIlIIlIlI = -1; llllllllllllllIlllllIlllIlIIlIlI <= 1; ++llllllllllllllIlllllIlllIlIIlIlI) {
            for (int llllllllllllllIlllllIlllIlIIlIll = -1; llllllllllllllIlllllIlllIlIIlIll <= 1; ++llllllllllllllIlllllIlllIlIIlIll) {
                if (Math.abs(llllllllllllllIlllllIlllIlIIlIlI) + Math.abs(llllllllllllllIlllllIlllIlIIlIll) != 0) {
                    final List<BlockChangeRecord1_8> llllllllllllllIlllllIlllIlIIllII = new ArrayList<BlockChangeRecord1_8>();
                    if (Math.abs(llllllllllllllIlllllIlllIlIIlIlI) + Math.abs(llllllllllllllIlllllIlllIlIIlIll) == 2) {
                        for (int llllllllllllllIlllllIlllIllIIIlI = llllllllllllllIlllllIlllIlIIIIlI * 16; llllllllllllllIlllllIlllIllIIIlI < llllllllllllllIlllllIlllIlIIIIlI * 16 + 16; ++llllllllllllllIlllllIlllIllIIIlI) {
                            final int llllllllllllllIlllllIlllIllIIlII = (llllllllllllllIlllllIlllIlIIlIlI == 1) ? 0 : 15;
                            final int llllllllllllllIlllllIlllIllIIIll = (llllllllllllllIlllllIlllIlIIlIll == 1) ? 0 : 15;
                            updateBlock(llllllllllllllIlllllIlllIlIIIlIl, new Position((llllllllllllllIlllllIlllIlIIlIII + llllllllllllllIlllllIlllIlIIlIlI << 4) + llllllllllllllIlllllIlllIllIIlII, (short)llllllllllllllIlllllIlllIllIIIlI, (llllllllllllllIlllllIlllIlIIIIll + llllllllllllllIlllllIlllIlIIlIll << 4) + llllllllllllllIlllllIlllIllIIIll), llllllllllllllIlllllIlllIlIIllII);
                        }
                    }
                    else {
                        for (int llllllllllllllIlllllIlllIlIIllll = llllllllllllllIlllllIlllIlIIIIlI * 16; llllllllllllllIlllllIlllIlIIllll < llllllllllllllIlllllIlllIlIIIIlI * 16 + 16; ++llllllllllllllIlllllIlllIlIIllll) {
                            int llllllllllllllIlllllIlllIlIlIIll = 0;
                            int llllllllllllllIlllllIlllIlIlIIlI = 0;
                            int llllllllllllllIlllllIlllIlIlIIIl = 0;
                            int llllllllllllllIlllllIlllIlIlIIII = 0;
                            if (llllllllllllllIlllllIlllIlIIlIlI == 1) {
                                final int llllllllllllllIlllllIlllIllIIIIl = 0;
                                final int llllllllllllllIlllllIlllIllIIIII = 2;
                                final int llllllllllllllIlllllIlllIlIlllll = 0;
                                final int llllllllllllllIlllllIlllIlIllllI = 16;
                            }
                            else if (llllllllllllllIlllllIlllIlIIlIlI == -1) {
                                final int llllllllllllllIlllllIlllIlIlllIl = 14;
                                final int llllllllllllllIlllllIlllIlIlllII = 16;
                                final int llllllllllllllIlllllIlllIlIllIll = 0;
                                final int llllllllllllllIlllllIlllIlIllIlI = 16;
                            }
                            else if (llllllllllllllIlllllIlllIlIIlIll == 1) {
                                final int llllllllllllllIlllllIlllIlIllIIl = 0;
                                final int llllllllllllllIlllllIlllIlIllIII = 16;
                                final int llllllllllllllIlllllIlllIlIlIlll = 0;
                                final int llllllllllllllIlllllIlllIlIlIllI = 2;
                            }
                            else {
                                llllllllllllllIlllllIlllIlIlIIll = 0;
                                llllllllllllllIlllllIlllIlIlIIlI = 16;
                                llllllllllllllIlllllIlllIlIlIIIl = 14;
                                llllllllllllllIlllllIlllIlIlIIII = 16;
                            }
                            for (int llllllllllllllIlllllIlllIlIlIlII = llllllllllllllIlllllIlllIlIlIIll; llllllllllllllIlllllIlllIlIlIlII < llllllllllllllIlllllIlllIlIlIIlI; ++llllllllllllllIlllllIlllIlIlIlII) {
                                for (int llllllllllllllIlllllIlllIlIlIlIl = llllllllllllllIlllllIlllIlIlIIIl; llllllllllllllIlllllIlllIlIlIlIl < llllllllllllllIlllllIlllIlIlIIII; ++llllllllllllllIlllllIlllIlIlIlIl) {
                                    updateBlock(llllllllllllllIlllllIlllIlIIIlIl, new Position((llllllllllllllIlllllIlllIlIIlIII + llllllllllllllIlllllIlllIlIIlIlI << 4) + llllllllllllllIlllllIlllIlIlIlII, (short)llllllllllllllIlllllIlllIlIIllll, (llllllllllllllIlllllIlllIlIIIIll + llllllllllllllIlllllIlllIlIIlIll << 4) + llllllllllllllIlllllIlllIlIlIlIl), llllllllllllllIlllllIlllIlIIllII);
                                }
                            }
                        }
                    }
                    if (!llllllllllllllIlllllIlllIlIIllII.isEmpty()) {
                        final PacketWrapper llllllllllllllIlllllIlllIlIIllIl = PacketWrapper.create(ClientboundPackets1_13.MULTI_BLOCK_CHANGE, null, llllllllllllllIlllllIlllIlIIIlIl);
                        llllllllllllllIlllllIlllIlIIllIl.write(Type.INT, llllllllllllllIlllllIlllIlIIlIII + llllllllllllllIlllllIlllIlIIlIlI);
                        llllllllllllllIlllllIlllIlIIllIl.write(Type.INT, llllllllllllllIlllllIlllIlIIIIll + llllllllllllllIlllllIlllIlIIlIll);
                        llllllllllllllIlllllIlllIlIIllIl.write(Type.BLOCK_CHANGE_RECORD_ARRAY, llllllllllllllIlllllIlllIlIIllII.toArray(ConnectionData.EMPTY_RECORDS));
                        try {
                            llllllllllllllIlllllIlllIlIIllIl.send(Protocol1_13To1_12_2.class);
                        }
                        catch (Exception llllllllllllllIlllllIlllIlIIlllI) {
                            llllllllllllllIlllllIlllIlIIlllI.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    public static ConnectionHandler getConnectionHandler(final int llllllllllllllIlllllIllIlIIlllII) {
        return ConnectionData.connectionHandlerMap.get(llllllllllllllIlllllIllIlIIlllII);
    }
    
    public static void init() {
        if (!Via.getConfig().isServersideBlockConnections()) {
            return;
        }
        Via.getPlatform().getLogger().info("Loading block connection mappings ...");
        final JsonObject llllllllllllllIlllllIllIllIIIllI = MappingDataLoader.loadData("mapping-1.13.json", true);
        final JsonObject llllllllllllllIlllllIllIllIIIlIl = llllllllllllllIlllllIllIllIIIllI.getAsJsonObject("blockstates");
        for (final Map.Entry<String, JsonElement> llllllllllllllIlllllIllIllIlIlIl : llllllllllllllIlllllIllIllIIIlIl.entrySet()) {
            final int llllllllllllllIlllllIllIllIlIlll = Integer.parseInt(llllllllllllllIlllllIllIllIlIlIl.getKey());
            final String llllllllllllllIlllllIllIllIlIllI = llllllllllllllIlllllIllIllIlIlIl.getValue().getAsString();
            ConnectionData.idToKey.put(llllllllllllllIlllllIllIllIlIlll, llllllllllllllIlllllIllIllIlIllI);
            ConnectionData.keyToId.put(llllllllllllllIlllllIllIllIlIllI, llllllllllllllIlllllIllIllIlIlll);
        }
        ConnectionData.connectionHandlerMap = new Int2ObjectOpenHashMap<ConnectionHandler>(3650, 1.0f);
        if (!Via.getConfig().isReduceBlockStorageMemory()) {
            ConnectionData.blockConnectionData = new Int2ObjectOpenHashMap<BlockData>(1146, 1.0f);
            final JsonObject llllllllllllllIlllllIllIllIIlIll = MappingDataLoader.loadData("blockConnections.json");
            for (final Map.Entry<String, JsonElement> llllllllllllllIlllllIllIllIIllII : llllllllllllllIlllllIllIllIIlIll.entrySet()) {
                final int llllllllllllllIlllllIllIllIIlllI = ConnectionData.keyToId.get(llllllllllllllIlllllIllIllIIllII.getKey());
                final BlockData llllllllllllllIlllllIllIllIIllIl = new BlockData();
                for (final Map.Entry<String, JsonElement> llllllllllllllIlllllIllIllIIllll : llllllllllllllIlllllIllIllIIllII.getValue().getAsJsonObject().entrySet()) {
                    final String llllllllllllllIlllllIllIllIlIIlI = llllllllllllllIlllllIllIllIIllll.getKey();
                    final JsonObject llllllllllllllIlllllIllIllIlIIIl = llllllllllllllIlllllIllIllIIllll.getValue().getAsJsonObject();
                    final boolean[] llllllllllllllIlllllIllIllIlIIII = new boolean[6];
                    final boolean llllllllllllllIlllllIllIlIllIlIl = (Object)BlockFace.values();
                    for (boolean llllllllllllllIlllllIllIlIllIlII = llllllllllllllIlllllIllIlIllIlIl.length != 0, llllllllllllllIlllllIllIlIllIIll = false; llllllllllllllIlllllIllIlIllIIll < llllllllllllllIlllllIllIlIllIlII; ++llllllllllllllIlllllIllIlIllIIll) {
                        final BlockFace llllllllllllllIlllllIllIllIlIIll = llllllllllllllIlllllIllIlIllIlIl[llllllllllllllIlllllIllIlIllIIll];
                        final String llllllllllllllIlllllIllIllIlIlII = llllllllllllllIlllllIllIllIlIIll.toString().toLowerCase(Locale.ROOT);
                        if (llllllllllllllIlllllIllIllIlIIIl.has(llllllllllllllIlllllIllIllIlIlII)) {
                            llllllllllllllIlllllIllIllIlIIII[llllllllllllllIlllllIllIllIlIIll.ordinal()] = llllllllllllllIlllllIllIllIlIIIl.getAsJsonPrimitive(llllllllllllllIlllllIllIllIlIlII).getAsBoolean();
                        }
                    }
                    llllllllllllllIlllllIllIllIIllIl.put(llllllllllllllIlllllIllIllIlIIlI, llllllllllllllIlllllIllIllIlIIII);
                }
                if (llllllllllllllIlllllIllIllIIllII.getKey().contains("stairs")) {
                    llllllllllllllIlllllIllIllIIllIl.put("allFalseIfStairPre1_12", new boolean[6]);
                }
                ConnectionData.blockConnectionData.put(llllllllllllllIlllllIllIllIIlllI, llllllllllllllIlllllIllIllIIllIl);
            }
        }
        final JsonObject llllllllllllllIlllllIllIllIIIlII = MappingDataLoader.loadData("blockData.json");
        final JsonArray llllllllllllllIlllllIllIllIIIIll = llllllllllllllIlllllIllIllIIIlII.getAsJsonArray("occluding");
        for (final JsonElement llllllllllllllIlllllIllIllIIlIlI : llllllllllllllIlllllIllIllIIIIll) {
            ConnectionData.occludingStates.add((int)ConnectionData.keyToId.get(llllllllllllllIlllllIllIllIIlIlI.getAsString()));
        }
        final List<ConnectorInitAction> llllllllllllllIlllllIllIllIIIIlI = new ArrayList<ConnectorInitAction>();
        llllllllllllllIlllllIllIllIIIIlI.add(PumpkinConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.addAll(BasicFenceConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(NetherFenceConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.addAll(WallConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(MelonConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.addAll(GlassConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(ChestConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(DoorConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(RedstoneConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(StairConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(FlowerConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.addAll(ChorusPlantConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(TripwireConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(SnowyGrassConnectionHandler.init());
        llllllllllllllIlllllIllIllIIIIlI.add(FireConnectionHandler.init());
        if (Via.getConfig().isVineClimbFix()) {
            llllllllllllllIlllllIllIllIIIIlI.add(VineConnectionHandler.init());
        }
        for (final String llllllllllllllIlllllIllIllIIIlll : ConnectionData.keyToId.keySet()) {
            final WrappedBlockData llllllllllllllIlllllIllIllIIlIII = WrappedBlockData.fromString(llllllllllllllIlllllIllIllIIIlll);
            for (final ConnectorInitAction llllllllllllllIlllllIllIllIIlIIl : llllllllllllllIlllllIllIllIIIIlI) {
                llllllllllllllIlllllIllIllIIlIIl.check(llllllllllllllIlllllIllIllIIlIII);
            }
        }
        if (Via.getConfig().getBlockConnectionMethod().equalsIgnoreCase("packet")) {
            ConnectionData.blockConnectionProvider = new PacketBlockConnectionProvider();
            Via.getManager().getProviders().register(BlockConnectionProvider.class, ConnectionData.blockConnectionProvider);
        }
    }
    
    public static void connectBlocks(final UserConnection llllllllllllllIlllllIllIlllllIlI, final Chunk llllllllllllllIlllllIllIlllllIIl) {
        final long llllllllllllllIlllllIllIlllllIII = llllllllllllllIlllllIllIlllllIIl.getX() << 4;
        final long llllllllllllllIlllllIllIllllIlll = llllllllllllllIlllllIllIlllllIIl.getZ() << 4;
        for (int llllllllllllllIlllllIllIlllllIll = 0; llllllllllllllIlllllIllIlllllIll < llllllllllllllIlllllIllIlllllIIl.getSections().length; ++llllllllllllllIlllllIllIlllllIll) {
            final ChunkSection llllllllllllllIlllllIllIlllllllI = llllllllllllllIlllllIllIlllllIIl.getSections()[llllllllllllllIlllllIllIlllllIll];
            if (llllllllllllllIlllllIllIlllllllI != null) {
                boolean llllllllllllllIlllllIllIllllllIl = false;
                for (int llllllllllllllIlllllIlllIIIIIlII = 0; llllllllllllllIlllllIlllIIIIIlII < llllllllllllllIlllllIllIlllllllI.getPaletteSize(); ++llllllllllllllIlllllIlllIIIIIlII) {
                    final int llllllllllllllIlllllIlllIIIIIlIl = llllllllllllllIlllllIllIlllllllI.getPaletteEntry(llllllllllllllIlllllIlllIIIIIlII);
                    if (connects(llllllllllllllIlllllIlllIIIIIlIl)) {
                        llllllllllllllIlllllIllIllllllIl = true;
                        break;
                    }
                }
                if (llllllllllllllIlllllIllIllllllIl) {
                    final long llllllllllllllIlllllIllIllllllII = llllllllllllllIlllllIllIlllllIll << 4;
                    for (int llllllllllllllIlllllIllIllllllll = 0; llllllllllllllIlllllIllIllllllll < 16; ++llllllllllllllIlllllIllIllllllll) {
                        for (int llllllllllllllIlllllIlllIIIIIIII = 0; llllllllllllllIlllllIlllIIIIIIII < 16; ++llllllllllllllIlllllIlllIIIIIIII) {
                            for (int llllllllllllllIlllllIlllIIIIIIIl = 0; llllllllllllllIlllllIlllIIIIIIIl < 16; ++llllllllllllllIlllllIlllIIIIIIIl) {
                                int llllllllllllllIlllllIlllIIIIIIll = llllllllllllllIlllllIllIlllllllI.getFlatBlock(llllllllllllllIlllllIlllIIIIIIIl, llllllllllllllIlllllIllIllllllll, llllllllllllllIlllllIlllIIIIIIII);
                                final ConnectionHandler llllllllllllllIlllllIlllIIIIIIlI = getConnectionHandler(llllllllllllllIlllllIlllIIIIIIll);
                                if (llllllllllllllIlllllIlllIIIIIIlI != null) {
                                    llllllllllllllIlllllIlllIIIIIIll = llllllllllllllIlllllIlllIIIIIIlI.connect(llllllllllllllIlllllIllIlllllIlI, new Position((int)(llllllllllllllIlllllIllIlllllIII + llllllllllllllIlllllIlllIIIIIIIl), (short)(llllllllllllllIlllllIllIllllllII + llllllllllllllIlllllIllIllllllll), (int)(llllllllllllllIlllllIllIllllIlll + llllllllllllllIlllllIlllIIIIIIII)), llllllllllllllIlllllIlllIIIIIIll);
                                    llllllllllllllIlllllIllIlllllllI.setFlatBlock(llllllllllllllIlllllIlllIIIIIIIl, llllllllllllllIlllllIllIllllllll, llllllllllllllIlllllIlllIIIIIIII, llllllllllllllIlllllIlllIIIIIIll);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void updateBlockStorage(final UserConnection llllllllllllllIlllllIlllIIIllIll, final int llllllllllllllIlllllIlllIIIllIlI, final int llllllllllllllIlllllIlllIIIllllI, final int llllllllllllllIlllllIlllIIIllIII, final int llllllllllllllIlllllIlllIIIlllII) {
        if (!needStoreBlocks()) {
            return;
        }
        if (isWelcome(llllllllllllllIlllllIlllIIIlllII)) {
            ConnectionData.blockConnectionProvider.storeBlock(llllllllllllllIlllllIlllIIIllIll, llllllllllllllIlllllIlllIIIllIlI, llllllllllllllIlllllIlllIIIllllI, llllllllllllllIlllllIlllIIIllIII, llllllllllllllIlllllIlllIIIlllII);
        }
        else {
            ConnectionData.blockConnectionProvider.removeBlock(llllllllllllllIlllllIlllIIIllIll, llllllllllllllIlllllIlllIIIllIlI, llllllllllllllIlllllIlllIIIllllI, llllllllllllllIlllllIlllIIIllIII);
        }
    }
    
    public static String getKey(final int llllllllllllllIlllllIllIlIIlIllI) {
        return ConnectionData.idToKey.get(llllllllllllllIlllllIllIlIIlIllI);
    }
    
    @FunctionalInterface
    interface ConnectorInitAction
    {
        void check(final WrappedBlockData p0);
    }
}
