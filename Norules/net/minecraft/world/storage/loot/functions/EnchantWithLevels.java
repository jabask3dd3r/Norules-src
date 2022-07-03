package net.minecraft.world.storage.loot.functions;

import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.enchantment.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class EnchantWithLevels extends LootFunction
{
    private final /* synthetic */ boolean isTreasure;
    private final /* synthetic */ RandomValueRange randomLevel;
    
    public EnchantWithLevels(final LootCondition[] lllllllllllllIllIIIlIlIIIIlIllll, final RandomValueRange lllllllllllllIllIIIlIlIIIIlIlllI, final boolean lllllllllllllIllIIIlIlIIIIlIlIIl) {
        super(lllllllllllllIllIIIlIlIIIIlIllll);
        this.randomLevel = lllllllllllllIllIIIlIlIIIIlIlllI;
        this.isTreasure = lllllllllllllIllIIIlIlIIIIlIlIIl;
    }
    
    @Override
    public ItemStack apply(final ItemStack lllllllllllllIllIIIlIlIIIIlIIIII, final Random lllllllllllllIllIIIlIlIIIIlIIIll, final LootContext lllllllllllllIllIIIlIlIIIIlIIIlI) {
        return EnchantmentHelper.addRandomEnchantment(lllllllllllllIllIIIlIlIIIIlIIIll, lllllllllllllIllIIIlIlIIIIlIIIII, this.randomLevel.generateInt(lllllllllllllIllIIIlIlIIIIlIIIll), this.isTreasure);
    }
    
    public static class Serializer extends LootFunction.Serializer<EnchantWithLevels>
    {
        @Override
        public EnchantWithLevels deserialize(final JsonObject lllllllllllllIlIllIlllIIllIIIlll, final JsonDeserializationContext lllllllllllllIlIllIlllIIllIIlIll, final LootCondition[] lllllllllllllIlIllIlllIIllIIIlIl) {
            final RandomValueRange lllllllllllllIlIllIlllIIllIIlIIl = JsonUtils.deserializeClass(lllllllllllllIlIllIlllIIllIIIlll, "levels", lllllllllllllIlIllIlllIIllIIlIll, (Class<? extends RandomValueRange>)RandomValueRange.class);
            final boolean lllllllllllllIlIllIlllIIllIIlIII = JsonUtils.getBoolean(lllllllllllllIlIllIlllIIllIIIlll, "treasure", false);
            return new EnchantWithLevels(lllllllllllllIlIllIlllIIllIIIlIl, lllllllllllllIlIllIlllIIllIIlIIl, lllllllllllllIlIllIlllIIllIIlIII);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIlIllIlllIIllIlIlIl, final EnchantWithLevels lllllllllllllIlIllIlllIIllIlIlII, final JsonSerializationContext lllllllllllllIlIllIlllIIllIlIllI) {
            lllllllllllllIlIllIlllIIllIlIlIl.add("levels", lllllllllllllIlIllIlllIIllIlIllI.serialize((Object)lllllllllllllIlIllIlllIIllIlIlII.randomLevel));
            lllllllllllllIlIllIlllIIllIlIlIl.addProperty("treasure", Boolean.valueOf(lllllllllllllIlIllIlllIIllIlIlII.isTreasure));
        }
        
        public Serializer() {
            super(new ResourceLocation("enchant_with_levels"), EnchantWithLevels.class);
        }
    }
}
