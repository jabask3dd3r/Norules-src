package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.legacyimpl;

import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.io.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.nbt.*;
import com.viaversion.viaversion.libs.kyori.adventure.nbt.api.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.util.*;

final class NBTLegacyHoverEventSerializerImpl implements LegacyHoverEventSerializer
{
    private static final /* synthetic */ TagStringIO SNBT_IO;
    private static final /* synthetic */ Codec<CompoundBinaryTag, String, IOException, IOException> SNBT_CODEC;
    
    static {
        ENTITY_ID = "id";
        ENTITY_NAME = "name";
        ITEM_TAG = "tag";
        ENTITY_TYPE = "type";
        ITEM_TYPE = "id";
        ITEM_COUNT = "Count";
        INSTANCE = new NBTLegacyHoverEventSerializerImpl();
        SNBT_IO = TagStringIO.get();
        final TagStringIO snbt_IO = NBTLegacyHoverEventSerializerImpl.SNBT_IO;
        Objects.requireNonNull(snbt_IO);
        final Codec.Decoder<CompoundBinaryTag, String, X> lllllllllllllIIIIIlIIIIIlllIlIII = snbt_IO::asCompound;
        final TagStringIO snbt_IO2 = NBTLegacyHoverEventSerializerImpl.SNBT_IO;
        Objects.requireNonNull(snbt_IO2);
        SNBT_CODEC = Codec.of((Codec.Decoder<CompoundBinaryTag, String, IOException>)lllllllllllllIIIIIlIIIIIlllIlIII, (Codec.Encoder<CompoundBinaryTag, String, IOException>)snbt_IO2::asString);
    }
    
    @NotNull
    @Override
    public Component serializeShowEntity(final HoverEvent.ShowEntity llllllllllllllIIlllIIIIlllllIlII, final Codec.Encoder<Component, String, ? extends RuntimeException> llllllllllllllIIlllIIIIlllllIIll) throws IOException {
        final CompoundBinaryTag.Builder llllllllllllllIIlllIIIIllllIllll = CompoundBinaryTag.builder().putString("id", llllllllllllllIIlllIIIIlllllIlII.id().toString()).putString("type", llllllllllllllIIlllIIIIlllllIlII.type().asString());
        final Component llllllllllllllIIlllIIIIllllIlllI = llllllllllllllIIlllIIIIlllllIlII.name();
        if (llllllllllllllIIlllIIIIllllIlllI != null) {
            llllllllllllllIIlllIIIIllllIllll.putString("name", llllllllllllllIIlllIIIIlllllIIll.encode(llllllllllllllIIlllIIIIllllIlllI));
        }
        return Component.text(NBTLegacyHoverEventSerializerImpl.SNBT_CODEC.encode(llllllllllllllIIlllIIIIllllIllll.build()));
    }
    
    private static void assertTextComponent(final Component llllllllllllllIIlllIIIlIIIIIIllI) {
        if (!(llllllllllllllIIlllIIIlIIIIIIllI instanceof TextComponent) || !llllllllllllllIIlllIIIlIIIIIIllI.children().isEmpty()) {
            throw new IllegalArgumentException("Legacy events must be single Component instances");
        }
    }
    
    @NotNull
    @Override
    public Component serializeShowItem(final HoverEvent.ShowItem llllllllllllllIIlllIIIlIIIIIIIII) throws IOException {
        final CompoundBinaryTag.Builder llllllllllllllIIlllIIIIlllllllIl = CompoundBinaryTag.builder().putString("id", llllllllllllllIIlllIIIlIIIIIIIII.item().asString()).putByte("Count", (byte)llllllllllllllIIlllIIIlIIIIIIIII.count());
        final BinaryTagHolder llllllllllllllIIlllIIIIlllllllII = llllllllllllllIIlllIIIlIIIIIIIII.nbt();
        if (llllllllllllllIIlllIIIIlllllllII != null) {
            llllllllllllllIIlllIIIIlllllllIl.put("tag", llllllllllllllIIlllIIIIlllllllII.get(NBTLegacyHoverEventSerializerImpl.SNBT_CODEC));
        }
        return Component.text(NBTLegacyHoverEventSerializerImpl.SNBT_CODEC.encode(llllllllllllllIIlllIIIIlllllllIl.build()));
    }
    
    private NBTLegacyHoverEventSerializerImpl() {
    }
    
    @Override
    public HoverEvent.ShowEntity deserializeShowEntity(@NotNull final Component llllllllllllllIIlllIIIlIIIIlIIII, final Codec.Decoder<Component, String, ? extends RuntimeException> llllllllllllllIIlllIIIlIIIIIllll) throws IOException {
        assertTextComponent(llllllllllllllIIlllIIIlIIIIlIIII);
        final CompoundBinaryTag llllllllllllllIIlllIIIlIIIIIlIll = NBTLegacyHoverEventSerializerImpl.SNBT_CODEC.decode(((TextComponent)llllllllllllllIIlllIIIlIIIIlIIII).content());
        return HoverEvent.ShowEntity.of(Key.key(llllllllllllllIIlllIIIlIIIIIlIll.getString("type")), UUID.fromString(llllllllllllllIIlllIIIlIIIIIlIll.getString("id")), llllllllllllllIIlllIIIlIIIIIllll.decode(llllllllllllllIIlllIIIlIIIIIlIll.getString("name")));
    }
    
    @Override
    public HoverEvent.ShowItem deserializeShowItem(@NotNull final Component llllllllllllllIIlllIIIlIIIIllIll) throws IOException {
        assertTextComponent(llllllllllllllIIlllIIIlIIIIllIll);
        final CompoundBinaryTag llllllllllllllIIlllIIIlIIIIllIII = NBTLegacyHoverEventSerializerImpl.SNBT_CODEC.decode(((TextComponent)llllllllllllllIIlllIIIlIIIIllIll).content());
        final CompoundBinaryTag llllllllllllllIIlllIIIlIIIIlIlll = llllllllllllllIIlllIIIlIIIIllIII.getCompound("tag");
        return HoverEvent.ShowItem.of(Key.key(llllllllllllllIIlllIIIlIIIIllIII.getString("id")), llllllllllllllIIlllIIIlIIIIllIII.getByte("Count", (byte)1), (llllllllllllllIIlllIIIlIIIIlIlll == CompoundBinaryTag.empty()) ? null : BinaryTagHolder.encode(llllllllllllllIIlllIIIlIIIIlIlll, NBTLegacyHoverEventSerializerImpl.SNBT_CODEC));
    }
}
