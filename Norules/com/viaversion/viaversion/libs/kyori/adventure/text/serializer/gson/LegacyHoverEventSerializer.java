package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import java.io.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

public interface LegacyHoverEventSerializer
{
    HoverEvent.ShowItem deserializeShowItem(@NotNull final Component llllllllllllllIlIlIllIlIIlIllIII) throws IOException;
    
    HoverEvent.ShowEntity deserializeShowEntity(@NotNull final Component llllllllllllllIlIlIllIlIIlIlIllI, final Codec.Decoder<Component, String, ? extends RuntimeException> llllllllllllllIlIlIllIlIIlIlIlll) throws IOException;
    
    @NotNull
    Component serializeShowItem(final HoverEvent.ShowItem llllllllllllllIlIlIllIlIIlIlIlIl) throws IOException;
    
    @NotNull
    Component serializeShowEntity(final HoverEvent.ShowEntity llllllllllllllIlIlIllIlIIlIlIlII, final Codec.Encoder<Component, String, ? extends RuntimeException> llllllllllllllIlIlIllIlIIlIlIIll) throws IOException;
}
