package net.minecraft.util;

import javax.annotation.*;
import java.lang.reflect.*;
import org.apache.commons.lang3.*;
import com.google.gson.stream.*;
import com.google.gson.reflect.*;
import com.google.gson.*;
import net.minecraft.item.*;
import java.io.*;

public class JsonUtils
{
    public static boolean isString(final JsonElement llllllllllllllllIlllIlIllIIIlIll) {
        return llllllllllllllllIlllIlIllIIIlIll.isJsonPrimitive() && llllllllllllllllIlllIlIllIIIlIll.getAsJsonPrimitive().isString();
    }
    
    public static int getInt(final JsonObject llllllllllllllllIlllIlIIllIlllll, final String llllllllllllllllIlllIlIIllIlllII) {
        if (llllllllllllllllIlllIlIIllIlllll.has(llllllllllllllllIlllIlIIllIlllII)) {
            return getInt(llllllllllllllllIlllIlIIllIlllll.get(llllllllllllllllIlllIlIIllIlllII), llllllllllllllllIlllIlIIllIlllII);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIIllIlllII).append(", expected to find a Int")));
    }
    
    public static JsonArray getJsonArray(final JsonObject llllllllllllllllIlllIlIIlIIIIllI, final String llllllllllllllllIlllIlIIlIIIIlII, @Nullable final JsonArray llllllllllllllllIlllIlIIlIIIIIlI) {
        return llllllllllllllllIlllIlIIlIIIIllI.has(llllllllllllllllIlllIlIIlIIIIlII) ? getJsonArray(llllllllllllllllIlllIlIIlIIIIllI.get(llllllllllllllllIlllIlIIlIIIIlII), llllllllllllllllIlllIlIIlIIIIlII) : llllllllllllllllIlllIlIIlIIIIIlI;
    }
    
    @Nullable
    public static <T> T func_193840_a(final Gson llllllllllllllllIlllIIllllllIlll, final String llllllllllllllllIlllIIlllllllIIl, final Type llllllllllllllllIlllIIlllllllIII) {
        return func_193837_a(llllllllllllllllIlllIIllllllIlll, llllllllllllllllIlllIIlllllllIIl, llllllllllllllllIlllIIlllllllIII, false);
    }
    
    public static JsonObject getJsonObject(final JsonElement llllllllllllllllIlllIlIIllIIIIIl, final String llllllllllllllllIlllIlIIllIIIIII) {
        if (llllllllllllllllIlllIlIIllIIIIIl.isJsonObject()) {
            return llllllllllllllllIlllIlIIllIIIIIl.getAsJsonObject();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIIllIIIIII).append(" to be a JsonObject, was ").append(toString(llllllllllllllllIlllIlIIllIIIIIl))));
    }
    
    public static float getFloat(final JsonObject llllllllllllllllIlllIlIIllllIIIl, final String llllllllllllllllIlllIlIIllllIlII, final float llllllllllllllllIlllIlIIlllIllII) {
        return llllllllllllllllIlllIlIIllllIIIl.has(llllllllllllllllIlllIlIIllllIlII) ? getFloat(llllllllllllllllIlllIlIIllllIIIl.get(llllllllllllllllIlllIlIIllllIlII), llllllllllllllllIlllIlIIllllIlII) : llllllllllllllllIlllIlIIlllIllII;
    }
    
    public static <T> T deserializeClass(final JsonObject llllllllllllllllIlllIlIIIlIlllII, final String llllllllllllllllIlllIlIIIllIIIIl, final JsonDeserializationContext llllllllllllllllIlllIlIIIlIllIlI, final Class<? extends T> llllllllllllllllIlllIlIIIlIlllIl) {
        if (llllllllllllllllIlllIlIIIlIlllII.has(llllllllllllllllIlllIlIIIllIIIIl)) {
            return deserializeClass(llllllllllllllllIlllIlIIIlIlllII.get(llllllllllllllllIlllIlIIIllIIIIl), llllllllllllllllIlllIlIIIllIIIIl, llllllllllllllllIlllIlIIIlIllIlI, llllllllllllllllIlllIlIIIlIlllIl);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIIIllIIIIl)));
    }
    
    public static boolean getBoolean(final JsonObject llllllllllllllllIlllIlIlIIIllIlI, final String llllllllllllllllIlllIlIlIIIllIIl, final boolean llllllllllllllllIlllIlIlIIIllIll) {
        return llllllllllllllllIlllIlIlIIIllIlI.has(llllllllllllllllIlllIlIlIIIllIIl) ? getBoolean(llllllllllllllllIlllIlIlIIIllIlI.get(llllllllllllllllIlllIlIlIIIllIIl), llllllllllllllllIlllIlIlIIIllIIl) : llllllllllllllllIlllIlIlIIIllIll;
    }
    
    public static String toString(final JsonElement llllllllllllllllIlllIlIIIlIIIIIl) {
        final String llllllllllllllllIlllIlIIIlIIIIll = StringUtils.abbreviateMiddle(String.valueOf(llllllllllllllllIlllIlIIIlIIIIIl), "...", 10);
        if (llllllllllllllllIlllIlIIIlIIIIIl == null) {
            return "null (missing)";
        }
        if (llllllllllllllllIlllIlIIIlIIIIIl.isJsonNull()) {
            return "null (json)";
        }
        if (llllllllllllllllIlllIlIIIlIIIIIl.isJsonArray()) {
            return String.valueOf(new StringBuilder("an array (").append(llllllllllllllllIlllIlIIIlIIIIll).append(")"));
        }
        if (llllllllllllllllIlllIlIIIlIIIIIl.isJsonObject()) {
            return String.valueOf(new StringBuilder("an object (").append(llllllllllllllllIlllIlIIIlIIIIll).append(")"));
        }
        if (llllllllllllllllIlllIlIIIlIIIIIl.isJsonPrimitive()) {
            final JsonPrimitive llllllllllllllllIlllIlIIIlIIIIlI = llllllllllllllllIlllIlIIIlIIIIIl.getAsJsonPrimitive();
            if (llllllllllllllllIlllIlIIIlIIIIlI.isNumber()) {
                return String.valueOf(new StringBuilder("a number (").append(llllllllllllllllIlllIlIIIlIIIIll).append(")"));
            }
            if (llllllllllllllllIlllIlIIIlIIIIlI.isBoolean()) {
                return String.valueOf(new StringBuilder("a boolean (").append(llllllllllllllllIlllIlIIIlIIIIll).append(")"));
            }
        }
        return llllllllllllllllIlllIlIIIlIIIIll;
    }
    
    public static float getFloat(final JsonObject llllllllllllllllIlllIlIlIIIIIIlI, final String llllllllllllllllIlllIlIlIIIIIIIl) {
        if (llllllllllllllllIlllIlIlIIIIIIlI.has(llllllllllllllllIlllIlIlIIIIIIIl)) {
            return getFloat(llllllllllllllllIlllIlIlIIIIIIlI.get(llllllllllllllllIlllIlIlIIIIIIIl), llllllllllllllllIlllIlIlIIIIIIIl);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIlIIIIIIIl).append(", expected to find a Float")));
    }
    
    @Nullable
    public static <T> T func_193838_a(final Gson llllllllllllllllIlllIlIIIIlIlIIl, final Reader llllllllllllllllIlllIlIIIIlIlIII, final Type llllllllllllllllIlllIlIIIIlIIIIl, final boolean llllllllllllllllIlllIlIIIIlIIIII) {
        try {
            final JsonReader llllllllllllllllIlllIlIIIIlIIlIl = new JsonReader(llllllllllllllllIlllIlIIIIlIlIII);
            llllllllllllllllIlllIlIIIIlIIlIl.setLenient(llllllllllllllllIlllIlIIIIlIIIII);
            return (T)llllllllllllllllIlllIlIIIIlIlIIl.getAdapter(TypeToken.get(llllllllllllllllIlllIlIIIIlIIIIl)).read(llllllllllllllllIlllIlIIIIlIIlIl);
        }
        catch (IOException llllllllllllllllIlllIlIIIIlIIlII) {
            throw new JsonParseException((Throwable)llllllllllllllllIlllIlIIIIlIIlII);
        }
    }
    
    public static boolean isBoolean(final JsonObject llllllllllllllllIlllIlIllIIIIlII, final String llllllllllllllllIlllIlIllIIIIIll) {
        return isJsonPrimitive(llllllllllllllllIlllIlIllIIIIlII, llllllllllllllllIlllIlIllIIIIIll) && llllllllllllllllIlllIlIllIIIIlII.getAsJsonPrimitive(llllllllllllllllIlllIlIllIIIIIll).isBoolean();
    }
    
    public static boolean isNumber(final JsonElement llllllllllllllllIlllIlIllIIIIlll) {
        return llllllllllllllllIlllIlIllIIIIlll.isJsonPrimitive() && llllllllllllllllIlllIlIllIIIIlll.getAsJsonPrimitive().isNumber();
    }
    
    @Nullable
    public static <T> T func_193839_a(final Gson llllllllllllllllIlllIIllllllIIIl, final Reader llllllllllllllllIlllIIllllllIIII, final Class<T> llllllllllllllllIlllIIlllllIllII) {
        return gsonDeserialize(llllllllllllllllIlllIIllllllIIIl, llllllllllllllllIlllIIllllllIIII, llllllllllllllllIlllIIlllllIllII, false);
    }
    
    public static boolean isJsonPrimitive(final JsonObject llllllllllllllllIlllIlIlIlllIllI, final String llllllllllllllllIlllIlIlIlllIlll) {
        return hasField(llllllllllllllllIlllIlIlIlllIllI, llllllllllllllllIlllIlIlIlllIlll) && llllllllllllllllIlllIlIlIlllIllI.get(llllllllllllllllIlllIlIlIlllIlll).isJsonPrimitive();
    }
    
    public static int getInt(final JsonElement llllllllllllllllIlllIlIIlllIIIll, final String llllllllllllllllIlllIlIIlllIIlII) {
        if (llllllllllllllllIlllIlIIlllIIIll.isJsonPrimitive() && llllllllllllllllIlllIlIIlllIIIll.getAsJsonPrimitive().isNumber()) {
            return llllllllllllllllIlllIlIIlllIIIll.getAsInt();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIIlllIIlII).append(" to be a Int, was ").append(toString(llllllllllllllllIlllIlIIlllIIIll))));
    }
    
    public static <T> T deserializeClass(final JsonObject llllllllllllllllIlllIlIIIlIlIIIl, final String llllllllllllllllIlllIlIIIlIIlIll, final T llllllllllllllllIlllIlIIIlIIlIlI, final JsonDeserializationContext llllllllllllllllIlllIlIIIlIIlllI, final Class<? extends T> llllllllllllllllIlllIlIIIlIIlIII) {
        return llllllllllllllllIlllIlIIIlIlIIIl.has(llllllllllllllllIlllIlIIIlIIlIll) ? deserializeClass(llllllllllllllllIlllIlIIIlIlIIIl.get(llllllllllllllllIlllIlIIIlIIlIll), llllllllllllllllIlllIlIIIlIIlIll, llllllllllllllllIlllIlIIIlIIlllI, llllllllllllllllIlllIlIIIlIIlIII) : llllllllllllllllIlllIlIIIlIIlIlI;
    }
    
    public static JsonObject getJsonObject(final JsonObject llllllllllllllllIlllIlIIlIllllIl, final String llllllllllllllllIlllIlIIlIllllII) {
        if (llllllllllllllllIlllIlIIlIllllIl.has(llllllllllllllllIlllIlIIlIllllII)) {
            return getJsonObject(llllllllllllllllIlllIlIIlIllllIl.get(llllllllllllllllIlllIlIIlIllllII), llllllllllllllllIlllIlIIlIllllII);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIIlIllllII).append(", expected to find a JsonObject")));
    }
    
    public static Item getItem(final JsonObject llllllllllllllllIlllIlIlIlIIIlll, final String llllllllllllllllIlllIlIlIlIIIlIl) {
        if (llllllllllllllllIlllIlIlIlIIIlll.has(llllllllllllllllIlllIlIlIlIIIlIl)) {
            return getItem(llllllllllllllllIlllIlIlIlIIIlll.get(llllllllllllllllIlllIlIlIlIIIlIl), llllllllllllllllIlllIlIlIlIIIlIl);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIlIlIIIlIl).append(", expected to find an item")));
    }
    
    public static String getString(final JsonObject llllllllllllllllIlllIlIlIlIlllll, final String llllllllllllllllIlllIlIlIlIllIll, final String llllllllllllllllIlllIlIlIlIlllIl) {
        return llllllllllllllllIlllIlIlIlIlllll.has(llllllllllllllllIlllIlIlIlIllIll) ? getString(llllllllllllllllIlllIlIlIlIlllll.get(llllllllllllllllIlllIlIlIlIllIll), llllllllllllllllIlllIlIlIlIllIll) : llllllllllllllllIlllIlIlIlIlllIl;
    }
    
    public static String getString(final JsonElement llllllllllllllllIlllIlIlIllIlIlI, final String llllllllllllllllIlllIlIlIllIlIIl) {
        if (llllllllllllllllIlllIlIlIllIlIlI.isJsonPrimitive()) {
            return llllllllllllllllIlllIlIlIllIlIlI.getAsString();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIlIllIlIIl).append(" to be a string, was ").append(toString(llllllllllllllllIlllIlIlIllIlIlI))));
    }
    
    public static boolean getBoolean(final JsonObject llllllllllllllllIlllIlIlIIlIIlIl, final String llllllllllllllllIlllIlIlIIlIIlII) {
        if (llllllllllllllllIlllIlIlIIlIIlIl.has(llllllllllllllllIlllIlIlIIlIIlII)) {
            return getBoolean(llllllllllllllllIlllIlIlIIlIIlIl.get(llllllllllllllllIlllIlIlIIlIIlII), llllllllllllllllIlllIlIlIIlIIlII);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIlIIlIIlII).append(", expected to find a Boolean")));
    }
    
    public static JsonArray getJsonArray(final JsonElement llllllllllllllllIlllIlIIlIIllIIl, final String llllllllllllllllIlllIlIIlIIlIlll) {
        if (llllllllllllllllIlllIlIIlIIllIIl.isJsonArray()) {
            return llllllllllllllllIlllIlIIlIIllIIl.getAsJsonArray();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIIlIIlIlll).append(" to be a JsonArray, was ").append(toString(llllllllllllllllIlllIlIIlIIllIIl))));
    }
    
    public static int getInt(final JsonObject llllllllllllllllIlllIlIIllIlIIll, final String llllllllllllllllIlllIlIIllIlIIII, final int llllllllllllllllIlllIlIIllIlIlIl) {
        return llllllllllllllllIlllIlIIllIlIIll.has(llllllllllllllllIlllIlIIllIlIIII) ? getInt(llllllllllllllllIlllIlIIllIlIIll.get(llllllllllllllllIlllIlIIllIlIIII), llllllllllllllllIlllIlIIllIlIIII) : llllllllllllllllIlllIlIIllIlIlIl;
    }
    
    @Nullable
    public static <T> T func_193837_a(final Gson llllllllllllllllIlllIlIIIIIllIlI, final String llllllllllllllllIlllIlIIIIIlIlIl, final Type llllllllllllllllIlllIlIIIIIlIlII, final boolean llllllllllllllllIlllIlIIIIIlIIll) {
        return func_193838_a(llllllllllllllllIlllIlIIIIIllIlI, new StringReader(llllllllllllllllIlllIlIIIIIlIlIl), llllllllllllllllIlllIlIIIIIlIlII, llllllllllllllllIlllIlIIIIIlIIll);
    }
    
    public static boolean hasField(final JsonObject llllllllllllllllIlllIlIlIlllIIlI, final String llllllllllllllllIlllIlIlIllIllll) {
        return llllllllllllllllIlllIlIlIlllIIlI != null && llllllllllllllllIlllIlIlIlllIIlI.get(llllllllllllllllIlllIlIlIllIllll) != null;
    }
    
    @Nullable
    public static <T> T gsonDeserialize(final Gson llllllllllllllllIlllIlIIIIlllIIl, final Reader llllllllllllllllIlllIlIIIIllIIlI, final Class<T> llllllllllllllllIlllIlIIIIllIIIl, final boolean llllllllllllllllIlllIlIIIIllIIII) {
        try {
            final JsonReader llllllllllllllllIlllIlIIIIllIlIl = new JsonReader(llllllllllllllllIlllIlIIIIllIIlI);
            llllllllllllllllIlllIlIIIIllIlIl.setLenient(llllllllllllllllIlllIlIIIIllIIII);
            return (T)llllllllllllllllIlllIlIIIIlllIIl.getAdapter((Class)llllllllllllllllIlllIlIIIIllIIIl).read(llllllllllllllllIlllIlIIIIllIlIl);
        }
        catch (IOException llllllllllllllllIlllIlIIIIllIlII) {
            throw new JsonParseException((Throwable)llllllllllllllllIlllIlIIIIllIlII);
        }
    }
    
    public static <T> T deserializeClass(@Nullable final JsonElement llllllllllllllllIlllIlIIIllIlllI, final String llllllllllllllllIlllIlIIIllIllIl, final JsonDeserializationContext llllllllllllllllIlllIlIIIllIllII, final Class<? extends T> llllllllllllllllIlllIlIIIllIlIll) {
        if (llllllllllllllllIlllIlIIIllIlllI != null) {
            return (T)llllllllllllllllIlllIlIIIllIllII.deserialize(llllllllllllllllIlllIlIIIllIlllI, (Type)llllllllllllllllIlllIlIIIllIlIll);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIIIllIllIl)));
    }
    
    public static Item getItem(final JsonElement llllllllllllllllIlllIlIlIlIlIIIl, final String llllllllllllllllIlllIlIlIlIlIlII) {
        if (!llllllllllllllllIlllIlIlIlIlIIIl.isJsonPrimitive()) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIlIlIlIlII).append(" to be an item, was ").append(toString(llllllllllllllllIlllIlIlIlIlIIIl))));
        }
        final String llllllllllllllllIlllIlIlIlIlIIll = llllllllllllllllIlllIlIlIlIlIIIl.getAsString();
        final Item llllllllllllllllIlllIlIlIlIlIIlI = Item.getByNameOrId(llllllllllllllllIlllIlIlIlIlIIll);
        if (llllllllllllllllIlllIlIlIlIlIIlI == null) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIlIlIlIlII).append(" to be an item, was unknown string '").append(llllllllllllllllIlllIlIlIlIlIIll).append("'")));
        }
        return llllllllllllllllIlllIlIlIlIlIIlI;
    }
    
    public static String getString(final JsonObject llllllllllllllllIlllIlIlIllIIlII, final String llllllllllllllllIlllIlIlIllIIlIl) {
        if (llllllllllllllllIlllIlIlIllIIlII.has(llllllllllllllllIlllIlIlIllIIlIl)) {
            return getString(llllllllllllllllIlllIlIlIllIIlII.get(llllllllllllllllIlllIlIlIllIIlIl), llllllllllllllllIlllIlIlIllIIlIl);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIlIllIIlIl).append(", expected to find a string")));
    }
    
    @Nullable
    public static <T> T gsonDeserialize(final Gson llllllllllllllllIlllIIlllllIIlIl, final String llllllllllllllllIlllIIlllllIIlll, final Class<T> llllllllllllllllIlllIIlllllIIllI) {
        return gsonDeserialize(llllllllllllllllIlllIIlllllIIlIl, llllllllllllllllIlllIIlllllIIlll, llllllllllllllllIlllIIlllllIIllI, false);
    }
    
    public static float getFloat(final JsonElement llllllllllllllllIlllIlIlIIIIlllI, final String llllllllllllllllIlllIlIlIIIIllII) {
        if (llllllllllllllllIlllIlIlIIIIlllI.isJsonPrimitive() && llllllllllllllllIlllIlIlIIIIlllI.getAsJsonPrimitive().isNumber()) {
            return llllllllllllllllIlllIlIlIIIIlllI.getAsFloat();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIlIIIIllII).append(" to be a Float, was ").append(toString(llllllllllllllllIlllIlIlIIIIlllI))));
    }
    
    @Nullable
    public static <T> T gsonDeserialize(final Gson llllllllllllllllIlllIlIIIIIIlllI, final String llllllllllllllllIlllIlIIIIIIllIl, final Class<T> llllllllllllllllIlllIlIIIIIIllII, final boolean llllllllllllllllIlllIlIIIIIIlIll) {
        return gsonDeserialize(llllllllllllllllIlllIlIIIIIIlllI, new StringReader(llllllllllllllllIlllIlIIIIIIllIl), llllllllllllllllIlllIlIIIIIIllII, llllllllllllllllIlllIlIIIIIIlIll);
    }
    
    public static boolean isJsonArray(final JsonObject llllllllllllllllIlllIlIlIllllllI, final String llllllllllllllllIlllIlIlIlllllIl) {
        return hasField(llllllllllllllllIlllIlIlIllllllI, llllllllllllllllIlllIlIlIlllllIl) && llllllllllllllllIlllIlIlIllllllI.get(llllllllllllllllIlllIlIlIlllllIl).isJsonArray();
    }
    
    @Nullable
    public static <T> T func_193841_a(final Gson llllllllllllllllIlllIlIIIIIIIIII, final Reader llllllllllllllllIlllIlIIIIIIIIlI, final Type llllllllllllllllIlllIIlllllllllI) {
        return func_193838_a(llllllllllllllllIlllIlIIIIIIIIII, llllllllllllllllIlllIlIIIIIIIIlI, llllllllllllllllIlllIIlllllllllI, false);
    }
    
    public static boolean isString(final JsonObject llllllllllllllllIlllIlIllIIlIIII, final String llllllllllllllllIlllIlIllIIIllll) {
        return isJsonPrimitive(llllllllllllllllIlllIlIllIIlIIII, llllllllllllllllIlllIlIllIIIllll) && llllllllllllllllIlllIlIllIIlIIII.getAsJsonPrimitive(llllllllllllllllIlllIlIllIIIllll).isString();
    }
    
    public static JsonArray getJsonArray(final JsonObject llllllllllllllllIlllIlIIlIIIlllI, final String llllllllllllllllIlllIlIIlIIIllII) {
        if (llllllllllllllllIlllIlIIlIIIlllI.has(llllllllllllllllIlllIlIIlIIIllII)) {
            return getJsonArray(llllllllllllllllIlllIlIIlIIIlllI.get(llllllllllllllllIlllIlIIlIIIllII), llllllllllllllllIlllIlIIlIIIllII);
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Missing ").append(llllllllllllllllIlllIlIIlIIIllII).append(", expected to find a JsonArray")));
    }
    
    public static JsonObject getJsonObject(final JsonObject llllllllllllllllIlllIlIIlIlIllll, final String llllllllllllllllIlllIlIIlIlIlllI, final JsonObject llllllllllllllllIlllIlIIlIlIllII) {
        return llllllllllllllllIlllIlIIlIlIllll.has(llllllllllllllllIlllIlIIlIlIlllI) ? getJsonObject(llllllllllllllllIlllIlIIlIlIllll.get(llllllllllllllllIlllIlIIlIlIlllI), llllllllllllllllIlllIlIIlIlIlllI) : llllllllllllllllIlllIlIIlIlIllII;
    }
    
    public static boolean getBoolean(final JsonElement llllllllllllllllIlllIlIlIIllIlll, final String llllllllllllllllIlllIlIlIIlllIIl) {
        if (llllllllllllllllIlllIlIlIIllIlll.isJsonPrimitive()) {
            return llllllllllllllllIlllIlIlIIllIlll.getAsBoolean();
        }
        throw new JsonSyntaxException(String.valueOf(new StringBuilder("Expected ").append(llllllllllllllllIlllIlIlIIlllIIl).append(" to be a Boolean, was ").append(toString(llllllllllllllllIlllIlIlIIllIlll))));
    }
}
