package shadersmod.client;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.math.*;
import net.minecraft.client.gui.*;
import optifine.*;
import java.util.*;

public class GuiShaderOptions extends GuiScreenOF
{
    private /* synthetic */ GameSettings settings;
    private /* synthetic */ boolean changed;
    private /* synthetic */ long mouseStillTime;
    private /* synthetic */ int lastMouseX;
    protected /* synthetic */ String title;
    private /* synthetic */ GuiScreen prevScreen;
    private /* synthetic */ int lastMouseY;
    private /* synthetic */ String screenName;
    private /* synthetic */ String screenText;
    
    static {
        OPTION_EMPTY = "<empty>";
        OPTION_PROFILE = "<profile>";
        OPTION_REST = "*";
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIIIlIlllIIlIIllII, final int lllllllllllllIIIIIlIlllIIlIIlIll, final float lllllllllllllIIIIIlIlllIIlIIlIlI) {
        this.drawDefaultBackground();
        if (this.screenText != null) {
            this.drawCenteredString(this.fontRendererObj, this.screenText, this.width / 2, 15, 16777215);
        }
        else {
            this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 16777215);
        }
        super.drawScreen(lllllllllllllIIIIIlIlllIIlIIllII, lllllllllllllIIIIIlIlllIIlIIlIll, lllllllllllllIIIIIlIlllIIlIIlIlI);
        if (Math.abs(lllllllllllllIIIIIlIlllIIlIIllII - this.lastMouseX) <= 5 && Math.abs(lllllllllllllIIIIIlIlllIIlIIlIll - this.lastMouseY) <= 5) {
            this.drawTooltips(lllllllllllllIIIIIlIlllIIlIIllII, lllllllllllllIIIIIlIlllIIlIIlIll, this.buttonList);
        }
        else {
            this.lastMouseX = lllllllllllllIIIIIlIlllIIlIIllII;
            this.lastMouseY = lllllllllllllIIIIIlIlllIIlIIlIll;
            this.mouseStillTime = System.currentTimeMillis();
        }
    }
    
    @Override
    public void initGui() {
        this.title = I18n.format("of.options.shaderOptionsTitle", new Object[0]);
        final int lllllllllllllIIIIIlIlllIllIIIlII = 100;
        int lllllllllllllIIIIIlIlllIllIIIIll = 0;
        final int lllllllllllllIIIIIlIlllIllIIIIlI = 30;
        final int lllllllllllllIIIIIlIlllIllIIIIIl = 20;
        final int lllllllllllllIIIIIlIlllIllIIIIII = this.width - 130;
        final int lllllllllllllIIIIIlIlllIlIllllll = 120;
        final int lllllllllllllIIIIIlIlllIlIlllllI = 20;
        int lllllllllllllIIIIIlIlllIlIllllIl = Shaders.getShaderPackColumns(this.screenName, 2);
        final ShaderOption[] lllllllllllllIIIIIlIlllIlIllllII = Shaders.getShaderPackOptions(this.screenName);
        if (lllllllllllllIIIIIlIlllIlIllllII != null) {
            final int lllllllllllllIIIIIlIlllIlIlllIll = MathHelper.ceil(lllllllllllllIIIIIlIlllIlIllllII.length / 9.0);
            if (lllllllllllllIIIIIlIlllIlIllllIl < lllllllllllllIIIIIlIlllIlIlllIll) {
                lllllllllllllIIIIIlIlllIlIllllIl = lllllllllllllIIIIIlIlllIlIlllIll;
            }
            for (int lllllllllllllIIIIIlIlllIlIlllIlI = 0; lllllllllllllIIIIIlIlllIlIlllIlI < lllllllllllllIIIIIlIlllIlIllllII.length; ++lllllllllllllIIIIIlIlllIlIlllIlI) {
                final ShaderOption lllllllllllllIIIIIlIlllIlIlllIIl = lllllllllllllIIIIIlIlllIlIllllII[lllllllllllllIIIIIlIlllIlIlllIlI];
                if (lllllllllllllIIIIIlIlllIlIlllIIl != null && lllllllllllllIIIIIlIlllIlIlllIIl.isVisible()) {
                    final int lllllllllllllIIIIIlIlllIlIlllIII = lllllllllllllIIIIIlIlllIlIlllIlI % lllllllllllllIIIIIlIlllIlIllllIl;
                    final int lllllllllllllIIIIIlIlllIlIllIlll = lllllllllllllIIIIIlIlllIlIlllIlI / lllllllllllllIIIIIlIlllIlIllllIl;
                    final int lllllllllllllIIIIIlIlllIlIllIllI = Math.min(this.width / lllllllllllllIIIIIlIlllIlIllllIl, 200);
                    lllllllllllllIIIIIlIlllIllIIIIll = (this.width - lllllllllllllIIIIIlIlllIlIllIllI * lllllllllllllIIIIIlIlllIlIllllIl) / 2;
                    final int lllllllllllllIIIIIlIlllIlIllIlIl = lllllllllllllIIIIIlIlllIlIlllIII * lllllllllllllIIIIIlIlllIlIllIllI + 5 + lllllllllllllIIIIIlIlllIllIIIIll;
                    final int lllllllllllllIIIIIlIlllIlIllIlII = lllllllllllllIIIIIlIlllIllIIIIlI + lllllllllllllIIIIIlIlllIlIllIlll * lllllllllllllIIIIIlIlllIllIIIIIl;
                    final int lllllllllllllIIIIIlIlllIlIllIIll = lllllllllllllIIIIIlIlllIlIllIllI - 10;
                    final String lllllllllllllIIIIIlIlllIlIllIIlI = getButtonText(lllllllllllllIIIIIlIlllIlIlllIIl, lllllllllllllIIIIIlIlllIlIllIIll);
                    GuiButtonShaderOption lllllllllllllIIIIIlIlllIlIllIIII = null;
                    if (Shaders.isShaderPackOptionSlider(lllllllllllllIIIIIlIlllIlIlllIIl.getName())) {
                        final GuiButtonShaderOption lllllllllllllIIIIIlIlllIlIllIIIl = new GuiSliderShaderOption(lllllllllllllIIIIIlIlllIllIIIlII + lllllllllllllIIIIIlIlllIlIlllIlI, lllllllllllllIIIIIlIlllIlIllIlIl, lllllllllllllIIIIIlIlllIlIllIlII, lllllllllllllIIIIIlIlllIlIllIIll, lllllllllllllIIIIIlIlllIlIlllllI, lllllllllllllIIIIIlIlllIlIlllIIl, lllllllllllllIIIIIlIlllIlIllIIlI);
                    }
                    else {
                        lllllllllllllIIIIIlIlllIlIllIIII = new GuiButtonShaderOption(lllllllllllllIIIIIlIlllIllIIIlII + lllllllllllllIIIIIlIlllIlIlllIlI, lllllllllllllIIIIIlIlllIlIllIlIl, lllllllllllllIIIIIlIlllIlIllIlII, lllllllllllllIIIIIlIlllIlIllIIll, lllllllllllllIIIIIlIlllIlIlllllI, lllllllllllllIIIIIlIlllIlIlllIIl, lllllllllllllIIIIIlIlllIlIllIIlI);
                    }
                    lllllllllllllIIIIIlIlllIlIllIIII.enabled = lllllllllllllIIIIIlIlllIlIlllIIl.isEnabled();
                    this.buttonList.add(lllllllllllllIIIIIlIlllIlIllIIII);
                }
            }
        }
        this.buttonList.add(new GuiButton(201, this.width / 2 - lllllllllllllIIIIIlIlllIlIllllll - 20, this.height / 6 + 168 + 11, lllllllllllllIIIIIlIlllIlIllllll, lllllllllllllIIIIIlIlllIlIlllllI, I18n.format("controls.reset", new Object[0])));
        this.buttonList.add(new GuiButton(200, this.width / 2 + 20, this.height / 6 + 168 + 11, lllllllllllllIIIIIlIlllIlIllllll, lllllllllllllIIIIIlIlllIlIlllllI, I18n.format("gui.done", new Object[0])));
    }
    
    private void updateAllButtons() {
        for (final GuiButton lllllllllllllIIIIIlIlllIIlIllIll : this.buttonList) {
            if (lllllllllllllIIIIIlIlllIIlIllIll instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption lllllllllllllIIIIIlIlllIIlIllIlI = (GuiButtonShaderOption)lllllllllllllIIIIIlIlllIIlIllIll;
                final ShaderOption lllllllllllllIIIIIlIlllIIlIllIIl = lllllllllllllIIIIIlIlllIIlIllIlI.getShaderOption();
                if (lllllllllllllIIIIIlIlllIIlIllIIl instanceof ShaderOptionProfile) {
                    final ShaderOptionProfile lllllllllllllIIIIIlIlllIIlIllIII = (ShaderOptionProfile)lllllllllllllIIIIIlIlllIIlIllIIl;
                    lllllllllllllIIIIIlIlllIIlIllIII.updateProfile();
                }
                lllllllllllllIIIIIlIlllIIlIllIlI.displayString = getButtonText(lllllllllllllIIIIIlIlllIIlIllIIl, lllllllllllllIIIIIlIlllIIlIllIlI.getButtonWidth());
                lllllllllllllIIIIIlIlllIIlIllIlI.valueChanged();
            }
        }
    }
    
    public GuiShaderOptions(final GuiScreen lllllllllllllIIIIIlIlllIlllIIIIl, final GameSettings lllllllllllllIIIIIlIlllIlllIIIII, final String lllllllllllllIIIIIlIlllIllIllIll) {
        this(lllllllllllllIIIIIlIlllIlllIIIIl, lllllllllllllIIIIIlIlllIlllIIIII);
        this.screenName = lllllllllllllIIIIIlIlllIllIllIll;
        if (lllllllllllllIIIIIlIlllIllIllIll != null) {
            this.screenText = Shaders.translate(String.valueOf(new StringBuilder("screen.").append(lllllllllllllIIIIIlIlllIllIllIll)), lllllllllllllIIIIIlIlllIllIllIll);
        }
    }
    
    public GuiShaderOptions(final GuiScreen lllllllllllllIIIIIlIlllIlllIlIII, final GameSettings lllllllllllllIIIIIlIlllIlllIIlll) {
        this.lastMouseX = 0;
        this.lastMouseY = 0;
        this.mouseStillTime = 0L;
        this.screenName = null;
        this.screenText = null;
        this.changed = false;
        this.title = "Shader Options";
        this.prevScreen = lllllllllllllIIIIIlIlllIlllIlIII;
        this.settings = lllllllllllllIIIIIlIlllIlllIIlll;
    }
    
    private void drawTooltips(final int lllllllllllllIIIIIlIlllIIIllIlII, final int lllllllllllllIIIIIlIlllIIIllIIll, final List lllllllllllllIIIIIlIlllIIIlIIIlI) {
        final int lllllllllllllIIIIIlIlllIIIllIIIl = 700;
        if (System.currentTimeMillis() >= this.mouseStillTime + lllllllllllllIIIIIlIlllIIIllIIIl) {
            final int lllllllllllllIIIIIlIlllIIIllIIII = this.width / 2 - 150;
            int lllllllllllllIIIIIlIlllIIIlIllll = this.height / 6 - 7;
            if (lllllllllllllIIIIIlIlllIIIllIIll <= lllllllllllllIIIIIlIlllIIIlIllll + 98) {
                lllllllllllllIIIIIlIlllIIIlIllll += 105;
            }
            final int lllllllllllllIIIIIlIlllIIIlIlllI = lllllllllllllIIIIIlIlllIIIllIIII + 150 + 150;
            final int lllllllllllllIIIIIlIlllIIIlIllIl = lllllllllllllIIIIIlIlllIIIlIllll + 84 + 10;
            final GuiButton lllllllllllllIIIIIlIlllIIIlIllII = GuiScreenOF.getSelectedButton(lllllllllllllIIIIIlIlllIIIlIIIlI, lllllllllllllIIIIIlIlllIIIllIlII, lllllllllllllIIIIIlIlllIIIllIIll);
            if (lllllllllllllIIIIIlIlllIIIlIllII instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption lllllllllllllIIIIIlIlllIIIlIlIll = (GuiButtonShaderOption)lllllllllllllIIIIIlIlllIIIlIllII;
                final ShaderOption lllllllllllllIIIIIlIlllIIIlIlIlI = lllllllllllllIIIIIlIlllIIIlIlIll.getShaderOption();
                final String[] lllllllllllllIIIIIlIlllIIIlIlIIl = this.makeTooltipLines(lllllllllllllIIIIIlIlllIIIlIlIlI, lllllllllllllIIIIIlIlllIIIlIlllI - lllllllllllllIIIIIlIlllIIIllIIII);
                if (lllllllllllllIIIIIlIlllIIIlIlIIl == null) {
                    return;
                }
                this.drawGradientRect(lllllllllllllIIIIIlIlllIIIllIIII, lllllllllllllIIIIIlIlllIIIlIllll, lllllllllllllIIIIIlIlllIIIlIlllI, lllllllllllllIIIIIlIlllIIIlIllIl, -536870912, -536870912);
                for (int lllllllllllllIIIIIlIlllIIIlIlIII = 0; lllllllllllllIIIIIlIlllIIIlIlIII < lllllllllllllIIIIIlIlllIIIlIlIIl.length; ++lllllllllllllIIIIIlIlllIIIlIlIII) {
                    final String lllllllllllllIIIIIlIlllIIIlIIlll = lllllllllllllIIIIIlIlllIIIlIlIIl[lllllllllllllIIIIIlIlllIIIlIlIII];
                    int lllllllllllllIIIIIlIlllIIIlIIllI = 14540253;
                    if (lllllllllllllIIIIIlIlllIIIlIIlll.endsWith("!")) {
                        lllllllllllllIIIIIlIlllIIIlIIllI = 16719904;
                    }
                    this.fontRendererObj.drawStringWithShadow(lllllllllllllIIIIIlIlllIIIlIIlll, (float)(lllllllllllllIIIIIlIlllIIIllIIII + 5), (float)(lllllllllllllIIIIIlIlllIIIlIllll + 5 + lllllllllllllIIIIIlIlllIIIlIlIII * 11), lllllllllllllIIIIIlIlllIIIlIIllI);
                }
            }
        }
    }
    
    private String[] splitDescription(String lllllllllllllIIIIIlIllIllllIllll) {
        if (lllllllllllllIIIIIlIllIllllIllll.length() <= 0) {
            return new String[0];
        }
        lllllllllllllIIIIIlIllIllllIllll = StrUtils.removePrefix(lllllllllllllIIIIIlIllIllllIllll, "//");
        final String[] lllllllllllllIIIIIlIllIllllIlllI = lllllllllllllIIIIIlIllIllllIllll.split("\\. ");
        for (int lllllllllllllIIIIIlIllIllllIllIl = 0; lllllllllllllIIIIIlIllIllllIllIl < lllllllllllllIIIIIlIllIllllIlllI.length; ++lllllllllllllIIIIIlIllIllllIllIl) {
            lllllllllllllIIIIIlIllIllllIlllI[lllllllllllllIIIIIlIllIllllIllIl] = String.valueOf(new StringBuilder("- ").append(lllllllllllllIIIIIlIllIllllIlllI[lllllllllllllIIIIIlIllIllllIllIl].trim()));
            lllllllllllllIIIIIlIllIllllIlllI[lllllllllllllIIIIIlIllIllllIllIl] = StrUtils.removeSuffix(lllllllllllllIIIIIlIllIllllIlllI[lllllllllllllIIIIIlIllIllllIllIl], ".");
        }
        return lllllllllllllIIIIIlIllIllllIlllI;
    }
    
    @Override
    protected void actionPerformedRightClick(final GuiButton lllllllllllllIIIIIlIlllIIllIlIII) {
        if (lllllllllllllIIIIIlIlllIIllIlIII instanceof GuiButtonShaderOption) {
            final GuiButtonShaderOption lllllllllllllIIIIIlIlllIIllIlIll = (GuiButtonShaderOption)lllllllllllllIIIIIlIlllIIllIlIII;
            final ShaderOption lllllllllllllIIIIIlIlllIIllIlIlI = lllllllllllllIIIIIlIlllIIllIlIll.getShaderOption();
            if (isShiftKeyDown()) {
                lllllllllllllIIIIIlIlllIIllIlIlI.resetValue();
            }
            else {
                lllllllllllllIIIIIlIlllIIllIlIlI.prevValue();
            }
            this.updateAllButtons();
            this.changed = true;
        }
    }
    
    private String[] makeTooltipLines(final int lllllllllllllIIIIIlIllIlllIllIII, final List<String> lllllllllllllIIIIIlIllIlllIlllll) {
        final FontRenderer lllllllllllllIIIIIlIllIlllIllllI = Config.getMinecraft().fontRendererObj;
        final List<String> lllllllllllllIIIIIlIllIlllIlllIl = new ArrayList<String>();
        for (int lllllllllllllIIIIIlIllIlllIlllII = 0; lllllllllllllIIIIIlIllIlllIlllII < lllllllllllllIIIIIlIllIlllIlllll.size(); ++lllllllllllllIIIIIlIllIlllIlllII) {
            final String lllllllllllllIIIIIlIllIlllIllIll = lllllllllllllIIIIIlIllIlllIlllll.get(lllllllllllllIIIIIlIllIlllIlllII);
            if (lllllllllllllIIIIIlIllIlllIllIll != null && lllllllllllllIIIIIlIllIlllIllIll.length() > 0) {
                for (final String lllllllllllllIIIIIlIllIlllIllIlI : lllllllllllllIIIIIlIllIlllIllllI.listFormattedStringToWidth(lllllllllllllIIIIIlIllIlllIllIll, lllllllllllllIIIIIlIllIlllIllIII)) {
                    lllllllllllllIIIIIlIllIlllIlllIl.add(lllllllllllllIIIIIlIllIlllIllIlI);
                }
            }
        }
        final String[] lllllllllllllIIIIIlIllIlllIllIIl = lllllllllllllIIIIIlIllIlllIlllIl.toArray(new String[lllllllllllllIIIIIlIllIlllIlllIl.size()]);
        return lllllllllllllIIIIIlIllIlllIllIIl;
    }
    
    public static String getButtonText(final ShaderOption lllllllllllllIIIIIlIlllIlIIIllII, final int lllllllllllllIIIIIlIlllIlIIlIIll) {
        String lllllllllllllIIIIIlIlllIlIIlIIlI = lllllllllllllIIIIIlIlllIlIIIllII.getNameText();
        if (lllllllllllllIIIIIlIlllIlIIIllII instanceof ShaderOptionScreen) {
            final ShaderOptionScreen lllllllllllllIIIIIlIlllIlIIlIIIl = (ShaderOptionScreen)lllllllllllllIIIIIlIlllIlIIIllII;
            return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIlIlllIlIIlIIlI)).append("..."));
        }
        final FontRenderer lllllllllllllIIIIIlIlllIlIIlIIII = Config.getMinecraft().fontRendererObj;
        for (int lllllllllllllIIIIIlIlllIlIIIllll = lllllllllllllIIIIIlIlllIlIIlIIII.getStringWidth(String.valueOf(new StringBuilder(": ").append(Lang.getOff()))) + 5; lllllllllllllIIIIIlIlllIlIIlIIII.getStringWidth(lllllllllllllIIIIIlIlllIlIIlIIlI) + lllllllllllllIIIIIlIlllIlIIIllll >= lllllllllllllIIIIIlIlllIlIIlIIll && lllllllllllllIIIIIlIlllIlIIlIIlI.length() > 0; lllllllllllllIIIIIlIlllIlIIlIIlI = lllllllllllllIIIIIlIlllIlIIlIIlI.substring(0, lllllllllllllIIIIIlIlllIlIIlIIlI.length() - 1)) {}
        final String lllllllllllllIIIIIlIlllIlIIIlllI = lllllllllllllIIIIIlIlllIlIIIllII.isChanged() ? lllllllllllllIIIIIlIlllIlIIIllII.getValueColor(lllllllllllllIIIIIlIlllIlIIIllII.getValue()) : "";
        final String lllllllllllllIIIIIlIlllIlIIIllIl = lllllllllllllIIIIIlIlllIlIIIllII.getValueText(lllllllllllllIIIIIlIlllIlIIIllII.getValue());
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIlIlllIlIIlIIlI)).append(": ").append(lllllllllllllIIIIIlIlllIlIIIlllI).append(lllllllllllllIIIIIlIlllIlIIIllIl));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIIIlIlllIIlllIllI) {
        if (lllllllllllllIIIIIlIlllIIlllIllI.enabled) {
            if (lllllllllllllIIIIIlIlllIIlllIllI.id < 200 && lllllllllllllIIIIIlIlllIIlllIllI instanceof GuiButtonShaderOption) {
                final GuiButtonShaderOption lllllllllllllIIIIIlIlllIIllllllI = (GuiButtonShaderOption)lllllllllllllIIIIIlIlllIIlllIllI;
                final ShaderOption lllllllllllllIIIIIlIlllIIlllllIl = lllllllllllllIIIIIlIlllIIllllllI.getShaderOption();
                if (lllllllllllllIIIIIlIlllIIlllllIl instanceof ShaderOptionScreen) {
                    final String lllllllllllllIIIIIlIlllIIlllllII = lllllllllllllIIIIIlIlllIIlllllIl.getName();
                    final GuiShaderOptions lllllllllllllIIIIIlIlllIIllllIll = new GuiShaderOptions(this, this.settings, lllllllllllllIIIIIlIlllIIlllllII);
                    this.mc.displayGuiScreen(lllllllllllllIIIIIlIlllIIllllIll);
                    return;
                }
                if (isShiftKeyDown()) {
                    lllllllllllllIIIIIlIlllIIlllllIl.resetValue();
                }
                else {
                    lllllllllllllIIIIIlIlllIIlllllIl.nextValue();
                }
                this.updateAllButtons();
                this.changed = true;
            }
            if (lllllllllllllIIIIIlIlllIIlllIllI.id == 201) {
                final ShaderOption[] lllllllllllllIIIIIlIlllIIllllIlI = Shaders.getChangedOptions(Shaders.getShaderPackOptions());
                for (int lllllllllllllIIIIIlIlllIIllllIIl = 0; lllllllllllllIIIIIlIlllIIllllIIl < lllllllllllllIIIIIlIlllIIllllIlI.length; ++lllllllllllllIIIIIlIlllIIllllIIl) {
                    final ShaderOption lllllllllllllIIIIIlIlllIIllllIII = lllllllllllllIIIIIlIlllIIllllIlI[lllllllllllllIIIIIlIlllIIllllIIl];
                    lllllllllllllIIIIIlIlllIIllllIII.resetValue();
                    this.changed = true;
                }
                this.updateAllButtons();
            }
            if (lllllllllllllIIIIIlIlllIIlllIllI.id == 200) {
                if (this.changed) {
                    Shaders.saveShaderPackOptions();
                    this.changed = false;
                    Shaders.uninit();
                }
                this.mc.displayGuiScreen(this.prevScreen);
            }
        }
    }
    
    private String[] makeTooltipLines(final ShaderOption lllllllllllllIIIIIlIllIlllllllIl, final int lllllllllllllIIIIIlIlllIIIIIlIII) {
        if (lllllllllllllIIIIIlIllIlllllllIl instanceof ShaderOptionProfile) {
            return null;
        }
        final String lllllllllllllIIIIIlIlllIIIIIIlll = lllllllllllllIIIIIlIllIlllllllIl.getNameText();
        final String lllllllllllllIIIIIlIlllIIIIIIllI = Config.normalize(lllllllllllllIIIIIlIllIlllllllIl.getDescriptionText()).trim();
        final String[] lllllllllllllIIIIIlIlllIIIIIIlIl = this.splitDescription(lllllllllllllIIIIIlIlllIIIIIIllI);
        String lllllllllllllIIIIIlIlllIIIIIIlII = null;
        if (!lllllllllllllIIIIIlIlllIIIIIIlll.equals(lllllllllllllIIIIIlIllIlllllllIl.getName()) && this.settings.advancedItemTooltips) {
            lllllllllllllIIIIIlIlllIIIIIIlII = String.valueOf(new StringBuilder("§8").append(Lang.get("of.general.id")).append(": ").append(lllllllllllllIIIIIlIllIlllllllIl.getName()));
        }
        String lllllllllllllIIIIIlIlllIIIIIIIll = null;
        if (lllllllllllllIIIIIlIllIlllllllIl.getPaths() != null && this.settings.advancedItemTooltips) {
            lllllllllllllIIIIIlIlllIIIIIIIll = String.valueOf(new StringBuilder("§8").append(Lang.get("of.general.from")).append(": ").append(Config.arrayToString(lllllllllllllIIIIIlIllIlllllllIl.getPaths())));
        }
        String lllllllllllllIIIIIlIlllIIIIIIIlI = null;
        if (lllllllllllllIIIIIlIllIlllllllIl.getValueDefault() != null && this.settings.advancedItemTooltips) {
            final String lllllllllllllIIIIIlIlllIIIIIIIIl = lllllllllllllIIIIIlIllIlllllllIl.isEnabled() ? lllllllllllllIIIIIlIllIlllllllIl.getValueText(lllllllllllllIIIIIlIllIlllllllIl.getValueDefault()) : Lang.get("of.general.ambiguous");
            lllllllllllllIIIIIlIlllIIIIIIIlI = String.valueOf(new StringBuilder("§8").append(Lang.getDefault()).append(": ").append(lllllllllllllIIIIIlIlllIIIIIIIIl));
        }
        final List<String> lllllllllllllIIIIIlIlllIIIIIIIII = new ArrayList<String>();
        lllllllllllllIIIIIlIlllIIIIIIIII.add(lllllllllllllIIIIIlIlllIIIIIIlll);
        lllllllllllllIIIIIlIlllIIIIIIIII.addAll(Arrays.asList(lllllllllllllIIIIIlIlllIIIIIIlIl));
        if (lllllllllllllIIIIIlIlllIIIIIIlII != null) {
            lllllllllllllIIIIIlIlllIIIIIIIII.add(lllllllllllllIIIIIlIlllIIIIIIlII);
        }
        if (lllllllllllllIIIIIlIlllIIIIIIIll != null) {
            lllllllllllllIIIIIlIlllIIIIIIIII.add(lllllllllllllIIIIIlIlllIIIIIIIll);
        }
        if (lllllllllllllIIIIIlIlllIIIIIIIlI != null) {
            lllllllllllllIIIIIlIlllIIIIIIIII.add(lllllllllllllIIIIIlIlllIIIIIIIlI);
        }
        final String[] lllllllllllllIIIIIlIllIlllllllll = this.makeTooltipLines(lllllllllllllIIIIIlIlllIIIIIlIII, lllllllllllllIIIIIlIlllIIIIIIIII);
        return lllllllllllllIIIIIlIllIlllllllll;
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.changed) {
            Shaders.saveShaderPackOptions();
            this.changed = false;
            Shaders.uninit();
        }
    }
}
