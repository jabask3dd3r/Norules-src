package net.optifine.entity.model;

import net.minecraft.util.*;

public interface IEntityRenderer
{
    void setLocationTextureCustom(final ResourceLocation p0);
    
    void setEntityClass(final Class p0);
    
    Class getEntityClass();
    
    ResourceLocation getLocationTextureCustom();
}
