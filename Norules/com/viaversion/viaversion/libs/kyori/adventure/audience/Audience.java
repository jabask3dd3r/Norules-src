package com.viaversion.viaversion.libs.kyori.adventure.audience;

import com.viaversion.viaversion.libs.kyori.adventure.pointer.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.inventory.*;
import com.viaversion.viaversion.libs.kyori.adventure.identity.*;
import com.viaversion.viaversion.libs.kyori.adventure.sound.*;
import com.viaversion.viaversion.libs.kyori.adventure.bossbar.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.title.*;
import java.util.stream.*;

public interface Audience extends Pointered
{
    @ForwardingAudienceOverrideNotRequired
    default void sendPlayerListHeaderAndFooter(@NotNull final ComponentLike llllllllllllllIIIlllIlIIIIlIlIlI, @NotNull final ComponentLike llllllllllllllIIIlllIlIIIIlIlIIl) {
        this.sendPlayerListHeaderAndFooter(llllllllllllllIIIlllIlIIIIlIlIlI.asComponent(), llllllllllllllIIIlllIlIIIIlIlIIl.asComponent());
    }
    
    default void stopSound(@NotNull final SoundStop llllllllllllllIIIlllIIlllllllIlI) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Component llllllllllllllIIIlllIlIIlIlllIII) {
        this.sendMessage(Identity.nil(), llllllllllllllIIIlllIlIIlIlllIII);
    }
    
    default void resetTitle() {
    }
    
    default void openBook(@NotNull final Book llllllllllllllIIIlllIIllllllIIII) {
    }
    
    default void clearTitle() {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Identified llllllllllllllIIIlllIlIIlIllIIII, @NotNull final Component llllllllllllllIIIlllIlIIlIlIllll) {
        this.sendMessage(llllllllllllllIIIlllIlIIlIllIIII, llllllllllllllIIIlllIlIIlIlIllll, MessageType.SYSTEM);
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Component llllllllllllllIIIlllIlIIIlllIIIl, @NotNull final MessageType llllllllllllllIIIlllIlIIIlllIIII) {
        this.sendMessage(Identity.nil(), llllllllllllllIIIlllIlIIIlllIIIl, llllllllllllllIIIlllIlIIIlllIIII);
    }
    
    default void playSound(@NotNull final Sound llllllllllllllIIIlllIIllllllllll, final Sound.Emitter llllllllllllllIIIlllIIlllllllllI) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendPlayerListFooter(@NotNull final ComponentLike llllllllllllllIIIlllIlIIIIlllIIl) {
        this.sendPlayerListFooter(llllllllllllllIIIlllIlIIIIlllIIl.asComponent());
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final ComponentLike llllllllllllllIIIlllIlIIllIlIlIl) {
        this.sendMessage(Identity.nil(), llllllllllllllIIIlllIlIIllIlIlIl);
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendPlayerListHeader(@NotNull final ComponentLike llllllllllllllIIIlllIlIIIlIIIlll) {
        this.sendPlayerListHeader(llllllllllllllIIIlllIlIIIlIIIlll.asComponent());
    }
    
    default void sendMessage(@NotNull final Identity llllllllllllllIIIlllIlIIIlIllIIl, @NotNull final Component llllllllllllllIIIlllIlIIIlIllIlI, @NotNull final MessageType llllllllllllllIIIlllIlIIIlIllIII) {
    }
    
    default void sendActionBar(@NotNull final Component llllllllllllllIIIlllIlIIIlIIllII) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Identified llllllllllllllIIIlllIlIIllIIllII, @NotNull final ComponentLike llllllllllllllIIIlllIlIIllIIllIl) {
        this.sendMessage(llllllllllllllIIIlllIlIIllIIllII, llllllllllllllIIIlllIlIIllIIllIl.asComponent());
    }
    
    default void sendPlayerListHeaderAndFooter(@NotNull final Component llllllllllllllIIIlllIlIIIIlIIIIl, @NotNull final Component llllllllllllllIIIlllIlIIIIlIIIlI) {
    }
    
    @NotNull
    default Audience audience(@NotNull final Audience... llllllllllllllIIIlllIlIIlllIIIII) {
        final int llllllllllllllIIIlllIlIIllIllllI = llllllllllllllIIIlllIlIIlllIIIII.length;
        if (llllllllllllllIIIlllIlIIllIllllI == 0) {
            return empty();
        }
        if (llllllllllllllIIIlllIlIIllIllllI == 1) {
            return llllllllllllllIIIlllIlIIlllIIIII[0];
        }
        return audience(Arrays.asList(llllllllllllllIIIlllIlIIlllIIIII));
    }
    
    @NotNull
    default ForwardingAudience audience(@NotNull final Iterable<? extends Audience> llllllllllllllIIIlllIlIIllIllIlI) {
        return () -> llllllllllllllIIIlllIlIIllIllIlI;
    }
    
    default void hideBossBar(@NotNull final BossBar llllllllllllllIIIlllIlIIIIIlIlIl) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void stopSound(@NotNull final Sound llllllllllllllIIIlllIlIIIIIIIlII) {
        this.stopSound(Objects.requireNonNull(llllllllllllllIIIlllIlIIIIIIIlII, "sound").asStop());
    }
    
    default void playSound(@NotNull final Sound llllllllllllllIIIlllIlIIIIIlIIlI) {
    }
    
    default void showBossBar(@NotNull final BossBar llllllllllllllIIIlllIlIIIIIllIII) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final ComponentLike llllllllllllllIIIlllIlIIlIIllIlI, @NotNull final MessageType llllllllllllllIIIlllIlIIlIIllIIl) {
        this.sendMessage(Identity.nil(), llllllllllllllIIIlllIlIIlIIllIlI, llllllllllllllIIIlllIlIIlIIllIIl);
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void openBook(final Book.Builder llllllllllllllIIIlllIIllllllIlIl) {
        this.openBook(llllllllllllllIIIlllIIllllllIlIl.build());
    }
    
    default void sendPlayerListFooter(@NotNull final Component llllllllllllllIIIlllIlIIIIllIIlI) {
        this.sendPlayerListHeaderAndFooter(Component.empty(), llllllllllllllIIIlllIlIIIIllIIlI);
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Identity llllllllllllllIIIlllIlIIlIlIIlII, @NotNull final Component llllllllllllllIIIlllIlIIlIlIIlIl) {
        this.sendMessage(llllllllllllllIIIlllIlIIlIlIIlII, llllllllllllllIIIlllIlIIlIlIIlIl, MessageType.SYSTEM);
    }
    
    default void sendPlayerListHeader(@NotNull final Component llllllllllllllIIIlllIlIIIlIIIIII) {
        this.sendPlayerListHeaderAndFooter(llllllllllllllIIIlllIlIIIlIIIIII, Component.empty());
    }
    
    default void showTitle(@NotNull final Title llllllllllllllIIIlllIlIIIIIlllIl) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Identity llllllllllllllIIIlllIlIIllIIIIlI, @NotNull final ComponentLike llllllllllllllIIIlllIlIIllIIIIIl) {
        this.sendMessage(llllllllllllllIIIlllIlIIllIIIIlI, llllllllllllllIIIlllIlIIllIIIIIl.asComponent());
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Identified llllllllllllllIIIlllIlIIlIIIlllI, @NotNull final ComponentLike llllllllllllllIIIlllIlIIlIIIllII, @NotNull final MessageType llllllllllllllIIIlllIlIIlIIIllIl) {
        this.sendMessage(llllllllllllllIIIlllIlIIlIIIlllI, llllllllllllllIIIlllIlIIlIIIllII.asComponent(), llllllllllllllIIIlllIlIIlIIIllIl);
    }
    
    @NotNull
    default Collector<? super Audience, ?, ForwardingAudience> toAudience() {
        return Audiences.COLLECTOR;
    }
    
    default void playSound(@NotNull final Sound llllllllllllllIIIlllIlIIIIIIlllI, final double llllllllllllllIIIlllIlIIIIIIllII, final double llllllllllllllIIIlllIlIIIIIIllIl, final double llllllllllllllIIIlllIlIIIIIIllll) {
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendMessage(@NotNull final Identity llllllllllllllIIIlllIlIIIlllllIl, @NotNull final ComponentLike llllllllllllllIIIlllIlIIIllllllI, @NotNull final MessageType llllllllllllllIIIlllIlIIIlllllll) {
        this.sendMessage(llllllllllllllIIIlllIlIIIlllllIl, llllllllllllllIIIlllIlIIIllllllI.asComponent(), llllllllllllllIIIlllIlIIIlllllll);
    }
    
    @NotNull
    default Audience empty() {
        return EmptyAudience.INSTANCE;
    }
    
    @ForwardingAudienceOverrideNotRequired
    default void sendActionBar(@NotNull final ComponentLike llllllllllllllIIIlllIlIIIlIlIIIl) {
        this.sendActionBar(llllllllllllllIIIlllIlIIIlIlIIIl.asComponent());
    }
    
    default void sendMessage(@NotNull final Identified llllllllllllllIIIlllIlIIIllIIIll, @NotNull final Component llllllllllllllIIIlllIlIIIllIIlIl, @NotNull final MessageType llllllllllllllIIIlllIlIIIllIIlII) {
        this.sendMessage(llllllllllllllIIIlllIlIIIllIIIll.identity(), llllllllllllllIIIlllIlIIIllIIlIl, llllllllllllllIIIlllIlIIIllIIlII);
    }
}
