package optifine;

import net.minecraft.server.*;
import net.minecraft.world.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.world.storage.*;
import net.minecraft.profiler.*;

public class WorldServerOF extends WorldServer
{
    private /* synthetic */ MinecraftServer mcServer;
    
    @Override
    public void tick() {
        super.tick();
        if (!Config.isTimeDefault()) {
            this.fixWorldTime();
        }
        if (Config.waterOpacityChanged) {
            Config.waterOpacityChanged = false;
            ClearWater.updateWaterOpacity(Config.getGameSettings(), this);
        }
    }
    
    private void fixWorldWeather() {
        if (this.worldInfo.isRaining() || this.worldInfo.isThundering()) {
            this.worldInfo.setRainTime(0);
            this.worldInfo.setRaining(false);
            this.setRainStrength(0.0f);
            this.worldInfo.setThunderTime(0);
            this.worldInfo.setThundering(false);
            this.setThunderStrength(0.0f);
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(2, 0.0f));
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(7, 0.0f));
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(8, 0.0f));
        }
    }
    
    private void fixWorldTime() {
        if (this.worldInfo.getGameType().getID() == 1) {
            final long lllllllllllllIIIIIIIIllIllIIIlII = this.getWorldTime();
            final long lllllllllllllIIIIIIIIllIllIIIIll = lllllllllllllIIIIIIIIllIllIIIlII % 24000L;
            if (Config.isTimeDayOnly()) {
                if (lllllllllllllIIIIIIIIllIllIIIIll <= 1000L) {
                    this.setWorldTime(lllllllllllllIIIIIIIIllIllIIIlII - lllllllllllllIIIIIIIIllIllIIIIll + 1001L);
                }
                if (lllllllllllllIIIIIIIIllIllIIIIll >= 11000L) {
                    this.setWorldTime(lllllllllllllIIIIIIIIllIllIIIlII - lllllllllllllIIIIIIIIllIllIIIIll + 24001L);
                }
            }
            if (Config.isTimeNightOnly()) {
                if (lllllllllllllIIIIIIIIllIllIIIIll <= 14000L) {
                    this.setWorldTime(lllllllllllllIIIIIIIIllIllIIIlII - lllllllllllllIIIIIIIIllIllIIIIll + 14001L);
                }
                if (lllllllllllllIIIIIIIIllIllIIIIll >= 22000L) {
                    this.setWorldTime(lllllllllllllIIIIIIIIllIllIIIlII - lllllllllllllIIIIIIIIllIllIIIIll + 24000L + 14001L);
                }
            }
        }
    }
    
    public WorldServerOF(final MinecraftServer lllllllllllllIIIIIIIIllIllIlllII, final ISaveHandler lllllllllllllIIIIIIIIllIllIllIll, final WorldInfo lllllllllllllIIIIIIIIllIllIlIlII, final int lllllllllllllIIIIIIIIllIllIlIIll, final Profiler lllllllllllllIIIIIIIIllIllIllIII) {
        super(lllllllllllllIIIIIIIIllIllIlllII, lllllllllllllIIIIIIIIllIllIllIll, lllllllllllllIIIIIIIIllIllIlIlII, lllllllllllllIIIIIIIIllIllIlIIll, lllllllllllllIIIIIIIIllIllIllIII);
        this.mcServer = lllllllllllllIIIIIIIIllIllIlllII;
    }
    
    @Override
    protected void updateWeather() {
        if (!Config.isWeatherEnabled()) {
            this.fixWorldWeather();
        }
        super.updateWeather();
    }
}
