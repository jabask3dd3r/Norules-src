package net.minecraft.world.storage;

import javax.annotation.*;

public class SaveDataMemoryStorage extends MapStorage
{
    @Override
    public void setData(final String lllllllllllllIIlIlIlIlIlIlllllll, final WorldSavedData lllllllllllllIIlIlIlIlIllIIIIIIl) {
        this.loadedDataMap.put(lllllllllllllIIlIlIlIlIlIlllllll, lllllllllllllIIlIlIlIlIllIIIIIIl);
    }
    
    @Override
    public int getUniqueDataId(final String lllllllllllllIIlIlIlIlIlIllllIll) {
        return 0;
    }
    
    @Override
    public void saveAllData() {
    }
    
    public SaveDataMemoryStorage() {
        super(null);
    }
    
    @Nullable
    @Override
    public WorldSavedData getOrLoadData(final Class<? extends WorldSavedData> lllllllllllllIIlIlIlIlIllIIIlIlI, final String lllllllllllllIIlIlIlIlIllIIIlIIl) {
        return this.loadedDataMap.get(lllllllllllllIIlIlIlIlIllIIIlIIl);
    }
}
