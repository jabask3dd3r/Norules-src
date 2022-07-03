package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;

public abstract class AbstractObject2ObjectFunction<K, V> implements Object2ObjectFunction<K, V>, Serializable
{
    protected /* synthetic */ V defRetValue;
    
    protected AbstractObject2ObjectFunction() {
    }
    
    @Override
    public V defaultReturnValue() {
        return this.defRetValue;
    }
    
    @Override
    public void defaultReturnValue(final V lllllllllllllIllIIlIllIIIlIIIlII) {
        this.defRetValue = lllllllllllllIllIIlIllIIIlIIIlII;
    }
}
