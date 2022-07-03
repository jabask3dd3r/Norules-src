package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.annotation.*;
import java.io.*;

public class ParameterAnnotationsAttribute extends AttributeInfo
{
    @Override
    void renameClass(final String llllllllllllllIlllIIlllllIlIIIIl, final String llllllllllllllIlllIIlllllIlIIIII) {
        final Map<String, String> llllllllllllllIlllIIlllllIlIIIll = new HashMap<String, String>();
        llllllllllllllIlllIIlllllIlIIIll.put(llllllllllllllIlllIIlllllIlIIIIl, llllllllllllllIlllIIlllllIlIIIII);
        this.renameClass(llllllllllllllIlllIIlllllIlIIIll);
    }
    
    public ParameterAnnotationsAttribute(final ConstPool llllllllllllllIlllIIllllllllIlll, final String llllllllllllllIlllIIllllllllIllI, final byte[] llllllllllllllIlllIIllllllllIIIl) {
        super(llllllllllllllIlllIIllllllllIlll, llllllllllllllIlllIIllllllllIllI, llllllllllllllIlllIIllllllllIIIl);
    }
    
    static {
        visibleTag = "RuntimeVisibleParameterAnnotations";
        invisibleTag = "RuntimeInvisibleParameterAnnotations";
    }
    
    public ParameterAnnotationsAttribute(final ConstPool llllllllllllllIlllIIlllllllIlIIl, final String llllllllllllllIlllIIlllllllIlIII) {
        this(llllllllllllllIlllIIlllllllIlIIl, llllllllllllllIlllIIlllllllIlIII, new byte[] { 0 });
    }
    
    public void setAnnotations(final Annotation[][] llllllllllllllIlllIIlllllIllIllI) {
        final ByteArrayOutputStream llllllllllllllIlllIIlllllIllIlIl = new ByteArrayOutputStream();
        final AnnotationsWriter llllllllllllllIlllIIlllllIllIlII = new AnnotationsWriter(llllllllllllllIlllIIlllllIllIlIl, this.constPool);
        try {
            llllllllllllllIlllIIlllllIllIlII.numParameters(llllllllllllllIlllIIlllllIllIllI.length);
            final long llllllllllllllIlllIIlllllIlIllll = (Object)llllllllllllllIlllIIlllllIllIllI;
            final String llllllllllllllIlllIIlllllIlIlllI = (String)llllllllllllllIlllIIlllllIlIllll.length;
            for (char llllllllllllllIlllIIlllllIlIllIl = '\0'; llllllllllllllIlllIIlllllIlIllIl < llllllllllllllIlllIIlllllIlIlllI; ++llllllllllllllIlllIIlllllIlIllIl) {
                final Annotation[] llllllllllllllIlllIIlllllIlllIIl = llllllllllllllIlllIIlllllIlIllll[llllllllllllllIlllIIlllllIlIllIl];
                llllllllllllllIlllIIlllllIllIlII.numAnnotations(llllllllllllllIlllIIlllllIlllIIl.length);
                for (int llllllllllllllIlllIIlllllIlllIlI = 0; llllllllllllllIlllIIlllllIlllIlI < llllllllllllllIlllIIlllllIlllIIl.length; ++llllllllllllllIlllIIlllllIlllIlI) {
                    llllllllllllllIlllIIlllllIlllIIl[llllllllllllllIlllIIlllllIlllIlI].write(llllllllllllllIlllIIlllllIllIlII);
                }
            }
            llllllllllllllIlllIIlllllIllIlII.close();
        }
        catch (IOException llllllllllllllIlllIIlllllIlllIII) {
            throw new RuntimeException(llllllllllllllIlllIIlllllIlllIII);
        }
        this.set(llllllllllllllIlllIIlllllIllIlIl.toByteArray());
    }
    
    @Override
    public String toString() {
        final Annotation[][] llllllllllllllIlllIIllllIllllllI = this.getAnnotations();
        final StringBuilder llllllllllllllIlllIIllllIlllllIl = new StringBuilder();
        final Exception llllllllllllllIlllIIllllIllllIIl = (Object)llllllllllllllIlllIIllllIllllllI;
        final boolean llllllllllllllIlllIIllllIllllIII = llllllllllllllIlllIIllllIllllIIl.length != 0;
        for (short llllllllllllllIlllIIllllIlllIlll = 0; llllllllllllllIlllIIllllIlllIlll < (llllllllllllllIlllIIllllIllllIII ? 1 : 0); ++llllllllllllllIlllIIllllIlllIlll) {
            final double llllllllllllllIlllIIllllIlllIlIl;
            final Annotation[] llllllllllllllIlllIIlllllIIIIIII = (Object)(llllllllllllllIlllIIllllIlllIlIl = llllllllllllllIlllIIllllIllllIIl[llllllllllllllIlllIIllllIlllIlll]);
            final Exception llllllllllllllIlllIIllllIlllIlII = (Exception)llllllllllllllIlllIIllllIlllIlIl.length;
            for (byte llllllllllllllIlllIIllllIlllIIll = 0; llllllllllllllIlllIIllllIlllIIll < llllllllllllllIlllIIllllIlllIlII; ++llllllllllllllIlllIIllllIlllIIll) {
                final Annotation llllllllllllllIlllIIlllllIIIIIIl = llllllllllllllIlllIIllllIlllIlIl[llllllllllllllIlllIIllllIlllIIll];
                llllllllllllllIlllIIllllIlllllIl.append(llllllllllllllIlllIIlllllIIIIIIl.toString()).append(" ");
            }
            llllllllllllllIlllIIllllIlllllIl.append(", ");
        }
        return String.valueOf(llllllllllllllIlllIIllllIlllllIl).replaceAll(" (?=,)|, $", "");
    }
    
    public Annotation[][] getAnnotations() {
        try {
            return new AnnotationsAttribute.Parser(this.info, this.constPool).parseParameters();
        }
        catch (Exception llllllllllllllIlllIIllllllIIIlll) {
            throw new RuntimeException(llllllllllllllIlllIIllllllIIIlll.toString());
        }
    }
    
    @Override
    void renameClass(final Map<String, String> llllllllllllllIlllIIlllllIIllIII) {
        final AnnotationsAttribute.Renamer llllllllllllllIlllIIlllllIIlIlll = new AnnotationsAttribute.Renamer(this.info, this.getConstPool(), llllllllllllllIlllIIlllllIIllIII);
        try {
            llllllllllllllIlllIIlllllIIlIlll.parameters();
        }
        catch (Exception llllllllllllllIlllIIlllllIIllIlI) {
            throw new RuntimeException(llllllllllllllIlllIIlllllIIllIlI);
        }
    }
    
    ParameterAnnotationsAttribute(final ConstPool llllllllllllllIlllIIlllllllIIIlI, final int llllllllllllllIlllIIlllllllIIIIl, final DataInputStream llllllllllllllIlllIIllllllIlllII) throws IOException {
        super(llllllllllllllIlllIIlllllllIIIlI, llllllllllllllIlllIIlllllllIIIIl, llllllllllllllIlllIIllllllIlllII);
    }
    
    public int numParameters() {
        return this.info[0] & 0xFF;
    }
    
    @Override
    void getRefClasses(final Map<String, String> llllllllllllllIlllIIlllllIIIllll) {
        this.renameClass(llllllllllllllIlllIIlllllIIIllll);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIlllIIllllllIIllIl, final Map<String, String> llllllllllllllIlllIIllllllIIllII) {
        final AnnotationsAttribute.Copier llllllllllllllIlllIIllllllIIllll = new AnnotationsAttribute.Copier(this.info, this.constPool, llllllllllllllIlllIIllllllIIllIl, llllllllllllllIlllIIllllllIIllII);
        try {
            llllllllllllllIlllIIllllllIIllll.parameters();
            return new ParameterAnnotationsAttribute(llllllllllllllIlllIIllllllIIllIl, this.getName(), llllllllllllllIlllIIllllllIIllll.close());
        }
        catch (Exception llllllllllllllIlllIIllllllIlIIll) {
            throw new RuntimeException(llllllllllllllIlllIIllllllIlIIll.toString());
        }
    }
}
