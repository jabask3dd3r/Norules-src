package net.minecraft.advancements.critereon;

import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;

public class PlayerHurtEntityTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192223_b;
    private static final /* synthetic */ ResourceLocation field_192222_a;
    
    public PlayerHurtEntityTrigger() {
        this.field_192223_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    static {
        field_192222_a = new ResourceLocation("player_hurt_entity");
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIlIIIIllllIlIIlll) {
        this.field_192223_b.remove(lllllllllllllIlIlIIIIllllIlIIlll);
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIlIIIIllllIlIIIlI, final JsonDeserializationContext lllllllllllllIlIlIIIIllllIlIIIIl) {
        final DamagePredicate lllllllllllllIlIlIIIIllllIlIIIII = DamagePredicate.func_192364_a(lllllllllllllIlIlIIIIllllIlIIIlI.get("damage"));
        final EntityPredicate lllllllllllllIlIlIIIIllllIIlllll = EntityPredicate.func_192481_a(lllllllllllllIlIlIIIIllllIlIIIlI.get("entity"));
        return new Instance(lllllllllllllIlIlIIIIllllIlIIIII, lllllllllllllIlIlIIIIllllIIlllll);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return PlayerHurtEntityTrigger.field_192222_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIlIIIIllllIlllllI, final Listener<Instance> lllllllllllllIlIlIIIIlllllIIIIIl) {
        Listeners lllllllllllllIlIlIIIIlllllIIIIII = this.field_192223_b.get(lllllllllllllIlIlIIIIllllIlllllI);
        if (lllllllllllllIlIlIIIIlllllIIIIII == null) {
            lllllllllllllIlIlIIIIlllllIIIIII = new Listeners(lllllllllllllIlIlIIIIllllIlllllI);
            this.field_192223_b.put(lllllllllllllIlIlIIIIllllIlllllI, lllllllllllllIlIlIIIIlllllIIIIII);
        }
        lllllllllllllIlIlIIIIlllllIIIIII.func_192522_a(lllllllllllllIlIlIIIIlllllIIIIIl);
    }
    
    public void func_192220_a(final EntityPlayerMP lllllllllllllIlIlIIIIllllIIIIlIl, final Entity lllllllllllllIlIlIIIIlllIllIllll, final DamageSource lllllllllllllIlIlIIIIlllIllIllIl, final float lllllllllllllIlIlIIIIlllIllIllII, final float lllllllllllllIlIlIIIIlllIllllIll, final boolean lllllllllllllIlIlIIIIlllIllllIII) {
        final Listeners lllllllllllllIlIlIIIIlllIlllIlIl = this.field_192223_b.get(lllllllllllllIlIlIIIIllllIIIIlIl.func_192039_O());
        if (lllllllllllllIlIlIIIIlllIlllIlIl != null) {
            lllllllllllllIlIlIIIIlllIlllIlIl.func_192521_a(lllllllllllllIlIlIIIIllllIIIIlIl, lllllllllllllIlIlIIIIlllIllIllll, lllllllllllllIlIlIIIIlllIllIllIl, lllllllllllllIlIlIIIIlllIllIllII, lllllllllllllIlIlIIIIlllIllllIll, lllllllllllllIlIlIIIIlllIllllIII);
        }
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIlIIIIllllIllIllI, final Listener<Instance> lllllllllllllIlIlIIIIllllIllIIIl) {
        final Listeners lllllllllllllIlIlIIIIllllIllIlII = this.field_192223_b.get(lllllllllllllIlIlIIIIllllIllIllI);
        if (lllllllllllllIlIlIIIIllllIllIlII != null) {
            lllllllllllllIlIlIIIIllllIllIlII.func_192519_b(lllllllllllllIlIlIIIIllllIllIIIl);
            if (lllllllllllllIlIlIIIIllllIllIlII.func_192520_a()) {
                this.field_192223_b.remove(lllllllllllllIlIlIIIIllllIllIllI);
            }
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192523_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192524_b;
        
        public boolean func_192520_a() {
            return this.field_192524_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIIIllIllllllIIIIll) {
            this.field_192524_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192523_a = lllllllllllllIIIIllIllllllIIIIll;
        }
        
        public void func_192519_b(final Listener<Instance> lllllllllllllIIIIllIlllllIllIlII) {
            this.field_192524_b.remove(lllllllllllllIIIIllIlllllIllIlII);
        }
        
        public void func_192522_a(final Listener<Instance> lllllllllllllIIIIllIlllllIllllII) {
            this.field_192524_b.add(lllllllllllllIIIIllIlllllIllllII);
        }
        
        public void func_192521_a(final EntityPlayerMP lllllllllllllIIIIllIlllllIlIlIII, final Entity lllllllllllllIIIIllIlllllIIlllIl, final DamageSource lllllllllllllIIIIllIlllllIlIIllI, final float lllllllllllllIIIIllIlllllIIllIll, final float lllllllllllllIIIIllIlllllIlIIlII, final boolean lllllllllllllIIIIllIlllllIIllIIl) {
            List<Listener<Instance>> lllllllllllllIIIIllIlllllIlIIIlI = null;
            for (final Listener<Instance> lllllllllllllIIIIllIlllllIlIIIIl : this.field_192524_b) {
                if (lllllllllllllIIIIllIlllllIlIIIIl.func_192158_a().func_192278_a(lllllllllllllIIIIllIlllllIlIlIII, lllllllllllllIIIIllIlllllIIlllIl, lllllllllllllIIIIllIlllllIlIIllI, lllllllllllllIIIIllIlllllIIllIll, lllllllllllllIIIIllIlllllIlIIlII, lllllllllllllIIIIllIlllllIIllIIl)) {
                    if (lllllllllllllIIIIllIlllllIlIIIlI == null) {
                        lllllllllllllIIIIllIlllllIlIIIlI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIIIllIlllllIlIIIlI.add(lllllllllllllIIIIllIlllllIlIIIIl);
                }
            }
            if (lllllllllllllIIIIllIlllllIlIIIlI != null) {
                for (final Listener<Instance> lllllllllllllIIIIllIlllllIlIIIII : lllllllllllllIIIIllIlllllIlIIIlI) {
                    lllllllllllllIIIIllIlllllIlIIIII.func_192159_a(this.field_192523_a);
                }
            }
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ DamagePredicate field_192279_a;
        private final /* synthetic */ EntityPredicate field_192280_b;
        
        public Instance(final DamagePredicate llllllllllllllIIIIllIlllIIIIIIlI, final EntityPredicate llllllllllllllIIIIllIllIlllllllI) {
            super(PlayerHurtEntityTrigger.field_192222_a);
            this.field_192279_a = llllllllllllllIIIIllIlllIIIIIIlI;
            this.field_192280_b = llllllllllllllIIIIllIllIlllllllI;
        }
        
        public boolean func_192278_a(final EntityPlayerMP llllllllllllllIIIIllIllIllllIlIl, final Entity llllllllllllllIIIIllIllIlllIllIl, final DamageSource llllllllllllllIIIIllIllIlllIllII, final float llllllllllllllIIIIllIllIllllIIlI, final float llllllllllllllIIIIllIllIlllIlIlI, final boolean llllllllllllllIIIIllIllIlllIlIIl) {
            return this.field_192279_a.func_192365_a(llllllllllllllIIIIllIllIllllIlIl, llllllllllllllIIIIllIllIlllIllII, llllllllllllllIIIIllIllIllllIIlI, llllllllllllllIIIIllIllIlllIlIlI, llllllllllllllIIIIllIllIlllIlIIl) && this.field_192280_b.func_192482_a(llllllllllllllIIIIllIllIllllIlIl, llllllllllllllIIIIllIllIlllIllIl);
        }
    }
}
