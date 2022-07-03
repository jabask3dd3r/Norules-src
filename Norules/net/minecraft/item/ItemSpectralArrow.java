package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.*;

public class ItemSpectralArrow extends ItemArrow
{
    @Override
    public EntityArrow createArrow(final World lllllllllllllIlIIlllllIllIlIllIl, final ItemStack lllllllllllllIlIIlllllIllIlIllll, final EntityLivingBase lllllllllllllIlIIlllllIllIlIllII) {
        return new EntitySpectralArrow(lllllllllllllIlIIlllllIllIlIllIl, lllllllllllllIlIIlllllIllIlIllII);
    }
}
