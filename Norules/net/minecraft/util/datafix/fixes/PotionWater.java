package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class PotionWater implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllllIIlIIIllIlIIllllI) {
        final String lllllllllllllllIIlIIIllIlIIlllII = lllllllllllllllIIlIIIllIlIIllllI.getString("id");
        if ("minecraft:potion".equals(lllllllllllllllIIlIIIllIlIIlllII) || "minecraft:splash_potion".equals(lllllllllllllllIIlIIIllIlIIlllII) || "minecraft:lingering_potion".equals(lllllllllllllllIIlIIIllIlIIlllII) || "minecraft:tipped_arrow".equals(lllllllllllllllIIlIIIllIlIIlllII)) {
            final NBTTagCompound lllllllllllllllIIlIIIllIlIIllIll = lllllllllllllllIIlIIIllIlIIllllI.getCompoundTag("tag");
            if (!lllllllllllllllIIlIIIllIlIIllIll.hasKey("Potion", 8)) {
                lllllllllllllllIIlIIIllIlIIllIll.setString("Potion", "minecraft:water");
            }
            if (!lllllllllllllllIIlIIIllIlIIllllI.hasKey("tag", 10)) {
                lllllllllllllllIIlIIIllIlIIllllI.setTag("tag", lllllllllllllllIIlIIIllIlIIllIll);
            }
        }
        return lllllllllllllllIIlIIIllIlIIllllI;
    }
    
    @Override
    public int getFixVersion() {
        return 806;
    }
}
