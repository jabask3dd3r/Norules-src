package net.minecraft.util;

public class MouseFilter
{
    private /* synthetic */ float targetValue;
    private /* synthetic */ float remainingValue;
    private /* synthetic */ float lastAmount;
    
    public void reset() {
        this.targetValue = 0.0f;
        this.remainingValue = 0.0f;
        this.lastAmount = 0.0f;
    }
    
    public float smooth(float lllllllllllllIllllIlIIlIIIIlllIl, final float lllllllllllllIllllIlIIlIIIIlllII) {
        this.targetValue += lllllllllllllIllllIlIIlIIIIlllIl;
        lllllllllllllIllllIlIIlIIIIlllIl = (this.targetValue - this.remainingValue) * lllllllllllllIllllIlIIlIIIIlllII;
        this.lastAmount += (lllllllllllllIllllIlIIlIIIIlllIl - this.lastAmount) * 0.5f;
        if ((lllllllllllllIllllIlIIlIIIIlllIl > 0.0f && lllllllllllllIllllIlIIlIIIIlllIl > this.lastAmount) || (lllllllllllllIllllIlIIlIIIIlllIl < 0.0f && lllllllllllllIllllIlIIlIIIIlllIl < this.lastAmount)) {
            lllllllllllllIllllIlIIlIIIIlllIl = this.lastAmount;
        }
        this.remainingValue += lllllllllllllIllllIlIIlIIIIlllIl;
        return lllllllllllllIllllIlIIlIIIIlllIl;
    }
}
