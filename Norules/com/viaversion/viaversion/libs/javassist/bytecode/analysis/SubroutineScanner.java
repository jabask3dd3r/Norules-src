package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;

public class SubroutineScanner implements Opcode
{
    private /* synthetic */ Subroutine[] subroutines;
    /* synthetic */ Set<Integer> done;
    /* synthetic */ Map<Integer, Subroutine> subTable;
    
    private void scanLookupSwitch(final int lllllllllllllIlIlIIIIIlIIlllIlII, final CodeIterator lllllllllllllIlIlIIIIIlIIllIlIll, final Subroutine lllllllllllllIlIlIIIIIlIIlllIIlI) throws BadBytecode {
        int lllllllllllllIlIlIIIIIlIIlllIIIl = (lllllllllllllIlIlIIIIIlIIlllIlII & 0xFFFFFFFC) + 4;
        this.scan(lllllllllllllIlIlIIIIIlIIlllIlII + lllllllllllllIlIlIIIIIlIIllIlIll.s32bitAt(lllllllllllllIlIlIIIIIlIIlllIIIl), lllllllllllllIlIlIIIIIlIIllIlIll, lllllllllllllIlIlIIIIIlIIlllIIlI);
        lllllllllllllIlIlIIIIIlIIlllIIIl += 4;
        final int lllllllllllllIlIlIIIIIlIIlllIIII = lllllllllllllIlIlIIIIIlIIllIlIll.s32bitAt(lllllllllllllIlIlIIIIIlIIlllIIIl);
        final int n = lllllllllllllIlIlIIIIIlIIlllIIII * 8;
        for (lllllllllllllIlIlIIIIIlIIlllIIIl += 4, final int lllllllllllllIlIlIIIIIlIIllIllll = n + lllllllllllllIlIlIIIIIlIIlllIIIl, lllllllllllllIlIlIIIIIlIIlllIIIl += 4; lllllllllllllIlIlIIIIIlIIlllIIIl < lllllllllllllIlIlIIIIIlIIllIllll; lllllllllllllIlIlIIIIIlIIlllIIIl += 8) {
            final int lllllllllllllIlIlIIIIIlIIlllIllI = lllllllllllllIlIlIIIIIlIIllIlIll.s32bitAt(lllllllllllllIlIlIIIIIlIIlllIIIl) + lllllllllllllIlIlIIIIIlIIlllIlII;
            this.scan(lllllllllllllIlIlIIIIIlIIlllIllI, lllllllllllllIlIlIIIIIlIIllIlIll, lllllllllllllIlIlIIIIIlIIlllIIlI);
        }
    }
    
    private void scan(int lllllllllllllIlIlIIIIIlIlIllIllI, final CodeIterator lllllllllllllIlIlIIIIIlIlIllIlIl, final Subroutine lllllllllllllIlIlIIIIIlIlIllIIll) throws BadBytecode {
        if (this.done.contains(lllllllllllllIlIlIIIIIlIlIllIllI)) {
            return;
        }
        this.done.add(lllllllllllllIlIlIIIIIlIlIllIllI);
        final int lllllllllllllIlIlIIIIIlIlIlllIlI = lllllllllllllIlIlIIIIIlIlIllIlIl.lookAhead();
        lllllllllllllIlIlIIIIIlIlIllIlIl.move(lllllllllllllIlIlIIIIIlIlIllIllI);
        boolean lllllllllllllIlIlIIIIIlIlIlllIIl;
        do {
            lllllllllllllIlIlIIIIIlIlIllIllI = lllllllllllllIlIlIIIIIlIlIllIlIl.next();
            lllllllllllllIlIlIIIIIlIlIlllIIl = (this.scanOp(lllllllllllllIlIlIIIIIlIlIllIllI, lllllllllllllIlIlIIIIIlIlIllIlIl, lllllllllllllIlIlIIIIIlIlIllIIll) && lllllllllllllIlIlIIIIIlIlIllIlIl.hasNext());
        } while (lllllllllllllIlIlIIIIIlIlIlllIIl);
        lllllllllllllIlIlIIIIIlIlIllIlIl.move(lllllllllllllIlIlIIIIIlIlIlllIlI);
    }
    
    public Subroutine[] scan(final MethodInfo lllllllllllllIlIlIIIIIlIllIIlIlI) throws BadBytecode {
        final CodeAttribute lllllllllllllIlIlIIIIIlIllIIlllI = lllllllllllllIlIlIIIIIlIllIIlIlI.getCodeAttribute();
        final CodeIterator lllllllllllllIlIlIIIIIlIllIIllIl = lllllllllllllIlIlIIIIIlIllIIlllI.iterator();
        this.subroutines = new Subroutine[lllllllllllllIlIlIIIIIlIllIIlllI.getCodeLength()];
        this.subTable.clear();
        this.done.clear();
        this.scan(0, lllllllllllllIlIlIIIIIlIllIIllIl, null);
        final ExceptionTable lllllllllllllIlIlIIIIIlIllIIllII = lllllllllllllIlIlIIIIIlIllIIlllI.getExceptionTable();
        for (int lllllllllllllIlIlIIIIIlIllIlIIIl = 0; lllllllllllllIlIlIIIIIlIllIlIIIl < lllllllllllllIlIlIIIIIlIllIIllII.size(); ++lllllllllllllIlIlIIIIIlIllIlIIIl) {
            final int lllllllllllllIlIlIIIIIlIllIlIIll = lllllllllllllIlIlIIIIIlIllIIllII.handlerPc(lllllllllllllIlIlIIIIIlIllIlIIIl);
            this.scan(lllllllllllllIlIlIIIIIlIllIlIIll, lllllllllllllIlIlIIIIIlIllIIllIl, this.subroutines[lllllllllllllIlIlIIIIIlIllIIllII.startPc(lllllllllllllIlIlIIIIIlIllIlIIIl)]);
        }
        return this.subroutines;
    }
    
    private boolean scanOp(final int lllllllllllllIlIlIIIIIlIlIIIlIll, final CodeIterator lllllllllllllIlIlIIIIIlIlIIIlIlI, final Subroutine lllllllllllllIlIlIIIIIlIlIIIlIIl) throws BadBytecode {
        this.subroutines[lllllllllllllIlIlIIIIIlIlIIIlIll] = lllllllllllllIlIlIIIIIlIlIIIlIIl;
        final int lllllllllllllIlIlIIIIIlIlIIIllIl = lllllllllllllIlIlIIIIIlIlIIIlIlI.byteAt(lllllllllllllIlIlIIIIIlIlIIIlIll);
        if (lllllllllllllIlIlIIIIIlIlIIIllIl == 170) {
            this.scanTableSwitch(lllllllllllllIlIlIIIIIlIlIIIlIll, lllllllllllllIlIlIIIIIlIlIIIlIlI, lllllllllllllIlIlIIIIIlIlIIIlIIl);
            return false;
        }
        if (lllllllllllllIlIlIIIIIlIlIIIllIl == 171) {
            this.scanLookupSwitch(lllllllllllllIlIlIIIIIlIlIIIlIll, lllllllllllllIlIlIIIIIlIlIIIlIlI, lllllllllllllIlIlIIIIIlIlIIIlIIl);
            return false;
        }
        if (Util.isReturn(lllllllllllllIlIlIIIIIlIlIIIllIl) || lllllllllllllIlIlIIIIIlIlIIIllIl == 169 || lllllllllllllIlIlIIIIIlIlIIIllIl == 191) {
            return false;
        }
        if (Util.isJumpInstruction(lllllllllllllIlIlIIIIIlIlIIIllIl)) {
            final int lllllllllllllIlIlIIIIIlIlIIlIIlI = Util.getJumpTarget(lllllllllllllIlIlIIIIIlIlIIIlIll, lllllllllllllIlIlIIIIIlIlIIIlIlI);
            if (lllllllllllllIlIlIIIIIlIlIIIllIl == 168 || lllllllllllllIlIlIIIIIlIlIIIllIl == 201) {
                Subroutine lllllllllllllIlIlIIIIIlIlIIlIIll = this.subTable.get(lllllllllllllIlIlIIIIIlIlIIlIIlI);
                if (lllllllllllllIlIlIIIIIlIlIIlIIll == null) {
                    lllllllllllllIlIlIIIIIlIlIIlIIll = new Subroutine(lllllllllllllIlIlIIIIIlIlIIlIIlI, lllllllllllllIlIlIIIIIlIlIIIlIll);
                    this.subTable.put(lllllllllllllIlIlIIIIIlIlIIlIIlI, lllllllllllllIlIlIIIIIlIlIIlIIll);
                    this.scan(lllllllllllllIlIlIIIIIlIlIIlIIlI, lllllllllllllIlIlIIIIIlIlIIIlIlI, lllllllllllllIlIlIIIIIlIlIIlIIll);
                }
                else {
                    lllllllllllllIlIlIIIIIlIlIIlIIll.addCaller(lllllllllllllIlIlIIIIIlIlIIIlIll);
                }
            }
            else {
                this.scan(lllllllllllllIlIlIIIIIlIlIIlIIlI, lllllllllllllIlIlIIIIIlIlIIIlIlI, lllllllllllllIlIlIIIIIlIlIIIlIIl);
                if (Util.isGoto(lllllllllllllIlIlIIIIIlIlIIIllIl)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public SubroutineScanner() {
        this.subTable = new HashMap<Integer, Subroutine>();
        this.done = new HashSet<Integer>();
    }
    
    private void scanTableSwitch(final int lllllllllllllIlIlIIIIIlIIlIlIIII, final CodeIterator lllllllllllllIlIlIIIIIlIIlIlIlll, final Subroutine lllllllllllllIlIlIIIIIlIIlIIlllI) throws BadBytecode {
        int lllllllllllllIlIlIIIIIlIIlIlIlIl = (lllllllllllllIlIlIIIIIlIIlIlIIII & 0xFFFFFFFC) + 4;
        this.scan(lllllllllllllIlIlIIIIIlIIlIlIIII + lllllllllllllIlIlIIIIIlIIlIlIlll.s32bitAt(lllllllllllllIlIlIIIIIlIIlIlIlIl), lllllllllllllIlIlIIIIIlIIlIlIlll, lllllllllllllIlIlIIIIIlIIlIIlllI);
        lllllllllllllIlIlIIIIIlIIlIlIlIl += 4;
        final int lllllllllllllIlIlIIIIIlIIlIlIlII = lllllllllllllIlIlIIIIIlIIlIlIlll.s32bitAt(lllllllllllllIlIlIIIIIlIIlIlIlIl);
        lllllllllllllIlIlIIIIIlIIlIlIlIl += 4;
        final int lllllllllllllIlIlIIIIIlIIlIlIIll = lllllllllllllIlIlIIIIIlIIlIlIlll.s32bitAt(lllllllllllllIlIlIIIIIlIIlIlIlIl);
        final int n = (lllllllllllllIlIlIIIIIlIIlIlIIll - lllllllllllllIlIlIIIIIlIIlIlIlII + 1) * 4;
        lllllllllllllIlIlIIIIIlIIlIlIlIl += 4;
        for (int lllllllllllllIlIlIIIIIlIIlIlIIlI = n + lllllllllllllIlIlIIIIIlIIlIlIlIl; lllllllllllllIlIlIIIIIlIIlIlIlIl < lllllllllllllIlIlIIIIIlIIlIlIIlI; lllllllllllllIlIlIIIIIlIIlIlIlIl += 4) {
            final int lllllllllllllIlIlIIIIIlIIlIllIlI = lllllllllllllIlIlIIIIIlIIlIlIlll.s32bitAt(lllllllllllllIlIlIIIIIlIIlIlIlIl) + lllllllllllllIlIlIIIIIlIIlIlIIII;
            this.scan(lllllllllllllIlIlIIIIIlIIlIllIlI, lllllllllllllIlIlIIIIIlIIlIlIlll, lllllllllllllIlIlIIIIIlIIlIIlllI);
        }
    }
}
