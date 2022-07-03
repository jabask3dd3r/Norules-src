package com.viaversion.viaversion.libs.kyori.adventure.title;

import com.viaversion.viaversion.libs.kyori.examination.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import java.time.*;

@ApiStatus.NonExtendable
public interface Title extends Examinable
{
    public static final /* synthetic */ Times DEFAULT_TIMES = Times.of(Ticks.duration(10L), Ticks.duration(70L), Ticks.duration(20L));
    
    @NotNull
    Component subtitle();
    
    @NotNull
    default Title title(@NotNull final Component lllllllllllllIllllIllllIlllIlIlI, @NotNull final Component lllllllllllllIllllIllllIlllIlIIl) {
        return title(lllllllllllllIllllIllllIlllIlIlI, lllllllllllllIllllIllllIlllIlIIl, Title.DEFAULT_TIMES);
    }
    
    @NotNull
    Component title();
    
    @Nullable
    Times times();
    
    @NotNull
    default Title title(@NotNull final Component lllllllllllllIllllIllllIllIllIll, @NotNull final Component lllllllllllllIllllIllllIllIlllII, @Nullable final Times lllllllllllllIllllIllllIllIllIIl) {
        return new TitleImpl(lllllllllllllIllllIllllIllIllIll, lllllllllllllIllllIllllIllIlllII, lllllllllllllIllllIllllIllIllIIl);
    }
    
    public interface Times extends Examinable
    {
        @NotNull
        Duration fadeOut();
        
        @NotNull
        default Times of(@NotNull final Duration llllllllllllllIIllIlIIllllllIlII, @NotNull final Duration llllllllllllllIIllIlIIllllllIlIl, @NotNull final Duration llllllllllllllIIllIlIIllllllIIll) {
            return new TitleImpl.TimesImpl(llllllllllllllIIllIlIIllllllIlII, llllllllllllllIIllIlIIllllllIlIl, llllllllllllllIIllIlIIllllllIIll);
        }
        
        @NotNull
        Duration stay();
        
        @NotNull
        Duration fadeIn();
    }
}
