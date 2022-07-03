package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public final class MappingEndEvent extends CollectionEndEvent
{
    public MappingEndEvent(final Mark lllllllllllllIIIIllIIIllIlIIlIlI, final Mark lllllllllllllIIIIllIIIllIlIIlIIl) {
        super(lllllllllllllIIIIllIIIllIlIIlIlI, lllllllllllllIIIIllIIIllIlIIlIIl);
    }
    
    @Override
    public ID getEventId() {
        return ID.MappingEnd;
    }
}
