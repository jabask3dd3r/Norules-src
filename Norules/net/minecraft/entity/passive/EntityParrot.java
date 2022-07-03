package net.minecraft.entity.passive;

import com.google.common.base.*;
import net.minecraft.pathfinding.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.network.datasync.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import it.unimi.dsi.fastutil.ints.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.*;

public class EntityParrot extends EntityShoulderRiding implements EntityFlying
{
    private /* synthetic */ BlockPos field_192019_bM;
    public /* synthetic */ float field_192009_bC;
    public /* synthetic */ float field_192008_bB;
    public /* synthetic */ float field_192011_bE;
    private static final /* synthetic */ DataParameter<Integer> field_192013_bG;
    private static final /* synthetic */ Predicate<EntityLiving> field_192014_bH;
    public /* synthetic */ float field_192012_bF;
    private static final /* synthetic */ Item field_192015_bI;
    private static final /* synthetic */ Set<Item> field_192016_bJ;
    private static final /* synthetic */ Int2ObjectMap<SoundEvent> field_192017_bK;
    private /* synthetic */ boolean field_192018_bL;
    public /* synthetic */ float field_192010_bD;
    
    @Override
    public void onLivingUpdate() {
        func_192006_b(this.world, this);
        if (this.field_192019_bM == null || this.field_192019_bM.distanceSq(this.posX, this.posY, this.posZ) > 12.0 || this.world.getBlockState(this.field_192019_bM).getBlock() != Blocks.JUKEBOX) {
            this.field_192018_bL = false;
            this.field_192019_bM = null;
        }
        super.onLivingUpdate();
        this.func_192001_dv();
    }
    
    public EntityParrot(final World llllllllllllllIlIIlIlIlIIIlIIIIl) {
        super(llllllllllllllIlIIlIlIlIIIlIIIIl);
        this.field_192012_bF = 1.0f;
        this.setSize(0.5f, 0.9f);
        this.moveHelper = new EntityFlyHelper(this);
    }
    
    @Override
    protected float func_191954_d(final float llllllllllllllIlIIlIlIIllIIlIIll) {
        this.playSound(SoundEvents.field_192796_et, 0.15f, 1.0f);
        return llllllllllllllIlIIlIlIIllIIlIIll + this.field_192009_bC / 2.0f;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityParrot.field_192013_bG, 0);
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllIlIIlIlIIllIIllIIl, final Block llllllllllllllIlIIlIlIIllIIllIII) {
        this.playSound(SoundEvents.field_192795_es, 0.15f, 1.0f);
    }
    
    @Override
    protected PathNavigate getNewNavigator(final World llllllllllllllIlIIlIlIlIIIIIlIII) {
        final PathNavigateFlying llllllllllllllIlIIlIlIlIIIIIlIlI = new PathNavigateFlying(this, llllllllllllllIlIIlIlIlIIIIIlIII);
        llllllllllllllIlIIlIlIlIIIIIlIlI.func_192879_a(false);
        llllllllllllllIlIIlIlIlIIIIIlIlI.func_192877_c(true);
        llllllllllllllIlIIlIlIlIIIIIlIlI.func_192878_b(true);
        return llllllllllllllIlIIlIlIlIIIIIlIlI;
    }
    
    @Override
    public void func_191987_a(final BlockPos llllllllllllllIlIIlIlIIlllllllII, final boolean llllllllllllllIlIIlIlIIllllllIII) {
        this.field_192019_bM = llllllllllllllIlIIlIlIIlllllllII;
        this.field_192018_bL = llllllllllllllIlIIlIlIIllllllIII;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance llllllllllllllIlIIlIlIlIIIIlIlll, @Nullable final IEntityLivingData llllllllllllllIlIIlIlIlIIIIlIllI) {
        this.func_191997_m(this.rand.nextInt(5));
        return super.onInitialSpawn(llllllllllllllIlIIlIlIlIIIIlIlll, llllllllllllllIlIIlIlIlIIIIlIllI);
    }
    
    public boolean func_192004_dr() {
        return this.field_192018_bL;
    }
    
    public void func_191997_m(final int llllllllllllllIlIIlIlIIlIlllIIlI) {
        this.dataManager.set(EntityParrot.field_192013_bG, llllllllllllllIlIIlIlIIlIlllIIlI);
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.6f;
    }
    
    public static void func_192005_a(final World llllllllllllllIlIIlIlIIllIllIIlI, final Entity llllllllllllllIlIIlIlIIllIllIIIl) {
        if (!llllllllllllllIlIIlIlIIllIllIIIl.isSilent() && !func_192006_b(llllllllllllllIlIIlIlIIllIllIIlI, llllllllllllllIlIIlIlIIllIllIIIl) && llllllllllllllIlIIlIlIIllIllIIlI.rand.nextInt(200) == 0) {
            llllllllllllllIlIIlIlIIllIllIIlI.playSound(null, llllllllllllllIlIIlIlIIllIllIIIl.posX, llllllllllllllIlIIlIlIIllIllIIIl.posY, llllllllllllllIlIIlIlIIllIllIIIl.posZ, func_192003_a(llllllllllllllIlIIlIlIIllIllIIlI.rand), llllllllllllllIlIIlIlIIllIllIIIl.getSoundCategory(), 1.0f, func_192000_b(llllllllllllllIlIIlIlIIllIllIIlI.rand));
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(0, new EntityAIPanic(this, 1.25));
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(2, new EntityAIFollowOwnerFlying(this, 1.0, 5.0f, 1.0f));
        this.tasks.addTask(2, new EntityAIWanderAvoidWaterFlying(this, 1.0));
        this.tasks.addTask(3, new EntityAILandOnOwnersShoulder(this));
        this.tasks.addTask(3, new EntityAIFollow(this, 1.0, 3.0f, 7.0f));
    }
    
    @Override
    protected float getSoundPitch() {
        return func_192000_b(this.rand);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIlIIlIlIIllIIlllIl) {
        return SoundEvents.field_192794_er;
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIlIIlIlIIlllIllIIl, final EnumHand llllllllllllllIlIIlIlIIlllIllIII) {
        final ItemStack llllllllllllllIlIIlIlIIlllIllIll = llllllllllllllIlIIlIlIIlllIllIIl.getHeldItem(llllllllllllllIlIIlIlIIlllIllIII);
        if (!this.isTamed() && EntityParrot.field_192016_bJ.contains(llllllllllllllIlIIlIlIIlllIllIll.getItem())) {
            if (!llllllllllllllIlIIlIlIIlllIllIIl.capabilities.isCreativeMode) {
                llllllllllllllIlIIlIlIIlllIllIll.func_190918_g(1);
            }
            if (!this.isSilent()) {
                this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.field_192797_eu, this.getSoundCategory(), 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(10) == 0) {
                    this.func_193101_c(llllllllllllllIlIIlIlIIlllIllIIl);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        if (llllllllllllllIlIIlIlIIlllIllIll.getItem() == EntityParrot.field_192015_bI) {
            if (!llllllllllllllIlIIlIlIIlllIllIIl.capabilities.isCreativeMode) {
                llllllllllllllIlIIlIlIIlllIllIll.func_190918_g(1);
            }
            this.addPotionEffect(new PotionEffect(MobEffects.POISON, 900));
            if (llllllllllllllIlIIlIlIIlllIllIIl.isCreative() || !this.func_190530_aW()) {
                this.attackEntityFrom(DamageSource.causePlayerDamage(llllllllllllllIlIIlIlIIlllIllIIl), Float.MAX_VALUE);
            }
            return true;
        }
        if (!this.world.isRemote && !this.func_192002_a() && this.isTamed() && this.isOwner(llllllllllllllIlIIlIlIIlllIllIIl)) {
            this.aiSit.setSitting(!this.isSitting());
        }
        return super.processInteract(llllllllllllllIlIIlIlIIlllIllIIl, llllllllllllllIlIIlIlIIlllIllIII);
    }
    
    @Override
    public boolean canBePushed() {
        return true;
    }
    
    @Nullable
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllIlIIlIlIIllIllIlll) {
        return null;
    }
    
    static {
        field_192013_bG = EntityDataManager.createKey(EntityParrot.class, DataSerializers.VARINT);
        field_192014_bH = (Predicate)new Predicate<EntityLiving>() {
            public boolean apply(@Nullable final EntityLiving lllIIIIlIIlIII) {
                return lllIIIIlIIlIII != null && EntityParrot.field_192017_bK.containsKey(EntityList.field_191308_b.getIDForObject(lllIIIIlIIlIII.getClass()));
            }
        };
        field_192015_bI = Items.COOKIE;
        field_192016_bJ = Sets.newHashSet((Object[])new Item[] { Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS });
        (field_192017_bK = (Int2ObjectMap)new Int2ObjectOpenHashMap(32)).put(EntityList.field_191308_b.getIDForObject(EntityBlaze.class), (Object)SoundEvents.field_193791_eM);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityCaveSpider.class), (Object)SoundEvents.field_193813_fc);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityCreeper.class), (Object)SoundEvents.field_193792_eN);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityElderGuardian.class), (Object)SoundEvents.field_193793_eO);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityDragon.class), (Object)SoundEvents.field_193794_eP);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityEnderman.class), (Object)SoundEvents.field_193795_eQ);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityEndermite.class), (Object)SoundEvents.field_193796_eR);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityEvoker.class), (Object)SoundEvents.field_193797_eS);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityGhast.class), (Object)SoundEvents.field_193798_eT);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityHusk.class), (Object)SoundEvents.field_193799_eU);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityIllusionIllager.class), (Object)SoundEvents.field_193800_eV);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityMagmaCube.class), (Object)SoundEvents.field_193801_eW);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityPigZombie.class), (Object)SoundEvents.field_193822_fl);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityPolarBear.class), (Object)SoundEvents.field_193802_eX);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityShulker.class), (Object)SoundEvents.field_193803_eY);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntitySilverfish.class), (Object)SoundEvents.field_193804_eZ);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntitySkeleton.class), (Object)SoundEvents.field_193811_fa);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntitySlime.class), (Object)SoundEvents.field_193812_fb);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntitySpider.class), (Object)SoundEvents.field_193813_fc);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityStray.class), (Object)SoundEvents.field_193814_fd);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityVex.class), (Object)SoundEvents.field_193815_fe);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityVindicator.class), (Object)SoundEvents.field_193816_ff);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityWitch.class), (Object)SoundEvents.field_193817_fg);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityWither.class), (Object)SoundEvents.field_193818_fh);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityWitherSkeleton.class), (Object)SoundEvents.field_193819_fi);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityWolf.class), (Object)SoundEvents.field_193820_fj);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityZombie.class), (Object)SoundEvents.field_193821_fk);
        EntityParrot.field_192017_bK.put(EntityList.field_191308_b.getIDForObject(EntityZombieVillager.class), (Object)SoundEvents.field_193823_fm);
    }
    
    private static boolean func_192006_b(final World llllllllllllllIlIIlIlIIllllIIlll, final Entity llllllllllllllIlIIlIlIIllllIIllI) {
        if (!llllllllllllllIlIIlIlIIllllIIllI.isSilent() && llllllllllllllIlIIlIlIIllllIIlll.rand.nextInt(50) == 0) {
            final List<EntityLiving> llllllllllllllIlIIlIlIIllllIlIlI = llllllllllllllIlIIlIlIIllllIIlll.getEntitiesWithinAABB((Class<? extends EntityLiving>)EntityLiving.class, llllllllllllllIlIIlIlIIllllIIllI.getEntityBoundingBox().expandXyz(20.0), (com.google.common.base.Predicate<? super EntityLiving>)EntityParrot.field_192014_bH);
            if (!llllllllllllllIlIIlIlIIllllIlIlI.isEmpty()) {
                final EntityLiving llllllllllllllIlIIlIlIIllllIlIIl = llllllllllllllIlIIlIlIIllllIlIlI.get(llllllllllllllIlIIlIlIIllllIIlll.rand.nextInt(llllllllllllllIlIIlIlIIllllIlIlI.size()));
                if (!llllllllllllllIlIIlIlIIllllIlIIl.isSilent()) {
                    final SoundEvent llllllllllllllIlIIlIlIIllllIlIII = func_191999_g(EntityList.field_191308_b.getIDForObject(llllllllllllllIlIIlIlIIllllIlIIl.getClass()));
                    llllllllllllllIlIIlIlIIllllIIlll.playSound(null, llllllllllllllIlIIlIlIIllllIIllI.posX, llllllllllllllIlIIlIlIIllllIIllI.posY, llllllllllllllIlIIlIlIIllllIIllI.posZ, llllllllllllllIlIIlIlIIllllIlIII, llllllllllllllIlIIlIlIIllllIIllI.getSoundCategory(), 0.7f, func_192000_b(llllllllllllllIlIIlIlIIllllIIlll.rand));
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.field_192793_eq;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.field_193334_e);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.field_193334_e).setBaseValue(0.4000000059604645);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224);
    }
    
    public boolean func_192002_a() {
        return !this.onGround;
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal llllllllllllllIlIIlIlIIllIlllIIl) {
        return false;
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llllllllllllllIlIIlIlIIlllIlIlIl) {
        return false;
    }
    
    private void func_192001_dv() {
        this.field_192011_bE = this.field_192008_bB;
        this.field_192010_bD = this.field_192009_bC;
        this.field_192009_bC += (float)((this.onGround ? -1 : 4) * 0.3);
        this.field_192009_bC = MathHelper.clamp(this.field_192009_bC, 0.0f, 1.0f);
        if (!this.onGround && this.field_192012_bF < 1.0f) {
            this.field_192012_bF = 1.0f;
        }
        this.field_192012_bF *= (float)0.9;
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        this.field_192008_bB += this.field_192012_bF * 2.0f;
    }
    
    @Nullable
    public SoundEvent getAmbientSound() {
        return func_192003_a(this.rand);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final int llllllllllllllIlIIlIlIIlllIIllIl = MathHelper.floor(this.posX);
        final int llllllllllllllIlIIlIlIIlllIIllII = MathHelper.floor(this.getEntityBoundingBox().minY);
        final int llllllllllllllIlIIlIlIIlllIIlIll = MathHelper.floor(this.posZ);
        final BlockPos llllllllllllllIlIIlIlIIlllIIlIlI = new BlockPos(llllllllllllllIlIIlIlIIlllIIllIl, llllllllllllllIlIIlIlIIlllIIllII, llllllllllllllIlIIlIlIIlllIIlIll);
        final Block llllllllllllllIlIIlIlIIlllIIlIIl = this.world.getBlockState(llllllllllllllIlIIlIlIIlllIIlIlI.down()).getBlock();
        return llllllllllllllIlIIlIlIIlllIIlIIl instanceof BlockLeaves || llllllllllllllIlIIlIlIIlllIIlIIl == Blocks.GRASS || llllllllllllllIlIIlIlIIlllIIlIIl instanceof BlockLog || (llllllllllllllIlIIlIlIIlllIIlIIl == Blocks.AIR && this.world.getLight(llllllllllllllIlIIlIlIIlllIIlIlI) > 8 && super.getCanSpawnHere());
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllIlIIlIlIIllIlIllIl) {
        return llllllllllllllIlIIlIlIIllIlIllIl.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }
    
    @Override
    public void fall(final float llllllllllllllIlIIlIlIIlllIIIIIl, final float llllllllllllllIlIIlIlIIlllIIIIII) {
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIIlIlIIlIllIIIll) {
        super.readEntityFromNBT(llllllllllllllIlIIlIlIIlIllIIIll);
        this.func_191997_m(llllllllllllllIlIIlIlIIlIllIIIll.getInteger("Variant"));
    }
    
    @Override
    protected void collideWithEntity(final Entity llllllllllllllIlIIlIlIIllIIIIlII) {
        if (!(llllllllllllllIlIIlIlIIllIIIIlII instanceof EntityPlayer)) {
            super.collideWithEntity(llllllllllllllIlIIlIlIIllIIIIlII);
        }
    }
    
    public static SoundEvent func_191999_g(final int llllllllllllllIlIIlIlIIllIIlllll) {
        return (SoundEvent)(EntityParrot.field_192017_bK.containsKey(llllllllllllllIlIIlIlIIllIIlllll) ? EntityParrot.field_192017_bK.get(llllllllllllllIlIIlIlIIllIIlllll) : SoundEvents.field_192792_ep);
    }
    
    public int func_191998_ds() {
        return MathHelper.clamp(this.dataManager.get(EntityParrot.field_192013_bG), 0, 4);
    }
    
    private static SoundEvent func_192003_a(final Random llllllllllllllIlIIlIlIIllIlIIlIl) {
        if (llllllllllllllIlIIlIlIIllIlIIlIl.nextInt(1000) == 0) {
            final List<Integer> llllllllllllllIlIIlIlIIllIlIIlII = new ArrayList<Integer>((Collection<? extends Integer>)EntityParrot.field_192017_bK.keySet());
            return func_191999_g(llllllllllllllIlIIlIlIIllIlIIlII.get(llllllllllllllIlIIlIlIIllIlIIlIl.nextInt(llllllllllllllIlIIlIlIIllIlIIlII.size())));
        }
        return SoundEvents.field_192792_ep;
    }
    
    @Override
    protected void updateFallState(final double llllllllllllllIlIIlIlIIllIlllllI, final boolean llllllllllllllIlIIlIlIIllIllllIl, final IBlockState llllllllllllllIlIIlIlIIllIllllII, final BlockPos llllllllllllllIlIIlIlIIllIlllIll) {
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_192561_ax;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIIlIlIIlIllIlIIl) {
        super.writeEntityToNBT(llllllllllllllIlIIlIlIIlIllIlIIl);
        llllllllllllllIlIIlIlIIlIllIlIIl.setInteger("Variant", this.func_191998_ds());
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIlIIlIlIIlIlllllIl, final float llllllllllllllIlIIlIlIIlIlllllII) {
        if (this.isEntityInvulnerable(llllllllllllllIlIIlIlIIlIlllllIl)) {
            return false;
        }
        if (this.aiSit != null) {
            this.aiSit.setSitting(false);
        }
        return super.attackEntityFrom(llllllllllllllIlIIlIlIIlIlllllIl, llllllllllllllIlIIlIlIIlIlllllII);
    }
    
    @Override
    protected boolean func_191957_ae() {
        return true;
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.NEUTRAL;
    }
    
    private static float func_192000_b(final Random llllllllllllllIlIIlIlIIllIIIlIlI) {
        return (llllllllllllllIlIIlIlIIllIIIlIlI.nextFloat() - llllllllllllllIlIIlIlIIllIIIlIlI.nextFloat()) * 0.2f + 1.0f;
    }
}
