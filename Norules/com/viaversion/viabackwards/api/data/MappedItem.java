package com.viaversion.viabackwards.api.data;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;

public class MappedItem
{
    private final /* synthetic */ int id;
    private final /* synthetic */ String jsonName;
    
    public MappedItem(final int lIIIlllIIllIll, final String lIIIlllIIllIlI) {
        this.id = lIIIlllIIllIll;
        this.jsonName = ChatRewriter.legacyTextToJsonString(String.valueOf(new StringBuilder().append("§f").append(lIIIlllIIllIlI)));
    }
    
    public String getJsonName() {
        return this.jsonName;
    }
    
    public int getId() {
        return this.id;
    }
}
