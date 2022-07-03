package de.gerrygames.viarewind.utils;

import java.util.regex.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import de.gerrygames.viarewind.*;
import java.util.logging.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;

public class ChatUtil
{
    private static final /* synthetic */ Pattern UNUSED_COLOR_PATTERN;
    
    static {
        UNUSED_COLOR_PATTERN = Pattern.compile("(?>(?>§[0-fk-or])*(§r|\\Z))|(?>(?>§[0-f])*(§[0-f]))");
    }
    
    public static String removeUnusedColor(String lllllllllllllIlIlIllIIIlIIIlIIll, char lllllllllllllIlIlIllIIIlIIIIllll) {
        if (lllllllllllllIlIlIllIIIlIIIlIIll == null) {
            return null;
        }
        lllllllllllllIlIlIllIIIlIIIlIIll = ChatUtil.UNUSED_COLOR_PATTERN.matcher(lllllllllllllIlIlIllIIIlIIIlIIll).replaceAll("$1$2");
        final StringBuilder lllllllllllllIlIlIllIIIlIIIlIIIl = new StringBuilder();
        for (int lllllllllllllIlIlIllIIIlIIIlIlII = 0; lllllllllllllIlIlIllIIIlIIIlIlII < lllllllllllllIlIlIllIIIlIIIlIIll.length(); ++lllllllllllllIlIlIllIIIlIIIlIlII) {
            char lllllllllllllIlIlIllIIIlIIIlIlIl = lllllllllllllIlIlIllIIIlIIIlIIll.charAt(lllllllllllllIlIlIllIIIlIIIlIlII);
            if (lllllllllllllIlIlIllIIIlIIIlIlIl != '§' || lllllllllllllIlIlIllIIIlIIIlIlII == lllllllllllllIlIlIllIIIlIIIlIIll.length() - 1) {
                lllllllllllllIlIlIllIIIlIIIlIIIl.append(lllllllllllllIlIlIllIIIlIIIlIlIl);
            }
            else {
                lllllllllllllIlIlIllIIIlIIIlIlIl = lllllllllllllIlIlIllIIIlIIIlIIll.charAt(++lllllllllllllIlIlIllIIIlIIIlIlII);
                if (lllllllllllllIlIlIllIIIlIIIlIlIl != lllllllllllllIlIlIllIIIlIIIIllll) {
                    lllllllllllllIlIlIllIIIlIIIlIIIl.append('§').append(lllllllllllllIlIlIllIIIlIIIlIlIl);
                    lllllllllllllIlIlIllIIIlIIIIllll = lllllllllllllIlIlIllIIIlIIIlIlIl;
                }
            }
        }
        return String.valueOf(lllllllllllllIlIlIllIIIlIIIlIIIl);
    }
    
    public static String jsonToLegacy(final JsonElement lllllllllllllIlIlIllIIIlIIIllllI) {
        if (lllllllllllllIlIlIllIIIlIIIllllI.isJsonNull() || (lllllllllllllIlIlIllIIIlIIIllllI.isJsonArray() && lllllllllllllIlIlIllIIIlIIIllllI.getAsJsonArray().isEmpty()) || (lllllllllllllIlIlIllIIIlIIIllllI.isJsonObject() && lllllllllllllIlIlIllIIIlIIIllllI.getAsJsonObject().size() == 0)) {
            return "";
        }
        if (lllllllllllllIlIlIllIIIlIIIllllI.isJsonPrimitive()) {
            return lllllllllllllIlIlIllIIIlIIIllllI.getAsString();
        }
        return jsonToLegacy(lllllllllllllIlIlIllIIIlIIIllllI.toString());
    }
    
    public static String legacyToJson(final String lllllllllllllIlIlIllIIIlIIIlllII) {
        if (lllllllllllllIlIlIllIIIlIIIlllII == null) {
            return "";
        }
        return ((ComponentSerializer<TextComponent, O, String>)GsonComponentSerializer.gson()).serialize(LegacyComponentSerializer.legacySection().deserialize(lllllllllllllIlIlIllIIIlIIIlllII));
    }
    
    public static String jsonToLegacy(final String lllllllllllllIlIlIllIIIlIIlIIIll) {
        if (lllllllllllllIlIlIllIIIlIIlIIIll == null || lllllllllllllIlIlIllIIIlIIlIIIll.equals("null") || lllllllllllllIlIlIllIIIlIIlIIIll.isEmpty()) {
            return "";
        }
        try {
            String lllllllllllllIlIlIllIIIlIIlIIlIl;
            for (lllllllllllllIlIlIllIIIlIIlIIlIl = LegacyComponentSerializer.legacySection().serialize(((ComponentSerializer<I, Component, String>)ChatRewriter.HOVER_GSON_SERIALIZER).deserialize(lllllllllllllIlIlIllIIIlIIlIIIll)); lllllllllllllIlIlIllIIIlIIlIIlIl.startsWith("§f"); lllllllllllllIlIlIllIIIlIIlIIlIl = lllllllllllllIlIlIllIIIlIIlIIlIl.substring(2)) {}
            return lllllllllllllIlIlIllIIIlIIlIIlIl;
        }
        catch (Exception lllllllllllllIlIlIllIIIlIIlIIlII) {
            ViaRewind.getPlatform().getLogger().log(Level.WARNING, String.valueOf(new StringBuilder().append("Could not convert component to legacy text: ").append(lllllllllllllIlIlIllIIIlIIlIIIll)), lllllllllllllIlIlIllIIIlIIlIIlII);
            return "";
        }
    }
}
