package com.viaversion.viaversion.libs.kyori.adventure.bossbar;

import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

@ApiStatus.NonExtendable
public interface BossBar extends Examinable
{
    boolean hasFlag(@NotNull final Flag lllllllllllllIIlllIIIIIIIIllIIII);
    
    @NotNull
    default BossBar bossBar(@NotNull final Component lllllllllllllIIlllIIIIIIIlIlIIIl, final float lllllllllllllIIlllIIIIIIIlIlIlII, @NotNull final Color lllllllllllllIIlllIIIIIIIlIlIIll, @NotNull final Overlay lllllllllllllIIlllIIIIIIIlIlIlIl, @NotNull final Set<Flag> lllllllllllllIIlllIIIIIIIlIlIIlI) {
        BossBarImpl.checkProgress(lllllllllllllIIlllIIIIIIIlIlIlII);
        return new BossBarImpl(lllllllllllllIIlllIIIIIIIlIlIIIl, lllllllllllllIIlllIIIIIIIlIlIlII, lllllllllllllIIlllIIIIIIIlIlIIll, lllllllllllllIIlllIIIIIIIlIlIlIl, lllllllllllllIIlllIIIIIIIlIlIIlI);
    }
    
    @Contract("_ -> this")
    @NotNull
    BossBar overlay(@NotNull final Overlay lllllllllllllIIlllIIIIIIIIllIIlI);
    
    @NotNull
    Set<Flag> flags();
    
    @Contract("_ -> this")
    @NotNull
    BossBar addFlag(@NotNull final Flag lllllllllllllIIlllIIIIIIIIlIllll);
    
    @NotNull
    @Contract("_ -> this")
    BossBar addFlags(@NotNull final Flag... lllllllllllllIIlllIIIIIIIIlIllIl);
    
    @NotNull
    default BossBar bossBar(@NotNull final Component lllllllllllllIIlllIIIIIIIlllIlll, final float lllllllllllllIIlllIIIIIIIllllIII, @NotNull final Color lllllllllllllIIlllIIIIIIIllllIIl, @NotNull final Overlay lllllllllllllIIlllIIIIIIIllllIlI) {
        BossBarImpl.checkProgress(lllllllllllllIIlllIIIIIIIllllIII);
        return new BossBarImpl(lllllllllllllIIlllIIIIIIIlllIlll, lllllllllllllIIlllIIIIIIIllllIII, lllllllllllllIIlllIIIIIIIllllIIl, lllllllllllllIIlllIIIIIIIllllIlI);
    }
    
    float progress();
    
    @NotNull
    @Contract("_ -> this")
    BossBar removeFlags(@NotNull final Iterable<Flag> lllllllllllllIIlllIIIIIIIIlIlIlI);
    
    @Contract("_ -> this")
    @NotNull
    BossBar removeFlags(@NotNull final Flag... lllllllllllllIIlllIIIIIIIIlIllII);
    
    @NotNull
    Component name();
    
    @Contract("_ -> this")
    @NotNull
    BossBar name(@NotNull final Component lllllllllllllIIlllIIIIIIIIllllll);
    
    @NotNull
    @Contract("_ -> this")
    BossBar flags(@NotNull final Set<Flag> lllllllllllllIIlllIIIIIIIIllIIIl);
    
    @NotNull
    @Contract("_ -> this")
    BossBar color(@NotNull final Color lllllllllllllIIlllIIIIIIIIllIIll);
    
    @NotNull
    default BossBar bossBar(@NotNull final ComponentLike lllllllllllllIIlllIIIIIIIllIIlIl, final float lllllllllllllIIlllIIIIIIIllIIlll, @NotNull final Color lllllllllllllIIlllIIIIIIIllIlIII, @NotNull final Overlay lllllllllllllIIlllIIIIIIIllIIllI, @NotNull final Set<Flag> lllllllllllllIIlllIIIIIIIllIlIIl) {
        BossBarImpl.checkProgress(lllllllllllllIIlllIIIIIIIllIIlll);
        return bossBar(lllllllllllllIIlllIIIIIIIllIIlIl.asComponent(), lllllllllllllIIlllIIIIIIIllIIlll, lllllllllllllIIlllIIIIIIIllIlIII, lllllllllllllIIlllIIIIIIIllIIllI, lllllllllllllIIlllIIIIIIIllIlIIl);
    }
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    default float percent() {
        return this.progress();
    }
    
    @Contract("_ -> this")
    @NotNull
    default BossBar name(@NotNull final ComponentLike lllllllllllllIIlllIIIIIIIlIIIlII) {
        return this.name(lllllllllllllIIlllIIIIIIIlIIIlII.asComponent());
    }
    
    @Contract("_ -> this")
    @NotNull
    BossBar removeListener(@NotNull final Listener lllllllllllllIIlllIIIIIIIIlIlIII);
    
    @Deprecated
    @Contract("_ -> this")
    @NotNull
    @ApiStatus.ScheduledForRemoval
    default BossBar percent(final float lllllllllllllIIlllIIIIIIIIlllIII) {
        return this.progress(lllllllllllllIIlllIIIIIIIIlllIII);
    }
    
    @NotNull
    Overlay overlay();
    
    @NotNull
    default BossBar bossBar(@NotNull final ComponentLike lllllllllllllIIlllIIIIIIlIIIlIII, final float lllllllllllllIIlllIIIIIIlIIIlIIl, @NotNull final Color lllllllllllllIIlllIIIIIIlIIIlIlI, @NotNull final Overlay lllllllllllllIIlllIIIIIIlIIIIlll) {
        BossBarImpl.checkProgress(lllllllllllllIIlllIIIIIIlIIIlIIl);
        return bossBar(lllllllllllllIIlllIIIIIIlIIIlIII.asComponent(), lllllllllllllIIlllIIIIIIlIIIlIIl, lllllllllllllIIlllIIIIIIlIIIlIlI, lllllllllllllIIlllIIIIIIlIIIIlll);
    }
    
    @Contract("_ -> this")
    @NotNull
    BossBar addFlags(@NotNull final Iterable<Flag> lllllllllllllIIlllIIIIIIIIlIlIll);
    
    @NotNull
    @Contract("_ -> this")
    BossBar removeFlag(@NotNull final Flag lllllllllllllIIlllIIIIIIIIlIlllI);
    
    @NotNull
    Color color();
    
    @Contract("_ -> this")
    @NotNull
    BossBar addListener(@NotNull final Listener lllllllllllllIIlllIIIIIIIIlIlIIl);
    
    @NotNull
    @Contract("_ -> this")
    BossBar progress(final float lllllllllllllIIlllIIIIIIIIlllllI);
    
    public enum Flag
    {
        CREATE_WORLD_FOG("create_world_fog"), 
        DARKEN_SCREEN("darken_screen"), 
        PLAY_BOSS_MUSIC("play_boss_music");
        
        private final /* synthetic */ String name;
        
        private static /* synthetic */ Flag[] $values() {
            return new Flag[] { Flag.DARKEN_SCREEN, Flag.PLAY_BOSS_MUSIC, Flag.CREATE_WORLD_FOG };
        }
        
        static {
            $VALUES = $values();
            NAMES = Index.create(Flag.class, llllllllllllllIIlIllIlIIIIIllIIl -> llllllllllllllIIlIllIlIIIIIllIIl.name);
        }
        
        private Flag(final String llllllllllllllIIlIllIlIIIIlIIIlI) {
            this.name = llllllllllllllIIlIllIlIIIIlIIIlI;
        }
    }
    
    public enum Color
    {
        YELLOW(4), 
        BLUE(1), 
        GREEN(3), 
        RED(2), 
        WHITE(6);
        
        private final /* synthetic */ String name;
        
        PINK(0), 
        PURPLE(5);
        
        private static /* synthetic */ Color[] $values() {
            return new Color[] { Color.PINK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.PURPLE, Color.WHITE };
        }
        
        private Color(final int lllllllllllllIlllIIllIllIlIllIIl, final String lllllllllllllIlllIIllIllIlIllIlI) {
            this.name = lllllllllllllIlllIIllIllIlIllIlI;
        }
        
        static {
            $VALUES = $values();
            NAMES = Index.create(Color.class, lllllllllllllIlllIIllIllIlIlIIIl -> lllllllllllllIlllIIllIllIlIlIIIl.name);
        }
    }
    
    @ApiStatus.OverrideOnly
    public interface Listener
    {
        @Deprecated
        @ApiStatus.ScheduledForRemoval
        default void bossBarPercentChanged(@NotNull final BossBar lllllllllllllIIIIlIIIIIIIIllIIlI, final float lllllllllllllIIIIlIIIIIIIIllIIIl, final float lllllllllllllIIIIlIIIIIIIIllIIII) {
        }
        
        default void bossBarFlagsChanged(@NotNull final BossBar lllllllllllllIIIIlIIIIIIIIIlllIl, @NotNull final Set<Flag> lllllllllllllIIIIlIIIIIIIIIllIll, @NotNull final Set<Flag> lllllllllllllIIIIlIIIIIIIIIlllII) {
        }
        
        default void bossBarColorChanged(@NotNull final BossBar lllllllllllllIIIIlIIIIIIIIlIlIll, @NotNull final Color lllllllllllllIIIIlIIIIIIIIlIlIIl, @NotNull final Color lllllllllllllIIIIlIIIIIIIIlIlIlI) {
        }
        
        default void bossBarOverlayChanged(@NotNull final BossBar lllllllllllllIIIIlIIIIIIIIlIIlII, @NotNull final Overlay lllllllllllllIIIIlIIIIIIIIlIIIll, @NotNull final Overlay lllllllllllllIIIIlIIIIIIIIlIIIlI) {
        }
        
        default void bossBarProgressChanged(@NotNull final BossBar lllllllllllllIIIIlIIIIIIIIlllIll, final float lllllllllllllIIIIlIIIIIIIIllllII, final float lllllllllllllIIIIlIIIIIIIIllllIl) {
            this.bossBarPercentChanged(lllllllllllllIIIIlIIIIIIIIlllIll, lllllllllllllIIIIlIIIIIIIIllllII, lllllllllllllIIIIlIIIIIIIIllllIl);
        }
        
        default void bossBarNameChanged(@NotNull final BossBar lllllllllllllIIIIlIIIIIIIlIIIllI, @NotNull final Component lllllllllllllIIIIlIIIIIIIlIIIlll, @NotNull final Component lllllllllllllIIIIlIIIIIIIlIIlIII) {
        }
    }
    
    public enum Overlay
    {
        NOTCHED_6("NOTCHED_6"), 
        NOTCHED_20("NOTCHED_20"), 
        NOTCHED_10("NOTCHED_10"), 
        NOTCHED_12("NOTCHED_12"), 
        PROGRESS("PROGRESS");
        
        private final /* synthetic */ String name;
        
        static {
            $VALUES = $values();
            NAMES = Index.create(Overlay.class, lllllllllllllIlIlIlllIIIIlIIllIl -> lllllllllllllIlIlIlllIIIIlIIllIl.name);
        }
        
        private Overlay(final String lllllllllllllIlIlIlllIIIIlIlIlIl, final int lllllllllllllIlIlIlllIIIIlIlIllI, final String lllllllllllllIlIlIlllIIIIlIlIlll) {
            this.name = lllllllllllllIlIlIlllIIIIlIlIlll;
        }
        
        private static /* synthetic */ Overlay[] $values() {
            return new Overlay[] { Overlay.PROGRESS, Overlay.NOTCHED_6, Overlay.NOTCHED_10, Overlay.NOTCHED_12, Overlay.NOTCHED_20 };
        }
    }
}
