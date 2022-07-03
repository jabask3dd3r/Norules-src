package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.translation.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.util.regex.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.event.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

@ApiStatus.NonExtendable
public interface Component extends ComponentBuilderApplicable, ComponentLike, Examinable, HoverEventSource<Component>
{
    public static final /* synthetic */ BiPredicate<? super Component, ? super Component> EQUALS_IDENTITY = (lllllllllllllIlIllllllIIllIIlIII, lllllllllllllIlIllllllIIllIIIlll) -> lllllllllllllIlIllllllIIllIIlIII == lllllllllllllIlIllllllIIllIIIlll;
    
    @Nullable
    default ClickEvent clickEvent() {
        return this.style().clickEvent();
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIllllllllIIIlllII, @Nullable final TextColor lllllllllllllIlIllllllllIIIllIlI, @NotNull final ComponentLike... lllllllllllllIlIllllllllIIIllIll) {
        return translatable(lllllllllllllIlIllllllllIIIlllII, Style.style(lllllllllllllIlIllllllllIIIllIlI), lllllllllllllIlIllllllllIIIllIll);
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final long lllllllllllllIlIllllllllllIIIIII, @Nullable final TextColor lllllllllllllIlIllllllllllIIIIIl) {
        return text(String.valueOf(lllllllllllllIlIllllllllllIIIIII), lllllllllllllIlIllllllllllIIIIIl);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIllllllllIIllllII, @NotNull final ComponentLike... lllllllllllllIlIllllllllIIllllIl) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIllllllllIIllllII, "translatable").translationKey(), lllllllllllllIlIllllllllIIllllIl);
    }
    
    @NotNull
    @Contract(value = "_, _, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllIlIlIIIIl, @Nullable final TextColor lllllllllllllIlIlllllllIlIlIIIlI, @NotNull final Set<TextDecoration> lllllllllllllIlIlllllllIlIlIIIll, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIlIlIIIII) {
        return translatable(lllllllllllllIlIlllllllIlIlIIIIl, Style.style(lllllllllllllIlIlllllllIlIlIIIlI, lllllllllllllIlIlllllllIlIlIIIll), lllllllllllllIlIlllllllIlIlIIIII);
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default TextComponent text(final long lllllllllllllIlIllllllllllIIlllI) {
        return text(String.valueOf(lllllllllllllIlIllllllllllIIlllI));
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllIlIlllIll, @Nullable final TextColor lllllllllllllIlIlllllllIlIlllIlI, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIlIllllII) {
        return translatable(lllllllllllllIlIlllllllIlIlllIll, Style.style(lllllllllllllIlIlllllllIlIlllIlI), lllllllllllllIlIlllllllIlIllllII);
    }
    
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval
    @Contract(pure = true)
    default Component replaceText(@NotNull final Pattern lllllllllllllIlIllllllIlIllIllll, @NotNull final Function<TextComponent.Builder, ComponentLike> lllllllllllllIlIllllllIlIllIlllI, final int lllllllllllllIlIllllllIlIlllIIII) {
        return this.replaceText(lllllllllllllIlIllllllIlIIIlIIll -> lllllllllllllIlIllllllIlIIIlIIll.match(lllllllllllllIlIllllllIlIllIllll).times(lllllllllllllIlIllllllIlIlllIIII).replacement(lllllllllllllIlIllllllIlIllIlllI));
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default SelectorComponent selector(@NotNull final String lllllllllllllIllIIIIIIIlIIIIlIIl, @Nullable final ComponentLike lllllllllllllIllIIIIIIIlIIIIlIII) {
        return new SelectorComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIllIIIIIIIlIIIIlIIl, lllllllllllllIllIIIIIIIlIIIIlIII);
    }
    
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    default TextComponent text(@NotNull final String lllllllllllllIllIIIIIIIIllIlIllI) {
        if (lllllllllllllIllIIIIIIIIllIlIllI.isEmpty()) {
            return empty();
        }
        return new TextComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIllIIIIIIIIllIlIllI);
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final char lllllllllllllIllIIIIIIIIIlIlllII, @Nullable final TextColor lllllllllllllIllIIIIIIIIIlIllIll, @NotNull final Set<TextDecoration> lllllllllllllIllIIIIIIIIIlIllIlI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIlIlllII), lllllllllllllIllIIIIIIIIIlIllIll, lllllllllllllIllIIIIIIIIIlIllIlI);
    }
    
    @Contract(pure = true)
    default TranslatableComponent.Builder translatable() {
        return new TranslatableComponentImpl.BuilderImpl();
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default KeybindComponent keybind(@NotNull final String lllllllllllllIllIIIIIIIlIlIlIIII, @NotNull final Style lllllllllllllIllIIIIIIIlIlIlIIIl) {
        return new KeybindComponentImpl(Collections.emptyList(), lllllllllllllIllIIIIIIIlIlIlIIIl, lllllllllllllIllIIIIIIIlIlIlIIII);
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllllIIllIlI) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllllIIllIlI, "translatable").translationKey(), Style.empty());
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIllllllllIlIlIIII, @Nullable final TextColor lllllllllllllIlIllllllllIlIIlllI, @NotNull final Set<TextDecoration> lllllllllllllIlIllllllllIlIIllll) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIllllllllIlIlIIII, "translatable").translationKey(), lllllllllllllIlIllllllllIlIIlllI, lllllllllllllIlIllllllllIlIIllll);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final float lllllllllllllIllIIIIIIIIIIIIIlII, @Nullable final TextColor lllllllllllllIllIIIIIIIIIIIIIIll, @NotNull final Set<TextDecoration> lllllllllllllIllIIIIIIIIIIIIIIlI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIIIIlII), lllllllllllllIllIIIIIIIIIIIIIIll, lllllllllllllIllIIIIIIIIIIIIIIlI);
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default TextComponent text(final float lllllllllllllIllIIIIIIIIIIlIIllI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIlIIllI));
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final boolean lllllllllllllIllIIIIIIIIlIIlIlII, @Nullable final TextColor lllllllllllllIllIIIIIIIIlIIlIIlI, final TextDecoration... lllllllllllllIllIIIIIIIIlIIlIIll) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIlIIlIlII), lllllllllllllIllIIIIIIIIlIIlIIlI, lllllllllllllIllIIIIIIIIlIIlIIll);
    }
    
    @Nullable
    default TextColor color() {
        return this.style().color();
    }
    
    @Deprecated
    @Contract(pure = true)
    @NotNull
    @ApiStatus.ScheduledForRemoval
    default Component replaceText(@NotNull final String lllllllllllllIlIllllllIlIllIIIIl, @Nullable final ComponentLike lllllllllllllIlIllllllIlIllIIIII, @NotNull final IntFunction2<PatternReplacementResult> lllllllllllllIlIllllllIlIlIlllll) {
        return this.replaceText(lllllllllllllIlIllllllIlIIIlllll -> lllllllllllllIlIllllllIlIIIlllll.matchLiteral(lllllllllllllIlIllllllIlIllIIIIl).replacement(lllllllllllllIlIllllllIlIllIIIII).condition(lllllllllllllIlIllllllIlIlIlllll));
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(@NotNull final String lllllllllllllIllIIIIIIIIlIllIIll, @Nullable final TextColor lllllllllllllIllIIIIIIIIlIllIIlI, @NotNull final Set<TextDecoration> lllllllllllllIllIIIIIIIIlIllIlII) {
        return new TextComponentImpl(Collections.emptyList(), Style.style(lllllllllllllIllIIIIIIIIlIllIIlI, lllllllllllllIllIIIIIIIIlIllIlII), lllllllllllllIllIIIIIIIIlIllIIll);
    }
    
    @NotNull
    @Contract(pure = true)
    default Component colorIfAbsent(@Nullable final TextColor lllllllllllllIlIlllllllIIIIIllII) {
        if (this.color() == null) {
            return this.color(lllllllllllllIlIlllllllIIIIIllII);
        }
        return this;
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final int lllllllllllllIlIlllllllllllIIIlI, @Nullable final TextColor lllllllllllllIlIlllllllllllIIIll, final TextDecoration... lllllllllllllIlIlllllllllllIIlII) {
        return text(String.valueOf(lllllllllllllIlIlllllllllllIIIlI), lllllllllllllIlIlllllllllllIIIll, lllllllllllllIlIlllllllllllIIlII);
    }
    
    @NotNull
    @Contract(pure = true)
    default Component style(@NotNull final Consumer<Style.Builder> lllllllllllllIlIlllllllIIlIIllII) {
        return this.style(this.style().edit(lllllllllllllIlIlllllllIIlIIllII));
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent join(@NotNull final ComponentLike lllllllllllllIllIIIIIIIlllIlllII, @NotNull final ComponentLike... lllllllllllllIllIIIIIIIlllIlllIl) {
        return join(lllllllllllllIllIIIIIIIlllIlllII, Arrays.asList(lllllllllllllIllIIIIIIIlllIlllIl));
    }
    
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllllIIllllI) {
        return translatable(lllllllllllllIlIlllllllllIIllllI, Style.empty());
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default ScoreComponent score(@NotNull final String lllllllllllllIllIIIIIIIlIIlIIlII, @NotNull final String lllllllllllllIllIIIIIIIlIIlIIlIl) {
        return score(lllllllllllllIllIIIIIIIlIIlIIlII, lllllllllllllIllIIIIIIIlIIlIIlIl, null);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default BlockNBTComponent blockNBT(@NotNull final String lllllllllllllIllIIIIIIIllIIIlIll, final boolean lllllllllllllIllIIIIIIIllIIIllII, final BlockNBTComponent.Pos lllllllllllllIllIIIIIIIllIIIlllI) {
        return blockNBT(lllllllllllllIllIIIIIIIllIIIlIll, lllllllllllllIllIIIIIIIllIIIllII, null, lllllllllllllIllIIIIIIIllIIIlllI);
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final double lllllllllllllIllIIIIIIIIIIllllII, @Nullable final TextColor lllllllllllllIllIIIIIIIIIIlllIll, final TextDecoration... lllllllllllllIllIIIIIIIIIIlllIlI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIllllII), lllllllllllllIllIIIIIIIIIIlllIll, lllllllllllllIllIIIIIIIIIIlllIlI);
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllIllIlIlII, @NotNull final Style lllllllllllllIlIlllllllIllIlIIll, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIllIlIIlI) {
        return new TranslatableComponentImpl(Collections.emptyList(), lllllllllllllIlIlllllllIllIlIIll, lllllllllllllIlIlllllllIllIlIlII, lllllllllllllIlIlllllllIllIlIIlI);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(@NotNull final String lllllllllllllIllIIIIIIIIllIIlIII, @Nullable final TextColor lllllllllllllIllIIIIIIIIllIIlIIl) {
        return new TextComponentImpl(Collections.emptyList(), Style.style(lllllllllllllIllIIIIIIIIllIIlIIl), lllllllllllllIllIIIIIIIIllIIlIII);
    }
    
    @Contract(pure = true)
    default ScoreComponent.Builder score() {
        return new ScoreComponentImpl.BuilderImpl();
    }
    
    @Contract("_ -> new")
    @NotNull
    default StorageNBTComponent storageNBT(@NotNull final Consumer<? super StorageNBTComponent.Builder> lllllllllllllIllIIIIIIIlIIIIIIlI) {
        return Buildable.configureAndBuild(storageNBT(), lllllllllllllIllIIIIIIIlIIIIIIlI);
    }
    
    @NotNull
    @Contract("_ -> new")
    default TranslatableComponent translatable(@NotNull final Consumer<? super TranslatableComponent.Builder> lllllllllllllIlIlllllllllIlIIIlI) {
        return Buildable.configureAndBuild(translatable(), lllllllllllllIlIlllllllllIlIIIlI);
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllIllIlllIl, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIllIlllII) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllIllIlllIl, "translatable").translationKey(), lllllllllllllIlIlllllllIllIlllII);
    }
    
    @NotNull
    @Contract(pure = true)
    Component style(@NotNull final Style lllllllllllllIlIlllllllIIlIIllll);
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final double lllllllllllllIllIIIIIIIIIIlIllll, @Nullable final TextColor lllllllllllllIllIIIIIIIIIIllIIII, @NotNull final Set<TextDecoration> lllllllllllllIllIIIIIIIIIIlIlllI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIlIllll), lllllllllllllIllIIIIIIIIIIllIIII, lllllllllllllIllIIIIIIIIIIlIlllI);
    }
    
    @NotNull
    @Contract(pure = true)
    Component children(@NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIlIIIIlll);
    
    @Nullable
    default String insertion() {
        return this.style().insertion();
    }
    
    @NotNull
    @Contract(pure = true)
    default TextComponent text(final char lllllllllllllIllIIIIIIIIIllllllI) {
        if (lllllllllllllIllIIIIIIIIIllllllI == '\n') {
            return newline();
        }
        if (lllllllllllllIllIIIIIIIIIllllllI == ' ') {
            return space();
        }
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIllllllI));
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final boolean lllllllllllllIllIIIIIIIIlIIlllII, @Nullable final TextColor lllllllllllllIllIIIIIIIIlIIlllIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIlIIlllII), lllllllllllllIllIIIIIIIIlIIlllIl);
    }
    
    @NotNull
    default TextComponent newline() {
        return TextComponentImpl.NEWLINE;
    }
    
    default TextDecoration.State decoration(@NotNull final TextDecoration lllllllllllllIlIllllllIlllllIlll) {
        return this.style().decoration(lllllllllllllIlIllllllIlllllIlll);
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final int lllllllllllllIlIlllllllllllIllII, @Nullable final TextColor lllllllllllllIlIlllllllllllIllIl) {
        return text(String.valueOf(lllllllllllllIlIlllllllllllIllII), lllllllllllllIlIlllllllllllIllIl);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(final double lllllllllllllIllIIIIIIIIIlIIIlII, @Nullable final TextColor lllllllllllllIllIIIIIIIIIlIIIlIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIlIIIlII), lllllllllllllIllIIIIIIIIIlIIIlIl);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllllIIlIlII, @NotNull final Style lllllllllllllIlIlllllllllIIlIlIl) {
        return new TranslatableComponentImpl(Collections.emptyList(), lllllllllllllIlIlllllllllIIlIlIl, lllllllllllllIlIlllllllllIIlIlII, Collections.emptyList());
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIllllllllIlllIIll, @Nullable final TextColor lllllllllllllIlIllllllllIlllIlII, final TextDecoration... lllllllllllllIlIllllllllIlllIIlI) {
        return translatable(lllllllllllllIlIllllllllIlllIIll, Style.style(lllllllllllllIlIllllllllIlllIlII, lllllllllllllIlIllllllllIlllIIlI));
    }
    
    @Contract(pure = true)
    @NotNull
    default Component decorations(@NotNull final Map<TextDecoration, TextDecoration.State> lllllllllllllIlIllllllIlllIlIlll) {
        return this.style(this.style().decorations(lllllllllllllIlIllllllIlllIlIlll));
    }
    
    @Contract(pure = true)
    @NotNull
    default Component append(@NotNull final ComponentBuilder<?, ?> lllllllllllllIlIlllllllIIlIlIlII) {
        return this.append((Component)lllllllllllllIlIlllllllIIlIlIlII.build());
    }
    
    @NotNull
    List<Component> children();
    
    @Contract("_ -> new")
    @NotNull
    default SelectorComponent selector(@NotNull final Consumer<? super SelectorComponent.Builder> lllllllllllllIllIIIIIIIlIIIlIIlI) {
        return Buildable.configureAndBuild(selector(), lllllllllllllIllIIIIIIIlIIIlIIlI);
    }
    
    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    default StorageNBTComponent storageNBT(@NotNull final String lllllllllllllIllIIIIIIIIlllIIlII, final boolean lllllllllllllIllIIIIIIIIlllIIlll, @Nullable final ComponentLike lllllllllllllIllIIIIIIIIlllIIllI, @NotNull final Key lllllllllllllIllIIIIIIIIlllIIlIl) {
        return new StorageNBTComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIllIIIIIIIIlllIIlII, lllllllllllllIllIIIIIIIIlllIIlll, lllllllllllllIllIIIIIIIIlllIIllI, lllllllllllllIllIIIIIIIIlllIIlIl);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIllllllllIlIllIll, @Nullable final TextColor lllllllllllllIlIllllllllIlIlllII, @NotNull final Set<TextDecoration> lllllllllllllIlIllllllllIlIllIlI) {
        return translatable(lllllllllllllIlIllllllllIlIllIll, Style.style(lllllllllllllIlIllllllllIlIlllII, lllllllllllllIlIllllllllIlIllIlI));
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllIlllIIlIl, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIlllIIlII) {
        return new TranslatableComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIlIlllllllIlllIIlIl, lllllllllllllIlIlllllllIlllIIlII);
    }
    
    default boolean contains(@NotNull final Component lllllllllllllIlIlllllllIIlllIllI, @NotNull final BiPredicate<? super Component, ? super Component> lllllllllllllIlIlllllllIIlllIlll) {
        if (lllllllllllllIlIlllllllIIlllIlll.test(this, lllllllllllllIlIlllllllIIlllIllI)) {
            return true;
        }
        for (final Component lllllllllllllIlIlllllllIIlllIlIl : this.children()) {
            if (lllllllllllllIlIlllllllIIlllIlIl.contains(lllllllllllllIlIlllllllIIlllIllI, lllllllllllllIlIlllllllIIlllIlll)) {
                return true;
            }
        }
        final HoverEvent<?> lllllllllllllIlIlllllllIIllIlllI = this.hoverEvent();
        if (lllllllllllllIlIlllllllIIllIlllI != null) {
            final Object lllllllllllllIlIlllllllIIlllIIll = lllllllllllllIlIlllllllIIllIlllI.value();
            Component lllllllllllllIlIlllllllIIlllIIlI = null;
            if (lllllllllllllIlIlllllllIIlllIIll instanceof Component) {
                lllllllllllllIlIlllllllIIlllIIlI = (Component)lllllllllllllIlIlllllllIIllIlllI.value();
            }
            else if (lllllllllllllIlIlllllllIIlllIIll instanceof HoverEvent.ShowEntity) {
                lllllllllllllIlIlllllllIIlllIIlI = ((HoverEvent.ShowEntity)lllllllllllllIlIlllllllIIlllIIll).name();
            }
            if (lllllllllllllIlIlllllllIIlllIIlI != null) {
                if (lllllllllllllIlIlllllllIIlllIlll.test(lllllllllllllIlIlllllllIIlllIllI, lllllllllllllIlIlllllllIIlllIIlI)) {
                    return true;
                }
                for (final Component lllllllllllllIlIlllllllIIlllIlII : lllllllllllllIlIlllllllIIlllIIlI.children()) {
                    if (lllllllllllllIlIlllllllIIlllIlII.contains(lllllllllllllIlIlllllllIIlllIllI, lllllllllllllIlIlllllllIIlllIlll)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent join(@NotNull final ComponentLike lllllllllllllIllIIIIIIIlllIIIlII, final Iterable<? extends ComponentLike> lllllllllllllIllIIIIIIIlllIIIllI) {
        final Iterator<? extends ComponentLike> lllllllllllllIllIIIIIIIlllIIIIII = lllllllllllllIllIIIIIIIlllIIIllI.iterator();
        if (!lllllllllllllIllIIIIIIIlllIIIIII.hasNext()) {
            return empty();
        }
        final TextComponent.Builder lllllllllllllIllIIIIIIIllIlllllI = text();
        while (lllllllllllllIllIIIIIIIlllIIIIII.hasNext()) {
            lllllllllllllIllIIIIIIIllIlllllI.append((ComponentLike)lllllllllllllIllIIIIIIIlllIIIIII.next());
            if (lllllllllllllIllIIIIIIIlllIIIIII.hasNext()) {
                lllllllllllllIllIIIIIIIllIlllllI.append(lllllllllllllIllIIIIIIIlllIIIlII);
            }
        }
        return ((ComponentBuilder<TextComponent, B>)lllllllllllllIllIIIIIIIllIlllllI).build();
    }
    
    @NotNull
    @Contract(value = "_, _, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIllllllllIIIIIIIl, @Nullable final TextColor lllllllllllllIlIllllllllIIIIIIll, @NotNull final Set<TextDecoration> lllllllllllllIlIllllllllIIIIIIlI, @NotNull final ComponentLike... lllllllllllllIlIllllllllIIIIIIII) {
        return translatable(lllllllllllllIlIllllllllIIIIIIIl, Style.style(lllllllllllllIlIllllllllIIIIIIll, lllllllllllllIlIllllllllIIIIIIlI), lllllllllllllIlIllllllllIIIIIIII);
    }
    
    @Contract(pure = true)
    default EntityNBTComponent.Builder entityNBT() {
        return new EntityNBTComponentImpl.BuilderImpl();
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(@NotNull final String lllllllllllllIllIIIIIIIIllIlIIII, @NotNull final Style lllllllllllllIllIIIIIIIIllIlIIIl) {
        return new TextComponentImpl(Collections.emptyList(), lllllllllllllIllIIIIIIIIllIlIIIl, lllllllllllllIllIIIIIIIIllIlIIII);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIllllllllIllIIllI, @Nullable final TextColor lllllllllllllIlIllllllllIllIlIII, final TextDecoration... lllllllllllllIlIllllllllIllIIlll) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIllllllllIllIIllI, "translatable").translationKey(), lllllllllllllIlIllllllllIllIlIII, lllllllllllllIlIllllllllIllIIlll);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(final float lllllllllllllIllIIIIIIIIIIlIIIII, @NotNull final Style lllllllllllllIllIIIIIIIIIIlIIIIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIlIIIII), lllllllllllllIllIIIIIIIIIIlIIIIl);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(final double lllllllllllllIllIIIIIIIIIlIIllII, @NotNull final Style lllllllllllllIllIIIIIIIIIlIIllIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIlIIllII), lllllllllllllIllIIIIIIIIIlIIllIl);
    }
    
    @Deprecated
    @NotNull
    @ApiStatus.ScheduledForRemoval
    @Contract(pure = true)
    default Component replaceFirstText(@NotNull final Pattern lllllllllllllIlIllllllIllIIIlIlI, @NotNull final Function<TextComponent.Builder, ComponentLike> lllllllllllllIlIllllllIllIIIlIll) {
        return this.replaceText(lllllllllllllIlIllllllIIlllllllI -> lllllllllllllIlIllllllIIlllllllI.match(lllllllllllllIlIllllllIllIIIlIlI).once().replacement(lllllllllllllIlIllllllIllIIIlIll));
    }
    
    @NotNull
    @Contract(pure = true)
    default Component insertion(@Nullable final String lllllllllllllIlIllllllIllIlllIIl) {
        return this.style(this.style().insertion(lllllllllllllIlIllllllIllIlllIIl));
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(@NotNull final String lllllllllllllIllIIIIIIIIlIllllll, @Nullable final TextColor lllllllllllllIllIIIIIIIIllIIIIII, final TextDecoration... lllllllllllllIllIIIIIIIIlIlllllI) {
        return new TextComponentImpl(Collections.emptyList(), Style.style(lllllllllllllIllIIIIIIIIllIIIIII, lllllllllllllIllIIIIIIIIlIlllllI), lllllllllllllIllIIIIIIIIlIllllll);
    }
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @NotNull
    @Contract(pure = true)
    default Component replaceFirstText(@NotNull final String lllllllllllllIlIllllllIllIIlIlIl, @Nullable final ComponentLike lllllllllllllIlIllllllIllIIlIllI) {
        return this.replaceText(lllllllllllllIlIllllllIIllllIlIl -> lllllllllllllIlIllllllIIllllIlIl.matchLiteral(lllllllllllllIlIllllllIllIIlIlIl).once().replacement(lllllllllllllIlIllllllIllIIlIllI));
    }
    
    @NotNull
    @Contract("_ -> new")
    default ScoreComponent score(@NotNull final Consumer<? super ScoreComponent.Builder> lllllllllllllIllIIIIIIIlIIlIlIlI) {
        return Buildable.configureAndBuild(score(), lllllllllllllIllIIIIIIIlIIlIlIlI);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final int lllllllllllllIlIllllllllllIlIllI, @Nullable final TextColor lllllllllllllIlIllllllllllIllIII, @NotNull final Set<TextDecoration> lllllllllllllIlIllllllllllIlIlll) {
        return text(String.valueOf(lllllllllllllIlIllllllllllIlIllI), lllllllllllllIlIllllllllllIllIII, lllllllllllllIlIllllllllllIlIlll);
    }
    
    @NotNull
    default Collector<Component, ? extends ComponentBuilder<?, ?>, Component> toComponent(@NotNull final Component lllllllllllllIllIIIIIIIllIllIlIl) {
        final List<Component> lllllllllllllIlIllllllIIllIllIlI;
        final TextComponent.Builder lllllllllllllIlIllllllIIllIllIIl;
        return (Collector<Component, ? extends ComponentBuilder<?, ?>, Component>)Collector.of((Supplier<? extends ComponentBuilder<?, ?>>)Component::text, (lllllllllllllIlIllllllIIllIIllII, lllllllllllllIlIllllllIIllIIlllI) -> {
            if (lllllllllllllIllIIIIIIIllIllIlIl != empty() && !lllllllllllllIlIllllllIIllIIllII.children().isEmpty()) {
                lllllllllllllIlIllllllIIllIIllII.append(lllllllllllllIllIIIIIIIllIllIlIl);
            }
            lllllllllllllIlIllllllIIllIIllII.append(lllllllllllllIlIllllllIIllIIlllI);
        }, (lllllllllllllIlIllllllIIllIlIlll, lllllllllllllIlIllllllIIllIllIll) -> {
            lllllllllllllIlIllllllIIllIllIlI = lllllllllllllIlIllllllIIllIlIlll.children();
            lllllllllllllIlIllllllIIllIllIIl = text().append(lllllllllllllIlIllllllIIllIllIlI);
            if (!lllllllllllllIlIllllllIIllIllIlI.isEmpty()) {
                lllllllllllllIlIllllllIIllIllIIl.append(lllllllllllllIllIIIIIIIllIllIlIl);
            }
            lllllllllllllIlIllllllIIllIllIIl.append(lllllllllllllIlIllllllIIllIllIll.children());
            return lllllllllllllIlIllllllIIllIllIIl;
        }, ComponentBuilder::build, new Collector.Characteristics[0]);
    }
    
    @NotNull
    Style style();
    
    @NotNull
    @Contract("_ -> new")
    default KeybindComponent keybind(@NotNull final Consumer<? super KeybindComponent.Builder> lllllllllllllIllIIIIIIIlIlIllIlI) {
        return Buildable.configureAndBuild(keybind(), lllllllllllllIllIIIIIIIlIlIllIlI);
    }
    
    @NotNull
    default Collector<Component, ? extends ComponentBuilder<?, ?>, Component> toComponent() {
        return toComponent(empty());
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllIlIlIllll, @Nullable final TextColor lllllllllllllIlIlllllllIlIllIIII, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIlIlIlllI) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllIlIlIllll, "translatable").translationKey(), lllllllllllllIlIlllllllIlIllIIII, lllllllllllllIlIlllllllIlIlIlllI);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(final long lllllllllllllIlIllllllllllIIlIII, @NotNull final Style lllllllllllllIlIllllllllllIIlIIl) {
        return text(String.valueOf(lllllllllllllIlIllllllllllIIlIII), lllllllllllllIlIllllllllllIIlIIl);
    }
    
    @NotNull
    @Contract(pure = true)
    Component append(@NotNull final Component lllllllllllllIlIlllllllIIlIllllI);
    
    @NotNull
    default TextComponent empty() {
        return TextComponentImpl.EMPTY;
    }
    
    @NotNull
    default Map<TextDecoration, TextDecoration.State> decorations() {
        return this.style().decorations();
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default StorageNBTComponent storageNBT(@NotNull final String lllllllllllllIllIIIIIIIIllllIlII, final boolean lllllllllllllIllIIIIIIIIllllIIll, @NotNull final Key lllllllllllllIllIIIIIIIIllllIIlI) {
        return storageNBT(lllllllllllllIllIIIIIIIIllllIlII, lllllllllllllIllIIIIIIIIllllIIll, null, lllllllllllllIllIIIIIIIIllllIIlI);
    }
    
    @Contract("_, _ -> new")
    @NotNull
    default EntityNBTComponent entityNBT(@NotNull final String lllllllllllllIllIIIIIIIlIllIIIIl, @NotNull final String lllllllllllllIllIIIIIIIlIllIIIII) {
        return ((ComponentBuilder<EntityNBTComponent, B>)((NBTComponentBuilder<C, EntityNBTComponent.Builder>)entityNBT()).nbtPath(lllllllllllllIllIIIIIIIlIllIIIIl).selector(lllllllllllllIllIIIIIIIlIllIIIII)).build();
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllllIIIllII, @NotNull final Style lllllllllllllIlIlllllllllIIIllIl) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllllIIIllII, "translatable").translationKey(), lllllllllllllIlIlllllllllIIIllIl);
    }
    
    @NotNull
    @Contract(pure = true)
    default Component style(@NotNull final Consumer<Style.Builder> lllllllllllllIlIlllllllIIlIIIlII, final Style.Merge.Strategy lllllllllllllIlIlllllllIIlIIIIll) {
        return this.style(this.style().edit(lllllllllllllIlIlllllllIIlIIIlII, lllllllllllllIlIlllllllIIlIIIIll));
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default KeybindComponent keybind(@NotNull final String lllllllllllllIllIIIIIIIlIlIlIllI) {
        return keybind(lllllllllllllIllIIIIIIIlIlIlIllI, Style.empty());
    }
    
    @Contract(pure = true)
    default SelectorComponent.Builder selector() {
        return new SelectorComponentImpl.BuilderImpl();
    }
    
    @Contract(pure = true)
    @NotNull
    default Component mergeStyle(@NotNull final Component lllllllllllllIlIlllllllIIIlIIIII, @NotNull final Set<Style.Merge> lllllllllllllIlIlllllllIIIIlllll) {
        return this.style(this.style().merge(lllllllllllllIlIlllllllIIIlIIIII.style(), lllllllllllllIlIlllllllIIIIlllll));
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default BlockNBTComponent blockNBT(@NotNull final String lllllllllllllIllIIIIIIIllIlIIIIl, final BlockNBTComponent.Pos lllllllllllllIllIIIIIIIllIlIIIII) {
        return blockNBT(lllllllllllllIllIIIIIIIllIlIIIIl, false, lllllllllllllIllIIIIIIIllIlIIIII);
    }
    
    @Deprecated
    default void detectCycle(@NotNull final Component lllllllllllllIlIlllllllIIllIIIll) {
        if (lllllllllllllIlIlllllllIIllIIIll.contains(this)) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Component cycle detected between ").append(this).append(" and ").append(lllllllllllllIlIlllllllIIllIIIll)));
        }
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(final boolean lllllllllllllIllIIIIIIIIlIlIIlII, @NotNull final Style lllllllllllllIllIIIIIIIIlIlIIlIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIlIlIIlII), lllllllllllllIllIIIIIIIIlIlIIlIl);
    }
    
    @Contract("_ -> new")
    @NotNull
    default EntityNBTComponent entityNBT(@NotNull final Consumer<? super EntityNBTComponent.Builder> lllllllllllllIllIIIIIIIlIllIIllI) {
        return Buildable.configureAndBuild(entityNBT(), lllllllllllllIllIIIIIIIlIllIIllI);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllIllIIIllI, @NotNull final Style lllllllllllllIlIlllllllIllIIIlll, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIllIIlIII) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllIllIIIllI, "translatable").translationKey(), lllllllllllllIlIlllllllIllIIIlll, lllllllllllllIlIlllllllIllIIlIII);
    }
    
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    default SelectorComponent selector(@NotNull final String lllllllllllllIllIIIIIIIlIIIIlllI) {
        return selector(lllllllllllllIllIIIIIIIlIIIIlllI, null);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final boolean lllllllllllllIllIIIIIIIIlIIIIllI, @Nullable final TextColor lllllllllllllIllIIIIIIIIlIIIlIII, @NotNull final Set<TextDecoration> lllllllllllllIllIIIIIIIIlIIIIlll) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIlIIIIllI), lllllllllllllIllIIIIIIIIlIIIlIII, lllllllllllllIllIIIIIIIIlIIIIlll);
    }
    
    default boolean hasStyling() {
        return !this.style().isEmpty();
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIllllllllIIllIIlI, @NotNull final Style lllllllllllllIlIllllllllIIllIlII, @NotNull final ComponentLike... lllllllllllllIlIllllllllIIllIIll) {
        return new TranslatableComponentImpl(Collections.emptyList(), lllllllllllllIlIllllllllIIllIlII, lllllllllllllIlIllllllllIIllIIlI, lllllllllllllIlIllllllllIIllIIll);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIllllllllIlllllII, @Nullable final TextColor lllllllllllllIlIllllllllIlllllIl) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIllllllllIlllllII, "translatable").translationKey(), lllllllllllllIlIllllllllIlllllIl);
    }
    
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    default TextComponent text(final boolean lllllllllllllIllIIIIIIIIlIlIlIlI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIlIlIlIlI));
    }
    
    @Contract("_ -> new")
    @NotNull
    default TextComponent text(@NotNull final Consumer<? super TextComponent.Builder> lllllllllllllIllIIIIIIIIllIllIlI) {
        return Buildable.configureAndBuild(text(), lllllllllllllIllIIIIIIIIllIllIlI);
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default KeybindComponent keybind(@NotNull final String lllllllllllllIllIIIIIIIlIlIIIIII, @Nullable final TextColor lllllllllllllIllIIIIIIIlIIllllll, final TextDecoration... lllllllllllllIllIIIIIIIlIIlllllI) {
        return keybind(lllllllllllllIllIIIIIIIlIlIIIIII, Style.style(lllllllllllllIllIIIIIIIlIIllllll, lllllllllllllIllIIIIIIIlIIlllllI));
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default KeybindComponent keybind(@NotNull final String lllllllllllllIllIIIIIIIlIIllIIlI, @Nullable final TextColor lllllllllllllIllIIIIIIIlIIllIlII, @NotNull final Set<TextDecoration> lllllllllllllIllIIIIIIIlIIllIIll) {
        return keybind(lllllllllllllIllIIIIIIIlIIllIIlI, Style.style(lllllllllllllIllIIIIIIIlIIllIlII, lllllllllllllIllIIIIIIIlIIllIIll));
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final long lllllllllllllIlIlllllllllIllIllI, @Nullable final TextColor lllllllllllllIlIlllllllllIlllIII, final TextDecoration... lllllllllllllIlIlllllllllIllIlll) {
        return text(String.valueOf(lllllllllllllIlIlllllllllIllIllI), lllllllllllllIlIlllllllllIlllIII, lllllllllllllIlIlllllllllIllIlll);
    }
    
    @Nullable
    default HoverEvent<?> hoverEvent() {
        return this.style().hoverEvent();
    }
    
    @Contract(pure = true)
    default BlockNBTComponent.Builder blockNBT() {
        return new BlockNBTComponentImpl.BuilderImpl();
    }
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @Contract(pure = true)
    @NotNull
    default Component replaceText(@NotNull final String lllllllllllllIlIllllllIllIlIllII, @Nullable final ComponentLike lllllllllllllIlIllllllIllIlIlIll) {
        return this.replaceText(lllllllllllllIlIllllllIIlllIIllI -> lllllllllllllIlIllllllIIlllIIllI.matchLiteral(lllllllllllllIlIllllllIllIlIllII).replacement(lllllllllllllIlIllllllIllIlIlIll));
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default TextComponent text(final int lllllllllllllIlIlllllllllllllIlI) {
        return text(String.valueOf(lllllllllllllIlIlllllllllllllIlI));
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIllllllllIIIIlllI, @Nullable final TextColor lllllllllllllIlIllllllllIIIlIIII, @NotNull final ComponentLike... lllllllllllllIlIllllllllIIIIllll) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIllllllllIIIIlllI, "translatable").translationKey(), lllllllllllllIlIllllllllIIIlIIII, lllllllllllllIlIllllllllIIIIllll);
    }
    
    default void componentBuilderApply(@NotNull final ComponentBuilder<?, ?> lllllllllllllIlIllllllIlIlIIIlIl) {
        lllllllllllllIlIllllllIlIlIIIlIl.append(this);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIllllllllIlIIIlII, @NotNull final ComponentLike... lllllllllllllIlIllllllllIlIIIlIl) {
        return translatable(lllllllllllllIlIllllllllIlIIIlII, Style.empty(), lllllllllllllIlIllllllllIlIIIlIl);
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default StorageNBTComponent storageNBT(@NotNull final String lllllllllllllIllIIIIIIIIllllllII, @NotNull final Key lllllllllllllIllIIIIIIIIllllllIl) {
        return storageNBT(lllllllllllllIllIIIIIIIIllllllII, false, lllllllllllllIllIIIIIIIIllllllIl);
    }
    
    @Contract(pure = true)
    @NotNull
    default Component decoration(@NotNull final TextDecoration lllllllllllllIlIllllllIllllIlllI, final boolean lllllllllllllIlIllllllIllllIllll) {
        return this.decoration(lllllllllllllIlIllllllIllllIlllI, TextDecoration.State.byBoolean(lllllllllllllIlIllllllIllllIllll));
    }
    
    @Contract(pure = true)
    @NotNull
    Component replaceText(@NotNull final Consumer<TextReplacementConfig.Builder> lllllllllllllIlIllllllIllIllIIIl);
    
    @Deprecated
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default ScoreComponent score(@NotNull final String lllllllllllllIllIIIIIIIlIIIlllII, @NotNull final String lllllllllllllIllIIIIIIIlIIIllIlI, @Nullable final String lllllllllllllIllIIIIIIIlIIIllIll) {
        return new ScoreComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIllIIIIIIIlIIIlllII, lllllllllllllIllIIIIIIIlIIIllIlI, lllllllllllllIllIIIIIIIlIIIllIll);
    }
    
    @NotNull
    default Component append(@NotNull final ComponentLike lllllllllllllIlIlllllllIIlIllIll) {
        return this.append(lllllllllllllIlIlllllllIIlIllIll.asComponent());
    }
    
    @Contract(pure = true)
    default KeybindComponent.Builder keybind() {
        return new KeybindComponentImpl.BuilderImpl();
    }
    
    @NotNull
    @Contract(pure = true)
    default Component style(final Style.Builder lllllllllllllIlIlllllllIIIlllIlI) {
        return this.style(lllllllllllllIlIlllllllIIIlllIlI.build());
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default TextComponent text(final double lllllllllllllIllIIIIIIIIIlIlIIlI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIlIlIIlI));
    }
    
    @Contract(pure = true)
    @NotNull
    default Component color(@Nullable final TextColor lllllllllllllIlIlllllllIIIIlIIll) {
        return this.style(this.style().color(lllllllllllllIlIlllllllIIIIlIIll));
    }
    
    @NotNull
    default HoverEvent<Component> asHoverEvent(@NotNull final UnaryOperator<Component> lllllllllllllIlIllllllIlIIlllIll) {
        return HoverEvent.showText(lllllllllllllIlIllllllIlIIlllIll.apply(this));
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final float lllllllllllllIllIIIIIIIIIIIllIII, @Nullable final TextColor lllllllllllllIllIIIIIIIIIIIllIIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIIllIII), lllllllllllllIllIIIIIIIIIIIllIIl);
    }
    
    @NotNull
    @Contract(value = "_, _, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllIlIIlIIIl, @Nullable final TextColor lllllllllllllIlIlllllllIlIIlIIII, @NotNull final Set<TextDecoration> lllllllllllllIlIlllllllIlIIlIIlI, @NotNull final List<? extends ComponentLike> lllllllllllllIlIlllllllIlIIlIIll) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllIlIIlIIIl, "translatable").translationKey(), lllllllllllllIlIlllllllIlIIlIIII, lllllllllllllIlIlllllllIlIIlIIlI, lllllllllllllIlIlllllllIlIIlIIll);
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final char lllllllllllllIllIIIIIIIIIllllIII, @NotNull final Style lllllllllllllIllIIIIIIIIIllllIIl) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIllllIII), lllllllllllllIllIIIIIIIIIllllIIl);
    }
    
    @NotNull
    @Contract(pure = true)
    default Component mergeStyle(@NotNull final Component lllllllllllllIlIlllllllIIIlIlIlI, final Style.Merge... lllllllllllllIlIlllllllIIIlIlIll) {
        return this.mergeStyle(lllllllllllllIlIlllllllIIIlIlIlI, Style.Merge.of(lllllllllllllIlIlllllllIIIlIlIll));
    }
    
    @Contract(pure = true)
    default TextComponent.Builder text() {
        return new TextComponentImpl.BuilderImpl();
    }
    
    @Deprecated
    @NotNull
    @Contract(pure = true)
    @ApiStatus.ScheduledForRemoval
    default Component replaceText(@NotNull final Pattern lllllllllllllIlIllllllIllIlIIIII, @NotNull final Function<TextComponent.Builder, ComponentLike> lllllllllllllIlIllllllIllIlIIIIl) {
        return this.replaceText(lllllllllllllIlIllllllIIlllIllII -> lllllllllllllIlIllllllIIlllIllII.match(lllllllllllllIlIllllllIllIlIIIII).replacement(lllllllllllllIlIllllllIllIlIIIIl));
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default KeybindComponent keybind(@NotNull final String lllllllllllllIllIIIIIIIlIlIIlIIl, @Nullable final TextColor lllllllllllllIllIIIIIIIlIlIIlIII) {
        return keybind(lllllllllllllIllIIIIIIIlIlIIlIIl, Style.style(lllllllllllllIllIIIIIIIlIlIIlIII));
    }
    
    @NotNull
    default Component asComponent() {
        return this;
    }
    
    @Contract(pure = true)
    default StorageNBTComponent.Builder storageNBT() {
        return new StorageNBTComponentImpl.BuilderImpl();
    }
    
    @Contract(pure = true)
    @NotNull
    default Component clickEvent(@Nullable final ClickEvent lllllllllllllIlIllllllIlllIIllIl) {
        return this.style(this.style().clickEvent(lllllllllllllIlIllllllIlllIIllIl));
    }
    
    @NotNull
    @Contract("_ -> new")
    default BlockNBTComponent blockNBT(@NotNull final Consumer<? super BlockNBTComponent.Builder> lllllllllllllIllIIIIIIIllIlIlIIl) {
        return Buildable.configureAndBuild(blockNBT(), lllllllllllllIllIIIIIIIllIlIlIIl);
    }
    
    @Contract(pure = true)
    @NotNull
    default Component decorate(@NotNull final TextDecoration lllllllllllllIlIllllllIllllllllI) {
        return this.decoration(lllllllllllllIlIllllllIllllllllI, TextDecoration.State.TRUE);
    }
    
    default boolean hasDecoration(@NotNull final TextDecoration lllllllllllllIlIlllllllIIIIIIlIl) {
        return this.decoration(lllllllllllllIlIlllllllIIIIIIlIl) == TextDecoration.State.TRUE;
    }
    
    @Contract(value = "_, _, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final char lllllllllllllIllIIIIIIIIIllIlIII, @Nullable final TextColor lllllllllllllIllIIIIIIIIIllIIlll, final TextDecoration... lllllllllllllIllIIIIIIIIIllIIllI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIllIlIII), lllllllllllllIllIIIIIIIIIllIIlll, lllllllllllllIllIIIIIIIIIllIIllI);
    }
    
    @Contract(pure = true)
    @NotNull
    default Component decoration(@NotNull final TextDecoration lllllllllllllIlIllllllIllllIIlII, final TextDecoration.State lllllllllllllIlIllllllIllllIIIll) {
        return this.style(this.style().decoration(lllllllllllllIlIllllllIllllIIlII, lllllllllllllIlIllllllIllllIIIll));
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final String lllllllllllllIlIlllllllllIIIIlII, @Nullable final TextColor lllllllllllllIlIlllllllllIIIIlIl) {
        return translatable(lllllllllllllIlIlllllllllIIIIlII, Style.style(lllllllllllllIlIlllllllllIIIIlIl));
    }
    
    @Deprecated
    @Contract(pure = true)
    @NotNull
    @ApiStatus.ScheduledForRemoval
    default Component replaceText(@NotNull final String lllllllllllllIlIllllllIlIllllllI, @Nullable final ComponentLike lllllllllllllIlIllllllIlIlllllll, final int lllllllllllllIlIllllllIlIlllllIl) {
        return this.replaceText(lllllllllllllIlIllllllIlIIIIlIll -> lllllllllllllIlIllllllIlIIIIlIll.matchLiteral(lllllllllllllIlIllllllIlIllllllI).times(lllllllllllllIlIllllllIlIlllllIl).replacement(lllllllllllllIlIllllllIlIlllllll));
    }
    
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull
    default TextComponent text(final char lllllllllllllIllIIIIIIIIIlllIIIl, @Nullable final TextColor lllllllllllllIllIIIIIIIIIlllIIII) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIlllIIIl), lllllllllllllIllIIIIIIIIIlllIIII);
    }
    
    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    default BlockNBTComponent blockNBT(@NotNull final String lllllllllllllIllIIIIIIIlIlllIlIl, final boolean lllllllllllllIllIIIIIIIlIllllIIl, @Nullable final ComponentLike lllllllllllllIllIIIIIIIlIlllIlll, final BlockNBTComponent.Pos lllllllllllllIllIIIIIIIlIllllIll) {
        return new BlockNBTComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIllIIIIIIIlIlllIlIl, lllllllllllllIllIIIIIIIlIllllIIl, lllllllllllllIllIIIIIIIlIlllIlll, lllllllllllllIllIIIIIIIlIllllIll);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIllllllllIIlIIllI, @NotNull final Style lllllllllllllIlIllllllllIIlIlIII, @NotNull final ComponentLike... lllllllllllllIlIllllllllIIlIIlll) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIllllllllIIlIIllI, "translatable").translationKey(), lllllllllllllIlIllllllllIIlIlIII, lllllllllllllIlIllllllllIIlIIlll);
    }
    
    @Contract(value = "_, _, _, _ -> new", pure = true)
    @NotNull
    default TranslatableComponent translatable(@NotNull final Translatable lllllllllllllIlIlllllllIllllIIlI, @Nullable final TextColor lllllllllllllIlIlllllllIllllIIIl, @NotNull final Set<TextDecoration> lllllllllllllIlIlllllllIllllIIll, @NotNull final ComponentLike... lllllllllllllIlIlllllllIllllIIII) {
        return translatable(Objects.requireNonNull(lllllllllllllIlIlllllllIllllIIlI, "translatable").translationKey(), lllllllllllllIlIlllllllIllllIIIl, lllllllllllllIlIlllllllIllllIIll, lllllllllllllIlIlllllllIllllIIII);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final long lllllllllllllIlIlllllllllIlIllII, @Nullable final TextColor lllllllllllllIlIlllllllllIlIlIll, @NotNull final Set<TextDecoration> lllllllllllllIlIlllllllllIlIlIlI) {
        return text(String.valueOf(lllllllllllllIlIlllllllllIlIllII), lllllllllllllIlIlllllllllIlIlIll, lllllllllllllIlIlllllllllIlIlIlI);
    }
    
    @NotNull
    @Contract(pure = true)
    default Component hoverEvent(@Nullable final HoverEventSource<?> lllllllllllllIlIllllllIlllIIIIll) {
        return this.style(this.style().hoverEvent(lllllllllllllIlIllllllIlllIIIIll));
    }
    
    @NotNull
    @Contract(pure = true)
    Component replaceText(@NotNull final TextReplacementConfig lllllllllllllIlIllllllIllIllIIII);
    
    @Contract(pure = true)
    @NotNull
    default Component mergeStyle(@NotNull final Component lllllllllllllIlIlllllllIIIllIIll) {
        return this.mergeStyle(lllllllllllllIlIlllllllIIIllIIll, Style.Merge.all());
    }
    
    @Deprecated
    @Contract(pure = true)
    @NotNull
    @ApiStatus.ScheduledForRemoval
    default Component replaceText(@NotNull final Pattern lllllllllllllIlIllllllIlIlIlIIlI, @NotNull final Function<TextComponent.Builder, ComponentLike> lllllllllllllIlIllllllIlIlIlIIII, @NotNull final IntFunction2<PatternReplacementResult> lllllllllllllIlIllllllIlIlIlIIIl) {
        return this.replaceText(lllllllllllllIlIllllllIlIIlIlIll -> lllllllllllllIlIllllllIlIIlIlIll.match(lllllllllllllIlIllllllIlIlIlIIlI).replacement(lllllllllllllIlIllllllIlIlIlIIII).condition(lllllllllllllIlIllllllIlIlIlIIIl));
    }
    
    @NotNull
    default TextComponent space() {
        return TextComponentImpl.SPACE;
    }
    
    default boolean contains(@NotNull final Component lllllllllllllIlIlllllllIlIIIIlII) {
        return this.contains(lllllllllllllIlIlllllllIlIIIIlII, Component.EQUALS_IDENTITY);
    }
    
    @NotNull
    @Contract(value = "_, _ -> new", pure = true)
    default TextComponent text(final int lllllllllllllIlIllllllllllllIlIl, @NotNull final Style lllllllllllllIlIllllllllllllIlII) {
        return text(String.valueOf(lllllllllllllIlIllllllllllllIlIl), lllllllllllllIlIllllllllllllIlII);
    }
    
    @NotNull
    @Contract(value = "_, _, _ -> new", pure = true)
    default TextComponent text(final float lllllllllllllIllIIIIIIIIIIIIllll, @Nullable final TextColor lllllllllllllIllIIIIIIIIIIIlIIII, final TextDecoration... lllllllllllllIllIIIIIIIIIIIIlllI) {
        return text(String.valueOf(lllllllllllllIllIIIIIIIIIIIIllll), lllllllllllllIllIIIIIIIIIIIlIIII, lllllllllllllIllIIIIIIIIIIIIlllI);
    }
}
