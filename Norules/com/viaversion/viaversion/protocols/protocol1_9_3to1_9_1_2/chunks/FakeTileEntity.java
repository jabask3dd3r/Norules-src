package com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.chunks;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class FakeTileEntity
{
    private static final /* synthetic */ Int2ObjectMap<CompoundTag> tileEntities;
    
    public static boolean hasBlock(final int lllllllllllllIIllIIIllIIIlIIllII) {
        return FakeTileEntity.tileEntities.containsKey(lllllllllllllIIllIIIllIIIlIIllII);
    }
    
    private static void register(final List<Integer> lllllllllllllIIllIIIllIIIlIlIIll, final String lllllllllllllIIllIIIllIIIlIlIIII) {
        for (final int lllllllllllllIIllIIIllIIIlIlIlII : lllllllllllllIIllIIIllIIIlIlIIll) {
            register(lllllllllllllIIllIIIllIIIlIlIlII, lllllllllllllIIllIIIllIIIlIlIIII);
        }
    }
    
    static {
        tileEntities = new Int2ObjectOpenHashMap<CompoundTag>();
        register(Arrays.asList(61, 62), "Furnace");
        register(Arrays.asList(54, 146), "Chest");
        register(130, "EnderChest");
        register(84, "RecordPlayer");
        register(23, "Trap");
        register(158, "Dropper");
        register(Arrays.asList(63, 68), "Sign");
        register(52, "MobSpawner");
        register(25, "Music");
        register(Arrays.asList(33, 34, 29, 36), "Piston");
        register(117, "Cauldron");
        register(116, "EnchantTable");
        register(Arrays.asList(119, 120), "Airportal");
        register(138, "Beacon");
        register(144, "Skull");
        register(Arrays.asList(178, 151), "DLDetector");
        register(154, "Hopper");
        register(Arrays.asList(149, 150), "Comparator");
        register(140, "FlowerPot");
        register(Arrays.asList(176, 177), "Banner");
        register(209, "EndGateway");
        register(137, "Control");
    }
    
    public static CompoundTag getFromBlock(final int lllllllllllllIIllIIIllIIIlIIIIll, final int lllllllllllllIIllIIIllIIIlIIIIlI, final int lllllllllllllIIllIIIllIIIIllllII, final int lllllllllllllIIllIIIllIIIIlllIll) {
        final CompoundTag lllllllllllllIIllIIIllIIIIllllll = FakeTileEntity.tileEntities.get(lllllllllllllIIllIIIllIIIIlllIll);
        if (lllllllllllllIIllIIIllIIIIllllll != null) {
            final CompoundTag lllllllllllllIIllIIIllIIIlIIIlII = lllllllllllllIIllIIIllIIIIllllll.clone();
            lllllllllllllIIllIIIllIIIlIIIlII.put("x", new IntTag(lllllllllllllIIllIIIllIIIlIIIIll));
            lllllllllllllIIllIIIllIIIlIIIlII.put("y", new IntTag(lllllllllllllIIllIIIllIIIlIIIIlI));
            lllllllllllllIIllIIIllIIIlIIIlII.put("z", new IntTag(lllllllllllllIIllIIIllIIIIllllII));
            return lllllllllllllIIllIIIllIIIlIIIlII;
        }
        return null;
    }
    
    private static void register(final int lllllllllllllIIllIIIllIIIlIllIll, final String lllllllllllllIIllIIIllIIIlIlllIl) {
        final CompoundTag lllllllllllllIIllIIIllIIIlIlllII = new CompoundTag();
        lllllllllllllIIllIIIllIIIlIlllII.put(lllllllllllllIIllIIIllIIIlIlllIl, new StringTag());
        FakeTileEntity.tileEntities.put(lllllllllllllIIllIIIllIIIlIllIll, lllllllllllllIIllIIIllIIIlIlllII);
    }
}
