package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

public class Frame
{
    private /* synthetic */ boolean jsrMerged;
    private /* synthetic */ boolean retMerged;
    private /* synthetic */ int top;
    private /* synthetic */ Type[] stack;
    private /* synthetic */ Type[] locals;
    
    public void setStack(final int lllllllllllllIllIllIllllllIlIIlI, final Type lllllllllllllIllIllIllllllIlIIIl) {
        this.stack[lllllllllllllIllIllIllllllIlIIlI] = lllllllllllllIllIllIllllllIlIIIl;
    }
    
    public int localsLength() {
        return this.locals.length;
    }
    
    public Type getLocal(final int lllllllllllllIllIllIlllllllIlIIl) {
        return this.locals[lllllllllllllIllIllIlllllllIlIIl];
    }
    
    void setRetMerged(final boolean lllllllllllllIllIllIllllIlllIIlI) {
        this.retMerged = lllllllllllllIllIllIllllIlllIIlI;
    }
    
    public Type pop() {
        if (this.top < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        final Type[] stack = this.stack;
        final int top = this.top - 1;
        this.top = top;
        return stack[top];
    }
    
    public boolean mergeStack(final Frame lllllllllllllIllIllIlllllIlIIIlI) {
        boolean lllllllllllllIllIllIlllllIlIIlII = false;
        if (this.top != lllllllllllllIllIllIlllllIlIIIlI.top) {
            throw new RuntimeException("Operand stacks could not be merged, they are different sizes!");
        }
        for (int lllllllllllllIllIllIlllllIlIIlll = 0; lllllllllllllIllIllIlllllIlIIlll < this.top; ++lllllllllllllIllIllIlllllIlIIlll) {
            if (this.stack[lllllllllllllIllIllIlllllIlIIlll] != null) {
                final Type lllllllllllllIllIllIlllllIlIlIIl = this.stack[lllllllllllllIllIllIlllllIlIIlll];
                final Type lllllllllllllIllIllIlllllIlIlIII = lllllllllllllIllIllIlllllIlIlIIl.merge(lllllllllllllIllIllIlllllIlIIIlI.stack[lllllllllllllIllIllIlllllIlIIlll]);
                if (lllllllllllllIllIllIlllllIlIlIII == Type.BOGUS) {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append("Operand stacks could not be merged due to differing primitive types: pos = ").append(lllllllllllllIllIllIlllllIlIIlll)));
                }
                this.stack[lllllllllllllIllIllIlllllIlIIlll] = lllllllllllllIllIllIlllllIlIlIII;
                if (!lllllllllllllIllIllIlllllIlIlIII.equals(lllllllllllllIllIllIlllllIlIlIIl) || lllllllllllllIllIllIlllllIlIlIII.popChanged()) {
                    lllllllllllllIllIllIlllllIlIIlII = true;
                }
            }
        }
        return lllllllllllllIllIllIlllllIlIIlII;
    }
    
    public boolean merge(final Frame lllllllllllllIllIllIlllllIIlIIll) {
        boolean lllllllllllllIllIllIlllllIIlIIlI = false;
        for (int lllllllllllllIllIllIlllllIIlIlIl = 0; lllllllllllllIllIllIlllllIIlIlIl < this.locals.length; ++lllllllllllllIllIllIlllllIIlIlIl) {
            if (this.locals[lllllllllllllIllIllIlllllIIlIlIl] != null) {
                final Type lllllllllllllIllIllIlllllIIlIlll = this.locals[lllllllllllllIllIllIlllllIIlIlIl];
                final Type lllllllllllllIllIllIlllllIIlIllI = lllllllllllllIllIllIlllllIIlIlll.merge(lllllllllllllIllIllIlllllIIlIIll.locals[lllllllllllllIllIllIlllllIIlIlIl]);
                this.locals[lllllllllllllIllIllIlllllIIlIlIl] = lllllllllllllIllIllIlllllIIlIllI;
                if (!lllllllllllllIllIllIlllllIIlIllI.equals(lllllllllllllIllIllIlllllIIlIlll) || lllllllllllllIllIllIlllllIIlIllI.popChanged()) {
                    lllllllllllllIllIllIlllllIIlIIlI = true;
                }
            }
            else if (lllllllllllllIllIllIlllllIIlIIll.locals[lllllllllllllIllIllIlllllIIlIlIl] != null) {
                this.locals[lllllllllllllIllIllIlllllIIlIlIl] = lllllllllllllIllIllIlllllIIlIIll.locals[lllllllllllllIllIllIlllllIIlIlIl];
                lllllllllllllIllIllIlllllIIlIIlI = true;
            }
        }
        lllllllllllllIllIllIlllllIIlIIlI |= this.mergeStack(lllllllllllllIllIllIlllllIIlIIll);
        return lllllllllllllIllIllIlllllIIlIIlI;
    }
    
    public Type getStack(final int lllllllllllllIllIllIllllllIllIlI) {
        return this.stack[lllllllllllllIllIllIllllllIllIlI];
    }
    
    public int getTopIndex() {
        return this.top - 1;
    }
    
    boolean isRetMerged() {
        return this.retMerged;
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIllIllIlllllIIIIlIl = new StringBuffer();
        lllllllllllllIllIllIlllllIIIIlIl.append("locals = [");
        for (int lllllllllllllIllIllIlllllIIIlIII = 0; lllllllllllllIllIllIlllllIIIlIII < this.locals.length; ++lllllllllllllIllIllIlllllIIIlIII) {
            lllllllllllllIllIllIlllllIIIIlIl.append((this.locals[lllllllllllllIllIllIlllllIIIlIII] == null) ? "empty" : this.locals[lllllllllllllIllIllIlllllIIIlIII].toString());
            if (lllllllllllllIllIllIlllllIIIlIII < this.locals.length - 1) {
                lllllllllllllIllIllIlllllIIIIlIl.append(", ");
            }
        }
        lllllllllllllIllIllIlllllIIIIlIl.append("] stack = [");
        for (int lllllllllllllIllIllIlllllIIIIlll = 0; lllllllllllllIllIllIlllllIIIIlll < this.top; ++lllllllllllllIllIllIlllllIIIIlll) {
            lllllllllllllIllIllIlllllIIIIlIl.append(this.stack[lllllllllllllIllIllIlllllIIIIlll]);
            if (lllllllllllllIllIllIlllllIIIIlll < this.top - 1) {
                lllllllllllllIllIllIlllllIIIIlIl.append(", ");
            }
        }
        lllllllllllllIllIllIlllllIIIIlIl.append("]");
        return lllllllllllllIllIllIlllllIIIIlIl.toString();
    }
    
    boolean isJsrMerged() {
        return this.jsrMerged;
    }
    
    public void push(final Type lllllllllllllIllIllIlllllIlllllI) {
        this.stack[this.top++] = lllllllllllllIllIllIlllllIlllllI;
    }
    
    void setJsrMerged(final boolean lllllllllllllIllIllIllllIllllIll) {
        this.jsrMerged = lllllllllllllIllIllIllllIllllIll;
    }
    
    public Type peek() {
        if (this.top < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return this.stack[this.top - 1];
    }
    
    public Frame copy() {
        final Frame lllllllllllllIllIllIlllllIlllIII = new Frame(this.locals.length, this.stack.length);
        System.arraycopy(this.locals, 0, lllllllllllllIllIllIlllllIlllIII.locals, 0, this.locals.length);
        System.arraycopy(this.stack, 0, lllllllllllllIllIllIlllllIlllIII.stack, 0, this.stack.length);
        lllllllllllllIllIllIlllllIlllIII.top = this.top;
        return lllllllllllllIllIllIlllllIlllIII;
    }
    
    public Frame copyStack() {
        final Frame lllllllllllllIllIllIlllllIllIIlI = new Frame(this.locals.length, this.stack.length);
        System.arraycopy(this.stack, 0, lllllllllllllIllIllIlllllIllIIlI.stack, 0, this.stack.length);
        lllllllllllllIllIllIlllllIllIIlI.top = this.top;
        return lllllllllllllIllIllIlllllIllIIlI;
    }
    
    public void setLocal(final int lllllllllllllIllIllIlllllllIIlII, final Type lllllllllllllIllIllIlllllllIIIll) {
        this.locals[lllllllllllllIllIllIlllllllIIlII] = lllllllllllllIllIllIlllllllIIIll;
    }
    
    public Frame(final int lllllllllllllIllIllIllllllllIIII, final int lllllllllllllIllIllIlllllllIllll) {
        this.locals = new Type[lllllllllllllIllIllIllllllllIIII];
        this.stack = new Type[lllllllllllllIllIllIlllllllIllll];
    }
    
    public void clearStack() {
        this.top = 0;
    }
}
