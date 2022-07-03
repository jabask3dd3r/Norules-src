package com.viaversion.viabackwards.protocol.protocol1_10to1_11.storage;

public class ChestedHorseStorage
{
    private /* synthetic */ int liamaVariant;
    private /* synthetic */ boolean chested;
    private /* synthetic */ int liamaCarpetColor;
    private /* synthetic */ int liamaStrength;
    
    public boolean isChested() {
        return this.chested;
    }
    
    public void setLiamaVariant(final int lllllllllllllIllllIIllllIIllIlII) {
        this.liamaVariant = lllllllllllllIllllIIllllIIllIlII;
    }
    
    public int getLiamaVariant() {
        return this.liamaVariant;
    }
    
    public int getLiamaStrength() {
        return this.liamaStrength;
    }
    
    public void setLiamaCarpetColor(final int lllllllllllllIllllIIllllIIllllIl) {
        this.liamaCarpetColor = lllllllllllllIllllIIllllIIllllIl;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("ChestedHorseStorage{chested=").append(this.chested).append(", liamaStrength=").append(this.liamaStrength).append(", liamaCarpetColor=").append(this.liamaCarpetColor).append(", liamaVariant=").append(this.liamaVariant).append('}'));
    }
    
    public ChestedHorseStorage() {
        this.liamaCarpetColor = -1;
    }
    
    public void setChested(final boolean lllllllllllllIllllIIllllIlIIllll) {
        this.chested = lllllllllllllIllllIIllllIlIIllll;
    }
    
    public void setLiamaStrength(final int lllllllllllllIllllIIllllIlIIIlII) {
        this.liamaStrength = lllllllllllllIllllIIllllIlIIIlII;
    }
    
    public int getLiamaCarpetColor() {
        return this.liamaCarpetColor;
    }
}
