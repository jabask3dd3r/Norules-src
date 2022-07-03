package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class RidingToPassengers implements IFixableData
{
    protected NBTTagCompound extractVehicle(final NBTTagCompound llllllllllllllIIIIlIlIIIIlIlIIll) {
        final NBTTagCompound llllllllllllllIIIIlIlIIIIlIlIIlI = llllllllllllllIIIIlIlIIIIlIlIIll.getCompoundTag("Riding");
        llllllllllllllIIIIlIlIIIIlIlIIll.removeTag("Riding");
        return llllllllllllllIIIIlIlIIIIlIlIIlI;
    }
    
    @Override
    public int getFixVersion() {
        return 135;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(NBTTagCompound llllllllllllllIIIIlIlIIIIllIIIlI) {
        while (llllllllllllllIIIIlIlIIIIllIIIlI.hasKey("Riding", 10)) {
            final NBTTagCompound llllllllllllllIIIIlIlIIIIllIIlII = this.extractVehicle(llllllllllllllIIIIlIlIIIIllIIIlI);
            this.addPassengerToVehicle(llllllllllllllIIIIlIlIIIIllIIIlI, llllllllllllllIIIIlIlIIIIllIIlII);
            llllllllllllllIIIIlIlIIIIllIIIlI = llllllllllllllIIIIlIlIIIIllIIlII;
        }
        return llllllllllllllIIIIlIlIIIIllIIIlI;
    }
    
    protected void addPassengerToVehicle(final NBTTagCompound llllllllllllllIIIIlIlIIIIlIlllII, final NBTTagCompound llllllllllllllIIIIlIlIIIIlIllIII) {
        final NBTTagList llllllllllllllIIIIlIlIIIIlIllIlI = new NBTTagList();
        llllllllllllllIIIIlIlIIIIlIllIlI.appendTag(llllllllllllllIIIIlIlIIIIlIlllII);
        llllllllllllllIIIIlIlIIIIlIllIII.setTag("Passengers", llllllllllllllIIIIlIlIIIIlIllIlI);
    }
}
