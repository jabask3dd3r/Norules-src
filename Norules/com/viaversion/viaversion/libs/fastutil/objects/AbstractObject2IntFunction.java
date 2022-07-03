package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;

public abstract class AbstractObject2IntFunction<K> implements Object2IntFunction<K>, Serializable
{
    protected /* synthetic */ int defRetValue;
    
    protected AbstractObject2IntFunction() {
    }
    
    @Override
    public int defaultReturnValue() {
        return this.defRetValue;
    }
    
    @Override
    public void defaultReturnValue(final int lllllllllllllllIIlIlIlIIlIIlIlIl) {
        this.defRetValue = lllllllllllllllIIlIlIlIIlIIlIlIl;
    }
}
