package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import java.util.*;
import com.google.common.collect.*;

public class TickTrigger implements ICriterionTrigger<Instance>
{
    public static final /* synthetic */ ResourceLocation field_193183_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193184_b;
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllllIlIIlllIIlllIIlII) {
        this.field_193184_b.remove(lllllllllllllllIlIIlllIIlllIIlII);
    }
    
    public TickTrigger() {
        this.field_193184_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public void func_193182_a(final EntityPlayerMP lllllllllllllllIlIIlllIIllIllIlI) {
        final Listeners lllllllllllllllIlIIlllIIllIllIIl = this.field_193184_b.get(lllllllllllllllIlIIlllIIllIllIlI.func_192039_O());
        if (lllllllllllllllIlIIlllIIllIllIIl != null) {
            lllllllllllllllIlIIlllIIllIllIIl.func_193503_b();
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllllIlIIlllIIlllIIIII, final JsonDeserializationContext lllllllllllllllIlIIlllIIllIlllll) {
        return new Instance();
    }
    
    static {
        field_193183_a = new ResourceLocation("tick");
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return TickTrigger.field_193183_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllllIlIIlllIIlllllIlI, final Listener<Instance> lllllllllllllllIlIIlllIIllllIlIl) {
        Listeners lllllllllllllllIlIIlllIIlllllIII = this.field_193184_b.get(lllllllllllllllIlIIlllIIlllllIlI);
        if (lllllllllllllllIlIIlllIIlllllIII == null) {
            lllllllllllllllIlIIlllIIlllllIII = new Listeners(lllllllllllllllIlIIlllIIlllllIlI);
            this.field_193184_b.put(lllllllllllllllIlIIlllIIlllllIlI, lllllllllllllllIlIIlllIIlllllIII);
        }
        lllllllllllllllIlIIlllIIlllllIII.func_193502_a(lllllllllllllllIlIIlllIIllllIlIl);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllllIlIIlllIIlllIlIlI, final Listener<Instance> lllllllllllllllIlIIlllIIlllIlIIl) {
        final Listeners lllllllllllllllIlIIlllIIlllIllII = this.field_193184_b.get(lllllllllllllllIlIIlllIIlllIlIlI);
        if (lllllllllllllllIlIIlllIIlllIllII != null) {
            lllllllllllllllIlIIlllIIlllIllII.func_193500_b(lllllllllllllllIlIIlllIIlllIlIIl);
            if (lllllllllllllllIlIIlllIIlllIllII.func_193501_a()) {
                this.field_193184_b.remove(lllllllllllllllIlIIlllIIlllIlIlI);
            }
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193505_b;
        private final /* synthetic */ PlayerAdvancements field_193504_a;
        
        public void func_193502_a(final Listener<Instance> lIlllIllIIIlIII) {
            this.field_193505_b.add(lIlllIllIIIlIII);
        }
        
        public boolean func_193501_a() {
            return this.field_193505_b.isEmpty();
        }
        
        public void func_193503_b() {
            for (final Listener<Instance> lIlllIlIlllllIl : Lists.newArrayList((Iterable)this.field_193505_b)) {
                lIlllIlIlllllIl.func_192159_a(this.field_193504_a);
            }
        }
        
        public void func_193500_b(final Listener<Instance> lIlllIllIIIIIlI) {
            this.field_193505_b.remove(lIlllIllIIIIIlI);
        }
        
        public Listeners(final PlayerAdvancements lIlllIllIIlIIIl) {
            this.field_193505_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193504_a = lIlllIllIIlIIIl;
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        public Instance() {
            super(TickTrigger.field_193183_a);
        }
    }
}
