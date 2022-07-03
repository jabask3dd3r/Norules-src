package com.viaversion.viaversion.libs.fastutil;

public interface Hash
{
    public interface Strategy<K>
    {
        boolean equals(final K p0, final K p1);
        
        int hashCode(final K p0);
    }
}
