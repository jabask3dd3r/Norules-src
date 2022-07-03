package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class BlockEntityProvider implements Provider
{
    private final /* synthetic */ Map<String, BlockEntityHandler> handlers;
    
    private void sendBlockChange(final UserConnection lIlllIlIlIlIlII, final Position lIlllIlIlIlIIll, final int lIlllIlIlIIlllI) throws Exception {
        final PacketWrapper lIlllIlIlIlIIIl = PacketWrapper.create(ClientboundPackets1_13.BLOCK_CHANGE, null, lIlllIlIlIlIlII);
        lIlllIlIlIlIIIl.write(Type.POSITION, lIlllIlIlIlIIll);
        lIlllIlIlIlIIIl.write(Type.VAR_INT, lIlllIlIlIIlllI);
        lIlllIlIlIlIIIl.send(Protocol1_13To1_12_2.class);
    }
    
    public BlockEntityProvider() {
        this.handlers = new HashMap<String, BlockEntityHandler>();
        this.handlers.put("minecraft:flower_pot", new FlowerPotHandler());
        this.handlers.put("minecraft:bed", new BedHandler());
        this.handlers.put("minecraft:banner", new BannerHandler());
        this.handlers.put("minecraft:skull", new SkullHandler());
        this.handlers.put("minecraft:mob_spawner", new SpawnerHandler());
        this.handlers.put("minecraft:command_block", new CommandBlockHandler());
    }
    
    public int transform(final UserConnection lIlllIlIllIlIlI, final Position lIlllIlIllIlIIl, final CompoundTag lIlllIlIlIlllll, final boolean lIlllIlIllIIlll) throws Exception {
        final Tag lIlllIlIllIIllI = lIlllIlIlIlllll.get("id");
        if (lIlllIlIllIIllI == null) {
            return -1;
        }
        final String lIlllIlIllIIlIl = (String)lIlllIlIllIIllI.getValue();
        final BlockEntityHandler lIlllIlIllIIlII = this.handlers.get(lIlllIlIllIIlIl);
        if (lIlllIlIllIIlII == null) {
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unhandled BlockEntity ").append(lIlllIlIllIIlIl).append(" full tag: ").append(lIlllIlIlIlllll)));
            }
            return -1;
        }
        final int lIlllIlIllIIIll = lIlllIlIllIIlII.transform(lIlllIlIllIlIlI, lIlllIlIlIlllll);
        if (lIlllIlIllIIlll && lIlllIlIllIIIll != -1) {
            this.sendBlockChange(lIlllIlIllIlIlI, lIlllIlIllIlIIl, lIlllIlIllIIIll);
        }
        return lIlllIlIllIIIll;
    }
    
    public interface BlockEntityHandler
    {
        int transform(final UserConnection p0, final CompoundTag p1);
    }
}
