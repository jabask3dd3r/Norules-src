package net.minecraft.world.gen.structure;

import net.minecraft.world.storage.*;
import net.minecraft.nbt.*;

public class MapGenStructureData extends WorldSavedData
{
    private /* synthetic */ NBTTagCompound tagCompound;
    
    public NBTTagCompound getTagCompound() {
        return this.tagCompound;
    }
    
    public void writeInstance(final NBTTagCompound llllllllllllllIIIllIllIIlllIIlll, final int llllllllllllllIIIllIllIIlllIIllI, final int llllllllllllllIIIllIllIIlllIIlIl) {
        this.tagCompound.setTag(formatChunkCoords(llllllllllllllIIIllIllIIlllIIllI, llllllllllllllIIIllIllIIlllIIlIl), llllllllllllllIIIllIllIIlllIIlll);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIllIllIIlllllIIl) {
        this.tagCompound = llllllllllllllIIIllIllIIlllllIIl.getCompoundTag("Features");
    }
    
    public static String formatChunkCoords(final int llllllllllllllIIIllIllIIlllIIIII, final int llllllllllllllIIIllIllIIllIlllll) {
        return String.valueOf(new StringBuilder("[").append(llllllllllllllIIIllIllIIlllIIIII).append(",").append(llllllllllllllIIIllIllIIllIlllll).append("]"));
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIIllIllIIllllIIIl) {
        llllllllllllllIIIllIllIIllllIIIl.setTag("Features", this.tagCompound);
        return llllllllllllllIIIllIllIIllllIIIl;
    }
    
    public MapGenStructureData(final String llllllllllllllIIIllIllIIllllllIl) {
        super(llllllllllllllIIIllIllIIllllllIl);
        this.tagCompound = new NBTTagCompound();
    }
}
