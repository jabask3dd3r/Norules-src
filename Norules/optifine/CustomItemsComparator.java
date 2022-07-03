package optifine;

import java.util.*;

public class CustomItemsComparator implements Comparator
{
    @Override
    public int compare(final Object llllllllllllllIlIIlIIlIIlIlllIIl, final Object llllllllllllllIlIIlIIlIIlIllllII) {
        final CustomItemProperties llllllllllllllIlIIlIIlIIlIlllIll = (CustomItemProperties)llllllllllllllIlIIlIIlIIlIlllIIl;
        final CustomItemProperties llllllllllllllIlIIlIIlIIlIlllIlI = (CustomItemProperties)llllllllllllllIlIIlIIlIIlIllllII;
        if (llllllllllllllIlIIlIIlIIlIlllIll.weight != llllllllllllllIlIIlIIlIIlIlllIlI.weight) {
            return llllllllllllllIlIIlIIlIIlIlllIlI.weight - llllllllllllllIlIIlIIlIIlIlllIll.weight;
        }
        return Config.equals(llllllllllllllIlIIlIIlIIlIlllIll.basePath, llllllllllllllIlIIlIIlIIlIlllIlI.basePath) ? llllllllllllllIlIIlIIlIIlIlllIll.name.compareTo(llllllllllllllIlIIlIIlIIlIlllIlI.name) : llllllllllllllIlIIlIIlIIlIlllIll.basePath.compareTo(llllllllllllllIlIIlIIlIIlIlllIlI.basePath);
    }
}
