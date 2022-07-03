package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketAnimation implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumHand hand;
    
    public CPacketAnimation() {
    }
    
    public CPacketAnimation(final EnumHand lllllllllllllllIIllIlIlIIlllIIlI) {
        this.hand = lllllllllllllllIIllIlIlIIlllIIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllIlIlIIllIIllI) throws IOException {
        lllllllllllllllIIllIlIlIIllIIllI.writeEnumValue(this.hand);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllllIIllIlIlIIllIIIII) {
        lllllllllllllllIIllIlIlIIllIIIII.handleAnimation(this);
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllIlIlIIllIlllI) throws IOException {
        this.hand = lllllllllllllllIIllIlIlIIllIlllI.readEnumValue(EnumHand.class);
    }
}
