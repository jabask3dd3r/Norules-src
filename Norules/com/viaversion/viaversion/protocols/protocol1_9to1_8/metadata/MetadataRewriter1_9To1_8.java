package com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.minecraft.*;

public class MetadataRewriter1_9To1_8 extends EntityRewriter<Protocol1_9To1_8>
{
    public MetadataRewriter1_9To1_8(final Protocol1_9To1_8 llllllllllllllIlllIIlllIIIlIllII) {
        super(llllllllllllllIlllIIlllIIIlIllII);
    }
    
    @Override
    public EntityType objectTypeFromId(final int llllllllllllllIlllIIlllIIIIIIIll) {
        return Entity1_10Types.getTypeFromId(llllllllllllllIlllIIlllIIIIIIIll, true);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIlllIIlllIIIIIIlll) {
        return Entity1_10Types.getTypeFromId(llllllllllllllIlllIIlllIIIIIIlll, false);
    }
    
    @Override
    protected void handleMetadata(final int llllllllllllllIlllIIlllIIIIllIlI, final EntityType llllllllllllllIlllIIlllIIIIllIIl, final Metadata llllllllllllllIlllIIlllIIIIllIII, final List<Metadata> llllllllllllllIlllIIlllIIIIlIlll, final UserConnection llllllllllllllIlllIIlllIIIIlIllI) throws Exception {
        final MetaIndex llllllllllllllIlllIIlllIIIIlIlIl = MetaIndex.searchIndex(llllllllllllllIlllIIlllIIIIllIIl, llllllllllllllIlllIIlllIIIIllIII.id());
        if (llllllllllllllIlllIIlllIIIIlIlIl == null) {
            throw new Exception("Could not find valid metadata");
        }
        if (llllllllllllllIlllIIlllIIIIlIlIl.getNewType() == null) {
            llllllllllllllIlllIIlllIIIIlIlll.remove(llllllllllllllIlllIIlllIIIIllIII);
            return;
        }
        llllllllllllllIlllIIlllIIIIllIII.setId(llllllllllllllIlllIIlllIIIIlIlIl.getNewIndex());
        llllllllllllllIlllIIlllIIIIllIII.setMetaTypeUnsafe(llllllllllllllIlllIIlllIIIIlIlIl.getNewType());
        Object llllllllllllllIlllIIlllIIIIlIlII = llllllllllllllIlllIIlllIIIIllIII.getValue();
        switch (llllllllllllllIlllIIlllIIIIlIlIl.getNewType()) {
            case Byte: {
                if (llllllllllllllIlllIIlllIIIIlIlIl.getOldType() == MetaType1_8.Byte) {
                    llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlIlII);
                }
                if (llllllllllllllIlllIIlllIIIIlIlIl.getOldType() == MetaType1_8.Int) {
                    llllllllllllllIlllIIlllIIIIllIII.setValue(((Integer)llllllllllllllIlllIIlllIIIIlIlII).byteValue());
                }
                if (llllllllllllllIlllIIlllIIIIlIlIl == MetaIndex.ENTITY_STATUS && llllllllllllllIlllIIlllIIIIllIIl == Entity1_10Types.EntityType.PLAYER) {
                    Byte llllllllllllllIlllIIlllIIIlIIIlI = 0;
                    if (((byte)llllllllllllllIlllIIlllIIIIlIlII & 0x10) == 0x10) {
                        llllllllllllllIlllIIlllIIIlIIIlI = 1;
                    }
                    final int llllllllllllllIlllIIlllIIIlIIIIl = MetaIndex.PLAYER_HAND.getNewIndex();
                    final MetaType llllllllllllllIlllIIlllIIIlIIIII = MetaIndex.PLAYER_HAND.getNewType();
                    llllllllllllllIlllIIlllIIIIlIlll.add(new Metadata(llllllllllllllIlllIIlllIIIlIIIIl, llllllllllllllIlllIIlllIIIlIIIII, llllllllllllllIlllIIlllIIIlIIIlI));
                    break;
                }
                break;
            }
            case OptUUID: {
                final String llllllllllllllIlllIIlllIIIIlllll = (String)llllllllllllllIlllIIlllIIIIlIlII;
                UUID llllllllllllllIlllIIlllIIIIllllI = null;
                if (!llllllllllllllIlllIIlllIIIIlllll.isEmpty()) {
                    try {
                        llllllllllllllIlllIIlllIIIIllllI = UUID.fromString(llllllllllllllIlllIIlllIIIIlllll);
                    }
                    catch (Exception ex) {}
                }
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIllllI);
                break;
            }
            case VarInt: {
                if (llllllllllllllIlllIIlllIIIIlIlIl.getOldType() == MetaType1_8.Byte) {
                    llllllllllllllIlllIIlllIIIIllIII.setValue((int)llllllllllllllIlllIIlllIIIIlIlII);
                }
                if (llllllllllllllIlllIIlllIIIIlIlIl.getOldType() == MetaType1_8.Short) {
                    llllllllllllllIlllIIlllIIIIllIII.setValue((int)llllllllllllllIlllIIlllIIIIlIlII);
                }
                if (llllllllllllllIlllIIlllIIIIlIlIl.getOldType() == MetaType1_8.Int) {
                    llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlIlII);
                    break;
                }
                break;
            }
            case Float: {
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlIlII);
                break;
            }
            case String: {
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlIlII);
                break;
            }
            case Boolean: {
                if (llllllllllllllIlllIIlllIIIIlIlIl == MetaIndex.AGEABLE_AGE) {
                    llllllllllllllIlllIIlllIIIIllIII.setValue((byte)llllllllllllllIlllIIlllIIIIlIlII < 0);
                    break;
                }
                llllllllllllllIlllIIlllIIIIllIII.setValue((byte)llllllllllllllIlllIIlllIIIIlIlII != 0);
                break;
            }
            case Slot: {
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlIlII);
                ItemRewriter.toClient((Item)llllllllllllllIlllIIlllIIIIllIII.getValue());
                break;
            }
            case Position: {
                final Vector llllllllllllllIlllIIlllIIIIlllIl = (Vector)llllllllllllllIlllIIlllIIIIlIlII;
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlllIl);
                break;
            }
            case Vector3F: {
                final EulerAngle llllllllllllllIlllIIlllIIIIlllII = (EulerAngle)llllllllllllllIlllIIlllIIIIlIlII;
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlllII);
                break;
            }
            case Chat: {
                llllllllllllllIlllIIlllIIIIlIlII = Protocol1_9To1_8.fixJson(llllllllllllllIlllIIlllIIIIlIlII.toString());
                llllllllllllllIlllIIlllIIIIllIII.setValue(llllllllllllllIlllIIlllIIIIlIlII);
                break;
            }
            case BlockID: {
                llllllllllllllIlllIIlllIIIIllIII.setValue(((Number)llllllllllllllIlllIIlllIIIIlIlII).intValue());
                break;
            }
            default: {
                llllllllllllllIlllIIlllIIIIlIlll.remove(llllllllllllllIlllIIlllIIIIllIII);
                throw new Exception(String.valueOf(new StringBuilder().append("Unhandled MetaDataType: ").append(llllllllllllllIlllIIlllIIIIlIlIl.getNewType())));
            }
        }
    }
}
