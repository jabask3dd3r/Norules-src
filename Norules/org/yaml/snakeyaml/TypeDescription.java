package org.yaml.snakeyaml;

import java.util.logging.*;
import org.yaml.snakeyaml.introspector.*;
import org.yaml.snakeyaml.nodes.*;
import org.yaml.snakeyaml.error.*;
import java.util.*;
import java.lang.reflect.*;

public class TypeDescription
{
    private /* synthetic */ Map<String, PropertySubstitute> properties;
    private final /* synthetic */ Class<?> type;
    protected /* synthetic */ String[] includes;
    protected /* synthetic */ Set<String> excludes;
    private static final /* synthetic */ Logger log;
    private transient /* synthetic */ Set<Property> dumpProperties;
    private /* synthetic */ Tag tag;
    protected /* synthetic */ BeanAccess beanAccess;
    private transient /* synthetic */ boolean delegatesChecked;
    private transient /* synthetic */ PropertyUtils propertyUtils;
    private /* synthetic */ Class<?> impl;
    
    public boolean setupPropertyType(final String lllllllllllllIllIlllllIIllllIlIl, final Node lllllllllllllIllIlllllIIllllIlII) {
        return false;
    }
    
    public void substituteProperty(final String lllllllllllllIllIlllllIlIIllIlIl, final Class<?> lllllllllllllIllIlllllIlIIlllIlI, final String lllllllllllllIllIlllllIlIIllIIll, final String lllllllllllllIllIlllllIlIIlllIII, final Class<?>... lllllllllllllIllIlllllIlIIllIlll) {
        this.substituteProperty(new PropertySubstitute(lllllllllllllIllIlllllIlIIllIlIl, lllllllllllllIllIlllllIlIIlllIlI, lllllllllllllIllIlllllIlIIllIIll, lllllllllllllIllIlllllIlIIlllIII, lllllllllllllIllIlllllIlIIllIlll));
    }
    
    public void setIncludes(final String... lllllllllllllIllIlllllIlIIIlllll) {
        this.includes = (String[])((lllllllllllllIllIlllllIlIIIlllll != null && lllllllllllllIllIlllllIlIIIlllll.length > 0) ? lllllllllllllIllIlllllIlIIIlllll : null);
    }
    
    public TypeDescription(final Class<?> lllllllllllllIllIlllllIllIlllIII) {
        this(lllllllllllllIllIlllllIllIlllIII, null, null);
    }
    
    public void setPropertyUtils(final PropertyUtils lllllllllllllIllIlllllIlIIlIIlll) {
        this.propertyUtils = lllllllllllllIllIlllllIlIIlIIlll;
    }
    
    @Deprecated
    public void putListPropertyType(final String lllllllllllllIllIlllllIllIIllIII, final Class<?> lllllllllllllIllIlllllIllIIlIlll) {
        this.addPropertyParameters(lllllllllllllIllIlllllIllIIllIII, lllllllllllllIllIlllllIllIIlIlll);
    }
    
    public Property getProperty(final String lllllllllllllIllIlllllIlIlIIIIll) {
        if (!this.delegatesChecked) {
            this.checkDelegates();
        }
        return this.properties.containsKey(lllllllllllllIllIlllllIlIlIIIIll) ? ((PropertySubstitute)this.properties.get(lllllllllllllIllIlllllIlIlIIIIll)) : this.discoverProperty(lllllllllllllIllIlllllIlIlIIIIll);
    }
    
    public void substituteProperty(final PropertySubstitute lllllllllllllIllIlllllIlIIlIllIl) {
        if (Collections.EMPTY_MAP == this.properties) {
            this.properties = new LinkedHashMap<String, PropertySubstitute>();
        }
        lllllllllllllIllIlllllIlIIlIllIl.setTargetType(this.type);
        this.properties.put(lllllllllllllIllIlllllIlIIlIllIl.getName(), lllllllllllllIllIlllllIlIIlIllIl);
    }
    
    @Deprecated
    public Class<?> getMapKeyType(final String lllllllllllllIllIlllllIlIlllIlll) {
        if (this.properties.containsKey(lllllllllllllIllIlllllIlIlllIlll)) {
            final Class<?>[] lllllllllllllIllIlllllIlIllllIll = this.properties.get(lllllllllllllIllIlllllIlIlllIlll).getActualTypeArguments();
            if (lllllllllllllIllIlllllIlIllllIll != null && lllllllllllllIllIlllllIlIllllIll.length > 0) {
                return lllllllllllllIllIlllllIlIllllIll[0];
            }
        }
        return null;
    }
    
    @Deprecated
    public void putMapPropertyType(final String lllllllllllllIllIlllllIllIIIIIIl, final Class<?> lllllllllllllIllIlllllIllIIIIlII, final Class<?> lllllllllllllIllIlllllIlIlllllll) {
        this.addPropertyParameters(lllllllllllllIllIlllllIllIIIIIIl, lllllllllllllIllIlllllIllIIIIlII, lllllllllllllIllIlllllIlIlllllll);
    }
    
    @Deprecated
    public void setTag(final String lllllllllllllIllIlllllIllIlIIIlI) {
        this.setTag(new Tag(lllllllllllllIllIlllllIllIlIIIlI));
    }
    
    private void checkDelegates() {
        final Collection<PropertySubstitute> lllllllllllllIllIlllllIlIlIlIlII = this.properties.values();
        for (final PropertySubstitute lllllllllllllIllIlllllIlIlIlIlll : lllllllllllllIllIlllllIlIlIlIlII) {
            try {
                lllllllllllllIllIlllllIlIlIlIlll.setDelegate(this.discoverProperty(lllllllllllllIllIlllllIlIlIlIlll.getName()));
            }
            catch (YAMLException ex) {}
        }
        this.delegatesChecked = true;
    }
    
    public Set<Property> getProperties() {
        if (this.dumpProperties != null) {
            return this.dumpProperties;
        }
        if (this.propertyUtils == null) {
            return null;
        }
        if (this.includes != null) {
            this.dumpProperties = new LinkedHashSet<Property>();
            for (final String lllllllllllllIllIlllllIlIIIIIlll : this.includes) {
                if (!this.excludes.contains(lllllllllllllIllIlllllIlIIIIIlll)) {
                    this.dumpProperties.add(this.getProperty(lllllllllllllIllIlllllIlIIIIIlll));
                }
            }
            return this.dumpProperties;
        }
        final Set<Property> lllllllllllllIllIlllllIIllllllIl = (this.beanAccess == null) ? this.propertyUtils.getProperties(this.type) : this.propertyUtils.getProperties(this.type, this.beanAccess);
        if (!this.properties.isEmpty()) {
            if (!this.delegatesChecked) {
                this.checkDelegates();
            }
            this.dumpProperties = new LinkedHashSet<Property>();
            for (final Property lllllllllllllIllIlllllIlIIIIIIIl : this.properties.values()) {
                if (!this.excludes.contains(lllllllllllllIllIlllllIlIIIIIIIl.getName()) && lllllllllllllIllIlllllIlIIIIIIIl.isReadable()) {
                    this.dumpProperties.add(lllllllllllllIllIlllllIlIIIIIIIl);
                }
            }
            for (final Property lllllllllllllIllIlllllIIllllllll : lllllllllllllIllIlllllIIllllllIl) {
                if (!this.excludes.contains(lllllllllllllIllIlllllIIllllllll.getName())) {
                    this.dumpProperties.add(lllllllllllllIllIlllllIIllllllll);
                }
            }
            return this.dumpProperties;
        }
        if (this.excludes.isEmpty()) {
            final Set<Property> dumpProperties = lllllllllllllIllIlllllIIllllllIl;
            this.dumpProperties = dumpProperties;
            return dumpProperties;
        }
        this.dumpProperties = new LinkedHashSet<Property>();
        for (final Property lllllllllllllIllIlllllIlIIIIIIll : lllllllllllllIllIlllllIIllllllIl) {
            if (!this.excludes.contains(lllllllllllllIllIlllllIlIIIIIIll.getName())) {
                this.dumpProperties.add(lllllllllllllIllIlllllIlIIIIIIll);
            }
        }
        return this.dumpProperties;
    }
    
    public Object newInstance(final String lllllllllllllIllIlllllIIlllIIllI, final Node lllllllllllllIllIlllllIIlllIIlIl) {
        return null;
    }
    
    public void setExcludes(final String... lllllllllllllIllIlllllIlIIIlIIll) {
        if (lllllllllllllIllIlllllIlIIIlIIll != null && lllllllllllllIllIlllllIlIIIlIIll.length > 0) {
            this.excludes = new HashSet<String>();
            for (final String lllllllllllllIllIlllllIlIIIllIII : lllllllllllllIllIlllllIlIIIlIIll) {
                this.excludes.add(lllllllllllllIllIlllllIlIIIllIII);
            }
        }
        else {
            this.excludes = Collections.emptySet();
        }
    }
    
    @Deprecated
    public void setTag(final Tag lllllllllllllIllIlllllIllIlIIllI) {
        this.tag = lllllllllllllIllIlllllIllIlIIllI;
    }
    
    public TypeDescription(final Class<?> lllllllllllllIllIlllllIlllIIlIIl, final Tag lllllllllllllIllIlllllIlllIIlIII, final Class<?> lllllllllllllIllIlllllIlllIIIlll) {
        this.properties = Collections.emptyMap();
        this.excludes = Collections.emptySet();
        this.includes = null;
        this.type = lllllllllllllIllIlllllIlllIIlIIl;
        this.tag = lllllllllllllIllIlllllIlllIIlIII;
        this.impl = lllllllllllllIllIlllllIlllIIIlll;
        this.beanAccess = null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("TypeDescription for ").append(this.getType()).append(" (tag='").append(this.getTag()).append("')"));
    }
    
    public Tag getTag() {
        return this.tag;
    }
    
    @Deprecated
    public Class<?> getMapValueType(final String lllllllllllllIllIlllllIlIlllIIII) {
        if (this.properties.containsKey(lllllllllllllIllIlllllIlIlllIIII)) {
            final Class<?>[] lllllllllllllIllIlllllIlIlllIIlI = this.properties.get(lllllllllllllIllIlllllIlIlllIIII).getActualTypeArguments();
            if (lllllllllllllIllIlllllIlIlllIIlI != null && lllllllllllllIllIlllllIlIlllIIlI.length > 1) {
                return lllllllllllllIllIlllllIlIlllIIlI[1];
            }
        }
        return null;
    }
    
    @Deprecated
    public Class<?> getListPropertyType(final String lllllllllllllIllIlllllIllIIIlllI) {
        if (this.properties.containsKey(lllllllllllllIllIlllllIllIIIlllI)) {
            final Class<?>[] lllllllllllllIllIlllllIllIIlIIII = this.properties.get(lllllllllllllIllIlllllIllIIIlllI).getActualTypeArguments();
            if (lllllllllllllIllIlllllIllIIlIIII != null && lllllllllllllIllIlllllIllIIlIIII.length > 0) {
                return lllllllllllllIllIlllllIllIIlIIII[0];
            }
        }
        return null;
    }
    
    public TypeDescription(final Class<?> lllllllllllllIllIlllllIlllIlIlII, final Tag lllllllllllllIllIlllllIlllIlIIll) {
        this(lllllllllllllIllIlllllIlllIlIlII, lllllllllllllIllIlllllIlllIlIIll, null);
    }
    
    public Class<?> getType() {
        return this.type;
    }
    
    public boolean setProperty(final Object lllllllllllllIllIlllllIIllllIIlI, final String lllllllllllllIllIlllllIIllllIIIl, final Object lllllllllllllIllIlllllIIllllIIII) throws Exception {
        return false;
    }
    
    public Object newInstance(final Node lllllllllllllIllIlllllIIlllIlIlI) {
        if (this.impl != null) {
            try {
                final Constructor<?> lllllllllllllIllIlllllIIlllIllIl = this.impl.getDeclaredConstructor((Class<?>[])new Class[0]);
                lllllllllllllIllIlllllIIlllIllIl.setAccessible(true);
                return lllllllllllllIllIlllllIIlllIllIl.newInstance(new Object[0]);
            }
            catch (Exception lllllllllllllIllIlllllIIlllIllII) {
                TypeDescription.log.fine(lllllllllllllIllIlllllIIlllIllII.getLocalizedMessage());
                this.impl = null;
            }
        }
        return null;
    }
    
    public TypeDescription(final Class<?> lllllllllllllIllIlllllIllIllIIII, final Class<?> lllllllllllllIllIlllllIllIllIIlI) {
        this(lllllllllllllIllIlllllIllIllIIII, null, lllllllllllllIllIlllllIllIllIIlI);
    }
    
    public TypeDescription(final Class<?> lllllllllllllIllIlllllIlllIIIIlI, final String lllllllllllllIllIlllllIllIlllllI) {
        this(lllllllllllllIllIlllllIlllIIIIlI, new Tag(lllllllllllllIllIlllllIllIlllllI), null);
    }
    
    public void addPropertyParameters(final String lllllllllllllIllIlllllIlIllIIllI, final Class<?>... lllllllllllllIllIlllllIlIllIIIlI) {
        if (!this.properties.containsKey(lllllllllllllIllIlllllIlIllIIllI)) {
            this.substituteProperty(lllllllllllllIllIlllllIlIllIIllI, null, null, null, lllllllllllllIllIlllllIlIllIIIlI);
        }
        else {
            final PropertySubstitute lllllllllllllIllIlllllIlIllIlIII = this.properties.get(lllllllllllllIllIlllllIlIllIIllI);
            lllllllllllllIllIlllllIlIllIlIII.setActualTypeArguments(lllllllllllllIllIlllllIlIllIIIlI);
        }
    }
    
    private Property discoverProperty(final String lllllllllllllIllIlllllIlIlIIlIIl) {
        if (this.propertyUtils == null) {
            return null;
        }
        if (this.beanAccess == null) {
            return this.propertyUtils.getProperty(this.type, lllllllllllllIllIlllllIlIlIIlIIl);
        }
        return this.propertyUtils.getProperty(this.type, lllllllllllllIllIlllllIlIlIIlIIl, this.beanAccess);
    }
    
    public Object finalizeConstruction(final Object lllllllllllllIllIlllllIIlllIIIlI) {
        return lllllllllllllIllIlllllIIlllIIIlI;
    }
    
    static {
        log = Logger.getLogger(TypeDescription.class.getPackage().getName());
    }
}
