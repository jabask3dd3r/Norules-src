package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.*;
import com.google.common.collect.*;

public class ConsumeItemTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193150_b;
    private static final /* synthetic */ ResourceLocation field_193149_a;
    
    @Override
    public ResourceLocation func_192163_a() {
        return ConsumeItemTrigger.field_193149_a;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIllllIlIlIllIIlll, final JsonDeserializationContext lllllllllllllIlIllllIlIlIllIlIIl) {
        final ItemPredicate lllllllllllllIlIllllIlIlIllIlIII = ItemPredicate.func_192492_a(lllllllllllllIlIllllIlIlIllIIlll.get("item"));
        return new Instance(lllllllllllllIlIllllIlIlIllIlIII);
    }
    
    public ConsumeItemTrigger() {
        this.field_193150_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_193149_a = new ResourceLocation("consume_item");
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIllllIlIlIllllIlI, final Listener<Instance> lllllllllllllIlIllllIlIlIllllIIl) {
        final Listeners lllllllllllllIlIllllIlIlIllllIII = this.field_193150_b.get(lllllllllllllIlIllllIlIlIllllIlI);
        if (lllllllllllllIlIllllIlIlIllllIII != null) {
            lllllllllllllIlIllllIlIlIllllIII.func_193237_b(lllllllllllllIlIllllIlIlIllllIIl);
            if (lllllllllllllIlIllllIlIlIllllIII.func_193238_a()) {
                this.field_193150_b.remove(lllllllllllllIlIllllIlIlIllllIlI);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIllllIlIllIIIIIlI, final Listener<Instance> lllllllllllllIlIllllIlIllIIIIIIl) {
        Listeners lllllllllllllIlIllllIlIllIIIIlII = this.field_193150_b.get(lllllllllllllIlIllllIlIllIIIIIlI);
        if (lllllllllllllIlIllllIlIllIIIIlII == null) {
            lllllllllllllIlIllllIlIllIIIIlII = new Listeners(lllllllllllllIlIllllIlIllIIIIIlI);
            this.field_193150_b.put(lllllllllllllIlIllllIlIllIIIIIlI, lllllllllllllIlIllllIlIllIIIIlII);
        }
        lllllllllllllIlIllllIlIllIIIIlII.func_193239_a(lllllllllllllIlIllllIlIllIIIIIIl);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIllllIlIlIlllIIII) {
        this.field_193150_b.remove(lllllllllllllIlIllllIlIlIlllIIII);
    }
    
    public void func_193148_a(final EntityPlayerMP lllllllllllllIlIllllIlIlIlIlllII, final ItemStack lllllllllllllIlIllllIlIlIlIllIll) {
        final Listeners lllllllllllllIlIllllIlIlIlIllllI = this.field_193150_b.get(lllllllllllllIlIllllIlIlIlIlllII.func_192039_O());
        if (lllllllllllllIlIllllIlIlIlIllllI != null) {
            lllllllllllllIlIllllIlIlIlIllllI.func_193240_a(lllllllllllllIlIllllIlIlIlIllIll);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_193194_a;
        
        public boolean func_193193_a(final ItemStack llllllllllllllIIllIlIlIIllIIllIl) {
            return this.field_193194_a.func_192493_a(llllllllllllllIIllIlIlIIllIIllIl);
        }
        
        public Instance(final ItemPredicate llllllllllllllIIllIlIlIIllIlIlIl) {
            super(ConsumeItemTrigger.field_193149_a);
            this.field_193194_a = llllllllllllllIIllIlIlIIllIlIlIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193241_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193242_b;
        
        public void func_193240_a(final ItemStack lllllllllllllIIlIlIlllllllIIIlll) {
            List<Listener<Instance>> lllllllllllllIIlIlIlllllllIIIllI = null;
            for (final Listener<Instance> lllllllllllllIIlIlIlllllllIIIlIl : this.field_193242_b) {
                if (lllllllllllllIIlIlIlllllllIIIlIl.func_192158_a().func_193193_a(lllllllllllllIIlIlIlllllllIIIlll)) {
                    if (lllllllllllllIIlIlIlllllllIIIllI == null) {
                        lllllllllllllIIlIlIlllllllIIIllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIlIlIlllllllIIIllI.add(lllllllllllllIIlIlIlllllllIIIlIl);
                }
            }
            if (lllllllllllllIIlIlIlllllllIIIllI != null) {
                for (final Listener<Instance> lllllllllllllIIlIlIlllllllIIIlII : lllllllllllllIIlIlIlllllllIIIllI) {
                    lllllllllllllIIlIlIlllllllIIIlII.func_192159_a(this.field_193241_a);
                }
            }
        }
        
        public void func_193239_a(final Listener<Instance> lllllllllllllIIlIlIlllllllIlIlII) {
            this.field_193242_b.add(lllllllllllllIIlIlIlllllllIlIlII);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIlIlIlllllllIlllll) {
            this.field_193242_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193241_a = lllllllllllllIIlIlIlllllllIlllll;
        }
        
        public void func_193237_b(final Listener<Instance> lllllllllllllIIlIlIlllllllIlIIII) {
            this.field_193242_b.remove(lllllllllllllIIlIlIlllllllIlIIII);
        }
        
        public boolean func_193238_a() {
            return this.field_193242_b.isEmpty();
        }
    }
}
