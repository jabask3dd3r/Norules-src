package javax.vecmath;

import java.io.*;
import java.awt.*;

public class Color3b extends Tuple3b implements Serializable
{
    public final Color get() {
        final int llllllllllllllIIlllIlllIllllIIIl = this.x & 0xFF;
        final int llllllllllllllIIlllIlllIllllIIII = this.y & 0xFF;
        final int llllllllllllllIIlllIlllIlllIllll = this.z & 0xFF;
        return new Color(llllllllllllllIIlllIlllIllllIIIl, llllllllllllllIIlllIlllIllllIIII, llllllllllllllIIlllIlllIlllIllll);
    }
    
    public Color3b(final Color3b llllllllllllllIIlllIllllIIIIllII) {
        super(llllllllllllllIIlllIllllIIIIllII);
    }
    
    public Color3b(final byte[] llllllllllllllIIlllIllllIIIlIIlI) {
        super(llllllllllllllIIlllIllllIIIlIIlI);
    }
    
    public Color3b(final Color llllllllllllllIIlllIllllIIIIIIII) {
        super((byte)llllllllllllllIIlllIllllIIIIIIII.getRed(), (byte)llllllllllllllIIlllIllllIIIIIIII.getGreen(), (byte)llllllllllllllIIlllIllllIIIIIIII.getBlue());
    }
    
    public Color3b() {
    }
    
    public Color3b(final byte llllllllllllllIIlllIllllIIIllIlI, final byte llllllllllllllIIlllIllllIIIllIIl, final byte llllllllllllllIIlllIllllIIIllIII) {
        super(llllllllllllllIIlllIllllIIIllIlI, llllllllllllllIIlllIllllIIIllIIl, llllllllllllllIIlllIllllIIIllIII);
    }
    
    public final void set(final Color llllllllllllllIIlllIlllIllllIlll) {
        this.x = (byte)llllllllllllllIIlllIlllIllllIlll.getRed();
        this.y = (byte)llllllllllllllIIlllIlllIllllIlll.getGreen();
        this.z = (byte)llllllllllllllIIlllIlllIllllIlll.getBlue();
    }
    
    public Color3b(final Tuple3b llllllllllllllIIlllIllllIIIIlIII) {
        super(llllllllllllllIIlllIllllIIIIlIII);
    }
}
