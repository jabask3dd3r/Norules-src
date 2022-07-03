package net.minecraft.entity.monster;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;

public class EntityPigZombie extends EntityZombie
{
    private static final /* synthetic */ UUID ATTACK_SPEED_BOOST_MODIFIER_UUID;
    private /* synthetic */ UUID angerTargetUUID;
    private /* synthetic */ int angerLevel;
    private /* synthetic */ int randomSoundDelay;
    private static final /* synthetic */ AttributeModifier ATTACK_SPEED_BOOST_MODIFIER;
    
    @Override
    protected ItemStack func_190732_dj() {
        return ItemStack.field_190927_a;
    }
    
    private void becomeAngryAt(final Entity lllllllllllllllllllIIIIlIIllIIll) {
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);
        if (lllllllllllllllllllIIIIlIIllIIll instanceof EntityLivingBase) {
            this.setRevengeTarget((EntityLivingBase)lllllllllllllllllllIIIIlIIllIIll);
        }
    }
    
    public boolean processInteract(final EntityPlayer lllllllllllllllllllIIIIlIIlIlIIl, final EnumHand lllllllllllllllllllIIIIlIIlIlIII) {
        return false;
    }
    
    static {
        ATTACK_SPEED_BOOST_MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
        ATTACK_SPEED_BOOST_MODIFIER = new AttributeModifier(EntityPigZombie.ATTACK_SPEED_BOOST_MODIFIER_UUID, "Attacking speed boost", 0.05, 0).setSaved(false);
    }
    
    @Override
    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ZOMBIE_PIGMAN;
    }
    
    public boolean isAngry() {
        return this.angerLevel > 0;
    }
    
    @Override
    public void setRevengeTarget(@Nullable final EntityLivingBase lllllllllllllllllllIIIIlIllIllll) {
        super.setRevengeTarget(lllllllllllllllllllIIIIlIllIllll);
        if (lllllllllllllllllllIIIIlIllIllll != null) {
            this.angerTargetUUID = lllllllllllllllllllIIIIlIllIllll.getUniqueID();
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllllllllIIIIlIIlIllIl) {
        return SoundEvents.ENTITY_ZOMBIE_PIG_HURT;
    }
    
    public static void registerFixesPigZombie(final DataFixer lllllllllllllllllllIIIIlIlIllIII) {
        EntityLiving.registerFixesMob(lllllllllllllllllllIIIIlIlIllIII, EntityPigZombie.class);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllllllIIIIlIlIIlIll) {
        super.readEntityFromNBT(lllllllllllllllllllIIIIlIlIIlIll);
        this.angerLevel = lllllllllllllllllllIIIIlIlIIlIll.getShort("Anger");
        final String lllllllllllllllllllIIIIlIlIIlIlI = lllllllllllllllllllIIIIlIlIIlIll.getString("HurtBy");
        if (!lllllllllllllllllllIIIIlIlIIlIlI.isEmpty()) {
            this.angerTargetUUID = UUID.fromString(lllllllllllllllllllIIIIlIlIIlIlI);
            final EntityPlayer lllllllllllllllllllIIIIlIlIIlIIl = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(lllllllllllllllllllIIIIlIlIIlIIl);
            if (lllllllllllllllllllIIIIlIlIIlIIl != null) {
                this.attackingPlayer = lllllllllllllllllllIIIIlIlIIlIIl;
                this.recentlyHit = this.getRevengeTimer();
            }
        }
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_DEATH;
    }
    
    public EntityPigZombie(final World lllllllllllllllllllIIIIlIlllIlIl) {
        super(lllllllllllllllllllIIIIlIlllIlIl);
        this.isImmuneToFire = true;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllllllIIIIlIIllllll, final float lllllllllllllllllllIIIIlIIlllllI) {
        if (this.isEntityInvulnerable(lllllllllllllllllllIIIIlIIllllll)) {
            return false;
        }
        final Entity lllllllllllllllllllIIIIlIIllllIl = lllllllllllllllllllIIIIlIIllllll.getEntity();
        if (lllllllllllllllllllIIIIlIIllllIl instanceof EntityPlayer) {
            this.becomeAngryAt(lllllllllllllllllllIIIIlIIllllIl);
        }
        return super.attackEntityFrom(lllllllllllllllllllIIIIlIIllllll, lllllllllllllllllllIIIIlIIlllllI);
    }
    
    @Override
    protected void updateAITasks() {
        final IAttributeInstance lllllllllllllllllllIIIIlIllIIlII = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        if (this.isAngry()) {
            if (!this.isChild() && !lllllllllllllllllllIIIIlIllIIlII.hasModifier(EntityPigZombie.ATTACK_SPEED_BOOST_MODIFIER)) {
                lllllllllllllllllllIIIIlIllIIlII.applyModifier(EntityPigZombie.ATTACK_SPEED_BOOST_MODIFIER);
            }
            --this.angerLevel;
        }
        else if (lllllllllllllllllllIIIIlIllIIlII.hasModifier(EntityPigZombie.ATTACK_SPEED_BOOST_MODIFIER)) {
            lllllllllllllllllllIIIIlIllIIlII.removeModifier(EntityPigZombie.ATTACK_SPEED_BOOST_MODIFIER);
        }
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound(SoundEvents.ENTITY_ZOMBIE_PIG_ANGRY, this.getSoundVolume() * 2.0f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 1.8f);
        }
        if (this.angerLevel > 0 && this.angerTargetUUID != null && this.getAITarget() == null) {
            final EntityPlayer lllllllllllllllllllIIIIlIllIIIll = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(lllllllllllllllllllIIIIlIllIIIll);
            this.attackingPlayer = lllllllllllllllllllIIIIlIllIIIll;
            this.recentlyHit = this.getRevengeTimer();
        }
        super.updateAITasks();
    }
    
    @Override
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance lllllllllllllllllllIIIIlIIlIIlIl) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_PIG_AMBIENT;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllllllIIIIlIlIlIIIl) {
        super.writeEntityToNBT(lllllllllllllllllllIIIIlIlIlIIIl);
        lllllllllllllllllllIIIIlIlIlIIIl.setShort("Anger", (short)this.angerLevel);
        if (this.angerTargetUUID != null) {
            lllllllllllllllllllIIIIlIlIlIIIl.setString("HurtBy", this.angerTargetUUID.toString());
        }
        else {
            lllllllllllllllllllIIIIlIlIlIIIl.setString("HurtBy", "");
        }
    }
    
    @Override
    protected void applyEntityAI() {
        this.targetTasks.addTask(1, new AIHurtByAggressor(this));
        this.targetTasks.addTask(2, new AITargetAggressor(this));
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
    
    @Override
    public boolean func_191990_c(final EntityPlayer lllllllllllllllllllIIIIlIIlIIIII) {
        return this.isAngry();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(EntityPigZombie.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(0.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0);
    }
    
    static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        @Override
        public boolean shouldExecute() {
            return ((EntityPigZombie)this.taskOwner).isAngry() && super.shouldExecute();
        }
        
        public AITargetAggressor(final EntityPigZombie lllllllllllllIIlIlIllIllIlIIIIIl) {
            super(lllllllllllllIIlIlIllIllIlIIIIIl, EntityPlayer.class, true);
        }
    }
    
    static class AIHurtByAggressor extends EntityAIHurtByTarget
    {
        public AIHurtByAggressor(final EntityPigZombie lllllllllllllIIIlIIllIlIIlIlIIIl) {
            super(lllllllllllllIIIlIIllIlIIlIlIIIl, true, (Class<?>[])new Class[0]);
        }
        
        @Override
        protected void setEntityAttackTarget(final EntityCreature lllllllllllllIIIlIIllIlIIlIIlIlI, final EntityLivingBase lllllllllllllIIIlIIllIlIIlIIlIIl) {
            super.setEntityAttackTarget(lllllllllllllIIIlIIllIlIIlIIlIlI, lllllllllllllIIIlIIllIlIIlIIlIIl);
            if (lllllllllllllIIIlIIllIlIIlIIlIlI instanceof EntityPigZombie) {
                ((EntityPigZombie)lllllllllllllIIIlIIllIlIIlIIlIlI).becomeAngryAt(lllllllllllllIIIlIIllIlIIlIIlIIl);
            }
        }
    }
}
