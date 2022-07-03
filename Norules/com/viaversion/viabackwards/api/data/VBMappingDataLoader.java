package com.viaversion.viabackwards.api.data;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.*;

public class VBMappingDataLoader
{
    public static JsonObject loadData(final String lllllllllllllIllIlIIIIlIlIlIIIIl) {
        final InputStream lllllllllllllIllIlIIIIlIlIlIIIlI = VBMappingDataLoader.class.getClassLoader().getResourceAsStream(String.valueOf(new StringBuilder().append("assets/viabackwards/data/").append(lllllllllllllIllIlIIIIlIlIlIIIIl)));
        try {
            final InputStreamReader lllllllllllllIllIlIIIIlIlIlIIlIl = new InputStreamReader(lllllllllllllIllIlIIIIlIlIlIIIlI);
            try {
                final boolean lllllllllllllIllIlIIIIlIlIIllllI = GsonUtil.getGson().fromJson(lllllllllllllIllIlIIIIlIlIlIIlIl, (Class<Boolean>)JsonObject.class);
                lllllllllllllIllIlIIIIlIlIlIIlIl.close();
                return (JsonObject)lllllllllllllIllIlIIIIlIlIIllllI;
            }
            catch (Throwable lllllllllllllIllIlIIIIlIlIIllllI) {
                try {
                    lllllllllllllIllIlIIIIlIlIlIIlIl.close();
                }
                catch (Throwable lllllllllllllIllIlIIIIlIlIIlllIl) {
                    ((Throwable)lllllllllllllIllIlIIIIlIlIIllllI).addSuppressed((Throwable)lllllllllllllIllIlIIIIlIlIIlllIl);
                }
                throw lllllllllllllIllIlIIIIlIlIIllllI;
            }
        }
        catch (IOException lllllllllllllIllIlIIIIlIlIlIIlII) {
            lllllllllllllIllIlIIIIlIlIlIIlII.printStackTrace();
            return null;
        }
    }
    
    public static void mapIdentifiers(final int[] lllllllllllllIllIlIIIIlIIlllIlll, final JsonObject lllllllllllllIllIlIIIIlIIlllllII, final JsonObject lllllllllllllIllIlIIIIlIIlllIlIl, final JsonObject lllllllllllllIllIlIIIIlIIlllIlII, final boolean lllllllllllllIllIlIIIIlIIllllIIl) {
        final Object2IntMap lllllllllllllIllIlIIIIlIIllllIII = MappingDataLoader.indexedObjectToMap(lllllllllllllIllIlIIIIlIIlllIlIl);
        for (final Map.Entry<String, JsonElement> lllllllllllllIllIlIIIIlIIllllllI : lllllllllllllIllIlIIIIlIIlllllII.entrySet()) {
            final String lllllllllllllIllIlIIIIlIlIIIIIII = lllllllllllllIllIlIIIIlIIllllllI.getValue().getAsString();
            int lllllllllllllIllIlIIIIlIIlllllll = lllllllllllllIllIlIIIIlIIllllIII.getInt(lllllllllllllIllIlIIIIlIlIIIIIII);
            if (lllllllllllllIllIlIIIIlIIlllllll == -1) {
                if (lllllllllllllIllIlIIIIlIIlllIlII != null) {
                    JsonPrimitive lllllllllllllIllIlIIIIlIlIIIIIlI = lllllllllllllIllIlIIIIlIIlllIlII.getAsJsonPrimitive(lllllllllllllIllIlIIIIlIlIIIIIII);
                    String lllllllllllllIllIlIIIIlIlIIIIIIl = (lllllllllllllIllIlIIIIlIlIIIIIlI != null) ? lllllllllllllIllIlIIIIlIlIIIIIlI.getAsString() : null;
                    final int lllllllllllllIllIlIIIIlIlIIIIIll;
                    if (lllllllllllllIllIlIIIIlIlIIIIIIl == null && (lllllllllllllIllIlIIIIlIlIIIIIll = lllllllllllllIllIlIIIIlIlIIIIIII.indexOf(91)) != -1 && (lllllllllllllIllIlIIIIlIlIIIIIlI = lllllllllllllIllIlIIIIlIIlllIlII.getAsJsonPrimitive(lllllllllllllIllIlIIIIlIlIIIIIII.substring(0, lllllllllllllIllIlIIIIlIlIIIIIll))) != null) {
                        lllllllllllllIllIlIIIIlIlIIIIIIl = lllllllllllllIllIlIIIIlIlIIIIIlI.getAsString();
                        if (lllllllllllllIllIlIIIIlIlIIIIIIl.endsWith("[")) {
                            lllllllllllllIllIlIIIIlIlIIIIIIl = String.valueOf(new StringBuilder().append(lllllllllllllIllIlIIIIlIlIIIIIIl).append(lllllllllllllIllIlIIIIlIlIIIIIII.substring(lllllllllllllIllIlIIIIlIlIIIIIll + 1)));
                        }
                    }
                    if (lllllllllllllIllIlIIIIlIlIIIIIIl != null) {
                        lllllllllllllIllIlIIIIlIIlllllll = lllllllllllllIllIlIIIIlIIllllIII.getInt(lllllllllllllIllIlIIIIlIlIIIIIIl);
                    }
                }
                if (lllllllllllllIllIlIIIIlIIlllllll == -1) {
                    if ((lllllllllllllIllIlIIIIlIIllllIIl && !Via.getConfig().isSuppressConversionWarnings()) || Via.getManager().isDebug()) {
                        ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No key for ").append(lllllllllllllIllIlIIIIlIIllllllI.getValue()).append(" :( ")));
                        continue;
                    }
                    continue;
                }
            }
            lllllllllllllIllIlIIIIlIIlllIlll[Integer.parseInt(lllllllllllllIllIlIIIIlIIllllllI.getKey())] = lllllllllllllIllIlIIIIlIIlllllll;
        }
    }
    
    public static Int2ObjectMap<MappedItem> loadItemMappings(final JsonObject lllllllllllllIllIlIIIIlIIIllIlII, final JsonObject lllllllllllllIllIlIIIIlIIIlllIlI, final JsonObject lllllllllllllIllIlIIIIlIIIlllIIl, final boolean lllllllllllllIllIlIIIIlIIIlllIII) {
        final Int2ObjectMap<MappedItem> lllllllllllllIllIlIIIIlIIIllIlll = new Int2ObjectOpenHashMap<MappedItem>(lllllllllllllIllIlIIIIlIIIlllIIl.size(), 1.0f);
        final Object2IntMap<String> lllllllllllllIllIlIIIIlIIIllIllI = MappingDataLoader.indexedObjectToMap(lllllllllllllIllIlIIIIlIIIlllIlI);
        final Object2IntMap<String> lllllllllllllIllIlIIIIlIIIllIlIl = MappingDataLoader.indexedObjectToMap(lllllllllllllIllIlIIIIlIIIllIlII);
        for (final Map.Entry<String, JsonElement> lllllllllllllIllIlIIIIlIIIllllIl : lllllllllllllIllIlIIIIlIIIlllIIl.entrySet()) {
            final JsonObject lllllllllllllIllIlIIIIlIIlIIIIlI = lllllllllllllIllIlIIIIlIIIllllIl.getValue().getAsJsonObject();
            final String lllllllllllllIllIlIIIIlIIlIIIIIl = lllllllllllllIllIlIIIIlIIlIIIIlI.getAsJsonPrimitive("id").getAsString();
            final int lllllllllllllIllIlIIIIlIIlIIIIII = lllllllllllllIllIlIIIIlIIIllIllI.getInt(lllllllllllllIllIlIIIIlIIlIIIIIl);
            if (lllllllllllllIllIlIIIIlIIlIIIIII == -1) {
                if (Via.getConfig().isSuppressConversionWarnings() && !Via.getManager().isDebug()) {
                    continue;
                }
                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No key for ").append(lllllllllllllIllIlIIIIlIIlIIIIIl).append(" :( ")));
            }
            else {
                final int lllllllllllllIllIlIIIIlIIIllllll = lllllllllllllIllIlIIIIlIIIllIlIl.getInt(lllllllllllllIllIlIIIIlIIIllllIl.getKey());
                if (lllllllllllllIllIlIIIIlIIIllllll == -1) {
                    if (Via.getConfig().isSuppressConversionWarnings() && !Via.getManager().isDebug()) {
                        continue;
                    }
                    ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No old entry for ").append(lllllllllllllIllIlIIIIlIIlIIIIIl).append(" :( ")));
                }
                else {
                    final String lllllllllllllIllIlIIIIlIIIlllllI = lllllllllllllIllIlIIIIlIIlIIIIlI.getAsJsonPrimitive("name").getAsString();
                    lllllllllllllIllIlIIIIlIIIllIlll.put(lllllllllllllIllIlIIIIlIIIllllll, new MappedItem(lllllllllllllIllIlIIIIlIIlIIIIII, lllllllllllllIllIlIIIIlIIIlllllI));
                }
            }
        }
        if (lllllllllllllIllIlIIIIlIIIlllIII && !Via.getConfig().isSuppressConversionWarnings()) {
            for (final Object2IntMap.Entry<String> lllllllllllllIllIlIIIIlIIIllllII : lllllllllllllIllIlIIIIlIIIllIlIl.object2IntEntrySet()) {
                if (!lllllllllllllIllIlIIIIlIIIllIllI.containsKey(lllllllllllllIllIlIIIIlIIIllllII.getKey()) && !lllllllllllllIllIlIIIIlIIIllIlll.containsKey(lllllllllllllIllIlIIIIlIIIllllII.getIntValue())) {
                    ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No item mapping for ").append(lllllllllllllIllIlIIIIlIIIllllII.getKey()).append(" :( ")));
                }
            }
        }
        return lllllllllllllIllIlIIIIlIIIllIlll;
    }
    
    public static Map<String, String> objectToMap(final JsonObject lllllllllllllIllIlIIIIlIIllIIIIl) {
        final Map<String, String> lllllllllllllIllIlIIIIlIIllIIIII = new HashMap<String, String>();
        for (final Map.Entry<String, JsonElement> lllllllllllllIllIlIIIIlIIllIIIlI : lllllllllllllIllIlIIIIlIIllIIIIl.entrySet()) {
            String lllllllllllllIllIlIIIIlIIllIIlII = lllllllllllllIllIlIIIIlIIllIIIlI.getKey();
            if (lllllllllllllIllIlIIIIlIIllIIlII.indexOf(58) == -1) {
                lllllllllllllIllIlIIIIlIIllIIlII = String.valueOf(new StringBuilder().append("minecraft:").append(lllllllllllllIllIlIIIIlIIllIIlII));
            }
            String lllllllllllllIllIlIIIIlIIllIIIll = lllllllllllllIllIlIIIIlIIllIIIlI.getValue().getAsString();
            if (lllllllllllllIllIlIIIIlIIllIIIll.indexOf(58) == -1) {
                lllllllllllllIllIlIIIIlIIllIIIll = String.valueOf(new StringBuilder().append("minecraft:").append(lllllllllllllIllIlIIIIlIIllIIIll));
            }
            lllllllllllllIllIlIIIIlIIllIIIII.put(lllllllllllllIllIlIIIIlIIllIIlII, lllllllllllllIllIlIIIIlIIllIIIll);
        }
        return lllllllllllllIllIlIIIIlIIllIIIII;
    }
    
    public static JsonObject loadFromDataDir(final String lllllllllllllIllIlIIIIlIlIlIllll) {
        final File lllllllllllllIllIlIIIIlIlIllIIII = new File(ViaBackwards.getPlatform().getDataFolder(), lllllllllllllIllIlIIIIlIlIlIllll);
        if (!lllllllllllllIllIlIIIIlIlIllIIII.exists()) {
            return loadData(lllllllllllllIllIlIIIIlIlIlIllll);
        }
        try {
            final FileReader lllllllllllllIllIlIIIIlIlIllIlII = new FileReader(lllllllllllllIllIlIIIIlIlIllIIII);
            try {
                final String lllllllllllllIllIlIIIIlIlIlIllII = (String)GsonUtil.getGson().fromJson(lllllllllllllIllIlIIIIlIlIllIlII, JsonObject.class);
                lllllllllllllIllIlIIIIlIlIllIlII.close();
                return (JsonObject)lllllllllllllIllIlIIIIlIlIlIllII;
            }
            catch (Throwable lllllllllllllIllIlIIIIlIlIlIllII) {
                try {
                    lllllllllllllIllIlIIIIlIlIllIlII.close();
                }
                catch (Throwable lllllllllllllIllIlIIIIlIlIlIlIll) {
                    ((Throwable)lllllllllllllIllIlIIIIlIlIlIllII).addSuppressed((Throwable)lllllllllllllIllIlIIIIlIlIlIlIll);
                }
                throw lllllllllllllIllIlIIIIlIlIlIllII;
            }
        }
        catch (JsonSyntaxException lllllllllllllIllIlIIIIlIlIllIIll) {
            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append(lllllllllllllIllIlIIIIlIlIlIllll).append(" is badly formatted!")));
            lllllllllllllIllIlIIIIlIlIllIIll.printStackTrace();
            ViaBackwards.getPlatform().getLogger().warning("Falling back to resource's file!");
            return loadData(lllllllllllllIllIlIIIIlIlIlIllll);
        }
        catch (IOException | JsonIOException ex2) {
            final Exception ex;
            final Exception lllllllllllllIllIlIIIIlIlIllIIlI = ex;
            lllllllllllllIllIlIIIIlIlIllIIlI.printStackTrace();
            return null;
        }
    }
    
    public static void mapIdentifiers(final int[] lllllllllllllIllIlIIIIlIlIIllIII, final JsonObject lllllllllllllIllIlIIIIlIlIIlIIll, final JsonObject lllllllllllllIllIlIIIIlIlIIlIIlI, final JsonObject lllllllllllllIllIlIIIIlIlIIlIlIl) {
        mapIdentifiers(lllllllllllllIllIlIIIIlIlIIllIII, lllllllllllllIllIlIIIIlIlIIlIIll, lllllllllllllIllIlIIIIlIlIIlIIlI, lllllllllllllIllIlIIIIlIlIIlIlIl, true);
    }
    
    public static Int2ObjectMap<MappedItem> loadItemMappings(final JsonObject lllllllllllllIllIlIIIIlIIlIlIllI, final JsonObject lllllllllllllIllIlIIIIlIIlIlIIlI, final JsonObject lllllllllllllIllIlIIIIlIIlIlIlII) {
        return loadItemMappings(lllllllllllllIllIlIIIIlIIlIlIllI, lllllllllllllIllIlIIIIlIIlIlIIlI, lllllllllllllIllIlIIIIlIIlIlIlII, false);
    }
}
