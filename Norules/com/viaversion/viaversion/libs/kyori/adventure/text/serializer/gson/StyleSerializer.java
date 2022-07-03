package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.gson.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.gson.stream.*;
import java.io.*;
import com.viaversion.viaversion.libs.gson.internal.*;

final class StyleSerializer implements JsonDeserializer<Style>, JsonSerializer<Style>
{
    private final /* synthetic */ boolean emitLegacyHover;
    private static final /* synthetic */ TextDecoration[] DECORATIONS;
    private final /* synthetic */ LegacyHoverEventSerializer legacyHover;
    
    private Style deserialize(final JsonObject lllllllllllllIlllIlIIlllIlIIlIll, final JsonDeserializationContext lllllllllllllIlllIlIIlllIlIIlIlI) throws JsonParseException {
        final Style.Builder lllllllllllllIlllIlIIlllIIllIllI = Style.style();
        if (lllllllllllllIlllIlIIlllIlIIlIll.has("font")) {
            lllllllllllllIlllIlIIlllIIllIllI.font(lllllllllllllIlllIlIIlllIlIIlIlI.deserialize(lllllllllllllIlllIlIIlllIlIIlIll.get("font"), Key.class));
        }
        if (lllllllllllllIlllIlIIlllIlIIlIll.has("color")) {
            final TextColorWrapper lllllllllllllIlllIlIIlllIlIIlIIl = lllllllllllllIlllIlIIlllIlIIlIlI.deserialize(lllllllllllllIlllIlIIlllIlIIlIll.get("color"), TextColorWrapper.class);
            if (lllllllllllllIlllIlIIlllIlIIlIIl.color != null) {
                lllllllllllllIlllIlIIlllIIllIllI.color(lllllllllllllIlllIlIIlllIlIIlIIl.color);
            }
            else if (lllllllllllllIlllIlIIlllIlIIlIIl.decoration != null) {
                lllllllllllllIlllIlIIlllIIllIllI.decoration(lllllllllllllIlllIlIIlllIlIIlIIl.decoration, true);
            }
        }
        for (int lllllllllllllIlllIlIIlllIlIIIllI = 0, lllllllllllllIlllIlIIlllIlIIIlIl = StyleSerializer.DECORATIONS.length; lllllllllllllIlllIlIIlllIlIIIllI < lllllllllllllIlllIlIIlllIlIIIlIl; ++lllllllllllllIlllIlIIlllIlIIIllI) {
            final TextDecoration lllllllllllllIlllIlIIlllIlIIlIII = StyleSerializer.DECORATIONS[lllllllllllllIlllIlIIlllIlIIIllI];
            final String lllllllllllllIlllIlIIlllIlIIIlll = TextDecoration.NAMES.key(lllllllllllllIlllIlIIlllIlIIlIII);
            if (lllllllllllllIlllIlIIlllIlIIlIll.has(lllllllllllllIlllIlIIlllIlIIIlll)) {
                lllllllllllllIlllIlIIlllIIllIllI.decoration(lllllllllllllIlllIlIIlllIlIIlIII, lllllllllllllIlllIlIIlllIlIIlIll.get(lllllllllllllIlllIlIIlllIlIIIlll).getAsBoolean());
            }
        }
        if (lllllllllllllIlllIlIIlllIlIIlIll.has("insertion")) {
            lllllllllllllIlllIlIIlllIIllIllI.insertion(lllllllllllllIlllIlIIlllIlIIlIll.get("insertion").getAsString());
        }
        if (lllllllllllllIlllIlIIlllIlIIlIll.has("clickEvent")) {
            final JsonObject lllllllllllllIlllIlIIlllIlIIIIIl = lllllllllllllIlllIlIIlllIlIIlIll.getAsJsonObject("clickEvent");
            if (lllllllllllllIlllIlIIlllIlIIIIIl != null) {
                final ClickEvent.Action lllllllllllllIlllIlIIlllIlIIIIlI = optionallyDeserialize(lllllllllllllIlllIlIIlllIlIIIIIl.getAsJsonPrimitive("action"), lllllllllllllIlllIlIIlllIlIIlIlI, ClickEvent.Action.class);
                if (lllllllllllllIlllIlIIlllIlIIIIlI != null && lllllllllllllIlllIlIIlllIlIIIIlI.readable()) {
                    final JsonPrimitive lllllllllllllIlllIlIIlllIlIIIlII = lllllllllllllIlllIlIIlllIlIIIIIl.getAsJsonPrimitive("value");
                    final String lllllllllllllIlllIlIIlllIlIIIIll = (lllllllllllllIlllIlIIlllIlIIIlII == null) ? null : lllllllllllllIlllIlIIlllIlIIIlII.getAsString();
                    if (lllllllllllllIlllIlIIlllIlIIIIll != null) {
                        lllllllllllllIlllIlIIlllIIllIllI.clickEvent(ClickEvent.clickEvent(lllllllllllllIlllIlIIlllIlIIIIlI, lllllllllllllIlllIlIIlllIlIIIIll));
                    }
                }
            }
        }
        if (lllllllllllllIlllIlIIlllIlIIlIll.has("hoverEvent")) {
            final JsonObject lllllllllllllIlllIlIIlllIIlllIlI = lllllllllllllIlllIlIIlllIlIIlIll.getAsJsonObject("hoverEvent");
            if (lllllllllllllIlllIlIIlllIIlllIlI != null) {
                final HoverEvent.Action lllllllllllllIlllIlIIlllIIlllIll = optionallyDeserialize(lllllllllllllIlllIlIIlllIIlllIlI.getAsJsonPrimitive("action"), lllllllllllllIlllIlIIlllIlIIlIlI, HoverEvent.Action.class);
                if (lllllllllllllIlllIlIIlllIIlllIll != null && lllllllllllllIlllIlIIlllIIlllIll.readable()) {
                    Object lllllllllllllIlllIlIIlllIIllllII = null;
                    if (lllllllllllllIlllIlIIlllIIlllIlI.has("contents")) {
                        final JsonElement lllllllllllllIlllIlIIlllIlIIIIII = lllllllllllllIlllIlIIlllIIlllIlI.get("contents");
                        final Object lllllllllllllIlllIlIIlllIIllllll = lllllllllllllIlllIlIIlllIlIIlIlI.deserialize(lllllllllllllIlllIlIIlllIlIIIIII, lllllllllllllIlllIlIIlllIIlllIll.type());
                    }
                    else if (lllllllllllllIlllIlIIlllIIlllIlI.has("value")) {
                        final Component lllllllllllllIlllIlIIlllIIlllllI = lllllllllllllIlllIlIIlllIlIIlIlI.deserialize(lllllllllllllIlllIlIIlllIIlllIlI.get("value"), Component.class);
                        final Object lllllllllllllIlllIlIIlllIIllllIl = this.legacyHoverEventContents(lllllllllllllIlllIlIIlllIIlllIll, lllllllllllllIlllIlIIlllIIlllllI, lllllllllllllIlllIlIIlllIlIIlIlI);
                    }
                    else {
                        lllllllllllllIlllIlIIlllIIllllII = null;
                    }
                    if (lllllllllllllIlllIlIIlllIIllllII != null) {
                        lllllllllllllIlllIlIIlllIIllIllI.hoverEvent(HoverEvent.hoverEvent(lllllllllllllIlllIlIIlllIIlllIll, lllllllllllllIlllIlIIlllIIllllII));
                    }
                }
            }
        }
        if (lllllllllllllIlllIlIIlllIlIIlIll.has("font")) {
            lllllllllllllIlllIlIIlllIIllIllI.font(lllllllllllllIlllIlIIlllIlIIlIlI.deserialize(lllllllllllllIlllIlIIlllIlIIlIll.get("font"), Key.class));
        }
        return lllllllllllllIlllIlIIlllIIllIllI.build();
    }
    
    private JsonElement serializeLegacyHoverEvent(final HoverEvent<?> lllllllllllllIlllIlIIllIllIIIllI, final JsonElement lllllllllllllIlllIlIIllIllIIIlIl, final JsonSerializationContext lllllllllllllIlllIlIIllIllIIIlII) {
        if (lllllllllllllIlllIlIIllIllIIIllI.action() == HoverEvent.Action.SHOW_TEXT) {
            return lllllllllllllIlllIlIIllIllIIIlIl;
        }
        if (this.legacyHover != null) {
            Component lllllllllllllIlllIlIIllIllIIIIlI = null;
            try {
                if (lllllllllllllIlllIlIIllIllIIIllI.action() == HoverEvent.Action.SHOW_ENTITY) {
                    lllllllllllllIlllIlIIllIllIIIIlI = this.legacyHover.serializeShowEntity((HoverEvent.ShowEntity)lllllllllllllIlllIlIIllIllIIIllI.value(), this.encoder(lllllllllllllIlllIlIIllIllIIIlII));
                }
                else if (lllllllllllllIlllIlIIllIllIIIllI.action() == HoverEvent.Action.SHOW_ITEM) {
                    lllllllllllllIlllIlIIllIllIIIIlI = this.legacyHover.serializeShowItem((HoverEvent.ShowItem)lllllllllllllIlllIlIIllIllIIIllI.value());
                }
            }
            catch (IOException lllllllllllllIlllIlIIllIllIIIIll) {
                throw new JsonSyntaxException(lllllllllllllIlllIlIIllIllIIIIll);
            }
            return (lllllllllllllIlllIlIIllIllIIIIlI == null) ? JsonNull.INSTANCE : lllllllllllllIlllIlIIllIllIIIlII.serialize(lllllllllllllIlllIlIIllIllIIIIlI);
        }
        return JsonNull.INSTANCE;
    }
    
    private Object legacyHoverEventContents(final HoverEvent.Action<?> lllllllllllllIlllIlIIlllIIIllIll, final Component lllllllllllllIlllIlIIlllIIIlllII, final JsonDeserializationContext lllllllllllllIlllIlIIlllIIIllIlI) {
        if (lllllllllllllIlllIlIIlllIIIllIll == HoverEvent.Action.SHOW_TEXT) {
            return lllllllllllllIlllIlIIlllIIIlllII;
        }
        if (this.legacyHover != null) {
            try {
                if (lllllllllllllIlllIlIIlllIIIllIll == HoverEvent.Action.SHOW_ENTITY) {
                    return this.legacyHover.deserializeShowEntity(lllllllllllllIlllIlIIlllIIIlllII, this.decoder(lllllllllllllIlllIlIIlllIIIllIlI));
                }
                if (lllllllllllllIlllIlIIlllIIIllIll == HoverEvent.Action.SHOW_ITEM) {
                    return this.legacyHover.deserializeShowItem(lllllllllllllIlllIlIIlllIIIlllII);
                }
            }
            catch (IOException lllllllllllllIlllIlIIlllIIIllIIl) {
                throw new JsonParseException(lllllllllllllIlllIlIIlllIIIllIIl);
            }
        }
        throw new UnsupportedOperationException();
    }
    
    private Codec.Encoder<Component, String, RuntimeException> encoder(final JsonSerializationContext lllllllllllllIlllIlIIllIlIllIllI) {
        return (Codec.Encoder<Component, String, RuntimeException>)(lllllllllllllIlllIlIIllIlIIlIlll -> lllllllllllllIlllIlIIllIlIllIllI.serialize(lllllllllllllIlllIlIIllIlIIlIlll).toString());
    }
    
    StyleSerializer(@Nullable final LegacyHoverEventSerializer lllllllllllllIlllIlIIlllIllIlIlI, final boolean lllllllllllllIlllIlIIlllIllIlIll) {
        this.legacyHover = lllllllllllllIlllIlIIlllIllIlIlI;
        this.emitLegacyHover = lllllllllllllIlllIlIIlllIllIlIll;
    }
    
    static {
        HOVER_EVENT_ACTION = "action";
        HOVER_EVENT_VALUE = "value";
        HOVER_EVENT_CONTENTS = "contents";
        COLOR = "color";
        CLICK_EVENT_ACTION = "action";
        CLICK_EVENT_VALUE = "value";
        CLICK_EVENT = "clickEvent";
        HOVER_EVENT = "hoverEvent";
        FONT = "font";
        INSERTION = "insertion";
        DECORATIONS = new TextDecoration[] { TextDecoration.BOLD, TextDecoration.ITALIC, TextDecoration.UNDERLINED, TextDecoration.STRIKETHROUGH, TextDecoration.OBFUSCATED };
        final Set<TextDecoration> lllllllllllllIlllIlIIllIlIIIIlIl = EnumSet.allOf(TextDecoration.class);
        final char lllllllllllllIlllIlIIllIlIIIIIll = (Object)StyleSerializer.DECORATIONS;
        final String lllllllllllllIlllIlIIllIlIIIIIlI = (String)lllllllllllllIlllIlIIllIlIIIIIll.length;
        for (double lllllllllllllIlllIlIIllIlIIIIIIl = 0; lllllllllllllIlllIlIIllIlIIIIIIl < lllllllllllllIlllIlIIllIlIIIIIlI; ++lllllllllllllIlllIlIIllIlIIIIIIl) {
            final TextDecoration lllllllllllllIlllIlIIllIlIIIIllI = lllllllllllllIlllIlIIllIlIIIIIll[lllllllllllllIlllIlIIllIlIIIIIIl];
            lllllllllllllIlllIlIIllIlIIIIlIl.remove(lllllllllllllIlllIlIIllIlIIIIllI);
        }
        if (!lllllllllllllIlllIlIIllIlIIIIlIl.isEmpty()) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Gson serializer is missing some text decorations: ").append(lllllllllllllIlllIlIIllIlIIIIlIl)));
        }
    }
    
    @Override
    public JsonElement serialize(final Style lllllllllllllIlllIlIIllIlllllIlI, final Type lllllllllllllIlllIlIIllIlllllIIl, final JsonSerializationContext lllllllllllllIlllIlIIllIllllIlll) {
        final JsonObject lllllllllllllIlllIlIIllIlllIIIlI = new JsonObject();
        for (int lllllllllllllIlllIlIIllIllllIIll = 0, lllllllllllllIlllIlIIllIllllIIIl = StyleSerializer.DECORATIONS.length; lllllllllllllIlllIlIIllIllllIIll < lllllllllllllIlllIlIIllIllllIIIl; ++lllllllllllllIlllIlIIllIllllIIll) {
            final TextDecoration lllllllllllllIlllIlIIllIllllIlIl = StyleSerializer.DECORATIONS[lllllllllllllIlllIlIIllIllllIIll];
            final TextDecoration.State lllllllllllllIlllIlIIllIllllIlII = lllllllllllllIlllIlIIllIlllllIlI.decoration(lllllllllllllIlllIlIIllIllllIlIl);
            if (lllllllllllllIlllIlIIllIllllIlII != TextDecoration.State.NOT_SET) {
                final String lllllllllllllIlllIlIIllIllllIllI = TextDecoration.NAMES.key(lllllllllllllIlllIlIIllIllllIlIl);
                assert lllllllllllllIlllIlIIllIllllIllI != null;
                lllllllllllllIlllIlIIllIlllIIIlI.addProperty(lllllllllllllIlllIlIIllIllllIllI, lllllllllllllIlllIlIIllIllllIlII == TextDecoration.State.TRUE);
            }
        }
        final TextColor lllllllllllllIlllIlIIllIlllIIIII = lllllllllllllIlllIlIIllIlllllIlI.color();
        if (lllllllllllllIlllIlIIllIlllIIIII != null) {
            lllllllllllllIlllIlIIllIlllIIIlI.add("color", lllllllllllllIlllIlIIllIllllIlll.serialize(lllllllllllllIlllIlIIllIlllIIIII));
        }
        final String lllllllllllllIlllIlIIllIllIllllI = lllllllllllllIlllIlIIllIlllllIlI.insertion();
        if (lllllllllllllIlllIlIIllIllIllllI != null) {
            lllllllllllllIlllIlIIllIlllIIIlI.addProperty("insertion", lllllllllllllIlllIlIIllIllIllllI);
        }
        final ClickEvent lllllllllllllIlllIlIIllIllIlllII = lllllllllllllIlllIlIIllIlllllIlI.clickEvent();
        if (lllllllllllllIlllIlIIllIllIlllII != null) {
            final JsonObject lllllllllllllIlllIlIIllIlllIllll = new JsonObject();
            lllllllllllllIlllIlIIllIlllIllll.add("action", lllllllllllllIlllIlIIllIllllIlll.serialize(lllllllllllllIlllIlIIllIllIlllII.action()));
            lllllllllllllIlllIlIIllIlllIllll.addProperty("value", lllllllllllllIlllIlIIllIllIlllII.value());
            lllllllllllllIlllIlIIllIlllIIIlI.add("clickEvent", lllllllllllllIlllIlIIllIlllIllll);
        }
        final HoverEvent<?> lllllllllllllIlllIlIIllIllIllIlI = lllllllllllllIlllIlIIllIlllllIlI.hoverEvent();
        if (lllllllllllllIlllIlIIllIllIllIlI != null) {
            final JsonObject lllllllllllllIlllIlIIllIlllIllIl = new JsonObject();
            lllllllllllllIlllIlIIllIlllIllIl.add("action", lllllllllllllIlllIlIIllIllllIlll.serialize(lllllllllllllIlllIlIIllIllIllIlI.action()));
            final JsonElement lllllllllllllIlllIlIIllIlllIllII = lllllllllllllIlllIlIIllIllllIlll.serialize(lllllllllllllIlllIlIIllIllIllIlI.value());
            lllllllllllllIlllIlIIllIlllIllIl.add("contents", lllllllllllllIlllIlIIllIlllIllII);
            if (this.emitLegacyHover) {
                lllllllllllllIlllIlIIllIlllIllIl.add("value", this.serializeLegacyHoverEvent(lllllllllllllIlllIlIIllIllIllIlI, lllllllllllllIlllIlIIllIlllIllII, lllllllllllllIlllIlIIllIllllIlll));
            }
            lllllllllllllIlllIlIIllIlllIIIlI.add("hoverEvent", lllllllllllllIlllIlIIllIlllIllIl);
        }
        final Key lllllllllllllIlllIlIIllIllIllIIl = lllllllllllllIlllIlIIllIlllllIlI.font();
        if (lllllllllllllIlllIlIIllIllIllIIl != null) {
            lllllllllllllIlllIlIIllIlllIIIlI.add("font", lllllllllllllIlllIlIIllIllllIlll.serialize(lllllllllllllIlllIlIIllIllIllIIl));
        }
        return lllllllllllllIlllIlIIllIlllIIIlI;
    }
    
    private Codec.Decoder<Component, String, JsonParseException> decoder(final JsonDeserializationContext lllllllllllllIlllIlIIlllIIIIlllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokedynamic   BootstrapMethod #1, decode:(Lcom/viaversion/viaversion/libs/gson/JsonDeserializationContext;)Lcom/viaversion/viaversion/libs/kyori/adventure/util/Codec$Decoder;
        //     6: areturn        
        //    Signature:
        //  (Lcom/viaversion/viaversion/libs/gson/JsonDeserializationContext;)Lcom/viaversion/viaversion/libs/kyori/adventure/util/Codec$Decoder<Lcom/viaversion/viaversion/libs/kyori/adventure/text/Component;Ljava/lang/String;Lcom/viaversion/viaversion/libs/gson/JsonParseException;>;
        //    MethodParameters:
        //  Name                              Flags  
        //  --------------------------------  -----
        //  lllllllllllllIlllIlIIlllIIIIlllI  FINAL
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Could not infer any expression.
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static <T> T optionallyDeserialize(final JsonElement lllllllllllllIlllIlIIlllIIlIlIIl, final JsonDeserializationContext lllllllllllllIlllIlIIlllIIlIlIlI, final Class<T> lllllllllllllIlllIlIIlllIIlIlIII) {
        return (lllllllllllllIlllIlIIlllIIlIlIIl == null) ? null : lllllllllllllIlllIlIIlllIIlIlIlI.deserialize(lllllllllllllIlllIlIIlllIIlIlIIl, lllllllllllllIlllIlIIlllIIlIlIII);
    }
    
    @Override
    public Style deserialize(final JsonElement lllllllllllllIlllIlIIlllIlIlllll, final Type lllllllllllllIlllIlIIlllIlIlllIl, final JsonDeserializationContext lllllllllllllIlllIlIIlllIlIllllI) throws JsonParseException {
        final JsonObject lllllllllllllIlllIlIIlllIlIllIII = lllllllllllllIlllIlIIlllIlIlllll.getAsJsonObject();
        return this.deserialize(lllllllllllllIlllIlIIlllIlIllIII, lllllllllllllIlllIlIIlllIlIllllI);
    }
}
