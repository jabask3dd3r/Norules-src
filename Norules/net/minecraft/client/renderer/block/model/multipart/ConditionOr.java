package net.minecraft.client.renderer.block.model.multipart;

import net.minecraft.block.state.*;
import javax.annotation.*;
import com.google.common.collect.*;
import com.google.common.base.*;

public class ConditionOr implements ICondition
{
    final /* synthetic */ Iterable<ICondition> conditions;
    
    public ConditionOr(final Iterable<ICondition> lllllllllllllIlIIIIIIlllIlIIIlII) {
        this.conditions = lllllllllllllIlIIIIIIlllIlIIIlII;
    }
    
    @Override
    public Predicate<IBlockState> getPredicate(final BlockStateContainer lllllllllllllIlIIIIIIlllIIllllII) {
        return (Predicate<IBlockState>)Predicates.or(Iterables.transform((Iterable)this.conditions, (Function)new Function<ICondition, Predicate<IBlockState>>() {
            @Nullable
            public Predicate<IBlockState> apply(@Nullable final ICondition lllllllllllllIlIIIlIlIlIIIllIllI) {
                return (lllllllllllllIlIIIlIlIlIIIllIllI == null) ? null : lllllllllllllIlIIIlIlIlIIIllIllI.getPredicate(lllllllllllllIlIIIIIIlllIIllllII);
            }
        }));
    }
}
