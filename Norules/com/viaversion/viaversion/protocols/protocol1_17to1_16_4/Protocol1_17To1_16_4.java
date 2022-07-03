package com.viaversion.viaversion.protocols.protocol1_17to1_16_4;

import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.packets.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.*;

public final class Protocol1_17To1_16_4 extends AbstractProtocol<ClientboundPackets1_16_2, ClientboundPackets1_17, ServerboundPackets1_16_2, ServerboundPackets1_17>
{
    private final /* synthetic */ ItemRewriter itemRewriter;
    private static final /* synthetic */ String[] NEW_GAME_EVENT_TAGS;
    private final /* synthetic */ EntityRewriter entityRewriter;
    public static final /* synthetic */ MappingData MAPPINGS;
    private final /* synthetic */ TagRewriter tagRewriter;
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    static {
        MAPPINGS = new MappingDataBase("1.16.2", "1.17", true);
        NEW_GAME_EVENT_TAGS = new String[] { "minecraft:ignore_vibrations_sneaking", "minecraft:vibrations" };
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_17To1_16_4.MAPPINGS;
    }
    
    public Protocol1_17To1_16_4() {
        super(ClientboundPackets1_16_2.class, ClientboundPackets1_17.class, ServerboundPackets1_16_2.class, ServerboundPackets1_17.class);
        this.entityRewriter = new EntityPackets(this);
        this.itemRewriter = new InventoryPackets(this);
        this.tagRewriter = new TagRewriter(this);
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIlllIllIllIlIIllIII) {
        this.addEntityTracker(lllllllllllllIlllIllIllIlIIllIII, new EntityTrackerBase(lllllllllllllIlllIllIllIlIIllIII, Entity1_17Types.PLAYER));
        lllllllllllllIlllIllIllIlIIllIII.put(new InventoryAcknowledgements());
    }
    
    @Override
    protected void registerPackets() {
        this.entityRewriter.register();
        this.itemRewriter.register();
        WorldPackets.register(this);
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.TAGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIllllllIlIIIIllllIl;
                final long lllllllllllllIllllllIlIIIIllllII;
                double lllllllllllllIllllllIlIIIIlllIll;
                RegistryType lllllllllllllIllllllIlIIIlIIIIll;
                final int lllllllllllllIllllllIlIIIIllllIl2;
                long lllllllllllllIllllllIlIIIIllllII2;
                double lllllllllllllIllllllIlIIIIlllIll2;
                String lllllllllllllIllllllIlIIIlIIIIlI;
                this.handler(lllllllllllllIllllllIlIIIlIIIIII -> {
                    lllllllllllllIllllllIlIIIlIIIIII.write(Type.VAR_INT, 5);
                    lllllllllllllIllllllIlIIIIllllIl = (int)(Object)RegistryType.getValues();
                    lllllllllllllIllllllIlIIIIllllII = lllllllllllllIllllllIlIIIIllllIl.length;
                    lllllllllllllIllllllIlIIIIlllIll = 0;
                    while (lllllllllllllIllllllIlIIIIlllIll < lllllllllllllIllllllIlIIIIllllII) {
                        lllllllllllllIllllllIlIIIlIIIIll = lllllllllllllIllllllIlIIIIllllIl[lllllllllllllIllllllIlIIIIlllIll];
                        lllllllllllllIllllllIlIIIlIIIIII.write(Type.STRING, lllllllllllllIllllllIlIIIlIIIIll.getResourceLocation());
                        Protocol1_17To1_16_4.this.tagRewriter.handle(lllllllllllllIllllllIlIIIlIIIIII, Protocol1_17To1_16_4.this.tagRewriter.getRewriter(lllllllllllllIllllllIlIIIlIIIIll), Protocol1_17To1_16_4.this.tagRewriter.getNewTags(lllllllllllllIllllllIlIIIlIIIIll));
                        if (lllllllllllllIllllllIlIIIlIIIIll == RegistryType.ENTITY) {
                            break;
                        }
                        else {
                            ++lllllllllllllIllllllIlIIIIlllIll;
                        }
                    }
                    lllllllllllllIllllllIlIIIlIIIIII.write(Type.STRING, RegistryType.GAME_EVENT.getResourceLocation());
                    lllllllllllllIllllllIlIIIlIIIIII.write(Type.VAR_INT, Protocol1_17To1_16_4.NEW_GAME_EVENT_TAGS.length);
                    lllllllllllllIllllllIlIIIIllllIl2 = (int)(Object)Protocol1_17To1_16_4.NEW_GAME_EVENT_TAGS;
                    for (lllllllllllllIllllllIlIIIIllllII2 = lllllllllllllIllllllIlIIIIllllIl2.length, lllllllllllllIllllllIlIIIIlllIll2 = 0; lllllllllllllIllllllIlIIIIlllIll2 < lllllllllllllIllllllIlIIIIllllII2; ++lllllllllllllIllllllIlIIIIlllIll2) {
                        lllllllllllllIllllllIlIIIlIIIIlI = lllllllllllllIllllllIlIIIIllllIl2[lllllllllllllIllllllIlIIIIlllIll2];
                        lllllllllllllIllllllIlIIIlIIIIII.write(Type.STRING, lllllllllllllIllllllIlIIIlIIIIlI);
                        lllllllllllllIllllllIlIIIlIIIIII.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[0]);
                    }
                });
            }
        });
        new StatisticsRewriter(this).register(ClientboundPackets1_16_2.STATISTICS);
        final SoundRewriter lllllllllllllIlllIllIllIlIlIIIIl = new SoundRewriter(this);
        lllllllllllllIlllIllIllIlIlIIIIl.registerSound(ClientboundPackets1_16_2.SOUND);
        lllllllllllllIlllIllIllIlIlIIIIl.registerSound(ClientboundPackets1_16_2.ENTITY_SOUND);
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.RESOURCE_PACK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIlllIlllIIlIIIlIlI -> {
                    lllllllllllllIIlllIlllIIlIIIlIlI.passthrough(Type.STRING);
                    lllllllllllllIIlllIlllIIlIIIlIlI.passthrough(Type.STRING);
                    lllllllllllllIIlllIlllIIlIIIlIlI.write(Type.BOOLEAN, Via.getConfig().isForcedUse1_17ResourcePack());
                    lllllllllllllIIlllIlllIIlIIIlIlI.write(Type.OPTIONAL_COMPONENT, Via.getConfig().get1_17ResourcePackPrompt());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllIlllllIllllIIIIIIlIl;
                this.handler(llllllllllllIlllllIllllIIIIIIlII -> {
                    llllllllllllIlllllIllllIIIIIIlII.passthrough((Type<Object>)Type.VAR_INT);
                    llllllllllllIlllllIllllIIIIIIlII.passthrough((Type<Object>)Type.BYTE);
                    llllllllllllIlllllIllllIIIIIIlII.read((Type<Object>)Type.BOOLEAN);
                    llllllllllllIlllllIllllIIIIIIlII.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllIlllllIllllIIIIIIlIl = llllllllllllIlllllIllllIIIIIIlII.read((Type<Integer>)Type.VAR_INT);
                    if (llllllllllllIlllllIllllIIIIIIlIl != 0) {
                        llllllllllllIlllllIllllIIIIIIlII.write(Type.BOOLEAN, true);
                        llllllllllllIlllllIllllIIIIIIlII.write(Type.VAR_INT, llllllllllllIlllllIllllIIIIIIlIl);
                    }
                    else {
                        llllllllllllIlllllIllllIIIIIIlII.write(Type.BOOLEAN, false);
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_16_2, ClientboundPackets1_17, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.TITLE, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllIIIllIIlIIlIIIIlI;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIlIIl;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIlIII;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIIlll;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIIllI;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIIlIl;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIIlII;
                final IllegalArgumentException ex;
                final ClientboundPacketType lllllllllllllllIIIllIIlIIlIIIIIl;
                this.handler(lllllllllllllllIIIllIIlIIlIIIIll -> {
                    lllllllllllllllIIIllIIlIIlIIIIlI = lllllllllllllllIIIllIIlIIlIIIIll.read((Type<Integer>)Type.VAR_INT);
                    switch (lllllllllllllllIIIllIIlIIlIIIIlI) {
                        case 0: {
                            lllllllllllllllIIIllIIlIIlIIlIIl = ClientboundPackets1_17.TITLE_TEXT;
                            break;
                        }
                        case 1: {
                            lllllllllllllllIIIllIIlIIlIIlIII = ClientboundPackets1_17.TITLE_SUBTITLE;
                            break;
                        }
                        case 2: {
                            lllllllllllllllIIIllIIlIIlIIIlll = ClientboundPackets1_17.ACTIONBAR;
                            break;
                        }
                        case 3: {
                            lllllllllllllllIIIllIIlIIlIIIllI = ClientboundPackets1_17.TITLE_TIMES;
                            break;
                        }
                        case 4: {
                            lllllllllllllllIIIllIIlIIlIIIlIl = ClientboundPackets1_17.CLEAR_TITLES;
                            lllllllllllllllIIIllIIlIIlIIIIll.write(Type.BOOLEAN, false);
                            break;
                        }
                        case 5: {
                            lllllllllllllllIIIllIIlIIlIIIlII = ClientboundPackets1_17.CLEAR_TITLES;
                            lllllllllllllllIIIllIIlIIlIIIIll.write(Type.BOOLEAN, true);
                            break;
                        }
                        default: {
                            new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid title type received: ").append(lllllllllllllllIIIllIIlIIlIIIIlI)));
                            throw ex;
                        }
                    }
                    lllllllllllllllIIIllIIlIIlIIIIll.setId(lllllllllllllllIIIllIIlIIlIIIIIl.getId());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.EXPLOSION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.handler(llllllllllllllIIIIlIIIIllIlIllII -> llllllllllllllIIIIlIIIIllIlIllII.write(Type.VAR_INT, (Integer)llllllllllllllIIIIlIIIIllIlIllII.read((Type<T>)Type.INT)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.SPAWN_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14);
                this.handler(lllIIIllllIlIlI -> lllIIIllllIlIlI.write(Type.FLOAT, 0.0f));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this).registerServerbound(ServerboundPackets1_17.CLIENT_SETTINGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(llllllllllllIllllllIllIIlIIlIlIl -> llllllllllllIllllllIllIIlIIlIlIl.read((Type<Object>)Type.BOOLEAN));
            }
        });
    }
    
    @Override
    protected void onMappingDataLoaded() {
        this.tagRewriter.loadFromMappingData();
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:candles", "minecraft:ignored_by_piglin_babies", "minecraft:piglin_food", "minecraft:freeze_immune_wearables", "minecraft:axolotl_tempt_items", "minecraft:occludes_vibration_signals", "minecraft:fox_food", "minecraft:diamond_ores", "minecraft:iron_ores", "minecraft:lapis_ores", "minecraft:redstone_ores", "minecraft:coal_ores", "minecraft:copper_ores", "minecraft:emerald_ores", "minecraft:cluster_max_harvestables");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:crystal_sound_blocks", "minecraft:candle_cakes", "minecraft:candles", "minecraft:snow_step_sound_blocks", "minecraft:inside_step_sound_blocks", "minecraft:occludes_vibration_signals", "minecraft:dripstone_replaceable_blocks", "minecraft:cave_vines", "minecraft:moss_replaceable", "minecraft:deepslate_ore_replaceables", "minecraft:lush_ground_replaceable", "minecraft:diamond_ores", "minecraft:iron_ores", "minecraft:lapis_ores", "minecraft:redstone_ores", "minecraft:stone_ore_replaceables", "minecraft:coal_ores", "minecraft:copper_ores", "minecraft:emerald_ores", "minecraft:dirt", "minecraft:snow", "minecraft:small_dripleaf_placeable", "minecraft:features_cannot_replace", "minecraft:lava_pool_stone_replaceables", "minecraft:geode_invalid_blocks");
        this.tagRewriter.addEmptyTags(RegistryType.ENTITY, "minecraft:powder_snow_walkable_mobs", "minecraft:axolotl_always_hostiles", "minecraft:axolotl_tempted_hostiles", "minecraft:axolotl_hunt_targets", "minecraft:freeze_hurts_extra_types", "minecraft:freeze_immune_entity_types");
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
}
