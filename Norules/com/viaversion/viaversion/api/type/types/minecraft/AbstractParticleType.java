package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public abstract class AbstractParticleType extends Type<Particle>
{
    protected final /* synthetic */ Int2ObjectMap<ParticleReader> readers;
    
    protected ParticleReader vibrationHandler(final Type<Position> llllllllllllllIIllIIllIlIllIIIII) {
        final String llllllllllllllIIllIIllIlIlIIlIll;
        return (llllllllllllllIIllIIllIlIlIIllIl, llllllllllllllIIllIIllIlIlIIlIII) -> {
            llllllllllllllIIllIIllIlIlIIlIII.getArguments().add(new Particle.ParticleData(llllllllllllllIIllIIllIlIllIIIII, llllllllllllllIIllIIllIlIllIIIII.read(llllllllllllllIIllIIllIlIlIIllIl)));
            llllllllllllllIIllIIllIlIlIIlIll = (String)Type.STRING.read(llllllllllllllIIllIIllIlIlIIllIl);
            if (llllllllllllllIIllIIllIlIlIIlIll.equals("block")) {
                llllllllllllllIIllIIllIlIlIIlIII.getArguments().add(new Particle.ParticleData(llllllllllllllIIllIIllIlIllIIIII, llllllllllllllIIllIIllIlIllIIIII.read(llllllllllllllIIllIIllIlIlIIllIl)));
            }
            else if (llllllllllllllIIllIIllIlIlIIlIll.equals("entity")) {
                llllllllllllllIIllIIllIlIlIIlIII.getArguments().add(new Particle.ParticleData(Type.VAR_INT, Type.VAR_INT.readPrimitive(llllllllllllllIIllIIllIlIlIIllIl)));
            }
            else {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unknown vibration path position source type: ").append(llllllllllllllIIllIIllIlIlIIlIll)));
            }
            llllllllllllllIIllIIllIlIlIIlIII.getArguments().add(new Particle.ParticleData(Type.VAR_INT, Type.VAR_INT.readPrimitive(llllllllllllllIIllIIllIlIlIIllIl)));
        };
    }
    
    protected AbstractParticleType() {
        super("Particle", Particle.class);
        this.readers = new Int2ObjectOpenHashMap<ParticleReader>();
    }
    
    protected ParticleReader blockHandler() {
        return (llllllllllllllIIllIIllIlIIlIllIl, llllllllllllllIIllIIllIlIIlIllII) -> llllllllllllllIIllIIllIlIIlIllII.getArguments().add(new Particle.ParticleData(Type.VAR_INT, Type.VAR_INT.readPrimitive(llllllllllllllIIllIIllIlIIlIllIl)));
    }
    
    @Override
    public Particle read(final ByteBuf llllllllllllllIIllIIllIlIllIllIl) throws Exception {
        final int llllllllllllllIIllIIllIlIlllIIIl = Type.VAR_INT.readPrimitive(llllllllllllllIIllIIllIlIllIllIl);
        final Particle llllllllllllllIIllIIllIlIlllIIII = new Particle(llllllllllllllIIllIIllIlIlllIIIl);
        final ParticleReader llllllllllllllIIllIIllIlIllIllll = this.readers.get(llllllllllllllIIllIIllIlIlllIIIl);
        if (llllllllllllllIIllIIllIlIllIllll != null) {
            llllllllllllllIIllIIllIlIllIllll.read(llllllllllllllIIllIIllIlIllIllIl, llllllllllllllIIllIIllIlIlllIIII);
        }
        return llllllllllllllIIllIIllIlIlllIIII;
    }
    
    protected ParticleReader dustHandler() {
        return (llllllllllllllIIllIIllIlIIlllllI, llllllllllllllIIllIIllIlIIlllIll) -> {
            llllllllllllllIIllIIllIlIIlllIll.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIIlllllI)));
            llllllllllllllIIllIIllIlIIlllIll.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIIlllllI)));
            llllllllllllllIIllIIllIlIIlllIll.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIIlllllI)));
            llllllllllllllIIllIIllIlIIlllIll.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIIlllllI)));
        };
    }
    
    protected ParticleReader itemHandler(final Type<Item> llllllllllllllIIllIIllIlIllIIlIl) {
        return (llllllllllllllIIllIIllIlIIllIIll, llllllllllllllIIllIIllIlIIllIIlI) -> llllllllllllllIIllIIllIlIIllIIlI.getArguments().add(new Particle.ParticleData(llllllllllllllIIllIIllIlIllIIlIl, llllllllllllllIIllIIllIlIllIIlIl.read(llllllllllllllIIllIIllIlIIllIIll)));
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIllIIllIlIllllllI, final Particle llllllllllllllIIllIIllIlIllllIll) throws Exception {
        Type.VAR_INT.writePrimitive(llllllllllllllIIllIIllIlIllllllI, llllllllllllllIIllIIllIlIllllIll.getId());
        for (final Particle.ParticleData llllllllllllllIIllIIllIllIIIIIII : llllllllllllllIIllIIllIlIllllIll.getArguments()) {
            llllllllllllllIIllIIllIllIIIIIII.getType().write(llllllllllllllIIllIIllIlIllllllI, llllllllllllllIIllIIllIllIIIIIII.getValue());
        }
    }
    
    protected ParticleReader dustTransitionHandler() {
        return (llllllllllllllIIllIIllIlIlIIIlII, llllllllllllllIIllIIllIlIlIIIIIl) -> {
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
            llllllllllllllIIllIIllIlIlIIIIIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(llllllllllllllIIllIIllIlIlIIIlII)));
        };
    }
    
    @FunctionalInterface
    public interface ParticleReader
    {
        void read(final ByteBuf p0, final Particle p1) throws Exception;
    }
}
