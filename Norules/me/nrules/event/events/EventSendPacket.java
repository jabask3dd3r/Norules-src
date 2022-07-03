package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.network.*;

public class EventSendPacket extends Event
{
    public /* synthetic */ Packet packet;
    
    public EventSendPacket(final Packet lllllllllllllIllIllIIIllllIIllII) {
        this.setPacket(lllllllllllllIllIllIIIllllIIllII);
    }
    
    public void setPacket(final Packet lllllllllllllIllIllIIIllllIIIIIl) {
        this.packet = lllllllllllllIllIllIIIllllIIIIIl;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
}
