package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.gson.*;
import org.jetbrains.annotations.*;
import java.util.function.*;

public interface GsonComponentSerializer extends ComponentSerializer<Component, Component, String>, Buildable<GsonComponentSerializer, Builder>
{
    default Builder builder() {
        return new GsonComponentSerializerImpl.BuilderImpl();
    }
    
    @NotNull
    JsonElement serializeToTree(@NotNull final Component lllllllllllllIlllIIIIIllIIlIIIlI);
    
    @NotNull
    Component deserializeFromTree(@NotNull final JsonElement lllllllllllllIlllIIIIIllIIlIIIll);
    
    @NotNull
    UnaryOperator<GsonBuilder> populator();
    
    @NotNull
    default GsonComponentSerializer colorDownsamplingGson() {
        return GsonComponentSerializerImpl.Instances.LEGACY_INSTANCE;
    }
    
    @NotNull
    Gson serializer();
    
    @NotNull
    default GsonComponentSerializer gson() {
        return GsonComponentSerializerImpl.Instances.INSTANCE;
    }
    
    public interface Builder extends Buildable.Builder<GsonComponentSerializer>
    {
        @NotNull
        Builder downsampleColors();
        
        @NotNull
        Builder emitLegacyHoverEvent();
        
        @NotNull
        Builder legacyHoverEventSerializer(@Nullable final LegacyHoverEventSerializer lllllllllllllIIIIIIIIIllIlIlllIl);
        
        @NotNull
        GsonComponentSerializer build();
    }
    
    @ApiStatus.Internal
    public interface Provider
    {
        @ApiStatus.Internal
        @NotNull
        GsonComponentSerializer gsonLegacy();
        
        @NotNull
        @ApiStatus.Internal
        Consumer<Builder> builder();
        
        @NotNull
        @ApiStatus.Internal
        GsonComponentSerializer gson();
    }
}
