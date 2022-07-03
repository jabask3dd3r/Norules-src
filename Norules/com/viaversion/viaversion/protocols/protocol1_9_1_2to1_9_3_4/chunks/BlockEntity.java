package com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.chunks;

import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.*;

public class BlockEntity
{
    private static final /* synthetic */ Map<String, Integer> types;
    
    static {
        (types = new HashMap<String, Integer>()).put("MobSpawner", 1);
        BlockEntity.types.put("Control", 2);
        BlockEntity.types.put("Beacon", 3);
        BlockEntity.types.put("Skull", 4);
        BlockEntity.types.put("FlowerPot", 5);
        BlockEntity.types.put("Banner", 6);
        BlockEntity.types.put("UNKNOWN", 7);
        BlockEntity.types.put("EndGateway", 8);
        BlockEntity.types.put("Sign", 9);
    }
    
    private static void updateBlockEntity(final Position lllllllllllllllllllllIIIlIIllIII, final short lllllllllllllllllllllIIIlIIlIlll, final CompoundTag lllllllllllllllllllllIIIlIIllIll, final UserConnection lllllllllllllllllllllIIIlIIlIlIl) throws Exception {
        final PacketWrapper lllllllllllllllllllllIIIlIIllIIl = PacketWrapper.create(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, null, lllllllllllllllllllllIIIlIIlIlIl);
        lllllllllllllllllllllIIIlIIllIIl.write(Type.POSITION, lllllllllllllllllllllIIIlIIllIII);
        lllllllllllllllllllllIIIlIIllIIl.write(Type.UNSIGNED_BYTE, lllllllllllllllllllllIIIlIIlIlll);
        lllllllllllllllllllllIIIlIIllIIl.write(Type.NBT, lllllllllllllllllllllIIIlIIllIll);
        lllllllllllllllllllllIIIlIIllIIl.scheduleSend(Protocol1_9_1_2To1_9_3_4.class, false);
    }
    
    public static void handle(final List<CompoundTag> lllllllllllllllllllllIIIlIlIllII, final UserConnection lllllllllllllllllllllIIIlIlIllIl) {
        for (final CompoundTag lllllllllllllllllllllIIIlIlIllll : lllllllllllllllllllllIIIlIlIllII) {
            try {
                if (!lllllllllllllllllllllIIIlIlIllll.contains("id")) {
                    throw new Exception("NBT tag not handled because the id key is missing");
                }
                final String lllllllllllllllllllllIIIlIllIllI = (String)lllllllllllllllllllllIIIlIlIllll.get("id").getValue();
                if (!BlockEntity.types.containsKey(lllllllllllllllllllllIIIlIllIllI)) {
                    throw new Exception(String.valueOf(new StringBuilder().append("Not handled id: ").append(lllllllllllllllllllllIIIlIllIllI)));
                }
                final int lllllllllllllllllllllIIIlIllIlIl = BlockEntity.types.get(lllllllllllllllllllllIIIlIllIllI);
                if (lllllllllllllllllllllIIIlIllIlIl == -1) {
                    continue;
                }
                final int lllllllllllllllllllllIIIlIllIlII = lllllllllllllllllllllIIIlIlIllll.get("x").asInt();
                final int lllllllllllllllllllllIIIlIllIIll = lllllllllllllllllllllIIIlIlIllll.get("y").asInt();
                final int lllllllllllllllllllllIIIlIllIIlI = lllllllllllllllllllllIIIlIlIllll.get("z").asInt();
                final Position lllllllllllllllllllllIIIlIllIIIl = new Position(lllllllllllllllllllllIIIlIllIlII, (short)lllllllllllllllllllllIIIlIllIIll, lllllllllllllllllllllIIIlIllIIlI);
                updateBlockEntity(lllllllllllllllllllllIIIlIllIIIl, (short)lllllllllllllllllllllIIIlIllIlIl, lllllllllllllllllllllIIIlIlIllll, lllllllllllllllllllllIIIlIlIllIl);
            }
            catch (Exception lllllllllllllllllllllIIIlIllIIII) {
                if (!Via.getManager().isDebug()) {
                    continue;
                }
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Block Entity: ").append(lllllllllllllllllllllIIIlIllIIII.getMessage()).append(": ").append(lllllllllllllllllllllIIIlIlIllll)));
            }
        }
    }
}
