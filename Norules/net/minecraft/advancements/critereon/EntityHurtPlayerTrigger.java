package net.minecraft.advancements.critereon;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import java.util.*;
import com.google.common.collect.*;

public class EntityHurtPlayerTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192202_b;
    private static final /* synthetic */ ResourceLocation field_192201_a;
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIlllIlIIllIlllll, final Listener<Instance> lllllllllllllIlIIlllIlIIllIllllI) {
        Listeners lllllllllllllIlIIlllIlIIlllIIIIl = this.field_192202_b.get(lllllllllllllIlIIlllIlIIllIlllll);
        if (lllllllllllllIlIIlllIlIIlllIIIIl == null) {
            lllllllllllllIlIIlllIlIIlllIIIIl = new Listeners(lllllllllllllIlIIlllIlIIllIlllll);
            this.field_192202_b.put(lllllllllllllIlIIlllIlIIllIlllll, lllllllllllllIlIIlllIlIIlllIIIIl);
        }
        lllllllllllllIlIIlllIlIIlllIIIIl.func_192477_a(lllllllllllllIlIIlllIlIIllIllllI);
    }
    
    public void func_192200_a(final EntityPlayerMP lllllllllllllIlIIlllIlIIlIlIIIlI, final DamageSource lllllllllllllIlIIlllIlIIlIlIIIII, final float lllllllllllllIlIIlllIlIIlIIlIlII, final float lllllllllllllIlIIlllIlIIlIIlIIll, final boolean lllllllllllllIlIIlllIlIIlIIllIll) {
        final Listeners lllllllllllllIlIIlllIlIIlIIllIlI = this.field_192202_b.get(lllllllllllllIlIIlllIlIIlIlIIIlI.func_192039_O());
        if (lllllllllllllIlIIlllIlIIlIIllIlI != null) {
            lllllllllllllIlIIlllIlIIlIIllIlI.func_192478_a(lllllllllllllIlIIlllIlIIlIlIIIlI, lllllllllllllIlIIlllIlIIlIlIIIII, lllllllllllllIlIIlllIlIIlIIlIlII, lllllllllllllIlIIlllIlIIlIIlIIll, lllllllllllllIlIIlllIlIIlIIllIll);
        }
    }
    
    public EntityHurtPlayerTrigger() {
        this.field_192202_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_192201_a = new ResourceLocation("entity_hurt_player");
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIlllIlIIlIllIlll, final JsonDeserializationContext lllllllllllllIlIIlllIlIIlIlllIlI) {
        final DamagePredicate lllllllllllllIlIIlllIlIIlIlllIIl = DamagePredicate.func_192364_a(lllllllllllllIlIIlllIlIIlIllIlll.get("damage"));
        return new Instance(lllllllllllllIlIIlllIlIIlIlllIIl);
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIlllIlIIllIIIlIl) {
        this.field_192202_b.remove(lllllllllllllIlIIlllIlIIllIIIlIl);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIlllIlIIllIlIlll, final Listener<Instance> lllllllllllllIlIIlllIlIIllIlIIII) {
        final Listeners lllllllllllllIlIIlllIlIIllIlIlIl = this.field_192202_b.get(lllllllllllllIlIIlllIlIIllIlIlll);
        if (lllllllllllllIlIIlllIlIIllIlIlIl != null) {
            lllllllllllllIlIIlllIlIIllIlIlIl.func_192475_b(lllllllllllllIlIIlllIlIIllIlIIII);
            if (lllllllllllllIlIIlllIlIIllIlIlIl.func_192476_a()) {
                this.field_192202_b.remove(lllllllllllllIlIIlllIlIIllIlIlll);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EntityHurtPlayerTrigger.field_192201_a;
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192480_b;
        private final /* synthetic */ PlayerAdvancements field_192479_a;
        
        public void func_192478_a(final EntityPlayerMP lllllllllllllIIIllIlIlIlIIlIIlll, final DamageSource lllllllllllllIIIllIlIlIlIIIlllIl, final float lllllllllllllIIIllIlIlIlIIlIIlIl, final float lllllllllllllIIIllIlIlIlIIlIIlII, final boolean lllllllllllllIIIllIlIlIlIIIllIlI) {
            List<Listener<Instance>> lllllllllllllIIIllIlIlIlIIlIIIlI = null;
            for (final Listener<Instance> lllllllllllllIIIllIlIlIlIIlIIIIl : this.field_192480_b) {
                if (lllllllllllllIIIllIlIlIlIIlIIIIl.func_192158_a().func_192263_a(lllllllllllllIIIllIlIlIlIIlIIlll, lllllllllllllIIIllIlIlIlIIIlllIl, lllllllllllllIIIllIlIlIlIIlIIlIl, lllllllllllllIIIllIlIlIlIIlIIlII, lllllllllllllIIIllIlIlIlIIIllIlI)) {
                    if (lllllllllllllIIIllIlIlIlIIlIIIlI == null) {
                        lllllllllllllIIIllIlIlIlIIlIIIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIIllIlIlIlIIlIIIlI.add(lllllllllllllIIIllIlIlIlIIlIIIIl);
                }
            }
            if (lllllllllllllIIIllIlIlIlIIlIIIlI != null) {
                for (final Listener<Instance> lllllllllllllIIIllIlIlIlIIlIIIII : lllllllllllllIIIllIlIlIlIIlIIIlI) {
                    lllllllllllllIIIllIlIlIlIIlIIIII.func_192159_a(this.field_192479_a);
                }
            }
        }
        
        public void func_192477_a(final Listener<Instance> lllllllllllllIIIllIlIlIlIIlllIlI) {
            this.field_192480_b.add(lllllllllllllIIIllIlIlIlIIlllIlI);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIIllIlIlIlIlIIIIIl) {
            this.field_192480_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192479_a = lllllllllllllIIIllIlIlIlIlIIIIIl;
        }
        
        public void func_192475_b(final Listener<Instance> lllllllllllllIIIllIlIlIlIIllIlII) {
            this.field_192480_b.remove(lllllllllllllIIIllIlIlIlIIllIlII);
        }
        
        public boolean func_192476_a() {
            return this.field_192480_b.isEmpty();
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DamagePredicate field_192264_a;
        
        public boolean func_192263_a(final EntityPlayerMP lllllllllllllllIIIlIlIllllIllIIl, final DamageSource lllllllllllllllIIIlIlIllllIllIII, final float lllllllllllllllIIIlIlIllllIlllIl, final float lllllllllllllllIIIlIlIllllIlIllI, final boolean lllllllllllllllIIIlIlIllllIllIll) {
            return this.field_192264_a.func_192365_a(lllllllllllllllIIIlIlIllllIllIIl, lllllllllllllllIIIlIlIllllIllIII, lllllllllllllllIIIlIlIllllIlllIl, lllllllllllllllIIIlIlIllllIlIllI, lllllllllllllllIIIlIlIllllIllIll);
        }
        
        public Instance(final DamagePredicate lllllllllllllllIIIlIlIlllllIlIIl) {
            super(EntityHurtPlayerTrigger.field_192201_a);
            this.field_192264_a = lllllllllllllllIIIlIlIlllllIlIIl;
        }
    }
}
