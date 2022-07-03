package net.minecraft.scoreboard;

public class ScoreCriteria implements IScoreCriteria
{
    private final /* synthetic */ String dummyName;
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    @Override
    public EnumRenderType getRenderType() {
        return EnumRenderType.INTEGER;
    }
    
    @Override
    public String getName() {
        return this.dummyName;
    }
    
    public ScoreCriteria(final String lllllllllllllIlllIlIlIIIlIIlIIIl) {
        this.dummyName = lllllllllllllIlllIlIlIIIlIIlIIIl;
        IScoreCriteria.INSTANCES.put(lllllllllllllIlllIlIlIIIlIIlIIIl, this);
    }
}
