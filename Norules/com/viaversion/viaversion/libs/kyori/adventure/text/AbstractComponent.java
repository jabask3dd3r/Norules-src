package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import java.util.function.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import org.jetbrains.annotations.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

@Debug.Renderer(text = "this.debuggerString()", childrenArray = "this.children().toArray()", hasChildren = "!this.children().isEmpty()")
public abstract class AbstractComponent implements Component
{
    protected final /* synthetic */ List<Component> children;
    protected final /* synthetic */ Style style;
    private static final /* synthetic */ Predicate<Component> NOT_EMPTY;
    
    static {
        NOT_EMPTY = (lllllllllllllllllIIlllIIlIlIlIIl -> lllllllllllllllllIIlllIIlIlIlIIl != Component.empty());
    }
    
    @NotNull
    @Override
    public Component replaceText(@NotNull final Consumer<TextReplacementConfig.Builder> lllllllllllllllllIIlllIIllIlIIll) {
        Objects.requireNonNull(lllllllllllllllllIIlllIIllIlIIll, "configurer");
        return this.replaceText(Buildable.configureAndBuild(TextReplacementConfig.builder(), lllllllllllllllllIIlllIIllIlIIll));
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllllIIlllIIlIlllIlI = this.children.hashCode();
        lllllllllllllllllIIlllIIlIlllIlI = 31 * lllllllllllllllllIIlllIIlIlllIlI + this.style.hashCode();
        return lllllllllllllllllIIlllIIlIlllIlI;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllllllIIlllIIllIIIlII) {
        if (this == lllllllllllllllllIIlllIIllIIIlII) {
            return true;
        }
        if (!(lllllllllllllllllIIlllIIllIIIlII instanceof AbstractComponent)) {
            return false;
        }
        final AbstractComponent lllllllllllllllllIIlllIIllIIIIIl = (AbstractComponent)lllllllllllllllllIIlllIIllIIIlII;
        return Objects.equals(this.children, lllllllllllllllllIIlllIIllIIIIIl.children) && Objects.equals(this.style, lllllllllllllllllIIlllIIllIIIIIl.style);
    }
    
    private String debuggerString() {
        return StringExaminer.simpleEscaping().examine(this.examinableName(), this.examinablePropertiesWithoutChildren());
    }
    
    @NotNull
    @Override
    public Component replaceText(@NotNull final TextReplacementConfig lllllllllllllllllIIlllIIllIIllII) {
        Objects.requireNonNull(lllllllllllllllllIIlllIIllIIllII, "replacement");
        if (!(lllllllllllllllllIIlllIIllIIllII instanceof TextReplacementConfigImpl)) {
            throw new IllegalArgumentException("Provided replacement was a custom TextReplacementConfig implementation, which is not supported.");
        }
        return TextReplacementRenderer.INSTANCE.render((Component)this, ((TextReplacementConfigImpl)lllllllllllllllllIIlllIIllIIllII).createState());
    }
    
    @NotNull
    @Override
    public final List<Component> children() {
        return this.children;
    }
    
    @NotNull
    @Override
    public final Style style() {
        return this.style;
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    protected AbstractComponent(@NotNull final List<? extends ComponentLike> lllllllllllllllllIIlllIIlllIIIll, @NotNull final Style lllllllllllllllllIIlllIIlllIIIlI) {
        this.children = ComponentLike.asComponents(lllllllllllllllllIIlllIIlllIIIll, AbstractComponent.NOT_EMPTY);
        this.style = lllllllllllllllllIIlllIIlllIIIlI;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.concat(this.examinablePropertiesWithoutChildren(), (Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("children", this.children)));
    }
    
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.of(ExaminableProperty.of("style", this.style));
    }
}
