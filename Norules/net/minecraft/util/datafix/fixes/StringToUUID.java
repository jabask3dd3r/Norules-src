package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import java.util.*;

public class StringToUUID implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 108;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIIllIIIIIIIIlIlIll) {
        if (lllllllllllllIIIllIIIIIIIIlIlIll.hasKey("UUID", 8)) {
            lllllllllllllIIIllIIIIIIIIlIlIll.setUniqueId("UUID", UUID.fromString(lllllllllllllIIIllIIIIIIIIlIlIll.getString("UUID")));
        }
        return lllllllllllllIIIllIIIIIIIIlIlIll;
    }
}
