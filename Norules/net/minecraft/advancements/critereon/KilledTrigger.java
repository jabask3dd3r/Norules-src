package net.minecraft.advancements.critereon;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import com.google.common.collect.*;
import java.util.*;

public class KilledTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ ResourceLocation field_192214_b;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192213_a;
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllllllIllIlIllllllIlll, final Listener<Instance> llllllllllllllllIllIlIllllllIllI) {
        final Listeners llllllllllllllllIllIlIllllllIlIl = this.field_192213_a.get(llllllllllllllllIllIlIllllllIlll);
        if (llllllllllllllllIllIlIllllllIlIl != null) {
            llllllllllllllllIllIlIllllllIlIl.func_192501_b(llllllllllllllllIllIlIllllllIllI);
            if (llllllllllllllllIllIlIllllllIlIl.func_192502_a()) {
                this.field_192213_a.remove(llllllllllllllllIllIlIllllllIlll);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllllllIllIllIIIIIIIIll, final Listener<Instance> llllllllllllllllIllIlIlllllllllI) {
        Listeners llllllllllllllllIllIllIIIIIIIIIl = this.field_192213_a.get(llllllllllllllllIllIllIIIIIIIIll);
        if (llllllllllllllllIllIllIIIIIIIIIl == null) {
            llllllllllllllllIllIllIIIIIIIIIl = new Listeners(llllllllllllllllIllIllIIIIIIIIll);
            this.field_192213_a.put(llllllllllllllllIllIllIIIIIIIIll, llllllllllllllllIllIllIIIIIIIIIl);
        }
        llllllllllllllllIllIllIIIIIIIIIl.func_192504_a(llllllllllllllllIllIlIlllllllllI);
    }
    
    public void func_192211_a(final EntityPlayerMP llllllllllllllllIllIlIllllIlllIl, final Entity llllllllllllllllIllIlIllllIlllII, final DamageSource llllllllllllllllIllIlIllllIlIllI) {
        final Listeners llllllllllllllllIllIlIllllIllIlI = this.field_192213_a.get(llllllllllllllllIllIlIllllIlllIl.func_192039_O());
        if (llllllllllllllllIllIlIllllIllIlI != null) {
            llllllllllllllllIllIlIllllIllIlI.func_192503_a(llllllllllllllllIllIlIllllIlllIl, llllllllllllllllIllIlIllllIlllII, llllllllllllllllIllIlIllllIlIllI);
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllllllIllIlIlllllIlIll) {
        this.field_192213_a.remove(llllllllllllllllIllIlIlllllIlIll);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllllllIllIlIlllllIIlII, final JsonDeserializationContext llllllllllllllllIllIlIlllllIIllI) {
        return new Instance(this.field_192214_b, EntityPredicate.func_192481_a(llllllllllllllllIllIlIlllllIIlII.get("entity")), DamageSourcePredicate.func_192447_a(llllllllllllllllIllIlIlllllIIlII.get("killing_blow")));
    }
    
    public KilledTrigger(final ResourceLocation llllllllllllllllIllIllIIIIIIlllI) {
        this.field_192213_a = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
        this.field_192214_b = llllllllllllllllIllIllIIIIIIlllI;
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return this.field_192214_b;
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DamageSourcePredicate field_192272_b;
        private final /* synthetic */ EntityPredicate field_192271_a;
        
        public Instance(final ResourceLocation lllllllllllllIllIlllIIllIIlllIIl, final EntityPredicate lllllllllllllIllIlllIIllIIllllII, final DamageSourcePredicate lllllllllllllIllIlllIIllIIllIlll) {
            super(lllllllllllllIllIlllIIllIIlllIIl);
            this.field_192271_a = lllllllllllllIllIlllIIllIIllllII;
            this.field_192272_b = lllllllllllllIllIlllIIllIIllIlll;
        }
        
        public boolean func_192270_a(final EntityPlayerMP lllllllllllllIllIlllIIllIIlIllIl, final Entity lllllllllllllIllIlllIIllIIlIllII, final DamageSource lllllllllllllIllIlllIIllIIlIllll) {
            return this.field_192272_b.func_193418_a(lllllllllllllIllIlllIIllIIlIllIl, lllllllllllllIllIlllIIllIIlIllll) && this.field_192271_a.func_192482_a(lllllllllllllIllIlllIIllIIlIllIl, lllllllllllllIllIlllIIllIIlIllII);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192505_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192506_b;
        
        public boolean func_192502_a() {
            return this.field_192506_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llIllIlIIIlII) {
            this.field_192506_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192505_a = llIllIlIIIlII;
        }
        
        public void func_192503_a(final EntityPlayerMP llIllIIlIIIll, final Entity llIllIIlIIIlI, final DamageSource llIllIIlIIIIl) {
            List<Listener<Instance>> llIllIIlIIlll = null;
            for (final Listener<Instance> llIllIIlIIllI : this.field_192506_b) {
                if (llIllIIlIIllI.func_192158_a().func_192270_a(llIllIIlIIIll, llIllIIlIIIlI, llIllIIlIIIIl)) {
                    if (llIllIIlIIlll == null) {
                        llIllIIlIIlll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llIllIIlIIlll.add(llIllIIlIIllI);
                }
            }
            if (llIllIIlIIlll != null) {
                for (final Listener<Instance> llIllIIlIIlIl : llIllIIlIIlll) {
                    llIllIIlIIlIl.func_192159_a(this.field_192505_a);
                }
            }
        }
        
        public void func_192504_a(final Listener<Instance> llIllIIlllIll) {
            this.field_192506_b.add(llIllIIlllIll);
        }
        
        public void func_192501_b(final Listener<Instance> llIllIIllIIll) {
            this.field_192506_b.remove(llIllIIllIIll);
        }
    }
}
