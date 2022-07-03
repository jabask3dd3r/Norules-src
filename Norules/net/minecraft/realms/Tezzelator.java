package net.minecraft.realms;

import net.minecraft.client.renderer.*;

public class Tezzelator
{
    public static /* synthetic */ Tessellator t;
    
    public void offset(final double lllllllllllllllIIIllIlllIlIlIIII, final double lllllllllllllllIIIllIlllIlIlIIlI, final double lllllllllllllllIIIllIlllIlIlIIIl) {
        Tezzelator.t.getBuffer().setTranslation(lllllllllllllllIIIllIlllIlIlIIII, lllllllllllllllIIIllIlllIlIlIIlI, lllllllllllllllIIIllIlllIlIlIIIl);
    }
    
    public Tezzelator tex(final double lllllllllllllllIIIllIlllIIlllIIl, final double lllllllllllllllIIIllIlllIIlllIll) {
        Tezzelator.t.getBuffer().tex(lllllllllllllllIIIllIlllIIlllIIl, lllllllllllllllIIIllIlllIIlllIll);
        return this;
    }
    
    public RealmsBufferBuilder color(final int lllllllllllllllIIIllIlllIlIIIlII, final int lllllllllllllllIIIllIlllIlIIIlll, final int lllllllllllllllIIIllIlllIlIIIIlI, final int lllllllllllllllIIIllIlllIlIIIlIl) {
        return new RealmsBufferBuilder(Tezzelator.t.getBuffer().color(lllllllllllllllIIIllIlllIlIIIlII, lllllllllllllllIIIllIlllIlIIIlll, lllllllllllllllIIIllIlllIlIIIIlI, lllllllllllllllIIIllIlllIlIIIlIl));
    }
    
    public void normal(final float lllllllllllllllIIIllIlllIllIIIlI, final float lllllllllllllllIIIllIlllIllIIIIl, final float lllllllllllllllIIIllIlllIllIIIII) {
        Tezzelator.t.getBuffer().normal(lllllllllllllllIIIllIlllIllIIIlI, lllllllllllllllIIIllIlllIllIIIIl, lllllllllllllllIIIllIlllIllIIIII);
    }
    
    public void begin(final int lllllllllllllllIIIllIlllIlIlllII, final RealmsVertexFormat lllllllllllllllIIIllIlllIlIllIll) {
        Tezzelator.t.getBuffer().begin(lllllllllllllllIIIllIlllIlIlllII, lllllllllllllllIIIllIlllIlIllIll.getVertexFormat());
    }
    
    static {
        Tezzelator.t = Tessellator.getInstance();
        instance = new Tezzelator();
    }
    
    public void endVertex() {
        Tezzelator.t.getBuffer().endVertex();
    }
    
    public void color(final float lllllllllllllllIIIllIlllIlllIlII, final float lllllllllllllllIIIllIlllIlllIlll, final float lllllllllllllllIIIllIlllIlllIIlI, final float lllllllllllllllIIIllIlllIlllIIIl) {
        Tezzelator.t.getBuffer().color(lllllllllllllllIIIllIlllIlllIlII, lllllllllllllllIIIllIlllIlllIlll, lllllllllllllllIIIllIlllIlllIIlI, lllllllllllllllIIIllIlllIlllIIIl);
    }
    
    public Tezzelator vertex(final double lllllllllllllllIIIllIllllIIIIIII, final double lllllllllllllllIIIllIllllIIIIIll, final double lllllllllllllllIIIllIllllIIIIIlI) {
        Tezzelator.t.getBuffer().pos(lllllllllllllllIIIllIllllIIIIIII, lllllllllllllllIIIllIllllIIIIIll, lllllllllllllllIIIllIllllIIIIIlI);
        return this;
    }
    
    public void end() {
        Tezzelator.t.draw();
    }
    
    public void tex2(final short lllllllllllllllIIIllIlllIllIllIl, final short lllllllllllllllIIIllIlllIllIlIlI) {
        Tezzelator.t.getBuffer().lightmap(lllllllllllllllIIIllIlllIllIllIl, lllllllllllllllIIIllIlllIllIlIlI);
    }
}
