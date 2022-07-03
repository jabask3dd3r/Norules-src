package com.viaversion.viaversion.libs.kyori.adventure.text.flattener;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import java.util.function.*;
import org.jetbrains.annotations.*;

public interface ComponentFlattener extends Buildable<ComponentFlattener, Builder>
{
    @NotNull
    default ComponentFlattener basic() {
        return ComponentFlattenerImpl.BASIC;
    }
    
    void flatten(@NotNull final Component llllllllllllllIlIIIIIllIlllIllII, @NotNull final FlattenerListener llllllllllllllIlIIIIIllIlllIlIll);
    
    @NotNull
    default ComponentFlattener textOnly() {
        return ComponentFlattenerImpl.TEXT_ONLY;
    }
    
    @NotNull
    default Builder builder() {
        return new ComponentFlattenerImpl.BuilderImpl();
    }
    
    public interface Builder extends Buildable.Builder<ComponentFlattener>
    {
        @NotNull
         <T extends Component> Builder complexMapper(@NotNull final Class<T> lIIIIllI, @NotNull final BiConsumer<T, Consumer<Component>> lIIIIlll);
        
        @NotNull
        Builder unknownMapper(@Nullable final Function<Component, String> lIIIIlIl);
        
        @NotNull
         <T extends Component> Builder mapper(@NotNull final Class<T> lIIIlIII, @NotNull final Function<T, String> lIIIlIIl);
    }
}
