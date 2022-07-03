package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.world.gen.*;
import com.google.common.base.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.init.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.primitives.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class GuiCustomizeWorldScreen extends GuiScreen implements GuiSlider.FormatHelper, GuiPageButtonList.GuiResponder
{
    private /* synthetic */ boolean settingsModified;
    private /* synthetic */ GuiButton done;
    private final /* synthetic */ Random random;
    private /* synthetic */ ChunkGeneratorSettings.Factory settings;
    private /* synthetic */ GuiButton confirm;
    protected /* synthetic */ String pageTitle;
    private /* synthetic */ boolean confirmDismissed;
    protected /* synthetic */ String title;
    private /* synthetic */ GuiButton nextPage;
    private /* synthetic */ int confirmMode;
    private final /* synthetic */ GuiCreateWorld parent;
    protected /* synthetic */ String[] pageNames;
    private /* synthetic */ GuiPageButtonList list;
    private final /* synthetic */ ChunkGeneratorSettings.Factory defaultSettings;
    private /* synthetic */ GuiButton defaults;
    private final /* synthetic */ Predicate<String> numberFilter;
    protected /* synthetic */ String subtitle;
    private /* synthetic */ GuiButton randomize;
    private /* synthetic */ GuiButton cancel;
    private /* synthetic */ GuiButton previousPage;
    private /* synthetic */ GuiButton presets;
    
    @Override
    protected void keyTyped(final char llllllllllllllIllllIIlIIIlIllIIl, final int llllllllllllllIllllIIlIIIlIlIlIl) throws IOException {
        super.keyTyped(llllllllllllllIllllIIlIIIlIllIIl, llllllllllllllIllllIIlIIIlIlIlIl);
        if (this.confirmMode == 0) {
            switch (llllllllllllllIllllIIlIIIlIlIlIl) {
                case 200: {
                    this.modifyFocusValue(1.0f);
                    break;
                }
                case 208: {
                    this.modifyFocusValue(-1.0f);
                    break;
                }
                default: {
                    this.list.onKeyPressed(llllllllllllllIllllIIlIIIlIllIIl, llllllllllllllIllllIIlIIIlIlIlIl);
                    break;
                }
            }
        }
    }
    
    private String getFormattedValue(final int llllllllllllllIllllIIlIIlIlIlIII, final float llllllllllllllIllllIIlIIlIlIIIll) {
        switch (llllllllllllllIllllIIlIIlIlIlIII) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 107:
            case 108:
            case 110:
            case 111:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 139:
            case 140:
            case 142:
            case 143: {
                return String.format("%5.3f", llllllllllllllIllllIIlIIlIlIIIll);
            }
            case 105:
            case 106:
            case 109:
            case 112:
            case 113:
            case 114:
            case 115:
            case 137:
            case 138:
            case 141:
            case 144:
            case 145:
            case 146:
            case 147: {
                return String.format("%2.3f", llllllllllllllIllllIIlIIlIlIIIll);
            }
            default: {
                return String.format("%d", (int)llllllllllllllIllllIIlIIlIlIIIll);
            }
            case 162: {
                if (llllllllllllllIllllIIlIIlIlIIIll < 0.0f) {
                    return I18n.format("gui.all", new Object[0]);
                }
                if ((int)llllllllllllllIllllIIlIIlIlIIIll >= Biome.getIdForBiome(Biomes.HELL)) {
                    final Biome llllllllllllllIllllIIlIIlIlIIllI = Biome.getBiomeForId((int)llllllllllllllIllllIIlIIlIlIIIll + 2);
                    return (llllllllllllllIllllIIlIIlIlIIllI != null) ? llllllllllllllIllllIIlIIlIlIIllI.getBiomeName() : "?";
                }
                final Biome llllllllllllllIllllIIlIIlIlIIlIl = Biome.getBiomeForId((int)llllllllllllllIllllIIlIIlIlIIIll);
                return (llllllllllllllIllllIIlIIlIlIIlIl != null) ? llllllllllllllIllllIIlIIlIlIIlIl.getBiomeName() : "?";
            }
        }
    }
    
    private void updatePageControls() {
        this.previousPage.enabled = (this.list.getPage() != 0);
        this.nextPage.enabled = (this.list.getPage() != this.list.getPageCount() - 1);
        this.subtitle = I18n.format("book.pageIndicator", this.list.getPage() + 1, this.list.getPageCount());
        this.pageTitle = this.pageNames[this.list.getPage()];
        this.randomize.enabled = (this.list.getPage() != this.list.getPageCount() - 1);
    }
    
    @Override
    public void setEntryValue(final int llllllllllllllIllllIIlIIllIIIIlI, final String llllllllllllllIllllIIlIIllIIIllI) {
        float llllllllllllllIllllIIlIIllIIIlIl = 0.0f;
        try {
            llllllllllllllIllllIIlIIllIIIlIl = Float.parseFloat(llllllllllllllIllllIIlIIllIIIllI);
        }
        catch (NumberFormatException ex) {}
        float llllllllllllllIllllIIlIIllIIIlII = 0.0f;
        switch (llllllllllllllIllllIIlIIllIIIIlI) {
            case 132: {
                this.settings.mainNoiseScaleX = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 5000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.mainNoiseScaleX;
                break;
            }
            case 133: {
                this.settings.mainNoiseScaleY = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 5000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.mainNoiseScaleY;
                break;
            }
            case 134: {
                this.settings.mainNoiseScaleZ = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 5000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.mainNoiseScaleZ;
                break;
            }
            case 135: {
                this.settings.depthNoiseScaleX = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 2000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.depthNoiseScaleX;
                break;
            }
            case 136: {
                this.settings.depthNoiseScaleZ = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 2000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.depthNoiseScaleZ;
                break;
            }
            case 137: {
                this.settings.depthNoiseScaleExponent = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 0.01f, 20.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.depthNoiseScaleExponent;
                break;
            }
            case 138: {
                this.settings.baseSize = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 25.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.baseSize;
                break;
            }
            case 139: {
                this.settings.coordinateScale = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 6000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.coordinateScale;
                break;
            }
            case 140: {
                this.settings.heightScale = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 6000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.heightScale;
                break;
            }
            case 141: {
                this.settings.stretchY = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 0.01f, 50.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.stretchY;
                break;
            }
            case 142: {
                this.settings.upperLimitScale = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 5000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.upperLimitScale;
                break;
            }
            case 143: {
                this.settings.lowerLimitScale = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 5000.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.lowerLimitScale;
                break;
            }
            case 144: {
                this.settings.biomeDepthWeight = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 20.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.biomeDepthWeight;
                break;
            }
            case 145: {
                this.settings.biomeDepthOffset = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 0.0f, 20.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.biomeDepthOffset;
                break;
            }
            case 146: {
                this.settings.biomeScaleWeight = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 1.0f, 20.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.biomeScaleWeight;
                break;
            }
            case 147: {
                this.settings.biomeScaleOffset = MathHelper.clamp(llllllllllllllIllllIIlIIllIIIlIl, 0.0f, 20.0f);
                llllllllllllllIllllIIlIIllIIIlII = this.settings.biomeScaleOffset;
                break;
            }
        }
        if (llllllllllllllIllllIIlIIllIIIlII != llllllllllllllIllllIIlIIllIIIlIl && llllllllllllllIllllIIlIIllIIIlIl != 0.0f) {
            ((GuiTextField)this.list.getComponent(llllllllllllllIllllIIlIIllIIIIlI)).setText(this.getFormattedValue(llllllllllllllIllllIIlIIllIIIIlI, llllllllllllllIllllIIlIIllIIIlII));
        }
        ((GuiSlider)this.list.getComponent(llllllllllllllIllllIIlIIllIIIIlI - 132 + 100)).setSliderValue(llllllllllllllIllllIIlIIllIIIlII, false);
        if (!this.settings.equals(this.defaultSettings)) {
            this.setSettingsModified(true);
        }
    }
    
    private void setConfirmationControls(final boolean llllllllllllllIllllIIlIIIllIIIll) {
        this.confirm.visible = llllllllllllllIllllIIlIIIllIIIll;
        this.cancel.visible = llllllllllllllIllllIIlIIIllIIIll;
        this.randomize.enabled = !llllllllllllllIllllIIlIIIllIIIll;
        this.done.enabled = !llllllllllllllIllllIIlIIIllIIIll;
        this.previousPage.enabled = !llllllllllllllIllllIIlIIIllIIIll;
        this.nextPage.enabled = !llllllllllllllIllllIIlIIIllIIIll;
        this.defaults.enabled = (this.settingsModified && !llllllllllllllIllllIIlIIIllIIIll);
        this.presets.enabled = !llllllllllllllIllllIIlIIIllIIIll;
        this.list.setActive(!llllllllllllllIllllIIlIIIllIIIll);
    }
    
    @Override
    public String getText(final int llllllllllllllIllllIIlIIlIlIllll, final String llllllllllllllIllllIIlIIlIlIlllI, final float llllllllllllllIllllIIlIIlIllIIIl) {
        return String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllllIIlIIlIlIlllI)).append(": ").append(this.getFormattedValue(llllllllllllllIllllIIlIIlIlIllll, llllllllllllllIllllIIlIIlIllIIIl)));
    }
    
    @Override
    public void setEntryValue(final int llllllllllllllIllllIIlIIlIIIllll, final float llllllllllllllIllllIIlIIlIIIlllI) {
        switch (llllllllllllllIllllIIlIIlIIIllll) {
            case 100: {
                this.settings.mainNoiseScaleX = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 101: {
                this.settings.mainNoiseScaleY = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 102: {
                this.settings.mainNoiseScaleZ = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 103: {
                this.settings.depthNoiseScaleX = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 104: {
                this.settings.depthNoiseScaleZ = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 105: {
                this.settings.depthNoiseScaleExponent = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 106: {
                this.settings.baseSize = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 107: {
                this.settings.coordinateScale = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 108: {
                this.settings.heightScale = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 109: {
                this.settings.stretchY = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 110: {
                this.settings.upperLimitScale = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 111: {
                this.settings.lowerLimitScale = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 112: {
                this.settings.biomeDepthWeight = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 113: {
                this.settings.biomeDepthOffset = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 114: {
                this.settings.biomeScaleWeight = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 115: {
                this.settings.biomeScaleOffset = llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 157: {
                this.settings.dungeonChance = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 158: {
                this.settings.waterLakeChance = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 159: {
                this.settings.lavaLakeChance = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 160: {
                this.settings.seaLevel = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 162: {
                this.settings.fixedBiome = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 163: {
                this.settings.biomeSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 164: {
                this.settings.riverSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 165: {
                this.settings.dirtSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 166: {
                this.settings.dirtCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 167: {
                this.settings.dirtMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 168: {
                this.settings.dirtMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 169: {
                this.settings.gravelSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 170: {
                this.settings.gravelCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 171: {
                this.settings.gravelMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 172: {
                this.settings.gravelMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 173: {
                this.settings.graniteSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 174: {
                this.settings.graniteCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 175: {
                this.settings.graniteMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 176: {
                this.settings.graniteMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 177: {
                this.settings.dioriteSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 178: {
                this.settings.dioriteCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 179: {
                this.settings.dioriteMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 180: {
                this.settings.dioriteMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 181: {
                this.settings.andesiteSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 182: {
                this.settings.andesiteCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 183: {
                this.settings.andesiteMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 184: {
                this.settings.andesiteMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 185: {
                this.settings.coalSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 186: {
                this.settings.coalCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 187: {
                this.settings.coalMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 189: {
                this.settings.coalMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 190: {
                this.settings.ironSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 191: {
                this.settings.ironCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 192: {
                this.settings.ironMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 193: {
                this.settings.ironMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 194: {
                this.settings.goldSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 195: {
                this.settings.goldCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 196: {
                this.settings.goldMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 197: {
                this.settings.goldMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 198: {
                this.settings.redstoneSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 199: {
                this.settings.redstoneCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 200: {
                this.settings.redstoneMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 201: {
                this.settings.redstoneMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 202: {
                this.settings.diamondSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 203: {
                this.settings.diamondCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 204: {
                this.settings.diamondMinHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 205: {
                this.settings.diamondMaxHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 206: {
                this.settings.lapisSize = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 207: {
                this.settings.lapisCount = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 208: {
                this.settings.lapisCenterHeight = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
            case 209: {
                this.settings.lapisSpread = (int)llllllllllllllIllllIIlIIlIIIlllI;
                break;
            }
        }
        if (llllllllllllllIllllIIlIIlIIIllll >= 100 && llllllllllllllIllllIIlIIlIIIllll < 116) {
            final Gui llllllllllllllIllllIIlIIlIIlIIIl = this.list.getComponent(llllllllllllllIllllIIlIIlIIIllll - 100 + 132);
            if (llllllllllllllIllllIIlIIlIIlIIIl != null) {
                ((GuiTextField)llllllllllllllIllllIIlIIlIIlIIIl).setText(this.getFormattedValue(llllllllllllllIllllIIlIIlIIIllll, llllllllllllllIllllIIlIIlIIIlllI));
            }
        }
        if (!this.settings.equals(this.defaultSettings)) {
            this.setSettingsModified(true);
        }
    }
    
    public String saveValues() {
        return this.settings.toString().replace("\n", "");
    }
    
    private void exitConfirmation() throws IOException {
        switch (this.confirmMode) {
            case 300: {
                this.actionPerformed((GuiButton)this.list.getComponent(300));
                break;
            }
            case 304: {
                this.restoreDefaults();
                break;
            }
        }
        this.confirmMode = 0;
        this.confirmDismissed = true;
        this.setConfirmationControls(false);
    }
    
    private void restoreDefaults() {
        this.settings.setDefaults();
        this.createPagedList();
        this.setSettingsModified(false);
    }
    
    public void loadValues(final String llllllllllllllIllllIIlIIllIIlllI) {
        if (llllllllllllllIllllIIlIIllIIlllI != null && !llllllllllllllIllllIIlIIllIIlllI.isEmpty()) {
            this.settings = ChunkGeneratorSettings.Factory.jsonToFactory(llllllllllllllIllllIIlIIllIIlllI);
        }
        else {
            this.settings = new ChunkGeneratorSettings.Factory();
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIllllIIlIIlIIIIIll) throws IOException {
        if (llllllllllllllIllllIIlIIlIIIIIll.enabled) {
            switch (llllllllllllllIllllIIlIIlIIIIIll.id) {
                case 300: {
                    this.parent.chunkProviderSettingsJson = this.settings.toString();
                    this.mc.displayGuiScreen(this.parent);
                    break;
                }
                case 301: {
                    for (int llllllllllllllIllllIIlIIlIIIIIlI = 0; llllllllllllllIllllIIlIIlIIIIIlI < this.list.getSize(); ++llllllllllllllIllllIIlIIlIIIIIlI) {
                        final GuiPageButtonList.GuiEntry llllllllllllllIllllIIlIIlIIIIIIl = this.list.getListEntry(llllllllllllllIllllIIlIIlIIIIIlI);
                        final Gui llllllllllllllIllllIIlIIlIIIIIII = llllllllllllllIllllIIlIIlIIIIIIl.getComponent1();
                        if (llllllllllllllIllllIIlIIlIIIIIII instanceof GuiButton) {
                            final GuiButton llllllllllllllIllllIIlIIIlllllll = (GuiButton)llllllllllllllIllllIIlIIlIIIIIII;
                            if (llllllllllllllIllllIIlIIIlllllll instanceof GuiSlider) {
                                final float llllllllllllllIllllIIlIIIllllllI = ((GuiSlider)llllllllllllllIllllIIlIIIlllllll).getSliderPosition() * (0.75f + this.random.nextFloat() * 0.5f) + (this.random.nextFloat() * 0.1f - 0.05f);
                                ((GuiSlider)llllllllllllllIllllIIlIIIlllllll).setSliderPosition(MathHelper.clamp(llllllllllllllIllllIIlIIIllllllI, 0.0f, 1.0f));
                            }
                            else if (llllllllllllllIllllIIlIIIlllllll instanceof GuiListButton) {
                                ((GuiListButton)llllllllllllllIllllIIlIIIlllllll).setValue(this.random.nextBoolean());
                            }
                        }
                        final Gui llllllllllllllIllllIIlIIIlllllIl = llllllllllllllIllllIIlIIlIIIIIIl.getComponent2();
                        if (llllllllllllllIllllIIlIIIlllllIl instanceof GuiButton) {
                            final GuiButton llllllllllllllIllllIIlIIIlllllII = (GuiButton)llllllllllllllIllllIIlIIIlllllIl;
                            if (llllllllllllllIllllIIlIIIlllllII instanceof GuiSlider) {
                                final float llllllllllllllIllllIIlIIIllllIll = ((GuiSlider)llllllllllllllIllllIIlIIIlllllII).getSliderPosition() * (0.75f + this.random.nextFloat() * 0.5f) + (this.random.nextFloat() * 0.1f - 0.05f);
                                ((GuiSlider)llllllllllllllIllllIIlIIIlllllII).setSliderPosition(MathHelper.clamp(llllllllllllllIllllIIlIIIllllIll, 0.0f, 1.0f));
                            }
                            else if (llllllllllllllIllllIIlIIIlllllII instanceof GuiListButton) {
                                ((GuiListButton)llllllllllllllIllllIIlIIIlllllII).setValue(this.random.nextBoolean());
                            }
                        }
                    }
                }
                case 302: {
                    this.list.previousPage();
                    this.updatePageControls();
                    break;
                }
                case 303: {
                    this.list.nextPage();
                    this.updatePageControls();
                    break;
                }
                case 304: {
                    if (this.settingsModified) {
                        this.enterConfirmation(304);
                        break;
                    }
                    break;
                }
                case 305: {
                    this.mc.displayGuiScreen(new GuiScreenCustomizePresets(this));
                    break;
                }
                case 306: {
                    this.exitConfirmation();
                    break;
                }
                case 307: {
                    this.confirmMode = 0;
                    this.exitConfirmation();
                    break;
                }
            }
        }
    }
    
    @Override
    public void initGui() {
        int llllllllllllllIllllIIlIIllllIIII = 0;
        int llllllllllllllIllllIIlIIlllIllll = 0;
        if (this.list != null) {
            llllllllllllllIllllIIlIIllllIIII = this.list.getPage();
            llllllllllllllIllllIIlIIlllIllll = this.list.getAmountScrolled();
        }
        this.title = I18n.format("options.customizeTitle", new Object[0]);
        this.buttonList.clear();
        this.previousPage = this.addButton(new GuiButton(302, 20, 5, 80, 20, I18n.format("createWorld.customize.custom.prev", new Object[0])));
        this.nextPage = this.addButton(new GuiButton(303, this.width - 100, 5, 80, 20, I18n.format("createWorld.customize.custom.next", new Object[0])));
        this.defaults = this.addButton(new GuiButton(304, this.width / 2 - 187, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.defaults", new Object[0])));
        this.randomize = this.addButton(new GuiButton(301, this.width / 2 - 92, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.randomize", new Object[0])));
        this.presets = this.addButton(new GuiButton(305, this.width / 2 + 3, this.height - 27, 90, 20, I18n.format("createWorld.customize.custom.presets", new Object[0])));
        this.done = this.addButton(new GuiButton(300, this.width / 2 + 98, this.height - 27, 90, 20, I18n.format("gui.done", new Object[0])));
        this.defaults.enabled = this.settingsModified;
        this.confirm = new GuiButton(306, this.width / 2 - 55, 160, 50, 20, I18n.format("gui.yes", new Object[0]));
        this.confirm.visible = false;
        this.buttonList.add(this.confirm);
        this.cancel = new GuiButton(307, this.width / 2 + 5, 160, 50, 20, I18n.format("gui.no", new Object[0]));
        this.cancel.visible = false;
        this.buttonList.add(this.cancel);
        if (this.confirmMode != 0) {
            this.confirm.visible = true;
            this.cancel.visible = true;
        }
        this.createPagedList();
        if (llllllllllllllIllllIIlIIllllIIII != 0) {
            this.list.setPage(llllllllllllllIllllIIlIIllllIIII);
            this.list.scrollBy(llllllllllllllIllllIIlIIlllIllll);
            this.updatePageControls();
        }
    }
    
    private void enterConfirmation(final int llllllllllllllIllllIIlIIIllIllII) {
        this.confirmMode = llllllllllllllIllllIIlIIIllIllII;
        this.setConfirmationControls(true);
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIllllIIlIIIIllIIll, final int llllllllllllllIllllIIlIIIIllIllI, final int llllllllllllllIllllIIlIIIIllIlIl) throws IOException {
        super.mouseClicked(llllllllllllllIllllIIlIIIIllIIll, llllllllllllllIllllIIlIIIIllIllI, llllllllllllllIllllIIlIIIIllIlIl);
        if (this.confirmMode == 0 && !this.confirmDismissed) {
            this.list.mouseClicked(llllllllllllllIllllIIlIIIIllIIll, llllllllllllllIllllIIlIIIIllIllI, llllllllllllllIllllIIlIIIIllIlIl);
        }
    }
    
    private void setSettingsModified(final boolean llllllllllllllIllllIIlIIlIlllIll) {
        this.settingsModified = llllllllllllllIllllIIlIIlIlllIll;
        this.defaults.enabled = llllllllllllllIllllIIlIIlIlllIll;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    public GuiCustomizeWorldScreen(final GuiScreen llllllllllllllIllllIIlIIllllIllI, final String llllllllllllllIllllIIlIIlllllIII) {
        this.title = "Customize World Settings";
        this.subtitle = "Page 1 of 3";
        this.pageTitle = "Basic Settings";
        this.pageNames = new String[4];
        this.numberFilter = (Predicate<String>)new Predicate<String>() {
            public boolean apply(@Nullable final String llllllllllllllIllIIIllllllIllIII) {
                final Float llllllllllllllIllIIIllllllIllIIl = Floats.tryParse(llllllllllllllIllIIIllllllIllIII);
                return llllllllllllllIllIIIllllllIllIII.isEmpty() || (llllllllllllllIllIIIllllllIllIIl != null && Floats.isFinite((float)llllllllllllllIllIIIllllllIllIIl) && llllllllllllllIllIIIllllllIllIIl >= 0.0f);
            }
        };
        this.defaultSettings = new ChunkGeneratorSettings.Factory();
        this.random = new Random();
        this.parent = (GuiCreateWorld)llllllllllllllIllllIIlIIllllIllI;
        this.loadValues(llllllllllllllIllllIIlIIlllllIII);
    }
    
    @Override
    protected void mouseReleased(final int llllllllllllllIllllIIlIIIIlIlIll, final int llllllllllllllIllllIIlIIIIlIlIlI, final int llllllllllllllIllllIIlIIIIlIIlIl) {
        super.mouseReleased(llllllllllllllIllllIIlIIIIlIlIll, llllllllllllllIllllIIlIIIIlIlIlI, llllllllllllllIllllIIlIIIIlIIlIl);
        if (this.confirmDismissed) {
            this.confirmDismissed = false;
        }
        else if (this.confirmMode == 0) {
            this.list.mouseReleased(llllllllllllllIllllIIlIIIIlIlIll, llllllllllllllIllllIIlIIIIlIlIlI, llllllllllllllIllllIIlIIIIlIIlIl);
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIllllIIlIIIIIllIlI, final int llllllllllllllIllllIIlIIIIIlIIII, final float llllllllllllllIllllIIlIIIIIIllll) {
        this.drawDefaultBackground();
        this.list.drawScreen(llllllllllllllIllllIIlIIIIIllIlI, llllllllllllllIllllIIlIIIIIlIIII, llllllllllllllIllllIIlIIIIIIllll);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 2, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.subtitle, this.width / 2, 12, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.pageTitle, this.width / 2, 22, 16777215);
        super.drawScreen(llllllllllllllIllllIIlIIIIIllIlI, llllllllllllllIllllIIlIIIIIlIIII, llllllllllllllIllllIIlIIIIIIllll);
        if (this.confirmMode != 0) {
            Gui.drawRect(0.0, 0.0, this.width, this.height, Integer.MIN_VALUE);
            this.drawHorizontalLine(this.width / 2 - 91, this.width / 2 + 90, 99, -2039584);
            this.drawHorizontalLine(this.width / 2 - 91, this.width / 2 + 90, 185, -6250336);
            this.drawVerticalLine(this.width / 2 - 91, 99, 185, -2039584);
            this.drawVerticalLine(this.width / 2 + 90, 99, 185, -6250336);
            final float llllllllllllllIllllIIlIIIIIlIlll = 85.0f;
            final float llllllllllllllIllllIIlIIIIIlIllI = 180.0f;
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator llllllllllllllIllllIIlIIIIIlIlIl = Tessellator.getInstance();
            final BufferBuilder llllllllllllllIllllIIlIIIIIlIlII = llllllllllllllIllllIIlIIIIIlIlIl.getBuffer();
            this.mc.getTextureManager().bindTexture(GuiCustomizeWorldScreen.OPTIONS_BACKGROUND);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final float llllllllllllllIllllIIlIIIIIlIIll = 32.0f;
            llllllllllllllIllllIIlIIIIIlIlII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            llllllllllllllIllllIIlIIIIIlIlII.pos(this.width / 2 - 90, 185.0, 0.0).tex(0.0, 2.65625).color(64, 64, 64, 64).endVertex();
            llllllllllllllIllllIIlIIIIIlIlII.pos(this.width / 2 + 90, 185.0, 0.0).tex(5.625, 2.65625).color(64, 64, 64, 64).endVertex();
            llllllllllllllIllllIIlIIIIIlIlII.pos(this.width / 2 + 90, 100.0, 0.0).tex(5.625, 0.0).color(64, 64, 64, 64).endVertex();
            llllllllllllllIllllIIlIIIIIlIlII.pos(this.width / 2 - 90, 100.0, 0.0).tex(0.0, 0.0).color(64, 64, 64, 64).endVertex();
            llllllllllllllIllllIIlIIIIIlIlIl.draw();
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirmTitle", new Object[0]), this.width / 2, 105, 16777215);
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirm1", new Object[0]), this.width / 2, 125, 16777215);
            this.drawCenteredString(this.fontRendererObj, I18n.format("createWorld.customize.custom.confirm2", new Object[0]), this.width / 2, 135, 16777215);
            this.confirm.func_191745_a(this.mc, llllllllllllllIllllIIlIIIIIllIlI, llllllllllllllIllllIIlIIIIIlIIII);
            this.cancel.func_191745_a(this.mc, llllllllllllllIllllIIlIIIIIllIlI, llllllllllllllIllllIIlIIIIIlIIII);
        }
    }
    
    private void modifyFocusValue(final float llllllllllllllIllllIIlIIIlIIlIll) {
        final Gui llllllllllllllIllllIIlIIIlIIlIlI = this.list.getFocusedControl();
        if (llllllllllllllIllllIIlIIIlIIlIlI instanceof GuiTextField) {
            float llllllllllllllIllllIIlIIIlIIlIIl = llllllllllllllIllllIIlIIIlIIlIll;
            if (GuiScreen.isShiftKeyDown()) {
                llllllllllllllIllllIIlIIIlIIlIIl = llllllllllllllIllllIIlIIIlIIlIll * 0.1f;
                if (GuiScreen.isCtrlKeyDown()) {
                    llllllllllllllIllllIIlIIIlIIlIIl *= 0.1f;
                }
            }
            else if (GuiScreen.isCtrlKeyDown()) {
                llllllllllllllIllllIIlIIIlIIlIIl = llllllllllllllIllllIIlIIIlIIlIll * 10.0f;
                if (GuiScreen.isAltKeyDown()) {
                    llllllllllllllIllllIIlIIIlIIlIIl *= 10.0f;
                }
            }
            final GuiTextField llllllllllllllIllllIIlIIIlIIlIII = (GuiTextField)llllllllllllllIllllIIlIIIlIIlIlI;
            Float llllllllllllllIllllIIlIIIlIIIlll = Floats.tryParse(llllllllllllllIllllIIlIIIlIIlIII.getText());
            if (llllllllllllllIllllIIlIIIlIIIlll != null) {
                llllllllllllllIllllIIlIIIlIIIlll += llllllllllllllIllllIIlIIIlIIlIIl;
                final int llllllllllllllIllllIIlIIIlIIIllI = llllllllllllllIllllIIlIIIlIIlIII.getId();
                final String llllllllllllllIllllIIlIIIlIIIlIl = this.getFormattedValue(llllllllllllllIllllIIlIIIlIIlIII.getId(), llllllllllllllIllllIIlIIIlIIIlll);
                llllllllllllllIllllIIlIIIlIIlIII.setText(llllllllllllllIllllIIlIIIlIIIlIl);
                this.setEntryValue(llllllllllllllIllllIIlIIIlIIIllI, llllllllllllllIllllIIlIIIlIIIlIl);
            }
        }
    }
    
    private void createPagedList() {
        final GuiPageButtonList.GuiListEntry[] llllllllllllllIllllIIlIIlllIIIIl = { new GuiPageButtonList.GuiSlideEntry(160, I18n.format("createWorld.customize.custom.seaLevel", new Object[0]), true, this, 1.0f, 255.0f, (float)this.settings.seaLevel), new GuiPageButtonList.GuiButtonEntry(148, I18n.format("createWorld.customize.custom.useCaves", new Object[0]), true, this.settings.useCaves), new GuiPageButtonList.GuiButtonEntry(150, I18n.format("createWorld.customize.custom.useStrongholds", new Object[0]), true, this.settings.useStrongholds), new GuiPageButtonList.GuiButtonEntry(151, I18n.format("createWorld.customize.custom.useVillages", new Object[0]), true, this.settings.useVillages), new GuiPageButtonList.GuiButtonEntry(152, I18n.format("createWorld.customize.custom.useMineShafts", new Object[0]), true, this.settings.useMineShafts), new GuiPageButtonList.GuiButtonEntry(153, I18n.format("createWorld.customize.custom.useTemples", new Object[0]), true, this.settings.useTemples), new GuiPageButtonList.GuiButtonEntry(210, I18n.format("createWorld.customize.custom.useMonuments", new Object[0]), true, this.settings.useMonuments), new GuiPageButtonList.GuiButtonEntry(211, I18n.format("createWorld.customize.custom.useMansions", new Object[0]), true, this.settings.field_191076_A), new GuiPageButtonList.GuiButtonEntry(154, I18n.format("createWorld.customize.custom.useRavines", new Object[0]), true, this.settings.useRavines), new GuiPageButtonList.GuiButtonEntry(149, I18n.format("createWorld.customize.custom.useDungeons", new Object[0]), true, this.settings.useDungeons), new GuiPageButtonList.GuiSlideEntry(157, I18n.format("createWorld.customize.custom.dungeonChance", new Object[0]), true, this, 1.0f, 100.0f, (float)this.settings.dungeonChance), new GuiPageButtonList.GuiButtonEntry(155, I18n.format("createWorld.customize.custom.useWaterLakes", new Object[0]), true, this.settings.useWaterLakes), new GuiPageButtonList.GuiSlideEntry(158, I18n.format("createWorld.customize.custom.waterLakeChance", new Object[0]), true, this, 1.0f, 100.0f, (float)this.settings.waterLakeChance), new GuiPageButtonList.GuiButtonEntry(156, I18n.format("createWorld.customize.custom.useLavaLakes", new Object[0]), true, this.settings.useLavaLakes), new GuiPageButtonList.GuiSlideEntry(159, I18n.format("createWorld.customize.custom.lavaLakeChance", new Object[0]), true, this, 10.0f, 100.0f, (float)this.settings.lavaLakeChance), new GuiPageButtonList.GuiButtonEntry(161, I18n.format("createWorld.customize.custom.useLavaOceans", new Object[0]), true, this.settings.useLavaOceans), new GuiPageButtonList.GuiSlideEntry(162, I18n.format("createWorld.customize.custom.fixedBiome", new Object[0]), true, this, -1.0f, 37.0f, (float)this.settings.fixedBiome), new GuiPageButtonList.GuiSlideEntry(163, I18n.format("createWorld.customize.custom.biomeSize", new Object[0]), true, this, 1.0f, 8.0f, (float)this.settings.biomeSize), new GuiPageButtonList.GuiSlideEntry(164, I18n.format("createWorld.customize.custom.riverSize", new Object[0]), true, this, 1.0f, 5.0f, (float)this.settings.riverSize) };
        final GuiPageButtonList.GuiListEntry[] llllllllllllllIllllIIlIIlllIIIII = { new GuiPageButtonList.GuiLabelEntry(416, I18n.format("tile.dirt.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(165, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.dirtSize), new GuiPageButtonList.GuiSlideEntry(166, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.dirtCount), new GuiPageButtonList.GuiSlideEntry(167, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dirtMinHeight), new GuiPageButtonList.GuiSlideEntry(168, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dirtMaxHeight), new GuiPageButtonList.GuiLabelEntry(417, I18n.format("tile.gravel.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(169, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.gravelSize), new GuiPageButtonList.GuiSlideEntry(170, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.gravelCount), new GuiPageButtonList.GuiSlideEntry(171, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.gravelMinHeight), new GuiPageButtonList.GuiSlideEntry(172, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.gravelMaxHeight), new GuiPageButtonList.GuiLabelEntry(418, I18n.format("tile.stone.granite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(173, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.graniteSize), new GuiPageButtonList.GuiSlideEntry(174, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.graniteCount), new GuiPageButtonList.GuiSlideEntry(175, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.graniteMinHeight), new GuiPageButtonList.GuiSlideEntry(176, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.graniteMaxHeight), new GuiPageButtonList.GuiLabelEntry(419, I18n.format("tile.stone.diorite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(177, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.dioriteSize), new GuiPageButtonList.GuiSlideEntry(178, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.dioriteCount), new GuiPageButtonList.GuiSlideEntry(179, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dioriteMinHeight), new GuiPageButtonList.GuiSlideEntry(180, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.dioriteMaxHeight), new GuiPageButtonList.GuiLabelEntry(420, I18n.format("tile.stone.andesite.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(181, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.andesiteSize), new GuiPageButtonList.GuiSlideEntry(182, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.andesiteCount), new GuiPageButtonList.GuiSlideEntry(183, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.andesiteMinHeight), new GuiPageButtonList.GuiSlideEntry(184, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.andesiteMaxHeight), new GuiPageButtonList.GuiLabelEntry(421, I18n.format("tile.oreCoal.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(185, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.coalSize), new GuiPageButtonList.GuiSlideEntry(186, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.coalCount), new GuiPageButtonList.GuiSlideEntry(187, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.coalMinHeight), new GuiPageButtonList.GuiSlideEntry(189, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.coalMaxHeight), new GuiPageButtonList.GuiLabelEntry(422, I18n.format("tile.oreIron.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(190, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.ironSize), new GuiPageButtonList.GuiSlideEntry(191, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.ironCount), new GuiPageButtonList.GuiSlideEntry(192, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.ironMinHeight), new GuiPageButtonList.GuiSlideEntry(193, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.ironMaxHeight), new GuiPageButtonList.GuiLabelEntry(423, I18n.format("tile.oreGold.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(194, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.goldSize), new GuiPageButtonList.GuiSlideEntry(195, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.goldCount), new GuiPageButtonList.GuiSlideEntry(196, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.goldMinHeight), new GuiPageButtonList.GuiSlideEntry(197, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.goldMaxHeight), new GuiPageButtonList.GuiLabelEntry(424, I18n.format("tile.oreRedstone.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(198, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.redstoneSize), new GuiPageButtonList.GuiSlideEntry(199, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.redstoneCount), new GuiPageButtonList.GuiSlideEntry(200, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.redstoneMinHeight), new GuiPageButtonList.GuiSlideEntry(201, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.redstoneMaxHeight), new GuiPageButtonList.GuiLabelEntry(425, I18n.format("tile.oreDiamond.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(202, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.diamondSize), new GuiPageButtonList.GuiSlideEntry(203, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.diamondCount), new GuiPageButtonList.GuiSlideEntry(204, I18n.format("createWorld.customize.custom.minHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.diamondMinHeight), new GuiPageButtonList.GuiSlideEntry(205, I18n.format("createWorld.customize.custom.maxHeight", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.diamondMaxHeight), new GuiPageButtonList.GuiLabelEntry(426, I18n.format("tile.oreLapis.name", new Object[0]), false), null, new GuiPageButtonList.GuiSlideEntry(206, I18n.format("createWorld.customize.custom.size", new Object[0]), false, this, 1.0f, 50.0f, (float)this.settings.lapisSize), new GuiPageButtonList.GuiSlideEntry(207, I18n.format("createWorld.customize.custom.count", new Object[0]), false, this, 0.0f, 40.0f, (float)this.settings.lapisCount), new GuiPageButtonList.GuiSlideEntry(208, I18n.format("createWorld.customize.custom.center", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.lapisCenterHeight), new GuiPageButtonList.GuiSlideEntry(209, I18n.format("createWorld.customize.custom.spread", new Object[0]), false, this, 0.0f, 255.0f, (float)this.settings.lapisSpread) };
        final GuiPageButtonList.GuiListEntry[] llllllllllllllIllllIIlIIllIlllll = { new GuiPageButtonList.GuiSlideEntry(100, I18n.format("createWorld.customize.custom.mainNoiseScaleX", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.mainNoiseScaleX), new GuiPageButtonList.GuiSlideEntry(101, I18n.format("createWorld.customize.custom.mainNoiseScaleY", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.mainNoiseScaleY), new GuiPageButtonList.GuiSlideEntry(102, I18n.format("createWorld.customize.custom.mainNoiseScaleZ", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.mainNoiseScaleZ), new GuiPageButtonList.GuiSlideEntry(103, I18n.format("createWorld.customize.custom.depthNoiseScaleX", new Object[0]), false, this, 1.0f, 2000.0f, this.settings.depthNoiseScaleX), new GuiPageButtonList.GuiSlideEntry(104, I18n.format("createWorld.customize.custom.depthNoiseScaleZ", new Object[0]), false, this, 1.0f, 2000.0f, this.settings.depthNoiseScaleZ), new GuiPageButtonList.GuiSlideEntry(105, I18n.format("createWorld.customize.custom.depthNoiseScaleExponent", new Object[0]), false, this, 0.01f, 20.0f, this.settings.depthNoiseScaleExponent), new GuiPageButtonList.GuiSlideEntry(106, I18n.format("createWorld.customize.custom.baseSize", new Object[0]), false, this, 1.0f, 25.0f, this.settings.baseSize), new GuiPageButtonList.GuiSlideEntry(107, I18n.format("createWorld.customize.custom.coordinateScale", new Object[0]), false, this, 1.0f, 6000.0f, this.settings.coordinateScale), new GuiPageButtonList.GuiSlideEntry(108, I18n.format("createWorld.customize.custom.heightScale", new Object[0]), false, this, 1.0f, 6000.0f, this.settings.heightScale), new GuiPageButtonList.GuiSlideEntry(109, I18n.format("createWorld.customize.custom.stretchY", new Object[0]), false, this, 0.01f, 50.0f, this.settings.stretchY), new GuiPageButtonList.GuiSlideEntry(110, I18n.format("createWorld.customize.custom.upperLimitScale", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.upperLimitScale), new GuiPageButtonList.GuiSlideEntry(111, I18n.format("createWorld.customize.custom.lowerLimitScale", new Object[0]), false, this, 1.0f, 5000.0f, this.settings.lowerLimitScale), new GuiPageButtonList.GuiSlideEntry(112, I18n.format("createWorld.customize.custom.biomeDepthWeight", new Object[0]), false, this, 1.0f, 20.0f, this.settings.biomeDepthWeight), new GuiPageButtonList.GuiSlideEntry(113, I18n.format("createWorld.customize.custom.biomeDepthOffset", new Object[0]), false, this, 0.0f, 20.0f, this.settings.biomeDepthOffset), new GuiPageButtonList.GuiSlideEntry(114, I18n.format("createWorld.customize.custom.biomeScaleWeight", new Object[0]), false, this, 1.0f, 20.0f, this.settings.biomeScaleWeight), new GuiPageButtonList.GuiSlideEntry(115, I18n.format("createWorld.customize.custom.biomeScaleOffset", new Object[0]), false, this, 0.0f, 20.0f, this.settings.biomeScaleOffset) };
        final GuiPageButtonList.GuiListEntry[] llllllllllllllIllllIIlIIllIllllI = { new GuiPageButtonList.GuiLabelEntry(400, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleX", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(132, String.format("%5.3f", this.settings.mainNoiseScaleX), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(401, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleY", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(133, String.format("%5.3f", this.settings.mainNoiseScaleY), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(402, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.mainNoiseScaleZ", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(134, String.format("%5.3f", this.settings.mainNoiseScaleZ), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(403, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleX", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(135, String.format("%5.3f", this.settings.depthNoiseScaleX), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(404, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleZ", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(136, String.format("%5.3f", this.settings.depthNoiseScaleZ), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(405, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.depthNoiseScaleExponent", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(137, String.format("%2.3f", this.settings.depthNoiseScaleExponent), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(406, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.baseSize", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(138, String.format("%2.3f", this.settings.baseSize), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(407, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.coordinateScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(139, String.format("%5.3f", this.settings.coordinateScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(408, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.heightScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(140, String.format("%5.3f", this.settings.heightScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(409, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.stretchY", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(141, String.format("%2.3f", this.settings.stretchY), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(410, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.upperLimitScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(142, String.format("%5.3f", this.settings.upperLimitScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(411, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.lowerLimitScale", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(143, String.format("%5.3f", this.settings.lowerLimitScale), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(412, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeDepthWeight", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(144, String.format("%2.3f", this.settings.biomeDepthWeight), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(413, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeDepthOffset", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(145, String.format("%2.3f", this.settings.biomeDepthOffset), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(414, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeScaleWeight", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(146, String.format("%2.3f", this.settings.biomeScaleWeight), false, this.numberFilter), new GuiPageButtonList.GuiLabelEntry(415, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.custom.biomeScaleOffset", new Object[0]))).append(":")), false), new GuiPageButtonList.EditBoxEntry(147, String.format("%2.3f", this.settings.biomeScaleOffset), false, this.numberFilter) };
        this.list = new GuiPageButtonList(this.mc, this.width, this.height, 32, this.height - 32, 25, this, new GuiPageButtonList.GuiListEntry[][] { llllllllllllllIllllIIlIIlllIIIIl, llllllllllllllIllllIIlIIlllIIIII, llllllllllllllIllllIIlIIllIlllll, llllllllllllllIllllIIlIIllIllllI });
        for (int llllllllllllllIllllIIlIIllIlllIl = 0; llllllllllllllIllllIIlIIllIlllIl < 4; ++llllllllllllllIllllIIlIIllIlllIl) {
            this.pageNames[llllllllllllllIllllIIlIIllIlllIl] = I18n.format(String.valueOf(new StringBuilder("createWorld.customize.custom.page").append(llllllllllllllIllllIIlIIllIlllIl)), new Object[0]);
        }
        this.updatePageControls();
    }
    
    @Override
    public void setEntryValue(final int llllllllllllllIllllIIlIIlIIlllIl, final boolean llllllllllllllIllllIIlIIlIIlllII) {
        switch (llllllllllllllIllllIIlIIlIIlllIl) {
            case 148: {
                this.settings.useCaves = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 149: {
                this.settings.useDungeons = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 150: {
                this.settings.useStrongholds = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 151: {
                this.settings.useVillages = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 152: {
                this.settings.useMineShafts = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 153: {
                this.settings.useTemples = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 154: {
                this.settings.useRavines = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 155: {
                this.settings.useWaterLakes = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 156: {
                this.settings.useLavaLakes = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 161: {
                this.settings.useLavaOceans = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 210: {
                this.settings.useMonuments = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
            case 211: {
                this.settings.field_191076_A = llllllllllllllIllllIIlIIlIIlllII;
                break;
            }
        }
        if (!this.settings.equals(this.defaultSettings)) {
            this.setSettingsModified(true);
        }
    }
}
