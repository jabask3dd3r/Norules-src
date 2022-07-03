package optifine;

import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class EntityUtils
{
    private static final /* synthetic */ Map<String, Integer> mapIdByName;
    private static final /* synthetic */ Map<String, Integer> mapIdByLocation;
    private static final /* synthetic */ Map<Class, Integer> mapIdByClass;
    
    public static int getEntityIdByClass(final Entity llllllllllllllIlIIIIIIlIlllllIll) {
        return (llllllllllllllIlIIIIIIlIlllllIll == null) ? -1 : getEntityIdByClass(llllllllllllllIlIIIIIIlIlllllIll.getClass());
    }
    
    static {
        mapIdByClass = new HashMap<Class, Integer>();
        mapIdByLocation = new HashMap<String, Integer>();
        mapIdByName = new HashMap<String, Integer>();
        for (int llllllllllllllIlIIIIIIllIIIIlIlI = 0; llllllllllllllIlIIIIIIllIIIIlIlI < 1000; ++llllllllllllllIlIIIIIIllIIIIlIlI) {
            final Class llllllllllllllIlIIIIIIllIIIIlIIl = EntityList.getClassFromID(llllllllllllllIlIIIIIIllIIIIlIlI);
            if (llllllllllllllIlIIIIIIllIIIIlIIl != null) {
                final ResourceLocation llllllllllllllIlIIIIIIllIIIIlIII = EntityList.func_191306_a(llllllllllllllIlIIIIIIllIIIIlIIl);
                if (llllllllllllllIlIIIIIIllIIIIlIII != null) {
                    final String llllllllllllllIlIIIIIIllIIIIIlll = llllllllllllllIlIIIIIIllIIIIlIII.toString();
                    final String llllllllllllllIlIIIIIIllIIIIIllI = EntityList.func_191302_a(llllllllllllllIlIIIIIIllIIIIlIII);
                    if (llllllllllllllIlIIIIIIllIIIIIllI != null) {
                        if (EntityUtils.mapIdByClass.containsKey(llllllllllllllIlIIIIIIllIIIIlIIl)) {
                            Config.warn(String.valueOf(new StringBuilder("Duplicate entity class: ").append(llllllllllllllIlIIIIIIllIIIIlIIl).append(", id1: ").append(EntityUtils.mapIdByClass.get(llllllllllllllIlIIIIIIllIIIIlIIl)).append(", id2: ").append(llllllllllllllIlIIIIIIllIIIIlIlI)));
                        }
                        if (EntityUtils.mapIdByLocation.containsKey(llllllllllllllIlIIIIIIllIIIIIlll)) {
                            Config.warn(String.valueOf(new StringBuilder("Duplicate entity location: ").append(llllllllllllllIlIIIIIIllIIIIIlll).append(", id1: ").append(EntityUtils.mapIdByLocation.get(llllllllllllllIlIIIIIIllIIIIIlll)).append(", id2: ").append(llllllllllllllIlIIIIIIllIIIIlIlI)));
                        }
                        if (EntityUtils.mapIdByName.containsKey(llllllllllllllIlIIIIIIllIIIIIlll)) {
                            Config.warn(String.valueOf(new StringBuilder("Duplicate entity name: ").append(llllllllllllllIlIIIIIIllIIIIIllI).append(", id1: ").append(EntityUtils.mapIdByName.get(llllllllllllllIlIIIIIIllIIIIIllI)).append(", id2: ").append(llllllllllllllIlIIIIIIllIIIIlIlI)));
                        }
                        EntityUtils.mapIdByClass.put(llllllllllllllIlIIIIIIllIIIIlIIl, llllllllllllllIlIIIIIIllIIIIlIlI);
                        EntityUtils.mapIdByLocation.put(llllllllllllllIlIIIIIIllIIIIIlll, llllllllllllllIlIIIIIIllIIIIlIlI);
                        EntityUtils.mapIdByName.put(llllllllllllllIlIIIIIIllIIIIIllI, llllllllllllllIlIIIIIIllIIIIlIlI);
                    }
                }
            }
        }
    }
    
    public static int getEntityIdByLocation(final String llllllllllllllIlIIIIIIlIllllIIlI) {
        final Integer llllllllllllllIlIIIIIIlIllllIIIl = EntityUtils.mapIdByLocation.get(llllllllllllllIlIIIIIIlIllllIIlI);
        return (llllllllllllllIlIIIIIIlIllllIIIl == null) ? -1 : llllllllllllllIlIIIIIIlIllllIIIl;
    }
    
    public static int getEntityIdByClass(final Class llllllllllllllIlIIIIIIlIllllIllI) {
        final Integer llllllllllllllIlIIIIIIlIllllIlll = EntityUtils.mapIdByClass.get(llllllllllllllIlIIIIIIlIllllIllI);
        return (llllllllllllllIlIIIIIIlIllllIlll == null) ? -1 : llllllllllllllIlIIIIIIlIllllIlll;
    }
    
    public static int getEntityIdByName(final String llllllllllllllIlIIIIIIlIlllIllII) {
        final Integer llllllllllllllIlIIIIIIlIlllIlIll = EntityUtils.mapIdByName.get(llllllllllllllIlIIIIIIlIlllIllII);
        return (llllllllllllllIlIIIIIIlIlllIlIll == null) ? -1 : llllllllllllllIlIIIIIIlIlllIlIll;
    }
}
