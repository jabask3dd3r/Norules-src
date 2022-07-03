package com.viaversion.viaversion.protocols.protocol1_9to1_8.sounds;

public enum SoundCategory
{
    HOSTILE("hostile", 5), 
    MUSIC("music", 1), 
    RECORD("record", 2);
    
    private final /* synthetic */ int id;
    private final /* synthetic */ String name;
    
    VOICE("voice", 9), 
    WEATHER("weather", 3), 
    MASTER("master", 0), 
    BLOCK("block", 4), 
    PLAYER("player", 7), 
    AMBIENT("ambient", 8), 
    NEUTRAL("neutral", 6);
    
    private SoundCategory(final String lllllllllllllIlIllIlllIlIllIllIl, final int lllllllllllllIlIllIlllIlIllIllII) {
        this.name = lllllllllllllIlIllIlllIlIllIllIl;
        this.id = lllllllllllllIlIllIlllIlIllIllII;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
}
