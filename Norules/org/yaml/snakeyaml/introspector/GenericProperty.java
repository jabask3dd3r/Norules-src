package org.yaml.snakeyaml.introspector;

import java.lang.reflect.*;

public abstract class GenericProperty extends Property
{
    private /* synthetic */ Class<?>[] actualClasses;
    private /* synthetic */ boolean actualClassesChecked;
    private /* synthetic */ Type genType;
    
    @Override
    public Class<?>[] getActualTypeArguments() {
        if (!this.actualClassesChecked) {
            if (this.genType instanceof ParameterizedType) {
                final ParameterizedType llllllllllllllIlllIlllllllIIlIII = (ParameterizedType)this.genType;
                final Type[] llllllllllllllIlllIlllllllIIIlll = llllllllllllllIlllIlllllllIIlIII.getActualTypeArguments();
                if (llllllllllllllIlllIlllllllIIIlll.length > 0) {
                    this.actualClasses = (Class<?>[])new Class[llllllllllllllIlllIlllllllIIIlll.length];
                    for (int llllllllllllllIlllIlllllllIIlIIl = 0; llllllllllllllIlllIlllllllIIlIIl < llllllllllllllIlllIlllllllIIIlll.length; ++llllllllllllllIlllIlllllllIIlIIl) {
                        if (llllllllllllllIlllIlllllllIIIlll[llllllllllllllIlllIlllllllIIlIIl] instanceof Class) {
                            this.actualClasses[llllllllllllllIlllIlllllllIIlIIl] = (Class<?>)llllllllllllllIlllIlllllllIIIlll[llllllllllllllIlllIlllllllIIlIIl];
                        }
                        else if (llllllllllllllIlllIlllllllIIIlll[llllllllllllllIlllIlllllllIIlIIl] instanceof ParameterizedType) {
                            this.actualClasses[llllllllllllllIlllIlllllllIIlIIl] = (Class<?>)((ParameterizedType)llllllllllllllIlllIlllllllIIIlll[llllllllllllllIlllIlllllllIIlIIl]).getRawType();
                        }
                        else {
                            if (!(llllllllllllllIlllIlllllllIIIlll[llllllllllllllIlllIlllllllIIlIIl] instanceof GenericArrayType)) {
                                this.actualClasses = null;
                                break;
                            }
                            final Type llllllllllllllIlllIlllllllIIlIlI = ((GenericArrayType)llllllllllllllIlllIlllllllIIIlll[llllllllllllllIlllIlllllllIIlIIl]).getGenericComponentType();
                            if (!(llllllllllllllIlllIlllllllIIlIlI instanceof Class)) {
                                this.actualClasses = null;
                                break;
                            }
                            this.actualClasses[llllllllllllllIlllIlllllllIIlIIl] = Array.newInstance((Class<?>)llllllllllllllIlllIlllllllIIlIlI, 0).getClass();
                        }
                    }
                }
            }
            else if (this.genType instanceof GenericArrayType) {
                final Type llllllllllllllIlllIlllllllIIIllI = ((GenericArrayType)this.genType).getGenericComponentType();
                if (llllllllllllllIlllIlllllllIIIllI instanceof Class) {
                    this.actualClasses = (Class<?>[])new Class[] { (Class)llllllllllllllIlllIlllllllIIIllI };
                }
            }
            else if (this.genType instanceof Class) {
                final Class<?> llllllllllllllIlllIlllllllIIIlIl = (Class<?>)this.genType;
                if (llllllllllllllIlllIlllllllIIIlIl.isArray()) {
                    this.actualClasses = (Class<?>[])new Class[1];
                    this.actualClasses[0] = this.getType().getComponentType();
                }
            }
            this.actualClassesChecked = true;
        }
        return this.actualClasses;
    }
    
    public GenericProperty(final String llllllllllllllIlllIlllllllIlIIlI, final Class<?> llllllllllllllIlllIlllllllIlIIIl, final Type llllllllllllllIlllIlllllllIlIIII) {
        super(llllllllllllllIlllIlllllllIlIIlI, llllllllllllllIlllIlllllllIlIIIl);
        this.genType = llllllllllllllIlllIlllllllIlIIII;
        this.actualClassesChecked = (llllllllllllllIlllIlllllllIlIIII == null);
    }
}
