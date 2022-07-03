package net.minecraft.util.datafix;

import net.minecraft.nbt.*;

public interface IDataWalker
{
    NBTTagCompound process(final IDataFixer p0, final NBTTagCompound p1, final int p2);
}
