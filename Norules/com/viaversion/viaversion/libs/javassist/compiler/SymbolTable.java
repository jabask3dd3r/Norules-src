package com.viaversion.viaversion.libs.javassist.compiler;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public final class SymbolTable extends HashMap<String, Declarator>
{
    private /* synthetic */ SymbolTable parent;
    
    public SymbolTable(final SymbolTable lllllllllllllllIlIIllIIllIllIIII) {
        this.parent = lllllllllllllllIlIIllIIllIllIIII;
    }
    
    public SymbolTable getParent() {
        return this.parent;
    }
    
    public Declarator lookup(final String lllllllllllllllIlIIllIIllIlIIIll) {
        final Declarator lllllllllllllllIlIIllIIllIlIIlIl = ((HashMap<K, Declarator>)this).get(lllllllllllllllIlIIllIIllIlIIIll);
        if (lllllllllllllllIlIIllIIllIlIIlIl == null && this.parent != null) {
            return this.parent.lookup(lllllllllllllllIlIIllIIllIlIIIll);
        }
        return lllllllllllllllIlIIllIIllIlIIlIl;
    }
    
    public void append(final String lllllllllllllllIlIIllIIllIIlllIl, final Declarator lllllllllllllllIlIIllIIllIIlllII) {
        this.put(lllllllllllllllIlIIllIIllIIlllIl, lllllllllllllllIlIIllIIllIIlllII);
    }
    
    public SymbolTable() {
        this(null);
    }
}
