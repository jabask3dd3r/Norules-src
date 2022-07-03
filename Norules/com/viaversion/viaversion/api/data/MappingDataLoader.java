package com.viaversion.viaversion.api.data;

import java.util.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.util.*;
import java.io.*;

public class MappingDataLoader
{
    private static /* synthetic */ boolean cacheJsonMappings;
    private static final /* synthetic */ Map<String, JsonObject> MAPPINGS_CACHE;
    
    static {
        MAPPINGS_CACHE = new ConcurrentHashMap<String, JsonObject>();
    }
    
    public static Object2IntMap<String> arrayToMap(final JsonArray lllllllllllllIIIlIlIIIIllIlllIll) {
        final Object2IntMap<String> lllllllllllllIIIlIlIIIIllIllllII = new Object2IntOpenHashMap<String>(lllllllllllllIIIlIlIIIIllIlllIll.size(), 1.0f);
        lllllllllllllIIIlIlIIIIllIllllII.defaultReturnValue(-1);
        for (int lllllllllllllIIIlIlIIIIllIlllllI = 0; lllllllllllllIIIlIlIIIIllIlllllI < lllllllllllllIIIlIlIIIIllIlllIll.size(); ++lllllllllllllIIIlIlIIIIllIlllllI) {
            lllllllllllllIIIlIlIIIIllIllllII.put(lllllllllllllIIIlIlIIIIllIlllIll.get(lllllllllllllIIIlIlIIIIllIlllllI).getAsString(), lllllllllllllIIIlIlIIIIllIlllllI);
        }
        return lllllllllllllIIIlIlIIIIllIllllII;
    }
    
    public static InputStream getResource(final String lllllllllllllIIIlIlIIIIllIllIllI) {
        return MappingDataLoader.class.getClassLoader().getResourceAsStream(String.valueOf(new StringBuilder().append("assets/viaversion/data/").append(lllllllllllllIIIlIlIIIIllIllIllI)));
    }
    
    public static JsonObject loadFromDataDir(final String lllllllllllllIIIlIlIIIlIIllIIIIl) {
        final File lllllllllllllIIIlIlIIIlIIllIIIII = new File(Via.getPlatform().getDataFolder(), lllllllllllllIIIlIlIIIlIIllIIIIl);
        if (!lllllllllllllIIIlIlIIIlIIllIIIII.exists()) {
            return loadData(lllllllllllllIIIlIlIIIlIIllIIIIl);
        }
        try {
            final FileReader lllllllllllllIIIlIlIIIlIIllIIlII = new FileReader(lllllllllllllIIIlIlIIIlIIllIIIII);
            try {
                final byte lllllllllllllIIIlIlIIIlIIlIlllII = GsonUtil.getGson().fromJson(lllllllllllllIIIlIlIIIlIIllIIlII, (Class<Byte>)JsonObject.class);
                lllllllllllllIIIlIlIIIlIIllIIlII.close();
                return (JsonObject)lllllllllllllIIIlIlIIIlIIlIlllII;
            }
            catch (Throwable lllllllllllllIIIlIlIIIlIIlIlllII) {
                try {
                    lllllllllllllIIIlIlIIIlIIllIIlII.close();
                }
                catch (Throwable lllllllllllllIIIlIlIIIlIIlIllIll) {
                    ((Throwable)lllllllllllllIIIlIlIIIlIIlIlllII).addSuppressed((Throwable)lllllllllllllIIIlIlIIIlIIlIllIll);
                }
                throw lllllllllllllIIIlIlIIIlIIlIlllII;
            }
        }
        catch (JsonSyntaxException lllllllllllllIIIlIlIIIlIIllIIIll) {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append(lllllllllllllIIIlIlIIIlIIllIIIIl).append(" is badly formatted!")));
            lllllllllllllIIIlIlIIIlIIllIIIll.printStackTrace();
        }
        catch (IOException | JsonIOException ex2) {
            final Exception ex;
            final Exception lllllllllllllIIIlIlIIIlIIllIIIlI = ex;
            lllllllllllllIIIlIlIIIlIIllIIIlI.printStackTrace();
        }
        return null;
    }
    
    public static boolean isCacheJsonMappings() {
        return MappingDataLoader.cacheJsonMappings;
    }
    
    public static void enableMappingsCache() {
        MappingDataLoader.cacheJsonMappings = true;
    }
    
    public static void mapIdentifiers(final int[] lllllllllllllIIIlIlIIIlIIIlIIlIl, final JsonObject lllllllllllllIIIlIlIIIlIIIlIIIIl, final JsonObject lllllllllllllIIIlIlIIIlIIIlIIIll) {
        mapIdentifiers(lllllllllllllIIIlIlIIIlIIIlIIlIl, lllllllllllllIIIlIlIIIlIIIlIIIIl, lllllllllllllIIIlIlIIIlIIIlIIIll, null);
    }
    
    public static JsonObject loadData(final String lllllllllllllIIIlIlIIIlIIlIllIII) {
        return loadData(lllllllllllllIIIlIlIIIlIIlIllIII, false);
    }
    
    public static void mapIdentifiers(final int[] lllllllllllllIIIlIlIIIIlllIlllIl, final JsonArray lllllllllllllIIIlIlIIIIlllIlllII, final JsonArray lllllllllllllIIIlIlIIIIlllIllIll, final JsonObject lllllllllllllIIIlIlIIIIlllIllIlI, final boolean lllllllllllllIIIlIlIIIIlllIlIIll) {
        final Object2IntMap<String> lllllllllllllIIIlIlIIIIlllIllIII = arrayToMap(lllllllllllllIIIlIlIIIIlllIllIll);
        for (int lllllllllllllIIIlIlIIIIlllIllllI = 0; lllllllllllllIIIlIlIIIIlllIllllI < lllllllllllllIIIlIlIIIIlllIlllII.size(); ++lllllllllllllIIIlIlIIIIlllIllllI) {
            final JsonElement lllllllllllllIIIlIlIIIIllllIIIII = lllllllllllllIIIlIlIIIIlllIlllII.get(lllllllllllllIIIlIlIIIIlllIllllI);
            int lllllllllllllIIIlIlIIIIlllIlllll = lllllllllllllIIIlIlIIIIlllIllIII.getInt(lllllllllllllIIIlIlIIIIllllIIIII.getAsString());
            if (lllllllllllllIIIlIlIIIIlllIlllll == -1) {
                if (lllllllllllllIIIlIlIIIIlllIllIlI != null) {
                    final JsonElement lllllllllllllIIIlIlIIIIllllIIIIl = lllllllllllllIIIlIlIIIIlllIllIlI.get(lllllllllllllIIIlIlIIIIllllIIIII.getAsString());
                    if (lllllllllllllIIIlIlIIIIllllIIIIl != null) {
                        final String lllllllllllllIIIlIlIIIIllllIIIlI = lllllllllllllIIIlIlIIIIllllIIIIl.getAsString();
                        if (lllllllllllllIIIlIlIIIIllllIIIlI.isEmpty()) {
                            continue;
                        }
                        lllllllllllllIIIlIlIIIIlllIlllll = lllllllllllllIIIlIlIIIIlllIllIII.getInt(lllllllllllllIIIlIlIIIIllllIIIlI);
                    }
                }
                if (lllllllllllllIIIlIlIIIIlllIlllll == -1) {
                    if ((lllllllllllllIIIlIlIIIIlllIlIIll && !Via.getConfig().isSuppressConversionWarnings()) || Via.getManager().isDebug()) {
                        Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No key for ").append(lllllllllllllIIIlIlIIIIllllIIIII).append(" :( ")));
                    }
                    continue;
                }
            }
            lllllllllllllIIIlIlIIIIlllIlllIl[lllllllllllllIIIlIlIIIIlllIllllI] = lllllllllllllIIIlIlIIIIlllIlllll;
        }
    }
    
    public static void mapIdentifiers(final int[] lllllllllllllIIIlIlIIIIlllllIIIl, final JsonArray lllllllllllllIIIlIlIIIIlllllIlII, final JsonArray lllllllllllllIIIlIlIIIIllllIllll, final boolean lllllllllllllIIIlIlIIIIllllIlllI) {
        mapIdentifiers(lllllllllllllIIIlIlIIIIlllllIIIl, lllllllllllllIIIlIlIIIIlllllIlII, lllllllllllllIIIlIlIIIIllllIllll, null, lllllllllllllIIIlIlIIIIllllIlllI);
    }
    
    private static int mapIdentifierEntry(final Map.Entry<String, JsonElement> lllllllllllllIIIlIlIIIlIIIIIIIlI, final Object2IntMap lllllllllllllIIIlIlIIIlIIIIIIIIl, final JsonObject lllllllllllllIIIlIlIIIlIIIIIIIII) {
        int lllllllllllllIIIlIlIIIIlllllllll = lllllllllllllIIIlIlIIIlIIIIIIIIl.getInt(lllllllllllllIIIlIlIIIlIIIIIIIlI.getValue().getAsString());
        if (lllllllllllllIIIlIlIIIIlllllllll == -1) {
            if (lllllllllllllIIIlIlIIIlIIIIIIIII != null) {
                final JsonElement lllllllllllllIIIlIlIIIlIIIIIIIll = lllllllllllllIIIlIlIIIlIIIIIIIII.get(lllllllllllllIIIlIlIIIlIIIIIIIlI.getKey());
                if (lllllllllllllIIIlIlIIIlIIIIIIIll != null) {
                    lllllllllllllIIIlIlIIIIlllllllll = lllllllllllllIIIlIlIIIlIIIIIIIIl.getInt(lllllllllllllIIIlIlIIIlIIIIIIIll.getAsString());
                }
            }
            if (lllllllllllllIIIlIlIIIIlllllllll == -1) {
                if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No key for ").append(lllllllllllllIIIlIlIIIlIIIIIIIlI.getValue()).append(" :( ")));
                }
                return -1;
            }
        }
        return lllllllllllllIIIlIlIIIIlllllllll;
    }
    
    public static Object2IntMap<String> indexedObjectToMap(final JsonObject lllllllllllllIIIlIlIIIIlllIIIlIl) {
        final Object2IntMap<String> lllllllllllllIIIlIlIIIIlllIIIllI = new Object2IntOpenHashMap<String>(lllllllllllllIIIlIlIIIIlllIIIlIl.size(), 1.0f);
        lllllllllllllIIIlIlIIIIlllIIIllI.defaultReturnValue(-1);
        for (final Map.Entry<String, JsonElement> lllllllllllllIIIlIlIIIIlllIIlIII : lllllllllllllIIIlIlIIIIlllIIIlIl.entrySet()) {
            lllllllllllllIIIlIlIIIIlllIIIllI.put(lllllllllllllIIIlIlIIIIlllIIlIII.getValue().getAsString(), Integer.parseInt(lllllllllllllIIIlIlIIIIlllIIlIII.getKey()));
        }
        return lllllllllllllIIIlIlIIIIlllIIIllI;
    }
    
    public static void mapIdentifiers(final int[] lllllllllllllIIIlIlIIIlIIIIlIIII, final JsonObject lllllllllllllIIIlIlIIIlIIIIIllll, final JsonObject lllllllllllllIIIlIlIIIlIIIIIlllI, final JsonObject lllllllllllllIIIlIlIIIlIIIIIllIl) {
        final Object2IntMap<String> lllllllllllllIIIlIlIIIlIIIIlIIIl = indexedObjectToMap(lllllllllllllIIIlIlIIIlIIIIIlllI);
        for (final Map.Entry<String, JsonElement> lllllllllllllIIIlIlIIIlIIIIlIllI : lllllllllllllIIIlIlIIIlIIIIIllll.entrySet()) {
            final int lllllllllllllIIIlIlIIIlIIIIlIlll = mapIdentifierEntry(lllllllllllllIIIlIlIIIlIIIIlIllI, lllllllllllllIIIlIlIIIlIIIIlIIIl, lllllllllllllIIIlIlIIIlIIIIIllIl);
            if (lllllllllllllIIIlIlIIIlIIIIlIlll != -1) {
                lllllllllllllIIIlIlIIIlIIIIlIIII[Integer.parseInt(lllllllllllllIIIlIlIIIlIIIIlIllI.getKey())] = lllllllllllllIIIlIlIIIlIIIIlIlll;
            }
        }
    }
    
    public static void mapIdentifiers(final Int2IntBiMap lllllllllllllIIIlIlIIIlIIIllIIII, final JsonObject lllllllllllllIIIlIlIIIlIIIlIllll, final JsonObject lllllllllllllIIIlIlIIIlIIIlIlllI, final JsonObject lllllllllllllIIIlIlIIIlIIIllIIlI) {
        final Object2IntMap<String> lllllllllllllIIIlIlIIIlIIIllIIIl = indexedObjectToMap(lllllllllllllIIIlIlIIIlIIIlIlllI);
        for (final Map.Entry<String, JsonElement> lllllllllllllIIIlIlIIIlIIIllIllI : lllllllllllllIIIlIlIIIlIIIlIllll.entrySet()) {
            final int lllllllllllllIIIlIlIIIlIIIllIlll = mapIdentifierEntry(lllllllllllllIIIlIlIIIlIIIllIllI, lllllllllllllIIIlIlIIIlIIIllIIIl, lllllllllllllIIIlIlIIIlIIIllIIlI);
            if (lllllllllllllIIIlIlIIIlIIIllIlll != -1) {
                lllllllllllllIIIlIlIIIlIIIllIIII.put(Integer.parseInt(lllllllllllllIIIlIlIIIlIIIllIllI.getKey()), lllllllllllllIIIlIlIIIlIIIllIlll);
            }
        }
    }
    
    public static JsonObject loadData(final String lllllllllllllIIIlIlIIIlIIlIIlIII, final boolean lllllllllllllIIIlIlIIIlIIlIIIlll) {
        if (MappingDataLoader.cacheJsonMappings) {
            final JsonObject lllllllllllllIIIlIlIIIlIIlIIlllI = MappingDataLoader.MAPPINGS_CACHE.get(lllllllllllllIIIlIlIIIlIIlIIlIII);
            if (lllllllllllllIIIlIlIIIlIIlIIlllI != null) {
                return lllllllllllllIIIlIlIIIlIIlIIlllI;
            }
        }
        final InputStream lllllllllllllIIIlIlIIIlIIlIIlIlI = getResource(lllllllllllllIIIlIlIIIlIIlIIlIII);
        if (lllllllllllllIIIlIlIIIlIIlIIlIlI == null) {
            return null;
        }
        final InputStreamReader lllllllllllllIIIlIlIIIlIIlIIlIIl = new InputStreamReader(lllllllllllllIIIlIlIIIlIIlIIlIlI);
        try {
            final JsonObject lllllllllllllIIIlIlIIIlIIlIIllIl = GsonUtil.getGson().fromJson(lllllllllllllIIIlIlIIIlIIlIIlIIl, JsonObject.class);
            if (lllllllllllllIIIlIlIIIlIIlIIIlll && MappingDataLoader.cacheJsonMappings) {
                MappingDataLoader.MAPPINGS_CACHE.put(lllllllllllllIIIlIlIIIlIIlIIlIII, lllllllllllllIIIlIlIIIlIIlIIllIl);
            }
            final String lllllllllllllIIIlIlIIIlIIlIIIIll = (String)lllllllllllllIIIlIlIIIlIIlIIllIl;
            return (JsonObject)lllllllllllllIIIlIlIIIlIIlIIIIll;
        }
        finally {
            try {
                lllllllllllllIIIlIlIIIlIIlIIlIIl.close();
            }
            catch (IOException ex) {}
        }
    }
    
    public static Map<String, JsonObject> getMappingsCache() {
        return MappingDataLoader.MAPPINGS_CACHE;
    }
}
