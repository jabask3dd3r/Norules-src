package com.viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.chat.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;

public class PlayerPackets
{
    public static void register(final Protocol1_9To1_8 llllIIllIlIIIl) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIIllIlIlIIIlIlII) throws Exception {
                        try {
                            final JsonObject llllllllllllllllIIllIlIlIIIllIII = llllllllllllllllIIllIlIlIIIlIlII.get((Type<JsonObject>)Type.COMPONENT, 0);
                            ChatRewriter.toClient(llllllllllllllllIIllIlIlIIIllIII, llllllllllllllllIIllIlIlIIIlIlII.user());
                        }
                        catch (Exception llllllllllllllllIIllIlIlIIIlIlll) {
                            llllllllllllllllIIllIlIlIIIlIlll.printStackTrace();
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.TAB_LIST, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.DISCONNECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.TITLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIIlIlIlIIIIlIIll) throws Exception {
                        final int llllllllllllllllIIlIlIlIIIIlIIlI = llllllllllllllllIIlIlIlIIIIlIIll.get((Type<Integer>)Type.VAR_INT, 0);
                        if (llllllllllllllllIIlIlIlIIIIlIIlI == 0 || llllllllllllllllIIlIlIlIIIIlIIlI == 1) {
                            Protocol1_9To1_8.FIX_JSON.write(llllllllllllllllIIlIlIlIIIIlIIll, llllllllllllllllIIlIlIlIIIIlIIll.read(Type.STRING));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIlIIIIllIlIlIll) {
                        lllllllllllllIllIIlIIIIllIlIlIll.write(Type.VAR_INT, 0);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.TEAMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIIIllIlIIIlIIIl) throws Exception {
                        final byte lllllllllllllllllIIIllIlIIIIlllI = lllllllllllllllllIIIllIlIIIlIIIl.get((Type<Byte>)Type.BYTE, 0);
                        if (lllllllllllllllllIIIllIlIIIIlllI == 0 || lllllllllllllllllIIIllIlIIIIlllI == 2) {
                            lllllllllllllllllIIIllIlIIIlIIIl.passthrough(Type.STRING);
                            lllllllllllllllllIIIllIlIIIlIIIl.passthrough(Type.STRING);
                            lllllllllllllllllIIIllIlIIIlIIIl.passthrough(Type.STRING);
                            lllllllllllllllllIIIllIlIIIlIIIl.passthrough((Type<Object>)Type.BYTE);
                            lllllllllllllllllIIIllIlIIIlIIIl.passthrough(Type.STRING);
                            lllllllllllllllllIIIllIlIIIlIIIl.write(Type.STRING, Via.getConfig().isPreventCollision() ? "never" : "");
                            lllllllllllllllllIIIllIlIIIlIIIl.passthrough((Type<Object>)Type.BYTE);
                        }
                        if (lllllllllllllllllIIIllIlIIIIlllI == 0 || lllllllllllllllllIIIllIlIIIIlllI == 3 || lllllllllllllllllIIIllIlIIIIlllI == 4) {
                            final String[] lllllllllllllllllIIIllIlIIIlllII = lllllllllllllllllIIIllIlIIIlIIIl.passthrough(Type.STRING_ARRAY);
                            final EntityTracker1_9 lllllllllllllllllIIIllIlIIIllIll = lllllllllllllllllIIIllIlIIIlIIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                            final String lllllllllllllllllIIIllIlIIIllIlI = lllllllllllllllllIIIllIlIIIlIIIl.user().getProtocolInfo().getUsername();
                            final String lllllllllllllllllIIIllIlIIIllIII = lllllllllllllllllIIIllIlIIIlIIIl.get(Type.STRING, 0);
                            final long lllllllllllllllllIIIllIlIIIIIlll = (Object)lllllllllllllllllIIIllIlIIIlllII;
                            final byte lllllllllllllllllIIIllIlIIIIIllI = (byte)lllllllllllllllllIIIllIlIIIIIlll.length;
                            for (String lllllllllllllllllIIIllIlIIIIIlIl = (String)0; lllllllllllllllllIIIllIlIIIIIlIl < lllllllllllllllllIIIllIlIIIIIllI; ++lllllllllllllllllIIIllIlIIIIIlIl) {
                                final String lllllllllllllllllIIIllIlIIIlllIl = lllllllllllllllllIIIllIlIIIIIlll[lllllllllllllllllIIIllIlIIIIIlIl];
                                if (lllllllllllllllllIIIllIlIIIllIll.isAutoTeam() && lllllllllllllllllIIIllIlIIIlllIl.equalsIgnoreCase(lllllllllllllllllIIIllIlIIIllIlI)) {
                                    if (lllllllllllllllllIIIllIlIIIIlllI == 4) {
                                        lllllllllllllllllIIIllIlIIIlIIIl.send(Protocol1_9To1_8.class);
                                        lllllllllllllllllIIIllIlIIIlIIIl.cancel();
                                        lllllllllllllllllIIIllIlIIIllIll.sendTeamPacket(true, true);
                                        lllllllllllllllllIIIllIlIIIllIll.setCurrentTeam("viaversion");
                                    }
                                    else {
                                        lllllllllllllllllIIIllIlIIIllIll.sendTeamPacket(false, true);
                                        lllllllllllllllllIIIllIlIIIllIll.setCurrentTeam(lllllllllllllllllIIIllIlIIIllIII);
                                    }
                                }
                            }
                        }
                        if (lllllllllllllllllIIIllIlIIIIlllI == 1) {
                            final EntityTracker1_9 lllllllllllllllllIIIllIlIIIlIllI = lllllllllllllllllIIIllIlIIIlIIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                            final String lllllllllllllllllIIIllIlIIIlIlIl = lllllllllllllllllIIIllIlIIIlIIIl.get(Type.STRING, 0);
                            if (lllllllllllllllllIIIllIlIIIlIllI.isAutoTeam() && lllllllllllllllllIIIllIlIIIlIlIl.equals(lllllllllllllllllIIIllIlIIIlIllI.getCurrentTeam())) {
                                lllllllllllllllllIIIllIlIIIlIIIl.send(Protocol1_9To1_8.class);
                                lllllllllllllllllIIIllIlIIIlIIIl.cancel();
                                lllllllllllllllllIIIllIlIIIlIllI.sendTeamPacket(true, true);
                                lllllllllllllllllIIIllIlIIIlIllI.setCurrentTeam("viaversion");
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlllIlIlllllllIIl) throws Exception {
                        final int llllllllllllllIIlllIlIlllllllIll = llllllllllllllIIlllIlIlllllllIIl.get((Type<Integer>)Type.INT, 0);
                        final EntityTracker1_9 llllllllllllllIIlllIlIlllllllIlI = llllllllllllllIIlllIlIlllllllIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        llllllllllllllIIlllIlIlllllllIlI.addEntity(llllllllllllllIIlllIlIlllllllIll, Entity1_10Types.EntityType.PLAYER);
                        llllllllllllllIIlllIlIlllllllIlI.setClientEntityId(llllllllllllllIIlllIlIlllllllIll);
                    }
                });
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllllIIlllIIIlIIllI) throws Exception {
                        final EntityTracker1_9 lllllllllllllIllllIIlllIIIlIIlll = lllllllllllllIllllIIlllIIIlIIllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIllllIIlllIIIlIIlll.setGameMode(GameMode.getById(lllllllllllllIllllIIlllIIIlIIllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0)));
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlllIIIIIlIlIlII) throws Exception {
                        final CommandBlockProvider lllllllllllllIIIIlllIIIIIlIlIlIl = Via.getManager().getProviders().get(CommandBlockProvider.class);
                        lllllllllllllIIIIlllIIIIIlIlIlIl.sendPermission(lllllllllllllIIIIlllIIIIIlIlIlII.user());
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIlIIIIlIIlIIllll) throws Exception {
                        final EntityTracker1_9 lllllllllllllIlIIlIIIIlIIlIIlllI = lllllllllllllIlIIlIIIIlIIlIIllll.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (Via.getConfig().isAutoTeam()) {
                            lllllllllllllIlIIlIIIIlIIlIIlllI.setAutoTeam(true);
                            lllllllllllllIlIIlIIIIlIIlIIllll.send(Protocol1_9To1_8.class);
                            lllllllllllllIlIIlIIIIlIIlIIllll.cancel();
                            lllllllllllllIlIIlIIIIlIIlIIlllI.sendTeamPacket(true, true);
                            lllllllllllllIlIIlIIIIlIIlIIlllI.setCurrentTeam("viaversion");
                        }
                        else {
                            lllllllllllllIlIIlIIIIlIIlIIlllI.setAutoTeam(false);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.PLAYER_INFO, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllllllIlllIIllllII) throws Exception {
                        final int lllllllllllllIllllllIlllIIlllllI = lllllllllllllIllllllIlllIIllllII.get((Type<Integer>)Type.VAR_INT, 0);
                        for (int lllllllllllllIllllllIlllIIllllIl = lllllllllllllIllllllIlllIIllllII.get((Type<Integer>)Type.VAR_INT, 1), lllllllllllllIllllllIlllIlIIIIIl = 0; lllllllllllllIllllllIlllIlIIIIIl < lllllllllllllIllllllIlllIIllllIl; ++lllllllllllllIllllllIlllIlIIIIIl) {
                            lllllllllllllIllllllIlllIIllllII.passthrough(Type.UUID);
                            if (lllllllllllllIllllllIlllIIlllllI == 0) {
                                lllllllllllllIllllllIlllIIllllII.passthrough(Type.STRING);
                                for (int lllllllllllllIllllllIlllIlIIIlII = lllllllllllllIllllllIlllIIllllII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIllllllIlllIlIIIlIl = 0; lllllllllllllIllllllIlllIlIIIlIl < lllllllllllllIllllllIlllIlIIIlII; ++lllllllllllllIllllllIlllIlIIIlIl) {
                                    lllllllllllllIllllllIlllIIllllII.passthrough(Type.STRING);
                                    lllllllllllllIllllllIlllIIllllII.passthrough(Type.STRING);
                                    final boolean lllllllllllllIllllllIlllIlIIIllI = lllllllllllllIllllllIlllIIllllII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                    if (lllllllllllllIllllllIlllIlIIIllI) {
                                        lllllllllllllIllllllIlllIIllllII.passthrough(Type.STRING);
                                    }
                                }
                                lllllllllllllIllllllIlllIIllllII.passthrough((Type<Object>)Type.VAR_INT);
                                lllllllllllllIllllllIlllIIllllII.passthrough((Type<Object>)Type.VAR_INT);
                                final boolean lllllllllllllIllllllIlllIlIIIIll = lllllllllllllIllllllIlllIIllllII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIllllllIlllIlIIIIll) {
                                    Protocol1_9To1_8.FIX_JSON.write(lllllllllllllIllllllIlllIIllllII, lllllllllllllIllllllIlllIIllllII.read(Type.STRING));
                                }
                            }
                            else if (lllllllllllllIllllllIlllIIlllllI == 1 || lllllllllllllIllllllIlllIIlllllI == 2) {
                                lllllllllllllIllllllIlllIIllllII.passthrough((Type<Object>)Type.VAR_INT);
                            }
                            else if (lllllllllllllIllllllIlllIIlllllI == 3) {
                                final boolean lllllllllllllIllllllIlllIlIIIIlI = lllllllllllllIllllllIlllIIllllII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIllllllIlllIlIIIIlI) {
                                    Protocol1_9To1_8.FIX_JSON.write(lllllllllllllIllllllIlllIIllllII, lllllllllllllIllllllIlllIIllllII.read(Type.STRING));
                                }
                            }
                            else if (lllllllllllllIllllllIlllIIlllllI == 4) {}
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlllIIllIllIlIIlIl) throws Exception {
                        final String llllllllllllllIlllIIllIllIlIIllI = llllllllllllllIlllIIllIllIlIIlIl.get(Type.STRING, 0);
                        if (llllllllllllllIlllIIllIllIlIIllI.equalsIgnoreCase("MC|BOpen")) {
                            llllllllllllllIlllIIllIllIlIIlIl.read(Type.REMAINING_BYTES);
                            llllllllllllllIlllIIllIllIlIIlIl.write(Type.VAR_INT, 0);
                        }
                        if (llllllllllllllIlllIIllIllIlIIllI.equalsIgnoreCase("MC|TrList")) {
                            llllllllllllllIlllIIllIllIlIIlIl.passthrough((Type<Object>)Type.INT);
                            final Short llllllllllllllIlllIIllIllIlIlIIl = llllllllllllllIlllIIllIllIlIIlIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                            for (int llllllllllllllIlllIIllIllIlIlIlI = 0; llllllllllllllIlllIIllIllIlIlIlI < llllllllllllllIlllIIllIllIlIlIIl; ++llllllllllllllIlllIIllIllIlIlIlI) {
                                final Item llllllllllllllIlllIIllIllIlIllIl = llllllllllllllIlllIIllIllIlIIlIl.passthrough(Type.ITEM);
                                ItemRewriter.toClient(llllllllllllllIlllIIllIllIlIllIl);
                                final Item llllllllllllllIlllIIllIllIlIllII = llllllllllllllIlllIIllIllIlIIlIl.passthrough(Type.ITEM);
                                ItemRewriter.toClient(llllllllllllllIlllIIllIllIlIllII);
                                final boolean llllllllllllllIlllIIllIllIlIlIll = llllllllllllllIlllIIllIllIlIIlIl.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (llllllllllllllIlllIIllIllIlIlIll) {
                                    final Item llllllllllllllIlllIIllIllIlIlllI = llllllllllllllIlllIIllIllIlIIlIl.passthrough(Type.ITEM);
                                    ItemRewriter.toClient(llllllllllllllIlllIIllIllIlIlllI);
                                }
                                llllllllllllllIlllIIllIllIlIIlIl.passthrough((Type<Object>)Type.BOOLEAN);
                                llllllllllllllIlllIIllIllIlIIlIl.passthrough((Type<Object>)Type.INT);
                                llllllllllllllIlllIIllIllIlIIlIl.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.UPDATE_HEALTH, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIIIIIIIIIIlIIl) throws Exception {
                        final float lllllllllllllIIIIlIIIIIIIIIIlIlI = lllllllllllllIIIIlIIIIIIIIIIlIIl.get((Type<Float>)Type.FLOAT, 0);
                        if (lllllllllllllIIIIlIIIIIIIIIIlIlI <= 0.0f) {
                            final ClientChunks lllllllllllllIIIIlIIIIIIIIIIllIl = lllllllllllllIIIIlIIIIIIIIIIlIIl.user().get(ClientChunks.class);
                            lllllllllllllIIIIlIIIIIIIIIIllIl.getBulkChunks().clear();
                            lllllllllllllIIIIlIIIIIIIIIIllIl.getLoadedChunks().clear();
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIllIlIIlIlIIlIl) throws Exception {
                        final ClientChunks lllllllllllllIIllIllIlIIlIlIlIII = lllllllllllllIIllIllIlIIlIlIIlIl.user().get(ClientChunks.class);
                        lllllllllllllIIllIllIlIIlIlIlIII.getBulkChunks().clear();
                        lllllllllllllIIllIllIlIIlIlIlIII.getLoadedChunks().clear();
                        final int lllllllllllllIIllIllIlIIlIlIIlll = lllllllllllllIIllIllIlIIlIlIIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final EntityTracker1_9 lllllllllllllIIllIllIlIIlIlIIllI = lllllllllllllIIllIllIlIIlIlIIlIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIIllIllIlIIlIlIIllI.setGameMode(GameMode.getById(lllllllllllllIIllIllIlIIlIlIIlll));
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlllIlIlllIlIlll) throws Exception {
                        final CommandBlockProvider lllllllllllllllIIlllIlIlllIllIII = Via.getManager().getProviders().get(CommandBlockProvider.class);
                        lllllllllllllllIIlllIlIlllIllIII.sendPermission(lllllllllllllllIIlllIlIlllIlIlll.user());
                        lllllllllllllllIIlllIlIlllIllIII.unloadChunks(lllllllllllllllIIlllIlIlllIlIlll.user());
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).registerClientbound(ClientboundPackets1_8.GAME_EVENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLOAT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIllIlllIIIlIlIll) throws Exception {
                        if (lllllllllllllIIIIllIlllIIIlIlIll.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 3) {
                            final int lllllllllllllIIIIllIlllIIIlIllll = lllllllllllllIIIIllIlllIIIlIlIll.get((Type<Float>)Type.FLOAT, 0).intValue();
                            final EntityTracker1_9 lllllllllllllIIIIllIlllIIIlIlllI = lllllllllllllIIIIllIlllIIIlIlIll.user().getEntityTracker(Protocol1_9To1_8.class);
                            lllllllllllllIIIIllIlllIIIlIlllI.setGameMode(GameMode.getById(lllllllllllllIIIIllIlllIIIlIllll));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllIIllIlIIIl).cancelClientbound(ClientboundPackets1_8.SET_COMPRESSION);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BOOLEAN, Type.NOTHING);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.CLIENT_SETTINGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT, Type.BYTE);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllllllllllllIIllI) throws Exception {
                        final int lllllllllllllllllllllllllllIIlIl = lllllllllllllllllllllllllllIIllI.read((Type<Integer>)Type.VAR_INT);
                        if (Via.getConfig().isLeftHandedHandling() && lllllllllllllllllllllllllllIIlIl == 0) {
                            lllllllllllllllllllllllllllIIllI.set(Type.UNSIGNED_BYTE, 0, (short)(lllllllllllllllllllllllllllIIllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0) | 0x80));
                        }
                        lllllllllllllllllllllllllllIIllI.sendToServer(Protocol1_9To1_8.class);
                        lllllllllllllllllllllllllllIIllI.cancel();
                        Via.getManager().getProviders().get(MainHandProvider.class).setMainHand(lllllllllllllllllllllllllllIIllI.user(), lllllllllllllllllllllllllllIIlIl);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.NOTHING);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).cancelServerbound(ServerboundPackets1_9.TELEPORT_CONFIRM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).cancelServerbound(ServerboundPackets1_9.VEHICLE_MOVE);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).cancelServerbound(ServerboundPackets1_9.STEER_BOAT);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlllIIllllIIIlII) throws Exception {
                        final String lllllllllllllllIIlllIIllllIIIlIl = lllllllllllllllIIlllIIllllIIIlII.get(Type.STRING, 0);
                        if (lllllllllllllllIIlllIIllllIIIlIl.equalsIgnoreCase("MC|BSign")) {
                            final Item lllllllllllllllIIlllIIllllIIlIII = lllllllllllllllIIlllIIllllIIIlII.passthrough(Type.ITEM);
                            if (lllllllllllllllIIlllIIllllIIlIII != null) {
                                lllllllllllllllIIlllIIllllIIlIII.setIdentifier(387);
                                ItemRewriter.rewriteBookToServer(lllllllllllllllIIlllIIllllIIlIII);
                            }
                        }
                        if (lllllllllllllllIIlllIIllllIIIlIl.equalsIgnoreCase("MC|AutoCmd")) {
                            lllllllllllllllIIlllIIllllIIIlII.set(Type.STRING, 0, "MC|AdvCdm");
                            lllllllllllllllIIlllIIllllIIIlII.write(Type.BYTE, (Byte)0);
                            lllllllllllllllIIlllIIllllIIIlII.passthrough((Type<Object>)Type.INT);
                            lllllllllllllllIIlllIIllllIIIlII.passthrough((Type<Object>)Type.INT);
                            lllllllllllllllIIlllIIllllIIIlII.passthrough((Type<Object>)Type.INT);
                            lllllllllllllllIIlllIIllllIIIlII.passthrough(Type.STRING);
                            lllllllllllllllIIlllIIllllIIIlII.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllllIIlllIIllllIIIlII.clearInputBuffer();
                        }
                        if (lllllllllllllllIIlllIIllllIIIlIl.equalsIgnoreCase("MC|AdvCmd")) {
                            lllllllllllllllIIlllIIllllIIIlII.set(Type.STRING, 0, "MC|AdvCdm");
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.CLIENT_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIIIIlIlIIIlIIlll) throws Exception {
                        final int lllllllllllllllIIIIIlIlIIIlIlIII = lllllllllllllllIIIIIlIlIIIlIIlll.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lllllllllllllllIIIIIlIlIIIlIlIII == 2) {
                            final EntityTracker1_9 lllllllllllllllIIIIIlIlIIIlIllIl = lllllllllllllllIIIIIlIlIIIlIIlll.user().getEntityTracker(Protocol1_9To1_8.class);
                            if (lllllllllllllllIIIIIlIlIIIlIllIl.isBlocking()) {
                                if (!Via.getConfig().isShowShieldWhenSwordInHand()) {
                                    lllllllllllllllIIIIIlIlIIIlIllIl.setSecondHand(null);
                                }
                                lllllllllllllllIIIIIlIlIIIlIllIl.setBlocking(false);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BOOLEAN);
                this.handler(new PlayerMovementMapper());
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.PLAYER_POSITION_AND_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BOOLEAN);
                this.handler(new PlayerMovementMapper());
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.PLAYER_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BOOLEAN);
                this.handler(new PlayerMovementMapper());
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)llllIIllIlIIIl).registerServerbound(ServerboundPackets1_9.PLAYER_MOVEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BOOLEAN);
                this.handler(new PlayerMovementMapper());
            }
        });
    }
}
