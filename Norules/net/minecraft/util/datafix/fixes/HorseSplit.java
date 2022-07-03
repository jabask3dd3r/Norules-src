package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class HorseSplit implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIlIIllIIlIIlIIlIIll) {
        if ("EntityHorse".equals(lllllllllllllIlIIllIIlIIlIIlIIll.getString("id"))) {
            final int lllllllllllllIlIIllIIlIIlIIlIlII = lllllllllllllIlIIllIIlIIlIIlIIll.getInteger("Type");
            switch (lllllllllllllIlIIllIIlIIlIIlIlII) {
                default: {
                    lllllllllllllIlIIllIIlIIlIIlIIll.setString("id", "Horse");
                    break;
                }
                case 1: {
                    lllllllllllllIlIIllIIlIIlIIlIIll.setString("id", "Donkey");
                    break;
                }
                case 2: {
                    lllllllllllllIlIIllIIlIIlIIlIIll.setString("id", "Mule");
                    break;
                }
                case 3: {
                    lllllllllllllIlIIllIIlIIlIIlIIll.setString("id", "ZombieHorse");
                    break;
                }
                case 4: {
                    lllllllllllllIlIIllIIlIIlIIlIIll.setString("id", "SkeletonHorse");
                    break;
                }
            }
            lllllllllllllIlIIllIIlIIlIIlIIll.removeTag("Type");
        }
        return lllllllllllllIlIIllIIlIIlIIlIIll;
    }
    
    @Override
    public int getFixVersion() {
        return 703;
    }
}
