package org.yaml.snakeyaml.nodes;

import java.util.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;

public class MappingNode extends CollectionNode<NodeTuple>
{
    private /* synthetic */ List<NodeTuple> value;
    private /* synthetic */ boolean merged;
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllIlllllIIIllIIIlIIIIl = new StringBuilder();
        for (final NodeTuple llllllllllllIlllllIIIllIIIlIIlIl : this.getValue()) {
            llllllllllllIlllllIIIllIIIlIIIIl.append("{ key=");
            llllllllllllIlllllIIIllIIIlIIIIl.append(llllllllllllIlllllIIIllIIIlIIlIl.getKeyNode());
            llllllllllllIlllllIIIllIIIlIIIIl.append("; value=");
            if (llllllllllllIlllllIIIllIIIlIIlIl.getValueNode() instanceof CollectionNode) {
                llllllllllllIlllllIIIllIIIlIIIIl.append(System.identityHashCode(llllllllllllIlllllIIIllIIIlIIlIl.getValueNode()));
            }
            else {
                llllllllllllIlllllIIIllIIIlIIIIl.append(llllllllllllIlllllIIIllIIIlIIlIl.toString());
            }
            llllllllllllIlllllIIIllIIIlIIIIl.append(" }");
        }
        final String llllllllllllIlllllIIIllIIIlIIIlI = String.valueOf(llllllllllllIlllllIIIllIIIlIIIIl);
        return String.valueOf(new StringBuilder().append("<").append(this.getClass().getName()).append(" (tag=").append(this.getTag()).append(", values=").append(llllllllllllIlllllIIIllIIIlIIIlI).append(")>"));
    }
    
    public void setMerged(final boolean llllllllllllIlllllIIIllIIIIlIllI) {
        this.merged = llllllllllllIlllllIIIllIIIIlIllI;
    }
    
    public MappingNode(final Tag llllllllllllIlllllIIIllIIlllIlll, final List<NodeTuple> llllllllllllIlllllIIIllIIlllIIlI, final DumperOptions.FlowStyle llllllllllllIlllllIIIllIIlllIIIl) {
        this(llllllllllllIlllllIIIllIIlllIlll, true, llllllllllllIlllllIIIllIIlllIIlI, null, null, llllllllllllIlllllIIIllIIlllIIIl);
    }
    
    public void setOnlyKeyType(final Class<?> llllllllllllIlllllIIIllIIIllllII) {
        for (final NodeTuple llllllllllllIlllllIIIllIIlIIIIIl : this.value) {
            llllllllllllIlllllIIIllIIlIIIIIl.getKeyNode().setType(llllllllllllIlllllIIIllIIIllllII);
        }
    }
    
    public void setTypes(final Class<?> llllllllllllIlllllIIIllIIIllIIIl, final Class<?> llllllllllllIlllllIIIllIIIllIIII) {
        for (final NodeTuple llllllllllllIlllllIIIllIIIllIlII : this.value) {
            llllllllllllIlllllIIIllIIIllIlII.getValueNode().setType(llllllllllllIlllllIIIllIIIllIIII);
            llllllllllllIlllllIIIllIIIllIlII.getKeyNode().setType(llllllllllllIlllllIIIllIIIllIIIl);
        }
    }
    
    @Deprecated
    public MappingNode(final Tag llllllllllllIlllllIIIllIIlIlIllI, final List<NodeTuple> llllllllllllIlllllIIIllIIlIlIIIl, final Boolean llllllllllllIlllllIIIllIIlIlIlII) {
        this(llllllllllllIlllllIIIllIIlIlIllI, llllllllllllIlllllIIIllIIlIlIIIl, DumperOptions.FlowStyle.fromBoolean(llllllllllllIlllllIIIllIIlIlIlII));
    }
    
    @Deprecated
    public MappingNode(final Tag llllllllllllIlllllIIIllIIllIlIII, final boolean llllllllllllIlllllIIIllIIllIIlll, final List<NodeTuple> llllllllllllIlllllIIIllIIlIlllll, final Mark llllllllllllIlllllIIIllIIllIIlIl, final Mark llllllllllllIlllllIIIllIIlIlllIl, final Boolean llllllllllllIlllllIIIllIIlIlllII) {
        this(llllllllllllIlllllIIIllIIllIlIII, llllllllllllIlllllIIIllIIllIIlll, llllllllllllIlllllIIIllIIlIlllll, llllllllllllIlllllIIIllIIllIIlIl, llllllllllllIlllllIIIllIIlIlllIl, DumperOptions.FlowStyle.fromBoolean(llllllllllllIlllllIIIllIIlIlllII));
    }
    
    @Override
    public List<NodeTuple> getValue() {
        return this.value;
    }
    
    public void setValue(final List<NodeTuple> llllllllllllIlllllIIIllIIlIIlIII) {
        this.value = llllllllllllIlllllIIIllIIlIIlIII;
    }
    
    public MappingNode(final Tag llllllllllllIlllllIIIllIlIIIIIlI, final boolean llllllllllllIlllllIIIllIlIIIIIIl, final List<NodeTuple> llllllllllllIlllllIIIllIlIIIIlll, final Mark llllllllllllIlllllIIIllIIlllllll, final Mark llllllllllllIlllllIIIllIlIIIIlIl, final DumperOptions.FlowStyle llllllllllllIlllllIIIllIIlllllIl) {
        super(llllllllllllIlllllIIIllIlIIIIIlI, llllllllllllIlllllIIIllIIlllllll, llllllllllllIlllllIIIllIlIIIIlIl, llllllllllllIlllllIIIllIIlllllIl);
        this.merged = false;
        if (llllllllllllIlllllIIIllIlIIIIlll == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = llllllllllllIlllllIIIllIlIIIIlll;
        this.resolved = llllllllllllIlllllIIIllIlIIIIIIl;
    }
    
    @Override
    public NodeId getNodeId() {
        return NodeId.mapping;
    }
    
    public boolean isMerged() {
        return this.merged;
    }
}
