package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;

public class EffectsChangedTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193154_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193155_b;
    
    public void func_193153_a(final EntityPlayerMP lllllllllllllllllllIIllIllIlIlII) {
        final Listeners lllllllllllllllllllIIllIllIlIIll = this.field_193155_b.get(lllllllllllllllllllIIllIllIlIlII.func_192039_O());
        if (lllllllllllllllllllIIllIllIlIIll != null) {
            lllllllllllllllllllIIllIllIlIIll.func_193432_a(lllllllllllllllllllIIllIllIlIlII);
        }
    }
    
    public EffectsChangedTrigger() {
        this.field_193155_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllllllllIIllIllIlllIl, final JsonDeserializationContext lllllllllllllllllllIIllIllIlllII) {
        final MobEffectsPredicate lllllllllllllllllllIIllIllIllIll = MobEffectsPredicate.func_193471_a(lllllllllllllllllllIIllIllIlllIl.get("effects"));
        return new Instance(lllllllllllllllllllIIllIllIllIll);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllllllllIIllIlllllIIl, final Listener<Instance> lllllllllllllllllllIIllIlllllIII) {
        Listeners lllllllllllllllllllIIllIllllIlll = this.field_193155_b.get(lllllllllllllllllllIIllIlllllIIl);
        if (lllllllllllllllllllIIllIllllIlll == null) {
            lllllllllllllllllllIIllIllllIlll = new Listeners(lllllllllllllllllllIIllIlllllIIl);
            this.field_193155_b.put(lllllllllllllllllllIIllIlllllIIl, lllllllllllllllllllIIllIllllIlll);
        }
        lllllllllllllllllllIIllIllllIlll.func_193431_a(lllllllllllllllllllIIllIlllllIII);
    }
    
    static {
        field_193154_a = new ResourceLocation("effects_changed");
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllllllllIIllIlllIllIl, final Listener<Instance> lllllllllllllllllllIIllIlllIllII) {
        final Listeners lllllllllllllllllllIIllIlllIlIll = this.field_193155_b.get(lllllllllllllllllllIIllIlllIllIl);
        if (lllllllllllllllllllIIllIlllIlIll != null) {
            lllllllllllllllllllIIllIlllIlIll.func_193429_b(lllllllllllllllllllIIllIlllIllII);
            if (lllllllllllllllllllIIllIlllIlIll.func_193430_a()) {
                this.field_193155_b.remove(lllllllllllllllllllIIllIlllIllIl);
            }
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllllllllIIllIlllIIIll) {
        this.field_193155_b.remove(lllllllllllllllllllIIllIlllIIIll);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EffectsChangedTrigger.field_193154_a;
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193433_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193434_b;
        
        public boolean func_193430_a() {
            return this.field_193434_b.isEmpty();
        }
        
        public void func_193431_a(final Listener<Instance> lllllllllllllIllllllllIIIIllllIl) {
            this.field_193434_b.add(lllllllllllllIllllllllIIIIllllIl);
        }
        
        public void func_193432_a(final EntityPlayerMP lllllllllllllIllllllllIIIIlIlllI) {
            List<Listener<Instance>> lllllllllllllIllllllllIIIIlIllIl = null;
            for (final Listener<Instance> lllllllllllllIllllllllIIIIlIllII : this.field_193434_b) {
                if (lllllllllllllIllllllllIIIIlIllII.func_192158_a().func_193195_a(lllllllllllllIllllllllIIIIlIlllI)) {
                    if (lllllllllllllIllllllllIIIIlIllIl == null) {
                        lllllllllllllIllllllllIIIIlIllIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIllllllllIIIIlIllIl.add(lllllllllllllIllllllllIIIIlIllII);
                }
            }
            if (lllllllllllllIllllllllIIIIlIllIl != null) {
                for (final Listener<Instance> lllllllllllllIllllllllIIIIlIlIll : lllllllllllllIllllllllIIIIlIllIl) {
                    lllllllllllllIllllllllIIIIlIlIll.func_192159_a(this.field_193433_a);
                }
            }
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIllllllllIIIlIIIlII) {
            this.field_193434_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193433_a = lllllllllllllIllllllllIIIlIIIlII;
        }
        
        public void func_193429_b(final Listener<Instance> lllllllllllllIllllllllIIIIllIlIl) {
            this.field_193434_b.remove(lllllllllllllIllllllllIIIIllIlIl);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MobEffectsPredicate field_193196_a;
        
        public Instance(final MobEffectsPredicate lllllllllllllIlllIllIlllIllIlIlI) {
            super(EffectsChangedTrigger.field_193154_a);
            this.field_193196_a = lllllllllllllIlllIllIlllIllIlIlI;
        }
        
        public boolean func_193195_a(final EntityPlayerMP lllllllllllllIlllIllIlllIllIIlII) {
            return this.field_193196_a.func_193472_a(lllllllllllllIlllIllIlllIllIIlII);
        }
    }
}
