package net.minecraft.world;

import net.minecraft.world.storage.*;

public final class WorldSettings
{
    private final /* synthetic */ long seed;
    private /* synthetic */ String generatorOptions;
    private final /* synthetic */ boolean hardcoreEnabled;
    private final /* synthetic */ boolean mapFeaturesEnabled;
    private /* synthetic */ boolean bonusChestEnabled;
    private final /* synthetic */ WorldType terrainType;
    private final /* synthetic */ GameType theGameType;
    private /* synthetic */ boolean commandsAllowed;
    
    public long getSeed() {
        return this.seed;
    }
    
    public WorldType getTerrainType() {
        return this.terrainType;
    }
    
    public GameType getGameType() {
        return this.theGameType;
    }
    
    public static GameType getGameTypeById(final int lllllllllllllIllIIIlIlIIlllllIII) {
        return GameType.getByID(lllllllllllllIllIIIlIlIIlllllIII);
    }
    
    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }
    
    public boolean getHardcoreEnabled() {
        return this.hardcoreEnabled;
    }
    
    public WorldSettings(final WorldInfo lllllllllllllIllIIIlIlIlIIIllllI) {
        this(lllllllllllllIllIIIlIlIlIIIllllI.getSeed(), lllllllllllllIllIIIlIlIlIIIllllI.getGameType(), lllllllllllllIllIIIlIlIlIIIllllI.isMapFeaturesEnabled(), lllllllllllllIllIIIlIlIlIIIllllI.isHardcoreModeEnabled(), lllllllllllllIllIIIlIlIlIIIllllI.getTerrainType());
    }
    
    public WorldSettings setGeneratorOptions(final String lllllllllllllIllIIIlIlIlIIIlIIII) {
        this.generatorOptions = lllllllllllllIllIIIlIlIlIIIlIIII;
        return this;
    }
    
    public String getGeneratorOptions() {
        return this.generatorOptions;
    }
    
    public WorldSettings(final long lllllllllllllIllIIIlIlIlIIlIllII, final GameType lllllllllllllIllIIIlIlIlIIlIIlIl, final boolean lllllllllllllIllIIIlIlIlIIlIlIlI, final boolean lllllllllllllIllIIIlIlIlIIlIIIll, final WorldType lllllllllllllIllIIIlIlIlIIlIlIII) {
        this.generatorOptions = "";
        this.seed = lllllllllllllIllIIIlIlIlIIlIllII;
        this.theGameType = lllllllllllllIllIIIlIlIlIIlIIlIl;
        this.mapFeaturesEnabled = lllllllllllllIllIIIlIlIlIIlIlIlI;
        this.hardcoreEnabled = lllllllllllllIllIIIlIlIlIIlIIIll;
        this.terrainType = lllllllllllllIllIIIlIlIlIIlIlIII;
    }
    
    public WorldSettings enableCommands() {
        this.commandsAllowed = true;
        return this;
    }
    
    public boolean isBonusChestEnabled() {
        return this.bonusChestEnabled;
    }
    
    public boolean areCommandsAllowed() {
        return this.commandsAllowed;
    }
    
    public WorldSettings enableBonusChest() {
        this.bonusChestEnabled = true;
        return this;
    }
}
