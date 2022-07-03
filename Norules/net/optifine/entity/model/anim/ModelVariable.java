package net.optifine.entity.model.anim;

import net.minecraft.client.model.*;

public class ModelVariable implements IExpression
{
    private /* synthetic */ String name;
    private /* synthetic */ EnumModelVariable enumModelVariable;
    private /* synthetic */ ModelRenderer modelRenderer;
    
    public float getValue() {
        return this.enumModelVariable.getFloat(this.modelRenderer);
    }
    
    @Override
    public float eval() {
        return this.getValue();
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public void setValue(final float llIlIllIIlIIIIl) {
        this.enumModelVariable.setFloat(this.modelRenderer, llIlIllIIlIIIIl);
    }
    
    public ModelVariable(final String llIlIllIIlIllll, final ModelRenderer llIlIllIIllIIlI, final EnumModelVariable llIlIllIIllIIIl) {
        this.name = llIlIllIIlIllll;
        this.modelRenderer = llIlIllIIllIIlI;
        this.enumModelVariable = llIlIllIIllIIIl;
    }
}
