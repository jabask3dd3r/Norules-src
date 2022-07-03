package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class ZombieSplit implements IFixableData
{
    @Override
    public int getFixVersion() {
        return 702;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllllIlllllIIlIIllIIlI) {
        if ("Zombie".equals(lllllllllllllllIlllllIIlIIllIIlI.getString("id"))) {
            final int lllllllllllllllIlllllIIlIIllIIll = lllllllllllllllIlllllIIlIIllIIlI.getInteger("ZombieType");
            switch (lllllllllllllllIlllllIIlIIllIIll) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: {
                    lllllllllllllllIlllllIIlIIllIIlI.setString("id", "ZombieVillager");
                    lllllllllllllllIlllllIIlIIllIIlI.setInteger("Profession", lllllllllllllllIlllllIIlIIllIIll - 1);
                    break;
                }
                case 6: {
                    lllllllllllllllIlllllIIlIIllIIlI.setString("id", "Husk");
                    break;
                }
            }
            lllllllllllllllIlllllIIlIIllIIlI.removeTag("ZombieType");
        }
        return lllllllllllllllIlllllIIlIIllIIlI;
    }
}
