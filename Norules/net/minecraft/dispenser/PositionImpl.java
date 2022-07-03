package net.minecraft.dispenser;

public class PositionImpl implements IPosition
{
    protected final /* synthetic */ double z;
    protected final /* synthetic */ double y;
    protected final /* synthetic */ double x;
    
    @Override
    public double getY() {
        return this.y;
    }
    
    @Override
    public double getX() {
        return this.x;
    }
    
    public PositionImpl(final double lllllllllllllIlIIllllllIlIllIlll, final double lllllllllllllIlIIllllllIlIllIIlI, final double lllllllllllllIlIIllllllIlIllIIIl) {
        this.x = lllllllllllllIlIIllllllIlIllIlll;
        this.y = lllllllllllllIlIIllllllIlIllIIlI;
        this.z = lllllllllllllIlIIllllllIlIllIIIl;
    }
    
    @Override
    public double getZ() {
        return this.z;
    }
}
