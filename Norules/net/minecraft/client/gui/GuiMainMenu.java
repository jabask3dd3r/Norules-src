package net.minecraft.client.gui;

import java.util.*;
import font.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import net.minecraft.realms.*;
import optifine.*;
import org.lwjgl.util.glu.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import com.google.common.util.concurrent.*;
import java.io.*;
import java.net.*;
import me.nrules.altmgr.*;
import ViaMCP.minecraft.viamcp1_12.gui.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.text.*;
import org.lwjgl.opengl.*;
import me.nrules.utils.render.*;

public class GuiMainMenu extends GuiScreen
{
    private /* synthetic */ GuiScreen realmsNotification;
    private static final /* synthetic */ ResourceLocation[] TITLE_PANORAMA_PATHS;
    private /* synthetic */ String openGLWarningLink;
    private /* synthetic */ int openGLWarningY1;
    private /* synthetic */ GuiButton modButton;
    private /* synthetic */ int field_193978_M;
    private /* synthetic */ GuiScreen modUpdateNotification;
    private /* synthetic */ String openGLWarning1;
    private /* synthetic */ int openGLWarningX1;
    private /* synthetic */ ResourceLocation backgroundTexture;
    private /* synthetic */ GLSLSandboxShader backgroundShader;
    private /* synthetic */ GuiButton buttonResetDemo;
    private /* synthetic */ float panoramaTimer;
    private /* synthetic */ long initTime;
    private /* synthetic */ int openGLWarning2Width;
    private /* synthetic */ int field_193979_N;
    private /* synthetic */ int openGLWarning1Width;
    private /* synthetic */ boolean hasCheckedForRealmsNotification;
    private final /* synthetic */ Object threadLock;
    private /* synthetic */ int openGLWarningY2;
    private /* synthetic */ String openGLWarning2;
    private /* synthetic */ DynamicTexture viewportTexture;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int openGLWarningX2;
    
    public GuiMainMenu() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   net/minecraft/client/gui/GuiScreen.<init>:()V
        //     4: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //     5: invokestatic    java/lang/System.currentTimeMillis:()J
        //     8: putfield        net/minecraft/client/gui/GuiMainMenu.initTime:J
        //    11: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //    12: getstatic       font/FontLoader.INSTANCE:Lfont/FontLoader;
        //    15: getfield        font/FontLoader.comforta_light_20:Lfont/MinecraftFontRenderer;
        //    18: putfield        net/minecraft/client/gui/GuiMainMenu.font:Lfont/MinecraftFontRenderer;
        //    21: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //    22: new             Ljava/lang/Object;
        //    25: dup            
        //    26: invokespecial   java/lang/Object.<init>:()V
        //    29: putfield        net/minecraft/client/gui/GuiMainMenu.threadLock:Ljava/lang/Object;
        //    32: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //    33: getstatic       net/minecraft/client/gui/GuiMainMenu.MORE_INFO_TEXT:Ljava/lang/String;
        //    36: putfield        net/minecraft/client/gui/GuiMainMenu.openGLWarning2:Ljava/lang/String;
        //    39: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //    40: ldc             "missingno"
        //    42: putfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //    45: aconst_null    
        //    46: astore_1        /* lllllllllllllIIllIIlllllIlIllllI */
        //    47: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    50: astore_2        /* lllllllllllllIIllIIlllllIlIlllIl */
        //    51: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //    54: invokevirtual   net/minecraft/client/Minecraft.getResourceManager:()Lnet/minecraft/client/resources/IResourceManager;
        //    57: getstatic       net/minecraft/client/gui/GuiMainMenu.SPLASH_TEXTS:Lnet/minecraft/util/ResourceLocation;
        //    60: invokeinterface net/minecraft/client/resources/IResourceManager.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    65: astore_1        /* lllllllllllllIIllIIlllllIlIllllI */
        //    66: new             Ljava/io/BufferedReader;
        //    69: dup            
        //    70: new             Ljava/io/InputStreamReader;
        //    73: dup            
        //    74: aload_1         /* lllllllllllllIIllIIlllllIlIllllI */
        //    75: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    80: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    83: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    86: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    89: astore_3        /* lllllllllllllIIllIIlllllIlIlllII */
        //    90: goto            117
        //    93: aload           lllllllllllllIIllIIlllllIlIllIll
        //    95: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //    98: astore          lllllllllllllIIllIIlllllIlIllIll
        //   100: aload           lllllllllllllIIllIIlllllIlIllIll
        //   102: invokevirtual   java/lang/String.isEmpty:()Z
        //   105: ifne            117
        //   108: aload_2         /* lllllllllllllIIllIIlllllIlIlllIl */
        //   109: aload           lllllllllllllIIllIIlllllIlIllIll
        //   111: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   116: pop            
        //   117: aload_3         /* lllllllllllllIIllIIlllllIlIlllII */
        //   118: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   121: dup            
        //   122: astore          lllllllllllllIIllIIlllllIlIllIlI
        //   124: ifnonnull       93
        //   127: aload_2         /* lllllllllllllIIllIIlllllIlIlllIl */
        //   128: invokeinterface java/util/List.isEmpty:()Z
        //   133: ifne            193
        //   136: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //   137: aload_2         /* lllllllllllllIIllIIlllllIlIlllIl */
        //   138: getstatic       net/minecraft/client/gui/GuiMainMenu.RANDOM:Ljava/util/Random;
        //   141: aload_2         /* lllllllllllllIIllIIlllllIlIlllIl */
        //   142: invokeinterface java/util/List.size:()I
        //   147: invokevirtual   java/util/Random.nextInt:(I)I
        //   150: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   155: checkcast       Ljava/lang/String;
        //   158: putfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //   161: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //   162: getfield        net/minecraft/client/gui/GuiMainMenu.splashText:Ljava/lang/String;
        //   165: invokevirtual   java/lang/String.hashCode:()I
        //   168: ldc             125780783
        //   170: if_icmpeq       136
        //   173: goto            193
        //   176: astore_2       
        //   177: aload_1         /* lllllllllllllIIllIIlllllIlIllllI */
        //   178: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   181: goto            197
        //   184: astore          lllllllllllllIIllIIlllllIlIlIIll
        //   186: aload_1         /* lllllllllllllIIllIIlllllIlIllllI */
        //   187: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   190: aload           lllllllllllllIIllIIlllllIlIlIIll
        //   192: athrow         
        //   193: aload_1         /* lllllllllllllIIllIIlllllIlIllllI */
        //   194: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //   197: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //   198: getstatic       net/minecraft/client/gui/GuiMainMenu.RANDOM:Ljava/util/Random;
        //   201: invokevirtual   java/util/Random.nextFloat:()F
        //   204: putfield        net/minecraft/client/gui/GuiMainMenu.updateCounter:F
        //   207: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //   208: ldc             ""
        //   210: putfield        net/minecraft/client/gui/GuiMainMenu.openGLWarning1:Ljava/lang/String;
        //   213: aload_0         /* lllllllllllllIIllIIlllllIlIllIII */
        //   214: new             Lme/nrules/utils/render/GLSLSandboxShader;
        //   217: dup            
        //   218: ldc             "/assets/minecraft/nrules/shaders/noise.fsh"
        //   220: invokespecial   me/nrules/utils/render/GLSLSandboxShader.<init>:(Ljava/lang/String;)V
        //   223: putfield        net/minecraft/client/gui/GuiMainMenu.backgroundShader:Lme/nrules/utils/render/GLSLSandboxShader;
        //   226: goto            241
        //   229: astore_2        /* lllllllllllllIIllIIlllllIlIllIIl */
        //   230: new             Ljava/lang/IllegalStateException;
        //   233: dup            
        //   234: ldc             "Failed to load backgound shader"
        //   236: aload_2         /* lllllllllllllIIllIIlllllIlIllIIl */
        //   237: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   240: athrow         
        //   241: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  47     173    176    184    Ljava/io/IOException;
        //  47     177    184    193    Any
        //  213    226    229    241    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void rotateAndBlurSkybox() {
        this.mc.getTextureManager().bindTexture(this.backgroundTexture);
        GlStateManager.glTexParameteri(3553, 10241, 9729);
        GlStateManager.glTexParameteri(3553, 10240, 9729);
        GlStateManager.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.colorMask(true, true, true, false);
        final Tessellator lllllllllllllIIllIIllllIllIIIlIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIllIIllllIllIIIlII = lllllllllllllIIllIIllllIllIIIlIl.getBuffer();
        lllllllllllllIIllIIllllIllIIIlII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        GlStateManager.disableAlpha();
        final int lllllllllllllIIllIIllllIllIIIIll = 3;
        int lllllllllllllIIllIIllllIllIIIIlI = 3;
        final CustomPanoramaProperties lllllllllllllIIllIIllllIllIIIIIl = CustomPanorama.getCustomPanoramaProperties();
        if (lllllllllllllIIllIIllllIllIIIIIl != null) {
            lllllllllllllIIllIIllllIllIIIIlI = lllllllllllllIIllIIllllIllIIIIIl.getBlur2();
        }
        for (int lllllllllllllIIllIIllllIllIIIIII = 0; lllllllllllllIIllIIllllIllIIIIII < lllllllllllllIIllIIllllIllIIIIlI; ++lllllllllllllIIllIIllllIllIIIIII) {
            final float lllllllllllllIIllIIllllIlIllllll = 1.0f / (lllllllllllllIIllIIllllIllIIIIII + 1);
            final int lllllllllllllIIllIIllllIlIlllllI = this.width;
            final int lllllllllllllIIllIIllllIlIllllIl = this.height;
            final float lllllllllllllIIllIIllllIlIllllII = (lllllllllllllIIllIIllllIllIIIIII - 1) / 256.0f;
            lllllllllllllIIllIIllllIllIIIlII.pos(lllllllllllllIIllIIllllIlIlllllI, lllllllllllllIIllIIllllIlIllllIl, this.zLevel).tex(0.0f + lllllllllllllIIllIIllllIlIllllII, 1.0).color(1.0f, 1.0f, 1.0f, lllllllllllllIIllIIllllIlIllllll).endVertex();
            lllllllllllllIIllIIllllIllIIIlII.pos(lllllllllllllIIllIIllllIlIlllllI, 0.0, this.zLevel).tex(1.0f + lllllllllllllIIllIIllllIlIllllII, 1.0).color(1.0f, 1.0f, 1.0f, lllllllllllllIIllIIllllIlIllllll).endVertex();
            lllllllllllllIIllIIllllIllIIIlII.pos(0.0, 0.0, this.zLevel).tex(1.0f + lllllllllllllIIllIIllllIlIllllII, 0.0).color(1.0f, 1.0f, 1.0f, lllllllllllllIIllIIllllIlIllllll).endVertex();
            lllllllllllllIIllIIllllIllIIIlII.pos(0.0, lllllllllllllIIllIIllllIlIllllIl, this.zLevel).tex(0.0f + lllllllllllllIIllIIllllIlIllllII, 0.0).color(1.0f, 1.0f, 1.0f, lllllllllllllIIllIIllllIlIllllll).endVertex();
        }
        lllllllllllllIIllIIllllIllIIIlIl.draw();
        GlStateManager.enableAlpha();
        GlStateManager.colorMask(true, true, true, true);
    }
    
    @Override
    public void initGui() {
        this.viewportTexture = new DynamicTexture(256, 256);
        this.backgroundTexture = this.mc.getTextureManager().getDynamicTextureLocation("1", this.viewportTexture);
        this.field_193978_M = this.fontRendererObj.getStringWidth("1");
        this.field_193979_N = this.width - this.field_193978_M - 49;
        final int lllllllllllllIIllIIlllllIlIIIIlI = 24;
        final int lllllllllllllIIllIIlllllIlIIIIIl = this.height / 4 + 48;
        if (this.mc.isDemo()) {
            this.addDemoButtons(lllllllllllllIIllIIlllllIlIIIIIl, 24);
        }
        else {
            this.addSingleplayerMultiplayerButtons(lllllllllllllIIllIIlllllIlIIIIIl, 24);
        }
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, lllllllllllllIIllIIlllllIlIIIIIl + 72 + 12, 98, 20, I18n.format("menu.options", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 2, lllllllllllllIIllIIlllllIlIIIIIl + 72 + 12, 98, 20, I18n.format("menu.quit", new Object[0])));
        this.buttonList.add(new GuiButtonLanguage(5, this.width / 2 + 2, lllllllllllllIIllIIlllllIlIIIIIl + 52));
        this.buttonList.add(new GuiButton(69, this.width / 2 - 99, lllllllllllllIIllIIlllllIlIIIIIl + 52, 98, 20, "Version"));
        synchronized (this.threadLock) {
            this.openGLWarning1Width = this.fontRendererObj.getStringWidth(this.openGLWarning1);
            this.openGLWarning2Width = this.fontRendererObj.getStringWidth(this.openGLWarning2);
            final int lllllllllllllIIllIIlllllIlIIIIII = Math.max(this.openGLWarning1Width, this.openGLWarning2Width);
            this.openGLWarningX1 = (this.width - lllllllllllllIIllIIlllllIlIIIIII) / 2;
            this.openGLWarningY1 = this.buttonList.get(0).yPosition - 24;
            this.openGLWarningX2 = this.openGLWarningX1 + lllllllllllllIIllIIlllllIlIIIIII;
            this.openGLWarningY2 = this.openGLWarningY1 + 24;
        }
        // monitorexit(this.threadLock)
        this.mc.setConnectedToRealms(false);
        this.initTime = System.currentTimeMillis();
        if (Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS) && !this.hasCheckedForRealmsNotification) {
            final RealmsBridge lllllllllllllIIllIIlllllIIllllll = new RealmsBridge();
            this.realmsNotification = lllllllllllllIIllIIlllllIIllllll.getNotificationScreen(this);
            this.hasCheckedForRealmsNotification = true;
        }
        if (this.areRealmsNotificationsEnabled()) {
            this.realmsNotification.setGuiSize(this.width, this.height);
            this.realmsNotification.initGui();
        }
        if (Reflector.NotificationModUpdateScreen_init.exists()) {
            this.modUpdateNotification = (GuiScreen)Reflector.call(Reflector.NotificationModUpdateScreen_init, this, this.modButton);
        }
    }
    
    private void drawPanorama(final int lllllllllllllIIllIIllllIlllIllll, final int lllllllllllllIIllIIllllIlllIlllI, final float lllllllllllllIIllIIllllIlllIllIl) {
        final Tessellator lllllllllllllIIllIIllllIlllIllII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIllIIllllIlllIlIll = lllllllllllllIIllIIllllIlllIllII.getBuffer();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        Project.gluPerspective(120.0f, 1.0f, 0.05f, 10.0f);
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.disableCull();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final int lllllllllllllIIllIIllllIlllIlIlI = 8;
        int lllllllllllllIIllIIllllIlllIlIIl = 64;
        final CustomPanoramaProperties lllllllllllllIIllIIllllIlllIlIII = CustomPanorama.getCustomPanoramaProperties();
        if (lllllllllllllIIllIIllllIlllIlIII != null) {
            lllllllllllllIIllIIllllIlllIlIIl = lllllllllllllIIllIIllllIlllIlIII.getBlur1();
        }
        for (int lllllllllllllIIllIIllllIlllIIlll = 0; lllllllllllllIIllIIllllIlllIIlll < lllllllllllllIIllIIllllIlllIlIIl; ++lllllllllllllIIllIIllllIlllIIlll) {
            GlStateManager.pushMatrix();
            final float lllllllllllllIIllIIllllIlllIIllI = (lllllllllllllIIllIIllllIlllIIlll % 8 / 8.0f - 0.5f) / 64.0f;
            final float lllllllllllllIIllIIllllIlllIIlIl = (lllllllllllllIIllIIllllIlllIIlll / 8 / 8.0f - 0.5f) / 64.0f;
            final float lllllllllllllIIllIIllllIlllIIlII = 0.0f;
            GlStateManager.translate(lllllllllllllIIllIIllllIlllIIllI, lllllllllllllIIllIIllllIlllIIlIl, 0.0f);
            GlStateManager.rotate(MathHelper.sin(this.panoramaTimer / 400.0f) * 25.0f + 20.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(-this.panoramaTimer * 0.1f, 0.0f, 1.0f, 0.0f);
            for (int lllllllllllllIIllIIllllIlllIIIll = 0; lllllllllllllIIllIIllllIlllIIIll < 6; ++lllllllllllllIIllIIllllIlllIIIll) {
                GlStateManager.pushMatrix();
                if (lllllllllllllIIllIIllllIlllIIIll == 1) {
                    GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (lllllllllllllIIllIIllllIlllIIIll == 2) {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                }
                if (lllllllllllllIIllIIllllIlllIIIll == 3) {
                    GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
                }
                if (lllllllllllllIIllIIllllIlllIIIll == 4) {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllllIIllIIllllIlllIIIll == 5) {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                ResourceLocation[] lllllllllllllIIllIIllllIlllIIIlI = GuiMainMenu.TITLE_PANORAMA_PATHS;
                if (lllllllllllllIIllIIllllIlllIlIII != null) {
                    lllllllllllllIIllIIllllIlllIIIlI = lllllllllllllIIllIIllllIlllIlIII.getPanoramaLocations();
                }
                this.mc.getTextureManager().bindTexture(lllllllllllllIIllIIllllIlllIIIlI[lllllllllllllIIllIIllllIlllIIIll]);
                lllllllllllllIIllIIllllIlllIlIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                final int lllllllllllllIIllIIllllIlllIIIIl = 255 / (lllllllllllllIIllIIllllIlllIIlll + 1);
                final float lllllllllllllIIllIIllllIlllIIIII = 0.0f;
                lllllllllllllIIllIIllllIlllIlIll.pos(-1.0, -1.0, 1.0).tex(0.0, 0.0).color(255, 255, 255, lllllllllllllIIllIIllllIlllIIIIl).endVertex();
                lllllllllllllIIllIIllllIlllIlIll.pos(1.0, -1.0, 1.0).tex(1.0, 0.0).color(255, 255, 255, lllllllllllllIIllIIllllIlllIIIIl).endVertex();
                lllllllllllllIIllIIllllIlllIlIll.pos(1.0, 1.0, 1.0).tex(1.0, 1.0).color(255, 255, 255, lllllllllllllIIllIIllllIlllIIIIl).endVertex();
                lllllllllllllIIllIIllllIlllIlIll.pos(-1.0, 1.0, 1.0).tex(0.0, 1.0).color(255, 255, 255, lllllllllllllIIllIIllllIlllIIIIl).endVertex();
                lllllllllllllIIllIIllllIlllIllII.draw();
                GlStateManager.popMatrix();
            }
            GlStateManager.popMatrix();
            GlStateManager.colorMask(true, true, true, false);
        }
        lllllllllllllIIllIIllllIlllIlIll.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.matrixMode(5889);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
    }
    
    private boolean areRealmsNotificationsEnabled() {
        return Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS) && this.realmsNotification != null;
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIIllIIllllIIlllIIII, final int lllllllllllllIIllIIllllIIlllIlII, final int lllllllllllllIIllIIllllIIlllIIll) throws IOException {
        super.mouseClicked(lllllllllllllIIllIIllllIIlllIIII, lllllllllllllIIllIIllllIIlllIlII, lllllllllllllIIllIIllllIIlllIIll);
        synchronized (this.threadLock) {
            if (!this.openGLWarning1.isEmpty() && !StringUtils.isNullOrEmpty(this.openGLWarningLink) && lllllllllllllIIllIIllllIIlllIIII >= this.openGLWarningX1 && lllllllllllllIIllIIllllIIlllIIII <= this.openGLWarningX2 && lllllllllllllIIllIIllllIIlllIlII >= this.openGLWarningY1 && lllllllllllllIIllIIllllIIlllIlII <= this.openGLWarningY2) {
                final GuiConfirmOpenLink lllllllllllllIIllIIllllIIlllIIlI = new GuiConfirmOpenLink(this, this.openGLWarningLink, 13, true);
                lllllllllllllIIllIIllllIIlllIIlI.disableSecurityWarning();
                this.mc.displayGuiScreen(lllllllllllllIIllIIllllIIlllIIlI);
            }
        }
        // monitorexit(this.threadLock)
        if (lllllllllllllIIllIIllllIIlllIIII > this.field_193979_N && lllllllllllllIIllIIllllIIlllIIII < this.field_193979_N + this.field_193978_M && lllllllllllllIIllIIllllIIlllIlII > this.height - 10 && lllllllllllllIIllIIllllIIlllIlII < this.height) {
            this.mc.displayGuiScreen(new GuiWinGame(false, Runnables.doNothing()));
        }
    }
    
    @Override
    public void confirmClicked(final boolean lllllllllllllIIllIIlllllIIIIIIlI, final int lllllllllllllIIllIIlllllIIIIlIII) {
        if (lllllllllllllIIllIIlllllIIIIIIlI && lllllllllllllIIllIIlllllIIIIlIII == 12) {
            final ISaveFormat lllllllllllllIIllIIlllllIIIIIlll = this.mc.getSaveLoader();
            lllllllllllllIIllIIlllllIIIIIlll.flushCache();
            lllllllllllllIIllIIlllllIIIIIlll.deleteWorldDirectory("Demo_World");
            this.mc.displayGuiScreen(this);
        }
        else if (lllllllllllllIIllIIlllllIIIIlIII == 12) {
            this.mc.displayGuiScreen(this);
        }
        else if (lllllllllllllIIllIIlllllIIIIlIII == 13) {
            if (lllllllllllllIIllIIlllllIIIIIIlI) {
                try {
                    final Class<?> lllllllllllllIIllIIlllllIIIIIllI = Class.forName("java.awt.Desktop");
                    final Object lllllllllllllIIllIIlllllIIIIIlIl = lllllllllllllIIllIIlllllIIIIIllI.getMethod("getDesktop", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
                    lllllllllllllIIllIIlllllIIIIIllI.getMethod("browse", URI.class).invoke(lllllllllllllIIllIIlllllIIIIIlIl, new URI(this.openGLWarningLink));
                }
                catch (Throwable lllllllllllllIIllIIlllllIIIIIlII) {
                    GuiMainMenu.LOGGER.error("Couldn't open link", lllllllllllllIIllIIlllllIIIIIlII);
                }
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIllIIlllllIIIllIII) throws IOException {
        if (lllllllllllllIIllIIlllllIIIllIII.id == 0) {
            this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 5) {
            this.mc.displayGuiScreen(new GuiAltLogin(this));
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 1) {
            this.mc.displayGuiScreen(new GuiWorldSelection(this));
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 2) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 69) {
            this.mc.displayGuiScreen(new GuiProtocolSelector(this));
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 4) {
            this.mc.shutdown();
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 6 && Reflector.GuiModList_Constructor.exists()) {
            this.mc.displayGuiScreen((GuiScreen)Reflector.newInstance(Reflector.GuiModList_Constructor, this));
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 11) {
            this.mc.launchIntegratedServer("Demo_World", "Demo_World", WorldServerDemo.DEMO_WORLD_SETTINGS);
        }
        if (lllllllllllllIIllIIlllllIIIllIII.id == 12) {
            final ISaveFormat lllllllllllllIIllIIlllllIIIllIll = this.mc.getSaveLoader();
            final WorldInfo lllllllllllllIIllIIlllllIIIllIlI = lllllllllllllIIllIIlllllIIIllIll.getWorldInfo("Demo_World");
            if (lllllllllllllIIllIIlllllIIIllIlI != null) {
                this.mc.displayGuiScreen(new GuiYesNo(this, I18n.format("selectWorld.deleteQuestion", new Object[0]), String.valueOf(new StringBuilder("'").append(lllllllllllllIIllIIlllllIIIllIlI.getWorldName()).append("' ").append(I18n.format("selectWorld.deleteWarning", new Object[0]))), I18n.format("selectWorld.deleteButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 12));
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        RANDOM = new Random();
        MORE_INFO_TEXT = String.valueOf(new StringBuilder("Please click ").append(TextFormatting.UNDERLINE).append("here").append(TextFormatting.RESET).append(" for more information."));
        SPLASH_TEXTS = new ResourceLocation("texts/splashes.txt");
        MINECRAFT_TITLE_TEXTURES = new ResourceLocation("textures/gui/title/minecraft.png");
        field_194400_H = new ResourceLocation("textures/gui/title/edition.png");
        TITLE_PANORAMA_PATHS = new ResourceLocation[] { new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png") };
    }
    
    private void switchToRealms() {
        final RealmsBridge lllllllllllllIIllIIlllllIIIlIIlI = new RealmsBridge();
        lllllllllllllIIllIIlllllIIIlIIlI.switchToRealms(this);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIllIIllllIIlllllll, final int lllllllllllllIIllIIllllIIllllllI, final float lllllllllllllIIllIIllllIlIIIIIIl) {
        this.panoramaTimer += lllllllllllllIIllIIllllIlIIIIIIl;
        this.drawDefaultBackground();
        GlStateManager.enableAlpha();
        GlStateManager.disableCull();
        this.backgroundShader.useShader(this.width, this.height, (float)lllllllllllllIIllIIllllIIlllllll, (float)lllllllllllllIIllIIllllIIllllllI, (System.currentTimeMillis() - this.initTime) / 1000.0f);
        GL11.glBegin(7);
        GL11.glVertex2f(-1.0f, -1.0f);
        GL11.glVertex2f(-1.0f, 1.0f);
        GL11.glVertex2f(1.0f, 1.0f);
        GL11.glVertex2f(1.0f, -1.0f);
        GL11.glEnd();
        GL20.glUseProgram(0);
        RenderUtils.drawTexture(new ResourceLocation("nrules/bebra.png"), this.width / 2 - 148, this.height / 4 - 50, 300.0, 100.0);
        RenderUtils.drawTexture(new ResourceLocation("nrules/dfd.png"), this.width / 2 - 85, this.height / 4 - 7, 180.0, 60.0);
        super.drawScreen(lllllllllllllIIllIIllllIIlllllll, lllllllllllllIIllIIllllIIllllllI, lllllllllllllIIllIIllllIlIIIIIIl);
    }
    
    private void renderSkybox(final int lllllllllllllIIllIIllllIlIlIIIlI, final int lllllllllllllIIllIIllllIlIlIIIIl, final float lllllllllllllIIllIIllllIlIlIIIII) {
        this.mc.getFramebuffer().unbindFramebuffer();
        GlStateManager.viewport(0, 0, 256, 256);
        this.drawPanorama(lllllllllllllIIllIIllllIlIlIIIlI, lllllllllllllIIllIIllllIlIlIIIIl, lllllllllllllIIllIIllllIlIlIIIII);
        this.rotateAndBlurSkybox();
        int lllllllllllllIIllIIllllIlIIlllll = 3;
        final CustomPanoramaProperties lllllllllllllIIllIIllllIlIIllllI = CustomPanorama.getCustomPanoramaProperties();
        if (lllllllllllllIIllIIllllIlIIllllI != null) {
            lllllllllllllIIllIIllllIlIIlllll = lllllllllllllIIllIIllllIlIIllllI.getBlur3();
        }
        for (int lllllllllllllIIllIIllllIlIIlllIl = 0; lllllllllllllIIllIIllllIlIIlllIl < lllllllllllllIIllIIllllIlIIlllll; ++lllllllllllllIIllIIllllIlIIlllIl) {
            this.rotateAndBlurSkybox();
            this.rotateAndBlurSkybox();
        }
        this.mc.getFramebuffer().bindFramebuffer(true);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        final float lllllllllllllIIllIIllllIlIIlllII = 120.0f / ((this.width > this.height) ? this.width : this.height);
        final float lllllllllllllIIllIIllllIlIIllIll = this.height * lllllllllllllIIllIIllllIlIIlllII / 256.0f;
        final float lllllllllllllIIllIIllllIlIIllIlI = this.width * lllllllllllllIIllIIllllIlIIlllII / 256.0f;
        final int lllllllllllllIIllIIllllIlIIllIIl = this.width;
        final int lllllllllllllIIllIIllllIlIIllIII = this.height;
        final Tessellator lllllllllllllIIllIIllllIlIIlIlll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIllIIllllIlIIlIllI = lllllllllllllIIllIIllllIlIIlIlll.getBuffer();
        lllllllllllllIIllIIllllIlIIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lllllllllllllIIllIIllllIlIIlIllI.pos(0.0, lllllllllllllIIllIIllllIlIIllIII, this.zLevel).tex(0.5f - lllllllllllllIIllIIllllIlIIllIll, 0.5f + lllllllllllllIIllIIllllIlIIllIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIllIIllllIlIIlIllI.pos(lllllllllllllIIllIIllllIlIIllIIl, lllllllllllllIIllIIllllIlIIllIII, this.zLevel).tex(0.5f - lllllllllllllIIllIIllllIlIIllIll, 0.5f - lllllllllllllIIllIIllllIlIIllIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIllIIllllIlIIlIllI.pos(lllllllllllllIIllIIllllIlIIllIIl, 0.0, this.zLevel).tex(0.5f + lllllllllllllIIllIIllllIlIIllIll, 0.5f - lllllllllllllIIllIIllllIlIIllIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIllIIllllIlIIlIllI.pos(0.0, 0.0, this.zLevel).tex(0.5f + lllllllllllllIIllIIllllIlIIllIll, 0.5f + lllllllllllllIIllIIllllIlIIllIlI).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        lllllllllllllIIllIIllllIlIIlIlll.draw();
    }
    
    @Override
    public void onGuiClosed() {
        if (this.realmsNotification != null) {
            this.realmsNotification.onGuiClosed();
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIIllIIlllllIlIIlIlI, final int lllllllllllllIIllIIlllllIlIIlIIl) throws IOException {
    }
    
    private void addDemoButtons(final int lllllllllllllIIllIIlllllIIlIIlIl, final int lllllllllllllIIllIIlllllIIlIIlII) {
        this.buttonList.add(new GuiButton(11, this.width / 2 - 100, lllllllllllllIIllIIlllllIIlIIlIl, I18n.format("menu.playdemo", new Object[0])));
        this.buttonResetDemo = this.addButton(new GuiButton(12, this.width / 2 - 100, lllllllllllllIIllIIlllllIIlIIlIl + lllllllllllllIIllIIlllllIIlIIlII * 1, I18n.format("menu.resetdemo", new Object[0])));
        final ISaveFormat lllllllllllllIIllIIlllllIIlIlIII = this.mc.getSaveLoader();
        final WorldInfo lllllllllllllIIllIIlllllIIlIIlll = lllllllllllllIIllIIlllllIIlIlIII.getWorldInfo("Demo_World");
        if (lllllllllllllIIllIIlllllIIlIIlll == null) {
            this.buttonResetDemo.enabled = false;
        }
    }
    
    private void addSingleplayerMultiplayerButtons(final int lllllllllllllIIllIIlllllIIllIlIl, final int lllllllllllllIIllIIlllllIIllIlII) {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, lllllllllllllIIllIIlllllIIllIlIl, I18n.format("menu.singleplayer", new Object[0])));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, lllllllllllllIIllIIlllllIIllIlIl + lllllllllllllIIllIIlllllIIllIlII * 1, I18n.format("menu.multiplayer", new Object[0])));
    }
    
    @Override
    public void updateScreen() {
        if (this.areRealmsNotificationsEnabled()) {
            this.realmsNotification.updateScreen();
        }
    }
}
