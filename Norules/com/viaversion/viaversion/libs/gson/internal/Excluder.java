package com.viaversion.viaversion.libs.gson.internal;

import com.viaversion.viaversion.libs.gson.reflect.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.annotations.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;

public final class Excluder implements TypeAdapterFactory, Cloneable
{
    private /* synthetic */ List<ExclusionStrategy> serializationStrategies;
    private /* synthetic */ double version;
    private /* synthetic */ List<ExclusionStrategy> deserializationStrategies;
    private /* synthetic */ int modifiers;
    private /* synthetic */ boolean serializeInnerClasses;
    private /* synthetic */ boolean requireExpose;
    
    private boolean excludeClassInStrategy(final Class<?> lllllllllllllIIIIllIIIlIllIIIlII, final boolean lllllllllllllIIIIllIIIlIlIllllll) {
        final List<ExclusionStrategy> lllllllllllllIIIIllIIIlIllIIIIlI = lllllllllllllIIIIllIIIlIlIllllll ? this.serializationStrategies : this.deserializationStrategies;
        for (final ExclusionStrategy lllllllllllllIIIIllIIIlIllIIIllI : lllllllllllllIIIIllIIIlIllIIIIlI) {
            if (lllllllllllllIIIIllIIIlIllIIIllI.shouldSkipClass(lllllllllllllIIIIllIIIlIllIIIlII)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public <T> TypeAdapter<T> create(final Gson lllllllllllllIIIIllIIIlIllllIllI, final TypeToken<T> lllllllllllllIIIIllIIIlIllllIlIl) {
        final Class<?> lllllllllllllIIIIllIIIlIlllllIll = lllllllllllllIIIIllIIIlIllllIlIl.getRawType();
        final boolean lllllllllllllIIIIllIIIlIlllllIlI = this.excludeClassChecks(lllllllllllllIIIIllIIIlIlllllIll);
        final boolean lllllllllllllIIIIllIIIlIlllllIIl = lllllllllllllIIIIllIIIlIlllllIlI || this.excludeClassInStrategy(lllllllllllllIIIIllIIIlIlllllIll, true);
        final boolean lllllllllllllIIIIllIIIlIlllllIII = lllllllllllllIIIIllIIIlIlllllIlI || this.excludeClassInStrategy(lllllllllllllIIIIllIIIlIlllllIll, false);
        if (!lllllllllllllIIIIllIIIlIlllllIIl && !lllllllllllllIIIIllIIIlIlllllIII) {
            return null;
        }
        return new TypeAdapter<T>() {
            private /* synthetic */ TypeAdapter<T> delegate;
            
            private TypeAdapter<T> delegate() {
                final TypeAdapter<T> lllllllllllllIlIllIllllllIIIllIl = this.delegate;
                return (lllllllllllllIlIllIllllllIIIllIl != null) ? lllllllllllllIlIllIllllllIIIllIl : (this.delegate = lllllllllllllIIIIllIIIlIllllIllI.getDelegateAdapter(Excluder.this, lllllllllllllIIIIllIIIlIllllIlIl));
            }
            
            @Override
            public T read(final JsonReader lllllllllllllIlIllIllllllIIlllII) throws IOException {
                if (lllllllllllllIIIIllIIIlIlllllIII) {
                    lllllllllllllIlIllIllllllIIlllII.skipValue();
                    return null;
                }
                return this.delegate().read(lllllllllllllIlIllIllllllIIlllII);
            }
            
            @Override
            public void write(final JsonWriter lllllllllllllIlIllIllllllIIlIlIl, final T lllllllllllllIlIllIllllllIIlIIIl) throws IOException {
                if (lllllllllllllIIIIllIIIlIlllllIIl) {
                    lllllllllllllIlIllIllllllIIlIlIl.nullValue();
                    return;
                }
                this.delegate().write(lllllllllllllIlIllIllllllIIlIlIl, lllllllllllllIlIllIllllllIIlIIIl);
            }
        };
    }
    
    public Excluder withExclusionStrategy(final ExclusionStrategy lllllllllllllIIIIllIIIllIIIIlIIl, final boolean lllllllllllllIIIIllIIIllIIIIlIII, final boolean lllllllllllllIIIIllIIIllIIIIIlll) {
        final Excluder lllllllllllllIIIIllIIIllIIIIlIll = this.clone();
        if (lllllllllllllIIIIllIIIllIIIIlIII) {
            lllllllllllllIIIIllIIIllIIIIlIll.serializationStrategies = new ArrayList<ExclusionStrategy>(this.serializationStrategies);
            lllllllllllllIIIIllIIIllIIIIlIll.serializationStrategies.add(lllllllllllllIIIIllIIIllIIIIlIIl);
        }
        if (lllllllllllllIIIIllIIIllIIIIIlll) {
            lllllllllllllIIIIllIIIllIIIIlIll.deserializationStrategies = new ArrayList<ExclusionStrategy>(this.deserializationStrategies);
            lllllllllllllIIIIllIIIllIIIIlIll.deserializationStrategies.add(lllllllllllllIIIIllIIIllIIIIlIIl);
        }
        return lllllllllllllIIIIllIIIllIIIIlIll;
    }
    
    private boolean isAnonymousOrLocal(final Class<?> lllllllllllllIIIIllIIIlIlIlllIIl) {
        return !Enum.class.isAssignableFrom(lllllllllllllIIIIllIIIlIlIlllIIl) && (lllllllllllllIIIIllIIIlIlIlllIIl.isAnonymousClass() || lllllllllllllIIIIllIIIlIlIlllIIl.isLocalClass());
    }
    
    public boolean excludeField(final Field lllllllllllllIIIIllIIIlIlllIIlIl, final boolean lllllllllllllIIIIllIIIlIlllIIlII) {
        if ((this.modifiers & lllllllllllllIIIIllIIIlIlllIIlIl.getModifiers()) != 0x0) {
            return true;
        }
        if (this.version != -1.0 && !this.isValidVersion(lllllllllllllIIIIllIIIlIlllIIlIl.getAnnotation(Since.class), lllllllllllllIIIIllIIIlIlllIIlIl.getAnnotation(Until.class))) {
            return true;
        }
        if (lllllllllllllIIIIllIIIlIlllIIlIl.isSynthetic()) {
            return true;
        }
        Label_0109: {
            if (this.requireExpose) {
                final Expose lllllllllllllIIIIllIIIlIlllIlIIl = lllllllllllllIIIIllIIIlIlllIIlIl.getAnnotation(Expose.class);
                if (lllllllllllllIIIIllIIIlIlllIlIIl != null) {
                    if (lllllllllllllIIIIllIIIlIlllIIlII) {
                        if (lllllllllllllIIIIllIIIlIlllIlIIl.serialize()) {
                            break Label_0109;
                        }
                    }
                    else if (lllllllllllllIIIIllIIIlIlllIlIIl.deserialize()) {
                        break Label_0109;
                    }
                }
                return true;
            }
        }
        if (!this.serializeInnerClasses && this.isInnerClass(lllllllllllllIIIIllIIIlIlllIIlIl.getType())) {
            return true;
        }
        if (this.isAnonymousOrLocal(lllllllllllllIIIIllIIIlIlllIIlIl.getType())) {
            return true;
        }
        final List<ExclusionStrategy> lllllllllllllIIIIllIIIlIlllIIIll = lllllllllllllIIIIllIIIlIlllIIlII ? this.serializationStrategies : this.deserializationStrategies;
        if (!lllllllllllllIIIIllIIIlIlllIIIll.isEmpty()) {
            final FieldAttributes lllllllllllllIIIIllIIIlIlllIIlll = new FieldAttributes(lllllllllllllIIIIllIIIlIlllIIlIl);
            for (final ExclusionStrategy lllllllllllllIIIIllIIIlIlllIlIII : lllllllllllllIIIIllIIIlIlllIIIll) {
                if (lllllllllllllIIIIllIIIlIlllIlIII.shouldSkipField(lllllllllllllIIIIllIIIlIlllIIlll)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Excluder disableInnerClassSerialization() {
        final Excluder lllllllllllllIIIIllIIIllIIIlllIl = this.clone();
        lllllllllllllIIIIllIIIllIIIlllIl.serializeInnerClasses = false;
        return lllllllllllllIIIIllIIIllIIIlllIl;
    }
    
    private boolean excludeClassChecks(final Class<?> lllllllllllllIIIIllIIIlIllIlIllI) {
        return (this.version != -1.0 && !this.isValidVersion(lllllllllllllIIIIllIIIlIllIlIllI.getAnnotation(Since.class), lllllllllllllIIIIllIIIlIllIlIllI.getAnnotation(Until.class))) || (!this.serializeInnerClasses && this.isInnerClass(lllllllllllllIIIIllIIIlIllIlIllI)) || this.isAnonymousOrLocal(lllllllllllllIIIIllIIIlIllIlIllI);
    }
    
    private boolean isValidVersion(final Since lllllllllllllIIIIllIIIlIlIlIIllI, final Until lllllllllllllIIIIllIIIlIlIlIlIII) {
        return this.isValidSince(lllllllllllllIIIIllIIIlIlIlIIllI) && this.isValidUntil(lllllllllllllIIIIllIIIlIlIlIlIII);
    }
    
    private boolean isValidUntil(final Until lllllllllllllIIIIllIIIlIlIIlIllI) {
        if (lllllllllllllIIIIllIIIlIlIIlIllI != null) {
            final double lllllllllllllIIIIllIIIlIlIIllIII = lllllllllllllIIIIllIIIlIlIIlIllI.value();
            if (lllllllllllllIIIIllIIIlIlIIllIII <= this.version) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isStatic(final Class<?> lllllllllllllIIIIllIIIlIlIlIllll) {
        return (lllllllllllllIIIIllIIIlIlIlIllll.getModifiers() & 0x8) != 0x0;
    }
    
    private boolean isInnerClass(final Class<?> lllllllllllllIIIIllIIIlIlIllIlII) {
        return lllllllllllllIIIIllIIIlIlIllIlII.isMemberClass() && !this.isStatic(lllllllllllllIIIIllIIIlIlIllIlII);
    }
    
    public Excluder withModifiers(final int... lllllllllllllIIIIllIIIllIIlIlIIl) {
        final Excluder lllllllllllllIIIIllIIIllIIlIlIII = this.clone();
        lllllllllllllIIIIllIIIllIIlIlIII.modifiers = 0;
        final char lllllllllllllIIIIllIIIllIIlIIlII = (Object)lllllllllllllIIIIllIIIllIIlIlIIl;
        final long lllllllllllllIIIIllIIIllIIlIIIll = lllllllllllllIIIIllIIIllIIlIIlII.length;
        for (byte lllllllllllllIIIIllIIIllIIlIIIlI = 0; lllllllllllllIIIIllIIIllIIlIIIlI < lllllllllllllIIIIllIIIllIIlIIIll; ++lllllllllllllIIIIllIIIllIIlIIIlI) {
            final int lllllllllllllIIIIllIIIllIIlIlIll = lllllllllllllIIIIllIIIllIIlIIlII[lllllllllllllIIIIllIIIllIIlIIIlI];
            final Excluder excluder = lllllllllllllIIIIllIIIllIIlIlIII;
            excluder.modifiers |= lllllllllllllIIIIllIIIllIIlIlIll;
        }
        return lllllllllllllIIIIllIIIllIIlIlIII;
    }
    
    public boolean excludeClass(final Class<?> lllllllllllllIIIIllIIIlIllIlIIIl, final boolean lllllllllllllIIIIllIIIlIllIIllIl) {
        return this.excludeClassChecks(lllllllllllllIIIIllIIIlIllIlIIIl) || this.excludeClassInStrategy(lllllllllllllIIIIllIIIlIllIlIIIl, lllllllllllllIIIIllIIIlIllIIllIl);
    }
    
    @Override
    protected Excluder clone() {
        try {
            return (Excluder)super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIIIIllIIIllIIllllll) {
            throw new AssertionError((Object)lllllllllllllIIIIllIIIllIIllllll);
        }
    }
    
    static {
        DEFAULT = new Excluder();
    }
    
    private boolean isValidSince(final Since lllllllllllllIIIIllIIIlIlIIlllll) {
        if (lllllllllllllIIIIllIIIlIlIIlllll != null) {
            final double lllllllllllllIIIIllIIIlIlIlIIIIl = lllllllllllllIIIIllIIIlIlIIlllll.value();
            if (lllllllllllllIIIIllIIIlIlIlIIIIl > this.version) {
                return false;
            }
        }
        return true;
    }
    
    public Excluder() {
        this.version = -1.0;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }
    
    public Excluder excludeFieldsWithoutExposeAnnotation() {
        final Excluder lllllllllllllIIIIllIIIllIIIlIlll = this.clone();
        lllllllllllllIIIIllIIIllIIIlIlll.requireExpose = true;
        return lllllllllllllIIIIllIIIllIIIlIlll;
    }
    
    public Excluder withVersion(final double lllllllllllllIIIIllIIIllIIllIlll) {
        final Excluder lllllllllllllIIIIllIIIllIIllIllI = this.clone();
        lllllllllllllIIIIllIIIllIIllIllI.version = lllllllllllllIIIIllIIIllIIllIlll;
        return lllllllllllllIIIIllIIIllIIllIllI;
    }
}
