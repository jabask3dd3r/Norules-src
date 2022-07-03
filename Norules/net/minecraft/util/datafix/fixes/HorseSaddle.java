package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class HorseSaddle implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIIlIIlIlIIIIIIIIll) {
        if ("EntityHorse".equals(lllllllllllllIIIlIIlIlIIIIIIIIll.getString("id")) && !lllllllllllllIIIlIIlIlIIIIIIIIll.hasKey("SaddleItem", 10) && lllllllllllllIIIlIIlIlIIIIIIIIll.getBoolean("Saddle")) {
            final NBTTagCompound lllllllllllllIIIlIIlIlIIIIIIIIlI = new NBTTagCompound();
            lllllllllllllIIIlIIlIlIIIIIIIIlI.setString("id", "minecraft:saddle");
            lllllllllllllIIIlIIlIlIIIIIIIIlI.setByte("Count", (byte)1);
            lllllllllllllIIIlIIlIlIIIIIIIIlI.setShort("Damage", (short)0);
            lllllllllllllIIIlIIlIlIIIIIIIIll.setTag("SaddleItem", lllllllllllllIIIlIIlIlIIIIIIIIlI);
            lllllllllllllIIIlIIlIlIIIIIIIIll.removeTag("Saddle");
        }
        return lllllllllllllIIIlIIlIlIIIIIIIIll;
    }
    
    @Override
    public int getFixVersion() {
        return 110;
    }
}
