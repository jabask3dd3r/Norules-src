package me.nrules.utils.render;

public final class Shifting
{
    private /* synthetic */ double y;
    private /* synthetic */ double x;
    
    public double getX() {
        return this.x;
    }
    
    public final void interpolate(final double lllllllllllllIIIIIIlIIIllIIlIIll, final double lllllllllllllIIIIIIlIIIllIIlIIlI, final double lllllllllllllIIIIIIlIIIllIIlIIIl) {
        this.x = AnimUtils.animate(lllllllllllllIIIIIIlIIIllIIlIIll, this.x, lllllllllllllIIIIIIlIIIllIIlIIIl);
        this.y = AnimUtils.animate(lllllllllllllIIIIIIlIIIllIIlIIlI, this.y, lllllllllllllIIIIIIlIIIllIIlIIIl);
    }
    
    public void animate(final double lllllllllllllIIIIIIlIIIllIIIlIII, final double lllllllllllllIIIIIIlIIIllIIIIlll) {
        this.x = AnimUtils.animate(this.x, lllllllllllllIIIIIIlIIIllIIIlIII, 1.0);
        this.y = AnimUtils.animate(this.y, lllllllllllllIIIIIIlIIIllIIIIlll, 1.0);
    }
    
    public double getY() {
        return this.y;
    }
    
    public Shifting(final float lllllllllllllIIIIIIlIIIllIIllIlI, final float lllllllllllllIIIIIIlIIIllIIlllII) {
        this.x = lllllllllllllIIIIIIlIIIllIIllIlI;
        this.y = lllllllllllllIIIIIIlIIIllIIlllII;
    }
    
    public void setY(final double lllllllllllllIIIIIIlIIIlIlllIlII) {
        this.y = lllllllllllllIIIIIIlIIIlIlllIlII;
    }
    
    public void setX(final double lllllllllllllIIIIIIlIIIlIlllllIl) {
        this.x = lllllllllllllIIIIIIlIIIlIlllllIl;
    }
}
