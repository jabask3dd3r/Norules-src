package net.minecraft.entity.item;

import net.minecraft.item.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.network.datasync.*;
import net.minecraft.nbt.*;

public class EntityFireworkRocket extends Entity
{
    private static final /* synthetic */ DataParameter<Integer> field_191512_b;
    private /* synthetic */ EntityLivingBase field_191513_e;
    private /* synthetic */ int fireworkAge;
    private /* synthetic */ int lifetime;
    private static final /* synthetic */ DataParameter<ItemStack> FIREWORK_ITEM;
    
    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIlIllIIIIlllIlllIII) {
        if (lllllllllllllIlIllIIIIlllIlllIII == 17 && this.world.isRemote) {
            final ItemStack lllllllllllllIlIllIIIIlllIlllIll = this.dataManager.get(EntityFireworkRocket.FIREWORK_ITEM);
            final NBTTagCompound lllllllllllllIlIllIIIIlllIlllIlI = lllllllllllllIlIllIIIIlllIlllIll.func_190926_b() ? null : lllllllllllllIlIllIIIIlllIlllIll.getSubCompound("Fireworks");
            this.world.makeFireworks(this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, lllllllllllllIlIllIIIIlllIlllIlI);
        }
        super.handleStatusUpdate(lllllllllllllIlIllIIIIlllIlllIII);
    }
    
    public boolean func_191511_j() {
        return this.dataManager.get(EntityFireworkRocket.field_191512_b) > 0;
    }
    
    public static void registerFixesFireworkRocket(final DataFixer lllllllllllllIlIllIIIIlllIllIIll) {
        lllllllllllllIlIllIIIIlllIllIIll.registerWalker(FixTypes.ENTITY, new ItemStackData(EntityFireworkRocket.class, new String[] { "FireworksItem" }));
    }
    
    public EntityFireworkRocket(final World lllllllllllllIlIllIIIlIIIIIllIIl, final double lllllllllllllIlIllIIIlIIIIlIIIIl, final double lllllllllllllIlIllIIIlIIIIlIIIII, final double lllllllllllllIlIllIIIlIIIIIlllll, final ItemStack lllllllllllllIlIllIIIlIIIIIllllI) {
        super(lllllllllllllIlIllIIIlIIIIIllIIl);
        this.fireworkAge = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(lllllllllllllIlIllIIIlIIIIlIIIIl, lllllllllllllIlIllIIIlIIIIlIIIII, lllllllllllllIlIllIIIlIIIIIlllll);
        int lllllllllllllIlIllIIIlIIIIIlllIl = 1;
        if (!lllllllllllllIlIllIIIlIIIIIllllI.func_190926_b() && lllllllllllllIlIllIIIlIIIIIllllI.hasTagCompound()) {
            this.dataManager.set(EntityFireworkRocket.FIREWORK_ITEM, lllllllllllllIlIllIIIlIIIIIllllI.copy());
            final NBTTagCompound lllllllllllllIlIllIIIlIIIIIlllII = lllllllllllllIlIllIIIlIIIIIllllI.getTagCompound();
            final NBTTagCompound lllllllllllllIlIllIIIlIIIIIllIll = lllllllllllllIlIllIIIlIIIIIlllII.getCompoundTag("Fireworks");
            lllllllllllllIlIllIIIlIIIIIlllIl += lllllllllllllIlIllIIIlIIIIIllIll.getByte("Flight");
        }
        this.motionX = this.rand.nextGaussian() * 0.001;
        this.motionZ = this.rand.nextGaussian() * 0.001;
        this.motionY = 0.05;
        this.lifetime = 10 * lllllllllllllIlIllIIIlIIIIIlllIl + this.rand.nextInt(6) + this.rand.nextInt(7);
    }
    
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        if (this.func_191511_j()) {
            if (this.field_191513_e == null) {
                final Entity lllllllllllllIlIllIIIIllllllIIIl = this.world.getEntityByID(this.dataManager.get(EntityFireworkRocket.field_191512_b));
                if (lllllllllllllIlIllIIIIllllllIIIl instanceof EntityLivingBase) {
                    this.field_191513_e = (EntityLivingBase)lllllllllllllIlIllIIIIllllllIIIl;
                }
            }
            if (this.field_191513_e != null) {
                if (this.field_191513_e.isElytraFlying()) {
                    final Vec3d lllllllllllllIlIllIIIIllllllIIII = this.field_191513_e.getLookVec();
                    final double lllllllllllllIlIllIIIIlllllIllll = 1.5;
                    final double lllllllllllllIlIllIIIIlllllIlllI = 0.1;
                    final EntityLivingBase field_191513_e = this.field_191513_e;
                    field_191513_e.motionX += lllllllllllllIlIllIIIIllllllIIII.xCoord * 0.1 + (lllllllllllllIlIllIIIIllllllIIII.xCoord * 1.5 - this.field_191513_e.motionX) * 0.5;
                    final EntityLivingBase field_191513_e2 = this.field_191513_e;
                    field_191513_e2.motionY += lllllllllllllIlIllIIIIllllllIIII.yCoord * 0.1 + (lllllllllllllIlIllIIIIllllllIIII.yCoord * 1.5 - this.field_191513_e.motionY) * 0.5;
                    final EntityLivingBase field_191513_e3 = this.field_191513_e;
                    field_191513_e3.motionZ += lllllllllllllIlIllIIIIllllllIIII.zCoord * 0.1 + (lllllllllllllIlIllIIIIllllllIIII.zCoord * 1.5 - this.field_191513_e.motionZ) * 0.5;
                }
                this.setPosition(this.field_191513_e.posX, this.field_191513_e.posY, this.field_191513_e.posZ);
                this.motionX = this.field_191513_e.motionX;
                this.motionY = this.field_191513_e.motionY;
                this.motionZ = this.field_191513_e.motionZ;
            }
        }
        else {
            this.motionX *= 1.15;
            this.motionZ *= 1.15;
            this.motionY += 0.04;
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }
        final float lllllllllllllIlIllIIIIlllllIllIl = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, lllllllllllllIlIllIIIIlllllIllIl) * 57.29577951308232);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        if (this.fireworkAge == 0 && !this.isSilent()) {
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.AMBIENT, 3.0f, 1.0f);
        }
        ++this.fireworkAge;
        if (this.world.isRemote && this.fireworkAge % 2 < 2) {
            this.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, this.posX, this.posY - 0.3, this.posZ, this.rand.nextGaussian() * 0.05, -this.motionY * 0.5, this.rand.nextGaussian() * 0.05, new int[0]);
        }
        if (!this.world.isRemote && this.fireworkAge > this.lifetime) {
            this.world.setEntityState(this, (byte)17);
            this.func_191510_k();
            this.setDead();
        }
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityFireworkRocket.FIREWORK_ITEM, ItemStack.field_190927_a);
        this.dataManager.register(EntityFireworkRocket.field_191512_b, 0);
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIllIIIIlllIlIIlII) {
        this.fireworkAge = lllllllllllllIlIllIIIIlllIlIIlII.getInteger("Life");
        this.lifetime = lllllllllllllIlIllIIIIlllIlIIlII.getInteger("LifeTime");
        final NBTTagCompound lllllllllllllIlIllIIIIlllIlIIIll = lllllllllllllIlIllIIIIlllIlIIlII.getCompoundTag("FireworksItem");
        if (lllllllllllllIlIllIIIIlllIlIIIll != null) {
            final ItemStack lllllllllllllIlIllIIIIlllIlIIIlI = new ItemStack(lllllllllllllIlIllIIIIlllIlIIIll);
            if (!lllllllllllllIlIllIIIIlllIlIIIlI.func_190926_b()) {
                this.dataManager.set(EntityFireworkRocket.FIREWORK_ITEM, lllllllllllllIlIllIIIIlllIlIIIlI);
            }
        }
    }
    
    @Override
    public boolean isInRangeToRender3d(final double lllllllllllllIlIllIIIlIIIIlIllll, final double lllllllllllllIlIllIIIlIIIIlIlllI, final double lllllllllllllIlIllIIIlIIIIlIllIl) {
        return super.isInRangeToRender3d(lllllllllllllIlIllIIIlIIIIlIllll, lllllllllllllIlIllIIIlIIIIlIlllI, lllllllllllllIlIllIIIlIIIIlIllIl) && !this.func_191511_j();
    }
    
    public EntityFireworkRocket(final World lllllllllllllIlIllIIIlIIIlIIIIlI) {
        super(lllllllllllllIlIllIIIlIIIlIIIIlI);
        this.setSize(0.25f, 0.25f);
    }
    
    private void func_191510_k() {
        float lllllllllllllIlIllIIIIllllIllIll = 0.0f;
        final ItemStack lllllllllllllIlIllIIIIllllIllIlI = this.dataManager.get(EntityFireworkRocket.FIREWORK_ITEM);
        final NBTTagCompound lllllllllllllIlIllIIIIllllIllIIl = lllllllllllllIlIllIIIIllllIllIlI.func_190926_b() ? null : lllllllllllllIlIllIIIIllllIllIlI.getSubCompound("Fireworks");
        final NBTTagList lllllllllllllIlIllIIIIllllIllIII = (lllllllllllllIlIllIIIIllllIllIIl != null) ? lllllllllllllIlIllIIIIllllIllIIl.getTagList("Explosions", 10) : null;
        if (lllllllllllllIlIllIIIIllllIllIII != null && !lllllllllllllIlIllIIIIllllIllIII.hasNoTags()) {
            lllllllllllllIlIllIIIIllllIllIll = (float)(5 + lllllllllllllIlIllIIIIllllIllIII.tagCount() * 2);
        }
        if (lllllllllllllIlIllIIIIllllIllIll > 0.0f) {
            if (this.field_191513_e != null) {
                this.field_191513_e.attackEntityFrom(DamageSource.field_191552_t, (float)(5 + lllllllllllllIlIllIIIIllllIllIII.tagCount() * 2));
            }
            final double lllllllllllllIlIllIIIIllllIlIlll = 5.0;
            final Vec3d lllllllllllllIlIllIIIIllllIlIllI = new Vec3d(this.posX, this.posY, this.posZ);
            for (final EntityLivingBase lllllllllllllIlIllIIIIllllIlIlIl : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, this.getEntityBoundingBox().expandXyz(5.0))) {
                if (lllllllllllllIlIllIIIIllllIlIlIl != this.field_191513_e && this.getDistanceSqToEntity(lllllllllllllIlIllIIIIllllIlIlIl) <= 25.0) {
                    boolean lllllllllllllIlIllIIIIllllIlIlII = false;
                    for (int lllllllllllllIlIllIIIIllllIlIIll = 0; lllllllllllllIlIllIIIIllllIlIIll < 2; ++lllllllllllllIlIllIIIIllllIlIIll) {
                        final RayTraceResult lllllllllllllIlIllIIIIllllIlIIlI = this.world.rayTraceBlocks(lllllllllllllIlIllIIIIllllIlIllI, new Vec3d(lllllllllllllIlIllIIIIllllIlIlIl.posX, lllllllllllllIlIllIIIIllllIlIlIl.posY + lllllllllllllIlIllIIIIllllIlIlIl.height * 0.5 * lllllllllllllIlIllIIIIllllIlIIll, lllllllllllllIlIllIIIIllllIlIlIl.posZ), false, true, false);
                        if (lllllllllllllIlIllIIIIllllIlIIlI == null || lllllllllllllIlIllIIIIllllIlIIlI.typeOfHit == RayTraceResult.Type.MISS) {
                            lllllllllllllIlIllIIIIllllIlIlII = true;
                            break;
                        }
                    }
                    if (!lllllllllllllIlIllIIIIllllIlIlII) {
                        continue;
                    }
                    final float lllllllllllllIlIllIIIIllllIlIIIl = lllllllllllllIlIllIIIIllllIllIll * (float)Math.sqrt((5.0 - this.getDistanceToEntity(lllllllllllllIlIllIIIIllllIlIlIl)) / 5.0);
                    lllllllllllllIlIllIIIIllllIlIlIl.attackEntityFrom(DamageSource.field_191552_t, lllllllllllllIlIllIIIIllllIlIIIl);
                }
            }
        }
    }
    
    static {
        FIREWORK_ITEM = EntityDataManager.createKey(EntityFireworkRocket.class, DataSerializers.OPTIONAL_ITEM_STACK);
        field_191512_b = EntityDataManager.createKey(EntityFireworkRocket.class, DataSerializers.VARINT);
    }
    
    @Override
    public void setVelocity(final double lllllllllllllIlIllIIIIlllllllIlI, final double lllllllllllllIlIllIIIIlllllllIIl, final double lllllllllllllIlIllIIIIllllllllIl) {
        this.motionX = lllllllllllllIlIllIIIIlllllllIlI;
        this.motionY = lllllllllllllIlIllIIIIlllllllIIl;
        this.motionZ = lllllllllllllIlIllIIIIllllllllIl;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllllllllllllIlIllIIIIllllllllII = MathHelper.sqrt(lllllllllllllIlIllIIIIlllllllIlI * lllllllllllllIlIllIIIIlllllllIlI + lllllllllllllIlIllIIIIllllllllIl * lllllllllllllIlIllIIIIllllllllIl);
            this.rotationYaw = (float)(MathHelper.atan2(lllllllllllllIlIllIIIIlllllllIlI, lllllllllllllIlIllIIIIllllllllIl) * 57.29577951308232);
            this.rotationPitch = (float)(MathHelper.atan2(lllllllllllllIlIllIIIIlllllllIIl, lllllllllllllIlIllIIIIllllllllII) * 57.29577951308232);
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllIlIllIIIlIIIIlllIll) {
        return lllllllllllllIlIllIIIlIIIIlllIll < 4096.0 && !this.func_191511_j();
    }
    
    public EntityFireworkRocket(final World lllllllllllllIlIllIIIlIIIIIIlIII, final ItemStack lllllllllllllIlIllIIIlIIIIIIlIll, final EntityLivingBase lllllllllllllIlIllIIIlIIIIIIlIlI) {
        this(lllllllllllllIlIllIIIlIIIIIIlIII, lllllllllllllIlIllIIIlIIIIIIlIlI.posX, lllllllllllllIlIllIIIlIIIIIIlIlI.posY, lllllllllllllIlIllIIIlIIIIIIlIlI.posZ, lllllllllllllIlIllIIIlIIIIIIlIll);
        this.dataManager.set(EntityFireworkRocket.field_191512_b, lllllllllllllIlIllIIIlIIIIIIlIlI.getEntityId());
        this.field_191513_e = lllllllllllllIlIllIIIlIIIIIIlIlI;
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIllIIIIlllIlIlIll) {
        lllllllllllllIlIllIIIIlllIlIlIll.setInteger("Life", this.fireworkAge);
        lllllllllllllIlIllIIIIlllIlIlIll.setInteger("LifeTime", this.lifetime);
        final ItemStack lllllllllllllIlIllIIIIlllIlIllIl = this.dataManager.get(EntityFireworkRocket.FIREWORK_ITEM);
        if (!lllllllllllllIlIllIIIIlllIlIllIl.func_190926_b()) {
            lllllllllllllIlIllIIIIlllIlIlIll.setTag("FireworksItem", lllllllllllllIlIllIIIIlllIlIllIl.writeToNBT(new NBTTagCompound()));
        }
    }
}
