package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.block_entity_handlers;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.providers.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class FlowerPotHandler implements BackwardsBlockEntityProvider.BackwardsBlockEntityHandler
{
    private static final /* synthetic */ Int2ObjectMap<Pair<String, Byte>> FLOWERS;
    private static final /* synthetic */ Pair<String, Byte> AIR;
    
    public static boolean isFlowah(final int llllllllllllllIIIllIlIlllllIIIlI) {
        return llllllllllllllIIIllIlIlllllIIIlI >= 5265 && llllllllllllllIIIllIlIlllllIIIlI <= 5286;
    }
    
    private static void register(final int llllllllllllllIIIllIlIlllllIllIl, final String llllllllllllllIIIllIlIlllllIllll, final byte llllllllllllllIIIllIlIlllllIlllI) {
        FlowerPotHandler.FLOWERS.put(llllllllllllllIIIllIlIlllllIllIl, new Pair<String, Byte>(llllllllllllllIIIllIlIlllllIllll, llllllllllllllIIIllIlIlllllIlllI));
    }
    
    public Pair<String, Byte> getOrDefault(final int llllllllllllllIIIllIlIllllIllIIl) {
        final Pair<String, Byte> llllllllllllllIIIllIlIllllIllIlI = FlowerPotHandler.FLOWERS.get(llllllllllllllIIIllIlIllllIllIIl);
        return (llllllllllllllIIIllIlIllllIllIlI != null) ? llllllllllllllIIIllIlIllllIllIlI : FlowerPotHandler.AIR;
    }
    
    @Override
    public CompoundTag transform(final UserConnection llllllllllllllIIIllIlIllllIIllIl, final int llllllllllllllIIIllIlIllllIIIlll, final CompoundTag llllllllllllllIIIllIlIllllIIIllI) {
        final Pair<String, Byte> llllllllllllllIIIllIlIllllIIlIIl = this.getOrDefault(llllllllllllllIIIllIlIllllIIIlll);
        llllllllllllllIIIllIlIllllIIIllI.put("Item", new StringTag(llllllllllllllIIIllIlIllllIIlIIl.getKey()));
        llllllllllllllIIIllIlIllllIIIllI.put("Data", new IntTag(llllllllllllllIIIllIlIllllIIlIIl.getValue()));
        return llllllllllllllIIIllIlIllllIIIllI;
    }
    
    static {
        FLOWERS = new Int2ObjectOpenHashMap<Pair<String, Byte>>(22, 1.0f);
        AIR = new Pair<String, Byte>("minecraft:air", (Byte)0);
        FlowerPotHandler.FLOWERS.put(5265, FlowerPotHandler.AIR);
        register(5266, "minecraft:sapling", (byte)0);
        register(5267, "minecraft:sapling", (byte)1);
        register(5268, "minecraft:sapling", (byte)2);
        register(5269, "minecraft:sapling", (byte)3);
        register(5270, "minecraft:sapling", (byte)4);
        register(5271, "minecraft:sapling", (byte)5);
        register(5272, "minecraft:tallgrass", (byte)2);
        register(5273, "minecraft:yellow_flower", (byte)0);
        register(5274, "minecraft:red_flower", (byte)0);
        register(5275, "minecraft:red_flower", (byte)1);
        register(5276, "minecraft:red_flower", (byte)2);
        register(5277, "minecraft:red_flower", (byte)3);
        register(5278, "minecraft:red_flower", (byte)4);
        register(5279, "minecraft:red_flower", (byte)5);
        register(5280, "minecraft:red_flower", (byte)6);
        register(5281, "minecraft:red_flower", (byte)7);
        register(5282, "minecraft:red_flower", (byte)8);
        register(5283, "minecraft:red_mushroom", (byte)0);
        register(5284, "minecraft:brown_mushroom", (byte)0);
        register(5285, "minecraft:deadbush", (byte)0);
        register(5286, "minecraft:cactus", (byte)0);
    }
}
