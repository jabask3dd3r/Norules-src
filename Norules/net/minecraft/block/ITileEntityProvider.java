package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;

public interface ITileEntityProvider
{
    @Nullable
    TileEntity createNewTileEntity(final World p0, final int p1);
}
