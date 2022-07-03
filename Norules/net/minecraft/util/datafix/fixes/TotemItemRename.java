package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class TotemItemRename implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 820;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIllllIIllllIIIIlllI) {
        if ("minecraft:totem".equals(lllllllllllllIllllIIllllIIIIlllI.getString("id"))) {
            lllllllllllllIllllIIllllIIIIlllI.setString("id", "minecraft:totem_of_undying");
        }
        return lllllllllllllIllllIIllllIIIIlllI;
    }
}
