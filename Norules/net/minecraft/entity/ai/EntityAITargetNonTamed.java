package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import com.google.common.base.*;
import net.minecraft.entity.*;

public class EntityAITargetNonTamed<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
{
    private final /* synthetic */ EntityTameable theTameable;
    
    public EntityAITargetNonTamed(final EntityTameable lllllllllllllIIlllIIIllllIIIlllI, final Class<T> lllllllllllllIIlllIIIllllIIlIIlI, final boolean lllllllllllllIIlllIIIllllIIlIIIl, final Predicate<? super T> lllllllllllllIIlllIIIllllIIIlIll) {
        super(lllllllllllllIIlllIIIllllIIIlllI, lllllllllllllIIlllIIIllllIIlIIlI, 10, lllllllllllllIIlllIIIllllIIlIIIl, false, lllllllllllllIIlllIIIllllIIIlIll);
        this.theTameable = lllllllllllllIIlllIIIllllIIIlllI;
    }
    
    @Override
    public boolean shouldExecute() {
        return !this.theTameable.isTamed() && super.shouldExecute();
    }
}
