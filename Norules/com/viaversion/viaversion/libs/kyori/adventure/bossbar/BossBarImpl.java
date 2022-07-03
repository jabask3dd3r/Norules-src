package com.viaversion.viaversion.libs.kyori.adventure.bossbar;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;

final class BossBarImpl extends HackyBossBarPlatformBridge implements BossBar
{
    private /* synthetic */ Overlay overlay;
    private /* synthetic */ Color color;
    private final /* synthetic */ List<Listener> listeners;
    private final /* synthetic */ Set<Flag> flags;
    private static final /* synthetic */ BiConsumer<BossBarImpl, Set<Flag>> FLAGS_ADDED;
    private static final /* synthetic */ BiConsumer<BossBarImpl, Set<Flag>> FLAGS_REMOVED;
    private /* synthetic */ Component name;
    private /* synthetic */ float progress;
    
    @Override
    public boolean hasFlag(@NotNull final Flag llllllllllllllllllllIIllllIIIllI) {
        return this.flags.contains(llllllllllllllllllllIIllllIIIllI);
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    BossBarImpl(@NotNull final Component llllllllllllllllllllIlIIIIlIIlIl, final float llllllllllllllllllllIlIIIIlIIIlI, @NotNull final Color llllllllllllllllllllIlIIIIlIIlII, @NotNull final Overlay llllllllllllllllllllIlIIIIlIIIIl, @NotNull final Set<Flag> llllllllllllllllllllIlIIIIlIIIll) {
        this(llllllllllllllllllllIlIIIIlIIlIl, llllllllllllllllllllIlIIIIlIIIlI, llllllllllllllllllllIlIIIIlIIlII, llllllllllllllllllllIlIIIIlIIIIl);
        this.flags.addAll(llllllllllllllllllllIlIIIIlIIIll);
    }
    
    @NotNull
    @Override
    public BossBar removeListener(@NotNull final Listener llllllllllllllllllllIIllIlIlIIII) {
        this.listeners.remove(llllllllllllllllllllIIllIlIlIIII);
        return this;
    }
    
    @NotNull
    @Override
    public BossBar removeFlags(@NotNull final Iterable<Flag> llllllllllllllllllllIIllIlllIlIl) {
        return this.editFlags(llllllllllllllllllllIIllIlllIlIl, Set::remove, BossBarImpl.FLAGS_REMOVED);
    }
    
    @NotNull
    private BossBar editFlags(final Flag[] llllllllllllllllllllIIlllIIIllll, final BiPredicate<Set<Flag>, Flag> llllllllllllllllllllIIlllIIIlllI, final BiConsumer<BossBarImpl, Set<Flag>> llllllllllllllllllllIIlllIIIllIl) {
        if (llllllllllllllllllllIIlllIIIllll.length == 0) {
            return this;
        }
        Set<Flag> llllllllllllllllllllIIlllIIIIllI = null;
        for (int llllllllllllllllllllIIlllIIIllII = 0, llllllllllllllllllllIIlllIIIlIll = llllllllllllllllllllIIlllIIIllll.length; llllllllllllllllllllIIlllIIIllII < llllllllllllllllllllIIlllIIIlIll; ++llllllllllllllllllllIIlllIIIllII) {
            if (llllllllllllllllllllIIlllIIIlllI.test(this.flags, llllllllllllllllllllIIlllIIIllll[llllllllllllllllllllIIlllIIIllII])) {
                if (llllllllllllllllllllIIlllIIIIllI == null) {
                    llllllllllllllllllllIIlllIIIIllI = EnumSet.noneOf(Flag.class);
                }
                llllllllllllllllllllIIlllIIIIllI.add(llllllllllllllllllllIIlllIIIllll[llllllllllllllllllllIIlllIIIllII]);
            }
        }
        if (llllllllllllllllllllIIlllIIIIllI != null) {
            llllllllllllllllllllIIlllIIIllIl.accept(this, llllllllllllllllllllIIlllIIIIllI);
        }
        return this;
    }
    
    static {
        FLAGS_ADDED = ((llllllllllllllllllllIIlIlllIIIIl, llllllllllllllllllllIIlIlllIIIII) -> llllllllllllllllllllIIlIlllIIIIl.forEachListener(llllllllllllllllllllIIlIllIllIlI -> llllllllllllllllllllIIlIllIllIlI.bossBarFlagsChanged(llllllllllllllllllllIIlIlllIIIIl, llllllllllllllllllllIIlIlllIIIII, Collections.emptySet())));
        FLAGS_REMOVED = ((llllllllllllllllllllIIlIllllIIlI, llllllllllllllllllllIIlIllllIIIl) -> llllllllllllllllllllIIlIllllIIlI.forEachListener(llllllllllllllllllllIIlIlllIIllI -> llllllllllllllllllllIIlIlllIIllI.bossBarFlagsChanged(llllllllllllllllllllIIlIllllIIlI, Collections.emptySet(), llllllllllllllllllllIIlIllllIIIl)));
    }
    
    @NotNull
    @Override
    public BossBar addFlags(@NotNull final Flag... llllllllllllllllllllIIlllIlIIIlI) {
        return this.editFlags(llllllllllllllllllllIIlllIlIIIlI, Set::add, BossBarImpl.FLAGS_ADDED);
    }
    
    @NotNull
    @Override
    public Overlay overlay() {
        return this.overlay;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("name", this.name), ExaminableProperty.of("progress", this.progress), ExaminableProperty.of("color", this.color), ExaminableProperty.of("overlay", this.overlay), ExaminableProperty.of("flags", this.flags) });
    }
    
    @NotNull
    private BossBar editFlags(final Iterable<Flag> llllllllllllllllllllIIllIllIlIIl, final BiPredicate<Set<Flag>, Flag> llllllllllllllllllllIIllIllIIlll, final BiConsumer<BossBarImpl, Set<Flag>> llllllllllllllllllllIIllIllIlIII) {
        Set<Flag> llllllllllllllllllllIIllIllIIIIl = null;
        for (final Flag llllllllllllllllllllIIllIllIIllI : llllllllllllllllllllIIllIllIlIIl) {
            if (llllllllllllllllllllIIllIllIIlll.test(this.flags, llllllllllllllllllllIIllIllIIllI)) {
                if (llllllllllllllllllllIIllIllIIIIl == null) {
                    llllllllllllllllllllIIllIllIIIIl = EnumSet.noneOf(Flag.class);
                }
                llllllllllllllllllllIIllIllIIIIl.add(llllllllllllllllllllIIllIllIIllI);
            }
        }
        if (llllllllllllllllllllIIllIllIIIIl != null) {
            llllllllllllllllllllIIllIllIlIII.accept(this, llllllllllllllllllllIIllIllIIIIl);
        }
        return this;
    }
    
    @NotNull
    @Override
    public BossBar name(@NotNull final Component llllllllllllllllllllIlIIIIIIlllI) {
        Objects.requireNonNull(llllllllllllllllllllIlIIIIIIlllI, "name");
        final Component llllllllllllllllllllIlIIIIIIlIll = this.name;
        if (!Objects.equals(llllllllllllllllllllIlIIIIIIlllI, llllllllllllllllllllIlIIIIIIlIll)) {
            this.name = llllllllllllllllllllIlIIIIIIlllI;
            this.forEachListener(llllllllllllllllllllIIlIllllIlIl -> llllllllllllllllllllIIlIllllIlIl.bossBarNameChanged(this, llllllllllllllllllllIlIIIIIIlIll, llllllllllllllllllllIlIIIIIIlllI));
        }
        return this;
    }
    
    @NotNull
    @Override
    public BossBar flags(@NotNull final Set<Flag> llllllllllllllllllllIIllllIlIlII) {
        if (llllllllllllllllllllIIllllIlIlII.isEmpty()) {
            final Set<Flag> llllllllllllllllllllIIllllIlIIll = EnumSet.copyOf(this.flags);
            this.flags.clear();
            this.forEachListener(llllllllllllllllllllIIllIIlIIlIl -> llllllllllllllllllllIIllIIlIIlIl.bossBarFlagsChanged(this, Collections.emptySet(), llllllllllllllllllllIIllllIlIIll));
        }
        else if (!this.flags.equals(llllllllllllllllllllIIllllIlIlII)) {
            final Set<Flag> llllllllllllllllllllIIllllIlIIlI = EnumSet.copyOf(this.flags);
            this.flags.clear();
            this.flags.addAll(llllllllllllllllllllIIllllIlIlII);
            final EnumSet<Flag> copy;
            final Set<Flag> llllllllllllllllllllIIllllIlIIIl = copy = EnumSet.copyOf(llllllllllllllllllllIIllllIlIlII);
            final Set<Flag> set = llllllllllllllllllllIIllllIlIIlI;
            Objects.requireNonNull(set);
            copy.removeIf(set::contains);
            final EnumSet<Flag> copy2;
            final Set<Flag> llllllllllllllllllllIIllllIlIIII = copy2 = EnumSet.copyOf(llllllllllllllllllllIIllllIlIIlI);
            final Set<Flag> flags = this.flags;
            Objects.requireNonNull(flags);
            copy2.removeIf(flags::contains);
            this.forEachListener(llllllllllllllllllllIIllIIlIlllI -> llllllllllllllllllllIIllIIlIlllI.bossBarFlagsChanged(this, llllllllllllllllllllIIllllIlIIIl, llllllllllllllllllllIIllllIlIIII));
        }
        return this;
    }
    
    @NotNull
    @Override
    public BossBar removeFlag(@NotNull final Flag llllllllllllllllllllIIlllIlllIII) {
        return this.editFlags(llllllllllllllllllllIIlllIlllIII, Set::remove, BossBarImpl.FLAGS_REMOVED);
    }
    
    @Override
    public float progress() {
        return this.progress;
    }
    
    @NotNull
    @Override
    public BossBar overlay(@NotNull final Overlay llllllllllllllllllllIIlllllIIIll) {
        Objects.requireNonNull(llllllllllllllllllllIIlllllIIIll, "overlay");
        final Overlay llllllllllllllllllllIIlllllIIIII = this.overlay;
        if (llllllllllllllllllllIIlllllIIIll != llllllllllllllllllllIIlllllIIIII) {
            this.overlay = llllllllllllllllllllIIlllllIIIll;
            this.forEachListener(llllllllllllllllllllIIllIIIlllIl -> llllllllllllllllllllIIllIIIlllIl.bossBarOverlayChanged(this, llllllllllllllllllllIIlllllIIIII, llllllllllllllllllllIIlllllIIIll));
        }
        return this;
    }
    
    @NotNull
    @Override
    public BossBar addListener(@NotNull final Listener llllllllllllllllllllIIllIlIlIlll) {
        this.listeners.add(llllllllllllllllllllIIllIlIlIlll);
        return this;
    }
    
    private void forEachListener(@NotNull final Consumer<Listener> llllllllllllllllllllIIllIlIIIlll) {
        for (final Listener llllllllllllllllllllIIllIlIIIllI : this.listeners) {
            llllllllllllllllllllIIllIlIIIlll.accept(llllllllllllllllllllIIllIlIIIllI);
        }
    }
    
    BossBarImpl(@NotNull final Component llllllllllllllllllllIlIIIIllIllI, final float llllllllllllllllllllIlIIIIlllIII, @NotNull final Color llllllllllllllllllllIlIIIIllIlll, @NotNull final Overlay llllllllllllllllllllIlIIIIlllIIl) {
        this.listeners = new CopyOnWriteArrayList<Listener>();
        this.flags = EnumSet.noneOf(Flag.class);
        this.name = Objects.requireNonNull(llllllllllllllllllllIlIIIIllIllI, "name");
        this.progress = llllllllllllllllllllIlIIIIlllIII;
        this.color = Objects.requireNonNull(llllllllllllllllllllIlIIIIllIlll, "color");
        this.overlay = Objects.requireNonNull(llllllllllllllllllllIlIIIIlllIIl, "overlay");
    }
    
    @NotNull
    @Override
    public BossBar removeFlags(@NotNull final Flag... llllllllllllllllllllIIlllIIllIll) {
        return this.editFlags(llllllllllllllllllllIIlllIIllIll, Set::remove, BossBarImpl.FLAGS_REMOVED);
    }
    
    @NotNull
    @Override
    public BossBar color(@NotNull final Color llllllllllllllllllllIIllllllIIII) {
        Objects.requireNonNull(llllllllllllllllllllIIllllllIIII, "color");
        final Color llllllllllllllllllllIIlllllIllIl = this.color;
        if (llllllllllllllllllllIIllllllIIII != llllllllllllllllllllIIlllllIllIl) {
            this.color = llllllllllllllllllllIIllllllIIII;
            this.forEachListener(llllllllllllllllllllIIllIIIlIIIl -> llllllllllllllllllllIIllIIIlIIIl.bossBarColorChanged(this, llllllllllllllllllllIIlllllIllIl, llllllllllllllllllllIIllllllIIII));
        }
        return this;
    }
    
    @NotNull
    @Override
    public Component name() {
        return this.name;
    }
    
    static void checkProgress(final float llllllllllllllllllllIIlllllllIIl) {
        if (llllllllllllllllllllIIlllllllIIl < 0.0f || llllllllllllllllllllIIlllllllIIl > 1.0f) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("progress must be between 0.0 and 1.0, was ").append(llllllllllllllllllllIIlllllllIIl)));
        }
    }
    
    @NotNull
    @Override
    public Set<Flag> flags() {
        return Collections.unmodifiableSet((Set<? extends Flag>)this.flags);
    }
    
    @NotNull
    @Override
    public BossBar progress(final float llllllllllllllllllllIlIIIIIIIIIl) {
        checkProgress(llllllllllllllllllllIlIIIIIIIIIl);
        final float llllllllllllllllllllIIlllllllllI = this.progress;
        if (llllllllllllllllllllIlIIIIIIIIIl != llllllllllllllllllllIIlllllllllI) {
            this.progress = llllllllllllllllllllIlIIIIIIIIIl;
            this.forEachListener(llllllllllllllllllllIIllIIIIIlIl -> llllllllllllllllllllIIllIIIIIlIl.bossBarProgressChanged(this, llllllllllllllllllllIIlllllllllI, llllllllllllllllllllIlIIIIIIIIIl));
        }
        return this;
    }
    
    @NotNull
    private BossBar editFlags(@NotNull final Flag llllllllllllllllllllIIlllIlIlllI, @NotNull final BiPredicate<Set<Flag>, Flag> llllllllllllllllllllIIlllIlIllIl, final BiConsumer<BossBarImpl, Set<Flag>> llllllllllllllllllllIIlllIlIllll) {
        if (llllllllllllllllllllIIlllIlIllIl.test(this.flags, llllllllllllllllllllIIlllIlIlllI)) {
            llllllllllllllllllllIIlllIlIllll.accept(this, Collections.singleton(llllllllllllllllllllIIlllIlIlllI));
        }
        return this;
    }
    
    @NotNull
    @Override
    public BossBar addFlags(@NotNull final Iterable<Flag> llllllllllllllllllllIIllIlllllII) {
        return this.editFlags(llllllllllllllllllllIIllIlllllII, Set::add, BossBarImpl.FLAGS_ADDED);
    }
    
    @NotNull
    @Override
    public BossBar addFlag(@NotNull final Flag llllllllllllllllllllIIlllIllllll) {
        return this.editFlags(llllllllllllllllllllIIlllIllllll, Set::add, BossBarImpl.FLAGS_ADDED);
    }
    
    @NotNull
    @Override
    public Color color() {
        return this.color;
    }
}
