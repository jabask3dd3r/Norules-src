package net.minecraft.util.text;

import com.google.common.annotations.*;
import java.util.regex.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.text.translation.*;

public class TextComponentTranslation extends TextComponentBase
{
    private final /* synthetic */ Object[] formatArgs;
    private /* synthetic */ long lastTranslationUpdateTimeInMilliseconds;
    public static final /* synthetic */ Pattern STRING_VARIABLE_PATTERN;
    private final /* synthetic */ Object syncLock;
    @VisibleForTesting
    /* synthetic */ List<ITextComponent> children;
    private final /* synthetic */ String key;
    
    static {
        STRING_VARIABLE_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
    }
    
    public String getKey() {
        return this.key;
    }
    
    @Override
    public ITextComponent setStyle(final Style llllllllllllllllllIIllIIIlllIIII) {
        super.setStyle(llllllllllllllllllIIllIIIlllIIII);
        final double llllllllllllllllllIIllIIIllIlIII;
        final char llllllllllllllllllIIllIIIllIlIIl = (char)((Object[])(Object)(llllllllllllllllllIIllIIIllIlIII = (double)this.formatArgs)).length;
        for (Exception llllllllllllllllllIIllIIIllIlIlI = (Exception)0; llllllllllllllllllIIllIIIllIlIlI < llllllllllllllllllIIllIIIllIlIIl; ++llllllllllllllllllIIllIIIllIlIlI) {
            final Object llllllllllllllllllIIllIIIllIllll = llllllllllllllllllIIllIIIllIlIII[llllllllllllllllllIIllIIIllIlIlI];
            if (llllllllllllllllllIIllIIIllIllll instanceof ITextComponent) {
                ((ITextComponent)llllllllllllllllllIIllIIIllIllll).getStyle().setParentStyle(this.getStyle());
            }
        }
        if (this.lastTranslationUpdateTimeInMilliseconds > -1L) {
            for (final ITextComponent llllllllllllllllllIIllIIIllIlllI : this.children) {
                llllllllllllllllllIIllIIIllIlllI.getStyle().setParentStyle(llllllllllllllllllIIllIIIlllIIII);
            }
        }
        return this;
    }
    
    public Object[] getFormatArgs() {
        return this.formatArgs;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllllllIIllIIIIlllllI = super.hashCode();
        llllllllllllllllllIIllIIIIlllllI = 31 * llllllllllllllllllIIllIIIIlllllI + this.key.hashCode();
        llllllllllllllllllIIllIIIIlllllI = 31 * llllllllllllllllllIIllIIIIlllllI + Arrays.hashCode(this.formatArgs);
        return llllllllllllllllllIIllIIIIlllllI;
    }
    
    @Override
    public TextComponentTranslation createCopy() {
        final Object[] llllllllllllllllllIIllIIIlIlIIll = new Object[this.formatArgs.length];
        for (int llllllllllllllllllIIllIIIlIlIIlI = 0; llllllllllllllllllIIllIIIlIlIIlI < this.formatArgs.length; ++llllllllllllllllllIIllIIIlIlIIlI) {
            if (this.formatArgs[llllllllllllllllllIIllIIIlIlIIlI] instanceof ITextComponent) {
                llllllllllllllllllIIllIIIlIlIIll[llllllllllllllllllIIllIIIlIlIIlI] = ((ITextComponent)this.formatArgs[llllllllllllllllllIIllIIIlIlIIlI]).createCopy();
            }
            else {
                llllllllllllllllllIIllIIIlIlIIll[llllllllllllllllllIIllIIIlIlIIlI] = this.formatArgs[llllllllllllllllllIIllIIIlIlIIlI];
            }
        }
        final TextComponentTranslation llllllllllllllllllIIllIIIlIlIIIl = new TextComponentTranslation(this.key, llllllllllllllllllIIllIIIlIlIIll);
        llllllllllllllllllIIllIIIlIlIIIl.setStyle(this.getStyle().createShallowCopy());
        for (final ITextComponent llllllllllllllllllIIllIIIlIlIIII : this.getSiblings()) {
            llllllllllllllllllIIllIIIlIlIIIl.appendSibling(llllllllllllllllllIIllIIIlIlIIII.createCopy());
        }
        return llllllllllllllllllIIllIIIlIlIIIl;
    }
    
    private ITextComponent getFormatArgumentAsComponent(final int llllllllllllllllllIIllIIIllllIlI) {
        if (llllllllllllllllllIIllIIIllllIlI >= this.formatArgs.length) {
            throw new TextComponentTranslationFormatException(this, llllllllllllllllllIIllIIIllllIlI);
        }
        final Object llllllllllllllllllIIllIIIllllllI = this.formatArgs[llllllllllllllllllIIllIIIllllIlI];
        ITextComponent llllllllllllllllllIIllIIIlllllII = null;
        if (llllllllllllllllllIIllIIIllllllI instanceof ITextComponent) {
            final ITextComponent llllllllllllllllllIIllIIIlllllIl = (ITextComponent)llllllllllllllllllIIllIIIllllllI;
        }
        else {
            llllllllllllllllllIIllIIIlllllII = new TextComponentString((llllllllllllllllllIIllIIIllllllI == null) ? "null" : llllllllllllllllllIIllIIIllllllI.toString());
            llllllllllllllllllIIllIIIlllllII.getStyle().setParentStyle(this.getStyle());
        }
        return llllllllllllllllllIIllIIIlllllII;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllllIIllIIIlIIIIll) {
        if (this == llllllllllllllllllIIllIIIlIIIIll) {
            return true;
        }
        if (!(llllllllllllllllllIIllIIIlIIIIll instanceof TextComponentTranslation)) {
            return false;
        }
        final TextComponentTranslation llllllllllllllllllIIllIIIlIIIlIl = (TextComponentTranslation)llllllllllllllllllIIllIIIlIIIIll;
        return Arrays.equals(this.formatArgs, llllllllllllllllllIIllIIIlIIIlIl.formatArgs) && this.key.equals(llllllllllllllllllIIllIIIlIIIlIl.key) && super.equals(llllllllllllllllllIIllIIIlIIIIll);
    }
    
    public TextComponentTranslation(final String llllllllllllllllllIIllIIllIIIIII, final Object... llllllllllllllllllIIllIIlIllllll) {
        this.syncLock = new Object();
        this.lastTranslationUpdateTimeInMilliseconds = -1L;
        this.children = (List<ITextComponent>)Lists.newArrayList();
        this.key = llllllllllllllllllIIllIIllIIIIII;
        this.formatArgs = llllllllllllllllllIIllIIlIllllll;
        final double llllllllllllllllllIIllIIlIllIlll = (double)llllllllllllllllllIIllIIlIllllll;
        final double llllllllllllllllllIIllIIlIlllIII = llllllllllllllllllIIllIIlIllllll.length;
        for (String llllllllllllllllllIIllIIlIlllIIl = (String)0; llllllllllllllllllIIllIIlIlllIIl < llllllllllllllllllIIllIIlIlllIII; ++llllllllllllllllllIIllIIlIlllIIl) {
            final Object llllllllllllllllllIIllIIlIlllllI = llllllllllllllllllIIllIIlIllIlll[llllllllllllllllllIIllIIlIlllIIl];
            if (llllllllllllllllllIIllIIlIlllllI instanceof ITextComponent) {
                ((ITextComponent)llllllllllllllllllIIllIIlIlllllI).getStyle().setParentStyle(this.getStyle());
            }
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TranslatableComponent{key='").append(this.key).append('\'').append(", args=").append(Arrays.toString(this.formatArgs)).append(", siblings=").append(this.siblings).append(", style=").append(this.getStyle()).append('}'));
    }
    
    @Override
    public String getUnformattedComponentText() {
        this.ensureInitialized();
        final StringBuilder llllllllllllllllllIIllIIIlIlllll = new StringBuilder();
        for (final ITextComponent llllllllllllllllllIIllIIIlIllllI : this.children) {
            llllllllllllllllllIIllIIIlIlllll.append(llllllllllllllllllIIllIIIlIllllI.getUnformattedComponentText());
        }
        return String.valueOf(llllllllllllllllllIIllIIIlIlllll);
    }
    
    protected void initializeFromFormat(final String llllllllllllllllllIIllIIlIIIllll) {
        final boolean llllllllllllllllllIIllIIlIIllllI = false;
        final Matcher llllllllllllllllllIIllIIlIIlllIl = TextComponentTranslation.STRING_VARIABLE_PATTERN.matcher(llllllllllllllllllIIllIIlIIIllll);
        int llllllllllllllllllIIllIIlIIlllII = 0;
        int llllllllllllllllllIIllIIlIIllIll = 0;
        try {
            while (llllllllllllllllllIIllIIlIIlllIl.find(llllllllllllllllllIIllIIlIIllIll)) {
                final int llllllllllllllllllIIllIIlIIllIIl = llllllllllllllllllIIllIIlIIlllIl.start();
                final int llllllllllllllllllIIllIIlIIllIlI = llllllllllllllllllIIllIIlIIlllIl.end();
                if (llllllllllllllllllIIllIIlIIllIIl > llllllllllllllllllIIllIIlIIllIll) {
                    final TextComponentString llllllllllllllllllIIllIIlIIllIII = new TextComponentString(String.format(llllllllllllllllllIIllIIlIIIllll.substring(llllllllllllllllllIIllIIlIIllIll, llllllllllllllllllIIllIIlIIllIIl), new Object[0]));
                    llllllllllllllllllIIllIIlIIllIII.getStyle().setParentStyle(this.getStyle());
                    this.children.add(llllllllllllllllllIIllIIlIIllIII);
                }
                final String llllllllllllllllllIIllIIlIIlIlll = llllllllllllllllllIIllIIlIIlllIl.group(2);
                final String llllllllllllllllllIIllIIlIIlIllI = llllllllllllllllllIIllIIlIIIllll.substring(llllllllllllllllllIIllIIlIIllIIl, llllllllllllllllllIIllIIlIIllIlI);
                if ("%".equals(llllllllllllllllllIIllIIlIIlIlll) && "%%".equals(llllllllllllllllllIIllIIlIIlIllI)) {
                    final TextComponentString llllllllllllllllllIIllIIlIIlIlIl = new TextComponentString("%");
                    llllllllllllllllllIIllIIlIIlIlIl.getStyle().setParentStyle(this.getStyle());
                    this.children.add(llllllllllllllllllIIllIIlIIlIlIl);
                }
                else {
                    if (!"s".equals(llllllllllllllllllIIllIIlIIlIlll)) {
                        throw new TextComponentTranslationFormatException(this, String.valueOf(new StringBuilder("Unsupported format: '").append(llllllllllllllllllIIllIIlIIlIllI).append("'")));
                    }
                    final String llllllllllllllllllIIllIIlIIlIlII = llllllllllllllllllIIllIIlIIlllIl.group(1);
                    final int llllllllllllllllllIIllIIlIIlIIll = (llllllllllllllllllIIllIIlIIlIlII != null) ? (Integer.parseInt(llllllllllllllllllIIllIIlIIlIlII) - 1) : llllllllllllllllllIIllIIlIIlllII++;
                    if (llllllllllllllllllIIllIIlIIlIIll < this.formatArgs.length) {
                        this.children.add(this.getFormatArgumentAsComponent(llllllllllllllllllIIllIIlIIlIIll));
                    }
                }
                llllllllllllllllllIIllIIlIIllIll = llllllllllllllllllIIllIIlIIllIlI;
            }
            if (llllllllllllllllllIIllIIlIIllIll < llllllllllllllllllIIllIIlIIIllll.length()) {
                final TextComponentString llllllllllllllllllIIllIIlIIlIIlI = new TextComponentString(String.format(llllllllllllllllllIIllIIlIIIllll.substring(llllllllllllllllllIIllIIlIIllIll), new Object[0]));
                llllllllllllllllllIIllIIlIIlIIlI.getStyle().setParentStyle(this.getStyle());
                this.children.add(llllllllllllllllllIIllIIlIIlIIlI);
            }
        }
        catch (IllegalFormatException llllllllllllllllllIIllIIlIIlIIIl) {
            throw new TextComponentTranslationFormatException(this, llllllllllllllllllIIllIIlIIlIIIl);
        }
    }
    
    @Override
    public Iterator<ITextComponent> iterator() {
        this.ensureInitialized();
        return (Iterator<ITextComponent>)Iterators.concat((Iterator)TextComponentBase.createDeepCopyIterator(this.children), (Iterator)TextComponentBase.createDeepCopyIterator(this.siblings));
    }
    
    @VisibleForTesting
    synchronized void ensureInitialized() {
        synchronized (this.syncLock) {
            final long llllllllllllllllllIIllIIlIllIIlI = I18n.getLastTranslationUpdateTimeInMilliseconds();
            if (llllllllllllllllllIIllIIlIllIIlI == this.lastTranslationUpdateTimeInMilliseconds) {
                // monitorexit(this.syncLock)
                return;
            }
            this.lastTranslationUpdateTimeInMilliseconds = llllllllllllllllllIIllIIlIllIIlI;
            this.children.clear();
        }
        // monitorexit(this.syncLock)
        try {
            this.initializeFromFormat(I18n.translateToLocal(this.key));
        }
        catch (TextComponentTranslationFormatException llllllllllllllllllIIllIIlIllIIIl) {
            this.children.clear();
            try {
                this.initializeFromFormat(I18n.translateToFallback(this.key));
            }
            catch (TextComponentTranslationFormatException llllllllllllllllllIIllIIlIllIIII) {
                throw llllllllllllllllllIIllIIlIllIIIl;
            }
        }
    }
}
