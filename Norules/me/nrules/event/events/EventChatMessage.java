package me.nrules.event.events;

import me.nrules.event.*;

public class EventChatMessage extends Event
{
    public /* synthetic */ boolean cancelled;
    public /* synthetic */ String message;
    
    @Override
    public void setCancelled(final boolean llllllllllllllIIIIlIIllIIlIIIlII) {
        this.cancelled = llllllllllllllIIIIlIIllIIlIIIlII;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public EventChatMessage(final String llllllllllllllIIIIlIIllIIlIIlIll) {
        this.message = llllllllllllllIIIIlIIllIIlIIlIll;
    }
}
