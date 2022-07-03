package org.yaml.snakeyaml.representer;

import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;
import java.util.*;
import org.yaml.snakeyaml.nodes.*;

public abstract class BaseRepresenter
{
    protected final /* synthetic */ Map<Class<?>, Represent> representers;
    private /* synthetic */ PropertyUtils propertyUtils;
    protected /* synthetic */ DumperOptions.FlowStyle defaultFlowStyle;
    protected /* synthetic */ DumperOptions.ScalarStyle defaultScalarStyle;
    private /* synthetic */ boolean explicitPropertyUtils;
    protected /* synthetic */ Represent nullRepresenter;
    protected final /* synthetic */ Map<Class<?>, Represent> multiRepresenters;
    protected /* synthetic */ Object objectToRepresent;
    protected final /* synthetic */ Map<Object, Node> representedObjects;
    
    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }
    
    public DumperOptions.ScalarStyle getDefaultScalarStyle() {
        if (this.defaultScalarStyle == null) {
            return DumperOptions.ScalarStyle.PLAIN;
        }
        return this.defaultScalarStyle;
    }
    
    public Node represent(final Object lllllllllllllIIIlIllllIIllIllIIl) {
        final Node lllllllllllllIIIlIllllIIllIllIll = this.representData(lllllllllllllIIIlIllllIIllIllIIl);
        this.representedObjects.clear();
        this.objectToRepresent = null;
        return lllllllllllllIIIlIllllIIllIllIll;
    }
    
    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }
    
    protected final Node representData(final Object lllllllllllllIIIlIllllIIllIIIIII) {
        this.objectToRepresent = lllllllllllllIIIlIllllIIllIIIIII;
        if (this.representedObjects.containsKey(this.objectToRepresent)) {
            final Node lllllllllllllIIIlIllllIIllIlIIII = this.representedObjects.get(this.objectToRepresent);
            return lllllllllllllIIIlIllllIIllIlIIII;
        }
        if (lllllllllllllIIIlIllllIIllIIIIII == null) {
            final Node lllllllllllllIIIlIllllIIllIIllll = this.nullRepresenter.representData(null);
            return lllllllllllllIIIlIllllIIllIIllll;
        }
        final Class<?> lllllllllllllIIIlIllllIIllIIIIlI = lllllllllllllIIIlIllllIIllIIIIII.getClass();
        Node lllllllllllllIIIlIllllIIllIIIIll = null;
        if (this.representers.containsKey(lllllllllllllIIIlIllllIIllIIIIlI)) {
            final Represent lllllllllllllIIIlIllllIIllIIlllI = this.representers.get(lllllllllllllIIIlIllllIIllIIIIlI);
            final Node lllllllllllllIIIlIllllIIllIIllIl = lllllllllllllIIIlIllllIIllIIlllI.representData(lllllllllllllIIIlIllllIIllIIIIII);
        }
        else {
            for (final Class<?> lllllllllllllIIIlIllllIIllIIlIlI : this.multiRepresenters.keySet()) {
                if (lllllllllllllIIIlIllllIIllIIlIlI != null && lllllllllllllIIIlIllllIIllIIlIlI.isInstance(lllllllllllllIIIlIllllIIllIIIIII)) {
                    final Represent lllllllllllllIIIlIllllIIllIIllII = this.multiRepresenters.get(lllllllllllllIIIlIllllIIllIIlIlI);
                    final Node lllllllllllllIIIlIllllIIllIIlIll = lllllllllllllIIIlIllllIIllIIllII.representData(lllllllllllllIIIlIllllIIllIIIIII);
                    return lllllllllllllIIIlIllllIIllIIlIll;
                }
            }
            if (this.multiRepresenters.containsKey(null)) {
                final Represent lllllllllllllIIIlIllllIIllIIlIII = this.multiRepresenters.get(null);
                final Node lllllllllllllIIIlIllllIIllIIIlll = lllllllllllllIIIlIllllIIllIIlIII.representData(lllllllllllllIIIlIllllIIllIIIIII);
            }
            else {
                final Represent lllllllllllllIIIlIllllIIllIIIllI = this.representers.get(null);
                lllllllllllllIIIlIllllIIllIIIIll = lllllllllllllIIIlIllllIIllIIIllI.representData(lllllllllllllIIIlIllllIIllIIIIII);
            }
        }
        return lllllllllllllIIIlIllllIIllIIIIll;
    }
    
    public void setPropertyUtils(final PropertyUtils lllllllllllllIIIlIllllIIIlIIlIIl) {
        this.propertyUtils = lllllllllllllIIIlIllllIIIlIIlIIl;
        this.explicitPropertyUtils = true;
    }
    
    public DumperOptions.FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }
    
    protected Node representScalar(final Tag lllllllllllllIIIlIllllIIlIlIllll, final String lllllllllllllIIIlIllllIIlIlIlllI, DumperOptions.ScalarStyle lllllllllllllIIIlIllllIIlIlIllIl) {
        if (lllllllllllllIIIlIllllIIlIlIllIl == null) {
            lllllllllllllIIIlIllllIIlIlIllIl = this.defaultScalarStyle;
        }
        final Node lllllllllllllIIIlIllllIIlIllIIIl = new ScalarNode(lllllllllllllIIIlIllllIIlIlIllll, lllllllllllllIIIlIllllIIlIlIlllI, null, null, lllllllllllllIIIlIllllIIlIlIllIl);
        return lllllllllllllIIIlIllllIIlIllIIIl;
    }
    
    protected Node representScalar(final Tag lllllllllllllIIIlIllllIIlIlIIlll, final String lllllllllllllIIIlIllllIIlIlIIIll) {
        return this.representScalar(lllllllllllllIIIlIllllIIlIlIIlll, lllllllllllllIIIlIllllIIlIlIIIll, null);
    }
    
    public void setDefaultFlowStyle(final DumperOptions.FlowStyle lllllllllllllIIIlIllllIIIlIlIIlI) {
        this.defaultFlowStyle = lllllllllllllIIIlIllllIIIlIlIIlI;
    }
    
    public void setDefaultScalarStyle(final DumperOptions.ScalarStyle lllllllllllllIIIlIllllIIIlIlllIl) {
        this.defaultScalarStyle = lllllllllllllIIIlIllllIIIlIlllIl;
    }
    
    protected Node representMapping(final Tag lllllllllllllIIIlIllllIIIlllIIIl, final Map<?, ?> lllllllllllllIIIlIllllIIIllIlIIl, final DumperOptions.FlowStyle lllllllllllllIIIlIllllIIIllIlIII) {
        final List<NodeTuple> lllllllllllllIIIlIllllIIIllIlllI = new ArrayList<NodeTuple>(lllllllllllllIIIlIllllIIIllIlIIl.size());
        final MappingNode lllllllllllllIIIlIllllIIIllIllIl = new MappingNode(lllllllllllllIIIlIllllIIIlllIIIl, lllllllllllllIIIlIllllIIIllIlllI, lllllllllllllIIIlIllllIIIllIlIII);
        this.representedObjects.put(this.objectToRepresent, lllllllllllllIIIlIllllIIIllIllIl);
        DumperOptions.FlowStyle lllllllllllllIIIlIllllIIIllIllII = DumperOptions.FlowStyle.FLOW;
        for (final Map.Entry<?, ?> lllllllllllllIIIlIllllIIIlllIlII : lllllllllllllIIIlIllllIIIllIlIIl.entrySet()) {
            final Node lllllllllllllIIIlIllllIIIlllIllI = this.representData(lllllllllllllIIIlIllllIIIlllIlII.getKey());
            final Node lllllllllllllIIIlIllllIIIlllIlIl = this.representData(lllllllllllllIIIlIllllIIIlllIlII.getValue());
            if (!(lllllllllllllIIIlIllllIIIlllIllI instanceof ScalarNode) || !((ScalarNode)lllllllllllllIIIlIllllIIIlllIllI).isPlain()) {
                lllllllllllllIIIlIllllIIIllIllII = DumperOptions.FlowStyle.BLOCK;
            }
            if (!(lllllllllllllIIIlIllllIIIlllIlIl instanceof ScalarNode) || !((ScalarNode)lllllllllllllIIIlIllllIIIlllIlIl).isPlain()) {
                lllllllllllllIIIlIllllIIIllIllII = DumperOptions.FlowStyle.BLOCK;
            }
            lllllllllllllIIIlIllllIIIllIlllI.add(new NodeTuple(lllllllllllllIIIlIllllIIIlllIllI, lllllllllllllIIIlIllllIIIlllIlIl));
        }
        if (lllllllllllllIIIlIllllIIIllIlIII == DumperOptions.FlowStyle.AUTO) {
            if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
                lllllllllllllIIIlIllllIIIllIllIl.setFlowStyle(this.defaultFlowStyle);
            }
            else {
                lllllllllllllIIIlIllllIIIllIllIl.setFlowStyle(lllllllllllllIIIlIllllIIIllIllII);
            }
        }
        return lllllllllllllIIIlIllllIIIllIllIl;
    }
    
    protected Node representSequence(final Tag lllllllllllllIIIlIllllIIlIIlIIll, final Iterable<?> lllllllllllllIIIlIllllIIlIIIlIlI, final DumperOptions.FlowStyle lllllllllllllIIIlIllllIIlIIIlIIl) {
        int lllllllllllllIIIlIllllIIlIIlIIII = 10;
        if (lllllllllllllIIIlIllllIIlIIIlIlI instanceof List) {
            lllllllllllllIIIlIllllIIlIIlIIII = ((List)lllllllllllllIIIlIllllIIlIIIlIlI).size();
        }
        final List<Node> lllllllllllllIIIlIllllIIlIIIllll = new ArrayList<Node>(lllllllllllllIIIlIllllIIlIIlIIII);
        final SequenceNode lllllllllllllIIIlIllllIIlIIIlllI = new SequenceNode(lllllllllllllIIIlIllllIIlIIlIIll, lllllllllllllIIIlIllllIIlIIIllll, lllllllllllllIIIlIllllIIlIIIlIIl);
        this.representedObjects.put(this.objectToRepresent, lllllllllllllIIIlIllllIIlIIIlllI);
        DumperOptions.FlowStyle lllllllllllllIIIlIllllIIlIIIllIl = DumperOptions.FlowStyle.FLOW;
        for (final Object lllllllllllllIIIlIllllIIlIIlIllI : lllllllllllllIIIlIllllIIlIIIlIlI) {
            final Node lllllllllllllIIIlIllllIIlIIlIlll = this.representData(lllllllllllllIIIlIllllIIlIIlIllI);
            if (!(lllllllllllllIIIlIllllIIlIIlIlll instanceof ScalarNode) || !((ScalarNode)lllllllllllllIIIlIllllIIlIIlIlll).isPlain()) {
                lllllllllllllIIIlIllllIIlIIIllIl = DumperOptions.FlowStyle.BLOCK;
            }
            lllllllllllllIIIlIllllIIlIIIllll.add(lllllllllllllIIIlIllllIIlIIlIlll);
        }
        if (lllllllllllllIIIlIllllIIlIIIlIIl == DumperOptions.FlowStyle.AUTO) {
            if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
                lllllllllllllIIIlIllllIIlIIIlllI.setFlowStyle(this.defaultFlowStyle);
            }
            else {
                lllllllllllllIIIlIllllIIlIIIlllI.setFlowStyle(lllllllllllllIIIlIllllIIlIIIllIl);
            }
        }
        return lllllllllllllIIIlIllllIIlIIIlllI;
    }
    
    public BaseRepresenter() {
        this.representers = new HashMap<Class<?>, Represent>();
        this.multiRepresenters = new LinkedHashMap<Class<?>, Represent>();
        this.defaultScalarStyle = null;
        this.defaultFlowStyle = DumperOptions.FlowStyle.AUTO;
        this.representedObjects = new IdentityHashMap<Object, Node>() {
            @Override
            public Node put(final Object lllllllllllllIIIIlllIIIIIIIllIIl, final Node lllllllllllllIIIIlllIIIIIIIllIll) {
                return super.put(lllllllllllllIIIIlllIIIIIIIllIIl, new AnchorNode(lllllllllllllIIIIlllIIIIIIIllIll));
            }
        };
        this.explicitPropertyUtils = false;
    }
}
