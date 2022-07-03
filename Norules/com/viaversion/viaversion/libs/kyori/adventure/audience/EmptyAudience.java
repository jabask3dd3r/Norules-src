package com.viaversion.viaversion.libs.kyori.adventure.audience;

import com.viaversion.viaversion.libs.kyori.adventure.pointer.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.inventory.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.identity.*;
import java.util.function.*;

final class EmptyAudience implements Audience
{
    @Contract("_, null -> null; _, !null -> !null")
    @Nullable
    @Override
    public <T> T getOrDefault(@NotNull final Pointer<T> lllllllllllllIIIlIIllIIIIIIllllI, @Nullable final T lllllllllllllIIIlIIllIIIIIIlllIl) {
        return lllllllllllllIIIlIIllIIIIIIlllIl;
    }
    
    static {
        INSTANCE = new EmptyAudience();
    }
    
    @NotNull
    @Override
    public <T> Optional<T> get(@NotNull final Pointer<T> lllllllllllllIIIlIIllIIIIIlIIIlI) {
        return Optional.empty();
    }
    
    @Override
    public void openBook(final Book.Builder lllllllllllllIIIlIIlIllllllIIIll) {
    }
    
    @Override
    public void sendMessage(@NotNull final Identity lllllllllllllIIIlIIllIIIIIIIlIIl, @NotNull final ComponentLike lllllllllllllIIIlIIllIIIIIIIlIII) {
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIlIIlIlllllIllllI) {
        return this == lllllllllllllIIIlIIlIlllllIllllI;
    }
    
    @Override
    public void sendMessage(@NotNull final Identified lllllllllllllIIIlIIllIIIIIIIllIl, @NotNull final ComponentLike lllllllllllllIIIlIIllIIIIIIIlllI) {
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "EmptyAudience";
    }
    
    @Override
    public void sendMessage(@NotNull final Identity lllllllllllllIIIlIIlIlllllllIlll, @NotNull final ComponentLike lllllllllllllIIIlIIlIllllllllIII, @NotNull final MessageType lllllllllllllIIIlIIlIlllllllIllI) {
    }
    
    @Override
    public void sendPlayerListFooter(@NotNull final ComponentLike lllllllllllllIIIlIIlIllllllIlIll) {
    }
    
    @Override
    public void sendMessage(@NotNull final Identified lllllllllllllIIIlIIlIlllllllllIl, @NotNull final ComponentLike lllllllllllllIIIlIIlIlllllllllll, @NotNull final MessageType lllllllllllllIIIlIIlIllllllllllI) {
    }
    
    @Override
    public void sendPlayerListHeaderAndFooter(@NotNull final ComponentLike lllllllllllllIIIlIIlIllllllIlIII, @NotNull final ComponentLike lllllllllllllIIIlIIlIllllllIIlll) {
    }
    
    @Override
    public void sendPlayerListHeader(@NotNull final ComponentLike lllllllllllllIIIlIIlIllllllIlllI) {
    }
    
    @Override
    public void sendActionBar(@NotNull final ComponentLike lllllllllllllIIIlIIlIlllllllIIIl) {
    }
    
    @Override
    public void sendMessage(@NotNull final ComponentLike lllllllllllllIIIlIIllIIIIIIlIIIl) {
    }
    
    @Override
    public void sendMessage(@NotNull final ComponentLike lllllllllllllIIIlIIllIIIIIIIIlII, @NotNull final MessageType lllllllllllllIIIlIIllIIIIIIIIIll) {
    }
    
    @Override
    public <T> T getOrDefaultFrom(@NotNull final Pointer<T> lllllllllllllIIIlIIllIIIIIIlIllI, @NotNull final Supplier<? extends T> lllllllllllllIIIlIIllIIIIIIlIlll) {
        return (T)lllllllllllllIIIlIIllIIIIIIlIlll.get();
    }
}
