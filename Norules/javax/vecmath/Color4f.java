package javax.vecmath;

import java.io.*;
import java.awt.*;

public class Color4f extends Tuple4f implements Serializable
{
    public Color4f(final float[] lllllllllllllIlIlIIlIlIIlIlIlIIl) {
        super(lllllllllllllIlIlIIlIlIIlIlIlIIl);
    }
    
    public Color4f(final float lllllllllllllIlIlIIlIlIIlIllIIII, final float lllllllllllllIlIlIIlIlIIlIlIllll, final float lllllllllllllIlIlIIlIlIIlIllIIll, final float lllllllllllllIlIlIIlIlIIlIllIIlI) {
        super(lllllllllllllIlIlIIlIlIIlIllIIII, lllllllllllllIlIlIIlIlIIlIlIllll, lllllllllllllIlIlIIlIlIIlIllIIll, lllllllllllllIlIlIIlIlIIlIllIIlI);
    }
    
    public Color4f() {
    }
    
    public final void set(final Color lllllllllllllIlIlIIlIlIIlIIIIllI) {
        this.x = lllllllllllllIlIlIIlIlIIlIIIIllI.getRed() / 255.0f;
        this.y = lllllllllllllIlIlIIlIlIIlIIIIllI.getGreen() / 255.0f;
        this.z = lllllllllllllIlIlIIlIlIIlIIIIllI.getBlue() / 255.0f;
        this.w = lllllllllllllIlIlIIlIlIIlIIIIllI.getAlpha() / 255.0f;
    }
    
    public Color4f(final Color lllllllllllllIlIlIIlIlIIlIIlIIIl) {
        super(lllllllllllllIlIlIIlIlIIlIIlIIIl.getRed() / 255.0f, lllllllllllllIlIlIIlIlIIlIIlIIIl.getGreen() / 255.0f, lllllllllllllIlIlIIlIlIIlIIlIIIl.getBlue() / 255.0f, lllllllllllllIlIlIIlIlIIlIIlIIIl.getAlpha() / 255.0f);
    }
    
    public Color4f(final Tuple4d lllllllllllllIlIlIIlIlIIlIIlIlIl) {
        super(lllllllllllllIlIlIIlIlIIlIIlIlIl);
    }
    
    public Color4f(final Tuple4f lllllllllllllIlIlIIlIlIIlIIllIll) {
        super(lllllllllllllIlIlIIlIlIIlIIllIll);
    }
    
    public final Color get() {
        final int lllllllllllllIlIlIIlIlIIIllllIII = Math.round(this.x * 255.0f);
        final int lllllllllllllIlIlIIlIlIIIlllIlll = Math.round(this.y * 255.0f);
        final int lllllllllllllIlIlIIlIlIIIlllIlIl = Math.round(this.z * 255.0f);
        final int lllllllllllllIlIlIIlIlIIIlllIIll = Math.round(this.w * 255.0f);
        return new Color(lllllllllllllIlIlIIlIlIIIllllIII, lllllllllllllIlIlIIlIlIIIlllIlll, lllllllllllllIlIlIIlIlIIIlllIlIl, lllllllllllllIlIlIIlIlIIIlllIIll);
    }
    
    public Color4f(final Color4f lllllllllllllIlIlIIlIlIIlIlIIIIl) {
        super(lllllllllllllIlIlIIlIlIIlIlIIIIl);
    }
}
