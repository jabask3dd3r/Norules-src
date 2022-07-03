package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public final class SequenceEndEvent extends CollectionEndEvent
{
    public SequenceEndEvent(final Mark lllllllllllllIllIIllIlIIIlIIIIll, final Mark lllllllllllllIllIIllIlIIIlIIIIlI) {
        super(lllllllllllllIllIIllIlIIIlIIIIll, lllllllllllllIllIIllIlIIIlIIIIlI);
    }
    
    @Override
    public ID getEventId() {
        return ID.SequenceEnd;
    }
}
