package me.nrules.utils.render;

import java.awt.*;
import org.lwjgl.opengl.*;

public class ColorHolder
{
    private /* synthetic */ int g;
    private /* synthetic */ int b;
    private /* synthetic */ int a;
    private /* synthetic */ int r;
    
    @Override
    public boolean equals(final Object llllllllllllIlllllIIlllIIlIllIII) {
        if (this == llllllllllllIlllllIIlllIIlIllIII) {
            return true;
        }
        final ColorHolder llllllllllllIlllllIIlllIIlIlIlll = (ColorHolder)llllllllllllIlllllIIlllIIlIllIII;
        return this.r == ((ColorHolder)llllllllllllIlllllIIlllIIlIllIII).r && this.g == ((ColorHolder)llllllllllllIlllllIIlllIIlIllIII).g && this.b == ((ColorHolder)llllllllllllIlllllIIlllIIlIllIII).b && this.a == ((ColorHolder)llllllllllllIlllllIIlllIIlIllIII).a;
    }
    
    public final void setB(final int llllllllllllIlllllIIlllIlIIIIlIl) {
        this.b = llllllllllllIlllllIIlllIlIIIIlIl;
    }
    
    public ColorHolder(final int llllllllllllIlllllIIlllIIIlllIll, final int llllllllllllIlllllIIlllIIIlllIlI, final int llllllllllllIlllllIIlllIIIlllIIl, final int llllllllllllIlllllIIlllIIIlllIII) {
        this.r = llllllllllllIlllllIIlllIIIlllIll;
        this.g = llllllllllllIlllllIIlllIIIlllIlI;
        this.b = llllllllllllIlllllIIlllIIIlllIIl;
        this.a = llllllllllllIlllllIIlllIIIlllIII;
    }
    
    public final int toHex() {
        return 0xFF000000 | (this.r & 0xFF) << 16 | (this.g & 0xFF) << 8 | (this.b & 0xFF);
    }
    
    public final ColorHolder clone() {
        return new ColorHolder(this.r, this.g, this.b, this.a);
    }
    
    public final Color toJavaColour() {
        return new Color(this.r, this.g, this.b, this.a);
    }
    
    public final ColorHolder darker() {
        return new ColorHolder(Math.max(this.r - 10, 0), Math.max(this.g - 10, 0), Math.max(this.b - 10, 0), this.a);
    }
    
    public final void setG(final int llllllllllllIlllllIIlllIlIIIlllI) {
        this.g = llllllllllllIlllllIIlllIlIIIlllI;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllIlllllIIlllIIlIlIIII = this.r;
        llllllllllllIlllllIIlllIIlIlIIII = 31 * llllllllllllIlllllIIlllIIlIlIIII + this.g;
        llllllllllllIlllllIIlllIIlIlIIII = 31 * llllllllllllIlllllIIlllIIlIlIIII + this.b;
        llllllllllllIlllllIIlllIIlIlIIII = 31 * llllllllllllIlllllIIlllIIlIlIIII + this.a;
        return llllllllllllIlllllIIlllIIlIlIIII;
    }
    
    public final int getB() {
        return this.b;
    }
    
    public final void setA(final int llllllllllllIlllllIIlllIIlllllII) {
        this.a = llllllllllllIlllllIIlllIIlllllII;
    }
    
    public final ColorHolder fromHex(final int llllllllllllIlllllIIlllIIllIlIIl) {
        final ColorHolder llllllllllllIlllllIIlllIIllIlIII = new ColorHolder(0, 0, 0);
        llllllllllllIlllllIIlllIIllIlIII.becomeHex(llllllllllllIlllllIIlllIIllIlIIl);
        return llllllllllllIlllllIIlllIIllIlIII;
    }
    
    public ColorHolder(final int llllllllllllIlllllIIlllIIlIIlIII, final int llllllllllllIlllllIIlllIIlIIIIll, final int llllllllllllIlllllIIlllIIlIIIllI) {
        this.r = llllllllllllIlllllIIlllIIlIIlIII;
        this.g = llllllllllllIlllllIIlllIIlIIIIll;
        this.b = llllllllllllIlllllIIlllIIlIIIllI;
        this.a = 255;
    }
    
    public final void becomeHex(final int llllllllllllIlllllIIlllIIllIllIl) {
        this.r = (llllllllllllIlllllIIlllIIllIllIl & 0xFF0000) >> 16;
        this.g = (llllllllllllIlllllIIlllIIllIllIl & 0xFF00) >> 8;
        this.b = (llllllllllllIlllllIIlllIIllIllIl & 0xFF);
        this.a = 255;
    }
    
    public final ColorHolder brighter() {
        return new ColorHolder(Math.min(this.r + 10, 255), Math.min(this.g + 10, 255), Math.min(this.b + 10, 255), this.a);
    }
    
    public ColorHolder(final Color llllllllllllIlllllIIlllIIIlIllll) {
        this.r = llllllllllllIlllllIIlllIIIlIllll.getRed();
        this.g = llllllllllllIlllllIIlllIIIlIllll.getGreen();
        this.b = llllllllllllIlllllIIlllIIIlIllll.getBlue();
        this.a = llllllllllllIlllllIIlllIIIlIllll.getAlpha();
    }
    
    public final void setGLColor() {
        GL11.glColor4f(this.r / 255.0f, this.g / 255.0f, this.b / 255.0f, this.a / 255.0f);
    }
    
    public final int getA() {
        return this.a;
    }
    
    public final void setR(final int llllllllllllIlllllIIlllIlIIlIlll) {
        this.r = llllllllllllIlllllIIlllIlIIlIlll;
    }
    
    public final int getG() {
        return this.g;
    }
    
    public final int getR() {
        return this.r;
    }
}
