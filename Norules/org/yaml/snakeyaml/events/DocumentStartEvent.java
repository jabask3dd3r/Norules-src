package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.*;
import java.util.*;
import org.yaml.snakeyaml.error.*;

public final class DocumentStartEvent extends Event
{
    private final /* synthetic */ DumperOptions.Version version;
    private final /* synthetic */ boolean explicit;
    private final /* synthetic */ Map<String, String> tags;
    
    @Override
    public ID getEventId() {
        return ID.DocumentStart;
    }
    
    public Map<String, String> getTags() {
        return this.tags;
    }
    
    public DumperOptions.Version getVersion() {
        return this.version;
    }
    
    public DocumentStartEvent(final Mark llllllllllllllIllIIIlllllIlllIll, final Mark llllllllllllllIllIIIlllllIllIlII, final boolean llllllllllllllIllIIIlllllIllIIll, final DumperOptions.Version llllllllllllllIllIIIlllllIllIIlI, final Map<String, String> llllllllllllllIllIIIlllllIllIlll) {
        super(llllllllllllllIllIIIlllllIlllIll, llllllllllllllIllIIIlllllIllIlII);
        this.explicit = llllllllllllllIllIIIlllllIllIIll;
        this.version = llllllllllllllIllIIIlllllIllIIlI;
        this.tags = llllllllllllllIllIIIlllllIllIlll;
    }
    
    public boolean getExplicit() {
        return this.explicit;
    }
}
