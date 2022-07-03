package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import java.util.*;

public enum SoundSource
{
    MASTER("master", 0);
    
    private final /* synthetic */ int id;
    
    WEATHER("weather", 3), 
    PLAYER("player", 7), 
    NEUTRAL("neutral", 6), 
    VOICE("voice", 9), 
    BLOCK("block", 4), 
    RECORD("record", 2);
    
    private final /* synthetic */ String name;
    
    AMBIENT("ambient", 8), 
    HOSTILE("hostile", 5), 
    MUSIC("music", 1);
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static Optional<SoundSource> findBySource(final String llIlIlIllllIlll) {
        final byte llIlIlIllllIllI = (Object)values();
        final byte llIlIlIllllIlIl = (byte)llIlIlIllllIllI.length;
        for (short llIlIlIllllIlII = 0; llIlIlIllllIlII < llIlIlIllllIlIl; ++llIlIlIllllIlII) {
            final SoundSource llIlIlIlllllIIl = llIlIlIllllIllI[llIlIlIllllIlII];
            if (llIlIlIlllllIIl.name.equalsIgnoreCase(llIlIlIllllIlll)) {
                return Optional.of(llIlIlIlllllIIl);
            }
        }
        return Optional.empty();
    }
    
    private SoundSource(final String llIlIllIIIIIlIl, final int llIlIlIllllllll) {
        this.name = llIlIllIIIIIlIl;
        this.id = llIlIlIllllllll;
    }
}
