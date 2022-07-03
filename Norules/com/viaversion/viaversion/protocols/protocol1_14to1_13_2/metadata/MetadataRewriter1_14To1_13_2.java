package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.metadata;

import com.viaversion.viaversion.rewriter.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.storage.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.minecraft.entities.*;

public class MetadataRewriter1_14To1_13_2 extends EntityRewriter<Protocol1_14To1_13_2>
{
    @Override
    protected void handleMetadata(final int lllllllllllllIIIlIIlIllllIIllIIl, final EntityType lllllllllllllIIIlIIlIllllIIllIII, final Metadata lllllllllllllIIIlIIlIllllIIlIIII, final List<Metadata> lllllllllllllIIIlIIlIllllIIlIllI, final UserConnection lllllllllllllIIIlIIlIllllIIlIlIl) throws Exception {
        lllllllllllllIIIlIIlIllllIIlIIII.setMetaType(MetaType1_14.byId(lllllllllllllIIIlIIlIllllIIlIIII.metaType().typeId()));
        final EntityTracker1_14 lllllllllllllIIIlIIlIllllIIlIlII = this.tracker(lllllllllllllIIIlIIlIllllIIlIlIl);
        if (lllllllllllllIIIlIIlIllllIIlIIII.metaType() == MetaType1_14.Slot) {
            ((Protocol1_14To1_13_2)this.protocol).getItemRewriter().handleItemToClient((Item)lllllllllllllIIIlIIlIllllIIlIIII.getValue());
        }
        else if (lllllllllllllIIIlIIlIllllIIlIIII.metaType() == MetaType1_14.BlockID) {
            final int lllllllllllllIIIlIIlIllllIlIIIIl = (int)lllllllllllllIIIlIIlIllllIIlIIII.getValue();
            lllllllllllllIIIlIIlIllllIIlIIII.setValue(((Protocol1_14To1_13_2)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIlIIlIllllIlIIIIl));
        }
        else if (lllllllllllllIIIlIIlIllllIIlIIII.metaType() == MetaType1_14.PARTICLE) {
            this.rewriteParticle((Particle)lllllllllllllIIIlIIlIllllIIlIIII.getValue());
        }
        if (lllllllllllllIIIlIIlIllllIIllIII == null) {
            return;
        }
        if (lllllllllllllIIIlIIlIllllIIlIIII.id() > 5) {
            lllllllllllllIIIlIIlIllllIIlIIII.setId(lllllllllllllIIIlIIlIllllIIlIIII.id() + 1);
        }
        if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 8 && lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.LIVINGENTITY)) {
            final float lllllllllllllIIIlIIlIllllIlIIIII = ((Number)lllllllllllllIIIlIIlIllllIIlIIII.getValue()).floatValue();
            if (Float.isNaN(lllllllllllllIIIlIIlIllllIlIIIII) && Via.getConfig().is1_14HealthNaNFix()) {
                lllllllllllllIIIlIIlIllllIIlIIII.setValue(1.0f);
            }
        }
        if (lllllllllllllIIIlIIlIllllIIlIIII.id() > 11 && lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.LIVINGENTITY)) {
            lllllllllllllIIIlIIlIllllIIlIIII.setId(lllllllllllllIIIlIIlIllllIIlIIII.id() + 1);
        }
        if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.ABSTRACT_INSENTIENT) && lllllllllllllIIIlIIlIllllIIlIIII.id() == 13) {
            lllllllllllllIIIlIIlIllllIIlIlII.setInsentientData(lllllllllllllIIIlIIlIllllIIllIIl, (byte)((((Number)lllllllllllllIIIlIIlIllllIIlIIII.getValue()).byteValue() & 0xFFFFFFFB) | (lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl) & 0x4)));
            lllllllllllllIIIlIIlIllllIIlIIII.setValue(lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl));
        }
        if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.PLAYER)) {
            if (lllllllllllllIIIlIIlIllllIIllIIl != lllllllllllllIIIlIIlIllllIIlIlII.clientEntityId()) {
                if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 0) {
                    final byte lllllllllllllIIIlIIlIllllIIlllll = ((Number)lllllllllllllIIIlIIlIllllIIlIIII.getValue()).byteValue();
                    lllllllllllllIIIlIIlIllllIIlIlII.setEntityFlags(lllllllllllllIIIlIIlIllllIIllIIl, lllllllllllllIIIlIIlIllllIIlllll);
                }
                else if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 7) {
                    lllllllllllllIIIlIIlIllllIIlIlII.setRiptide(lllllllllllllIIIlIIlIllllIIllIIl, (((Number)lllllllllllllIIIlIIlIllllIIlIIII.getValue()).byteValue() & 0x4) != 0x0);
                }
                if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 0 || lllllllllllllIIIlIIlIllllIIlIIII.id() == 7) {
                    lllllllllllllIIIlIIlIllllIIlIllI.add(new Metadata(6, MetaType1_14.Pose, recalculatePlayerPose(lllllllllllllIIIlIIlIllllIIllIIl, lllllllllllllIIIlIIlIllllIIlIlII)));
                }
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.ZOMBIE)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 16) {
                lllllllllllllIIIlIIlIllllIIlIlII.setInsentientData(lllllllllllllIIIlIIlIllllIIllIIl, (byte)((lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl) & 0xFFFFFFFB) | (lllllllllllllIIIlIIlIllllIIlIIII.getValue() ? 4 : 0)));
                lllllllllllllIIIlIIlIllllIIlIllI.remove(lllllllllllllIIIlIIlIllllIIlIIII);
                lllllllllllllIIIlIIlIllllIIlIllI.add(new Metadata(13, MetaType1_14.Byte, lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl)));
            }
            else if (lllllllllllllIIIlIIlIllllIIlIIII.id() > 16) {
                lllllllllllllIIIlIIlIllllIIlIIII.setId(lllllllllllllIIIlIIlIllllIIlIIII.id() - 1);
            }
        }
        if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.MINECART_ABSTRACT)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 10) {
                final int lllllllllllllIIIlIIlIllllIIllllI = (int)lllllllllllllIIIlIIlIllllIIlIIII.getValue();
                lllllllllllllIIIlIIlIllllIIlIIII.setValue(((Protocol1_14To1_13_2)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIlIIlIllllIIllllI));
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.is(Entity1_14Types.HORSE)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 18) {
                lllllllllllllIIIlIIlIllllIIlIllI.remove(lllllllllllllIIIlIIlIllllIIlIIII);
                final int lllllllllllllIIIlIIlIllllIIlllIl = (int)lllllllllllllIIIlIIlIllllIIlIIII.getValue();
                Item lllllllllllllIIIlIIlIllllIIlllII = null;
                if (lllllllllllllIIIlIIlIllllIIlllIl == 1) {
                    lllllllllllllIIIlIIlIllllIIlllII = new DataItem(((Protocol1_14To1_13_2)this.protocol).getMappingData().getNewItemId(727), (byte)1, (short)0, null);
                }
                else if (lllllllllllllIIIlIIlIllllIIlllIl == 2) {
                    lllllllllllllIIIlIIlIllllIIlllII = new DataItem(((Protocol1_14To1_13_2)this.protocol).getMappingData().getNewItemId(728), (byte)1, (short)0, null);
                }
                else if (lllllllllllllIIIlIIlIllllIIlllIl == 3) {
                    lllllllllllllIIIlIIlIllllIIlllII = new DataItem(((Protocol1_14To1_13_2)this.protocol).getMappingData().getNewItemId(729), (byte)1, (short)0, null);
                }
                final PacketWrapper lllllllllllllIIIlIIlIllllIIllIll = PacketWrapper.create(ClientboundPackets1_14.ENTITY_EQUIPMENT, null, lllllllllllllIIIlIIlIllllIIlIlIl);
                lllllllllllllIIIlIIlIllllIIllIll.write(Type.VAR_INT, lllllllllllllIIIlIIlIllllIIllIIl);
                lllllllllllllIIIlIIlIllllIIllIll.write(Type.VAR_INT, 4);
                lllllllllllllIIIlIIlIllllIIllIll.write(Type.FLAT_VAR_INT_ITEM, lllllllllllllIIIlIIlIllllIIlllII);
                lllllllllllllIIIlIIlIllllIIllIll.scheduleSend(Protocol1_14To1_13_2.class);
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.is(Entity1_14Types.VILLAGER)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 15) {
                lllllllllllllIIIlIIlIllllIIlIIII.setTypeAndValue(MetaType1_14.VillagerData, new VillagerData(2, getNewProfessionId((int)lllllllllllllIIIlIIlIllllIIlIIII.getValue()), 0));
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.is(Entity1_14Types.ZOMBIE_VILLAGER)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 18) {
                lllllllllllllIIIlIIlIllllIIlIIII.setTypeAndValue(MetaType1_14.VillagerData, new VillagerData(2, getNewProfessionId((int)lllllllllllllIIIlIIlIllllIIlIIII.getValue()), 0));
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.ABSTRACT_ARROW)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() >= 9) {
                lllllllllllllIIIlIIlIllllIIlIIII.setId(lllllllllllllIIIlIIlIllllIIlIIII.id() + 1);
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.is(Entity1_14Types.FIREWORK_ROCKET)) {
            if (lllllllllllllIIIlIIlIllllIIlIIII.id() == 8) {
                lllllllllllllIIIlIIlIllllIIlIIII.setMetaType(MetaType1_14.OptVarInt);
                if (lllllllllllllIIIlIIlIllllIIlIIII.getValue().equals(0)) {
                    lllllllllllllIIIlIIlIllllIIlIIII.setValue(null);
                }
            }
        }
        else if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.ABSTRACT_SKELETON) && lllllllllllllIIIlIIlIllllIIlIIII.id() == 14) {
            lllllllllllllIIIlIIlIllllIIlIlII.setInsentientData(lllllllllllllIIIlIIlIllllIIllIIl, (byte)((lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl) & 0xFFFFFFFB) | (lllllllllllllIIIlIIlIllllIIlIIII.getValue() ? 4 : 0)));
            lllllllllllllIIIlIIlIllllIIlIllI.remove(lllllllllllllIIIlIIlIllllIIlIIII);
            lllllllllllllIIIlIIlIllllIIlIllI.add(new Metadata(13, MetaType1_14.Byte, lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl)));
        }
        if (lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.ABSTRACT_ILLAGER_BASE) && lllllllllllllIIIlIIlIllllIIlIIII.id() == 14) {
            lllllllllllllIIIlIIlIllllIIlIlII.setInsentientData(lllllllllllllIIIlIIlIllllIIllIIl, (byte)((lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl) & 0xFFFFFFFB) | ((((Number)lllllllllllllIIIlIIlIllllIIlIIII.getValue()).byteValue() != 0) ? 4 : 0)));
            lllllllllllllIIIlIIlIllllIIlIllI.remove(lllllllllllllIIIlIIlIllllIIlIIII);
            lllllllllllllIIIlIIlIllllIIlIllI.add(new Metadata(13, MetaType1_14.Byte, lllllllllllllIIIlIIlIllllIIlIlII.getInsentientData(lllllllllllllIIIlIIlIllllIIllIIl)));
        }
        if ((lllllllllllllIIIlIIlIllllIIllIII.is(Entity1_14Types.WITCH) || lllllllllllllIIIlIIlIllllIIllIII.is(Entity1_14Types.RAVAGER) || lllllllllllllIIIlIIlIllllIIllIII.isOrHasParent(Entity1_14Types.ABSTRACT_ILLAGER_BASE)) && lllllllllllllIIIlIIlIllllIIlIIII.id() >= 14) {
            lllllllllllllIIIlIIlIllllIIlIIII.setId(lllllllllllllIIIlIIlIllllIIlIIII.id() + 1);
        }
    }
    
    public MetadataRewriter1_14To1_13_2(final Protocol1_14To1_13_2 lllllllllllllIIIlIIlIllllIlIlllI) {
        super(lllllllllllllIIIlIIlIllllIlIlllI);
        this.mapTypes(Entity1_13Types.EntityType.values(), Entity1_14Types.class);
        this.mapEntityType(Entity1_13Types.EntityType.OCELOT, Entity1_14Types.CAT);
    }
    
    private static boolean isFallFlying(final int lllllllllllllIIIlIIlIlllIllllIlI) {
        return (lllllllllllllIIIlIIlIlllIllllIlI & 0x80) != 0x0;
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIIIlIIlIllllIIIIllI) {
        return Entity1_14Types.getTypeFromId(lllllllllllllIIIlIIlIllllIIIIllI);
    }
    
    private static boolean isSneaking(final byte lllllllllllllIIIlIIlIllllIIIIIll) {
        return (lllllllllllllIIIlIIlIllllIIIIIll & 0x2) != 0x0;
    }
    
    private static boolean isSwimming(final byte lllllllllllllIIIlIIlIllllIIIIIIl) {
        return (lllllllllllllIIIlIIlIllllIIIIIIl & 0x10) != 0x0;
    }
    
    private static int getNewProfessionId(final int lllllllllllllIIIlIIlIlllIlllllIl) {
        switch (lllllllllllllIIIlIIlIlllIlllllIl) {
            case 0: {
                return 5;
            }
            case 1: {
                return 9;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 11;
            }
            default: {
                return 0;
            }
        }
    }
    
    public static int recalculatePlayerPose(final int lllllllllllllIIIlIIlIlllIlllIlIl, final EntityTracker1_14 lllllllllllllIIIlIIlIlllIlllIlII) {
        final byte lllllllllllllIIIlIIlIlllIlllIIll = lllllllllllllIIIlIIlIlllIlllIlII.getEntityFlags(lllllllllllllIIIlIIlIlllIlllIlIl);
        int lllllllllllllIIIlIIlIlllIlllIIlI = 0;
        if (isFallFlying(lllllllllllllIIIlIIlIlllIlllIIll)) {
            lllllllllllllIIIlIIlIlllIlllIIlI = 1;
        }
        else if (lllllllllllllIIIlIIlIlllIlllIlII.isSleeping(lllllllllllllIIIlIIlIlllIlllIlIl)) {
            lllllllllllllIIIlIIlIlllIlllIIlI = 2;
        }
        else if (isSwimming(lllllllllllllIIIlIIlIlllIlllIIll)) {
            lllllllllllllIIIlIIlIlllIlllIIlI = 3;
        }
        else if (lllllllllllllIIIlIIlIlllIlllIlII.isRiptide(lllllllllllllIIIlIIlIlllIlllIlIl)) {
            lllllllllllllIIIlIIlIlllIlllIIlI = 4;
        }
        else if (isSneaking(lllllllllllllIIIlIIlIlllIlllIIll)) {
            lllllllllllllIIIlIIlIlllIlllIIlI = 5;
        }
        return lllllllllllllIIIlIIlIlllIlllIIlI;
    }
}
