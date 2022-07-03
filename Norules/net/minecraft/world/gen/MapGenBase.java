package net.minecraft.world.gen;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.world.chunk.*;

public class MapGenBase
{
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ Random rand;
    protected /* synthetic */ int range;
    
    public void generate(final World llllllllllllllllIIIIllIIIIlIlIIl, final int llllllllllllllllIIIIllIIIIlIlIII, final int llllllllllllllllIIIIllIIIIllIIll, final ChunkPrimer llllllllllllllllIIIIllIIIIlIIllI) {
        final int llllllllllllllllIIIIllIIIIllIIIl = this.range;
        this.worldObj = llllllllllllllllIIIIllIIIIlIlIIl;
        this.rand.setSeed(llllllllllllllllIIIIllIIIIlIlIIl.getSeed());
        final long llllllllllllllllIIIIllIIIIllIIII = this.rand.nextLong();
        final long llllllllllllllllIIIIllIIIIlIllll = this.rand.nextLong();
        for (int llllllllllllllllIIIIllIIIIlIlllI = llllllllllllllllIIIIllIIIIlIlIII - llllllllllllllllIIIIllIIIIllIIIl; llllllllllllllllIIIIllIIIIlIlllI <= llllllllllllllllIIIIllIIIIlIlIII + llllllllllllllllIIIIllIIIIllIIIl; ++llllllllllllllllIIIIllIIIIlIlllI) {
            for (int llllllllllllllllIIIIllIIIIlIllIl = llllllllllllllllIIIIllIIIIllIIll - llllllllllllllllIIIIllIIIIllIIIl; llllllllllllllllIIIIllIIIIlIllIl <= llllllllllllllllIIIIllIIIIllIIll + llllllllllllllllIIIIllIIIIllIIIl; ++llllllllllllllllIIIIllIIIIlIllIl) {
                final long llllllllllllllllIIIIllIIIIlIllII = llllllllllllllllIIIIllIIIIlIlllI * llllllllllllllllIIIIllIIIIllIIII;
                final long llllllllllllllllIIIIllIIIIlIlIll = llllllllllllllllIIIIllIIIIlIllIl * llllllllllllllllIIIIllIIIIlIllll;
                this.rand.setSeed(llllllllllllllllIIIIllIIIIlIllII ^ llllllllllllllllIIIIllIIIIlIlIll ^ llllllllllllllllIIIIllIIIIlIlIIl.getSeed());
                this.recursiveGenerate(llllllllllllllllIIIIllIIIIlIlIIl, llllllllllllllllIIIIllIIIIlIlllI, llllllllllllllllIIIIllIIIIlIllIl, llllllllllllllllIIIIllIIIIlIlIII, llllllllllllllllIIIIllIIIIllIIll, llllllllllllllllIIIIllIIIIlIIllI);
            }
        }
    }
    
    public MapGenBase() {
        this.range = 8;
        this.rand = new Random();
    }
    
    protected void recursiveGenerate(final World llllllllllllllllIIIIllIIIIIIIlIl, final int llllllllllllllllIIIIllIIIIIIIlII, final int llllllllllllllllIIIIllIIIIIIIIll, final int llllllllllllllllIIIIllIIIIIIIIlI, final int llllllllllllllllIIIIllIIIIIIIIIl, final ChunkPrimer llllllllllllllllIIIIllIIIIIIIIII) {
    }
    
    public static void func_191068_a(final long llllllllllllllllIIIIllIIIIIIlllI, final Random llllllllllllllllIIIIllIIIIIIllIl, final int llllllllllllllllIIIIllIIIIIlIlII, final int llllllllllllllllIIIIllIIIIIlIIll) {
        llllllllllllllllIIIIllIIIIIIllIl.setSeed(llllllllllllllllIIIIllIIIIIIlllI);
        final long llllllllllllllllIIIIllIIIIIlIIlI = llllllllllllllllIIIIllIIIIIIllIl.nextLong();
        final long llllllllllllllllIIIIllIIIIIlIIIl = llllllllllllllllIIIIllIIIIIIllIl.nextLong();
        final long llllllllllllllllIIIIllIIIIIlIIII = llllllllllllllllIIIIllIIIIIlIlII * llllllllllllllllIIIIllIIIIIlIIlI;
        final long llllllllllllllllIIIIllIIIIIIllll = llllllllllllllllIIIIllIIIIIlIIll * llllllllllllllllIIIIllIIIIIlIIIl;
        llllllllllllllllIIIIllIIIIIIllIl.setSeed(llllllllllllllllIIIIllIIIIIlIIII ^ llllllllllllllllIIIIllIIIIIIllll ^ llllllllllllllllIIIIllIIIIIIlllI);
    }
}
