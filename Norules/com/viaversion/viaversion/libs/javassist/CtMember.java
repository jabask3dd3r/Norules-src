package com.viaversion.viaversion.libs.javassist;

public abstract class CtMember
{
    /* synthetic */ CtMember next;
    protected /* synthetic */ CtClass declaringClass;
    
    @Override
    public String toString() {
        final StringBuffer llllllllllllllllIlIlIIlIIlIIIIll = new StringBuffer(this.getClass().getName());
        llllllllllllllllIlIlIIlIIlIIIIll.append("@");
        llllllllllllllllIlIlIIlIIlIIIIll.append(Integer.toHexString(this.hashCode()));
        llllllllllllllllIlIlIIlIIlIIIIll.append("[");
        llllllllllllllllIlIlIIlIIlIIIIll.append(Modifier.toString(this.getModifiers()));
        this.extendToString(llllllllllllllllIlIlIIlIIlIIIIll);
        llllllllllllllllIlIlIIlIIlIIIIll.append("]");
        return llllllllllllllllIlIlIIlIIlIIIIll.toString();
    }
    
    public abstract int getModifiers();
    
    public abstract Object[] getAnnotations() throws ClassNotFoundException;
    
    public abstract void setModifiers(final int p0);
    
    protected abstract void extendToString(final StringBuffer p0);
    
    public abstract boolean hasAnnotation(final String p0);
    
    protected CtMember(final CtClass llllllllllllllllIlIlIIlIIlIIllIl) {
        this.declaringClass = llllllllllllllllIlIlIIlIIlIIllIl;
        this.next = null;
    }
    
    public abstract void setAttribute(final String p0, final byte[] p1);
    
    public abstract String getGenericSignature();
    
    public abstract byte[] getAttribute(final String p0);
    
    public abstract Object[] getAvailableAnnotations();
    
    final CtMember next() {
        return this.next;
    }
    
    public boolean visibleFrom(final CtClass llllllllllllllllIlIlIIlIIIlIllll) {
        final int llllllllllllllllIlIlIIlIIIllIIIl = this.getModifiers();
        if (Modifier.isPublic(llllllllllllllllIlIlIIlIIIllIIIl)) {
            return true;
        }
        if (Modifier.isPrivate(llllllllllllllllIlIlIIlIIIllIIIl)) {
            return llllllllllllllllIlIlIIlIIIlIllll == this.declaringClass;
        }
        final String llllllllllllllllIlIlIIlIIIllIllI = this.declaringClass.getPackageName();
        final String llllllllllllllllIlIlIIlIIIllIlIl = llllllllllllllllIlIlIIlIIIlIllll.getPackageName();
        boolean llllllllllllllllIlIlIIlIIIllIlII = false;
        if (llllllllllllllllIlIlIIlIIIllIllI == null) {
            final boolean llllllllllllllllIlIlIIlIIIllIlll = llllllllllllllllIlIlIIlIIIllIlIl == null;
        }
        else {
            llllllllllllllllIlIlIIlIIIllIlII = llllllllllllllllIlIlIIlIIIllIllI.equals(llllllllllllllllIlIlIIlIIIllIlIl);
        }
        if (!llllllllllllllllIlIlIIlIIIllIlII && Modifier.isProtected(llllllllllllllllIlIlIIlIIIllIIIl)) {
            return llllllllllllllllIlIlIIlIIIlIllll.subclassOf(this.declaringClass);
        }
        return llllllllllllllllIlIlIIlIIIllIlII;
    }
    
    public abstract void setGenericSignature(final String p0);
    
    public abstract String getName();
    
    public boolean hasAnnotation(final Class<?> llllllllllllllllIlIlIIlIIIlIIlll) {
        return this.hasAnnotation(llllllllllllllllIlIlIIlIIIlIIlll.getName());
    }
    
    public CtClass getDeclaringClass() {
        return this.declaringClass;
    }
    
    public abstract Object getAnnotation(final Class<?> p0) throws ClassNotFoundException;
    
    public abstract String getSignature();
    
    void nameReplaced() {
    }
    
    static class Cache extends CtMember
    {
        private /* synthetic */ CtMember consTail;
        private /* synthetic */ CtMember methodTail;
        private /* synthetic */ CtMember fieldTail;
        
        static int count(CtMember lllllllllllllIIlllIlllIllIllIlII, final CtMember lllllllllllllIIlllIlllIllIllIllI) {
            int lllllllllllllIIlllIlllIllIllIlIl = 0;
            while (lllllllllllllIIlllIlllIllIllIlII != lllllllllllllIIlllIlllIllIllIllI) {
                ++lllllllllllllIIlllIlllIllIllIlIl;
                lllllllllllllIIlllIlllIllIllIlII = lllllllllllllIIlllIlllIllIllIlII.next;
            }
            return lllllllllllllIIlllIlllIllIllIlIl;
        }
        
        @Override
        public void setGenericSignature(final String lllllllllllllIIlllIlllIllllIIlIl) {
        }
        
        void addConstructor(final CtMember lllllllllllllIIlllIlllIlllIIIIll) {
            lllllllllllllIIlllIlllIlllIIIIll.next = this.consTail.next;
            this.consTail.next = lllllllllllllIIlllIlllIlllIIIIll;
            if (this.consTail == this.fieldTail) {
                this.fieldTail = lllllllllllllIIlllIlllIlllIIIIll;
            }
            this.consTail = lllllllllllllIIlllIlllIlllIIIIll;
        }
        
        Cache(final CtClassType lllllllllllllIIlllIlllIlllIlllll) {
            super(lllllllllllllIIlllIlllIlllIlllll);
            this.methodTail = this;
            this.consTail = this;
            this.fieldTail = this;
            this.fieldTail.next = this;
        }
        
        CtMember lastCons() {
            return this.consTail;
        }
        
        CtMember fieldHead() {
            return this.consTail;
        }
        
        void addMethod(final CtMember lllllllllllllIIlllIlllIlllIIlIIl) {
            lllllllllllllIIlllIlllIlllIIlIIl.next = this.methodTail.next;
            this.methodTail.next = lllllllllllllIIlllIlllIlllIIlIIl;
            if (this.methodTail == this.consTail) {
                this.consTail = lllllllllllllIIlllIlllIlllIIlIIl;
                if (this.methodTail == this.fieldTail) {
                    this.fieldTail = lllllllllllllIIlllIlllIlllIIlIIl;
                }
            }
            this.methodTail = lllllllllllllIIlllIlllIlllIIlIIl;
        }
        
        @Override
        public Object[] getAvailableAnnotations() {
            return null;
        }
        
        @Override
        protected void extendToString(final StringBuffer lllllllllllllIIlllIlllIllllllIII) {
        }
        
        @Override
        public Object[] getAnnotations() throws ClassNotFoundException {
            return null;
        }
        
        CtMember lastMethod() {
            return this.methodTail;
        }
        
        CtMember consHead() {
            return this.methodTail;
        }
        
        @Override
        public void setModifiers(final int lllllllllllllIIlllIlllIllllIlIII) {
        }
        
        @Override
        public Object getAnnotation(final Class<?> lllllllllllllIIlllIlllIlllllIlII) throws ClassNotFoundException {
            return null;
        }
        
        @Override
        public String getSignature() {
            return null;
        }
        
        CtMember methodHead() {
            return this;
        }
        
        @Override
        public boolean hasAnnotation(final String lllllllllllllIIlllIlllIlllllIllI) {
            return false;
        }
        
        @Override
        public void setAttribute(final String lllllllllllllIIlllIlllIllllIlIll, final byte[] lllllllllllllIIlllIlllIllllIlIlI) {
        }
        
        void remove(final CtMember lllllllllllllIIlllIlllIllIlIlIII) {
            CtMember lllllllllllllIIlllIlllIllIlIlIll = this;
            CtMember lllllllllllllIIlllIlllIllIlIlIlI;
            while ((lllllllllllllIIlllIlllIllIlIlIlI = lllllllllllllIIlllIlllIllIlIlIll.next) != this) {
                if (lllllllllllllIIlllIlllIllIlIlIlI == lllllllllllllIIlllIlllIllIlIlIII) {
                    lllllllllllllIIlllIlllIllIlIlIll.next = lllllllllllllIIlllIlllIllIlIlIlI.next;
                    if (lllllllllllllIIlllIlllIllIlIlIlI == this.methodTail) {
                        this.methodTail = lllllllllllllIIlllIlllIllIlIlIll;
                    }
                    if (lllllllllllllIIlllIlllIllIlIlIlI == this.consTail) {
                        this.consTail = lllllllllllllIIlllIlllIllIlIlIll;
                    }
                    if (lllllllllllllIIlllIlllIllIlIlIlI == this.fieldTail) {
                        this.fieldTail = lllllllllllllIIlllIlllIllIlIlIll;
                        break;
                    }
                    break;
                }
                else {
                    lllllllllllllIIlllIlllIllIlIlIll = lllllllllllllIIlllIlllIllIlIlIll.next;
                }
            }
        }
        
        @Override
        public int getModifiers() {
            return 0;
        }
        
        @Override
        public String getGenericSignature() {
            return null;
        }
        
        void addField(final CtMember lllllllllllllIIlllIlllIllIllllIl) {
            lllllllllllllIIlllIlllIllIllllIl.next = this;
            this.fieldTail.next = lllllllllllllIIlllIlllIllIllllIl;
            this.fieldTail = lllllllllllllIIlllIlllIllIllllIl;
        }
        
        CtMember lastField() {
            return this.fieldTail;
        }
        
        @Override
        public String getName() {
            return null;
        }
        
        @Override
        public byte[] getAttribute(final String lllllllllllllIIlllIlllIlllllIIIl) {
            return null;
        }
    }
}
