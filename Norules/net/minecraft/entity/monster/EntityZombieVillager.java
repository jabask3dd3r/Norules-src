package net.minecraft.entity.monster;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.math.*;
import net.minecraft.advancements.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.network.datasync.*;

public class EntityZombieVillager extends EntityZombie
{
    private static final /* synthetic */ DataParameter<Boolean> CONVERTING;
    private /* synthetic */ int conversionTime;
    private /* synthetic */ UUID field_191992_by;
    private static final /* synthetic */ DataParameter<Integer> field_190739_c;
    
    @Override
    protected ItemStack func_190732_dj() {
        return ItemStack.field_190927_a;
    }
    
    public SoundEvent getHurtSound(final DamageSource lllllllllllllIIIlIIlIllIllIlllII) {
        return SoundEvents.ENTITY_ZOMBIE_VILLAGER_HURT;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIIlIIlIlllIIlllIIl) {
        super.writeEntityToNBT(lllllllllllllIIIlIIlIlllIIlllIIl);
        lllllllllllllIIIlIIlIlllIIlllIIl.setInteger("Profession", this.func_190736_dl());
        lllllllllllllIIIlIIlIlllIIlllIIl.setInteger("ConversionTime", this.isConverting() ? this.conversionTime : -1);
        if (this.field_191992_by != null) {
            lllllllllllllIIIlIIlIlllIIlllIIl.setUniqueId("ConversionPlayer", this.field_191992_by);
        }
    }
    
    protected void func_190738_dp() {
        final EntityVillager lllllllllllllIIIlIIlIllIlllllllI = new EntityVillager(this.world);
        lllllllllllllIIIlIIlIllIlllllllI.copyLocationAndAnglesFrom(this);
        lllllllllllllIIIlIIlIllIlllllllI.setProfession(this.func_190736_dl());
        lllllllllllllIIIlIIlIllIlllllllI.func_190672_a(this.world.getDifficultyForLocation(new BlockPos(lllllllllllllIIIlIIlIllIlllllllI)), null, false);
        lllllllllllllIIIlIIlIllIlllllllI.setLookingForHome();
        if (this.isChild()) {
            lllllllllllllIIIlIIlIllIlllllllI.setGrowingAge(-24000);
        }
        this.world.removeEntity(this);
        lllllllllllllIIIlIIlIllIlllllllI.setNoAI(this.isAIDisabled());
        if (this.hasCustomName()) {
            lllllllllllllIIIlIIlIllIlllllllI.setCustomNameTag(this.getCustomNameTag());
            lllllllllllllIIIlIIlIllIlllllllI.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
        }
        this.world.spawnEntityInWorld(lllllllllllllIIIlIIlIllIlllllllI);
        if (this.field_191992_by != null) {
            final EntityPlayer lllllllllllllIIIlIIlIllIllllllIl = this.world.getPlayerEntityByUUID(this.field_191992_by);
            if (lllllllllllllIIIlIIlIllIllllllIl instanceof EntityPlayerMP) {
                CriteriaTriggers.field_192137_q.func_192183_a((EntityPlayerMP)lllllllllllllIIIlIIlIllIllllllIl, this, lllllllllllllIIIlIIlIllIlllllllI);
            }
        }
        lllllllllllllIIIlIIlIllIlllllllI.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0));
        this.world.playEvent(null, 1027, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
    }
    
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_VILLAGER_AMBIENT;
    }
    
    public void func_190733_a(final int lllllllllllllIIIlIIlIlllIlIIIlll) {
        this.dataManager.set(EntityZombieVillager.field_190739_c, lllllllllllllIIIlIIlIlllIlIIIlll);
    }
    
    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_VILLAGER_DEATH;
    }
    
    public SoundEvent func_190731_di() {
        return SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP;
    }
    
    public static void func_190737_b(final DataFixer lllllllllllllIIIlIIlIlllIIllllll) {
        EntityLiving.registerFixesMob(lllllllllllllIIIlIIlIlllIIllllll, EntityZombieVillager.class);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191183_as;
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIIIlIIlIlllIIIIIIll) {
        if (lllllllllllllIIIlIIlIlllIIIIIIll == 16) {
            if (!this.isSilent()) {
                this.world.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, this.getSoundCategory(), 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        else {
            super.handleStatusUpdate(lllllllllllllIIIlIIlIlllIIIIIIll);
        }
    }
    
    protected void func_191991_a(@Nullable final UUID lllllllllllllIIIlIIlIlllIIIIllIl, final int lllllllllllllIIIlIIlIlllIIIIllII) {
        this.field_191992_by = lllllllllllllIIIlIIlIlllIIIIllIl;
        this.conversionTime = lllllllllllllIIIlIIlIlllIIIIllII;
        this.getDataManager().set(EntityZombieVillager.CONVERTING, true);
        this.removePotionEffect(MobEffects.WEAKNESS);
        this.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, lllllllllllllIIIlIIlIlllIIIIllII, Math.min(this.world.getDifficulty().getDifficultyId() - 1, 0)));
        this.world.setEntityState(this, (byte)16);
    }
    
    protected int func_190735_dq() {
        int lllllllllllllIIIlIIlIllIllllIIII = 1;
        if (this.rand.nextFloat() < 0.01f) {
            int lllllllllllllIIIlIIlIllIlllIllll = 0;
            final BlockPos.MutableBlockPos lllllllllllllIIIlIIlIllIlllIlllI = new BlockPos.MutableBlockPos();
            for (int lllllllllllllIIIlIIlIllIlllIllIl = (int)this.posX - 4; lllllllllllllIIIlIIlIllIlllIllIl < (int)this.posX + 4 && lllllllllllllIIIlIIlIllIlllIllll < 14; ++lllllllllllllIIIlIIlIllIlllIllIl) {
                for (int lllllllllllllIIIlIIlIllIlllIllII = (int)this.posY - 4; lllllllllllllIIIlIIlIllIlllIllII < (int)this.posY + 4 && lllllllllllllIIIlIIlIllIlllIllll < 14; ++lllllllllllllIIIlIIlIllIlllIllII) {
                    for (int lllllllllllllIIIlIIlIllIlllIlIll = (int)this.posZ - 4; lllllllllllllIIIlIIlIllIlllIlIll < (int)this.posZ + 4 && lllllllllllllIIIlIIlIllIlllIllll < 14; ++lllllllllllllIIIlIIlIllIlllIlIll) {
                        final Block lllllllllllllIIIlIIlIllIlllIlIlI = this.world.getBlockState(lllllllllllllIIIlIIlIllIlllIlllI.setPos(lllllllllllllIIIlIIlIllIlllIllIl, lllllllllllllIIIlIIlIllIlllIllII, lllllllllllllIIIlIIlIllIlllIlIll)).getBlock();
                        if (lllllllllllllIIIlIIlIllIlllIlIlI == Blocks.IRON_BARS || lllllllllllllIIIlIIlIllIlllIlIlI == Blocks.BED) {
                            if (this.rand.nextFloat() < 0.3f) {
                                ++lllllllllllllIIIlIIlIllIllllIIII;
                            }
                            ++lllllllllllllIIIlIIlIllIlllIllll;
                        }
                    }
                }
            }
        }
        return lllllllllllllIIIlIIlIllIllllIIII;
    }
    
    public boolean isConverting() {
        return this.getDataManager().get(EntityZombieVillager.CONVERTING);
    }
    
    public EntityZombieVillager(final World lllllllllllllIIIlIIlIlllIlIIlllI) {
        super(lllllllllllllIIIlIIlIlllIlIIlllI);
    }
    
    @Override
    public void onUpdate() {
        if (!this.world.isRemote && this.isConverting()) {
            final int lllllllllllllIIIlIIlIlllIIlIIllI = this.func_190735_dq();
            this.conversionTime -= lllllllllllllIIIlIIlIlllIIlIIllI;
            if (this.conversionTime <= 0) {
                this.func_190738_dp();
            }
        }
        super.onUpdate();
    }
    
    @Override
    protected float getSoundPitch() {
        return this.isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 2.0f) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIlIIlIlllIIllIIll) {
        super.readEntityFromNBT(lllllllllllllIIIlIIlIlllIIllIIll);
        this.func_190733_a(lllllllllllllIIIlIIlIlllIIllIIll.getInteger("Profession"));
        if (lllllllllllllIIIlIIlIlllIIllIIll.hasKey("ConversionTime", 99) && lllllllllllllIIIlIIlIlllIIllIIll.getInteger("ConversionTime") > -1) {
            this.func_191991_a(lllllllllllllIIIlIIlIlllIIllIIll.hasUniqueId("ConversionPlayer") ? lllllllllllllIIIlIIlIlllIIllIIll.getUniqueId("ConversionPlayer") : null, lllllllllllllIIIlIIlIlllIIllIIll.getInteger("ConversionTime"));
        }
    }
    
    public boolean processInteract(final EntityPlayer lllllllllllllIIIlIIlIlllIIIllIlI, final EnumHand lllllllllllllIIIlIIlIlllIIIllIIl) {
        final ItemStack lllllllllllllIIIlIIlIlllIIIlllII = lllllllllllllIIIlIIlIlllIIIllIlI.getHeldItem(lllllllllllllIIIlIIlIlllIIIllIIl);
        if (lllllllllllllIIIlIIlIlllIIIlllII.getItem() == Items.GOLDEN_APPLE && lllllllllllllIIIlIIlIlllIIIlllII.getMetadata() == 0 && this.isPotionActive(MobEffects.WEAKNESS)) {
            if (!lllllllllllllIIIlIIlIlllIIIllIlI.capabilities.isCreativeMode) {
                lllllllllllllIIIlIIlIlllIIIlllII.func_190918_g(1);
            }
            if (!this.world.isRemote) {
                this.func_191991_a(lllllllllllllIIIlIIlIlllIIIllIlI.getUniqueID(), this.rand.nextInt(2401) + 3600);
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean canDespawn() {
        return !this.isConverting();
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIIlIIlIlllIIlIlllI, @Nullable final IEntityLivingData lllllllllllllIIIlIIlIlllIIlIllIl) {
        this.func_190733_a(this.world.rand.nextInt(6));
        return super.onInitialSpawn(lllllllllllllIIIlIIlIlllIIlIlllI, lllllllllllllIIIlIIlIlllIIlIllIl);
    }
    
    public int func_190736_dl() {
        return Math.max(this.dataManager.get(EntityZombieVillager.field_190739_c) % 6, 0);
    }
    
    static {
        CONVERTING = EntityDataManager.createKey(EntityZombieVillager.class, DataSerializers.BOOLEAN);
        field_190739_c = EntityDataManager.createKey(EntityZombieVillager.class, DataSerializers.VARINT);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityZombieVillager.CONVERTING, false);
        this.dataManager.register(EntityZombieVillager.field_190739_c, 0);
    }
}
