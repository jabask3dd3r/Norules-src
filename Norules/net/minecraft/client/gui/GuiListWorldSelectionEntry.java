package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.init.*;
import net.minecraft.client.audio.*;
import net.minecraft.world.*;
import java.util.*;
import org.apache.commons.lang3.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.text.*;
import net.minecraft.client.renderer.*;
import org.apache.logging.log4j.*;
import java.text.*;
import net.minecraft.world.storage.*;

public class GuiListWorldSelectionEntry implements GuiListExtended.IGuiListEntry
{
    private static final /* synthetic */ ResourceLocation ICON_OVERLAY_LOCATION;
    private final /* synthetic */ GuiListWorldSelection containingListSel;
    private final /* synthetic */ Minecraft client;
    private final /* synthetic */ GuiWorldSelection worldSelScreen;
    private final /* synthetic */ ResourceLocation iconLocation;
    private static final /* synthetic */ DateFormat DATE_FORMAT;
    private /* synthetic */ long lastClickTime;
    private /* synthetic */ File iconFile;
    private static final /* synthetic */ ResourceLocation ICON_MISSING;
    private final /* synthetic */ WorldSummary worldSummary;
    private /* synthetic */ DynamicTexture icon;
    
    private void loadWorld() {
        this.client.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
        if (this.client.getSaveLoader().canLoadWorld(this.worldSummary.getFileName())) {
            this.client.launchIntegratedServer(this.worldSummary.getFileName(), this.worldSummary.getDisplayName(), null);
        }
    }
    
    public GuiListWorldSelectionEntry(final GuiListWorldSelection lllllllllllllIIIllIIIIIIIIIlIIIl, final WorldSummary lllllllllllllIIIllIIIIIIIIIlIlII, final ISaveFormat lllllllllllllIIIllIIIIIIIIIIllll) {
        this.containingListSel = lllllllllllllIIIllIIIIIIIIIlIIIl;
        this.worldSelScreen = lllllllllllllIIIllIIIIIIIIIlIIIl.getGuiWorldSelection();
        this.worldSummary = lllllllllllllIIIllIIIIIIIIIlIlII;
        this.client = Minecraft.getMinecraft();
        this.iconLocation = new ResourceLocation(String.valueOf(new StringBuilder("worlds/").append(lllllllllllllIIIllIIIIIIIIIlIlII.getFileName()).append("/icon")));
        this.iconFile = lllllllllllllIIIllIIIIIIIIIIllll.getFile(lllllllllllllIIIllIIIIIIIIIlIlII.getFileName(), "icon.png");
        if (!this.iconFile.isFile()) {
            this.iconFile = null;
        }
        this.loadServerIcon();
    }
    
    public void editWorld() {
        this.client.displayGuiScreen(new GuiWorldEdit(this.worldSelScreen, this.worldSummary.getFileName()));
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIIIlIlllllllIllIlIl, final int lllllllllllllIIIlIlllllllIllIlII, final int lllllllllllllIIIlIlllllllIllIIll, final int lllllllllllllIIIlIlllllllIllIIlI, final int lllllllllllllIIIlIlllllllIllIIIl, final int lllllllllllllIIIlIlllllllIllIIII) {
    }
    
    private void loadServerIcon() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //     4: ifnull          21
        //     7: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //     8: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //    11: invokevirtual   java/io/File.isFile:()Z
        //    14: ifeq            21
        //    17: iconst_1       
        //    18: goto            22
        //    21: iconst_0       
        //    22: istore_1        /* lllllllllllllIIIlIlllllllIlllIIl */
        //    23: iload_1         /* lllllllllllllIIIlIlllllllIlllllI */
        //    24: ifeq            191
        //    27: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //    28: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //    31: invokestatic    javax/imageio/ImageIO.read:(Ljava/io/File;)Ljava/awt/image/BufferedImage;
        //    34: astore_2        /* lllllllllllllIIIlIlllllllIlllIII */
        //    35: aload_2         /* lllllllllllllIIIlIlllllllIllllIl */
        //    36: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    39: bipush          64
        //    41: if_icmpne       48
        //    44: iconst_1       
        //    45: goto            49
        //    48: iconst_0       
        //    49: ldc             "Must be 64 pixels wide"
        //    51: iconst_0       
        //    52: anewarray       Ljava/lang/Object;
        //    55: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    58: aload_2         /* lllllllllllllIIIlIlllllllIllllIl */
        //    59: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    62: bipush          64
        //    64: if_icmpne       71
        //    67: iconst_1       
        //    68: goto            72
        //    71: iconst_0       
        //    72: ldc             "Must be 64 pixels high"
        //    74: iconst_0       
        //    75: anewarray       Ljava/lang/Object;
        //    78: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    81: goto            109
        //    84: astore_3        /* lllllllllllllIIIlIlllllllIllIlll */
        //    85: getstatic       net/minecraft/client/gui/GuiListWorldSelectionEntry.LOGGER:Lorg/apache/logging/log4j/Logger;
        //    88: ldc             "Invalid icon for world {}"
        //    90: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //    91: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.worldSummary:Lnet/minecraft/world/storage/WorldSummary;
        //    94: invokevirtual   net/minecraft/world/storage/WorldSummary.getFileName:()Ljava/lang/String;
        //    97: aload_3         /* lllllllllllllIIIlIlllllllIlllIll */
        //    98: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   103: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   104: aconst_null    
        //   105: putfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconFile:Ljava/io/File;
        //   108: return         
        //   109: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   110: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   113: ifnonnull       154
        //   116: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   117: new             Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   120: dup            
        //   121: aload_2         /* lllllllllllllIIIlIlllllllIllllII */
        //   122: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   125: aload_2         /* lllllllllllllIIIlIlllllllIllllII */
        //   126: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   129: invokespecial   net/minecraft/client/renderer/texture/DynamicTexture.<init>:(II)V
        //   132: putfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   135: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   136: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.client:Lnet/minecraft/client/Minecraft;
        //   139: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   142: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   143: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconLocation:Lnet/minecraft/util/ResourceLocation;
        //   146: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   147: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   150: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.loadTexture:(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/ITextureObject;)Z
        //   153: pop            
        //   154: aload_2         /* lllllllllllllIIIlIlllllllIllllII */
        //   155: iconst_0       
        //   156: iconst_0       
        //   157: aload_2         /* lllllllllllllIIIlIlllllllIllllII */
        //   158: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   161: aload_2         /* lllllllllllllIIIlIlllllllIllllII */
        //   162: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   165: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   166: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   169: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.getTextureData:()[I
        //   172: iconst_0       
        //   173: aload_2         /* lllllllllllllIIIlIlllllllIllllII */
        //   174: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   177: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   180: pop            
        //   181: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   182: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   185: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.updateDynamicTexture:()V
        //   188: goto            214
        //   191: iload_1         /* lllllllllllllIIIlIlllllllIlllllI */
        //   192: ifne            214
        //   195: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   196: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.client:Lnet/minecraft/client/Minecraft;
        //   199: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   202: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   203: getfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.iconLocation:Lnet/minecraft/util/ResourceLocation;
        //   206: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.deleteTexture:(Lnet/minecraft/util/ResourceLocation;)V
        //   209: aload_0         /* lllllllllllllIIIlIlllllllIlllIlI */
        //   210: aconst_null    
        //   211: putfield        net/minecraft/client/gui/GuiListWorldSelectionEntry.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   214: return         
        //    StackMapTable: 00 0B 15 40 01 FD 00 19 01 07 00 CD 40 01 15 40 01 FF 00 0B 00 02 07 00 02 01 00 01 07 00 C5 FC 00 18 07 00 CD 2C FA 00 24 16
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  27     81     84     109    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public void func_192634_a(final int lllllllllllllIIIllIIIIIIIIIIIIlI, final int lllllllllllllIIIlIllllllllllIIIl, final int lllllllllllllIIIllIIIIIIIIIIIIII, final int lllllllllllllIIIlIllllllllllllll, final int lllllllllllllIIIlIlllllllllllllI, final int lllllllllllllIIIlIlllllllllIllll, final int lllllllllllllIIIlIllllllllllllII, final boolean lllllllllllllIIIlIlllllllllIlllI, final float lllllllllllllIIIlIlllllllllllIlI) {
        String lllllllllllllIIIlIlllllllllllIIl = this.worldSummary.getDisplayName();
        final String lllllllllllllIIIlIlllllllllllIII = String.valueOf(new StringBuilder(String.valueOf(this.worldSummary.getFileName())).append(" (").append(GuiListWorldSelectionEntry.DATE_FORMAT.format(new Date(this.worldSummary.getLastTimePlayed()))).append(")"));
        String lllllllllllllIIIlIllllllllllIlll = "";
        if (StringUtils.isEmpty((CharSequence)lllllllllllllIIIlIlllllllllllIIl)) {
            lllllllllllllIIIlIlllllllllllIIl = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.world", new Object[0]))).append(" ").append(lllllllllllllIIIllIIIIIIIIIIIIlI + 1));
        }
        if (this.worldSummary.requiresConversion()) {
            lllllllllllllIIIlIllllllllllIlll = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.conversion", new Object[0]))).append(" ").append(lllllllllllllIIIlIllllllllllIlll));
        }
        else {
            lllllllllllllIIIlIllllllllllIlll = I18n.format(String.valueOf(new StringBuilder("gameMode.").append(this.worldSummary.getEnumGameType().getName())), new Object[0]);
            if (this.worldSummary.isHardcoreModeEnabled()) {
                lllllllllllllIIIlIllllllllllIlll = String.valueOf(new StringBuilder().append(TextFormatting.DARK_RED).append(I18n.format("gameMode.hardcore", new Object[0])).append(TextFormatting.RESET));
            }
            if (this.worldSummary.getCheatsEnabled()) {
                lllllllllllllIIIlIllllllllllIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIllllllllllIlll)).append(", ").append(I18n.format("selectWorld.cheats", new Object[0])));
            }
            final String lllllllllllllIIIlIllllllllllIllI = this.worldSummary.getVersionName();
            if (this.worldSummary.markVersionInList()) {
                if (this.worldSummary.askToOpenWorld()) {
                    lllllllllllllIIIlIllllllllllIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIllllllllllIlll)).append(", ").append(I18n.format("selectWorld.version", new Object[0])).append(" ").append(TextFormatting.RED).append(lllllllllllllIIIlIllllllllllIllI).append(TextFormatting.RESET));
                }
                else {
                    lllllllllllllIIIlIllllllllllIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIllllllllllIlll)).append(", ").append(I18n.format("selectWorld.version", new Object[0])).append(" ").append(TextFormatting.ITALIC).append(lllllllllllllIIIlIllllllllllIllI).append(TextFormatting.RESET));
                }
            }
            else {
                lllllllllllllIIIlIllllllllllIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIllllllllllIlll)).append(", ").append(I18n.format("selectWorld.version", new Object[0])).append(" ").append(lllllllllllllIIIlIllllllllllIllI));
            }
        }
        this.client.fontRendererObj.drawString(lllllllllllllIIIlIlllllllllllIIl, lllllllllllllIIIlIllllllllllIIIl + 32 + 3, lllllllllllllIIIllIIIIIIIIIIIIII + 1, 16777215);
        this.client.fontRendererObj.drawString(lllllllllllllIIIlIlllllllllllIII, lllllllllllllIIIlIllllllllllIIIl + 32 + 3, lllllllllllllIIIllIIIIIIIIIIIIII + this.client.fontRendererObj.FONT_HEIGHT + 3, 8421504);
        this.client.fontRendererObj.drawString(lllllllllllllIIIlIllllllllllIlll, lllllllllllllIIIlIllllllllllIIIl + 32 + 3, lllllllllllllIIIllIIIIIIIIIIIIII + this.client.fontRendererObj.FONT_HEIGHT + this.client.fontRendererObj.FONT_HEIGHT + 3, 8421504);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.client.getTextureManager().bindTexture((this.icon != null) ? this.iconLocation : GuiListWorldSelectionEntry.ICON_MISSING);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlIllllllllllIIIl, lllllllllllllIIIllIIIIIIIIIIIIII, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
        GlStateManager.disableBlend();
        if (this.client.gameSettings.touchscreen || lllllllllllllIIIlIlllllllllIlllI) {
            this.client.getTextureManager().bindTexture(GuiListWorldSelectionEntry.ICON_OVERLAY_LOCATION);
            Gui.drawRect(lllllllllllllIIIlIllllllllllIIIl, lllllllllllllIIIllIIIIIIIIIIIIII, lllllllllllllIIIlIllllllllllIIIl + 32, lllllllllllllIIIllIIIIIIIIIIIIII + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int lllllllllllllIIIlIllllllllllIlIl = lllllllllllllIIIlIlllllllllIllll - lllllllllllllIIIlIllllllllllIIIl;
            final int lllllllllllllIIIlIllllllllllIlII = (lllllllllllllIIIlIllllllllllIlIl < 32) ? 32 : 0;
            if (this.worldSummary.markVersionInList()) {
                Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlIllllllllllIIIl, lllllllllllllIIIllIIIIIIIIIIIIII, 32.0f, (float)lllllllllllllIIIlIllllllllllIlII, 32, 32, 256.0f, 256.0f);
                if (this.worldSummary.askToOpenWorld()) {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlIllllllllllIIIl, lllllllllllllIIIllIIIIIIIIIIIIII, 96.0f, (float)lllllllllllllIIIlIllllllllllIlII, 32, 32, 256.0f, 256.0f);
                    if (lllllllllllllIIIlIllllllllllIlIl < 32) {
                        this.worldSelScreen.setVersionTooltip(String.valueOf(new StringBuilder().append(TextFormatting.RED).append(I18n.format("selectWorld.tooltip.fromNewerVersion1", new Object[0])).append("\n").append(TextFormatting.RED).append(I18n.format("selectWorld.tooltip.fromNewerVersion2", new Object[0]))));
                    }
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlIllllllllllIIIl, lllllllllllllIIIllIIIIIIIIIIIIII, 64.0f, (float)lllllllllllllIIIlIllllllllllIlII, 32, 32, 256.0f, 256.0f);
                    if (lllllllllllllIIIlIllllllllllIlIl < 32) {
                        this.worldSelScreen.setVersionTooltip(String.valueOf(new StringBuilder().append(TextFormatting.GOLD).append(I18n.format("selectWorld.tooltip.snapshot1", new Object[0])).append("\n").append(TextFormatting.GOLD).append(I18n.format("selectWorld.tooltip.snapshot2", new Object[0]))));
                    }
                }
            }
            else {
                Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlIllllllllllIIIl, lllllllllllllIIIllIIIIIIIIIIIIII, 0.0f, (float)lllllllllllllIIIlIllllllllllIlII, 32, 32, 256.0f, 256.0f);
            }
        }
    }
    
    public void deleteWorld() {
        this.client.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
            @Override
            public void confirmClicked(final boolean lllllllllllllIlIIlIIlIlIlIIIlIIl, final int lllllllllllllIlIIlIIlIlIlIIIlIII) {
                if (lllllllllllllIlIIlIIlIlIlIIIlIIl) {
                    GuiListWorldSelectionEntry.this.client.displayGuiScreen(new GuiScreenWorking());
                    final ISaveFormat lllllllllllllIlIIlIIlIlIlIIIIlll = GuiListWorldSelectionEntry.this.client.getSaveLoader();
                    lllllllllllllIlIIlIIlIlIlIIIIlll.flushCache();
                    lllllllllllllIlIIlIIlIlIlIIIIlll.deleteWorldDirectory(GuiListWorldSelectionEntry.this.worldSummary.getFileName());
                    GuiListWorldSelectionEntry.this.containingListSel.refreshList();
                }
                GuiListWorldSelectionEntry.this.client.displayGuiScreen(GuiListWorldSelectionEntry.this.worldSelScreen);
            }
        }, I18n.format("selectWorld.deleteQuestion", new Object[0]), String.valueOf(new StringBuilder("'").append(this.worldSummary.getDisplayName()).append("' ").append(I18n.format("selectWorld.deleteWarning", new Object[0]))), I18n.format("selectWorld.deleteButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 0));
    }
    
    @Override
    public void func_192633_a(final int lllllllllllllIIIlIlllllllIlIlllI, final int lllllllllllllIIIlIlllllllIlIllIl, final int lllllllllllllIIIlIlllllllIlIllII, final float lllllllllllllIIIlIlllllllIlIlIll) {
    }
    
    static {
        LOGGER = LogManager.getLogger();
        DATE_FORMAT = new SimpleDateFormat();
        ICON_MISSING = new ResourceLocation("textures/misc/unknown_server.png");
        ICON_OVERLAY_LOCATION = new ResourceLocation("textures/gui/world_selection.png");
    }
    
    public void recreateWorld() {
        this.client.displayGuiScreen(new GuiScreenWorking());
        final GuiCreateWorld lllllllllllllIIIlIllllllllIIllIl = new GuiCreateWorld(this.worldSelScreen);
        final ISaveHandler lllllllllllllIIIlIllllllllIIllII = this.client.getSaveLoader().getSaveLoader(this.worldSummary.getFileName(), false);
        final WorldInfo lllllllllllllIIIlIllllllllIIlIll = lllllllllllllIIIlIllllllllIIllII.loadWorldInfo();
        lllllllllllllIIIlIllllllllIIllII.flush();
        if (lllllllllllllIIIlIllllllllIIlIll != null) {
            lllllllllllllIIIlIllllllllIIllIl.recreateFromExistingWorld(lllllllllllllIIIlIllllllllIIlIll);
            this.client.displayGuiScreen(lllllllllllllIIIlIllllllllIIllIl);
        }
    }
    
    public void joinWorld() {
        if (this.worldSummary.askToOpenWorld()) {
            this.client.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                @Override
                public void confirmClicked(final boolean lllllllllllllIllIlIllllIlllIIllI, final int lllllllllllllIllIlIllllIlllIlIII) {
                    if (lllllllllllllIllIlIllllIlllIIllI) {
                        GuiListWorldSelectionEntry.this.loadWorld();
                    }
                    else {
                        GuiListWorldSelectionEntry.this.client.displayGuiScreen(GuiListWorldSelectionEntry.this.worldSelScreen);
                    }
                }
            }, I18n.format("selectWorld.versionQuestion", new Object[0]), I18n.format("selectWorld.versionWarning", this.worldSummary.getVersionName()), I18n.format("selectWorld.versionJoinButton", new Object[0]), I18n.format("gui.cancel", new Object[0]), 0));
        }
        else {
            this.loadWorld();
        }
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllllIIIlIllllllllIlllIl, final int lllllllllllllIIIlIlllllllllIIIll, final int lllllllllllllIIIlIlllllllllIIIlI, final int lllllllllllllIIIlIlllllllllIIIIl, final int lllllllllllllIIIlIlllllllllIIIII, final int lllllllllllllIIIlIllllllllIlllll) {
        this.containingListSel.selectWorld(lllllllllllllIIIlIllllllllIlllIl);
        if (lllllllllllllIIIlIlllllllllIIIII <= 32 && lllllllllllllIIIlIlllllllllIIIII < 32) {
            this.joinWorld();
            return true;
        }
        if (Minecraft.getSystemTime() - this.lastClickTime < 250L) {
            this.joinWorld();
            return true;
        }
        this.lastClickTime = Minecraft.getSystemTime();
        return false;
    }
}
