package com.viaversion.viaversion.libs.kyori.adventure.key;

import java.util.function.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import org.jetbrains.annotations.*;

final class KeyImpl implements Key
{
    private final /* synthetic */ String namespace;
    private final /* synthetic */ String value;
    private static final /* synthetic */ IntPredicate VALUE_PREDICATE;
    private static final /* synthetic */ IntPredicate NAMESPACE_PREDICATE;
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("namespace", this.namespace), ExaminableProperty.of("value", this.value) });
    }
    
    @NotNull
    private static String asString(@NotNull final String lllllllllllllIlllIIlllllIlIIlIll, @NotNull final String lllllllllllllIlllIIlllllIlIIllII) {
        return String.valueOf(new StringBuilder().append(lllllllllllllIlllIIlllllIlIIlIll).append(':').append(lllllllllllllIlllIIlllllIlIIllII));
    }
    
    @Override
    public int compareTo(@NotNull final Key lllllllllllllIlllIIlllllIIlIlllI) {
        return super.compareTo(lllllllllllllIlllIIlllllIIlIlllI);
    }
    
    static int clampCompare(final int lllllllllllllIlllIIlllllIIlIlIII) {
        if (lllllllllllllIlllIIlllllIIlIlIII < 0) {
            return -1;
        }
        if (lllllllllllllIlllIIlllllIIlIlIII > 0) {
            return 1;
        }
        return lllllllllllllIlllIIlllllIIlIlIII;
    }
    
    @NotNull
    @Override
    public String value() {
        return this.value;
    }
    
    @NotNull
    @Override
    public String namespace() {
        return this.namespace;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIIlllllIIllllIl) {
        if (this == lllllllllllllIlllIIlllllIIllllIl) {
            return true;
        }
        if (!(lllllllllllllIlllIIlllllIIllllIl instanceof Key)) {
            return false;
        }
        final Key lllllllllllllIlllIIlllllIIlllIlI = (Key)lllllllllllllIlllIIlllllIIllllIl;
        return Objects.equals(this.namespace, lllllllllllllIlllIIlllllIIlllIlI.namespace()) && Objects.equals(this.value, lllllllllllllIlllIIlllllIIlllIlI.value());
    }
    
    @VisibleForTesting
    static boolean valueValid(@NotNull final String lllllllllllllIlllIIlllllIlIllllI) {
        for (int lllllllllllllIlllIIlllllIlIlllIl = 0, lllllllllllllIlllIIlllllIlIlllII = lllllllllllllIlllIIlllllIlIllllI.length(); lllllllllllllIlllIIlllllIlIlllIl < lllllllllllllIlllIIlllllIlIlllII; ++lllllllllllllIlllIIlllllIlIlllIl) {
            if (!KeyImpl.VALUE_PREDICATE.test(lllllllllllllIlllIIlllllIlIllllI.charAt(lllllllllllllIlllIIlllllIlIlllIl))) {
                return false;
            }
        }
        return true;
    }
    
    static {
        NAMESPACE_PATTERN = "[a-z0-9_\\-.]+";
        VALUE_PATTERN = "[a-z0-9_\\-./]+";
        NAMESPACE_PREDICATE = (lllllllllllllIlllIIlllllIIIlIIIl -> lllllllllllllIlllIIlllllIIIlIIIl == 95 || lllllllllllllIlllIIlllllIIIlIIIl == 45 || (lllllllllllllIlllIIlllllIIIlIIIl >= 97 && lllllllllllllIlllIIlllllIIIlIIIl <= 122) || (lllllllllllllIlllIIlllllIIIlIIIl >= 48 && lllllllllllllIlllIIlllllIIIlIIIl <= 57) || lllllllllllllIlllIIlllllIIIlIIIl == 46);
        VALUE_PREDICATE = (lllllllllllllIlllIIlllllIIIlIlll -> lllllllllllllIlllIIlllllIIIlIlll == 95 || lllllllllllllIlllIIlllllIIIlIlll == 45 || (lllllllllllllIlllIIlllllIIIlIlll >= 97 && lllllllllllllIlllIIlllllIIIlIlll <= 122) || (lllllllllllllIlllIIlllllIIIlIlll >= 48 && lllllllllllllIlllIIlllllIIIlIlll <= 57) || lllllllllllllIlllIIlllllIIIlIlll == 47 || lllllllllllllIlllIIlllllIIIlIlll == 46);
    }
    
    @NotNull
    @Override
    public String asString() {
        return asString(this.namespace, this.value);
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.asString();
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlllIIlllllIIllIIll = this.namespace.hashCode();
        lllllllllllllIlllIIlllllIIllIIll = 31 * lllllllllllllIlllIIlllllIIllIIll + this.value.hashCode();
        return lllllllllllllIlllIIlllllIIllIIll;
    }
    
    KeyImpl(@NotNull final String lllllllllllllIlllIIlllllIlllIIlI, @NotNull final String lllllllllllllIlllIIlllllIlllIIll) {
        if (!namespaceValid(lllllllllllllIlllIIlllllIlllIIlI)) {
            throw new InvalidKeyException(lllllllllllllIlllIIlllllIlllIIlI, lllllllllllllIlllIIlllllIlllIIll, String.format("Non [a-z0-9_.-] character in namespace of Key[%s]", asString(lllllllllllllIlllIIlllllIlllIIlI, lllllllllllllIlllIIlllllIlllIIll)));
        }
        if (!valueValid(lllllllllllllIlllIIlllllIlllIIll)) {
            throw new InvalidKeyException(lllllllllllllIlllIIlllllIlllIIlI, lllllllllllllIlllIIlllllIlllIIll, String.format("Non [a-z0-9/._-] character in value of Key[%s]", asString(lllllllllllllIlllIIlllllIlllIIlI, lllllllllllllIlllIIlllllIlllIIll)));
        }
        this.namespace = Objects.requireNonNull(lllllllllllllIlllIIlllllIlllIIlI, "namespace");
        this.value = Objects.requireNonNull(lllllllllllllIlllIIlllllIlllIIll, "value");
    }
    
    @VisibleForTesting
    static boolean namespaceValid(@NotNull final String lllllllllllllIlllIIlllllIllIlIII) {
        for (int lllllllllllllIlllIIlllllIllIIlll = 0, lllllllllllllIlllIIlllllIllIIllI = lllllllllllllIlllIIlllllIllIlIII.length(); lllllllllllllIlllIIlllllIllIIlll < lllllllllllllIlllIIlllllIllIIllI; ++lllllllllllllIlllIIlllllIllIIlll) {
            if (!KeyImpl.NAMESPACE_PREDICATE.test(lllllllllllllIlllIIlllllIllIlIII.charAt(lllllllllllllIlllIIlllllIllIIlll))) {
                return false;
            }
        }
        return true;
    }
}
