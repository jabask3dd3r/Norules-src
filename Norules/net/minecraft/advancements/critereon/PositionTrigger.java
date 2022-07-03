package net.minecraft.advancements.critereon;

import net.minecraft.util.*;
import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import com.google.gson.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import java.util.*;

public class PositionTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192218_b;
    private final /* synthetic */ ResourceLocation field_192217_a;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIIIllllIllIIIIllIIl, final Listener<Instance> lllllllllllllIIIllllIllIIIIlIlII) {
        final Listeners lllllllllllllIIIllllIllIIIIlIlll = this.field_192218_b.get(lllllllllllllIIIllllIllIIIIllIIl);
        if (lllllllllllllIIIllllIllIIIIlIlll != null) {
            lllllllllllllIIIllllIllIIIIlIlll.func_192507_b(lllllllllllllIIIllllIllIIIIlIlII);
            if (lllllllllllllIIIllllIllIIIIlIlll.func_192508_a()) {
                this.field_192218_b.remove(lllllllllllllIIIllllIllIIIIllIIl);
            }
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return this.field_192217_a;
    }
    
    public void func_192215_a(final EntityPlayerMP lllllllllllllIIIllllIlIllllllIll) {
        final Listeners lllllllllllllIIIllllIlIlllllllIl = this.field_192218_b.get(lllllllllllllIIIllllIlIllllllIll.func_192039_O());
        if (lllllllllllllIIIllllIlIlllllllIl != null) {
            lllllllllllllIIIllllIlIlllllllIl.func_193462_a(lllllllllllllIIIllllIlIllllllIll.getServerWorld(), lllllllllllllIIIllllIlIllllllIll.posX, lllllllllllllIIIllllIlIllllllIll.posY, lllllllllllllIIIllllIlIllllllIll.posZ);
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIIIllllIllIIIIIllIl) {
        this.field_192218_b.remove(lllllllllllllIIIllllIllIIIIIllIl);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIIIllllIllIIIlIIIIl, final Listener<Instance> lllllllllllllIIIllllIllIIIlIIIII) {
        Listeners lllllllllllllIIIllllIllIIIlIIIll = this.field_192218_b.get(lllllllllllllIIIllllIllIIIlIIIIl);
        if (lllllllllllllIIIllllIllIIIlIIIll == null) {
            lllllllllllllIIIllllIllIIIlIIIll = new Listeners(lllllllllllllIIIllllIllIIIlIIIIl);
            this.field_192218_b.put(lllllllllllllIIIllllIllIIIlIIIIl, lllllllllllllIIIllllIllIIIlIIIll);
        }
        lllllllllllllIIIllllIllIIIlIIIll.func_192510_a(lllllllllllllIIIllllIllIIIlIIIII);
    }
    
    public PositionTrigger(final ResourceLocation lllllllllllllIIIllllIllIIIllIIII) {
        this.field_192218_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
        this.field_192217_a = lllllllllllllIIIllllIllIIIllIIII;
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIIIllllIllIIIIIIlII, final JsonDeserializationContext lllllllllllllIIIllllIllIIIIIIlll) {
        final LocationPredicate lllllllllllllIIIllllIllIIIIIIllI = LocationPredicate.func_193454_a((JsonElement)lllllllllllllIIIllllIllIIIIIIlII);
        return new Instance(this.field_192217_a, lllllllllllllIIIllllIllIIIIIIllI);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ LocationPredicate field_193205_a;
        
        public boolean func_193204_a(final WorldServer lllllllllllllIIlllIIllllIIIIIIIl, final double lllllllllllllIIlllIIlllIlllllIll, final double lllllllllllllIIlllIIlllIllllllll, final double lllllllllllllIIlllIIlllIlllllIIl) {
            return this.field_193205_a.func_193452_a(lllllllllllllIIlllIIllllIIIIIIIl, lllllllllllllIIlllIIlllIlllllIll, lllllllllllllIIlllIIlllIllllllll, lllllllllllllIIlllIIlllIlllllIIl);
        }
        
        public Instance(final ResourceLocation lllllllllllllIIlllIIllllIIIIlIIl, final LocationPredicate lllllllllllllIIlllIIllllIIIIlIII) {
            super(lllllllllllllIIlllIIllllIIIIlIIl);
            this.field_193205_a = lllllllllllllIIlllIIllllIIIIlIII;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192511_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192512_b;
        
        public Listeners(final PlayerAdvancements llllllllllllllIlIIlIIIlIlIIlIIll) {
            this.field_192512_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192511_a = llllllllllllllIlIIlIIIlIlIIlIIll;
        }
        
        public void func_193462_a(final WorldServer llllllllllllllIlIIlIIIlIIlllIIII, final double llllllllllllllIlIIlIIIlIIlllIlll, final double llllllllllllllIlIIlIIIlIIlllIllI, final double llllllllllllllIlIIlIIIlIIllIllIl) {
            List<Listener<Instance>> llllllllllllllIlIIlIIIlIIlllIlII = null;
            for (final Listener<Instance> llllllllllllllIlIIlIIIlIIlllIIll : this.field_192512_b) {
                if (llllllllllllllIlIIlIIIlIIlllIIll.func_192158_a().func_193204_a(llllllllllllllIlIIlIIIlIIlllIIII, llllllllllllllIlIIlIIIlIIlllIlll, llllllllllllllIlIIlIIIlIIlllIllI, llllllllllllllIlIIlIIIlIIllIllIl)) {
                    if (llllllllllllllIlIIlIIIlIIlllIlII == null) {
                        llllllllllllllIlIIlIIIlIIlllIlII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    llllllllllllllIlIIlIIIlIIlllIlII.add(llllllllllllllIlIIlIIIlIIlllIIll);
                }
            }
            if (llllllllllllllIlIIlIIIlIIlllIlII != null) {
                for (final Listener<Instance> llllllllllllllIlIIlIIIlIIlllIIlI : llllllllllllllIlIIlIIIlIIlllIlII) {
                    llllllllllllllIlIIlIIIlIIlllIIlI.func_192159_a(this.field_192511_a);
                }
            }
        }
        
        public void func_192507_b(final Listener<Instance> llllllllllllllIlIIlIIIlIlIIIIlII) {
            this.field_192512_b.remove(llllllllllllllIlIIlIIIlIlIIIIlII);
        }
        
        public void func_192510_a(final Listener<Instance> llllllllllllllIlIIlIIIlIlIIIlIII) {
            this.field_192512_b.add(llllllllllllllIlIIlIIIlIlIIIlIII);
        }
        
        public boolean func_192508_a() {
            return this.field_192512_b.isEmpty();
        }
    }
}
