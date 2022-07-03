package com.viaversion.viabackwards.utils;

public class Block
{
    private final /* synthetic */ int id;
    private final /* synthetic */ short data;
    
    public Block(final int lllllllllllllIlllIIlllIIIIllIlll) {
        this.id = lllllllllllllIlllIIlllIIIIllIlll;
        this.data = 0;
    }
    
    public Block withData(final int lllllllllllllIlllIIlllIIIIlIlIll) {
        return new Block(this.id, lllllllllllllIlllIIlllIIIIlIlIll);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlllIIlllIIIIIllllI = this.id;
        lllllllllllllIlllIIlllIIIIIllllI = 31 * lllllllllllllIlllIIlllIIIIIllllI + this.data;
        return lllllllllllllIlllIIlllIIIIIllllI;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIIlllIIIIlIIIll) {
        if (this == lllllllllllllIlllIIlllIIIIlIIIll) {
            return true;
        }
        if (lllllllllllllIlllIIlllIIIIlIIIll == null || this.getClass() != lllllllllllllIlllIIlllIIIIlIIIll.getClass()) {
            return false;
        }
        final Block lllllllllllllIlllIIlllIIIIlIIlIl = (Block)lllllllllllllIlllIIlllIIIIlIIIll;
        return this.id == lllllllllllllIlllIIlllIIIIlIIlIl.id && this.data == lllllllllllllIlllIIlllIIIIlIIlIl.data;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getData() {
        return this.data;
    }
    
    public Block(final int lllllllllllllIlllIIlllIIIlIIIIIl, final int lllllllllllllIlllIIlllIIIlIIIIII) {
        this.id = lllllllllllllIlllIIlllIIIlIIIIIl;
        this.data = (short)lllllllllllllIlllIIlllIIIlIIIIII;
    }
}
