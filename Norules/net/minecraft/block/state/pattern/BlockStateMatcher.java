package net.minecraft.block.state.pattern;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.block.properties.*;
import javax.annotation.*;
import net.minecraft.block.*;
import com.google.common.collect.*;

public class BlockStateMatcher implements Predicate<IBlockState>
{
    private final /* synthetic */ BlockStateContainer blockstate;
    private final /* synthetic */ Map<IProperty<?>, Predicate<?>> propertyPredicates;
    
    public <V extends Comparable<V>> BlockStateMatcher where(final IProperty<V> lllllllllllllIIlIllIIIIllIlIIIIl, final Predicate<? extends V> lllllllllllllIIlIllIIIIllIlIIIll) {
        if (!this.blockstate.getProperties().contains(lllllllllllllIIlIllIIIIllIlIIIIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(this.blockstate).append(" cannot support property ").append(lllllllllllllIIlIllIIIIllIlIIIIl)));
        }
        this.propertyPredicates.put(lllllllllllllIIlIllIIIIllIlIIIIl, lllllllllllllIIlIllIIIIllIlIIIll);
        return this;
    }
    
    protected <T extends Comparable<T>> boolean matches(final IBlockState lllllllllllllIIlIllIIIIllIlIlllI, final IProperty<T> lllllllllllllIIlIllIIIIllIlIllIl, final Predicate<T> lllllllllllllIIlIllIIIIllIlIlIIl) {
        return lllllllllllllIIlIllIIIIllIlIlIIl.apply((Object)lllllllllllllIIlIllIIIIllIlIlllI.getValue(lllllllllllllIIlIllIIIIllIlIllIl));
    }
    
    static {
        ANY = (Predicate)new Predicate<IBlockState>() {
            public boolean apply(@Nullable final IBlockState llllllllllllIlllllIlIllIIIllIllI) {
                return true;
            }
        };
    }
    
    public boolean apply(@Nullable final IBlockState lllllllllllllIIlIllIIIIllIllIlIl) {
        if (lllllllllllllIIlIllIIIIllIllIlIl == null || !lllllllllllllIIlIllIIIIllIllIlIl.getBlock().equals(this.blockstate.getBlock())) {
            return false;
        }
        if (this.propertyPredicates.isEmpty()) {
            return true;
        }
        for (final Map.Entry<IProperty<?>, Predicate<?>> lllllllllllllIIlIllIIIIllIllIlll : this.propertyPredicates.entrySet()) {
            if (!this.matches(lllllllllllllIIlIllIIIIllIllIlIl, lllllllllllllIIlIllIIIIllIllIlll.getKey(), lllllllllllllIIlIllIIIIllIllIlll.getValue())) {
                return false;
            }
        }
        return true;
    }
    
    public static BlockStateMatcher forBlock(final Block lllllllllllllIIlIllIIIIllIlllllI) {
        return new BlockStateMatcher(lllllllllllllIIlIllIIIIllIlllllI.getBlockState());
    }
    
    private BlockStateMatcher(final BlockStateContainer lllllllllllllIIlIllIIIIlllIIIIIl) {
        this.propertyPredicates = (Map<IProperty<?>, Predicate<?>>)Maps.newHashMap();
        this.blockstate = lllllllllllllIIlIllIIIIlllIIIIIl;
    }
}
