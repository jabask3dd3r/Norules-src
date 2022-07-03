package com.viaversion.viaversion.api.minecraft;

import java.util.*;

public enum BlockFace
{
    private final /* synthetic */ EnumAxis axis;
    private final /* synthetic */ byte modX;
    
    EAST((byte)1, (byte)0, (byte)0, EnumAxis.X), 
    SOUTH((byte)0, (byte)0, (byte)1, EnumAxis.Z), 
    WEST((byte)(-1), (byte)0, (byte)0, EnumAxis.X), 
    TOP((byte)0, (byte)1, (byte)0, EnumAxis.Y);
    
    private final /* synthetic */ byte modY;
    private final /* synthetic */ byte modZ;
    
    BOTTOM((byte)0, (byte)(-1), (byte)0, EnumAxis.Y);
    
    private static final /* synthetic */ Map<BlockFace, BlockFace> opposites;
    
    NORTH((byte)0, (byte)0, (byte)(-1), EnumAxis.Z);
    
    public byte getModX() {
        return this.modX;
    }
    
    static {
        (opposites = new HashMap<BlockFace, BlockFace>()).put(BlockFace.NORTH, BlockFace.SOUTH);
        BlockFace.opposites.put(BlockFace.SOUTH, BlockFace.NORTH);
        BlockFace.opposites.put(BlockFace.EAST, BlockFace.WEST);
        BlockFace.opposites.put(BlockFace.WEST, BlockFace.EAST);
        BlockFace.opposites.put(BlockFace.TOP, BlockFace.BOTTOM);
        BlockFace.opposites.put(BlockFace.BOTTOM, BlockFace.TOP);
    }
    
    public byte getModZ() {
        return this.modZ;
    }
    
    public byte getModY() {
        return this.modY;
    }
    
    public EnumAxis getAxis() {
        return this.axis;
    }
    
    private BlockFace(final byte llllllllllllIlllllIlIIlllllIIlII, final byte llllllllllllIlllllIlIIlllllIIIll, final byte llllllllllllIlllllIlIIllllIllIll, final EnumAxis llllllllllllIlllllIlIIlllllIIIIl) {
        this.modX = llllllllllllIlllllIlIIlllllIIlII;
        this.modY = llllllllllllIlllllIlIIlllllIIIll;
        this.modZ = llllllllllllIlllllIlIIllllIllIll;
        this.axis = llllllllllllIlllllIlIIlllllIIIIl;
    }
    
    public BlockFace opposite() {
        return BlockFace.opposites.get(this);
    }
    
    public enum EnumAxis
    {
        X, 
        Z, 
        Y;
    }
}
