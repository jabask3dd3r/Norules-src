package net.minecraft.entity.item;

import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.datasync.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.util.text.translation.*;

public class EntityItem extends Entity
{
    private /* synthetic */ int delayBeforeCanPickup;
    private /* synthetic */ int age;
    public /* synthetic */ float hoverStart;
    private /* synthetic */ String owner;
    private /* synthetic */ int health;
    private /* synthetic */ String thrower;
    private static final /* synthetic */ DataParameter<ItemStack> ITEM;
    
    @Override
    protected void dealFireDamage(final int llllllllllllllllllIIllllIlIIllIl) {
        this.attackEntityFrom(DamageSource.inFire, (float)llllllllllllllllllIIllllIlIIllIl);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        ITEM = EntityDataManager.createKey(EntityItem.class, DataSerializers.OPTIONAL_ITEM_STACK);
    }
    
    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }
    
    public boolean cannotPickup() {
        return this.delayBeforeCanPickup > 0;
    }
    
    @Override
    protected void entityInit() {
        this.getDataManager().register(EntityItem.ITEM, ItemStack.field_190927_a);
    }
    
    public EntityItem(final World llllllllllllllllllIIlllllIIlIlll, final double llllllllllllllllllIIlllllIIlIllI, final double llllllllllllllllllIIlllllIIlIlIl, final double llllllllllllllllllIIlllllIIlIlII, final ItemStack llllllllllllllllllIIlllllIIlIIll) {
        this(llllllllllllllllllIIlllllIIlIlll, llllllllllllllllllIIlllllIIlIllI, llllllllllllllllllIIlllllIIlIlIl, llllllllllllllllllIIlllllIIlIlII);
        this.setEntityItemStack(llllllllllllllllllIIlllllIIlIIll);
    }
    
    public void setNoPickupDelay() {
        this.delayBeforeCanPickup = 0;
    }
    
    public void setOwner(final String llllllllllllllllllIIllllIIIIIIlI) {
        this.owner = llllllllllllllllllIIllllIIIIIIlI;
    }
    
    public EntityItem(final World llllllllllllllllllIIlllllIIIllII) {
        super(llllllllllllllllllIIlllllIIIllII);
        this.health = 5;
        this.hoverStart = (float)(Math.random() * 3.141592653589793 * 2.0);
        this.setSize(0.25f, 0.25f);
        this.setEntityItemStack(ItemStack.field_190927_a);
    }
    
    @Override
    public void onUpdate() {
        if (this.getEntityItem().func_190926_b()) {
            this.setDead();
        }
        else {
            super.onUpdate();
            if (this.delayBeforeCanPickup > 0 && this.delayBeforeCanPickup != 32767) {
                --this.delayBeforeCanPickup;
            }
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            final double llllllllllllllllllIIllllIlllllIl = this.motionX;
            final double llllllllllllllllllIIllllIlllllII = this.motionY;
            final double llllllllllllllllllIIllllIllllIll = this.motionZ;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.03999999910593033;
            }
            if (this.world.isRemote) {
                this.noClip = false;
            }
            else {
                this.noClip = this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0, this.posZ);
            }
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            final boolean llllllllllllllllllIIllllIllllIlI = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;
            if (llllllllllllllllllIIllllIllllIlI || this.ticksExisted % 25 == 0) {
                if (this.world.getBlockState(new BlockPos(this)).getMaterial() == Material.LAVA) {
                    this.motionY = 0.20000000298023224;
                    this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                    this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
                    this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
                }
                if (!this.world.isRemote) {
                    this.searchForOtherItemsNearby();
                }
            }
            float llllllllllllllllllIIllllIllllIIl = 0.98f;
            if (this.onGround) {
                llllllllllllllllllIIllllIllllIIl = this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ))).getBlock().slipperiness * 0.98f;
            }
            this.motionX *= llllllllllllllllllIIllllIllllIIl;
            this.motionY *= 0.9800000190734863;
            this.motionZ *= llllllllllllllllllIIllllIllllIIl;
            if (this.onGround) {
                this.motionY *= -0.5;
            }
            if (this.age != -32768) {
                ++this.age;
            }
            this.handleWaterMovement();
            if (!this.world.isRemote) {
                final double llllllllllllllllllIIllllIllllIII = this.motionX - llllllllllllllllllIIllllIlllllIl;
                final double llllllllllllllllllIIllllIlllIlll = this.motionY - llllllllllllllllllIIllllIlllllII;
                final double llllllllllllllllllIIllllIlllIllI = this.motionZ - llllllllllllllllllIIllllIllllIll;
                final double llllllllllllllllllIIllllIlllIlIl = llllllllllllllllllIIllllIllllIII * llllllllllllllllllIIllllIllllIII + llllllllllllllllllIIllllIlllIlll * llllllllllllllllllIIllllIlllIlll + llllllllllllllllllIIllllIlllIllI * llllllllllllllllllIIllllIlllIllI;
                if (llllllllllllllllllIIllllIlllIlIl > 0.01) {
                    this.isAirBorne = true;
                }
            }
            if (!this.world.isRemote && this.age >= 6000) {
                this.setDead();
            }
        }
    }
    
    private void searchForOtherItemsNearby() {
        for (final EntityItem llllllllllllllllllIIllllIllIIllI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityItem.class, this.getEntityBoundingBox().expand(0.5, 0.0, 0.5))) {
            this.combineItems(llllllllllllllllllIIllllIllIIllI);
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllllIIllllIlIIIIll, final float llllllllllllllllllIIllllIlIIIIlI) {
        if (this.isEntityInvulnerable(llllllllllllllllllIIllllIlIIIIll)) {
            return false;
        }
        if (!this.getEntityItem().func_190926_b() && this.getEntityItem().getItem() == Items.NETHER_STAR && llllllllllllllllllIIllllIlIIIIll.isExplosion()) {
            return false;
        }
        this.setBeenAttacked();
        this.health -= (int)llllllllllllllllllIIllllIlIIIIlI;
        if (this.health <= 0) {
            this.setDead();
        }
        return false;
    }
    
    public void setEntityItemStack(final ItemStack llllllllllllllllllIIllllIIIIlIll) {
        this.getDataManager().set(EntityItem.ITEM, llllllllllllllllllIIllllIIIIlIll);
        this.getDataManager().setDirty(EntityItem.ITEM);
    }
    
    public void setDefaultPickupDelay() {
        this.delayBeforeCanPickup = 10;
    }
    
    @Nullable
    @Override
    public Entity changeDimension(final int llllllllllllllllllIIllllIIIlIlIl) {
        final Entity llllllllllllllllllIIllllIIIlIlll = super.changeDimension(llllllllllllllllllIIllllIIIlIlIl);
        if (!this.world.isRemote && llllllllllllllllllIIllllIIIlIlll instanceof EntityItem) {
            ((EntityItem)llllllllllllllllllIIllllIIIlIlll).searchForOtherItemsNearby();
        }
        return llllllllllllllllllIIllllIIIlIlll;
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void setNoDespawn() {
        this.age = -6000;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllllIIllllIIllIlII) {
        this.health = llllllllllllllllllIIllllIIllIlII.getShort("Health");
        this.age = llllllllllllllllllIIllllIIllIlII.getShort("Age");
        if (llllllllllllllllllIIllllIIllIlII.hasKey("PickupDelay")) {
            this.delayBeforeCanPickup = llllllllllllllllllIIllllIIllIlII.getShort("PickupDelay");
        }
        if (llllllllllllllllllIIllllIIllIlII.hasKey("Owner")) {
            this.owner = llllllllllllllllllIIllllIIllIlII.getString("Owner");
        }
        if (llllllllllllllllllIIllllIIllIlII.hasKey("Thrower")) {
            this.thrower = llllllllllllllllllIIllllIIllIlII.getString("Thrower");
        }
        final NBTTagCompound llllllllllllllllllIIllllIIllIIll = llllllllllllllllllIIllllIIllIlII.getCompoundTag("Item");
        this.setEntityItemStack(new ItemStack(llllllllllllllllllIIllllIIllIIll));
        if (this.getEntityItem().func_190926_b()) {
            this.setDead();
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllllIIllllIIlllIll) {
        llllllllllllllllllIIllllIIlllIll.setShort("Health", (short)this.health);
        llllllllllllllllllIIllllIIlllIll.setShort("Age", (short)this.age);
        llllllllllllllllllIIllllIIlllIll.setShort("PickupDelay", (short)this.delayBeforeCanPickup);
        if (this.getThrower() != null) {
            llllllllllllllllllIIllllIIlllIll.setString("Thrower", this.thrower);
        }
        if (this.getOwner() != null) {
            llllllllllllllllllIIllllIIlllIll.setString("Owner", this.owner);
        }
        if (!this.getEntityItem().func_190926_b()) {
            llllllllllllllllllIIllllIIlllIll.setTag("Item", this.getEntityItem().writeToNBT(new NBTTagCompound()));
        }
    }
    
    public String getThrower() {
        return this.thrower;
    }
    
    public void setInfinitePickupDelay() {
        this.delayBeforeCanPickup = 32767;
    }
    
    private boolean combineItems(final EntityItem llllllllllllllllllIIllllIlIllIIl) {
        if (llllllllllllllllllIIllllIlIllIIl == this) {
            return false;
        }
        if (!llllllllllllllllllIIllllIlIllIIl.isEntityAlive() || !this.isEntityAlive()) {
            return false;
        }
        final ItemStack llllllllllllllllllIIllllIlIlllII = this.getEntityItem();
        final ItemStack llllllllllllllllllIIllllIlIllIll = llllllllllllllllllIIllllIlIllIIl.getEntityItem();
        if (this.delayBeforeCanPickup == 32767 || llllllllllllllllllIIllllIlIllIIl.delayBeforeCanPickup == 32767) {
            return false;
        }
        if (this.age == -32768 || llllllllllllllllllIIllllIlIllIIl.age == -32768) {
            return false;
        }
        if (llllllllllllllllllIIllllIlIllIll.getItem() != llllllllllllllllllIIllllIlIlllII.getItem()) {
            return false;
        }
        if (llllllllllllllllllIIllllIlIllIll.hasTagCompound() ^ llllllllllllllllllIIllllIlIlllII.hasTagCompound()) {
            return false;
        }
        if (llllllllllllllllllIIllllIlIllIll.hasTagCompound() && !llllllllllllllllllIIllllIlIllIll.getTagCompound().equals(llllllllllllllllllIIllllIlIlllII.getTagCompound())) {
            return false;
        }
        if (llllllllllllllllllIIllllIlIllIll.getItem() == null) {
            return false;
        }
        if (llllllllllllllllllIIllllIlIllIll.getItem().getHasSubtypes() && llllllllllllllllllIIllllIlIllIll.getMetadata() != llllllllllllllllllIIllllIlIlllII.getMetadata()) {
            return false;
        }
        if (llllllllllllllllllIIllllIlIllIll.func_190916_E() < llllllllllllllllllIIllllIlIlllII.func_190916_E()) {
            return llllllllllllllllllIIllllIlIllIIl.combineItems(this);
        }
        if (llllllllllllllllllIIllllIlIllIll.func_190916_E() + llllllllllllllllllIIllllIlIlllII.func_190916_E() > llllllllllllllllllIIllllIlIllIll.getMaxStackSize()) {
            return false;
        }
        llllllllllllllllllIIllllIlIllIll.func_190917_f(llllllllllllllllllIIllllIlIlllII.func_190916_E());
        llllllllllllllllllIIllllIlIllIIl.delayBeforeCanPickup = Math.max(llllllllllllllllllIIllllIlIllIIl.delayBeforeCanPickup, this.delayBeforeCanPickup);
        llllllllllllllllllIIllllIlIllIIl.age = Math.min(llllllllllllllllllIIllllIlIllIIl.age, this.age);
        llllllllllllllllllIIllllIlIllIIl.setEntityItemStack(llllllllllllllllllIIllllIlIllIll);
        this.setDead();
        return true;
    }
    
    public EntityItem(final World llllllllllllllllllIIlllllIlIlIII, final double llllllllllllllllllIIlllllIlIllII, final double llllllllllllllllllIIlllllIlIlIll, final double llllllllllllllllllIIlllllIlIIlIl) {
        super(llllllllllllllllllIIlllllIlIlIII);
        this.health = 5;
        this.hoverStart = (float)(Math.random() * 3.141592653589793 * 2.0);
        this.setSize(0.25f, 0.25f);
        this.setPosition(llllllllllllllllllIIlllllIlIllII, llllllllllllllllllIIlllllIlIlIll, llllllllllllllllllIIlllllIlIIlIl);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612);
        this.motionY = 0.20000000298023224;
        this.motionZ = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612);
    }
    
    public static void registerFixesItem(final DataFixer llllllllllllllllllIIllllIlIIIIII) {
        llllllllllllllllllIIllllIlIIIIII.registerWalker(FixTypes.ENTITY, new ItemStackData(EntityItem.class, new String[] { "Item" }));
    }
    
    public void setAgeToCreativeDespawnTime() {
        this.age = 4800;
    }
    
    public void setPickupDelay(final int llllllllllllllllllIIlllIlllIlIIl) {
        this.delayBeforeCanPickup = llllllllllllllllllIIlllIlllIlIIl;
    }
    
    public void setThrower(final String llllllllllllllllllIIlllIlllllIll) {
        this.thrower = llllllllllllllllllIIlllIlllllIll;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void makeFakeItem() {
        this.setInfinitePickupDelay();
        this.age = 5999;
    }
    
    public ItemStack getEntityItem() {
        return this.getDataManager().get(EntityItem.ITEM);
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer llllllllllllllllllIIllllIIlIIlII) {
        if (!this.world.isRemote) {
            final ItemStack llllllllllllllllllIIllllIIlIlIII = this.getEntityItem();
            final Item llllllllllllllllllIIllllIIlIIlll = llllllllllllllllllIIllllIIlIlIII.getItem();
            final int llllllllllllllllllIIllllIIlIIllI = llllllllllllllllllIIllllIIlIlIII.func_190916_E();
            if (this.delayBeforeCanPickup == 0 && (this.owner == null || 6000 - this.age <= 200 || this.owner.equals(llllllllllllllllllIIllllIIlIIlII.getName())) && llllllllllllllllllIIllllIIlIIlII.inventory.addItemStackToInventory(llllllllllllllllllIIllllIIlIlIII)) {
                llllllllllllllllllIIllllIIlIIlII.onItemPickup(this, llllllllllllllllllIIllllIIlIIllI);
                if (llllllllllllllllllIIllllIIlIlIII.func_190926_b()) {
                    this.setDead();
                    llllllllllllllllllIIllllIIlIlIII.func_190920_e(llllllllllllllllllIIllllIIlIIllI);
                }
                llllllllllllllllllIIllllIIlIIlII.addStat(StatList.getObjectsPickedUpStats(llllllllllllllllllIIllllIIlIIlll), llllllllllllllllllIIllllIIlIIllI);
            }
        }
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.getCustomNameTag() : I18n.translateToLocal(String.valueOf(new StringBuilder("item.").append(this.getEntityItem().getUnlocalizedName())));
    }
    
    @Override
    public boolean handleWaterMovement() {
        if (this.world.handleMaterialAcceleration(this.getEntityBoundingBox(), Material.WATER, this)) {
            if (!this.inWater && !this.firstUpdate) {
                this.resetHeight();
            }
            this.inWater = true;
        }
        else {
            this.inWater = false;
        }
        return this.inWater;
    }
}
