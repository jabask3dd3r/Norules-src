package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.rewriter.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.google.common.base.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public abstract class EntityRewriterBase<T extends BackwardsProtocol> extends EntityRewriter<T>
{
    private final /* synthetic */ int displayNameIndex;
    private final /* synthetic */ Int2ObjectMap<EntityData> entityDataMappings;
    private final /* synthetic */ int displayVisibilityIndex;
    private final /* synthetic */ MetaType displayNameMetaType;
    private final /* synthetic */ MetaType displayVisibilityMetaType;
    
    @Override
    public void handleMetadata(final int lllllllllllllIllllIlllIIIlIlllII, final List<Metadata> lllllllllllllIllllIlllIIIlIllIll, final UserConnection lllllllllllllIllllIlllIIIlIlIIll) {
        final EntityType lllllllllllllIllllIlllIIIlIllIIl = this.tracker(lllllllllllllIllllIlllIIIlIlIIll).entityType(lllllllllllllIllllIlllIIIlIlllII);
        if (lllllllllllllIllllIlllIIIlIllIIl == null) {
            return;
        }
        super.handleMetadata(lllllllllllllIllllIlllIIIlIlllII, lllllllllllllIllllIlllIIIlIllIll, lllllllllllllIllllIlllIIIlIlIIll);
        final EntityData lllllllllllllIllllIlllIIIlIllIII = this.entityDataForType(lllllllllllllIllllIlllIIIlIllIIl);
        final Metadata lllllllllllllIllllIlllIIIlIlIlll = this.getMeta(this.displayNameIndex, lllllllllllllIllllIlllIIIlIllIll);
        if (lllllllllllllIllllIlllIIIlIlIlll != null && lllllllllllllIllllIlllIIIlIllIII != null && lllllllllllllIllllIlllIIIlIllIII.mobName() != null && (lllllllllllllIllllIlllIIIlIlIlll.getValue() == null || lllllllllllllIllllIlllIIIlIlIlll.getValue().toString().isEmpty()) && lllllllllllllIllllIlllIIIlIlIlll.metaType().typeId() == this.displayNameMetaType.typeId()) {
            lllllllllllllIllllIlllIIIlIlIlll.setValue(lllllllllllllIllllIlllIIIlIllIII.mobName());
            if (ViaBackwards.getConfig().alwaysShowOriginalMobName()) {
                this.removeMeta(this.displayVisibilityIndex, lllllllllllllIllllIlllIIIlIllIll);
                lllllllllllllIllllIlllIIIlIllIll.add(new Metadata(this.displayVisibilityIndex, this.displayVisibilityMetaType, true));
            }
        }
        if (lllllllllllllIllllIlllIIIlIllIII != null && lllllllllllllIllllIlllIIIlIllIII.hasBaseMeta()) {
            lllllllllllllIllllIlllIIIlIllIII.defaultMeta().createMeta(new WrappedMetadata(lllllllllllllIllllIlllIIIlIllIll));
        }
    }
    
    protected boolean hasData(final EntityType lllllllllllllIllllIlllIIIIllIlll) {
        return this.entityDataMappings.containsKey(lllllllllllllIllllIlllIIIIllIlll.getId());
    }
    
    protected PacketHandler getTrackerHandler(final Type<? extends Number> lllllllllllllIllllIllIllllllIIII, final int lllllllllllllIllllIllIlllllIllll) {
        final Number lllllllllllllIllllIllIlllIllllIl;
        return lllllllllllllIllllIllIlllIlllIIl -> {
            lllllllllllllIllllIllIlllIllllIl = lllllllllllllIllllIllIlllIlllIIl.get(lllllllllllllIllllIllIllllllIIII, lllllllllllllIllllIllIlllllIllll);
            this.tracker(lllllllllllllIllllIllIlllIlllIIl.user()).addEntity(lllllllllllllIllllIllIlllIlllIIl.get((Type<Integer>)Type.VAR_INT, 0), this.typeFromId(lllllllllllllIllllIllIlllIllllIl.intValue()));
        };
    }
    
    protected StoredEntityData storedEntityData(final MetaHandlerEvent lllllllllllllIllllIlllIIIIlIlIll) {
        return this.tracker(lllllllllllllIllllIlllIIIIlIlIll.user()).entityData(lllllllllllllIllllIlllIIIIlIlIll.entityId());
    }
    
    EntityRewriterBase(final T lllllllllllllIllllIlllIIIllIllll, final MetaType lllllllllllllIllllIlllIIIllIlllI, final int lllllllllllllIllllIlllIIIllIllIl, final MetaType lllllllllllllIllllIlllIIIllIIllI, final int lllllllllllllIllllIlllIIIllIlIll) {
        super(lllllllllllllIllllIlllIIIllIllll, false);
        this.entityDataMappings = new Int2ObjectOpenHashMap<EntityData>();
        this.displayNameMetaType = lllllllllllllIllllIlllIIIllIlllI;
        this.displayNameIndex = lllllllllllllIllllIlllIIIllIllIl;
        this.displayVisibilityMetaType = lllllllllllllIllllIlllIIIllIIllI;
        this.displayVisibilityIndex = lllllllllllllIllllIlllIIIllIlIll;
    }
    
    protected void removeMeta(final int lllllllllllllIllllIlllIIIIlllllI, final List<Metadata> lllllllllllllIllllIlllIIIIllllll) {
        lllllllllllllIllllIlllIIIIllllll.removeIf(lllllllllllllIllllIllIlllIIllIII -> lllllllllllllIllllIllIlllIIllIII.id() == lllllllllllllIllllIlllIIIIlllllI);
    }
    
    protected EntityData mapEntityTypeWithData(final EntityType lllllllllllllIllllIlllIIIIIlllll, final EntityType lllllllllllllIllllIlllIIIIlIIIll) {
        Preconditions.checkArgument(lllllllllllllIllllIlllIIIIIlllll.getClass() == lllllllllllllIllllIlllIIIIlIIIll.getClass());
        final int lllllllllllllIllllIlllIIIIlIIIlI = this.newEntityId(lllllllllllllIllllIlllIIIIlIIIll.getId());
        final EntityData lllllllllllllIllllIlllIIIIlIIIIl = new EntityData(lllllllllllllIllllIlllIIIIIlllll.getId(), lllllllllllllIllllIlllIIIIlIIIlI);
        this.mapEntityType(lllllllllllllIllllIlllIIIIIlllll.getId(), lllllllllllllIllllIlllIIIIlIIIlI);
        this.entityDataMappings.put(lllllllllllllIllllIlllIIIIIlllll.getId(), lllllllllllllIllllIlllIIIIlIIIIl);
        return lllllllllllllIllllIlllIIIIlIIIIl;
    }
    
    protected Metadata getMeta(final int lllllllllllllIllllIlllIIIlIIlIIl, final List<Metadata> lllllllllllllIllllIlllIIIlIIIllI) {
        for (final Metadata lllllllllllllIllllIlllIIIlIIlIll : lllllllllllllIllllIlllIIIlIIIllI) {
            if (lllllllllllllIllllIlllIIIlIIlIll.id() == lllllllllllllIllllIlllIIIlIIlIIl) {
                return lllllllllllllIllllIlllIIIlIIlIll;
            }
        }
        return null;
    }
    
    protected PacketHandler getDimensionHandler(final int lllllllllllllIllllIllIllllIlllll) {
        final ClientWorld lllllllllllllIllllIllIllllIllIII;
        final int lllllllllllllIllllIllIllllIlIlll;
        return lllllllllllllIllllIllIllllIlIlIl -> {
            lllllllllllllIllllIllIllllIllIII = lllllllllllllIllllIllIllllIlIlIl.user().get(ClientWorld.class);
            lllllllllllllIllllIllIllllIlIlll = lllllllllllllIllllIllIllllIlIlIl.get((Type<Integer>)Type.INT, lllllllllllllIllllIllIllllIlllll);
            lllllllllllllIllllIllIllllIllIII.setEnvironment(lllllllllllllIllllIllIllllIlIlll);
        };
    }
    
    protected PacketHandler getTrackerHandler(final EntityType lllllllllllllIllllIllIlllllIIlll, final Type<? extends Number> lllllllllllllIllllIllIlllllIIIll) {
        return lllllllllllllIllllIllIllllIIlIll -> this.tracker(lllllllllllllIllllIllIllllIIlIll.user()).addEntity((int)lllllllllllllIllllIllIllllIIlIll.get(lllllllllllllIllllIllIlllllIIIll, 0), lllllllllllllIllllIllIlllllIIlll);
    }
    
    public void registerMetaTypeHandler(final MetaType lllllllllllllIllllIllIlllllllIll, final MetaType lllllllllllllIllllIllIllllllllll, final MetaType lllllllllllllIllllIllIlllllllllI, final MetaType lllllllllllllIllllIllIllllllllIl) {
        final MetaType lllllllllllllIllllIllIlllIlIIllI;
        int lllllllllllllIllllIllIlllIlIllll;
        JsonElement lllllllllllllIllllIllIlllIlIlllI;
        this.filter().handler((lllllllllllllIllllIllIlllIlIlIII, lllllllllllllIllllIllIlllIlIIlll) -> {
            lllllllllllllIllllIllIlllIlIIllI = lllllllllllllIllllIllIlllIlIIlll.metaType();
            if (lllllllllllllIllllIllIlllllllIll != null && lllllllllllllIllllIllIlllIlIIllI == lllllllllllllIllllIllIlllllllIll) {
                this.protocol.getItemRewriter().handleItemToClient((Item)lllllllllllllIllllIllIlllIlIIlll.value());
            }
            else if (lllllllllllllIllllIllIllllllllll != null && lllllllllllllIllllIllIlllIlIIllI == lllllllllllllIllllIllIllllllllll) {
                lllllllllllllIllllIllIlllIlIllll = (int)lllllllllllllIllllIllIlllIlIIlll.value();
                lllllllllllllIllllIllIlllIlIIlll.setValue(this.protocol.getMappingData().getNewBlockStateId(lllllllllllllIllllIllIlllIlIllll));
            }
            else if (lllllllllllllIllllIllIlllllllllI != null && lllllllllllllIllllIllIlllIlIIllI == lllllllllllllIllllIllIlllllllllI) {
                this.rewriteParticle((Particle)lllllllllllllIllllIllIlllIlIIlll.value());
            }
            else if (lllllllllllllIllllIllIllllllllIl != null && lllllllllllllIllllIllIlllIlIIllI == lllllllllllllIllllIllIllllllllIl) {
                lllllllllllllIllllIllIlllIlIlllI = (JsonElement)lllllllllllllIllllIllIlllIlIIlll.value();
                if (lllllllllllllIllllIllIlllIlIlllI != null) {
                    this.protocol.getTranslatableRewriter().processText(lllllllllllllIllllIllIlllIlIlllI);
                }
            }
        });
    }
    
    protected PacketHandler getTrackerHandler() {
        return this.getTrackerHandler(Type.VAR_INT, 1);
    }
    
    protected EntityData entityDataForType(final EntityType lllllllllllllIllllIlllIIIIllIIIl) {
        return this.entityDataMappings.get(lllllllllllllIllllIlllIIIIllIIIl.getId());
    }
    
    @Override
    public <E extends Enum> void mapTypes(final EntityType[] lllllllllllllIllllIlllIIIIIlIIII, final Class<E> lllllllllllllIllllIlllIIIIIIllII) {
        if (this.typeMappings == null) {
            this.typeMappings = new Int2IntOpenHashMap(lllllllllllllIllllIlllIIIIIlIIII.length, 1.0f);
            this.typeMappings.defaultReturnValue(-1);
        }
        final double lllllllllllllIllllIlllIIIIIIlIll = (Object)lllllllllllllIllllIlllIIIIIlIIII;
        final String lllllllllllllIllllIlllIIIIIIlIlI = (String)lllllllllllllIllllIlllIIIIIIlIll.length;
        for (char lllllllllllllIllllIlllIIIIIIlIIl = '\0'; lllllllllllllIllllIlllIIIIIIlIIl < lllllllllllllIllllIlllIIIIIIlIlI; ++lllllllllllllIllllIlllIIIIIIlIIl) {
            final EntityType lllllllllllllIllllIlllIIIIIlIIlI = lllllllllllllIllllIlllIIIIIIlIll[lllllllllllllIllllIlllIIIIIIlIIl];
            try {
                final E lllllllllllllIllllIlllIIIIIlIIll = java.lang.Enum.valueOf(lllllllllllllIllllIlllIIIIIIllII, lllllllllllllIllllIlllIIIIIlIIlI.name());
                this.typeMappings.put(lllllllllllllIllllIlllIIIIIlIIlI.getId(), ((EntityType)lllllllllllllIllllIlllIIIIIlIIll).getId());
            }
            catch (IllegalArgumentException ex) {}
        }
    }
}
