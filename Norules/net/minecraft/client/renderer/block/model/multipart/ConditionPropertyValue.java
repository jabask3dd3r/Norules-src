package net.minecraft.client.renderer.block.model.multipart;

import net.minecraft.block.properties.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import java.util.*;
import com.google.common.base.*;

public class ConditionPropertyValue implements ICondition
{
    private final /* synthetic */ String value;
    private static final /* synthetic */ Splitter SPLITTER;
    private final /* synthetic */ String key;
    
    public ConditionPropertyValue(final String llllllllllllllIlllllIIIIllIllllI, final String llllllllllllllIlllllIIIIlllIIIII) {
        this.key = llllllllllllllIlllllIIIIllIllllI;
        this.value = llllllllllllllIlllllIIIIlllIIIII;
    }
    
    private Predicate<IBlockState> makePredicate(final IProperty<?> llllllllllllllIlllllIIIIlIllllIl, final String llllllllllllllIlllllIIIIllIIIIII) {
        final Optional<?> llllllllllllllIlllllIIIIlIllllll = llllllllllllllIlllllIIIIlIllllIl.parseValue(llllllllllllllIlllllIIIIllIIIIII);
        if (!llllllllllllllIlllllIIIIlIllllll.isPresent()) {
            throw new RuntimeException(String.valueOf(new StringBuilder(String.valueOf(this.toString())).append(": has an unknown value: ").append(this.value)));
        }
        return (Predicate<IBlockState>)new Predicate<IBlockState>() {
            public boolean apply(@Nullable final IBlockState lllllllllllllllIlllIllllIIIlIIll) {
                return lllllllllllllllIlllIllllIIIlIIll != null && lllllllllllllllIlllIllllIIIlIIll.getValue(llllllllllllllIlllllIIIIlIllllIl).equals(llllllllllllllIlllllIIIIlIllllll.get());
            }
        };
    }
    
    static {
        SPLITTER = Splitter.on('|').omitEmptyStrings();
    }
    
    @Override
    public Predicate<IBlockState> getPredicate(final BlockStateContainer llllllllllllllIlllllIIIIllIlIlII) {
        final IProperty<?> llllllllllllllIlllllIIIIllIlIIll = llllllllllllllIlllllIIIIllIlIlII.getProperty(this.key);
        if (llllllllllllllIlllllIIIIllIlIIll == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder(String.valueOf(this.toString())).append(": Definition: ").append(llllllllllllllIlllllIIIIllIlIlII).append(" has no property: ").append(this.key)));
        }
        String llllllllllllllIlllllIIIIllIlIIlI = this.value;
        final boolean llllllllllllllIlllllIIIIllIlIIIl = !llllllllllllllIlllllIIIIllIlIIlI.isEmpty() && llllllllllllllIlllllIIIIllIlIIlI.charAt(0) == '!';
        if (llllllllllllllIlllllIIIIllIlIIIl) {
            llllllllllllllIlllllIIIIllIlIIlI = llllllllllllllIlllllIIIIllIlIIlI.substring(1);
        }
        final List<String> llllllllllllllIlllllIIIIllIlIIII = (List<String>)ConditionPropertyValue.SPLITTER.splitToList((CharSequence)llllllllllllllIlllllIIIIllIlIIlI);
        if (llllllllllllllIlllllIIIIllIlIIII.isEmpty()) {
            throw new RuntimeException(String.valueOf(new StringBuilder(String.valueOf(this.toString())).append(": has an empty value: ").append(this.value)));
        }
        Predicate<IBlockState> llllllllllllllIlllllIIIIllIIlllI = null;
        if (llllllllllllllIlllllIIIIllIlIIII.size() == 1) {
            final Predicate<IBlockState> llllllllllllllIlllllIIIIllIIllll = this.makePredicate(llllllllllllllIlllllIIIIllIlIIll, llllllllllllllIlllllIIIIllIlIIlI);
        }
        else {
            llllllllllllllIlllllIIIIllIIlllI = (Predicate<IBlockState>)Predicates.or(Iterables.transform((Iterable)llllllllllllllIlllllIIIIllIlIIII, (Function)new Function<String, Predicate<IBlockState>>() {
                @Nullable
                public Predicate<IBlockState> apply(@Nullable final String llllllllllllllllllIIlllllIlllIlI) {
                    return ConditionPropertyValue.this.makePredicate(llllllllllllllIlllllIIIIllIlIIll, llllllllllllllllllIIlllllIlllIlI);
                }
            }));
        }
        return (Predicate<IBlockState>)(llllllllllllllIlllllIIIIllIlIIIl ? Predicates.not((Predicate)llllllllllllllIlllllIIIIllIIlllI) : llllllllllllllIlllllIIIIllIIlllI);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("key", (Object)this.key).add("value", (Object)this.value).toString();
    }
}
