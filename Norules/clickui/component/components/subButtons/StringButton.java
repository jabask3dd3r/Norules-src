package clickui.component.components.subButtons;

import clickui.settings.*;
import clickui.panel.panels.*;
import me.nrules.utils.render.*;
import font.*;
import net.minecraft.util.*;
import clickui.component.*;

public class StringButton extends Parentable<Setting, CheatTypePanel>
{
    private /* synthetic */ float textHoverAnimate;
    private /* synthetic */ boolean listen;
    private /* synthetic */ String currentString;
    
    private void enterString() {
        this.listen = false;
        if (this.currentString.isEmpty()) {
            ((Component<Setting>)this).getObject().setValString(((Component<Setting>)this).getObject().getdString());
        }
        else {
            ((Component<Setting>)this).getObject().setValString(this.currentString);
        }
    }
    
    @Override
    public void mouseClicked(final int llllllllllllllIIIIIlllllIlIlIllI, final int llllllllllllllIIIIIlllllIlIllIIl, final int llllllllllllllIIIIIlllllIlIllIII) {
        if (this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight()) && llllllllllllllIIIIIlllllIlIllIII == 0) {
            this.listen = !this.listen;
            if (!this.listen) {
                this.enterString();
            }
        }
        else {
            this.listen = false;
        }
        super.mouseClicked(llllllllllllllIIIIIlllllIlIlIllI, llllllllllllllIIIIIlllllIlIllIIl, llllllllllllllIIIIIlllllIlIllIII);
    }
    
    @Override
    public void updatePosition(final float llllllllllllllIIIIIlllllIlllIIll, final float llllllllllllllIIIIIlllllIlllIlIl) {
        this.setX(llllllllllllllIIIIIlllllIlllIIll + this.getOffsetX());
        this.setY(llllllllllllllIIIIIlllllIlllIlIl + this.getOffsetY());
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIIIlllllIllIlIlI, final int llllllllllllllIIIIIlllllIllIlIIl, final float llllllllllllllIIIIIlllllIllIIIlI) {
        final boolean llllllllllllllIIIIIlllllIllIIlll = this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight());
        this.textHoverAnimate = AnimUtils.moveUD(this.textHoverAnimate, (float)(llllllllllllllIIIIIlllllIllIIlll ? 4 : 2), 5.42E-4f);
        final MinecraftFontRenderer llllllllllllllIIIIIlllllIllIIllI = FontLoader.INSTANCE.consola_19;
        llllllllllllllIIIIIlllllIllIIllI.drawStringWithShadow(this.listen ? String.valueOf(new StringBuilder(String.valueOf(this.currentString)).append("_")) : (this.currentString.isEmpty() ? ((Component<Setting>)this).getObject().getdString() : this.currentString), (int)this.getX() + (int)this.textHoverAnimate, (int)this.getY() + 1, -1);
        super.drawScreen(llllllllllllllIIIIIlllllIllIlIlI, llllllllllllllIIIIIlllllIllIlIIl, llllllllllllllIIIIIlllllIllIIIlI);
    }
    
    @Override
    public boolean isVisible() {
        return ((Component<Setting>)this).getObject().isVisible();
    }
    
    @Override
    public void keyTyped(final char llllllllllllllIIIIIlllllIlIIIlIl, final int llllllllllllllIIIIIlllllIlIIIIll) {
        if (llllllllllllllIIIIIlllllIlIIIIll == 1) {
            return;
        }
        if (this.listen) {
            if (28 == llllllllllllllIIIIIlllllIlIIIIll) {
                this.enterString();
            }
            else if (llllllllllllllIIIIIlllllIlIIIIll == 14) {
                if (this.currentString != null) {
                    if (!this.currentString.isEmpty()) {
                        this.currentString = this.currentString.substring(0, this.currentString.length() - 1);
                    }
                }
                else {
                    this.listen = false;
                }
            }
            else if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIIIIIlllllIlIIIlIl)) {
                this.setString(String.valueOf(new StringBuilder(String.valueOf(this.currentString)).append(llllllllllllllIIIIIlllllIlIIIlIl)));
                System.out.println(String.valueOf(new StringBuilder("new string: ").append(this.currentString)));
            }
        }
    }
    
    public StringButton(final Setting llllllllllllllIIIIIllllllIIIIIlI, final CheatTypePanel llllllllllllllIIIIIllllllIIIIIIl, final float llllllllllllllIIIIIllllllIIIIIII, final float llllllllllllllIIIIIllllllIIIlIII, final float llllllllllllllIIIIIlllllIllllllI, final float llllllllllllllIIIIIlllllIlllllIl, final float llllllllllllllIIIIIllllllIIIIlIl, final float llllllllllllllIIIIIlllllIllllIll) {
        super(llllllllllllllIIIIIllllllIIIIIlI, llllllllllllllIIIIIllllllIIIIIIl, llllllllllllllIIIIIllllllIIIIIII, llllllllllllllIIIIIllllllIIIlIII, llllllllllllllIIIIIlllllIllllllI, llllllllllllllIIIIIlllllIlllllIl, llllllllllllllIIIIIllllllIIIIlIl, llllllllllllllIIIIIlllllIllllIll);
        this.textHoverAnimate = 0.0f;
        this.listen = false;
        this.currentString = "";
    }
    
    private void setString(final String llllllllllllllIIIIIlllllIIlllIIl) {
        this.currentString = llllllllllllllIIIIIlllllIIlllIIl;
    }
}
