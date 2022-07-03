package net.minecraft.entity.monster;

import net.minecraft.entity.player.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;

public class EntityElderGuardian extends EntityGuardian
{
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        final int llllllllllllllIIllIlllIIIIIIIIlI = 1200;
        if ((this.ticksExisted + this.getEntityId()) % 1200 == 0) {
            final Potion llllllllllllllIIllIlllIIIIIIIIIl = MobEffects.MINING_FATIGUE;
            final List<EntityPlayerMP> llllllllllllllIIllIlllIIIIIIIIII = this.world.getPlayers((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, (com.google.common.base.Predicate<? super EntityPlayerMP>)new Predicate<EntityPlayerMP>() {
                public boolean apply(@Nullable final EntityPlayerMP lllllllllllllIIIIlIllIlIIIlIlIlI) {
                    return EntityElderGuardian.this.getDistanceSqToEntity(lllllllllllllIIIIlIllIlIIIlIlIlI) < 2500.0 && lllllllllllllIIIIlIllIlIIIlIlIlI.interactionManager.survivalOrAdventure();
                }
            });
            final int llllllllllllllIIllIllIllllllllll = 2;
            final int llllllllllllllIIllIllIlllllllllI = 6000;
            final int llllllllllllllIIllIllIllllllllIl = 1200;
            for (final EntityPlayerMP llllllllllllllIIllIllIllllllllII : llllllllllllllIIllIlllIIIIIIIIII) {
                if (!llllllllllllllIIllIllIllllllllII.isPotionActive(llllllllllllllIIllIlllIIIIIIIIIl) || llllllllllllllIIllIllIllllllllII.getActivePotionEffect(llllllllllllllIIllIlllIIIIIIIIIl).getAmplifier() < 2 || llllllllllllllIIllIllIllllllllII.getActivePotionEffect(llllllllllllllIIllIlllIIIIIIIIIl).getDuration() < 1200) {
                    llllllllllllllIIllIllIllllllllII.connection.sendPacket(new SPacketChangeGameState(10, 0.0f));
                    llllllllllllllIIllIllIllllllllII.addPotionEffect(new PotionEffect(llllllllllllllIIllIlllIIIIIIIIIl, 6000, 2));
                }
            }
        }
        if (!this.hasHome()) {
            this.setHomePosAndDistance(new BlockPos(this), 16);
        }
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ELDER_GUARDIAN;
    }
    
    public EntityElderGuardian(final World llllllllllllllIIllIlllIIIIllIIll) {
        super(llllllllllllllIIllIlllIIIIllIIll);
        this.setSize(this.width * 2.35f, this.height * 2.35f);
        this.enablePersistence();
        if (this.wander != null) {
            this.wander.setExecutionChance(400);
        }
    }
    
    @Override
    public int getAttackDuration() {
        return 60;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIIllIlllIIIIIlIllI) {
        return this.isInWater() ? SoundEvents.ENTITY_ELDER_GUARDIAN_HURT : SoundEvents.ENTITY_ELDER_GUARDIAN_HURT_LAND;
    }
    
    @Override
    protected SoundEvent func_190765_dj() {
        return SoundEvents.field_191240_aK;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return this.isInWater() ? SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH : SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH_LAND;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isInWater() ? SoundEvents.ENTITY_ELDER_GUARDIAN_AMBIENT : SoundEvents.ENTITY_ELDERGUARDIAN_AMBIENTLAND;
    }
    
    public static void func_190768_b(final DataFixer llllllllllllllIIllIlllIIIIlIIlll) {
        EntityLiving.registerFixesMob(llllllllllllllIIllIlllIIIIlIIlll, EntityElderGuardian.class);
    }
    
    public void func_190767_di() {
        this.clientSideSpikesAnimation = 1.0f;
        this.clientSideSpikesAnimationO = this.clientSideSpikesAnimation;
    }
}
