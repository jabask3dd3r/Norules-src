package net.minecraft.client.renderer;

import net.minecraft.util.math.*;

public class DestroyBlockProgress
{
    private final /* synthetic */ BlockPos position;
    private final /* synthetic */ int miningPlayerEntId;
    private /* synthetic */ int partialBlockProgress;
    private /* synthetic */ int createdAtCloudUpdateTick;
    
    public int getCreationCloudUpdateTick() {
        return this.createdAtCloudUpdateTick;
    }
    
    public DestroyBlockProgress(final int lllllllllllllIIlllllIIlllIIIIIll, final BlockPos lllllllllllllIIlllllIIllIlllllll) {
        this.miningPlayerEntId = lllllllllllllIIlllllIIlllIIIIIll;
        this.position = lllllllllllllIIlllllIIllIlllllll;
    }
    
    public int getPartialBlockDamage() {
        return this.partialBlockProgress;
    }
    
    public void setCloudUpdateTick(final int lllllllllllllIIlllllIIllIllIllIl) {
        this.createdAtCloudUpdateTick = lllllllllllllIIlllllIIllIllIllIl;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public void setPartialBlockDamage(int lllllllllllllIIlllllIIllIlllIllI) {
        if (lllllllllllllIIlllllIIllIlllIllI > 10) {
            lllllllllllllIIlllllIIllIlllIllI = 10;
        }
        this.partialBlockProgress = lllllllllllllIIlllllIIllIlllIllI;
    }
}
