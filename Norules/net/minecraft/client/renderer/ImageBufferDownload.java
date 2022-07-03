package net.minecraft.client.renderer;

import java.awt.image.*;
import java.awt.*;
import javax.annotation.*;

public class ImageBufferDownload implements IImageBuffer
{
    private /* synthetic */ int[] imageData;
    private /* synthetic */ int imageWidth;
    private /* synthetic */ int imageHeight;
    
    private void doTransparencyHack(final int llllllllllllllllIllllIlIllllIllI, final int llllllllllllllllIllllIlIllllIlIl, final int llllllllllllllllIllllIlIllllIlII, final int llllllllllllllllIllllIlIllllIIll) {
        for (int llllllllllllllllIllllIlIllllIIlI = llllllllllllllllIllllIlIllllIllI; llllllllllllllllIllllIlIllllIIlI < llllllllllllllllIllllIlIllllIlII; ++llllllllllllllllIllllIlIllllIIlI) {
            for (int llllllllllllllllIllllIlIllllIIIl = llllllllllllllllIllllIlIllllIlIl; llllllllllllllllIllllIlIllllIIIl < llllllllllllllllIllllIlIllllIIll; ++llllllllllllllllIllllIlIllllIIIl) {
                final int llllllllllllllllIllllIlIllllIIII = this.imageData[llllllllllllllllIllllIlIllllIIlI + llllllllllllllllIllllIlIllllIIIl * this.imageWidth];
                if ((llllllllllllllllIllllIlIllllIIII >> 24 & 0xFF) < 128) {
                    return;
                }
            }
        }
        for (int llllllllllllllllIllllIlIlllIllll = llllllllllllllllIllllIlIllllIllI; llllllllllllllllIllllIlIlllIllll < llllllllllllllllIllllIlIllllIlII; ++llllllllllllllllIllllIlIlllIllll) {
            for (int llllllllllllllllIllllIlIlllIlllI = llllllllllllllllIllllIlIllllIlIl; llllllllllllllllIllllIlIlllIlllI < llllllllllllllllIllllIlIllllIIll; ++llllllllllllllllIllllIlIlllIlllI) {
                final int[] imageData = this.imageData;
                final int n = llllllllllllllllIllllIlIlllIllll + llllllllllllllllIllllIlIlllIlllI * this.imageWidth;
                imageData[n] &= 0xFFFFFF;
            }
        }
    }
    
    @Override
    public void skinAvailable() {
    }
    
    @Nullable
    @Override
    public BufferedImage parseUserSkin(final BufferedImage llllllllllllllllIllllIllIIIIIlll) {
        if (llllllllllllllllIllllIllIIIIIlll == null) {
            return null;
        }
        this.imageWidth = 64;
        this.imageHeight = 64;
        final int llllllllllllllllIllllIllIIIIlllI = llllllllllllllllIllllIllIIIIIlll.getWidth();
        final int llllllllllllllllIllllIllIIIIllIl = llllllllllllllllIllllIllIIIIIlll.getHeight();
        int llllllllllllllllIllllIllIIIIllII = 1;
        while (this.imageWidth < llllllllllllllllIllllIllIIIIlllI || this.imageHeight < llllllllllllllllIllllIllIIIIllIl) {
            this.imageWidth *= 2;
            this.imageHeight *= 2;
            llllllllllllllllIllllIllIIIIllII *= 2;
        }
        final BufferedImage llllllllllllllllIllllIllIIIIlIll = new BufferedImage(this.imageWidth, this.imageHeight, 2);
        final Graphics llllllllllllllllIllllIllIIIIlIlI = llllllllllllllllIllllIllIIIIlIll.getGraphics();
        llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIIlll, 0, 0, null);
        final boolean llllllllllllllllIllllIllIIIIlIIl = llllllllllllllllIllllIllIIIIIlll.getHeight() == 32 * llllllllllllllllIllllIllIIIIllII;
        if (llllllllllllllllIllllIllIIIIlIIl) {
            llllllllllllllllIllllIllIIIIlIlI.setColor(new Color(0, 0, 0, 0));
            llllllllllllllllIllllIllIIIIlIlI.fillRect(0 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 24 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 4 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 8 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 28 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 24 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 8 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 12 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 20 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 8 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 12 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 24 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 4 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 8 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 28 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 24 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 0 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 4 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 32 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 28 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 12 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 40 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 36 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 44 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 44 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 40 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 36 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 40 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 36 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 44 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 44 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 40 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 40 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 44 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
            llllllllllllllllIllllIllIIIIlIlI.drawImage(llllllllllllllllIllllIllIIIIlIll, 48 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 44 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 52 * llllllllllllllllIllllIllIIIIllII, 20 * llllllllllllllllIllllIllIIIIllII, 56 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, null);
        }
        llllllllllllllllIllllIllIIIIlIlI.dispose();
        this.imageData = ((DataBufferInt)llllllllllllllllIllllIllIIIIlIll.getRaster().getDataBuffer()).getData();
        this.setAreaOpaque(0 * llllllllllllllllIllllIllIIIIllII, 0 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII);
        if (llllllllllllllllIllllIllIIIIlIIl) {
            this.doTransparencyHack(32 * llllllllllllllllIllllIllIIIIllII, 0 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII);
        }
        this.setAreaOpaque(0 * llllllllllllllllIllllIllIIIIllII, 16 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII, 32 * llllllllllllllllIllllIllIIIIllII);
        this.setAreaOpaque(16 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 48 * llllllllllllllllIllllIllIIIIllII, 64 * llllllllllllllllIllllIllIIIIllII);
        return llllllllllllllllIllllIllIIIIlIll;
    }
    
    private void setAreaOpaque(final int llllllllllllllllIllllIlIllIlllIl, final int llllllllllllllllIllllIlIllIlIlIl, final int llllllllllllllllIllllIlIllIllIll, final int llllllllllllllllIllllIlIllIllIlI) {
        for (int llllllllllllllllIllllIlIllIllIIl = llllllllllllllllIllllIlIllIlllIl; llllllllllllllllIllllIlIllIllIIl < llllllllllllllllIllllIlIllIllIll; ++llllllllllllllllIllllIlIllIllIIl) {
            for (int llllllllllllllllIllllIlIllIllIII = llllllllllllllllIllllIlIllIlIlIl; llllllllllllllllIllllIlIllIllIII < llllllllllllllllIllllIlIllIllIlI; ++llllllllllllllllIllllIlIllIllIII) {
                final int[] imageData = this.imageData;
                final int n = llllllllllllllllIllllIlIllIllIIl + llllllllllllllllIllllIlIllIllIII * this.imageWidth;
                imageData[n] |= 0xFF000000;
            }
        }
    }
}
