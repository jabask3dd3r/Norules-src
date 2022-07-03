package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.*;
import javax.annotation.*;

public class ItemMapBase extends Item
{
    @Nullable
    public Packet<?> createMapDataPacket(final ItemStack lllllllllllllIIIIlllIlIIlllIllIl, final World lllllllllllllIIIIlllIlIIlllIllII, final EntityPlayer lllllllllllllIIIIlllIlIIlllIlIll) {
        return null;
    }
    
    @Override
    public boolean isMap() {
        return true;
    }
}
