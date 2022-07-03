package net.minecraft.client.gui;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.client.resources.*;
import java.net.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import org.apache.logging.log4j.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;

public class ServerListEntryNormal implements GuiListExtended.IGuiListEntry
{
    private /* synthetic */ DynamicTexture icon;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ ServerData server;
    private static final /* synthetic */ ResourceLocation SERVER_SELECTION_BUTTONS;
    private final /* synthetic */ GuiMultiplayer owner;
    private /* synthetic */ String lastIconB64;
    private /* synthetic */ long lastClickTime;
    private static final /* synthetic */ ThreadPoolExecutor EXECUTOR;
    private static final /* synthetic */ ResourceLocation UNKNOWN_SERVER;
    private final /* synthetic */ ResourceLocation serverIcon;
    
    @Override
    public void func_192634_a(final int lllllllllllllIIIlllIlIllllIIlIIl, final int lllllllllllllIIIlllIlIllllIIlIII, final int lllllllllllllIIIlllIlIllllIIIlll, final int lllllllllllllIIIlllIlIllllIIIllI, final int lllllllllllllIIIlllIlIllllIIIlIl, final int lllllllllllllIIIlllIlIlllIlIIIlI, final int lllllllllllllIIIlllIlIllllIIIIll, final boolean lllllllllllllIIIlllIlIllllIIIIlI, final float lllllllllllllIIIlllIlIllllIIIIIl) {
        if (!this.server.pinged) {
            this.server.pinged = true;
            this.server.pingToServer = -2L;
            this.server.serverMOTD = "";
            this.server.populationInfo = "";
            ServerListEntryNormal.EXECUTOR.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        ServerListEntryNormal.this.owner.getOldServerPinger().ping(ServerListEntryNormal.this.server);
                    }
                    catch (UnknownHostException llllllllllllllIIIllIIIlIlllIllII) {
                        ServerListEntryNormal.this.server.pingToServer = -1L;
                        ServerListEntryNormal.this.server.serverMOTD = String.valueOf(new StringBuilder().append(TextFormatting.DARK_RED).append(I18n.format("multiplayer.status.cannot_resolve", new Object[0])));
                    }
                    catch (Exception llllllllllllllIIIllIIIlIlllIlIll) {
                        ServerListEntryNormal.this.server.pingToServer = -1L;
                        ServerListEntryNormal.this.server.serverMOTD = String.valueOf(new StringBuilder().append(TextFormatting.DARK_RED).append(I18n.format("multiplayer.status.cannot_connect", new Object[0])));
                    }
                }
            });
        }
        final boolean lllllllllllllIIIlllIlIllllIIIIII = this.server.version > 340;
        final boolean lllllllllllllIIIlllIlIlllIllllll = this.server.version < 340;
        final boolean lllllllllllllIIIlllIlIlllIlllllI = lllllllllllllIIIlllIlIllllIIIIII || lllllllllllllIIIlllIlIlllIllllll;
        this.mc.fontRendererObj.drawString(this.server.serverName, lllllllllllllIIIlllIlIllllIIlIII + 32 + 3, lllllllllllllIIIlllIlIllllIIIlll + 1, 16777215);
        final List<String> lllllllllllllIIIlllIlIlllIllllIl = this.mc.fontRendererObj.listFormattedStringToWidth(this.server.serverMOTD, lllllllllllllIIIlllIlIllllIIIllI - 32 - 2);
        for (int lllllllllllllIIIlllIlIlllIllllII = 0; lllllllllllllIIIlllIlIlllIllllII < Math.min(lllllllllllllIIIlllIlIlllIllllIl.size(), 2); ++lllllllllllllIIIlllIlIlllIllllII) {
            this.mc.fontRendererObj.drawString(lllllllllllllIIIlllIlIlllIllllIl.get(lllllllllllllIIIlllIlIlllIllllII), lllllllllllllIIIlllIlIllllIIlIII + 32 + 3, lllllllllllllIIIlllIlIllllIIIlll + 12 + this.mc.fontRendererObj.FONT_HEIGHT * lllllllllllllIIIlllIlIlllIllllII, 8421504);
        }
        final String lllllllllllllIIIlllIlIlllIlllIll = lllllllllllllIIIlllIlIlllIlllllI ? String.valueOf(new StringBuilder().append(TextFormatting.DARK_RED).append(this.server.gameVersion)) : this.server.populationInfo;
        final int lllllllllllllIIIlllIlIlllIlllIlI = this.mc.fontRendererObj.getStringWidth(lllllllllllllIIIlllIlIlllIlllIll);
        this.mc.fontRendererObj.drawString(lllllllllllllIIIlllIlIlllIlllIll, lllllllllllllIIIlllIlIllllIIlIII + lllllllllllllIIIlllIlIllllIIIllI - lllllllllllllIIIlllIlIlllIlllIlI - 15 - 2, lllllllllllllIIIlllIlIllllIIIlll + 1, 8421504);
        int lllllllllllllIIIlllIlIlllIlllIIl = 0;
        String lllllllllllllIIIlllIlIlllIlllIII = null;
        int lllllllllllllIIIlllIlIlllIllIIII = 0;
        String lllllllllllllIIIlllIlIlllIlIllII = null;
        if (lllllllllllllIIIlllIlIlllIlllllI) {
            final int lllllllllllllIIIlllIlIlllIllIlll = 5;
            final String lllllllllllllIIIlllIlIlllIlIllll = I18n.format(lllllllllllllIIIlllIlIllllIIIIII ? "multiplayer.status.client_out_of_date" : "multiplayer.status.server_out_of_date", new Object[0]);
            lllllllllllllIIIlllIlIlllIlllIII = this.server.playerList;
        }
        else if (this.server.pinged && this.server.pingToServer != -2L) {
            if (this.server.pingToServer < 0L) {
                final int lllllllllllllIIIlllIlIlllIllIllI = 5;
            }
            else if (this.server.pingToServer < 150L) {
                final int lllllllllllllIIIlllIlIlllIllIlIl = 0;
            }
            else if (this.server.pingToServer < 300L) {
                final int lllllllllllllIIIlllIlIlllIllIlII = 1;
            }
            else if (this.server.pingToServer < 600L) {
                final int lllllllllllllIIIlllIlIlllIllIIll = 2;
            }
            else if (this.server.pingToServer < 1000L) {
                final int lllllllllllllIIIlllIlIlllIllIIlI = 3;
            }
            else {
                final int lllllllllllllIIIlllIlIlllIllIIIl = 4;
            }
            if (this.server.pingToServer < 0L) {
                final String lllllllllllllIIIlllIlIlllIlIlllI = I18n.format("multiplayer.status.no_connection", new Object[0]);
            }
            else {
                final String lllllllllllllIIIlllIlIlllIlIllIl = String.valueOf(new StringBuilder(String.valueOf(this.server.pingToServer)).append("ms"));
                lllllllllllllIIIlllIlIlllIlllIII = this.server.playerList;
            }
        }
        else {
            lllllllllllllIIIlllIlIlllIlllIIl = 1;
            lllllllllllllIIIlllIlIlllIllIIII = (int)(Minecraft.getSystemTime() / 100L + lllllllllllllIIIlllIlIllllIIlIIl * 2 & 0x7L);
            if (lllllllllllllIIIlllIlIlllIllIIII > 4) {
                lllllllllllllIIIlllIlIlllIllIIII = 8 - lllllllllllllIIIlllIlIlllIllIIII;
            }
            lllllllllllllIIIlllIlIlllIlIllII = I18n.format("multiplayer.status.pinging", new Object[0]);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII + lllllllllllllIIIlllIlIllllIIIllI - 15, lllllllllllllIIIlllIlIllllIIIlll, (float)(lllllllllllllIIIlllIlIlllIlllIIl * 10), (float)(176 + lllllllllllllIIIlllIlIlllIllIIII * 8), 10, 8, 256.0f, 256.0f);
        if (this.server.getBase64EncodedIconData() != null && !this.server.getBase64EncodedIconData().equals(this.lastIconB64)) {
            this.lastIconB64 = this.server.getBase64EncodedIconData();
            this.prepareServerIcon();
            this.owner.getServerList().saveServerList();
        }
        if (this.icon != null) {
            this.drawTextureAt(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, this.serverIcon);
        }
        else {
            this.drawTextureAt(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, ServerListEntryNormal.UNKNOWN_SERVER);
        }
        final int lllllllllllllIIIlllIlIlllIlIlIll = lllllllllllllIIIlllIlIlllIlIIIlI - lllllllllllllIIIlllIlIllllIIlIII;
        final int lllllllllllllIIIlllIlIlllIlIlIlI = lllllllllllllIIIlllIlIllllIIIIll - lllllllllllllIIIlllIlIllllIIIlll;
        if (lllllllllllllIIIlllIlIlllIlIlIll >= lllllllllllllIIIlllIlIllllIIIllI - 15 && lllllllllllllIIIlllIlIlllIlIlIll <= lllllllllllllIIIlllIlIllllIIIllI - 5 && lllllllllllllIIIlllIlIlllIlIlIlI >= 0 && lllllllllllllIIIlllIlIlllIlIlIlI <= 8) {
            this.owner.setHoveringText(lllllllllllllIIIlllIlIlllIlIllII);
        }
        else if (lllllllllllllIIIlllIlIlllIlIlIll >= lllllllllllllIIIlllIlIllllIIIllI - lllllllllllllIIIlllIlIlllIlllIlI - 15 - 2 && lllllllllllllIIIlllIlIlllIlIlIll <= lllllllllllllIIIlllIlIllllIIIllI - 15 - 2 && lllllllllllllIIIlllIlIlllIlIlIlI >= 0 && lllllllllllllIIIlllIlIlllIlIlIlI <= 8) {
            this.owner.setHoveringText(lllllllllllllIIIlllIlIlllIlllIII);
        }
        if (this.mc.gameSettings.touchscreen || lllllllllllllIIIlllIlIllllIIIIlI) {
            this.mc.getTextureManager().bindTexture(ServerListEntryNormal.SERVER_SELECTION_BUTTONS);
            Gui.drawRect(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, lllllllllllllIIIlllIlIllllIIlIII + 32, lllllllllllllIIIlllIlIllllIIIlll + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int lllllllllllllIIIlllIlIlllIlIlIIl = lllllllllllllIIIlllIlIlllIlIIIlI - lllllllllllllIIIlllIlIllllIIlIII;
            final int lllllllllllllIIIlllIlIlllIlIlIII = lllllllllllllIIIlllIlIllllIIIIll - lllllllllllllIIIlllIlIllllIIIlll;
            if (this.canJoin()) {
                if (lllllllllllllIIIlllIlIlllIlIlIIl < 32 && lllllllllllllIIIlllIlIlllIlIlIIl > 16) {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, 0.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, 0.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            if (this.owner.canMoveUp(this, lllllllllllllIIIlllIlIllllIIlIIl)) {
                if (lllllllllllllIIIlllIlIlllIlIlIIl < 16 && lllllllllllllIIIlllIlIlllIlIlIII < 16) {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, 96.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, 96.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            if (this.owner.canMoveDown(this, lllllllllllllIIIlllIlIllllIIlIIl)) {
                if (lllllllllllllIIIlllIlIlllIlIlIIl < 16 && lllllllllllllIIIlllIlIlllIlIlIII > 16) {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, 64.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                }
                else {
                    Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIllllIIlIII, lllllllllllllIIIlllIlIllllIIIlll, 64.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        EXECUTOR = new ScheduledThreadPoolExecutor(5, new ThreadFactoryBuilder().setNameFormat("Server Pinger #%d").setDaemon(true).build());
        UNKNOWN_SERVER = new ResourceLocation("textures/misc/unknown_server.png");
        SERVER_SELECTION_BUTTONS = new ResourceLocation("textures/gui/server_selection.png");
    }
    
    private void prepareServerIcon() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //     4: invokevirtual   net/minecraft/client/multiplayer/ServerData.getBase64EncodedIconData:()Ljava/lang/String;
        //     7: ifnonnull       32
        //    10: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //    11: getfield        net/minecraft/client/gui/ServerListEntryNormal.mc:Lnet/minecraft/client/Minecraft;
        //    14: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //    17: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //    18: getfield        net/minecraft/client/gui/ServerListEntryNormal.serverIcon:Lnet/minecraft/util/ResourceLocation;
        //    21: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.deleteTexture:(Lnet/minecraft/util/ResourceLocation;)V
        //    24: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //    25: aconst_null    
        //    26: putfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //    29: goto            283
        //    32: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //    33: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //    36: invokevirtual   net/minecraft/client/multiplayer/ServerData.getBase64EncodedIconData:()Ljava/lang/String;
        //    39: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    42: invokestatic    io/netty/buffer/Unpooled.copiedBuffer:(Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)Lio/netty/buffer/ByteBuf;
        //    45: astore_1        /* lllllllllllllIIIlllIlIllIlllIlll */
        //    46: aconst_null    
        //    47: astore_2        /* lllllllllllllIIIlllIlIllIlllIllI */
        //    48: aload_1         /* lllllllllllllIIIlllIlIllIlllllIl */
        //    49: invokestatic    io/netty/handler/codec/base64/Base64.decode:(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
        //    52: astore_2        /* lllllllllllllIIIlllIlIllIlllllII */
        //    53: new             Lio/netty/buffer/ByteBufInputStream;
        //    56: dup            
        //    57: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //    58: invokespecial   io/netty/buffer/ByteBufInputStream.<init>:(Lio/netty/buffer/ByteBuf;)V
        //    61: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    64: astore_3        /* lllllllllllllIIIlllIlIllIllllIll */
        //    65: aload_3         /* lllllllllllllIIIlllIlIllIllllIll */
        //    66: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    69: bipush          64
        //    71: if_icmpne       78
        //    74: iconst_1       
        //    75: goto            79
        //    78: iconst_0       
        //    79: ldc_w           "Must be 64 pixels wide"
        //    82: iconst_0       
        //    83: anewarray       Ljava/lang/Object;
        //    86: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //    89: aload_3         /* lllllllllllllIIIlllIlIllIllllIll */
        //    90: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    93: bipush          64
        //    95: if_icmpne       102
        //    98: iconst_1       
        //    99: goto            103
        //   102: iconst_0       
        //   103: ldc_w           "Must be 64 pixels high"
        //   106: iconst_0       
        //   107: anewarray       Ljava/lang/Object;
        //   110: invokestatic    org/apache/commons/lang3/Validate.validState:(ZLjava/lang/String;[Ljava/lang/Object;)V
        //   113: aload_1         /* lllllllllllllIIIlllIlIllIlllllIl */
        //   114: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   117: pop            
        //   118: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //   119: ifnull          204
        //   122: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //   123: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   126: pop            
        //   127: goto            204
        //   130: astore          lllllllllllllIIIlllIlIllIllllIIl
        //   132: getstatic       net/minecraft/client/gui/ServerListEntryNormal.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   135: ldc_w           "Invalid icon for server {} ({})"
        //   138: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   139: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //   142: getfield        net/minecraft/client/multiplayer/ServerData.serverName:Ljava/lang/String;
        //   145: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   146: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //   149: getfield        net/minecraft/client/multiplayer/ServerData.serverIP:Ljava/lang/String;
        //   152: aload           lllllllllllllIIIlllIlIllIllllIIl
        //   154: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   159: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   160: getfield        net/minecraft/client/gui/ServerListEntryNormal.server:Lnet/minecraft/client/multiplayer/ServerData;
        //   163: aconst_null    
        //   164: invokevirtual   net/minecraft/client/multiplayer/ServerData.setBase64EncodedIconData:(Ljava/lang/String;)V
        //   167: aload_1         /* lllllllllllllIIIlllIlIllIlllllIl */
        //   168: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   171: pop            
        //   172: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //   173: ifnull          203
        //   176: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //   177: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   180: pop            
        //   181: goto            203
        //   184: astore          lllllllllllllIIIlllIlIllIlllIIll
        //   186: aload_1         /* lllllllllllllIIIlllIlIllIlllllIl */
        //   187: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   190: pop            
        //   191: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //   192: ifnull          200
        //   195: aload_2         /* lllllllllllllIIIlllIlIllIlllllII */
        //   196: invokevirtual   io/netty/buffer/ByteBuf.release:()Z
        //   199: pop            
        //   200: aload           lllllllllllllIIIlllIlIllIlllIIll
        //   202: athrow         
        //   203: return         
        //   204: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   205: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   208: ifnonnull       249
        //   211: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   212: new             Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   215: dup            
        //   216: aload_3         /* lllllllllllllIIIlllIlIllIllllIlI */
        //   217: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   220: aload_3         /* lllllllllllllIIIlllIlIllIllllIlI */
        //   221: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   224: invokespecial   net/minecraft/client/renderer/texture/DynamicTexture.<init>:(II)V
        //   227: putfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   230: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   231: getfield        net/minecraft/client/gui/ServerListEntryNormal.mc:Lnet/minecraft/client/Minecraft;
        //   234: invokevirtual   net/minecraft/client/Minecraft.getTextureManager:()Lnet/minecraft/client/renderer/texture/TextureManager;
        //   237: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   238: getfield        net/minecraft/client/gui/ServerListEntryNormal.serverIcon:Lnet/minecraft/util/ResourceLocation;
        //   241: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   242: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   245: invokevirtual   net/minecraft/client/renderer/texture/TextureManager.loadTexture:(Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/ITextureObject;)Z
        //   248: pop            
        //   249: aload_3         /* lllllllllllllIIIlllIlIllIllllIlI */
        //   250: iconst_0       
        //   251: iconst_0       
        //   252: aload_3         /* lllllllllllllIIIlllIlIllIllllIlI */
        //   253: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   256: aload_3         /* lllllllllllllIIIlllIlIllIllllIlI */
        //   257: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //   260: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   261: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   264: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.getTextureData:()[I
        //   267: iconst_0       
        //   268: aload_3         /* lllllllllllllIIIlllIlIllIllllIlI */
        //   269: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //   272: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   275: pop            
        //   276: aload_0         /* lllllllllllllIIIlllIlIllIllllllI */
        //   277: getfield        net/minecraft/client/gui/ServerListEntryNormal.icon:Lnet/minecraft/client/renderer/texture/DynamicTexture;
        //   280: invokevirtual   net/minecraft/client/renderer/texture/DynamicTexture.updateDynamicTexture:()V
        //   283: return         
        //    StackMapTable: 00 0C 20 FE 00 2D 07 01 B4 07 01 B4 07 01 A2 40 01 16 40 01 FF 00 1A 00 03 07 00 02 07 01 B4 07 01 B4 00 01 07 01 80 75 07 01 80 FE 00 0F 00 00 07 01 80 FF 00 02 00 05 07 00 02 07 01 B4 07 01 B4 00 07 01 80 00 00 FF 00 00 00 04 07 00 02 07 01 B4 07 01 B4 07 01 A2 00 00 2C F8 00 21
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  48     113    130    184    Ljava/lang/Throwable;
        //  48     113    184    203    Any
        //  130    167    184    203    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private boolean canJoin() {
        return true;
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIIIlllIlIllIlIlllIl, final int lllllllllllllIIIlllIlIllIlIlllII, final int lllllllllllllIIIlllIlIllIlIllIll, final int lllllllllllllIIIlllIlIllIlIllIlI, final int lllllllllllllIIIlllIlIllIlIllIIl, final int lllllllllllllIIIlllIlIllIlIllIII) {
    }
    
    @Override
    public void func_192633_a(final int lllllllllllllIIIlllIlIllIllIIIlI, final int lllllllllllllIIIlllIlIllIllIIIIl, final int lllllllllllllIIIlllIlIllIllIIIII, final float lllllllllllllIIIlllIlIllIlIlllll) {
    }
    
    public ServerData getServerData() {
        return this.server;
    }
    
    protected ServerListEntryNormal(final GuiMultiplayer lllllllllllllIIIlllIlIlllllIIIlI, final ServerData lllllllllllllIIIlllIlIlllllIIIIl) {
        this.owner = lllllllllllllIIIlllIlIlllllIIIlI;
        this.server = lllllllllllllIIIlllIlIlllllIIIIl;
        this.mc = Minecraft.getMinecraft();
        this.serverIcon = new ResourceLocation(String.valueOf(new StringBuilder("servers/").append(lllllllllllllIIIlllIlIlllllIIIIl.serverIP).append("/icon")));
        this.icon = (DynamicTexture)this.mc.getTextureManager().getTexture(this.serverIcon);
    }
    
    protected void drawTextureAt(final int lllllllllllllIIIlllIlIlllIIIlIII, final int lllllllllllllIIIlllIlIlllIIIlIll, final ResourceLocation lllllllllllllIIIlllIlIlllIIIIllI) {
        this.mc.getTextureManager().bindTexture(lllllllllllllIIIlllIlIlllIIIIllI);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIlllIlIlllIIIlIII, lllllllllllllIIIlllIlIlllIIIlIll, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
        GlStateManager.disableBlend();
    }
    
    @Override
    public boolean mousePressed(final int lllllllllllllIIIlllIlIllIllIIllI, final int lllllllllllllIIIlllIlIllIllIllII, final int lllllllllllllIIIlllIlIllIllIlIll, final int lllllllllllllIIIlllIlIllIllIlIlI, final int lllllllllllllIIIlllIlIllIllIIlIl, final int lllllllllllllIIIlllIlIllIllIlIII) {
        if (lllllllllllllIIIlllIlIllIllIIlIl <= 32) {
            if (lllllllllllllIIIlllIlIllIllIIlIl < 32 && lllllllllllllIIIlllIlIllIllIIlIl > 16 && this.canJoin()) {
                this.owner.selectServer(lllllllllllllIIIlllIlIllIllIIllI);
                this.owner.connectToSelected();
                return true;
            }
            if (lllllllllllllIIIlllIlIllIllIIlIl < 16 && lllllllllllllIIIlllIlIllIllIlIII < 16 && this.owner.canMoveUp(this, lllllllllllllIIIlllIlIllIllIIllI)) {
                this.owner.moveServerUp(this, lllllllllllllIIIlllIlIllIllIIllI, GuiScreen.isShiftKeyDown());
                return true;
            }
            if (lllllllllllllIIIlllIlIllIllIIlIl < 16 && lllllllllllllIIIlllIlIllIllIlIII > 16 && this.owner.canMoveDown(this, lllllllllllllIIIlllIlIllIllIIllI)) {
                this.owner.moveServerDown(this, lllllllllllllIIIlllIlIllIllIIllI, GuiScreen.isShiftKeyDown());
                return true;
            }
        }
        this.owner.selectServer(lllllllllllllIIIlllIlIllIllIIllI);
        if (Minecraft.getSystemTime() - this.lastClickTime < 250L) {
            this.owner.connectToSelected();
        }
        this.lastClickTime = Minecraft.getSystemTime();
        return false;
    }
}
