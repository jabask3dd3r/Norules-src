package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import com.google.common.collect.*;

public class NetherTravelTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193169_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193170_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIlIIllllIlIlllIlIll, final Listener<Instance> lllllllllllllIlIIllllIlIlllIIllI) {
        final Listeners lllllllllllllIlIIllllIlIlllIlIIl = this.field_193170_b.get(lllllllllllllIlIIllllIlIlllIlIll);
        if (lllllllllllllIlIIllllIlIlllIlIIl != null) {
            lllllllllllllIlIIllllIlIlllIlIIl.func_193481_b(lllllllllllllIlIIllllIlIlllIIllI);
            if (lllllllllllllIlIIllllIlIlllIlIIl.func_193482_a()) {
                this.field_193170_b.remove(lllllllllllllIlIIllllIlIlllIlIll);
            }
        }
    }
    
    static {
        field_193169_a = new ResourceLocation("nether_travel");
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIlIIllllIlIllIlIlII, final JsonDeserializationContext lllllllllllllIlIIllllIlIllIllIII) {
        final LocationPredicate lllllllllllllIlIIllllIlIllIlIlll = LocationPredicate.func_193454_a(lllllllllllllIlIIllllIlIllIlIlII.get("entered"));
        final LocationPredicate lllllllllllllIlIIllllIlIllIlIllI = LocationPredicate.func_193454_a(lllllllllllllIlIIllllIlIllIlIlII.get("exited"));
        final DistancePredicate lllllllllllllIlIIllllIlIllIlIlIl = DistancePredicate.func_193421_a(lllllllllllllIlIIllllIlIllIlIlII.get("distance"));
        return new Instance(lllllllllllllIlIIllllIlIllIlIlll, lllllllllllllIlIIllllIlIllIlIllI, lllllllllllllIlIIllllIlIllIlIlIl);
    }
    
    public NetherTravelTrigger() {
        this.field_193170_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return NetherTravelTrigger.field_193169_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIlIIllllIlIllIlllll) {
        this.field_193170_b.remove(lllllllllllllIlIIllllIlIllIlllll);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIlIIllllIlIllllIIll, final Listener<Instance> lllllllllllllIlIIllllIlIllllIIlI) {
        Listeners lllllllllllllIlIIllllIlIllllIlIl = this.field_193170_b.get(lllllllllllllIlIIllllIlIllllIIll);
        if (lllllllllllllIlIIllllIlIllllIlIl == null) {
            lllllllllllllIlIIllllIlIllllIlIl = new Listeners(lllllllllllllIlIIllllIlIllllIIll);
            this.field_193170_b.put(lllllllllllllIlIIllllIlIllllIIll, lllllllllllllIlIIllllIlIllllIlIl);
        }
        lllllllllllllIlIIllllIlIllllIlIl.func_193484_a(lllllllllllllIlIIllllIlIllllIIlI);
    }
    
    public void func_193168_a(final EntityPlayerMP lllllllllllllIlIIllllIlIllIIIlll, final Vec3d lllllllllllllIlIIllllIlIllIIlIlI) {
        final Listeners lllllllllllllIlIIllllIlIllIIlIIl = this.field_193170_b.get(lllllllllllllIlIIllllIlIllIIIlll.func_192039_O());
        if (lllllllllllllIlIIllllIlIllIIlIIl != null) {
            lllllllllllllIlIIllllIlIllIIlIIl.func_193483_a(lllllllllllllIlIIllllIlIllIIIlll.getServerWorld(), lllllllllllllIlIIllllIlIllIIlIlI, lllllllllllllIlIIllllIlIllIIIlll.posX, lllllllllllllIlIIllllIlIllIIIlll.posY, lllllllllllllIlIIllllIlIllIIIlll.posZ);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193485_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193486_b;
        
        public void func_193484_a(final Listener<Instance> lllllllllllllIIlllIlIIlIlllIIlII) {
            this.field_193486_b.add(lllllllllllllIIlllIlIIlIlllIIlII);
        }
        
        public void func_193483_a(final WorldServer lllllllllllllIIlllIlIIlIllIIlIII, final Vec3d lllllllllllllIIlllIlIIlIllIIIlll, final double lllllllllllllIIlllIlIIlIllIIIllI, final double lllllllllllllIIlllIlIIlIllIIIlIl, final double lllllllllllllIIlllIlIIlIllIIllIl) {
            List<Listener<Instance>> lllllllllllllIIlllIlIIlIllIIllII = null;
            for (final Listener<Instance> lllllllllllllIIlllIlIIlIllIIlIll : this.field_193486_b) {
                if (lllllllllllllIIlllIlIIlIllIIlIll.func_192158_a().func_193206_a(lllllllllllllIIlllIlIIlIllIIlIII, lllllllllllllIIlllIlIIlIllIIIlll, lllllllllllllIIlllIlIIlIllIIIllI, lllllllllllllIIlllIlIIlIllIIIlIl, lllllllllllllIIlllIlIIlIllIIllIl)) {
                    if (lllllllllllllIIlllIlIIlIllIIllII == null) {
                        lllllllllllllIIlllIlIIlIllIIllII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIlllIlIIlIllIIllII.add(lllllllllllllIIlllIlIIlIllIIlIll);
                }
            }
            if (lllllllllllllIIlllIlIIlIllIIllII != null) {
                for (final Listener<Instance> lllllllllllllIIlllIlIIlIllIIlIlI : lllllllllllllIIlllIlIIlIllIIllII) {
                    lllllllllllllIIlllIlIIlIllIIlIlI.func_192159_a(this.field_193485_a);
                }
            }
        }
        
        public void func_193481_b(final Listener<Instance> lllllllllllllIIlllIlIIlIllIlllII) {
            this.field_193486_b.remove(lllllllllllllIIlllIlIIlIllIlllII);
        }
        
        public boolean func_193482_a() {
            return this.field_193486_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIlllIlIIlIlllIllIl) {
            this.field_193486_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193485_a = lllllllllllllIIlllIlIIlIlllIllIl;
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ LocationPredicate field_193207_a;
        private final /* synthetic */ LocationPredicate field_193208_b;
        private final /* synthetic */ DistancePredicate field_193209_c;
        
        public boolean func_193206_a(final WorldServer llllllllllllllIIIIIllIllIIIlIlIl, final Vec3d llllllllllllllIIIIIllIllIIIlIlII, final double llllllllllllllIIIIIllIllIIIlIIll, final double llllllllllllllIIIIIllIllIIIllIII, final double llllllllllllllIIIIIllIllIIIlIlll) {
            return this.field_193207_a.func_193452_a(llllllllllllllIIIIIllIllIIIlIlIl, llllllllllllllIIIIIllIllIIIlIlII.xCoord, llllllllllllllIIIIIllIllIIIlIlII.yCoord, llllllllllllllIIIIIllIllIIIlIlII.zCoord) && this.field_193208_b.func_193452_a(llllllllllllllIIIIIllIllIIIlIlIl, llllllllllllllIIIIIllIllIIIlIIll, llllllllllllllIIIIIllIllIIIllIII, llllllllllllllIIIIIllIllIIIlIlll) && this.field_193209_c.func_193422_a(llllllllllllllIIIIIllIllIIIlIlII.xCoord, llllllllllllllIIIIIllIllIIIlIlII.yCoord, llllllllllllllIIIIIllIllIIIlIlII.zCoord, llllllllllllllIIIIIllIllIIIlIIll, llllllllllllllIIIIIllIllIIIllIII, llllllllllllllIIIIIllIllIIIlIlll);
        }
        
        public Instance(final LocationPredicate llllllllllllllIIIIIllIllIIlIIlIl, final LocationPredicate llllllllllllllIIIIIllIllIIlIlIII, final DistancePredicate llllllllllllllIIIIIllIllIIlIIlll) {
            super(NetherTravelTrigger.field_193169_a);
            this.field_193207_a = llllllllllllllIIIIIllIllIIlIIlIl;
            this.field_193208_b = llllllllllllllIIIIIllIllIIlIlIII;
            this.field_193209_c = llllllllllllllIIIIIllIllIIlIIlll;
        }
    }
}
