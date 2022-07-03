package clickui.component.components.subButtons;

import clickui.settings.*;
import clickui.panel.panels.*;
import me.nrules.utils.render.*;
import font.*;
import clickui.component.*;

public class ModeButton extends Parentable<Setting, CheatTypePanel>
{
    private /* synthetic */ float movingTextAnimte;
    private /* synthetic */ int modeCounter;
    private /* synthetic */ float textHoverAnimate;
    
    @Override
    public void drawScreen(final int lllllllllllllIIlIIlIIlllIlllIlll, final int lllllllllllllIIlIIlIIlllIlllIllI, final float lllllllllllllIIlIIlIIlllIlllIlIl) {
        final boolean lllllllllllllIIlIIlIIlllIllllIlI = this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
        this.textHoverAnimate = AnimUtils.moveUD(this.textHoverAnimate, (float)(lllllllllllllIIlIIlIIlllIllllIlI ? 4 : 2), 5.42E-4f);
        final MinecraftFontRenderer lllllllllllllIIlIIlIIlllIllllIIl = FontLoader.INSTANCE.consola_19;
        lllllllllllllIIlIIlIIlllIllllIIl.drawStringWithShadow(((Component<Setting>)this).getObject().getName(), (int)this.getX() + (int)this.textHoverAnimate, (int)this.getY() + 1, -1);
        lllllllllllllIIlIIlIIlllIllllIIl.drawStringWithShadow(((Component<Setting>)this).getObject().getValString(), (int)this.getX() - 51 + (int)this.getWidth() - (int)this.movingTextAnimte, (int)this.getY() + 1, -1);
        super.drawScreen(lllllllllllllIIlIIlIIlllIlllIlll, lllllllllllllIIlIIlIIlllIlllIllI, lllllllllllllIIlIIlIIlllIlllIlIl);
    }
    
    @Override
    public boolean isVisible() {
        return ((Component<Setting>)this).getObject().isVisible();
    }
    
    @Override
    public void updatePosition(final float lllllllllllllIIlIIlIIllllIIIIllI, final float lllllllllllllIIlIIlIIllllIIIlIII) {
        this.setX(lllllllllllllIIlIIlIIllllIIIIllI + this.getOffsetX());
        this.setY(lllllllllllllIIlIIlIIllllIIIlIII + this.getOffsetY());
    }
    
    public ModeButton(final Setting lllllllllllllIIlIIlIIllllIIlIlIl, final CheatTypePanel lllllllllllllIIlIIlIIllllIIlIlII, final float lllllllllllllIIlIIlIIllllIIlIIll, final float lllllllllllllIIlIIlIIllllIIllIll, final float lllllllllllllIIlIIlIIllllIIllIlI, final float lllllllllllllIIlIIlIIllllIIllIIl, final float lllllllllllllIIlIIlIIllllIIllIII, final float lllllllllllllIIlIIlIIllllIIlIlll) {
        super(lllllllllllllIIlIIlIIllllIIlIlIl, lllllllllllllIIlIIlIIllllIIlIlII, lllllllllllllIIlIIlIIllllIIlIIll, lllllllllllllIIlIIlIIllllIIllIll, lllllllllllllIIlIIlIIllllIIllIlI, lllllllllllllIIlIIlIIllllIIllIIl, lllllllllllllIIlIIlIIllllIIllIII, lllllllllllllIIlIIlIIllllIIlIlll);
        this.textHoverAnimate = 0.0f;
        this.movingTextAnimte = 0.0f;
        this.modeCounter = 0;
    }
    
    @Override
    public void mouseClicked(final int lllllllllllllIIlIIlIIlllIllIllII, final int lllllllllllllIIlIIlIIlllIllIIllI, final int lllllllllllllIIlIIlIIlllIllIIlIl) {
        final int lllllllllllllIIlIIlIIlllIllIlIIl = ((Component<Setting>)this).getObject().getOptions().size();
        if (this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight())) {
            if (lllllllllllllIIlIIlIIlllIllIIlIl == 0) {
                if (this.modeCounter + 1 > lllllllllllllIIlIIlIIlllIllIlIIl - 1) {
                    this.modeCounter = 0;
                }
                else {
                    ++this.modeCounter;
                }
                ((Component<Setting>)this).getObject().setValString(((Component<Setting>)this).getObject().getOptions().get(this.modeCounter));
            }
            else if (lllllllllllllIIlIIlIIlllIllIIlIl == 1) {
                if (this.modeCounter == 0) {
                    this.modeCounter = lllllllllllllIIlIIlIIlllIllIlIIl - 1;
                }
                else {
                    --this.modeCounter;
                }
                ((Component<Setting>)this).getObject().setValString(((Component<Setting>)this).getObject().getOptions().get(this.modeCounter));
            }
        }
        super.mouseClicked(lllllllllllllIIlIIlIIlllIllIllII, lllllllllllllIIlIIlIIlllIllIIllI, lllllllllllllIIlIIlIIlllIllIIlIl);
    }
}
