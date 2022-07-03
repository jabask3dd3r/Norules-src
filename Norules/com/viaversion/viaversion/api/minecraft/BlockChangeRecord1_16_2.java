package com.viaversion.viaversion.api.minecraft;

import com.google.common.base.*;

public class BlockChangeRecord1_16_2 implements BlockChangeRecord
{
    private final /* synthetic */ byte sectionX;
    private final /* synthetic */ byte sectionZ;
    private final /* synthetic */ byte sectionY;
    private /* synthetic */ int blockId;
    
    public BlockChangeRecord1_16_2(final byte lIllIIlIllIIIll, final byte lIllIIlIllIIlll, final byte lIllIIlIllIIllI, final int lIllIIlIllIIIII) {
        this.sectionX = lIllIIlIllIIIll;
        this.sectionY = lIllIIlIllIIlll;
        this.sectionZ = lIllIIlIllIIllI;
        this.blockId = lIllIIlIllIIIII;
    }
    
    @Override
    public byte getSectionZ() {
        return this.sectionZ;
    }
    
    @Override
    public byte getSectionY() {
        return this.sectionY;
    }
    
    @Override
    public int getBlockId() {
        return this.blockId;
    }
    
    public BlockChangeRecord1_16_2(final int lIllIIlIlIlIlII, final int lIllIIlIlIlIIll, final int lIllIIlIlIlIlll, final int lIllIIlIlIlIIIl) {
        this((byte)lIllIIlIlIlIlII, (byte)lIllIIlIlIlIIll, (byte)lIllIIlIlIlIlll, lIllIIlIlIlIIIl);
    }
    
    @Override
    public short getY(final int lIllIIlIlIIIlII) {
        Preconditions.checkArgument(lIllIIlIlIIIlII >= 0, (Object)String.valueOf(new StringBuilder().append("Invalid chunkSectionY: ").append(lIllIIlIlIIIlII)));
        return (short)((lIllIIlIlIIIlII << 4) + this.sectionY);
    }
    
    @Override
    public void setBlockId(final int lIllIIlIIlllIIl) {
        this.blockId = lIllIIlIIlllIIl;
    }
    
    @Override
    public byte getSectionX() {
        return this.sectionX;
    }
}
