package net.minecraft.world.storage.loot;

import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.util.math.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;

public abstract class LootEntry
{
    protected final /* synthetic */ int weight;
    protected final /* synthetic */ LootCondition[] conditions;
    protected final /* synthetic */ int quality;
    
    public abstract void addLoot(final Collection<ItemStack> p0, final Random p1, final LootContext p2);
    
    public int getEffectiveWeight(final float lllllllllllllIIlIllIllIlIllllIII) {
        return Math.max(MathHelper.floor(this.weight + this.quality * lllllllllllllIIlIllIllIlIllllIII), 0);
    }
    
    protected LootEntry(final int lllllllllllllIIlIllIllIllIIIIIII, final int lllllllllllllIIlIllIllIlIlllllll, final LootCondition[] lllllllllllllIIlIllIllIlIllllllI) {
        this.weight = lllllllllllllIIlIllIllIllIIIIIII;
        this.quality = lllllllllllllIIlIllIllIlIlllllll;
        this.conditions = lllllllllllllIIlIllIllIlIllllllI;
    }
    
    protected abstract void serialize(final JsonObject p0, final JsonSerializationContext p1);
    
    public static class Serializer implements JsonDeserializer<LootEntry>, JsonSerializer<LootEntry>
    {
        public LootEntry deserialize(final JsonElement llllllllllllllIIlIlIlIlIllIlIIII, final Type llllllllllllllIIlIlIlIlIllIllIII, final JsonDeserializationContext llllllllllllllIIlIlIlIlIllIIllll) throws JsonParseException {
            final JsonObject llllllllllllllIIlIlIlIlIllIlIllI = JsonUtils.getJsonObject(llllllllllllllIIlIlIlIlIllIlIIII, "loot item");
            final String llllllllllllllIIlIlIlIlIllIlIlIl = JsonUtils.getString(llllllllllllllIIlIlIlIlIllIlIllI, "type");
            final int llllllllllllllIIlIlIlIlIllIlIlII = JsonUtils.getInt(llllllllllllllIIlIlIlIlIllIlIllI, "weight", 1);
            final int llllllllllllllIIlIlIlIlIllIlIIll = JsonUtils.getInt(llllllllllllllIIlIlIlIlIllIlIllI, "quality", 0);
            LootCondition[] llllllllllllllIIlIlIlIlIllIlIIIl = null;
            if (llllllllllllllIIlIlIlIlIllIlIllI.has("conditions")) {
                final LootCondition[] llllllllllllllIIlIlIlIlIllIlIIlI = JsonUtils.deserializeClass(llllllllllllllIIlIlIlIlIllIlIllI, "conditions", llllllllllllllIIlIlIlIlIllIIllll, (Class<? extends LootCondition[]>)LootCondition[].class);
            }
            else {
                llllllllllllllIIlIlIlIlIllIlIIIl = new LootCondition[0];
            }
            if ("item".equals(llllllllllllllIIlIlIlIlIllIlIlIl)) {
                return LootEntryItem.deserialize(llllllllllllllIIlIlIlIlIllIlIllI, llllllllllllllIIlIlIlIlIllIIllll, llllllllllllllIIlIlIlIlIllIlIlII, llllllllllllllIIlIlIlIlIllIlIIll, llllllllllllllIIlIlIlIlIllIlIIIl);
            }
            if ("loot_table".equals(llllllllllllllIIlIlIlIlIllIlIlIl)) {
                return LootEntryTable.deserialize(llllllllllllllIIlIlIlIlIllIlIllI, llllllllllllllIIlIlIlIlIllIIllll, llllllllllllllIIlIlIlIlIllIlIlII, llllllllllllllIIlIlIlIlIllIlIIll, llllllllllllllIIlIlIlIlIllIlIIIl);
            }
            if ("empty".equals(llllllllllllllIIlIlIlIlIllIlIlIl)) {
                return LootEntryEmpty.deserialize(llllllllllllllIIlIlIlIlIllIlIllI, llllllllllllllIIlIlIlIlIllIIllll, llllllllllllllIIlIlIlIlIllIlIlII, llllllllllllllIIlIlIlIlIllIlIIll, llllllllllllllIIlIlIlIlIllIlIIIl);
            }
            throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown loot entry type '").append(llllllllllllllIIlIlIlIlIllIlIlIl).append("'")));
        }
        
        public JsonElement serialize(final LootEntry llllllllllllllIIlIlIlIlIllIIIIIl, final Type llllllllllllllIIlIlIlIlIllIIIlII, final JsonSerializationContext llllllllllllllIIlIlIlIlIllIIIIII) {
            final JsonObject llllllllllllllIIlIlIlIlIllIIIIlI = new JsonObject();
            llllllllllllllIIlIlIlIlIllIIIIlI.addProperty("weight", (Number)llllllllllllllIIlIlIlIlIllIIIIIl.weight);
            llllllllllllllIIlIlIlIlIllIIIIlI.addProperty("quality", (Number)llllllllllllllIIlIlIlIlIllIIIIIl.quality);
            if (llllllllllllllIIlIlIlIlIllIIIIIl.conditions.length > 0) {
                llllllllllllllIIlIlIlIlIllIIIIlI.add("conditions", llllllllllllllIIlIlIlIlIllIIIIII.serialize((Object)llllllllllllllIIlIlIlIlIllIIIIIl.conditions));
            }
            if (llllllllllllllIIlIlIlIlIllIIIIIl instanceof LootEntryItem) {
                llllllllllllllIIlIlIlIlIllIIIIlI.addProperty("type", "item");
            }
            else if (llllllllllllllIIlIlIlIlIllIIIIIl instanceof LootEntryTable) {
                llllllllllllllIIlIlIlIlIllIIIIlI.addProperty("type", "loot_table");
            }
            else {
                if (!(llllllllllllllIIlIlIlIlIllIIIIIl instanceof LootEntryEmpty)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to serialize ").append(llllllllllllllIIlIlIlIlIllIIIIIl)));
                }
                llllllllllllllIIlIlIlIlIllIIIIlI.addProperty("type", "empty");
            }
            llllllllllllllIIlIlIlIlIllIIIIIl.serialize(llllllllllllllIIlIlIlIlIllIIIIlI, llllllllllllllIIlIlIlIlIllIIIIII);
            return (JsonElement)llllllllllllllIIlIlIlIlIllIIIIlI;
        }
    }
}
