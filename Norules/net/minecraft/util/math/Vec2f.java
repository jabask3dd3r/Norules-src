package net.minecraft.util.math;

public class Vec2f
{
    public final /* synthetic */ float x;
    public final /* synthetic */ float y;
    
    public Vec2f(final float lllllllllllllIIlIIlIIlIlIIIIlIll, final float lllllllllllllIIlIIlIIlIlIIIIlIlI) {
        this.x = lllllllllllllIIlIIlIIlIlIIIIlIll;
        this.y = lllllllllllllIIlIIlIIlIlIIIIlIlI;
    }
    
    static {
        ZERO = new Vec2f(0.0f, 0.0f);
        ONE = new Vec2f(1.0f, 1.0f);
        UNIT_X = new Vec2f(1.0f, 0.0f);
        NEGATIVE_UNIT_X = new Vec2f(-1.0f, 0.0f);
        UNIT_Y = new Vec2f(0.0f, 1.0f);
        NEGATIVE_UNIT_Y = new Vec2f(0.0f, -1.0f);
        MAX = new Vec2f(Float.MAX_VALUE, Float.MAX_VALUE);
        MIN = new Vec2f(Float.MIN_VALUE, Float.MIN_VALUE);
    }
}
