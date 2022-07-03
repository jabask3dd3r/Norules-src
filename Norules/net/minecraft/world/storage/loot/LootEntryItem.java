package net.minecraft.world.storage.loot;

import net.minecraft.world.storage.loot.functions.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.conditions.*;
import com.google.gson.*;
import net.minecraft.util.*;

public class LootEntryItem extends LootEntry
{
    protected final /* synthetic */ LootFunction[] functions;
    protected final /* synthetic */ Item item;
    
    @Override
    public void addLoot(final Collection<ItemStack> llllllllllllIlllllllIlIIIIlIIlIl, final Random llllllllllllIlllllllIlIIIIlIllII, final LootContext llllllllllllIlllllllIlIIIIlIIIll) {
        ItemStack llllllllllllIlllllllIlIIIIlIlIlI = new ItemStack(this.item);
        final String llllllllllllIlllllllIlIIIIIllllI;
        final Exception llllllllllllIlllllllIlIIIIIlllll = (Exception)((LootFunction[])(Object)(llllllllllllIlllllllIlIIIIIllllI = (String)(Object)this.functions)).length;
        for (long llllllllllllIlllllllIlIIIIlIIIII = 0; llllllllllllIlllllllIlIIIIlIIIII < llllllllllllIlllllllIlIIIIIlllll; ++llllllllllllIlllllllIlIIIIlIIIII) {
            final LootFunction llllllllllllIlllllllIlIIIIlIlIIl = llllllllllllIlllllllIlIIIIIllllI[llllllllllllIlllllllIlIIIIlIIIII];
            if (LootConditionManager.testAllConditions(llllllllllllIlllllllIlIIIIlIlIIl.getConditions(), llllllllllllIlllllllIlIIIIlIllII, llllllllllllIlllllllIlIIIIlIIIll)) {
                llllllllllllIlllllllIlIIIIlIlIlI = llllllllllllIlllllllIlIIIIlIlIIl.apply(llllllllllllIlllllllIlIIIIlIlIlI, llllllllllllIlllllllIlIIIIlIllII, llllllllllllIlllllllIlIIIIlIIIll);
            }
        }
        if (!llllllllllllIlllllllIlIIIIlIlIlI.func_190926_b()) {
            if (llllllllllllIlllllllIlIIIIlIlIlI.func_190916_E() < this.item.getItemStackLimit()) {
                llllllllllllIlllllllIlIIIIlIIlIl.add(llllllllllllIlllllllIlIIIIlIlIlI);
            }
            else {
                int llllllllllllIlllllllIlIIIIlIlIII = llllllllllllIlllllllIlIIIIlIlIlI.func_190916_E();
                while (llllllllllllIlllllllIlIIIIlIlIII > 0) {
                    final ItemStack llllllllllllIlllllllIlIIIIlIIlll = llllllllllllIlllllllIlIIIIlIlIlI.copy();
                    llllllllllllIlllllllIlIIIIlIIlll.func_190920_e(Math.min(llllllllllllIlllllllIlIIIIlIlIlI.getMaxStackSize(), llllllllllllIlllllllIlIIIIlIlIII));
                    llllllllllllIlllllllIlIIIIlIlIII -= llllllllllllIlllllllIlIIIIlIIlll.func_190916_E();
                    llllllllllllIlllllllIlIIIIlIIlIl.add(llllllllllllIlllllllIlIIIIlIIlll);
                }
            }
        }
    }
    
    @Override
    protected void serialize(final JsonObject llllllllllllIlllllllIlIIIIIlIlII, final JsonSerializationContext llllllllllllIlllllllIlIIIIIlIlll) {
        if (this.functions != null && this.functions.length > 0) {
            llllllllllllIlllllllIlIIIIIlIlII.add("functions", llllllllllllIlllllllIlIIIIIlIlll.serialize((Object)this.functions));
        }
        final ResourceLocation llllllllllllIlllllllIlIIIIIlIllI = Item.REGISTRY.getNameForObject(this.item);
        if (llllllllllllIlllllllIlIIIIIlIllI == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Can't serialize unknown item ").append(this.item)));
        }
        llllllllllllIlllllllIlIIIIIlIlII.addProperty("name", llllllllllllIlllllllIlIIIIIlIllI.toString());
    }
    
    public LootEntryItem(final Item llllllllllllIlllllllIlIIIlIIIIlI, final int llllllllllllIlllllllIlIIIIlllIll, final int llllllllllllIlllllllIlIIIlIIIIII, final LootFunction[] llllllllllllIlllllllIlIIIIllllll, final LootCondition[] llllllllllllIlllllllIlIIIIlllllI) {
        super(llllllllllllIlllllllIlIIIIlllIll, llllllllllllIlllllllIlIIIlIIIIII, llllllllllllIlllllllIlIIIIlllllI);
        this.item = llllllllllllIlllllllIlIIIlIIIIlI;
        this.functions = llllllllllllIlllllllIlIIIIllllll;
    }
    
    public static LootEntryItem deserialize(final JsonObject llllllllllllIlllllllIlIIIIIIIIlI, final JsonDeserializationContext llllllllllllIlllllllIlIIIIIIlIIl, final int llllllllllllIlllllllIlIIIIIIlIII, final int llllllllllllIlllllllIIllllllllll, final LootCondition[] llllllllllllIlllllllIIlllllllllI) {
        final Item llllllllllllIlllllllIlIIIIIIIlIl = JsonUtils.getItem(llllllllllllIlllllllIlIIIIIIIIlI, "name");
        LootFunction[] llllllllllllIlllllllIlIIIIIIIIll = null;
        if (llllllllllllIlllllllIlIIIIIIIIlI.has("functions")) {
            final LootFunction[] llllllllllllIlllllllIlIIIIIIIlII = JsonUtils.deserializeClass(llllllllllllIlllllllIlIIIIIIIIlI, "functions", llllllllllllIlllllllIlIIIIIIlIIl, (Class<? extends LootFunction[]>)LootFunction[].class);
        }
        else {
            llllllllllllIlllllllIlIIIIIIIIll = new LootFunction[0];
        }
        return new LootEntryItem(llllllllllllIlllllllIlIIIIIIIlIl, llllllllllllIlllllllIlIIIIIIlIII, llllllllllllIlllllllIIllllllllll, llllllllllllIlllllllIlIIIIIIIIll, llllllllllllIlllllllIIlllllllllI);
    }
}
