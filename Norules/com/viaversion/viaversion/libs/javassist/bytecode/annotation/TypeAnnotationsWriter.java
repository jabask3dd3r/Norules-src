package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TypeAnnotationsWriter extends AnnotationsWriter
{
    public void localVarTargetTable(final int lllllllllllllIIlIllIIIIIIlIIIIIl, final int lllllllllllllIIlIllIIIIIIlIIIlII, final int lllllllllllllIIlIllIIIIIIlIIIIll) throws IOException {
        this.write16bit(lllllllllllllIIlIllIIIIIIlIIIIIl);
        this.write16bit(lllllllllllllIIlIllIIIIIIlIIIlII);
        this.write16bit(lllllllllllllIIlIllIIIIIIlIIIIll);
    }
    
    public void formalParameterTarget(final int lllllllllllllIIlIllIIIIIIlIlllII) throws IOException {
        this.output.write(22);
        this.output.write(lllllllllllllIIlIllIIIIIIlIlllII);
    }
    
    public void typeParameterBoundTarget(final int lllllllllllllIIlIllIIIIIIllIlIII, final int lllllllllllllIIlIllIIIIIIllIlIll, final int lllllllllllllIIlIllIIIIIIllIlIlI) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIllIlIII);
        this.output.write(lllllllllllllIIlIllIIIIIIllIlIll);
        this.output.write(lllllllllllllIIlIllIIIIIIllIlIlI);
    }
    
    public void typePath(final int lllllllllllllIIlIllIIIIIIIIllllI) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIIIllllI);
    }
    
    public void localVarTarget(final int lllllllllllllIIlIllIIIIIIlIIllII, final int lllllllllllllIIlIllIIIIIIlIIlllI) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIlIIllII);
        this.write16bit(lllllllllllllIIlIllIIIIIIlIIlllI);
    }
    
    public void catchTarget(final int lllllllllllllIIlIllIIIIIIIlllIIl) throws IOException {
        this.output.write(66);
        this.write16bit(lllllllllllllIIlIllIIIIIIIlllIIl);
    }
    
    public void typeParameterTarget(final int lllllllllllllIIlIllIIIIIIllllIIl, final int lllllllllllllIIlIllIIIIIIllllIII) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIllllIIl);
        this.output.write(lllllllllllllIIlIllIIIIIIllllIII);
    }
    
    public void typeArgumentTarget(final int lllllllllllllIIlIllIIIIIIIlIlIlI, final int lllllllllllllIIlIllIIIIIIIlIlIIl, final int lllllllllllllIIlIllIIIIIIIlIlIII) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIIlIlIlI);
        this.write16bit(lllllllllllllIIlIllIIIIIIIlIlIIl);
        this.output.write(lllllllllllllIIlIllIIIIIIIlIlIII);
    }
    
    public void offsetTarget(final int lllllllllllllIIlIllIIIIIIIllIIIl, final int lllllllllllllIIlIllIIIIIIIllIIll) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIIllIIIl);
        this.write16bit(lllllllllllllIIlIllIIIIIIIllIIll);
    }
    
    public void emptyTarget(final int lllllllllllllIIlIllIIIIIIllIIIlI) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIllIIIlI);
    }
    
    public void typePathPath(final int lllllllllllllIIlIllIIIIIIIIlIllI, final int lllllllllllllIIlIllIIIIIIIIllIII) throws IOException {
        this.output.write(lllllllllllllIIlIllIIIIIIIIlIllI);
        this.output.write(lllllllllllllIIlIllIIIIIIIIllIII);
    }
    
    public void throwsTarget(final int lllllllllllllIIlIllIIIIIIlIlIllI) throws IOException {
        this.output.write(23);
        this.write16bit(lllllllllllllIIlIllIIIIIIlIlIllI);
    }
    
    @Override
    public void numAnnotations(final int lllllllllllllIIlIllIIIIIlIIIIIIl) throws IOException {
        super.numAnnotations(lllllllllllllIIlIllIIIIIlIIIIIIl);
    }
    
    public TypeAnnotationsWriter(final OutputStream lllllllllllllIIlIllIIIIIlIIIlIll, final ConstPool lllllllllllllIIlIllIIIIIlIIIIlll) {
        super(lllllllllllllIIlIllIIIIIlIIIlIll, lllllllllllllIIlIllIIIIIlIIIIlll);
    }
    
    public void supertypeTarget(final int lllllllllllllIIlIllIIIIIIlllIlII) throws IOException {
        this.output.write(16);
        this.write16bit(lllllllllllllIIlIllIIIIIIlllIlII);
    }
}
