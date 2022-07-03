package com.viaversion.viabackwards.protocol.protocol1_9_4to1_10.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_9_4to1_10.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import java.util.function.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import com.viaversion.viabackwards.utils.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_10 extends LegacyEntityRewriter<Protocol1_9_4To1_10>
{
    @Override
    protected EntityType getObjectTypeFromId(final int llllllllllllllIllIIIllIllIlllIlI) {
        return Entity1_10Types.getTypeFromId(llllllllllllllIllIIIllIllIlllIlI, true);
    }
    
    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(Entity1_10Types.EntityType.POLAR_BEAR, Entity1_10Types.EntityType.SHEEP).mobName("Polar Bear");
        final boolean llllllllllllllIllIIIllIllIlIllII;
        this.filter().type(Entity1_10Types.EntityType.POLAR_BEAR).index(13).handler((llllllllllllllIllIIIllIllIlIlllI, llllllllllllllIllIIIllIllIlIlIll) -> {
            llllllllllllllIllIIIllIllIlIllII = (boolean)llllllllllllllIllIIIllIllIlIlIll.getValue();
            llllllllllllllIllIIIllIllIlIlIll.setTypeAndValue(MetaType1_9.Byte, (byte)(llllllllllllllIllIIIllIllIlIllII ? 14 : 0));
            return;
        });
        this.filter().type(Entity1_10Types.EntityType.ZOMBIE).index(13).handler((llllllllllllllIllIIIllIllIllIIll, llllllllllllllIllIIIllIllIllIIlI) -> {
            if ((int)llllllllllllllIllIIIllIllIllIIlI.getValue() == 6) {
                llllllllllllllIllIIIllIllIllIIlI.setValue(0);
            }
            return;
        });
        this.filter().type(Entity1_10Types.EntityType.SKELETON).index(12).handler((llllllllllllllIllIIIllIllIllIlll, llllllllllllllIllIIIllIllIllIllI) -> {
            if ((int)llllllllllllllIllIIIllIllIllIllI.getValue() == 2) {
                llllllllllllllIllIIIllIllIllIllI.setValue(0);
            }
            return;
        });
        this.filter().removeIndex(5);
    }
    
    public EntityPackets1_10(final Protocol1_9_4To1_10 llllllllllllllIllIIIllIlllIIIlll) {
        super(llllllllllllllIllIIIllIlllIIIlll);
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.handler(LegacyEntityRewriter.this.getObjectTrackerHandler());
                this.handler(LegacyEntityRewriter.this.getObjectRewriter(llllllllllllllllllIlIlIllllIIllI -> Entity1_11Types.ObjectType.findById(llllllllllllllllllIlIlIllllIIllI).orElse(null)));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIlIIlllIlIIllI) throws Exception {
                        final Optional<Entity1_12Types.ObjectType> llllllllllllllIIllIlIIlllIlIlIII = Entity1_12Types.ObjectType.findById(llllllllllllllIIllIlIIlllIlIIllI.get((Type<Byte>)Type.BYTE, 0));
                        if (llllllllllllllIIllIlIIlllIlIlIII.isPresent() && llllllllllllllIIllIlIIlllIlIlIII.get() == Entity1_12Types.ObjectType.FALLING_BLOCK) {
                            final int llllllllllllllIIllIlIIlllIlIlllI = llllllllllllllIIllIlIIlllIlIIllI.get((Type<Integer>)Type.INT, 0);
                            final int llllllllllllllIIllIlIIlllIlIllIl = llllllllllllllIIllIlIIlllIlIlllI & 0xFFF;
                            final int llllllllllllllIIllIlIIlllIlIllII = llllllllllllllIIllIlIIlllIlIlllI >> 12 & 0xF;
                            final Block llllllllllllllIIllIlIIlllIlIlIll = ((Protocol1_9_4To1_10)EntityPackets1_10.this.protocol).getItemRewriter().handleBlock(llllllllllllllIIllIlIIlllIlIllIl, llllllllllllllIIllIlIIlllIlIllII);
                            if (llllllllllllllIIllIlIIlllIlIlIll == null) {
                                return;
                            }
                            llllllllllllllIIllIlIIlllIlIIllI.set(Type.INT, 0, llllllllllllllIIllIlIIlllIlIlIll.getId() | llllllllllllllIIllIlIIlllIlIlIll.getData() << 12);
                        }
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_9_3.SPAWN_EXPERIENCE_ORB, Entity1_10Types.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_9_3.SPAWN_GLOBAL_ENTITY, Entity1_10Types.EntityType.WEATHER);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_9.METADATA_LIST);
                this.handler(EntityRewriterBase.this.getTrackerHandler(Type.UNSIGNED_BYTE, 0));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIllllIIIIllIIll) throws Exception {
                        final int lllllllllllllIllIIllllIIIIllIIlI = lllllllllllllIllIIllllIIIIllIIll.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityType lllllllllllllIllIIllllIIIIllIIIl = EntityPackets1_10.this.tracker(lllllllllllllIllIIllllIIIIllIIll.user()).entityType(lllllllllllllIllIIllllIIIIllIIlI);
                        final List<Metadata> lllllllllllllIllIIllllIIIIllIIII = lllllllllllllIllIIllllIIIIllIIll.get(Types1_9.METADATA_LIST, 0);
                        EntityPackets1_10.this.handleMetadata(lllllllllllllIllIIllllIIIIllIIll.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIllIIllllIIIIllIIII, lllllllllllllIllIIllllIIIIllIIll.user());
                        final EntityData lllllllllllllIllIIllllIIIIlIllll = EntityRewriterBase.this.entityDataForType(lllllllllllllIllIIllllIIIIllIIIl);
                        if (lllllllllllllIllIIllllIIIIlIllll != null) {
                            final WrappedMetadata lllllllllllllIllIIllllIIIIllIlIl = new WrappedMetadata(lllllllllllllIllIIllllIIIIllIIII);
                            lllllllllllllIllIIllllIIIIllIIll.set(Type.UNSIGNED_BYTE, 0, (short)lllllllllllllIllIIllllIIIIlIllll.replacementId());
                            if (lllllllllllllIllIIllllIIIIlIllll.hasBaseMeta()) {
                                lllllllllllllIllIIllllIIIIlIllll.defaultMeta().createMeta(lllllllllllllIllIIllllIIIIllIlIl);
                            }
                        }
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_9_3.SPAWN_PAINTING, Entity1_10Types.EntityType.PAINTING);
        this.registerJoinGame(ClientboundPackets1_9_3.JOIN_GAME, Entity1_10Types.EntityType.PLAYER);
        this.registerRespawn(ClientboundPackets1_9_3.RESPAWN);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_9.METADATA_LIST);
                this.handler(LegacyEntityRewriter.this.getTrackerAndMetaHandler(Types1_9.METADATA_LIST, Entity1_11Types.EntityType.PLAYER));
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_9_3.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_9_3.ENTITY_METADATA, Types1_9.METADATA_LIST);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIllIIIllIllIllllIl) {
        return Entity1_10Types.getTypeFromId(llllllllllllllIllIIIllIllIllllIl, false);
    }
}
