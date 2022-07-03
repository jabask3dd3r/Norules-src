package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;
import java.math.*;
import java.util.*;
import org.yaml.snakeyaml.nodes.*;
import org.yaml.snakeyaml.introspector.*;

public class Constructor extends SafeConstructor
{
    public Constructor(final TypeDescription lllllllllllllIIIlllIlIlIIIIllllI, final LoaderOptions lllllllllllllIIIlllIlIlIIIIllIlI) {
        this(lllllllllllllIIIlllIlIlIIIIllllI, null, lllllllllllllIIIlllIlIlIIIIllIlI);
    }
    
    public Constructor(final TypeDescription lllllllllllllIIIlllIlIlIIIlIIIll) {
        this(lllllllllllllIIIlllIlIlIIIlIIIll, null, new LoaderOptions());
    }
    
    public Constructor(final String lllllllllllllIIIlllIlIIllllllIll) throws ClassNotFoundException {
        this(Class.forName(check(lllllllllllllIIIlllIlIIllllllIll)));
    }
    
    protected Class<?> getClassForName(final String lllllllllllllIIIlllIlIIlllIlIllI) throws ClassNotFoundException {
        try {
            return Class.forName(lllllllllllllIIIlllIlIIlllIlIllI, true, Thread.currentThread().getContextClassLoader());
        }
        catch (ClassNotFoundException lllllllllllllIIIlllIlIIlllIllIII) {
            return Class.forName(lllllllllllllIIIlllIlIIlllIlIllI);
        }
    }
    
    private static final String check(final String lllllllllllllIIIlllIlIIllllIllIl) {
        if (lllllllllllllIIIlllIlIIllllIllIl == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        if (lllllllllllllIIIlllIlIIllllIllIl.trim().length() == 0) {
            throw new YAMLException("Root type must be provided.");
        }
        return lllllllllllllIIIlllIlIIllllIllIl;
    }
    
    private static Class<?> checkRoot(final Class<?> lllllllllllllIIIlllIlIlIIIlIlIIl) {
        if (lllllllllllllIIIlllIlIlIIIlIlIIl == null) {
            throw new NullPointerException("Root class must be provided.");
        }
        return lllllllllllllIIIlllIlIlIIIlIlIIl;
    }
    
    public Constructor(final Class<?> lllllllllllllIIIlllIlIlIIIllIIII, final LoaderOptions lllllllllllllIIIlllIlIlIIIlIllll) {
        this(new TypeDescription(checkRoot(lllllllllllllIIIlllIlIlIIIllIIII)), lllllllllllllIIIlllIlIlIIIlIllll);
    }
    
    public Constructor(final String lllllllllllllIIIlllIlIIlllllIlII, final LoaderOptions lllllllllllllIIIlllIlIIlllllIIII) throws ClassNotFoundException {
        this(Class.forName(check(lllllllllllllIIIlllIlIIlllllIlII)), lllllllllllllIIIlllIlIIlllllIIII);
    }
    
    protected Class<?> getClassForNode(final Node lllllllllllllIIIlllIlIIllllIIIlI) {
        final Class<?> lllllllllllllIIIlllIlIIllllIIIIl = this.typeTags.get(lllllllllllllIIIlllIlIIllllIIIlI.getTag());
        if (lllllllllllllIIIlllIlIIllllIIIIl == null) {
            final String lllllllllllllIIIlllIlIIllllIIlIl = lllllllllllllIIIlllIlIIllllIIIlI.getTag().getClassName();
            Class<?> lllllllllllllIIIlllIlIIllllIIlII;
            try {
                lllllllllllllIIIlllIlIIllllIIlII = this.getClassForName(lllllllllllllIIIlllIlIIllllIIlIl);
            }
            catch (ClassNotFoundException lllllllllllllIIIlllIlIIllllIIllI) {
                throw new YAMLException(String.valueOf(new StringBuilder().append("Class not found: ").append(lllllllllllllIIIlllIlIIllllIIlIl)));
            }
            this.typeTags.put(lllllllllllllIIIlllIlIIllllIIIlI.getTag(), lllllllllllllIIIlllIlIIllllIIlII);
            return lllllllllllllIIIlllIlIIllllIIlII;
        }
        return lllllllllllllIIIlllIlIIllllIIIIl;
    }
    
    public Constructor() {
        this(Object.class);
    }
    
    public Constructor(final TypeDescription lllllllllllllIIIlllIlIlIIIIIIlll, final Collection<TypeDescription> lllllllllllllIIIlllIlIlIIIIIIllI, final LoaderOptions lllllllllllllIIIlllIlIlIIIIIIlIl) {
        super(lllllllllllllIIIlllIlIlIIIIIIlIl);
        if (lllllllllllllIIIlllIlIlIIIIIIlll == null) {
            throw new NullPointerException("Root type must be provided.");
        }
        this.yamlConstructors.put(null, new ConstructYamlObject());
        if (!Object.class.equals(lllllllllllllIIIlllIlIlIIIIIIlll.getType())) {
            this.rootTag = new Tag(lllllllllllllIIIlllIlIlIIIIIIlll.getType());
        }
        this.yamlClassConstructors.put(NodeId.scalar, new ConstructScalar());
        this.yamlClassConstructors.put(NodeId.mapping, new ConstructMapping());
        this.yamlClassConstructors.put(NodeId.sequence, new ConstructSequence());
        this.addTypeDescription(lllllllllllllIIIlllIlIlIIIIIIlll);
        if (lllllllllllllIIIlllIlIlIIIIIIllI != null) {
            for (final TypeDescription lllllllllllllIIIlllIlIlIIIIIlIlI : lllllllllllllIIIlllIlIlIIIIIIllI) {
                this.addTypeDescription(lllllllllllllIIIlllIlIlIIIIIlIlI);
            }
        }
    }
    
    public Constructor(final Class<?> lllllllllllllIIIlllIlIlIIIllIlll) {
        this(new TypeDescription(checkRoot(lllllllllllllIIIlllIlIlIIIllIlll)));
    }
    
    public Constructor(final LoaderOptions lllllllllllllIIIlllIlIlIIIllllIl) {
        this(Object.class, lllllllllllllIIIlllIlIlIIIllllIl);
    }
    
    public Constructor(final TypeDescription lllllllllllllIIIlllIlIlIIIIlIIlI, final Collection<TypeDescription> lllllllllllllIIIlllIlIlIIIIlIlII) {
        this(lllllllllllllIIIlllIlIlIIIIlIIlI, lllllllllllllIIIlllIlIlIIIIlIlII, new LoaderOptions());
    }
    
    protected class ConstructYamlObject implements Construct
    {
        @Override
        public Object construct(final Node llllllllllllllllllIllllIIIllIIll) {
            try {
                return this.getConstructor(llllllllllllllllllIllllIIIllIIll).construct(llllllllllllllllllIllllIIIllIIll);
            }
            catch (ConstructorException llllllllllllllllllIllllIIIllIllI) {
                throw llllllllllllllllllIllllIIIllIllI;
            }
            catch (Exception llllllllllllllllllIllllIIIllIlIl) {
                throw new ConstructorException(null, null, String.valueOf(new StringBuilder().append("Can't construct a java object for ").append(llllllllllllllllllIllllIIIllIIll.getTag()).append("; exception=").append(llllllllllllllllllIllllIIIllIlIl.getMessage())), llllllllllllllllllIllllIIIllIIll.getStartMark(), llllllllllllllllllIllllIIIllIlIl);
            }
        }
        
        @Override
        public void construct2ndStep(final Node llllllllllllllllllIllllIIIlIIllI, final Object llllllllllllllllllIllllIIIlIIlIl) {
            try {
                this.getConstructor(llllllllllllllllllIllllIIIlIIllI).construct2ndStep(llllllllllllllllllIllllIIIlIIllI, llllllllllllllllllIllllIIIlIIlIl);
            }
            catch (Exception llllllllllllllllllIllllIIIlIlIll) {
                throw new ConstructorException(null, null, String.valueOf(new StringBuilder().append("Can't construct a second step for a java object for ").append(llllllllllllllllllIllllIIIlIIllI.getTag()).append("; exception=").append(llllllllllllllllllIllllIIIlIlIll.getMessage())), llllllllllllllllllIllllIIIlIIllI.getStartMark(), llllllllllllllllllIllllIIIlIlIll);
            }
        }
        
        private Construct getConstructor(final Node llllllllllllllllllIllllIIIllllII) {
            final Class<?> llllllllllllllllllIllllIIIllllll = Constructor.this.getClassForNode(llllllllllllllllllIllllIIIllllII);
            llllllllllllllllllIllllIIIllllII.setType(llllllllllllllllllIllllIIIllllll);
            final Construct llllllllllllllllllIllllIIIlllllI = Constructor.this.yamlClassConstructors.get(llllllllllllllllllIllllIIIllllII.getNodeId());
            return llllllllllllllllllIllllIIIlllllI;
        }
    }
    
    protected class ConstructSequence implements Construct
    {
        private final Class<?> wrapIfPrimitive(final Class<?> llllllllllllllIIlllIllIllIllIIII) {
            if (!llllllllllllllIIlllIllIllIllIIII.isPrimitive()) {
                return llllllllllllllIIlllIllIllIllIIII;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Integer.TYPE) {
                return Integer.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Float.TYPE) {
                return Float.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Double.TYPE) {
                return Double.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Boolean.TYPE) {
                return Boolean.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Long.TYPE) {
                return Long.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Character.TYPE) {
                return Character.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Short.TYPE) {
                return Short.class;
            }
            if (llllllllllllllIIlllIllIllIllIIII == Byte.TYPE) {
                return Byte.class;
            }
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unexpected primitive ").append(llllllllllllllIIlllIllIllIllIIII)));
        }
        
        @Override
        public Object construct(final Node llllllllllllllIIlllIllIlllIIlIlI) {
            final SequenceNode llllllllllllllIIlllIllIlllIIllII = (SequenceNode)llllllllllllllIIlllIllIlllIIlIlI;
            if (Set.class.isAssignableFrom(llllllllllllllIIlllIllIlllIIlIlI.getType())) {
                if (llllllllllllllIIlllIllIlllIIlIlI.isTwoStepsConstruction()) {
                    throw new YAMLException("Set cannot be recursive.");
                }
                return Constructor.this.constructSet(llllllllllllllIIlllIllIlllIIllII);
            }
            else if (Collection.class.isAssignableFrom(llllllllllllllIIlllIllIlllIIlIlI.getType())) {
                if (llllllllllllllIIlllIllIlllIIlIlI.isTwoStepsConstruction()) {
                    return Constructor.this.newList(llllllllllllllIIlllIllIlllIIllII);
                }
                return Constructor.this.constructSequence(llllllllllllllIIlllIllIlllIIllII);
            }
            else {
                if (!llllllllllllllIIlllIllIlllIIlIlI.getType().isArray()) {
                    final List<java.lang.reflect.Constructor<?>> llllllllllllllIIlllIllIlllIlIIII = new ArrayList<java.lang.reflect.Constructor<?>>(llllllllllllllIIlllIllIlllIIllII.getValue().size());
                    for (final java.lang.reflect.Constructor<?> llllllllllllllIIlllIllIlllllllIl : llllllllllllllIIlllIllIlllIIlIlI.getType().getDeclaredConstructors()) {
                        if (llllllllllllllIIlllIllIlllIIllII.getValue().size() == llllllllllllllIIlllIllIlllllllIl.getParameterTypes().length) {
                            llllllllllllllIIlllIllIlllIlIIII.add(llllllllllllllIIlllIllIlllllllIl);
                        }
                    }
                    if (!llllllllllllllIIlllIllIlllIlIIII.isEmpty()) {
                        if (llllllllllllllIIlllIllIlllIlIIII.size() == 1) {
                            final Object[] llllllllllllllIIlllIllIllllIlllI = new Object[llllllllllllllIIlllIllIlllIIllII.getValue().size()];
                            final java.lang.reflect.Constructor<?> llllllllllllllIIlllIllIllllIllII = llllllllllllllIIlllIllIlllIlIIII.get(0);
                            int llllllllllllllIIlllIllIllllIlIlI = 0;
                            for (final Node llllllllllllllIIlllIllIlllllIlII : llllllllllllllIIlllIllIlllIIllII.getValue()) {
                                final Class<?> llllllllllllllIIlllIllIlllllIlIl = llllllllllllllIIlllIllIllllIllII.getParameterTypes()[llllllllllllllIIlllIllIllllIlIlI];
                                llllllllllllllIIlllIllIlllllIlII.setType(llllllllllllllIIlllIllIlllllIlIl);
                                llllllllllllllIIlllIllIllllIlllI[llllllllllllllIIlllIllIllllIlIlI++] = Constructor.this.constructObject(llllllllllllllIIlllIllIlllllIlII);
                            }
                            try {
                                llllllllllllllIIlllIllIllllIllII.setAccessible(true);
                                return llllllllllllllIIlllIllIllllIllII.newInstance(llllllllllllllIIlllIllIllllIlllI);
                            }
                            catch (Exception llllllllllllllIIlllIllIlllllIIII) {
                                throw new YAMLException(llllllllllllllIIlllIllIlllllIIII);
                            }
                        }
                        final List<Object> llllllllllllllIIlllIllIlllIlIllI = (List<Object>)Constructor.this.constructSequence(llllllllllllllIIlllIllIlllIIllII);
                        final Class<?>[] llllllllllllllIIlllIllIlllIlIlII = (Class<?>[])new Class[llllllllllllllIIlllIllIlllIlIllI.size()];
                        int llllllllllllllIIlllIllIlllIlIIlI = 0;
                        for (final Object llllllllllllllIIlllIllIllllIlIII : llllllllllllllIIlllIllIlllIlIllI) {
                            llllllllllllllIIlllIllIlllIlIlII[llllllllllllllIIlllIllIlllIlIIlI] = llllllllllllllIIlllIllIllllIlIII.getClass();
                            ++llllllllllllllIIlllIllIlllIlIIlI;
                        }
                        for (final java.lang.reflect.Constructor<?> llllllllllllllIIlllIllIlllIllIll : llllllllllllllIIlllIllIlllIlIIII) {
                            final Class<?>[] llllllllllllllIIlllIllIllllIIIII = llllllllllllllIIlllIllIlllIllIll.getParameterTypes();
                            boolean llllllllllllllIIlllIllIlllIlllIl = true;
                            for (int llllllllllllllIIlllIllIllllIIlII = 0; llllllllllllllIIlllIllIllllIIlII < llllllllllllllIIlllIllIllllIIIII.length; ++llllllllllllllIIlllIllIllllIIlII) {
                                if (!this.wrapIfPrimitive(llllllllllllllIIlllIllIllllIIIII[llllllllllllllIIlllIllIllllIIlII]).isAssignableFrom(llllllllllllllIIlllIllIlllIlIlII[llllllllllllllIIlllIllIllllIIlII])) {
                                    llllllllllllllIIlllIllIlllIlllIl = false;
                                    break;
                                }
                            }
                            if (llllllllllllllIIlllIllIlllIlllIl) {
                                try {
                                    llllllllllllllIIlllIllIlllIllIll.setAccessible(true);
                                    return llllllllllllllIIlllIllIlllIllIll.newInstance(llllllllllllllIIlllIllIlllIlIllI.toArray());
                                }
                                catch (Exception llllllllllllllIIlllIllIllllIIIlI) {
                                    throw new YAMLException(llllllllllllllIIlllIllIllllIIIlI);
                                }
                            }
                        }
                    }
                    throw new YAMLException(String.valueOf(new StringBuilder().append("No suitable constructor with ").append(String.valueOf(llllllllllllllIIlllIllIlllIIllII.getValue().size())).append(" arguments found for ").append(llllllllllllllIIlllIllIlllIIlIlI.getType())));
                }
                if (llllllllllllllIIlllIllIlllIIlIlI.isTwoStepsConstruction()) {
                    return Constructor.this.createArray(llllllllllllllIIlllIllIlllIIlIlI.getType(), llllllllllllllIIlllIllIlllIIllII.getValue().size());
                }
                return Constructor.this.constructArray(llllllllllllllIIlllIllIlllIIllII);
            }
        }
        
        @Override
        public void construct2ndStep(final Node llllllllllllllIIlllIllIllIlIIIlI, final Object llllllllllllllIIlllIllIllIlIIIII) {
            final SequenceNode llllllllllllllIIlllIllIllIIlllll = (SequenceNode)llllllllllllllIIlllIllIllIlIIIlI;
            if (List.class.isAssignableFrom(llllllllllllllIIlllIllIllIlIIIlI.getType())) {
                final List<Object> llllllllllllllIIlllIllIllIlIIlIl = (List<Object>)llllllllllllllIIlllIllIllIlIIIII;
                Constructor.this.constructSequenceStep2(llllllllllllllIIlllIllIllIIlllll, llllllllllllllIIlllIllIllIlIIlIl);
            }
            else {
                if (!llllllllllllllIIlllIllIllIlIIIlI.getType().isArray()) {
                    throw new YAMLException("Immutable objects cannot be recursive.");
                }
                Constructor.this.constructArrayStep2(llllllllllllllIIlllIllIllIIlllll, llllllllllllllIIlllIllIllIlIIIII);
            }
        }
    }
    
    protected class ConstructScalar extends AbstractConstruct
    {
        private Object constructStandardJavaInstance(final Class lllllllllllllllIIlIlIlIIllIllIll, final ScalarNode lllllllllllllllIIlIlIlIIllIlIIlI) {
            if (lllllllllllllllIIlIlIlIIllIllIll == String.class) {
                final Construct lllllllllllllllIIlIlIlIlIIIIllll = Constructor.this.yamlConstructors.get(Tag.STR);
                final Object lllllllllllllllIIlIlIlIlIIIIlllI = lllllllllllllllIIlIlIlIlIIIIllll.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
            }
            else if (lllllllllllllllIIlIlIlIIllIllIll == Boolean.class || lllllllllllllllIIlIlIlIIllIllIll == Boolean.TYPE) {
                final Construct lllllllllllllllIIlIlIlIlIIIIllIl = Constructor.this.yamlConstructors.get(Tag.BOOL);
                final Object lllllllllllllllIIlIlIlIlIIIIllII = lllllllllllllllIIlIlIlIlIIIIllIl.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
            }
            else if (lllllllllllllllIIlIlIlIIllIllIll == Character.class || lllllllllllllllIIlIlIlIIllIllIll == Character.TYPE) {
                final Construct lllllllllllllllIIlIlIlIlIIIIlIIl = Constructor.this.yamlConstructors.get(Tag.STR);
                final String lllllllllllllllIIlIlIlIlIIIIIlll = (String)lllllllllllllllIIlIlIlIlIIIIlIIl.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
                if (lllllllllllllllIIlIlIlIlIIIIIlll.length() == 0) {
                    final Object lllllllllllllllIIlIlIlIlIIIIlIll = null;
                }
                else {
                    if (lllllllllllllllIIlIlIlIlIIIIIlll.length() != 1) {
                        throw new YAMLException(String.valueOf(new StringBuilder().append("Invalid node Character: '").append(lllllllllllllllIIlIlIlIlIIIIIlll).append("'; length: ").append(lllllllllllllllIIlIlIlIlIIIIIlll.length())));
                    }
                    final Object lllllllllllllllIIlIlIlIlIIIIIlIl = lllllllllllllllIIlIlIlIlIIIIIlll.charAt(0);
                }
            }
            else if (Date.class.isAssignableFrom(lllllllllllllllIIlIlIlIIllIllIll)) {
                final Construct lllllllllllllllIIlIlIlIIlllllIll = Constructor.this.yamlConstructors.get(Tag.TIMESTAMP);
                final Date lllllllllllllllIIlIlIlIIlllllIIl = (Date)lllllllllllllllIIlIlIlIIlllllIll.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
                if (lllllllllllllllIIlIlIlIIllIllIll == Date.class) {
                    final Object lllllllllllllllIIlIlIlIlIIIIIIll = lllllllllllllllIIlIlIlIIlllllIIl;
                }
                else {
                    try {
                        final java.lang.reflect.Constructor<?> lllllllllllllllIIlIlIlIlIIIIIIIl = lllllllllllllllIIlIlIlIIllIllIll.getConstructor(Long.TYPE);
                        final Object lllllllllllllllIIlIlIlIIllllIlll = lllllllllllllllIIlIlIlIlIIIIIIIl.newInstance(lllllllllllllllIIlIlIlIIlllllIIl.getTime());
                    }
                    catch (RuntimeException lllllllllllllllIIlIlIlIIllllllll) {
                        throw lllllllllllllllIIlIlIlIIllllllll;
                    }
                    catch (Exception lllllllllllllllIIlIlIlIIllllllIl) {
                        throw new YAMLException(String.valueOf(new StringBuilder().append("Cannot construct: '").append(lllllllllllllllIIlIlIlIIllIllIll).append("'")));
                    }
                }
            }
            else if (lllllllllllllllIIlIlIlIIllIllIll == Float.class || lllllllllllllllIIlIlIlIIllIllIll == Double.class || lllllllllllllllIIlIlIlIIllIllIll == Float.TYPE || lllllllllllllllIIlIlIlIIllIllIll == Double.TYPE || lllllllllllllllIIlIlIlIIllIllIll == BigDecimal.class) {
                if (lllllllllllllllIIlIlIlIIllIllIll == BigDecimal.class) {
                    final Object lllllllllllllllIIlIlIlIIllllIlIl = new BigDecimal(lllllllllllllllIIlIlIlIIllIlIIlI.getValue());
                }
                else {
                    final Construct lllllllllllllllIIlIlIlIIllllIIll = Constructor.this.yamlConstructors.get(Tag.FLOAT);
                    Object lllllllllllllllIIlIlIlIIllllIIIl = lllllllllllllllIIlIlIlIIllllIIll.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
                    if (lllllllllllllllIIlIlIlIIllIllIll == Float.class || lllllllllllllllIIlIlIlIIllIllIll == Float.TYPE) {
                        lllllllllllllllIIlIlIlIIllllIIIl = ((Double)lllllllllllllllIIlIlIlIIllllIIIl).floatValue();
                    }
                }
            }
            else if (lllllllllllllllIIlIlIlIIllIllIll == Byte.class || lllllllllllllllIIlIlIlIIllIllIll == Short.class || lllllllllllllllIIlIlIlIIllIllIll == Integer.class || lllllllllllllllIIlIlIlIIllIllIll == Long.class || lllllllllllllllIIlIlIlIIllIllIll == BigInteger.class || lllllllllllllllIIlIlIlIIllIllIll == Byte.TYPE || lllllllllllllllIIlIlIlIIllIllIll == Short.TYPE || lllllllllllllllIIlIlIlIIllIllIll == Integer.TYPE || lllllllllllllllIIlIlIlIIllIllIll == Long.TYPE) {
                final Construct lllllllllllllllIIlIlIlIIlllIllll = Constructor.this.yamlConstructors.get(Tag.INT);
                Object lllllllllllllllIIlIlIlIIlllIllIl = lllllllllllllllIIlIlIlIIlllIllll.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
                if (lllllllllllllllIIlIlIlIIllIllIll == Byte.class || lllllllllllllllIIlIlIlIIllIllIll == Byte.TYPE) {
                    lllllllllllllllIIlIlIlIIlllIllIl = Integer.valueOf(lllllllllllllllIIlIlIlIIlllIllIl.toString()).byteValue();
                }
                else if (lllllllllllllllIIlIlIlIIllIllIll == Short.class || lllllllllllllllIIlIlIlIIllIllIll == Short.TYPE) {
                    lllllllllllllllIIlIlIlIIlllIllIl = Integer.valueOf(lllllllllllllllIIlIlIlIIlllIllIl.toString()).shortValue();
                }
                else if (lllllllllllllllIIlIlIlIIllIllIll == Integer.class || lllllllllllllllIIlIlIlIIllIllIll == Integer.TYPE) {
                    lllllllllllllllIIlIlIlIIlllIllIl = Integer.parseInt(lllllllllllllllIIlIlIlIIlllIllIl.toString());
                }
                else if (lllllllllllllllIIlIlIlIIllIllIll == Long.class || lllllllllllllllIIlIlIlIIllIllIll == Long.TYPE) {
                    lllllllllllllllIIlIlIlIIlllIllIl = Long.valueOf(lllllllllllllllIIlIlIlIIlllIllIl.toString());
                }
                else {
                    lllllllllllllllIIlIlIlIIlllIllIl = new BigInteger(lllllllllllllllIIlIlIlIIlllIllIl.toString());
                }
            }
            else if (Enum.class.isAssignableFrom(lllllllllllllllIIlIlIlIIllIllIll)) {
                final String lllllllllllllllIIlIlIlIIlllIlIIl = lllllllllllllllIIlIlIlIIllIlIIlI.getValue();
                try {
                    final Object lllllllllllllllIIlIlIlIIlllIIlll = Enum.valueOf((Class<Object>)lllllllllllllllIIlIlIlIIllIllIll, lllllllllllllllIIlIlIlIIlllIlIIl);
                }
                catch (Exception lllllllllllllllIIlIlIlIIlllIlIll) {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Unable to find enum value '").append(lllllllllllllllIIlIlIlIIlllIlIIl).append("' for enum class: ").append(lllllllllllllllIIlIlIlIIllIllIll.getName())));
                }
            }
            else if (Calendar.class.isAssignableFrom(lllllllllllllllIIlIlIlIIllIllIll)) {
                final ConstructYamlTimestamp lllllllllllllllIIlIlIlIIlllIIllI = new ConstructYamlTimestamp();
                lllllllllllllllIIlIlIlIIlllIIllI.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
                final Object lllllllllllllllIIlIlIlIIlllIIlIl = lllllllllllllllIIlIlIlIIlllIIllI.getCalendar();
            }
            else if (Number.class.isAssignableFrom(lllllllllllllllIIlIlIlIIllIllIll)) {
                final ConstructYamlFloat lllllllllllllllIIlIlIlIIlllIIlII = new ConstructYamlFloat();
                final Object lllllllllllllllIIlIlIlIIlllIIIll = lllllllllllllllIIlIlIlIIlllIIlII.construct(lllllllllllllllIIlIlIlIIllIlIIlI);
            }
            else if (UUID.class == lllllllllllllllIIlIlIlIIllIllIll) {
                final Object lllllllllllllllIIlIlIlIIlllIIIIl = UUID.fromString(lllllllllllllllIIlIlIlIIllIlIIlI.getValue());
            }
            else {
                if (!Constructor.this.yamlConstructors.containsKey(lllllllllllllllIIlIlIlIIllIlIIlI.getTag())) {
                    throw new YAMLException(String.valueOf(new StringBuilder().append("Unsupported class: ").append(lllllllllllllllIIlIlIlIIllIllIll)));
                }
                final Object lllllllllllllllIIlIlIlIIllIlllll = Constructor.this.yamlConstructors.get(lllllllllllllllIIlIlIlIIllIlIIlI.getTag()).construct(lllllllllllllllIIlIlIlIIllIlIIlI);
            }
            final Object lllllllllllllllIIlIlIlIIllIlIlll;
            return lllllllllllllllIIlIlIlIIllIlIlll;
        }
        
        @Override
        public Object construct(final Node lllllllllllllllIIlIlIlIlIlIlIlII) {
            final ScalarNode lllllllllllllllIIlIlIlIlIlIllIII = (ScalarNode)lllllllllllllllIIlIlIlIlIlIlIlII;
            final Class<?> lllllllllllllllIIlIlIlIlIlIlIlll = lllllllllllllllIIlIlIlIlIlIllIII.getType();
            try {
                return Constructor.this.newInstance(lllllllllllllllIIlIlIlIlIlIlIlll, lllllllllllllllIIlIlIlIlIlIllIII, false);
            }
            catch (InstantiationException lllllllllllllllIIlIlIlIlIllIlIII) {
                Object lllllllllllllllIIlIlIlIlIlIlIllI = null;
                if (lllllllllllllllIIlIlIlIlIlIlIlll.isPrimitive() || lllllllllllllllIIlIlIlIlIlIlIlll == String.class || Number.class.isAssignableFrom(lllllllllllllllIIlIlIlIlIlIlIlll) || lllllllllllllllIIlIlIlIlIlIlIlll == Boolean.class || Date.class.isAssignableFrom(lllllllllllllllIIlIlIlIlIlIlIlll) || lllllllllllllllIIlIlIlIlIlIlIlll == Character.class || lllllllllllllllIIlIlIlIlIlIlIlll == BigInteger.class || lllllllllllllllIIlIlIlIlIlIlIlll == BigDecimal.class || Enum.class.isAssignableFrom(lllllllllllllllIIlIlIlIlIlIlIlll) || Tag.BINARY.equals(lllllllllllllllIIlIlIlIlIlIllIII.getTag()) || Calendar.class.isAssignableFrom(lllllllllllllllIIlIlIlIlIlIlIlll) || lllllllllllllllIIlIlIlIlIlIlIlll == UUID.class) {
                    final Object lllllllllllllllIIlIlIlIlIllIIlll = this.constructStandardJavaInstance(lllllllllllllllIIlIlIlIlIlIlIlll, lllllllllllllllIIlIlIlIlIlIllIII);
                }
                else {
                    final java.lang.reflect.Constructor<?>[] lllllllllllllllIIlIlIlIlIlIllllI = lllllllllllllllIIlIlIlIlIlIlIlll.getDeclaredConstructors();
                    int lllllllllllllllIIlIlIlIlIlIlllIl = 0;
                    java.lang.reflect.Constructor<?> lllllllllllllllIIlIlIlIlIlIlllII = null;
                    for (final java.lang.reflect.Constructor<?> lllllllllllllllIIlIlIlIlIllIIllI : lllllllllllllllIIlIlIlIlIlIllllI) {
                        if (lllllllllllllllIIlIlIlIlIllIIllI.getParameterTypes().length == 1) {
                            ++lllllllllllllllIIlIlIlIlIlIlllIl;
                            lllllllllllllllIIlIlIlIlIlIlllII = lllllllllllllllIIlIlIlIlIllIIllI;
                        }
                    }
                    if (lllllllllllllllIIlIlIlIlIlIlllII == null) {
                        try {
                            return Constructor.this.newInstance(lllllllllllllllIIlIlIlIlIlIlIlll, lllllllllllllllIIlIlIlIlIlIllIII, false);
                        }
                        catch (InstantiationException lllllllllllllllIIlIlIlIlIllIIIlI) {
                            throw new YAMLException(String.valueOf(new StringBuilder().append("No single argument constructor found for ").append(lllllllllllllllIIlIlIlIlIlIlIlll).append(" : ").append(lllllllllllllllIIlIlIlIlIllIIIlI.getMessage())));
                        }
                    }
                    Object lllllllllllllllIIlIlIlIlIlIllIll = null;
                    if (lllllllllllllllIIlIlIlIlIlIlllIl == 1) {
                        final Object lllllllllllllllIIlIlIlIlIllIIIIl = this.constructStandardJavaInstance(lllllllllllllllIIlIlIlIlIlIlllII.getParameterTypes()[0], lllllllllllllllIIlIlIlIlIlIllIII);
                    }
                    else {
                        lllllllllllllllIIlIlIlIlIlIllIll = Constructor.this.constructScalar(lllllllllllllllIIlIlIlIlIlIllIII);
                        try {
                            lllllllllllllllIIlIlIlIlIlIlllII = lllllllllllllllIIlIlIlIlIlIlIlll.getDeclaredConstructor(String.class);
                        }
                        catch (Exception lllllllllllllllIIlIlIlIlIllIIIII) {
                            throw new YAMLException(String.valueOf(new StringBuilder().append("Can't construct a java object for scalar ").append(lllllllllllllllIIlIlIlIlIlIllIII.getTag()).append("; No String constructor found. Exception=").append(lllllllllllllllIIlIlIlIlIllIIIII.getMessage())), lllllllllllllllIIlIlIlIlIllIIIII);
                        }
                    }
                    try {
                        lllllllllllllllIIlIlIlIlIlIlllII.setAccessible(true);
                        lllllllllllllllIIlIlIlIlIlIlIllI = lllllllllllllllIIlIlIlIlIlIlllII.newInstance(lllllllllllllllIIlIlIlIlIlIllIll);
                    }
                    catch (Exception lllllllllllllllIIlIlIlIlIlIlllll) {
                        throw new ConstructorException(null, null, String.valueOf(new StringBuilder().append("Can't construct a java object for scalar ").append(lllllllllllllllIIlIlIlIlIlIllIII.getTag()).append("; exception=").append(lllllllllllllllIIlIlIlIlIlIlllll.getMessage())), lllllllllllllllIIlIlIlIlIlIllIII.getStartMark(), lllllllllllllllIIlIlIlIlIlIlllll);
                    }
                }
                return lllllllllllllllIIlIlIlIlIlIlIllI;
            }
        }
    }
    
    protected class ConstructMapping implements Construct
    {
        protected Object constructJavaBean2ndStep(final MappingNode llllllllllllllIlllIlIIIIlIlIllII, final Object llllllllllllllIlllIlIIIIlIlIIllI) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        org/yaml/snakeyaml/constructor/Constructor$ConstructMapping.this$0:Lorg/yaml/snakeyaml/constructor/Constructor;
            //     4: aload_1         /* llllllllllllllIlllIlIIIIlIlIIlll */
            //     5: invokevirtual   org/yaml/snakeyaml/constructor/Constructor.flattenMapping:(Lorg/yaml/snakeyaml/nodes/MappingNode;)V
            //     8: aload_1         /* llllllllllllllIlllIlIIIIlIlIIlll */
            //     9: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.getType:()Ljava/lang/Class;
            //    12: astore_3        /* llllllllllllllIlllIlIIIIlIlIlIlI */
            //    13: aload_1         /* llllllllllllllIlllIlIIIIlIlIIlll */
            //    14: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.getValue:()Ljava/util/List;
            //    17: astore          llllllllllllllIlllIlIIIIlIlIlIIl
            //    19: aload           llllllllllllllIlllIlIIIIlIlIlIIl
            //    21: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
            //    26: astore          llllllllllllllIlllIlIIIIlIlIlllI
            //    28: aload           llllllllllllllIlllIlIIIIlIlIlllI
            //    30: invokeinterface java/util/Iterator.hasNext:()Z
            //    35: ifeq            628
            //    38: aload           llllllllllllllIlllIlIIIIlIlIlllI
            //    40: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //    45: checkcast       Lorg/yaml/snakeyaml/nodes/NodeTuple;
            //    48: astore          llllllllllllllIlllIlIIIIlIlIllll
            //    50: aload           llllllllllllllIlllIlIIIIlIlIllll
            //    52: invokevirtual   org/yaml/snakeyaml/nodes/NodeTuple.getKeyNode:()Lorg/yaml/snakeyaml/nodes/Node;
            //    55: instanceof      Lorg/yaml/snakeyaml/nodes/ScalarNode;
            //    58: ifeq            74
            //    61: aload           llllllllllllllIlllIlIIIIlIlIllll
            //    63: invokevirtual   org/yaml/snakeyaml/nodes/NodeTuple.getKeyNode:()Lorg/yaml/snakeyaml/nodes/Node;
            //    66: checkcast       Lorg/yaml/snakeyaml/nodes/ScalarNode;
            //    69: astore          llllllllllllllIlllIlIIIIllIIIIIl
            //    71: goto            105
            //    74: new             Lorg/yaml/snakeyaml/error/YAMLException;
            //    77: dup            
            //    78: new             Ljava/lang/StringBuilder;
            //    81: dup            
            //    82: invokespecial   java/lang/StringBuilder.<init>:()V
            //    85: ldc             "Keys must be scalars but found: "
            //    87: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    90: aload           llllllllllllllIlllIlIIIIlIlIllll
            //    92: invokevirtual   org/yaml/snakeyaml/nodes/NodeTuple.getKeyNode:()Lorg/yaml/snakeyaml/nodes/Node;
            //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //    98: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   101: invokespecial   org/yaml/snakeyaml/error/YAMLException.<init>:(Ljava/lang/String;)V
            //   104: athrow         
            //   105: aload           llllllllllllllIlllIlIIIIlIlIllll
            //   107: invokevirtual   org/yaml/snakeyaml/nodes/NodeTuple.getValueNode:()Lorg/yaml/snakeyaml/nodes/Node;
            //   110: astore          llllllllllllllIlllIlIIIIlIllIIIl
            //   112: aload           llllllllllllllIlllIlIIIIlIllIIlI
            //   114: ldc             Ljava/lang/String;.class
            //   116: invokevirtual   org/yaml/snakeyaml/nodes/ScalarNode.setType:(Ljava/lang/Class;)V
            //   119: aload_0         /* llllllllllllllIlllIlIIIIlIlIllIl */
            //   120: getfield        org/yaml/snakeyaml/constructor/Constructor$ConstructMapping.this$0:Lorg/yaml/snakeyaml/constructor/Constructor;
            //   123: aload           llllllllllllllIlllIlIIIIlIllIIlI
            //   125: invokevirtual   org/yaml/snakeyaml/constructor/Constructor.constructObject:(Lorg/yaml/snakeyaml/nodes/Node;)Ljava/lang/Object;
            //   128: checkcast       Ljava/lang/String;
            //   131: astore          llllllllllllllIlllIlIIIIlIllIIII
            //   133: aload_0         /* llllllllllllllIlllIlIIIIlIlIllIl */
            //   134: getfield        org/yaml/snakeyaml/constructor/Constructor$ConstructMapping.this$0:Lorg/yaml/snakeyaml/constructor/Constructor;
            //   137: getfield        org/yaml/snakeyaml/constructor/Constructor.typeDefinitions:Ljava/util/Map;
            //   140: aload_3         /* llllllllllllllIlllIlIIIIlIlIlIlI */
            //   141: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //   146: checkcast       Lorg/yaml/snakeyaml/TypeDescription;
            //   149: astore          llllllllllllllIlllIlIIIIlIlllIII
            //   151: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   153: ifnonnull       166
            //   156: aload_0         /* llllllllllllllIlllIlIIIIlIlIllIl */
            //   157: aload_3         /* llllllllllllllIlllIlIIIIlIlIlIlI */
            //   158: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   160: invokevirtual   org/yaml/snakeyaml/constructor/Constructor$ConstructMapping.getProperty:(Ljava/lang/Class;Ljava/lang/String;)Lorg/yaml/snakeyaml/introspector/Property;
            //   163: goto            173
            //   166: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   168: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   170: invokevirtual   org/yaml/snakeyaml/TypeDescription.getProperty:(Ljava/lang/String;)Lorg/yaml/snakeyaml/introspector/Property;
            //   173: astore          llllllllllllllIlllIlIIIIlIllIlll
            //   175: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   177: invokevirtual   org/yaml/snakeyaml/introspector/Property.isWritable:()Z
            //   180: ifne            223
            //   183: new             Lorg/yaml/snakeyaml/error/YAMLException;
            //   186: dup            
            //   187: new             Ljava/lang/StringBuilder;
            //   190: dup            
            //   191: invokespecial   java/lang/StringBuilder.<init>:()V
            //   194: ldc             "No writable property '"
            //   196: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   199: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   201: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   204: ldc             "' on class: "
            //   206: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   209: aload_3         /* llllllllllllllIlllIlIIIIlIlIlIlI */
            //   210: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
            //   213: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   216: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   219: invokespecial   org/yaml/snakeyaml/error/YAMLException.<init>:(Ljava/lang/String;)V
            //   222: athrow         
            //   223: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   225: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   227: invokevirtual   org/yaml/snakeyaml/introspector/Property.getType:()Ljava/lang/Class;
            //   230: invokevirtual   org/yaml/snakeyaml/nodes/Node.setType:(Ljava/lang/Class;)V
            //   233: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   235: ifnull          250
            //   238: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   240: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   242: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   244: invokevirtual   org/yaml/snakeyaml/TypeDescription.setupPropertyType:(Ljava/lang/String;Lorg/yaml/snakeyaml/nodes/Node;)Z
            //   247: goto            251
            //   250: iconst_0       
            //   251: istore          llllllllllllllIlllIlIIIIlIllIllI
            //   253: iload           llllllllllllllIlllIlIIIIlIllIllI
            //   255: ifne            416
            //   258: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   260: invokevirtual   org/yaml/snakeyaml/nodes/Node.getNodeId:()Lorg/yaml/snakeyaml/nodes/NodeId;
            //   263: getstatic       org/yaml/snakeyaml/nodes/NodeId.scalar:Lorg/yaml/snakeyaml/nodes/NodeId;
            //   266: if_acmpeq       416
            //   269: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   271: invokevirtual   org/yaml/snakeyaml/introspector/Property.getActualTypeArguments:()[Ljava/lang/Class;
            //   274: astore          llllllllllllllIlllIlIIIIlIlllIIl
            //   276: aload           llllllllllllllIlllIlIIIIlIlllIIl
            //   278: ifnull          416
            //   281: aload           llllllllllllllIlllIlIIIIlIlllIIl
            //   283: arraylength    
            //   284: ifle            416
            //   287: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   289: invokevirtual   org/yaml/snakeyaml/nodes/Node.getNodeId:()Lorg/yaml/snakeyaml/nodes/NodeId;
            //   292: getstatic       org/yaml/snakeyaml/nodes/NodeId.sequence:Lorg/yaml/snakeyaml/nodes/NodeId;
            //   295: if_acmpne       321
            //   298: aload           llllllllllllllIlllIlIIIIlIlllIIl
            //   300: iconst_0       
            //   301: aaload         
            //   302: astore          llllllllllllllIlllIlIIIIllIIIIII
            //   304: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   306: checkcast       Lorg/yaml/snakeyaml/nodes/SequenceNode;
            //   309: astore          llllllllllllllIlllIlIIIIlIllllll
            //   311: aload           llllllllllllllIlllIlIIIIlIllllll
            //   313: aload           llllllllllllllIlllIlIIIIllIIIIII
            //   315: invokevirtual   org/yaml/snakeyaml/nodes/SequenceNode.setListType:(Ljava/lang/Class;)V
            //   318: goto            416
            //   321: ldc             Ljava/util/Set;.class
            //   323: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   325: invokevirtual   org/yaml/snakeyaml/nodes/Node.getType:()Ljava/lang/Class;
            //   328: invokevirtual   java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
            //   331: ifeq            366
            //   334: aload           llllllllllllllIlllIlIIIIlIlllIIl
            //   336: iconst_0       
            //   337: aaload         
            //   338: astore          llllllllllllllIlllIlIIIIlIlllllI
            //   340: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   342: checkcast       Lorg/yaml/snakeyaml/nodes/MappingNode;
            //   345: astore          llllllllllllllIlllIlIIIIlIllllIl
            //   347: aload           llllllllllllllIlllIlIIIIlIllllIl
            //   349: aload           llllllllllllllIlllIlIIIIlIlllllI
            //   351: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.setOnlyKeyType:(Ljava/lang/Class;)V
            //   354: aload           llllllllllllllIlllIlIIIIlIllllIl
            //   356: iconst_1       
            //   357: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
            //   360: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.setUseClassConstructor:(Ljava/lang/Boolean;)V
            //   363: goto            416
            //   366: ldc             Ljava/util/Map;.class
            //   368: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   370: invokevirtual   org/yaml/snakeyaml/nodes/Node.getType:()Ljava/lang/Class;
            //   373: invokevirtual   java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
            //   376: ifeq            416
            //   379: aload           llllllllllllllIlllIlIIIIlIlllIIl
            //   381: iconst_0       
            //   382: aaload         
            //   383: astore          llllllllllllllIlllIlIIIIlIllllII
            //   385: aload           llllllllllllllIlllIlIIIIlIlllIIl
            //   387: iconst_1       
            //   388: aaload         
            //   389: astore          llllllllllllllIlllIlIIIIlIlllIll
            //   391: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   393: checkcast       Lorg/yaml/snakeyaml/nodes/MappingNode;
            //   396: astore          llllllllllllllIlllIlIIIIlIlllIlI
            //   398: aload           llllllllllllllIlllIlIIIIlIlllIlI
            //   400: aload           llllllllllllllIlllIlIIIIlIllllII
            //   402: aload           llllllllllllllIlllIlIIIIlIlllIll
            //   404: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.setTypes:(Ljava/lang/Class;Ljava/lang/Class;)V
            //   407: aload           llllllllllllllIlllIlIIIIlIlllIlI
            //   409: iconst_1       
            //   410: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
            //   413: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.setUseClassConstructor:(Ljava/lang/Boolean;)V
            //   416: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   418: ifnull          434
            //   421: aload_0         /* llllllllllllllIlllIlIIIIlIlIllIl */
            //   422: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   424: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   426: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   428: invokespecial   org/yaml/snakeyaml/constructor/Constructor$ConstructMapping.newInstance:(Lorg/yaml/snakeyaml/TypeDescription;Ljava/lang/String;Lorg/yaml/snakeyaml/nodes/Node;)Ljava/lang/Object;
            //   431: goto            443
            //   434: aload_0         /* llllllllllllllIlllIlIIIIlIlIllIl */
            //   435: getfield        org/yaml/snakeyaml/constructor/Constructor$ConstructMapping.this$0:Lorg/yaml/snakeyaml/constructor/Constructor;
            //   438: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   440: invokevirtual   org/yaml/snakeyaml/constructor/Constructor.constructObject:(Lorg/yaml/snakeyaml/nodes/Node;)Ljava/lang/Object;
            //   443: astore          llllllllllllllIlllIlIIIIlIllIlIl
            //   445: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   447: invokevirtual   org/yaml/snakeyaml/introspector/Property.getType:()Ljava/lang/Class;
            //   450: getstatic       java/lang/Float.TYPE:Ljava/lang/Class;
            //   453: if_acmpeq       466
            //   456: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   458: invokevirtual   org/yaml/snakeyaml/introspector/Property.getType:()Ljava/lang/Class;
            //   461: ldc             Ljava/lang/Float;.class
            //   463: if_acmpne       487
            //   466: aload           llllllllllllllIlllIlIIIIlIllIlIl
            //   468: instanceof      Ljava/lang/Double;
            //   471: ifeq            487
            //   474: aload           llllllllllllllIlllIlIIIIlIllIlIl
            //   476: checkcast       Ljava/lang/Double;
            //   479: invokevirtual   java/lang/Double.floatValue:()F
            //   482: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
            //   485: astore          llllllllllllllIlllIlIIIIlIllIlIl
            //   487: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   489: invokevirtual   org/yaml/snakeyaml/introspector/Property.getType:()Ljava/lang/Class;
            //   492: ldc             Ljava/lang/String;.class
            //   494: if_acmpne       536
            //   497: getstatic       org/yaml/snakeyaml/nodes/Tag.BINARY:Lorg/yaml/snakeyaml/nodes/Tag;
            //   500: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   502: invokevirtual   org/yaml/snakeyaml/nodes/Node.getTag:()Lorg/yaml/snakeyaml/nodes/Tag;
            //   505: invokevirtual   org/yaml/snakeyaml/nodes/Tag.equals:(Ljava/lang/Object;)Z
            //   508: ifeq            536
            //   511: aload           llllllllllllllIlllIlIIIIlIllIlIl
            //   513: instanceof      [B
            //   516: ifeq            536
            //   519: new             Ljava/lang/String;
            //   522: dup            
            //   523: aload           llllllllllllllIlllIlIIIIlIllIlIl
            //   525: checkcast       [B
            //   528: checkcast       [B
            //   531: invokespecial   java/lang/String.<init>:([B)V
            //   534: astore          llllllllllllllIlllIlIIIIlIllIlIl
            //   536: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   538: ifnull          554
            //   541: aload           llllllllllllllIlllIlIIIIlIlllIII
            //   543: aload_2         /* llllllllllllllIlllIlIIIIlIlIlIll */
            //   544: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   546: aload           llllllllllllllIlllIlIIIIlIllIlIl
            //   548: invokevirtual   org/yaml/snakeyaml/TypeDescription.setProperty:(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
            //   551: ifne            562
            //   554: aload           llllllllllllllIlllIlIIIIlIllIlll
            //   556: aload_2         /* llllllllllllllIlllIlIIIIlIlIlIll */
            //   557: aload           llllllllllllllIlllIlIIIIlIllIlIl
            //   559: invokevirtual   org/yaml/snakeyaml/introspector/Property.set:(Ljava/lang/Object;Ljava/lang/Object;)V
            //   562: goto            625
            //   565: astore          llllllllllllllIlllIlIIIIlIllIlII
            //   567: aload           llllllllllllllIlllIlIIIIlIllIlII
            //   569: athrow         
            //   570: astore          llllllllllllllIlllIlIIIIlIllIIll
            //   572: new             Lorg/yaml/snakeyaml/constructor/ConstructorException;
            //   575: dup            
            //   576: new             Ljava/lang/StringBuilder;
            //   579: dup            
            //   580: invokespecial   java/lang/StringBuilder.<init>:()V
            //   583: ldc             "Cannot create property="
            //   585: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   588: aload           llllllllllllllIlllIlIIIIlIllIIII
            //   590: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   593: ldc             " for JavaBean="
            //   595: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   598: aload_2         /* llllllllllllllIlllIlIIIIlIlIlIll */
            //   599: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   602: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
            //   605: aload_1         /* llllllllllllllIlllIlIIIIlIlIIlll */
            //   606: invokevirtual   org/yaml/snakeyaml/nodes/MappingNode.getStartMark:()Lorg/yaml/snakeyaml/error/Mark;
            //   609: aload           llllllllllllllIlllIlIIIIlIllIIll
            //   611: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
            //   614: aload           llllllllllllllIlllIlIIIIlIllIIIl
            //   616: invokevirtual   org/yaml/snakeyaml/nodes/Node.getStartMark:()Lorg/yaml/snakeyaml/error/Mark;
            //   619: aload           llllllllllllllIlllIlIIIIlIllIIll
            //   621: invokespecial   org/yaml/snakeyaml/constructor/ConstructorException.<init>:(Ljava/lang/String;Lorg/yaml/snakeyaml/error/Mark;Ljava/lang/String;Lorg/yaml/snakeyaml/error/Mark;Ljava/lang/Throwable;)V
            //   624: athrow         
            //   625: goto            28
            //   628: aload_2         /* llllllllllllllIlllIlIIIIlIlIlIll */
            //   629: areturn        
            //    StackMapTable: 00 16 FE 00 1C 07 00 84 07 00 2E 07 00 34 FC 00 2D 07 00 3E FC 00 1E 07 00 44 FE 00 3C 07 00 8B 07 00 54 07 00 72 46 07 00 7B FC 00 31 07 00 7B 1A 40 01 FD 00 45 01 07 01 3E 2C FA 00 31 11 48 07 00 04 FC 00 16 07 00 04 14 30 11 07 FF 00 02 00 0A 07 00 02 07 00 24 07 00 04 07 00 84 07 00 2E 07 00 34 07 00 3E 07 00 44 07 00 8B 07 00 54 00 01 07 00 1C 44 07 00 1E FF 00 36 00 0E 07 00 02 07 00 24 07 00 04 07 00 84 07 00 2E 07 00 34 07 00 3E 07 00 44 07 00 8B 07 00 54 07 00 72 07 00 7B 01 07 00 04 00 00 FF 00 02 00 06 07 00 02 07 00 24 07 00 04 07 00 84 07 00 2E 07 00 34 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                                  
            //  -----  -----  -----  -----  ------------------------------------------------------
            //  133    562    565    570    Lorg/yaml/snakeyaml/constructor/DuplicateKeyException;
            //  133    562    570    625    Ljava/lang/Exception;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public Object construct(final Node llllllllllllllIlllIlIIIIlllIIIIl) {
            final MappingNode llllllllllllllIlllIlIIIIlllIIIII = (MappingNode)llllllllllllllIlllIlIIIIlllIIIIl;
            if (Map.class.isAssignableFrom(llllllllllllllIlllIlIIIIlllIIIIl.getType())) {
                if (llllllllllllllIlllIlIIIIlllIIIIl.isTwoStepsConstruction()) {
                    return Constructor.this.newMap(llllllllllllllIlllIlIIIIlllIIIII);
                }
                return Constructor.this.constructMapping(llllllllllllllIlllIlIIIIlllIIIII);
            }
            else if (Collection.class.isAssignableFrom(llllllllllllllIlllIlIIIIlllIIIIl.getType())) {
                if (llllllllllllllIlllIlIIIIlllIIIIl.isTwoStepsConstruction()) {
                    return Constructor.this.newSet(llllllllllllllIlllIlIIIIlllIIIII);
                }
                return Constructor.this.constructSet(llllllllllllllIlllIlIIIIlllIIIII);
            }
            else {
                final Object llllllllllllllIlllIlIIIIlllIIIll = Constructor.this.newInstance(llllllllllllllIlllIlIIIIlllIIIII);
                if (llllllllllllllIlllIlIIIIlllIIIIl.isTwoStepsConstruction()) {
                    return llllllllllllllIlllIlIIIIlllIIIll;
                }
                return this.constructJavaBean2ndStep(llllllllllllllIlllIlIIIIlllIIIII, llllllllllllllIlllIlIIIIlllIIIll);
            }
        }
        
        @Override
        public void construct2ndStep(final Node llllllllllllllIlllIlIIIIllIlIlll, final Object llllllllllllllIlllIlIIIIllIlIIll) {
            if (Map.class.isAssignableFrom(llllllllllllllIlllIlIIIIllIlIlll.getType())) {
                Constructor.this.constructMapping2ndStep((MappingNode)llllllllllllllIlllIlIIIIllIlIlll, (Map<Object, Object>)llllllllllllllIlllIlIIIIllIlIIll);
            }
            else if (Set.class.isAssignableFrom(llllllllllllllIlllIlIIIIllIlIlll.getType())) {
                Constructor.this.constructSet2ndStep((MappingNode)llllllllllllllIlllIlIIIIllIlIlll, (Set<Object>)llllllllllllllIlllIlIIIIllIlIIll);
            }
            else {
                this.constructJavaBean2ndStep((MappingNode)llllllllllllllIlllIlIIIIllIlIlll, llllllllllllllIlllIlIIIIllIlIIll);
            }
        }
        
        private Object newInstance(final TypeDescription llllllllllllllIlllIlIIIIlIIIllII, final String llllllllllllllIlllIlIIIIlIIlIIII, final Node llllllllllllllIlllIlIIIIlIIIllll) {
            final Object llllllllllllllIlllIlIIIIlIIIlllI = llllllllllllllIlllIlIIIIlIIIllII.newInstance(llllllllllllllIlllIlIIIIlIIlIIII, llllllllllllllIlllIlIIIIlIIIllll);
            if (llllllllllllllIlllIlIIIIlIIIlllI != null) {
                Constructor.this.constructedObjects.put(llllllllllllllIlllIlIIIIlIIIllll, llllllllllllllIlllIlIIIIlIIIlllI);
                return Constructor.this.constructObjectNoCheck(llllllllllllllIlllIlIIIIlIIIllll);
            }
            return Constructor.this.constructObject(llllllllllllllIlllIlIIIIlIIIllll);
        }
        
        protected Property getProperty(final Class<?> llllllllllllllIlllIlIIIIlIIIIlII, final String llllllllllllllIlllIlIIIIlIIIIIll) {
            return Constructor.this.getPropertyUtils().getProperty(llllllllllllllIlllIlIIIIlIIIIlII, llllllllllllllIlllIlIIIIlIIIIIll);
        }
    }
}
