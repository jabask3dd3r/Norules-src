package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public final class AliasEvent extends NodeEvent
{
    @Override
    public ID getEventId() {
        return ID.Alias;
    }
    
    public AliasEvent(final String llllllllllllllIlIIIllllIllllIIIl, final Mark llllllllllllllIlIIIllllIllllIIII, final Mark llllllllllllllIlIIIllllIllllIIll) {
        super(llllllllllllllIlIIIllllIllllIIIl, llllllllllllllIlIIIllllIllllIIII, llllllllllllllIlIIIllllIllllIIll);
        if (llllllllllllllIlIIIllllIllllIIIl == null) {
            throw new NullPointerException("anchor is not specified for alias");
        }
    }
}
