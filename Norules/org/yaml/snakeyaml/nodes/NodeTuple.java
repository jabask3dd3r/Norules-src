package org.yaml.snakeyaml.nodes;

public final class NodeTuple
{
    private /* synthetic */ Node keyNode;
    private /* synthetic */ Node valueNode;
    
    public Node getValueNode() {
        return this.valueNode;
    }
    
    public NodeTuple(final Node lllllllllllllIlllIllllIIllllIlll, final Node lllllllllllllIlllIllllIIlllllIIl) {
        if (lllllllllllllIlllIllllIIllllIlll == null || lllllllllllllIlllIllllIIlllllIIl == null) {
            throw new NullPointerException("Nodes must be provided.");
        }
        this.keyNode = lllllllllllllIlllIllllIIllllIlll;
        this.valueNode = lllllllllllllIlllIllllIIlllllIIl;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("<NodeTuple keyNode=").append(this.keyNode.toString()).append("; valueNode=").append(this.valueNode.toString()).append(">"));
    }
    
    public Node getKeyNode() {
        return this.keyNode;
    }
}
