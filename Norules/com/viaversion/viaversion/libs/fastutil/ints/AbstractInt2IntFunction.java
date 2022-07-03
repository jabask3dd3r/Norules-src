package com.viaversion.viaversion.libs.fastutil.ints;

import java.io.*;

public abstract class AbstractInt2IntFunction implements Int2IntFunction, Serializable
{
    protected /* synthetic */ int defRetValue;
    
    @Override
    public void defaultReturnValue(final int lllllllllllllIllIIlllIIIIllllIlI) {
        this.defRetValue = lllllllllllllIllIIlllIIIIllllIlI;
    }
    
    protected AbstractInt2IntFunction() {
    }
    
    @Override
    public int defaultReturnValue() {
        return this.defRetValue;
    }
}
