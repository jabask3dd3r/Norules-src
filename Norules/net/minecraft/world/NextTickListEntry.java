package net.minecraft.world;

import net.minecraft.block.*;
import net.minecraft.util.math.*;

public class NextTickListEntry implements Comparable<NextTickListEntry>
{
    private final /* synthetic */ Block block;
    private final /* synthetic */ long tickEntryID;
    public final /* synthetic */ BlockPos position;
    private static /* synthetic */ long nextTickEntryID;
    public /* synthetic */ int priority;
    public /* synthetic */ long scheduledTime;
    
    @Override
    public int hashCode() {
        return this.position.hashCode();
    }
    
    public NextTickListEntry(final BlockPos llllllllllllllllIlIllllIIlllllll, final Block llllllllllllllllIlIllllIIllllllI) {
        this.tickEntryID = NextTickListEntry.nextTickEntryID++;
        this.position = llllllllllllllllIlIllllIIlllllll.toImmutable();
        this.block = llllllllllllllllIlIllllIIllllllI;
    }
    
    @Override
    public int compareTo(final NextTickListEntry llllllllllllllllIlIllllIIlIlllll) {
        if (this.scheduledTime < llllllllllllllllIlIllllIIlIlllll.scheduledTime) {
            return -1;
        }
        if (this.scheduledTime > llllllllllllllllIlIllllIIlIlllll.scheduledTime) {
            return 1;
        }
        if (this.priority != llllllllllllllllIlIllllIIlIlllll.priority) {
            return this.priority - llllllllllllllllIlIllllIIlIlllll.priority;
        }
        if (this.tickEntryID < llllllllllllllllIlIllllIIlIlllll.tickEntryID) {
            return -1;
        }
        return (this.tickEntryID > llllllllllllllllIlIllllIIlIlllll.tickEntryID) ? 1 : 0;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(Block.getIdFromBlock(this.block))).append(": ").append(this.position).append(", ").append(this.scheduledTime).append(", ").append(this.priority).append(", ").append(this.tickEntryID));
    }
    
    public NextTickListEntry setScheduledTime(final long llllllllllllllllIlIllllIIllIlIll) {
        this.scheduledTime = llllllllllllllllIlIllllIIllIlIll;
        return this;
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    public void setPriority(final int llllllllllllllllIlIllllIIllIIlIl) {
        this.priority = llllllllllllllllIlIllllIIllIIlIl;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIlIllllIIlllIIll) {
        if (!(llllllllllllllllIlIllllIIlllIIll instanceof NextTickListEntry)) {
            return false;
        }
        final NextTickListEntry llllllllllllllllIlIllllIIlllIlIl = (NextTickListEntry)llllllllllllllllIlIllllIIlllIIll;
        return this.position.equals(llllllllllllllllIlIllllIIlllIlIl.position) && Block.isEqualTo(this.block, llllllllllllllllIlIllllIIlllIlIl.block);
    }
}
