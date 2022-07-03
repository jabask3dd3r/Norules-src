package net.minecraft.scoreboard;

public class ScoreObjective
{
    private /* synthetic */ IScoreCriteria.EnumRenderType renderType;
    private final /* synthetic */ IScoreCriteria objectiveCriteria;
    private final /* synthetic */ String name;
    private /* synthetic */ String displayName;
    private final /* synthetic */ Scoreboard theScoreboard;
    
    public IScoreCriteria getCriteria() {
        return this.objectiveCriteria;
    }
    
    public IScoreCriteria.EnumRenderType getRenderType() {
        return this.renderType;
    }
    
    public void setRenderType(final IScoreCriteria.EnumRenderType llllllllllllllIIlllIlIIIIIIIlIIl) {
        this.renderType = llllllllllllllIIlllIlIIIIIIIlIIl;
        this.theScoreboard.onObjectiveDisplayNameChanged(this);
    }
    
    public Scoreboard getScoreboard() {
        return this.theScoreboard;
    }
    
    public ScoreObjective(final Scoreboard llllllllllllllIIlllIlIIIIIlllIlI, final String llllllllllllllIIlllIlIIIIIlllIIl, final IScoreCriteria llllllllllllllIIlllIlIIIIIlllIII) {
        this.theScoreboard = llllllllllllllIIlllIlIIIIIlllIlI;
        this.name = llllllllllllllIIlllIlIIIIIlllIIl;
        this.objectiveCriteria = llllllllllllllIIlllIlIIIIIlllIII;
        this.displayName = llllllllllllllIIlllIlIIIIIlllIIl;
        this.renderType = llllllllllllllIIlllIlIIIIIlllIII.getRenderType();
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setDisplayName(final String llllllllllllllIIlllIlIIIIIIllIll) {
        this.displayName = llllllllllllllIIlllIlIIIIIIllIll;
        this.theScoreboard.onObjectiveDisplayNameChanged(this);
    }
}
