package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import java.util.function.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viabackwards.api.entities.storage.*;

public abstract class LegacyEntityRewriter<T extends BackwardsProtocol> extends EntityRewriterBase<T>
{
    private final /* synthetic */ Map<ObjectType, EntityData> objectTypes;
    
    @Override
    public void registerMetadataRewriter(final ClientboundPacketType lllllllllllllllIIlllIIlIlIlIIIII, final Type<List<Metadata>> lllllllllllllllIIlllIIlIlIIlllll) {
        this.registerMetadataRewriter(lllllllllllllllIIlllIIlIlIlIIIII, null, lllllllllllllllIIlllIIlIlIIlllll);
    }
    
    @Deprecated
    protected void addTrackedEntity(final PacketWrapper lllllllllllllllIIlllIIlIIlllIlll, final int lllllllllllllllIIlllIIlIIllllIlI, final EntityType lllllllllllllllIIlllIIlIIlllIlIl) throws Exception {
        this.tracker(lllllllllllllllIIlllIIlIIlllIlll.user()).addEntity(lllllllllllllllIIlllIIlIIllllIlI, lllllllllllllllIIlllIIlIIlllIlIl);
    }
    
    protected void registerRespawn(final ClientboundPacketType lllllllllllllllIIlllIIlIlIllllIl) {
        this.protocol.registerClientbound(lllllllllllllllIIlllIIlIlIllllIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final ClientWorld llllllllllllllIIIIllllIlIllIlllI;
                this.handler(llllllllllllllIIIIllllIlIllIllIl -> {
                    llllllllllllllIIIIllllIlIllIlllI = llllllllllllllIIIIllllIlIllIllIl.user().get(ClientWorld.class);
                    llllllllllllllIIIIllllIlIllIlllI.setEnvironment(llllllllllllllIIIIllllIlIllIllIl.get((Type<Integer>)Type.INT, 0));
                });
            }
        });
    }
    
    protected PacketHandler getObjectTrackerHandler() {
        return lllllllllllllllIIlllIIlIIlIlIIll -> this.addTrackedEntity(lllllllllllllllIIlllIIlIIlIlIIll, lllllllllllllllIIlllIIlIIlIlIIll.get((Type<Integer>)Type.VAR_INT, 0), this.getObjectTypeFromId(lllllllllllllllIIlllIIlIIlIlIIll.get((Type<Byte>)Type.BYTE, 0)));
    }
    
    protected EntityData getObjectData(final ObjectType lllllllllllllllIIlllIIlIllIIIlIl) {
        return this.objectTypes.get(lllllllllllllllIIlllIIlIllIIIlIl);
    }
    
    protected LegacyEntityRewriter(final T lllllllllllllllIIlllIIlIllIllllI, final MetaType lllllllllllllllIIlllIIlIllIllIIl, final MetaType lllllllllllllllIIlllIIlIllIllIII) {
        super(lllllllllllllllIIlllIIlIllIllllI, lllllllllllllllIIlllIIlIllIllIIl, 2, lllllllllllllllIIlllIIlIllIllIII, 3);
        this.objectTypes = new HashMap<ObjectType, EntityData>();
    }
    
    protected void registerJoinGame(final ClientboundPacketType lllllllllllllllIIlllIIlIlIllIlIl, final EntityType lllllllllllllllIIlllIIlIlIllIlll) {
        this.protocol.registerClientbound(lllllllllllllllIIlllIIlIlIllIlIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                final EntityType val$playerType;
                final ClientWorld lllllllllllllIIllllllllIlllIIllI;
                this.handler(lllllllllllllIIllllllllIlllIIlll -> {
                    val$playerType = lllllllllllllllIIlllIIlIlIllIlll;
                    lllllllllllllIIllllllllIlllIIllI = lllllllllllllIIllllllllIlllIIlll.user().get(ClientWorld.class);
                    lllllllllllllIIllllllllIlllIIllI.setEnvironment(lllllllllllllIIllllllllIlllIIlll.get((Type<Integer>)Type.INT, 1));
                    LegacyEntityRewriter.this.addTrackedEntity(lllllllllllllIIllllllllIlllIIlll, lllllllllllllIIllllllllIlllIIlll.get((Type<Integer>)Type.INT, 0), val$playerType);
                });
            }
        });
    }
    
    protected PacketHandler getMobSpawnRewriter(final Type<List<Metadata>> lllllllllllllllIIlllIIlIlIIllIll) {
        final int lllllllllllllllIIlllIIlIIlIIIllI;
        final EntityType lllllllllllllllIIlllIIlIIlIIIlIl;
        final List<Metadata> lllllllllllllllIIlllIIlIIlIIIlII;
        final EntityData lllllllllllllllIIlllIIlIIlIIIIll;
        return lllllllllllllllIIlllIIlIIlIIIlll -> {
            lllllllllllllllIIlllIIlIIlIIIllI = lllllllllllllllIIlllIIlIIlIIIlll.get((Type<Integer>)Type.VAR_INT, 0);
            lllllllllllllllIIlllIIlIIlIIIlIl = this.tracker(lllllllllllllllIIlllIIlIIlIIIlll.user()).entityType(lllllllllllllllIIlllIIlIIlIIIllI);
            lllllllllllllllIIlllIIlIIlIIIlII = lllllllllllllllIIlllIIlIIlIIIlll.get(lllllllllllllllIIlllIIlIlIIllIll, 0);
            this.handleMetadata(lllllllllllllllIIlllIIlIIlIIIllI, lllllllllllllllIIlllIIlIIlIIIlII, lllllllllllllllIIlllIIlIIlIIIlll.user());
            lllllllllllllllIIlllIIlIIlIIIIll = this.entityDataForType(lllllllllllllllIIlllIIlIIlIIIlIl);
            if (lllllllllllllllIIlllIIlIIlIIIIll != null) {
                lllllllllllllllIIlllIIlIIlIIIlll.set(Type.VAR_INT, 1, lllllllllllllllIIlllIIlIIlIIIIll.replacementId());
                if (lllllllllllllllIIlllIIlIIlIIIIll.hasBaseMeta()) {
                    lllllllllllllllIIlllIIlIIlIIIIll.defaultMeta().createMeta(new WrappedMetadata(lllllllllllllllIIlllIIlIIlIIIlII));
                }
            }
        };
    }
    
    protected LegacyEntityRewriter(final T lllllllllllllllIIlllIIlIlllIIlII) {
        this(lllllllllllllllIIlllIIlIlllIIlII, MetaType1_9.String, MetaType1_9.Boolean);
    }
    
    protected EntityObjectData mapObjectType(final ObjectType lllllllllllllllIIlllIIlIllIlIIIl, final ObjectType lllllllllllllllIIlllIIlIllIlIIII, final int lllllllllllllllIIlllIIlIllIIllll) {
        final EntityObjectData lllllllllllllllIIlllIIlIllIIlllI = new EntityObjectData(lllllllllllllllIIlllIIlIllIlIIIl.getId(), true, lllllllllllllllIIlllIIlIllIlIIII.getId(), lllllllllllllllIIlllIIlIllIIllll);
        this.objectTypes.put(lllllllllllllllIIlllIIlIllIlIIIl, lllllllllllllllIIlllIIlIllIIlllI);
        return lllllllllllllllIIlllIIlIllIIlllI;
    }
    
    protected PacketHandler getTrackerAndMetaHandler(final Type<List<Metadata>> lllllllllllllllIIlllIIlIlIIlIIIl, final EntityType lllllllllllllllIIlllIIlIlIIIllIl) {
        final List<Metadata> lllllllllllllllIIlllIIlIIlIlllII;
        return lllllllllllllllIIlllIIlIIlIllIII -> {
            this.addTrackedEntity(lllllllllllllllIIlllIIlIIlIllIII, lllllllllllllllIIlllIIlIIlIllIII.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllllIIlllIIlIlIIIllIl);
            lllllllllllllllIIlllIIlIIlIlllII = lllllllllllllllIIlllIIlIIlIllIII.get(lllllllllllllllIIlllIIlIlIIlIIIl, 0);
            this.handleMetadata(lllllllllllllllIIlllIIlIIlIllIII.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllllIIlllIIlIIlIlllII, lllllllllllllllIIlllIIlIIlIllIII.user());
        };
    }
    
    @Override
    public void registerMetadataRewriter(final ClientboundPacketType lllllllllllllllIIlllIIlIlIlIlIlI, final Type<List<Metadata>> lllllllllllllllIIlllIIlIlIlIllIl, final Type<List<Metadata>> lllllllllllllllIIlllIIlIlIlIllII) {
        this.protocol.registerClientbound(lllllllllllllllIIlllIIlIlIlIlIlI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                if (lllllllllllllllIIlllIIlIlIlIllIl != null) {
                    this.map(lllllllllllllllIIlllIIlIlIlIllIl, lllllllllllllllIIlllIIlIlIlIllII);
                }
                else {
                    this.map(lllllllllllllllIIlllIIlIlIlIllII);
                }
                final List<Metadata> lllllllllllllIIlllIllIIIIIlIIlll;
                this.handler(lllllllllllllIIlllIllIIIIIlIIlII -> {
                    lllllllllllllIIlllIllIIIIIlIIlll = lllllllllllllIIlllIllIIIIIlIIlII.get(lllllllllllllllIIlllIIlIlIlIllII, 0);
                    LegacyEntityRewriter.this.handleMetadata(lllllllllllllIIlllIllIIIIIlIIlII.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIIlllIllIIIIIlIIlll, lllllllllllllIIlllIllIIIIIlIIlII.user());
                });
            }
        });
    }
    
    protected PacketHandler getObjectRewriter(final Function<Byte, ObjectType> lllllllllllllllIIlllIIlIlIIIlIIl) {
        final ObjectType lllllllllllllllIIlllIIlIIllIllII;
        EntityData lllllllllllllllIIlllIIlIIllIlIll;
        return lllllllllllllllIIlllIIlIIllIllIl -> {
            lllllllllllllllIIlllIIlIIllIllII = lllllllllllllllIIlllIIlIlIIIlIIl.apply(lllllllllllllllIIlllIIlIIllIllIl.get((Type<Byte>)Type.BYTE, 0));
            if (lllllllllllllllIIlllIIlIIllIllII == null) {
                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find Entity Type").append(lllllllllllllllIIlllIIlIIllIllIl.get((Type<Object>)Type.BYTE, 0))));
            }
            else {
                lllllllllllllllIIlllIIlIIllIlIll = this.getObjectData(lllllllllllllllIIlllIIlIIllIllII);
                if (lllllllllllllllIIlllIIlIIllIlIll != null) {
                    lllllllllllllllIIlllIIlIIllIllIl.set(Type.BYTE, 0, (byte)lllllllllllllllIIlllIIlIIllIlIll.replacementId());
                    if (lllllllllllllllIIlllIIlIIllIlIll.objectData() != -1) {
                        lllllllllllllllIIlllIIlIIllIllIl.set(Type.INT, 0, lllllllllllllllIIlllIIlIIllIlIll.objectData());
                    }
                }
            }
        };
    }
    
    protected EntityType getObjectTypeFromId(final int lllllllllllllllIIlllIIlIlIIIIIll) {
        return this.typeFromId(lllllllllllllllIIlllIIlIlIIIIIll);
    }
}
