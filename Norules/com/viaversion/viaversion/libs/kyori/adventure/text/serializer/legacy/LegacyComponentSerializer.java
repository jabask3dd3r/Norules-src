package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy;

import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.regex.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.flattener.*;
import org.jetbrains.annotations.*;
import java.util.function.*;

public interface LegacyComponentSerializer extends ComponentSerializer<Component, TextComponent, String>, Buildable<LegacyComponentSerializer, Builder>
{
    @NotNull
    String serialize(@NotNull final Component llllllllllllllIIIIllIIllllllIlll);
    
    @NotNull
    default LegacyComponentSerializer legacy(final char llllllllllllllIIIIllIIllllllllll) {
        if (llllllllllllllIIIIllIIllllllllll == '§') {
            return legacySection();
        }
        if (llllllllllllllIIIIllIIllllllllll == '&') {
            return legacyAmpersand();
        }
        return builder().character(llllllllllllllIIIIllIIllllllllll).build();
    }
    
    @NotNull
    default LegacyComponentSerializer legacyAmpersand() {
        return LegacyComponentSerializerImpl.Instances.AMPERSAND;
    }
    
    @Nullable
    default LegacyFormat parseChar(final char llllllllllllllIIIIllIIlllllllIll) {
        return LegacyComponentSerializerImpl.legacyFormat(llllllllllllllIIIIllIIlllllllIll);
    }
    
    @NotNull
    default Builder builder() {
        return new LegacyComponentSerializerImpl.BuilderImpl();
    }
    
    @NotNull
    TextComponent deserialize(@NotNull final String llllllllllllllIIIIllIIlllllllIII);
    
    @NotNull
    default LegacyComponentSerializer legacySection() {
        return LegacyComponentSerializerImpl.Instances.SECTION;
    }
    
    public interface Builder extends Buildable.Builder<LegacyComponentSerializer>
    {
        @NotNull
        LegacyComponentSerializer build();
        
        @NotNull
        Builder useUnusualXRepeatedCharacterHexFormat();
        
        @NotNull
        Builder extractUrls(@NotNull final Pattern lllllllllllllllllIllIIllIIIlllll);
        
        @NotNull
        Builder extractUrls();
        
        @NotNull
        Builder hexColors();
        
        @NotNull
        Builder extractUrls(@Nullable final Style lllllllllllllllllIllIIllIIIllllI);
        
        @NotNull
        Builder extractUrls(@NotNull final Pattern lllllllllllllllllIllIIllIIIlllIl, @Nullable final Style lllllllllllllllllIllIIllIIIlllII);
        
        @NotNull
        Builder character(final char lllllllllllllllllIllIIllIIlIIIIl);
        
        @NotNull
        Builder hexCharacter(final char lllllllllllllllllIllIIllIIlIIIII);
        
        @NotNull
        Builder flattener(@NotNull final ComponentFlattener lllllllllllllllllIllIIllIIIllIll);
    }
    
    @ApiStatus.Internal
    public interface Provider
    {
        @ApiStatus.Internal
        @NotNull
        LegacyComponentSerializer legacySection();
        
        @NotNull
        @ApiStatus.Internal
        LegacyComponentSerializer legacyAmpersand();
        
        @NotNull
        @ApiStatus.Internal
        Consumer<Builder> legacy();
    }
}
