package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class Executor implements Opcode
{
    private final /* synthetic */ ClassPool classPool;
    private final /* synthetic */ ConstPool constPool;
    private /* synthetic */ int lastPos;
    private final /* synthetic */ Type CLASS_TYPE;
    private final /* synthetic */ Type THROWABLE_TYPE;
    private final /* synthetic */ Type STRING_TYPE;
    
    private Type simplePeek(final Frame lIIllIIIIlIlIll) {
        final Type lIIllIIIIlIllII = lIIllIIIIlIlIll.peek();
        return (lIIllIIIIlIllII == Type.TOP) ? lIIllIIIIlIlIll.getStack(lIIllIIIIlIlIll.getTopIndex() - 1) : lIIllIIIIlIllII;
    }
    
    private void evalWide(final int lIIllIIIlIllIll, final CodeIterator lIIllIIIlIllIlI, final Frame lIIllIIIlIllIIl, final Subroutine lIIllIIIlIllIII) throws BadBytecode {
        final int lIIllIIIlIllllI = lIIllIIIlIllIlI.byteAt(lIIllIIIlIllIll + 1);
        final int lIIllIIIlIlllIl = lIIllIIIlIllIlI.u16bitAt(lIIllIIIlIllIll + 2);
        switch (lIIllIIIlIllllI) {
            case 21: {
                this.evalLoad(Type.INTEGER, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 22: {
                this.evalLoad(Type.LONG, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 23: {
                this.evalLoad(Type.FLOAT, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 24: {
                this.evalLoad(Type.DOUBLE, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 25: {
                this.evalLoad(Type.OBJECT, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 54: {
                this.evalStore(Type.INTEGER, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 55: {
                this.evalStore(Type.LONG, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 56: {
                this.evalStore(Type.FLOAT, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 57: {
                this.evalStore(Type.DOUBLE, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 58: {
                this.evalStore(Type.OBJECT, lIIllIIIlIlllIl, lIIllIIIlIllIIl, lIIllIIIlIllIII);
                break;
            }
            case 132: {
                this.verifyAssignable(Type.INTEGER, lIIllIIIlIllIIl.getLocal(lIIllIIIlIlllIl));
                break;
            }
            case 169: {
                this.verifyAssignable(Type.RETURN_ADDRESS, lIIllIIIlIllIIl.getLocal(lIIllIIIlIlllIl));
                break;
            }
            default: {
                throw new BadBytecode(String.valueOf(new StringBuilder().append("Invalid WIDE operand [pos = ").append(lIIllIIIlIllIll).append("]: ").append(lIIllIIIlIllllI)));
            }
        }
    }
    
    private Type resolveClassInfo(final String lIIlIlllllllllI) throws BadBytecode {
        CtClass lIIllIIIIIIIIII = null;
        try {
            if (lIIlIlllllllllI.charAt(0) == '[') {
                lIIllIIIIIIIIII = Descriptor.toCtClass(lIIlIlllllllllI, this.classPool);
            }
            else {
                lIIllIIIIIIIIII = this.classPool.get(lIIlIlllllllllI);
            }
        }
        catch (NotFoundException lIIllIIIIIIIIll) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not find class in descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIllIIIIIIIIll.getMessage())));
        }
        if (lIIllIIIIIIIIII == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not obtain type for descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIlIlllllllllI)));
        }
        return Type.get(lIIllIIIIIIIIII);
    }
    
    public Executor(final ClassPool lIIllIllIlllIlI, final ConstPool lIIllIllIllllII) {
        this.constPool = lIIllIllIllllII;
        this.classPool = lIIllIllIlllIlI;
        try {
            this.STRING_TYPE = this.getType("java.lang.String");
            this.CLASS_TYPE = this.getType("java.lang.Class");
            this.THROWABLE_TYPE = this.getType("java.lang.Throwable");
        }
        catch (Exception lIIllIllIllllll) {
            throw new RuntimeException(lIIllIllIllllll);
        }
    }
    
    private void evalLDC(final int lIIllIIlllIIllI, final Frame lIIllIIlllIIIII) throws BadBytecode {
        final int lIIllIIlllIIlII = this.constPool.getTag(lIIllIIlllIIllI);
        switch (lIIllIIlllIIlII) {
            case 8: {
                final Type lIIllIIlllIllIl = this.STRING_TYPE;
                break;
            }
            case 3: {
                final Type lIIllIIlllIllII = Type.INTEGER;
                break;
            }
            case 4: {
                final Type lIIllIIlllIlIll = Type.FLOAT;
                break;
            }
            case 5: {
                final Type lIIllIIlllIlIlI = Type.LONG;
                break;
            }
            case 6: {
                final Type lIIllIIlllIlIIl = Type.DOUBLE;
                break;
            }
            case 7: {
                final Type lIIllIIlllIlIII = this.CLASS_TYPE;
                break;
            }
            default: {
                throw new BadBytecode(String.valueOf(new StringBuilder().append("bad LDC [pos = ").append(this.lastPos).append("]: ").append(lIIllIIlllIIlII)));
            }
        }
        final Type lIIllIIlllIIIll;
        this.simplePush(lIIllIIlllIIIll, lIIllIIlllIIIII);
    }
    
    private void simpleSetLocal(final int lIIllIIIIIIlIlI, final Type lIIllIIIIIIllII, final Frame lIIllIIIIIIlIll) {
        lIIllIIIIIIlIll.setLocal(lIIllIIIIIIlIlI, lIIllIIIIIIllII);
        if (lIIllIIIIIIllII.getSize() == 2) {
            lIIllIIIIIIlIll.setLocal(lIIllIIIIIIlIlI + 1, Type.TOP);
        }
    }
    
    public void execute(final MethodInfo lIIllIllIIlIllI, final int lIIllIllIIlIlIl, final CodeIterator lIIllIllIIlIlII, final Frame lIIllIllIIllIlI, final Subroutine lIIllIllIIlIIlI) throws BadBytecode {
        this.lastPos = lIIllIllIIlIlIl;
        final int lIIllIllIIllIII = lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl);
        switch (lIIllIllIIllIII) {
            case 1: {
                lIIllIllIIllIlI.push(Type.UNINIT);
                break;
            }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 9:
            case 10: {
                lIIllIllIIllIlI.push(Type.LONG);
                lIIllIllIIllIlI.push(Type.TOP);
                break;
            }
            case 11:
            case 12:
            case 13: {
                lIIllIllIIllIlI.push(Type.FLOAT);
                break;
            }
            case 14:
            case 15: {
                lIIllIllIIllIlI.push(Type.DOUBLE);
                lIIllIllIIllIlI.push(Type.TOP);
                break;
            }
            case 16:
            case 17: {
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 18: {
                this.evalLDC(lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 19:
            case 20: {
                this.evalLDC(lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 21: {
                this.evalLoad(Type.INTEGER, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 22: {
                this.evalLoad(Type.LONG, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 23: {
                this.evalLoad(Type.FLOAT, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 24: {
                this.evalLoad(Type.DOUBLE, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 25: {
                this.evalLoad(Type.OBJECT, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 26:
            case 27:
            case 28:
            case 29: {
                this.evalLoad(Type.INTEGER, lIIllIllIIllIII - 26, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 30:
            case 31:
            case 32:
            case 33: {
                this.evalLoad(Type.LONG, lIIllIllIIllIII - 30, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 34:
            case 35:
            case 36:
            case 37: {
                this.evalLoad(Type.FLOAT, lIIllIllIIllIII - 34, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 38:
            case 39:
            case 40:
            case 41: {
                this.evalLoad(Type.DOUBLE, lIIllIllIIllIII - 38, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 42:
            case 43:
            case 44:
            case 45: {
                this.evalLoad(Type.OBJECT, lIIllIllIIllIII - 42, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 46: {
                this.evalArrayLoad(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 47: {
                this.evalArrayLoad(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 48: {
                this.evalArrayLoad(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 49: {
                this.evalArrayLoad(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 50: {
                this.evalArrayLoad(Type.OBJECT, lIIllIllIIllIlI);
                break;
            }
            case 51:
            case 52:
            case 53: {
                this.evalArrayLoad(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 54: {
                this.evalStore(Type.INTEGER, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 55: {
                this.evalStore(Type.LONG, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 56: {
                this.evalStore(Type.FLOAT, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 57: {
                this.evalStore(Type.DOUBLE, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 58: {
                this.evalStore(Type.OBJECT, lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 59:
            case 60:
            case 61:
            case 62: {
                this.evalStore(Type.INTEGER, lIIllIllIIllIII - 59, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 63:
            case 64:
            case 65:
            case 66: {
                this.evalStore(Type.LONG, lIIllIllIIllIII - 63, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 67:
            case 68:
            case 69:
            case 70: {
                this.evalStore(Type.FLOAT, lIIllIllIIllIII - 67, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 71:
            case 72:
            case 73:
            case 74: {
                this.evalStore(Type.DOUBLE, lIIllIllIIllIII - 71, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 75:
            case 76:
            case 77:
            case 78: {
                this.evalStore(Type.OBJECT, lIIllIllIIllIII - 75, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 79: {
                this.evalArrayStore(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 80: {
                this.evalArrayStore(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 81: {
                this.evalArrayStore(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 82: {
                this.evalArrayStore(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 83: {
                this.evalArrayStore(Type.OBJECT, lIIllIllIIllIlI);
                break;
            }
            case 84:
            case 85:
            case 86: {
                this.evalArrayStore(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 87: {
                if (lIIllIllIIllIlI.pop() == Type.TOP) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("POP can not be used with a category 2 value, pos = ").append(lIIllIllIIlIlIl)));
                }
                break;
            }
            case 88: {
                lIIllIllIIllIlI.pop();
                lIIllIllIIllIlI.pop();
                break;
            }
            case 89: {
                final Type lIIllIllIlIllII = lIIllIllIIllIlI.peek();
                if (lIIllIllIlIllII == Type.TOP) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("DUP can not be used with a category 2 value, pos = ").append(lIIllIllIIlIlIl)));
                }
                lIIllIllIIllIlI.push(lIIllIllIIllIlI.peek());
                break;
            }
            case 90:
            case 91: {
                final Type lIIllIllIlIlIll = lIIllIllIIllIlI.peek();
                if (lIIllIllIlIlIll == Type.TOP) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("DUP can not be used with a category 2 value, pos = ").append(lIIllIllIIlIlIl)));
                }
                int lIIllIllIlIlIlI = lIIllIllIIllIlI.getTopIndex();
                final int lIIllIllIlIlIIl = lIIllIllIlIlIlI - (lIIllIllIIllIII - 90) - 1;
                lIIllIllIIllIlI.push(lIIllIllIlIlIll);
                while (lIIllIllIlIlIlI > lIIllIllIlIlIIl) {
                    lIIllIllIIllIlI.setStack(lIIllIllIlIlIlI, lIIllIllIIllIlI.getStack(lIIllIllIlIlIlI - 1));
                    --lIIllIllIlIlIlI;
                }
                lIIllIllIIllIlI.setStack(lIIllIllIlIlIIl, lIIllIllIlIlIll);
                break;
            }
            case 92: {
                lIIllIllIIllIlI.push(lIIllIllIIllIlI.getStack(lIIllIllIIllIlI.getTopIndex() - 1));
                lIIllIllIIllIlI.push(lIIllIllIIllIlI.getStack(lIIllIllIIllIlI.getTopIndex() - 1));
                break;
            }
            case 93:
            case 94: {
                int lIIllIllIlIlIII = lIIllIllIIllIlI.getTopIndex();
                final int lIIllIllIlIIlll = lIIllIllIlIlIII - (lIIllIllIIllIII - 93) - 1;
                final Type lIIllIllIlIIllI = lIIllIllIIllIlI.getStack(lIIllIllIIllIlI.getTopIndex() - 1);
                final Type lIIllIllIlIIlIl = lIIllIllIIllIlI.peek();
                lIIllIllIIllIlI.push(lIIllIllIlIIllI);
                lIIllIllIIllIlI.push(lIIllIllIlIIlIl);
                while (lIIllIllIlIlIII > lIIllIllIlIIlll) {
                    lIIllIllIIllIlI.setStack(lIIllIllIlIlIII, lIIllIllIIllIlI.getStack(lIIllIllIlIlIII - 2));
                    --lIIllIllIlIlIII;
                }
                lIIllIllIIllIlI.setStack(lIIllIllIlIIlll, lIIllIllIlIIlIl);
                lIIllIllIIllIlI.setStack(lIIllIllIlIIlll - 1, lIIllIllIlIIllI);
                break;
            }
            case 95: {
                final Type lIIllIllIlIIlII = lIIllIllIIllIlI.pop();
                final Type lIIllIllIlIIIll = lIIllIllIIllIlI.pop();
                if (lIIllIllIlIIlII.getSize() == 2 || lIIllIllIlIIIll.getSize() == 2) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("Swap can not be used with category 2 values, pos = ").append(lIIllIllIIlIlIl)));
                }
                lIIllIllIIllIlI.push(lIIllIllIlIIlII);
                lIIllIllIIllIlI.push(lIIllIllIlIIIll);
                break;
            }
            case 96: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 97: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 98: {
                this.evalBinaryMath(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 99: {
                this.evalBinaryMath(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 100: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 101: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 102: {
                this.evalBinaryMath(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 103: {
                this.evalBinaryMath(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 104: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 105: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 106: {
                this.evalBinaryMath(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 107: {
                this.evalBinaryMath(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 108: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 109: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 110: {
                this.evalBinaryMath(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 111: {
                this.evalBinaryMath(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 112: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 113: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 114: {
                this.evalBinaryMath(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 115: {
                this.evalBinaryMath(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 116: {
                this.verifyAssignable(Type.INTEGER, this.simplePeek(lIIllIllIIllIlI));
                break;
            }
            case 117: {
                this.verifyAssignable(Type.LONG, this.simplePeek(lIIllIllIIllIlI));
                break;
            }
            case 118: {
                this.verifyAssignable(Type.FLOAT, this.simplePeek(lIIllIllIIllIlI));
                break;
            }
            case 119: {
                this.verifyAssignable(Type.DOUBLE, this.simplePeek(lIIllIllIIllIlI));
                break;
            }
            case 120: {
                this.evalShift(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 121: {
                this.evalShift(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 122: {
                this.evalShift(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 123: {
                this.evalShift(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 124: {
                this.evalShift(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 125: {
                this.evalShift(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 126: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 127: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 128: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 129: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 130: {
                this.evalBinaryMath(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 131: {
                this.evalBinaryMath(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 132: {
                final int lIIllIllIlIIIlI = lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1);
                this.verifyAssignable(Type.INTEGER, lIIllIllIIllIlI.getLocal(lIIllIllIlIIIlI));
                this.access(lIIllIllIlIIIlI, Type.INTEGER, lIIllIllIIlIIlI);
                break;
            }
            case 133: {
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 134: {
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 135: {
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 136: {
                this.verifyAssignable(Type.LONG, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 137: {
                this.verifyAssignable(Type.LONG, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 138: {
                this.verifyAssignable(Type.LONG, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 139: {
                this.verifyAssignable(Type.FLOAT, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 140: {
                this.verifyAssignable(Type.FLOAT, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 141: {
                this.verifyAssignable(Type.FLOAT, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.DOUBLE, lIIllIllIIllIlI);
                break;
            }
            case 142: {
                this.verifyAssignable(Type.DOUBLE, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.INTEGER, lIIllIllIIllIlI);
                break;
            }
            case 143: {
                this.verifyAssignable(Type.DOUBLE, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.LONG, lIIllIllIIllIlI);
                break;
            }
            case 144: {
                this.verifyAssignable(Type.DOUBLE, this.simplePop(lIIllIllIIllIlI));
                this.simplePush(Type.FLOAT, lIIllIllIIllIlI);
                break;
            }
            case 145:
            case 146:
            case 147: {
                this.verifyAssignable(Type.INTEGER, lIIllIllIIllIlI.peek());
                break;
            }
            case 148: {
                this.verifyAssignable(Type.LONG, this.simplePop(lIIllIllIIllIlI));
                this.verifyAssignable(Type.LONG, this.simplePop(lIIllIllIIllIlI));
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 149:
            case 150: {
                this.verifyAssignable(Type.FLOAT, this.simplePop(lIIllIllIIllIlI));
                this.verifyAssignable(Type.FLOAT, this.simplePop(lIIllIllIIllIlI));
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 151:
            case 152: {
                this.verifyAssignable(Type.DOUBLE, this.simplePop(lIIllIllIIllIlI));
                this.verifyAssignable(Type.DOUBLE, this.simplePop(lIIllIllIIllIlI));
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158: {
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164: {
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 165:
            case 166: {
                this.verifyAssignable(Type.OBJECT, this.simplePop(lIIllIllIIllIlI));
                this.verifyAssignable(Type.OBJECT, this.simplePop(lIIllIllIIllIlI));
            }
            case 168: {
                lIIllIllIIllIlI.push(Type.RETURN_ADDRESS);
                break;
            }
            case 169: {
                this.verifyAssignable(Type.RETURN_ADDRESS, lIIllIllIIllIlI.getLocal(lIIllIllIIlIlII.byteAt(lIIllIllIIlIlIl + 1)));
                break;
            }
            case 170:
            case 171:
            case 172: {
                this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 173: {
                this.verifyAssignable(Type.LONG, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 174: {
                this.verifyAssignable(Type.FLOAT, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 175: {
                this.verifyAssignable(Type.DOUBLE, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 176: {
                try {
                    final CtClass lIIllIllIlIIIIl = Descriptor.getReturnType(lIIllIllIIlIllI.getDescriptor(), this.classPool);
                    this.verifyAssignable(Type.get(lIIllIllIlIIIIl), this.simplePop(lIIllIllIIllIlI));
                }
                catch (NotFoundException lIIllIllIlIIIII) {
                    throw new RuntimeException(lIIllIllIlIIIII);
                }
            }
            case 178: {
                this.evalGetField(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 179: {
                this.evalPutField(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 180: {
                this.evalGetField(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 181: {
                this.evalPutField(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 182:
            case 183:
            case 184: {
                this.evalInvokeMethod(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 185: {
                this.evalInvokeIntfMethod(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 186: {
                this.evalInvokeDynamic(lIIllIllIIllIII, lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1), lIIllIllIIllIlI);
                break;
            }
            case 187: {
                lIIllIllIIllIlI.push(this.resolveClassInfo(this.constPool.getClassInfo(lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1))));
                break;
            }
            case 188: {
                this.evalNewArray(lIIllIllIIlIlIl, lIIllIllIIlIlII, lIIllIllIIllIlI);
                break;
            }
            case 189: {
                this.evalNewObjectArray(lIIllIllIIlIlIl, lIIllIllIIlIlII, lIIllIllIIllIlI);
                break;
            }
            case 190: {
                final Type lIIllIllIIlllll = this.simplePop(lIIllIllIIllIlI);
                if (!lIIllIllIIlllll.isArray() && lIIllIllIIlllll != Type.UNINIT) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("Array length passed a non-array [pos = ").append(lIIllIllIIlIlIl).append("]: ").append(lIIllIllIIlllll)));
                }
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 191: {
                this.verifyAssignable(this.THROWABLE_TYPE, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 192: {
                this.verifyAssignable(Type.OBJECT, this.simplePop(lIIllIllIIllIlI));
                lIIllIllIIllIlI.push(this.typeFromDesc(this.constPool.getClassInfoByDescriptor(lIIllIllIIlIlII.u16bitAt(lIIllIllIIlIlIl + 1))));
                break;
            }
            case 193: {
                this.verifyAssignable(Type.OBJECT, this.simplePop(lIIllIllIIllIlI));
                lIIllIllIIllIlI.push(Type.INTEGER);
                break;
            }
            case 194:
            case 195: {
                this.verifyAssignable(Type.OBJECT, this.simplePop(lIIllIllIIllIlI));
                break;
            }
            case 196: {
                this.evalWide(lIIllIllIIlIlIl, lIIllIllIIlIlII, lIIllIllIIllIlI, lIIllIllIIlIIlI);
                break;
            }
            case 197: {
                this.evalNewObjectArray(lIIllIllIIlIlIl, lIIllIllIIlIlII, lIIllIllIIllIlI);
                break;
            }
            case 198:
            case 199: {
                this.verifyAssignable(Type.OBJECT, this.simplePop(lIIllIllIIllIlI));
            }
            case 201: {
                lIIllIllIIllIlI.push(Type.RETURN_ADDRESS);
                break;
            }
        }
    }
    
    private void evalInvokeIntfMethod(final int lIIllIlIIllIIll, final int lIIllIlIIllIIlI, final Frame lIIllIlIIllIIIl) throws BadBytecode {
        final String lIIllIlIIllIIII = this.constPool.getInterfaceMethodrefType(lIIllIlIIllIIlI);
        final Type[] lIIllIlIIlIllll = this.paramTypesFromDesc(lIIllIlIIllIIII);
        int lIIllIlIIlIlllI = lIIllIlIIlIllll.length;
        while (lIIllIlIIlIlllI > 0) {
            this.verifyAssignable(this.zeroExtend(lIIllIlIIlIllll[--lIIllIlIIlIlllI]), this.simplePop(lIIllIlIIllIIIl));
        }
        final String lIIllIlIIlIllIl = this.constPool.getInterfaceMethodrefClassName(lIIllIlIIllIIlI);
        final Type lIIllIlIIlIllII = this.resolveClassInfo(lIIllIlIIlIllIl);
        this.verifyAssignable(lIIllIlIIlIllII, this.simplePop(lIIllIlIIllIIIl));
        final Type lIIllIlIIlIlIll = this.returnTypeFromDesc(lIIllIlIIllIIII);
        if (lIIllIlIIlIlIll != Type.VOID) {
            this.simplePush(this.zeroExtend(lIIllIlIIlIlIll), lIIllIlIIllIIIl);
        }
    }
    
    private void evalNewObjectArray(final int lIIllIIlIlIIlll, final CodeIterator lIIllIIlIlIIllI, final Frame lIIllIIlIlIIlIl) throws BadBytecode {
        final Type lIIllIIlIlIllII = this.resolveClassInfo(this.constPool.getClassInfo(lIIllIIlIlIIllI.u16bitAt(lIIllIIlIlIIlll + 1)));
        String lIIllIIlIlIlIll = lIIllIIlIlIllII.getCtClass().getName();
        final int lIIllIIlIlIlIlI = lIIllIIlIlIIllI.byteAt(lIIllIIlIlIIlll);
        int lIIllIIlIlIlIIl = 0;
        if (lIIllIIlIlIlIlI == 197) {
            final int lIIllIIlIllIIIl = lIIllIIlIlIIllI.byteAt(lIIllIIlIlIIlll + 3);
        }
        else {
            lIIllIIlIlIlIll = String.valueOf(new StringBuilder().append(lIIllIIlIlIlIll).append("[]"));
            lIIllIIlIlIlIIl = 1;
        }
        while (lIIllIIlIlIlIIl-- > 0) {
            this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIIlIlIIlIl));
        }
        this.simplePush(this.getType(lIIllIIlIlIlIll), lIIllIIlIlIIlIl);
    }
    
    private void evalNewArray(final int lIIllIIlIlllllI, final CodeIterator lIIllIIllIIIIll, final Frame lIIllIIllIIIIlI) throws BadBytecode {
        this.verifyAssignable(Type.INTEGER, this.simplePop(lIIllIIllIIIIlI));
        Type lIIllIIllIIIIIl = null;
        final int lIIllIIllIIIIII = lIIllIIllIIIIll.byteAt(lIIllIIlIlllllI + 1);
        switch (lIIllIIllIIIIII) {
            case 4: {
                lIIllIIllIIIIIl = this.getType("boolean[]");
                break;
            }
            case 5: {
                lIIllIIllIIIIIl = this.getType("char[]");
                break;
            }
            case 8: {
                lIIllIIllIIIIIl = this.getType("byte[]");
                break;
            }
            case 9: {
                lIIllIIllIIIIIl = this.getType("short[]");
                break;
            }
            case 10: {
                lIIllIIllIIIIIl = this.getType("int[]");
                break;
            }
            case 11: {
                lIIllIIllIIIIIl = this.getType("long[]");
                break;
            }
            case 6: {
                lIIllIIllIIIIIl = this.getType("float[]");
                break;
            }
            case 7: {
                lIIllIIllIIIIIl = this.getType("double[]");
                break;
            }
            default: {
                throw new BadBytecode(String.valueOf(new StringBuilder().append("Invalid array type [pos = ").append(lIIllIIlIlllllI).append("]: ").append(lIIllIIllIIIIII)));
            }
        }
        lIIllIIllIIIIlI.push(lIIllIIllIIIIIl);
    }
    
    private void evalLoad(final Type lIIllIIllIlIllI, final int lIIllIIllIlIlIl, final Frame lIIllIIllIIlllI, final Subroutine lIIllIIllIlIIll) throws BadBytecode {
        final Type lIIllIIllIlIIlI = lIIllIIllIIlllI.getLocal(lIIllIIllIlIlIl);
        this.verifyAssignable(lIIllIIllIlIllI, lIIllIIllIlIIlI);
        this.simplePush(lIIllIIllIlIIlI, lIIllIIllIIlllI);
        this.access(lIIllIIllIlIlIl, lIIllIIllIlIIlI, lIIllIIllIlIIll);
    }
    
    private void evalPutField(final int lIIllIIlIIlIlll, final int lIIllIIlIIlIIII, final Frame lIIllIIlIIlIlIl) throws BadBytecode {
        final String lIIllIIlIIlIlII = this.constPool.getFieldrefType(lIIllIIlIIlIIII);
        final Type lIIllIIlIIlIIll = this.zeroExtend(this.typeFromDesc(lIIllIIlIIlIlII));
        this.verifyAssignable(lIIllIIlIIlIIll, this.simplePop(lIIllIIlIIlIlIl));
        if (lIIllIIlIIlIlll == 181) {
            final Type lIIllIIlIIllIIl = this.resolveClassInfo(this.constPool.getFieldrefClassName(lIIllIIlIIlIIII));
            this.verifyAssignable(lIIllIIlIIllIIl, this.simplePop(lIIllIIlIIlIlIl));
        }
    }
    
    private Type returnTypeFromDesc(final String lIIllIIIIllIIll) throws BadBytecode {
        CtClass lIIllIIIIllIlIl = null;
        try {
            lIIllIIIIllIlIl = Descriptor.getReturnType(lIIllIIIIllIIll, this.classPool);
        }
        catch (NotFoundException lIIllIIIIlllIII) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not find class in descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIllIIIIlllIII.getMessage())));
        }
        if (lIIllIIIIllIlIl == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not obtain return type for descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIllIIIIllIIll)));
        }
        return Type.get(lIIllIIIIllIlIl);
    }
    
    private void evalArrayStore(final Type lIIllIlIllIIlll, final Frame lIIllIlIllIllIl) throws BadBytecode {
        final Type lIIllIlIllIllII = this.simplePop(lIIllIlIllIllIl);
        final Type lIIllIlIllIlIll = lIIllIlIllIllIl.pop();
        final Type lIIllIlIllIlIlI = lIIllIlIllIllIl.pop();
        if (lIIllIlIllIlIlI == Type.UNINIT) {
            this.verifyAssignable(Type.INTEGER, lIIllIlIllIlIll);
            return;
        }
        Type lIIllIlIllIlIIl = lIIllIlIllIlIlI.getComponent();
        if (lIIllIlIllIlIIl == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Not an array! [pos = ").append(this.lastPos).append("]: ").append(lIIllIlIllIlIIl)));
        }
        lIIllIlIllIlIIl = this.zeroExtend(lIIllIlIllIlIIl);
        this.verifyAssignable(lIIllIlIllIIlll, lIIllIlIllIlIIl);
        this.verifyAssignable(Type.INTEGER, lIIllIlIllIlIll);
        if (lIIllIlIllIIlll == Type.OBJECT) {
            this.verifyAssignable(lIIllIlIllIIlll, lIIllIlIllIllII);
        }
        else {
            this.verifyAssignable(lIIllIlIllIlIIl, lIIllIlIllIllII);
        }
    }
    
    private void evalInvokeDynamic(final int lIIllIlIIIIIIII, final int lIIllIIlllllIII, final Frame lIIllIIllllIlll) throws BadBytecode {
        final String lIIllIIllllllIl = this.constPool.getInvokeDynamicType(lIIllIIlllllIII);
        final Type[] lIIllIIllllllII = this.paramTypesFromDesc(lIIllIIllllllIl);
        int lIIllIIlllllIll = lIIllIIllllllII.length;
        while (lIIllIIlllllIll > 0) {
            this.verifyAssignable(this.zeroExtend(lIIllIIllllllII[--lIIllIIlllllIll]), this.simplePop(lIIllIIllllIlll));
        }
        final Type lIIllIIlllllIlI = this.returnTypeFromDesc(lIIllIIllllllIl);
        if (lIIllIIlllllIlI != Type.VOID) {
            this.simplePush(this.zeroExtend(lIIllIIlllllIlI), lIIllIIllllIlll);
        }
    }
    
    private void evalInvokeMethod(final int lIIllIlIIIIllll, final int lIIllIlIIIIlllI, final Frame lIIllIlIIIlIlIl) throws BadBytecode {
        final String lIIllIlIIIlIlII = this.constPool.getMethodrefType(lIIllIlIIIIlllI);
        final Type[] lIIllIlIIIlIIll = this.paramTypesFromDesc(lIIllIlIIIlIlII);
        int lIIllIlIIIlIIlI = lIIllIlIIIlIIll.length;
        while (lIIllIlIIIlIIlI > 0) {
            this.verifyAssignable(this.zeroExtend(lIIllIlIIIlIIll[--lIIllIlIIIlIIlI]), this.simplePop(lIIllIlIIIlIlIl));
        }
        if (lIIllIlIIIIllll != 184) {
            final Type lIIllIlIIIllIIl = this.resolveClassInfo(this.constPool.getMethodrefClassName(lIIllIlIIIIlllI));
            this.verifyAssignable(lIIllIlIIIllIIl, this.simplePop(lIIllIlIIIlIlIl));
        }
        final Type lIIllIlIIIlIIIl = this.returnTypeFromDesc(lIIllIlIIIlIlII);
        if (lIIllIlIIIlIIIl != Type.VOID) {
            this.simplePush(this.zeroExtend(lIIllIlIIIlIIIl), lIIllIlIIIlIlIl);
        }
    }
    
    private void evalBinaryMath(final Type lIIllIlIlIlIllI, final Frame lIIllIlIlIllIlI) throws BadBytecode {
        final Type lIIllIlIlIllIIl = this.simplePop(lIIllIlIlIllIlI);
        final Type lIIllIlIlIllIII = this.simplePop(lIIllIlIlIllIlI);
        this.verifyAssignable(lIIllIlIlIlIllI, lIIllIlIlIllIIl);
        this.verifyAssignable(lIIllIlIlIlIllI, lIIllIlIlIllIII);
        this.simplePush(lIIllIlIlIllIII, lIIllIlIlIllIlI);
    }
    
    private void evalShift(final Type lIIllIIlIIIIIII, final Frame lIIllIIIlllllll) throws BadBytecode {
        final Type lIIllIIlIIIIIll = this.simplePop(lIIllIIIlllllll);
        final Type lIIllIIlIIIIIlI = this.simplePop(lIIllIIIlllllll);
        this.verifyAssignable(Type.INTEGER, lIIllIIlIIIIIll);
        this.verifyAssignable(lIIllIIlIIIIIII, lIIllIIlIIIIIlI);
        this.simplePush(lIIllIIlIIIIIlI, lIIllIIIlllllll);
    }
    
    private Type simplePop(final Frame lIIllIIIIlIIlII) {
        final Type lIIllIIIIlIIlIl = lIIllIIIIlIIlII.pop();
        return (lIIllIIIIlIIlIl == Type.TOP) ? lIIllIIIIlIIlII.pop() : lIIllIIIIlIIlIl;
    }
    
    private Type[] paramTypesFromDesc(final String lIIllIIIlIIIlII) throws BadBytecode {
        CtClass[] lIIllIIIlIIIIll = null;
        try {
            lIIllIIIlIIIIll = Descriptor.getParameterTypes(lIIllIIIlIIIlII, this.classPool);
        }
        catch (NotFoundException lIIllIIIlIIIlll) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not find class in descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIllIIIlIIIlll.getMessage())));
        }
        if (lIIllIIIlIIIIll == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not obtain parameters for descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIllIIIlIIIlII)));
        }
        final Type[] lIIllIIIlIIIIlI = new Type[lIIllIIIlIIIIll.length];
        for (int lIIllIIIlIIIllI = 0; lIIllIIIlIIIllI < lIIllIIIlIIIIlI.length; ++lIIllIIIlIIIllI) {
            lIIllIIIlIIIIlI[lIIllIIIlIIIllI] = Type.get(lIIllIIIlIIIIll[lIIllIIIlIIIllI]);
        }
        return lIIllIIIlIIIIlI;
    }
    
    private Type getType(final String lIIllIIIlIIlllI) throws BadBytecode {
        try {
            return Type.get(this.classPool.get(lIIllIIIlIIlllI));
        }
        catch (NotFoundException lIIllIIIlIlIIlI) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not find class [pos = ").append(this.lastPos).append("]: ").append(lIIllIIIlIIlllI)));
        }
    }
    
    private void verifyAssignable(final Type lIIlIlllllIlIII, final Type lIIlIlllllIlIlI) throws BadBytecode {
        if (!lIIlIlllllIlIII.isAssignableFrom(lIIlIlllllIlIlI)) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Expected type: ").append(lIIlIlllllIlIII).append(" Got: ").append(lIIlIlllllIlIlI).append(" [pos = ").append(this.lastPos).append("]")));
        }
    }
    
    private Type zeroExtend(final Type lIIllIllIIIlIlI) {
        if (lIIllIllIIIlIlI == Type.SHORT || lIIllIllIIIlIlI == Type.BYTE || lIIllIllIIIlIlI == Type.CHAR || lIIllIllIIIlIlI == Type.BOOLEAN) {
            return Type.INTEGER;
        }
        return lIIllIllIIIlIlI;
    }
    
    private void access(final int lIIllIIIIIlIlII, final Type lIIllIIIIIlIIll, final Subroutine lIIllIIIIIlIIlI) {
        if (lIIllIIIIIlIIlI == null) {
            return;
        }
        lIIllIIIIIlIIlI.access(lIIllIIIIIlIlII);
        if (lIIllIIIIIlIIll.getSize() == 2) {
            lIIllIIIIIlIIlI.access(lIIllIIIIIlIlII + 1);
        }
    }
    
    private Type typeFromDesc(final String lIIlIllllllIlIl) throws BadBytecode {
        CtClass lIIlIllllllIlII = null;
        try {
            lIIlIllllllIlII = Descriptor.toCtClass(lIIlIllllllIlIl, this.classPool);
        }
        catch (NotFoundException lIIlIllllllIlll) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not find class in descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIlIllllllIlll.getMessage())));
        }
        if (lIIlIllllllIlII == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Could not obtain type for descriptor [pos = ").append(this.lastPos).append("]: ").append(lIIlIllllllIlIl)));
        }
        return Type.get(lIIlIllllllIlII);
    }
    
    private void evalStore(final Type lIIllIIIlllIlIl, final int lIIllIIIllIlllI, final Frame lIIllIIIllIllIl, final Subroutine lIIllIIIllIllII) throws BadBytecode {
        final Type lIIllIIIlllIIIl = this.simplePop(lIIllIIIllIllIl);
        if (lIIllIIIlllIlIl != Type.OBJECT || lIIllIIIlllIIIl != Type.RETURN_ADDRESS) {
            this.verifyAssignable(lIIllIIIlllIlIl, lIIllIIIlllIIIl);
        }
        this.simpleSetLocal(lIIllIIIllIlllI, lIIllIIIlllIIIl, lIIllIIIllIllIl);
        this.access(lIIllIIIllIlllI, lIIllIIIlllIIIl, lIIllIIIllIllII);
    }
    
    private void evalGetField(final int lIIllIlIlIIIIll, final int lIIllIlIlIIlIII, final Frame lIIllIlIlIIIlll) throws BadBytecode {
        final String lIIllIlIlIIIllI = this.constPool.getFieldrefType(lIIllIlIlIIlIII);
        final Type lIIllIlIlIIIlIl = this.zeroExtend(this.typeFromDesc(lIIllIlIlIIIllI));
        if (lIIllIlIlIIIIll == 180) {
            final Type lIIllIlIlIIlIll = this.resolveClassInfo(this.constPool.getFieldrefClassName(lIIllIlIlIIlIII));
            this.verifyAssignable(lIIllIlIlIIlIll, this.simplePop(lIIllIlIlIIIlll));
        }
        this.simplePush(lIIllIlIlIIIlIl, lIIllIlIlIIIlll);
    }
    
    private void evalArrayLoad(final Type lIIllIllIIIIIIl, final Frame lIIllIllIIIIIII) throws BadBytecode {
        final Type lIIllIlIlllllll = lIIllIllIIIIIII.pop();
        final Type lIIllIlIllllllI = lIIllIllIIIIIII.pop();
        if (lIIllIlIllllllI == Type.UNINIT) {
            this.verifyAssignable(Type.INTEGER, lIIllIlIlllllll);
            if (lIIllIllIIIIIIl == Type.OBJECT) {
                this.simplePush(Type.UNINIT, lIIllIllIIIIIII);
            }
            else {
                this.simplePush(lIIllIllIIIIIIl, lIIllIllIIIIIII);
            }
            return;
        }
        Type lIIllIlIlllllIl = lIIllIlIllllllI.getComponent();
        if (lIIllIlIlllllIl == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Not an array! [pos = ").append(this.lastPos).append("]: ").append(lIIllIlIlllllIl)));
        }
        lIIllIlIlllllIl = this.zeroExtend(lIIllIlIlllllIl);
        this.verifyAssignable(lIIllIllIIIIIIl, lIIllIlIlllllIl);
        this.verifyAssignable(Type.INTEGER, lIIllIlIlllllll);
        this.simplePush(lIIllIlIlllllIl, lIIllIllIIIIIII);
    }
    
    private void simplePush(final Type lIIllIIIIIlllll, final Frame lIIllIIIIIllllI) {
        lIIllIIIIIllllI.push(lIIllIIIIIlllll);
        if (lIIllIIIIIlllll.getSize() == 2) {
            lIIllIIIIIllllI.push(Type.TOP);
        }
    }
}
