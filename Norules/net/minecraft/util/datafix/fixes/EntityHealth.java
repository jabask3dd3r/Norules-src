package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import java.util.*;
import net.minecraft.nbt.*;
import com.google.common.collect.*;

public class EntityHealth implements IFixableData
{
    private static final /* synthetic */ Set<String> ENTITY_LIST;
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIIllllIIIlllIlIllII) {
        if (EntityHealth.ENTITY_LIST.contains(lllllllllllllIIllllIIIlllIlIllII.getString("id"))) {
            float lllllllllllllIIllllIIIlllIlIlIlI = 0.0f;
            if (lllllllllllllIIllllIIIlllIlIllII.hasKey("HealF", 99)) {
                final float lllllllllllllIIllllIIIlllIlIlIll = lllllllllllllIIllllIIIlllIlIllII.getFloat("HealF");
                lllllllllllllIIllllIIIlllIlIllII.removeTag("HealF");
            }
            else {
                if (!lllllllllllllIIllllIIIlllIlIllII.hasKey("Health", 99)) {
                    return lllllllllllllIIllllIIIlllIlIllII;
                }
                lllllllllllllIIllllIIIlllIlIlIlI = lllllllllllllIIllllIIIlllIlIllII.getFloat("Health");
            }
            lllllllllllllIIllllIIIlllIlIllII.setFloat("Health", lllllllllllllIIllllIIIlllIlIlIlI);
        }
        return lllllllllllllIIllllIIIlllIlIllII;
    }
    
    static {
        ENTITY_LIST = Sets.newHashSet((Object[])new String[] { "ArmorStand", "Bat", "Blaze", "CaveSpider", "Chicken", "Cow", "Creeper", "EnderDragon", "Enderman", "Endermite", "EntityHorse", "Ghast", "Giant", "Guardian", "LavaSlime", "MushroomCow", "Ozelot", "Pig", "PigZombie", "Rabbit", "Sheep", "Shulker", "Silverfish", "Skeleton", "Slime", "SnowMan", "Spider", "Squid", "Villager", "VillagerGolem", "Witch", "WitherBoss", "Wolf", "Zombie" });
    }
    
    @Override
    public int getFixVersion() {
        return 109;
    }
}
