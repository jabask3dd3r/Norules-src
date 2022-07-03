package org.yaml.snakeyaml.composer;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.parser.*;
import org.yaml.snakeyaml.resolver.*;
import org.yaml.snakeyaml.error.*;
import java.util.*;
import org.yaml.snakeyaml.events.*;
import org.yaml.snakeyaml.nodes.*;

public class Composer
{
    private final /* synthetic */ Set<Node> recursiveNodes;
    private final /* synthetic */ Map<String, Node> anchors;
    private final /* synthetic */ LoaderOptions loadingConfig;
    protected final /* synthetic */ Parser parser;
    private /* synthetic */ int nonScalarAliasesCount;
    private final /* synthetic */ Resolver resolver;
    
    protected void composeMappingChildren(final List<NodeTuple> llIIIllIlllI, final MappingNode llIIIlllIIlI) {
        final Node llIIIlllIIIl = this.composeKeyNode(llIIIlllIIlI);
        if (llIIIlllIIIl.getTag().equals(Tag.MERGE)) {
            llIIIlllIIlI.setMerged(true);
        }
        final Node llIIIlllIIII = this.composeValueNode(llIIIlllIIlI);
        llIIIllIlllI.add(new NodeTuple(llIIIlllIIIl, llIIIlllIIII));
    }
    
    protected Node composeKeyNode(final MappingNode llIIIllIIlIl) {
        return this.composeNode(llIIIllIIlIl);
    }
    
    protected Node composeScalarNode(final String llIIlIllIlll) {
        final ScalarEvent llIIlIllllIl = (ScalarEvent)this.parser.getEvent();
        final String llIIlIllllII = llIIlIllllIl.getTag();
        boolean llIIlIlllIll = false;
        Tag llIIlIlllIlI = null;
        if (llIIlIllllII == null || llIIlIllllII.equals("!")) {
            final Tag llIIllIIIIII = this.resolver.resolve(NodeId.scalar, llIIlIllllIl.getValue(), llIIlIllllIl.getImplicit().canOmitTagInPlainScalar());
            llIIlIlllIll = true;
        }
        else {
            llIIlIlllIlI = new Tag(llIIlIllllII);
        }
        final Node llIIlIlllIIl = new ScalarNode(llIIlIlllIlI, llIIlIlllIll, llIIlIllllIl.getValue(), llIIlIllllIl.getStartMark(), llIIlIllllIl.getEndMark(), llIIlIllllIl.getScalarStyle());
        if (llIIlIllIlll != null) {
            llIIlIlllIIl.setAnchor(llIIlIllIlll);
            this.anchors.put(llIIlIllIlll, llIIlIlllIIl);
        }
        return llIIlIlllIIl;
    }
    
    public Composer(final Parser llIIlllllllI, final Resolver llIlIIIIIIII) {
        this(llIIlllllllI, llIlIIIIIIII, new LoaderOptions());
    }
    
    protected Node composeValueNode(final MappingNode llIIIllIIIIl) {
        return this.composeNode(llIIIllIIIIl);
    }
    
    private Node composeNode(final Node llIIllIIlIll) {
        if (llIIllIIlIll != null) {
            this.recursiveNodes.add(llIIllIIlIll);
        }
        Node llIIllIIllIl = null;
        if (this.parser.checkEvent(Event.ID.Alias)) {
            final AliasEvent llIIllIlIllI = (AliasEvent)this.parser.getEvent();
            final String llIIllIlIlIl = llIIllIlIllI.getAnchor();
            if (!this.anchors.containsKey(llIIllIlIlIl)) {
                throw new ComposerException(null, null, String.valueOf(new StringBuilder().append("found undefined alias ").append(llIIllIlIlIl)), llIIllIlIllI.getStartMark());
            }
            final Node llIIllIlIlII = this.anchors.get(llIIllIlIlIl);
            if (!(llIIllIlIlII instanceof ScalarNode)) {
                ++this.nonScalarAliasesCount;
                if (this.nonScalarAliasesCount > this.loadingConfig.getMaxAliasesForCollections()) {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Number of aliases for non-scalar nodes exceeds the specified max=").append(this.loadingConfig.getMaxAliasesForCollections())));
                }
            }
            if (this.recursiveNodes.remove(llIIllIlIlII)) {
                llIIllIlIlII.setTwoStepsConstruction(true);
            }
        }
        else {
            final NodeEvent llIIllIlIIIl = (NodeEvent)this.parser.peekEvent();
            final String llIIllIlIIII = llIIllIlIIIl.getAnchor();
            if (this.parser.checkEvent(Event.ID.Scalar)) {
                final Node llIIllIlIIll = this.composeScalarNode(llIIllIlIIII);
            }
            else if (this.parser.checkEvent(Event.ID.SequenceStart)) {
                final Node llIIllIlIIlI = this.composeSequenceNode(llIIllIlIIII);
            }
            else {
                llIIllIIllIl = this.composeMappingNode(llIIllIlIIII);
            }
        }
        this.recursiveNodes.remove(llIIllIIlIll);
        return llIIllIIllIl;
    }
    
    protected Node composeMappingNode(final String llIIlIIIIIIl) {
        final MappingStartEvent llIIlIIIlIIl = (MappingStartEvent)this.parser.getEvent();
        final String llIIlIIIlIII = llIIlIIIlIIl.getTag();
        boolean llIIlIIIIllI = false;
        Tag llIIlIIIIlll = null;
        if (llIIlIIIlIII == null || llIIlIIIlIII.equals("!")) {
            final Tag llIIlIIIllII = this.resolver.resolve(NodeId.mapping, null, llIIlIIIlIIl.getImplicit());
            llIIlIIIIllI = true;
        }
        else {
            llIIlIIIIlll = new Tag(llIIlIIIlIII);
        }
        final List<NodeTuple> llIIlIIIIlIl = new ArrayList<NodeTuple>();
        final MappingNode llIIlIIIIlII = new MappingNode(llIIlIIIIlll, llIIlIIIIllI, llIIlIIIIlIl, llIIlIIIlIIl.getStartMark(), null, llIIlIIIlIIl.getFlowStyle());
        if (llIIlIIIIIIl != null) {
            llIIlIIIIlII.setAnchor(llIIlIIIIIIl);
            this.anchors.put(llIIlIIIIIIl, llIIlIIIIlII);
        }
        while (!this.parser.checkEvent(Event.ID.MappingEnd)) {
            this.composeMappingChildren(llIIlIIIIlIl, llIIlIIIIlII);
        }
        final Event llIIlIIIIIll = this.parser.getEvent();
        llIIlIIIIlII.setEndMark(llIIlIIIIIll.getEndMark());
        return llIIlIIIIlII;
    }
    
    public Composer(final Parser llIIllllIIll, final Resolver llIIllllIIlI, final LoaderOptions llIIllllIlIl) {
        this.nonScalarAliasesCount = 0;
        this.parser = llIIllllIIll;
        this.resolver = llIIllllIIlI;
        this.anchors = new HashMap<String, Node>();
        this.recursiveNodes = new HashSet<Node>();
        this.loadingConfig = llIIllllIlIl;
    }
    
    public boolean checkNode() {
        if (this.parser.checkEvent(Event.ID.StreamStart)) {
            this.parser.getEvent();
        }
        return !this.parser.checkEvent(Event.ID.StreamEnd);
    }
    
    protected Node composeSequenceNode(final String llIIlIlIIllI) {
        final SequenceStartEvent llIIlIlIIlIl = (SequenceStartEvent)this.parser.getEvent();
        final String llIIlIlIIlII = llIIlIlIIlIl.getTag();
        boolean llIIlIlIIIlI = false;
        Tag llIIlIlIIIll = null;
        if (llIIlIlIIlII == null || llIIlIlIIlII.equals("!")) {
            final Tag llIIlIlIlIII = this.resolver.resolve(NodeId.sequence, null, llIIlIlIIlIl.getImplicit());
            llIIlIlIIIlI = true;
        }
        else {
            llIIlIlIIIll = new Tag(llIIlIlIIlII);
        }
        final ArrayList<Node> llIIlIlIIIIl = new ArrayList<Node>();
        final SequenceNode llIIlIlIIIII = new SequenceNode(llIIlIlIIIll, llIIlIlIIIlI, llIIlIlIIIIl, llIIlIlIIlIl.getStartMark(), null, llIIlIlIIlIl.getFlowStyle());
        if (llIIlIlIIllI != null) {
            llIIlIlIIIII.setAnchor(llIIlIlIIllI);
            this.anchors.put(llIIlIlIIllI, llIIlIlIIIII);
        }
        while (!this.parser.checkEvent(Event.ID.SequenceEnd)) {
            llIIlIlIIIIl.add(this.composeNode(llIIlIlIIIII));
        }
        final Event llIIlIIlllll = this.parser.getEvent();
        llIIlIlIIIII.setEndMark(llIIlIIlllll.getEndMark());
        return llIIlIlIIIII;
    }
    
    public Node getNode() {
        this.parser.getEvent();
        final Node llIIlllIlIlI = this.composeNode(null);
        this.parser.getEvent();
        this.anchors.clear();
        this.recursiveNodes.clear();
        return llIIlllIlIlI;
    }
    
    public Node getSingleNode() {
        this.parser.getEvent();
        Node llIIlllIIIII = null;
        if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
            llIIlllIIIII = this.getNode();
        }
        if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
            final Event llIIlllIIIll = this.parser.getEvent();
            final Mark llIIlllIIIlI = (llIIlllIIIII != null) ? llIIlllIIIII.getStartMark() : null;
            throw new ComposerException("expected a single document in the stream", llIIlllIIIlI, "but found another document", llIIlllIIIll.getStartMark());
        }
        this.parser.getEvent();
        return llIIlllIIIII;
    }
}
