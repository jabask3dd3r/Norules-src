package com.viaversion.viaversion.libs.kyori.adventure.text.format;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;

public enum TextDecoration implements StyleBuilderApplicable, TextFormat
{
    BOLD("bold"), 
    STRIKETHROUGH("strikethrough"), 
    UNDERLINED("underlined");
    
    private final /* synthetic */ String name;
    
    ITALIC("italic"), 
    OBFUSCATED("obfuscated");
    
    static {
        $VALUES = $values();
        NAMES = Index.create(TextDecoration.class, lllllllllllllIlIllIlIIllllIIIlIl -> lllllllllllllIlIllIlIIllllIIIlIl.name);
    }
    
    @NotNull
    public final TextDecorationAndState as(final boolean lllllllllllllIlIllIlIIllllIlllII) {
        return this.as(State.byBoolean(lllllllllllllIlIllIlIIllllIlllII));
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.name;
    }
    
    @Override
    public void styleApply(final Style.Builder lllllllllllllIlIllIlIIllllIIlllI) {
        lllllllllllllIlIllIlIIllllIIlllI.decorate(this);
    }
    
    @NotNull
    public final TextDecorationAndState as(@NotNull final State lllllllllllllIlIllIlIIllllIlIlIl) {
        return new TextDecorationAndStateImpl(this, lllllllllllllIlIllIlIIllllIlIlIl);
    }
    
    private static /* synthetic */ TextDecoration[] $values() {
        return new TextDecoration[] { TextDecoration.OBFUSCATED, TextDecoration.BOLD, TextDecoration.STRIKETHROUGH, TextDecoration.UNDERLINED, TextDecoration.ITALIC };
    }
    
    private TextDecoration(final String lllllllllllllIlIllIlIIlllllIIlIl) {
        this.name = lllllllllllllIlIllIlIIlllllIIlIl;
    }
    
    public enum State
    {
        FALSE(1), 
        TRUE(2), 
        NOT_SET(0);
        
        private final /* synthetic */ String name;
        
        private State(final int llllllllllllllllIllllIIlIllIIIII, final String llllllllllllllllIllllIIlIllIIIlI) {
            this.name = llllllllllllllllIllllIIlIllIIIlI;
        }
        
        private static /* synthetic */ State[] $values() {
            return new State[] { State.NOT_SET, State.FALSE, State.TRUE };
        }
        
        static {
            $VALUES = $values();
        }
        
        @NotNull
        public static State byBoolean(final boolean llllllllllllllllIllllIIlIlIIlIll) {
            return llllllllllllllllIllllIIlIlIIlIll ? State.TRUE : State.FALSE;
        }
        
        @NotNull
        public static State byBoolean(@Nullable final Boolean llllllllllllllllIllllIIlIlIIIIIl) {
            return (llllllllllllllllIllllIIlIlIIIIIl == null) ? State.NOT_SET : byBoolean((boolean)llllllllllllllllIllllIIlIlIIIIIl);
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
