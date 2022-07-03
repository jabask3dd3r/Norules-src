package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import java.nio.charset.*;
import com.google.common.base.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viabackwards.utils.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.concurrent.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;

public class PlayerPacket1_13 extends RewriterBase<Protocol1_12_2To1_13>
{
    private final /* synthetic */ CommandRewriter commandRewriter;
    
    public PlayerPacket1_13(final Protocol1_12_2To1_13 llllllllllllllIlIllIlIlIIIlIIlIl) {
        super(llllllllllllllIlIllIlIlIIIlIIlIl);
        this.commandRewriter = new CommandRewriter((Protocol)this.protocol) {};
    }
    
    @Override
    protected void registerPackets() {
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(State.LOGIN, 4, -1, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIllllIlIIlIIIl) throws Exception {
                        lllllllllllllIIIllIllllIlIIlIIIl.cancel();
                        lllllllllllllIIIllIllllIlIIlIIIl.create(2, new PacketHandler() {
                            @Override
                            public void handle(final PacketWrapper llllllllllllllllIlIlIlIIIllIIlIl) throws Exception {
                                llllllllllllllllIlIlIlIIIllIIlIl.write(Type.VAR_INT, (Integer)lllllllllllllIIIllIllllIlIIlIIIl.read((Type<T>)Type.VAR_INT));
                                llllllllllllllllIlIlIlIIIllIIlIl.write(Type.BOOLEAN, false);
                            }
                        }).sendToServer(Protocol1_12_2To1_13.class);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIlllIIllllIlllII) throws Exception {
                        final String lllllllllllllIIlIlllIIllllIllllI = lllllllllllllIIlIlllIIllllIlllII.read(Type.STRING);
                        if (lllllllllllllIIlIlllIIllllIllllI.equals("minecraft:trader_list")) {
                            lllllllllllllIIlIlllIIllllIlllII.write(Type.STRING, "MC|TrList");
                            lllllllllllllIIlIlllIIllllIlllII.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllIIlIlllIIlllllIIllI = lllllllllllllIIlIlllIIllllIlllII.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIIlIlllIIlllllIIlll = 0; lllllllllllllIIlIlllIIlllllIIlll < lllllllllllllIIlIlllIIlllllIIllI; ++lllllllllllllIIlIlllIIlllllIIlll) {
                                final Item lllllllllllllIIlIlllIIlllllIlIlI = lllllllllllllIIlIlllIIllllIlllII.read(Type.FLAT_ITEM);
                                lllllllllllllIIlIlllIIllllIlllII.write(Type.ITEM, ((Protocol1_12_2To1_13)PlayerPacket1_13.this.protocol).getItemRewriter().handleItemToClient(lllllllllllllIIlIlllIIlllllIlIlI));
                                final Item lllllllllllllIIlIlllIIlllllIlIIl = lllllllllllllIIlIlllIIllllIlllII.read(Type.FLAT_ITEM);
                                lllllllllllllIIlIlllIIllllIlllII.write(Type.ITEM, ((Protocol1_12_2To1_13)PlayerPacket1_13.this.protocol).getItemRewriter().handleItemToClient(lllllllllllllIIlIlllIIlllllIlIIl));
                                final boolean lllllllllllllIIlIlllIIlllllIlIII = lllllllllllllIIlIlllIIllllIlllII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIIlIlllIIlllllIlIII) {
                                    final Item lllllllllllllIIlIlllIIlllllIlIll = lllllllllllllIIlIlllIIllllIlllII.read(Type.FLAT_ITEM);
                                    lllllllllllllIIlIlllIIllllIlllII.write(Type.ITEM, ((Protocol1_12_2To1_13)PlayerPacket1_13.this.protocol).getItemRewriter().handleItemToClient(lllllllllllllIIlIlllIIlllllIlIll));
                                }
                                lllllllllllllIIlIlllIIllllIlllII.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllIIlIlllIIllllIlllII.passthrough((Type<Object>)Type.INT);
                                lllllllllllllIIlIlllIIllllIlllII.passthrough((Type<Object>)Type.INT);
                            }
                        }
                        else {
                            final String lllllllllllllIIlIlllIIlllllIIIIl = InventoryPackets.getOldPluginChannelId(lllllllllllllIIlIlllIIllllIllllI);
                            if (lllllllllllllIIlIlllIIlllllIIIIl == null) {
                                if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                    ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring outgoing plugin message with channel: ").append(lllllllllllllIIlIlllIIllllIllllI)));
                                }
                                lllllllllllllIIlIlllIIllllIlllII.cancel();
                                return;
                            }
                            lllllllllllllIIlIlllIIllllIlllII.write(Type.STRING, lllllllllllllIIlIlllIIlllllIIIIl);
                            if (lllllllllllllIIlIlllIIlllllIIIIl.equals("REGISTER") || lllllllllllllIIlIlllIIlllllIIIIl.equals("UNREGISTER")) {
                                final String[] lllllllllllllIIlIlllIIlllllIIIll = new String(lllllllllllllIIlIlllIIllllIlllII.read(Type.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                                final List<String> lllllllllllllIIlIlllIIlllllIIIlI = new ArrayList<String>();
                                final long lllllllllllllIIlIlllIIllllIlIlll = (Object)lllllllllllllIIlIlllIIlllllIIIll;
                                final int length = lllllllllllllIIlIlllIIllllIlIlll.length;
                                for (Exception lllllllllllllIIlIlllIIllllIlIlIl = (Exception)0; lllllllllllllIIlIlllIIllllIlIlIl < length; ++lllllllllllllIIlIlllIIllllIlIlIl) {
                                    final String lllllllllllllIIlIlllIIlllllIIlII = lllllllllllllIIlIlllIIllllIlIlll[lllllllllllllIIlIlllIIllllIlIlIl];
                                    final String lllllllllllllIIlIlllIIlllllIIlIl = InventoryPackets.getOldPluginChannelId(lllllllllllllIIlIlllIIlllllIIlII);
                                    if (lllllllllllllIIlIlllIIlllllIIlIl != null) {
                                        lllllllllllllIIlIlllIIlllllIIIlI.add(lllllllllllllIIlIlllIIlllllIIlIl);
                                    }
                                    else if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                        ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring plugin channel in outgoing REGISTER: ").append(lllllllllllllIIlIlllIIlllllIIlII)));
                                    }
                                }
                                lllllllllllllIIlIlllIIllllIlllII.write(Type.REMAINING_BYTES, Joiner.on('\0').join((Iterable)lllllllllllllIIlIlllIIlllllIIIlI).getBytes(StandardCharsets.UTF_8));
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIIllIIIllIIlIlI) throws Exception {
                        final ParticleMapping.ParticleData lllllllllllllIlIIIIllIIIllIIlIIl = ParticleMapping.getMapping(lllllllllllllIlIIIIllIIIllIIlIlI.get((Type<Integer>)Type.INT, 0));
                        lllllllllllllIlIIIIllIIIllIIlIlI.set(Type.INT, 0, lllllllllllllIlIIIIllIIIllIIlIIl.getHistoryId());
                        final int[] lllllllllllllIlIIIIllIIIllIIlIII = lllllllllllllIlIIIIllIIIllIIlIIl.rewriteData((Protocol1_12_2To1_13)PlayerPacket1_13.this.protocol, lllllllllllllIlIIIIllIIIllIIlIlI);
                        if (lllllllllllllIlIIIIllIIIllIIlIII != null) {
                            if (lllllllllllllIlIIIIllIIIllIIlIIl.getHandler().isBlockHandler() && lllllllllllllIlIIIIllIIIllIIlIII[0] == 0) {
                                lllllllllllllIlIIIIllIIIllIIlIlI.cancel();
                                return;
                            }
                            final long lllllllllllllIlIIIIllIIIllIIIIll = (Object)lllllllllllllIlIIIIllIIIllIIlIII;
                            final char lllllllllllllIlIIIIllIIIllIIIIlI = (char)lllllllllllllIlIIIIllIIIllIIIIll.length;
                            for (float lllllllllllllIlIIIIllIIIllIIIIIl = 0; lllllllllllllIlIIIIllIIIllIIIIIl < lllllllllllllIlIIIIllIIIllIIIIlI; ++lllllllllllllIlIIIIllIIIllIIIIIl) {
                                final int lllllllllllllIlIIIIllIIIllIIllII = lllllllllllllIlIIIIllIIIllIIIIll[lllllllllllllIlIIIIllIIIllIIIIIl];
                                lllllllllllllIlIIIIllIIIllIIlIlI.write(Type.VAR_INT, lllllllllllllIlIIIIllIIIllIIllII);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.PLAYER_INFO, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIIlIIIIIlIIIIIlI) throws Exception {
                        final TabCompleteStorage llllllllllllllllIIlIIIIIlIIIIIIl = llllllllllllllllIIlIIIIIlIIIIIlI.user().get(TabCompleteStorage.class);
                        final int llllllllllllllllIIlIIIIIlIIIIIII = llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Integer>)Type.VAR_INT);
                        for (int llllllllllllllllIIlIIIIIIlllllll = llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllllIIlIIIIIlIIIIlII = 0; llllllllllllllllIIlIIIIIlIIIIlII < llllllllllllllllIIlIIIIIIlllllll; ++llllllllllllllllIIlIIIIIlIIIIlII) {
                            final UUID llllllllllllllllIIlIIIIIlIIIIlIl = llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.UUID);
                            if (llllllllllllllllIIlIIIIIlIIIIIII == 0) {
                                final String llllllllllllllllIIlIIIIIlIIIIlll = llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.STRING);
                                llllllllllllllllIIlIIIIIlIIIIIIl.usernames().put(llllllllllllllllIIlIIIIIlIIIIlIl, llllllllllllllllIIlIIIIIlIIIIlll);
                                for (int llllllllllllllllIIlIIIIIlIIIIllI = llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllllIIlIIIIIlIIIlIII = 0; llllllllllllllllIIlIIIIIlIIIlIII < llllllllllllllllIIlIIIIIlIIIIllI; ++llllllllllllllllIIlIIIIIlIIIlIII) {
                                    llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.STRING);
                                    llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.STRING);
                                    if (llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                        llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.STRING);
                                    }
                                }
                                llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Object>)Type.VAR_INT);
                                llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Object>)Type.VAR_INT);
                                if (llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                    llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.COMPONENT);
                                }
                            }
                            else if (llllllllllllllllIIlIIIIIlIIIIIII == 1) {
                                llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Object>)Type.VAR_INT);
                            }
                            else if (llllllllllllllllIIlIIIIIlIIIIIII == 2) {
                                llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Object>)Type.VAR_INT);
                            }
                            else if (llllllllllllllllIIlIIIIIlIIIIIII == 3) {
                                if (llllllllllllllllIIlIIIIIlIIIIIlI.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                    llllllllllllllllIIlIIIIIlIIIIIlI.passthrough(Type.COMPONENT);
                                }
                            }
                            else if (llllllllllllllllIIlIIIIIlIIIIIII == 4) {
                                llllllllllllllllIIlIIIIIlIIIIIIl.usernames().remove(llllllllllllllllIIlIIIIIlIIIIlIl);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SCOREBOARD_OBJECTIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlllIlIIlIIllIllIII) throws Exception {
                        final byte lllllllllllllIlllIlIIlIIllIlIlll = lllllllllllllIlllIlIIlIIllIllIII.get((Type<Byte>)Type.BYTE, 0);
                        if (lllllllllllllIlllIlIIlIIllIlIlll == 0 || lllllllllllllIlllIlIIlIIllIlIlll == 2) {
                            String lllllllllllllIlllIlIIlIIllIllIll = lllllllllllllIlllIlIIlIIllIllIII.read(Type.COMPONENT).toString();
                            lllllllllllllIlllIlIIlIIllIllIll = ChatRewriter.jsonToLegacyText(lllllllllllllIlllIlIIlIIllIllIll);
                            if (lllllllllllllIlllIlIIlIIllIllIll.length() > 32) {
                                lllllllllllllIlllIlIIlIIllIllIll = lllllllllllllIlllIlIIlIIllIllIll.substring(0, 32);
                            }
                            lllllllllllllIlllIlIIlIIllIllIII.write(Type.STRING, lllllllllllllIlllIlIIlIIllIllIll);
                            final int lllllllllllllIlllIlIIlIIllIllIlI = lllllllllllllIlllIlIIlIIllIllIII.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllIlllIlIIlIIllIllIII.write(Type.STRING, (lllllllllllllIlllIlIIlIIllIllIlI == 1) ? "hearts" : "integer");
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.TEAMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIlIlllIlIlIlllII) throws Exception {
                        final byte llllllllllllllllIlIlllIlIlIlllIl = llllllllllllllllIlIlllIlIlIlllII.get((Type<Byte>)Type.BYTE, 0);
                        if (llllllllllllllllIlIlllIlIlIlllIl == 0 || llllllllllllllllIlIlllIlIlIlllIl == 2) {
                            String llllllllllllllllIlIlllIlIllIlIII = llllllllllllllllIlIlllIlIlIlllII.read(Type.STRING);
                            llllllllllllllllIlIlllIlIllIlIII = ChatRewriter.jsonToLegacyText(llllllllllllllllIlIlllIlIllIlIII);
                            llllllllllllllllIlIlllIlIllIlIII = ChatUtil.removeUnusedColor(llllllllllllllllIlIlllIlIllIlIII, 'f');
                            if (llllllllllllllllIlIlllIlIllIlIII.length() > 32) {
                                llllllllllllllllIlIlllIlIllIlIII = llllllllllllllllIlIlllIlIllIlIII.substring(0, 32);
                            }
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.STRING, llllllllllllllllIlIlllIlIllIlIII);
                            final byte llllllllllllllllIlIlllIlIllIIlll = llllllllllllllllIlIlllIlIlIlllII.read((Type<Byte>)Type.BYTE);
                            final String llllllllllllllllIlIlllIlIllIIllI = llllllllllllllllIlIlllIlIlIlllII.read(Type.STRING);
                            final String llllllllllllllllIlIlllIlIllIIlIl = llllllllllllllllIlIlllIlIlIlllII.read(Type.STRING);
                            int llllllllllllllllIlIlllIlIllIIlII = llllllllllllllllIlIlllIlIlIlllII.read((Type<Integer>)Type.VAR_INT);
                            if (llllllllllllllllIlIlllIlIllIIlII == 21) {
                                llllllllllllllllIlIlllIlIllIIlII = -1;
                            }
                            final JsonElement llllllllllllllllIlIlllIlIllIIIll = llllllllllllllllIlIlllIlIlIlllII.read(Type.COMPONENT);
                            final JsonElement llllllllllllllllIlIlllIlIllIIIlI = llllllllllllllllIlIlllIlIlIlllII.read(Type.COMPONENT);
                            String llllllllllllllllIlIlllIlIllIIIIl = (llllllllllllllllIlIlllIlIllIIIll == null || llllllllllllllllIlIlllIlIllIIIll.isJsonNull()) ? "" : ChatRewriter.jsonToLegacyText(llllllllllllllllIlIlllIlIllIIIll.toString());
                            if (ViaBackwards.getConfig().addTeamColorTo1_13Prefix()) {
                                llllllllllllllllIlIlllIlIllIIIIl = String.valueOf(new StringBuilder().append(llllllllllllllllIlIlllIlIllIIIIl).append("§").append((llllllllllllllllIlIlllIlIllIIlII > -1 && llllllllllllllllIlIlllIlIllIIlII <= 15) ? Integer.toHexString(llllllllllllllllIlIlllIlIllIIlII) : "r"));
                            }
                            llllllllllllllllIlIlllIlIllIIIIl = ChatUtil.removeUnusedColor(llllllllllllllllIlIlllIlIllIIIIl, 'f', true);
                            if (llllllllllllllllIlIlllIlIllIIIIl.length() > 16) {
                                llllllllllllllllIlIlllIlIllIIIIl = llllllllllllllllIlIlllIlIllIIIIl.substring(0, 16);
                            }
                            if (llllllllllllllllIlIlllIlIllIIIIl.endsWith("§")) {
                                llllllllllllllllIlIlllIlIllIIIIl = llllllllllllllllIlIlllIlIllIIIIl.substring(0, llllllllllllllllIlIlllIlIllIIIIl.length() - 1);
                            }
                            String llllllllllllllllIlIlllIlIllIIIII = (llllllllllllllllIlIlllIlIllIIIlI == null || llllllllllllllllIlIlllIlIllIIIlI.isJsonNull()) ? "" : ChatRewriter.jsonToLegacyText(llllllllllllllllIlIlllIlIllIIIlI.toString());
                            llllllllllllllllIlIlllIlIllIIIII = ChatUtil.removeUnusedColor(llllllllllllllllIlIlllIlIllIIIII, '\0');
                            if (llllllllllllllllIlIlllIlIllIIIII.length() > 16) {
                                llllllllllllllllIlIlllIlIllIIIII = llllllllllllllllIlIlllIlIllIIIII.substring(0, 16);
                            }
                            if (llllllllllllllllIlIlllIlIllIIIII.endsWith("§")) {
                                llllllllllllllllIlIlllIlIllIIIII = llllllllllllllllIlIlllIlIllIIIII.substring(0, llllllllllllllllIlIlllIlIllIIIII.length() - 1);
                            }
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.STRING, llllllllllllllllIlIlllIlIllIIIIl);
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.STRING, llllllllllllllllIlIlllIlIllIIIII);
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.BYTE, llllllllllllllllIlIlllIlIllIIlll);
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.STRING, llllllllllllllllIlIlllIlIllIIllI);
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.STRING, llllllllllllllllIlIlllIlIllIIlIl);
                            llllllllllllllllIlIlllIlIlIlllII.write(Type.BYTE, (byte)llllllllllllllllIlIlllIlIllIIlII);
                        }
                        if (llllllllllllllllIlIlllIlIlIlllIl == 0 || llllllllllllllllIlIlllIlIlIlllIl == 3 || llllllllllllllllIlIlllIlIlIlllIl == 4) {
                            llllllllllllllllIlIlllIlIlIlllII.passthrough(Type.STRING_ARRAY);
                        }
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_13, ClientboundPackets1_12_1, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.DECLARE_COMMANDS, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final TabCompleteStorage llllllllllllllIIIllIlIIllIllIIll;
                final int llllllllllllllIIIllIlIIllIllIIlI;
                boolean llllllllllllllIIIllIlIIllIllIIIl;
                int llllllllllllllIIIllIlIIllIllIllI;
                byte llllllllllllllIIIllIlIIllIlllIII;
                byte llllllllllllllIIIllIlIIllIllIlll;
                String llllllllllllllIIIllIlIIllIlllIIl;
                this.handler(llllllllllllllIIIllIlIIllIlIllll -> {
                    llllllllllllllIIIllIlIIllIlIllll.cancel();
                    llllllllllllllIIIllIlIIllIllIIll = llllllllllllllIIIllIlIIllIlIllll.user().get(TabCompleteStorage.class);
                    if (!llllllllllllllIIIllIlIIllIllIIll.commands().isEmpty()) {
                        llllllllllllllIIIllIlIIllIllIIll.commands().clear();
                    }
                    llllllllllllllIIIllIlIIllIllIIlI = llllllllllllllIIIllIlIIllIlIllll.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIIIllIlIIllIllIIIl = true;
                    for (llllllllllllllIIIllIlIIllIllIllI = 0; llllllllllllllIIIllIlIIllIllIllI < llllllllllllllIIIllIlIIllIllIIlI; ++llllllllllllllIIIllIlIIllIllIllI) {
                        llllllllllllllIIIllIlIIllIlllIII = llllllllllllllIIIllIlIIllIlIllll.read((Type<Byte>)Type.BYTE);
                        llllllllllllllIIIllIlIIllIlIllll.read(Type.VAR_INT_ARRAY_PRIMITIVE);
                        if ((llllllllllllllIIIllIlIIllIlllIII & 0x8) != 0x0) {
                            llllllllllllllIIIllIlIIllIlIllll.read((Type<Object>)Type.VAR_INT);
                        }
                        llllllllllllllIIIllIlIIllIllIlll = (byte)(llllllllllllllIIIllIlIIllIlllIII & 0x3);
                        if (llllllllllllllIIIllIlIIllIllIIIl && llllllllllllllIIIllIlIIllIllIlll == 2) {
                            llllllllllllllIIIllIlIIllIllIIIl = false;
                        }
                        if (llllllllllllllIIIllIlIIllIllIlll == 1 || llllllllllllllIIIllIlIIllIllIlll == 2) {
                            llllllllllllllIIIllIlIIllIlllIIl = llllllllllllllIIIllIlIIllIlIllll.read(Type.STRING);
                            if (llllllllllllllIIIllIlIIllIllIlll == 1 && llllllllllllllIIIllIlIIllIllIIIl) {
                                llllllllllllllIIIllIlIIllIllIIll.commands().add(String.valueOf(new StringBuilder().append('/').append(llllllllllllllIIIllIlIIllIlllIIl)));
                            }
                        }
                        if (llllllllllllllIIIllIlIIllIllIlll == 2) {
                            PlayerPacket1_13.this.commandRewriter.handleArgument(llllllllllllllIIIllIlIIllIlIllll, llllllllllllllIIIllIlIIllIlIllll.read(Type.STRING));
                        }
                        if ((llllllllllllllIIIllIlIIllIlllIII & 0x10) != 0x0) {
                            llllllllllllllIIIllIlIIllIlIllll.read(Type.STRING);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlIIlIIIlIIlIll) throws Exception {
                        final TabCompleteStorage llllllllllllllIIIIlIIlIIIlIlIIII = llllllllllllllIIIIlIIlIIIlIIlIll.user().get(TabCompleteStorage.class);
                        if (llllllllllllllIIIIlIIlIIIlIlIIII.lastRequest() == null) {
                            llllllllllllllIIIIlIIlIIIlIIlIll.cancel();
                            return;
                        }
                        if (llllllllllllllIIIIlIIlIIIlIlIIII.lastId() != llllllllllllllIIIIlIIlIIIlIIlIll.read((Type<Integer>)Type.VAR_INT)) {
                            llllllllllllllIIIIlIIlIIIlIIlIll.cancel();
                        }
                        final int llllllllllllllIIIIlIIlIIIlIIllll = llllllllllllllIIIIlIIlIIIlIIlIll.read((Type<Integer>)Type.VAR_INT);
                        final int llllllllllllllIIIIlIIlIIIlIIlllI = llllllllllllllIIIIlIIlIIIlIIlIll.read((Type<Integer>)Type.VAR_INT);
                        final int llllllllllllllIIIIlIIlIIIlIIllIl = llllllllllllllIIIIlIIlIIIlIlIIII.lastRequest().lastIndexOf(32) + 1;
                        if (llllllllllllllIIIIlIIlIIIlIIllIl != llllllllllllllIIIIlIIlIIIlIIllll) {
                            llllllllllllllIIIIlIIlIIIlIIlIll.cancel();
                        }
                        if (llllllllllllllIIIIlIIlIIIlIIlllI != llllllllllllllIIIIlIIlIIIlIlIIII.lastRequest().length() - llllllllllllllIIIIlIIlIIIlIIllIl) {
                            llllllllllllllIIIIlIIlIIIlIIlIll.cancel();
                        }
                        for (int llllllllllllllIIIIlIIlIIIlIIllII = llllllllllllllIIIIlIIlIIIlIIlIll.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllIIIIlIIlIIIlIlIIll = 0; llllllllllllllIIIIlIIlIIIlIlIIll < llllllllllllllIIIIlIIlIIIlIIllII; ++llllllllllllllIIIIlIIlIIIlIlIIll) {
                            final String llllllllllllllIIIIlIIlIIIlIlIlII = llllllllllllllIIIIlIIlIIIlIIlIll.read(Type.STRING);
                            llllllllllllllIIIIlIIlIIIlIIlIll.write(Type.STRING, String.valueOf(new StringBuilder().append((llllllllllllllIIIIlIIlIIIlIIllll == 0 && !llllllllllllllIIIIlIIlIIIlIlIIII.isLastAssumeCommand()) ? "/" : "").append(llllllllllllllIIIIlIIlIIIlIlIlII)));
                            if (llllllllllllllIIIIlIIlIIIlIIlIll.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIIIIlIIlIIIlIIlIll.read(Type.STRING);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final TabCompleteStorage lllllllllllllIIIllIlIllIIIIllIlI;
                final ArrayList<String> lllllllllllllIIIllIlIllIIIIllIIl;
                String lllllllllllllIIIllIlIllIIIIllIII;
                final boolean lllllllllllllIIIllIlIllIIIIlIlll;
                String lllllllllllllIIIllIlIllIIIIlllll;
                float lllllllllllllIIIllIlIllIIIIIllll;
                String lllllllllllllIIIllIlIllIIIlIIIII;
                final Iterator<String> iterator;
                String lllllllllllllIIIllIlIllIIIIllllI;
                PacketWrapper lllllllllllllIIIllIlIllIIIIlllII;
                float lllllllllllllIIIllIlIllIIIIIllll2;
                String lllllllllllllIIIllIlIllIIIIlllIl;
                int lllllllllllllIIIllIlIllIIIIlIllI;
                this.handler(lllllllllllllIIIllIlIllIIIIlIlIl -> {
                    lllllllllllllIIIllIlIllIIIIllIlI = lllllllllllllIIIllIlIllIIIIlIlIl.user().get(TabCompleteStorage.class);
                    lllllllllllllIIIllIlIllIIIIllIIl = new ArrayList<String>();
                    lllllllllllllIIIllIlIllIIIIllIII = lllllllllllllIIIllIlIllIIIIlIlIl.read(Type.STRING);
                    lllllllllllllIIIllIlIllIIIIlIlll = lllllllllllllIIIllIlIllIIIIlIlIl.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllIIIllIlIllIIIIlIlIl.read(Type.OPTIONAL_POSITION);
                    if (!lllllllllllllIIIllIlIllIIIIlIlll && !lllllllllllllIIIllIlIllIIIIllIII.startsWith("/")) {
                        lllllllllllllIIIllIlIllIIIIlllll = lllllllllllllIIIllIlIllIIIIllIII.substring(lllllllllllllIIIllIlIllIIIIllIII.lastIndexOf(32) + 1);
                        lllllllllllllIIIllIlIllIIIIIllll = (float)lllllllllllllIIIllIlIllIIIIllIlI.usernames().values().iterator();
                        while (((Iterator)lllllllllllllIIIllIlIllIIIIIllll).hasNext()) {
                            lllllllllllllIIIllIlIllIIIlIIIII = ((Iterator<String>)lllllllllllllIIIllIlIllIIIIIllll).next();
                            if (startsWithIgnoreCase(lllllllllllllIIIllIlIllIIIlIIIII, lllllllllllllIIIllIlIllIIIIlllll)) {
                                lllllllllllllIIIllIlIllIIIIllIIl.add(lllllllllllllIIIllIlIllIIIlIIIII);
                            }
                        }
                    }
                    else if (!lllllllllllllIIIllIlIllIIIIllIlI.commands().isEmpty() && !lllllllllllllIIIllIlIllIIIIllIII.contains(" ")) {
                        lllllllllllllIIIllIlIllIIIIllIlI.commands().iterator();
                        while (iterator.hasNext()) {
                            lllllllllllllIIIllIlIllIIIIllllI = iterator.next();
                            if (startsWithIgnoreCase(lllllllllllllIIIllIlIllIIIIllllI, lllllllllllllIIIllIlIllIIIIllIII)) {
                                lllllllllllllIIIllIlIllIIIIllIIl.add(lllllllllllllIIIllIlIllIIIIllllI);
                            }
                        }
                    }
                    if (!lllllllllllllIIIllIlIllIIIIllIIl.isEmpty()) {
                        lllllllllllllIIIllIlIllIIIIlIlIl.cancel();
                        lllllllllllllIIIllIlIllIIIIlllII = lllllllllllllIIIllIlIllIIIIlIlIl.create(ClientboundPackets1_12_1.TAB_COMPLETE);
                        lllllllllllllIIIllIlIllIIIIlllII.write(Type.VAR_INT, lllllllllllllIIIllIlIllIIIIllIIl.size());
                        lllllllllllllIIIllIlIllIIIIIllll2 = (float)lllllllllllllIIIllIlIllIIIIllIIl.iterator();
                        while (((Iterator)lllllllllllllIIIllIlIllIIIIIllll2).hasNext()) {
                            lllllllllllllIIIllIlIllIIIIlllIl = ((Iterator<String>)lllllllllllllIIIllIlIllIIIIIllll2).next();
                            lllllllllllllIIIllIlIllIIIIlllII.write(Type.STRING, lllllllllllllIIIllIlIllIIIIlllIl);
                        }
                        lllllllllllllIIIllIlIllIIIIlllII.scheduleSend(Protocol1_12_2To1_13.class);
                        lllllllllllllIIIllIlIllIIIIllIlI.setLastRequest(null);
                    }
                    else {
                        if (!lllllllllllllIIIllIlIllIIIIlIlll && lllllllllllllIIIllIlIllIIIIllIII.startsWith("/")) {
                            lllllllllllllIIIllIlIllIIIIllIII = lllllllllllllIIIllIlIllIIIIllIII.substring(1);
                        }
                        lllllllllllllIIIllIlIllIIIIlIllI = ThreadLocalRandom.current().nextInt();
                        lllllllllllllIIIllIlIllIIIIlIlIl.write(Type.VAR_INT, lllllllllllllIIIllIlIllIIIIlIllI);
                        lllllllllllllIIIllIlIllIIIIlIlIl.write(Type.STRING, lllllllllllllIIIllIlIllIIIIllIII);
                        lllllllllllllIIIllIlIllIIIIllIlI.setLastId(lllllllllllllIIIllIlIllIIIIlIllI);
                        lllllllllllllIIIllIlIllIIIIllIlI.setLastAssumeCommand(lllllllllllllIIIllIlIllIIIIlIlll);
                        lllllllllllllIIIllIlIllIIIIllIlI.setLastRequest(lllllllllllllIIIllIlIllIIIIllIII);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final long llllllllllllllIlIIIlIlIllIIIIlIl;
                final String llllllllllllllIlIIIlIlIllIIIlIIl;
                float llllllllllllllIlIIIlIlIllIIIIlII;
                final Item llllllllllllllIlIIIlIlIllIlIIIll;
                final boolean llllllllllllllIlIIIlIlIllIlIIIlI;
                final byte llllllllllllllIlIIIlIlIllIlIIIIl;
                final int llllllllllllllIlIIIlIlIllIlIIIII;
                final int llllllllllllllIlIIIlIlIllIIlllll;
                final int llllllllllllllIlIIIlIlIllIIllllI;
                byte llllllllllllllIlIIIlIlIllIIlllIl;
                final String llllllllllllllIlIIIlIlIllIIlllII;
                final int llllllllllllllIlIIIlIlIllIIllIll;
                final int llllllllllllllIlIIIlIlIllIIllIlI;
                final int llllllllllllllIlIIIlIlIllIIllIIl;
                final int llllllllllllllIlIIIlIlIllIIllIII;
                final String llllllllllllllIlIIIlIlIllIIlIlll;
                final int llllllllllllllIlIIIlIlIllIIlIllI;
                final String llllllllllllllIlIIIlIlIllIIlIlIl;
                final int llllllllllllllIlIIIlIlIllIIlIlII;
                final String llllllllllllllIlIIIlIlIllIIlIIll;
                final int llllllllllllllIlIIIlIlIllIIlIIlI;
                byte llllllllllllllIlIIIlIlIllIIlIIIl;
                final String llllllllllllllIlIIIlIlIllIIIllII;
                String[] llllllllllllllIlIIIlIlIllIIIlllI;
                ArrayList<String> llllllllllllllIlIIIlIlIllIIIllIl;
                final String[] array;
                int length;
                int i = 0;
                String llllllllllllllIlIIIlIlIllIIIllll;
                String llllllllllllllIlIIIlIlIllIIlIIII;
                this.handler(llllllllllllllIlIIIlIlIllIIIlIlI -> {
                    llllllllllllllIlIIIlIlIllIIIlIIl = (String)(llllllllllllllIlIIIlIlIllIIIIlIl = (long)llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.STRING));
                    llllllllllllllIlIIIlIlIllIIIIlII = -1;
                    switch (((String)llllllllllllllIlIIIlIlIllIIIIlIl).hashCode()) {
                        case -295809223: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|BSign")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 0;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -296231034: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|BEdit")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 1;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -751882236: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|ItemName")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 2;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -592727859: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|AdvCmd")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 3;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -708575099: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|AutoCmd")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 4;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -62698213: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|Struct")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 5;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -563769974: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|Beacon")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 6;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -278283530: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|TrSel")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 7;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case 1626013338: {
                            if (((String)llllllllllllllIlIIIlIlIllIIIIlIl).equals("MC|PickItem")) {
                                llllllllllllllIlIIIlIlIllIIIIlII = 8;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                    }
                    switch (llllllllllllllIlIIIlIlIllIIIIlII) {
                        case 0.0f:
                        case 1.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(11);
                            llllllllllllllIlIIIlIlIllIlIIIll = llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.ITEM);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.FLAT_ITEM, ((Protocol1_12_2To1_13)PlayerPacket1_13.this.protocol).getItemRewriter().handleItemToServer(llllllllllllllIlIIIlIlIllIlIIIll));
                            llllllllllllllIlIIIlIlIllIlIIIlI = llllllllllllllIlIIIlIlIllIIIlIIl.equals("MC|BSign");
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BOOLEAN, llllllllllllllIlIIIlIlIllIlIIIlI);
                            break;
                        }
                        case 2.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(28);
                            break;
                        }
                        case 3.0f: {
                            llllllllllllllIlIIIlIlIllIlIIIIl = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Byte>)Type.BYTE);
                            if (llllllllllllllIlIIIlIlIllIlIIIIl == 0) {
                                llllllllllllllIlIIIlIlIllIIIlIlI.setId(34);
                                llllllllllllllIlIIIlIlIllIIIlIlI.cancel();
                                ViaBackwards.getPlatform().getLogger().warning("Client send MC|AdvCmd custom payload to update command block, weird!");
                                break;
                            }
                            else if (llllllllllllllIlIIIlIlIllIlIIIIl == 1) {
                                llllllllllllllIlIIIlIlIllIIIlIlI.setId(35);
                                llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, (Integer)llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<T>)Type.INT));
                                llllllllllllllIlIIIlIlIllIIIlIlI.passthrough(Type.STRING);
                                llllllllllllllIlIIIlIlIllIIIlIlI.passthrough((Type<Object>)Type.BOOLEAN);
                                break;
                            }
                            else {
                                llllllllllllllIlIIIlIlIllIIIlIlI.cancel();
                                break;
                            }
                            break;
                        }
                        case 4.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(34);
                            llllllllllllllIlIIIlIlIllIlIIIII = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT);
                            llllllllllllllIlIIIlIlIllIIlllll = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT);
                            llllllllllllllIlIIIlIlIllIIllllI = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.POSITION, new Position(llllllllllllllIlIIIlIlIllIlIIIII, (short)llllllllllllllIlIIIlIlIllIIlllll, llllllllllllllIlIIIlIlIllIIllllI));
                            llllllllllllllIlIIIlIlIllIIIlIlI.passthrough(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIlllIl = 0;
                            if (llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIlIIIlIlIllIIlllIl |= 0x1;
                            }
                            llllllllllllllIlIIIlIlIllIIlllII = llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIllIll = (llllllllllllllIlIIIlIlIllIIlllII.equals("SEQUENCE") ? 0 : (llllllllllllllIlIIIlIlIllIIlllII.equals("AUTO") ? 1 : 2));
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, llllllllllllllIlIIIlIlIllIIllIll);
                            if (llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIlIIIlIlIllIIlllIl |= 0x2;
                            }
                            if (llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIlIIIlIlIllIIlllIl |= 0x4;
                            }
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIlllIl);
                            break;
                        }
                        case 5.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(37);
                            llllllllllllllIlIIIlIlIllIIllIlI = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT);
                            llllllllllllllIlIIIlIlIllIIllIIl = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT);
                            llllllllllllllIlIIIlIlIllIIllIII = llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.POSITION, new Position(llllllllllllllIlIIIlIlIllIIllIlI, (short)llllllllllllllIlIIIlIlIllIIllIIl, llllllllllllllIlIIIlIlIllIIllIII));
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Byte>)Type.BYTE) - 1);
                            llllllllllllllIlIIIlIlIllIIlIlll = llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIlIllI = (llllllllllllllIlIIIlIlIllIIlIlll.equals("SAVE") ? 0 : (llllllllllllllIlIIIlIlIllIIlIlll.equals("LOAD") ? 1 : (llllllllllllllIlIIIlIlIllIIlIlll.equals("CORNER") ? 2 : 3)));
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, llllllllllllllIlIIIlIlIllIIlIllI);
                            llllllllllllllIlIIIlIlIllIIIlIlI.passthrough(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT).byteValue());
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT).byteValue());
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT).byteValue());
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT).byteValue());
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT).byteValue());
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Integer>)Type.INT).byteValue());
                            llllllllllllllIlIIIlIlIllIIlIlIl = llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIlIlII = (llllllllllllllIlIIIlIlIllIIlIlll.equals("NONE") ? 0 : (llllllllllllllIlIIIlIlIllIIlIlll.equals("LEFT_RIGHT") ? 1 : 2));
                            llllllllllllllIlIIIlIlIllIIlIIll = llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIlIIlI = (llllllllllllllIlIIIlIlIllIIlIlll.equals("NONE") ? 0 : (llllllllllllllIlIIIlIlIllIIlIlll.equals("CLOCKWISE_90") ? 1 : (llllllllllllllIlIIIlIlIllIIlIlll.equals("CLOCKWISE_180") ? 2 : 3)));
                            llllllllllllllIlIIIlIlIllIIIlIlI.passthrough(Type.STRING);
                            llllllllllllllIlIIIlIlIllIIlIIIl = 0;
                            if (llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIlIIIlIlIllIIlIIIl |= 0x1;
                            }
                            if (llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIlIIIlIlIllIIlIIIl |= 0x2;
                            }
                            if (llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIlIIIlIlIllIIlIIIl |= 0x4;
                            }
                            llllllllllllllIlIIIlIlIllIIIlIlI.passthrough((Type<Object>)Type.FLOAT);
                            llllllllllllllIlIIIlIlIllIIIlIlI.passthrough((Type<Object>)Type.VAR_LONG);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.BYTE, llllllllllllllIlIIIlIlIllIIlIIIl);
                            break;
                        }
                        case 6.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(32);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, (Integer)llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<T>)Type.INT));
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, (Integer)llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<T>)Type.INT));
                            break;
                        }
                        case 7.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(31);
                            llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.VAR_INT, (Integer)llllllllllllllIlIIIlIlIllIIIlIlI.read((Type<T>)Type.INT));
                            break;
                        }
                        case 8.0f: {
                            llllllllllllllIlIIIlIlIllIIIlIlI.setId(21);
                            break;
                        }
                        default: {
                            llllllllllllllIlIIIlIlIllIIIllII = InventoryPackets.getNewPluginChannelId(llllllllllllllIlIIIlIlIllIIIlIIl);
                            if (llllllllllllllIlIIIlIlIllIIIllII == null) {
                                if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                    ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring incoming plugin message with channel: ").append(llllllllllllllIlIIIlIlIllIIIlIIl)));
                                }
                                llllllllllllllIlIIIlIlIllIIIlIlI.cancel();
                                return;
                            }
                            else {
                                llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.STRING, llllllllllllllIlIIIlIlIllIIIllII);
                                if (llllllllllllllIlIIIlIlIllIIIllII.equals("minecraft:register") || llllllllllllllIlIIIlIlIllIIIllII.equals("minecraft:unregister")) {
                                    llllllllllllllIlIIIlIlIllIIIlllI = new String(llllllllllllllIlIIIlIlIllIIIlIlI.read(Type.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                                    llllllllllllllIlIIIlIlIllIIIllIl = new ArrayList<String>();
                                    for (length = array.length; i < length; ++i) {
                                        llllllllllllllIlIIIlIlIllIIIllll = array[i];
                                        llllllllllllllIlIIIlIlIllIIlIIII = InventoryPackets.getNewPluginChannelId(llllllllllllllIlIIIlIlIllIIIllll);
                                        if (llllllllllllllIlIIIlIlIllIIlIIII != null) {
                                            llllllllllllllIlIIIlIlIllIIIllIl.add(llllllllllllllIlIIIlIlIllIIlIIII);
                                        }
                                        else if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring plugin channel in incoming REGISTER: ").append(llllllllllllllIlIIIlIlIllIIIllll)));
                                        }
                                    }
                                    if (!llllllllllllllIlIIIlIlIllIIIllIl.isEmpty()) {
                                        llllllllllllllIlIIIlIlIllIIIlIlI.write(Type.REMAINING_BYTES, Joiner.on('\0').join((Iterable)llllllllllllllIlIIIlIlIllIIIllIl).getBytes(StandardCharsets.UTF_8));
                                        break;
                                    }
                                    else {
                                        llllllllllllllIlIIIlIlIllIIIlIlI.cancel();
                                        return;
                                    }
                                }
                                else {
                                    break;
                                }
                            }
                            break;
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.STATISTICS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlllIlIIllllIIIllII) throws Exception {
                        int lllllllllllllIlllIlIIllllIIIlllI;
                        final int lllllllllllllIlllIlIIllllIIIllll = lllllllllllllIlllIlIIllllIIIlllI = lllllllllllllIlllIlIIllllIIIllII.get((Type<Integer>)Type.VAR_INT, 0);
                        for (int lllllllllllllIlllIlIIllllIIlIIlI = 0; lllllllllllllIlllIlIIllllIIlIIlI < lllllllllllllIlllIlIIllllIIIllll; ++lllllllllllllIlllIlIIllllIIlIIlI) {
                            final int lllllllllllllIlllIlIIllllIIlIlIl = lllllllllllllIlllIlIIllllIIIllII.read((Type<Integer>)Type.VAR_INT);
                            final int lllllllllllllIlllIlIIllllIIlIlII = lllllllllllllIlllIlIIllllIIIllII.read((Type<Integer>)Type.VAR_INT);
                            String lllllllllllllIlllIlIIllllIIlIIll = "";
                            switch (lllllllllllllIlllIlIIllllIIlIlIl) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7: {
                                    lllllllllllllIlllIlIIllllIIIllII.read((Type<Object>)Type.VAR_INT);
                                    --lllllllllllllIlllIlIIllllIIIlllI;
                                    continue;
                                }
                                case 8: {
                                    lllllllllllllIlllIlIIllllIIlIIll = ((Protocol1_12_2To1_13)PlayerPacket1_13.this.protocol).getMappingData().getStatisticMappings().get(lllllllllllllIlllIlIIllllIIlIlII);
                                    if (lllllllllllllIlllIlIIllllIIlIIll == null) {
                                        lllllllllllllIlllIlIIllllIIIllII.read((Type<Object>)Type.VAR_INT);
                                        --lllllllllllllIlllIlIIllllIIIlllI;
                                        continue;
                                    }
                                    break;
                                }
                            }
                            lllllllllllllIlllIlIIllllIIIllII.write(Type.STRING, lllllllllllllIlllIlIIllllIIlIIll);
                            lllllllllllllIlllIlIIllllIIIllII.passthrough((Type<Object>)Type.VAR_INT);
                        }
                        if (lllllllllllllIlllIlIIllllIIIlllI != lllllllllllllIlllIlIIllllIIIllll) {
                            lllllllllllllIlllIlIIllllIIIllII.set(Type.VAR_INT, 0, lllllllllllllIlllIlIIllllIIIlllI);
                        }
                    }
                });
            }
        });
    }
    
    private static boolean startsWithIgnoreCase(final String llllllllllllllIlIllIlIlIIIIlllIl, final String llllllllllllllIlIllIlIlIIIIllIlI) {
        return llllllllllllllIlIllIlIlIIIIlllIl.length() >= llllllllllllllIlIllIlIlIIIIllIlI.length() && llllllllllllllIlIllIlIlIIIIlllIl.regionMatches(true, 0, llllllllllllllIlIllIlIlIIIIllIlI, 0, llllllllllllllIlIllIlIlIIIIllIlI.length());
    }
}
