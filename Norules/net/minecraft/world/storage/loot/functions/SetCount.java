package net.minecraft.world.storage.loot.functions;

import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class SetCount extends LootFunction
{
    private final /* synthetic */ RandomValueRange countRange;
    
    public SetCount(final LootCondition[] lllllllllllllIIIIIllllIlllIIllIl, final RandomValueRange lllllllllllllIIIIIllllIlllIIllll) {
        super(lllllllllllllIIIIIllllIlllIIllIl);
        this.countRange = lllllllllllllIIIIIllllIlllIIllll;
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIIIIIllllIlllIIIlll, final Random lllllllllllllIIIIIllllIlllIIIllI, final LootContext lllllllllllllIIIIIllllIlllIIIlIl) {
        lllllllllllllIIIIIllllIlllIIIlll.func_190920_e(this.countRange.generateInt(lllllllllllllIIIIIllllIlllIIIllI));
        return lllllllllllllIIIIIllllIlllIIIlll;
    }
    
    public static class Serializer extends LootFunction.Serializer<SetCount>
    {
        protected Serializer() {
            super(new ResourceLocation("set_count"), SetCount.class);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIIlllIllIIIlIIIIlll, final SetCount lllllllllllllIIlllIllIIIlIIIIllI, final JsonSerializationContext lllllllllllllIIlllIllIIIlIIIIlIl) {
            lllllllllllllIIlllIllIIIlIIIIlll.add("count", lllllllllllllIIlllIllIIIlIIIIlIl.serialize((Object)lllllllllllllIIlllIllIIIlIIIIllI.countRange));
        }
        
        @Override
        public SetCount deserialize(final JsonObject lllllllllllllIIlllIllIIIIlllllIl, final JsonDeserializationContext lllllllllllllIIlllIllIIIIlllllII, final LootCondition[] lllllllllllllIIlllIllIIIIllllllI) {
            return new SetCount(lllllllllllllIIlllIllIIIIllllllI, JsonUtils.deserializeClass(lllllllllllllIIlllIllIIIIlllllIl, "count", lllllllllllllIIlllIllIIIIlllllII, (Class<? extends RandomValueRange>)RandomValueRange.class));
        }
    }
}
