package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.chunks;

import com.viaversion.viaversion.api.minecraft.chunks.*;

public class ExtendedBlockStorage
{
    private /* synthetic */ byte[] blockLSBArray;
    private /* synthetic */ NibbleArray blocklightArray;
    private /* synthetic */ int yBase;
    private /* synthetic */ NibbleArray blockMSBArray;
    private /* synthetic */ NibbleArray skylightArray;
    private /* synthetic */ NibbleArray blockMetadataArray;
    
    public NibbleArray getMetadataArray() {
        return this.blockMetadataArray;
    }
    
    public NibbleArray getBlockMSBArray() {
        return this.blockMSBArray;
    }
    
    public void setBlocklightArray(final NibbleArray lllllllllllllIllllIIlIIlllIIIIII) {
        this.blocklightArray = lllllllllllllIllllIIlIIlllIIIIII;
    }
    
    public void setSkylightArray(final NibbleArray lllllllllllllIllllIIlIIllIlllIlI) {
        this.skylightArray = lllllllllllllIllllIIlIIllIlllIlI;
    }
    
    public byte[] getBlockLSBArray() {
        return this.blockLSBArray;
    }
    
    public int getExtBlockMetadata(final int lllllllllllllIllllIIlIlIIIlllIIl, final int lllllllllllllIllllIIlIlIIIllIlII, final int lllllllllllllIllllIIlIlIIIllIlll) {
        return this.blockMetadataArray.get(lllllllllllllIllllIIlIlIIIlllIIl, lllllllllllllIllllIIlIlIIIllIlII, lllllllllllllIllllIIlIlIIIllIlll);
    }
    
    public void clearMSBArray() {
        this.blockMSBArray = null;
    }
    
    public NibbleArray createBlockMSBArray() {
        this.blockMSBArray = new NibbleArray(this.blockLSBArray.length);
        return this.blockMSBArray;
    }
    
    public int getExtSkylightValue(final int lllllllllllllIllllIIlIlIIIIIllII, final int lllllllllllllIllllIIlIlIIIIIIlll, final int lllllllllllllIllllIIlIlIIIIIlIlI) {
        return this.skylightArray.get(lllllllllllllIllllIIlIlIIIIIllII, lllllllllllllIllllIIlIlIIIIIIlll, lllllllllllllIllllIIlIlIIIIIlIlI);
    }
    
    public void setExtBlockMetadata(final int lllllllllllllIllllIIlIlIIIlIllII, final int lllllllllllllIllllIIlIlIIIlIIllI, final int lllllllllllllIllllIIlIlIIIlIIlIl, final int lllllllllllllIllllIIlIlIIIlIIlII) {
        this.blockMetadataArray.set(lllllllllllllIllllIIlIlIIIlIllII, lllllllllllllIllllIIlIlIIIlIIllI, lllllllllllllIllllIIlIlIIIlIIlIl, lllllllllllllIllllIIlIlIIIlIIlII);
    }
    
    public NibbleArray getBlocklightArray() {
        return this.blocklightArray;
    }
    
    public int getExtBlocklightValue(final int lllllllllllllIllllIIlIIllllIllIl, final int lllllllllllllIllllIIlIIlllllIIII, final int lllllllllllllIllllIIlIIllllIlIll) {
        return this.blocklightArray.get(lllllllllllllIllllIIlIIllllIllIl, lllllllllllllIllllIIlIIlllllIIII, lllllllllllllIllllIIlIIllllIlIll);
    }
    
    public void setBlockMetadataArray(final NibbleArray lllllllllllllIllllIIlIIlllIIIlII) {
        this.blockMetadataArray = lllllllllllllIllllIIlIIlllIIIlII;
    }
    
    public boolean isEmpty() {
        return this.blockMSBArray == null;
    }
    
    public void setExtSkylightValue(final int lllllllllllllIllllIIlIlIIIIlIlIl, final int lllllllllllllIllllIIlIlIIIIllIIl, final int lllllllllllllIllllIIlIlIIIIllIII, final int lllllllllllllIllllIIlIlIIIIlIIlI) {
        this.skylightArray.set(lllllllllllllIllllIIlIlIIIIlIlIl, lllllllllllllIllllIIlIlIIIIllIIl, lllllllllllllIllllIIlIlIIIIllIII, lllllllllllllIllllIIlIlIIIIlIIlI);
    }
    
    public void setExtBlocklightValue(final int lllllllllllllIllllIIlIIllllllIlI, final int lllllllllllllIllllIIlIIllllllllI, final int lllllllllllllIllllIIlIIlllllllIl, final int lllllllllllllIllllIIlIIlllllIlll) {
        this.blocklightArray.set(lllllllllllllIllllIIlIIllllllIlI, lllllllllllllIllllIIlIIllllllllI, lllllllllllllIllllIIlIIlllllllIl, lllllllllllllIllllIIlIIlllllIlll);
    }
    
    public NibbleArray getSkylightArray() {
        return this.skylightArray;
    }
    
    public int getYLocation() {
        return this.yBase;
    }
    
    public ExtendedBlockStorage(final int lllllllllllllIllllIIlIlIIlIIIIII, final boolean lllllllllllllIllllIIlIlIIIllllll) {
        this.yBase = lllllllllllllIllllIIlIlIIlIIIIII;
        this.blockLSBArray = new byte[4096];
        this.blockMetadataArray = new NibbleArray(this.blockLSBArray.length);
        this.blocklightArray = new NibbleArray(this.blockLSBArray.length);
        if (lllllllllllllIllllIIlIlIIIllllll) {
            this.skylightArray = new NibbleArray(this.blockLSBArray.length);
        }
    }
    
    public void setBlockLSBArray(final byte[] lllllllllllllIllllIIlIIlllIlIIlI) {
        this.blockLSBArray = lllllllllllllIllllIIlIIlllIlIIlI;
    }
    
    public void setBlockMSBArray(final NibbleArray lllllllllllllIllllIIlIIlllIIlIlI) {
        this.blockMSBArray = lllllllllllllIllllIIlIIlllIIlIlI;
    }
}
