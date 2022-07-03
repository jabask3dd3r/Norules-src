package net.minecraft.entity.projectile;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;

public class EntityEgg extends EntityThrowable
{
    @Override
    public void handleStatusUpdate(final byte lllllllllllllllIllIllIIlllllllIl) {
        if (lllllllllllllllIllIllIIlllllllIl == 3) {
            final double lllllllllllllllIllIllIlIIIIIIIIl = 0.08;
            for (int lllllllllllllllIllIllIlIIIIIIIII = 0; lllllllllllllllIllIllIlIIIIIIIII < 8; ++lllllllllllllllIllIllIlIIIIIIIII) {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, (this.rand.nextFloat() - 0.5) * 0.08, (this.rand.nextFloat() - 0.5) * 0.08, (this.rand.nextFloat() - 0.5) * 0.08, Item.getIdFromItem(Items.EGG));
            }
        }
    }
    
    public EntityEgg(final World lllllllllllllllIllIllIlIIIllIlII) {
        super(lllllllllllllllIllIllIlIIIllIlII);
    }
    
    public static void registerFixesEgg(final DataFixer lllllllllllllllIllIllIlIIIIlIlll) {
        EntityThrowable.registerFixesThrowable(lllllllllllllllIllIllIlIIIIlIlll, "ThrownEgg");
    }
    
    public EntityEgg(final World lllllllllllllllIllIllIlIIIlIIIlI, final double lllllllllllllllIllIllIlIIIIlllII, final double lllllllllllllllIllIllIlIIIIllIll, final double lllllllllllllllIllIllIlIIIIlllll) {
        super(lllllllllllllllIllIllIlIIIlIIIlI, lllllllllllllllIllIllIlIIIIlllII, lllllllllllllllIllIllIlIIIIllIll, lllllllllllllllIllIllIlIIIIlllll);
    }
    
    public EntityEgg(final World lllllllllllllllIllIllIlIIIlIllIl, final EntityLivingBase lllllllllllllllIllIllIlIIIlIlIIl) {
        super(lllllllllllllllIllIllIlIIIlIllIl, lllllllllllllllIllIllIlIIIlIlIIl);
    }
    
    @Override
    protected void onImpact(final RayTraceResult lllllllllllllllIllIllIIlllIllIII) {
        if (lllllllllllllllIllIllIIlllIllIII.entityHit != null) {
            lllllllllllllllIllIllIIlllIllIII.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0f);
        }
        if (!this.world.isRemote) {
            if (this.rand.nextInt(8) == 0) {
                int lllllllllllllllIllIllIIlllIllllI = 1;
                if (this.rand.nextInt(32) == 0) {
                    lllllllllllllllIllIllIIlllIllllI = 4;
                }
                for (int lllllllllllllllIllIllIIlllIlllII = 0; lllllllllllllllIllIllIIlllIlllII < lllllllllllllllIllIllIIlllIllllI; ++lllllllllllllllIllIllIIlllIlllII) {
                    final EntityChicken lllllllllllllllIllIllIIlllIllIlI = new EntityChicken(this.world);
                    lllllllllllllllIllIllIIlllIllIlI.setGrowingAge(-24000);
                    lllllllllllllllIllIllIIlllIllIlI.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    this.world.spawnEntityInWorld(lllllllllllllllIllIllIIlllIllIlI);
                }
            }
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
}
