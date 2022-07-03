package org.yaml.snakeyaml.extensions.compactnotation;

import org.yaml.snakeyaml.constructor.*;
import org.yaml.snakeyaml.error.*;
import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.nodes.*;
import java.util.*;
import java.util.regex.*;

public class CompactConstructor extends Constructor
{
    private /* synthetic */ Construct compactConstruct;
    private static final /* synthetic */ Pattern PROPERTY_NAME_PATTERN;
    private static final /* synthetic */ Pattern GUESS_COMPACT;
    private static final /* synthetic */ Pattern FIRST_PATTERN;
    
    protected void setProperties(final Object lllllllllllllIIIIIIIIIlIIlllllIl, final Map<String, Object> lllllllllllllIIIIIIIIIlIIlllllII) throws Exception {
        if (lllllllllllllIIIIIIIIIlIIlllllII == null) {
            throw new NullPointerException("Data for Compact Object Notation cannot be null.");
        }
        for (final Map.Entry<String, Object> lllllllllllllIIIIIIIIIlIlIIIIIll : lllllllllllllIIIIIIIIIlIIlllllII.entrySet()) {
            final String lllllllllllllIIIIIIIIIlIlIIIIlIl = lllllllllllllIIIIIIIIIlIlIIIIIll.getKey();
            final Property lllllllllllllIIIIIIIIIlIlIIIIlII = this.getPropertyUtils().getProperty(lllllllllllllIIIIIIIIIlIIlllllIl.getClass(), lllllllllllllIIIIIIIIIlIlIIIIlIl);
            try {
                lllllllllllllIIIIIIIIIlIlIIIIlII.set(lllllllllllllIIIIIIIIIlIIlllllIl, lllllllllllllIIIIIIIIIlIlIIIIIll.getValue());
            }
            catch (IllegalArgumentException lllllllllllllIIIIIIIIIlIlIIIIllI) {
                throw new YAMLException(String.valueOf(new StringBuilder().append("Cannot set property='").append(lllllllllllllIIIIIIIIIlIlIIIIlIl).append("' with value='").append(lllllllllllllIIIIIIIIIlIIlllllII.get(lllllllllllllIIIIIIIIIlIlIIIIlIl)).append("' (").append(lllllllllllllIIIIIIIIIlIIlllllII.get(lllllllllllllIIIIIIIIIlIlIIIIlIl).getClass()).append(") in ").append(lllllllllllllIIIIIIIIIlIIlllllIl)));
            }
        }
    }
    
    private Construct getCompactConstruct() {
        if (this.compactConstruct == null) {
            this.compactConstruct = this.createCompactConstruct();
        }
        return this.compactConstruct;
    }
    
    @Override
    protected Construct getConstructor(final Node lllllllllllllIIIIIIIIIlIIlIIIIII) {
        if (lllllllllllllIIIIIIIIIlIIlIIIIII instanceof MappingNode) {
            final MappingNode lllllllllllllIIIIIIIIIlIIlIIIlII = (MappingNode)lllllllllllllIIIIIIIIIlIIlIIIIII;
            final List<NodeTuple> lllllllllllllIIIIIIIIIlIIlIIIIll = lllllllllllllIIIIIIIIIlIIlIIIlII.getValue();
            if (lllllllllllllIIIIIIIIIlIIlIIIIll.size() == 1) {
                final NodeTuple lllllllllllllIIIIIIIIIlIIlIIIllI = lllllllllllllIIIIIIIIIlIIlIIIIll.get(0);
                final Node lllllllllllllIIIIIIIIIlIIlIIIlIl = lllllllllllllIIIIIIIIIlIIlIIIllI.getKeyNode();
                if (lllllllllllllIIIIIIIIIlIIlIIIlIl instanceof ScalarNode) {
                    final ScalarNode lllllllllllllIIIIIIIIIlIIlIIIlll = (ScalarNode)lllllllllllllIIIIIIIIIlIIlIIIlIl;
                    if (CompactConstructor.GUESS_COMPACT.matcher(lllllllllllllIIIIIIIIIlIIlIIIlll.getValue()).matches()) {
                        return this.getCompactConstruct();
                    }
                }
            }
        }
        else if (lllllllllllllIIIIIIIIIlIIlIIIIII instanceof ScalarNode) {
            final ScalarNode lllllllllllllIIIIIIIIIlIIlIIIIlI = (ScalarNode)lllllllllllllIIIIIIIIIlIIlIIIIII;
            if (CompactConstructor.GUESS_COMPACT.matcher(lllllllllllllIIIIIIIIIlIIlIIIIlI.getValue()).matches()) {
                return this.getCompactConstruct();
            }
        }
        return super.getConstructor(lllllllllllllIIIIIIIIIlIIlIIIIII);
    }
    
    protected Construct createCompactConstruct() {
        return new ConstructCompactObject();
    }
    
    static {
        GUESS_COMPACT = Pattern.compile("\\p{Alpha}.*\\s*\\((?:,?\\s*(?:(?:\\w*)|(?:\\p{Alpha}\\w*\\s*=.+))\\s*)+\\)");
        FIRST_PATTERN = Pattern.compile("(\\p{Alpha}.*)(\\s*)\\((.*?)\\)");
        PROPERTY_NAME_PATTERN = Pattern.compile("\\s*(\\p{Alpha}\\w*)\\s*=(.+)");
    }
    
    protected String getSequencePropertyName(final Class<?> lllllllllllllIIIIIIIIIlIIIlIIIll) {
        final Set<Property> lllllllllllllIIIIIIIIIlIIIlIIIlI = this.getPropertyUtils().getProperties(lllllllllllllIIIIIIIIIlIIIlIIIll);
        final Iterator<Property> lllllllllllllIIIIIIIIIlIIIlIIlIl = lllllllllllllIIIIIIIIIlIIIlIIIlI.iterator();
        while (lllllllllllllIIIIIIIIIlIIIlIIlIl.hasNext()) {
            final Property lllllllllllllIIIIIIIIIlIIIlIIllI = lllllllllllllIIIIIIIIIlIIIlIIlIl.next();
            if (!List.class.isAssignableFrom(lllllllllllllIIIIIIIIIlIIIlIIllI.getType())) {
                lllllllllllllIIIIIIIIIlIIIlIIlIl.remove();
            }
        }
        if (lllllllllllllIIIIIIIIIlIIIlIIIlI.size() == 0) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("No list property found in ").append(lllllllllllllIIIIIIIIIlIIIlIIIll)));
        }
        if (lllllllllllllIIIIIIIIIlIIIlIIIlI.size() > 1) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Many list properties found in ").append(lllllllllllllIIIIIIIIIlIIIlIIIll).append("; Please override getSequencePropertyName() to specify which property to use.")));
        }
        return lllllllllllllIIIIIIIIIlIIIlIIIlI.iterator().next().getName();
    }
    
    protected Object constructCompactFormat(final ScalarNode lllllllllllllIIIIIIIIIlIlIlIIIll, final CompactData lllllllllllllIIIIIIIIIlIlIlIIIlI) {
        try {
            final Object lllllllllllllIIIIIIIIIlIlIlIlIlI = this.createInstance(lllllllllllllIIIIIIIIIlIlIlIIIll, lllllllllllllIIIIIIIIIlIlIlIIIlI);
            final Map<String, Object> lllllllllllllIIIIIIIIIlIlIlIlIIl = new HashMap<String, Object>(lllllllllllllIIIIIIIIIlIlIlIIIlI.getProperties());
            this.setProperties(lllllllllllllIIIIIIIIIlIlIlIlIlI, lllllllllllllIIIIIIIIIlIlIlIlIIl);
            return lllllllllllllIIIIIIIIIlIlIlIlIlI;
        }
        catch (Exception lllllllllllllIIIIIIIIIlIlIlIlIII) {
            throw new YAMLException(lllllllllllllIIIIIIIIIlIlIlIlIII);
        }
    }
    
    protected void applySequence(final Object lllllllllllllIIIIIIIIIlIIIllIIIl, final List<?> lllllllllllllIIIIIIIIIlIIIllIIII) {
        try {
            final Property lllllllllllllIIIIIIIIIlIIIllIlII = this.getPropertyUtils().getProperty(lllllllllllllIIIIIIIIIlIIIllIIIl.getClass(), this.getSequencePropertyName(lllllllllllllIIIIIIIIIlIIIllIIIl.getClass()));
            lllllllllllllIIIIIIIIIlIIIllIlII.set(lllllllllllllIIIIIIIIIlIIIllIIIl, lllllllllllllIIIIIIIIIlIIIllIIII);
        }
        catch (Exception lllllllllllllIIIIIIIIIlIIIllIIll) {
            throw new YAMLException(lllllllllllllIIIIIIIIIlIIIllIIll);
        }
    }
    
    protected Object createInstance(final ScalarNode lllllllllllllIIIIIIIIIlIlIIllIII, final CompactData lllllllllllllIIIIIIIIIlIlIIlIIlI) throws Exception {
        final Class<?> lllllllllllllIIIIIIIIIlIlIIlIllI = this.getClassForName(lllllllllllllIIIIIIIIIlIlIIlIIlI.getPrefix());
        final Class<?>[] lllllllllllllIIIIIIIIIlIlIIlIlIl = (Class<?>[])new Class[lllllllllllllIIIIIIIIIlIlIIlIIlI.getArguments().size()];
        for (int lllllllllllllIIIIIIIIIlIlIIllIlI = 0; lllllllllllllIIIIIIIIIlIlIIllIlI < lllllllllllllIIIIIIIIIlIlIIlIlIl.length; ++lllllllllllllIIIIIIIIIlIlIIllIlI) {
            lllllllllllllIIIIIIIIIlIlIIlIlIl[lllllllllllllIIIIIIIIIlIlIIllIlI] = String.class;
        }
        final java.lang.reflect.Constructor<?> lllllllllllllIIIIIIIIIlIlIIlIlII = lllllllllllllIIIIIIIIIlIlIIlIllI.getDeclaredConstructor(lllllllllllllIIIIIIIIIlIlIIlIlIl);
        lllllllllllllIIIIIIIIIlIlIIlIlII.setAccessible(true);
        return lllllllllllllIIIIIIIIIlIlIIlIlII.newInstance(lllllllllllllIIIIIIIIIlIlIIlIIlI.getArguments().toArray());
    }
    
    public CompactData getCompactData(final String lllllllllllllIIIIIIIIIlIIllIIIIl) {
        if (!lllllllllllllIIIIIIIIIlIIllIIIIl.endsWith(")")) {
            return null;
        }
        if (lllllllllllllIIIIIIIIIlIIllIIIIl.indexOf(40) < 0) {
            return null;
        }
        final Matcher lllllllllllllIIIIIIIIIlIIllIIIII = CompactConstructor.FIRST_PATTERN.matcher(lllllllllllllIIIIIIIIIlIIllIIIIl);
        if (!lllllllllllllIIIIIIIIIlIIllIIIII.matches()) {
            return null;
        }
        final String lllllllllllllIIIIIIIIIlIIllIIllI = lllllllllllllIIIIIIIIIlIIllIIIII.group(1).trim();
        final String lllllllllllllIIIIIIIIIlIIllIIlIl = lllllllllllllIIIIIIIIIlIIllIIIII.group(3);
        final CompactData lllllllllllllIIIIIIIIIlIIllIIlII = new CompactData(lllllllllllllIIIIIIIIIlIIllIIllI);
        if (lllllllllllllIIIIIIIIIlIIllIIlIl.length() == 0) {
            return lllllllllllllIIIIIIIIIlIIllIIlII;
        }
        final String[] lllllllllllllIIIIIIIIIlIIllIIIll = lllllllllllllIIIIIIIIIlIIllIIlIl.split("\\s*,\\s*");
        for (int lllllllllllllIIIIIIIIIlIIllIIlll = 0; lllllllllllllIIIIIIIIIlIIllIIlll < lllllllllllllIIIIIIIIIlIIllIIIll.length; ++lllllllllllllIIIIIIIIIlIIllIIlll) {
            final String lllllllllllllIIIIIIIIIlIIllIlIII = lllllllllllllIIIIIIIIIlIIllIIIll[lllllllllllllIIIIIIIIIlIIllIIlll];
            if (lllllllllllllIIIIIIIIIlIIllIlIII.indexOf(61) < 0) {
                lllllllllllllIIIIIIIIIlIIllIIlII.getArguments().add(lllllllllllllIIIIIIIIIlIIllIlIII);
            }
            else {
                final Matcher lllllllllllllIIIIIIIIIlIIllIlIIl = CompactConstructor.PROPERTY_NAME_PATTERN.matcher(lllllllllllllIIIIIIIIIlIIllIlIII);
                if (!lllllllllllllIIIIIIIIIlIIllIlIIl.matches()) {
                    return null;
                }
                final String lllllllllllllIIIIIIIIIlIIllIlIll = lllllllllllllIIIIIIIIIlIIllIlIIl.group(1);
                final String lllllllllllllIIIIIIIIIlIIllIlIlI = lllllllllllllIIIIIIIIIlIIllIlIIl.group(2).trim();
                lllllllllllllIIIIIIIIIlIIllIIlII.getProperties().put(lllllllllllllIIIIIIIIIlIIllIlIll, lllllllllllllIIIIIIIIIlIIllIlIlI);
            }
        }
        return lllllllllllllIIIIIIIIIlIIllIIlII;
    }
    
    public class ConstructCompactObject extends ConstructMapping
    {
        @Override
        public void construct2ndStep(final Node llllllllllllllllllIlIIllllIlIlll, final Object llllllllllllllllllIlIIllllIlIllI) {
            final MappingNode llllllllllllllllllIlIIllllIlIlIl = (MappingNode)llllllllllllllllllIlIIllllIlIlll;
            final NodeTuple llllllllllllllllllIlIIllllIlIlII = llllllllllllllllllIlIIllllIlIlIl.getValue().iterator().next();
            final Node llllllllllllllllllIlIIllllIlIIll = llllllllllllllllllIlIIllllIlIlII.getValueNode();
            if (llllllllllllllllllIlIIllllIlIIll instanceof MappingNode) {
                llllllllllllllllllIlIIllllIlIIll.setType(llllllllllllllllllIlIIllllIlIllI.getClass());
                this.constructJavaBean2ndStep((MappingNode)llllllllllllllllllIlIIllllIlIIll, llllllllllllllllllIlIIllllIlIllI);
            }
            else {
                CompactConstructor.this.applySequence(llllllllllllllllllIlIIllllIlIllI, BaseConstructor.this.constructSequence((SequenceNode)llllllllllllllllllIlIIllllIlIIll));
            }
        }
        
        @Override
        public Object construct(final Node llllllllllllllllllIlIIllllIIIIll) {
            ScalarNode llllllllllllllllllIlIIllllIIIIlI = null;
            if (llllllllllllllllllIlIIllllIIIIll instanceof MappingNode) {
                final MappingNode llllllllllllllllllIlIIllllIIIlll = (MappingNode)llllllllllllllllllIlIIllllIIIIll;
                final NodeTuple llllllllllllllllllIlIIllllIIIllI = llllllllllllllllllIlIIllllIIIlll.getValue().iterator().next();
                llllllllllllllllllIlIIllllIIIIll.setTwoStepsConstruction(true);
                final ScalarNode llllllllllllllllllIlIIllllIIIlIl = (ScalarNode)llllllllllllllllllIlIIllllIIIllI.getKeyNode();
            }
            else {
                llllllllllllllllllIlIIllllIIIIlI = (ScalarNode)llllllllllllllllllIlIIllllIIIIll;
            }
            final CompactData llllllllllllllllllIlIIllllIIIIIl = CompactConstructor.this.getCompactData(llllllllllllllllllIlIIllllIIIIlI.getValue());
            if (llllllllllllllllllIlIIllllIIIIIl == null) {
                return BaseConstructor.this.constructScalar(llllllllllllllllllIlIIllllIIIIlI);
            }
            return CompactConstructor.this.constructCompactFormat(llllllllllllllllllIlIIllllIIIIlI, llllllllllllllllllIlIIllllIIIIIl);
        }
    }
}
