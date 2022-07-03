package org.yaml.snakeyaml.introspector;

import java.lang.annotation.*;
import java.util.logging.*;
import java.lang.reflect.*;
import java.util.*;
import org.yaml.snakeyaml.error.*;

public class PropertySubstitute extends Property
{
    protected /* synthetic */ Class<?> targetType;
    private static final /* synthetic */ Logger log;
    private transient /* synthetic */ Method read;
    private final /* synthetic */ String writeMethod;
    private transient /* synthetic */ Method write;
    private final /* synthetic */ String readMethod;
    private /* synthetic */ boolean filler;
    private /* synthetic */ Field field;
    private /* synthetic */ Property delegate;
    protected /* synthetic */ Class<?>[] parameters;
    
    @Override
    public <A extends Annotation> A getAnnotation(final Class<A> llllllllllllllIlIlIlIIlIIIIllIlI) {
        A llllllllllllllIlIlIlIIlIIIIllIIl = null;
        if (this.read != null) {
            final A llllllllllllllIlIlIlIIlIIIIllllI = this.read.getAnnotation(llllllllllllllIlIlIlIIlIIIIllIlI);
        }
        else if (this.field != null) {
            final A llllllllllllllIlIlIlIIlIIIIlllII = this.field.getAnnotation(llllllllllllllIlIlIlIIlIIIIllIlI);
        }
        else {
            llllllllllllllIlIlIlIIlIIIIllIIl = this.delegate.getAnnotation(llllllllllllllIlIlIlIIlIIIIllIlI);
        }
        return llllllllllllllIlIlIlIIlIIIIllIIl;
    }
    
    @Override
    public boolean isReadable() {
        return this.read != null || this.field != null || (this.delegate != null && this.delegate.isReadable());
    }
    
    @Override
    public String getName() {
        final String llllllllllllllIlIlIlIIIlllIIIlII = super.getName();
        if (llllllllllllllIlIlIlIIIlllIIIlII != null) {
            return llllllllllllllIlIlIlIIIlllIIIlII;
        }
        return (this.delegate != null) ? this.delegate.getName() : null;
    }
    
    @Override
    public List<Annotation> getAnnotations() {
        Annotation[] llllllllllllllIlIlIlIIlIIIlIlIIl = null;
        if (this.read != null) {
            llllllllllllllIlIlIlIIlIIIlIlIIl = this.read.getAnnotations();
        }
        else if (this.field != null) {
            llllllllllllllIlIlIlIIlIIIlIlIIl = this.field.getAnnotations();
        }
        return (llllllllllllllIlIlIlIIlIIIlIlIIl != null) ? Arrays.asList(llllllllllllllIlIlIlIIlIIIlIlIIl) : this.delegate.getAnnotations();
    }
    
    @Override
    public boolean isWritable() {
        return this.write != null || this.field != null || (this.delegate != null && this.delegate.isWritable());
    }
    
    @Override
    public Class<?> getType() {
        final Class<?> llllllllllllllIlIlIlIIIllIlllllI = super.getType();
        if (llllllllllllllIlIlIlIIIllIlllllI != null) {
            return llllllllllllllIlIlIlIIIllIlllllI;
        }
        return (this.delegate != null) ? this.delegate.getType() : null;
    }
    
    public void setDelegate(final Property llllllllllllllIlIlIlIIIllIllIIlI) {
        this.delegate = llllllllllllllIlIlIlIIIllIllIIlI;
        if (this.writeMethod != null && this.write == null && !this.filler) {
            this.filler = true;
            this.write = this.discoverMethod(this.targetType, this.writeMethod, this.getActualTypeArguments());
        }
    }
    
    public void setActualTypeArguments(final Class<?>... llllllllllllllIlIlIlIIlIIllIllIl) {
        if (llllllllllllllIlIlIlIIlIIllIllIl != null && llllllllllllllIlIlIlIIlIIllIllIl.length > 0) {
            this.parameters = llllllllllllllIlIlIlIIlIIllIllIl;
        }
        else {
            this.parameters = null;
        }
    }
    
    private Method discoverMethod(final Class<?> llllllllllllllIlIlIlIIIlllIlIllI, final String llllllllllllllIlIlIlIIIlllIlIlIl, final Class<?>... llllllllllllllIlIlIlIIIlllIlIIII) {
        for (Class<?> llllllllllllllIlIlIlIIIlllIllIII = llllllllllllllIlIlIlIIIlllIlIllI; llllllllllllllIlIlIlIIIlllIllIII != null; llllllllllllllIlIlIlIIIlllIllIII = llllllllllllllIlIlIlIIIlllIllIII.getSuperclass()) {
            for (final Method llllllllllllllIlIlIlIIIlllIlllII : llllllllllllllIlIlIlIIIlllIllIII.getDeclaredMethods()) {
                if (llllllllllllllIlIlIlIIIlllIlIlIl.equals(llllllllllllllIlIlIlIIIlllIlllII.getName())) {
                    final Class<?>[] llllllllllllllIlIlIlIIIlllIllllI = llllllllllllllIlIlIlIIIlllIlllII.getParameterTypes();
                    if (llllllllllllllIlIlIlIIIlllIllllI.length == llllllllllllllIlIlIlIIIlllIlIIII.length) {
                        boolean llllllllllllllIlIlIlIIIlllIlllIl = true;
                        for (int llllllllllllllIlIlIlIIIlllIlllll = 0; llllllllllllllIlIlIlIIIlllIlllll < llllllllllllllIlIlIlIIIlllIllllI.length; ++llllllllllllllIlIlIlIIIlllIlllll) {
                            if (!llllllllllllllIlIlIlIIIlllIllllI[llllllllllllllIlIlIlIIIlllIlllll].isAssignableFrom(llllllllllllllIlIlIlIIIlllIlIIII[llllllllllllllIlIlIlIIIlllIlllll])) {
                                llllllllllllllIlIlIlIIIlllIlllIl = false;
                            }
                        }
                        if (llllllllllllllIlIlIlIIIlllIlllIl) {
                            llllllllllllllIlIlIlIIIlllIlllII.setAccessible(true);
                            return llllllllllllllIlIlIlIIIlllIlllII;
                        }
                    }
                }
            }
        }
        if (PropertySubstitute.log.isLoggable(Level.FINE)) {
            PropertySubstitute.log.fine(String.format("Failed to find [%s(%d args)] for %s.%s", llllllllllllllIlIlIlIIIlllIlIlIl, llllllllllllllIlIlIlIIIlllIlIIII.length, this.targetType.getName(), this.getName()));
        }
        return null;
    }
    
    public PropertySubstitute(final String llllllllllllllIlIlIlIIlIIllllIIl, final Class<?> llllllllllllllIlIlIlIIlIIllllIII, final Class<?>... llllllllllllllIlIlIlIIlIIllllIll) {
        this(llllllllllllllIlIlIlIIlIIllllIIl, llllllllllllllIlIlIlIIlIIllllIII, null, (String)null, llllllllllllllIlIlIlIIlIIllllIll);
    }
    
    public PropertySubstitute(final String llllllllllllllIlIlIlIIlIlIIIllIl, final Class<?> llllllllllllllIlIlIlIIlIlIIIIllI, final String llllllllllllllIlIlIlIIlIlIIIIlIl, final String llllllllllllllIlIlIlIIlIlIIIlIlI, final Class<?>... llllllllllllllIlIlIlIIlIlIIIlIIl) {
        super(llllllllllllllIlIlIlIIlIlIIIllIl, llllllllllllllIlIlIlIIlIlIIIIllI);
        this.readMethod = llllllllllllllIlIlIlIIlIlIIIIlIl;
        this.writeMethod = llllllllllllllIlIlIlIIlIlIIIlIlI;
        this.setActualTypeArguments(llllllllllllllIlIlIlIIlIlIIIlIIl);
        this.filler = false;
    }
    
    @Override
    public Class<?>[] getActualTypeArguments() {
        if (this.parameters == null && this.delegate != null) {
            return this.delegate.getActualTypeArguments();
        }
        return this.parameters;
    }
    
    public void setTargetType(final Class<?> llllllllllllllIlIlIlIIIlllllIlll) {
        if (this.targetType != llllllllllllllIlIlIlIIIlllllIlll) {
            this.targetType = llllllllllllllIlIlIlIIIlllllIlll;
            final String llllllllllllllIlIlIlIIIllllllIlI = this.getName();
            for (Class<?> llllllllllllllIlIlIlIIIlllllllII = llllllllllllllIlIlIlIIIlllllIlll; llllllllllllllIlIlIlIIIlllllllII != null; llllllllllllllIlIlIlIIIlllllllII = llllllllllllllIlIlIlIIIlllllllII.getSuperclass()) {
                final Field[] llllllllllllllIlIlIlIIIlllllllll = llllllllllllllIlIlIlIIIlllllllII.getDeclaredFields();
                final int llllllllllllllIlIlIlIIIllllllllI = llllllllllllllIlIlIlIIIlllllllll.length;
                int llllllllllllllIlIlIlIIIlllllllIl = 0;
                while (llllllllllllllIlIlIlIIIlllllllIl < llllllllllllllIlIlIlIIIllllllllI) {
                    final Field llllllllllllllIlIlIlIIlIIIIIIIII = llllllllllllllIlIlIlIIIlllllllll[llllllllllllllIlIlIlIIIlllllllIl];
                    if (llllllllllllllIlIlIlIIlIIIIIIIII.getName().equals(llllllllllllllIlIlIlIIIllllllIlI)) {
                        final int llllllllllllllIlIlIlIIlIIIIIIIIl = llllllllllllllIlIlIlIIlIIIIIIIII.getModifiers();
                        if (!Modifier.isStatic(llllllllllllllIlIlIlIIlIIIIIIIIl) && !Modifier.isTransient(llllllllllllllIlIlIlIIlIIIIIIIIl)) {
                            llllllllllllllIlIlIlIIlIIIIIIIII.setAccessible(true);
                            this.field = llllllllllllllIlIlIlIIlIIIIIIIII;
                            break;
                        }
                        break;
                    }
                    else {
                        ++llllllllllllllIlIlIlIIIlllllllIl;
                    }
                }
            }
            if (this.field == null && PropertySubstitute.log.isLoggable(Level.FINE)) {
                PropertySubstitute.log.fine(String.format("Failed to find field for %s.%s", llllllllllllllIlIlIlIIIlllllIlll.getName(), this.getName()));
            }
            if (this.readMethod != null) {
                this.read = this.discoverMethod(llllllllllllllIlIlIlIIIlllllIlll, this.readMethod, (Class<?>[])new Class[0]);
            }
            if (this.writeMethod != null) {
                this.filler = false;
                this.write = this.discoverMethod(llllllllllllllIlIlIlIIIlllllIlll, this.writeMethod, this.getType());
                if (this.write == null && this.parameters != null) {
                    this.filler = true;
                    this.write = this.discoverMethod(llllllllllllllIlIlIlIIIlllllIlll, this.writeMethod, this.parameters);
                }
            }
        }
    }
    
    @Override
    public void set(final Object llllllllllllllIlIlIlIIlIIlIIlIII, final Object llllllllllllllIlIlIlIIlIIlIIlIll) throws Exception {
        if (this.write != null) {
            if (!this.filler) {
                this.write.invoke(llllllllllllllIlIlIlIIlIIlIIlIII, llllllllllllllIlIlIlIIlIIlIIlIll);
            }
            else if (llllllllllllllIlIlIlIIlIIlIIlIll != null) {
                if (llllllllllllllIlIlIlIIlIIlIIlIll instanceof Collection) {
                    final Collection<?> llllllllllllllIlIlIlIIlIIlIlIlII = (Collection<?>)llllllllllllllIlIlIlIIlIIlIIlIll;
                    for (final Object llllllllllllllIlIlIlIIlIIlIllIII : llllllllllllllIlIlIlIIlIIlIlIlII) {
                        this.write.invoke(llllllllllllllIlIlIlIIlIIlIIlIII, llllllllllllllIlIlIlIIlIIlIllIII);
                    }
                }
                else if (llllllllllllllIlIlIlIIlIIlIIlIll instanceof Map) {
                    final Map<?, ?> llllllllllllllIlIlIlIIlIIlIlIIIl = (Map<?, ?>)llllllllllllllIlIlIlIIlIIlIIlIll;
                    for (final Map.Entry<?, ?> llllllllllllllIlIlIlIIlIIlIlIIll : llllllllllllllIlIlIlIIlIIlIlIIIl.entrySet()) {
                        this.write.invoke(llllllllllllllIlIlIlIIlIIlIIlIII, llllllllllllllIlIlIlIIlIIlIlIIll.getKey(), llllllllllllllIlIlIlIIlIIlIlIIll.getValue());
                    }
                }
                else if (llllllllllllllIlIlIlIIlIIlIIlIll.getClass().isArray()) {
                    for (int llllllllllllllIlIlIlIIlIIlIIllll = Array.getLength(llllllllllllllIlIlIlIIlIIlIIlIll), llllllllllllllIlIlIlIIlIIlIlIIII = 0; llllllllllllllIlIlIlIIlIIlIlIIII < llllllllllllllIlIlIlIIlIIlIIllll; ++llllllllllllllIlIlIlIIlIIlIlIIII) {
                        this.write.invoke(llllllllllllllIlIlIlIIlIIlIIlIII, Array.get(llllllllllllllIlIlIlIIlIIlIIlIll, llllllllllllllIlIlIlIIlIIlIlIIII));
                    }
                }
            }
        }
        else if (this.field != null) {
            this.field.set(llllllllllllllIlIlIlIIlIIlIIlIII, llllllllllllllIlIlIlIIlIIlIIlIll);
        }
        else if (this.delegate != null) {
            this.delegate.set(llllllllllllllIlIlIlIIlIIlIIlIII, llllllllllllllIlIlIlIIlIIlIIlIll);
        }
        else {
            PropertySubstitute.log.warning(String.valueOf(new StringBuilder().append("No setter/delegate for '").append(this.getName()).append("' on object ").append(llllllllllllllIlIlIlIIlIIlIIlIII)));
        }
    }
    
    static {
        log = Logger.getLogger(PropertySubstitute.class.getPackage().getName());
    }
    
    @Override
    public Object get(final Object llllllllllllllIlIlIlIIlIIIllIIlI) {
        try {
            if (this.read != null) {
                return this.read.invoke(llllllllllllllIlIlIlIIlIIIllIIlI, new Object[0]);
            }
            if (this.field != null) {
                return this.field.get(llllllllllllllIlIlIlIIlIIIllIIlI);
            }
        }
        catch (Exception llllllllllllllIlIlIlIIlIIIlllIII) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unable to find getter for property '").append(this.getName()).append("' on object ").append(llllllllllllllIlIlIlIIlIIIllIIlI).append(":").append(llllllllllllllIlIlIlIIlIIIlllIII)));
        }
        if (this.delegate != null) {
            return this.delegate.get(llllllllllllllIlIlIlIIlIIIllIIlI);
        }
        throw new YAMLException(String.valueOf(new StringBuilder().append("No getter or delegate for property '").append(this.getName()).append("' on object ").append(llllllllllllllIlIlIlIIlIIIllIIlI)));
    }
}
