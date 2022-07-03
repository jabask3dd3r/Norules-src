package com.viaversion.viaversion.libs.kyori.adventure.text.flattener;

import java.util.function.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

final class ComponentFlattenerImpl implements ComponentFlattener
{
    private final /* synthetic */ Map<Class<?>, Function<?, String>> flatteners;
    private final /* synthetic */ Map<Class<?>, BiConsumer<?, Consumer<Component>>> complexFlatteners;
    private final /* synthetic */ ConcurrentMap<Class<?>, Handler> propagatedFlatteners;
    private final /* synthetic */ Function<Component, String> unknownHandler;
    
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this.flatteners, this.complexFlatteners, this.unknownHandler);
    }
    
    ComponentFlattenerImpl(final Map<Class<?>, Function<?, String>> lllllllllllllIIIIIIIIlIlIlIlllIl, final Map<Class<?>, BiConsumer<?, Consumer<Component>>> lllllllllllllIIIIIIIIlIlIlIlllII, @Nullable final Function<Component, String> lllllllllllllIIIIIIIIlIlIlIllIll) {
        this.propagatedFlatteners = new ConcurrentHashMap<Class<?>, Handler>();
        this.flatteners = Collections.unmodifiableMap((Map<? extends Class<?>, ? extends Function<?, String>>)new HashMap<Class<?>, Function<?, String>>(lllllllllllllIIIIIIIIlIlIlIlllIl));
        this.complexFlatteners = Collections.unmodifiableMap((Map<? extends Class<?>, ? extends BiConsumer<?, Consumer<Component>>>)new HashMap<Class<?>, BiConsumer<?, Consumer<Component>>>(lllllllllllllIIIIIIIIlIlIlIlllII));
        this.unknownHandler = lllllllllllllIIIIIIIIlIlIlIllIll;
    }
    
    static {
        MAX_DEPTH = 512;
        BASIC = new BuilderImpl().mapper(KeybindComponent.class, lllllllllllllIIIIIIIIlIIlIllIlIl -> lllllllllllllIIIIIIIIlIIlIllIlIl.keybind()).mapper(ScoreComponent.class, ScoreComponent::value).mapper(SelectorComponent.class, SelectorComponent::pattern).mapper(TextComponent.class, TextComponent::content).mapper(TranslatableComponent.class, TranslatableComponent::key).build();
        TEXT_ONLY = new BuilderImpl().mapper(TextComponent.class, TextComponent::content).build();
    }
    
    @Nullable
    private <T extends Component> Handler flattener(final T lllllllllllllIIIIIIIIlIlIIlIlIII) {
        final Function<Component, String> lllllllllllllIIIIIIIIlIlIIIIlIIl;
        final Iterator<Map.Entry<Class<?>, Function<?, String>>> iterator;
        Map.Entry<Class<?>, Function<?, String>> lllllllllllllIIIIIIIIlIlIIIIllIl;
        BiConsumer<Component, Consumer<Component>> lllllllllllllIIIIIIIIlIlIIIIlIII;
        final Iterator<Map.Entry<Class<?>, BiConsumer<?, Consumer<Component>>>> iterator2;
        Map.Entry<Class<?>, BiConsumer<?, Consumer<Component>>> lllllllllllllIIIIIIIIlIlIIIIllII;
        final Handler lllllllllllllIIIIIIIIlIlIIlIIlIl = this.propagatedFlatteners.computeIfAbsent(lllllllllllllIIIIIIIIlIlIIlIlIII.getClass(), lllllllllllllIIIIIIIIlIlIIIIIllI -> {
            lllllllllllllIIIIIIIIlIlIIIIlIIl = (Function<Component, String>)this.flatteners.get(lllllllllllllIIIIIIIIlIlIIIIIllI);
            if (lllllllllllllIIIIIIIIlIlIIIIlIIl != null) {
                return (lllllllllllllIIIIIIIIlIIlIllllIl, lllllllllllllIIIIIIIIlIIlIllllII, lllllllllllllIIIIIIIIlIIlIlllIll) -> lllllllllllllIIIIIIIIlIIlIllllII.component(lllllllllllllIIIIIIIIlIlIIIIlIIl.apply(lllllllllllllIIIIIIIIlIIlIllllIl));
            }
            else {
                this.flatteners.entrySet().iterator();
                while (iterator.hasNext()) {
                    lllllllllllllIIIIIIIIlIlIIIIllIl = iterator.next();
                    if (lllllllllllllIIIIIIIIlIlIIIIllIl.getKey().isAssignableFrom(lllllllllllllIIIIIIIIlIlIIIIIllI)) {
                        return (lllllllllllllIIIIIIIIlIIllIIIlll, lllllllllllllIIIIIIIIlIIllIIIIlI, lllllllllllllIIIIIIIIlIIllIIIlIl) -> lllllllllllllIIIIIIIIlIIllIIIIlI.component(lllllllllllllIIIIIIIIlIlIIIIllIl.getValue().apply(lllllllllllllIIIIIIIIlIIllIIIlll));
                    }
                }
                lllllllllllllIIIIIIIIlIlIIIIlIII = (BiConsumer<Component, Consumer<Component>>)this.complexFlatteners.get(lllllllllllllIIIIIIIIlIlIIIIIllI);
                if (lllllllllllllIIIIIIIIlIlIIIIlIII != null) {
                    return (lllllllllllllIIIIIIIIlIIllIllIlI, lllllllllllllIIIIIIIIlIIllIllllI, lllllllllllllIIIIIIIIlIIllIlllIl) -> lllllllllllllIIIIIIIIlIlIIIIlIII.accept(lllllllllllllIIIIIIIIlIIllIllIlI, lllllllllllllIIIIIIIIlIIllIIllII -> this.flatten0(lllllllllllllIIIIIIIIlIIllIIllII, lllllllllllllIIIIIIIIlIIllIllllI, lllllllllllllIIIIIIIIlIIllIlllIl));
                }
                else {
                    this.complexFlatteners.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        lllllllllllllIIIIIIIIlIlIIIIllII = iterator2.next();
                        if (lllllllllllllIIIIIIIIlIlIIIIllII.getKey().isAssignableFrom(lllllllllllllIIIIIIIIlIlIIIIIllI)) {
                            return (lllllllllllllIIIIIIIIlIIlllllIlI, lllllllllllllIIIIIIIIlIIlllllIIl, lllllllllllllIIIIIIIIlIIlllllIII) -> lllllllllllllIIIIIIIIlIlIIIIllII.getValue().accept(lllllllllllllIIIIIIIIlIIlllllIlI, lllllllllllllIIIIIIIIlIIlllIIlll -> this.flatten0(lllllllllllllIIIIIIIIlIIlllIIlll, lllllllllllllIIIIIIIIlIIlllllIIl, lllllllllllllIIIIIIIIlIIlllllIII));
                        }
                    }
                    return Handler.NONE;
                }
            }
        });
        if (lllllllllllllIIIIIIIIlIlIIlIIlIl == Handler.NONE) {
            return (this.unknownHandler == null) ? null : ((lllllllllllllIIIIIIIIlIlIIIllIII, lllllllllllllIIIIIIIIlIlIIIlIlll, lllllllllllllIIIIIIIIlIlIIIlIllI) -> this.unknownHandler.apply(lllllllllllllIIIIIIIIlIlIIIllIII));
        }
        return lllllllllllllIIIIIIIIlIlIIlIIlIl;
    }
    
    private void flatten0(@NotNull final Component lllllllllllllIIIIIIIIlIlIIllllIl, @NotNull final FlattenerListener lllllllllllllIIIIIIIIlIlIIlllllI, final int lllllllllllllIIIIIIIIlIlIIllllII) {
        Objects.requireNonNull(lllllllllllllIIIIIIIIlIlIIllllIl, "input");
        Objects.requireNonNull(lllllllllllllIIIIIIIIlIlIIlllllI, "listener");
        if (lllllllllllllIIIIIIIIlIlIIllllIl == Component.empty()) {
            return;
        }
        if (lllllllllllllIIIIIIIIlIlIIllllII > 512) {
            throw new IllegalStateException("Exceeded maximum depth of 512 while attempting to flatten components!");
        }
        final Handler lllllllllllllIIIIIIIIlIlIIllIllI = this.flattener(lllllllllllllIIIIIIIIlIlIIllllIl);
        final Style lllllllllllllIIIIIIIIlIlIIllIlIl = lllllllllllllIIIIIIIIlIlIIllllIl.style();
        lllllllllllllIIIIIIIIlIlIIlllllI.pushStyle(lllllllllllllIIIIIIIIlIlIIllIlIl);
        try {
            if (lllllllllllllIIIIIIIIlIlIIllIllI != null) {
                lllllllllllllIIIIIIIIlIlIIllIllI.handle(lllllllllllllIIIIIIIIlIlIIllllIl, lllllllllllllIIIIIIIIlIlIIlllllI, lllllllllllllIIIIIIIIlIlIIllllII + 1);
            }
            if (!lllllllllllllIIIIIIIIlIlIIllllIl.children().isEmpty()) {
                for (final Component lllllllllllllIIIIIIIIlIlIIlllIll : lllllllllllllIIIIIIIIlIlIIllllIl.children()) {
                    this.flatten0(lllllllllllllIIIIIIIIlIlIIlllIll, lllllllllllllIIIIIIIIlIlIIlllllI, lllllllllllllIIIIIIIIlIlIIllllII + 1);
                }
            }
        }
        finally {
            lllllllllllllIIIIIIIIlIlIIlllllI.popStyle(lllllllllllllIIIIIIIIlIlIIllIlIl);
        }
    }
    
    @Override
    public void flatten(@NotNull final Component lllllllllllllIIIIIIIIlIlIlIIlllI, @NotNull final FlattenerListener lllllllllllllIIIIIIIIlIlIlIIllll) {
        this.flatten0(lllllllllllllIIIIIIIIlIlIlIIlllI, lllllllllllllIIIIIIIIlIlIlIIllll, 0);
    }
    
    static final class BuilderImpl implements Builder
    {
        @Nullable
        private /* synthetic */ Function<Component, String> unknownHandler;
        private final /* synthetic */ Map<Class<?>, Function<?, String>> flatteners;
        private final /* synthetic */ Map<Class<?>, BiConsumer<?, Consumer<Component>>> complexFlatteners;
        
        @Override
        public <T extends Component> Builder complexMapper(@NotNull final Class<T> lllllllllllllIIIIllIllIllIllIIll, @NotNull final BiConsumer<T, Consumer<Component>> lllllllllllllIIIIllIllIllIllIlII) {
            this.validateNoneInHierarchy(Objects.requireNonNull(lllllllllllllIIIIllIllIllIllIIll, "type"));
            this.complexFlatteners.put(lllllllllllllIIIIllIllIllIllIIll, Objects.requireNonNull(lllllllllllllIIIIllIllIllIllIlII, "converter"));
            this.flatteners.remove(lllllllllllllIIIIllIllIllIllIIll);
            return this;
        }
        
        @Override
        public Builder unknownMapper(@Nullable final Function<Component, String> lllllllllllllIIIIllIllIllIIlIlIl) {
            this.unknownHandler = lllllllllllllIIIIllIllIllIIlIlIl;
            return this;
        }
        
        @NotNull
        @Override
        public ComponentFlattener build() {
            return new ComponentFlattenerImpl(this.flatteners, this.complexFlatteners, this.unknownHandler);
        }
        
        private static void testHierarchy(final Class<?> lllllllllllllIIIIllIllIllIIlllII, final Class<?> lllllllllllllIIIIllIllIllIIlllIl) {
            if (!lllllllllllllIIIIllIllIllIIlllII.equals(lllllllllllllIIIIllIllIllIIlllIl) && (lllllllllllllIIIIllIllIllIIlllII.isAssignableFrom(lllllllllllllIIIIllIllIllIIlllIl) || lllllllllllllIIIIllIllIllIIlllIl.isAssignableFrom(lllllllllllllIIIIllIllIllIIlllII))) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Conflict detected between already registered type ").append(lllllllllllllIIIIllIllIllIIlllII).append(" and newly registered type ").append(lllllllllllllIIIIllIllIllIIlllIl).append("! Types in a component flattener must not share a common hierachy!")));
            }
        }
        
        BuilderImpl(final Map<Class<?>, Function<?, String>> lllllllllllllIIIIllIllIlllIIlllI, final Map<Class<?>, BiConsumer<?, Consumer<Component>>> lllllllllllllIIIIllIllIlllIlIIII, @Nullable final Function<Component, String> lllllllllllllIIIIllIllIlllIIllll) {
            this.flatteners = new HashMap<Class<?>, Function<?, String>>(lllllllllllllIIIIllIllIlllIIlllI);
            this.complexFlatteners = new HashMap<Class<?>, BiConsumer<?, Consumer<Component>>>(lllllllllllllIIIIllIllIlllIlIIII);
            this.unknownHandler = lllllllllllllIIIIllIllIlllIIllll;
        }
        
        private void validateNoneInHierarchy(final Class<? extends Component> lllllllllllllIIIIllIllIllIlIlIII) {
            for (final Class<?> lllllllllllllIIIIllIllIllIlIIlll : this.flatteners.keySet()) {
                testHierarchy(lllllllllllllIIIIllIllIllIlIIlll, lllllllllllllIIIIllIllIllIlIlIII);
            }
            for (final Class<?> lllllllllllllIIIIllIllIllIlIIllI : this.complexFlatteners.keySet()) {
                testHierarchy(lllllllllllllIIIIllIllIllIlIIllI, lllllllllllllIIIIllIllIllIlIlIII);
            }
        }
        
        BuilderImpl() {
            this.flatteners = new HashMap<Class<?>, Function<?, String>>();
            this.complexFlatteners = new HashMap<Class<?>, BiConsumer<?, Consumer<Component>>>();
        }
        
        @Override
        public <T extends Component> Builder mapper(@NotNull final Class<T> lllllllllllllIIIIllIllIllIllllll, @NotNull final Function<T, String> lllllllllllllIIIIllIllIllIlllllI) {
            this.validateNoneInHierarchy(Objects.requireNonNull(lllllllllllllIIIIllIllIllIllllll, "type"));
            this.flatteners.put(lllllllllllllIIIIllIllIllIllllll, Objects.requireNonNull(lllllllllllllIIIIllIllIllIlllllI, "converter"));
            this.complexFlatteners.remove(lllllllllllllIIIIllIllIllIllllll);
            return this;
        }
    }
    
    @FunctionalInterface
    interface Handler
    {
        public static final /* synthetic */ Handler NONE = (lllllllllllllllIIIlIllIlllIllIlI, lllllllllllllllIIIlIllIlllIllIIl, lllllllllllllllIIIlIllIlllIllIII) -> {};
        
        void handle(final Component lllllllllllllllIIIlIllIlllIlllII, final FlattenerListener lllllllllllllllIIIlIllIlllIlllIl, final int lllllllllllllllIIIlIllIlllIllIll);
    }
}
