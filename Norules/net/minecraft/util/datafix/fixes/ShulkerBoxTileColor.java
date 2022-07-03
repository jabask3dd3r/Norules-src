package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ShulkerBoxTileColor implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 813;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIIIIlIllIIllIlllIl) {
        if ("minecraft:shulker".equals(lllllllllllllIIIIIlIllIIllIlllIl.getString("id"))) {
            lllllllllllllIIIIIlIllIIllIlllIl.removeTag("Color");
        }
        return lllllllllllllIIIIIlIllIIllIlllIl;
    }
}
