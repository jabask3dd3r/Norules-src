package com.viaversion.viaversion.api.legacy;

import com.viaversion.viaversion.api.legacy.bossbar.*;

public interface LegacyViaAPI<T>
{
    default BossBar createLegacyBossBar(final String llllllllllllllllIllIIllIlIlIIIII, final BossColor llllllllllllllllIllIIllIlIlIIIll, final BossStyle llllllllllllllllIllIIllIlIIllllI) {
        return this.createLegacyBossBar(llllllllllllllllIllIIllIlIlIIIII, 1.0f, llllllllllllllllIllIIllIlIlIIIll, llllllllllllllllIllIIllIlIIllllI);
    }
    
    BossBar createLegacyBossBar(final String p0, final float p1, final BossColor p2, final BossStyle p3);
}
