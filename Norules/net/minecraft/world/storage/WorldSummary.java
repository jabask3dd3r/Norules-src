package net.minecraft.world.storage;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.util.text.translation.*;

public class WorldSummary implements Comparable<WorldSummary>
{
    private final /* synthetic */ boolean cheatsEnabled;
    private final /* synthetic */ long sizeOnDisk;
    private final /* synthetic */ boolean hardcore;
    private final /* synthetic */ int versionId;
    private final /* synthetic */ GameType theEnumGameType;
    private final /* synthetic */ boolean versionSnapshot;
    private final /* synthetic */ boolean requiresConversion;
    private final /* synthetic */ String fileName;
    private final /* synthetic */ long lastTimePlayed;
    private final /* synthetic */ String versionName;
    private final /* synthetic */ String displayName;
    
    public boolean getCheatsEnabled() {
        return this.cheatsEnabled;
    }
    
    public long getLastTimePlayed() {
        return this.lastTimePlayed;
    }
    
    @Override
    public int compareTo(final WorldSummary lIIIIlllIIllIl) {
        if (this.lastTimePlayed < lIIIIlllIIllIl.lastTimePlayed) {
            return 1;
        }
        return (this.lastTimePlayed > lIIIIlllIIllIl.lastTimePlayed) ? -1 : this.fileName.compareTo(lIIIIlllIIllIl.fileName);
    }
    
    public boolean askToOpenWorld() {
        return this.versionId > 1343;
    }
    
    public boolean isHardcoreModeEnabled() {
        return this.hardcore;
    }
    
    public GameType getEnumGameType() {
        return this.theEnumGameType;
    }
    
    public long getSizeOnDisk() {
        return this.sizeOnDisk;
    }
    
    public boolean requiresConversion() {
        return this.requiresConversion;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public boolean markVersionInList() {
        return this.askToOpenWorld();
    }
    
    public String getVersionName() {
        return StringUtils.isNullOrEmpty(this.versionName) ? I18n.translateToLocal("selectWorld.versionUnknown") : this.versionName;
    }
    
    public WorldSummary(final WorldInfo lIIIIllllIlIlI, final String lIIIIllllIlIIl, final String lIIIIllllIlIII, final long lIIIIllllIIIIl, final boolean lIIIIllllIIIII) {
        this.fileName = lIIIIllllIlIIl;
        this.displayName = lIIIIllllIlIII;
        this.lastTimePlayed = lIIIIllllIlIlI.getLastTimePlayed();
        this.sizeOnDisk = lIIIIllllIIIIl;
        this.theEnumGameType = lIIIIllllIlIlI.getGameType();
        this.requiresConversion = lIIIIllllIIIII;
        this.hardcore = lIIIIllllIlIlI.isHardcoreModeEnabled();
        this.cheatsEnabled = lIIIIllllIlIlI.areCommandsAllowed();
        this.versionName = lIIIIllllIlIlI.getVersionName();
        this.versionId = lIIIIllllIlIlI.getVersionId();
        this.versionSnapshot = lIIIIllllIlIlI.isVersionSnapshot();
    }
}
