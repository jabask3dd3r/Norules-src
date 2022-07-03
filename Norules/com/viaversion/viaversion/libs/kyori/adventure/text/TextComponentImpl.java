package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class TextComponentImpl extends AbstractComponent implements TextComponent
{
    private static final /* synthetic */ boolean WARN_WHEN_LEGACY_FORMATTING_DETECTED;
    private final /* synthetic */ String content;
    
    @NotNull
    private static TextComponent createDirect(@NotNull final String lllllllllllllIIllIllllIllIIllIII) {
        return new TextComponentImpl(Collections.emptyList(), Style.empty(), lllllllllllllIIllIllllIllIIllIII);
    }
    
    static {
        SECTION_CHAR = '§';
        WARN_WHEN_LEGACY_FORMATTING_DETECTED = Boolean.getBoolean(String.join(".", "net", "kyori", "adventure", "text", "warnWhenLegacyFormattingDetected"));
        EMPTY = createDirect("");
        NEWLINE = createDirect("\n");
        SPACE = createDirect(" ");
    }
    
    @NotNull
    @Override
    public TextComponent children(@NotNull final List<? extends ComponentLike> lllllllllllllIIllIllllIlIlllIlII) {
        return new TextComponentImpl(lllllllllllllIIllIllllIlIlllIlII, this.style, this.content);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIllIllllIlIlIllIll = super.hashCode();
        lllllllllllllIIllIllllIlIlIllIll = 31 * lllllllllllllIIllIllllIlIlIllIll + this.content.hashCode();
        return lllllllllllllIIllIllllIlIlIllIll;
    }
    
    TextComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllIIllIllllIllIIlIIII, @NotNull final Style lllllllllllllIIllIllllIllIIIllll, @NotNull final String lllllllllllllIIllIllllIllIIIlllI) {
        super(lllllllllllllIIllIllllIllIIlIIII, lllllllllllllIIllIllllIllIIIllll);
        this.content = lllllllllllllIIllIllllIllIIIlllI;
        if (TextComponentImpl.WARN_WHEN_LEGACY_FORMATTING_DETECTED) {
            final LegacyFormattingDetected lllllllllllllIIllIllllIllIIIllIl = this.warnWhenLegacyFormattingDetected();
            if (lllllllllllllIIllIllllIllIIIllIl != null) {
                Nag.print(lllllllllllllIIllIllllIllIIIllIl);
            }
        }
    }
    
    @NotNull
    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    public String content() {
        return this.content;
    }
    
    @VisibleForTesting
    @Nullable
    final LegacyFormattingDetected warnWhenLegacyFormattingDetected() {
        if (this.content.indexOf(167) != -1) {
            return new LegacyFormattingDetected(this);
        }
        return null;
    }
    
    @NotNull
    @Override
    public TextComponent style(@NotNull final Style lllllllllllllIIllIllllIlIllIllIl) {
        return new TextComponentImpl(this.children, lllllllllllllIIllIllllIlIllIllIl, this.content);
    }
    
    @NotNull
    @Override
    public TextComponent content(@NotNull final String lllllllllllllIIllIllllIlIllllIll) {
        if (Objects.equals(this.content, lllllllllllllIIllIllllIlIllllIll)) {
            return this;
        }
        return new TextComponentImpl(this.children, this.style, Objects.requireNonNull(lllllllllllllIIllIllllIlIllllIll, "content"));
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("content", this.content)), super.examinablePropertiesWithoutChildren());
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIllIllllIlIllIIlIl) {
        if (this == lllllllllllllIIllIllllIlIllIIlIl) {
            return true;
        }
        if (!(lllllllllllllIIllIllllIlIllIIlIl instanceof TextComponentImpl)) {
            return false;
        }
        if (!super.equals(lllllllllllllIIllIllllIlIllIIlIl)) {
            return false;
        }
        final TextComponentImpl lllllllllllllIIllIllllIlIllIIIlI = (TextComponentImpl)lllllllllllllIIllIllllIlIllIIlIl;
        return Objects.equals(this.content, lllllllllllllIIllIllllIlIllIIIlI.content);
    }
    
    static final class BuilderImpl extends AbstractComponentBuilder<TextComponent, TextComponent.Builder> implements TextComponent.Builder
    {
        private /* synthetic */ String content;
        
        BuilderImpl() {
            this.content = "";
        }
        
        @NotNull
        @Override
        public TextComponent build() {
            if (this.isEmpty()) {
                return Component.empty();
            }
            return new TextComponentImpl(this.children, this.buildStyle(), this.content);
        }
        
        @NotNull
        @Override
        public String content() {
            return this.content;
        }
        
        @NotNull
        @Override
        public TextComponent.Builder content(@NotNull final String lllllllllllllIlIIIllIlIIIIllIIll) {
            this.content = Objects.requireNonNull(lllllllllllllIlIIIllIlIIIIllIIll, "content");
            return this;
        }
        
        private boolean isEmpty() {
            return this.content.isEmpty() && this.children.isEmpty() && !this.hasStyle();
        }
        
        BuilderImpl(@NotNull final TextComponent lllllllllllllIlIIIllIlIIIIlllIlI) {
            super(lllllllllllllIlIIIllIlIIIIlllIlI);
            this.content = "";
            this.content = lllllllllllllIlIIIllIlIIIIlllIlI.content();
        }
    }
}
