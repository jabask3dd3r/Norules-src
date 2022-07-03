package com.viaversion.viaversion.libs.javassist;

final class CtArray extends CtClass
{
    private /* synthetic */ CtClass[] interfaces;
    protected /* synthetic */ ClassPool pool;
    
    @Override
    public CtClass getComponentType() throws NotFoundException {
        final String lllllllllllllIIIIIlllllIIIllIIlI = this.getName();
        return this.pool.get(lllllllllllllIIIIIlllllIIIllIIlI.substring(0, lllllllllllllIIIIIlllllIIIllIIlI.length() - 2));
    }
    
    @Override
    public CtMethod getMethod(final String lllllllllllllIIIIIlllllIIIlIIIlI, final String lllllllllllllIIIIIlllllIIIlIIIIl) throws NotFoundException {
        return this.getSuperclass().getMethod(lllllllllllllIIIIIlllllIIIlIIIlI, lllllllllllllIIIIIlllllIIIlIIIIl);
    }
    
    @Override
    public int getModifiers() {
        int lllllllllllllIIIIIlllllIIlIlIIIl = 16;
        try {
            lllllllllllllIIIIIlllllIIlIlIIIl |= (this.getComponentType().getModifiers() & 0x7);
        }
        catch (NotFoundException ex) {}
        return lllllllllllllIIIIIlllllIIlIlIIIl;
    }
    
    @Override
    public boolean subtypeOf(final CtClass lllllllllllllIIIIIlllllIIIlllIIl) throws NotFoundException {
        if (super.subtypeOf(lllllllllllllIIIIIlllllIIIlllIIl)) {
            return true;
        }
        final String lllllllllllllIIIIIlllllIIIllllII = lllllllllllllIIIIIlllllIIIlllIIl.getName();
        if (lllllllllllllIIIIIlllllIIIllllII.equals("java.lang.Object")) {
            return true;
        }
        final CtClass[] lllllllllllllIIIIIlllllIIIlllIll = this.getInterfaces();
        for (int lllllllllllllIIIIIlllllIIIllllll = 0; lllllllllllllIIIIIlllllIIIllllll < lllllllllllllIIIIIlllllIIIlllIll.length; ++lllllllllllllIIIIIlllllIIIllllll) {
            if (lllllllllllllIIIIIlllllIIIlllIll[lllllllllllllIIIIIlllllIIIllllll].subtypeOf(lllllllllllllIIIIIlllllIIIlllIIl)) {
                return true;
            }
        }
        return lllllllllllllIIIIIlllllIIIlllIIl.isArray() && this.getComponentType().subtypeOf(lllllllllllllIIIIIlllllIIIlllIIl.getComponentType());
    }
    
    CtArray(final String lllllllllllllIIIIIlllllIIlIllIll, final ClassPool lllllllllllllIIIIIlllllIIlIllIlI) {
        super(lllllllllllllIIIIIlllllIIlIllIll);
        this.interfaces = null;
        this.pool = lllllllllllllIIIIIlllllIIlIllIlI;
    }
    
    @Override
    public ClassPool getClassPool() {
        return this.pool;
    }
    
    @Override
    public boolean isArray() {
        return true;
    }
    
    @Override
    public CtClass getSuperclass() throws NotFoundException {
        return this.pool.get("java.lang.Object");
    }
    
    @Override
    public CtMethod[] getMethods() {
        try {
            return this.getSuperclass().getMethods();
        }
        catch (NotFoundException lllllllllllllIIIIIlllllIIIlIlIlI) {
            return super.getMethods();
        }
    }
    
    @Override
    public CtConstructor[] getConstructors() {
        try {
            return this.getSuperclass().getConstructors();
        }
        catch (NotFoundException lllllllllllllIIIIIlllllIIIIllIll) {
            return super.getConstructors();
        }
    }
    
    @Override
    public CtClass[] getInterfaces() throws NotFoundException {
        if (this.interfaces == null) {
            final Class<?>[] lllllllllllllIIIIIlllllIIlIIlIIl = Object[].class.getInterfaces();
            this.interfaces = new CtClass[lllllllllllllIIIIIlllllIIlIIlIIl.length];
            for (int lllllllllllllIIIIIlllllIIlIIlIlI = 0; lllllllllllllIIIIIlllllIIlIIlIlI < lllllllllllllIIIIIlllllIIlIIlIIl.length; ++lllllllllllllIIIIIlllllIIlIIlIlI) {
                this.interfaces[lllllllllllllIIIIIlllllIIlIIlIlI] = this.pool.get(lllllllllllllIIIIIlllllIIlIIlIIl[lllllllllllllIIIIIlllllIIlIIlIlI].getName());
            }
        }
        return this.interfaces;
    }
}
