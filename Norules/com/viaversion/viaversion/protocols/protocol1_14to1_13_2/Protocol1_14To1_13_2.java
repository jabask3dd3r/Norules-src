package com.viaversion.viaversion.protocols.protocol1_14to1_13_2;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.packets.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.storage.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;

public class Protocol1_14To1_13_2 extends AbstractProtocol<ClientboundPackets1_13, ClientboundPackets1_14, ServerboundPackets1_13, ServerboundPackets1_14>
{
    private final /* synthetic */ EntityRewriter metadataRewriter;
    public static final /* synthetic */ MappingData MAPPINGS;
    private final /* synthetic */ ItemRewriter itemRewriter;
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.metadataRewriter;
    }
    
    @Override
    protected void registerPackets() {
        this.metadataRewriter.register();
        this.itemRewriter.register();
        EntityPackets.register(this);
        WorldPackets.register(this);
        PlayerPackets.register(this);
        new SoundRewriter(this).registerSound(ClientboundPackets1_13.SOUND);
        new StatisticsRewriter(this).register(ClientboundPackets1_13.STATISTICS);
        final ComponentRewriter lllllllllllllIIlllllIIllllIllIlI = new ComponentRewriter1_14(this);
        lllllllllllllIIlllllIIllllIllIlI.registerChatMessage(ClientboundPackets1_13.CHAT_MESSAGE);
        final CommandRewriter1_14 lllllllllllllIIlllllIIllllIllIIl = new CommandRewriter1_14(this);
        lllllllllllllIIlllllIIllllIllIIl.registerDeclareCommands(ClientboundPackets1_13.DECLARE_COMMANDS);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.TAGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIIIlIllIlIlIIl) throws Exception {
                        final int lllllllllllllIIIIlIIIlIllIlIllIl = lllllllllllllIIIIlIIIlIllIlIlIIl.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT, lllllllllllllIIIIlIIIlIllIlIllIl + 6);
                        for (int lllllllllllllIIIIlIIIlIllIllIlII = 0; lllllllllllllIIIIlIIIlIllIllIlII < lllllllllllllIIIIlIIIlIllIlIllIl; ++lllllllllllllIIIIlIIIlIllIllIlII) {
                            lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough(Type.STRING);
                            final int[] lllllllllllllIIIIlIIIlIllIllIlIl = lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                            for (int lllllllllllllIIIIlIIIlIllIllIllI = 0; lllllllllllllIIIIlIIIlIllIllIllI < lllllllllllllIIIIlIIIlIllIllIlIl.length; ++lllllllllllllIIIIlIIIlIllIllIllI) {
                                lllllllllllllIIIIlIIIlIllIllIlIl[lllllllllllllIIIIlIIIlIllIllIllI] = Protocol1_14To1_13_2.this.getMappingData().getNewBlockId(lllllllllllllIIIIlIIIlIllIllIlIl[lllllllllllllIIIIlIIIlIllIllIllI]);
                            }
                        }
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:signs");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { Protocol1_14To1_13_2.this.getMappingData().getNewBlockId(150), Protocol1_14To1_13_2.this.getMappingData().getNewBlockId(155) });
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:wall_signs");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { Protocol1_14To1_13_2.this.getMappingData().getNewBlockId(155) });
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:standing_signs");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { Protocol1_14To1_13_2.this.getMappingData().getNewBlockId(150) });
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:fences");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { 189, 248, 472, 473, 474, 475 });
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:walls");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { 271, 272 });
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:wooden_fences");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { 189, 472, 473, 474, 475 });
                        final int lllllllllllllIIIIlIIIlIllIlIllII = lllllllllllllIIIIlIIIlIllIlIlIIl.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT, lllllllllllllIIIIlIIIlIllIlIllII + 2);
                        for (int lllllllllllllIIIIlIIIlIllIllIIIl = 0; lllllllllllllIIIIlIIIlIllIllIIIl < lllllllllllllIIIIlIIIlIllIlIllII; ++lllllllllllllIIIIlIIIlIllIllIIIl) {
                            lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough(Type.STRING);
                            final int[] lllllllllllllIIIIlIIIlIllIllIIlI = lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                            for (int lllllllllllllIIIIlIIIlIllIllIIll = 0; lllllllllllllIIIIlIIIlIllIllIIll < lllllllllllllIIIIlIIIlIllIllIIlI.length; ++lllllllllllllIIIIlIIIlIllIllIIll) {
                                lllllllllllllIIIIlIIIlIllIllIIlI[lllllllllllllIIIIlIIIlIllIllIIll] = Protocol1_14To1_13_2.this.getMappingData().getNewItemId(lllllllllllllIIIIlIIIlIllIllIIlI[lllllllllllllIIIIlIIIlIllIllIIll]);
                            }
                        }
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:signs");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { Protocol1_14To1_13_2.this.getMappingData().getNewItemId(541) });
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.STRING, "minecraft:arrows");
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { 526, 825, 826 });
                        for (int lllllllllllllIIIIlIIIlIllIlIlIll = lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIIIlIIIlIllIllIIII = 0; lllllllllllllIIIIlIIIlIllIllIIII < lllllllllllllIIIIlIIIlIllIlIlIll; ++lllllllllllllIIIIlIIIlIllIllIIII) {
                            lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough(Type.STRING);
                            lllllllllllllIIIIlIIIlIllIlIlIIl.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                        }
                        lllllllllllllIIIIlIIIlIllIlIlIIl.write(Type.VAR_INT, 0);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).cancelServerbound(ServerboundPackets1_14.SET_DIFFICULTY);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).cancelServerbound(ServerboundPackets1_14.LOCK_DIFFICULTY);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).cancelServerbound(ServerboundPackets1_14.UPDATE_JIGSAW_BLOCK);
    }
    
    public Protocol1_14To1_13_2() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_14.class, ServerboundPackets1_13.class, ServerboundPackets1_14.class);
        this.metadataRewriter = new MetadataRewriter1_14To1_13_2(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    @Override
    protected void onMappingDataLoaded() {
        WorldPackets.air = this.getMappingData().getBlockStateMappings().getNewId(0);
        WorldPackets.voidAir = this.getMappingData().getBlockStateMappings().getNewId(8591);
        WorldPackets.caveAir = this.getMappingData().getBlockStateMappings().getNewId(8592);
    }
    
    static {
        MAPPINGS = new MappingData();
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_14To1_13_2.MAPPINGS;
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIIlllllIIllllIIllIl) {
        lllllllllllllIIlllllIIllllIIllIl.addEntityTracker(this.getClass(), new EntityTracker1_14(lllllllllllllIIlllllIIllllIIllIl));
        if (!lllllllllllllIIlllllIIllllIIllIl.has(ClientWorld.class)) {
            lllllllllllllIIlllllIIllllIIllIl.put(new ClientWorld(lllllllllllllIIlllllIIllllIIllIl));
        }
    }
}
