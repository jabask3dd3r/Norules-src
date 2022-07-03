package com.viaversion.viaversion.libs.javassist.bytecode.stackmap;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class MapMaker extends Tracer
{
    void make(final TypedBlock[] lllllllllllllIllIllIIllllllIIlIl, final byte[] lllllllllllllIllIllIIllllllIIlll) throws BadBytecode {
        this.make(lllllllllllllIllIllIIllllllIIlll, lllllllllllllIllIllIIllllllIIlIl[0]);
        this.findDeadCatchers(lllllllllllllIllIllIIllllllIIlll, lllllllllllllIllIllIIllllllIIlIl);
        try {
            this.fixTypes(lllllllllllllIllIllIIllllllIIlll, lllllllllllllIllIllIIllllllIIlIl);
        }
        catch (NotFoundException lllllllllllllIllIllIIllllllIlIlI) {
            throw new BadBytecode("failed to resolve types", lllllllllllllIllIllIIllllllIlIlI);
        }
    }
    
    private void writeStackFrame(final StackMap.Writer lllllllllllllIllIllIIllIIIlllIIl, final ConstPool lllllllllllllIllIllIIllIIIllllIl, final int lllllllllllllIllIllIIllIIIllllII, final TypedBlock lllllllllllllIllIllIIllIIIllIllI) {
        lllllllllllllIllIllIIllIIIlllIIl.write16bit(lllllllllllllIllIllIIllIIIllllII);
        this.writeVerifyTypeInfo(lllllllllllllIllIllIIllIIIlllIIl, lllllllllllllIllIllIIllIIIllllIl, lllllllllllllIllIllIIllIIIllIllI.localsTypes, lllllllllllllIllIllIIllIIIllIllI.numLocals);
        this.writeVerifyTypeInfo(lllllllllllllIllIllIIllIIIlllIIl, lllllllllllllIllIllIIllIIIllllIl, lllllllllllllIllIllIIllIIIllIllI.stackTypes, lllllllllllllIllIllIIllIIIllIllI.stackTop);
    }
    
    public StackMapTable toStackMap(final TypedBlock[] lllllllllllllIllIllIIllIlllIlIIl) {
        final StackMapTable.Writer lllllllllllllIllIllIIllIlllIlllI = new StackMapTable.Writer(32);
        final int lllllllllllllIllIllIIllIlllIllIl = lllllllllllllIllIllIIllIlllIlIIl.length;
        TypedBlock lllllllllllllIllIllIIllIlllIllII = lllllllllllllIllIllIIllIlllIlIIl[0];
        int lllllllllllllIllIllIIllIlllIlIll = lllllllllllllIllIllIIllIlllIllII.length;
        if (lllllllllllllIllIllIIllIlllIllII.incoming > 0) {
            lllllllllllllIllIllIIllIlllIlllI.sameFrame(0);
            --lllllllllllllIllIllIIllIlllIlIll;
        }
        for (int lllllllllllllIllIllIIllIllllIIIl = 1; lllllllllllllIllIllIIllIllllIIIl < lllllllllllllIllIllIIllIlllIllIl; ++lllllllllllllIllIllIIllIllllIIIl) {
            final TypedBlock lllllllllllllIllIllIIllIllllIIlI = lllllllllllllIllIllIIllIlllIlIIl[lllllllllllllIllIllIIllIllllIIIl];
            if (this.isTarget(lllllllllllllIllIllIIllIllllIIlI, lllllllllllllIllIllIIllIlllIlIIl[lllllllllllllIllIllIIllIllllIIIl - 1])) {
                lllllllllllllIllIllIIllIllllIIlI.resetNumLocals();
                final int lllllllllllllIllIllIIllIllllIIll = stackMapDiff(lllllllllllllIllIllIIllIlllIllII.numLocals, lllllllllllllIllIllIIllIlllIllII.localsTypes, lllllllllllllIllIllIIllIllllIIlI.numLocals, lllllllllllllIllIllIIllIllllIIlI.localsTypes);
                this.toStackMapBody(lllllllllllllIllIllIIllIlllIlllI, lllllllllllllIllIllIIllIllllIIlI, lllllllllllllIllIllIIllIllllIIll, lllllllllllllIllIllIIllIlllIlIll, lllllllllllllIllIllIIllIlllIllII);
                lllllllllllllIllIllIIllIlllIlIll = lllllllllllllIllIllIIllIllllIIlI.length - 1;
                lllllllllllllIllIllIIllIlllIllII = lllllllllllllIllIllIIllIllllIIlI;
            }
            else if (lllllllllllllIllIllIIllIllllIIlI.incoming == 0) {
                lllllllllllllIllIllIIllIlllIlllI.sameFrame(lllllllllllllIllIllIIllIlllIlIll);
                lllllllllllllIllIllIIllIlllIlIll = lllllllllllllIllIllIIllIllllIIlI.length - 1;
            }
            else {
                lllllllllllllIllIllIIllIlllIlIll += lllllllllllllIllIllIIllIllllIIlI.length;
            }
        }
        return lllllllllllllIllIllIIllIlllIlllI.toStackMapTable(this.cpool);
    }
    
    protected static int recordTypeData(final int lllllllllllllIllIllIIlllIllIIlIl, final TypeData[] lllllllllllllIllIllIIlllIllIIIII, final TypeData[] lllllllllllllIllIllIIlllIllIIIll) {
        int lllllllllllllIllIllIIlllIllIIIlI = -1;
        for (int lllllllllllllIllIllIIlllIllIIllI = 0; lllllllllllllIllIllIIlllIllIIllI < lllllllllllllIllIllIIlllIllIIlIl; ++lllllllllllllIllIllIIlllIllIIllI) {
            final TypeData lllllllllllllIllIllIIlllIllIIlll = validateTypeData(lllllllllllllIllIllIIlllIllIIIII, lllllllllllllIllIllIIlllIllIIlIl, lllllllllllllIllIllIIlllIllIIllI);
            lllllllllllllIllIllIIlllIllIIIll[lllllllllllllIllIllIIlllIllIIllI] = lllllllllllllIllIllIIlllIllIIlll.join();
            if (lllllllllllllIllIllIIlllIllIIlll != MapMaker.TOP) {
                lllllllllllllIllIllIIlllIllIIIlI = lllllllllllllIllIllIIlllIllIIllI + 1;
            }
        }
        return lllllllllllllIllIllIIlllIllIIIlI + 1;
    }
    
    private void mergeMap(final TypedBlock lllllllllllllIllIllIIllllIlIllll, final boolean lllllllllllllIllIllIIllllIlIlllI) throws BadBytecode {
        for (int lllllllllllllIllIllIIllllIllIIIl = this.localsTypes.length, lllllllllllllIllIllIIllllIllIllI = 0; lllllllllllllIllIllIIllllIllIllI < lllllllllllllIllIllIIllllIllIIIl; ++lllllllllllllIllIllIIllllIllIllI) {
            lllllllllllllIllIllIIllllIlIllll.localsTypes[lllllllllllllIllIllIIllllIllIllI] = this.merge(validateTypeData(this.localsTypes, lllllllllllllIllIllIIllllIllIIIl, lllllllllllllIllIllIIllllIllIllI), lllllllllllllIllIllIIllllIlIllll.localsTypes[lllllllllllllIllIllIIllllIllIllI]);
        }
        if (lllllllllllllIllIllIIllllIlIlllI) {
            for (int lllllllllllllIllIllIIllllIllIIIl = this.stackTop, lllllllllllllIllIllIIllllIllIlIl = 0; lllllllllllllIllIllIIllllIllIlIl < lllllllllllllIllIllIIllllIllIIIl; ++lllllllllllllIllIllIIllllIllIlIl) {
                lllllllllllllIllIllIIllllIlIllll.stackTypes[lllllllllllllIllIllIIllllIllIlIl] = this.merge(this.stackTypes[lllllllllllllIllIllIIllllIllIlIl], lllllllllllllIllIllIIllllIlIllll.stackTypes[lllllllllllllIllIllIIllllIllIlIl]);
            }
        }
    }
    
    private void make(final byte[] lllllllllllllIllIllIIlllllIlIIIl, final TypedBlock lllllllllllllIllIllIIlllllIlIIII) throws BadBytecode {
        copyTypeData(lllllllllllllIllIllIIlllllIlIIII.stackTop, lllllllllllllIllIllIIlllllIlIIII.stackTypes, this.stackTypes);
        this.stackTop = lllllllllllllIllIllIIlllllIlIIII.stackTop;
        copyTypeData(lllllllllllllIllIllIIlllllIlIIII.localsTypes.length, lllllllllllllIllIllIIlllllIlIIII.localsTypes, this.localsTypes);
        this.traceException(lllllllllllllIllIllIIlllllIlIIIl, lllllllllllllIllIllIIlllllIlIIII.toCatch);
        int lllllllllllllIllIllIIlllllIlIlII = lllllllllllllIllIllIIlllllIlIIII.position;
        final int lllllllllllllIllIllIIlllllIlIIll = lllllllllllllIllIllIIlllllIlIlII + lllllllllllllIllIllIIlllllIlIIII.length;
        while (lllllllllllllIllIllIIlllllIlIlII < lllllllllllllIllIllIIlllllIlIIll) {
            lllllllllllllIllIllIIlllllIlIlII += this.doOpcode(lllllllllllllIllIllIIlllllIlIlII, lllllllllllllIllIllIIlllllIlIIIl);
            this.traceException(lllllllllllllIllIllIIlllllIlIIIl, lllllllllllllIllIllIIlllllIlIIII.toCatch);
        }
        if (lllllllllllllIllIllIIlllllIlIIII.exit != null) {
            for (int lllllllllllllIllIllIIlllllIllIII = 0; lllllllllllllIllIllIIlllllIllIII < lllllllllllllIllIllIIlllllIlIIII.exit.length; ++lllllllllllllIllIllIIlllllIllIII) {
                final TypedBlock lllllllllllllIllIllIIlllllIllIIl = (TypedBlock)lllllllllllllIllIllIIlllllIlIIII.exit[lllllllllllllIllIllIIlllllIllIII];
                if (lllllllllllllIllIllIIlllllIllIIl.alreadySet()) {
                    this.mergeMap(lllllllllllllIllIllIIlllllIllIIl, true);
                }
                else {
                    this.recordStackMap(lllllllllllllIllIllIIlllllIllIIl);
                    final MapMaker lllllllllllllIllIllIIlllllIllIlI = new MapMaker(this);
                    lllllllllllllIllIllIIlllllIllIlI.make(lllllllllllllIllIllIIlllllIlIIIl, lllllllllllllIllIllIIlllllIllIIl);
                }
            }
        }
    }
    
    private void recordStackMap(final TypedBlock lllllllllllllIllIllIIllllIIlllll) throws BadBytecode {
        final TypeData[] lllllllllllllIllIllIIllllIIllllI = TypeData.make(this.stackTypes.length);
        final int lllllllllllllIllIllIIllllIIlllIl = this.stackTop;
        recordTypeData(lllllllllllllIllIllIIllllIIlllIl, this.stackTypes, lllllllllllllIllIllIIllllIIllllI);
        this.recordStackMap0(lllllllllllllIllIllIIllllIIlllll, lllllllllllllIllIllIIllllIIlllIl, lllllllllllllIllIllIIllllIIllllI);
    }
    
    private boolean isTarget(final TypedBlock lllllllllllllIllIllIIllIllIllIlI, final TypedBlock lllllllllllllIllIllIIllIllIlllII) {
        final int lllllllllllllIllIllIIllIllIllIll = lllllllllllllIllIllIIllIllIllIlI.incoming;
        return lllllllllllllIllIllIIllIllIllIll > 1 || (lllllllllllllIllIllIIllIllIllIll >= 1 && lllllllllllllIllIllIIllIllIlllII.stop);
    }
    
    private void writeVerifyTypeInfo(final StackMap.Writer lllllllllllllIllIllIIllIIIlIIlII, final ConstPool lllllllllllllIllIllIIllIIIlIIIll, final TypeData[] lllllllllllllIllIllIIllIIIlIIlll, final int lllllllllllllIllIllIIllIIIlIIIIl) {
        int lllllllllllllIllIllIIllIIIlIIlIl = 0;
        for (int lllllllllllllIllIllIIllIIIlIllIl = 0; lllllllllllllIllIllIIllIIIlIllIl < lllllllllllllIllIllIIllIIIlIIIIl; ++lllllllllllllIllIllIIllIIIlIllIl) {
            final TypeData lllllllllllllIllIllIIllIIIlIlllI = lllllllllllllIllIllIIllIIIlIIlll[lllllllllllllIllIllIIllIIIlIllIl];
            if (lllllllllllllIllIllIIllIIIlIlllI != null && lllllllllllllIllIllIIllIIIlIlllI.is2WordType()) {
                ++lllllllllllllIllIllIIllIIIlIIlIl;
                ++lllllllllllllIllIllIIllIIIlIllIl;
            }
        }
        lllllllllllllIllIllIIllIIIlIIlII.write16bit(lllllllllllllIllIllIIllIIIlIIIIl - lllllllllllllIllIllIIllIIIlIIlIl);
        for (int lllllllllllllIllIllIIllIIIlIlIll = 0; lllllllllllllIllIllIIllIIIlIlIll < lllllllllllllIllIllIIllIIIlIIIIl; ++lllllllllllllIllIllIIllIIIlIlIll) {
            final TypeData lllllllllllllIllIllIIllIIIlIllII = lllllllllllllIllIllIIllIIIlIIlll[lllllllllllllIllIllIIllIIIlIlIll];
            lllllllllllllIllIllIIllIIIlIIlII.writeVerifyTypeInfo(lllllllllllllIllIllIIllIIIlIllII.getTypeTag(), lllllllllllllIllIllIIllIIIlIllII.getTypeData(lllllllllllllIllIllIIllIIIlIIIll));
            if (lllllllllllllIllIllIIllIIIlIllII.is2WordType()) {
                ++lllllllllllllIllIllIIllIIIlIlIll;
            }
        }
    }
    
    private TypeData.ClassName toExceptionType(final int lllllllllllllIllIllIIllllIIIIlll) {
        String lllllllllllllIllIllIIllllIIIIllI = null;
        if (lllllllllllllIllIllIIllllIIIIlll == 0) {
            final String lllllllllllllIllIllIIllllIIIlIIl = "java.lang.Throwable";
        }
        else {
            lllllllllllllIllIllIIllllIIIIllI = this.cpool.getClassInfo(lllllllllllllIllIllIIllllIIIIlll);
        }
        return new TypeData.ClassName(lllllllllllllIllIllIIllllIIIIllI);
    }
    
    public StackMap toStackMap2(final ConstPool lllllllllllllIllIllIIllIIlIIllIl, final TypedBlock[] lllllllllllllIllIllIIllIIlIlIlII) {
        final StackMap.Writer lllllllllllllIllIllIIllIIlIlIIll = new StackMap.Writer();
        final int lllllllllllllIllIllIIllIIlIlIIlI = lllllllllllllIllIllIIllIIlIlIlII.length;
        final boolean[] lllllllllllllIllIllIIllIIlIlIIIl = new boolean[lllllllllllllIllIllIIllIIlIlIIlI];
        TypedBlock lllllllllllllIllIllIIllIIlIlIIII = lllllllllllllIllIllIIllIIlIlIlII[0];
        lllllllllllllIllIllIIllIIlIlIIIl[0] = (lllllllllllllIllIllIIllIIlIlIIII.incoming > 0);
        int lllllllllllllIllIllIIllIIlIIllll = lllllllllllllIllIllIIllIIlIlIIIl[0] ? 1 : 0;
        for (int lllllllllllllIllIllIIllIIlIllIII = 1; lllllllllllllIllIllIIllIIlIllIII < lllllllllllllIllIllIIllIIlIlIIlI; ++lllllllllllllIllIllIIllIIlIllIII) {
            final TypedBlock lllllllllllllIllIllIIllIIlIllIIl = lllllllllllllIllIllIIllIIlIlIlII[lllllllllllllIllIllIIllIIlIllIII];
            final boolean[] array = lllllllllllllIllIllIIllIIlIlIIIl;
            final int n = lllllllllllllIllIllIIllIIlIllIII;
            final boolean target = this.isTarget(lllllllllllllIllIllIIllIIlIllIIl, lllllllllllllIllIllIIllIIlIlIlII[lllllllllllllIllIllIIllIIlIllIII - 1]);
            array[n] = target;
            if (target) {
                lllllllllllllIllIllIIllIIlIllIIl.resetNumLocals();
                lllllllllllllIllIllIIllIIlIlIIII = lllllllllllllIllIllIIllIIlIllIIl;
                ++lllllllllllllIllIllIIllIIlIIllll;
            }
        }
        if (lllllllllllllIllIllIIllIIlIIllll == 0) {
            return null;
        }
        lllllllllllllIllIllIIllIIlIlIIll.write16bit(lllllllllllllIllIllIIllIIlIIllll);
        for (int lllllllllllllIllIllIIllIIlIlIlll = 0; lllllllllllllIllIllIIllIIlIlIlll < lllllllllllllIllIllIIllIIlIlIIlI; ++lllllllllllllIllIllIIllIIlIlIlll) {
            if (lllllllllllllIllIllIIllIIlIlIIIl[lllllllllllllIllIllIIllIIlIlIlll]) {
                this.writeStackFrame(lllllllllllllIllIllIIllIIlIlIIll, lllllllllllllIllIllIIllIIlIIllIl, lllllllllllllIllIllIIllIIlIlIlII[lllllllllllllIllIllIIllIIlIlIlll].position, lllllllllllllIllIllIIllIIlIlIlII[lllllllllllllIllIllIIllIIlIlIlll]);
            }
        }
        return lllllllllllllIllIllIIllIIlIlIIll.toStackMap(lllllllllllllIllIllIIllIIlIIllIl);
    }
    
    private TypeData merge(final TypeData lllllllllllllIllIllIIllllIlIIllI, final TypeData lllllllllllllIllIllIIllllIlIIlIl) throws BadBytecode {
        if (lllllllllllllIllIllIIllllIlIIllI == lllllllllllllIllIllIIllllIlIIlIl) {
            return lllllllllllllIllIllIIllllIlIIlIl;
        }
        if (lllllllllllllIllIllIIllllIlIIlIl instanceof TypeData.ClassName || lllllllllllllIllIllIIllllIlIIlIl instanceof TypeData.BasicType) {
            return lllllllllllllIllIllIIllllIlIIlIl;
        }
        if (lllllllllllllIllIllIIllllIlIIlIl instanceof TypeData.AbsTypeVar) {
            ((TypeData.AbsTypeVar)lllllllllllllIllIllIIllllIlIIlIl).merge(lllllllllllllIllIllIIllllIlIIllI);
            return lllllllllllllIllIllIIllllIlIIlIl;
        }
        throw new RuntimeException("fatal: this should never happen");
    }
    
    private static int stackMapDiff(final int lllllllllllllIllIllIIllIlIIIlIlI, final TypeData[] lllllllllllllIllIllIIllIlIIIIIll, final int lllllllllllllIllIllIIllIlIIIIIlI, final TypeData[] lllllllllllllIllIllIIllIlIIIIlll) {
        final int lllllllllllllIllIllIIllIlIIIIllI = lllllllllllllIllIllIIllIlIIIIIlI - lllllllllllllIllIllIIllIlIIIlIlI;
        int lllllllllllllIllIllIIllIlIIIIlIl = 0;
        if (lllllllllllllIllIllIIllIlIIIIllI > 0) {
            final int lllllllllllllIllIllIIllIlIIIlIll = lllllllllllllIllIllIIllIlIIIlIlI;
        }
        else {
            lllllllllllllIllIllIIllIlIIIIlIl = lllllllllllllIllIllIIllIlIIIIIlI;
        }
        if (!stackMapEq(lllllllllllllIllIllIIllIlIIIIIll, lllllllllllllIllIllIIllIlIIIIlll, lllllllllllllIllIllIIllIlIIIIlIl)) {
            return -100;
        }
        if (lllllllllllllIllIllIIllIlIIIIllI > 0) {
            return diffSize(lllllllllllllIllIllIIllIlIIIIlll, lllllllllllllIllIllIIllIlIIIIlIl, lllllllllllllIllIllIIllIlIIIIIlI);
        }
        return -diffSize(lllllllllllllIllIllIIllIlIIIIIll, lllllllllllllIllIllIIllIlIIIIlIl, lllllllllllllIllIllIIllIlIIIlIlI);
    }
    
    public static StackMap make2(final ClassPool lllllllllllllIllIllIlIIIIIIIIllI, final MethodInfo lllllllllllllIllIllIlIIIIIIIlIlI) throws BadBytecode {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getCodeAttribute:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;
        //     4: astore_2        /* lllllllllllllIllIllIlIIIIIIIIlII */
        //     5: aload_2         /* lllllllllllllIllIllIlIIIIIIIlIIl */
        //     6: ifnonnull       11
        //     9: aconst_null    
        //    10: areturn        
        //    11: aload_1         /* lllllllllllllIllIllIlIIIIIIIIlIl */
        //    12: aload_2         /* lllllllllllllIllIllIlIIIIIIIlIIl */
        //    13: iconst_1       
        //    14: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock.makeBlocks:(Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;Z)[Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock;
        //    17: astore_3        /* lllllllllllllIllIllIlIIIIIIIlllI */
        //    18: goto            25
        //    21: astore          lllllllllllllIllIllIlIIIIIIIllIl
        //    23: aconst_null    
        //    24: areturn        
        //    25: aload_3         /* lllllllllllllIllIllIlIIIIIIIlIII */
        //    26: ifnonnull       31
        //    29: aconst_null    
        //    30: areturn        
        //    31: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker;
        //    34: dup            
        //    35: aload_0         /* lllllllllllllIllIllIlIIIIIIIlIll */
        //    36: aload_1         /* lllllllllllllIllIllIlIIIIIIIIlIl */
        //    37: aload_2         /* lllllllllllllIllIllIlIIIIIIIlIIl */
        //    38: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker.<init>:(Lcom/viaversion/viaversion/libs/javassist/ClassPool;Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;)V
        //    41: astore          lllllllllllllIllIllIlIIIIIIIIlll
        //    43: aload           lllllllllllllIllIllIlIIIIIIIIlll
        //    45: aload_3         /* lllllllllllllIllIllIlIIIIIIIlIII */
        //    46: aload_2         /* lllllllllllllIllIllIlIIIIIIIlIIl */
        //    47: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute.getCode:()[B
        //    50: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker.make:([Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock;[B)V
        //    53: goto            69
        //    56: astore          lllllllllllllIllIllIlIIIIIIIllII
        //    58: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        //    61: dup            
        //    62: aload_1         /* lllllllllllllIllIllIlIIIIIIIIlIl */
        //    63: aload           lllllllllllllIllIllIlIIIIIIIllII
        //    65: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/BadBytecode.<init>:(Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;Ljava/lang/Throwable;)V
        //    68: athrow         
        //    69: aload           lllllllllllllIllIllIlIIIIIIIIlll
        //    71: aload_1         /* lllllllllllllIllIllIlIIIIIIIIlIl */
        //    72: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getConstPool:()Lcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;
        //    75: aload_3         /* lllllllllllllIllIllIlIIIIIIIlIII */
        //    76: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker.toStackMap2:(Lcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;[Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock;)Lcom/viaversion/viaversion/libs/javassist/bytecode/StackMap;
        //    79: areturn        
        //    Exceptions:
        //  throws com.viaversion.viaversion.libs.javassist.bytecode.BadBytecode
        //    StackMapTable: 00 06 FC 00 0B 07 01 B1 49 07 00 1F FC 00 03 07 00 A9 05 FF 00 18 00 05 07 01 D5 07 01 A4 07 01 B1 07 00 A9 07 00 02 00 01 07 00 24 0C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                                               
        //  -----  -----  -----  -----  -----------------------------------------------------------------------------------
        //  11     18     21     25     Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/BasicBlock$JsrBytecode;
        //  43     53     56     69     Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void recordStackMap(final TypedBlock lllllllllllllIllIllIIllllIIIllll, final int lllllllllllllIllIllIIllllIIlIIlI) throws BadBytecode {
        final TypeData[] lllllllllllllIllIllIIllllIIlIIIl = TypeData.make(this.stackTypes.length);
        lllllllllllllIllIllIIllllIIlIIIl[0] = this.toExceptionType(lllllllllllllIllIllIIllllIIlIIlI).join();
        this.recordStackMap0(lllllllllllllIllIllIIllllIIIllll, 1, lllllllllllllIllIllIIllllIIlIIIl);
    }
    
    protected static void copyTypeData(final int lllllllllllllIllIllIIlllIlIlIIll, final TypeData[] lllllllllllllIllIllIIlllIlIlIlIl, final TypeData[] lllllllllllllIllIllIIlllIlIlIIIl) {
        for (int lllllllllllllIllIllIIlllIlIlIlll = 0; lllllllllllllIllIllIIlllIlIlIlll < lllllllllllllIllIllIIlllIlIlIIll; ++lllllllllllllIllIllIIlllIlIlIlll) {
            lllllllllllllIllIllIIlllIlIlIIIl[lllllllllllllIllIllIIlllIlIlIlll] = lllllllllllllIllIllIIlllIlIlIlIl[lllllllllllllIllIllIIlllIlIlIlll];
        }
    }
    
    private static int diffSize(final TypeData[] lllllllllllllIllIllIIllIIllIllII, int lllllllllllllIllIllIIllIIllIlIll, final int lllllllllllllIllIllIIllIIllIIllI) {
        int lllllllllllllIllIllIIllIIllIlIIl = 0;
        while (lllllllllllllIllIllIIllIIllIlIll < lllllllllllllIllIllIIllIIllIIllI) {
            final TypeData lllllllllllllIllIllIIllIIllIllIl = lllllllllllllIllIllIIllIIllIllII[lllllllllllllIllIllIIllIIllIlIll++];
            ++lllllllllllllIllIllIIllIIllIlIIl;
            if (lllllllllllllIllIllIIllIIllIllIl.is2WordType()) {
                ++lllllllllllllIllIllIIllIIllIlIll;
            }
        }
        return lllllllllllllIllIllIIllIIllIlIIl;
    }
    
    private int[] fillStackMap(final int lllllllllllllIllIllIIllIlIIllIll, final int lllllllllllllIllIllIIllIlIlIIIll, final int[] lllllllllllllIllIllIIllIlIIllIIl, final TypeData[] lllllllllllllIllIllIIllIlIIllIII) {
        final int lllllllllllllIllIllIIllIlIlIIIII = diffSize(lllllllllllllIllIllIIllIlIIllIII, lllllllllllllIllIllIIllIlIlIIIll, lllllllllllllIllIllIIllIlIlIIIll + lllllllllllllIllIllIIllIlIIllIll);
        final ConstPool lllllllllllllIllIllIIllIlIIlllll = this.cpool;
        final int[] lllllllllllllIllIllIIllIlIIllllI = new int[lllllllllllllIllIllIIllIlIlIIIII];
        int lllllllllllllIllIllIIllIlIIlllIl = 0;
        for (int lllllllllllllIllIllIIllIlIlIIllI = 0; lllllllllllllIllIllIIllIlIlIIllI < lllllllllllllIllIllIIllIlIIllIll; ++lllllllllllllIllIllIIllIlIlIIllI) {
            final TypeData lllllllllllllIllIllIIllIlIlIIlll = lllllllllllllIllIllIIllIlIIllIII[lllllllllllllIllIllIIllIlIlIIIll + lllllllllllllIllIllIIllIlIlIIllI];
            lllllllllllllIllIllIIllIlIIllllI[lllllllllllllIllIllIIllIlIIlllIl] = lllllllllllllIllIllIIllIlIlIIlll.getTypeTag();
            lllllllllllllIllIllIIllIlIIllIIl[lllllllllllllIllIllIIllIlIIlllIl] = lllllllllllllIllIllIIllIlIlIIlll.getTypeData(lllllllllllllIllIllIIllIlIIlllll);
            if (lllllllllllllIllIllIIllIlIlIIlll.is2WordType()) {
                ++lllllllllllllIllIllIIllIlIlIIllI;
            }
            ++lllllllllllllIllIllIIllIlIIlllIl;
        }
        return lllllllllllllIllIllIIllIlIIllllI;
    }
    
    private void fixTypes(final byte[] lllllllllllllIllIllIIlllIIIIlIlI, final TypedBlock[] lllllllllllllIllIllIIlllIIIIIlII) throws BadBytecode, NotFoundException {
        final List<TypeData> lllllllllllllIllIllIIlllIIIIlIII = new ArrayList<TypeData>();
        final int lllllllllllllIllIllIIlllIIIIIlll = lllllllllllllIllIllIIlllIIIIIlII.length;
        int lllllllllllllIllIllIIlllIIIIIllI = 0;
        for (final TypedBlock lllllllllllllIllIllIIlllIIIIllIl : lllllllllllllIllIllIIlllIIIIIlII) {
            if (lllllllllllllIllIllIIlllIIIIllIl.alreadySet()) {
                for (int lllllllllllllIllIllIIlllIIIIlllI = lllllllllllllIllIllIIlllIIIIllIl.localsTypes.length, lllllllllllllIllIllIIlllIIIlIIII = 0; lllllllllllllIllIllIIlllIIIlIIII < lllllllllllllIllIllIIlllIIIIlllI; ++lllllllllllllIllIllIIlllIIIlIIII) {
                    lllllllllllllIllIllIIlllIIIIIllI = lllllllllllllIllIllIIlllIIIIllIl.localsTypes[lllllllllllllIllIllIIlllIIIlIIII].dfs(lllllllllllllIllIllIIlllIIIIlIII, lllllllllllllIllIllIIlllIIIIIllI, this.classPool);
                }
                for (int lllllllllllllIllIllIIlllIIIIlllI = lllllllllllllIllIllIIlllIIIIllIl.stackTop, lllllllllllllIllIllIIlllIIIIllll = 0; lllllllllllllIllIllIIlllIIIIllll < lllllllllllllIllIllIIlllIIIIlllI; ++lllllllllllllIllIllIIlllIIIIllll) {
                    lllllllllllllIllIllIIlllIIIIIllI = lllllllllllllIllIllIIlllIIIIllIl.stackTypes[lllllllllllllIllIllIIlllIIIIllll].dfs(lllllllllllllIllIllIIlllIIIIlIII, lllllllllllllIllIllIIlllIIIIIllI, this.classPool);
                }
            }
        }
    }
    
    protected MapMaker(final MapMaker lllllllllllllIllIllIIllllllIllll) {
        super(lllllllllllllIllIllIIllllllIllll);
    }
    
    private void toStackMapBody(final StackMapTable.Writer lllllllllllllIllIllIIllIlIllllII, final TypedBlock lllllllllllllIllIllIIllIlIlllIll, final int lllllllllllllIllIllIIllIllIIIlIl, final int lllllllllllllIllIllIIllIllIIIlII, final TypedBlock lllllllllllllIllIllIIllIlIlllIII) {
        final int lllllllllllllIllIllIIllIllIIIIlI = lllllllllllllIllIllIIllIlIlllIll.stackTop;
        if (lllllllllllllIllIllIIllIllIIIIlI == 0) {
            if (lllllllllllllIllIllIIllIllIIIlIl == 0) {
                lllllllllllllIllIllIIllIlIllllII.sameFrame(lllllllllllllIllIllIIllIllIIIlII);
                return;
            }
            if (0 > lllllllllllllIllIllIIllIllIIIlIl && lllllllllllllIllIllIIllIllIIIlIl >= -3) {
                lllllllllllllIllIllIIllIlIllllII.chopFrame(lllllllllllllIllIllIIllIllIIIlII, -lllllllllllllIllIllIIllIllIIIlIl);
                return;
            }
            if (0 < lllllllllllllIllIllIIllIllIIIlIl && lllllllllllllIllIllIIllIllIIIlIl <= 3) {
                final int[] lllllllllllllIllIllIIllIllIIllII = new int[lllllllllllllIllIllIIllIllIIIlIl];
                final int[] lllllllllllllIllIllIIllIllIIlIll = this.fillStackMap(lllllllllllllIllIllIIllIlIlllIll.numLocals - lllllllllllllIllIllIIllIlIlllIII.numLocals, lllllllllllllIllIllIIllIlIlllIII.numLocals, lllllllllllllIllIllIIllIllIIllII, lllllllllllllIllIllIIllIlIlllIll.localsTypes);
                lllllllllllllIllIllIIllIlIllllII.appendFrame(lllllllllllllIllIllIIllIllIIIlII, lllllllllllllIllIllIIllIllIIlIll, lllllllllllllIllIllIIllIllIIllII);
                return;
            }
        }
        else {
            if (lllllllllllllIllIllIIllIllIIIIlI == 1 && lllllllllllllIllIllIIllIllIIIlIl == 0) {
                final TypeData lllllllllllllIllIllIIllIllIIlIlI = lllllllllllllIllIllIIllIlIlllIll.stackTypes[0];
                lllllllllllllIllIllIIllIlIllllII.sameLocals(lllllllllllllIllIllIIllIllIIIlII, lllllllllllllIllIllIIllIllIIlIlI.getTypeTag(), lllllllllllllIllIllIIllIllIIlIlI.getTypeData(this.cpool));
                return;
            }
            if (lllllllllllllIllIllIIllIllIIIIlI == 2 && lllllllllllllIllIllIIllIllIIIlIl == 0) {
                final TypeData lllllllllllllIllIllIIllIllIIlIIl = lllllllllllllIllIllIIllIlIlllIll.stackTypes[0];
                if (lllllllllllllIllIllIIllIllIIlIIl.is2WordType()) {
                    lllllllllllllIllIllIIllIlIllllII.sameLocals(lllllllllllllIllIllIIllIllIIIlII, lllllllllllllIllIllIIllIllIIlIIl.getTypeTag(), lllllllllllllIllIllIIllIllIIlIIl.getTypeData(this.cpool));
                    return;
                }
            }
        }
        final int[] lllllllllllllIllIllIIllIllIIIIIl = new int[lllllllllllllIllIllIIllIllIIIIlI];
        final int[] lllllllllllllIllIllIIllIllIIIIII = this.fillStackMap(lllllllllllllIllIllIIllIllIIIIlI, 0, lllllllllllllIllIllIIllIllIIIIIl, lllllllllllllIllIllIIllIlIlllIll.stackTypes);
        final int[] lllllllllllllIllIllIIllIlIllllll = new int[lllllllllllllIllIllIIllIlIlllIll.numLocals];
        final int[] lllllllllllllIllIllIIllIlIlllllI = this.fillStackMap(lllllllllllllIllIllIIllIlIlllIll.numLocals, 0, lllllllllllllIllIllIIllIlIllllll, lllllllllllllIllIllIIllIlIlllIll.localsTypes);
        lllllllllllllIllIllIIllIlIllllII.fullFrame(lllllllllllllIllIllIIllIllIIIlII, lllllllllllllIllIllIIllIlIlllllI, lllllllllllllIllIllIIllIlIllllll, lllllllllllllIllIllIIllIllIIIIII, lllllllllllllIllIllIIllIllIIIIIl);
    }
    
    private void fixDeadcode(final byte[] lllllllllllllIllIllIIlllIIIllllI, final TypedBlock lllllllllllllIllIllIIlllIIIlllIl) throws BadBytecode {
        final int lllllllllllllIllIllIIlllIIlIIIIl = lllllllllllllIllIllIIlllIIIlllIl.position;
        final int lllllllllllllIllIllIIlllIIlIIIII = lllllllllllllIllIllIIlllIIIlllIl.length - 3;
        if (lllllllllllllIllIllIIlllIIlIIIII < 0) {
            if (lllllllllllllIllIllIIlllIIlIIIII == -1) {
                lllllllllllllIllIllIIlllIIIllllI[lllllllllllllIllIllIIlllIIlIIIIl] = 0;
            }
            lllllllllllllIllIllIIlllIIIllllI[lllllllllllllIllIllIIlllIIlIIIIl + lllllllllllllIllIllIIlllIIIlllIl.length - 1] = -65;
            lllllllllllllIllIllIIlllIIIlllIl.incoming = 1;
            this.recordStackMap(lllllllllllllIllIllIIlllIIIlllIl, 0);
            return;
        }
        lllllllllllllIllIllIIlllIIIlllIl.incoming = 0;
        for (int lllllllllllllIllIllIIlllIIlIIlIl = 0; lllllllllllllIllIllIIlllIIlIIlIl < lllllllllllllIllIllIIlllIIlIIIII; ++lllllllllllllIllIllIIlllIIlIIlIl) {
            lllllllllllllIllIllIIlllIIIllllI[lllllllllllllIllIllIIlllIIlIIIIl + lllllllllllllIllIllIIlllIIlIIlIl] = 0;
        }
        lllllllllllllIllIllIIlllIIIllllI[lllllllllllllIllIllIIlllIIlIIIIl + lllllllllllllIllIllIIlllIIlIIIII] = -89;
        ByteArray.write16bit(-lllllllllllllIllIllIIlllIIlIIIII, lllllllllllllIllIllIIlllIIIllllI, lllllllllllllIllIllIIlllIIlIIIIl + lllllllllllllIllIllIIlllIIlIIIII + 1);
    }
    
    public static StackMapTable make(final ClassPool lllllllllllllIllIllIlIIIIIIllIlI, final MethodInfo lllllllllllllIllIllIlIIIIIIllllI) throws BadBytecode {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getCodeAttribute:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;
        //     4: astore_2        /* lllllllllllllIllIllIlIIIIIIllIII */
        //     5: aload_2         /* lllllllllllllIllIllIlIIIIIIlllIl */
        //     6: ifnonnull       11
        //     9: aconst_null    
        //    10: areturn        
        //    11: aload_1         /* lllllllllllllIllIllIlIIIIIIllIIl */
        //    12: aload_2         /* lllllllllllllIllIllIlIIIIIIlllIl */
        //    13: iconst_1       
        //    14: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock.makeBlocks:(Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;Z)[Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock;
        //    17: astore_3        /* lllllllllllllIllIllIlIIIIIlIIIlI */
        //    18: goto            25
        //    21: astore          lllllllllllllIllIllIlIIIIIlIIIIl
        //    23: aconst_null    
        //    24: areturn        
        //    25: aload_3         /* lllllllllllllIllIllIlIIIIIIlllII */
        //    26: ifnonnull       31
        //    29: aconst_null    
        //    30: areturn        
        //    31: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker;
        //    34: dup            
        //    35: aload_0         /* lllllllllllllIllIllIlIIIIIIlllll */
        //    36: aload_1         /* lllllllllllllIllIllIlIIIIIIllIIl */
        //    37: aload_2         /* lllllllllllllIllIllIlIIIIIIlllIl */
        //    38: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker.<init>:(Lcom/viaversion/viaversion/libs/javassist/ClassPool;Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;)V
        //    41: astore          lllllllllllllIllIllIlIIIIIIllIll
        //    43: aload           lllllllllllllIllIllIlIIIIIIllIll
        //    45: aload_3         /* lllllllllllllIllIllIlIIIIIIlllII */
        //    46: aload_2         /* lllllllllllllIllIllIlIIIIIIlllIl */
        //    47: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute.getCode:()[B
        //    50: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker.make:([Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock;[B)V
        //    53: goto            69
        //    56: astore          lllllllllllllIllIllIlIIIIIlIIIII
        //    58: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        //    61: dup            
        //    62: aload_1         /* lllllllllllllIllIllIlIIIIIIllIIl */
        //    63: aload           lllllllllllllIllIllIlIIIIIlIIIII
        //    65: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/BadBytecode.<init>:(Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;Ljava/lang/Throwable;)V
        //    68: athrow         
        //    69: aload           lllllllllllllIllIllIlIIIIIIllIll
        //    71: aload_3         /* lllllllllllllIllIllIlIIIIIIlllII */
        //    72: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/stackmap/MapMaker.toStackMap:([Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/TypedBlock;)Lcom/viaversion/viaversion/libs/javassist/bytecode/StackMapTable;
        //    75: areturn        
        //    Exceptions:
        //  throws com.viaversion.viaversion.libs.javassist.bytecode.BadBytecode
        //    StackMapTable: 00 06 FC 00 0B 07 01 B1 49 07 00 1F FC 00 03 07 00 A9 05 FF 00 18 00 05 07 01 D5 07 01 A4 07 01 B1 07 00 A9 07 00 02 00 01 07 00 24 0C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                                               
        //  -----  -----  -----  -----  -----------------------------------------------------------------------------------
        //  11     18     21     25     Lcom/viaversion/viaversion/libs/javassist/bytecode/stackmap/BasicBlock$JsrBytecode;
        //  43     53     56     69     Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static TypeData validateTypeData(final TypeData[] lllllllllllllIllIllIIlllIlIIIlll, final int lllllllllllllIllIllIIlllIlIIIllI, final int lllllllllllllIllIllIIlllIlIIIlIl) {
        final TypeData lllllllllllllIllIllIIlllIlIIlIII = lllllllllllllIllIllIIlllIlIIIlll[lllllllllllllIllIllIIlllIlIIIlIl];
        if (lllllllllllllIllIllIIlllIlIIlIII.is2WordType() && lllllllllllllIllIllIIlllIlIIIlIl + 1 < lllllllllllllIllIllIIlllIlIIIllI && lllllllllllllIllIllIIlllIlIIIlll[lllllllllllllIllIllIIlllIlIIIlIl + 1] != MapMaker.TOP) {
            return MapMaker.TOP;
        }
        return lllllllllllllIllIllIIlllIlIIlIII;
    }
    
    private void traceException(final byte[] lllllllllllllIllIllIIllllIllllll, BasicBlock.Catch lllllllllllllIllIllIIllllIlllllI) throws BadBytecode {
        while (lllllllllllllIllIllIIllllIlllllI != null) {
            final TypedBlock lllllllllllllIllIllIIlllllIIIlII = (TypedBlock)lllllllllllllIllIllIIllllIlllllI.body;
            if (lllllllllllllIllIllIIlllllIIIlII.alreadySet()) {
                this.mergeMap(lllllllllllllIllIllIIlllllIIIlII, false);
                if (lllllllllllllIllIllIIlllllIIIlII.stackTop < 1) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("bad catch clause: ").append(lllllllllllllIllIllIIllllIlllllI.typeIndex)));
                }
                lllllllllllllIllIllIIlllllIIIlII.stackTypes[0] = this.merge(this.toExceptionType(lllllllllllllIllIllIIllllIlllllI.typeIndex), lllllllllllllIllIllIIlllllIIIlII.stackTypes[0]);
            }
            else {
                this.recordStackMap(lllllllllllllIllIllIIlllllIIIlII, lllllllllllllIllIllIIllllIlllllI.typeIndex);
                final MapMaker lllllllllllllIllIllIIlllllIIIlIl = new MapMaker(this);
                lllllllllllllIllIllIIlllllIIIlIl.make(lllllllllllllIllIllIIllllIllllll, lllllllllllllIllIllIIlllllIIIlII);
            }
            lllllllllllllIllIllIIllllIlllllI = lllllllllllllIllIllIIllllIlllllI.next;
        }
    }
    
    private void recordStackMap0(final TypedBlock lllllllllllllIllIllIIlllIlllIIll, final int lllllllllllllIllIllIIlllIlllIIlI, final TypeData[] lllllllllllllIllIllIIlllIllllIII) throws BadBytecode {
        final int lllllllllllllIllIllIIlllIlllIlll = this.localsTypes.length;
        final TypeData[] lllllllllllllIllIllIIlllIlllIllI = TypeData.make(lllllllllllllIllIllIIlllIlllIlll);
        final int lllllllllllllIllIllIIlllIlllIlIl = recordTypeData(lllllllllllllIllIllIIlllIlllIlll, this.localsTypes, lllllllllllllIllIllIIlllIlllIllI);
        lllllllllllllIllIllIIlllIlllIIll.setStackMap(lllllllllllllIllIllIIlllIlllIIlI, lllllllllllllIllIllIIlllIllllIII, lllllllllllllIllIllIIlllIlllIlIl, lllllllllllllIllIllIIlllIlllIllI);
    }
    
    public MapMaker(final ClassPool lllllllllllllIllIllIIlllllllIlll, final MethodInfo lllllllllllllIllIllIIlllllllIllI, final CodeAttribute lllllllllllllIllIllIIllllllllIIl) {
        super(lllllllllllllIllIllIIlllllllIlll, lllllllllllllIllIllIIlllllllIllI.getConstPool(), lllllllllllllIllIllIIllllllllIIl.getMaxStack(), lllllllllllllIllIllIIllllllllIIl.getMaxLocals(), TypedBlock.getRetType(lllllllllllllIllIllIIlllllllIllI.getDescriptor()));
    }
    
    private void findDeadCatchers(final byte[] lllllllllllllIllIllIIlllIIllIllI, final TypedBlock[] lllllllllllllIllIllIIlllIIllIIIl) throws BadBytecode {
        for (final TypedBlock lllllllllllllIllIllIIlllIIlllIIl : lllllllllllllIllIllIIlllIIllIIIl) {
            if (!lllllllllllllIllIllIIlllIIlllIIl.alreadySet()) {
                this.fixDeadcode(lllllllllllllIllIllIIlllIIllIllI, lllllllllllllIllIllIIlllIIlllIIl);
                final BasicBlock.Catch lllllllllllllIllIllIIlllIIlllIlI = lllllllllllllIllIllIIlllIIlllIIl.toCatch;
                if (lllllllllllllIllIllIIlllIIlllIlI != null) {
                    final TypedBlock lllllllllllllIllIllIIlllIIlllIll = (TypedBlock)lllllllllllllIllIllIIlllIIlllIlI.body;
                    if (!lllllllllllllIllIllIIlllIIlllIll.alreadySet()) {
                        this.recordStackMap(lllllllllllllIllIllIIlllIIlllIll, lllllllllllllIllIllIIlllIIlllIlI.typeIndex);
                        this.fixDeadcode(lllllllllllllIllIllIIlllIIllIllI, lllllllllllllIllIllIIlllIIlllIll);
                        lllllllllllllIllIllIIlllIIlllIll.incoming = 1;
                    }
                }
            }
        }
    }
    
    private static boolean stackMapEq(final TypeData[] lllllllllllllIllIllIIllIIllllIIl, final TypeData[] lllllllllllllIllIllIIllIIllllIII, final int lllllllllllllIllIllIIllIIlllIlII) {
        for (int lllllllllllllIllIllIIllIIllllIlI = 0; lllllllllllllIllIllIIllIIllllIlI < lllllllllllllIllIllIIllIIlllIlII; ++lllllllllllllIllIllIIllIIllllIlI) {
            if (!lllllllllllllIllIllIIllIIllllIIl[lllllllllllllIllIllIIllIIllllIlI].eq(lllllllllllllIllIllIIllIIllllIII[lllllllllllllIllIllIIllIIllllIlI])) {
                return false;
            }
        }
        return true;
    }
}
