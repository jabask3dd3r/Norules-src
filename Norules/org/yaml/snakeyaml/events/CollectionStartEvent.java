package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;

public abstract class CollectionStartEvent extends NodeEvent
{
    private final /* synthetic */ String tag;
    private final /* synthetic */ DumperOptions.FlowStyle flowStyle;
    private final /* synthetic */ boolean implicit;
    
    public String getTag() {
        return this.tag;
    }
    
    public DumperOptions.FlowStyle getFlowStyle() {
        return this.flowStyle;
    }
    
    @Deprecated
    public CollectionStartEvent(final String llllllllllllllllIlIIIIIIIllIIlll, final String llllllllllllllllIlIIIIIIIllIIllI, final boolean llllllllllllllllIlIIIIIIIllIIlIl, final Mark llllllllllllllllIlIIIIIIIllIlIll, final Mark llllllllllllllllIlIIIIIIIllIIIll, final Boolean llllllllllllllllIlIIIIIIIllIIIlI) {
        this(llllllllllllllllIlIIIIIIIllIIlll, llllllllllllllllIlIIIIIIIllIIllI, llllllllllllllllIlIIIIIIIllIIlIl, llllllllllllllllIlIIIIIIIllIlIll, llllllllllllllllIlIIIIIIIllIIIll, DumperOptions.FlowStyle.fromBoolean(llllllllllllllllIlIIIIIIIllIIIlI));
    }
    
    @Override
    protected String getArguments() {
        return String.valueOf(new StringBuilder().append(super.getArguments()).append(", tag=").append(this.tag).append(", implicit=").append(this.implicit));
    }
    
    public boolean isFlow() {
        return DumperOptions.FlowStyle.FLOW == this.flowStyle;
    }
    
    public boolean getImplicit() {
        return this.implicit;
    }
    
    public CollectionStartEvent(final String llllllllllllllllIlIIIIIIlIIIIIll, final String llllllllllllllllIlIIIIIIlIIIIIlI, final boolean llllllllllllllllIlIIIIIIIllllIlI, final Mark llllllllllllllllIlIIIIIIIllllIIl, final Mark llllllllllllllllIlIIIIIIIllllIII, final DumperOptions.FlowStyle llllllllllllllllIlIIIIIIIllllllI) {
        super(llllllllllllllllIlIIIIIIlIIIIIll, llllllllllllllllIlIIIIIIIllllIIl, llllllllllllllllIlIIIIIIIllllIII);
        this.tag = llllllllllllllllIlIIIIIIlIIIIIlI;
        this.implicit = llllllllllllllllIlIIIIIIIllllIlI;
        if (llllllllllllllllIlIIIIIIIllllllI == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.flowStyle = llllllllllllllllIlIIIIIIIllllllI;
    }
}
