package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketTabComplete implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String[] matches;
    
    public String[] getMatches() {
        return this.matches;
    }
    
    public SPacketTabComplete(final String[] lllllllllllllllIllIIIIIIllIIlIII) {
        this.matches = lllllllllllllllIllIIIIIIllIIlIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIllIIIIIIlIlIlIII) {
        lllllllllllllllIllIIIIIIlIlIlIII.handleTabComplete(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIllIIIIIIllIIIIIl) throws IOException {
        this.matches = new String[lllllllllllllllIllIIIIIIllIIIIIl.readVarIntFromBuffer()];
        for (int lllllllllllllllIllIIIIIIllIIIIII = 0; lllllllllllllllIllIIIIIIllIIIIII < this.matches.length; ++lllllllllllllllIllIIIIIIllIIIIII) {
            this.matches[lllllllllllllllIllIIIIIIllIIIIII] = lllllllllllllllIllIIIIIIllIIIIIl.readStringFromBuffer(32767);
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIllIIIIIIlIllIIlI) throws IOException {
        lllllllllllllllIllIIIIIIlIllIIlI.writeVarIntToBuffer(this.matches.length);
        int lllllllllllllllIllIIIIIIlIlIlllI;
        for (Exception lllllllllllllllIllIIIIIIlIlIllll = (Exception)((String[])(Object)(lllllllllllllllIllIIIIIIlIlIlllI = (int)(Object)this.matches)).length, lllllllllllllllIllIIIIIIlIllIIII = (Exception)0; lllllllllllllllIllIIIIIIlIllIIII < lllllllllllllllIllIIIIIIlIlIllll; ++lllllllllllllllIllIIIIIIlIllIIII) {
            final String lllllllllllllllIllIIIIIIlIllIlII = lllllllllllllllIllIIIIIIlIlIlllI[lllllllllllllllIllIIIIIIlIllIIII];
            lllllllllllllllIllIIIIIIlIllIIlI.writeString(lllllllllllllllIllIIIIIIlIllIlII);
        }
    }
    
    public SPacketTabComplete() {
    }
}
