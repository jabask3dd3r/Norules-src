package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;

public class ImpossibleTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192205_a;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lIIllIlIlIlIII, final Listener<Instance> lIIllIlIlIIlll) {
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ImpossibleTrigger.field_192205_a;
    }
    
    static {
        field_192205_a = new ResourceLocation("impossible");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lIIllIlIlIlIll, final Listener<Instance> lIIllIlIlIlIlI) {
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lIIllIlIlIIIll, final JsonDeserializationContext lIIllIlIlIIIlI) {
        return new Instance();
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lIIllIlIlIIlIl) {
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        public Instance() {
            super(ImpossibleTrigger.field_192205_a);
        }
    }
}
