package com.viaversion.viabackwards.api.data;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import java.util.logging.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viabackwards.api.*;
import com.google.common.base.*;
import com.viaversion.viaversion.api.*;

public class BackwardsMappings extends MappingDataBase
{
    private final /* synthetic */ Class<? extends Protocol> vvProtocolClass;
    private /* synthetic */ Int2ObjectMap<MappedItem> backwardsItemMappings;
    private /* synthetic */ Map<String, String> backwardsSoundMappings;
    
    public String getMappedNamedSound(String lllllllllllllIIllIllIllIIllIIIIl) {
        if (this.backwardsItemMappings == null) {
            return null;
        }
        if (((String)lllllllllllllIIllIllIllIIllIIIIl).indexOf(58) == -1) {
            lllllllllllllIIllIllIllIIllIIIIl = String.valueOf(new StringBuilder().append("minecraft:").append((String)lllllllllllllIIllIllIllIIllIIIIl));
        }
        return this.backwardsSoundMappings.get(lllllllllllllIIllIllIllIIllIIIIl);
    }
    
    @Override
    protected Logger getLogger() {
        return ViaBackwards.getPlatform().getLogger();
    }
    
    @Override
    protected Mappings loadFromArray(final JsonObject lllllllllllllIIllIllIllIlIlIIIII, final JsonObject lllllllllllllIIllIllIllIlIlIIlIl, final JsonObject lllllllllllllIIllIllIllIlIIllllI, final String lllllllllllllIIllIllIllIlIlIIIll) {
        if (!lllllllllllllIIllIllIllIlIlIIIII.has(lllllllllllllIIllIllIllIlIlIIIll) || !lllllllllllllIIllIllIllIlIlIIlIl.has(lllllllllllllIIllIllIllIlIlIIIll)) {
            return null;
        }
        final JsonObject lllllllllllllIIllIllIllIlIlIIIlI = (lllllllllllllIIllIllIllIlIIllllI != null) ? lllllllllllllIIllIllIllIlIIllllI.getAsJsonObject(lllllllllllllIIllIllIllIlIlIIIll) : null;
        return new VBMappings(lllllllllllllIIllIllIllIlIlIIIII.getAsJsonArray(lllllllllllllIIllIllIllIlIlIIIll), lllllllllllllIIllIllIllIlIlIIlIl.getAsJsonArray(lllllllllllllIIllIllIllIlIlIIIll), lllllllllllllIIllIllIllIlIlIIIlI, this.shouldWarnOnMissing(lllllllllllllIIllIllIllIlIlIIIll));
    }
    
    @Override
    public int getNewBlockId(final int lllllllllllllIIllIllIllIIlllIIll) {
        return this.blockMappings.getNewId(lllllllllllllIIllIllIllIIlllIIll);
    }
    
    public Map<String, String> getBackwardsSoundMappings() {
        return this.backwardsSoundMappings;
    }
    
    @Override
    protected JsonObject loadDiffFile() {
        return VBMappingDataLoader.loadFromDataDir(String.valueOf(new StringBuilder().append("mapping-").append(this.newVersion).append("to").append(this.oldVersion).append(".json")));
    }
    
    @Override
    public int getNewItemId(final int lllllllllllllIIllIllIllIIllllIll) {
        return this.itemMappings.get(lllllllllllllIIllIllIllIIllllIll);
    }
    
    protected boolean shouldWarnOnMissing(final String lllllllllllllIIllIllIllIlIIIIIII) {
        return !lllllllllllllIIllIllIllIlIIIIIII.equals("blocks") && !lllllllllllllIIllIllIllIlIIIIIII.equals("statistics");
    }
    
    public Int2ObjectMap<MappedItem> getBackwardsItemMappings() {
        return this.backwardsItemMappings;
    }
    
    public MappedItem getMappedItem(final int lllllllllllllIIllIllIllIIllIIlll) {
        return (this.backwardsItemMappings != null) ? this.backwardsItemMappings.get(lllllllllllllIIllIllIllIIllIIlll) : null;
    }
    
    public BackwardsMappings(final String lllllllllllllIIllIllIllIllIIlIII, final String lllllllllllllIIllIllIllIllIIIlll, final Class<? extends Protocol> lllllllllllllIIllIllIllIllIIIIIl, final boolean lllllllllllllIIllIllIllIllIIIIII) {
        super(lllllllllllllIIllIllIllIllIIlIII, lllllllllllllIIllIllIllIllIIIlll, lllllllllllllIIllIllIllIllIIIIII);
        Preconditions.checkArgument(lllllllllllllIIllIllIllIllIIIIIl == null || !lllllllllllllIIllIllIllIllIIIIIl.isAssignableFrom(BackwardsProtocol.class));
        this.vvProtocolClass = lllllllllllllIIllIllIllIllIIIIIl;
        this.loadItems = false;
    }
    
    public BackwardsMappings(final String lllllllllllllIIllIllIllIllIlIIIl, final String lllllllllllllIIllIllIllIllIlIlII, final Class<? extends Protocol> lllllllllllllIIllIllIllIllIIllll) {
        this(lllllllllllllIIllIllIllIllIlIIIl, lllllllllllllIIllIllIllIllIlIlII, lllllllllllllIIllIllIllIllIIllll, false);
    }
    
    @Override
    public int getOldItemId(final int lllllllllllllIIllIllIllIIllIllll) {
        return this.checkValidity(lllllllllllllIIllIllIllIIllIllll, this.itemMappings.inverse().get(lllllllllllllIIllIllIllIIllIllll), "item");
    }
    
    @Override
    protected Mappings loadFromObject(final JsonObject lllllllllllllIIllIllIllIlIIlIlII, final JsonObject lllllllllllllIIllIllIllIlIIIllIl, final JsonObject lllllllllllllIIllIllIllIlIIIllII, final String lllllllllllllIIllIllIllIlIIIlIll) {
        if (!lllllllllllllIIllIllIllIlIIlIlII.has(lllllllllllllIIllIllIllIlIIIlIll) || !lllllllllllllIIllIllIllIlIIIllIl.has(lllllllllllllIIllIllIllIlIIIlIll)) {
            return null;
        }
        final JsonObject lllllllllllllIIllIllIllIlIIlIIII = (lllllllllllllIIllIllIllIlIIIllII != null) ? lllllllllllllIIllIllIllIlIIIllII.getAsJsonObject(lllllllllllllIIllIllIllIlIIIlIll) : null;
        return new VBMappings(lllllllllllllIIllIllIllIlIIlIlII.getAsJsonObject(lllllllllllllIIllIllIllIlIIIlIll), lllllllllllllIIllIllIllIlIIIllIl.getAsJsonObject(lllllllllllllIIllIllIllIlIIIlIll), lllllllllllllIIllIllIllIlIIlIIII, this.shouldWarnOnMissing(lllllllllllllIIllIllIllIlIIIlIll));
    }
    
    @Override
    protected void loadExtras(final JsonObject lllllllllllllIIllIllIllIlIllIllI, final JsonObject lllllllllllllIIllIllIllIlIllIlIl, final JsonObject lllllllllllllIIllIllIllIlIllIlII) {
        if (lllllllllllllIIllIllIllIlIllIlII != null) {
            final JsonObject lllllllllllllIIllIllIllIlIlllIIl = lllllllllllllIIllIllIllIlIllIlII.getAsJsonObject("items");
            if (lllllllllllllIIllIllIllIlIlllIIl != null) {
                this.backwardsItemMappings = VBMappingDataLoader.loadItemMappings(lllllllllllllIIllIllIllIlIllIllI.getAsJsonObject("items"), lllllllllllllIIllIllIllIlIllIlIl.getAsJsonObject("items"), lllllllllllllIIllIllIllIlIlllIIl, this.shouldWarnOnMissing("items"));
            }
            final JsonObject lllllllllllllIIllIllIllIlIlllIII = lllllllllllllIIllIllIllIlIllIlII.getAsJsonObject("sounds");
            if (lllllllllllllIIllIllIllIlIlllIII != null) {
                this.backwardsSoundMappings = VBMappingDataLoader.objectToMap(lllllllllllllIIllIllIllIlIlllIII);
            }
        }
        if (this.vvProtocolClass != null) {
            this.itemMappings = ((Protocol)Via.getManager().getProtocolManager().getProtocol(this.vvProtocolClass)).getMappingData().getItemMappings().inverse();
        }
        this.loadVBExtras(lllllllllllllIIllIllIllIlIllIllI, lllllllllllllIIllIllIllIlIllIlIl);
    }
    
    protected void loadVBExtras(final JsonObject lllllllllllllIIllIllIllIlIIIIlIl, final JsonObject lllllllllllllIIllIllIllIlIIIIlII) {
    }
}
