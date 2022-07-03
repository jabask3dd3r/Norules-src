package net.minecraft.client.renderer.culling;

import net.minecraft.util.math.*;

public class Frustum implements ICamera
{
    private /* synthetic */ double yPosition;
    private /* synthetic */ double zPosition;
    private /* synthetic */ double xPosition;
    private final /* synthetic */ ClippingHelper clippingHelper;
    
    public Frustum() {
        this(ClippingHelperImpl.getInstance());
    }
    
    @Override
    public void setPosition(final double llllllllllllllIIIIIIlIIlllllIlll, final double llllllllllllllIIIIIIlIIlllllIllI, final double llllllllllllllIIIIIIlIIlllllIlIl) {
        this.xPosition = llllllllllllllIIIIIIlIIlllllIlll;
        this.yPosition = llllllllllllllIIIIIIlIIlllllIllI;
        this.zPosition = llllllllllllllIIIIIIlIIlllllIlIl;
    }
    
    @Override
    public boolean isBoundingBoxInFrustum(final AxisAlignedBB llllllllllllllIIIIIIlIIlllIllIlI) {
        return this.isBoxInFrustum(llllllllllllllIIIIIIlIIlllIllIlI.minX, llllllllllllllIIIIIIlIIlllIllIlI.minY, llllllllllllllIIIIIIlIIlllIllIlI.minZ, llllllllllllllIIIIIIlIIlllIllIlI.maxX, llllllllllllllIIIIIIlIIlllIllIlI.maxY, llllllllllllllIIIIIIlIIlllIllIlI.maxZ);
    }
    
    public boolean isBoxInFrustum(final double llllllllllllllIIIIIIlIIllllIllII, final double llllllllllllllIIIIIIlIIllllIlIll, final double llllllllllllllIIIIIIlIIllllIlIlI, final double llllllllllllllIIIIIIlIIllllIlIIl, final double llllllllllllllIIIIIIlIIllllIlIII, final double llllllllllllllIIIIIIlIIllllIIIII) {
        return this.clippingHelper.isBoxInFrustum(llllllllllllllIIIIIIlIIllllIllII - this.xPosition, llllllllllllllIIIIIIlIIllllIlIll - this.yPosition, llllllllllllllIIIIIIlIIllllIlIlI - this.zPosition, llllllllllllllIIIIIIlIIllllIlIIl - this.xPosition, llllllllllllllIIIIIIlIIllllIlIII - this.yPosition, llllllllllllllIIIIIIlIIllllIIIII - this.zPosition);
    }
    
    public Frustum(final ClippingHelper llllllllllllllIIIIIIlIlIIIIIIIll) {
        this.clippingHelper = llllllllllllllIIIIIIlIlIIIIIIIll;
    }
}
