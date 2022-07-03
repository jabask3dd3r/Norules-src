package net.minecraft.world.chunk.storage;

public class NibbleArrayReader
{
    private final /* synthetic */ int depthBits;
    private final /* synthetic */ int depthBitsPlusFour;
    public final /* synthetic */ byte[] data;
    
    public int get(final int lllllllllllllIIlllllIllIIllIllll, final int lllllllllllllIIlllllIllIIllIlllI, final int lllllllllllllIIlllllIllIIlllIlII) {
        final int lllllllllllllIIlllllIllIIlllIIll = lllllllllllllIIlllllIllIIllIllll << this.depthBitsPlusFour | lllllllllllllIIlllllIllIIlllIlII << this.depthBits | lllllllllllllIIlllllIllIIllIlllI;
        final int lllllllllllllIIlllllIllIIlllIIlI = lllllllllllllIIlllllIllIIlllIIll >> 1;
        final int lllllllllllllIIlllllIllIIlllIIIl = lllllllllllllIIlllllIllIIlllIIll & 0x1;
        return (lllllllllllllIIlllllIllIIlllIIIl == 0) ? (this.data[lllllllllllllIIlllllIllIIlllIIlI] & 0xF) : (this.data[lllllllllllllIIlllllIllIIlllIIlI] >> 4 & 0xF);
    }
    
    public NibbleArrayReader(final byte[] lllllllllllllIIlllllIllIlIIIIIll, final int lllllllllllllIIlllllIllIIlllllll) {
        this.data = lllllllllllllIIlllllIllIlIIIIIll;
        this.depthBits = lllllllllllllIIlllllIllIIlllllll;
        this.depthBitsPlusFour = lllllllllllllIIlllllIllIIlllllll + 4;
    }
}
