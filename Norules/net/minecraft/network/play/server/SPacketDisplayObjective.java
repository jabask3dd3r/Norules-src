package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.scoreboard.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketDisplayObjective implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int position;
    private /* synthetic */ String scoreName;
    
    public SPacketDisplayObjective() {
    }
    
    public String getName() {
        return this.scoreName;
    }
    
    public SPacketDisplayObjective(final int lllllllllllllIlIIIlllIIIlIIlllII, final ScoreObjective lllllllllllllIlIIIlllIIIlIIllIll) {
        this.position = lllllllllllllIlIIIlllIIIlIIlllII;
        if (lllllllllllllIlIIIlllIIIlIIllIll == null) {
            this.scoreName = "";
        }
        else {
            this.scoreName = lllllllllllllIlIIIlllIIIlIIllIll.getName();
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIlllIIIlIIlIlIl) throws IOException {
        this.position = lllllllllllllIlIIIlllIIIlIIlIlIl.readByte();
        this.scoreName = lllllllllllllIlIIIlllIIIlIIlIlIl.readStringFromBuffer(16);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIIlllIIIlIIIlIIl) {
        lllllllllllllIlIIIlllIIIlIIIlIIl.handleDisplayObjective(this);
    }
    
    public int getPosition() {
        return this.position;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIlllIIIlIIlIIIl) throws IOException {
        lllllllllllllIlIIIlllIIIlIIlIIIl.writeByte(this.position);
        lllllllllllllIlIIIlllIIIlIIlIIIl.writeString(this.scoreName);
    }
}
