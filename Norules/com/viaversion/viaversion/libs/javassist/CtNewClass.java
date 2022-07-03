package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;

class CtNewClass extends CtClassType
{
    protected /* synthetic */ boolean hasConstructor;
    
    private boolean isInheritable(final int llllllllllllllIIlIIIlIIllllIlIll, final CtClass llllllllllllllIIlIIIlIIllllIllIl) {
        if (Modifier.isPrivate(llllllllllllllIIlIIIlIIllllIlIll)) {
            return false;
        }
        if (!Modifier.isPackage(llllllllllllllIIlIIIlIIllllIlIll)) {
            return true;
        }
        final String llllllllllllllIIlIIIlIIlllllIIIl = this.getPackageName();
        final String llllllllllllllIIlIIIlIIlllllIIII = llllllllllllllIIlIIIlIIllllIllIl.getPackageName();
        if (llllllllllllllIIlIIIlIIlllllIIIl == null) {
            return llllllllllllllIIlIIIlIIlllllIIII == null;
        }
        return llllllllllllllIIlIIIlIIlllllIIIl.equals(llllllllllllllIIlIIIlIIlllllIIII);
    }
    
    @Override
    protected void extendToString(final StringBuffer llllllllllllllIIlIIIlIlIIIIllllI) {
        if (this.hasConstructor) {
            llllllllllllllIIlIIIlIlIIIIllllI.append("hasConstructor ");
        }
        super.extendToString(llllllllllllllIIlIIIlIlIIIIllllI);
    }
    
    @Override
    public void addConstructor(final CtConstructor llllllllllllllIIlIIIlIlIIIIllIlI) throws CannotCompileException {
        this.hasConstructor = true;
        super.addConstructor(llllllllllllllIIlIIIlIlIIIIllIlI);
    }
    
    CtNewClass(final String llllllllllllllIIlIIIlIlIIIlIlllI, final ClassPool llllllllllllllIIlIIIlIlIIIlIIlll, final boolean llllllllllllllIIlIIIlIlIIIlIIllI, final CtClass llllllllllllllIIlIIIlIlIIIlIIlIl) {
        super(llllllllllllllIIlIIIlIlIIIlIlllI, llllllllllllllIIlIIIlIlIIIlIIlll);
        this.wasChanged = true;
        String llllllllllllllIIlIIIlIlIIIlIlIlI = null;
        if (llllllllllllllIIlIIIlIlIIIlIIllI || llllllllllllllIIlIIIlIlIIIlIIlIl == null) {
            final String llllllllllllllIIlIIIlIlIIIllIIII = null;
        }
        else {
            llllllllllllllIIlIIIlIlIIIlIlIlI = llllllllllllllIIlIIIlIlIIIlIIlIl.getName();
        }
        this.classfile = new ClassFile(llllllllllllllIIlIIIlIlIIIlIIllI, llllllllllllllIIlIIIlIlIIIlIlllI, llllllllllllllIIlIIIlIlIIIlIlIlI);
        if (llllllllllllllIIlIIIlIlIIIlIIllI && llllllllllllllIIlIIIlIlIIIlIIlIl != null) {
            this.classfile.setInterfaces(new String[] { llllllllllllllIIlIIIlIlIIIlIIlIl.getName() });
        }
        this.setModifiers(Modifier.setPublic(this.getModifiers()));
        this.hasConstructor = llllllllllllllIIlIIIlIlIIIlIIllI;
    }
    
    @Override
    public void toBytecode(final DataOutputStream llllllllllllllIIlIIIlIlIIIIlIIII) throws IOException, CannotCompileException {
        if (!this.hasConstructor) {
            try {
                this.inheritAllConstructors();
                this.hasConstructor = true;
            }
            catch (NotFoundException llllllllllllllIIlIIIlIlIIIIlIlII) {
                throw new CannotCompileException(llllllllllllllIIlIIIlIlIIIIlIlII);
            }
        }
        super.toBytecode(llllllllllllllIIlIIIlIlIIIIlIIII);
    }
    
    public void inheritAllConstructors() throws NotFoundException, CannotCompileException {
        final CtClass llllllllllllllIIlIIIlIlIIIIIIIIl = this.getSuperclass();
        final CtConstructor[] llllllllllllllIIlIIIlIlIIIIIIIII = llllllllllllllIIlIIIlIlIIIIIIIIl.getDeclaredConstructors();
        int llllllllllllllIIlIIIlIIlllllllll = 0;
        for (int llllllllllllllIIlIIIlIlIIIIIIIll = 0; llllllllllllllIIlIIIlIlIIIIIIIll < llllllllllllllIIlIIIlIlIIIIIIIII.length; ++llllllllllllllIIlIIIlIlIIIIIIIll) {
            final CtConstructor llllllllllllllIIlIIIlIlIIIIIIlIl = llllllllllllllIIlIIIlIlIIIIIIIII[llllllllllllllIIlIIIlIlIIIIIIIll];
            final int llllllllllllllIIlIIIlIlIIIIIIlII = llllllllllllllIIlIIIlIlIIIIIIlIl.getModifiers();
            if (this.isInheritable(llllllllllllllIIlIIIlIlIIIIIIlII, llllllllllllllIIlIIIlIlIIIIIIIIl)) {
                final CtConstructor llllllllllllllIIlIIIlIlIIIIIIllI = CtNewConstructor.make(llllllllllllllIIlIIIlIlIIIIIIlIl.getParameterTypes(), llllllllllllllIIlIIIlIlIIIIIIlIl.getExceptionTypes(), this);
                llllllllllllllIIlIIIlIlIIIIIIllI.setModifiers(llllllllllllllIIlIIIlIlIIIIIIlII & 0x7);
                this.addConstructor(llllllllllllllIIlIIIlIlIIIIIIllI);
                ++llllllllllllllIIlIIIlIIlllllllll;
            }
        }
        if (llllllllllllllIIlIIIlIIlllllllll < 1) {
            throw new CannotCompileException(String.valueOf(new StringBuilder().append("no inheritable constructor in ").append(llllllllllllllIIlIIIlIlIIIIIIIIl.getName())));
        }
    }
}
