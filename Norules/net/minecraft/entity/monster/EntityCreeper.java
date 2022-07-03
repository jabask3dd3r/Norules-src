package net.minecraft.entity.monster;

import net.minecraft.util.datafix.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.network.datasync.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;

public class EntityCreeper extends EntityMob
{
    private /* synthetic */ int lastActiveTime;
    private /* synthetic */ int timeSinceIgnited;
    private /* synthetic */ int droppedSkulls;
    private /* synthetic */ int explosionRadius;
    private static final /* synthetic */ DataParameter<Boolean> IGNITED;
    private static final /* synthetic */ DataParameter<Boolean> POWERED;
    private static final /* synthetic */ DataParameter<Integer> STATE;
    private /* synthetic */ int fuseTime;
    
    public static void registerFixesCreeper(final DataFixer lllllllllllllIllIlIllIIlIIlllIlI) {
        EntityLiving.registerFixesMob(lllllllllllllIllIlIllIIlIIlllIlI, EntityCreeper.class);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllIllIlIllIIlIIIlIlII) {
        return true;
    }
    
    private void explode() {
        if (!this.world.isRemote) {
            final boolean lllllllllllllIllIlIllIIIlllIlIlI = this.world.getGameRules().getBoolean("mobGriefing");
            final float lllllllllllllIllIlIllIIIlllIlIIl = this.getPowered() ? 2.0f : 1.0f;
            this.dead = true;
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius * lllllllllllllIllIlIllIIIlllIlIIl, lllllllllllllIllIlIllIIIlllIlIlI);
            this.setDead();
            this.func_190741_do();
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIllIlIllIIlIIlIIllI) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }
    
    private void func_190741_do() {
        final Collection<PotionEffect> lllllllllllllIllIlIllIIIllIlllll = this.getActivePotionEffects();
        if (!lllllllllllllIllIlIllIIIllIlllll.isEmpty()) {
            final EntityAreaEffectCloud lllllllllllllIllIlIllIIIllIllllI = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
            lllllllllllllIllIlIllIIIllIllllI.setRadius(2.5f);
            lllllllllllllIllIlIllIIIllIllllI.setRadiusOnUse(-0.5f);
            lllllllllllllIllIlIllIIIllIllllI.setWaitTime(10);
            lllllllllllllIllIlIllIIIllIllllI.setDuration(lllllllllllllIllIlIllIIIllIllllI.getDuration() / 2);
            lllllllllllllIllIlIllIIIllIllllI.setRadiusPerTick(-lllllllllllllIllIlIllIIIllIllllI.getRadius() / lllllllllllllIllIlIllIIIllIllllI.getDuration());
            for (final PotionEffect lllllllllllllIllIlIllIIIllIlllIl : lllllllllllllIllIlIllIIIllIlllll) {
                lllllllllllllIllIlIllIIIllIllllI.addEffect(new PotionEffect(lllllllllllllIllIlIllIIIllIlllIl));
            }
            this.world.spawnEntityInWorld(lllllllllllllIllIlIllIIIllIllllI);
        }
    }
    
    public float getCreeperFlashIntensity(final float lllllllllllllIllIlIllIIlIIIIllIl) {
        return (this.lastActiveTime + (this.timeSinceIgnited - this.lastActiveTime) * lllllllllllllIllIlIllIIlIIIIllIl) / (this.fuseTime - 2);
    }
    
    static {
        STATE = EntityDataManager.createKey(EntityCreeper.class, DataSerializers.VARINT);
        POWERED = EntityDataManager.createKey(EntityCreeper.class, DataSerializers.BOOLEAN);
        IGNITED = EntityDataManager.createKey(EntityCreeper.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_CREEPER;
    }
    
    @Override
    protected boolean processInteract(final EntityPlayer lllllllllllllIllIlIllIIIllllIIIl, final EnumHand lllllllllllllIllIlIllIIIllllIlII) {
        final ItemStack lllllllllllllIllIlIllIIIllllIIll = lllllllllllllIllIlIllIIIllllIIIl.getHeldItem(lllllllllllllIllIlIllIIIllllIlII);
        if (lllllllllllllIllIlIllIIIllllIIll.getItem() == Items.FLINT_AND_STEEL) {
            this.world.playSound(lllllllllllllIllIlIllIIIllllIIIl, this.posX, this.posY, this.posZ, SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 1.0f, this.rand.nextFloat() * 0.4f + 0.8f);
            lllllllllllllIllIlIllIIIllllIIIl.swingArm(lllllllllllllIllIlIllIIIllllIlII);
            if (!this.world.isRemote) {
                this.ignite();
                lllllllllllllIllIlIllIIIllllIIll.damageItem(1, lllllllllllllIllIlIllIIIllllIIIl);
                return true;
            }
        }
        return super.processInteract(lllllllllllllIllIlIllIIIllllIIIl, lllllllllllllIllIlIllIIIllllIlII);
    }
    
    public EntityCreeper(final World lllllllllllllIllIlIllIIlIlIlIIlI) {
        super(lllllllllllllIllIlIllIIlIlIlIIlI);
        this.fuseTime = 30;
        this.explosionRadius = 3;
        this.setSize(0.6f, 1.7f);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityCreeper.STATE, -1);
        this.dataManager.register(EntityCreeper.POWERED, false);
        this.dataManager.register(EntityCreeper.IGNITED, false);
    }
    
    public boolean hasIgnited() {
        return this.dataManager.get(EntityCreeper.IGNITED);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIllIlIllIIlIIllIIII) {
        super.readEntityFromNBT(lllllllllllllIllIlIllIIlIIllIIII);
        this.dataManager.set(EntityCreeper.POWERED, lllllllllllllIllIlIllIIlIIllIIII.getBoolean("powered"));
        if (lllllllllllllIllIlIllIIlIIllIIII.hasKey("Fuse", 99)) {
            this.fuseTime = lllllllllllllIllIlIllIIlIIllIIII.getShort("Fuse");
        }
        if (lllllllllllllIllIlIllIIlIIllIIII.hasKey("ExplosionRadius", 99)) {
            this.explosionRadius = lllllllllllllIllIlIllIIlIIllIIII.getByte("ExplosionRadius");
        }
        if (lllllllllllllIllIlIllIIlIIllIIII.getBoolean("ignited")) {
            this.ignite();
        }
    }
    
    @Override
    public int getMaxFallHeight() {
        return (this.getAttackTarget() == null) ? 3 : (3 + (int)(this.getHealth() - 1.0f));
    }
    
    public boolean getPowered() {
        return this.dataManager.get(EntityCreeper.POWERED);
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt lllllllllllllIllIlIllIIIlllllIll) {
        super.onStruckByLightning(lllllllllllllIllIlIllIIIlllllIll);
        this.dataManager.set(EntityCreeper.POWERED, true);
    }
    
    @Override
    public void onUpdate() {
        if (this.isEntityAlive()) {
            this.lastActiveTime = this.timeSinceIgnited;
            if (this.hasIgnited()) {
                this.setCreeperState(1);
            }
            final int lllllllllllllIllIlIllIIlIIlIlIlI = this.getCreeperState();
            if (lllllllllllllIllIlIllIIlIIlIlIlI > 0 && this.timeSinceIgnited == 0) {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
            }
            this.timeSinceIgnited += lllllllllllllIllIlIllIIlIIlIlIlI;
            if (this.timeSinceIgnited < 0) {
                this.timeSinceIgnited = 0;
            }
            if (this.timeSinceIgnited >= this.fuseTime) {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }
        super.onUpdate();
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }
    
    public void incrementDroppedSkulls() {
        ++this.droppedSkulls;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIllIlIllIIlIIllIllI) {
        super.writeEntityToNBT(lllllllllllllIllIlIllIIlIIllIllI);
        if (this.dataManager.get(EntityCreeper.POWERED)) {
            lllllllllllllIllIlIllIIlIIllIllI.setBoolean("powered", true);
        }
        lllllllllllllIllIlIllIIlIIllIllI.setShort("Fuse", (short)this.fuseTime);
        lllllllllllllIllIlIllIIlIIllIllI.setByte("ExplosionRadius", (byte)this.explosionRadius);
        lllllllllllllIllIlIllIIlIIllIllI.setBoolean("ignited", this.hasIgnited());
    }
    
    public int getCreeperState() {
        return this.dataManager.get(EntityCreeper.STATE);
    }
    
    public void ignite() {
        this.dataManager.set(EntityCreeper.IGNITED, true);
    }
    
    public boolean isAIEnabled() {
        return this.droppedSkulls < 1 && this.world.getGameRules().getBoolean("doMobLoot");
    }
    
    @Override
    public void fall(final float lllllllllllllIllIlIllIIlIlIIIlII, final float lllllllllllllIllIlIllIIlIlIIIIII) {
        super.fall(lllllllllllllIllIlIllIIlIlIIIlII, lllllllllllllIllIlIllIIlIlIIIIII);
        this.timeSinceIgnited += (int)(lllllllllllllIllIlIllIIlIlIIIlII * 1.5f);
        if (this.timeSinceIgnited > this.fuseTime - 5) {
            this.timeSinceIgnited = this.fuseTime - 5;
        }
    }
    
    public void setCreeperState(final int lllllllllllllIllIlIllIIlIIIIIIll) {
        this.dataManager.set(EntityCreeper.STATE, lllllllllllllIllIlIllIIlIIIIIIll);
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllIllIlIllIIlIIIllIIl) {
        super.onDeath(lllllllllllllIllIlIllIIlIIIllIIl);
        if (this.world.getGameRules().getBoolean("doMobLoot")) {
            if (lllllllllllllIllIlIllIIlIIIllIIl.getEntity() instanceof EntitySkeleton) {
                final int lllllllllllllIllIlIllIIlIIIlllIl = Item.getIdFromItem(Items.RECORD_13);
                final int lllllllllllllIllIlIllIIlIIIlllII = Item.getIdFromItem(Items.RECORD_WAIT);
                final int lllllllllllllIllIlIllIIlIIIllIll = lllllllllllllIllIlIllIIlIIIlllIl + this.rand.nextInt(lllllllllllllIllIlIllIIlIIIlllII - lllllllllllllIllIlIllIIlIIIlllIl + 1);
                this.dropItem(Item.getItemById(lllllllllllllIllIlIllIIlIIIllIll), 1);
            }
            else if (lllllllllllllIllIlIllIIlIIIllIIl.getEntity() instanceof EntityCreeper && lllllllllllllIllIlIllIIlIIIllIIl.getEntity() != this && ((EntityCreeper)lllllllllllllIllIlIllIIlIIIllIIl.getEntity()).getPowered() && ((EntityCreeper)lllllllllllllIllIlIllIIlIIIllIIl.getEntity()).isAIEnabled()) {
                ((EntityCreeper)lllllllllllllIllIlIllIIlIIIllIIl.getEntity()).incrementDroppedSkulls();
                this.entityDropItem(new ItemStack(Items.SKULL, 1, 4), 0.0f);
            }
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICreeperSwell(this));
        this.tasks.addTask(3, new EntityAIAvoidEntity<Object>(this, EntityOcelot.class, 6.0f, 1.0, 1.2));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
    }
}
