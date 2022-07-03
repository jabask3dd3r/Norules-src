package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import java.util.*;

public class BredAnimalsTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192171_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192172_b;
    
    @Override
    public ResourceLocation func_192163_a() {
        return BredAnimalsTrigger.field_192171_a;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllllIIlIllIIIIIIllIlll, final JsonDeserializationContext llllllllllllllIIlIllIIIIIIlllIll) {
        final EntityPredicate llllllllllllllIIlIllIIIIIIlllIlI = EntityPredicate.func_192481_a(llllllllllllllIIlIllIIIIIIllIlll.get("parent"));
        final EntityPredicate llllllllllllllIIlIllIIIIIIlllIIl = EntityPredicate.func_192481_a(llllllllllllllIIlIllIIIIIIllIlll.get("partner"));
        final EntityPredicate llllllllllllllIIlIllIIIIIIlllIII = EntityPredicate.func_192481_a(llllllllllllllIIlIllIIIIIIllIlll.get("child"));
        return new Instance(llllllllllllllIIlIllIIIIIIlllIlI, llllllllllllllIIlIllIIIIIIlllIIl, llllllllllllllIIlIllIIIIIIlllIII);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllllIIlIllIIIIIlIIIIlI) {
        this.field_192172_b.remove(llllllllllllllIIlIllIIIIIlIIIIlI);
    }
    
    public void func_192168_a(final EntityPlayerMP llllllllllllllIIlIllIIIIIIlIIllI, final EntityAnimal llllllllllllllIIlIllIIIIIIlIIlIl, final EntityAnimal llllllllllllllIIlIllIIIIIIlIlIlI, final EntityAgeable llllllllllllllIIlIllIIIIIIlIlIIl) {
        final Listeners llllllllllllllIIlIllIIIIIIlIlIII = this.field_192172_b.get(llllllllllllllIIlIllIIIIIIlIIllI.func_192039_O());
        if (llllllllllllllIIlIllIIIIIIlIlIII != null) {
            llllllllllllllIIlIllIIIIIIlIlIII.func_192342_a(llllllllllllllIIlIllIIIIIIlIIllI, llllllllllllllIIlIllIIIIIIlIIlIl, llllllllllllllIIlIllIIIIIIlIlIlI, llllllllllllllIIlIllIIIIIIlIlIIl);
        }
    }
    
    static {
        field_192171_a = new ResourceLocation("bred_animals");
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllllIIlIllIIIIIlIIlIlI, final Listener<Instance> llllllllllllllIIlIllIIIIIlIIllIl) {
        final Listeners llllllllllllllIIlIllIIIIIlIIllII = this.field_192172_b.get(llllllllllllllIIlIllIIIIIlIIlIlI);
        if (llllllllllllllIIlIllIIIIIlIIllII != null) {
            llllllllllllllIIlIllIIIIIlIIllII.func_192340_b(llllllllllllllIIlIllIIIIIlIIllIl);
            if (llllllllllllllIIlIllIIIIIlIIllII.func_192341_a()) {
                this.field_192172_b.remove(llllllllllllllIIlIllIIIIIlIIlIlI);
            }
        }
    }
    
    public BredAnimalsTrigger() {
        this.field_192172_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllllIIlIllIIIIIlIllIlI, final Listener<Instance> llllllllllllllIIlIllIIIIIlIllIIl) {
        Listeners llllllllllllllIIlIllIIIIIlIllIII = this.field_192172_b.get(llllllllllllllIIlIllIIIIIlIllIlI);
        if (llllllllllllllIIlIllIIIIIlIllIII == null) {
            llllllllllllllIIlIllIIIIIlIllIII = new Listeners(llllllllllllllIIlIllIIIIIlIllIlI);
            this.field_192172_b.put(llllllllllllllIIlIllIIIIIlIllIlI, llllllllllllllIIlIllIIIIIlIllIII);
        }
        llllllllllllllIIlIllIIIIIlIllIII.func_192343_a(llllllllllllllIIlIllIIIIIlIllIIl);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192247_a;
        private final /* synthetic */ EntityPredicate field_192248_b;
        private final /* synthetic */ EntityPredicate field_192249_c;
        
        public boolean func_192246_a(final EntityPlayerMP llllllllllllllllIllIllIIIIllIllI, final EntityAnimal llllllllllllllllIllIllIIIIllIIII, final EntityAnimal llllllllllllllllIllIllIIIIlIllll, final EntityAgeable llllllllllllllllIllIllIIIIlIlllI) {
            return this.field_192249_c.func_192482_a(llllllllllllllllIllIllIIIIllIllI, llllllllllllllllIllIllIIIIlIlllI) && ((this.field_192247_a.func_192482_a(llllllllllllllllIllIllIIIIllIllI, llllllllllllllllIllIllIIIIllIIII) && this.field_192248_b.func_192482_a(llllllllllllllllIllIllIIIIllIllI, llllllllllllllllIllIllIIIIlIllll)) || (this.field_192247_a.func_192482_a(llllllllllllllllIllIllIIIIllIllI, llllllllllllllllIllIllIIIIlIllll) && this.field_192248_b.func_192482_a(llllllllllllllllIllIllIIIIllIllI, llllllllllllllllIllIllIIIIllIIII)));
        }
        
        public Instance(final EntityPredicate llllllllllllllllIllIllIIIlIIIIll, final EntityPredicate llllllllllllllllIllIllIIIIlllllI, final EntityPredicate llllllllllllllllIllIllIIIIllllIl) {
            super(BredAnimalsTrigger.field_192171_a);
            this.field_192247_a = llllllllllllllllIllIllIIIlIIIIll;
            this.field_192248_b = llllllllllllllllIllIllIIIIlllllI;
            this.field_192249_c = llllllllllllllllIllIllIIIIllllIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192345_b;
        private final /* synthetic */ PlayerAdvancements field_192344_a;
        
        public void func_192343_a(final Listener<Instance> lllllllllllllIIllllIlIlIlIlllllI) {
            this.field_192345_b.add(lllllllllllllIIllllIlIlIlIlllllI);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIllllIlIlIllIIIlll) {
            this.field_192345_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192344_a = lllllllllllllIIllllIlIlIllIIIlll;
        }
        
        public boolean func_192341_a() {
            return this.field_192345_b.isEmpty();
        }
        
        public void func_192340_b(final Listener<Instance> lllllllllllllIIllllIlIlIlIlllIII) {
            this.field_192345_b.remove(lllllllllllllIIllllIlIlIlIlllIII);
        }
        
        public void func_192342_a(final EntityPlayerMP lllllllllllllIIllllIlIlIlIlIIllI, final EntityAnimal lllllllllllllIIllllIlIlIlIlIIlIl, final EntityAnimal lllllllllllllIIllllIlIlIlIlIllII, final EntityAgeable lllllllllllllIIllllIlIlIlIlIlIll) {
            List<Listener<Instance>> lllllllllllllIIllllIlIlIlIlIlIlI = null;
            for (final Listener<Instance> lllllllllllllIIllllIlIlIlIlIlIIl : this.field_192345_b) {
                if (lllllllllllllIIllllIlIlIlIlIlIIl.func_192158_a().func_192246_a(lllllllllllllIIllllIlIlIlIlIIllI, lllllllllllllIIllllIlIlIlIlIIlIl, lllllllllllllIIllllIlIlIlIlIllII, lllllllllllllIIllllIlIlIlIlIlIll)) {
                    if (lllllllllllllIIllllIlIlIlIlIlIlI == null) {
                        lllllllllllllIIllllIlIlIlIlIlIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIllllIlIlIlIlIlIlI.add(lllllllllllllIIllllIlIlIlIlIlIIl);
                }
            }
            if (lllllllllllllIIllllIlIlIlIlIlIlI != null) {
                for (final Listener<Instance> lllllllllllllIIllllIlIlIlIlIlIII : lllllllllllllIIllllIlIlIlIlIlIlI) {
                    lllllllllllllIIllllIlIlIlIlIlIII.func_192159_a(this.field_192344_a);
                }
            }
        }
    }
}
