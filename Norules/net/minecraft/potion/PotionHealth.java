package net.minecraft.potion;

public class PotionHealth extends Potion
{
    @Override
    public boolean isInstant() {
        return true;
    }
    
    public PotionHealth(final boolean lllllllllllllllIlIIlIlIIllIlIlll, final int lllllllllllllllIlIIlIlIIllIllIIl) {
        super(lllllllllllllllIlIIlIlIIllIlIlll, lllllllllllllllIlIIlIlIIllIllIIl);
    }
    
    @Override
    public boolean isReady(final int lllllllllllllllIlIIlIlIIllIlIIlI, final int lllllllllllllllIlIIlIlIIllIlIIIl) {
        return lllllllllllllllIlIIlIlIIllIlIIlI >= 1;
    }
}
