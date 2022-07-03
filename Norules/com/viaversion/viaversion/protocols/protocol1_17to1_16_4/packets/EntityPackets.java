package com.viaversion.viaversion.protocols.protocol1_17to1_16_4.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public final class EntityPackets extends EntityRewriter<Protocol1_17To1_16_4>
{
    @Override
    protected void registerRewrites() {
        int lllllllllllllIIllllllIlllllllIII;
        this.filter().handler((lllllllllllllIIllllllIllllllIlll, lllllllllllllIIllllllIllllllIllI) -> {
            lllllllllllllIIllllllIllllllIllI.setMetaType(MetaType1_17.byId(lllllllllllllIIllllllIllllllIllI.metaType().typeId()));
            if (lllllllllllllIIllllllIllllllIllI.metaType() == MetaType1_17.POSE) {
                lllllllllllllIIllllllIlllllllIII = (int)lllllllllllllIIllllllIllllllIllI.value();
                if (lllllllllllllIIllllllIlllllllIII > 5) {
                    lllllllllllllIIllllllIllllllIllI.setValue(lllllllllllllIIllllllIlllllllIII + 1);
                }
            }
            return;
        });
        this.registerMetaTypeHandler(MetaType1_17.ITEM, MetaType1_17.BLOCK_STATE, MetaType1_17.PARTICLE);
        this.filter().filterFamily(Entity1_17Types.ENTITY).addIndex(7);
        final int lllllllllllllIIllllllIlllllllllI;
        this.filter().filterFamily(Entity1_17Types.MINECART_ABSTRACT).index(11).handler((lllllllllllllIIlllllllIIIIIIIIII, lllllllllllllIIllllllIllllllllll) -> {
            lllllllllllllIIllllllIlllllllllI = (int)lllllllllllllIIllllllIllllllllll.getValue();
            lllllllllllllIIllllllIllllllllll.setValue(((Protocol1_17To1_16_4)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIllllllIlllllllllI));
            return;
        });
        this.filter().type(Entity1_17Types.SHULKER).removeIndex(17);
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIIlllllllIIIIIIIlIl) {
        return Entity1_17Types.getTypeFromId(lllllllllllllIIlllllllIIIIIIIlIl);
    }
    
    public EntityPackets(final Protocol1_17To1_16_4 lllllllllllllIIlllllllIIIIIlIIIl) {
        super(lllllllllllllIIlllllllIIIIIlIIIl);
        this.mapTypes(Entity1_16_2Types.values(), Entity1_17Types.class);
    }
    
    public void registerPackets() {
        this.registerTrackerWithData(ClientboundPackets1_16_2.SPAWN_ENTITY, Entity1_17Types.FALLING_BLOCK);
        this.registerTracker(ClientboundPackets1_16_2.SPAWN_MOB);
        this.registerTracker(ClientboundPackets1_16_2.SPAWN_PLAYER, Entity1_17Types.PLAYER);
        this.registerMetadataRewriter(ClientboundPackets1_16_2.ENTITY_METADATA, Types1_16.METADATA_LIST, Types1_17.METADATA_LIST);
        ((Protocol<ClientboundPackets1_16_2, ClientboundPackets1_17, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.DESTROY_ENTITIES, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int[] lllllllllllllIlIlIllIIlIlllIlllI;
                final EntityTracker lllllllllllllIlIlIllIIlIlllIllIl;
                final byte lllllllllllllIlIlIllIIlIlllIlIIl;
                String lllllllllllllIlIlIllIIlIlllIlIII;
                long lllllllllllllIlIlIllIIlIlllIIlll;
                int lllllllllllllIlIlIllIIlIllllIIII;
                PacketWrapper lllllllllllllIlIlIllIIlIllllIIIl;
                this.handler(lllllllllllllIlIlIllIIlIlllIllll -> {
                    lllllllllllllIlIlIllIIlIlllIlllI = lllllllllllllIlIlIllIIlIlllIllll.read(Type.VAR_INT_ARRAY_PRIMITIVE);
                    lllllllllllllIlIlIllIIlIlllIllll.cancel();
                    lllllllllllllIlIlIllIIlIlllIllIl = lllllllllllllIlIlIllIIlIlllIllll.user().getEntityTracker(Protocol1_17To1_16_4.class);
                    lllllllllllllIlIlIllIIlIlllIlIIl = (byte)(Object)lllllllllllllIlIlIllIIlIlllIlllI;
                    for (lllllllllllllIlIlIllIIlIlllIlIII = (String)lllllllllllllIlIlIllIIlIlllIlIIl.length, lllllllllllllIlIlIllIIlIlllIIlll = 0; lllllllllllllIlIlIllIIlIlllIIlll < lllllllllllllIlIlIllIIlIlllIlIII; ++lllllllllllllIlIlIllIIlIlllIIlll) {
                        lllllllllllllIlIlIllIIlIllllIIII = lllllllllllllIlIlIllIIlIlllIlIIl[lllllllllllllIlIlIllIIlIlllIIlll];
                        lllllllllllllIlIlIllIIlIlllIllIl.removeEntity(lllllllllllllIlIlIllIIlIllllIIII);
                        lllllllllllllIlIlIllIIlIllllIIIl = lllllllllllllIlIlIllIIlIlllIllll.create(ClientboundPackets1_17.REMOVE_ENTITY);
                        lllllllllllllIlIlIllIIlIllllIIIl.write(Type.VAR_INT, lllllllllllllIlIlIllIIlIllllIIII);
                        lllllllllllllIlIlIllIIlIllllIIIl.send(Protocol1_17To1_16_4.class);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllIlllIIIIIIlIllIIlII -> lllllllllllllIlllIIIIIIlIllIIlII.write(Type.VAR_INT, (Integer)lllllllllllllIlllIIIIIIlIllIIlII.read((Type<T>)Type.INT)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllIlIIllIlIlIIIIIlIIl -> lllllllllllllIlIIllIlIlIIIIIlIIl.write(Type.BOOLEAN, false));
            }
        });
        ((Protocol<ClientboundPackets1_16_2, ClientboundPackets1_17, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.COMBAT_EVENT, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIIIlIllIlIIIlllIIl;
                final ClientboundPacketType llllllllllllllIIIlIllIlIIIllllIl;
                final ClientboundPacketType llllllllllllllIIIlIllIlIIIllllII;
                final ClientboundPacketType llllllllllllllIIIlIllIlIIIlllIll;
                final IllegalArgumentException ex;
                final ClientboundPacketType llllllllllllllIIIlIllIlIIIlllIII;
                this.handler(llllllllllllllIIIlIllIlIIIlllIlI -> {
                    llllllllllllllIIIlIllIlIIIlllIIl = llllllllllllllIIIlIllIlIIIlllIlI.read((Type<Integer>)Type.VAR_INT);
                    switch (llllllllllllllIIIlIllIlIIIlllIIl) {
                        case 0: {
                            llllllllllllllIIIlIllIlIIIllllIl = ClientboundPackets1_17.COMBAT_ENTER;
                            break;
                        }
                        case 1: {
                            llllllllllllllIIIlIllIlIIIllllII = ClientboundPackets1_17.COMBAT_END;
                            break;
                        }
                        case 2: {
                            llllllllllllllIIIlIllIlIIIlllIll = ClientboundPackets1_17.COMBAT_KILL;
                            break;
                        }
                        default: {
                            new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid combat type received: ").append(llllllllllllllIIIlIllIlIIIlllIIl)));
                            throw ex;
                        }
                    }
                    llllllllllllllIIIlIllIlIIIlllIlI.setId(llllllllllllllIIIlIllIlIIIlllIII.getId());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).cancelClientbound(ClientboundPackets1_16_2.ENTITY_MOVEMENT);
    }
}
