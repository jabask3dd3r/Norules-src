package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class AnnotationsWriter
{
    private /* synthetic */ ConstPool pool;
    protected /* synthetic */ OutputStream output;
    
    public void constValueIndex(final long llllllllllllllIllIIIIIllllIlIIII) throws IOException {
        this.constValueIndex(74, this.pool.addLongInfo(llllllllllllllIllIIIIIllllIlIIII));
    }
    
    public AnnotationsWriter(final OutputStream llllllllllllllIllIIIIlIIIIlIIIll, final ConstPool llllllllllllllIllIIIIlIIIIlIIlIl) {
        this.output = llllllllllllllIllIIIIlIIIIlIIIll;
        this.pool = llllllllllllllIllIIIIlIIIIlIIlIl;
    }
    
    public void enumConstValue(final String llllllllllllllIllIIIIIlllIlIlIll, final String llllllllllllllIllIIIIIlllIlIlIlI) throws IOException {
        this.enumConstValue(this.pool.addUtf8Info(llllllllllllllIllIIIIIlllIlIlIll), this.pool.addUtf8Info(llllllllllllllIllIIIIIlllIlIlIlI));
    }
    
    public void close() throws IOException {
        this.output.close();
    }
    
    public void classInfoIndex(final int llllllllllllllIllIIIIIlllIIlIlIl) throws IOException {
        this.output.write(99);
        this.write16bit(llllllllllllllIllIIIIIlllIIlIlIl);
    }
    
    public void arrayValue(final int llllllllllllllIllIIIIIlllIIIllII) throws IOException {
        this.output.write(91);
        this.write16bit(llllllllllllllIllIIIIIlllIIIllII);
    }
    
    public void constValueIndex(final char llllllllllllllIllIIIIIlllllIIIII) throws IOException {
        this.constValueIndex(67, this.pool.addIntegerInfo(llllllllllllllIllIIIIIlllllIIIII));
    }
    
    public void memberValuePair(final String llllllllllllllIllIIIIIlllllllIlI) throws IOException {
        this.memberValuePair(this.pool.addUtf8Info(llllllllllllllIllIIIIIlllllllIlI));
    }
    
    public void enumConstValue(final int llllllllllllllIllIIIIIlllIlIIlIl, final int llllllllllllllIllIIIIIlllIlIIlII) throws IOException {
        this.output.write(101);
        this.write16bit(llllllllllllllIllIIIIIlllIlIIlIl);
        this.write16bit(llllllllllllllIllIIIIIlllIlIIlII);
    }
    
    public void annotation(final int llllllllllllllIllIIIIIllllllllll, final int llllllllllllllIllIIIIIlllllllllI) throws IOException {
        this.write16bit(llllllllllllllIllIIIIIllllllllll);
        this.write16bit(llllllllllllllIllIIIIIlllllllllI);
    }
    
    public void annotationValue() throws IOException {
        this.output.write(64);
    }
    
    public void constValueIndex(final String llllllllllllllIllIIIIIlllIllllII) throws IOException {
        this.constValueIndex(115, this.pool.addUtf8Info(llllllllllllllIllIIIIIlllIllllII));
    }
    
    public void memberValuePair(final int llllllllllllllIllIIIIIllllllIIlI) throws IOException {
        this.write16bit(llllllllllllllIllIIIIIllllllIIlI);
    }
    
    public void constValueIndex(final float llllllllllllllIllIIIIIllllIIlIlI) throws IOException {
        this.constValueIndex(70, this.pool.addFloatInfo(llllllllllllllIllIIIIIllllIIlIlI));
    }
    
    public void constValueIndex(final int llllllllllllllIllIIIIIllllIlIlII) throws IOException {
        this.constValueIndex(73, this.pool.addIntegerInfo(llllllllllllllIllIIIIIllllIlIlII));
    }
    
    public void annotation(final String llllllllllllllIllIIIIlIIIIIIlIll, final int llllllllllllllIllIIIIlIIIIIIlIlI) throws IOException {
        this.annotation(this.pool.addUtf8Info(llllllllllllllIllIIIIlIIIIIIlIll), llllllllllllllIllIIIIlIIIIIIlIlI);
    }
    
    public ConstPool getConstPool() {
        return this.pool;
    }
    
    public void constValueIndex(final boolean llllllllllllllIllIIIIIlllllIllII) throws IOException {
        this.constValueIndex(90, this.pool.addIntegerInfo((int)(llllllllllllllIllIIIIIlllllIllII ? 1 : 0)));
    }
    
    public void numParameters(final int llllllllllllllIllIIIIlIIIIIllIII) throws IOException {
        this.output.write(llllllllllllllIllIIIIlIIIIIllIII);
    }
    
    public void constValueIndex(final byte llllllllllllllIllIIIIIlllllIIllI) throws IOException {
        this.constValueIndex(66, this.pool.addIntegerInfo(llllllllllllllIllIIIIIlllllIIllI));
    }
    
    public void classInfoIndex(final String llllllllllllllIllIIIIIlllIIllIll) throws IOException {
        this.classInfoIndex(this.pool.addUtf8Info(llllllllllllllIllIIIIIlllIIllIll));
    }
    
    public void constValueIndex(final int llllllllllllllIllIIIIIlllIllIlII, final int llllllllllllllIllIIIIIlllIllIllI) throws IOException {
        this.output.write(llllllllllllllIllIIIIIlllIllIlII);
        this.write16bit(llllllllllllllIllIIIIIlllIllIllI);
    }
    
    public void constValueIndex(final short llllllllllllllIllIIIIIllllIlllII) throws IOException {
        this.constValueIndex(83, this.pool.addIntegerInfo(llllllllllllllIllIIIIIllllIlllII));
    }
    
    protected void write16bit(final int llllllllllllllIllIIIIIlllIIIIlll) throws IOException {
        final byte[] llllllllllllllIllIIIIIlllIIIIllI = new byte[2];
        ByteArray.write16bit(llllllllllllllIllIIIIIlllIIIIlll, llllllllllllllIllIIIIIlllIIIIllI, 0);
        this.output.write(llllllllllllllIllIIIIIlllIIIIllI);
    }
    
    public void constValueIndex(final double llllllllllllllIllIIIIIllllIIIIlI) throws IOException {
        this.constValueIndex(68, this.pool.addDoubleInfo(llllllllllllllIllIIIIIllllIIIIlI));
    }
    
    public void numAnnotations(final int llllllllllllllIllIIIIlIIIIIlIIlI) throws IOException {
        this.write16bit(llllllllllllllIllIIIIlIIIIIlIIlI);
    }
}
