package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.*;
import java.util.*;
import com.google.common.collect.*;

public class VillagerTradeTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192237_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192238_b;
    
    public VillagerTradeTrigger() {
        this.field_192238_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIIlllIlIlllllllllII, final Listener<Instance> lllllllllllllIIlllIlIlllllllllll) {
        final Listeners lllllllllllllIIlllIlIllllllllllI = this.field_192238_b.get(lllllllllllllIIlllIlIlllllllllII);
        if (lllllllllllllIIlllIlIllllllllllI != null) {
            lllllllllllllIIlllIlIllllllllllI.func_192538_b(lllllllllllllIIlllIlIlllllllllll);
            if (lllllllllllllIIlllIlIllllllllllI.func_192539_a()) {
                this.field_192238_b.remove(lllllllllllllIIlllIlIlllllllllII);
            }
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIIlllIllIIIIIIIllII, final Listener<Instance> lllllllllllllIIlllIllIIIIIIIlIll) {
        Listeners lllllllllllllIIlllIllIIIIIIIlIlI = this.field_192238_b.get(lllllllllllllIIlllIllIIIIIIIllII);
        if (lllllllllllllIIlllIllIIIIIIIlIlI == null) {
            lllllllllllllIIlllIllIIIIIIIlIlI = new Listeners(lllllllllllllIIlllIllIIIIIIIllII);
            this.field_192238_b.put(lllllllllllllIIlllIllIIIIIIIllII, lllllllllllllIIlllIllIIIIIIIlIlI);
        }
        lllllllllllllIIlllIllIIIIIIIlIlI.func_192540_a(lllllllllllllIIlllIllIIIIIIIlIll);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIIlllIlIllllllIlIll, final JsonDeserializationContext lllllllllllllIIlllIlIllllllIlllI) {
        final EntityPredicate lllllllllllllIIlllIlIllllllIllIl = EntityPredicate.func_192481_a(lllllllllllllIIlllIlIllllllIlIll.get("villager"));
        final ItemPredicate lllllllllllllIIlllIlIllllllIllII = ItemPredicate.func_192492_a(lllllllllllllIIlllIlIllllllIlIll.get("item"));
        return new Instance(lllllllllllllIIlllIlIllllllIllIl, lllllllllllllIIlllIlIllllllIllII);
    }
    
    static {
        field_192237_a = new ResourceLocation("villager_trade");
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIIlllIlIlllllllIllI) {
        this.field_192238_b.remove(lllllllllllllIIlllIlIlllllllIllI);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return VillagerTradeTrigger.field_192237_a;
    }
    
    public void func_192234_a(final EntityPlayerMP lllllllllllllIIlllIlIllllllIIIlI, final EntityVillager lllllllllllllIIlllIlIllllllIIIIl, final ItemStack lllllllllllllIIlllIlIllllllIIIII) {
        final Listeners lllllllllllllIIlllIlIlllllIlllll = this.field_192238_b.get(lllllllllllllIIlllIlIllllllIIIlI.func_192039_O());
        if (lllllllllllllIIlllIlIlllllIlllll != null) {
            lllllllllllllIIlllIlIlllllIlllll.func_192537_a(lllllllllllllIIlllIlIllllllIIIlI, lllllllllllllIIlllIlIllllllIIIIl, lllllllllllllIIlllIlIllllllIIIII);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192286_a;
        private final /* synthetic */ ItemPredicate field_192287_b;
        
        public boolean func_192285_a(final EntityPlayerMP llllllllllllIlllllIIIIIlIlIlIlIl, final EntityVillager llllllllllllIlllllIIIIIlIlIlIIII, final ItemStack llllllllllllIlllllIIIIIlIlIlIIll) {
            return this.field_192286_a.func_192482_a(llllllllllllIlllllIIIIIlIlIlIlIl, llllllllllllIlllllIIIIIlIlIlIIII) && this.field_192287_b.func_192493_a(llllllllllllIlllllIIIIIlIlIlIIll);
        }
        
        public Instance(final EntityPredicate llllllllllllIlllllIIIIIlIlIlllll, final ItemPredicate llllllllllllIlllllIIIIIlIlIllIll) {
            super(VillagerTradeTrigger.field_192237_a);
            this.field_192286_a = llllllllllllIlllllIIIIIlIlIlllll;
            this.field_192287_b = llllllllllllIlllllIIIIIlIlIllIll;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192541_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192542_b;
        
        public boolean func_192539_a() {
            return this.field_192542_b.isEmpty();
        }
        
        public void func_192538_b(final Listener<Instance> llllllllllllllIllIIlIlIIIlllIlIl) {
            this.field_192542_b.remove(llllllllllllllIllIIlIlIIIlllIlIl);
        }
        
        public void func_192537_a(final EntityPlayerMP llllllllllllllIllIIlIlIIIllIIlIl, final EntityVillager llllllllllllllIllIIlIlIIIllIlIll, final ItemStack llllllllllllllIllIIlIlIIIllIIIll) {
            List<Listener<Instance>> llllllllllllllIllIIlIlIIIllIlIIl = null;
            for (final Listener<Instance> llllllllllllllIllIIlIlIIIllIlIII : this.field_192542_b) {
                if (llllllllllllllIllIIlIlIIIllIlIII.func_192158_a().func_192285_a(llllllllllllllIllIIlIlIIIllIIlIl, llllllllllllllIllIIlIlIIIllIlIll, llllllllllllllIllIIlIlIIIllIIIll)) {
                    if (llllllllllllllIllIIlIlIIIllIlIIl == null) {
                        llllllllllllllIllIIlIlIIIllIlIIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIllIIlIlIIIllIlIIl.add(llllllllllllllIllIIlIlIIIllIlIII);
                }
            }
            if (llllllllllllllIllIIlIlIIIllIlIIl != null) {
                for (final Listener<Instance> llllllllllllllIllIIlIlIIIllIIlll : llllllllllllllIllIIlIlIIIllIlIIl) {
                    llllllllllllllIllIIlIlIIIllIIlll.func_192159_a(this.field_192541_a);
                }
            }
        }
        
        public void func_192540_a(final Listener<Instance> llllllllllllllIllIIlIlIIIlllllIl) {
            this.field_192542_b.add(llllllllllllllIllIIlIlIIIlllllIl);
        }
        
        public Listeners(final PlayerAdvancements llllllllllllllIllIIlIlIIlIIIIllI) {
            this.field_192542_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192541_a = llllllllllllllIllIIlIlIIlIIIIllI;
        }
    }
}
