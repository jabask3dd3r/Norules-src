package us.myles.ViaVersion.api.boss;

@Deprecated
public enum BossFlag
{
    DARKEN_SKY(1);
    
    private final /* synthetic */ int id;
    
    PLAY_BOSS_MUSIC(2);
    
    private BossFlag(final int lllllllllllllIlllIllIIIIllllllII) {
        this.id = lllllllllllllIlllIllIIIIllllllII;
    }
    
    public int getId() {
        return this.id;
    }
}
