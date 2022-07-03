package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.world.storage.*;
import net.minecraft.profiler.*;

public class WorldServerDemo extends WorldServer
{
    private static final /* synthetic */ long DEMO_WORLD_SEED;
    public static final /* synthetic */ WorldSettings DEMO_WORLD_SETTINGS;
    
    static {
        DEMO_WORLD_SEED = "North Carolina".hashCode();
        DEMO_WORLD_SETTINGS = new WorldSettings(WorldServerDemo.DEMO_WORLD_SEED, GameType.SURVIVAL, true, false, WorldType.DEFAULT).enableBonusChest();
    }
    
    public WorldServerDemo(final MinecraftServer lllllllllllllIlIIllIllIlIlIIIIlI, final ISaveHandler lllllllllllllIlIIllIllIlIIlllIll, final WorldInfo lllllllllllllIlIIllIllIlIlIIIIII, final int lllllllllllllIlIIllIllIlIIlllIIl, final Profiler lllllllllllllIlIIllIllIlIIlllllI) {
        super(lllllllllllllIlIIllIllIlIlIIIIlI, lllllllllllllIlIIllIllIlIIlllIll, lllllllllllllIlIIllIllIlIlIIIIII, lllllllllllllIlIIllIllIlIIlllIIl, lllllllllllllIlIIllIllIlIIlllllI);
        this.worldInfo.populateFromWorldSettings(WorldServerDemo.DEMO_WORLD_SETTINGS);
    }
}
