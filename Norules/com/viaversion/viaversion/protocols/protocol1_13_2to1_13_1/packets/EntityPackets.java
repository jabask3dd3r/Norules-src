package com.viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import java.util.*;

public class EntityPackets
{
    public static void register(final Protocol lllllllllllllllIIIIlllIIIlllIIIl) {
        final char lllllllllllllllIIIIlllIIIlIllIll;
        Metadata lllllllllllllllIIIIlllIIIllIIIIl;
        final PacketHandler lllllllllllllllIIIIlllIIIlllIIII = lllllllllllllllIIIIlllIIIlIlllIl -> {
            lllllllllllllllIIIIlllIIIlIllIll = (char)lllllllllllllllIIIIlllIIIlIlllIl.get(Types1_13_2.METADATA_LIST, 0).iterator();
            while (((Iterator)lllllllllllllllIIIIlllIIIlIllIll).hasNext()) {
                lllllllllllllllIIIIlllIIIllIIIIl = ((Iterator<Metadata>)lllllllllllllllIIIIlllIIIlIllIll).next();
                lllllllllllllllIIIIlllIIIllIIIIl.setMetaType(MetaType1_13_2.byId(lllllllllllllllIIIIlllIIIllIIIIl.metaType().typeId()));
            }
            return;
        };
        lllllllllllllllIIIIlllIIIlllIIIl.registerClientbound(ClientboundPackets1_13.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Types1_13.METADATA_LIST, Types1_13_2.METADATA_LIST);
                this.handler(lllllllllllllllIIIIlllIIIlllIIII);
            }
        });
        lllllllllllllllIIIIlllIIIlllIIIl.registerClientbound(ClientboundPackets1_13.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_13.METADATA_LIST, Types1_13_2.METADATA_LIST);
                this.handler(lllllllllllllllIIIIlllIIIlllIIII);
            }
        });
        lllllllllllllllIIIIlllIIIlllIIIl.registerClientbound(ClientboundPackets1_13.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Types1_13.METADATA_LIST, Types1_13_2.METADATA_LIST);
                this.handler(lllllllllllllllIIIIlllIIIlllIIII);
            }
        });
    }
}
