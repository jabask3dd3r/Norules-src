package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.util.text.*;

public class CPacketUpdateSign implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ BlockPos pos;
    private /* synthetic */ String[] lines;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIIlllIIlIIIlll) throws IOException {
        this.pos = llllllllllllllIllIIIlllIIlIIIlll.readBlockPos();
        this.lines = new String[4];
        for (int llllllllllllllIllIIIlllIIlIIlIIl = 0; llllllllllllllIllIIIlllIIlIIlIIl < 4; ++llllllllllllllIllIIIlllIIlIIlIIl) {
            this.lines[llllllllllllllIllIIIlllIIlIIlIIl] = llllllllllllllIllIIIlllIIlIIIlll.readStringFromBuffer(384);
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIIlllIIlIIIIIl) throws IOException {
        llllllllllllllIllIIIlllIIlIIIIIl.writeBlockPos(this.pos);
        for (int llllllllllllllIllIIIlllIIlIIIIII = 0; llllllllllllllIllIIIlllIIlIIIIII < 4; ++llllllllllllllIllIIIlllIIlIIIIII) {
            llllllllllllllIllIIIlllIIlIIIIIl.writeString(this.lines[llllllllllllllIllIIIlllIIlIIIIII]);
        }
    }
    
    public String[] getLines() {
        return this.lines;
    }
    
    public CPacketUpdateSign(final BlockPos llllllllllllllIllIIIlllIIlIlIIll, final ITextComponent[] llllllllllllllIllIIIlllIIlIlIIlI) {
        this.pos = llllllllllllllIllIIIlllIIlIlIIll;
        this.lines = new String[] { llllllllllllllIllIIIlllIIlIlIIlI[0].getUnformattedText(), llllllllllllllIllIIIlllIIlIlIIlI[1].getUnformattedText(), llllllllllllllIllIIIlllIIlIlIIlI[2].getUnformattedText(), llllllllllllllIllIIIlllIIlIlIIlI[3].getUnformattedText() };
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIllIIIlllIIIllIlll) {
        llllllllllllllIllIIIlllIIIllIlll.processUpdateSign(this);
    }
    
    public BlockPos getPosition() {
        return this.pos;
    }
    
    public CPacketUpdateSign() {
    }
}
