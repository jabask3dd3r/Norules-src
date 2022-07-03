package de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage;

import com.viaversion.viaversion.api.connection.*;

public class BlockPlaceDestroyTracker extends StoredObject
{
    private /* synthetic */ long blockPlaced;
    private /* synthetic */ long lastMining;
    private /* synthetic */ boolean mining;
    
    public void setLastMining(final long llllllllllllllIIlIlIIlIIIIIlllII) {
        this.lastMining = llllllllllllllIIlIlIIlIIIIIlllII;
    }
    
    public BlockPlaceDestroyTracker(final UserConnection llllllllllllllIIlIlIIlIIIIlllIlI) {
        super(llllllllllllllIIlIlIIlIIIIlllIlI);
    }
    
    public void setMining(final boolean llllllllllllllIIlIlIIlIIIIlIlIII) {
        this.mining = (llllllllllllllIIlIlIIlIIIIlIlIII && this.getUser().get(EntityTracker.class).getPlayerGamemode() != 1);
        this.lastMining = System.currentTimeMillis();
    }
    
    public void updateMining() {
        if (this.isMining()) {
            this.lastMining = System.currentTimeMillis();
        }
    }
    
    public boolean isMining() {
        final long llllllllllllllIIlIlIIlIIIIllIIII = System.currentTimeMillis() - this.lastMining;
        return (this.mining && llllllllllllllIIlIlIIlIIIIllIIII < 75L) || llllllllllllllIIlIlIIlIIIIllIIII < 75L;
    }
    
    public long getLastMining() {
        return this.lastMining;
    }
    
    public void place() {
        this.blockPlaced = System.currentTimeMillis();
    }
    
    public long getBlockPlaced() {
        return this.blockPlaced;
    }
}
