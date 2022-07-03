package com.viaversion.viaversion.libs.javassist.bytecode;

class ByteVector implements Cloneable
{
    private /* synthetic */ int size;
    private /* synthetic */ byte[] buffer;
    
    public ByteVector() {
        this.buffer = new byte[64];
        this.size = 0;
    }
    
    public Object clone() throws CloneNotSupportedException {
        final ByteVector llllllllllllllIlIlIIllIlllIllIll = (ByteVector)super.clone();
        llllllllllllllIlIlIIllIlllIllIll.buffer = this.buffer.clone();
        return llllllllllllllIlIlIIllIlllIllIll;
    }
    
    public int read(final int llllllllllllllIlIlIIllIlllIIllII) {
        if (llllllllllllllIlIlIIllIlllIIllII < 0 || this.size <= llllllllllllllIlIlIIllIlllIIllII) {
            throw new ArrayIndexOutOfBoundsException(llllllllllllllIlIlIIllIlllIIllII);
        }
        return this.buffer[llllllllllllllIlIlIIllIlllIIllII];
    }
    
    public void addGap(final int llllllllllllllIlIlIIllIllIIllIIl) {
        if (this.size + llllllllllllllIlIlIIllIllIIllIIl > this.buffer.length) {
            int llllllllllllllIlIlIIllIllIIllllI = this.size << 1;
            if (llllllllllllllIlIlIIllIllIIllllI < this.size + llllllllllllllIlIlIIllIllIIllIIl) {
                llllllllllllllIlIlIIllIllIIllllI = this.size + llllllllllllllIlIlIIllIllIIllIIl;
            }
            final byte[] llllllllllllllIlIlIIllIllIIlllIl = new byte[llllllllllllllIlIlIIllIllIIllllI];
            System.arraycopy(this.buffer, 0, llllllllllllllIlIlIIllIllIIlllIl, 0, this.size);
            this.buffer = llllllllllllllIlIlIIllIllIIlllIl;
        }
        this.size += llllllllllllllIlIlIIllIllIIllIIl;
    }
    
    public void add(final int llllllllllllllIlIlIIllIllIllllIl) {
        this.addGap(1);
        this.buffer[this.size - 1] = (byte)llllllllllllllIlIlIIllIllIllllIl;
    }
    
    public final int getSize() {
        return this.size;
    }
    
    public void write(final int llllllllllllllIlIlIIllIlllIIIIlI, final int llllllllllllllIlIlIIllIlllIIIIIl) {
        if (llllllllllllllIlIlIIllIlllIIIIlI < 0 || this.size <= llllllllllllllIlIlIIllIlllIIIIlI) {
            throw new ArrayIndexOutOfBoundsException(llllllllllllllIlIlIIllIlllIIIIlI);
        }
        this.buffer[llllllllllllllIlIlIIllIlllIIIIlI] = (byte)llllllllllllllIlIlIIllIlllIIIIIl;
    }
    
    public void add(final int llllllllllllllIlIlIIllIllIlIlIll, final int llllllllllllllIlIlIIllIllIlIIlIl, final int llllllllllllllIlIlIIllIllIlIlIIl, final int llllllllllllllIlIlIIllIllIlIlIII) {
        this.addGap(4);
        this.buffer[this.size - 4] = (byte)llllllllllllllIlIlIIllIllIlIlIll;
        this.buffer[this.size - 3] = (byte)llllllllllllllIlIlIIllIllIlIIlIl;
        this.buffer[this.size - 2] = (byte)llllllllllllllIlIlIIllIllIlIlIIl;
        this.buffer[this.size - 1] = (byte)llllllllllllllIlIlIIllIllIlIlIII;
    }
    
    public void add(final int llllllllllllllIlIlIIllIllIllIllI, final int llllllllllllllIlIlIIllIllIllIlIl) {
        this.addGap(2);
        this.buffer[this.size - 2] = (byte)llllllllllllllIlIlIIllIllIllIllI;
        this.buffer[this.size - 1] = (byte)llllllllllllllIlIlIIllIllIllIlIl;
    }
    
    public final byte[] copy() {
        final byte[] llllllllllllllIlIlIIllIlllIlIIlI = new byte[this.size];
        System.arraycopy(this.buffer, 0, llllllllllllllIlIlIIllIlllIlIIlI, 0, this.size);
        return llllllllllllllIlIlIIllIlllIlIIlI;
    }
}
