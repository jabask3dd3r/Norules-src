package net.minecraft.client.gui;

import me.nrules.utils.world.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.border.*;
import net.minecraft.client.gui.chat.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.potion.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.resources.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import me.nrules.module.combat.*;
import me.nrules.*;
import java.util.*;
import java.awt.*;
import me.nrules.utils.render.*;
import com.mojang.realmsclient.gui.*;
import net.minecraft.init.*;
import me.nrules.event.events.*;
import net.minecraft.client.network.*;
import font.*;
import optifine.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.settings.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;

public class GuiIngame extends Gui
{
    private final /* synthetic */ GuiBossOverlay overlayBoss;
    private final /* synthetic */ GuiNewChat persistantChatGUI;
    private final /* synthetic */ GuiOverlayDebug overlayDebug;
    private /* synthetic */ int remainingHighlightTicks;
    public /* synthetic */ float prevVignetteBrightness;
    private /* synthetic */ String recordPlaying;
    private /* synthetic */ int titleFadeOut;
    private final /* synthetic */ RenderItem itemRenderer;
    private static final /* synthetic */ ResourceLocation VIGNETTE_TEX_PATH;
    private static final /* synthetic */ ResourceLocation PUMPKIN_BLUR_TEX_PATH;
    private /* synthetic */ double hudHeight;
    private /* synthetic */ String displayedTitle;
    private final /* synthetic */ GuiPlayerTabOverlay overlayPlayerList;
    /* synthetic */ double last;
    private /* synthetic */ int recordPlayingUpFor;
    private final /* synthetic */ TimerHelper animationStopwatch;
    private /* synthetic */ int lastPlayerHealth;
    private /* synthetic */ ItemStack highlightingItemStack;
    private /* synthetic */ long lastSystemTime;
    private /* synthetic */ boolean recordIsPlaying;
    private /* synthetic */ int titleDisplayTime;
    private final /* synthetic */ GuiSpectator spectatorGui;
    private /* synthetic */ int playerHealth;
    private /* synthetic */ String displayedSubTitle;
    private final /* synthetic */ Map<ChatType, List<IChatListener>> field_191743_I;
    private static final /* synthetic */ ResourceLocation WIDGETS_TEX_PATH;
    private /* synthetic */ double healthBarWidth;
    private /* synthetic */ int titleFadeIn;
    private /* synthetic */ long healthUpdateCounter;
    private final /* synthetic */ GuiSubtitleOverlay overlaySubtitle;
    private final /* synthetic */ Random rand;
    private /* synthetic */ int titlesTimer;
    private /* synthetic */ int updateCounter;
    /* synthetic */ double deltaSpeed;
    private final /* synthetic */ Minecraft mc;
    
    public void setDefaultTitlesTimes() {
        this.titleFadeIn = 10;
        this.titleDisplayTime = 70;
        this.titleFadeOut = 20;
    }
    
    private void renderPumpkinOverlay(final ScaledResolution lllllIIIlllII) {
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableAlpha();
        this.mc.getTextureManager().bindTexture(GuiIngame.PUMPKIN_BLUR_TEX_PATH);
        final Tessellator lllllIIIllIll = Tessellator.getInstance();
        final BufferBuilder lllllIIIllIlI = lllllIIIllIll.getBuffer();
        lllllIIIllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllIIIllIlI.pos(0.0, lllllIIIlllII.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
        lllllIIIllIlI.pos(lllllIIIlllII.getScaledWidth(), lllllIIIlllII.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
        lllllIIIllIlI.pos(lllllIIIlllII.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
        lllllIIIllIlI.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
        lllllIIIllIll.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public int getUpdateCounter() {
        return this.updateCounter;
    }
    
    private void renderPortal(float llllIlllIIlIl, final ScaledResolution llllIlllIlllI) {
        if (llllIlllIIlIl < 1.0f) {
            llllIlllIIlIl *= llllIlllIIlIl;
            llllIlllIIlIl *= llllIlllIIlIl;
            llllIlllIIlIl = llllIlllIIlIl * 0.8f + 0.2f;
        }
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllIlllIIlIl);
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        final TextureAtlasSprite llllIlllIllIl = this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(Blocks.PORTAL.getDefaultState());
        final float llllIlllIllII = llllIlllIllIl.getMinU();
        final float llllIlllIlIll = llllIlllIllIl.getMinV();
        final float llllIlllIlIlI = llllIlllIllIl.getMaxU();
        final float llllIlllIlIIl = llllIlllIllIl.getMaxV();
        final Tessellator llllIlllIlIII = Tessellator.getInstance();
        final BufferBuilder llllIlllIIlll = llllIlllIlIII.getBuffer();
        llllIlllIIlll.begin(7, DefaultVertexFormats.POSITION_TEX);
        llllIlllIIlll.pos(0.0, llllIlllIlllI.getScaledHeight(), -90.0).tex(llllIlllIllII, llllIlllIlIIl).endVertex();
        llllIlllIIlll.pos(llllIlllIlllI.getScaledWidth(), llllIlllIlllI.getScaledHeight(), -90.0).tex(llllIlllIlIlI, llllIlllIlIIl).endVertex();
        llllIlllIIlll.pos(llllIlllIlllI.getScaledWidth(), 0.0, -90.0).tex(llllIlllIlIlI, llllIlllIlIll).endVertex();
        llllIlllIIlll.pos(0.0, 0.0, -90.0).tex(llllIlllIllII, llllIlllIlIll).endVertex();
        llllIlllIlIII.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public GuiSpectator getSpectatorGui() {
        return this.spectatorGui;
    }
    
    public void setRecordPlaying(final String llllIlIllIlII, final boolean llllIlIllIIll) {
        this.recordPlaying = llllIlIllIlII;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = llllIlIllIIll;
    }
    
    public void func_191742_a(final ChatType llllIlIIIlllI, final ITextComponent llllIlIIIllIl) {
        for (final IChatListener llllIlIIIllII : this.field_191743_I.get(llllIlIIIlllI)) {
            llllIlIIIllII.func_192576_a(llllIlIIIlllI, llllIlIIIllIl);
        }
    }
    
    public GuiPlayerTabOverlay getTabList() {
        return this.overlayPlayerList;
    }
    
    static {
        VIGNETTE_TEX_PATH = new ResourceLocation("textures/misc/vignette.png");
        WIDGETS_TEX_PATH = new ResourceLocation("textures/gui/widgets.png");
        PUMPKIN_BLUR_TEX_PATH = new ResourceLocation("textures/misc/pumpkinblur.png");
    }
    
    private void renderVignette(float lllllIIIIIIlI, final ScaledResolution lllllIIIIlIlI) {
        if (!Config.isVignetteEnabled()) {
            GlStateManager.enableDepth();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }
        else {
            lllllIIIIIIlI = 1.0f - lllllIIIIIIlI;
            lllllIIIIIIlI = MathHelper.clamp(lllllIIIIIIlI, 0.0f, 1.0f);
            final WorldBorder lllllIIIIlIIl = this.mc.world.getWorldBorder();
            float lllllIIIIlIII = (float)lllllIIIIlIIl.getClosestDistance(this.mc.player);
            final double lllllIIIIIlll = Math.min(lllllIIIIlIIl.getResizeSpeed() * lllllIIIIlIIl.getWarningTime() * 1000.0, Math.abs(lllllIIIIlIIl.getTargetSize() - lllllIIIIlIIl.getDiameter()));
            final double lllllIIIIIllI = Math.max(lllllIIIIlIIl.getWarningDistance(), lllllIIIIIlll);
            if (lllllIIIIlIII < lllllIIIIIllI) {
                lllllIIIIlIII = 1.0f - (float)(lllllIIIIlIII / lllllIIIIIllI);
            }
            else {
                lllllIIIIlIII = 0.0f;
            }
            this.prevVignetteBrightness += (float)((lllllIIIIIIlI - this.prevVignetteBrightness) * 0.01);
            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            if (lllllIIIIlIII > 0.0f) {
                GlStateManager.color(0.0f, lllllIIIIlIII, lllllIIIIlIII, 1.0f);
            }
            else {
                GlStateManager.color(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0f);
            }
            this.mc.getTextureManager().bindTexture(GuiIngame.VIGNETTE_TEX_PATH);
            final Tessellator lllllIIIIIlIl = Tessellator.getInstance();
            final BufferBuilder lllllIIIIIlII = lllllIIIIIlIl.getBuffer();
            lllllIIIIIlII.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllIIIIIlII.pos(0.0, lllllIIIIlIlI.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
            lllllIIIIIlII.pos(lllllIIIIlIlI.getScaledWidth(), lllllIIIIlIlI.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
            lllllIIIIIlII.pos(lllllIIIIlIlI.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
            lllllIIIIIlII.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
            lllllIIIIIlIl.draw();
            GlStateManager.depthMask(true);
            GlStateManager.enableDepth();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }
    }
    
    public GuiIngame(final Minecraft lIIIIlIlIlIllI) {
        this.rand = new Random();
        this.animationStopwatch = new TimerHelper();
        this.recordPlaying = "";
        this.prevVignetteBrightness = 1.0f;
        this.highlightingItemStack = ItemStack.field_190927_a;
        this.displayedTitle = "";
        this.displayedSubTitle = "";
        this.field_191743_I = (Map<ChatType, List<IChatListener>>)Maps.newHashMap();
        this.deltaSpeed = 0.0;
        this.last = 0.0;
        this.mc = lIIIIlIlIlIllI;
        this.itemRenderer = lIIIIlIlIlIllI.getRenderItem();
        this.overlayDebug = new GuiOverlayDebug(lIIIIlIlIlIllI);
        this.spectatorGui = new GuiSpectator(lIIIIlIlIlIllI);
        this.persistantChatGUI = new GuiNewChat(lIIIIlIlIlIllI);
        this.overlayPlayerList = new GuiPlayerTabOverlay(lIIIIlIlIlIllI, this);
        this.overlayBoss = new GuiBossOverlay(lIIIIlIlIlIllI);
        this.overlaySubtitle = new GuiSubtitleOverlay(lIIIIlIlIlIllI);
        long lIIIIlIlIIlllI;
        for (char lIIIIlIlIIllll = (char)((ChatType[])(Object)(lIIIIlIlIIlllI = (long)(Object)ChatType.values())).length, lIIIIlIlIlIIII = '\0'; lIIIIlIlIlIIII < lIIIIlIlIIllll; ++lIIIIlIlIlIIII) {
            final ChatType lIIIIlIlIlIlIl = lIIIIlIlIIlllI[lIIIIlIlIlIIII];
            this.field_191743_I.put(lIIIIlIlIlIlIl, Lists.newArrayList());
        }
        final IChatListener lIIIIlIlIlIlII = NarratorChatListener.field_193643_a;
        this.field_191743_I.get(ChatType.CHAT).add(new NormalChatListener(lIIIIlIlIlIllI));
        this.field_191743_I.get(ChatType.CHAT).add(lIIIIlIlIlIlII);
        this.field_191743_I.get(ChatType.SYSTEM).add(new NormalChatListener(lIIIIlIlIlIllI));
        this.field_191743_I.get(ChatType.SYSTEM).add(lIIIIlIlIlIlII);
        this.field_191743_I.get(ChatType.GAME_INFO).add(new OverlayChatListener(lIIIIlIlIlIllI));
        this.setDefaultTitlesTimes();
    }
    
    public void displayTitle(final String llllIlIlIIIlI, final String llllIlIlIIIIl, final int llllIlIlIIIII, final int llllIlIlIIlIl, final int llllIlIlIIlII) {
        if (llllIlIlIIIlI == null && llllIlIlIIIIl == null && llllIlIlIIIII < 0 && llllIlIlIIlIl < 0 && llllIlIlIIlII < 0) {
            this.displayedTitle = "";
            this.displayedSubTitle = "";
            this.titlesTimer = 0;
        }
        else if (llllIlIlIIIlI != null) {
            this.displayedTitle = llllIlIlIIIlI;
            this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
        }
        else if (llllIlIlIIIIl != null) {
            this.displayedSubTitle = llllIlIlIIIIl;
        }
        else {
            if (llllIlIlIIIII >= 0) {
                this.titleFadeIn = llllIlIlIIIII;
            }
            if (llllIlIlIIlIl >= 0) {
                this.titleDisplayTime = llllIlIlIIlIl;
            }
            if (llllIlIlIIlII >= 0) {
                this.titleFadeOut = llllIlIlIIlII;
            }
            if (this.titlesTimer > 0) {
                this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
            }
        }
    }
    
    private void renderPlayerStats(final ScaledResolution llllllIIllIlI) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            final EntityPlayer llllllIIllIIl = (EntityPlayer)this.mc.getRenderViewEntity();
            final int llllllIIllIII = MathHelper.ceil(llllllIIllIIl.getHealth());
            final boolean llllllIIlIlll = this.healthUpdateCounter > this.updateCounter && (this.healthUpdateCounter - this.updateCounter) / 3L % 2L == 1L;
            if (llllllIIllIII < this.playerHealth && llllllIIllIIl.hurtResistantTime > 0) {
                this.lastSystemTime = Minecraft.getSystemTime();
                this.healthUpdateCounter = this.updateCounter + 20;
            }
            else if (llllllIIllIII > this.playerHealth && llllllIIllIIl.hurtResistantTime > 0) {
                this.lastSystemTime = Minecraft.getSystemTime();
                this.healthUpdateCounter = this.updateCounter + 10;
            }
            if (Minecraft.getSystemTime() - this.lastSystemTime > 1000L) {
                this.playerHealth = llllllIIllIII;
                this.lastPlayerHealth = llllllIIllIII;
                this.lastSystemTime = Minecraft.getSystemTime();
            }
            this.playerHealth = llllllIIllIII;
            final int llllllIIlIllI = this.lastPlayerHealth;
            this.rand.setSeed(this.updateCounter * 312871);
            final FoodStats llllllIIlIlIl = llllllIIllIIl.getFoodStats();
            final int llllllIIlIlII = llllllIIlIlIl.getFoodLevel();
            final IAttributeInstance llllllIIlIIll = llllllIIllIIl.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
            final int llllllIIlIIlI = llllllIIllIlI.getScaledWidth() / 2 - 91;
            final int llllllIIlIIIl = llllllIIllIlI.getScaledWidth() / 2 + 91;
            final int llllllIIlIIII = llllllIIllIlI.getScaledHeight() - 39;
            final float llllllIIIllll = (float)llllllIIlIIll.getAttributeValue();
            final int llllllIIIlllI = MathHelper.ceil(llllllIIllIIl.getAbsorptionAmount());
            final int llllllIIIllIl = MathHelper.ceil((llllllIIIllll + llllllIIIlllI) / 2.0f / 10.0f);
            final int llllllIIIllII = Math.max(10 - (llllllIIIllIl - 2), 3);
            final int llllllIIIlIll = llllllIIlIIII - (llllllIIIllIl - 1) * llllllIIIllII - 10;
            final int llllllIIIlIlI = llllllIIlIIII - 10;
            int llllllIIIlIIl = llllllIIIlllI;
            final int llllllIIIlIII = llllllIIllIIl.getTotalArmorValue();
            int llllllIIIIlll = -1;
            if (llllllIIllIIl.isPotionActive(MobEffects.REGENERATION)) {
                llllllIIIIlll = this.updateCounter % MathHelper.ceil(llllllIIIllll + 5.0f);
            }
            this.mc.mcProfiler.startSection("armor");
            for (int llllllIIIIllI = 0; llllllIIIIllI < 10; ++llllllIIIIllI) {
                if (llllllIIIlIII > 0) {
                    final int llllllIIIIlIl = llllllIIlIIlI + llllllIIIIllI * 8;
                    if (llllllIIIIllI * 2 + 1 < llllllIIIlIII) {
                        this.drawTexturedModalRect(llllllIIIIlIl, llllllIIIlIll, 34, 9, 9, 9);
                    }
                    if (llllllIIIIllI * 2 + 1 == llllllIIIlIII) {
                        this.drawTexturedModalRect(llllllIIIIlIl, llllllIIIlIll, 25, 9, 9, 9);
                    }
                    if (llllllIIIIllI * 2 + 1 > llllllIIIlIII) {
                        this.drawTexturedModalRect(llllllIIIIlIl, llllllIIIlIll, 16, 9, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endStartSection("health");
            for (int llllllIIIIlII = MathHelper.ceil((llllllIIIllll + llllllIIIlllI) / 2.0f) - 1; llllllIIIIlII >= 0; --llllllIIIIlII) {
                int llllllIIIIIll = 16;
                if (llllllIIllIIl.isPotionActive(MobEffects.POISON)) {
                    llllllIIIIIll += 36;
                }
                else if (llllllIIllIIl.isPotionActive(MobEffects.WITHER)) {
                    llllllIIIIIll += 72;
                }
                int llllllIIIIIlI = 0;
                if (llllllIIlIlll) {
                    llllllIIIIIlI = 1;
                }
                final int llllllIIIIIIl = MathHelper.ceil((llllllIIIIlII + 1) / 10.0f) - 1;
                final int llllllIIIIIII = llllllIIlIIlI + llllllIIIIlII % 10 * 8;
                int lllllIlllllll = llllllIIlIIII - llllllIIIIIIl * llllllIIIllII;
                if (llllllIIllIII <= 4) {
                    lllllIlllllll += this.rand.nextInt(2);
                }
                if (llllllIIIlIIl <= 0 && llllllIIIIlII == llllllIIIIlll) {
                    lllllIlllllll -= 2;
                }
                int lllllIllllllI = 0;
                if (llllllIIllIIl.world.getWorldInfo().isHardcoreModeEnabled()) {
                    lllllIllllllI = 5;
                }
                this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, 16 + llllllIIIIIlI * 9, 9 * lllllIllllllI, 9, 9);
                if (llllllIIlIlll) {
                    if (llllllIIIIlII * 2 + 1 < llllllIIlIllI) {
                        this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, llllllIIIIIll + 54, 9 * lllllIllllllI, 9, 9);
                    }
                    if (llllllIIIIlII * 2 + 1 == llllllIIlIllI) {
                        this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, llllllIIIIIll + 63, 9 * lllllIllllllI, 9, 9);
                    }
                }
                if (llllllIIIlIIl > 0) {
                    if (llllllIIIlIIl == llllllIIIlllI && llllllIIIlllI % 2 == 1) {
                        this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, llllllIIIIIll + 153, 9 * lllllIllllllI, 9, 9);
                        --llllllIIIlIIl;
                    }
                    else {
                        this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, llllllIIIIIll + 144, 9 * lllllIllllllI, 9, 9);
                        llllllIIIlIIl -= 2;
                    }
                }
                else {
                    if (llllllIIIIlII * 2 + 1 < llllllIIllIII) {
                        this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, llllllIIIIIll + 36, 9 * lllllIllllllI, 9, 9);
                    }
                    if (llllllIIIIlII * 2 + 1 == llllllIIllIII) {
                        this.drawTexturedModalRect(llllllIIIIIII, lllllIlllllll, llllllIIIIIll + 45, 9 * lllllIllllllI, 9, 9);
                    }
                }
            }
            final Entity lllllIlllllIl = llllllIIllIIl.getRidingEntity();
            if (lllllIlllllIl == null || !(lllllIlllllIl instanceof EntityLivingBase)) {
                this.mc.mcProfiler.endStartSection("food");
                for (int lllllIlllllII = 0; lllllIlllllII < 10; ++lllllIlllllII) {
                    int lllllIllllIll = llllllIIlIIII;
                    int lllllIllllIlI = 16;
                    int lllllIllllIIl = 0;
                    if (llllllIIllIIl.isPotionActive(MobEffects.HUNGER)) {
                        lllllIllllIlI += 36;
                        lllllIllllIIl = 13;
                    }
                    if (llllllIIllIIl.getFoodStats().getSaturationLevel() <= 0.0f && this.updateCounter % (llllllIIlIlII * 3 + 1) == 0) {
                        lllllIllllIll = llllllIIlIIII + (this.rand.nextInt(3) - 1);
                    }
                    final int lllllIllllIII = llllllIIlIIIl - lllllIlllllII * 8 - 9;
                    this.drawTexturedModalRect(lllllIllllIII, lllllIllllIll, 16 + lllllIllllIIl * 9, 27, 9, 9);
                    if (lllllIlllllII * 2 + 1 < llllllIIlIlII) {
                        this.drawTexturedModalRect(lllllIllllIII, lllllIllllIll, lllllIllllIlI + 36, 27, 9, 9);
                    }
                    if (lllllIlllllII * 2 + 1 == llllllIIlIlII) {
                        this.drawTexturedModalRect(lllllIllllIII, lllllIllllIll, lllllIllllIlI + 45, 27, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endStartSection("air");
            if (llllllIIllIIl.isInsideOfMaterial(Material.WATER)) {
                final int lllllIlllIlll = this.mc.player.getAir();
                for (int lllllIlllIllI = MathHelper.ceil((lllllIlllIlll - 2) * 10.0 / 300.0), lllllIlllIlIl = MathHelper.ceil(lllllIlllIlll * 10.0 / 300.0) - lllllIlllIllI, lllllIlllIlII = 0; lllllIlllIlII < lllllIlllIllI + lllllIlllIlIl; ++lllllIlllIlII) {
                    if (lllllIlllIlII < lllllIlllIllI) {
                        this.drawTexturedModalRect(llllllIIlIIIl - lllllIlllIlII * 8 - 9, llllllIIIlIlI, 16, 18, 9, 9);
                    }
                    else {
                        this.drawTexturedModalRect(llllllIIlIIIl - lllllIlllIlII * 8 - 9, llllllIIIlIlI, 25, 18, 9, 9);
                    }
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    public FontRenderer getFontRenderer() {
        return this.mc.fontRendererObj;
    }
    
    protected void renderPotionEffects(final ScaledResolution lIIIIIlIlIIIII) {
        final Collection<PotionEffect> lIIIIIlIIlllll = this.mc.player.getActivePotionEffects();
        if (!lIIIIIlIIlllll.isEmpty()) {
            this.mc.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
            GlStateManager.enableBlend();
            int lIIIIIlIIllllI = 0;
            int lIIIIIlIIlllIl = 0;
            for (final PotionEffect lIIIIIlIIllIll : Ordering.natural().reverse().sortedCopy((Iterable)lIIIIIlIIlllll)) {
                final Potion lIIIIIlIIllIlI = lIIIIIlIIllIll.getPotion();
                boolean lIIIIIlIIllIIl = lIIIIIlIIllIlI.hasStatusIcon();
                if (Reflector.ForgePotion_shouldRenderHUD.exists()) {
                    if (!Reflector.callBoolean(lIIIIIlIIllIlI, Reflector.ForgePotion_shouldRenderHUD, lIIIIIlIIllIll)) {
                        continue;
                    }
                    this.mc.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
                    lIIIIIlIIllIIl = true;
                }
                if (lIIIIIlIIllIIl && lIIIIIlIIllIll.doesShowParticles()) {
                    int lIIIIIlIIllIII = lIIIIIlIlIIIII.getScaledWidth();
                    int lIIIIIlIIlIlll = 1;
                    if (this.mc.isDemo()) {
                        lIIIIIlIIlIlll += 15;
                    }
                    final int lIIIIIlIIlIllI = lIIIIIlIIllIlI.getStatusIconIndex();
                    if (lIIIIIlIIllIlI.isBeneficial()) {
                        ++lIIIIIlIIllllI;
                        lIIIIIlIIllIII -= 25 * lIIIIIlIIllllI;
                    }
                    else {
                        ++lIIIIIlIIlllIl;
                        lIIIIIlIIllIII -= 25 * lIIIIIlIIlllIl;
                        lIIIIIlIIlIlll += 26;
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    float lIIIIIlIIlIlIl = 1.0f;
                    if (lIIIIIlIIllIll.getIsAmbient()) {
                        this.drawTexturedModalRect(lIIIIIlIIllIII, lIIIIIlIIlIlll, 165, 166, 24, 24);
                    }
                    else {
                        this.drawTexturedModalRect(lIIIIIlIIllIII, lIIIIIlIIlIlll, 141, 166, 24, 24);
                        if (lIIIIIlIIllIll.getDuration() <= 200) {
                            final int lIIIIIlIIlIlII = 10 - lIIIIIlIIllIll.getDuration() / 20;
                            lIIIIIlIIlIlIl = MathHelper.clamp(lIIIIIlIIllIll.getDuration() / 10.0f / 5.0f * 0.5f, 0.0f, 0.5f) + MathHelper.cos(lIIIIIlIIllIll.getDuration() * 3.1415927f / 5.0f) * MathHelper.clamp(lIIIIIlIIlIlII / 10.0f * 0.25f, 0.0f, 0.25f);
                        }
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, lIIIIIlIIlIlIl);
                    if (Reflector.ForgePotion_renderHUDEffect.exists()) {
                        if (lIIIIIlIIllIlI.hasStatusIcon()) {
                            this.drawTexturedModalRect(lIIIIIlIIllIII + 3, lIIIIIlIIlIlll + 3, lIIIIIlIIlIllI % 8 * 18, 198 + lIIIIIlIIlIllI / 8 * 18, 18, 18);
                        }
                        Reflector.call(lIIIIIlIIllIlI, Reflector.ForgePotion_renderHUDEffect, lIIIIIlIIllIII, lIIIIIlIIlIlll, lIIIIIlIIllIll, this.mc, lIIIIIlIIlIlIl);
                    }
                    else {
                        this.drawTexturedModalRect(lIIIIIlIIllIII + 3, lIIIIIlIIlIlll + 3, lIIIIIlIIlIllI % 8 * 18, 198 + lIIIIIlIIlIllI / 8 * 18, 18, 18);
                    }
                }
            }
        }
    }
    
    public static void drawHeadHui(final ResourceLocation lIIIIIllIlIlll, final int lIIIIIllIlIllI, final int lIIIIIllIlIlIl) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(lIIIIIllIlIlll);
        Gui.drawScaledCustomSizeModalRect(lIIIIIllIlIllI, lIIIIIllIlIlIl, 8.0f, 8.0f, 8, 8, 24, 24, 64.0f, 64.0f);
    }
    
    public void setRecordPlayingMessage(final String llllIlIlllIIl) {
        this.setRecordPlaying(I18n.format("record.nowPlaying", llllIlIlllIIl), true);
    }
    
    public float toPercent(final float lIIIIIlllIIIIl, final float lIIIIIlllIIIII) {
        return (float)(Math.round(lIIIIIlllIIIIl / lIIIIIlllIIIII * 10000.0f) / 100);
    }
    
    private void renderScoreboard(final ScoreObjective lllllllIIlIlI, final ScaledResolution lllllllIlllll) {
        final Scoreboard lllllllIllllI = lllllllIIlIlI.getScoreboard();
        Collection<Score> lllllllIlllIl = lllllllIllllI.getSortedScores(lllllllIIlIlI);
        final List<Score> lllllllIlllII = (List<Score>)Lists.newArrayList(Iterables.filter((Iterable)lllllllIlllIl, (Predicate)new Predicate<Score>() {
            public boolean apply(@Nullable final Score llllllllllllllIIIIIIIlllllIllllI) {
                return llllllllllllllIIIIIIIlllllIllllI.getPlayerName() != null && !llllllllllllllIIIIIIIlllllIllllI.getPlayerName().startsWith("#");
            }
        }));
        if (lllllllIlllII.size() > 15) {
            lllllllIlllIl = (Collection<Score>)Lists.newArrayList(Iterables.skip((Iterable)lllllllIlllII, lllllllIlllIl.size() - 15));
        }
        else {
            lllllllIlllIl = lllllllIlllII;
        }
        int lllllllIllIll = this.getFontRenderer().getStringWidth(lllllllIIlIlI.getDisplayName());
        for (final Score lllllllIllIlI : lllllllIlllIl) {
            final ScorePlayerTeam lllllllIllIIl = lllllllIllllI.getPlayersTeam(lllllllIllIlI.getPlayerName());
            final String lllllllIllIII = String.valueOf(new StringBuilder(String.valueOf(ScorePlayerTeam.formatPlayerName(lllllllIllIIl, lllllllIllIlI.getPlayerName()))).append(": ").append(TextFormatting.RED).append(lllllllIllIlI.getScorePoints()));
            lllllllIllIll = Math.max(lllllllIllIll, this.getFontRenderer().getStringWidth(lllllllIllIII));
        }
        final int lllllllIlIlll = lllllllIlllIl.size() * this.getFontRenderer().FONT_HEIGHT;
        final int lllllllIlIllI = lllllllIlllll.getScaledHeight() / 2 + lllllllIlIlll / 3;
        final int lllllllIlIlIl = 3;
        final int lllllllIlIlII = lllllllIlllll.getScaledWidth() - lllllllIllIll - 3;
        int lllllllIlIIll = 0;
        for (final Score lllllllIlIIlI : lllllllIlllIl) {
            ++lllllllIlIIll;
            final ScorePlayerTeam lllllllIlIIIl = lllllllIllllI.getPlayersTeam(lllllllIlIIlI.getPlayerName());
            final String lllllllIlIIII = ScorePlayerTeam.formatPlayerName(lllllllIlIIIl, lllllllIlIIlI.getPlayerName());
            final String lllllllIIllll = String.valueOf(new StringBuilder().append(TextFormatting.RED).append(lllllllIlIIlI.getScorePoints()));
            final int lllllllIIlllI = lllllllIlIllI - lllllllIlIIll * this.getFontRenderer().FONT_HEIGHT;
            final int lllllllIIllIl = lllllllIlllll.getScaledWidth() - 3 + 2;
            Gui.drawRect(lllllllIlIlII - 2, lllllllIIlllI, lllllllIIllIl, lllllllIIlllI + this.getFontRenderer().FONT_HEIGHT, 1342177280);
            this.getFontRenderer().drawString(lllllllIlIIII, lllllllIlIlII, lllllllIIlllI, 553648127);
            this.getFontRenderer().drawString(lllllllIIllll, lllllllIIllIl - this.getFontRenderer().getStringWidth(lllllllIIllll), lllllllIIlllI, 553648127);
            if (lllllllIlIIll == lllllllIlllIl.size()) {
                final String lllllllIIllII = lllllllIIlIlI.getDisplayName();
                Gui.drawRect(lllllllIlIlII - 2, lllllllIIlllI - this.getFontRenderer().FONT_HEIGHT - 1, lllllllIIllIl, lllllllIIlllI - 1, 1610612736);
                Gui.drawRect(lllllllIlIlII - 2, lllllllIIlllI - 1, lllllllIIllIl, lllllllIIlllI, 1342177280);
                this.getFontRenderer().drawString(lllllllIIllII, lllllllIlIlII + lllllllIllIll / 2 - this.getFontRenderer().getStringWidth(lllllllIIllII) / 2, lllllllIIlllI - this.getFontRenderer().FONT_HEIGHT, 553648127);
            }
        }
    }
    
    public void renderDemo(final ScaledResolution llllllllllIII) {
        this.mc.mcProfiler.startSection("demo");
        String llllllllllIll = null;
        if (this.mc.world.getTotalWorldTime() >= 120500L) {
            final String lllllllllllII = I18n.format("demo.demoExpired", new Object[0]);
        }
        else {
            llllllllllIll = I18n.format("demo.remainingTime", StringUtils.ticksToElapsedTime((int)(120500L - this.mc.world.getTotalWorldTime())));
        }
        final int llllllllllIlI = this.getFontRenderer().getStringWidth(llllllllllIll);
        this.getFontRenderer().drawStringWithShadow(llllllllllIll, (float)(llllllllllIII.getScaledWidth() - llllllllllIlI - 10), 5.0f, 16777215);
        this.mc.mcProfiler.endSection();
    }
    
    public void setRecordPlaying(final ITextComponent llllIlIIllIIl, final boolean llllIlIIllIII) {
        this.setRecordPlaying(llllIlIIllIIl.getUnformattedText(), llllIlIIllIII);
    }
    
    public GuiNewChat getChatGUI() {
        return this.persistantChatGUI;
    }
    
    protected void renderHotbar(final ScaledResolution lIIIIIIlllIlII, final float lIIIIIIlllIIll) {
        final double lIIIIIIlllIIlI = lIIIIIIlllIlII.getScaledWidth() / 2 - 91 + this.mc.player.inventory.currentItem * 20;
        final double lIIIIIIlllIIIl = (lIIIIIIlllIIlI - this.last) / Math.max((float)Minecraft.getDebugFPS(), 5.0f) * 25.0;
        if (Math.abs(lIIIIIIlllIIIl) > Math.abs(lIIIIIIlllIIlI - this.last)) {
            this.last = lIIIIIIlllIIlI;
        }
        else {
            this.last += lIIIIIIlllIIIl;
        }
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(GuiIngame.WIDGETS_TEX_PATH);
            final EntityPlayer lIIIIIIlllIIII = (EntityPlayer)this.mc.getRenderViewEntity();
            final ItemStack lIIIIIIllIllll = lIIIIIIlllIIII.getHeldItemOffhand();
            final EnumHandSide lIIIIIIllIlllI = lIIIIIIlllIIII.getPrimaryHand().opposite();
            final int lIIIIIIllIllIl = lIIIIIIlllIlII.getScaledWidth() / 2;
            final float lIIIIIIllIllII = this.zLevel;
            final int lIIIIIIllIlIll = 182;
            final int lIIIIIIllIlIlI = 91;
            this.zLevel = -90.0f;
            this.drawTexturedModalRect(lIIIIIIllIllIl - 91, lIIIIIIlllIlII.getScaledHeight() - 22, 0, 0, 182, 22);
            this.drawTexturedModalRect((int)this.last, lIIIIIIlllIlII.getScaledHeight() - 22 - 1, 0, 22, 24, 22);
            if (!lIIIIIIllIllll.func_190926_b()) {
                if (lIIIIIIllIlllI == EnumHandSide.LEFT) {
                    this.drawTexturedModalRect((int)this.last, lIIIIIIlllIlII.getScaledHeight() - 23, 24, 22, 29, 24);
                }
                else {
                    this.drawTexturedModalRect((int)this.last, lIIIIIIlllIlII.getScaledHeight() - 23, 53, 22, 29, 24);
                }
            }
            this.zLevel = lIIIIIIllIllII;
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.enableGUIStandardItemLighting();
            CustomItems.setRenderOffHand(false);
            for (int lIIIIIIllIlIIl = 0; lIIIIIIllIlIIl < 9; ++lIIIIIIllIlIIl) {
                final int lIIIIIIllIlIII = lIIIIIIllIllIl - 90 + lIIIIIIllIlIIl * 20 + 2;
                final int lIIIIIIllIIlll = lIIIIIIlllIlII.getScaledHeight() - 16 - 3;
                this.renderHotbarItem(lIIIIIIllIlIII, lIIIIIIllIIlll, lIIIIIIlllIIll, lIIIIIIlllIIII, lIIIIIIlllIIII.inventory.mainInventory.get(lIIIIIIllIlIIl));
            }
            if (!lIIIIIIllIllll.func_190926_b()) {
                CustomItems.setRenderOffHand(true);
                final int lIIIIIIllIIllI = lIIIIIIlllIlII.getScaledHeight() - 16 - 3;
                if (lIIIIIIllIlllI == EnumHandSide.LEFT) {
                    this.renderHotbarItem(lIIIIIIllIllIl - 91 - 26, lIIIIIIllIIllI, lIIIIIIlllIIll, lIIIIIIlllIIII, lIIIIIIllIllll);
                }
                else {
                    this.renderHotbarItem(lIIIIIIllIllIl + 91 + 10, lIIIIIIllIIllI, lIIIIIIlllIIll, lIIIIIIlllIIII, lIIIIIIllIllll);
                }
                CustomItems.setRenderOffHand(false);
            }
            if (this.mc.gameSettings.attackIndicator == 2) {
                final float lIIIIIIllIIlIl = this.mc.player.getCooledAttackStrength(0.0f);
                if (lIIIIIIllIIlIl < 1.0f) {
                    final int lIIIIIIllIIlII = lIIIIIIlllIlII.getScaledHeight() - 20;
                    int lIIIIIIllIIIll = lIIIIIIllIllIl + 91 + 6;
                    if (lIIIIIIllIlllI == EnumHandSide.RIGHT) {
                        lIIIIIIllIIIll = lIIIIIIllIllIl - 91 - 22;
                    }
                    this.mc.getTextureManager().bindTexture(Gui.ICONS);
                    final int lIIIIIIllIIIlI = (int)(lIIIIIIllIIlIl * 19.0f);
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    this.drawTexturedModalRect(lIIIIIIllIIIll, lIIIIIIllIIlII, 0, 94, 18, 18);
                    this.drawTexturedModalRect(lIIIIIIllIIIll, lIIIIIIllIIlII + 18 - lIIIIIIllIIIlI, 18, 112 - lIIIIIIllIIIlI, 18, lIIIIIIllIIIlI);
                }
            }
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }
    
    public void renderGameOverlay(final float lIIIIIllllllIl) {
        final ScaledResolution lIIIIlIIlIlllI = new ScaledResolution(this.mc);
        final int lIIIIlIIlIllIl = lIIIIlIIlIlllI.getScaledWidth();
        final int lIIIIlIIlIllII = lIIIIlIIlIlllI.getScaledHeight();
        final FontRenderer lIIIIlIIlIlIll = this.getFontRenderer();
        GlStateManager.enableBlend();
        if (Config.isVignetteEnabled()) {
            this.renderVignette(this.mc.player.getBrightness(), lIIIIlIIlIlllI);
        }
        else {
            GlStateManager.enableDepth();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        }
        final ItemStack lIIIIlIIlIlIlI = this.mc.player.inventory.armorItemInSlot(3);
        if (this.mc.gameSettings.thirdPersonView == 0 && lIIIIlIIlIlIlI.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
            this.renderPumpkinOverlay(lIIIIlIIlIlllI);
        }
        if (!this.mc.player.isPotionActive(MobEffects.NAUSEA)) {
            final float lIIIIlIIlIlIIl = this.mc.player.prevTimeInPortal + (this.mc.player.timeInPortal - this.mc.player.prevTimeInPortal) * lIIIIIllllllIl;
            if (lIIIIlIIlIlIIl > 0.0f) {
                this.renderPortal(lIIIIlIIlIlIIl, lIIIIlIIlIlllI);
            }
        }
        if (this.mc.playerController.isSpectator()) {
            this.spectatorGui.renderTooltip(lIIIIlIIlIlllI, lIIIIIllllllIl);
        }
        else {
            this.renderHotbar(lIIIIlIIlIlllI, lIIIIIllllllIl);
        }
        final Event2D lIIIIlIIlIlIII = new Event2D((float)lIIIIlIIlIlllI.getScaledWidth(), (float)lIIIIlIIlIlllI.getScaledHeight());
        lIIIIlIIlIlIII.call();
        final EventRenderer2D lIIIIlIIlIIlll = new EventRenderer2D(lIIIIlIIlIlllI, lIIIIIllllllIl);
        lIIIIlIIlIIlll.call();
        if (Killaura.targetHud.getValBoolean() && Main.moduleManager.getModuleByName("Killaura").isToggled() && this.mc.world != null) {
            final Event2D lIIIIlIIlIIllI = new Event2D((float)lIIIIlIIlIlllI.getScaledWidth(), (float)lIIIIlIIlIlllI.getScaledHeight());
            final float lIIIIlIIlIIlIl = lIIIIlIIlIIllI.getWidth();
            final float lIIIIlIIlIIlII = lIIIIlIIlIIllI.getHeight();
            final int[] lIIIIlIIlIIIll = { 1 };
            final EntityPlayer lIIIIlIIlIIIlI = this.mc.world.loadedEntityList.stream().filter(llllIIllIllll -> llllIIllIllll instanceof EntityPlayer).filter(llllIIllIlIll -> this.mc.player != llllIIllIlIll).map(llllIIllIIllI -> llllIIllIIllI).min(Comparator.comparing(llllIIllIIIII -> this.mc.player.getDistanceToEntity(llllIIllIIIII))).orElse(null);
            final String lIIIIlIIlIIIIl = Killaura.targetHudModeType.getValString();
            if (lIIIIlIIlIIIlI != null && lIIIIlIIlIIIlI.getHealth() > 0.0f && lIIIIlIIlIIIIl.equalsIgnoreCase("Simple")) {
                final float lIIIIlIIlIIIII = lIIIIlIIlIIlIl / 2.0f + 30.0f;
                final float lIIIIlIIIlllll = lIIIIlIIlIIlII / 2.0f + 10.0f;
                final float lIIIIlIIIllllI = lIIIIlIIlIIIlI.getHealth();
                double lIIIIlIIIlllIl = lIIIIlIIIllllI / lIIIIlIIlIIIlI.getMaxHealth();
                lIIIIlIIIlllIl = MathHelper.clamp(lIIIIlIIIlllIl, 0.0, 1.0);
                final double lIIIIlIIIlllII = 72.0 * lIIIIlIIIlllIl;
                final int lIIIIlIIIllIll = TwoColoreffect(new Color(65, 179, 255, 170), new Color(248, 54, 255, 170), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 3.0 * (lIIIIlIIlIIIll[0] * 2.55) / 60.0).getRGB();
                if (this.animationStopwatch.delay(15.0f)) {
                    this.healthBarWidth = AnimUtils.animate(lIIIIlIIIlllII, this.healthBarWidth - 10.0, 0.3529999852180481);
                    this.hudHeight = AnimUtils.animate(40.0, this.hudHeight, 0.10000000149011612);
                    this.animationStopwatch.reset();
                }
                RenderUtils.drawRect(lIIIIlIIlIIIII + 50.0f, lIIIIlIIIlllll + 10.0f, lIIIIlIIlIIIII + 80.0f + this.healthBarWidth, lIIIIlIIIlllll + 25.0f, lIIIIlIIIllIll);
                final int[] array = lIIIIlIIlIIIll;
                final int n = 0;
                ++array[n];
            }
            if (lIIIIlIIlIIIlI != null && lIIIIlIIlIIIlI.getHealth() > 0.0f && lIIIIlIIlIIIIl.equalsIgnoreCase("Improve")) {
                final NetworkPlayerInfo lIIIIlIIIllIlI = this.mc.getConnection().getPlayerInfo(lIIIIlIIlIIIlI.getUniqueID());
                final MinecraftFontRenderer lIIIIlIIIllIIl = FontLoader.INSTANCE.comfortaa_bold_16;
                if (lIIIIlIIIllIlI != null && lIIIIlIIIllIlI.getLocationSkin() != null) {
                    final ScaledResolution lIIIIlIIIllIII = new ScaledResolution(this.mc);
                    final int lIIIIlIIIlIlll = 20;
                    final float lIIIIlIIIlIllI = lIIIIlIIlIIIlI.getMaxHealth();
                    final float lIIIIlIIIlIlIl = lIIIIlIIlIIIlI.getHealth();
                    final int lIIIIlIIIlIlII = new ScaledResolution(this.mc).getScaledWidth();
                    final int lIIIIlIIIlIIll = new ScaledResolution(this.mc).getScaledHeight();
                    final int lIIIIlIIIlIIlI = lIIIIlIIIllIII.getScaledWidth() / 2 + lIIIIlIIIlIlll;
                    final int lIIIIlIIIlIIIl = lIIIIlIIIllIII.getScaledHeight() / 2 + 10;
                    RenderUtils.drawSmoothRect((float)(lIIIIlIIIlIlII / 2 + 15), (float)(lIIIIlIIIlIIll / 2 + 44), (float)(lIIIIlIIIlIlII / 2 + 144), (float)(lIIIIlIIIlIIll / 2 + 83), new Color(23, 23, 25, 203).getRGB());
                    RenderUtils.drawSmoothRect((float)(lIIIIlIIIlIlII / 2 + 28), (float)(lIIIIlIIIlIIll / 2 + 76), lIIIIlIIIlIlII / 2 + this.toPercent(lIIIIlIIIlIlIl, lIIIIlIIIlIlIl) * 1.0f + 28.0f, (float)(lIIIIlIIIlIIll / 2 + 79), new Color(12, 12, 12, 225).getRGB());
                    RenderUtils.drawSmoothRect((float)(lIIIIlIIIlIlII / 2 + 28), (float)(lIIIIlIIIlIIll / 2 + 76), lIIIIlIIIlIlII / 2 + this.toPercent(lIIIIlIIIlIlIl, lIIIIlIIIlIllI) * 1.0f + 28.0f, (float)(lIIIIlIIIlIIll / 2 + 79), new Color(20, 221, 32).getRGB());
                    lIIIIlIIIllIIl.drawStringWithShadow(lIIIIlIIlIIIlI.getName(), lIIIIlIIIlIlII / 2 + 45, lIIIIlIIIlIIll / 2 + 49, 16777215);
                    lIIIIlIIIllIIl.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("\u2661")), lIIIIlIIIlIlII / 2 + 17, lIIIIlIIIlIIll / 2 + 73, 16777215);
                    if (this.mc.player.getHealth() - lIIIIlIIIlIlIl > 0.0f) {
                        lIIIIlIIIllIIl.drawStringWithShadow("Winning!", lIIIIlIIIlIlII / 2 + 45, lIIIIlIIIlIIll / 2 + 64, new Color(0, 255, 0, 255).getRGB());
                    }
                    if (this.mc.player.getHealth() - lIIIIlIIIlIlIl < 0.0f) {
                        lIIIIlIIIllIIl.drawStringWithShadow("Losing!", lIIIIlIIIlIlII / 2 + 45, lIIIIlIIIlIIll / 2 + 64, new Color(255, 0, 0, 255).getRGB());
                    }
                    if (this.mc.player.getHealth() - lIIIIlIIIlIlIl == 0.0f) {
                        lIIIIlIIIllIIl.drawStringWithShadow("Destroy Him!", lIIIIlIIIlIlII / 2 + 45, lIIIIlIIIlIIll / 2 + 64, new Color(255, 255, 0, 255).getRGB());
                    }
                    int lIIIIlIIIlIIII = 0;
                    if (Item.getIdFromItem(lIIIIlIIlIIIlI.inventory.getCurrentItem().getItem()) == 322) {
                        lIIIIlIIIlIIII = lIIIIlIIlIIIlI.inventory.getCurrentItem().stackSize;
                    }
                    else if (Item.getIdFromItem(lIIIIlIIlIIIlI.getHeldItemOffhand().getItem()) == 322) {
                        lIIIIlIIIlIIII = lIIIIlIIlIIIlI.getHeldItemOffhand().stackSize;
                    }
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)(lIIIIlIIIllIII.getScaledWidth() / 2 + 130), (float)(lIIIIlIIIllIII.getScaledHeight() / 2 + 42.5), 0.0f);
                    GL11.glScaled(1.0, 1.0, 0.0);
                    this.mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.GOLDEN_APPLE), 0, 0);
                    GL11.glScaled(0.83, 0.83, 0.0);
                    lIIIIlIIIllIIl.drawStringWithShadow(String.valueOf(lIIIIlIIIlIIII), 6, 16, -1);
                    GL11.glPopMatrix();
                    GlStateManager.pushMatrix();
                    GlStateManager.popMatrix();
                    drawHeadHui(lIIIIlIIIllIlI.getLocationSkin(), lIIIIlIIIlIIlI - 4, lIIIIlIIIlIIIl + 35);
                }
            }
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiIngame.ICONS);
        GlStateManager.enableBlend();
        this.renderAttackIndicator(lIIIIIllllllIl, lIIIIlIIlIlllI);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        this.mc.mcProfiler.startSection("bossHealth");
        this.overlayBoss.renderBossHealth();
        this.mc.mcProfiler.endSection();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiIngame.ICONS);
        if (this.mc.playerController.shouldDrawHUD()) {
            this.renderPlayerStats(lIIIIlIIlIlllI);
        }
        this.renderMountHealth(lIIIIlIIlIlllI);
        GlStateManager.disableBlend();
        if (this.mc.player.getSleepTimer() > 0) {
            this.mc.mcProfiler.startSection("sleep");
            GlStateManager.disableDepth();
            GlStateManager.disableAlpha();
            final int lIIIIlIIIIllll = this.mc.player.getSleepTimer();
            float lIIIIlIIIIlllI = lIIIIlIIIIllll / 100.0f;
            if (lIIIIlIIIIlllI > 1.0f) {
                lIIIIlIIIIlllI = 1.0f - (lIIIIlIIIIllll - 100) / 10.0f;
            }
            final int lIIIIlIIIIllIl = (int)(220.0f * lIIIIlIIIIlllI) << 24 | 0x101020;
            Gui.drawRect(0.0, 0.0, lIIIIlIIlIllIl, lIIIIlIIlIllII, lIIIIlIIIIllIl);
            GlStateManager.enableAlpha();
            GlStateManager.enableDepth();
            this.mc.mcProfiler.endSection();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lIIIIlIIIIllII = lIIIIlIIlIllIl / 2 - 91;
        if (this.mc.player.isRidingHorse()) {
            this.renderHorseJumpBar(lIIIIlIIlIlllI, lIIIIlIIIIllII);
        }
        else if (this.mc.playerController.gameIsSurvivalOrAdventure()) {
            this.renderExpBar(lIIIIlIIlIlllI, lIIIIlIIIIllII);
        }
        if (this.mc.gameSettings.heldItemTooltips && !this.mc.playerController.isSpectator()) {
            this.renderSelectedItem(lIIIIlIIlIlllI);
        }
        else if (this.mc.player.isSpectator()) {
            this.spectatorGui.renderSelectedItem(lIIIIlIIlIlllI);
        }
        if (this.mc.isDemo()) {
            this.renderDemo(lIIIIlIIlIlllI);
        }
        this.renderPotionEffects(lIIIIlIIlIlllI);
        if (this.mc.gameSettings.showDebugInfo) {
            this.overlayDebug.renderDebugInfo(lIIIIlIIlIlllI);
        }
        if (this.recordPlayingUpFor > 0) {
            this.mc.mcProfiler.startSection("overlayMessage");
            final float lIIIIlIIIIlIll = this.recordPlayingUpFor - lIIIIIllllllIl;
            int lIIIIlIIIIlIlI = (int)(lIIIIlIIIIlIll * 255.0f / 20.0f);
            if (lIIIIlIIIIlIlI > 255) {
                lIIIIlIIIIlIlI = 255;
            }
            if (lIIIIlIIIIlIlI > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lIIIIlIIlIllIl / 2), (float)(lIIIIlIIlIllII - 68), 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                int lIIIIlIIIIlIIl = 16777215;
                if (this.recordIsPlaying) {
                    lIIIIlIIIIlIIl = (MathHelper.hsvToRGB(lIIIIlIIIIlIll / 50.0f, 0.7f, 0.6f) & 0xFFFFFF);
                }
                lIIIIlIIlIlIll.drawString(this.recordPlaying, -lIIIIlIIlIlIll.getStringWidth(this.recordPlaying) / 2, -4.0, lIIIIlIIIIlIIl + (lIIIIlIIIIlIlI << 24 & 0xFF000000));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        this.overlaySubtitle.renderSubtitles(lIIIIlIIlIlllI);
        if (this.titlesTimer > 0) {
            this.mc.mcProfiler.startSection("titleAndSubtitle");
            final float lIIIIlIIIIlIII = this.titlesTimer - lIIIIIllllllIl;
            int lIIIIlIIIIIlll = 255;
            if (this.titlesTimer > this.titleFadeOut + this.titleDisplayTime) {
                final float lIIIIlIIIIIllI = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut - lIIIIlIIIIlIII;
                lIIIIlIIIIIlll = (int)(lIIIIlIIIIIllI * 255.0f / this.titleFadeIn);
            }
            if (this.titlesTimer <= this.titleFadeOut) {
                lIIIIlIIIIIlll = (int)(lIIIIlIIIIlIII * 255.0f / this.titleFadeOut);
            }
            lIIIIlIIIIIlll = MathHelper.clamp(lIIIIlIIIIIlll, 0, 255);
            if (lIIIIlIIIIIlll > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lIIIIlIIlIllIl / 2), (float)(lIIIIlIIlIllII / 2), 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.pushMatrix();
                GlStateManager.scale(4.0f, 4.0f, 4.0f);
                final int lIIIIlIIIIIlIl = lIIIIlIIIIIlll << 24 & 0xFF000000;
                lIIIIlIIlIlIll.drawString(this.displayedTitle, (float)(-lIIIIlIIlIlIll.getStringWidth(this.displayedTitle) / 2), -10.0f, 0xFFFFFF | lIIIIlIIIIIlIl, true);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                lIIIIlIIlIlIll.drawString(this.displayedSubTitle, (float)(-lIIIIlIIlIlIll.getStringWidth(this.displayedSubTitle) / 2), 5.0f, 0xFFFFFF | lIIIIlIIIIIlIl, true);
                GlStateManager.popMatrix();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        final Scoreboard lIIIIlIIIIIlII = this.mc.world.getScoreboard();
        ScoreObjective lIIIIlIIIIIIll = null;
        final ScorePlayerTeam lIIIIlIIIIIIlI = lIIIIlIIIIIlII.getPlayersTeam(this.mc.player.getName());
        if (lIIIIlIIIIIIlI != null) {
            final int lIIIIlIIIIIIIl = lIIIIlIIIIIIlI.getChatFormat().getColorIndex();
            if (lIIIIlIIIIIIIl >= 0) {
                lIIIIlIIIIIIll = lIIIIlIIIIIlII.getObjectiveInDisplaySlot(3 + lIIIIlIIIIIIIl);
            }
        }
        ScoreObjective lIIIIlIIIIIIII = (lIIIIlIIIIIIll != null) ? lIIIIlIIIIIIll : lIIIIlIIIIIlII.getObjectiveInDisplaySlot(1);
        if (lIIIIlIIIIIIII != null && !Main.moduleManager.getModuleByName("NoScoreBoard").isToggled()) {
            this.renderScoreboard(lIIIIlIIIIIIII, lIIIIlIIlIlllI);
        }
        final EventRender2D lIIIIIllllllll = new EventRender2D(lIIIIlIIlIlllI, lIIIIIllllllIl);
        lIIIIIllllllll.call();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.disableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, (float)(lIIIIlIIlIllII - 48), 0.0f);
        this.mc.mcProfiler.startSection("chat");
        this.persistantChatGUI.drawChat(this.updateCounter);
        this.mc.mcProfiler.endSection();
        GlStateManager.popMatrix();
        lIIIIlIIIIIIII = lIIIIlIIIIIlII.getObjectiveInDisplaySlot(0);
        if (this.mc.gameSettings.keyBindPlayerList.isKeyDown() && (!this.mc.isIntegratedServerRunning() || this.mc.player.connection.getPlayerInfoMap().size() > 1 || lIIIIlIIIIIIII != null)) {
            this.overlayPlayerList.updatePlayerList(true);
            this.overlayPlayerList.renderPlayerlist(lIIIIlIIlIllIl, lIIIIlIIIIIlII, lIIIIlIIIIIIII);
        }
        else {
            this.overlayPlayerList.updatePlayerList(false);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
    }
    
    private void renderHotbarItem(final int llllIllIlIIll, final int llllIllIlIIlI, final float llllIllIlIIIl, final EntityPlayer llllIllIIlIII, final ItemStack llllIllIIIlll) {
        if (!llllIllIIIlll.func_190926_b()) {
            final float llllIllIIlllI = llllIllIIIlll.func_190921_D() - llllIllIlIIIl;
            if (llllIllIIlllI > 0.0f) {
                GlStateManager.pushMatrix();
                final float llllIllIIllIl = 1.0f + llllIllIIlllI / 5.0f;
                GlStateManager.translate((float)(llllIllIlIIll + 8), (float)(llllIllIlIIlI + 12), 0.0f);
                GlStateManager.scale(1.0f / llllIllIIllIl, (llllIllIIllIl + 1.0f) / 2.0f, 1.0f);
                GlStateManager.translate((float)(-(llllIllIlIIll + 8)), (float)(-(llllIllIlIIlI + 12)), 0.0f);
            }
            this.itemRenderer.renderItemAndEffectIntoGUI(llllIllIIlIII, llllIllIIIlll, llllIllIlIIll, llllIllIlIIlI);
            if (llllIllIIlllI > 0.0f) {
                GlStateManager.popMatrix();
            }
            this.itemRenderer.renderItemOverlays(this.mc.fontRendererObj, llllIllIIIlll, llllIllIlIIll, llllIllIlIIlI);
        }
    }
    
    public static Color TwoColoreffect(final Color lIIIIIIlIIllIl, final Color lIIIIIIlIIIlll, double lIIIIIIlIIIllI) {
        if (lIIIIIIlIIIllI > 1.0) {
            final double lIIIIIIlIIlIlI = (double)(lIIIIIIlIIIllI % 1.0);
            lIIIIIIlIIIllI = (((int)lIIIIIIlIIIllI % 2 == 0) ? lIIIIIIlIIlIlI : (1.0 - lIIIIIIlIIlIlI));
        }
        final double lIIIIIIlIIlIIl = (double)(1.0 - lIIIIIIlIIIllI);
        return new Color((int)(lIIIIIIlIIllIl.getRed() * lIIIIIIlIIlIIl + (double)lIIIIIIlIIIlll.getRed() * lIIIIIIlIIIllI), (int)(lIIIIIIlIIllIl.getGreen() * lIIIIIIlIIlIIl + (double)lIIIIIIlIIIlll.getGreen() * lIIIIIIlIIIllI), (int)(lIIIIIIlIIllIl.getBlue() * lIIIIIIlIIlIIl + (double)lIIIIIIlIIIlll.getBlue() * lIIIIIIlIIIllI), (int)(lIIIIIIlIIllIl.getAlpha() * lIIIIIIlIIlIIl + (double)lIIIIIIlIIIlll.getAlpha() * lIIIIIIlIIIllI));
    }
    
    private void renderMountHealth(final ScaledResolution lllllIlIIIlII) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            final EntityPlayer lllllIlIIIIll = (EntityPlayer)this.mc.getRenderViewEntity();
            final Entity lllllIlIIIIlI = lllllIlIIIIll.getRidingEntity();
            if (lllllIlIIIIlI instanceof EntityLivingBase) {
                this.mc.mcProfiler.endStartSection("mountHealth");
                final EntityLivingBase lllllIlIIIIIl = (EntityLivingBase)lllllIlIIIIlI;
                final int lllllIlIIIIII = (int)Math.ceil(lllllIlIIIIIl.getHealth());
                final float lllllIIllllll = lllllIlIIIIIl.getMaxHealth();
                int lllllIIlllllI = (int)(lllllIIllllll + 0.5f) / 2;
                if (lllllIIlllllI > 30) {
                    lllllIIlllllI = 30;
                }
                final int lllllIIllllIl = lllllIlIIIlII.getScaledHeight() - 39;
                final int lllllIIllllII = lllllIlIIIlII.getScaledWidth() / 2 + 91;
                int lllllIIlllIll = lllllIIllllIl;
                int lllllIIlllIlI = 0;
                final boolean lllllIIlllIIl = false;
                while (lllllIIlllllI > 0) {
                    final int lllllIIlllIII = Math.min(lllllIIlllllI, 10);
                    lllllIIlllllI -= lllllIIlllIII;
                    for (int lllllIIllIlll = 0; lllllIIllIlll < lllllIIlllIII; ++lllllIIllIlll) {
                        final int lllllIIllIllI = 52;
                        final int lllllIIllIlIl = 0;
                        final int lllllIIllIlII = lllllIIllllII - lllllIIllIlll * 8 - 9;
                        this.drawTexturedModalRect(lllllIIllIlII, lllllIIlllIll, 52 + lllllIIllIlIl * 9, 9, 9, 9);
                        if (lllllIIllIlll * 2 + 1 + lllllIIlllIlI < lllllIlIIIIII) {
                            this.drawTexturedModalRect(lllllIIllIlII, lllllIIlllIll, 88, 9, 9, 9);
                        }
                        if (lllllIIllIlll * 2 + 1 + lllllIIlllIlI == lllllIlIIIIII) {
                            this.drawTexturedModalRect(lllllIIllIlII, lllllIIlllIll, 97, 9, 9, 9);
                        }
                    }
                    lllllIIlllIll -= 10;
                    lllllIIlllIlI += 20;
                }
            }
        }
    }
    
    public void updateTick() {
        if (this.mc.world == null) {
            TextureAnimations.updateAnimations();
        }
        if (this.recordPlayingUpFor > 0) {
            --this.recordPlayingUpFor;
        }
        if (this.titlesTimer > 0) {
            --this.titlesTimer;
            if (this.titlesTimer <= 0) {
                this.displayedTitle = "";
                this.displayedSubTitle = "";
            }
        }
        ++this.updateCounter;
        if (this.mc.player != null) {
            final ItemStack llllIllIIIIIl = this.mc.player.inventory.getCurrentItem();
            if (llllIllIIIIIl.func_190926_b()) {
                this.remainingHighlightTicks = 0;
            }
            else if (!this.highlightingItemStack.func_190926_b() && llllIllIIIIIl.getItem() == this.highlightingItemStack.getItem() && ItemStack.areItemStackTagsEqual(llllIllIIIIIl, this.highlightingItemStack) && (llllIllIIIIIl.isItemStackDamageable() || llllIllIIIIIl.getMetadata() == this.highlightingItemStack.getMetadata())) {
                if (this.remainingHighlightTicks > 0) {
                    --this.remainingHighlightTicks;
                }
            }
            else {
                this.remainingHighlightTicks = 40;
            }
            this.highlightingItemStack = llllIllIIIIIl;
        }
    }
    
    public void renderSelectedItem(final ScaledResolution lIIIIIIIIIIlll) {
        this.mc.mcProfiler.startSection("selectedItemName");
        if (this.remainingHighlightTicks > 0 && !this.highlightingItemStack.func_190926_b()) {
            String lIIIIIIIIIllII = this.highlightingItemStack.getDisplayName();
            if (this.highlightingItemStack.hasDisplayName()) {
                lIIIIIIIIIllII = String.valueOf(new StringBuilder().append(TextFormatting.ITALIC).append(lIIIIIIIIIllII));
            }
            final int lIIIIIIIIIlIll = (lIIIIIIIIIIlll.getScaledWidth() - this.getFontRenderer().getStringWidth(lIIIIIIIIIllII)) / 2;
            int lIIIIIIIIIlIlI = lIIIIIIIIIIlll.getScaledHeight() - 59;
            if (!this.mc.playerController.shouldDrawHUD()) {
                lIIIIIIIIIlIlI += 14;
            }
            int lIIIIIIIIIlIIl = (int)(this.remainingHighlightTicks * 256.0f / 10.0f);
            if (lIIIIIIIIIlIIl > 255) {
                lIIIIIIIIIlIIl = 255;
            }
            if (lIIIIIIIIIlIIl > 0) {
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                this.getFontRenderer().drawStringWithShadow(lIIIIIIIIIllII, (float)lIIIIIIIIIlIll, (float)lIIIIIIIIIlIlI, 16777215 + (lIIIIIIIIIlIIl << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
        this.mc.mcProfiler.endSection();
    }
    
    public GuiBossOverlay getBossOverlay() {
        return this.overlayBoss;
    }
    
    public void resetPlayersOverlayFooterHeader() {
        this.overlayPlayerList.resetFooterHeader();
        this.overlayBoss.clearBossInfos();
        this.mc.func_193033_an().func_191788_b();
    }
    
    public void renderExpBar(final ScaledResolution lIIIIIIIlIIllI, final int lIIIIIIIlIIlIl) {
        this.mc.mcProfiler.startSection("expBar");
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
        final int lIIIIIIIlIIlII = this.mc.player.xpBarCap();
        if (lIIIIIIIlIIlII > 0) {
            final int lIIIIIIIlIIIll = 182;
            final int lIIIIIIIlIIIlI = (int)(this.mc.player.experience * 183.0f);
            final int lIIIIIIIlIIIIl = lIIIIIIIlIIllI.getScaledHeight() - 32 + 3;
            this.drawTexturedModalRect(lIIIIIIIlIIlIl, lIIIIIIIlIIIIl, 0, 64, 182, 5);
            if (lIIIIIIIlIIIlI > 0) {
                this.drawTexturedModalRect(lIIIIIIIlIIlIl, lIIIIIIIlIIIIl, 0, 69, lIIIIIIIlIIIlI, 5);
            }
        }
        this.mc.mcProfiler.endSection();
        if (this.mc.player.experienceLevel > 0) {
            this.mc.mcProfiler.startSection("expLevel");
            int lIIIIIIIlIIIII = 8453920;
            if (Config.isCustomColors()) {
                lIIIIIIIlIIIII = CustomColors.getExpBarTextColor(lIIIIIIIlIIIII);
            }
            final String lIIIIIIIIlllll = String.valueOf(new StringBuilder().append(this.mc.player.experienceLevel));
            final int lIIIIIIIIllllI = (lIIIIIIIlIIllI.getScaledWidth() - this.getFontRenderer().getStringWidth(lIIIIIIIIlllll)) / 2;
            final int lIIIIIIIIlllIl = lIIIIIIIlIIllI.getScaledHeight() - 31 - 4;
            this.getFontRenderer().drawString(lIIIIIIIIlllll, lIIIIIIIIllllI + 1, lIIIIIIIIlllIl, 0);
            this.getFontRenderer().drawString(lIIIIIIIIlllll, lIIIIIIIIllllI - 1, lIIIIIIIIlllIl, 0);
            this.getFontRenderer().drawString(lIIIIIIIIlllll, lIIIIIIIIllllI, lIIIIIIIIlllIl + 1, 0);
            this.getFontRenderer().drawString(lIIIIIIIIlllll, lIIIIIIIIllllI, lIIIIIIIIlllIl - 1, 0);
            this.getFontRenderer().drawString(lIIIIIIIIlllll, lIIIIIIIIllllI, lIIIIIIIIlllIl, lIIIIIIIlIIIII);
            this.mc.mcProfiler.endSection();
        }
    }
    
    private void renderAttackIndicator(final float lIIIIIllIIlIII, final ScaledResolution lIIIIIlIlllIII) {
        final GameSettings lIIIIIllIIIllI = this.mc.gameSettings;
        if (lIIIIIllIIIllI.thirdPersonView == 0) {
            if (this.mc.playerController.isSpectator() && this.mc.pointedEntity == null) {
                final RayTraceResult lIIIIIllIIIlIl = this.mc.objectMouseOver;
                if (lIIIIIllIIIlIl == null || lIIIIIllIIIlIl.typeOfHit != RayTraceResult.Type.BLOCK) {
                    return;
                }
                final BlockPos lIIIIIllIIIlII = lIIIIIllIIIlIl.getBlockPos();
                final IBlockState lIIIIIllIIIIll = this.mc.world.getBlockState(lIIIIIllIIIlII);
                if (!ReflectorForge.blockHasTileEntity(lIIIIIllIIIIll) || !(this.mc.world.getTileEntity(lIIIIIllIIIlII) instanceof IInventory)) {
                    return;
                }
            }
            final int lIIIIIllIIIIlI = lIIIIIlIlllIII.getScaledWidth();
            final int lIIIIIllIIIIIl = lIIIIIlIlllIII.getScaledHeight();
            if (lIIIIIllIIIllI.showDebugInfo && !lIIIIIllIIIllI.hideGUI && !this.mc.player.hasReducedDebug() && !lIIIIIllIIIllI.reducedDebugInfo) {
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(lIIIIIllIIIIlI / 2), (float)(lIIIIIllIIIIIl / 2), this.zLevel);
                final Entity lIIIIIllIIIIII = this.mc.getRenderViewEntity();
                GlStateManager.rotate(lIIIIIllIIIIII.prevRotationPitch + (lIIIIIllIIIIII.rotationPitch - lIIIIIllIIIIII.prevRotationPitch) * lIIIIIllIIlIII, -1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(lIIIIIllIIIIII.prevRotationYaw + (lIIIIIllIIIIII.rotationYaw - lIIIIIllIIIIII.prevRotationYaw) * lIIIIIllIIlIII, 0.0f, 1.0f, 0.0f);
                GlStateManager.scale(-1.0f, -1.0f, -1.0f);
                OpenGlHelper.renderDirections(10);
                GlStateManager.popMatrix();
            }
            else {
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.enableAlpha();
                this.drawTexturedModalRect(lIIIIIllIIIIlI / 2 - 7, lIIIIIllIIIIIl / 2 - 7, 0, 0, 16, 16);
                if (this.mc.gameSettings.attackIndicator == 1) {
                    final float lIIIIIlIllllll = this.mc.player.getCooledAttackStrength(0.0f);
                    boolean lIIIIIlIlllllI = false;
                    if (this.mc.pointedEntity != null && this.mc.pointedEntity instanceof EntityLivingBase && lIIIIIlIllllll >= 1.0f) {
                        lIIIIIlIlllllI = (this.mc.player.getCooldownPeriod() > 5.0f);
                        lIIIIIlIlllllI &= ((EntityLivingBase)this.mc.pointedEntity).isEntityAlive();
                    }
                    final int lIIIIIlIllllIl = lIIIIIllIIIIIl / 2 - 7 + 16;
                    final int lIIIIIlIllllII = lIIIIIllIIIIlI / 2 - 8;
                    if (lIIIIIlIlllllI) {
                        this.drawTexturedModalRect(lIIIIIlIllllII, lIIIIIlIllllIl, 68, 94, 16, 16);
                    }
                    else if (lIIIIIlIllllll < 1.0f) {
                        final int lIIIIIlIlllIll = (int)(lIIIIIlIllllll * 17.0f);
                        this.drawTexturedModalRect(lIIIIIlIllllII, lIIIIIlIllllIl, 36, 94, 16, 4);
                        this.drawTexturedModalRect(lIIIIIlIllllII, lIIIIIlIllllIl, 52, 94, lIIIIIlIlllIll, 4);
                    }
                }
            }
        }
    }
    
    public void renderHorseJumpBar(final ScaledResolution lIIIIIIIllIlIl, final int lIIIIIIIlllIll) {
        this.mc.mcProfiler.startSection("jumpBar");
        this.mc.getTextureManager().bindTexture(Gui.ICONS);
        final float lIIIIIIIlllIlI = this.mc.player.getHorseJumpPower();
        final int lIIIIIIIlllIIl = 182;
        final int lIIIIIIIlllIII = (int)(lIIIIIIIlllIlI * 183.0f);
        final int lIIIIIIIllIlll = lIIIIIIIllIlIl.getScaledHeight() - 32 + 3;
        this.drawTexturedModalRect(lIIIIIIIlllIll, lIIIIIIIllIlll, 0, 84, 182, 5);
        if (lIIIIIIIlllIII > 0) {
            this.drawTexturedModalRect(lIIIIIIIlllIll, lIIIIIIIllIlll, 0, 89, lIIIIIIIlllIII, 5);
        }
        this.mc.mcProfiler.endSection();
    }
}
