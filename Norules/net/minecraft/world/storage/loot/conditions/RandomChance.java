package net.minecraft.world.storage.loot.conditions;

import java.util.*;
import net.minecraft.world.storage.loot.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class RandomChance implements LootCondition
{
    private final /* synthetic */ float chance;
    
    @Override
    public boolean testCondition(final Random llllllllllllllIlIlIlllllIlIIIllI, final LootContext llllllllllllllIlIlIlllllIlIIIlIl) {
        return llllllllllllllIlIlIlllllIlIIIllI.nextFloat() < this.chance;
    }
    
    public RandomChance(final float llllllllllllllIlIlIlllllIlIIllII) {
        this.chance = llllllllllllllIlIlIlllllIlIIllII;
    }
    
    public static class Serializer extends LootCondition.Serializer<RandomChance>
    {
        @Override
        public void serialize(final JsonObject lllllllllllllIlIIlllIIlIllIIIIIl, final RandomChance lllllllllllllIlIIlllIIlIllIIIIll, final JsonSerializationContext lllllllllllllIlIIlllIIlIllIIIIlI) {
            lllllllllllllIlIIlllIIlIllIIIIIl.addProperty("chance", (Number)lllllllllllllIlIIlllIIlIllIIIIll.chance);
        }
        
        protected Serializer() {
            super(new ResourceLocation("random_chance"), RandomChance.class);
        }
        
        @Override
        public RandomChance deserialize(final JsonObject lllllllllllllIlIIlllIIlIlIlllIll, final JsonDeserializationContext lllllllllllllIlIIlllIIlIlIllllII) {
            return new RandomChance(JsonUtils.getFloat(lllllllllllllIlIIlllIIlIlIlllIll, "chance"));
        }
    }
}
