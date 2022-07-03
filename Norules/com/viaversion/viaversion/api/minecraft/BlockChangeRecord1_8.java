package com.viaversion.viaversion.api.minecraft;

public class BlockChangeRecord1_8 implements BlockChangeRecord
{
    private /* synthetic */ int blockId;
    private final /* synthetic */ short y;
    private final /* synthetic */ byte sectionX;
    private final /* synthetic */ byte sectionZ;
    
    @Override
    public int getBlockId() {
        return this.blockId;
    }
    
    @Override
    public byte getSectionZ() {
        return this.sectionZ;
    }
    
    @Override
    public byte getSectionY() {
        return (byte)(this.y & 0xF);
    }
    
    public BlockChangeRecord1_8(final byte lllllllllllllIllIIllIIlIIIIlllll, final short lllllllllllllIllIIllIIlIIIIllIIl, final byte lllllllllllllIllIIllIIlIIIIllIII, final int lllllllllllllIllIIllIIlIIIIlllII) {
        this.sectionX = lllllllllllllIllIIllIIlIIIIlllll;
        this.y = lllllllllllllIllIIllIIlIIIIllIIl;
        this.sectionZ = lllllllllllllIllIIllIIlIIIIllIII;
        this.blockId = lllllllllllllIllIIllIIlIIIIlllII;
    }
    
    @Override
    public void setBlockId(final int lllllllllllllIllIIllIIIlllllIIlI) {
        this.blockId = lllllllllllllIllIIllIIIlllllIIlI;
    }
    
    @Override
    public byte getSectionX() {
        return this.sectionX;
    }
    
    @Override
    public short getY(final int lllllllllllllIllIIllIIIlllllllll) {
        return this.y;
    }
    
    public BlockChangeRecord1_8(final int lllllllllllllIllIIllIIlIIIIIlIll, final int lllllllllllllIllIIllIIlIIIIIllll, final int lllllllllllllIllIIllIIlIIIIIlIIl, final int lllllllllllllIllIIllIIlIIIIIllIl) {
        this((byte)lllllllllllllIllIIllIIlIIIIIlIll, (short)lllllllllllllIllIIllIIlIIIIIllll, (byte)lllllllllllllIllIIllIIlIIIIIlIIl, lllllllllllllIllIIllIIlIIIIIllIl);
    }
}
