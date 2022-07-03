package de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata;

import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.*;
import com.viaversion.viaversion.api.minecraft.*;
import de.gerrygames.viarewind.*;

public class MetadataRewriter
{
    public static void transform(final Entity1_10Types.EntityType lllllllllllllIlllIlllIIIlllIllll, final List<Metadata> lllllllllllllIlllIlllIIIlllIlllI) {
        for (final Metadata lllllllllllllIlllIlllIIIllllIIlI : new ArrayList(lllllllllllllIlllIlllIIIlllIlllI)) {
            final MetaIndex lllllllllllllIlllIlllIIIllllIIll = MetaIndex1_8to1_9.searchIndex(lllllllllllllIlllIlllIIIlllIllll, lllllllllllllIlllIlllIIIllllIIlI.id());
            try {
                if (lllllllllllllIlllIlllIIIllllIIll == null) {
                    throw new Exception("Could not find valid metadata");
                }
                if (lllllllllllllIlllIlllIIIllllIIll.getOldType() == MetaType1_8.NonExistent || lllllllllllllIlllIlllIIIllllIIll.getNewType() == null) {
                    lllllllllllllIlllIlllIIIlllIlllI.remove(lllllllllllllIlllIlllIIIllllIIlI);
                }
                else {
                    final Object lllllllllllllIlllIlllIIIllllIlIl = lllllllllllllIlllIlllIIIllllIIlI.getValue();
                    lllllllllllllIlllIlllIIIllllIIlI.setMetaTypeUnsafe(lllllllllllllIlllIlllIIIllllIIll.getOldType());
                    lllllllllllllIlllIlllIIIllllIIlI.setId(lllllllllllllIlllIlllIIIllllIIll.getIndex());
                    switch (lllllllllllllIlllIlllIIIllllIIll.getNewType()) {
                        case Byte: {
                            if (lllllllllllllIlllIlllIIIllllIIll.getOldType() == MetaType1_8.Byte) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIlIl);
                            }
                            if (lllllllllllllIlllIlllIIIllllIIll.getOldType() == MetaType1_8.Int) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue((int)lllllllllllllIlllIlllIIIllllIlIl);
                                break;
                            }
                            break;
                        }
                        case OptUUID: {
                            if (lllllllllllllIlllIlllIIIllllIIll.getOldType() != MetaType1_8.String) {
                                lllllllllllllIlllIlllIIIlllIlllI.remove(lllllllllllllIlllIlllIIIllllIIlI);
                                break;
                            }
                            final UUID lllllllllllllIlllIlllIIIlllllIII = (UUID)lllllllllllllIlllIlllIIIllllIlIl;
                            if (lllllllllllllIlllIlllIIIlllllIII == null) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue("");
                                break;
                            }
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIlllllIII.toString());
                            break;
                        }
                        case BlockID: {
                            lllllllllllllIlllIlllIIIlllIlllI.remove(lllllllllllllIlllIlllIIIllllIIlI);
                            lllllllllllllIlllIlllIIIlllIlllI.add(new Metadata(lllllllllllllIlllIlllIIIllllIIll.getIndex(), MetaType1_8.Short, ((Integer)lllllllllllllIlllIlllIIIllllIlIl).shortValue()));
                            break;
                        }
                        case VarInt: {
                            if (lllllllllllllIlllIlllIIIllllIIll.getOldType() == MetaType1_8.Byte) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue(((Integer)lllllllllllllIlllIlllIIIllllIlIl).byteValue());
                            }
                            if (lllllllllllllIlllIlllIIIllllIIll.getOldType() == MetaType1_8.Short) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue(((Integer)lllllllllllllIlllIlllIIIllllIlIl).shortValue());
                            }
                            if (lllllllllllllIlllIlllIIIllllIIll.getOldType() == MetaType1_8.Int) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIlIl);
                                break;
                            }
                            break;
                        }
                        case Float: {
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIlIl);
                            break;
                        }
                        case String: {
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIlIl);
                            break;
                        }
                        case Boolean: {
                            if (lllllllllllllIlllIlllIIIllllIIll == MetaIndex.AGEABLE_AGE) {
                                lllllllllllllIlllIlllIIIllllIIlI.setValue((byte)(lllllllllllllIlllIlllIIIllllIlIl ? -1 : 0));
                                break;
                            }
                            lllllllllllllIlllIlllIIIllllIIlI.setValue((byte)(byte)(((boolean)lllllllllllllIlllIlllIIIllllIlIl) ? 1 : 0));
                            break;
                        }
                        case Slot: {
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(ItemRewriter.toClient((Item)lllllllllllllIlllIlllIIIllllIlIl));
                            break;
                        }
                        case Position: {
                            final Vector lllllllllllllIlllIlllIIIllllIlll = (Vector)lllllllllllllIlllIlllIIIllllIlIl;
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIlll);
                            break;
                        }
                        case Vector3F: {
                            final EulerAngle lllllllllllllIlllIlllIIIllllIllI = (EulerAngle)lllllllllllllIlllIlllIIIllllIlIl;
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIllI);
                            break;
                        }
                        case Chat: {
                            lllllllllllllIlllIlllIIIllllIIlI.setValue(lllllllllllllIlllIlllIIIllllIlIl);
                            break;
                        }
                        default: {
                            ViaRewind.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("[Out] Unhandled MetaDataType: ").append(lllllllllllllIlllIlllIIIllllIIll.getNewType())));
                            lllllllllllllIlllIlllIIIlllIlllI.remove(lllllllllllllIlllIlllIIIllllIIlI);
                            break;
                        }
                    }
                    if (lllllllllllllIlllIlllIIIllllIIll.getOldType().type().getOutputClass().isAssignableFrom(lllllllllllllIlllIlllIIIllllIIlI.getValue().getClass())) {
                        continue;
                    }
                    lllllllllllllIlllIlllIIIlllIlllI.remove(lllllllllllllIlllIlllIIIllllIIlI);
                }
            }
            catch (Exception lllllllllllllIlllIlllIIIllllIlII) {
                lllllllllllllIlllIlllIIIlllIlllI.remove(lllllllllllllIlllIlllIIIllllIIlI);
            }
        }
    }
}
