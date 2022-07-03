package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.*;
import io.netty.buffer.*;

public class Particle1_13_2Type extends Type<Particle>
{
    @Override
    public Particle read(final ByteBuf lllllllllllllIlIIIIIlIIllllIIlII) throws Exception {
        final int lllllllllllllIlIIIIIlIIllllIIllI = Type.VAR_INT.readPrimitive(lllllllllllllIlIIIIIlIIllllIIlII);
        final Particle lllllllllllllIlIIIIIlIIllllIIlIl = new Particle(lllllllllllllIlIIIIIlIIllllIIllI);
        switch (lllllllllllllIlIIIIIlIIllllIIllI) {
            case 3:
            case 20: {
                lllllllllllllIlIIIIIlIIllllIIlIl.getArguments().add(new Particle.ParticleData(Type.VAR_INT, Type.VAR_INT.readPrimitive(lllllllllllllIlIIIIIlIIllllIIlII)));
                break;
            }
            case 11: {
                lllllllllllllIlIIIIIlIIllllIIlIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(lllllllllllllIlIIIIIlIIllllIIlII)));
                lllllllllllllIlIIIIIlIIllllIIlIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(lllllllllllllIlIIIIIlIIllllIIlII)));
                lllllllllllllIlIIIIIlIIllllIIlIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(lllllllllllllIlIIIIIlIIllllIIlII)));
                lllllllllllllIlIIIIIlIIllllIIlIl.getArguments().add(new Particle.ParticleData(Type.FLOAT, Type.FLOAT.readPrimitive(lllllllllllllIlIIIIIlIIllllIIlII)));
                break;
            }
            case 27: {
                lllllllllllllIlIIIIIlIIllllIIlIl.getArguments().add(new Particle.ParticleData(Type.FLAT_VAR_INT_ITEM, Type.FLAT_VAR_INT_ITEM.read(lllllllllllllIlIIIIIlIIllllIIlII)));
                break;
            }
        }
        return lllllllllllllIlIIIIIlIIllllIIlIl;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllIlIIIIIlIIlllllIIIl, final Particle lllllllllllllIlIIIIIlIIllllIlllI) throws Exception {
        Type.VAR_INT.writePrimitive(lllllllllllllIlIIIIIlIIlllllIIIl, lllllllllllllIlIIIIIlIIllllIlllI.getId());
        for (final Particle.ParticleData lllllllllllllIlIIIIIlIIlllllIIll : lllllllllllllIlIIIIIlIIllllIlllI.getArguments()) {
            lllllllllllllIlIIIIIlIIlllllIIll.getType().write(lllllllllllllIlIIIIIlIIlllllIIIl, lllllllllllllIlIIIIIlIIlllllIIll.getValue());
        }
    }
    
    public Particle1_13_2Type() {
        super("Particle", Particle.class);
    }
}
