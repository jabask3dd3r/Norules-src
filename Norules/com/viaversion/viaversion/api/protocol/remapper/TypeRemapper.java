package com.viaversion.viaversion.api.protocol.remapper;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class TypeRemapper<T> implements ValueReader<T>, ValueWriter<T>
{
    private final /* synthetic */ Type<T> type;
    
    public TypeRemapper(final Type<T> llllllllllllllIllIIIlIllIlIlIllI) {
        this.type = llllllllllllllIllIIIlIllIlIlIllI;
    }
    
    @Override
    public void write(final PacketWrapper llllllllllllllIllIIIlIllIlIIIllI, final T llllllllllllllIllIIIlIllIlIIlIII) {
        llllllllllllllIllIIIlIllIlIIIllI.write(this.type, llllllllllllllIllIIIlIllIlIIlIII);
    }
    
    @Override
    public T read(final PacketWrapper llllllllllllllIllIIIlIllIlIIlllI) throws Exception {
        return llllllllllllllIllIIIlIllIlIIlllI.read(this.type);
    }
}
