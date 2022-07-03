package com.viaversion.viaversion.protocols.protocol1_9to1_8.chat;

public enum GameMode
{
    private final /* synthetic */ int id;
    
    SPECTATOR(3, "Spectator Mode"), 
    CREATIVE(1, "Creative Mode");
    
    private final /* synthetic */ String text;
    
    ADVENTURE(2, "Adventure Mode"), 
    SURVIVAL(0, "Survival Mode");
    
    public int getId() {
        return this.id;
    }
    
    public String getText() {
        return this.text;
    }
    
    private GameMode(final int llllllllllllllllIllIlIIIllIlIlIl, final String llllllllllllllllIllIlIIIllIIllll) {
        this.id = llllllllllllllllIllIlIIIllIlIlIl;
        this.text = llllllllllllllllIllIlIIIllIIllll;
    }
    
    public static GameMode getById(final int llllllllllllllllIllIlIIIllIIIIIl) {
        final char llllllllllllllllIllIlIIIllIIIIII = (Object)values();
        final float llllllllllllllllIllIlIIIlIllllll = llllllllllllllllIllIlIIIllIIIIII.length;
        for (char llllllllllllllllIllIlIIIlIlllllI = '\0'; llllllllllllllllIllIlIIIlIlllllI < llllllllllllllllIllIlIIIlIllllll; ++llllllllllllllllIllIlIIIlIlllllI) {
            final GameMode llllllllllllllllIllIlIIIllIIIIll = llllllllllllllllIllIlIIIllIIIIII[llllllllllllllllIllIlIIIlIlllllI];
            if (llllllllllllllllIllIlIIIllIIIIll.getId() == llllllllllllllllIllIlIIIllIIIIIl) {
                return llllllllllllllllIllIlIIIllIIIIll;
            }
        }
        return null;
    }
}
