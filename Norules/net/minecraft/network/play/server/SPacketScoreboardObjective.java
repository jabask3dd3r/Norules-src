package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.scoreboard.*;

public class SPacketScoreboardObjective implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String objectiveName;
    private /* synthetic */ int action;
    private /* synthetic */ String objectiveValue;
    private /* synthetic */ IScoreCriteria.EnumRenderType type;
    
    public SPacketScoreboardObjective() {
    }
    
    public String getObjectiveName() {
        return this.objectiveName;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIlIlIllIllIllIII) {
        lllllllllllllIlIIlIlIllIllIllIII.handleScoreboardObjective(this);
    }
    
    public int getAction() {
        return this.action;
    }
    
    public IScoreCriteria.EnumRenderType getRenderType() {
        return this.type;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIlIlIllIlllIIIIl) throws IOException {
        lllllllllllllIlIIlIlIllIlllIIIIl.writeString(this.objectiveName);
        lllllllllllllIlIIlIlIllIlllIIIIl.writeByte(this.action);
        if (this.action == 0 || this.action == 2) {
            lllllllllllllIlIIlIlIllIlllIIIIl.writeString(this.objectiveValue);
            lllllllllllllIlIIlIlIllIlllIIIIl.writeString(this.type.getRenderType());
        }
    }
    
    public SPacketScoreboardObjective(final ScoreObjective lllllllllllllIlIIlIlIlllIIIIIlII, final int lllllllllllllIlIIlIlIlllIIIIIIll) {
        this.objectiveName = lllllllllllllIlIIlIlIlllIIIIIlII.getName();
        this.objectiveValue = lllllllllllllIlIIlIlIlllIIIIIlII.getDisplayName();
        this.type = lllllllllllllIlIIlIlIlllIIIIIlII.getCriteria().getRenderType();
        this.action = lllllllllllllIlIIlIlIlllIIIIIIll;
    }
    
    public String getObjectiveValue() {
        return this.objectiveValue;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIlIlIllIlllIllII) throws IOException {
        this.objectiveName = lllllllllllllIlIIlIlIllIlllIllII.readStringFromBuffer(16);
        this.action = lllllllllllllIlIIlIlIllIlllIllII.readByte();
        if (this.action == 0 || this.action == 2) {
            this.objectiveValue = lllllllllllllIlIIlIlIllIlllIllII.readStringFromBuffer(32);
            this.type = IScoreCriteria.EnumRenderType.getByName(lllllllllllllIlIIlIlIllIlllIllII.readStringFromBuffer(16));
        }
    }
}
