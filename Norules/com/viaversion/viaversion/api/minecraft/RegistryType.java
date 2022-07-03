package com.viaversion.viaversion.api.minecraft;

import java.util.*;

public enum RegistryType
{
    ITEM("item"), 
    ENTITY("entity_type"), 
    GAME_EVENT("game_event");
    
    private static final /* synthetic */ Map<String, RegistryType> MAP;
    private final /* synthetic */ String resourceLocation;
    
    FLUID("fluid");
    
    private static final /* synthetic */ RegistryType[] VALUES;
    
    BLOCK("block");
    
    private RegistryType(final String lllllllllllllIlllIlllIIllIIIIIIl) {
        this.resourceLocation = lllllllllllllIlllIlllIIllIIIIIIl;
    }
    
    static {
        MAP = new HashMap<String, RegistryType>();
        VALUES = values();
        final int lllllllllllllIlllIlllIIlIllllIII = (Object)getValues();
        final Exception lllllllllllllIlllIlllIIlIlllIlll = (Exception)lllllllllllllIlllIlllIIlIllllIII.length;
        for (short lllllllllllllIlllIlllIIlIlllIllI = 0; lllllllllllllIlllIlllIIlIlllIllI < lllllllllllllIlllIlllIIlIlllIlll; ++lllllllllllllIlllIlllIIlIlllIllI) {
            final RegistryType lllllllllllllIlllIlllIIlIllllIIl = lllllllllllllIlllIlllIIlIllllIII[lllllllllllllIlllIlllIIlIlllIllI];
            RegistryType.MAP.put(lllllllllllllIlllIlllIIlIllllIIl.resourceLocation, lllllllllllllIlllIlllIIlIllllIIl);
        }
    }
    
    public static RegistryType getByKey(final String lllllllllllllIlllIlllIIllIIIlIll) {
        return RegistryType.MAP.get(lllllllllllllIlllIlllIIllIIIlIll);
    }
    
    public String getResourceLocation() {
        return this.resourceLocation;
    }
    
    public static RegistryType[] getValues() {
        return RegistryType.VALUES;
    }
}
