package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import java.util.*;
import com.google.common.collect.*;

public class LevitationTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193164_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193165_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllllIlIIIIIllIlIlIlIll, final Listener<Instance> llllllllllllllIlIIIIIllIlIlIlllI) {
        final Listeners llllllllllllllIlIIIIIllIlIlIllIl = this.field_193165_b.get(llllllllllllllIlIIIIIllIlIlIlIll);
        if (llllllllllllllIlIIIIIllIlIlIllIl != null) {
            llllllllllllllIlIIIIIllIlIlIllIl.func_193446_b(llllllllllllllIlIIIIIllIlIlIlllI);
            if (llllllllllllllIlIIIIIllIlIlIllIl.func_193447_a()) {
                this.field_193165_b.remove(llllllllllllllIlIIIIIllIlIlIlIll);
            }
        }
    }
    
    public void func_193162_a(final EntityPlayerMP llllllllllllllIlIIIIIllIlIIIllII, final Vec3d llllllllllllllIlIIIIIllIlIIlIIII, final int llllllllllllllIlIIIIIllIlIIIlIlI) {
        final Listeners llllllllllllllIlIIIIIllIlIIIlllI = this.field_193165_b.get(llllllllllllllIlIIIIIllIlIIIllII.func_192039_O());
        if (llllllllllllllIlIIIIIllIlIIIlllI != null) {
            llllllllllllllIlIIIIIllIlIIIlllI.func_193448_a(llllllllllllllIlIIIIIllIlIIIllII, llllllllllllllIlIIIIIllIlIIlIIII, llllllllllllllIlIIIIIllIlIIIlIlI);
        }
    }
    
    public LevitationTrigger() {
        this.field_193165_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllllIlIIIIIllIlIIllIlI, final JsonDeserializationContext llllllllllllllIlIIIIIllIlIIlllIl) {
        final DistancePredicate llllllllllllllIlIIIIIllIlIIlllII = DistancePredicate.func_193421_a(llllllllllllllIlIIIIIllIlIIllIlI.get("distance"));
        final MinMaxBounds llllllllllllllIlIIIIIllIlIIllIll = MinMaxBounds.func_192515_a(llllllllllllllIlIIIIIllIlIIllIlI.get("duration"));
        return new Instance(llllllllllllllIlIIIIIllIlIIlllII, llllllllllllllIlIIIIIllIlIIllIll);
    }
    
    static {
        field_193164_a = new ResourceLocation("levitation");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllllIlIIIIIllIlIlllIll, final Listener<Instance> llllllllllllllIlIIIIIllIlIlllIlI) {
        Listeners llllllllllllllIlIIIIIllIlIlllIIl = this.field_193165_b.get(llllllllllllllIlIIIIIllIlIlllIll);
        if (llllllllllllllIlIIIIIllIlIlllIIl == null) {
            llllllllllllllIlIIIIIllIlIlllIIl = new Listeners(llllllllllllllIlIIIIIllIlIlllIll);
            this.field_193165_b.put(llllllllllllllIlIIIIIllIlIlllIll, llllllllllllllIlIIIIIllIlIlllIIl);
        }
        llllllllllllllIlIIIIIllIlIlllIIl.func_193449_a(llllllllllllllIlIIIIIllIlIlllIlI);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return LevitationTrigger.field_193164_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllllIlIIIIIllIlIlIIIll) {
        this.field_193165_b.remove(llllllllllllllIlIIIIIllIlIlIIIll);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_193203_b;
        private final /* synthetic */ DistancePredicate field_193202_a;
        
        public Instance(final DistancePredicate lllllllllllllIlIllIlIIllIllIIlII, final MinMaxBounds lllllllllllllIlIllIlIIllIllIIIll) {
            super(LevitationTrigger.field_193164_a);
            this.field_193202_a = lllllllllllllIlIllIlIIllIllIIlII;
            this.field_193203_b = lllllllllllllIlIllIlIIllIllIIIll;
        }
        
        public boolean func_193201_a(final EntityPlayerMP lllllllllllllIlIllIlIIllIlIllIIl, final Vec3d lllllllllllllIlIllIlIIllIlIlllII, final int lllllllllllllIlIllIlIIllIlIlIlll) {
            return this.field_193202_a.func_193422_a(lllllllllllllIlIllIlIIllIlIlllII.xCoord, lllllllllllllIlIllIlIIllIlIlllII.yCoord, lllllllllllllIlIllIlIIllIlIlllII.zCoord, lllllllllllllIlIllIlIIllIlIllIIl.posX, lllllllllllllIlIllIlIIllIlIllIIl.posY, lllllllllllllIlIllIlIIllIlIllIIl.posZ) && this.field_193203_b.func_192514_a((float)lllllllllllllIlIllIlIIllIlIlIlll);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193451_b;
        private final /* synthetic */ PlayerAdvancements field_193450_a;
        
        public void func_193446_b(final Listener<Instance> llllllllllllllIlIllIIllllllIIIIl) {
            this.field_193451_b.remove(llllllllllllllIlIllIIllllllIIIIl);
        }
        
        public boolean func_193447_a() {
            return this.field_193451_b.isEmpty();
        }
        
        public void func_193449_a(final Listener<Instance> llllllllllllllIlIllIIllllllIIlll) {
            this.field_193451_b.add(llllllllllllllIlIllIIllllllIIlll);
        }
        
        public void func_193448_a(final EntityPlayerMP llllllllllllllIlIllIIlllllIlIIIl, final Vec3d llllllllllllllIlIllIIlllllIlIlll, final int llllllllllllllIlIllIIlllllIIllll) {
            List<Listener<Instance>> llllllllllllllIlIllIIlllllIlIlIl = null;
            for (final Listener<Instance> llllllllllllllIlIllIIlllllIlIlII : this.field_193451_b) {
                if (llllllllllllllIlIllIIlllllIlIlII.func_192158_a().func_193201_a(llllllllllllllIlIllIIlllllIlIIIl, llllllllllllllIlIllIIlllllIlIlll, llllllllllllllIlIllIIlllllIIllll)) {
                    if (llllllllllllllIlIllIIlllllIlIlIl == null) {
                        llllllllllllllIlIllIIlllllIlIlIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIlIllIIlllllIlIlIl.add(llllllllllllllIlIllIIlllllIlIlII);
                }
            }
            if (llllllllllllllIlIllIIlllllIlIlIl != null) {
                for (final Listener<Instance> llllllllllllllIlIllIIlllllIlIIll : llllllllllllllIlIllIIlllllIlIlIl) {
                    llllllllllllllIlIllIIlllllIlIIll.func_192159_a(this.field_193450_a);
                }
            }
        }
        
        public Listeners(final PlayerAdvancements llllllllllllllIlIllIIlllllllIIlI) {
            this.field_193451_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193450_a = llllllllllllllIlIllIIlllllllIIlI;
        }
    }
}
