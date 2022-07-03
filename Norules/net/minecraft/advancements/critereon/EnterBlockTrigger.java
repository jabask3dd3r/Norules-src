package net.minecraft.advancements.critereon;

import net.minecraft.advancements.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import com.google.gson.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;

public class EnterBlockTrigger implements ICriterionTrigger<Instance>
{
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192197_b;
    private static final /* synthetic */ ResourceLocation field_192196_a;
    
    static {
        field_192196_a = new ResourceLocation("enter_block");
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return EnterBlockTrigger.field_192196_a;
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIllIIlIllIllIllIIIl, final Listener<Instance> lllllllllllllIllIIlIllIllIllIlII) {
        final Listeners lllllllllllllIllIIlIllIllIllIIll = this.field_192197_b.get(lllllllllllllIllIIlIllIllIllIIIl);
        if (lllllllllllllIllIIlIllIllIllIIll != null) {
            lllllllllllllIllIIlIllIllIllIIll.func_192469_b(lllllllllllllIllIIlIllIllIllIlII);
            if (lllllllllllllIllIIlIllIllIllIIll.func_192470_a()) {
                this.field_192197_b.remove(lllllllllllllIllIIlIllIllIllIIIl);
            }
        }
    }
    
    public void func_192193_a(final EntityPlayerMP lllllllllllllIllIIlIllIllIIIIllI, final IBlockState lllllllllllllIllIIlIllIllIIIIIIl) {
        final Listeners lllllllllllllIllIIlIllIllIIIIlII = this.field_192197_b.get(lllllllllllllIllIIlIllIllIIIIllI.func_192039_O());
        if (lllllllllllllIllIIlIllIllIIIIlII != null) {
            lllllllllllllIllIIlIllIllIIIIlII.func_192471_a(lllllllllllllIllIIlIllIllIIIIIIl);
        }
    }
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIllIIlIllIllIIllllI, final JsonDeserializationContext lllllllllllllIllIIlIllIllIIlllIl) {
        Block lllllllllllllIllIIlIllIllIIlllII = null;
        if (lllllllllllllIllIIlIllIllIIllllI.has("block")) {
            final ResourceLocation lllllllllllllIllIIlIllIllIIllIll = new ResourceLocation(JsonUtils.getString(lllllllllllllIllIIlIllIllIIllllI, "block"));
            if (!Block.REGISTRY.containsKey(lllllllllllllIllIIlIllIllIIllIll)) {
                throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown block type '").append(lllllllllllllIllIIlIllIllIIllIll).append("'")));
            }
            lllllllllllllIllIIlIllIllIIlllII = Block.REGISTRY.getObject(lllllllllllllIllIIlIllIllIIllIll);
        }
        Map<IProperty<?>, Object> lllllllllllllIllIIlIllIllIIllIlI = null;
        if (lllllllllllllIllIIlIllIllIIllllI.has("state")) {
            if (lllllllllllllIllIIlIllIllIIlllII == null) {
                throw new JsonSyntaxException("Can't define block state without a specific block type");
            }
            final BlockStateContainer lllllllllllllIllIIlIllIllIIllIIl = lllllllllllllIllIIlIllIllIIlllII.getBlockState();
            for (final Map.Entry<String, JsonElement> lllllllllllllIllIIlIllIllIIllIII : JsonUtils.getJsonObject(lllllllllllllIllIIlIllIllIIllllI, "state").entrySet()) {
                final IProperty<?> lllllllllllllIllIIlIllIllIIlIlll = lllllllllllllIllIIlIllIllIIllIIl.getProperty(lllllllllllllIllIIlIllIllIIllIII.getKey());
                if (lllllllllllllIllIIlIllIllIIlIlll == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown block state property '").append(lllllllllllllIllIIlIllIllIIllIII.getKey()).append("' for block '").append(Block.REGISTRY.getNameForObject(lllllllllllllIllIIlIllIllIIlllII)).append("'")));
                }
                final String lllllllllllllIllIIlIllIllIIlIllI = JsonUtils.getString(lllllllllllllIllIIlIllIllIIllIII.getValue(), lllllllllllllIllIIlIllIllIIllIII.getKey());
                final Optional<?> lllllllllllllIllIIlIllIllIIlIlIl = lllllllllllllIllIIlIllIllIIlIlll.parseValue(lllllllllllllIllIIlIllIllIIlIllI);
                if (!lllllllllllllIllIIlIllIllIIlIlIl.isPresent()) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid block state value '").append(lllllllllllllIllIIlIllIllIIlIllI).append("' for property '").append(lllllllllllllIllIIlIllIllIIllIII.getKey()).append("' on block '").append(Block.REGISTRY.getNameForObject(lllllllllllllIllIIlIllIllIIlllII)).append("'")));
                }
                if (lllllllllllllIllIIlIllIllIIllIlI == null) {
                    lllllllllllllIllIIlIllIllIIllIlI = (Map<IProperty<?>, Object>)Maps.newHashMap();
                }
                lllllllllllllIllIIlIllIllIIllIlI.put(lllllllllllllIllIIlIllIllIIlIlll, lllllllllllllIllIIlIllIllIIlIlIl.get());
            }
        }
        return new Instance(lllllllllllllIllIIlIllIllIIlllII, lllllllllllllIllIIlIllIllIIllIlI);
    }
    
    public EnterBlockTrigger() {
        this.field_192197_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIllIIlIllIllIlIlIIl) {
        this.field_192197_b.remove(lllllllllllllIllIIlIllIllIlIlIIl);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIllIIlIllIllIllllIl, final Listener<Instance> lllllllllllllIllIIlIllIllIllllII) {
        Listeners lllllllllllllIllIIlIllIllIllllll = this.field_192197_b.get(lllllllllllllIllIIlIllIllIllllIl);
        if (lllllllllllllIllIIlIllIllIllllll == null) {
            lllllllllllllIllIIlIllIllIllllll = new Listeners(lllllllllllllIllIIlIllIllIllllIl);
            this.field_192197_b.put(lllllllllllllIllIIlIllIllIllllIl, lllllllllllllIllIIlIllIllIllllll);
        }
        lllllllllllllIllIIlIllIllIllllll.func_192472_a(lllllllllllllIllIIlIllIllIllllII);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ Block field_192261_a;
        private final /* synthetic */ Map<IProperty<?>, Object> field_192262_b;
        
        public Instance(@Nullable final Block lllllllllllllllIIIlIlllIIIIIIIll, @Nullable final Map<IProperty<?>, Object> lllllllllllllllIIIlIllIlllllllll) {
            super(EnterBlockTrigger.field_192196_a);
            this.field_192261_a = lllllllllllllllIIIlIlllIIIIIIIll;
            this.field_192262_b = lllllllllllllllIIIlIllIlllllllll;
        }
        
        public boolean func_192260_a(final IBlockState lllllllllllllllIIIlIllIlllllIllI) {
            if (this.field_192261_a != null && lllllllllllllllIIIlIllIlllllIllI.getBlock() != this.field_192261_a) {
                return false;
            }
            if (this.field_192262_b != null) {
                for (final Map.Entry<IProperty<?>, Object> lllllllllllllllIIIlIllIllllllIII : this.field_192262_b.entrySet()) {
                    if (lllllllllllllllIIIlIllIlllllIllI.getValue(lllllllllllllllIIIlIllIllllllIII.getKey()) != lllllllllllllllIIIlIllIllllllIII.getValue()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192473_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192474_b;
        
        public boolean func_192470_a() {
            return this.field_192474_b.isEmpty();
        }
        
        public void func_192472_a(final Listener<Instance> lllllllllllllIIIIllIllIlllllIlIl) {
            this.field_192474_b.add(lllllllllllllIIIIllIllIlllllIlIl);
        }
        
        public void func_192469_b(final Listener<Instance> lllllllllllllIIIIllIllIllllIllll) {
            this.field_192474_b.remove(lllllllllllllIIIIllIllIllllIllll);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllIIIIllIllIllllllllI) {
            this.field_192474_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192473_a = lllllllllllllIIIIllIllIllllllllI;
        }
        
        public void func_192471_a(final IBlockState lllllllllllllIIIIllIllIllllIIIll) {
            List<Listener<Instance>> lllllllllllllIIIIllIllIllllIIlll = null;
            for (final Listener<Instance> lllllllllllllIIIIllIllIllllIIllI : this.field_192474_b) {
                if (lllllllllllllIIIIllIllIllllIIllI.func_192158_a().func_192260_a(lllllllllllllIIIIllIllIllllIIIll)) {
                    if (lllllllllllllIIIIllIllIllllIIlll == null) {
                        lllllllllllllIIIIllIllIllllIIlll = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllIIIIllIllIllllIIlll.add(lllllllllllllIIIIllIllIllllIIllI);
                }
            }
            if (lllllllllllllIIIIllIllIllllIIlll != null) {
                for (final Listener<Instance> lllllllllllllIIIIllIllIllllIIlIl : lllllllllllllIIIIllIllIllllIIlll) {
                    lllllllllllllIIIIllIllIllllIIlIl.func_192159_a(this.field_192473_a);
                }
            }
        }
    }
}
