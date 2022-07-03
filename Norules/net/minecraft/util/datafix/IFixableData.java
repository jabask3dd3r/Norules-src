package net.minecraft.util.datafix;

import net.minecraft.nbt.*;

public interface IFixableData
{
    int getFixVersion();
    
    NBTTagCompound fixTagCompound(final NBTTagCompound p0);
}
