package net.minecraft.world.border;

public enum EnumBorderStatus
{
    SHRINKING("SHRINKING", 1, 16724016), 
    STATIONARY("STATIONARY", 2, 2138367);
    
    private final /* synthetic */ int id;
    
    GROWING("GROWING", 0, 4259712);
    
    private EnumBorderStatus(final String lllllllllllllIIlIlIlllIlIlIllllI, final int lllllllllllllIIlIlIlllIlIlIlllIl, final int lllllllllllllIIlIlIlllIlIlIlllII) {
        this.id = lllllllllllllIIlIlIlllIlIlIlllII;
    }
    
    public int getID() {
        return this.id;
    }
}
