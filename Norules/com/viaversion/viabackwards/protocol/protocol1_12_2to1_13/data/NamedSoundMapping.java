package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import java.lang.reflect.*;

public class NamedSoundMapping
{
    private static final /* synthetic */ Map<String, String> SOUNDS;
    
    public static String getOldId(String lllllllllllllIIIlllIllllllllIlll) {
        if (lllllllllllllIIIlllIllllllllIlll.startsWith("minecraft:")) {
            lllllllllllllIIIlllIllllllllIlll = lllllllllllllIIIlllIllllllllIlll.substring(10);
        }
        return NamedSoundMapping.SOUNDS.get(lllllllllllllIIIlllIllllllllIlll);
    }
    
    static {
        SOUNDS = new HashMap<String, String>();
        try {
            final Field lllllllllllllIIIlllIlllllllIlllI = NamedSoundRewriter.class.getDeclaredField("oldToNew");
            lllllllllllllIIIlllIlllllllIlllI.setAccessible(true);
            final Map<String, String> lllllllllllllIIIlllIlllllllIllIl = (Map<String, String>)lllllllllllllIIIlllIlllllllIlllI.get(null);
            lllllllllllllIIIlllIlllllllIllIl.forEach((lllllllllllllIIIlllIllllllllIIlI, lllllllllllllIIIlllIllllllllIIll) -> NamedSoundMapping.SOUNDS.put(lllllllllllllIIIlllIllllllllIIll, lllllllllllllIIIlllIllllllllIIlI));
        }
        catch (NoSuchFieldException | IllegalAccessException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIIIlllIlllllllIllII = ex;
            lllllllllllllIIIlllIlllllllIllII.printStackTrace();
        }
    }
}
