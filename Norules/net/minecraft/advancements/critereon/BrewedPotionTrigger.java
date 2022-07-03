package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import net.minecraft.potion.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class BrewedPotionTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192177_b;
    private static final /* synthetic */ ResourceLocation field_192176_a;
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllllIIIllIllIllllllIl) {
        this.field_192177_b.remove(lllllllllllllllIIIllIllIllllllIl);
    }
    
    public BrewedPotionTrigger() {
        this.field_192177_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return BrewedPotionTrigger.field_192176_a;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllllIIIllIllIllllIlII, final JsonDeserializationContext lllllllllllllllIIIllIllIllllIlll) {
        PotionType lllllllllllllllIIIllIllIllllIllI = null;
        if (lllllllllllllllIIIllIllIllllIlII.has("potion")) {
            final ResourceLocation lllllllllllllllIIIllIllIllllIlIl = new ResourceLocation(JsonUtils.getString(lllllllllllllllIIIllIllIllllIlII, "potion"));
            if (!PotionType.REGISTRY.containsKey(lllllllllllllllIIIllIllIllllIlIl)) {
                throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown potion '").append(lllllllllllllllIIIllIllIllllIlIl).append("'")));
            }
            lllllllllllllllIIIllIllIllllIllI = PotionType.REGISTRY.getObject(lllllllllllllllIIIllIllIllllIlIl);
        }
        return new Instance(lllllllllllllllIIIllIllIllllIllI);
    }
    
    static {
        field_192176_a = new ResourceLocation("brewed_potion");
    }
    
    public void func_192173_a(final EntityPlayerMP lllllllllllllllIIIllIllIlllIllII, final PotionType lllllllllllllllIIIllIllIlllIlIll) {
        final Listeners lllllllllllllllIIIllIllIlllIlIlI = this.field_192177_b.get(lllllllllllllllIIIllIllIlllIllII.func_192039_O());
        if (lllllllllllllllIIIllIllIlllIlIlI != null) {
            lllllllllllllllIIIllIllIlllIlIlI.func_192348_a(lllllllllllllllIIIllIllIlllIlIll);
        }
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllllIIIllIlllIIIlIlIl, final Listener<Instance> lllllllllllllllIIIllIlllIIIlIlII) {
        Listeners lllllllllllllllIIIllIlllIIIlIIll = this.field_192177_b.get(lllllllllllllllIIIllIlllIIIlIlIl);
        if (lllllllllllllllIIIllIlllIIIlIIll == null) {
            lllllllllllllllIIIllIlllIIIlIIll = new Listeners(lllllllllllllllIIIllIlllIIIlIlIl);
            this.field_192177_b.put(lllllllllllllllIIIllIlllIIIlIlIl, lllllllllllllllIIIllIlllIIIlIIll);
        }
        lllllllllllllllIIIllIlllIIIlIIll.func_192349_a(lllllllllllllllIIIllIlllIIIlIlII);
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllllIIIllIlllIIIIlIIl, final Listener<Instance> lllllllllllllllIIIllIlllIIIIlIII) {
        final Listeners lllllllllllllllIIIllIlllIIIIIlll = this.field_192177_b.get(lllllllllllllllIIIllIlllIIIIlIIl);
        if (lllllllllllllllIIIllIlllIIIIIlll != null) {
            lllllllllllllllIIIllIlllIIIIIlll.func_192346_b(lllllllllllllllIIIllIlllIIIIlIII);
            if (lllllllllllllllIIIllIlllIIIIIlll.func_192347_a()) {
                this.field_192177_b.remove(lllllllllllllllIIIllIlllIIIIlIIl);
            }
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ PotionType field_192251_a;
        
        public boolean func_192250_a(final PotionType llllllllllllllIIIllIlIIIlllIlIll) {
            return this.field_192251_a == null || this.field_192251_a == llllllllllllllIIIllIlIIIlllIlIll;
        }
        
        public Instance(@Nullable final PotionType llllllllllllllIIIllIlIIIllllIIIl) {
            super(BrewedPotionTrigger.field_192176_a);
            this.field_192251_a = llllllllllllllIIIllIlIIIllllIIIl;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_192351_b;
        private final /* synthetic */ PlayerAdvancements field_192350_a;
        
        public Listeners(final PlayerAdvancements lllllllllllllIIlllIlIIlIlIllIIll) {
            this.field_192351_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192350_a = lllllllllllllIIlllIlIIlIlIllIIll;
        }
        
        public void func_192346_b(final Listener<Instance> lllllllllllllIIlllIlIIlIlIlIIllI) {
            this.field_192351_b.remove(lllllllllllllIIlllIlIIlIlIlIIllI);
        }
        
        public void func_192348_a(final PotionType lllllllllllllIIlllIlIIlIlIIlllIl) {
            List<Listener<Instance>> lllllllllllllIIlllIlIIlIlIIlllII = null;
            for (final Listener<Instance> lllllllllllllIIlllIlIIlIlIIllIll : this.field_192351_b) {
                if (lllllllllllllIIlllIlIIlIlIIllIll.func_192158_a().func_192250_a(lllllllllllllIIlllIlIIlIlIIlllIl)) {
                    if (lllllllllllllIIlllIlIIlIlIIlllII == null) {
                        lllllllllllllIIlllIlIIlIlIIlllII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIlllIlIIlIlIIlllII.add(lllllllllllllIIlllIlIIlIlIIllIll);
                }
            }
            if (lllllllllllllIIlllIlIIlIlIIlllII != null) {
                for (final Listener<Instance> lllllllllllllIIlllIlIIlIlIIllIlI : lllllllllllllIIlllIlIIlIlIIlllII) {
                    lllllllllllllIIlllIlIIlIlIIllIlI.func_192159_a(this.field_192350_a);
                }
            }
        }
        
        public boolean func_192347_a() {
            return this.field_192351_b.isEmpty();
        }
        
        public void func_192349_a(final Listener<Instance> lllllllllllllIIlllIlIIlIlIlIlIlI) {
            this.field_192351_b.add(lllllllllllllIIlllIlIIlIlIlIlIlI);
        }
    }
}
