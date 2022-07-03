package clickui.panel;

import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import me.nrules.utils.player.*;
import me.nrules.utils.render.*;

public class Panel
{
    private /* synthetic */ float y;
    private /* synthetic */ boolean expand;
    private /* synthetic */ ScaledResolution resolution;
    private /* synthetic */ float lastX;
    private /* synthetic */ float x;
    private /* synthetic */ float lastY;
    private /* synthetic */ boolean dragging;
    private /* synthetic */ float width;
    private /* synthetic */ float height;
    private /* synthetic */ float xAnimate;
    private /* synthetic */ float yAnimate;
    
    public void mouseClicked(final int llllllllllllllIllIIIlIIIllIllIII, final int llllllllllllllIllIIIlIIIllIlIlll, final int llllllllllllllIllIIIlIIIllIlIllI) {
        if (this.isHovered(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + 14.0f)) {
            if (llllllllllllllIllIIIlIIIllIlIllI == 0) {
                this.setDragging(true);
                this.setLastX(this.getX() - llllllllllllllIllIIIlIIIllIllIII);
                this.setLastY(this.getY() - llllllllllllllIllIIIlIIIllIlIlll);
            }
            if (llllllllllllllIllIIIlIIIllIlIllI == 1) {
                this.setExpand(!this.isExpand());
            }
        }
    }
    
    public void setDragging(final boolean llllllllllllllIllIIIlIIIlIIIlIIl) {
        this.dragging = llllllllllllllIllIIIlIIIlIIIlIIl;
    }
    
    public float getY() {
        return this.y;
    }
    
    public Panel(final float llllllllllllllIllIIIlIIIlllIlllI, final float llllllllllllllIllIIIlIIIllllIIlI, final float llllllllllllllIllIIIlIIIllllIIIl, final float llllllllllllllIllIIIlIIIllllIIII) {
        this.resolution = new ScaledResolution(Minecraft.getMinecraft());
        this.xAnimate = 0.0f;
        this.yAnimate = 0.0f;
        this.x = llllllllllllllIllIIIlIIIlllIlllI;
        this.y = llllllllllllllIllIIIlIIIllllIIlI;
        this.width = llllllllllllllIllIIIlIIIllllIIIl;
        this.height = llllllllllllllIllIIIlIIIllllIIII;
    }
    
    public boolean isHovered(final float llllllllllllllIllIIIlIIIIlllIIIl, final float llllllllllllllIllIIIlIIIIlllIIII, final float llllllllllllllIllIIIlIIIIlllIIll, final float llllllllllllllIllIIIlIIIIlllIIlI) {
        return MouseUtil.INSTANCE.isHovered(llllllllllllllIllIIIlIIIIlllIIIl, llllllllllllllIllIIIlIIIIlllIIII, llllllllllllllIllIIIlIIIIlllIIll, llllllllllllllIllIIIlIIIIlllIIlI);
    }
    
    public void setHeight(final float llllllllllllllIllIIIlIIIlIlIIIlI) {
        this.height = llllllllllllllIllIIIlIIIlIlIIIlI;
    }
    
    public void setY(final float llllllllllllllIllIIIlIIIlIllIlII) {
        this.y = llllllllllllllIllIIIlIIIlIllIlII;
    }
    
    public boolean isDragging() {
        return this.dragging;
    }
    
    public void updatePosition(final float llllllllllllllIllIIIlIIIlllIlIIl, final float llllllllllllllIllIIIlIIIlllIlIII) {
    }
    
    public void setX(final float llllllllllllllIllIIIlIIIlIllllll) {
        this.x = llllllllllllllIllIIIlIIIlIllllll;
    }
    
    public float getWidth() {
        return this.width;
    }
    
    public void setWidth(final float llllllllllllllIllIIIlIIIlIlIlIll) {
        this.width = llllllllllllllIllIIIlIIIlIlIlIll;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public void mouseReleased(final int llllllllllllllIllIIIlIIIllIIlllI, final int llllllllllllllIllIIIlIIIllIIllIl, final int llllllllllllllIllIIIlIIIllIIllII) {
        if (this.isDragging() && llllllllllllllIllIIIlIIIllIIllII == 0) {
            this.setDragging(false);
        }
    }
    
    public float getX() {
        return this.x;
    }
    
    public void setLastY(final float llllllllllllllIllIIIlIIIlIIlIIlI) {
        this.lastY = llllllllllllllIllIIIlIIIlIIlIIlI;
    }
    
    public void setLastX(final float llllllllllllllIllIIIlIIIlIIllIll) {
        this.lastX = llllllllllllllIllIIIlIIIlIIllIll;
    }
    
    public void drawScreen(final int llllllllllllllIllIIIlIIIllIlllll, final int llllllllllllllIllIIIlIIIllIllllI, final float llllllllllllllIllIIIlIIIlllIIIIl) {
        this.resolution = new ScaledResolution(Minecraft.getMinecraft());
        if (this.isDragging()) {
            this.xAnimate = AnimUtils.moveUD(this.getX(), llllllllllllllIllIIIlIIIllIlllll + this.getLastX(), 5.42E-4f);
            this.yAnimate = AnimUtils.moveUD(this.getY(), llllllllllllllIllIIIlIIIllIllllI + this.getLastY(), 5.42E-4f);
            this.setX(this.xAnimate);
            this.setY(this.yAnimate);
            if (this.getX() < 0.0f) {
                this.setX(0.0f);
            }
            if (this.getY() < 0.0f) {
                this.setY(0.0f);
            }
            if (this.getX() + this.getWidth() > this.getResolution().getScaledWidth()) {
                this.setX(this.getResolution().getScaledWidth() - this.getWidth());
            }
            if (this.getY() + this.getHeight() > this.getResolution().getScaledHeight()) {
                this.setY(this.getResolution().getScaledHeight() - this.getHeight());
            }
            this.updatePosition(this.getX(), this.getY());
        }
    }
    
    public float getLastX() {
        return this.lastX;
    }
    
    public ScaledResolution getResolution() {
        return this.resolution;
    }
    
    public void setExpand(final boolean llllllllllllllIllIIIlIIIIllllllI) {
        this.expand = llllllllllllllIllIIIlIIIIllllllI;
    }
    
    public void handleMouseInput() {
    }
    
    public boolean isExpand() {
        return this.expand;
    }
    
    public float getLastY() {
        return this.lastY;
    }
    
    public void keyTyped(final char llllllllllllllIllIIIlIIIllIIIlll, final int llllllllllllllIllIIIlIIIllIIIllI) {
    }
}
