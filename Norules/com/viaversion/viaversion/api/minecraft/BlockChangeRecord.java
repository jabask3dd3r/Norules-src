package com.viaversion.viaversion.api.minecraft;

public interface BlockChangeRecord
{
    int getBlockId();
    
    @Deprecated
    default short getY() {
        return this.getY(-1);
    }
    
    void setBlockId(final int p0);
    
    short getY(final int p0);
    
    byte getSectionZ();
    
    byte getSectionX();
    
    byte getSectionY();
}
