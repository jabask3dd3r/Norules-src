package net.minecraft.entity.monster;

import net.minecraft.util.datafix.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;

public class EntitySilverfish extends EntityMob
{
    private /* synthetic */ AISummonSilverfish summonSilverfish;
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllIllllllIIIlllIIlIIlI, final float llllllllllllIllllllIIIlllIIlIlII) {
        if (this.isEntityInvulnerable(llllllllllllIllllllIIIlllIIlIIlI)) {
            return false;
        }
        if ((llllllllllllIllllllIIIlllIIlIIlI instanceof EntityDamageSource || llllllllllllIllllllIIIlllIIlIIlI == DamageSource.magic) && this.summonSilverfish != null) {
            this.summonSilverfish.notifyHurt();
        }
        return super.attackEntityFrom(llllllllllllIllllllIIIlllIIlIIlI, llllllllllllIllllllIIIlllIIlIlII);
    }
    
    public static void registerFixesSilverfish(final DataFixer llllllllllllIllllllIIIlllIlIllII) {
        EntityLiving.registerFixesMob(llllllllllllIllllllIIIlllIlIllII, EntitySilverfish.class);
    }
    
    @Override
    public float getBlockPathWeight(final BlockPos llllllllllllIllllllIIIlllIIIIIll) {
        return (this.world.getBlockState(llllllllllllIllllllIIIlllIIIIIll.down()).getBlock() == Blocks.STONE) ? 10.0f : super.getBlockPathWeight(llllllllllllIllllllIIIlllIIIIIll);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SILVERFISH_DEATH;
    }
    
    public EntitySilverfish(final World llllllllllllIllllllIIIlllIlIllll) {
        super(llllllllllllIllllllIIIlllIlIllll);
        this.setSize(0.4f, 0.3f);
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllIllllllIIIlllIIlllII, final Block llllllllllllIllllllIIIlllIIllIll) {
        this.playSound(SoundEvents.ENTITY_SILVERFISH_STEP, 0.15f, 1.0f);
    }
    
    @Override
    public void onUpdate() {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    @Override
    public void setRenderYawOffset(final float llllllllllllIllllllIIIlllIIIlIIl) {
        this.rotationYaw = llllllllllllIllllllIIIlllIIIlIIl;
        super.setRenderYawOffset(llllllllllllIllllllIIIlllIIIlIIl);
    }
    
    @Override
    protected void initEntityAI() {
        this.summonSilverfish = new AISummonSilverfish(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, this.summonSilverfish);
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0, false));
        this.tasks.addTask(5, new AIHideInStone(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SILVERFISH;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllIllllllIIIlllIlIIIII) {
        return SoundEvents.ENTITY_SILVERFISH_HURT;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public float getEyeHeight() {
        return 0.1f;
    }
    
    @Override
    public double getYOffset() {
        return 0.1;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        if (super.getCanSpawnHere()) {
            final EntityPlayer llllllllllllIllllllIIIllIlllllII = this.world.getNearestPlayerNotCreative(this, 5.0);
            return llllllllllllIllllllIIIllIlllllII == null;
        }
        return false;
    }
    
    static class AISummonSilverfish extends EntityAIBase
    {
        private /* synthetic */ int lookForFriends;
        private final /* synthetic */ EntitySilverfish silverfish;
        
        @Override
        public void updateTask() {
            --this.lookForFriends;
            if (this.lookForFriends <= 0) {
                final World llllllllllllllIIIllIlIllIIlllIlI = this.silverfish.world;
                final Random llllllllllllllIIIllIlIllIIlllIIl = this.silverfish.getRNG();
                final BlockPos llllllllllllllIIIllIlIllIIlllIII = new BlockPos(this.silverfish);
                for (int llllllllllllllIIIllIlIllIIllIlll = 0; llllllllllllllIIIllIlIllIIllIlll <= 5 && llllllllllllllIIIllIlIllIIllIlll >= -5; llllllllllllllIIIllIlIllIIllIlll = ((llllllllllllllIIIllIlIllIIllIlll <= 0) ? 1 : 0) - llllllllllllllIIIllIlIllIIllIlll) {
                    for (int llllllllllllllIIIllIlIllIIllIllI = 0; llllllllllllllIIIllIlIllIIllIllI <= 10 && llllllllllllllIIIllIlIllIIllIllI >= -10; llllllllllllllIIIllIlIllIIllIllI = ((llllllllllllllIIIllIlIllIIllIllI <= 0) ? 1 : 0) - llllllllllllllIIIllIlIllIIllIllI) {
                        for (int llllllllllllllIIIllIlIllIIllIlIl = 0; llllllllllllllIIIllIlIllIIllIlIl <= 10 && llllllllllllllIIIllIlIllIIllIlIl >= -10; llllllllllllllIIIllIlIllIIllIlIl = ((llllllllllllllIIIllIlIllIIllIlIl <= 0) ? 1 : 0) - llllllllllllllIIIllIlIllIIllIlIl) {
                            final BlockPos llllllllllllllIIIllIlIllIIllIlII = llllllllllllllIIIllIlIllIIlllIII.add(llllllllllllllIIIllIlIllIIllIllI, llllllllllllllIIIllIlIllIIllIlll, llllllllllllllIIIllIlIllIIllIlIl);
                            final IBlockState llllllllllllllIIIllIlIllIIllIIll = llllllllllllllIIIllIlIllIIlllIlI.getBlockState(llllllllllllllIIIllIlIllIIllIlII);
                            if (llllllllllllllIIIllIlIllIIllIIll.getBlock() == Blocks.MONSTER_EGG) {
                                if (llllllllllllllIIIllIlIllIIlllIlI.getGameRules().getBoolean("mobGriefing")) {
                                    llllllllllllllIIIllIlIllIIlllIlI.destroyBlock(llllllllllllllIIIllIlIllIIllIlII, true);
                                }
                                else {
                                    llllllllllllllIIIllIlIllIIlllIlI.setBlockState(llllllllllllllIIIllIlIllIIllIlII, llllllllllllllIIIllIlIllIIllIIll.getValue(BlockSilverfish.VARIANT).getModelBlock(), 3);
                                }
                                if (llllllllllllllIIIllIlIllIIlllIIl.nextBoolean()) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        @Override
        public boolean shouldExecute() {
            return this.lookForFriends > 0;
        }
        
        public void notifyHurt() {
            if (this.lookForFriends == 0) {
                this.lookForFriends = 20;
            }
        }
        
        public AISummonSilverfish() {
        }
    }
    
    static class AIHideInStone extends EntityAIWander
    {
        private /* synthetic */ boolean doMerge;
        private /* synthetic */ EnumFacing facing;
        
        @Override
        public boolean shouldExecute() {
            if (this.entity.getAttackTarget() != null) {
                return false;
            }
            if (!this.entity.getNavigator().noPath()) {
                return false;
            }
            final Random llllllllllllllIllllIlIIIlllllIII = this.entity.getRNG();
            if (this.entity.world.getGameRules().getBoolean("mobGriefing") && llllllllllllllIllllIlIIIlllllIII.nextInt(10) == 0) {
                this.facing = EnumFacing.random(llllllllllllllIllllIlIIIlllllIII);
                final BlockPos llllllllllllllIllllIlIIIllllIlll = new BlockPos(this.entity.posX, this.entity.posY + 0.5, this.entity.posZ).offset(this.facing);
                final IBlockState llllllllllllllIllllIlIIIllllIllI = this.entity.world.getBlockState(llllllllllllllIllllIlIIIllllIlll);
                if (BlockSilverfish.canContainSilverfish(llllllllllllllIllllIlIIIllllIllI)) {
                    this.doMerge = true;
                    return true;
                }
            }
            this.doMerge = false;
            return super.shouldExecute();
        }
        
        public AIHideInStone(final EntitySilverfish llllllllllllllIllllIlIIlIIIIIIII) {
            super(llllllllllllllIllllIlIIlIIIIIIII, 1.0, 10);
            this.setMutexBits(1);
        }
        
        @Override
        public void startExecuting() {
            if (!this.doMerge) {
                super.startExecuting();
            }
            else {
                final World llllllllllllllIllllIlIIIlllIlIIl = this.entity.world;
                final BlockPos llllllllllllllIllllIlIIIlllIlIII = new BlockPos(this.entity.posX, this.entity.posY + 0.5, this.entity.posZ).offset(this.facing);
                final IBlockState llllllllllllllIllllIlIIIlllIIlll = llllllllllllllIllllIlIIIlllIlIIl.getBlockState(llllllllllllllIllllIlIIIlllIlIII);
                if (BlockSilverfish.canContainSilverfish(llllllllllllllIllllIlIIIlllIIlll)) {
                    llllllllllllllIllllIlIIIlllIlIIl.setBlockState(llllllllllllllIllllIlIIIlllIlIII, Blocks.MONSTER_EGG.getDefaultState().withProperty(BlockSilverfish.VARIANT, BlockSilverfish.EnumType.forModelBlock(llllllllllllllIllllIlIIIlllIIlll)), 3);
                    this.entity.spawnExplosionParticle();
                    this.entity.setDead();
                }
            }
        }
        
        @Override
        public boolean continueExecuting() {
            return !this.doMerge && super.continueExecuting();
        }
    }
}
