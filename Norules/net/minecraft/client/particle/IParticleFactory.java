package net.minecraft.client.particle;

import net.minecraft.world.*;
import javax.annotation.*;

public interface IParticleFactory
{
    @Nullable
    Particle createParticle(final int p0, final World p1, final double p2, final double p3, final double p4, final double p5, final double p6, final double p7, final int... p8);
}
