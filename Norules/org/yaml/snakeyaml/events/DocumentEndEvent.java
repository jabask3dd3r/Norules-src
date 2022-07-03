package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public final class DocumentEndEvent extends Event
{
    private final /* synthetic */ boolean explicit;
    
    @Override
    public ID getEventId() {
        return ID.DocumentEnd;
    }
    
    public boolean getExplicit() {
        return this.explicit;
    }
    
    public DocumentEndEvent(final Mark lllllllllllllIlllIIllIllllIIIlll, final Mark lllllllllllllIlllIIllIllllIIIllI, final boolean lllllllllllllIlllIIllIllllIIIIIl) {
        super(lllllllllllllIlllIIllIllllIIIlll, lllllllllllllIlllIIllIllllIIIllI);
        this.explicit = lllllllllllllIlllIIllIllllIIIIIl;
    }
}
