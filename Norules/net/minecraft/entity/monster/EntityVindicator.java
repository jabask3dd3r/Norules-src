package net.minecraft.entity.monster;

import com.google.common.base.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;

public class EntityVindicator extends AbstractIllager
{
    private static final /* synthetic */ Predicate<Entity> field_190644_c;
    private /* synthetic */ boolean field_190643_b;
    
    public EntityVindicator(final World lllllllllllllllIllIllIIIllIlIIll) {
        super(lllllllllllllllIllIllIIIllIlIIll);
        this.setSize(0.6f, 1.95f);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.field_191268_hm;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllllIllIllIIIlIIIlIlI, @Nullable final IEntityLivingData lllllllllllllllIllIllIIIlIIIIlIl) {
        final IEntityLivingData lllllllllllllllIllIllIIIlIIIlIII = super.onInitialSpawn(lllllllllllllllIllIllIIIlIIIlIlI, lllllllllllllllIllIllIIIlIIIIlIl);
        this.setEquipmentBasedOnDifficulty(lllllllllllllllIllIllIIIlIIIlIlI);
        this.setEnchantmentBasedOnDifficulty(lllllllllllllllIllIllIIIlIIIlIlI);
        return lllllllllllllllIllIllIIIlIIIlIII;
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        this.func_190636_a(this.getAttackTarget() != null);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIllIllIIIlIIlIIlI) {
        super.readEntityFromNBT(lllllllllllllllIllIllIIIlIIlIIlI);
        if (lllllllllllllllIllIllIIIlIIlIIlI.hasKey("Johnny", 99)) {
            this.field_190643_b = lllllllllllllllIllIllIIIlIIlIIlI.getBoolean("Johnny");
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIllIllIIIlIIllIll) {
        super.writeEntityToNBT(lllllllllllllllIllIllIIIlIIllIll);
        if (this.field_190643_b) {
            lllllllllllllllIllIllIIIlIIllIll.setBoolean("Johnny", true);
        }
    }
    
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191186_av;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0, false));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[] { EntityVindicator.class }));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityVillager.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityIronGolem.class, true));
        this.targetTasks.addTask(4, new AIJohnnyAttack(this));
    }
    
    @Override
    public void setCustomNameTag(final String lllllllllllllllIllIllIIIIlllIIll) {
        super.setCustomNameTag(lllllllllllllllIllIllIIIIlllIIll);
        if (!this.field_190643_b && "Johnny".equals(lllllllllllllllIllIllIIIIlllIIll)) {
            this.field_190643_b = true;
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllllIllIllIIIIllIllIl) {
        return SoundEvents.field_191270_ho;
    }
    
    public void func_190636_a(final boolean lllllllllllllllIllIllIIIlIlIIllI) {
        this.func_193079_a(1, lllllllllllllllIllIllIIIlIlIIllI);
    }
    
    public boolean func_190639_o() {
        return this.func_193078_a(1);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3499999940395355);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.field_191269_hn;
    }
    
    @Override
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance lllllllllllllllIllIllIIIlIIIIIIl) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
    }
    
    public static void func_190641_b(final DataFixer lllllllllllllllIllIllIIIllIlIIIl) {
        EntityLiving.registerFixesMob(lllllllllllllllIllIllIIIllIlIIIl, EntityVindicator.class);
    }
    
    @Override
    public boolean isOnSameTeam(final Entity lllllllllllllllIllIllIIIIllllIIl) {
        return super.isOnSameTeam(lllllllllllllllIllIllIIIIllllIIl) || (lllllllllllllllIllIllIIIIllllIIl instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIllIllIIIIllllIIl).getCreatureAttribute() == EnumCreatureAttribute.ILLAGER && (this.getTeam() == null && lllllllllllllllIllIllIIIIllllIIl.getTeam() == null));
    }
    
    @Override
    public IllagerArmPose func_193077_p() {
        return this.func_190639_o() ? IllagerArmPose.ATTACKING : IllagerArmPose.CROSSED;
    }
    
    static {
        field_190644_c = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIlllIlllllllIllIII) {
                return lllllllllllllIIlllIlllllllIllIII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIIlllIlllllllIllIII).func_190631_cK();
            }
        };
    }
    
    static class AIJohnnyAttack extends EntityAINearestAttackableTarget<EntityLivingBase>
    {
        public AIJohnnyAttack(final EntityVindicator lllllllllllllIllIlIlIIlIlIlIIIII) {
            super(lllllllllllllIllIlIlIIlIlIlIIIII, EntityLivingBase.class, 0, true, true, EntityVindicator.field_190644_c);
        }
        
        @Override
        public boolean shouldExecute() {
            return ((EntityVindicator)this.taskOwner).field_190643_b && super.shouldExecute();
        }
    }
}
