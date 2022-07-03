package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers.*;

public class BackwardsBlockEntityProvider implements Provider
{
    private final /* synthetic */ Map<String, BackwardsBlockEntityHandler> handlers;
    
    public CompoundTag transform(final UserConnection lllllllllllllIllIlllIIlIlIllIlII, final Position lllllllllllllIllIlllIIlIlIlllIll, final CompoundTag lllllllllllllIllIlllIIlIlIlllIlI) throws Exception {
        final String lllllllllllllIllIlllIIlIlIlllIIl = (String)lllllllllllllIllIlllIIlIlIlllIlI.get("id").getValue();
        final BackwardsBlockEntityHandler lllllllllllllIllIlllIIlIlIlllIII = this.handlers.get(lllllllllllllIllIlllIIlIlIlllIIl);
        if (lllllllllllllIllIlllIIlIlIlllIII == null) {
            if (Via.getManager().isDebug()) {
                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unhandled BlockEntity ").append(lllllllllllllIllIlllIIlIlIlllIIl).append(" full tag: ").append(lllllllllllllIllIlllIIlIlIlllIlI)));
            }
            return lllllllllllllIllIlllIIlIlIlllIlI;
        }
        final BackwardsBlockStorage lllllllllllllIllIlllIIlIlIllIlll = lllllllllllllIllIlllIIlIlIllIlII.get(BackwardsBlockStorage.class);
        final Integer lllllllllllllIllIlllIIlIlIllIllI = lllllllllllllIllIlllIIlIlIllIlll.get(lllllllllllllIllIlllIIlIlIlllIll);
        if (lllllllllllllIllIlllIIlIlIllIllI == null) {
            if (Via.getManager().isDebug()) {
                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Handled BlockEntity does not have a stored block :( ").append(lllllllllllllIllIlllIIlIlIlllIIl).append(" full tag: ").append(lllllllllllllIllIlllIIlIlIlllIlI)));
            }
            return lllllllllllllIllIlllIIlIlIlllIlI;
        }
        return lllllllllllllIllIlllIIlIlIlllIII.transform(lllllllllllllIllIlllIIlIlIllIlII, lllllllllllllIllIlllIIlIlIllIllI, lllllllllllllIllIlllIIlIlIlllIlI);
    }
    
    public CompoundTag transform(final UserConnection lllllllllllllIllIlllIIlIlIlIIIlI, final Position lllllllllllllIllIlllIIlIlIlIIllI, final String lllllllllllllIllIlllIIlIlIlIIlIl) throws Exception {
        final CompoundTag lllllllllllllIllIlllIIlIlIlIIlII = new CompoundTag();
        lllllllllllllIllIlllIIlIlIlIIlII.put("id", new StringTag(lllllllllllllIllIlllIIlIlIlIIlIl));
        lllllllllllllIllIlllIIlIlIlIIlII.put("x", new IntTag(Math.toIntExact(lllllllllllllIllIlllIIlIlIlIIllI.getX())));
        lllllllllllllIllIlllIIlIlIlIIlII.put("y", new IntTag(Math.toIntExact(lllllllllllllIllIlllIIlIlIlIIllI.getY())));
        lllllllllllllIllIlllIIlIlIlIIlII.put("z", new IntTag(Math.toIntExact(lllllllllllllIllIlllIIlIlIlIIllI.getZ())));
        return this.transform(lllllllllllllIllIlllIIlIlIlIIIlI, lllllllllllllIllIlllIIlIlIlIIllI, lllllllllllllIllIlllIIlIlIlIIlII);
    }
    
    public boolean isHandled(final String lllllllllllllIllIlllIIlIllIIIllI) {
        return this.handlers.containsKey(lllllllllllllIllIlllIIlIllIIIllI);
    }
    
    public BackwardsBlockEntityProvider() {
        this.handlers = new HashMap<String, BackwardsBlockEntityHandler>();
        this.handlers.put("minecraft:flower_pot", new FlowerPotHandler());
        this.handlers.put("minecraft:bed", new BedHandler());
        this.handlers.put("minecraft:banner", new BannerHandler());
        this.handlers.put("minecraft:skull", new SkullHandler());
        this.handlers.put("minecraft:mob_spawner", new SpawnerHandler());
        this.handlers.put("minecraft:piston", new PistonHandler());
    }
    
    public interface BackwardsBlockEntityHandler
    {
        CompoundTag transform(final UserConnection p0, final int p1, final CompoundTag p2);
    }
}
