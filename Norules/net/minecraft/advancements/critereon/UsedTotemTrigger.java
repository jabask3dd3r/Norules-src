package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import java.util.*;

public class UsedTotemTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193188_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193189_b;
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIIlllllIIlIIlIllllI, final JsonDeserializationContext lllllllllllllIIlllllIIlIIllIIIII) {
        final ItemPredicate lllllllllllllIIlllllIIlIIlIlllll = ItemPredicate.func_192492_a(lllllllllllllIIlllllIIlIIlIllllI.get("item"));
        return new Instance(lllllllllllllIIlllllIIlIIlIlllll);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIIlllllIIlIIlllIIIl, final Listener<Instance> lllllllllllllIIlllllIIlIIlllIIII) {
        final Listeners lllllllllllllIIlllllIIlIIllIllll = this.field_193189_b.get(lllllllllllllIIlllllIIlIIlllIIIl);
        if (lllllllllllllIIlllllIIlIIllIllll != null) {
            lllllllllllllIIlllllIIlIIllIllll.func_193506_b(lllllllllllllIIlllllIIlIIlllIIII);
            if (lllllllllllllIIlllllIIlIIllIllll.func_193507_a()) {
                this.field_193189_b.remove(lllllllllllllIIlllllIIlIIlllIIIl);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return UsedTotemTrigger.field_193188_a;
    }
    
    static {
        field_193188_a = new ResourceLocation("used_totem");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIIlllllIIlIIlllllIl, final Listener<Instance> lllllllllllllIIlllllIIlIIllllIII) {
        Listeners lllllllllllllIIlllllIIlIIllllIll = this.field_193189_b.get(lllllllllllllIIlllllIIlIIlllllIl);
        if (lllllllllllllIIlllllIIlIIllllIll == null) {
            lllllllllllllIIlllllIIlIIllllIll = new Listeners(lllllllllllllIIlllllIIlIIlllllIl);
            this.field_193189_b.put(lllllllllllllIIlllllIIlIIlllllIl, lllllllllllllIIlllllIIlIIllllIll);
        }
        lllllllllllllIIlllllIIlIIllllIll.func_193508_a(lllllllllllllIIlllllIIlIIllllIII);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIIlllllIIlIIllIIlIl) {
        this.field_193189_b.remove(lllllllllllllIIlllllIIlIIllIIlIl);
    }
    
    public UsedTotemTrigger() {
        this.field_193189_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public void func_193187_a(final EntityPlayerMP lllllllllllllIIlllllIIlIIlIlIlll, final ItemStack lllllllllllllIIlllllIIlIIlIlIllI) {
        final Listeners lllllllllllllIIlllllIIlIIlIlIlIl = this.field_193189_b.get(lllllllllllllIIlllllIIlIIlIlIlll.func_192039_O());
        if (lllllllllllllIIlllllIIlIIlIlIlIl != null) {
            lllllllllllllIIlllllIIlIIlIlIlIl.func_193509_a(lllllllllllllIIlllllIIlIIlIlIllI);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ ItemPredicate field_193219_a;
        
        public Instance(final ItemPredicate llllllllllllllllllllllIlIlIIllII) {
            super(UsedTotemTrigger.field_193188_a);
            this.field_193219_a = llllllllllllllllllllllIlIlIIllII;
        }
        
        public boolean func_193218_a(final ItemStack llllllllllllllllllllllIlIlIIIllI) {
            return this.field_193219_a.func_192493_a(llllllllllllllllllllllIlIlIIIllI);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193510_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193511_b;
        
        public void func_193508_a(final Listener<Instance> lllllllllllllllIlIlIIlIlIIlIIlIl) {
            this.field_193511_b.add(lllllllllllllllIlIlIIlIlIIlIIlIl);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllllIlIlIIlIlIIllIIII) {
            this.field_193511_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193510_a = lllllllllllllllIlIlIIlIlIIllIIII;
        }
        
        public void func_193509_a(final ItemStack lllllllllllllllIlIlIIlIlIIIlIIll) {
            List<Listener<Instance>> lllllllllllllllIlIlIIlIlIIIlIlll = null;
            for (final Listener<Instance> lllllllllllllllIlIlIIlIlIIIlIllI : this.field_193511_b) {
                if (lllllllllllllllIlIlIIlIlIIIlIllI.func_192158_a().func_193218_a(lllllllllllllllIlIlIIlIlIIIlIIll)) {
                    if (lllllllllllllllIlIlIIlIlIIIlIlll == null) {
                        lllllllllllllllIlIlIIlIlIIIlIlll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIlIlIIlIlIIIlIlll.add(lllllllllllllllIlIlIIlIlIIIlIllI);
                }
            }
            if (lllllllllllllllIlIlIIlIlIIIlIlll != null) {
                for (final Listener<Instance> lllllllllllllllIlIlIIlIlIIIlIlIl : lllllllllllllllIlIlIIlIlIIIlIlll) {
                    lllllllllllllllIlIlIIlIlIIIlIlIl.func_192159_a(this.field_193510_a);
                }
            }
        }
        
        public boolean func_193507_a() {
            return this.field_193511_b.isEmpty();
        }
        
        public void func_193506_b(final Listener<Instance> lllllllllllllllIlIlIIlIlIIIlllll) {
            this.field_193511_b.remove(lllllllllllllllIlIlIIlIlIIIlllll);
        }
    }
}
