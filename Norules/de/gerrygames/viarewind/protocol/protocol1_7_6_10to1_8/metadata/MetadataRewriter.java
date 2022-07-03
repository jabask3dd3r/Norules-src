package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.metadata;

import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_7_6_10.metadata.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import de.gerrygames.viarewind.*;

public class MetadataRewriter
{
    public static void transform(final Entity1_10Types.EntityType lIlllIIIlIIlll, final List<Metadata> lIlllIIIlIIlII) {
        for (final Metadata lIlllIIIlIlIII : new ArrayList(lIlllIIIlIIlII)) {
            final MetaIndex1_8to1_7_6_10 lIlllIIIlIlIIl = MetaIndex1_7_6_10to1_8.searchIndex(lIlllIIIlIIlll, lIlllIIIlIlIII.id());
            try {
                if (lIlllIIIlIlIIl == null) {
                    throw new Exception("Could not find valid metadata");
                }
                if (lIlllIIIlIlIIl.getOldType() == MetaType1_7_6_10.NonExistent) {
                    lIlllIIIlIIlII.remove(lIlllIIIlIlIII);
                }
                else {
                    Object lIlllIIIlIlIll = lIlllIIIlIlIII.getValue();
                    if (!lIlllIIIlIlIll.getClass().isAssignableFrom(lIlllIIIlIlIIl.getNewType().type().getOutputClass())) {
                        lIlllIIIlIIlII.remove(lIlllIIIlIlIII);
                    }
                    else {
                        lIlllIIIlIlIII.setMetaTypeUnsafe(lIlllIIIlIlIIl.getOldType());
                        lIlllIIIlIlIII.setId(lIlllIIIlIlIIl.getIndex());
                        switch (lIlllIIIlIlIIl.getOldType()) {
                            case Int: {
                                if (lIlllIIIlIlIIl.getNewType() == MetaType1_8.Byte) {
                                    lIlllIIIlIlIII.setValue((int)lIlllIIIlIlIll);
                                    if (lIlllIIIlIlIIl == MetaIndex1_8to1_7_6_10.ENTITY_AGEABLE_AGE && (int)lIlllIIIlIlIII.getValue() < 0) {
                                        lIlllIIIlIlIII.setValue(-25000);
                                    }
                                }
                                if (lIlllIIIlIlIIl.getNewType() == MetaType1_8.Short) {
                                    lIlllIIIlIlIII.setValue((int)lIlllIIIlIlIll);
                                }
                                if (lIlllIIIlIlIIl.getNewType() == MetaType1_8.Int) {
                                    lIlllIIIlIlIII.setValue(lIlllIIIlIlIll);
                                    continue;
                                }
                                continue;
                            }
                            case Byte: {
                                if (lIlllIIIlIlIIl.getNewType() == MetaType1_8.Int) {
                                    lIlllIIIlIlIII.setValue(((Integer)lIlllIIIlIlIll).byteValue());
                                }
                                if (lIlllIIIlIlIIl.getNewType() == MetaType1_8.Byte) {
                                    if (lIlllIIIlIlIIl == MetaIndex1_8to1_7_6_10.ITEM_FRAME_ROTATION) {
                                        lIlllIIIlIlIll = ((byte)lIlllIIIlIlIll / 2).byteValue();
                                    }
                                    lIlllIIIlIlIII.setValue(lIlllIIIlIlIll);
                                }
                                if (lIlllIIIlIlIIl == MetaIndex1_8to1_7_6_10.HUMAN_SKIN_FLAGS) {
                                    byte lIlllIIIlIllIl = (byte)lIlllIIIlIlIll;
                                    final boolean lIlllIIIlIllII = (lIlllIIIlIllIl & 0x1) != 0x0;
                                    lIlllIIIlIllIl = (byte)(lIlllIIIlIllII ? 0 : 2);
                                    lIlllIIIlIlIII.setValue(lIlllIIIlIllIl);
                                    continue;
                                }
                                continue;
                            }
                            case Slot: {
                                lIlllIIIlIlIII.setValue(ItemRewriter.toClient((Item)lIlllIIIlIlIll));
                                continue;
                            }
                            case Float: {
                                lIlllIIIlIlIII.setValue(lIlllIIIlIlIll);
                                continue;
                            }
                            case Short: {
                                lIlllIIIlIlIII.setValue(lIlllIIIlIlIll);
                                continue;
                            }
                            case String: {
                                lIlllIIIlIlIII.setValue(lIlllIIIlIlIll);
                                continue;
                            }
                            case Position: {
                                lIlllIIIlIlIII.setValue(lIlllIIIlIlIll);
                                continue;
                            }
                            default: {
                                ViaRewind.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("[Out] Unhandled MetaDataType: ").append(lIlllIIIlIlIIl.getNewType())));
                                lIlllIIIlIIlII.remove(lIlllIIIlIlIII);
                                continue;
                            }
                        }
                    }
                }
            }
            catch (Exception lIlllIIIlIlIlI) {
                lIlllIIIlIIlII.remove(lIlllIIIlIlIII);
            }
        }
    }
}
