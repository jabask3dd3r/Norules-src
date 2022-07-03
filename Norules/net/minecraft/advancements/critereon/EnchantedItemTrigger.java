package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.advancements.*;
import java.util.*;
import com.google.common.collect.*;

public class EnchantedItemTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192191_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192192_b;
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIIlIIIIllllIlIlI) {
        this.field_192192_b.remove(lllllllllllllIlIIIlIIIIllllIlIlI);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIIlIIIIllllllllI, final Listener<Instance> lllllllllllllIlIIIlIIIlIIIIIIIIl) {
        Listeners lllllllllllllIlIIIlIIIlIIIIIIIII = this.field_192192_b.get(lllllllllllllIlIIIlIIIIllllllllI);
        if (lllllllllllllIlIIIlIIIlIIIIIIIII == null) {
            lllllllllllllIlIIIlIIIlIIIIIIIII = new Listeners(lllllllllllllIlIIIlIIIIllllllllI);
            this.field_192192_b.put(lllllllllllllIlIIIlIIIIllllllllI, lllllllllllllIlIIIlIIIlIIIIIIIII);
        }
        lllllllllllllIlIIIlIIIlIIIIIIIII.func_192460_a(lllllllllllllIlIIIlIIIlIIIIIIIIl);
    }
    
    public EnchantedItemTrigger() {
        this.field_192192_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIIlIIIIllllIIlIl, final JsonDeserializationContext lllllllllllllIlIIIlIIIIllllIIlII) {
        final ItemPredicate lllllllllllllIlIIIlIIIIllllIIIll = ItemPredicate.func_192492_a(lllllllllllllIlIIIlIIIIllllIIlIl.get("item"));
        final MinMaxBounds lllllllllllllIlIIIlIIIIllllIIIlI = MinMaxBounds.func_192515_a(lllllllllllllIlIIIlIIIIllllIIlIl.get("levels"));
        return new Instance(lllllllllllllIlIIIlIIIIllllIIIll, lllllllllllllIlIIIlIIIIllllIIIlI);
    }
    
    public void func_192190_a(final EntityPlayerMP lllllllllllllIlIIIlIIIIlllIlIIll, final ItemStack lllllllllllllIlIIIlIIIIlllIlIIlI, final int lllllllllllllIlIIIlIIIIlllIlIIIl) {
        final Listeners lllllllllllllIlIIIlIIIIlllIlIlIl = this.field_192192_b.get(lllllllllllllIlIIIlIIIIlllIlIIll.func_192039_O());
        if (lllllllllllllIlIIIlIIIIlllIlIlIl != null) {
            lllllllllllllIlIIIlIIIIlllIlIlIl.func_192459_a(lllllllllllllIlIIIlIIIIlllIlIIlI, lllllllllllllIlIIIlIIIIlllIlIIIl);
        }
    }
    
    static {
        field_192191_a = new ResourceLocation("enchanted_item");
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EnchantedItemTrigger.field_192191_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIIlIIIIlllllIIlI, final Listener<Instance> lllllllllllllIlIIIlIIIIlllllIIIl) {
        final Listeners lllllllllllllIlIIIlIIIIlllllIlII = this.field_192192_b.get(lllllllllllllIlIIIlIIIIlllllIIlI);
        if (lllllllllllllIlIIIlIIIIlllllIlII != null) {
            lllllllllllllIlIIIlIIIIlllllIlII.func_192457_b(lllllllllllllIlIIIlIIIIlllllIIIl);
            if (lllllllllllllIlIIIlIIIIlllllIlII.func_192458_a()) {
                this.field_192192_b.remove(lllllllllllllIlIIIlIIIIlllllIIlI);
            }
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192462_b;
        private final /* synthetic */ PlayerAdvancements field_192461_a;
        
        public boolean func_192458_a() {
            return this.field_192462_b.isEmpty();
        }
        
        public void func_192459_a(final ItemStack lllllllllllllIIIlIIIlllllIlllIll, final int lllllllllllllIIIlIIIlllllIlllIlI) {
            List<Listener<Instance>> lllllllllllllIIIlIIIlllllIllllll = null;
            for (final Listener<Instance> lllllllllllllIIIlIIIlllllIlllllI : this.field_192462_b) {
                if (lllllllllllllIIIlIIIlllllIlllllI.func_192158_a().func_192257_a(lllllllllllllIIIlIIIlllllIlllIll, lllllllllllllIIIlIIIlllllIlllIlI)) {
                    if (lllllllllllllIIIlIIIlllllIllllll == null) {
                        lllllllllllllIIIlIIIlllllIllllll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIIlIIIlllllIllllll.add(lllllllllllllIIIlIIIlllllIlllllI);
                }
            }
            if (lllllllllllllIIIlIIIlllllIllllll != null) {
                for (final Listener<Instance> lllllllllllllIIIlIIIlllllIllllIl : lllllllllllllIIIlIIIlllllIllllll) {
                    lllllllllllllIIIlIIIlllllIllllIl.func_192159_a(this.field_192461_a);
                }
            }
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIIlIIIllllllIllIlI) {
            this.field_192462_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192461_a = lllllllllllllIIIlIIIllllllIllIlI;
        }
        
        public void func_192460_a(final Listener<Instance> lllllllllllllIIIlIIIllllllIIllll) {
            this.field_192462_b.add(lllllllllllllIIIlIIIllllllIIllll);
        }
        
        public void func_192457_b(final Listener<Instance> lllllllllllllIIIlIIIllllllIIlIIl) {
            this.field_192462_b.remove(lllllllllllllIIIlIIIllllllIIlIIl);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192259_b;
        private final /* synthetic */ ItemPredicate field_192258_a;
        
        public Instance(final ItemPredicate lllllllllllllllllIllIlIlIIlIlIIl, final MinMaxBounds lllllllllllllllllIllIlIlIIlIlIII) {
            super(EnchantedItemTrigger.field_192191_a);
            this.field_192258_a = lllllllllllllllllIllIlIlIIlIlIIl;
            this.field_192259_b = lllllllllllllllllIllIlIlIIlIlIII;
        }
        
        public boolean func_192257_a(final ItemStack lllllllllllllllllIllIlIlIIlIIIII, final int lllllllllllllllllIllIlIlIIIlllII) {
            return this.field_192258_a.func_192493_a(lllllllllllllllllIllIlIlIIlIIIII) && this.field_192259_b.func_192514_a((float)lllllllllllllllllIllIlIlIIIlllII);
        }
    }
}
