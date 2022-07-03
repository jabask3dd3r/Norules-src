package com.viaversion.viaversion.libs.kyori.adventure.text.event;

import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.nbt.api.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.renderer.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

public final class HoverEvent<V> implements Examinable, HoverEventSource<V>, StyleBuilderApplicable
{
    private final /* synthetic */ Action<V> action;
    private final /* synthetic */ V value;
    
    @NotNull
    public V value() {
        return this.value;
    }
    
    @Override
    public void styleApply(final Style.Builder llllllllllllllIllllllIlIIIllIIll) {
        llllllllllllllIllllllIlIIIllIIll.hoverEvent(this);
    }
    
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull final ShowItem llllllllllllllIllllllIlIlIIlllll) {
        return new HoverEvent<ShowItem>(Action.SHOW_ITEM, llllllllllllllIllllllIlIlIIlllll);
    }
    
    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull final Key llllllllllllllIllllllIlIlIIIlIII, @NotNull final UUID llllllllllllllIllllllIlIlIIIlIIl, @Nullable final Component llllllllllllllIllllllIlIlIIIIlll) {
        return showEntity(ShowEntity.of(llllllllllllllIllllllIlIlIIIlIII, llllllllllllllIllllllIlIlIIIlIIl, llllllllllllllIllllllIlIlIIIIlll));
    }
    
    @NotNull
    public static <V> HoverEvent<V> hoverEvent(@NotNull final Action<V> llllllllllllllIllllllIlIIllIllIl, @NotNull final V llllllllllllllIllllllIlIIllIlllI) {
        return new HoverEvent<V>(llllllllllllllIllllllIlIIllIllIl, llllllllllllllIllllllIlIIllIlllI);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIllllllIlIIIlIIIIl = this.action.hashCode();
        llllllllllllllIllllllIlIIIlIIIIl = 31 * llllllllllllllIllllllIlIIIlIIIIl + this.value.hashCode();
        return llllllllllllllIllllllIlIIIlIIIIl;
    }
    
    @NotNull
    public static HoverEvent<Component> showText(@NotNull final Component llllllllllllllIllllllIlIllIIlIll) {
        return new HoverEvent<Component>(Action.SHOW_TEXT, llllllllllllllIllllllIlIllIIlIll);
    }
    
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull final Key llllllllllllllIllllllIlIllIIIllI, final int llllllllllllllIllllllIlIllIIIlIl) {
        return showItem(llllllllllllllIllllllIlIllIIIllI, llllllllllllllIllllllIlIllIIIlIl, null);
    }
    
    @NotNull
    public <C> HoverEvent<V> withRenderedValue(@NotNull final ComponentRenderer<C> llllllllllllllIllllllIlIIlIIlIlI, @NotNull final C llllllllllllllIllllllIlIIlIIlIll) {
        final V llllllllllllllIllllllIlIIlIIIllI = this.value;
        final V llllllllllllllIllllllIlIIlIIIlIl = ((Action<Object>)this.action).renderer.render(llllllllllllllIllllllIlIIlIIlIlI, llllllllllllllIllllllIlIIlIIlIll, llllllllllllllIllllllIlIIlIIIllI);
        if (llllllllllllllIllllllIlIIlIIIlIl != llllllllllllllIllllllIlIIlIIIllI) {
            return new HoverEvent<V>(this.action, llllllllllllllIllllllIlIIlIIIlIl);
        }
        return this;
    }
    
    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull final Keyed llllllllllllllIllllllIlIlIIlIIlI, @NotNull final UUID llllllllllllllIllllllIlIlIIlIIIl) {
        return showEntity(llllllllllllllIllllllIlIlIIlIIlI, llllllllllllllIllllllIlIlIIlIIIl, null);
    }
    
    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull final Key llllllllllllllIllllllIlIlIIllIlI, @NotNull final UUID llllllllllllllIllllllIlIlIIllIIl) {
        return showEntity(llllllllllllllIllllllIlIlIIllIlI, llllllllllllllIllllllIlIlIIllIIl, null);
    }
    
    @NotNull
    public Action<V> action() {
        return this.action;
    }
    
    @NotNull
    public static HoverEvent<Component> showText(@NotNull final ComponentLike llllllllllllllIllllllIlIllIIllll) {
        return showText(llllllllllllllIllllllIlIllIIllll.asComponent());
    }
    
    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull final Keyed llllllllllllllIllllllIlIIlllllII, @NotNull final UUID llllllllllllllIllllllIlIIlllllIl, @Nullable final Component llllllllllllllIllllllIlIIllllIll) {
        return showEntity(ShowEntity.of(llllllllllllllIllllllIlIIlllllII, llllllllllllllIllllllIlIIlllllIl, llllllllllllllIllllllIlIIllllIll));
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull final Keyed llllllllllllllIllllllIlIlIllllIl, final int llllllllllllllIllllllIlIlIlllllI) {
        return showItem(llllllllllllllIllllllIlIlIllllIl, llllllllllllllIllllllIlIlIlllllI, null);
    }
    
    private HoverEvent(@NotNull final Action<V> llllllllllllllIllllllIlIIllIIlII, @NotNull final V llllllllllllllIllllllIlIIllIIlIl) {
        this.action = Objects.requireNonNull(llllllllllllllIllllllIlIIllIIlII, "action");
        this.value = Objects.requireNonNull(llllllllllllllIllllllIlIIllIIlIl, "value");
    }
    
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull final Keyed llllllllllllllIllllllIlIlIlIlIIl, final int llllllllllllllIllllllIlIlIlIIlll, @Nullable final BinaryTagHolder llllllllllllllIllllllIlIlIlIlIII) {
        return showItem(ShowItem.of(llllllllllllllIllllllIlIlIlIlIIl, llllllllllllllIllllllIlIlIlIIlll, llllllllllllllIllllllIlIlIlIlIII));
    }
    
    @NotNull
    @Override
    public HoverEvent<V> asHoverEvent() {
        return this;
    }
    
    @NotNull
    public static HoverEvent<ShowItem> showItem(@NotNull final Key llllllllllllllIllllllIlIlIllIIll, final int llllllllllllllIllllllIlIlIllIlIl, @Nullable final BinaryTagHolder llllllllllllllIllllllIlIlIllIlII) {
        return showItem(ShowItem.of(llllllllllllllIllllllIlIlIllIIll, llllllllllllllIllllllIlIlIllIlIl, llllllllllllllIllllllIlIlIllIlII));
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("action", this.action), ExaminableProperty.of("value", this.value) });
    }
    
    @NotNull
    @Override
    public HoverEvent<V> asHoverEvent(@NotNull final UnaryOperator<V> llllllllllllllIllllllIlIIIlllIlI) {
        if (llllllllllllllIllllllIlIIIlllIlI == UnaryOperator.identity()) {
            return this;
        }
        return new HoverEvent<V>(this.action, llllllllllllllIllllllIlIIIlllIlI.apply(this.value));
    }
    
    @Override
    public boolean equals(@Nullable final Object llllllllllllllIllllllIlIIIlIlIll) {
        if (this == llllllllllllllIllllllIlIIIlIlIll) {
            return true;
        }
        if (llllllllllllllIllllllIlIIIlIlIll == null || this.getClass() != llllllllllllllIllllllIlIIIlIlIll.getClass()) {
            return false;
        }
        final HoverEvent<?> llllllllllllllIllllllIlIIIlIlIII = (HoverEvent<?>)llllllllllllllIllllllIlIIIlIlIll;
        return this.action == llllllllllllllIllllllIlIIIlIlIII.action && this.value.equals(llllllllllllllIllllllIlIIIlIlIII.value);
    }
    
    @NotNull
    public HoverEvent<V> value(@NotNull final V llllllllllllllIllllllIlIIlIlIlIl) {
        return new HoverEvent<V>(this.action, llllllllllllllIllllllIlIIlIlIlIl);
    }
    
    @NotNull
    public static HoverEvent<ShowEntity> showEntity(@NotNull final ShowEntity llllllllllllllIllllllIlIIlllIIll) {
        return new HoverEvent<ShowEntity>(Action.SHOW_ENTITY, llllllllllllllIllllllIlIIlllIIll);
    }
    
    public static final class Action<V>
    {
        public static final /* synthetic */ Action<Component> SHOW_TEXT;
        public static final /* synthetic */ Action<ShowItem> SHOW_ITEM;
        private final /* synthetic */ String name;
        private final /* synthetic */ boolean readable;
        private final /* synthetic */ Class<V> type;
        private final /* synthetic */ Renderer<V> renderer;
        public static final /* synthetic */ Action<ShowEntity> SHOW_ENTITY;
        
        @NotNull
        @Override
        public String toString() {
            return this.name;
        }
        
        @NotNull
        public Class<V> type() {
            return this.type;
        }
        
        Action(final String llllllllllllllIIllIllIIIllIIIllI, final Class<V> llllllllllllllIIllIllIIIllIIlIII, final boolean llllllllllllllIIllIllIIIllIIlIIl, final Renderer<V> llllllllllllllIIllIllIIIllIIIlll) {
            this.name = llllllllllllllIIllIllIIIllIIIllI;
            this.type = llllllllllllllIIllIllIIIllIIlIII;
            this.readable = llllllllllllllIIllIllIIIllIIlIIl;
            this.renderer = llllllllllllllIIllIllIIIllIIIlll;
        }
        
        public boolean readable() {
            return this.readable;
        }
        
        static {
            SHOW_TEXT = new Action<Component>("show_text", Component.class, true, new Renderer<Component>() {
                @NotNull
                @Override
                public <C> Component render(@NotNull final ComponentRenderer<C> lllllllllllllIIIIIIllIlIlIllIIlI, @NotNull final C lllllllllllllIIIIIIllIlIlIllIIll, @NotNull final Component lllllllllllllIIIIIIllIlIlIllIIIl) {
                    return lllllllllllllIIIIIIllIlIlIllIIlI.render(lllllllllllllIIIIIIllIlIlIllIIIl, lllllllllllllIIIIIIllIlIlIllIIll);
                }
            });
            SHOW_ITEM = new Action<ShowItem>("show_item", ShowItem.class, true, new Renderer<ShowItem>() {
                @NotNull
                @Override
                public <C> ShowItem render(@NotNull final ComponentRenderer<C> lllllllllllllllIIllIllIlIIlIIIII, @NotNull final C lllllllllllllllIIllIllIlIIIlllIl, @NotNull final ShowItem lllllllllllllllIIllIllIlIIIllllI) {
                    return lllllllllllllllIIllIllIlIIIllllI;
                }
            });
            SHOW_ENTITY = new Action<ShowEntity>("show_entity", ShowEntity.class, true, new Renderer<ShowEntity>() {
                @NotNull
                @Override
                public <C> ShowEntity render(@NotNull final ComponentRenderer<C> llllllllllllllIlIIIIIIlIlIlIIIII, @NotNull final C llllllllllllllIlIIIIIIlIlIlIIIlI, @NotNull final ShowEntity llllllllllllllIlIIIIIIlIlIlIIIIl) {
                    if (llllllllllllllIlIIIIIIlIlIlIIIIl.name == null) {
                        return llllllllllllllIlIIIIIIlIlIlIIIIl;
                    }
                    return llllllllllllllIlIIIIIIlIlIlIIIIl.name(llllllllllllllIlIIIIIIlIlIlIIIII.render(llllllllllllllIlIIIIIIlIlIlIIIIl.name, llllllllllllllIlIIIIIIlIlIlIIIlI));
                }
            });
            NAMES = Index.create(llllllllllllllIIllIllIIIlIllIIII -> llllllllllllllIIllIllIIIlIllIIII.name, (Action<?>[])new Action[] { Action.SHOW_TEXT, Action.SHOW_ITEM, Action.SHOW_ENTITY });
        }
        
        @FunctionalInterface
        interface Renderer<V>
        {
            @NotNull
             <C> V render(@NotNull final ComponentRenderer<C> llllllllllllllllIlIlIIlIllIIIllI, @NotNull final C llllllllllllllllIlIlIIlIllIIIlIl, @NotNull final V llllllllllllllllIlIlIIlIllIIIlII);
        }
    }
    
    public static final class ShowItem implements Examinable
    {
        @Nullable
        private final /* synthetic */ BinaryTagHolder nbt;
        private final /* synthetic */ Key item;
        private final /* synthetic */ int count;
        
        @NotNull
        public static ShowItem of(@NotNull final Keyed lllllllllllllIlIIlIIlIlIIlllIllI, final int lllllllllllllIlIIlIIlIlIIlllIlll) {
            return of(lllllllllllllIlIIlIIlIlIIlllIllI, lllllllllllllIlIIlIIlIlIIlllIlll, null);
        }
        
        @NotNull
        public static ShowItem of(@NotNull final Keyed lllllllllllllIlIIlIIlIlIIllIIIlI, final int lllllllllllllIlIIlIIlIlIIllIIIII, @Nullable final BinaryTagHolder lllllllllllllIlIIlIIlIlIIllIIIIl) {
            return new ShowItem(Objects.requireNonNull(lllllllllllllIlIIlIIlIlIIllIIIlI, "item").key(), lllllllllllllIlIIlIIlIlIIllIIIII, lllllllllllllIlIIlIIlIlIIllIIIIl);
        }
        
        @NotNull
        public ShowItem count(final int lllllllllllllIlIIlIIlIlIIIlllIll) {
            if (lllllllllllllIlIIlIIlIlIIIlllIll == this.count) {
                return this;
            }
            return new ShowItem(this.item, lllllllllllllIlIIlIIlIlIIIlllIll, this.nbt);
        }
        
        @Override
        public String toString() {
            return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
        }
        
        private ShowItem(@NotNull final Key lllllllllllllIlIIlIIlIlIIlIlIlII, final int lllllllllllllIlIIlIIlIlIIlIlIIll, @Nullable final BinaryTagHolder lllllllllllllIlIIlIIlIlIIlIlIlIl) {
            this.item = lllllllllllllIlIIlIIlIlIIlIlIlII;
            this.count = lllllllllllllIlIIlIIlIlIIlIlIIll;
            this.nbt = lllllllllllllIlIIlIIlIlIIlIlIlIl;
        }
        
        @NotNull
        @Override
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("item", this.item), ExaminableProperty.of("count", this.count), ExaminableProperty.of("nbt", this.nbt) });
        }
        
        @Nullable
        public BinaryTagHolder nbt() {
            return this.nbt;
        }
        
        @Override
        public boolean equals(@Nullable final Object lllllllllllllIlIIlIIlIlIIIlIlIIl) {
            if (this == lllllllllllllIlIIlIIlIlIIIlIlIIl) {
                return true;
            }
            if (lllllllllllllIlIIlIIlIlIIIlIlIIl == null || this.getClass() != lllllllllllllIlIIlIIlIlIIIlIlIIl.getClass()) {
                return false;
            }
            final ShowItem lllllllllllllIlIIlIIlIlIIIlIIllI = (ShowItem)lllllllllllllIlIIlIIlIlIIIlIlIIl;
            return this.item.equals(lllllllllllllIlIIlIIlIlIIIlIIllI.item) && this.count == lllllllllllllIlIIlIIlIlIIIlIIllI.count && Objects.equals(this.nbt, lllllllllllllIlIIlIIlIlIIIlIIllI.nbt);
        }
        
        @NotNull
        public ShowItem nbt(@Nullable final BinaryTagHolder lllllllllllllIlIIlIIlIlIIIllIIIl) {
            if (Objects.equals(lllllllllllllIlIIlIIlIlIIIllIIIl, this.nbt)) {
                return this;
            }
            return new ShowItem(this.item, this.count, lllllllllllllIlIIlIIlIlIIIllIIIl);
        }
        
        public int count() {
            return this.count;
        }
        
        @NotNull
        public static ShowItem of(@NotNull final Key lllllllllllllIlIIlIIlIlIIlllllll, final int lllllllllllllIlIIlIIlIlIIllllllI) {
            return of(lllllllllllllIlIIlIIlIlIIlllllll, lllllllllllllIlIIlIIlIlIIllllllI, null);
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllIlIIlIIlIlIIIIlllll = this.item.hashCode();
            lllllllllllllIlIIlIIlIlIIIIlllll = 31 * lllllllllllllIlIIlIIlIlIIIIlllll + Integer.hashCode(this.count);
            lllllllllllllIlIIlIIlIlIIIIlllll = 31 * lllllllllllllIlIIlIIlIlIIIIlllll + Objects.hashCode(this.nbt);
            return lllllllllllllIlIIlIIlIlIIIIlllll;
        }
        
        @NotNull
        public ShowItem item(@NotNull final Key lllllllllllllIlIIlIIlIlIIlIIIlIl) {
            if (Objects.requireNonNull(lllllllllllllIlIIlIIlIlIIlIIIlIl, "item").equals(this.item)) {
                return this;
            }
            return new ShowItem(lllllllllllllIlIIlIIlIlIIlIIIlIl, this.count, this.nbt);
        }
        
        @NotNull
        public Key item() {
            return this.item;
        }
        
        @NotNull
        public static ShowItem of(@NotNull final Key lllllllllllllIlIIlIIlIlIIllIllIl, final int lllllllllllllIlIIlIIlIlIIllIllII, @Nullable final BinaryTagHolder lllllllllllllIlIIlIIlIlIIllIlllI) {
            return new ShowItem(Objects.requireNonNull(lllllllllllllIlIIlIIlIlIIllIllIl, "item"), lllllllllllllIlIIlIIlIlIIllIllII, lllllllllllllIlIIlIIlIlIIllIlllI);
        }
    }
    
    public static final class ShowEntity implements Examinable
    {
        private final /* synthetic */ Component name;
        private final /* synthetic */ Key type;
        private final /* synthetic */ UUID id;
        
        @NotNull
        @Override
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("type", this.type), ExaminableProperty.of("id", this.id), ExaminableProperty.of("name", this.name) });
        }
        
        @Override
        public boolean equals(@Nullable final Object lllllllllllllIIllllIIlIIIlIIllll) {
            if (this == lllllllllllllIIllllIIlIIIlIIllll) {
                return true;
            }
            if (lllllllllllllIIllllIIlIIIlIIllll == null || this.getClass() != lllllllllllllIIllllIIlIIIlIIllll.getClass()) {
                return false;
            }
            final ShowEntity lllllllllllllIIllllIIlIIIlIIllII = (ShowEntity)lllllllllllllIIllllIIlIIIlIIllll;
            return this.type.equals(lllllllllllllIIllllIIlIIIlIIllII.type) && this.id.equals(lllllllllllllIIllllIIlIIIlIIllII.id) && Objects.equals(this.name, lllllllllllllIIllllIIlIIIlIIllII.name);
        }
        
        @NotNull
        public static ShowEntity of(@NotNull final Keyed lllllllllllllIIllllIIlIIlIlIIlII, @NotNull final UUID lllllllllllllIIllllIIlIIlIlIIIll) {
            return of(lllllllllllllIIllllIIlIIlIlIIlII, lllllllllllllIIllllIIlIIlIlIIIll, null);
        }
        
        @Nullable
        public Component name() {
            return this.name;
        }
        
        @NotNull
        public static ShowEntity of(@NotNull final Key lllllllllllllIIllllIIlIIlIIllIIl, @NotNull final UUID lllllllllllllIIllllIIlIIlIIllIll, @Nullable final Component lllllllllllllIIllllIIlIIlIIllIlI) {
            return new ShowEntity(Objects.requireNonNull(lllllllllllllIIllllIIlIIlIIllIIl, "type"), Objects.requireNonNull(lllllllllllllIIllllIIlIIlIIllIll, "id"), lllllllllllllIIllllIIlIIlIIllIlI);
        }
        
        @NotNull
        public Key type() {
            return this.type;
        }
        
        @NotNull
        public ShowEntity type(@NotNull final Key lllllllllllllIIllllIIlIIIlllIIlI) {
            if (Objects.requireNonNull(lllllllllllllIIllllIIlIIIlllIIlI, "type").equals(this.type)) {
                return this;
            }
            return new ShowEntity(lllllllllllllIIllllIIlIIIlllIIlI, this.id, this.name);
        }
        
        @NotNull
        public static ShowEntity of(@NotNull final Keyed lllllllllllllIIllllIIlIIlIIIllll, @NotNull final UUID lllllllllllllIIllllIIlIIlIIIllIl, @Nullable final Component lllllllllllllIIllllIIlIIlIIIlllI) {
            return new ShowEntity(Objects.requireNonNull(lllllllllllllIIllllIIlIIlIIIllll, "type").key(), Objects.requireNonNull(lllllllllllllIIllllIIlIIlIIIllIl, "id"), lllllllllllllIIllllIIlIIlIIIlllI);
        }
        
        @Override
        public String toString() {
            return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
        }
        
        private ShowEntity(@NotNull final Key lllllllllllllIIllllIIlIIlIIIIIII, @NotNull final UUID lllllllllllllIIllllIIlIIlIIIIIlI, @Nullable final Component lllllllllllllIIllllIIlIIlIIIIIIl) {
            this.type = lllllllllllllIIllllIIlIIlIIIIIII;
            this.id = lllllllllllllIIllllIIlIIlIIIIIlI;
            this.name = lllllllllllllIIllllIIlIIlIIIIIIl;
        }
        
        @NotNull
        public ShowEntity name(@Nullable final Component lllllllllllllIIllllIIlIIIlIlIlll) {
            if (Objects.equals(lllllllllllllIIllllIIlIIIlIlIlll, this.name)) {
                return this;
            }
            return new ShowEntity(this.type, this.id, lllllllllllllIIllllIIlIIIlIlIlll);
        }
        
        @NotNull
        public ShowEntity type(@NotNull final Keyed lllllllllllllIIllllIIlIIIllIlIll) {
            return this.type(Objects.requireNonNull(lllllllllllllIIllllIIlIIIllIlIll, "type").key());
        }
        
        @NotNull
        public ShowEntity id(@NotNull final UUID lllllllllllllIIllllIIlIIIllIIIIl) {
            if (Objects.requireNonNull(lllllllllllllIIllllIIlIIIllIIIIl).equals(this.id)) {
                return this;
            }
            return new ShowEntity(this.type, lllllllllllllIIllllIIlIIIllIIIIl, this.name);
        }
        
        @NotNull
        public static ShowEntity of(@NotNull final Key lllllllllllllIIllllIIlIIlIlIllII, @NotNull final UUID lllllllllllllIIllllIIlIIlIlIlIll) {
            return of(lllllllllllllIIllllIIlIIlIlIllII, lllllllllllllIIllllIIlIIlIlIlIll, null);
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllIIllllIIlIIIlIIIlIl = this.type.hashCode();
            lllllllllllllIIllllIIlIIIlIIIlIl = 31 * lllllllllllllIIllllIIlIIIlIIIlIl + this.id.hashCode();
            lllllllllllllIIllllIIlIIIlIIIlIl = 31 * lllllllllllllIIllllIIlIIIlIIIlIl + Objects.hashCode(this.name);
            return lllllllllllllIIllllIIlIIIlIIIlIl;
        }
        
        @NotNull
        public UUID id() {
            return this.id;
        }
    }
}
