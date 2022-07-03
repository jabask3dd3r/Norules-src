package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.bytecode.stackmap.*;
import java.util.*;

public class ControlFlow
{
    private /* synthetic */ CtClass clazz;
    private /* synthetic */ Block[] basicBlocks;
    private /* synthetic */ MethodInfo methodInfo;
    private /* synthetic */ Frame[] frames;
    
    public ControlFlow(final CtMethod lllllllllllllIlIIllllllIlIlIIIlI) throws BadBytecode {
        this(lllllllllllllIlIIllllllIlIlIIIlI.getDeclaringClass(), lllllllllllllIlIIllllllIlIlIIIlI.getMethodInfo2());
    }
    
    public Frame frameAt(final int lllllllllllllIlIIllllllIIllllIIl) throws BadBytecode {
        if (this.frames == null) {
            this.frames = new Analyzer().analyze(this.clazz, this.methodInfo);
        }
        return this.frames[lllllllllllllIlIIllllllIIllllIIl];
    }
    
    public Node[] postDominatorTree() {
        final int lllllllllllllIlIIllllllIIlIlIIlI = this.basicBlocks.length;
        if (lllllllllllllIlIIllllllIIlIlIIlI == 0) {
            return null;
        }
        final Node[] lllllllllllllIlIIllllllIIlIlIIIl = new Node[lllllllllllllIlIIllllllIIlIlIIlI];
        final boolean[] lllllllllllllIlIIllllllIIlIlIIII = new boolean[lllllllllllllIlIIllllllIIlIlIIlI];
        final int[] lllllllllllllIlIIllllllIIlIIllll = new int[lllllllllllllIlIIllllllIIlIlIIlI];
        for (int lllllllllllllIlIIllllllIIlIlIlll = 0; lllllllllllllIlIIllllllIIlIlIlll < lllllllllllllIlIIllllllIIlIlIIlI; ++lllllllllllllIlIIllllllIIlIlIlll) {
            lllllllllllllIlIIllllllIIlIlIIIl[lllllllllllllIlIIllllllIIlIlIlll] = new Node(this.basicBlocks[lllllllllllllIlIIllllllIIlIlIlll]);
            lllllllllllllIlIIllllllIIlIlIIII[lllllllllllllIlIIllllllIIlIlIlll] = false;
        }
        final Access lllllllllllllIlIIllllllIIlIIlllI = new Access(lllllllllllllIlIIllllllIIlIlIIIl) {
            @Override
            BasicBlock[] entrances(final Node lllllllllllllIlIIIIllllIIIllllll) {
                return lllllllllllllIlIIIIllllIIIllllll.block.getExit();
            }
            
            @Override
            BasicBlock[] exits(final Node lllllllllllllIlIIIIllllIIlIIIlII) {
                return lllllllllllllIlIIIIllllIIlIIIlII.block.entrances;
            }
        };
        int lllllllllllllIlIIllllllIIlIIllIl = 0;
        for (int lllllllllllllIlIIllllllIIlIlIllI = 0; lllllllllllllIlIIllllllIIlIlIllI < lllllllllllllIlIIllllllIIlIlIIlI; ++lllllllllllllIlIIllllllIIlIlIllI) {
            if (lllllllllllllIlIIllllllIIlIlIIIl[lllllllllllllIlIIllllllIIlIlIllI].block.exits() == 0) {
                lllllllllllllIlIIllllllIIlIIllIl = lllllllllllllIlIIllllllIIlIlIIIl[lllllllllllllIlIIllllllIIlIlIllI].makeDepth1stTree(null, lllllllllllllIlIIllllllIIlIlIIII, lllllllllllllIlIIllllllIIlIIllIl, lllllllllllllIlIIllllllIIlIIllll, lllllllllllllIlIIllllllIIlIIlllI);
            }
        }
        boolean lllllllllllllIlIIllllllIIlIIllII;
        do {
            for (int lllllllllllllIlIIllllllIIlIlIlIl = 0; lllllllllllllIlIIllllllIIlIlIlIl < lllllllllllllIlIIllllllIIlIlIIlI; ++lllllllllllllIlIIllllllIIlIlIlIl) {
                lllllllllllllIlIIllllllIIlIlIIII[lllllllllllllIlIIllllllIIlIlIlIl] = false;
            }
            lllllllllllllIlIIllllllIIlIIllII = false;
            for (int lllllllllllllIlIIllllllIIlIlIlII = 0; lllllllllllllIlIIllllllIIlIlIlII < lllllllllllllIlIIllllllIIlIlIIlI; ++lllllllllllllIlIIllllllIIlIlIlII) {
                if (lllllllllllllIlIIllllllIIlIlIIIl[lllllllllllllIlIIllllllIIlIlIlII].block.exits() == 0 && lllllllllllllIlIIllllllIIlIlIIIl[lllllllllllllIlIIllllllIIlIlIlII].makeDominatorTree(lllllllllllllIlIIllllllIIlIlIIII, lllllllllllllIlIIllllllIIlIIllll, lllllllllllllIlIIllllllIIlIIlllI)) {
                    lllllllllllllIlIIllllllIIlIIllII = true;
                }
            }
        } while (lllllllllllllIlIIllllllIIlIIllII);
        setChildren(lllllllllllllIlIIllllllIIlIlIIIl);
        return lllllllllllllIlIIllllllIIlIlIIIl;
    }
    
    public Node[] dominatorTree() {
        final int lllllllllllllIlIIllllllIIllIllII = this.basicBlocks.length;
        if (lllllllllllllIlIIllllllIIllIllII == 0) {
            return null;
        }
        final Node[] lllllllllllllIlIIllllllIIllIlIll = new Node[lllllllllllllIlIIllllllIIllIllII];
        final boolean[] lllllllllllllIlIIllllllIIllIlIlI = new boolean[lllllllllllllIlIIllllllIIllIllII];
        final int[] lllllllllllllIlIIllllllIIllIlIIl = new int[lllllllllllllIlIIllllllIIllIllII];
        for (int lllllllllllllIlIIllllllIIllIllll = 0; lllllllllllllIlIIllllllIIllIllll < lllllllllllllIlIIllllllIIllIllII; ++lllllllllllllIlIIllllllIIllIllll) {
            lllllllllllllIlIIllllllIIllIlIll[lllllllllllllIlIIllllllIIllIllll] = new Node(this.basicBlocks[lllllllllllllIlIIllllllIIllIllll]);
            lllllllllllllIlIIllllllIIllIlIlI[lllllllllllllIlIIllllllIIllIllll] = false;
        }
        final Access lllllllllllllIlIIllllllIIllIlIII = new Access(lllllllllllllIlIIllllllIIllIlIll) {
            @Override
            BasicBlock[] entrances(final Node lllllllllllllIIIIIlllIllIlIIIIIl) {
                return lllllllllllllIIIIIlllIllIlIIIIIl.block.entrances;
            }
            
            @Override
            BasicBlock[] exits(final Node lllllllllllllIIIIIlllIllIlIIIllI) {
                return lllllllllllllIIIIIlllIllIlIIIllI.block.getExit();
            }
        };
        lllllllllllllIlIIllllllIIllIlIll[0].makeDepth1stTree(null, lllllllllllllIlIIllllllIIllIlIlI, 0, lllllllllllllIlIIllllllIIllIlIIl, lllllllllllllIlIIllllllIIllIlIII);
        do {
            for (int lllllllllllllIlIIllllllIIllIlllI = 0; lllllllllllllIlIIllllllIIllIlllI < lllllllllllllIlIIllllllIIllIllII; ++lllllllllllllIlIIllllllIIllIlllI) {
                lllllllllllllIlIIllllllIIllIlIlI[lllllllllllllIlIIllllllIIllIlllI] = false;
            }
        } while (lllllllllllllIlIIllllllIIllIlIll[0].makeDominatorTree(lllllllllllllIlIIllllllIIllIlIlI, lllllllllllllIlIIllllllIIllIlIIl, lllllllllllllIlIIllllllIIllIlIII));
        setChildren(lllllllllllllIlIIllllllIIllIlIll);
        return lllllllllllllIlIIllllllIIllIlIll;
    }
    
    public Block[] basicBlocks() {
        return this.basicBlocks;
    }
    
    public ControlFlow(final CtClass lllllllllllllIlIIllllllIlIIIlIII, final MethodInfo lllllllllllllIlIIllllllIlIIIIlll) throws BadBytecode {
        this.clazz = lllllllllllllIlIIllllllIlIIIlIII;
        this.methodInfo = lllllllllllllIlIIllllllIlIIIIlll;
        this.frames = null;
        this.basicBlocks = (Block[])new BasicBlock.Maker() {
            @Override
            protected BasicBlock makeBlock(final int lllllllllllllllIIllIllllIIIllIlI) {
                return new Block(lllllllllllllllIIllIllllIIIllIlI, ControlFlow.this.methodInfo);
            }
            
            @Override
            protected BasicBlock[] makeArray(final int lllllllllllllllIIllIllllIIIlIlll) {
                return new Block[lllllllllllllllIIllIllllIIIlIlll];
            }
        }.make(lllllllllllllIlIIllllllIlIIIIlll);
        if (this.basicBlocks == null) {
            this.basicBlocks = new Block[0];
        }
        final int lllllllllllllIlIIllllllIlIIIlIll = this.basicBlocks.length;
        final int[] lllllllllllllIlIIllllllIlIIIlIlI = new int[lllllllllllllIlIIllllllIlIIIlIll];
        for (int lllllllllllllIlIIllllllIlIIlIllI = 0; lllllllllllllIlIIllllllIlIIlIllI < lllllllllllllIlIIllllllIlIIIlIll; ++lllllllllllllIlIIllllllIlIIlIllI) {
            final Block lllllllllllllIlIIllllllIlIIlIlll = this.basicBlocks[lllllllllllllIlIIllllllIlIIlIllI];
            lllllllllllllIlIIllllllIlIIlIlll.index = lllllllllllllIlIIllllllIlIIlIllI;
            lllllllllllllIlIIllllllIlIIlIlll.entrances = new Block[lllllllllllllIlIIllllllIlIIlIlll.incomings()];
            lllllllllllllIlIIllllllIlIIIlIlI[lllllllllllllIlIIllllllIlIIlIllI] = 0;
        }
        for (int lllllllllllllIlIIllllllIlIIIllll = 0; lllllllllllllIlIIllllllIlIIIllll < lllllllllllllIlIIllllllIlIIIlIll; ++lllllllllllllIlIIllllllIlIIIllll) {
            final Block lllllllllllllIlIIllllllIlIIlIIIl = this.basicBlocks[lllllllllllllIlIIllllllIlIIIllll];
            for (int lllllllllllllIlIIllllllIlIIlIlII = 0; lllllllllllllIlIIllllllIlIIlIlII < lllllllllllllIlIIllllllIlIIlIIIl.exits(); ++lllllllllllllIlIIllllllIlIIlIlII) {
                final Block lllllllllllllIlIIllllllIlIIlIlIl = lllllllllllllIlIIllllllIlIIlIIIl.exit(lllllllllllllIlIIllllllIlIIlIlII);
                lllllllllllllIlIIllllllIlIIlIlIl.entrances[lllllllllllllIlIIllllllIlIIIlIlI[lllllllllllllIlIIllllllIlIIlIlIl.index]++] = lllllllllllllIlIIllllllIlIIlIIIl;
            }
            final Catcher[] lllllllllllllIlIIllllllIlIIlIIII = lllllllllllllIlIIllllllIlIIlIIIl.catchers();
            for (int lllllllllllllIlIIllllllIlIIlIIlI = 0; lllllllllllllIlIIllllllIlIIlIIlI < lllllllllllllIlIIllllllIlIIlIIII.length; ++lllllllllllllIlIIllllllIlIIlIIlI) {
                final Block lllllllllllllIlIIllllllIlIIlIIll = lllllllllllllIlIIllllllIlIIlIIII[lllllllllllllIlIIllllllIlIIlIIlI].node;
                lllllllllllllIlIIllllllIlIIlIIll.entrances[lllllllllllllIlIIllllllIlIIIlIlI[lllllllllllllIlIIllllllIlIIlIIll.index]++] = lllllllllllllIlIIllllllIlIIlIIIl;
            }
        }
    }
    
    abstract static class Access
    {
        /* synthetic */ Node[] all;
        
        Access(final Node[] lllllllllllllIllIIIlIlIIIIIlIlll) {
            this.all = lllllllllllllIllIIIlIlIIIIIlIlll;
        }
        
        abstract BasicBlock[] exits(final Node p0);
        
        Node node(final BasicBlock lllllllllllllIllIIIlIlIIIIIlIIIl) {
            return this.all[((Block)lllllllllllllIllIIIlIlIIIIIlIIIl).index];
        }
        
        abstract BasicBlock[] entrances(final Node p0);
    }
    
    public static class Block extends BasicBlock
    {
        /* synthetic */ MethodInfo method;
        /* synthetic */ Block[] entrances;
        public /* synthetic */ Object clientData;
        /* synthetic */ int index;
        
        Block(final int lllllllllllllIlIllllllIIlIlIlIIl, final MethodInfo lllllllllllllIlIllllllIIlIlIlIll) {
            super(lllllllllllllIlIllllllIIlIlIlIIl);
            this.clientData = null;
            this.method = lllllllllllllIlIllllllIIlIlIlIll;
        }
        
        @Override
        protected void toString2(final StringBuffer lllllllllllllIlIllllllIIlIlIIIII) {
            super.toString2(lllllllllllllIlIllllllIIlIlIIIII);
            lllllllllllllIlIllllllIIlIlIIIII.append(", incoming{");
            for (int lllllllllllllIlIllllllIIlIlIIlII = 0; lllllllllllllIlIllllllIIlIlIIlII < this.entrances.length; ++lllllllllllllIlIllllllIIlIlIIlII) {
                lllllllllllllIlIllllllIIlIlIIIII.append(this.entrances[lllllllllllllIlIllllllIIlIlIIlII].position).append(", ");
            }
            lllllllllllllIlIllllllIIlIlIIIII.append("}");
        }
        
        public Block exit(final int lllllllllllllIlIllllllIIlIIIIIIl) {
            return (Block)this.exit[lllllllllllllIlIllllllIIlIIIIIIl];
        }
        
        public int position() {
            return this.position;
        }
        
        public Catcher[] catchers() {
            final List<Catcher> lllllllllllllIlIllllllIIIlllllII = new ArrayList<Catcher>();
            for (Catch lllllllllllllIlIllllllIIIllllIll = this.toCatch; lllllllllllllIlIllllllIIIllllIll != null; lllllllllllllIlIllllllIIIllllIll = lllllllllllllIlIllllllIIIllllIll.next) {
                lllllllllllllIlIllllllIIIlllllII.add(new Catcher(lllllllllllllIlIllllllIIIllllIll));
            }
            return lllllllllllllIlIllllllIIIlllllII.toArray(new Catcher[lllllllllllllIlIllllllIIIlllllII.size()]);
        }
        
        BasicBlock[] getExit() {
            return this.exit;
        }
        
        public int index() {
            return this.index;
        }
        
        public int length() {
            return this.length;
        }
        
        public Block incoming(final int lllllllllllllIlIllllllIIlIIIlIlI) {
            return this.entrances[lllllllllllllIlIllllllIIlIIIlIlI];
        }
        
        public int exits() {
            return (this.exit == null) ? 0 : this.exit.length;
        }
        
        public int incomings() {
            return this.incoming;
        }
    }
    
    public static class Catcher
    {
        private /* synthetic */ Block node;
        private /* synthetic */ int typeIndex;
        
        Catcher(final BasicBlock.Catch lllllllllllllIlllIIllllllIllIllI) {
            this.node = (Block)lllllllllllllIlllIIllllllIllIllI.body;
            this.typeIndex = lllllllllllllIlllIIllllllIllIllI.typeIndex;
        }
        
        public String type() {
            if (this.typeIndex == 0) {
                return "java.lang.Throwable";
            }
            return this.node.method.getConstPool().getClassInfo(this.typeIndex);
        }
        
        public Block block() {
            return this.node;
        }
    }
    
    public static class Node
    {
        private /* synthetic */ Node parent;
        private /* synthetic */ Node[] children;
        private /* synthetic */ Block block;
        
        Node(final Block lllllllllllllllIllIlIIIllIlIIlll) {
            this.block = lllllllllllllllIllIlIIIllIlIIlll;
            this.parent = null;
        }
        
        public Node parent() {
            return this.parent;
        }
        
        private static void setChildren(final Node[] lllllllllllllllIllIlIIIlIIlllIIl) {
            final int lllllllllllllllIllIlIIIlIIlllIII = lllllllllllllllIllIlIIIlIIlllIIl.length;
            final int[] lllllllllllllllIllIlIIIlIIllIlll = new int[lllllllllllllllIllIlIIIlIIlllIII];
            for (int lllllllllllllllIllIlIIIlIlIIIIIl = 0; lllllllllllllllIllIlIIIlIlIIIIIl < lllllllllllllllIllIlIIIlIIlllIII; ++lllllllllllllllIllIlIIIlIlIIIIIl) {
                lllllllllllllllIllIlIIIlIIllIlll[lllllllllllllllIllIlIIIlIlIIIIIl] = 0;
            }
            for (int lllllllllllllllIllIlIIIlIIllllll = 0; lllllllllllllllIllIlIIIlIIllllll < lllllllllllllllIllIlIIIlIIlllIII; ++lllllllllllllllIllIlIIIlIIllllll) {
                final Node lllllllllllllllIllIlIIIlIlIIIIII = lllllllllllllllIllIlIIIlIIlllIIl[lllllllllllllllIllIlIIIlIIllllll].parent;
                if (lllllllllllllllIllIlIIIlIlIIIIII != null) {
                    final int[] array = lllllllllllllllIllIlIIIlIIllIlll;
                    final int index = lllllllllllllllIllIlIIIlIlIIIIII.block.index;
                    ++array[index];
                }
            }
            for (int lllllllllllllllIllIlIIIlIIlllllI = 0; lllllllllllllllIllIlIIIlIIlllllI < lllllllllllllllIllIlIIIlIIlllIII; ++lllllllllllllllIllIlIIIlIIlllllI) {
                lllllllllllllllIllIlIIIlIIlllIIl[lllllllllllllllIllIlIIIlIIlllllI].children = new Node[lllllllllllllllIllIlIIIlIIllIlll[lllllllllllllllIllIlIIIlIIlllllI]];
            }
            for (int lllllllllllllllIllIlIIIlIIllllIl = 0; lllllllllllllllIllIlIIIlIIllllIl < lllllllllllllllIllIlIIIlIIlllIII; ++lllllllllllllllIllIlIIIlIIllllIl) {
                lllllllllllllllIllIlIIIlIIllIlll[lllllllllllllllIllIlIIIlIIllllIl] = 0;
            }
            for (final Node lllllllllllllllIllIlIIIlIIllllII : lllllllllllllllIllIlIIIlIIlllIIl) {
                final Node lllllllllllllllIllIlIIIlIIlllIll = lllllllllllllllIllIlIIIlIIllllII.parent;
                if (lllllllllllllllIllIlIIIlIIlllIll != null) {
                    lllllllllllllllIllIlIIIlIIlllIll.children[lllllllllllllllIllIlIIIlIIllIlll[lllllllllllllllIllIlIIIlIIlllIll.block.index]++] = lllllllllllllllIllIlIIIlIIllllII;
                }
            }
        }
        
        boolean makeDominatorTree(final boolean[] lllllllllllllllIllIlIIIlIllIIIIl, final int[] lllllllllllllllIllIlIIIlIlIllIII, final Access lllllllllllllllIllIlIIIlIlIlllll) {
            final int lllllllllllllllIllIlIIIlIlIllllI = this.block.index;
            if (lllllllllllllllIllIlIIIlIllIIIIl[lllllllllllllllIllIlIIIlIlIllllI]) {
                return false;
            }
            lllllllllllllllIllIlIIIlIllIIIIl[lllllllllllllllIllIlIIIlIlIllllI] = true;
            boolean lllllllllllllllIllIlIIIlIlIlllIl = false;
            final BasicBlock[] lllllllllllllllIllIlIIIlIlIlllII = lllllllllllllllIllIlIIIlIlIlllll.exits(this);
            if (lllllllllllllllIllIlIIIlIlIlllII != null) {
                for (int lllllllllllllllIllIlIIIlIllIIlIl = 0; lllllllllllllllIllIlIIIlIllIIlIl < lllllllllllllllIllIlIIIlIlIlllII.length; ++lllllllllllllllIllIlIIIlIllIIlIl) {
                    final Node lllllllllllllllIllIlIIIlIllIIllI = lllllllllllllllIllIlIIIlIlIlllll.node(lllllllllllllllIllIlIIIlIlIlllII[lllllllllllllllIllIlIIIlIllIIlIl]);
                    if (lllllllllllllllIllIlIIIlIllIIllI.makeDominatorTree(lllllllllllllllIllIlIIIlIllIIIIl, lllllllllllllllIllIlIIIlIlIllIII, lllllllllllllllIllIlIIIlIlIlllll)) {
                        lllllllllllllllIllIlIIIlIlIlllIl = true;
                    }
                }
            }
            final BasicBlock[] lllllllllllllllIllIlIIIlIlIllIll = lllllllllllllllIllIlIIIlIlIlllll.entrances(this);
            if (lllllllllllllllIllIlIIIlIlIllIll != null) {
                for (int lllllllllllllllIllIlIIIlIllIIIll = 0; lllllllllllllllIllIlIIIlIllIIIll < lllllllllllllllIllIlIIIlIlIllIll.length; ++lllllllllllllllIllIlIIIlIllIIIll) {
                    if (this.parent != null) {
                        final Node lllllllllllllllIllIlIIIlIllIIlII = getAncestor(this.parent, lllllllllllllllIllIlIIIlIlIlllll.node(lllllllllllllllIllIlIIIlIlIllIll[lllllllllllllllIllIlIIIlIllIIIll]), lllllllllllllllIllIlIIIlIlIllIII);
                        if (lllllllllllllllIllIlIIIlIllIIlII != this.parent) {
                            this.parent = lllllllllllllllIllIlIIIlIllIIlII;
                            lllllllllllllllIllIlIIIlIlIlllIl = true;
                        }
                    }
                }
            }
            return lllllllllllllllIllIlIIIlIlIlllIl;
        }
        
        int makeDepth1stTree(final Node lllllllllllllllIllIlIIIlIllllIIl, final boolean[] lllllllllllllllIllIlIIIllIIIIIII, int lllllllllllllllIllIlIIIlIlllIlll, final int[] lllllllllllllllIllIlIIIlIllllllI, final Access lllllllllllllllIllIlIIIlIlllIlIl) {
            final int lllllllllllllllIllIlIIIlIlllllII = this.block.index;
            if (lllllllllllllllIllIlIIIllIIIIIII[lllllllllllllllIllIlIIIlIlllllII]) {
                return lllllllllllllllIllIlIIIlIlllIlll;
            }
            lllllllllllllllIllIlIIIllIIIIIII[lllllllllllllllIllIlIIIlIlllllII] = true;
            this.parent = lllllllllllllllIllIlIIIlIllllIIl;
            final BasicBlock[] lllllllllllllllIllIlIIIlIllllIll = lllllllllllllllIllIlIIIlIlllIlIl.exits(this);
            if (lllllllllllllllIllIlIIIlIllllIll != null) {
                for (int lllllllllllllllIllIlIIIllIIIIIll = 0; lllllllllllllllIllIlIIIllIIIIIll < lllllllllllllllIllIlIIIlIllllIll.length; ++lllllllllllllllIllIlIIIllIIIIIll) {
                    final Node lllllllllllllllIllIlIIIllIIIIlII = lllllllllllllllIllIlIIIlIlllIlIl.node(lllllllllllllllIllIlIIIlIllllIll[lllllllllllllllIllIlIIIllIIIIIll]);
                    lllllllllllllllIllIlIIIlIlllIlll = lllllllllllllllIllIlIIIllIIIIlII.makeDepth1stTree(this, lllllllllllllllIllIlIIIllIIIIIII, lllllllllllllllIllIlIIIlIlllIlll, lllllllllllllllIllIlIIIlIllllllI, lllllllllllllllIllIlIIIlIlllIlIl);
                }
            }
            lllllllllllllllIllIlIIIlIllllllI[lllllllllllllllIllIlIIIlIlllllII] = lllllllllllllllIllIlIIIlIlllIlll++;
            return lllllllllllllllIllIlIIIlIlllIlll;
        }
        
        private static Node getAncestor(Node lllllllllllllllIllIlIIIlIlIIlIlI, Node lllllllllllllllIllIlIIIlIlIIlIIl, final int[] lllllllllllllllIllIlIIIlIlIIlIll) {
            while (lllllllllllllllIllIlIIIlIlIIlIlI != lllllllllllllllIllIlIIIlIlIIlIIl) {
                if (lllllllllllllllIllIlIIIlIlIIlIll[((Node)lllllllllllllllIllIlIIIlIlIIlIlI).block.index] < lllllllllllllllIllIlIIIlIlIIlIll[((Node)lllllllllllllllIllIlIIIlIlIIlIIl).block.index]) {
                    lllllllllllllllIllIlIIIlIlIIlIlI = ((Node)lllllllllllllllIllIlIIIlIlIIlIlI).parent;
                }
                else {
                    lllllllllllllllIllIlIIIlIlIIlIIl = ((Node)lllllllllllllllIllIlIIIlIlIIlIIl).parent;
                }
                if (lllllllllllllllIllIlIIIlIlIIlIlI == null || lllllllllllllllIllIlIIIlIlIIlIIl == null) {
                    return null;
                }
            }
            return (Node)lllllllllllllllIllIlIIIlIlIIlIlI;
        }
        
        public Node child(final int lllllllllllllllIllIlIIIllIIlIIIl) {
            return this.children[lllllllllllllllIllIlIIIllIIlIIIl];
        }
        
        @Override
        public String toString() {
            final StringBuffer lllllllllllllllIllIlIIIllIlIIIIl = new StringBuffer();
            lllllllllllllllIllIlIIIllIlIIIIl.append("Node[pos=").append(this.block().position());
            lllllllllllllllIllIlIIIllIlIIIIl.append(", parent=");
            lllllllllllllllIllIlIIIllIlIIIIl.append((this.parent == null) ? "*" : Integer.toString(this.parent.block().position()));
            lllllllllllllllIllIlIIIllIlIIIIl.append(", children{");
            for (int lllllllllllllllIllIlIIIllIlIIIll = 0; lllllllllllllllIllIlIIIllIlIIIll < this.children.length; ++lllllllllllllllIllIlIIIllIlIIIll) {
                lllllllllllllllIllIlIIIllIlIIIIl.append(this.children[lllllllllllllllIllIlIIIllIlIIIll].block().position()).append(", ");
            }
            lllllllllllllllIllIlIIIllIlIIIIl.append("}]");
            return lllllllllllllllIllIlIIIllIlIIIIl.toString();
        }
        
        public int children() {
            return this.children.length;
        }
        
        public Block block() {
            return this.block;
        }
    }
}
