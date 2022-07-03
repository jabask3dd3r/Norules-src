package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.util.*;

public interface TextComponent extends BuildableComponent<TextComponent, Builder>, ScopedComponent<TextComponent>
{
    @Contract(pure = true)
    @NotNull
    TextComponent content(@NotNull final String llllllllllllllIlllIlIlIlIIIlllII);
    
    @NotNull
    default TextComponent ofChildren(@NotNull final ComponentLike... llllllllllllllIlllIlIlIlIIIlllll) {
        if (llllllllllllllIlllIlIlIlIIIlllll.length == 0) {
            return Component.empty();
        }
        return new TextComponentImpl(Arrays.asList(llllllllllllllIlllIlIlIlIIIlllll), Style.empty(), "");
    }
    
    @NotNull
    String content();
    
    public interface Builder extends ComponentBuilder<TextComponent, Builder>
    {
        @Contract("_ -> this")
        @NotNull
        Builder content(@NotNull final String llllllllllllllIlIlllIlIlIllIIIIl);
        
        @NotNull
        String content();
    }
}
