package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;

public class ClassFileWriter
{
    private /* synthetic */ FieldWriter fields;
    private /* synthetic */ ByteStream output;
    private /* synthetic */ MethodWriter methods;
    private /* synthetic */ ConstPoolWriter constPool;
    
    public FieldWriter getFieldWriter() {
        return this.fields;
    }
    
    public void end(final DataOutputStream lllllllllllllllIIlllIIIlIIlllIlI, final int lllllllllllllllIIlllIIIlIlIIIIII, final int lllllllllllllllIIlllIIIlIIlllIII, final int lllllllllllllllIIlllIIIlIIlllllI, final int[] lllllllllllllllIIlllIIIlIIllIllI, final AttributeWriter lllllllllllllllIIlllIIIlIIllIlIl) throws IOException {
        this.constPool.end();
        this.output.writeTo(lllllllllllllllIIlllIIIlIIlllIlI);
        lllllllllllllllIIlllIIIlIIlllIlI.writeShort(lllllllllllllllIIlllIIIlIlIIIIII);
        lllllllllllllllIIlllIIIlIIlllIlI.writeShort(lllllllllllllllIIlllIIIlIIlllIII);
        lllllllllllllllIIlllIIIlIIlllIlI.writeShort(lllllllllllllllIIlllIIIlIIlllllI);
        if (lllllllllllllllIIlllIIIlIIllIllI == null) {
            lllllllllllllllIIlllIIIlIIlllIlI.writeShort(0);
        }
        else {
            final int lllllllllllllllIIlllIIIlIlIIIIll = lllllllllllllllIIlllIIIlIIllIllI.length;
            lllllllllllllllIIlllIIIlIIlllIlI.writeShort(lllllllllllllllIIlllIIIlIlIIIIll);
            for (int lllllllllllllllIIlllIIIlIlIIIlII = 0; lllllllllllllllIIlllIIIlIlIIIlII < lllllllllllllllIIlllIIIlIlIIIIll; ++lllllllllllllllIIlllIIIlIlIIIlII) {
                lllllllllllllllIIlllIIIlIIlllIlI.writeShort(lllllllllllllllIIlllIIIlIIllIllI[lllllllllllllllIIlllIIIlIlIIIlII]);
            }
        }
        lllllllllllllllIIlllIIIlIIlllIlI.writeShort(this.fields.size());
        this.fields.write(lllllllllllllllIIlllIIIlIIlllIlI);
        lllllllllllllllIIlllIIIlIIlllIlI.writeShort(this.methods.numOfMethods());
        this.methods.write(lllllllllllllllIIlllIIIlIIlllIlI);
        if (lllllllllllllllIIlllIIIlIIllIlIl == null) {
            lllllllllllllllIIlllIIIlIIlllIlI.writeShort(0);
        }
        else {
            lllllllllllllllIIlllIIIlIIlllIlI.writeShort(lllllllllllllllIIlllIIIlIIllIlIl.size());
            lllllllllllllllIIlllIIIlIIllIlIl.write(lllllllllllllllIIlllIIIlIIlllIlI);
        }
    }
    
    public byte[] end(final int lllllllllllllllIIlllIIIlIlIlIlII, final int lllllllllllllllIIlllIIIlIlIllIIl, final int lllllllllllllllIIlllIIIlIlIllIII, final int[] lllllllllllllllIIlllIIIlIlIlIlll, final AttributeWriter lllllllllllllllIIlllIIIlIlIlIllI) {
        this.constPool.end();
        this.output.writeShort(lllllllllllllllIIlllIIIlIlIlIlII);
        this.output.writeShort(lllllllllllllllIIlllIIIlIlIllIIl);
        this.output.writeShort(lllllllllllllllIIlllIIIlIlIllIII);
        if (lllllllllllllllIIlllIIIlIlIlIlll == null) {
            this.output.writeShort(0);
        }
        else {
            final int lllllllllllllllIIlllIIIlIlIlllII = lllllllllllllllIIlllIIIlIlIlIlll.length;
            this.output.writeShort(lllllllllllllllIIlllIIIlIlIlllII);
            for (int lllllllllllllllIIlllIIIlIlIlllIl = 0; lllllllllllllllIIlllIIIlIlIlllIl < lllllllllllllllIIlllIIIlIlIlllII; ++lllllllllllllllIIlllIIIlIlIlllIl) {
                this.output.writeShort(lllllllllllllllIIlllIIIlIlIlIlll[lllllllllllllllIIlllIIIlIlIlllIl]);
            }
        }
        this.output.enlarge(this.fields.dataSize() + this.methods.dataSize() + 6);
        try {
            this.output.writeShort(this.fields.size());
            this.fields.write(this.output);
            this.output.writeShort(this.methods.numOfMethods());
            this.methods.write(this.output);
        }
        catch (IOException ex) {}
        writeAttribute(this.output, lllllllllllllllIIlllIIIlIlIlIllI, 0);
        return this.output.toByteArray();
    }
    
    public MethodWriter getMethodWriter() {
        return this.methods;
    }
    
    public ClassFileWriter(final int lllllllllllllllIIlllIIIlIlllIIll, final int lllllllllllllllIIlllIIIlIlllIIlI) {
        this.output = new ByteStream(512);
        this.output.writeInt(-889275714);
        this.output.writeShort(lllllllllllllllIIlllIIIlIlllIIlI);
        this.output.writeShort(lllllllllllllllIIlllIIIlIlllIIll);
        this.constPool = new ConstPoolWriter(this.output);
        this.fields = new FieldWriter(this.constPool);
        this.methods = new MethodWriter(this.constPool);
    }
    
    public ConstPoolWriter getConstPool() {
        return this.constPool;
    }
    
    static void writeAttribute(final ByteStream lllllllllllllllIIlllIIIlIIlIlIIl, final AttributeWriter lllllllllllllllIIlllIIIlIIlIllII, final int lllllllllllllllIIlllIIIlIIlIIlll) {
        if (lllllllllllllllIIlllIIIlIIlIllII == null) {
            lllllllllllllllIIlllIIIlIIlIlIIl.writeShort(lllllllllllllllIIlllIIIlIIlIIlll);
            return;
        }
        lllllllllllllllIIlllIIIlIIlIlIIl.writeShort(lllllllllllllllIIlllIIIlIIlIllII.size() + lllllllllllllllIIlllIIIlIIlIIlll);
        final DataOutputStream lllllllllllllllIIlllIIIlIIlIlIlI = new DataOutputStream(lllllllllllllllIIlllIIIlIIlIlIIl);
        try {
            lllllllllllllllIIlllIIIlIIlIllII.write(lllllllllllllllIIlllIIIlIIlIlIlI);
            lllllllllllllllIIlllIIIlIIlIlIlI.flush();
        }
        catch (IOException ex) {}
    }
    
    public static final class FieldWriter
    {
        protected /* synthetic */ ConstPoolWriter constPool;
        private /* synthetic */ int fieldCount;
        protected /* synthetic */ ByteStream output;
        
        void write(final OutputStream llllllllllllllIIIIIIllIllIllllII) throws IOException {
            this.output.writeTo(llllllllllllllIIIIIIllIllIllllII);
        }
        
        public void add(final int llllllllllllllIIIIIIllIllllIIIll, final String llllllllllllllIIIIIIllIllllIIIlI, final String llllllllllllllIIIIIIllIlllIllIlI, final AttributeWriter llllllllllllllIIIIIIllIllllIIIII) {
            final int llllllllllllllIIIIIIllIlllIlllll = this.constPool.addUtf8Info(llllllllllllllIIIIIIllIllllIIIlI);
            final int llllllllllllllIIIIIIllIlllIllllI = this.constPool.addUtf8Info(llllllllllllllIIIIIIllIlllIllIlI);
            this.add(llllllllllllllIIIIIIllIllllIIIll, llllllllllllllIIIIIIllIlllIlllll, llllllllllllllIIIIIIllIlllIllllI, llllllllllllllIIIIIIllIllllIIIII);
        }
        
        FieldWriter(final ConstPoolWriter llllllllllllllIIIIIIllIllllIllII) {
            this.output = new ByteStream(128);
            this.constPool = llllllllllllllIIIIIIllIllllIllII;
            this.fieldCount = 0;
        }
        
        public void add(final int llllllllllllllIIIIIIllIlllIlIIII, final int llllllllllllllIIIIIIllIlllIIlIlI, final int llllllllllllllIIIIIIllIlllIIlllI, final AttributeWriter llllllllllllllIIIIIIllIlllIIlIII) {
            ++this.fieldCount;
            this.output.writeShort(llllllllllllllIIIIIIllIlllIlIIII);
            this.output.writeShort(llllllllllllllIIIIIIllIlllIIlIlI);
            this.output.writeShort(llllllllllllllIIIIIIllIlllIIlllI);
            ClassFileWriter.writeAttribute(this.output, llllllllllllllIIIIIIllIlllIIlIII, 0);
        }
        
        int dataSize() {
            return this.output.size();
        }
        
        int size() {
            return this.fieldCount;
        }
    }
    
    public static final class ConstPoolWriter
    {
        /* synthetic */ ByteStream output;
        protected /* synthetic */ int num;
        protected /* synthetic */ int startPos;
        
        public int addClassInfo(final int lllllllllllllIIIIIllIlIlllIlIIII) {
            this.output.write(7);
            this.output.writeShort(lllllllllllllIIIIIllIlIlllIlIIII);
            return this.num++;
        }
        
        public int addMethodTypeInfo(final int lllllllllllllIIIIIllIlIllIIlIIlI) {
            this.output.write(16);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIIlIIlI);
            return this.num++;
        }
        
        public int addNameAndTypeInfo(final int lllllllllllllIIIIIllIlIlllIIIIII, final int lllllllllllllIIIIIllIlIllIllllll) {
            this.output.write(12);
            this.output.writeShort(lllllllllllllIIIIIllIlIlllIIIIII);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIllllll);
            return this.num++;
        }
        
        public int addFieldrefInfo(final int lllllllllllllIIIIIllIlIllIllIlll, final int lllllllllllllIIIIIllIlIllIllIIll) {
            this.output.write(9);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIllIlll);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIllIIll);
            return this.num++;
        }
        
        public int addLongInfo(final long lllllllllllllIIIIIllIlIlIllIIIll) {
            this.output.write(5);
            this.output.writeLong(lllllllllllllIIIIIllIlIlIllIIIll);
            final int lllllllllllllIIIIIllIlIlIllIIlIl = this.num;
            this.num += 2;
            return lllllllllllllIIIIIllIlIlIllIIlIl;
        }
        
        public int addMethodrefInfo(final int lllllllllllllIIIIIllIlIllIlIlIll, final int lllllllllllllIIIIIllIlIllIlIllIl) {
            this.output.write(10);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIlIlIll);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIlIllIl);
            return this.num++;
        }
        
        public int addMethodHandleInfo(final int lllllllllllllIIIIIllIlIllIIllIIl, final int lllllllllllllIIIIIllIlIllIIllIII) {
            this.output.write(15);
            this.output.write(lllllllllllllIIIIIllIlIllIIllIIl);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIIllIII);
            return this.num++;
        }
        
        public int addFloatInfo(final float lllllllllllllIIIIIllIlIlIllIllIl) {
            this.output.write(4);
            this.output.writeFloat(lllllllllllllIIIIIllIlIlIllIllIl);
            return this.num++;
        }
        
        void end() {
            this.output.writeShort(this.startPos, this.num);
        }
        
        ConstPoolWriter(final ByteStream lllllllllllllIIIIIllIlIllllIlllI) {
            this.output = lllllllllllllIIIIIllIlIllllIlllI;
            this.startPos = lllllllllllllIIIIIllIlIllllIlllI.getPos();
            this.num = 1;
            this.output.writeShort(1);
        }
        
        public int addStringInfo(final String lllllllllllllIIIIIllIlIlIllllIll) {
            final int lllllllllllllIIIIIllIlIlIllllIlI = this.addUtf8Info(lllllllllllllIIIIIllIlIlIllllIll);
            this.output.write(8);
            this.output.writeShort(lllllllllllllIIIIIllIlIlIllllIlI);
            return this.num++;
        }
        
        public int addNameAndTypeInfo(final String lllllllllllllIIIIIllIlIlllIIlIIl, final String lllllllllllllIIIIIllIlIlllIIIlIl) {
            return this.addNameAndTypeInfo(this.addUtf8Info(lllllllllllllIIIIIllIlIlllIIlIIl), this.addUtf8Info(lllllllllllllIIIIIllIlIlllIIIlIl));
        }
        
        public int addDoubleInfo(final double lllllllllllllIIIIIllIlIlIlIllIlI) {
            this.output.write(6);
            this.output.writeDouble(lllllllllllllIIIIIllIlIlIlIllIlI);
            final int lllllllllllllIIIIIllIlIlIlIlllII = this.num;
            this.num += 2;
            return lllllllllllllIIIIIllIlIlIlIlllII;
        }
        
        public int addIntegerInfo(final int lllllllllllllIIIIIllIlIlIlllIIll) {
            this.output.write(3);
            this.output.writeInt(lllllllllllllIIIIIllIlIlIlllIIll);
            return this.num++;
        }
        
        public int addClassInfo(final String lllllllllllllIIIIIllIlIlllIlIlIl) {
            final int lllllllllllllIIIIIllIlIlllIlIlll = this.addUtf8Info(lllllllllllllIIIIIllIlIlllIlIlIl);
            this.output.write(7);
            this.output.writeShort(lllllllllllllIIIIIllIlIlllIlIlll);
            return this.num++;
        }
        
        public int addUtf8Info(final String lllllllllllllIIIIIllIlIlIlIlIlIl) {
            this.output.write(1);
            this.output.writeUTF(lllllllllllllIIIIIllIlIlIlIlIlIl);
            return this.num++;
        }
        
        public int[] addClassInfo(final String[] lllllllllllllIIIIIllIlIllllIIIII) {
            final int lllllllllllllIIIIIllIlIllllIIIll = lllllllllllllIIIIIllIlIllllIIIII.length;
            final int[] lllllllllllllIIIIIllIlIllllIIIlI = new int[lllllllllllllIIIIIllIlIllllIIIll];
            for (int lllllllllllllIIIIIllIlIllllIIllI = 0; lllllllllllllIIIIIllIlIllllIIllI < lllllllllllllIIIIIllIlIllllIIIll; ++lllllllllllllIIIIIllIlIllllIIllI) {
                lllllllllllllIIIIIllIlIllllIIIlI[lllllllllllllIIIIIllIlIllllIIllI] = this.addClassInfo(lllllllllllllIIIIIllIlIllllIIIII[lllllllllllllIIIIIllIlIllllIIllI]);
            }
            return lllllllllllllIIIIIllIlIllllIIIlI;
        }
        
        public int addDynamicInfo(final int lllllllllllllIIIIIllIlIllIIIIIIl, final int lllllllllllllIIIIIllIlIllIIIIIll) {
            this.output.write(17);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIIIIIIl);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIIIIIll);
            return this.num++;
        }
        
        public int addInterfaceMethodrefInfo(final int lllllllllllllIIIIIllIlIllIlIIlIl, final int lllllllllllllIIIIIllIlIllIlIIlII) {
            this.output.write(11);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIlIIlIl);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIlIIlII);
            return this.num++;
        }
        
        public int addInvokeDynamicInfo(final int lllllllllllllIIIIIllIlIllIIIlIlI, final int lllllllllllllIIIIIllIlIllIIIllII) {
            this.output.write(18);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIIIlIlI);
            this.output.writeShort(lllllllllllllIIIIIllIlIllIIIllII);
            return this.num++;
        }
    }
    
    public interface AttributeWriter
    {
        int size();
        
        void write(final DataOutputStream p0) throws IOException;
    }
    
    public static final class MethodWriter
    {
        protected /* synthetic */ ConstPoolWriter constPool;
        protected /* synthetic */ int throwsIndex;
        private /* synthetic */ boolean isAbstract;
        protected /* synthetic */ int codeIndex;
        protected /* synthetic */ int stackIndex;
        protected /* synthetic */ ByteStream output;
        private /* synthetic */ int catchCount;
        private /* synthetic */ int methodCount;
        private /* synthetic */ int startPos;
        private /* synthetic */ int catchPos;
        
        private void writeThrows(final int[] llllllllllllllIlllIlIIlIIIlIlllI) {
            if (this.throwsIndex == 0) {
                this.throwsIndex = this.constPool.addUtf8Info("Exceptions");
            }
            this.output.writeShort(this.throwsIndex);
            this.output.writeInt(llllllllllllllIlllIlIIlIIIlIlllI.length * 2 + 2);
            this.output.writeShort(llllllllllllllIlllIlIIlIIIlIlllI.length);
            for (int llllllllllllllIlllIlIIlIIIllIIlI = 0; llllllllllllllIlllIlIIlIIIllIIlI < llllllllllllllIlllIlIIlIIIlIlllI.length; ++llllllllllllllIlllIlIIlIIIllIIlI) {
                this.output.writeShort(llllllllllllllIlllIlIIlIIIlIlllI[llllllllllllllIlllIlIIlIIIllIIlI]);
            }
        }
        
        public void add(final int llllllllllllllIlllIlIIlIIIlIlIIl) {
            this.output.write(llllllllllllllIlllIlIIlIIIlIlIIl);
        }
        
        public void codeEnd(final int llllllllllllllIlllIlIIIllllllIll, final int llllllllllllllIlllIlIIIllllllIlI) {
            if (!this.isAbstract) {
                this.output.writeShort(this.startPos + 6, llllllllllllllIlllIlIIIllllllIll);
                this.output.writeShort(this.startPos + 8, llllllllllllllIlllIlIIIllllllIlI);
                this.output.writeInt(this.startPos + 10, this.output.getPos() - this.startPos - 14);
                this.catchPos = this.output.getPos();
                this.catchCount = 0;
                this.output.writeShort(0);
            }
        }
        
        public void addInvoke(final int llllllllllllllIlllIlIIlIIIIIlIIl, final String llllllllllllllIlllIlIIlIIIIlIIII, final String llllllllllllllIlllIlIIlIIIIIllll, final String llllllllllllllIlllIlIIlIIIIIIllI) {
            final int llllllllllllllIlllIlIIlIIIIIllIl = this.constPool.addClassInfo(llllllllllllllIlllIlIIlIIIIlIIII);
            final int llllllllllllllIlllIlIIlIIIIIllII = this.constPool.addNameAndTypeInfo(llllllllllllllIlllIlIIlIIIIIllll, llllllllllllllIlllIlIIlIIIIIIllI);
            final int llllllllllllllIlllIlIIlIIIIIlIll = this.constPool.addMethodrefInfo(llllllllllllllIlllIlIIlIIIIIllIl, llllllllllllllIlllIlIIlIIIIIllII);
            this.add(llllllllllllllIlllIlIIlIIIIIlIIl);
            this.add16(llllllllllllllIlllIlIIlIIIIIlIll);
        }
        
        public void add32(final int llllllllllllllIlllIlIIlIIIIllIll) {
            this.output.writeInt(llllllllllllllIlllIlIIlIIIIllIll);
        }
        
        public void begin(final int llllllllllllllIlllIlIIlIIIlllIll, final int llllllllllllllIlllIlIIlIIIlllIlI, final int llllllllllllllIlllIlIIlIIlIIIIII, final int[] llllllllllllllIlllIlIIlIIIlllIII, final AttributeWriter llllllllllllllIlllIlIIlIIIlllllI) {
            ++this.methodCount;
            this.output.writeShort(llllllllllllllIlllIlIIlIIIlllIll);
            this.output.writeShort(llllllllllllllIlllIlIIlIIIlllIlI);
            this.output.writeShort(llllllllllllllIlllIlIIlIIlIIIIII);
            this.isAbstract = ((llllllllllllllIlllIlIIlIIIlllIll & 0x400) != 0x0);
            int llllllllllllllIlllIlIIlIIIllllIl = this.isAbstract ? 0 : 1;
            if (llllllllllllllIlllIlIIlIIIlllIII != null) {
                ++llllllllllllllIlllIlIIlIIIllllIl;
            }
            ClassFileWriter.writeAttribute(this.output, llllllllllllllIlllIlIIlIIIlllllI, llllllllllllllIlllIlIIlIIIllllIl);
            if (llllllllllllllIlllIlIIlIIIlllIII != null) {
                this.writeThrows(llllllllllllllIlllIlIIlIIIlllIII);
            }
            if (!this.isAbstract) {
                if (this.codeIndex == 0) {
                    this.codeIndex = this.constPool.addUtf8Info("Code");
                }
                this.startPos = this.output.getPos();
                this.output.writeShort(this.codeIndex);
                this.output.writeBlank(12);
            }
            this.catchPos = -1;
            this.catchCount = 0;
        }
        
        public void end(final StackMapTable.Writer llllllllllllllIlllIlIIIllllIIIll, final AttributeWriter llllllllllllllIlllIlIIIllllIIIlI) {
            if (this.isAbstract) {
                return;
            }
            this.output.writeShort(this.catchPos, this.catchCount);
            final int llllllllllllllIlllIlIIIllllIIIIl = (llllllllllllllIlllIlIIIllllIIIll != null) ? 1 : 0;
            ClassFileWriter.writeAttribute(this.output, llllllllllllllIlllIlIIIllllIIIlI, llllllllllllllIlllIlIIIllllIIIIl);
            if (llllllllllllllIlllIlIIIllllIIIll != null) {
                if (this.stackIndex == 0) {
                    this.stackIndex = this.constPool.addUtf8Info("StackMapTable");
                }
                this.output.writeShort(this.stackIndex);
                final byte[] llllllllllllllIlllIlIIIllllIIlIl = llllllllllllllIlllIlIIIllllIIIll.toByteArray();
                this.output.writeInt(llllllllllllllIlllIlIIIllllIIlIl.length);
                this.output.write(llllllllllllllIlllIlIIIllllIIlIl);
            }
            this.output.writeInt(this.startPos + 2, this.output.getPos() - this.startPos - 6);
        }
        
        int numOfMethods() {
            return this.methodCount;
        }
        
        void write(final OutputStream llllllllllllllIlllIlIIIlllIIllll) throws IOException {
            this.output.writeTo(llllllllllllllIlllIlIIIlllIIllll);
        }
        
        public void add16(final int llllllllllllllIlllIlIIlIIIlIIIll) {
            this.output.writeShort(llllllllllllllIlllIlIIlIIIlIIIll);
        }
        
        public int size() {
            return this.output.getPos() - this.startPos - 14;
        }
        
        public void addCatch(final int llllllllllllllIlllIlIIIllllIlllI, final int llllllllllllllIlllIlIIIllllIllIl, final int llllllllllllllIlllIlIIIllllIllII, final int llllllllllllllIlllIlIIIlllllIIII) {
            ++this.catchCount;
            this.output.writeShort(llllllllllllllIlllIlIIIllllIlllI);
            this.output.writeShort(llllllllllllllIlllIlIIIllllIllIl);
            this.output.writeShort(llllllllllllllIlllIlIIIllllIllII);
            this.output.writeShort(llllllllllllllIlllIlIIIlllllIIII);
        }
        
        public void begin(final int llllllllllllllIlllIlIIlIIlIllIll, final String llllllllllllllIlllIlIIlIIlIllIlI, final String llllllllllllllIlllIlIIlIIlIlIIII, final String[] llllllllllllllIlllIlIIlIIlIllIII, final AttributeWriter llllllllllllllIlllIlIIlIIlIlIlll) {
            final int llllllllllllllIlllIlIIlIIlIlIllI = this.constPool.addUtf8Info(llllllllllllllIlllIlIIlIIlIllIlI);
            final int llllllllllllllIlllIlIIlIIlIlIlIl = this.constPool.addUtf8Info(llllllllllllllIlllIlIIlIIlIlIIII);
            int[] llllllllllllllIlllIlIIlIIlIlIlII = null;
            if (llllllllllllllIlllIlIIlIIlIllIII == null) {
                final int[] llllllllllllllIlllIlIIlIIlIlllIl = null;
            }
            else {
                llllllllllllllIlllIlIIlIIlIlIlII = this.constPool.addClassInfo(llllllllllllllIlllIlIIlIIlIllIII);
            }
            this.begin(llllllllllllllIlllIlIIlIIlIllIll, llllllllllllllIlllIlIIlIIlIlIllI, llllllllllllllIlllIlIIlIIlIlIlIl, llllllllllllllIlllIlIIlIIlIlIlII, llllllllllllllIlllIlIIlIIlIlIlll);
        }
        
        MethodWriter(final ConstPoolWriter llllllllllllllIlllIlIIlIIllIIlll) {
            this.output = new ByteStream(256);
            this.constPool = llllllllllllllIlllIlIIlIIllIIlll;
            this.methodCount = 0;
            this.codeIndex = 0;
            this.throwsIndex = 0;
            this.stackIndex = 0;
        }
        
        int dataSize() {
            return this.output.size();
        }
    }
}
