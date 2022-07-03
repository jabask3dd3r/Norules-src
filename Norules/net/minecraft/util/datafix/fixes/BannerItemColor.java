package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class BannerItemColor implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 804;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lIIlIIIIlII) {
        if ("minecraft:banner".equals(lIIlIIIIlII.getString("id")) && lIIlIIIIlII.hasKey("tag", 10)) {
            final NBTTagCompound lIIlIIIlIII = lIIlIIIIlII.getCompoundTag("tag");
            if (lIIlIIIlIII.hasKey("BlockEntityTag", 10)) {
                final NBTTagCompound lIIlIIIIlll = lIIlIIIlIII.getCompoundTag("BlockEntityTag");
                if (lIIlIIIIlll.hasKey("Base", 99)) {
                    lIIlIIIIlII.setShort("Damage", (short)(lIIlIIIIlll.getShort("Base") & 0xF));
                    if (lIIlIIIlIII.hasKey("display", 10)) {
                        final NBTTagCompound lIIlIIIIllI = lIIlIIIlIII.getCompoundTag("display");
                        if (lIIlIIIIllI.hasKey("Lore", 9)) {
                            final NBTTagList lIIlIIIIlIl = lIIlIIIIllI.getTagList("Lore", 8);
                            if (lIIlIIIIlIl.tagCount() == 1 && "(+NBT)".equals(lIIlIIIIlIl.getStringTagAt(0))) {
                                return lIIlIIIIlII;
                            }
                        }
                    }
                    lIIlIIIIlll.removeTag("Base");
                    if (lIIlIIIIlll.hasNoTags()) {
                        lIIlIIIlIII.removeTag("BlockEntityTag");
                    }
                    if (lIIlIIIlIII.hasNoTags()) {
                        lIIlIIIIlII.removeTag("tag");
                    }
                }
            }
        }
        return lIIlIIIIlII;
    }
}
