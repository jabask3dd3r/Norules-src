package com.viaversion.viaversion.libs.javassist.bytecode;

class CodeAnalyzer implements Opcode
{
    private /* synthetic */ CodeAttribute codeAttr;
    private /* synthetic */ ConstPool constPool;
    
    private void checkTarget(final int llllllllllllIlllllIIIlIIIlllIIII, final int llllllllllllIlllllIIIlIIIllIllll, final int llllllllllllIlllllIIIlIIIlllIlII, final int[] llllllllllllIlllllIIIlIIIlllIIll, final int llllllllllllIlllllIIIlIIIlllIIlI) throws BadBytecode {
        if (llllllllllllIlllllIIIlIIIllIllll < 0 || llllllllllllIlllllIIIlIIIlllIlII <= llllllllllllIlllllIIIlIIIllIllll) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("bad branch offset at ").append(llllllllllllIlllllIIIlIIIlllIIII)));
        }
        final int llllllllllllIlllllIIIlIIIlllIIIl = llllllllllllIlllllIIIlIIIlllIIll[llllllllllllIlllllIIIlIIIllIllll];
        if (llllllllllllIlllllIIIlIIIlllIIIl == 0) {
            llllllllllllIlllllIIIlIIIlllIIll[llllllllllllIlllllIIIlIIIllIllll] = -llllllllllllIlllllIIIlIIIlllIIlI;
        }
        else if (llllllllllllIlllllIIIlIIIlllIIIl != llllllllllllIlllllIIIlIIIlllIIlI && llllllllllllIlllllIIIlIIIlllIIIl != -llllllllllllIlllllIIIlIIIlllIIlI) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("verification error (").append(llllllllllllIlllllIIIlIIIlllIIlI).append(",").append(llllllllllllIlllllIIIlIIIlllIIIl).append(") at ").append(llllllllllllIlllllIIIlIIIlllIIII)));
        }
    }
    
    private int visitInst(int llllllllllllIlllllIIIlIIIlIlIlll, final CodeIterator llllllllllllIlllllIIIlIIIlIllIll, final int llllllllllllIlllllIIIlIIIlIlIlIl, int llllllllllllIlllllIIIlIIIlIlIlII) throws BadBytecode {
        switch (llllllllllllIlllllIIIlIIIlIlIlll) {
            case 180L: {
                llllllllllllIlllllIIIlIIIlIlIlII += this.getFieldSize(llllllllllllIlllllIIIlIIIlIllIll, llllllllllllIlllllIIIlIIIlIlIlIl) - 1;
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 181L: {
                llllllllllllIlllllIIIlIIIlIlIlII -= this.getFieldSize(llllllllllllIlllllIIIlIIIlIllIll, llllllllllllIlllllIIIlIIIlIlIlIl) + 1;
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 178L: {
                llllllllllllIlllllIIIlIIIlIlIlII += this.getFieldSize(llllllllllllIlllllIIIlIIIlIllIll, llllllllllllIlllllIIIlIIIlIlIlIl);
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 179L: {
                llllllllllllIlllllIIIlIIIlIlIlII -= this.getFieldSize(llllllllllllIlllllIIIlIIIlIllIll, llllllllllllIlllllIIIlIIIlIlIlIl);
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 182L:
            case 183L: {
                final String llllllllllllIlllllIIIlIIIllIIIIl = this.constPool.getMethodrefType(llllllllllllIlllllIIIlIIIlIllIll.u16bitAt(llllllllllllIlllllIIIlIIIlIlIlIl + 1));
                llllllllllllIlllllIIIlIIIlIlIlII += Descriptor.dataSize(llllllllllllIlllllIIIlIIIllIIIIl) - 1;
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 184L: {
                final String llllllllllllIlllllIIIlIIIllIIIII = this.constPool.getMethodrefType(llllllllllllIlllllIIIlIIIlIllIll.u16bitAt(llllllllllllIlllllIIIlIIIlIlIlIl + 1));
                llllllllllllIlllllIIIlIIIlIlIlII += Descriptor.dataSize(llllllllllllIlllllIIIlIIIllIIIII);
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 185L: {
                final String llllllllllllIlllllIIIlIIIlIlllll = this.constPool.getInterfaceMethodrefType(llllllllllllIlllllIIIlIIIlIllIll.u16bitAt(llllllllllllIlllllIIIlIIIlIlIlIl + 1));
                llllllllllllIlllllIIIlIIIlIlIlII += Descriptor.dataSize(llllllllllllIlllllIIIlIIIlIlllll) - 1;
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 186L: {
                final String llllllllllllIlllllIIIlIIIlIllllI = this.constPool.getInvokeDynamicType(llllllllllllIlllllIIIlIIIlIllIll.u16bitAt(llllllllllllIlllllIIIlIIIlIlIlIl + 1));
                llllllllllllIlllllIIIlIIIlIlIlII += Descriptor.dataSize(llllllllllllIlllllIIIlIIIlIllllI);
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 191L: {
                llllllllllllIlllllIIIlIIIlIlIlII = 1;
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 197L: {
                llllllllllllIlllllIIIlIIIlIlIlII += 1 - llllllllllllIlllllIIIlIIIlIllIll.byteAt(llllllllllllIlllllIIIlIIIlIlIlIl + 3);
                return llllllllllllIlllllIIIlIIIlIlIlII;
            }
            case 196L: {
                llllllllllllIlllllIIIlIIIlIlIlll = llllllllllllIlllllIIIlIIIlIllIll.byteAt(llllllllllllIlllllIIIlIIIlIlIlIl + 1);
                break;
            }
        }
        llllllllllllIlllllIIIlIIIlIlIlII += CodeAnalyzer.STACK_GROW[llllllllllllIlllllIIIlIIIlIlIlll];
        return llllllllllllIlllllIIIlIIIlIlIlII;
    }
    
    private static boolean isEnd(final int llllllllllllIlllllIIIlIIIllIlIII) {
        return (172 <= llllllllllllIlllllIIIlIIIllIlIII && llllllllllllIlllllIIIlIIIllIlIII <= 177) || llllllllllllIlllllIIIlIIIllIlIII == 191;
    }
    
    public int computeMaxStack() throws BadBytecode {
        final CodeIterator llllllllllllIlllllIIIlIIlllIIIlI = this.codeAttr.iterator();
        final int llllllllllllIlllllIIIlIIlllIIIIl = llllllllllllIlllllIIIlIIlllIIIlI.getCodeLength();
        final int[] llllllllllllIlllllIIIlIIlllIIIII = new int[llllllllllllIlllllIIIlIIlllIIIIl];
        this.constPool = this.codeAttr.getConstPool();
        this.initStack(llllllllllllIlllllIIIlIIlllIIIII, this.codeAttr);
        boolean llllllllllllIlllllIIIlIIllIlllll;
        do {
            llllllllllllIlllllIIIlIIllIlllll = false;
            for (int llllllllllllIlllllIIIlIIlllIIlIl = 0; llllllllllllIlllllIIIlIIlllIIlIl < llllllllllllIlllllIIIlIIlllIIIIl; ++llllllllllllIlllllIIIlIIlllIIlIl) {
                if (llllllllllllIlllllIIIlIIlllIIIII[llllllllllllIlllllIIIlIIlllIIlIl] < 0) {
                    llllllllllllIlllllIIIlIIllIlllll = true;
                    this.visitBytecode(llllllllllllIlllllIIIlIIlllIIIlI, llllllllllllIlllllIIIlIIlllIIIII, llllllllllllIlllllIIIlIIlllIIlIl);
                }
            }
        } while (llllllllllllIlllllIIIlIIllIlllll);
        int llllllllllllIlllllIIIlIIllIllllI = 1;
        for (int llllllllllllIlllllIIIlIIlllIIlII = 0; llllllllllllIlllllIIIlIIlllIIlII < llllllllllllIlllllIIIlIIlllIIIIl; ++llllllllllllIlllllIIIlIIlllIIlII) {
            if (llllllllllllIlllllIIIlIIlllIIIII[llllllllllllIlllllIIIlIIlllIIlII] > llllllllllllIlllllIIIlIIllIllllI) {
                llllllllllllIlllllIIIlIIllIllllI = llllllllllllIlllllIIIlIIlllIIIII[llllllllllllIlllllIIIlIIlllIIlII];
            }
        }
        return llllllllllllIlllllIIIlIIllIllllI - 1;
    }
    
    private void visitBytecode(final CodeIterator llllllllllllIlllllIIIlIIlIllIlIl, final int[] llllllllllllIlllllIIIlIIlIlllIll, int llllllllllllIlllllIIIlIIlIlllIlI) throws BadBytecode {
        final int llllllllllllIlllllIIIlIIlIlllIIl = llllllllllllIlllllIIIlIIlIlllIll.length;
        llllllllllllIlllllIIIlIIlIllIlIl.move(llllllllllllIlllllIIIlIIlIlllIlI);
        int llllllllllllIlllllIIIlIIlIlllIII = -llllllllllllIlllllIIIlIIlIlllIll[llllllllllllIlllllIIIlIIlIlllIlI];
        final int[] llllllllllllIlllllIIIlIIlIllIlll = { -1 };
        while (llllllllllllIlllllIIIlIIlIllIlIl.hasNext()) {
            llllllllllllIlllllIIIlIIlIlllIlI = llllllllllllIlllllIIIlIIlIllIlIl.next();
            llllllllllllIlllllIIIlIIlIlllIll[llllllllllllIlllllIIIlIIlIlllIlI] = llllllllllllIlllllIIIlIIlIlllIII;
            final int llllllllllllIlllllIIIlIIlIlllllI = llllllllllllIlllllIIIlIIlIllIlIl.byteAt(llllllllllllIlllllIIIlIIlIlllIlI);
            llllllllllllIlllllIIIlIIlIlllIII = this.visitInst(llllllllllllIlllllIIIlIIlIlllllI, llllllllllllIlllllIIIlIIlIllIlIl, llllllllllllIlllllIIIlIIlIlllIlI, llllllllllllIlllllIIIlIIlIlllIII);
            if (llllllllllllIlllllIIIlIIlIlllIII < 1) {
                throw new BadBytecode(String.valueOf(new StringBuilder().append("stack underflow at ").append(llllllllllllIlllllIIIlIIlIlllIlI)));
            }
            if (this.processBranch(llllllllllllIlllllIIIlIIlIlllllI, llllllllllllIlllllIIIlIIlIllIlIl, llllllllllllIlllllIIIlIIlIlllIlI, llllllllllllIlllllIIIlIIlIlllIIl, llllllllllllIlllllIIIlIIlIlllIll, llllllllllllIlllllIIIlIIlIlllIII, llllllllllllIlllllIIIlIIlIllIlll)) {
                break;
            }
            if (isEnd(llllllllllllIlllllIIIlIIlIlllllI)) {
                break;
            }
            if (llllllllllllIlllllIIIlIIlIlllllI != 168 && llllllllllllIlllllIIIlIIlIlllllI != 201) {
                continue;
            }
            --llllllllllllIlllllIIIlIIlIlllIII;
        }
    }
    
    private void initStack(final int[] llllllllllllIlllllIIIlIIllIIlIll, final CodeAttribute llllllllllllIlllllIIIlIIllIIlIlI) {
        llllllllllllIlllllIIIlIIllIIlIll[0] = -1;
        final ExceptionTable llllllllllllIlllllIIIlIIllIIllII = llllllllllllIlllllIIIlIIllIIlIlI.getExceptionTable();
        if (llllllllllllIlllllIIIlIIllIIllII != null) {
            for (int llllllllllllIlllllIIIlIIllIlIIII = llllllllllllIlllllIIIlIIllIIllII.size(), llllllllllllIlllllIIIlIIllIlIIIl = 0; llllllllllllIlllllIIIlIIllIlIIIl < llllllllllllIlllllIIIlIIllIlIIII; ++llllllllllllIlllllIIIlIIllIlIIIl) {
                llllllllllllIlllllIIIlIIllIIlIll[llllllllllllIlllllIIIlIIllIIllII.handlerPc(llllllllllllIlllllIIIlIIllIlIIIl)] = -2;
            }
        }
    }
    
    private boolean processBranch(final int llllllllllllIlllllIIIlIIlIIIlIlI, final CodeIterator llllllllllllIlllllIIIlIIlIIlIIIl, final int llllllllllllIlllllIIIlIIlIIIlIII, final int llllllllllllIlllllIIIlIIlIIIIlll, final int[] llllllllllllIlllllIIIlIIlIIIIllI, final int llllllllllllIlllllIIIlIIlIIIllIl, final int[] llllllllllllIlllllIIIlIIlIIIIlII) throws BadBytecode {
        if ((153 <= llllllllllllIlllllIIIlIIlIIIlIlI && llllllllllllIlllllIIIlIIlIIIlIlI <= 166) || llllllllllllIlllllIIIlIIlIIIlIlI == 198 || llllllllllllIlllllIIIlIIlIIIlIlI == 199) {
            final int llllllllllllIlllllIIIlIIlIlIIIII = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s16bitAt(llllllllllllIlllllIIIlIIlIIIlIII + 1);
            this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIlIIIII, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
        }
        else {
            switch (llllllllllllIlllllIIIlIIlIIIlIlI) {
                case 167: {
                    final int llllllllllllIlllllIIIlIIlIIlllll = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s16bitAt(llllllllllllIlllllIIIlIIlIIIlIII + 1);
                    this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIIlllll, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
                    return true;
                }
                case 200: {
                    final int llllllllllllIlllllIIIlIIlIIllllI = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIIlIII + 1);
                    this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIIllllI, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
                    return true;
                }
                case 168:
                case 201: {
                    int llllllllllllIlllllIIIlIIlIIlllII = 0;
                    if (llllllllllllIlllllIIIlIIlIIIlIlI == 168) {
                        final int llllllllllllIlllllIIIlIIlIIlllIl = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s16bitAt(llllllllllllIlllllIIIlIIlIIIlIII + 1);
                    }
                    else {
                        llllllllllllIlllllIIIlIIlIIlllII = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIIlIII + 1);
                    }
                    this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIIlllII, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
                    if (llllllllllllIlllllIIIlIIlIIIIlII[0] < 0) {
                        llllllllllllIlllllIIIlIIlIIIIlII[0] = llllllllllllIlllllIIIlIIlIIIllIl;
                        return false;
                    }
                    if (llllllllllllIlllllIIIlIIlIIIllIl == llllllllllllIlllllIIIlIIlIIIIlII[0]) {
                        return false;
                    }
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("sorry, cannot compute this data flow due to JSR: ").append(llllllllllllIlllllIIIlIIlIIIllIl).append(",").append(llllllllllllIlllllIIIlIIlIIIIlII[0])));
                }
                case 169: {
                    if (llllllllllllIlllllIIIlIIlIIIIlII[0] < 0) {
                        llllllllllllIlllllIIIlIIlIIIIlII[0] = llllllllllllIlllllIIIlIIlIIIllIl + 1;
                        return false;
                    }
                    if (llllllllllllIlllllIIIlIIlIIIllIl + 1 == llllllllllllIlllllIIIlIIlIIIIlII[0]) {
                        return true;
                    }
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("sorry, cannot compute this data flow due to RET: ").append(llllllllllllIlllllIIIlIIlIIIllIl).append(",").append(llllllllllllIlllllIIIlIIlIIIIlII[0])));
                }
                case 170:
                case 171: {
                    int llllllllllllIlllllIIIlIIlIIlIlII = (llllllllllllIlllllIIIlIIlIIIlIII & 0xFFFFFFFC) + 4;
                    int llllllllllllIlllllIIIlIIlIIlIlIl = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIlIlII);
                    this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIIlIlIl, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
                    if (llllllllllllIlllllIIIlIIlIIIlIlI == 171) {
                        final int llllllllllllIlllllIIIlIIlIIllIlI = llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIlIlII + 4);
                        llllllllllllIlllllIIIlIIlIIlIlII += 12;
                        for (int llllllllllllIlllllIIIlIIlIIllIll = 0; llllllllllllIlllllIIIlIIlIIllIll < llllllllllllIlllllIIIlIIlIIllIlI; ++llllllllllllIlllllIIIlIIlIIllIll) {
                            llllllllllllIlllllIIIlIIlIIlIlIl = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIlIlII);
                            this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIIlIlIl, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
                            llllllllllllIlllllIIIlIIlIIlIlII += 8;
                        }
                    }
                    else {
                        final int llllllllllllIlllllIIIlIIlIIllIII = llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIlIlII + 4);
                        final int llllllllllllIlllllIIIlIIlIIlIlll = llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIlIlII + 8);
                        final int llllllllllllIlllllIIIlIIlIIlIllI = llllllllllllIlllllIIIlIIlIIlIlll - llllllllllllIlllllIIIlIIlIIllIII + 1;
                        llllllllllllIlllllIIIlIIlIIlIlII += 12;
                        for (int llllllllllllIlllllIIIlIIlIIllIIl = 0; llllllllllllIlllllIIIlIIlIIllIIl < llllllllllllIlllllIIIlIIlIIlIllI; ++llllllllllllIlllllIIIlIIlIIllIIl) {
                            llllllllllllIlllllIIIlIIlIIlIlIl = llllllllllllIlllllIIIlIIlIIIlIII + llllllllllllIlllllIIIlIIlIIlIIIl.s32bitAt(llllllllllllIlllllIIIlIIlIIlIlII);
                            this.checkTarget(llllllllllllIlllllIIIlIIlIIIlIII, llllllllllllIlllllIIIlIIlIIlIlIl, llllllllllllIlllllIIIlIIlIIIIlll, llllllllllllIlllllIIIlIIlIIIIllI, llllllllllllIlllllIIIlIIlIIIllIl);
                            llllllllllllIlllllIIIlIIlIIlIlII += 4;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    public CodeAnalyzer(final CodeAttribute llllllllllllIlllllIIIlIIlllIllll) {
        this.codeAttr = llllllllllllIlllllIIIlIIlllIllll;
        this.constPool = llllllllllllIlllllIIIlIIlllIllll.getConstPool();
    }
    
    private int getFieldSize(final CodeIterator llllllllllllIlllllIIIlIIIlIIllIl, final int llllllllllllIlllllIIIlIIIlIIlIII) {
        final String llllllllllllIlllllIIIlIIIlIIlIll = this.constPool.getFieldrefType(llllllllllllIlllllIIIlIIIlIIllIl.u16bitAt(llllllllllllIlllllIIIlIIIlIIlIII + 1));
        return Descriptor.dataSize(llllllllllllIlllllIIIlIIIlIIlIll);
    }
}
