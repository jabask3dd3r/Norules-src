package net.minecraft.tileentity;

import net.minecraft.nbt.*;

public class TileEntityComparator extends TileEntity
{
    private /* synthetic */ int outputSignal;
    
    @Override
    public void readFromNBT(final NBTTagCompound lIIlllllIlIIlII) {
        super.readFromNBT(lIIlllllIlIIlII);
        this.outputSignal = lIIlllllIlIIlII.getInteger("OutputSignal");
    }
    
    public void setOutputSignal(final int lIIlllllIIllIll) {
        this.outputSignal = lIIlllllIIllIll;
    }
    
    public int getOutputSignal() {
        return this.outputSignal;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lIIlllllIlIlIII) {
        super.writeToNBT(lIIlllllIlIlIII);
        lIIlllllIlIlIII.setInteger("OutputSignal", this.outputSignal);
        return lIIlllllIlIlIII;
    }
}
