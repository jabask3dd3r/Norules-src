package net.optifine.entity.model.anim;

import net.minecraft.client.model.*;

public interface IModelResolver
{
    ModelVariable getModelVariable(final String p0);
    
    ModelRenderer getModelRenderer(final String p0);
    
    IExpression getExpression(final String p0);
}
