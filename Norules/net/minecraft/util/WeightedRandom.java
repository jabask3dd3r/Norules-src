package net.minecraft.util;

import java.util.*;

public class WeightedRandom
{
    public static int getTotalWeight(final List<? extends Item> lllllllllllllIllIIIIllllIlIllllI) {
        int lllllllllllllIllIIIIllllIlIlllIl = 0;
        for (int lllllllllllllIllIIIIllllIlIlllII = 0, lllllllllllllIllIIIIllllIlIllIll = lllllllllllllIllIIIIllllIlIllllI.size(); lllllllllllllIllIIIIllllIlIlllII < lllllllllllllIllIIIIllllIlIllIll; ++lllllllllllllIllIIIIllllIlIlllII) {
            final Item lllllllllllllIllIIIIllllIlIllIlI = (Item)lllllllllllllIllIIIIllllIlIllllI.get(lllllllllllllIllIIIIllllIlIlllII);
            lllllllllllllIllIIIIllllIlIlllIl += lllllllllllllIllIIIIllllIlIllIlI.itemWeight;
        }
        return lllllllllllllIllIIIIllllIlIlllIl;
    }
    
    public static <T extends Item> T getRandomItem(final Random lllllllllllllIllIIIIllllIlIIllII, final List<T> lllllllllllllIllIIIIllllIlIIllll, final int lllllllllllllIllIIIIllllIlIIlIlI) {
        if (lllllllllllllIllIIIIllllIlIIlIlI <= 0) {
            throw new IllegalArgumentException();
        }
        final int lllllllllllllIllIIIIllllIlIIllIl = lllllllllllllIllIIIIllllIlIIllII.nextInt(lllllllllllllIllIIIIllllIlIIlIlI);
        return getRandomItem(lllllllllllllIllIIIIllllIlIIllll, lllllllllllllIllIIIIllllIlIIllIl);
    }
    
    public static <T extends Item> T getRandomItem(final List<T> lllllllllllllIllIIIIllllIlIIIIll, int lllllllllllllIllIIIIllllIIllllIl) {
        for (int lllllllllllllIllIIIIllllIlIIIIIl = 0, lllllllllllllIllIIIIllllIlIIIIII = lllllllllllllIllIIIIllllIlIIIIll.size(); lllllllllllllIllIIIIllllIlIIIIIl < lllllllllllllIllIIIIllllIlIIIIII; ++lllllllllllllIllIIIIllllIlIIIIIl) {
            final T lllllllllllllIllIIIIllllIIllllll = lllllllllllllIllIIIIllllIlIIIIll.get(lllllllllllllIllIIIIllllIlIIIIIl);
            lllllllllllllIllIIIIllllIIllllIl -= lllllllllllllIllIIIIllllIIllllll.itemWeight;
            if (lllllllllllllIllIIIIllllIIllllIl < 0) {
                return lllllllllllllIllIIIIllllIIllllll;
            }
        }
        return null;
    }
    
    public static <T extends Item> T getRandomItem(final Random lllllllllllllIllIIIIllllIIllIlll, final List<T> lllllllllllllIllIIIIllllIIllIllI) {
        return getRandomItem(lllllllllllllIllIIIIllllIIllIlll, lllllllllllllIllIIIIllllIIllIllI, getTotalWeight(lllllllllllllIllIIIIllllIIllIllI));
    }
    
    public static class Item
    {
        protected /* synthetic */ int itemWeight;
        
        public Item(final int lllllllllllllIlIlllIIIIllIllIlII) {
            this.itemWeight = lllllllllllllIlIlllIIIIllIllIlII;
        }
    }
}
