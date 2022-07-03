package net.minecraft.world.storage.loot;

import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.util.math.*;
import java.lang.reflect.*;
import org.apache.commons.lang3.*;
import com.google.gson.*;
import net.minecraft.util.*;
import java.util.*;

public class LootPool
{
    private final /* synthetic */ RandomValueRange bonusRolls;
    private final /* synthetic */ RandomValueRange rolls;
    private final /* synthetic */ LootEntry[] lootEntries;
    private final /* synthetic */ LootCondition[] poolConditions;
    
    protected void createLootRoll(final Collection<ItemStack> llllllllllllllllIIlIlIIIlIIIllII, final Random llllllllllllllllIIlIlIIIlIIlIlIl, final LootContext llllllllllllllllIIlIlIIIlIIIlIlI) {
        final List<LootEntry> llllllllllllllllIIlIlIIIlIIlIIll = (List<LootEntry>)Lists.newArrayList();
        int llllllllllllllllIIlIlIIIlIIlIIlI = 0;
        final byte llllllllllllllllIIlIlIIIlIIIIlII;
        long llllllllllllllllIIlIlIIIlIIIIlIl = ((LootEntry[])(Object)(llllllllllllllllIIlIlIIIlIIIIlII = (byte)(Object)this.lootEntries)).length;
        for (final LootEntry llllllllllllllllIIlIlIIIlIIlIIIl : llllllllllllllllIIlIlIIIlIIIIlII) {
            if (LootConditionManager.testAllConditions(llllllllllllllllIIlIlIIIlIIlIIIl.conditions, llllllllllllllllIIlIlIIIlIIlIlIl, llllllllllllllllIIlIlIIIlIIIlIlI)) {
                final int llllllllllllllllIIlIlIIIlIIlIIII = llllllllllllllllIIlIlIIIlIIlIIIl.getEffectiveWeight(llllllllllllllllIIlIlIIIlIIIlIlI.getLuck());
                if (llllllllllllllllIIlIlIIIlIIlIIII > 0) {
                    llllllllllllllllIIlIlIIIlIIlIIll.add(llllllllllllllllIIlIlIIIlIIlIIIl);
                    llllllllllllllllIIlIlIIIlIIlIIlI += llllllllllllllllIIlIlIIIlIIlIIII;
                }
            }
        }
        if (llllllllllllllllIIlIlIIIlIIlIIlI != 0 && !llllllllllllllllIIlIlIIIlIIlIIll.isEmpty()) {
            int llllllllllllllllIIlIlIIIlIIIllll = llllllllllllllllIIlIlIIIlIIlIlIl.nextInt(llllllllllllllllIIlIlIIIlIIlIIlI);
            llllllllllllllllIIlIlIIIlIIIIlIl = (long)llllllllllllllllIIlIlIIIlIIlIIll.iterator();
            while (((Iterator)llllllllllllllllIIlIlIIIlIIIIlIl).hasNext()) {
                final LootEntry llllllllllllllllIIlIlIIIlIIIlllI = ((Iterator<LootEntry>)llllllllllllllllIIlIlIIIlIIIIlIl).next();
                llllllllllllllllIIlIlIIIlIIIllll -= llllllllllllllllIIlIlIIIlIIIlllI.getEffectiveWeight(llllllllllllllllIIlIlIIIlIIIlIlI.getLuck());
                if (llllllllllllllllIIlIlIIIlIIIllll < 0) {
                    llllllllllllllllIIlIlIIIlIIIlllI.addLoot(llllllllllllllllIIlIlIIIlIIIllII, llllllllllllllllIIlIlIIIlIIlIlIl, llllllllllllllllIIlIlIIIlIIIlIlI);
                }
            }
        }
    }
    
    public void generateLoot(final Collection<ItemStack> llllllllllllllllIIlIlIIIIllllIll, final Random llllllllllllllllIIlIlIIIIlllIlII, final LootContext llllllllllllllllIIlIlIIIIlllIIll) {
        if (LootConditionManager.testAllConditions(this.poolConditions, llllllllllllllllIIlIlIIIIlllIlII, llllllllllllllllIIlIlIIIIlllIIll)) {
            for (int llllllllllllllllIIlIlIIIIllllIII = this.rolls.generateInt(llllllllllllllllIIlIlIIIIlllIlII) + MathHelper.floor(this.bonusRolls.generateFloat(llllllllllllllllIIlIlIIIIlllIlII) * llllllllllllllllIIlIlIIIIlllIIll.getLuck()), llllllllllllllllIIlIlIIIIlllIlll = 0; llllllllllllllllIIlIlIIIIlllIlll < llllllllllllllllIIlIlIIIIllllIII; ++llllllllllllllllIIlIlIIIIlllIlll) {
                this.createLootRoll(llllllllllllllllIIlIlIIIIllllIll, llllllllllllllllIIlIlIIIIlllIlII, llllllllllllllllIIlIlIIIIlllIIll);
            }
        }
    }
    
    public LootPool(final LootEntry[] llllllllllllllllIIlIlIIIlIlIIllI, final LootCondition[] llllllllllllllllIIlIlIIIlIlIIlIl, final RandomValueRange llllllllllllllllIIlIlIIIlIlIIlII, final RandomValueRange llllllllllllllllIIlIlIIIlIlIlIII) {
        this.lootEntries = llllllllllllllllIIlIlIIIlIlIIllI;
        this.poolConditions = llllllllllllllllIIlIlIIIlIlIIlIl;
        this.rolls = llllllllllllllllIIlIlIIIlIlIIlII;
        this.bonusRolls = llllllllllllllllIIlIlIIIlIlIlIII;
    }
    
    public static class Serializer implements JsonDeserializer<LootPool>, JsonSerializer<LootPool>
    {
        public JsonElement serialize(final LootPool lllllllllllllllllllllIllIllIlIll, final Type lllllllllllllllllllllIllIllIlllI, final JsonSerializationContext lllllllllllllllllllllIllIllIllIl) {
            final JsonObject lllllllllllllllllllllIllIllIllII = new JsonObject();
            lllllllllllllllllllllIllIllIllII.add("entries", lllllllllllllllllllllIllIllIllIl.serialize((Object)lllllllllllllllllllllIllIllIlIll.lootEntries));
            lllllllllllllllllllllIllIllIllII.add("rolls", lllllllllllllllllllllIllIllIllIl.serialize((Object)lllllllllllllllllllllIllIllIlIll.rolls));
            if (lllllllllllllllllllllIllIllIlIll.bonusRolls.getMin() != 0.0f && lllllllllllllllllllllIllIllIlIll.bonusRolls.getMax() != 0.0f) {
                lllllllllllllllllllllIllIllIllII.add("bonus_rolls", lllllllllllllllllllllIllIllIllIl.serialize((Object)lllllllllllllllllllllIllIllIlIll.bonusRolls));
            }
            if (!ArrayUtils.isEmpty((Object[])lllllllllllllllllllllIllIllIlIll.poolConditions)) {
                lllllllllllllllllllllIllIllIllII.add("conditions", lllllllllllllllllllllIllIllIllIl.serialize((Object)lllllllllllllllllllllIllIllIlIll.poolConditions));
            }
            return (JsonElement)lllllllllllllllllllllIllIllIllII;
        }
        
        public LootPool deserialize(final JsonElement lllllllllllllllllllllIllIllllIlI, final Type lllllllllllllllllllllIlllIIIIIIl, final JsonDeserializationContext lllllllllllllllllllllIllIllllIIl) throws JsonParseException {
            final JsonObject lllllllllllllllllllllIllIlllllll = JsonUtils.getJsonObject(lllllllllllllllllllllIllIllllIlI, "loot pool");
            final LootEntry[] lllllllllllllllllllllIllIllllllI = JsonUtils.deserializeClass(lllllllllllllllllllllIllIlllllll, "entries", lllllllllllllllllllllIllIllllIIl, (Class<? extends LootEntry[]>)LootEntry[].class);
            final LootCondition[] lllllllllllllllllllllIllIlllllIl = JsonUtils.deserializeClass(lllllllllllllllllllllIllIlllllll, "conditions", new LootCondition[0], lllllllllllllllllllllIllIllllIIl, LootCondition[].class);
            final RandomValueRange lllllllllllllllllllllIllIlllllII = JsonUtils.deserializeClass(lllllllllllllllllllllIllIlllllll, "rolls", lllllllllllllllllllllIllIllllIIl, (Class<? extends RandomValueRange>)RandomValueRange.class);
            final RandomValueRange lllllllllllllllllllllIllIllllIll = JsonUtils.deserializeClass(lllllllllllllllllllllIllIlllllll, "bonus_rolls", new RandomValueRange(0.0f, 0.0f), lllllllllllllllllllllIllIllllIIl, RandomValueRange.class);
            return new LootPool(lllllllllllllllllllllIllIllllllI, lllllllllllllllllllllIllIlllllIl, lllllllllllllllllllllIllIlllllII, lllllllllllllllllllllIllIllllIll);
        }
    }
}
