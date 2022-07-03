package com.viaversion.viaversion.protocols.protocol1_11to1_10.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.*;

public class MetadataRewriter1_11To1_10 extends EntityRewriter<Protocol1_11To1_10>
{
    @Override
    public EntityType objectTypeFromId(final int lllllllllllllIIllIIIIlIlIllIlIII) {
        return Entity1_11Types.getTypeFromId(lllllllllllllIIllIIIIlIlIllIlIII, true);
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIIllIIIIlIlIllIllIl) {
        return Entity1_11Types.getTypeFromId(lllllllllllllIIllIIIIlIlIllIllIl, false);
    }
    
    public MetadataRewriter1_11To1_10(final Protocol1_11To1_10 lllllllllllllIIllIIIIlIllIIllIIl) {
        super(lllllllllllllIIllIIIIlIllIIllIIl);
    }
    
    public static Optional<Metadata> getById(final List<Metadata> lllllllllllllIIllIIIIlIlIlIIlIlI, final int lllllllllllllIIllIIIIlIlIlIIlIll) {
        for (final Metadata lllllllllllllIIllIIIIlIlIlIIllIl : lllllllllllllIIllIIIIlIlIlIIlIlI) {
            if (lllllllllllllIIllIIIIlIlIlIIllIl.id() == lllllllllllllIIllIIIIlIlIlIIlIll) {
                return Optional.of(lllllllllllllIIllIIIIlIlIlIIllIl);
            }
        }
        return Optional.empty();
    }
    
    @Override
    protected void handleMetadata(final int lllllllllllllIIllIIIIlIlIllllIlI, final EntityType lllllllllllllIIllIIIIlIlIlllllll, final Metadata lllllllllllllIIllIIIIlIlIllllIII, final List<Metadata> lllllllllllllIIllIIIIlIlIlllIlll, final UserConnection lllllllllllllIIllIIIIlIlIlllIllI) {
        if (lllllllllllllIIllIIIIlIlIllllIII.getValue() instanceof DataItem) {
            EntityIdRewriter.toClientItem((Item)lllllllllllllIIllIIIIlIlIllllIII.getValue());
        }
        if (lllllllllllllIIllIIIIlIlIlllllll == null) {
            return;
        }
        if (lllllllllllllIIllIIIIlIlIlllllll.is(Entity1_11Types.EntityType.ELDER_GUARDIAN) || lllllllllllllIIllIIIIlIlIlllllll.is(Entity1_11Types.EntityType.GUARDIAN)) {
            final int lllllllllllllIIllIIIIlIllIIIlIll = lllllllllllllIIllIIIIlIlIllllIII.id();
            if (lllllllllllllIIllIIIIlIllIIIlIll == 12) {
                final boolean lllllllllllllIIllIIIIlIllIIIllII = ((byte)lllllllllllllIIllIIIIlIlIllllIII.getValue() & 0x2) == 0x2;
                lllllllllllllIIllIIIIlIlIllllIII.setTypeAndValue(MetaType1_9.Boolean, lllllllllllllIIllIIIIlIllIIIllII);
            }
        }
        if (lllllllllllllIIllIIIIlIlIlllllll.isOrHasParent(Entity1_11Types.EntityType.ABSTRACT_SKELETON)) {
            final int lllllllllllllIIllIIIIlIllIIIlIlI = lllllllllllllIIllIIIIlIlIllllIII.id();
            if (lllllllllllllIIllIIIIlIllIIIlIlI == 12) {
                lllllllllllllIIllIIIIlIlIlllIlll.remove(lllllllllllllIIllIIIIlIlIllllIII);
            }
            if (lllllllllllllIIllIIIIlIllIIIlIlI == 13) {
                lllllllllllllIIllIIIIlIlIllllIII.setId(12);
            }
        }
        if (lllllllllllllIIllIIIIlIlIlllllll.isOrHasParent(Entity1_11Types.EntityType.ZOMBIE)) {
            if (lllllllllllllIIllIIIIlIlIlllllll.is(Entity1_11Types.EntityType.ZOMBIE, Entity1_11Types.EntityType.HUSK) && lllllllllllllIIllIIIIlIlIllllIII.id() == 14) {
                lllllllllllllIIllIIIIlIlIlllIlll.remove(lllllllllllllIIllIIIIlIlIllllIII);
            }
            else if (lllllllllllllIIllIIIIlIlIllllIII.id() == 15) {
                lllllllllllllIIllIIIIlIlIllllIII.setId(14);
            }
            else if (lllllllllllllIIllIIIIlIlIllllIII.id() == 14) {
                lllllllllllllIIllIIIIlIlIllllIII.setId(15);
            }
        }
        if (lllllllllllllIIllIIIIlIlIlllllll.isOrHasParent(Entity1_11Types.EntityType.ABSTRACT_HORSE)) {
            final int lllllllllllllIIllIIIIlIllIIIlIIl = lllllllllllllIIllIIIIlIlIllllIII.id();
            if (lllllllllllllIIllIIIIlIllIIIlIIl == 14) {
                lllllllllllllIIllIIIIlIlIlllIlll.remove(lllllllllllllIIllIIIIlIlIllllIII);
            }
            if (lllllllllllllIIllIIIIlIllIIIlIIl == 16) {
                lllllllllllllIIllIIIIlIlIllllIII.setId(14);
            }
            if (lllllllllllllIIllIIIIlIllIIIlIIl == 17) {
                lllllllllllllIIllIIIIlIlIllllIII.setId(16);
            }
            if (!lllllllllllllIIllIIIIlIlIlllllll.is(Entity1_11Types.EntityType.HORSE)) {
                if (lllllllllllllIIllIIIIlIlIllllIII.id() == 15 || lllllllllllllIIllIIIIlIlIllllIII.id() == 16) {
                    lllllllllllllIIllIIIIlIlIlllIlll.remove(lllllllllllllIIllIIIIlIlIllllIII);
                }
            }
            if (lllllllllllllIIllIIIIlIlIlllllll.is(Entity1_11Types.EntityType.DONKEY, Entity1_11Types.EntityType.MULE) && lllllllllllllIIllIIIIlIlIllllIII.id() == 13) {
                if (((byte)lllllllllllllIIllIIIIlIlIllllIII.getValue() & 0x8) == 0x8) {
                    lllllllllllllIIllIIIIlIlIlllIlll.add(new Metadata(15, MetaType1_9.Boolean, true));
                }
                else {
                    lllllllllllllIIllIIIIlIlIlllIlll.add(new Metadata(15, MetaType1_9.Boolean, false));
                }
            }
        }
        if (lllllllllllllIIllIIIIlIlIlllllll.is(Entity1_11Types.EntityType.ARMOR_STAND) && Via.getConfig().isHologramPatch()) {
            final Metadata lllllllllllllIIllIIIIlIllIIIIlII = this.metaByIndex(11, lllllllllllllIIllIIIIlIlIlllIlll);
            final Metadata lllllllllllllIIllIIIIlIllIIIIIll = this.metaByIndex(2, lllllllllllllIIllIIIIlIlIlllIlll);
            final Metadata lllllllllllllIIllIIIIlIllIIIIIlI = this.metaByIndex(3, lllllllllllllIIllIIIIlIlIlllIlll);
            if (lllllllllllllIIllIIIIlIlIllllIII.id() == 0 && lllllllllllllIIllIIIIlIllIIIIlII != null && lllllllllllllIIllIIIIlIllIIIIIll != null && lllllllllllllIIllIIIIlIllIIIIIlI != null) {
                final byte lllllllllllllIIllIIIIlIllIIIIlIl = (byte)lllllllllllllIIllIIIIlIlIllllIII.getValue();
                if ((lllllllllllllIIllIIIIlIllIIIIlIl & 0x20) == 0x20 && ((byte)lllllllllllllIIllIIIIlIllIIIIlII.getValue() & 0x1) == 0x1 && !((String)lllllllllllllIIllIIIIlIllIIIIIll.getValue()).isEmpty() && (boolean)lllllllllllllIIllIIIIlIllIIIIIlI.getValue()) {
                    final EntityTracker1_11 lllllllllllllIIllIIIIlIllIIIIllI = this.tracker(lllllllllllllIIllIIIIlIlIlllIllI);
                    if (!lllllllllllllIIllIIIIlIllIIIIllI.isHologram(lllllllllllllIIllIIIIlIlIllllIlI)) {
                        lllllllllllllIIllIIIIlIllIIIIllI.addHologram(lllllllllllllIIllIIIIlIlIllllIlI);
                        try {
                            final PacketWrapper lllllllllllllIIllIIIIlIllIIIlIII = PacketWrapper.create(ClientboundPackets1_9_3.ENTITY_POSITION, null, lllllllllllllIIllIIIIlIlIlllIllI);
                            lllllllllllllIIllIIIIlIllIIIlIII.write(Type.VAR_INT, lllllllllllllIIllIIIIlIlIllllIlI);
                            lllllllllllllIIllIIIIlIllIIIlIII.write(Type.SHORT, (Short)0);
                            lllllllllllllIIllIIIIlIllIIIlIII.write(Type.SHORT, (short)(128.0 * (-Via.getConfig().getHologramYOffset() * 32.0)));
                            lllllllllllllIIllIIIIlIllIIIlIII.write(Type.SHORT, (Short)0);
                            lllllllllllllIIllIIIIlIllIIIlIII.write(Type.BOOLEAN, true);
                            lllllllllllllIIllIIIIlIllIIIlIII.send(Protocol1_11To1_10.class);
                        }
                        catch (Exception lllllllllllllIIllIIIIlIllIIIIlll) {
                            lllllllllllllIIllIIIIlIllIIIIlll.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    
    public static Entity1_11Types.EntityType rewriteEntityType(final int lllllllllllllIIllIIIIlIlIlIllIll, final List<Metadata> lllllllllllllIIllIIIIlIlIlIlIllI) {
        final Optional<Entity1_11Types.EntityType> lllllllllllllIIllIIIIlIlIlIllIIl = Entity1_11Types.EntityType.findById(lllllllllllllIIllIIIIlIlIlIllIll);
        if (!lllllllllllllIIllIIIIlIlIlIllIIl.isPresent()) {
            Via.getManager().getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Error: could not find Entity type ").append(lllllllllllllIIllIIIIlIlIlIllIll).append(" with metadata: ").append(lllllllllllllIIllIIIIlIlIlIlIllI)));
            return null;
        }
        final Entity1_11Types.EntityType lllllllllllllIIllIIIIlIlIlIllIII = lllllllllllllIIllIIIIlIlIlIllIIl.get();
        try {
            if (lllllllllllllIIllIIIIlIlIlIllIII.is(Entity1_11Types.EntityType.GUARDIAN)) {
                final Optional<Metadata> lllllllllllllIIllIIIIlIlIllIIIIl = getById(lllllllllllllIIllIIIIlIlIlIlIllI, 12);
                if (lllllllllllllIIllIIIIlIlIllIIIIl.isPresent() && ((byte)lllllllllllllIIllIIIIlIlIllIIIIl.get().getValue() & 0x4) == 0x4) {
                    return Entity1_11Types.EntityType.ELDER_GUARDIAN;
                }
            }
            if (lllllllllllllIIllIIIIlIlIlIllIII.is(Entity1_11Types.EntityType.SKELETON)) {
                final Optional<Metadata> lllllllllllllIIllIIIIlIlIllIIIII = getById(lllllllllllllIIllIIIIlIlIlIlIllI, 12);
                if (lllllllllllllIIllIIIIlIlIllIIIII.isPresent()) {
                    if ((int)lllllllllllllIIllIIIIlIlIllIIIII.get().getValue() == 1) {
                        return Entity1_11Types.EntityType.WITHER_SKELETON;
                    }
                    if ((int)lllllllllllllIIllIIIIlIlIllIIIII.get().getValue() == 2) {
                        return Entity1_11Types.EntityType.STRAY;
                    }
                }
            }
            if (lllllllllllllIIllIIIIlIlIlIllIII.is(Entity1_11Types.EntityType.ZOMBIE)) {
                final Optional<Metadata> lllllllllllllIIllIIIIlIlIlIllllI = getById(lllllllllllllIIllIIIIlIlIlIlIllI, 13);
                if (lllllllllllllIIllIIIIlIlIlIllllI.isPresent()) {
                    final int lllllllllllllIIllIIIIlIlIlIlllll = (int)lllllllllllllIIllIIIIlIlIlIllllI.get().getValue();
                    if (lllllllllllllIIllIIIIlIlIlIlllll > 0 && lllllllllllllIIllIIIIlIlIlIlllll < 6) {
                        lllllllllllllIIllIIIIlIlIlIlIllI.add(new Metadata(16, MetaType1_9.VarInt, lllllllllllllIIllIIIIlIlIlIlllll - 1));
                        return Entity1_11Types.EntityType.ZOMBIE_VILLAGER;
                    }
                    if (lllllllllllllIIllIIIIlIlIlIlllll == 6) {
                        return Entity1_11Types.EntityType.HUSK;
                    }
                }
            }
            if (lllllllllllllIIllIIIIlIlIlIllIII.is(Entity1_11Types.EntityType.HORSE)) {
                final Optional<Metadata> lllllllllllllIIllIIIIlIlIlIlllIl = getById(lllllllllllllIIllIIIIlIlIlIlIllI, 14);
                if (lllllllllllllIIllIIIIlIlIlIlllIl.isPresent()) {
                    if ((int)lllllllllllllIIllIIIIlIlIlIlllIl.get().getValue() == 0) {
                        return Entity1_11Types.EntityType.HORSE;
                    }
                    if ((int)lllllllllllllIIllIIIIlIlIlIlllIl.get().getValue() == 1) {
                        return Entity1_11Types.EntityType.DONKEY;
                    }
                    if ((int)lllllllllllllIIllIIIIlIlIlIlllIl.get().getValue() == 2) {
                        return Entity1_11Types.EntityType.MULE;
                    }
                    if ((int)lllllllllllllIIllIIIIlIlIlIlllIl.get().getValue() == 3) {
                        return Entity1_11Types.EntityType.ZOMBIE_HORSE;
                    }
                    if ((int)lllllllllllllIIllIIIIlIlIlIlllIl.get().getValue() == 4) {
                        return Entity1_11Types.EntityType.SKELETON_HORSE;
                    }
                }
            }
        }
        catch (Exception lllllllllllllIIllIIIIlIlIlIlllII) {
            if (!Via.getConfig().isSuppressMetadataErrors() || Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning("An error occurred with entity type rewriter");
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Metadata: ").append(lllllllllllllIIllIIIIlIlIlIlIllI)));
                lllllllllllllIIllIIIIlIlIlIlllII.printStackTrace();
            }
        }
        return lllllllllllllIIllIIIIlIlIlIllIII;
    }
}
