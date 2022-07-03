package net.minecraft.world.storage.loot;

import net.minecraft.world.storage.loot.conditions.*;
import com.google.gson.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import java.util.*;

public class LootEntryTable extends LootEntry
{
    protected final /* synthetic */ ResourceLocation table;
    
    @Override
    protected void serialize(final JsonObject llllllllllllllIIIIIlIIIlIIlllllI, final JsonSerializationContext llllllllllllllIIIIIlIIIlIlIIIIIl) {
        llllllllllllllIIIIIlIIIlIIlllllI.addProperty("name", this.table.toString());
    }
    
    public LootEntryTable(final ResourceLocation llllllllllllllIIIIIlIIIllIIIIIIl, final int llllllllllllllIIIIIlIIIlIlllllll, final int llllllllllllllIIIIIlIIIlIlllIlIl, final LootCondition[] llllllllllllllIIIIIlIIIlIlllIlII) {
        super(llllllllllllllIIIIIlIIIlIlllllll, llllllllllllllIIIIIlIIIlIlllIlIl, llllllllllllllIIIIIlIIIlIlllIlII);
        this.table = llllllllllllllIIIIIlIIIllIIIIIIl;
    }
    
    public static LootEntryTable deserialize(final JsonObject llllllllllllllIIIIIlIIIlIIlIlIIl, final JsonDeserializationContext llllllllllllllIIIIIlIIIlIIllIIIl, final int llllllllllllllIIIIIlIIIlIIlIlIII, final int llllllllllllllIIIIIlIIIlIIlIIlll, final LootCondition[] llllllllllllllIIIIIlIIIlIIlIIlIl) {
        final ResourceLocation llllllllllllllIIIIIlIIIlIIlIlIll = new ResourceLocation(JsonUtils.getString(llllllllllllllIIIIIlIIIlIIlIlIIl, "name"));
        return new LootEntryTable(llllllllllllllIIIIIlIIIlIIlIlIll, llllllllllllllIIIIIlIIIlIIlIlIII, llllllllllllllIIIIIlIIIlIIlIIlll, llllllllllllllIIIIIlIIIlIIlIIlIl);
    }
    
    @Override
    public void addLoot(final Collection<ItemStack> llllllllllllllIIIIIlIIIlIlIlIlIl, final Random llllllllllllllIIIIIlIIIlIlIlllII, final LootContext llllllllllllllIIIIIlIIIlIlIllIll) {
        final LootTable llllllllllllllIIIIIlIIIlIlIllIlI = llllllllllllllIIIIIlIIIlIlIllIll.getLootTableManager().getLootTableFromLocation(this.table);
        final Collection<ItemStack> llllllllllllllIIIIIlIIIlIlIllIIl = llllllllllllllIIIIIlIIIlIlIllIlI.generateLootForPools(llllllllllllllIIIIIlIIIlIlIlllII, llllllllllllllIIIIIlIIIlIlIllIll);
        llllllllllllllIIIIIlIIIlIlIlIlIl.addAll(llllllllllllllIIIIIlIIIlIlIllIIl);
    }
}
