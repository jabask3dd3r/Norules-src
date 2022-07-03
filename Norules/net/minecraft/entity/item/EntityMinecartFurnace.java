package net.minecraft.entity.item;

import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;

public class EntityMinecartFurnace extends EntityMinecart
{
    public /* synthetic */ double pushX;
    private static final /* synthetic */ DataParameter<Boolean> POWERED;
    public /* synthetic */ double pushZ;
    private /* synthetic */ int fuel;
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIIIIIIlIIIIlIIllI) {
        super.readEntityFromNBT(lllllllllllllIIIIIIIIlIIIIlIIllI);
        this.pushX = lllllllllllllIIIIIIIIlIIIIlIIllI.getDouble("PushX");
        this.pushZ = lllllllllllllIIIIIIIIlIIIIlIIllI.getDouble("PushZ");
        this.fuel = lllllllllllllIIIIIIIIlIIIIlIIllI.getShort("Fuel");
    }
    
    public EntityMinecartFurnace(final World lllllllllllllIIIIIIIIlIIIllIllll, final double lllllllllllllIIIIIIIIlIIIllIlIIl, final double lllllllllllllIIIIIIIIlIIIllIllIl, final double lllllllllllllIIIIIIIIlIIIllIIlll) {
        super(lllllllllllllIIIIIIIIlIIIllIllll, lllllllllllllIIIIIIIIlIIIllIlIIl, lllllllllllllIIIIIIIIlIIIllIllIl, lllllllllllllIIIIIIIIlIIIllIIlll);
    }
    
    @Override
    protected void moveAlongTrack(final BlockPos lllllllllllllIIIIIIIIlIIIlIIllll, final IBlockState lllllllllllllIIIIIIIIlIIIlIIlllI) {
        super.moveAlongTrack(lllllllllllllIIIIIIIIlIIIlIIllll, lllllllllllllIIIIIIIIlIIIlIIlllI);
        double lllllllllllllIIIIIIIIlIIIlIIllIl = this.pushX * this.pushX + this.pushZ * this.pushZ;
        if (lllllllllllllIIIIIIIIlIIIlIIllIl > 1.0E-4 && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.001) {
            lllllllllllllIIIIIIIIlIIIlIIllIl = MathHelper.sqrt(lllllllllllllIIIIIIIIlIIIlIIllIl);
            this.pushX /= lllllllllllllIIIIIIIIlIIIlIIllIl;
            this.pushZ /= lllllllllllllIIIIIIIIlIIIlIIllIl;
            if (this.pushX * this.motionX + this.pushZ * this.motionZ < 0.0) {
                this.pushX = 0.0;
                this.pushZ = 0.0;
            }
            else {
                final double lllllllllllllIIIIIIIIlIIIlIIllII = lllllllllllllIIIIIIIIlIIIlIIllIl / this.getMaximumSpeed();
                this.pushX *= lllllllllllllIIIIIIIIlIIIlIIllII;
                this.pushZ *= lllllllllllllIIIIIIIIlIIIlIIllII;
            }
        }
    }
    
    @Override
    public Type getType() {
        return Type.FURNACE;
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer lllllllllllllIIIIIIIIlIIIIlllIII, final EnumHand lllllllllllllIIIIIIIIlIIIIllIIll) {
        final ItemStack lllllllllllllIIIIIIIIlIIIIllIllI = lllllllllllllIIIIIIIIlIIIIlllIII.getHeldItem(lllllllllllllIIIIIIIIlIIIIllIIll);
        if (lllllllllllllIIIIIIIIlIIIIllIllI.getItem() == Items.COAL && this.fuel + 3600 <= 32000) {
            if (!lllllllllllllIIIIIIIIlIIIIlllIII.capabilities.isCreativeMode) {
                lllllllllllllIIIIIIIIlIIIIllIllI.func_190918_g(1);
            }
            this.fuel += 3600;
        }
        this.pushX = this.posX - lllllllllllllIIIIIIIIlIIIIlllIII.posX;
        this.pushZ = this.posZ - lllllllllllllIIIIIIIIlIIIIlllIII.posZ;
        return true;
    }
    
    @Override
    public void killMinecart(final DamageSource lllllllllllllIIIIIIIIlIIIlIlIllI) {
        super.killMinecart(lllllllllllllIIIIIIIIlIIIlIlIllI);
        if (!lllllllllllllIIIIIIIIlIIIlIlIllI.isExplosion() && this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.entityDropItem(new ItemStack(Blocks.FURNACE, 1), 0.0f);
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIIIIIIIIlIIIIlIlllI) {
        super.writeEntityToNBT(lllllllllllllIIIIIIIIlIIIIlIlllI);
        lllllllllllllIIIIIIIIlIIIIlIlllI.setDouble("PushX", this.pushX);
        lllllllllllllIIIIIIIIlIIIIlIlllI.setDouble("PushZ", this.pushZ);
        lllllllllllllIIIIIIIIlIIIIlIlllI.setShort("Fuel", (short)this.fuel);
    }
    
    static {
        POWERED = EntityDataManager.createKey(EntityMinecartFurnace.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    protected double getMaximumSpeed() {
        return 0.2;
    }
    
    public static void registerFixesMinecartFurnace(final DataFixer lllllllllllllIIIIIIIIlIIIllIIlIl) {
        EntityMinecart.registerFixesMinecart(lllllllllllllIIIIIIIIlIIIllIIlIl, EntityMinecartFurnace.class);
    }
    
    @Override
    public IBlockState getDefaultDisplayTile() {
        return (this.isMinecartPowered() ? Blocks.LIT_FURNACE : Blocks.FURNACE).getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, EnumFacing.NORTH);
    }
    
    @Override
    protected void applyDrag() {
        double lllllllllllllIIIIIIIIlIIIlIIIIlI = this.pushX * this.pushX + this.pushZ * this.pushZ;
        if (lllllllllllllIIIIIIIIlIIIlIIIIlI > 1.0E-4) {
            lllllllllllllIIIIIIIIlIIIlIIIIlI = MathHelper.sqrt(lllllllllllllIIIIIIIIlIIIlIIIIlI);
            this.pushX /= lllllllllllllIIIIIIIIlIIIlIIIIlI;
            this.pushZ /= lllllllllllllIIIIIIIIlIIIlIIIIlI;
            final double lllllllllllllIIIIIIIIlIIIlIIIIIl = 1.0;
            this.motionX *= 0.800000011920929;
            this.motionY *= 0.0;
            this.motionZ *= 0.800000011920929;
            this.motionX += this.pushX * 1.0;
            this.motionZ += this.pushZ * 1.0;
        }
        else {
            this.motionX *= 0.9800000190734863;
            this.motionY *= 0.0;
            this.motionZ *= 0.9800000190734863;
        }
        super.applyDrag();
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.fuel > 0) {
            --this.fuel;
        }
        if (this.fuel <= 0) {
            this.pushX = 0.0;
            this.pushZ = 0.0;
        }
        this.setMinecartPowered(this.fuel > 0);
        if (this.isMinecartPowered() && this.rand.nextInt(4) == 0) {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.8, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    protected void setMinecartPowered(final boolean lllllllllllllIIIIIIIIlIIIIIlllll) {
        this.dataManager.set(EntityMinecartFurnace.POWERED, lllllllllllllIIIIIIIIlIIIIIlllll);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityMinecartFurnace.POWERED, false);
    }
    
    protected boolean isMinecartPowered() {
        return this.dataManager.get(EntityMinecartFurnace.POWERED);
    }
    
    public EntityMinecartFurnace(final World lllllllllllllIIIIIIIIlIIIlllIllI) {
        super(lllllllllllllIIIIIIIIlIIIlllIllI);
    }
}
