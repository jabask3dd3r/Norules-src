package com.viaversion.viaversion.libs.kyori.adventure.text.event;

import java.net.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

public final class ClickEvent implements StyleBuilderApplicable, Examinable
{
    private final /* synthetic */ String value;
    private final /* synthetic */ Action action;
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlIIllIIlIlIIllIlI = this.action.hashCode();
        lllllllllllllIIlIIllIIlIlIIllIlI = 31 * lllllllllllllIIlIIllIIlIlIIllIlI + this.value.hashCode();
        return lllllllllllllIIlIIllIIlIlIIllIlI;
    }
    
    @NotNull
    public static ClickEvent runCommand(@NotNull final String lllllllllllllIIlIIllIIlIllIllIlI) {
        return new ClickEvent(Action.RUN_COMMAND, lllllllllllllIIlIIllIIlIllIllIlI);
    }
    
    @NotNull
    public Action action() {
        return this.action;
    }
    
    @NotNull
    public static ClickEvent copyToClipboard(@NotNull final String lllllllllllllIIlIIllIIlIllIIlIlI) {
        return new ClickEvent(Action.COPY_TO_CLIPBOARD, lllllllllllllIIlIIllIIlIllIIlIlI);
    }
    
    @NotNull
    public static ClickEvent changePage(final int lllllllllllllIIlIIllIIlIllIIlllI) {
        return changePage(String.valueOf(lllllllllllllIIlIIllIIlIllIIlllI));
    }
    
    @NotNull
    public static ClickEvent openUrl(@NotNull final URL lllllllllllllIIlIIllIIlIlllIIIlI) {
        return openUrl(lllllllllllllIIlIIllIIlIlllIIIlI.toExternalForm());
    }
    
    @NotNull
    public String value() {
        return this.value;
    }
    
    private ClickEvent(@NotNull final Action lllllllllllllIIlIIllIIlIlIllllII, @NotNull final String lllllllllllllIIlIIllIIlIlIlllIll) {
        this.action = Objects.requireNonNull(lllllllllllllIIlIIllIIlIlIllllII, "action");
        this.value = Objects.requireNonNull(lllllllllllllIIlIIllIIlIlIlllIll, "value");
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("action", this.action), ExaminableProperty.of("value", this.value) });
    }
    
    @NotNull
    public static ClickEvent suggestCommand(@NotNull final String lllllllllllllIIlIIllIIlIllIlIllI) {
        return new ClickEvent(Action.SUGGEST_COMMAND, lllllllllllllIIlIIllIIlIllIlIllI);
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIlIIllIIlIlIlIIlII) {
        if (this == lllllllllllllIIlIIllIIlIlIlIIlII) {
            return true;
        }
        if (lllllllllllllIIlIIllIIlIlIlIIlII == null || this.getClass() != lllllllllllllIIlIIllIIlIlIlIIlII.getClass()) {
            return false;
        }
        final ClickEvent lllllllllllllIIlIIllIIlIlIlIIIIl = (ClickEvent)lllllllllllllIIlIIllIIlIlIlIIlII;
        return this.action == lllllllllllllIIlIIllIIlIlIlIIIIl.action && Objects.equals(this.value, lllllllllllllIIlIIllIIlIlIlIIIIl.value);
    }
    
    @NotNull
    public static ClickEvent changePage(@NotNull final String lllllllllllllIIlIIllIIlIllIlIIlI) {
        return new ClickEvent(Action.CHANGE_PAGE, lllllllllllllIIlIIllIIlIllIlIIlI);
    }
    
    @NotNull
    public static ClickEvent openUrl(@NotNull final String lllllllllllllIIlIIllIIlIlllIIllI) {
        return new ClickEvent(Action.OPEN_URL, lllllllllllllIIlIIllIIlIlllIIllI);
    }
    
    @NotNull
    public static ClickEvent clickEvent(@NotNull final Action lllllllllllllIIlIIllIIlIllIIIlIl, @NotNull final String lllllllllllllIIlIIllIIlIllIIIlII) {
        return new ClickEvent(lllllllllllllIIlIIllIIlIllIIIlIl, lllllllllllllIIlIIllIIlIllIIIlII);
    }
    
    @NotNull
    public static ClickEvent openFile(@NotNull final String lllllllllllllIIlIIllIIlIllIllllI) {
        return new ClickEvent(Action.OPEN_FILE, lllllllllllllIIlIIllIIlIllIllllI);
    }
    
    @Override
    public void styleApply(final Style.Builder lllllllllllllIIlIIllIIlIlIlIllII) {
        lllllllllllllIIlIIllIIlIlIlIllII.clickEvent(this);
    }
    
    public enum Action
    {
        OPEN_FILE("open_file", false), 
        OPEN_URL("open_url", true);
        
        private final /* synthetic */ String name;
        
        CHANGE_PAGE("change_page", true), 
        SUGGEST_COMMAND("suggest_command", true), 
        RUN_COMMAND("run_command", true);
        
        private final /* synthetic */ boolean readable;
        
        COPY_TO_CLIPBOARD("copy_to_clipboard", true);
        
        private Action(final String lllllllllllllIIIIIlIIlIIIIllIIII, final boolean lllllllllllllIIIIIlIIlIIIIlIllll) {
            this.name = lllllllllllllIIIIIlIIlIIIIllIIII;
            this.readable = lllllllllllllIIIIIlIIlIIIIlIllll;
        }
        
        public boolean readable() {
            return this.readable;
        }
        
        @NotNull
        @Override
        public String toString() {
            return this.name;
        }
        
        private static /* synthetic */ Action[] $values() {
            return new Action[] { Action.OPEN_URL, Action.OPEN_FILE, Action.RUN_COMMAND, Action.SUGGEST_COMMAND, Action.CHANGE_PAGE, Action.COPY_TO_CLIPBOARD };
        }
        
        static {
            $VALUES = $values();
            NAMES = Index.create(Action.class, lllllllllllllIIIIIlIIlIIIIIlllll -> lllllllllllllIIIIIlIIlIIIIIlllll.name);
        }
    }
}
