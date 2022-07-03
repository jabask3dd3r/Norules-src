package com.viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.google.common.collect.*;
import java.util.*;

public class Protocol1_13To1_12_2 extends AbstractProtocol<ClientboundPackets1_12_1, ClientboundPackets1_13, ServerboundPackets1_12_1, ServerboundPackets1_13>
{
    private static final /* synthetic */ PacketHandler SEND_DECLARE_COMMANDS_AND_TAGS;
    private static final /* synthetic */ Set<Character> FORMATTING_CODES;
    public static final /* synthetic */ PacketHandler POS_TO_3_INT;
    public static final /* synthetic */ MappingData MAPPINGS;
    private final /* synthetic */ EntityRewriter entityRewriter;
    private static final /* synthetic */ Map<Character, Character> SCOREBOARD_TEAM_NAME_REWRITE;
    private final /* synthetic */ ItemRewriter itemRewriter;
    
    @Override
    public void register(final ViaProviders lllllllllllllllIIIllllIllIlIlIIl) {
        lllllllllllllllIIIllllIllIlIlIIl.register(BlockEntityProvider.class, new BlockEntityProvider());
        lllllllllllllllIIIllllIllIlIlIIl.register(PaintingProvider.class, new PaintingProvider());
    }
    
    public Protocol1_13To1_12_2() {
        super(ClientboundPackets1_12_1.class, ClientboundPackets1_13.class, ServerboundPackets1_12_1.class, ServerboundPackets1_13.class);
        this.entityRewriter = new MetadataRewriter1_13To1_12_2(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    public static int[] toPrimitive(final Integer[] lllllllllllllllIIIllllIllIIIIIll) {
        final int[] lllllllllllllllIIIllllIllIIIIIlI = new int[lllllllllllllllIIIllllIllIIIIIll.length];
        for (int lllllllllllllllIIIllllIllIIIIlII = 0; lllllllllllllllIIIllllIllIIIIlII < lllllllllllllllIIIllllIllIIIIIll.length; ++lllllllllllllllIIIllllIllIIIIlII) {
            lllllllllllllllIIIllllIllIIIIIlI[lllllllllllllllIIIllllIllIIIIlII] = lllllllllllllllIIIllllIllIIIIIll[lllllllllllllllIIIllllIllIIIIlII];
        }
        return lllllllllllllllIIIllllIllIIIIIlI;
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_13To1_12_2.MAPPINGS;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllllIIIllllIllIlIlllI) {
        lllllllllllllllIIIllllIllIlIlllI.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllllIIIllllIllIlIlllI, Entity1_13Types.EntityType.PLAYER));
        lllllllllllllllIIIllllIllIlIlllI.put(new TabCompleteTracker());
        if (!lllllllllllllllIIIllllIllIlIlllI.has(ClientWorld.class)) {
            lllllllllllllllIIIllllIllIlIlllI.put(new ClientWorld(lllllllllllllllIIIllllIllIlIlllI));
        }
        lllllllllllllllIIIllllIllIlIlllI.put(new BlockStorage());
        if (Via.getConfig().isServersideBlockConnections() && Via.getManager().getProviders().get(BlockConnectionProvider.class) instanceof PacketBlockConnectionProvider) {
            lllllllllllllllIIIllllIllIlIlllI.put(new BlockConnectionStorage());
        }
    }
    
    protected String rewriteTeamMemberName(String lllllllllllllllIIIllllIllIIIllII) {
        if (ChatColorUtil.stripColor(lllllllllllllllIIIllllIllIIIllII).isEmpty()) {
            final StringBuilder lllllllllllllllIIIllllIllIIIllll = new StringBuilder();
            for (int lllllllllllllllIIIllllIllIIlIIII = 1; lllllllllllllllIIIllllIllIIlIIII < lllllllllllllllIIIllllIllIIIllII.length(); lllllllllllllllIIIllllIllIIlIIII += 2) {
                final char lllllllllllllllIIIllllIllIIlIIlI = lllllllllllllllIIIllllIllIIIllII.charAt(lllllllllllllllIIIllllIllIIlIIII);
                Character lllllllllllllllIIIllllIllIIlIIIl = Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.get(lllllllllllllllIIIllllIllIIlIIlI);
                if (lllllllllllllllIIIllllIllIIlIIIl == null) {
                    lllllllllllllllIIIllllIllIIlIIIl = lllllllllllllllIIIllllIllIIlIIlI;
                }
                lllllllllllllllIIIllllIllIIIllll.append('§').append(lllllllllllllllIIIllllIllIIlIIIl);
            }
            lllllllllllllllIIIllllIllIIIllII = String.valueOf(lllllllllllllllIIIllllIllIIIllll);
        }
        return lllllllllllllllIIIllllIllIIIllII;
    }
    
    @Override
    protected void registerPackets() {
        this.entityRewriter.register();
        this.itemRewriter.register();
        EntityPackets.register(this);
        WorldPackets.register(this);
        this.registerClientbound(State.LOGIN, 0, 0, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIIIlllIIllIIllIll -> ChatRewriter.processTranslate(lllllllllllllIlIIIlllIIllIIllIll.passthrough(Type.COMPONENT)));
            }
        });
        this.registerClientbound(State.STATUS, 0, 0, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIlIIIlIIlllllIII) throws Exception {
                        final String llllllllllllllIlIlIIIlIIllllIlll = llllllllllllllIlIlIIIlIIlllllIII.get(Type.STRING, 0);
                        try {
                            final JsonObject llllllllllllllIlIlIIIlIIlllllIll = GsonUtil.getGson().fromJson(llllllllllllllIlIlIIIlIIllllIlll, JsonObject.class);
                            if (llllllllllllllIlIlIIIlIIlllllIll.has("favicon")) {
                                llllllllllllllIlIlIIIlIIlllllIll.addProperty("favicon", llllllllllllllIlIlIIIlIIlllllIll.get("favicon").getAsString().replace("\n", ""));
                            }
                            llllllllllllllIlIlIIIlIIlllllIII.set(Type.STRING, 0, GsonUtil.getGson().toJson(llllllllllllllIlIlIIIlIIlllllIll));
                        }
                        catch (JsonParseException llllllllllllllIlIlIIIlIIlllllIlI) {
                            llllllllllllllIlIlIIIlIIlllllIlI.printStackTrace();
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.STATISTICS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIllIlIIllIIlll) throws Exception {
                        final int llllllllllllllIllIIllIlIIllIlIIl = llllllllllllllIllIIllIlIIllIIlll.read((Type<Integer>)Type.VAR_INT);
                        final List<StatisticData> llllllllllllllIllIIllIlIIllIlIII = new ArrayList<StatisticData>();
                        for (int llllllllllllllIllIIllIlIIllIllIl = 0; llllllllllllllIllIIllIlIIllIllIl < llllllllllllllIllIIllIlIIllIlIIl; ++llllllllllllllIllIIllIlIIllIllIl) {
                            final String llllllllllllllIllIIllIlIIlllIIlI = llllllllllllllIllIIllIlIIllIIlll.read(Type.STRING);
                            final String[] llllllllllllllIllIIllIlIIlllIIIl = llllllllllllllIllIIllIlIIlllIIlI.split("\\.");
                            int llllllllllllllIllIIllIlIIlllIIII = 0;
                            int llllllllllllllIllIIllIlIIllIllll = -1;
                            final int llllllllllllllIllIIllIlIIllIlllI = llllllllllllllIllIIllIlIIllIIlll.read((Type<Integer>)Type.VAR_INT);
                            if (llllllllllllllIllIIllIlIIlllIIIl.length == 2) {
                                llllllllllllllIllIIllIlIIlllIIII = 8;
                                final Integer llllllllllllllIllIIllIlIIlllIlII = StatisticMappings.CUSTOM_STATS.get(llllllllllllllIllIIllIlIIlllIIlI);
                                if (llllllllllllllIllIIllIlIIlllIlII != null) {
                                    llllllllllllllIllIIllIlIIllIllll = llllllllllllllIllIIllIlIIlllIlII;
                                }
                                else {
                                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find 1.13 -> 1.12.2 statistic mapping for ").append(llllllllllllllIllIIllIlIIlllIIlI)));
                                }
                            }
                            else if (llllllllllllllIllIIllIlIIlllIIIl.length > 2) {
                                final short llllllllllllllIllIIllIlIIlIlllIl;
                                final String llllllllllllllIllIIllIlIIlllIIll = (String)(llllllllllllllIllIIllIlIIlIlllIl = (short)llllllllllllllIllIIllIlIIlllIIIl[1]);
                                int llllllllllllllIllIIllIlIIlIlllII = -1;
                                switch (((String)llllllllllllllIllIIllIlIIlIlllIl).hashCode()) {
                                    case 664431610: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("mineBlock")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 0;
                                            break;
                                        }
                                        break;
                                    }
                                    case 1485652307: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("craftItem")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 1;
                                            break;
                                        }
                                        break;
                                    }
                                    case -148334278: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("useItem")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 2;
                                            break;
                                        }
                                        break;
                                    }
                                    case -1898270542: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("breakItem")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 3;
                                            break;
                                        }
                                        break;
                                    }
                                    case -988476804: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("pickup")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 4;
                                            break;
                                        }
                                        break;
                                    }
                                    case 3092207: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("drop")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 5;
                                            break;
                                        }
                                        break;
                                    }
                                    case -1964602143: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("killEntity")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 6;
                                            break;
                                        }
                                        break;
                                    }
                                    case -863208777: {
                                        if (((String)llllllllllllllIllIIllIlIIlIlllIl).equals("entityKilledBy")) {
                                            llllllllllllllIllIIllIlIIlIlllII = 7;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                switch (llllllllllllllIllIIllIlIIlIlllII) {
                                    case 0: {
                                        llllllllllllllIllIIllIlIIlllIIII = 0;
                                        break;
                                    }
                                    case 1: {
                                        llllllllllllllIllIIllIlIIlllIIII = 1;
                                        break;
                                    }
                                    case 2: {
                                        llllllllllllllIllIIllIlIIlllIIII = 2;
                                        break;
                                    }
                                    case 3: {
                                        llllllllllllllIllIIllIlIIlllIIII = 3;
                                        break;
                                    }
                                    case 4: {
                                        llllllllllllllIllIIllIlIIlllIIII = 4;
                                        break;
                                    }
                                    case 5: {
                                        llllllllllllllIllIIllIlIIlllIIII = 5;
                                        break;
                                    }
                                    case 6: {
                                        llllllllllllllIllIIllIlIIlllIIII = 6;
                                        break;
                                    }
                                    case 7: {
                                        llllllllllllllIllIIllIlIIlllIIII = 7;
                                        break;
                                    }
                                }
                            }
                            if (llllllllllllllIllIIllIlIIllIllll != -1) {
                                llllllllllllllIllIIllIlIIllIlIII.add(new StatisticData(llllllllllllllIllIIllIlIIlllIIII, llllllllllllllIllIIllIlIIllIllll, llllllllllllllIllIIllIlIIllIlllI));
                            }
                        }
                        llllllllllllllIllIIllIlIIllIIlll.write(Type.VAR_INT, llllllllllllllIllIIllIlIIllIlIII.size());
                        for (final StatisticData llllllllllllllIllIIllIlIIllIllII : llllllllllllllIllIIllIlIIllIlIII) {
                            llllllllllllllIllIIllIlIIllIIlll.write(Type.VAR_INT, llllllllllllllIllIIllIlIIllIllII.getCategoryId());
                            llllllllllllllIllIIllIlIIllIIlll.write(Type.VAR_INT, llllllllllllllIllIIllIlIIllIllII.getNewId());
                            llllllllllllllIllIIllIlIIllIIlll.write(Type.VAR_INT, llllllllllllllIllIIllIlIIllIllII.getValue());
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.BOSSBAR, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlllllIIIIlIlIIIl) throws Exception {
                        final int llllllllllllllIIlllllIIIIlIlIIlI = llllllllllllllIIlllllIIIIlIlIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        if (llllllllllllllIIlllllIIIIlIlIIlI == 0 || llllllllllllllIIlllllIIIIlIlIIlI == 3) {
                            ChatRewriter.processTranslate(llllllllllllllIIlllllIIIIlIlIIIl.passthrough(Type.COMPONENT));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllllIIIlIllIIlllIlllI -> ChatRewriter.processTranslate(lllllllllllllllIIIlIllIIlllIlllI.passthrough(Type.COMPONENT)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIlIllIIIIlIlIII) throws Exception {
                        lllllllllllllIllIIlIllIIIIlIlIII.write(Type.VAR_INT, lllllllllllllIllIIlIllIIIIlIlIII.user().get(TabCompleteTracker.class).getTransactionId());
                        final String lllllllllllllIllIIlIllIIIIlIllII = lllllllllllllIllIIlIllIIIIlIlIII.user().get(TabCompleteTracker.class).getInput();
                        int lllllllllllllIllIIlIllIIIIlIlIll = 0;
                        int lllllllllllllIllIIlIllIIIIlIlIlI = 0;
                        if (lllllllllllllIllIIlIllIIIIlIllII.endsWith(" ") || lllllllllllllIllIIlIllIIIIlIllII.isEmpty()) {
                            final int lllllllllllllIllIIlIllIIIIllIIll = lllllllllllllIllIIlIllIIIIlIllII.length();
                            final int lllllllllllllIllIIlIllIIIIllIIlI = 0;
                        }
                        else {
                            final int lllllllllllllIllIIlIllIIIIllIIIl = lllllllllllllIllIIlIllIIIIlIlIll = lllllllllllllIllIIlIllIIIIlIllII.lastIndexOf(32) + 1;
                            lllllllllllllIllIIlIllIIIIlIlIlI = lllllllllllllIllIIlIllIIIIlIllII.length() - lllllllllllllIllIIlIllIIIIllIIIl;
                        }
                        lllllllllllllIllIIlIllIIIIlIlIII.write(Type.VAR_INT, lllllllllllllIllIIlIllIIIIlIlIll);
                        lllllllllllllIllIIlIllIIIIlIlIII.write(Type.VAR_INT, lllllllllllllIllIIlIllIIIIlIlIlI);
                        for (int lllllllllllllIllIIlIllIIIIlIlIIl = lllllllllllllIllIIlIllIIIIlIlIII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIllIIlIllIIIIlIllll = 0; lllllllllllllIllIIlIllIIIIlIllll < lllllllllllllIllIIlIllIIIIlIlIIl; ++lllllllllllllIllIIlIllIIIIlIllll) {
                            String lllllllllllllIllIIlIllIIIIllIIII = lllllllllllllIllIIlIllIIIIlIlIII.read(Type.STRING);
                            if (lllllllllllllIllIIlIllIIIIllIIII.startsWith("/") && lllllllllllllIllIIlIllIIIIlIlIll == 0) {
                                lllllllllllllIllIIlIllIIIIllIIII = lllllllllllllIllIIlIllIIIIllIIII.substring(1);
                            }
                            lllllllllllllIllIIlIllIIIIlIlIII.write(Type.STRING, lllllllllllllIllIIlIllIIIIllIIII);
                            lllllllllllllIllIIlIllIIIIlIlIII.write(Type.BOOLEAN, false);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.handler(lllllllllllllllIIIllIlIIIIIIlIII -> ChatRewriter.processTranslate(lllllllllllllllIIIllIlIIIIIIlIII.passthrough(Type.COMPONENT)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.COOLDOWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIlIIlIlIllIIll) throws Exception {
                        final int llllllllllllllIllIIlIIlIlIllIIlI = llllllllllllllIllIIlIIlIlIllIIll.read((Type<Integer>)Type.VAR_INT);
                        final int llllllllllllllIllIIlIIlIlIllIIIl = llllllllllllllIllIIlIIlIlIllIIll.read((Type<Integer>)Type.VAR_INT);
                        llllllllllllllIllIIlIIlIlIllIIll.cancel();
                        if (llllllllllllllIllIIlIIlIlIllIIlI == 383) {
                            for (int llllllllllllllIllIIlIIlIlIlllIII = 0; llllllllllllllIllIIlIIlIlIlllIII < 44; ++llllllllllllllIllIIlIIlIlIlllIII) {
                                final Integer llllllllllllllIllIIlIIlIlIlllIIl = Protocol1_13To1_12_2.this.getMappingData().getItemMappings().get(llllllllllllllIllIIlIIlIlIllIIlI << 16 | llllllllllllllIllIIlIIlIlIlllIII);
                                if (llllllllllllllIllIIlIIlIlIlllIIl == null) {
                                    break;
                                }
                                final PacketWrapper llllllllllllllIllIIlIIlIlIlllIlI = llllllllllllllIllIIlIIlIlIllIIll.create(ClientboundPackets1_13.COOLDOWN);
                                llllllllllllllIllIIlIIlIlIlllIlI.write(Type.VAR_INT, llllllllllllllIllIIlIIlIlIlllIIl);
                                llllllllllllllIllIIlIIlIlIlllIlI.write(Type.VAR_INT, llllllllllllllIllIIlIIlIlIllIIIl);
                                llllllllllllllIllIIlIIlIlIlllIlI.send(Protocol1_13To1_12_2.class);
                            }
                        }
                        else {
                            for (int llllllllllllllIllIIlIIlIlIllIlIl = 0; llllllllllllllIllIIlIIlIlIllIlIl < 16; ++llllllllllllllIllIIlIIlIlIllIlIl) {
                                final int llllllllllllllIllIIlIIlIlIllIllI = Protocol1_13To1_12_2.this.getMappingData().getItemMappings().get(llllllllllllllIllIIlIIlIlIllIIlI << 4 | llllllllllllllIllIIlIIlIlIllIlIl);
                                if (llllllllllllllIllIIlIIlIlIllIllI == -1) {
                                    break;
                                }
                                final PacketWrapper llllllllllllllIllIIlIIlIlIllIlll = llllllllllllllIllIIlIIlIlIllIIll.create(ClientboundPackets1_13.COOLDOWN);
                                llllllllllllllIllIIlIIlIlIllIlll.write(Type.VAR_INT, llllllllllllllIllIIlIIlIlIllIllI);
                                llllllllllllllIllIIlIIlIlIllIlll.write(Type.VAR_INT, llllllllllllllIllIIlIIlIlIllIIIl);
                                llllllllllllllIllIIlIIlIlIllIlll.send(Protocol1_13To1_12_2.class);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.DISCONNECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllllIIlIIlIllIlIlllll -> ChatRewriter.processTranslate(lllllllllllllllIIlIIlIllIlIlllll.passthrough(Type.COMPONENT)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIlllIllIIIIlIlII) throws Exception {
                        final int llllllllllllllIlIlllIllIIIIlIlll = llllllllllllllIlIlllIllIIIIlIlII.get((Type<Integer>)Type.INT, 0);
                        final int llllllllllllllIlIlllIllIIIIlIllI = llllllllllllllIlIlllIllIIIIlIlII.get((Type<Integer>)Type.INT, 1);
                        if (llllllllllllllIlIlllIllIIIIlIlll == 1010) {
                            llllllllllllllIlIlllIllIIIIlIlII.set(Type.INT, 1, Protocol1_13To1_12_2.this.getMappingData().getItemMappings().get(llllllllllllllIlIlllIllIIIIlIllI << 4));
                        }
                        else if (llllllllllllllIlIlllIllIIIIlIlll == 2001) {
                            final int llllllllllllllIlIlllIllIIIIllIll = llllllllllllllIlIlllIllIIIIlIllI & 0xFFF;
                            final int llllllllllllllIlIlllIllIIIIllIlI = llllllllllllllIlIlllIllIIIIlIllI >> 12;
                            llllllllllllllIlIlllIllIIIIlIlII.set(Type.INT, 1, WorldPackets.toNewId(llllllllllllllIlIlllIllIIIIllIll << 4 | llllllllllllllIlIlllIllIIIIllIlI));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIIIIlIlllIlIllI) throws Exception {
                        final int lllllllllllllIlIlIIIIlIlllIllIIl = lllllllllllllIlIlIIIIlIlllIlIllI.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIlIlIIIIlIlllIlIllI.user().getEntityTracker(Protocol1_13To1_12_2.class).addEntity(lllllllllllllIlIlIIIIlIlllIllIIl, Entity1_13Types.EntityType.PLAYER);
                        final ClientWorld lllllllllllllIlIlIIIIlIlllIllIII = lllllllllllllIlIlIIIIlIlllIlIllI.user().get(ClientWorld.class);
                        final int lllllllllllllIlIlIIIIlIlllIlIlll = lllllllllllllIlIlIIIIlIlllIlIllI.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIlIlIIIIlIlllIllIII.setEnvironment(lllllllllllllIlIlIIIIlIlllIlIlll);
                    }
                });
                this.handler(Protocol1_13To1_12_2.SEND_DECLARE_COMMANDS_AND_TAGS);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.CRAFT_RECIPE_RESPONSE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE);
                this.handler(llllllllllllllIllllIllIIIlllllII -> llllllllllllllIllllIllIIIlllllII.write(Type.STRING, String.valueOf(new StringBuilder().append("viaversion:legacy/").append(llllllllllllllIllllIllIIIlllllII.read((Type<Object>)Type.VAR_INT)))));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.COMBAT_EVENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIlIIIlIlllIIlllI) throws Exception {
                        if (lllllllllllllIllIlIIIlIlllIIlllI.get((Type<Integer>)Type.VAR_INT, 0) == 2) {
                            lllllllllllllIllIlIIIlIlllIIlllI.passthrough((Type<Object>)Type.VAR_INT);
                            lllllllllllllIllIlIIIlIlllIIlllI.passthrough((Type<Object>)Type.INT);
                            ChatRewriter.processTranslate(lllllllllllllIllIlIIIlIlllIIlllI.passthrough(Type.COMPONENT));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIIlllIIlllIlIl) throws Exception {
                        for (int lllllllllllllIIIllIIlllIIlllIlII = lllllllllllllIIIllIIlllIIlllIlIl.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIIllIIlllIIlllIlll = 0; lllllllllllllIIIllIIlllIIlllIlll < lllllllllllllIIIllIIlllIIlllIlII; ++lllllllllllllIIIllIIlllIIlllIlll) {
                            final byte lllllllllllllIIIllIIlllIIllllIlI = lllllllllllllIIIllIIlllIIlllIlIl.read((Type<Byte>)Type.BYTE);
                            final int lllllllllllllIIIllIIlllIIllllIIl = (lllllllllllllIIIllIIlllIIllllIlI & 0xF0) >> 4;
                            lllllllllllllIIIllIIlllIIlllIlIl.write(Type.VAR_INT, lllllllllllllIIIllIIlllIIllllIIl);
                            lllllllllllllIIIllIIlllIIlllIlIl.passthrough((Type<Object>)Type.BYTE);
                            lllllllllllllIIIllIIlllIIlllIlIl.passthrough((Type<Object>)Type.BYTE);
                            final byte lllllllllllllIIIllIIlllIIllllIII = (byte)(lllllllllllllIIIllIIlllIIllllIlI & 0xF);
                            lllllllllllllIIIllIIlllIIlllIlIl.write(Type.BYTE, lllllllllllllIIIllIIlllIIllllIII);
                            lllllllllllllIIIllIIlllIIlllIlIl.write(Type.OPTIONAL_COMPONENT, null);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.UNLOCK_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIllIlllIIIlIIllI) throws Exception {
                        lllllllllllllIIlIllIlllIIIlIIllI.write(Type.BOOLEAN, false);
                        lllllllllllllIIlIllIlllIIIlIIllI.write(Type.BOOLEAN, false);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIlIllllllIlIIlI) throws Exception {
                        final int lllllllllllllIlIlIlIllllllIlIIIl = lllllllllllllIlIlIlIllllllIlIIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        for (int lllllllllllllIlIlIlIllllllIlIlII = 0; lllllllllllllIlIlIlIllllllIlIlII < ((lllllllllllllIlIlIlIllllllIlIIIl == 0) ? 2 : 1); ++lllllllllllllIlIlIlIllllllIlIlII) {
                            final int[] lllllllllllllIlIlIlIllllllIlIllI = lllllllllllllIlIlIlIllllllIlIIlI.read(Type.VAR_INT_ARRAY_PRIMITIVE);
                            final String[] lllllllllllllIlIlIlIllllllIlIlIl = new String[lllllllllllllIlIlIlIllllllIlIllI.length];
                            for (int lllllllllllllIlIlIlIllllllIlIlll = 0; lllllllllllllIlIlIlIllllllIlIlll < lllllllllllllIlIlIlIllllllIlIllI.length; ++lllllllllllllIlIlIlIllllllIlIlll) {
                                lllllllllllllIlIlIlIllllllIlIlIl[lllllllllllllIlIlIlIllllllIlIlll] = String.valueOf(new StringBuilder().append("viaversion:legacy/").append(lllllllllllllIlIlIlIllllllIlIllI[lllllllllllllIlIlIlIllllllIlIlll]));
                            }
                            lllllllllllllIlIlIlIllllllIlIIlI.write(Type.STRING_ARRAY, lllllllllllllIlIlIlIllllllIlIlIl);
                        }
                        if (lllllllllllllIlIlIlIllllllIlIIIl == 0) {
                            lllllllllllllIlIlIlIllllllIlIIlI.create(ClientboundPackets1_13.DECLARE_RECIPES, new PacketHandler() {
                                @Override
                                public void handle(final PacketWrapper llllllllllllllIIlllIIlIIllIIIIIl) throws Exception {
                                    llllllllllllllIIlllIIlIIllIIIIIl.write(Type.VAR_INT, RecipeData.recipes.size());
                                    for (final Map.Entry<String, RecipeData.Recipe> llllllllllllllIIlllIIlIIllIIIlII : RecipeData.recipes.entrySet()) {
                                        llllllllllllllIIlllIIlIIllIIIIIl.write(Type.STRING, llllllllllllllIIlllIIlIIllIIIlII.getKey());
                                        llllllllllllllIIlllIIlIIllIIIIIl.write(Type.STRING, llllllllllllllIIlllIIlIIllIIIlII.getValue().getType());
                                        final String llllllllllllllIIlllIIlIIlIlllllI = llllllllllllllIIlllIIlIIllIIIlII.getValue().getType();
                                        char llllllllllllllIIlllIIlIIlIllllIl = (char)(-1);
                                        switch (llllllllllllllIIlllIIlIIlIlllllI.hashCode()) {
                                            case -571676035: {
                                                if (llllllllllllllIIlllIIlIIlIlllllI.equals("crafting_shapeless")) {
                                                    llllllllllllllIIlllIIlIIlIllllIl = '\0';
                                                    break;
                                                }
                                                break;
                                            }
                                            case 1533084160: {
                                                if (llllllllllllllIIlllIIlIIlIlllllI.equals("crafting_shaped")) {
                                                    llllllllllllllIIlllIIlIIlIllllIl = '\u0001';
                                                    break;
                                                }
                                                break;
                                            }
                                            case -491776273: {
                                                if (llllllllllllllIIlllIIlIIlIlllllI.equals("smelting")) {
                                                    llllllllllllllIIlllIIlIIlIllllIl = '\u0002';
                                                    break;
                                                }
                                                break;
                                            }
                                        }
                                        switch (llllllllllllllIIlllIIlIIlIllllIl) {
                                            case '\0': {
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.STRING, llllllllllllllIIlllIIlIIllIIIlII.getValue().getGroup());
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.VAR_INT, llllllllllllllIIlllIIlIIllIIIlII.getValue().getIngredients().length);
                                                final DataItem[][] ingredients = llllllllllllllIIlllIIlIIllIIIlII.getValue().getIngredients();
                                                final Exception llllllllllllllIIlllIIlIIlIlllIll = (Exception)ingredients.length;
                                                for (short llllllllllllllIIlllIIlIIlIlllIlI = 0; llllllllllllllIIlllIIlIIlIlllIlI < llllllllllllllIIlllIIlIIlIlllIll; ++llllllllllllllIIlllIIlIIlIlllIlI) {
                                                    final Item[] llllllllllllllIIlllIIlIIllIIlIlI = ingredients[llllllllllllllIIlllIIlIIlIlllIlI];
                                                    final Item[] llllllllllllllIIlllIIlIIllIIlIll = llllllllllllllIIlllIIlIIllIIlIlI.clone();
                                                    for (int llllllllllllllIIlllIIlIIllIIllII = 0; llllllllllllllIIlllIIlIIllIIllII < llllllllllllllIIlllIIlIIllIIlIll.length; ++llllllllllllllIIlllIIlIIllIIllII) {
                                                        if (llllllllllllllIIlllIIlIIllIIlIll[llllllllllllllIIlllIIlIIllIIllII] != null) {
                                                            llllllllllllllIIlllIIlIIllIIlIll[llllllllllllllIIlllIIlIIllIIllII] = new DataItem(llllllllllllllIIlllIIlIIllIIlIll[llllllllllllllIIlllIIlIIllIIllII]);
                                                        }
                                                    }
                                                    llllllllllllllIIlllIIlIIllIIIIIl.write(Type.FLAT_ITEM_ARRAY_VAR_INT, llllllllllllllIIlllIIlIIllIIlIll);
                                                }
                                                llllllllllllllIIlllIIlIIllIIIIIl.write((Type<DataItem>)Type.FLAT_ITEM, new DataItem(llllllllllllllIIlllIIlIIllIIIlII.getValue().getResult()));
                                                continue;
                                            }
                                            case '\u0001': {
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.VAR_INT, llllllllllllllIIlllIIlIIllIIIlII.getValue().getWidth());
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.VAR_INT, llllllllllllllIIlllIIlIIllIIIlII.getValue().getHeight());
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.STRING, llllllllllllllIIlllIIlIIllIIIlII.getValue().getGroup());
                                                final DataItem[][] ingredients2 = llllllllllllllIIlllIIlIIllIIIlII.getValue().getIngredients();
                                                final Exception llllllllllllllIIlllIIlIIlIlllIll = (Exception)ingredients2.length;
                                                for (short llllllllllllllIIlllIIlIIlIlllIlI = 0; llllllllllllllIIlllIIlIIlIlllIlI < llllllllllllllIIlllIIlIIlIlllIll; ++llllllllllllllIIlllIIlIIlIlllIlI) {
                                                    final Item[] llllllllllllllIIlllIIlIIllIIIlll = ingredients2[llllllllllllllIIlllIIlIIlIlllIlI];
                                                    final Item[] llllllllllllllIIlllIIlIIllIIlIII = llllllllllllllIIlllIIlIIllIIIlll.clone();
                                                    for (int llllllllllllllIIlllIIlIIllIIlIIl = 0; llllllllllllllIIlllIIlIIllIIlIIl < llllllllllllllIIlllIIlIIllIIlIII.length; ++llllllllllllllIIlllIIlIIllIIlIIl) {
                                                        if (llllllllllllllIIlllIIlIIllIIlIII[llllllllllllllIIlllIIlIIllIIlIIl] != null) {
                                                            llllllllllllllIIlllIIlIIllIIlIII[llllllllllllllIIlllIIlIIllIIlIIl] = new DataItem(llllllllllllllIIlllIIlIIllIIlIII[llllllllllllllIIlllIIlIIllIIlIIl]);
                                                        }
                                                    }
                                                    llllllllllllllIIlllIIlIIllIIIIIl.write(Type.FLAT_ITEM_ARRAY_VAR_INT, llllllllllllllIIlllIIlIIllIIlIII);
                                                }
                                                llllllllllllllIIlllIIlIIllIIIIIl.write((Type<DataItem>)Type.FLAT_ITEM, new DataItem(llllllllllllllIIlllIIlIIllIIIlII.getValue().getResult()));
                                                continue;
                                            }
                                            case '\u0002': {
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.STRING, llllllllllllllIIlllIIlIIllIIIlII.getValue().getGroup());
                                                final Item[] llllllllllllllIIlllIIlIIllIIIlIl = llllllllllllllIIlllIIlIIllIIIlII.getValue().getIngredient().clone();
                                                for (int llllllllllllllIIlllIIlIIllIIIllI = 0; llllllllllllllIIlllIIlIIllIIIllI < llllllllllllllIIlllIIlIIllIIIlIl.length; ++llllllllllllllIIlllIIlIIllIIIllI) {
                                                    if (llllllllllllllIIlllIIlIIllIIIlIl[llllllllllllllIIlllIIlIIllIIIllI] != null) {
                                                        llllllllllllllIIlllIIlIIllIIIlIl[llllllllllllllIIlllIIlIIllIIIllI] = new DataItem(llllllllllllllIIlllIIlIIllIIIlIl[llllllllllllllIIlllIIlIIllIIIllI]);
                                                    }
                                                }
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.FLAT_ITEM_ARRAY_VAR_INT, llllllllllllllIIlllIIlIIllIIIlIl);
                                                llllllllllllllIIlllIIlIIllIIIIIl.write((Type<DataItem>)Type.FLAT_ITEM, new DataItem(llllllllllllllIIlllIIlIIllIIIlII.getValue().getResult()));
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.FLOAT, llllllllllllllIIlllIIlIIllIIIlII.getValue().getExperience());
                                                llllllllllllllIIlllIIlIIllIIIIIl.write(Type.VAR_INT, llllllllllllllIIlllIIlIIllIIIlII.getValue().getCookingTime());
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }).send(Protocol1_13To1_12_2.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIlllllIIllIlIlI) throws Exception {
                        final ClientWorld lllllllllllllIIIIIlllllIIllIlIIl = lllllllllllllIIIIIlllllIIllIlIlI.user().get(ClientWorld.class);
                        final int lllllllllllllIIIIIlllllIIllIlIII = lllllllllllllIIIIIlllllIIllIlIlI.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIIIIIlllllIIllIlIIl.setEnvironment(lllllllllllllIIIIIlllllIIllIlIII);
                        if (Via.getConfig().isServersideBlockConnections()) {
                            ConnectionData.clearBlockStorage(lllllllllllllIIIIIlllllIIllIlIlI.user());
                        }
                    }
                });
                this.handler(Protocol1_13To1_12_2.SEND_DECLARE_COMMANDS_AND_TAGS);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.SCOREBOARD_OBJECTIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIIllIIIllllIllI) throws Exception {
                        final byte lllllllllllllIIIlIIllIIIllllIlll = lllllllllllllIIIlIIllIIIllllIllI.get((Type<Byte>)Type.BYTE, 0);
                        if (lllllllllllllIIIlIIllIIIllllIlll == 0 || lllllllllllllIIIlIIllIIIllllIlll == 2) {
                            final String lllllllllllllIIIlIIllIIIlllllIll = lllllllllllllIIIlIIllIIIllllIllI.read(Type.STRING);
                            lllllllllllllIIIlIIllIIIllllIllI.write(Type.COMPONENT, ChatRewriter.legacyTextToJson(lllllllllllllIIIlIIllIIIlllllIll));
                            final String lllllllllllllIIIlIIllIIIlllllIlI = lllllllllllllIIIlIIllIIIllllIllI.read(Type.STRING);
                            lllllllllllllIIIlIIllIIIllllIllI.write(Type.VAR_INT, lllllllllllllIIIlIIllIIIlllllIlI.equals("integer") ? 0 : 1);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.TEAMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlllIIIIlIIlllllIIl) throws Exception {
                        final byte lllllllllllllIlllIIIIlIIlllllIII = lllllllllllllIlllIIIIlIIlllllIIl.get((Type<Byte>)Type.BYTE, 0);
                        if (lllllllllllllIlllIIIIlIIlllllIII == 0 || lllllllllllllIlllIIIIlIIlllllIII == 2) {
                            final String lllllllllllllIlllIIIIlIlIIIIIIII = lllllllllllllIlllIIIIlIIlllllIIl.read(Type.STRING);
                            lllllllllllllIlllIIIIlIIlllllIIl.write(Type.COMPONENT, ChatRewriter.legacyTextToJson(lllllllllllllIlllIIIIlIlIIIIIIII));
                            final String lllllllllllllIlllIIIIlIIllllllll = lllllllllllllIlllIIIIlIIlllllIIl.read(Type.STRING);
                            String lllllllllllllIlllIIIIlIIlllllllI = lllllllllllllIlllIIIIlIIlllllIIl.read(Type.STRING);
                            lllllllllllllIlllIIIIlIIlllllIIl.passthrough((Type<Object>)Type.BYTE);
                            lllllllllllllIlllIIIIlIIlllllIIl.passthrough(Type.STRING);
                            lllllllllllllIlllIIIIlIIlllllIIl.passthrough(Type.STRING);
                            int lllllllllllllIlllIIIIlIIllllllIl = lllllllllllllIlllIIIIlIIlllllIIl.read((Type<Byte>)Type.BYTE);
                            if (lllllllllllllIlllIIIIlIIllllllIl == -1) {
                                lllllllllllllIlllIIIIlIIllllllIl = 21;
                            }
                            if (Via.getConfig().is1_13TeamColourFix()) {
                                final char lllllllllllllIlllIIIIlIlIIIIIIIl = Protocol1_13To1_12_2.this.getLastColorChar(lllllllllllllIlllIIIIlIIllllllll);
                                lllllllllllllIlllIIIIlIIllllllIl = ChatColorUtil.getColorOrdinal(lllllllllllllIlllIIIIlIlIIIIIIIl);
                                lllllllllllllIlllIIIIlIIlllllllI = String.valueOf(new StringBuilder().append('§').append(Character.toString(lllllllllllllIlllIIIIlIlIIIIIIIl)).append(lllllllllllllIlllIIIIlIIlllllllI));
                            }
                            lllllllllllllIlllIIIIlIIlllllIIl.write(Type.VAR_INT, lllllllllllllIlllIIIIlIIllllllIl);
                            lllllllllllllIlllIIIIlIIlllllIIl.write(Type.COMPONENT, ChatRewriter.legacyTextToJson(lllllllllllllIlllIIIIlIIllllllll));
                            lllllllllllllIlllIIIIlIIlllllIIl.write(Type.COMPONENT, ChatRewriter.legacyTextToJson(lllllllllllllIlllIIIIlIIlllllllI));
                        }
                        if (lllllllllllllIlllIIIIlIIlllllIII == 0 || lllllllllllllIlllIIIIlIIlllllIII == 3 || lllllllllllllIlllIIIIlIIlllllIII == 4) {
                            final String[] lllllllllllllIlllIIIIlIIlllllIll = lllllllllllllIlllIIIIlIIlllllIIl.read(Type.STRING_ARRAY);
                            for (int lllllllllllllIlllIIIIlIIllllllII = 0; lllllllllllllIlllIIIIlIIllllllII < lllllllllllllIlllIIIIlIIlllllIll.length; ++lllllllllllllIlllIIIIlIIllllllII) {
                                lllllllllllllIlllIIIIlIIlllllIll[lllllllllllllIlllIIIIlIIllllllII] = Protocol1_13To1_12_2.this.rewriteTeamMemberName(lllllllllllllIlllIIIIlIIlllllIll[lllllllllllllIlllIIIIlIIllllllII]);
                            }
                            lllllllllllllIlllIIIIlIIlllllIIl.write(Type.STRING_ARRAY, lllllllllllllIlllIIIIlIIlllllIll);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.UPDATE_SCORE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllllIlIIlIllIIIII) throws Exception {
                        String lllllllllllllllllllIlIIlIlIlllll = lllllllllllllllllllIlIIlIllIIIII.read(Type.STRING);
                        lllllllllllllllllllIlIIlIlIlllll = Protocol1_13To1_12_2.this.rewriteTeamMemberName(lllllllllllllllllllIlIIlIlIlllll);
                        lllllllllllllllllllIlIIlIllIIIII.write(Type.STRING, lllllllllllllllllllIlIIlIlIlllll);
                        final byte lllllllllllllllllllIlIIlIlIllllI = lllllllllllllllllllIlIIlIllIIIII.read((Type<Byte>)Type.BYTE);
                        lllllllllllllllllllIlIIlIllIIIII.write(Type.BYTE, lllllllllllllllllllIlIIlIlIllllI);
                        lllllllllllllllllllIlIIlIllIIIII.passthrough(Type.STRING);
                        if (lllllllllllllllllllIlIIlIlIllllI != 1) {
                            lllllllllllllllllllIlIIlIllIIIII.passthrough((Type<Object>)Type.VAR_INT);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.TITLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIIlIlllIIIIIllll) throws Exception {
                        final int lllllllllllllllIIIlIlllIIIIlIIII = lllllllllllllllIIIlIlllIIIIIllll.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lllllllllllllllIIIlIlllIIIIlIIII >= 0 && lllllllllllllllIIIlIlllIIIIlIIII <= 2) {
                            ChatRewriter.processTranslate(lllllllllllllllIIIlIlllIIIIIllll.passthrough(Type.COMPONENT));
                        }
                    }
                });
            }
        });
        new SoundRewriter(this).registerSound(ClientboundPackets1_12_1.SOUND);
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.TAB_LIST, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIlllIIIIllIIIlIl) throws Exception {
                        ChatRewriter.processTranslate(lllllllllllllIllIlllIIIIllIIIlIl.passthrough(Type.COMPONENT));
                        ChatRewriter.processTranslate(lllllllllllllIllIlllIIIIllIIIlIl.passthrough(Type.COMPONENT));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.ADVANCEMENTS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIIIlIIIIlIlIlll) throws Exception {
                        lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Object>)Type.BOOLEAN);
                        for (int lllllllllllllllllIIIlIIIIlIlIllI = lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllllllIIIlIIIIlIllIIl = 0; lllllllllllllllllIIIlIIIIlIllIIl < lllllllllllllllllIIIlIIIIlIlIllI; ++lllllllllllllllllIIIlIIIIlIllIIl) {
                            lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.STRING);
                            if (lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.STRING);
                            }
                            if (lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                ChatRewriter.processTranslate(lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.COMPONENT));
                                ChatRewriter.processTranslate(lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.COMPONENT));
                                final Item lllllllllllllllllIIIlIIIIlIlllIl = lllllllllllllllllIIIlIIIIlIlIlll.read(Type.ITEM);
                                Protocol1_13To1_12_2.this.itemRewriter.handleItemToClient(lllllllllllllllllIIIlIIIIlIlllIl);
                                lllllllllllllllllIIIlIIIIlIlIlll.write(Type.FLAT_ITEM, lllllllllllllllllIIIlIIIIlIlllIl);
                                lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Object>)Type.VAR_INT);
                                final int lllllllllllllllllIIIlIIIIlIlllII = lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Integer>)Type.INT);
                                if ((lllllllllllllllllIIIlIIIIlIlllII & 0x1) != 0x0) {
                                    lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.STRING);
                                }
                                lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Object>)Type.FLOAT);
                                lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Object>)Type.FLOAT);
                            }
                            lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.STRING_ARRAY);
                            for (int lllllllllllllllllIIIlIIIIlIllIlI = lllllllllllllllllIIIlIIIIlIlIlll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllllllIIIlIIIIlIllIll = 0; lllllllllllllllllIIIlIIIIlIllIll < lllllllllllllllllIIIlIIIIlIllIlI; ++lllllllllllllllllIIIlIIIIlIllIll) {
                                lllllllllllllllllIIIlIIIIlIlIlll.passthrough(Type.STRING_ARRAY);
                            }
                        }
                    }
                });
            }
        });
        this.cancelServerbound(State.LOGIN, 2);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).cancelServerbound(ServerboundPackets1_13.QUERY_BLOCK_NBT);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIIIlllIIIIIllI) throws Exception {
                        if (Via.getConfig().isDisable1_13AutoComplete()) {
                            llllllllllllllIIllIIIlllIIIIIllI.cancel();
                        }
                        final int llllllllllllllIIllIIIlllIIIIIlIl = llllllllllllllIIllIIIlllIIIIIllI.read((Type<Integer>)Type.VAR_INT);
                        llllllllllllllIIllIIIlllIIIIIllI.user().get(TabCompleteTracker.class).setTransactionId(llllllllllllllIIllIIIlllIIIIIlIl);
                    }
                });
                this.map(Type.STRING, (ValueTransformer<String, Object>)new ValueTransformer<String, String>(Type.STRING) {
                    @Override
                    public String transform(final PacketWrapper lllllllllllllIlllIlIlllIIIlllllI, final String lllllllllllllIlllIlIlllIIIlllIll) {
                        lllllllllllllIlllIlIlllIIIlllllI.user().get(TabCompleteTracker.class).setInput(lllllllllllllIlllIlIlllIIIlllIll);
                        return String.valueOf(new StringBuilder().append("/").append(lllllllllllllIlllIlIlllIIIlllIll));
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIllIIlIIlIlllll) throws Exception {
                        lllllllllllllIllIIllIIlIIlIlllll.write(Type.BOOLEAN, false);
                        lllllllllllllIllIIllIIlIIlIlllll.write(Type.OPTIONAL_POSITION, null);
                        if (!lllllllllllllIllIIllIIlIIlIlllll.isCancelled() && Via.getConfig().get1_13TabCompleteDelay() > 0) {
                            final TabCompleteTracker lllllllllllllIllIIllIIlIIllIIIIl = lllllllllllllIllIIllIIlIIlIlllll.user().get(TabCompleteTracker.class);
                            lllllllllllllIllIIllIIlIIlIlllll.cancel();
                            lllllllllllllIllIIllIIlIIllIIIIl.setTimeToSend(System.currentTimeMillis() + Via.getConfig().get1_13TabCompleteDelay() * 50L);
                            lllllllllllllIllIIllIIlIIllIIIIl.setLastTabComplete(lllllllllllllIllIIllIIlIIlIlllll.get(Type.STRING, 0));
                        }
                    }
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIllllllllIIIllI) throws Exception {
                        final Item llllllllllllllIIIIllllllllIIIlIl = llllllllllllllIIIIllllllllIIIllI.read(Type.FLAT_ITEM);
                        final boolean llllllllllllllIIIIllllllllIIIlII = llllllllllllllIIIIllllllllIIIllI.read((Type<Boolean>)Type.BOOLEAN);
                        Protocol1_13To1_12_2.this.itemRewriter.handleItemToServer(llllllllllllllIIIIllllllllIIIlIl);
                        llllllllllllllIIIIllllllllIIIllI.write(Type.STRING, llllllllllllllIIIIllllllllIIIlII ? "MC|BSign" : "MC|BEdit");
                        llllllllllllllIIIIllllllllIIIllI.write(Type.ITEM, llllllllllllllIIIIllllllllIIIlIl);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).cancelServerbound(ServerboundPackets1_13.ENTITY_NBT_REQUEST);
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.PICK_ITEM, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIIllllllIlIIIll) throws Exception {
                        llllllllllllllIIIIIllllllIlIIIll.write(Type.STRING, "MC|PickItem");
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.CRAFT_RECIPE_REQUEST, new PacketRemapper() {
            @Override
            public void registerMap() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getstatic       com/viaversion/viaversion/api/type/Type.BYTE:Lcom/viaversion/viaversion/api/type/types/ByteType;
                //     4: invokevirtual   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/Protocol1_13To1_12_2$26.map:(Lcom/viaversion/viaversion/api/type/Type;)V
                //     7: aload_0         /* llllllllllllllIlIIIllIllIllIlllI */
                //     8: invokedynamic   BootstrapMethod #0, handle:()Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
                //    13: invokevirtual   com/viaversion/viaversion/protocols/protocol1_13to1_12_2/Protocol1_13To1_12_2$26.handler:(Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;)V
                //    16: return         
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.RECIPE_BOOK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllllIIlIIIIlllllll) throws Exception {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     1: getstatic       com/viaversion/viaversion/api/type/Type.VAR_INT:Lcom/viaversion/viaversion/api/type/types/VarIntType;
                        //     4: iconst_0       
                        //     5: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.get:(Lcom/viaversion/viaversion/api/type/Type;I)Ljava/lang/Object;
                        //    10: checkcast       Ljava/lang/Integer;
                        //    13: invokevirtual   java/lang/Integer.intValue:()I
                        //    16: istore_2        /* llllllllllllllllllIIlIIIlIIIIIII */
                        //    17: iload_2         /* llllllllllllllllllIIlIIIlIIIIIII */
                        //    18: ifne            76
                        //    21: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //    22: getstatic       com/viaversion/viaversion/api/type/Type.STRING:Lcom/viaversion/viaversion/api/type/Type;
                        //    25: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.read:(Lcom/viaversion/viaversion/api/type/Type;)Ljava/lang/Object;
                        //    30: checkcast       Ljava/lang/String;
                        //    33: astore_3        /* llllllllllllllllllIIlIIIIlllllIl */
                        //    34: aload_3         /* llllllllllllllllllIIlIIIlIIIIlII */
                        //    35: invokevirtual   java/lang/String.length:()I
                        //    38: bipush          19
                        //    40: if_icmplt       58
                        //    43: aload_3         /* llllllllllllllllllIIlIIIlIIIIlII */
                        //    44: bipush          18
                        //    46: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
                        //    49: invokestatic    com/google/common/primitives/Ints.tryParse:(Ljava/lang/String;)Ljava/lang/Integer;
                        //    52: dup            
                        //    53: astore          llllllllllllllllllIIlIIIlIIIIlIl
                        //    55: ifnonnull       65
                        //    58: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //    59: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.cancel:()V
                        //    64: return         
                        //    65: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //    66: getstatic       com/viaversion/viaversion/api/type/Type.INT:Lcom/viaversion/viaversion/api/type/types/IntType;
                        //    69: aload           llllllllllllllllllIIlIIIlIIIIIll
                        //    71: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.write:(Lcom/viaversion/viaversion/api/type/Type;Ljava/lang/Object;)V
                        //    76: iload_2         /* llllllllllllllllllIIlIIIlIIIIIII */
                        //    77: iconst_1       
                        //    78: if_icmpne       121
                        //    81: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //    82: getstatic       com/viaversion/viaversion/api/type/Type.BOOLEAN:Lcom/viaversion/viaversion/api/type/types/BooleanType;
                        //    85: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.passthrough:(Lcom/viaversion/viaversion/api/type/Type;)Ljava/lang/Object;
                        //    90: pop            
                        //    91: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //    92: getstatic       com/viaversion/viaversion/api/type/Type.BOOLEAN:Lcom/viaversion/viaversion/api/type/types/BooleanType;
                        //    95: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.passthrough:(Lcom/viaversion/viaversion/api/type/Type;)Ljava/lang/Object;
                        //   100: pop            
                        //   101: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //   102: getstatic       com/viaversion/viaversion/api/type/Type.BOOLEAN:Lcom/viaversion/viaversion/api/type/types/BooleanType;
                        //   105: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.read:(Lcom/viaversion/viaversion/api/type/Type;)Ljava/lang/Object;
                        //   110: pop            
                        //   111: aload_1         /* llllllllllllllllllIIlIIIlIIIIIIl */
                        //   112: getstatic       com/viaversion/viaversion/api/type/Type.BOOLEAN:Lcom/viaversion/viaversion/api/type/types/BooleanType;
                        //   115: invokeinterface com/viaversion/viaversion/api/protocol/packet/PacketWrapper.read:(Lcom/viaversion/viaversion/api/type/Type;)Ljava/lang/Object;
                        //   120: pop            
                        //   121: return         
                        //    Exceptions:
                        //  throws java.lang.Exception
                        //    StackMapTable: 00 04 FD 00 3A 01 07 00 2D FC 00 06 07 00 1F F9 00 0A 2C
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.NullPointerException
                        // 
                        throw new IllegalStateException("An error occurred while decompiling this method.");
                    }
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.RENAME_ITEM, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIllIllIlIlllIIIlI -> lllllllllllllIlIllIllIlIlllIIIlI.write(Type.STRING, "MC|ItemName"));
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.SELECT_TRADE, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIllIIlIlIIllIIllI -> lllllllllllllIlIllIIlIlIIllIIllI.write(Type.STRING, "MC|TrSel"));
                this.map(Type.VAR_INT, Type.INT);
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.SET_BEACON_EFFECT, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllIlIllllIlIIIlIlIIl -> llllllllllllllIlIllllIlIIIlIlIIl.write(Type.STRING, "MC|Beacon"));
                this.map(Type.VAR_INT, Type.INT);
                this.map(Type.VAR_INT, Type.INT);
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.UPDATE_COMMAND_BLOCK, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIllIIlIIIIllIlIllI -> lllllllllllllIIllIIlIIIIllIlIllI.write(Type.STRING, "MC|AutoCmd"));
                this.handler(Protocol1_13To1_12_2.POS_TO_3_INT);
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllllIIlllIIIIlIlIl) throws Exception {
                        final int lllllllllllllIllllIIlllIIIIllIII = lllllllllllllIllllIIlllIIIIlIlIl.read((Type<Integer>)Type.VAR_INT);
                        final byte lllllllllllllIllllIIlllIIIIlIlll = lllllllllllllIllllIIlllIIIIlIlIl.read((Type<Byte>)Type.BYTE);
                        final String lllllllllllllIllllIIlllIIIIlIllI = (lllllllllllllIllllIIlllIIIIllIII == 0) ? "SEQUENCE" : ((lllllllllllllIllllIIlllIIIIllIII == 1) ? "AUTO" : "REDSTONE");
                        lllllllllllllIllllIIlllIIIIlIlIl.write(Type.BOOLEAN, (lllllllllllllIllllIIlllIIIIlIlll & 0x1) != 0x0);
                        lllllllllllllIllllIIlllIIIIlIlIl.write(Type.STRING, lllllllllllllIllllIIlllIIIIlIllI);
                        lllllllllllllIllllIIlllIIIIlIlIl.write(Type.BOOLEAN, (lllllllllllllIllllIIlllIIIIlIlll & 0x2) != 0x0);
                        lllllllllllllIllllIIlllIIIIlIlIl.write(Type.BOOLEAN, (lllllllllllllIllllIIlllIIIIlIlll & 0x4) != 0x0);
                    }
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.UPDATE_COMMAND_BLOCK_MINECART, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIllIlIIIIlIlll) throws Exception {
                        lllllllllllllIIIIlIllIlIIIIlIlll.write(Type.STRING, "MC|AdvCmd");
                        lllllllllllllIIIIlIllIlIIIIlIlll.write(Type.BYTE, (Byte)1);
                    }
                });
                this.map(Type.VAR_INT, Type.INT);
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_12_1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.UPDATE_STRUCTURE_BLOCK, ServerboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllllllllIlIIIlIIllIl -> llllllllllllllllllllIlIIIlIIllIl.write(Type.STRING, "MC|Struct"));
                this.handler(Protocol1_13To1_12_2.POS_TO_3_INT);
                this.map((Type<Object>)Type.VAR_INT, (ValueTransformer<Object, Object>)new ValueTransformer<Integer, Byte>(Type.BYTE) {
                    @Override
                    public Byte transform(final PacketWrapper llllllllllllIlllllIlIIIllIIIIllI, final Integer llllllllllllIlllllIlIIIllIIIIlIl) throws Exception {
                        return (byte)(llllllllllllIlllllIlIIIllIIIIlIl + 1);
                    }
                });
                this.map((Type<Object>)Type.VAR_INT, (ValueTransformer<Object, Object>)new ValueTransformer<Integer, String>(Type.STRING) {
                    @Override
                    public String transform(final PacketWrapper lllllllllllllIlIIIllIIlllllIllll, final Integer lllllllllllllIlIIIllIIlllllIlllI) throws Exception {
                        return (lllllllllllllIlIIIllIIlllllIlllI == 0) ? "SAVE" : ((lllllllllllllIlIIIllIIlllllIlllI == 1) ? "LOAD" : ((lllllllllllllIlIIIllIIlllllIlllI == 2) ? "CORNER" : "DATA"));
                    }
                });
                this.map(Type.STRING);
                this.map(Type.BYTE, Type.INT);
                this.map(Type.BYTE, Type.INT);
                this.map(Type.BYTE, Type.INT);
                this.map(Type.BYTE, Type.INT);
                this.map(Type.BYTE, Type.INT);
                this.map(Type.BYTE, Type.INT);
                this.map((Type<Object>)Type.VAR_INT, (ValueTransformer<Object, Object>)new ValueTransformer<Integer, String>(Type.STRING) {
                    @Override
                    public String transform(final PacketWrapper llllllllllllllIIIIlIIllIIIllIllI, final Integer llllllllllllllIIIIlIIllIIIllIlIl) throws Exception {
                        return (llllllllllllllIIIIlIIllIIIllIlIl == 0) ? "NONE" : ((llllllllllllllIIIIlIIllIIIllIlIl == 1) ? "LEFT_RIGHT" : "FRONT_BACK");
                    }
                });
                this.map((Type<Object>)Type.VAR_INT, (ValueTransformer<Object, Object>)new ValueTransformer<Integer, String>(Type.STRING) {
                    @Override
                    public String transform(final PacketWrapper lllllllllllllIIlllIllllIIIllllll, final Integer lllllllllllllIIlllIllllIIIlllllI) throws Exception {
                        return (lllllllllllllIIlllIllllIIIlllllI == 0) ? "NONE" : ((lllllllllllllIIlllIllllIIIlllllI == 1) ? "CLOCKWISE_90" : ((lllllllllllllIIlllIllllIIIlllllI == 2) ? "CLOCKWISE_180" : "COUNTERCLOCKWISE_90"));
                    }
                });
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIllllIllllIllllIlllI) throws Exception {
                        final float llllllllllllIllllIllllIlllllIIIl = llllllllllllIllllIllllIllllIlllI.read((Type<Float>)Type.FLOAT);
                        final long llllllllllllIllllIllllIlllllIIII = llllllllllllIllllIllllIllllIlllI.read((Type<Long>)Type.VAR_LONG);
                        final byte llllllllllllIllllIllllIllllIllll = llllllllllllIllllIllllIllllIlllI.read((Type<Byte>)Type.BYTE);
                        llllllllllllIllllIllllIllllIlllI.write(Type.BOOLEAN, (llllllllllllIllllIllllIllllIllll & 0x1) != 0x0);
                        llllllllllllIllllIllllIllllIlllI.write(Type.BOOLEAN, (llllllllllllIllllIllllIllllIllll & 0x2) != 0x0);
                        llllllllllllIllllIllllIllllIlllI.write(Type.BOOLEAN, (llllllllllllIllllIllllIllllIllll & 0x4) != 0x0);
                        llllllllllllIllllIllllIllllIlllI.write(Type.FLOAT, llllllllllllIllllIllllIlllllIIIl);
                        llllllllllllIllllIllllIllllIlllI.write(Type.VAR_LONG, llllllllllllIllllIllllIlllllIIII);
                    }
                });
            }
        });
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    public char getLastColorChar(final String lllllllllllllllIIIllllIllIIllllI) {
        final int lllllllllllllllIIIllllIllIIlllIl = lllllllllllllllIIIllllIllIIllllI.length();
        for (int lllllllllllllllIIIllllIllIlIIIII = lllllllllllllllIIIllllIllIIlllIl - 1; lllllllllllllllIIIllllIllIlIIIII > -1; --lllllllllllllllIIIllllIllIlIIIII) {
            final char lllllllllllllllIIIllllIllIlIIIIl = lllllllllllllllIIIllllIllIIllllI.charAt(lllllllllllllllIIIllllIllIlIIIII);
            if (lllllllllllllllIIIllllIllIlIIIIl == '§' && lllllllllllllllIIIllllIllIlIIIII < lllllllllllllllIIIllllIllIIlllIl - 1) {
                final char lllllllllllllllIIIllllIllIlIIIlI = lllllllllllllllIIIllllIllIIllllI.charAt(lllllllllllllllIIIllllIllIlIIIII + 1);
                if (ChatColorUtil.isColorCode(lllllllllllllllIIIllllIllIlIIIlI) && !Protocol1_13To1_12_2.FORMATTING_CODES.contains(lllllllllllllllIIIllllIllIlIIIlI)) {
                    return lllllllllllllllIIIllllIllIlIIIlI;
                }
            }
        }
        return 'r';
    }
    
    @Override
    protected void onMappingDataLoaded() {
        ConnectionData.init();
        RecipeData.init();
        BlockIdData.init();
    }
    
    static {
        MAPPINGS = new MappingData();
        SCOREBOARD_TEAM_NAME_REWRITE = new HashMap<Character, Character>();
        FORMATTING_CODES = Sets.newHashSet((Object[])new Character[] { 'k', 'l', 'm', 'n', 'o', 'r' });
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('0', 'g');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('1', 'h');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('2', 'i');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('3', 'j');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('4', 'p');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('5', 'q');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('6', 's');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('7', 't');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('8', 'u');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('9', 'v');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('a', 'w');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('b', 'x');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('c', 'y');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('d', 'z');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('e', '!');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('f', '?');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('k', '#');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('l', '(');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('m', ')');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('n', ':');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('o', ';');
        Protocol1_13To1_12_2.SCOREBOARD_TEAM_NAME_REWRITE.put('r', '/');
        final Position lllllllllllllllIIIllllIlIllIIIIl;
        POS_TO_3_INT = (lllllllllllllllIIIllllIlIllIIIII -> {
            lllllllllllllllIIIllllIlIllIIIIl = lllllllllllllllIIIllllIlIllIIIII.read(Type.POSITION);
            lllllllllllllllIIIllllIlIllIIIII.write(Type.INT, lllllllllllllllIIIllllIlIllIIIIl.getX());
            lllllllllllllllIIIllllIlIllIIIII.write(Type.INT, lllllllllllllllIIIllllIlIllIIIIl.getY());
            lllllllllllllllIIIllllIlIllIIIII.write(Type.INT, lllllllllllllllIIIllllIlIllIIIIl.getZ());
            return;
        });
        final double lllllllllllllllIIIllllIlIllIlIIl;
        Map.Entry<String, Integer[]> lllllllllllllllIIIllllIlIllIlllI;
        final double lllllllllllllllIIIllllIlIllIlIIl2;
        Map.Entry<String, Integer[]> lllllllllllllllIIIllllIlIllIllIl;
        final double lllllllllllllllIIIllllIlIllIlIIl3;
        Map.Entry<String, Integer[]> lllllllllllllllIIIllllIlIllIllII;
        SEND_DECLARE_COMMANDS_AND_TAGS = (lllllllllllllllIIIllllIlIlllIIll -> {
            lllllllllllllllIIIllllIlIlllIIll.create(ClientboundPackets1_13.DECLARE_COMMANDS, lllllllllllllllIIIllllIlIllIIlIl -> {
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.VAR_INT, 2);
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.BYTE, (Byte)0);
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { 1 });
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.BYTE, (Byte)22);
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[0]);
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.STRING, "args");
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.STRING, "brigadier:string");
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.VAR_INT, 2);
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.STRING, "minecraft:ask_server");
                lllllllllllllllIIIllllIlIllIIlIl.write(Type.VAR_INT, 0);
                return;
            }).scheduleSend(Protocol1_13To1_12_2.class);
            lllllllllllllllIIIllllIlIlllIIll.create(ClientboundPackets1_13.TAGS, lllllllllllllllIIIllllIlIllIlIlI -> {
                lllllllllllllllIIIllllIlIllIlIlI.write(Type.VAR_INT, Protocol1_13To1_12_2.MAPPINGS.getBlockTags().size());
                lllllllllllllllIIIllllIlIllIlIIl = (double)Protocol1_13To1_12_2.MAPPINGS.getBlockTags().entrySet().iterator();
                while (((Iterator)lllllllllllllllIIIllllIlIllIlIIl).hasNext()) {
                    lllllllllllllllIIIllllIlIllIlllI = ((Iterator<Map.Entry<String, Integer[]>>)lllllllllllllllIIIllllIlIllIlIIl).next();
                    lllllllllllllllIIIllllIlIllIlIlI.write(Type.STRING, lllllllllllllllIIIllllIlIllIlllI.getKey());
                    lllllllllllllllIIIllllIlIllIlIlI.write(Type.VAR_INT_ARRAY_PRIMITIVE, toPrimitive(lllllllllllllllIIIllllIlIllIlllI.getValue()));
                }
                lllllllllllllllIIIllllIlIllIlIlI.write(Type.VAR_INT, Protocol1_13To1_12_2.MAPPINGS.getItemTags().size());
                lllllllllllllllIIIllllIlIllIlIIl2 = (double)Protocol1_13To1_12_2.MAPPINGS.getItemTags().entrySet().iterator();
                while (((Iterator)lllllllllllllllIIIllllIlIllIlIIl2).hasNext()) {
                    lllllllllllllllIIIllllIlIllIllIl = ((Iterator<Map.Entry<String, Integer[]>>)lllllllllllllllIIIllllIlIllIlIIl2).next();
                    lllllllllllllllIIIllllIlIllIlIlI.write(Type.STRING, lllllllllllllllIIIllllIlIllIllIl.getKey());
                    lllllllllllllllIIIllllIlIllIlIlI.write(Type.VAR_INT_ARRAY_PRIMITIVE, toPrimitive(lllllllllllllllIIIllllIlIllIllIl.getValue()));
                }
                lllllllllllllllIIIllllIlIllIlIlI.write(Type.VAR_INT, Protocol1_13To1_12_2.MAPPINGS.getFluidTags().size());
                lllllllllllllllIIIllllIlIllIlIIl3 = (double)Protocol1_13To1_12_2.MAPPINGS.getFluidTags().entrySet().iterator();
                while (((Iterator)lllllllllllllllIIIllllIlIllIlIIl3).hasNext()) {
                    lllllllllllllllIIIllllIlIllIllII = ((Iterator<Map.Entry<String, Integer[]>>)lllllllllllllllIIIllllIlIllIlIIl3).next();
                    lllllllllllllllIIIllllIlIllIlIlI.write(Type.STRING, lllllllllllllllIIIllllIlIllIllII.getKey());
                    lllllllllllllllIIIllllIlIllIlIlI.write(Type.VAR_INT_ARRAY_PRIMITIVE, toPrimitive(lllllllllllllllIIIllllIlIllIllII.getValue()));
                }
            }).scheduleSend(Protocol1_13To1_12_2.class);
        });
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
}
