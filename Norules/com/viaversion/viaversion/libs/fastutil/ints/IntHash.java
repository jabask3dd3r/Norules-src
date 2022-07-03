package com.viaversion.viaversion.libs.fastutil.ints;

public interface IntHash
{
    public interface Strategy
    {
        boolean equals(final int p0, final int p1);
        
        int hashCode(final int p0);
    }
}
