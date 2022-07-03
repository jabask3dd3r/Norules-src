package com.viaversion.viaversion.api.protocol.remapper;

import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.exception.*;
import java.util.function.*;
import java.util.*;

public abstract class PacketRemapper
{
    private final /* synthetic */ List<PacketHandler> valueRemappers;
    
    public void map(final Type llllllllllllllllIIllIIIIIIIllIIl, final Type llllllllllllllllIIllIIIIIIIllIII) {
        this.handler(llllllllllllllllIIlIllllIlIlIlIl -> llllllllllllllllIIlIllllIlIlIlIl.write(llllllllllllllllIIllIIIIIIIllIII, (Object)llllllllllllllllIIlIllllIlIlIlIl.read((Type<T>)llllllllllllllllIIllIIIIIIIllIIl)));
    }
    
    public void remap(final PacketWrapper llllllllllllllllIIlIlllllIlIIIlI) throws Exception {
        try {
            for (final PacketHandler llllllllllllllllIIlIlllllIlIllII : this.valueRemappers) {
                llllllllllllllllIIlIlllllIlIllII.handle(llllllllllllllllIIlIlllllIlIIIlI);
            }
        }
        catch (CancelException llllllllllllllllIIlIlllllIlIlIlI) {
            throw llllllllllllllllIIlIlllllIlIlIlI;
        }
        catch (InformativeException llllllllllllllllIIlIlllllIlIlIII) {
            llllllllllllllllIIlIlllllIlIlIII.addSource(this.getClass());
            throw llllllllllllllllIIlIlllllIlIlIII;
        }
        catch (Exception llllllllllllllllIIlIlllllIlIIlIl) {
            final InformativeException llllllllllllllllIIlIlllllIlIIlll = new InformativeException(llllllllllllllllIIlIlllllIlIIlIl);
            llllllllllllllllIIlIlllllIlIIlll.addSource(this.getClass());
            throw llllllllllllllllIIlIlllllIlIIlll;
        }
    }
    
    public <T1, T2> void map(final Type<T1> llllllllllllllllIIllIIIIIIIIlIll, final Type<T2> llllllllllllllllIIllIIIIIIIIlIlI, final Function<T1, T2> llllllllllllllllIIllIIIIIIIIllIl) {
        this.map(llllllllllllllllIIllIIIIIIIIlIll, (ValueTransformer<T1, Object>)new ValueTransformer<T1, T2>(llllllllllllllllIIllIIIIIIIIlIlI) {
            @Override
            public T2 transform(final PacketWrapper lllllllllllllllIIIllllIlIIIlIllI, final T1 lllllllllllllllIIIllllIlIIIlIIll) throws Exception {
                return llllllllllllllllIIllIIIIIIIIllIl.apply(lllllllllllllllIIIllllIlIIIlIIll);
            }
        });
    }
    
    public void read(final Type llllllllllllllllIIlIlllllIllllIl) {
        this.handler(llllllllllllllllIIlIlllllIIIlIlI -> llllllllllllllllIIlIlllllIIIlIlI.read((Type<Object>)llllllllllllllllIIlIlllllIllllIl));
    }
    
    public abstract void registerMap();
    
    public <T> void map(final ValueReader<T> llllllllllllllllIIlIlllllllIllII, final ValueWriter<T> llllllllllllllllIIlIlllllllIlIll) {
        this.handler(llllllllllllllllIIlIllllIllIIlll -> llllllllllllllllIIlIlllllllIlIll.write(llllllllllllllllIIlIllllIllIIlll, llllllllllllllllIIlIlllllllIllII.read(llllllllllllllllIIlIllllIllIIlll)));
    }
    
    public <T1, T2> void map(final ValueTransformer<T1, T2> llllllllllllllllIIllIIIIIIIIIIll) {
        if (llllllllllllllllIIllIIIIIIIIIIll.getInputType() == null) {
            throw new IllegalArgumentException("Use map(Type<T1>, ValueTransformer<T1, T2>) for value transformers without specified input type!");
        }
        this.map(llllllllllllllllIIllIIIIIIIIIIll.getInputType(), llllllllllllllllIIllIIIIIIIIIIll);
    }
    
    protected PacketRemapper() {
        this.valueRemappers = new ArrayList<PacketHandler>();
        this.registerMap();
    }
    
    public <T1, T2> void map(final Type<T1> llllllllllllllllIIlIlllllllllIll, final ValueTransformer<T1, T2> llllllllllllllllIIlIllllllllIlII) {
        this.map(new TypeRemapper<T1>(llllllllllllllllIIlIlllllllllIll), llllllllllllllllIIlIllllllllIlII);
    }
    
    public void map(final Type llllllllllllllllIIllIIIIIIIllllI) {
        this.handler(llllllllllllllllIIlIllllIlIIllIl -> llllllllllllllllIIlIllllIlIIllIl.write(llllllllllllllllIIllIIIIIIIllllI, (T)llllllllllllllllIIlIllllIlIIllIl.read((Type<T>)llllllllllllllllIIllIIIIIIIllllI)));
    }
    
    public <T> void create(final Type<T> llllllllllllllllIIlIllllllIlIIII, final T llllllllllllllllIIlIllllllIIlllI) {
        this.handler(llllllllllllllllIIlIllllIlllllll -> llllllllllllllllIIlIllllIlllllll.write(llllllllllllllllIIlIllllllIlIIII, llllllllllllllllIIlIllllllIIlllI));
    }
    
    public void handler(final PacketHandler llllllllllllllllIIlIlllllllIIlIl) {
        this.valueRemappers.add(llllllllllllllllIIlIlllllllIIlIl);
    }
}
