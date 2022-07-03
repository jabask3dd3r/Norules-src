package org.yaml.snakeyaml.introspector;

import org.yaml.snakeyaml.util.*;
import org.yaml.snakeyaml.error.*;
import java.beans.*;
import java.lang.reflect.*;
import java.util.*;

public class PropertyUtils
{
    private final /* synthetic */ Map<Class<?>, Set<Property>> readableProperties;
    private /* synthetic */ boolean skipMissingProperties;
    private /* synthetic */ boolean allowReadOnlyProperties;
    private /* synthetic */ BeanAccess beanAccess;
    private final /* synthetic */ Map<Class<?>, Map<String, Property>> propertiesCache;
    private /* synthetic */ PlatformFeatureDetector platformFeatureDetector;
    
    public Set<Property> getProperties(final Class<?> lllllllllllllllIIIIIlIIlIIIllllI) {
        return this.getProperties(lllllllllllllllIIIIIlIIlIIIllllI, this.beanAccess);
    }
    
    public boolean isSkipMissingProperties() {
        return this.skipMissingProperties;
    }
    
    public void setSkipMissingProperties(final boolean lllllllllllllllIIIIIlIIIllIIllIl) {
        if (this.skipMissingProperties != lllllllllllllllIIIIIlIIIllIIllIl) {
            this.skipMissingProperties = lllllllllllllllIIIIIlIIIllIIllIl;
            this.readableProperties.clear();
        }
    }
    
    public PropertyUtils() {
        this(new PlatformFeatureDetector());
    }
    
    public Property getProperty(final Class<?> lllllllllllllllIIIIIlIIIlllIlIlI, final String lllllllllllllllIIIIIlIIIlllIIIll, final BeanAccess lllllllllllllllIIIIIlIIIlllIlIII) {
        final Map<String, Property> lllllllllllllllIIIIIlIIIlllIIlll = this.getPropertiesMap(lllllllllllllllIIIIIlIIIlllIlIlI, lllllllllllllllIIIIIlIIIlllIlIII);
        Property lllllllllllllllIIIIIlIIIlllIIllI = lllllllllllllllIIIIIlIIIlllIIlll.get(lllllllllllllllIIIIIlIIIlllIIIll);
        if (lllllllllllllllIIIIIlIIIlllIIllI == null && this.skipMissingProperties) {
            lllllllllllllllIIIIIlIIIlllIIllI = new MissingProperty(lllllllllllllllIIIIIlIIIlllIIIll);
        }
        if (lllllllllllllllIIIIIlIIIlllIIllI == null) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unable to find property '").append(lllllllllllllllIIIIIlIIIlllIIIll).append("' on class: ").append(lllllllllllllllIIIIIlIIIlllIlIlI.getName())));
        }
        return lllllllllllllllIIIIIlIIIlllIIllI;
    }
    
    public void setAllowReadOnlyProperties(final boolean lllllllllllllllIIIIIlIIIllIlIllI) {
        if (this.allowReadOnlyProperties != lllllllllllllllIIIIIlIIIllIlIllI) {
            this.allowReadOnlyProperties = lllllllllllllllIIIIIlIIIllIlIllI;
            this.readableProperties.clear();
        }
    }
    
    protected Map<String, Property> getPropertiesMap(final Class<?> lllllllllllllllIIIIIlIIlIIllIlII, final BeanAccess lllllllllllllllIIIIIlIIlIIllIIll) {
        if (this.propertiesCache.containsKey(lllllllllllllllIIIIIlIIlIIllIlII)) {
            return this.propertiesCache.get(lllllllllllllllIIIIIlIIlIIllIlII);
        }
        final Map<String, Property> lllllllllllllllIIIIIlIIlIIllIIlI = new LinkedHashMap<String, Property>();
        boolean lllllllllllllllIIIIIlIIlIIllIIIl = false;
        switch (lllllllllllllllIIIIIlIIlIIllIIll) {
            case FIELD: {
                for (Class<?> lllllllllllllllIIIIIlIIlIlIIIIlI = lllllllllllllllIIIIIlIIlIIllIlII; lllllllllllllllIIIIIlIIlIlIIIIlI != null; lllllllllllllllIIIIIlIIlIlIIIIlI = lllllllllllllllIIIIIlIIlIlIIIIlI.getSuperclass()) {
                    for (final Field lllllllllllllllIIIIIlIIlIlIIIllI : lllllllllllllllIIIIIlIIlIlIIIIlI.getDeclaredFields()) {
                        final int lllllllllllllllIIIIIlIIlIlIIIlll = lllllllllllllllIIIIIlIIlIlIIIllI.getModifiers();
                        if (!Modifier.isStatic(lllllllllllllllIIIIIlIIlIlIIIlll) && !Modifier.isTransient(lllllllllllllllIIIIIlIIlIlIIIlll) && !lllllllllllllllIIIIIlIIlIIllIIlI.containsKey(lllllllllllllllIIIIIlIIlIlIIIllI.getName())) {
                            lllllllllllllllIIIIIlIIlIIllIIlI.put(lllllllllllllllIIIIIlIIlIlIIIllI.getName(), new FieldProperty(lllllllllllllllIIIIIlIIlIlIIIllI));
                        }
                    }
                }
                break;
            }
            default: {
                try {
                    for (final PropertyDescriptor lllllllllllllllIIIIIlIIlIlIIIIII : Introspector.getBeanInfo(lllllllllllllllIIIIIlIIlIIllIlII).getPropertyDescriptors()) {
                        final Method lllllllllllllllIIIIIlIIlIlIIIIIl = lllllllllllllllIIIIIlIIlIlIIIIII.getReadMethod();
                        if ((lllllllllllllllIIIIIlIIlIlIIIIIl == null || !lllllllllllllllIIIIIlIIlIlIIIIIl.getName().equals("getClass")) && !this.isTransient(lllllllllllllllIIIIIlIIlIlIIIIII)) {
                            lllllllllllllllIIIIIlIIlIIllIIlI.put(lllllllllllllllIIIIIlIIlIlIIIIII.getName(), new MethodProperty(lllllllllllllllIIIIIlIIlIlIIIIII));
                        }
                    }
                }
                catch (IntrospectionException lllllllllllllllIIIIIlIIlIIllllII) {
                    throw new YAMLException(lllllllllllllllIIIIIlIIlIIllllII);
                }
                for (Class<?> lllllllllllllllIIIIIlIIlIIllIllI = lllllllllllllllIIIIIlIIlIIllIlII; lllllllllllllllIIIIIlIIlIIllIllI != null; lllllllllllllllIIIIIlIIlIIllIllI = lllllllllllllllIIIIIlIIlIIllIllI.getSuperclass()) {
                    for (final Field lllllllllllllllIIIIIlIIlIIlllIlI : lllllllllllllllIIIIIlIIlIIllIllI.getDeclaredFields()) {
                        final int lllllllllllllllIIIIIlIIlIIlllIll = lllllllllllllllIIIIIlIIlIIlllIlI.getModifiers();
                        if (!Modifier.isStatic(lllllllllllllllIIIIIlIIlIIlllIll) && !Modifier.isTransient(lllllllllllllllIIIIIlIIlIIlllIll)) {
                            if (Modifier.isPublic(lllllllllllllllIIIIIlIIlIIlllIll)) {
                                lllllllllllllllIIIIIlIIlIIllIIlI.put(lllllllllllllllIIIIIlIIlIIlllIlI.getName(), new FieldProperty(lllllllllllllllIIIIIlIIlIIlllIlI));
                            }
                            else {
                                lllllllllllllllIIIIIlIIlIIllIIIl = true;
                            }
                        }
                    }
                }
                break;
            }
        }
        if (lllllllllllllllIIIIIlIIlIIllIIlI.isEmpty() && lllllllllllllllIIIIIlIIlIIllIIIl) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("No JavaBean properties found in ").append(lllllllllllllllIIIIIlIIlIIllIlII.getName())));
        }
        this.propertiesCache.put(lllllllllllllllIIIIIlIIlIIllIlII, lllllllllllllllIIIIIlIIlIIllIIlI);
        return lllllllllllllllIIIIIlIIlIIllIIlI;
    }
    
    protected Set<Property> createPropertySet(final Class<?> lllllllllllllllIIIIIlIIlIIIIIlIl, final BeanAccess lllllllllllllllIIIIIlIIIllllllll) {
        final Set<Property> lllllllllllllllIIIIIlIIlIIIIIIll = new TreeSet<Property>();
        final Collection<Property> lllllllllllllllIIIIIlIIlIIIIIIlI = this.getPropertiesMap(lllllllllllllllIIIIIlIIlIIIIIlIl, lllllllllllllllIIIIIlIIIllllllll).values();
        for (final Property lllllllllllllllIIIIIlIIlIIIIlIII : lllllllllllllllIIIIIlIIlIIIIIIlI) {
            if (lllllllllllllllIIIIIlIIlIIIIlIII.isReadable() && (this.allowReadOnlyProperties || lllllllllllllllIIIIIlIIlIIIIlIII.isWritable())) {
                lllllllllllllllIIIIIlIIlIIIIIIll.add(lllllllllllllllIIIIIlIIlIIIIlIII);
            }
        }
        return lllllllllllllllIIIIIlIIlIIIIIIll;
    }
    
    private boolean isTransient(final FeatureDescriptor lllllllllllllllIIIIIlIIlIIlIIIlI) {
        return Boolean.TRUE.equals(lllllllllllllllIIIIIlIIlIIlIIIlI.getValue("transient"));
    }
    
    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }
    
    public Property getProperty(final Class<?> lllllllllllllllIIIIIlIIIllllIllI, final String lllllllllllllllIIIIIlIIIllllIIlI) {
        return this.getProperty(lllllllllllllllIIIIIlIIIllllIllI, lllllllllllllllIIIIIlIIIllllIIlI, this.beanAccess);
    }
    
    PropertyUtils(final PlatformFeatureDetector lllllllllllllllIIIIIlIIlIlIlIlIl) {
        this.propertiesCache = new HashMap<Class<?>, Map<String, Property>>();
        this.readableProperties = new HashMap<Class<?>, Set<Property>>();
        this.beanAccess = BeanAccess.DEFAULT;
        this.allowReadOnlyProperties = false;
        this.skipMissingProperties = false;
        this.platformFeatureDetector = lllllllllllllllIIIIIlIIlIlIlIlIl;
        if (lllllllllllllllIIIIIlIIlIlIlIlIl.isRunningOnAndroid()) {
            this.beanAccess = BeanAccess.FIELD;
        }
    }
    
    static {
        TRANSIENT = "transient";
    }
    
    public void setBeanAccess(final BeanAccess lllllllllllllllIIIIIlIIIllIllIlI) {
        if (this.platformFeatureDetector.isRunningOnAndroid() && lllllllllllllllIIIIIlIIIllIllIlI != BeanAccess.FIELD) {
            throw new IllegalArgumentException("JVM is Android - only BeanAccess.FIELD is available");
        }
        if (this.beanAccess != lllllllllllllllIIIIIlIIIllIllIlI) {
            this.beanAccess = lllllllllllllllIIIIIlIIIllIllIlI;
            this.propertiesCache.clear();
            this.readableProperties.clear();
        }
    }
    
    public Set<Property> getProperties(final Class<?> lllllllllllllllIIIIIlIIlIIIlIIlI, final BeanAccess lllllllllllllllIIIIIlIIlIIIlIIIl) {
        if (this.readableProperties.containsKey(lllllllllllllllIIIIIlIIlIIIlIIlI)) {
            return this.readableProperties.get(lllllllllllllllIIIIIlIIlIIIlIIlI);
        }
        final Set<Property> lllllllllllllllIIIIIlIIlIIIlIlII = this.createPropertySet(lllllllllllllllIIIIIlIIlIIIlIIlI, lllllllllllllllIIIIIlIIlIIIlIIIl);
        this.readableProperties.put(lllllllllllllllIIIIIlIIlIIIlIIlI, lllllllllllllllIIIIIlIIlIIIlIlII);
        return lllllllllllllllIIIIIlIIlIIIlIlII;
    }
}
