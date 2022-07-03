package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class RedundantChanceTags implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIlIIlIIIIIIIIlIIll) {
        if (lllllllllllllIIlIIlIIIIIIIIlIIll.hasKey("HandDropChances", 9)) {
            final NBTTagList lllllllllllllIIlIIlIIIIIIIIlIIlI = lllllllllllllIIlIIlIIIIIIIIlIIll.getTagList("HandDropChances", 5);
            if (lllllllllllllIIlIIlIIIIIIIIlIIlI.tagCount() == 2 && lllllllllllllIIlIIlIIIIIIIIlIIlI.getFloatAt(0) == 0.0f && lllllllllllllIIlIIlIIIIIIIIlIIlI.getFloatAt(1) == 0.0f) {
                lllllllllllllIIlIIlIIIIIIIIlIIll.removeTag("HandDropChances");
            }
        }
        if (lllllllllllllIIlIIlIIIIIIIIlIIll.hasKey("ArmorDropChances", 9)) {
            final NBTTagList lllllllllllllIIlIIlIIIIIIIIlIIIl = lllllllllllllIIlIIlIIIIIIIIlIIll.getTagList("ArmorDropChances", 5);
            if (lllllllllllllIIlIIlIIIIIIIIlIIIl.tagCount() == 4 && lllllllllllllIIlIIlIIIIIIIIlIIIl.getFloatAt(0) == 0.0f && lllllllllllllIIlIIlIIIIIIIIlIIIl.getFloatAt(1) == 0.0f && lllllllllllllIIlIIlIIIIIIIIlIIIl.getFloatAt(2) == 0.0f && lllllllllllllIIlIIlIIIIIIIIlIIIl.getFloatAt(3) == 0.0f) {
                lllllllllllllIIlIIlIIIIIIIIlIIll.removeTag("ArmorDropChances");
            }
        }
        return lllllllllllllIIlIIlIIIIIIIIlIIll;
    }
    
    @Override
    public int getFixVersion() {
        return 113;
    }
}
