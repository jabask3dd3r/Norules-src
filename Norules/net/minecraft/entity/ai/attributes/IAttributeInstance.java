package net.minecraft.entity.ai.attributes;

import java.util.*;
import javax.annotation.*;

public interface IAttributeInstance
{
    void removeModifier(final AttributeModifier p0);
    
    void removeAllModifiers();
    
    boolean hasModifier(final AttributeModifier p0);
    
    Collection<AttributeModifier> getModifiersByOperation(final int p0);
    
    double getAttributeValue();
    
    @Nullable
    AttributeModifier getModifier(final UUID p0);
    
    double getBaseValue();
    
    void setBaseValue(final double p0);
    
    void removeModifier(final UUID p0);
    
    void applyModifier(final AttributeModifier p0);
    
    Collection<AttributeModifier> getModifiers();
    
    IAttribute getAttribute();
}
