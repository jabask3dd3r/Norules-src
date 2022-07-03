package net.minecraft.util;

import net.minecraft.util.math.*;

public class CombatRules
{
    public static float getDamageAfterMagicAbsorb(final float lllllllllllllIIllIlIIlIllIlIlIII, final float lllllllllllllIIllIlIIlIllIlIIlll) {
        final float lllllllllllllIIllIlIIlIllIlIIllI = MathHelper.clamp(lllllllllllllIIllIlIIlIllIlIIlll, 0.0f, 20.0f);
        return lllllllllllllIIllIlIIlIllIlIlIII * (1.0f - lllllllllllllIIllIlIIlIllIlIIllI / 25.0f);
    }
    
    public static float getDamageAfterAbsorb(final float lllllllllllllIIllIlIIlIllIllIlIl, final float lllllllllllllIIllIlIIlIllIllIlII, final float lllllllllllllIIllIlIIlIllIlIlllI) {
        final float lllllllllllllIIllIlIIlIllIllIIlI = 2.0f + lllllllllllllIIllIlIIlIllIlIlllI / 4.0f;
        final float lllllllllllllIIllIlIIlIllIllIIIl = MathHelper.clamp(lllllllllllllIIllIlIIlIllIllIlII - lllllllllllllIIllIlIIlIllIllIlIl / lllllllllllllIIllIlIIlIllIllIIlI, lllllllllllllIIllIlIIlIllIllIlII * 0.2f, 20.0f);
        return lllllllllllllIIllIlIIlIllIllIlIl * (1.0f - lllllllllllllIIllIlIIlIllIllIIIl / 25.0f);
    }
}
