package me.nrules.utils.render;

import javax.vecmath.*;
import java.util.concurrent.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;

public class Particle
{
    private /* synthetic */ float size;
    private final /* synthetic */ int maxAlpha;
    private /* synthetic */ Vector2f pos;
    private /* synthetic */ Vector2f velocity;
    private /* synthetic */ int alpha;
    private /* synthetic */ Vector2f acceleration;
    
    public int getAlpha() {
        return this.alpha;
    }
    
    public Vector2f getPos() {
        return this.pos;
    }
    
    public void update() {
        if (this.alpha < this.maxAlpha) {
            this.alpha += 8;
        }
        if (this.acceleration.getX() > 0.35f) {
            this.acceleration.setX(this.acceleration.getX() * 0.975f);
        }
        else if (this.acceleration.getX() < -0.35f) {
            this.acceleration.setX(this.acceleration.getX() * 0.975f);
        }
        if (this.acceleration.getY() > 0.35f) {
            this.acceleration.setY(this.acceleration.getY() * 0.975f);
        }
        else if (this.acceleration.getY() < -0.35f) {
            this.acceleration.setY(this.acceleration.getY() * 0.975f);
        }
        this.pos.add(this.acceleration);
        this.pos.add(this.velocity);
    }
    
    public void setAlpha(final int lllllllllllllIIlllIllIlIIlIIllIl) {
        this.alpha = lllllllllllllIIlllIllIlIIlIIllIl;
    }
    
    public void setVelocity(final Vector2f lllllllllllllIIlllIllIlIIlIlllIl) {
        this.velocity = lllllllllllllIIlllIllIlIIlIlllIl;
    }
    
    public void setSize(final float lllllllllllllIIlllIllIlIIlIIIIlI) {
        this.size = lllllllllllllIIlllIllIlIIlIIIIlI;
    }
    
    public Particle(final Vector2f lllllllllllllIIlllIllIlIlIIlIlll) {
        this.pos = lllllllllllllIIlllIllIlIlIIlIlll;
        final int lllllllllllllIIlllIllIlIlIIlIllI = -1;
        final int lllllllllllllIIlllIllIlIlIIlIlIl = 1;
        final float lllllllllllllIIlllIllIlIlIIlIlII = lllllllllllllIIlllIllIlIlIIlIllI + ThreadLocalRandom.current().nextFloat() * (lllllllllllllIIlllIllIlIlIIlIlIl - lllllllllllllIIlllIllIlIlIIlIllI);
        final float lllllllllllllIIlllIllIlIlIIlIIll = lllllllllllllIIlllIllIlIlIIlIllI + ThreadLocalRandom.current().nextFloat() * (lllllllllllllIIlllIllIlIlIIlIlIl - lllllllllllllIIlllIllIlIlIIlIllI);
        this.velocity = new Vector2f(lllllllllllllIIlllIllIlIlIIlIlII, lllllllllllllIIlllIllIlIlIIlIIll);
        this.acceleration = new Vector2f(0.0f, 0.35f);
        this.alpha = 0;
        this.maxAlpha = ThreadLocalRandom.current().nextInt(32, 192);
        this.size = 0.5f + ThreadLocalRandom.current().nextFloat() * 1.5f;
    }
    
    public void setPos(final Vector2f lllllllllllllIIlllIllIlIIllIIllI) {
        this.pos = lllllllllllllIIlllIllIlIIllIIllI;
    }
    
    public void setAcceleration(final Vector2f lllllllllllllIIlllIllIlIIlIlIlII) {
        this.acceleration = lllllllllllllIIlllIllIlIIlIlIlII;
    }
    
    public void respawn(final ScaledResolution lllllllllllllIIlllIllIlIlIIIIlll) {
        this.pos = new Vector2f((float)(Math.random() * lllllllllllllIIlllIllIlIlIIIIlll.getScaledWidth()), (float)(Math.random() * lllllllllllllIIlllIllIlIlIIIIlll.getScaledHeight()));
    }
    
    public static int changeAlpha(int lllllllllllllIIlllIllIlIIllIllIl, final int lllllllllllllIIlllIllIlIIllIllII) {
        lllllllllllllIIlllIllIlIIllIllIl &= 0xFFFFFF;
        return lllllllllllllIIlllIllIlIIllIllII << 24 | lllllllllllllIIlllIllIlIIllIllIl;
    }
    
    public float getSize() {
        return this.size;
    }
    
    public void render(final int lllllllllllllIIlllIllIlIIllllIII, final int lllllllllllllIIlllIllIlIIlllIlll) {
        if (Mouse.isButtonDown(0)) {
            final float lllllllllllllIIlllIllIlIIllllIll = lllllllllllllIIlllIllIlIIllllIII - this.pos.getX();
            final float lllllllllllllIIlllIllIlIIllllIlI = lllllllllllllIIlllIllIlIIlllIlll - this.pos.getY();
            if (Math.abs(lllllllllllllIIlllIllIlIIllllIll) < 50.0f && Math.abs(lllllllllllllIIlllIllIlIIllllIlI) < 50.0f) {
                this.acceleration.setX(this.acceleration.getX() + lllllllllllllIIlllIllIlIIllllIll * 0.0015f);
                this.acceleration.setY(this.acceleration.getY() + lllllllllllllIIlllIllIlIIllllIlI * 0.0015f);
            }
        }
        RenderUtils.drawRect(this.pos.x, this.pos.y, this.pos.x + this.size, this.pos.y + this.size, changeAlpha(-6749970, this.alpha));
    }
    
    public Vector2f getAcceleration() {
        return this.acceleration;
    }
    
    public Vector2f getVelocity() {
        return this.velocity;
    }
}
