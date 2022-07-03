package com.viaversion.viaversion.libs.javassist.runtime;

public class Cflow extends ThreadLocal<Depth>
{
    public void exit() {
        this.get().dec();
    }
    
    @Override
    protected synchronized Depth initialValue() {
        return new Depth();
    }
    
    public int value() {
        return this.get().value();
    }
    
    public void enter() {
        this.get().inc();
    }
    
    protected static class Depth
    {
        private /* synthetic */ int depth;
        
        int value() {
            return this.depth;
        }
        
        void dec() {
            --this.depth;
        }
        
        Depth() {
            this.depth = 0;
        }
        
        void inc() {
            ++this.depth;
        }
    }
}
