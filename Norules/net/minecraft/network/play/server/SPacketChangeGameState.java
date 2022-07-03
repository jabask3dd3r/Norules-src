package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketChangeGameState implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ float value;
    private /* synthetic */ int state;
    
    public float getValue() {
        return this.value;
    }
    
    public SPacketChangeGameState(final int llllllllllllllIllIIlIlllIlllIlIl, final float llllllllllllllIllIIlIlllIlllIIll) {
        this.state = llllllllllllllIllIIlIlllIlllIlIl;
        this.value = llllllllllllllIllIIlIlllIlllIIll;
    }
    
    public SPacketChangeGameState() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIllIIlIlllIlIlIIll) {
        llllllllllllllIllIIlIlllIlIlIIll.handleChangeGameState(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIllIIlIlllIlIlllII) throws IOException {
        llllllllllllllIllIIlIlllIlIlllII.writeByte(this.state);
        llllllllllllllIllIIlIlllIlIlllII.writeFloat(this.value);
    }
    
    static {
        MESSAGE_NAMES = new String[] { "tile.bed.notValid" };
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIllIIlIlllIllIIlII) throws IOException {
        this.state = llllllllllllllIllIIlIlllIllIIlII.readUnsignedByte();
        this.value = llllllllllllllIllIIlIlllIllIIlII.readFloat();
    }
    
    public int getGameState() {
        return this.state;
    }
}
