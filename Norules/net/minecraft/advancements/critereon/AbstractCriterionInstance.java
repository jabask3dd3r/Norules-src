package net.minecraft.advancements.critereon;

import net.minecraft.advancements.*;
import net.minecraft.util.*;

public class AbstractCriterionInstance implements ICriterionInstance
{
    private final /* synthetic */ ResourceLocation field_192245_a;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("AbstractCriterionInstance{criterion=").append(this.field_192245_a).append('}'));
    }
    
    @Override
    public ResourceLocation func_192244_a() {
        return this.field_192245_a;
    }
    
    public AbstractCriterionInstance(final ResourceLocation lllllllllllllIllllllIlIIIIlIlllI) {
        this.field_192245_a = lllllllllllllIllllllIlIIIIlIlllI;
    }
}
