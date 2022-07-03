package net.minecraft.client.gui;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import java.io.*;

public class GuiWinGame extends GuiScreen
{
    private static final /* synthetic */ ResourceLocation MINECRAFT_LOGO;
    private final /* synthetic */ Runnable field_193981_i;
    private /* synthetic */ float time;
    private final /* synthetic */ boolean field_193980_h;
    private /* synthetic */ float scrollSpeed;
    private /* synthetic */ int totalScrollLength;
    private static final /* synthetic */ ResourceLocation VIGNETTE_TEXTURE;
    private /* synthetic */ List<String> lines;
    private static final /* synthetic */ ResourceLocation field_194401_g;
    
    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    private void drawWinGameScreen(final int lllllllllllllIIlllllIIIlIIlllIIl, final int lllllllllllllIIlllllIIIlIIlllIII, final float lllllllllllllIIlllllIIIlIIllIlll) {
        final Tessellator lllllllllllllIIlllllIIIlIIllIllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlllllIIIlIIllIlIl = lllllllllllllIIlllllIIIlIIllIllI.getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        lllllllllllllIIlllllIIIlIIllIlIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        final int lllllllllllllIIlllllIIIlIIllIlII = this.width;
        final float lllllllllllllIIlllllIIIlIIllIIll = -this.time * 0.5f * this.scrollSpeed;
        final float lllllllllllllIIlllllIIIlIIllIIlI = this.height - this.time * 0.5f * this.scrollSpeed;
        final float lllllllllllllIIlllllIIIlIIllIIIl = 0.015625f;
        float lllllllllllllIIlllllIIIlIIllIIII = this.time * 0.02f;
        final float lllllllllllllIIlllllIIIlIIlIllll = (this.totalScrollLength + this.height + this.height + 24) / this.scrollSpeed;
        final float lllllllllllllIIlllllIIIlIIlIlllI = (lllllllllllllIIlllllIIIlIIlIllll - 20.0f - this.time) * 0.005f;
        if (lllllllllllllIIlllllIIIlIIlIlllI < lllllllllllllIIlllllIIIlIIllIIII) {
            lllllllllllllIIlllllIIIlIIllIIII = lllllllllllllIIlllllIIIlIIlIlllI;
        }
        if (lllllllllllllIIlllllIIIlIIllIIII > 1.0f) {
            lllllllllllllIIlllllIIIlIIllIIII = 1.0f;
        }
        lllllllllllllIIlllllIIIlIIllIIII *= lllllllllllllIIlllllIIIlIIllIIII;
        lllllllllllllIIlllllIIIlIIllIIII = lllllllllllllIIlllllIIIlIIllIIII * 96.0f / 255.0f;
        lllllllllllllIIlllllIIIlIIllIlIl.pos(0.0, this.height, this.zLevel).tex(0.0, lllllllllllllIIlllllIIIlIIllIIll * 0.015625f).color(lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIllIlIl.pos(lllllllllllllIIlllllIIIlIIllIlII, this.height, this.zLevel).tex(lllllllllllllIIlllllIIIlIIllIlII * 0.015625f, lllllllllllllIIlllllIIIlIIllIIll * 0.015625f).color(lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIllIlIl.pos(lllllllllllllIIlllllIIIlIIllIlII, 0.0, this.zLevel).tex(lllllllllllllIIlllllIIIlIIllIlII * 0.015625f, lllllllllllllIIlllllIIIlIIllIIlI * 0.015625f).color(lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIllIlIl.pos(0.0, 0.0, this.zLevel).tex(0.0, lllllllllllllIIlllllIIIlIIllIIlI * 0.015625f).color(lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, lllllllllllllIIlllllIIIlIIllIIII, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIllIllI.draw();
    }
    
    @Override
    public void initGui() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //     4: ifnonnull       517
        //     7: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //     8: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    11: putfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //    14: aconst_null    
        //    15: astore_1        /* lllllllllllllIIlllllIIIlIlIIllll */
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: getstatic       net/minecraft/util/text/TextFormatting.WHITE:Lnet/minecraft/util/text/TextFormatting;
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    29: getstatic       net/minecraft/util/text/TextFormatting.OBFUSCATED:Lnet/minecraft/util/text/TextFormatting;
        //    32: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    35: getstatic       net/minecraft/util/text/TextFormatting.GREEN:Lnet/minecraft/util/text/TextFormatting;
        //    38: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    41: getstatic       net/minecraft/util/text/TextFormatting.AQUA:Lnet/minecraft/util/text/TextFormatting;
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    47: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    50: astore_2        /* lllllllllllllIIlllllIIIlIllIIIII */
        //    51: sipush          274
        //    54: istore_3        /* lllllllllllllIIlllllIIIlIlIlllll */
        //    55: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //    56: getfield        net/minecraft/client/gui/GuiWinGame.field_193980_h:Z
        //    59: ifeq            326
        //    62: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //    63: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //    66: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //    69: new             Lnet/minecraft/util/ResourceLocation;
        //    72: dup            
        //    73: ldc             "texts/end.txt"
        //    75: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //    78: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    83: astore_1        /* lllllllllllllIIlllllIIIlIllIIIIl */
        //    84: aload_1         /* lllllllllllllIIlllllIIIlIllIIIIl */
        //    85: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    90: astore          lllllllllllllIIlllllIIIlIlIllllI
        //    92: new             Ljava/io/BufferedReader;
        //    95: dup            
        //    96: new             Ljava/io/InputStreamReader;
        //    99: dup            
        //   100: aload           lllllllllllllIIlllllIIIlIlIllllI
        //   102: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   105: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   108: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   111: astore          lllllllllllllIIlllllIIIlIlIlllIl
        //   113: new             Ljava/util/Random;
        //   116: dup            
        //   117: ldc2_w          8124371
        //   120: invokespecial   java/util/Random.<init>:(J)V
        //   123: astore          lllllllllllllIIlllllIIIlIlIlllII
        //   125: goto            281
        //   128: aload           lllllllllllllIIlllllIIIlIlIllIll
        //   130: ldc             "PLAYERNAME"
        //   132: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   133: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   136: invokevirtual   net/minecraft/client/Minecraft.getSession:()Lnet/minecraft/util/Session;
        //   139: invokevirtual   net/minecraft/util/Session.getUsername:()Ljava/lang/String;
        //   142: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   145: astore          lllllllllllllIIlllllIIIlIlIllIll
        //   147: goto            234
        //   150: aload           lllllllllllllIIlllllIIIlIlIllIll
        //   152: aload_2         /* lllllllllllllIIlllllIIIlIllIIIII */
        //   153: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   156: istore          lllllllllllllIIlllllIIIlIlIlIlll
        //   158: aload           lllllllllllllIIlllllIIIlIlIllIll
        //   160: iconst_0       
        //   161: iload           lllllllllllllIIlllllIIIlIlIlIlll
        //   163: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   166: astore          lllllllllllllIIlllllIIIlIlIllIIl
        //   168: aload           lllllllllllllIIlllllIIIlIlIllIll
        //   170: iload           lllllllllllllIIlllllIIIlIlIlIlll
        //   172: aload_2         /* lllllllllllllIIlllllIIIlIllIIIII */
        //   173: invokevirtual   java/lang/String.length:()I
        //   176: iadd           
        //   177: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   180: astore          lllllllllllllIIlllllIIIlIlIllIII
        //   182: new             Ljava/lang/StringBuilder;
        //   185: dup            
        //   186: aload           lllllllllllllIIlllllIIIlIlIllIIl
        //   188: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   191: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   194: getstatic       net/minecraft/util/text/TextFormatting.WHITE:Lnet/minecraft/util/text/TextFormatting;
        //   197: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   200: getstatic       net/minecraft/util/text/TextFormatting.OBFUSCATED:Lnet/minecraft/util/text/TextFormatting;
        //   203: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   206: ldc_w           "XXXXXXXX"
        //   209: iconst_0       
        //   210: aload           lllllllllllllIIlllllIIIlIlIlllII
        //   212: iconst_4       
        //   213: invokevirtual   java/util/Random.nextInt:(I)I
        //   216: iconst_3       
        //   217: iadd           
        //   218: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   221: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   224: aload           lllllllllllllIIlllllIIIlIlIllIII
        //   226: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   229: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   232: astore          lllllllllllllIIlllllIIIlIlIllIll
        //   234: aload           lllllllllllllIIlllllIIIlIlIllIll
        //   236: aload_2         /* lllllllllllllIIlllllIIIlIllIIIII */
        //   237: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   240: ifne            150
        //   243: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   244: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   247: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   248: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   251: getfield        net/minecraft/client/Minecraft.fontRendererObj:Lnet/minecraft/client/gui/FontRenderer;
        //   254: aload           lllllllllllllIIlllllIIIlIlIllIll
        //   256: sipush          274
        //   259: invokevirtual   net/minecraft/client/gui/FontRenderer.listFormattedStringToWidth:(Ljava/lang/String;I)Ljava/util/List;
        //   262: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   267: pop            
        //   268: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   269: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   272: ldc_w           ""
        //   275: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   280: pop            
        //   281: aload           lllllllllllllIIlllllIIIlIlIlllIl
        //   283: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   286: dup            
        //   287: astore          lllllllllllllIIlllllIIIlIlIllIlI
        //   289: ifnonnull       128
        //   292: aload           lllllllllllllIIlllllIIIlIlIllllI
        //   294: invokevirtual   java/io/InputStream.close:()V
        //   297: iconst_0       
        //   298: istore          lllllllllllllIIlllllIIIlIlIlIllI
        //   300: goto            319
        //   303: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   304: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   307: ldc_w           ""
        //   310: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   315: pop            
        //   316: iinc            lllllllllllllIIlllllIIIlIlIlIllI, 1
        //   319: iload           lllllllllllllIIlllllIIIlIlIlIllI
        //   321: bipush          8
        //   323: if_icmplt       303
        //   326: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   327: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   330: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //   333: new             Lnet/minecraft/util/ResourceLocation;
        //   336: dup            
        //   337: ldc_w           "texts/credits.txt"
        //   340: invokespecial   net/minecraft/util/ResourceLocation.<init>:(Ljava/lang/String;)V
        //   343: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //   348: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //   353: astore          lllllllllllllIIlllllIIIlIlIlIlIl
        //   355: new             Ljava/io/BufferedReader;
        //   358: dup            
        //   359: new             Ljava/io/InputStreamReader;
        //   362: dup            
        //   363: aload           lllllllllllllIIlllllIIIlIlIlIlIl
        //   365: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //   368: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //   371: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   374: astore          lllllllllllllIIlllllIIIlIlIlIlII
        //   376: goto            449
        //   379: aload           lllllllllllllIIlllllIIIlIlIlIIll
        //   381: ldc             "PLAYERNAME"
        //   383: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   384: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   387: invokevirtual   net/minecraft/client/Minecraft.getSession:()Lnet/minecraft/util/Session;
        //   390: invokevirtual   net/minecraft/util/Session.getUsername:()Ljava/lang/String;
        //   393: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   396: astore          lllllllllllllIIlllllIIIlIlIlIIll
        //   398: aload           lllllllllllllIIlllllIIIlIlIlIIll
        //   400: ldc_w           "\t"
        //   403: ldc_w           "    "
        //   406: invokevirtual   java/lang/String.replaceAll:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   409: astore          lllllllllllllIIlllllIIIlIlIlIIll
        //   411: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   412: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   415: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   416: getfield        net/minecraft/client/gui/GuiWinGame.mc:Lnet/minecraft/client/Minecraft;
        //   419: getfield        net/minecraft/client/Minecraft.fontRendererObj:Lnet/minecraft/client/gui/FontRenderer;
        //   422: aload           lllllllllllllIIlllllIIIlIlIlIIll
        //   424: sipush          274
        //   427: invokevirtual   net/minecraft/client/gui/FontRenderer.listFormattedStringToWidth:(Ljava/lang/String;I)Ljava/util/List;
        //   430: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   435: pop            
        //   436: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   437: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   440: ldc_w           ""
        //   443: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   448: pop            
        //   449: aload           lllllllllllllIIlllllIIIlIlIlIlII
        //   451: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   454: dup            
        //   455: astore          lllllllllllllIIlllllIIIlIlIlIIlI
        //   457: ifnonnull       379
        //   460: aload           lllllllllllllIIlllllIIIlIlIlIlIl
        //   462: invokevirtual   java/io/InputStream.close:()V
        //   465: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   466: aload_0         /* lllllllllllllIIlllllIIIlIlIlIIII */
        //   467: getfield        net/minecraft/client/gui/GuiWinGame.lines:Ljava/util/List;
        //   470: invokeinterface java/util/List.size:()I
        //   475: bipush          12
        //   477: imul           
        //   478: putfield        net/minecraft/client/gui/GuiWinGame.totalScrollLength:I
        //   481: goto            513
        //   484: astore_2        /* lllllllllllllIIlllllIIIlIlIlIIIl */
        //   485: getstatic       net/minecraft/client/gui/GuiWinGame.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   488: ldc_w           "Couldn't load credits"
        //   491: aload_2         /* lllllllllllllIIlllllIIIlIlIlIIIl */
        //   492: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   497: aload_1         /* lllllllllllllIIlllllIIIlIllIIIIl */
        //   498: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   501: goto            517
        //   504: astore          lllllllllllllIIlllllIIIlIlIIIlIl
        //   506: aload_1         /* lllllllllllllIIlllllIIIlIllIIIIl */
        //   507: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   510: aload           lllllllllllllIIlllllIIIlIlIIIlIl
        //   512: athrow         
        //   513: aload_1         /* lllllllllllllIIlllllIIIlIllIIIIl */
        //   514: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   517: return         
        //    StackMapTable: 00 0D FF 00 80 00 08 07 00 02 07 00 D4 07 00 BB 01 07 01 37 07 00 DA 07 00 EA 07 00 BB 00 00 15 FB 00 53 FA 00 2E FD 00 15 07 00 BB 01 0F FF 00 06 00 04 07 00 02 07 00 D4 07 00 BB 01 00 00 FE 00 34 07 01 37 07 00 DA 07 00 BB FA 00 45 FF 00 22 00 02 07 00 02 07 00 D4 00 01 07 00 99 53 07 01 78 FF 00 08 00 07 07 00 02 07 00 D4 07 00 BB 01 07 01 37 07 00 DA 07 00 BB 00 00 FF 00 03 00 01 07 00 02 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  16     481    484    504    Ljava/lang/Exception;
        //  16     497    504    513    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIlllllIIIlIIIlIlIl, final int lllllllllllllIIlllllIIIlIIIIIlII, final float lllllllllllllIIlllllIIIlIIIIIIll) {
        this.drawWinGameScreen(lllllllllllllIIlllllIIIlIIIlIlIl, lllllllllllllIIlllllIIIlIIIIIlII, lllllllllllllIIlllllIIIlIIIIIIll);
        final Tessellator lllllllllllllIIlllllIIIlIIIlIIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIlllllIIIlIIIlIIIl = lllllllllllllIIlllllIIIlIIIlIIlI.getBuffer();
        final int lllllllllllllIIlllllIIIlIIIlIIII = 274;
        final int lllllllllllllIIlllllIIIlIIIIllll = this.width / 2 - 137;
        final int lllllllllllllIIlllllIIIlIIIIlllI = this.height + 50;
        this.time += lllllllllllllIIlllllIIIlIIIIIIll;
        final float lllllllllllllIIlllllIIIlIIIIllIl = -this.time * this.scrollSpeed;
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, lllllllllllllIIlllllIIIlIIIIllIl, 0.0f);
        this.mc.getTextureManager().bindTexture(GuiWinGame.MINECRAFT_LOGO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableAlpha();
        this.drawTexturedModalRect(lllllllllllllIIlllllIIIlIIIIllll, lllllllllllllIIlllllIIIlIIIIlllI, 0, 0, 155, 44);
        this.drawTexturedModalRect(lllllllllllllIIlllllIIIlIIIIllll + 155, lllllllllllllIIlllllIIIlIIIIlllI, 0, 45, 155, 44);
        this.mc.getTextureManager().bindTexture(GuiWinGame.field_194401_g);
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIlllllIIIlIIIIllll + 88, lllllllllllllIIlllllIIIlIIIIlllI + 37, 0.0f, 0.0f, 98, 14, 128.0f, 16.0f);
        GlStateManager.disableAlpha();
        int lllllllllllllIIlllllIIIlIIIIllII = lllllllllllllIIlllllIIIlIIIIlllI + 100;
        for (int lllllllllllllIIlllllIIIlIIIIlIll = 0; lllllllllllllIIlllllIIIlIIIIlIll < this.lines.size(); ++lllllllllllllIIlllllIIIlIIIIlIll) {
            if (lllllllllllllIIlllllIIIlIIIIlIll == this.lines.size() - 1) {
                final float lllllllllllllIIlllllIIIlIIIIlIlI = lllllllllllllIIlllllIIIlIIIIllII + lllllllllllllIIlllllIIIlIIIIllIl - (this.height / 2 - 6);
                if (lllllllllllllIIlllllIIIlIIIIlIlI < 0.0f) {
                    GlStateManager.translate(0.0f, -lllllllllllllIIlllllIIIlIIIIlIlI, 0.0f);
                }
            }
            if (lllllllllllllIIlllllIIIlIIIIllII + lllllllllllllIIlllllIIIlIIIIllIl + 12.0f + 8.0f > 0.0f && lllllllllllllIIlllllIIIlIIIIllII + lllllllllllllIIlllllIIIlIIIIllIl < this.height) {
                final String lllllllllllllIIlllllIIIlIIIIlIIl = this.lines.get(lllllllllllllIIlllllIIIlIIIIlIll);
                if (lllllllllllllIIlllllIIIlIIIIlIIl.startsWith("[C]")) {
                    this.fontRendererObj.drawStringWithShadow(lllllllllllllIIlllllIIIlIIIIlIIl.substring(3), (float)(lllllllllllllIIlllllIIIlIIIIllll + (274 - this.fontRendererObj.getStringWidth(lllllllllllllIIlllllIIIlIIIIlIIl.substring(3))) / 2), (float)lllllllllllllIIlllllIIIlIIIIllII, 16777215);
                }
                else {
                    this.fontRendererObj.fontRandom.setSeed((long)(lllllllllllllIIlllllIIIlIIIIlIll * 4238972211L + this.time / 4.0f));
                    this.fontRendererObj.drawStringWithShadow(lllllllllllllIIlllllIIIlIIIIlIIl, (float)lllllllllllllIIlllllIIIlIIIIllll, (float)lllllllllllllIIlllllIIIlIIIIllII, 16777215);
                }
            }
            lllllllllllllIIlllllIIIlIIIIllII += 12;
        }
        GlStateManager.popMatrix();
        this.mc.getTextureManager().bindTexture(GuiWinGame.VIGNETTE_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);
        final int lllllllllllllIIlllllIIIlIIIIlIII = this.width;
        final int lllllllllllllIIlllllIIIlIIIIIlll = this.height;
        lllllllllllllIIlllllIIIlIIIlIIIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lllllllllllllIIlllllIIIlIIIlIIIl.pos(0.0, lllllllllllllIIlllllIIIlIIIIIlll, this.zLevel).tex(0.0, 1.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIIlIIIl.pos(lllllllllllllIIlllllIIIlIIIIlIII, lllllllllllllIIlllllIIIlIIIIIlll, this.zLevel).tex(1.0, 1.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIIlIIIl.pos(lllllllllllllIIlllllIIIlIIIIlIII, 0.0, this.zLevel).tex(1.0, 0.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIIlIIIl.pos(0.0, 0.0, this.zLevel).tex(0.0, 0.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIlllllIIIlIIIlIIlI.draw();
        GlStateManager.disableBlend();
        super.drawScreen(lllllllllllllIIlllllIIIlIIIlIlIl, lllllllllllllIIlllllIIIlIIIIIlII, lllllllllllllIIlllllIIIlIIIIIIll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");
        field_194401_g = new ResourceLocation("textures/gui/title/edition.png");
        VIGNETTE_TEXTURE = new ResourceLocation("textures/misc/vignette.png");
    }
    
    private void sendRespawnPacket() {
        this.field_193981_i.run();
        this.mc.displayGuiScreen(null);
    }
    
    public GuiWinGame(final boolean lllllllllllllIIlllllIIIllIIIIIIl, final Runnable lllllllllllllIIlllllIIIllIIIIIll) {
        this.scrollSpeed = 0.5f;
        this.field_193980_h = lllllllllllllIIlllllIIIllIIIIIIl;
        this.field_193981_i = lllllllllllllIIlllllIIIllIIIIIll;
        if (!lllllllllllllIIlllllIIIllIIIIIIl) {
            this.scrollSpeed = 0.75f;
        }
    }
    
    @Override
    public void updateScreen() {
        this.mc.getMusicTicker().update();
        this.mc.getSoundHandler().update();
        final float lllllllllllllIIlllllIIIlIlllllII = (this.totalScrollLength + this.height + this.height + 24) / this.scrollSpeed;
        if (this.time > lllllllllllllIIlllllIIIlIlllllII) {
            this.sendRespawnPacket();
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIIlllllIIIlIlllIllI, final int lllllllllllllIIlllllIIIlIlllIIll) throws IOException {
        if (lllllllllllllIIlllllIIIlIlllIIll == 1) {
            this.sendRespawnPacket();
        }
    }
}
