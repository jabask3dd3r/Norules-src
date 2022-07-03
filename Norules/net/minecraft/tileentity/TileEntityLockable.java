package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.util.text.*;

public abstract class TileEntityLockable extends TileEntity implements ILockableContainer
{
    private /* synthetic */ LockCode code;
    
    @Override
    public void setLockCode(final LockCode llllllllllllllIIIIIllIIIIIllIlll) {
        this.code = llllllllllllllIIIIIllIIIIIllIlll;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIIIIllIIIIlIIIIIl) {
        super.writeToNBT(llllllllllllllIIIIIllIIIIlIIIIIl);
        if (this.code != null) {
            this.code.toNBT(llllllllllllllIIIIIllIIIIlIIIIIl);
        }
        return llllllllllllllIIIIIllIIIIlIIIIIl;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIIIllIIIIlIIlIIl) {
        super.readFromNBT(llllllllllllllIIIIIllIIIIlIIlIIl);
        this.code = LockCode.fromNBT(llllllllllllllIIIIIllIIIIlIIlIIl);
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    @Override
    public LockCode getLockCode() {
        return this.code;
    }
    
    @Override
    public boolean isLocked() {
        return this.code != null && !this.code.isEmpty();
    }
    
    public TileEntityLockable() {
        this.code = LockCode.EMPTY_CODE;
    }
}
