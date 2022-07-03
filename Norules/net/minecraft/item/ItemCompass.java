package net.minecraft.item;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.entity.*;

public class ItemCompass extends Item
{
    public ItemCompass() {
        this.addPropertyOverride(new ResourceLocation("angle"), new IItemPropertyGetter() {
            /* synthetic */ double rota;
            /* synthetic */ double rotation;
            /* synthetic */ long lastUpdateTick;
            
            private double getSpawnToAngle(final World lllllllllllllIIIIIlIllIlIlIIlIII, final Entity lllllllllllllIIIIIlIllIlIlIIlIlI) {
                final BlockPos lllllllllllllIIIIIlIllIlIlIIlIIl = lllllllllllllIIIIIlIllIlIlIIlIII.getSpawnPoint();
                return Math.atan2(lllllllllllllIIIIIlIllIlIlIIlIIl.getZ() - lllllllllllllIIIIIlIllIlIlIIlIlI.posZ, lllllllllllllIIIIIlIllIlIlIIlIIl.getX() - lllllllllllllIIIIIlIllIlIlIIlIlI.posX);
            }
            
            private double getFrameRotation(final EntityItemFrame lllllllllllllIIIIIlIllIlIlIlIIII) {
                return MathHelper.clampAngle(180 + lllllllllllllIIIIIlIllIlIlIlIIII.facingDirection.getHorizontalIndex() * 90);
            }
            
            private double wobble(final World lllllllllllllIIIIIlIllIlIlIlIllI, final double lllllllllllllIIIIIlIllIlIlIlIlIl) {
                if (lllllllllllllIIIIIlIllIlIlIlIllI.getTotalWorldTime() != this.lastUpdateTick) {
                    this.lastUpdateTick = lllllllllllllIIIIIlIllIlIlIlIllI.getTotalWorldTime();
                    double lllllllllllllIIIIIlIllIlIlIllIII = lllllllllllllIIIIIlIllIlIlIlIlIl - this.rotation;
                    lllllllllllllIIIIIlIllIlIlIllIII = MathHelper.func_191273_b(lllllllllllllIIIIIlIllIlIlIllIII + 0.5, 1.0) - 0.5;
                    this.rota += lllllllllllllIIIIIlIllIlIlIllIII * 0.1;
                    this.rota *= 0.8;
                    this.rotation = MathHelper.func_191273_b(this.rotation + this.rota, 1.0);
                }
                return this.rotation;
            }
            
            @Override
            public float apply(final ItemStack lllllllllllllIIIIIlIllIlIlllIIIl, @Nullable World lllllllllllllIIIIIlIllIlIllIIllI, @Nullable final EntityLivingBase lllllllllllllIIIIIlIllIlIllIllll) {
                if (lllllllllllllIIIIIlIllIlIllIllll == null && !lllllllllllllIIIIIlIllIlIlllIIIl.isOnItemFrame()) {
                    return 0.0f;
                }
                final boolean lllllllllllllIIIIIlIllIlIllIlllI = lllllllllllllIIIIIlIllIlIllIllll != null;
                final Entity lllllllllllllIIIIIlIllIlIllIllIl = lllllllllllllIIIIIlIllIlIllIlllI ? lllllllllllllIIIIIlIllIlIllIllll : lllllllllllllIIIIIlIllIlIlllIIIl.getItemFrame();
                if (lllllllllllllIIIIIlIllIlIllIIllI == null) {
                    lllllllllllllIIIIIlIllIlIllIIllI = lllllllllllllIIIIIlIllIlIllIllIl.world;
                }
                double lllllllllllllIIIIIlIllIlIllIlIll;
                if (((World)lllllllllllllIIIIIlIllIlIllIIllI).provider.isSurfaceWorld()) {
                    double lllllllllllllIIIIIlIllIlIllIlIlI = lllllllllllllIIIIIlIllIlIllIlllI ? lllllllllllllIIIIIlIllIlIllIllIl.rotationYaw : this.getFrameRotation((EntityItemFrame)lllllllllllllIIIIIlIllIlIllIllIl);
                    lllllllllllllIIIIIlIllIlIllIlIlI = MathHelper.func_191273_b(lllllllllllllIIIIIlIllIlIllIlIlI / 360.0, 1.0);
                    final double lllllllllllllIIIIIlIllIlIllIlIIl = this.getSpawnToAngle((World)lllllllllllllIIIIIlIllIlIllIIllI, lllllllllllllIIIIIlIllIlIllIllIl) / 6.283185307179586;
                    final double lllllllllllllIIIIIlIllIlIllIllII = 0.5 - (lllllllllllllIIIIIlIllIlIllIlIlI - 0.25 - lllllllllllllIIIIIlIllIlIllIlIIl);
                }
                else {
                    lllllllllllllIIIIIlIllIlIllIlIll = Math.random();
                }
                if (lllllllllllllIIIIIlIllIlIllIlllI) {
                    lllllllllllllIIIIIlIllIlIllIlIll = this.wobble((World)lllllllllllllIIIIIlIllIlIllIIllI, lllllllllllllIIIIIlIllIlIllIlIll);
                }
                return MathHelper.positiveModulo((float)lllllllllllllIIIIIlIllIlIllIlIll, 1.0f);
            }
        });
    }
}
