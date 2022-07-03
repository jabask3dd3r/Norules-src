package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.*;
import java.util.*;

public class SequenceNode extends CollectionNode<Node>
{
    private final /* synthetic */ List<Node> value;
    
    public SequenceNode(final Tag lllllllllllllIllIlIllllIIllIlIlI, final boolean lllllllllllllIllIlIllllIIlllIIII, final List<Node> lllllllllllllIllIlIllllIIllIllll, final Mark lllllllllllllIllIlIllllIIllIlllI, final Mark lllllllllllllIllIlIllllIIllIllIl, final DumperOptions.FlowStyle lllllllllllllIllIlIllllIIllIIlIl) {
        super(lllllllllllllIllIlIllllIIllIlIlI, lllllllllllllIllIlIllllIIllIlllI, lllllllllllllIllIlIllllIIllIllIl, lllllllllllllIllIlIllllIIllIIlIl);
        if (lllllllllllllIllIlIllllIIllIllll == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = lllllllllllllIllIlIllllIIllIllll;
        this.resolved = lllllllllllllIllIlIllllIIlllIIII;
    }
    
    @Override
    public List<Node> getValue() {
        return this.value;
    }
    
    @Deprecated
    public SequenceNode(final Tag lllllllllllllIllIlIllllIIlIlIIll, final List<Node> lllllllllllllIllIlIllllIIlIlIIlI, final Boolean lllllllllllllIllIlIllllIIlIIllIl) {
        this(lllllllllllllIllIlIllllIIlIlIIll, lllllllllllllIllIlIllllIIlIlIIlI, DumperOptions.FlowStyle.fromBoolean(lllllllllllllIllIlIllllIIlIIllIl));
    }
    
    @Deprecated
    public SequenceNode(final Tag lllllllllllllIllIlIllllIIIllllIl, final boolean lllllllllllllIllIlIllllIIIllllII, final List<Node> lllllllllllllIllIlIllllIIlIIIIlI, final Mark lllllllllllllIllIlIllllIIIlllIlI, final Mark lllllllllllllIllIlIllllIIlIIIIII, final Boolean lllllllllllllIllIlIllllIIIlllIII) {
        this(lllllllllllllIllIlIllllIIIllllIl, lllllllllllllIllIlIllllIIIllllII, lllllllllllllIllIlIllllIIlIIIIlI, lllllllllllllIllIlIllllIIIlllIlI, lllllllllllllIllIlIllllIIlIIIIII, DumperOptions.FlowStyle.fromBoolean(lllllllllllllIllIlIllllIIIlllIII));
    }
    
    public void setListType(final Class<?> lllllllllllllIllIlIllllIIIlIlIlI) {
        for (final Node lllllllllllllIllIlIllllIIIlIllll : this.value) {
            lllllllllllllIllIlIllllIIIlIllll.setType(lllllllllllllIllIlIllllIIIlIlIlI);
        }
    }
    
    @Override
    public NodeId getNodeId() {
        return NodeId.sequence;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("<").append(this.getClass().getName()).append(" (tag=").append(this.getTag()).append(", value=").append(this.getValue()).append(")>"));
    }
    
    public SequenceNode(final Tag lllllllllllllIllIlIllllIIlIllIll, final List<Node> lllllllllllllIllIlIllllIIlIllIlI, final DumperOptions.FlowStyle lllllllllllllIllIlIllllIIlIllIIl) {
        this(lllllllllllllIllIlIllllIIlIllIll, true, lllllllllllllIllIlIllllIIlIllIlI, null, null, lllllllllllllIllIlIllllIIlIllIIl);
    }
}
