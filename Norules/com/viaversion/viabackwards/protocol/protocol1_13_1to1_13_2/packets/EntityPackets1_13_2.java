package com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.packets;

import com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_13_2
{
    public static void register(final Protocol1_13_1To1_13_2 lllllllllllllIllllIIllllIlIllIlI) {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIllllIIllllIlIllIlI).registerClientbound(ClientboundPackets1_13.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_13_2.METADATA_LIST, Types1_13.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIlllllllIlllIII) throws Exception {
                        for (final Metadata lllllllllllllIIIIIlllllllIlllIlI : lllllllllllllIIIIIlllllllIlllIII.get(Types1_13.METADATA_LIST, 0)) {
                            if (lllllllllllllIIIIIlllllllIlllIlI.metaType() == MetaType1_13_2.Slot) {
                                lllllllllllllIIIIIlllllllIlllIlI.setMetaType(MetaType1_13.Slot);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIllllIIllllIlIllIlI).registerClientbound(ClientboundPackets1_13.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_13_2.METADATA_LIST, Types1_13.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIlIIIllllIlIlII) throws Exception {
                        for (final Metadata lllllllllllllIIIlIlIIIllllIlIllI : lllllllllllllIIIlIlIIIllllIlIlII.get(Types1_13.METADATA_LIST, 0)) {
                            if (lllllllllllllIIIlIlIIIllllIlIllI.metaType() == MetaType1_13_2.Slot) {
                                lllllllllllllIIIlIlIIIllllIlIllI.setMetaType(MetaType1_13.Slot);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIllllIIllllIlIllIlI).registerClientbound(ClientboundPackets1_13.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Types1_13_2.METADATA_LIST, Types1_13.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIlllIlIlIIIIIIIl) throws Exception {
                        for (final Metadata lllllllllllllIIlIlllIlIlIIIIIIll : lllllllllllllIIlIlllIlIlIIIIIIIl.get(Types1_13.METADATA_LIST, 0)) {
                            if (lllllllllllllIIlIlllIlIlIIIIIIll.metaType() == MetaType1_13_2.Slot) {
                                lllllllllllllIIlIlllIlIlIIIIIIll.setMetaType(MetaType1_13.Slot);
                            }
                        }
                    }
                });
            }
        });
    }
}
