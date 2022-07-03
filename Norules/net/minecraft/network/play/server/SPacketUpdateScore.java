package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.scoreboard.*;
import net.minecraft.network.*;

public class SPacketUpdateScore implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int value;
    private /* synthetic */ String name;
    private /* synthetic */ Action action;
    private /* synthetic */ String objective;
    
    public SPacketUpdateScore(final Score lllllllllllllIllIlIlIlIllIIllIll) {
        this.name = "";
        this.objective = "";
        this.name = lllllllllllllIllIlIlIlIllIIllIll.getPlayerName();
        this.objective = lllllllllllllIllIlIlIlIllIIllIll.getObjective().getName();
        this.value = lllllllllllllIllIlIlIlIllIIllIll.getScorePoints();
        this.action = Action.CHANGE;
    }
    
    public Action getScoreAction() {
        return this.action;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllIlIlIlIlIllllIlI) {
        lllllllllllllIllIlIlIlIlIllllIlI.handleUpdateScore(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIlIlIlIllIIIIlII) throws IOException {
        this.name = lllllllllllllIllIlIlIlIllIIIIlII.readStringFromBuffer(40);
        this.action = lllllllllllllIllIlIlIlIllIIIIlII.readEnumValue(Action.class);
        this.objective = lllllllllllllIllIlIlIlIllIIIIlII.readStringFromBuffer(16);
        if (this.action != Action.REMOVE) {
            this.value = lllllllllllllIllIlIlIlIllIIIIlII.readVarIntFromBuffer();
        }
    }
    
    public SPacketUpdateScore(final String lllllllllllllIllIlIlIlIllIIlIlIl) {
        this.name = "";
        this.objective = "";
        this.name = lllllllllllllIllIlIlIlIllIIlIlIl;
        this.objective = "";
        this.value = 0;
        this.action = Action.REMOVE;
    }
    
    public int getScoreValue() {
        return this.value;
    }
    
    public String getObjectiveName() {
        return this.objective;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIlIlIlIllIIIIIII) throws IOException {
        lllllllllllllIllIlIlIlIllIIIIIII.writeString(this.name);
        lllllllllllllIllIlIlIlIllIIIIIII.writeEnumValue(this.action);
        lllllllllllllIllIlIlIlIllIIIIIII.writeString(this.objective);
        if (this.action != Action.REMOVE) {
            lllllllllllllIllIlIlIlIllIIIIIII.writeVarIntToBuffer(this.value);
        }
    }
    
    public SPacketUpdateScore(final String lllllllllllllIllIlIlIlIllIIIlllI, final ScoreObjective lllllllllllllIllIlIlIlIllIIIlIlI) {
        this.name = "";
        this.objective = "";
        this.name = lllllllllllllIllIlIlIlIllIIIlllI;
        this.objective = lllllllllllllIllIlIlIlIllIIIlIlI.getName();
        this.value = 0;
        this.action = Action.REMOVE;
    }
    
    public SPacketUpdateScore() {
        this.name = "";
        this.objective = "";
    }
    
    public String getPlayerName() {
        return this.name;
    }
    
    public enum Action
    {
        CHANGE("CHANGE", 0), 
        REMOVE("REMOVE", 1);
        
        private Action(final String lllllllllllllllIIlIIIIlIlllIIIII, final int lllllllllllllllIIlIIIIlIllIlllll) {
        }
    }
}
