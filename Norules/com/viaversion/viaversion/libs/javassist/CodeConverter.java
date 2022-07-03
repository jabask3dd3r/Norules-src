package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.convert.*;

public class CodeConverter
{
    protected /* synthetic */ Transformer transformers;
    
    public void insertAfterMethod(final CtMethod lllllllllllllIIlllIllIlllllIlllI, final CtMethod lllllllllllllIIlllIllIllllllIIII) throws CannotCompileException {
        try {
            this.transformers = new TransformAfter(this.transformers, lllllllllllllIIlllIllIlllllIlllI, lllllllllllllIIlllIllIllllllIIII);
        }
        catch (NotFoundException lllllllllllllIIlllIllIllllllIIll) {
            throw new CannotCompileException(lllllllllllllIIlllIllIllllllIIll);
        }
    }
    
    public void replaceFieldWrite(final CtField lllllllllllllIIlllIlllIIIIlllIlI, final CtClass lllllllllllllIIlllIlllIIIIllIlIl, final String lllllllllllllIIlllIlllIIIIlllIII) {
        this.transformers = new TransformWriteField(this.transformers, lllllllllllllIIlllIlllIIIIlllIlI, lllllllllllllIIlllIlllIIIIllIlIl.getName(), lllllllllllllIIlllIlllIIIIlllIII);
    }
    
    public void replaceFieldRead(final CtField lllllllllllllIIlllIlllIIIlIIIIlI, final CtClass lllllllllllllIIlllIlllIIIlIIIIIl, final String lllllllllllllIIlllIlllIIIlIIIIII) {
        this.transformers = new TransformReadField(this.transformers, lllllllllllllIIlllIlllIIIlIIIIlI, lllllllllllllIIlllIlllIIIlIIIIIl.getName(), lllllllllllllIIlllIlllIIIlIIIIII);
    }
    
    protected void doit(final CtClass lllllllllllllIIlllIllIllllIlllII, final MethodInfo lllllllllllllIIlllIllIllllIllIll, final ConstPool lllllllllllllIIlllIllIllllIllIlI) throws CannotCompileException {
        final CodeAttribute lllllllllllllIIlllIllIllllIllIII = lllllllllllllIIlllIllIllllIllIll.getCodeAttribute();
        if (lllllllllllllIIlllIllIllllIllIII == null || this.transformers == null) {
            return;
        }
        for (Transformer lllllllllllllIIlllIllIllllIllIIl = this.transformers; lllllllllllllIIlllIllIllllIllIIl != null; lllllllllllllIIlllIllIllllIllIIl = lllllllllllllIIlllIllIllllIllIIl.getNext()) {
            lllllllllllllIIlllIllIllllIllIIl.initialize(lllllllllllllIIlllIllIllllIllIlI, lllllllllllllIIlllIllIllllIlllII, lllllllllllllIIlllIllIllllIllIll);
        }
        final CodeIterator lllllllllllllIIlllIllIllllIlIlll = lllllllllllllIIlllIllIllllIllIII.iterator();
        while (lllllllllllllIIlllIllIllllIlIlll.hasNext()) {
            try {
                int lllllllllllllIIlllIllIlllllIIIIl = lllllllllllllIIlllIllIllllIlIlll.next();
                for (Transformer lllllllllllllIIlllIllIllllIllIIl = this.transformers; lllllllllllllIIlllIllIllllIllIIl != null; lllllllllllllIIlllIllIllllIllIIl = lllllllllllllIIlllIllIllllIllIIl.getNext()) {
                    lllllllllllllIIlllIllIlllllIIIIl = lllllllllllllIIlllIllIllllIllIIl.transform(lllllllllllllIIlllIllIllllIlllII, lllllllllllllIIlllIllIlllllIIIIl, lllllllllllllIIlllIllIllllIlIlll, lllllllllllllIIlllIllIllllIllIlI);
                }
                continue;
            }
            catch (BadBytecode lllllllllllllIIlllIllIlllllIIIII) {
                throw new CannotCompileException(lllllllllllllIIlllIllIlllllIIIII);
            }
            break;
        }
        int lllllllllllllIIlllIllIllllIlIllI = 0;
        int lllllllllllllIIlllIllIllllIlIlIl = 0;
        for (Transformer lllllllllllllIIlllIllIllllIllIIl = this.transformers; lllllllllllllIIlllIllIllllIllIIl != null; lllllllllllllIIlllIllIllllIllIIl = lllllllllllllIIlllIllIllllIllIIl.getNext()) {
            int lllllllllllllIIlllIllIllllIlllll = lllllllllllllIIlllIllIllllIllIIl.extraLocals();
            if (lllllllllllllIIlllIllIllllIlllll > lllllllllllllIIlllIllIllllIlIllI) {
                lllllllllllllIIlllIllIllllIlIllI = lllllllllllllIIlllIllIllllIlllll;
            }
            lllllllllllllIIlllIllIllllIlllll = lllllllllllllIIlllIllIllllIllIIl.extraStack();
            if (lllllllllllllIIlllIllIllllIlllll > lllllllllllllIIlllIllIllllIlIlIl) {
                lllllllllllllIIlllIllIllllIlIlIl = lllllllllllllIIlllIllIllllIlllll;
            }
        }
        for (Transformer lllllllllllllIIlllIllIllllIllIIl = this.transformers; lllllllllllllIIlllIllIllllIllIIl != null; lllllllllllllIIlllIllIllllIllIIl = lllllllllllllIIlllIllIllllIllIIl.getNext()) {
            lllllllllllllIIlllIllIllllIllIIl.clean();
        }
        if (lllllllllllllIIlllIllIllllIlIllI > 0) {
            lllllllllllllIIlllIllIllllIllIII.setMaxLocals(lllllllllllllIIlllIllIllllIllIII.getMaxLocals() + lllllllllllllIIlllIllIllllIlIllI);
        }
        if (lllllllllllllIIlllIllIllllIlIlIl > 0) {
            lllllllllllllIIlllIllIllllIllIII.setMaxStack(lllllllllllllIIlllIllIllllIllIII.getMaxStack() + lllllllllllllIIlllIllIllllIlIlIl);
        }
        try {
            lllllllllllllIIlllIllIllllIllIll.rebuildStackMapIf6(lllllllllllllIIlllIllIllllIlllII.getClassPool(), lllllllllllllIIlllIllIllllIlllII.getClassFile2());
        }
        catch (BadBytecode lllllllllllllIIlllIllIllllIllllI) {
            throw new CannotCompileException(lllllllllllllIIlllIllIllllIllllI.getMessage(), lllllllllllllIIlllIllIllllIllllI);
        }
    }
    
    public void redirectMethodCall(final String lllllllllllllIIlllIlllIIIIIlIIIl, final CtMethod lllllllllllllIIlllIlllIIIIIIllIl) throws CannotCompileException {
        this.transformers = new TransformCall(this.transformers, lllllllllllllIIlllIlllIIIIIlIIIl, lllllllllllllIIlllIlllIIIIIIllIl);
    }
    
    public void redirectFieldAccess(final CtField lllllllllllllIIlllIlllIIIlIlIIlI, final CtClass lllllllllllllIIlllIlllIIIlIIllIl, final String lllllllllllllIIlllIlllIIIlIlIIII) {
        this.transformers = new TransformFieldAccess(this.transformers, lllllllllllllIIlllIlllIIIlIlIIlI, lllllllllllllIIlllIlllIIIlIIllIl.getName(), lllllllllllllIIlllIlllIIIlIlIIII);
    }
    
    public void redirectMethodCallToStatic(final CtMethod lllllllllllllIIlllIlllIIIIIIIlIl, final CtMethod lllllllllllllIIlllIlllIIIIIIIlII) {
        this.transformers = new TransformCallToStatic(this.transformers, lllllllllllllIIlllIlllIIIIIIIlIl, lllllllllllllIIlllIlllIIIIIIIlII);
    }
    
    public void redirectMethodCall(final CtMethod lllllllllllllIIlllIlllIIIIIllIll, final CtMethod lllllllllllllIIlllIlllIIIIIllIlI) throws CannotCompileException {
        final String lllllllllllllIIlllIlllIIIIlIIIII = lllllllllllllIIlllIlllIIIIIllIll.getMethodInfo2().getDescriptor();
        final String lllllllllllllIIlllIlllIIIIIlllll = lllllllllllllIIlllIlllIIIIIllIlI.getMethodInfo2().getDescriptor();
        if (!lllllllllllllIIlllIlllIIIIlIIIII.equals(lllllllllllllIIlllIlllIIIIIlllll)) {
            throw new CannotCompileException(String.valueOf(new StringBuilder().append("signature mismatch: ").append(lllllllllllllIIlllIlllIIIIIllIlI.getLongName())));
        }
        final int lllllllllllllIIlllIlllIIIIIllllI = lllllllllllllIIlllIlllIIIIIllIll.getModifiers();
        final int lllllllllllllIIlllIlllIIIIIlllIl = lllllllllllllIIlllIlllIIIIIllIlI.getModifiers();
        if (Modifier.isStatic(lllllllllllllIIlllIlllIIIIIllllI) != Modifier.isStatic(lllllllllllllIIlllIlllIIIIIlllIl) || (Modifier.isPrivate(lllllllllllllIIlllIlllIIIIIllllI) && !Modifier.isPrivate(lllllllllllllIIlllIlllIIIIIlllIl)) || lllllllllllllIIlllIlllIIIIIllIll.getDeclaringClass().isInterface() != lllllllllllllIIlllIlllIIIIIllIlI.getDeclaringClass().isInterface()) {
            throw new CannotCompileException(String.valueOf(new StringBuilder().append("invoke-type mismatch ").append(lllllllllllllIIlllIlllIIIIIllIlI.getLongName())));
        }
        this.transformers = new TransformCall(this.transformers, lllllllllllllIIlllIlllIIIIIllIll, lllllllllllllIIlllIlllIIIIIllIlI);
    }
    
    public void replaceNew(final CtClass lllllllllllllIIlllIlllIIIlIlllII, final CtClass lllllllllllllIIlllIlllIIIlIllIII) {
        this.transformers = new TransformNewClass(this.transformers, lllllllllllllIIlllIlllIIIlIlllII.getName(), lllllllllllllIIlllIlllIIIlIllIII.getName());
    }
    
    public void replaceNew(final CtClass lllllllllllllIIlllIlllIIIllIIlll, final CtClass lllllllllllllIIlllIlllIIIllIIllI, final String lllllllllllllIIlllIlllIIIllIIlIl) {
        this.transformers = new TransformNew(this.transformers, lllllllllllllIIlllIlllIIIllIIlll.getName(), lllllllllllllIIlllIlllIIIllIIllI.getName(), lllllllllllllIIlllIlllIIIllIIlIl);
    }
    
    public void replaceArrayAccess(final CtClass lllllllllllllIIlllIlllIIIIlIllll, final ArrayAccessReplacementMethodNames lllllllllllllIIlllIlllIIIIlIlllI) throws NotFoundException {
        this.transformers = new TransformAccessArrayField(this.transformers, lllllllllllllIIlllIlllIIIIlIllll.getName(), lllllllllllllIIlllIlllIIIIlIlllI);
    }
    
    public void insertBeforeMethod(final CtMethod lllllllllllllIIlllIllIlllllllIlI, final CtMethod lllllllllllllIIlllIllIlllllllIIl) throws CannotCompileException {
        try {
            this.transformers = new TransformBefore(this.transformers, lllllllllllllIIlllIllIlllllllIlI, lllllllllllllIIlllIllIlllllllIIl);
        }
        catch (NotFoundException lllllllllllllIIlllIllIllllllllll) {
            throw new CannotCompileException(lllllllllllllIIlllIllIllllllllll);
        }
    }
    
    public CodeConverter() {
        this.transformers = null;
    }
    
    public static class DefaultArrayAccessReplacementMethodNames implements ArrayAccessReplacementMethodNames
    {
        @Override
        public String charRead() {
            return "arrayReadChar";
        }
        
        @Override
        public String objectWrite() {
            return "arrayWriteObject";
        }
        
        @Override
        public String byteOrBooleanWrite() {
            return "arrayWriteByteOrBoolean";
        }
        
        @Override
        public String floatRead() {
            return "arrayReadFloat";
        }
        
        @Override
        public String floatWrite() {
            return "arrayWriteFloat";
        }
        
        @Override
        public String longWrite() {
            return "arrayWriteLong";
        }
        
        @Override
        public String objectRead() {
            return "arrayReadObject";
        }
        
        @Override
        public String shortRead() {
            return "arrayReadShort";
        }
        
        @Override
        public String intWrite() {
            return "arrayWriteInt";
        }
        
        @Override
        public String shortWrite() {
            return "arrayWriteShort";
        }
        
        @Override
        public String doubleRead() {
            return "arrayReadDouble";
        }
        
        @Override
        public String byteOrBooleanRead() {
            return "arrayReadByteOrBoolean";
        }
        
        @Override
        public String charWrite() {
            return "arrayWriteChar";
        }
        
        @Override
        public String intRead() {
            return "arrayReadInt";
        }
        
        @Override
        public String longRead() {
            return "arrayReadLong";
        }
        
        @Override
        public String doubleWrite() {
            return "arrayWriteDouble";
        }
    }
    
    public interface ArrayAccessReplacementMethodNames
    {
        String longRead();
        
        String doubleRead();
        
        String floatWrite();
        
        String objectWrite();
        
        String charWrite();
        
        String shortRead();
        
        String floatRead();
        
        String longWrite();
        
        String objectRead();
        
        String shortWrite();
        
        String byteOrBooleanWrite();
        
        String intRead();
        
        String charRead();
        
        String byteOrBooleanRead();
        
        String intWrite();
        
        String doubleWrite();
    }
}
