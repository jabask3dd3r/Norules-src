package com.viaversion.viaversion.libs.javassist.tools.reflect;

import java.lang.reflect.*;
import java.io.*;

public class Metaobject implements Serializable
{
    protected /* synthetic */ Metalevel baseobject;
    protected /* synthetic */ Method[] methods;
    protected /* synthetic */ ClassMetaobject classmetaobject;
    
    public final Object getObject() {
        return this.baseobject;
    }
    
    public final String getMethodName(final int lllllllllllllIIlIllIlllIIlllIIII) {
        final String lllllllllllllIIlIllIlllIIlllIIll = this.methods[lllllllllllllIIlIllIlllIIlllIIII].getName();
        int lllllllllllllIIlIllIlllIIlllIIlI = 3;
        char lllllllllllllIIlIllIlllIIlllIllI;
        do {
            lllllllllllllIIlIllIlllIIlllIllI = lllllllllllllIIlIllIlllIIlllIIll.charAt(lllllllllllllIIlIllIlllIIlllIIlI++);
        } while (lllllllllllllIIlIllIlllIIlllIllI >= '0' && '9' >= lllllllllllllIIlIllIlllIIlllIllI);
        return lllllllllllllIIlIllIlllIIlllIIll.substring(lllllllllllllIIlIllIlllIIlllIIlI);
    }
    
    public void trapFieldWrite(final String lllllllllllllIIlIllIlllIIlIIlIll, final Object lllllllllllllIIlIllIlllIIlIIIllI) {
        final Class<?> lllllllllllllIIlIllIlllIIlIIlIIl = this.getClassMetaobject().getJavaClass();
        try {
            lllllllllllllIIlIllIlllIIlIIlIIl.getField(lllllllllllllIIlIllIlllIIlIIlIll).set(this.getObject(), lllllllllllllIIlIllIlllIIlIIIllI);
        }
        catch (NoSuchFieldException lllllllllllllIIlIllIlllIIlIIlllI) {
            throw new RuntimeException(lllllllllllllIIlIllIlllIIlIIlllI.toString());
        }
        catch (IllegalAccessException lllllllllllllIIlIllIlllIIlIIllIl) {
            throw new RuntimeException(lllllllllllllIIlIllIlllIIlIIllIl.toString());
        }
    }
    
    public Object trapFieldRead(final String lllllllllllllIIlIllIlllIIlIlIllI) {
        final Class<?> lllllllllllllIIlIllIlllIIlIllIII = this.getClassMetaobject().getJavaClass();
        try {
            return lllllllllllllIIlIllIlllIIlIllIII.getField(lllllllllllllIIlIllIlllIIlIlIllI).get(this.getObject());
        }
        catch (NoSuchFieldException lllllllllllllIIlIllIlllIIlIlllII) {
            throw new RuntimeException(lllllllllllllIIlIllIlllIIlIlllII.toString());
        }
        catch (IllegalAccessException lllllllllllllIIlIllIlllIIlIllIll) {
            throw new RuntimeException(lllllllllllllIIlIllIlllIIlIllIll.toString());
        }
    }
    
    protected Metaobject() {
        this.baseobject = null;
        this.classmetaobject = null;
        this.methods = null;
    }
    
    private void writeObject(final ObjectOutputStream lllllllllllllIIlIllIlllIlIIlIlII) throws IOException {
        lllllllllllllIIlIllIlllIlIIlIlII.writeObject(this.baseobject);
    }
    
    public Object trapMethodcall(final int lllllllllllllIIlIllIlllIIIlllIIl, final Object[] lllllllllllllIIlIllIlllIIIlllIll) throws Throwable {
        try {
            return this.methods[lllllllllllllIIlIllIlllIIIlllIIl].invoke(this.getObject(), lllllllllllllIIlIllIlllIIIlllIll);
        }
        catch (InvocationTargetException lllllllllllllIIlIllIlllIIIllllll) {
            throw lllllllllllllIIlIllIlllIIIllllll.getTargetException();
        }
        catch (IllegalAccessException lllllllllllllIIlIllIlllIIIlllllI) {
            throw new CannotInvokeException(lllllllllllllIIlIllIlllIIIlllllI);
        }
    }
    
    public final ClassMetaobject getClassMetaobject() {
        return this.classmetaobject;
    }
    
    public final Class<?>[] getParameterTypes(final int lllllllllllllIIlIllIlllIIllIlIIl) {
        return this.methods[lllllllllllllIIlIllIlllIIllIlIIl].getParameterTypes();
    }
    
    public final void setObject(final Object lllllllllllllIIlIllIlllIIllllllI) {
        this.baseobject = (Metalevel)lllllllllllllIIlIllIlllIIllllllI;
        this.classmetaobject = this.baseobject._getClass();
        this.methods = this.classmetaobject.getReflectiveMethods();
        this.baseobject._setMetaobject(this);
    }
    
    public final Class<?> getReturnType(final int lllllllllllllIIlIllIlllIIllIIIIl) {
        return this.methods[lllllllllllllIIlIllIlllIIllIIIIl].getReturnType();
    }
    
    public Metaobject(final Object lllllllllllllIIlIllIlllIlIIlllIl, final Object[] lllllllllllllIIlIllIlllIlIIlllll) {
        this.baseobject = (Metalevel)lllllllllllllIIlIllIlllIlIIlllIl;
        this.classmetaobject = this.baseobject._getClass();
        this.methods = this.classmetaobject.getReflectiveMethods();
    }
    
    private void readObject(final ObjectInputStream lllllllllllllIIlIllIlllIlIIIlllI) throws ClassNotFoundException, IOException {
        this.baseobject = (Metalevel)lllllllllllllIIlIllIlllIlIIIlllI.readObject();
        this.classmetaobject = this.baseobject._getClass();
        this.methods = this.classmetaobject.getReflectiveMethods();
    }
}
