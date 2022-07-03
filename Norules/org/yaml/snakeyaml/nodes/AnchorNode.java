package org.yaml.snakeyaml.nodes;

public class AnchorNode extends Node
{
    private /* synthetic */ Node realNode;
    
    public Node getRealNode() {
        return this.realNode;
    }
    
    @Override
    public NodeId getNodeId() {
        return NodeId.anchor;
    }
    
    public AnchorNode(final Node lllllllllllllllIIIlllIIlIlIllIll) {
        super(lllllllllllllllIIIlllIIlIlIllIll.getTag(), lllllllllllllllIIIlllIIlIlIllIll.getStartMark(), lllllllllllllllIIIlllIIlIlIllIll.getEndMark());
        this.realNode = lllllllllllllllIIIlllIIlIlIllIll;
    }
}
