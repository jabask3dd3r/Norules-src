package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.util.math.*;

public class ScaledResolution
{
    private /* synthetic */ int scaleFactor;
    private final /* synthetic */ double scaledWidthD;
    private /* synthetic */ int scaledHeight;
    public static /* synthetic */ int scaledWidth;
    private final /* synthetic */ double scaledHeightD;
    
    public double getScaledWidth_double() {
        return this.scaledWidthD;
    }
    
    public ScaledResolution(final Minecraft lllllllllllllIllIIIIIlIIlIlIIIII) {
        ScaledResolution.scaledWidth = lllllllllllllIllIIIIIlIIlIlIIIII.displayWidth;
        this.scaledHeight = lllllllllllllIllIIIIIlIIlIlIIIII.displayHeight;
        this.scaleFactor = 1;
        final boolean lllllllllllllIllIIIIIlIIlIIlllll = lllllllllllllIllIIIIIlIIlIlIIIII.isUnicode();
        int lllllllllllllIllIIIIIlIIlIIllllI = lllllllllllllIllIIIIIlIIlIlIIIII.gameSettings.guiScale;
        if (lllllllllllllIllIIIIIlIIlIIllllI == 0) {
            lllllllllllllIllIIIIIlIIlIIllllI = 1000;
        }
        while (this.scaleFactor < lllllllllllllIllIIIIIlIIlIIllllI && ScaledResolution.scaledWidth / (this.scaleFactor + 1) >= 320 && this.scaledHeight / (this.scaleFactor + 1) >= 240) {
            ++this.scaleFactor;
        }
        if (lllllllllllllIllIIIIIlIIlIIlllll && this.scaleFactor % 2 != 0 && this.scaleFactor != 1) {
            --this.scaleFactor;
        }
        this.scaledWidthD = ScaledResolution.scaledWidth / (double)this.scaleFactor;
        this.scaledHeightD = this.scaledHeight / (double)this.scaleFactor;
        ScaledResolution.scaledWidth = MathHelper.ceil(this.scaledWidthD);
        this.scaledHeight = MathHelper.ceil(this.scaledHeightD);
    }
    
    public int getScaledWidth() {
        return ScaledResolution.scaledWidth;
    }
    
    public int getScaledHeight() {
        return this.scaledHeight;
    }
    
    public double getScaledHeight_double() {
        return this.scaledHeightD;
    }
    
    public int getScaleFactor() {
        return this.scaleFactor;
    }
}
