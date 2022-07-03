package com.viaversion.viaversion.api.protocol.remapper;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.exception.*;

public abstract class ValueTransformer<T1, T2> implements ValueWriter<T1>
{
    private final /* synthetic */ Type<T2> outputType;
    private final /* synthetic */ Type<T1> inputType;
    
    protected ValueTransformer(final Type<T1> llllllllllllllIlIIllIIIlIlIlIIlI, final Type<T2> llllllllllllllIlIIllIIIlIlIlIlII) {
        this.inputType = llllllllllllllIlIIllIIIlIlIlIIlI;
        this.outputType = llllllllllllllIlIIllIIIlIlIlIlII;
    }
    
    public Type<T2> getOutputType() {
        return this.outputType;
    }
    
    public Type<T1> getInputType() {
        return this.inputType;
    }
    
    @Override
    public void write(final PacketWrapper llllllllllllllIlIIllIIIlIlIIIIIl, final T1 llllllllllllllIlIIllIIIlIlIIIIII) throws Exception {
        try {
            llllllllllllllIlIIllIIIlIlIIIIIl.write(this.outputType, this.transform(llllllllllllllIlIIllIIIlIlIIIIIl, llllllllllllllIlIIllIIIlIlIIIIII));
        }
        catch (InformativeException llllllllllllllIlIIllIIIlIlIIIllI) {
            llllllllllllllIlIIllIIIlIlIIIllI.addSource(this.getClass());
            throw llllllllllllllIlIIllIIIlIlIIIllI;
        }
    }
    
    protected ValueTransformer(final Type<T2> llllllllllllllIlIIllIIIlIlIIllIl) {
        this(null, llllllllllllllIlIIllIIIlIlIIllIl);
    }
    
    public abstract T2 transform(final PacketWrapper p0, final T1 p1) throws Exception;
}
