package net.minecraft.world.storage;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import javax.annotation.*;

public interface IPlayerFileData
{
    String[] getAvailablePlayerDat();
    
    @Nullable
    NBTTagCompound readPlayerData(final EntityPlayer p0);
    
    void writePlayerData(final EntityPlayer p0);
}
