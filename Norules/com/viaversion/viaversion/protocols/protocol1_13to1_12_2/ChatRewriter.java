package com.viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.legacyimpl.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.*;

public final class ChatRewriter
{
    private static final /* synthetic */ ComponentRewriter COMPONENT_REWRITER;
    public static final /* synthetic */ GsonComponentSerializer HOVER_GSON_SERIALIZER;
    
    public static String legacyTextToJsonString(final String llllllllllllllIIIllIlIIIlIIIIlll, final boolean llllllllllllllIIIllIlIIIlIIIlIIl) {
        final Component llllllllllllllIIIllIlIIIlIIIlIII = Component.text(llllllllllllllIIIllIlIIIIllIllII -> {
            if (llllllllllllllIIIllIlIIIlIIIlIIl) {
                llllllllllllllIIIllIlIIIIllIllII.decoration(TextDecoration.ITALIC, false);
            }
            llllllllllllllIIIllIlIIIIllIllII.append(LegacyComponentSerializer.legacySection().deserialize(llllllllllllllIIIllIlIIIlIIIIlll));
            return;
        });
        return ((ComponentSerializer<Component, O, String>)GsonComponentSerializer.gson()).serialize(llllllllllllllIIIllIlIIIlIIIlIII);
    }
    
    public static JsonElement legacyTextToJson(final String llllllllllllllIIIllIlIIIlIIIIIII) {
        return JsonParser.parseString(legacyTextToJsonString(llllllllllllllIIIllIlIIIlIIIIIII, false));
    }
    
    public static String jsonToLegacyText(final String llllllllllllllIIIllIlIIIIllllIlI) {
        try {
            final Component llllllllllllllIIIllIlIIIIlllllII = ((ComponentSerializer<I, Component, String>)ChatRewriter.HOVER_GSON_SERIALIZER).deserialize(llllllllllllllIIIllIlIIIIllllIlI);
            return LegacyComponentSerializer.legacySection().serialize(llllllllllllllIIIllIlIIIIlllllII);
        }
        catch (Exception llllllllllllllIIIllIlIIIIllllIll) {
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Error converting json text to legacy: ").append(llllllllllllllIIIllIlIIIIllllIlI)));
            llllllllllllllIIIllIlIIIIllllIll.printStackTrace();
            return "";
        }
    }
    
    public static String legacyTextToJsonString(final String llllllllllllllIIIllIlIIIlIIIIIlI) {
        return legacyTextToJsonString(llllllllllllllIIIllIlIIIlIIIIIlI, false);
    }
    
    static {
        HOVER_GSON_SERIALIZER = GsonComponentSerializer.builder().emitLegacyHoverEvent().legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.get()).build();
        COMPONENT_REWRITER = new ComponentRewriter1_13();
    }
    
    public static void processTranslate(final JsonElement llllllllllllllIIIllIlIIIIlllIllI) {
        ChatRewriter.COMPONENT_REWRITER.processText(llllllllllllllIIIllIlIIIIlllIllI);
    }
}
