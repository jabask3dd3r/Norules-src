package com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.data.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.types.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_16_2 extends ItemRewriter<Protocol1_16_1To1_16_2>
{
    @Override
    protected void registerPackets() {
        final BlockRewriter llllllllllllllIlIllllIlllIIIIllI = new BlockRewriter(this.protocol, Type.POSITION1_14);
        new RecipeRewriter1_16(this.protocol).registerDefaultHandler(ClientboundPackets1_16_2.DECLARE_RECIPES);
        this.registerSetCooldown(ClientboundPackets1_16_2.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_16_2.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_16_2.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerEntityEquipmentArray(ClientboundPackets1_16_2.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
        this.registerTradeList(ClientboundPackets1_16_2.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_16_2.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.UNLOCK_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllIlIllIlIllIIlllIIl -> {
                    llllllllllllllIlIllIlIllIIlllIIl.passthrough((Type<Object>)Type.VAR_INT);
                    llllllllllllllIlIllIlIllIIlllIIl.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.passthrough((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.read((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.read((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.read((Type<Object>)Type.BOOLEAN);
                    llllllllllllllIlIllIlIllIIlllIIl.read((Type<Object>)Type.BOOLEAN);
                });
            }
        });
        llllllllllllllIlIllllIlllIIIIllI.registerAcknowledgePlayerDigging(ClientboundPackets1_16_2.ACKNOWLEDGE_PLAYER_DIGGING);
        llllllllllllllIlIllllIlllIIIIllI.registerBlockAction(ClientboundPackets1_16_2.BLOCK_ACTION);
        llllllllllllllIlIllllIlllIIIIllI.registerBlockChange(ClientboundPackets1_16_2.BLOCK_CHANGE);
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Chunk lllllllllllllIIlIIlIllllllIIlllI;
                int lllllllllllllIIlIIlIllllllIlIlIl;
                ChunkSection lllllllllllllIIlIIlIllllllIlIllI;
                int lllllllllllllIIlIIlIllllllIlIlll;
                int lllllllllllllIIlIIlIllllllIllIII;
                final Iterator<CompoundTag> iterator;
                CompoundTag lllllllllllllIIlIIlIllllllIlIIIl;
                IntTag lllllllllllllIIlIIlIllllllIlIlII;
                IntTag lllllllllllllIIlIIlIllllllIlIIll;
                IntTag lllllllllllllIIlIIlIllllllIlIIlI;
                this.handler(lllllllllllllIIlIIlIllllllIIllII -> {
                    lllllllllllllIIlIIlIllllllIIlllI = lllllllllllllIIlIIlIllllllIIllII.read((Type<Chunk>)new Chunk1_16_2Type());
                    lllllllllllllIIlIIlIllllllIIllII.write(new Chunk1_16Type(), lllllllllllllIIlIIlIllllllIIlllI);
                    lllllllllllllIIlIIlIllllllIIlllI.setIgnoreOldLightData(true);
                    for (lllllllllllllIIlIIlIllllllIlIlIl = 0; lllllllllllllIIlIIlIllllllIlIlIl < lllllllllllllIIlIIlIllllllIIlllI.getSections().length; ++lllllllllllllIIlIIlIllllllIlIlIl) {
                        lllllllllllllIIlIIlIllllllIlIllI = lllllllllllllIIlIIlIllllllIIlllI.getSections()[lllllllllllllIIlIIlIllllllIlIlIl];
                        if (lllllllllllllIIlIIlIllllllIlIllI != null) {
                            for (lllllllllllllIIlIIlIllllllIlIlll = 0; lllllllllllllIIlIIlIllllllIlIlll < lllllllllllllIIlIIlIllllllIlIllI.getPaletteSize(); ++lllllllllllllIIlIIlIllllllIlIlll) {
                                lllllllllllllIIlIIlIllllllIllIII = lllllllllllllIIlIIlIllllllIlIllI.getPaletteEntry(lllllllllllllIIlIIlIllllllIlIlll);
                                lllllllllllllIIlIIlIllllllIlIllI.setPaletteEntry(lllllllllllllIIlIIlIllllllIlIlll, ((Protocol1_16_1To1_16_2)BlockItemPackets1_16_2.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIlIIlIllllllIllIII));
                            }
                        }
                    }
                    lllllllllllllIIlIIlIllllllIIlllI.getBlockEntities().iterator();
                    while (iterator.hasNext()) {
                        lllllllllllllIIlIIlIllllllIlIIIl = iterator.next();
                        if (lllllllllllllIIlIIlIllllllIlIIIl == null) {
                            continue;
                        }
                        else {
                            lllllllllllllIIlIIlIllllllIlIlII = lllllllllllllIIlIIlIllllllIlIIIl.get("x");
                            lllllllllllllIIlIIlIllllllIlIIll = lllllllllllllIIlIIlIllllllIlIIIl.get("y");
                            lllllllllllllIIlIIlIllllllIlIIlI = lllllllllllllIIlIIlIllllllIlIIIl.get("z");
                            if (lllllllllllllIIlIIlIllllllIlIlII != null && lllllllllllllIIlIIlIllllllIlIIll != null && lllllllllllllIIlIIlIllllllIlIIlI != null) {
                                BlockItemPackets1_16_2.this.handleBlockEntity(lllllllllllllIIlIIlIllllllIlIIIl, new Position(lllllllllllllIIlIIlIllllllIlIlII.asInt(), lllllllllllllIIlIIlIllllllIlIIll.asShort(), lllllllllllllIIlIIlIllllllIlIIlI.asInt()));
                            }
                            else {
                                continue;
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position lllllllllllllIlIIlllIIIllIIIIIlI;
                this.handler(lllllllllllllIlIIlllIIIllIIIIIII -> {
                    lllllllllllllIlIIlllIIIllIIIIIlI = lllllllllllllIlIIlllIIIllIIIIIII.passthrough(Type.POSITION1_14);
                    lllllllllllllIlIIlllIIIllIIIIIII.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                    BlockItemPackets1_16_2.this.handleBlockEntity(lllllllllllllIlIIlllIIIllIIIIIII.passthrough(Type.NBT), lllllllllllllIlIIlllIIIllIIIIIlI);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final long lllllllllllllIlllllIlIIllllIlIlI;
                final int lllllllllllllIlllllIlIIllllIIlll;
                final int lllllllllllllIlllllIlIIllllIIlIl;
                final int lllllllllllllIlllllIlIIllllIIIll;
                final BlockChangeRecord[] lllllllllllllIlllllIlIIllllIIIIl;
                int lllllllllllllIlllllIlIIlllllIIlI;
                BlockChangeRecord lllllllllllllIlllllIlIIlllllIlll;
                int lllllllllllllIlllllIlIIlllllIlII;
                this.handler(lllllllllllllIlllllIlIIlllIlllII -> {
                    lllllllllllllIlllllIlIIllllIlIlI = lllllllllllllIlllllIlIIlllIlllII.read((Type<Long>)Type.LONG);
                    lllllllllllllIlllllIlIIlllIlllII.read((Type<Object>)Type.BOOLEAN);
                    lllllllllllllIlllllIlIIllllIIlll = (int)(lllllllllllllIlllllIlIIllllIlIlI >> 42);
                    lllllllllllllIlllllIlIIllllIIlIl = (int)(lllllllllllllIlllllIlIIllllIlIlI << 44 >> 44);
                    lllllllllllllIlllllIlIIllllIIIll = (int)(lllllllllllllIlllllIlIIllllIlIlI << 22 >> 42);
                    lllllllllllllIlllllIlIIlllIlllII.write(Type.INT, lllllllllllllIlllllIlIIllllIIlll);
                    lllllllllllllIlllllIlIIlllIlllII.write(Type.INT, lllllllllllllIlllllIlIIllllIIIll);
                    lllllllllllllIlllllIlIIllllIIIIl = lllllllllllllIlllllIlIIlllIlllII.read(Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY);
                    lllllllllllllIlllllIlIIlllIlllII.write(Type.BLOCK_CHANGE_RECORD_ARRAY, lllllllllllllIlllllIlIIllllIIIIl);
                    for (lllllllllllllIlllllIlIIlllllIIlI = 0; lllllllllllllIlllllIlIIlllllIIlI < lllllllllllllIlllllIlIIllllIIIIl.length; ++lllllllllllllIlllllIlIIlllllIIlI) {
                        lllllllllllllIlllllIlIIlllllIlll = lllllllllllllIlllllIlIIllllIIIIl[lllllllllllllIlllllIlIIlllllIIlI];
                        lllllllllllllIlllllIlIIlllllIlII = ((Protocol1_16_1To1_16_2)BlockItemPackets1_16_2.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIlllllIlIIlllllIlll.getBlockId());
                        lllllllllllllIlllllIlIIllllIIIIl[lllllllllllllIlllllIlIIlllllIIlI] = new BlockChangeRecord1_8(lllllllllllllIlllllIlIIlllllIlll.getSectionX(), lllllllllllllIlllllIlIIlllllIlll.getY(lllllllllllllIlllllIlIIllllIIlIl), lllllllllllllIlllllIlIIlllllIlll.getSectionZ(), lllllllllllllIlllllIlIIlllllIlII);
                    }
                });
            }
        });
        llllllllllllllIlIllllIlllIIIIllI.registerEffect(ClientboundPackets1_16_2.EFFECT, 1010, 2001);
        this.registerSpawnParticle(ClientboundPackets1_16_2.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.DOUBLE);
        this.registerClickWindow(ServerboundPackets1_16.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_16.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this.protocol).registerServerbound(ServerboundPackets1_16.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIlIIlIIIIlllIlIII -> BlockItemPackets1_16_2.this.handleItemToServer(lllllllllllllIlIlIIlIIIIlllIlIII.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
    }
    
    public BlockItemPackets1_16_2(final Protocol1_16_1To1_16_2 llllllllllllllIlIllllIlllIIIlIll, final TranslatableRewriter llllllllllllllIlIllllIlllIIIllIl) {
        super(llllllllllllllIlIllllIlllIIIlIll, llllllllllllllIlIllllIlllIIIllIl);
    }
    
    private void handleBlockEntity(final CompoundTag llllllllllllllIlIllllIllIllIIIll, final Position llllllllllllllIlIllllIllIllIIlll) {
        final StringTag llllllllllllllIlIllllIllIllIIlIl = llllllllllllllIlIllllIllIllIIIll.get("id");
        if (llllllllllllllIlIllllIllIllIIlIl == null) {
            return;
        }
        if (llllllllllllllIlIllllIllIllIIlIl.getValue().equals("minecraft:skull")) {
            final Tag llllllllllllllIlIllllIllIlllIIIl = llllllllllllllIlIllllIllIllIIIll.get("SkullOwner");
            if (!(llllllllllllllIlIllllIllIlllIIIl instanceof CompoundTag)) {
                return;
            }
            final CompoundTag llllllllllllllIlIllllIllIlllIIII = (CompoundTag)llllllllllllllIlIllllIllIlllIIIl;
            if (!llllllllllllllIlIllllIllIlllIIII.contains("Id")) {
                return;
            }
            final CompoundTag llllllllllllllIlIllllIllIllIllll = llllllllllllllIlIllllIllIlllIIII.get("Properties");
            if (llllllllllllllIlIllllIllIllIllll == null) {
                return;
            }
            final ListTag llllllllllllllIlIllllIllIllIlllI = llllllllllllllIlIllllIllIllIllll.get("textures");
            if (llllllllllllllIlIllllIllIllIlllI == null) {
                return;
            }
            final CompoundTag llllllllllllllIlIllllIllIllIllIl = (llllllllllllllIlIllllIllIllIlllI.size() > 0) ? llllllllllllllIlIllllIllIllIlllI.get(0) : null;
            if (llllllllllllllIlIllllIllIllIllIl == null) {
                return;
            }
            final int llllllllllllllIlIllllIllIllIllII = llllllllllllllIlIllllIllIllIllIl.get("Value").getValue().hashCode();
            final int[] llllllllllllllIlIllllIllIllIlIll = { llllllllllllllIlIllllIllIllIllII, 0, 0, 0 };
            llllllllllllllIlIllllIllIlllIIII.put("Id", new IntArrayTag(llllllllllllllIlIllllIllIllIlIll));
        }
    }
}
