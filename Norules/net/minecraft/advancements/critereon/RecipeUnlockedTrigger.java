package net.minecraft.advancements.critereon;

import net.minecraft.advancements.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.item.crafting.*;
import net.minecraft.entity.player.*;
import java.util.*;
import com.google.common.collect.*;

public class RecipeUnlockedTrigger implements ICriterionTrigger<Instance>
{
    private static final /* synthetic */ ResourceLocation field_192227_a;
    private final /* synthetic */ Map<PlayerAdvancements, Listeners> field_192228_b;
    
    @Override
    public Instance func_192166_a(final JsonObject lllllllllllllIIIIlIIlIllIlIlIlll, final JsonDeserializationContext lllllllllllllIIIIlIIlIllIlIlIllI) {
        final ResourceLocation lllllllllllllIIIIlIIlIllIlIlIlIl = new ResourceLocation(JsonUtils.getString(lllllllllllllIIIIlIIlIllIlIlIlll, "recipe"));
        final IRecipe lllllllllllllIIIIlIIlIllIlIlIlII = CraftingManager.func_193373_a(lllllllllllllIIIIlIIlIllIlIlIlIl);
        if (lllllllllllllIIIIlIIlIllIlIlIlII == null) {
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown recipe '").append(lllllllllllllIIIIlIIlIllIlIlIlIl).append("'")));
        }
        return new Instance(lllllllllllllIIIIlIIlIllIlIlIlII);
    }
    
    @Override
    public void func_192165_a(final PlayerAdvancements lllllllllllllIIIIlIIlIllIlllIlII, final Listener<Instance> lllllllllllllIIIIlIIlIllIllIllll) {
        Listeners lllllllllllllIIIIlIIlIllIlllIIlI = this.field_192228_b.get(lllllllllllllIIIIlIIlIllIlllIlII);
        if (lllllllllllllIIIIlIIlIllIlllIIlI == null) {
            lllllllllllllIIIIlIIlIllIlllIIlI = new Listeners(lllllllllllllIIIIlIIlIllIlllIlII);
            this.field_192228_b.put(lllllllllllllIIIIlIIlIllIlllIlII, lllllllllllllIIIIlIIlIllIlllIIlI);
        }
        lllllllllllllIIIIlIIlIllIlllIIlI.func_192528_a(lllllllllllllIIIIlIIlIllIllIllll);
    }
    
    static {
        field_192227_a = new ResourceLocation("recipe_unlocked");
    }
    
    @Override
    public ResourceLocation func_192163_a() {
        return RecipeUnlockedTrigger.field_192227_a;
    }
    
    public void func_192225_a(final EntityPlayerMP lllllllllllllIIIIlIIlIllIlIIlIll, final IRecipe lllllllllllllIIIIlIIlIllIlIIlIlI) {
        final Listeners lllllllllllllIIIIlIIlIllIlIIlIIl = this.field_192228_b.get(lllllllllllllIIIIlIIlIllIlIIlIll.func_192039_O());
        if (lllllllllllllIIIIlIIlIllIlIIlIIl != null) {
            lllllllllllllIIIIlIIlIllIlIIlIIl.func_193493_a(lllllllllllllIIIIlIIlIllIlIIlIlI);
        }
    }
    
    public RecipeUnlockedTrigger() {
        this.field_192228_b = (Map<PlayerAdvancements, Listeners>)Maps.newHashMap();
    }
    
    @Override
    public void func_192164_b(final PlayerAdvancements lllllllllllllIIIIlIIlIllIllIIlII, final Listener<Instance> lllllllllllllIIIIlIIlIllIllIIIll) {
        final Listeners lllllllllllllIIIIlIIlIllIllIIllI = this.field_192228_b.get(lllllllllllllIIIIlIIlIllIllIIlII);
        if (lllllllllllllIIIIlIIlIllIllIIllI != null) {
            lllllllllllllIIIIlIIlIllIllIIllI.func_192525_b(lllllllllllllIIIIlIIlIllIllIIIll);
            if (lllllllllllllIIIIlIIlIllIllIIllI.func_192527_a()) {
                this.field_192228_b.remove(lllllllllllllIIIIlIIlIllIllIIlII);
            }
        }
    }
    
    @Override
    public void func_192167_a(final PlayerAdvancements lllllllllllllIIIIlIIlIllIlIllllI) {
        this.field_192228_b.remove(lllllllllllllIIIIlIIlIllIlIllllI);
    }
    
    static class Listeners
    {
        private final /* synthetic */ PlayerAdvancements field_192529_a;
        private final /* synthetic */ Set<Listener<Instance>> field_192530_b;
        
        public void func_193493_a(final IRecipe lllllllllllllllIIIIIlIIlllIIllll) {
            List<Listener<Instance>> lllllllllllllllIIIIIlIIlllIIlllI = null;
            for (final Listener<Instance> lllllllllllllllIIIIIlIIlllIIllIl : this.field_192530_b) {
                if (lllllllllllllllIIIIIlIIlllIIllIl.func_192158_a().func_193215_a(lllllllllllllllIIIIIlIIlllIIllll)) {
                    if (lllllllllllllllIIIIIlIIlllIIlllI == null) {
                        lllllllllllllllIIIIIlIIlllIIlllI = (List<Listener<Instance>>)Lists.newArrayList();
                    }
                    lllllllllllllllIIIIIlIIlllIIlllI.add(lllllllllllllllIIIIIlIIlllIIllIl);
                }
            }
            if (lllllllllllllllIIIIIlIIlllIIlllI != null) {
                for (final Listener<Instance> lllllllllllllllIIIIIlIIlllIIllII : lllllllllllllllIIIIIlIIlllIIlllI) {
                    lllllllllllllllIIIIIlIIlllIIllII.func_192159_a(this.field_192529_a);
                }
            }
        }
        
        public void func_192525_b(final Listener<Instance> lllllllllllllllIIIIIlIIlllIllIII) {
            this.field_192530_b.remove(lllllllllllllllIIIIIlIIlllIllIII);
        }
        
        public void func_192528_a(final Listener<Instance> lllllllllllllllIIIIIlIIlllIlllII) {
            this.field_192530_b.add(lllllllllllllllIIIIIlIIlllIlllII);
        }
        
        public Listeners(final PlayerAdvancements lllllllllllllllIIIIIlIIllllIIlll) {
            this.field_192530_b = (Set<Listener<Instance>>)Sets.newHashSet();
            this.field_192529_a = lllllllllllllllIIIIIlIIllllIIlll;
        }
        
        public boolean func_192527_a() {
            return this.field_192530_b.isEmpty();
        }
    }
    
    public static class Instance extends AbstractCriterionInstance
    {
        private final /* synthetic */ IRecipe field_192282_a;
        
        public Instance(final IRecipe lllllllllllllIlIlllIlIIIlIlllIll) {
            super(RecipeUnlockedTrigger.field_192227_a);
            this.field_192282_a = lllllllllllllIlIlllIlIIIlIlllIll;
        }
        
        public boolean func_193215_a(final IRecipe lllllllllllllIlIlllIlIIIlIllIlIl) {
            return this.field_192282_a == lllllllllllllIlIlllIlIIIlIllIlIl;
        }
    }
}
