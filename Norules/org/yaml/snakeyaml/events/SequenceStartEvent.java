package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.*;

public final class SequenceStartEvent extends CollectionStartEvent
{
    @Deprecated
    public SequenceStartEvent(final String lIIIlIIIIllIIll, final String lIIIlIIIIlllIIl, final boolean lIIIlIIIIlllIII, final Mark lIIIlIIIIllIIII, final Mark lIIIlIIIIllIllI, final Boolean lIIIlIIIIlIlllI) {
        this(lIIIlIIIIllIIll, lIIIlIIIIlllIIl, lIIIlIIIIlllIII, lIIIlIIIIllIIII, lIIIlIIIIllIllI, DumperOptions.FlowStyle.fromBoolean(lIIIlIIIIlIlllI));
    }
    
    @Override
    public ID getEventId() {
        return ID.SequenceStart;
    }
    
    public SequenceStartEvent(final String lIIIlIIIlIIllll, final String lIIIlIIIlIIlllI, final boolean lIIIlIIIlIIIllI, final Mark lIIIlIIIlIIIlIl, final Mark lIIIlIIIlIIIlII, final DumperOptions.FlowStyle lIIIlIIIlIIIIll) {
        super(lIIIlIIIlIIllll, lIIIlIIIlIIlllI, lIIIlIIIlIIIllI, lIIIlIIIlIIIlIl, lIIIlIIIlIIIlII, lIIIlIIIlIIIIll);
    }
}
