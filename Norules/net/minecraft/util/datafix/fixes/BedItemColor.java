package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;

public class BedItemColor implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIIIIIIIllIIlIlllIl) {
        if ("minecraft:bed".equals(lllllllllllllIIIIIIIIllIIlIlllIl.getString("id")) && lllllllllllllIIIIIIIIllIIlIlllIl.getShort("Damage") == 0) {
            lllllllllllllIIIIIIIIllIIlIlllIl.setShort("Damage", (short)EnumDyeColor.RED.getMetadata());
        }
        return lllllllllllllIIIIIIIIllIIlIlllIl;
    }
    
    @Override
    public int getFixVersion() {
        return 1125;
    }
}
