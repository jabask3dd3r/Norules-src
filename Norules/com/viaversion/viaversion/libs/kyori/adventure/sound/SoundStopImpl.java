package com.viaversion.viaversion.libs.kyori.adventure.sound;

import java.util.*;
import java.util.stream.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import com.viaversion.viaversion.libs.kyori.adventure.key.*;

abstract class SoundStopImpl implements SoundStop
{
    private final /* synthetic */ Sound.Source source;
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIlIIIIIIIlIIlllIIIl) {
        if (this == lllllllllllllIlIIIIIIIlIIlllIIIl) {
            return true;
        }
        if (!(lllllllllllllIlIIIIIIIlIIlllIIIl instanceof SoundStopImpl)) {
            return false;
        }
        final SoundStopImpl lllllllllllllIlIIIIIIIlIIllIlllI = (SoundStopImpl)lllllllllllllIlIIIIIIIlIIlllIIIl;
        return Objects.equals(this.sound(), lllllllllllllIlIIIIIIIlIIllIlllI.sound()) && Objects.equals(this.source, lllllllllllllIlIIIIIIIlIIllIlllI.source);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIIIIIIIlIIllIIlll = Objects.hashCode(this.sound());
        lllllllllllllIlIIIIIIIlIIllIIlll = 31 * lllllllllllllIlIIIIIIIlIIllIIlll + Objects.hashCode(this.source);
        return lllllllllllllIlIIIIIIIlIIllIIlll;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("name", this.sound()), ExaminableProperty.of("source", this.source) });
    }
    
    @Override
    public Sound.Source source() {
        return this.source;
    }
    
    SoundStopImpl(final Sound.Source lllllllllllllIlIIIIIIIlIIlllllII) {
        this.source = lllllllllllllIlIIIIIIIlIIlllllII;
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    static {
        ALL = new SoundStopImpl() {
            @Nullable
            @Override
            public Key sound() {
                return null;
            }
        };
    }
}
