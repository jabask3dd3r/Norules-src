package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.annotation.*;
import java.io.*;

public class TypeAnnotationsAttribute extends AttributeInfo
{
    static {
        visibleTag = "RuntimeVisibleTypeAnnotations";
        invisibleTag = "RuntimeInvisibleTypeAnnotations";
    }
    
    TypeAnnotationsAttribute(final ConstPool lllllllllllllIIIIIlIIIlIIIIlIllI, final int lllllllllllllIIIIIlIIIlIIIIllIIl, final DataInputStream lllllllllllllIIIIIlIIIlIIIIllIII) throws IOException {
        super(lllllllllllllIIIIIlIIIlIIIIlIllI, lllllllllllllIIIIIlIIIlIIIIllIIl, lllllllllllllIIIIIlIIIlIIIIllIII);
    }
    
    public TypeAnnotationsAttribute(final ConstPool lllllllllllllIIIIIlIIIlIIIlIIIlI, final String lllllllllllllIIIIIlIIIlIIIlIIIIl, final byte[] lllllllllllllIIIIIlIIIlIIIlIIIII) {
        super(lllllllllllllIIIIIlIIIlIIIlIIIlI, lllllllllllllIIIIIlIIIlIIIlIIIIl, lllllllllllllIIIIIlIIIlIIIlIIIII);
    }
    
    @Override
    void renameClass(final Map<String, String> lllllllllllllIIIIIlIIIIllllIllll) {
        final Renamer lllllllllllllIIIIIlIIIIllllIlllI = new Renamer(this.info, this.getConstPool(), lllllllllllllIIIIIlIIIIllllIllll);
        try {
            lllllllllllllIIIIIlIIIIllllIlllI.annotationArray();
        }
        catch (Exception lllllllllllllIIIIIlIIIIlllllIIIl) {
            throw new RuntimeException(lllllllllllllIIIIIlIIIIlllllIIIl);
        }
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIIIIIlIIIlIIIIIlIIl, final Map<String, String> lllllllllllllIIIIIlIIIlIIIIIIlII) {
        final Copier lllllllllllllIIIIIlIIIlIIIIIIlll = new Copier(this.info, this.constPool, lllllllllllllIIIIIlIIIlIIIIIlIIl, lllllllllllllIIIIIlIIIlIIIIIIlII);
        try {
            lllllllllllllIIIIIlIIIlIIIIIIlll.annotationArray();
            return new TypeAnnotationsAttribute(lllllllllllllIIIIIlIIIlIIIIIlIIl, this.getName(), lllllllllllllIIIIIlIIIlIIIIIIlll.close());
        }
        catch (Exception lllllllllllllIIIIIlIIIlIIIIIlIll) {
            throw new RuntimeException(lllllllllllllIIIIIlIIIlIIIIIlIll);
        }
    }
    
    public int numAnnotations() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    @Override
    void renameClass(final String lllllllllllllIIIIIlIIIIlllllllII, final String lllllllllllllIIIIIlIIIIllllllIll) {
        final Map<String, String> lllllllllllllIIIIIlIIIIllllllIlI = new HashMap<String, String>();
        lllllllllllllIIIIIlIIIIllllllIlI.put(lllllllllllllIIIIIlIIIIlllllllII, lllllllllllllIIIIIlIIIIllllllIll);
        this.renameClass(lllllllllllllIIIIIlIIIIllllllIlI);
    }
    
    @Override
    void getRefClasses(final Map<String, String> lllllllllllllIIIIIlIIIIllllIIlII) {
        this.renameClass(lllllllllllllIIIIIlIIIIllllIIlII);
    }
    
    static class SubWalker
    {
        /* synthetic */ byte[] info;
        
        void typeParameterBoundTarget(final int llllllllllllllllllIIIIIllIIlllIl, final int llllllllllllllllllIIIIIllIIlllII, final int llllllllllllllllllIIIIIllIIllIll, final int llllllllllllllllllIIIIIllIIllIlI) throws Exception {
        }
        
        final int targetInfo(final int llllllllllllllllllIIIIIllIlIllII, final int llllllllllllllllllIIIIIllIlIlIII) throws Exception {
            switch (llllllllllllllllllIIIIIllIlIlIII) {
                case 0:
                case 1: {
                    final int llllllllllllllllllIIIIIllIlllIII = this.info[llllllllllllllllllIIIIIllIlIllII] & 0xFF;
                    this.typeParameterTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIlIlIII, llllllllllllllllllIIIIIllIlllIII);
                    return llllllllllllllllllIIIIIllIlIllII + 1;
                }
                case 16: {
                    final int llllllllllllllllllIIIIIllIllIlll = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIllIlIllII);
                    this.supertypeTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIllIlll);
                    return llllllllllllllllllIIIIIllIlIllII + 2;
                }
                case 17:
                case 18: {
                    final int llllllllllllllllllIIIIIllIllIllI = this.info[llllllllllllllllllIIIIIllIlIllII] & 0xFF;
                    final int llllllllllllllllllIIIIIllIllIlIl = this.info[llllllllllllllllllIIIIIllIlIllII + 1] & 0xFF;
                    this.typeParameterBoundTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIlIlIII, llllllllllllllllllIIIIIllIllIllI, llllllllllllllllllIIIIIllIllIlIl);
                    return llllllllllllllllllIIIIIllIlIllII + 2;
                }
                case 19:
                case 20:
                case 21: {
                    this.emptyTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIlIlIII);
                    return llllllllllllllllllIIIIIllIlIllII;
                }
                case 22: {
                    final int llllllllllllllllllIIIIIllIllIlII = this.info[llllllllllllllllllIIIIIllIlIllII] & 0xFF;
                    this.formalParameterTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIllIlII);
                    return llllllllllllllllllIIIIIllIlIllII + 1;
                }
                case 23: {
                    final int llllllllllllllllllIIIIIllIllIIll = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIllIlIllII);
                    this.throwsTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIllIIll);
                    return llllllllllllllllllIIIIIllIlIllII + 2;
                }
                case 64:
                case 65: {
                    final int llllllllllllllllllIIIIIllIllIIlI = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIllIlIllII);
                    return this.localvarTarget(llllllllllllllllllIIIIIllIlIllII + 2, llllllllllllllllllIIIIIllIlIlIII, llllllllllllllllllIIIIIllIllIIlI);
                }
                case 66: {
                    final int llllllllllllllllllIIIIIllIllIIIl = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIllIlIllII);
                    this.catchTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIllIIIl);
                    return llllllllllllllllllIIIIIllIlIllII + 2;
                }
                case 67:
                case 68:
                case 69:
                case 70: {
                    final int llllllllllllllllllIIIIIllIllIIII = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIllIlIllII);
                    this.offsetTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIlIlIII, llllllllllllllllllIIIIIllIllIIII);
                    return llllllllllllllllllIIIIIllIlIllII + 2;
                }
                case 71:
                case 72:
                case 73:
                case 74:
                case 75: {
                    final int llllllllllllllllllIIIIIllIlIllll = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIllIlIllII);
                    final int llllllllllllllllllIIIIIllIlIlllI = this.info[llllllllllllllllllIIIIIllIlIllII + 2] & 0xFF;
                    this.typeArgumentTarget(llllllllllllllllllIIIIIllIlIllII, llllllllllllllllllIIIIIllIlIlIII, llllllllllllllllllIIIIIllIlIllll, llllllllllllllllllIIIIIllIlIlllI);
                    return llllllllllllllllllIIIIIllIlIllII + 3;
                }
                default: {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append("invalid target type: ").append(llllllllllllllllllIIIIIllIlIlIII)));
                }
            }
        }
        
        void emptyTarget(final int llllllllllllllllllIIIIIllIIllIII, final int llllllllllllllllllIIIIIllIIlIlll) throws Exception {
        }
        
        void formalParameterTarget(final int llllllllllllllllllIIIIIllIIlIlIl, final int llllllllllllllllllIIIIIllIIlIlII) throws Exception {
        }
        
        int localvarTarget(int llllllllllllllllllIIIIIlIlllllll, final int llllllllllllllllllIIIIIllIIIIIlI, final int llllllllllllllllllIIIIIllIIIIIIl) throws Exception {
            for (int llllllllllllllllllIIIIIllIIIIlIl = 0; llllllllllllllllllIIIIIllIIIIlIl < llllllllllllllllllIIIIIllIIIIIIl; ++llllllllllllllllllIIIIIllIIIIlIl) {
                final int llllllllllllllllllIIIIIllIIIlIII = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIlIlllllll);
                final int llllllllllllllllllIIIIIllIIIIlll = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIlIlllllll + 2);
                final int llllllllllllllllllIIIIIllIIIIllI = ByteArray.readU16bit(this.info, llllllllllllllllllIIIIIlIlllllll + 4);
                this.localvarTarget(llllllllllllllllllIIIIIlIlllllll, llllllllllllllllllIIIIIllIIIIIlI, llllllllllllllllllIIIIIllIIIlIII, llllllllllllllllllIIIIIllIIIIlll, llllllllllllllllllIIIIIllIIIIllI);
                llllllllllllllllllIIIIIlIlllllll += 6;
            }
            return llllllllllllllllllIIIIIlIlllllll;
        }
        
        final int typePath(int llllllllllllllllllIIIIIlIlIlllll) throws Exception {
            final int llllllllllllllllllIIIIIlIllIIIIl = this.info[llllllllllllllllllIIIIIlIlIlllll++] & 0xFF;
            return this.typePath(llllllllllllllllllIIIIIlIlIlllll, llllllllllllllllllIIIIIlIllIIIIl);
        }
        
        int typePath(int llllllllllllllllllIIIIIlIlIlIIII, final int llllllllllllllllllIIIIIlIlIlIIlI) throws Exception {
            for (int llllllllllllllllllIIIIIlIlIlIlIl = 0; llllllllllllllllllIIIIIlIlIlIlIl < llllllllllllllllllIIIIIlIlIlIIlI; ++llllllllllllllllllIIIIIlIlIlIlIl) {
                final int llllllllllllllllllIIIIIlIlIlIlll = this.info[llllllllllllllllllIIIIIlIlIlIIII] & 0xFF;
                final int llllllllllllllllllIIIIIlIlIlIllI = this.info[llllllllllllllllllIIIIIlIlIlIIII + 1] & 0xFF;
                this.typePath(llllllllllllllllllIIIIIlIlIlIIII, llllllllllllllllllIIIIIlIlIlIlll, llllllllllllllllllIIIIIlIlIlIllI);
                llllllllllllllllllIIIIIlIlIlIIII += 2;
            }
            return llllllllllllllllllIIIIIlIlIlIIII;
        }
        
        void typeParameterTarget(final int llllllllllllllllllIIIIIllIlIIlII, final int llllllllllllllllllIIIIIllIlIIIll, final int llllllllllllllllllIIIIIllIlIIIlI) throws Exception {
        }
        
        void supertypeTarget(final int llllllllllllllllllIIIIIllIlIIIII, final int llllllllllllllllllIIIIIllIIlllll) throws Exception {
        }
        
        void offsetTarget(final int llllllllllllllllllIIIIIlIllIlllI, final int llllllllllllllllllIIIIIlIllIllIl, final int llllllllllllllllllIIIIIlIllIllII) throws Exception {
        }
        
        void catchTarget(final int llllllllllllllllllIIIIIlIlllIIIl, final int llllllllllllllllllIIIIIlIlllIIII) throws Exception {
        }
        
        void typePath(final int llllllllllllllllllIIIIIlIlIIlIlI, final int llllllllllllllllllIIIIIlIlIIlIIl, final int llllllllllllllllllIIIIIlIlIIlIII) throws Exception {
        }
        
        void localvarTarget(final int llllllllllllllllllIIIIIlIlllIlll, final int llllllllllllllllllIIIIIlIlllIllI, final int llllllllllllllllllIIIIIlIlllIlIl, final int llllllllllllllllllIIIIIlIlllIlII, final int llllllllllllllllllIIIIIlIlllIIll) throws Exception {
        }
        
        void typeArgumentTarget(final int llllllllllllllllllIIIIIlIllIlIlI, final int llllllllllllllllllIIIIIlIllIlIIl, final int llllllllllllllllllIIIIIlIllIlIII, final int llllllllllllllllllIIIIIlIllIIlll) throws Exception {
        }
        
        void throwsTarget(final int llllllllllllllllllIIIIIllIIlIIlI, final int llllllllllllllllllIIIIIllIIlIIIl) throws Exception {
        }
        
        SubWalker(final byte[] llllllllllllllllllIIIIIlllIIIIII) {
            this.info = llllllllllllllllllIIIIIlllIIIIII;
        }
    }
    
    static class TAWalker extends AnnotationsAttribute.Walker
    {
        /* synthetic */ SubWalker subWalker;
        
        @Override
        int annotationArray(int lllllllllllllllIIIIIIIlIIllIIIll, final int lllllllllllllllIIIIIIIlIIllIIlIl) throws Exception {
            for (int lllllllllllllllIIIIIIIlIIllIlIII = 0; lllllllllllllllIIIIIIIlIIllIlIII < lllllllllllllllIIIIIIIlIIllIIlIl; ++lllllllllllllllIIIIIIIlIIllIlIII) {
                final int lllllllllllllllIIIIIIIlIIllIlIIl = this.info[lllllllllllllllIIIIIIIlIIllIIIll] & 0xFF;
                lllllllllllllllIIIIIIIlIIllIIIll = this.subWalker.targetInfo(lllllllllllllllIIIIIIIlIIllIIIll + 1, lllllllllllllllIIIIIIIlIIllIlIIl);
                lllllllllllllllIIIIIIIlIIllIIIll = this.subWalker.typePath(lllllllllllllllIIIIIIIlIIllIIIll);
                lllllllllllllllIIIIIIIlIIllIIIll = this.annotation(lllllllllllllllIIIIIIIlIIllIIIll);
            }
            return lllllllllllllllIIIIIIIlIIllIIIll;
        }
        
        TAWalker(final byte[] lllllllllllllllIIIIIIIlIIllIllll) {
            super(lllllllllllllllIIIIIIIlIIllIllll);
            this.subWalker = new SubWalker(lllllllllllllllIIIIIIIlIIllIllll);
        }
    }
    
    static class Copier extends AnnotationsAttribute.Copier
    {
        /* synthetic */ SubCopier sub;
        
        @Override
        int annotationArray(int lllllllllllllIIIIIlIIIIllIlIllII, final int lllllllllllllIIIIIlIIIIllIlIlllI) throws Exception {
            this.writer.numAnnotations(lllllllllllllIIIIIlIIIIllIlIlllI);
            for (int lllllllllllllIIIIIlIIIIllIllIIIl = 0; lllllllllllllIIIIIlIIIIllIllIIIl < lllllllllllllIIIIIlIIIIllIlIlllI; ++lllllllllllllIIIIIlIIIIllIllIIIl) {
                final int lllllllllllllIIIIIlIIIIllIllIIlI = this.info[lllllllllllllIIIIIlIIIIllIlIllII] & 0xFF;
                lllllllllllllIIIIIlIIIIllIlIllII = this.sub.targetInfo(lllllllllllllIIIIIlIIIIllIlIllII + 1, lllllllllllllIIIIIlIIIIllIllIIlI);
                lllllllllllllIIIIIlIIIIllIlIllII = this.sub.typePath(lllllllllllllIIIIIlIIIIllIlIllII);
                lllllllllllllIIIIIlIIIIllIlIllII = this.annotation(lllllllllllllIIIIIlIIIIllIlIllII);
            }
            return lllllllllllllIIIIIlIIIIllIlIllII;
        }
        
        Copier(final byte[] lllllllllllllIIIIIlIIIIllIllllII, final ConstPool lllllllllllllIIIIIlIIIIllIlllIll, final ConstPool lllllllllllllIIIIIlIIIIllIlllIlI, final Map<String, String> lllllllllllllIIIIIlIIIIllIlllIIl) {
            super(lllllllllllllIIIIIlIIIIllIllllII, lllllllllllllIIIIIlIIIIllIlllIll, lllllllllllllIIIIIlIIIIllIlllIlI, lllllllllllllIIIIIlIIIIllIlllIIl, false);
            final TypeAnnotationsWriter lllllllllllllIIIIIlIIIIllIlllllI = new TypeAnnotationsWriter(this.output, lllllllllllllIIIIIlIIIIllIlllIlI);
            this.writer = lllllllllllllIIIIIlIIIIllIlllllI;
            this.sub = new SubCopier(lllllllllllllIIIIIlIIIIllIllllII, lllllllllllllIIIIIlIIIIllIlllIll, lllllllllllllIIIIIlIIIIllIlllIlI, lllllllllllllIIIIIlIIIIllIlllIIl, lllllllllllllIIIIIlIIIIllIlllllI);
        }
    }
    
    static class SubCopier extends SubWalker
    {
        /* synthetic */ TypeAnnotationsWriter writer;
        /* synthetic */ ConstPool destPool;
        /* synthetic */ Map<String, String> classnames;
        /* synthetic */ ConstPool srcPool;
        
        @Override
        void typePath(final int llllllllllllllIlIllllllIlIlIIlIl, final int llllllllllllllIlIllllllIlIlIIlII, final int llllllllllllllIlIllllllIlIlIIIll) throws Exception {
            this.writer.typePathPath(llllllllllllllIlIllllllIlIlIIlII, llllllllllllllIlIllllllIlIlIIIll);
        }
        
        @Override
        void throwsTarget(final int llllllllllllllIlIllllllIllllIIll, final int llllllllllllllIlIllllllIllllIIlI) throws Exception {
            this.writer.throwsTarget(llllllllllllllIlIllllllIllllIIlI);
        }
        
        @Override
        void formalParameterTarget(final int llllllllllllllIlIllllllIlllllIlI, final int llllllllllllllIlIllllllIllllIlll) throws Exception {
            this.writer.formalParameterTarget(llllllllllllllIlIllllllIllllIlll);
        }
        
        @Override
        int localvarTarget(final int llllllllllllllIlIllllllIlllIlIlI, final int llllllllllllllIlIllllllIlllIlIIl, final int llllllllllllllIlIllllllIlllIIlII) throws Exception {
            this.writer.localVarTarget(llllllllllllllIlIllllllIlllIlIIl, llllllllllllllIlIllllllIlllIIlII);
            return super.localvarTarget(llllllllllllllIlIllllllIlllIlIlI, llllllllllllllIlIllllllIlllIlIIl, llllllllllllllIlIllllllIlllIIlII);
        }
        
        @Override
        void localvarTarget(final int llllllllllllllIlIllllllIllIllllI, final int llllllllllllllIlIllllllIllIlllIl, final int llllllllllllllIlIllllllIllIlllII, final int llllllllllllllIlIllllllIllIlIlll, final int llllllllllllllIlIllllllIllIlIllI) throws Exception {
            this.writer.localVarTargetTable(llllllllllllllIlIllllllIllIlllII, llllllllllllllIlIllllllIllIlIlll, llllllllllllllIlIllllllIllIlIllI);
        }
        
        @Override
        void typeParameterBoundTarget(final int llllllllllllllIlIlllllllIIIIllII, final int llllllllllllllIlIlllllllIIIIIlll, final int llllllllllllllIlIlllllllIIIIlIlI, final int llllllllllllllIlIlllllllIIIIlIIl) throws Exception {
            this.writer.typeParameterBoundTarget(llllllllllllllIlIlllllllIIIIIlll, llllllllllllllIlIlllllllIIIIlIlI, llllllllllllllIlIlllllllIIIIlIIl);
        }
        
        SubCopier(final byte[] llllllllllllllIlIlllllllIIlIIlll, final ConstPool llllllllllllllIlIlllllllIIlIllII, final ConstPool llllllllllllllIlIlllllllIIlIIlIl, final Map<String, String> llllllllllllllIlIlllllllIIlIIlII, final TypeAnnotationsWriter llllllllllllllIlIlllllllIIlIlIIl) {
            super(llllllllllllllIlIlllllllIIlIIlll);
            this.srcPool = llllllllllllllIlIlllllllIIlIllII;
            this.destPool = llllllllllllllIlIlllllllIIlIIlIl;
            this.classnames = llllllllllllllIlIlllllllIIlIIlII;
            this.writer = llllllllllllllIlIlllllllIIlIlIIl;
        }
        
        @Override
        void catchTarget(final int llllllllllllllIlIllllllIllIlIIlI, final int llllllllllllllIlIllllllIllIIllll) throws Exception {
            this.writer.catchTarget(llllllllllllllIlIllllllIllIIllll);
        }
        
        @Override
        void emptyTarget(final int llllllllllllllIlIlllllllIIIIIIIl, final int llllllllllllllIlIllllllIlllllllI) throws Exception {
            this.writer.emptyTarget(llllllllllllllIlIllllllIlllllllI);
        }
        
        @Override
        void supertypeTarget(final int llllllllllllllIlIlllllllIIIlIlIl, final int llllllllllllllIlIlllllllIIIlIlII) throws Exception {
            this.writer.supertypeTarget(llllllllllllllIlIlllllllIIIlIlII);
        }
        
        @Override
        void typeParameterTarget(final int llllllllllllllIlIlllllllIIIllllI, final int llllllllllllllIlIlllllllIIIlllIl, final int llllllllllllllIlIlllllllIIIlllII) throws Exception {
            this.writer.typeParameterTarget(llllllllllllllIlIlllllllIIIlllIl, llllllllllllllIlIlllllllIIIlllII);
        }
        
        @Override
        int typePath(final int llllllllllllllIlIllllllIlIlIlllI, final int llllllllllllllIlIllllllIlIlIlIlI) throws Exception {
            this.writer.typePath(llllllllllllllIlIllllllIlIlIlIlI);
            return super.typePath(llllllllllllllIlIllllllIlIlIlllI, llllllllllllllIlIllllllIlIlIlIlI);
        }
        
        @Override
        void offsetTarget(final int llllllllllllllIlIllllllIllIIlIlI, final int llllllllllllllIlIllllllIllIIlIIl, final int llllllllllllllIlIllllllIllIIIlIl) throws Exception {
            this.writer.offsetTarget(llllllllllllllIlIllllllIllIIlIIl, llllllllllllllIlIllllllIllIIIlIl);
        }
        
        @Override
        void typeArgumentTarget(final int llllllllllllllIlIllllllIlIllllII, final int llllllllllllllIlIllllllIlIlllIlI, final int llllllllllllllIlIllllllIlIlllIII, final int llllllllllllllIlIllllllIlIllIlll) throws Exception {
            this.writer.typeArgumentTarget(llllllllllllllIlIllllllIlIlllIlI, llllllllllllllIlIllllllIlIlllIII, llllllllllllllIlIllllllIlIllIlll);
        }
    }
    
    static class Renamer extends AnnotationsAttribute.Renamer
    {
        /* synthetic */ SubWalker sub;
        
        Renamer(final byte[] lllllllllllllIIlIllIlIIIIIlIlllI, final ConstPool lllllllllllllIIlIllIlIIIIIlIlIIl, final Map<String, String> lllllllllllllIIlIllIlIIIIIlIlIII) {
            super(lllllllllllllIIlIllIlIIIIIlIlllI, lllllllllllllIIlIllIlIIIIIlIlIIl, lllllllllllllIIlIllIlIIIIIlIlIII);
            this.sub = new SubWalker(lllllllllllllIIlIllIlIIIIIlIlllI);
        }
        
        @Override
        int annotationArray(int lllllllllllllIIlIllIlIIIIIIlllII, final int lllllllllllllIIlIllIlIIIIIIllIll) throws Exception {
            for (int lllllllllllllIIlIllIlIIIIIlIIIIl = 0; lllllllllllllIIlIllIlIIIIIlIIIIl < lllllllllllllIIlIllIlIIIIIIllIll; ++lllllllllllllIIlIllIlIIIIIlIIIIl) {
                final int lllllllllllllIIlIllIlIIIIIlIIIlI = this.info[lllllllllllllIIlIllIlIIIIIIlllII] & 0xFF;
                lllllllllllllIIlIllIlIIIIIIlllII = this.sub.targetInfo(lllllllllllllIIlIllIlIIIIIIlllII + 1, lllllllllllllIIlIllIlIIIIIlIIIlI);
                lllllllllllllIIlIllIlIIIIIIlllII = this.sub.typePath(lllllllllllllIIlIllIlIIIIIIlllII);
                lllllllllllllIIlIllIlIIIIIIlllII = this.annotation(lllllllllllllIIlIllIlIIIIIIlllII);
            }
            return lllllllllllllIIlIllIlIIIIIIlllII;
        }
    }
}
