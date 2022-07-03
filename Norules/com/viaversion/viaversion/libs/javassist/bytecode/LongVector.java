package com.viaversion.viaversion.libs.javassist.bytecode;

final class LongVector
{
    private /* synthetic */ int elements;
    private /* synthetic */ ConstInfo[][] objects;
    
    public int capacity() {
        return this.objects.length * 128;
    }
    
    public LongVector() {
        this.objects = new ConstInfo[8][];
        this.elements = 0;
    }
    
    public void addElement(final ConstInfo llllllllllllllIIIIIIIllIIlIlIlll) {
        final int llllllllllllllIIIIIIIllIIlIlIllI = this.elements >> 7;
        final int llllllllllllllIIIIIIIllIIlIlIlIl = this.elements & 0x7F;
        final int llllllllllllllIIIIIIIllIIlIlIlII = this.objects.length;
        if (llllllllllllllIIIIIIIllIIlIlIllI >= llllllllllllllIIIIIIIllIIlIlIlII) {
            final ConstInfo[][] llllllllllllllIIIIIIIllIIlIllIIl = new ConstInfo[llllllllllllllIIIIIIIllIIlIlIlII + 8][];
            System.arraycopy(this.objects, 0, llllllllllllllIIIIIIIllIIlIllIIl, 0, llllllllllllllIIIIIIIllIIlIlIlII);
            this.objects = llllllllllllllIIIIIIIllIIlIllIIl;
        }
        if (this.objects[llllllllllllllIIIIIIIllIIlIlIllI] == null) {
            this.objects[llllllllllllllIIIIIIIllIIlIlIllI] = new ConstInfo[128];
        }
        this.objects[llllllllllllllIIIIIIIllIIlIlIllI][llllllllllllllIIIIIIIllIIlIlIlIl] = llllllllllllllIIIIIIIllIIlIlIlll;
        ++this.elements;
    }
    
    static {
        VSIZE = 8;
        ABITS = 7;
        ASIZE = 128;
    }
    
    public LongVector(final int llllllllllllllIIIIIIIllIIlllIIII) {
        final int llllllllllllllIIIIIIIllIIllIllll = (llllllllllllllIIIIIIIllIIlllIIII >> 7 & 0xFFFFFFF8) + 8;
        this.objects = new ConstInfo[llllllllllllllIIIIIIIllIIllIllll][];
        this.elements = 0;
    }
    
    public int size() {
        return this.elements;
    }
    
    public ConstInfo elementAt(final int llllllllllllllIIIIIIIllIIllIIIII) {
        if (llllllllllllllIIIIIIIllIIllIIIII < 0 || this.elements <= llllllllllllllIIIIIIIllIIllIIIII) {
            return null;
        }
        return this.objects[llllllllllllllIIIIIIIllIIllIIIII >> 7][llllllllllllllIIIIIIIllIIllIIIII & 0x7F];
    }
}
