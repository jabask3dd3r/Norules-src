package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class Scoreboard extends StoredObject
{
    private /* synthetic */ HashMap<String, ScoreTeam> scoreTeams;
    private /* synthetic */ String colorIndependentSidebar;
    private /* synthetic */ HashSet<String> objectives;
    private /* synthetic */ HashSet<String> scoreTeamNames;
    private /* synthetic */ HashMap<Byte, String> colorDependentSidebar;
    private /* synthetic */ HashMap<String, Byte> teamColors;
    private /* synthetic */ HashMap<String, List<String>> teams;
    
    public void addTeam(final String llllllllllllllllllIllIIIIIIlIIll) {
        this.teams.computeIfAbsent(llllllllllllllllllIllIIIIIIlIIll, llllllllllllllllllIlIllllIIIlIlI -> new ArrayList());
    }
    
    public Scoreboard(final UserConnection llllllllllllllllllIllIIIIIllIIll) {
        super(llllllllllllllllllIllIIIIIllIIll);
        this.teams = new HashMap<String, List<String>>();
        this.objectives = new HashSet<String>();
        this.scoreTeams = new HashMap<String, ScoreTeam>();
        this.teamColors = new HashMap<String, Byte>();
        this.scoreTeamNames = new HashSet<String>();
        this.colorDependentSidebar = new HashMap<Byte, String>();
    }
    
    public void removePlayerFromTeam(final String llllllllllllllllllIlIlllllllllIl, final String llllllllllllllllllIllIIIIIIIIIII) {
        final List<String> llllllllllllllllllIlIlllllllllll = this.teams.get(llllllllllllllllllIllIIIIIIIIIII);
        if (llllllllllllllllllIlIlllllllllll != null) {
            llllllllllllllllllIlIlllllllllll.remove(llllllllllllllllllIlIlllllllllIl);
        }
    }
    
    public String getColorIndependentSidebar() {
        return this.colorIndependentSidebar;
    }
    
    public void removeObjective(final String llllllllllllllllllIlIlllllIIIllI) {
        this.objectives.remove(llllllllllllllllllIlIlllllIIIllI);
        this.colorDependentSidebar.values().remove(llllllllllllllllllIlIlllllIIIllI);
        if (llllllllllllllllllIlIlllllIIIllI.equals(this.colorIndependentSidebar)) {
            this.colorIndependentSidebar = null;
        }
    }
    
    public void removeTeam(final String llllllllllllllllllIllIIIIIIIllll) {
        this.teams.remove(llllllllllllllllllIllIIIIIIIllll);
        this.scoreTeams.remove(llllllllllllllllllIllIIIIIIIllll);
        this.teamColors.remove(llllllllllllllllllIllIIIIIIIllll);
    }
    
    public HashMap<Byte, String> getColorDependentSidebar() {
        return this.colorDependentSidebar;
    }
    
    public Optional<Byte> getPlayerTeamColor(final String llllllllllllllllllIlIlllllIlllll) {
        final Optional<String> llllllllllllllllllIlIlllllIllllI = this.getTeam(llllllllllllllllllIlIlllllIlllll);
        return llllllllllllllllllIlIlllllIllllI.isPresent() ? this.getTeamColor(llllllllllllllllllIlIlllllIllllI.get()) : Optional.empty();
    }
    
    public String sendTeamForScore(final String llllllllllllllllllIlIllllIllIIll) {
        if (llllllllllllllllllIlIllllIllIIll.length() <= 16) {
            return llllllllllllllllllIlIllllIllIIll;
        }
        if (this.scoreTeams.containsKey(llllllllllllllllllIlIllllIllIIll)) {
            return this.scoreTeams.get(llllllllllllllllllIlIllllIllIIll).name;
        }
        int llllllllllllllllllIlIllllIllIIlI;
        int llllllllllllllllllIlIllllIllIIIl;
        String llllllllllllllllllIlIllllIllIIII;
        for (llllllllllllllllllIlIllllIllIIlI = 16, llllllllllllllllllIlIllllIllIIIl = Math.min(16, llllllllllllllllllIlIllllIllIIll.length() - 16), llllllllllllllllllIlIllllIllIIII = llllllllllllllllllIlIllllIllIIll.substring(llllllllllllllllllIlIllllIllIIIl, llllllllllllllllllIlIllllIllIIIl + llllllllllllllllllIlIllllIllIIlI); this.scoreTeamNames.contains(llllllllllllllllllIlIllllIllIIII) || this.teams.containsKey(llllllllllllllllllIlIllllIllIIII); llllllllllllllllllIlIllllIllIIII = llllllllllllllllllIlIllllIllIIll.substring(llllllllllllllllllIlIllllIllIIIl, llllllllllllllllllIlIllllIllIIIl + llllllllllllllllllIlIllllIllIIlI)) {
            --llllllllllllllllllIlIllllIllIIIl;
            while (llllllllllllllllllIlIllllIllIIll.length() - llllllllllllllllllIlIllllIllIIlI - llllllllllllllllllIlIllllIllIIIl > 16) {
                if (--llllllllllllllllllIlIllllIllIIlI < 1) {
                    return llllllllllllllllllIlIllllIllIIll;
                }
                llllllllllllllllllIlIllllIllIIIl = Math.min(16, llllllllllllllllllIlIllllIllIIll.length() - llllllllllllllllllIlIllllIllIIlI);
            }
        }
        final String llllllllllllllllllIlIllllIlIllll = llllllllllllllllllIlIllllIllIIll.substring(0, llllllllllllllllllIlIllllIllIIIl);
        final String llllllllllllllllllIlIllllIlIlllI = (llllllllllllllllllIlIllllIllIIIl + llllllllllllllllllIlIllllIllIIlI >= llllllllllllllllllIlIllllIllIIll.length()) ? "" : llllllllllllllllllIlIllllIllIIll.substring(llllllllllllllllllIlIllllIllIIIl + llllllllllllllllllIlIllllIllIIlI, llllllllllllllllllIlIllllIllIIll.length());
        final ScoreTeam llllllllllllllllllIlIllllIlIllIl = new ScoreTeam(llllllllllllllllllIlIllllIllIIII, llllllllllllllllllIlIllllIlIllll, llllllllllllllllllIlIllllIlIlllI);
        this.scoreTeams.put(llllllllllllllllllIlIllllIllIIll, llllllllllllllllllIlIllllIlIllIl);
        this.scoreTeamNames.add(llllllllllllllllllIlIllllIllIIII);
        final PacketWrapper llllllllllllllllllIlIllllIlIllII = PacketWrapper.create(62, null, this.getUser());
        llllllllllllllllllIlIllllIlIllII.write(Type.STRING, llllllllllllllllllIlIllllIllIIII);
        llllllllllllllllllIlIllllIlIllII.write(Type.BYTE, (Byte)0);
        llllllllllllllllllIlIllllIlIllII.write(Type.STRING, "ViaRewind");
        llllllllllllllllllIlIllllIlIllII.write(Type.STRING, llllllllllllllllllIlIllllIlIllll);
        llllllllllllllllllIlIllllIlIllII.write(Type.STRING, llllllllllllllllllIlIllllIlIlllI);
        llllllllllllllllllIlIllllIlIllII.write(Type.BYTE, (Byte)0);
        llllllllllllllllllIlIllllIlIllII.write(Type.SHORT, (Short)1);
        llllllllllllllllllIlIllllIlIllII.write(Type.STRING, llllllllllllllllllIlIllllIllIIII);
        PacketUtil.sendPacket(llllllllllllllllllIlIllllIlIllII, Protocol1_7_6_10TO1_8.class, true, true);
        return llllllllllllllllllIlIllllIllIIII;
    }
    
    public void setColorIndependentSidebar(final String llllllllllllllllllIlIllllIIIllIl) {
        this.colorIndependentSidebar = llllllllllllllllllIlIllllIIIllIl;
    }
    
    public String removeTeamForScore(final String llllllllllllllllllIlIllllIIlllIl) {
        final ScoreTeam llllllllllllllllllIlIllllIIlllII = this.scoreTeams.remove(llllllllllllllllllIlIllllIIlllIl);
        if (llllllllllllllllllIlIllllIIlllII == null) {
            return llllllllllllllllllIlIllllIIlllIl;
        }
        this.scoreTeamNames.remove(llllllllllllllllllIlIllllIIlllII.name);
        final PacketWrapper llllllllllllllllllIlIllllIIllIll = PacketWrapper.create(62, null, this.getUser());
        llllllllllllllllllIlIllllIIllIll.write(Type.STRING, llllllllllllllllllIlIllllIIlllII.name);
        llllllllllllllllllIlIllllIIllIll.write(Type.BYTE, (Byte)1);
        PacketUtil.sendPacket(llllllllllllllllllIlIllllIIllIll, Protocol1_7_6_10TO1_8.class, true, true);
        return llllllllllllllllllIlIllllIIlllII.name;
    }
    
    public void addPlayerToTeam(final String llllllllllllllllllIllIIIIIlIllII, final String llllllllllllllllllIllIIIIIlIlIII) {
        this.teams.computeIfAbsent(llllllllllllllllllIllIIIIIlIlIII, llllllllllllllllllIlIllllIIIlIIl -> new ArrayList()).add(llllllllllllllllllIllIIIIIlIllII);
    }
    
    public void addObjective(final String llllllllllllllllllIlIlllllIIlIlI) {
        this.objectives.add(llllllllllllllllllIlIlllllIIlIlI);
    }
    
    public boolean isPlayerInTeam(final String llllllllllllllllllIlIlllllllIIIl, final String llllllllllllllllllIlIlllllllIIII) {
        final List<String> llllllllllllllllllIlIlllllllIIll = this.teams.get(llllllllllllllllllIlIlllllllIIII);
        return llllllllllllllllllIlIlllllllIIll != null && llllllllllllllllllIlIlllllllIIll.contains(llllllllllllllllllIlIlllllllIIIl);
    }
    
    public Optional<Byte> getTeamColor(final String llllllllllllllllllIllIIIIIIllIll) {
        return Optional.ofNullable(this.teamColors.get(llllllllllllllllllIllIIIIIIllIll));
    }
    
    public boolean teamExists(final String llllllllllllllllllIllIIIIIIIIlll) {
        return this.teams.containsKey(llllllllllllllllllIllIIIIIIIIlll);
    }
    
    public Optional<String> getTeam(final String llllllllllllllllllIlIlllllIlIIlI) {
        for (final Map.Entry<String, List<String>> llllllllllllllllllIlIlllllIlIllI : this.teams.entrySet()) {
            if (llllllllllllllllllIlIlllllIlIllI.getValue().contains(llllllllllllllllllIlIlllllIlIIlI)) {
                return Optional.of(llllllllllllllllllIlIlllllIlIllI.getKey());
            }
        }
        return Optional.empty();
    }
    
    public boolean objectiveExists(final String llllllllllllllllllIlIllllIlllllI) {
        return this.objectives.contains(llllllllllllllllllIlIllllIlllllI);
    }
    
    public void setTeamColor(final String llllllllllllllllllIllIIIIIlIIIll, final Byte llllllllllllllllllIllIIIIIlIIIlI) {
        this.teamColors.put(llllllllllllllllllIllIIIIIlIIIll, llllllllllllllllllIllIIIIIlIIIlI);
    }
    
    public boolean isPlayerInTeam(final String llllllllllllllllllIlIllllllIIllI) {
        for (final List<String> llllllllllllllllllIlIllllllIlIlI : this.teams.values()) {
            if (llllllllllllllllllIlIllllllIlIlI.contains(llllllllllllllllllIlIllllllIIllI)) {
                return true;
            }
        }
        return false;
    }
    
    private class ScoreTeam
    {
        private /* synthetic */ String name;
        private /* synthetic */ String suffix;
        private /* synthetic */ String prefix;
        
        public ScoreTeam(final String llllllllllllllllIllIlIIlIIlIIlll, final String llllllllllllllllIllIlIIlIIlIIllI, final String llllllllllllllllIllIlIIlIIlIIlIl) {
            this.prefix = llllllllllllllllIllIlIIlIIlIIllI;
            this.suffix = llllllllllllllllIllIlIIlIIlIIlIl;
            this.name = llllllllllllllllIllIlIIlIIlIIlll;
        }
    }
}
