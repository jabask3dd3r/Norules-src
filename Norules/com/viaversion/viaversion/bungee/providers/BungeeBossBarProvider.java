package com.viaversion.viaversion.bungee.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import java.util.*;
import com.viaversion.viaversion.bungee.storage.*;
import com.viaversion.viaversion.api.connection.*;

public class BungeeBossBarProvider extends BossBarProvider
{
    @Override
    public void handleRemove(final UserConnection llllllllllllllIIlIIllIIlllIIllll, final UUID llllllllllllllIIlIIllIIlllIlIIII) {
        if (llllllllllllllIIlIIllIIlllIIllll.has(BungeeStorage.class)) {
            final BungeeStorage llllllllllllllIIlIIllIIlllIlIIll = llllllllllllllIIlIIllIIlllIIllll.get(BungeeStorage.class);
            if (llllllllllllllIIlIIllIIlllIlIIll.getBossbar() != null) {
                llllllllllllllIIlIIllIIlllIlIIll.getBossbar().remove(llllllllllllllIIlIIllIIlllIlIIII);
            }
        }
    }
    
    @Override
    public void handleAdd(final UserConnection llllllllllllllIIlIIllIIlllIllIll, final UUID llllllllllllllIIlIIllIIlllIllIII) {
        if (llllllllllllllIIlIIllIIlllIllIll.has(BungeeStorage.class)) {
            final BungeeStorage llllllllllllllIIlIIllIIlllIlllIl = llllllllllllllIIlIIllIIlllIllIll.get(BungeeStorage.class);
            if (llllllllllllllIIlIIllIIlllIlllIl.getBossbar() != null) {
                llllllllllllllIIlIIllIIlllIlllIl.getBossbar().add(llllllllllllllIIlIIllIIlllIllIII);
            }
        }
    }
}
