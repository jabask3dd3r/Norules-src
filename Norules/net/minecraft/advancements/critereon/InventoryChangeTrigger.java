package net.minecraft.advancements.critereon;

import com.google.gson.*;
import net.minecraft.util.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import java.util.*;
import com.google.common.collect.*;

public class InventoryChangeTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192209_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192210_b;
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIllIlIllIllIlIlll) {
        this.field_192210_b.remove(lllllllllllllIlIllIlIllIllIlIlll);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIllIlIllIllIIllIl, final JsonDeserializationContext lllllllllllllIlIllIlIllIllIIllII) {
        final JsonObject lllllllllllllIlIllIlIllIllIIlIll = JsonUtils.getJsonObject(lllllllllllllIlIllIlIllIllIIllIl, "slots", new JsonObject());
        final MinMaxBounds lllllllllllllIlIllIlIllIllIIlIlI = MinMaxBounds.func_192515_a(lllllllllllllIlIllIlIllIllIIlIll.get("occupied"));
        final MinMaxBounds lllllllllllllIlIllIlIllIllIIlIIl = MinMaxBounds.func_192515_a(lllllllllllllIlIllIlIllIllIIlIll.get("full"));
        final MinMaxBounds lllllllllllllIlIllIlIllIllIIlIII = MinMaxBounds.func_192515_a(lllllllllllllIlIllIlIllIllIIlIll.get("empty"));
        final ItemPredicate[] lllllllllllllIlIllIlIllIllIIIlll = ItemPredicate.func_192494_b(lllllllllllllIlIllIlIllIllIIllIl.get("items"));
        return new Instance(lllllllllllllIlIllIlIllIllIIlIlI, lllllllllllllIlIllIlIllIllIIlIIl, lllllllllllllIlIllIlIllIllIIlIII, lllllllllllllIlIllIlIllIllIIIlll);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return InventoryChangeTrigger.field_192209_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIllIlIllIlllIlIIl, final Listener<Instance> lllllllllllllIlIllIlIllIlllIlIII) {
        Listeners lllllllllllllIlIllIlIllIlllIlIll = this.field_192210_b.get(lllllllllllllIlIllIlIllIlllIlIIl);
        if (lllllllllllllIlIllIlIllIlllIlIll == null) {
            lllllllllllllIlIllIlIllIlllIlIll = new Listeners(lllllllllllllIlIllIlIllIlllIlIIl);
            this.field_192210_b.put(lllllllllllllIlIllIlIllIlllIlIIl, lllllllllllllIlIllIlIllIlllIlIll);
        }
        lllllllllllllIlIllIlIllIlllIlIll.func_192489_a(lllllllllllllIlIllIlIllIlllIlIII);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIllIlIllIllIlllIl, final Listener<Instance> lllllllllllllIlIllIlIllIllIlllII) {
        final Listeners lllllllllllllIlIllIlIllIllIlllll = this.field_192210_b.get(lllllllllllllIlIllIlIllIllIlllIl);
        if (lllllllllllllIlIllIlIllIllIlllll != null) {
            lllllllllllllIlIllIlIllIllIlllll.func_192487_b(lllllllllllllIlIllIlIllIllIlllII);
            if (lllllllllllllIlIllIlIllIllIlllll.func_192488_a()) {
                this.field_192210_b.remove(lllllllllllllIlIllIlIllIllIlllIl);
            }
        }
    }
    
    static {
        field_192209_a = new ResourceLocation("inventory_changed");
    }
    
    public InventoryChangeTrigger() {
        this.field_192210_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public void func_192208_a(final EntityPlayerMP lllllllllllllIlIllIlIllIlIllIlll, final InventoryPlayer lllllllllllllIlIllIlIllIlIllIllI) {
        final Listeners lllllllllllllIlIllIlIllIlIlllIIl = this.field_192210_b.get(lllllllllllllIlIllIlIllIlIllIlll.func_192039_O());
        if (lllllllllllllIlIllIlIllIlIlllIIl != null) {
            lllllllllllllIlIllIlIllIlIlllIIl.func_192486_a(lllllllllllllIlIllIlIllIlIllIllI);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192267_b;
        private final /* synthetic */ MinMaxBounds field_192266_a;
        private final /* synthetic */ ItemPredicate[] field_192269_d;
        private final /* synthetic */ MinMaxBounds field_192268_c;
        
        public boolean func_192265_a(final InventoryPlayer llllllllllllllIIlIlIIlllIlIlIIll) {
            int llllllllllllllIIlIlIIlllIlIlllII = 0;
            int llllllllllllllIIlIlIIlllIlIllIll = 0;
            int llllllllllllllIIlIlIIlllIlIllIlI = 0;
            final List<ItemPredicate> llllllllllllllIIlIlIIlllIlIllIIl = (List<ItemPredicate>)Lists.newArrayList((Object[])this.field_192269_d);
            for (int llllllllllllllIIlIlIIlllIlIllIII = 0; llllllllllllllIIlIlIIlllIlIllIII < llllllllllllllIIlIlIIlllIlIlIIll.getSizeInventory(); ++llllllllllllllIIlIlIIlllIlIllIII) {
                final ItemStack llllllllllllllIIlIlIIlllIlIlIlll = llllllllllllllIIlIlIIlllIlIlIIll.getStackInSlot(llllllllllllllIIlIlIIlllIlIllIII);
                if (llllllllllllllIIlIlIIlllIlIlIlll.func_190926_b()) {
                    ++llllllllllllllIIlIlIIlllIlIllIll;
                }
                else {
                    ++llllllllllllllIIlIlIIlllIlIllIlI;
                    if (llllllllllllllIIlIlIIlllIlIlIlll.func_190916_E() >= llllllllllllllIIlIlIIlllIlIlIlll.getMaxStackSize()) {
                        ++llllllllllllllIIlIlIIlllIlIlllII;
                    }
                    final Iterator<ItemPredicate> llllllllllllllIIlIlIIlllIlIlIllI = llllllllllllllIIlIlIIlllIlIllIIl.iterator();
                    while (llllllllllllllIIlIlIIlllIlIlIllI.hasNext()) {
                        final ItemPredicate llllllllllllllIIlIlIIlllIlIlIlIl = llllllllllllllIIlIlIIlllIlIlIllI.next();
                        if (llllllllllllllIIlIlIIlllIlIlIlIl.func_192493_a(llllllllllllllIIlIlIIlllIlIlIlll)) {
                            llllllllllllllIIlIlIIlllIlIlIllI.remove();
                        }
                    }
                }
            }
            return this.field_192267_b.func_192514_a((float)llllllllllllllIIlIlIIlllIlIlllII) && this.field_192268_c.func_192514_a((float)llllllllllllllIIlIlIIlllIlIllIll) && this.field_192266_a.func_192514_a((float)llllllllllllllIIlIlIIlllIlIllIlI) && llllllllllllllIIlIlIIlllIlIllIIl.isEmpty();
        }
        
        public Instance(final MinMaxBounds llllllllllllllIIlIlIIlllIlllIIIl, final MinMaxBounds llllllllllllllIIlIlIIlllIlllIIII, final MinMaxBounds llllllllllllllIIlIlIIlllIllIllll, final ItemPredicate[] llllllllllllllIIlIlIIlllIllIlIIl) {
            super(InventoryChangeTrigger.field_192209_a);
            this.field_192266_a = llllllllllllllIIlIlIIlllIlllIIIl;
            this.field_192267_b = llllllllllllllIIlIlIIlllIlllIIII;
            this.field_192268_c = llllllllllllllIIlIlIIlllIllIllll;
            this.field_192269_d = llllllllllllllIIlIlIIlllIllIlIIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192491_b;
        private final /* synthetic */ PlayerAdvancements field_192490_a;
        
        public void func_192487_b(final Listener<Instance> llllllllllllllIlIIIIlIIlIIIIIIll) {
            this.field_192491_b.remove(llllllllllllllIlIIIIlIIlIIIIIIll);
        }
        
        public void func_192486_a(final InventoryPlayer llllllllllllllIlIIIIlIIIllllIlIl) {
            List<Listener<Instance>> llllllllllllllIlIIIIlIIIlllllIIl = null;
            for (final Listener<Instance> llllllllllllllIlIIIIlIIIlllllIII : this.field_192491_b) {
                if (llllllllllllllIlIIIIlIIIlllllIII.func_192158_a().func_192265_a(llllllllllllllIlIIIIlIIIllllIlIl)) {
                    if (llllllllllllllIlIIIIlIIIlllllIIl == null) {
                        llllllllllllllIlIIIIlIIIlllllIIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIlIIIIlIIIlllllIIl.add(llllllllllllllIlIIIIlIIIlllllIII);
                }
            }
            if (llllllllllllllIlIIIIlIIIlllllIIl != null) {
                for (final Listener<Instance> llllllllllllllIlIIIIlIIIllllIlll : llllllllllllllIlIIIIlIIIlllllIIl) {
                    llllllllllllllIlIIIIlIIIllllIlll.func_192159_a(this.field_192490_a);
                }
            }
        }
        
        public Listeners(final PlayerAdvancements llllllllllllllIlIIIIlIIlIIIlIIII) {
            this.field_192491_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192490_a = llllllllllllllIlIIIIlIIlIIIlIIII;
        }
        
        public boolean func_192488_a() {
            return this.field_192491_b.isEmpty();
        }
        
        public void func_192489_a(final Listener<Instance> llllllllllllllIlIIIIlIIlIIIIIlll) {
            this.field_192491_b.add(llllllllllllllIlIIIIlIIlIIIIIlll);
        }
    }
}
