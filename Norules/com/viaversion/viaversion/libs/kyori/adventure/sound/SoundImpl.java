package com.viaversion.viaversion.libs.kyori.adventure.sound;

import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

abstract class SoundImpl implements Sound
{
    private /* synthetic */ SoundStop stop;
    private final /* synthetic */ float pitch;
    private final /* synthetic */ float volume;
    private final /* synthetic */ Source source;
    
    @Override
    public int hashCode() {
        int lllllllllllllllIIlIIlllIlllIIIIl = this.name().hashCode();
        lllllllllllllllIIlIIlllIlllIIIIl = 31 * lllllllllllllllIIlIIlllIlllIIIIl + this.source.hashCode();
        lllllllllllllllIIlIIlllIlllIIIIl = 31 * lllllllllllllllIIlIIlllIlllIIIIl + Float.hashCode(this.volume);
        lllllllllllllllIIlIIlllIlllIIIIl = 31 * lllllllllllllllIIlIIlllIlllIIIIl + Float.hashCode(this.pitch);
        return lllllllllllllllIIlIIlllIlllIIIIl;
    }
    
    static {
        EMITTER_SELF = new Emitter() {
            @Override
            public String toString() {
                return "SelfSoundEmitter";
            }
        };
    }
    
    SoundImpl(@NotNull final Source lllllllllllllllIIlIIllllIIllIIIl, final float lllllllllllllllIIlIIllllIIlIllll, final float lllllllllllllllIIlIIllllIIllIIII) {
        this.source = lllllllllllllllIIlIIllllIIllIIIl;
        this.volume = lllllllllllllllIIlIIllllIIlIllll;
        this.pitch = lllllllllllllllIIlIIllllIIllIIII;
    }
    
    @NotNull
    @Override
    public SoundStop asStop() {
        if (this.stop == null) {
            this.stop = SoundStop.namedOnSource(this.name(), this.source());
        }
        return this.stop;
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("name", this.name()), ExaminableProperty.of("source", this.source), ExaminableProperty.of("volume", this.volume), ExaminableProperty.of("pitch", this.pitch) });
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllIIlIIlllIlllllIII) {
        if (this == lllllllllllllllIIlIIlllIlllllIII) {
            return true;
        }
        if (!(lllllllllllllllIIlIIlllIlllllIII instanceof SoundImpl)) {
            return false;
        }
        final SoundImpl lllllllllllllllIIlIIlllIllllIIlI = (SoundImpl)lllllllllllllllIIlIIlllIlllllIII;
        return this.name().equals(lllllllllllllllIIlIIlllIllllIIlI.name()) && this.source == lllllllllllllllIIlIIlllIllllIIlI.source && ShadyPines.equals(this.volume, lllllllllllllllIIlIIlllIllllIIlI.volume) && ShadyPines.equals(this.pitch, lllllllllllllllIIlIIlllIllllIIlI.pitch);
    }
    
    @Override
    public float volume() {
        return this.volume;
    }
    
    @NotNull
    @Override
    public Source source() {
        return this.source;
    }
    
    @Override
    public float pitch() {
        return this.pitch;
    }
}
