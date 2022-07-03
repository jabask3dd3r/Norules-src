package net.minecraft.block.properties;

import java.util.*;
import com.google.common.base.*;

public interface IProperty<T extends Comparable<T>>
{
    String getName();
    
    Class<T> getValueClass();
    
    Collection<T> getAllowedValues();
    
    Optional<T> parseValue(final String p0);
    
    String getName(final T p0);
}
