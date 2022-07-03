package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.entity.*;

public class TameAnimalTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193180_b;
    private static final /* synthetic */ ResourceLocation field_193179_a;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIllIlIllIlIlIIIIIll, final Listener<Instance> lllllllllllllIllIlIllIlIlIIIIIlI) {
        Listeners lllllllllllllIllIlIllIlIlIIIIlIl = this.field_193180_b.get(lllllllllllllIllIlIllIlIlIIIIIll);
        if (lllllllllllllIllIlIllIlIlIIIIlIl == null) {
            lllllllllllllIllIlIllIlIlIIIIlIl = new Listeners(lllllllllllllIllIlIllIlIlIIIIIll);
            this.field_193180_b.put(lllllllllllllIllIlIllIlIlIIIIIll, lllllllllllllIllIlIllIlIlIIIIlIl);
        }
        lllllllllllllIllIlIllIlIlIIIIlIl.func_193496_a(lllllllllllllIllIlIllIlIlIIIIIlI);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIllIlIllIlIIllIlIII, final JsonDeserializationContext lllllllllllllIllIlIllIlIIllIlIlI) {
        final EntityPredicate lllllllllllllIllIlIllIlIIllIlIIl = EntityPredicate.func_192481_a(lllllllllllllIllIlIllIlIIllIlIII.get("entity"));
        return new Instance(lllllllllllllIllIlIllIlIIllIlIIl);
    }
    
    static {
        field_193179_a = new ResourceLocation("tame_animal");
    }
    
    public void func_193178_a(final EntityPlayerMP lllllllllllllIllIlIllIlIIlIlllIl, final EntityAnimal lllllllllllllIllIlIllIlIIllIIIII) {
        final Listeners lllllllllllllIllIlIllIlIIlIlllll = this.field_193180_b.get(lllllllllllllIllIlIllIlIIlIlllIl.func_192039_O());
        if (lllllllllllllIllIlIllIlIIlIlllll != null) {
            lllllllllllllIllIlIllIlIIlIlllll.func_193497_a(lllllllllllllIllIlIllIlIIlIlllIl, lllllllllllllIllIlIllIlIIllIIIII);
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return TameAnimalTrigger.field_193179_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIllIlIllIlIIllllIll, final Listener<Instance> lllllllllllllIllIlIllIlIIlllIllI) {
        final Listeners lllllllllllllIllIlIllIlIIllllIIl = this.field_193180_b.get(lllllllllllllIllIlIllIlIIllllIll);
        if (lllllllllllllIllIlIllIlIIllllIIl != null) {
            lllllllllllllIllIlIllIlIIllllIIl.func_193494_b(lllllllllllllIllIlIllIlIIlllIllI);
            if (lllllllllllllIllIlIllIlIIllllIIl.func_193495_a()) {
                this.field_193180_b.remove(lllllllllllllIllIlIllIlIIllllIll);
            }
        }
    }
    
    public TameAnimalTrigger() {
        this.field_193180_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIllIlIllIlIIllIllll) {
        this.field_193180_b.remove(lllllllllllllIllIlIllIlIIllIllll);
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193498_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193499_b;
        
        public Listeners(final PlayerAdvancements lllllllllllllIlIlIllllIIIIlIIlll) {
            this.field_193499_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193498_a = lllllllllllllIlIlIllllIIIIlIIlll;
        }
        
        public void func_193494_b(final Listener<Instance> lllllllllllllIlIlIllllIIIIIllIlI) {
            this.field_193499_b.remove(lllllllllllllIlIlIllllIIIIIllIlI);
        }
        
        public void func_193497_a(final EntityPlayerMP lllllllllllllIlIlIllllIIIIIlIIII, final EntityAnimal lllllllllllllIlIlIllllIIIIIIlIIl) {
            List<Listener<Instance>> lllllllllllllIlIlIllllIIIIIIlllI = null;
            for (final Listener<Instance> lllllllllllllIlIlIllllIIIIIIllIl : this.field_193499_b) {
                if (lllllllllllllIlIlIllllIIIIIIllIl.func_192158_a().func_193216_a(lllllllllllllIlIlIllllIIIIIlIIII, lllllllllllllIlIlIllllIIIIIIlIIl)) {
                    if (lllllllllllllIlIlIllllIIIIIIlllI == null) {
                        lllllllllllllIlIlIllllIIIIIIlllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIlIlIllllIIIIIIlllI.add(lllllllllllllIlIlIllllIIIIIIllIl);
                }
            }
            if (lllllllllllllIlIlIllllIIIIIIlllI != null) {
                for (final Listener<Instance> lllllllllllllIlIlIllllIIIIIIllII : lllllllllllllIlIlIllllIIIIIIlllI) {
                    lllllllllllllIlIlIllllIIIIIIllII.func_192159_a(this.field_193498_a);
                }
            }
        }
        
        public void func_193496_a(final Listener<Instance> lllllllllllllIlIlIllllIIIIIllllI) {
            this.field_193499_b.add(lllllllllllllIlIlIllllIIIIIllllI);
        }
        
        public boolean func_193495_a() {
            return this.field_193499_b.isEmpty();
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_193217_a;
        
        public Instance(final EntityPredicate lllllllllllllIIIIIIlIIIlIIlIIlIl) {
            super(TameAnimalTrigger.field_193179_a);
            this.field_193217_a = lllllllllllllIIIIIIlIIIlIIlIIlIl;
        }
        
        public boolean func_193216_a(final EntityPlayerMP lllllllllllllIIIIIIlIIIlIIIlIlll, final EntityAnimal lllllllllllllIIIIIIlIIIlIIIllIIl) {
            return this.field_193217_a.func_192482_a(lllllllllllllIIIIIIlIIIlIIIlIlll, lllllllllllllIIIIIIlIIIlIIIllIIl);
        }
    }
}
