package javax.vecmath;

import java.io.*;
import java.awt.*;

public class Color3f extends Tuple3f implements Serializable
{
    public Color3f(final Color lllllllllllllIlllIllIIIlllllllII) {
        super(lllllllllllllIlllIllIIIlllllllII.getRed() / 255.0f, lllllllllllllIlllIllIIIlllllllII.getGreen() / 255.0f, lllllllllllllIlllIllIIIlllllllII.getBlue() / 255.0f);
    }
    
    public final Color get() {
        final int lllllllllllllIlllIllIIIllllIlIll = Math.round(this.x * 255.0f);
        final int lllllllllllllIlllIllIIIllllIlIlI = Math.round(this.y * 255.0f);
        final int lllllllllllllIlllIllIIIllllIlIIl = Math.round(this.z * 255.0f);
        return new Color(lllllllllllllIlllIllIIIllllIlIll, lllllllllllllIlllIllIIIllllIlIlI, lllllllllllllIlllIllIIIllllIlIIl);
    }
    
    public Color3f(final float lllllllllllllIlllIllIIlIIIIllllI, final float lllllllllllllIlllIllIIlIIIIlllIl, final float lllllllllllllIlllIllIIlIIIIllIII) {
        super(lllllllllllllIlllIllIIlIIIIllllI, lllllllllllllIlllIllIIlIIIIlllIl, lllllllllllllIlllIllIIlIIIIllIII);
    }
    
    public Color3f(final float[] lllllllllllllIlllIllIIlIIIIlIlII) {
        super(lllllllllllllIlllIllIIlIIIIlIlII);
    }
    
    public Color3f(final Tuple3f lllllllllllllIlllIllIIlIIIIIIllI) {
        super(lllllllllllllIlllIllIIlIIIIIIllI);
    }
    
    public Color3f() {
    }
    
    public final void set(final Color lllllllllllllIlllIllIIIlllllIIll) {
        this.x = lllllllllllllIlllIllIIIlllllIIll.getRed() / 255.0f;
        this.y = lllllllllllllIlllIllIIIlllllIIll.getGreen() / 255.0f;
        this.z = lllllllllllllIlllIllIIIlllllIIll.getBlue() / 255.0f;
    }
    
    public Color3f(final Tuple3d lllllllllllllIlllIllIIlIIIIIIIlI) {
        super(lllllllllllllIlllIllIIlIIIIIIIlI);
    }
    
    public Color3f(final Color3f lllllllllllllIlllIllIIlIIIIIlllI) {
        super(lllllllllllllIlllIllIIlIIIIIlllI);
    }
}
