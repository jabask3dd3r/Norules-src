package net.minecraft.world.storage.loot;

import net.minecraft.inventory.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.math.*;
import java.util.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class LootTable
{
    private final /* synthetic */ LootPool[] pools;
    private static final /* synthetic */ Logger LOGGER;
    
    public LootTable(final LootPool[] lllllllllllllllllllIIllllIIIllll) {
        this.pools = lllllllllllllllllllIIllllIIIllll;
    }
    
    public void fillInventory(final IInventory lllllllllllllllllllIIlllIllIlIIl, final Random lllllllllllllllllllIIlllIllIlIII, final LootContext lllllllllllllllllllIIlllIllIIlll) {
        final List<ItemStack> lllllllllllllllllllIIlllIllIllIl = this.generateLootForPools(lllllllllllllllllllIIlllIllIlIII, lllllllllllllllllllIIlllIllIIlll);
        final List<Integer> lllllllllllllllllllIIlllIllIllII = this.getEmptySlotsRandomized(lllllllllllllllllllIIlllIllIlIIl, lllllllllllllllllllIIlllIllIlIII);
        this.shuffleItems(lllllllllllllllllllIIlllIllIllIl, lllllllllllllllllllIIlllIllIllII.size(), lllllllllllllllllllIIlllIllIlIII);
        for (final ItemStack lllllllllllllllllllIIlllIllIlIll : lllllllllllllllllllIIlllIllIllIl) {
            if (lllllllllllllllllllIIlllIllIllII.isEmpty()) {
                LootTable.LOGGER.warn("Tried to over-fill a container");
                return;
            }
            if (lllllllllllllllllllIIlllIllIlIll.func_190926_b()) {
                lllllllllllllllllllIIlllIllIlIIl.setInventorySlotContents(lllllllllllllllllllIIlllIllIllII.remove(lllllllllllllllllllIIlllIllIllII.size() - 1), ItemStack.field_190927_a);
            }
            else {
                lllllllllllllllllllIIlllIllIlIIl.setInventorySlotContents(lllllllllllllllllllIIlllIllIllII.remove(lllllllllllllllllllIIlllIllIllII.size() - 1), lllllllllllllllllllIIlllIllIlIll);
            }
        }
    }
    
    public List<ItemStack> generateLootForPools(final Random lllllllllllllllllllIIllllIIIIIII, final LootContext lllllllllllllllllllIIlllIlllllll) {
        final List<ItemStack> lllllllllllllllllllIIllllIIIIIll = (List<ItemStack>)Lists.newArrayList();
        if (lllllllllllllllllllIIlllIlllllll.addLootTable(this)) {
            final short lllllllllllllllllllIIlllIllllIlI;
            final Exception lllllllllllllllllllIIlllIllllIll = (Exception)((LootPool[])(Object)(lllllllllllllllllllIIlllIllllIlI = (short)(Object)this.pools)).length;
            for (final LootPool lllllllllllllllllllIIllllIIIIIlI : lllllllllllllllllllIIlllIllllIlI) {
                lllllllllllllllllllIIllllIIIIIlI.generateLoot(lllllllllllllllllllIIllllIIIIIll, lllllllllllllllllllIIllllIIIIIII, lllllllllllllllllllIIlllIlllllll);
            }
            lllllllllllllllllllIIlllIlllllll.removeLootTable(this);
        }
        else {
            LootTable.LOGGER.warn("Detected infinite loop in loot tables");
        }
        return lllllllllllllllllllIIllllIIIIIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        EMPTY_LOOT_TABLE = new LootTable(new LootPool[0]);
    }
    
    private void shuffleItems(final List<ItemStack> lllllllllllllllllllIIlllIlIlIIII, int lllllllllllllllllllIIlllIlIIllll, final Random lllllllllllllllllllIIlllIlIlIlll) {
        final List<ItemStack> lllllllllllllllllllIIlllIlIlIllI = (List<ItemStack>)Lists.newArrayList();
        final Iterator<ItemStack> lllllllllllllllllllIIlllIlIlIlIl = lllllllllllllllllllIIlllIlIlIIII.iterator();
        while (lllllllllllllllllllIIlllIlIlIlIl.hasNext()) {
            final ItemStack lllllllllllllllllllIIlllIlIlIlII = lllllllllllllllllllIIlllIlIlIlIl.next();
            if (lllllllllllllllllllIIlllIlIlIlII.func_190926_b()) {
                lllllllllllllllllllIIlllIlIlIlIl.remove();
            }
            else {
                if (lllllllllllllllllllIIlllIlIlIlII.func_190916_E() <= 1) {
                    continue;
                }
                lllllllllllllllllllIIlllIlIlIllI.add(lllllllllllllllllllIIlllIlIlIlII);
                lllllllllllllllllllIIlllIlIlIlIl.remove();
            }
        }
        lllllllllllllllllllIIlllIlIIllll -= lllllllllllllllllllIIlllIlIlIIII.size();
        while (lllllllllllllllllllIIlllIlIIllll > 0 && !lllllllllllllllllllIIlllIlIlIllI.isEmpty()) {
            final ItemStack lllllllllllllllllllIIlllIlIlIIll = lllllllllllllllllllIIlllIlIlIllI.remove(MathHelper.getInt(lllllllllllllllllllIIlllIlIlIlll, 0, lllllllllllllllllllIIlllIlIlIllI.size() - 1));
            final int lllllllllllllllllllIIlllIlIlIIlI = MathHelper.getInt(lllllllllllllllllllIIlllIlIlIlll, 1, lllllllllllllllllllIIlllIlIlIIll.func_190916_E() / 2);
            final ItemStack lllllllllllllllllllIIlllIlIlIIIl = lllllllllllllllllllIIlllIlIlIIll.splitStack(lllllllllllllllllllIIlllIlIlIIlI);
            if (lllllllllllllllllllIIlllIlIlIIll.func_190916_E() > 1 && lllllllllllllllllllIIlllIlIlIlll.nextBoolean()) {
                lllllllllllllllllllIIlllIlIlIllI.add(lllllllllllllllllllIIlllIlIlIIll);
            }
            else {
                lllllllllllllllllllIIlllIlIlIIII.add(lllllllllllllllllllIIlllIlIlIIll);
            }
            if (lllllllllllllllllllIIlllIlIlIIIl.func_190916_E() > 1 && lllllllllllllllllllIIlllIlIlIlll.nextBoolean()) {
                lllllllllllllllllllIIlllIlIlIllI.add(lllllllllllllllllllIIlllIlIlIIIl);
            }
            else {
                lllllllllllllllllllIIlllIlIlIIII.add(lllllllllllllllllllIIlllIlIlIIIl);
            }
        }
        lllllllllllllllllllIIlllIlIlIIII.addAll(lllllllllllllllllllIIlllIlIlIllI);
        Collections.shuffle(lllllllllllllllllllIIlllIlIlIIII, lllllllllllllllllllIIlllIlIlIlll);
    }
    
    private List<Integer> getEmptySlotsRandomized(final IInventory lllllllllllllllllllIIlllIlIIIIll, final Random lllllllllllllllllllIIlllIlIIIIlI) {
        final List<Integer> lllllllllllllllllllIIlllIlIIIIIl = (List<Integer>)Lists.newArrayList();
        for (int lllllllllllllllllllIIlllIlIIIIII = 0; lllllllllllllllllllIIlllIlIIIIII < lllllllllllllllllllIIlllIlIIIIll.getSizeInventory(); ++lllllllllllllllllllIIlllIlIIIIII) {
            if (lllllllllllllllllllIIlllIlIIIIll.getStackInSlot(lllllllllllllllllllIIlllIlIIIIII).func_190926_b()) {
                lllllllllllllllllllIIlllIlIIIIIl.add(lllllllllllllllllllIIlllIlIIIIII);
            }
        }
        Collections.shuffle(lllllllllllllllllllIIlllIlIIIIIl, lllllllllllllllllllIIlllIlIIIIlI);
        return lllllllllllllllllllIIlllIlIIIIIl;
    }
    
    public static class Serializer implements JsonDeserializer<LootTable>, JsonSerializer<LootTable>
    {
        public LootTable deserialize(final JsonElement llllllllllllllIllllIIllIIllIllll, final Type llllllllllllllIllllIIllIIlllIIll, final JsonDeserializationContext llllllllllllllIllllIIllIIllIlllI) throws JsonParseException {
            final JsonObject llllllllllllllIllllIIllIIlllIIIl = JsonUtils.getJsonObject(llllllllllllllIllllIIllIIllIllll, "loot table");
            final LootPool[] llllllllllllllIllllIIllIIlllIIII = JsonUtils.deserializeClass(llllllllllllllIllllIIllIIlllIIIl, "pools", new LootPool[0], llllllllllllllIllllIIllIIllIlllI, LootPool[].class);
            return new LootTable(llllllllllllllIllllIIllIIlllIIII);
        }
        
        public JsonElement serialize(final LootTable llllllllllllllIllllIIllIIllIIIll, final Type llllllllllllllIllllIIllIIllIIllI, final JsonSerializationContext llllllllllllllIllllIIllIIllIIlIl) {
            final JsonObject llllllllllllllIllllIIllIIllIIlII = new JsonObject();
            llllllllllllllIllllIIllIIllIIlII.add("pools", llllllllllllllIllllIIllIIllIIlIl.serialize((Object)llllllllllllllIllllIIllIIllIIIll.pools));
            return (JsonElement)llllllllllllllIllllIIllIIllIIlII;
        }
    }
}
