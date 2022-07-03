package com.viaversion.viaversion.libs.kyori.adventure.util;

import java.util.*;
import org.jetbrains.annotations.*;
import java.util.function.*;
import java.util.concurrent.*;

public abstract class Listenable<L>
{
    private final /* synthetic */ List<L> listeners;
    
    protected final void addListener0(@NotNull final L lllllllllllllllIlIlIIllIIIlIlIlI) {
        this.listeners.add(lllllllllllllllIlIlIIllIIIlIlIlI);
    }
    
    protected final void forEachListener(@NotNull final Consumer<L> lllllllllllllllIlIlIIllIIIllIlII) {
        for (final L lllllllllllllllIlIlIIllIIIllIIll : this.listeners) {
            lllllllllllllllIlIlIIllIIIllIlII.accept(lllllllllllllllIlIlIIllIIIllIIll);
        }
    }
    
    protected final void removeListener0(@NotNull final L lllllllllllllllIlIlIIllIIIlIIIll) {
        this.listeners.remove(lllllllllllllllIlIlIIllIIIlIIIll);
    }
    
    public Listenable() {
        this.listeners = new CopyOnWriteArrayList<L>();
    }
}
