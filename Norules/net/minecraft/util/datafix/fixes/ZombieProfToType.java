package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import java.util.*;
import net.minecraft.nbt.*;

public class ZombieProfToType implements IFixableData
{
    private static final /* synthetic */ Random RANDOM;
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIllIIIlIlllIlIIllIl) {
        if ("Zombie".equals(lllllllllllllIllIIIlIlllIlIIllIl.getString("id")) && lllllllllllllIllIIIlIlllIlIIllIl.getBoolean("IsVillager")) {
            if (!lllllllllllllIllIIIlIlllIlIIllIl.hasKey("ZombieType", 99)) {
                int lllllllllllllIllIIIlIlllIlIIllII = -1;
                if (lllllllllllllIllIIIlIlllIlIIllIl.hasKey("VillagerProfession", 99)) {
                    try {
                        lllllllllllllIllIIIlIlllIlIIllII = this.func_191277_a(lllllllllllllIllIIIlIlllIlIIllIl.getInteger("VillagerProfession"));
                    }
                    catch (RuntimeException ex) {}
                }
                if (lllllllllllllIllIIIlIlllIlIIllII == -1) {
                    lllllllllllllIllIIIlIlllIlIIllII = this.func_191277_a(ZombieProfToType.RANDOM.nextInt(6));
                }
                lllllllllllllIllIIIlIlllIlIIllIl.setInteger("ZombieType", lllllllllllllIllIIIlIlllIlIIllII);
            }
            lllllllllllllIllIIIlIlllIlIIllIl.removeTag("IsVillager");
        }
        return lllllllllllllIllIIIlIlllIlIIllIl;
    }
    
    private int func_191277_a(final int lllllllllllllIllIIIlIlllIlIIIlIl) {
        return (lllllllllllllIllIIIlIlllIlIIIlIl >= 0 && lllllllllllllIllIIIlIlllIlIIIlIl < 6) ? lllllllllllllIllIIIlIlllIlIIIlIl : -1;
    }
    
    static {
        RANDOM = new Random();
    }
    
    @Override
    public int getFixVersion() {
        return 502;
    }
}
