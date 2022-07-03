package net.minecraft.client.gui;

import net.minecraft.client.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import net.minecraft.client.network.*;
import com.mojang.authlib.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;

public class GuiPlayerTabOverlay extends Gui
{
    private /* synthetic */ ITextComponent footer;
    private static final /* synthetic */ Ordering<NetworkPlayerInfo> ENTRY_ORDERING;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ GuiIngame guiIngame;
    private /* synthetic */ boolean isBeingRendered;
    private /* synthetic */ long lastTimeOpened;
    private /* synthetic */ ITextComponent header;
    
    public void renderPlayerlist(final int llllllllllllIllllllllIIlIlIIlllI, final Scoreboard llllllllllllIllllllllIIlIlIIllIl, @Nullable final ScoreObjective llllllllllllIllllllllIIlIlIIllII) {
        final NetHandlerPlayClient llllllllllllIllllllllIIlIlIIlIll = this.mc.player.connection;
        List<NetworkPlayerInfo> llllllllllllIllllllllIIlIlIIlIlI = (List<NetworkPlayerInfo>)GuiPlayerTabOverlay.ENTRY_ORDERING.sortedCopy((Iterable)llllllllllllIllllllllIIlIlIIlIll.getPlayerInfoMap());
        int llllllllllllIllllllllIIlIlIIlIIl = 0;
        int llllllllllllIllllllllIIlIlIIlIII = 0;
        for (final NetworkPlayerInfo llllllllllllIllllllllIIlIlIIIlll : llllllllllllIllllllllIIlIlIIlIlI) {
            int llllllllllllIllllllllIIlIlIIIllI = this.mc.fontRendererObj.getStringWidth(this.getPlayerName(llllllllllllIllllllllIIlIlIIIlll));
            llllllllllllIllllllllIIlIlIIlIIl = Math.max(llllllllllllIllllllllIIlIlIIlIIl, llllllllllllIllllllllIIlIlIIIllI);
            if (llllllllllllIllllllllIIlIlIIllII != null && llllllllllllIllllllllIIlIlIIllII.getRenderType() != IScoreCriteria.EnumRenderType.HEARTS) {
                llllllllllllIllllllllIIlIlIIIllI = this.mc.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(" ").append(llllllllllllIllllllllIIlIlIIllIl.getOrCreateScore(llllllllllllIllllllllIIlIlIIIlll.getGameProfile().getName(), llllllllllllIllllllllIIlIlIIllII).getScorePoints())));
                llllllllllllIllllllllIIlIlIIlIII = Math.max(llllllllllllIllllllllIIlIlIIlIII, llllllllllllIllllllllIIlIlIIIllI);
            }
        }
        llllllllllllIllllllllIIlIlIIlIlI = llllllllllllIllllllllIIlIlIIlIlI.subList(0, Math.min(llllllllllllIllllllllIIlIlIIlIlI.size(), 80));
        int llllllllllllIllllllllIIlIlIIIlII;
        int llllllllllllIllllllllIIlIlIIIlIl;
        int llllllllllllIllllllllIIlIlIIIIll;
        for (llllllllllllIllllllllIIlIlIIIlIl = (llllllllllllIllllllllIIlIlIIIlII = llllllllllllIllllllllIIlIlIIlIlI.size()), llllllllllllIllllllllIIlIlIIIIll = 1; llllllllllllIllllllllIIlIlIIIlII > 20; llllllllllllIllllllllIIlIlIIIlII = (llllllllllllIllllllllIIlIlIIIlIl + llllllllllllIllllllllIIlIlIIIIll - 1) / llllllllllllIllllllllIIlIlIIIIll) {
            ++llllllllllllIllllllllIIlIlIIIIll;
        }
        final boolean llllllllllllIllllllllIIlIlIIIIlI = this.mc.isIntegratedServerRunning() || this.mc.getConnection().getNetworkManager().isEncrypted();
        int llllllllllllIllllllllIIlIIllllll = 0;
        if (llllllllllllIllllllllIIlIlIIllII != null) {
            if (llllllllllllIllllllllIIlIlIIllII.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS) {
                final int llllllllllllIllllllllIIlIlIIIIIl = 90;
            }
            else {
                final int llllllllllllIllllllllIIlIlIIIIII = llllllllllllIllllllllIIlIlIIlIII;
            }
        }
        else {
            llllllllllllIllllllllIIlIIllllll = 0;
        }
        final int llllllllllllIllllllllIIlIIlllllI = Math.min(llllllllllllIllllllllIIlIlIIIIll * ((llllllllllllIllllllllIIlIlIIIIlI ? 9 : 0) + llllllllllllIllllllllIIlIlIIlIIl + llllllllllllIllllllllIIlIIllllll + 13), llllllllllllIllllllllIIlIlIIlllI - 50) / llllllllllllIllllllllIIlIlIIIIll;
        final int llllllllllllIllllllllIIlIIllllIl = llllllllllllIllllllllIIlIlIIlllI / 2 - (llllllllllllIllllllllIIlIIlllllI * llllllllllllIllllllllIIlIlIIIIll + (llllllllllllIllllllllIIlIlIIIIll - 1) * 5) / 2;
        int llllllllllllIllllllllIIlIIllllII = 10;
        int llllllllllllIllllllllIIlIIlllIll = llllllllllllIllllllllIIlIIlllllI * llllllllllllIllllllllIIlIlIIIIll + (llllllllllllIllllllllIIlIlIIIIll - 1) * 5;
        List<String> llllllllllllIllllllllIIlIIlllIlI = null;
        if (this.header != null) {
            llllllllllllIllllllllIIlIIlllIlI = this.mc.fontRendererObj.listFormattedStringToWidth(this.header.getFormattedText(), llllllllllllIllllllllIIlIlIIlllI - 50);
            for (final String llllllllllllIllllllllIIlIIlllIIl : llllllllllllIllllllllIIlIIlllIlI) {
                llllllllllllIllllllllIIlIIlllIll = Math.max(llllllllllllIllllllllIIlIIlllIll, this.mc.fontRendererObj.getStringWidth(llllllllllllIllllllllIIlIIlllIIl));
            }
        }
        List<String> llllllllllllIllllllllIIlIIlllIII = null;
        if (this.footer != null) {
            llllllllllllIllllllllIIlIIlllIII = this.mc.fontRendererObj.listFormattedStringToWidth(this.footer.getFormattedText(), llllllllllllIllllllllIIlIlIIlllI - 50);
            for (final String llllllllllllIllllllllIIlIIllIlll : llllllllllllIllllllllIIlIIlllIII) {
                llllllllllllIllllllllIIlIIlllIll = Math.max(llllllllllllIllllllllIIlIIlllIll, this.mc.fontRendererObj.getStringWidth(llllllllllllIllllllllIIlIIllIlll));
            }
        }
        if (llllllllllllIllllllllIIlIIlllIlI != null) {
            Gui.drawRect(llllllllllllIllllllllIIlIlIIlllI / 2 - llllllllllllIllllllllIIlIIlllIll / 2 - 1, llllllllllllIllllllllIIlIIllllII - 1, llllllllllllIllllllllIIlIlIIlllI / 2 + llllllllllllIllllllllIIlIIlllIll / 2 + 1, llllllllllllIllllllllIIlIIllllII + llllllllllllIllllllllIIlIIlllIlI.size() * this.mc.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (final String llllllllllllIllllllllIIlIIllIllI : llllllllllllIllllllllIIlIIlllIlI) {
                final int llllllllllllIllllllllIIlIIllIlIl = this.mc.fontRendererObj.getStringWidth(llllllllllllIllllllllIIlIIllIllI);
                this.mc.fontRendererObj.drawStringWithShadow(llllllllllllIllllllllIIlIIllIllI, (float)(llllllllllllIllllllllIIlIlIIlllI / 2 - llllllllllllIllllllllIIlIIllIlIl / 2), (float)llllllllllllIllllllllIIlIIllllII, -1);
                llllllllllllIllllllllIIlIIllllII += this.mc.fontRendererObj.FONT_HEIGHT;
            }
            ++llllllllllllIllllllllIIlIIllllII;
        }
        Gui.drawRect(llllllllllllIllllllllIIlIlIIlllI / 2 - llllllllllllIllllllllIIlIIlllIll / 2 - 1, llllllllllllIllllllllIIlIIllllII - 1, llllllllllllIllllllllIIlIlIIlllI / 2 + llllllllllllIllllllllIIlIIlllIll / 2 + 1, llllllllllllIllllllllIIlIIllllII + llllllllllllIllllllllIIlIlIIIlII * 9, Integer.MIN_VALUE);
        for (int llllllllllllIllllllllIIlIIllIlII = 0; llllllllllllIllllllllIIlIIllIlII < llllllllllllIllllllllIIlIlIIIlIl; ++llllllllllllIllllllllIIlIIllIlII) {
            final int llllllllllllIllllllllIIlIIllIIll = llllllllllllIllllllllIIlIIllIlII / llllllllllllIllllllllIIlIlIIIlII;
            final int llllllllllllIllllllllIIlIIllIIlI = llllllllllllIllllllllIIlIIllIlII % llllllllllllIllllllllIIlIlIIIlII;
            int llllllllllllIllllllllIIlIIllIIIl = llllllllllllIllllllllIIlIIllllIl + llllllllllllIllllllllIIlIIllIIll * llllllllllllIllllllllIIlIIlllllI + llllllllllllIllllllllIIlIIllIIll * 5;
            final int llllllllllllIllllllllIIlIIllIIII = llllllllllllIllllllllIIlIIllllII + llllllllllllIllllllllIIlIIllIIlI * 9;
            Gui.drawRect(llllllllllllIllllllllIIlIIllIIIl, llllllllllllIllllllllIIlIIllIIII, llllllllllllIllllllllIIlIIllIIIl + llllllllllllIllllllllIIlIIlllllI, llllllllllllIllllllllIIlIIllIIII + 8, 553648127);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (llllllllllllIllllllllIIlIIllIlII < llllllllllllIllllllllIIlIlIIlIlI.size()) {
                final NetworkPlayerInfo llllllllllllIllllllllIIlIIlIllll = llllllllllllIllllllllIIlIlIIlIlI.get(llllllllllllIllllllllIIlIIllIlII);
                final GameProfile llllllllllllIllllllllIIlIIlIlllI = llllllllllllIllllllllIIlIIlIllll.getGameProfile();
                if (llllllllllllIllllllllIIlIlIIIIlI) {
                    final EntityPlayer llllllllllllIllllllllIIlIIlIllIl = this.mc.world.getPlayerEntityByUUID(llllllllllllIllllllllIIlIIlIlllI.getId());
                    final boolean llllllllllllIllllllllIIlIIlIllII = llllllllllllIllllllllIIlIIlIllIl != null && llllllllllllIllllllllIIlIIlIllIl.isWearing(EnumPlayerModelParts.CAPE) && ("Dinnerbone".equals(llllllllllllIllllllllIIlIIlIlllI.getName()) || "Grumm".equals(llllllllllllIllllllllIIlIIlIlllI.getName()));
                    this.mc.getTextureManager().bindTexture(llllllllllllIllllllllIIlIIlIllll.getLocationSkin());
                    final int llllllllllllIllllllllIIlIIlIlIll = 8 + (llllllllllllIllllllllIIlIIlIllII ? 8 : 0);
                    final int llllllllllllIllllllllIIlIIlIlIlI = 8 * (llllllllllllIllllllllIIlIIlIllII ? -1 : 1);
                    Gui.drawScaledCustomSizeModalRect(llllllllllllIllllllllIIlIIllIIIl, llllllllllllIllllllllIIlIIllIIII, 8.0f, (float)llllllllllllIllllllllIIlIIlIlIll, 8, llllllllllllIllllllllIIlIIlIlIlI, 8, 8, 64.0f, 64.0f);
                    if (llllllllllllIllllllllIIlIIlIllIl != null && llllllllllllIllllllllIIlIIlIllIl.isWearing(EnumPlayerModelParts.HAT)) {
                        final int llllllllllllIllllllllIIlIIlIlIIl = 8 + (llllllllllllIllllllllIIlIIlIllII ? 8 : 0);
                        final int llllllllllllIllllllllIIlIIlIlIII = 8 * (llllllllllllIllllllllIIlIIlIllII ? -1 : 1);
                        Gui.drawScaledCustomSizeModalRect(llllllllllllIllllllllIIlIIllIIIl, llllllllllllIllllllllIIlIIllIIII, 40.0f, (float)llllllllllllIllllllllIIlIIlIlIIl, 8, llllllllllllIllllllllIIlIIlIlIII, 8, 8, 64.0f, 64.0f);
                    }
                    llllllllllllIllllllllIIlIIllIIIl += 9;
                }
                final String llllllllllllIllllllllIIlIIlIIlll = this.getPlayerName(llllllllllllIllllllllIIlIIlIllll);
                if (llllllllllllIllllllllIIlIIlIllll.getGameType() == GameType.SPECTATOR) {
                    this.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(TextFormatting.ITALIC).append(llllllllllllIllllllllIIlIIlIIlll)), (float)llllllllllllIllllllllIIlIIllIIIl, (float)llllllllllllIllllllllIIlIIllIIII, -1862270977);
                }
                else {
                    this.mc.fontRendererObj.drawStringWithShadow(llllllllllllIllllllllIIlIIlIIlll, (float)llllllllllllIllllllllIIlIIllIIIl, (float)llllllllllllIllllllllIIlIIllIIII, -1);
                }
                if (llllllllllllIllllllllIIlIlIIllII != null && llllllllllllIllllllllIIlIIlIllll.getGameType() != GameType.SPECTATOR) {
                    final int llllllllllllIllllllllIIlIIlIIllI = llllllllllllIllllllllIIlIIllIIIl + llllllllllllIllllllllIIlIlIIlIIl + 1;
                    final int llllllllllllIllllllllIIlIIlIIlIl = llllllllllllIllllllllIIlIIlIIllI + llllllllllllIllllllllIIlIIllllll;
                    if (llllllllllllIllllllllIIlIIlIIlIl - llllllllllllIllllllllIIlIIlIIllI > 5) {
                        this.drawScoreboardValues(llllllllllllIllllllllIIlIlIIllII, llllllllllllIllllllllIIlIIllIIII, llllllllllllIllllllllIIlIIlIlllI.getName(), llllllllllllIllllllllIIlIIlIIllI, llllllllllllIllllllllIIlIIlIIlIl, llllllllllllIllllllllIIlIIlIllll);
                    }
                }
                this.drawPing(llllllllllllIllllllllIIlIIlllllI, llllllllllllIllllllllIIlIIllIIIl - (llllllllllllIllllllllIIlIlIIIIlI ? 9 : 0), llllllllllllIllllllllIIlIIllIIII, llllllllllllIllllllllIIlIIlIllll);
            }
        }
        if (llllllllllllIllllllllIIlIIlllIII != null) {
            llllllllllllIllllllllIIlIIllllII = llllllllllllIllllllllIIlIIllllII + llllllllllllIllllllllIIlIlIIIlII * 9 + 1;
            Gui.drawRect(llllllllllllIllllllllIIlIlIIlllI / 2 - llllllllllllIllllllllIIlIIlllIll / 2 - 1, llllllllllllIllllllllIIlIIllllII - 1, llllllllllllIllllllllIIlIlIIlllI / 2 + llllllllllllIllllllllIIlIIlllIll / 2 + 1, llllllllllllIllllllllIIlIIllllII + llllllllllllIllllllllIIlIIlllIII.size() * this.mc.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (final String llllllllllllIllllllllIIlIIlIIlII : llllllllllllIllllllllIIlIIlllIII) {
                final int llllllllllllIllllllllIIlIIlIIIll = this.mc.fontRendererObj.getStringWidth(llllllllllllIllllllllIIlIIlIIlII);
                this.mc.fontRendererObj.drawStringWithShadow(llllllllllllIllllllllIIlIIlIIlII, (float)(llllllllllllIllllllllIIlIlIIlllI / 2 - llllllllllllIllllllllIIlIIlIIIll / 2), (float)llllllllllllIllllllllIIlIIllllII, -1);
                llllllllllllIllllllllIIlIIllllII += this.mc.fontRendererObj.FONT_HEIGHT;
            }
        }
    }
    
    public void updatePlayerList(final boolean llllllllllllIllllllllIIlIlllIIlI) {
        if (llllllllllllIllllllllIIlIlllIIlI && !this.isBeingRendered) {
            this.lastTimeOpened = Minecraft.getSystemTime();
        }
        this.isBeingRendered = llllllllllllIllllllllIIlIlllIIlI;
    }
    
    public void setHeader(@Nullable final ITextComponent llllllllllllIllllllllIIIlIlIllll) {
        this.header = llllllllllllIllllllllIIIlIlIllll;
    }
    
    public String getPlayerName(final NetworkPlayerInfo llllllllllllIllllllllIIlIlllIllI) {
        return (llllllllllllIllllllllIIlIlllIllI.getDisplayName() != null) ? llllllllllllIllllllllIIlIlllIllI.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName(llllllllllllIllllllllIIlIlllIllI.getPlayerTeam(), llllllllllllIllllllllIIlIlllIllI.getGameProfile().getName());
    }
    
    static {
        ENTRY_ORDERING = Ordering.from((Comparator)new PlayerComparator(null));
    }
    
    public GuiPlayerTabOverlay(final Minecraft llllllllllllIllllllllIIlIllllIll, final GuiIngame llllllllllllIllllllllIIlIllllIlI) {
        this.mc = llllllllllllIllllllllIIlIllllIll;
        this.guiIngame = llllllllllllIllllllllIIlIllllIlI;
    }
    
    public void setFooter(@Nullable final ITextComponent llllllllllllIllllllllIIIlIllIlIl) {
        this.footer = llllllllllllIllllllllIIIlIllIlIl;
    }
    
    protected void drawPing(final int llllllllllllIllllllllIIIlllIlllI, final int llllllllllllIllllllllIIIlllIllIl, final int llllllllllllIllllllllIIIlllIllII, final NetworkPlayerInfo llllllllllllIllllllllIIIlllIlIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiPlayerTabOverlay.ICONS);
        final int llllllllllllIllllllllIIIllllIllI = 0;
        int llllllllllllIllllllllIIIllllIIII = 0;
        if (llllllllllllIllllllllIIIlllIlIll.getResponseTime() < 0) {
            final int llllllllllllIllllllllIIIllllIlIl = 5;
        }
        else if (llllllllllllIllllllllIIIlllIlIll.getResponseTime() < 150) {
            final int llllllllllllIllllllllIIIllllIlII = 0;
        }
        else if (llllllllllllIllllllllIIIlllIlIll.getResponseTime() < 300) {
            final int llllllllllllIllllllllIIIllllIIll = 1;
        }
        else if (llllllllllllIllllllllIIIlllIlIll.getResponseTime() < 600) {
            final int llllllllllllIllllllllIIIllllIIlI = 2;
        }
        else if (llllllllllllIllllllllIIIlllIlIll.getResponseTime() < 1000) {
            final int llllllllllllIllllllllIIIllllIIIl = 3;
        }
        else {
            llllllllllllIllllllllIIIllllIIII = 4;
        }
        this.zLevel += 100.0f;
        this.drawTexturedModalRect(llllllllllllIllllllllIIIlllIllIl + llllllllllllIllllllllIIIlllIlllI - 11, llllllllllllIllllllllIIIlllIllII, 0, 176 + llllllllllllIllllllllIIIllllIIII * 8, 10, 8);
        this.zLevel -= 100.0f;
    }
    
    private void drawScoreboardValues(final ScoreObjective llllllllllllIllllllllIIIllIllIII, final int llllllllllllIllllllllIIIllIIIlIl, final String llllllllllllIllllllllIIIllIlIllI, final int llllllllllllIllllllllIIIllIlIlIl, final int llllllllllllIllllllllIIIllIIIIlI, final NetworkPlayerInfo llllllllllllIllllllllIIIllIIIIIl) {
        final int llllllllllllIllllllllIIIllIlIIlI = llllllllllllIllllllllIIIllIllIII.getScoreboard().getOrCreateScore(llllllllllllIllllllllIIIllIlIllI, llllllllllllIllllllllIIIllIllIII).getScorePoints();
        if (llllllllllllIllllllllIIIllIllIII.getRenderType() == IScoreCriteria.EnumRenderType.HEARTS) {
            this.mc.getTextureManager().bindTexture(GuiPlayerTabOverlay.ICONS);
            if (this.lastTimeOpened == llllllllllllIllllllllIIIllIIIIIl.getRenderVisibilityId()) {
                if (llllllllllllIllllllllIIIllIlIIlI < llllllllllllIllllllllIIIllIIIIIl.getLastHealth()) {
                    llllllllllllIllllllllIIIllIIIIIl.setLastHealthTime(Minecraft.getSystemTime());
                    llllllllllllIllllllllIIIllIIIIIl.setHealthBlinkTime(this.guiIngame.getUpdateCounter() + 20);
                }
                else if (llllllllllllIllllllllIIIllIlIIlI > llllllllllllIllllllllIIIllIIIIIl.getLastHealth()) {
                    llllllllllllIllllllllIIIllIIIIIl.setLastHealthTime(Minecraft.getSystemTime());
                    llllllllllllIllllllllIIIllIIIIIl.setHealthBlinkTime(this.guiIngame.getUpdateCounter() + 10);
                }
            }
            if (Minecraft.getSystemTime() - llllllllllllIllllllllIIIllIIIIIl.getLastHealthTime() > 1000L || this.lastTimeOpened != llllllllllllIllllllllIIIllIIIIIl.getRenderVisibilityId()) {
                llllllllllllIllllllllIIIllIIIIIl.setLastHealth(llllllllllllIllllllllIIIllIlIIlI);
                llllllllllllIllllllllIIIllIIIIIl.setDisplayHealth(llllllllllllIllllllllIIIllIlIIlI);
                llllllllllllIllllllllIIIllIIIIIl.setLastHealthTime(Minecraft.getSystemTime());
            }
            llllllllllllIllllllllIIIllIIIIIl.setRenderVisibilityId(this.lastTimeOpened);
            llllllllllllIllllllllIIIllIIIIIl.setLastHealth(llllllllllllIllllllllIIIllIlIIlI);
            final int llllllllllllIllllllllIIIllIlIIIl = MathHelper.ceil(Math.max(llllllllllllIllllllllIIIllIlIIlI, llllllllllllIllllllllIIIllIIIIIl.getDisplayHealth()) / 2.0f);
            final int llllllllllllIllllllllIIIllIlIIII = Math.max(MathHelper.ceil((float)(llllllllllllIllllllllIIIllIlIIlI / 2)), Math.max(MathHelper.ceil((float)(llllllllllllIllllllllIIIllIIIIIl.getDisplayHealth() / 2)), 10));
            final boolean llllllllllllIllllllllIIIllIIllll = llllllllllllIllllllllIIIllIIIIIl.getHealthBlinkTime() > this.guiIngame.getUpdateCounter() && (llllllllllllIllllllllIIIllIIIIIl.getHealthBlinkTime() - this.guiIngame.getUpdateCounter()) / 3L % 2L == 1L;
            if (llllllllllllIllllllllIIIllIlIIIl > 0) {
                final float llllllllllllIllllllllIIIllIIlllI = Math.min((llllllllllllIllllllllIIIllIIIIlI - llllllllllllIllllllllIIIllIlIlIl - 4) / (float)llllllllllllIllllllllIIIllIlIIII, 9.0f);
                if (llllllllllllIllllllllIIIllIIlllI > 3.0f) {
                    for (int llllllllllllIllllllllIIIllIIllIl = llllllllllllIllllllllIIIllIlIIIl; llllllllllllIllllllllIIIllIIllIl < llllllllllllIllllllllIIIllIlIIII; ++llllllllllllIllllllllIIIllIIllIl) {
                        this.drawTexturedModalRect(llllllllllllIllllllllIIIllIlIlIl + llllllllllllIllllllllIIIllIIllIl * llllllllllllIllllllllIIIllIIlllI, (float)llllllllllllIllllllllIIIllIIIlIl, llllllllllllIllllllllIIIllIIllll ? 25 : 16, 0, 9, 9);
                    }
                    for (int llllllllllllIllllllllIIIllIIllII = 0; llllllllllllIllllllllIIIllIIllII < llllllllllllIllllllllIIIllIlIIIl; ++llllllllllllIllllllllIIIllIIllII) {
                        this.drawTexturedModalRect(llllllllllllIllllllllIIIllIlIlIl + llllllllllllIllllllllIIIllIIllII * llllllllllllIllllllllIIIllIIlllI, (float)llllllllllllIllllllllIIIllIIIlIl, llllllllllllIllllllllIIIllIIllll ? 25 : 16, 0, 9, 9);
                        if (llllllllllllIllllllllIIIllIIllll) {
                            if (llllllllllllIllllllllIIIllIIllII * 2 + 1 < llllllllllllIllllllllIIIllIIIIIl.getDisplayHealth()) {
                                this.drawTexturedModalRect(llllllllllllIllllllllIIIllIlIlIl + llllllllllllIllllllllIIIllIIllII * llllllllllllIllllllllIIIllIIlllI, (float)llllllllllllIllllllllIIIllIIIlIl, 70, 0, 9, 9);
                            }
                            if (llllllllllllIllllllllIIIllIIllII * 2 + 1 == llllllllllllIllllllllIIIllIIIIIl.getDisplayHealth()) {
                                this.drawTexturedModalRect(llllllllllllIllllllllIIIllIlIlIl + llllllllllllIllllllllIIIllIIllII * llllllllllllIllllllllIIIllIIlllI, (float)llllllllllllIllllllllIIIllIIIlIl, 79, 0, 9, 9);
                            }
                        }
                        if (llllllllllllIllllllllIIIllIIllII * 2 + 1 < llllllllllllIllllllllIIIllIlIIlI) {
                            this.drawTexturedModalRect(llllllllllllIllllllllIIIllIlIlIl + llllllllllllIllllllllIIIllIIllII * llllllllllllIllllllllIIIllIIlllI, (float)llllllllllllIllllllllIIIllIIIlIl, (llllllllllllIllllllllIIIllIIllII >= 10) ? 160 : 52, 0, 9, 9);
                        }
                        if (llllllllllllIllllllllIIIllIIllII * 2 + 1 == llllllllllllIllllllllIIIllIlIIlI) {
                            this.drawTexturedModalRect(llllllllllllIllllllllIIIllIlIlIl + llllllllllllIllllllllIIIllIIllII * llllllllllllIllllllllIIIllIIlllI, (float)llllllllllllIllllllllIIIllIIIlIl, (llllllllllllIllllllllIIIllIIllII >= 10) ? 169 : 61, 0, 9, 9);
                        }
                    }
                }
                else {
                    final float llllllllllllIllllllllIIIllIIlIll = MathHelper.clamp(llllllllllllIllllllllIIIllIlIIlI / 20.0f, 0.0f, 1.0f);
                    final int llllllllllllIllllllllIIIllIIlIlI = (int)((1.0f - llllllllllllIllllllllIIIllIIlIll) * 255.0f) << 16 | (int)(llllllllllllIllllllllIIIllIIlIll * 255.0f) << 8;
                    String llllllllllllIllllllllIIIllIIlIIl = String.valueOf(new StringBuilder().append(llllllllllllIllllllllIIIllIlIIlI / 2.0f));
                    if (llllllllllllIllllllllIIIllIIIIlI - this.mc.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllIllllllllIIIllIIlIIl)).append("hp"))) >= llllllllllllIllllllllIIIllIlIlIl) {
                        llllllllllllIllllllllIIIllIIlIIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllIllllllllIIIllIIlIIl)).append("hp"));
                    }
                    this.mc.fontRendererObj.drawStringWithShadow(llllllllllllIllllllllIIIllIIlIIl, (float)((llllllllllllIllllllllIIIllIIIIlI + llllllllllllIllllllllIIIllIlIlIl) / 2 - this.mc.fontRendererObj.getStringWidth(llllllllllllIllllllllIIIllIIlIIl) / 2), (float)llllllllllllIllllllllIIIllIIIlIl, llllllllllllIllllllllIIIllIIlIlI);
                }
            }
        }
        else {
            final String llllllllllllIllllllllIIIllIIlIII = String.valueOf(new StringBuilder().append(TextFormatting.YELLOW).append(llllllllllllIllllllllIIIllIlIIlI));
            this.mc.fontRendererObj.drawStringWithShadow(llllllllllllIllllllllIIIllIIlIII, (float)(llllllllllllIllllllllIIIllIIIIlI - this.mc.fontRendererObj.getStringWidth(llllllllllllIllllllllIIIllIIlIII)), (float)llllllllllllIllllllllIIIllIIIlIl, 16777215);
        }
    }
    
    public void resetFooterHeader() {
        this.header = null;
        this.footer = null;
    }
    
    static class PlayerComparator implements Comparator<NetworkPlayerInfo>
    {
        @Override
        public int compare(final NetworkPlayerInfo lllllllllllllIlIIlllIIlIIlllIIlI, final NetworkPlayerInfo lllllllllllllIlIIlllIIlIIlllIIIl) {
            final ScorePlayerTeam lllllllllllllIlIIlllIIlIIlllIIII = lllllllllllllIlIIlllIIlIIlllIIlI.getPlayerTeam();
            final ScorePlayerTeam lllllllllllllIlIIlllIIlIIllIllll = lllllllllllllIlIIlllIIlIIlllIIIl.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst(lllllllllllllIlIIlllIIlIIlllIIlI.getGameType() != GameType.SPECTATOR, lllllllllllllIlIIlllIIlIIlllIIIl.getGameType() != GameType.SPECTATOR).compare((Comparable)((lllllllllllllIlIIlllIIlIIlllIIII != null) ? lllllllllllllIlIIlllIIlIIlllIIII.getRegisteredName() : ""), (Comparable)((lllllllllllllIlIIlllIIlIIllIllll != null) ? lllllllllllllIlIIlllIIlIIllIllll.getRegisteredName() : "")).compare((Comparable)lllllllllllllIlIIlllIIlIIlllIIlI.getGameProfile().getName(), (Comparable)lllllllllllllIlIIlllIIlIIlllIIIl.getGameProfile().getName()).result();
        }
        
        private PlayerComparator() {
        }
    }
}
