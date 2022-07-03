package net.minecraft.world.storage.loot.functions;

import net.minecraft.world.storage.loot.conditions.*;
import org.apache.logging.log4j.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class Smelt extends LootFunction
{
    private static final /* synthetic */ Logger LOGGER;
    
    public Smelt(final LootCondition[] lllllllllllllIIIIllIIlIllIlIIlll) {
        super(lllllllllllllIIIIllIIlIllIlIIlll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIIIIllIIlIllIlIIIlI, final Random lllllllllllllIIIIllIIlIllIlIIIIl, final LootContext lllllllllllllIIIIllIIlIllIlIIIII) {
        if (lllllllllllllIIIIllIIlIllIlIIIlI.func_190926_b()) {
            return lllllllllllllIIIIllIIlIllIlIIIlI;
        }
        final ItemStack lllllllllllllIIIIllIIlIllIIlllll = FurnaceRecipes.instance().getSmeltingResult(lllllllllllllIIIIllIIlIllIlIIIlI);
        if (lllllllllllllIIIIllIIlIllIIlllll.func_190926_b()) {
            Smelt.LOGGER.warn("Couldn't smelt {} because there is no smelting recipe", (Object)lllllllllllllIIIIllIIlIllIlIIIlI);
            return lllllllllllllIIIIllIIlIllIlIIIlI;
        }
        final ItemStack lllllllllllllIIIIllIIlIllIIllllI = lllllllllllllIIIIllIIlIllIIlllll.copy();
        lllllllllllllIIIIllIIlIllIIllllI.func_190920_e(lllllllllllllIIIIllIIlIllIlIIIlI.func_190916_E());
        return lllllllllllllIIIIllIIlIllIIllllI;
    }
    
    public static class Serializer extends LootFunction.Serializer<Smelt>
    {
        protected Serializer() {
            super(new ResourceLocation("furnace_smelt"), Smelt.class);
        }
        
        @Override
        public Smelt deserialize(final JsonObject lllllllllllllIllllllIllllIIIIIll, final JsonDeserializationContext lllllllllllllIllllllIllllIIIIIlI, final LootCondition[] lllllllllllllIllllllIllllIIIIIII) {
            return new Smelt(lllllllllllllIllllllIllllIIIIIII);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIllllllIllllIIIlIII, final Smelt lllllllllllllIllllllIllllIIIIlll, final JsonSerializationContext lllllllllllllIllllllIllllIIIIllI) {
        }
    }
}
