package net.minecraft.world.storage;

public class WorldSavedDataCallableSave implements Runnable
{
    private final /* synthetic */ WorldSavedData data;
    
    @Override
    public void run() {
        this.data.markDirty();
    }
    
    public WorldSavedDataCallableSave(final WorldSavedData lllllllllllllIlIIlllIIlIIIIIlIll) {
        this.data = lllllllllllllIlIIlllIIlIIIIIlIll;
    }
}
