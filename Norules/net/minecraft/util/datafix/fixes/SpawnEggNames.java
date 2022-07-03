package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class SpawnEggNames implements IFixableData
{
    private static final /* synthetic */ String[] ENTITY_IDS;
    
    static {
        ENTITY_IDS = new String[256];
        final String[] lIlIIIIIlIlIllI = SpawnEggNames.ENTITY_IDS;
        lIlIIIIIlIlIllI[1] = "Item";
        lIlIIIIIlIlIllI[2] = "XPOrb";
        lIlIIIIIlIlIllI[7] = "ThrownEgg";
        lIlIIIIIlIlIllI[8] = "LeashKnot";
        lIlIIIIIlIlIllI[9] = "Painting";
        lIlIIIIIlIlIllI[10] = "Arrow";
        lIlIIIIIlIlIllI[11] = "Snowball";
        lIlIIIIIlIlIllI[12] = "Fireball";
        lIlIIIIIlIlIllI[13] = "SmallFireball";
        lIlIIIIIlIlIllI[14] = "ThrownEnderpearl";
        lIlIIIIIlIlIllI[15] = "EyeOfEnderSignal";
        lIlIIIIIlIlIllI[16] = "ThrownPotion";
        lIlIIIIIlIlIllI[17] = "ThrownExpBottle";
        lIlIIIIIlIlIllI[18] = "ItemFrame";
        lIlIIIIIlIlIllI[19] = "WitherSkull";
        lIlIIIIIlIlIllI[20] = "PrimedTnt";
        lIlIIIIIlIlIllI[21] = "FallingSand";
        lIlIIIIIlIlIllI[22] = "FireworksRocketEntity";
        lIlIIIIIlIlIllI[23] = "TippedArrow";
        lIlIIIIIlIlIllI[24] = "SpectralArrow";
        lIlIIIIIlIlIllI[25] = "ShulkerBullet";
        lIlIIIIIlIlIllI[26] = "DragonFireball";
        lIlIIIIIlIlIllI[30] = "ArmorStand";
        lIlIIIIIlIlIllI[41] = "Boat";
        lIlIIIIIlIlIllI[42] = "MinecartRideable";
        lIlIIIIIlIlIllI[43] = "MinecartChest";
        lIlIIIIIlIlIllI[44] = "MinecartFurnace";
        lIlIIIIIlIlIllI[45] = "MinecartTNT";
        lIlIIIIIlIlIllI[46] = "MinecartHopper";
        lIlIIIIIlIlIllI[47] = "MinecartSpawner";
        lIlIIIIIlIlIllI[40] = "MinecartCommandBlock";
        lIlIIIIIlIlIllI[48] = "Mob";
        lIlIIIIIlIlIllI[49] = "Monster";
        lIlIIIIIlIlIllI[50] = "Creeper";
        lIlIIIIIlIlIllI[51] = "Skeleton";
        lIlIIIIIlIlIllI[52] = "Spider";
        lIlIIIIIlIlIllI[53] = "Giant";
        lIlIIIIIlIlIllI[54] = "Zombie";
        lIlIIIIIlIlIllI[55] = "Slime";
        lIlIIIIIlIlIllI[56] = "Ghast";
        lIlIIIIIlIlIllI[57] = "PigZombie";
        lIlIIIIIlIlIllI[58] = "Enderman";
        lIlIIIIIlIlIllI[59] = "CaveSpider";
        lIlIIIIIlIlIllI[60] = "Silverfish";
        lIlIIIIIlIlIllI[61] = "Blaze";
        lIlIIIIIlIlIllI[62] = "LavaSlime";
        lIlIIIIIlIlIllI[63] = "EnderDragon";
        lIlIIIIIlIlIllI[64] = "WitherBoss";
        lIlIIIIIlIlIllI[65] = "Bat";
        lIlIIIIIlIlIllI[66] = "Witch";
        lIlIIIIIlIlIllI[67] = "Endermite";
        lIlIIIIIlIlIllI[68] = "Guardian";
        lIlIIIIIlIlIllI[69] = "Shulker";
        lIlIIIIIlIlIllI[90] = "Pig";
        lIlIIIIIlIlIllI[91] = "Sheep";
        lIlIIIIIlIlIllI[92] = "Cow";
        lIlIIIIIlIlIllI[93] = "Chicken";
        lIlIIIIIlIlIllI[94] = "Squid";
        lIlIIIIIlIlIllI[95] = "Wolf";
        lIlIIIIIlIlIllI[96] = "MushroomCow";
        lIlIIIIIlIlIllI[97] = "SnowMan";
        lIlIIIIIlIlIllI[98] = "Ozelot";
        lIlIIIIIlIlIllI[99] = "VillagerGolem";
        lIlIIIIIlIlIllI[100] = "EntityHorse";
        lIlIIIIIlIlIllI[101] = "Rabbit";
        lIlIIIIIlIlIllI[120] = "Villager";
        lIlIIIIIlIlIllI[200] = "EnderCrystal";
    }
    
    @Override
    public int getFixVersion() {
        return 105;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lIlIIIIIlIIIlIl) {
        if ("minecraft:spawn_egg".equals(lIlIIIIIlIIIlIl.getString("id"))) {
            final NBTTagCompound lIlIIIIIlIIlIIl = lIlIIIIIlIIIlIl.getCompoundTag("tag");
            final NBTTagCompound lIlIIIIIlIIlIII = lIlIIIIIlIIlIIl.getCompoundTag("EntityTag");
            final short lIlIIIIIlIIIlll = lIlIIIIIlIIIlIl.getShort("Damage");
            if (!lIlIIIIIlIIlIII.hasKey("id", 8)) {
                final String lIlIIIIIlIIIllI = SpawnEggNames.ENTITY_IDS[lIlIIIIIlIIIlll & 0xFF];
                if (lIlIIIIIlIIIllI != null) {
                    lIlIIIIIlIIlIII.setString("id", lIlIIIIIlIIIllI);
                    lIlIIIIIlIIlIIl.setTag("EntityTag", lIlIIIIIlIIlIII);
                    lIlIIIIIlIIIlIl.setTag("tag", lIlIIIIIlIIlIIl);
                }
            }
            if (lIlIIIIIlIIIlll != 0) {
                lIlIIIIIlIIIlIl.setShort("Damage", (short)0);
            }
        }
        return lIlIIIIIlIIIlIl;
    }
}
