package com.viaversion.viaversion.libs.kyori.adventure.inventory;

import com.viaversion.viaversion.libs.kyori.adventure.util.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import java.util.*;

@ApiStatus.NonExtendable
public interface Book extends Buildable<Book, Builder>, Examinable
{
    @NotNull
    List<Component> pages();
    
    @Contract(value = "_ -> new", pure = true)
    @NotNull
    Book title(@NotNull final Component lllllllllllllllIlllllIIllllIIIll);
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    Book pages(@NotNull final List<Component> lllllllllllllllIlllllIIlllIllIlI);
    
    @NotNull
    Component author();
    
    @NotNull
    default Builder toBuilder() {
        return builder().title(this.title()).author(this.author()).pages(this.pages());
    }
    
    @NotNull
    default Builder builder() {
        return new BookImpl.BuilderImpl();
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    default Book pages(@NotNull final Component... lllllllllllllllIlllllIIlllIlllll) {
        return this.pages(Arrays.asList(lllllllllllllllIlllllIIlllIlllll));
    }
    
    @NotNull
    default Book book(@NotNull final Component lllllllllllllllIlllllIlIIIIIIIlI, @NotNull final Component lllllllllllllllIlllllIlIIIIIIlII, @NotNull final Collection<Component> lllllllllllllllIlllllIlIIIIIIlll) {
        return new BookImpl(lllllllllllllllIlllllIlIIIIIIIlI, lllllllllllllllIlllllIlIIIIIIlII, new ArrayList<Component>(lllllllllllllllIlllllIlIIIIIIlll));
    }
    
    @NotNull
    @Contract(value = "_ -> new", pure = true)
    Book author(@NotNull final Component lllllllllllllllIlllllIIllllIIIlI);
    
    @NotNull
    Component title();
    
    @NotNull
    default Book book(@NotNull final Component lllllllllllllllIlllllIIlllllIIII, @NotNull final Component lllllllllllllllIlllllIIllllIllll, @NotNull final Component... lllllllllllllllIlllllIIllllIlllI) {
        return book(lllllllllllllllIlllllIIlllllIIII, lllllllllllllllIlllllIIllllIllll, Arrays.asList(lllllllllllllllIlllllIIllllIlllI));
    }
    
    public interface Builder extends Buildable.Builder<Book>
    {
        @Contract("_ -> this")
        @NotNull
        Builder addPage(@NotNull final Component lllllllllllllIIIIIlIIIIIllIIIIII);
        
        @Contract("_ -> this")
        @NotNull
        Builder title(@NotNull final Component lllllllllllllIIIIIlIIIIIllIIIIlI);
        
        @Contract("_ -> this")
        @NotNull
        Builder pages(@NotNull final Component... lllllllllllllIIIIIlIIIIIlIllllll);
        
        @NotNull
        @Contract("_ -> this")
        Builder author(@NotNull final Component lllllllllllllIIIIIlIIIIIllIIIIIl);
        
        @NotNull
        Book build();
        
        @NotNull
        @Contract("_ -> this")
        Builder pages(@NotNull final Collection<Component> lllllllllllllIIIIIlIIIIIlIlllllI);
    }
}
