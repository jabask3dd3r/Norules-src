package net.minecraft.client.renderer.block.model.multipart;

import net.minecraft.block.state.*;
import javax.annotation.*;
import com.google.common.collect.*;
import com.google.common.base.*;

public class ConditionAnd implements ICondition
{
    private final /* synthetic */ Iterable<ICondition> conditions;
    
    public ConditionAnd(final Iterable<ICondition> lllllllllllllIIIllIIlIlllIllIlIl) {
        this.conditions = lllllllllllllIIIllIIlIlllIllIlIl;
    }
    
    @Override
    public Predicate<IBlockState> getPredicate(final BlockStateContainer lllllllllllllIIIllIIlIlllIllIIIl) {
        return (Predicate<IBlockState>)Predicates.and(Iterables.transform((Iterable)this.conditions, (Function)new Function<ICondition, Predicate<IBlockState>>() {
            @Nullable
            public Predicate<IBlockState> apply(@Nullable final ICondition llllllllllllllIIlllIIlIIIIlllIlI) {
                return (llllllllllllllIIlllIIlIIIIlllIlI == null) ? null : llllllllllllllIIlllIIlIIIIlllIlI.getPredicate(lllllllllllllIIIllIIlIlllIllIIIl);
            }
        }));
    }
}
