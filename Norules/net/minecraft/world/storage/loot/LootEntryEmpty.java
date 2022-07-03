package net.minecraft.world.storage.loot;

import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.item.*;
import java.util.*;
import com.google.gson.*;

public class LootEntryEmpty extends LootEntry
{
    public LootEntryEmpty(final int lllllllllllllIIlIIlIlIIIIIlIIIII, final int lllllllllllllIIlIIlIlIIIIIIllIll, final LootCondition[] lllllllllllllIIlIIlIlIIIIIIllIlI) {
        super(lllllllllllllIIlIIlIlIIIIIlIIIII, lllllllllllllIIlIIlIlIIIIIIllIll, lllllllllllllIIlIIlIlIIIIIIllIlI);
    }
    
    @Override
    public void addLoot(final Collection<ItemStack> lllllllllllllIIlIIlIlIIIIIIllIII, final Random lllllllllllllIIlIIlIlIIIIIIlIlll, final LootContext lllllllllllllIIlIIlIlIIIIIIlIllI) {
    }
    
    @Override
    protected void serialize(final JsonObject lllllllllllllIIlIIlIlIIIIIIlIlII, final JsonSerializationContext lllllllllllllIIlIIlIlIIIIIIlIIll) {
    }
    
    public static LootEntryEmpty deserialize(final JsonObject lllllllllllllIIlIIlIlIIIIIIIllll, final JsonDeserializationContext lllllllllllllIIlIIlIlIIIIIIIlllI, final int lllllllllllllIIlIIlIlIIIIIIIlIlI, final int lllllllllllllIIlIIlIlIIIIIIIllII, final LootCondition[] lllllllllllllIIlIIlIlIIIIIIIlIll) {
        return new LootEntryEmpty(lllllllllllllIIlIIlIlIIIIIIIlIlI, lllllllllllllIIlIIlIlIIIIIIIllII, lllllllllllllIIlIIlIlIIIIIIIlIll);
    }
}
