package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.entity.boss.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.creativetab.*;
import net.minecraft.stats.*;

public class ItemGlassBottle extends Item
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIlIIIlIllllIIIIIIII, final EntityPlayer lllllllllllllIlIIIlIlllIllllllll, final EnumHand lllllllllllllIlIIIlIllllIIIIIlll) {
        final List<EntityAreaEffectCloud> lllllllllllllIlIIIlIllllIIIIIllI = lllllllllllllIlIIIlIllllIIIIIIII.getEntitiesWithinAABB((Class<? extends EntityAreaEffectCloud>)EntityAreaEffectCloud.class, lllllllllllllIlIIIlIlllIllllllll.getEntityBoundingBox().expandXyz(2.0), (com.google.common.base.Predicate<? super EntityAreaEffectCloud>)new Predicate<EntityAreaEffectCloud>() {
            public boolean apply(@Nullable final EntityAreaEffectCloud lIIlIIllllllIl) {
                return lIIlIIllllllIl != null && lIIlIIllllllIl.isEntityAlive() && lIIlIIllllllIl.getOwner() instanceof EntityDragon;
            }
        });
        final ItemStack lllllllllllllIlIIIlIllllIIIIIlIl = lllllllllllllIlIIIlIlllIllllllll.getHeldItem(lllllllllllllIlIIIlIllllIIIIIlll);
        if (!lllllllllllllIlIIIlIllllIIIIIllI.isEmpty()) {
            final EntityAreaEffectCloud lllllllllllllIlIIIlIllllIIIIIlII = lllllllllllllIlIIIlIllllIIIIIllI.get(0);
            lllllllllllllIlIIIlIllllIIIIIlII.setRadius(lllllllllllllIlIIIlIllllIIIIIlII.getRadius() - 0.5f);
            lllllllllllllIlIIIlIllllIIIIIIII.playSound(null, lllllllllllllIlIIIlIlllIllllllll.posX, lllllllllllllIlIIIlIlllIllllllll.posY, lllllllllllllIlIIIlIlllIllllllll.posZ, SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.turnBottleIntoItem(lllllllllllllIlIIIlIllllIIIIIlIl, lllllllllllllIlIIIlIlllIllllllll, new ItemStack(Items.DRAGON_BREATH)));
        }
        final RayTraceResult lllllllllllllIlIIIlIllllIIIIIIll = this.rayTrace(lllllllllllllIlIIIlIllllIIIIIIII, lllllllllllllIlIIIlIlllIllllllll, true);
        if (lllllllllllllIlIIIlIllllIIIIIIll == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllIlIIIlIllllIIIIIlIl);
        }
        if (lllllllllllllIlIIIlIllllIIIIIIll.typeOfHit == RayTraceResult.Type.BLOCK) {
            final BlockPos lllllllllllllIlIIIlIllllIIIIIIlI = lllllllllllllIlIIIlIllllIIIIIIll.getBlockPos();
            if (!lllllllllllllIlIIIlIllllIIIIIIII.isBlockModifiable(lllllllllllllIlIIIlIlllIllllllll, lllllllllllllIlIIIlIllllIIIIIIlI) || !lllllllllllllIlIIIlIlllIllllllll.canPlayerEdit(lllllllllllllIlIIIlIllllIIIIIIlI.offset(lllllllllllllIlIIIlIllllIIIIIIll.sideHit), lllllllllllllIlIIIlIllllIIIIIIll.sideHit, lllllllllllllIlIIIlIllllIIIIIlIl)) {
                return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllIlIIIlIllllIIIIIlIl);
            }
            if (lllllllllllllIlIIIlIllllIIIIIIII.getBlockState(lllllllllllllIlIIIlIllllIIIIIIlI).getMaterial() == Material.WATER) {
                lllllllllllllIlIIIlIllllIIIIIIII.playSound(lllllllllllllIlIIIlIlllIllllllll, lllllllllllllIlIIIlIlllIllllllll.posX, lllllllllllllIlIIIlIlllIllllllll.posY, lllllllllllllIlIIIlIlllIllllllll.posZ, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.turnBottleIntoItem(lllllllllllllIlIIIlIllllIIIIIlIl, lllllllllllllIlIIIlIlllIllllllll, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER)));
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllIlIIIlIllllIIIIIlIl);
    }
    
    public ItemGlassBottle() {
        this.setCreativeTab(CreativeTabs.BREWING);
    }
    
    protected ItemStack turnBottleIntoItem(final ItemStack lllllllllllllIlIIIlIlllIllllIIII, final EntityPlayer lllllllllllllIlIIIlIlllIlllIllll, final ItemStack lllllllllllllIlIIIlIlllIlllIlllI) {
        lllllllllllllIlIIIlIlllIllllIIII.func_190918_g(1);
        lllllllllllllIlIIIlIlllIlllIllll.addStat(StatList.getObjectUseStats(this));
        if (lllllllllllllIlIIIlIlllIllllIIII.func_190926_b()) {
            return lllllllllllllIlIIIlIlllIlllIlllI;
        }
        if (!lllllllllllllIlIIIlIlllIlllIllll.inventory.addItemStackToInventory(lllllllllllllIlIIIlIlllIlllIlllI)) {
            lllllllllllllIlIIIlIlllIlllIllll.dropItem(lllllllllllllIlIIIlIlllIlllIlllI, false);
        }
        return lllllllllllllIlIIIlIlllIllllIIII;
    }
}
