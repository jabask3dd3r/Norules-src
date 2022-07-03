package com.viaversion.viaversion.libs.kyori.adventure.pointer;

import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import java.util.*;

final class PointersImpl implements Pointers
{
    private final /* synthetic */ Map<Pointer<?>, Supplier<?>> pointers;
    
    @NotNull
    @Override
    public <T> Optional<T> get(@NotNull final Pointer<T> llllllllllllllIlIIIIllIlIIIlIlll) {
        Objects.requireNonNull(llllllllllllllIlIIIIllIlIIIlIlll, "pointer");
        return Optional.ofNullable(this.pointers.get(llllllllllllllIlIIIIllIlIIIlIlll).get());
    }
    
    static {
        EMPTY = new Pointers() {
            @NotNull
            @Override
            public <T> Optional<T> get(@NotNull final Pointer<T> lllllllllllllIIllIIlIllllllIlIlI) {
                return Optional.empty();
            }
            
            @Override
            public <T> boolean supports(@NotNull final Pointer<T> lllllllllllllIIllIIlIllllllIIlll) {
                return false;
            }
            
            @Override
            public Builder toBuilder() {
                return new BuilderImpl();
            }
            
            @Override
            public String toString() {
                return "EmptyPointers";
            }
        };
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    PointersImpl(@NotNull final BuilderImpl llllllllllllllIlIIIIllIlIIIllllI) {
        this.pointers = new HashMap<Pointer<?>, Supplier<?>>(llllllllllllllIlIIIIllIlIIIllllI.pointers);
    }
    
    @Override
    public <T> boolean supports(@NotNull final Pointer<T> llllllllllllllIlIIIIllIlIIIlIIII) {
        Objects.requireNonNull(llllllllllllllIlIIIIllIlIIIlIIII, "pointer");
        return this.pointers.containsKey(llllllllllllllIlIIIIllIlIIIlIIII);
    }
    
    static final class BuilderImpl implements Builder
    {
        private final /* synthetic */ Map<Pointer<?>, Supplier<?>> pointers;
        
        BuilderImpl(@NotNull final PointersImpl llllllllllllIllllIllllIlIllIlIlI) {
            this.pointers = new HashMap<Pointer<?>, Supplier<?>>(llllllllllllIllllIllllIlIllIlIlI.pointers);
        }
        
        @NotNull
        @Override
        public <T> Builder withDynamic(@NotNull final Pointer<T> llllllllllllIllllIllllIlIllIIIIl, @NotNull final Supplier<T> llllllllllllIllllIllllIlIllIIIlI) {
            this.pointers.put(Objects.requireNonNull(llllllllllllIllllIllllIlIllIIIIl, "pointer"), Objects.requireNonNull(llllllllllllIllllIllllIlIllIIIlI, "value"));
            return this;
        }
        
        @NotNull
        @Override
        public Pointers build() {
            return new PointersImpl(this);
        }
        
        BuilderImpl() {
            this.pointers = new HashMap<Pointer<?>, Supplier<?>>();
        }
    }
}
