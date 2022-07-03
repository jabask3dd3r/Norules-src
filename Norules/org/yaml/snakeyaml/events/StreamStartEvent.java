package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public final class StreamStartEvent extends Event
{
    public StreamStartEvent(final Mark llllllllllllllllIIIlIllIIIIIlIll, final Mark llllllllllllllllIIIlIllIIIIIllIl) {
        super(llllllllllllllllIIIlIllIIIIIlIll, llllllllllllllllIIIlIllIIIIIllIl);
    }
    
    @Override
    public ID getEventId() {
        return ID.StreamStart;
    }
}
