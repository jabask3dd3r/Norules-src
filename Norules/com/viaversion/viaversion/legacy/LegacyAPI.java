package com.viaversion.viaversion.legacy;

import com.viaversion.viaversion.api.legacy.*;
import com.viaversion.viaversion.api.legacy.bossbar.*;
import com.viaversion.viaversion.legacy.bossbar.*;

public final class LegacyAPI<T> implements LegacyViaAPI<T>
{
    @Override
    public BossBar createLegacyBossBar(final String lllllllllllllIIlIllIIlIlIIlIIIlI, final float lllllllllllllIIlIllIIlIlIIlIIIIl, final BossColor lllllllllllllIIlIllIIlIlIIlIIlII, final BossStyle lllllllllllllIIlIllIIlIlIIIlllll) {
        return new CommonBoss(lllllllllllllIIlIllIIlIlIIlIIIlI, lllllllllllllIIlIllIIlIlIIlIIIIl, lllllllllllllIIlIllIIlIlIIlIIlII, lllllllllllllIIlIllIIlIlIIIlllll);
    }
}
