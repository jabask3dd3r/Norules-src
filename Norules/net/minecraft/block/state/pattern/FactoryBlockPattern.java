package net.minecraft.block.state.pattern;

import java.util.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import org.apache.commons.lang3.*;
import java.lang.reflect.*;

public class FactoryBlockPattern
{
    private /* synthetic */ int rowWidth;
    private static final /* synthetic */ Joiner COMMA_JOIN;
    private final /* synthetic */ List<String[]> depth;
    private /* synthetic */ int aisleHeight;
    private final /* synthetic */ Map<Character, Predicate<BlockWorldState>> symbolMap;
    
    private void checkMissingPredicates() {
        final List<Character> lllllllllllllIlIIIIllIIIIIIlIlll = (List<Character>)Lists.newArrayList();
        for (final Map.Entry<Character, Predicate<BlockWorldState>> lllllllllllllIlIIIIllIIIIIIlIllI : this.symbolMap.entrySet()) {
            if (lllllllllllllIlIIIIllIIIIIIlIllI.getValue() == null) {
                lllllllllllllIlIIIIllIIIIIIlIlll.add(lllllllllllllIlIIIIllIIIIIIlIllI.getKey());
            }
        }
        if (!lllllllllllllIlIIIIllIIIIIIlIlll.isEmpty()) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Predicates for character(s) ").append(FactoryBlockPattern.COMMA_JOIN.join((Iterable)lllllllllllllIlIIIIllIIIIIIlIlll)).append(" are missing")));
        }
    }
    
    private FactoryBlockPattern() {
        this.depth = (List<String[]>)Lists.newArrayList();
        this.symbolMap = (Map<Character, Predicate<BlockWorldState>>)Maps.newHashMap();
        this.symbolMap.put(' ', (Predicate<BlockWorldState>)Predicates.alwaysTrue());
    }
    
    public BlockPattern build() {
        return new BlockPattern(this.makePredicateArray());
    }
    
    public FactoryBlockPattern where(final char lllllllllllllIlIIIIllIIIIIllIIII, final Predicate<BlockWorldState> lllllllllllllIlIIIIllIIIIIllIIlI) {
        this.symbolMap.put(lllllllllllllIlIIIIllIIIIIllIIII, lllllllllllllIlIIIIllIIIIIllIIlI);
        return this;
    }
    
    public static FactoryBlockPattern start() {
        return new FactoryBlockPattern();
    }
    
    static {
        COMMA_JOIN = Joiner.on(",");
    }
    
    public FactoryBlockPattern aisle(final String... lllllllllllllIlIIIIllIIIIlIIIlII) {
        if (ArrayUtils.isEmpty((Object[])lllllllllllllIlIIIIllIIIIlIIIlII) || StringUtils.isEmpty((CharSequence)lllllllllllllIlIIIIllIIIIlIIIlII[0])) {
            throw new IllegalArgumentException("Empty pattern for aisle");
        }
        if (this.depth.isEmpty()) {
            this.aisleHeight = lllllllllllllIlIIIIllIIIIlIIIlII.length;
            this.rowWidth = lllllllllllllIlIIIIllIIIIlIIIlII[0].length();
        }
        if (lllllllllllllIlIIIIllIIIIlIIIlII.length != this.aisleHeight) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Expected aisle with height of ").append(this.aisleHeight).append(", but was given one with a height of ").append(lllllllllllllIlIIIIllIIIIlIIIlII.length).append(")")));
        }
        final String lllllllllllllIlIIIIllIIIIIllllII = (Object)lllllllllllllIlIIIIllIIIIlIIIlII;
        final short lllllllllllllIlIIIIllIIIIIllllIl = (short)lllllllllllllIlIIIIllIIIIlIIIlII.length;
        for (byte lllllllllllllIlIIIIllIIIIIlllllI = 0; lllllllllllllIlIIIIllIIIIIlllllI < lllllllllllllIlIIIIllIIIIIllllIl; ++lllllllllllllIlIIIIllIIIIIlllllI) {
            final String lllllllllllllIlIIIIllIIIIlIIIIll = lllllllllllllIlIIIIllIIIIIllllII[lllllllllllllIlIIIIllIIIIIlllllI];
            if (lllllllllllllIlIIIIllIIIIlIIIIll.length() != this.rowWidth) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Not all rows in the given aisle are the correct width (expected ").append(this.rowWidth).append(", found one with ").append(lllllllllllllIlIIIIllIIIIlIIIIll.length()).append(")")));
            }
            final short lllllllllllllIlIIIIllIIIIIlllIII;
            final short lllllllllllllIlIIIIllIIIIIlllIIl = (short)((char[])(Object)(lllllllllllllIlIIIIllIIIIIlllIII = (short)(Object)lllllllllllllIlIIIIllIIIIlIIIIll.toCharArray())).length;
            for (String lllllllllllllIlIIIIllIIIIIlllIlI = (String)0; lllllllllllllIlIIIIllIIIIIlllIlI < lllllllllllllIlIIIIllIIIIIlllIIl; ++lllllllllllllIlIIIIllIIIIIlllIlI) {
                final char lllllllllllllIlIIIIllIIIIlIIIIlI = lllllllllllllIlIIIIllIIIIIlllIII[lllllllllllllIlIIIIllIIIIIlllIlI];
                if (!this.symbolMap.containsKey(lllllllllllllIlIIIIllIIIIlIIIIlI)) {
                    this.symbolMap.put(lllllllllllllIlIIIIllIIIIlIIIIlI, null);
                }
            }
        }
        this.depth.add(lllllllllllllIlIIIIllIIIIlIIIlII);
        return this;
    }
    
    private Predicate<BlockWorldState>[][][] makePredicateArray() {
        this.checkMissingPredicates();
        final Predicate[][][] lllllllllllllIlIIIIllIIIIIlIIlIl = (Predicate[][][])Array.newInstance(Predicate.class, this.depth.size(), this.aisleHeight, this.rowWidth);
        for (int lllllllllllllIlIIIIllIIIIIlIIlII = 0; lllllllllllllIlIIIIllIIIIIlIIlII < this.depth.size(); ++lllllllllllllIlIIIIllIIIIIlIIlII) {
            for (int lllllllllllllIlIIIIllIIIIIlIIIll = 0; lllllllllllllIlIIIIllIIIIIlIIIll < this.aisleHeight; ++lllllllllllllIlIIIIllIIIIIlIIIll) {
                for (int lllllllllllllIlIIIIllIIIIIlIIIlI = 0; lllllllllllllIlIIIIllIIIIIlIIIlI < this.rowWidth; ++lllllllllllllIlIIIIllIIIIIlIIIlI) {
                    lllllllllllllIlIIIIllIIIIIlIIlIl[lllllllllllllIlIIIIllIIIIIlIIlII][lllllllllllllIlIIIIllIIIIIlIIIll][lllllllllllllIlIIIIllIIIIIlIIIlI] = this.symbolMap.get(this.depth.get(lllllllllllllIlIIIIllIIIIIlIIlII)[lllllllllllllIlIIIIllIIIIIlIIIll].charAt(lllllllllllllIlIIIIllIIIIIlIIIlI));
                }
            }
        }
        return (Predicate<BlockWorldState>[][][])lllllllllllllIlIIIIllIIIIIlIIlIl;
    }
}
