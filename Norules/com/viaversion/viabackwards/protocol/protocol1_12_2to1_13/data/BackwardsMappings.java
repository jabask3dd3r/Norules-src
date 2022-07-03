package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import java.util.*;
import com.viaversion.viaversion.api.data.*;

public class BackwardsMappings extends com.viaversion.viabackwards.api.data.BackwardsMappings
{
    private final /* synthetic */ Map<String, String> translateMappings;
    private final /* synthetic */ Int2ObjectMap<String> statisticMappings;
    private /* synthetic */ Mappings enchantmentMappings;
    
    public BackwardsMappings() {
        super("1.13", "1.12", Protocol1_13To1_12_2.class, true);
        this.statisticMappings = new Int2ObjectOpenHashMap<String>();
        this.translateMappings = new HashMap<String, String>();
    }
    
    public Map<String, String> getTranslateMappings() {
        return this.translateMappings;
    }
    
    @Override
    protected boolean shouldWarnOnMissing(final String llllllllllllllIIIlllIllllllllIlI) {
        return super.shouldWarnOnMissing(llllllllllllllIIIlllIllllllllIlI) && !llllllllllllllIIIlllIllllllllIlI.equals("items");
    }
    
    @Override
    protected int checkValidity(final int llllllllllllllIIIllllIIIIIIIIIIl, final int llllllllllllllIIIllllIIIIIIIIIII, final String llllllllllllllIIIlllIlllllllllll) {
        return llllllllllllllIIIllllIIIIIIIIIII;
    }
    
    private static void mapIdentifiers(final int[] llllllllllllllIIIllllIIIIIlIlIll, final JsonObject llllllllllllllIIIllllIIIIIlIllll, final JsonObject llllllllllllllIIIllllIIIIIlIlIIl, final JsonObject llllllllllllllIIIllllIIIIIlIllIl) {
        final Object2IntMap llllllllllllllIIIllllIIIIIlIllII = MappingDataLoader.indexedObjectToMap(llllllllllllllIIIllllIIIIIlIlIIl);
        for (final Map.Entry<String, JsonElement> llllllllllllllIIIllllIIIIIllIIIl : llllllllllllllIIIllllIIIIIlIllll.entrySet()) {
            final String llllllllllllllIIIllllIIIIIllIlII = llllllllllllllIIIllllIIIIIllIIIl.getValue().getAsString();
            int llllllllllllllIIIllllIIIIIllIIll = llllllllllllllIIIllllIIIIIlIllII.getInt(llllllllllllllIIIllllIIIIIllIlII);
            short llllllllllllllIIIllllIIIIIllIIlI = -1;
            if (llllllllllllllIIIllllIIIIIllIIll == -1) {
                JsonPrimitive llllllllllllllIIIllllIIIIIllIlIl = llllllllllllllIIIllllIIIIIlIllIl.getAsJsonPrimitive(llllllllllllllIIIllllIIIIIllIlII);
                final int llllllllllllllIIIllllIIIIIllIlll;
                if (llllllllllllllIIIllllIIIIIllIlIl == null && (llllllllllllllIIIllllIIIIIllIlll = llllllllllllllIIIllllIIIIIllIlII.indexOf(91)) != -1) {
                    llllllllllllllIIIllllIIIIIllIlIl = llllllllllllllIIIllllIIIIIlIllIl.getAsJsonPrimitive(llllllllllllllIIIllllIIIIIllIlII.substring(0, llllllllllllllIIIllllIIIIIllIlll));
                }
                if (llllllllllllllIIIllllIIIIIllIlIl != null) {
                    if (llllllllllllllIIIllllIIIIIllIlIl.getAsString().startsWith("id:")) {
                        final String llllllllllllllIIIllllIIIIIllIllI = llllllllllllllIIIllllIIIIIllIlIl.getAsString().replace("id:", "");
                        llllllllllllllIIIllllIIIIIllIIlI = Short.parseShort(llllllllllllllIIIllllIIIIIllIllI);
                        llllllllllllllIIIllllIIIIIllIIll = llllllllllllllIIIllllIIIIIlIllII.getInt(llllllllllllllIIIllllIIIIIlIlIIl.getAsJsonPrimitive(llllllllllllllIIIllllIIIIIllIllI).getAsString());
                    }
                    else {
                        llllllllllllllIIIllllIIIIIllIIll = llllllllllllllIIIllllIIIIIlIllII.getInt(llllllllllllllIIIllllIIIIIllIlIl.getAsString());
                    }
                }
                if (llllllllllllllIIIllllIIIIIllIIll == -1) {
                    if (Via.getConfig().isSuppressConversionWarnings() && !Via.getManager().isDebug()) {
                        continue;
                    }
                    if (llllllllllllllIIIllllIIIIIllIlIl != null) {
                        ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No key for ").append(llllllllllllllIIIllllIIIIIllIIIl.getValue()).append("/").append(llllllllllllllIIIllllIIIIIllIlIl.getAsString()).append(" :( ")));
                        continue;
                    }
                    ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("No key for ").append(llllllllllllllIIIllllIIIIIllIIIl.getValue()).append(" :( ")));
                    continue;
                }
            }
            llllllllllllllIIIllllIIIIIlIlIll[Integer.parseInt(llllllllllllllIIIllllIIIIIllIIIl.getKey())] = ((llllllllllllllIIIllllIIIIIllIIlI != -1) ? llllllllllllllIIIllllIIIIIllIIlI : ((short)llllllllllllllIIIllllIIIIIllIIll));
        }
    }
    
    public Int2ObjectMap<String> getStatisticMappings() {
        return this.statisticMappings;
    }
    
    public void loadVBExtras(final JsonObject llllllllllllllIIIllllIIIIlIIlIll, final JsonObject llllllllllllllIIIllllIIIIlIIlIlI) {
        this.enchantmentMappings = new VBMappings(llllllllllllllIIIllllIIIIlIIlIll.getAsJsonObject("enchantments"), llllllllllllllIIIllllIIIIlIIlIlI.getAsJsonObject("enchantments"), false);
        for (final Map.Entry<String, Integer> llllllllllllllIIIllllIIIIlIIlllI : StatisticMappings.CUSTOM_STATS.entrySet()) {
            this.statisticMappings.put((int)llllllllllllllIIIllllIIIIlIIlllI.getValue(), llllllllllllllIIIllllIIIIlIIlllI.getKey());
        }
        for (final Map.Entry<String, String> llllllllllllllIIIllllIIIIlIIllIl : Protocol1_13To1_12_2.MAPPINGS.getTranslateMapping().entrySet()) {
            this.translateMappings.put(llllllllllllllIIIllllIIIIlIIllIl.getValue(), llllllllllllllIIIllllIIIIlIIllIl.getKey());
        }
    }
    
    @Override
    public int getNewBlockStateId(final int llllllllllllllIIIllllIIIIIIIIlIl) {
        final int llllllllllllllIIIllllIIIIIIIIlll = super.getNewBlockStateId(llllllllllllllIIIllllIIIIIIIIlIl);
        switch (llllllllllllllIIIllllIIIIIIIIlll) {
            case 1595:
            case 1596:
            case 1597: {
                return 1584;
            }
            case 1611:
            case 1612:
            case 1613: {
                return 1600;
            }
            default: {
                return llllllllllllllIIIllllIIIIIIIIlll;
            }
        }
    }
    
    @Override
    protected Mappings loadFromObject(final JsonObject llllllllllllllIIIllllIIIIIIlIIIl, final JsonObject llllllllllllllIIIllllIIIIIIlIIII, final JsonObject llllllllllllllIIIllllIIIIIIIllll, final String llllllllllllllIIIllllIIIIIIIlllI) {
        if (llllllllllllllIIIllllIIIIIIIlllI.equals("blockstates")) {
            final int[] llllllllllllllIIIllllIIIIIIllIII = new int[8582];
            Arrays.fill(llllllllllllllIIIllllIIIIIIllIII, -1);
            mapIdentifiers(llllllllllllllIIIllllIIIIIIllIII, llllllllllllllIIIllllIIIIIIlIIIl.getAsJsonObject("blockstates"), llllllllllllllIIIllllIIIIIIlIIII.getAsJsonObject("blocks"), llllllllllllllIIIllllIIIIIIIllll.getAsJsonObject("blockstates"));
            return new IntArrayMappings(llllllllllllllIIIllllIIIIIIllIII);
        }
        return super.loadFromObject(llllllllllllllIIIllllIIIIIIlIIIl, llllllllllllllIIIllllIIIIIIlIIII, llllllllllllllIIIllllIIIIIIIllll, llllllllllllllIIIllllIIIIIIIlllI);
    }
    
    public Mappings getEnchantmentMappings() {
        return this.enchantmentMappings;
    }
}
