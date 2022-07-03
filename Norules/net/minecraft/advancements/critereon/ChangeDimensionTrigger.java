package net.minecraft.advancements.critereon;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import com.google.gson.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class ChangeDimensionTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193145_b;
    private static final /* synthetic */ ResourceLocation field_193144_a;
    
    @Override
    public void func_192167_a(final PlayerAdvancements llllllllllllllIlIIlIlIIIIIIIIlll) {
        this.field_193145_b.remove(llllllllllllllIlIIlIlIIIIIIIIlll);
    }
    
    public void func_193143_a(final EntityPlayerMP llllllllllllllIlIIlIIlllllllIIll, final DimensionType llllllllllllllIlIIlIIllllllIllIl, final DimensionType llllllllllllllIlIIlIIlllllllIIIl) {
        final Listeners llllllllllllllIlIIlIIlllllllIIII = this.field_193145_b.get(llllllllllllllIlIIlIIlllllllIIll.func_192039_O());
        if (llllllllllllllIlIIlIIlllllllIIII != null) {
            llllllllllllllIlIIlIIlllllllIIII.func_193234_a(llllllllllllllIlIIlIIllllllIllIl, llllllllllllllIlIIlIIlllllllIIIl);
        }
    }
    
    static {
        field_193144_a = new ResourceLocation("changed_dimension");
    }
    
    public ChangeDimensionTrigger() {
        this.field_193145_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements llllllllllllllIlIIlIlIIIIIIlIIIl, final Listener<Instance> llllllllllllllIlIIlIlIIIIIIlIIII) {
        final Listeners llllllllllllllIlIIlIlIIIIIIIllll = this.field_193145_b.get(llllllllllllllIlIIlIlIIIIIIlIIIl);
        if (llllllllllllllIlIIlIlIIIIIIIllll != null) {
            llllllllllllllIlIIlIlIIIIIIIllll.func_193231_b(llllllllllllllIlIIlIlIIIIIIlIIII);
            if (llllllllllllllIlIIlIlIIIIIIIllll.func_193232_a()) {
                this.field_193145_b.remove(llllllllllllllIlIIlIlIIIIIIlIIIl);
            }
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llllllllllllllIlIIlIIlllllllllII, final JsonDeserializationContext llllllllllllllIlIIlIIlllllllllll) {
        final DimensionType llllllllllllllIlIIlIIllllllllllI = llllllllllllllIlIIlIIlllllllllII.has("from") ? DimensionType.func_193417_a(JsonUtils.getString(llllllllllllllIlIIlIIlllllllllII, "from")) : null;
        final DimensionType llllllllllllllIlIIlIIlllllllllIl = llllllllllllllIlIIlIIlllllllllII.has("to") ? DimensionType.func_193417_a(JsonUtils.getString(llllllllllllllIlIIlIIlllllllllII, "to")) : null;
        return new Instance(llllllllllllllIlIIlIIllllllllllI, llllllllllllllIlIIlIIlllllllllIl);
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return ChangeDimensionTrigger.field_193144_a;
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements llllllllllllllIlIIlIlIIIIIIllIIl, final Listener<Instance> llllllllllllllIlIIlIlIIIIIIlllII) {
        Listeners llllllllllllllIlIIlIlIIIIIIllIll = this.field_193145_b.get(llllllllllllllIlIIlIlIIIIIIllIIl);
        if (llllllllllllllIlIIlIlIIIIIIllIll == null) {
            llllllllllllllIlIIlIlIIIIIIllIll = new Listeners(llllllllllllllIlIIlIlIIIIIIllIIl);
            this.field_193145_b.put(llllllllllllllIlIIlIlIIIIIIllIIl, llllllllllllllIlIIlIlIIIIIIllIll);
        }
        llllllllllllllIlIIlIlIIIIIIllIll.func_193233_a(llllllllllllllIlIIlIlIIIIIIlllII);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        @Nullable
        private final /* synthetic */ DimensionType field_193191_a;
        @Nullable
        private final /* synthetic */ DimensionType field_193192_b;
        
        public boolean func_193190_a(final DimensionType llllllllllllllllIIllllIIlIIIlIlI, final DimensionType llllllllllllllllIIllllIIlIIIllII) {
            return (this.field_193191_a == null || this.field_193191_a == llllllllllllllllIIllllIIlIIIlIlI) && (this.field_193192_b == null || this.field_193192_b == llllllllllllllllIIllllIIlIIIllII);
        }
        
        public Instance(@Nullable final DimensionType llllllllllllllllIIllllIIlIIlIIll, @Nullable final DimensionType llllllllllllllllIIllllIIlIIlIIlI) {
            super(ChangeDimensionTrigger.field_193144_a);
            this.field_193191_a = llllllllllllllllIIllllIIlIIlIIll;
            this.field_193192_b = llllllllllllllllIIllllIIlIIlIIlI;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_193235_a;
        private final /* synthetic */ Set<Listener<Instance>> field_193236_b;
        
        public void func_193231_b(final Listener<Instance> lllllllllllllIIIlllIlIlIllIlllII) {
            this.field_193236_b.remove(lllllllllllllIIIlllIlIlIllIlllII);
        }
        
        public void func_193233_a(final Listener<Instance> lllllllllllllIIIlllIlIlIlllIIIII) {
            this.field_193236_b.add(lllllllllllllIIIlllIlIlIlllIIIII);
        }
        
        public boolean func_193232_a() {
            return this.field_193236_b.isEmpty();
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIIlllIlIlIlllIlIll) {
            this.field_193236_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193235_a = lllllllllllllIIIlllIlIlIlllIlIll;
        }
        
        public void func_193234_a(final DimensionType lllllllllllllIIIlllIlIlIllIIllII, final DimensionType lllllllllllllIIIlllIlIlIllIlIIIl) {
            List<Listener<Instance>> lllllllllllllIIIlllIlIlIllIlIIII = null;
            for (final Listener<Instance> lllllllllllllIIIlllIlIlIllIIllll : this.field_193236_b) {
                if (lllllllllllllIIIlllIlIlIllIIllll.func_192158_a().func_193190_a(lllllllllllllIIIlllIlIlIllIIllII, lllllllllllllIIIlllIlIlIllIlIIIl)) {
                    if (lllllllllllllIIIlllIlIlIllIlIIII == null) {
                        lllllllllllllIIIlllIlIlIllIlIIII = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIIlllIlIlIllIlIIII.add(lllllllllllllIIIlllIlIlIllIIllll);
                }
            }
            if (lllllllllllllIIIlllIlIlIllIlIIII != null) {
                for (final Listener<Instance> lllllllllllllIIIlllIlIlIllIIlllI : lllllllllllllIIIlllIlIlIllIlIIII) {
                    lllllllllllllIIIlllIlIlIllIIlllI.func_192159_a(this.field_193235_a);
                }
            }
        }
    }
}
