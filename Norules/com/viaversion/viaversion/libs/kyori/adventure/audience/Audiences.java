package com.viaversion.viaversion.libs.kyori.adventure.audience;

import java.util.stream.*;
import java.util.function.*;
import java.util.*;

final class Audiences
{
    private Audiences() {
    }
    
    static {
        COLLECTOR = Collectors.collectingAndThen((Collector<? super Audience, ?, ArrayList>)Collectors.toCollection((Supplier<R>)ArrayList::new), llllllllllllllllIlIIlllllIlIIIlI -> Audience.audience((Iterable<? extends Audience>)Collections.unmodifiableCollection((Collection<?>)llllllllllllllllIlIIlllllIlIIIlI)));
    }
}
