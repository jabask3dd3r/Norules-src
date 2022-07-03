package net.minecraft.scoreboard;

import net.minecraft.world.storage.*;
import org.apache.logging.log4j.*;
import net.minecraft.nbt.*;
import net.minecraft.util.text.*;

public class ScoreboardSaveData extends WorldSavedData
{
    private /* synthetic */ Scoreboard theScoreboard;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ NBTTagCompound delayedInitNbt;
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIIIlllIIIIIlIIIIlIl) {
        if (this.theScoreboard == null) {
            ScoreboardSaveData.LOGGER.warn("Tried to save scoreboard without having a scoreboard...");
            return lllllllllllllIIIlllIIIIIlIIIIlIl;
        }
        lllllllllllllIIIlllIIIIIlIIIIlIl.setTag("Objectives", this.objectivesToNbt());
        lllllllllllllIIIlllIIIIIlIIIIlIl.setTag("PlayerScores", this.scoresToNbt());
        lllllllllllllIIIlllIIIIIlIIIIlIl.setTag("Teams", this.teamsToNbt());
        this.fillInDisplaySlots(lllllllllllllIIIlllIIIIIlIIIIlIl);
        return lllllllllllllIIIlllIIIIIlIIIIlIl;
    }
    
    public ScoreboardSaveData() {
        this("scoreboard");
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    protected NBTTagList teamsToNbt() {
        final NBTTagList lllllllllllllIIIlllIIIIIIllllIIl = new NBTTagList();
        for (final ScorePlayerTeam lllllllllllllIIIlllIIIIIIllllIII : this.theScoreboard.getTeams()) {
            final NBTTagCompound lllllllllllllIIIlllIIIIIIlllIlll = new NBTTagCompound();
            lllllllllllllIIIlllIIIIIIlllIlll.setString("Name", lllllllllllllIIIlllIIIIIIllllIII.getRegisteredName());
            lllllllllllllIIIlllIIIIIIlllIlll.setString("DisplayName", lllllllllllllIIIlllIIIIIIllllIII.getTeamName());
            if (lllllllllllllIIIlllIIIIIIllllIII.getChatFormat().getColorIndex() >= 0) {
                lllllllllllllIIIlllIIIIIIlllIlll.setString("TeamColor", lllllllllllllIIIlllIIIIIIllllIII.getChatFormat().getFriendlyName());
            }
            lllllllllllllIIIlllIIIIIIlllIlll.setString("Prefix", lllllllllllllIIIlllIIIIIIllllIII.getColorPrefix());
            lllllllllllllIIIlllIIIIIIlllIlll.setString("Suffix", lllllllllllllIIIlllIIIIIIllllIII.getColorSuffix());
            lllllllllllllIIIlllIIIIIIlllIlll.setBoolean("AllowFriendlyFire", lllllllllllllIIIlllIIIIIIllllIII.getAllowFriendlyFire());
            lllllllllllllIIIlllIIIIIIlllIlll.setBoolean("SeeFriendlyInvisibles", lllllllllllllIIIlllIIIIIIllllIII.getSeeFriendlyInvisiblesEnabled());
            lllllllllllllIIIlllIIIIIIlllIlll.setString("NameTagVisibility", lllllllllllllIIIlllIIIIIIllllIII.getNameTagVisibility().internalName);
            lllllllllllllIIIlllIIIIIIlllIlll.setString("DeathMessageVisibility", lllllllllllllIIIlllIIIIIIllllIII.getDeathMessageVisibility().internalName);
            lllllllllllllIIIlllIIIIIIlllIlll.setString("CollisionRule", lllllllllllllIIIlllIIIIIIllllIII.getCollisionRule().name);
            final NBTTagList lllllllllllllIIIlllIIIIIIlllIllI = new NBTTagList();
            for (final String lllllllllllllIIIlllIIIIIIlllIlIl : lllllllllllllIIIlllIIIIIIllllIII.getMembershipCollection()) {
                lllllllllllllIIIlllIIIIIIlllIllI.appendTag(new NBTTagString(lllllllllllllIIIlllIIIIIIlllIlIl));
            }
            lllllllllllllIIIlllIIIIIIlllIlll.setTag("Players", lllllllllllllIIIlllIIIIIIlllIllI);
            lllllllllllllIIIlllIIIIIIllllIIl.appendTag(lllllllllllllIIIlllIIIIIIlllIlll);
        }
        return lllllllllllllIIIlllIIIIIIllllIIl;
    }
    
    protected void readObjectives(final NBTTagList lllllllllllllIIIlllIIIIIlIlIIIll) {
        for (int lllllllllllllIIIlllIIIIIlIlIlIIl = 0; lllllllllllllIIIlllIIIIIlIlIlIIl < lllllllllllllIIIlllIIIIIlIlIIIll.tagCount(); ++lllllllllllllIIIlllIIIIIlIlIlIIl) {
            final NBTTagCompound lllllllllllllIIIlllIIIIIlIlIlIII = lllllllllllllIIIlllIIIIIlIlIIIll.getCompoundTagAt(lllllllllllllIIIlllIIIIIlIlIlIIl);
            final IScoreCriteria lllllllllllllIIIlllIIIIIlIlIIlll = IScoreCriteria.INSTANCES.get(lllllllllllllIIIlllIIIIIlIlIlIII.getString("CriteriaName"));
            if (lllllllllllllIIIlllIIIIIlIlIIlll != null) {
                String lllllllllllllIIIlllIIIIIlIlIIllI = lllllllllllllIIIlllIIIIIlIlIlIII.getString("Name");
                if (lllllllllllllIIIlllIIIIIlIlIIllI.length() > 16) {
                    lllllllllllllIIIlllIIIIIlIlIIllI = lllllllllllllIIIlllIIIIIlIlIIllI.substring(0, 16);
                }
                final ScoreObjective lllllllllllllIIIlllIIIIIlIlIIlIl = this.theScoreboard.addScoreObjective(lllllllllllllIIIlllIIIIIlIlIIllI, lllllllllllllIIIlllIIIIIlIlIIlll);
                lllllllllllllIIIlllIIIIIlIlIIlIl.setDisplayName(lllllllllllllIIIlllIIIIIlIlIlIII.getString("DisplayName"));
                lllllllllllllIIIlllIIIIIlIlIIlIl.setRenderType(IScoreCriteria.EnumRenderType.getByName(lllllllllllllIIIlllIIIIIlIlIlIII.getString("RenderType")));
            }
        }
    }
    
    protected NBTTagList objectivesToNbt() {
        final NBTTagList lllllllllllllIIIlllIIIIIIlIlIlII = new NBTTagList();
        for (final ScoreObjective lllllllllllllIIIlllIIIIIIlIlIIll : this.theScoreboard.getScoreObjectives()) {
            if (lllllllllllllIIIlllIIIIIIlIlIIll.getCriteria() != null) {
                final NBTTagCompound lllllllllllllIIIlllIIIIIIlIlIIlI = new NBTTagCompound();
                lllllllllllllIIIlllIIIIIIlIlIIlI.setString("Name", lllllllllllllIIIlllIIIIIIlIlIIll.getName());
                lllllllllllllIIIlllIIIIIIlIlIIlI.setString("CriteriaName", lllllllllllllIIIlllIIIIIIlIlIIll.getCriteria().getName());
                lllllllllllllIIIlllIIIIIIlIlIIlI.setString("DisplayName", lllllllllllllIIIlllIIIIIIlIlIIll.getDisplayName());
                lllllllllllllIIIlllIIIIIIlIlIIlI.setString("RenderType", lllllllllllllIIIlllIIIIIIlIlIIll.getRenderType().getRenderType());
                lllllllllllllIIIlllIIIIIIlIlIlII.appendTag(lllllllllllllIIIlllIIIIIIlIlIIlI);
            }
        }
        return lllllllllllllIIIlllIIIIIIlIlIlII;
    }
    
    protected void readTeams(final NBTTagList lllllllllllllIIIlllIIIIIllIlIlII) {
        for (int lllllllllllllIIIlllIIIIIllIlllIl = 0; lllllllllllllIIIlllIIIIIllIlllIl < lllllllllllllIIIlllIIIIIllIlIlII.tagCount(); ++lllllllllllllIIIlllIIIIIllIlllIl) {
            final NBTTagCompound lllllllllllllIIIlllIIIIIllIlllII = lllllllllllllIIIlllIIIIIllIlIlII.getCompoundTagAt(lllllllllllllIIIlllIIIIIllIlllIl);
            String lllllllllllllIIIlllIIIIIllIllIll = lllllllllllllIIIlllIIIIIllIlllII.getString("Name");
            if (lllllllllllllIIIlllIIIIIllIllIll.length() > 16) {
                lllllllllllllIIIlllIIIIIllIllIll = lllllllllllllIIIlllIIIIIllIllIll.substring(0, 16);
            }
            final ScorePlayerTeam lllllllllllllIIIlllIIIIIllIllIlI = this.theScoreboard.createTeam(lllllllllllllIIIlllIIIIIllIllIll);
            String lllllllllllllIIIlllIIIIIllIllIIl = lllllllllllllIIIlllIIIIIllIlllII.getString("DisplayName");
            if (lllllllllllllIIIlllIIIIIllIllIIl.length() > 32) {
                lllllllllllllIIIlllIIIIIllIllIIl = lllllllllllllIIIlllIIIIIllIllIIl.substring(0, 32);
            }
            lllllllllllllIIIlllIIIIIllIllIlI.setTeamName(lllllllllllllIIIlllIIIIIllIllIIl);
            if (lllllllllllllIIIlllIIIIIllIlllII.hasKey("TeamColor", 8)) {
                lllllllllllllIIIlllIIIIIllIllIlI.setChatFormat(TextFormatting.getValueByName(lllllllllllllIIIlllIIIIIllIlllII.getString("TeamColor")));
            }
            lllllllllllllIIIlllIIIIIllIllIlI.setNamePrefix(lllllllllllllIIIlllIIIIIllIlllII.getString("Prefix"));
            lllllllllllllIIIlllIIIIIllIllIlI.setNameSuffix(lllllllllllllIIIlllIIIIIllIlllII.getString("Suffix"));
            if (lllllllllllllIIIlllIIIIIllIlllII.hasKey("AllowFriendlyFire", 99)) {
                lllllllllllllIIIlllIIIIIllIllIlI.setAllowFriendlyFire(lllllllllllllIIIlllIIIIIllIlllII.getBoolean("AllowFriendlyFire"));
            }
            if (lllllllllllllIIIlllIIIIIllIlllII.hasKey("SeeFriendlyInvisibles", 99)) {
                lllllllllllllIIIlllIIIIIllIllIlI.setSeeFriendlyInvisiblesEnabled(lllllllllllllIIIlllIIIIIllIlllII.getBoolean("SeeFriendlyInvisibles"));
            }
            if (lllllllllllllIIIlllIIIIIllIlllII.hasKey("NameTagVisibility", 8)) {
                final Team.EnumVisible lllllllllllllIIIlllIIIIIllIllIII = Team.EnumVisible.getByName(lllllllllllllIIIlllIIIIIllIlllII.getString("NameTagVisibility"));
                if (lllllllllllllIIIlllIIIIIllIllIII != null) {
                    lllllllllllllIIIlllIIIIIllIllIlI.setNameTagVisibility(lllllllllllllIIIlllIIIIIllIllIII);
                }
            }
            if (lllllllllllllIIIlllIIIIIllIlllII.hasKey("DeathMessageVisibility", 8)) {
                final Team.EnumVisible lllllllllllllIIIlllIIIIIllIlIlll = Team.EnumVisible.getByName(lllllllllllllIIIlllIIIIIllIlllII.getString("DeathMessageVisibility"));
                if (lllllllllllllIIIlllIIIIIllIlIlll != null) {
                    lllllllllllllIIIlllIIIIIllIllIlI.setDeathMessageVisibility(lllllllllllllIIIlllIIIIIllIlIlll);
                }
            }
            if (lllllllllllllIIIlllIIIIIllIlllII.hasKey("CollisionRule", 8)) {
                final Team.CollisionRule lllllllllllllIIIlllIIIIIllIlIllI = Team.CollisionRule.getByName(lllllllllllllIIIlllIIIIIllIlllII.getString("CollisionRule"));
                if (lllllllllllllIIIlllIIIIIllIlIllI != null) {
                    lllllllllllllIIIlllIIIIIllIllIlI.setCollisionRule(lllllllllllllIIIlllIIIIIllIlIllI);
                }
            }
            this.loadTeamPlayers(lllllllllllllIIIlllIIIIIllIllIlI, lllllllllllllIIIlllIIIIIllIlllII.getTagList("Players", 8));
        }
    }
    
    protected void readDisplayConfig(final NBTTagCompound lllllllllllllIIIlllIIIIIlIllIllI) {
        for (int lllllllllllllIIIlllIIIIIlIlllIlI = 0; lllllllllllllIIIlllIIIIIlIlllIlI < 19; ++lllllllllllllIIIlllIIIIIlIlllIlI) {
            if (lllllllllllllIIIlllIIIIIlIllIllI.hasKey(String.valueOf(new StringBuilder("slot_").append(lllllllllllllIIIlllIIIIIlIlllIlI)), 8)) {
                final String lllllllllllllIIIlllIIIIIlIlllIIl = lllllllllllllIIIlllIIIIIlIllIllI.getString(String.valueOf(new StringBuilder("slot_").append(lllllllllllllIIIlllIIIIIlIlllIlI)));
                final ScoreObjective lllllllllllllIIIlllIIIIIlIlllIII = this.theScoreboard.getObjective(lllllllllllllIIIlllIIIIIlIlllIIl);
                this.theScoreboard.setObjectiveInDisplaySlot(lllllllllllllIIIlllIIIIIlIlllIlI, lllllllllllllIIIlllIIIIIlIlllIII);
            }
        }
    }
    
    public void setScoreboard(final Scoreboard lllllllllllllIIIlllIIIIIlllIlllI) {
        this.theScoreboard = lllllllllllllIIIlllIIIIIlllIlllI;
        if (this.delayedInitNbt != null) {
            this.readFromNBT(this.delayedInitNbt);
        }
    }
    
    protected void loadTeamPlayers(final ScorePlayerTeam lllllllllllllIIIlllIIIIIllIIlIII, final NBTTagList lllllllllllllIIIlllIIIIIllIIIIll) {
        for (int lllllllllllllIIIlllIIIIIllIIIllI = 0; lllllllllllllIIIlllIIIIIllIIIllI < lllllllllllllIIIlllIIIIIllIIIIll.tagCount(); ++lllllllllllllIIIlllIIIIIllIIIllI) {
            this.theScoreboard.addPlayerToTeam(lllllllllllllIIIlllIIIIIllIIIIll.getStringTagAt(lllllllllllllIIIlllIIIIIllIIIllI), lllllllllllllIIIlllIIIIIllIIlIII.getRegisteredName());
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIIIlllIIIIIlllIlIII) {
        if (this.theScoreboard == null) {
            this.delayedInitNbt = lllllllllllllIIIlllIIIIIlllIlIII;
        }
        else {
            this.readObjectives(lllllllllllllIIIlllIIIIIlllIlIII.getTagList("Objectives", 10));
            this.readScores(lllllllllllllIIIlllIIIIIlllIlIII.getTagList("PlayerScores", 10));
            if (lllllllllllllIIIlllIIIIIlllIlIII.hasKey("DisplaySlots", 10)) {
                this.readDisplayConfig(lllllllllllllIIIlllIIIIIlllIlIII.getCompoundTag("DisplaySlots"));
            }
            if (lllllllllllllIIIlllIIIIIlllIlIII.hasKey("Teams", 9)) {
                this.readTeams(lllllllllllllIIIlllIIIIIlllIlIII.getTagList("Teams", 10));
            }
        }
    }
    
    public ScoreboardSaveData(final String lllllllllllllIIIlllIIIIIllllIlII) {
        super(lllllllllllllIIIlllIIIIIllllIlII);
    }
    
    protected void fillInDisplaySlots(final NBTTagCompound lllllllllllllIIIlllIIIIIIlIlllll) {
        final NBTTagCompound lllllllllllllIIIlllIIIIIIllIIlII = new NBTTagCompound();
        boolean lllllllllllllIIIlllIIIIIIllIIIll = false;
        for (int lllllllllllllIIIlllIIIIIIllIIIlI = 0; lllllllllllllIIIlllIIIIIIllIIIlI < 19; ++lllllllllllllIIIlllIIIIIIllIIIlI) {
            final ScoreObjective lllllllllllllIIIlllIIIIIIllIIIIl = this.theScoreboard.getObjectiveInDisplaySlot(lllllllllllllIIIlllIIIIIIllIIIlI);
            if (lllllllllllllIIIlllIIIIIIllIIIIl != null) {
                lllllllllllllIIIlllIIIIIIllIIlII.setString(String.valueOf(new StringBuilder("slot_").append(lllllllllllllIIIlllIIIIIIllIIIlI)), lllllllllllllIIIlllIIIIIIllIIIIl.getName());
                lllllllllllllIIIlllIIIIIIllIIIll = true;
            }
        }
        if (lllllllllllllIIIlllIIIIIIllIIIll) {
            lllllllllllllIIIlllIIIIIIlIlllll.setTag("DisplaySlots", lllllllllllllIIIlllIIIIIIllIIlII);
        }
    }
    
    protected NBTTagList scoresToNbt() {
        final NBTTagList lllllllllllllIIIlllIIIIIIlIIIllI = new NBTTagList();
        for (final Score lllllllllllllIIIlllIIIIIIlIIIlIl : this.theScoreboard.getScores()) {
            if (lllllllllllllIIIlllIIIIIIlIIIlIl.getObjective() != null) {
                final NBTTagCompound lllllllllllllIIIlllIIIIIIlIIIlII = new NBTTagCompound();
                lllllllllllllIIIlllIIIIIIlIIIlII.setString("Name", lllllllllllllIIIlllIIIIIIlIIIlIl.getPlayerName());
                lllllllllllllIIIlllIIIIIIlIIIlII.setString("Objective", lllllllllllllIIIlllIIIIIIlIIIlIl.getObjective().getName());
                lllllllllllllIIIlllIIIIIIlIIIlII.setInteger("Score", lllllllllllllIIIlllIIIIIIlIIIlIl.getScorePoints());
                lllllllllllllIIIlllIIIIIIlIIIlII.setBoolean("Locked", lllllllllllllIIIlllIIIIIIlIIIlIl.isLocked());
                lllllllllllllIIIlllIIIIIIlIIIllI.appendTag(lllllllllllllIIIlllIIIIIIlIIIlII);
            }
        }
        return lllllllllllllIIIlllIIIIIIlIIIllI;
    }
    
    protected void readScores(final NBTTagList lllllllllllllIIIlllIIIIIlIIlIlIl) {
        for (int lllllllllllllIIIlllIIIIIlIIlIlII = 0; lllllllllllllIIIlllIIIIIlIIlIlII < lllllllllllllIIIlllIIIIIlIIlIlIl.tagCount(); ++lllllllllllllIIIlllIIIIIlIIlIlII) {
            final NBTTagCompound lllllllllllllIIIlllIIIIIlIIlIIll = lllllllllllllIIIlllIIIIIlIIlIlIl.getCompoundTagAt(lllllllllllllIIIlllIIIIIlIIlIlII);
            final ScoreObjective lllllllllllllIIIlllIIIIIlIIlIIlI = this.theScoreboard.getObjective(lllllllllllllIIIlllIIIIIlIIlIIll.getString("Objective"));
            String lllllllllllllIIIlllIIIIIlIIlIIIl = lllllllllllllIIIlllIIIIIlIIlIIll.getString("Name");
            if (lllllllllllllIIIlllIIIIIlIIlIIIl.length() > 40) {
                lllllllllllllIIIlllIIIIIlIIlIIIl = lllllllllllllIIIlllIIIIIlIIlIIIl.substring(0, 40);
            }
            final Score lllllllllllllIIIlllIIIIIlIIlIIII = this.theScoreboard.getOrCreateScore(lllllllllllllIIIlllIIIIIlIIlIIIl, lllllllllllllIIIlllIIIIIlIIlIIlI);
            lllllllllllllIIIlllIIIIIlIIlIIII.setScorePoints(lllllllllllllIIIlllIIIIIlIIlIIll.getInteger("Score"));
            if (lllllllllllllIIIlllIIIIIlIIlIIll.hasKey("Locked")) {
                lllllllllllllIIIlllIIIIIlIIlIIII.setLocked(lllllllllllllIIIlllIIIIIlIIlIIll.getBoolean("Locked"));
            }
        }
    }
}
