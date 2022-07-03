package clickui.panel.panels;

import clickui.panel.*;
import clickui.component.components.*;
import me.nrules.*;
import me.nrules.module.*;
import clickui.settings.*;
import java.util.*;
import me.nrules.module.render.*;
import me.nrules.utils.render.*;
import java.awt.*;
import org.apache.commons.lang3.text.*;
import font.*;
import clickui.component.components.subButtons.*;
import clickui.component.*;

public class CheatTypePanel extends Panel
{
    private /* synthetic */ Section section;
    private /* synthetic */ CheatButton selectedCheat;
    private /* synthetic */ ArrayList<CheatButton> cheatButtons;
    private /* synthetic */ float rectAnimation;
    private /* synthetic */ float backButtonHoverAnimate;
    private /* synthetic */ Category cheatType;
    private /* synthetic */ ArrayList<Parentable> cheatOptions;
    
    public Category getCheatType() {
        return this.cheatType;
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
    }
    
    @Override
    public void updatePosition(final float lllllllllllllIllIllIIIIIllIllIIl, final float lllllllllllllIllIllIIIIIllIllIII) {
        this.cheatButtons.forEach(lllllllllllllIllIllIIIIIIllllllI -> lllllllllllllIllIllIIIIIIllllllI.updatePosition(lllllllllllllIllIllIIIIIllIllIIl, lllllllllllllIllIllIIIIIllIllIII));
        this.cheatOptions.forEach(lllllllllllllIllIllIIIIIIllllIlI -> lllllllllllllIllIllIIIIIIllllIlI.updatePosition(lllllllllllllIllIllIIIIIllIllIIl, lllllllllllllIllIllIIIIIllIllIII));
        super.updatePosition(lllllllllllllIllIllIIIIIllIllIIl, lllllllllllllIllIllIIIIIllIllIII);
    }
    
    public void setSection(final Section lllllllllllllIllIllIIIIIlIIIlllI) {
        this.section = lllllllllllllIllIllIIIIIlIIIlllI;
    }
    
    @Override
    public void mouseClicked(final int lllllllllllllIllIllIIIIIlIllIlII, final int lllllllllllllIllIllIIIIIlIllIIll, final int lllllllllllllIllIllIIIIIlIllIllI) {
        if (this.isExpand()) {
            if (this.getSection() == Section.CHEATS) {
                this.cheatButtons.forEach(lllllllllllllIllIllIIIIIIllIIIlI -> lllllllllllllIllIllIIIIIIllIIIlI.mouseClicked(lllllllllllllIllIllIIIIIlIllIlII, lllllllllllllIllIllIIIIIlIllIIll, lllllllllllllIllIllIIIIIlIllIllI));
            }
            else {
                if (this.isHovered(this.getX() + 1.0f, this.getY() + 2.0f, this.getX() + 14.0f, this.getY() + 12.0f) && lllllllllllllIllIllIIIIIlIllIllI == 0) {
                    this.setSection(Section.CHEATS);
                    this.setSelectedCheat(null);
                }
                if (Objects.nonNull(this.getSelectedCheat())) {
                    this.cheatOptions.stream().filter(lllllllllllllIllIllIIIIIIlIlllII -> Main.settingsManager.getSettingsByMod(((Component<Module>)this.getSelectedCheat()).getObject()).contains(lllllllllllllIllIllIIIIIIlIlllII.getObject()) && ((Parentable)lllllllllllllIllIllIIIIIIlIlllII).isVisible()).forEach(lllllllllllllIllIllIIIIIIlIlIlll -> lllllllllllllIllIllIIIIIIlIlIlll.mouseClicked(lllllllllllllIllIllIIIIIlIllIlII, lllllllllllllIllIllIIIIIlIllIIll, lllllllllllllIllIllIIIIIlIllIllI));
                }
            }
        }
        super.mouseClicked(lllllllllllllIllIllIIIIIlIllIlII, lllllllllllllIllIllIIIIIlIllIIll, lllllllllllllIllIllIIIIIlIllIllI);
    }
    
    public Section getSection() {
        return this.section;
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIllIllIIIIIlIlIlIII, final int lllllllllllllIllIllIIIIIlIlIlIll, final int lllllllllllllIllIllIIIIIlIlIlIlI) {
        if (this.isExpand() && this.getSection() == Section.SETTINGS && Objects.nonNull(this.getSelectedCheat())) {
            this.cheatOptions.stream().filter(lllllllllllllIllIllIIIIIIlIIllIl -> Main.settingsManager.getSettingsByMod(((Component<Module>)this.getSelectedCheat()).getObject()).contains(lllllllllllllIllIllIIIIIIlIIllIl.getObject()) && ((Parentable)lllllllllllllIllIllIIIIIIlIIllIl).isVisible()).forEach(lllllllllllllIllIllIIIIIIlIIIlII -> lllllllllllllIllIllIIIIIIlIIIlII.mouseReleased(lllllllllllllIllIllIIIIIlIlIlIII, lllllllllllllIllIllIIIIIlIlIlIll, lllllllllllllIllIllIIIIIlIlIlIlI));
        }
        super.mouseReleased(lllllllllllllIllIllIIIIIlIlIlIII, lllllllllllllIllIllIIIIIlIlIlIll, lllllllllllllIllIllIIIIIlIlIlIlI);
    }
    
    public void setSelectedCheat(final CheatButton lllllllllllllIllIllIIIIIlIIIIlIl) {
        this.selectedCheat = lllllllllllllIllIllIIIIIlIIIIlIl;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllIllIIIIIllIIIlIl, final int lllllllllllllIllIllIIIIIllIIllII, final float lllllllllllllIllIllIIIIIllIIIIll) {
        this.rectAnimation = AnimUtils.moveUD(this.rectAnimation, this.getHeight(), 0.0123f);
        this.backButtonHoverAnimate = AnimUtils.moveUD(this.backButtonHoverAnimate, (float)(this.isHovered(this.getX() + 1.0f, this.getY() + 2.0f, this.getX() + 14.0f, this.getY() + 12.0f) ? 0 : 2), 2.42E-4f);
        float lllllllllllllIllIllIIIIIllIIlIlI = 0.0f;
        if (this.isExpand()) {
            if (this.getSection() == Section.CHEATS) {
                lllllllllllllIllIllIIIIIllIIlIlI = (float)(Main.moduleManager.getCheats(this.getCheatType()).isEmpty() ? 14 : (14 + Main.moduleManager.getCheats(this.getCheatType()).size() * 14 + 2));
            }
            else if (Objects.nonNull(this.getSelectedCheat())) {
                lllllllllllllIllIllIIIIIllIIlIlI = (float)(14 + ((Main.settingsManager.getSettingsByMod(((Component<Module>)this.getSelectedCheat()).getObject()) == null) ? 0 : (Main.settingsManager.getSettingsByMod(((Component<Module>)this.getSelectedCheat()).getObject()).stream().filter(lllllllllllllIllIllIIIIIIlllIlII -> lllllllllllllIllIllIIIIIIlllIlII.isVisible()).toArray().length * 12 + 2)));
            }
        }
        else {
            lllllllllllllIllIllIIIIIllIIlIlI = 14.0f;
        }
        this.setHeight(lllllllllllllIllIllIIIIIllIIlIlI);
        if (ClickGUI.rainbow.getValBoolean()) {
            RenderUtils.drawSmoothRect(this.getX() - 1.0f, this.getY() - 1.0f, this.getX() + this.getWidth() + 1.0f, this.getY() + this.rectAnimation + 1.0f, RenderUtils.getRainbow(17000, -15 * (int)this.getY() / 2));
        }
        else {
            RenderUtils.drawSmoothRect(this.getX() - 1.0f, this.getY() - 1.0f, this.getX() + this.getWidth() + 1.0f, this.getY() + this.rectAnimation + 1.0f, new Color(101, 28, 152).getRGB());
        }
        RenderUtils.drawSmoothRect(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.rectAnimation, new Color(36, 36, 36).getRGB());
        final MinecraftFontRenderer lllllllllllllIllIllIIIIIllIIlIIl = FontLoader.INSTANCE.comfortaa_bold_20;
        lllllllllllllIllIllIIIIIllIIlIIl.drawCenteredStringWithShadow((this.getSection() == Section.CHEATS) ? WordUtils.capitalizeFully(this.getCheatType().name()) : ((Component<Module>)this.getSelectedCheat()).getObject().getName(), (int)this.getX() + (int)this.getWidth() / 2, (int)this.getY() + 5, -1);
        if (Main.moduleManager.getCheats(this.getCheatType()) != null && this.isExpand()) {
            RenderUtils.drawSmoothRect(this.getX() + 2.0f, this.getY() + 14.0f, this.getX() + this.getWidth() - 2.0f, this.getY() + this.rectAnimation + (this.isExpand() ? -2 : 0), new Color(62, 61, 61).getRGB());
            if (this.getSection() == Section.CHEATS) {
                this.cheatButtons.forEach(lllllllllllllIllIllIIIIIIllIlIll -> lllllllllllllIllIllIIIIIIllIlIll.drawScreen(lllllllllllllIllIllIIIIIllIIIlIl, lllllllllllllIllIllIIIIIllIIllII, lllllllllllllIllIllIIIIIllIIIIll));
            }
            else {
                lllllllllllllIllIllIIIIIllIIlIIl.drawStringWithShadow("<", (int)this.getX() + 4, (int)this.getY() + (int)this.backButtonHoverAnimate, Color.white.getRGB());
                if (Objects.nonNull(this.getSelectedCheat())) {
                    float lllllllllllllIllIllIIIIIllIIlIII = 14.0f;
                    for (final Parentable lllllllllllllIllIllIIIIIllIIIlll : this.cheatOptions) {
                        if (Main.settingsManager.getSettingsByMod(((Component<Module>)this.getSelectedCheat()).getObject()) != null && Main.settingsManager.getSettingsByMod(((Component<Module>)this.getSelectedCheat()).getObject()).contains(lllllllllllllIllIllIIIIIllIIIlll.getObject()) && lllllllllllllIllIllIIIIIllIIIlll.isVisible()) {
                            lllllllllllllIllIllIIIIIllIIIlll.setOffsetY(lllllllllllllIllIllIIIIIllIIlIII);
                            lllllllllllllIllIllIIIIIllIIIlll.updatePosition(this.getX(), this.getY());
                            lllllllllllllIllIllIIIIIllIIIlll.drawScreen(lllllllllllllIllIllIIIIIllIIIlIl, lllllllllllllIllIllIIIIIllIIllII, lllllllllllllIllIllIIIIIllIIIIll);
                            lllllllllllllIllIllIIIIIllIIlIII += 12.0f;
                        }
                    }
                }
            }
        }
        if (!this.isExpand() && this.getSection() == Section.SETTINGS) {
            this.setSection(Section.CHEATS);
            this.setSelectedCheat(null);
        }
        super.drawScreen(lllllllllllllIllIllIIIIIllIIIlIl, lllllllllllllIllIllIIIIIllIIllII, lllllllllllllIllIllIIIIIllIIIIll);
    }
    
    public CheatTypePanel(final Category lllllllllllllIllIllIIIIIlllIlIIl, final float lllllllllllllIllIllIIIIIllllIIII, final float lllllllllllllIllIllIIIIIlllIIlll) {
        super(lllllllllllllIllIllIIIIIllllIIII, lllllllllllllIllIllIIIIIlllIIlll, 120.0f, 300.0f);
        this.rectAnimation = 0.0f;
        this.backButtonHoverAnimate = 0.0f;
        this.cheatType = lllllllllllllIllIllIIIIIlllIlIIl;
        this.cheatButtons = new ArrayList<CheatButton>();
        this.cheatOptions = new ArrayList<Parentable>();
        this.setSection(Section.CHEATS);
        float lllllllllllllIllIllIIIIIlllIlllI = 14.0f;
        for (final Module lllllllllllllIllIllIIIIIlllIllIl : Main.moduleManager.getCheats(this.getCheatType())) {
            this.cheatButtons.add(new CheatButton(lllllllllllllIllIllIIIIIlllIllIl, this, this.getX(), this.getY(), this.getWidth() - 4.0f, 14.0f, 2.0f, lllllllllllllIllIllIIIIIlllIlllI));
            if (Main.settingsManager.getSettingsByMod(lllllllllllllIllIllIIIIIlllIllIl) != null) {
                float lllllllllllllIllIllIIIIIlllIllII = 14.0f;
                for (final Setting lllllllllllllIllIllIIIIIlllIlIll : Main.settingsManager.getSettingsByMod(lllllllllllllIllIllIIIIIlllIllIl)) {
                    if (lllllllllllllIllIllIIIIIlllIlIll.isCheck()) {
                        this.cheatOptions.add(new BooleanButton(lllllllllllllIllIllIIIIIlllIlIll, this, this.getX(), this.getY(), this.getWidth() - 4.0f, 12.0f, 2.0f, lllllllllllllIllIllIIIIIlllIllII));
                    }
                    if (lllllllllllllIllIllIIIIIlllIlIll.isCombo()) {
                        this.cheatOptions.add(new ModeButton(lllllllllllllIllIllIIIIIlllIlIll, this, this.getX(), this.getY(), this.getWidth() - 4.0f, 12.0f, 2.0f, lllllllllllllIllIllIIIIIlllIllII));
                    }
                    if (lllllllllllllIllIllIIIIIlllIlIll.isSlider()) {
                        this.cheatOptions.add(new SliderButton(lllllllllllllIllIllIIIIIlllIlIll, this, this.getX(), this.getY(), this.getWidth() - 4.0f, 12.0f, 2.0f, lllllllllllllIllIllIIIIIlllIllII));
                    }
                    if (lllllllllllllIllIllIIIIIlllIlIll.isString()) {
                        this.cheatOptions.add(new StringButton(lllllllllllllIllIllIIIIIlllIlIll, this, this.getX(), this.getY(), this.getWidth() - 4.0f, 12.0f, 2.0f, lllllllllllllIllIllIIIIIlllIllII));
                    }
                    lllllllllllllIllIllIIIIIlllIllII += 12.0f;
                }
            }
            lllllllllllllIllIllIIIIIlllIlllI += 14.0f;
        }
    }
    
    @Override
    public void keyTyped(final char lllllllllllllIllIllIIIIIlIIllIll, final int lllllllllllllIllIllIIIIIlIIlllIl) {
        if (this.isExpand() && this.getSection() == Section.CHEATS) {
            this.cheatButtons.forEach(lllllllllllllIllIllIIIIIIIllllIl -> lllllllllllllIllIllIIIIIIIllllIl.keyTyped(lllllllllllllIllIllIIIIIlIIllIll, lllllllllllllIllIllIIIIIlIIlllIl));
        }
        super.keyTyped(lllllllllllllIllIllIIIIIlIIllIll, lllllllllllllIllIllIIIIIlIIlllIl);
    }
    
    public CheatButton getSelectedCheat() {
        return this.selectedCheat;
    }
}
