package net.minecraft.client.renderer.texture;

import java.nio.*;
import java.awt.image.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import optifine.*;
import net.minecraft.client.*;

public class TextureUtil
{
    public static final /* synthetic */ int[] MISSING_TEXTURE_DATA;
    private static final /* synthetic */ IntBuffer DATA_BUFFER;
    public static final /* synthetic */ DynamicTexture MISSING_TEXTURE;
    private static final /* synthetic */ float[] COLOR_GAMMAS;
    
    public static int[][] generateMipmapData(final int llllllllllllllIIllIlIIlIlIllIIII, final int llllllllllllllIIllIlIIlIlIlIIIII, final int[][] llllllllllllllIIllIlIIlIlIIlllll) {
        final int[][] llllllllllllllIIllIlIIlIlIlIllIl = new int[llllllllllllllIIllIlIIlIlIllIIII + 1][];
        llllllllllllllIIllIlIIlIlIlIllIl[0] = llllllllllllllIIllIlIIlIlIIlllll[0];
        if (llllllllllllllIIllIlIIlIlIllIIII > 0) {
            boolean llllllllllllllIIllIlIIlIlIlIllII = false;
            for (int llllllllllllllIIllIlIIlIlIlIlIll = 0; llllllllllllllIIllIlIIlIlIlIlIll < llllllllllllllIIllIlIIlIlIIlllll.length; ++llllllllllllllIIllIlIIlIlIlIlIll) {
                if (llllllllllllllIIllIlIIlIlIIlllll[0][llllllllllllllIIllIlIIlIlIlIlIll] >> 24 == 0) {
                    llllllllllllllIIllIlIIlIlIlIllII = true;
                    break;
                }
            }
            for (int llllllllllllllIIllIlIIlIlIlIlIlI = 1; llllllllllllllIIllIlIIlIlIlIlIlI <= llllllllllllllIIllIlIIlIlIllIIII; ++llllllllllllllIIllIlIIlIlIlIlIlI) {
                if (llllllllllllllIIllIlIIlIlIIlllll[llllllllllllllIIllIlIIlIlIlIlIlI] != null) {
                    llllllllllllllIIllIlIIlIlIlIllIl[llllllllllllllIIllIlIIlIlIlIlIlI] = llllllllllllllIIllIlIIlIlIIlllll[llllllllllllllIIllIlIIlIlIlIlIlI];
                }
                else {
                    final int[] llllllllllllllIIllIlIIlIlIlIlIIl = llllllllllllllIIllIlIIlIlIlIllIl[llllllllllllllIIllIlIIlIlIlIlIlI - 1];
                    final int[] llllllllllllllIIllIlIIlIlIlIlIII = new int[llllllllllllllIIllIlIIlIlIlIlIIl.length >> 2];
                    final int llllllllllllllIIllIlIIlIlIlIIlll = llllllllllllllIIllIlIIlIlIlIIIII >> llllllllllllllIIllIlIIlIlIlIlIlI;
                    final int llllllllllllllIIllIlIIlIlIlIIllI = llllllllllllllIIllIlIIlIlIlIlIII.length / llllllllllllllIIllIlIIlIlIlIIlll;
                    final int llllllllllllllIIllIlIIlIlIlIIlIl = llllllllllllllIIllIlIIlIlIlIIlll << 1;
                    for (int llllllllllllllIIllIlIIlIlIlIIlII = 0; llllllllllllllIIllIlIIlIlIlIIlII < llllllllllllllIIllIlIIlIlIlIIlll; ++llllllllllllllIIllIlIIlIlIlIIlII) {
                        for (int llllllllllllllIIllIlIIlIlIlIIIll = 0; llllllllllllllIIllIlIIlIlIlIIIll < llllllllllllllIIllIlIIlIlIlIIllI; ++llllllllllllllIIllIlIIlIlIlIIIll) {
                            final int llllllllllllllIIllIlIIlIlIlIIIlI = 2 * (llllllllllllllIIllIlIIlIlIlIIlII + llllllllllllllIIllIlIIlIlIlIIIll * llllllllllllllIIllIlIIlIlIlIIlIl);
                            llllllllllllllIIllIlIIlIlIlIlIII[llllllllllllllIIllIlIIlIlIlIIlII + llllllllllllllIIllIlIIlIlIlIIIll * llllllllllllllIIllIlIIlIlIlIIlll] = blendColors(llllllllllllllIIllIlIIlIlIlIlIIl[llllllllllllllIIllIlIIlIlIlIIIlI + 0], llllllllllllllIIllIlIIlIlIlIlIIl[llllllllllllllIIllIlIIlIlIlIIIlI + 1], llllllllllllllIIllIlIIlIlIlIlIIl[llllllllllllllIIllIlIIlIlIlIIIlI + 0 + llllllllllllllIIllIlIIlIlIlIIlIl], llllllllllllllIIllIlIIlIlIlIlIIl[llllllllllllllIIllIlIIlIlIlIIIlI + 1 + llllllllllllllIIllIlIIlIlIlIIlIl], llllllllllllllIIllIlIIlIlIlIllII);
                        }
                    }
                    llllllllllllllIIllIlIIlIlIlIllIl[llllllllllllllIIllIlIIlIlIlIlIlI] = llllllllllllllIIllIlIIlIlIlIlIII;
                }
            }
        }
        return llllllllllllllIIllIlIIlIlIlIllIl;
    }
    
    private static void uploadTextureSub(final int llllllllllllllIIllIlIIlIIIllIIIl, final int[] llllllllllllllIIllIlIIlIIIlllllI, final int llllllllllllllIIllIlIIlIIIlIllll, final int llllllllllllllIIllIlIIlIIIllllII, final int llllllllllllllIIllIlIIlIIIlIllIl, final int llllllllllllllIIllIlIIlIIIlllIlI, final boolean llllllllllllllIIllIlIIlIIIlllIIl, final boolean llllllllllllllIIllIlIIlIIIlIlIlI, final boolean llllllllllllllIIllIlIIlIIIlIlIIl) {
        final int llllllllllllllIIllIlIIlIIIllIllI = 4194304 / llllllllllllllIIllIlIIlIIIlIllll;
        setTextureBlurMipmap(llllllllllllllIIllIlIIlIIIlllIIl, llllllllllllllIIllIlIIlIIIlIlIIl);
        setTextureClamped(llllllllllllllIIllIlIIlIIIlIlIlI);
        int llllllllllllllIIllIlIIlIIIllIlIl;
        for (int llllllllllllllIIllIlIIlIIIllIlII = 0; llllllllllllllIIllIlIIlIIIllIlII < llllllllllllllIIllIlIIlIIIlIllll * llllllllllllllIIllIlIIlIIIllllII; llllllllllllllIIllIlIIlIIIllIlII += llllllllllllllIIllIlIIlIIIlIllll * llllllllllllllIIllIlIIlIIIllIlIl) {
            final int llllllllllllllIIllIlIIlIIIllIIll = llllllllllllllIIllIlIIlIIIllIlII / llllllllllllllIIllIlIIlIIIlIllll;
            llllllllllllllIIllIlIIlIIIllIlIl = Math.min(llllllllllllllIIllIlIIlIIIllIllI, llllllllllllllIIllIlIIlIIIllllII - llllllllllllllIIllIlIIlIIIllIIll);
            final int llllllllllllllIIllIlIIlIIIllIIlI = llllllllllllllIIllIlIIlIIIlIllll * llllllllllllllIIllIlIIlIIIllIlIl;
            copyToBufferPos(llllllllllllllIIllIlIIlIIIlllllI, llllllllllllllIIllIlIIlIIIllIlII, llllllllllllllIIllIlIIlIIIllIIlI);
            GlStateManager.glTexSubImage2D(3553, llllllllllllllIIllIlIIlIIIllIIIl, llllllllllllllIIllIlIIlIIIlIllIl, llllllllllllllIIllIlIIlIIIlllIlI + llllllllllllllIIllIlIIlIIIllIIll, llllllllllllllIIllIlIIlIIIlIllll, llllllllllllllIIllIlIIlIIIllIlIl, 32993, 33639, TextureUtil.DATA_BUFFER);
        }
    }
    
    public static BufferedImage readBufferedImage(final InputStream llllllllllllllIIllIlIIIlIllllIIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: aload_0         /* llllllllllllllIIllIlIIIlIlllllII */
        //     7: invokestatic    javax/imageio/ImageIO.read:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    10: astore_1        /* llllllllllllllIIllIlIIIlIllllIII */
        //    11: goto            21
        //    14: astore_2        /* llllllllllllllIIllIlIIIlIlllIlll */
        //    15: aload_0         /* llllllllllllllIIllIlIIIlIlllllII */
        //    16: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    19: aload_2         /* llllllllllllllIIllIlIIIlIlllIlll */
        //    20: athrow         
        //    21: aload_0         /* llllllllllllllIIllIlIIIlIlllllII */
        //    22: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    25: aload_1         /* llllllllllllllIIllIlIIIlIllllIlI */
        //    26: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 06 47 07 00 93 FC 00 06 07 00 95
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  6      14     14     21     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int[] readImageData(final IResourceManager llllllllllllllIIllIlIIIllIIlIlII, final ResourceLocation llllllllllllllIIllIlIIIllIIlIIll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2        /* llllllllllllllIIllIlIIIllIIIlIII */
        //     2: aload_0         /* llllllllllllllIIllIlIIIllIIIlIlI */
        //     3: aload_1         /* llllllllllllllIIllIlIIIllIIIlIIl */
        //     4: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //     9: astore_2        /* llllllllllllllIIllIlIIIllIIlIIlI */
        //    10: aload_2         /* llllllllllllllIIllIlIIIllIIlIIlI */
        //    11: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    16: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    19: astore          llllllllllllllIIllIlIIIllIIIllll
        //    21: aload           llllllllllllllIIllIlIIIllIIIllll
        //    23: ifnull          81
        //    26: aload           llllllllllllllIIllIlIIIllIIIllll
        //    28: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    31: istore          llllllllllllllIIllIlIIIllIIIlllI
        //    33: aload           llllllllllllllIIllIlIIIllIIIllll
        //    35: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    38: istore          llllllllllllllIIllIlIIIllIIIllIl
        //    40: iload           llllllllllllllIIllIlIIIllIIIlllI
        //    42: iload           llllllllllllllIIllIlIIIllIIIllIl
        //    44: imul           
        //    45: newarray        I
        //    47: astore          llllllllllllllIIllIlIIIllIIIllII
        //    49: aload           llllllllllllllIIllIlIIIllIIIllll
        //    51: iconst_0       
        //    52: iconst_0       
        //    53: iload           llllllllllllllIIllIlIIIllIIIlllI
        //    55: iload           llllllllllllllIIllIlIIIllIIIllIl
        //    57: aload           llllllllllllllIIllIlIIIllIIIllII
        //    59: iconst_0       
        //    60: iload           llllllllllllllIIllIlIIIllIIIlllI
        //    62: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //    65: pop            
        //    66: aload           llllllllllllllIIllIlIIIllIIIllII
        //    68: astore          llllllllllllllIIllIlIIIllIIIlIll
        //    70: aload           llllllllllllllIIllIlIIIllIIIlIll
        //    72: astore          llllllllllllllIIllIlIIIllIIIIIII
        //    74: aload_2         /* llllllllllllllIIllIlIIIllIIlIIlI */
        //    75: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    78: aload           llllllllllllllIIllIlIIIllIIIIIII
        //    80: areturn        
        //    81: aconst_null    
        //    82: astore_3        /* llllllllllllllIIllIlIIIllIIlIIIl */
        //    83: goto            95
        //    86: astore          llllllllllllllIIllIlIIIllIIIIIIl
        //    88: aload_2         /* llllllllllllllIIllIlIIIllIIlIIlI */
        //    89: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    92: aload           llllllllllllllIIllIlIIIllIIIIIIl
        //    94: athrow         
        //    95: aload_2         /* llllllllllllllIIllIlIIIllIIlIIlI */
        //    96: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    99: aload_3         /* llllllllllllllIIllIlIIIllIIlIIII */
        //   100: checkcast       [I
        //   103: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 03 FE 00 51 07 00 9F 00 07 00 95 FF 00 04 00 03 07 00 99 07 00 CE 07 00 9F 00 01 07 00 93 FD 00 08 05 07 00 95
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      74     86     95     Any
        //  81     86     86     95     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void deleteTexture(final int llllllllllllllIIllIlIIlIlllllIlI) {
        GlStateManager.deleteTexture(llllllllllllllIIllIlIIlIlllllIlI);
    }
    
    public static void processPixelValues(final int[] llllllllllllllIIllIlIIIlIlIIllll, final int llllllllllllllIIllIlIIIlIlIIlllI, final int llllllllllllllIIllIlIIIlIlIIIlll) {
        final int[] llllllllllllllIIllIlIIIlIlIIllII = new int[llllllllllllllIIllIlIIIlIlIIlllI];
        for (int llllllllllllllIIllIlIIIlIlIIlIll = llllllllllllllIIllIlIIIlIlIIIlll / 2, llllllllllllllIIllIlIIIlIlIIlIlI = 0; llllllllllllllIIllIlIIIlIlIIlIlI < llllllllllllllIIllIlIIIlIlIIlIll; ++llllllllllllllIIllIlIIIlIlIIlIlI) {
            System.arraycopy(llllllllllllllIIllIlIIIlIlIIllll, llllllllllllllIIllIlIIIlIlIIlIlI * llllllllllllllIIllIlIIIlIlIIlllI, llllllllllllllIIllIlIIIlIlIIllII, 0, llllllllllllllIIllIlIIIlIlIIlllI);
            System.arraycopy(llllllllllllllIIllIlIIIlIlIIllll, (llllllllllllllIIllIlIIIlIlIIIlll - 1 - llllllllllllllIIllIlIIIlIlIIlIlI) * llllllllllllllIIllIlIIIlIlIIlllI, llllllllllllllIIllIlIIIlIlIIllll, llllllllllllllIIllIlIIIlIlIIlIlI * llllllllllllllIIllIlIIIlIlIIlllI, llllllllllllllIIllIlIIIlIlIIlllI);
            System.arraycopy(llllllllllllllIIllIlIIIlIlIIllII, 0, llllllllllllllIIllIlIIIlIlIIllll, (llllllllllllllIIllIlIIIlIlIIIlll - 1 - llllllllllllllIIllIlIIIlIlIIlIlI) * llllllllllllllIIllIlIIIlIlIIlllI, llllllllllllllIIllIlIIIlIlIIlllI);
        }
    }
    
    public static int uploadTextureImageAllocate(final int llllllllllllllIIllIlIIlIIIIlllll, final BufferedImage llllllllllllllIIllIlIIlIIIIllIlI, final boolean llllllllllllllIIllIlIIlIIIIlllIl, final boolean llllllllllllllIIllIlIIlIIIIllIII) {
        allocateTexture(llllllllllllllIIllIlIIlIIIIlllll, llllllllllllllIIllIlIIlIIIIllIlI.getWidth(), llllllllllllllIIllIlIIlIIIIllIlI.getHeight());
        return uploadTextureImageSub(llllllllllllllIIllIlIIlIIIIlllll, llllllllllllllIIllIlIIlIIIIllIlI, 0, 0, llllllllllllllIIllIlIIlIIIIlllIl, llllllllllllllIIllIlIIlIIIIllIII);
    }
    
    public static int uploadTextureImageSub(final int llllllllllllllIIllIlIIIlllllIllI, final BufferedImage llllllllllllllIIllIlIIIllllIllll, final int llllllllllllllIIllIlIIIllllIlllI, final int llllllllllllllIIllIlIIIlllllIIll, final boolean llllllllllllllIIllIlIIIllllIllII, final boolean llllllllllllllIIllIlIIIlllllIIIl) {
        bindTexture(llllllllllllllIIllIlIIIlllllIllI);
        uploadTextureImageSubImpl(llllllllllllllIIllIlIIIllllIllll, llllllllllllllIIllIlIIIllllIlllI, llllllllllllllIIllIlIIIlllllIIll, llllllllllllllIIllIlIIIllllIllII, llllllllllllllIIllIlIIIlllllIIIl);
        return llllllllllllllIIllIlIIIlllllIllI;
    }
    
    private static float getColorGamma(final int llllllllllllllIIllIlIIllIIIIIIll) {
        return TextureUtil.COLOR_GAMMAS[llllllllllllllIIllIlIIllIIIIIIll & 0xFF];
    }
    
    private static int blendColorComponent(final int llllllllllllllIIllIlIIlIIlllIIlI, final int llllllllllllllIIllIlIIlIIllllIll, final int llllllllllllllIIllIlIIlIIlllIIII, final int llllllllllllllIIllIlIIlIIllllIIl, final int llllllllllllllIIllIlIIlIIllllIII) {
        final float llllllllllllllIIllIlIIlIIlllIlll = getColorGamma(llllllllllllllIIllIlIIlIIlllIIlI >> llllllllllllllIIllIlIIlIIllllIII);
        final float llllllllllllllIIllIlIIlIIlllIllI = getColorGamma(llllllllllllllIIllIlIIlIIllllIll >> llllllllllllllIIllIlIIlIIllllIII);
        final float llllllllllllllIIllIlIIlIIlllIlIl = getColorGamma(llllllllllllllIIllIlIIlIIlllIIII >> llllllllllllllIIllIlIIlIIllllIII);
        final float llllllllllllllIIllIlIIlIIlllIlII = getColorGamma(llllllllllllllIIllIlIIlIIllllIIl >> llllllllllllllIIllIlIIlIIllllIII);
        final float llllllllllllllIIllIlIIlIIlllIIll = (float)Math.pow((llllllllllllllIIllIlIIlIIlllIlll + llllllllllllllIIllIlIIlIIlllIllI + llllllllllllllIIllIlIIlIIlllIlIl + llllllllllllllIIllIlIIlIIlllIlII) * 0.25, 0.45454545454545453);
        return (int)(llllllllllllllIIllIlIIlIIlllIIll * 255.0);
    }
    
    public static void uploadTexture(final int llllllllllllllIIllIlIIlIlllIIIIl, final int[] llllllllllllllIIllIlIIlIllIllIlI, final int llllllllllllllIIllIlIIlIllIlllIl, final int llllllllllllllIIllIlIIlIllIllIII) {
        bindTexture(llllllllllllllIIllIlIIlIlllIIIIl);
        uploadTextureSub(0, llllllllllllllIIllIlIIlIllIllIlI, llllllllllllllIIllIlIIlIllIlllIl, llllllllllllllIIllIlIIlIllIllIII, 0, 0, false, false, false);
    }
    
    public static int glGenTextures() {
        return GlStateManager.generateTexture();
    }
    
    private static int blendColors(final int llllllllllllllIIllIlIIlIlIIIllll, final int llllllllllllllIIllIlIIlIlIIIlllI, final int llllllllllllllIIllIlIIlIlIIIlIII, final int llllllllllllllIIllIlIIlIlIIIllII, final boolean llllllllllllllIIllIlIIlIlIIIlIll) {
        return Mipmaps.alphaBlend(llllllllllllllIIllIlIIlIlIIIllll, llllllllllllllIIllIlIIlIlIIIlllI, llllllllllllllIIllIlIIlIlIIIlIII, llllllllllllllIIllIlIIlIlIIIllII);
    }
    
    private static void setTextureBlurred(final boolean llllllllllllllIIllIlIIIllIllllll) {
        setTextureBlurMipmap(llllllllllllllIIllIlIIIllIllllll, false);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DATA_BUFFER = GLAllocation.createDirectIntBuffer(4194304);
        MISSING_TEXTURE = new DynamicTexture(16, 16);
        MISSING_TEXTURE_DATA = TextureUtil.MISSING_TEXTURE.getTextureData();
        final int llllllllllllllIIllIlIIllIIIlIlll = -16777216;
        final int llllllllllllllIIllIlIIllIIIlIllI = -524040;
        final int[] llllllllllllllIIllIlIIllIIIlIlIl = { -524040, -524040, -524040, -524040, -524040, -524040, -524040, -524040 };
        final int[] llllllllllllllIIllIlIIllIIIlIIll = { -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216 };
        final int llllllllllllllIIllIlIIllIIIlIIlI = llllllllllllllIIllIlIIllIIIlIlIl.length;
        for (int llllllllllllllIIllIlIIllIIIlIIII = 0; llllllllllllllIIllIlIIllIIIlIIII < 16; ++llllllllllllllIIllIlIIllIIIlIIII) {
            System.arraycopy((llllllllllllllIIllIlIIllIIIlIIII < llllllllllllllIIllIlIIllIIIlIIlI) ? llllllllllllllIIllIlIIllIIIlIlIl : llllllllllllllIIllIlIIllIIIlIIll, 0, TextureUtil.MISSING_TEXTURE_DATA, 16 * llllllllllllllIIllIlIIllIIIlIIII, llllllllllllllIIllIlIIllIIIlIIlI);
            System.arraycopy((llllllllllllllIIllIlIIllIIIlIIII < llllllllllllllIIllIlIIllIIIlIIlI) ? llllllllllllllIIllIlIIllIIIlIIll : llllllllllllllIIllIlIIllIIIlIlIl, 0, TextureUtil.MISSING_TEXTURE_DATA, 16 * llllllllllllllIIllIlIIllIIIlIIII + llllllllllllllIIllIlIIllIIIlIIlI, llllllllllllllIIllIlIIllIIIlIIlI);
        }
        TextureUtil.MISSING_TEXTURE.updateDynamicTexture();
        COLOR_GAMMAS = new float[256];
        for (int llllllllllllllIIllIlIIllIIIIlllI = 0; llllllllllllllIIllIlIIllIIIIlllI < TextureUtil.COLOR_GAMMAS.length; ++llllllllllllllIIllIlIIllIIIIlllI) {
            TextureUtil.COLOR_GAMMAS[llllllllllllllIIllIlIIllIIIIlllI] = (float)Math.pow(llllllllllllllIIllIlIIllIIIIlllI / 255.0f, 2.2);
        }
        MIPMAP_BUFFER = new int[4];
    }
    
    static void bindTexture(final int llllllllllllllIIllIlIIIllIlIIIIl) {
        GlStateManager.bindTexture(llllllllllllllIIllIlIIIllIlIIIIl);
    }
    
    private static void copyToBuffer(final int[] llllllllllllllIIllIlIIIllIllIIII, final int llllllllllllllIIllIlIIIllIllIIIl) {
        copyToBufferPos(llllllllllllllIIllIlIIIllIllIIII, 0, llllllllllllllIIllIlIIIllIllIIIl);
    }
    
    public static int anaglyphColor(final int llllllllllllllIIllIlIIIlIlIlllIl) {
        final int llllllllllllllIIllIlIIIlIllIIlII = llllllllllllllIIllIlIIIlIlIlllIl >> 24 & 0xFF;
        final int llllllllllllllIIllIlIIIlIllIIIll = llllllllllllllIIllIlIIIlIlIlllIl >> 16 & 0xFF;
        final int llllllllllllllIIllIlIIIlIllIIIlI = llllllllllllllIIllIlIIIlIlIlllIl >> 8 & 0xFF;
        final int llllllllllllllIIllIlIIIlIllIIIIl = llllllllllllllIIllIlIIIlIlIlllIl & 0xFF;
        final int llllllllllllllIIllIlIIIlIllIIIII = (llllllllllllllIIllIlIIIlIllIIIll * 30 + llllllllllllllIIllIlIIIlIllIIIlI * 59 + llllllllllllllIIllIlIIIlIllIIIIl * 11) / 100;
        final int llllllllllllllIIllIlIIIlIlIlllll = (llllllllllllllIIllIlIIIlIllIIIll * 30 + llllllllllllllIIllIlIIIlIllIIIlI * 70) / 100;
        final int llllllllllllllIIllIlIIIlIlIllllI = (llllllllllllllIIllIlIIIlIllIIIll * 30 + llllllllllllllIIllIlIIIlIllIIIIl * 70) / 100;
        return llllllllllllllIIllIlIIIlIllIIlII << 24 | llllllllllllllIIllIlIIIlIllIIIII << 16 | llllllllllllllIIllIlIIIlIlIlllll << 8 | llllllllllllllIIllIlIIIlIlIllllI;
    }
    
    public static int[] updateAnaglyph(final int[] llllllllllllllIIllIlIIIlIlllIIll) {
        final int[] llllllllllllllIIllIlIIIlIlllIIlI = new int[llllllllllllllIIllIlIIIlIlllIIll.length];
        for (int llllllllllllllIIllIlIIIlIlllIIIl = 0; llllllllllllllIIllIlIIIlIlllIIIl < llllllllllllllIIllIlIIIlIlllIIll.length; ++llllllllllllllIIllIlIIIlIlllIIIl) {
            llllllllllllllIIllIlIIIlIlllIIlI[llllllllllllllIIllIlIIIlIlllIIIl] = anaglyphColor(llllllllllllllIIllIlIIIlIlllIIll[llllllllllllllIIllIlIIIlIlllIIIl]);
        }
        return llllllllllllllIIllIlIIIlIlllIIlI;
    }
    
    private static void uploadTextureImageSubImpl(final BufferedImage llllllllllllllIIllIlIIIlllIlllIl, final int llllllllllllllIIllIlIIIlllIlllII, final int llllllllllllllIIllIlIIIlllIllIll, final boolean llllllllllllllIIllIlIIIlllIIllIl, final boolean llllllllllllllIIllIlIIIlllIllIIl) {
        final int llllllllllllllIIllIlIIIlllIllIII = llllllllllllllIIllIlIIIlllIlllIl.getWidth();
        final int llllllllllllllIIllIlIIIlllIlIlll = llllllllllllllIIllIlIIIlllIlllIl.getHeight();
        final int llllllllllllllIIllIlIIIlllIlIllI = 4194304 / llllllllllllllIIllIlIIIlllIllIII;
        final int[] llllllllllllllIIllIlIIIlllIlIlIl = new int[llllllllllllllIIllIlIIIlllIlIllI * llllllllllllllIIllIlIIIlllIllIII];
        setTextureBlurred(llllllllllllllIIllIlIIIlllIIllIl);
        setTextureClamped(llllllllllllllIIllIlIIIlllIllIIl);
        for (int llllllllllllllIIllIlIIIlllIlIlII = 0; llllllllllllllIIllIlIIIlllIlIlII < llllllllllllllIIllIlIIIlllIllIII * llllllllllllllIIllIlIIIlllIlIlll; llllllllllllllIIllIlIIIlllIlIlII += llllllllllllllIIllIlIIIlllIllIII * llllllllllllllIIllIlIIIlllIlIllI) {
            final int llllllllllllllIIllIlIIIlllIlIIll = llllllllllllllIIllIlIIIlllIlIlII / llllllllllllllIIllIlIIIlllIllIII;
            final int llllllllllllllIIllIlIIIlllIlIIlI = Math.min(llllllllllllllIIllIlIIIlllIlIllI, llllllllllllllIIllIlIIIlllIlIlll - llllllllllllllIIllIlIIIlllIlIIll);
            final int llllllllllllllIIllIlIIIlllIlIIIl = llllllllllllllIIllIlIIIlllIllIII * llllllllllllllIIllIlIIIlllIlIIlI;
            llllllllllllllIIllIlIIIlllIlllIl.getRGB(0, llllllllllllllIIllIlIIIlllIlIIll, llllllllllllllIIllIlIIIlllIllIII, llllllllllllllIIllIlIIIlllIlIIlI, llllllllllllllIIllIlIIIlllIlIlIl, 0, llllllllllllllIIllIlIIIlllIllIII);
            copyToBuffer(llllllllllllllIIllIlIIIlllIlIlIl, llllllllllllllIIllIlIIIlllIlIIIl);
            GlStateManager.glTexSubImage2D(3553, 0, llllllllllllllIIllIlIIIlllIlllII, llllllllllllllIIllIlIIIlllIllIll + llllllllllllllIIllIlIIIlllIlIIll, llllllllllllllIIllIlIIIlllIllIII, llllllllllllllIIllIlIIIlllIlIIlI, 32993, 33639, TextureUtil.DATA_BUFFER);
        }
    }
    
    public static void allocateTextureImpl(final int llllllllllllllIIllIlIIlIIIIIlIII, final int llllllllllllllIIllIlIIlIIIIIIlll, final int llllllllllllllIIllIlIIlIIIIIIllI, final int llllllllllllllIIllIlIIlIIIIIIlIl) {
        Object llllllllllllllIIllIlIIlIIIIIIlII = TextureUtil.class;
        if (Reflector.SplashScreen.exists()) {
            llllllllllllllIIllIlIIlIIIIIIlII = Reflector.SplashScreen.getTargetClass();
        }
        synchronized (llllllllllllllIIllIlIIlIIIIIIlII) {
            deleteTexture(llllllllllllllIIllIlIIlIIIIIlIII);
            bindTexture(llllllllllllllIIllIlIIlIIIIIlIII);
        }
        if (llllllllllllllIIllIlIIlIIIIIIlll >= 0) {
            GlStateManager.glTexParameteri(3553, 33085, llllllllllllllIIllIlIIlIIIIIIlll);
            GlStateManager.glTexParameteri(3553, 33082, 0);
            GlStateManager.glTexParameteri(3553, 33083, llllllllllllllIIllIlIIlIIIIIIlll);
            GlStateManager.glTexParameterf(3553, 34049, 0.0f);
        }
        for (int llllllllllllllIIllIlIIlIIIIIIIll = 0; llllllllllllllIIllIlIIlIIIIIIIll <= llllllllllllllIIllIlIIlIIIIIIlll; ++llllllllllllllIIllIlIIlIIIIIIIll) {
            GlStateManager.glTexImage2D(3553, llllllllllllllIIllIlIIlIIIIIIIll, 6408, llllllllllllllIIllIlIIlIIIIIIllI >> llllllllllllllIIllIlIIlIIIIIIIll, llllllllllllllIIllIlIIlIIIIIIlIl >> llllllllllllllIIllIlIIlIIIIIIIll, 0, 32993, 33639, null);
        }
    }
    
    public static int uploadTextureImage(final int llllllllllllllIIllIlIIlIllllIIlI, final BufferedImage llllllllllllllIIllIlIIlIlllIllII) {
        return uploadTextureImageAllocate(llllllllllllllIIllIlIIlIllllIIlI, llllllllllllllIIllIlIIlIlllIllII, false, false);
    }
    
    public static void setTextureClamped(final boolean llllllllllllllIIllIlIIIlllIIIIlI) {
        if (llllllllllllllIIllIlIIIlllIIIIlI) {
            GlStateManager.glTexParameteri(3553, 10242, 33071);
            GlStateManager.glTexParameteri(3553, 10243, 33071);
        }
        else {
            GlStateManager.glTexParameteri(3553, 10242, 10497);
            GlStateManager.glTexParameteri(3553, 10243, 10497);
        }
    }
    
    public static void setTextureBlurMipmap(final boolean llllllllllllllIIllIlIIIllIllIlll, final boolean llllllllllllllIIllIlIIIllIllIllI) {
        if (llllllllllllllIIllIlIIIllIllIlll) {
            GlStateManager.glTexParameteri(3553, 10241, llllllllllllllIIllIlIIIllIllIllI ? 9987 : 9729);
            GlStateManager.glTexParameteri(3553, 10240, 9729);
        }
        else {
            final int llllllllllllllIIllIlIIIllIlllIII = Config.getMipmapType();
            GlStateManager.glTexParameteri(3553, 10241, llllllllllllllIIllIlIIIllIllIllI ? llllllllllllllIIllIlIIIllIlllIII : 9728);
            GlStateManager.glTexParameteri(3553, 10240, 9728);
        }
    }
    
    private static void copyToBufferPos(final int[] llllllllllllllIIllIlIIIllIlIIllI, final int llllllllllllllIIllIlIIIllIlIlIIl, final int llllllllllllllIIllIlIIIllIlIIlII) {
        int[] llllllllllllllIIllIlIIIllIlIIlll = llllllllllllllIIllIlIIIllIlIIllI;
        if (Minecraft.getMinecraft().gameSettings.anaglyph) {
            llllllllllllllIIllIlIIIllIlIIlll = updateAnaglyph(llllllllllllllIIllIlIIIllIlIIllI);
        }
        TextureUtil.DATA_BUFFER.clear();
        TextureUtil.DATA_BUFFER.put(llllllllllllllIIllIlIIIllIlIIlll, llllllllllllllIIllIlIIIllIlIlIIl, llllllllllllllIIllIlIIIllIlIIlII);
        TextureUtil.DATA_BUFFER.position(0).limit(llllllllllllllIIllIlIIIllIlIIlII);
    }
    
    public static void uploadTextureMipmap(final int[][] llllllllllllllIIllIlIIlIIlIlllll, final int llllllllllllllIIllIlIIlIIlIllllI, final int llllllllllllllIIllIlIIlIIlIlIlII, final int llllllllllllllIIllIlIIlIIlIlIIll, final int llllllllllllllIIllIlIIlIIlIlIIlI, final boolean llllllllllllllIIllIlIIlIIlIlIIIl, final boolean llllllllllllllIIllIlIIlIIlIllIIl) {
        for (int llllllllllllllIIllIlIIlIIlIllIII = 0; llllllllllllllIIllIlIIlIIlIllIII < llllllllllllllIIllIlIIlIIlIlllll.length; ++llllllllllllllIIllIlIIlIIlIllIII) {
            final int[] llllllllllllllIIllIlIIlIIlIlIlll = llllllllllllllIIllIlIIlIIlIlllll[llllllllllllllIIllIlIIlIIlIllIII];
            uploadTextureSub(llllllllllllllIIllIlIIlIIlIllIII, llllllllllllllIIllIlIIlIIlIlIlll, llllllllllllllIIllIlIIlIIlIllllI >> llllllllllllllIIllIlIIlIIlIllIII, llllllllllllllIIllIlIIlIIlIlIlII >> llllllllllllllIIllIlIIlIIlIllIII, llllllllllllllIIllIlIIlIIlIlIIll >> llllllllllllllIIllIlIIlIIlIllIII, llllllllllllllIIllIlIIlIIlIlIIlI >> llllllllllllllIIllIlIIlIIlIllIII, llllllllllllllIIllIlIIlIIlIlIIIl, llllllllllllllIIllIlIIlIIlIllIIl, llllllllllllllIIllIlIIlIIlIlllll.length > 1);
        }
    }
    
    public static void allocateTexture(final int llllllllllllllIIllIlIIlIIIIlIIIl, final int llllllllllllllIIllIlIIlIIIIlIIll, final int llllllllllllllIIllIlIIlIIIIlIIlI) {
        allocateTextureImpl(llllllllllllllIIllIlIIlIIIIlIIIl, 0, llllllllllllllIIllIlIIlIIIIlIIll, llllllllllllllIIllIlIIlIIIIlIIlI);
    }
}
