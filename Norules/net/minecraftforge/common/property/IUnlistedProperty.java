package net.minecraftforge.common.property;

public interface IUnlistedProperty<V>
{
    boolean isValid(final V p0);
    
    String valueToString(final V p0);
    
    Class<V> getType();
    
    String getName();
}
