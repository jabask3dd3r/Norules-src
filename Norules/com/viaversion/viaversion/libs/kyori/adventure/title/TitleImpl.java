package com.viaversion.viaversion.libs.kyori.adventure.title;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.time.*;

final class TitleImpl implements Title
{
    @Nullable
    private final /* synthetic */ Times times;
    private final /* synthetic */ Component subtitle;
    private final /* synthetic */ Component title;
    
    @Nullable
    @Override
    public Times times() {
        return this.times;
    }
    
    @NotNull
    @Override
    public Component subtitle() {
        return this.subtitle;
    }
    
    @NotNull
    @Override
    public Component title() {
        return this.title;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIlllIIIIlIllllllIl) {
        if (this == lllllllllllllIIlllIIIIlIllllllIl) {
            return true;
        }
        if (lllllllllllllIIlllIIIIlIllllllIl == null || this.getClass() != lllllllllllllIIlllIIIIlIllllllIl.getClass()) {
            return false;
        }
        final TitleImpl lllllllllllllIIlllIIIIlIlllllIlI = (TitleImpl)lllllllllllllIIlllIIIIlIllllllIl;
        return this.title.equals(lllllllllllllIIlllIIIIlIlllllIlI.title) && this.subtitle.equals(lllllllllllllIIlllIIIIlIlllllIlI.subtitle) && Objects.equals(this.times, lllllllllllllIIlllIIIIlIlllllIlI.times);
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("title", this.title), ExaminableProperty.of("subtitle", this.subtitle), ExaminableProperty.of("times", this.times) });
    }
    
    TitleImpl(@NotNull final Component lllllllllllllIIlllIIIIllIIIlIIlI, @NotNull final Component lllllllllllllIIlllIIIIllIIIlIlII, @Nullable final Times lllllllllllllIIlllIIIIllIIIlIIll) {
        this.title = lllllllllllllIIlllIIIIllIIIlIIlI;
        this.subtitle = lllllllllllllIIlllIIIIllIIIlIlII;
        this.times = lllllllllllllIIlllIIIIllIIIlIIll;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlllIIIIlIllllIIll = this.title.hashCode();
        lllllllllllllIIlllIIIIlIllllIIll = 31 * lllllllllllllIIlllIIIIlIllllIIll + this.subtitle.hashCode();
        lllllllllllllIIlllIIIIlIllllIIll = 31 * lllllllllllllIIlllIIIIlIllllIIll + Objects.hashCode(this.times);
        return lllllllllllllIIlllIIIIlIllllIIll;
    }
    
    static class TimesImpl implements Times
    {
        private final /* synthetic */ Duration stay;
        private final /* synthetic */ Duration fadeIn;
        private final /* synthetic */ Duration fadeOut;
        
        @NotNull
        @Override
        public Duration fadeIn() {
            return this.fadeIn;
        }
        
        @NotNull
        @Override
        public Duration fadeOut() {
            return this.fadeOut;
        }
        
        @Override
        public boolean equals(@Nullable final Object lllllllllllllIlIllIIlIIIIllIllIl) {
            if (this == lllllllllllllIlIllIIlIIIIllIllIl) {
                return true;
            }
            if (lllllllllllllIlIllIIlIIIIllIllIl == null || this.getClass() != lllllllllllllIlIllIIlIIIIllIllIl.getClass()) {
                return false;
            }
            final TimesImpl lllllllllllllIlIllIIlIIIIllIlIlI = (TimesImpl)lllllllllllllIlIllIIlIIIIllIllIl;
            return this.fadeIn.equals(lllllllllllllIlIllIIlIIIIllIlIlI.fadeIn) && this.stay.equals(lllllllllllllIlIllIIlIIIIllIlIlI.stay) && this.fadeOut.equals(lllllllllllllIlIllIIlIIIIllIlIlI.fadeOut);
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllIlIllIIlIIIIllIIIll = this.fadeIn.hashCode();
            lllllllllllllIlIllIIlIIIIllIIIll = 31 * lllllllllllllIlIllIIlIIIIllIIIll + this.stay.hashCode();
            lllllllllllllIlIllIIlIIIIllIIIll = 31 * lllllllllllllIlIllIIlIIIIllIIIll + this.fadeOut.hashCode();
            return lllllllllllllIlIllIIlIIIIllIIIll;
        }
        
        @Override
        public String toString() {
            return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
        }
        
        @NotNull
        @Override
        public Duration stay() {
            return this.stay;
        }
        
        @NotNull
        @Override
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("fadeIn", this.fadeIn), ExaminableProperty.of("stay", this.stay), ExaminableProperty.of("fadeOut", this.fadeOut) });
        }
        
        TimesImpl(final Duration lllllllllllllIlIllIIlIIIlIIIIlII, final Duration lllllllllllllIlIllIIlIIIlIIIIIll, final Duration lllllllllllllIlIllIIlIIIlIIIIIlI) {
            this.fadeIn = lllllllllllllIlIllIIlIIIlIIIIlII;
            this.stay = lllllllllllllIlIllIIlIIIlIIIIIll;
            this.fadeOut = lllllllllllllIlIllIIlIIIlIIIIIlI;
        }
    }
}
