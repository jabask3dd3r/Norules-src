package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.projectile.*;

public class EntityMinecartTNT extends EntityMinecart
{
    private /* synthetic */ int minecartTNTFuse;
    
    public void ignite() {
        this.minecartTNTFuse = 80;
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)10);
            if (!this.isSilent()) {
                this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
        }
    }
    
    public EntityMinecartTNT(final World lllllllllllllIIllIIIIlIIIIllIIll) {
        super(lllllllllllllIIllIIIIlIIIIllIIll);
        this.minecartTNTFuse = -1;
    }
    
    @Override
    public IBlockState getDefaultDisplayTile() {
        return Blocks.TNT.getDefaultState();
    }
    
    @Override
    public void killMinecart(final DamageSource lllllllllllllIIllIIIIlIIIIIIIlIl) {
        final double lllllllllllllIIllIIIIlIIIIIIIlII = this.motionX * this.motionX + this.motionZ * this.motionZ;
        if (!lllllllllllllIIllIIIIlIIIIIIIlIl.isFireDamage() && !lllllllllllllIIllIIIIlIIIIIIIlIl.isExplosion() && lllllllllllllIIllIIIIlIIIIIIIlII < 0.009999999776482582) {
            super.killMinecart(lllllllllllllIIllIIIIlIIIIIIIlIl);
            if (!lllllllllllllIIllIIIIlIIIIIIIlIl.isExplosion() && this.world.getGameRules().getBoolean("doEntityDrops")) {
                this.entityDropItem(new ItemStack(Blocks.TNT, 1), 0.0f);
            }
        }
        else if (this.minecartTNTFuse < 0) {
            this.ignite();
            this.minecartTNTFuse = this.rand.nextInt(20) + this.rand.nextInt(20);
        }
    }
    
    @Override
    public void onActivatorRailPass(final int lllllllllllllIIllIIIIIlllllIlIII, final int lllllllllllllIIllIIIIIlllllIIlll, final int lllllllllllllIIllIIIIIlllllIIllI, final boolean lllllllllllllIIllIIIIIlllllIIlIl) {
        if (lllllllllllllIIllIIIIIlllllIIlIl && this.minecartTNTFuse < 0) {
            this.ignite();
        }
    }
    
    public boolean isIgnited() {
        return this.minecartTNTFuse > -1;
    }
    
    @Override
    public float getExplosionResistance(final Explosion lllllllllllllIIllIIIIIllllIIlIII, final World lllllllllllllIIllIIIIIllllIIIlll, final BlockPos lllllllllllllIIllIIIIIllllIIIllI, final IBlockState lllllllllllllIIllIIIIIllllIIIlIl) {
        return (!this.isIgnited() || (!BlockRailBase.isRailBlock(lllllllllllllIIllIIIIIllllIIIlIl) && !BlockRailBase.isRailBlock(lllllllllllllIIllIIIIIllllIIIlll, lllllllllllllIIllIIIIIllllIIIllI.up()))) ? super.getExplosionResistance(lllllllllllllIIllIIIIIllllIIlIII, lllllllllllllIIllIIIIIllllIIIlll, lllllllllllllIIllIIIIIllllIIIllI, lllllllllllllIIllIIIIIllllIIIlIl) : 0.0f;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.minecartTNTFuse > 0) {
            --this.minecartTNTFuse;
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
        else if (this.minecartTNTFuse == 0) {
            this.explodeCart(this.motionX * this.motionX + this.motionZ * this.motionZ);
        }
        if (this.isCollidedHorizontally) {
            final double lllllllllllllIIllIIIIlIIIIIllIll = this.motionX * this.motionX + this.motionZ * this.motionZ;
            if (lllllllllllllIIllIIIIlIIIIIllIll >= 0.009999999776482582) {
                this.explodeCart(lllllllllllllIIllIIIIlIIIIIllIll);
            }
        }
    }
    
    public static void registerFixesMinecartTNT(final DataFixer lllllllllllllIIllIIIIlIIIIlIIIIl) {
        EntityMinecart.registerFixesMinecart(lllllllllllllIIllIIIIlIIIIlIIIIl, EntityMinecartTNT.class);
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIIllIIIIIllllIlllll) {
        if (lllllllllllllIIllIIIIIllllIlllll == 10) {
            this.ignite();
        }
        else {
            super.handleStatusUpdate(lllllllllllllIIllIIIIIllllIlllll);
        }
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIIllIIIIIlllIlIllIl) {
        super.readEntityFromNBT(lllllllllllllIIllIIIIIlllIlIllIl);
        if (lllllllllllllIIllIIIIIlllIlIllIl.hasKey("TNTFuse", 99)) {
            this.minecartTNTFuse = lllllllllllllIIllIIIIIlllIlIllIl.getInteger("TNTFuse");
        }
    }
    
    public EntityMinecartTNT(final World lllllllllllllIIllIIIIlIIIIlIIlll, final double lllllllllllllIIllIIIIlIIIIlIlIll, final double lllllllllllllIIllIIIIlIIIIlIIlIl, final double lllllllllllllIIllIIIIlIIIIlIlIIl) {
        super(lllllllllllllIIllIIIIlIIIIlIIlll, lllllllllllllIIllIIIIlIIIIlIlIll, lllllllllllllIIllIIIIlIIIIlIIlIl, lllllllllllllIIllIIIIlIIIIlIlIIl);
        this.minecartTNTFuse = -1;
    }
    
    @Override
    public boolean verifyExplosion(final Explosion lllllllllllllIIllIIIIIlllIllIlll, final World lllllllllllllIIllIIIIIlllIllIllI, final BlockPos lllllllllllllIIllIIIIIlllIlllIll, final IBlockState lllllllllllllIIllIIIIIlllIlllIlI, final float lllllllllllllIIllIIIIIlllIllIIll) {
        return (!this.isIgnited() || (!BlockRailBase.isRailBlock(lllllllllllllIIllIIIIIlllIlllIlI) && !BlockRailBase.isRailBlock(lllllllllllllIIllIIIIIlllIllIllI, lllllllllllllIIllIIIIIlllIlllIll.up()))) && super.verifyExplosion(lllllllllllllIIllIIIIIlllIllIlll, lllllllllllllIIllIIIIIlllIllIllI, lllllllllllllIIllIIIIIlllIlllIll, lllllllllllllIIllIIIIIlllIlllIlI, lllllllllllllIIllIIIIIlllIllIIll);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIllIIIIlIIIIIlIIlI, final float lllllllllllllIIllIIIIlIIIIIIllII) {
        final Entity lllllllllllllIIllIIIIlIIIIIlIIII = lllllllllllllIIllIIIIlIIIIIlIIlI.getSourceOfDamage();
        if (lllllllllllllIIllIIIIlIIIIIlIIII instanceof EntityArrow) {
            final EntityArrow lllllllllllllIIllIIIIlIIIIIIllll = (EntityArrow)lllllllllllllIIllIIIIlIIIIIlIIII;
            if (lllllllllllllIIllIIIIlIIIIIIllll.isBurning()) {
                this.explodeCart(lllllllllllllIIllIIIIlIIIIIIllll.motionX * lllllllllllllIIllIIIIlIIIIIIllll.motionX + lllllllllllllIIllIIIIlIIIIIIllll.motionY * lllllllllllllIIllIIIIlIIIIIIllll.motionY + lllllllllllllIIllIIIIlIIIIIIllll.motionZ * lllllllllllllIIllIIIIlIIIIIIllll.motionZ);
            }
        }
        return super.attackEntityFrom(lllllllllllllIIllIIIIlIIIIIlIIlI, lllllllllllllIIllIIIIlIIIIIIllII);
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIIllIIIIIlllIlIlIIl) {
        super.writeEntityToNBT(lllllllllllllIIllIIIIIlllIlIlIIl);
        lllllllllllllIIllIIIIIlllIlIlIIl.setInteger("TNTFuse", this.minecartTNTFuse);
    }
    
    @Override
    public void fall(final float lllllllllllllIIllIIIIIlllllIlllI, final float lllllllllllllIIllIIIIIllllllIIIl) {
        if (lllllllllllllIIllIIIIIlllllIlllI >= 3.0f) {
            final float lllllllllllllIIllIIIIIllllllIIII = lllllllllllllIIllIIIIIlllllIlllI / 10.0f;
            this.explodeCart(lllllllllllllIIllIIIIIllllllIIII * lllllllllllllIIllIIIIIllllllIIII);
        }
        super.fall(lllllllllllllIIllIIIIIlllllIlllI, lllllllllllllIIllIIIIIllllllIIIl);
    }
    
    @Override
    public Type getType() {
        return Type.TNT;
    }
    
    protected void explodeCart(final double lllllllllllllIIllIIIIIllllllllII) {
        if (!this.world.isRemote) {
            double lllllllllllllIIllIIIIIlllllllIll = Math.sqrt(lllllllllllllIIllIIIIIllllllllII);
            if (lllllllllllllIIllIIIIIlllllllIll > 5.0) {
                lllllllllllllIIllIIIIIlllllllIll = 5.0;
            }
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, (float)(4.0 + this.rand.nextDouble() * 1.5 * lllllllllllllIIllIIIIIlllllllIll), true);
            this.setDead();
        }
    }
    
    public int getFuseTicks() {
        return this.minecartTNTFuse;
    }
}
