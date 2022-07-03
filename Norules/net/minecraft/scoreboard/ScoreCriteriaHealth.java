package net.minecraft.scoreboard;

public class ScoreCriteriaHealth extends ScoreCriteria
{
    @Override
    public boolean isReadOnly() {
        return true;
    }
    
    @Override
    public IScoreCriteria.EnumRenderType getRenderType() {
        return IScoreCriteria.EnumRenderType.HEARTS;
    }
    
    public ScoreCriteriaHealth(final String llllllllllllIlllllIlIIllIIIIlIll) {
        super(llllllllllllIlllllIlIIllIIIIlIll);
    }
}
