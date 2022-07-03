package clickui.component.components.subButtons;

import clickui.settings.*;
import clickui.panel.panels.*;
import java.awt.*;
import me.nrules.utils.render.*;
import me.nrules.module.render.*;
import font.*;
import clickui.component.*;

public class BooleanButton extends Parentable<Setting, CheatTypePanel>
{
    private /* synthetic */ float rightRectAnimation;
    private /* synthetic */ float leftRectAnimation;
    private /* synthetic */ float textHoverAnimate;
    
    @Override
    public void updatePosition(final float lllllllllllllIIIIIIllllIlIlIIIll, final float lllllllllllllIIIIIIllllIlIIlllll) {
        this.setX(lllllllllllllIIIIIIllllIlIlIIIll + this.getOffsetX());
        this.setY(lllllllllllllIIIIIIllllIlIIlllll + this.getOffsetY());
    }
    
    @Override
    public void mouseClicked(final int lllllllllllllIIIIIIllllIlIIIIlII, final int lllllllllllllIIIIIIllllIIlllllll, final int lllllllllllllIIIIIIllllIlIIIIIlI) {
        if (this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight()) && lllllllllllllIIIIIIllllIlIIIIIlI == 0) {
            ((Component<Setting>)this).getObject().setValBoolean(!((Component<Setting>)this).getObject().getValBoolean());
        }
        super.mouseClicked(lllllllllllllIIIIIIllllIlIIIIlII, lllllllllllllIIIIIIllllIIlllllll, lllllllllllllIIIIIIllllIlIIIIIlI);
    }
    
    @Override
    public boolean isVisible() {
        return ((Component<Setting>)this).getObject().isVisible();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIIIIllllIlIIlIllI, final int lllllllllllllIIIIIIllllIlIIIlllI, final float lllllllllllllIIIIIIllllIlIIIllIl) {
        final boolean lllllllllllllIIIIIIllllIlIIlIIll = this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
        this.textHoverAnimate = AnimUtils.moveUD(this.textHoverAnimate, (float)(lllllllllllllIIIIIIllllIlIIlIIll ? 4 : 2), 1.000542f);
        this.leftRectAnimation = AnimUtils.moveUD(this.leftRectAnimation, (float)(((Component<Setting>)this).getObject().getValBoolean() ? 10 : 17), 5.42E-4f);
        this.rightRectAnimation = AnimUtils.moveUD(this.rightRectAnimation, (float)(((Component<Setting>)this).getObject().getValBoolean() ? 3 : 10), 5.42E-4f);
        RenderUtils.drawRect(this.getX() + this.getWidth() - 18.0f, this.getY() + 2.0f, this.getX() + this.getWidth() - 2.0f, this.getY() + this.getHeight() - 2.0f, new Color(14, 14, 14).getRGB());
        final Color lllllllllllllIIIIIIllllIlIIlIIlI = Color.getHSBColor(1.0f, 1.0f, 0.65f);
        if (ClickGUI.rainbow.getValBoolean()) {
            RenderUtils.drawRect2(this.getX() + this.getWidth() - this.leftRectAnimation, this.getY() + 3.0f, this.getX() + this.getWidth() - this.rightRectAnimation, this.getY() + this.getHeight() - 3.0f, ((Component<Setting>)this).getObject().getValBoolean() ? RenderUtils.getRainbow(17000, -15 * (int)this.getY()) : new Color(50, 50, 50).getRGB());
        }
        else {
            RenderUtils.drawRect2(this.getX() + this.getWidth() - this.leftRectAnimation, this.getY() + 3.0f, this.getX() + this.getWidth() - this.rightRectAnimation, this.getY() + this.getHeight() - 3.0f, ((Component<Setting>)this).getObject().getValBoolean() ? new Color(145, 239, 62).getRGB() : new Color(50, 50, 50).getRGB());
        }
        final MinecraftFontRenderer lllllllllllllIIIIIIllllIlIIlIIIl = FontLoader.INSTANCE.consola_16;
        lllllllllllllIIIIIIllllIlIIlIIIl.drawStringWithShadow(((Component<Setting>)this).getObject().getName(), (int)this.getX() + (int)this.textHoverAnimate, (int)this.getY() + 1, -1);
        super.drawScreen(lllllllllllllIIIIIIllllIlIIlIllI, lllllllllllllIIIIIIllllIlIIIlllI, lllllllllllllIIIIIIllllIlIIIllIl);
    }
    
    public BooleanButton(final Setting lllllllllllllIIIIIIllllIlIlllIII, final CheatTypePanel lllllllllllllIIIIIIllllIlIlIlllI, final float lllllllllllllIIIIIIllllIlIllIllI, final float lllllllllllllIIIIIIllllIlIllIlIl, final float lllllllllllllIIIIIIllllIlIlIlIll, final float lllllllllllllIIIIIIllllIlIllIIll, final float lllllllllllllIIIIIIllllIlIlIlIIl, final float lllllllllllllIIIIIIllllIlIlIlIII) {
        super(lllllllllllllIIIIIIllllIlIlllIII, lllllllllllllIIIIIIllllIlIlIlllI, lllllllllllllIIIIIIllllIlIllIllI, lllllllllllllIIIIIIllllIlIllIlIl, lllllllllllllIIIIIIllllIlIlIlIll, lllllllllllllIIIIIIllllIlIllIIll, lllllllllllllIIIIIIllllIlIlIlIIl, lllllllllllllIIIIIIllllIlIlIlIII);
        this.textHoverAnimate = 0.0f;
        this.leftRectAnimation = 0.0f;
        this.rightRectAnimation = 0.0f;
    }
}
