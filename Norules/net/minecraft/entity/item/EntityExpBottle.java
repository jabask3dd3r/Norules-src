package net.minecraft.entity.item;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;

public class EntityExpBottle extends EntityThrowable
{
    public static void registerFixesExpBottle(final DataFixer lllllllllllllIIllIlIIIIIIIlIlIIl) {
        EntityThrowable.registerFixesThrowable(lllllllllllllIIllIlIIIIIIIlIlIIl, "ThrowableExpBottle");
    }
    
    public EntityExpBottle(final World lllllllllllllIIllIlIIIIIIIllllII, final EntityLivingBase lllllllllllllIIllIlIIIIIIIlllllI) {
        super(lllllllllllllIIllIlIIIIIIIllllII, lllllllllllllIIllIlIIIIIIIlllllI);
    }
    
    public EntityExpBottle(final World lllllllllllllIIllIlIIIIIIlIIIlII) {
        super(lllllllllllllIIllIlIIIIIIlIIIlII);
    }
    
    @Override
    protected float getGravityVelocity() {
        return 0.07f;
    }
    
    public EntityExpBottle(final World lllllllllllllIIllIlIIIIIIIllIlII, final double lllllllllllllIIllIlIIIIIIIllIIll, final double lllllllllllllIIllIlIIIIIIIlIllIl, final double lllllllllllllIIllIlIIIIIIIllIIIl) {
        super(lllllllllllllIIllIlIIIIIIIllIlII, lllllllllllllIIllIlIIIIIIIllIIll, lllllllllllllIIllIlIIIIIIIlIllIl, lllllllllllllIIllIlIIIIIIIllIIIl);
    }
    
    @Override
    protected void onImpact(final RayTraceResult lllllllllllllIIllIlIIIIIIIlIIIll) {
        if (!this.world.isRemote) {
            this.world.playEvent(2002, new BlockPos(this), PotionUtils.getPotionColor(PotionTypes.WATER));
            int lllllllllllllIIllIlIIIIIIIlIIIlI = 3 + this.world.rand.nextInt(5) + this.world.rand.nextInt(5);
            while (lllllllllllllIIllIlIIIIIIIlIIIlI > 0) {
                final int lllllllllllllIIllIlIIIIIIIlIIIIl = EntityXPOrb.getXPSplit(lllllllllllllIIllIlIIIIIIIlIIIlI);
                lllllllllllllIIllIlIIIIIIIlIIIlI -= lllllllllllllIIllIlIIIIIIIlIIIIl;
                this.world.spawnEntityInWorld(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, lllllllllllllIIllIlIIIIIIIlIIIIl));
            }
            this.setDead();
        }
    }
}
