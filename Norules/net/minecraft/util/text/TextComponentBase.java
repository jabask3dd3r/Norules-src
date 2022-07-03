package net.minecraft.util.text;

import java.util.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import javax.annotation.*;

public abstract class TextComponentBase implements ITextComponent
{
    protected /* synthetic */ List<ITextComponent> siblings;
    private /* synthetic */ Style style;
    
    @Override
    public List<ITextComponent> getSiblings() {
        return this.siblings;
    }
    
    @Override
    public ITextComponent appendText(final String llllllllllllllIlIIlIlIIIlllIlIll) {
        return this.appendSibling(new TextComponentString(llllllllllllllIlIIlIlIIIlllIlIll));
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIlIlIIIlIlIllII) {
        if (this == llllllllllllllIlIIlIlIIIlIlIllII) {
            return true;
        }
        if (!(llllllllllllllIlIIlIlIIIlIlIllII instanceof TextComponentBase)) {
            return false;
        }
        final TextComponentBase llllllllllllllIlIIlIlIIIlIlIlllI = (TextComponentBase)llllllllllllllIlIIlIlIIIlIlIllII;
        return this.siblings.equals(llllllllllllllIlIIlIlIIIlIlIlllI.siblings) && this.getStyle().equals(llllllllllllllIlIIlIlIIIlIlIlllI.getStyle());
    }
    
    @Override
    public Style getStyle() {
        if (this.style == null) {
            this.style = new Style();
            for (final ITextComponent llllllllllllllIlIIlIlIIIllIllIIl : this.siblings) {
                llllllllllllllIlIIlIlIIIllIllIIl.getStyle().setParentStyle(this.style);
            }
        }
        return this.style;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.style.hashCode() + this.siblings.hashCode();
    }
    
    @Override
    public ITextComponent appendSibling(final ITextComponent llllllllllllllIlIIlIlIIIllllIIlI) {
        llllllllllllllIlIIlIlIIIllllIIlI.getStyle().setParentStyle(this.getStyle());
        this.siblings.add(llllllllllllllIlIIlIlIIIllllIIlI);
        return this;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("BaseComponent{style=").append(this.style).append(", siblings=").append(this.siblings).append('}'));
    }
    
    public TextComponentBase() {
        this.siblings = (List<ITextComponent>)Lists.newArrayList();
    }
    
    @Override
    public Iterator<ITextComponent> iterator() {
        return (Iterator<ITextComponent>)Iterators.concat((Iterator)Iterators.forArray((Object[])new TextComponentBase[] { this }), (Iterator)createDeepCopyIterator(this.siblings));
    }
    
    public static Iterator<ITextComponent> createDeepCopyIterator(final Iterable<ITextComponent> llllllllllllllIlIIlIlIIIlIllIlll) {
        Iterator<ITextComponent> llllllllllllllIlIIlIlIIIlIllIllI = (Iterator<ITextComponent>)Iterators.concat(Iterators.transform((Iterator)llllllllllllllIlIIlIlIIIlIllIlll.iterator(), (Function)new Function<ITextComponent, Iterator<ITextComponent>>() {
            public Iterator<ITextComponent> apply(@Nullable final ITextComponent lllllllllllllIllIIIlIllllllIIlIl) {
                return lllllllllllllIllIIIlIllllllIIlIl.iterator();
            }
        }));
        llllllllllllllIlIIlIlIIIlIllIllI = (Iterator<ITextComponent>)Iterators.transform((Iterator)llllllllllllllIlIIlIlIIIlIllIllI, (Function)new Function<ITextComponent, ITextComponent>() {
            public ITextComponent apply(@Nullable final ITextComponent llllllllllllllIllIIIlIIllIIIllIl) {
                final ITextComponent llllllllllllllIllIIIlIIllIIIllII = llllllllllllllIllIIIlIIllIIIllIl.createCopy();
                llllllllllllllIllIIIlIIllIIIllII.setStyle(llllllllllllllIllIIIlIIllIIIllII.getStyle().createDeepCopy());
                return llllllllllllllIllIIIlIIllIIIllII;
            }
        });
        return llllllllllllllIlIIlIlIIIlIllIllI;
    }
    
    @Override
    public ITextComponent setStyle(final Style llllllllllllllIlIIlIlIIIlllIIIll) {
        this.style = llllllllllllllIlIIlIlIIIlllIIIll;
        for (final ITextComponent llllllllllllllIlIIlIlIIIlllIIIlI : this.siblings) {
            llllllllllllllIlIIlIlIIIlllIIIlI.getStyle().setParentStyle(this.getStyle());
        }
        return this;
    }
    
    @Override
    public final String getFormattedText() {
        final StringBuilder llllllllllllllIlIIlIlIIIllIIIIIl = new StringBuilder();
        for (final ITextComponent llllllllllllllIlIIlIlIIIllIIIIII : this) {
            final String llllllllllllllIlIIlIlIIIlIllllll = llllllllllllllIlIIlIlIIIllIIIIII.getUnformattedComponentText();
            if (!llllllllllllllIlIIlIlIIIlIllllll.isEmpty()) {
                llllllllllllllIlIIlIlIIIllIIIIIl.append(llllllllllllllIlIIlIlIIIllIIIIII.getStyle().getFormattingCode());
                llllllllllllllIlIIlIlIIIllIIIIIl.append(llllllllllllllIlIIlIlIIIlIllllll);
                llllllllllllllIlIIlIlIIIllIIIIIl.append(TextFormatting.RESET);
            }
        }
        return String.valueOf(llllllllllllllIlIIlIlIIIllIIIIIl);
    }
    
    @Override
    public final String getUnformattedText() {
        final StringBuilder llllllllllllllIlIIlIlIIIllIIllIl = new StringBuilder();
        for (final ITextComponent llllllllllllllIlIIlIlIIIllIIllII : this) {
            llllllllllllllIlIIlIlIIIllIIllIl.append(llllllllllllllIlIIlIlIIIllIIllII.getUnformattedComponentText());
        }
        return String.valueOf(llllllllllllllIlIIlIlIIIllIIllIl);
    }
}
