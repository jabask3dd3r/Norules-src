package net.minecraft.scoreboard;

import net.minecraft.util.text.*;

public class ScoreCriteriaColored implements IScoreCriteria
{
    private final /* synthetic */ String goalName;
    
    @Override
    public EnumRenderType getRenderType() {
        return EnumRenderType.INTEGER;
    }
    
    @Override
    public String getName() {
        return this.goalName;
    }
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    public ScoreCriteriaColored(final String lllllllllllllIIIIIllllIIllIllIIl, final TextFormatting lllllllllllllIIIIIllllIIllIlIlIl) {
        this.goalName = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIllllIIllIllIIl)).append(lllllllllllllIIIIIllllIIllIlIlIl.getFriendlyName()));
        IScoreCriteria.INSTANCES.put(this.goalName, this);
    }
}
