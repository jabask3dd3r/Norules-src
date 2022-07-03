package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;

public class GuiLockIconButton extends GuiButton
{
    private /* synthetic */ boolean locked;
    
    public void func_191745_a(final Minecraft lllllllllllllIlIlllIIIIIIlllIIlI, final int lllllllllllllIlIlllIIIIIIlllllIl, final int lllllllllllllIlIlllIIIIIIlllIIII, final float lllllllllllllIlIlllIIIIIIllllIll) {
        if (this.visible) {
            lllllllllllllIlIlllIIIIIIlllIIlI.getTextureManager().bindTexture(GuiButton.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final boolean lllllllllllllIlIlllIIIIIIllllIlI = lllllllllllllIlIlllIIIIIIlllllIl >= this.xPosition && lllllllllllllIlIlllIIIIIIlllIIII >= this.yPosition && lllllllllllllIlIlllIIIIIIlllllIl < this.xPosition + this.width && lllllllllllllIlIlllIIIIIIlllIIII < this.yPosition + this.height;
            Icon lllllllllllllIlIlllIIIIIIlllIlII = null;
            if (this.locked) {
                if (!this.enabled) {
                    final Icon lllllllllllllIlIlllIIIIIIllllIIl = Icon.LOCKED_DISABLED;
                }
                else if (lllllllllllllIlIlllIIIIIIllllIlI) {
                    final Icon lllllllllllllIlIlllIIIIIIllllIII = Icon.LOCKED_HOVER;
                }
                else {
                    final Icon lllllllllllllIlIlllIIIIIIlllIlll = Icon.LOCKED;
                }
            }
            else if (!this.enabled) {
                final Icon lllllllllllllIlIlllIIIIIIlllIllI = Icon.UNLOCKED_DISABLED;
            }
            else if (lllllllllllllIlIlllIIIIIIllllIlI) {
                final Icon lllllllllllllIlIlllIIIIIIlllIlIl = Icon.UNLOCKED_HOVER;
            }
            else {
                lllllllllllllIlIlllIIIIIIlllIlII = Icon.UNLOCKED;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllIlIlllIIIIIIlllIlII.getX(), lllllllllllllIlIlllIIIIIIlllIlII.getY(), this.width, this.height);
        }
    }
    
    public void setLocked(final boolean lllllllllllllIlIlllIIIIIlIIIlIII) {
        this.locked = lllllllllllllIlIlllIIIIIlIIIlIII;
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public GuiLockIconButton(final int lllllllllllllIlIlllIIIIIlIIlIlIl, final int lllllllllllllIlIlllIIIIIlIIlIlII, final int lllllllllllllIlIlllIIIIIlIIlIIll) {
        super(lllllllllllllIlIlllIIIIIlIIlIlIl, lllllllllllllIlIlllIIIIIlIIlIlII, lllllllllllllIlIlllIIIIIlIIlIIll, 20, 20, "");
    }
    
    enum Icon
    {
        private final /* synthetic */ int x;
        
        UNLOCKED_HOVER("UNLOCKED_HOVER", 4, 20, 166), 
        UNLOCKED_DISABLED("UNLOCKED_DISABLED", 5, 20, 186), 
        LOCKED_DISABLED("LOCKED_DISABLED", 2, 0, 186), 
        LOCKED_HOVER("LOCKED_HOVER", 1, 0, 166);
        
        private final /* synthetic */ int y;
        
        UNLOCKED("UNLOCKED", 3, 20, 146), 
        LOCKED("LOCKED", 0, 0, 146);
        
        public int getX() {
            return this.x;
        }
        
        private Icon(final String llllllllllllIlllllIIlIlIlIIlIllI, final int llllllllllllIlllllIIlIlIlIIlIlIl, final int llllllllllllIlllllIIlIlIlIIllIIl, final int llllllllllllIlllllIIlIlIlIIlIIll) {
            this.x = llllllllllllIlllllIIlIlIlIIllIIl;
            this.y = llllllllllllIlllllIIlIlIlIIlIIll;
        }
        
        public int getY() {
            return this.y;
        }
    }
}
