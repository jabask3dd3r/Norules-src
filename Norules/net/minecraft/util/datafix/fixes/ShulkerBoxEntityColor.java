package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ShulkerBoxEntityColor implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIlIIllIlIlIIllllllI) {
        if ("minecraft:shulker".equals(lllllllllllllIlIIllIlIlIIllllllI.getString("id")) && !lllllllllllllIlIIllIlIlIIllllllI.hasKey("Color", 99)) {
            lllllllllllllIlIIllIlIlIIllllllI.setByte("Color", (byte)10);
        }
        return lllllllllllllIlIIllIlIlIIllllllI;
    }
    
    @Override
    public int getFixVersion() {
        return 808;
    }
}
