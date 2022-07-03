package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.network.*;

public class CPacketPlayerTryUseItem implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumHand hand;
    
    public CPacketPlayerTryUseItem() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIlIIllllIIlIllI) throws IOException {
        llllllllllllllIlIIlIIllllIIlIllI.writeEnumValue(this.hand);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIlIIllllIIlllII) throws IOException {
        this.hand = llllllllllllllIlIIlIIllllIIlllII.readEnumValue(EnumHand.class);
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
    
    public CPacketPlayerTryUseItem(final EnumHand llllllllllllllIlIIlIIllllIlIIIlI) {
        this.hand = llllllllllllllIlIIlIIllllIlIIIlI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIlIIlIIllllIIlIIII) {
        llllllllllllllIlIIlIIllllIIlIIII.processPlayerBlockPlacement(this);
    }
}
