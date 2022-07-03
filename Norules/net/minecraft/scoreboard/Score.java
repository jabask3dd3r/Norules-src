package net.minecraft.scoreboard;

import java.util.*;

public class Score
{
    private final /* synthetic */ String scorePlayerName;
    private /* synthetic */ boolean locked;
    private final /* synthetic */ ScoreObjective theScoreObjective;
    private /* synthetic */ int scorePoints;
    private /* synthetic */ boolean forceUpdate;
    private final /* synthetic */ Scoreboard theScoreboard;
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public void setScorePoints(final int lllllllllllllIlIIlIIlIIIIlIllIIl) {
        final int lllllllllllllIlIIlIIlIIIIlIllIII = this.scorePoints;
        this.scorePoints = lllllllllllllIlIIlIIlIIIIlIllIIl;
        if (lllllllllllllIlIIlIIlIIIIlIllIII != lllllllllllllIlIIlIIlIIIIlIllIIl || this.forceUpdate) {
            this.forceUpdate = false;
            this.getScoreScoreboard().onScoreUpdated(this);
        }
    }
    
    public int getScorePoints() {
        return this.scorePoints;
    }
    
    public void incrementScore() {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.increaseScore(1);
    }
    
    public Scoreboard getScoreScoreboard() {
        return this.theScoreboard;
    }
    
    public Score(final Scoreboard lllllllllllllIlIIlIIlIIIIlllIIlI, final ScoreObjective lllllllllllllIlIIlIIlIIIIlllIlIl, final String lllllllllllllIlIIlIIlIIIIlllIIII) {
        this.theScoreboard = lllllllllllllIlIIlIIlIIIIlllIIlI;
        this.theScoreObjective = lllllllllllllIlIIlIIlIIIIlllIlIl;
        this.scorePlayerName = lllllllllllllIlIIlIIlIIIIlllIIII;
        this.forceUpdate = true;
    }
    
    static {
        SCORE_COMPARATOR = new Comparator<Score>() {
            @Override
            public int compare(final Score llIlIlIllIIIII, final Score llIlIlIllIIIIl) {
                if (llIlIlIllIIIII.getScorePoints() > llIlIlIllIIIIl.getScorePoints()) {
                    return 1;
                }
                return (llIlIlIllIIIII.getScorePoints() < llIlIlIllIIIIl.getScorePoints()) ? -1 : llIlIlIllIIIIl.getPlayerName().compareToIgnoreCase(llIlIlIllIIIII.getPlayerName());
            }
        };
    }
    
    public ScoreObjective getObjective() {
        return this.theScoreObjective;
    }
    
    public void decreaseScore(final int lllllllllllllIlIIlIIlIIIIllIIlII) {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScorePoints(this.getScorePoints() - lllllllllllllIlIIlIIlIIIIllIIlII);
    }
    
    public void increaseScore(final int lllllllllllllIlIIlIIlIIIIllIlIlI) {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScorePoints(this.getScorePoints() + lllllllllllllIlIIlIIlIIIIllIlIlI);
    }
    
    public String getPlayerName() {
        return this.scorePlayerName;
    }
    
    public void setLocked(final boolean lllllllllllllIlIIlIIlIIIIlIIIlIl) {
        this.locked = lllllllllllllIlIIlIIlIIIIlIIIlIl;
    }
}
