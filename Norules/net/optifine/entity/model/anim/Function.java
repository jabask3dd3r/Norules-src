package net.optifine.entity.model.anim;

public class Function implements IExpression
{
    private /* synthetic */ IExpression[] arguments;
    private /* synthetic */ EnumFunctionType enumFunction;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.enumFunction).append("()"));
    }
    
    @Override
    public float eval() {
        return this.enumFunction.eval(this.arguments);
    }
    
    public Function(final EnumFunctionType llllllllllllllIIIIIlIIllIIllIlIl, final IExpression[] llllllllllllllIIIIIlIIllIIllIIIl) {
        this.enumFunction = llllllllllllllIIIIIlIIllIIllIlIl;
        this.arguments = llllllllllllllIIIIIlIIllIIllIIIl;
    }
}
