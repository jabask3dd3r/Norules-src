package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;

public abstract class AbstractInt2ObjectFunction<V> implements Int2ObjectFunction<V>, Serializable
{
    protected /* synthetic */ V defRetValue;
    
    @Override
    public V defaultReturnValue() {
        return this.defRetValue;
    }
    
    protected AbstractInt2ObjectFunction() {
    }
    
    @Override
    public void defaultReturnValue(final V llllllllllllllIIIllllIllllIlllII) {
        this.defRetValue = llllllllllllllIIIllllIllllIlllII;
    }
}
