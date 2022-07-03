package net.minecraft.realms;

import net.minecraft.world.storage.*;

public class RealmsLevelSummary implements Comparable<RealmsLevelSummary>
{
    private final /* synthetic */ WorldSummary levelSummary;
    
    public boolean isRequiresConversion() {
        return this.levelSummary.requiresConversion();
    }
    
    public boolean hasCheats() {
        return this.levelSummary.getCheatsEnabled();
    }
    
    public int getGameMode() {
        return this.levelSummary.getEnumGameType().getID();
    }
    
    public boolean isHardcore() {
        return this.levelSummary.isHardcoreModeEnabled();
    }
    
    public int compareTo(final WorldSummary lllllllllllllIIIIIIIlIllIIlIIllI) {
        return this.levelSummary.compareTo(lllllllllllllIIIIIIIlIllIIlIIllI);
    }
    
    public String getLevelId() {
        return this.levelSummary.getFileName();
    }
    
    public String getLevelName() {
        return this.levelSummary.getDisplayName();
    }
    
    @Override
    public int compareTo(final RealmsLevelSummary lllllllllllllIIIIIIIlIllIIIlllIl) {
        if (this.levelSummary.getLastTimePlayed() < lllllllllllllIIIIIIIlIllIIIlllIl.getLastPlayed()) {
            return 1;
        }
        return (this.levelSummary.getLastTimePlayed() > lllllllllllllIIIIIIIlIllIIIlllIl.getLastPlayed()) ? -1 : this.levelSummary.getFileName().compareTo(lllllllllllllIIIIIIIlIllIIIlllIl.getLevelId());
    }
    
    public long getSizeOnDisk() {
        return this.levelSummary.getSizeOnDisk();
    }
    
    public RealmsLevelSummary(final WorldSummary lllllllllllllIIIIIIIlIllIlIIIIll) {
        this.levelSummary = lllllllllllllIIIIIIIlIllIlIIIIll;
    }
    
    public long getLastPlayed() {
        return this.levelSummary.getLastTimePlayed();
    }
}
