package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public final class StreamEndEvent extends Event
{
    public StreamEndEvent(final Mark llllllllllllllIlIIIIIIIIlIllIlII, final Mark llllllllllllllIlIIIIIIIIlIllIIII) {
        super(llllllllllllllIlIIIIIIIIlIllIlII, llllllllllllllIlIIIIIIIIlIllIIII);
    }
    
    @Override
    public ID getEventId() {
        return ID.StreamEnd;
    }
}
