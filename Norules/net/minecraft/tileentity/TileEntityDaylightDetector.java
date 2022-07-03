package net.minecraft.tileentity;

import net.minecraft.util.*;
import net.minecraft.block.*;

public class TileEntityDaylightDetector extends TileEntity implements ITickable
{
    @Override
    public void update() {
        if (this.world != null && !this.world.isRemote && this.world.getTotalWorldTime() % 20L == 0L) {
            this.blockType = this.getBlockType();
            if (this.blockType instanceof BlockDaylightDetector) {
                ((BlockDaylightDetector)this.blockType).updatePower(this.world, this.pos);
            }
        }
    }
}
