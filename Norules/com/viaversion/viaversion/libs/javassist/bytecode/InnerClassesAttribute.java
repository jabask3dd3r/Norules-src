package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class InnerClassesAttribute extends AttributeInfo
{
    public int outerClassIndex(final int llllllllllllIlllllIIIIIIlIIllIII) {
        return ByteArray.readU16bit(this.get(), llllllllllllIlllllIIIIIIlIIllIII * 8 + 4);
    }
    
    InnerClassesAttribute(final ConstPool llllllllllllIlllllIIIIIIllIIllII, final int llllllllllllIlllllIIIIIIllIIlIll, final DataInputStream llllllllllllIlllllIIIIIIllIIlIlI) throws IOException {
        super(llllllllllllIlllllIIIIIIllIIllII, llllllllllllIlllllIIIIIIllIIlIll, llllllllllllIlllllIIIIIIllIIlIlI);
    }
    
    public String innerClass(final int llllllllllllIlllllIIIIIIlIlIIllI) {
        final int llllllllllllIlllllIIIIIIlIlIlIII = this.innerClassIndex(llllllllllllIlllllIIIIIIlIlIIllI);
        if (llllllllllllIlllllIIIIIIlIlIlIII == 0) {
            return null;
        }
        return this.constPool.getClassInfo(llllllllllllIlllllIIIIIIlIlIlIII);
    }
    
    public int tableLength() {
        return ByteArray.readU16bit(this.get(), 0);
    }
    
    public int innerClassIndex(final int llllllllllllIlllllIIIIIIlIlIlllI) {
        return ByteArray.readU16bit(this.get(), llllllllllllIlllllIIIIIIlIlIlllI * 8 + 2);
    }
    
    public void append(final int llllllllllllIlllllIIIIIIIIlIllIl, final int llllllllllllIlllllIIIIIIIIlIIIll, final int llllllllllllIlllllIIIIIIIIlIlIll, final int llllllllllllIlllllIIIIIIIIlIlIlI) {
        final byte[] llllllllllllIlllllIIIIIIIIlIlIIl = this.get();
        final int llllllllllllIlllllIIIIIIIIlIlIII = llllllllllllIlllllIIIIIIIIlIlIIl.length;
        final byte[] llllllllllllIlllllIIIIIIIIlIIlll = new byte[llllllllllllIlllllIIIIIIIIlIlIII + 8];
        for (int llllllllllllIlllllIIIIIIIIlIllll = 2; llllllllllllIlllllIIIIIIIIlIllll < llllllllllllIlllllIIIIIIIIlIlIII; ++llllllllllllIlllllIIIIIIIIlIllll) {
            llllllllllllIlllllIIIIIIIIlIIlll[llllllllllllIlllllIIIIIIIIlIllll] = llllllllllllIlllllIIIIIIIIlIlIIl[llllllllllllIlllllIIIIIIIIlIllll];
        }
        final int llllllllllllIlllllIIIIIIIIlIIllI = ByteArray.readU16bit(llllllllllllIlllllIIIIIIIIlIlIIl, 0);
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIIlIIllI + 1, llllllllllllIlllllIIIIIIIIlIIlll, 0);
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIIlIllIl, llllllllllllIlllllIIIIIIIIlIIlll, llllllllllllIlllllIIIIIIIIlIlIII);
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIIlIIIll, llllllllllllIlllllIIIIIIIIlIIlll, llllllllllllIlllllIIIIIIIIlIlIII + 2);
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIIlIlIll, llllllllllllIlllllIIIIIIIIlIIlll, llllllllllllIlllllIIIIIIIIlIlIII + 4);
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIIlIlIlI, llllllllllllIlllllIIIIIIIIlIIlll, llllllllllllIlllllIIIIIIIIlIlIII + 6);
        this.set(llllllllllllIlllllIIIIIIIIlIIlll);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllIllllIlllllllllIIlII, final Map<String, String> llllllllllllIllllIlllllllllIIIll) {
        final byte[] llllllllllllIllllIlllllllllIlIll = this.get();
        final byte[] llllllllllllIllllIlllllllllIlIlI = new byte[llllllllllllIllllIlllllllllIlIll.length];
        final ConstPool llllllllllllIllllIlllllllllIlIIl = this.getConstPool();
        final InnerClassesAttribute llllllllllllIllllIlllllllllIlIII = new InnerClassesAttribute(llllllllllllIllllIlllllllllIIlII, llllllllllllIllllIlllllllllIlIlI);
        final int llllllllllllIllllIlllllllllIIlll = ByteArray.readU16bit(llllllllllllIllllIlllllllllIlIll, 0);
        ByteArray.write16bit(llllllllllllIllllIlllllllllIIlll, llllllllllllIllllIlllllllllIlIlI, 0);
        int llllllllllllIllllIlllllllllIIllI = 2;
        for (int llllllllllllIllllIlllllllllIllll = 0; llllllllllllIllllIlllllllllIllll < llllllllllllIllllIlllllllllIIlll; ++llllllllllllIllllIlllllllllIllll) {
            int llllllllllllIllllIllllllllllIIll = ByteArray.readU16bit(llllllllllllIllllIlllllllllIlIll, llllllllllllIllllIlllllllllIIllI);
            int llllllllllllIllllIllllllllllIIlI = ByteArray.readU16bit(llllllllllllIllllIlllllllllIlIll, llllllllllllIllllIlllllllllIIllI + 2);
            int llllllllllllIllllIllllllllllIIIl = ByteArray.readU16bit(llllllllllllIllllIlllllllllIlIll, llllllllllllIllllIlllllllllIIllI + 4);
            final int llllllllllllIllllIllllllllllIIII = ByteArray.readU16bit(llllllllllllIllllIlllllllllIlIll, llllllllllllIllllIlllllllllIIllI + 6);
            if (llllllllllllIllllIllllllllllIIll != 0) {
                llllllllllllIllllIllllllllllIIll = llllllllllllIllllIlllllllllIlIIl.copy(llllllllllllIllllIllllllllllIIll, llllllllllllIllllIlllllllllIIlII, llllllllllllIllllIlllllllllIIIll);
            }
            ByteArray.write16bit(llllllllllllIllllIllllllllllIIll, llllllllllllIllllIlllllllllIlIlI, llllllllllllIllllIlllllllllIIllI);
            if (llllllllllllIllllIllllllllllIIlI != 0) {
                llllllllllllIllllIllllllllllIIlI = llllllllllllIllllIlllllllllIlIIl.copy(llllllllllllIllllIllllllllllIIlI, llllllllllllIllllIlllllllllIIlII, llllllllllllIllllIlllllllllIIIll);
            }
            ByteArray.write16bit(llllllllllllIllllIllllllllllIIlI, llllllllllllIllllIlllllllllIlIlI, llllllllllllIllllIlllllllllIIllI + 2);
            if (llllllllllllIllllIllllllllllIIIl != 0) {
                llllllllllllIllllIllllllllllIIIl = llllllllllllIllllIlllllllllIlIIl.copy(llllllllllllIllllIllllllllllIIIl, llllllllllllIllllIlllllllllIIlII, llllllllllllIllllIlllllllllIIIll);
            }
            ByteArray.write16bit(llllllllllllIllllIllllllllllIIIl, llllllllllllIllllIlllllllllIlIlI, llllllllllllIllllIlllllllllIIllI + 4);
            ByteArray.write16bit(llllllllllllIllllIllllllllllIIII, llllllllllllIllllIlllllllllIlIlI, llllllllllllIllllIlllllllllIIllI + 6);
            llllllllllllIllllIlllllllllIIllI += 8;
        }
        return llllllllllllIllllIlllllllllIlIII;
    }
    
    public void setAccessFlags(final int llllllllllllIlllllIIIIIIIllIIIIl, final int llllllllllllIlllllIIIIIIIlIlllIl) {
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIlIlllIl, this.get(), llllllllllllIlllllIIIIIIIllIIIIl * 8 + 8);
    }
    
    public int accessFlags(final int llllllllllllIlllllIIIIIIIllIlIII) {
        return ByteArray.readU16bit(this.get(), llllllllllllIlllllIIIIIIIllIlIII * 8 + 8);
    }
    
    public int innerNameIndex(final int llllllllllllIlllllIIIIIIIllllllI) {
        return ByteArray.readU16bit(this.get(), llllllllllllIlllllIIIIIIIllllllI * 8 + 6);
    }
    
    static {
        tag = "InnerClasses";
    }
    
    public int remove(final int llllllllllllIlllllIIIIIIIIIlIIlI) {
        final byte[] llllllllllllIlllllIIIIIIIIIlIIIl = this.get();
        final int llllllllllllIlllllIIIIIIIIIlIIII = llllllllllllIlllllIIIIIIIIIlIIIl.length;
        if (llllllllllllIlllllIIIIIIIIIlIIII < 10) {
            return 0;
        }
        final int llllllllllllIlllllIIIIIIIIIIllll = ByteArray.readU16bit(llllllllllllIlllllIIIIIIIIIlIIIl, 0);
        final int llllllllllllIlllllIIIIIIIIIIlllI = 2 + llllllllllllIlllllIIIIIIIIIlIIlI * 8;
        if (llllllllllllIlllllIIIIIIIIIIllll <= llllllllllllIlllllIIIIIIIIIlIIlI) {
            return llllllllllllIlllllIIIIIIIIIIllll;
        }
        final byte[] llllllllllllIlllllIIIIIIIIIIllIl = new byte[llllllllllllIlllllIIIIIIIIIlIIII - 8];
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIIIIllll - 1, llllllllllllIlllllIIIIIIIIIIllIl, 0);
        int llllllllllllIlllllIIIIIIIIIIllII = 2;
        int llllllllllllIlllllIIIIIIIIIIlIll = 2;
        while (llllllllllllIlllllIIIIIIIIIIllII < llllllllllllIlllllIIIIIIIIIlIIII) {
            if (llllllllllllIlllllIIIIIIIIIIllII == llllllllllllIlllllIIIIIIIIIIlllI) {
                llllllllllllIlllllIIIIIIIIIIllII += 8;
            }
            else {
                llllllllllllIlllllIIIIIIIIIIllIl[llllllllllllIlllllIIIIIIIIIIlIll++] = llllllllllllIlllllIIIIIIIIIlIIIl[llllllllllllIlllllIIIIIIIIIIllII++];
            }
        }
        this.set(llllllllllllIlllllIIIIIIIIIIllIl);
        return llllllllllllIlllllIIIIIIIIIIllll - 1;
    }
    
    public String innerName(final int llllllllllllIlllllIIIIIIIlllIllI) {
        final int llllllllllllIlllllIIIIIIIllllIII = this.innerNameIndex(llllllllllllIlllllIIIIIIIlllIllI);
        if (llllllllllllIlllllIIIIIIIllllIII == 0) {
            return null;
        }
        return this.constPool.getUtf8Info(llllllllllllIlllllIIIIIIIllllIII);
    }
    
    private InnerClassesAttribute(final ConstPool llllllllllllIlllllIIIIIIlIlllllI, final byte[] llllllllllllIlllllIIIIIIllIIIIII) {
        super(llllllllllllIlllllIIIIIIlIlllllI, "InnerClasses", llllllllllllIlllllIIIIIIllIIIIII);
    }
    
    public void append(final String llllllllllllIlllllIIIIIIIlIIIlll, final String llllllllllllIlllllIIIIIIIIlllllI, final String llllllllllllIlllllIIIIIIIlIIIlIl, final int llllllllllllIlllllIIIIIIIlIIIlII) {
        final int llllllllllllIlllllIIIIIIIlIIIIll = this.constPool.addClassInfo(llllllllllllIlllllIIIIIIIlIIIlll);
        final int llllllllllllIlllllIIIIIIIlIIIIlI = this.constPool.addClassInfo(llllllllllllIlllllIIIIIIIIlllllI);
        final int llllllllllllIlllllIIIIIIIlIIIIIl = this.constPool.addUtf8Info(llllllllllllIlllllIIIIIIIlIIIlIl);
        this.append(llllllllllllIlllllIIIIIIIlIIIIll, llllllllllllIlllllIIIIIIIlIIIIlI, llllllllllllIlllllIIIIIIIlIIIIIl, llllllllllllIlllllIIIIIIIlIIIlII);
    }
    
    public String outerClass(final int llllllllllllIlllllIIIIIIlIIlIIIl) {
        final int llllllllllllIlllllIIIIIIlIIlIIII = this.outerClassIndex(llllllllllllIlllllIIIIIIlIIlIIIl);
        if (llllllllllllIlllllIIIIIIlIIlIIII == 0) {
            return null;
        }
        return this.constPool.getClassInfo(llllllllllllIlllllIIIIIIlIIlIIII);
    }
    
    public void setOuterClassIndex(final int llllllllllllIlllllIIIIIIlIIIlIII, final int llllllllllllIlllllIIIIIIlIIIIlII) {
        ByteArray.write16bit(llllllllllllIlllllIIIIIIlIIIIlII, this.get(), llllllllllllIlllllIIIIIIlIIIlIII * 8 + 4);
    }
    
    public InnerClassesAttribute(final ConstPool llllllllllllIlllllIIIIIIlIllIlll) {
        super(llllllllllllIlllllIIIIIIlIllIlll, "InnerClasses", new byte[2]);
        ByteArray.write16bit(0, this.get(), 0);
    }
    
    public void setInnerClassIndex(final int llllllllllllIlllllIIIIIIlIlIIIII, final int llllllllllllIlllllIIIIIIlIIlllII) {
        ByteArray.write16bit(llllllllllllIlllllIIIIIIlIIlllII, this.get(), llllllllllllIlllllIIIIIIlIlIIIII * 8 + 2);
    }
    
    public void setInnerNameIndex(final int llllllllllllIlllllIIIIIIIllIllIl, final int llllllllllllIlllllIIIIIIIllIllII) {
        ByteArray.write16bit(llllllllllllIlllllIIIIIIIllIllII, this.get(), llllllllllllIlllllIIIIIIIllIllIl * 8 + 6);
    }
    
    public int find(final String llllllllllllIlllllIIIIIIIlIlIllI) {
        for (int llllllllllllIlllllIIIIIIIlIlIlIl = this.tableLength(), llllllllllllIlllllIIIIIIIlIllIII = 0; llllllllllllIlllllIIIIIIIlIllIII < llllllllllllIlllllIIIIIIIlIlIlIl; ++llllllllllllIlllllIIIIIIIlIllIII) {
            if (llllllllllllIlllllIIIIIIIlIlIllI.equals(this.innerClass(llllllllllllIlllllIIIIIIIlIllIII))) {
                return llllllllllllIlllllIIIIIIIlIllIII;
            }
        }
        return -1;
    }
}
