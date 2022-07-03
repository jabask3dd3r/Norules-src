package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;

public class EventRender3D extends Event
{
    private /* synthetic */ int ix;
    private /* synthetic */ int x;
    private /* synthetic */ int iy;
    private /* synthetic */ boolean offset;
    private /* synthetic */ int y;
    private /* synthetic */ int iz;
    public /* synthetic */ float renderPartialTicks;
    private /* synthetic */ int z;
    
    public EventRender3D(final float lllllllllllllllIIlIIllIllIIlIlll, final int lllllllllllllllIIlIIllIllIIlIllI, final int lllllllllllllllIIlIIllIllIIlIlIl, final int lllllllllllllllIIlIIllIllIIlIlII) {
        this.renderPartialTicks = lllllllllllllllIIlIIllIllIIlIlll;
        this.x = lllllllllllllllIIlIIllIllIIlIllI;
        this.y = lllllllllllllllIIlIIllIllIIlIlIl;
        this.z = lllllllllllllllIIlIIllIllIIlIlII;
        this.ix = lllllllllllllllIIlIIllIllIIlIllI;
        this.iy = lllllllllllllllIIlIIllIllIIlIlIl;
        this.iz = lllllllllllllllIIlIIllIllIIlIlII;
    }
    
    public int getZ() {
        return this.z;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void reset() {
        this.x = this.ix;
        this.y = this.iy;
        this.z = this.iz;
        this.offset = false;
    }
    
    public void setZ(final int lllllllllllllllIIlIIllIlIllIIllI) {
        this.z = lllllllllllllllIIlIIllIlIllIIllI;
    }
    
    public float getPartialTicks() {
        return this.renderPartialTicks;
    }
    
    public boolean isOffset() {
        return this.offset;
    }
    
    public void setY(final int lllllllllllllllIIlIIllIlIllIllIl) {
        this.y = lllllllllllllllIIlIIllIlIllIllIl;
    }
    
    public void offset(final int lllllllllllllllIIlIIllIllIIIIlIl) {
        final double lllllllllllllllIIlIIllIllIIIlIIl = RenderManager.renderPosX;
        final double lllllllllllllllIIlIIllIllIIIlIII = RenderManager.renderPosY;
        final double lllllllllllllllIIlIIllIllIIIIlll = RenderManager.renderPosZ;
        if (lllllllllllllllIIlIIllIllIIIIlIl < 0) {
            GlStateManager.translate(-lllllllllllllllIIlIIllIllIIIlIIl, -lllllllllllllllIIlIIllIllIIIlIII, -lllllllllllllllIIlIIllIllIIIIlll);
            this.x -= (int)lllllllllllllllIIlIIllIllIIIlIIl;
            this.y -= (int)lllllllllllllllIIlIIllIllIIIlIII;
            this.z -= (int)lllllllllllllllIIlIIllIllIIIIlll;
            this.offset = true;
        }
        else if (lllllllllllllllIIlIIllIllIIIIlIl > 0) {
            GlStateManager.translate(lllllllllllllllIIlIIllIllIIIlIIl, lllllllllllllllIIlIIllIllIIIlIII, lllllllllllllllIIlIIllIllIIIIlll);
            this.x += (int)lllllllllllllllIIlIIllIllIIIlIIl;
            this.y += (int)lllllllllllllllIIlIIllIllIIIlIII;
            this.z += (int)lllllllllllllllIIlIIllIllIIIIlll;
            this.offset = true;
        }
    }
    
    public void setX(final int lllllllllllllllIIlIIllIlIllllIII) {
        this.x = lllllllllllllllIIlIIllIlIllllIII;
    }
    
    public int getX() {
        return this.x;
    }
}
