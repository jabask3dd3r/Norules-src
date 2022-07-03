package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.minecraft.*;
import java.util.logging.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.*;

public class MappingDataBase implements MappingData
{
    protected /* synthetic */ Mappings blockStateMappings;
    protected /* synthetic */ Int2IntBiMap itemMappings;
    protected /* synthetic */ Map<RegistryType, List<TagData>> tags;
    protected /* synthetic */ Mappings statisticsMappings;
    protected final /* synthetic */ boolean hasDiffFile;
    protected /* synthetic */ Mappings soundMappings;
    protected /* synthetic */ Mappings blockMappings;
    protected /* synthetic */ ParticleMappings particleMappings;
    protected final /* synthetic */ String oldVersion;
    protected /* synthetic */ boolean loadItems;
    protected final /* synthetic */ String newVersion;
    
    public MappingDataBase(final String lllllllllllllIlIlIlIlllllIlIllll, final String lllllllllllllIlIlIlIlllllIlIlllI) {
        this(lllllllllllllIlIlIlIlllllIlIllll, lllllllllllllIlIlIlIlllllIlIlllI, false);
    }
    
    protected int checkValidity(final int lllllllllllllIlIlIlIlllIlIIllIII, final int lllllllllllllIlIlIlIlllIlIIlIlll, final String lllllllllllllIlIlIlIlllIlIIlIllI) {
        if (lllllllllllllIlIlIlIlllIlIIlIlll == -1) {
            this.getLogger().warning(String.format("Missing %s %s for %s %s %d", this.newVersion, lllllllllllllIlIlIlIlllIlIIlIllI, this.oldVersion, lllllllllllllIlIlIlIlllIlIIlIllI, lllllllllllllIlIlIlIlllIlIIllIII));
            return 0;
        }
        return lllllllllllllIlIlIlIlllIlIIlIlll;
    }
    
    @Override
    public int getNewBlockStateId(final int lllllllllllllIlIlIlIllllIIllIIlI) {
        return this.checkValidity(lllllllllllllIlIlIlIllllIIllIIlI, this.blockStateMappings.getNewId(lllllllllllllIlIlIlIllllIIllIIlI), "blockstate");
    }
    
    @Override
    public List<TagData> getTags(final RegistryType lllllllllllllIlIlIlIlllIllllIIIl) {
        return (this.tags != null) ? this.tags.get(lllllllllllllIlIlIlIlllIllllIIIl) : null;
    }
    
    @Override
    public int getNewParticleId(final int lllllllllllllIlIlIlIllllIIIIIIIl) {
        return this.checkValidity(lllllllllllllIlIlIlIllllIIIIIIIl, this.particleMappings.getMappings().getNewId(lllllllllllllIlIlIlIllllIIIIIIIl), "particles");
    }
    
    protected Logger getLogger() {
        return Via.getPlatform().getLogger();
    }
    
    @Override
    public void load() {
        this.getLogger().info(String.valueOf(new StringBuilder().append("Loading ").append(this.oldVersion).append(" -> ").append(this.newVersion).append(" mappings...")));
        final JsonObject lllllllllllllIlIlIlIlllllIIIlllI = this.hasDiffFile ? this.loadDiffFile() : null;
        final JsonObject lllllllllllllIlIlIlIlllllIIIllII = MappingDataLoader.loadData(String.valueOf(new StringBuilder().append("mapping-").append(this.oldVersion).append(".json")), true);
        final JsonObject lllllllllllllIlIlIlIlllllIIIlIll = MappingDataLoader.loadData(String.valueOf(new StringBuilder().append("mapping-").append(this.newVersion).append(".json")), true);
        this.blockMappings = this.loadFromObject(lllllllllllllIlIlIlIlllllIIIllII, lllllllllllllIlIlIlIlllllIIIlIll, lllllllllllllIlIlIlIlllllIIIlllI, "blocks");
        this.blockStateMappings = this.loadFromObject(lllllllllllllIlIlIlIlllllIIIllII, lllllllllllllIlIlIlIlllllIIIlIll, lllllllllllllIlIlIlIlllllIIIlllI, "blockstates");
        this.soundMappings = this.loadFromArray(lllllllllllllIlIlIlIlllllIIIllII, lllllllllllllIlIlIlIlllllIIIlIll, lllllllllllllIlIlIlIlllllIIIlllI, "sounds");
        this.statisticsMappings = this.loadFromArray(lllllllllllllIlIlIlIlllllIIIllII, lllllllllllllIlIlIlIlllllIIIlIll, lllllllllllllIlIlIlIlllllIIIlllI, "statistics");
        final Mappings lllllllllllllIlIlIlIlllllIIIlIIl = this.loadFromArray(lllllllllllllIlIlIlIlllllIIIllII, lllllllllllllIlIlIlIlllllIIIlIll, lllllllllllllIlIlIlIlllllIIIlllI, "particles");
        if (lllllllllllllIlIlIlIlllllIIIlIIl != null) {
            this.particleMappings = new ParticleMappings(lllllllllllllIlIlIlIlllllIIIllII.getAsJsonArray("particles"), lllllllllllllIlIlIlIlllllIIIlIIl);
        }
        if (this.loadItems && lllllllllllllIlIlIlIlllllIIIlIll.has("items")) {
            this.itemMappings = new Int2IntBiHashMap();
            this.itemMappings.defaultReturnValue(-1);
            MappingDataLoader.mapIdentifiers(this.itemMappings, lllllllllllllIlIlIlIlllllIIIllII.getAsJsonObject("items"), lllllllllllllIlIlIlIlllllIIIlIll.getAsJsonObject("items"), (lllllllllllllIlIlIlIlllllIIIlllI != null) ? lllllllllllllIlIlIlIlllllIIIlllI.getAsJsonObject("items") : null);
        }
        if (lllllllllllllIlIlIlIlllllIIIlllI != null && lllllllllllllIlIlIlIlllllIIIlllI.has("tags")) {
            this.tags = new EnumMap<RegistryType, List<TagData>>(RegistryType.class);
            final JsonObject lllllllllllllIlIlIlIlllllIIlIIII = lllllllllllllIlIlIlIlllllIIIlllI.getAsJsonObject("tags");
            if (lllllllllllllIlIlIlIlllllIIlIIII.has(RegistryType.ITEM.getResourceLocation())) {
                this.loadTags(RegistryType.ITEM, lllllllllllllIlIlIlIlllllIIlIIII, MappingDataLoader.indexedObjectToMap(lllllllllllllIlIlIlIlllllIIIlIll.getAsJsonObject("items")));
            }
            if (lllllllllllllIlIlIlIlllllIIlIIII.has(RegistryType.BLOCK.getResourceLocation())) {
                this.loadTags(RegistryType.BLOCK, lllllllllllllIlIlIlIlllllIIlIIII, MappingDataLoader.indexedObjectToMap(lllllllllllllIlIlIlIlllllIIIlIll.getAsJsonObject("blocks")));
            }
        }
        this.loadExtras(lllllllllllllIlIlIlIlllllIIIllII, lllllllllllllIlIlIlIlllllIIIlIll, lllllllllllllIlIlIlIlllllIIIlllI);
    }
    
    protected Mappings loadFromObject(final JsonObject lllllllllllllIlIlIlIlllIlIlIllll, final JsonObject lllllllllllllIlIlIlIlllIlIlIlIIl, final JsonObject lllllllllllllIlIlIlIlllIlIlIlIII, final String lllllllllllllIlIlIlIlllIlIlIllII) {
        if (!lllllllllllllIlIlIlIlllIlIlIllll.has(lllllllllllllIlIlIlIlllIlIlIllII) || !lllllllllllllIlIlIlIlllIlIlIlIIl.has(lllllllllllllIlIlIlIlllIlIlIllII)) {
            return null;
        }
        final JsonObject lllllllllllllIlIlIlIlllIlIlIlIll = (lllllllllllllIlIlIlIlllIlIlIlIII != null) ? lllllllllllllIlIlIlIlllIlIlIlIII.getAsJsonObject(lllllllllllllIlIlIlIlllIlIlIllII) : null;
        return new IntArrayMappings(lllllllllllllIlIlIlIlllIlIlIllll.getAsJsonObject(lllllllllllllIlIlIlIlllIlIlIllII), lllllllllllllIlIlIlIlllIlIlIlIIl.getAsJsonObject(lllllllllllllIlIlIlIlllIlIlIllII), lllllllllllllIlIlIlIlllIlIlIlIll);
    }
    
    @Override
    public Mappings getSoundMappings() {
        return this.soundMappings;
    }
    
    @Override
    public Mappings getBlockStateMappings() {
        return this.blockStateMappings;
    }
    
    @Override
    public ParticleMappings getParticleMappings() {
        return this.particleMappings;
    }
    
    protected Mappings loadFromArray(final JsonObject lllllllllllllIlIlIlIlllIlIlllIlI, final JsonObject lllllllllllllIlIlIlIlllIlIlllIIl, final JsonObject lllllllllllllIlIlIlIlllIlIlllIII, final String lllllllllllllIlIlIlIlllIlIllllIl) {
        if (!lllllllllllllIlIlIlIlllIlIlllIlI.has(lllllllllllllIlIlIlIlllIlIllllIl) || !lllllllllllllIlIlIlIlllIlIlllIIl.has(lllllllllllllIlIlIlIlllIlIllllIl)) {
            return null;
        }
        final JsonObject lllllllllllllIlIlIlIlllIlIlllIll = (lllllllllllllIlIlIlIlllIlIlllIII != null) ? lllllllllllllIlIlIlIlllIlIlllIII.getAsJsonObject(lllllllllllllIlIlIlIlllIlIllllIl) : null;
        return new IntArrayMappings(lllllllllllllIlIlIlIlllIlIlllIlI.getAsJsonArray(lllllllllllllIlIlIlIlllIlIllllIl), lllllllllllllIlIlIlIlllIlIlllIIl.getAsJsonArray(lllllllllllllIlIlIlIlllIlIllllIl), lllllllllllllIlIlIlIlllIlIlllIll);
    }
    
    @Override
    public int getOldItemId(final int lllllllllllllIlIlIlIllllIIIlIIIl) {
        final int lllllllllllllIlIlIlIllllIIIIllll = this.itemMappings.inverse().get(lllllllllllllIlIlIlIllllIIIlIIIl);
        return (lllllllllllllIlIlIlIllllIIIIllll != -1) ? lllllllllllllIlIlIlIllllIIIIllll : 1;
    }
    
    @Override
    public Int2IntBiMap getItemMappings() {
        return this.itemMappings;
    }
    
    @Override
    public int getNewItemId(final int lllllllllllllIlIlIlIllllIIIllIll) {
        return this.checkValidity(lllllllllllllIlIlIlIllllIIIllIll, this.itemMappings.get(lllllllllllllIlIlIlIllllIIIllIll), "item");
    }
    
    @Override
    public Mappings getBlockMappings() {
        return this.blockMappings;
    }
    
    @Override
    public Mappings getStatisticsMappings() {
        return this.statisticsMappings;
    }
    
    protected JsonObject loadDiffFile() {
        return MappingDataLoader.loadData(String.valueOf(new StringBuilder().append("mappingdiff-").append(this.oldVersion).append("to").append(this.newVersion).append(".json")));
    }
    
    public MappingDataBase(final String lllllllllllllIlIlIlIlllllIlIIlII, final String lllllllllllllIlIlIlIlllllIlIIIll, final boolean lllllllllllllIlIlIlIlllllIlIIllI) {
        this.loadItems = true;
        this.oldVersion = lllllllllllllIlIlIlIlllllIlIIlII;
        this.newVersion = lllllllllllllIlIlIlIlllllIlIIIll;
        this.hasDiffFile = lllllllllllllIlIlIlIlllllIlIIllI;
    }
    
    @Override
    public int getNewBlockId(final int lllllllllllllIlIlIlIllllIIlIlIIl) {
        return this.checkValidity(lllllllllllllIlIlIlIllllIIlIlIIl, this.blockMappings.getNewId(lllllllllllllIlIlIlIllllIIlIlIIl), "block");
    }
    
    protected void loadExtras(final JsonObject lllllllllllllIlIlIlIlllIlIIlIlII, final JsonObject lllllllllllllIlIlIlIlllIlIIlIIll, final JsonObject lllllllllllllIlIlIlIlllIlIIlIIlI) {
    }
    
    private void loadTags(final RegistryType lllllllllllllIlIlIlIllllIlIIlIll, final JsonObject lllllllllllllIlIlIlIllllIlIlIIIl, final Object2IntMap<String> lllllllllllllIlIlIlIllllIlIIlIIl) {
        final JsonObject lllllllllllllIlIlIlIllllIlIIllll = lllllllllllllIlIlIlIllllIlIlIIIl.getAsJsonObject(lllllllllllllIlIlIlIllllIlIIlIll.getResourceLocation());
        final List<TagData> lllllllllllllIlIlIlIllllIlIIlllI = new ArrayList<TagData>(lllllllllllllIlIlIlIllllIlIIllll.size());
        for (final Map.Entry<String, JsonElement> lllllllllllllIlIlIlIllllIlIlIlII : lllllllllllllIlIlIlIllllIlIIllll.entrySet()) {
            final JsonArray lllllllllllllIlIlIlIllllIlIllIII = lllllllllllllIlIlIlIllllIlIlIlII.getValue().getAsJsonArray();
            final int[] lllllllllllllIlIlIlIllllIlIlIllI = new int[lllllllllllllIlIlIlIllllIlIllIII.size()];
            int lllllllllllllIlIlIlIllllIlIlIlIl = 0;
            for (final JsonElement lllllllllllllIlIlIlIllllIlIllIlI : lllllllllllllIlIlIlIllllIlIllIII) {
                String lllllllllllllIlIlIlIllllIlIlllII = lllllllllllllIlIlIlIllllIlIllIlI.getAsString();
                if (!lllllllllllllIlIlIlIllllIlIIlIIl.containsKey(lllllllllllllIlIlIlIllllIlIlllII) && !lllllllllllllIlIlIlIllllIlIIlIIl.containsKey(lllllllllllllIlIlIlIllllIlIlllII = lllllllllllllIlIlIlIllllIlIlllII.replace("minecraft:", ""))) {
                    this.getLogger().warning(String.valueOf(new StringBuilder().append(lllllllllllllIlIlIlIllllIlIIlIll).append(" Tags contains invalid type identifier ").append(lllllllllllllIlIlIlIllllIlIlllII).append(" in tag ").append(lllllllllllllIlIlIlIllllIlIlIlII.getKey())));
                }
                else {
                    lllllllllllllIlIlIlIllllIlIlIllI[lllllllllllllIlIlIlIllllIlIlIlIl++] = lllllllllllllIlIlIlIllllIlIIlIIl.getInt(lllllllllllllIlIlIlIllllIlIlllII);
                }
            }
            lllllllllllllIlIlIlIllllIlIIlllI.add(new TagData(lllllllllllllIlIlIlIllllIlIlIlII.getKey(), lllllllllllllIlIlIlIllllIlIlIllI));
        }
        this.tags.put(lllllllllllllIlIlIlIllllIlIIlIll, lllllllllllllIlIlIlIllllIlIIlllI);
    }
}
