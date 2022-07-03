package optifine;

import net.minecraft.util.math.*;

public class CustomColorFader
{
    private /* synthetic */ Vec3d color;
    private /* synthetic */ long timeUpdate;
    
    public Vec3d getColor(final double llllllllllllIllllllllIlIIIIllIIl, final double llllllllllllIllllllllIlIIIlIIlIl, final double llllllllllllIllllllllIlIIIlIIlII) {
        if (this.color == null) {
            this.color = new Vec3d(llllllllllllIllllllllIlIIIIllIIl, llllllllllllIllllllllIlIIIlIIlIl, llllllllllllIllllllllIlIIIlIIlII);
            return this.color;
        }
        final long llllllllllllIllllllllIlIIIlIIIll = System.currentTimeMillis();
        final long llllllllllllIllllllllIlIIIlIIIlI = llllllllllllIllllllllIlIIIlIIIll - this.timeUpdate;
        if (llllllllllllIllllllllIlIIIlIIIlI == 0L) {
            return this.color;
        }
        this.timeUpdate = llllllllllllIllllllllIlIIIlIIIll;
        if (Math.abs(llllllllllllIllllllllIlIIIIllIIl - this.color.xCoord) < 0.004 && Math.abs(llllllllllllIllllllllIlIIIlIIlIl - this.color.yCoord) < 0.004 && Math.abs(llllllllllllIllllllllIlIIIlIIlII - this.color.zCoord) < 0.004) {
            return this.color;
        }
        double llllllllllllIllllllllIlIIIlIIIIl = llllllllllllIllllllllIlIIIlIIIlI * 0.001;
        llllllllllllIllllllllIlIIIlIIIIl = Config.limit(llllllllllllIllllllllIlIIIlIIIIl, 0.0, 1.0);
        final double llllllllllllIllllllllIlIIIlIIIII = llllllllllllIllllllllIlIIIIllIIl - this.color.xCoord;
        final double llllllllllllIllllllllIlIIIIlllll = llllllllllllIllllllllIlIIIlIIlIl - this.color.yCoord;
        final double llllllllllllIllllllllIlIIIIllllI = llllllllllllIllllllllIlIIIlIIlII - this.color.zCoord;
        final double llllllllllllIllllllllIlIIIIlllIl = this.color.xCoord + llllllllllllIllllllllIlIIIlIIIII * llllllllllllIllllllllIlIIIlIIIIl;
        final double llllllllllllIllllllllIlIIIIlllII = this.color.yCoord + llllllllllllIllllllllIlIIIIlllll * llllllllllllIllllllllIlIIIlIIIIl;
        final double llllllllllllIllllllllIlIIIIllIll = this.color.zCoord + llllllllllllIllllllllIlIIIIllllI * llllllllllllIllllllllIlIIIlIIIIl;
        this.color = new Vec3d(llllllllllllIllllllllIlIIIIlllIl, llllllllllllIllllllllIlIIIIlllII, llllllllllllIllllllllIlIIIIllIll);
        return this.color;
    }
    
    public CustomColorFader() {
        this.color = null;
        this.timeUpdate = System.currentTimeMillis();
    }
}
