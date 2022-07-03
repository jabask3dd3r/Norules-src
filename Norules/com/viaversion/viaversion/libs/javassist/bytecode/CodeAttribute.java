package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class CodeAttribute extends AttributeInfo implements Opcode
{
    private /* synthetic */ List<AttributeInfo> attributes;
    private /* synthetic */ ExceptionTable exceptions;
    private /* synthetic */ int maxLocals;
    private /* synthetic */ int maxStack;
    
    @Override
    void write(final DataOutputStream lllllllllllllIlIIIllIIIIlIIlIIIl) throws IOException {
        lllllllllllllIlIIIllIIIIlIIlIIIl.writeShort(this.name);
        lllllllllllllIlIIIllIIIIlIIlIIIl.writeInt(this.length() - 6);
        lllllllllllllIlIIIllIIIIlIIlIIIl.writeShort(this.maxStack);
        lllllllllllllIlIIIllIIIIlIIlIIIl.writeShort(this.maxLocals);
        lllllllllllllIlIIIllIIIIlIIlIIIl.writeInt(this.info.length);
        lllllllllllllIlIIIllIIIIlIIlIIIl.write(this.info);
        this.exceptions.write(lllllllllllllIlIIIllIIIIlIIlIIIl);
        lllllllllllllIlIIIllIIIIlIIlIIIl.writeShort(this.attributes.size());
        AttributeInfo.writeAll(this.attributes, lllllllllllllIlIIIllIIIIlIIlIIIl);
    }
    
    public CodeIterator iterator() {
        return new CodeIterator(this);
    }
    
    public String getDeclaringClass() {
        final ConstPool lllllllllllllIlIIIllIIIIIlllIIll = this.getConstPool();
        return lllllllllllllIlIIIllIIIIIlllIIll.getClassName();
    }
    
    public List<AttributeInfo> getAttributes() {
        return this.attributes;
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIlIIIllIIIIlIIllIlI, final Map<String, String> lllllllllllllIlIIIllIIIIlIIlllII) throws RuntimeCopyException {
        try {
            return new CodeAttribute(lllllllllllllIlIIIllIIIIlIIllIlI, this, lllllllllllllIlIIIllIIIIlIIlllII);
        }
        catch (BadBytecode lllllllllllllIlIIIllIIIIlIIlllll) {
            throw new RuntimeCopyException("bad bytecode. fatal?");
        }
    }
    
    private CodeAttribute(final ConstPool lllllllllllllIlIIIllIIIIllIIlIII, final CodeAttribute lllllllllllllIlIIIllIIIIllIIIlll, final Map<String, String> lllllllllllllIlIIIllIIIIllIIIllI) throws BadBytecode {
        super(lllllllllllllIlIIIllIIIIllIIlIII, "Code");
        this.maxStack = lllllllllllllIlIIIllIIIIllIIIlll.getMaxStack();
        this.maxLocals = lllllllllllllIlIIIllIIIIllIIIlll.getMaxLocals();
        this.exceptions = lllllllllllllIlIIIllIIIIllIIIlll.getExceptionTable().copy(lllllllllllllIlIIIllIIIIllIIlIII, lllllllllllllIlIIIllIIIIllIIIllI);
        this.attributes = new ArrayList<AttributeInfo>();
        final List<AttributeInfo> lllllllllllllIlIIIllIIIIllIIIlIl = lllllllllllllIlIIIllIIIIllIIIlll.getAttributes();
        for (int lllllllllllllIlIIIllIIIIllIIIlII = lllllllllllllIlIIIllIIIIllIIIlIl.size(), lllllllllllllIlIIIllIIIIllIIlIlI = 0; lllllllllllllIlIIIllIIIIllIIlIlI < lllllllllllllIlIIIllIIIIllIIIlII; ++lllllllllllllIlIIIllIIIIllIIlIlI) {
            final AttributeInfo lllllllllllllIlIIIllIIIIllIIlIll = lllllllllllllIlIIIllIIIIllIIIlIl.get(lllllllllllllIlIIIllIIIIllIIlIlI);
            this.attributes.add(lllllllllllllIlIIIllIIIIllIIlIll.copy(lllllllllllllIlIIIllIIIIllIIlIII, lllllllllllllIlIIIllIIIIllIIIllI));
        }
        this.info = lllllllllllllIlIIIllIIIIllIIIlll.copyCode(lllllllllllllIlIIIllIIIIllIIlIII, lllllllllllllIlIIIllIIIIllIIIllI, this.exceptions, this);
    }
    
    private static void copyConstPoolInfo(final int lllllllllllllIlIIIlIlllllIllIIII, final byte[] lllllllllllllIlIIIlIlllllIllIllI, final ConstPool lllllllllllllIlIIIlIlllllIllIlIl, final byte[] lllllllllllllIlIIIlIlllllIlIllIl, final ConstPool lllllllllllllIlIIIlIlllllIllIIll, final Map<String, String> lllllllllllllIlIIIlIlllllIlIlIll) {
        int lllllllllllllIlIIIlIlllllIllIIIl = (lllllllllllllIlIIIlIlllllIllIllI[lllllllllllllIlIIIlIlllllIllIIII] & 0xFF) << 8 | (lllllllllllllIlIIIlIlllllIllIllI[lllllllllllllIlIIIlIlllllIllIIII + 1] & 0xFF);
        lllllllllllllIlIIIlIlllllIllIIIl = lllllllllllllIlIIIlIlllllIllIlIl.copy(lllllllllllllIlIIIlIlllllIllIIIl, lllllllllllllIlIIIlIlllllIllIIll, lllllllllllllIlIIIlIlllllIlIlIll);
        lllllllllllllIlIIIlIlllllIlIllIl[lllllllllllllIlIIIlIlllllIllIIII] = (byte)(lllllllllllllIlIIIlIlllllIllIIIl >> 8);
        lllllllllllllIlIIIlIlllllIlIllIl[lllllllllllllIlIIIlIlllllIllIIII + 1] = (byte)lllllllllllllIlIIIlIlllllIllIIIl;
    }
    
    public void setMaxLocals(final int lllllllllllllIlIIIllIIIIIlIIIIIl) {
        this.maxLocals = lllllllllllllIlIIIllIIIIIlIIIIIl;
    }
    
    @Override
    public int length() {
        return 18 + this.info.length + this.exceptions.size() * 8 + AttributeInfo.getLength(this.attributes);
    }
    
    public void setAttribute(final StackMapTable lllllllllllllIlIIIllIIIIIIIIIllI) {
        AttributeInfo.remove(this.attributes, "StackMapTable");
        if (lllllllllllllIlIIIllIIIIIIIIIllI != null) {
            this.attributes.add(lllllllllllllIlIIIllIIIIIIIIIllI);
        }
    }
    
    public void setMaxStack(final int lllllllllllllIlIIIllIIIIIllIIIIl) {
        this.maxStack = lllllllllllllIlIIIllIIIIIllIIIIl;
    }
    
    public int getCodeLength() {
        return this.info.length;
    }
    
    public int computeMaxStack() throws BadBytecode {
        this.maxStack = new CodeAnalyzer(this).computeMaxStack();
        return this.maxStack;
    }
    
    static {
        tag = "Code";
    }
    
    @Override
    void renameClass(final String lllllllllllllIlIIIllIIIIlIIIIlll, final String lllllllllllllIlIIIllIIIIlIIIIIll) {
        AttributeInfo.renameClass(this.attributes, lllllllllllllIlIIIllIIIIlIIIIlll, lllllllllllllIlIIIllIIIIlIIIIIll);
    }
    
    @Override
    void renameClass(final Map<String, String> lllllllllllllIlIIIllIIIIIlllllIl) {
        AttributeInfo.renameClass(this.attributes, lllllllllllllIlIIIllIIIIIlllllIl);
    }
    
    @Override
    public byte[] get() {
        throw new UnsupportedOperationException("CodeAttribute.get()");
    }
    
    public AttributeInfo getAttribute(final String lllllllllllllIlIIIllIIIIIIIIllII) {
        return AttributeInfo.lookup(this.attributes, lllllllllllllIlIIIllIIIIIIIIllII);
    }
    
    public byte[] getCode() {
        return this.info;
    }
    
    @Override
    public void set(final byte[] lllllllllllllIlIIIllIIIIlIIIllII) {
        throw new UnsupportedOperationException("CodeAttribute.set()");
    }
    
    CodeAttribute(final ConstPool lllllllllllllIlIIIllIIIIlIlIlIlI, final int lllllllllllllIlIIIllIIIIlIlIlIIl, final DataInputStream lllllllllllllIlIIIllIIIIlIlIllll) throws IOException {
        super(lllllllllllllIlIIIllIIIIlIlIlIlI, lllllllllllllIlIIIllIIIIlIlIlIIl, (byte[])null);
        final int lllllllllllllIlIIIllIIIIlIlIlllI = lllllllllllllIlIIIllIIIIlIlIllll.readInt();
        this.maxStack = lllllllllllllIlIIIllIIIIlIlIllll.readUnsignedShort();
        this.maxLocals = lllllllllllllIlIIIllIIIIlIlIllll.readUnsignedShort();
        final int lllllllllllllIlIIIllIIIIlIlIllIl = lllllllllllllIlIIIllIIIIlIlIllll.readInt();
        this.info = new byte[lllllllllllllIlIIIllIIIIlIlIllIl];
        lllllllllllllIlIIIllIIIIlIlIllll.readFully(this.info);
        this.exceptions = new ExceptionTable(lllllllllllllIlIIIllIIIIlIlIlIlI, lllllllllllllIlIIIllIIIIlIlIllll);
        this.attributes = new ArrayList<AttributeInfo>();
        for (int lllllllllllllIlIIIllIIIIlIlIllII = lllllllllllllIlIIIllIIIIlIlIllll.readUnsignedShort(), lllllllllllllIlIIIllIIIIlIllIIll = 0; lllllllllllllIlIIIllIIIIlIllIIll < lllllllllllllIlIIIllIIIIlIlIllII; ++lllllllllllllIlIIIllIIIIlIllIIll) {
            this.attributes.add(AttributeInfo.read(lllllllllllllIlIIIllIIIIlIlIlIlI, lllllllllllllIlIIIllIIIIlIlIllll));
        }
    }
    
    private byte[] copyCode(final ConstPool lllllllllllllIlIIIlIlllllllIllII, final Map<String, String> lllllllllllllIlIIIlIllllllllIIll, final ExceptionTable lllllllllllllIlIIIlIllllllllIIlI, final CodeAttribute lllllllllllllIlIIIlIllllllllIIIl) throws BadBytecode {
        final int lllllllllllllIlIIIlIllllllllIIII = this.getCodeLength();
        final byte[] lllllllllllllIlIIIlIlllllllIllll = new byte[lllllllllllllIlIIIlIllllllllIIII];
        lllllllllllllIlIIIlIllllllllIIIl.info = lllllllllllllIlIIIlIlllllllIllll;
        final LdcEntry lllllllllllllIlIIIlIlllllllIlllI = copyCode(this.info, 0, lllllllllllllIlIIIlIllllllllIIII, this.getConstPool(), lllllllllllllIlIIIlIlllllllIllll, lllllllllllllIlIIIlIlllllllIllII, lllllllllllllIlIIIlIllllllllIIll);
        return LdcEntry.doit(lllllllllllllIlIIIlIlllllllIllll, lllllllllllllIlIIIlIlllllllIlllI, lllllllllllllIlIIIlIllllllllIIlI, lllllllllllllIlIIIlIllllllllIIIl);
    }
    
    void setCode(final byte[] lllllllllllllIlIIIllIIIIIIlIllIl) {
        super.set(lllllllllllllIlIIIllIIIIIIlIllIl);
    }
    
    public int getMaxLocals() {
        return this.maxLocals;
    }
    
    private static void shiftIndex(final CodeIterator lllllllllllllIlIIIlIlllllIIIllII, final int lllllllllllllIlIIIlIlllllIIIlIll, final int lllllllllllllIlIIIlIlllllIIIlIlI) throws BadBytecode {
        final int lllllllllllllIlIIIlIlllllIIIlllI = lllllllllllllIlIIIlIlllllIIIllII.next();
        final int lllllllllllllIlIIIlIlllllIIIllIl = lllllllllllllIlIIIlIlllllIIIllII.byteAt(lllllllllllllIlIIIlIlllllIIIlllI);
        if (lllllllllllllIlIIIlIlllllIIIllIl < 21) {
            return;
        }
        if (lllllllllllllIlIIIlIlllllIIIllIl < 79) {
            if (lllllllllllllIlIIIlIlllllIIIllIl < 26) {
                shiftIndex8(lllllllllllllIlIIIlIlllllIIIllII, lllllllllllllIlIIIlIlllllIIIlllI, lllllllllllllIlIIIlIlllllIIIllIl, lllllllllllllIlIIIlIlllllIIIlIll, lllllllllllllIlIIIlIlllllIIIlIlI);
            }
            else if (lllllllllllllIlIIIlIlllllIIIllIl < 46) {
                shiftIndex0(lllllllllllllIlIIIlIlllllIIIllII, lllllllllllllIlIIIlIlllllIIIlllI, lllllllllllllIlIIIlIlllllIIIllIl, lllllllllllllIlIIIlIlllllIIIlIll, lllllllllllllIlIIIlIlllllIIIlIlI, 26, 21);
            }
            else {
                if (lllllllllllllIlIIIlIlllllIIIllIl < 54) {
                    return;
                }
                if (lllllllllllllIlIIIlIlllllIIIllIl < 59) {
                    shiftIndex8(lllllllllllllIlIIIlIlllllIIIllII, lllllllllllllIlIIIlIlllllIIIlllI, lllllllllllllIlIIIlIlllllIIIllIl, lllllllllllllIlIIIlIlllllIIIlIll, lllllllllllllIlIIIlIlllllIIIlIlI);
                }
                else {
                    shiftIndex0(lllllllllllllIlIIIlIlllllIIIllII, lllllllllllllIlIIIlIlllllIIIlllI, lllllllllllllIlIIIlIlllllIIIllIl, lllllllllllllIlIIIlIlllllIIIlIll, lllllllllllllIlIIIlIlllllIIIlIlI, 59, 54);
                }
            }
        }
        else if (lllllllllllllIlIIIlIlllllIIIllIl == 132) {
            int lllllllllllllIlIIIlIlllllIIlIIll = lllllllllllllIlIIIlIlllllIIIllII.byteAt(lllllllllllllIlIIIlIlllllIIIlllI + 1);
            if (lllllllllllllIlIIIlIlllllIIlIIll < lllllllllllllIlIIIlIlllllIIIlIll) {
                return;
            }
            lllllllllllllIlIIIlIlllllIIlIIll += lllllllllllllIlIIIlIlllllIIIlIlI;
            if (lllllllllllllIlIIIlIlllllIIlIIll < 256) {
                lllllllllllllIlIIIlIlllllIIIllII.writeByte(lllllllllllllIlIIIlIlllllIIlIIll, lllllllllllllIlIIIlIlllllIIIlllI + 1);
            }
            else {
                final int lllllllllllllIlIIIlIlllllIIlIlIl = (byte)lllllllllllllIlIIIlIlllllIIIllII.byteAt(lllllllllllllIlIIIlIlllllIIIlllI + 2);
                final int lllllllllllllIlIIIlIlllllIIlIlII = lllllllllllllIlIIIlIlllllIIIllII.insertExGap(3);
                lllllllllllllIlIIIlIlllllIIIllII.writeByte(196, lllllllllllllIlIIIlIlllllIIlIlII - 3);
                lllllllllllllIlIIIlIlllllIIIllII.writeByte(132, lllllllllllllIlIIIlIlllllIIlIlII - 2);
                lllllllllllllIlIIIlIlllllIIIllII.write16bit(lllllllllllllIlIIIlIlllllIIlIIll, lllllllllllllIlIIIlIlllllIIlIlII - 1);
                lllllllllllllIlIIIlIlllllIIIllII.write16bit(lllllllllllllIlIIIlIlllllIIlIlIl, lllllllllllllIlIIIlIlllllIIlIlII + 1);
            }
        }
        else if (lllllllllllllIlIIIlIlllllIIIllIl == 169) {
            shiftIndex8(lllllllllllllIlIIIlIlllllIIIllII, lllllllllllllIlIIIlIlllllIIIlllI, lllllllllllllIlIIIlIlllllIIIllIl, lllllllllllllIlIIIlIlllllIIIlIll, lllllllllllllIlIIIlIlllllIIIlIlI);
        }
        else if (lllllllllllllIlIIIlIlllllIIIllIl == 196) {
            int lllllllllllllIlIIIlIlllllIIlIIlI = lllllllllllllIlIIIlIlllllIIIllII.u16bitAt(lllllllllllllIlIIIlIlllllIIIlllI + 2);
            if (lllllllllllllIlIIIlIlllllIIlIIlI < lllllllllllllIlIIIlIlllllIIIlIll) {
                return;
            }
            lllllllllllllIlIIIlIlllllIIlIIlI += lllllllllllllIlIIIlIlllllIIIlIlI;
            lllllllllllllIlIIIlIlllllIIIllII.write16bit(lllllllllllllIlIIIlIlllllIIlIIlI, lllllllllllllIlIIIlIlllllIIIlllI + 2);
        }
    }
    
    public CodeAttribute(final ConstPool lllllllllllllIlIIIllIIIIllIllIII, final int lllllllllllllIlIIIllIIIIllIlllIl, final int lllllllllllllIlIIIllIIIIllIlIllI, final byte[] lllllllllllllIlIIIllIIIIllIllIll, final ExceptionTable lllllllllllllIlIIIllIIIIllIllIlI) {
        super(lllllllllllllIlIIIllIIIIllIllIII, "Code");
        this.maxStack = lllllllllllllIlIIIllIIIIllIlllIl;
        this.maxLocals = lllllllllllllIlIIIllIIIIllIlIllI;
        this.info = lllllllllllllIlIIIllIIIIllIllIll;
        this.exceptions = lllllllllllllIlIIIllIIIIllIllIlI;
        this.attributes = new ArrayList<AttributeInfo>();
    }
    
    private static void shiftIndex8(final CodeIterator lllllllllllllIlIIIlIllllIlllIllI, final int lllllllllllllIlIIIlIllllIllllIll, final int lllllllllllllIlIIIlIllllIlllIlII, final int lllllllllllllIlIIIlIllllIlllIIll, final int lllllllllllllIlIIIlIllllIlllIIlI) throws BadBytecode {
        int lllllllllllllIlIIIlIllllIlllIlll = lllllllllllllIlIIIlIllllIlllIllI.byteAt(lllllllllllllIlIIIlIllllIllllIll + 1);
        if (lllllllllllllIlIIIlIllllIlllIlll < lllllllllllllIlIIIlIllllIlllIIll) {
            return;
        }
        lllllllllllllIlIIIlIllllIlllIlll += lllllllllllllIlIIIlIllllIlllIIlI;
        if (lllllllllllllIlIIIlIllllIlllIlll < 256) {
            lllllllllllllIlIIIlIllllIlllIllI.writeByte(lllllllllllllIlIIIlIllllIlllIlll, lllllllllllllIlIIIlIllllIllllIll + 1);
        }
        else {
            final int lllllllllllllIlIIIlIllllIlllllIl = lllllllllllllIlIIIlIllllIlllIllI.insertExGap(2);
            lllllllllllllIlIIIlIllllIlllIllI.writeByte(196, lllllllllllllIlIIIlIllllIlllllIl - 2);
            lllllllllllllIlIIIlIllllIlllIllI.writeByte(lllllllllllllIlIIIlIllllIlllIlII, lllllllllllllIlIIIlIllllIlllllIl - 1);
            lllllllllllllIlIIIlIllllIlllIllI.write16bit(lllllllllllllIlIIIlIllllIlllIlll, lllllllllllllIlIIIlIllllIlllllIl);
        }
    }
    
    private static void shiftIndex0(final CodeIterator lllllllllllllIlIIIlIllllIllIIlII, final int lllllllllllllIlIIIlIllllIlIllIll, int lllllllllllllIlIIIlIllllIllIIIlI, final int lllllllllllllIlIIIlIllllIllIIIIl, final int lllllllllllllIlIIIlIllllIlIllIII, final int lllllllllllllIlIIIlIllllIlIlllll, final int lllllllllllllIlIIIlIllllIlIlIllI) throws BadBytecode {
        int lllllllllllllIlIIIlIllllIlIlllIl = (lllllllllllllIlIIIlIllllIllIIIlI - lllllllllllllIlIIIlIllllIlIlllll) % 4;
        if (lllllllllllllIlIIIlIllllIlIlllIl < lllllllllllllIlIIIlIllllIllIIIIl) {
            return;
        }
        lllllllllllllIlIIIlIllllIlIlllIl += lllllllllllllIlIIIlIllllIlIllIII;
        if (lllllllllllllIlIIIlIllllIlIlllIl < 4) {
            lllllllllllllIlIIIlIllllIllIIlII.writeByte(lllllllllllllIlIIIlIllllIllIIIlI + lllllllllllllIlIIIlIllllIlIllIII, lllllllllllllIlIIIlIllllIlIllIll);
        }
        else {
            lllllllllllllIlIIIlIllllIllIIIlI = (lllllllllllllIlIIIlIllllIllIIIlI - lllllllllllllIlIIIlIllllIlIlllll) / 4 + lllllllllllllIlIIIlIllllIlIlIllI;
            if (lllllllllllllIlIIIlIllllIlIlllIl < 256) {
                final int lllllllllllllIlIIIlIllllIllIIllI = lllllllllllllIlIIIlIllllIllIIlII.insertExGap(1);
                lllllllllllllIlIIIlIllllIllIIlII.writeByte(lllllllllllllIlIIIlIllllIllIIIlI, lllllllllllllIlIIIlIllllIllIIllI - 1);
                lllllllllllllIlIIIlIllllIllIIlII.writeByte(lllllllllllllIlIIIlIllllIlIlllIl, lllllllllllllIlIIIlIllllIllIIllI);
            }
            else {
                final int lllllllllllllIlIIIlIllllIllIIlIl = lllllllllllllIlIIIlIllllIllIIlII.insertExGap(3);
                lllllllllllllIlIIIlIllllIllIIlII.writeByte(196, lllllllllllllIlIIIlIllllIllIIlIl - 1);
                lllllllllllllIlIIIlIllllIllIIlII.writeByte(lllllllllllllIlIIIlIllllIllIIIlI, lllllllllllllIlIIIlIllllIllIIlIl);
                lllllllllllllIlIIIlIllllIllIIlII.write16bit(lllllllllllllIlIIIlIllllIlIlllIl, lllllllllllllIlIIIlIllllIllIIlIl + 1);
            }
        }
    }
    
    public void insertLocalVar(final int lllllllllllllIlIIIlIlllllIlIIlII, final int lllllllllllllIlIIIlIlllllIIlllll) throws BadBytecode {
        final CodeIterator lllllllllllllIlIIIlIlllllIlIIIlI = this.iterator();
        while (lllllllllllllIlIIIlIlllllIlIIIlI.hasNext()) {
            shiftIndex(lllllllllllllIlIIIlIlllllIlIIIlI, lllllllllllllIlIIIlIlllllIlIIlII, lllllllllllllIlIIIlIlllllIIlllll);
        }
        this.setMaxLocals(this.getMaxLocals() + lllllllllllllIlIIIlIlllllIIlllll);
    }
    
    public ExceptionTable getExceptionTable() {
        return this.exceptions;
    }
    
    public int getMaxStack() {
        return this.maxStack;
    }
    
    private static LdcEntry copyCode(final byte[] lllllllllllllIlIIIlIllllllIlIIll, final int lllllllllllllIlIIIlIllllllIlIIlI, final int lllllllllllllIlIIIlIllllllIIlIIl, final ConstPool lllllllllllllIlIIIlIllllllIlIIII, final byte[] lllllllllllllIlIIIlIllllllIIIlll, final ConstPool lllllllllllllIlIIIlIllllllIIIllI, final Map<String, String> lllllllllllllIlIIIlIllllllIIllIl) throws BadBytecode {
        LdcEntry lllllllllllllIlIIIlIllllllIIllII = null;
        int lllllllllllllIlIIIlIllllllIlIlIl;
        for (int lllllllllllllIlIIIlIllllllIlIlII = lllllllllllllIlIIIlIllllllIlIIlI; lllllllllllllIlIIIlIllllllIlIlII < lllllllllllllIlIIIlIllllllIIlIIl; lllllllllllllIlIIIlIllllllIlIlII = lllllllllllllIlIIIlIllllllIlIlIl) {
            lllllllllllllIlIIIlIllllllIlIlIl = CodeIterator.nextOpcode(lllllllllllllIlIIIlIllllllIlIIll, lllllllllllllIlIIIlIllllllIlIlII);
            final byte lllllllllllllIlIIIlIllllllIlIllI = lllllllllllllIlIIIlIllllllIlIIll[lllllllllllllIlIIIlIllllllIlIlII];
            switch ((lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII] = lllllllllllllIlIIIlIllllllIlIllI) & 0xFF) {
                case 19:
                case 20:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193: {
                    copyConstPoolInfo(lllllllllllllIlIIIlIllllllIlIlII + 1, lllllllllllllIlIIIlIllllllIlIIll, lllllllllllllIlIIIlIllllllIlIIII, lllllllllllllIlIIIlIllllllIIIlll, lllllllllllllIlIIIlIllllllIIIllI, lllllllllllllIlIIIlIllllllIIllIl);
                    break;
                }
                case 18: {
                    int lllllllllllllIlIIIlIllllllIlIlll = lllllllllllllIlIIIlIllllllIlIIll[lllllllllllllIlIIIlIllllllIlIlII + 1] & 0xFF;
                    lllllllllllllIlIIIlIllllllIlIlll = lllllllllllllIlIIIlIllllllIlIIII.copy(lllllllllllllIlIIIlIllllllIlIlll, lllllllllllllIlIIIlIllllllIIIllI, lllllllllllllIlIIIlIllllllIIllIl);
                    if (lllllllllllllIlIIIlIllllllIlIlll < 256) {
                        lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 1] = (byte)lllllllllllllIlIIIlIllllllIlIlll;
                        break;
                    }
                    lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 1] = (lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII] = 0);
                    final LdcEntry lllllllllllllIlIIIlIllllllIllIII = new LdcEntry();
                    lllllllllllllIlIIIlIllllllIllIII.where = lllllllllllllIlIIIlIllllllIlIlII;
                    lllllllllllllIlIIIlIllllllIllIII.index = lllllllllllllIlIIIlIllllllIlIlll;
                    lllllllllllllIlIIIlIllllllIllIII.next = lllllllllllllIlIIIlIllllllIIllII;
                    lllllllllllllIlIIIlIllllllIIllII = lllllllllllllIlIIIlIllllllIllIII;
                    break;
                }
                case 185: {
                    copyConstPoolInfo(lllllllllllllIlIIIlIllllllIlIlII + 1, lllllllllllllIlIIIlIllllllIlIIll, lllllllllllllIlIIIlIllllllIlIIII, lllllllllllllIlIIIlIllllllIIIlll, lllllllllllllIlIIIlIllllllIIIllI, lllllllllllllIlIIIlIllllllIIllIl);
                    lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 3] = lllllllllllllIlIIIlIllllllIlIIll[lllllllllllllIlIIIlIllllllIlIlII + 3];
                    lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 4] = lllllllllllllIlIIIlIllllllIlIIll[lllllllllllllIlIIIlIllllllIlIlII + 4];
                    break;
                }
                case 186: {
                    copyConstPoolInfo(lllllllllllllIlIIIlIllllllIlIlII + 1, lllllllllllllIlIIIlIllllllIlIIll, lllllllllllllIlIIIlIllllllIlIIII, lllllllllllllIlIIIlIllllllIIIlll, lllllllllllllIlIIIlIllllllIIIllI, lllllllllllllIlIIIlIllllllIIllIl);
                    lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 4] = (lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 3] = 0);
                    break;
                }
                case 197: {
                    copyConstPoolInfo(lllllllllllllIlIIIlIllllllIlIlII + 1, lllllllllllllIlIIIlIllllllIlIIll, lllllllllllllIlIIIlIllllllIlIIII, lllllllllllllIlIIIlIllllllIIIlll, lllllllllllllIlIIIlIllllllIIIllI, lllllllllllllIlIIIlIllllllIIllIl);
                    lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII + 3] = lllllllllllllIlIIIlIllllllIlIIll[lllllllllllllIlIIIlIllllllIlIlII + 3];
                    break;
                }
                default: {
                    while (++lllllllllllllIlIIIlIllllllIlIlII < lllllllllllllIlIIIlIllllllIlIlIl) {
                        lllllllllllllIlIIIlIllllllIIIlll[lllllllllllllIlIIIlIllllllIlIlII] = lllllllllllllIlIIIlIllllllIlIIll[lllllllllllllIlIIIlIllllllIlIlII];
                    }
                    break;
                }
            }
        }
        return lllllllllllllIlIIIlIllllllIIllII;
    }
    
    public void setAttribute(final StackMap lllllllllllllIlIIIllIIIIIIIIIIII) {
        AttributeInfo.remove(this.attributes, "StackMap");
        if (lllllllllllllIlIIIllIIIIIIIIIIII != null) {
            this.attributes.add(lllllllllllllIlIIIllIIIIIIIIIIII);
        }
    }
    
    @Override
    void getRefClasses(final Map<String, String> lllllllllllllIlIIIllIIIIIllllIIl) {
        AttributeInfo.getRefClasses(this.attributes, lllllllllllllIlIIIllIIIIIllllIIl);
    }
    
    static class LdcEntry
    {
        /* synthetic */ LdcEntry next;
        /* synthetic */ int where;
        /* synthetic */ int index;
        
        static byte[] doit(byte[] lllllllllllllIlIIIlIlIIllIlIIlII, final LdcEntry lllllllllllllIlIIIlIlIIllIlIIIll, final ExceptionTable lllllllllllllIlIIIlIlIIllIlIIIlI, final CodeAttribute lllllllllllllIlIIIlIlIIllIlIIIIl) throws BadBytecode {
            if (lllllllllllllIlIIIlIlIIllIlIIIll != null) {
                lllllllllllllIlIIIlIlIIllIlIIlII = CodeIterator.changeLdcToLdcW((byte[])lllllllllllllIlIIIlIlIIllIlIIlII, lllllllllllllIlIIIlIlIIllIlIIIlI, lllllllllllllIlIIIlIlIIllIlIIIIl, lllllllllllllIlIIIlIlIIllIlIIIll);
            }
            return (byte[])lllllllllllllIlIIIlIlIIllIlIIlII;
        }
    }
    
    public static class RuntimeCopyException extends RuntimeException
    {
        public RuntimeCopyException(final String llllllllllllllIlIIIlIlIIlIlIllll) {
            super(llllllllllllllIlIIIlIlIIlIlIllll);
        }
    }
}
