package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.*;
import com.google.common.collect.*;

public class ItemDurabilityTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193160_b;
    private static final /* synthetic */ ResourceLocation field_193159_a;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIllIlIllllllllIlllI, final Listener<Instance> lllllllllllllIllIlIlllllllllIIIl) {
        Listeners lllllllllllllIllIlIlllllllllIIII = this.field_193160_b.get(lllllllllllllIllIlIllllllllIlllI);
        if (lllllllllllllIllIlIlllllllllIIII == null) {
            lllllllllllllIllIlIlllllllllIIII = new Listeners(lllllllllllllIllIlIllllllllIlllI);
            this.field_193160_b.put(lllllllllllllIllIlIllllllllIlllI, lllllllllllllIllIlIlllllllllIIII);
        }
        lllllllllllllIllIlIlllllllllIIII.func_193440_a(lllllllllllllIllIlIlllllllllIIIl);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIllIlIlllllllIllIlI) {
        this.field_193160_b.remove(lllllllllllllIllIlIlllllllIllIlI);
    }
    
    public void func_193158_a(final EntityPlayerMP lllllllllllllIllIlIlllllllIIIlIl, final ItemStack lllllllllllllIllIlIlllllllIIIlII, final int lllllllllllllIllIlIllllllIlllllI) {
        final Listeners lllllllllllllIllIlIlllllllIIIIlI = this.field_193160_b.get(lllllllllllllIllIlIlllllllIIIlIl.func_192039_O());
        if (lllllllllllllIllIlIlllllllIIIIlI != null) {
            lllllllllllllIllIlIlllllllIIIIlI.func_193441_a(lllllllllllllIllIlIlllllllIIIlII, lllllllllllllIllIlIllllllIlllllI);
        }
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIllIlIllllllllIIIlI, final Listener<Instance> lllllllllllllIllIlIllllllllIIlIl) {
        final Listeners lllllllllllllIllIlIllllllllIIlII = this.field_193160_b.get(lllllllllllllIllIlIllllllllIIIlI);
        if (lllllllllllllIllIlIllllllllIIlII != null) {
            lllllllllllllIllIlIllllllllIIlII.func_193438_b(lllllllllllllIllIlIllllllllIIlIl);
            if (lllllllllllllIllIlIllllllllIIlII.func_193439_a()) {
                this.field_193160_b.remove(lllllllllllllIllIlIllllllllIIIlI);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ItemDurabilityTrigger.field_193159_a;
    }
    
    static {
        field_193159_a = new ResourceLocation("item_durability_changed");
    }
    
    public ItemDurabilityTrigger() {
        this.field_193160_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIllIlIlllllllIIllll, final JsonDeserializationContext lllllllllllllIllIlIlllllllIlIIll) {
        final ItemPredicate lllllllllllllIllIlIlllllllIlIIlI = ItemPredicate.func_192492_a(lllllllllllllIllIlIlllllllIIllll.get("item"));
        final MinMaxBounds lllllllllllllIllIlIlllllllIlIIIl = MinMaxBounds.func_192515_a(lllllllllllllIllIlIlllllllIIllll.get("durability"));
        final MinMaxBounds lllllllllllllIllIlIlllllllIlIIII = MinMaxBounds.func_192515_a(lllllllllllllIllIlIlllllllIIllll.get("delta"));
        return new Instance(lllllllllllllIllIlIlllllllIlIIlI, lllllllllllllIllIlIlllllllIlIIIl, lllllllllllllIllIlIlllllllIlIIII);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_193199_b;
        private final /* synthetic */ MinMaxBounds field_193200_c;
        private final /* synthetic */ ItemPredicate field_193198_a;
        
        public boolean func_193197_a(final ItemStack llllllllllllllIlIlllIIIlIIIIIlIl, final int llllllllllllllIlIlllIIIlIIIIIIIl) {
            return this.field_193198_a.func_192493_a(llllllllllllllIlIlllIIIlIIIIIlIl) && this.field_193199_b.func_192514_a((float)(llllllllllllllIlIlllIIIlIIIIIlIl.getMaxDamage() - llllllllllllllIlIlllIIIlIIIIIIIl)) && this.field_193200_c.func_192514_a((float)(llllllllllllllIlIlllIIIlIIIIIlIl.getItemDamage() - llllllllllllllIlIlllIIIlIIIIIIIl));
        }
        
        public Instance(final ItemPredicate llllllllllllllIlIlllIIIlIIIlIIII, final MinMaxBounds llllllllllllllIlIlllIIIlIIIIlIll, final MinMaxBounds llllllllllllllIlIlllIIIlIIIIlIlI) {
            super(ItemDurabilityTrigger.field_193159_a);
            this.field_193198_a = llllllllllllllIlIlllIIIlIIIlIIII;
            this.field_193199_b = llllllllllllllIlIlllIIIlIIIIlIll;
            this.field_193200_c = llllllllllllllIlIlllIIIlIIIIlIlI;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193442_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193443_b;
        
        public void func_193441_a(final ItemStack llllllllllllllIlIlIlllllIIlIIIlI, final int llllllllllllllIlIlIlllllIIlIIIIl) {
            List<Listener<Instance>> llllllllllllllIlIlIlllllIIlIIIII = null;
            for (final Listener<Instance> llllllllllllllIlIlIlllllIIIlllll : this.field_193443_b) {
                if (llllllllllllllIlIlIlllllIIIlllll.func_192158_a().func_193197_a(llllllllllllllIlIlIlllllIIlIIIlI, llllllllllllllIlIlIlllllIIlIIIIl)) {
                    if (llllllllllllllIlIlIlllllIIlIIIII == null) {
                        llllllllllllllIlIlIlllllIIlIIIII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIlIlIlllllIIlIIIII.add(llllllllllllllIlIlIlllllIIIlllll);
                }
            }
            if (llllllllllllllIlIlIlllllIIlIIIII != null) {
                for (final Listener<Instance> llllllllllllllIlIlIlllllIIIllllI : llllllllllllllIlIlIlllllIIlIIIII) {
                    llllllllllllllIlIlIlllllIIIllllI.func_192159_a(this.field_193442_a);
                }
            }
        }
        
        public void func_193440_a(final Listener<Instance> llllllllllllllIlIlIlllllIIllIIlI) {
            this.field_193443_b.add(llllllllllllllIlIlIlllllIIllIIlI);
        }
        
        public void func_193438_b(final Listener<Instance> llllllllllllllIlIlIlllllIIlIllII) {
            this.field_193443_b.remove(llllllllllllllIlIlIlllllIIlIllII);
        }
        
        public boolean func_193439_a() {
            return this.field_193443_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llllllllllllllIlIlIlllllIIlllIll) {
            this.field_193443_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193442_a = llllllllllllllIlIlIlllllIIlllIll;
        }
    }
}
