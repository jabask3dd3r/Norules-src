package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityAIWatchClosest2 extends EntityAIWatchClosest
{
    public EntityAIWatchClosest2(final EntityLiving llllllllllllllIlIIIlIlIIlIlllIII, final Class<? extends Entity> llllllllllllllIlIIIlIlIIlIllllII, final float llllllllllllllIlIIIlIlIIlIlllIll, final float llllllllllllllIlIIIlIlIIlIlllIlI) {
        super(llllllllllllllIlIIIlIlIIlIlllIII, llllllllllllllIlIIIlIlIIlIllllII, llllllllllllllIlIIIlIlIIlIlllIll, llllllllllllllIlIIIlIlIIlIlllIlI);
        this.setMutexBits(3);
    }
}
