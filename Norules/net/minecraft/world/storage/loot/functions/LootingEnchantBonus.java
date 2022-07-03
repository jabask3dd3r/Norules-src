package net.minecraft.world.storage.loot.functions;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.world.storage.loot.conditions.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class LootingEnchantBonus extends LootFunction
{
    private final /* synthetic */ int limit;
    private final /* synthetic */ RandomValueRange count;
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllllIlIllllIIIIllllll, final Random lllllllllllllllIlIllllIIIIllIlll, final LootContext lllllllllllllllIlIllllIIIIllllIl) {
        final Entity lllllllllllllllIlIllllIIIIllllII = lllllllllllllllIlIllllIIIIllllIl.getKiller();
        if (lllllllllllllllIlIllllIIIIllllII instanceof EntityLivingBase) {
            final int lllllllllllllllIlIllllIIIIlllIll = EnchantmentHelper.getLootingModifier((EntityLivingBase)lllllllllllllllIlIllllIIIIllllII);
            if (lllllllllllllllIlIllllIIIIlllIll == 0) {
                return lllllllllllllllIlIllllIIIIllllll;
            }
            final float lllllllllllllllIlIllllIIIIlllIlI = lllllllllllllllIlIllllIIIIlllIll * this.count.generateFloat(lllllllllllllllIlIllllIIIIllIlll);
            lllllllllllllllIlIllllIIIIllllll.func_190917_f(Math.round(lllllllllllllllIlIllllIIIIlllIlI));
            if (this.limit != 0 && lllllllllllllllIlIllllIIIIllllll.func_190916_E() > this.limit) {
                lllllllllllllllIlIllllIIIIllllll.func_190920_e(this.limit);
            }
        }
        return lllllllllllllllIlIllllIIIIllllll;
    }
    
    public LootingEnchantBonus(final LootCondition[] lllllllllllllllIlIllllIIIlIIlllI, final RandomValueRange lllllllllllllllIlIllllIIIlIIllIl, final int lllllllllllllllIlIllllIIIlIIlIII) {
        super(lllllllllllllllIlIllllIIIlIIlllI);
        this.count = lllllllllllllllIlIllllIIIlIIllIl;
        this.limit = lllllllllllllllIlIllllIIIlIIlIII;
    }
    
    public static class Serializer extends LootFunction.Serializer<LootingEnchantBonus>
    {
        protected Serializer() {
            super(new ResourceLocation("looting_enchant"), LootingEnchantBonus.class);
        }
        
        @Override
        public void serialize(final JsonObject llllllllllllllIIIIlllIlllIIIIIll, final LootingEnchantBonus llllllllllllllIIIIlllIlllIIIIIlI, final JsonSerializationContext llllllllllllllIIIIlllIllIllllllI) {
            llllllllllllllIIIIlllIlllIIIIIll.add("count", llllllllllllllIIIIlllIllIllllllI.serialize((Object)llllllllllllllIIIIlllIlllIIIIIlI.count));
            if (llllllllllllllIIIIlllIlllIIIIIlI.limit > 0) {
                llllllllllllllIIIIlllIlllIIIIIll.add("limit", llllllllllllllIIIIlllIllIllllllI.serialize((Object)llllllllllllllIIIIlllIlllIIIIIlI.limit));
            }
        }
        
        @Override
        public LootingEnchantBonus deserialize(final JsonObject llllllllllllllIIIIlllIllIllllIII, final JsonDeserializationContext llllllllllllllIIIIlllIllIlllIIll, final LootCondition[] llllllllllllllIIIIlllIllIlllIllI) {
            final int llllllllllllllIIIIlllIllIlllIlIl = JsonUtils.getInt(llllllllllllllIIIIlllIllIllllIII, "limit", 0);
            return new LootingEnchantBonus(llllllllllllllIIIIlllIllIlllIllI, JsonUtils.deserializeClass(llllllllllllllIIIIlllIllIllllIII, "count", llllllllllllllIIIIlllIllIlllIIll, (Class<? extends RandomValueRange>)RandomValueRange.class), llllllllllllllIIIIlllIllIlllIlIl);
        }
    }
}
