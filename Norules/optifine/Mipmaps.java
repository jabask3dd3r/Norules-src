package optifine;

import java.awt.*;
import java.nio.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;

public class Mipmaps
{
    private final /* synthetic */ boolean direct;
    private final /* synthetic */ int[] data;
    private /* synthetic */ Dimension[] mipmapDimensions;
    private final /* synthetic */ int width;
    private /* synthetic */ IntBuffer[] mipmapBuffers;
    private /* synthetic */ int[][] mipmapDatas;
    private final /* synthetic */ int height;
    private final /* synthetic */ String iconName;
    
    private int averageColor(final int lllllllllllllIlIIIIlllllIIllIlIl, final int lllllllllllllIlIIIIlllllIIllIlII) {
        final int lllllllllllllIlIIIIlllllIIllIlll = (lllllllllllllIlIIIIlllllIIllIlIl & 0xFF000000) >> 24 & 0xFF;
        final int lllllllllllllIlIIIIlllllIIllIllI = (lllllllllllllIlIIIIlllllIIllIlII & 0xFF000000) >> 24 & 0xFF;
        return (lllllllllllllIlIIIIlllllIIllIlll + lllllllllllllIlIIIIlllllIIllIllI >> 1 << 24) + ((lllllllllllllIlIIIIlllllIIllIlIl & 0xFEFEFE) + (lllllllllllllIlIIIIlllllIIllIlII & 0xFEFEFE) >> 1);
    }
    
    public Mipmaps(final String lllllllllllllIlIIIIllllllllIIlII, final int lllllllllllllIlIIIIlllllllIlllIl, final int lllllllllllllIlIIIIlllllllIlllII, final int[] lllllllllllllIlIIIIlllllllIllIll, final boolean lllllllllllllIlIIIIlllllllIllIlI) {
        this.iconName = lllllllllllllIlIIIIllllllllIIlII;
        this.width = lllllllllllllIlIIIIlllllllIlllIl;
        this.height = lllllllllllllIlIIIIlllllllIlllII;
        this.data = lllllllllllllIlIIIIlllllllIllIll;
        this.direct = lllllllllllllIlIIIIlllllllIllIlI;
        this.mipmapDimensions = makeMipmapDimensions(lllllllllllllIlIIIIlllllllIlllIl, lllllllllllllIlIIIIlllllllIlllII, lllllllllllllIlIIIIllllllllIIlII);
        this.mipmapDatas = generateMipMapData(lllllllllllllIlIIIIlllllllIllIll, lllllllllllllIlIIIIlllllllIlllIl, lllllllllllllIlIIIIlllllllIlllII, this.mipmapDimensions);
        if (lllllllllllllIlIIIIlllllllIllIlI) {
            this.mipmapBuffers = makeMipmapBuffers(this.mipmapDimensions, this.mipmapDatas);
        }
    }
    
    public static Dimension[] makeMipmapDimensions(final int lllllllllllllIlIIIIlllllllIIIlII, final int lllllllllllllIlIIIIlllllllIIlllI, final String lllllllllllllIlIIIIlllllllIIIIlI) {
        final int lllllllllllllIlIIIIlllllllIIllII = TextureUtils.ceilPowerOfTwo(lllllllllllllIlIIIIlllllllIIIlII);
        final int lllllllllllllIlIIIIlllllllIIlIll = TextureUtils.ceilPowerOfTwo(lllllllllllllIlIIIIlllllllIIlllI);
        if (lllllllllllllIlIIIIlllllllIIllII == lllllllllllllIlIIIIlllllllIIIlII && lllllllllllllIlIIIIlllllllIIlIll == lllllllllllllIlIIIIlllllllIIlllI) {
            final List lllllllllllllIlIIIIlllllllIIlIlI = new ArrayList();
            int lllllllllllllIlIIIIlllllllIIlIIl = lllllllllllllIlIIIIlllllllIIllII;
            int lllllllllllllIlIIIIlllllllIIlIII = lllllllllllllIlIIIIlllllllIIlIll;
            while (true) {
                lllllllllllllIlIIIIlllllllIIlIIl /= 2;
                lllllllllllllIlIIIIlllllllIIlIII /= 2;
                if (lllllllllllllIlIIIIlllllllIIlIIl <= 0 && lllllllllllllIlIIIIlllllllIIlIII <= 0) {
                    break;
                }
                if (lllllllllllllIlIIIIlllllllIIlIIl <= 0) {
                    lllllllllllllIlIIIIlllllllIIlIIl = 1;
                }
                if (lllllllllllllIlIIIIlllllllIIlIII <= 0) {
                    lllllllllllllIlIIIIlllllllIIlIII = 1;
                }
                final int lllllllllllllIlIIIIlllllllIIIllI = lllllllllllllIlIIIIlllllllIIlIIl * lllllllllllllIlIIIIlllllllIIlIII * 4;
                final Dimension lllllllllllllIlIIIIlllllllIIIlIl = new Dimension(lllllllllllllIlIIIIlllllllIIlIIl, lllllllllllllIlIIIIlllllllIIlIII);
                lllllllllllllIlIIIIlllllllIIlIlI.add(lllllllllllllIlIIIIlllllllIIIlIl);
            }
            final Dimension[] lllllllllllllIlIIIIlllllllIIIlll = lllllllllllllIlIIIIlllllllIIlIlI.toArray(new Dimension[lllllllllllllIlIIIIlllllllIIlIlI.size()]);
            return lllllllllllllIlIIIIlllllllIIIlll;
        }
        Config.warn(String.valueOf(new StringBuilder("Mipmaps not possible (power of 2 dimensions needed), texture: ").append(lllllllllllllIlIIIIlllllllIIIIlI).append(", dim: ").append(lllllllllllllIlIIIIlllllllIIIlII).append("x").append(lllllllllllllIlIIIIlllllllIIlllI)));
        return new Dimension[0];
    }
    
    public static IntBuffer[] makeMipmapBuffers(final Dimension[] lllllllllllllIlIIIIlllllIIlIlIIl, final int[][] lllllllllllllIlIIIIlllllIIlIIIII) {
        if (lllllllllllllIlIIIIlllllIIlIlIIl == null) {
            return null;
        }
        final IntBuffer[] lllllllllllllIlIIIIlllllIIlIIlll = new IntBuffer[lllllllllllllIlIIIIlllllIIlIlIIl.length];
        for (int lllllllllllllIlIIIIlllllIIlIIllI = 0; lllllllllllllIlIIIIlllllIIlIIllI < lllllllllllllIlIIIIlllllIIlIlIIl.length; ++lllllllllllllIlIIIIlllllIIlIIllI) {
            final Dimension lllllllllllllIlIIIIlllllIIlIIlIl = lllllllllllllIlIIIIlllllIIlIlIIl[lllllllllllllIlIIIIlllllIIlIIllI];
            final int lllllllllllllIlIIIIlllllIIlIIlII = lllllllllllllIlIIIIlllllIIlIIlIl.width * lllllllllllllIlIIIIlllllIIlIIlIl.height;
            final IntBuffer lllllllllllllIlIIIIlllllIIlIIIll = GLAllocation.createDirectIntBuffer(lllllllllllllIlIIIIlllllIIlIIlII);
            final int[] lllllllllllllIlIIIIlllllIIlIIIlI = lllllllllllllIlIIIIlllllIIlIIIII[lllllllllllllIlIIIIlllllIIlIIllI];
            lllllllllllllIlIIIIlllllIIlIIIll.clear();
            lllllllllllllIlIIIIlllllIIlIIIll.put(lllllllllllllIlIIIIlllllIIlIIIlI);
            lllllllllllllIlIIIIlllllIIlIIIll.clear();
            lllllllllllllIlIIIIlllllIIlIIlll[lllllllllllllIlIIIIlllllIIlIIllI] = lllllllllllllIlIIIIlllllIIlIIIll;
        }
        return lllllllllllllIlIIIIlllllIIlIIlll;
    }
    
    private static int alphaBlend(int lllllllllllllIlIIIIlllllIlIIllII, int lllllllllllllIlIIIIlllllIlIIlIll) {
        int lllllllllllllIlIIIIlllllIlIllIII = (lllllllllllllIlIIIIlllllIlIIllII & 0xFF000000) >> 24 & 0xFF;
        int lllllllllllllIlIIIIlllllIlIlIlll = (lllllllllllllIlIIIIlllllIlIIlIll & 0xFF000000) >> 24 & 0xFF;
        int lllllllllllllIlIIIIlllllIlIlIllI = (lllllllllllllIlIIIIlllllIlIllIII + lllllllllllllIlIIIIlllllIlIlIlll) / 2;
        if (lllllllllllllIlIIIIlllllIlIllIII == 0 && lllllllllllllIlIIIIlllllIlIlIlll == 0) {
            lllllllllllllIlIIIIlllllIlIllIII = 1;
            lllllllllllllIlIIIIlllllIlIlIlll = 1;
        }
        else {
            if (lllllllllllllIlIIIIlllllIlIllIII == 0) {
                lllllllllllllIlIIIIlllllIlIIllII = lllllllllllllIlIIIIlllllIlIIlIll;
                lllllllllllllIlIIIIlllllIlIlIllI /= 2;
            }
            if (lllllllllllllIlIIIIlllllIlIlIlll == 0) {
                lllllllllllllIlIIIIlllllIlIIlIll = lllllllllllllIlIIIIlllllIlIIllII;
                lllllllllllllIlIIIIlllllIlIlIllI /= 2;
            }
        }
        final int lllllllllllllIlIIIIlllllIlIlIlIl = (lllllllllllllIlIIIIlllllIlIIllII >> 16 & 0xFF) * lllllllllllllIlIIIIlllllIlIllIII;
        final int lllllllllllllIlIIIIlllllIlIlIlII = (lllllllllllllIlIIIIlllllIlIIllII >> 8 & 0xFF) * lllllllllllllIlIIIIlllllIlIllIII;
        final int lllllllllllllIlIIIIlllllIlIlIIll = (lllllllllllllIlIIIIlllllIlIIllII & 0xFF) * lllllllllllllIlIIIIlllllIlIllIII;
        final int lllllllllllllIlIIIIlllllIlIlIIlI = (lllllllllllllIlIIIIlllllIlIIlIll >> 16 & 0xFF) * lllllllllllllIlIIIIlllllIlIlIlll;
        final int lllllllllllllIlIIIIlllllIlIlIIIl = (lllllllllllllIlIIIIlllllIlIIlIll >> 8 & 0xFF) * lllllllllllllIlIIIIlllllIlIlIlll;
        final int lllllllllllllIlIIIIlllllIlIlIIII = (lllllllllllllIlIIIIlllllIlIIlIll & 0xFF) * lllllllllllllIlIIIIlllllIlIlIlll;
        final int lllllllllllllIlIIIIlllllIlIIllll = (lllllllllllllIlIIIIlllllIlIlIlIl + lllllllllllllIlIIIIlllllIlIlIIlI) / (lllllllllllllIlIIIIlllllIlIllIII + lllllllllllllIlIIIIlllllIlIlIlll);
        final int lllllllllllllIlIIIIlllllIlIIlllI = (lllllllllllllIlIIIIlllllIlIlIlII + lllllllllllllIlIIIIlllllIlIlIIIl) / (lllllllllllllIlIIIIlllllIlIllIII + lllllllllllllIlIIIIlllllIlIlIlll);
        final int lllllllllllllIlIIIIlllllIlIIllIl = (lllllllllllllIlIIIIlllllIlIlIIll + lllllllllllllIlIIIIlllllIlIlIIII) / (lllllllllllllIlIIIIlllllIlIllIII + lllllllllllllIlIIIIlllllIlIlIlll);
        return lllllllllllllIlIIIIlllllIlIlIllI << 24 | lllllllllllllIlIIIIlllllIlIIllll << 16 | lllllllllllllIlIIIIlllllIlIIlllI << 8 | lllllllllllllIlIIIIlllllIlIIllIl;
    }
    
    public static int alphaBlend(final int lllllllllllllIlIIIIlllllIllIllll, final int lllllllllllllIlIIIIlllllIllIlllI, final int lllllllllllllIlIIIIlllllIllIllIl, final int lllllllllllllIlIIIIlllllIllIllII) {
        final int lllllllllllllIlIIIIlllllIlllIIlI = alphaBlend(lllllllllllllIlIIIIlllllIllIllll, lllllllllllllIlIIIIlllllIllIlllI);
        final int lllllllllllllIlIIIIlllllIlllIIIl = alphaBlend(lllllllllllllIlIIIIlllllIllIllIl, lllllllllllllIlIIIIlllllIllIllII);
        final int lllllllllllllIlIIIIlllllIlllIIII = alphaBlend(lllllllllllllIlIIIIlllllIlllIIlI, lllllllllllllIlIIIIlllllIlllIIIl);
        return lllllllllllllIlIIIIlllllIlllIIII;
    }
    
    public static void allocateMipmapTextures(final int lllllllllllllIlIIIIlllllIIIlIIII, final int lllllllllllllIlIIIIlllllIIIIllll, final String lllllllllllllIlIIIIlllllIIIIIlIl) {
        final Dimension[] lllllllllllllIlIIIIlllllIIIIllIl = makeMipmapDimensions(lllllllllllllIlIIIIlllllIIIlIIII, lllllllllllllIlIIIIlllllIIIIllll, lllllllllllllIlIIIIlllllIIIIIlIl);
        for (int lllllllllllllIlIIIIlllllIIIIllII = 0; lllllllllllllIlIIIIlllllIIIIllII < lllllllllllllIlIIIIlllllIIIIllIl.length; ++lllllllllllllIlIIIIlllllIIIIllII) {
            final Dimension lllllllllllllIlIIIIlllllIIIIlIll = lllllllllllllIlIIIIlllllIIIIllIl[lllllllllllllIlIIIIlllllIIIIllII];
            final int lllllllllllllIlIIIIlllllIIIIlIlI = lllllllllllllIlIIIIlllllIIIIlIll.width;
            final int lllllllllllllIlIIIIlllllIIIIlIIl = lllllllllllllIlIIIIlllllIIIIlIll.height;
            final int lllllllllllllIlIIIIlllllIIIIlIII = lllllllllllllIlIIIIlllllIIIIllII + 1;
            GL11.glTexImage2D(3553, lllllllllllllIlIIIIlllllIIIIlIII, 6408, lllllllllllllIlIIIIlllllIIIIlIlI, lllllllllllllIlIIIIlllllIIIIlIIl, 0, 32993, 33639, (IntBuffer)null);
        }
    }
    
    public static int[][] generateMipMapData(final int[] lllllllllllllIlIIIIllllllIIlIIIl, final int lllllllllllllIlIIIIllllllIIlIIII, final int lllllllllllllIlIIIIllllllIlIIlII, final Dimension[] lllllllllllllIlIIIIllllllIIIllll) {
        int[] lllllllllllllIlIIIIllllllIlIIIlI = lllllllllllllIlIIIIllllllIIlIIIl;
        int lllllllllllllIlIIIIllllllIlIIIIl = lllllllllllllIlIIIIllllllIIlIIII;
        boolean lllllllllllllIlIIIIllllllIlIIIII = true;
        final int[][] lllllllllllllIlIIIIllllllIIlllll = new int[lllllllllllllIlIIIIllllllIIIllll.length][];
        for (int lllllllllllllIlIIIIllllllIIllllI = 0; lllllllllllllIlIIIIllllllIIllllI < lllllllllllllIlIIIIllllllIIIllll.length; ++lllllllllllllIlIIIIllllllIIllllI) {
            final Dimension lllllllllllllIlIIIIllllllIIlllIl = lllllllllllllIlIIIIllllllIIIllll[lllllllllllllIlIIIIllllllIIllllI];
            final int lllllllllllllIlIIIIllllllIIlllII = lllllllllllllIlIIIIllllllIIlllIl.width;
            final int lllllllllllllIlIIIIllllllIIllIll = lllllllllllllIlIIIIllllllIIlllIl.height;
            final int[] lllllllllllllIlIIIIllllllIIllIlI = new int[lllllllllllllIlIIIIllllllIIlllII * lllllllllllllIlIIIIllllllIIllIll];
            lllllllllllllIlIIIIllllllIIlllll[lllllllllllllIlIIIIllllllIIllllI] = lllllllllllllIlIIIIllllllIIllIlI;
            final int lllllllllllllIlIIIIllllllIIllIIl = lllllllllllllIlIIIIllllllIIllllI + 1;
            if (lllllllllllllIlIIIIllllllIlIIIII) {
                for (int lllllllllllllIlIIIIllllllIIllIII = 0; lllllllllllllIlIIIIllllllIIllIII < lllllllllllllIlIIIIllllllIIlllII; ++lllllllllllllIlIIIIllllllIIllIII) {
                    for (int lllllllllllllIlIIIIllllllIIlIlll = 0; lllllllllllllIlIIIIllllllIIlIlll < lllllllllllllIlIIIIllllllIIllIll; ++lllllllllllllIlIIIIllllllIIlIlll) {
                        final int lllllllllllllIlIIIIllllllIIlIllI = lllllllllllllIlIIIIllllllIlIIIlI[lllllllllllllIlIIIIllllllIIllIII * 2 + 0 + (lllllllllllllIlIIIIllllllIIlIlll * 2 + 0) * lllllllllllllIlIIIIllllllIlIIIIl];
                        final int lllllllllllllIlIIIIllllllIIlIlIl = lllllllllllllIlIIIIllllllIlIIIlI[lllllllllllllIlIIIIllllllIIllIII * 2 + 1 + (lllllllllllllIlIIIIllllllIIlIlll * 2 + 0) * lllllllllllllIlIIIIllllllIlIIIIl];
                        final int lllllllllllllIlIIIIllllllIIlIlII = lllllllllllllIlIIIIllllllIlIIIlI[lllllllllllllIlIIIIllllllIIllIII * 2 + 1 + (lllllllllllllIlIIIIllllllIIlIlll * 2 + 1) * lllllllllllllIlIIIIllllllIlIIIIl];
                        final int lllllllllllllIlIIIIllllllIIlIIll = lllllllllllllIlIIIIllllllIlIIIlI[lllllllllllllIlIIIIllllllIIllIII * 2 + 0 + (lllllllllllllIlIIIIllllllIIlIlll * 2 + 1) * lllllllllllllIlIIIIllllllIlIIIIl];
                        final int lllllllllllllIlIIIIllllllIIlIIlI = alphaBlend(lllllllllllllIlIIIIllllllIIlIllI, lllllllllllllIlIIIIllllllIIlIlIl, lllllllllllllIlIIIIllllllIIlIlII, lllllllllllllIlIIIIllllllIIlIIll);
                        lllllllllllllIlIIIIllllllIIllIlI[lllllllllllllIlIIIIllllllIIllIII + lllllllllllllIlIIIIllllllIIlIlll * lllllllllllllIlIIIIllllllIIlllII] = lllllllllllllIlIIIIllllllIIlIIlI;
                    }
                }
            }
            lllllllllllllIlIIIIllllllIlIIIlI = lllllllllllllIlIIIIllllllIIllIlI;
            lllllllllllllIlIIIIllllllIlIIIIl = lllllllllllllIlIIIIllllllIIlllII;
            if (lllllllllllllIlIIIIllllllIIlllII <= 1 || lllllllllllllIlIIIIllllllIIllIll <= 1) {
                lllllllllllllIlIIIIllllllIlIIIII = false;
            }
        }
        return lllllllllllllIlIIIIllllllIIlllll;
    }
}
