package clickui.component.components.subButtons;

import clickui.settings.*;
import clickui.panel.panels.*;
import java.awt.*;
import me.nrules.module.render.*;
import me.nrules.utils.render.*;
import font.*;
import java.math.*;
import clickui.component.*;

public class SliderButton extends Parentable<Setting, CheatTypePanel>
{
    private /* synthetic */ boolean sliding;
    private /* synthetic */ float currentValueAnimate;
    private /* synthetic */ float textHoverAnimate;
    
    public void setSliding(final boolean lllllllllllllIlllIllIlIIllIIllll) {
        this.sliding = lllllllllllllIlllIllIlIIllIIllll;
    }
    
    @Override
    public boolean isVisible() {
        return ((Component<Setting>)this).getObject().isVisible();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlllIllIlIIllllllll, final int lllllllllllllIlllIllIlIIlllllllI, final float lllllllllllllIlllIllIlIIllllllIl) {
        final boolean lllllllllllllIlllIllIlIlIIIIlIlI = this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
        String lllllllllllllIlllIllIlIlIIIIlIIl = null;
        if (((Component<Setting>)this).getObject().onlyInt()) {
            lllllllllllllIlllIllIlIlIIIIlIIl = String.valueOf(((Component<Setting>)this).getObject().getValInt());
        }
        else {
            lllllllllllllIlllIllIlIlIIIIlIIl = String.format("%.2f", ((Component<Setting>)this).getObject().getValDouble());
        }
        final double lllllllllllllIlllIllIlIlIIIIlIII = (((Component<Setting>)this).getObject().getValDouble() - ((Component<Setting>)this).getObject().getMin()) / (((Component<Setting>)this).getObject().getMax() - ((Component<Setting>)this).getObject().getMin());
        this.textHoverAnimate = AnimUtils.moveUD(this.textHoverAnimate, (float)((lllllllllllllIlllIllIlIlIIIIlIlI || this.isSliding()) ? 4 : 2), 5.42E-4f);
        this.currentValueAnimate = AnimUtils.moveUD(this.currentValueAnimate, (float)lllllllllllllIlllIllIlIlIIIIlIII, 5.42E-4f);
        final Color lllllllllllllIlllIllIlIlIIIIIlll = Color.getHSBColor(1.0f, 1.0f, 0.65f);
        if (ClickGUI.rainbow.getValBoolean()) {
            RenderUtils.drawRect2(this.getX(), this.getY(), this.getX() + this.getWidth() * this.currentValueAnimate, this.getY() + this.getHeight(), RenderUtils.getRainbow(17000, -15 * (int)this.getY()));
        }
        else {
            RenderUtils.drawRect2(this.getX(), this.getY(), this.getX() + this.getWidth() * this.currentValueAnimate, this.getY() + this.getHeight(), new Color(152, 51, 207).getRGB());
        }
        final MinecraftFontRenderer lllllllllllllIlllIllIlIlIIIIIllI = FontLoader.INSTANCE.consola_16;
        final MinecraftFontRenderer lllllllllllllIlllIllIlIlIIIIIlIl = FontLoader.INSTANCE.comfortaa_bold_16;
        lllllllllllllIlllIllIlIlIIIIIlIl.drawStringWithShadow(((Component<Setting>)this).getObject().getName(), (int)this.getX() + (int)this.textHoverAnimate, (int)this.getY() + 1, -1);
        lllllllllllllIlllIllIlIlIIIIIllI.drawStringWithShadow(lllllllllllllIlllIllIlIlIIIIlIIl, (int)this.getX() + (int)this.getWidth() - lllllllllllllIlllIllIlIlIIIIIlIl.getStringWidth(lllllllllllllIlllIllIlIlIIIIlIIl) - 2, (int)this.getY() + 1, -1);
        final double lllllllllllllIlllIllIlIlIIIIIlII = Math.min(this.getWidth(), Math.max(0.0f, lllllllllllllIlllIllIlIIllllllll - this.getX()));
        final double lllllllllllllIlllIllIlIlIIIIIIll = ((Component<Setting>)this).getObject().getMin();
        final double lllllllllllllIlllIllIlIlIIIIIIlI = ((Component<Setting>)this).getObject().getMax();
        if (this.isSliding()) {
            if (lllllllllllllIlllIllIlIlIIIIIlII == 0.0) {
                ((Component<Setting>)this).getObject().setValDouble(((Component<Setting>)this).getObject().getMin());
            }
            else {
                final double lllllllllllllIlllIllIlIlIIIIIIIl = this.roundToPlace(lllllllllllllIlllIllIlIlIIIIIlII / this.getWidth() * (lllllllllllllIlllIllIlIlIIIIIIlI - lllllllllllllIlllIllIlIlIIIIIIll) + lllllllllllllIlllIllIlIlIIIIIIll, 2);
                ((Component<Setting>)this).getObject().setValDouble(lllllllllllllIlllIllIlIlIIIIIIIl);
            }
        }
        super.drawScreen(lllllllllllllIlllIllIlIIllllllll, lllllllllllllIlllIllIlIIlllllllI, lllllllllllllIlllIllIlIIllllllIl);
    }
    
    @Override
    public void mouseClicked(final int lllllllllllllIlllIllIlIIlllIlIIl, final int lllllllllllllIlllIllIlIIlllIllII, final int lllllllllllllIlllIllIlIIlllIIlll) {
        if (this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight()) && lllllllllllllIlllIllIlIIlllIIlll == 0) {
            this.setSliding(true);
        }
        super.mouseClicked(lllllllllllllIlllIllIlIIlllIlIIl, lllllllllllllIlllIllIlIIlllIllII, lllllllllllllIlllIllIlIIlllIIlll);
    }
    
    public boolean isSliding() {
        return this.sliding;
    }
    
    public SliderButton(final Setting lllllllllllllIlllIllIlIlIIlIllIl, final CheatTypePanel lllllllllllllIlllIllIlIlIIllIlIl, final float lllllllllllllIlllIllIlIlIIlIlIll, final float lllllllllllllIlllIllIlIlIIllIIll, final float lllllllllllllIlllIllIlIlIIlIlIIl, final float lllllllllllllIlllIllIlIlIIllIIIl, final float lllllllllllllIlllIllIlIlIIllIIII, final float lllllllllllllIlllIllIlIlIIlIIllI) {
        super(lllllllllllllIlllIllIlIlIIlIllIl, lllllllllllllIlllIllIlIlIIllIlIl, lllllllllllllIlllIllIlIlIIlIlIll, lllllllllllllIlllIllIlIlIIllIIll, lllllllllllllIlllIllIlIlIIlIlIIl, lllllllllllllIlllIllIlIlIIllIIIl, lllllllllllllIlllIllIlIlIIllIIII, lllllllllllllIlllIllIlIlIIlIIllI);
        this.textHoverAnimate = 0.0f;
        this.currentValueAnimate = 0.0f;
    }
    
    @Override
    public void updatePosition(final float lllllllllllllIlllIllIlIlIIlIIIIl, final float lllllllllllllIlllIllIlIlIIlIIIII) {
        this.setX(lllllllllllllIlllIllIlIlIIlIIIIl + this.getOffsetX());
        this.setY(lllllllllllllIlllIllIlIlIIlIIIII + this.getOffsetY());
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIlllIllIlIIlllIIIIl, final int lllllllllllllIlllIllIlIIlllIIIII, final int lllllllllllllIlllIllIlIIllIllIll) {
        if (this.isSliding() && lllllllllllllIlllIllIlIIllIllIll == 0) {
            this.setSliding(false);
        }
        super.mouseReleased(lllllllllllllIlllIllIlIIlllIIIIl, lllllllllllllIlllIllIlIIlllIIIII, lllllllllllllIlllIllIlIIllIllIll);
    }
    
    private double roundToPlace(final double lllllllllllllIlllIllIlIIllIIIlll, final int lllllllllllllIlllIllIlIIllIIlIIl) {
        if (lllllllllllllIlllIllIlIIllIIlIIl < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal lllllllllllllIlllIllIlIIllIIlIII = new BigDecimal(lllllllllllllIlllIllIlIIllIIIlll);
        lllllllllllllIlllIllIlIIllIIlIII = lllllllllllllIlllIllIlIIllIIlIII.setScale(lllllllllllllIlllIllIlIIllIIlIIl, RoundingMode.HALF_UP);
        return lllllllllllllIlllIllIlIIllIIlIII.doubleValue();
    }
}
