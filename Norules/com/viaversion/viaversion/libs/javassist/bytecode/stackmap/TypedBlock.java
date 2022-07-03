package com.viaversion.viaversion.libs.javassist.bytecode.stackmap;

import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class TypedBlock extends BasicBlock
{
    public /* synthetic */ TypeData[] localsTypes;
    public /* synthetic */ int numLocals;
    public /* synthetic */ TypeData[] stackTypes;
    public /* synthetic */ int stackTop;
    
    public static TypedBlock[] makeBlocks(final MethodInfo lllllllllllllIIIlllIIlIIIlIlIIlI, final CodeAttribute lllllllllllllIIIlllIIlIIIlIlIIIl, final boolean lllllllllllllIIIlllIIlIIIlIlIllI) throws BadBytecode {
        final TypedBlock[] lllllllllllllIIIlllIIlIIIlIlIlIl = (TypedBlock[])new Maker().make(lllllllllllllIIIlllIIlIIIlIlIIlI);
        if (lllllllllllllIIIlllIIlIIIlIlIllI && lllllllllllllIIIlllIIlIIIlIlIlIl.length < 2 && (lllllllllllllIIIlllIIlIIIlIlIlIl.length == 0 || lllllllllllllIIIlllIIlIIIlIlIlIl[0].incoming == 0)) {
            return null;
        }
        final ConstPool lllllllllllllIIIlllIIlIIIlIlIlII = lllllllllllllIIIlllIIlIIIlIlIIlI.getConstPool();
        final boolean lllllllllllllIIIlllIIlIIIlIlIIll = (lllllllllllllIIIlllIIlIIIlIlIIlI.getAccessFlags() & 0x8) != 0x0;
        lllllllllllllIIIlllIIlIIIlIlIlIl[0].initFirstBlock(lllllllllllllIIIlllIIlIIIlIlIIIl.getMaxStack(), lllllllllllllIIIlllIIlIIIlIlIIIl.getMaxLocals(), lllllllllllllIIIlllIIlIIIlIlIlII.getClassName(), lllllllllllllIIIlllIIlIIIlIlIIlI.getDescriptor(), lllllllllllllIIIlllIIlIIIlIlIIll, lllllllllllllIIIlllIIlIIIlIlIIlI.isConstructor());
        return lllllllllllllIIIlllIIlIIIlIlIlIl;
    }
    
    @Override
    protected void toString2(final StringBuffer lllllllllllllIIIlllIIlIIIlIIIIll) {
        super.toString2(lllllllllllllIIIlllIIlIIIlIIIIll);
        lllllllllllllIIIlllIIlIIIlIIIIll.append(",\n stack={");
        this.printTypes(lllllllllllllIIIlllIIlIIIlIIIIll, this.stackTop, this.stackTypes);
        lllllllllllllIIIlllIIlIIIlIIIIll.append("}, locals={");
        this.printTypes(lllllllllllllIIIlllIIlIIIlIIIIll, this.numLocals, this.localsTypes);
        lllllllllllllIIIlllIIlIIIlIIIIll.append('}');
    }
    
    public void setStackMap(final int lllllllllllllIIIlllIIlIIIIlIIlll, final TypeData[] lllllllllllllIIIlllIIlIIIIlIIllI, final int lllllllllllllIIIlllIIlIIIIlIIIII, final TypeData[] lllllllllllllIIIlllIIlIIIIIlllll) throws BadBytecode {
        this.stackTop = lllllllllllllIIIlllIIlIIIIlIIlll;
        this.stackTypes = lllllllllllllIIIlllIIlIIIIlIIllI;
        this.numLocals = lllllllllllllIIIlllIIlIIIIlIIIII;
        this.localsTypes = lllllllllllllIIIlllIIlIIIIIlllll;
    }
    
    private static int descToTag(final String lllllllllllllIIIlllIIIlllllIllIl, int lllllllllllllIIIlllIIIlllllIIlIl, final int lllllllllllllIIIlllIIIlllllIIlII, final TypeData[] lllllllllllllIIIlllIIIlllllIIIll) throws BadBytecode {
        final int lllllllllllllIIIlllIIIlllllIlIIl = lllllllllllllIIIlllIIIlllllIIlIl;
        int lllllllllllllIIIlllIIIlllllIlIII = 0;
        char lllllllllllllIIIlllIIIlllllIIlll = lllllllllllllIIIlllIIIlllllIllIl.charAt(lllllllllllllIIIlllIIIlllllIIlIl);
        if (lllllllllllllIIIlllIIIlllllIIlll == ')') {
            return 0;
        }
        while (lllllllllllllIIIlllIIIlllllIIlll == '[') {
            ++lllllllllllllIIIlllIIIlllllIlIII;
            lllllllllllllIIIlllIIIlllllIIlll = lllllllllllllIIIlllIIIlllllIllIl.charAt(++lllllllllllllIIIlllIIIlllllIIlIl);
        }
        if (lllllllllllllIIIlllIIIlllllIIlll == 'L') {
            int lllllllllllllIIIlllIIIlllllIllll = lllllllllllllIIIlllIIIlllllIllIl.indexOf(59, ++lllllllllllllIIIlllIIIlllllIIlIl);
            if (lllllllllllllIIIlllIIIlllllIlIII > 0) {
                lllllllllllllIIIlllIIIlllllIIIll[lllllllllllllIIIlllIIIlllllIIlII] = new TypeData.ClassName(lllllllllllllIIIlllIIIlllllIllIl.substring(lllllllllllllIIIlllIIIlllllIlIIl, ++lllllllllllllIIIlllIIIlllllIllll));
            }
            else {
                lllllllllllllIIIlllIIIlllllIIIll[lllllllllllllIIIlllIIIlllllIIlII] = new TypeData.ClassName(lllllllllllllIIIlllIIIlllllIllIl.substring(lllllllllllllIIIlllIIIlllllIlIIl + 1, ++lllllllllllllIIIlllIIIlllllIllll - 1).replace('/', '.'));
            }
            return lllllllllllllIIIlllIIIlllllIllll;
        }
        if (lllllllllllllIIIlllIIIlllllIlIII > 0) {
            lllllllllllllIIIlllIIIlllllIIIll[lllllllllllllIIIlllIIIlllllIIlII] = new TypeData.ClassName(lllllllllllllIIIlllIIIlllllIllIl.substring(lllllllllllllIIIlllIIIlllllIlIIl, ++lllllllllllllIIIlllIIIlllllIIlIl));
            return lllllllllllllIIIlllIIIlllllIIlIl;
        }
        final TypeData lllllllllllllIIIlllIIIlllllIlllI = toPrimitiveTag(lllllllllllllIIIlllIIIlllllIIlll);
        if (lllllllllllllIIIlllIIIlllllIlllI == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("bad method descriptor: ").append(lllllllllllllIIIlllIIIlllllIllIl)));
        }
        lllllllllllllIIIlllIIIlllllIIIll[lllllllllllllIIIlllIIIlllllIIlII] = lllllllllllllIIIlllIIIlllllIlllI;
        return lllllllllllllIIIlllIIIlllllIIlIl + 1;
    }
    
    protected TypedBlock(final int lllllllllllllIIIlllIIlIIIlIIIlll) {
        super(lllllllllllllIIIlllIIlIIIlIIIlll);
        this.localsTypes = null;
    }
    
    public boolean alreadySet() {
        return this.localsTypes != null;
    }
    
    private static TypeData toPrimitiveTag(final char lllllllllllllIIIlllIIIllllIlllIl) {
        switch (lllllllllllllIIIlllIIIllllIlllIl) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z': {
                return TypeTag.INTEGER;
            }
            case 'J': {
                return TypeTag.LONG;
            }
            case 'F': {
                return TypeTag.FLOAT;
            }
            case 'D': {
                return TypeTag.DOUBLE;
            }
            default: {
                return null;
            }
        }
    }
    
    void initFirstBlock(final int lllllllllllllIIIlllIIlIIIIIIIIIl, final int lllllllllllllIIIlllIIlIIIIIIIIII, final String lllllllllllllIIIlllIIlIIIIIIlIIl, final String lllllllllllllIIIlllIIIlllllllllI, final boolean lllllllllllllIIIlllIIIllllllllIl, final boolean lllllllllllllIIIlllIIIllllllllII) throws BadBytecode {
        if (lllllllllllllIIIlllIIIlllllllllI.charAt(0) != '(') {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("no method descriptor: ").append(lllllllllllllIIIlllIIIlllllllllI)));
        }
        this.stackTop = 0;
        this.stackTypes = TypeData.make(lllllllllllllIIIlllIIlIIIIIIIIIl);
        final TypeData[] lllllllllllllIIIlllIIlIIIIIIIlIl = TypeData.make(lllllllllllllIIIlllIIlIIIIIIIIII);
        if (lllllllllllllIIIlllIIIllllllllII) {
            lllllllllllllIIIlllIIlIIIIIIIlIl[0] = new TypeData.UninitThis(lllllllllllllIIIlllIIlIIIIIIlIIl);
        }
        else if (!lllllllllllllIIIlllIIIllllllllIl) {
            lllllllllllllIIIlllIIlIIIIIIIlIl[0] = new TypeData.ClassName(lllllllllllllIIIlllIIlIIIIIIlIIl);
        }
        int lllllllllllllIIIlllIIlIIIIIIIlII = lllllllllllllIIIlllIIIllllllllIl ? -1 : 0;
        int lllllllllllllIIIlllIIlIIIIIIIIll = 1;
        try {
            while ((lllllllllllllIIIlllIIlIIIIIIIIll = descToTag(lllllllllllllIIIlllIIIlllllllllI, lllllllllllllIIIlllIIlIIIIIIIIll, ++lllllllllllllIIIlllIIlIIIIIIIlII, lllllllllllllIIIlllIIlIIIIIIIlIl)) > 0) {
                if (lllllllllllllIIIlllIIlIIIIIIIlIl[lllllllllllllIIIlllIIlIIIIIIIlII].is2WordType()) {
                    lllllllllllllIIIlllIIlIIIIIIIlIl[++lllllllllllllIIIlllIIlIIIIIIIlII] = TypeTag.TOP;
                }
            }
        }
        catch (StringIndexOutOfBoundsException lllllllllllllIIIlllIIlIIIIIIllIl) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("bad method descriptor: ").append(lllllllllllllIIIlllIIIlllllllllI)));
        }
        this.numLocals = lllllllllllllIIIlllIIlIIIIIIIlII;
        this.localsTypes = lllllllllllllIIIlllIIlIIIIIIIlIl;
    }
    
    public void resetNumLocals() {
        if (this.localsTypes != null) {
            int lllllllllllllIIIlllIIlIIIIIlllII;
            for (lllllllllllllIIIlllIIlIIIIIlllII = this.localsTypes.length; lllllllllllllIIIlllIIlIIIIIlllII > 0 && this.localsTypes[lllllllllllllIIIlllIIlIIIIIlllII - 1].isBasicType() == TypeTag.TOP && (lllllllllllllIIIlllIIlIIIIIlllII <= 1 || !this.localsTypes[lllllllllllllIIIlllIIlIIIIIlllII - 2].is2WordType()); --lllllllllllllIIIlllIIlIIIIIlllII) {}
            this.numLocals = lllllllllllllIIIlllIIlIIIIIlllII;
        }
    }
    
    public static String getRetType(final String lllllllllllllIIIlllIIIllllIllIII) {
        final int lllllllllllllIIIlllIIIllllIlIlll = lllllllllllllIIIlllIIIllllIllIII.indexOf(41);
        if (lllllllllllllIIIlllIIIllllIlIlll < 0) {
            return "java.lang.Object";
        }
        final char lllllllllllllIIIlllIIIllllIlIllI = lllllllllllllIIIlllIIIllllIllIII.charAt(lllllllllllllIIIlllIIIllllIlIlll + 1);
        if (lllllllllllllIIIlllIIIllllIlIllI == '[') {
            return lllllllllllllIIIlllIIIllllIllIII.substring(lllllllllllllIIIlllIIIllllIlIlll + 1);
        }
        if (lllllllllllllIIIlllIIIllllIlIllI == 'L') {
            return lllllllllllllIIIlllIIIllllIllIII.substring(lllllllllllllIIIlllIIIllllIlIlll + 2, lllllllllllllIIIlllIIIllllIllIII.length() - 1).replace('/', '.');
        }
        return "java.lang.Object";
    }
    
    private void printTypes(final StringBuffer lllllllllllllIIIlllIIlIIIIlllIII, final int lllllllllllllIIIlllIIlIIIIllIlII, final TypeData[] lllllllllllllIIIlllIIlIIIIllIIll) {
        if (lllllllllllllIIIlllIIlIIIIllIIll == null) {
            return;
        }
        for (int lllllllllllllIIIlllIIlIIIIlllIlI = 0; lllllllllllllIIIlllIIlIIIIlllIlI < lllllllllllllIIIlllIIlIIIIllIlII; ++lllllllllllllIIIlllIIlIIIIlllIlI) {
            if (lllllllllllllIIIlllIIlIIIIlllIlI > 0) {
                lllllllllllllIIIlllIIlIIIIlllIII.append(", ");
            }
            final TypeData lllllllllllllIIIlllIIlIIIIlllIll = lllllllllllllIIIlllIIlIIIIllIIll[lllllllllllllIIIlllIIlIIIIlllIlI];
            lllllllllllllIIIlllIIlIIIIlllIII.append((lllllllllllllIIIlllIIlIIIIlllIll == null) ? "<>" : lllllllllllllIIIlllIIlIIIIlllIll.toString());
        }
    }
    
    public static class Maker extends BasicBlock.Maker
    {
        @Override
        protected BasicBlock[] makeArray(final int lllllllllllllIlIIllIIIlIlllllIlI) {
            return new TypedBlock[lllllllllllllIlIIllIIIlIlllllIlI];
        }
        
        @Override
        protected BasicBlock makeBlock(final int lllllllllllllIlIIllIIIlIllllllIl) {
            return new TypedBlock(lllllllllllllIlIIllIIIlIllllllIl);
        }
    }
}
