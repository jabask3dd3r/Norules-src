package com.viaversion.viaversion.libs.kyori.adventure.sound;

import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.function.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;
import org.jetbrains.annotations.*;

@ApiStatus.NonExtendable
public interface SoundStop extends Examinable
{
    @NotNull
    default SoundStop namedOnSource(@NotNull final Supplier<? extends Sound.Type> lllllllllllllIllIIlIIIIllllIlllI, final Sound.Source lllllllllllllIllIIlIIIIllllIllll) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIIllllIlllI, "sound");
        Objects.requireNonNull(lllllllllllllIllIIlIIIIllllIllll, "source");
        return new SoundStopImpl(lllllllllllllIllIIlIIIIllllIllll) {
            @NotNull
            @Override
            public Key sound() {
                return lllllllllllllIllIIlIIIIllllIlllI.get().key();
            }
        };
    }
    
    @NotNull
    default SoundStop namedOnSource(@NotNull final Key lllllllllllllIllIIlIIIIllllllllI, final Sound.Source lllllllllllllIllIIlIIIIlllllllll) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIIllllllllI, "sound");
        Objects.requireNonNull(lllllllllllllIllIIlIIIIlllllllll, "source");
        return new SoundStopImpl(lllllllllllllIllIIlIIIIlllllllll) {
            @NotNull
            @Override
            public Key sound() {
                return lllllllllllllIllIIlIIIIllllllllI;
            }
        };
    }
    
    @NotNull
    default SoundStop named(final Sound.Type lllllllllllllIllIIlIIIlIIIIIllII) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIlIIIIIllII, "sound");
        return new SoundStopImpl(null) {
            @NotNull
            @Override
            public Key sound() {
                return lllllllllllllIllIIlIIIlIIIIIllII.key();
            }
        };
    }
    
    Sound.Source source();
    
    @NotNull
    default SoundStop named(@NotNull final Supplier<? extends Sound.Type> lllllllllllllIllIIlIIIlIIIIIlIII) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIlIIIIIlIII, "sound");
        return new SoundStopImpl(null) {
            @NotNull
            @Override
            public Key sound() {
                return lllllllllllllIllIIlIIIlIIIIIlIII.get().key();
            }
        };
    }
    
    @NotNull
    default SoundStop namedOnSource(final Sound.Type lllllllllllllIllIIlIIIIlllllIllI, final Sound.Source lllllllllllllIllIIlIIIIlllllIlll) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIIlllllIllI, "sound");
        return namedOnSource(lllllllllllllIllIIlIIIIlllllIllI.key(), lllllllllllllIllIIlIIIIlllllIlll);
    }
    
    @Nullable
    Key sound();
    
    @NotNull
    default SoundStop all() {
        return SoundStopImpl.ALL;
    }
    
    @NotNull
    default SoundStop source(final Sound.Source lllllllllllllIllIIlIIIlIIIIIIlII) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIlIIIIIIlII, "source");
        return new SoundStopImpl(lllllllllllllIllIIlIIIlIIIIIIlII) {
            @Nullable
            @Override
            public Key sound() {
                return null;
            }
        };
    }
    
    @NotNull
    default SoundStop named(@NotNull final Key lllllllllllllIllIIlIIIlIIIIlIIII) {
        Objects.requireNonNull(lllllllllllllIllIIlIIIlIIIIlIIII, "sound");
        return new SoundStopImpl(null) {
            @NotNull
            @Override
            public Key sound() {
                return lllllllllllllIllIIlIIIlIIIIlIIII;
            }
        };
    }
}
