package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketDestroyEntities implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int[] entityIDs;
    
    public SPacketDestroyEntities() {
    }
    
    public int[] getEntityIDs() {
        return this.entityIDs;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllllIIIlIIllIIlII) throws IOException {
        lllllllllllllIIllllIIIlIIllIIlII.writeVarIntToBuffer(this.entityIDs.length);
        double lllllllllllllIIllllIIIlIIllIIIII;
        for (String lllllllllllllIIllllIIIlIIllIIIIl = (String)((int[])(Object)(lllllllllllllIIllllIIIlIIllIIIII = (double)(Object)this.entityIDs)).length, lllllllllllllIIllllIIIlIIllIIIlI = (String)0; lllllllllllllIIllllIIIlIIllIIIlI < lllllllllllllIIllllIIIlIIllIIIIl; ++lllllllllllllIIllllIIIlIIllIIIlI) {
            final int lllllllllllllIIllllIIIlIIllIIllI = lllllllllllllIIllllIIIlIIllIIIII[lllllllllllllIIllllIIIlIIllIIIlI];
            lllllllllllllIIllllIIIlIIllIIlII.writeVarIntToBuffer(lllllllllllllIIllllIIIlIIllIIllI);
        }
    }
    
    public SPacketDestroyEntities(final int... lllllllllllllIIllllIIIlIIllllIlI) {
        this.entityIDs = lllllllllllllIIllllIIIlIIllllIlI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllllIIIlIIlllIIII) throws IOException {
        this.entityIDs = new int[lllllllllllllIIllllIIIlIIlllIIII.readVarIntFromBuffer()];
        for (int lllllllllllllIIllllIIIlIIlllIIlI = 0; lllllllllllllIIllllIIIlIIlllIIlI < this.entityIDs.length; ++lllllllllllllIIllllIIIlIIlllIIlI) {
            this.entityIDs[lllllllllllllIIllllIIIlIIlllIIlI] = lllllllllllllIIllllIIIlIIlllIIII.readVarIntFromBuffer();
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIllllIIIlIIlIlllII) {
        lllllllllllllIIllllIIIlIIlIlllII.handleDestroyEntities(this);
    }
}
