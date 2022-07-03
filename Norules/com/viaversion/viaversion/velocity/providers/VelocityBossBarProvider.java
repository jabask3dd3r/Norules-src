package com.viaversion.viaversion.velocity.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import java.util.*;
import com.viaversion.viaversion.velocity.storage.*;
import com.viaversion.viaversion.api.connection.*;

public class VelocityBossBarProvider extends BossBarProvider
{
    @Override
    public void handleRemove(final UserConnection lllllllllllllIIlllllIIlllllIlIII, final UUID lllllllllllllIIlllllIIlllllIlIIl) {
        if (lllllllllllllIIlllllIIlllllIlIII.has(VelocityStorage.class)) {
            final VelocityStorage lllllllllllllIIlllllIIlllllIllII = lllllllllllllIIlllllIIlllllIlIII.get(VelocityStorage.class);
            if (lllllllllllllIIlllllIIlllllIllII.getBossbar() != null) {
                lllllllllllllIIlllllIIlllllIllII.getBossbar().remove(lllllllllllllIIlllllIIlllllIlIIl);
            }
        }
    }
    
    @Override
    public void handleAdd(final UserConnection lllllllllllllIIlllllIIllllllIIlI, final UUID lllllllllllllIIlllllIIllllllIIll) {
        if (lllllllllllllIIlllllIIllllllIIlI.has(VelocityStorage.class)) {
            final VelocityStorage lllllllllllllIIlllllIIllllllIllI = lllllllllllllIIlllllIIllllllIIlI.get(VelocityStorage.class);
            if (lllllllllllllIIlllllIIllllllIllI.getBossbar() != null) {
                lllllllllllllIIlllllIIllllllIllI.getBossbar().add(lllllllllllllIIlllllIIllllllIIll);
            }
        }
    }
}
