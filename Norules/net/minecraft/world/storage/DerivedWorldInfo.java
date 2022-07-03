package net.minecraft.world.storage;

import net.minecraft.nbt.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class DerivedWorldInfo extends WorldInfo
{
    private final /* synthetic */ WorldInfo theWorldInfo;
    
    @Override
    public boolean isInitialized() {
        return this.theWorldInfo.isInitialized();
    }
    
    @Override
    public void setSpawnX(final int lllllllllllllIlIIlIIIIIlllllllll) {
    }
    
    @Override
    public int getSpawnZ() {
        return this.theWorldInfo.getSpawnZ();
    }
    
    @Override
    public int getThunderTime() {
        return this.theWorldInfo.getThunderTime();
    }
    
    @Override
    public NBTTagCompound cloneNBTCompound(@Nullable final NBTTagCompound lllllllllllllIlIIlIIIIlIIIllIIll) {
        return this.theWorldInfo.cloneNBTCompound(lllllllllllllIlIIlIIIIlIIIllIIll);
    }
    
    @Override
    public void setSpawnY(final int lllllllllllllIlIIlIIIIIlllllllIl) {
    }
    
    @Override
    public void setDimensionData(final DimensionType lllllllllllllIlIIlIIIIIllIllllll, final NBTTagCompound lllllllllllllIlIIlIIIIIlllIIIIIl) {
        this.theWorldInfo.setDimensionData(lllllllllllllIlIIlIIIIIllIllllll, lllllllllllllIlIIlIIIIIlllIIIIIl);
    }
    
    @Override
    public int getSaveVersion() {
        return this.theWorldInfo.getSaveVersion();
    }
    
    @Override
    public long getSeed() {
        return this.theWorldInfo.getSeed();
    }
    
    @Override
    public boolean isThundering() {
        return this.theWorldInfo.isThundering();
    }
    
    @Override
    public void setSpawnZ(final int lllllllllllllIlIIlIIIIIllllllIll) {
    }
    
    @Override
    public void setServerInitialized(final boolean lllllllllllllIlIIlIIIIIlllIlIlII) {
    }
    
    @Override
    public void setWorldTime(final long lllllllllllllIlIIlIIIIIlllllIlll) {
    }
    
    @Override
    public EnumDifficulty getDifficulty() {
        return this.theWorldInfo.getDifficulty();
    }
    
    @Override
    public int getSpawnX() {
        return this.theWorldInfo.getSpawnX();
    }
    
    @Override
    public boolean isDifficultyLocked() {
        return this.theWorldInfo.isDifficultyLocked();
    }
    
    @Override
    public void setRaining(final boolean lllllllllllllIlIIlIIIIIllllIlIll) {
    }
    
    @Override
    public void setDifficultyLocked(final boolean lllllllllllllIlIIlIIIIIlllIIIlll) {
    }
    
    @Override
    public int getRainTime() {
        return this.theWorldInfo.getRainTime();
    }
    
    @Override
    public long getLastTimePlayed() {
        return this.theWorldInfo.getLastTimePlayed();
    }
    
    @Override
    public boolean isMapFeaturesEnabled() {
        return this.theWorldInfo.isMapFeaturesEnabled();
    }
    
    @Override
    public GameRules getGameRulesInstance() {
        return this.theWorldInfo.getGameRulesInstance();
    }
    
    @Override
    public boolean isRaining() {
        return this.theWorldInfo.isRaining();
    }
    
    @Override
    public void setWorldName(final String lllllllllllllIlIIlIIIIIlllllIIll) {
    }
    
    @Override
    public long getSizeOnDisk() {
        return this.theWorldInfo.getSizeOnDisk();
    }
    
    @Override
    public void setDifficulty(final EnumDifficulty lllllllllllllIlIIlIIIIIlllIIllII) {
    }
    
    @Override
    public void setTerrainType(final WorldType lllllllllllllIlIIlIIIIIlllIllllI) {
    }
    
    @Override
    public void setAllowCommands(final boolean lllllllllllllIlIIlIIIIIlllIllIIl) {
    }
    
    @Override
    public long getWorldTime() {
        return this.theWorldInfo.getWorldTime();
    }
    
    @Override
    public void setSaveVersion(final int lllllllllllllIlIIlIIIIIlllllIIIl) {
    }
    
    public DerivedWorldInfo(final WorldInfo lllllllllllllIlIIlIIIIlIIIlllIIl) {
        this.theWorldInfo = lllllllllllllIlIIlIIIIlIIIlllIIl;
    }
    
    @Override
    public boolean areCommandsAllowed() {
        return this.theWorldInfo.areCommandsAllowed();
    }
    
    @Override
    public void setWorldTotalTime(final long lllllllllllllIlIIlIIIIIllllllIIl) {
    }
    
    @Override
    public WorldType getTerrainType() {
        return this.theWorldInfo.getTerrainType();
    }
    
    @Override
    public void setThundering(final boolean lllllllllllllIlIIlIIIIIllllIllll) {
    }
    
    @Override
    public long getWorldTotalTime() {
        return this.theWorldInfo.getWorldTotalTime();
    }
    
    @Override
    public GameType getGameType() {
        return this.theWorldInfo.getGameType();
    }
    
    @Override
    public NBTTagCompound getDimensionData(final DimensionType lllllllllllllIlIIlIIIIIllIlllIII) {
        return this.theWorldInfo.getDimensionData(lllllllllllllIlIIlIIIIIllIlllIII);
    }
    
    @Override
    public void setSpawn(final BlockPos lllllllllllllIlIIlIIIIIlllllIlIl) {
    }
    
    @Override
    public void setThunderTime(final int lllllllllllllIlIIlIIIIIllllIllIl) {
    }
    
    @Override
    public void setRainTime(final int lllllllllllllIlIIlIIIIIllllIlIIl) {
    }
    
    @Override
    public String getWorldName() {
        return this.theWorldInfo.getWorldName();
    }
    
    @Override
    public int getSpawnY() {
        return this.theWorldInfo.getSpawnY();
    }
    
    @Override
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.theWorldInfo.getPlayerNBTTagCompound();
    }
    
    @Override
    public boolean isHardcoreModeEnabled() {
        return this.theWorldInfo.isHardcoreModeEnabled();
    }
}
