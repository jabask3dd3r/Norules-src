package net.minecraft.entity.ai;

import net.minecraft.entity.player.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.entity.monster.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityAINearestAttackableTarget<T extends EntityLivingBase> extends EntityAITarget
{
    private final /* synthetic */ int targetChance;
    protected final /* synthetic */ Predicate<? super T> targetEntitySelector;
    protected /* synthetic */ T targetEntity;
    protected final /* synthetic */ Class<T> targetClass;
    protected final /* synthetic */ Sorter theNearestAttackableTargetSorter;
    
    public EntityAINearestAttackableTarget(final EntityCreature lllllllllllllIlIIIIIIIlIIlIIIlII, final Class<T> lllllllllllllIlIIIIIIIlIIlIIIIll, final boolean lllllllllllllIlIIIIIIIlIIIlllllI) {
        this(lllllllllllllIlIIIIIIIlIIlIIIlII, lllllllllllllIlIIIIIIIlIIlIIIIll, lllllllllllllIlIIIIIIIlIIIlllllI, false);
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0) {
            return false;
        }
        if (this.targetClass == EntityPlayer.class || this.targetClass == EntityPlayerMP.class) {
            this.targetEntity = (T)this.taskOwner.world.getNearestAttackablePlayer(this.taskOwner.posX, this.taskOwner.posY + this.taskOwner.getEyeHeight(), this.taskOwner.posZ, this.getTargetDistance(), this.getTargetDistance(), (Function<EntityPlayer, Double>)new Function<EntityPlayer, Double>() {
                @Nullable
                public Double apply(@Nullable final EntityPlayer lllllllllllllIlIlllIIIIlIlIlIlll) {
                    final ItemStack lllllllllllllIlIlllIIIIlIlIlllIl = lllllllllllllIlIlllIIIIlIlIlIlll.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                    if (lllllllllllllIlIlllIIIIlIlIlllIl.getItem() == Items.SKULL) {
                        final int lllllllllllllIlIlllIIIIlIlIlllII = lllllllllllllIlIlllIIIIlIlIlllIl.getItemDamage();
                        final boolean lllllllllllllIlIlllIIIIlIlIllIll = EntityAINearestAttackableTarget.this.taskOwner instanceof EntitySkeleton && lllllllllllllIlIlllIIIIlIlIlllII == 0;
                        final boolean lllllllllllllIlIlllIIIIlIlIllIlI = EntityAINearestAttackableTarget.this.taskOwner instanceof EntityZombie && lllllllllllllIlIlllIIIIlIlIlllII == 2;
                        final boolean lllllllllllllIlIlllIIIIlIlIllIIl = EntityAINearestAttackableTarget.this.taskOwner instanceof EntityCreeper && lllllllllllllIlIlllIIIIlIlIlllII == 4;
                        if (lllllllllllllIlIlllIIIIlIlIllIll || lllllllllllllIlIlllIIIIlIlIllIlI || lllllllllllllIlIlllIIIIlIlIllIIl) {
                            return 0.5;
                        }
                    }
                    return 1.0;
                }
            }, (Predicate<EntityPlayer>)this.targetEntitySelector);
            return this.targetEntity != null;
        }
        final List<T> lllllllllllllIlIIIIIIIlIIIIlIllI = this.taskOwner.world.getEntitiesWithinAABB((Class<? extends T>)this.targetClass, this.getTargetableArea(this.getTargetDistance()), this.targetEntitySelector);
        if (lllllllllllllIlIIIIIIIlIIIIlIllI.isEmpty()) {
            return false;
        }
        Collections.sort(lllllllllllllIlIIIIIIIlIIIIlIllI, this.theNearestAttackableTargetSorter);
        this.targetEntity = lllllllllllllIlIIIIIIIlIIIIlIllI.get(0);
        return true;
    }
    
    protected AxisAlignedBB getTargetableArea(final double lllllllllllllIlIIIIIIIlIIIIIlllI) {
        return this.taskOwner.getEntityBoundingBox().expand(lllllllllllllIlIIIIIIIlIIIIIlllI, 4.0, lllllllllllllIlIIIIIIIlIIIIIlllI);
    }
    
    public EntityAINearestAttackableTarget(final EntityCreature lllllllllllllIlIIIIIIIlIIIlIIllI, final Class<T> lllllllllllllIlIIIIIIIlIIIIllllI, final int lllllllllllllIlIIIIIIIlIIIIlllIl, final boolean lllllllllllllIlIIIIIIIlIIIIlllII, final boolean lllllllllllllIlIIIIIIIlIIIIllIll, @Nullable final Predicate<? super T> lllllllllllllIlIIIIIIIlIIIIllIlI) {
        super(lllllllllllllIlIIIIIIIlIIIlIIllI, lllllllllllllIlIIIIIIIlIIIIlllII, lllllllllllllIlIIIIIIIlIIIIllIll);
        this.targetClass = lllllllllllllIlIIIIIIIlIIIIllllI;
        this.targetChance = lllllllllllllIlIIIIIIIlIIIIlllIl;
        this.theNearestAttackableTargetSorter = new Sorter(lllllllllllllIlIIIIIIIlIIIlIIllI);
        this.setMutexBits(1);
        this.targetEntitySelector = (Predicate<? super T>)new Predicate<T>() {
            public boolean apply(@Nullable final T lllllllllllllIlIllIlllIlllIIIlIl) {
                return lllllllllllllIlIllIlllIlllIIIlIl != null && (lllllllllllllIlIIIIIIIlIIIIllIlI == null || lllllllllllllIlIIIIIIIlIIIIllIlI.apply((Object)lllllllllllllIlIllIlllIlllIIIlIl)) && EntitySelectors.NOT_SPECTATING.apply((Object)lllllllllllllIlIllIlllIlllIIIlIl) && EntityAINearestAttackableTarget.this.isSuitableTarget(lllllllllllllIlIllIlllIlllIIIlIl, false);
            }
        };
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }
    
    public EntityAINearestAttackableTarget(final EntityCreature lllllllllllllIlIIIIIIIlIIIllIlll, final Class<T> lllllllllllllIlIIIIIIIlIIIllIIIl, final boolean lllllllllllllIlIIIIIIIlIIIllIIII, final boolean lllllllllllllIlIIIIIIIlIIIlIllll) {
        this(lllllllllllllIlIIIIIIIlIIIllIlll, lllllllllllllIlIIIIIIIlIIIllIIIl, 10, lllllllllllllIlIIIIIIIlIIIllIIII, lllllllllllllIlIIIIIIIlIIIlIllll, null);
    }
    
    public static class Sorter implements Comparator<Entity>
    {
        private final /* synthetic */ Entity theEntity;
        
        @Override
        public int compare(final Entity lllllllllllllIIIIIllIlIlllllllll, final Entity lllllllllllllIIIIIllIlIllllllllI) {
            final double lllllllllllllIIIIIllIllIIIIIIIlI = this.theEntity.getDistanceSqToEntity(lllllllllllllIIIIIllIlIlllllllll);
            final double lllllllllllllIIIIIllIllIIIIIIIIl = this.theEntity.getDistanceSqToEntity(lllllllllllllIIIIIllIlIllllllllI);
            if (lllllllllllllIIIIIllIllIIIIIIIlI < lllllllllllllIIIIIllIllIIIIIIIIl) {
                return -1;
            }
            return (lllllllllllllIIIIIllIllIIIIIIIlI > lllllllllllllIIIIIllIllIIIIIIIIl) ? 1 : 0;
        }
        
        public Sorter(final Entity lllllllllllllIIIIIllIllIIIIIllIl) {
            this.theEntity = lllllllllllllIIIIIllIllIIIIIllIl;
        }
    }
}
