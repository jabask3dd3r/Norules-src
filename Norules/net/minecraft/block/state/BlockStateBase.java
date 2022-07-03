package net.minecraft.block.state;

import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public abstract class BlockStateBase implements IBlockState
{
    private static final /* synthetic */ Function<Map.Entry<IProperty<?>, Comparable<?>>, String> MAP_ENTRY_TO_STRING;
    private /* synthetic */ int blockId;
    private static final /* synthetic */ Joiner COMMA_JOINER;
    private /* synthetic */ int metadata;
    private /* synthetic */ ResourceLocation blockLocation;
    private /* synthetic */ int blockStateId;
    
    public ResourceLocation getBlockLocation() {
        if (this.blockLocation == null) {
            this.blockLocation = Block.REGISTRY.getNameForObject(this.getBlock());
        }
        return this.blockLocation;
    }
    
    public int getBlockId() {
        if (this.blockId < 0) {
            this.blockId = Block.getIdFromBlock(this.getBlock());
        }
        return this.blockId;
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIlIIIIIIlIlIIlIllI = new StringBuilder();
        lllllllllllllIIlIIIIIIlIlIIlIllI.append(Block.REGISTRY.getNameForObject(this.getBlock()));
        if (!this.getProperties().isEmpty()) {
            lllllllllllllIIlIIIIIIlIlIIlIllI.append("[");
            BlockStateBase.COMMA_JOINER.appendTo(lllllllllllllIIlIIIIIIlIlIIlIllI, Iterables.transform((Iterable)this.getProperties().entrySet(), (Function)BlockStateBase.MAP_ENTRY_TO_STRING));
            lllllllllllllIIlIIIIIIlIlIIlIllI.append("]");
        }
        return String.valueOf(lllllllllllllIIlIIIIIIlIlIIlIllI);
    }
    
    public BlockStateBase() {
        this.blockId = -1;
        this.blockStateId = -1;
        this.metadata = -1;
        this.blockLocation = null;
    }
    
    static {
        COMMA_JOINER = Joiner.on(',');
        MAP_ENTRY_TO_STRING = (Function)new Function<Map.Entry<IProperty<?>, Comparable<?>>, String>() {
            private <T extends Comparable<T>> String getPropertyName(final IProperty<T> lllllllllllllIllllIllllIIIllIlII, final Comparable<?> lllllllllllllIllllIllllIIIllIIll) {
                return lllllllllllllIllllIllllIIIllIlII.getName((T)lllllllllllllIllllIllllIIIllIIll);
            }
            
            @Nullable
            public String apply(@Nullable final Map.Entry<IProperty<?>, Comparable<?>> lllllllllllllIllllIllllIIIlllllI) {
                if (lllllllllllllIllllIllllIIIlllllI == null) {
                    return "<NULL>";
                }
                final IProperty<?> lllllllllllllIllllIllllIIIllllIl = lllllllllllllIllllIllllIIIlllllI.getKey();
                return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIllllIIIllllIl.getName())).append("=").append(this.getPropertyName(lllllllllllllIllllIllllIIIllllIl, lllllllllllllIllllIllllIIIlllllI.getValue())));
            }
        };
    }
    
    public int getMetadata() {
        if (this.metadata < 0) {
            this.metadata = this.getBlock().getMetaFromState(this);
        }
        return this.metadata;
    }
    
    public int getBlockStateId() {
        if (this.blockStateId < 0) {
            this.blockStateId = Block.getStateId(this);
        }
        return this.blockStateId;
    }
    
    public ImmutableTable<IProperty<?>, Comparable<?>, IBlockState> getPropertyValueTable() {
        return null;
    }
    
    protected static <T> T cyclePropertyValue(final Collection<T> lllllllllllllIIlIIIIIIlIlIIlllll, final T lllllllllllllIIlIIIIIIlIlIIllIll) {
        final Iterator<T> lllllllllllllIIlIIIIIIlIlIIlllIl = lllllllllllllIIlIIIIIIlIlIIlllll.iterator();
        while (lllllllllllllIIlIIIIIIlIlIIlllIl.hasNext()) {
            if (lllllllllllllIIlIIIIIIlIlIIlllIl.next().equals(lllllllllllllIIlIIIIIIlIlIIllIll)) {
                if (lllllllllllllIIlIIIIIIlIlIIlllIl.hasNext()) {
                    return lllllllllllllIIlIIIIIIlIlIIlllIl.next();
                }
                return lllllllllllllIIlIIIIIIlIlIIlllll.iterator().next();
            }
        }
        return lllllllllllllIIlIIIIIIlIlIIlllIl.next();
    }
    
    @Override
    public <T extends Comparable<T>> IBlockState cycleProperty(final IProperty<T> lllllllllllllIIlIIIIIIlIlIlIIlIl) {
        return this.withProperty(lllllllllllllIIlIIIIIIlIlIlIIlIl, (Comparable)cyclePropertyValue((Collection<V>)lllllllllllllIIlIIIIIIlIlIlIIlIl.getAllowedValues(), (V)this.getValue((IProperty<T>)lllllllllllllIIlIIIIIIlIlIlIIlIl)));
    }
}
