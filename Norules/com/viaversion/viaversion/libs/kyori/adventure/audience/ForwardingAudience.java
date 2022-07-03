package com.viaversion.viaversion.libs.kyori.adventure.audience;

import com.viaversion.viaversion.libs.kyori.adventure.pointer.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.bossbar.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.sound.*;
import com.viaversion.viaversion.libs.kyori.adventure.inventory.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.title.*;
import com.viaversion.viaversion.libs.kyori.adventure.identity.*;
import java.util.*;

@FunctionalInterface
public interface ForwardingAudience extends Audience
{
    @ApiStatus.OverrideOnly
    @NotNull
    Iterable<? extends Audience> audiences();
    
    @Contract("_, null -> null; _, !null -> !null")
    @Nullable
    default <T> T getOrDefault(@NotNull final Pointer<T> lllllllllllllllIllIIlIllIllIlIlI, @Nullable final T lllllllllllllllIllIIlIllIllIllII) {
        return lllllllllllllllIllIIlIllIllIllII;
    }
    
    default void playSound(@NotNull final Sound lllllllllllllllIllIIlIlIllIIIIll) {
        for (final Audience lllllllllllllllIllIIlIlIllIIIIlI : this.audiences()) {
            lllllllllllllllIllIIlIlIllIIIIlI.playSound(lllllllllllllllIllIIlIlIllIIIIll);
        }
    }
    
    default void showBossBar(@NotNull final BossBar lllllllllllllllIllIIlIlIllIllIll) {
        for (final Audience lllllllllllllllIllIIlIlIllIllIlI : this.audiences()) {
            lllllllllllllllIllIIlIlIllIllIlI.showBossBar(lllllllllllllllIllIIlIlIllIllIll);
        }
    }
    
    default void sendPlayerListFooter(@NotNull final Component lllllllllllllllIllIIlIllIIIlIIll) {
        for (final Audience lllllllllllllllIllIIlIllIIIlIIlI : this.audiences()) {
            lllllllllllllllIllIIlIllIIIlIIlI.sendPlayerListFooter(lllllllllllllllIllIIlIllIIIlIIll);
        }
    }
    
    default void playSound(@NotNull final Sound lllllllllllllllIllIIlIlIlIllIIll, final double lllllllllllllllIllIIlIlIlIllIlII, final double lllllllllllllllIllIIlIlIlIllIIlI, final double lllllllllllllllIllIIlIlIlIllIIIl) {
        for (final Audience lllllllllllllllIllIIlIlIlIllIIII : this.audiences()) {
            lllllllllllllllIllIIlIlIlIllIIII.playSound(lllllllllllllllIllIIlIlIlIllIIll, lllllllllllllllIllIIlIlIlIllIlII, lllllllllllllllIllIIlIlIlIllIIlI, lllllllllllllllIllIIlIlIlIllIIIl);
        }
    }
    
    default void stopSound(@NotNull final SoundStop lllllllllllllllIllIIlIlIlIIIllll) {
        for (final Audience lllllllllllllllIllIIlIlIlIIIlllI : this.audiences()) {
            lllllllllllllllIllIIlIlIlIIIlllI.stopSound(lllllllllllllllIllIIlIlIlIIIllll);
        }
    }
    
    default void hideBossBar(@NotNull final BossBar lllllllllllllllIllIIlIlIllIIllll) {
        for (final Audience lllllllllllllllIllIIlIlIllIIlllI : this.audiences()) {
            lllllllllllllllIllIIlIlIllIIlllI.hideBossBar(lllllllllllllllIllIIlIlIllIIllll);
        }
    }
    
    default void sendActionBar(@NotNull final Component lllllllllllllllIllIIlIllIIlIlIll) {
        for (final Audience lllllllllllllllIllIIlIllIIlIlIlI : this.audiences()) {
            lllllllllllllllIllIIlIllIIlIlIlI.sendActionBar(lllllllllllllllIllIIlIllIIlIlIll);
        }
    }
    
    default void sendPlayerListHeaderAndFooter(@NotNull final Component lllllllllllllllIllIIlIllIIIIIllI, @NotNull final Component lllllllllllllllIllIIlIllIIIIIlIl) {
        for (final Audience lllllllllllllllIllIIlIllIIIIIlII : this.audiences()) {
            lllllllllllllllIllIIlIllIIIIIlII.sendPlayerListHeaderAndFooter(lllllllllllllllIllIIlIllIIIIIllI, lllllllllllllllIllIIlIllIIIIIlIl);
        }
    }
    
    default void playSound(@NotNull final Sound lllllllllllllllIllIIlIlIlIIllllI, final Sound.Emitter lllllllllllllllIllIIlIlIlIIlllIl) {
        for (final Audience lllllllllllllllIllIIlIlIlIIlllII : this.audiences()) {
            lllllllllllllllIllIIlIlIlIIlllII.playSound(lllllllllllllllIllIIlIlIlIIllllI, lllllllllllllllIllIIlIlIlIIlllIl);
        }
    }
    
    default void resetTitle() {
        for (final Audience lllllllllllllllIllIIlIlIlllIIlII : this.audiences()) {
            lllllllllllllllIllIIlIlIlllIIlII.resetTitle();
        }
    }
    
    default void openBook(@NotNull final Book lllllllllllllllIllIIlIlIlIIIIIll) {
        for (final Audience lllllllllllllllIllIIlIlIlIIIIIlI : this.audiences()) {
            lllllllllllllllIllIIlIlIlIIIIIlI.openBook(lllllllllllllllIllIIlIlIlIIIIIll);
        }
    }
    
    default void sendPlayerListHeader(@NotNull final Component lllllllllllllllIllIIlIllIIIlllll) {
        for (final Audience lllllllllllllllIllIIlIllIIIllllI : this.audiences()) {
            lllllllllllllllIllIIlIllIIIllllI.sendPlayerListHeader(lllllllllllllllIllIIlIllIIIlllll);
        }
    }
    
    default <T> T getOrDefaultFrom(@NotNull final Pointer<T> lllllllllllllllIllIIlIllIlIllllI, @NotNull final Supplier<? extends T> lllllllllllllllIllIIlIllIllIIIII) {
        return (T)lllllllllllllllIllIIlIllIllIIIII.get();
    }
    
    default void sendMessage(@NotNull final Identified lllllllllllllllIllIIlIllIlIlIIIl, @NotNull final Component lllllllllllllllIllIIlIllIlIIllll, @NotNull final MessageType lllllllllllllllIllIIlIllIlIlIIII) {
        for (final Audience lllllllllllllllIllIIlIllIlIIlllI : this.audiences()) {
            lllllllllllllllIllIIlIllIlIIlllI.sendMessage(lllllllllllllllIllIIlIllIlIlIIIl, lllllllllllllllIllIIlIllIlIIllll, lllllllllllllllIllIIlIllIlIlIIII);
        }
    }
    
    default void showTitle(@NotNull final Title lllllllllllllllIllIIlIlIllllIlll) {
        for (final Audience lllllllllllllllIllIIlIlIllllIllI : this.audiences()) {
            lllllllllllllllIllIIlIlIllllIllI.showTitle(lllllllllllllllIllIIlIlIllllIlll);
        }
    }
    
    default void clearTitle() {
        for (final Audience lllllllllllllllIllIIlIlIlllIllII : this.audiences()) {
            lllllllllllllllIllIIlIlIlllIllII.clearTitle();
        }
    }
    
    @NotNull
    default <T> Optional<T> get(@NotNull final Pointer<T> lllllllllllllllIllIIlIllIlllIIIl) {
        return Optional.empty();
    }
    
    default void sendMessage(@NotNull final Identity lllllllllllllllIllIIlIllIIllllIl, @NotNull final Component lllllllllllllllIllIIlIllIIlllIll, @NotNull final MessageType lllllllllllllllIllIIlIllIIllllII) {
        for (final Audience lllllllllllllllIllIIlIllIIlllIlI : this.audiences()) {
            lllllllllllllllIllIIlIllIIlllIlI.sendMessage(lllllllllllllllIllIIlIllIIllllIl, lllllllllllllllIllIIlIllIIlllIll, lllllllllllllllIllIIlIllIIllllII);
        }
    }
    
    public interface Single extends ForwardingAudience
    {
        default void openBook(@NotNull final Book lllllllllllllIIllllIIIIIlllIIIlI) {
            this.audience().openBook(lllllllllllllIIllllIIIIIlllIIIlI);
        }
        
        @NotNull
        default <T> Optional<T> get(@NotNull final Pointer<T> lllllllllllllIIllllIIIIllIIIIlII) {
            return this.audience().get(lllllllllllllIIllllIIIIllIIIIlII);
        }
        
        default void sendPlayerListFooter(@NotNull final Component lllllllllllllIIllllIIIIlIIlllIll) {
            this.audience().sendPlayerListFooter(lllllllllllllIIllllIIIIlIIlllIll);
        }
        
        default void resetTitle() {
            this.audience().resetTitle();
        }
        
        default void sendMessage(@NotNull final Identified lllllllllllllIIllllIIIIlIllIIlII, @NotNull final Component lllllllllllllIIllllIIIIlIllIIIll, @NotNull final MessageType lllllllllllllIIllllIIIIlIllIIlIl) {
            this.audience().sendMessage(lllllllllllllIIllllIIIIlIllIIlII, lllllllllllllIIllllIIIIlIllIIIll, lllllllllllllIIllllIIIIlIllIIlIl);
        }
        
        @ApiStatus.OverrideOnly
        @NotNull
        Audience audience();
        
        @Contract("_, null -> null; _, !null -> !null")
        @Nullable
        default <T> T getOrDefault(@NotNull final Pointer<T> lllllllllllllIIllllIIIIlIllllIll, @Nullable final T lllllllllllllIIllllIIIIlIlllllII) {
            return this.audience().getOrDefault(lllllllllllllIIllllIIIIlIllllIll, lllllllllllllIIllllIIIIlIlllllII);
        }
        
        default <T> T getOrDefaultFrom(@NotNull final Pointer<T> lllllllllllllIIllllIIIIlIlllIIII, @NotNull final Supplier<? extends T> lllllllllllllIIllllIIIIlIlllIIIl) {
            return this.audience().getOrDefaultFrom(lllllllllllllIIllllIIIIlIlllIIII, lllllllllllllIIllllIIIIlIlllIIIl);
        }
        
        default void hideBossBar(@NotNull final BossBar lllllllllllllIIllllIIIIlIIIlIlIl) {
            this.audience().hideBossBar(lllllllllllllIIllllIIIIlIIIlIlIl);
        }
        
        default void playSound(@NotNull final Sound lllllllllllllIIllllIIIIIllllIIlI, final Sound.Emitter lllllllllllllIIllllIIIIIllllIIll) {
            this.audience().playSound(lllllllllllllIIllllIIIIIllllIIlI, lllllllllllllIIllllIIIIIllllIIll);
        }
        
        @Deprecated
        @NotNull
        default Iterable<? extends Audience> audiences() {
            return Collections.singleton(this.audience());
        }
        
        default void stopSound(@NotNull final SoundStop lllllllllllllIIllllIIIIIlllIlIIl) {
            this.audience().stopSound(lllllllllllllIIllllIIIIIlllIlIIl);
        }
        
        default void sendPlayerListHeader(@NotNull final Component lllllllllllllIIllllIIIIlIlIIIIlI) {
            this.audience().sendPlayerListHeader(lllllllllllllIIllllIIIIlIlIIIIlI);
        }
        
        default void playSound(@NotNull final Sound lllllllllllllIIllllIIIIlIIIIlllI) {
            this.audience().playSound(lllllllllllllIIllllIIIIlIIIIlllI);
        }
        
        default void clearTitle() {
            this.audience().clearTitle();
        }
        
        default void showTitle(@NotNull final Title lllllllllllllIIllllIIIIlIIlIlIIl) {
            this.audience().showTitle(lllllllllllllIIllllIIIIlIIlIlIIl);
        }
        
        default void showBossBar(@NotNull final BossBar lllllllllllllIIllllIIIIlIIIlllII) {
            this.audience().showBossBar(lllllllllllllIIllllIIIIlIIIlllII);
        }
        
        default void sendActionBar(@NotNull final Component lllllllllllllIIllllIIIIlIlIIlIIl) {
            this.audience().sendActionBar(lllllllllllllIIllllIIIIlIlIIlIIl);
        }
        
        default void playSound(@NotNull final Sound lllllllllllllIIllllIIIIlIIIIIIIl, final double lllllllllllllIIllllIIIIlIIIIIIll, final double lllllllllllllIIllllIIIIlIIIIIlII, final double lllllllllllllIIllllIIIIlIIIIIIlI) {
            this.audience().playSound(lllllllllllllIIllllIIIIlIIIIIIIl, lllllllllllllIIllllIIIIlIIIIIIll, lllllllllllllIIllllIIIIlIIIIIlII, lllllllllllllIIllllIIIIlIIIIIIlI);
        }
        
        default void sendPlayerListHeaderAndFooter(@NotNull final Component lllllllllllllIIllllIIIIlIIllIIlI, @NotNull final Component lllllllllllllIIllllIIIIlIIllIIll) {
            this.audience().sendPlayerListHeaderAndFooter(lllllllllllllIIllllIIIIlIIllIIlI, lllllllllllllIIllllIIIIlIIllIIll);
        }
        
        default void sendMessage(@NotNull final Identity lllllllllllllIIllllIIIIlIlIlIlII, @NotNull final Component lllllllllllllIIllllIIIIlIlIlIlIl, @NotNull final MessageType lllllllllllllIIllllIIIIlIlIlIllI) {
            this.audience().sendMessage(lllllllllllllIIllllIIIIlIlIlIlII, lllllllllllllIIllllIIIIlIlIlIlIl, lllllllllllllIIllllIIIIlIlIlIllI);
        }
    }
}
