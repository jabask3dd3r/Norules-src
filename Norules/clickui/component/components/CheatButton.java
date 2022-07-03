package clickui.component.components;

import me.nrules.module.*;
import me.nrules.*;
import clickui.panel.panels.*;
import me.nrules.module.render.*;
import me.nrules.utils.render.*;
import java.awt.*;
import font.*;
import clickui.component.*;

public class CheatButton extends Parentable<Module, CheatTypePanel>
{
    private /* synthetic */ float textHoverAnimate;
    private /* synthetic */ boolean binding;
    private /* synthetic */ float activeRectAnimate;
    
    @Override
    public void mouseClicked(final int llllllllllllllIIIIlllIIIlIIIIIlI, final int llllllllllllllIIIIlllIIIlIIIIIIl, final int llllllllllllllIIIIlllIIIIlllllII) {
        if (this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight())) {
            if (llllllllllllllIIIIlllIIIIlllllII == 0) {
                ((Component<Module>)this).getObject().toggle();
            }
            if (llllllllllllllIIIIlllIIIIlllllII == 1 && Main.settingsManager.getSettingsByMod(((Component<Module>)this).getObject()) != null) {
                ((Parentable<O, CheatTypePanel>)this).getParent().setSelectedCheat(this);
                ((Parentable<O, CheatTypePanel>)this).getParent().setSection(Section.SETTINGS);
            }
            if (llllllllllllllIIIIlllIIIIlllllII == 2) {
                this.setBinding(!this.isBinding());
            }
        }
        else if (this.isBinding()) {
            this.setBinding(false);
        }
        super.mouseClicked(llllllllllllllIIIIlllIIIlIIIIIlI, llllllllllllllIIIIlllIIIlIIIIIIl, llllllllllllllIIIIlllIIIIlllllII);
    }
    
    public CheatButton(final Module llllllllllllllIIIIlllIIIlIlIlIlI, final CheatTypePanel llllllllllllllIIIIlllIIIlIlIlIIl, final float llllllllllllllIIIIlllIIIlIlIlIII, final float llllllllllllllIIIIlllIIIlIllIIII, final float llllllllllllllIIIIlllIIIlIlIllll, final float llllllllllllllIIIIlllIIIlIlIlllI, final float llllllllllllllIIIIlllIIIlIlIIlII, final float llllllllllllllIIIIlllIIIlIlIllII) {
        super(llllllllllllllIIIIlllIIIlIlIlIlI, llllllllllllllIIIIlllIIIlIlIlIIl, llllllllllllllIIIIlllIIIlIlIlIII, llllllllllllllIIIIlllIIIlIllIIII, llllllllllllllIIIIlllIIIlIlIllll, llllllllllllllIIIIlllIIIlIlIlllI, llllllllllllllIIIIlllIIIlIlIIlII, llllllllllllllIIIIlllIIIlIlIllII);
        this.textHoverAnimate = 0.0f;
        this.activeRectAnimate = 0.0f;
    }
    
    public boolean isBinding() {
        return this.binding;
    }
    
    public void setBinding(final boolean llllllllllllllIIIIlllIIIIllIlIlI) {
        this.binding = llllllllllllllIIIIlllIIIIllIlIlI;
    }
    
    @Override
    public void updatePosition(final float llllllllllllllIIIIlllIIIlIIllllI, final float llllllllllllllIIIIlllIIIlIIllIlI) {
        this.setX(llllllllllllllIIIIlllIIIlIIllllI + this.getOffsetX());
        this.setY(llllllllllllllIIIIlllIIIlIIllIlI + this.getOffsetY());
    }
    
    @Override
    public void keyTyped(final char llllllllllllllIIIIlllIIIIlllIlll, final int llllllllllllllIIIIlllIIIIlllIIll) {
        if (this.isBinding()) {
            if (llllllllllllllIIIIlllIIIIlllIIll == 16) {
                ((Component<Module>)this).getObject().setKey(0);
            }
            else if (llllllllllllllIIIIlllIIIIlllIIll == 1) {
                this.setBinding(false);
            }
            else if (llllllllllllllIIIIlllIIIIlllIIll == 17 || llllllllllllllIIIIlllIIIIlllIIll == 32 || llllllllllllllIIIIlllIIIIlllIIll == 30 || llllllllllllllIIIIlllIIIIlllIIll == 31) {
                this.setBinding(false);
            }
            else {
                ((Component<Module>)this).getObject().setKey(llllllllllllllIIIIlllIIIIlllIIll);
            }
            this.setBinding(false);
        }
        super.keyTyped(llllllllllllllIIIIlllIIIIlllIlll, llllllllllllllIIIIlllIIIIlllIIll);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIIlllIIIlIIlIIlI, final int llllllllllllllIIIIlllIIIlIIlIIIl, final float llllllllllllllIIIIlllIIIlIIlIIII) {
        final boolean llllllllllllllIIIIlllIIIlIIIllll = this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
        this.textHoverAnimate = AnimUtils.moveUD(this.textHoverAnimate, (float)(llllllllllllllIIIIlllIIIlIIIllll ? 4 : 2), 5.42E-4f);
        this.activeRectAnimate = AnimUtils.moveUD(this.activeRectAnimate, ((Component<Module>)this).getObject().isToggled() ? this.getWidth() : 0.0f, 0.00542f);
        if (ClickGUI.rainbow.getValBoolean()) {
            RenderUtils.drawRect2(this.getX(), this.getY(), this.getX() + this.activeRectAnimate, this.getY() + this.getHeight(), RenderUtils.getRainbow(17000, -15 * (int)this.getY()));
        }
        else {
            RenderUtils.drawRect2(this.getX(), this.getY(), this.getX() + this.activeRectAnimate, this.getY() + this.getHeight(), new Color(166, 38, 224, 130).getRGB());
        }
        final MinecraftFontRenderer llllllllllllllIIIIlllIIIlIIIlllI = FontLoader.INSTANCE.futura_normal_20;
        llllllllllllllIIIIlllIIIlIIIlllI.drawStringWithShadow(this.isBinding() ? "Press a key..." : ((Component<Module>)this).getObject().getName(), (int)this.getX() + (int)this.textHoverAnimate, (int)this.getY() + 2, -1);
        if (Main.settingsManager.getSettingsByMod(((Component<Module>)this).getObject()) != null) {
            llllllllllllllIIIIlllIIIlIIIlllI.drawStringWithShadow(this.isBinding() ? "" : "....", (int)this.getX() - 5 + (int)this.getWidth() - 9, (int)this.getY() + 1, -1);
        }
        super.drawScreen(llllllllllllllIIIIlllIIIlIIlIIlI, llllllllllllllIIIIlllIIIlIIlIIIl, llllllllllllllIIIIlllIIIlIIlIIII);
    }
}
