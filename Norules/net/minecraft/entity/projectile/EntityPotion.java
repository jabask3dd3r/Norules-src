package net.minecraft.entity.projectile;

import com.google.common.base.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.potion.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.monster.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.datasync.*;
import org.apache.logging.log4j.*;
import javax.annotation.*;

public class EntityPotion extends EntityThrowable
{
    public static final /* synthetic */ Predicate<EntityLivingBase> field_190546_d;
    private static final /* synthetic */ DataParameter<ItemStack> ITEM;
    private static final /* synthetic */ Logger LOGGER;
    
    private void func_190543_a(final RayTraceResult llllllllllllllllIIllllIlIIllIIll, final List<PotionEffect> llllllllllllllllIIllllIlIIllIIlI) {
        final AxisAlignedBB llllllllllllllllIIllllIlIIllIIIl = this.getEntityBoundingBox().expand(4.0, 2.0, 4.0);
        final List<EntityLivingBase> llllllllllllllllIIllllIlIIllIIII = this.world.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, llllllllllllllllIIllllIlIIllIIIl);
        if (!llllllllllllllllIIllllIlIIllIIII.isEmpty()) {
            for (final EntityLivingBase llllllllllllllllIIllllIlIIlIllll : llllllllllllllllIIllllIlIIllIIII) {
                if (llllllllllllllllIIllllIlIIlIllll.canBeHitWithPotion()) {
                    final double llllllllllllllllIIllllIlIIlIlllI = this.getDistanceSqToEntity(llllllllllllllllIIllllIlIIlIllll);
                    if (llllllllllllllllIIllllIlIIlIlllI >= 16.0) {
                        continue;
                    }
                    double llllllllllllllllIIllllIlIIlIllIl = 1.0 - Math.sqrt(llllllllllllllllIIllllIlIIlIlllI) / 4.0;
                    if (llllllllllllllllIIllllIlIIlIllll == llllllllllllllllIIllllIlIIllIIll.entityHit) {
                        llllllllllllllllIIllllIlIIlIllIl = 1.0;
                    }
                    for (final PotionEffect llllllllllllllllIIllllIlIIlIllII : llllllllllllllllIIllllIlIIllIIlI) {
                        final Potion llllllllllllllllIIllllIlIIlIlIll = llllllllllllllllIIllllIlIIlIllII.getPotion();
                        if (llllllllllllllllIIllllIlIIlIlIll.isInstant()) {
                            llllllllllllllllIIllllIlIIlIlIll.affectEntity(this, this.getThrower(), llllllllllllllllIIllllIlIIlIllll, llllllllllllllllIIllllIlIIlIllII.getAmplifier(), llllllllllllllllIIllllIlIIlIllIl);
                        }
                        else {
                            final int llllllllllllllllIIllllIlIIlIlIlI = (int)(llllllllllllllllIIllllIlIIlIllIl * llllllllllllllllIIllllIlIIlIllII.getDuration() + 0.5);
                            if (llllllllllllllllIIllllIlIIlIlIlI <= 20) {
                                continue;
                            }
                            llllllllllllllllIIllllIlIIlIllll.addPotionEffect(new PotionEffect(llllllllllllllllIIllllIlIIlIlIll, llllllllllllllllIIllllIlIIlIlIlI, llllllllllllllllIIllllIlIIlIllII.getAmplifier(), llllllllllllllllIIllllIlIIlIllII.getIsAmbient(), llllllllllllllllIIllllIlIIlIllII.doesShowParticles()));
                        }
                    }
                }
            }
        }
    }
    
    public void setItem(final ItemStack llllllllllllllllIIllllIlIlllIIIl) {
        this.getDataManager().set(EntityPotion.ITEM, llllllllllllllllIIllllIlIlllIIIl);
        this.getDataManager().setDirty(EntityPotion.ITEM);
    }
    
    private boolean isLingering() {
        return this.getPotion().getItem() == Items.LINGERING_POTION;
    }
    
    public EntityPotion(final World llllllllllllllllIIllllIllIIIIIlI, final double llllllllllllllllIIllllIllIIIIlll, final double llllllllllllllllIIllllIllIIIIllI, final double llllllllllllllllIIllllIlIlllllll, final ItemStack llllllllllllllllIIllllIllIIIIlII) {
        super(llllllllllllllllIIllllIllIIIIIlI, llllllllllllllllIIllllIllIIIIlll, llllllllllllllllIIllllIllIIIIllI, llllllllllllllllIIllllIlIlllllll);
        if (!llllllllllllllllIIllllIllIIIIlII.func_190926_b()) {
            this.setItem(llllllllllllllllIIllllIllIIIIlII);
        }
    }
    
    private void func_190545_n() {
        final AxisAlignedBB llllllllllllllllIIllllIlIlIIlIll = this.getEntityBoundingBox().expand(4.0, 2.0, 4.0);
        final List<EntityLivingBase> llllllllllllllllIIllllIlIlIIlIlI = this.world.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, llllllllllllllllIIllllIlIlIIlIll, (com.google.common.base.Predicate<? super EntityLivingBase>)EntityPotion.field_190546_d);
        if (!llllllllllllllllIIllllIlIlIIlIlI.isEmpty()) {
            for (final EntityLivingBase llllllllllllllllIIllllIlIlIIlIIl : llllllllllllllllIIllllIlIlIIlIlI) {
                final double llllllllllllllllIIllllIlIlIIlIII = this.getDistanceSqToEntity(llllllllllllllllIIllllIlIlIIlIIl);
                if (llllllllllllllllIIllllIlIlIIlIII < 16.0 && func_190544_c(llllllllllllllllIIllllIlIlIIlIIl)) {
                    llllllllllllllllIIllllIlIlIIlIIl.attackEntityFrom(DamageSource.drown, 1.0f);
                }
            }
        }
    }
    
    @Override
    protected void entityInit() {
        this.getDataManager().register(EntityPotion.ITEM, ItemStack.field_190927_a);
    }
    
    @Override
    protected void onImpact(final RayTraceResult llllllllllllllllIIllllIlIllIIIll) {
        if (!this.world.isRemote) {
            final ItemStack llllllllllllllllIIllllIlIllIIIlI = this.getPotion();
            final PotionType llllllllllllllllIIllllIlIllIIIIl = PotionUtils.getPotionFromItem(llllllllllllllllIIllllIlIllIIIlI);
            final List<PotionEffect> llllllllllllllllIIllllIlIllIIIII = PotionUtils.getEffectsFromStack(llllllllllllllllIIllllIlIllIIIlI);
            final boolean llllllllllllllllIIllllIlIlIlllll = llllllllllllllllIIllllIlIllIIIIl == PotionTypes.WATER && llllllllllllllllIIllllIlIllIIIII.isEmpty();
            if (llllllllllllllllIIllllIlIllIIIll.typeOfHit == RayTraceResult.Type.BLOCK && llllllllllllllllIIllllIlIlIlllll) {
                final BlockPos llllllllllllllllIIllllIlIlIllllI = llllllllllllllllIIllllIlIllIIIll.getBlockPos().offset(llllllllllllllllIIllllIlIllIIIll.sideHit);
                this.extinguishFires(llllllllllllllllIIllllIlIlIllllI, llllllllllllllllIIllllIlIllIIIll.sideHit);
                for (final EnumFacing llllllllllllllllIIllllIlIlIlllIl : EnumFacing.Plane.HORIZONTAL) {
                    this.extinguishFires(llllllllllllllllIIllllIlIlIllllI.offset(llllllllllllllllIIllllIlIlIlllIl), llllllllllllllllIIllllIlIlIlllIl);
                }
            }
            if (llllllllllllllllIIllllIlIlIlllll) {
                this.func_190545_n();
            }
            else if (!llllllllllllllllIIllllIlIllIIIII.isEmpty()) {
                if (this.isLingering()) {
                    this.func_190542_a(llllllllllllllllIIllllIlIllIIIlI, llllllllllllllllIIllllIlIllIIIIl);
                }
                else {
                    this.func_190543_a(llllllllllllllllIIllllIlIllIIIll, llllllllllllllllIIllllIlIllIIIII);
                }
            }
            final int llllllllllllllllIIllllIlIlIlllII = llllllllllllllllIIllllIlIllIIIIl.hasInstantEffect() ? 2007 : 2002;
            this.world.playEvent(llllllllllllllllIIllllIlIlIlllII, new BlockPos(this), PotionUtils.func_190932_c(llllllllllllllllIIllllIlIllIIIlI));
            this.setDead();
        }
    }
    
    public static void registerFixesPotion(final DataFixer llllllllllllllllIIllllIIllllllIl) {
        EntityThrowable.registerFixesThrowable(llllllllllllllllIIllllIIllllllIl, "ThrownPotion");
        llllllllllllllllIIllllIIllllllIl.registerWalker(FixTypes.ENTITY, new ItemStackData(EntityPotion.class, new String[] { "Potion" }));
    }
    
    private void func_190542_a(final ItemStack llllllllllllllllIIllllIlIIIlIlIl, final PotionType llllllllllllllllIIllllIlIIIlIlII) {
        final EntityAreaEffectCloud llllllllllllllllIIllllIlIIIlIIll = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
        llllllllllllllllIIllllIlIIIlIIll.setOwner(this.getThrower());
        llllllllllllllllIIllllIlIIIlIIll.setRadius(3.0f);
        llllllllllllllllIIllllIlIIIlIIll.setRadiusOnUse(-0.5f);
        llllllllllllllllIIllllIlIIIlIIll.setWaitTime(10);
        llllllllllllllllIIllllIlIIIlIIll.setRadiusPerTick(-llllllllllllllllIIllllIlIIIlIIll.getRadius() / llllllllllllllllIIllllIlIIIlIIll.getDuration());
        llllllllllllllllIIllllIlIIIlIIll.setPotion(llllllllllllllllIIllllIlIIIlIlII);
        for (final PotionEffect llllllllllllllllIIllllIlIIIlIIlI : PotionUtils.getFullEffectsFromItem(llllllllllllllllIIllllIlIIIlIlIl)) {
            llllllllllllllllIIllllIlIIIlIIll.addEffect(new PotionEffect(llllllllllllllllIIllllIlIIIlIIlI));
        }
        final NBTTagCompound llllllllllllllllIIllllIlIIIlIIIl = llllllllllllllllIIllllIlIIIlIlIl.getTagCompound();
        if (llllllllllllllllIIllllIlIIIlIIIl != null && llllllllllllllllIIllllIlIIIlIIIl.hasKey("CustomPotionColor", 99)) {
            llllllllllllllllIIllllIlIIIlIIll.setColor(llllllllllllllllIIllllIlIIIlIIIl.getInteger("CustomPotionColor"));
        }
        this.world.spawnEntityInWorld(llllllllllllllllIIllllIlIIIlIIll);
    }
    
    public ItemStack getPotion() {
        final ItemStack llllllllllllllllIIllllIlIlllIlll = this.getDataManager().get(EntityPotion.ITEM);
        if (llllllllllllllllIIllllIlIlllIlll.getItem() != Items.SPLASH_POTION && llllllllllllllllIIllllIlIlllIlll.getItem() != Items.LINGERING_POTION) {
            if (this.world != null) {
                EntityPotion.LOGGER.error("ThrownPotion entity {} has no item?!", (Object)this.getEntityId());
            }
            return new ItemStack(Items.SPLASH_POTION);
        }
        return llllllllllllllllIIllllIlIlllIlll;
    }
    
    public EntityPotion(final World llllllllllllllllIIllllIllIIlIllI, final EntityLivingBase llllllllllllllllIIllllIllIIlIlIl, final ItemStack llllllllllllllllIIllllIllIIlIIII) {
        super(llllllllllllllllIIllllIllIIlIllI, llllllllllllllllIIllllIllIIlIlIl);
        this.setItem(llllllllllllllllIIllllIllIIlIIII);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIllllIIlllIlllI) {
        super.writeEntityToNBT(llllllllllllllllIIllllIIlllIlllI);
        final ItemStack llllllllllllllllIIllllIIlllIllIl = this.getPotion();
        if (!llllllllllllllllIIllllIIlllIllIl.func_190926_b()) {
            llllllllllllllllIIllllIIlllIlllI.setTag("Potion", llllllllllllllllIIllllIIlllIllIl.writeToNBT(new NBTTagCompound()));
        }
    }
    
    @Override
    protected float getGravityVelocity() {
        return 0.05f;
    }
    
    private static boolean func_190544_c(final EntityLivingBase llllllllllllllllIIllllIIlllIlIII) {
        return llllllllllllllllIIllllIIlllIlIII instanceof EntityEnderman || llllllllllllllllIIllllIIlllIlIII instanceof EntityBlaze;
    }
    
    private void extinguishFires(final BlockPos llllllllllllllllIIllllIlIIIIIIll, final EnumFacing llllllllllllllllIIllllIlIIIIIIlI) {
        if (this.world.getBlockState(llllllllllllllllIIllllIlIIIIIIll).getBlock() == Blocks.FIRE) {
            this.world.extinguishFire(null, llllllllllllllllIIllllIlIIIIIIll.offset(llllllllllllllllIIllllIlIIIIIIlI), llllllllllllllllIIllllIlIIIIIIlI.getOpposite());
        }
    }
    
    public EntityPotion(final World llllllllllllllllIIllllIllIIlllII) {
        super(llllllllllllllllIIllllIllIIlllII);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIllllIIllllIlII) {
        super.readEntityFromNBT(llllllllllllllllIIllllIIllllIlII);
        final ItemStack llllllllllllllllIIllllIIllllIllI = new ItemStack(llllllllllllllllIIllllIIllllIlII.getCompoundTag("Potion"));
        if (llllllllllllllllIIllllIIllllIllI.func_190926_b()) {
            this.setDead();
        }
        else {
            this.setItem(llllllllllllllllIIllllIIllllIllI);
        }
    }
    
    static {
        ITEM = EntityDataManager.createKey(EntityPotion.class, DataSerializers.OPTIONAL_ITEM_STACK);
        LOGGER = LogManager.getLogger();
        field_190546_d = (Predicate)new Predicate<EntityLivingBase>() {
            public boolean apply(@Nullable final EntityLivingBase lllllllllllllIlIIllIIIIlIIIIIlIl) {
                return func_190544_c(lllllllllllllIlIIllIIIIlIIIIIlIl);
            }
        };
    }
}
