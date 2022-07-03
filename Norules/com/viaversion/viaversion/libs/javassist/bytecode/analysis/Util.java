package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class Util implements Opcode
{
    public static boolean isGoto(final int lllllllllllllIIllllIIIIIIIllIlll) {
        return lllllllllllllIIllllIIIIIIIllIlll == 167 || lllllllllllllIIllllIIIIIIIllIlll == 200;
    }
    
    public static int getJumpTarget(int lllllllllllllIIllllIIIIIIIllllll, final CodeIterator lllllllllllllIIllllIIIIIIlIIIIIl) {
        final int lllllllllllllIIllllIIIIIIlIIIIII = lllllllllllllIIllllIIIIIIlIIIIIl.byteAt(lllllllllllllIIllllIIIIIIIllllll);
        lllllllllllllIIllllIIIIIIIllllll += ((lllllllllllllIIllllIIIIIIlIIIIII == 201 || lllllllllllllIIllllIIIIIIlIIIIII == 200) ? lllllllllllllIIllllIIIIIIlIIIIIl.s32bitAt(lllllllllllllIIllllIIIIIIIllllll + 1) : lllllllllllllIIllllIIIIIIlIIIIIl.s16bitAt(lllllllllllllIIllllIIIIIIIllllll + 1));
        return lllllllllllllIIllllIIIIIIIllllll;
    }
    
    public static boolean isJumpInstruction(final int lllllllllllllIIllllIIIIIIIlllIll) {
        return (lllllllllllllIIllllIIIIIIIlllIll >= 153 && lllllllllllllIIllllIIIIIIIlllIll <= 168) || lllllllllllllIIllllIIIIIIIlllIll == 198 || lllllllllllllIIllllIIIIIIIlllIll == 199 || lllllllllllllIIllllIIIIIIIlllIll == 201 || lllllllllllllIIllllIIIIIIIlllIll == 200;
    }
    
    public static boolean isJsr(final int lllllllllllllIIllllIIIIIIIllIlIl) {
        return lllllllllllllIIllllIIIIIIIllIlIl == 168 || lllllllllllllIIllllIIIIIIIllIlIl == 201;
    }
    
    public static boolean isReturn(final int lllllllllllllIIllllIIIIIIIllIIIl) {
        return lllllllllllllIIllllIIIIIIIllIIIl >= 172 && lllllllllllllIIllllIIIIIIIllIIIl <= 177;
    }
}
