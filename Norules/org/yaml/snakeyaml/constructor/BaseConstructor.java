package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.composer.*;
import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;
import java.lang.reflect.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.*;

public abstract class BaseConstructor
{
    private /* synthetic */ boolean allowDuplicateKeys;
    private final /* synthetic */ ArrayList<RecursiveTuple<Set<Object>, Object>> sets2fill;
    protected /* synthetic */ Composer composer;
    private /* synthetic */ PropertyUtils propertyUtils;
    private /* synthetic */ boolean explicitPropertyUtils;
    protected /* synthetic */ Tag rootTag;
    protected final /* synthetic */ Map<NodeId, Construct> yamlClassConstructors;
    private final /* synthetic */ ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>> maps2fill;
    protected final /* synthetic */ Map<Tag, Construct> yamlConstructors;
    protected /* synthetic */ LoaderOptions loadingConfig;
    final /* synthetic */ Map<Node, Object> constructedObjects;
    private /* synthetic */ boolean wrappedToRootException;
    protected final /* synthetic */ Map<Class<?>, TypeDescription> typeDefinitions;
    protected final /* synthetic */ Map<String, Construct> yamlMultiConstructors;
    protected final /* synthetic */ Map<Tag, Class<?>> typeTags;
    private final /* synthetic */ Set<Node> recursiveObjects;
    
    protected void constructSequenceStep2(final SequenceNode lllllllllllllIllIlllllllIIIlllll, final Collection<Object> lllllllllllllIllIlllllllIIIllIll) {
        for (final Node lllllllllllllIllIlllllllIIlIIIlI : lllllllllllllIllIlllllllIIIlllll.getValue()) {
            lllllllllllllIllIlllllllIIIllIll.add(this.constructObject(lllllllllllllIllIlllllllIIlIIIlI));
        }
    }
    
    protected void constructSet2ndStep(final MappingNode lllllllllllllIllIllllllIlIllIlII, final Set<Object> lllllllllllllIllIllllllIlIlIllll) {
        final List<NodeTuple> lllllllllllllIllIllllllIlIllIIlI = lllllllllllllIllIllllllIlIllIlII.getValue();
        for (final NodeTuple lllllllllllllIllIllllllIlIllIlll : lllllllllllllIllIllllllIlIllIIlI) {
            final Node lllllllllllllIllIllllllIlIlllIIl = lllllllllllllIllIllllllIlIllIlll.getKeyNode();
            final Object lllllllllllllIllIllllllIlIlllIII = this.constructObject(lllllllllllllIllIllllllIlIlllIIl);
            if (lllllllllllllIllIllllllIlIlllIII != null) {
                try {
                    lllllllllllllIllIllllllIlIlllIII.hashCode();
                }
                catch (Exception lllllllllllllIllIllllllIlIlllIlI) {
                    throw new ConstructorException("while constructing a Set", lllllllllllllIllIllllllIlIllIlII.getStartMark(), String.valueOf(new StringBuilder().append("found unacceptable key ").append(lllllllllllllIllIllllllIlIlllIII)), lllllllllllllIllIllllllIlIllIlll.getKeyNode().getStartMark(), lllllllllllllIllIllllllIlIlllIlI);
                }
            }
            if (lllllllllllllIllIllllllIlIlllIIl.isTwoStepsConstruction()) {
                this.postponeSetFilling(lllllllllllllIllIllllllIlIlIllll, lllllllllllllIllIllllllIlIlllIII);
            }
            else {
                lllllllllllllIllIllllllIlIlIllll.add(lllllllllllllIllIllllllIlIlllIII);
            }
        }
    }
    
    private void fillRecursive() {
        if (!this.maps2fill.isEmpty()) {
            for (final RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>> lllllllllllllIllIlllllllllIlIIIl : this.maps2fill) {
                final RecursiveTuple<Object, Object> lllllllllllllIllIlllllllllIlIIlI = lllllllllllllIllIlllllllllIlIIIl._2();
                lllllllllllllIllIlllllllllIlIIIl._1().put(lllllllllllllIllIlllllllllIlIIlI._1(), lllllllllllllIllIlllllllllIlIIlI._2());
            }
            this.maps2fill.clear();
        }
        if (!this.sets2fill.isEmpty()) {
            for (final RecursiveTuple<Set<Object>, Object> lllllllllllllIllIlllllllllIIllll : this.sets2fill) {
                lllllllllllllIllIlllllllllIIllll._1().add(lllllllllllllIllIlllllllllIIllll._2());
            }
            this.sets2fill.clear();
        }
    }
    
    protected Set<Object> newSet(final CollectionNode<?> lllllllllllllIllIlllllllIlIlIlIl) {
        try {
            return (Set<Object>)this.newInstance(Set.class, lllllllllllllIllIlllllllIlIlIlIl);
        }
        catch (InstantiationException lllllllllllllIllIlllllllIlIlIlll) {
            return this.createDefaultSet(lllllllllllllIllIlllllllIlIlIlIl.getValue().size());
        }
    }
    
    protected Object createArray(final Class<?> lllllllllllllIllIllllllllIIlIIlI, final int lllllllllllllIllIllllllllIIlIIIl) {
        return Array.newInstance(lllllllllllllIllIllllllllIIlIIlI.getComponentType(), lllllllllllllIllIllllllllIIlIIIl);
    }
    
    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }
    
    public BaseConstructor(final LoaderOptions lllllllllllllIlllIIIIIIIIIIIIIII) {
        this.yamlClassConstructors = new EnumMap<NodeId, Construct>(NodeId.class);
        this.yamlConstructors = new HashMap<Tag, Construct>();
        this.yamlMultiConstructors = new HashMap<String, Construct>();
        this.allowDuplicateKeys = true;
        this.wrappedToRootException = false;
        this.constructedObjects = new HashMap<Node, Object>();
        this.recursiveObjects = new HashSet<Node>();
        this.maps2fill = new ArrayList<RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>>();
        this.sets2fill = new ArrayList<RecursiveTuple<Set<Object>, Object>>();
        this.typeDefinitions = new HashMap<Class<?>, TypeDescription>();
        this.typeTags = new HashMap<Tag, Class<?>>();
        this.rootTag = null;
        this.explicitPropertyUtils = false;
        this.typeDefinitions.put(SortedMap.class, new TypeDescription(SortedMap.class, Tag.OMAP, TreeMap.class));
        this.typeDefinitions.put(SortedSet.class, new TypeDescription(SortedSet.class, Tag.SET, TreeSet.class));
        this.loadingConfig = lllllllllllllIlllIIIIIIIIIIIIIII;
    }
    
    protected Object constructObjectNoCheck(final Node lllllllllllllIllIllllllllIllllIl) {
        if (this.recursiveObjects.contains(lllllllllllllIllIllllllllIllllIl)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", lllllllllllllIllIllllllllIllllIl.getStartMark());
        }
        this.recursiveObjects.add(lllllllllllllIllIllllllllIllllIl);
        final Construct lllllllllllllIllIllllllllIllllII = this.getConstructor(lllllllllllllIllIllllllllIllllIl);
        final Object lllllllllllllIllIllllllllIlllIll = this.constructedObjects.containsKey(lllllllllllllIllIllllllllIllllIl) ? this.constructedObjects.get(lllllllllllllIllIllllllllIllllIl) : lllllllllllllIllIllllllllIllllII.construct(lllllllllllllIllIllllllllIllllIl);
        this.finalizeConstruction(lllllllllllllIllIllllllllIllllIl, lllllllllllllIllIllllllllIlllIll);
        this.constructedObjects.put(lllllllllllllIllIllllllllIllllIl, lllllllllllllIllIllllllllIlllIll);
        this.recursiveObjects.remove(lllllllllllllIllIllllllllIllllIl);
        if (lllllllllllllIllIllllllllIllllIl.isTwoStepsConstruction()) {
            lllllllllllllIllIllllllllIllllII.construct2ndStep(lllllllllllllIllIllllllllIllllIl, lllllllllllllIllIllllllllIlllIll);
        }
        return lllllllllllllIllIllllllllIlllIll;
    }
    
    protected List<Object> createDefaultList(final int lllllllllllllIllIllllllllIlIIIIl) {
        return new ArrayList<Object>(lllllllllllllIllIllllllllIlIIIIl);
    }
    
    public void setAllowDuplicateKeys(final boolean lllllllllllllIllIllllllIIllllIIl) {
        this.allowDuplicateKeys = lllllllllllllIllIllllllIIllllIIl;
    }
    
    protected Set<Object> createDefaultSet(final int lllllllllllllIllIllllllllIIlllII) {
        return new LinkedHashSet<Object>(lllllllllllllIllIllllllllIIlllII);
    }
    
    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }
    
    protected Map<Object, Object> constructMapping(final MappingNode lllllllllllllIllIllllllIllllIIll) {
        final Map<Object, Object> lllllllllllllIllIllllllIllllIIlI = this.newMap(lllllllllllllIllIllllllIllllIIll);
        this.constructMapping2ndStep(lllllllllllllIllIllllllIllllIIll, lllllllllllllIllIllllllIllllIIlI);
        return lllllllllllllIllIllllllIllllIIlI;
    }
    
    protected Object constructObject(final Node lllllllllllllIllIlllllllllIIIIll) {
        if (this.constructedObjects.containsKey(lllllllllllllIllIlllllllllIIIIll)) {
            return this.constructedObjects.get(lllllllllllllIllIlllllllllIIIIll);
        }
        return this.constructObjectNoCheck(lllllllllllllIllIlllllllllIIIIll);
    }
    
    public boolean checkData() {
        return this.composer.checkNode();
    }
    
    public BaseConstructor() {
        this(new LoaderOptions());
    }
    
    public Object getData() throws NoSuchElementException {
        if (!this.composer.checkNode()) {
            throw new NoSuchElementException("No document is available.");
        }
        final Node lllllllllllllIllIlllllllllllIIll = this.composer.getNode();
        if (this.rootTag != null) {
            lllllllllllllIllIlllllllllllIIll.setTag(this.rootTag);
        }
        return this.constructDocument(lllllllllllllIllIlllllllllllIIll);
    }
    
    public void setPropertyUtils(final PropertyUtils lllllllllllllIllIllllllIlIIlIlII) {
        this.propertyUtils = lllllllllllllIllIllllllIlIIlIlII;
        this.explicitPropertyUtils = true;
        final Collection<TypeDescription> lllllllllllllIllIllllllIlIIlIllI = this.typeDefinitions.values();
        for (final TypeDescription lllllllllllllIllIllllllIlIIllIlI : lllllllllllllIllIllllllIlIIlIllI) {
            lllllllllllllIllIllllllIlIIllIlI.setPropertyUtils(lllllllllllllIllIllllllIlIIlIlII);
        }
    }
    
    protected Object newInstance(final Class<?> lllllllllllllIllIlllllllIllIIIII, final Node lllllllllllllIllIlllllllIlIlllll, final boolean lllllllllllllIllIlllllllIllIIIll) throws InstantiationException {
        final Class<?> lllllllllllllIllIlllllllIllIIIlI = lllllllllllllIllIlllllllIlIlllll.getType();
        if (this.typeDefinitions.containsKey(lllllllllllllIllIlllllllIllIIIlI)) {
            final TypeDescription lllllllllllllIllIlllllllIllIlIll = this.typeDefinitions.get(lllllllllllllIllIlllllllIllIIIlI);
            final Object lllllllllllllIllIlllllllIllIlIlI = lllllllllllllIllIlllllllIllIlIll.newInstance(lllllllllllllIllIlllllllIlIlllll);
            if (lllllllllllllIllIlllllllIllIlIlI != null) {
                return lllllllllllllIllIlllllllIllIlIlI;
            }
        }
        if (lllllllllllllIllIlllllllIllIIIll && lllllllllllllIllIlllllllIllIIIII.isAssignableFrom(lllllllllllllIllIlllllllIllIIIlI) && !Modifier.isAbstract(lllllllllllllIllIlllllllIllIIIlI.getModifiers())) {
            try {
                final Constructor<?> lllllllllllllIllIlllllllIllIlIIl = lllllllllllllIllIlllllllIllIIIlI.getDeclaredConstructor((Class<?>[])new Class[0]);
                lllllllllllllIllIlllllllIllIlIIl.setAccessible(true);
                return lllllllllllllIllIlllllllIllIlIIl.newInstance(new Object[0]);
            }
            catch (NoSuchMethodException lllllllllllllIllIlllllllIllIlIII) {
                throw new InstantiationException(String.valueOf(new StringBuilder().append("NoSuchMethodException:").append(lllllllllllllIllIlllllllIllIlIII.getLocalizedMessage())));
            }
            catch (Exception lllllllllllllIllIlllllllIllIIlll) {
                throw new YAMLException(lllllllllllllIllIlllllllIllIIlll);
            }
        }
        throw new InstantiationException();
    }
    
    protected final Object constructDocument(final Node lllllllllllllIllIlllllllllIllIlI) {
        try {
            final Object lllllllllllllIllIlllllllllIlllll = this.constructObject(lllllllllllllIllIlllllllllIllIlI);
            this.fillRecursive();
            final char lllllllllllllIllIlllllllllIllIII = (char)lllllllllllllIllIlllllllllIlllll;
            return lllllllllllllIllIlllllllllIllIII;
        }
        catch (RuntimeException lllllllllllllIllIlllllllllIllllI) {
            if (this.wrappedToRootException && !(lllllllllllllIllIlllllllllIllllI instanceof YAMLException)) {
                throw new YAMLException(lllllllllllllIllIlllllllllIllllI);
            }
            throw lllllllllllllIllIlllllllllIllllI;
        }
        finally {
            this.constructedObjects.clear();
            this.recursiveObjects.clear();
        }
    }
    
    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }
    
    public TypeDescription addTypeDescription(final TypeDescription lllllllllllllIllIllllllIlIIIIllI) {
        if (lllllllllllllIllIllllllIlIIIIllI == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        final Tag lllllllllllllIllIllllllIlIIIlIII = lllllllllllllIllIllllllIlIIIIllI.getTag();
        this.typeTags.put(lllllllllllllIllIllllllIlIIIlIII, lllllllllllllIllIllllllIlIIIIllI.getType());
        lllllllllllllIllIllllllIlIIIIllI.setPropertyUtils(this.getPropertyUtils());
        return this.typeDefinitions.put(lllllllllllllIllIllllllIlIIIIllI.getType(), lllllllllllllIllIllllllIlIIIIllI);
    }
    
    protected String constructScalar(final ScalarNode lllllllllllllIllIllllllllIlIIlII) {
        return lllllllllllllIllIllllllllIlIIlII.getValue();
    }
    
    protected Object newInstance(final Node lllllllllllllIllIlllllllIlllllll) {
        try {
            return this.newInstance(Object.class, lllllllllllllIllIlllllllIlllllll);
        }
        catch (InstantiationException lllllllllllllIllIllllllllIIIIIIl) {
            throw new YAMLException(lllllllllllllIllIllllllllIIIIIIl);
        }
    }
    
    protected Map<Object, Object> createDefaultMap(final int lllllllllllllIllIllllllllIIllIII) {
        return new LinkedHashMap<Object, Object>(lllllllllllllIllIllllllllIIllIII);
    }
    
    protected Object finalizeConstruction(final Node lllllllllllllIllIllllllllIIIlIll, final Object lllllllllllllIllIllllllllIIIIllI) {
        final Class<?> lllllllllllllIllIllllllllIIIlIIl = lllllllllllllIllIllllllllIIIlIll.getType();
        if (this.typeDefinitions.containsKey(lllllllllllllIllIllllllllIIIlIIl)) {
            return this.typeDefinitions.get(lllllllllllllIllIllllllllIIIlIIl).finalizeConstruction(lllllllllllllIllIllllllllIIIIllI);
        }
        return lllllllllllllIllIllllllllIIIIllI;
    }
    
    protected Construct getConstructor(final Node lllllllllllllIllIllllllllIlIllIl) {
        if (lllllllllllllIllIllllllllIlIllIl.useClassConstructor()) {
            return this.yamlClassConstructors.get(lllllllllllllIllIllllllllIlIllIl.getNodeId());
        }
        final Construct lllllllllllllIllIllllllllIlIllll = this.yamlConstructors.get(lllllllllllllIllIllllllllIlIllIl.getTag());
        if (lllllllllllllIllIllllllllIlIllll == null) {
            for (final String lllllllllllllIllIllllllllIllIIIl : this.yamlMultiConstructors.keySet()) {
                if (lllllllllllllIllIllllllllIlIllIl.getTag().startsWith(lllllllllllllIllIllllllllIllIIIl)) {
                    return this.yamlMultiConstructors.get(lllllllllllllIllIllllllllIllIIIl);
                }
            }
            return this.yamlConstructors.get(null);
        }
        return lllllllllllllIllIllllllllIlIllll;
    }
    
    protected List<Object> newList(final SequenceNode lllllllllllllIllIlllllllIlIIlIlI) {
        try {
            return (List<Object>)this.newInstance(List.class, lllllllllllllIllIlllllllIlIIlIlI);
        }
        catch (InstantiationException lllllllllllllIllIlllllllIlIIlllI) {
            return this.createDefaultList(lllllllllllllIllIlllllllIlIIlIlI.getValue().size());
        }
    }
    
    protected Set<Object> constructSet(final MappingNode lllllllllllllIllIllllllIllllllII) {
        final Set<Object> lllllllllllllIllIllllllIlllllIll = this.newSet(lllllllllllllIllIllllllIllllllII);
        this.constructSet2ndStep(lllllllllllllIllIllllllIllllllII, lllllllllllllIllIllllllIlllllIll);
        return lllllllllllllIllIllllllIlllllIll;
    }
    
    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }
    
    protected Map<Object, Object> newMap(final MappingNode lllllllllllllIllIlllllllIlIIIIIl) {
        try {
            return (Map<Object, Object>)this.newInstance(Map.class, lllllllllllllIllIlllllllIlIIIIIl);
        }
        catch (InstantiationException lllllllllllllIllIlllllllIlIIIlIl) {
            return this.createDefaultMap(lllllllllllllIllIlllllllIlIIIIIl.getValue().size());
        }
    }
    
    public void setComposer(final Composer lllllllllllllIllIllllllllllllIlI) {
        this.composer = lllllllllllllIllIllllllllllllIlI;
    }
    
    protected void postponeMapFilling(final Map<Object, Object> lllllllllllllIllIllllllIllIIIllI, final Object lllllllllllllIllIllllllIllIIIlIl, final Object lllllllllllllIllIllllllIllIIlIII) {
        this.maps2fill.add(0, new RecursiveTuple<Map<Object, Object>, RecursiveTuple<Object, Object>>(lllllllllllllIllIllllllIllIIIllI, new RecursiveTuple<Object, Object>(lllllllllllllIllIllllllIllIIIlIl, lllllllllllllIllIllllllIllIIlIII)));
    }
    
    protected Set<?> constructSet(final SequenceNode lllllllllllllIllIlllllllIIllIIlI) {
        final Set<Object> lllllllllllllIllIlllllllIIllIIIl = this.newSet(lllllllllllllIllIlllllllIIllIIlI);
        this.constructSequenceStep2(lllllllllllllIllIlllllllIIllIIlI, lllllllllllllIllIlllllllIIllIIIl);
        return lllllllllllllIllIlllllllIIllIIIl;
    }
    
    protected List<?> constructSequence(final SequenceNode lllllllllllllIllIlllllllIIlllIll) {
        final List<Object> lllllllllllllIllIlllllllIIlllIlI = this.newList(lllllllllllllIllIlllllllIIlllIll);
        this.constructSequenceStep2(lllllllllllllIllIlllllllIIlllIll, lllllllllllllIllIlllllllIIlllIlI);
        return lllllllllllllIllIlllllllIIlllIlI;
    }
    
    protected Object constructArrayStep2(final SequenceNode lllllllllllllIllIlllllllIIIIIlll, final Object lllllllllllllIllIlllllllIIIIIllI) {
        final Class<?> lllllllllllllIllIlllllllIIIIlIlI = lllllllllllllIllIlllllllIIIIIlll.getType().getComponentType();
        int lllllllllllllIllIlllllllIIIIlIIl = 0;
        for (final Node lllllllllllllIllIlllllllIIIIllll : lllllllllllllIllIlllllllIIIIIlll.getValue()) {
            if (lllllllllllllIllIlllllllIIIIllll.getType() == Object.class) {
                lllllllllllllIllIlllllllIIIIllll.setType(lllllllllllllIllIlllllllIIIIlIlI);
            }
            final Object lllllllllllllIllIlllllllIIIlIIII = this.constructObject(lllllllllllllIllIlllllllIIIIllll);
            if (lllllllllllllIllIlllllllIIIIlIlI.isPrimitive()) {
                if (lllllllllllllIllIlllllllIIIlIIII == null) {
                    throw new NullPointerException(String.valueOf(new StringBuilder().append("Unable to construct element value for ").append(lllllllllllllIllIlllllllIIIIllll)));
                }
                if (Byte.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setByte(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, ((Number)lllllllllllllIllIlllllllIIIlIIII).byteValue());
                }
                else if (Short.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setShort(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, ((Number)lllllllllllllIllIlllllllIIIlIIII).shortValue());
                }
                else if (Integer.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setInt(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, ((Number)lllllllllllllIllIlllllllIIIlIIII).intValue());
                }
                else if (Long.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setLong(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, ((Number)lllllllllllllIllIlllllllIIIlIIII).longValue());
                }
                else if (Float.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setFloat(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, ((Number)lllllllllllllIllIlllllllIIIlIIII).floatValue());
                }
                else if (Double.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setDouble(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, ((Number)lllllllllllllIllIlllllllIIIlIIII).doubleValue());
                }
                else if (Character.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                    Array.setChar(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, (char)lllllllllllllIllIlllllllIIIlIIII);
                }
                else {
                    if (!Boolean.TYPE.equals(lllllllllllllIllIlllllllIIIIlIlI)) {
                        throw new YAMLException("unexpected primitive type");
                    }
                    Array.setBoolean(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, (boolean)lllllllllllllIllIlllllllIIIlIIII);
                }
            }
            else {
                Array.set(lllllllllllllIllIlllllllIIIIIllI, lllllllllllllIllIlllllllIIIIlIIl, lllllllllllllIllIlllllllIIIlIIII);
            }
            ++lllllllllllllIllIlllllllIIIIlIIl;
        }
        return lllllllllllllIllIlllllllIIIIIllI;
    }
    
    protected void constructMapping2ndStep(final MappingNode lllllllllllllIllIllllllIllIllIII, final Map<Object, Object> lllllllllllllIllIllllllIllIlIlll) {
        final List<NodeTuple> lllllllllllllIllIllllllIllIllIlI = lllllllllllllIllIllllllIllIllIII.getValue();
        for (final NodeTuple lllllllllllllIllIllllllIllIlllll : lllllllllllllIllIllllllIllIllIlI) {
            final Node lllllllllllllIllIllllllIlllIIIll = lllllllllllllIllIllllllIllIlllll.getKeyNode();
            final Node lllllllllllllIllIllllllIlllIIIlI = lllllllllllllIllIllllllIllIlllll.getValueNode();
            final Object lllllllllllllIllIllllllIlllIIIIl = this.constructObject(lllllllllllllIllIllllllIlllIIIll);
            if (lllllllllllllIllIllllllIlllIIIIl != null) {
                try {
                    lllllllllllllIllIllllllIlllIIIIl.hashCode();
                }
                catch (Exception lllllllllllllIllIllllllIlllIIlII) {
                    throw new ConstructorException("while constructing a mapping", lllllllllllllIllIllllllIllIllIII.getStartMark(), String.valueOf(new StringBuilder().append("found unacceptable key ").append(lllllllllllllIllIllllllIlllIIIIl)), lllllllllllllIllIllllllIllIlllll.getKeyNode().getStartMark(), lllllllllllllIllIllllllIlllIIlII);
                }
            }
            final Object lllllllllllllIllIllllllIlllIIIII = this.constructObject(lllllllllllllIllIllllllIlllIIIlI);
            if (lllllllllllllIllIllllllIlllIIIll.isTwoStepsConstruction()) {
                if (!this.loadingConfig.getAllowRecursiveKeys()) {
                    throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
                }
                this.postponeMapFilling(lllllllllllllIllIllllllIllIlIlll, lllllllllllllIllIllllllIlllIIIIl, lllllllllllllIllIllllllIlllIIIII);
            }
            else {
                lllllllllllllIllIllllllIllIlIlll.put(lllllllllllllIllIllllllIlllIIIIl, lllllllllllllIllIllllllIlllIIIII);
            }
        }
    }
    
    public void setWrappedToRootException(final boolean lllllllllllllIllIllllllIIlllIIII) {
        this.wrappedToRootException = lllllllllllllIllIllllllIIlllIIII;
    }
    
    protected void postponeSetFilling(final Set<Object> lllllllllllllIllIllllllIlIlIIIIl, final Object lllllllllllllIllIllllllIlIlIIIII) {
        this.sets2fill.add(0, new RecursiveTuple<Set<Object>, Object>(lllllllllllllIllIllllllIlIlIIIIl, lllllllllllllIllIllllllIlIlIIIII));
    }
    
    protected final Object newInstance(final Class<?> lllllllllllllIllIlllllllIlllIlll, final Node lllllllllllllIllIlllllllIlllIIll) throws InstantiationException {
        return this.newInstance(lllllllllllllIllIlllllllIlllIlll, lllllllllllllIllIlllllllIlllIIll, true);
    }
    
    protected Object constructArray(final SequenceNode lllllllllllllIllIlllllllIIlIlIlI) {
        return this.constructArrayStep2(lllllllllllllIllIlllllllIIlIlIlI, this.createArray(lllllllllllllIllIlllllllIIlIlIlI.getType(), lllllllllllllIllIlllllllIIlIlIlI.getValue().size()));
    }
    
    public Object getSingleData(final Class<?> lllllllllllllIllIllllllllllIIlll) {
        final Node lllllllllllllIllIllllllllllIlIIl = this.composer.getSingleNode();
        if (lllllllllllllIllIllllllllllIlIIl != null && !Tag.NULL.equals(lllllllllllllIllIllllllllllIlIIl.getTag())) {
            if (Object.class != lllllllllllllIllIllllllllllIIlll) {
                lllllllllllllIllIllllllllllIlIIl.setTag(new Tag(lllllllllllllIllIllllllllllIIlll));
            }
            else if (this.rootTag != null) {
                lllllllllllllIllIllllllllllIlIIl.setTag(this.rootTag);
            }
            return this.constructDocument(lllllllllllllIllIllllllllllIlIIl);
        }
        final Construct lllllllllllllIllIllllllllllIllII = this.yamlConstructors.get(Tag.NULL);
        return lllllllllllllIllIllllllllllIllII.construct(lllllllllllllIllIllllllllllIlIIl);
    }
    
    private static class RecursiveTuple<T, K>
    {
        private final /* synthetic */ T _1;
        private final /* synthetic */ K _2;
        
        public T _1() {
            return this._1;
        }
        
        public K _2() {
            return this._2;
        }
        
        public RecursiveTuple(final T lllllllllllllIlIIIlIIlIIIIlllllI, final K lllllllllllllIlIIIlIIlIIIIllllIl) {
            this._1 = lllllllllllllIlIIIlIIlIIIIlllllI;
            this._2 = lllllllllllllIlIIIlIIlIIIIllllIl;
        }
    }
}
