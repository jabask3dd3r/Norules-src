package net.minecraft.world.storage.loot.functions;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.math.*;
import net.minecraft.world.storage.loot.conditions.*;
import org.apache.logging.log4j.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class SetDamage extends LootFunction
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ RandomValueRange damageRange;
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIlIlllIlIIlIIIIllIl, final Random lllllllllllllIlIlllIlIIlIIIIIlll, final LootContext lllllllllllllIlIlllIlIIlIIIIlIll) {
        if (lllllllllllllIlIlllIlIIlIIIIllIl.isItemStackDamageable()) {
            final float lllllllllllllIlIlllIlIIlIIIIlIlI = 1.0f - this.damageRange.generateFloat(lllllllllllllIlIlllIlIIlIIIIIlll);
            lllllllllllllIlIlllIlIIlIIIIllIl.setItemDamage(MathHelper.floor(lllllllllllllIlIlllIlIIlIIIIlIlI * lllllllllllllIlIlllIlIIlIIIIllIl.getMaxDamage()));
        }
        else {
            SetDamage.LOGGER.warn("Couldn't set damage of loot item {}", (Object)lllllllllllllIlIlllIlIIlIIIIllIl);
        }
        return lllllllllllllIlIlllIlIIlIIIIllIl;
    }
    
    public SetDamage(final LootCondition[] lllllllllllllIlIlllIlIIlIIIlIlll, final RandomValueRange lllllllllllllIlIlllIlIIlIIIlIIll) {
        super(lllllllllllllIlIlllIlIIlIIIlIlll);
        this.damageRange = lllllllllllllIlIlllIlIIlIIIlIIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public static class Serializer extends LootFunction.Serializer<SetDamage>
    {
        @Override
        public SetDamage deserialize(final JsonObject lllllllllllllIIIllIllllIllIIlIlI, final JsonDeserializationContext lllllllllllllIIIllIllllIllIIIllI, final LootCondition[] lllllllllllllIIIllIllllIllIIIlIl) {
            return new SetDamage(lllllllllllllIIIllIllllIllIIIlIl, JsonUtils.deserializeClass(lllllllllllllIIIllIllllIllIIlIlI, "damage", lllllllllllllIIIllIllllIllIIIllI, (Class<? extends RandomValueRange>)RandomValueRange.class));
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIIIllIllllIllIlIlII, final SetDamage lllllllllllllIIIllIllllIllIlIIII, final JsonSerializationContext lllllllllllllIIIllIllllIllIIllll) {
            lllllllllllllIIIllIllllIllIlIlII.add("damage", lllllllllllllIIIllIllllIllIIllll.serialize((Object)lllllllllllllIIIllIllllIllIlIIII.damageRange));
        }
        
        protected Serializer() {
            super(new ResourceLocation("set_damage"), SetDamage.class);
        }
    }
}
