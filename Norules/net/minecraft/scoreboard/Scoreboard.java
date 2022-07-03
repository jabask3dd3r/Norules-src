package net.minecraft.scoreboard;

import net.minecraft.util.text.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import java.util.*;

public class Scoreboard
{
    private final /* synthetic */ Map<String, ScoreObjective> scoreObjectives;
    private final /* synthetic */ Map<String, ScorePlayerTeam> teams;
    private final /* synthetic */ Map<IScoreCriteria, List<ScoreObjective>> scoreObjectiveCriterias;
    private final /* synthetic */ ScoreObjective[] objectiveDisplaySlots;
    private final /* synthetic */ Map<String, ScorePlayerTeam> teamMemberships;
    private final /* synthetic */ Map<String, Map<ScoreObjective, Score>> entitiesScoreObjectives;
    private static /* synthetic */ String[] displaySlots;
    
    public Collection<String> getTeamNames() {
        return this.teams.keySet();
    }
    
    public Collection<String> getObjectiveNames() {
        return this.entitiesScoreObjectives.keySet();
    }
    
    public void onScoreObjectiveRemoved(final ScoreObjective lllllllllllllIllIlllIlIIllIlllII) {
    }
    
    public boolean entityHasObjective(final String lllllllllllllIllIlllIlIllIIlllII, final ScoreObjective lllllllllllllIllIlllIlIllIIllIll) {
        final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIllIIllIlI = this.entitiesScoreObjectives.get(lllllllllllllIllIlllIlIllIIlllII);
        if (lllllllllllllIllIlllIlIllIIllIlI == null) {
            return false;
        }
        final Score lllllllllllllIllIlllIlIllIIllIIl = lllllllllllllIllIlllIlIllIIllIlI.get(lllllllllllllIllIlllIlIllIIllIll);
        return lllllllllllllIllIlllIlIllIIllIIl != null;
    }
    
    public boolean addPlayerToTeam(final String lllllllllllllIllIlllIlIlIIIIIIlI, final String lllllllllllllIllIlllIlIlIIIIIIIl) {
        if (lllllllllllllIllIlllIlIlIIIIIIlI.length() > 40) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("The player name '").append(lllllllllllllIllIlllIlIlIIIIIIlI).append("' is too long!")));
        }
        if (!this.teams.containsKey(lllllllllllllIllIlllIlIlIIIIIIIl)) {
            return false;
        }
        final ScorePlayerTeam lllllllllllllIllIlllIlIlIIIIIlII = this.getTeam(lllllllllllllIllIlllIlIlIIIIIIIl);
        if (this.getPlayersTeam(lllllllllllllIllIlllIlIlIIIIIIlI) != null) {
            this.removePlayerFromTeams(lllllllllllllIllIlllIlIlIIIIIIlI);
        }
        this.teamMemberships.put(lllllllllllllIllIlllIlIlIIIIIIlI, lllllllllllllIllIlllIlIlIIIIIlII);
        lllllllllllllIllIlllIlIlIIIIIlII.getMembershipCollection().add(lllllllllllllIllIlllIlIlIIIIIIlI);
        return true;
    }
    
    public void removeTeam(final ScorePlayerTeam lllllllllllllIllIlllIlIlIIIIlllI) {
        if (lllllllllllllIllIlllIlIlIIIIlllI != null) {
            this.teams.remove(lllllllllllllIllIlllIlIlIIIIlllI.getRegisteredName());
            for (final String lllllllllllllIllIlllIlIlIIIlIIII : lllllllllllllIllIlllIlIlIIIIlllI.getMembershipCollection()) {
                this.teamMemberships.remove(lllllllllllllIllIlllIlIlIIIlIIII);
            }
            this.broadcastTeamRemove(lllllllllllllIllIlllIlIlIIIIlllI);
        }
    }
    
    public boolean removePlayerFromTeams(final String lllllllllllllIllIlllIlIIlllllIll) {
        final ScorePlayerTeam lllllllllllllIllIlllIlIIlllllIlI = this.getPlayersTeam(lllllllllllllIllIlllIlIIlllllIll);
        if (lllllllllllllIllIlllIlIIlllllIlI != null) {
            this.removePlayerFromTeam(lllllllllllllIllIlllIlIIlllllIll, lllllllllllllIllIlllIlIIlllllIlI);
            return true;
        }
        return false;
    }
    
    public void broadcastTeamCreated(final ScorePlayerTeam lllllllllllllIllIlllIlIIllIlIIll) {
    }
    
    public void broadcastScoreUpdate(final String lllllllllllllIllIlllIlIIllIllIII) {
    }
    
    public Score getOrCreateScore(final String lllllllllllllIllIlllIlIllIIIlIII, final ScoreObjective lllllllllllllIllIlllIlIllIIIllII) {
        if (lllllllllllllIllIlllIlIllIIIlIII.length() > 40) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("The player name '").append(lllllllllllllIllIlllIlIllIIIlIII).append("' is too long!")));
        }
        Map<ScoreObjective, Score> lllllllllllllIllIlllIlIllIIIlIll = this.entitiesScoreObjectives.get(lllllllllllllIllIlllIlIllIIIlIII);
        if (lllllllllllllIllIlllIlIllIIIlIll == null) {
            lllllllllllllIllIlllIlIllIIIlIll = (Map<ScoreObjective, Score>)Maps.newHashMap();
            this.entitiesScoreObjectives.put(lllllllllllllIllIlllIlIllIIIlIII, lllllllllllllIllIlllIlIllIIIlIll);
        }
        Score lllllllllllllIllIlllIlIllIIIlIlI = lllllllllllllIllIlllIlIllIIIlIll.get(lllllllllllllIllIlllIlIllIIIllII);
        if (lllllllllllllIllIlllIlIllIIIlIlI == null) {
            lllllllllllllIllIlllIlIllIIIlIlI = new Score(this, lllllllllllllIllIlllIlIllIIIllII, lllllllllllllIllIlllIlIllIIIlIII);
            lllllllllllllIllIlllIlIllIIIlIll.put(lllllllllllllIllIlllIlIllIIIllII, lllllllllllllIllIlllIlIllIIIlIlI);
        }
        return lllllllllllllIllIlllIlIllIIIlIlI;
    }
    
    public ScorePlayerTeam getTeam(final String lllllllllllllIllIlllIlIlIIlIIIlI) {
        return this.teams.get(lllllllllllllIllIlllIlIlIIlIIIlI);
    }
    
    public Collection<ScorePlayerTeam> getTeams() {
        return this.teams.values();
    }
    
    public static int getObjectiveDisplaySlotNumber(final String lllllllllllllIllIlllIlIIllIIIIlI) {
        if ("list".equalsIgnoreCase(lllllllllllllIllIlllIlIIllIIIIlI)) {
            return 0;
        }
        if ("sidebar".equalsIgnoreCase(lllllllllllllIllIlllIlIIllIIIIlI)) {
            return 1;
        }
        if ("belowName".equalsIgnoreCase(lllllllllllllIllIlllIlIIllIIIIlI)) {
            return 2;
        }
        if (lllllllllllllIllIlllIlIIllIIIIlI.startsWith("sidebar.team.")) {
            final String lllllllllllllIllIlllIlIIllIIIlII = lllllllllllllIllIlllIlIIllIIIIlI.substring("sidebar.team.".length());
            final TextFormatting lllllllllllllIllIlllIlIIllIIIIll = TextFormatting.getValueByName(lllllllllllllIllIlllIlIIllIIIlII);
            if (lllllllllllllIllIlllIlIIllIIIIll != null && lllllllllllllIllIlllIlIIllIIIIll.getColorIndex() >= 0) {
                return lllllllllllllIllIlllIlIIllIIIIll.getColorIndex() + 3;
            }
        }
        return -1;
    }
    
    public void onScoreObjectiveAdded(final ScoreObjective lllllllllllllIllIlllIlIIlllIIIII) {
    }
    
    @Nullable
    public ScorePlayerTeam getPlayersTeam(final String lllllllllllllIllIlllIlIIlllIIIlI) {
        return this.teamMemberships.get(lllllllllllllIllIlllIlIIlllIIIlI);
    }
    
    public static String getObjectiveDisplaySlot(final int lllllllllllllIllIlllIlIIllIIllII) {
        switch (lllllllllllllIllIlllIlIIllIIllII) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
            default: {
                if (lllllllllllllIllIlllIlIIllIIllII >= 3 && lllllllllllllIllIlllIlIIllIIllII <= 18) {
                    final TextFormatting lllllllllllllIllIlllIlIIllIIlIll = TextFormatting.fromColorIndex(lllllllllllllIllIlllIlIIllIIllII - 3);
                    if (lllllllllllllIllIlllIlIIllIIlIll != null && lllllllllllllIllIlllIlIIllIIlIll != TextFormatting.RESET) {
                        return String.valueOf(new StringBuilder("sidebar.team.").append(lllllllllllllIllIlllIlIIllIIlIll.getFriendlyName()));
                    }
                }
                return null;
            }
        }
    }
    
    public void removeObjective(final ScoreObjective lllllllllllllIllIlllIlIlIIllllIl) {
        if (lllllllllllllIllIlllIlIlIIllllIl != null) {
            this.scoreObjectives.remove(lllllllllllllIllIlllIlIlIIllllIl.getName());
            for (int lllllllllllllIllIlllIlIlIIllllII = 0; lllllllllllllIllIlllIlIlIIllllII < 19; ++lllllllllllllIllIlllIlIlIIllllII) {
                if (this.getObjectiveInDisplaySlot(lllllllllllllIllIlllIlIlIIllllII) == lllllllllllllIllIlllIlIlIIllllIl) {
                    this.setObjectiveInDisplaySlot(lllllllllllllIllIlllIlIlIIllllII, null);
                }
            }
            final List<ScoreObjective> lllllllllllllIllIlllIlIlIIlllIll = this.scoreObjectiveCriterias.get(lllllllllllllIllIlllIlIlIIllllIl.getCriteria());
            if (lllllllllllllIllIlllIlIlIIlllIll != null) {
                lllllllllllllIllIlllIlIlIIlllIll.remove(lllllllllllllIllIlllIlIlIIllllIl);
            }
            for (final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIIlllIlI : this.entitiesScoreObjectives.values()) {
                lllllllllllllIllIlllIlIlIIlllIlI.remove(lllllllllllllIllIlllIlIlIIllllIl);
            }
            this.onScoreObjectiveRemoved(lllllllllllllIllIlllIlIlIIllllIl);
        }
    }
    
    public void broadcastTeamRemove(final ScorePlayerTeam lllllllllllllIllIlllIlIIllIIllll) {
    }
    
    public void removeEntity(final Entity lllllllllllllIllIlllIlIIlIlllIII) {
        if (lllllllllllllIllIlllIlIIlIlllIII != null && !(lllllllllllllIllIlllIlIIlIlllIII instanceof EntityPlayer) && !lllllllllllllIllIlllIlIIlIlllIII.isEntityAlive()) {
            final String lllllllllllllIllIlllIlIIlIllIlll = lllllllllllllIllIlllIlIIlIlllIII.getCachedUniqueIdString();
            this.removeObjectiveFromEntity(lllllllllllllIllIlllIlIIlIllIlll, null);
            this.removePlayerFromTeams(lllllllllllllIllIlllIlIIlIllIlll);
        }
    }
    
    @Nullable
    public ScoreObjective getObjectiveInDisplaySlot(final int lllllllllllllIllIlllIlIlIIlIIllI) {
        return this.objectiveDisplaySlots[lllllllllllllIllIlllIlIlIIlIIllI];
    }
    
    public ScorePlayerTeam createTeam(final String lllllllllllllIllIlllIlIlIIIllIll) {
        if (lllllllllllllIllIlllIlIlIIIllIll.length() > 16) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("The team name '").append(lllllllllllllIllIlllIlIlIIIllIll).append("' is too long!")));
        }
        ScorePlayerTeam lllllllllllllIllIlllIlIlIIIllIlI = this.getTeam(lllllllllllllIllIlllIlIlIIIllIll);
        if (lllllllllllllIllIlllIlIlIIIllIlI != null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("A team with the name '").append(lllllllllllllIllIlllIlIlIIIllIll).append("' already exists!")));
        }
        lllllllllllllIllIlllIlIlIIIllIlI = new ScorePlayerTeam(this, lllllllllllllIllIlllIlIlIIIllIll);
        this.teams.put(lllllllllllllIllIlllIlIlIIIllIll, lllllllllllllIllIlllIlIlIIIllIlI);
        this.broadcastTeamCreated(lllllllllllllIllIlllIlIlIIIllIlI);
        return lllllllllllllIllIlllIlIlIIIllIlI;
    }
    
    public Map<ScoreObjective, Score> getObjectivesForEntity(final String lllllllllllllIllIlllIlIlIlIIlIII) {
        Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIlIIIlll = this.entitiesScoreObjectives.get(lllllllllllllIllIlllIlIlIlIIlIII);
        if (lllllllllllllIllIlllIlIlIlIIIlll == null) {
            lllllllllllllIllIlllIlIlIlIIIlll = (Map<ScoreObjective, Score>)Maps.newHashMap();
        }
        return lllllllllllllIllIlllIlIlIlIIIlll;
    }
    
    public Collection<ScoreObjective> getScoreObjectives() {
        return this.scoreObjectives.values();
    }
    
    public void removePlayerFromTeam(final String lllllllllllllIllIlllIlIIllllIIlI, final ScorePlayerTeam lllllllllllllIllIlllIlIIllllIIIl) {
        if (this.getPlayersTeam(lllllllllllllIllIlllIlIIllllIIlI) != lllllllllllllIllIlllIlIIllllIIIl) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Player is either on another team or not on any team. Cannot remove from team '").append(lllllllllllllIllIlllIlIIllllIIIl.getRegisteredName()).append("'.")));
        }
        this.teamMemberships.remove(lllllllllllllIllIlllIlIIllllIIlI);
        lllllllllllllIllIlllIlIIllllIIIl.getMembershipCollection().remove(lllllllllllllIllIlllIlIIllllIIlI);
    }
    
    public Collection<Score> getSortedScores(final ScoreObjective lllllllllllllIllIlllIlIlIllllIII) {
        final List<Score> lllllllllllllIllIlllIlIlIlllllII = (List<Score>)Lists.newArrayList();
        for (final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIllllIll : this.entitiesScoreObjectives.values()) {
            final Score lllllllllllllIllIlllIlIlIllllIlI = lllllllllllllIllIlllIlIlIllllIll.get(lllllllllllllIllIlllIlIlIllllIII);
            if (lllllllllllllIllIlllIlIlIllllIlI != null) {
                lllllllllllllIllIlllIlIlIlllllII.add(lllllllllllllIllIlllIlIlIllllIlI);
            }
        }
        Collections.sort(lllllllllllllIllIlllIlIlIlllllII, Score.SCORE_COMPARATOR);
        return lllllllllllllIllIlllIlIlIlllllII;
    }
    
    public void onScoreUpdated(final Score lllllllllllllIllIlllIlIIllIllIlI) {
    }
    
    public Scoreboard() {
        this.scoreObjectives = (Map<String, ScoreObjective>)Maps.newHashMap();
        this.scoreObjectiveCriterias = (Map<IScoreCriteria, List<ScoreObjective>>)Maps.newHashMap();
        this.entitiesScoreObjectives = (Map<String, Map<ScoreObjective, Score>>)Maps.newHashMap();
        this.objectiveDisplaySlots = new ScoreObjective[19];
        this.teams = (Map<String, ScorePlayerTeam>)Maps.newHashMap();
        this.teamMemberships = (Map<String, ScorePlayerTeam>)Maps.newHashMap();
    }
    
    public void removeObjectiveFromEntity(final String lllllllllllllIllIlllIlIlIlIlllll, final ScoreObjective lllllllllllllIllIlllIlIlIllIIlIl) {
        if (lllllllllllllIllIlllIlIlIllIIlIl == null) {
            final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIllIIlII = this.entitiesScoreObjectives.remove(lllllllllllllIllIlllIlIlIlIlllll);
            if (lllllllllllllIllIlllIlIlIllIIlII != null) {
                this.broadcastScoreUpdate(lllllllllllllIllIlllIlIlIlIlllll);
            }
        }
        else {
            final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIllIIIll = this.entitiesScoreObjectives.get(lllllllllllllIllIlllIlIlIlIlllll);
            if (lllllllllllllIllIlllIlIlIllIIIll != null) {
                final Score lllllllllllllIllIlllIlIlIllIIIlI = lllllllllllllIllIlllIlIlIllIIIll.remove(lllllllllllllIllIlllIlIlIllIIlIl);
                if (lllllllllllllIllIlllIlIlIllIIIll.size() < 1) {
                    final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIllIIIIl = this.entitiesScoreObjectives.remove(lllllllllllllIllIlllIlIlIlIlllll);
                    if (lllllllllllllIllIlllIlIlIllIIIIl != null) {
                        this.broadcastScoreUpdate(lllllllllllllIllIlllIlIlIlIlllll);
                    }
                }
                else if (lllllllllllllIllIlllIlIlIllIIIlI != null) {
                    this.broadcastScoreUpdate(lllllllllllllIllIlllIlIlIlIlllll, lllllllllllllIllIlllIlIlIllIIlIl);
                }
            }
        }
    }
    
    public void broadcastTeamInfoUpdate(final ScorePlayerTeam lllllllllllllIllIlllIlIIllIlIIIl) {
    }
    
    public Collection<ScoreObjective> getObjectivesFromCriteria(final IScoreCriteria lllllllllllllIllIlllIlIllIlIIlll) {
        final Collection<ScoreObjective> lllllllllllllIllIlllIlIllIlIIllI = this.scoreObjectiveCriterias.get(lllllllllllllIllIlllIlIllIlIIlll);
        return (Collection<ScoreObjective>)((lllllllllllllIllIlllIlIllIlIIllI == null) ? Lists.newArrayList() : Lists.newArrayList((Iterable)lllllllllllllIllIlllIlIllIlIIllI));
    }
    
    public void broadcastScoreUpdate(final String lllllllllllllIllIlllIlIIllIlIllI, final ScoreObjective lllllllllllllIllIlllIlIIllIlIlIl) {
    }
    
    public void setObjectiveInDisplaySlot(final int lllllllllllllIllIlllIlIlIIllIIII, final ScoreObjective lllllllllllllIllIlllIlIlIIlIllII) {
        this.objectiveDisplaySlots[lllllllllllllIllIlllIlIlIIllIIII] = lllllllllllllIllIlllIlIlIIlIllII;
    }
    
    public void onObjectiveDisplayNameChanged(final ScoreObjective lllllllllllllIllIlllIlIIllIllllI) {
    }
    
    public ScoreObjective addScoreObjective(final String lllllllllllllIllIlllIlIllIlIllll, final IScoreCriteria lllllllllllllIllIlllIlIllIllIIll) {
        if (lllllllllllllIllIlllIlIllIlIllll.length() > 16) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("The objective name '").append(lllllllllllllIllIlllIlIllIlIllll).append("' is too long!")));
        }
        ScoreObjective lllllllllllllIllIlllIlIllIllIIlI = this.getObjective(lllllllllllllIllIlllIlIllIlIllll);
        if (lllllllllllllIllIlllIlIllIllIIlI != null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("An objective with the name '").append(lllllllllllllIllIlllIlIllIlIllll).append("' already exists!")));
        }
        lllllllllllllIllIlllIlIllIllIIlI = new ScoreObjective(this, lllllllllllllIllIlllIlIllIlIllll, lllllllllllllIllIlllIlIllIllIIll);
        List<ScoreObjective> lllllllllllllIllIlllIlIllIllIIIl = this.scoreObjectiveCriterias.get(lllllllllllllIllIlllIlIllIllIIll);
        if (lllllllllllllIllIlllIlIllIllIIIl == null) {
            lllllllllllllIllIlllIlIllIllIIIl = (List<ScoreObjective>)Lists.newArrayList();
            this.scoreObjectiveCriterias.put(lllllllllllllIllIlllIlIllIllIIll, lllllllllllllIllIlllIlIllIllIIIl);
        }
        lllllllllllllIllIlllIlIllIllIIIl.add(lllllllllllllIllIlllIlIllIllIIlI);
        this.scoreObjectives.put(lllllllllllllIllIlllIlIllIlIllll, lllllllllllllIllIlllIlIllIllIIlI);
        this.onScoreObjectiveAdded(lllllllllllllIllIlllIlIllIllIIlI);
        return lllllllllllllIllIlllIlIllIllIIlI;
    }
    
    public Collection<Score> getScores() {
        final Collection<Map<ScoreObjective, Score>> lllllllllllllIllIlllIlIlIlIlIlII = this.entitiesScoreObjectives.values();
        final List<Score> lllllllllllllIllIlllIlIlIlIlIIll = (List<Score>)Lists.newArrayList();
        for (final Map<ScoreObjective, Score> lllllllllllllIllIlllIlIlIlIlIIlI : lllllllllllllIllIlllIlIlIlIlIlII) {
            lllllllllllllIllIlllIlIlIlIlIIll.addAll(lllllllllllllIllIlllIlIlIlIlIIlI.values());
        }
        return lllllllllllllIllIlllIlIlIlIlIIll;
    }
    
    public static String[] getDisplaySlotStrings() {
        if (Scoreboard.displaySlots == null) {
            Scoreboard.displaySlots = new String[19];
            for (int lllllllllllllIllIlllIlIIlIlllllI = 0; lllllllllllllIllIlllIlIIlIlllllI < 19; ++lllllllllllllIllIlllIlIIlIlllllI) {
                Scoreboard.displaySlots[lllllllllllllIllIlllIlIIlIlllllI] = getObjectiveDisplaySlot(lllllllllllllIllIlllIlIIlIlllllI);
            }
        }
        return Scoreboard.displaySlots;
    }
    
    @Nullable
    public ScoreObjective getObjective(final String lllllllllllllIllIlllIlIllIllllIl) {
        return this.scoreObjectives.get(lllllllllllllIllIlllIlIllIllllIl);
    }
}
