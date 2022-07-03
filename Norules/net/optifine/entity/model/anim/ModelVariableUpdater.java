package net.optifine.entity.model.anim;

import optifine.*;

public class ModelVariableUpdater
{
    private /* synthetic */ IExpression expression;
    private /* synthetic */ ModelVariable modelVariable;
    private /* synthetic */ String modelVariableName;
    private /* synthetic */ String expressionText;
    
    public void update() {
        final float lllllllllllllIlllIIIIIIllIlIllII = this.expression.eval();
        this.modelVariable.setValue(lllllllllllllIlllIIIIIIllIlIllII);
    }
    
    public boolean initialize(final IModelResolver lllllllllllllIlllIIIIIIlllIlIlIl) {
        this.modelVariable = lllllllllllllIlllIIIIIIlllIlIlIl.getModelVariable(this.modelVariableName);
        if (this.modelVariable == null) {
            Config.warn(String.valueOf(new StringBuilder("Model variable not found: ").append(this.modelVariableName)));
            return false;
        }
        try {
            final ExpressionParser lllllllllllllIlllIIIIIIlllIlIIll = new ExpressionParser(lllllllllllllIlllIIIIIIlllIlIlIl);
            this.expression = lllllllllllllIlllIIIIIIlllIlIIll.parse(this.expressionText);
            return true;
        }
        catch (ParseException lllllllllllllIlllIIIIIIlllIlIIIl) {
            Config.warn(String.valueOf(new StringBuilder("Error parsing expression: ").append(this.expressionText)));
            Config.warn(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIIIIlllIlIIIl.getClass().getName())).append(": ").append(lllllllllllllIlllIIIIIIlllIlIIIl.getMessage())));
            return false;
        }
    }
    
    public ModelVariableUpdater(final String lllllllllllllIlllIIIIIIllIllllIl, final String lllllllllllllIlllIIIIIIllIllIlIl) {
        this.modelVariableName = lllllllllllllIlllIIIIIIllIllllIl;
        this.expressionText = lllllllllllllIlllIIIIIIllIllIlIl;
    }
}
