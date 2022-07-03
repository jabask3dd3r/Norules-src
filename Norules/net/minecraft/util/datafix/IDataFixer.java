package net.minecraft.util.datafix;

import net.minecraft.nbt.*;

public interface IDataFixer
{
    NBTTagCompound process(final IFixType p0, final NBTTagCompound p1, final int p2);
}
