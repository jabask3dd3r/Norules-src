package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.annotation.*;

public class AnnotationsAttribute extends AttributeInfo
{
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIlIlIllIlIIIlIIlll, final Map<String, String> llllllllllllllIlIlIllIlIIIlIIIlI) {
        final Copier llllllllllllllIlIlIllIlIIIlIIlIl = new Copier(this.info, this.constPool, llllllllllllllIlIlIllIlIIIlIIlll, llllllllllllllIlIlIllIlIIIlIIIlI);
        try {
            llllllllllllllIlIlIllIlIIIlIIlIl.annotationArray();
            return new AnnotationsAttribute(llllllllllllllIlIlIllIlIIIlIIlll, this.getName(), llllllllllllllIlIlIllIlIIIlIIlIl.close());
        }
        catch (Exception llllllllllllllIlIlIllIlIIIlIlIIl) {
            throw new RuntimeException(llllllllllllllIlIlIllIlIIIlIlIIl);
        }
    }
    
    public void setAnnotation(final Annotation llllllllllllllIlIlIllIIllIIllIlI) {
        this.setAnnotations(new Annotation[] { llllllllllllllIlIlIllIIllIIllIlI });
    }
    
    @Override
    void renameClass(final String llllllllllllllIlIlIllIIllIIIlIll, final String llllllllllllllIlIlIllIIllIIIIllI) {
        final Map<String, String> llllllllllllllIlIlIllIIllIIIlIIl = new HashMap<String, String>();
        llllllllllllllIlIlIllIIllIIIlIIl.put(llllllllllllllIlIlIllIIllIIIlIll, llllllllllllllIlIlIllIIllIIIIllI);
        this.renameClass(llllllllllllllIlIlIllIIllIIIlIIl);
    }
    
    public AnnotationsAttribute(final ConstPool llllllllllllllIlIlIllIlIIlIIIIlI, final String llllllllllllllIlIlIllIlIIlIIIIIl) {
        this(llllllllllllllIlIlIllIlIIlIIIIlI, llllllllllllllIlIlIllIlIIlIIIIIl, new byte[] { 0, 0 });
    }
    
    public AnnotationsAttribute(final ConstPool llllllllllllllIlIlIllIlIIlIIllIl, final String llllllllllllllIlIlIllIlIIlIIllII, final byte[] llllllllllllllIlIlIllIlIIlIIIlll) {
        super(llllllllllllllIlIlIllIlIIlIIllIl, llllllllllllllIlIlIllIlIIlIIllII, llllllllllllllIlIlIllIlIIlIIIlll);
    }
    
    AnnotationsAttribute(final ConstPool llllllllllllllIlIlIllIlIIIlllIII, final int llllllllllllllIlIlIllIlIIIllIIll, final DataInputStream llllllllllllllIlIlIllIlIIIllIIlI) throws IOException {
        super(llllllllllllllIlIlIllIlIIIlllIII, llllllllllllllIlIlIllIlIIIllIIll, llllllllllllllIlIlIllIlIIIllIIlI);
    }
    
    public Annotation[] getAnnotations() {
        try {
            return new Parser(this.info, this.constPool).parseAnnotations();
        }
        catch (Exception llllllllllllllIlIlIllIIlllIIlIlI) {
            throw new RuntimeException(llllllllllllllIlIlIllIIlllIIlIlI);
        }
    }
    
    public int numAnnotations() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    public boolean removeAnnotation(final String llllllllllllllIlIlIllIIlllIlIlll) {
        final Annotation[] llllllllllllllIlIlIllIIlllIllIll = this.getAnnotations();
        for (int llllllllllllllIlIlIllIIllllIIIII = 0; llllllllllllllIlIlIllIIllllIIIII < llllllllllllllIlIlIllIIlllIllIll.length; ++llllllllllllllIlIlIllIIllllIIIII) {
            if (llllllllllllllIlIlIllIIlllIllIll[llllllllllllllIlIlIllIIllllIIIII].getTypeName().equals(llllllllllllllIlIlIllIIlllIlIlll)) {
                final Annotation[] llllllllllllllIlIlIllIIllllIIIlI = new Annotation[llllllllllllllIlIlIllIIlllIllIll.length - 1];
                System.arraycopy(llllllllllllllIlIlIllIIlllIllIll, 0, llllllllllllllIlIlIllIIllllIIIlI, 0, llllllllllllllIlIlIllIIllllIIIII);
                if (llllllllllllllIlIlIllIIllllIIIII < llllllllllllllIlIlIllIIlllIllIll.length - 1) {
                    System.arraycopy(llllllllllllllIlIlIllIIlllIllIll, llllllllllllllIlIlIllIIllllIIIII + 1, llllllllllllllIlIlIllIIllllIIIlI, llllllllllllllIlIlIllIIllllIIIII, llllllllllllllIlIlIllIIlllIllIll.length - llllllllllllllIlIlIllIIllllIIIII - 1);
                }
                this.setAnnotations(llllllllllllllIlIlIllIIllllIIIlI);
                return true;
            }
        }
        return false;
    }
    
    static {
        visibleTag = "RuntimeVisibleAnnotations";
        invisibleTag = "RuntimeInvisibleAnnotations";
    }
    
    @Override
    void renameClass(final Map<String, String> llllllllllllllIlIlIllIIlIllllIIl) {
        final Renamer llllllllllllllIlIlIllIIlIlllIlll = new Renamer(this.info, this.getConstPool(), llllllllllllllIlIlIllIIlIllllIIl);
        try {
            llllllllllllllIlIlIllIIlIlllIlll.annotationArray();
        }
        catch (Exception llllllllllllllIlIlIllIIlIlllllIl) {
            throw new RuntimeException(llllllllllllllIlIlIllIIlIlllllIl);
        }
    }
    
    public Annotation getAnnotation(final String llllllllllllllIlIlIllIlIIIIlIllI) {
        final Annotation[] llllllllllllllIlIlIllIlIIIIllIII = this.getAnnotations();
        for (int llllllllllllllIlIlIllIlIIIIllIll = 0; llllllllllllllIlIlIllIlIIIIllIll < llllllllllllllIlIlIllIlIIIIllIII.length; ++llllllllllllllIlIlIllIlIIIIllIll) {
            if (llllllllllllllIlIlIllIlIIIIllIII[llllllllllllllIlIlIllIlIIIIllIll].getTypeName().equals(llllllllllllllIlIlIllIlIIIIlIllI)) {
                return llllllllllllllIlIlIllIlIIIIllIII[llllllllllllllIlIlIllIlIIIIllIll];
            }
        }
        return null;
    }
    
    public void addAnnotation(final Annotation llllllllllllllIlIlIllIIlllllllIl) {
        final String llllllllllllllIlIlIllIlIIIIIIlII = llllllllllllllIlIlIllIIlllllllIl.getTypeName();
        final Annotation[] llllllllllllllIlIlIllIlIIIIIIIlI = this.getAnnotations();
        for (int llllllllllllllIlIlIllIlIIIIIlIIl = 0; llllllllllllllIlIlIllIlIIIIIlIIl < llllllllllllllIlIlIllIlIIIIIIIlI.length; ++llllllllllllllIlIlIllIlIIIIIlIIl) {
            if (llllllllllllllIlIlIllIlIIIIIIIlI[llllllllllllllIlIlIllIlIIIIIlIIl].getTypeName().equals(llllllllllllllIlIlIllIlIIIIIIlII)) {
                llllllllllllllIlIlIllIlIIIIIIIlI[llllllllllllllIlIlIllIlIIIIIlIIl] = llllllllllllllIlIlIllIIlllllllIl;
                this.setAnnotations(llllllllllllllIlIlIllIlIIIIIIIlI);
                return;
            }
        }
        final Annotation[] llllllllllllllIlIlIllIlIIIIIIIII = new Annotation[llllllllllllllIlIlIllIlIIIIIIIlI.length + 1];
        System.arraycopy(llllllllllllllIlIlIllIlIIIIIIIlI, 0, llllllllllllllIlIlIllIlIIIIIIIII, 0, llllllllllllllIlIlIllIlIIIIIIIlI.length);
        llllllllllllllIlIlIllIlIIIIIIIII[llllllllllllllIlIlIllIlIIIIIIIlI.length] = llllllllllllllIlIlIllIIlllllllIl;
        this.setAnnotations(llllllllllllllIlIlIllIlIIIIIIIII);
    }
    
    @Override
    void getRefClasses(final Map<String, String> llllllllllllllIlIlIllIIlIllIlIlI) {
        this.renameClass(llllllllllllllIlIlIllIIlIllIlIlI);
    }
    
    @Override
    public String toString() {
        final Annotation[] llllllllllllllIlIlIllIIlIllIIlII = this.getAnnotations();
        final StringBuilder llllllllllllllIlIlIllIIlIllIIIll = new StringBuilder();
        int llllllllllllllIlIlIllIIlIllIIIlI = 0;
        while (llllllllllllllIlIlIllIIlIllIIIlI < llllllllllllllIlIlIllIIlIllIIlII.length) {
            llllllllllllllIlIlIllIIlIllIIIll.append(llllllllllllllIlIlIllIIlIllIIlII[llllllllllllllIlIlIllIIlIllIIIlI++].toString());
            if (llllllllllllllIlIlIllIIlIllIIIlI != llllllllllllllIlIlIllIIlIllIIlII.length) {
                llllllllllllllIlIlIllIIlIllIIIll.append(", ");
            }
        }
        return String.valueOf(llllllllllllllIlIlIllIIlIllIIIll);
    }
    
    public void setAnnotations(final Annotation[] llllllllllllllIlIlIllIIllIlIlIlI) {
        final ByteArrayOutputStream llllllllllllllIlIlIllIIllIlIlIII = new ByteArrayOutputStream();
        final AnnotationsWriter llllllllllllllIlIlIllIIllIlIIllI = new AnnotationsWriter(llllllllllllllIlIlIllIIllIlIlIII, this.constPool);
        try {
            final int llllllllllllllIlIlIllIIllIlIlllI = llllllllllllllIlIlIllIIllIlIlIlI.length;
            llllllllllllllIlIlIllIIllIlIIllI.numAnnotations(llllllllllllllIlIlIllIIllIlIlllI);
            for (int llllllllllllllIlIlIllIIllIlIllll = 0; llllllllllllllIlIlIllIIllIlIllll < llllllllllllllIlIlIllIIllIlIlllI; ++llllllllllllllIlIlIllIIllIlIllll) {
                llllllllllllllIlIlIllIIllIlIlIlI[llllllllllllllIlIlIllIIllIlIllll].write(llllllllllllllIlIlIllIIllIlIIllI);
            }
            llllllllllllllIlIlIllIIllIlIIllI.close();
        }
        catch (IOException llllllllllllllIlIlIllIIllIlIllIl) {
            throw new RuntimeException(llllllllllllllIlIlIllIIllIlIllIl);
        }
        this.set(llllllllllllllIlIlIllIIllIlIlIII.toByteArray());
    }
    
    static class Walker
    {
        /* synthetic */ byte[] info;
        
        void parameters(final int lllllllllllllIlllIllllIIlIlIIlll, int lllllllllllllIlllIllllIIlIlIIllI) throws Exception {
            for (int lllllllllllllIlllIllllIIlIlIllII = 0; lllllllllllllIlllIllllIIlIlIllII < lllllllllllllIlllIllllIIlIlIIlll; ++lllllllllllllIlllIllllIIlIlIllII) {
                lllllllllllllIlllIllllIIlIlIIllI = this.annotationArray(lllllllllllllIlllIllllIIlIlIIllI);
            }
        }
        
        void classMemberValue(final int lllllllllllllIlllIllllIIIlIIIIlI, final int lllllllllllllIlllIllllIIIlIIIIIl) throws Exception {
        }
        
        final int annotation(final int lllllllllllllIlllIllllIIlIIIIlll) throws Exception {
            final int lllllllllllllIlllIllllIIlIIIIllI = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIlIIIIlll);
            final int lllllllllllllIlllIllllIIlIIIIlIl = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIlIIIIlll + 2);
            return this.annotation(lllllllllllllIlllIllllIIlIIIIlll + 4, lllllllllllllIlllIllllIIlIIIIllI, lllllllllllllIlllIllllIIlIIIIlIl);
        }
        
        void enumMemberValue(final int lllllllllllllIlllIllllIIIlIIIllI, final int lllllllllllllIlllIllllIIIlIIIlIl, final int lllllllllllllIlllIllllIIIlIIIlII) throws Exception {
        }
        
        Walker(final byte[] lllllllllllllIlllIllllIIlIlllIIl) {
            this.info = lllllllllllllIlllIllllIIlIlllIIl;
        }
        
        int memberValuePair(final int lllllllllllllIlllIllllIIIlIlllIl, final int lllllllllllllIlllIllllIIIlIlllll) throws Exception {
            return this.memberValue(lllllllllllllIlllIllllIIIlIlllIl);
        }
        
        int annotationArray(int lllllllllllllIlllIllllIIlIIIllll, final int lllllllllllllIlllIllllIIlIIlIIIl) throws Exception {
            for (int lllllllllllllIlllIllllIIlIIlIlII = 0; lllllllllllllIlllIllllIIlIIlIlII < lllllllllllllIlllIllllIIlIIlIIIl; ++lllllllllllllIlllIllllIIlIIlIlII) {
                lllllllllllllIlllIllllIIlIIIllll = this.annotation(lllllllllllllIlllIllllIIlIIIllll);
            }
            return lllllllllllllIlllIllllIIlIIIllll;
        }
        
        void constValueMember(final int lllllllllllllIlllIllllIIIlIIlIIl, final int lllllllllllllIlllIllllIIIlIIlIII) throws Exception {
        }
        
        int annotation(int lllllllllllllIlllIllllIIIlllIlIl, final int lllllllllllllIlllIllllIIIllllIIl, final int lllllllllllllIlllIllllIIIlllIlII) throws Exception {
            for (int lllllllllllllIlllIllllIIIlllllII = 0; lllllllllllllIlllIllllIIIlllllII < lllllllllllllIlllIllllIIIlllIlII; ++lllllllllllllIlllIllllIIIlllllII) {
                lllllllllllllIlllIllllIIIlllIlIl = this.memberValuePair(lllllllllllllIlllIllllIIIlllIlIl);
            }
            return lllllllllllllIlllIllllIIIlllIlIl;
        }
        
        final int memberValuePair(final int lllllllllllllIlllIllllIIIllIIlIl) throws Exception {
            final int lllllllllllllIlllIllllIIIllIIlll = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIIllIIlIl);
            return this.memberValuePair(lllllllllllllIlllIllllIIIllIIlIl + 2, lllllllllllllIlllIllllIIIllIIlll);
        }
        
        final void annotationArray() throws Exception {
            this.annotationArray(0);
        }
        
        final int annotationArray(final int lllllllllllllIlllIllllIIlIIllIlI) throws Exception {
            final int lllllllllllllIlllIllllIIlIIlllII = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIlIIllIlI);
            return this.annotationArray(lllllllllllllIlllIllllIIlIIllIlI + 2, lllllllllllllIlllIllllIIlIIlllII);
        }
        
        int arrayMemberValue(int lllllllllllllIlllIllllIIIIllIIIl, final int lllllllllllllIlllIllllIIIIllIIll) throws Exception {
            for (int lllllllllllllIlllIllllIIIIllIllI = 0; lllllllllllllIlllIllllIIIIllIllI < lllllllllllllIlllIllllIIIIllIIll; ++lllllllllllllIlllIllllIIIIllIllI) {
                lllllllllllllIlllIllllIIIIllIIIl = this.memberValue(lllllllllllllIlllIllllIIIIllIIIl);
            }
            return lllllllllllllIlllIllllIIIIllIIIl;
        }
        
        int annotationMemberValue(final int lllllllllllllIlllIllllIIIIlllIll) throws Exception {
            return this.annotation(lllllllllllllIlllIllllIIIIlllIll);
        }
        
        final void parameters() throws Exception {
            final int lllllllllllllIlllIllllIIlIllIIll = this.info[0] & 0xFF;
            this.parameters(lllllllllllllIlllIllllIIlIllIIll, 1);
        }
        
        final int memberValue(final int lllllllllllllIlllIllllIIIlIIlllI) throws Exception {
            final int lllllllllllllIlllIllllIIIlIlIIII = this.info[lllllllllllllIlllIllllIIIlIIlllI] & 0xFF;
            if (lllllllllllllIlllIllllIIIlIlIIII == 101) {
                final int lllllllllllllIlllIllllIIIlIlIlll = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIIlIIlllI + 1);
                final int lllllllllllllIlllIllllIIIlIlIllI = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIIlIIlllI + 3);
                this.enumMemberValue(lllllllllllllIlllIllllIIIlIIlllI, lllllllllllllIlllIllllIIIlIlIlll, lllllllllllllIlllIllllIIIlIlIllI);
                return lllllllllllllIlllIllllIIIlIIlllI + 5;
            }
            if (lllllllllllllIlllIllllIIIlIlIIII == 99) {
                final int lllllllllllllIlllIllllIIIlIlIlIl = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIIlIIlllI + 1);
                this.classMemberValue(lllllllllllllIlllIllllIIIlIIlllI, lllllllllllllIlllIllllIIIlIlIlIl);
                return lllllllllllllIlllIllllIIIlIIlllI + 3;
            }
            if (lllllllllllllIlllIllllIIIlIlIIII == 64) {
                return this.annotationMemberValue(lllllllllllllIlllIllllIIIlIIlllI + 1);
            }
            if (lllllllllllllIlllIllllIIIlIlIIII == 91) {
                final int lllllllllllllIlllIllllIIIlIlIlII = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIIlIIlllI + 1);
                return this.arrayMemberValue(lllllllllllllIlllIllllIIIlIIlllI + 3, lllllllllllllIlllIllllIIIlIlIlII);
            }
            final int lllllllllllllIlllIllllIIIlIlIIll = ByteArray.readU16bit(this.info, lllllllllllllIlllIllllIIIlIIlllI + 1);
            this.constValueMember(lllllllllllllIlllIllllIIIlIlIIII, lllllllllllllIlllIllllIIIlIlIIll);
            return lllllllllllllIlllIllllIIIlIIlllI + 3;
        }
    }
    
    static class Parser extends Walker
    {
        /* synthetic */ MemberValue currentMember;
        /* synthetic */ ConstPool pool;
        /* synthetic */ Annotation[][] allParams;
        /* synthetic */ Annotation currentAnno;
        /* synthetic */ Annotation[] allAnno;
        
        @Override
        int arrayMemberValue(int lllllllllllllIlIIIllIlIIlllIIlll, final int lllllllllllllIlIIIllIlIIlllIIlIl) throws Exception {
            final ArrayMemberValue lllllllllllllIlIIIllIlIIlllIllII = new ArrayMemberValue(this.pool);
            final MemberValue[] lllllllllllllIlIIIllIlIIlllIlIll = new MemberValue[lllllllllllllIlIIIllIlIIlllIIlIl];
            for (int lllllllllllllIlIIIllIlIIllllIIIl = 0; lllllllllllllIlIIIllIlIIllllIIIl < lllllllllllllIlIIIllIlIIlllIIlIl; ++lllllllllllllIlIIIllIlIIllllIIIl) {
                lllllllllllllIlIIIllIlIIlllIIlll = this.memberValue(lllllllllllllIlIIIllIlIIlllIIlll);
                lllllllllllllIlIIIllIlIIlllIlIll[lllllllllllllIlIIIllIlIIllllIIIl] = this.currentMember;
            }
            lllllllllllllIlIIIllIlIIlllIllII.setValue(lllllllllllllIlIIIllIlIIlllIlIll);
            this.currentMember = lllllllllllllIlIIIllIlIIlllIllII;
            return lllllllllllllIlIIIllIlIIlllIIlll;
        }
        
        Annotation[][] parseParameters() throws Exception {
            this.parameters();
            return this.allParams;
        }
        
        @Override
        void classMemberValue(final int lllllllllllllIlIIIllIlIlIIIlIIll, final int lllllllllllllIlIIIllIlIlIIIlIllI) throws Exception {
            this.currentMember = new ClassMemberValue(lllllllllllllIlIIIllIlIlIIIlIllI, this.pool);
            super.classMemberValue(lllllllllllllIlIIIllIlIlIIIlIIll, lllllllllllllIlIIIllIlIlIIIlIllI);
        }
        
        @Override
        void parameters(final int lllllllllllllIlIIIllIlIlIllIllII, int lllllllllllllIlIIIllIlIlIllIlIll) throws Exception {
            final Annotation[][] lllllllllllllIlIIIllIlIlIllIlllI = new Annotation[lllllllllllllIlIIIllIlIlIllIllII][];
            for (int lllllllllllllIlIIIllIlIlIlllIIlI = 0; lllllllllllllIlIIIllIlIlIlllIIlI < lllllllllllllIlIIIllIlIlIllIllII; ++lllllllllllllIlIIIllIlIlIlllIIlI) {
                lllllllllllllIlIIIllIlIlIllIlIll = this.annotationArray(lllllllllllllIlIIIllIlIlIllIlIll);
                lllllllllllllIlIIIllIlIlIllIlllI[lllllllllllllIlIIIllIlIlIlllIIlI] = this.allAnno;
            }
            this.allParams = lllllllllllllIlIIIllIlIlIllIlllI;
        }
        
        @Override
        void constValueMember(final int lllllllllllllIlIIIllIlIlIIllIlIl, final int lllllllllllllIlIIIllIlIlIIllIlII) throws Exception {
            final ConstPool lllllllllllllIlIIIllIlIlIIllIIlI = this.pool;
            switch (lllllllllllllIlIIIllIlIlIIllIlIl) {
                case 66: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIllllll = new ByteMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 67: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIlllllI = new CharMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 68: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIllllIl = new DoubleMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 70: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIllllII = new FloatMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 73: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIlllIll = new IntegerMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 74: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIlllIlI = new LongMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 83: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIlllIIl = new ShortMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 90: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIlllIII = new BooleanMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                case 115: {
                    final MemberValue lllllllllllllIlIIIllIlIlIIllIlll = new StringMemberValue(lllllllllllllIlIIIllIlIlIIllIlII, lllllllllllllIlIIIllIlIlIIllIIlI);
                    break;
                }
                default: {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append("unknown tag:").append(lllllllllllllIlIIIllIlIlIIllIlIl)));
                }
            }
            final MemberValue lllllllllllllIlIIIllIlIlIIllIIll;
            this.currentMember = lllllllllllllIlIIIllIlIlIIllIIll;
            super.constValueMember(lllllllllllllIlIIIllIlIlIIllIlIl, lllllllllllllIlIIIllIlIlIIllIlII);
        }
        
        Annotation[] parseAnnotations() throws Exception {
            this.annotationArray();
            return this.allAnno;
        }
        
        @Override
        int memberValuePair(int lllllllllllllIlIIIllIlIlIlIIIllI, final int lllllllllllllIlIIIllIlIlIlIIlIII) throws Exception {
            lllllllllllllIlIIIllIlIlIlIIIllI = super.memberValuePair((int)lllllllllllllIlIIIllIlIlIlIIIllI, lllllllllllllIlIIIllIlIlIlIIlIII);
            this.currentAnno.addMemberValue(lllllllllllllIlIIIllIlIlIlIIlIII, this.currentMember);
            return (int)lllllllllllllIlIIIllIlIlIlIIIllI;
        }
        
        Parser(final byte[] lllllllllllllIlIIIllIlIllIIIIlIl, final ConstPool lllllllllllllIlIIIllIlIllIIIIIIl) {
            super(lllllllllllllIlIIIllIlIllIIIIlIl);
            this.pool = lllllllllllllIlIIIllIlIllIIIIIIl;
        }
        
        @Override
        int annotationMemberValue(int lllllllllllllIlIIIllIlIlIIIIIlIl) throws Exception {
            final Annotation lllllllllllllIlIIIllIlIlIIIIlIIl = this.currentAnno;
            lllllllllllllIlIIIllIlIlIIIIIlIl = super.annotationMemberValue((int)lllllllllllllIlIIIllIlIlIIIIIlIl);
            this.currentMember = new AnnotationMemberValue(this.currentAnno, this.pool);
            this.currentAnno = lllllllllllllIlIIIllIlIlIIIIlIIl;
            return (int)lllllllllllllIlIIIllIlIlIIIIIlIl;
        }
        
        MemberValue parseMemberValue() throws Exception {
            this.memberValue(0);
            return this.currentMember;
        }
        
        @Override
        int annotationArray(int lllllllllllllIlIIIllIlIlIlIlllIl, final int lllllllllllllIlIIIllIlIlIllIIIII) throws Exception {
            final Annotation[] lllllllllllllIlIIIllIlIlIlIlllll = new Annotation[lllllllllllllIlIIIllIlIlIllIIIII];
            for (int lllllllllllllIlIIIllIlIlIllIIIll = 0; lllllllllllllIlIIIllIlIlIllIIIll < lllllllllllllIlIIIllIlIlIllIIIII; ++lllllllllllllIlIIIllIlIlIllIIIll) {
                lllllllllllllIlIIIllIlIlIlIlllIl = this.annotation(lllllllllllllIlIIIllIlIlIlIlllIl);
                lllllllllllllIlIIIllIlIlIlIlllll[lllllllllllllIlIIIllIlIlIllIIIll] = this.currentAnno;
            }
            this.allAnno = lllllllllllllIlIIIllIlIlIlIlllll;
            return lllllllllllllIlIIIllIlIlIlIlllIl;
        }
        
        @Override
        void enumMemberValue(final int lllllllllllllIlIIIllIlIlIIlIIIll, final int lllllllllllllIlIIIllIlIlIIlIIIlI, final int lllllllllllllIlIIIllIlIlIIlIIlIl) throws Exception {
            this.currentMember = new EnumMemberValue(lllllllllllllIlIIIllIlIlIIlIIIlI, lllllllllllllIlIIIllIlIlIIlIIlIl, this.pool);
            super.enumMemberValue(lllllllllllllIlIIIllIlIlIIlIIIll, lllllllllllllIlIIIllIlIlIIlIIIlI, lllllllllllllIlIIIllIlIlIIlIIlIl);
        }
        
        @Override
        int annotation(final int lllllllllllllIlIIIllIlIlIlIlIlII, final int lllllllllllllIlIIIllIlIlIlIlIIll, final int lllllllllllllIlIIIllIlIlIlIlIIlI) throws Exception {
            this.currentAnno = new Annotation(lllllllllllllIlIIIllIlIlIlIlIIll, this.pool);
            return super.annotation(lllllllllllllIlIIIllIlIlIlIlIlII, lllllllllllllIlIIIllIlIlIlIlIIll, lllllllllllllIlIIIllIlIlIlIlIIlI);
        }
    }
    
    static class Copier extends Walker
    {
        /* synthetic */ Map<String, String> classnames;
        /* synthetic */ AnnotationsWriter writer;
        /* synthetic */ ConstPool srcPool;
        /* synthetic */ ByteArrayOutputStream output;
        /* synthetic */ ConstPool destPool;
        
        Copier(final byte[] lllllllllllllIIllIllIIlIIIIlIllI, final ConstPool lllllllllllllIIllIllIIlIIIIllIll, final ConstPool lllllllllllllIIllIllIIlIIIIllIlI, final Map<String, String> lllllllllllllIIllIllIIlIIIIllIIl, final boolean lllllllllllllIIllIllIIlIIIIllIII) {
            super(lllllllllllllIIllIllIIlIIIIlIllI);
            this.output = new ByteArrayOutputStream();
            if (lllllllllllllIIllIllIIlIIIIllIII) {
                this.writer = new AnnotationsWriter(this.output, lllllllllllllIIllIllIIlIIIIllIlI);
            }
            this.srcPool = lllllllllllllIIllIllIIlIIIIllIll;
            this.destPool = lllllllllllllIIllIllIIlIIIIllIlI;
            this.classnames = lllllllllllllIIllIllIIlIIIIllIIl;
        }
        
        @Override
        int annotationArray(final int lllllllllllllIIllIllIIlIIIIIIIIl, final int lllllllllllllIIllIllIIIlllllllIl) throws Exception {
            this.writer.numAnnotations(lllllllllllllIIllIllIIIlllllllIl);
            return super.annotationArray(lllllllllllllIIllIllIIlIIIIIIIIl, lllllllllllllIIllIllIIIlllllllIl);
        }
        
        @Override
        void parameters(final int lllllllllllllIIllIllIIlIIIIIIlll, final int lllllllllllllIIllIllIIlIIIIIlIIl) throws Exception {
            this.writer.numParameters(lllllllllllllIIllIllIIlIIIIIIlll);
            super.parameters(lllllllllllllIIllIllIIlIIIIIIlll, lllllllllllllIIllIllIIlIIIIIlIIl);
        }
        
        Copier(final byte[] lllllllllllllIIllIllIIlIIIlIIlll, final ConstPool lllllllllllllIIllIllIIlIIIlIIllI, final ConstPool lllllllllllllIIllIllIIlIIIlIlIlI, final Map<String, String> lllllllllllllIIllIllIIlIIIlIIlII) {
            this(lllllllllllllIIllIllIIlIIIlIIlll, lllllllllllllIIllIllIIlIIIlIIllI, lllllllllllllIIllIllIIlIIIlIlIlI, lllllllllllllIIllIllIIlIIIlIIlII, true);
        }
        
        @Override
        int annotationMemberValue(final int lllllllllllllIIllIllIIIlllIIIlII) throws Exception {
            this.writer.annotationValue();
            return super.annotationMemberValue(lllllllllllllIIllIllIIIlllIIIlII);
        }
        
        @Override
        int arrayMemberValue(final int lllllllllllllIIllIllIIIllIllllll, final int lllllllllllllIIllIllIIIllIlllllI) throws Exception {
            this.writer.arrayValue(lllllllllllllIIllIllIIIllIlllllI);
            return super.arrayMemberValue(lllllllllllllIIllIllIIIllIllllll, lllllllllllllIIllIllIIIllIlllllI);
        }
        
        byte[] close() throws IOException {
            this.writer.close();
            return this.output.toByteArray();
        }
        
        int copyType(final int lllllllllllllIIllIllIIIllIlIlIll) {
            final String lllllllllllllIIllIllIIIllIlIlllI = this.srcPool.getUtf8Info(lllllllllllllIIllIllIIIllIlIlIll);
            final String lllllllllllllIIllIllIIIllIlIllIl = Descriptor.rename(lllllllllllllIIllIllIIIllIlIlllI, this.classnames);
            return this.destPool.addUtf8Info(lllllllllllllIIllIllIIIllIlIllIl);
        }
        
        int copy(final int lllllllllllllIIllIllIIIllIllIlll) {
            return this.srcPool.copy(lllllllllllllIIllIllIIIllIllIlll, this.destPool, this.classnames);
        }
        
        @Override
        void classMemberValue(final int lllllllllllllIIllIllIIIlllIIlIll, final int lllllllllllllIIllIllIIIlllIIllIl) throws Exception {
            this.writer.classInfoIndex(this.copyType(lllllllllllllIIllIllIIIlllIIllIl));
            super.classMemberValue(lllllllllllllIIllIllIIIlllIIlIll, lllllllllllllIIllIllIIIlllIIllIl);
        }
        
        @Override
        void enumMemberValue(final int lllllllllllllIIllIllIIIlllIllIIl, final int lllllllllllllIIllIllIIIlllIlIlII, final int lllllllllllllIIllIllIIIlllIlIlll) throws Exception {
            this.writer.enumConstValue(this.copyType(lllllllllllllIIllIllIIIlllIlIlII), this.copy(lllllllllllllIIllIllIIIlllIlIlll));
            super.enumMemberValue(lllllllllllllIIllIllIIIlllIllIIl, lllllllllllllIIllIllIIIlllIlIlII, lllllllllllllIIllIllIIIlllIlIlll);
        }
        
        @Override
        void constValueMember(final int lllllllllllllIIllIllIIIllllIIIll, final int lllllllllllllIIllIllIIIlllIlllll) throws Exception {
            this.writer.constValueIndex(lllllllllllllIIllIllIIIllllIIIll, this.copy(lllllllllllllIIllIllIIIlllIlllll));
            super.constValueMember(lllllllllllllIIllIllIIIllllIIIll, lllllllllllllIIllIllIIIlllIlllll);
        }
        
        @Override
        int annotation(final int lllllllllllllIIllIllIIIlllllIlll, final int lllllllllllllIIllIllIIIlllllIIlI, final int lllllllllllllIIllIllIIIlllllIlIl) throws Exception {
            this.writer.annotation(this.copyType(lllllllllllllIIllIllIIIlllllIIlI), lllllllllllllIIllIllIIIlllllIlIl);
            return super.annotation(lllllllllllllIIllIllIIIlllllIlll, lllllllllllllIIllIllIIIlllllIIlI, lllllllllllllIIllIllIIIlllllIlIl);
        }
        
        @Override
        int memberValuePair(final int lllllllllllllIIllIllIIIllllIllII, final int lllllllllllllIIllIllIIIllllIlIll) throws Exception {
            this.writer.memberValuePair(this.copy(lllllllllllllIIllIllIIIllllIlIll));
            return super.memberValuePair(lllllllllllllIIllIllIIIllllIllII, lllllllllllllIIllIllIIIllllIlIll);
        }
    }
    
    static class Renamer extends Walker
    {
        /* synthetic */ Map<String, String> classnames;
        /* synthetic */ ConstPool cpool;
        
        Renamer(final byte[] lllllllllllllllIlIIlIIlIllIlIIlI, final ConstPool lllllllllllllllIlIIlIIlIllIlIlIl, final Map<String, String> lllllllllllllllIlIIlIIlIllIlIIII) {
            super(lllllllllllllllIlIIlIIlIllIlIIlI);
            this.cpool = lllllllllllllllIlIIlIIlIllIlIlIl;
            this.classnames = lllllllllllllllIlIIlIIlIllIlIIII;
        }
        
        @Override
        int annotation(final int lllllllllllllllIlIIlIIlIllIIlIlI, final int lllllllllllllllIlIIlIIlIllIIlIIl, final int lllllllllllllllIlIIlIIlIllIIIlII) throws Exception {
            this.renameType(lllllllllllllllIlIIlIIlIllIIlIlI - 4, lllllllllllllllIlIIlIIlIllIIlIIl);
            return super.annotation(lllllllllllllllIlIIlIIlIllIIlIlI, lllllllllllllllIlIIlIIlIllIIlIIl, lllllllllllllllIlIIlIIlIllIIIlII);
        }
        
        @Override
        void enumMemberValue(final int lllllllllllllllIlIIlIIlIlIlllllI, final int lllllllllllllllIlIIlIIlIlIlllIIl, final int lllllllllllllllIlIIlIIlIlIllllII) throws Exception {
            this.renameType(lllllllllllllllIlIIlIIlIlIlllllI + 1, lllllllllllllllIlIIlIIlIlIlllIIl);
            super.enumMemberValue(lllllllllllllllIlIIlIIlIlIlllllI, lllllllllllllllIlIIlIIlIlIlllIIl, lllllllllllllllIlIIlIIlIlIllllII);
        }
        
        private void renameType(final int lllllllllllllllIlIIlIIlIlIlIIIIl, final int lllllllllllllllIlIIlIIlIlIlIIlIl) {
            final String lllllllllllllllIlIIlIIlIlIlIIlII = this.cpool.getUtf8Info(lllllllllllllllIlIIlIIlIlIlIIlIl);
            final String lllllllllllllllIlIIlIIlIlIlIIIll = Descriptor.rename(lllllllllllllllIlIIlIIlIlIlIIlII, this.classnames);
            if (!lllllllllllllllIlIIlIIlIlIlIIlII.equals(lllllllllllllllIlIIlIIlIlIlIIIll)) {
                final int lllllllllllllllIlIIlIIlIlIlIlIII = this.cpool.addUtf8Info(lllllllllllllllIlIIlIIlIlIlIIIll);
                ByteArray.write16bit(lllllllllllllllIlIIlIIlIlIlIlIII, this.info, lllllllllllllllIlIIlIIlIlIlIIIIl);
            }
        }
        
        @Override
        void classMemberValue(final int lllllllllllllllIlIIlIIlIlIllIIll, final int lllllllllllllllIlIIlIIlIlIllIIlI) throws Exception {
            this.renameType(lllllllllllllllIlIIlIIlIlIllIIll + 1, lllllllllllllllIlIIlIIlIlIllIIlI);
            super.classMemberValue(lllllllllllllllIlIIlIIlIlIllIIll, lllllllllllllllIlIIlIIlIlIllIIlI);
        }
    }
}
