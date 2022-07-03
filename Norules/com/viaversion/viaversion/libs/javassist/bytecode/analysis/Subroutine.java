package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import java.util.*;

public class Subroutine
{
    private /* synthetic */ Set<Integer> access;
    private /* synthetic */ int start;
    private /* synthetic */ List<Integer> callers;
    
    public Collection<Integer> callers() {
        return this.callers;
    }
    
    public Subroutine(final int llllllllllllllIIIlIlIllIIlIIlllI, final int llllllllllllllIIIlIlIllIIlIIllIl) {
        this.callers = new ArrayList<Integer>();
        this.access = new HashSet<Integer>();
        this.start = llllllllllllllIIIlIlIllIIlIIlllI;
        this.callers.add(llllllllllllllIIIlIlIllIIlIIllIl);
    }
    
    public int start() {
        return this.start;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("start = ").append(this.start).append(" callers = ").append(this.callers.toString()));
    }
    
    public void addCaller(final int llllllllllllllIIIlIlIllIIlIIlIIl) {
        this.callers.add(llllllllllllllIIIlIlIllIIlIIlIIl);
    }
    
    public void access(final int llllllllllllllIIIlIlIllIIlIIIIII) {
        this.access.add(llllllllllllllIIIlIlIllIIlIIIIII);
    }
    
    public Collection<Integer> accessed() {
        return this.access;
    }
    
    public boolean isAccessed(final int llllllllllllllIIIlIlIllIIIlllIII) {
        return this.access.contains(llllllllllllllIIIlIlIllIIIlllIII);
    }
}
