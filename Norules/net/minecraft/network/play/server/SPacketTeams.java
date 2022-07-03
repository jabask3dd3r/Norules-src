package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import com.google.common.collect.*;
import java.io.*;
import net.minecraft.scoreboard.*;
import net.minecraft.network.*;

public class SPacketTeams implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String collisionRule;
    private /* synthetic */ String nameTagVisibility;
    private /* synthetic */ int action;
    private /* synthetic */ String suffix;
    private /* synthetic */ int color;
    private /* synthetic */ String prefix;
    private /* synthetic */ String displayName;
    private final /* synthetic */ Collection<String> players;
    private /* synthetic */ int friendlyFlags;
    private /* synthetic */ String name;
    
    public SPacketTeams() {
        this.name = "";
        this.displayName = "";
        this.prefix = "";
        this.suffix = "";
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.collisionRule = Team.CollisionRule.ALWAYS.name;
        this.color = -1;
        this.players = (Collection<String>)Lists.newArrayList();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lIlIllIllllllI) {
        if (lIlIllIllllllI != null) {
            lIlIllIllllllI.handleTeams(this);
        }
    }
    
    public Collection<String> getPlayers() {
        return this.players;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public int getAction() {
        return this.action;
    }
    
    public int getFriendlyFlags() {
        return this.friendlyFlags;
    }
    
    public String getCollisionRule() {
        return this.collisionRule;
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lIlIlllIIlIIll) throws IOException {
        this.name = lIlIlllIIlIIll.readStringFromBuffer(16);
        this.action = lIlIlllIIlIIll.readByte();
        if (this.action == 0 || this.action == 2) {
            this.displayName = lIlIlllIIlIIll.readStringFromBuffer(32);
            this.prefix = lIlIlllIIlIIll.readStringFromBuffer(16);
            this.suffix = lIlIlllIIlIIll.readStringFromBuffer(16);
            this.friendlyFlags = lIlIlllIIlIIll.readByte();
            this.nameTagVisibility = lIlIlllIIlIIll.readStringFromBuffer(32);
            this.collisionRule = lIlIlllIIlIIll.readStringFromBuffer(32);
            this.color = lIlIlllIIlIIll.readByte();
        }
        if (this.action == 0 || this.action == 3 || this.action == 4) {
            for (int lIlIlllIIlIIlI = lIlIlllIIlIIll.readVarIntFromBuffer(), lIlIlllIIlIIIl = 0; lIlIlllIIlIIIl < lIlIlllIIlIIlI; ++lIlIlllIIlIIIl) {
                this.players.add(lIlIlllIIlIIll.readStringFromBuffer(40));
            }
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lIlIlllIIIIlll) throws IOException {
        lIlIlllIIIIlll.writeString(this.name);
        lIlIlllIIIIlll.writeByte(this.action);
        if (this.action == 0 || this.action == 2) {
            lIlIlllIIIIlll.writeString(this.displayName);
            lIlIlllIIIIlll.writeString(this.prefix);
            lIlIlllIIIIlll.writeString(this.suffix);
            lIlIlllIIIIlll.writeByte(this.friendlyFlags);
            lIlIlllIIIIlll.writeString(this.nameTagVisibility);
            lIlIlllIIIIlll.writeString(this.collisionRule);
            lIlIlllIIIIlll.writeByte(this.color);
        }
        if (this.action == 0 || this.action == 3 || this.action == 4) {
            lIlIlllIIIIlll.writeVarIntToBuffer(this.players.size());
            for (final String lIlIlllIIIIllI : this.players) {
                lIlIlllIIIIlll.writeString(lIlIlllIIIIllI);
            }
        }
    }
    
    public String getNameTagVisibility() {
        return this.nameTagVisibility;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public SPacketTeams(final ScorePlayerTeam lIlIlllIlIIIIl, final Collection<String> lIlIlllIlIIlII, final int lIlIlllIlIIIll) {
        this.name = "";
        this.displayName = "";
        this.prefix = "";
        this.suffix = "";
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.collisionRule = Team.CollisionRule.ALWAYS.name;
        this.color = -1;
        this.players = (Collection<String>)Lists.newArrayList();
        if (lIlIlllIlIIIll != 3 && lIlIlllIlIIIll != 4) {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        if (lIlIlllIlIIlII != null && !lIlIlllIlIIlII.isEmpty()) {
            this.action = lIlIlllIlIIIll;
            this.name = lIlIlllIlIIIIl.getRegisteredName();
            this.players.addAll(lIlIlllIlIIlII);
            return;
        }
        throw new IllegalArgumentException("Players cannot be null/empty");
    }
    
    public int getColor() {
        return this.color;
    }
    
    public SPacketTeams(final ScorePlayerTeam lIlIllllIIIllI, final int lIlIlllIlllllI) {
        this.name = "";
        this.displayName = "";
        this.prefix = "";
        this.suffix = "";
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.collisionRule = Team.CollisionRule.ALWAYS.name;
        this.color = -1;
        this.players = (Collection<String>)Lists.newArrayList();
        this.name = lIlIllllIIIllI.getRegisteredName();
        this.action = lIlIlllIlllllI;
        if (lIlIlllIlllllI == 0 || lIlIlllIlllllI == 2) {
            this.displayName = lIlIllllIIIllI.getTeamName();
            this.prefix = lIlIllllIIIllI.getColorPrefix();
            this.suffix = lIlIllllIIIllI.getColorSuffix();
            this.friendlyFlags = lIlIllllIIIllI.getFriendlyFlags();
            this.nameTagVisibility = lIlIllllIIIllI.getNameTagVisibility().internalName;
            this.collisionRule = lIlIllllIIIllI.getCollisionRule().name;
            this.color = lIlIllllIIIllI.getChatFormat().getColorIndex();
        }
        if (lIlIlllIlllllI == 0) {
            this.players.addAll(lIlIllllIIIllI.getMembershipCollection());
        }
    }
}
