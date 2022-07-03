package javax.vecmath;

import java.io.*;
import java.awt.*;

public class Color4b extends Tuple4b implements Serializable
{
    public final Color get() {
        final int lllllllllllllllIIlllIIIllIIIIIII = this.x & 0xFF;
        final int lllllllllllllllIIlllIIIlIlllllll = this.y & 0xFF;
        final int lllllllllllllllIIlllIIIlIllllllI = this.z & 0xFF;
        final int lllllllllllllllIIlllIIIlIlllllIl = this.w & 0xFF;
        return new Color(lllllllllllllllIIlllIIIllIIIIIII, lllllllllllllllIIlllIIIlIlllllll, lllllllllllllllIIlllIIIlIllllllI, lllllllllllllllIIlllIIIlIlllllIl);
    }
    
    public final void set(final Color lllllllllllllllIIlllIIIllIIIlIIl) {
        this.x = (byte)lllllllllllllllIIlllIIIllIIIlIIl.getRed();
        this.y = (byte)lllllllllllllllIIlllIIIllIIIlIIl.getGreen();
        this.z = (byte)lllllllllllllllIIlllIIIllIIIlIIl.getBlue();
        this.w = (byte)lllllllllllllllIIlllIIIllIIIlIIl.getAlpha();
    }
    
    public Color4b(final Color4b lllllllllllllllIIlllIIIllIIlllII) {
        super(lllllllllllllllIIlllIIIllIIlllII);
    }
    
    public Color4b() {
    }
    
    public Color4b(final byte lllllllllllllllIIlllIIIllIllIIII, final byte lllllllllllllllIIlllIIIllIlIlIlI, final byte lllllllllllllllIIlllIIIllIlIlllI, final byte lllllllllllllllIIlllIIIllIlIlIII) {
        super(lllllllllllllllIIlllIIIllIllIIII, lllllllllllllllIIlllIIIllIlIlIlI, lllllllllllllllIIlllIIIllIlIlllI, lllllllllllllllIIlllIIIllIlIlIII);
    }
    
    public Color4b(final byte[] lllllllllllllllIIlllIIIllIlIIIlI) {
        super(lllllllllllllllIIlllIIIllIlIIIlI);
    }
    
    public Color4b(final Tuple4b lllllllllllllllIIlllIIIllIIllIII) {
        super(lllllllllllllllIIlllIIIllIIllIII);
    }
    
    public Color4b(final Color lllllllllllllllIIlllIIIllIIlIIlI) {
        super((byte)lllllllllllllllIIlllIIIllIIlIIlI.getRed(), (byte)lllllllllllllllIIlllIIIllIIlIIlI.getGreen(), (byte)lllllllllllllllIIlllIIIllIIlIIlI.getBlue(), (byte)lllllllllllllllIIlllIIIllIIlIIlI.getAlpha());
    }
}
