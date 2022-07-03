package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.*;

public abstract class NodeEvent extends Event
{
    private final /* synthetic */ String anchor;
    
    public NodeEvent(final String llllllllllllllIIlIlllIIIIllIllIl, final Mark llllllllllllllIIlIlllIIIIllIlIII, final Mark llllllllllllllIIlIlllIIIIllIIlll) {
        super(llllllllllllllIIlIlllIIIIllIlIII, llllllllllllllIIlIlllIIIIllIIlll);
        this.anchor = llllllllllllllIIlIlllIIIIllIllIl;
    }
    
    @Override
    protected String getArguments() {
        return String.valueOf(new StringBuilder().append("anchor=").append(this.anchor));
    }
    
    public String getAnchor() {
        return this.anchor;
    }
}
