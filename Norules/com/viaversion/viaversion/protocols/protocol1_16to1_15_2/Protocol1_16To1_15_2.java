package com.viaversion.viaversion.protocols.protocol1_16to1_15_2;

import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.data.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.*;
import java.nio.charset.*;
import com.google.common.base.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.*;
import java.util.*;

public class Protocol1_16To1_15_2 extends AbstractProtocol<ClientboundPackets1_15, ClientboundPackets1_16, ServerboundPackets1_14, ServerboundPackets1_16>
{
    private final /* synthetic */ EntityRewriter metadataRewriter;
    private final /* synthetic */ ItemRewriter itemRewriter;
    public static final /* synthetic */ MappingData MAPPINGS;
    private static final /* synthetic */ UUID ZERO_UUID;
    private /* synthetic */ TagRewriter tagRewriter;
    
    @Override
    public void init(final UserConnection lllllllllllllllIIIlllIIIIlIllIlI) {
        lllllllllllllllIIIlllIIIIlIllIlI.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllllIIIlllIIIIlIllIlI, Entity1_16Types.PLAYER));
    }
    
    @Override
    protected void registerPackets() {
        this.metadataRewriter.register();
        this.itemRewriter.register();
        EntityPackets.register(this);
        WorldPackets.register(this);
        this.tagRewriter = new TagRewriter(this);
        this.tagRewriter.register(ClientboundPackets1_15.TAGS, RegistryType.ENTITY);
        new StatisticsRewriter(this).register(ClientboundPackets1_15.STATISTICS);
        this.registerClientbound(State.LOGIN, 2, 2, new PacketRemapper() {
            @Override
            public void registerMap() {
                final UUID lllllllllllllIIIIlIlllIllllllIIl;
                this.handler(lllllllllllllIIIIlIlllIllllllIII -> {
                    lllllllllllllIIIIlIlllIllllllIIl = UUID.fromString(lllllllllllllIIIIlIlllIllllllIII.read(Type.STRING));
                    lllllllllllllIIIIlIlllIllllllIII.write(Type.UUID_INT_ARRAY, lllllllllllllIIIIlIlllIllllllIIl);
                });
            }
        });
        this.registerClientbound(State.STATUS, 0, 0, new PacketRemapper() {
            @Override
            public void registerMap() {
                final String llllllllllllllllllllllllIllIIlIl;
                final JsonObject llllllllllllllllllllllllIllIIlII;
                final JsonObject llllllllllllllllllllllllIllIIIll;
                JsonArray llllllllllllllllllllllllIllIIIlI;
                JsonArray llllllllllllllllllllllllIllIIIIl;
                byte llllllllllllllllllllllllIlIllIlI;
                JsonElement llllllllllllllllllllllllIllIIlll;
                JsonObject llllllllllllllllllllllllIllIlIlI;
                String llllllllllllllllllllllllIllIlIIl;
                String llllllllllllllllllllllllIllIlIII;
                boolean llllllllllllllllllllllllIlIlIlIl;
                float llllllllllllllllllllllllIlIlIlII;
                boolean llllllllllllllllllllllllIlIlIIll;
                String llllllllllllllllllllllllIllIlIll;
                JsonObject llllllllllllllllllllllllIllIllII;
                this.handler(llllllllllllllllllllllllIllIIllI -> {
                    llllllllllllllllllllllllIllIIlIl = llllllllllllllllllllllllIllIIllI.passthrough(Type.STRING);
                    llllllllllllllllllllllllIllIIlII = GsonUtil.getGson().fromJson(llllllllllllllllllllllllIllIIlIl, JsonObject.class);
                    llllllllllllllllllllllllIllIIIll = llllllllllllllllllllllllIllIIlII.getAsJsonObject("players");
                    if (llllllllllllllllllllllllIllIIIll != null) {
                        llllllllllllllllllllllllIllIIIlI = llllllllllllllllllllllllIllIIIll.getAsJsonArray("sample");
                        if (llllllllllllllllllllllllIllIIIlI != null) {
                            llllllllllllllllllllllllIllIIIIl = new JsonArray();
                            llllllllllllllllllllllllIlIllIlI = (byte)llllllllllllllllllllllllIllIIIlI.iterator();
                            while (((Iterator)llllllllllllllllllllllllIlIllIlI).hasNext()) {
                                llllllllllllllllllllllllIllIIlll = ((Iterator<JsonElement>)llllllllllllllllllllllllIlIllIlI).next();
                                llllllllllllllllllllllllIllIlIlI = llllllllllllllllllllllllIllIIlll.getAsJsonObject();
                                llllllllllllllllllllllllIllIlIIl = llllllllllllllllllllllllIllIlIlI.getAsJsonPrimitive("name").getAsString();
                                if (llllllllllllllllllllllllIllIlIIl.indexOf(10) == -1) {
                                    llllllllllllllllllllllllIllIIIIl.add(llllllllllllllllllllllllIllIlIlI);
                                }
                                else {
                                    llllllllllllllllllllllllIllIlIII = llllllllllllllllllllllllIllIlIlI.getAsJsonPrimitive("id").getAsString();
                                    llllllllllllllllllllllllIlIlIlIl = (boolean)(Object)llllllllllllllllllllllllIllIlIIl.split("\n");
                                    for (llllllllllllllllllllllllIlIlIlII = llllllllllllllllllllllllIlIlIlIl.length, llllllllllllllllllllllllIlIlIIll = false; (llllllllllllllllllllllllIlIlIIll ? 1 : 0) < llllllllllllllllllllllllIlIlIlII; ++llllllllllllllllllllllllIlIlIIll) {
                                        llllllllllllllllllllllllIllIlIll = llllllllllllllllllllllllIlIlIlIl[llllllllllllllllllllllllIlIlIIll];
                                        llllllllllllllllllllllllIllIllII = new JsonObject();
                                        llllllllllllllllllllllllIllIllII.addProperty("name", llllllllllllllllllllllllIllIlIll);
                                        llllllllllllllllllllllllIllIllII.addProperty("id", llllllllllllllllllllllllIllIlIII);
                                        llllllllllllllllllllllllIllIIIIl.add(llllllllllllllllllllllllIllIllII);
                                    }
                                }
                            }
                            if (llllllllllllllllllllllllIllIIIIl.size() != llllllllllllllllllllllllIllIIIlI.size()) {
                                llllllllllllllllllllllllIllIIIll.add("sample", llllllllllllllllllllllllIllIIIIl);
                                llllllllllllllllllllllllIllIIllI.set(Type.STRING, 0, llllllllllllllllllllllllIllIIlII.toString());
                            }
                        }
                    }
                });
            }
        });
        final ComponentRewriter lllllllllllllllIIIlllIIIIlllIIII = new TranslationMappings(this);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_15.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.COMPONENT);
                this.map(Type.BYTE);
                this.handler(llllllllllllllllllIllIIIIIlllIIl -> {
                    lllllllllllllllIIIlllIIIIlllIIII.processText(llllllllllllllllllIllIIIIIlllIIl.get(Type.COMPONENT, 0));
                    llllllllllllllllllIllIIIIIlllIIl.write(Type.UUID, Protocol1_16To1_15_2.ZERO_UUID);
                });
            }
        });
        lllllllllllllllIIIlllIIIIlllIIII.registerBossBar(ClientboundPackets1_15.BOSSBAR);
        lllllllllllllllIIIlllIIIIlllIIII.registerTitle(ClientboundPackets1_15.TITLE);
        lllllllllllllllIIIlllIIIIlllIIII.registerCombatEvent(ClientboundPackets1_15.COMBAT_EVENT);
        final SoundRewriter lllllllllllllllIIIlllIIIIllIllll = new SoundRewriter(this);
        lllllllllllllllIIIlllIIIIllIllll.registerSound(ClientboundPackets1_15.SOUND);
        lllllllllllllllIIIlllIIIIllIllll.registerSound(ClientboundPackets1_15.ENTITY_SOUND);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this).registerServerbound(ServerboundPackets1_16.INTERACT_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllIllllIlIIIIIllIll;
                this.handler(lllllllllllllllIllllIlIIIIIllIlI -> {
                    lllllllllllllllIllllIlIIIIIllIlI.passthrough((Type<Object>)Type.VAR_INT);
                    lllllllllllllllIllllIlIIIIIllIll = lllllllllllllllIllllIlIIIIIllIlI.passthrough((Type<Integer>)Type.VAR_INT);
                    if (lllllllllllllllIllllIlIIIIIllIll == 0 || lllllllllllllllIllllIlIIIIIllIll == 2) {
                        if (lllllllllllllllIllllIlIIIIIllIll == 2) {
                            lllllllllllllllIllllIlIIIIIllIlI.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllllIllllIlIIIIIllIlI.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllllIllllIlIIIIIllIlI.passthrough((Type<Object>)Type.FLOAT);
                        }
                        lllllllllllllllIllllIlIIIIIllIlI.passthrough((Type<Object>)Type.VAR_INT);
                    }
                    lllllllllllllllIllllIlIIIIIllIlI.read((Type<Object>)Type.BOOLEAN);
                });
            }
        });
        if (Via.getConfig().isIgnoreLong1_16ChannelNames()) {
            ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this).registerServerbound(ServerboundPackets1_16.PLUGIN_MESSAGE, new PacketRemapper() {
                @Override
                public void registerMap() {
                    final String lllllllllllllIIllIlllIIlIlIIIllI;
                    String[] lllllllllllllIIllIlllIIlIlIIlIIl;
                    ArrayList<String> lllllllllllllIIllIlllIIlIlIIlIII;
                    Exception lllllllllllllIIllIlllIIlIlIIIIIl;
                    int lllllllllllllIIllIlllIIlIlIIIIII;
                    int lllllllllllllIIllIlllIIlIIllllll;
                    String lllllllllllllIIllIlllIIlIlIIlIlI;
                    this.handler(lllllllllllllIIllIlllIIlIlIIIlll -> {
                        lllllllllllllIIllIlllIIlIlIIIllI = lllllllllllllIIllIlllIIlIlIIIlll.passthrough(Type.STRING);
                        if (lllllllllllllIIllIlllIIlIlIIIllI.length() > 32) {
                            if (!Via.getConfig().isSuppressConversionWarnings()) {
                                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring incoming plugin channel, as it is longer than 32 characters: ").append(lllllllllllllIIllIlllIIlIlIIIllI)));
                            }
                            lllllllllllllIIllIlllIIlIlIIIlll.cancel();
                        }
                        else if (lllllllllllllIIllIlllIIlIlIIIllI.equals("minecraft:register") || lllllllllllllIIllIlllIIlIlIIIllI.equals("minecraft:unregister")) {
                            lllllllllllllIIllIlllIIlIlIIlIIl = new String(lllllllllllllIIllIlllIIlIlIIIlll.read(Type.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                            lllllllllllllIIllIlllIIlIlIIlIII = new ArrayList<String>(lllllllllllllIIllIlllIIlIlIIlIIl.length);
                            lllllllllllllIIllIlllIIlIlIIIIIl = (Exception)(Object)lllllllllllllIIllIlllIIlIlIIlIIl;
                            for (lllllllllllllIIllIlllIIlIlIIIIII = lllllllllllllIIllIlllIIlIlIIIIIl.length, lllllllllllllIIllIlllIIlIIllllll = 0; lllllllllllllIIllIlllIIlIIllllll < lllllllllllllIIllIlllIIlIlIIIIII; ++lllllllllllllIIllIlllIIlIIllllll) {
                                lllllllllllllIIllIlllIIlIlIIlIlI = lllllllllllllIIllIlllIIlIlIIIIIl[lllllllllllllIIllIlllIIlIIllllll];
                                if (lllllllllllllIIllIlllIIlIlIIlIlI.length() > 32) {
                                    if (!Via.getConfig().isSuppressConversionWarnings()) {
                                        Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring incoming plugin channel register of '").append(lllllllllllllIIllIlllIIlIlIIlIlI).append("', as it is longer than 32 characters")));
                                    }
                                }
                                else {
                                    lllllllllllllIIllIlllIIlIlIIlIII.add(lllllllllllllIIllIlllIIlIlIIlIlI);
                                }
                            }
                            if (lllllllllllllIIllIlllIIlIlIIlIII.isEmpty()) {
                                lllllllllllllIIllIlllIIlIlIIIlll.cancel();
                            }
                            else {
                                lllllllllllllIIllIlllIIlIlIIIlll.write(Type.REMAINING_BYTES, Joiner.on('\0').join((Iterable)lllllllllllllIIllIlllIIlIlIIlIII).getBytes(StandardCharsets.UTF_8));
                            }
                        }
                    });
                }
            });
        }
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this).registerServerbound(ServerboundPackets1_16.PLAYER_ABILITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIIlllIlIlIIIllIII -> {
                    lllllllllllllIlIIlllIlIlIIIllIII.passthrough((Type<Object>)Type.BYTE);
                    lllllllllllllIlIIlllIlIlIIIllIII.write(Type.FLOAT, 0.05f);
                    lllllllllllllIlIIlllIlIlIIIllIII.write(Type.FLOAT, 0.1f);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this).cancelServerbound(ServerboundPackets1_16.GENERATE_JIGSAW);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this).cancelServerbound(ServerboundPackets1_16.UPDATE_JIGSAW_BLOCK);
    }
    
    public Protocol1_16To1_15_2() {
        super(ClientboundPackets1_15.class, ClientboundPackets1_16.class, ServerboundPackets1_14.class, ServerboundPackets1_16.class);
        this.metadataRewriter = new MetadataRewriter1_16To1_15_2(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    @Override
    protected void onMappingDataLoaded() {
        final int[] lllllllllllllllIIIlllIIIIllIIIll = new int[47];
        int lllllllllllllllIIIlllIIIIllIIIlI = 0;
        lllllllllllllllIIIlllIIIIllIIIll[lllllllllllllllIIIlllIIIIllIIIlI++] = 140;
        lllllllllllllllIIIlllIIIIllIIIll[lllllllllllllllIIIlllIIIIllIIIlI++] = 179;
        lllllllllllllllIIIlllIIIIllIIIll[lllllllllllllllIIIlllIIIIllIIIlI++] = 264;
        for (int lllllllllllllllIIIlllIIIIllIIlll = 153; lllllllllllllllIIIlllIIIIllIIlll <= 158; ++lllllllllllllllIIIlllIIIIllIIlll) {
            lllllllllllllllIIIlllIIIIllIIIll[lllllllllllllllIIIlllIIIIllIIIlI++] = lllllllllllllllIIIlllIIIIllIIlll;
        }
        for (int lllllllllllllllIIIlllIIIIllIIllI = 163; lllllllllllllllIIIlllIIIIllIIllI <= 168; ++lllllllllllllllIIIlllIIIIllIIllI) {
            lllllllllllllllIIIlllIIIIllIIIll[lllllllllllllllIIIlllIIIIllIIIlI++] = lllllllllllllllIIIlllIIIIllIIllI;
        }
        for (int lllllllllllllllIIIlllIIIIllIIlIl = 408; lllllllllllllllIIIlllIIIIllIIlIl <= 439; ++lllllllllllllllIIIlllIIIIllIIlIl) {
            lllllllllllllllIIIlllIIIIllIIIll[lllllllllllllllIIIlllIIIIllIIIlI++] = lllllllllllllllIIIlllIIIIllIIlIl;
        }
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:wall_post_override", lllllllllllllllIIIlllIIIIllIIIll);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:beacon_base_blocks", 133, 134, 148, 265);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:climbable", 160, 241, 658);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:fire", 142);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:campfires", 679);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:fence_gates", 242, 467, 468, 469, 470, 471);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:unstable_bottom_center", 242, 467, 468, 469, 470, 471);
        this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:wooden_trapdoors", 193, 194, 195, 196, 197, 198);
        this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:wooden_trapdoors", 215, 216, 217, 218, 219, 220);
        this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:beacon_payment_items", 529, 530, 531, 760);
        this.tagRewriter.addTag(RegistryType.ENTITY, "minecraft:impact_projectiles", 2, 72, 71, 37, 69, 79, 83, 15, 93);
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:guarded_by_piglins");
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:soul_speed_blocks");
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:soul_fire_base_blocks");
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:non_flammable_wood");
        this.tagRewriter.addEmptyTag(RegistryType.ITEM, "minecraft:non_flammable_wood");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:bamboo_plantable_on", "minecraft:beds", "minecraft:bee_growables", "minecraft:beehives", "minecraft:coral_plants", "minecraft:crops", "minecraft:dragon_immune", "minecraft:flowers", "minecraft:portals", "minecraft:shulker_boxes", "minecraft:small_flowers", "minecraft:tall_flowers", "minecraft:trapdoors", "minecraft:underwater_bonemeals", "minecraft:wither_immune", "minecraft:wooden_fences", "minecraft:wooden_trapdoors");
        this.tagRewriter.addEmptyTags(RegistryType.ENTITY, "minecraft:arrows", "minecraft:beehive_inhabitors", "minecraft:raiders", "minecraft:skeletons");
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:beds", "minecraft:coals", "minecraft:fences", "minecraft:flowers", "minecraft:lectern_books", "minecraft:music_discs", "minecraft:small_flowers", "minecraft:tall_flowers", "minecraft:trapdoors", "minecraft:walls", "minecraft:wooden_fences");
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    static {
        ZERO_UUID = new UUID(0L, 0L);
        MAPPINGS = new MappingData();
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_16To1_15_2.MAPPINGS;
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.metadataRewriter;
    }
}
