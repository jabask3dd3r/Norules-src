package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.*;

public final class MappingStartEvent extends CollectionStartEvent
{
    @Deprecated
    public MappingStartEvent(final String llllllllllllllIIllllIlllIllIllIl, final String llllllllllllllIIllllIlllIllIIlIl, final boolean llllllllllllllIIllllIlllIllIlIll, final Mark llllllllllllllIIllllIlllIllIlIlI, final Mark llllllllllllllIIllllIlllIllIIIlI, final Boolean llllllllllllllIIllllIlllIllIIIIl) {
        this(llllllllllllllIIllllIlllIllIllIl, llllllllllllllIIllllIlllIllIIlIl, llllllllllllllIIllllIlllIllIlIll, llllllllllllllIIllllIlllIllIlIlI, llllllllllllllIIllllIlllIllIIIlI, DumperOptions.FlowStyle.fromBoolean(llllllllllllllIIllllIlllIllIIIIl));
    }
    
    public MappingStartEvent(final String llllllllllllllIIllllIllllIIIIIlI, final String llllllllllllllIIllllIlllIllllIlI, final boolean llllllllllllllIIllllIlllIllllIIl, final Mark llllllllllllllIIllllIlllIllllIII, final Mark llllllllllllllIIllllIlllIlllIlll, final DumperOptions.FlowStyle llllllllllllllIIllllIlllIlllIllI) {
        super(llllllllllllllIIllllIllllIIIIIlI, llllllllllllllIIllllIlllIllllIlI, llllllllllllllIIllllIlllIllllIIl, llllllllllllllIIllllIlllIllllIII, llllllllllllllIIllllIlllIlllIlll, llllllllllllllIIllllIlllIlllIllI);
    }
    
    @Override
    public ID getEventId() {
        return ID.MappingStart;
    }
}
