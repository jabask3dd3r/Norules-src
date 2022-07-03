package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.chat;

import java.util.regex.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;
import com.google.common.base.*;

@Deprecated
public class TagSerializer
{
    private static final /* synthetic */ Pattern PLAIN_TEXT;
    
    private static JsonElement toJson(final Tag llllllllllllllIIlIlllIlIIllIIlll) {
        if (llllllllllllllIIlIlllIlIIllIIlll instanceof CompoundTag) {
            return toJson((CompoundTag)llllllllllllllIIlIlllIlIIllIIlll);
        }
        if (llllllllllllllIIlIlllIlIIllIIlll instanceof ListTag) {
            final ListTag llllllllllllllIIlIlllIlIIllIlIIl = (ListTag)llllllllllllllIIlIlllIlIIllIIlll;
            final JsonArray llllllllllllllIIlIlllIlIIllIlIII = new JsonArray();
            for (final Tag llllllllllllllIIlIlllIlIIllIlIlI : llllllllllllllIIlIlllIlIIllIlIIl) {
                llllllllllllllIIlIlllIlIIllIlIII.add(toJson(llllllllllllllIIlIlllIlIIllIlIlI));
            }
            return llllllllllllllIIlIlllIlIIllIlIII;
        }
        return new JsonPrimitive(llllllllllllllIIlIlllIlIIllIIlll.getValue().toString());
    }
    
    static {
        PLAIN_TEXT = Pattern.compile("[A-Za-z0-9._+-]+");
    }
    
    public static String toString(final JsonObject llllllllllllllIIlIlllIlIlIIlIIII) {
        final StringBuilder llllllllllllllIIlIlllIlIlIIIllll = new StringBuilder("{");
        for (final Map.Entry<String, JsonElement> llllllllllllllIIlIlllIlIlIIlIIIl : llllllllllllllIIlIlllIlIlIIlIIII.entrySet()) {
            Preconditions.checkArgument(llllllllllllllIIlIlllIlIlIIlIIIl.getValue().isJsonPrimitive());
            if (llllllllllllllIIlIlllIlIlIIIllll.length() != 1) {
                llllllllllllllIIlIlllIlIlIIIllll.append(',');
            }
            final String llllllllllllllIIlIlllIlIlIIlIIll = escape(llllllllllllllIIlIlllIlIlIIlIIIl.getValue().getAsString());
            llllllllllllllIIlIlllIlIlIIIllll.append(llllllllllllllIIlIlllIlIlIIlIIIl.getKey()).append(':').append(llllllllllllllIIlIlllIlIlIIlIIll);
        }
        return String.valueOf(llllllllllllllIIlIlllIlIlIIIllll.append('}'));
    }
    
    public static JsonObject toJson(final CompoundTag llllllllllllllIIlIlllIlIIlllIlIl) {
        final JsonObject llllllllllllllIIlIlllIlIIlllIlII = new JsonObject();
        for (final Map.Entry<String, Tag> llllllllllllllIIlIlllIlIIlllIllI : llllllllllllllIIlIlllIlIIlllIlIl.entrySet()) {
            llllllllllllllIIlIlllIlIIlllIlII.add(llllllllllllllIIlIlllIlIIlllIllI.getKey(), toJson(llllllllllllllIIlIlllIlIIlllIllI.getValue()));
        }
        return llllllllllllllIIlIlllIlIIlllIlII;
    }
    
    public static String escape(final String llllllllllllllIIlIlllIlIIlIllIlI) {
        if (TagSerializer.PLAIN_TEXT.matcher(llllllllllllllIIlIlllIlIIlIllIlI).matches()) {
            return llllllllllllllIIlIlllIlIIlIllIlI;
        }
        final StringBuilder llllllllllllllIIlIlllIlIIlIllIIl = new StringBuilder(" ");
        char llllllllllllllIIlIlllIlIIlIllIII = '\0';
        for (int llllllllllllllIIlIlllIlIIlIllIll = 0; llllllllllllllIIlIlllIlIIlIllIll < llllllllllllllIIlIlllIlIIlIllIlI.length(); ++llllllllllllllIIlIlllIlIIlIllIll) {
            final char llllllllllllllIIlIlllIlIIlIlllII = llllllllllllllIIlIlllIlIIlIllIlI.charAt(llllllllllllllIIlIlllIlIIlIllIll);
            if (llllllllllllllIIlIlllIlIIlIlllII == '\\') {
                llllllllllllllIIlIlllIlIIlIllIIl.append('\\');
            }
            else if (llllllllllllllIIlIlllIlIIlIlllII == '\"' || llllllllllllllIIlIlllIlIIlIlllII == '\'') {
                if (llllllllllllllIIlIlllIlIIlIllIII == '\0') {
                    llllllllllllllIIlIlllIlIIlIllIII = ((llllllllllllllIIlIlllIlIIlIlllII == '\"') ? '\'' : '\"');
                }
                if (llllllllllllllIIlIlllIlIIlIllIII == llllllllllllllIIlIlllIlIIlIlllII) {
                    llllllllllllllIIlIlllIlIIlIllIIl.append('\\');
                }
            }
            llllllllllllllIIlIlllIlIIlIllIIl.append(llllllllllllllIIlIlllIlIIlIlllII);
        }
        if (llllllllllllllIIlIlllIlIIlIllIII == '\0') {
            llllllllllllllIIlIlllIlIIlIllIII = '\"';
        }
        llllllllllllllIIlIlllIlIIlIllIIl.setCharAt(0, llllllllllllllIIlIlllIlIIlIllIII);
        llllllllllllllIIlIlllIlIIlIllIIl.append(llllllllllllllIIlIlllIlIIlIllIII);
        return String.valueOf(llllllllllllllIIlIlllIlIIlIllIIl);
    }
}
