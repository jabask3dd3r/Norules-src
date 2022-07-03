package com.viaversion.viaversion.libs.kyori.adventure.inventory;

import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.examination.string.*;
import com.viaversion.viaversion.libs.kyori.examination.*;

final class BookImpl implements Book
{
    private final /* synthetic */ Component title;
    private final /* synthetic */ List<Component> pages;
    private final /* synthetic */ Component author;
    
    @NotNull
    @Override
    public Book author(@NotNull final Component llllllllllllllIIIllIIIIIIlllIlIl) {
        return new BookImpl(this.title, Objects.requireNonNull(llllllllllllllIIIllIIIIIIlllIlIl, "author"), this.pages);
    }
    
    @NotNull
    @Override
    public Book pages(@NotNull final List<Component> llllllllllllllIIIllIIIIIIllIlIll) {
        return new BookImpl(this.title, this.author, new ArrayList<Component>(Objects.requireNonNull(llllllllllllllIIIllIIIIIIllIlIll, "pages")));
    }
    
    @NotNull
    @Override
    public Book title(@NotNull final Component llllllllllllllIIIllIIIIIIlllllll) {
        return new BookImpl(Objects.requireNonNull(llllllllllllllIIIllIIIIIIlllllll, "title"), this.author, this.pages);
    }
    
    @NotNull
    @Override
    public Component author() {
        return this.author;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIIIllIIIIIIlIlIllI = this.title.hashCode();
        llllllllllllllIIIllIIIIIIlIlIllI = 31 * llllllllllllllIIIllIIIIIIlIlIllI + this.author.hashCode();
        llllllllllllllIIIllIIIIIIlIlIllI = 31 * llllllllllllllIIIllIIIIIIlIlIllI + this.pages.hashCode();
        return llllllllllllllIIIllIIIIIIlIlIllI;
    }
    
    @NotNull
    @Override
    public Stream<? extends ExaminableProperty> examinableProperties() {
        return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("title", this.title), ExaminableProperty.of("author", this.author), ExaminableProperty.of("pages", this.pages) });
    }
    
    @NotNull
    @Override
    public Component title() {
        return this.title;
    }
    
    BookImpl(@NotNull final Component llllllllllllllIIIllIIIIIlIIIllIl, @NotNull final Component llllllllllllllIIIllIIIIIlIIIlllI, @NotNull final List<Component> llllllllllllllIIIllIIIIIlIIIllll) {
        this.title = Objects.requireNonNull(llllllllllllllIIIllIIIIIlIIIllIl, "title");
        this.author = Objects.requireNonNull(llllllllllllllIIIllIIIIIlIIIlllI, "author");
        this.pages = Collections.unmodifiableList((List<? extends Component>)Objects.requireNonNull((List<? extends T>)llllllllllllllIIIllIIIIIlIIIllll, "pages"));
    }
    
    @NotNull
    @Override
    public List<Component> pages() {
        return this.pages;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIllIIIIIIllIIIII) {
        if (this == llllllllllllllIIIllIIIIIIllIIIII) {
            return true;
        }
        if (!(llllllllllllllIIIllIIIIIIllIIIII instanceof BookImpl)) {
            return false;
        }
        final BookImpl llllllllllllllIIIllIIIIIIlIlllIl = (BookImpl)llllllllllllllIIIllIIIIIIllIIIII;
        return this.title.equals(llllllllllllllIIIllIIIIIIlIlllIl.title) && this.author.equals(llllllllllllllIIIllIIIIIIlIlllIl.author) && this.pages.equals(llllllllllllllIIIllIIIIIIlIlllIl.pages);
    }
    
    @Override
    public String toString() {
        return this.examine((Examiner<String>)StringExaminer.simpleEscaping());
    }
    
    static final class BuilderImpl implements Builder
    {
        private /* synthetic */ Component title;
        private /* synthetic */ Component author;
        private final /* synthetic */ List<Component> pages;
        
        @NotNull
        @Override
        public Builder title(@NotNull final Component lllllllllllllIIlllllIlllIIllllIl) {
            this.title = Objects.requireNonNull(lllllllllllllIIlllllIlllIIllllIl, "title");
            return this;
        }
        
        BuilderImpl() {
            this.title = Component.empty();
            this.author = Component.empty();
            this.pages = new ArrayList<Component>();
        }
        
        @NotNull
        @Override
        public Builder addPage(@NotNull final Component lllllllllllllIIlllllIlllIIlIlIIl) {
            this.pages.add(Objects.requireNonNull(lllllllllllllIIlllllIlllIIlIlIIl, "page"));
            return this;
        }
        
        @NotNull
        @Override
        public Builder author(@NotNull final Component lllllllllllllIIlllllIlllIIllIllI) {
            this.author = Objects.requireNonNull(lllllllllllllIIlllllIlllIIllIllI, "author");
            return this;
        }
        
        @NotNull
        @Override
        public Builder pages(@NotNull final Component... lllllllllllllIIlllllIlllIIIIlIII) {
            Collections.addAll(this.pages, lllllllllllllIIlllllIlllIIIIlIII);
            return this;
        }
        
        @NotNull
        @Override
        public Builder pages(@NotNull final Collection<Component> lllllllllllllIIlllllIlllIIIllIlI) {
            this.pages.addAll(Objects.requireNonNull(lllllllllllllIIlllllIlllIIIllIlI, "pages"));
            return this;
        }
        
        @NotNull
        @Override
        public Book build() {
            return new BookImpl(this.title, this.author, new ArrayList<Component>(this.pages));
        }
    }
}
