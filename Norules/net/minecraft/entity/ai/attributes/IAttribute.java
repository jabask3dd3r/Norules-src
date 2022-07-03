package net.minecraft.entity.ai.attributes;

import javax.annotation.*;

public interface IAttribute
{
    boolean getShouldWatch();
    
    String getAttributeUnlocalizedName();
    
    double getDefaultValue();
    
    double clampValue(final double p0);
    
    @Nullable
    IAttribute getParent();
}
