package net.minecraft.entity;

import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class MultiPartEntityPart extends Entity
{
    public final /* synthetic */ String partName;
    public final /* synthetic */ IEntityMultiPart entityDragonObj;
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public MultiPartEntityPart(final IEntityMultiPart lllllllllllllIllIlIllllIlIIllIII, final String lllllllllllllIllIlIllllIlIIlllII, final float lllllllllllllIllIlIllllIlIIllIll, final float lllllllllllllIllIlIllllIlIIllIlI) {
        super(lllllllllllllIllIlIllllIlIIllIII.getWorld());
        this.setSize(lllllllllllllIllIlIllllIlIIllIll, lllllllllllllIllIlIllllIlIIllIlI);
        this.entityDragonObj = lllllllllllllIllIlIllllIlIIllIII;
        this.partName = lllllllllllllIllIlIllllIlIIlllII;
    }
    
    @Override
    public boolean isEntityEqual(final Entity lllllllllllllIllIlIllllIlIIIIIII) {
        return this == lllllllllllllIllIlIllllIlIIIIIII || this.entityDragonObj == lllllllllllllIllIlIllllIlIIIIIII;
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIllIlIllllIlIIlIIlI) {
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIllIlIllllIlIIlIIII) {
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIllIlIllllIlIIIIlll, final float lllllllllllllIllIlIllllIlIIIIllI) {
        return !this.isEntityInvulnerable(lllllllllllllIllIlIllllIlIIIIlll) && this.entityDragonObj.attackEntityFromPart(this, lllllllllllllIllIlIllllIlIIIIlll, lllllllllllllIllIlIllllIlIIIIllI);
    }
}
