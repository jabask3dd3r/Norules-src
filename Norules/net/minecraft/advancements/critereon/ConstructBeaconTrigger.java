package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import java.util.*;
import com.google.common.collect.*;

public class ConstructBeaconTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192181_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192182_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllllIIlIlIIlIlIIIlIll, final Listener<Instance> lllllllllllllllIIlIlIIlIlIIIIllI) {
        final Listeners lllllllllllllllIIlIlIIlIlIIIlIIl = this.field_192182_b.get(lllllllllllllllIIlIlIIlIlIIIlIll);
        if (lllllllllllllllIIlIlIIlIlIIIlIIl != null) {
            lllllllllllllllIIlIlIIlIlIIIlIIl.func_192353_b(lllllllllllllllIIlIlIIlIlIIIIllI);
            if (lllllllllllllllIIlIlIIlIlIIIlIIl.func_192354_a()) {
                this.field_192182_b.remove(lllllllllllllllIIlIlIIlIlIIIlIll);
            }
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllllIIlIlIIlIIlllllll) {
        this.field_192182_b.remove(lllllllllllllllIIlIlIIlIIlllllll);
    }
    
    public ConstructBeaconTrigger() {
        this.field_192182_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ConstructBeaconTrigger.field_192181_a;
    }
    
    static {
        field_192181_a = new ResourceLocation("construct_beacon");
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllllIIlIlIIlIIllllIII, final JsonDeserializationContext lllllllllllllllIIlIlIIlIIllllIlI) {
        final MinMaxBounds lllllllllllllllIIlIlIIlIIllllIIl = MinMaxBounds.func_192515_a(lllllllllllllllIIlIlIIlIIllllIII.get("level"));
        return new Instance(lllllllllllllllIIlIlIIlIIllllIIl);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllllIIlIlIIlIlIIlIIll, final Listener<Instance> lllllllllllllllIIlIlIIlIlIIlIIlI) {
        Listeners lllllllllllllllIIlIlIIlIlIIlIlIl = this.field_192182_b.get(lllllllllllllllIIlIlIIlIlIIlIIll);
        if (lllllllllllllllIIlIlIIlIlIIlIlIl == null) {
            lllllllllllllllIIlIlIIlIlIIlIlIl = new Listeners(lllllllllllllllIIlIlIIlIlIIlIIll);
            this.field_192182_b.put(lllllllllllllllIIlIlIIlIlIIlIIll, lllllllllllllllIIlIlIIlIlIIlIlIl);
        }
        lllllllllllllllIIlIlIIlIlIIlIlIl.func_192355_a(lllllllllllllllIIlIlIIlIlIIlIIlI);
    }
    
    public void func_192180_a(final EntityPlayerMP lllllllllllllllIIlIlIIlIIlllIIIl, final TileEntityBeacon lllllllllllllllIIlIlIIlIIlllIIII) {
        final Listeners lllllllllllllllIIlIlIIlIIllIllll = this.field_192182_b.get(lllllllllllllllIIlIlIIlIIlllIIIl.func_192039_O());
        if (lllllllllllllllIIlIlIIlIIllIllll != null) {
            lllllllllllllllIIlIlIIlIIllIllll.func_192352_a(lllllllllllllllIIlIlIIlIIlllIIII);
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192253_a;
        
        public boolean func_192252_a(final TileEntityBeacon llllllllllllllIlIllllllllIlIllIl) {
            return this.field_192253_a.func_192514_a((float)llllllllllllllIlIllllllllIlIllIl.func_191979_s());
        }
        
        public Instance(final MinMaxBounds llllllllllllllIlIllllllllIllIIll) {
            super(ConstructBeaconTrigger.field_192181_a);
            this.field_192253_a = llllllllllllllIlIllllllllIllIIll;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192356_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192357_b;
        
        public void func_192353_b(final Listener<Instance> lllllllllllllllIIllIlllIlIIllIll) {
            this.field_192357_b.remove(lllllllllllllllIIllIlllIlIIllIll);
        }
        
        public void func_192352_a(final TileEntityBeacon lllllllllllllllIIllIlllIlIIIllll) {
            List<Listener<Instance>> lllllllllllllllIIllIlllIlIIlIIll = null;
            for (final Listener<Instance> lllllllllllllllIIllIlllIlIIlIIlI : this.field_192357_b) {
                if (lllllllllllllllIIllIlllIlIIlIIlI.func_192158_a().func_192252_a(lllllllllllllllIIllIlllIlIIIllll)) {
                    if (lllllllllllllllIIllIlllIlIIlIIll == null) {
                        lllllllllllllllIIllIlllIlIIlIIll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIIllIlllIlIIlIIll.add(lllllllllllllllIIllIlllIlIIlIIlI);
                }
            }
            if (lllllllllllllllIIllIlllIlIIlIIll != null) {
                for (final Listener<Instance> lllllllllllllllIIllIlllIlIIlIIIl : lllllllllllllllIIllIlllIlIIlIIll) {
                    lllllllllllllllIIllIlllIlIIlIIIl.func_192159_a(this.field_192356_a);
                }
            }
        }
        
        public void func_192355_a(final Listener<Instance> lllllllllllllllIIllIlllIlIlIIIll) {
            this.field_192357_b.add(lllllllllllllllIIllIlllIlIlIIIll);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllllIIllIlllIlIlIlIlI) {
            this.field_192357_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192356_a = lllllllllllllllIIllIlllIlIlIlIlI;
        }
        
        public boolean func_192354_a() {
            return this.field_192357_b.isEmpty();
        }
    }
}
