package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.logging.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.google.common.base.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.rewriter.meta.*;
import java.util.*;

public abstract class EntityRewriter<T extends Protocol> extends RewriterBase<T> implements com.viaversion.viaversion.api.rewriter.EntityRewriter<T>
{
    protected final /* synthetic */ List<MetaFilter> metadataFilters;
    private static final /* synthetic */ Metadata[] EMPTY_ARRAY;
    protected /* synthetic */ Int2IntMap typeMappings;
    protected final /* synthetic */ boolean trackMappedType;
    
    public void registerMetaTypeHandler(final MetaType lllllllllllllllIIlIIllllIlIIIIlI, final MetaType lllllllllllllllIIlIIllllIlIIIIIl, final MetaType lllllllllllllllIIlIIllllIlIIIIII) {
        int lllllllllllllllIIlIIlllIIIIIlIIl;
        this.filter().handler((lllllllllllllllIIlIIlllIIIIIIlII, lllllllllllllllIIlIIlllIIIIIIIll) -> {
            if (lllllllllllllllIIlIIllllIlIIIIlI != null && lllllllllllllllIIlIIlllIIIIIIIll.metaType() == lllllllllllllllIIlIIllllIlIIIIlI) {
                this.protocol.getItemRewriter().handleItemToClient((Item)lllllllllllllllIIlIIlllIIIIIIIll.value());
            }
            else if (lllllllllllllllIIlIIllllIlIIIIIl != null && lllllllllllllllIIlIIlllIIIIIIIll.metaType() == lllllllllllllllIIlIIllllIlIIIIIl) {
                lllllllllllllllIIlIIlllIIIIIlIIl = (int)lllllllllllllllIIlIIlllIIIIIIIll.value();
                lllllllllllllllIIlIIlllIIIIIIIll.setValue(this.protocol.getMappingData().getNewBlockStateId(lllllllllllllllIIlIIlllIIIIIlIIl));
            }
            else if (lllllllllllllllIIlIIllllIlIIIIII != null && lllllllllllllllIIlIIlllIIIIIIIll.metaType() == lllllllllllllllIIlIIllllIlIIIIII) {
                this.rewriteParticle((Particle)lllllllllllllllIIlIIlllIIIIIIIll.value());
            }
        });
    }
    
    private void logException(final Exception lllllllllllllllIIlIIlllIIlIlllIl, final EntityType lllllllllllllllIIlIIlllIIllIIIIl, final List<Metadata> lllllllllllllllIIlIIlllIIlIllIll, final Metadata lllllllllllllllIIlIIlllIIlIlllll) {
        if (!Via.getConfig().isSuppressMetadataErrors() || Via.getManager().isDebug()) {
            final Logger lllllllllllllllIIlIIlllIIllIIlII = Via.getPlatform().getLogger();
            lllllllllllllllIIlIIlllIIllIIlII.severe(String.valueOf(new StringBuilder().append("An error occurred in metadata handler ").append(this.getClass().getSimpleName()).append(" for ").append((lllllllllllllllIIlIIlllIIllIIIIl != null) ? lllllllllllllllIIlIIlllIIllIIIIl.name() : "untracked").append(" entity type: ").append(lllllllllllllllIIlIIlllIIlIlllll)));
            lllllllllllllllIIlIIlllIIllIIlII.severe(lllllllllllllllIIlIIlllIIlIllIll.stream().sorted(Comparator.comparingInt(Metadata::id)).map((Function<? super Object, ?>)Metadata::toString).collect((Collector<? super Object, ?, String>)Collectors.joining("\n", "Full metadata: ", "")));
            lllllllllllllllIIlIIlllIIlIlllIl.printStackTrace();
        }
    }
    
    protected void rewriteParticle(final Particle lllllllllllllllIIlIIlllIIllIlllI) {
        final ParticleMappings lllllllllllllllIIlIIlllIIlllIIIl = this.protocol.getMappingData().getParticleMappings();
        final int lllllllllllllllIIlIIlllIIlllIIII = lllllllllllllllIIlIIlllIIllIlllI.getId();
        if (lllllllllllllllIIlIIlllIIlllIIII == lllllllllllllllIIlIIlllIIlllIIIl.getBlockId() || lllllllllllllllIIlIIlllIIlllIIII == lllllllllllllllIIlIIlllIIlllIIIl.getFallingDustId()) {
            final Particle.ParticleData lllllllllllllllIIlIIlllIIlllIlIl = lllllllllllllllIIlIIlllIIllIlllI.getArguments().get(0);
            lllllllllllllllIIlIIlllIIlllIlIl.setValue(this.protocol.getMappingData().getNewBlockStateId(lllllllllllllllIIlIIlllIIlllIlIl.get()));
        }
        else if (lllllllllllllllIIlIIlllIIlllIIII == lllllllllllllllIIlIIlllIIlllIIIl.getItemId()) {
            final Particle.ParticleData lllllllllllllllIIlIIlllIIlllIlII = lllllllllllllllIIlIIlllIIllIlllI.getArguments().get(0);
            lllllllllllllllIIlIIlllIIlllIlII.setValue(this.protocol.getMappingData().getNewItemId(lllllllllllllllIIlIIlllIIlllIlII.get()));
        }
        lllllllllllllllIIlIIlllIIllIlllI.setId(this.protocol.getMappingData().getNewParticleId(lllllllllllllllIIlIIlllIIlllIIII));
    }
    
    public void registerTracker(final ClientboundPacketType lllllllllllllllIIlIIllllIIIIlIll, final EntityType lllllllllllllllIIlIIllllIIIIlIlI, final Type<?> lllllllllllllllIIlIIllllIIIIlIIl) {
        this.protocol.registerClientbound(lllllllllllllllIIlIIllllIIIIlIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Type<Integer> val$intType;
                final EntityType val$entityType;
                final int lllllllllllllIIllIIIlllllIlIIIlI;
                this.handler(lllllllllllllIIllIIIlllllIIllllI -> {
                    val$intType = (Type<Integer>)lllllllllllllllIIlIIllllIIIIlIIl;
                    val$entityType = lllllllllllllllIIlIIllllIIIIlIlI;
                    lllllllllllllIIllIIIlllllIlIIIlI = lllllllllllllIIllIIIlllllIIllllI.passthrough(val$intType);
                    EntityRewriter.this.tracker(lllllllllllllIIllIIIlllllIIllllI.user()).addEntity(lllllllllllllIIllIIIlllllIlIIIlI, val$entityType);
                });
            }
        });
    }
    
    static {
        EMPTY_ARRAY = new Metadata[0];
    }
    
    public void registerMetadataRewriter(final ClientboundPacketType lllllllllllllllIIlIIlllIllIllIll, final Type<List<Metadata>> lllllllllllllllIIlIIlllIllIlIlIl, final Type<List<Metadata>> lllllllllllllllIIlIIlllIllIlIIll) {
        this.protocol.registerClientbound(lllllllllllllllIIlIIlllIllIllIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                if (lllllllllllllllIIlIIlllIllIlIlIl != null) {
                    this.map(lllllllllllllllIIlIIlllIllIlIlIl, lllllllllllllllIIlIIlllIllIlIIll);
                }
                else {
                    this.map(lllllllllllllllIIlIIlllIllIlIIll);
                }
                final Type<List<Metadata>> val$newMetaType;
                final int lllllllllllllIlIIlIIIllIIIIIIllI;
                final List<Metadata> lllllllllllllIlIIlIIIllIIIIIIlIl;
                this.handler(lllllllllllllIlIIlIIIllIIIIIIIlI -> {
                    val$newMetaType = lllllllllllllllIIlIIlllIllIlIIll;
                    lllllllllllllIlIIlIIIllIIIIIIllI = lllllllllllllIlIIlIIIllIIIIIIIlI.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlIIlIIIllIIIIIIlIl = lllllllllllllIlIIlIIIllIIIIIIIlI.get(val$newMetaType, 0);
                    EntityRewriter.this.handleMetadata(lllllllllllllIlIIlIIIllIIIIIIllI, lllllllllllllIlIIlIIIllIIIIIIlIl, lllllllllllllIlIIlIIIllIIIIIIIlI.user());
                });
            }
        });
    }
    
    public void registerFilter(final MetaFilter lllllllllllllllIIlIIlllllIllllII) {
        Preconditions.checkArgument(!this.metadataFilters.contains(lllllllllllllllIIlIIlllllIllllII));
        this.metadataFilters.add(lllllllllllllllIIlIIlllllIllllII);
    }
    
    public <E extends Enum> void mapTypes(final EntityType[] lllllllllllllllIIlIIllllIlIIlllI, final Class<E> lllllllllllllllIIlIIllllIlIlIIII) {
        if (this.typeMappings == null) {
            this.typeMappings = new Int2IntOpenHashMap(lllllllllllllllIIlIIllllIlIIlllI.length, 1.0f);
            this.typeMappings.defaultReturnValue(-1);
        }
        final Exception lllllllllllllllIIlIIllllIlIIllII = (Object)lllllllllllllllIIlIIllllIlIIlllI;
        for (short lllllllllllllllIIlIIllllIlIIlIll = (short)lllllllllllllllIIlIIllllIlIIllII.length, lllllllllllllllIIlIIllllIlIIlIlI = 0; lllllllllllllllIIlIIllllIlIIlIlI < lllllllllllllllIIlIIllllIlIIlIll; ++lllllllllllllllIIlIIllllIlIIlIlI) {
            final EntityType lllllllllllllllIIlIIllllIlIlIIll = lllllllllllllllIIlIIllllIlIIllII[lllllllllllllllIIlIIllllIlIIlIlI];
            try {
                final E lllllllllllllllIIlIIllllIlIlIlIl = java.lang.Enum.valueOf(lllllllllllllllIIlIIllllIlIlIIII, lllllllllllllllIIlIIllllIlIlIIll.name());
                this.typeMappings.put(lllllllllllllllIIlIIllllIlIlIIll.getId(), ((EntityType)lllllllllllllllIIlIIllllIlIlIlIl).getId());
            }
            catch (IllegalArgumentException lllllllllllllllIIlIIllllIlIlIlII) {
                if (!this.typeMappings.containsKey(lllllllllllllllIIlIIllllIlIlIIll.getId())) {
                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find new entity type for ").append(lllllllllllllllIIlIIllllIlIlIIll).append("! Old type: ").append(lllllllllllllllIIlIIllllIlIlIIll.getClass().getEnclosingClass().getSimpleName()).append(", new type: ").append(lllllllllllllllIIlIIllllIlIlIIII.getEnclosingClass().getSimpleName())));
                }
            }
        }
    }
    
    @Deprecated
    protected Metadata metaByIndex(final int lllllllllllllllIIlIIlllIlIIIIlIl, final List<Metadata> lllllllllllllllIIlIIlllIlIIIIIll) {
        for (final Metadata lllllllllllllllIIlIIlllIlIIIlIII : lllllllllllllllIIlIIlllIlIIIIIll) {
            if (lllllllllllllllIIlIIlllIlIIIlIII.id() == lllllllllllllllIIlIIlllIlIIIIlIl) {
                return lllllllllllllllIIlIIlllIlIIIlIII;
            }
        }
        return null;
    }
    
    protected EntityRewriter(final T lllllllllllllllIIlIIllllllIIlIIl, final boolean lllllllllllllllIIlIIllllllIIIlIl) {
        super(lllllllllllllllIIlIIllllllIIlIIl);
        this.metadataFilters = new ArrayList<MetaFilter>();
        this.trackMappedType = lllllllllllllllIIlIIllllllIIIlIl;
        lllllllllllllllIIlIIllllllIIlIIl.put(this);
    }
    
    protected PacketHandler worldDataTrackerHandler(final int lllllllllllllllIIlIIlllIlIllIllI) {
        final EntityTracker lllllllllllllllIIlIIlllIIIIllIlI;
        final CompoundTag lllllllllllllllIIlIIlllIIIIllIIl;
        final Tag lllllllllllllllIIlIIlllIIIIllIII;
        int lllllllllllllllIIlIIlllIIIIllllI;
        final Tag lllllllllllllllIIlIIlllIIIIlIlll;
        return lllllllllllllllIIlIIlllIIIIlIlII -> {
            lllllllllllllllIIlIIlllIIIIllIlI = this.tracker(lllllllllllllllIIlIIlllIIIIlIlII.user());
            lllllllllllllllIIlIIlllIIIIllIIl = lllllllllllllllIIlIIlllIIIIlIlII.get(Type.NBT, lllllllllllllllIIlIIlllIlIllIllI);
            lllllllllllllllIIlIIlllIIIIllIII = lllllllllllllllIIlIIlllIIIIllIIl.get("height");
            if (lllllllllllllllIIlIIlllIIIIllIII instanceof IntTag) {
                lllllllllllllllIIlIIlllIIIIllllI = ((IntTag)lllllllllllllllIIlIIlllIIIIllIII).asInt();
                lllllllllllllllIIlIIlllIIIIllIlI.setCurrentWorldSectionHeight(lllllllllllllllIIlIIlllIIIIllllI >> 4);
            }
            else {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Height missing in dimension data: ").append(lllllllllllllllIIlIIlllIIIIllIIl)));
            }
            lllllllllllllllIIlIIlllIIIIlIlll = lllllllllllllllIIlIIlllIIIIllIIl.get("min_y");
            if (lllllllllllllllIIlIIlllIIIIlIlll instanceof IntTag) {
                lllllllllllllllIIlIIlllIIIIllIlI.setCurrentMinY(((IntTag)lllllllllllllllIIlIIlllIIIIlIlll).asInt());
            }
            else {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Min Y missing in dimension data: ").append(lllllllllllllllIIlIIlllIIIIllIIl)));
            }
        };
    }
    
    protected void mapEntityType(final int lllllllllllllllIIlIIllllIlIlllll, final int lllllllllllllllIIlIIllllIlIllllI) {
        if (this.typeMappings == null) {
            this.typeMappings = new Int2IntOpenHashMap();
            this.typeMappings.defaultReturnValue(-1);
        }
        this.typeMappings.put(lllllllllllllllIIlIIllllIlIlllll, lllllllllllllllIIlIIllllIlIllllI);
    }
    
    public PacketHandler trackerAndRewriterHandler(final Type<List<Metadata>> lllllllllllllllIIlIIlllIlIlIlIlI) {
        final int lllllllllllllllIIlIIlllIIIllIIII;
        final int lllllllllllllllIIlIIlllIIIlIllll;
        final int lllllllllllllllIIlIIlllIIIlIlllI;
        final EntityType lllllllllllllllIIlIIlllIIIlIllIl;
        return lllllllllllllllIIlIIlllIIIllIIIl -> {
            lllllllllllllllIIlIIlllIIIllIIII = lllllllllllllllIIlIIlllIIIllIIIl.get((Type<Integer>)Type.VAR_INT, 0);
            lllllllllllllllIIlIIlllIIIlIllll = lllllllllllllllIIlIIlllIIIllIIIl.get((Type<Integer>)Type.VAR_INT, 1);
            lllllllllllllllIIlIIlllIIIlIlllI = this.newEntityId(lllllllllllllllIIlIIlllIIIlIllll);
            if (lllllllllllllllIIlIIlllIIIlIlllI != lllllllllllllllIIlIIlllIIIlIllll) {
                lllllllllllllllIIlIIlllIIIllIIIl.set(Type.VAR_INT, 1, lllllllllllllllIIlIIlllIIIlIlllI);
            }
            lllllllllllllllIIlIIlllIIIlIllIl = this.typeFromId(this.trackMappedType ? lllllllllllllllIIlIIlllIIIlIlllI : lllllllllllllllIIlIIlllIIIlIllll);
            this.tracker(lllllllllllllllIIlIIlllIIIllIIIl.user()).addEntity(lllllllllllllllIIlIIlllIIIllIIII, lllllllllllllllIIlIIlllIIIlIllIl);
            if (lllllllllllllllIIlIIlllIlIlIlIlI != null) {
                this.handleMetadata(lllllllllllllllIIlIIlllIIIllIIII, lllllllllllllllIIlIIlllIIIllIIIl.get(lllllllllllllllIIlIIlllIlIlIlIlI, 0), lllllllllllllllIIlIIlllIIIllIIIl.user());
            }
        };
    }
    
    @Override
    public void handleMetadata(final int lllllllllllllllIIlIIlllllIlIIIll, final List<Metadata> lllllllllllllllIIlIIlllllIlIIIlI, final UserConnection lllllllllllllllIIlIIlllllIIllIll) {
        final EntityType lllllllllllllllIIlIIlllllIlIIIII = this.tracker(lllllllllllllllIIlIIlllllIIllIll).entityType(lllllllllllllllIIlIIlllllIlIIIll);
        int lllllllllllllllIIlIIlllllIIlllll = 0;
        final short lllllllllllllllIIlIIlllllIIllIII = (Object)lllllllllllllllIIlIIlllllIlIIIlI.toArray(EntityRewriter.EMPTY_ARRAY);
        final char lllllllllllllllIIlIIlllllIIlIlll = (char)lllllllllllllllIIlIIlllllIIllIII.length;
        for (long lllllllllllllllIIlIIlllllIIlIllI = 0; lllllllllllllllIIlIIlllllIIlIllI < lllllllllllllllIIlIIlllllIIlIlll; ++lllllllllllllllIIlIIlllllIIlIllI) {
            final Metadata lllllllllllllllIIlIIlllllIlIIlIl = lllllllllllllllIIlIIlllllIIllIII[lllllllllllllllIIlIIlllllIIlIllI];
            if (!this.callOldMetaHandler(lllllllllllllllIIlIIlllllIlIIIll, lllllllllllllllIIlIIlllllIlIIIII, lllllllllllllllIIlIIlllllIlIIlIl, lllllllllllllllIIlIIlllllIlIIIlI, lllllllllllllllIIlIIlllllIIllIll)) {
                lllllllllllllllIIlIIlllllIlIIIlI.remove(lllllllllllllllIIlIIlllllIIlllll--);
            }
            else {
                MetaHandlerEvent lllllllllllllllIIlIIlllllIlIIllI = null;
                for (final MetaFilter lllllllllllllllIIlIIlllllIlIIlll : this.metadataFilters) {
                    if (!lllllllllllllllIIlIIlllllIlIIlll.isFiltered(lllllllllllllllIIlIIlllllIlIIIII, lllllllllllllllIIlIIlllllIlIIlIl)) {
                        continue;
                    }
                    if (lllllllllllllllIIlIIlllllIlIIllI == null) {
                        lllllllllllllllIIlIIlllllIlIIllI = new MetaHandlerEventImpl(lllllllllllllllIIlIIlllllIIllIll, lllllllllllllllIIlIIlllllIlIIIII, lllllllllllllllIIlIIlllllIlIIIll, lllllllllllllllIIlIIlllllIlIIlIl, lllllllllllllllIIlIIlllllIlIIIlI);
                    }
                    try {
                        lllllllllllllllIIlIIlllllIlIIlll.handler().handle(lllllllllllllllIIlIIlllllIlIIllI, lllllllllllllllIIlIIlllllIlIIlIl);
                    }
                    catch (Exception lllllllllllllllIIlIIlllllIlIlIII) {
                        this.logException(lllllllllllllllIIlIIlllllIlIlIII, lllllllllllllllIIlIIlllllIlIIIII, lllllllllllllllIIlIIlllllIlIIIlI, lllllllllllllllIIlIIlllllIlIIlIl);
                        lllllllllllllllIIlIIlllllIlIIIlI.remove(lllllllllllllllIIlIIlllllIIlllll--);
                        break;
                    }
                    if (lllllllllllllllIIlIIlllllIlIIllI.cancelled()) {
                        lllllllllllllllIIlIIlllllIlIIIlI.remove(lllllllllllllllIIlIIlllllIIlllll--);
                        break;
                    }
                }
                if (lllllllllllllllIIlIIlllllIlIIllI != null && lllllllllllllllIIlIIlllllIlIIllI.extraMeta() != null) {
                    lllllllllllllllIIlIIlllllIlIIIlI.addAll(lllllllllllllllIIlIIlllllIlIIllI.extraMeta());
                }
                ++lllllllllllllllIIlIIlllllIIlllll;
            }
        }
    }
    
    public void registerTracker(final ClientboundPacketType lllllllllllllllIIlIIlllIlllllllI, final EntityType lllllllllllllllIIlIIllllIIIIIIII) {
        this.registerTracker(lllllllllllllllIIlIIlllIlllllllI, lllllllllllllllIIlIIllllIIIIIIII, Type.VAR_INT);
    }
    
    public void registerTrackerWithData(final ClientboundPacketType lllllllllllllllIIlIIllllIIlIIIII, final EntityType lllllllllllllllIIlIIllllIIlIIlII) {
        this.protocol.registerClientbound(lllllllllllllllIIlIIllllIIlIIIII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.handler(EntityRewriter.this.trackerHandler());
                final EntityType val$fallingBlockType;
                final int lllllllllllllIIlIIllIIllIlIIIIlI;
                final EntityType lllllllllllllIIlIIllIIllIlIIIIIl;
                this.handler(lllllllllllllIIlIIllIIllIIlllllI -> {
                    val$fallingBlockType = lllllllllllllllIIlIIllllIIlIIlII;
                    lllllllllllllIIlIIllIIllIlIIIIlI = lllllllllllllIIlIIllIIllIIlllllI.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIIlIIllIIllIlIIIIIl = EntityRewriter.this.tracker(lllllllllllllIIlIIllIIllIIlllllI.user()).entityType(lllllllllllllIIlIIllIIllIlIIIIlI);
                    if (lllllllllllllIIlIIllIIllIlIIIIIl == val$fallingBlockType) {
                        lllllllllllllIIlIIllIIllIIlllllI.set(Type.INT, 0, EntityRewriter.this.protocol.getMappingData().getNewBlockStateId(lllllllllllllIIlIIllIIllIIlllllI.get((Type<Integer>)Type.INT, 0)));
                    }
                });
            }
        });
    }
    
    public void mapEntityType(final EntityType lllllllllllllllIIlIIllllIllIlIII, final EntityType lllllllllllllllIIlIIllllIllIIlll) {
        Preconditions.checkArgument(lllllllllllllllIIlIIllllIllIlIII.getClass() != lllllllllllllllIIlIIllllIllIIlll.getClass(), (Object)"EntityTypes should not be of the same class/enum");
        this.mapEntityType(lllllllllllllllIIlIIllllIllIlIII.getId(), lllllllllllllllIIlIIllllIllIIlll.getId());
    }
    
    public MetaFilter.Builder filter() {
        return new MetaFilter.Builder(this);
    }
    
    public PacketHandler trackerAndRewriterHandler(final Type<List<Metadata>> lllllllllllllllIIlIIlllIlIIlllII, final EntityType lllllllllllllllIIlIIlllIlIIllIlI) {
        final int lllllllllllllllIIlIIlllIIlIIIIII;
        return lllllllllllllllIIlIIlllIIIllllII -> {
            lllllllllllllllIIlIIlllIIlIIIIII = lllllllllllllllIIlIIlllIIIllllII.get((Type<Integer>)Type.VAR_INT, 0);
            this.tracker(lllllllllllllllIIlIIlllIIIllllII.user()).addEntity(lllllllllllllllIIlIIlllIIlIIIIII, lllllllllllllllIIlIIlllIlIIllIlI);
            if (lllllllllllllllIIlIIlllIlIIlllII != null) {
                this.handleMetadata(lllllllllllllllIIlIIlllIIlIIIIII, lllllllllllllllIIlIIlllIIIllllII.get(lllllllllllllllIIlIIlllIlIIlllII, 0), lllllllllllllllIIlIIlllIIIllllII.user());
            }
        };
    }
    
    public void registerTracker(final ClientboundPacketType lllllllllllllllIIlIIllllIIllIIlI) {
        this.protocol.registerClientbound(lllllllllllllllIIlIIllllIIllIIlI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.handler(EntityRewriter.this.trackerHandler());
            }
        });
    }
    
    public PacketHandler trackerHandler() {
        return this.trackerAndRewriterHandler(null);
    }
    
    @Override
    public int newEntityId(final int lllllllllllllllIIlIIllllIlllIIII) {
        return (this.typeMappings != null) ? this.typeMappings.getOrDefault(lllllllllllllllIIlIIllllIlllIIII, lllllllllllllllIIlIIllllIlllIIII) : lllllllllllllllIIlIIllllIlllIIII;
    }
    
    @Deprecated
    private boolean callOldMetaHandler(final int lllllllllllllllIIlIIlllllIIIIIIl, final EntityType lllllllllllllllIIlIIlllllIIIIIII, final Metadata lllllllllllllllIIlIIlllllIIIIlIl, final List<Metadata> lllllllllllllllIIlIIllllIllllllI, final UserConnection lllllllllllllllIIlIIllllIlllllIl) {
        try {
            this.handleMetadata(lllllllllllllllIIlIIlllllIIIIIIl, lllllllllllllllIIlIIlllllIIIIIII, lllllllllllllllIIlIIlllllIIIIlIl, lllllllllllllllIIlIIllllIllllllI, lllllllllllllllIIlIIllllIlllllIl);
            return true;
        }
        catch (Exception lllllllllllllllIIlIIlllllIIIlIIl) {
            this.logException(lllllllllllllllIIlIIlllllIIIlIIl, lllllllllllllllIIlIIlllllIIIIIII, lllllllllllllllIIlIIllllIllllllI, lllllllllllllllIIlIIlllllIIIIlIl);
            return false;
        }
    }
    
    public PacketHandler objectTrackerHandler() {
        final int lllllllllllllllIIlIIlllIIlIlIIIl;
        final byte lllllllllllllllIIlIIlllIIlIlIIII;
        final EntityType lllllllllllllllIIlIIlllIIlIIllll;
        return lllllllllllllllIIlIIlllIIlIlIIlI -> {
            lllllllllllllllIIlIIlllIIlIlIIIl = lllllllllllllllIIlIIlllIIlIlIIlI.get((Type<Integer>)Type.VAR_INT, 0);
            lllllllllllllllIIlIIlllIIlIlIIII = lllllllllllllllIIlIIlllIIlIlIIlI.get((Type<Byte>)Type.BYTE, 0);
            lllllllllllllllIIlIIlllIIlIIllll = this.objectTypeFromId(lllllllllllllllIIlIIlllIIlIlIIII);
            this.tracker(lllllllllllllllIIlIIlllIIlIlIIlI.user()).addEntity(lllllllllllllllIIlIIlllIIlIlIIIl, lllllllllllllllIIlIIlllIIlIIllll);
        };
    }
    
    public void registerMetadataRewriter(final ClientboundPacketType lllllllllllllllIIlIIlllIllIIIlll, final Type<List<Metadata>> lllllllllllllllIIlIIlllIllIIIllI) {
        this.registerMetadataRewriter(lllllllllllllllIIlIIlllIllIIIlll, null, lllllllllllllllIIlIIlllIllIIIllI);
    }
    
    public void registerRemoveEntity(final ClientboundPacketType lllllllllllllllIIlIIlllIlllIlIIl) {
        this.protocol.registerClientbound(lllllllllllllllIIlIIlllIlllIlIIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIllIlllIllIlIlIIIIl;
                this.handler(lllllllllllllIllIlllIllIlIIlllll -> {
                    lllllllllllllIllIlllIllIlIlIIIIl = lllllllllllllIllIlllIllIlIIlllll.passthrough((Type<Integer>)Type.VAR_INT);
                    EntityRewriter.this.tracker(lllllllllllllIllIlllIllIlIIlllll.user()).removeEntity(lllllllllllllIllIlllIllIlIlIIIIl);
                });
            }
        });
    }
    
    @Deprecated
    protected void handleMetadata(final int lllllllllllllllIIlIIllllIllllIlI, final EntityType lllllllllllllllIIlIIllllIllllIIl, final Metadata lllllllllllllllIIlIIllllIllllIII, final List<Metadata> lllllllllllllllIIlIIllllIlllIlll, final UserConnection lllllllllllllllIIlIIllllIlllIllI) throws Exception {
    }
    
    public void registerRemoveEntities(final ClientboundPacketType lllllllllllllllIIlIIlllIllllIIll) {
        this.protocol.registerClientbound(lllllllllllllllIIlIIlllIllllIIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int[] lllllllllllllIlIlIllIllllllllIII;
                final EntityTracker lllllllllllllIlIlIllIlllllllIlll;
                final byte lllllllllllllIlIlIllIlllllllIIlI;
                long lllllllllllllIlIlIllIlllllllIIIl;
                int lllllllllllllIlIlIllIlllllllIIII;
                int lllllllllllllIlIlIllIllllllllIll;
                this.handler(lllllllllllllIlIlIllIllllllllIIl -> {
                    lllllllllllllIlIlIllIllllllllIII = lllllllllllllIlIlIllIllllllllIIl.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                    lllllllllllllIlIlIllIlllllllIlll = EntityRewriter.this.tracker(lllllllllllllIlIlIllIllllllllIIl.user());
                    lllllllllllllIlIlIllIlllllllIIlI = (byte)(Object)lllllllllllllIlIlIllIllllllllIII;
                    for (lllllllllllllIlIlIllIlllllllIIIl = lllllllllllllIlIlIllIlllllllIIlI.length, lllllllllllllIlIlIllIlllllllIIII = 0; lllllllllllllIlIlIllIlllllllIIII < lllllllllllllIlIlIllIlllllllIIIl; ++lllllllllllllIlIlIllIlllllllIIII) {
                        lllllllllllllIlIlIllIllllllllIll = lllllllllllllIlIlIllIlllllllIIlI[lllllllllllllIlIlIllIlllllllIIII];
                        lllllllllllllIlIlIllIlllllllIlll.removeEntity(lllllllllllllIlIlIllIllllllllIll);
                    }
                });
            }
        });
    }
    
    protected EntityRewriter(final T lllllllllllllllIIlIIllllllIIlllI) {
        this(lllllllllllllllIIlIIllllllIIlllI, true);
    }
}
