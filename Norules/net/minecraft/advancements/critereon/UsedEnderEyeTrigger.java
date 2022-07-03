package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import java.util.*;
import com.google.common.collect.*;

public class UsedEnderEyeTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192242_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192243_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllllIIIlIllIIllIlIlIlI, final Listener<Instance> llllllllllllllIIIlIllIIllIlIIlIl) {
        final Listeners llllllllllllllIIIlIllIIllIlIlIII = this.field_192243_b.get(llllllllllllllIIIlIllIIllIlIlIlI);
        if (llllllllllllllIIIlIllIIllIlIlIII != null) {
            llllllllllllllIIIlIllIIllIlIlIII.func_192544_b(llllllllllllllIIIlIllIIllIlIIlIl);
            if (llllllllllllllIIIlIllIIllIlIlIII.func_192545_a()) {
                this.field_192243_b.remove(llllllllllllllIIIlIllIIllIlIlIlI);
            }
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllllIIIlIllIIllIIlIlll, final JsonDeserializationContext llllllllllllllIIIlIllIIllIIllIIl) {
        final MinMaxBounds llllllllllllllIIIlIllIIllIIllIII = MinMaxBounds.func_192515_a(llllllllllllllIIIlIllIIllIIlIlll.get("distance"));
        return new Instance(llllllllllllllIIIlIllIIllIIllIII);
    }
    
    public UsedEnderEyeTrigger() {
        this.field_192243_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllllIIIlIllIIllIlIIIII) {
        this.field_192243_b.remove(llllllllllllllIIIlIllIIllIlIIIII);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return UsedEnderEyeTrigger.field_192242_a;
    }
    
    public void func_192239_a(final EntityPlayerMP llllllllllllllIIIlIllIIllIIIlIII, final BlockPos llllllllllllllIIIlIllIIllIIIIlll) {
        final Listeners llllllllllllllIIIlIllIIllIIIllII = this.field_192243_b.get(llllllllllllllIIIlIllIIllIIIlIII.func_192039_O());
        if (llllllllllllllIIIlIllIIllIIIllII != null) {
            final double llllllllllllllIIIlIllIIllIIIlIll = llllllllllllllIIIlIllIIllIIIlIII.posX - llllllllllllllIIIlIllIIllIIIIlll.getX();
            final double llllllllllllllIIIlIllIIllIIIlIlI = llllllllllllllIIIlIllIIllIIIlIII.posZ - llllllllllllllIIIlIllIIllIIIIlll.getZ();
            llllllllllllllIIIlIllIIllIIIllII.func_192543_a(llllllllllllllIIIlIllIIllIIIlIll * llllllllllllllIIIlIllIIllIIIlIll + llllllllllllllIIIlIllIIllIIIlIlI * llllllllllllllIIIlIllIIllIIIlIlI);
        }
    }
    
    static {
        field_192242_a = new ResourceLocation("used_ender_eye");
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllllIIIlIllIIllIllIllI, final Listener<Instance> llllllllllllllIIIlIllIIllIllIlIl) {
        Listeners llllllllllllllIIIlIllIIllIllIlII = this.field_192243_b.get(llllllllllllllIIIlIllIIllIllIllI);
        if (llllllllllllllIIIlIllIIllIllIlII == null) {
            llllllllllllllIIIlIllIIllIllIlII = new Listeners(llllllllllllllIIIlIllIIllIllIllI);
            this.field_192243_b.put(llllllllllllllIIIlIllIIllIllIllI, llllllllllllllIIIlIllIIllIllIlII);
        }
        llllllllllllllIIIlIllIIllIllIlII.func_192546_a(llllllllllllllIIIlIllIIllIllIlIl);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ MinMaxBounds field_192289_a;
        
        public Instance(final MinMaxBounds lllllllllllllIlllllllllIllllIIIl) {
            super(UsedEnderEyeTrigger.field_192242_a);
            this.field_192289_a = lllllllllllllIlllllllllIllllIIIl;
        }
        
        public boolean func_192288_a(final double lllllllllllllIlllllllllIlllIlIll) {
            return this.field_192289_a.func_192513_a(lllllllllllllIlllllllllIlllIlIll);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192547_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192548_b;
        
        public void func_192543_a(final double llIIIIIlIlllIIl) {
            List<Listener<Instance>> llIIIIIlIlllIII = null;
            for (final Listener<Instance> llIIIIIlIllIlll : this.field_192548_b) {
                if (llIIIIIlIllIlll.func_192158_a().func_192288_a(llIIIIIlIlllIIl)) {
                    if (llIIIIIlIlllIII == null) {
                        llIIIIIlIlllIII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llIIIIIlIlllIII.add(llIIIIIlIllIlll);
                }
            }
            if (llIIIIIlIlllIII != null) {
                for (final Listener<Instance> llIIIIIlIllIllI : llIIIIIlIlllIII) {
                    llIIIIIlIllIllI.func_192159_a(this.field_192547_a);
                }
            }
        }
        
        public void func_192544_b(final Listener<Instance> llIIIIIllIIIIlI) {
            this.field_192548_b.remove(llIIIIIllIIIIlI);
        }
        
        public boolean func_192545_a() {
            return this.field_192548_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements llIIIIIllIIllll) {
            this.field_192548_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192547_a = llIIIIIllIIllll;
        }
        
        public void func_192546_a(final Listener<Instance> llIIIIIllIIlIII) {
            this.field_192548_b.add(llIIIIIllIIlIII);
        }
    }
}
