package org.yaml.snakeyaml.serializer;

import org.yaml.snakeyaml.emitter.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.resolver.*;
import org.yaml.snakeyaml.error.*;
import java.io.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.*;
import org.yaml.snakeyaml.events.*;

public final class Serializer
{
    private /* synthetic */ AnchorGenerator anchorGenerator;
    private /* synthetic */ Map<String, String> useTags;
    private /* synthetic */ boolean explicitEnd;
    private /* synthetic */ Map<Node, String> anchors;
    private /* synthetic */ Set<Node> serializedNodes;
    private final /* synthetic */ Emitable emitter;
    private /* synthetic */ Tag explicitRoot;
    private /* synthetic */ DumperOptions.Version useVersion;
    private final /* synthetic */ Resolver resolver;
    private /* synthetic */ boolean explicitStart;
    private /* synthetic */ Boolean closed;
    
    public void close() throws IOException {
        if (this.closed == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (!Boolean.TRUE.equals(this.closed)) {
            this.emitter.emit(new StreamEndEvent(null, null));
            this.closed = Boolean.TRUE;
            this.serializedNodes.clear();
            this.anchors.clear();
        }
    }
    
    public Serializer(final Emitable lllllllllllllIIIIIllIlIIllIllIII, final Resolver lllllllllllllIIIIIllIlIIllIlIlll, final DumperOptions lllllllllllllIIIIIllIlIIllIlIIIl, final Tag lllllllllllllIIIIIllIlIIllIlIlIl) {
        this.emitter = lllllllllllllIIIIIllIlIIllIllIII;
        this.resolver = lllllllllllllIIIIIllIlIIllIlIlll;
        this.explicitStart = lllllllllllllIIIIIllIlIIllIlIIIl.isExplicitStart();
        this.explicitEnd = lllllllllllllIIIIIllIlIIllIlIIIl.isExplicitEnd();
        if (lllllllllllllIIIIIllIlIIllIlIIIl.getVersion() != null) {
            this.useVersion = lllllllllllllIIIIIllIlIIllIlIIIl.getVersion();
        }
        this.useTags = lllllllllllllIIIIIllIlIIllIlIIIl.getTags();
        this.serializedNodes = new HashSet<Node>();
        this.anchors = new HashMap<Node, String>();
        this.anchorGenerator = lllllllllllllIIIIIllIlIIllIlIIIl.getAnchorGenerator();
        this.closed = null;
        this.explicitRoot = lllllllllllllIIIIIllIlIIllIlIlIl;
    }
    
    public void serialize(final Node lllllllllllllIIIIIllIlIIllIIIllI) throws IOException {
        if (this.closed == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (this.closed) {
            throw new SerializerException("serializer is closed");
        }
        this.emitter.emit(new DocumentStartEvent(null, null, this.explicitStart, this.useVersion, this.useTags));
        this.anchorNode(lllllllllllllIIIIIllIlIIllIIIllI);
        if (this.explicitRoot != null) {
            lllllllllllllIIIIIllIlIIllIIIllI.setTag(this.explicitRoot);
        }
        this.serializeNode(lllllllllllllIIIIIllIlIIllIIIllI, null);
        this.emitter.emit(new DocumentEndEvent(null, null, this.explicitEnd));
        this.serializedNodes.clear();
        this.anchors.clear();
    }
    
    private void serializeNode(Node lllllllllllllIIIIIllIlIIIllllIII, final Node lllllllllllllIIIIIllIlIIIllllIll) throws IOException {
        if (lllllllllllllIIIIIllIlIIIllllIII.getNodeId() == NodeId.anchor) {
            lllllllllllllIIIIIllIlIIIllllIII = ((AnchorNode)lllllllllllllIIIIIllIlIIIllllIII).getRealNode();
        }
        final String lllllllllllllIIIIIllIlIIIllllIlI = this.anchors.get(lllllllllllllIIIIIllIlIIIllllIII);
        if (this.serializedNodes.contains(lllllllllllllIIIIIllIlIIIllllIII)) {
            this.emitter.emit(new AliasEvent(lllllllllllllIIIIIllIlIIIllllIlI, null, null));
        }
        else {
            this.serializedNodes.add(lllllllllllllIIIIIllIlIIIllllIII);
            switch (lllllllllllllIIIIIllIlIIIllllIII.getNodeId()) {
                case scalar: {
                    final ScalarNode lllllllllllllIIIIIllIlIIlIIIlIIl = (ScalarNode)lllllllllllllIIIIIllIlIIIllllIII;
                    final Tag lllllllllllllIIIIIllIlIIlIIIlIII = this.resolver.resolve(NodeId.scalar, lllllllllllllIIIIIllIlIIlIIIlIIl.getValue(), true);
                    final Tag lllllllllllllIIIIIllIlIIlIIIIlll = this.resolver.resolve(NodeId.scalar, lllllllllllllIIIIIllIlIIlIIIlIIl.getValue(), false);
                    final ImplicitTuple lllllllllllllIIIIIllIlIIlIIIIllI = new ImplicitTuple(lllllllllllllIIIIIllIlIIIllllIII.getTag().equals(lllllllllllllIIIIIllIlIIlIIIlIII), lllllllllllllIIIIIllIlIIIllllIII.getTag().equals(lllllllllllllIIIIIllIlIIlIIIIlll));
                    final ScalarEvent lllllllllllllIIIIIllIlIIlIIIIlIl = new ScalarEvent(lllllllllllllIIIIIllIlIIIllllIlI, lllllllllllllIIIIIllIlIIIllllIII.getTag().getValue(), lllllllllllllIIIIIllIlIIlIIIIllI, lllllllllllllIIIIIllIlIIlIIIlIIl.getValue(), null, null, lllllllllllllIIIIIllIlIIlIIIlIIl.getScalarStyle());
                    this.emitter.emit(lllllllllllllIIIIIllIlIIlIIIIlIl);
                    break;
                }
                case sequence: {
                    final SequenceNode lllllllllllllIIIIIllIlIIlIIIIlII = (SequenceNode)lllllllllllllIIIIIllIlIIIllllIII;
                    final boolean lllllllllllllIIIIIllIlIIlIIIIIll = lllllllllllllIIIIIllIlIIIllllIII.getTag().equals(this.resolver.resolve(NodeId.sequence, null, true));
                    this.emitter.emit(new SequenceStartEvent(lllllllllllllIIIIIllIlIIIllllIlI, lllllllllllllIIIIIllIlIIIllllIII.getTag().getValue(), lllllllllllllIIIIIllIlIIlIIIIIll, null, null, lllllllllllllIIIIIllIlIIlIIIIlII.getFlowStyle()));
                    final List<Node> lllllllllllllIIIIIllIlIIlIIIIIlI = lllllllllllllIIIIIllIlIIlIIIIlII.getValue();
                    for (final Node lllllllllllllIIIIIllIlIIlIIIllll : lllllllllllllIIIIIllIlIIlIIIIIlI) {
                        this.serializeNode(lllllllllllllIIIIIllIlIIlIIIllll, lllllllllllllIIIIIllIlIIIllllIII);
                    }
                    this.emitter.emit(new SequenceEndEvent(null, null));
                    break;
                }
                default: {
                    final Tag lllllllllllllIIIIIllIlIIlIIIIIIl = this.resolver.resolve(NodeId.mapping, null, true);
                    final boolean lllllllllllllIIIIIllIlIIlIIIIIII = lllllllllllllIIIIIllIlIIIllllIII.getTag().equals(lllllllllllllIIIIIllIlIIlIIIIIIl);
                    this.emitter.emit(new MappingStartEvent(lllllllllllllIIIIIllIlIIIllllIlI, lllllllllllllIIIIIllIlIIIllllIII.getTag().getValue(), lllllllllllllIIIIIllIlIIlIIIIIII, null, null, ((CollectionNode)lllllllllllllIIIIIllIlIIIllllIII).getFlowStyle()));
                    final MappingNode lllllllllllllIIIIIllIlIIIlllllll = (MappingNode)lllllllllllllIIIIIllIlIIIllllIII;
                    final List<NodeTuple> lllllllllllllIIIIIllIlIIIllllllI = lllllllllllllIIIIIllIlIIIlllllll.getValue();
                    for (final NodeTuple lllllllllllllIIIIIllIlIIlIIIlIll : lllllllllllllIIIIIllIlIIIllllllI) {
                        final Node lllllllllllllIIIIIllIlIIlIIIllIl = lllllllllllllIIIIIllIlIIlIIIlIll.getKeyNode();
                        final Node lllllllllllllIIIIIllIlIIlIIIllII = lllllllllllllIIIIIllIlIIlIIIlIll.getValueNode();
                        this.serializeNode(lllllllllllllIIIIIllIlIIlIIIllIl, lllllllllllllIIIIIllIlIIIlllllll);
                        this.serializeNode(lllllllllllllIIIIIllIlIIlIIIllII, lllllllllllllIIIIIllIlIIIlllllll);
                    }
                    this.emitter.emit(new MappingEndEvent(null, null));
                    break;
                }
            }
        }
    }
    
    public void open() throws IOException {
        if (this.closed == null) {
            this.emitter.emit(new StreamStartEvent(null, null));
            this.closed = Boolean.FALSE;
            return;
        }
        if (Boolean.TRUE.equals(this.closed)) {
            throw new SerializerException("serializer is closed");
        }
        throw new SerializerException("serializer is already opened");
    }
    
    private void anchorNode(Node lllllllllllllIIIIIllIlIIlIlIlIll) {
        if (((Node)lllllllllllllIIIIIllIlIIlIlIlIll).getNodeId() == NodeId.anchor) {
            lllllllllllllIIIIIllIlIIlIlIlIll = ((AnchorNode)lllllllllllllIIIIIllIlIIlIlIlIll).getRealNode();
        }
        if (this.anchors.containsKey(lllllllllllllIIIIIllIlIIlIlIlIll)) {
            String lllllllllllllIIIIIllIlIIlIlllIIl = this.anchors.get(lllllllllllllIIIIIllIlIIlIlIlIll);
            if (null == lllllllllllllIIIIIllIlIIlIlllIIl) {
                lllllllllllllIIIIIllIlIIlIlllIIl = this.anchorGenerator.nextAnchor((Node)lllllllllllllIIIIIllIlIIlIlIlIll);
                this.anchors.put((Node)lllllllllllllIIIIIllIlIIlIlIlIll, lllllllllllllIIIIIllIlIIlIlllIIl);
            }
        }
        else {
            this.anchors.put((Node)lllllllllllllIIIIIllIlIIlIlIlIll, (((Node)lllllllllllllIIIIIllIlIIlIlIlIll).getAnchor() != null) ? this.anchorGenerator.nextAnchor((Node)lllllllllllllIIIIIllIlIIlIlIlIll) : null);
            switch (((Node)lllllllllllllIIIIIllIlIIlIlIlIll).getNodeId()) {
                case sequence: {
                    final SequenceNode lllllllllllllIIIIIllIlIIlIllIIII = (SequenceNode)lllllllllllllIIIIIllIlIIlIlIlIll;
                    final List<Node> lllllllllllllIIIIIllIlIIlIlIllll = lllllllllllllIIIIIllIlIIlIllIIII.getValue();
                    for (final Node lllllllllllllIIIIIllIlIIlIlllIII : lllllllllllllIIIIIllIlIIlIlIllll) {
                        this.anchorNode(lllllllllllllIIIIIllIlIIlIlllIII);
                    }
                    break;
                }
                case mapping: {
                    final MappingNode lllllllllllllIIIIIllIlIIlIllIIlI = (MappingNode)lllllllllllllIIIIIllIlIIlIlIlIll;
                    final List<NodeTuple> lllllllllllllIIIIIllIlIIlIllIIIl = lllllllllllllIIIIIllIlIIlIllIIlI.getValue();
                    for (final NodeTuple lllllllllllllIIIIIllIlIIlIllIlII : lllllllllllllIIIIIllIlIIlIllIIIl) {
                        final Node lllllllllllllIIIIIllIlIIlIllIllI = lllllllllllllIIIIIllIlIIlIllIlII.getKeyNode();
                        final Node lllllllllllllIIIIIllIlIIlIllIlIl = lllllllllllllIIIIIllIlIIlIllIlII.getValueNode();
                        this.anchorNode(lllllllllllllIIIIIllIlIIlIllIllI);
                        this.anchorNode(lllllllllllllIIIIIllIlIIlIllIlIl);
                    }
                    break;
                }
            }
        }
    }
}
