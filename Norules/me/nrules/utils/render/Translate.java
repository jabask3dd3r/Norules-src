package me.nrules.utils.render;

public class Translate
{
    private /* synthetic */ float y;
    private /* synthetic */ long lastMS;
    private /* synthetic */ float x;
    
    public void setY(final float lllllllllllllIIlllllIIIIIlllIlIl) {
        this.y = lllllllllllllIIlllllIIIIIlllIlIl;
    }
    
    public float getX() {
        return this.x;
    }
    
    public void setX(final float lllllllllllllIIlllllIIIIlIIIIIII) {
        this.x = lllllllllllllIIlllllIIIIlIIIIIII;
    }
    
    public void interpolate(final float lllllllllllllIIlllllIIIIlIlIIlII, final float lllllllllllllIIlllllIIIIlIlIllII, final int lllllllllllllIIlllllIIIIlIlIlIll, final int lllllllllllllIIlllllIIIIlIlIlIlI) {
        final long lllllllllllllIIlllllIIIIlIlIlIIl = System.currentTimeMillis();
        final long lllllllllllllIIlllllIIIIlIlIlIII = lllllllllllllIIlllllIIIIlIlIlIIl - this.lastMS;
        this.lastMS = lllllllllllllIIlllllIIIIlIlIlIIl;
        final int lllllllllllllIIlllllIIIIlIlIIlll = (int)(Math.abs(lllllllllllllIIlllllIIIIlIlIIlII - this.x) * 0.51f);
        final int lllllllllllllIIlllllIIIIlIlIIllI = (int)(Math.abs(lllllllllllllIIlllllIIIIlIlIllII - this.y) * 0.51f);
        this.x = AnimUtils.calculateCompensation(lllllllllllllIIlllllIIIIlIlIIlII, this.x, lllllllllllllIIlllllIIIIlIlIlIII, lllllllllllllIIlllllIIIIlIlIIlll);
        this.y = AnimUtils.calculateCompensation(lllllllllllllIIlllllIIIIlIlIllII, this.y, lllllllllllllIIlllllIIIIlIlIlIII, lllllllllllllIIlllllIIIIlIlIIllI);
    }
    
    public float getY() {
        return this.y;
    }
    
    public void interpolate(final float lllllllllllllIIlllllIIIIlIIIllIl, final float lllllllllllllIIlllllIIIIlIIlIlII, final double lllllllllllllIIlllllIIIIlIIlIIll) {
        final long lllllllllllllIIlllllIIIIlIIlIIlI = System.currentTimeMillis();
        final long lllllllllllllIIlllllIIIIlIIlIIIl = lllllllllllllIIlllllIIIIlIIlIIlI - this.lastMS;
        this.lastMS = lllllllllllllIIlllllIIIIlIIlIIlI;
        double lllllllllllllIIlllllIIIIlIIlIIII = 0.0;
        double lllllllllllllIIlllllIIIIlIIIllll = 0.0;
        if (lllllllllllllIIlllllIIIIlIIlIIll != 0.0) {
            lllllllllllllIIlllllIIIIlIIlIIII = Math.abs(lllllllllllllIIlllllIIIIlIIIllIl - this.x) * 0.35f / (10.0 / lllllllllllllIIlllllIIIIlIIlIIll);
            lllllllllllllIIlllllIIIIlIIIllll = Math.abs(lllllllllllllIIlllllIIIIlIIlIlII - this.y) * 0.35f / (10.0 / lllllllllllllIIlllllIIIIlIIlIIll);
        }
        this.x = AnimUtils.calculateCompensation(lllllllllllllIIlllllIIIIlIIIllIl, this.x, lllllllllllllIIlllllIIIIlIIlIIIl, lllllllllllllIIlllllIIIIlIIlIIII);
        this.y = AnimUtils.calculateCompensation(lllllllllllllIIlllllIIIIlIIlIlII, this.y, lllllllllllllIIlllllIIIIlIIlIIIl, lllllllllllllIIlllllIIIIlIIIllll);
    }
    
    public Translate(final float lllllllllllllIIlllllIIIllIIIlllI, final float lllllllllllllIIlllllIIIllIIlIIII) {
        this.x = lllllllllllllIIlllllIIIllIIIlllI;
        this.y = lllllllllllllIIlllllIIIllIIlIIII;
        this.lastMS = System.currentTimeMillis();
    }
}
