package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class PotionItems implements IFixableData
{
    private static final /* synthetic */ String[] POTION_IDS;
    
    static {
        (POTION_IDS = new String[128])[0] = "minecraft:water";
        PotionItems.POTION_IDS[1] = "minecraft:regeneration";
        PotionItems.POTION_IDS[2] = "minecraft:swiftness";
        PotionItems.POTION_IDS[3] = "minecraft:fire_resistance";
        PotionItems.POTION_IDS[4] = "minecraft:poison";
        PotionItems.POTION_IDS[5] = "minecraft:healing";
        PotionItems.POTION_IDS[6] = "minecraft:night_vision";
        PotionItems.POTION_IDS[7] = null;
        PotionItems.POTION_IDS[8] = "minecraft:weakness";
        PotionItems.POTION_IDS[9] = "minecraft:strength";
        PotionItems.POTION_IDS[10] = "minecraft:slowness";
        PotionItems.POTION_IDS[11] = "minecraft:leaping";
        PotionItems.POTION_IDS[12] = "minecraft:harming";
        PotionItems.POTION_IDS[13] = "minecraft:water_breathing";
        PotionItems.POTION_IDS[14] = "minecraft:invisibility";
        PotionItems.POTION_IDS[15] = null;
        PotionItems.POTION_IDS[16] = "minecraft:awkward";
        PotionItems.POTION_IDS[17] = "minecraft:regeneration";
        PotionItems.POTION_IDS[18] = "minecraft:swiftness";
        PotionItems.POTION_IDS[19] = "minecraft:fire_resistance";
        PotionItems.POTION_IDS[20] = "minecraft:poison";
        PotionItems.POTION_IDS[21] = "minecraft:healing";
        PotionItems.POTION_IDS[22] = "minecraft:night_vision";
        PotionItems.POTION_IDS[23] = null;
        PotionItems.POTION_IDS[24] = "minecraft:weakness";
        PotionItems.POTION_IDS[25] = "minecraft:strength";
        PotionItems.POTION_IDS[26] = "minecraft:slowness";
        PotionItems.POTION_IDS[27] = "minecraft:leaping";
        PotionItems.POTION_IDS[28] = "minecraft:harming";
        PotionItems.POTION_IDS[29] = "minecraft:water_breathing";
        PotionItems.POTION_IDS[30] = "minecraft:invisibility";
        PotionItems.POTION_IDS[31] = null;
        PotionItems.POTION_IDS[32] = "minecraft:thick";
        PotionItems.POTION_IDS[33] = "minecraft:strong_regeneration";
        PotionItems.POTION_IDS[34] = "minecraft:strong_swiftness";
        PotionItems.POTION_IDS[35] = "minecraft:fire_resistance";
        PotionItems.POTION_IDS[36] = "minecraft:strong_poison";
        PotionItems.POTION_IDS[37] = "minecraft:strong_healing";
        PotionItems.POTION_IDS[38] = "minecraft:night_vision";
        PotionItems.POTION_IDS[39] = null;
        PotionItems.POTION_IDS[40] = "minecraft:weakness";
        PotionItems.POTION_IDS[41] = "minecraft:strong_strength";
        PotionItems.POTION_IDS[42] = "minecraft:slowness";
        PotionItems.POTION_IDS[43] = "minecraft:strong_leaping";
        PotionItems.POTION_IDS[44] = "minecraft:strong_harming";
        PotionItems.POTION_IDS[45] = "minecraft:water_breathing";
        PotionItems.POTION_IDS[46] = "minecraft:invisibility";
        PotionItems.POTION_IDS[47] = null;
        PotionItems.POTION_IDS[48] = null;
        PotionItems.POTION_IDS[49] = "minecraft:strong_regeneration";
        PotionItems.POTION_IDS[50] = "minecraft:strong_swiftness";
        PotionItems.POTION_IDS[51] = "minecraft:fire_resistance";
        PotionItems.POTION_IDS[52] = "minecraft:strong_poison";
        PotionItems.POTION_IDS[53] = "minecraft:strong_healing";
        PotionItems.POTION_IDS[54] = "minecraft:night_vision";
        PotionItems.POTION_IDS[55] = null;
        PotionItems.POTION_IDS[56] = "minecraft:weakness";
        PotionItems.POTION_IDS[57] = "minecraft:strong_strength";
        PotionItems.POTION_IDS[58] = "minecraft:slowness";
        PotionItems.POTION_IDS[59] = "minecraft:strong_leaping";
        PotionItems.POTION_IDS[60] = "minecraft:strong_harming";
        PotionItems.POTION_IDS[61] = "minecraft:water_breathing";
        PotionItems.POTION_IDS[62] = "minecraft:invisibility";
        PotionItems.POTION_IDS[63] = null;
        PotionItems.POTION_IDS[64] = "minecraft:mundane";
        PotionItems.POTION_IDS[65] = "minecraft:long_regeneration";
        PotionItems.POTION_IDS[66] = "minecraft:long_swiftness";
        PotionItems.POTION_IDS[67] = "minecraft:long_fire_resistance";
        PotionItems.POTION_IDS[68] = "minecraft:long_poison";
        PotionItems.POTION_IDS[69] = "minecraft:healing";
        PotionItems.POTION_IDS[70] = "minecraft:long_night_vision";
        PotionItems.POTION_IDS[71] = null;
        PotionItems.POTION_IDS[72] = "minecraft:long_weakness";
        PotionItems.POTION_IDS[73] = "minecraft:long_strength";
        PotionItems.POTION_IDS[74] = "minecraft:long_slowness";
        PotionItems.POTION_IDS[75] = "minecraft:long_leaping";
        PotionItems.POTION_IDS[76] = "minecraft:harming";
        PotionItems.POTION_IDS[77] = "minecraft:long_water_breathing";
        PotionItems.POTION_IDS[78] = "minecraft:long_invisibility";
        PotionItems.POTION_IDS[79] = null;
        PotionItems.POTION_IDS[80] = "minecraft:awkward";
        PotionItems.POTION_IDS[81] = "minecraft:long_regeneration";
        PotionItems.POTION_IDS[82] = "minecraft:long_swiftness";
        PotionItems.POTION_IDS[83] = "minecraft:long_fire_resistance";
        PotionItems.POTION_IDS[84] = "minecraft:long_poison";
        PotionItems.POTION_IDS[85] = "minecraft:healing";
        PotionItems.POTION_IDS[86] = "minecraft:long_night_vision";
        PotionItems.POTION_IDS[87] = null;
        PotionItems.POTION_IDS[88] = "minecraft:long_weakness";
        PotionItems.POTION_IDS[89] = "minecraft:long_strength";
        PotionItems.POTION_IDS[90] = "minecraft:long_slowness";
        PotionItems.POTION_IDS[91] = "minecraft:long_leaping";
        PotionItems.POTION_IDS[92] = "minecraft:harming";
        PotionItems.POTION_IDS[93] = "minecraft:long_water_breathing";
        PotionItems.POTION_IDS[94] = "minecraft:long_invisibility";
        PotionItems.POTION_IDS[95] = null;
        PotionItems.POTION_IDS[96] = "minecraft:thick";
        PotionItems.POTION_IDS[97] = "minecraft:regeneration";
        PotionItems.POTION_IDS[98] = "minecraft:swiftness";
        PotionItems.POTION_IDS[99] = "minecraft:long_fire_resistance";
        PotionItems.POTION_IDS[100] = "minecraft:poison";
        PotionItems.POTION_IDS[101] = "minecraft:strong_healing";
        PotionItems.POTION_IDS[102] = "minecraft:long_night_vision";
        PotionItems.POTION_IDS[103] = null;
        PotionItems.POTION_IDS[104] = "minecraft:long_weakness";
        PotionItems.POTION_IDS[105] = "minecraft:strength";
        PotionItems.POTION_IDS[106] = "minecraft:long_slowness";
        PotionItems.POTION_IDS[107] = "minecraft:leaping";
        PotionItems.POTION_IDS[108] = "minecraft:strong_harming";
        PotionItems.POTION_IDS[109] = "minecraft:long_water_breathing";
        PotionItems.POTION_IDS[110] = "minecraft:long_invisibility";
        PotionItems.POTION_IDS[111] = null;
        PotionItems.POTION_IDS[112] = null;
        PotionItems.POTION_IDS[113] = "minecraft:regeneration";
        PotionItems.POTION_IDS[114] = "minecraft:swiftness";
        PotionItems.POTION_IDS[115] = "minecraft:long_fire_resistance";
        PotionItems.POTION_IDS[116] = "minecraft:poison";
        PotionItems.POTION_IDS[117] = "minecraft:strong_healing";
        PotionItems.POTION_IDS[118] = "minecraft:long_night_vision";
        PotionItems.POTION_IDS[119] = null;
        PotionItems.POTION_IDS[120] = "minecraft:long_weakness";
        PotionItems.POTION_IDS[121] = "minecraft:strength";
        PotionItems.POTION_IDS[122] = "minecraft:long_slowness";
        PotionItems.POTION_IDS[123] = "minecraft:leaping";
        PotionItems.POTION_IDS[124] = "minecraft:strong_harming";
        PotionItems.POTION_IDS[125] = "minecraft:long_water_breathing";
        PotionItems.POTION_IDS[126] = "minecraft:long_invisibility";
        PotionItems.POTION_IDS[127] = null;
    }
    
    @Override
    public int getFixVersion() {
        return 102;
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound llIIIlIIIlIllll) {
        if ("minecraft:potion".equals(llIIIlIIIlIllll.getString("id"))) {
            final NBTTagCompound llIIIlIIIlIlllI = llIIIlIIIlIllll.getCompoundTag("tag");
            final short llIIIlIIIlIllIl = llIIIlIIIlIllll.getShort("Damage");
            if (!llIIIlIIIlIlllI.hasKey("Potion", 8)) {
                final String llIIIlIIIlIllII = PotionItems.POTION_IDS[llIIIlIIIlIllIl & 0x7F];
                llIIIlIIIlIlllI.setString("Potion", (llIIIlIIIlIllII == null) ? "minecraft:water" : llIIIlIIIlIllII);
                llIIIlIIIlIllll.setTag("tag", llIIIlIIIlIlllI);
                if ((llIIIlIIIlIllIl & 0x4000) == 0x4000) {
                    llIIIlIIIlIllll.setString("id", "minecraft:splash_potion");
                }
            }
            if (llIIIlIIIlIllIl != 0) {
                llIIIlIIIlIllll.setShort("Damage", (short)0);
            }
        }
        return llIIIlIIIlIllll;
    }
}
