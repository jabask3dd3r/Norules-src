package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class EntityArmorAndHeld implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIllllllIIlIlIIIIlll) {
        final NBTTagList lllllllllllllIllllllIIlIlIIIllIl = lllllllllllllIllllllIIlIlIIIIlll.getTagList("Equipment", 10);
        if (!lllllllllllllIllllllIIlIlIIIllIl.hasNoTags() && !lllllllllllllIllllllIIlIlIIIIlll.hasKey("HandItems", 10)) {
            final NBTTagList lllllllllllllIllllllIIlIlIIIllII = new NBTTagList();
            lllllllllllllIllllllIIlIlIIIllII.appendTag(lllllllllllllIllllllIIlIlIIIllIl.get(0));
            lllllllllllllIllllllIIlIlIIIllII.appendTag(new NBTTagCompound());
            lllllllllllllIllllllIIlIlIIIIlll.setTag("HandItems", lllllllllllllIllllllIIlIlIIIllII);
        }
        if (lllllllllllllIllllllIIlIlIIIllIl.tagCount() > 1 && !lllllllllllllIllllllIIlIlIIIIlll.hasKey("ArmorItem", 10)) {
            final NBTTagList lllllllllllllIllllllIIlIlIIIlIll = new NBTTagList();
            lllllllllllllIllllllIIlIlIIIlIll.appendTag(lllllllllllllIllllllIIlIlIIIllIl.getCompoundTagAt(1));
            lllllllllllllIllllllIIlIlIIIlIll.appendTag(lllllllllllllIllllllIIlIlIIIllIl.getCompoundTagAt(2));
            lllllllllllllIllllllIIlIlIIIlIll.appendTag(lllllllllllllIllllllIIlIlIIIllIl.getCompoundTagAt(3));
            lllllllllllllIllllllIIlIlIIIlIll.appendTag(lllllllllllllIllllllIIlIlIIIllIl.getCompoundTagAt(4));
            lllllllllllllIllllllIIlIlIIIIlll.setTag("ArmorItems", lllllllllllllIllllllIIlIlIIIlIll);
        }
        lllllllllllllIllllllIIlIlIIIIlll.removeTag("Equipment");
        if (lllllllllllllIllllllIIlIlIIIIlll.hasKey("DropChances", 9)) {
            final NBTTagList lllllllllllllIllllllIIlIlIIIlIlI = lllllllllllllIllllllIIlIlIIIIlll.getTagList("DropChances", 5);
            if (!lllllllllllllIllllllIIlIlIIIIlll.hasKey("HandDropChances", 10)) {
                final NBTTagList lllllllllllllIllllllIIlIlIIIlIIl = new NBTTagList();
                lllllllllllllIllllllIIlIlIIIlIIl.appendTag(new NBTTagFloat(lllllllllllllIllllllIIlIlIIIlIlI.getFloatAt(0)));
                lllllllllllllIllllllIIlIlIIIlIIl.appendTag(new NBTTagFloat(0.0f));
                lllllllllllllIllllllIIlIlIIIIlll.setTag("HandDropChances", lllllllllllllIllllllIIlIlIIIlIIl);
            }
            if (!lllllllllllllIllllllIIlIlIIIIlll.hasKey("ArmorDropChances", 10)) {
                final NBTTagList lllllllllllllIllllllIIlIlIIIlIII = new NBTTagList();
                lllllllllllllIllllllIIlIlIIIlIII.appendTag(new NBTTagFloat(lllllllllllllIllllllIIlIlIIIlIlI.getFloatAt(1)));
                lllllllllllllIllllllIIlIlIIIlIII.appendTag(new NBTTagFloat(lllllllllllllIllllllIIlIlIIIlIlI.getFloatAt(2)));
                lllllllllllllIllllllIIlIlIIIlIII.appendTag(new NBTTagFloat(lllllllllllllIllllllIIlIlIIIlIlI.getFloatAt(3)));
                lllllllllllllIllllllIIlIlIIIlIII.appendTag(new NBTTagFloat(lllllllllllllIllllllIIlIlIIIlIlI.getFloatAt(4)));
                lllllllllllllIllllllIIlIlIIIIlll.setTag("ArmorDropChances", lllllllllllllIllllllIIlIlIIIlIII);
            }
            lllllllllllllIllllllIIlIlIIIIlll.removeTag("DropChances");
        }
        return lllllllllllllIllllllIIlIlIIIIlll;
    }
    
    @Override
    public int getFixVersion() {
        return 100;
    }
}
