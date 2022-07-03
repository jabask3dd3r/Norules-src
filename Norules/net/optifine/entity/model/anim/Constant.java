package net.optifine.entity.model.anim;

public class Constant implements IExpression
{
    private /* synthetic */ float value;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.value));
    }
    
    @Override
    public float eval() {
        return this.value;
    }
    
    public Constant(final float lllllllllllllIlIlIIllllIlIIlIIlI) {
        this.value = lllllllllllllIlIlIIllllIlIIlIIlI;
    }
}
