package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;

public class Bytecode extends ByteVector implements Cloneable, Opcode
{
    private /* synthetic */ int stackDepth;
    /* synthetic */ ConstPool constPool;
    public static final /* synthetic */ CtClass THIS;
    /* synthetic */ int maxLocals;
    /* synthetic */ int maxStack;
    /* synthetic */ ExceptionTable tryblocks;
    
    public void addOpcode(final int lllllllllllllllllIlIIIIlIlllIIlI) {
        this.add(lllllllllllllllllIlIIIIlIlllIIlI);
        this.growStack(Bytecode.STACK_GROW[lllllllllllllllllIlIIIIlIlllIIlI]);
    }
    
    public void addDstore(final int lllllllllllllllllIlIIIIlIIIlIIll) {
        if (lllllllllllllllllIlIIIIlIIIlIIll < 4) {
            this.addOpcode(71 + lllllllllllllllllIlIIIIlIIIlIIll);
        }
        else if (lllllllllllllllllIlIIIIlIIIlIIll < 256) {
            this.addOpcode(57);
            this.add(lllllllllllllllllIlIIIIlIIIlIIll);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(57);
            this.addIndex(lllllllllllllllllIlIIIIlIIIlIIll);
        }
    }
    
    public void addIndex(final int lllllllllllllllllIlIIIIlIlIllIll) {
        this.add(lllllllllllllllllIlIIIIlIlIllIll >> 8, lllllllllllllllllIlIIIIlIlIllIll);
    }
    
    public void addInvokeinterface(final int lllllllllllllllllIIlllllIllllIII, final String lllllllllllllllllIIlllllIlllIlll, final String lllllllllllllllllIIlllllIlllIllI, final int lllllllllllllllllIIlllllIlllIlIl) {
        this.add(185);
        this.addIndex(this.constPool.addInterfaceMethodrefInfo(lllllllllllllllllIIlllllIllllIII, lllllllllllllllllIIlllllIlllIlll, lllllllllllllllllIIlllllIlllIllI));
        this.add(lllllllllllllllllIIlllllIlllIlIl);
        this.add(0);
        this.growStack(Descriptor.dataSize(lllllllllllllllllIIlllllIlllIllI) - 1);
    }
    
    @Override
    public Object clone() {
        try {
            final Bytecode lllllllllllllllllIlIIIlIIIllIlll = (Bytecode)super.clone();
            lllllllllllllllllIlIIIlIIIllIlll.tryblocks = (ExceptionTable)this.tryblocks.clone();
            return lllllllllllllllllIlIIIlIIIllIlll;
        }
        catch (CloneNotSupportedException lllllllllllllllllIlIIIlIIIllIllI) {
            throw new RuntimeException(lllllllllllllllllIlIIIlIIIllIllI);
        }
    }
    
    public void addInvokestatic(final String lllllllllllllllllIlIIIIIIIIlIIlI, final String lllllllllllllllllIlIIIIIIIIlIIIl, final String lllllllllllllllllIlIIIIIIIIlIIII) {
        this.addInvokestatic(this.constPool.addClassInfo(lllllllllllllllllIlIIIIIIIIlIIlI), lllllllllllllllllIlIIIIIIIIlIIIl, lllllllllllllllllIlIIIIIIIIlIIII);
    }
    
    public void setMaxLocals(final int lllllllllllllllllIlIIIlIIIIlIlII) {
        this.maxLocals = lllllllllllllllllIlIIIlIIIIlIlII;
    }
    
    public void addInvokevirtual(final CtClass lllllllllllllllllIIlllllllIlllll, final String lllllllllllllllllIIllllllllIIlII, final CtClass lllllllllllllllllIIlllllllIlllIl, final CtClass[] lllllllllllllllllIIlllllllIlllII) {
        final String lllllllllllllllllIIllllllllIIIIl = Descriptor.ofMethod(lllllllllllllllllIIlllllllIlllIl, lllllllllllllllllIIlllllllIlllII);
        this.addInvokevirtual(lllllllllllllllllIIlllllllIlllll, lllllllllllllllllIIllllllllIIlII, lllllllllllllllllIIllllllllIIIIl);
    }
    
    public void addLconst(final long lllllllllllllllllIlIIIIlIIllIIll) {
        if (lllllllllllllllllIlIIIIlIIllIIll == 0L || lllllllllllllllllIlIIIIlIIllIIll == 1L) {
            this.addOpcode(9 + (int)lllllllllllllllllIlIIIIlIIllIIll);
        }
        else {
            this.addLdc2w(lllllllllllllllllIlIIIIlIIllIIll);
        }
    }
    
    public void addNew(final String lllllllllllllllllIIlllllIIllllll) {
        this.addOpcode(187);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIIlllllIIllllll));
    }
    
    public void addInvokevirtual(final int lllllllllllllllllIIllllllIlllIIl, final String lllllllllllllllllIIllllllIlllIII, final String lllllllllllllllllIIllllllIlllIll) {
        this.add(182);
        this.addIndex(this.constPool.addMethodrefInfo(lllllllllllllllllIIllllllIlllIIl, lllllllllllllllllIIllllllIlllIII, lllllllllllllllllIIllllllIlllIll));
        this.growStack(Descriptor.dataSize(lllllllllllllllllIIllllllIlllIll) - 1);
    }
    
    public void addInvokeinterface(final CtClass lllllllllllllllllIIllllllIIllIll, final String lllllllllllllllllIIllllllIIlIlIl, final String lllllllllllllllllIIllllllIIlIlII, final int lllllllllllllllllIIllllllIIllIII) {
        this.addInvokeinterface(this.constPool.addClassInfo(lllllllllllllllllIIllllllIIllIll), lllllllllllllllllIIllllllIIlIlIl, lllllllllllllllllIIllllllIIlIlII, lllllllllllllllllIIllllllIIllIII);
    }
    
    public void addNew(final CtClass lllllllllllllllllIIlllllIlIIIlIl) {
        this.addOpcode(187);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIIlllllIlIIIlIl));
    }
    
    public void addGetfield(final CtClass lllllllllllllllllIlIIIIIlIllllll, final String lllllllllllllllllIlIIIIIllIIIIll, final String lllllllllllllllllIlIIIIIlIllllIl) {
        this.add(180);
        final int lllllllllllllllllIlIIIIIllIIIIIl = this.constPool.addClassInfo(lllllllllllllllllIlIIIIIlIllllll);
        this.addIndex(this.constPool.addFieldrefInfo(lllllllllllllllllIlIIIIIllIIIIIl, lllllllllllllllllIlIIIIIllIIIIll, lllllllllllllllllIlIIIIIlIllllIl));
        this.growStack(Descriptor.dataSize(lllllllllllllllllIlIIIIIlIllllIl) - 1);
    }
    
    public int addMultiNewarray(final String lllllllllllllllllIIlllllIIIIlIlI, final int lllllllllllllllllIIlllllIIIIlIIl) {
        this.add(197);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIIlllllIIIIlIlI));
        this.add(lllllllllllllllllIIlllllIIIIlIIl);
        this.growStack(1 - lllllllllllllllllIIlllllIIIIlIIl);
        return lllllllllllllllllIIlllllIIIIlIIl;
    }
    
    public void addIstore(final int lllllllllllllllllIlIIIIlIIlllIIl) {
        if (lllllllllllllllllIlIIIIlIIlllIIl < 4) {
            this.addOpcode(59 + lllllllllllllllllIlIIIIlIIlllIIl);
        }
        else if (lllllllllllllllllIlIIIIlIIlllIIl < 256) {
            this.addOpcode(54);
            this.add(lllllllllllllllllIlIIIIlIIlllIIl);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(54);
            this.addIndex(lllllllllllllllllIlIIIIlIIlllIIl);
        }
    }
    
    public void addRet(final int lllllllllllllllllIIllllIlIlIIlIl) {
        if (lllllllllllllllllIIllllIlIlIIlIl < 256) {
            this.addOpcode(169);
            this.add(lllllllllllllllllIIllllIlIlIIlIl);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(169);
            this.addIndex(lllllllllllllllllIIllllIlIlIIlIl);
        }
    }
    
    public void addDconst(final double lllllllllllllllllIlIIIIlIIIlllll) {
        if (lllllllllllllllllIlIIIIlIIIlllll == 0.0 || lllllllllllllllllIlIIIIlIIIlllll == 1.0) {
            this.addOpcode(14 + (int)lllllllllllllllllIlIIIIlIIIlllll);
        }
        else {
            this.addLdc2w(lllllllllllllllllIlIIIIlIIIlllll);
        }
    }
    
    public void addInvokespecial(final int lllllllllllllllllIlIIIIIIIlllllI, final String lllllllllllllllllIlIIIIIIIlllIlI) {
        this.add(183);
        this.addIndex(lllllllllllllllllIlIIIIIIIlllllI);
        this.growStack(Descriptor.dataSize(lllllllllllllllllIlIIIIIIIlllIlI) - 1);
    }
    
    public void addGetfield(final String lllllllllllllllllIlIIIIIlIllIIII, final String lllllllllllllllllIlIIIIIlIlIllll, final String lllllllllllllllllIlIIIIIlIllIIll) {
        this.add(180);
        final int lllllllllllllllllIlIIIIIlIllIIlI = this.constPool.addClassInfo(lllllllllllllllllIlIIIIIlIllIIII);
        this.addIndex(this.constPool.addFieldrefInfo(lllllllllllllllllIlIIIIIlIllIIlI, lllllllllllllllllIlIIIIIlIlIllll, lllllllllllllllllIlIIIIIlIllIIll));
        this.growStack(Descriptor.dataSize(lllllllllllllllllIlIIIIIlIllIIll) - 1);
    }
    
    public CodeAttribute toCodeAttribute() {
        return new CodeAttribute(this.constPool, this.maxStack, this.maxLocals, this.get(), this.tryblocks);
    }
    
    public void addExceptionHandler(final int lllllllllllllllllIlIIIIlllIIllII, final int lllllllllllllllllIlIIIIlllIIlIll, final int lllllllllllllllllIlIIIIlllIIlIlI, final int lllllllllllllllllIlIIIIlllIIlIIl) {
        this.tryblocks.add(lllllllllllllllllIlIIIIlllIIllII, lllllllllllllllllIlIIIIlllIIlIll, lllllllllllllllllIlIIIIlllIIlIlI, lllllllllllllllllIlIIIIlllIIlIIl);
    }
    
    @Override
    public void addGap(final int lllllllllllllllllIlIIIIlIllllIII) {
        super.addGap(lllllllllllllllllIlIIIIlIllllIII);
    }
    
    public int getMaxStack() {
        return this.maxStack;
    }
    
    public int addMultiNewarray(final CtClass lllllllllllllllllIIlllllIIIlIIII, final int lllllllllllllllllIIlllllIIIIllll) {
        this.add(197);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIIlllllIIIlIIII));
        this.add(lllllllllllllllllIIlllllIIIIllll);
        this.growStack(1 - lllllllllllllllllIIlllllIIIIllll);
        return lllllllllllllllllIIlllllIIIIllll;
    }
    
    public void addFstore(final int lllllllllllllllllIlIIIIlIIIIIIll) {
        if (lllllllllllllllllIlIIIIlIIIIIIll < 4) {
            this.addOpcode(67 + lllllllllllllllllIlIIIIlIIIIIIll);
        }
        else if (lllllllllllllllllIlIIIIlIIIIIIll < 256) {
            this.addOpcode(56);
            this.add(lllllllllllllllllIlIIIIlIIIIIIll);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(56);
            this.addIndex(lllllllllllllllllIlIIIIlIIIIIIll);
        }
    }
    
    public void addGetstatic(final CtClass lllllllllllllllllIlIIIIIlIlIIllI, final String lllllllllllllllllIlIIIIIlIlIIIII, final String lllllllllllllllllIlIIIIIlIlIIlII) {
        this.add(178);
        final int lllllllllllllllllIlIIIIIlIlIIIll = this.constPool.addClassInfo(lllllllllllllllllIlIIIIIlIlIIllI);
        this.addIndex(this.constPool.addFieldrefInfo(lllllllllllllllllIlIIIIIlIlIIIll, lllllllllllllllllIlIIIIIlIlIIIII, lllllllllllllllllIlIIIIIlIlIIlII));
        this.growStack(Descriptor.dataSize(lllllllllllllllllIlIIIIIlIlIIlII));
    }
    
    public void addLdc2w(final long lllllllllllllllllIIlllllIlIlIIIl) {
        this.addOpcode(20);
        this.addIndex(this.constPool.addLongInfo(lllllllllllllllllIIlllllIlIlIIIl));
    }
    
    public void addInvokespecial(final String lllllllllllllllllIlIIIIIIllIIlII, final String lllllllllllllllllIlIIIIIIllIIlll, final String lllllllllllllllllIlIIIIIIllIIllI) {
        this.addInvokespecial(false, this.constPool.addClassInfo(lllllllllllllllllIlIIIIIIllIIlII), lllllllllllllllllIlIIIIIIllIIlll, lllllllllllllllllIlIIIIIIllIIllI);
    }
    
    public void addInstanceof(final String lllllllllllllllllIlIIIIIllIIlIll) {
        this.addOpcode(193);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIlIIIIIllIIlIll));
    }
    
    public void addPutfield(final String lllllllllllllllllIIllllIllllIIII, final String lllllllllllllllllIIllllIllllIIll, final String lllllllllllllllllIIllllIllllIIlI) {
        this.addPutfield0(null, lllllllllllllllllIIllllIllllIIII, lllllllllllllllllIIllllIllllIIll, lllllllllllllllllIIllllIllllIIlI);
    }
    
    public void addInvokeinterface(final CtClass lllllllllllllllllIIllllllIlIlllI, final String lllllllllllllllllIIllllllIlIIllI, final CtClass lllllllllllllllllIIllllllIlIIlIl, final CtClass[] lllllllllllllllllIIllllllIlIIlII, final int lllllllllllllllllIIllllllIlIIIll) {
        final String lllllllllllllllllIIllllllIlIlIIl = Descriptor.ofMethod(lllllllllllllllllIIllllllIlIIlIl, lllllllllllllllllIIllllllIlIIlII);
        this.addInvokeinterface(lllllllllllllllllIIllllllIlIlllI, lllllllllllllllllIIllllllIlIIllI, lllllllllllllllllIIllllllIlIlIIl, lllllllllllllllllIIllllllIlIIIll);
    }
    
    public void addAload(final int lllllllllllllllllIlIIIIlIlIlIlll) {
        if (lllllllllllllllllIlIIIIlIlIlIlll < 4) {
            this.addOpcode(42 + lllllllllllllllllIlIIIIlIlIlIlll);
        }
        else if (lllllllllllllllllIlIIIIlIlIlIlll < 256) {
            this.addOpcode(25);
            this.add(lllllllllllllllllIlIIIIlIlIlIlll);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(25);
            this.addIndex(lllllllllllllllllIlIIIIlIlIlIlll);
        }
    }
    
    public int addLoad(final int lllllllllllllllllIlIIIIIlllllIIl, final CtClass lllllllllllllllllIlIIIIIlllllIll) {
        if (lllllllllllllllllIlIIIIIlllllIll.isPrimitive()) {
            if (lllllllllllllllllIlIIIIIlllllIll == CtClass.booleanType || lllllllllllllllllIlIIIIIlllllIll == CtClass.charType || lllllllllllllllllIlIIIIIlllllIll == CtClass.byteType || lllllllllllllllllIlIIIIIlllllIll == CtClass.shortType || lllllllllllllllllIlIIIIIlllllIll == CtClass.intType) {
                this.addIload(lllllllllllllllllIlIIIIIlllllIIl);
            }
            else {
                if (lllllllllllllllllIlIIIIIlllllIll == CtClass.longType) {
                    this.addLload(lllllllllllllllllIlIIIIIlllllIIl);
                    return 2;
                }
                if (lllllllllllllllllIlIIIIIlllllIll == CtClass.floatType) {
                    this.addFload(lllllllllllllllllIlIIIIIlllllIIl);
                }
                else {
                    if (lllllllllllllllllIlIIIIIlllllIll == CtClass.doubleType) {
                        this.addDload(lllllllllllllllllIlIIIIIlllllIIl);
                        return 2;
                    }
                    throw new RuntimeException("void type?");
                }
            }
        }
        else {
            this.addAload(lllllllllllllllllIlIIIIIlllllIIl);
        }
        return 1;
    }
    
    public void setMaxLocals(final boolean lllllllllllllllllIlIIIlIIIIIIIlI, final CtClass[] lllllllllllllllllIlIIIlIIIIIIIIl, int lllllllllllllllllIlIIIIlllllllII) {
        if (!lllllllllllllllllIlIIIlIIIIIIIlI) {
            ++lllllllllllllllllIlIIIIlllllllII;
        }
        if (lllllllllllllllllIlIIIlIIIIIIIIl != null) {
            final CtClass lllllllllllllllllIlIIIlIIIIIIllI = CtClass.doubleType;
            final CtClass lllllllllllllllllIlIIIlIIIIIIlIl = CtClass.longType;
            for (final CtClass lllllllllllllllllIlIIIlIIIIIlIII : lllllllllllllllllIlIIIlIIIIIIIIl) {
                if (lllllllllllllllllIlIIIlIIIIIlIII == lllllllllllllllllIlIIIlIIIIIIllI || lllllllllllllllllIlIIIlIIIIIlIII == lllllllllllllllllIlIIIlIIIIIIlIl) {
                    lllllllllllllllllIlIIIIlllllllII += 2;
                }
                else {
                    ++lllllllllllllllllIlIIIIlllllllII;
                }
            }
        }
        this.maxLocals = lllllllllllllllllIlIIIIlllllllII;
    }
    
    public void addInvokespecial(final boolean lllllllllllllllllIlIIIIIIlIIIlll, final int lllllllllllllllllIlIIIIIIlIIIllI, final String lllllllllllllllllIlIIIIIIlIIIlIl, final String lllllllllllllllllIlIIIIIIlIIlIlI) {
        int lllllllllllllllllIlIIIIIIlIIlIIl = 0;
        if (lllllllllllllllllIlIIIIIIlIIIlll) {
            final int lllllllllllllllllIlIIIIIIlIIllll = this.constPool.addInterfaceMethodrefInfo(lllllllllllllllllIlIIIIIIlIIIllI, lllllllllllllllllIlIIIIIIlIIIlIl, lllllllllllllllllIlIIIIIIlIIlIlI);
        }
        else {
            lllllllllllllllllIlIIIIIIlIIlIIl = this.constPool.addMethodrefInfo(lllllllllllllllllIlIIIIIIlIIIllI, lllllllllllllllllIlIIIIIIlIIIlIl, lllllllllllllllllIlIIIIIIlIIlIlI);
        }
        this.addInvokespecial(lllllllllllllllllIlIIIIIIlIIlIIl, lllllllllllllllllIlIIIIIIlIIlIlI);
    }
    
    public void write16bit(final int lllllllllllllllllIlIIIIllIIlIlIl, final int lllllllllllllllllIlIIIIllIIlIIIl) {
        this.write(lllllllllllllllllIlIIIIllIIlIlIl, lllllllllllllllllIlIIIIllIIlIIIl >> 8);
        this.write(lllllllllllllllllIlIIIIllIIlIlIl + 1, lllllllllllllllllIlIIIIllIIlIIIl);
    }
    
    public void addLdc2w(final double lllllllllllllllllIIlllllIlIIllIl) {
        this.addOpcode(20);
        this.addIndex(this.constPool.addDoubleInfo(lllllllllllllllllIIlllllIlIIllIl));
    }
    
    public void write32bit(final int lllllllllllllllllIlIIIIllIIIllII, final int lllllllllllllllllIlIIIIllIIIlIII) {
        this.write16bit(lllllllllllllllllIlIIIIllIIIllII, lllllllllllllllllIlIIIIllIIIlIII >> 16);
        this.write16bit(lllllllllllllllllIlIIIIllIIIllII + 2, lllllllllllllllllIlIIIIllIIIlIII);
    }
    
    public void addPrintln(final String lllllllllllllllllIIllllIlIIlllIl) {
        this.addGetstatic("java.lang.System", "err", "Ljava/io/PrintStream;");
        this.addLdc(lllllllllllllllllIIllllIlIIlllIl);
        this.addInvokevirtual("java.io.PrintStream", "println", "(Ljava/lang/String;)V");
    }
    
    @Override
    public void add(final int lllllllllllllllllIlIIIIllIIIIlII) {
        super.add(lllllllllllllllllIlIIIIllIIIIlII);
    }
    
    public void addLdc(final String lllllllllllllllllIIlllllIlIlllIl) {
        this.addLdc(this.constPool.addStringInfo(lllllllllllllllllIIlllllIlIlllIl));
    }
    
    @Override
    public int read(final int lllllllllllllllllIlIIIIllIlllIll) {
        return super.read(lllllllllllllllllIlIIIIllIlllIll);
    }
    
    public void addLdc(final int lllllllllllllllllIIlllllIlIllIIl) {
        if (lllllllllllllllllIIlllllIlIllIIl > 255) {
            this.addOpcode(19);
            this.addIndex(lllllllllllllllllIIlllllIlIllIIl);
        }
        else {
            this.addOpcode(18);
            this.add(lllllllllllllllllIIlllllIlIllIIl);
        }
    }
    
    public void addLstore(final int lllllllllllllllllIlIIIIlIIlIIlIl) {
        if (lllllllllllllllllIlIIIIlIIlIIlIl < 4) {
            this.addOpcode(63 + lllllllllllllllllIlIIIIlIIlIIlIl);
        }
        else if (lllllllllllllllllIlIIIIlIIlIIlIl < 256) {
            this.addOpcode(55);
            this.add(lllllllllllllllllIlIIIIlIIlIIlIl);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(55);
            this.addIndex(lllllllllllllllllIlIIIIlIIlIIlIl);
        }
    }
    
    private void addInvokestatic(final int lllllllllllllllllIIlllllllllIIIl, final String lllllllllllllllllIIlllllllllIIII, final String lllllllllllllllllIIllllllllIllll, final boolean lllllllllllllllllIIlllllllllIlII) {
        this.add(184);
        int lllllllllllllllllIIlllllllllIIll = 0;
        if (lllllllllllllllllIIlllllllllIlII) {
            final int lllllllllllllllllIIllllllllllIIl = this.constPool.addInterfaceMethodrefInfo(lllllllllllllllllIIlllllllllIIIl, lllllllllllllllllIIlllllllllIIII, lllllllllllllllllIIllllllllIllll);
        }
        else {
            lllllllllllllllllIIlllllllllIIll = this.constPool.addMethodrefInfo(lllllllllllllllllIIlllllllllIIIl, lllllllllllllllllIIlllllllllIIII, lllllllllllllllllIIllllllllIllll);
        }
        this.addIndex(lllllllllllllllllIIlllllllllIIll);
        this.growStack(Descriptor.dataSize(lllllllllllllllllIIllllllllIllll));
    }
    
    public void add32bit(final int lllllllllllllllllIlIIIIlIlllllII) {
        this.add(lllllllllllllllllIlIIIIlIlllllII >> 24, lllllllllllllllllIlIIIIlIlllllII >> 16, lllllllllllllllllIlIIIIlIlllllII >> 8, lllllllllllllllllIlIIIIlIlllllII);
    }
    
    public ConstPool getConstPool() {
        return this.constPool;
    }
    
    public void addPutstatic(final CtClass lllllllllllllllllIIllllIllIlIIlI, final String lllllllllllllllllIIllllIllIlIIIl, final String lllllllllllllllllIIllllIllIlIlII) {
        this.addPutstatic0(lllllllllllllllllIIllllIllIlIIlI, null, lllllllllllllllllIIllllIllIlIIIl, lllllllllllllllllIIllllIllIlIlII);
    }
    
    public void addReturn(final CtClass lllllllllllllllllIIllllIlIlIllII) {
        if (lllllllllllllllllIIllllIlIlIllII == null) {
            this.addOpcode(177);
        }
        else if (lllllllllllllllllIIllllIlIlIllII.isPrimitive()) {
            final CtPrimitiveType lllllllllllllllllIIllllIlIlIlllI = (CtPrimitiveType)lllllllllllllllllIIllllIlIlIllII;
            this.addOpcode(lllllllllllllllllIIllllIlIlIlllI.getReturnOp());
        }
        else {
            this.addOpcode(176);
        }
    }
    
    public Bytecode(final ConstPool lllllllllllllllllIlIIIlIIlIIIllI, final int lllllllllllllllllIlIIIlIIlIIIIIl, final int lllllllllllllllllIlIIIlIIlIIIlII) {
        this.constPool = lllllllllllllllllIlIIIlIIlIIIllI;
        this.maxStack = lllllllllllllllllIlIIIlIIlIIIIIl;
        this.maxLocals = lllllllllllllllllIlIIIlIIlIIIlII;
        this.tryblocks = new ExceptionTable(lllllllllllllllllIlIIIlIIlIIIllI);
        this.stackDepth = 0;
    }
    
    private void addPutfield0(final CtClass lllllllllllllllllIIllllIlllIIIII, final String lllllllllllllllllIIllllIllIlllll, final String lllllllllllllllllIIllllIllIllllI, final String lllllllllllllllllIIllllIllIlllIl) {
        this.add(181);
        final int lllllllllllllllllIIllllIlllIIIlI = (lllllllllllllllllIIllllIllIlllll == null) ? this.constPool.addClassInfo(lllllllllllllllllIIllllIlllIIIII) : this.constPool.addClassInfo(lllllllllllllllllIIllllIllIlllll);
        this.addIndex(this.constPool.addFieldrefInfo(lllllllllllllllllIIllllIlllIIIlI, lllllllllllllllllIIllllIllIllllI, lllllllllllllllllIIllllIllIlllIl));
        this.growStack(-1 - Descriptor.dataSize(lllllllllllllllllIIllllIllIlllIl));
    }
    
    @Override
    public void write(final int lllllllllllllllllIlIIIIllIIllllI, final int lllllllllllllllllIlIIIIllIIlllIl) {
        super.write(lllllllllllllllllIlIIIIllIIllllI, lllllllllllllllllIlIIIIllIIlllIl);
    }
    
    public int length() {
        return this.getSize();
    }
    
    public int addStore(final int lllllllllllllllllIlIIIIIllllIIII, final CtClass lllllllllllllllllIlIIIIIllllIIlI) {
        if (lllllllllllllllllIlIIIIIllllIIlI.isPrimitive()) {
            if (lllllllllllllllllIlIIIIIllllIIlI == CtClass.booleanType || lllllllllllllllllIlIIIIIllllIIlI == CtClass.charType || lllllllllllllllllIlIIIIIllllIIlI == CtClass.byteType || lllllllllllllllllIlIIIIIllllIIlI == CtClass.shortType || lllllllllllllllllIlIIIIIllllIIlI == CtClass.intType) {
                this.addIstore(lllllllllllllllllIlIIIIIllllIIII);
            }
            else {
                if (lllllllllllllllllIlIIIIIllllIIlI == CtClass.longType) {
                    this.addLstore(lllllllllllllllllIlIIIIIllllIIII);
                    return 2;
                }
                if (lllllllllllllllllIlIIIIIllllIIlI == CtClass.floatType) {
                    this.addFstore(lllllllllllllllllIlIIIIIllllIIII);
                }
                else {
                    if (lllllllllllllllllIlIIIIIllllIIlI == CtClass.doubleType) {
                        this.addDstore(lllllllllllllllllIlIIIIIllllIIII);
                        return 2;
                    }
                    throw new RuntimeException("void type?");
                }
            }
        }
        else {
            this.addAstore(lllllllllllllllllIlIIIIIllllIIII);
        }
        return 1;
    }
    
    public byte[] get() {
        return this.copy();
    }
    
    public void setMaxStack(final int lllllllllllllllllIlIIIlIIIIllIll) {
        this.maxStack = lllllllllllllllllIlIIIlIIIIllIll;
    }
    
    public int currentPc() {
        return this.getSize();
    }
    
    public void addNewarray(final int lllllllllllllllllIIlllllIIlIlIll, final int lllllllllllllllllIIlllllIIlIlIlI) {
        this.addIconst(lllllllllllllllllIIlllllIIlIlIlI);
        this.addOpcode(188);
        this.add(lllllllllllllllllIIlllllIIlIlIll);
    }
    
    public void addCheckcast(final CtClass lllllllllllllllllIlIIIIIllIllIIl) {
        this.addOpcode(192);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIlIIIIIllIllIIl));
    }
    
    public void addIload(final int lllllllllllllllllIlIIIIlIIllllll) {
        if (lllllllllllllllllIlIIIIlIIllllll < 4) {
            this.addOpcode(26 + lllllllllllllllllIlIIIIlIIllllll);
        }
        else if (lllllllllllllllllIlIIIIlIIllllll < 256) {
            this.addOpcode(21);
            this.add(lllllllllllllllllIlIIIIlIIllllll);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(21);
            this.addIndex(lllllllllllllllllIlIIIIlIIllllll);
        }
    }
    
    public void addFload(final int lllllllllllllllllIlIIIIlIIIIIlll) {
        if (lllllllllllllllllIlIIIIlIIIIIlll < 4) {
            this.addOpcode(34 + lllllllllllllllllIlIIIIlIIIIIlll);
        }
        else if (lllllllllllllllllIlIIIIlIIIIIlll < 256) {
            this.addOpcode(23);
            this.add(lllllllllllllllllIlIIIIlIIIIIlll);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(23);
            this.addIndex(lllllllllllllllllIlIIIIlIIIIIlll);
        }
    }
    
    public void addInvokedynamic(final int lllllllllllllllllIIlllllIllIllIl, final String lllllllllllllllllIIlllllIllIllII, final String lllllllllllllllllIIlllllIllIIlIl) {
        final int lllllllllllllllllIIlllllIllIlIlI = this.constPool.addNameAndTypeInfo(lllllllllllllllllIIlllllIllIllII, lllllllllllllllllIIlllllIllIIlIl);
        final int lllllllllllllllllIIlllllIllIlIIl = this.constPool.addInvokeDynamicInfo(lllllllllllllllllIIlllllIllIllIl, lllllllllllllllllIIlllllIllIlIlI);
        this.add(186);
        this.addIndex(lllllllllllllllllIIlllllIllIlIIl);
        this.add(0, 0);
        this.growStack(Descriptor.dataSize(lllllllllllllllllIIlllllIllIIlIl));
    }
    
    public int getStackDepth() {
        return this.stackDepth;
    }
    
    public void addInvokestatic(final CtClass lllllllllllllllllIlIIIIIIIlIllII, final String lllllllllllllllllIlIIIIIIIlIlIll, final CtClass lllllllllllllllllIlIIIIIIIlIlIlI, final CtClass[] lllllllllllllllllIlIIIIIIIlIlIIl) {
        final String lllllllllllllllllIlIIIIIIIlIlllI = Descriptor.ofMethod(lllllllllllllllllIlIIIIIIIlIlIlI, lllllllllllllllllIlIIIIIIIlIlIIl);
        this.addInvokestatic(lllllllllllllllllIlIIIIIIIlIllII, lllllllllllllllllIlIIIIIIIlIlIll, lllllllllllllllllIlIIIIIIIlIlllI);
    }
    
    public void addInvokestatic(final int lllllllllllllllllIlIIIIIIIIIIIlI, final String lllllllllllllllllIlIIIIIIIIIIlIl, final String lllllllllllllllllIlIIIIIIIIIIlII) {
        this.addInvokestatic(lllllllllllllllllIlIIIIIIIIIIIlI, lllllllllllllllllIlIIIIIIIIIIlIl, lllllllllllllllllIlIIIIIIIIIIlII, false);
    }
    
    public void setStackDepth(final int lllllllllllllllllIlIIIIlIllIIIIl) {
        this.stackDepth = lllllllllllllllllIlIIIIlIllIIIIl;
        if (this.stackDepth > this.maxStack) {
            this.maxStack = this.stackDepth;
        }
    }
    
    public void addExceptionHandler(final int lllllllllllllllllIlIIIIlllIlIllI, final int lllllllllllllllllIlIIIIlllIlIlIl, final int lllllllllllllllllIlIIIIlllIllIIl, final String lllllllllllllllllIlIIIIlllIllIII) {
        this.addExceptionHandler(lllllllllllllllllIlIIIIlllIlIllI, lllllllllllllllllIlIIIIlllIlIlIl, lllllllllllllllllIlIIIIlllIllIIl, this.constPool.addClassInfo(lllllllllllllllllIlIIIIlllIllIII));
    }
    
    public void addExceptionHandler(final int lllllllllllllllllIlIIIIllllIIlIl, final int lllllllllllllllllIlIIIIllllIIlII, final int lllllllllllllllllIlIIIIllllIIIll, final CtClass lllllllllllllllllIlIIIIllllIIIlI) {
        this.addExceptionHandler(lllllllllllllllllIlIIIIllllIIlIl, lllllllllllllllllIlIIIIllllIIlII, lllllllllllllllllIlIIIIllllIIIll, this.constPool.addClassInfo(lllllllllllllllllIlIIIIllllIIIlI));
    }
    
    public void addLload(final int lllllllllllllllllIlIIIIlIIlIllIl) {
        if (lllllllllllllllllIlIIIIlIIlIllIl < 4) {
            this.addOpcode(30 + lllllllllllllllllIlIIIIlIIlIllIl);
        }
        else if (lllllllllllllllllIlIIIIlIIlIllIl < 256) {
            this.addOpcode(22);
            this.add(lllllllllllllllllIlIIIIlIIlIllIl);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(22);
            this.addIndex(lllllllllllllllllIlIIIIlIIlIllIl);
        }
    }
    
    public void addPutstatic(final String lllllllllllllllllIIllllIllIIIllI, final String lllllllllllllllllIIllllIllIIlIIl, final String lllllllllllllllllIIllllIllIIIlII) {
        this.addPutstatic0(null, lllllllllllllllllIIllllIllIIIllI, lllllllllllllllllIIllllIllIIlIIl, lllllllllllllllllIIllllIllIIIlII);
    }
    
    public ExceptionTable getExceptionTable() {
        return this.tryblocks;
    }
    
    public void addCheckcast(final String lllllllllllllllllIlIIIIIllIlIIll) {
        this.addOpcode(192);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIlIIIIIllIlIIll));
    }
    
    public void addPutfield(final CtClass lllllllllllllllllIIllllIllllllII, final String lllllllllllllllllIIllllIllllllll, final String lllllllllllllllllIIllllIlllllIlI) {
        this.addPutfield0(lllllllllllllllllIIllllIllllllII, null, lllllllllllllllllIIllllIllllllll, lllllllllllllllllIIllllIlllllIlI);
    }
    
    public void addInvokespecial(final CtClass lllllllllllllllllIlIIIIIIlllIIIl, final String lllllllllllllllllIlIIIIIIlllIlIl, final String lllllllllllllllllIlIIIIIIllIllll) {
        final boolean lllllllllllllllllIlIIIIIIlllIIll = lllllllllllllllllIlIIIIIIlllIIIl != null && lllllllllllllllllIlIIIIIIlllIIIl.isInterface();
        this.addInvokespecial(lllllllllllllllllIlIIIIIIlllIIll, this.constPool.addClassInfo(lllllllllllllllllIlIIIIIIlllIIIl), lllllllllllllllllIlIIIIIIlllIlIl, lllllllllllllllllIlIIIIIIllIllll);
    }
    
    public void addInvokespecial(final CtClass lllllllllllllllllIlIIIIIlIIIIIIl, final String lllllllllllllllllIlIIIIIlIIIIIII, final CtClass lllllllllllllllllIlIIIIIIlllllll, final CtClass[] lllllllllllllllllIlIIIIIIllllllI) {
        final String lllllllllllllllllIlIIIIIlIIIIIll = Descriptor.ofMethod(lllllllllllllllllIlIIIIIIlllllll, lllllllllllllllllIlIIIIIIllllllI);
        this.addInvokespecial(lllllllllllllllllIlIIIIIlIIIIIIl, lllllllllllllllllIlIIIIIlIIIIIII, lllllllllllllllllIlIIIIIlIIIIIll);
    }
    
    public void addFconst(final float lllllllllllllllllIlIIIIlIIIIllll) {
        if (lllllllllllllllllIlIIIIlIIIIllll == 0.0f || lllllllllllllllllIlIIIIlIIIIllll == 1.0f || lllllllllllllllllIlIIIIlIIIIllll == 2.0f) {
            this.addOpcode(11 + (int)lllllllllllllllllIlIIIIlIIIIllll);
        }
        else {
            this.addLdc(this.constPool.addFloatInfo(lllllllllllllllllIlIIIIlIIIIllll));
        }
    }
    
    public int addMultiNewarray(final CtClass lllllllllllllllllIIlllllIIIllIll, final int[] lllllllllllllllllIIlllllIIIllllI) {
        final int lllllllllllllllllIIlllllIIIlllIl = lllllllllllllllllIIlllllIIIllllI.length;
        for (int lllllllllllllllllIIlllllIIlIIIIl = 0; lllllllllllllllllIIlllllIIlIIIIl < lllllllllllllllllIIlllllIIIlllIl; ++lllllllllllllllllIIlllllIIlIIIIl) {
            this.addIconst(lllllllllllllllllIIlllllIIIllllI[lllllllllllllllllIIlllllIIlIIIIl]);
        }
        this.growStack(lllllllllllllllllIIlllllIIIlllIl);
        return this.addMultiNewarray(lllllllllllllllllIIlllllIIIllIll, lllllllllllllllllIIlllllIIIlllIl);
    }
    
    public void addIconst(final int lllllllllllllllllIlIIIIlIlIIlIIl) {
        if (lllllllllllllllllIlIIIIlIlIIlIIl < 6 && -2 < lllllllllllllllllIlIIIIlIlIIlIIl) {
            this.addOpcode(3 + lllllllllllllllllIlIIIIlIlIIlIIl);
        }
        else if (lllllllllllllllllIlIIIIlIlIIlIIl <= 127 && -128 <= lllllllllllllllllIlIIIIlIlIIlIIl) {
            this.addOpcode(16);
            this.add(lllllllllllllllllIlIIIIlIlIIlIIl);
        }
        else if (lllllllllllllllllIlIIIIlIlIIlIIl <= 32767 && -32768 <= lllllllllllllllllIlIIIIlIlIIlIIl) {
            this.addOpcode(17);
            this.add(lllllllllllllllllIlIIIIlIlIIlIIl >> 8);
            this.add(lllllllllllllllllIlIIIIlIlIIlIIl);
        }
        else {
            this.addLdc(this.constPool.addIntegerInfo(lllllllllllllllllIlIIIIlIlIIlIIl));
        }
    }
    
    static {
        THIS = ConstPool.THIS;
    }
    
    public Bytecode(final ConstPool lllllllllllllllllIlIIIlIIIlllIlI) {
        this(lllllllllllllllllIlIIIlIIIlllIlI, 0, 0);
    }
    
    public void addAstore(final int lllllllllllllllllIlIIIIlIlIlIIIl) {
        if (lllllllllllllllllIlIIIIlIlIlIIIl < 4) {
            this.addOpcode(75 + lllllllllllllllllIlIIIIlIlIlIIIl);
        }
        else if (lllllllllllllllllIlIIIIlIlIlIIIl < 256) {
            this.addOpcode(58);
            this.add(lllllllllllllllllIlIIIIlIlIlIIIl);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(58);
            this.addIndex(lllllllllllllllllIlIIIIlIlIlIIIl);
        }
    }
    
    public void addDload(final int lllllllllllllllllIlIIIIlIIIllIIl) {
        if (lllllllllllllllllIlIIIIlIIIllIIl < 4) {
            this.addOpcode(38 + lllllllllllllllllIlIIIIlIIIllIIl);
        }
        else if (lllllllllllllllllIlIIIIlIIIllIIl < 256) {
            this.addOpcode(24);
            this.add(lllllllllllllllllIlIIIIlIIIllIIl);
        }
        else {
            this.addOpcode(196);
            this.addOpcode(24);
            this.addIndex(lllllllllllllllllIlIIIIlIIIllIIl);
        }
    }
    
    public void addInvokevirtual(final CtClass lllllllllllllllllIIlllllllIlIlIl, final String lllllllllllllllllIIlllllllIlIIII, final String lllllllllllllllllIIlllllllIIllll) {
        this.addInvokevirtual(this.constPool.addClassInfo(lllllllllllllllllIIlllllllIlIlIl), lllllllllllllllllIIlllllllIlIIII, lllllllllllllllllIIlllllllIIllll);
    }
    
    public void addAnewarray(final CtClass lllllllllllllllllIIlllllIIllIlII, final int lllllllllllllllllIIlllllIIllIIll) {
        this.addIconst(lllllllllllllllllIIlllllIIllIIll);
        this.addOpcode(189);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIIlllllIIllIlII));
    }
    
    private void addPutstatic0(final CtClass lllllllllllllllllIIllllIlIllIllI, final String lllllllllllllllllIIllllIlIlllIll, final String lllllllllllllllllIIllllIlIllIlII, final String lllllllllllllllllIIllllIlIllIIll) {
        this.add(179);
        final int lllllllllllllllllIIllllIlIlllIII = (lllllllllllllllllIIllllIlIlllIll == null) ? this.constPool.addClassInfo(lllllllllllllllllIIllllIlIllIllI) : this.constPool.addClassInfo(lllllllllllllllllIIllllIlIlllIll);
        this.addIndex(this.constPool.addFieldrefInfo(lllllllllllllllllIIllllIlIlllIII, lllllllllllllllllIIllllIlIllIlII, lllllllllllllllllIIllllIlIllIIll));
        this.growStack(-Descriptor.dataSize(lllllllllllllllllIIllllIlIllIIll));
    }
    
    public void growStack(final int lllllllllllllllllIlIIIIlIllIllII) {
        this.setStackDepth(this.stackDepth + lllllllllllllllllIlIIIIlIllIllII);
    }
    
    public int getMaxLocals() {
        return this.maxLocals;
    }
    
    public int read32bit(final int lllllllllllllllllIlIIIIllIlIIlIl) {
        final int lllllllllllllllllIlIIIIllIlIlIII = this.read16bit(lllllllllllllllllIlIIIIllIlIIlIl);
        final int lllllllllllllllllIlIIIIllIlIIlll = this.read16bit(lllllllllllllllllIlIIIIllIlIIlIl + 2);
        return (lllllllllllllllllIlIIIIllIlIlIII << 16) + (lllllllllllllllllIlIIIIllIlIIlll & 0xFFFF);
    }
    
    public void addConstZero(final CtClass lllllllllllllllllIlIIIIlIlIIIlIl) {
        if (lllllllllllllllllIlIIIIlIlIIIlIl.isPrimitive()) {
            if (lllllllllllllllllIlIIIIlIlIIIlIl == CtClass.longType) {
                this.addOpcode(9);
            }
            else if (lllllllllllllllllIlIIIIlIlIIIlIl == CtClass.floatType) {
                this.addOpcode(11);
            }
            else if (lllllllllllllllllIlIIIIlIlIIIlIl == CtClass.doubleType) {
                this.addOpcode(14);
            }
            else {
                if (lllllllllllllllllIlIIIIlIlIIIlIl == CtClass.voidType) {
                    throw new RuntimeException("void type?");
                }
                this.addOpcode(3);
            }
        }
        else {
            this.addOpcode(1);
        }
    }
    
    public int read16bit(final int lllllllllllllllllIlIIIIllIllIlIl) {
        final int lllllllllllllllllIlIIIIllIllIlII = this.read(lllllllllllllllllIlIIIIllIllIlIl);
        final int lllllllllllllllllIlIIIIllIllIIll = this.read(lllllllllllllllllIlIIIIllIllIlIl + 1);
        return (lllllllllllllllllIlIIIIllIllIlII << 8) + (lllllllllllllllllIlIIIIllIllIIll & 0xFF);
    }
    
    public int addLoadParameters(final CtClass[] lllllllllllllllllIlIIIIIlllIIIIl, final int lllllllllllllllllIlIIIIIlllIIIII) {
        int lllllllllllllllllIlIIIIIlllIIIll = 0;
        if (lllllllllllllllllIlIIIIIlllIIIIl != null) {
            for (int lllllllllllllllllIlIIIIIlllIIlll = lllllllllllllllllIlIIIIIlllIIIIl.length, lllllllllllllllllIlIIIIIlllIlIII = 0; lllllllllllllllllIlIIIIIlllIlIII < lllllllllllllllllIlIIIIIlllIIlll; ++lllllllllllllllllIlIIIIIlllIlIII) {
                lllllllllllllllllIlIIIIIlllIIIll += this.addLoad(lllllllllllllllllIlIIIIIlllIIIll + lllllllllllllllllIlIIIIIlllIIIII, lllllllllllllllllIlIIIIIlllIIIIl[lllllllllllllllllIlIIIIIlllIlIII]);
            }
        }
        return lllllllllllllllllIlIIIIIlllIIIll;
    }
    
    public void addGetstatic(final String lllllllllllllllllIlIIIIIlIIlIlll, final String lllllllllllllllllIlIIIIIlIIlIIIl, final String lllllllllllllllllIlIIIIIlIIlIIII) {
        this.add(178);
        final int lllllllllllllllllIlIIIIIlIIlIlII = this.constPool.addClassInfo(lllllllllllllllllIlIIIIIlIIlIlll);
        this.addIndex(this.constPool.addFieldrefInfo(lllllllllllllllllIlIIIIIlIIlIlII, lllllllllllllllllIlIIIIIlIIlIIIl, lllllllllllllllllIlIIIIIlIIlIIII));
        this.growStack(Descriptor.dataSize(lllllllllllllllllIlIIIIIlIIlIIII));
    }
    
    public void addInvokespecial(final int lllllllllllllllllIlIIIIIIlIllIII, final String lllllllllllllllllIlIIIIIIlIllIll, final String lllllllllllllllllIlIIIIIIlIllIlI) {
        this.addInvokespecial(false, lllllllllllllllllIlIIIIIIlIllIII, lllllllllllllllllIlIIIIIIlIllIll, lllllllllllllllllIlIIIIIIlIllIlI);
    }
    
    public void incMaxLocals(final int lllllllllllllllllIlIIIIlllllIIll) {
        this.maxLocals += lllllllllllllllllIlIIIIlllllIIll;
    }
    
    public void addInvokestatic(final CtClass lllllllllllllllllIlIIIIIIIlIIIII, final String lllllllllllllllllIlIIIIIIIIllIlI, final String lllllllllllllllllIlIIIIIIIIllllI) {
        boolean lllllllllllllllllIlIIIIIIIIlllIl = false;
        if (lllllllllllllllllIlIIIIIIIlIIIII == Bytecode.THIS) {
            final boolean lllllllllllllllllIlIIIIIIIlIIIlI = false;
        }
        else {
            lllllllllllllllllIlIIIIIIIIlllIl = lllllllllllllllllIlIIIIIIIlIIIII.isInterface();
        }
        this.addInvokestatic(this.constPool.addClassInfo(lllllllllllllllllIlIIIIIIIlIIIII), lllllllllllllllllIlIIIIIIIIllIlI, lllllllllllllllllIlIIIIIIIIllllI, lllllllllllllllllIlIIIIIIIIlllIl);
    }
    
    public void addAnewarray(final String lllllllllllllllllIIlllllIIlllIll) {
        this.addOpcode(189);
        this.addIndex(this.constPool.addClassInfo(lllllllllllllllllIIlllllIIlllIll));
    }
    
    public void addInvokevirtual(final String lllllllllllllllllIIlllllllIIIlIl, final String lllllllllllllllllIIlllllllIIIlII, final String lllllllllllllllllIIlllllllIIIlll) {
        this.addInvokevirtual(this.constPool.addClassInfo(lllllllllllllllllIIlllllllIIIlIl), lllllllllllllllllIIlllllllIIIlII, lllllllllllllllllIIlllllllIIIlll);
    }
    
    public void addInvokeinterface(final String lllllllllllllllllIIllllllIIIIlll, final String lllllllllllllllllIIllllllIIIlIll, final String lllllllllllllllllIIllllllIIIlIlI, final int lllllllllllllllllIIllllllIIIlIIl) {
        this.addInvokeinterface(this.constPool.addClassInfo(lllllllllllllllllIIllllllIIIIlll), lllllllllllllllllIIllllllIIIlIll, lllllllllllllllllIIllllllIIIlIlI, lllllllllllllllllIIllllllIIIlIIl);
    }
}
