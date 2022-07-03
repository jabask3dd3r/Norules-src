package org.yaml.snakeyaml.representer;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.*;

public class Representer extends SafeRepresenter
{
    protected /* synthetic */ Map<Class<?>, TypeDescription> typeDefinitions;
    
    private void resetTag(final Class<?> llllllllllllllIIllIIlllllIIIIIlI, final Node llllllllllllllIIllIIlllllIIIIllI) {
        final Tag llllllllllllllIIllIIlllllIIIIlII = llllllllllllllIIllIIlllllIIIIllI.getTag();
        if (llllllllllllllIIllIIlllllIIIIlII.matches(llllllllllllllIIllIIlllllIIIIIlI)) {
            if (Enum.class.isAssignableFrom(llllllllllllllIIllIIlllllIIIIIlI)) {
                llllllllllllllIIllIIlllllIIIIllI.setTag(Tag.STR);
            }
            else {
                llllllllllllllIIllIIlllllIIIIllI.setTag(Tag.MAP);
            }
        }
    }
    
    public Representer(final DumperOptions llllllllllllllIIllIlIIIIIlIIIlIl) {
        super(llllllllllllllIIllIlIIIIIlIIIlIl);
        this.typeDefinitions = Collections.emptyMap();
        this.representers.put(null, new RepresentJavaBean());
    }
    
    public Representer() {
        this.typeDefinitions = Collections.emptyMap();
        this.representers.put(null, new RepresentJavaBean());
    }
    
    protected NodeTuple representJavaBeanProperty(final Object llllllllllllllIIllIIllllllllIIll, final Property llllllllllllllIIllIIllllllllIIIl, final Object llllllllllllllIIllIIlllllllIIIll, final Tag llllllllllllllIIllIIlllllllIIIlI) {
        final ScalarNode llllllllllllllIIllIIlllllllIlIll = (ScalarNode)this.representData(llllllllllllllIIllIIllllllllIIIl.getName());
        final boolean llllllllllllllIIllIIlllllllIlIIl = this.representedObjects.containsKey(llllllllllllllIIllIIlllllllIIIll);
        final Node llllllllllllllIIllIIlllllllIIlll = this.representData(llllllllllllllIIllIIlllllllIIIll);
        if (llllllllllllllIIllIIlllllllIIIll != null && !llllllllllllllIIllIIlllllllIlIIl) {
            final NodeId llllllllllllllIIllIIllllllllIlll = llllllllllllllIIllIIlllllllIIlll.getNodeId();
            if (llllllllllllllIIllIIlllllllIIIlI == null) {
                if (llllllllllllllIIllIIllllllllIlll == NodeId.scalar) {
                    if (llllllllllllllIIllIIllllllllIIIl.getType() != Enum.class && llllllllllllllIIllIIlllllllIIIll instanceof Enum) {
                        llllllllllllllIIllIIlllllllIIlll.setTag(Tag.STR);
                    }
                }
                else {
                    if (llllllllllllllIIllIIllllllllIlll == NodeId.mapping && llllllllllllllIIllIIllllllllIIIl.getType() == llllllllllllllIIllIIlllllllIIIll.getClass() && !(llllllllllllllIIllIIlllllllIIIll instanceof Map) && !llllllllllllllIIllIIlllllllIIlll.getTag().equals(Tag.SET)) {
                        llllllllllllllIIllIIlllllllIIlll.setTag(Tag.MAP);
                    }
                    this.checkGlobalTag(llllllllllllllIIllIIllllllllIIIl, llllllllllllllIIllIIlllllllIIlll, llllllllllllllIIllIIlllllllIIIll);
                }
            }
        }
        return new NodeTuple(llllllllllllllIIllIIlllllllIlIll, llllllllllllllIIllIIlllllllIIlll);
    }
    
    @Override
    public void setPropertyUtils(final PropertyUtils llllllllllllllIIllIlIIIIIIllIIll) {
        super.setPropertyUtils(llllllllllllllIIllIlIIIIIIllIIll);
        final Collection<TypeDescription> llllllllllllllIIllIlIIIIIIllIlIl = this.typeDefinitions.values();
        for (final TypeDescription llllllllllllllIIllIlIIIIIIlllIIl : llllllllllllllIIllIlIIIIIIllIlIl) {
            llllllllllllllIIllIlIIIIIIlllIIl.setPropertyUtils(llllllllllllllIIllIlIIIIIIllIIll);
        }
    }
    
    protected Set<Property> getProperties(final Class<?> llllllllllllllIIllIIllllIllIlllI) {
        if (this.typeDefinitions.containsKey(llllllllllllllIIllIIllllIllIlllI)) {
            return this.typeDefinitions.get(llllllllllllllIIllIIllllIllIlllI).getProperties();
        }
        return this.getPropertyUtils().getProperties(llllllllllllllIIllIIllllIllIlllI);
    }
    
    protected MappingNode representJavaBean(final Set<Property> llllllllllllllIIllIlIIIIIIIllIlI, final Object llllllllllllllIIllIlIIIIIIIlIIIl) {
        final List<NodeTuple> llllllllllllllIIllIlIIIIIIIllIII = new ArrayList<NodeTuple>(llllllllllllllIIllIlIIIIIIIllIlI.size());
        final Tag llllllllllllllIIllIlIIIIIIIlIllI = this.classTags.get(llllllllllllllIIllIlIIIIIIIlIIIl.getClass());
        final Tag llllllllllllllIIllIlIIIIIIIlIlll = (llllllllllllllIIllIlIIIIIIIlIllI != null) ? llllllllllllllIIllIlIIIIIIIlIllI : new Tag(llllllllllllllIIllIlIIIIIIIlIIIl.getClass());
        final MappingNode llllllllllllllIIllIlIIIIIIIlIlIl = new MappingNode(llllllllllllllIIllIlIIIIIIIlIlll, llllllllllllllIIllIlIIIIIIIllIII, DumperOptions.FlowStyle.AUTO);
        this.representedObjects.put(llllllllllllllIIllIlIIIIIIIlIIIl, llllllllllllllIIllIlIIIIIIIlIlIl);
        DumperOptions.FlowStyle llllllllllllllIIllIlIIIIIIIlIlII = DumperOptions.FlowStyle.FLOW;
        for (final Property llllllllllllllIIllIlIIIIIIIlllIl : llllllllllllllIIllIlIIIIIIIllIlI) {
            final Object llllllllllllllIIllIlIIIIIIlIIIIl = llllllllllllllIIllIlIIIIIIIlllIl.get(llllllllllllllIIllIlIIIIIIIlIIIl);
            final Tag llllllllllllllIIllIlIIIIIIlIIIII = (llllllllllllllIIllIlIIIIIIlIIIIl == null) ? null : this.classTags.get(llllllllllllllIIllIlIIIIIIlIIIIl.getClass());
            final NodeTuple llllllllllllllIIllIlIIIIIIIlllll = this.representJavaBeanProperty(llllllllllllllIIllIlIIIIIIIlIIIl, llllllllllllllIIllIlIIIIIIIlllIl, llllllllllllllIIllIlIIIIIIlIIIIl, llllllllllllllIIllIlIIIIIIlIIIII);
            if (llllllllllllllIIllIlIIIIIIIlllll == null) {
                continue;
            }
            if (!((ScalarNode)llllllllllllllIIllIlIIIIIIIlllll.getKeyNode()).isPlain()) {
                llllllllllllllIIllIlIIIIIIIlIlII = DumperOptions.FlowStyle.BLOCK;
            }
            final Node llllllllllllllIIllIlIIIIIIIllllI = llllllllllllllIIllIlIIIIIIIlllll.getValueNode();
            if (!(llllllllllllllIIllIlIIIIIIIllllI instanceof ScalarNode) || !((ScalarNode)llllllllllllllIIllIlIIIIIIIllllI).isPlain()) {
                llllllllllllllIIllIlIIIIIIIlIlII = DumperOptions.FlowStyle.BLOCK;
            }
            llllllllllllllIIllIlIIIIIIIllIII.add(llllllllllllllIIllIlIIIIIIIlllll);
        }
        if (this.defaultFlowStyle != DumperOptions.FlowStyle.AUTO) {
            llllllllllllllIIllIlIIIIIIIlIlIl.setFlowStyle(this.defaultFlowStyle);
        }
        else {
            llllllllllllllIIllIlIIIIIIIlIlIl.setFlowStyle(llllllllllllllIIllIlIIIIIIIlIlII);
        }
        return llllllllllllllIIllIlIIIIIIIlIlIl;
    }
    
    protected void checkGlobalTag(final Property llllllllllllllIIllIIlllllIlIlllI, final Node llllllllllllllIIllIIlllllIlIlIll, final Object llllllllllllllIIllIIlllllIlIIlII) {
        if (llllllllllllllIIllIIlllllIlIIlII.getClass().isArray() && llllllllllllllIIllIIlllllIlIIlII.getClass().getComponentType().isPrimitive()) {
            return;
        }
        final Class<?>[] llllllllllllllIIllIIlllllIlIlIII = llllllllllllllIIllIIlllllIlIlllI.getActualTypeArguments();
        if (llllllllllllllIIllIIlllllIlIlIII != null) {
            if (llllllllllllllIIllIIlllllIlIlIll.getNodeId() == NodeId.sequence) {
                final Class<?> llllllllllllllIIllIIllllllIIlIlI = llllllllllllllIIllIIlllllIlIlIII[0];
                final SequenceNode llllllllllllllIIllIIllllllIIlIIl = (SequenceNode)llllllllllllllIIllIIlllllIlIlIll;
                Iterable<Object> llllllllllllllIIllIIllllllIIlIII = (Iterable<Object>)Collections.EMPTY_LIST;
                if (llllllllllllllIIllIIlllllIlIIlII.getClass().isArray()) {
                    llllllllllllllIIllIIllllllIIlIII = Arrays.asList((Object[])llllllllllllllIIllIIlllllIlIIlII);
                }
                else if (llllllllllllllIIllIIlllllIlIIlII instanceof Iterable) {
                    llllllllllllllIIllIIllllllIIlIII = (Iterable<Object>)llllllllllllllIIllIIlllllIlIIlII;
                }
                final Iterator<Object> llllllllllllllIIllIIllllllIIIllI = llllllllllllllIIllIIllllllIIlIII.iterator();
                if (llllllllllllllIIllIIllllllIIIllI.hasNext()) {
                    for (final Node llllllllllllllIIllIIllllllIIllII : llllllllllllllIIllIIllllllIIlIIl.getValue()) {
                        final Object llllllllllllllIIllIIllllllIIllIl = llllllllllllllIIllIIllllllIIIllI.next();
                        if (llllllllllllllIIllIIllllllIIllIl != null && llllllllllllllIIllIIllllllIIlIlI.equals(llllllllllllllIIllIIllllllIIllIl.getClass()) && llllllllllllllIIllIIllllllIIllII.getNodeId() == NodeId.mapping) {
                            llllllllllllllIIllIIllllllIIllII.setTag(Tag.MAP);
                        }
                    }
                }
            }
            else if (llllllllllllllIIllIIlllllIlIIlII instanceof Set) {
                final Class<?> llllllllllllllIIllIIllllllIIIIII = llllllllllllllIIllIIlllllIlIlIII[0];
                final MappingNode llllllllllllllIIllIIlllllIllllll = (MappingNode)llllllllllllllIIllIIlllllIlIlIll;
                final Iterator<NodeTuple> llllllllllllllIIllIIlllllIllllII = llllllllllllllIIllIIlllllIllllll.getValue().iterator();
                final Set<?> llllllllllllllIIllIIlllllIlllIlI = (Set<?>)llllllllllllllIIllIIlllllIlIIlII;
                for (final Object llllllllllllllIIllIIllllllIIIIll : llllllllllllllIIllIIlllllIlllIlI) {
                    final NodeTuple llllllllllllllIIllIIllllllIIIlIl = llllllllllllllIIllIIlllllIllllII.next();
                    final Node llllllllllllllIIllIIllllllIIIlII = llllllllllllllIIllIIllllllIIIlIl.getKeyNode();
                    if (llllllllllllllIIllIIllllllIIIIII.equals(llllllllllllllIIllIIllllllIIIIll.getClass()) && llllllllllllllIIllIIllllllIIIlII.getNodeId() == NodeId.mapping) {
                        llllllllllllllIIllIIllllllIIIlII.setTag(Tag.MAP);
                    }
                }
            }
            else if (llllllllllllllIIllIIlllllIlIIlII instanceof Map) {
                final Class<?> llllllllllllllIIllIIlllllIllIllI = llllllllllllllIIllIIlllllIlIlIII[0];
                final Class<?> llllllllllllllIIllIIlllllIllIlII = llllllllllllllIIllIIlllllIlIlIII[1];
                final MappingNode llllllllllllllIIllIIlllllIllIIlI = (MappingNode)llllllllllllllIIllIIlllllIlIlIll;
                for (final NodeTuple llllllllllllllIIllIIlllllIlllIIl : llllllllllllllIIllIIlllllIllIIlI.getValue()) {
                    this.resetTag(llllllllllllllIIllIIlllllIllIllI, llllllllllllllIIllIIlllllIlllIIl.getKeyNode());
                    this.resetTag(llllllllllllllIIllIIlllllIllIlII, llllllllllllllIIllIIlllllIlllIIl.getValueNode());
                }
            }
        }
    }
    
    public TypeDescription addTypeDescription(final TypeDescription llllllllllllllIIllIlIIIIIIllllll) {
        if (Collections.EMPTY_MAP == this.typeDefinitions) {
            this.typeDefinitions = new HashMap<Class<?>, TypeDescription>();
        }
        if (llllllllllllllIIllIlIIIIIIllllll.getTag() != null) {
            this.addClassTag(llllllllllllllIIllIlIIIIIIllllll.getType(), llllllllllllllIIllIlIIIIIIllllll.getTag());
        }
        llllllllllllllIIllIlIIIIIIllllll.setPropertyUtils(this.getPropertyUtils());
        return this.typeDefinitions.put(llllllllllllllIIllIlIIIIIIllllll.getType(), llllllllllllllIIllIlIIIIIIllllll);
    }
    
    protected class RepresentJavaBean implements Represent
    {
        @Override
        public Node representData(final Object llllllllllllllllllllllIIllIlIllI) {
            return Representer.this.representJavaBean(Representer.this.getProperties(llllllllllllllllllllllIIllIlIllI.getClass()), llllllllllllllllllllllIIllIlIllI);
        }
    }
}
