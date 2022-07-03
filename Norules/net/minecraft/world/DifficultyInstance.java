package net.minecraft.world;

import javax.annotation.concurrent.*;
import net.minecraft.util.math.*;

@Immutable
public class DifficultyInstance
{
    private final /* synthetic */ float additionalDifficulty;
    private final /* synthetic */ EnumDifficulty worldDifficulty;
    
    public DifficultyInstance(final EnumDifficulty lllIllIIIlll, final long lllIllIIIIIl, final long lllIllIIIIII, final float lllIllIIIlII) {
        this.worldDifficulty = lllIllIIIlll;
        this.additionalDifficulty = this.calculateAdditionalDifficulty(lllIllIIIlll, lllIllIIIIIl, lllIllIIIIII, lllIllIIIlII);
    }
    
    public boolean func_193845_a(final float lllIlIlllIII) {
        return this.additionalDifficulty > lllIlIlllIII;
    }
    
    public float getAdditionalDifficulty() {
        return this.additionalDifficulty;
    }
    
    public float getClampedAdditionalDifficulty() {
        if (this.additionalDifficulty < 2.0f) {
            return 0.0f;
        }
        return (this.additionalDifficulty > 4.0f) ? 1.0f : ((this.additionalDifficulty - 2.0f) / 2.0f);
    }
    
    private float calculateAdditionalDifficulty(final EnumDifficulty lllIlIlIlIIl, final long lllIlIlIlIII, final long lllIlIIlllll, final float lllIlIIllllI) {
        if (lllIlIlIlIIl == EnumDifficulty.PEACEFUL) {
            return 0.0f;
        }
        final boolean lllIlIlIIlIl = lllIlIlIlIIl == EnumDifficulty.HARD;
        float lllIlIlIIlII = 0.75f;
        final float lllIlIlIIIll = MathHelper.clamp((lllIlIlIlIII - 72000.0f) / 1440000.0f, 0.0f, 1.0f) * 0.25f;
        lllIlIlIIlII += lllIlIlIIIll;
        float lllIlIlIIIlI = 0.0f;
        lllIlIlIIIlI += MathHelper.clamp(lllIlIIlllll / 3600000.0f, 0.0f, 1.0f) * (lllIlIlIIlIl ? 1.0f : 0.75f);
        lllIlIlIIIlI += MathHelper.clamp(lllIlIIllllI * 0.25f, 0.0f, lllIlIlIIIll);
        if (lllIlIlIlIIl == EnumDifficulty.EASY) {
            lllIlIlIIIlI *= 0.5f;
        }
        lllIlIlIIlII += lllIlIlIIIlI;
        return lllIlIlIlIIl.getDifficultyId() * lllIlIlIIlII;
    }
}
