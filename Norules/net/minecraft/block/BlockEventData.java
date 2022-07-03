package net.minecraft.block;

import net.minecraft.util.math.*;

public class BlockEventData
{
    private final /* synthetic */ int eventParameter;
    private final /* synthetic */ Block blockType;
    private final /* synthetic */ int eventID;
    private final /* synthetic */ BlockPos position;
    
    @Override
    public boolean equals(final Object lllllllllllllIIIllIllIIllIIIlIll) {
        if (!(lllllllllllllIIIllIllIIllIIIlIll instanceof BlockEventData)) {
            return false;
        }
        final BlockEventData lllllllllllllIIIllIllIIllIIIlIlI = (BlockEventData)lllllllllllllIIIllIllIIllIIIlIll;
        return this.position.equals(lllllllllllllIIIllIllIIllIIIlIlI.position) && this.eventID == lllllllllllllIIIllIllIIllIIIlIlI.eventID && this.eventParameter == lllllllllllllIIIllIllIIllIIIlIlI.eventParameter && this.blockType == lllllllllllllIIIllIllIIllIIIlIlI.blockType;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TE(").append(this.position).append("),").append(this.eventID).append(",").append(this.eventParameter).append(",").append(this.blockType));
    }
    
    public int getEventParameter() {
        return this.eventParameter;
    }
    
    public Block getBlock() {
        return this.blockType;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public int getEventID() {
        return this.eventID;
    }
    
    public BlockEventData(final BlockPos lllllllllllllIIIllIllIIllIIlllll, final Block lllllllllllllIIIllIllIIllIlIIIll, final int lllllllllllllIIIllIllIIllIIlllIl, final int lllllllllllllIIIllIllIIllIlIIIIl) {
        this.position = lllllllllllllIIIllIllIIllIIlllll;
        this.eventID = lllllllllllllIIIllIllIIllIIlllIl;
        this.eventParameter = lllllllllllllIIIllIllIIllIlIIIIl;
        this.blockType = lllllllllllllIIIllIllIIllIlIIIll;
    }
}
