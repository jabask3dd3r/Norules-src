package com.viaversion.viaversion.libs.javassist.convert;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public class TransformCall extends Transformer
{
    protected /* synthetic */ String classname;
    protected /* synthetic */ String methodDescriptor;
    protected /* synthetic */ String newClassname;
    protected /* synthetic */ String methodname;
    protected /* synthetic */ String newMethodname;
    protected /* synthetic */ int newIndex;
    protected /* synthetic */ ConstPool constPool;
    protected /* synthetic */ boolean newMethodIsPrivate;
    
    @Override
    public void initialize(final ConstPool lllllllllllllIllIllIIIlllIlIIIlI, final CodeAttribute lllllllllllllIllIllIIIlllIlIIlII) {
        if (this.constPool != lllllllllllllIllIllIIIlllIlIIIlI) {
            this.newIndex = 0;
        }
    }
    
    @Override
    public int transform(final CtClass lllllllllllllIllIllIIIlllIIlIlII, int lllllllllllllIllIllIIIlllIIIllIl, final CodeIterator lllllllllllllIllIllIIIlllIIlIIlI, final ConstPool lllllllllllllIllIllIIIlllIIlIIIl) throws BadBytecode {
        final int lllllllllllllIllIllIIIlllIIlIIII = lllllllllllllIllIllIIIlllIIlIIlI.byteAt(lllllllllllllIllIllIIIlllIIIllIl);
        if (lllllllllllllIllIllIIIlllIIlIIII == 185 || lllllllllllllIllIllIIIlllIIlIIII == 183 || lllllllllllllIllIllIIIlllIIlIIII == 184 || lllllllllllllIllIllIIIlllIIlIIII == 182) {
            final int lllllllllllllIllIllIIIlllIIlIlll = lllllllllllllIllIllIIIlllIIlIIlI.u16bitAt(lllllllllllllIllIllIIIlllIIIllIl + 1);
            final String lllllllllllllIllIllIIIlllIIlIllI = lllllllllllllIllIllIIIlllIIlIIIl.eqMember(this.methodname, this.methodDescriptor, lllllllllllllIllIllIIIlllIIlIlll);
            if (lllllllllllllIllIllIIIlllIIlIllI != null && this.matchClass(lllllllllllllIllIllIIIlllIIlIllI, lllllllllllllIllIllIIIlllIIlIlII.getClassPool())) {
                final int lllllllllllllIllIllIIIlllIIllIII = lllllllllllllIllIllIIIlllIIlIIIl.getMemberNameAndType(lllllllllllllIllIllIIIlllIIlIlll);
                lllllllllllllIllIllIIIlllIIIllIl = this.match(lllllllllllllIllIllIIIlllIIlIIII, lllllllllllllIllIllIIIlllIIIllIl, lllllllllllllIllIllIIIlllIIlIIlI, lllllllllllllIllIllIIIlllIIlIIIl.getNameAndTypeDescriptor(lllllllllllllIllIllIIIlllIIllIII), lllllllllllllIllIllIIIlllIIlIIIl);
            }
        }
        return lllllllllllllIllIllIIIlllIIIllIl;
    }
    
    private boolean matchClass(final String lllllllllllllIllIllIIIllIlllIlll, final ClassPool lllllllllllllIllIllIIIllIllllIIl) {
        if (this.classname.equals(lllllllllllllIllIllIIIllIlllIlll)) {
            return true;
        }
        try {
            final CtClass lllllllllllllIllIllIIIllIllllllI = lllllllllllllIllIllIIIllIllllIIl.get(lllllllllllllIllIllIIIllIlllIlll);
            final CtClass lllllllllllllIllIllIIIllIlllllIl = lllllllllllllIllIllIIIllIllllIIl.get(this.classname);
            if (lllllllllllllIllIllIIIllIllllllI.subtypeOf(lllllllllllllIllIllIIIllIlllllIl)) {
                try {
                    final CtMethod lllllllllllllIllIllIIIlllIIIIIII = lllllllllllllIllIllIIIllIllllllI.getMethod(this.methodname, this.methodDescriptor);
                    return lllllllllllllIllIllIIIlllIIIIIII.getDeclaringClass().getName().equals(this.classname);
                }
                catch (NotFoundException lllllllllllllIllIllIIIllIlllllll) {
                    return true;
                }
            }
        }
        catch (NotFoundException lllllllllllllIllIllIIIllIlllllII) {
            return false;
        }
        return false;
    }
    
    public TransformCall(final Transformer lllllllllllllIllIllIIIlllIlllIll, final CtMethod lllllllllllllIllIllIIIlllIlllIlI, final CtMethod lllllllllllllIllIllIIIlllIllIlIl) {
        this(lllllllllllllIllIllIIIlllIlllIll, lllllllllllllIllIllIIIlllIlllIlI.getName(), lllllllllllllIllIllIIIlllIllIlIl);
        this.classname = lllllllllllllIllIllIIIlllIlllIlI.getDeclaringClass().getName();
    }
    
    protected int match(final int lllllllllllllIllIllIIIllIllIIIIl, final int lllllllllllllIllIllIIIllIllIIIII, final CodeIterator lllllllllllllIllIllIIIllIllIIlIl, final int lllllllllllllIllIllIIIllIlIllllI, final ConstPool lllllllllllllIllIllIIIllIllIIIll) throws BadBytecode {
        if (this.newIndex == 0) {
            final int lllllllllllllIllIllIIIllIllIlIlI = lllllllllllllIllIllIIIllIllIIIll.addNameAndTypeInfo(lllllllllllllIllIllIIIllIllIIIll.addUtf8Info(this.newMethodname), lllllllllllllIllIllIIIllIlIllllI);
            final int lllllllllllllIllIllIIIllIllIlIIl = lllllllllllllIllIllIIIllIllIIIll.addClassInfo(this.newClassname);
            if (lllllllllllllIllIllIIIllIllIIIIl == 185) {
                this.newIndex = lllllllllllllIllIllIIIllIllIIIll.addInterfaceMethodrefInfo(lllllllllllllIllIllIIIllIllIlIIl, lllllllllllllIllIllIIIllIllIlIlI);
            }
            else {
                if (this.newMethodIsPrivate && lllllllllllllIllIllIIIllIllIIIIl == 182) {
                    lllllllllllllIllIllIIIllIllIIlIl.writeByte(183, lllllllllllllIllIllIIIllIllIIIII);
                }
                this.newIndex = lllllllllllllIllIllIIIllIllIIIll.addMethodrefInfo(lllllllllllllIllIllIIIllIllIlIIl, lllllllllllllIllIllIIIllIllIlIlI);
            }
            this.constPool = lllllllllllllIllIllIIIllIllIIIll;
        }
        lllllllllllllIllIllIIIllIllIIlIl.write16bit(this.newIndex, lllllllllllllIllIllIIIllIllIIIII + 1);
        return lllllllllllllIllIllIIIllIllIIIII;
    }
    
    public TransformCall(final Transformer lllllllllllllIllIllIIIlllIlIlIll, final String lllllllllllllIllIllIIIlllIlIlIlI, final CtMethod lllllllllllllIllIllIIIlllIlIllIl) {
        super(lllllllllllllIllIllIIIlllIlIlIll);
        this.methodname = lllllllllllllIllIllIIIlllIlIlIlI;
        this.methodDescriptor = lllllllllllllIllIllIIIlllIlIllIl.getMethodInfo2().getDescriptor();
        final String name = lllllllllllllIllIllIIIlllIlIllIl.getDeclaringClass().getName();
        this.newClassname = name;
        this.classname = name;
        this.newMethodname = lllllllllllllIllIllIIIlllIlIllIl.getName();
        this.constPool = null;
        this.newMethodIsPrivate = Modifier.isPrivate(lllllllllllllIllIllIIIlllIlIllIl.getModifiers());
    }
}
