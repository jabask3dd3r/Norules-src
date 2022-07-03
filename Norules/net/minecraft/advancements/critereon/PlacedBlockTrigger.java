package net.minecraft.advancements.critereon;

import net.minecraft.advancements.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import com.google.gson.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.world.*;
import java.util.*;
import com.google.common.collect.*;

public class PlacedBlockTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_193174_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_193175_b;
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllIIIIIIllllI, final Listener<Instance> lllIIIIIIllIIl) {
        final Listeners lllIIIIIIlllII = this.field_193175_b.get(lllIIIIIIllllI);
        if (lllIIIIIIlllII != null) {
            lllIIIIIIlllII.func_193487_b(lllIIIIIIllIIl);
            if (lllIIIIIIlllII.func_193488_a()) {
                this.field_193175_b.remove(lllIIIIIIllllI);
            }
        }
    }
    
    static {
        field_193174_a = new ResourceLocation("placed_block");
    }
    
    public PlacedBlockTrigger() {
        this.field_193175_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public Instance func_192166_a(final JsonObject llIllllllllIll, final JsonDeserializationContext lllIIIIIIIIllI) {
        Block lllIIIIIIIIlIl = null;
        if (llIllllllllIll.has("block")) {
            final ResourceLocation lllIIIIIIIIlII = new ResourceLocation(JsonUtils.getString(llIllllllllIll, "block"));
            if (!Block.REGISTRY.containsKey(lllIIIIIIIIlII)) {
                throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown block type '").append(lllIIIIIIIIlII).append("'")));
            }
            lllIIIIIIIIlIl = Block.REGISTRY.getObject(lllIIIIIIIIlII);
        }
        Map<IProperty<?>, Object> lllIIIIIIIIIll = null;
        if (llIllllllllIll.has("state")) {
            if (lllIIIIIIIIlIl == null) {
                throw new JsonSyntaxException("Can't define block state without a specific block type");
            }
            final BlockStateContainer lllIIIIIIIIIlI = lllIIIIIIIIlIl.getBlockState();
            for (final Map.Entry<String, JsonElement> lllIIIIIIIIIIl : JsonUtils.getJsonObject(llIllllllllIll, "state").entrySet()) {
                final IProperty<?> lllIIIIIIIIIII = lllIIIIIIIIIlI.getProperty(lllIIIIIIIIIIl.getKey());
                if (lllIIIIIIIIIII == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown block state property '").append(lllIIIIIIIIIIl.getKey()).append("' for block '").append(Block.REGISTRY.getNameForObject(lllIIIIIIIIlIl)).append("'")));
                }
                final String llIlllllllllll = JsonUtils.getString(lllIIIIIIIIIIl.getValue(), lllIIIIIIIIIIl.getKey());
                final Optional<?> llIllllllllllI = lllIIIIIIIIIII.parseValue(llIlllllllllll);
                if (!llIllllllllllI.isPresent()) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Invalid block state value '").append(llIlllllllllll).append("' for property '").append(lllIIIIIIIIIIl.getKey()).append("' on block '").append(Block.REGISTRY.getNameForObject(lllIIIIIIIIlIl)).append("'")));
                }
                if (lllIIIIIIIIIll == null) {
                    lllIIIIIIIIIll = (Map<IProperty<?>, Object>)Maps.newHashMap();
                }
                lllIIIIIIIIIll.put(lllIIIIIIIIIII, llIllllllllllI.get());
            }
        }
        final LocationPredicate llIlllllllllIl = LocationPredicate.func_193454_a(llIllllllllIll.get("location"));
        final ItemPredicate llIlllllllllII = ItemPredicate.func_192492_a(llIllllllllIll.get("item"));
        return new Instance(lllIIIIIIIIlIl, lllIIIIIIIIIll, llIlllllllllIl, llIlllllllllII);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllIIIIIlIlIlI, final Listener<Instance> lllIIIIIlIIlIl) {
        Listeners lllIIIIIlIlIII = this.field_193175_b.get(lllIIIIIlIlIlI);
        if (lllIIIIIlIlIII == null) {
            lllIIIIIlIlIII = new Listeners(lllIIIIIlIlIlI);
            this.field_193175_b.put(lllIIIIIlIlIlI, lllIIIIIlIlIII);
        }
        lllIIIIIlIlIII.func_193490_a(lllIIIIIlIIlIl);
    }
    
    public void func_193173_a(final EntityPlayerMP llIllllllIIlIl, final BlockPos llIllllllIIlII, final ItemStack llIllllllIlIIl) {
        final IBlockState llIllllllIlIII = llIllllllIIlIl.world.getBlockState(llIllllllIIlII);
        final Listeners llIllllllIIlll = this.field_193175_b.get(llIllllllIIlIl.func_192039_O());
        if (llIllllllIIlll != null) {
            llIllllllIIlll.func_193489_a(llIllllllIlIII, llIllllllIIlII, llIllllllIIlIl.getServerWorld(), llIllllllIlIIl);
        }
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return PlacedBlockTrigger.field_193174_a;
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllIIIIIIlIIlI) {
        this.field_193175_b.remove(lllIIIIIIlIIlI);
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ LocationPredicate field_193213_c;
        private final /* synthetic */ Block field_193211_a;
        private final /* synthetic */ ItemPredicate field_193214_d;
        private final /* synthetic */ Map<IProperty<?>, Object> field_193212_b;
        
        public Instance(@Nullable final Block llllllllllllllIIllIIlIIIIlIlIIIl, @Nullable final Map<IProperty<?>, Object> llllllllllllllIIllIIlIIIIlIlIIII, final LocationPredicate llllllllllllllIIllIIlIIIIlIIlIlI, final ItemPredicate llllllllllllllIIllIIlIIIIlIIlllI) {
            super(PlacedBlockTrigger.field_193174_a);
            this.field_193211_a = llllllllllllllIIllIIlIIIIlIlIIIl;
            this.field_193212_b = llllllllllllllIIllIIlIIIIlIlIIII;
            this.field_193213_c = llllllllllllllIIllIIlIIIIlIIlIlI;
            this.field_193214_d = llllllllllllllIIllIIlIIIIlIIlllI;
        }
        
        public boolean func_193210_a(final IBlockState llllllllllllllIIllIIlIIIIIlllIlI, final BlockPos llllllllllllllIIllIIlIIIIIlllIIl, final WorldServer llllllllllllllIIllIIlIIIIIlllIII, final ItemStack llllllllllllllIIllIIlIIIIIllllIl) {
            if (this.field_193211_a != null && llllllllllllllIIllIIlIIIIIlllIlI.getBlock() != this.field_193211_a) {
                return false;
            }
            if (this.field_193212_b != null) {
                for (final Map.Entry<IProperty<?>, Object> llllllllllllllIIllIIlIIIIIllllII : this.field_193212_b.entrySet()) {
                    if (llllllllllllllIIllIIlIIIIIlllIlI.getValue(llllllllllllllIIllIIlIIIIIllllII.getKey()) != llllllllllllllIIllIIlIIIIIllllII.getValue()) {
                        return false;
                    }
                }
            }
            return this.field_193213_c.func_193453_a(llllllllllllllIIllIIlIIIIIlllIII, (float)llllllllllllllIIllIIlIIIIIlllIIl.getX(), (float)llllllllllllllIIllIIlIIIIIlllIIl.getY(), (float)llllllllllllllIIllIIlIIIIIlllIIl.getZ()) && this.field_193214_d.func_192493_a(llllllllllllllIIllIIlIIIIIllllIl);
        }
    }
    
    static class Listeners
    {
        private final /* synthetic */ Set<Listener<Instance>> field_193492_b;
        private final /* synthetic */ PlayerAdvancements field_193491_a;
        
        public void func_193489_a(final IBlockState lllllllllllllllIllIIllIIlllllIIl, final BlockPos lllllllllllllllIllIIllIIllllIIII, final WorldServer lllllllllllllllIllIIllIIllllIlll, final ItemStack lllllllllllllllIllIIllIIllllIllI) {
            List<Listener<Instance>> lllllllllllllllIllIIllIIllllIlIl = null;
            for (final Listener<Instance> lllllllllllllllIllIIllIIllllIlII : this.field_193492_b) {
                if (lllllllllllllllIllIIllIIllllIlII.func_192158_a().func_193210_a(lllllllllllllllIllIIllIIlllllIIl, lllllllllllllllIllIIllIIllllIIII, lllllllllllllllIllIIllIIllllIlll, lllllllllllllllIllIIllIIllllIllI)) {
                    if (lllllllllllllllIllIIllIIllllIlIl == null) {
                        lllllllllllllllIllIIllIIllllIlIl = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIllIIllIIllllIlIl.add(lllllllllllllllIllIIllIIllllIlII);
                }
            }
            if (lllllllllllllllIllIIllIIllllIlIl != null) {
                for (final Listener<Instance> lllllllllllllllIllIIllIIllllIIll : lllllllllllllllIllIIllIIllllIlIl) {
                    lllllllllllllllIllIIllIIllllIIll.func_192159_a(this.field_193491_a);
                }
            }
        }
        
        public boolean func_193488_a() {
            return this.field_193492_b.isEmpty();
        }
        
        public void func_193490_a(final Listener<Instance> lllllllllllllllIllIIllIlIIIIlIll) {
            this.field_193492_b.add(lllllllllllllllIllIIllIlIIIIlIll);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllllIllIIllIlIIIlIlII) {
            this.field_193492_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_193491_a = lllllllllllllllIllIIllIlIIIlIlII;
        }
        
        public void func_193487_b(final Listener<Instance> lllllllllllllllIllIIllIlIIIIIlIl) {
            this.field_193492_b.remove(lllllllllllllllIllIIllIlIIIIIlIl);
        }
    }
}
