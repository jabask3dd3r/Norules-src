package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class LocalVariableAttribute extends AttributeInfo
{
    @Deprecated
    public LocalVariableAttribute(final ConstPool llllllllllllllIlllllIIlIllIIlllI, final String llllllllllllllIlllllIIlIllIlIIII) {
        super(llllllllllllllIlllllIIlIllIIlllI, llllllllllllllIlllllIIlIllIlIIII, new byte[2]);
        ByteArray.write16bit(0, this.info, 0);
    }
    
    public LocalVariableAttribute(final ConstPool llllllllllllllIlllllIIlIllIllIII) {
        super(llllllllllllllIlllllIIlIllIllIII, "LocalVariableTable", new byte[2]);
        ByteArray.write16bit(0, this.info, 0);
    }
    
    void shiftPc(final int llllllllllllllIlllllIIlIIIlIIIIl, final int llllllllllllllIlllllIIlIIIlIIlIl, final boolean llllllllllllllIlllllIIlIIIlIIlII) {
        for (int llllllllllllllIlllllIIlIIIlIIIll = this.tableLength(), llllllllllllllIlllllIIlIIIlIlIII = 0; llllllllllllllIlllllIIlIIIlIlIII < llllllllllllllIlllllIIlIIIlIIIll; ++llllllllllllllIlllllIIlIIIlIlIII) {
            final int llllllllllllllIlllllIIlIIIlIlIll = llllllllllllllIlllllIIlIIIlIlIII * 10 + 2;
            final int llllllllllllllIlllllIIlIIIlIlIlI = ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIIlIlIll);
            final int llllllllllllllIlllllIIlIIIlIlIIl = ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIIlIlIll + 2);
            if (llllllllllllllIlllllIIlIIIlIlIlI > llllllllllllllIlllllIIlIIIlIIIIl || (llllllllllllllIlllllIIlIIIlIIlII && llllllllllllllIlllllIIlIIIlIlIlI == llllllllllllllIlllllIIlIIIlIIIIl && llllllllllllllIlllllIIlIIIlIlIlI != 0)) {
                ByteArray.write16bit(llllllllllllllIlllllIIlIIIlIlIlI + llllllllllllllIlllllIIlIIIlIIlIl, this.info, llllllllllllllIlllllIIlIIIlIlIll);
            }
            else if (llllllllllllllIlllllIIlIIIlIlIlI + llllllllllllllIlllllIIlIIIlIlIIl > llllllllllllllIlllllIIlIIIlIIIIl || (llllllllllllllIlllllIIlIIIlIIlII && llllllllllllllIlllllIIlIIIlIlIlI + llllllllllllllIlllllIIlIIIlIlIIl == llllllllllllllIlllllIIlIIIlIIIIl)) {
                ByteArray.write16bit(llllllllllllllIlllllIIlIIIlIlIIl + llllllllllllllIlllllIIlIIIlIIlIl, this.info, llllllllllllllIlllllIIlIIIlIlIll + 2);
            }
        }
    }
    
    public int nameIndex(final int llllllllllllllIlllllIIlIIIIlIlII) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIIIlIlII * 10 + 6);
    }
    
    String renameEntry(final String llllllllllllllIlllllIIlIIlllIlll, final String llllllllllllllIlllllIIlIIllllIIl, final String llllllllllllllIlllllIIlIIlllIlIl) {
        return Descriptor.rename(llllllllllllllIlllllIIlIIlllIlll, llllllllllllllIlllllIIlIIllllIIl, llllllllllllllIlllllIIlIIlllIlIl);
    }
    
    String renameEntry(final String llllllllllllllIlllllIIlIIlIlIlll, final Map<String, String> llllllllllllllIlllllIIlIIlIllIII) {
        return Descriptor.rename(llllllllllllllIlllllIIlIIlIlIlll, llllllllllllllIlllllIIlIIlIllIII);
    }
    
    @Override
    void renameClass(final Map<String, String> llllllllllllllIlllllIIlIIllIIlll) {
        final ConstPool llllllllllllllIlllllIIlIIllIIllI = this.getConstPool();
        for (int llllllllllllllIlllllIIlIIllIIlIl = this.tableLength(), llllllllllllllIlllllIIlIIllIlIIl = 0; llllllllllllllIlllllIIlIIllIlIIl < llllllllllllllIlllllIIlIIllIIlIl; ++llllllllllllllIlllllIIlIIllIlIIl) {
            final int llllllllllllllIlllllIIlIIllIlIll = llllllllllllllIlllllIIlIIllIlIIl * 10 + 2;
            final int llllllllllllllIlllllIIlIIllIlIlI = ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIllIlIll + 6);
            if (llllllllllllllIlllllIIlIIllIlIlI != 0) {
                String llllllllllllllIlllllIIlIIllIllII = llllllllllllllIlllllIIlIIllIIllI.getUtf8Info(llllllllllllllIlllllIIlIIllIlIlI);
                llllllllllllllIlllllIIlIIllIllII = this.renameEntry(llllllllllllllIlllllIIlIIllIllII, llllllllllllllIlllllIIlIIllIIlll);
                ByteArray.write16bit(llllllllllllllIlllllIIlIIllIIllI.addUtf8Info(llllllllllllllIlllllIIlIIllIllII), this.info, llllllllllllllIlllllIIlIIllIlIll + 6);
            }
        }
    }
    
    public int descriptorIndex(final int llllllllllllllIlllllIIlIIIIIIIIl) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIIIIIIIl * 10 + 8);
    }
    
    public String descriptor(final int llllllllllllllIlllllIIIlllllIlIl) {
        return this.getConstPool().getUtf8Info(this.descriptorIndex(llllllllllllllIlllllIIIlllllIlIl));
    }
    
    public String variableName(final int llllllllllllllIlllllIIlIIIIlIIII) {
        return this.getConstPool().getUtf8Info(this.nameIndex(llllllllllllllIlllllIIlIIIIlIIII));
    }
    
    public int signatureIndex(final int llllllllllllllIlllllIIIllllllIll) {
        return this.descriptorIndex(llllllllllllllIlllllIIIllllllIll);
    }
    
    static {
        tag = "LocalVariableTable";
        typeTag = "LocalVariableTypeTable";
    }
    
    public void addEntry(final int llllllllllllllIlllllIIlIlIlIIIIl, final int llllllllllllllIlllllIIlIlIlIlIII, final int llllllllllllllIlllllIIlIlIlIIlll, final int llllllllllllllIlllllIIlIlIlIIllI, final int llllllllllllllIlllllIIlIlIIlllIl) {
        final int llllllllllllllIlllllIIlIlIlIIlII = this.info.length;
        final byte[] llllllllllllllIlllllIIlIlIlIIIll = new byte[llllllllllllllIlllllIIlIlIlIIlII + 10];
        ByteArray.write16bit(this.tableLength() + 1, llllllllllllllIlllllIIlIlIlIIIll, 0);
        for (int llllllllllllllIlllllIIlIlIlIlIll = 2; llllllllllllllIlllllIIlIlIlIlIll < llllllllllllllIlllllIIlIlIlIIlII; ++llllllllllllllIlllllIIlIlIlIlIll) {
            llllllllllllllIlllllIIlIlIlIIIll[llllllllllllllIlllllIIlIlIlIlIll] = this.info[llllllllllllllIlllllIIlIlIlIlIll];
        }
        ByteArray.write16bit(llllllllllllllIlllllIIlIlIlIIIIl, llllllllllllllIlllllIIlIlIlIIIll, llllllllllllllIlllllIIlIlIlIIlII);
        ByteArray.write16bit(llllllllllllllIlllllIIlIlIlIlIII, llllllllllllllIlllllIIlIlIlIIIll, llllllllllllllIlllllIIlIlIlIIlII + 2);
        ByteArray.write16bit(llllllllllllllIlllllIIlIlIlIIlll, llllllllllllllIlllllIIlIlIlIIIll, llllllllllllllIlllllIIlIlIlIIlII + 4);
        ByteArray.write16bit(llllllllllllllIlllllIIlIlIlIIllI, llllllllllllllIlllllIIlIlIlIIIll, llllllllllllllIlllllIIlIlIlIIlII + 6);
        ByteArray.write16bit(llllllllllllllIlllllIIlIlIIlllIl, llllllllllllllIlllllIIlIlIlIIIll, llllllllllllllIlllllIIlIlIlIIlII + 8);
        this.info = llllllllllllllIlllllIIlIlIlIIIll;
    }
    
    public int tableLength() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    public String variableNameByIndex(final int llllllllllllllIlllllIIlIIIIIIllI) {
        for (int llllllllllllllIlllllIIlIIIIIlIlI = 0; llllllllllllllIlllllIIlIIIIIlIlI < this.tableLength(); ++llllllllllllllIlllllIIlIIIIIlIlI) {
            if (this.index(llllllllllllllIlllllIIlIIIIIlIlI) == llllllllllllllIlllllIIlIIIIIIllI) {
                return this.variableName(llllllllllllllIlllllIIlIIIIIlIlI);
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    
    @Override
    void renameClass(final String llllllllllllllIlllllIIlIlIIIIllI, final String llllllllllllllIlllllIIlIlIIIIlIl) {
        final ConstPool llllllllllllllIlllllIIlIlIIIlIIl = this.getConstPool();
        for (int llllllllllllllIlllllIIlIlIIIlIII = this.tableLength(), llllllllllllllIlllllIIlIlIIIllIl = 0; llllllllllllllIlllllIIlIlIIIllIl < llllllllllllllIlllllIIlIlIIIlIII; ++llllllllllllllIlllllIIlIlIIIllIl) {
            final int llllllllllllllIlllllIIlIlIIIllll = llllllllllllllIlllllIIlIlIIIllIl * 10 + 2;
            final int llllllllllllllIlllllIIlIlIIIlllI = ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIlIIIllll + 6);
            if (llllllllllllllIlllllIIlIlIIIlllI != 0) {
                String llllllllllllllIlllllIIlIlIIlIIII = llllllllllllllIlllllIIlIlIIIlIIl.getUtf8Info(llllllllllllllIlllllIIlIlIIIlllI);
                llllllllllllllIlllllIIlIlIIlIIII = this.renameEntry(llllllllllllllIlllllIIlIlIIlIIII, llllllllllllllIlllllIIlIlIIIIllI, llllllllllllllIlllllIIlIlIIIIlIl);
                ByteArray.write16bit(llllllllllllllIlllllIIlIlIIIlIIl.addUtf8Info(llllllllllllllIlllllIIlIlIIlIIII), this.info, llllllllllllllIlllllIIlIlIIIllll + 6);
            }
        }
    }
    
    public int codeLength(final int llllllllllllllIlllllIIlIIIllIlll) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIIllIlll * 10 + 4);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIlllllIIIlllIIIlIl, final Map<String, String> llllllllllllllIlllllIIIlllIIllIl) {
        final byte[] llllllllllllllIlllllIIIlllIIllII = this.get();
        final byte[] llllllllllllllIlllllIIIlllIIlIll = new byte[llllllllllllllIlllllIIIlllIIllII.length];
        final ConstPool llllllllllllllIlllllIIIlllIIlIlI = this.getConstPool();
        final LocalVariableAttribute llllllllllllllIlllllIIIlllIIlIIl = this.makeThisAttr(llllllllllllllIlllllIIIlllIIIlIl, llllllllllllllIlllllIIIlllIIlIll);
        final int llllllllllllllIlllllIIIlllIIlIII = ByteArray.readU16bit(llllllllllllllIlllllIIIlllIIllII, 0);
        ByteArray.write16bit(llllllllllllllIlllllIIIlllIIlIII, llllllllllllllIlllllIIIlllIIlIll, 0);
        int llllllllllllllIlllllIIIlllIIIlll = 2;
        for (int llllllllllllllIlllllIIIlllIlIIII = 0; llllllllllllllIlllllIIIlllIlIIII < llllllllllllllIlllllIIIlllIIlIII; ++llllllllllllllIlllllIIIlllIlIIII) {
            final int llllllllllllllIlllllIIIlllIlIlIl = ByteArray.readU16bit(llllllllllllllIlllllIIIlllIIllII, llllllllllllllIlllllIIIlllIIIlll);
            final int llllllllllllllIlllllIIIlllIlIlII = ByteArray.readU16bit(llllllllllllllIlllllIIIlllIIllII, llllllllllllllIlllllIIIlllIIIlll + 2);
            int llllllllllllllIlllllIIIlllIlIIll = ByteArray.readU16bit(llllllllllllllIlllllIIIlllIIllII, llllllllllllllIlllllIIIlllIIIlll + 4);
            int llllllllllllllIlllllIIIlllIlIIlI = ByteArray.readU16bit(llllllllllllllIlllllIIIlllIIllII, llllllllllllllIlllllIIIlllIIIlll + 6);
            final int llllllllllllllIlllllIIIlllIlIIIl = ByteArray.readU16bit(llllllllllllllIlllllIIIlllIIllII, llllllllllllllIlllllIIIlllIIIlll + 8);
            ByteArray.write16bit(llllllllllllllIlllllIIIlllIlIlIl, llllllllllllllIlllllIIIlllIIlIll, llllllllllllllIlllllIIIlllIIIlll);
            ByteArray.write16bit(llllllllllllllIlllllIIIlllIlIlII, llllllllllllllIlllllIIIlllIIlIll, llllllllllllllIlllllIIIlllIIIlll + 2);
            if (llllllllllllllIlllllIIIlllIlIIll != 0) {
                llllllllllllllIlllllIIIlllIlIIll = llllllllllllllIlllllIIIlllIIlIlI.copy(llllllllllllllIlllllIIIlllIlIIll, llllllllllllllIlllllIIIlllIIIlIl, null);
            }
            ByteArray.write16bit(llllllllllllllIlllllIIIlllIlIIll, llllllllllllllIlllllIIIlllIIlIll, llllllllllllllIlllllIIIlllIIIlll + 4);
            if (llllllllllllllIlllllIIIlllIlIIlI != 0) {
                String llllllllllllllIlllllIIIlllIlIllI = llllllllllllllIlllllIIIlllIIlIlI.getUtf8Info(llllllllllllllIlllllIIIlllIlIIlI);
                llllllllllllllIlllllIIIlllIlIllI = Descriptor.rename(llllllllllllllIlllllIIIlllIlIllI, llllllllllllllIlllllIIIlllIIllIl);
                llllllllllllllIlllllIIIlllIlIIlI = llllllllllllllIlllllIIIlllIIIlIl.addUtf8Info(llllllllllllllIlllllIIIlllIlIllI);
            }
            ByteArray.write16bit(llllllllllllllIlllllIIIlllIlIIlI, llllllllllllllIlllllIIIlllIIlIll, llllllllllllllIlllllIIIlllIIIlll + 6);
            ByteArray.write16bit(llllllllllllllIlllllIIIlllIlIIIl, llllllllllllllIlllllIIIlllIIlIll, llllllllllllllIlllllIIIlllIIIlll + 8);
            llllllllllllllIlllllIIIlllIIIlll += 10;
        }
        return llllllllllllllIlllllIIIlllIIlIIl;
    }
    
    LocalVariableAttribute makeThisAttr(final ConstPool llllllllllllllIlllllIIIllIllIIll, final byte[] llllllllllllllIlllllIIIllIllIIlI) {
        return new LocalVariableAttribute(llllllllllllllIlllllIIIllIllIIll, "LocalVariableTable", llllllllllllllIlllllIIIllIllIIlI);
    }
    
    public void shiftIndex(final int llllllllllllllIlllllIIlIIlIIlIII, final int llllllllllllllIlllllIIlIIlIIIlll) {
        for (int llllllllllllllIlllllIIlIIlIIlIlI = this.info.length, llllllllllllllIlllllIIlIIlIIlllI = 2; llllllllllllllIlllllIIlIIlIIlllI < llllllllllllllIlllllIIlIIlIIlIlI; llllllllllllllIlllllIIlIIlIIlllI += 10) {
            final int llllllllllllllIlllllIIlIIlIIllll = ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIlIIlllI + 8);
            if (llllllllllllllIlllllIIlIIlIIllll >= llllllllllllllIlllllIIlIIlIIlIII) {
                ByteArray.write16bit(llllllllllllllIlllllIIlIIlIIllll + llllllllllllllIlllllIIlIIlIIIlll, this.info, llllllllllllllIlllllIIlIIlIIlllI + 8);
            }
        }
    }
    
    LocalVariableAttribute(final ConstPool llllllllllllllIlllllIIlIllIIIIll, final int llllllllllllllIlllllIIlIllIIIllI, final DataInputStream llllllllllllllIlllllIIlIllIIIIIl) throws IOException {
        super(llllllllllllllIlllllIIlIllIIIIll, llllllllllllllIlllllIIlIllIIIllI, llllllllllllllIlllllIIlIllIIIIIl);
    }
    
    public int startPc(final int llllllllllllllIlllllIIlIIIllllIl) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlllllIIlIIIllllIl * 10 + 2);
    }
    
    LocalVariableAttribute(final ConstPool llllllllllllllIlllllIIlIlIllIlll, final String llllllllllllllIlllllIIlIlIllIllI, final byte[] llllllllllllllIlllllIIlIlIllIlIl) {
        super(llllllllllllllIlllllIIlIlIllIlll, llllllllllllllIlllllIIlIlIllIllI, llllllllllllllIlllllIIlIlIllIlIl);
    }
    
    public int index(final int llllllllllllllIlllllIIIllllIlIIl) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlllllIIIllllIlIIl * 10 + 10);
    }
    
    public String signature(final int llllllllllllllIlllllIIIllllIllIl) {
        return this.descriptor(llllllllllllllIlllllIIIllllIllIl);
    }
}
