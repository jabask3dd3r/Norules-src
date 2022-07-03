package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

@ApiStatus.NonExtendable
public interface TextDecorationAndState extends StyleBuilderApplicable, Examinable
{
    TextDecoration.State state();
    
    TextDecoration decoration();
    
    default void styleApply(final Style.Builder llIIIIIlIlIIllI) {
        llIIIIIlIlIIllI.decoration(this.decoration(), this.state());
    }
    
    default Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("decoration", this.decoration()), ExaminableProperty.of("state", this.state()) });
    }
}
