package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.function.*;
import org.jetbrains.annotations.*;
import java.io.*;
import java.util.*;

public abstract class BinaryTagType<T extends BinaryTag> implements Predicate<BinaryTagType<? extends BinaryTag>>
{
    private static final /* synthetic */ List<BinaryTagType<? extends BinaryTag>> TYPES;
    
    @NotNull
    public abstract T read(@NotNull final DataInput lllllllllllllIlIllIllllIIIllIIlI) throws IOException;
    
    @NotNull
    static <T extends BinaryTag> BinaryTagType<T> register(final Class<T> lllllllllllllIlIllIllllIIIIlIIll, final byte lllllllllllllIlIllIllllIIIIlIIlI, final Reader<T> lllllllllllllIlIllIllllIIIIlIlII, @Nullable final Writer<T> lllllllllllllIlIllIllllIIIIlIlIl) {
        return register(new Impl<T>(lllllllllllllIlIllIllllIIIIlIIll, lllllllllllllIlIllIllllIIIIlIIlI, lllllllllllllIlIllIllllIIIIlIlII, lllllllllllllIlIllIllllIIIIlIlIl));
    }
    
    static <T extends BinaryTag> void write(final BinaryTagType<? extends BinaryTag> lllllllllllllIlIllIllllIIIlIlIlI, final T lllllllllllllIlIllIllllIIIlIllII, final DataOutput lllllllllllllIlIllIllllIIIlIlIll) throws IOException {
        lllllllllllllIlIllIllllIIIlIlIlI.write((BinaryTag)lllllllllllllIlIllIllllIIIlIllII, lllllllllllllIlIllIllllIIIlIlIll);
    }
    
    public abstract void write(@NotNull final T lllllllllllllIlIllIllllIIIllIIII, @NotNull final DataOutput lllllllllllllIlIllIllllIIIllIIIl) throws IOException;
    
    static {
        TYPES = new ArrayList<BinaryTagType<? extends BinaryTag>>();
    }
    
    @NotNull
    static <T extends NumberBinaryTag> BinaryTagType<T> registerNumeric(final Class<T> lllllllllllllIlIllIllllIIIIIIIlI, final byte lllllllllllllIlIllIllllIIIIIIlII, final Reader<T> lllllllllllllIlIllIllllIIIIIIlIl, final Writer<T> lllllllllllllIlIllIllllIIIIIIIll) {
        return register(new Impl.Numeric<T>(lllllllllllllIlIllIllllIIIIIIIlI, lllllllllllllIlIllIllllIIIIIIlII, lllllllllllllIlIllIllllIIIIIIlIl, lllllllllllllIlIllIllllIIIIIIIll));
    }
    
    abstract boolean numeric();
    
    public abstract byte id();
    
    private static <T extends BinaryTag, Y extends BinaryTagType<T>> Y register(final Y lllllllllllllIlIllIlllIllllllIII) {
        BinaryTagType.TYPES.add(lllllllllllllIlIllIlllIllllllIII);
        return lllllllllllllIlIllIlllIllllllIII;
    }
    
    @Override
    public boolean test(final BinaryTagType<? extends BinaryTag> lllllllllllllIlIllIlllIlllllIIll) {
        return this == lllllllllllllIlIllIlllIlllllIIll || (this.numeric() && lllllllllllllIlIllIlllIlllllIIll.numeric());
    }
    
    @NotNull
    static BinaryTagType<? extends BinaryTag> of(final byte lllllllllllllIlIllIllllIIIlIIIII) {
        for (int lllllllllllllIlIllIllllIIIIllllI = 0; lllllllllllllIlIllIllllIIIIllllI < BinaryTagType.TYPES.size(); ++lllllllllllllIlIllIllllIIIIllllI) {
            final BinaryTagType<? extends BinaryTag> lllllllllllllIlIllIllllIIIIlllll = BinaryTagType.TYPES.get(lllllllllllllIlIllIllllIIIIllllI);
            if (lllllllllllllIlIllIllllIIIIlllll.id() == lllllllllllllIlIllIllllIIIlIIIII) {
                return lllllllllllllIlIllIllllIIIIlllll;
            }
        }
        throw new IllegalArgumentException(String.valueOf(lllllllllllllIlIllIllllIIIlIIIII));
    }
    
    interface Writer<T extends BinaryTag>
    {
        void write(@NotNull final T lIlllIIIlIIllIl, @NotNull final DataOutput lIlllIIIlIIllII) throws IOException;
    }
    
    static class Impl<T extends BinaryTag> extends BinaryTagType<T>
    {
        final /* synthetic */ byte id;
        @Nullable
        private final /* synthetic */ Writer<T> writer;
        private final /* synthetic */ Reader<T> reader;
        final /* synthetic */ Class<T> type;
        
        @Override
        public final void write(@NotNull final T lllllllllllllIIIllllIIlllIIIllIl, @NotNull final DataOutput lllllllllllllIIIllllIIlllIIIllII) throws IOException {
            if (this.writer != null) {
                this.writer.write(lllllllllllllIIIllllIIlllIIIllIl, lllllllllllllIIIllllIIlllIIIllII);
            }
        }
        
        @Override
        public final byte id() {
            return this.id;
        }
        
        Impl(final Class<T> lllllllllllllIIIllllIIlllIlIIIll, final byte lllllllllllllIIIllllIIlllIlIIIlI, final Reader<T> lllllllllllllIIIllllIIlllIlIIlII, @Nullable final Writer<T> lllllllllllllIIIllllIIlllIlIIlIl) {
            this.type = lllllllllllllIIIllllIIlllIlIIIll;
            this.id = lllllllllllllIIIllllIIlllIlIIIlI;
            this.reader = lllllllllllllIIIllllIIlllIlIIlII;
            this.writer = lllllllllllllIIIllllIIlllIlIIlIl;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(BinaryTagType.class.getSimpleName()).append('[').append(this.type.getSimpleName()).append(" ").append(this.id).append("]"));
        }
        
        @NotNull
        @Override
        public final T read(@NotNull final DataInput lllllllllllllIIIllllIIlllIIlIlIl) throws IOException {
            return this.reader.read(lllllllllllllIIIllllIIlllIIlIlIl);
        }
        
        @Override
        boolean numeric() {
            return false;
        }
        
        static class Numeric<T extends BinaryTag> extends Impl<T>
        {
            @Override
            public String toString() {
                return String.valueOf(new StringBuilder().append(BinaryTagType.class.getSimpleName()).append('[').append(this.type.getSimpleName()).append(" ").append(this.id).append(" (numeric)]"));
            }
            
            @Override
            boolean numeric() {
                return true;
            }
            
            Numeric(final Class<T> lllllllllllllllIIllIlIIllIlIllll, final byte lllllllllllllllIIllIlIIllIllIIII, final Reader<T> lllllllllllllllIIllIlIIllIllIIIl, @Nullable final Writer<T> lllllllllllllllIIllIlIIllIlIlllI) {
                super(lllllllllllllllIIllIlIIllIlIllll, lllllllllllllllIIllIlIIllIllIIII, lllllllllllllllIIllIlIIllIllIIIl, lllllllllllllllIIllIlIIllIlIlllI);
            }
        }
    }
    
    interface Reader<T extends BinaryTag>
    {
        @NotNull
        T read(@NotNull final DataInput lllllllllllllIlIIllIllIlIIlIlIlI) throws IOException;
    }
}
