package com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson;

import java.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.util.function.*;

final class GsonComponentSerializerImpl implements GsonComponentSerializer
{
    private final /* synthetic */ boolean emitLegacyHover;
    private final /* synthetic */ boolean downsampleColor;
    static final /* synthetic */ Consumer<Builder> BUILDER;
    @Nullable
    private final /* synthetic */ LegacyHoverEventSerializer legacyHoverSerializer;
    private final /* synthetic */ Gson serializer;
    private final /* synthetic */ UnaryOperator<GsonBuilder> populator;
    private static final /* synthetic */ Optional<Provider> SERVICE;
    
    @NotNull
    @Override
    public String serialize(@NotNull final Component llllllllllllllIIllIlllllIIIIIlII) {
        return this.serializer().toJson(llllllllllllllIIllIlllllIIIIIlII);
    }
    
    @NotNull
    @Override
    public JsonElement serializeToTree(@NotNull final Component llllllllllllllIIllIllllIlllIllll) {
        return this.serializer().toJsonTree(llllllllllllllIIllIllllIlllIllll);
    }
    
    @NotNull
    @Override
    public Component deserializeFromTree(@NotNull final JsonElement llllllllllllllIIllIllllIllllllII) {
        final Component llllllllllllllIIllIllllIlllllIIl = this.serializer().fromJson(llllllllllllllIIllIllllIllllllII, Component.class);
        if (llllllllllllllIIllIllllIlllllIIl == null) {
            throw ComponentSerializerImpl.notSureHowToDeserialize(llllllllllllllIIllIllllIllllllII);
        }
        return llllllllllllllIIllIllllIlllllIIl;
    }
    
    GsonComponentSerializerImpl(final boolean llllllllllllllIIllIlllllIIllllIl, @Nullable final LegacyHoverEventSerializer llllllllllllllIIllIlllllIlIIIIIl, final boolean llllllllllllllIIllIlllllIIllllll) {
        this.downsampleColor = llllllllllllllIIllIlllllIIllllIl;
        this.legacyHoverSerializer = llllllllllllllIIllIlllllIlIIIIIl;
        this.emitLegacyHover = llllllllllllllIIllIlllllIIllllll;
        this.populator = (UnaryOperator<GsonBuilder>)(llllllllllllllIIllIllllIlIllIlll -> {
            llllllllllllllIIllIllllIlIllIlll.registerTypeHierarchyAdapter(Key.class, KeySerializer.INSTANCE);
            llllllllllllllIIllIllllIlIllIlll.registerTypeHierarchyAdapter(Component.class, new ComponentSerializerImpl());
            llllllllllllllIIllIllllIlIllIlll.registerTypeHierarchyAdapter(Style.class, new StyleSerializer(llllllllllllllIIllIlllllIlIIIIIl, llllllllllllllIIllIlllllIIllllll));
            llllllllllllllIIllIllllIlIllIlll.registerTypeAdapter(ClickEvent.Action.class, IndexedSerializer.of("click action", ClickEvent.Action.NAMES));
            llllllllllllllIIllIllllIlIllIlll.registerTypeAdapter(HoverEvent.Action.class, IndexedSerializer.of("hover action", HoverEvent.Action.NAMES));
            llllllllllllllIIllIllllIlIllIlll.registerTypeAdapter(HoverEvent.ShowItem.class, new ShowItemSerializer());
            llllllllllllllIIllIllllIlIllIlll.registerTypeAdapter(HoverEvent.ShowEntity.class, new ShowEntitySerializer());
            llllllllllllllIIllIllllIlIllIlll.registerTypeAdapter(TextColorWrapper.class, new TextColorWrapper.Serializer());
            llllllllllllllIIllIllllIlIllIlll.registerTypeHierarchyAdapter(TextColor.class, llllllllllllllIIllIlllllIIllllIl ? TextColorSerializer.DOWNSAMPLE_COLOR : TextColorSerializer.INSTANCE);
            llllllllllllllIIllIllllIlIllIlll.registerTypeAdapter(TextDecoration.class, IndexedSerializer.of("text decoration", TextDecoration.NAMES));
            llllllllllllllIIllIllllIlIllIlll.registerTypeHierarchyAdapter(BlockNBTComponent.Pos.class, BlockNBTComponentPosSerializer.INSTANCE);
            return llllllllllllllIIllIllllIlIllIlll;
        });
        this.serializer = this.populator.apply(new GsonBuilder()).create();
    }
    
    @NotNull
    @Override
    public Gson serializer() {
        return this.serializer;
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    public UnaryOperator<GsonBuilder> populator() {
        return this.populator;
    }
    
    @NotNull
    @Override
    public Component deserialize(@NotNull final String llllllllllllllIIllIlllllIIIlIlII) {
        final Component llllllllllllllIIllIlllllIIIIlllI = this.serializer().fromJson(llllllllllllllIIllIlllllIIIlIlII, Component.class);
        if (llllllllllllllIIllIlllllIIIIlllI == null) {
            throw ComponentSerializerImpl.notSureHowToDeserialize(llllllllllllllIIllIlllllIIIlIlII);
        }
        return llllllllllllllIIllIlllllIIIIlllI;
    }
    
    static {
        SERVICE = Services.service(Provider.class);
        BUILDER = GsonComponentSerializerImpl.SERVICE.map((Function<? super Provider, ? extends Consumer<Builder>>)Provider::builder).orElseGet(() -> llllllllllllllIIllIllllIlIllIllI -> {});
    }
    
    static final class BuilderImpl implements Builder
    {
        private /* synthetic */ boolean emitLegacyHover;
        @Nullable
        private /* synthetic */ LegacyHoverEventSerializer legacyHoverSerializer;
        private /* synthetic */ boolean downsampleColor;
        
        @NotNull
        @Override
        public Builder downsampleColors() {
            this.downsampleColor = true;
            return this;
        }
        
        BuilderImpl() {
            this.downsampleColor = false;
            this.emitLegacyHover = false;
            GsonComponentSerializerImpl.BUILDER.accept(this);
        }
        
        @NotNull
        @Override
        public GsonComponentSerializer build() {
            if (this.legacyHoverSerializer == null) {
                return this.downsampleColor ? Instances.LEGACY_INSTANCE : Instances.INSTANCE;
            }
            return new GsonComponentSerializerImpl(this.downsampleColor, this.legacyHoverSerializer, this.emitLegacyHover);
        }
        
        BuilderImpl(final GsonComponentSerializerImpl llllllllllllllIllllIllIIlllIIIlI) {
            this();
            this.downsampleColor = llllllllllllllIllllIllIIlllIIIlI.downsampleColor;
            this.emitLegacyHover = llllllllllllllIllllIllIIlllIIIlI.emitLegacyHover;
            this.legacyHoverSerializer = llllllllllllllIllllIllIIlllIIIlI.legacyHoverSerializer;
        }
        
        @NotNull
        @Override
        public Builder legacyHoverEventSerializer(@Nullable final LegacyHoverEventSerializer llllllllllllllIllllIllIIllIllIII) {
            this.legacyHoverSerializer = llllllllllllllIllllIllIIllIllIII;
            return this;
        }
        
        @NotNull
        @Override
        public Builder emitLegacyHoverEvent() {
            this.emitLegacyHover = true;
            return this;
        }
    }
    
    static final class Instances
    {
        static final /* synthetic */ GsonComponentSerializer INSTANCE;
        static final /* synthetic */ GsonComponentSerializer LEGACY_INSTANCE;
        
        static {
            INSTANCE = GsonComponentSerializerImpl.SERVICE.map(Provider::gson).orElseGet(() -> new GsonComponentSerializerImpl(false, null, false));
            LEGACY_INSTANCE = GsonComponentSerializerImpl.SERVICE.map(Provider::gsonLegacy).orElseGet(() -> new GsonComponentSerializerImpl(true, null, true));
        }
    }
}
