package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import javax.annotation.*;

public class ParticleBlockDust extends ParticleDigging
{
    protected ParticleBlockDust(final World lllllllllllllllllllIIIIIIIlIIlII, final double lllllllllllllllllllIIIIIIIIllIlI, final double lllllllllllllllllllIIIIIIIlIIIlI, final double lllllllllllllllllllIIIIIIIIllIII, final double lllllllllllllllllllIIIIIIIIlIlll, final double lllllllllllllllllllIIIIIIIIlIllI, final double lllllllllllllllllllIIIIIIIIllllI, final IBlockState lllllllllllllllllllIIIIIIIIlllIl) {
        super(lllllllllllllllllllIIIIIIIlIIlII, lllllllllllllllllllIIIIIIIIllIlI, lllllllllllllllllllIIIIIIIlIIIlI, lllllllllllllllllllIIIIIIIIllIII, lllllllllllllllllllIIIIIIIIlIlll, lllllllllllllllllllIIIIIIIIlIllI, lllllllllllllllllllIIIIIIIIllllI, lllllllllllllllllllIIIIIIIIlllIl);
        this.motionX = lllllllllllllllllllIIIIIIIIlIlll;
        this.motionY = lllllllllllllllllllIIIIIIIIlIllI;
        this.motionZ = lllllllllllllllllllIIIIIIIIllllI;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Nullable
        @Override
        public Particle createParticle(final int llllllllllllllIlIlIlIIIlIlIllIlI, final World llllllllllllllIlIlIlIIIlIlIllIIl, final double llllllllllllllIlIlIlIIIlIlIllIII, final double llllllllllllllIlIlIlIIIlIlIIllIl, final double llllllllllllllIlIlIlIIIlIlIlIllI, final double llllllllllllllIlIlIlIIIlIlIIlIll, final double llllllllllllllIlIlIlIIIlIlIlIlII, final double llllllllllllllIlIlIlIIIlIlIlIIll, final int... llllllllllllllIlIlIlIIIlIlIIlIII) {
            final IBlockState llllllllllllllIlIlIlIIIlIlIlIIIl = Block.getStateById(llllllllllllllIlIlIlIIIlIlIIlIII[0]);
            return (llllllllllllllIlIlIlIIIlIlIlIIIl.getRenderType() == EnumBlockRenderType.INVISIBLE) ? null : new ParticleBlockDust(llllllllllllllIlIlIlIIIlIlIllIIl, llllllllllllllIlIlIlIIIlIlIllIII, llllllllllllllIlIlIlIIIlIlIIllIl, llllllllllllllIlIlIlIIIlIlIlIllI, llllllllllllllIlIlIlIIIlIlIIlIll, llllllllllllllIlIlIlIIIlIlIlIlII, llllllllllllllIlIlIlIIIlIlIlIIll, llllllllllllllIlIlIlIIIlIlIlIIIl).init();
        }
    }
}
