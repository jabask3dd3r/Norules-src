package net.minecraft.world.storage.loot.functions;

import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import org.apache.logging.log4j.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class SetMetadata extends LootFunction
{
    private final /* synthetic */ RandomValueRange metaRange;
    private static final /* synthetic */ Logger LOGGER;
    
    public SetMetadata(final LootCondition[] lllllllllllllIllIIIIllllIIlIIlII, final RandomValueRange lllllllllllllIllIIIIllllIIlIIIll) {
        super(lllllllllllllIllIIIIllllIIlIIlII);
        this.metaRange = lllllllllllllIllIIIIllllIIlIIIll;
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIllIIIIllllIIIllllI, final Random lllllllllllllIllIIIIllllIIIllIIl, final LootContext lllllllllllllIllIIIIllllIIIlllII) {
        if (lllllllllllllIllIIIIllllIIIllllI.isItemStackDamageable()) {
            SetMetadata.LOGGER.warn("Couldn't set data of loot item {}", (Object)lllllllllllllIllIIIIllllIIIllllI);
        }
        else {
            lllllllllllllIllIIIIllllIIIllllI.setItemDamage(this.metaRange.generateInt(lllllllllllllIllIIIIllllIIIllIIl));
        }
        return lllllllllllllIllIIIIllllIIIllllI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public static class Serializer extends LootFunction.Serializer<SetMetadata>
    {
        @Override
        public SetMetadata deserialize(final JsonObject lllllllllllllllIlIlllllIIIlIIIlI, final JsonDeserializationContext lllllllllllllllIlIlllllIIIlIIlII, final LootCondition[] lllllllllllllllIlIlllllIIIlIIIll) {
            return new SetMetadata(lllllllllllllllIlIlllllIIIlIIIll, JsonUtils.deserializeClass(lllllllllllllllIlIlllllIIIlIIIlI, "data", lllllllllllllllIlIlllllIIIlIIlII, (Class<? extends RandomValueRange>)RandomValueRange.class));
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllllIlIlllllIIIlIllll, final SetMetadata lllllllllllllllIlIlllllIIIlIlIll, final JsonSerializationContext lllllllllllllllIlIlllllIIIlIlIlI) {
            lllllllllllllllIlIlllllIIIlIllll.add("data", lllllllllllllllIlIlllllIIIlIlIlI.serialize((Object)lllllllllllllllIlIlllllIIIlIlIll.metaRange));
        }
        
        protected Serializer() {
            super(new ResourceLocation("set_data"), SetMetadata.class);
        }
    }
}
