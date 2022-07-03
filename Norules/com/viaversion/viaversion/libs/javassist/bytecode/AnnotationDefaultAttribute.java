package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.annotation.*;
import java.io.*;

public class AnnotationDefaultAttribute extends AttributeInfo
{
    @Override
    public String toString() {
        return this.getDefaultValue().toString();
    }
    
    static {
        tag = "AnnotationDefault";
    }
    
    AnnotationDefaultAttribute(final ConstPool lllllllllllllIIlIIIllllIllIIllll, final int lllllllllllllIIlIIIllllIllIlIIlI, final DataInputStream lllllllllllllIIlIIIllllIllIlIIIl) throws IOException {
        super(lllllllllllllIIlIIIllllIllIIllll, lllllllllllllIIlIIIllllIllIlIIlI, lllllllllllllIIlIIIllllIllIlIIIl);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIIlIIIllllIllIIIlIl, final Map<String, String> lllllllllllllIIlIIIllllIllIIIIII) {
        final AnnotationsAttribute.Copier lllllllllllllIIlIIIllllIllIIIIll = new AnnotationsAttribute.Copier(this.info, this.constPool, lllllllllllllIIlIIIllllIllIIIlIl, lllllllllllllIIlIIIllllIllIIIIII);
        try {
            lllllllllllllIIlIIIllllIllIIIIll.memberValue(0);
            return new AnnotationDefaultAttribute(lllllllllllllIIlIIIllllIllIIIlIl, lllllllllllllIIlIIIllllIllIIIIll.close());
        }
        catch (Exception lllllllllllllIIlIIIllllIllIIIlll) {
            throw new RuntimeException(lllllllllllllIIlIIIllllIllIIIlll.toString());
        }
    }
    
    public void setDefaultValue(final MemberValue lllllllllllllIIlIIIllllIlIllIIII) {
        final ByteArrayOutputStream lllllllllllllIIlIIIllllIlIlIllll = new ByteArrayOutputStream();
        final AnnotationsWriter lllllllllllllIIlIIIllllIlIlIlllI = new AnnotationsWriter(lllllllllllllIIlIIIllllIlIlIllll, this.constPool);
        try {
            lllllllllllllIIlIIIllllIlIllIIII.write(lllllllllllllIIlIIIllllIlIlIlllI);
            lllllllllllllIIlIIIllllIlIlIlllI.close();
        }
        catch (IOException lllllllllllllIIlIIIllllIlIllIIlI) {
            throw new RuntimeException(lllllllllllllIIlIIIllllIlIllIIlI);
        }
        this.set(lllllllllllllIIlIIIllllIlIlIllll.toByteArray());
    }
    
    public AnnotationDefaultAttribute(final ConstPool lllllllllllllIIlIIIllllIllIllIll) {
        this(lllllllllllllIIlIIIllllIllIllIll, new byte[] { 0, 0 });
    }
    
    public AnnotationDefaultAttribute(final ConstPool lllllllllllllIIlIIIllllIlllIIIll, final byte[] lllllllllllllIIlIIIllllIlllIIIlI) {
        super(lllllllllllllIIlIIIllllIlllIIIll, "AnnotationDefault", lllllllllllllIIlIIIllllIlllIIIlI);
    }
    
    public MemberValue getDefaultValue() {
        try {
            return new AnnotationsAttribute.Parser(this.info, this.constPool).parseMemberValue();
        }
        catch (Exception lllllllllllllIIlIIIllllIlIlllIll) {
            throw new RuntimeException(lllllllllllllIIlIIIllllIlIlllIll.toString());
        }
    }
}
