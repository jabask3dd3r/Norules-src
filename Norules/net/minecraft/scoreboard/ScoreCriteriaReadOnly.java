package net.minecraft.scoreboard;

public class ScoreCriteriaReadOnly extends ScoreCriteria
{
    public ScoreCriteriaReadOnly(final String lllllllllllllIllIIllIIlIIllIlIll) {
        super(lllllllllllllIllIIllIIlIIllIlIll);
    }
    
    @Override
    public boolean isReadOnly() {
        return true;
    }
}
