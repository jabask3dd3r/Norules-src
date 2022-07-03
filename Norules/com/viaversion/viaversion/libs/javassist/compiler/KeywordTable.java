package com.viaversion.viaversion.libs.javassist.compiler;

import java.util.*;

public final class KeywordTable extends HashMap<String, Integer>
{
    public int lookup(final String lllllllllllllIlIIlllIIIlllllllll) {
        return this.containsKey(lllllllllllllIlIIlllIIIlllllllll) ? ((HashMap<K, Integer>)this).get(lllllllllllllIlIIlllIIIlllllllll) : -1;
    }
    
    public void append(final String lllllllllllllIlIIlllIIIllllllIII, final int lllllllllllllIlIIlllIIIlllllIlII) {
        this.put(lllllllllllllIlIIlllIIIllllllIII, lllllllllllllIlIIlllIIIlllllIlII);
    }
}
