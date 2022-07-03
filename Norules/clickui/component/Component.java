package clickui.component;

import me.nrules.utils.player.*;

public abstract class Component<T>
{
    private /* synthetic */ float staticY;
    private /* synthetic */ float height;
    private /* synthetic */ float offsetX;
    private /* synthetic */ float x;
    private /* synthetic */ float staticX;
    private /* synthetic */ float width;
    private /* synthetic */ float y;
    private /* synthetic */ float offsetY;
    private /* synthetic */ T object;
    
    public boolean isHovered(final float lllllllllllllIIIIlIlllllIlIlllIl, final float lllllllllllllIIIIlIlllllIlIlllII, final float lllllllllllllIIIIlIlllllIlIllIll, final float lllllllllllllIIIIlIlllllIlIllIlI) {
        return MouseUtil.INSTANCE.isHovered(lllllllllllllIIIIlIlllllIlIlllIl, lllllllllllllIIIIlIlllllIlIlllII, lllllllllllllIIIIlIlllllIlIllIll, lllllllllllllIIIIlIlllllIlIllIlI);
    }
    
    public float getWidth() {
        return this.width;
    }
    
    public float getStaticX() {
        return this.staticX;
    }
    
    public void handleMouseInput() {
    }
    
    public void setY(final float lllllllllllllIIIIlIllllllIIlllIl) {
        this.y = lllllllllllllIIIIlIllllllIIlllIl;
    }
    
    public void mouseClicked(final int lllllllllllllIIIIlIlllllllIIIIlI, final int lllllllllllllIIIIlIlllllllIIIIIl, final int lllllllllllllIIIIlIlllllllIIIIII) {
    }
    
    public void drawScreen(final int lllllllllllllIIIIlIlllllllIIIllI, final int lllllllllllllIIIIlIlllllllIIIlIl, final float lllllllllllllIIIIlIlllllllIIIlII) {
    }
    
    public void setOffsetY(final float lllllllllllllIIIIlIlllllIllIlIIl) {
        this.offsetY = lllllllllllllIIIIlIlllllIllIlIIl;
    }
    
    public void setStaticX(final float lllllllllllllIIIIlIllllllIIlIllI) {
        this.staticX = lllllllllllllIIIIlIllllllIIlIllI;
    }
    
    public void setHeight(final float lllllllllllllIIIIlIlllllIllllIll) {
        this.height = lllllllllllllIIIIlIlllllIllllIll;
    }
    
    public void setWidth(final float lllllllllllllIIIIlIllllllIIIIIlI) {
        this.width = lllllllllllllIIIIlIllllllIIIIIlI;
    }
    
    public abstract void updatePosition(final float p0, final float p1);
    
    public void setX(final float lllllllllllllIIIIlIllllllIlIIllI) {
        this.x = lllllllllllllIIIIlIllllllIlIIllI;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public void mouseReleased(final int lllllllllllllIIIIlIllllllIlllllI, final int lllllllllllllIIIIlIllllllIllllIl, final int lllllllllllllIIIIlIllllllIllllII) {
    }
    
    public float getY() {
        return this.y;
    }
    
    public Component(final T lllllllllllllIIIIlIlllllllIIlllI, final float lllllllllllllIIIIlIlllllllIlIlIl, final float lllllllllllllIIIIlIlllllllIlIlII, final float lllllllllllllIIIIlIlllllllIlIIll, final float lllllllllllllIIIIlIlllllllIlIIlI, final float lllllllllllllIIIIlIlllllllIIlIIl, final float lllllllllllllIIIIlIlllllllIIlIII) {
        this.object = lllllllllllllIIIIlIlllllllIIlllI;
        this.x = lllllllllllllIIIIlIlllllllIlIlIl + lllllllllllllIIIIlIlllllllIIlIIl;
        this.y = lllllllllllllIIIIlIlllllllIlIlII + lllllllllllllIIIIlIlllllllIIlIII;
        this.staticX = lllllllllllllIIIIlIlllllllIlIlIl;
        this.staticY = lllllllllllllIIIIlIlllllllIlIlII;
        this.width = lllllllllllllIIIIlIlllllllIlIIll;
        this.height = lllllllllllllIIIIlIlllllllIlIIlI;
        this.offsetX = lllllllllllllIIIIlIlllllllIIlIIl;
        this.offsetY = lllllllllllllIIIIlIlllllllIIlIII;
    }
    
    public float getStaticY() {
        return this.staticY;
    }
    
    public T getObject() {
        return this.object;
    }
    
    public float getX() {
        return this.x;
    }
    
    public float getOffsetY() {
        return this.offsetY;
    }
    
    public void setStaticY(final float lllllllllllllIIIIlIllllllIIIllIl) {
        this.staticY = lllllllllllllIIIIlIllllllIIIllIl;
    }
    
    public void setObject(final T lllllllllllllIIIIlIllllllIllIIIl) {
        this.object = lllllllllllllIIIIlIllllllIllIIIl;
    }
    
    public void keyTyped(final char lllllllllllllIIIIlIllllllIlllIIl, final int lllllllllllllIIIIlIllllllIlllIII) {
    }
    
    public float getOffsetX() {
        return this.offsetX;
    }
    
    public void setOffsetX(final float lllllllllllllIIIIlIlllllIlllIIlI) {
        this.offsetX = lllllllllllllIIIIlIlllllIlllIIlI;
    }
}
