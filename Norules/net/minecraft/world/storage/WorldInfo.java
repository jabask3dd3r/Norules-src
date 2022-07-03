package net.minecraft.world.storage;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.crash.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.server.*;

public class WorldInfo
{
    private /* synthetic */ boolean initialized;
    private /* synthetic */ double borderCenterZ;
    private /* synthetic */ int borderWarningTime;
    private /* synthetic */ NBTTagCompound playerTag;
    private /* synthetic */ int borderWarningDistance;
    private /* synthetic */ int dimension;
    private /* synthetic */ int spawnZ;
    private /* synthetic */ String versionName;
    private /* synthetic */ int spawnY;
    private /* synthetic */ String levelName;
    private /* synthetic */ boolean raining;
    private /* synthetic */ String generatorOptions;
    private /* synthetic */ long sizeOnDisk;
    private /* synthetic */ int spawnX;
    private /* synthetic */ double borderSize;
    private /* synthetic */ int rainTime;
    private /* synthetic */ double borderCenterX;
    private /* synthetic */ EnumDifficulty difficulty;
    private final /* synthetic */ Map<DimensionType, NBTTagCompound> dimensionData;
    private /* synthetic */ WorldType terrainType;
    private /* synthetic */ long randomSeed;
    private /* synthetic */ boolean allowCommands;
    private /* synthetic */ int versionId;
    private /* synthetic */ long borderSizeLerpTime;
    private /* synthetic */ boolean mapFeaturesEnabled;
    private /* synthetic */ boolean hardcore;
    private /* synthetic */ boolean thundering;
    private /* synthetic */ int thunderTime;
    private /* synthetic */ boolean difficultyLocked;
    private /* synthetic */ double borderSafeZone;
    private /* synthetic */ long worldTime;
    private /* synthetic */ double borderSizeLerpTarget;
    private /* synthetic */ boolean versionSnapshot;
    public static final /* synthetic */ EnumDifficulty DEFAULT_DIFFICULTY;
    private /* synthetic */ int saveVersion;
    private /* synthetic */ long totalTime;
    private /* synthetic */ int cleanWeatherTime;
    private /* synthetic */ long lastTimePlayed;
    private /* synthetic */ double borderDamagePerBlock;
    private /* synthetic */ GameRules theGameRules;
    private /* synthetic */ GameType theGameType;
    
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.playerTag;
    }
    
    public GameRules getGameRulesInstance() {
        return this.theGameRules;
    }
    
    public void setBorderLerpTime(final long lllllllllllllllIIlIIIlIlllIlIlII) {
        this.borderSizeLerpTime = lllllllllllllllIIlIIIlIlllIlIlII;
    }
    
    public void setCleanWeatherTime(final int lllllllllllllllIIlIIIllIIlllIlII) {
        this.cleanWeatherTime = lllllllllllllllIIlIIIllIIlllIlII;
    }
    
    public void setBorderLerpTarget(final double lllllllllllllllIIlIIIlIlllIIlIll) {
        this.borderSizeLerpTarget = lllllllllllllllIIlIIIlIlllIIlIll;
    }
    
    public GameType getGameType() {
        return this.theGameType;
    }
    
    public void setTerrainType(final WorldType lllllllllllllllIIlIIIllIIIIIIIlI) {
        this.terrainType = lllllllllllllllIIlIIIllIIIIIIIlI;
    }
    
    public long getWorldTime() {
        return this.worldTime;
    }
    
    public long getSizeOnDisk() {
        return this.sizeOnDisk;
    }
    
    public long getWorldTotalTime() {
        return this.totalTime;
    }
    
    public WorldInfo(final WorldInfo lllllllllllllllIIlIIIlllIIIIIIIl) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
        this.randomSeed = lllllllllllllllIIlIIIlllIIIIIIIl.randomSeed;
        this.terrainType = lllllllllllllllIIlIIIlllIIIIIIIl.terrainType;
        this.generatorOptions = lllllllllllllllIIlIIIlllIIIIIIIl.generatorOptions;
        this.theGameType = lllllllllllllllIIlIIIlllIIIIIIIl.theGameType;
        this.mapFeaturesEnabled = lllllllllllllllIIlIIIlllIIIIIIIl.mapFeaturesEnabled;
        this.spawnX = lllllllllllllllIIlIIIlllIIIIIIIl.spawnX;
        this.spawnY = lllllllllllllllIIlIIIlllIIIIIIIl.spawnY;
        this.spawnZ = lllllllllllllllIIlIIIlllIIIIIIIl.spawnZ;
        this.totalTime = lllllllllllllllIIlIIIlllIIIIIIIl.totalTime;
        this.worldTime = lllllllllllllllIIlIIIlllIIIIIIIl.worldTime;
        this.lastTimePlayed = lllllllllllllllIIlIIIlllIIIIIIIl.lastTimePlayed;
        this.sizeOnDisk = lllllllllllllllIIlIIIlllIIIIIIIl.sizeOnDisk;
        this.playerTag = lllllllllllllllIIlIIIlllIIIIIIIl.playerTag;
        this.dimension = lllllllllllllllIIlIIIlllIIIIIIIl.dimension;
        this.levelName = lllllllllllllllIIlIIIlllIIIIIIIl.levelName;
        this.saveVersion = lllllllllllllllIIlIIIlllIIIIIIIl.saveVersion;
        this.rainTime = lllllllllllllllIIlIIIlllIIIIIIIl.rainTime;
        this.raining = lllllllllllllllIIlIIIlllIIIIIIIl.raining;
        this.thunderTime = lllllllllllllllIIlIIIlllIIIIIIIl.thunderTime;
        this.thundering = lllllllllllllllIIlIIIlllIIIIIIIl.thundering;
        this.hardcore = lllllllllllllllIIlIIIlllIIIIIIIl.hardcore;
        this.allowCommands = lllllllllllllllIIlIIIlllIIIIIIIl.allowCommands;
        this.initialized = lllllllllllllllIIlIIIlllIIIIIIIl.initialized;
        this.theGameRules = lllllllllllllllIIlIIIlllIIIIIIIl.theGameRules;
        this.difficulty = lllllllllllllllIIlIIIlllIIIIIIIl.difficulty;
        this.difficultyLocked = lllllllllllllllIIlIIIlllIIIIIIIl.difficultyLocked;
        this.borderCenterX = lllllllllllllllIIlIIIlllIIIIIIIl.borderCenterX;
        this.borderCenterZ = lllllllllllllllIIlIIIlllIIIIIIIl.borderCenterZ;
        this.borderSize = lllllllllllllllIIlIIIlllIIIIIIIl.borderSize;
        this.borderSizeLerpTime = lllllllllllllllIIlIIIlllIIIIIIIl.borderSizeLerpTime;
        this.borderSizeLerpTarget = lllllllllllllllIIlIIIlllIIIIIIIl.borderSizeLerpTarget;
        this.borderSafeZone = lllllllllllllllIIlIIIlllIIIIIIIl.borderSafeZone;
        this.borderDamagePerBlock = lllllllllllllllIIlIIIlllIIIIIIIl.borderDamagePerBlock;
        this.borderWarningTime = lllllllllllllllIIlIIIlllIIIIIIIl.borderWarningTime;
        this.borderWarningDistance = lllllllllllllllIIlIIIlllIIIIIIIl.borderWarningDistance;
    }
    
    public void getBorderCenterX(final double lllllllllllllllIIlIIIlIllIllllll) {
        this.borderCenterX = lllllllllllllllIIlIIIlIllIllllll;
    }
    
    public String getWorldName() {
        return this.levelName;
    }
    
    public int getSpawnZ() {
        return this.spawnZ;
    }
    
    public void setBorderWarningTime(final int lllllllllllllllIIlIIIlIllIIllIIl) {
        this.borderWarningTime = lllllllllllllllIIlIIIlIllIIllIIl;
    }
    
    public static void registerFixes(final DataFixer lllllllllllllllIIlIIIlllIIlIlIII) {
        lllllllllllllllIIlIIIlllIIlIlIII.registerWalker(FixTypes.LEVEL, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllllIIIIIlIIIIIlIllIIII, final NBTTagCompound lllllllllllllIIIIIlIIIIIlIllIIlI, final int lllllllllllllIIIIIlIIIIIlIlIlllI) {
                if (lllllllllllllIIIIIlIIIIIlIllIIlI.hasKey("Player", 10)) {
                    lllllllllllllIIIIIlIIIIIlIllIIlI.setTag("Player", lllllllllllllIIIIIlIIIIIlIllIIII.process(FixTypes.PLAYER, lllllllllllllIIIIIlIIIIIlIllIIlI.getCompoundTag("Player"), lllllllllllllIIIIIlIIIIIlIlIlllI));
                }
                return lllllllllllllIIIIIlIIIIIlIllIIlI;
            }
        });
    }
    
    public void setWorldTime(final long lllllllllllllllIIlIIIllIlIlIlIll) {
        this.worldTime = lllllllllllllllIIlIIIllIlIlIlIll;
    }
    
    public void setWorldName(final String lllllllllllllllIIlIIIllIlIIlIlII) {
        this.levelName = lllllllllllllllIIlIIIllIlIIlIlII;
    }
    
    public void setAllowCommands(final boolean lllllllllllllllIIlIIIlIlllllIllI) {
        this.allowCommands = lllllllllllllllIIlIIIlIlllllIllI;
    }
    
    public void addToCrashReport(final CrashReportCategory lllllllllllllllIIlIIIlIllIIIIIIl) {
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level seed", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.valueOf(WorldInfo.this.getSeed());
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level generator", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("ID %02d - %s, ver %d. Features enabled: %b", WorldInfo.this.terrainType.getWorldTypeID(), WorldInfo.this.terrainType.getWorldTypeName(), WorldInfo.this.terrainType.getGeneratorVersion(), WorldInfo.this.mapFeaturesEnabled);
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level generator options", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return WorldInfo.this.generatorOptions;
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level spawn location", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return CrashReportCategory.getCoordinateInfo(WorldInfo.this.spawnX, WorldInfo.this.spawnY, WorldInfo.this.spawnZ);
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level time", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("%d game time, %d day time", WorldInfo.this.totalTime, WorldInfo.this.worldTime);
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level dimension", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.valueOf(WorldInfo.this.dimension);
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level storage version", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                String lllllllllllllIlIlIlllIIlIlIllIlI = "Unknown?";
                try {
                    switch (WorldInfo.this.saveVersion) {
                        case 19132: {
                            lllllllllllllIlIlIlllIIlIlIllIlI = "McRegion";
                            break;
                        }
                        case 19133: {
                            lllllllllllllIlIlIlllIIlIlIllIlI = "Anvil";
                            break;
                        }
                    }
                }
                catch (Throwable t) {}
                return String.format("0x%05X - %s", WorldInfo.this.saveVersion, lllllllllllllIlIlIlllIIlIlIllIlI);
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level weather", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", WorldInfo.this.rainTime, WorldInfo.this.raining, WorldInfo.this.thunderTime, WorldInfo.this.thundering);
            }
        });
        lllllllllllllllIIlIIIlIllIIIIIIl.setDetail("Level game mode", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", WorldInfo.this.theGameType.getName(), WorldInfo.this.theGameType.getID(), WorldInfo.this.hardcore, WorldInfo.this.allowCommands);
            }
        });
    }
    
    public int getBorderWarningTime() {
        return this.borderWarningTime;
    }
    
    public void setThundering(final boolean lllllllllllllllIIlIIIllIIllIIllI) {
        this.thundering = lllllllllllllllIIlIIIllIIllIIllI;
    }
    
    public double getBorderDamagePerBlock() {
        return this.borderDamagePerBlock;
    }
    
    public void setDifficultyLocked(final boolean lllllllllllllllIIlIIIlIllIIIlIIl) {
        this.difficultyLocked = lllllllllllllllIIlIIIlIllIIIlIIl;
    }
    
    public int getSaveVersion() {
        return this.saveVersion;
    }
    
    public int getThunderTime() {
        return this.thunderTime;
    }
    
    public void populateFromWorldSettings(final WorldSettings lllllllllllllllIIlIIIlllIIIIlIIl) {
        this.randomSeed = lllllllllllllllIIlIIIlllIIIIlIIl.getSeed();
        this.theGameType = lllllllllllllllIIlIIIlllIIIIlIIl.getGameType();
        this.mapFeaturesEnabled = lllllllllllllllIIlIIIlllIIIIlIIl.isMapFeaturesEnabled();
        this.hardcore = lllllllllllllllIIlIIIlllIIIIlIIl.getHardcoreEnabled();
        this.terrainType = lllllllllllllllIIlIIIlllIIIIlIIl.getTerrainType();
        this.generatorOptions = lllllllllllllllIIlIIIlllIIIIlIIl.getGeneratorOptions();
        this.allowCommands = lllllllllllllllIIlIIIlllIIIIlIIl.areCommandsAllowed();
    }
    
    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }
    
    public void setThunderTime(final int lllllllllllllllIIlIIIllIIlIlIlIl) {
        this.thunderTime = lllllllllllllllIIlIIIllIIlIlIlIl;
    }
    
    public boolean isInitialized() {
        return this.initialized;
    }
    
    static {
        DEFAULT_DIFFICULTY = EnumDifficulty.NORMAL;
    }
    
    public WorldInfo(final WorldSettings lllllllllllllllIIlIIIlllIIIIlllI, final String lllllllllllllllIIlIIIlllIIIIllIl) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
        this.populateFromWorldSettings(lllllllllllllllIIlIIIlllIIIIlllI);
        this.levelName = lllllllllllllllIIlIIIlllIIIIllIl;
        this.difficulty = WorldInfo.DEFAULT_DIFFICULTY;
        this.initialized = false;
    }
    
    public boolean isThundering() {
        return this.thundering;
    }
    
    public void setBorderWarningDistance(final int lllllllllllllllIIlIIIlIllIIlllll) {
        this.borderWarningDistance = lllllllllllllllIIlIIIlIllIIlllll;
    }
    
    public void setRaining(final boolean lllllllllllllllIIlIIIllIIlIIIIIl) {
        this.raining = lllllllllllllllIIlIIIllIIlIIIIIl;
    }
    
    public boolean areCommandsAllowed() {
        return this.allowCommands;
    }
    
    public void setMapFeaturesEnabled(final boolean lllllllllllllllIIlIIIllIIIlIIIII) {
        this.mapFeaturesEnabled = lllllllllllllllIIlIIIllIIIlIIIII;
    }
    
    public void setSpawn(final BlockPos lllllllllllllllIIlIIIllIlIlIIlII) {
        this.spawnX = lllllllllllllllIIlIIIllIlIlIIlII.getX();
        this.spawnY = lllllllllllllllIIlIIIllIlIlIIlII.getY();
        this.spawnZ = lllllllllllllllIIlIIIllIlIlIIlII.getZ();
    }
    
    protected WorldInfo() {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
    }
    
    public WorldType getTerrainType() {
        return this.terrainType;
    }
    
    public void setSpawnX(final int lllllllllllllllIIlIIIllIllIIIllI) {
        this.spawnX = lllllllllllllllIIlIIIllIllIIIllI;
    }
    
    public boolean isVersionSnapshot() {
        return this.versionSnapshot;
    }
    
    public boolean isRaining() {
        return this.raining;
    }
    
    public int getRainTime() {
        return this.rainTime;
    }
    
    public NBTTagCompound cloneNBTCompound(@Nullable NBTTagCompound lllllllllllllllIIlIIIllIlllllIIl) {
        if (lllllllllllllllIIlIIIllIlllllIIl == null) {
            lllllllllllllllIIlIIIllIlllllIIl = this.playerTag;
        }
        final NBTTagCompound lllllllllllllllIIlIIIllIlllllIll = new NBTTagCompound();
        this.updateTagCompound(lllllllllllllllIIlIIIllIlllllIll, lllllllllllllllIIlIIIllIlllllIIl);
        return lllllllllllllllIIlIIIllIlllllIll;
    }
    
    public boolean isDifficultyLocked() {
        return this.difficultyLocked;
    }
    
    public double getBorderCenterZ() {
        return this.borderCenterZ;
    }
    
    public void setDifficulty(final EnumDifficulty lllllllllllllllIIlIIIlIllIIlIIlI) {
        this.difficulty = lllllllllllllllIIlIIIlIllIIlIIlI;
    }
    
    public double getBorderSafeZone() {
        return this.borderSafeZone;
    }
    
    public void setSpawnZ(final int lllllllllllllllIIlIIIllIlIlllIlI) {
        this.spawnZ = lllllllllllllllIIlIIIllIlIlllIlI;
    }
    
    public long getBorderLerpTime() {
        return this.borderSizeLerpTime;
    }
    
    private void updateTagCompound(final NBTTagCompound lllllllllllllllIIlIIIllIlllIllll, final NBTTagCompound lllllllllllllllIIlIIIllIlllIlIII) {
        final NBTTagCompound lllllllllllllllIIlIIIllIlllIllIl = new NBTTagCompound();
        lllllllllllllllIIlIIIllIlllIllIl.setString("Name", "1.12.2");
        lllllllllllllllIIlIIIllIlllIllIl.setInteger("Id", 1343);
        lllllllllllllllIIlIIIllIlllIllIl.setBoolean("Snapshot", false);
        lllllllllllllllIIlIIIllIlllIllll.setTag("Version", lllllllllllllllIIlIIIllIlllIllIl);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("DataVersion", 1343);
        lllllllllllllllIIlIIIllIlllIllll.setLong("RandomSeed", this.randomSeed);
        lllllllllllllllIIlIIIllIlllIllll.setString("generatorName", this.terrainType.getWorldTypeName());
        lllllllllllllllIIlIIIllIlllIllll.setInteger("generatorVersion", this.terrainType.getGeneratorVersion());
        lllllllllllllllIIlIIIllIlllIllll.setString("generatorOptions", this.generatorOptions);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("GameType", this.theGameType.getID());
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("MapFeatures", this.mapFeaturesEnabled);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("SpawnX", this.spawnX);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("SpawnY", this.spawnY);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("SpawnZ", this.spawnZ);
        lllllllllllllllIIlIIIllIlllIllll.setLong("Time", this.totalTime);
        lllllllllllllllIIlIIIllIlllIllll.setLong("DayTime", this.worldTime);
        lllllllllllllllIIlIIIllIlllIllll.setLong("SizeOnDisk", this.sizeOnDisk);
        lllllllllllllllIIlIIIllIlllIllll.setLong("LastPlayed", MinecraftServer.getCurrentTimeMillis());
        lllllllllllllllIIlIIIllIlllIllll.setString("LevelName", this.levelName);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("version", this.saveVersion);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("clearWeatherTime", this.cleanWeatherTime);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("rainTime", this.rainTime);
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("raining", this.raining);
        lllllllllllllllIIlIIIllIlllIllll.setInteger("thunderTime", this.thunderTime);
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("thundering", this.thundering);
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("hardcore", this.hardcore);
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("allowCommands", this.allowCommands);
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("initialized", this.initialized);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderCenterX", this.borderCenterX);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderCenterZ", this.borderCenterZ);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderSize", this.borderSize);
        lllllllllllllllIIlIIIllIlllIllll.setLong("BorderSizeLerpTime", this.borderSizeLerpTime);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderSafeZone", this.borderSafeZone);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderDamagePerBlock", this.borderDamagePerBlock);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderSizeLerpTarget", this.borderSizeLerpTarget);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderWarningBlocks", this.borderWarningDistance);
        lllllllllllllllIIlIIIllIlllIllll.setDouble("BorderWarningTime", this.borderWarningTime);
        if (this.difficulty != null) {
            lllllllllllllllIIlIIIllIlllIllll.setByte("Difficulty", (byte)this.difficulty.getDifficultyId());
        }
        lllllllllllllllIIlIIIllIlllIllll.setBoolean("DifficultyLocked", this.difficultyLocked);
        lllllllllllllllIIlIIIllIlllIllll.setTag("GameRules", this.theGameRules.writeToNBT());
        final NBTTagCompound lllllllllllllllIIlIIIllIlllIllII = new NBTTagCompound();
        for (final Map.Entry<DimensionType, NBTTagCompound> lllllllllllllllIIlIIIllIlllIlIll : this.dimensionData.entrySet()) {
            lllllllllllllllIIlIIIllIlllIllII.setTag(String.valueOf(lllllllllllllllIIlIIIllIlllIlIll.getKey().getId()), lllllllllllllllIIlIIIllIlllIlIll.getValue());
        }
        lllllllllllllllIIlIIIllIlllIllll.setTag("DimensionData", lllllllllllllllIIlIIIllIlllIllII);
        if (lllllllllllllllIIlIIIllIlllIlIII != null) {
            lllllllllllllllIIlIIIllIlllIllll.setTag("Player", lllllllllllllllIIlIIIllIlllIlIII);
        }
    }
    
    public int getCleanWeatherTime() {
        return this.cleanWeatherTime;
    }
    
    public long getLastTimePlayed() {
        return this.lastTimePlayed;
    }
    
    public void setServerInitialized(final boolean lllllllllllllllIIlIIIlIllllIllll) {
        this.initialized = lllllllllllllllIIlIIIlIllllIllll;
    }
    
    public void getBorderCenterZ(final double lllllllllllllllIIlIIIlIlllIIIlIl) {
        this.borderCenterZ = lllllllllllllllIIlIIIlIlllIIIlIl;
    }
    
    public double getBorderCenterX() {
        return this.borderCenterX;
    }
    
    public int getBorderWarningDistance() {
        return this.borderWarningDistance;
    }
    
    public WorldInfo(final NBTTagCompound lllllllllllllllIIlIIIlllIIIllIIl) {
        this.terrainType = WorldType.DEFAULT;
        this.generatorOptions = "";
        this.borderSize = 6.0E7;
        this.borderSafeZone = 5.0;
        this.borderDamagePerBlock = 0.2;
        this.borderWarningDistance = 5;
        this.borderWarningTime = 15;
        this.dimensionData = (Map<DimensionType, NBTTagCompound>)Maps.newEnumMap((Class)DimensionType.class);
        this.theGameRules = new GameRules();
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("Version", 10)) {
            final NBTTagCompound lllllllllllllllIIlIIIlllIIIlllll = lllllllllllllllIIlIIIlllIIIllIIl.getCompoundTag("Version");
            this.versionName = lllllllllllllllIIlIIIlllIIIlllll.getString("Name");
            this.versionId = lllllllllllllllIIlIIIlllIIIlllll.getInteger("Id");
            this.versionSnapshot = lllllllllllllllIIlIIIlllIIIlllll.getBoolean("Snapshot");
        }
        this.randomSeed = lllllllllllllllIIlIIIlllIIIllIIl.getLong("RandomSeed");
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("generatorName", 8)) {
            final String lllllllllllllllIIlIIIlllIIIllllI = lllllllllllllllIIlIIIlllIIIllIIl.getString("generatorName");
            this.terrainType = WorldType.parseWorldType(lllllllllllllllIIlIIIlllIIIllllI);
            if (this.terrainType == null) {
                this.terrainType = WorldType.DEFAULT;
            }
            else if (this.terrainType.isVersioned()) {
                int lllllllllllllllIIlIIIlllIIIlllIl = 0;
                if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("generatorVersion", 99)) {
                    lllllllllllllllIIlIIIlllIIIlllIl = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("generatorVersion");
                }
                this.terrainType = this.terrainType.getWorldTypeForGeneratorVersion(lllllllllllllllIIlIIIlllIIIlllIl);
            }
            if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("generatorOptions", 8)) {
                this.generatorOptions = lllllllllllllllIIlIIIlllIIIllIIl.getString("generatorOptions");
            }
        }
        this.theGameType = GameType.getByID(lllllllllllllllIIlIIIlllIIIllIIl.getInteger("GameType"));
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("MapFeatures", 99)) {
            this.mapFeaturesEnabled = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("MapFeatures");
        }
        else {
            this.mapFeaturesEnabled = true;
        }
        this.spawnX = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("SpawnX");
        this.spawnY = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("SpawnY");
        this.spawnZ = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("SpawnZ");
        this.totalTime = lllllllllllllllIIlIIIlllIIIllIIl.getLong("Time");
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("DayTime", 99)) {
            this.worldTime = lllllllllllllllIIlIIIlllIIIllIIl.getLong("DayTime");
        }
        else {
            this.worldTime = this.totalTime;
        }
        this.lastTimePlayed = lllllllllllllllIIlIIIlllIIIllIIl.getLong("LastPlayed");
        this.sizeOnDisk = lllllllllllllllIIlIIIlllIIIllIIl.getLong("SizeOnDisk");
        this.levelName = lllllllllllllllIIlIIIlllIIIllIIl.getString("LevelName");
        this.saveVersion = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("version");
        this.cleanWeatherTime = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("clearWeatherTime");
        this.rainTime = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("rainTime");
        this.raining = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("raining");
        this.thunderTime = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("thunderTime");
        this.thundering = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("thundering");
        this.hardcore = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("hardcore");
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("initialized", 99)) {
            this.initialized = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("initialized");
        }
        else {
            this.initialized = true;
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("allowCommands", 99)) {
            this.allowCommands = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("allowCommands");
        }
        else {
            this.allowCommands = (this.theGameType == GameType.CREATIVE);
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("Player", 10)) {
            this.playerTag = lllllllllllllllIIlIIIlllIIIllIIl.getCompoundTag("Player");
            this.dimension = this.playerTag.getInteger("Dimension");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("GameRules", 10)) {
            this.theGameRules.readFromNBT(lllllllllllllllIIlIIIlllIIIllIIl.getCompoundTag("GameRules"));
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("Difficulty", 99)) {
            this.difficulty = EnumDifficulty.getDifficultyEnum(lllllllllllllllIIlIIIlllIIIllIIl.getByte("Difficulty"));
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("DifficultyLocked", 1)) {
            this.difficultyLocked = lllllllllllllllIIlIIIlllIIIllIIl.getBoolean("DifficultyLocked");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderCenterX", 99)) {
            this.borderCenterX = lllllllllllllllIIlIIIlllIIIllIIl.getDouble("BorderCenterX");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderCenterZ", 99)) {
            this.borderCenterZ = lllllllllllllllIIlIIIlllIIIllIIl.getDouble("BorderCenterZ");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderSize", 99)) {
            this.borderSize = lllllllllllllllIIlIIIlllIIIllIIl.getDouble("BorderSize");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderSizeLerpTime", 99)) {
            this.borderSizeLerpTime = lllllllllllllllIIlIIIlllIIIllIIl.getLong("BorderSizeLerpTime");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderSizeLerpTarget", 99)) {
            this.borderSizeLerpTarget = lllllllllllllllIIlIIIlllIIIllIIl.getDouble("BorderSizeLerpTarget");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderSafeZone", 99)) {
            this.borderSafeZone = lllllllllllllllIIlIIIlllIIIllIIl.getDouble("BorderSafeZone");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderDamagePerBlock", 99)) {
            this.borderDamagePerBlock = lllllllllllllllIIlIIIlllIIIllIIl.getDouble("BorderDamagePerBlock");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderWarningBlocks", 99)) {
            this.borderWarningDistance = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("BorderWarningBlocks");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("BorderWarningTime", 99)) {
            this.borderWarningTime = lllllllllllllllIIlIIIlllIIIllIIl.getInteger("BorderWarningTime");
        }
        if (lllllllllllllllIIlIIIlllIIIllIIl.hasKey("DimensionData", 10)) {
            final NBTTagCompound lllllllllllllllIIlIIIlllIIIlllII = lllllllllllllllIIlIIIlllIIIllIIl.getCompoundTag("DimensionData");
            for (final String lllllllllllllllIIlIIIlllIIIllIll : lllllllllllllllIIlIIIlllIIIlllII.getKeySet()) {
                this.dimensionData.put(DimensionType.getById(Integer.parseInt(lllllllllllllllIIlIIIlllIIIllIll)), lllllllllllllllIIlIIIlllIIIlllII.getCompoundTag(lllllllllllllllIIlIIIlllIIIllIll));
            }
        }
    }
    
    public void setGameType(final GameType lllllllllllllllIIlIIIllIIIIllIII) {
        this.theGameType = lllllllllllllllIIlIIIllIIIIllIII;
    }
    
    public void setWorldTotalTime(final long lllllllllllllllIIlIIIllIlIllIllI) {
        this.totalTime = lllllllllllllllIIlIIIllIlIllIllI;
    }
    
    public int getSpawnX() {
        return this.spawnX;
    }
    
    public int getSpawnY() {
        return this.spawnY;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public void setRainTime(final int lllllllllllllllIIlIIIllIIIlllIII) {
        this.rainTime = lllllllllllllllIIlIIIllIIIlllIII;
    }
    
    public long getSeed() {
        return this.randomSeed;
    }
    
    public void setHardcore(final boolean lllllllllllllllIIlIIIllIIIIIlIll) {
        this.hardcore = lllllllllllllllIIlIIIllIIIIIlIll;
    }
    
    public int getVersionId() {
        return this.versionId;
    }
    
    public void setBorderSize(final double lllllllllllllllIIlIIIlIlllIllIll) {
        this.borderSize = lllllllllllllllIIlIIIlIlllIllIll;
    }
    
    public boolean isHardcoreModeEnabled() {
        return this.hardcore;
    }
    
    public void setSpawnY(final int lllllllllllllllIIlIIIllIllIIIIII) {
        this.spawnY = lllllllllllllllIIlIIIllIllIIIIII;
    }
    
    public void setBorderSafeZone(final double lllllllllllllllIIlIIIlIllIllIlII) {
        this.borderSafeZone = lllllllllllllllIIlIIIlIllIllIlII;
    }
    
    public void setSaveVersion(final int lllllllllllllllIIlIIIllIlIIIlIll) {
        this.saveVersion = lllllllllllllllIIlIIIllIlIIIlIll;
    }
    
    public String getVersionName() {
        return this.versionName;
    }
    
    public void setBorderDamagePerBlock(final double lllllllllllllllIIlIIIlIllIlIlIll) {
        this.borderDamagePerBlock = lllllllllllllllIIlIIIlIllIlIlIll;
    }
    
    public double getBorderSize() {
        return this.borderSize;
    }
    
    public String getGeneratorOptions() {
        return (this.generatorOptions == null) ? "" : this.generatorOptions;
    }
    
    public void setDimensionData(final DimensionType lllllllllllllllIIlIIIlIlIlllIIII, final NBTTagCompound lllllllllllllllIIlIIIlIlIlllIIlI) {
        this.dimensionData.put(lllllllllllllllIIlIIIlIlIlllIIII, lllllllllllllllIIlIIIlIlIlllIIlI);
    }
    
    public NBTTagCompound getDimensionData(final DimensionType lllllllllllllllIIlIIIlIlIlllllII) {
        final NBTTagCompound lllllllllllllllIIlIIIlIlIllllIll = this.dimensionData.get(lllllllllllllllIIlIIIlIlIlllllII);
        return (lllllllllllllllIIlIIIlIlIllllIll == null) ? new NBTTagCompound() : lllllllllllllllIIlIIIlIlIllllIll;
    }
    
    public double getBorderLerpTarget() {
        return this.borderSizeLerpTarget;
    }
}
