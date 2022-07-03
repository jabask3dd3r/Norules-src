package net.minecraft.client.renderer.texture;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.client.resources.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class LayeredColorMaskTexture extends AbstractTexture
{
    private final /* synthetic */ ResourceLocation textureLocation;
    private final /* synthetic */ List<EnumDyeColor> listDyeColors;
    private final /* synthetic */ List<String> listTextures;
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIlIIllIIIlIIIIIIlll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   net/minecraft/client/renderer/texture/LayeredColorMaskTexture.deleteGlTexture:()V
        //     4: aconst_null    
        //     5: astore_2        /* lllllllllllllIlIIllIIIlIIIIIIllI */
        //     6: aload_1         /* lllllllllllllIlIIllIIIIlllllIIll */
        //     7: aload_0         /* lllllllllllllIlIIllIIIIlllllIlII */
        //     8: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.textureLocation:Lnet/minecraft/util/ResourceLocation;
        //    11: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    16: astore_2        /* lllllllllllllIlIIllIIIlIIIIIIllI */
        //    17: aload_2         /* lllllllllllllIlIIllIIIlIIIIIIllI */
        //    18: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    23: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    26: astore          lllllllllllllIlIIllIIIlIIIIIIIll
        //    28: aload           lllllllllllllIlIIllIIIlIIIIIIIll
        //    30: invokevirtual   java/awt/image/BufferedImage.getType:()I
        //    33: istore          lllllllllllllIlIIllIIIlIIIIIIIlI
        //    35: iload           lllllllllllllIlIIllIIIlIIIIIIIlI
        //    37: ifne            44
        //    40: bipush          6
        //    42: istore          lllllllllllllIlIIllIIIlIIIIIIIlI
        //    44: new             Ljava/awt/image/BufferedImage;
        //    47: dup            
        //    48: aload           lllllllllllllIlIIllIIIlIIIIIIIll
        //    50: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    53: aload           lllllllllllllIlIIllIIIlIIIIIIIll
        //    55: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    58: iload           lllllllllllllIlIIllIIIlIIIIIIIlI
        //    60: invokespecial   java/awt/image/BufferedImage.<init>:(III)V
        //    63: astore_3        /* lllllllllllllIlIIllIIIIlllllIIIl */
        //    64: aload_3         /* lllllllllllllIlIIllIIIlIIIIIIlIl */
        //    65: invokevirtual   java/awt/image/BufferedImage.getGraphics:()Ljava/awt/Graphics;
        //    68: astore          lllllllllllllIlIIllIIIlIIIIIIIIl
        //    70: aload           lllllllllllllIlIIllIIIlIIIIIIIIl
        //    72: aload           lllllllllllllIlIIllIIIlIIIIIIIll
        //    74: iconst_0       
        //    75: iconst_0       
        //    76: aconst_null    
        //    77: invokevirtual   java/awt/Graphics.drawImage:(Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
        //    80: pop            
        //    81: iconst_0       
        //    82: istore          lllllllllllllIlIIllIIIlIIIIIIIII
        //    84: iload           lllllllllllllIlIIllIIIlIIIIIIIII
        //    86: bipush          17
        //    88: if_icmpge       119
        //    91: iload           lllllllllllllIlIIllIIIlIIIIIIIII
        //    93: aload_0         /* lllllllllllllIlIIllIIIIlllllIlII */
        //    94: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listTextures:Ljava/util/List;
        //    97: invokeinterface java/util/List.size:()I
        //   102: if_icmpge       119
        //   105: iload           lllllllllllllIlIIllIIIlIIIIIIIII
        //   107: aload_0         /* lllllllllllllIlIIllIIIIlllllIlII */
        //   108: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listDyeColors:Ljava/util/List;
        //   111: invokeinterface java/util/List.size:()I
        //   116: if_icmplt       126
        //   119: aload_2         /* lllllllllllllIlIIllIIIlIIIIIIllI */
        //   120: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   123: goto            407
        //   126: aconst_null    
        //   127: astore          lllllllllllllIlIIllIIIIlllllllll
        //   129: aload_0         /* lllllllllllllIlIIllIIIIlllllIlII */
        //   130: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listTextures:Ljava/util/List;
        //   133: iload           lllllllllllllIlIIllIIIlIIIIIIIII
        //   135: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   140: checkcast       Ljava/lang/String;
        //   143: astore          lllllllllllllIlIIllIIIIllllllllI
        //   145: aload_0         /* lllllllllllllIlIIllIIIIlllllIlII */
        //   146: getfield        net/minecraft/client/renderer/texture/LayeredColorMaskTexture.listDyeColors:Ljava/util/List;
        //   149: iload           lllllllllllllIlIIllIIIlIIIIIIIII
        //   151: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   156: checkcast       Lnet/minecraft/item/EnumDyeColor;
        //   159: invokevirtual   net/minecraft/item/EnumDyeColor.func_193350_e:()I
        //   162: istore          lllllllllllllIlIIllIIIIlllllllIl
        //   164: aload           lllllllllllllIlIIllIIIIllllllllI
        //   166: ifnull          365
        //   169: aload_1         /* lllllllllllllIlIIllIIIIlllllIIll */
        //   170: new             Lnet/minecraft/util/ResourceLocation;
        //   173: dup            
        //   174: aload           lllllllllllllIlIIllIIIIllllllllI
        //   176: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //   179: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   184: astore          lllllllllllllIlIIllIIIIlllllllll
        //   186: aload           lllllllllllllIlIIllIIIIlllllllll
        //   188: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   193: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //   196: astore          lllllllllllllIlIIllIIIIlllllllII
        //   198: aload           lllllllllllllIlIIllIIIIlllllllII
        //   200: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   203: aload_3         /* lllllllllllllIlIIllIIIlIIIIIIlIl */
        //   204: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   207: if_icmpne       365
        //   210: aload           lllllllllllllIlIIllIIIIlllllllII
        //   212: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   215: aload_3         /* lllllllllllllIlIIllIIIlIIIIIIlIl */
        //   216: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   219: if_icmpne       365
        //   222: aload           lllllllllllllIlIIllIIIIlllllllII
        //   224: invokevirtual   java/awt/image/BufferedImage.getType:()I
        //   227: bipush          6
        //   229: if_icmpne       365
        //   232: iconst_0       
        //   233: istore          lllllllllllllIlIIllIIIIllllllIll
        //   235: goto            329
        //   238: iconst_0       
        //   239: istore          lllllllllllllIlIIllIIIIllllllIlI
        //   241: goto            316
        //   244: aload           lllllllllllllIlIIllIIIIlllllllII
        //   246: iload           lllllllllllllIlIIllIIIIllllllIlI
        //   248: iload           lllllllllllllIlIIllIIIIllllllIll
        //   250: invokevirtual   java/awt/image/BufferedImage.getRGB:(II)I
        //   253: istore          lllllllllllllIlIIllIIIIllllllIIl
        //   255: iload           lllllllllllllIlIIllIIIIllllllIIl
        //   257: ldc             -16777216
        //   259: iand           
        //   260: ifeq            313
        //   263: iload           lllllllllllllIlIIllIIIIllllllIIl
        //   265: ldc             16711680
        //   267: iand           
        //   268: bipush          8
        //   270: ishl           
        //   271: ldc             -16777216
        //   273: iand           
        //   274: istore          lllllllllllllIlIIllIIIIllllllIII
        //   276: aload           lllllllllllllIlIIllIIIlIIIIIIIll
        //   278: iload           lllllllllllllIlIIllIIIIllllllIlI
        //   280: iload           lllllllllllllIlIIllIIIIllllllIll
        //   282: invokevirtual   java/awt/image/BufferedImage.getRGB:(II)I
        //   285: istore          lllllllllllllIlIIllIIIIlllllIlll
        //   287: iload           lllllllllllllIlIIllIIIIlllllIlll
        //   289: iload           lllllllllllllIlIIllIIIIlllllllIl
        //   291: invokestatic    net/minecraft/util/math/MathHelper.multiplyColor:(II)I
        //   294: ldc             16777215
        //   296: iand           
        //   297: istore          lllllllllllllIlIIllIIIIlllllIllI
        //   299: aload           lllllllllllllIlIIllIIIIlllllllII
        //   301: iload           lllllllllllllIlIIllIIIIllllllIlI
        //   303: iload           lllllllllllllIlIIllIIIIllllllIll
        //   305: iload           lllllllllllllIlIIllIIIIllllllIII
        //   307: iload           lllllllllllllIlIIllIIIIlllllIllI
        //   309: ior            
        //   310: invokevirtual   java/awt/image/BufferedImage.setRGB:(III)V
        //   313: iinc            lllllllllllllIlIIllIIIIllllllIlI, 1
        //   316: iload           lllllllllllllIlIIllIIIIllllllIlI
        //   318: aload           lllllllllllllIlIIllIIIIlllllllII
        //   320: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   323: if_icmplt       244
        //   326: iinc            lllllllllllllIlIIllIIIIllllllIll, 1
        //   329: iload           lllllllllllllIlIIllIIIIllllllIll
        //   331: aload           lllllllllllllIlIIllIIIIlllllllII
        //   333: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   336: if_icmplt       238
        //   339: aload_3         /* lllllllllllllIlIIllIIIlIIIIIIlIl */
        //   340: invokevirtual   java/awt/image/BufferedImage.getGraphics:()Ljava/awt/Graphics;
        //   343: aload           lllllllllllllIlIIllIIIIlllllllII
        //   345: iconst_0       
        //   346: iconst_0       
        //   347: aconst_null    
        //   348: invokevirtual   java/awt/Graphics.drawImage:(Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
        //   351: pop            
        //   352: goto            365
        //   355: astore          lllllllllllllIlIIllIIIIlllIllIll
        //   357: aload           lllllllllllllIlIIllIIIIlllllllll
        //   359: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   362: aload           lllllllllllllIlIIllIIIIlllIllIll
        //   364: athrow         
        //   365: aload           lllllllllllllIlIIllIIIIlllllllll
        //   367: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   370: iinc            lllllllllllllIlIIllIIIlIIIIIIIII, 1
        //   373: goto            84
        //   376: astore          lllllllllllllIlIIllIIIIlllllIlIl
        //   378: getstatic       net/minecraft/client/renderer/texture/LayeredColorMaskTexture.LOG:Lorg/apache/logging/log4j/Logger;
        //   381: ldc             "Couldn't load layered image"
        //   383: aload           lllllllllllllIlIIllIIIIlllllIlIl
        //   385: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   390: aload_2         /* lllllllllllllIlIIllIIIlIIIIIIllI */
        //   391: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   394: goto            406
        //   397: astore          lllllllllllllIlIIllIIIIlllIllIIl
        //   399: aload_2         /* lllllllllllllIlIIllIIIlIIIIIIllI */
        //   400: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   403: aload           lllllllllllllIlIIllIIIIlllIllIIl
        //   405: athrow         
        //   406: return         
        //   407: aload_0         /* lllllllllllllIlIIllIIIIlllllIlII */
        //   408: invokevirtual   net/minecraft/client/renderer/texture/LayeredColorMaskTexture.getGlTextureId:()I
        //   411: aload_3         /* lllllllllllllIlIIllIIIlIIIIIIlII */
        //   412: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.uploadTextureImage:(ILjava/awt/image/BufferedImage;)I
        //   415: pop            
        //   416: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 0F FF 00 2C 00 06 07 00 02 07 00 19 07 00 1F 00 07 00 2B 01 00 00 FF 00 27 00 08 07 00 02 07 00 19 07 00 1F 07 00 2B 07 00 2B 01 07 00 3F 01 00 00 22 06 FF 00 6F 00 0D 07 00 02 07 00 19 07 00 1F 07 00 2B 07 00 2B 01 07 00 3F 01 07 00 1F 07 00 58 01 07 00 2B 01 00 00 FC 00 05 01 FC 00 44 01 FA 00 02 FA 00 0C FF 00 19 00 09 07 00 02 07 00 19 07 00 1F 07 00 2B 07 00 2B 01 07 00 3F 01 07 00 1F 00 01 07 00 BA FD 00 09 07 00 58 01 FF 00 0A 00 03 07 00 02 07 00 19 07 00 1F 00 01 07 00 11 54 07 00 BA FD 00 08 00 07 00 11 FF 00 00 00 08 07 00 02 07 00 19 07 00 1F 07 00 2B 07 00 2B 01 07 00 3F 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  129    355    355    365    Any
        //  6      119    376    397    Ljava/io/IOException;
        //  126    376    376    397    Ljava/io/IOException;
        //  6      119    397    406    Any
        //  126    390    397    406    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public LayeredColorMaskTexture(final ResourceLocation lllllllllllllIlIIllIIIlIIIlIIIlI, final List<String> lllllllllllllIlIIllIIIlIIIlIlIII, final List<EnumDyeColor> lllllllllllllIlIIllIIIlIIIlIIllI) {
        this.textureLocation = lllllllllllllIlIIllIIIlIIIlIIIlI;
        this.listTextures = lllllllllllllIlIIllIIIlIIIlIlIII;
        this.listDyeColors = lllllllllllllIlIIllIIIlIIIlIIllI;
    }
    
    static {
        LOG = LogManager.getLogger();
    }
}
