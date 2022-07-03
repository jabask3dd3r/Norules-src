package net.minecraft.world.storage.loot.conditions;

import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class RandomChanceWithLooting implements LootCondition
{
    private final /* synthetic */ float lootingMultiplier;
    private final /* synthetic */ float chance;
    
    public RandomChanceWithLooting(final float lllllllllllllIlIIIllIIlIIlllIIlI, final float lllllllllllllIlIIIllIIlIIlllIIIl) {
        this.chance = lllllllllllllIlIIIllIIlIIlllIIlI;
        this.lootingMultiplier = lllllllllllllIlIIIllIIlIIlllIIIl;
    }
    
    @Override
    public boolean testCondition(final Random lllllllllllllIlIIIllIIlIIllIIlII, final LootContext lllllllllllllIlIIIllIIlIIllIIIll) {
        int lllllllllllllIlIIIllIIlIIllIIllI = 0;
        if (lllllllllllllIlIIIllIIlIIllIIIll.getKiller() instanceof EntityLivingBase) {
            lllllllllllllIlIIIllIIlIIllIIllI = EnchantmentHelper.getLootingModifier((EntityLivingBase)lllllllllllllIlIIIllIIlIIllIIIll.getKiller());
        }
        return lllllllllllllIlIIIllIIlIIllIIlII.nextFloat() < this.chance + lllllllllllllIlIIIllIIlIIllIIllI * this.lootingMultiplier;
    }
    
    public static class Serializer extends LootCondition.Serializer<RandomChanceWithLooting>
    {
        @Override
        public RandomChanceWithLooting deserialize(final JsonObject lllllllllllllIIlIlIlllIlllllllIl, final JsonDeserializationContext lllllllllllllIIlIlIlllIlllllllII) {
            return new RandomChanceWithLooting(JsonUtils.getFloat(lllllllllllllIIlIlIlllIlllllllIl, "chance"), JsonUtils.getFloat(lllllllllllllIIlIlIlllIlllllllIl, "looting_multiplier"));
        }
        
        protected Serializer() {
            super(new ResourceLocation("random_chance_with_looting"), RandomChanceWithLooting.class);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIIlIlIllllIIIIIIlII, final RandomChanceWithLooting lllllllllllllIIlIlIllllIIIIIIIII, final JsonSerializationContext lllllllllllllIIlIlIllllIIIIIIIlI) {
            lllllllllllllIIlIlIllllIIIIIIlII.addProperty("chance", (Number)lllllllllllllIIlIlIllllIIIIIIIII.chance);
            lllllllllllllIIlIlIllllIIIIIIlII.addProperty("looting_multiplier", (Number)lllllllllllllIIlIlIllllIIIIIIIII.lootingMultiplier);
        }
    }
}
