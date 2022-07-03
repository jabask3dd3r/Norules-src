package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.*;
import java.util.*;
import org.yaml.snakeyaml.error.*;

public abstract class CollectionNode<T> extends Node
{
    private /* synthetic */ DumperOptions.FlowStyle flowStyle;
    
    public abstract List<T> getValue();
    
    public CollectionNode(final Tag llllllllllllllIllIIIlllIllIlIIll, final Mark llllllllllllllIllIIIlllIllIlIIlI, final Mark llllllllllllllIllIIIlllIllIlIIIl, final DumperOptions.FlowStyle llllllllllllllIllIIIlllIllIlIIII) {
        super(llllllllllllllIllIIIlllIllIlIIll, llllllllllllllIllIIIlllIllIlIIlI, llllllllllllllIllIIIlllIllIlIIIl);
        this.setFlowStyle(llllllllllllllIllIIIlllIllIlIIII);
    }
    
    public void setEndMark(final Mark llllllllllllllIllIIIlllIlIlIlllI) {
        this.endMark = llllllllllllllIllIIIlllIlIlIlllI;
    }
    
    public DumperOptions.FlowStyle getFlowStyle() {
        return this.flowStyle;
    }
    
    @Deprecated
    public CollectionNode(final Tag llllllllllllllIllIIIlllIllIIIlII, final Mark llllllllllllllIllIIIlllIllIIlIII, final Mark llllllllllllllIllIIIlllIllIIIIlI, final Boolean llllllllllllllIllIIIlllIllIIIllI) {
        this(llllllllllllllIllIIIlllIllIIIlII, llllllllllllllIllIIIlllIllIIlIII, llllllllllllllIllIIIlllIllIIIIlI, DumperOptions.FlowStyle.fromBoolean(llllllllllllllIllIIIlllIllIIIllI));
    }
    
    @Deprecated
    public void setFlowStyle(final Boolean llllllllllllllIllIIIlllIlIllIlII) {
        this.setFlowStyle(DumperOptions.FlowStyle.fromBoolean(llllllllllllllIllIIIlllIlIllIlII));
    }
    
    public void setFlowStyle(final DumperOptions.FlowStyle llllllllllllllIllIIIlllIlIlllIII) {
        if (llllllllllllllIllIIIlllIlIlllIII == null) {
            throw new NullPointerException("Flow style must be provided.");
        }
        this.flowStyle = llllllllllllllIllIIIlllIlIlllIII;
    }
}
