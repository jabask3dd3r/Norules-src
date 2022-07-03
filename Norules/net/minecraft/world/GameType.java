package net.minecraft.world;

import net.minecraft.entity.player.*;

public enum GameType
{
    NOT_SET("NOT_SET", 0, -1, "", ""), 
    SPECTATOR("SPECTATOR", 4, 3, "spectator", "sp");
    
    /* synthetic */ String shortName;
    
    CREATIVE("CREATIVE", 2, 1, "creative", "c");
    
    /* synthetic */ String name;
    
    SURVIVAL("SURVIVAL", 1, 0, "survival", "s"), 
    ADVENTURE("ADVENTURE", 3, 2, "adventure", "a");
    
    /* synthetic */ int id;
    
    public static GameType parseGameTypeWithDefault(final String llllllllllllllIllIIlIllIIllllIll, final GameType llllllllllllllIllIIlIllIIlllllIl) {
        final Exception llllllllllllllIllIIlIllIIlllIllI;
        final int llllllllllllllIllIIlIllIIlllIlll = ((GameType[])(Object)(llllllllllllllIllIIlIllIIlllIllI = (Exception)(Object)values())).length;
        for (char llllllllllllllIllIIlIllIIllllIII = '\0'; llllllllllllllIllIIlIllIIllllIII < llllllllllllllIllIIlIllIIlllIlll; ++llllllllllllllIllIIlIllIIllllIII) {
            final GameType llllllllllllllIllIIlIllIIlllllII = llllllllllllllIllIIlIllIIlllIllI[llllllllllllllIllIIlIllIIllllIII];
            if (llllllllllllllIllIIlIllIIlllllII.name.equals(llllllllllllllIllIIlIllIIllllIll) || llllllllllllllIllIIlIllIIlllllII.shortName.equals(llllllllllllllIllIIlIllIIllllIll)) {
                return llllllllllllllIllIIlIllIIlllllII;
            }
        }
        return llllllllllllllIllIIlIllIIlllllIl;
    }
    
    public boolean isCreative() {
        return this == GameType.CREATIVE;
    }
    
    public int getID() {
        return this.id;
    }
    
    private GameType(final String llllllllllllllIllIIlIllIlIlllIlI, final int llllllllllllllIllIIlIllIlIlllIIl, final int llllllllllllllIllIIlIllIlIlllllI, final String llllllllllllllIllIIlIllIlIllIlll, final String llllllllllllllIllIIlIllIlIllllII) {
        this.id = llllllllllllllIllIIlIllIlIlllllI;
        this.name = llllllllllllllIllIIlIllIlIllIlll;
        this.shortName = llllllllllllllIllIIlIllIlIllllII;
    }
    
    public static GameType parseGameTypeWithDefault(final int llllllllllllllIllIIlIllIlIIIllIl, final GameType llllllllllllllIllIIlIllIlIIIllII) {
        final byte llllllllllllllIllIIlIllIlIIIlIII;
        final int llllllllllllllIllIIlIllIlIIIlIIl = ((GameType[])(Object)(llllllllllllllIllIIlIllIlIIIlIII = (byte)(Object)values())).length;
        for (boolean llllllllllllllIllIIlIllIlIIIlIlI = false; (llllllllllllllIllIIlIllIlIIIlIlI ? 1 : 0) < llllllllllllllIllIIlIllIlIIIlIIl; ++llllllllllllllIllIIlIllIlIIIlIlI) {
            final GameType llllllllllllllIllIIlIllIlIIIlllI = llllllllllllllIllIIlIllIlIIIlIII[llllllllllllllIllIIlIllIlIIIlIlI];
            if (llllllllllllllIllIIlIllIlIIIlllI.id == llllllllllllllIllIIlIllIlIIIllIl) {
                return llllllllllllllIllIIlIllIlIIIlllI;
            }
        }
        return llllllllllllllIllIIlIllIlIIIllII;
    }
    
    public boolean isSurvivalOrAdventure() {
        return this == GameType.SURVIVAL || this == GameType.ADVENTURE;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isAdventure() {
        return this == GameType.ADVENTURE || this == GameType.SPECTATOR;
    }
    
    public static GameType getByName(final String llllllllllllllIllIIlIllIlIIIIllI) {
        return parseGameTypeWithDefault(llllllllllllllIllIIlIllIlIIIIllI, GameType.SURVIVAL);
    }
    
    public void configurePlayerCapabilities(final PlayerCapabilities llllllllllllllIllIIlIllIlIlIIIll) {
        if (this == GameType.CREATIVE) {
            llllllllllllllIllIIlIllIlIlIIIll.allowFlying = true;
            llllllllllllllIllIIlIllIlIlIIIll.isCreativeMode = true;
            llllllllllllllIllIIlIllIlIlIIIll.disableDamage = true;
        }
        else if (this == GameType.SPECTATOR) {
            llllllllllllllIllIIlIllIlIlIIIll.allowFlying = true;
            llllllllllllllIllIIlIllIlIlIIIll.isCreativeMode = false;
            llllllllllllllIllIIlIllIlIlIIIll.disableDamage = true;
            llllllllllllllIllIIlIllIlIlIIIll.isFlying = true;
        }
        else {
            llllllllllllllIllIIlIllIlIlIIIll.allowFlying = false;
            llllllllllllllIllIIlIllIlIlIIIll.isCreativeMode = false;
            llllllllllllllIllIIlIllIlIlIIIll.disableDamage = false;
            llllllllllllllIllIIlIllIlIlIIIll.isFlying = false;
        }
        llllllllllllllIllIIlIllIlIlIIIll.allowEdit = !this.isAdventure();
    }
    
    public static GameType getByID(final int llllllllllllllIllIIlIllIlIIlIlll) {
        return parseGameTypeWithDefault(llllllllllllllIllIIlIllIlIIlIlll, GameType.SURVIVAL);
    }
}
