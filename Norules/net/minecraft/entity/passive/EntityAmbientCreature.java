package net.minecraft.entity.passive;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public abstract class EntityAmbientCreature extends EntityLiving implements IAnimals
{
    @Override
    public boolean canBeLeashedTo(final EntityPlayer lllllllllllllIlIIllllIIIIIllIlIl) {
        return false;
    }
    
    public EntityAmbientCreature(final World lllllllllllllIlIIllllIIIIIllIlll) {
        super(lllllllllllllIlIIllllIIIIIllIlll);
    }
}
