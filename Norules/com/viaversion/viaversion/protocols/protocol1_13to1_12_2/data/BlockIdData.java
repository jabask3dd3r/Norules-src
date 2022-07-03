package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.io.*;
import java.util.*;

public class BlockIdData
{
    public static /* synthetic */ Map<String, String[]> fallbackReverseMapping;
    public static /* synthetic */ Int2ObjectMap<String> numberIdToString;
    public static final /* synthetic */ String[] PREVIOUS;
    public static /* synthetic */ Map<String, String[]> blockIdMapping;
    
    static {
        PREVIOUS = new String[0];
    }
    
    public static void init() {
        final InputStream llllllllllllllIIllIlllIlIlIIIlIl = MappingData.class.getClassLoader().getResourceAsStream("assets/viaversion/data/blockIds1.12to1.13.json");
        boolean llllllllllllllIIllIlllIlIlIIIIII = false;
        try {
            final InputStreamReader llllllllllllllIIllIlllIlIlIIlIlI = new InputStreamReader(llllllllllllllIIllIlllIlIlIIIlIl);
            try {
                final Map<String, String[]> llllllllllllllIIllIlllIlIlIIlIll = GsonUtil.getGson().fromJson(llllllllllllllIIllIlllIlIlIIlIlI, new TypeToken<Map<String, String[]>>() {}.getType());
                BlockIdData.blockIdMapping = new HashMap<String, String[]>(llllllllllllllIIllIlllIlIlIIlIll);
                BlockIdData.fallbackReverseMapping = new HashMap<String, String[]>();
                llllllllllllllIIllIlllIlIlIIIIII = (boolean)BlockIdData.blockIdMapping.entrySet().iterator();
                while (((Iterator)llllllllllllllIIllIlllIlIlIIIIII).hasNext()) {
                    final Map.Entry<String, String[]> llllllllllllllIIllIlllIlIlIIllII = ((Iterator<Map.Entry<String, String[]>>)llllllllllllllIIllIlllIlIlIIIIII).next();
                    final int llllllllllllllIIllIlllIlIIlllllI = (Object)llllllllllllllIIllIlllIlIlIIllII.getValue();
                    final int llllllllllllllIIllIlllIlIIllllIl = llllllllllllllIIllIlllIlIIlllllI.length;
                    for (String llllllllllllllIIllIlllIlIIllllII = (String)0; llllllllllllllIIllIlllIlIIllllII < llllllllllllllIIllIlllIlIIllllIl; ++llllllllllllllIIllIlllIlIIllllII) {
                        final String llllllllllllllIIllIlllIlIlIIllIl = llllllllllllllIIllIlllIlIIlllllI[llllllllllllllIIllIlllIlIIllllII];
                        String[] llllllllllllllIIllIlllIlIlIIlllI = BlockIdData.fallbackReverseMapping.get(llllllllllllllIIllIlllIlIlIIllIl);
                        if (llllllllllllllIIllIlllIlIlIIlllI == null) {
                            llllllllllllllIIllIlllIlIlIIlllI = BlockIdData.PREVIOUS;
                        }
                        BlockIdData.fallbackReverseMapping.put(llllllllllllllIIllIlllIlIlIIllIl, (String[])ObjectArrays.concat((Object[])llllllllllllllIIllIlllIlIlIIlllI, (Object)llllllllllllllIIllIlllIlIlIIllII.getKey()));
                    }
                }
                llllllllllllllIIllIlllIlIlIIlIlI.close();
            }
            catch (Throwable t) {
                try {
                    llllllllllllllIIllIlllIlIlIIlIlI.close();
                }
                catch (Throwable llllllllllllllIIllIlllIlIlIIIIII) {
                    t.addSuppressed((Throwable)llllllllllllllIIllIlllIlIlIIIIII);
                }
                throw t;
            }
        }
        catch (IOException llllllllllllllIIllIlllIlIlIIlIIl) {
            llllllllllllllIIllIlllIlIlIIlIIl.printStackTrace();
        }
        final InputStream llllllllllllllIIllIlllIlIlIIIlII = MappingData.class.getClassLoader().getResourceAsStream("assets/viaversion/data/blockNumberToString1.12.json");
        try {
            final InputStreamReader llllllllllllllIIllIlllIlIlIIIlll = new InputStreamReader(llllllllllllllIIllIlllIlIlIIIlII);
            try {
                final Map<Integer, String> llllllllllllllIIllIlllIlIlIIlIII = GsonUtil.getGson().fromJson(llllllllllllllIIllIlllIlIlIIIlll, new TypeToken<Map<Integer, String>>() {}.getType());
                BlockIdData.numberIdToString = new Int2ObjectOpenHashMap<String>(llllllllllllllIIllIlllIlIlIIlIII);
                llllllllllllllIIllIlllIlIlIIIlll.close();
            }
            catch (Throwable llllllllllllllIIllIlllIlIlIIIIII) {
                try {
                    llllllllllllllIIllIlllIlIlIIIlll.close();
                }
                catch (Throwable llllllllllllllIIllIlllIlIIllllll) {
                    ((Throwable)llllllllllllllIIllIlllIlIlIIIIII).addSuppressed((Throwable)llllllllllllllIIllIlllIlIIllllll);
                }
                throw llllllllllllllIIllIlllIlIlIIIIII;
            }
        }
        catch (IOException llllllllllllllIIllIlllIlIlIIIllI) {
            llllllllllllllIIllIlllIlIlIIIllI.printStackTrace();
        }
    }
}
