package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;

public class ItemHangingEntity extends Item
{
    private final /* synthetic */ Class<? extends EntityHanging> hangingEntityClass;
    
    @Nullable
    private EntityHanging createEntity(final World lllllllllllllIllIlllIIIIIllIlIII, final BlockPos lllllllllllllIllIlllIIIIIllIIlll, final EnumFacing lllllllllllllIllIlllIIIIIllIIIlI) {
        if (this.hangingEntityClass == EntityPainting.class) {
            return new EntityPainting(lllllllllllllIllIlllIIIIIllIlIII, lllllllllllllIllIlllIIIIIllIIlll, lllllllllllllIllIlllIIIIIllIIIlI);
        }
        return (this.hangingEntityClass == EntityItemFrame.class) ? new EntityItemFrame(lllllllllllllIllIlllIIIIIllIlIII, lllllllllllllIllIlllIIIIIllIIlll, lllllllllllllIllIlllIIIIIllIIIlI) : null;
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIllIlllIIIIIlllIlIl, final World lllllllllllllIllIlllIIIIIlllIlII, final BlockPos lllllllllllllIllIlllIIIIIlllllll, final EnumHand lllllllllllllIllIlllIIIIIllllllI, final EnumFacing lllllllllllllIllIlllIIIIIlllllIl, final float lllllllllllllIllIlllIIIIIlllllII, final float lllllllllllllIllIlllIIIIIllllIll, final float lllllllllllllIllIlllIIIIIllllIlI) {
        final ItemStack lllllllllllllIllIlllIIIIIllllIIl = lllllllllllllIllIlllIIIIIlllIlIl.getHeldItem(lllllllllllllIllIlllIIIIIllllllI);
        final BlockPos lllllllllllllIllIlllIIIIIllllIII = lllllllllllllIllIlllIIIIIlllllll.offset(lllllllllllllIllIlllIIIIIlllllIl);
        if (lllllllllllllIllIlllIIIIIlllllIl != EnumFacing.DOWN && lllllllllllllIllIlllIIIIIlllllIl != EnumFacing.UP && lllllllllllllIllIlllIIIIIlllIlIl.canPlayerEdit(lllllllllllllIllIlllIIIIIllllIII, lllllllllllllIllIlllIIIIIlllllIl, lllllllllllllIllIlllIIIIIllllIIl)) {
            final EntityHanging lllllllllllllIllIlllIIIIIlllIlll = this.createEntity(lllllllllllllIllIlllIIIIIlllIlII, lllllllllllllIllIlllIIIIIllllIII, lllllllllllllIllIlllIIIIIlllllIl);
            if (lllllllllllllIllIlllIIIIIlllIlll != null && lllllllllllllIllIlllIIIIIlllIlll.onValidSurface()) {
                if (!lllllllllllllIllIlllIIIIIlllIlII.isRemote) {
                    lllllllllllllIllIlllIIIIIlllIlll.playPlaceSound();
                    lllllllllllllIllIlllIIIIIlllIlII.spawnEntityInWorld(lllllllllllllIllIlllIIIIIlllIlll);
                }
                lllllllllllllIllIlllIIIIIllllIIl.func_190918_g(1);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }
    
    public ItemHangingEntity(final Class<? extends EntityHanging> lllllllllllllIllIlllIIIIlIIIlllI) {
        this.hangingEntityClass = lllllllllllllIllIlllIIIIlIIIlllI;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
