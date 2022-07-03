package net.minecraft.item;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.entity.*;

public class ItemClock extends Item
{
    public ItemClock() {
        this.addPropertyOverride(new ResourceLocation("time"), new IItemPropertyGetter() {
            /* synthetic */ double rota;
            /* synthetic */ long lastUpdateTick;
            /* synthetic */ double rotation;
            
            private double wobble(final World llIIlIIlIIllI, final double llIIlIIlIIlIl) {
                if (llIIlIIlIIllI.getTotalWorldTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = llIIlIIlIIllI.getTotalWorldTime();
                    double llIIlIIlIlIII = llIIlIIlIIlIl - this.rotation;
                    llIIlIIlIlIII = MathHelper.func_191273_b(llIIlIIlIlIII + 0.5, 1.0) - 0.5;
                    this.rota += llIIlIIlIlIII * 0.1;
                    this.rota *= 0.9;
                    this.rotation = MathHelper.func_191273_b(this.rotation + this.rota, 1.0);
                }
                return this.rotation;
            }
            
            @Override
            public float apply(final ItemStack llIIlIIllllIl, @Nullable World llIIlIIllIlII, @Nullable final EntityLivingBase llIIlIIllIIll) {
                final boolean llIIlIIlllIlI = llIIlIIllIIll != null;
                final Entity llIIlIIlllIIl = llIIlIIlllIlI ? llIIlIIllIIll : llIIlIIllllIl.getItemFrame();
                if (llIIlIIllIlII == null && llIIlIIlllIIl != null) {
                    llIIlIIllIlII = llIIlIIlllIIl.world;
                }
                if (llIIlIIllIlII == null) {
                    return 0.0f;
                }
                double llIIlIIllIlll = 0.0;
                if (llIIlIIllIlII.provider.isSurfaceWorld()) {
                    final double llIIlIIlllIII = llIIlIIllIlII.getCelestialAngle(1.0f);
                }
                else {
                    llIIlIIllIlll = Math.random();
                }
                llIIlIIllIlll = this.wobble(llIIlIIllIlII, llIIlIIllIlll);
                return (float)llIIlIIllIlll;
            }
        });
    }
}
