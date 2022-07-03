package optifine;

import net.minecraft.util.*;
import net.minecraft.util.math.*;

public enum BlockDir
{
    SOUTH_WEST("SOUTH_WEST", 8, EnumFacing.SOUTH, EnumFacing.WEST), 
    DOWN_EAST("DOWN_EAST", 15, EnumFacing.DOWN, EnumFacing.EAST);
    
    private /* synthetic */ EnumFacing facing2;
    
    EAST("EAST", 5, EnumFacing.EAST), 
    UP("UP", 1, EnumFacing.UP), 
    SOUTH_EAST("SOUTH_EAST", 9, EnumFacing.SOUTH, EnumFacing.EAST), 
    DOWN_NORTH("DOWN_NORTH", 10, EnumFacing.DOWN, EnumFacing.NORTH), 
    DOWN_SOUTH("DOWN_SOUTH", 11, EnumFacing.DOWN, EnumFacing.SOUTH), 
    DOWN("DOWN", 0, EnumFacing.DOWN), 
    DOWN_WEST("DOWN_WEST", 14, EnumFacing.DOWN, EnumFacing.WEST);
    
    private /* synthetic */ EnumFacing facing1;
    
    UP_WEST("UP_WEST", 16, EnumFacing.UP, EnumFacing.WEST), 
    WEST("WEST", 4, EnumFacing.WEST), 
    UP_SOUTH("UP_SOUTH", 13, EnumFacing.UP, EnumFacing.SOUTH), 
    UP_NORTH("UP_NORTH", 12, EnumFacing.UP, EnumFacing.NORTH), 
    NORTH("NORTH", 2, EnumFacing.NORTH), 
    NORTH_WEST("NORTH_WEST", 6, EnumFacing.NORTH, EnumFacing.WEST), 
    NORTH_EAST("NORTH_EAST", 7, EnumFacing.NORTH, EnumFacing.EAST), 
    UP_EAST("UP_EAST", 17, EnumFacing.UP, EnumFacing.EAST), 
    SOUTH("SOUTH", 3, EnumFacing.SOUTH);
    
    BlockPos offset(BlockPos lllllllllllllIlIIIlIIIlIlllllIll) {
        lllllllllllllIlIIIlIIIlIlllllIll = lllllllllllllIlIIIlIIIlIlllllIll.offset(this.facing1, 1);
        if (this.facing2 != null) {
            lllllllllllllIlIIIlIIIlIlllllIll = lllllllllllllIlIIIlIIIlIlllllIll.offset(this.facing2, 1);
        }
        return lllllllllllllIlIIIlIIIlIlllllIll;
    }
    
    public int getOffsetY() {
        int lllllllllllllIlIIIlIIIlIllllIIIl = this.facing1.getFrontOffsetY();
        if (this.facing2 != null) {
            lllllllllllllIlIIIlIIIlIllllIIIl += this.facing2.getFrontOffsetY();
        }
        return lllllllllllllIlIIIlIIIlIllllIIIl;
    }
    
    public EnumFacing getFacing1() {
        return this.facing1;
    }
    
    public boolean isDouble() {
        return this.facing2 != null;
    }
    
    public int getOffsetZ() {
        int lllllllllllllIlIIIlIIIlIlllIlIll = this.facing1.getFrontOffsetZ();
        if (this.facing2 != null) {
            lllllllllllllIlIIIlIIIlIlllIlIll += this.facing2.getFrontOffsetZ();
        }
        return lllllllllllllIlIIIlIIIlIlllIlIll;
    }
    
    private BlockDir(final String lllllllllllllIlIIIlIIIllIIIlIllI, final int lllllllllllllIlIIIlIIIllIIIlIlIl, final EnumFacing lllllllllllllIlIIIlIIIllIIIllIII) {
        this.facing1 = lllllllllllllIlIIIlIIIllIIIllIII;
    }
    
    private BlockDir(final String lllllllllllllIlIIIlIIIllIIIIlIlI, final int lllllllllllllIlIIIlIIIllIIIIlIIl, final EnumFacing lllllllllllllIlIIIlIIIllIIIIlIII, final EnumFacing lllllllllllllIlIIIlIIIllIIIIllII) {
        this.facing1 = lllllllllllllIlIIIlIIIllIIIIlIII;
        this.facing2 = lllllllllllllIlIIIlIIIllIIIIllII;
    }
    
    public int getOffsetX() {
        int lllllllllllllIlIIIlIIIlIllllIlll = this.facing1.getFrontOffsetX();
        if (this.facing2 != null) {
            lllllllllllllIlIIIlIIIlIllllIlll += this.facing2.getFrontOffsetX();
        }
        return lllllllllllllIlIIIlIIIlIllllIlll;
    }
    
    public EnumFacing getFacing2() {
        return this.facing2;
    }
}
