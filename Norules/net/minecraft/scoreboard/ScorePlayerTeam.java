package net.minecraft.scoreboard;

import net.minecraft.util.text.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class ScorePlayerTeam extends Team
{
    private /* synthetic */ String colorSuffix;
    private /* synthetic */ TextFormatting chatFormat;
    private /* synthetic */ boolean allowFriendlyFire;
    private /* synthetic */ CollisionRule collisionRule;
    private final /* synthetic */ Set<String> membershipSet;
    private /* synthetic */ boolean canSeeFriendlyInvisibles;
    private /* synthetic */ EnumVisible deathMessageVisibility;
    private /* synthetic */ EnumVisible nameTagVisibility;
    private final /* synthetic */ Scoreboard theScoreboard;
    private final /* synthetic */ String registeredName;
    private /* synthetic */ String namePrefixSPT;
    private /* synthetic */ String teamNameSPT;
    
    public void setNameTagVisibility(final EnumVisible lllllllllllllIllIIIIIIlIllIllIIl) {
        this.nameTagVisibility = lllllllllllllIllIIIIIIlIllIllIIl;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public int getFriendlyFlags() {
        int lllllllllllllIllIIIIIIlIllIIIlII = 0;
        if (this.getAllowFriendlyFire()) {
            lllllllllllllIllIIIIIIlIllIIIlII |= 0x1;
        }
        if (this.getSeeFriendlyInvisiblesEnabled()) {
            lllllllllllllIllIIIIIIlIllIIIlII |= 0x2;
        }
        return lllllllllllllIllIIIIIIlIllIIIlII;
    }
    
    public void setChatFormat(final TextFormatting lllllllllllllIllIIIIIIlIlIlllIII) {
        this.chatFormat = lllllllllllllIllIIIIIIlIlIlllIII;
    }
    
    @Override
    public boolean getAllowFriendlyFire() {
        return this.allowFriendlyFire;
    }
    
    public void setSeeFriendlyInvisiblesEnabled(final boolean lllllllllllllIllIIIIIIlIlllIIIll) {
        this.canSeeFriendlyInvisibles = lllllllllllllIllIIIIIIlIlllIIIll;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public String getColorSuffix() {
        return this.colorSuffix;
    }
    
    public String getColorPrefix() {
        return this.namePrefixSPT;
    }
    
    @Override
    public CollisionRule getCollisionRule() {
        return this.collisionRule;
    }
    
    public void setAllowFriendlyFire(final boolean lllllllllllllIllIIIIIIlIlllIlllI) {
        this.allowFriendlyFire = lllllllllllllIllIIIIIIlIlllIlllI;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    @Override
    public String getRegisteredName() {
        return this.registeredName;
    }
    
    public String getTeamName() {
        return this.teamNameSPT;
    }
    
    public static String formatPlayerName(@Nullable final Team lllllllllllllIllIIIIIIlIllllIllI, final String lllllllllllllIllIIIIIIlIllllIlll) {
        return (lllllllllllllIllIIIIIIlIllllIllI == null) ? lllllllllllllIllIIIIIIlIllllIlll : lllllllllllllIllIIIIIIlIllllIllI.formatString(lllllllllllllIllIIIIIIlIllllIlll);
    }
    
    public void setTeamName(final String lllllllllllllIllIIIIIIllIIIllIII) {
        if (lllllllllllllIllIIIIIIllIIIllIII == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.teamNameSPT = lllllllllllllIllIIIIIIllIIIllIII;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public void setDeathMessageVisibility(final EnumVisible lllllllllllllIllIIIIIIlIllIlIIIl) {
        this.deathMessageVisibility = lllllllllllllIllIIIIIIlIllIlIIIl;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    @Override
    public String formatString(final String lllllllllllllIllIIIIIIlIllllllIl) {
        return String.valueOf(new StringBuilder(String.valueOf(this.getColorPrefix())).append(lllllllllllllIllIIIIIIlIllllllIl).append(this.getColorSuffix()));
    }
    
    public void setCollisionRule(final CollisionRule lllllllllllllIllIIIIIIlIllIIlIII) {
        this.collisionRule = lllllllllllllIllIIIIIIlIllIIlIII;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public ScorePlayerTeam(final Scoreboard lllllllllllllIllIIIIIIllIIlIIIll, final String lllllllllllllIllIIIIIIllIIlIIIlI) {
        this.membershipSet = (Set<String>)Sets.newHashSet();
        this.namePrefixSPT = "";
        this.colorSuffix = "";
        this.allowFriendlyFire = true;
        this.canSeeFriendlyInvisibles = true;
        this.nameTagVisibility = EnumVisible.ALWAYS;
        this.deathMessageVisibility = EnumVisible.ALWAYS;
        this.chatFormat = TextFormatting.RESET;
        this.collisionRule = CollisionRule.ALWAYS;
        this.theScoreboard = lllllllllllllIllIIIIIIllIIlIIIll;
        this.registeredName = lllllllllllllIllIIIIIIllIIlIIIlI;
        this.teamNameSPT = lllllllllllllIllIIIIIIllIIlIIIlI;
    }
    
    @Override
    public EnumVisible getDeathMessageVisibility() {
        return this.deathMessageVisibility;
    }
    
    @Override
    public TextFormatting getChatFormat() {
        return this.chatFormat;
    }
    
    @Override
    public boolean getSeeFriendlyInvisiblesEnabled() {
        return this.canSeeFriendlyInvisibles;
    }
    
    @Override
    public EnumVisible getNameTagVisibility() {
        return this.nameTagVisibility;
    }
    
    public void setNamePrefix(final String lllllllllllllIllIIIIIIllIIIIlIlI) {
        if (lllllllllllllIllIIIIIIllIIIIlIlI == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        this.namePrefixSPT = lllllllllllllIllIIIIIIllIIIIlIlI;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public void setNameSuffix(final String lllllllllllllIllIIIIIIllIIIIIIll) {
        this.colorSuffix = lllllllllllllIllIIIIIIllIIIIIIll;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    @Override
    public Collection<String> getMembershipCollection() {
        return this.membershipSet;
    }
    
    public void setFriendlyFlags(final int lllllllllllllIllIIIIIIlIlIlllllI) {
        this.setAllowFriendlyFire((lllllllllllllIllIIIIIIlIlIlllllI & 0x1) > 0);
        this.setSeeFriendlyInvisiblesEnabled((lllllllllllllIllIIIIIIlIlIlllllI & 0x2) > 0);
    }
}
