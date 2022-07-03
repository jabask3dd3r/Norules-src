package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import java.util.*;

public class CuredZombieVillagerTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192186_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192187_b;
    
    @Override
    public ResourceLocation func_192163_a() {
        return CuredZombieVillagerTrigger.field_192186_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIlIlIllIlIIIllIl, final Listener<Instance> lllllllllllllIlIIlIlIllIlIIIllII) {
        Listeners lllllllllllllIlIIlIlIllIlIIIlIll = this.field_192187_b.get(lllllllllllllIlIIlIlIllIlIIIllIl);
        if (lllllllllllllIlIIlIlIllIlIIIlIll == null) {
            lllllllllllllIlIIlIlIllIlIIIlIll = new Listeners(lllllllllllllIlIIlIlIllIlIIIllIl);
            this.field_192187_b.put(lllllllllllllIlIIlIlIllIlIIIllIl, lllllllllllllIlIIlIlIllIlIIIlIll);
        }
        lllllllllllllIlIIlIlIllIlIIIlIll.func_192360_a(lllllllllllllIlIIlIlIllIlIIIllII);
    }
    
    static {
        field_192186_a = new ResourceLocation("cured_zombie_villager");
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIlIlIllIIlllllIl, final Listener<Instance> lllllllllllllIlIIlIlIllIIlllllII) {
        final Listeners lllllllllllllIlIIlIlIllIIlllllll = this.field_192187_b.get(lllllllllllllIlIIlIlIllIIlllllIl);
        if (lllllllllllllIlIIlIlIllIIlllllll != null) {
            lllllllllllllIlIIlIlIllIIlllllll.func_192358_b(lllllllllllllIlIIlIlIllIIlllllII);
            if (lllllllllllllIlIIlIlIllIIlllllll.func_192359_a()) {
                this.field_192187_b.remove(lllllllllllllIlIIlIlIllIIlllllIl);
            }
        }
    }
    
    public void func_192183_a(final EntityPlayerMP lllllllllllllIlIIlIlIllIIllIIIll, final EntityZombie lllllllllllllIlIIlIlIllIIlIlllIl, final EntityVillager lllllllllllllIlIIlIlIllIIllIIIIl) {
        final Listeners lllllllllllllIlIIlIlIllIIllIIIII = this.field_192187_b.get(lllllllllllllIlIIlIlIllIIllIIIll.func_192039_O());
        if (lllllllllllllIlIIlIlIllIIllIIIII != null) {
            lllllllllllllIlIIlIlIllIIllIIIII.func_192361_a(lllllllllllllIlIIlIlIllIIllIIIll, lllllllllllllIlIIlIlIllIIlIlllIl, lllllllllllllIlIIlIlIllIIllIIIIl);
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIlIlIllIIlllIIII, final JsonDeserializationContext lllllllllllllIlIIlIlIllIIllIllll) {
        final EntityPredicate lllllllllllllIlIIlIlIllIIllIlllI = EntityPredicate.func_192481_a(lllllllllllllIlIIlIlIllIIlllIIII.get("zombie"));
        final EntityPredicate lllllllllllllIlIIlIlIllIIllIllIl = EntityPredicate.func_192481_a(lllllllllllllIlIIlIlIllIIlllIIII.get("villager"));
        return new Instance(lllllllllllllIlIIlIlIllIIllIlllI, lllllllllllllIlIIlIlIllIIllIllIl);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIlIlIllIIlllIlll) {
        this.field_192187_b.remove(lllllllllllllIlIIlIlIllIIlllIlll);
    }
    
    public CuredZombieVillagerTrigger() {
        this.field_192187_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ EntityPredicate field_192255_a;
        private final /* synthetic */ EntityPredicate field_192256_b;
        
        public boolean func_192254_a(final EntityPlayerMP lllllllllllllIlIlIlIlllIIIllllll, final EntityZombie lllllllllllllIlIlIlIlllIIIlllIlI, final EntityVillager lllllllllllllIlIlIlIlllIIIlllIIl) {
            return this.field_192255_a.func_192482_a(lllllllllllllIlIlIlIlllIIIllllll, lllllllllllllIlIlIlIlllIIIlllIlI) && this.field_192256_b.func_192482_a(lllllllllllllIlIlIlIlllIIIllllll, lllllllllllllIlIlIlIlllIIIlllIIl);
        }
        
        public Instance(final EntityPredicate lllllllllllllIlIlIlIlllIIlIIlIIl, final EntityPredicate lllllllllllllIlIlIlIlllIIlIIIlIl) {
            super(CuredZombieVillagerTrigger.field_192186_a);
            this.field_192255_a = lllllllllllllIlIlIlIlllIIlIIlIIl;
            this.field_192256_b = lllllllllllllIlIlIlIlllIIlIIIlIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192362_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192363_b;
        
        public Listeners(final PlayerAdvancements lllllllllllllIIlIlllIIlllIIIllll) {
            this.field_192363_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192362_a = lllllllllllllIIlIlllIIlllIIIllll;
        }
        
        public void func_192358_b(final Listener<Instance> lllllllllllllIIlIlllIIlllIIIIIII) {
            this.field_192363_b.remove(lllllllllllllIIlIlllIIlllIIIIIII);
        }
        
        public boolean func_192359_a() {
            return this.field_192363_b.isEmpty();
        }
        
        public void func_192360_a(final Listener<Instance> lllllllllllllIIlIlllIIlllIIIIllI) {
            this.field_192363_b.add(lllllllllllllIIlIlllIIlllIIIIllI);
        }
        
        public void func_192361_a(final EntityPlayerMP lllllllllllllIIlIlllIIllIlllIlll, final EntityZombie lllllllllllllIIlIlllIIllIllIllll, final EntityVillager lllllllllllllIIlIlllIIllIllIlllI) {
            List<Listener<Instance>> lllllllllllllIIlIlllIIllIlllIlII = null;
            for (final Listener<Instance> lllllllllllllIIlIlllIIllIlllIIll : this.field_192363_b) {
                if (lllllllllllllIIlIlllIIllIlllIIll.func_192158_a().func_192254_a(lllllllllllllIIlIlllIIllIlllIlll, lllllllllllllIIlIlllIIllIllIllll, lllllllllllllIIlIlllIIllIllIlllI)) {
                    if (lllllllllllllIIlIlllIIllIlllIlII == null) {
                        lllllllllllllIIlIlllIIllIlllIlII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIlIlllIIllIlllIlII.add(lllllllllllllIIlIlllIIllIlllIIll);
                }
            }
            if (lllllllllllllIIlIlllIIllIlllIlII != null) {
                for (final Listener<Instance> lllllllllllllIIlIlllIIllIlllIIlI : lllllllllllllIIlIlllIIllIlllIlII) {
                    lllllllllllllIIlIlllIIllIlllIIlI.func_192159_a(this.field_192362_a);
                }
            }
        }
    }
}
