package net.minecraft.entity.monster;

import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.item.*;

public class EntityEvoker extends EntitySpellcasterIllager
{
    private /* synthetic */ EntitySheep field_190763_bw;
    
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191185_au;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
    }
    
    @Nullable
    private EntitySheep func_190751_dj() {
        return this.field_190763_bw;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.field_191245_bo;
    }
    
    public EntityEvoker(final World lllllllllllllIlllIIlllIIlIlIIIlI) {
        super(lllllllllllllIlllIIlllIIlIlIIIlI);
        this.setSize(0.6f, 1.95f);
        this.experienceValue = 10;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.field_191243_bm;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlllIIlllIIlIIIlIlI) {
        super.writeEntityToNBT(lllllllllllllIlllIIlllIIlIIIlIlI);
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AICastingSpell((AICastingSpell)null));
        this.tasks.addTask(2, new EntityAIAvoidEntity<Object>(this, EntityPlayer.class, 8.0f, 0.6, 1.0));
        this.tasks.addTask(4, new AISummonSpell((AISummonSpell)null));
        this.tasks.addTask(5, new AIAttackSpell((AIAttackSpell)null));
        this.tasks.addTask(6, new AIWololoSpell());
        this.tasks.addTask(8, new EntityAIWander(this, 0.6));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[] { EntityEvoker.class }));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true).func_190882_b(300));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityVillager.class, false).func_190882_b(300));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityIronGolem.class, false));
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIlllIIlllIIIlllIlll) {
        return SoundEvents.field_191246_bp;
    }
    
    private void func_190748_a(@Nullable final EntitySheep lllllllllllllIlllIIlllIIIlllIIIl) {
        this.field_190763_bw = lllllllllllllIlllIIlllIIIlllIIIl;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(12.0);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
    }
    
    @Override
    public boolean isOnSameTeam(final Entity lllllllllllllIlllIIlllIIIllllIll) {
        if (lllllllllllllIlllIIlllIIIllllIll == null) {
            return false;
        }
        if (lllllllllllllIlllIIlllIIIllllIll == this) {
            return true;
        }
        if (super.isOnSameTeam(lllllllllllllIlllIIlllIIIllllIll)) {
            return true;
        }
        if (lllllllllllllIlllIIlllIIIllllIll instanceof EntityVex) {
            return this.isOnSameTeam(((EntityVex)lllllllllllllIlllIIlllIIIllllIll).func_190645_o());
        }
        return lllllllllllllIlllIIlllIIIllllIll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIlllIIlllIIIllllIll).getCreatureAttribute() == EnumCreatureAttribute.ILLAGER && (this.getTeam() == null && lllllllllllllIlllIIlllIIIllllIll.getTeam() == null);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlllIIlllIIlIIIlllI) {
        super.readEntityFromNBT(lllllllllllllIlllIIlllIIlIIIlllI);
    }
    
    @Override
    protected SoundEvent func_193086_dk() {
        return SoundEvents.field_191244_bn;
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
    }
    
    public static void func_190759_b(final DataFixer lllllllllllllIlllIIlllIIlIIlIlIl) {
        EntityLiving.registerFixesMob(lllllllllllllIlllIIlllIIlIIlIlIl, EntityEvoker.class);
    }
    
    class AIAttackSpell extends AIUseSpell
    {
        @Override
        protected int func_190869_f() {
            return 40;
        }
        
        @Override
        protected SoundEvent func_190871_k() {
            return SoundEvents.field_191247_bq;
        }
        
        private AIAttackSpell() {
        }
        
        private void func_190876_a(final double llllllllllllllllIllIllIIlIllllIl, final double llllllllllllllllIllIllIIllIIlIlI, final double llllllllllllllllIllIllIIlIlllIll, final double llllllllllllllllIllIllIIlIlllIlI, final float llllllllllllllllIllIllIIllIIIlll, final int llllllllllllllllIllIllIIlIlllIII) {
            BlockPos llllllllllllllllIllIllIIllIIIlIl = new BlockPos(llllllllllllllllIllIllIIlIllllIl, llllllllllllllllIllIllIIlIlllIlI, llllllllllllllllIllIllIIllIIlIlI);
            boolean llllllllllllllllIllIllIIllIIIlII = false;
            double llllllllllllllllIllIllIIllIIIIll = 0.0;
            while (true) {
                while (EntityEvoker.this.world.isBlockNormalCube(llllllllllllllllIllIllIIllIIIlIl, true) || !EntityEvoker.this.world.isBlockNormalCube(llllllllllllllllIllIllIIllIIIlIl.down(), true)) {
                    llllllllllllllllIllIllIIllIIIlIl = llllllllllllllllIllIllIIllIIIlIl.down();
                    if (llllllllllllllllIllIllIIllIIIlIl.getY() < MathHelper.floor(llllllllllllllllIllIllIIlIlllIll) - 1) {
                        if (llllllllllllllllIllIllIIllIIIlII) {
                            final EntityEvokerFangs llllllllllllllllIllIllIIllIIIIII = new EntityEvokerFangs(EntityEvoker.this.world, llllllllllllllllIllIllIIlIllllIl, llllllllllllllllIllIllIIllIIIlIl.getY() + llllllllllllllllIllIllIIllIIIIll, llllllllllllllllIllIllIIllIIlIlI, llllllllllllllllIllIllIIllIIIlll, llllllllllllllllIllIllIIlIlllIII, EntityEvoker.this);
                            EntityEvoker.this.world.spawnEntityInWorld(llllllllllllllllIllIllIIllIIIIII);
                        }
                        return;
                    }
                }
                if (!EntityEvoker.this.world.isAirBlock(llllllllllllllllIllIllIIllIIIlIl)) {
                    final IBlockState llllllllllllllllIllIllIIllIIIIlI = EntityEvoker.this.world.getBlockState(llllllllllllllllIllIllIIllIIIlIl);
                    final AxisAlignedBB llllllllllllllllIllIllIIllIIIIIl = llllllllllllllllIllIllIIllIIIIlI.getCollisionBoundingBox(EntityEvoker.this.world, llllllllllllllllIllIllIIllIIIlIl);
                    if (llllllllllllllllIllIllIIllIIIIIl != null) {
                        llllllllllllllllIllIllIIllIIIIll = llllllllllllllllIllIllIIllIIIIIl.maxY;
                    }
                }
                llllllllllllllllIllIllIIllIIIlII = true;
                continue;
            }
        }
        
        @Override
        protected void func_190868_j() {
            final EntityLivingBase llllllllllllllllIllIllIIlllIlIll = EntityEvoker.this.getAttackTarget();
            final double llllllllllllllllIllIllIIlllIlIlI = Math.min(llllllllllllllllIllIllIIlllIlIll.posY, EntityEvoker.this.posY);
            final double llllllllllllllllIllIllIIlllIlIIl = Math.max(llllllllllllllllIllIllIIlllIlIll.posY, EntityEvoker.this.posY) + 1.0;
            final float llllllllllllllllIllIllIIlllIlIII = (float)MathHelper.atan2(llllllllllllllllIllIllIIlllIlIll.posZ - EntityEvoker.this.posZ, llllllllllllllllIllIllIIlllIlIll.posX - EntityEvoker.this.posX);
            if (EntityEvoker.this.getDistanceSqToEntity(llllllllllllllllIllIllIIlllIlIll) < 9.0) {
                for (int llllllllllllllllIllIllIIlllIIlll = 0; llllllllllllllllIllIllIIlllIIlll < 5; ++llllllllllllllllIllIllIIlllIIlll) {
                    final float llllllllllllllllIllIllIIlllIIllI = llllllllllllllllIllIllIIlllIlIII + llllllllllllllllIllIllIIlllIIlll * 3.1415927f * 0.4f;
                    this.func_190876_a(EntityEvoker.this.posX + MathHelper.cos(llllllllllllllllIllIllIIlllIIllI) * 1.5, EntityEvoker.this.posZ + MathHelper.sin(llllllllllllllllIllIllIIlllIIllI) * 1.5, llllllllllllllllIllIllIIlllIlIlI, llllllllllllllllIllIllIIlllIlIIl, llllllllllllllllIllIllIIlllIIllI, 0);
                }
                for (int llllllllllllllllIllIllIIlllIIlIl = 0; llllllllllllllllIllIllIIlllIIlIl < 8; ++llllllllllllllllIllIllIIlllIIlIl) {
                    final float llllllllllllllllIllIllIIlllIIlII = llllllllllllllllIllIllIIlllIlIII + llllllllllllllllIllIllIIlllIIlIl * 3.1415927f * 2.0f / 8.0f + 1.2566371f;
                    this.func_190876_a(EntityEvoker.this.posX + MathHelper.cos(llllllllllllllllIllIllIIlllIIlII) * 2.5, EntityEvoker.this.posZ + MathHelper.sin(llllllllllllllllIllIllIIlllIIlII) * 2.5, llllllllllllllllIllIllIIlllIlIlI, llllllllllllllllIllIllIIlllIlIIl, llllllllllllllllIllIllIIlllIIlII, 3);
                }
            }
            else {
                for (int llllllllllllllllIllIllIIlllIIIll = 0; llllllllllllllllIllIllIIlllIIIll < 16; ++llllllllllllllllIllIllIIlllIIIll) {
                    final double llllllllllllllllIllIllIIlllIIIlI = 1.25 * (llllllllllllllllIllIllIIlllIIIll + 1);
                    final int llllllllllllllllIllIllIIlllIIIIl = 1 * llllllllllllllllIllIllIIlllIIIll;
                    this.func_190876_a(EntityEvoker.this.posX + MathHelper.cos(llllllllllllllllIllIllIIlllIlIII) * llllllllllllllllIllIllIIlllIIIlI, EntityEvoker.this.posZ + MathHelper.sin(llllllllllllllllIllIllIIlllIlIII) * llllllllllllllllIllIllIIlllIIIlI, llllllllllllllllIllIllIIlllIlIlI, llllllllllllllllIllIllIIlllIlIIl, llllllllllllllllIllIllIIlllIlIII, llllllllllllllllIllIllIIlllIIIIl);
                }
            }
        }
        
        @Override
        protected SpellType func_193320_l() {
            return SpellType.FANGS;
        }
        
        @Override
        protected int func_190872_i() {
            return 100;
        }
    }
    
    class AISummonSpell extends AIUseSpell
    {
        @Override
        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            }
            final int lllllllllllllIIlllllIlIIIIIlllIl = EntityEvoker.this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityVex.class, EntityEvoker.this.getEntityBoundingBox().expandXyz(16.0)).size();
            return EntityEvoker.this.rand.nextInt(8) + 1 > lllllllllllllIIlllllIlIIIIIlllIl;
        }
        
        @Override
        protected SpellType func_193320_l() {
            return SpellType.SUMMON_VEX;
        }
        
        @Override
        protected int func_190872_i() {
            return 340;
        }
        
        private AISummonSpell() {
        }
        
        @Override
        protected SoundEvent func_190871_k() {
            return SoundEvents.field_191248_br;
        }
        
        @Override
        protected int func_190869_f() {
            return 100;
        }
        
        @Override
        protected void func_190868_j() {
            for (int lllllllllllllIIlllllIlIIIIIlIIll = 0; lllllllllllllIIlllllIlIIIIIlIIll < 3; ++lllllllllllllIIlllllIlIIIIIlIIll) {
                final BlockPos lllllllllllllIIlllllIlIIIIIlIIlI = new BlockPos(EntityEvoker.this).add(-2 + EntityEvoker.this.rand.nextInt(5), 1, -2 + EntityEvoker.this.rand.nextInt(5));
                final EntityVex lllllllllllllIIlllllIlIIIIIlIIIl = new EntityVex(EntityEvoker.this.world);
                lllllllllllllIIlllllIlIIIIIlIIIl.moveToBlockPosAndAngles(lllllllllllllIIlllllIlIIIIIlIIlI, 0.0f, 0.0f);
                lllllllllllllIIlllllIlIIIIIlIIIl.onInitialSpawn(EntityEvoker.this.world.getDifficultyForLocation(lllllllllllllIIlllllIlIIIIIlIIlI), null);
                lllllllllllllIIlllllIlIIIIIlIIIl.func_190658_a(EntityEvoker.this);
                lllllllllllllIIlllllIlIIIIIlIIIl.func_190651_g(lllllllllllllIIlllllIlIIIIIlIIlI);
                lllllllllllllIIlllllIlIIIIIlIIIl.func_190653_a(20 * (30 + EntityEvoker.this.rand.nextInt(90)));
                EntityEvoker.this.world.spawnEntityInWorld(lllllllllllllIIlllllIlIIIIIlIIIl);
            }
        }
    }
    
    class AICastingSpell extends AICastingApell
    {
        private AICastingSpell() {
        }
        
        @Override
        public void updateTask() {
            if (EntityEvoker.this.getAttackTarget() != null) {
                EntityEvoker.this.getLookHelper().setLookPositionWithEntity(EntityEvoker.this.getAttackTarget(), (float)EntityEvoker.this.getHorizontalFaceSpeed(), (float)EntityEvoker.this.getVerticalFaceSpeed());
            }
            else if (EntityEvoker.this.func_190751_dj() != null) {
                EntityEvoker.this.getLookHelper().setLookPositionWithEntity(EntityEvoker.this.func_190751_dj(), (float)EntityEvoker.this.getHorizontalFaceSpeed(), (float)EntityEvoker.this.getVerticalFaceSpeed());
            }
        }
    }
    
    public class AIWololoSpell extends AIUseSpell
    {
        final /* synthetic */ Predicate<EntitySheep> field_190879_a;
        
        @Override
        public boolean shouldExecute() {
            if (EntityEvoker.this.getAttackTarget() != null) {
                return false;
            }
            if (EntityEvoker.this.func_193082_dl()) {
                return false;
            }
            if (EntityEvoker.this.ticksExisted < this.field_193322_d) {
                return false;
            }
            if (!EntityEvoker.this.world.getGameRules().getBoolean("mobGriefing")) {
                return false;
            }
            final List<EntitySheep> lllllllllllllllIIlIllIIIIIIlllII = EntityEvoker.this.world.getEntitiesWithinAABB((Class<? extends EntitySheep>)EntitySheep.class, EntityEvoker.this.getEntityBoundingBox().expand(16.0, 4.0, 16.0), (com.google.common.base.Predicate<? super EntitySheep>)this.field_190879_a);
            if (lllllllllllllllIIlIllIIIIIIlllII.isEmpty()) {
                return false;
            }
            EntityEvoker.this.func_190748_a(lllllllllllllllIIlIllIIIIIIlllII.get(EntityEvoker.this.rand.nextInt(lllllllllllllllIIlIllIIIIIIlllII.size())));
            return true;
        }
        
        @Override
        protected int func_190867_m() {
            return 40;
        }
        
        @Override
        public void resetTask() {
            super.resetTask();
            EntityEvoker.this.func_190748_a(null);
        }
        
        @Override
        protected SoundEvent func_190871_k() {
            return SoundEvents.field_191249_bs;
        }
        
        @Override
        public boolean continueExecuting() {
            return EntityEvoker.this.func_190751_dj() != null && this.field_193321_c > 0;
        }
        
        public AIWololoSpell() {
            this.field_190879_a = (Predicate<EntitySheep>)new Predicate<EntitySheep>() {
                public boolean apply(final EntitySheep lllllllllllllIllIIlIIIllIIIlIIIl) {
                    return lllllllllllllIllIIlIIIllIIIlIIIl.getFleeceColor() == EnumDyeColor.BLUE;
                }
            };
        }
        
        @Override
        protected void func_190868_j() {
            final EntitySheep lllllllllllllllIIlIllIIIIIIlIIII = EntityEvoker.this.func_190751_dj();
            if (lllllllllllllllIIlIllIIIIIIlIIII != null && lllllllllllllllIIlIllIIIIIIlIIII.isEntityAlive()) {
                lllllllllllllllIIlIllIIIIIIlIIII.setFleeceColor(EnumDyeColor.RED);
            }
        }
        
        @Override
        protected int func_190872_i() {
            return 140;
        }
        
        @Override
        protected int func_190869_f() {
            return 60;
        }
        
        @Override
        protected SpellType func_193320_l() {
            return SpellType.WOLOLO;
        }
    }
}
