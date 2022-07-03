package us.myles.ViaVersion.api.boss;

@Deprecated
public enum BossStyle
{
    SEGMENTED_12(3);
    
    private final /* synthetic */ int id;
    
    SOLID(0), 
    SEGMENTED_10(2), 
    SEGMENTED_6(1), 
    SEGMENTED_20(4);
    
    public int getId() {
        return this.id;
    }
    
    private BossStyle(final int lIlIlIIllllIII) {
        this.id = lIlIlIIllllIII;
    }
}
