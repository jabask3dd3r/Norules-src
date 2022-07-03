package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import java.util.*;

public class SummonedEntityTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192232_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192233_b;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIIIlIlIIIIllIlIl, final Listener<Instance> lllllllllllllIlIIIIlIlIIIIllIlII) {
        Listeners lllllllllllllIlIIIIlIlIIIIllIlll = this.field_192233_b.get(lllllllllllllIlIIIIlIlIIIIllIlIl);
        if (lllllllllllllIlIIIIlIlIIIIllIlll == null) {
            lllllllllllllIlIIIIlIlIIIIllIlll = new Listeners(lllllllllllllIlIIIIlIlIIIIllIlIl);
            this.field_192233_b.put(lllllllllllllIlIIIIlIlIIIIllIlIl, lllllllllllllIlIIIIlIlIIIIllIlll);
        }
        lllllllllllllIlIIIIlIlIIIIllIlll.func_192534_a(lllllllllllllIlIIIIlIlIIIIllIlII);
    }
    
    public SummonedEntityTrigger() {
        this.field_192233_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_192232_a = new ResourceLocation("summoned_entity");
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIIIlIlIIIIlIlIIl, final Listener<Instance> lllllllllllllIlIIIIlIlIIIIlIlIII) {
        final Listeners lllllllllllllIlIIIIlIlIIIIlIlIll = this.field_192233_b.get(lllllllllllllIlIIIIlIlIIIIlIlIIl);
        if (lllllllllllllIlIIIIlIlIIIIlIlIll != null) {
            lllllllllllllIlIIIIlIlIIIIlIlIll.func_192531_b(lllllllllllllIlIIIIlIlIIIIlIlIII);
            if (lllllllllllllIlIIIIlIlIIIIlIlIll.func_192532_a()) {
                this.field_192233_b.remove(lllllllllllllIlIIIIlIlIIIIlIlIIl);
            }
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIIIlIlIIIIIllIlI, final JsonDeserializationContext lllllllllllllIlIIIIlIlIIIIIlllII) {
        final EntityPredicate lllllllllllllIlIIIIlIlIIIIIllIll = EntityPredicate.func_192481_a(lllllllllllllIlIIIIlIlIIIIIllIlI.get("entity"));
        return new Instance(lllllllllllllIlIIIIlIlIIIIIllIll);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return SummonedEntityTrigger.field_192232_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIIIlIlIIIIlIIIIl) {
        this.field_192233_b.remove(lllllllllllllIlIIIIlIlIIIIlIIIIl);
    }
    
    public void func_192229_a(final EntityPlayerMP lllllllllllllIlIIIIlIlIIIIIIllll, final Entity lllllllllllllIlIIIIlIlIIIIIlIIlI) {
        final Listeners lllllllllllllIlIIIIlIlIIIIIlIIIl = this.field_192233_b.get(lllllllllllllIlIIIIlIlIIIIIIllll.func_192039_O());
        if (lllllllllllllIlIIIIlIlIIIIIlIIIl != null) {
            lllllllllllllIlIIIIlIlIIIIIlIIIl.func_192533_a(lllllllllllllIlIIIIlIlIIIIIIllll, lllllllllllllIlIIIIlIlIIIIIlIIlI);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192284_a;
        
        public boolean func_192283_a(final EntityPlayerMP lllllllllllllIIIIIlIIllllIlIIIIl, final Entity lllllllllllllIIIIIlIIllllIlIIIII) {
            return this.field_192284_a.func_192482_a(lllllllllllllIIIIIlIIllllIlIIIIl, lllllllllllllIIIIIlIIllllIlIIIII);
        }
        
        public Instance(final EntityPredicate lllllllllllllIIIIIlIIllllIlIIllI) {
            super(SummonedEntityTrigger.field_192232_a);
            this.field_192284_a = lllllllllllllIIIIIlIIllllIlIIllI;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192536_b;
        private final /* synthetic */ PlayerAdvancements field_192535_a;
        
        public boolean func_192532_a() {
            return this.field_192536_b.isEmpty();
        }
        
        public void func_192534_a(final Listener<Instance> llllllllllllllIIIIIIlIlIIlllIIIl) {
            this.field_192536_b.add(llllllllllllllIIIIIIlIlIIlllIIIl);
        }
        
        public void func_192531_b(final Listener<Instance> llllllllllllllIIIIIIlIlIIllIlIIl) {
            this.field_192536_b.remove(llllllllllllllIIIIIIlIlIIllIlIIl);
        }
        
        public Listeners(final PlayerAdvancements llllllllllllllIIIIIIlIlIlIllIlIl) {
            this.field_192536_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192535_a = llllllllllllllIIIIIIlIlIlIllIlIl;
        }
        
        public void func_192533_a(final EntityPlayerMP llllllllllllllIIIIIIlIlIIllIIIIl, final Entity llllllllllllllIIIIIIlIlIIlIllIlI) {
            List<Listener<Instance>> llllllllllllllIIIIIIlIlIIlIlllll = null;
            for (final Listener<Instance> llllllllllllllIIIIIIlIlIIlIllllI : this.field_192536_b) {
                if (llllllllllllllIIIIIIlIlIIlIllllI.func_192158_a().func_192283_a(llllllllllllllIIIIIIlIlIIllIIIIl, llllllllllllllIIIIIIlIlIIlIllIlI)) {
                    if (llllllllllllllIIIIIIlIlIIlIlllll == null) {
                        llllllllllllllIIIIIIlIlIIlIlllll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIIIIIIlIlIIlIlllll.add(llllllllllllllIIIIIIlIlIIlIllllI);
                }
            }
            if (llllllllllllllIIIIIIlIlIIlIlllll != null) {
                for (final Listener<Instance> llllllllllllllIIIIIIlIlIIlIlllIl : llllllllllllllIIIIIIlIlIIlIlllll) {
                    llllllllllllllIIIIIIlIlIIlIlllIl.func_192159_a(this.field_192535_a);
                }
            }
        }
    }
}
