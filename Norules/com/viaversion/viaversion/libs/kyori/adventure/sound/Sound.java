package com.viaversion.viaversion.libs.kyori.adventure.sound;

import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;

@ApiStatus.NonExtendable
public interface Sound extends Examinable
{
    @NotNull
    default Sound sound(@NotNull final Type lllllllllllllllIIllIlIllllIlllll, final Source.Provider lllllllllllllllIIllIlIllllIlllIl, final float lllllllllllllllIIllIlIlllllIIIII, final float lllllllllllllllIIllIlIllllIllllI) {
        return sound(lllllllllllllllIIllIlIllllIlllll, lllllllllllllllIIllIlIllllIlllIl.soundSource(), lllllllllllllllIIllIlIlllllIIIII, lllllllllllllllIIllIlIllllIllllI);
    }
    
    @NotNull
    default Sound sound(@NotNull final Type lllllllllllllllIIllIllIIIIIIllIl, @NotNull final Source lllllllllllllllIIllIllIIIIIIllll, final float lllllllllllllllIIllIllIIIIIlIIII, final float lllllllllllllllIIllIllIIIIIIlllI) {
        Objects.requireNonNull(lllllllllllllllIIllIllIIIIIIllIl, "type");
        return sound(lllllllllllllllIIllIllIIIIIIllIl.key(), lllllllllllllllIIllIllIIIIIIllll, lllllllllllllllIIllIllIIIIIlIIII, lllllllllllllllIIllIllIIIIIIlllI);
    }
    
    @NotNull
    SoundStop asStop();
    
    float pitch();
    
    @NotNull
    default Sound sound(@NotNull final Key lllllllllllllllIIllIlIllllllIIII, final Source.Provider lllllllllllllllIIllIlIlllllIllIl, final float lllllllllllllllIIllIlIlllllIlllI, final float lllllllllllllllIIllIlIlllllIllll) {
        return sound(lllllllllllllllIIllIlIllllllIIII, lllllllllllllllIIllIlIlllllIllIl.soundSource(), lllllllllllllllIIllIlIlllllIlllI, lllllllllllllllIIllIlIlllllIllll);
    }
    
    @NotNull
    Key name();
    
    @NotNull
    default Sound sound(@NotNull final Supplier<? extends Type> lllllllllllllllIIllIlIllllIIllll, final Source.Provider lllllllllllllllIIllIlIllllIlIIII, final float lllllllllllllllIIllIlIllllIIlllI, final float lllllllllllllllIIllIlIllllIIllIl) {
        return sound(lllllllllllllllIIllIlIllllIIllll, lllllllllllllllIIllIlIllllIlIIII.soundSource(), lllllllllllllllIIllIlIllllIIlllI, lllllllllllllllIIllIlIllllIIllIl);
    }
    
    @NotNull
    Source source();
    
    @NotNull
    default Sound sound(@NotNull final Supplier<? extends Type> lllllllllllllllIIllIlIllllllllll, @NotNull final Source lllllllllllllllIIllIlIllllllllIl, final float lllllllllllllllIIllIllIIIIIIIIII, final float lllllllllllllllIIllIlIlllllllllI) {
        Objects.requireNonNull(lllllllllllllllIIllIlIllllllllll, "type");
        Objects.requireNonNull(lllllllllllllllIIllIlIllllllllIl, "source");
        return new SoundImpl(lllllllllllllllIIllIlIllllllllIl, lllllllllllllllIIllIllIIIIIIIIII, lllllllllllllllIIllIlIlllllllllI) {
            @NotNull
            @Override
            public Key name() {
                return lllllllllllllllIIllIlIllllllllll.get().key();
            }
        };
    }
    
    @NotNull
    default Sound sound(@NotNull final Key lllllllllllllllIIllIllIIIIlIIIII, @NotNull final Source lllllllllllllllIIllIllIIIIIllllI, final float lllllllllllllllIIllIllIIIIIlllll, final float lllllllllllllllIIllIllIIIIIlllIl) {
        Objects.requireNonNull(lllllllllllllllIIllIllIIIIlIIIII, "name");
        Objects.requireNonNull(lllllllllllllllIIllIllIIIIIllllI, "source");
        return new SoundImpl(lllllllllllllllIIllIllIIIIIllllI, lllllllllllllllIIllIllIIIIIlllll, lllllllllllllllIIllIllIIIIIlllIl) {
            @NotNull
            @Override
            public Key name() {
                return lllllllllllllllIIllIllIIIIlIIIII;
            }
        };
    }
    
    float volume();
    
    public enum Source
    {
        MASTER("master"), 
        RECORD("record"), 
        AMBIENT("ambient"), 
        WEATHER("weather");
        
        private final /* synthetic */ String name;
        
        NEUTRAL("neutral"), 
        BLOCK("block"), 
        VOICE("voice"), 
        MUSIC("music"), 
        PLAYER("player"), 
        HOSTILE("hostile");
        
        private static /* synthetic */ Source[] $values() {
            return new Source[] { Source.MASTER, Source.MUSIC, Source.RECORD, Source.WEATHER, Source.BLOCK, Source.HOSTILE, Source.NEUTRAL, Source.PLAYER, Source.AMBIENT, Source.VOICE };
        }
        
        static {
            $VALUES = $values();
            NAMES = Index.create(Source.class, llllIIlIllIlII -> llllIIlIllIlII.name);
        }
        
        private Source(final String llllIIlIllllIl) {
            this.name = llllIIlIllllIl;
        }
        
        public interface Provider
        {
            @NotNull
            Source soundSource();
        }
    }
    
    public interface Emitter
    {
        @NotNull
        default Emitter self() {
            return SoundImpl.EMITTER_SELF;
        }
    }
    
    public interface Type extends Keyed
    {
        @NotNull
        Key key();
    }
}
