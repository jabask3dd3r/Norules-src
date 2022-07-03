package me.nrules.event.events;

import me.nrules.event.*;
import net.minecraft.network.*;

public class EventReceivePacket extends Event
{
    private /* synthetic */ Packet packet;
    
    public void setPacket(final Packet lllllllllllllllIllIIlIlIIlIIIllI) {
        this.packet = lllllllllllllllIllIIlIlIIlIIIllI;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
    
    public EventReceivePacket(final Packet lllllllllllllllIllIIlIlIIlIIllIl) {
        this.packet = lllllllllllllllIllIIlIlIIlIIllIl;
    }
}
