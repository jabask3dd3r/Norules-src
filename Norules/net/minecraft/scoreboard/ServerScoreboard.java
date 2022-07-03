package net.minecraft.scoreboard;

import net.minecraft.server.*;
import net.minecraft.network.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.player.*;

public class ServerScoreboard extends Scoreboard
{
    private final /* synthetic */ MinecraftServer scoreboardMCServer;
    private final /* synthetic */ Set<ScoreObjective> addedObjectives;
    private /* synthetic */ Runnable[] dirtyRunnables;
    
    @Override
    public void broadcastTeamInfoUpdate(final ScorePlayerTeam llllllllllllllllIIIIIlIlIllIlllI) {
        super.broadcastTeamInfoUpdate(llllllllllllllllIIIIIlIlIllIlllI);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(llllllllllllllllIIIIIlIlIllIlllI, 2));
        this.markSaveDataDirty();
    }
    
    public ServerScoreboard(final MinecraftServer llllllllllllllllIIIIIlIlllIIIIlI) {
        this.addedObjectives = (Set<ScoreObjective>)Sets.newHashSet();
        this.dirtyRunnables = new Runnable[0];
        this.scoreboardMCServer = llllllllllllllllIIIIIlIlllIIIIlI;
    }
    
    @Override
    public void onScoreObjectiveAdded(final ScoreObjective llllllllllllllllIIIIIlIllIIIlIII) {
        super.onScoreObjectiveAdded(llllllllllllllllIIIIIlIllIIIlIII);
        this.markSaveDataDirty();
    }
    
    @Override
    public void broadcastScoreUpdate(final String llllllllllllllllIIIIIlIllIlllIII) {
        super.broadcastScoreUpdate(llllllllllllllllIIIIIlIllIlllIII);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketUpdateScore(llllllllllllllllIIIIIlIllIlllIII));
        this.markSaveDataDirty();
    }
    
    @Override
    public void removePlayerFromTeam(final String llllllllllllllllIIIIIlIllIIlIIII, final ScorePlayerTeam llllllllllllllllIIIIIlIllIIIllll) {
        super.removePlayerFromTeam(llllllllllllllllIIIIIlIllIIlIIII, llllllllllllllllIIIIIlIllIIIllll);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(llllllllllllllllIIIIIlIllIIIllll, Arrays.asList(llllllllllllllllIIIIIlIllIIlIIII), 4));
        this.markSaveDataDirty();
    }
    
    protected void markSaveDataDirty() {
        final int llllllllllllllllIIIIIlIlIlIlIllI;
        final long llllllllllllllllIIIIIlIlIlIlIlll = ((Runnable[])(Object)(llllllllllllllllIIIIIlIlIlIlIllI = (int)(Object)this.dirtyRunnables)).length;
        for (char llllllllllllllllIIIIIlIlIlIllIII = '\0'; llllllllllllllllIIIIIlIlIlIllIII < llllllllllllllllIIIIIlIlIlIlIlll; ++llllllllllllllllIIIIIlIlIlIllIII) {
            final Runnable llllllllllllllllIIIIIlIlIlIllIll = llllllllllllllllIIIIIlIlIlIlIllI[llllllllllllllllIIIIIlIlIlIllIII];
            llllllllllllllllIIIIIlIlIlIllIll.run();
        }
    }
    
    public int getObjectiveDisplaySlotCount(final ScoreObjective llllllllllllllllIIIIIlIlIIIIllll) {
        int llllllllllllllllIIIIIlIlIIIIlllI = 0;
        for (int llllllllllllllllIIIIIlIlIIIIllIl = 0; llllllllllllllllIIIIIlIlIIIIllIl < 19; ++llllllllllllllllIIIIIlIlIIIIllIl) {
            if (this.getObjectiveInDisplaySlot(llllllllllllllllIIIIIlIlIIIIllIl) == llllllllllllllllIIIIIlIlIIIIllll) {
                ++llllllllllllllllIIIIIlIlIIIIlllI;
            }
        }
        return llllllllllllllllIIIIIlIlIIIIlllI;
    }
    
    @Override
    public void onScoreObjectiveRemoved(final ScoreObjective llllllllllllllllIIIIIlIlIlllllII) {
        super.onScoreObjectiveRemoved(llllllllllllllllIIIIIlIlIlllllII);
        if (this.addedObjectives.contains(llllllllllllllllIIIIIlIlIlllllII)) {
            this.sendDisplaySlotRemovalPackets(llllllllllllllllIIIIIlIlIlllllII);
        }
        this.markSaveDataDirty();
    }
    
    @Override
    public void setObjectiveInDisplaySlot(final int llllllllllllllllIIIIIlIllIlIIIll, final ScoreObjective llllllllllllllllIIIIIlIllIlIIllI) {
        final ScoreObjective llllllllllllllllIIIIIlIllIlIIlIl = this.getObjectiveInDisplaySlot(llllllllllllllllIIIIIlIllIlIIIll);
        super.setObjectiveInDisplaySlot(llllllllllllllllIIIIIlIllIlIIIll, llllllllllllllllIIIIIlIllIlIIllI);
        if (llllllllllllllllIIIIIlIllIlIIlIl != llllllllllllllllIIIIIlIllIlIIllI && llllllllllllllllIIIIIlIllIlIIlIl != null) {
            if (this.getObjectiveDisplaySlotCount(llllllllllllllllIIIIIlIllIlIIlIl) > 0) {
                this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketDisplayObjective(llllllllllllllllIIIIIlIllIlIIIll, llllllllllllllllIIIIIlIllIlIIllI));
            }
            else {
                this.sendDisplaySlotRemovalPackets(llllllllllllllllIIIIIlIllIlIIlIl);
            }
        }
        if (llllllllllllllllIIIIIlIllIlIIllI != null) {
            if (this.addedObjectives.contains(llllllllllllllllIIIIIlIllIlIIllI)) {
                this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketDisplayObjective(llllllllllllllllIIIIIlIllIlIIIll, llllllllllllllllIIIIIlIllIlIIllI));
            }
            else {
                this.addObjective(llllllllllllllllIIIIIlIllIlIIllI);
            }
        }
        this.markSaveDataDirty();
    }
    
    @Override
    public void broadcastScoreUpdate(final String llllllllllllllllIIIIIlIllIllIIIl, final ScoreObjective llllllllllllllllIIIIIlIllIllIIII) {
        super.broadcastScoreUpdate(llllllllllllllllIIIIIlIllIllIIIl, llllllllllllllllIIIIIlIllIllIIII);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketUpdateScore(llllllllllllllllIIIIIlIllIllIIIl, llllllllllllllllIIIIIlIllIllIIII));
        this.markSaveDataDirty();
    }
    
    @Override
    public void broadcastTeamRemove(final ScorePlayerTeam llllllllllllllllIIIIIlIlIllIlIII) {
        super.broadcastTeamRemove(llllllllllllllllIIIIIlIlIllIlIII);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(llllllllllllllllIIIIIlIlIllIlIII, 1));
        this.markSaveDataDirty();
    }
    
    public void addDirtyRunnable(final Runnable llllllllllllllllIIIIIlIlIllIIIlI) {
        this.dirtyRunnables = Arrays.copyOf(this.dirtyRunnables, this.dirtyRunnables.length + 1);
        this.dirtyRunnables[this.dirtyRunnables.length - 1] = llllllllllllllllIIIIIlIlIllIIIlI;
    }
    
    public List<Packet<?>> getCreatePackets(final ScoreObjective llllllllllllllllIIIIIlIlIlIIllll) {
        final List<Packet<?>> llllllllllllllllIIIIIlIlIlIIlllI = (List<Packet<?>>)Lists.newArrayList();
        llllllllllllllllIIIIIlIlIlIIlllI.add(new SPacketScoreboardObjective(llllllllllllllllIIIIIlIlIlIIllll, 0));
        for (int llllllllllllllllIIIIIlIlIlIIllIl = 0; llllllllllllllllIIIIIlIlIlIIllIl < 19; ++llllllllllllllllIIIIIlIlIlIIllIl) {
            if (this.getObjectiveInDisplaySlot(llllllllllllllllIIIIIlIlIlIIllIl) == llllllllllllllllIIIIIlIlIlIIllll) {
                llllllllllllllllIIIIIlIlIlIIlllI.add(new SPacketDisplayObjective(llllllllllllllllIIIIIlIlIlIIllIl, llllllllllllllllIIIIIlIlIlIIllll));
            }
        }
        for (final Score llllllllllllllllIIIIIlIlIlIIllII : this.getSortedScores(llllllllllllllllIIIIIlIlIlIIllll)) {
            llllllllllllllllIIIIIlIlIlIIlllI.add(new SPacketUpdateScore(llllllllllllllllIIIIIlIlIlIIllII));
        }
        return llllllllllllllllIIIIIlIlIlIIlllI;
    }
    
    @Override
    public void broadcastTeamCreated(final ScorePlayerTeam llllllllllllllllIIIIIlIlIlllIlII) {
        super.broadcastTeamCreated(llllllllllllllllIIIIIlIlIlllIlII);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(llllllllllllllllIIIIIlIlIlllIlII, 0));
        this.markSaveDataDirty();
    }
    
    public void addObjective(final ScoreObjective llllllllllllllllIIIIIlIlIIlllIIl) {
        final List<Packet<?>> llllllllllllllllIIIIIlIlIIllllIl = this.getCreatePackets(llllllllllllllllIIIIIlIlIIlllIIl);
        for (final EntityPlayerMP llllllllllllllllIIIIIlIlIIllllII : this.scoreboardMCServer.getPlayerList().getPlayerList()) {
            for (final Packet<?> llllllllllllllllIIIIIlIlIIlllIll : llllllllllllllllIIIIIlIlIIllllIl) {
                llllllllllllllllIIIIIlIlIIllllII.connection.sendPacket(llllllllllllllllIIIIIlIlIIlllIll);
            }
        }
        this.addedObjectives.add(llllllllllllllllIIIIIlIlIIlllIIl);
    }
    
    @Override
    public void onScoreUpdated(final Score llllllllllllllllIIIIIlIllIlllllI) {
        super.onScoreUpdated(llllllllllllllllIIIIIlIllIlllllI);
        if (this.addedObjectives.contains(llllllllllllllllIIIIIlIllIlllllI.getObjective())) {
            this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketUpdateScore(llllllllllllllllIIIIIlIllIlllllI));
        }
        this.markSaveDataDirty();
    }
    
    @Override
    public boolean addPlayerToTeam(final String llllllllllllllllIIIIIlIllIIlIlll, final String llllllllllllllllIIIIIlIllIIlIllI) {
        if (super.addPlayerToTeam(llllllllllllllllIIIIIlIllIIlIlll, llllllllllllllllIIIIIlIllIIlIllI)) {
            final ScorePlayerTeam llllllllllllllllIIIIIlIllIIllIIl = this.getTeam(llllllllllllllllIIIIIlIllIIlIllI);
            this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(llllllllllllllllIIIIIlIllIIllIIl, Arrays.asList(llllllllllllllllIIIIIlIllIIlIlll), 3));
            this.markSaveDataDirty();
            return true;
        }
        return false;
    }
    
    public List<Packet<?>> getDestroyPackets(final ScoreObjective llllllllllllllllIIIIIlIlIIlIlIlI) {
        final List<Packet<?>> llllllllllllllllIIIIIlIlIIlIllIl = (List<Packet<?>>)Lists.newArrayList();
        llllllllllllllllIIIIIlIlIIlIllIl.add(new SPacketScoreboardObjective(llllllllllllllllIIIIIlIlIIlIlIlI, 1));
        for (int llllllllllllllllIIIIIlIlIIlIllII = 0; llllllllllllllllIIIIIlIlIIlIllII < 19; ++llllllllllllllllIIIIIlIlIIlIllII) {
            if (this.getObjectiveInDisplaySlot(llllllllllllllllIIIIIlIlIIlIllII) == llllllllllllllllIIIIIlIlIIlIlIlI) {
                llllllllllllllllIIIIIlIlIIlIllIl.add(new SPacketDisplayObjective(llllllllllllllllIIIIIlIlIIlIllII, llllllllllllllllIIIIIlIlIIlIlIlI));
            }
        }
        return llllllllllllllllIIIIIlIlIIlIllIl;
    }
    
    @Override
    public void onObjectiveDisplayNameChanged(final ScoreObjective llllllllllllllllIIIIIlIllIIIIIII) {
        super.onObjectiveDisplayNameChanged(llllllllllllllllIIIIIlIllIIIIIII);
        if (this.addedObjectives.contains(llllllllllllllllIIIIIlIllIIIIIII)) {
            this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketScoreboardObjective(llllllllllllllllIIIIIlIllIIIIIII, 2));
        }
        this.markSaveDataDirty();
    }
    
    public void sendDisplaySlotRemovalPackets(final ScoreObjective llllllllllllllllIIIIIlIlIIIllIlI) {
        final List<Packet<?>> llllllllllllllllIIIIIlIlIIIllllI = this.getDestroyPackets(llllllllllllllllIIIIIlIlIIIllIlI);
        for (final EntityPlayerMP llllllllllllllllIIIIIlIlIIIlllIl : this.scoreboardMCServer.getPlayerList().getPlayerList()) {
            for (final Packet<?> llllllllllllllllIIIIIlIlIIIlllII : llllllllllllllllIIIIIlIlIIIllllI) {
                llllllllllllllllIIIIIlIlIIIlllIl.connection.sendPacket(llllllllllllllllIIIIIlIlIIIlllII);
            }
        }
        this.addedObjectives.remove(llllllllllllllllIIIIIlIlIIIllIlI);
    }
}
