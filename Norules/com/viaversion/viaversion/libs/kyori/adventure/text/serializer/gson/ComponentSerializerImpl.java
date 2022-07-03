package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import java.lang.reflect.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;

final class ComponentSerializerImpl implements JsonDeserializer<Component>, JsonSerializer<Component>
{
    static {
        TRANSLATE = "translate";
        SCORE_OBJECTIVE = "objective";
        SCORE_VALUE = "value";
        NBT_ENTITY = "entity";
        SELECTOR = "selector";
        SCORE = "score";
        NBT = "nbt";
        KEYBIND = "keybind";
        TEXT = "text";
        SCORE_NAME = "name";
        NBT_BLOCK = "block";
        EXTRA = "extra";
        NBT_STORAGE = "storage";
        NBT_INTERPRET = "interpret";
        TRANSLATE_WITH = "with";
        SEPARATOR = "separator";
    }
    
    @Override
    public Component deserialize(final JsonElement lllllllllllllIIllllllIlIllIlIllI, final Type lllllllllllllIIllllllIlIllIlIlll, final JsonDeserializationContext lllllllllllllIIllllllIlIllIllIII) throws JsonParseException {
        return this.deserialize0(lllllllllllllIIllllllIlIllIlIllI, lllllllllllllIIllllllIlIllIllIII);
    }
    
    private BuildableComponent<?, ?> deserialize0(final JsonElement lllllllllllllIIllllllIlIllIIIIlI, final JsonDeserializationContext lllllllllllllIIllllllIlIllIIIIll) throws JsonParseException {
        if (lllllllllllllIIllllllIlIllIIIIlI.isJsonPrimitive()) {
            return Component.text(lllllllllllllIIllllllIlIllIIIIlI.getAsString());
        }
        if (lllllllllllllIIllllllIlIllIIIIlI.isJsonArray()) {
            ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIllllll = null;
            for (final JsonElement lllllllllllllIIllllllIlIllIIIIII : lllllllllllllIIllllllIlIllIIIIlI.getAsJsonArray()) {
                final BuildableComponent<?, ?> lllllllllllllIIllllllIlIllIIIIIl = this.deserialize0(lllllllllllllIIllllllIlIllIIIIII, lllllllllllllIIllllllIlIllIIIIll);
                if (lllllllllllllIIllllllIlIlIllllll == null) {
                    lllllllllllllIIllllllIlIlIllllll = (ComponentBuilder<?, ?>)lllllllllllllIIllllllIlIllIIIIIl.toBuilder();
                }
                else {
                    lllllllllllllIIllllllIlIlIllllll.append(lllllllllllllIIllllllIlIllIIIIIl);
                }
            }
            if (lllllllllllllIIllllllIlIlIllllll == null) {
                throw notSureHowToDeserialize(lllllllllllllIIllllllIlIllIIIIlI);
            }
            return (BuildableComponent<?, ?>)lllllllllllllIIllllllIlIlIllllll.build();
        }
        else {
            if (!lllllllllllllIIllllllIlIllIIIIlI.isJsonObject()) {
                throw notSureHowToDeserialize(lllllllllllllIIllllllIlIllIIIIlI);
            }
            final JsonObject lllllllllllllIIllllllIlIlIIlllll = lllllllllllllIIllllllIlIllIIIIlI.getAsJsonObject();
            if (lllllllllllllIIllllllIlIlIIlllll.has("text")) {
                final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIlllllI = Component.text().content(lllllllllllllIIllllllIlIlIIlllll.get("text").getAsString());
            }
            else if (lllllllllllllIIllllllIlIlIIlllll.has("translate")) {
                final String lllllllllllllIIllllllIlIlIllIlll = lllllllllllllIIllllllIlIlIIlllll.get("translate").getAsString();
                if (!lllllllllllllIIllllllIlIlIIlllll.has("with")) {
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIllllIl = Component.translatable().key(lllllllllllllIIllllllIlIlIllIlll);
                }
                else {
                    final JsonArray lllllllllllllIIllllllIlIlIlllIIl = lllllllllllllIIllllllIlIlIIlllll.getAsJsonArray("with");
                    final List<Component> lllllllllllllIIllllllIlIlIlllIII = new ArrayList<Component>(lllllllllllllIIllllllIlIlIlllIIl.size());
                    for (int lllllllllllllIIllllllIlIlIlllIll = 0, lllllllllllllIIllllllIlIlIlllIlI = lllllllllllllIIllllllIlIlIlllIIl.size(); lllllllllllllIIllllllIlIlIlllIll < lllllllllllllIIllllllIlIlIlllIlI; ++lllllllllllllIIllllllIlIlIlllIll) {
                        final JsonElement lllllllllllllIIllllllIlIlIllllII = lllllllllllllIIllllllIlIlIlllIIl.get(lllllllllllllIIllllllIlIlIlllIll);
                        lllllllllllllIIllllllIlIlIlllIII.add(this.deserialize0(lllllllllllllIIllllllIlIlIllllII, lllllllllllllIIllllllIlIllIIIIll));
                    }
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIllIllI = Component.translatable().key(lllllllllllllIIllllllIlIlIllIlll).args(lllllllllllllIIllllllIlIlIlllIII);
                }
            }
            else if (lllllllllllllIIllllllIlIlIIlllll.has("score")) {
                final JsonObject lllllllllllllIIllllllIlIlIllIlII = lllllllllllllIIllllllIlIlIIlllll.getAsJsonObject("score");
                if (!lllllllllllllIIllllllIlIlIllIlII.has("name") || !lllllllllllllIIllllllIlIlIllIlII.has("objective")) {
                    throw new JsonParseException("A score component requires a name and objective");
                }
                final ScoreComponent.Builder lllllllllllllIIllllllIlIlIllIIll = Component.score().name(lllllllllllllIIllllllIlIlIllIlII.get("name").getAsString()).objective(lllllllllllllIIllllllIlIlIllIlII.get("objective").getAsString());
                if (lllllllllllllIIllllllIlIlIllIlII.has("value")) {
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIllIlIl = lllllllllllllIIllllllIlIlIllIIll.value(lllllllllllllIIllllllIlIlIllIlII.get("value").getAsString());
                }
                else {
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIllIIlI = lllllllllllllIIllllllIlIlIllIIll;
                }
            }
            else if (lllllllllllllIIllllllIlIlIIlllll.has("selector")) {
                final Component lllllllllllllIIllllllIlIlIllIIIl = this.deserializeSeparator(lllllllllllllIIllllllIlIlIIlllll, lllllllllllllIIllllllIlIllIIIIll);
                final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIllIIII = Component.selector().pattern(lllllllllllllIIllllllIlIlIIlllll.get("selector").getAsString()).separator(lllllllllllllIIllllllIlIlIllIIIl);
            }
            else if (lllllllllllllIIllllllIlIlIIlllll.has("keybind")) {
                final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIlIllll = Component.keybind().keybind(lllllllllllllIIllllllIlIlIIlllll.get("keybind").getAsString());
            }
            else {
                if (!lllllllllllllIIllllllIlIlIIlllll.has("nbt")) {
                    throw notSureHowToDeserialize(lllllllllllllIIllllllIlIllIIIIlI);
                }
                final String lllllllllllllIIllllllIlIlIlIlIlI = lllllllllllllIIllllllIlIlIIlllll.get("nbt").getAsString();
                final boolean lllllllllllllIIllllllIlIlIlIlIIl = lllllllllllllIIllllllIlIlIIlllll.has("interpret") && lllllllllllllIIllllllIlIlIIlllll.getAsJsonPrimitive("interpret").getAsBoolean();
                final Component lllllllllllllIIllllllIlIlIlIlIII = this.deserializeSeparator(lllllllllllllIIllllllIlIlIIlllll, lllllllllllllIIllllllIlIllIIIIll);
                if (lllllllllllllIIllllllIlIlIIlllll.has("block")) {
                    final BlockNBTComponent.Pos lllllllllllllIIllllllIlIlIlIlllI = lllllllllllllIIllllllIlIllIIIIll.deserialize(lllllllllllllIIllllllIlIlIIlllll.get("block"), BlockNBTComponent.Pos.class);
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIlIllIl = nbt(Component.blockNBT(), lllllllllllllIIllllllIlIlIlIlIlI, lllllllllllllIIllllllIlIlIlIlIIl, lllllllllllllIIllllllIlIlIlIlIII).pos(lllllllllllllIIllllllIlIlIlIlllI);
                }
                else if (lllllllllllllIIllllllIlIlIIlllll.has("entity")) {
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIlIllII = nbt(Component.entityNBT(), lllllllllllllIIllllllIlIlIlIlIlI, lllllllllllllIIllllllIlIlIlIlIIl, lllllllllllllIIllllllIlIlIlIlIII).selector(lllllllllllllIIllllllIlIlIIlllll.get("entity").getAsString());
                }
                else {
                    if (!lllllllllllllIIllllllIlIlIIlllll.has("storage")) {
                        throw notSureHowToDeserialize(lllllllllllllIIllllllIlIllIIIIlI);
                    }
                    final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIlIlIll = nbt(Component.storageNBT(), lllllllllllllIIllllllIlIlIlIlIlI, lllllllllllllIIllllllIlIlIlIlIIl, lllllllllllllIIllllllIlIlIlIlIII).storage(lllllllllllllIIllllllIlIllIIIIll.deserialize(lllllllllllllIIllllllIlIlIIlllll.get("storage"), Key.class));
                }
            }
            final ComponentBuilder<?, ?> lllllllllllllIIllllllIlIlIIllllI;
            if (lllllllllllllIIllllllIlIlIIlllll.has("extra")) {
                final JsonArray lllllllllllllIIllllllIlIlIlIIIll = lllllllllllllIIllllllIlIlIIlllll.getAsJsonArray("extra");
                for (int lllllllllllllIIllllllIlIlIlIIlIl = 0, lllllllllllllIIllllllIlIlIlIIlII = lllllllllllllIIllllllIlIlIlIIIll.size(); lllllllllllllIIllllllIlIlIlIIlIl < lllllllllllllIIllllllIlIlIlIIlII; ++lllllllllllllIIllllllIlIlIlIIlIl) {
                    final JsonElement lllllllllllllIIllllllIlIlIlIIllI = lllllllllllllIIllllllIlIlIlIIIll.get(lllllllllllllIIllllllIlIlIlIIlIl);
                    lllllllllllllIIllllllIlIlIIllllI.append(this.deserialize0(lllllllllllllIIllllllIlIlIlIIllI, lllllllllllllIIllllllIlIllIIIIll));
                }
            }
            final Style lllllllllllllIIllllllIlIlIIlllIl = lllllllllllllIIllllllIlIllIIIIll.deserialize(lllllllllllllIIllllllIlIllIIIIlI, Style.class);
            if (!lllllllllllllIIllllllIlIlIIlllIl.isEmpty()) {
                lllllllllllllIIllllllIlIlIIllllI.style(lllllllllllllIIllllllIlIlIIlllIl);
            }
            return (BuildableComponent<?, ?>)lllllllllllllIIllllllIlIlIIllllI.build();
        }
    }
    
    static JsonParseException notSureHowToDeserialize(final Object lllllllllllllIIllllllIlIIlIIIIII) {
        return new JsonParseException(String.valueOf(new StringBuilder().append("Don't know how to turn ").append(lllllllllllllIIllllllIlIIlIIIIII).append(" into a Component")));
    }
    
    private static IllegalArgumentException notSureHowToSerialize(final Component lllllllllllllIIllllllIlIIIllllII) {
        return new IllegalArgumentException(String.valueOf(new StringBuilder().append("Don't know how to serialize ").append(lllllllllllllIIllllllIlIIIllllII).append(" as a Component")));
    }
    
    private static <C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> B nbt(final B lllllllllllllIIllllllIlIlIIIIIII, final String lllllllllllllIIllllllIlIlIIIIIlI, final boolean lllllllllllllIIllllllIlIIlllllll, @Nullable final Component lllllllllllllIIllllllIlIlIIIIIIl) {
        return ((NBTComponentBuilder<C, B>)((NBTComponentBuilder<C, NBTComponentBuilder<C, B>>)lllllllllllllIIllllllIlIlIIIIIII).nbtPath(lllllllllllllIIllllllIlIlIIIIIlI).interpret(lllllllllllllIIllllllIlIIlllllll)).separator(lllllllllllllIIllllllIlIlIIIIIIl);
    }
    
    private void serializeSeparator(final JsonSerializationContext lllllllllllllIIllllllIlIIlIIlIlI, final JsonObject lllllllllllllIIllllllIlIIlIIlIIl, @Nullable final Component lllllllllllllIIllllllIlIIlIIlIll) {
        if (lllllllllllllIIllllllIlIIlIIlIll != null) {
            lllllllllllllIIllllllIlIIlIIlIIl.add("separator", lllllllllllllIIllllllIlIIlIIlIlI.serialize(lllllllllllllIIllllllIlIIlIIlIll));
        }
    }
    
    @Nullable
    private Component deserializeSeparator(final JsonObject lllllllllllllIIllllllIlIlIIIllIl, final JsonDeserializationContext lllllllllllllIIllllllIlIlIIIlllI) {
        if (lllllllllllllIIllllllIlIlIIIllIl.has("separator")) {
            return this.deserialize0(lllllllllllllIIllllllIlIlIIIllIl.get("separator"), lllllllllllllIIllllllIlIlIIIlllI);
        }
        return null;
    }
    
    @Override
    public JsonElement serialize(final Component lllllllllllllIIllllllIlIIllIllII, final Type lllllllllllllIIllllllIlIIllIlIll, final JsonSerializationContext lllllllllllllIIllllllIlIIllIllIl) {
        final JsonObject lllllllllllllIIllllllIlIIlIllIIl = new JsonObject();
        if (lllllllllllllIIllllllIlIIllIllII.hasStyling()) {
            final JsonElement lllllllllllllIIllllllIlIIllIlIIl = lllllllllllllIIllllllIlIIllIllIl.serialize(lllllllllllllIIllllllIlIIllIllII.style());
            if (lllllllllllllIIllllllIlIIllIlIIl.isJsonObject()) {
                for (final Map.Entry<String, JsonElement> lllllllllllllIIllllllIlIIllIlIlI : ((JsonObject)lllllllllllllIIllllllIlIIllIlIIl).entrySet()) {
                    lllllllllllllIIllllllIlIIlIllIIl.add(lllllllllllllIIllllllIlIIllIlIlI.getKey(), lllllllllllllIIllllllIlIIllIlIlI.getValue());
                }
            }
        }
        final List<Component> lllllllllllllIIllllllIlIIlIllIII = lllllllllllllIIllllllIlIIllIllII.children();
        if (!lllllllllllllIIllllllIlIIlIllIII.isEmpty()) {
            final JsonArray lllllllllllllIIllllllIlIIllIIlll = new JsonArray();
            for (final Component lllllllllllllIIllllllIlIIllIlIII : lllllllllllllIIllllllIlIIlIllIII) {
                lllllllllllllIIllllllIlIIllIIlll.add(lllllllllllllIIllllllIlIIllIllIl.serialize(lllllllllllllIIllllllIlIIllIlIII));
            }
            lllllllllllllIIllllllIlIIlIllIIl.add("extra", lllllllllllllIIllllllIlIIllIIlll);
        }
        if (lllllllllllllIIllllllIlIIllIllII instanceof TextComponent) {
            lllllllllllllIIllllllIlIIlIllIIl.addProperty("text", ((TextComponent)lllllllllllllIIllllllIlIIllIllII).content());
        }
        else if (lllllllllllllIIllllllIlIIllIllII instanceof TranslatableComponent) {
            final TranslatableComponent lllllllllllllIIllllllIlIIllIIlII = (TranslatableComponent)lllllllllllllIIllllllIlIIllIllII;
            lllllllllllllIIllllllIlIIlIllIIl.addProperty("translate", lllllllllllllIIllllllIlIIllIIlII.key());
            if (!lllllllllllllIIllllllIlIIllIIlII.args().isEmpty()) {
                final JsonArray lllllllllllllIIllllllIlIIllIIlIl = new JsonArray();
                for (final Component lllllllllllllIIllllllIlIIllIIllI : lllllllllllllIIllllllIlIIllIIlII.args()) {
                    lllllllllllllIIllllllIlIIllIIlIl.add(lllllllllllllIIllllllIlIIllIllIl.serialize(lllllllllllllIIllllllIlIIllIIllI));
                }
                lllllllllllllIIllllllIlIIlIllIIl.add("with", lllllllllllllIIllllllIlIIllIIlIl);
            }
        }
        else if (lllllllllllllIIllllllIlIIllIllII instanceof ScoreComponent) {
            final ScoreComponent lllllllllllllIIllllllIlIIllIIIll = (ScoreComponent)lllllllllllllIIllllllIlIIllIllII;
            final JsonObject lllllllllllllIIllllllIlIIllIIIlI = new JsonObject();
            lllllllllllllIIllllllIlIIllIIIlI.addProperty("name", lllllllllllllIIllllllIlIIllIIIll.name());
            lllllllllllllIIllllllIlIIllIIIlI.addProperty("objective", lllllllllllllIIllllllIlIIllIIIll.objective());
            final String lllllllllllllIIllllllIlIIllIIIIl = lllllllllllllIIllllllIlIIllIIIll.value();
            if (lllllllllllllIIllllllIlIIllIIIIl != null) {
                lllllllllllllIIllllllIlIIllIIIlI.addProperty("value", lllllllllllllIIllllllIlIIllIIIIl);
            }
            lllllllllllllIIllllllIlIIlIllIIl.add("score", lllllllllllllIIllllllIlIIllIIIlI);
        }
        else if (lllllllllllllIIllllllIlIIllIllII instanceof SelectorComponent) {
            final SelectorComponent lllllllllllllIIllllllIlIIllIIIII = (SelectorComponent)lllllllllllllIIllllllIlIIllIllII;
            lllllllllllllIIllllllIlIIlIllIIl.addProperty("selector", lllllllllllllIIllllllIlIIllIIIII.pattern());
            this.serializeSeparator(lllllllllllllIIllllllIlIIllIllIl, lllllllllllllIIllllllIlIIlIllIIl, lllllllllllllIIllllllIlIIllIIIII.separator());
        }
        else if (lllllllllllllIIllllllIlIIllIllII instanceof KeybindComponent) {
            lllllllllllllIIllllllIlIIlIllIIl.addProperty("keybind", ((KeybindComponent)lllllllllllllIIllllllIlIIllIllII).keybind());
        }
        else {
            if (!(lllllllllllllIIllllllIlIIllIllII instanceof NBTComponent)) {
                throw notSureHowToSerialize(lllllllllllllIIllllllIlIIllIllII);
            }
            final NBTComponent<?, ?> lllllllllllllIIllllllIlIIlIllllI = (NBTComponent<?, ?>)lllllllllllllIIllllllIlIIllIllII;
            lllllllllllllIIllllllIlIIlIllIIl.addProperty("nbt", lllllllllllllIIllllllIlIIlIllllI.nbtPath());
            lllllllllllllIIllllllIlIIlIllIIl.addProperty("interpret", lllllllllllllIIllllllIlIIlIllllI.interpret());
            if (lllllllllllllIIllllllIlIIllIllII instanceof BlockNBTComponent) {
                final JsonElement lllllllllllllIIllllllIlIIlIlllll = lllllllllllllIIllllllIlIIllIllIl.serialize(((BlockNBTComponent)lllllllllllllIIllllllIlIIlIllllI).pos());
                lllllllllllllIIllllllIlIIlIllIIl.add("block", lllllllllllllIIllllllIlIIlIlllll);
                this.serializeSeparator(lllllllllllllIIllllllIlIIllIllIl, lllllllllllllIIllllllIlIIlIllIIl, lllllllllllllIIllllllIlIIlIllllI.separator());
            }
            else if (lllllllllllllIIllllllIlIIllIllII instanceof EntityNBTComponent) {
                lllllllllllllIIllllllIlIIlIllIIl.addProperty("entity", ((EntityNBTComponent)lllllllllllllIIllllllIlIIlIllllI).selector());
            }
            else {
                if (!(lllllllllllllIIllllllIlIIllIllII instanceof StorageNBTComponent)) {
                    throw notSureHowToSerialize(lllllllllllllIIllllllIlIIllIllII);
                }
                lllllllllllllIIllllllIlIIlIllIIl.add("storage", lllllllllllllIIllllllIlIIllIllIl.serialize(((StorageNBTComponent)lllllllllllllIIllllllIlIIlIllllI).storage()));
            }
        }
        return lllllllllllllIIllllllIlIIlIllIIl;
    }
}
