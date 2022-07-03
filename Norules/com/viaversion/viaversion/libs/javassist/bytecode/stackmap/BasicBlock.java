package com.viaversion.viaversion.libs.javassist.bytecode.stackmap;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;

public class BasicBlock
{
    protected /* synthetic */ int length;
    protected /* synthetic */ BasicBlock[] exit;
    protected /* synthetic */ int incoming;
    protected /* synthetic */ Catch toCatch;
    protected /* synthetic */ boolean stop;
    protected /* synthetic */ int position;
    
    protected void toString2(final StringBuffer llllllllllllllllIlIlIlIIIlllIIlI) {
        llllllllllllllllIlIlIlIIIlllIIlI.append("pos=").append(this.position).append(", len=").append(this.length).append(", in=").append(this.incoming).append(", exit{");
        if (this.exit != null) {
            final int llllllllllllllllIlIlIlIIIllIllII = (Object)this.exit;
            final short llllllllllllllllIlIlIlIIIllIlIll = (short)llllllllllllllllIlIlIlIIIllIllII.length;
            for (boolean llllllllllllllllIlIlIlIIIllIlIIl = false; (llllllllllllllllIlIlIlIIIllIlIIl ? 1 : 0) < llllllllllllllllIlIlIlIIIllIlIll; ++llllllllllllllllIlIlIlIIIllIlIIl) {
                final BasicBlock llllllllllllllllIlIlIlIIIlllIlIl = llllllllllllllllIlIlIlIIIllIllII[llllllllllllllllIlIlIlIIIllIlIIl];
                llllllllllllllllIlIlIlIIIlllIIlI.append(llllllllllllllllIlIlIlIIIlllIlIl.position).append(",");
            }
        }
        llllllllllllllllIlIlIlIIIlllIIlI.append("}, {");
        for (Catch llllllllllllllllIlIlIlIIIlllIIIl = this.toCatch; llllllllllllllllIlIlIlIIIlllIIIl != null; llllllllllllllllIlIlIlIIIlllIIIl = llllllllllllllllIlIlIlIIIlllIIIl.next) {
            llllllllllllllllIlIlIlIIIlllIIlI.append("(").append(llllllllllllllllIlIlIlIIIlllIIIl.body.position).append(", ").append(llllllllllllllllIlIlIlIIIlllIIIl.typeIndex).append("), ");
        }
        llllllllllllllllIlIlIlIIIlllIIlI.append("}");
    }
    
    @Override
    public String toString() {
        final StringBuffer llllllllllllllllIlIlIlIIlIIIlIIl = new StringBuffer();
        final String llllllllllllllllIlIlIlIIlIIIlIII = this.getClass().getName();
        final int llllllllllllllllIlIlIlIIlIIIIlll = llllllllllllllllIlIlIlIIlIIIlIII.lastIndexOf(46);
        llllllllllllllllIlIlIlIIlIIIlIIl.append((llllllllllllllllIlIlIlIIlIIIIlll < 0) ? llllllllllllllllIlIlIlIIlIIIlIII : llllllllllllllllIlIlIlIIlIIIlIII.substring(llllllllllllllllIlIlIlIIlIIIIlll + 1));
        llllllllllllllllIlIlIlIIlIIIlIIl.append("[");
        this.toString2(llllllllllllllllIlIlIlIIlIIIlIIl);
        llllllllllllllllIlIlIlIIlIIIlIIl.append("]");
        return llllllllllllllllIlIlIlIIlIIIlIIl.toString();
    }
    
    protected BasicBlock(final int llllllllllllllllIlIlIlIIlIlIIIII) {
        this.position = llllllllllllllllIlIlIlIIlIlIIIII;
        this.length = 0;
        this.incoming = 0;
    }
    
    public static BasicBlock find(final BasicBlock[] llllllllllllllllIlIlIlIIlIIlIllI, final int llllllllllllllllIlIlIlIIlIIlIIll) throws BadBytecode {
        final boolean llllllllllllllllIlIlIlIIlIIlIIlI = (Object)llllllllllllllllIlIlIlIIlIIlIllI;
        final byte llllllllllllllllIlIlIlIIlIIlIIIl = (byte)llllllllllllllllIlIlIlIIlIIlIIlI.length;
        for (short llllllllllllllllIlIlIlIIlIIlIIII = 0; llllllllllllllllIlIlIlIIlIIlIIII < llllllllllllllllIlIlIlIIlIIlIIIl; ++llllllllllllllllIlIlIlIIlIIlIIII) {
            final BasicBlock llllllllllllllllIlIlIlIIlIIlIlll = llllllllllllllllIlIlIlIIlIIlIIlI[llllllllllllllllIlIlIlIIlIIlIIII];
            if (llllllllllllllllIlIlIlIIlIIlIlll.position <= llllllllllllllllIlIlIlIIlIIlIIll && llllllllllllllllIlIlIlIIlIIlIIll < llllllllllllllllIlIlIlIIlIIlIlll.position + llllllllllllllllIlIlIlIIlIIlIlll.length) {
                return llllllllllllllllIlIlIlIIlIIlIlll;
            }
        }
        throw new BadBytecode(String.valueOf(new StringBuilder().append("no basic block at ").append(llllllllllllllllIlIlIlIIlIIlIIll)));
    }
    
    static class JsrBytecode extends BadBytecode
    {
        JsrBytecode() {
            super("JSR");
        }
    }
    
    public static class Catch
    {
        public /* synthetic */ BasicBlock body;
        public /* synthetic */ int typeIndex;
        public /* synthetic */ Catch next;
        
        Catch(final int lllllllllllllIlllIIIIIIlIlIllIIl, final Catch lllllllllllllIlllIIIIIIlIlIlllII) {
            this.typeIndex = lllllllllllllIlllIIIIIIlIlIllIIl;
            this.next = lllllllllllllIlllIIIIIIlIlIlllII;
        }
    }
    
    static class Mark implements Comparable<Mark>
    {
        /* synthetic */ Catch catcher;
        /* synthetic */ BasicBlock block;
        /* synthetic */ int size;
        /* synthetic */ BasicBlock[] jump;
        /* synthetic */ int position;
        /* synthetic */ boolean alwaysJmp;
        
        Mark(final int lllllllllllllIIIIIIlllllIIIIlIIl) {
            this.position = lllllllllllllIIIIIIlllllIIIIlIIl;
            this.block = null;
            this.jump = null;
            this.alwaysJmp = false;
            this.size = 0;
            this.catcher = null;
        }
        
        void setJump(final BasicBlock[] lllllllllllllIIIIIIllllIlllllIIl, final int lllllllllllllIIIIIIllllIlllllIII, final boolean lllllllllllllIIIIIIllllIlllllIll) {
            this.jump = lllllllllllllIIIIIIllllIlllllIIl;
            this.size = lllllllllllllIIIIIIllllIlllllIII;
            this.alwaysJmp = lllllllllllllIIIIIIllllIlllllIll;
        }
        
        @Override
        public int compareTo(final Mark lllllllllllllIIIIIIlllllIIIIIIll) {
            if (null == lllllllllllllIIIIIIlllllIIIIIIll) {
                return -1;
            }
            return this.position - lllllllllllllIIIIIIlllllIIIIIIll.position;
        }
    }
    
    public static class Maker
    {
        protected void makeJsr(final Map<Integer, Mark> lllllllllllllIIIIlllIlIIIIIllIII, final int lllllllllllllIIIIlllIlIIIIIlIlll, final int lllllllllllllIIIIlllIlIIIIIlIllI, final int lllllllllllllIIIIlllIlIIIIIlIlIl) throws BadBytecode {
            throw new JsrBytecode();
        }
        
        private BasicBlock[] makeArray(final BasicBlock lllllllllllllIIIIlllIlIIllIIlIIl) {
            final BasicBlock[] lllllllllllllIIIIlllIlIIllIIlIll = this.makeArray(1);
            lllllllllllllIIIIlllIlIIllIIlIll[0] = lllllllllllllIIIIlllIlIIllIIlIIl;
            return lllllllllllllIIIIlllIlIIllIIlIll;
        }
        
        private void addCatchers(final BasicBlock[] lllllllllllllIIIIlllIIlllllIIIll, final ExceptionTable lllllllllllllIIIIlllIIllllIlllll) throws BadBytecode {
            if (lllllllllllllIIIIlllIIllllIlllll == null) {
                return;
            }
            int lllllllllllllIIIIlllIIlllllIIIIl = lllllllllllllIIIIlllIIllllIlllll.size();
            while (--lllllllllllllIIIIlllIIlllllIIIIl >= 0) {
                final BasicBlock lllllllllllllIIIIlllIIlllllIlIII = BasicBlock.find(lllllllllllllIIIIlllIIlllllIIIll, lllllllllllllIIIIlllIIllllIlllll.handlerPc(lllllllllllllIIIIlllIIlllllIIIIl));
                final int lllllllllllllIIIIlllIIlllllIIlll = lllllllllllllIIIIlllIIllllIlllll.startPc(lllllllllllllIIIIlllIIlllllIIIIl);
                final int lllllllllllllIIIIlllIIlllllIIllI = lllllllllllllIIIIlllIIllllIlllll.endPc(lllllllllllllIIIIlllIIlllllIIIIl);
                final int lllllllllllllIIIIlllIIlllllIIlIl = lllllllllllllIIIIlllIIllllIlllll.catchType(lllllllllllllIIIIlllIIlllllIIIIl);
                final BasicBlock basicBlock = lllllllllllllIIIIlllIIlllllIlIII;
                --basicBlock.incoming;
                for (int lllllllllllllIIIIlllIIlllllIlIIl = 0; lllllllllllllIIIIlllIIlllllIlIIl < lllllllllllllIIIIlllIIlllllIIIll.length; ++lllllllllllllIIIIlllIIlllllIlIIl) {
                    final BasicBlock lllllllllllllIIIIlllIIlllllIlIll = lllllllllllllIIIIlllIIlllllIIIll[lllllllllllllIIIIlllIIlllllIlIIl];
                    final int lllllllllllllIIIIlllIIlllllIlIlI = lllllllllllllIIIIlllIIlllllIlIll.position;
                    if (lllllllllllllIIIIlllIIlllllIIlll <= lllllllllllllIIIIlllIIlllllIlIlI && lllllllllllllIIIIlllIIlllllIlIlI < lllllllllllllIIIIlllIIlllllIIllI) {
                        lllllllllllllIIIIlllIIlllllIlIll.toCatch = new Catch(lllllllllllllIIIIlllIIlllllIlIII, lllllllllllllIIIIlllIIlllllIIlIl, lllllllllllllIIIIlllIIlllllIlIll.toCatch);
                        final BasicBlock basicBlock2 = lllllllllllllIIIIlllIIlllllIlIII;
                        ++basicBlock2.incoming;
                    }
                }
            }
        }
        
        private Mark makeMark(final Map<Integer, Mark> lllllllllllllIIIIlllIlIIlIIlIIll, final int lllllllllllllIIIIlllIlIIlIIlIlIl) {
            return this.makeMark0(lllllllllllllIIIIlllIlIIlIIlIIll, lllllllllllllIIIIlllIlIIlIIlIlIl, true, true);
        }
        
        protected BasicBlock[] makeArray(final int lllllllllllllIIIIlllIlIIllIlIIIl) {
            return new BasicBlock[lllllllllllllIIIIlllIlIIllIlIIIl];
        }
        
        private void makeGoto(final Map<Integer, Mark> lllllllllllllIIIIlllIlIIIIlIIllI, final int lllllllllllllIIIIlllIlIIIIlIIlIl, final int lllllllllllllIIIIlllIlIIIIlIIlII, final int lllllllllllllIIIIlllIlIIIIIlllII) {
            final Mark lllllllllllllIIIIlllIlIIIIlIIIlI = this.makeMark(lllllllllllllIIIIlllIlIIIIlIIllI, lllllllllllllIIIIlllIlIIIIlIIlII);
            final BasicBlock[] lllllllllllllIIIIlllIlIIIIlIIIIl = this.makeArray(lllllllllllllIIIIlllIlIIIIlIIIlI.block);
            this.makeMark(lllllllllllllIIIIlllIlIIIIlIIllI, lllllllllllllIIIIlllIlIIIIlIIlIl, lllllllllllllIIIIlllIlIIIIlIIIIl, lllllllllllllIIIIlllIlIIIIIlllII, true);
        }
        
        private static BasicBlock getBBlock(final Mark lllllllllllllIIIIlllIIllllllIlll) {
            final BasicBlock lllllllllllllIIIIlllIIlllllllIII = lllllllllllllIIIIlllIIllllllIlll.block;
            if (lllllllllllllIIIIlllIIlllllllIII != null && lllllllllllllIIIIlllIIllllllIlll.size > 0) {
                lllllllllllllIIIIlllIIlllllllIII.exit = lllllllllllllIIIIlllIIllllllIlll.jump;
                lllllllllllllIIIIlllIIlllllllIII.length = lllllllllllllIIIIlllIIllllllIlll.size;
                lllllllllllllIIIIlllIIlllllllIII.stop = lllllllllllllIIIIlllIIllllllIlll.alwaysJmp;
            }
            return lllllllllllllIIIIlllIIlllllllIII;
        }
        
        private BasicBlock[] makeBlocks(final Map<Integer, Mark> lllllllllllllIIIIlllIlIIIIIIlIII) {
            final Mark[] lllllllllllllIIIIlllIlIIIIIIIlll = lllllllllllllIIIIlllIlIIIIIIlIII.values().toArray(new Mark[lllllllllllllIIIIlllIlIIIIIIlIII.size()]);
            Arrays.sort(lllllllllllllIIIIlllIlIIIIIIIlll);
            final List<BasicBlock> lllllllllllllIIIIlllIlIIIIIIIllI = new ArrayList<BasicBlock>();
            int lllllllllllllIIIIlllIlIIIIIIIlIl = 0;
            BasicBlock lllllllllllllIIIIlllIlIIIIIIIlII = null;
            if (lllllllllllllIIIIlllIlIIIIIIIlll.length > 0 && lllllllllllllIIIIlllIlIIIIIIIlll[0].position == 0 && lllllllllllllIIIIlllIlIIIIIIIlll[0].block != null) {
                final BasicBlock lllllllllllllIIIIlllIlIIIIIIllII = getBBlock(lllllllllllllIIIIlllIlIIIIIIIlll[lllllllllllllIIIIlllIlIIIIIIIlIl++]);
            }
            else {
                lllllllllllllIIIIlllIlIIIIIIIlII = this.makeBlock(0);
            }
            lllllllllllllIIIIlllIlIIIIIIIllI.add(lllllllllllllIIIIlllIlIIIIIIIlII);
            while (lllllllllllllIIIIlllIlIIIIIIIlIl < lllllllllllllIIIIlllIlIIIIIIIlll.length) {
                final Mark lllllllllllllIIIIlllIlIIIIIIlIll = lllllllllllllIIIIlllIlIIIIIIIlll[lllllllllllllIIIIlllIlIIIIIIIlIl++];
                final BasicBlock lllllllllllllIIIIlllIlIIIIIIlIlI = getBBlock(lllllllllllllIIIIlllIlIIIIIIlIll);
                if (lllllllllllllIIIIlllIlIIIIIIlIlI == null) {
                    if (lllllllllllllIIIIlllIlIIIIIIIlII.length > 0) {
                        lllllllllllllIIIIlllIlIIIIIIIlII = this.makeBlock(lllllllllllllIIIIlllIlIIIIIIIlII.position + lllllllllllllIIIIlllIlIIIIIIIlII.length);
                        lllllllllllllIIIIlllIlIIIIIIIllI.add(lllllllllllllIIIIlllIlIIIIIIIlII);
                    }
                    lllllllllllllIIIIlllIlIIIIIIIlII.length = lllllllllllllIIIIlllIlIIIIIIlIll.position + lllllllllllllIIIIlllIlIIIIIIlIll.size - lllllllllllllIIIIlllIlIIIIIIIlII.position;
                    lllllllllllllIIIIlllIlIIIIIIIlII.exit = lllllllllllllIIIIlllIlIIIIIIlIll.jump;
                    lllllllllllllIIIIlllIlIIIIIIIlII.stop = lllllllllllllIIIIlllIlIIIIIIlIll.alwaysJmp;
                }
                else {
                    if (lllllllllllllIIIIlllIlIIIIIIIlII.length == 0) {
                        lllllllllllllIIIIlllIlIIIIIIIlII.length = lllllllllllllIIIIlllIlIIIIIIlIll.position - lllllllllllllIIIIlllIlIIIIIIIlII.position;
                        final BasicBlock basicBlock = lllllllllllllIIIIlllIlIIIIIIlIlI;
                        ++basicBlock.incoming;
                        lllllllllllllIIIIlllIlIIIIIIIlII.exit = this.makeArray(lllllllllllllIIIIlllIlIIIIIIlIlI);
                    }
                    else if (lllllllllllllIIIIlllIlIIIIIIIlII.position + lllllllllllllIIIIlllIlIIIIIIIlII.length < lllllllllllllIIIIlllIlIIIIIIlIll.position) {
                        lllllllllllllIIIIlllIlIIIIIIIlII = this.makeBlock(lllllllllllllIIIIlllIlIIIIIIIlII.position + lllllllllllllIIIIlllIlIIIIIIIlII.length);
                        lllllllllllllIIIIlllIlIIIIIIIllI.add(lllllllllllllIIIIlllIlIIIIIIIlII);
                        lllllllllllllIIIIlllIlIIIIIIIlII.length = lllllllllllllIIIIlllIlIIIIIIlIll.position - lllllllllllllIIIIlllIlIIIIIIIlII.position;
                        lllllllllllllIIIIlllIlIIIIIIIlII.stop = true;
                        lllllllllllllIIIIlllIlIIIIIIIlII.exit = this.makeArray(lllllllllllllIIIIlllIlIIIIIIlIlI);
                    }
                    lllllllllllllIIIIlllIlIIIIIIIllI.add(lllllllllllllIIIIlllIlIIIIIIlIlI);
                    lllllllllllllIIIIlllIlIIIIIIIlII = lllllllllllllIIIIlllIlIIIIIIlIlI;
                }
            }
            return lllllllllllllIIIIlllIlIIIIIIIllI.toArray(this.makeArray(lllllllllllllIIIIlllIlIIIIIIIllI.size()));
        }
        
        private BasicBlock[] makeArray(final BasicBlock lllllllllllllIIIIlllIlIIlIlllllI, final BasicBlock lllllllllllllIIIIlllIlIIlIllllIl) {
            final BasicBlock[] lllllllllllllIIIIlllIlIIllIIIIII = this.makeArray(2);
            lllllllllllllIIIIlllIlIIllIIIIII[0] = lllllllllllllIIIIlllIlIIlIlllllI;
            lllllllllllllIIIIlllIlIIllIIIIII[1] = lllllllllllllIIIIlllIlIIlIllllIl;
            return lllllllllllllIIIIlllIlIIllIIIIII;
        }
        
        public BasicBlock[] make(final MethodInfo lllllllllllllIIIIlllIlIIlIllIIlI) throws BadBytecode {
            final CodeAttribute lllllllllllllIIIIlllIlIIlIllIlIl = lllllllllllllIIIIlllIlIIlIllIIlI.getCodeAttribute();
            if (lllllllllllllIIIIlllIlIIlIllIlIl == null) {
                return null;
            }
            final CodeIterator lllllllllllllIIIIlllIlIIlIllIlII = lllllllllllllIIIIlllIlIIlIllIlIl.iterator();
            return this.make(lllllllllllllIIIIlllIlIIlIllIlII, 0, lllllllllllllIIIIlllIlIIlIllIlII.getCodeLength(), lllllllllllllIIIIlllIlIIlIllIlIl.getExceptionTable());
        }
        
        private Mark makeMark0(final Map<Integer, Mark> lllllllllllllIIIIlllIlIIIllIllIl, final int lllllllllllllIIIIlllIlIIIlllIIll, final boolean lllllllllllllIIIIlllIlIIIllIlIll, final boolean lllllllllllllIIIIlllIlIIIllIlIlI) {
            final Integer lllllllllllllIIIIlllIlIIIlllIIII = lllllllllllllIIIIlllIlIIIlllIIll;
            Mark lllllllllllllIIIIlllIlIIIllIllll = lllllllllllllIIIIlllIlIIIllIllIl.get(lllllllllllllIIIIlllIlIIIlllIIII);
            if (lllllllllllllIIIIlllIlIIIllIllll == null) {
                lllllllllllllIIIIlllIlIIIllIllll = new Mark(lllllllllllllIIIIlllIlIIIlllIIll);
                lllllllllllllIIIIlllIlIIIllIllIl.put(lllllllllllllIIIIlllIlIIIlllIIII, lllllllllllllIIIIlllIlIIIllIllll);
            }
            if (lllllllllllllIIIIlllIlIIIllIlIll) {
                if (lllllllllllllIIIIlllIlIIIllIllll.block == null) {
                    lllllllllllllIIIIlllIlIIIllIllll.block = this.makeBlock(lllllllllllllIIIIlllIlIIIlllIIll);
                }
                if (lllllllllllllIIIIlllIlIIIllIlIlI) {
                    final BasicBlock block = lllllllllllllIIIIlllIlIIIllIllll.block;
                    ++block.incoming;
                }
            }
            return lllllllllllllIIIIlllIlIIIllIllll;
        }
        
        private Mark makeMark(final Map<Integer, Mark> lllllllllllllIIIIlllIlIIlIIIIIlI, final int lllllllllllllIIIIlllIlIIlIIIIIIl, final BasicBlock[] lllllllllllllIIIIlllIlIIlIIIIlll, final int lllllllllllllIIIIlllIlIIlIIIIllI, final boolean lllllllllllllIIIIlllIlIIlIIIIlIl) {
            final Mark lllllllllllllIIIIlllIlIIlIIIIlII = this.makeMark0(lllllllllllllIIIIlllIlIIlIIIIIlI, lllllllllllllIIIIlllIlIIlIIIIIIl, false, false);
            lllllllllllllIIIIlllIlIIlIIIIlII.setJump(lllllllllllllIIIIlllIlIIlIIIIlll, lllllllllllllIIIIlllIlIIlIIIIllI, lllllllllllllIIIIlllIlIIlIIIIlIl);
            return lllllllllllllIIIIlllIlIIlIIIIlII;
        }
        
        protected BasicBlock makeBlock(final int lllllllllllllIIIIlllIlIIllIlIllI) {
            return new BasicBlock(lllllllllllllIIIIlllIlIIllIlIllI);
        }
        
        public BasicBlock[] make(final CodeIterator lllllllllllllIIIIlllIlIIlIlIIlll, final int lllllllllllllIIIIlllIlIIlIlIIllI, final int lllllllllllllIIIIlllIlIIlIIllllI, final ExceptionTable lllllllllllllIIIIlllIlIIlIIlllIl) throws BadBytecode {
            final Map<Integer, Mark> lllllllllllllIIIIlllIlIIlIlIIIll = this.makeMarks(lllllllllllllIIIIlllIlIIlIlIIlll, lllllllllllllIIIIlllIlIIlIlIIllI, lllllllllllllIIIIlllIlIIlIIllllI, lllllllllllllIIIIlllIlIIlIIlllIl);
            final BasicBlock[] lllllllllllllIIIIlllIlIIlIlIIIlI = this.makeBlocks(lllllllllllllIIIIlllIlIIlIlIIIll);
            this.addCatchers(lllllllllllllIIIIlllIlIIlIlIIIlI, lllllllllllllIIIIlllIlIIlIIlllIl);
            return lllllllllllllIIIIlllIlIIlIlIIIlI;
        }
        
        private Map<Integer, Mark> makeMarks(final CodeIterator lllllllllllllIIIIlllIlIIIlIIIIll, final int lllllllllllllIIIIlllIlIIIIllllII, final int lllllllllllllIIIIlllIlIIIlIIIIIl, final ExceptionTable lllllllllllllIIIIlllIlIIIIlllIlI) throws BadBytecode {
            lllllllllllllIIIIlllIlIIIlIIIIll.begin();
            lllllllllllllIIIIlllIlIIIlIIIIll.move(lllllllllllllIIIIlllIlIIIIllllII);
            final Map<Integer, Mark> lllllllllllllIIIIlllIlIIIIllllll = new HashMap<Integer, Mark>();
            while (lllllllllllllIIIIlllIlIIIlIIIIll.hasNext()) {
                final int lllllllllllllIIIIlllIlIIIlIIIlll = lllllllllllllIIIIlllIlIIIlIIIIll.next();
                if (lllllllllllllIIIIlllIlIIIlIIIlll >= lllllllllllllIIIIlllIlIIIlIIIIIl) {
                    break;
                }
                final int lllllllllllllIIIIlllIlIIIlIIIllI = lllllllllllllIIIIlllIlIIIlIIIIll.byteAt(lllllllllllllIIIIlllIlIIIlIIIlll);
                if ((153 <= lllllllllllllIIIIlllIlIIIlIIIllI && lllllllllllllIIIIlllIlIIIlIIIllI <= 166) || lllllllllllllIIIIlllIlIIIlIIIllI == 198 || lllllllllllllIIIIlllIlIIIlIIIllI == 199) {
                    final Mark lllllllllllllIIIIlllIlIIIlIlIlll = this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s16bitAt(lllllllllllllIIIIlllIlIIIlIIIlll + 1));
                    final Mark lllllllllllllIIIIlllIlIIIlIlIllI = this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll + 3);
                    this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, this.makeArray(lllllllllllllIIIIlllIlIIIlIlIlll.block, lllllllllllllIIIIlllIlIIIlIlIllI.block), 3, false);
                }
                else if (167 <= lllllllllllllIIIIlllIlIIIlIIIllI && lllllllllllllIIIIlllIlIIIlIIIllI <= 171) {
                    switch (lllllllllllllIIIIlllIlIIIlIIIllI) {
                        case 167: {
                            this.makeGoto(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s16bitAt(lllllllllllllIIIIlllIlIIIlIIIlll + 1), 3);
                            continue;
                        }
                        case 168: {
                            this.makeJsr(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s16bitAt(lllllllllllllIIIIlllIlIIIlIIIlll + 1), 3);
                            continue;
                        }
                        case 169: {
                            this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, null, 2, true);
                            continue;
                        }
                        case 170: {
                            final int lllllllllllllIIIIlllIlIIIlIlIlIl = (lllllllllllllIIIIlllIlIIIlIIIlll & 0xFFFFFFFC) + 4;
                            final int lllllllllllllIIIIlllIlIIIlIlIlII = lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIlIlIl + 4);
                            final int lllllllllllllIIIIlllIlIIIlIlIIll = lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIlIlIl + 8);
                            final int lllllllllllllIIIIlllIlIIIlIlIIlI = lllllllllllllIIIIlllIlIIIlIlIIll - lllllllllllllIIIIlllIlIIIlIlIlII + 1;
                            final BasicBlock[] lllllllllllllIIIIlllIlIIIlIlIIIl = this.makeArray(lllllllllllllIIIIlllIlIIIlIlIIlI + 1);
                            lllllllllllllIIIIlllIlIIIlIlIIIl[0] = this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIlIlIl)).block;
                            int lllllllllllllIIIIlllIlIIIlIlIIII = lllllllllllllIIIIlllIlIIIlIlIlIl + 12;
                            final int lllllllllllllIIIIlllIlIIIlIIllll = lllllllllllllIIIIlllIlIIIlIlIIII + lllllllllllllIIIIlllIlIIIlIlIIlI * 4;
                            int lllllllllllllIIIIlllIlIIIlIIlllI = 1;
                            while (lllllllllllllIIIIlllIlIIIlIlIIII < lllllllllllllIIIIlllIlIIIlIIllll) {
                                lllllllllllllIIIIlllIlIIIlIlIIIl[lllllllllllllIIIIlllIlIIIlIIlllI++] = this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIlIIII)).block;
                                lllllllllllllIIIIlllIlIIIlIlIIII += 4;
                            }
                            this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, lllllllllllllIIIIlllIlIIIlIlIIIl, lllllllllllllIIIIlllIlIIIlIIllll - lllllllllllllIIIIlllIlIIIlIIIlll, true);
                            continue;
                        }
                        case 171: {
                            final int lllllllllllllIIIIlllIlIIIlIIllIl = (lllllllllllllIIIIlllIlIIIlIIIlll & 0xFFFFFFFC) + 4;
                            final int lllllllllllllIIIIlllIlIIIlIIllII = lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIIllIl + 4);
                            final BasicBlock[] lllllllllllllIIIIlllIlIIIlIIlIll = this.makeArray(lllllllllllllIIIIlllIlIIIlIIllII + 1);
                            lllllllllllllIIIIlllIlIIIlIIlIll[0] = this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIIllIl)).block;
                            int lllllllllllllIIIIlllIlIIIlIIlIlI = lllllllllllllIIIIlllIlIIIlIIllIl + 8 + 4;
                            final int lllllllllllllIIIIlllIlIIIlIIlIIl = lllllllllllllIIIIlllIlIIIlIIlIlI + lllllllllllllIIIIlllIlIIIlIIllII * 8 - 4;
                            int lllllllllllllIIIIlllIlIIIlIIlIII = 1;
                            while (lllllllllllllIIIIlllIlIIIlIIlIlI < lllllllllllllIIIIlllIlIIIlIIlIIl) {
                                lllllllllllllIIIIlllIlIIIlIIlIll[lllllllllllllIIIIlllIlIIIlIIlIII++] = this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIIlIlI)).block;
                                lllllllllllllIIIIlllIlIIIlIIlIlI += 8;
                            }
                            this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, lllllllllllllIIIIlllIlIIIlIIlIll, lllllllllllllIIIIlllIlIIIlIIlIIl - lllllllllllllIIIIlllIlIIIlIIIlll, true);
                            continue;
                        }
                    }
                }
                else if ((172 <= lllllllllllllIIIIlllIlIIIlIIIllI && lllllllllllllIIIIlllIlIIIlIIIllI <= 177) || lllllllllllllIIIIlllIlIIIlIIIllI == 191) {
                    this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, null, 1, true);
                }
                else if (lllllllllllllIIIIlllIlIIIlIIIllI == 200) {
                    this.makeGoto(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIIIlll + 1), 5);
                }
                else if (lllllllllllllIIIIlllIlIIIlIIIllI == 201) {
                    this.makeJsr(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, lllllllllllllIIIIlllIlIIIlIIIlll + lllllllllllllIIIIlllIlIIIlIIIIll.s32bitAt(lllllllllllllIIIIlllIlIIIlIIIlll + 1), 5);
                }
                else {
                    if (lllllllllllllIIIIlllIlIIIlIIIllI != 196 || lllllllllllllIIIIlllIlIIIlIIIIll.byteAt(lllllllllllllIIIIlllIlIIIlIIIlll + 1) != 169) {
                        continue;
                    }
                    this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIlIIIlll, null, 4, true);
                }
            }
            if (lllllllllllllIIIIlllIlIIIIlllIlI != null) {
                int lllllllllllllIIIIlllIlIIIlIIIlIl = lllllllllllllIIIIlllIlIIIIlllIlI.size();
                while (--lllllllllllllIIIIlllIlIIIlIIIlIl >= 0) {
                    this.makeMark0(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIIlllIlI.startPc(lllllllllllllIIIIlllIlIIIlIIIlIl), true, false);
                    this.makeMark(lllllllllllllIIIIlllIlIIIIllllll, lllllllllllllIIIIlllIlIIIIlllIlI.handlerPc(lllllllllllllIIIIlllIlIIIlIIIlIl));
                }
            }
            return lllllllllllllIIIIlllIlIIIIllllll;
        }
    }
}
