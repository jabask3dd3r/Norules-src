package com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1;

import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.data.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets.*;

public class Protocol1_16_2To1_16_1 extends AbstractProtocol<ClientboundPackets1_16, ClientboundPackets1_16_2, ServerboundPackets1_16, ServerboundPackets1_16_2>
{
    public static final /* synthetic */ MappingData MAPPINGS;
    private final /* synthetic */ EntityRewriter metadataRewriter;
    private /* synthetic */ TagRewriter tagRewriter;
    private final /* synthetic */ ItemRewriter itemRewriter;
    
    @Override
    public void init(final UserConnection lllllllllllllIllIlIllIIllIIllIlI) {
        lllllllllllllIllIlIllIIllIIllIlI.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllIllIlIllIIllIIllIlI, Entity1_16_2Types.PLAYER));
    }
    
    static {
        MAPPINGS = new MappingData();
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.metadataRewriter;
    }
    
    @Override
    protected void onMappingDataLoaded() {
        this.tagRewriter.addTag(RegistryType.ITEM, "minecraft:stone_crafting_materials", 14, 962);
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:mushroom_grow_block");
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:soul_fire_base_blocks", "minecraft:furnace_materials", "minecraft:crimson_stems", "minecraft:gold_ores", "minecraft:piglin_loved", "minecraft:piglin_repellents", "minecraft:creeper_drop_music_discs", "minecraft:logs_that_burn", "minecraft:stone_tool_materials", "minecraft:warped_stems");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:infiniburn_nether", "minecraft:crimson_stems", "minecraft:wither_summon_base_blocks", "minecraft:infiniburn_overworld", "minecraft:piglin_repellents", "minecraft:hoglin_repellents", "minecraft:prevent_mob_spawning_inside", "minecraft:wart_blocks", "minecraft:stone_pressure_plates", "minecraft:nylium", "minecraft:gold_ores", "minecraft:pressure_plates", "minecraft:logs_that_burn", "minecraft:strider_warm_blocks", "minecraft:warped_stems", "minecraft:infiniburn_end", "minecraft:base_stone_nether", "minecraft:base_stone_overworld");
    }
    
    @Override
    protected void registerPackets() {
        this.metadataRewriter.register();
        this.itemRewriter.register();
        EntityPackets.register(this);
        WorldPackets.register(this);
        this.tagRewriter = new TagRewriter(this);
        this.tagRewriter.register(ClientboundPackets1_16.TAGS, RegistryType.ENTITY);
        new StatisticsRewriter(this).register(ClientboundPackets1_16.STATISTICS);
        final SoundRewriter lllllllllllllIllIlIllIIllIlIIIll = new SoundRewriter(this);
        lllllllllllllIllIlIllIIllIlIIIll.registerSound(ClientboundPackets1_16.SOUND);
        lllllllllllllIllIlIllIIllIlIIIll.registerSound(ClientboundPackets1_16.ENTITY_SOUND);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this).registerServerbound(ServerboundPackets1_16_2.RECIPE_BOOK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIllIlIlIIllIlIIlll;
                final boolean lllllllllllllIIllIlIlIIllIlIIllI;
                final boolean lllllllllllllIIllIlIlIIllIlIIlIl;
                this.handler(lllllllllllllIIllIlIlIIllIlIlIII -> {
                    lllllllllllllIIllIlIlIIllIlIIlll = lllllllllllllIIllIlIlIIllIlIlIII.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIllIlIlIIllIlIIllI = lllllllllllllIIllIlIlIIllIlIlIII.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllIIllIlIlIIllIlIIlIl = lllllllllllllIIllIlIlIIllIlIlIII.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.VAR_INT, 1);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlll == 0);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlIl);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlll == 1);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlIl);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlll == 2);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlIl);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlll == 3);
                    lllllllllllllIIllIlIlIIllIlIlIII.write(Type.BOOLEAN, lllllllllllllIIllIlIlIIllIlIIlIl);
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_16, ServerboundPackets1_16_2>)this).registerServerbound(ServerboundPackets1_16_2.SEEN_RECIPE, ServerboundPackets1_16.RECIPE_BOOK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final String llllllllllllllIlIlIlllIllIIIIIIl;
                this.handler(llllllllllllllIlIlIlllIllIIIIIII -> {
                    llllllllllllllIlIlIlllIllIIIIIIl = llllllllllllllIlIlIlllIllIIIIIII.read(Type.STRING);
                    llllllllllllllIlIlIlllIllIIIIIII.write(Type.VAR_INT, 0);
                    llllllllllllllIlIlIlllIllIIIIIII.write(Type.STRING, llllllllllllllIlIlIlllIllIIIIIIl);
                });
            }
        });
    }
    
    public Protocol1_16_2To1_16_1() {
        super(ClientboundPackets1_16.class, ClientboundPackets1_16_2.class, ServerboundPackets1_16.class, ServerboundPackets1_16_2.class);
        this.metadataRewriter = new MetadataRewriter1_16_2To1_16_1(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_16_2To1_16_1.MAPPINGS;
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
}
