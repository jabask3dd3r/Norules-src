package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class RenderPotion extends RenderSnowball<EntityPotion>
{
    public RenderPotion(final RenderManager lllllllllllllIIIIIIIIlIlIllIlIll, final RenderItem lllllllllllllIIIIIIIIlIlIllIllIl) {
        super(lllllllllllllIIIIIIIIlIlIllIlIll, Items.POTIONITEM, lllllllllllllIIIIIIIIlIlIllIllIl);
    }
    
    @Override
    public ItemStack getStackToRender(final EntityPotion lllllllllllllIIIIIIIIlIlIllIIlll) {
        return lllllllllllllIIIIIIIIlIlIllIIlll.getPotion();
    }
}
