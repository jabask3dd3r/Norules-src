package net.minecraft.util.text;

import java.lang.reflect.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.util.*;
import com.google.gson.*;

public interface ITextComponent extends Iterable<ITextComponent>
{
    Style getStyle();
    
    List<ITextComponent> getSiblings();
    
    String getUnformattedText();
    
    String getFormattedText();
    
    ITextComponent appendSibling(final ITextComponent p0);
    
    ITextComponent appendText(final String p0);
    
    ITextComponent createCopy();
    
    ITextComponent setStyle(final Style p0);
    
    String getUnformattedComponentText();
    
    public static class Serializer implements JsonDeserializer<ITextComponent>, JsonSerializer<ITextComponent>
    {
        private static final /* synthetic */ Gson GSON;
        
        @Nullable
        public static ITextComponent fromJsonLenient(final String lIllIllllIIIlIl) {
            return JsonUtils.gsonDeserialize(Serializer.GSON, lIllIllllIIIlIl, ITextComponent.class, true);
        }
        
        private void serializeChatStyle(final Style lIllIllllllIllI, final JsonObject lIllIllllllIlIl, final JsonSerializationContext lIllIlllllllIlI) {
            final JsonElement lIllIlllllllIIl = lIllIlllllllIlI.serialize((Object)lIllIllllllIllI);
            if (lIllIlllllllIIl.isJsonObject()) {
                final JsonObject lIllIlllllllIII = (JsonObject)lIllIlllllllIIl;
                for (final Map.Entry<String, JsonElement> lIllIllllllIlll : lIllIlllllllIII.entrySet()) {
                    lIllIllllllIlIl.add((String)lIllIllllllIlll.getKey(), (JsonElement)lIllIllllllIlll.getValue());
                }
            }
        }
        
        static {
            final GsonBuilder lIlllIIIIllIllI = new GsonBuilder();
            lIlllIIIIllIllI.registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new Serializer());
            lIlllIIIIllIllI.registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer());
            lIlllIIIIllIllI.registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory());
            GSON = lIlllIIIIllIllI.create();
        }
        
        @Nullable
        public static ITextComponent jsonToComponent(final String lIllIllllIIlIIl) {
            return JsonUtils.gsonDeserialize(Serializer.GSON, lIllIllllIIlIIl, ITextComponent.class, false);
        }
        
        public ITextComponent deserialize(final JsonElement lIlllIIIIIIlllI, final Type lIlllIIIIlIIlII, final JsonDeserializationContext lIlllIIIIlIIIll) throws JsonParseException {
            if (lIlllIIIIIIlllI.isJsonPrimitive()) {
                return new TextComponentString(lIlllIIIIIIlllI.getAsString());
            }
            if (lIlllIIIIIIlllI.isJsonObject()) {
                final JsonObject lIlllIIIIIllllI = lIlllIIIIIIlllI.getAsJsonObject();
                ITextComponent lIlllIIIIIllIII = null;
                if (lIlllIIIIIllllI.has("text")) {
                    final ITextComponent lIlllIIIIIlllIl = new TextComponentString(lIlllIIIIIllllI.get("text").getAsString());
                }
                else if (lIlllIIIIIllllI.has("translate")) {
                    final String lIlllIIIIIlIlll = lIlllIIIIIllllI.get("translate").getAsString();
                    if (lIlllIIIIIllllI.has("with")) {
                        final JsonArray lIlllIIIIIlIllI = lIlllIIIIIllllI.getAsJsonArray("with");
                        final Object[] lIlllIIIIIlIlIl = new Object[lIlllIIIIIlIllI.size()];
                        for (int lIlllIIIIIlIlII = 0; lIlllIIIIIlIlII < lIlllIIIIIlIlIl.length; ++lIlllIIIIIlIlII) {
                            lIlllIIIIIlIlIl[lIlllIIIIIlIlII] = this.deserialize(lIlllIIIIIlIllI.get(lIlllIIIIIlIlII), lIlllIIIIlIIlII, lIlllIIIIlIIIll);
                            if (lIlllIIIIIlIlIl[lIlllIIIIIlIlII] instanceof TextComponentString) {
                                final TextComponentString lIlllIIIIIlIIll = (TextComponentString)lIlllIIIIIlIlIl[lIlllIIIIIlIlII];
                                if (lIlllIIIIIlIIll.getStyle().isEmpty() && lIlllIIIIIlIIll.getSiblings().isEmpty()) {
                                    lIlllIIIIIlIlIl[lIlllIIIIIlIlII] = lIlllIIIIIlIIll.getText();
                                }
                            }
                        }
                        final ITextComponent lIlllIIIIIlllII = new TextComponentTranslation(lIlllIIIIIlIlll, lIlllIIIIIlIlIl);
                    }
                    else {
                        final ITextComponent lIlllIIIIIllIll = new TextComponentTranslation(lIlllIIIIIlIlll, new Object[0]);
                    }
                }
                else if (lIlllIIIIIllllI.has("score")) {
                    final JsonObject lIlllIIIIIlIIlI = lIlllIIIIIllllI.getAsJsonObject("score");
                    if (!lIlllIIIIIlIIlI.has("name") || !lIlllIIIIIlIIlI.has("objective")) {
                        throw new JsonParseException("A score component needs a least a name and an objective");
                    }
                    final ITextComponent lIlllIIIIIllIlI = new TextComponentScore(JsonUtils.getString(lIlllIIIIIlIIlI, "name"), JsonUtils.getString(lIlllIIIIIlIIlI, "objective"));
                    if (lIlllIIIIIlIIlI.has("value")) {
                        ((TextComponentScore)lIlllIIIIIllIlI).setValue(JsonUtils.getString(lIlllIIIIIlIIlI, "value"));
                    }
                }
                else if (lIlllIIIIIllllI.has("selector")) {
                    final ITextComponent lIlllIIIIIllIIl = new TextComponentSelector(JsonUtils.getString(lIlllIIIIIllllI, "selector"));
                }
                else {
                    if (!lIlllIIIIIllllI.has("keybind")) {
                        throw new JsonParseException(String.valueOf(new StringBuilder("Don't know how to turn ").append(lIlllIIIIIIlllI).append(" into a Component")));
                    }
                    lIlllIIIIIllIII = new TextComponentKeybind(JsonUtils.getString(lIlllIIIIIllllI, "keybind"));
                }
                if (lIlllIIIIIllllI.has("extra")) {
                    final JsonArray lIlllIIIIIlIIIl = lIlllIIIIIllllI.getAsJsonArray("extra");
                    if (lIlllIIIIIlIIIl.size() <= 0) {
                        throw new JsonParseException("Unexpected empty array of components");
                    }
                    for (int lIlllIIIIIlIIII = 0; lIlllIIIIIlIIII < lIlllIIIIIlIIIl.size(); ++lIlllIIIIIlIIII) {
                        lIlllIIIIIllIII.appendSibling(this.deserialize(lIlllIIIIIlIIIl.get(lIlllIIIIIlIIII), lIlllIIIIlIIlII, lIlllIIIIlIIIll));
                    }
                }
                lIlllIIIIIllIII.setStyle((Style)lIlllIIIIlIIIll.deserialize(lIlllIIIIIIlllI, (Type)Style.class));
                return lIlllIIIIIllIII;
            }
            if (lIlllIIIIIIlllI.isJsonArray()) {
                final JsonArray lIlllIIIIlIIIlI = lIlllIIIIIIlllI.getAsJsonArray();
                ITextComponent lIlllIIIIlIIIIl = null;
                for (final JsonElement lIlllIIIIlIIIII : lIlllIIIIlIIIlI) {
                    final ITextComponent lIlllIIIIIlllll = this.deserialize(lIlllIIIIlIIIII, lIlllIIIIlIIIII.getClass(), lIlllIIIIlIIIll);
                    if (lIlllIIIIlIIIIl == null) {
                        lIlllIIIIlIIIIl = lIlllIIIIIlllll;
                    }
                    else {
                        lIlllIIIIlIIIIl.appendSibling(lIlllIIIIIlllll);
                    }
                }
                return lIlllIIIIlIIIIl;
            }
            throw new JsonParseException(String.valueOf(new StringBuilder("Don't know how to turn ").append(lIlllIIIIIIlllI).append(" into a Component")));
        }
        
        public static String componentToJson(final ITextComponent lIllIllllIIlIll) {
            return Serializer.GSON.toJson((Object)lIllIllllIIlIll);
        }
        
        public JsonElement serialize(final ITextComponent lIllIlllllIIlII, final Type lIllIlllllIIIll, final JsonSerializationContext lIllIllllIlIlIl) {
            final JsonObject lIllIlllllIIIIl = new JsonObject();
            if (!lIllIlllllIIlII.getStyle().isEmpty()) {
                this.serializeChatStyle(lIllIlllllIIlII.getStyle(), lIllIlllllIIIIl, lIllIllllIlIlIl);
            }
            if (!lIllIlllllIIlII.getSiblings().isEmpty()) {
                final JsonArray lIllIlllllIIIII = new JsonArray();
                for (final ITextComponent lIllIllllIlllll : lIllIlllllIIlII.getSiblings()) {
                    lIllIlllllIIIII.add(this.serialize(lIllIllllIlllll, lIllIllllIlllll.getClass(), lIllIllllIlIlIl));
                }
                lIllIlllllIIIIl.add("extra", (JsonElement)lIllIlllllIIIII);
            }
            if (lIllIlllllIIlII instanceof TextComponentString) {
                lIllIlllllIIIIl.addProperty("text", ((TextComponentString)lIllIlllllIIlII).getText());
            }
            else if (lIllIlllllIIlII instanceof TextComponentTranslation) {
                final TextComponentTranslation lIllIllllIllllI = (TextComponentTranslation)lIllIlllllIIlII;
                lIllIlllllIIIIl.addProperty("translate", lIllIllllIllllI.getKey());
                if (lIllIllllIllllI.getFormatArgs() != null && lIllIllllIllllI.getFormatArgs().length > 0) {
                    final JsonArray lIllIllllIlllIl = new JsonArray();
                    final boolean lIllIllllIIlllI;
                    final char lIllIllllIIllll = (char)((Object[])(Object)(lIllIllllIIlllI = (boolean)lIllIllllIllllI.getFormatArgs())).length;
                    for (short lIllIllllIlIIII = 0; lIllIllllIlIIII < lIllIllllIIllll; ++lIllIllllIlIIII) {
                        final Object lIllIllllIlllII = lIllIllllIIlllI[lIllIllllIlIIII];
                        if (lIllIllllIlllII instanceof ITextComponent) {
                            lIllIllllIlllIl.add(this.serialize((ITextComponent)lIllIllllIlllII, lIllIllllIlllII.getClass(), lIllIllllIlIlIl));
                        }
                        else {
                            lIllIllllIlllIl.add((JsonElement)new JsonPrimitive(String.valueOf(lIllIllllIlllII)));
                        }
                    }
                    lIllIlllllIIIIl.add("with", (JsonElement)lIllIllllIlllIl);
                }
            }
            else if (lIllIlllllIIlII instanceof TextComponentScore) {
                final TextComponentScore lIllIllllIllIll = (TextComponentScore)lIllIlllllIIlII;
                final JsonObject lIllIllllIllIlI = new JsonObject();
                lIllIllllIllIlI.addProperty("name", lIllIllllIllIll.getName());
                lIllIllllIllIlI.addProperty("objective", lIllIllllIllIll.getObjective());
                lIllIllllIllIlI.addProperty("value", lIllIllllIllIll.getUnformattedComponentText());
                lIllIlllllIIIIl.add("score", (JsonElement)lIllIllllIllIlI);
            }
            else if (lIllIlllllIIlII instanceof TextComponentSelector) {
                final TextComponentSelector lIllIllllIllIIl = (TextComponentSelector)lIllIlllllIIlII;
                lIllIlllllIIIIl.addProperty("selector", lIllIllllIllIIl.getSelector());
            }
            else {
                if (!(lIllIlllllIIlII instanceof TextComponentKeybind)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to serialize ").append(lIllIlllllIIlII).append(" as a Component")));
                }
                final TextComponentKeybind lIllIllllIllIII = (TextComponentKeybind)lIllIlllllIIlII;
                lIllIlllllIIIIl.addProperty("keybind", lIllIllllIllIII.func_193633_h());
            }
            return (JsonElement)lIllIlllllIIIIl;
        }
    }
}
