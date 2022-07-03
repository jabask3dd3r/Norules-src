package net.minecraft.util;

import javax.annotation.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import com.google.common.base.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;

public final class EntitySelectors
{
    public static final /* synthetic */ Predicate<Entity> NOT_SPECTATING;
    
    public static <T extends Entity> Predicate<T> withinRange(final double llllllllllllllIIIIIIllIllIlIlllI, final double llllllllllllllIIIIIIllIllIllIIlI, final double llllllllllllllIIIIIIllIllIlIllII, final double llllllllllllllIIIIIIllIllIllIIII) {
        final double llllllllllllllIIIIIIllIllIlIllll = llllllllllllllIIIIIIllIllIllIIII * llllllllllllllIIIIIIllIllIllIIII;
        return (Predicate<T>)new Predicate<T>() {
            public boolean apply(@Nullable final T llllllllllllllIllllIlllllIllIIII) {
                return llllllllllllllIllllIlllllIllIIII != null && llllllllllllllIllllIlllllIllIIII.getDistanceSq(llllllllllllllIIIIIIllIllIlIlllI, llllllllllllllIIIIIIllIllIllIIlI, llllllllllllllIIIIIIllIllIlIllII) <= llllllllllllllIIIIIIllIllIlIllll;
            }
        };
    }
    
    static {
        IS_ALIVE = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIllIllIIIIIIlIlIlI) {
                return lllllllllllllIIllIllIIIIIIlIlIlI.isEntityAlive();
            }
        };
        IS_STANDALONE = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllllIIlllIIIIIIIllIIl) {
                return lllllllllllllllIIlllIIIIIIIllIIl.isEntityAlive() && !lllllllllllllllIIlllIIIIIIIllIIl.isBeingRidden() && !lllllllllllllllIIlllIIIIIIIllIIl.isRiding();
            }
        };
        HAS_INVENTORY = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity llllllllllllllIIIIllIlllIIIlIlll) {
                return llllllllllllllIIIIllIlllIIIlIlll instanceof IInventory && llllllllllllllIIIIllIlllIIIlIlll.isEntityAlive();
            }
        };
        CAN_AI_TARGET = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllllIIllIlIIIIlIlIIIl) {
                return !(lllllllllllllllIIllIlIIIIlIlIIIl instanceof EntityPlayer) || (!((EntityPlayer)lllllllllllllllIIllIlIIIIlIlIIIl).isSpectator() && !((EntityPlayer)lllllllllllllllIIllIlIIIIlIlIIIl).isCreative());
            }
        };
        NOT_SPECTATING = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIIlIllllIIllllIIll) {
                return !(lllllllllllllIIIlIllllIIllllIIll instanceof EntityPlayer) || !((EntityPlayer)lllllllllllllIIIlIllllIIllllIIll).isSpectator();
            }
        };
    }
    
    public static Predicate<Entity> func_191324_b(final Entity llllllllllllllIIIIIIllIllIIllIll) {
        return (Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable Entity lllllllllllllIlIIIlIIlllllIlIIII) {
                while (((Entity)lllllllllllllIlIIIlIIlllllIlIIII).isRiding()) {
                    lllllllllllllIlIIIlIIlllllIlIIII = ((Entity)lllllllllllllIlIIIlIIlllllIlIIII).getRidingEntity();
                    if (lllllllllllllIlIIIlIIlllllIlIIII != llllllllllllllIIIIIIllIllIIllIll) {
                        continue;
                    }
                    return false;
                }
                return true;
            }
        };
    }
    
    public static <T extends Entity> Predicate<T> getTeamCollisionPredicate(final Entity llllllllllllllIIIIIIllIllIlIIlIl) {
        final Team llllllllllllllIIIIIIllIllIlIIlII = llllllllllllllIIIIIIllIllIlIIlIl.getTeam();
        final Team.CollisionRule llllllllllllllIIIIIIllIllIlIIIll = (llllllllllllllIIIIIIllIllIlIIlII == null) ? Team.CollisionRule.ALWAYS : llllllllllllllIIIIIIllIllIlIIlII.getCollisionRule();
        final Predicate<?> llllllllllllllIIIIIIllIllIlIIIlI = (Predicate<?>)((llllllllllllllIIIIIIllIllIlIIIll == Team.CollisionRule.NEVER) ? Predicates.alwaysFalse() : Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity llllllllllllllIIIlIIIIIIlllIIlll) {
                if (!llllllllllllllIIIlIIIIIIlllIIlll.canBePushed()) {
                    return false;
                }
                if (llllllllllllllIIIIIIllIllIlIIlIl.world.isRemote && (!(llllllllllllllIIIlIIIIIIlllIIlll instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIlIIIIIIlllIIlll).isUser())) {
                    return false;
                }
                final Team llllllllllllllIIIlIIIIIIlllIIlIl = llllllllllllllIIIlIIIIIIlllIIlll.getTeam();
                final Team.CollisionRule llllllllllllllIIIlIIIIIIlllIIlII = (llllllllllllllIIIlIIIIIIlllIIlIl == null) ? Team.CollisionRule.ALWAYS : llllllllllllllIIIlIIIIIIlllIIlIl.getCollisionRule();
                if (llllllllllllllIIIlIIIIIIlllIIlII == Team.CollisionRule.NEVER) {
                    return false;
                }
                final boolean llllllllllllllIIIlIIIIIIlllIIIlI = llllllllllllllIIIIIIllIllIlIIlII != null && llllllllllllllIIIIIIllIllIlIIlII.isSameTeam(llllllllllllllIIIlIIIIIIlllIIlIl);
                return ((llllllllllllllIIIIIIllIllIlIIIll != Team.CollisionRule.HIDE_FOR_OWN_TEAM && llllllllllllllIIIlIIIIIIlllIIlII != Team.CollisionRule.HIDE_FOR_OWN_TEAM) || !llllllllllllllIIIlIIIIIIlllIIIlI) && ((llllllllllllllIIIIIIllIllIlIIIll != Team.CollisionRule.HIDE_FOR_OTHER_TEAMS && llllllllllllllIIIlIIIIIIlllIIlII != Team.CollisionRule.HIDE_FOR_OTHER_TEAMS) || llllllllllllllIIIlIIIIIIlllIIIlI);
            }
        }));
        return (Predicate<T>)llllllllllllllIIIIIIllIllIlIIIlI;
    }
    
    public static class ArmoredMob implements Predicate<Entity>
    {
        private final /* synthetic */ ItemStack armor;
        
        public ArmoredMob(final ItemStack lllllllllllllIlIllIIIlIIlllIIIll) {
            this.armor = lllllllllllllIlIllIIIlIIlllIIIll;
        }
        
        public boolean apply(@Nullable final Entity lllllllllllllIlIllIIIlIIllIllIll) {
            if (!lllllllllllllIlIllIIIlIIllIllIll.isEntityAlive()) {
                return false;
            }
            if (!(lllllllllllllIlIllIIIlIIllIllIll instanceof EntityLivingBase)) {
                return false;
            }
            final EntityLivingBase lllllllllllllIlIllIIIlIIllIlllIl = (EntityLivingBase)lllllllllllllIlIllIIIlIIllIllIll;
            if (!lllllllllllllIlIllIIIlIIllIlllIl.getItemStackFromSlot(EntityLiving.getSlotForItemStack(this.armor)).func_190926_b()) {
                return false;
            }
            if (lllllllllllllIlIllIIIlIIllIlllIl instanceof EntityLiving) {
                return ((EntityLiving)lllllllllllllIlIllIIIlIIllIlllIl).canPickUpLoot();
            }
            return lllllllllllllIlIllIIIlIIllIlllIl instanceof EntityArmorStand || lllllllllllllIlIllIIIlIIllIlllIl instanceof EntityPlayer;
        }
    }
}
