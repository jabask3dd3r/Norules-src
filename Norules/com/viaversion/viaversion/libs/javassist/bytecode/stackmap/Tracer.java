package com.viaversion.viaversion.libs.javassist.bytecode.stackmap;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public abstract class Tracer implements TypeTag
{
    protected /* synthetic */ ClassPool classPool;
    protected /* synthetic */ String returnType;
    protected /* synthetic */ TypeData[] localsTypes;
    protected /* synthetic */ int stackTop;
    protected /* synthetic */ ConstPool cpool;
    protected /* synthetic */ TypeData[] stackTypes;
    
    private void checkParamTypes(final String llllllllllllllIIllllllIIlllllIII, final int llllllllllllllIIllllllIIllllIlll) throws BadBytecode {
        char llllllllllllllIIllllllIIllllIllI = llllllllllllllIIllllllIIlllllIII.charAt(llllllllllllllIIllllllIIllllIlll);
        if (llllllllllllllIIllllllIIllllIllI == ')') {
            return;
        }
        int llllllllllllllIIllllllIIllllIlIl = llllllllllllllIIllllllIIllllIlll;
        boolean llllllllllllllIIllllllIIllllIlII = false;
        while (llllllllllllllIIllllllIIllllIllI == '[') {
            llllllllllllllIIllllllIIllllIlII = true;
            llllllllllllllIIllllllIIllllIllI = llllllllllllllIIllllllIIlllllIII.charAt(++llllllllllllllIIllllllIIllllIlIl);
        }
        if (llllllllllllllIIllllllIIllllIllI == 'L') {
            llllllllllllllIIllllllIIllllIlIl = llllllllllllllIIllllllIIlllllIII.indexOf(59, llllllllllllllIIllllllIIllllIlIl) + 1;
            if (llllllllllllllIIllllllIIllllIlIl <= 0) {
                throw new IndexOutOfBoundsException("bad descriptor");
            }
        }
        else {
            ++llllllllllllllIIllllllIIllllIlIl;
        }
        this.checkParamTypes(llllllllllllllIIllllllIIlllllIII, llllllllllllllIIllllllIIllllIlIl);
        if (!llllllllllllllIIllllllIIllllIlII && (llllllllllllllIIllllllIIllllIllI == 'J' || llllllllllllllIIllllllIIllllIllI == 'D')) {
            this.stackTop -= 2;
        }
        else {
            --this.stackTop;
        }
        if (llllllllllllllIIllllllIIllllIlII) {
            this.stackTypes[this.stackTop].setType(llllllllllllllIIllllllIIlllllIII.substring(llllllllllllllIIllllllIIllllIlll, llllllllllllllIIllllllIIllllIlIl), this.classPool);
        }
        else if (llllllllllllllIIllllllIIllllIllI == 'L') {
            this.stackTypes[this.stackTop].setType(llllllllllllllIIllllllIIlllllIII.substring(llllllllllllllIIllllllIIllllIlll + 1, llllllllllllllIIllllllIIllllIlIl - 1).replace('/', '.'), this.classPool);
        }
    }
    
    private int doASTORE(final int llllllllllllllIIlllllllIIIlIIIII) {
        --this.stackTop;
        this.localsTypes[llllllllllllllIIlllllllIIIlIIIII] = this.stackTypes[this.stackTop];
        return 2;
    }
    
    public Tracer(final Tracer llllllllllllllIIlllllllIllIIlIlI) {
        this.classPool = llllllllllllllIIlllllllIllIIlIlI.classPool;
        this.cpool = llllllllllllllIIlllllllIllIIlIlI.cpool;
        this.returnType = llllllllllllllIIlllllllIllIIlIlI.returnType;
        this.stackTop = llllllllllllllIIlllllllIllIIlIlI.stackTop;
        this.stackTypes = TypeData.make(llllllllllllllIIlllllllIllIIlIlI.stackTypes.length);
        this.localsTypes = TypeData.make(llllllllllllllIIlllllllIllIIlIlI.localsTypes.length);
    }
    
    private int doNEWARRAY(final int llllllllllllllIIllllllIlIlllIlIl, final byte[] llllllllllllllIIllllllIlIlllIlII) {
        final int llllllllllllllIIllllllIlIlllIIll = this.stackTop - 1;
        switch (llllllllllllllIIllllllIlIlllIlII[llllllllllllllIIllllllIlIlllIlIl + 1] & 0xFF) {
            case 4: {
                final String llllllllllllllIIllllllIlIllllllI = "[Z";
                break;
            }
            case 5: {
                final String llllllllllllllIIllllllIlIlllllIl = "[C";
                break;
            }
            case 6: {
                final String llllllllllllllIIllllllIlIlllllII = "[F";
                break;
            }
            case 7: {
                final String llllllllllllllIIllllllIlIllllIll = "[D";
                break;
            }
            case 8: {
                final String llllllllllllllIIllllllIlIllllIlI = "[B";
                break;
            }
            case 9: {
                final String llllllllllllllIIllllllIlIllllIIl = "[S";
                break;
            }
            case 10: {
                final String llllllllllllllIIllllllIlIllllIII = "[I";
                break;
            }
            case 11: {
                final String llllllllllllllIIllllllIlIlllIlll = "[J";
                break;
            }
            default: {
                throw new RuntimeException("bad newarray");
            }
        }
        final String llllllllllllllIIllllllIlIlllIIlI;
        this.stackTypes[llllllllllllllIIllllllIlIlllIIll] = new TypeData.ClassName(llllllllllllllIIllllllIlIlllIIlI);
        return 2;
    }
    
    private void doWIDE_STORE(final int llllllllllllllIIllllllIllIlllIlI, final byte[] llllllllllllllIIllllllIllIlllllI, final TypeData llllllllllllllIIllllllIllIllllIl) {
        final int llllllllllllllIIllllllIllIllllII = ByteArray.readU16bit(llllllllllllllIIllllllIllIlllllI, llllllllllllllIIllllllIllIlllIlI + 2);
        this.doXSTORE(llllllllllllllIIllllllIllIllllII, llllllllllllllIIllllllIllIllllIl);
    }
    
    private int doWIDE(final int llllllllllllllIIllllllIlllIlllII, final byte[] llllllllllllllIIllllllIlllIllIll) throws BadBytecode {
        final int llllllllllllllIIllllllIlllIllIlI = llllllllllllllIIllllllIlllIllIll[llllllllllllllIIllllllIlllIlllII + 1] & 0xFF;
        switch (llllllllllllllIIllllllIlllIllIlI) {
            case 21: {
                this.doWIDE_XLOAD(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.INTEGER);
                break;
            }
            case 22: {
                this.doWIDE_XLOAD(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.LONG);
                break;
            }
            case 23: {
                this.doWIDE_XLOAD(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.FLOAT);
                break;
            }
            case 24: {
                this.doWIDE_XLOAD(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.DOUBLE);
                break;
            }
            case 25: {
                final int llllllllllllllIIllllllIlllIlllll = ByteArray.readU16bit(llllllllllllllIIllllllIlllIllIll, llllllllllllllIIllllllIlllIlllII + 2);
                this.doALOAD(llllllllllllllIIllllllIlllIlllll);
                break;
            }
            case 54: {
                this.doWIDE_STORE(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.INTEGER);
                break;
            }
            case 55: {
                this.doWIDE_STORE(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.LONG);
                break;
            }
            case 56: {
                this.doWIDE_STORE(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.FLOAT);
                break;
            }
            case 57: {
                this.doWIDE_STORE(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll, Tracer.DOUBLE);
                break;
            }
            case 58: {
                final int llllllllllllllIIllllllIlllIllllI = ByteArray.readU16bit(llllllllllllllIIllllllIlllIllIll, llllllllllllllIIllllllIlllIlllII + 2);
                this.doASTORE(llllllllllllllIIllllllIlllIllllI);
                break;
            }
            case 132: {
                return 6;
            }
            case 169: {
                this.visitRET(llllllllllllllIIllllllIlllIlllII, llllllllllllllIIllllllIlllIllIll);
                break;
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad WIDE instruction: ").append(llllllllllllllIIllllllIlllIllIlI)));
            }
        }
        return 4;
    }
    
    protected int doOpcode(final int llllllllllllllIIlllllllIlIllllIl, final byte[] llllllllllllllIIlllllllIlIllllII) throws BadBytecode {
        try {
            final int llllllllllllllIIlllllllIllIIIIll = llllllllllllllIIlllllllIlIllllII[llllllllllllllIIlllllllIlIllllIl] & 0xFF;
            if (llllllllllllllIIlllllllIllIIIIll < 54) {
                return this.doOpcode0_53(llllllllllllllIIlllllllIlIllllIl, llllllllllllllIIlllllllIlIllllII, llllllllllllllIIlllllllIllIIIIll);
            }
            if (llllllllllllllIIlllllllIllIIIIll < 96) {
                return this.doOpcode54_95(llllllllllllllIIlllllllIlIllllIl, llllllllllllllIIlllllllIlIllllII, llllllllllllllIIlllllllIllIIIIll);
            }
            if (llllllllllllllIIlllllllIllIIIIll < 148) {
                return this.doOpcode96_147(llllllllllllllIIlllllllIlIllllIl, llllllllllllllIIlllllllIlIllllII, llllllllllllllIIlllllllIllIIIIll);
            }
            return this.doOpcode148_201(llllllllllllllIIlllllllIlIllllIl, llllllllllllllIIlllllllIlIllllII, llllllllllllllIIlllllllIllIIIIll);
        }
        catch (ArrayIndexOutOfBoundsException llllllllllllllIIlllllllIllIIIIlI) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("inconsistent stack height ").append(llllllllllllllIIlllllllIllIIIIlI.getMessage())), llllllllllllllIIlllllllIllIIIIlI);
        }
    }
    
    public Tracer(final ClassPool llllllllllllllIIlllllllIllIllIII, final ConstPool llllllllllllllIIlllllllIllIlIlll, final int llllllllllllllIIlllllllIllIlIllI, final int llllllllllllllIIlllllllIllIlIlIl, final String llllllllllllllIIlllllllIllIIlllI) {
        this.classPool = llllllllllllllIIlllllllIllIllIII;
        this.cpool = llllllllllllllIIlllllllIllIlIlll;
        this.returnType = llllllllllllllIIlllllllIllIIlllI;
        this.stackTop = 0;
        this.stackTypes = TypeData.make(llllllllllllllIIlllllllIllIlIllI);
        this.localsTypes = TypeData.make(llllllllllllllIIlllllllIllIlIlIl);
    }
    
    private void constructorCalled(final TypeData llllllllllllllIIllllllIlIIlllIll, final int llllllllllllllIIllllllIlIIlllIlI) {
        llllllllllllllIIllllllIlIIlllIll.constructorCalled(llllllllllllllIIllllllIlIIlllIlI);
        for (int llllllllllllllIIllllllIlIIlllllI = 0; llllllllllllllIIllllllIlIIlllllI < this.stackTop; ++llllllllllllllIIllllllIlIIlllllI) {
            this.stackTypes[llllllllllllllIIllllllIlIIlllllI].constructorCalled(llllllllllllllIIllllllIlIIlllIlI);
        }
        for (int llllllllllllllIIllllllIlIIllllIl = 0; llllllllllllllIIllllllIlIIllllIl < this.localsTypes.length; ++llllllllllllllIIllllllIlIIllllIl) {
            this.localsTypes[llllllllllllllIIllllllIlIIllllIl].constructorCalled(llllllllllllllIIllllllIlIIlllIlI);
        }
    }
    
    protected void visitReturn(final int llllllllllllllIIlllllllIlIllIIIl, final byte[] llllllllllllllIIlllllllIlIllIIII) throws BadBytecode {
    }
    
    private int doXLOAD(final int llllllllllllllIIlllllllIIllIIIIl, final TypeData llllllllllllllIIlllllllIIlIllllI) {
        this.stackTypes[this.stackTop++] = llllllllllllllIIlllllllIIlIllllI;
        if (llllllllllllllIIlllllllIIlIllllI.is2WordType()) {
            this.stackTypes[this.stackTop++] = Tracer.TOP;
        }
        return 2;
    }
    
    private void doDUP_XX(final int llllllllllllllIIlllllllIIIIlIIII, final int llllllllllllllIIlllllllIIIIIllll) {
        final TypeData[] llllllllllllllIIlllllllIIIIlIlII = this.stackTypes;
        for (int llllllllllllllIIlllllllIIIIlIIll = this.stackTop - 1, llllllllllllllIIlllllllIIIIlIIlI = llllllllllllllIIlllllllIIIIlIIll - llllllllllllllIIlllllllIIIIIllll; llllllllllllllIIlllllllIIIIlIIll > llllllllllllllIIlllllllIIIIlIIlI; --llllllllllllllIIlllllllIIIIlIIll) {
            llllllllllllllIIlllllllIIIIlIlII[llllllllllllllIIlllllllIIIIlIIll + llllllllllllllIIlllllllIIIIlIIII] = llllllllllllllIIlllllllIIIIlIlII[llllllllllllllIIlllllllIIIIlIIll];
        }
    }
    
    private int doOpcode54_95(final int llllllllllllllIIlllllllIIlIIIIII, final byte[] llllllllllllllIIlllllllIIlIIIIll, final int llllllllllllllIIlllllllIIIlllllI) throws BadBytecode {
        switch (llllllllllllllIIlllllllIIIlllllI) {
            case 54: {
                return this.doXSTORE(llllllllllllllIIlllllllIIlIIIIII, llllllllllllllIIlllllllIIlIIIIll, Tracer.INTEGER);
            }
            case 55: {
                return this.doXSTORE(llllllllllllllIIlllllllIIlIIIIII, llllllllllllllIIlllllllIIlIIIIll, Tracer.LONG);
            }
            case 56: {
                return this.doXSTORE(llllllllllllllIIlllllllIIlIIIIII, llllllllllllllIIlllllllIIlIIIIll, Tracer.FLOAT);
            }
            case 57: {
                return this.doXSTORE(llllllllllllllIIlllllllIIlIIIIII, llllllllllllllIIlllllllIIlIIIIll, Tracer.DOUBLE);
            }
            case 58: {
                return this.doASTORE(llllllllllllllIIlllllllIIlIIIIll[llllllllllllllIIlllllllIIlIIIIII + 1] & 0xFF);
            }
            case 59:
            case 60:
            case 61:
            case 62: {
                final int llllllllllllllIIlllllllIIlIlIIIl = llllllllllllllIIlllllllIIIlllllI - 59;
                this.localsTypes[llllllllllllllIIlllllllIIlIlIIIl] = Tracer.INTEGER;
                --this.stackTop;
                break;
            }
            case 63:
            case 64:
            case 65:
            case 66: {
                final int llllllllllllllIIlllllllIIlIlIIII = llllllllllllllIIlllllllIIIlllllI - 63;
                this.localsTypes[llllllllllllllIIlllllllIIlIlIIII] = Tracer.LONG;
                this.localsTypes[llllllllllllllIIlllllllIIlIlIIII + 1] = Tracer.TOP;
                this.stackTop -= 2;
                break;
            }
            case 67:
            case 68:
            case 69:
            case 70: {
                final int llllllllllllllIIlllllllIIlIIllll = llllllllllllllIIlllllllIIIlllllI - 67;
                this.localsTypes[llllllllllllllIIlllllllIIlIIllll] = Tracer.FLOAT;
                --this.stackTop;
                break;
            }
            case 71:
            case 72:
            case 73:
            case 74: {
                final int llllllllllllllIIlllllllIIlIIlllI = llllllllllllllIIlllllllIIIlllllI - 71;
                this.localsTypes[llllllllllllllIIlllllllIIlIIlllI] = Tracer.DOUBLE;
                this.localsTypes[llllllllllllllIIlllllllIIlIIlllI + 1] = Tracer.TOP;
                this.stackTop -= 2;
                break;
            }
            case 75:
            case 76:
            case 77:
            case 78: {
                final int llllllllllllllIIlllllllIIlIIllIl = llllllllllllllIIlllllllIIIlllllI - 75;
                this.doASTORE(llllllllllllllIIlllllllIIlIIllIl);
                break;
            }
            case 79:
            case 80:
            case 81:
            case 82: {
                this.stackTop -= ((llllllllllllllIIlllllllIIIlllllI == 80 || llllllllllllllIIlllllllIIIlllllI == 82) ? 4 : 3);
                break;
            }
            case 83: {
                TypeData.aastore(this.stackTypes[this.stackTop - 3], this.stackTypes[this.stackTop - 1], this.classPool);
                this.stackTop -= 3;
                break;
            }
            case 84:
            case 85:
            case 86: {
                this.stackTop -= 3;
                break;
            }
            case 87: {
                --this.stackTop;
                break;
            }
            case 88: {
                this.stackTop -= 2;
                break;
            }
            case 89: {
                final int llllllllllllllIIlllllllIIlIIllII = this.stackTop;
                this.stackTypes[llllllllllllllIIlllllllIIlIIllII] = this.stackTypes[llllllllllllllIIlllllllIIlIIllII - 1];
                this.stackTop = llllllllllllllIIlllllllIIlIIllII + 1;
                break;
            }
            case 90:
            case 91: {
                final int llllllllllllllIIlllllllIIlIIlIll = llllllllllllllIIlllllllIIIlllllI - 90 + 2;
                this.doDUP_XX(1, llllllllllllllIIlllllllIIlIIlIll);
                final int llllllllllllllIIlllllllIIlIIlIlI = this.stackTop;
                this.stackTypes[llllllllllllllIIlllllllIIlIIlIlI - llllllllllllllIIlllllllIIlIIlIll] = this.stackTypes[llllllllllllllIIlllllllIIlIIlIlI];
                this.stackTop = llllllllllllllIIlllllllIIlIIlIlI + 1;
                break;
            }
            case 92: {
                this.doDUP_XX(2, 2);
                this.stackTop += 2;
                break;
            }
            case 93:
            case 94: {
                final int llllllllllllllIIlllllllIIlIIlIIl = llllllllllllllIIlllllllIIIlllllI - 93 + 3;
                this.doDUP_XX(2, llllllllllllllIIlllllllIIlIIlIIl);
                final int llllllllllllllIIlllllllIIlIIlIII = this.stackTop;
                this.stackTypes[llllllllllllllIIlllllllIIlIIlIII - llllllllllllllIIlllllllIIlIIlIIl] = this.stackTypes[llllllllllllllIIlllllllIIlIIlIII];
                this.stackTypes[llllllllllllllIIlllllllIIlIIlIII - llllllllllllllIIlllllllIIlIIlIIl + 1] = this.stackTypes[llllllllllllllIIlllllllIIlIIlIII + 1];
                this.stackTop = llllllllllllllIIlllllllIIlIIlIII + 2;
                break;
            }
            case 95: {
                final int llllllllllllllIIlllllllIIlIIIlll = this.stackTop - 1;
                final TypeData llllllllllllllIIlllllllIIlIIIllI = this.stackTypes[llllllllllllllIIlllllllIIlIIIlll];
                this.stackTypes[llllllllllllllIIlllllllIIlIIIlll] = this.stackTypes[llllllllllllllIIlllllllIIlIIIlll - 1];
                this.stackTypes[llllllllllllllIIlllllllIIlIIIlll - 1] = llllllllllllllIIlllllllIIlIIIllI;
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return 1;
    }
    
    private void doLDC(final int llllllllllllllIIlllllllIIlllIlll) {
        final TypeData[] llllllllllllllIIlllllllIIllllIlI = this.stackTypes;
        final int llllllllllllllIIlllllllIIllllIIl = this.cpool.getTag(llllllllllllllIIlllllllIIlllIlll);
        if (llllllllllllllIIlllllllIIllllIIl == 8) {
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = new TypeData.ClassName("java.lang.String");
        }
        else if (llllllllllllllIIlllllllIIllllIIl == 3) {
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = Tracer.INTEGER;
        }
        else if (llllllllllllllIIlllllllIIllllIIl == 4) {
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = Tracer.FLOAT;
        }
        else if (llllllllllllllIIlllllllIIllllIIl == 5) {
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = Tracer.LONG;
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = Tracer.TOP;
        }
        else if (llllllllllllllIIlllllllIIllllIIl == 6) {
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = Tracer.DOUBLE;
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = Tracer.TOP;
        }
        else if (llllllllllllllIIlllllllIIllllIIl == 7) {
            llllllllllllllIIlllllllIIllllIlI[this.stackTop++] = new TypeData.ClassName("java.lang.Class");
        }
        else {
            if (llllllllllllllIIlllllllIIllllIIl != 17) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad LDC: ").append(llllllllllllllIIlllllllIIllllIIl)));
            }
            final String llllllllllllllIIlllllllIIlllllIl = this.cpool.getDynamicType(llllllllllllllIIlllllllIIlllIlll);
            this.pushMemberType(llllllllllllllIIlllllllIIlllllIl);
        }
    }
    
    protected void visitJSR(final int llllllllllllllIIlllllllIlIIlllll, final byte[] llllllllllllllIIlllllllIlIIllllI) throws BadBytecode {
    }
    
    private int doPutField(final int llllllllllllllIIllllllIllIlIIlll, final byte[] llllllllllllllIIllllllIllIlIllIl, final boolean llllllllllllllIIllllllIllIlIllII) throws BadBytecode {
        final int llllllllllllllIIllllllIllIlIlIll = ByteArray.readU16bit(llllllllllllllIIllllllIllIlIllIl, llllllllllllllIIllllllIllIlIIlll + 1);
        final String llllllllllllllIIllllllIllIlIlIlI = this.cpool.getFieldrefType(llllllllllllllIIllllllIllIlIlIll);
        this.stackTop -= Descriptor.dataSize(llllllllllllllIIllllllIllIlIlIlI);
        final char llllllllllllllIIllllllIllIlIlIIl = llllllllllllllIIllllllIllIlIlIlI.charAt(0);
        if (llllllllllllllIIllllllIllIlIlIIl == 'L') {
            this.stackTypes[this.stackTop].setType(getFieldClassName(llllllllllllllIIllllllIllIlIlIlI, 0), this.classPool);
        }
        else if (llllllllllllllIIllllllIllIlIlIIl == '[') {
            this.stackTypes[this.stackTop].setType(llllllllllllllIIllllllIllIlIlIlI, this.classPool);
        }
        this.setFieldTarget(llllllllllllllIIllllllIllIlIllII, llllllllllllllIIllllllIllIlIlIll);
        return 3;
    }
    
    private int doInvokeIntfMethod(final int llllllllllllllIIllllllIlIIlIlIII, final byte[] llllllllllllllIIllllllIlIIlIllIl) throws BadBytecode {
        final int llllllllllllllIIllllllIlIIlIllII = ByteArray.readU16bit(llllllllllllllIIllllllIlIIlIllIl, llllllllllllllIIllllllIlIIlIlIII + 1);
        final String llllllllllllllIIllllllIlIIlIlIll = this.cpool.getInterfaceMethodrefType(llllllllllllllIIllllllIlIIlIllII);
        this.checkParamTypes(llllllllllllllIIllllllIlIIlIlIll, 1);
        final String llllllllllllllIIllllllIlIIlIlIlI = this.cpool.getInterfaceMethodrefClassName(llllllllllllllIIllllllIlIIlIllII);
        final TypeData[] stackTypes = this.stackTypes;
        final int stackTop = this.stackTop - 1;
        this.stackTop = stackTop;
        stackTypes[stackTop].setType(llllllllllllllIIllllllIlIIlIlIlI, this.classPool);
        this.pushMemberType(llllllllllllllIIllllllIlIIlIlIll);
        return 5;
    }
    
    private int doInvokeMethod(final int llllllllllllllIIllllllIlIlIIllll, final byte[] llllllllllllllIIllllllIlIlIIlIII, final boolean llllllllllllllIIllllllIlIlIIllIl) throws BadBytecode {
        final int llllllllllllllIIllllllIlIlIIllII = ByteArray.readU16bit(llllllllllllllIIllllllIlIlIIlIII, llllllllllllllIIllllllIlIlIIllll + 1);
        final String llllllllllllllIIllllllIlIlIIlIll = this.cpool.getMethodrefType(llllllllllllllIIllllllIlIlIIllII);
        this.checkParamTypes(llllllllllllllIIllllllIlIlIIlIll, 1);
        if (llllllllllllllIIllllllIlIlIIllIl) {
            final String llllllllllllllIIllllllIlIlIlIIlI = this.cpool.getMethodrefClassName(llllllllllllllIIllllllIlIlIIllII);
            final TypeData[] stackTypes = this.stackTypes;
            final int stackTop = this.stackTop - 1;
            this.stackTop = stackTop;
            final TypeData llllllllllllllIIllllllIlIlIlIIIl = stackTypes[stackTop];
            if (llllllllllllllIIllllllIlIlIlIIIl instanceof TypeData.UninitTypeVar && llllllllllllllIIllllllIlIlIlIIIl.isUninit()) {
                this.constructorCalled(llllllllllllllIIllllllIlIlIlIIIl, ((TypeData.UninitTypeVar)llllllllllllllIIllllllIlIlIlIIIl).offset());
            }
            else if (llllllllllllllIIllllllIlIlIlIIIl instanceof TypeData.UninitData) {
                this.constructorCalled(llllllllllllllIIllllllIlIlIlIIIl, ((TypeData.UninitData)llllllllllllllIIllllllIlIlIlIIIl).offset());
            }
            llllllllllllllIIllllllIlIlIlIIIl.setType(llllllllllllllIIllllllIlIlIlIIlI, this.classPool);
        }
        this.pushMemberType(llllllllllllllIIllllllIlIlIIlIll);
        return 3;
    }
    
    private void setFieldTarget(final boolean llllllllllllllIIllllllIllIIIIllI, final int llllllllllllllIIllllllIllIIIIlIl) throws BadBytecode {
        if (llllllllllllllIIllllllIllIIIIllI) {
            final String llllllllllllllIIllllllIllIIIlIll = this.cpool.getFieldrefClassName(llllllllllllllIIllllllIllIIIIlIl);
            final TypeData[] stackTypes = this.stackTypes;
            final int stackTop = this.stackTop - 1;
            this.stackTop = stackTop;
            stackTypes[stackTop].setType(llllllllllllllIIllllllIllIIIlIll, this.classPool);
        }
    }
    
    private int doXLOAD(final TypeData llllllllllllllIIlllllllIIllIlIII, final byte[] llllllllllllllIIlllllllIIllIllII, final int llllllllllllllIIlllllllIIllIIllI) {
        final int llllllllllllllIIlllllllIIllIlIlI = llllllllllllllIIlllllllIIllIllII[llllllllllllllIIlllllllIIllIIllI + 1] & 0xFF;
        return this.doXLOAD(llllllllllllllIIlllllllIIllIlIlI, llllllllllllllIIlllllllIIllIlIII);
    }
    
    private void doWIDE_XLOAD(final int llllllllllllllIIllllllIlllIIlllI, final byte[] llllllllllllllIIllllllIlllIIllIl, final TypeData llllllllllllllIIllllllIlllIIllII) {
        final int llllllllllllllIIllllllIlllIIlIll = ByteArray.readU16bit(llllllllllllllIIllllllIlllIIllIl, llllllllllllllIIllllllIlllIIlllI + 2);
        this.doXLOAD(llllllllllllllIIllllllIlllIIlIll, llllllllllllllIIllllllIlllIIllII);
    }
    
    protected void visitLookupSwitch(final int llllllllllllllIIlllllllIlIlIIlIl, final byte[] llllllllllllllIIlllllllIlIlIIlII, final int llllllllllllllIIlllllllIlIlIIIll, final int llllllllllllllIIlllllllIlIlIIIlI, final int llllllllllllllIIlllllllIlIlIIIIl) throws BadBytecode {
    }
    
    private int doOpcode0_53(final int llllllllllllllIIlllllllIlIIIlIIl, final byte[] llllllllllllllIIlllllllIlIIIllIl, final int llllllllllllllIIlllllllIlIIIIlll) throws BadBytecode {
        final TypeData[] llllllllllllllIIlllllllIlIIIlIll = this.stackTypes;
        switch (llllllllllllllIIlllllllIlIIIIlll) {
            case 0: {
                break;
            }
            case 1: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = new TypeData.NullType();
                break;
            }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.INTEGER;
                break;
            }
            case 9:
            case 10: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.LONG;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.TOP;
                break;
            }
            case 11:
            case 12:
            case 13: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.FLOAT;
                break;
            }
            case 14:
            case 15: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.DOUBLE;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.TOP;
                break;
            }
            case 16:
            case 17: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.INTEGER;
                return (llllllllllllllIIlllllllIlIIIIlll == 17) ? 3 : 2;
            }
            case 18: {
                this.doLDC(llllllllllllllIIlllllllIlIIIllIl[llllllllllllllIIlllllllIlIIIlIIl + 1] & 0xFF);
                return 2;
            }
            case 19:
            case 20: {
                this.doLDC(ByteArray.readU16bit(llllllllllllllIIlllllllIlIIIllIl, llllllllllllllIIlllllllIlIIIlIIl + 1));
                return 3;
            }
            case 21: {
                return this.doXLOAD(Tracer.INTEGER, llllllllllllllIIlllllllIlIIIllIl, llllllllllllllIIlllllllIlIIIlIIl);
            }
            case 22: {
                return this.doXLOAD(Tracer.LONG, llllllllllllllIIlllllllIlIIIllIl, llllllllllllllIIlllllllIlIIIlIIl);
            }
            case 23: {
                return this.doXLOAD(Tracer.FLOAT, llllllllllllllIIlllllllIlIIIllIl, llllllllllllllIIlllllllIlIIIlIIl);
            }
            case 24: {
                return this.doXLOAD(Tracer.DOUBLE, llllllllllllllIIlllllllIlIIIllIl, llllllllllllllIIlllllllIlIIIlIIl);
            }
            case 25: {
                return this.doALOAD(llllllllllllllIIlllllllIlIIIllIl[llllllllllllllIIlllllllIlIIIlIIl + 1] & 0xFF);
            }
            case 26:
            case 27:
            case 28:
            case 29: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.INTEGER;
                break;
            }
            case 30:
            case 31:
            case 32:
            case 33: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.LONG;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.TOP;
                break;
            }
            case 34:
            case 35:
            case 36:
            case 37: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.FLOAT;
                break;
            }
            case 38:
            case 39:
            case 40:
            case 41: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.DOUBLE;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = Tracer.TOP;
                break;
            }
            case 42:
            case 43:
            case 44:
            case 45: {
                final int llllllllllllllIIlllllllIlIIlIIlI = llllllllllllllIIlllllllIlIIIIlll - 42;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop++] = this.localsTypes[llllllllllllllIIlllllllIlIIlIIlI];
                break;
            }
            case 46: {
                final TypeData[] array = llllllllllllllIIlllllllIlIIIlIll;
                final int stackTop = this.stackTop - 1;
                this.stackTop = stackTop;
                array[stackTop - 1] = Tracer.INTEGER;
                break;
            }
            case 47: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop - 2] = Tracer.LONG;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop - 1] = Tracer.TOP;
                break;
            }
            case 48: {
                final TypeData[] array2 = llllllllllllllIIlllllllIlIIIlIll;
                final int stackTop2 = this.stackTop - 1;
                this.stackTop = stackTop2;
                array2[stackTop2 - 1] = Tracer.FLOAT;
                break;
            }
            case 49: {
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop - 2] = Tracer.DOUBLE;
                llllllllllllllIIlllllllIlIIIlIll[this.stackTop - 1] = Tracer.TOP;
                break;
            }
            case 50: {
                final int stackTop3 = this.stackTop - 1;
                this.stackTop = stackTop3;
                final int llllllllllllllIIlllllllIlIIlIIIl = stackTop3 - 1;
                final TypeData llllllllllllllIIlllllllIlIIlIIII = llllllllllllllIIlllllllIlIIIlIll[llllllllllllllIIlllllllIlIIlIIIl];
                llllllllllllllIIlllllllIlIIIlIll[llllllllllllllIIlllllllIlIIlIIIl] = TypeData.ArrayElement.make(llllllllllllllIIlllllllIlIIlIIII);
                break;
            }
            case 51:
            case 52:
            case 53: {
                final TypeData[] array3 = llllllllllllllIIlllllllIlIIIlIll;
                final int stackTop4 = this.stackTop - 1;
                this.stackTop = stackTop4;
                array3[stackTop4 - 1] = Tracer.INTEGER;
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return 1;
    }
    
    protected void visitRET(final int llllllllllllllIIlllllllIlIIlllII, final byte[] llllllllllllllIIlllllllIlIIllIll) throws BadBytecode {
    }
    
    private int doOpcode148_201(final int llllllllllllllIIllllllIllllIlIll, final byte[] llllllllllllllIIllllllIllllIlIlI, final int llllllllllllllIIllllllIllllIlIIl) throws BadBytecode {
        switch (llllllllllllllIIllllllIllllIlIIl) {
            case 148: {
                this.stackTypes[this.stackTop - 4] = Tracer.INTEGER;
                this.stackTop -= 3;
                break;
            }
            case 149:
            case 150: {
                final TypeData[] stackTypes = this.stackTypes;
                final int stackTop = this.stackTop - 1;
                this.stackTop = stackTop;
                stackTypes[stackTop - 1] = Tracer.INTEGER;
                break;
            }
            case 151:
            case 152: {
                this.stackTypes[this.stackTop - 4] = Tracer.INTEGER;
                this.stackTop -= 3;
                break;
            }
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158: {
                --this.stackTop;
                this.visitBranch(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, ByteArray.readS16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1));
                return 3;
            }
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166: {
                this.stackTop -= 2;
                this.visitBranch(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, ByteArray.readS16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1));
                return 3;
            }
            case 167: {
                this.visitGoto(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, ByteArray.readS16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1));
                return 3;
            }
            case 168: {
                this.visitJSR(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                return 3;
            }
            case 169: {
                this.visitRET(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                return 2;
            }
            case 170: {
                --this.stackTop;
                final int llllllllllllllIIllllllIllllllIll = (llllllllllllllIIllllllIllllIlIll & 0xFFFFFFFC) + 8;
                final int llllllllllllllIIllllllIllllllIlI = ByteArray.read32bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllllIll);
                final int llllllllllllllIIllllllIllllllIIl = ByteArray.read32bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllllIll + 4);
                final int llllllllllllllIIllllllIllllllIII = llllllllllllllIIllllllIllllllIIl - llllllllllllllIIllllllIllllllIlI + 1;
                this.visitTableSwitch(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllllIII, llllllllllllllIIllllllIllllllIll + 8, ByteArray.read32bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllllIll - 4));
                return llllllllllllllIIllllllIllllllIII * 4 + 16 - (llllllllllllllIIllllllIllllIlIll & 0x3);
            }
            case 171: {
                --this.stackTop;
                final int llllllllllllllIIllllllIlllllIlll = (llllllllllllllIIllllllIllllIlIll & 0xFFFFFFFC) + 8;
                final int llllllllllllllIIllllllIlllllIllI = ByteArray.read32bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIlllllIlll);
                this.visitLookupSwitch(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIlllllIllI, llllllllllllllIIllllllIlllllIlll + 4, ByteArray.read32bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIlllllIlll - 4));
                return llllllllllllllIIllllllIlllllIllI * 8 + 12 - (llllllllllllllIIllllllIllllIlIll & 0x3);
            }
            case 172: {
                --this.stackTop;
                this.visitReturn(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 173: {
                this.stackTop -= 2;
                this.visitReturn(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 174: {
                --this.stackTop;
                this.visitReturn(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 175: {
                this.stackTop -= 2;
                this.visitReturn(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 176: {
                final TypeData[] stackTypes2 = this.stackTypes;
                final int stackTop2 = this.stackTop - 1;
                this.stackTop = stackTop2;
                stackTypes2[stackTop2].setType(this.returnType, this.classPool);
                this.visitReturn(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 177: {
                this.visitReturn(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 178: {
                return this.doGetField(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, false);
            }
            case 179: {
                return this.doPutField(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, false);
            }
            case 180: {
                return this.doGetField(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, true);
            }
            case 181: {
                return this.doPutField(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, true);
            }
            case 182:
            case 183: {
                return this.doInvokeMethod(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, true);
            }
            case 184: {
                return this.doInvokeMethod(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, false);
            }
            case 185: {
                return this.doInvokeIntfMethod(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
            }
            case 186: {
                return this.doInvokeDynamic(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
            }
            case 187: {
                final int llllllllllllllIIllllllIlllllIlIl = ByteArray.readU16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1);
                this.stackTypes[this.stackTop++] = new TypeData.UninitData(llllllllllllllIIllllllIllllIlIll, this.cpool.getClassInfo(llllllllllllllIIllllllIlllllIlIl));
                return 3;
            }
            case 188: {
                return this.doNEWARRAY(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
            }
            case 189: {
                final int llllllllllllllIIllllllIlllllIlII = ByteArray.readU16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1);
                String llllllllllllllIIllllllIlllllIIll = this.cpool.getClassInfo(llllllllllllllIIllllllIlllllIlII).replace('.', '/');
                if (llllllllllllllIIllllllIlllllIIll.charAt(0) == '[') {
                    llllllllllllllIIllllllIlllllIIll = String.valueOf(new StringBuilder().append("[").append(llllllllllllllIIllllllIlllllIIll));
                }
                else {
                    llllllllllllllIIllllllIlllllIIll = String.valueOf(new StringBuilder().append("[L").append(llllllllllllllIIllllllIlllllIIll).append(";"));
                }
                this.stackTypes[this.stackTop - 1] = new TypeData.ClassName(llllllllllllllIIllllllIlllllIIll);
                return 3;
            }
            case 190: {
                this.stackTypes[this.stackTop - 1].setType("[Ljava.lang.Object;", this.classPool);
                this.stackTypes[this.stackTop - 1] = Tracer.INTEGER;
                break;
            }
            case 191: {
                final TypeData[] stackTypes3 = this.stackTypes;
                final int stackTop3 = this.stackTop - 1;
                this.stackTop = stackTop3;
                stackTypes3[stackTop3].setType("java.lang.Throwable", this.classPool);
                this.visitThrow(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                break;
            }
            case 192: {
                final int llllllllllllllIIllllllIlllllIIlI = ByteArray.readU16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1);
                String llllllllllllllIIllllllIlllllIIIl = this.cpool.getClassInfo(llllllllllllllIIllllllIlllllIIlI);
                if (llllllllllllllIIllllllIlllllIIIl.charAt(0) == '[') {
                    llllllllllllllIIllllllIlllllIIIl = llllllllllllllIIllllllIlllllIIIl.replace('.', '/');
                }
                this.stackTypes[this.stackTop - 1] = new TypeData.ClassName(llllllllllllllIIllllllIlllllIIIl);
                return 3;
            }
            case 193: {
                this.stackTypes[this.stackTop - 1] = Tracer.INTEGER;
                return 3;
            }
            case 194:
            case 195: {
                --this.stackTop;
                break;
            }
            case 196: {
                return this.doWIDE(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
            }
            case 197: {
                return this.doMultiANewArray(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
            }
            case 198:
            case 199: {
                --this.stackTop;
                this.visitBranch(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, ByteArray.readS16bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1));
                return 3;
            }
            case 200: {
                this.visitGoto(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI, ByteArray.read32bit(llllllllllllllIIllllllIllllIlIlI, llllllllllllllIIllllllIllllIlIll + 1));
                return 5;
            }
            case 201: {
                this.visitJSR(llllllllllllllIIllllllIllllIlIll, llllllllllllllIIllllllIllllIlIlI);
                return 5;
            }
        }
        return 1;
    }
    
    protected void visitGoto(final int llllllllllllllIIlllllllIlIllIlIl, final byte[] llllllllllllllIIlllllllIlIllIlII, final int llllllllllllllIIlllllllIlIllIIll) throws BadBytecode {
    }
    
    private int doInvokeDynamic(final int llllllllllllllIIllllllIlIIIlllIl, final byte[] llllllllllllllIIllllllIlIIIlIlll) throws BadBytecode {
        final int llllllllllllllIIllllllIlIIIllIll = ByteArray.readU16bit(llllllllllllllIIllllllIlIIIlIlll, llllllllllllllIIllllllIlIIIlllIl + 1);
        final String llllllllllllllIIllllllIlIIIllIlI = this.cpool.getInvokeDynamicType(llllllllllllllIIllllllIlIIIllIll);
        this.checkParamTypes(llllllllllllllIIllllllIlIIIllIlI, 1);
        this.pushMemberType(llllllllllllllIIllllllIlIIIllIlI);
        return 5;
    }
    
    protected void visitBranch(final int llllllllllllllIIlllllllIlIlllIIl, final byte[] llllllllllllllIIlllllllIlIlllIII, final int llllllllllllllIIlllllllIlIllIlll) throws BadBytecode {
    }
    
    private int doMultiANewArray(final int llllllllllllllIIllllllIlIllIIlIl, final byte[] llllllllllllllIIllllllIlIllIIlII) {
        final int llllllllllllllIIllllllIlIllIIIll = ByteArray.readU16bit(llllllllllllllIIllllllIlIllIIlII, llllllllllllllIIllllllIlIllIIlIl + 1);
        final int llllllllllllllIIllllllIlIllIIIlI = llllllllllllllIIllllllIlIllIIlII[llllllllllllllIIllllllIlIllIIlIl + 3] & 0xFF;
        this.stackTop -= llllllllllllllIIllllllIlIllIIIlI - 1;
        final String llllllllllllllIIllllllIlIllIIIIl = this.cpool.getClassInfo(llllllllllllllIIllllllIlIllIIIll).replace('.', '/');
        this.stackTypes[this.stackTop - 1] = new TypeData.ClassName(llllllllllllllIIllllllIlIllIIIIl);
        return 4;
    }
    
    protected void visitThrow(final int llllllllllllllIIlllllllIlIlIlllI, final byte[] llllllllllllllIIlllllllIlIlIllIl) throws BadBytecode {
    }
    
    private int doXSTORE(final int llllllllllllllIIlllllllIIIllIlIl, final byte[] llllllllllllllIIlllllllIIIllIlII, final TypeData llllllllllllllIIlllllllIIIllIIll) {
        final int llllllllllllllIIlllllllIIIllIIlI = llllllllllllllIIlllllllIIIllIlII[llllllllllllllIIlllllllIIIllIlIl + 1] & 0xFF;
        return this.doXSTORE(llllllllllllllIIlllllllIIIllIIlI, llllllllllllllIIlllllllIIIllIIll);
    }
    
    private int doGetField(final int llllllllllllllIIllllllIllIIllIlI, final byte[] llllllllllllllIIllllllIllIIllIIl, final boolean llllllllllllllIIllllllIllIIllIII) throws BadBytecode {
        final int llllllllllllllIIllllllIllIIlIlll = ByteArray.readU16bit(llllllllllllllIIllllllIllIIllIIl, llllllllllllllIIllllllIllIIllIlI + 1);
        this.setFieldTarget(llllllllllllllIIllllllIllIIllIII, llllllllllllllIIllllllIllIIlIlll);
        final String llllllllllllllIIllllllIllIIlIllI = this.cpool.getFieldrefType(llllllllllllllIIllllllIllIIlIlll);
        this.pushMemberType(llllllllllllllIIllllllIllIIlIllI);
        return 3;
    }
    
    protected void visitTableSwitch(final int llllllllllllllIIlllllllIlIlIlIll, final byte[] llllllllllllllIIlllllllIlIlIlIlI, final int llllllllllllllIIlllllllIlIlIlIIl, final int llllllllllllllIIlllllllIlIlIlIII, final int llllllllllllllIIlllllllIlIlIIlll) throws BadBytecode {
    }
    
    private int doOpcode96_147(final int llllllllllllllIIlllllllIIIIIlIII, final byte[] llllllllllllllIIlllllllIIIIIIlll, final int llllllllllllllIIlllllllIIIIIIllI) {
        if (llllllllllllllIIlllllllIIIIIIllI <= 131) {
            this.stackTop += Opcode.STACK_GROW[llllllllllllllIIlllllllIIIIIIllI];
            return 1;
        }
        switch (llllllllllllllIIlllllllIIIIIIllI) {
            case 132: {
                return 3;
            }
            case 133: {
                this.stackTypes[this.stackTop - 1] = Tracer.LONG;
                this.stackTypes[this.stackTop] = Tracer.TOP;
                ++this.stackTop;
                break;
            }
            case 134: {
                this.stackTypes[this.stackTop - 1] = Tracer.FLOAT;
                break;
            }
            case 135: {
                this.stackTypes[this.stackTop - 1] = Tracer.DOUBLE;
                this.stackTypes[this.stackTop] = Tracer.TOP;
                ++this.stackTop;
                break;
            }
            case 136: {
                final TypeData[] stackTypes = this.stackTypes;
                final int stackTop = this.stackTop - 1;
                this.stackTop = stackTop;
                stackTypes[stackTop - 1] = Tracer.INTEGER;
                break;
            }
            case 137: {
                final TypeData[] stackTypes2 = this.stackTypes;
                final int stackTop2 = this.stackTop - 1;
                this.stackTop = stackTop2;
                stackTypes2[stackTop2 - 1] = Tracer.FLOAT;
                break;
            }
            case 138: {
                this.stackTypes[this.stackTop - 2] = Tracer.DOUBLE;
                break;
            }
            case 139: {
                this.stackTypes[this.stackTop - 1] = Tracer.INTEGER;
                break;
            }
            case 140: {
                this.stackTypes[this.stackTop - 1] = Tracer.LONG;
                this.stackTypes[this.stackTop] = Tracer.TOP;
                ++this.stackTop;
                break;
            }
            case 141: {
                this.stackTypes[this.stackTop - 1] = Tracer.DOUBLE;
                this.stackTypes[this.stackTop] = Tracer.TOP;
                ++this.stackTop;
                break;
            }
            case 142: {
                final TypeData[] stackTypes3 = this.stackTypes;
                final int stackTop3 = this.stackTop - 1;
                this.stackTop = stackTop3;
                stackTypes3[stackTop3 - 1] = Tracer.INTEGER;
                break;
            }
            case 143: {
                this.stackTypes[this.stackTop - 2] = Tracer.LONG;
                break;
            }
            case 144: {
                final TypeData[] stackTypes4 = this.stackTypes;
                final int stackTop4 = this.stackTop - 1;
                this.stackTop = stackTop4;
                stackTypes4[stackTop4 - 1] = Tracer.FLOAT;
                break;
            }
            case 145:
            case 146:
            case 147: {
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return 1;
    }
    
    private int doXSTORE(final int llllllllllllllIIlllllllIIIlIIlIl, final TypeData llllllllllllllIIlllllllIIIlIIlll) {
        --this.stackTop;
        this.localsTypes[llllllllllllllIIlllllllIIIlIIlIl] = llllllllllllllIIlllllllIIIlIIlll;
        if (llllllllllllllIIlllllllIIIlIIlll.is2WordType()) {
            --this.stackTop;
            this.localsTypes[llllllllllllllIIlllllllIIIlIIlIl + 1] = Tracer.TOP;
        }
        return 2;
    }
    
    private int doALOAD(final int llllllllllllllIIlllllllIIlIllIII) {
        this.stackTypes[this.stackTop++] = this.localsTypes[llllllllllllllIIlllllllIIlIllIII];
        return 2;
    }
    
    private static String getFieldClassName(final String llllllllllllllIIllllllIlIIIIIIll, final int llllllllllllllIIllllllIlIIIIIIlI) {
        return llllllllllllllIIllllllIlIIIIIIll.substring(llllllllllllllIIllllllIlIIIIIIlI + 1, llllllllllllllIIllllllIlIIIIIIll.length() - 1).replace('/', '.');
    }
    
    private void pushMemberType(final String llllllllllllllIIllllllIlIIIIlllI) {
        int llllllllllllllIIllllllIlIIIIllIl = 0;
        if (llllllllllllllIIllllllIlIIIIlllI.charAt(0) == '(') {
            llllllllllllllIIllllllIlIIIIllIl = llllllllllllllIIllllllIlIIIIlllI.indexOf(41) + 1;
            if (llllllllllllllIIllllllIlIIIIllIl < 1) {
                throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("bad descriptor: ").append(llllllllllllllIIllllllIlIIIIlllI)));
            }
        }
        final TypeData[] llllllllllllllIIllllllIlIIIIllII = this.stackTypes;
        final int llllllllllllllIIllllllIlIIIIlIll = this.stackTop;
        switch (llllllllllllllIIllllllIlIIIIlllI.charAt(llllllllllllllIIllllllIlIIIIllIl)) {
            case '[': {
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll] = new TypeData.ClassName(llllllllllllllIIllllllIlIIIIlllI.substring(llllllllllllllIIllllllIlIIIIllIl));
                break;
            }
            case 'L': {
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll] = new TypeData.ClassName(getFieldClassName(llllllllllllllIIllllllIlIIIIlllI, llllllllllllllIIllllllIlIIIIllIl));
                break;
            }
            case 'J': {
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll] = Tracer.LONG;
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll + 1] = Tracer.TOP;
                this.stackTop += 2;
                return;
            }
            case 'F': {
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll] = Tracer.FLOAT;
                break;
            }
            case 'D': {
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll] = Tracer.DOUBLE;
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll + 1] = Tracer.TOP;
                this.stackTop += 2;
                return;
            }
            case 'V': {
                return;
            }
            default: {
                llllllllllllllIIllllllIlIIIIllII[llllllllllllllIIllllllIlIIIIlIll] = Tracer.INTEGER;
                break;
            }
        }
        ++this.stackTop;
    }
}
