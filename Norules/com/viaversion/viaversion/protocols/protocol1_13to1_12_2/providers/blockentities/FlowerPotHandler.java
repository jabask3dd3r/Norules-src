package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.blockentities;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.providers.*;
import java.util.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.concurrent.*;

public class FlowerPotHandler implements BlockEntityProvider.BlockEntityHandler
{
    private static final /* synthetic */ Map<Pair<?, Byte>, Integer> flowers;
    
    @Override
    public int transform(final UserConnection lllllllllllllIIIIIllllIIIIIIllIl, final CompoundTag lllllllllllllIIIIIllllIIIIIIlIII) {
        Object lllllllllllllIIIIIllllIIIIIIlIll = lllllllllllllIIIIIllllIIIIIIlIII.contains("Item") ? lllllllllllllIIIIIllllIIIIIIlIII.get("Item").getValue() : null;
        Object lllllllllllllIIIIIllllIIIIIIlIlI = lllllllllllllIIIIIllllIIIIIIlIII.contains("Data") ? lllllllllllllIIIIIllllIIIIIIlIII.get("Data").getValue() : null;
        if (lllllllllllllIIIIIllllIIIIIIlIll instanceof String) {
            lllllllllllllIIIIIllllIIIIIIlIll = ((String)lllllllllllllIIIIIllllIIIIIIlIll).replace("minecraft:", "");
        }
        else if (lllllllllllllIIIIIllllIIIIIIlIll instanceof Number) {
            lllllllllllllIIIIIllllIIIIIIlIll = ((Number)lllllllllllllIIIIIllllIIIIIIlIll).byteValue();
        }
        else {
            lllllllllllllIIIIIllllIIIIIIlIll = 0;
        }
        if (lllllllllllllIIIIIllllIIIIIIlIlI instanceof Number) {
            lllllllllllllIIIIIllllIIIIIIlIlI = ((Number)lllllllllllllIIIIIllllIIIIIIlIlI).byteValue();
        }
        else {
            lllllllllllllIIIIIllllIIIIIIlIlI = 0;
        }
        Integer lllllllllllllIIIIIllllIIIIIIlIIl = FlowerPotHandler.flowers.get(new Pair(lllllllllllllIIIIIllllIIIIIIlIll, (byte)lllllllllllllIIIIIllllIIIIIIlIlI));
        if (lllllllllllllIIIIIllllIIIIIIlIIl != null) {
            return lllllllllllllIIIIIllllIIIIIIlIIl;
        }
        lllllllllllllIIIIIllllIIIIIIlIIl = FlowerPotHandler.flowers.get(new Pair(lllllllllllllIIIIIllllIIIIIIlIll, 0));
        if (lllllllllllllIIIIIllllIIIIIIlIIl != null) {
            return lllllllllllllIIIIIllllIIIIIIlIIl;
        }
        return 5265;
    }
    
    public static void register(final String lllllllllllllIIIIIllllIIIIIllIlI, final byte lllllllllllllIIIIIllllIIIIIllIIl, final byte lllllllllllllIIIIIllllIIIIIllIII, final int lllllllllllllIIIIIllllIIIIIlIlll) {
        FlowerPotHandler.flowers.put(new Pair<Object, Byte>(lllllllllllllIIIIIllllIIIIIllIlI, lllllllllllllIIIIIllllIIIIIllIII), lllllllllllllIIIIIllllIIIIIlIlll);
        FlowerPotHandler.flowers.put(new Pair<Object, Byte>(lllllllllllllIIIIIllllIIIIIllIIl, lllllllllllllIIIIIllllIIIIIllIII), lllllllllllllIIIIIllllIIIIIlIlll);
    }
    
    static {
        flowers = new ConcurrentHashMap<Pair<?, Byte>, Integer>();
        register("air", (byte)0, (byte)0, 5265);
        register("sapling", (byte)6, (byte)0, 5266);
        register("sapling", (byte)6, (byte)1, 5267);
        register("sapling", (byte)6, (byte)2, 5268);
        register("sapling", (byte)6, (byte)3, 5269);
        register("sapling", (byte)6, (byte)4, 5270);
        register("sapling", (byte)6, (byte)5, 5271);
        register("tallgrass", (byte)31, (byte)2, 5272);
        register("yellow_flower", (byte)37, (byte)0, 5273);
        register("red_flower", (byte)38, (byte)0, 5274);
        register("red_flower", (byte)38, (byte)1, 5275);
        register("red_flower", (byte)38, (byte)2, 5276);
        register("red_flower", (byte)38, (byte)3, 5277);
        register("red_flower", (byte)38, (byte)4, 5278);
        register("red_flower", (byte)38, (byte)5, 5279);
        register("red_flower", (byte)38, (byte)6, 5280);
        register("red_flower", (byte)38, (byte)7, 5281);
        register("red_flower", (byte)38, (byte)8, 5282);
        register("red_mushroom", (byte)40, (byte)0, 5283);
        register("brown_mushroom", (byte)39, (byte)0, 5284);
        register("deadbush", (byte)32, (byte)0, 5285);
        register("cactus", (byte)81, (byte)0, 5286);
    }
}
