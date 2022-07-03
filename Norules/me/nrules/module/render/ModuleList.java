package me.nrules.module.render;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.potion.*;
import org.lwjgl.opengl.*;
import me.nrules.utils.render.*;
import me.nrules.notifications.*;
import font.*;
import net.minecraft.util.text.*;
import com.kisman.nr.cc.manager.*;
import net.minecraft.client.*;
import java.awt.*;
import me.nrules.event.*;
import me.nrules.event.events.*;
import me.nrules.*;
import clickui.settings.*;
import me.nrules.module.*;
import java.util.*;

public class ModuleList extends Module
{
    private static /* synthetic */ MinecraftFontRenderer font;
    private /* synthetic */ Setting offset;
    private /* synthetic */ Setting outline;
    private /* synthetic */ double lastPosX;
    private /* synthetic */ Setting modeType;
    /* synthetic */ float ld;
    private final /* synthetic */ ResourceLocation watermark;
    /* synthetic */ float xd;
    private /* synthetic */ Setting info;
    private /* synthetic */ double lastPosZ;
    private /* synthetic */ Setting modeType1;
    private static /* synthetic */ MinecraftFontRenderer font1;
    private final /* synthetic */ ArrayList<Double> distances;
    private /* synthetic */ Setting opacity;
    private /* synthetic */ Setting background;
    
    private void GayHud(final ScaledResolution lllllllllllllIIlIIlIIllIlllllIll) {
        final int lllllllllllllIIlIIlIIllIlllllIlI = lllllllllllllIIlIIlIIllIlllllIll.getScaledWidth();
        final int lllllllllllllIIlIIlIIllIlllllIIl = lllllllllllllIIlIIlIIllIlllllIll.getScaledHeight();
        final ArrayList<Module> lllllllllllllIIlIIlIIllIlllllIII = this.getSortedModules(ModuleList.font);
        final int lllllllllllllIIlIIlIIllIllllIlll = (int)this.offset.getValDouble();
        int lllllllllllllIIlIIlIIllIllllIllI = 1;
        for (final PotionEffect lllllllllllllIIlIIlIIllIllllIlIl : ModuleList.mc.player.getActivePotionEffects()) {
            if (lllllllllllllIIlIIlIIllIllllIlIl.getPotion().isBadEffect()) {
                lllllllllllllIIlIIlIIllIllllIllI = 54;
            }
            if (lllllllllllllIIlIIlIIllIllllIlIl.getPotion().isBeneficial()) {
                lllllllllllllIIlIIlIIllIllllIllI = 28;
            }
        }
        final int[] lllllllllllllIIlIIlIIllIllllIlII = { 1 };
        GL11.glEnable(3042);
        for (int lllllllllllllIIlIIlIIllIllllIIll = 0, lllllllllllllIIlIIlIIllIllllIIlI = lllllllllllllIIlIIlIIllIlllllIII.size(); lllllllllllllIIlIIlIIllIllllIIll < lllllllllllllIIlIIlIIllIllllIIlI; ++lllllllllllllIIlIIlIIllIllllIIll) {
            final Module lllllllllllllIIlIIlIIllIllllIIIl = lllllllllllllIIlIIlIIllIlllllIII.get(lllllllllllllIIlIIlIIllIllllIIll);
            final Translate lllllllllllllIIlIIlIIllIllllIIII = lllllllllllllIIlIIlIIllIllllIIIl.getTranslate();
            final String lllllllllllllIIlIIlIIllIlllIllll = lllllllllllllIIlIIlIIllIllllIIIl.getModuleName();
            final float lllllllllllllIIlIIlIIllIlllIlllI = (float)ModuleList.font.getStringWidth(lllllllllllllIIlIIlIIllIlllIllll);
            final float lllllllllllllIIlIIlIIllIlllIllIl = lllllllllllllIIlIIlIIllIlllllIlI - lllllllllllllIIlIIlIIllIlllIlllI - 3.0f;
            final boolean lllllllllllllIIlIIlIIllIlllIllII = lllllllllllllIIlIIlIIllIllllIIIl.isToggled();
            if (lllllllllllllIIlIIlIIllIlllIllII) {
                lllllllllllllIIlIIlIIllIllllIIII.interpolate(lllllllllllllIIlIIlIIllIlllIllIl, (float)lllllllllllllIIlIIlIIllIllllIllI, 7.0);
            }
            else {
                lllllllllllllIIlIIlIIllIllllIIII.interpolate((float)(lllllllllllllIIlIIlIIllIlllllIlI + 3), (float)lllllllllllllIIlIIlIIllIllllIllI, 7.0);
            }
            final double lllllllllllllIIlIIlIIllIlllIlIll = lllllllllllllIIlIIlIIllIllllIIII.getX();
            final double lllllllllllllIIlIIlIIllIlllIlIlI = lllllllllllllIIlIIlIIllIllllIIII.getY();
            final boolean lllllllllllllIIlIIlIIllIlllIlIIl = lllllllllllllIIlIIlIIllIlllIlIll > -lllllllllllllIIlIIlIIllIllllIlll;
            final int lllllllllllllIIlIIlIIllIlllIlIII = lllllllllllllIIlIIlIIllIlllllIII.indexOf(lllllllllllllIIlIIlIIllIllllIIIl) + 1;
            Module lllllllllllllIIlIIlIIllIlllIIlll = null;
            final int lllllllllllllIIlIIlIIllIlllIIllI = this.colorMode(lllllllllllllIIlIIlIIllIllllIlII);
            if (lllllllllllllIIlIIlIIllIlllllIII.size() > lllllllllllllIIlIIlIIllIlllIlIII) {
                lllllllllllllIIlIIlIIllIlllIIlll = this.getNextEnabledModule(lllllllllllllIIlIIlIIllIlllllIII, lllllllllllllIIlIIlIIllIlllIlIII);
            }
            if (this.background.getValBoolean()) {
                RenderUtils.drawRect(lllllllllllllIIlIIlIIllIlllIlIll - 2.0, lllllllllllllIIlIIlIIllIlllIlIlI - 1.0, lllllllllllllIIlIIlIIllIlllllIlI, lllllllllllllIIlIIlIIllIlllIlIlI + lllllllllllllIIlIIlIIllIllllIlll - 1.0, ColorUtils.getColor(0, (int)this.opacity.getValDouble()));
            }
            if (this.outline.getValBoolean()) {
                RenderUtils.drawRect(lllllllllllllIIlIIlIIllIlllIlIll - 2.6, lllllllllllllIIlIIlIIllIlllIlIlI - 1.0, lllllllllllllIIlIIlIIllIlllIlIll - 2.0, lllllllllllllIIlIIlIIllIlllIlIlI + lllllllllllllIIlIIlIIllIllllIlll - 1.0, lllllllllllllIIlIIlIIllIlllIIllI);
                final double lllllllllllllIIlIIlIIllIlllIIlIl = lllllllllllllIIlIIlIIllIllllIlll;
                if (lllllllllllllIIlIIlIIllIlllIIlll != null) {
                    final double lllllllllllllIIlIIlIIllIlllIIlII = lllllllllllllIIlIIlIIllIlllIlllI - ModuleList.font.getStringWidth(lllllllllllllIIlIIlIIllIlllIIlll.getModuleName());
                    RenderUtils.drawRect(lllllllllllllIIlIIlIIllIlllIlIll - 2.6, lllllllllllllIIlIIlIIllIlllIlIlI + lllllllllllllIIlIIlIIllIlllIIlIl - 1.0, lllllllllllllIIlIIlIIllIlllIlIll - 2.6 + lllllllllllllIIlIIlIIllIlllIIlII, lllllllllllllIIlIIlIIllIlllIlIlI + lllllllllllllIIlIIlIIllIlllIIlIl - 0.5, lllllllllllllIIlIIlIIllIlllIIllI);
                }
                else {
                    RenderUtils.drawRect(lllllllllllllIIlIIlIIllIlllIlIll - 2.6, lllllllllllllIIlIIlIIllIlllIlIlI + lllllllllllllIIlIIlIIllIlllIIlIl - 1.0, lllllllllllllIIlIIlIIllIlllllIlI, lllllllllllllIIlIIlIIllIlllIlIlI + lllllllllllllIIlIIlIIllIlllIIlIl - 0.6, lllllllllllllIIlIIlIIllIlllIIllI);
                }
            }
            ModuleList.font.drawStringWithShadow(lllllllllllllIIlIIlIIllIlllIllll, (int)lllllllllllllIIlIIlIIllIlllIlIll, (int)lllllllllllllIIlIIlIIllIlllIlIlI - 2, lllllllllllllIIlIIlIIllIlllIIllI);
            if (lllllllllllllIIlIIlIIllIllllIIIl.isToggled()) {
                lllllllllllllIIlIIlIIllIllllIllI += lllllllllllllIIlIIlIIllIllllIlll;
                final int[] array = lllllllllllllIIlIIlIIllIllllIlII;
                final int n = 0;
                array[n] -= (int)1.0f;
            }
        }
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @EventTarget
    public void onRender2D(final EventRender2D lllllllllllllIIlIIlIIlllIIIllIll) {
        if (!ModuleList.mc.gameSettings.showDebugInfo) {
            final String lllllllllllllIIlIIlIIlllIIlIIIlI = this.modeType1.getValString();
            if (lllllllllllllIIlIIlIIlllIIlIIIlI.equalsIgnoreCase("Comfort")) {
                ModuleList.font = FontLoader.INSTANCE.comfortaa_bold_19;
            }
            if (lllllllllllllIIlIIlIIlllIIlIIIlI.equalsIgnoreCase("Arial")) {
                ModuleList.font = FontLoader.INSTANCE.hind_19;
            }
            final String lllllllllllllIIlIIlIIlllIIlIIIIl = String.valueOf(new StringBuilder().append(TextFormatting.WHITE).append("NoRules").append(TextFormatting.GREEN).append(" Free").append(TextFormatting.GRAY).append(" | ").append(TextFormatting.RESET).append(TextFormatting.WHITE).append(ModuleList.mc.player.getName()).append(TextFormatting.GRAY).append(" | ").append(TextFormatting.RESET).append(TextFormatting.WHITE).append(ModuleList.mc.isSingleplayer() ? 0 : Managers.instance.serverManager.getPing()).append(" mc").append(TextFormatting.GRAY).append(" | ").append(TextFormatting.RESET).append(TextFormatting.WHITE).append("FPS: ").append(Minecraft.getDebugFPS()));
            final int lllllllllllllIIlIIlIIlllIIlIIIII = 9;
            final int lllllllllllllIIlIIlIIlllIIIlllll = 12;
            final int lllllllllllllIIlIIlIIlllIIIllllI = 4 + ModuleList.font.getStringWidth(lllllllllllllIIlIIlIIlllIIlIIIIl);
            final int lllllllllllllIIlIIlIIlllIIIlllIl = 4 + ModuleList.font.getStringHeight(lllllllllllllIIlIIlIIlllIIlIIIIl);
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII + 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll + 3), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl - 3), new Color(33, 33, 42).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII + 3), (float)lllllllllllllIIlIIlIIlllIIIlllll, (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(33, 33, 42).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII + 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll + 2), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl - 2), new Color(45, 45, 55).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII + 2), (float)lllllllllllllIIlIIlIIlllIIIlllll, (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(45, 45, 55).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII + 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll + 1), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl - 1), new Color(60, 60, 70).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII + 1), (float)lllllllllllllIIlIIlIIlllIIIlllll, (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(60, 60, 70).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll - 8), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl - 3), new Color(33, 33, 42).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 3), (float)lllllllllllllIIlIIlIIlllIIIlllll, (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(33, 33, 42).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll - 7), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl - 2), new Color(45, 45, 55).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 2), (float)lllllllllllllIIlIIlIIlllIIIlllll, (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(45, 45, 55).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll - 6), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl - 1), new Color(60, 60, 70).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 1), (float)lllllllllllllIIlIIlIIlllIIIlllll, (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(60, 60, 70).getRGB());
            RenderUtils.drawSmoothRect((float)lllllllllllllIIlIIlIIlllIIlIIIII, (float)(lllllllllllllIIlIIlIIlllIIIlllll - 5), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), RenderUtils.rainbow(100, 10.0));
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll - 1), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 3), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl + 3), new Color(33, 33, 42).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll - 2), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 2), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl + 2), new Color(45, 45, 55).getRGB());
            RenderUtils.drawSmoothRect((float)(lllllllllllllIIlIIlIIlllIIlIIIII - 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll - 3), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI + 1), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl + 1), new Color(60, 60, 70).getRGB());
            RenderUtils.drawSmoothRect((float)lllllllllllllIIlIIlIIlllIIlIIIII, (float)(lllllllllllllIIlIIlIIlllIIIlllll - 4), (float)(lllllllllllllIIlIIlIIlllIIlIIIII + lllllllllllllIIlIIlIIlllIIIllllI), (float)(lllllllllllllIIlIIlIIlllIIIlllll + lllllllllllllIIlIIlIIlllIIIlllIl), new Color(34, 34, 40).getRGB());
            ModuleList.font.drawStringWithShadow(lllllllllllllIIlIIlIIlllIIlIIIIl, lllllllllllllIIlIIlIIlllIIlIIIII + 2, lllllllllllllIIlIIlIIlllIIIlllll + 2, RenderUtils.rainbow(100, 10.0));
            this.GayHud(lllllllllllllIIlIIlIIlllIIIllIll.getResolution());
        }
    }
    
    public static Color TwoColoreffect(final Color lllllllllllllIIlIIlIIllIIlllIlII, final Color lllllllllllllIIlIIlIIllIIllllIII, double lllllllllllllIIlIIlIIllIIlllIIlI) {
        if (lllllllllllllIIlIIlIIllIIlllIIlI > 1.0) {
            final double lllllllllllllIIlIIlIIllIIlllIllI = lllllllllllllIIlIIlIIllIIlllIIlI % 1.0;
            lllllllllllllIIlIIlIIllIIlllIIlI = (((int)lllllllllllllIIlIIlIIllIIlllIIlI % 2 == 0) ? lllllllllllllIIlIIlIIllIIlllIllI : (1.0 - lllllllllllllIIlIIlIIllIIlllIllI));
        }
        final double lllllllllllllIIlIIlIIllIIlllIlIl = 1.0 - lllllllllllllIIlIIlIIllIIlllIIlI;
        return new Color((int)(lllllllllllllIIlIIlIIllIIlllIlII.getRed() * lllllllllllllIIlIIlIIllIIlllIlIl + lllllllllllllIIlIIlIIllIIllllIII.getRed() * lllllllllllllIIlIIlIIllIIlllIIlI), (int)(lllllllllllllIIlIIlIIllIIlllIlII.getGreen() * lllllllllllllIIlIIlIIllIIlllIlIl + lllllllllllllIIlIIlIIllIIllllIII.getGreen() * lllllllllllllIIlIIlIIllIIlllIIlI), (int)(lllllllllllllIIlIIlIIllIIlllIlII.getBlue() * lllllllllllllIIlIIlIIllIIlllIlIl + lllllllllllllIIlIIlIIllIIllllIII.getBlue() * lllllllllllllIIlIIlIIllIIlllIIlI), (int)(lllllllllllllIIlIIlIIllIIlllIlII.getAlpha() * lllllllllllllIIlIIlIIllIIlllIlIl + lllllllllllllIIlIIlIIllIIllllIII.getAlpha() * lllllllllllllIIlIIlIIllIIlllIIlI));
    }
    
    @EventTarget
    public void onUrMom(final EventUpdate lllllllllllllIIlIIlIIllIlIIlllII) {
        if (!Double.isNaN(this.lastPosX) && !Double.isNaN(this.lastPosZ)) {
            final double lllllllllllllIIlIIlIIllIlIIllIll = Math.abs(this.lastPosX - ModuleList.mc.player.posX);
            final double lllllllllllllIIlIIlIIllIlIIllIlI = Math.abs(this.lastPosZ - ModuleList.mc.player.posZ);
            final double lllllllllllllIIlIIlIIllIlIIllIIl = Math.sqrt(lllllllllllllIIlIIlIIllIlIIllIll * lllllllllllllIIlIIlIIllIlIIllIll + lllllllllllllIIlIIlIIllIlIIllIlI * lllllllllllllIIlIIlIIllIlIIllIlI) * 2.0;
            this.distances.add(lllllllllllllIIlIIlIIllIlIIllIIl);
            if (this.distances.size() > 20) {
                this.distances.remove(0);
            }
        }
        this.lastPosX = ModuleList.mc.player.posX;
        this.lastPosZ = ModuleList.mc.player.posZ;
    }
    
    public ModuleList() {
        super("HUD", 0, Category.RENDER);
        this.lastPosX = Double.NaN;
        this.lastPosZ = Double.NaN;
        this.distances = new ArrayList<Double>();
        this.xd = 0.0f;
        this.ld = 0.0f;
        this.watermark = new ResourceLocation("watermark.png");
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Background", this, true);
        this.background = setting;
        settingsManager.Property(setting);
        final SM settingsManager2 = Main.settingsManager;
        final Setting setting2 = new Setting("Outline", this, false);
        this.outline = setting2;
        settingsManager2.Property(setting2);
        final SM settingsManager3 = Main.settingsManager;
        final Setting setting3 = new Setting("Info", this, true);
        this.info = setting3;
        settingsManager3.Property(setting3);
        final SM settingsManager4 = Main.settingsManager;
        final Setting setting4 = new Setting("Opacity", this, 120.0, 1.0, 255.0, true);
        this.opacity = setting4;
        settingsManager4.Property(setting4);
        final SM settingsManager5 = Main.settingsManager;
        final Setting setting5 = new Setting("Offset", this, 10.0, 6.0, 20.0, true);
        this.offset = setting5;
        settingsManager5.Property(setting5);
        final ArrayList<String> lllllllllllllIIlIIlIIlllIIllIIIl = new ArrayList<String>();
        lllllllllllllIIlIIlIIlllIIllIIIl.add("Pulsive");
        lllllllllllllIIlIIlIIlllIIllIIIl.add("Rainbow");
        final ArrayList<String> lllllllllllllIIlIIlIIlllIIllIIII = new ArrayList<String>();
        lllllllllllllIIlIIlIIlllIIllIIII.add("Comfort");
        lllllllllllllIIlIIlIIlllIIllIIII.add("Arial");
        final SM settingsManager6 = Main.settingsManager;
        final Setting setting6 = new Setting("ColorMode", this, "Rainbow", lllllllllllllIIlIIlIIlllIIllIIIl);
        this.modeType = setting6;
        settingsManager6.Property(setting6);
        final SM settingsManager7 = Main.settingsManager;
        final Setting setting7 = new Setting("FontMode", this, "Arial", lllllllllllllIIlIIlIIlllIIllIIII);
        this.modeType1 = setting7;
        settingsManager7.Property(setting7);
    }
    
    private ArrayList<Module> getSortedModules(final MinecraftFontRenderer lllllllllllllIIlIIlIIllIlIIIIIIl) {
        final ArrayList<Module> lllllllllllllIIlIIlIIllIlIIIIIII = new ArrayList<Module>(ModuleManager.getModules());
        lllllllllllllIIlIIlIIllIlIIIIIII.sort(Comparator.comparingDouble(lllllllllllllIIlIIlIIllIIllIlIII -> -lllllllllllllIIlIIlIIllIlIIIIIIl.getStringWidth(lllllllllllllIIlIIlIIllIIllIlIII.getModuleName())));
        return lllllllllllllIIlIIlIIllIlIIIIIII;
    }
    
    private Module getNextEnabledModule(final ArrayList<Module> lllllllllllllIIlIIlIIllIlIIIlllI, final int lllllllllllllIIlIIlIIllIlIIIlIII) {
        for (int lllllllllllllIIlIIlIIllIlIIIllII = lllllllllllllIIlIIlIIllIlIIIlIII, lllllllllllllIIlIIlIIllIlIIIlIll = lllllllllllllIIlIIlIIllIlIIIlllI.size(); lllllllllllllIIlIIlIIllIlIIIllII < lllllllllllllIIlIIlIIllIlIIIlIll; ++lllllllllllllIIlIIlIIllIlIIIllII) {
            final Module lllllllllllllIIlIIlIIllIlIIIlIlI = lllllllllllllIIlIIlIIllIlIIIlllI.get(lllllllllllllIIlIIlIIllIlIIIllII);
            if (lllllllllllllIIlIIlIIllIlIIIlIlI.isToggled()) {
                return lllllllllllllIIlIIlIIllIlIIIlIlI;
            }
        }
        return null;
    }
    
    public Color getGradientOffset(final Color lllllllllllllIIlIIlIIllIlIlIlIII, final Color lllllllllllllIIlIIlIIllIlIlIIlll, double lllllllllllllIIlIIlIIllIlIlIIllI) {
        if (lllllllllllllIIlIIlIIllIlIlIIllI > 1.0) {
            final double lllllllllllllIIlIIlIIllIlIlIlllI = (double)(lllllllllllllIIlIIlIIllIlIlIIllI % 1.0);
            final int lllllllllllllIIlIIlIIllIlIlIllIl = (int)lllllllllllllIIlIIlIIllIlIlIIllI;
            lllllllllllllIIlIIlIIllIlIlIIllI = ((lllllllllllllIIlIIlIIllIlIlIllIl % 2 == 0) ? lllllllllllllIIlIIlIIllIlIlIlllI : (1.0 - lllllllllllllIIlIIlIIllIlIlIlllI));
        }
        final double lllllllllllllIIlIIlIIllIlIlIllII = (double)(1.0 - lllllllllllllIIlIIlIIllIlIlIIllI);
        final int lllllllllllllIIlIIlIIllIlIlIlIll = (int)(lllllllllllllIIlIIlIIllIlIlIlIII.getRed() * lllllllllllllIIlIIlIIllIlIlIllII + (double)lllllllllllllIIlIIlIIllIlIlIIlll.getRed() * lllllllllllllIIlIIlIIllIlIlIIllI);
        final int lllllllllllllIIlIIlIIllIlIlIlIlI = (int)(lllllllllllllIIlIIlIIllIlIlIlIII.getGreen() * lllllllllllllIIlIIlIIllIlIlIllII + (double)lllllllllllllIIlIIlIIllIlIlIIlll.getGreen() * lllllllllllllIIlIIlIIllIlIlIIllI);
        final int lllllllllllllIIlIIlIIllIlIlIlIIl = (int)(lllllllllllllIIlIIlIIllIlIlIlIII.getBlue() * lllllllllllllIIlIIlIIllIlIlIllII + (double)lllllllllllllIIlIIlIIllIlIlIIlll.getBlue() * lllllllllllllIIlIIlIIllIlIlIIllI);
        return new Color(lllllllllllllIIlIIlIIllIlIlIlIll, lllllllllllllIIlIIlIIllIlIlIlIlI, lllllllllllllIIlIIlIIllIlIlIlIIl);
    }
    
    static {
        ModuleList.font1 = FontLoader.INSTANCE.consola_19;
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    private int colorMode(final int[] lllllllllllllIIlIIlIIllIlIlllllI) {
        int lllllllllllllIIlIIlIIllIllIIIIll = -1;
        final String lllllllllllllIIlIIlIIllIllIIIIlI = this.modeType.getValString();
        final int lllllllllllllIIlIIlIIllIllIIIIIl = TwoColoreffect(new Color(255, 50, 50), new Color(79, 9, 9), Math.abs(System.currentTimeMillis() / 10L) / 100.0 + 6.0 * (lllllllllllllIIlIIlIIllIlIlllllI[0] * 2.55) / 60.0).getRGB();
        final int lllllllllllllIIlIIlIIllIllIIIIII = RenderUtils.rainbow(lllllllllllllIIlIIlIIllIlIlllllI[0] * 400, 20.0);
        if (lllllllllllllIIlIIlIIllIllIIIIlI.equalsIgnoreCase("Pulsive")) {
            lllllllllllllIIlIIlIIllIllIIIIll = lllllllllllllIIlIIlIIllIllIIIIIl;
        }
        if (lllllllllllllIIlIIlIIllIllIIIIlI.equalsIgnoreCase("Rainbow")) {
            lllllllllllllIIlIIlIIllIllIIIIll = lllllllllllllIIlIIlIIllIllIIIIII;
        }
        return lllllllllllllIIlIIlIIllIllIIIIll;
    }
    
    public enum WaterMarkMode
    {
        CSGO("CSGO", 1), 
        Simple("Simple", 0);
        
        private WaterMarkMode(final String lllllllllllllIlIIIllIIIIIllIIlIl, final int lllllllllllllIlIIIllIIIIIllIIIll) {
        }
    }
}
